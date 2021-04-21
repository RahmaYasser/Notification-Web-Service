package com.example.notificationwebservice.models;

public class Template {

    private String content;
    private String templateType;
    private String subject;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Template() {
    }

    public Template(String content, String type, String subject) {
        this.content = content;
        this.templateType = type;
        this.subject = subject;
    }
}
