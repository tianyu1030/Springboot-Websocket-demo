package com.websocket.demo;

import java.io.Serializable;

/**
 * @description: 返回json格式
 * @author: zty
 * @create: 2019-07-01
 **/
public class ApiReturnObject implements Serializable {


    private String msg;

    public ApiReturnObject(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static ApiReturnObject error(String msg){
        return new ApiReturnObject(msg);
    }

    public static ApiReturnObject success(String msg){
        return new ApiReturnObject(msg);
    }


}
