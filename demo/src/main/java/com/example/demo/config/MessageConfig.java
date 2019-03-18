package com.example.demo.config;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class MessageConfig {


    public static Connection getConnection() throws IOException, TimeoutException {

        ConnectionFactory connectionFactory = new ConnectionFactory();

        ///服务名
        connectionFactory.setHost("127.0.0.1");
        ///端口号
        connectionFactory.setPort(5672);
        ///vhost
//        connectionFactory.setVirtualHost("/vhost_gg");
        connectionFactory.setVirtualHost("/");
        ///username
        connectionFactory.setUsername("guest");
        ///password
        connectionFactory.setPassword("guest");

        return connectionFactory.newConnection();

    }
}
