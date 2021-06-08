package mock;

import fhict.semester2.application.DataFromImport;
import fhict.semester2.application.Medicine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedicineListReaderMock implements DataFromImport {
    private List<Medicine> medicineListMock;

    public MedicineListReaderMock() {
        medicineListMock = new ArrayList<>();
        medicineListMock.add(new Medicine("123", "paracetamol", 2.00));
        medicineListMock.add(new Medicine("456", "morfine", 3.50));
        medicineListMock.add(new Medicine("789", "ibuprofen", 1.00));
    }


    @Override
    public List<Medicine> readDataFromImportCSV() throws IOException {
        return Collections.unmodifiableList(medicineListMock);
    }
}
