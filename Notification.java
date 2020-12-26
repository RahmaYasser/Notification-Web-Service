import java.util.ArrayList;

public abstract class Notification {
    String Content = null;

    public void prepareContent(String templateMessage, String[] placeholders) {

        String firstPart = "", secondPart = "";
        for (int j = 0; j < placeholders.length; j++) {

            for (int i = 2; i < templateMessage.length(); i++) {
                if (templateMessage.charAt(i - 2) == 'X' && templateMessage.charAt(i - 1) == 'X' && templateMessage.charAt(i) == 'X') {
                    firstPart = templateMessage.substring(0, i - 2);
                    secondPart = templateMessage.substring(i + 1, templateMessage.length() );
                    break;
                }
            }
            templateMessage = firstPart + placeholders[j] + secondPart;
        }
        Content = templateMessage;
    }

    public String getContent() {
        return Content;
    }

    public abstract void sendNotification();
}
