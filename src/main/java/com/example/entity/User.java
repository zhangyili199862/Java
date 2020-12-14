package com.example.entity;

import lombok.Data;

@Data
public class User {
    private int id;
    private String username;
    private Integer age;
    private String phone;
    private String email;
    private String password;
}
