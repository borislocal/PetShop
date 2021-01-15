package animal.model;

import java.util.List;

public class Order {

    private long orderId;
    private List<Long> animalsInOrder;
    private double total;

    public Order() {

    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public List<Long> getAnimalsInOrder() {
        return animalsInOrder;
    }

    public void setAnimalsInOrder(List<Long> animalsInOrder) {
        this.animalsInOrder = animalsInOrder;
    }


}
