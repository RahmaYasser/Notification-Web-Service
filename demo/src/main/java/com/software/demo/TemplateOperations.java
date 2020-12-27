package com.software.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class TemplateOperations {

	Connection con= null;
	public TemplateOperations() {
		
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
	
	public void createTemplate(Template template) {
		
		String sql="insert into template value(?,?,?)";
		String sql2="insert into messages value(?,?,?)";
		try {
	
			PreparedStatement st= con.prepareStatement(sql);
			st.setString(1, template.getContact());
			st.setString(2, template.getSubject());
			st.setString(3, template.getTemplateType());
			st.executeUpdate();
			PreparedStatement st2= con.prepareStatement(sql2);
			
			for(int i=0 ; i<template.Messages.size(); i++) {
			st2.setString(1, template.Messages.get(i).getMessage());
			st2.setString(2, template.Messages.get(i).getLanguage());
			st2.setString(3, template.Messages.get(i).getType());
			st2.executeUpdate();
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Template readTemplate(String type) {
		
		String sql="select * from template where template.templateType ='"+ type+"'";
		String sql2="select * from messages where type= '"+ type +"'";
		Template temp= new Template();
		try {
			Statement st= con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			Statement st2= con.createStatement();
			ResultSet rs2=st2.executeQuery(sql2);
			
			if(rs.next()) {
				
				temp.setContact(rs.getString(1));
				temp.setSubject(rs.getString(2));
				temp.setTemplateType(rs.getString(3));
				
				while(rs2.next()) {
					Messages m= new Messages();
					m.setMessage(rs2.getString(1));
					m.setLanguage(rs2.getString(2));
					m.setType(rs2.getString(3));
					temp.Messages.add(m);
				}
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	
	public void deleteTemplate(String type) {
		
		String sql="delete from template where templateType = ?";
		String sql2="delete from messages where type = ?";
		
		try {
			java.sql.PreparedStatement st2 = con.prepareStatement(sql2);
			st2.setString(1, type);
			java.sql.PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, type);
			st2.executeUpdate();
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateTemplate(Template template) {
		
		String sql="update template set contact=? , subject=? where templateType=?";
		String sql2="update messages set messages=? where  language=?";
		try {
			PreparedStatement st= con.prepareStatement(sql);
			st.setString(1, template.getContact());
			st.setString(2, template.getSubject());
			st.setString(3, template.getTemplateType());
			st.executeUpdate();
			PreparedStatement st2= con.prepareStatement(sql2);
			
			for(int i=0 ; i<template.Messages.size(); i++) {
			st2.setString(1, template.Messages.get(i).getMessage());
			st2.setString(2, template.Messages.get(i).getLanguage());
			st2.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
