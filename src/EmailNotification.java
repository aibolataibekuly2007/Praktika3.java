public class EmailNotification implements Notification {
    private String recipientEmail;

    public EmailNotification(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("Sending email to " + recipientEmail + ": " + message);
    }
}