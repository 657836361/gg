//package com.example.demo.config;
//
//import com.rabbitmq.client.*;
//
//import java.io.IOException;
//import java.util.SortedSet;
//import java.util.concurrent.TimeoutException;
//
//public class Reciever {
//
//    static final String queue = "test";
//
//    public static void main(String[] args) throws IOException, TimeoutException {
//
//        Connection connection = MessageConfig.getConnection();
//
//        Channel channel = connection.createChannel();
//        channel.queueDeclare(queue, false, false, false, null);
//
//
//        channel.basicConsume(queue, false, new DefaultConsumer(channel) {
//            @Override
//            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//                System.out.println(new String(body, "utf-8"));
//                channel.basicAck(envelope.getDeliveryTag(), false);
//            }
//        });
//
////        channel.close();
////        connection.close();
//    }
//}
