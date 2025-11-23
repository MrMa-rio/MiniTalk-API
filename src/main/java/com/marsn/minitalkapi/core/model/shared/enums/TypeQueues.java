package com.marsn.minitalkapi.core.model.shared.enums;

import lombok.Getter;

@Getter
public enum TypeQueues {

    PROCESS_QUEUE("chat.process.queue");

    private final String queueName;

    TypeQueues(String queueName) {
        this.queueName = queueName;
    }


    public String getName() {
        return this.queueName;
    }
}
