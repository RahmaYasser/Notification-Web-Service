package com.software.demo;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SMSNotification extends Notification {

    public SMSNotification() {}
    
    public boolean validateContact() {
    	if(this.getContact().length()!=13)
    		return false;
    	return true;
    }
}