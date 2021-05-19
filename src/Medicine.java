import java.util.ArrayList;
import java.util.List;

public class Medicine {

    private final String number;
    private final String name;
    private double price;

    private List<Charge> chargeList;

    public Medicine(String number, String name, double price) {
        this.number = number;
        this.name = name;
        this.price = price;

        chargeList = new ArrayList<>();
    }

    public Charge addCharge(Charge charge){
        if(findCharge(charge.getChargeNumber()) >0){
            return null;
        }
        chargeList.add(charge);
        return charge;
    }


    private int findCharge(String chargeNumber) {
        for(int i=0; i<this.chargeList.size(); i++) {
            Charge charge = this.chargeList.get(i);
            if(charge.getChargeNumber().equals(chargeNumber)) {
                return i;
            }
        }
        return -1;
    }





    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
