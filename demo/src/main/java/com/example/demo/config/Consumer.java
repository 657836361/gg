//package com.example.demo.config;
//
//
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Consumer {
//
//    @RabbitListener(queues="QueueA")
//    public void processA(String str1) {
//        System.out.println("ReceiveA:"+str1);
//    }
//    @RabbitListener(queues="QueueB")
//    public void processB(String str) {
//        System.out.println("ReceiveB:"+str);
//    }
//    @RabbitListener(queues="QueueC")
//    public void processC(String str) {
//        System.out.println("ReceiveC:"+str);
//    }
//}
