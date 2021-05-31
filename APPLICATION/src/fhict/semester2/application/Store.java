package fhict.semester2.application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Store {

    private final String storeName;
    private List<Medicine> medicineList;

    private final DataToExport dataWriter;
    private final DataFromImport dataReader;

    public Store(String storeName, DataToExport dataWriter, DataFromImport dataReader)
            throws IOException {
        this.storeName = storeName;

        medicineList = new ArrayList<>();

        this.dataWriter = dataWriter;
        this.dataReader = dataReader;

        importMedicineList();
    }


    //Uitzoeken of Edum een toevoeging is om ipv return Null een andere waarde terug te geven
    public Boolean addMedicine(Medicine medicine) throws IOException {
        if(findMedicine(medicine.getNumber()) >0){
            return false;
        }
        medicineList.add(medicine);
        writeData();
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

    public void writeData() throws IOException{
        dataWriter.writeDataToCSVFile(medicineList);
    }

    private void importMedicineList() throws IOException {
            medicineList.addAll(dataReader.readDataFromImportCSV());
    }


}
