package com.marsn.minitalkapi.adapter.service.consumers;

import com.google.protobuf.InvalidProtocolBufferException;
import com.marsn.minitalkapi.adapter.service.processMessage.ProcessMessageAdapter;
import com.marsn.minitalkapi.v1.ChatMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class ProcessConsumer {

    private final ProcessMessageAdapter adapter;


    public ProcessConsumer(ProcessMessageAdapter adapter) {
        this.adapter = adapter;
    }

    @RabbitListener(queues = "chat.process.queue")
    public void consumeMessage(Message message) {

        try {
            ChatMessage chatMsg = ChatMessage.parseFrom(message.getBody());
            System.out.printf("📩 [%s] Nova mensagem em %s: %s%n",
                    chatMsg.getSenderId(), chatMsg.getConversationId(), chatMsg.getContent());

            System.out.println(chatMsg.getMessageId());

            //adapter.sendMessage(chatMsg)
        } catch (InvalidProtocolBufferException e) {
            log.error("FALHA DE PROCESSAMENTO DE CONVERSAO DE MENSAGEM");
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }
}