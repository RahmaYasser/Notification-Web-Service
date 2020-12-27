package com.software.demo;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SMSNotification extends Notification {

    public SMSNotification() {}
    
    @Override
    public void sendNotification() {
        // no need to be implemented in this sprint
    }
}