package com.sparta.todolist.service;

import com.sparta.todolist.dto.TodoRequestDto;
import com.sparta.todolist.dto.TodoResponseDto;
import com.sparta.todolist.entity.Todo;
import com.sparta.todolist.exception.InvalidPasswordException;
import com.sparta.todolist.exception.TodoNotFoundException;
import com.sparta.todolist.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public TodoResponseDto createTodo(TodoRequestDto requestDto) {
        // RequestDto -> Entity
        Todo todo = new Todo(requestDto);

        // DB 저장
        Todo saveTodo = todoRepository.save(todo);

        return new TodoResponseDto(saveTodo);
    }


    public List<TodoResponseDto> getTodos() {
        // DB 조회
        return todoRepository.findAllByOrderByCreatedAtDesc().stream()
                .map(TodoResponseDto::new)
                .toList();
    }

    @Transactional
    public Long updateTodo(Long id, TodoRequestDto requestDto) {

        // 해당 메모가 DB에 존재하는지 확인
        Todo todo = getTodo(id);

        // 비밀번호 확인
        validatePassword(todo.getPassword(), requestDto.getPassword());

        // 수정
        todo.update(requestDto);

        return id;
    }

    public Long deleteTodo(Long id, String password) {
        // 해당 메모가 DB에 존재하는지 확인
        Todo todo = getTodo(id);

        // 비밀번호 확인
        validatePassword(todo.getPassword(), password);

        // 삭제
        todoRepository.delete(todo);

        return id;
    }


    public Todo getTodo(Long id) {
        return todoRepository.findById(id).orElseThrow(() ->
                new TodoNotFoundException("일정이 존재하지 않습니다.")
        );
    }

    private void validatePassword(String actualPassword, String enteredPassword) {
        if (!actualPassword.equals(enteredPassword)) {
            throw new InvalidPasswordException("비밀번호가 일치하지 않습니다.");
        }
    }
}
