package sdet2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class vtigercreatelead extends baseclass {

	@Test
	public void createlead() {
		WebDriver driver = new ChromeDriver();
		//login to vtiger
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		// click on leads 
		driver.findElement(By.linkText("Leads")).click();
		
		//create new lead
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src = 'themes/softed/images/btnL3Add.gif']")));
		
			driver.findElement(By.xpath("//img[@src = 'themes/softed/images/btnL3Add.gif']")).click();
			
		//enter the details
			
			driver.findElement(By.name("lastname")).sendKeys("amrutha");
			driver.findElement(By.name("company")).sendKeys("axis");
			driver.findElement(By.xpath("//input[@class = 'crmbutton small save']")).click();
			// click on lead 
			driver.findElement(By.linkText("Leads")).click();
			driver.findElement(By.xpath("driver.findElement(By.xpath(\"//input[@class = 'crmbutton small save']\")).click();")).click();
			
			

		

	}

}
