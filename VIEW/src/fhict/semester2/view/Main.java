package fhict.semester2.view;

import fhict.semester2.application.Pharmacy;

import java.io.IOException;

public class Main  {


    private static Pharmacy pharmacy;


    public static void main(String[] args) throws IOException{
        pharmacy = new Pharmacy("CZE");
        OrderManagementUI orderManagementUI = new OrderManagementUI(pharmacy);
        orderManagementUI.startUI();

    }

}
