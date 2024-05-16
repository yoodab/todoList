package com.sparta.todolist.dto;

import com.sparta.todolist.entity.Todo;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoResponseDto {

    private Long id;

    private String title;

    private String content;
    private String manager;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;



    public TodoResponseDto(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.content = todo.getContent();
        this.manager = todo.getManager();
        this.createdAt = todo.getCreatedAt();
        this.modifiedAt = todo.getModifiedAt();
    }
}


