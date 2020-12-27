package com.software.demo;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Template {

	private	String contact;
	private String Subject;
    private String templateType; // the primary key in DB   
    public List<Messages> Messages= new ArrayList<>();
    
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	
	public String getTemplateMessage(String language){
	        for(int i=0;i<Messages.size();i++){
	           if(Messages.get(i).getLanguage().equalsIgnoreCase(language)) return Messages.get(i).getMessage();
	        
	    }
	return "";        
	}

	
	@Override
	public String toString() {
		return "Template [contact=" + contact + ", Subject=" + Subject + ", templateType=" + templateType
				+ ", Messages=" + Messages + "]";
	}
	public String getTemplateType() {
		return templateType;
	}
	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}
	
}
