package com.software.demo;


import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EmailNotification extends Notification {
    
    public EmailNotification() {}
    
    public boolean validateContact() {
    	String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(this.getContact());
        return m.matches();
    }
}