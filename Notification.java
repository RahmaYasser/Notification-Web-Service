public abstract class Notification {
    String Content = null;

    public void prepareContent(String tmplateMessage, String[] Placeholders) {

    }
    public abstract void sendNotification();

}
