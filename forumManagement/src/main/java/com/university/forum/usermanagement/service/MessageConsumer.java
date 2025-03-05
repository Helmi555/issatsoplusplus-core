package com.university.forum.usermanagement.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @RabbitListener(queues = "testQueue")
    public void receiveMessage(String message) {
        System.out.println("\uD83D\uDCE9 Received: "+message);
    }

    @RabbitListener(queues = "secondQueue")
    public void receiveSecondMessage(String message) {
        System.out.println("Second queue received : "+message);
    }

}
