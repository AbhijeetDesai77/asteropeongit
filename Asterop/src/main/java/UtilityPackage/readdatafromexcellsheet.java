package UtilityPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readdatafromexcellsheet {

	public Object[][] datafromexcel() throws EncryptedDocumentException, IOException {
		
		FileInputStream fis =new FileInputStream("C:\\Users\\Dell\\Downloads\\readdata.xlsx");
		
		Workbook workbook = WorkbookFactory.create(fis);
		
		Sheet sheet = workbook.getSheetAt(0);
		
		int LRN =sheet.getLastRowNum();

		short LCN = sheet.getRow(0).getLastCellNum();
		
		DataFormatter dataformater =new DataFormatter();
		
		List<Object[]> list=new ArrayList<>();
		
		for(int i=1;i<=LRN;i++) {

			Row celldata = sheet.getRow(i);

			Cell cellusername = celldata.getCell(0);
			Cell cellpassword = celldata.getCell(1);
			
			String username = dataformater.formatCellValue(cellusername);
			String password = dataformater.formatCellValue(cellpassword);
			
			list.add(new Object[] {username,password});
				
		}
		
	 return list.toArray(new Object[0][0]);
	}
	}


