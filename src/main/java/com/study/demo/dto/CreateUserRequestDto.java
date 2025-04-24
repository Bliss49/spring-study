package com.study.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateUserRequestDto {
    @NotBlank
    private String id;

    @NotBlank
    private String email;

    private boolean status;

    private String note;

    @NotBlank
    private String createBy;
}
