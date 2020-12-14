package com.example.service;

import com.example.entity.Message;
import com.example.entity.Result;
import com.example.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
//    List<User> getUser(int age);
    ResponseEntity<Result> login(String eamil, String password);
    ResponseEntity<Result> loginPost(User user);
    ResponseEntity<Result> register(User user);
    ResponseEntity<Result> getList();


}
