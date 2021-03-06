package com.software.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SMSNotificationOperations implements INotificationDataBaseOperations {

	private static final SMSNotificationOperations uniqueInstance = new SMSNotificationOperations();
    public static SMSNotificationOperations getInstance(){
        return uniqueInstance;
    }
	Connection con;
	private SMSNotificationOperations() {
		//connect to database
		String url="jdbc:mysql://localhost:3306/hb_student_tracker";
		String username="hbstudent";
		String pass="hbstudent";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, pass);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
    @Override
    public void CreateNotification(Notification notification, boolean status) throws SQLException {
	    
    	String sql="insert into smsnotification (contact , content) values(?,?)";
    	String sql2= "insert into notification (content , contact , status) values (?,?,?)";
    	PreparedStatement st= con.prepareStatement(sql);
		PreparedStatement st2= con.prepareStatement(sql2);
		st2.setString(1, notification.getContent());
		st2.setString(2, notification.getContact());
	    //insert in notification table with it status either fail or success
    	if(status) {
		try {
			//insert to sms-notification table in database if it's success
			st.setString(1, notification.getContact());
			st.setString(2, notification.getContent());
			st.executeUpdate();
			
			st2.setString(3, "successful");
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		else
			st2.setString(3, "failed");
		st2.executeUpdate();

    }

	@Override
	public Notification readNotification(int ID) {
		String sql="select * from emailnotification where Id ='"+ ID +"'";
		
		EmailNotification notification= new EmailNotification();
		
		try {
			Statement st= con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			if(rs.next()) {
				
				notification.setContact(rs.getString(2));
				notification.setContent(rs.getString(3));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notification;		
	}

	@Override
	public void deleteNotification(int ID) {
		String sql="delete from smsnotification where ID = ?";
		
		try {
			java.sql.PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, ID);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
