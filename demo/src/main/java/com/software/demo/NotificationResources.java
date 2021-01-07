package com.software.demo;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("notifications")
public class NotificationResources {
	
	EmailNotificationOperations repoEmail=   EmailNotificationOperations.getInstance();
	SMSNotificationOperations repoSMS= SMSNotificationOperations.getInstance();
	
	@POST
	@Path("create/{contact}")
	@Consumes(MediaType.TEXT_PLAIN)
    public void CreateNotification(@PathParam("contact")String contact,String ClientRequest) throws SQLException{
		
		INotificationFactory factory;
		Notification notification;
		String[] arr = ClientRequest.split(" ");
        String language = arr[0];
        String templateType = arr[1];
        String clientContact = arr[2];
        String placeholders="";
        
        for(int i=3;i<arr.length;i++)
             placeholders += arr[i] + " ";

        String[] placeholderArr= placeholders.split(" ");
		
        Template t = new Template();
		TemplateOperations operation= new TemplateOperations();
        String st=templateType;     
		t= operation.readTemplate(st);
		String message= t.getTemplateMessage(language);
		
		if(contact.equalsIgnoreCase("email")) {
			
			factory= new EmailNotificationFactory();
			notification= factory.CreateNotification(placeholderArr, message, clientContact);
			if(notification!=null)
				repoEmail.CreateNotification(notification, notification.validateContact()); 
			else
				System.out.println("Error occurred");	
		}
					
		else {
			
			factory= new SMSNotificationFactory();
			notification= factory.CreateNotification(placeholderArr, message, clientContact);			
			if(notification!=null)
				repoSMS.CreateNotification(notification, notification.validateContact());
			else
				System.out.println("Error occurred");
		}
	}
	
	public void readNotification(int ID, String contact) {
		
		Notification notification;
		if(contact.equalsIgnoreCase("email")) {
			notification= new EmailNotification();
			notification=repoEmail.readNotification(ID);
			
		}
		else {
			 notification = new SMSNotification();
			 notification=repoSMS.readNotification(ID);
		}
		System.out.println(notification);
		
	
	}
	
	public void deleteNotification(int ID, String contact) {
		Notification notification;
		if(contact.equalsIgnoreCase("email")) {
			notification= new EmailNotification();
			repoEmail.deleteNotification(ID);
			
		}
		else {
			 notification = new SMSNotification();
			 repoSMS.deleteNotification(ID);
		}
	}
        
}
