import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int nextId = 1;
    private int orderId;
    private List<OrderItem> items;
    private Payment paymentMethod;
    private Delivery deliveryMethod;
    private String customerEmail;
    private String customerPhone;

    public Order() {
        this.orderId = nextId++;
        this.items = new ArrayList<>();
    }

    public void addItem(String productName, int quantity, double price) {
        items.add(new OrderItem(productName, quantity, price));
    }

    public double calculateTotal() {
        double subtotal = 0;
        for (OrderItem item : items) {
            subtotal += item.getTotalPrice();
        }
        return subtotal;
    }

    public void setPaymentMethod(Payment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setDeliveryMethod(Delivery deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public void setCustomerEmail(String email) {
        this.customerEmail = email;
    }

    public void setCustomerPhone(String phone) {
        this.customerPhone = phone;
    }

    public void processOrder() {
        double total = calculateTotal();

        if (paymentMethod != null) {
            paymentMethod.processPayment(total);
        }

        if (deliveryMethod != null) {
            deliveryMethod.deliverOrder(this);
        }

        System.out.println("Order #" + orderId + " processed successfully");
    }

    public int getOrderId() {
        return orderId;
    }

    public List<OrderItem> getItems() {
        return new ArrayList<>(items);
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    // Изменено на public static class
    public static class OrderItem {
        private final String productName;
        private final int quantity;
        private final double price;

        public OrderItem(String productName, int quantity, double price) {
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
        }

        public double getTotalPrice() {
            return quantity * price;
        }

        public String getProductName() {
            return productName;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getPrice() {
            return price;
        }
    }
}