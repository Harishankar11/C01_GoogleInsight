package a0_Library;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;



import org.apache.poi.ss.usermodel.IndexedColors;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Excelcolor extends Excelreader {
	
	@Test
	public void color() throws Exception 
	{
		
		file = new File("./ExcelFiles/InsightUpdate.xlsx");
		
		
		FIS = new FileInputStream(file);
		
		wb = new XSSFWorkbook(FIS);
		
		wb.getSheetAt(0);
		
        /* Get access to XSSFCellStyle */
        my_style = wb.createCellStyle();
        
        /* We will now specify a background cell color */
        my_style.setFillPattern(XSSFCellStyle.FINE_DOTS );
         my_style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
         my_style.setFillBackgroundColor(IndexedColors.RED.getIndex());
         sheet = wb.getSheetAt(0);
         
    
         for(int i=0;i<=3;i++)
 		{
        	 for(int j=0;j<=3;j++)
 			{
        		 System.out.println("hari");
        		 
        		 
        		 System.out.println(i+" "+j);
        		 
        		r = sheet.getRow(i);
        		
        		c = r.createCell(j);
        		
        		c.setCellValue("Cell Fill Color Test");
        		c.setCellStyle(my_style); 
        		
        		
        		 
 			}
        	 

             fos = new FileOutputStream(file);
             wb.write(fos);
 		}
        
        
       
        
        
		
		
		
		
		
        
	}

}





















/* Create Workbook and Worksheet XLSX Format 
XSSFWorkbook my_workbook = new XSSFWorkbook();
XSSFSheet my_sheet = my_workbook.createSheet("Cell Font");
 Get access to XSSFCellStyle 
XSSFCellStyle my_style = my_workbook.createCellStyle();

 We will now specify a background cell color 
my_style.setFillPattern(XSSFCellStyle.FINE_DOTS );
my_style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
my_style.setFillBackgroundColor(IndexedColors.RED.getIndex());

 Create a row in the sheet 
Row row = my_sheet.createRow(0);
 Create a cell 
Cell cell = row.createCell(0);
cell.setCellValue("Cell Fill Color Test");
 Attach the style to the cell 
cell.setCellStyle(my_style);
 Write changes to the workbook 
FileOutputStream out = new FileOutputStream(new File("./ExcelFiles/cell_fill_color.xlsx"));
my_workbook.write(out);
out.close();*/
