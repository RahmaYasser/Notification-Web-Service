package com.software.demo;

public class Messages {

	private String message;
	private String language;
	private String type;
	
	public String getMessage() {
		return message;
	}
	public String getType() {
		return type;
	}
	@Override
	public String toString() {
		return "Messages [message=" + message + ", language=" + language  + "]";
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
}
