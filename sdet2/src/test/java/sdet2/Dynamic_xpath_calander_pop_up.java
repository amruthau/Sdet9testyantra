package sdet2;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import com.crm.autodesk.genericlib.JavaUtils;

public class Dynamic_xpath_calander_pop_up extends baseclass  {
	JavaUtils javalib = new JavaUtils();
	
	@Test
	public void bookticket() throws InterruptedException
	
	{
		String date = javalib.getDate();
	int month = javalib.getMonthInt();
	String year = javalib.getCurrentYear();
	

		WebDriver driver = new FirefoxDriver();
		driver .get("https://www.cleartrip.com/");
		  driver.findElement(By.id("FromTag")).sendKeys("BLR");
		  Thread.sleep(10000);
		  driver.findElement(By.id("ui-id-12")).click();		  
		  driver.findElement(By.id("ToTag")).sendKeys("GOI");
		  driver.findElement(By.xpath("//a[text() = 'Goa, IN - Dabolim Airport (GOI)']")).click();
		  
		//  xpath("//a[text() = 'Bangalore, IN - Kempegowda International Airport (BLR)']")
           driver.findElement(By.xpath("//td[@data-month ="+month+" and @data-year='"+year+"']/a[text()='"+date+"']")).click();
		  
		  driver.close();

}
}
