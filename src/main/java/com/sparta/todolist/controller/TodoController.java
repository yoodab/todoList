package com.sparta.todolist.controller;

import com.sparta.todolist.dto.TodoRequestDto;
import com.sparta.todolist.dto.TodoResponseDto;
import com.sparta.todolist.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/todos")
    public TodoResponseDto createTodo(@Valid @RequestBody TodoRequestDto requestDto) {
        return todoService.createTodo(requestDto);
    }

    @GetMapping("/todo/{id}")
    public TodoResponseDto getTodos(@PathVariable Long id) {
        return new TodoResponseDto(todoService.getTodo(id));
    }

    @GetMapping("/todos")
    public List<TodoResponseDto> getTodos() {
        return todoService.getTodos();
    }

    @PutMapping("/todos/{id}")
    public Long updateTodo(@PathVariable Long id,@Valid @RequestBody TodoRequestDto requestDto) {
        return todoService.updateTodo(id, requestDto);
    }

    @DeleteMapping("/todos/{id}")
    public Long deleteTodo(@PathVariable Long id, @RequestHeader(required = false) String password) {
        return todoService.deleteTodo(id,password);
    }


}
