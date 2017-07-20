package googleinshght;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.CellStyle;

import org.apache.poi.ss.usermodel.IndexedColors;

import org.testng.annotations.Test;

import a0_Library.Excelreader;

public class GoogleInsight extends Excelreader{

	@Test
	public void readdata() throws IOException, InterruptedException
	{

		Excelreader obj1 = new Excelreader();
		
		obj1.excelPath("./Excel/GoogleInsights.xlsx");
		
		System.out.println("Total excel row count : "+obj1.Sheetrowcount(0));
		
		System.out.println("Total excel row count : "+obj1.Sheetrowcount(1));
		
		//System.out.println("Total excel row count : "+obj1.Sheetcolumncount(0));
		
		
		for(int i=1;i<=obj1.Sheetrowcount(0);i++)
		{
			int k=2;
			
			if(i%2==0)
			{
				GoogleReport.browserToUrl();
			} else{
			
				GoogleReport.browserToUrlfirefox();
			}
			try{  //if any issue in write excel the column will be blank script dont stop
			
				
			for(int j=0;j<=obj1.Sheetrowcount(1);j++)
			{
				String SulekhaURL = obj1.getExcelSheetData(0, i, 1)+obj1.getExcelSheetData(1, j, 0);
				
				System.out.println(SulekhaURL);
				
				//GoogleReport.browserToUrl();
				
				List<String> a1 = GoogleReport.googleinsight(SulekhaURL);
				
				if(a1.size()<2)
				{
					a1.remove(0);
					a1.add(0, "1");
					a1.add(1, "1");
				}
				
				for(String e : a1)
				{
					
					int result = Integer.parseInt(e);
					
						my_style = wb.createCellStyle();
					 my_style.setAlignment(my_style.ALIGN_CENTER);
					 
					
					sheet = wb.getSheetAt(0);
					
					//sheet.getRow(i).createCell(k).setCellValue(result);
					
					r = sheet.getRow(i);
	        		
	        		c = r.createCell(k);
	        		
	        		if(result>=85 && result<100)
	        		{
	        			my_style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
	        			my_style.setFillPattern(CellStyle.SOLID_FOREGROUND);
	        		} else if(result>=75 && result<85)
	        		{
	        			my_style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
	        			my_style.setFillPattern(CellStyle.SOLID_FOREGROUND);
	        		} else if(result>=60 && result<75){
	        			my_style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
	        			my_style.setFillPattern(CellStyle.SOLID_FOREGROUND);
	        		} else {
	        			my_style.setFillForegroundColor(IndexedColors.RED.getIndex());
	        			my_style.setFillPattern(CellStyle.SOLID_FOREGROUND);
	        		}
	        		
	        		c.setCellValue(result);

	        		c.setCellStyle(my_style); 
					
		
					   
					k++;
					
					System.out.println(result);
				}
				
				
				
				fos = new FileOutputStream(file);
				
				wb.write(fos);
				

			}
				} catch(Exception ie2)
					{
						System.out.println("Issue in write the sheet : " + ie2);
					}
			
			GoogleReport.close();
			
			if(i%3==0)
			{
				for(int h=1;h<=100;h++)
				{
					Thread.sleep(4000);
					Thread.sleep(3000);
				
				}
			}
		
		
		}
		
		wb.close();

	}
	
}
