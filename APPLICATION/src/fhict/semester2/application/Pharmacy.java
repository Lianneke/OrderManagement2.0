package fhict.semester2.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pharmacy {

    private final String name;
    private List<Customer> customerList;
    private List<Order> orderList;
    private List<Medicine> medicineList;

    public Pharmacy(String name) {
        this.name = "CZE";

        customerList = new ArrayList<>();
        orderList = new ArrayList<>();
        medicineList = new ArrayList<>();
    }

    public boolean addCustomer(Customer customer){
        if(findCustomer(customer.getCustomerID()) >0){
            return false;
        }
        customerList.add(customer);
        return true;
    }


    private void addOrder(Order order){

        orderList.add(order);
    }


    private int findCustomer(String customerID){
        for(int i=0; i<this.customerList.size(); i++){
            Customer customer = this.customerList.get(i);
            if(customer.getCustomerID().equals(customerID)){
                return i;
            }
        }
        return -1;
    }

    public Customer queryCustomer(String customerID) {
        int position = findCustomer(customerID);
        if(position >=0) {
            return this.customerList.get(position);
        }

        return null;
    }


    public List<Customer> getCustomerList(){
        return Collections.unmodifiableList(customerList);
    }

    public List<Order> getOrderList(){
        return Collections.unmodifiableList(orderList);
    }


}
