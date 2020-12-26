public class EmailNotification extends Notification {
    private String Email;
    public EmailNotification() {
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getEmail() {
        return Email;
    }

    public EmailNotification(String email) {
        Email = email;
    }




    @Override
    public void sendNotification() {
        // no need to be implemented in this sprint
    }
}
