package com.university.forum.usermanagement.MemberManagement.Services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {
    private final RabbitTemplate rabbitTemplate;
    private final String queueName = "testQueue";

    public MessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(queueName, message);
        System.out.println("✅ Sent: " + message);
    }
    public void sendMessage2(String message) {
        rabbitTemplate.convertAndSend(queueName, message);
        System.out.println("Sent 2 : "+message);
    }
}
