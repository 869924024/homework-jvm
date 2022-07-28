package com.huang.service.WebSocket;


import com.huang.util.Socketio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 监听器启动
 */

@Configuration
@WebListener
@Slf4j
public class SocketioLisener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //启动Socketio服务
        Socketio socketio = new Socketio();
        socketio.startServer();
        log.info("监听启动了····");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //关闭Socketio服务
        Socketio socketio = new Socketio();
        socketio.stopSocketio();
    }
}