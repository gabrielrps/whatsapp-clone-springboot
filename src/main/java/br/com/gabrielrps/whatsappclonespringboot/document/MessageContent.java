package br.com.gabrielrps.whatsappclonespringboot.document;

import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document("messageContent")
public class MessageContent implements Serializable {

    private String id;
    private String message;
    private String name;
    private String timestamp;
    private Boolean received;

    private Boolean isUpload;
    private Boolean isSound;
    private Binary file;

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

    public Boolean getUpload() {
        return isUpload;
    }

    public void setUpload(Boolean upload) {
        isUpload = upload;
    }

    public Binary getFile() {
        return file;
    }

    public void setFile(Binary file) {
        this.file = file;
    }

    public Boolean getSound() {
        return isSound;
    }

    public void setSound(Boolean sound) {
        isSound = sound;
    }
}
