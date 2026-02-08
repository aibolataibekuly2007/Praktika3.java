public interface DiscountStrategy {
    double calculateDiscount(double subtotal, Order order);
}