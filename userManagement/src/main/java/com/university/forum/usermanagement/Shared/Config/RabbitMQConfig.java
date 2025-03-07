package com.university.forum.usermanagement.Shared.Config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

@Configuration
@EnableRabbit
public class RabbitMQConfig {

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public SimpleMessageListenerContainer messageListenerContainer(
            ConnectionFactory connectionFactory,
            Jackson2JsonMessageConverter jackson2JsonMessageConverter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setMessageListener(new MessageListenerAdapter(new MyMessageListener(), jackson2JsonMessageConverter));
        return container;
    }

    @Bean
    public Queue myQueue() {
        return new Queue("testQueue", true);
    }

    @Bean
    public Queue secondQueue() {
        return new Queue("secondQueue", true);
    }

    @Bean
    public TopicExchange memberManagementExchange() {
        return new TopicExchange("member-management-exchange");
    }

    @Bean
    public Queue forumServiceQueue() {
        return new Queue("forum-service-queue", true);
    }

    @Bean
    public Binding binding(Queue forumServiceQueue, TopicExchange memberManagementExchange) {
        return BindingBuilder.bind(forumServiceQueue).to(memberManagementExchange).with("member.professor.created");
    }
}
