package com.software.demo;

import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		Scanner scanner = new Scanner (System.in);
		String contact = scanner.nextLine();
		int ID = scanner.nextInt();
		NotificationResources resources= new NotificationResources();
		resources.readNotification(ID, contact);
		resources.deleteNotification(ID, contact);
		
	}
	
}
