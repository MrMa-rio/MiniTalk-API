package com.marsn.minitalkapi.core.model.shared.enums;

import lombok.Getter;

@Getter
public enum TypeQueues {

    GENERIC_QUEUE("generic-queue");

    private final String queueName;

    TypeQueues(String queueName) {
        this.queueName = queueName;
    }


}
