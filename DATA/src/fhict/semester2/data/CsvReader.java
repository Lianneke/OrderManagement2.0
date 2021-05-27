package fhict.semester2.data;

import fhict.semester2.application.DataFromImport;
import fhict.semester2.application.Medicine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvReader implements DataFromImport {

    private final ArrayList<Medicine> medicineList;
    private final String fileName;

    public CsvReader(String fileName) {
        medicineList = new ArrayList<>();

        this.fileName = fileName + ".csv";
    }

    public ArrayList<Medicine> readDataFromImportCSV()throws IOException{
        String row;
        String[] data;
        Medicine dataInput;

        File csvFile = new File(fileName);

        if(csvFile.isFile()){
            BufferedReader csvReader= new BufferedReader(new FileReader(fileName));
            while ((row = csvReader.readLine()) != null){
                data = row.split(",");

                dataInput = new Medicine(data[1], data[2], Double.parseDouble(data[3]));
                medicineList.add(dataInput);
            }
            try {
                csvReader.close();
            }catch (IOException ex){
                ex.printStackTrace();
            }

        }
        return medicineList;
    }



}
