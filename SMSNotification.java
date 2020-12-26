public class SMSNotification extends Notification {

    private String PhoneNumber;

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public SMSNotification() {
    }

    public SMSNotification(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }



    @Override
    public void sendNotification() {
        // no need to be implemented in this sprint
    }
}
