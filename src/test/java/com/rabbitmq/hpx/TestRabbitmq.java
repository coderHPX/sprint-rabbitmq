package com.rabbitmq.hpx;



import com.rabbitmq.hpx.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest(classes = SpringbootRabbitmqApplication.class)
@RunWith(SpringRunner.class)
public class TestRabbitmq {

    @Autowired
    RabbitTemplate rabbitTemplate;

    // routing
    @Test
    public void testConfigRouting(){
        rabbitTemplate.convertAndSend("myDirectExchange","test.config.routing","hello testConfigRouting");
    }



    // topic
    @Test
    public void testTopic(){
        rabbitTemplate.convertAndSend("topics","user.save.heihei","topic_test");
    }

    // routing
    @Test
    public void testRouting(){
        rabbitTemplate.convertAndSend("routing_test","error","routing_test_error   消息");
    }



    // fanout
    @Test
    public void testFanout(){
        rabbitTemplate.convertAndSend("fanout_test","","fanout_test 消息");
    }

    // work queue
    @Test
    public void testWorkQueue(){
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work","hello rabbit");
        }
    }

    // helloworld
    @Test
    public void testProducer(){

        Map<String, User> objectObjectHashMap = new HashMap<>();

        objectObjectHashMap.put("hpx",new User("hpx",21));
        objectObjectHashMap.put("hx",new User("hx",21));
        rabbitTemplate.convertAndSend("hello","objectObjectHashMap");
    }



}
