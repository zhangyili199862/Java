package com.example.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Message {
    String status;
    String message;

    Object data;
}
