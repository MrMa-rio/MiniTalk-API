package com.marsn.minitalkapi.core.model.user;

public record SendPacketMessageDTO(
        Long messageId,
        String conversationId,
        Long senderId,
        String content,
        Long timestamp,
        Boolean isSent,
        Boolean isDelivered,
        Boolean isRead,
        Boolean isDeleted,
        Boolean isEdited

) {
}
