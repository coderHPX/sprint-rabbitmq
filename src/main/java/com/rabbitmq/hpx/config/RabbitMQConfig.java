package com.rabbitmq.hpx.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Bean
    public DirectExchange myDirectExchange(){
        return new DirectExchange("myDirectExchange",true,false);
    }

    @Bean
    public Queue myRoutingQueue(){
        return new Queue("test",true);
    }

    @Bean
    public Binding myBinding(){
        return BindingBuilder.bind(myRoutingQueue()).to(myDirectExchange()).with("test.config.routing");
    }
}
