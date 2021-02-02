package sdet2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test

public class makemytriptestng extends baseclass
{
	{//open the browser
	   WebDriver driver = new ChromeDriver();
	   
	   //Maximize the browser
	   driver.manage().window().maximize();
	
	   //Enter the URL
	   driver.get("http://www.makemytrip.com");
	   driver.findElement(By.xpath("//p[@data-cy = 'submit']/a[text() = 'Search']")).click();
	  
	  driver.findElement(By.xpath(" //div[@aria-label= 'Sunday, 24 January 2021']/../..//div[@class = 'DayPicker-Week'][4]")).submit();
	  driver.findElement(By.xpath("//span[@for = 'fromCity']")).click();
	  driver.findElement(By.xpath("//input[@id = 'departure']")).click();
	  driver.findElement(By.xpath("//input[@class = 'react-autosuggest__input react-autosuggest__input--open']")).sendKeys("PNQ");
	   System.out.println("done");
	   
}
}
