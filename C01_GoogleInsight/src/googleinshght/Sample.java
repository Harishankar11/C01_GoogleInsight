package googleinshght;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import a0_Library.Excelreader;

public class Sample extends Excelreader {
	
	@Test
	public void add1() throws InterruptedException, IOException 
	{
		
		excelPath("./Excel/GoogleInsights.xlsx");
		
		sheet = wb.getSheet("Sheet1");
		
		sheet.getRow(0).createCell(1).setCellValue("Harish");
		
		FileOutputStream fos = new FileOutputStream(file);
		
		wb.write(fos);
		
		wb.close();
		
		
	}
	
	
	//@Test
	public void add() throws InterruptedException 
	{
	WebDriver driver = new FirefoxDriver();
	
	driver.get("http://lsapilistings.sulekha.com/apiv2/Businesses/CampaignPackages/10140828/0");
	Thread.sleep(1000);
	String s1 = driver.findElement(By.xpath("html/body")).getText();
	Thread.sleep(1000);
	System.out.println(s1);
	
	if(s1.contains("\"tenure\":30"))
	{
		System.out.println("Pass");
	}else {
		System.out.println("Fail");
	}
	
	
	String[] words= s1.split(",");  
	//using java foreach loop to print elements of string array  
	for(String w:words){  
		
		if(w.contains("packagename"))
		{
			String[] value = w.split(":");
			System.out.println(value[1]);
			break;
		}
		
	//System.out.println(w);  
	}  
	
	
	
	
	
	
	}
}
