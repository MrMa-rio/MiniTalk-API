package com.marsn.minitalkapi.adapter.service.processMessage;

import com.marsn.minitalkapi.adapter.service.producers.ChatProducer;
import com.marsn.minitalkapi.v1.ChatMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class DeliveryAdapter {

    private final ChatProducer chatProducer;

    public DeliveryAdapter(RabbitTemplate rabbitTemplate) {
        this.chatProducer = new ChatProducer(rabbitTemplate);
    }

    public void handleMessage(ChatMessage chatMsg) {
        chatProducer.sendMessage(chatMsg);
    }
}
