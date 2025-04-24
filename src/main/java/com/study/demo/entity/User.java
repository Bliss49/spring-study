package com.study.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
@Table(name = "user")
public class User extends BaseTime{
    @Id
    private String id;

    private String email;

    private boolean status;

    private String note;

    private String createdBy;
    private String updatedBy;

    @Builder
    public User (
            String id,
            String email,
            boolean status,
            String note,
            String createdBy,
            String updatedBy
    ) {
        this.id = id;
        this.email = email;
        this.status = status;
        this.note = note;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }
}
