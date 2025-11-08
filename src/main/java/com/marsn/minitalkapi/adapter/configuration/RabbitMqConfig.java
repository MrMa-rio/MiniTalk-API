package com.marsn.minitalkapi.adapter.configuration;

import com.marsn.minitalkapi.adapter.configuration.serializer_deserializer.ProtobufMessageConverter;
import com.marsn.minitalkapi.core.model.shared.enums.TypeExchanges;
import com.marsn.minitalkapi.core.model.shared.enums.TypeQueues;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Bean
    public DirectExchange processExchange() {
        return new DirectExchange(TypeExchanges.CHAT_EXCHANGE.getExchangeName());
    }
    @Bean
    public Queue processQueue() {
        return new Queue(TypeQueues.PROCESS_QUEUE.getQueueName(), false);
    }

    @Bean
    public TopicExchange deliveryExchange() {
        return new TopicExchange(TypeExchanges.DELIVERY_EXCHANGE.getExchangeName());
    }

    @Bean
    public MessageConverter messageConverter() {
        return new SimpleMessageConverter();
    }

    @Bean MessageConverter protobufMessageConverter() {
        return new ProtobufMessageConverter(Message.class);
    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, MessageConverter protobufMessageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(protobufMessageConverter);
        return rabbitTemplate;
    }

}
