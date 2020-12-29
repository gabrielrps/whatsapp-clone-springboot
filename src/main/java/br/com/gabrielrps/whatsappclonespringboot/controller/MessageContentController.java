package br.com.gabrielrps.whatsappclonespringboot.controller;

import br.com.gabrielrps.whatsappclonespringboot.document.MessageContent;
import br.com.gabrielrps.whatsappclonespringboot.service.MessageContentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MessageContentController {

    private final SimpMessagingTemplate template;
    private final MessageContentService messageContentService;

    public MessageContentController(SimpMessagingTemplate template, MessageContentService messageContentService) {
        this.template = template;
        this.messageContentService = messageContentService;
    }

    @PostMapping("/messages/new")
    public ResponseEntity<MessageContent> insertMessage(@RequestBody MessageContent messageContent){
        return new ResponseEntity<>(messageContentService.save(messageContent), HttpStatus.CREATED);
    }

    @GetMapping("/messages/sync")
    public ResponseEntity<List<MessageContent>> getMessages(){
        return new ResponseEntity<>(messageContentService.getMessages(), HttpStatus.CREATED);
    }

    @MessageMapping("/send")
    public void sendMessage(@Payload MessageContent message){
        message.setTimestamp(LocalDateTime.now().toString());

        template.convertAndSend("/topic/"+"teste", message);
    }



}
