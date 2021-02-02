package sdet2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.autodesk.genericlib.JavaUtils;

public class VtigerCreateQuote extends baseclass {
	
	@Test
	public void createquote() {
		WebDriver driver = new ChromeDriver();
		JavaUtils jLib = new JavaUtils();
		int randomNum = jLib.generateRandomNum();
		//login to vtiger
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//go to quotes
		driver.findElement(By.xpath("//img[@src = 'themes/softed/images/menuDnArrow.gif']")).click();
		driver.findElement(By.name("Quotes")).click();
		
		//create new quotes
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@title = 'Create Quote...']")));
		
		driver.findElement(By.xpath("//img[@title = 'Create Quote...']")).click();
		driver.findElement(By.name("subject")).sendKeys("sending quotes" + randomNum );
		driver.findElement(By.xpath("//input[@name = 'account_name']/following-sibling::img[@src = 'themes/softed/images/select.gif']")).click();
		driver.switchTo().frame("Accounts&action");
		
		driver.findElement(By.xpath("//tbody/tr[2]/td[1]/a[@id ='1']")).click();
		
	
	
	
	}
}
