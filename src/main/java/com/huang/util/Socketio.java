package com.huang.util;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;

import java.util.Collection;

public class Socketio {

    private static SocketIOServer socketIOServer;

    /**
     * @Title: startSocketio
     * @Description: 创建服务添加客户端
     */
    public void startSocketio() {


        Configuration conf = new Configuration();

        conf.setHostname( "localhost" );
        // 指定端口号
        conf.setPort( 1528 );
        // 设置最大的WebSocket帧内容长度限制
        conf.setMaxFramePayloadLength( 1024 * 1024 );
        // 设置最大HTTP内容长度限制
        conf.setMaxHttpContentLength( 1024 * 1024 );

        socketIOServer = new SocketIOServer( conf );

        ConnectListener connect = new ConnectListener() {
            @Override
            public void onConnect( SocketIOClient client ) {}
        };
        // 添加客户端
        socketIOServer.addConnectListener( connect );
        socketIOServer.start();
    }



    /*
     * @Author hjj
     * @Description //体消息推送
     * @Date 18:33 2022/7/28
     * @Param  * @param type
     * @param content 推送的内容
     * @return void
     **/
    public void pushArr( String type, Object content ) {

        // 获取全部客户端
        Collection<SocketIOClient> allClients = socketIOServer.getAllClients();
        for( SocketIOClient socket : allClients ) {
            socket.sendEvent( type, content );
        }
    }


    /*
     * @Author hjj
     * @Description //启动服务
     * @Date 18:34 2022/7/28
     * @Param  * @param
     * @return void
     **/
    public void startServer() {

        if( socketIOServer == null ) {
            new Thread( new Runnable() {
                @Override
                public void run() {
                    startSocketio();
                }
            } ).start();
        }
    }


    /**
     * @Title: stopSocketio
     * @Description: 停止服务
     */
    public void stopSocketio() {
        if( socketIOServer != null ) {
            socketIOServer.stop();
            socketIOServer = null;
        }
    }
}