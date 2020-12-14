package com.example.controller;


import com.example.entity.Result;
import com.example.entity.User;
import com.example.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class IndexController {
    UserService service;


//    @RequestMapping("/abc")
//    public List<User> abc(int age){
//        return service.getUser(age);
//    }

//    @PostMapping("/aaa")
//    public List<User> def(String name){
//        return service.getUserName(name);
//    }

    @GetMapping("/login")
    public ResponseEntity<Result> login(String email,String password){
        return service.login(email,password);
    }

    @RequestMapping("/loginPost")
    public ResponseEntity<Result> loginPost(User user){
        return service.loginPost(user);
    }

    @RequestMapping("/register")
    public ResponseEntity<Result> register(User user){
        return service.register(user);
    }

    @RequestMapping("/getList")
    public ResponseEntity<Result> getUserList(){
        return service.getList();
    }

}
