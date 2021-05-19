import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    private final static Store store = new Store("CZE");
    private final static Pharmacy pharmacy = new Pharmacy("CZE");

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //Adding new medicines, so I can do some test while building this application
        store.addMedicine(new Medicine("123", "Paracetamol 500mg", 1.99));
        store.addMedicine(new Medicine("456", "Bupivacaine 0,25mg", 2.25));

        // Adding new customers, so I can do some test while buidling this application
        pharmacy.addCustomer(new Customer("1", "ETZ", "Teststraat 6", "06100000", "test@testmail.com"));
        pharmacy.addCustomer(new Customer("2", "MUMC", "teststraat 10", "06112112", "MUMC@testmail.nl"));

        boolean quit = false;
        printOptions();

        while (!quit){
            System.out.println("\nEnter action: (1 to show available actions");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("bye!");
                    quit = true;
                    break;

                case 1:
                    printCustomerOptions();
                    int customerAction = scanner.nextInt();
                    scanner.nextLine();
                    switch (customerAction){
                        case 0:
                            System.out.println("bye");
                            break;
                        case 1:
                            printData(store.getMedicineList());
                            break;
//                        case 2:
                        default:
                            printCustomerOptions();

                    }
                    break;

                case 2:
                    printEmployeeOptions();
                    int employeeAction = scanner.nextInt();
                    scanner.nextLine();
                    switch (employeeAction){
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

    private static void addNewMedicine() {
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

    private static void collectDataToSearchForMedicine(){
        System.out.println("Enter identificationnumber: ");
        String number = scanner.nextLine();
        searchMedicine(number);
    }

    private static void searchMedicine(String number) {
        Medicine existingMedicineRecord = store.queryMedicine(number);
        if (existingMedicineRecord.equals(null)) {
            System.out.println("You made a mistake when entering the medicine number, please try again");
            return;
        }
        addNewCharge(existingMedicineRecord);
    }

    private static void addNewCharge(Medicine medicine) {
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

    private static void addNewCustomer(){
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



    private static void printOptions(){
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0 - exit\n" +
                "1 - Customer\n" +
                "2 - Employee\n");
        System.out.println("Choose your action: ");
    }

    private static void printCustomerOptions(){
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0 - exit\n" +
                "1 - show article overview\n" +
                "2 - start to order\n");
        System.out.println("Choose your action: ");
    }

    private static void printEmployeeOptions(){
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0 - exit\n" +
                "1 - show article overview\n" +
                "2 - add new medicine\n" +
                "3 - add new charge\n" +
                "4 - add new customer");
        System.out.println("Choose your action: ");
    }

    private static void printData(List printableList) {
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
