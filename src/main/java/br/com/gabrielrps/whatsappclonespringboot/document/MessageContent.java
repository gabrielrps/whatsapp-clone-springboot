package br.com.gabrielrps.whatsappclonespringboot.document;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("messageContent")
public class MessageContent {

    private String id;
    private String message;
    private String name;
    private String timestamp;
    private Boolean received;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean getReceived() {
        return received;
    }

    public void setReceived(Boolean received) {
        this.received = received;
    }
}
