//package com.example.demo.config;
//
//import com.rabbitmq.client.Channel;
//import com.rabbitmq.client.Connection;
//
//import java.io.IOException;
//import java.util.concurrent.TimeoutException;
//
//public class Sender {
//
//
//    static final String queue = "test";
//
//    public static void main(String[] args) throws IOException, TimeoutException {
//
//        ///获取一个连接
//        Connection connection = MessageConfig.getConnection();
//        ///连接中获取一个通道
//        Channel channel = connection.createChannel();
//        ///创建队列声明
//        channel.queueDeclare(queue,false,false,false,null);
//        channel.basicQos(1);
//        ///发送消息
//
//        try {
//            channel.txSelect();
//            for (int i = 0; i < 10; i++) {
//                channel.basicPublish("",queue,null,("你好"+i).getBytes("utf-8"));
//            }
//            channel.txCommit();
//            System.out.println("消息发送成功！");
//        } catch (IOException e) {
//            channel.txRollback();
//            System.out.println("error!");
//        }finally {
//            channel.close();
//            connection.close();
//            System.out.println("资源关闭！");
//        }
//    }
//}
