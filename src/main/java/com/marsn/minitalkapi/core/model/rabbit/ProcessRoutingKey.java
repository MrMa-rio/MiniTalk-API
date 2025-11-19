package com.marsn.minitalkapi.core.model.rabbit;

public record ProcessRoutingKey(Long name) implements RoutingKey {
    @Override
    public String toRoute() {
        return "process.chat." + name;
    }
}
