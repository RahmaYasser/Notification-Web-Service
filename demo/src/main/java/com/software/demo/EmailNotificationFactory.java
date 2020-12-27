package com.software.demo;

import java.util.ArrayList;

public class EmailNotificationFactory implements INotificationFactory{
/*	
	public boolean checkEmail(String email ) {
		
		  String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
          java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
          java.util.regex.Matcher m = p.matcher(email);
          return m.matches();


	} */

@Override
public Notification CreateNotification(String[] placeholders ,String message,String Contact) {
		
	Notification notification = new EmailNotification();
	if(notification.placeholdersSizeValidation(placeholders.length, message))
	{	
		notification.prepareContent(message, placeholders);
		notification.setContact(Contact);
	}
	else
	{
		System.out.println("Invalid placeholders");
		return null;
	}
	
	return notification;
	}
	
 }
