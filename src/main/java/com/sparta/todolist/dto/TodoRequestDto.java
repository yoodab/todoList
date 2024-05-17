package com.sparta.todolist.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoRequestDto {
    @NotBlank(message = "할일 제목은 필수입니다.")
    @Size(max = 200, message = "할일 제목은 최대 200자 이내여야 합니다.")
    private String title;
    private String content;
    @Email(message = "담당자는 이메일 형식이어야 합니다.")
    private String manager;
    @NotBlank(message = "비밀번호는 필수입니다.")
    private String password;
}

