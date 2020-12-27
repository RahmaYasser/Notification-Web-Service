package com.software.demo;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EmailNotification extends Notification {
    
    public EmailNotification() {}

    @Override
    public void sendNotification() {
        // no need to be implemented in this sprint
    }
}