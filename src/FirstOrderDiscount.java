public class FirstOrderDiscount implements DiscountStrategy {
    private double discountAmount;

    public FirstOrderDiscount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public double calculateDiscount(double subtotal, Order order) {
        return order.getOrderId() == 1 ? discountAmount : 0;
    }
}