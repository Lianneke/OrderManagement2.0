package fhict.semester2.data;

import fhict.semester2.application.DataToExport;
import fhict.semester2.application.Medicine;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter implements DataToExport {
    public final String fileName;

    public CsvWriter(String fileName){
        this.fileName = fileName + ".csv";
    }

    @Override
    public void writeDataToCSVFile(List<Medicine> medicineList) throws IOException {
        FileWriter csvWriter = new FileWriter(fileName);
        for(Object data : medicineList){
            csvWriter.append(data.toString());
            csvWriter.append("\n");
        }
        csvWriter.flush();
            csvWriter.close();
    }
}
