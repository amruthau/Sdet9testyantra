package sdet2.Extendreport;



import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SeleniumGrid {
	
@Test(dataProvider ="dataname")
public void remoteExceution(Platform platform, String browserName) throws Throwable
{
	URL url=new URL("http://192.168.0.104:4444/wd/hub");
	DesiredCapabilities cap=new DesiredCapabilities();
	cap.setPlatform(platform);
	cap.setBrowserName(browserName);
	RemoteWebDriver driver = new RemoteWebDriver(url, cap);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("http://gmail.com");
}	
@DataProvider(name="dataname", parallel=true)
public Object[][] getdata()
{
	Object[][] testdata=new Object[][]
			{
		{Platform.WINDOWS,"chrome"},
		{Platform.WINDOWS,"firefox"}
			};
	return testdata;		}}
/*
public class gridExc {
public RemoteWebDriver driver;
@Test
public void remoteExc() throws MalformedURLException
{
	 URL url = new URL("http://192.168.43.103:4444/wd/hub");
	  DesiredCapabilities cap= DesiredCapabilities.chrome();
	  cap.setPlatform(Platform.WINDOWS);
	  cap.setBrowserName("chrome");
	  driver= new RemoteWebDriver(url, cap);
	  driver.get("http://gmail.com");
}
}*/

