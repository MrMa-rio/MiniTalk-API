package com.marsn.minitalkapi.adapter.service.consumers;

import com.marsn.minitalkapi.adapter.service.processMessage.ProcessMessageAdapter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class ProcessConsumer {

    private final ProcessMessageAdapter adapter;

    public ProcessConsumer(ProcessMessageAdapter adapter) {
        this.adapter = adapter;
    }

    @RabbitListener(queues = "process.delivery")
    public void consumeMessage(String messageJson) {



    }
}