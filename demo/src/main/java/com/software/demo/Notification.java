package com.software.demo;

import com.sun.tools.javac.util.StringUtils;

public abstract class Notification {
    String Content = null;
    String contact=null;
  
    
    public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public boolean placeholdersSizeValidation(int placeholdersSize,String messages){
		int count = (messages.split("XXX", -1).length) - 1;
        if(count == placeholdersSize)return true;
        return false;
    }


	public void prepareContent(String templateMessage, String[] placeholders) {

        String firstPart = "", secondPart = "";
        for (int j = 0; j < placeholders.length; j++) {

            for (int i = 2; i < templateMessage.length(); i++) {
                if (templateMessage.charAt(i - 2) == 'X' && templateMessage.charAt(i - 1) == 'X' && templateMessage.charAt(i) == 'X') {
                    firstPart = templateMessage.substring(0, i - 2);
                    secondPart = templateMessage.substring(i + 1, templateMessage.length() );
                    break;
                }
            }
            templateMessage = firstPart + placeholders[j] + secondPart;
        }
        Content = templateMessage;
    }

    public String getContent() {
        return Content;
    }

    public abstract void sendNotification();
}