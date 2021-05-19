import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Store {

    private final String storeName;
    private List<Medicine> medicineList;

    public Store(String storeName) {
        this.storeName = storeName;

        medicineList = new ArrayList<>();
    }


    //Uitzoeken of Edum een toevoeging is om ipv return Null een andere waarde terug te geven
    public Boolean addMedicine(Medicine medicine){
        if(findMedicine(medicine.getNumber()) >0){
            return false;
        }
        medicineList.add(medicine);
        return true;
    }

    private int findMedicine(Medicine medicine) {
        return this.medicineList.indexOf(medicine);
    }

    private int findMedicine(String medicineNumber) {
        for(int i=0; i<this.medicineList.size(); i++) {
            Medicine medicine = this.medicineList.get(i);
            if(medicine.getNumber().equals(medicineNumber)) {
                return i;
            }
        }
        return -1;
    }

    public Medicine queryMedicine(String number) {
        int position = findMedicine(number);
        if(position >=0) {
            return this.medicineList.get(position);
        }

        return null;
    }

    public List<Medicine> getMedicineList(){
        return Collections.unmodifiableList(medicineList);
    }

}
