import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final String customerID;
    private String name;
    private String address;
    private String telephoneNumber;
    private String email;
    private List<Order> orderList;

    public Customer(String customerID, String name, String address, String telephoneNumber, String email) {
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.email = email;

        orderList = new ArrayList<>();
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID='" + customerID + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", orderList=" + orderList +
                '}';
    }
}
