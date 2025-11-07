package com.marsn.minitalkapi.adapter.service.producers;

import com.marsn.minitalkapi.core.model.shared.enums.TypeExchanges;
import com.marsn.minitalkapi.v1.ChatMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class ChatProducer {

    private final RabbitTemplate rabbitTemplate;

    public ChatProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(ChatMessage message) {


        String routingKey = "chat.conversation." + message.getDestinyId(); //TODO: Criar as routingKey de maneira mais eficiente e estruturada

        rabbitTemplate.convertAndSend(
                TypeExchanges.CHAT_EXCHANGE.getExchangeName(),
                routingKey,
                message.toByteArray()
        );

        System.out.printf("📤 [%s] Enviou mensagem na conversa %s: %s%n",
                message.getSenderId(), message.getConversationId(), message.getContent());
    }
}
