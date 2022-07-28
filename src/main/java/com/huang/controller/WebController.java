package com.huang.controller;

import com.huang.service.Bread.ShoppingService;
import com.huang.util.Socketio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hjj
 * @ClassName WebController
 * @description: TODO
 * @datetime 2022年 07月 28日 18:37
 * @version: 1.0
 */

@RestController
public class WebController {
    @Autowired
    ShoppingService shoppingService;
    /**
     * 推送服务
     */
    @GetMapping("/pushMessage")
    @ResponseBody
    public void pushMessage() {
        Socketio socketio = new Socketio();
        //这里是发送的消息内容
        socketio.pushArr("connect_msg", shoppingService.getOverBread());
    }
}
