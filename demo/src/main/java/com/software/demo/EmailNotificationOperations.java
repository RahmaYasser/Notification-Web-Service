package com.software.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmailNotificationOperations implements INotificationDataBaseOperations {

	Connection con;
	public EmailNotificationOperations() {
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
    public void CreateNotification(Notification notification) {
		
		String sql="insert into emailnotification (contact , content) values(?,?)";
		try {
			PreparedStatement st= con.prepareStatement(sql);
			st.setString(1, notification.getContact());
			st.setString(2, notification.getContent());
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }

  
}