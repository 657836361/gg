package com.example.demo.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.handler.annotation.Payload;

public class Get {


    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(value = "topic.exchange",durable = "true",type = "topic"),
            value = @Queue(value = "consumer_queue",durable = "true"),
            key = "key.#"
    ))
    public void process(@Payload String string, AMQP.Channel channel){

    }


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"http://10.20.160.198/wiki/display/dubbo/consumer.xml"});
        context.start();
    }
}
