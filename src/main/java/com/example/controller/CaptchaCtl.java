package com.example.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import com.example.entity.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class CaptchaCtl {
    @GetMapping("/captcha")
    public ResponseEntity<Result> getCaptcha(){
        Result res = new Result(200, "ok");
        ShearCaptcha captcha  =  CaptchaUtil.createShearCaptcha(111,36);
        // 验证码对应的字符串
        String code = captcha.getCode();
        String image = captcha.getImageBase64();
        Map<String,Object> map = new HashMap<>();
        map.put("code",code);
        map.put("image",image);
        res.setData(map);
        // 返回图片流
        return ResponseEntity.ok(res);
    }
}
