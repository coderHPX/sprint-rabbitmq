package com.rabbitmq.hpx.customer.baseConfig;


import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class Customer {

    @RabbitListener(queues = "test")
    public void receive(String msg, Channel channel, Message message) throws IOException {
        System.out.println("消息：==="+msg);
        channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);

    }
}
