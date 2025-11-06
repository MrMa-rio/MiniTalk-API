package com.marsn.minitalkapi.entrypoint.chat;

import com.marsn.minitalkapi.adapter.service.processMessage.ProcessMessageAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path = "/chat")
public class ChatController {
    private final ProcessMessageAdapter processMessageAdapter;

    public ChatController(ProcessMessageAdapter processMessageAdapter) {
        this.processMessageAdapter = processMessageAdapter;
    }

    @PostMapping("send-message")
    public String sendMessageChat () {
        return processMessageAdapter.sendMessage();
    }

    @PostMapping("/subscribe-chat")
    public String subscribe () {
        return processMessageAdapter.subscribe();
    }
}
