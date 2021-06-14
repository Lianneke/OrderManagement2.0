package fhict.semester2.view;

import fhict.semester2.application.DiscountExpirationDate;
import fhict.semester2.application.Pharmacy;

import java.io.IOException;

public class Main  {


    private static Pharmacy pharmacy;
    private static DiscountExpirationDate discountExpirationDate;


    public static void main(String[] args) throws IOException{
        pharmacy = new Pharmacy("CZE");
        discountExpirationDate = new DiscountExpirationDate();
        OrderManagementUI orderManagementUI = new OrderManagementUI(pharmacy, discountExpirationDate);
        orderManagementUI.startUI();

    }

}
