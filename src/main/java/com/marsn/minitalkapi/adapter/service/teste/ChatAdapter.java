package com.marsn.minitalkapi.adapter.service.teste;

import com.marsn.minitalkapi.adapter.mappers.ChatMapper;
import com.marsn.minitalkapi.adapter.service.consumers.ChatConsumer;
import com.marsn.minitalkapi.adapter.service.producers.ChatProducer;
import com.marsn.minitalkapi.core.model.user.SendPacketMessageDTO;
import com.marsn.minitalkapi.v1.ChatMessage;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class ChatAdapter {


    private final ChatProducer chatProducer;
    private final ChatConsumer chatConsumer;

    public ChatAdapter(RabbitTemplate rabbitTemplate, RabbitAdmin rabbitAdmin, ConnectionFactory connectionFactory) {
        this.chatProducer = new ChatProducer(rabbitTemplate);
        this.chatConsumer = new ChatConsumer(rabbitAdmin, connectionFactory);
    }

    public String sendMessage() {
        var dto = new SendPacketMessageDTO(
                "100",
                "TESTE",
                "teste100",
                "Ola",
                "2020-10-10T10:00:56"
        );
        try {

            ChatMessage chatMessage = ChatMapper.toModel(dto);

            chatProducer.sendMessage(chatMessage);
            return "Enviado com sucesso";
        } catch (Exception e) {
            return "Erro ao processar requsicao";
        }
    }

    public String subscribe() {
        chatConsumer.subscribeToConversation("MarioTeste", "TESTE");

        return "INSCRITO COM SUCESSO";
    }
}
