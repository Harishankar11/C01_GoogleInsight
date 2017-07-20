package ingishts;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Programs {
	
	
	
	
	public static void main(String []args)
	{
		
		
		/*febanocci();
		prime();*/
		//Palindrom();
		/*factorial();*/
		//amstrong();
		sample();
	}
	
	
	public static void sample()
	{
		System.getProperty("webdriver.chrome.driver", "D:\\Harishankar\\Workplace\\B01_UserDashboardWeb\\Files\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www4.sulekha.com/");
		
		System.out.println(driver.getTitle());
	}

	public void test()
	{
		WebDriver driver = new FirefoxDriver();
		
		Alert alret = driver.switchTo().alert();
		alret.accept();
		alret.dismiss();
		alret.getText();
		String mainwin = driver.getWindowHandle();
		
		Set<String> s1 = driver.getWindowHandles();
		
		Iterator<String> it = s1.iterator();
		
		while(it.hasNext())
		{
			String child = it.next();
			if(!mainwin.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				
			}
		}
		driver.switchTo().window(mainwin);
	}
	
	/*
	Input: 10

	Output: 0 1 1 2 3 5 8 13 21 34

	*/public static void febanocci()
	{
		System.out.println("Enter the number : ");
		
		Scanner s1 = new  Scanner(System.in);
		
		
		int r = s1.nextInt();
		
		
		int i=0,a=0,b=0,c=1;
		
		System.out.print(b+" ");
		System.out.print(c+" ");
		
		while(i<r)
		{
			
	
			a = b + c;
			
			b=c;
			
			c=a;
			
			System.out.print(a+" ");

			
			i++;
		}
		
		
		
	}
	
	public static void prime()
	{
		System.out.println("Enter the name");
		Scanner s1 = new Scanner(System.in);
		int r1 = s1.nextInt();
		
		if(r1%2==0)
		{
			System.out.println("It a prime");
			
		} else {
			System.out.println("Not prime");
		}
		
		
		
	}

	public static void Palindrom(){  
		 
		  int r,sum=0,temp;    
		  int n=12321;//It is the number variable to be checked for palindrome  
		  temp=n;
		  while(n>0)
		  {
			  r=n%10;
			  sum = (sum*10)+r;
			  n=n/10;
		  }
		   
		  if(temp==sum)    
		   System.out.println("palindrome number ");    
		  else    
		   System.out.println("not palindrome");    
		}  
		
	public static void factorial(){ 
	
		int a,b=5,temp=1;
		
		for(a=1;a<=b;a++)
		{
			temp=temp*a;
			
		}
	
		System.out.println(temp);
	}
	
	public static void amstrong(){  
		 
		  int r,sum=0,temp;    
		  int n=371;//It is the number variable to be checked for palindrome  
		  temp=n;
		  while(n>0)
		  {
			  r=n%10;
			  n=n/10;
			  sum = sum + (r*r*r);
			  
		  }
		   
		  if(temp==sum)    
		   System.out.println("amstrong number ");    
		  else    
		   System.out.println("not amstrong");    
		}  
	
}
