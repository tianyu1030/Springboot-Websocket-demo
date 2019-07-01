package com.websocket.demo.server;

import com.websocket.demo.ApiReturnObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * @description: 消息控制器
 * @author: zty
 * @create: 2019-07-01
 **/
@Controller
public class CheckCenterController {

    //在一个场景下，后台管理员通过后台管理系统添加一个商品需要推送到用户终端上，就可以通过调用 /socket/push/{cid}接口
    //此时的index页面（用户终端）是正在打开的（监听状态），当推送信息的时候，此时index页面就可以收到推送信息，完成一次消息推送
    //此时是由后台管理员请求服务器的操作引起的推送，而不是用户请求服务器返回的推送

    //页面请求
    @GetMapping("/socketdemo")
    public String demotohtml(){
        return "index";
    }
    //推送数据接口
    @ResponseBody
    @RequestMapping("/socket/push/{cid}")
    public ApiReturnObject pushToWeb(@PathVariable String cid, String message) {
        try {
            WebSocketServer.sendInfo(message, cid);
        } catch (IOException e) {
            e.printStackTrace();
            return ApiReturnObject.error(cid + "#" + e.getMessage());
        }
        return ApiReturnObject.success(cid);
    }
}
