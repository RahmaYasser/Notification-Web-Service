package com.software.demo;

import java.util.ArrayList;

public class SMSNotificationFactory implements INotificationFactory {

	@Override
	public Notification CreateNotification(String[] placeholders ,String message,String Contact) {
		
		Notification notification = new SMSNotification();
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
	

