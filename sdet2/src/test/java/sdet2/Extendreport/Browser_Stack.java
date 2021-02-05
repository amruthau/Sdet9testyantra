package sdet2.Extendreport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Browser_Stack  {
	public static final String USERNAME = "amruthau1";
	public static final String AUTOMATE_KEY = "yqLr5zkcreJyyHhsCLSz";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    public void main (String[]args) throws Exception {
	DesiredCapabilities caps = new DesiredCapabilities();
    
	caps.setCapability("os", "Windows");
	caps.setCapability("os_version", "10");
	caps.setCapability("browser", "Chrome");
	caps.setCapability("browser_version", "80");
	caps.setCapability("name", "amruthau1's First Test");
	
	WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
	driver.get("http://www.google.com");
	 WebElement google = driver.findElement(By.name("q"));
	google.sendKeys("facebook.com");
	
	
	driver.quit();
}
}