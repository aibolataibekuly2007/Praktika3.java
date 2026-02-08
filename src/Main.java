public class Main {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();

        DiscountCalculator discountCalculator = new DiscountCalculator();
        discountCalculator.addDiscountStrategy(new PercentageDiscount(10));
        discountCalculator.addDiscountStrategy(new QuantityDiscount(3, 5.0));
        discountCalculator.addDiscountStrategy(new FirstOrderDiscount(15.0));

        orderProcessor.setDiscountCalculator(discountCalculator);

        Order order1 = new Order();
        order1.addItem("Laptop", 1, 1200.00);
        order1.addItem("Mouse", 2, 25.00);
        order1.addItem("USB Cable", 3, 10.00);
        order1.setCustomerEmail("customer@example.com");
        order1.setCustomerPhone("+1234567890");

        Payment creditCardPayment = new CreditCardPayment("4111111111111111");
        Delivery courierDelivery = new CourierDelivery("123 Main St, City");

        order1.setPaymentMethod(creditCardPayment);
        order1.setDeliveryMethod(courierDelivery);

        EmailNotification emailNotification = new EmailNotification("customer@example.com");
        SmsNotification smsNotification = new SmsNotification("+1234567890");
        PushNotification pushNotification = new PushNotification("device_12345");

        orderProcessor.addNotification(emailNotification);
        orderProcessor.addNotification(smsNotification);
        orderProcessor.addNotification(pushNotification);

        orderProcessor.processOrder(order1);

        System.out.println("\n" + "=".repeat(50) + "\n");

        Order order2 = new Order();
        order2.addItem("Headphones", 1, 150.00);
        order2.addItem("Phone Case", 1, 20.00);
        order2.setCustomerEmail("another@example.com");

        Payment paypalPayment = new PayPalPayment("user@paypal.com");
        Delivery pickupDelivery = new PickUpPointDelivery("Pickup Point #5, Mall");

        order2.setPaymentMethod(paypalPayment);
        order2.setDeliveryMethod(pickupDelivery);

        OrderProcessor orderProcessor2 = new OrderProcessor();
        orderProcessor2.addNotification(new EmailNotification("another@example.com"));

        orderProcessor2.processOrder(order2);

        System.out.println("\n" + "=".repeat(50) + "\n");

        System.out.println("=== Adding New Payment Method ===");
        Payment newPayment = new CryptocurrencyPayment("BTC_Address_123");
        Order order3 = new Order();
        order3.addItem("Book", 1, 30.00);
        order3.setPaymentMethod(newPayment);
        order3.setDeliveryMethod(new PostDelivery("456 Oak St"));

        orderProcessor.processOrder(order3);
    }
}

class CryptocurrencyPayment implements Payment {
    private String walletAddress;

    public CryptocurrencyPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing cryptocurrency payment of $" + amount +
                " to wallet: " + walletAddress);
    }
}