package com.marsn.minitalkapi.adapter.configuration;

import com.marsn.minitalkapi.adapter.configuration.serializer_deserializer.ProtobufMessageConverter;
import com.marsn.minitalkapi.core.model.shared.enums.TypeExchanges;
import org.springframework.amqp.core.Message;
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
    public TopicExchange chatExchange() {
        return new TopicExchange(TypeExchanges.CHAT_EXCHANGE.getExchangeName(), true, false);
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
//        rabbitTemplate.setMessageConverter(messageConverter());
        rabbitTemplate.setMessageConverter(protobufMessageConverter);
        return rabbitTemplate;
    }

}
