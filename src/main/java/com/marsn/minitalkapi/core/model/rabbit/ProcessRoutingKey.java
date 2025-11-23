package com.marsn.minitalkapi.core.model.rabbit;

public record ProcessRoutingKey(String name) implements RoutingKey {
    @Override
    public String toRoute() {
        return "process.chat." + name;
    }
}
