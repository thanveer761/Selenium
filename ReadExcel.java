package week5.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
public static String[][] excelData (String fileName) throws IOException {
	XSSFWorkbook wb = new XSSFWorkbook("./data/"+ fileName +".xlsx");
	XSSFSheet sheet = wb.getSheet("sheet1");
	//to find the number of rows without using header row
	int rowCount = sheet.getLastRowNum();
	//System.out.println(rowCount);
	
	int cellCount = sheet.getRow(0).getLastCellNum();
	//declare 2d array 
	String[][] data = new String[rowCount][cellCount];
	
	for (int i = 1; i <=rowCount; i++) {
		for (int j = 0; j <cellCount; j++) {
			String cellValue = sheet.getRow(i).getCell(j).getStringCellValue();
			data[i-1][j]=cellValue;
			
		//System.out.println(cellValue);
		}}
			
			return data;
		}

}
