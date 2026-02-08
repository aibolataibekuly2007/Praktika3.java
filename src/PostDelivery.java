public class PostDelivery implements Delivery {
    private String address;

    public PostDelivery(String address) {
        this.address = address;
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("Delivering order #" + order.getOrderId() +
                " by post to: " + address);
    }
}