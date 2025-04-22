package com.study.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "user")
public class User {
    @Id
    private String id;

    private String email;

    private boolean status;

    private String note;

    private String createdBy;
    private String updatedBy;
    private LocalDateTime createdAt; // 생성된 시간
    private LocalDateTime updatedAt; // 업데이트 시간
}
