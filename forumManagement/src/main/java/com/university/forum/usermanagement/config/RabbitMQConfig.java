package com.university.forum.usermanagement.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue myQueue() {
        return new Queue("testQueue", true); // true makes it durable
    }

    @Bean
    public Queue secondQueue(){
        return new Queue("secondQueue",true);
    }
}

