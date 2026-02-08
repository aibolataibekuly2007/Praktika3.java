public class CourierDelivery implements Delivery {
    private String address;

    public CourierDelivery(String address) {
        this.address = address;
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("Delivering order #" + order.getOrderId() +
                " by courier to: " + address);
    }
}