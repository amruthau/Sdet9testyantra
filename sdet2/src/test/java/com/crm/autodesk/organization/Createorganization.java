package com.crm.autodesk.organization;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.autodesk.genericlib.BaseClass;
import com.crm.autodesk.genericlib.ExcelUtility;
import com.crm.autodesk.objectrrepositorylib.CreateNewOrganization;
import com.crm.autodesk.objectrrepositorylib.Home;
import com.crm.autodesk.objectrrepositorylib.Organizations;
import com.crm.autodesk.genericlib.WebDriverUtiles;
/* 
 * @author Amrutha U
 */


public class Createorganization extends BaseClass  {
	
	int randomNum = javaLib.generateRandomNum();
	//testcase1
	@Test
	public void Createorganization() throws Throwable
	{
		
		 String orgName = excelLib.getExcelData("contact", "tc_01", "OrgName")+ randomNum;
		String orgType = excelLib.getExcelData("contact", "tc_01", "orgType");
		 String orgIndustry = excelLib.getExcelData("contact", "tc_01", "Industry");
		String orgRating = excelLib.getExcelData("contact", "tc_01", "rating");


		//testcase 1
		/*1 navigate to organization page */
		Home hp = new Home(driver);
		hp.getOrgLnk().click();
		
		/*2 Create new organization*/
		Organizations orgPage = new Organizations(driver);
        orgPage.getCreateOrgImg().click();
        Thread.sleep(10000);
        
        /*4	"create a organization with madatory fields"*/
        CreateNewOrganization createOrgPage = new CreateNewOrganization(driver);
		createOrgPage.creatOrganization(orgName, orgIndustry, orgType, orgRating);
	    
      /* 5	logout 
	    hp.logout();
        driver.close();*/
	}
	//testcase2
	@Test
	public void CreateorgwithIndustrydropdown() throws Throwable 
	{
	String orgName = excelLib.getExcelData("contact", "tc_01", "OrgName")+ randomNum;	
	Home hp = new Home(driver);
	hp.getOrgLnk().click();
 
/*1	"naviagate to ""create new organization""page by click on ""+"" image"*/
    Organizations orgPage = new Organizations(driver);
    orgPage.getCreateOrgImg().click();
    
// 2 Check While Creating New Organization "Industry" Drop Down Option Is Working Or Not
    CreateNewOrganization createOrgPage = new CreateNewOrganization(driver);
   createOrgPage.creatOrganization(orgName);
   
    /* explicit wait */
    WebDriverUtiles explicitwait = new WebDriverUtiles();
    explicitwait.waitforElementToBeClickable( driver ,createOrgPage.getIndustriesLst());
    createOrgPage.getIndustriesLst().click();
    Select selectdropdown = new Select(createOrgPage.getIndustriesLst());
    selectdropdown.getOptions();
   List<WebElement> AllOptions = selectdropdown.getOptions();
   int totallist = AllOptions.size();
   System.out.println(totallist);
    //Organizations organization1 = new Organizations(driver);
  // organization1.getInDropDown();
    
/* 3 logout
   hp.logout();
    driver.close();*/

	}
	//testcase3
	@Test
	public void CreateorgwithIndustry() throws Throwable
	{
		String orgName = excelLib.getExcelData("contact", "tc_01", "OrgName")+ randomNum;
		String orgIndustry = excelLib.getExcelData("contact", "tc_01", "Industry");
		
		 Home hp = new Home(driver);
        hp.getOrgLnk().click();
	 
        
   /*1	"naviagate to ""create new organization""page by click on ""+"" image"*/
        Organizations orgPage = new Organizations(driver);
        orgPage.getCreateOrgImg().click();
        
   /* 2	create Organization With "Industry"*/
        CreateNewOrganization createOrgPage = new CreateNewOrganization(driver);
	    createOrgPage.creatOrganization(orgName, orgIndustry);

	    
   /* 3	logout 
	    hp.logout();
        driver.close();*/

}
	//testcase4
	@Test
	public void CreateorgwithTypeDropDown() throws Throwable {
		String orgName = excelLib.getExcelData("contact", "tc_01", "OrgName")+ randomNum;
		Home hp = new Home(driver);
        hp.getOrgLnk().click();
	 
   /*1	"naviagate to ""create new organization""page by click on ""+"" image"*/
        Organizations orgPage = new Organizations(driver);
        orgPage.getCreateOrgImg().click();
        
    //2	Check While Creating New Organization "type" Drop Down Option Is Working Or Not
        CreateNewOrganization createOrgPage = new CreateNewOrganization(driver);
        createOrgPage.creatOrganization(orgName);
        
        createOrgPage.getTypeLst().click();
        Select selectdropdown = new Select(createOrgPage.getTypeLst());
        selectdropdown.getOptions();
       List<WebElement> AllOptions = selectdropdown.getOptions();
       int totallist = AllOptions.size();
       System.out.println(totallist);
       //Organizations organization1 = new Organizations(driver);
       //organization1.getInDropDown();
           
   /* 3	logout 
	    hp.logout();
        driver.close();*/
	}
	// testcase5
	@Test
	public void CreateOrgwithType() throws Throwable {
		String orgName = excelLib.getExcelData("contact", "tc_01", "OrgName")+ randomNum;
		String orgType = excelLib.getExcelData("contact", "tc_01", "orgType");
		String orgIndustry = excelLib.getExcelData("contact", "tc_01", "Industry");
		String orgRating = excelLib.getExcelData("contact", "tc_01", "rating");

		 Home hp = new Home(driver);
	        hp.getOrgLnk().click();
		 
    /*1	"naviagate to ""create new organization""page by click on ""+"" image"*/
	        Organizations orgPage = new Organizations(driver);
	        orgPage.getCreateOrgImg().click();
	        
    /* 2	create Organization With "type"*/

	        CreateNewOrganization createOrgPage = new CreateNewOrganization(driver);
	        createOrgPage.creatOrganization(orgName, orgIndustry, orgType, orgRating);
		        
		    
   /*  3	logout 
		    hp.logout();
         driver.close();*/

	}
}
