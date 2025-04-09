package com.logmate.logmate_BE;


public class MessagePostDTO {
    private String content;

    public MessagePostDTO() {}

    public MessagePostDTO(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}