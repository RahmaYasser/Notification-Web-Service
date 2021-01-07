package com.software.demo;

import java.sql.Connection;
import java.sql.SQLException;

public interface INotificationDataBaseOperations {
	
	
    public void CreateNotification(Notification notificaiton, boolean status) throws SQLException;
    public Notification readNotification(int ID);
    public void deleteNotification(int ID);

}
