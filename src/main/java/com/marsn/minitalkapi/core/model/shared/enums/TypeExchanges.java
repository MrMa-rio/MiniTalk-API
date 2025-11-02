package com.marsn.minitalkapi.core.model.shared.enums;

import lombok.Getter;

@Getter
public enum TypeExchanges {

    GENERIC_EXCHANGE("generic-exchange"),
    CHAT_EXCHANGE("chat-exchange");

    private final String exchangeName;

    TypeExchanges(String exchangeName) {
        this.exchangeName = exchangeName;
    }

}
