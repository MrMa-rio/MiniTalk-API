package com.marsn.minitalkapi.adapter.service.producers;

import com.marsn.minitalkapi.core.model.rabbit.ProcessRoutingKey;
import com.marsn.minitalkapi.core.model.rabbit.RoutingKey;
import com.marsn.minitalkapi.core.model.shared.enums.TypeExchanges;
import com.marsn.minitalkapi.v1.ChatMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class ChatProducer {

    private final RabbitTemplate rabbitTemplate;

    public ChatProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(ChatMessage message) {

        System.out.println(message.getTimestamp());
        RoutingKey routingKey = new ProcessRoutingKey( String.valueOf(message.getDestinyId()));
        rabbitTemplate.convertAndSend(
                TypeExchanges.DELIVERY_EXCHANGE.getExchangeName(),
                routingKey.toRoute(),
                message
        );
    }
}
