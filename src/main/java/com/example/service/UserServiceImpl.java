package com.example.service;

import com.example.dao.UserMap;
import com.example.entity.Result;
import com.example.entity.TokenUtils;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMap userMap;
//    @Override
//    public List<User> getUser(int age) {
//        return userMap.getUser(age);
//    }

//    @Override
//    public List<User> getUserName(String name) {
//        return userMap.getUserName(name);
//    }



    @Override
    public ResponseEntity<Result> login(String eamil, String password) {
        TokenUtils tokenUtils = new TokenUtils();
        Result res = new Result(200, "ok");
        User user = this.userMap.login(eamil);
        if (user == null) {
            res.setStatus(400);
            res.setMessage("user is not exist");
            return ResponseEntity.ok(res);
        } else {
            if (user.getPassword() != null && user.getPassword().equals(password)) {
                String token = tokenUtils.token(eamil, password);

                Map<String, Object> map = new HashMap<>();
                map.put("token", token);
                res.setStatus(200);
                res.setMessage("登录成功啦");
                res.setData(map);
                return ResponseEntity.ok(res);
            } else {
                res.setStatus(400);
                res.setMessage("password wrong");
                return ResponseEntity.ok(res);
            }
        }
    }

    @Override
    public ResponseEntity<Result> loginPost(User obj) {
        TokenUtils tokenUtils = new TokenUtils();
        Result res = new Result(200, "ok");
        User user = this.userMap.login(obj.getEmail());
        if (user == null) {
            res.setStatus(400);
            res.setMessage("user is not exist");
            return ResponseEntity.ok(res);
        } else {
            if (user.getPassword() != null && user.getPassword().equals(obj.getPassword())) {
                String token = tokenUtils.token(obj.getEmail(), obj.getPassword());

                Map<String, Object> map = new HashMap<>();
                map.put("token", token);
                res.setStatus(200);
                res.setMessage("登录成功啦");
                res.setData(map);
                return ResponseEntity.ok(res);
            } else {
                res.setStatus(400);
                res.setMessage("password wrong");
                return ResponseEntity.ok(res);
            }
        }
    }

    @Override
    public ResponseEntity<Result> register(User user) {
        User userInfo = userMap.getUser(user.getEmail());
        Result res = new Result(200, "ok");
        if (userInfo==null) {
            int rows = userMap.register(user);
            if (rows > 0) {
                res.setMessage("注册成功！");
            } else {
                res.setMessage("注册失败！");
            }
            return ResponseEntity.ok(res);
        } else {

            res.setMessage("该用户已存在！");
            return ResponseEntity.ok(res);
        }
    }

    @Override
    public ResponseEntity<Result> getList() {
        List<User> users= userMap.getUserList();
        Result res = new Result(200, "ok");
        for (User user : users) {
            user.setPassword(null);
        };
        Map<String,List<User>> map = new HashMap<>();
        map.put("list",users);
        res.setData(map);
        return ResponseEntity.ok(res);
    }

}
