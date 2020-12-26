import java.util.ArrayList;

public interface INotificationFactory {
    public Notification CreateNotification(ArrayList<String> placeholders,String Language,String templateType,String Contact);
}
