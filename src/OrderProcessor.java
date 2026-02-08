import java.util.ArrayList;
import java.util.List;

public class OrderProcessor {
    private List<Notification> notifications;
    private DiscountCalculator discountCalculator;

    public OrderProcessor() {
        notifications = new ArrayList<>();
        discountCalculator = new DiscountCalculator();
    }

    public void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public void setDiscountCalculator(DiscountCalculator calculator) {
        this.discountCalculator = calculator;
    }

    public void processOrder(Order order) {
        double subtotal = order.calculateTotal();
        double discount = discountCalculator.calculateDiscount(subtotal, order);
        double total = subtotal - discount;

        System.out.println("\n=== Processing Order ===");
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Discount: $" + discount);
        System.out.println("Total: $" + total);

        order.processOrder();

        sendNotifications("Your order #" + order.getOrderId() +
                " has been processed. Total: $" + total);
    }

    private void sendNotifications(String message) {
        for (Notification notification : notifications) {
            notification.sendNotification(message);
        }
    }
}