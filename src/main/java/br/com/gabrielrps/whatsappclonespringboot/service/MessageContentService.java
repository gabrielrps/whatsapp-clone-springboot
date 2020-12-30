package br.com.gabrielrps.whatsappclonespringboot.service;

import br.com.gabrielrps.whatsappclonespringboot.document.MessageContent;
import br.com.gabrielrps.whatsappclonespringboot.repository.MessageContentRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
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

    public MessageContent saveUpload(String username, MultipartFile file) throws IOException {
        MessageContent messageContent = new MessageContent();

        messageContent.setMessage(file.getOriginalFilename());
        messageContent.setName(username);
        messageContent.setTimestamp(LocalDateTime.now().toString());
        messageContent.setReceived(false);
        messageContent.setUpload(true);
        messageContent.setFile(new Binary(BsonBinarySubType.BINARY, file.getBytes()));

        messageContentRepository.save(messageContent);

        return messageContent;
    }

    public MessageContent uploadSound(String username, MultipartFile file) throws IOException {
        MessageContent messageContent = new MessageContent();

        messageContent.setMessage(file.getOriginalFilename());
        messageContent.setName(username);
        messageContent.setTimestamp(LocalDateTime.now().toString());
        messageContent.setReceived(false);
        messageContent.setUpload(false);
        messageContent.setFile(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        messageContent.setSound(true);

        messageContentRepository.save(messageContent);

        return messageContent;
    }
}
