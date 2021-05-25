package fhict.semester2.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {

    private Customer customer;
    private long orderNumber;
    private double totalPrice;
    private List<OrderLine> orderLineList;

    public Order(Customer customer, long orderNumber) {
        this.customer = customer;
        this.orderNumber = orderNumber;

        orderLineList = new ArrayList<>();
    }

    public void addNewOrderLine(OrderLine orderLine){
        orderLineList.add(orderLine);
    }

    public List<OrderLine> getOrderLines(){
        return Collections.unmodifiableList(orderLineList);
    }

    public double totalPriceOrder(){
        double priceCounter = 0;
        for(OrderLine readOrderLine:orderLineList) {
            priceCounter = priceCounter + (readOrderLine.getPrice() + readOrderLine.getQuantity());
        }
        return priceCounter;
    }



    //kijken of dit netjes onder elkaar gezet kan worden.
    @Override
    public String toString() {
        return "fhict.semester2.application.Order{" +
                "orderLineList=" + orderLineList +
                '}';
    }
}
