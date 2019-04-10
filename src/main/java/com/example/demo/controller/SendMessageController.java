package com.example.demo.controller;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
public class SendMessageController {

    @Autowired
    public RabbitTemplate rabbitTemplate;


    @RequestMapping("/msg")
    public void send() throws InterruptedException {


//        rabbitTemplate.convertAndSend("java","java来了");

        for (int i = 1; i <= 30; i++) {
            Thread.sleep(1000);
            if(i % 3 == 0){
                rabbitTemplate.convertAndSend("directExchange","java",("java来了"+i));
            }else if(i % 2 == 0){
                rabbitTemplate.convertAndSend("directExchange","python",("python来了"+i));
            }else{
                rabbitTemplate.convertAndSend("directExchange","php",("php来了"+i));
            }
        }
    }
}
