package mock;

import fhict.semester2.application.DataToExport;
import fhict.semester2.application.Medicine;

import java.io.IOException;
import java.util.List;

public class MedicineListWriterMock implements DataToExport {

    private List<Medicine> medicineListTest;

    @Override
    public void writeDataToCSVFile(List<Medicine> medicineList) throws IOException {
        medicineListTest = medicineList;
    }

    public List<Medicine> getMedicineListTest(){
        return medicineListTest;
    }
}
