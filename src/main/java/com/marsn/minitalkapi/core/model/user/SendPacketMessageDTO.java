package com.marsn.minitalkapi.core.model.user;

public record SendPacketMessageDTO(
        String messageId,
        Long conversationId,
        Long senderId,
        String content,
        Long timestamp
) {}
