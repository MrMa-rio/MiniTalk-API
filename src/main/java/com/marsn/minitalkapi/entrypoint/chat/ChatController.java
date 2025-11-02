package com.marsn.minitalkapi.entrypoint.chat;

import com.marsn.minitalkapi.adapter.service.teste.ChatAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path = "/chat")
public class ChatController {
    private final ChatAdapter chatAdapter;

    public ChatController(ChatAdapter chatAdapter) {
        this.chatAdapter = chatAdapter;
    }

    @PostMapping("send-message")
    public String sendMessageChat () {
        return chatAdapter.sendMessage();
    }

    @PostMapping("/subscribe-chat")
    public String subscribe () {
        return chatAdapter.subscribe();
    }
}
