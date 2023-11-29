package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHandling {
	
public static String [][] excelData () throws IOException  {
	//public static void main (String [] args) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\anika\\eclipse-workspace-2023\\RealSelenium\\src\\testdata\\testdata.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook (fis);
		
		XSSFSheet sh = wb.getSheet("Sheet1");
			
		System.out.println(wb.getNumberOfSheets());

		int rowcount = sh.getPhysicalNumberOfRows();
		System.out.println(rowcount);
		
		int columnCount = sh.getRow(0).getPhysicalNumberOfCells();
		System.out.println(columnCount);
		
		DataFormatter df = new DataFormatter();
		
		String [] []credential = new String [rowcount][columnCount];
		
		
		
for (int i=0;i <rowcount ;i++) {
			
			for (int j=0;j <columnCount ;j++) {
			
				credential [i][j] = sh.getRow(i).getCell(j).getStringCellValue();
				
				
		
			System.out.print( credential[i][j]);
			
			System.out.print("  ");
			
			}
			
			System.out.println("  ");
				}
return credential;


}
}
