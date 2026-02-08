public class PickUpPointDelivery implements Delivery {
    private String pointAddress;

    public PickUpPointDelivery(String pointAddress) {
        this.pointAddress = pointAddress;
    }

    @Override
    public void deliverOrder(Order order) {
        System.out.println("Order #" + order.getOrderId() +
                " ready for pickup at: " + pointAddress);
    }
}