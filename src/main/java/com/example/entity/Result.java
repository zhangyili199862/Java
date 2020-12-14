package com.example.entity;

import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result implements Serializable {

    @SuppressWarnings("unused")
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(Result.class);

    private static final long serialVersionUID = -1802122468331526708L;
    private int status = -1;
    private String message = "待处理";
    private Object data = new HashMap<String, Object>();

    public Result(){}

    public Result(int status, String message){
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

//    public void putData(String key, Object value) {
//        data.put(key, value);
//    }
//
//    public void removeData(String key) {
//        data.remove(key);
//    }

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

}
