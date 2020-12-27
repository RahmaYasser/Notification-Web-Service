package com.software.demo;

import java.util.ArrayList;

public interface INotificationFactory {

	public Notification CreateNotification(String[] placeholders,String message,String Contact);
}
