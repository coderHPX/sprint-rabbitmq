package com.rabbitmq.hpx.customer;


import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class WorkQueueCustomer {

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive1(String msg){
        System.out.println("receive1 接受消息  " + msg);
    }

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive2(String msg){
        System.out.println("receive2 接受消息  " + msg);
    }

}
