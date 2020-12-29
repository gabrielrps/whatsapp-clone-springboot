package br.com.gabrielrps.whatsappclonespringboot.service;

import br.com.gabrielrps.whatsappclonespringboot.document.MessageContent;
import br.com.gabrielrps.whatsappclonespringboot.repository.MessageContentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageContentService {

    private final MessageContentRepository messageContentRepository;

    public MessageContentService(MessageContentRepository messageContentRepository) {
        this.messageContentRepository = messageContentRepository;
    }


    public MessageContent save(MessageContent messageContent) {
        return messageContentRepository.save(messageContent);
    }

    public List<MessageContent> getMessages() {
        return (List<MessageContent>) messageContentRepository.findAll();
    }
}
