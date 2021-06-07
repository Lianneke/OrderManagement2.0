package fhict.semester2.view;

import fhict.semester2.application.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class OrderManagementUI {

    private Pharmacy pharmacy;
    private Store store;
    private Scanner scanner;
    private DiscountExpirationDate discountExpirationDate;


    public OrderManagementUI(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public void startUI() throws IOException {
        welcomeMessage();
      //  printOptions();
    }

    private void welcomeMessage() throws IOException {
        System.out.println("Welcome to OrderManagement " + pharmacy.getName() + "\n");
        printOptions();
    }

    private void printOptions() throws IOException {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0 - exit\n" +
                "1 - Customer\n" +
                "2 - Employee\n");
        System.out.println("Choose your action: ");
        int choice = scanner.nextInt();
           scanner.nextLine();
        userOptions(choice);
    }

    private void userOptions(int choice) throws IOException {
        boolean quit = false;

        while (!quit) {
            System.out.println("\nEnter action: (1 to show available actions");

            switch (choice) {
                case 0:
                    System.out.println("bye!");
                    quit = true;
                    break;

                case 1:
                    printCustomerOptions();
                    int customerAction = scanner.nextInt();
                    scanner.nextLine();
                    switch (customerAction) {
                        case 0:
                            System.out.println("bye");
                            break;
                        case 1:
                            printData(store.getMedicineList());
                            break;
                        case 2:
                            searchCustomer();
                        default:
                            printCustomerOptions();

                    }
                    break;

                case 2:
                    printEmployeeOptions();
                    int employeeAction = scanner.nextInt();
                    scanner.nextLine();
                    switch (employeeAction) {
                        case 0:
                            System.out.println("bye");
                            break;
                        case 1:
                            printData(store.getMedicineList());
                            break;
                        case 2:
                            addNewMedicine();
                            break;
                        case 3:
                            printData(store.getMedicineList());
                            collectDataToSearchForMedicine();
                            break;
                        case 4:
                            addNewCustomer();
                            break;
                        case 5:
                            printData(pharmacy.getOrderList());
                        default:
                            printEmployeeOptions();
                    }
                    break;

                default:
                    printOptions();
                    break;
            }
        }
    }

        private void printCustomerOptions(){
            System.out.println("\nAvailable actions:\npress");
            System.out.println("0 - exit\n" +
                    "1 - show article overview\n" +
                    "2 - start to order\n");
            System.out.println("Choose your action: ");
        }

    private void printEmployeeOptions(){
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0 - exit\n" +
                "1 - show article overview\n" +
                "2 - add new medicine\n" +
                "3 - add new charge\n" +
                "4 - add new customer\n" +
                "5 - show order overview");
        System.out.println("Choose your action: ");
    }

    //Find a solution to generate a new ordernumber automatically
    private void createNewOrder(Customer customer){
        System.out.println("Enter date+time. Example 202105101229");
        long orderNumber = scanner.nextLong();
        Order newOrder = new Order(customer, orderNumber);
        order(newOrder);
    }

    private void searchCustomer(){
        printData(pharmacy.getCustomerList());
        System.out.println("Enter your customerID");
        String customerID = scanner.nextLine();

        Customer existingCustomerRecord = pharmacy.queryCustomer(customerID);

        if(existingCustomerRecord == null){
            System.out.println("Customer not found");
            return;
        }
        System.out.println("Welcome " + existingCustomerRecord.getName());

        createNewOrder(existingCustomerRecord);
    }

    private void addNewMedicine() throws IOException {
        System.out.println("Enter identificationnumber: ");
        String number = scanner.nextLine();
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter price: ");
        double price = scanner.nextDouble();

        Medicine newMedicine = new Medicine(number, name, price);

        if (store.addMedicine(newMedicine)) {
            System.out.println("New medicine added: number = " + newMedicine.getNumber() + ", name = " + newMedicine.getName() + ", price = " + newMedicine.getPrice());
        } else {
            System.out.println("Cannot add, " + newMedicine.getNumber() + " already on file");
        }
    }

    private void addNewCustomer(){
        System.out.println("Enter new customerID");
        String customerID = scanner.nextLine();
        System.out.println("Enter new customername: ");
        String name = scanner.nextLine();
        System.out.println("Enter new customeraddress ");
        String address = scanner.nextLine();
        System.out.println("Enter new telephonenumber: ");
        String telephonenumber = scanner.nextLine();
        System.out.println("Enter new emailaddress: ");
        String email = scanner.nextLine();

        Customer newCustomer = new Customer(customerID, name, address, telephonenumber, email);

        if (pharmacy.addCustomer(newCustomer)) {
            System.out.println("New customer added: customerID = " + customerID + ", name = " + name + ", address = " + address + ", telephonenumber = " + telephonenumber + ", email = " + email);
        } else {
            System.out.println("Cannot add, " + name + " already on file");
        }
    }

    private void collectDataToSearchForMedicine(){
        System.out.println("Enter identificationnumber: ");
        String number = scanner.nextLine();
        searchMedicine(number);
    }

    private void searchMedicine(String number) {
        Medicine existingMedicineRecord = store.queryMedicine(number);
        if (existingMedicineRecord == null) {
            System.out.println("You made a mistake when entering the medicine number, please try again");
            return;
        }
        addNewCharge(existingMedicineRecord);
    }

    private void addNewCharge(Medicine medicine) {
        System.out.println("Enter new chargenumber: ");
        String chargeNumber = scanner.nextLine();
        System.out.println("Enter expiration date\n" +
                "Please use the following format: yyyy-mm-dd");
        String date = scanner.nextLine();
        LocalDate expirationDate = LocalDate.parse(date);
        System.out.println("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        Charge newCharge = new Charge(chargeNumber, expirationDate, quantity);

        if (medicine.addCharge(newCharge)) {
            System.out.println("New charge added: chargenumber = " + newCharge.getChargeNumber() + ", expirationDate = " + newCharge.getExpirationDate() + ", quantity = " + newCharge.getQuantity());
        } else {
            System.out.println("Cannot add, " + newCharge.getChargeNumber() + "already on file");
        }
    }

    private void order(Order order) {

        while (true) {
            System.out.println("Enter 1 to add a new orderline, enter 2 to quit");
            int input = scanner.nextInt();
            scanner.nextLine();

            if (input == 2) {
                printData(order.getOrderLines());
                pharmacy.addOrder(order);
                break;
            } else {

                printData(store.getMedicineList());

                System.out.println("Enter medicineID");
                String medicineNumber = scanner.nextLine();

                Medicine existingMedicineRecord = store.queryMedicine(medicineNumber);

                if (existingMedicineRecord == null) {
                    System.out.println("medicine not found");
                    return;
                }
                printData(existingMedicineRecord.getChargeList());

                System.out.println("Enter chargeID");
                String chargeNumber = scanner.nextLine();

                Charge existingChargeNumber = existingMedicineRecord.queryCharge(chargeNumber);

                if (existingChargeNumber == null) {
                    System.out.println("fhict.semester2.application.Charge not found");
                    return;
                }

                System.out.println("Let's check if you've god some discount today");
                double discountAvailable = discountExpirationDate.checkIfListIsQualifiedForDiscount(existingChargeNumber, existingMedicineRecord);
                double price;

                if (discountAvailable == 0.0) {
                    System.out.println("No discount today!!\n");
                    price = existingMedicineRecord.getPrice();
                    System.out.println("You pay the normal price: " + price + "\n");
                }else{
                    System.out.println("Woehoew! You god your self some discount!!\n");
                    price = discountAvailable;

                    System.out.println("The normal price is: " + existingMedicineRecord.getPrice() + "The discount price is: " + price + "\n");
                }

                System.out.println("How many pieces do you want to order?");
                int pieces = scanner.nextInt();

                boolean quantitycheck = existingChargeNumber.checkAndSetQuantity(pieces);

                if (!quantitycheck) {
                    System.out.println("We don't have enough of this charge in our store, please try again");
                    return;
                }
                OrderLine newOrderLine = new OrderLine(existingMedicineRecord, existingChargeNumber, pieces, price);

                order.addNewOrderLine(newOrderLine);
            }
            System.out.println(order.getOrderLines());

        }


    }

    private void printData(List printableList) {
        int number = 0;
        if (printableList.isEmpty()) {
            System.out.println("List is empty");
        } else {
            for (Object printData : printableList) {
                System.out.println(number + ". " + printData.toString());
                number = number + 1;
            }
        }
    }

    }




