package com.rabbitmq.hpx.customer;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RoutingCustomer {

    @RabbitListener(bindings = @QueueBinding(value = @Queue,
            exchange = @Exchange(name = "routing_test",type = "direct"),
            key = {"info","error"}
    ))
    public void receive1(String msg){
        System.out.println("receive1    "+msg);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue,
            exchange = @Exchange(name = "routing_test",type = "direct"),
            key = {"info"}
    ))
    public void receive2(String msg){
        System.out.println("receive2    "+msg);
    }
}
