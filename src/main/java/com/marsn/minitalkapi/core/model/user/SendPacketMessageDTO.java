package com.marsn.minitalkapi.core.model.user;

public record SendPacketMessageDTO(
        String messageId,
        String conversationId,
        Long senderId,
        String content,
        String timestamp
) {
}
