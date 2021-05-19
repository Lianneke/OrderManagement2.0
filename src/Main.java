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

//                case 2:
//                    printEmployeeOptions();
//                    break;

                default:
                    printOptions();
                    break;
            }
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
