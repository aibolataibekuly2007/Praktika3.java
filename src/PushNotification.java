public class PushNotification implements Notification {
    private String deviceId;

    public PushNotification(String deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("Sending push notification to device " + deviceId + ": " + message);
    }
}