package com.marsn.minitalkapi.core.model.shared.enums;

import lombok.Getter;

@Getter
public enum TypeRoutingKeys {

    GENERIC_ROUTING_KEY("generic-routing-key");

    private final String routingKeyName;

    TypeRoutingKeys(String routingKeyName) {
        this.routingKeyName = routingKeyName;
    }




}
