package ingishts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class SanityUpdate {
	
	@Test(enabled=true)
	public void insight()
	{
		try {
			
			 
		File scr = new File("D:\\Harish\\GoogleInsight\\Excel\\GoogleInsight.xlsx");
		
		FileInputStream fis = new FileInputStream(scr);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = wb.getSheetAt(0);
		
		int sheetcount = sheet.getLastRowNum();
		
		sheetcount = sheetcount+1;
		
		for(int i=1;i<=sheetcount;i++)
		{
			
		
			String url = sheet.getRow(i).getCell(1).getStringCellValue();
			
			String[] t1 = SanityUpdate.googleinsight(url);
			
			System.out.println(t1[0]);
			
			sheet.getRow(i).createCell(2).setCellValue(t1[0]);
			
			System.out.println(t1[1]);
			
			sheet.getRow(i).createCell(3).setCellValue(t1[1]);
			
			FileOutputStream fos = new FileOutputStream(scr);
			
			wb.write(fos);
			
			String url1 = sheet.getRow(i).getCell(4).getStringCellValue();
			
			String[] t2 = SanityUpdate.googleinsight(url1);
			
			System.out.println(t2[0]);
			
			sheet.getRow(i).createCell(5).setCellValue(t2[0]);
			
			System.out.println(t2[1]);
			
			sheet.getRow(i).createCell(6).setCellValue(t2[1]);
			
			FileOutputStream fos1 = new FileOutputStream(scr);
			
			wb.write(fos1);
			
		
		}
		
		wb.close();
		
		} catch (Exception e) {
		
		System.out.println(e.getMessage());
		}
		
	}
	
	public static String[] googleinsight(String url)
	{
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://developers.google.com/speed/pagespeed/insights/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//URL text box
		driver.findElement(By.xpath("//input[@name='url']")).sendKeys(url);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//analysis button
		driver.findElement(By.xpath("//div[@role='button']")).click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//mobile data
		String s1 = driver.findElement(By.xpath("//div[@role='button']/following::p[2]")).getText();	
		
		//System.out.println(url);
		
		//System.out.println(s1);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//next tab
		driver.findElement(By.xpath("//div[@id=':l']")).click();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Desktop data
		String s2 = driver.findElement(By.xpath("//div[@role='button']/following::p[4]")).getText();	
		
		//System.out.println(s2);
		
		driver.close();
		
		
		return new String[] {s1, s2}; 
		
	}
	
	

}