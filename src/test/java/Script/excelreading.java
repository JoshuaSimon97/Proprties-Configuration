package Script;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.Test;

public class excelreading {
  @Test
  public void f() throws IOException {
	 FileInputStream f =  new FileInputStream("C:\\Users\\Joshua Simon\\Desktop\\data.xlsx");
	 XSSFWorkbook workbook = new XSSFWorkbook(f);
	 XSSFSheet sheet = workbook.getSheet("Sheet1");
	 XSSFRow row = sheet.getRow(0);
	 XSSFCell cell = row.getCell(0);
	 int col_num = -1;
	 HashMap<String, String> data = new HashMap<String, String>();

     for(int i=0; i < row.getLastCellNum(); i++)
     {
         if(row.getCell(i).getStringCellValue().trim().equals("key")) {
         }
     }
	 
//	 for(int i =0; i<10; i++) {
//		 row = sheet.createRow(i);
//		 cell = row.createCell(0);
//		 cell.setCellValue("joshua");
//	 }CM
	 
//	 FileOutputStream fos = new FileOutputStream("C:\\Users\\Joshua Simon\\Desktop\\data.xlsx");
//	 workbook.write(fos);
//	 fos.close();
	 f.close();
	 
  }
}
