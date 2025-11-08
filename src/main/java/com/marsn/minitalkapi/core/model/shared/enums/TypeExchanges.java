package com.marsn.minitalkapi.core.model.shared.enums;

import lombok.Getter;

@Getter
public enum TypeExchanges {

    DELIVERY_EXCHANGE("chat.delivery.exchange"),
    CHAT_EXCHANGE("chat.process.exchange");

    private final String exchangeName;

    TypeExchanges(String exchangeName) {
        this.exchangeName = exchangeName;
    }

}
