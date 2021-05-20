import java.util.ArrayList;
import java.util.Collections;
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

//Uitzoeken of Edum een toevoeging is om ipv return Null een andere waarde terug te geven
    public boolean addCharge(Charge charge){
        if(findCharge(charge.getChargeNumber()) >0){
            return false;
        }
        chargeList.add(charge);
        return true;
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

    public Charge queryCharge(String number) {
        int position = findCharge(number);
        if(position >=0) {
            return this.chargeList.get(position);
        }

        return null;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getNumber() {
        return number;
    }

    public List<Charge> getChargeList(){
        return Collections.unmodifiableList(chargeList);
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
