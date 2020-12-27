package com.software.demo;
import java.util.List;

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
	
	EmailNotificationOperations repoEmail=  new  EmailNotificationOperations();
	SMSNotificationOperations repoSMS= new SMSNotificationOperations();
	
	@POST
	@Path("create")
	@Consumes(MediaType.TEXT_PLAIN)
    public void CreateNotification(String ClientRequest){
		
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
        String st="'"+templateType+"'";     
		t= operation.readTemplate(st);
		
		String message= t.getTemplateMessage(language);
		
		if(t.getContact().equalsIgnoreCase("email")) {
			
			factory= new EmailNotificationFactory();
			notification= factory.CreateNotification(placeholderArr, message, clientContact);
			
			if(notification!=null)
				repoEmail.CreateNotification(notification);
			else
				System.out.println("Error occurred");
		
		}
					
		else {
			
			factory= new SMSNotificationFactory();
			notification= factory.CreateNotification(placeholderArr, message, clientContact);
			
			if(notification!=null)
				repoSMS.CreateNotification(notification);
			else
				System.out.println("Error occurred");
		
		}
	}
        
}
