package Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData 
{
	public static String getExcelData(int rowNo, int columnNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\seleniumPractice\\MavenTestNG_PracticeProject\\ExcelData\\logindata.xlsx");
		Workbook w1=WorkbookFactory.create(file);
		
		String CellData=w1.getSheet("login").getRow(rowNo).getCell(columnNo).getStringCellValue();
		return CellData;
	}
}
