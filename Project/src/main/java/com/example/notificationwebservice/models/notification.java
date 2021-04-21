package com.example.notificationwebservice.models;

public class notification {
    private String content;
    private String type;
    private String subject;
    private String state;
    private String contact;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public notification() {
    }

    public notification(String content, String type, String subject, String state, String contact) {
        this.content = content;
        this.type = type;
        this.subject = subject;
        this.state = state;
        this.contact = contact;
    }
}
