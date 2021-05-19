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



    public Medicine addMedicine(Medicine medicine){
        if(findMedicine(medicine.getNumber()) >0){
            return null;
        }
        medicineList.add(medicine);
        return medicine;
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

    public List<Medicine> getMedicineList(){
        return Collections.unmodifiableList(medicineList);
    }

}
