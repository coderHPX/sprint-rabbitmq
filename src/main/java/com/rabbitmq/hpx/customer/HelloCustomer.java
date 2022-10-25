package com.rabbitmq.hpx.customer;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.impl.AMQImpl;
import com.rabbitmq.hpx.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RabbitListener(queuesToDeclare = @Queue(value = "hello",declare = "true"))
@Slf4j
public class HelloCustomer {

    @RabbitHandler
    public void receive(String msg){
        System.out.println("消息：  "+msg);

    }
}
