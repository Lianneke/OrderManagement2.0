package fhict.semester2.application;

import java.io.IOException;
import java.util.List;

public interface DataToExport {

    void writeDataToCSVFile(List<Medicine> medicineList) throws IOException;
}
