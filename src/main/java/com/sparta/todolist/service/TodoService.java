package com.sparta.todolist.service;

import com.sparta.todolist.dto.TodoRequestDto;
import com.sparta.todolist.dto.TodoResponseDto;
import com.sparta.todolist.entity.Todo;
import com.sparta.todolist.repository.TodoRepository;
import org.springframework.stereotype.Service;

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

    public Todo getTodo(Long id) {
        return todoRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 일정은 존재하지 않습니다.")
        );
    }
}
