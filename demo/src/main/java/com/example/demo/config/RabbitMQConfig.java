package com.example.demo.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class RabbitMQConfig {

    @Value("${spring.rabbitmq.host}")
    private String addresses;

    @Value("${spring.rabbitmq.port}")
    private String port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value("${spring.rabbitmq.virtual-host}")
    private String virtualHost;

    @Value("${spring.rabbitmq.publisher-confirms}")
    private boolean publisherConfirms;

    @Bean
    public ConnectionFactory connectionFactory() {
        String str = "C:\\Users\\GG\\Desktop";
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(addresses + ":" + port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(virtualHost);
        /** 如果要进行消息回调，则这里必须要设置为true */
        connectionFactory.setPublisherConfirms(publisherConfirms);
        return connectionFactory;
    }

    @Bean
    /** 因为要设置回调类，所以应是prototype类型，如果是singleton类型，则回调类为最后一次设置 */
    @Scope("prototype")
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        template.setMandatory(true);
        return template;
        ///springboot 整合rabbitmq的消息可靠机制
    }


    @Bean
    public Queue queueA(){
        return new Queue("QueueA",true);
    }
    @Bean
    public Queue queueB(){
        return new Queue("QueueB",true);
    }
    @Bean
    public Queue queueC(){
        return new Queue("QueueC",true);
    }
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("directExchange");
    }
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }
//    @Bean
//    public Binding bindingExchangeA(Queue queueA,FanoutExchange fanoutExchange){
//        return BindingBuilder.bind(queueA).to(fanoutExchange);
//    }
//    @Bean
//    public Binding bindingExchangeB(Queue queueB,FanoutExchange fanoutExchange){
//        return BindingBuilder.bind(queueB).to(fanoutExchange);
//    }
//    @Bean
//    public Binding bindingExchangeC(Queue queueC,FanoutExchange fanoutExchange){
//        return BindingBuilder.bind(queueC).to(fanoutExchange);
//    }

    @Bean
    public Binding bindingExchangeA(Queue queueA,DirectExchange directExchange){
        return BindingBuilder.bind(queueA).to(directExchange).with("java");
    }
    @Bean
    public Binding bindingExchangeB(Queue queueB,DirectExchange directExchange){
        return BindingBuilder.bind(queueB).to(directExchange).with("python");
    }
    @Bean
    public Binding bindingExchangeC(Queue queueC,DirectExchange directExchange){
        return BindingBuilder.bind(queueC).to(directExchange).with("php");
    }
}
