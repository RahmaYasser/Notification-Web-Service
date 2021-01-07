package com.software.demo;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SMSNotification extends Notification {

    public SMSNotification() {}
    //this function to check if phone number is valid
    public boolean validateContact() {
    	if(this.getContact().length()!=13)
    		return false;
    	return true;
    }
}
