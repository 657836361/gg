package com.example.demo.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;

public class Get {


    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(value = "topic.exchange",durable = "true",type = "topic"),
            value = @Queue(value = "consumer_queue",durable = "true"),
            key = "key.#"
    ))
    public void process(@Payload String string, AMQP.Channel channel){

    }
}
