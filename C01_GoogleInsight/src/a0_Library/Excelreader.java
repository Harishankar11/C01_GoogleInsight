package a0_Library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Excelreader {
	
	public static File file;
	public static FileInputStream FIS;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static Row r;
	public static Cell c;
	public static XSSFCellStyle my_style;
	
	
	public void excelPath(String Path)
	{
		try
		{
	
		file = new File(Path);
		
		FIS = new FileInputStream(file);
		
		wb = new XSSFWorkbook(FIS);
					
		}catch(Exception excel1)
		{
			System.out.println("Error in excel reader" + excel1.getMessage());
		}
		
	}
	
	public String getExcelSheetData(int sheetindex, int row, int column)
	{
		sheet = wb.getSheetAt(sheetindex);
		
		String values = sheet.getRow(row).getCell(column).getStringCellValue();
		
		return values;

	}
	public void putExcelSheetData(int sheetindex, int row, int column, String Writedata)
	{
		sheet = wb.getSheetAt(sheetindex);
		
		sheet.getRow(row).createCell(column).setCellValue(Writedata);
		
		try {
			
			fos = new FileOutputStream(file);
			
			wb.write(fos);
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
		
		

	}
	
	public int Sheetrowcount(int sheetindex)
	{
	
		sheet = wb.getSheetAt(sheetindex);
		
		int rowcount = sheet.getLastRowNum();
		
		
		return rowcount;
		
	}
	public int Sheetcolumncount(int sheetindex)
	{
	
		sheet = wb.getSheetAt(sheetindex);
		
			r = sheet.getRow(0);
		 int columncount=  r.getLastCellNum();

		return columncount;
		
	}

}
