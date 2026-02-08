import java.util.List;

public class QuantityDiscount implements DiscountStrategy {
    private final int minQuantity;
    private final double discountAmount;

    public QuantityDiscount(int minQuantity, double discountAmount) {
        this.minQuantity = minQuantity;
        this.discountAmount = discountAmount;
    }

    @Override
    public double calculateDiscount(double subtotal, Order order) {
        int totalQuantity = 0;
        List<Order.OrderItem> items = order.getItems();

        for (Order.OrderItem item : items) {
            totalQuantity += item.getQuantity();
        }

        return totalQuantity >= minQuantity ? discountAmount : 0;
    }
}