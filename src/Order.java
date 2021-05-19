import java.util.ArrayList;
import java.util.List;

public class Order {

    private Customer customer;
    private long orderNumber;
    private List<OrderLine> orderLineList;

    public Order(Customer customer, long orderNumber) {
        this.customer = customer;
        this.orderNumber = orderNumber;

        orderLineList = new ArrayList<>();
    }
}
