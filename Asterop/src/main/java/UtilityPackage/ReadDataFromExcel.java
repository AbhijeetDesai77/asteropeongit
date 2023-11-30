package UtilityPackage;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadDataFromExcel {

    public Object[][] readExcel() throws EncryptedDocumentException, IOException {

        try (FileInputStream fis = new FileInputStream("C:\\Users\\Dell\\Downloads\\readdata.xlsx")) {
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheetAt(0);

            int LRN = sheet.getLastRowNum();
            int LCN = sheet.getRow(0).getLastCellNum(); // Assuming all rows have the same number of cells

            System.out.println("Total Rows: " + LRN);
            System.out.println("Total Columns: " + LCN);

            DataFormatter dataFormatter = new DataFormatter();

            List<Object[]> testData = new ArrayList<>();

            for (int i = 1; i <= LRN; i++) {
                Row celldata = sheet.getRow(i);

                Cell usernameCell = celldata.getCell(0);
                Cell passwordCell = celldata.getCell(1);

                String username = dataFormatter.formatCellValue(usernameCell);
                String password = dataFormatter.formatCellValue(passwordCell);

                testData.add(new Object[]{username, password});
            }

            return testData.toArray(new Object[0][0]);
        }
    }
}
