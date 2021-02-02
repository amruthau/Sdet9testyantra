package com.crm.autodesk.organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.genericlib.ExcelUtility;
import com.crm.autodesk.genericlib.FileUtility;
import com.crm.autodesk.genericlib.JavaUtils;
import com.crm.autodesk.genericlib.WebDriverUtiles;
import com.crm.autodesk.objectrrepositorylib.CreateNewOrganization;
import com.crm.autodesk.objectrrepositorylib.Home;
import com.crm.autodesk.objectrrepositorylib.Login;
import com.crm.autodesk.objectrrepositorylib.Organizations;

public class Createorganization_tc3 {
	JavaUtils jLib = new JavaUtils();
	WebDriverUtiles wLib = new WebDriverUtiles();
	FileUtility flib = new FileUtility();
	ExcelUtility eLib = new ExcelUtility();
	
	@Test
	public void createorganization() throws Throwable
	{
		/* Common Data */
		int randomNum = jLib.generateRandomNum();
		String USERNAME = flib.getPropertyKeyValue("username");
		String PASSWORD = flib.getPropertyKeyValue("password");
		String URL = flib.getPropertyKeyValue("url");
		String BROWSER = flib.getPropertyKeyValue("browser");

		/* test Data */
		String orgName = eLib.getExcelData("contact", "tc_01", "OrgName")+ randomNum;
		String orgType = eLib.getExcelData("contact", "tc_01", "orgType");
		String orgIndustry = eLib.getExcelData("contact", "tc_01", "Industry");
		String orgRating = eLib.getExcelData("contact", "tc_01", "rating");

		String contLastNAme = eLib.getExcelData("contact", "tc_01", "contactName") + randomNum;

		/* step 1 : login to APP */
		WebDriver driver = null;
		 if(BROWSER.equalsIgnoreCase("firefox")) {
		    driver= new FirefoxDriver();  
		 }else if(BROWSER.equalsIgnoreCase("chrome")) {
			 driver = new ChromeDriver();
		 }else if(BROWSER.equalsIgnoreCase("ie")) {
			 driver = new InternetExplorerDriver();
		 }
		 /*1	navigate to application*/
		wLib.waitForHTMLDOM(driver);
		driver.get(URL);

		/*2	login to application*/
		 Login lp = new Login(driver);
	      lp.loginToApp(USERNAME, PASSWORD);
	      
		/*3	navigate to organization*/
	      Home hp = new Home(driver);
	        hp.getOrgLnk().click();
		 
       /*4	"naviagate to ""create new organization""page by click on ""+"" image"*/
	        Organizations orgPage = new Organizations(driver);
	        orgPage.getCreateOrgImg().click();
	        
	   /* 5	create Organization With "Industry"*/
	        CreateNewOrganization createOrgPage = new CreateNewOrganization(driver);
		    createOrgPage.creatOrganization(orgName, orgIndustry);
   
		    
       /* 6	logout */
		    hp.logout();
            driver.close();
 

}

}
