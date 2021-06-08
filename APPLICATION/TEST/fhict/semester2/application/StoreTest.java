package fhict.semester2.application;

import mock.MedicineListReaderMock;
import mock.MedicineListWriterMock;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class StoreTest {


    MedicineListReaderMock readerMock = new MedicineListReaderMock();
    MedicineListWriterMock writerMock = new MedicineListWriterMock();

    @Test
    public void writeData() throws IOException {
        Store store = new Store("testcze", writerMock, readerMock);
        store.writeData();

        assertEquals(writerMock.getMedicineListTest().get(1).toString(), store.getMedicineList().get(1).toString());


    }

    @Test
    public void readData() throws IOException {
        Store store = new Store("testcze", writerMock, readerMock);
        ArrayList<Medicine> medicineListMockTest = new ArrayList<>();

        Medicine medicine = new Medicine("123", "paracetamol", 2.00);
        Medicine medicine1 = new Medicine("456", "morfine", 3.50);
        Medicine medicine2 = new Medicine("789", "ibuprofen", 1.00);

        medicineListMockTest.add(medicine);
        medicineListMockTest.add(medicine1);
        medicineListMockTest.add(medicine2);

        store.addMedicine(medicine);
        store.addMedicine(medicine1);
        store.addMedicine(medicine2);

        assertEquals(medicineListMockTest.get(2).toString(), store.getMedicineList().get(2).toString());
    }
}