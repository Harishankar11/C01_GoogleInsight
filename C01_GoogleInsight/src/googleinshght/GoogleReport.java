package googleinshght;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleReport {
	
	public static WebDriver driver;
	
	public static void browserToUrl()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Harishankar\\Harish\\Jar files\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("https://developers.google.com/speed/pagespeed/insights/");
		
		driver.manage().window().maximize();
	}
	public static void browserToUrlfirefox()
	{
		//System.setProperty("webdriver.gecko.driver", "D:\\Harishankar\\Harish\\Jar files\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		
		driver.get("https://developers.google.com/speed/pagespeed/insights/");
		
		driver.manage().window().maximize();
	}
	
	public static void close()
	{
		driver.close();
		
	}
	
	public static List<String> googleinsight(String url) throws InterruptedException
	{
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//URL text box
		driver.findElement(By.xpath("//input[@name='url']")).clear();
		
		driver.findElement(By.xpath("//input[@name='url']")).sendKeys(url);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//analysis button
		driver.findElement(By.xpath("//div[@role='button']")).click();
		
		Thread.sleep(6000);
		Thread.sleep(3000);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//mobile data
		
		List<WebElement> elements = driver.findElements(By.xpath("//p[@class='result-group-title-card-score']/span"));
		
		
		List<String> currentOptions = new ArrayList<String>();
		
		for(WebElement ele : elements)
		{
			currentOptions.add(ele.getAttribute("innerText"));
			//System.out.println(ele.getAttribute("innerText"));
			
		}

		return currentOptions; 
		
	}
	

}
