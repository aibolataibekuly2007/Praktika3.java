import java.util.ArrayList;
import java.util.List;

public class DiscountCalculator {
    private List<DiscountStrategy> discountStrategies;

    public DiscountCalculator() {
        discountStrategies = new ArrayList<>();
    }

    public void addDiscountStrategy(DiscountStrategy strategy) {
        discountStrategies.add(strategy);
    }

    public double calculateDiscount(double subtotal, Order order) {
        double totalDiscount = 0;

        for (DiscountStrategy strategy : discountStrategies) {
            totalDiscount += strategy.calculateDiscount(subtotal, order);
        }

        return totalDiscount;
    }
}