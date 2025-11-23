package com.marsn.minitalkapi.adapter.mappers;

import com.marsn.minitalkapi.core.model.user.SendPacketMessageDTO;
import com.marsn.minitalkapi.v1.ChatMessage;

public class ChatMapper {

    public static ChatMessage toModel(SendPacketMessageDTO dto) {
        return ChatMessage.newBuilder()
                .setMessageId(dto.messageId())
                .setConversationId(dto.conversationId())
                .setSenderId(dto.senderId())
                .setContent(dto.content())
                .setIsDeleted(dto.isDeleted())
                .setIsEdited(dto.isEdited())
                .setIsDelivered(dto.isDelivered())
                .setIsRead(dto.isRead())
                .setIsSent(dto.isSent())
                .setTimestamp(dto.timestamp())
                .build();
    }
}
