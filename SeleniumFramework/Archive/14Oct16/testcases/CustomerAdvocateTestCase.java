package com.whs.navigator.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.CustomerAdvocatePageFactory;
import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.UserPermissionMultiOrgPageFactory;


public class CustomerAdvocateTestCase {
	public static HomePageFactory_old Home = new HomePageFactory_old();
	public static CustomerAdvocatePageFactory CustAdvocate = new CustomerAdvocatePageFactory();
	 public static UserPermissionMultiOrgPageFactory UPMultiOrg = new UserPermissionMultiOrgPageFactory();
	
	/*==============================================================
	TestScript  	: verifyCustomerAdvocatePageforDiffUsers
	Manual TestCase	: [QAT-648][669][649][650]WCP_4418_TC_1.0_Customer Advocate
	Description		: 
	Author 			: QAA03
	Creation Date 	: 03/31/2016
	Release Name    : Matheson
	Pre-Requisites	:
	Revision History:
  ==============================================================*/
	
	@Test(priority=91)
	public void verifyCustomerAdvocatePageforDiffUsers()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,Home);
			PageFactory.initElements(driver,CustAdvocate);
			PageFactory.initElements(driver,UPMultiOrg);
			
			
	
		try {
			FrameworkUtil.sTestCaseName ="verifyCustomerAdvocatePageforDiffUsers";
			FrameworkUtil.sManualTestCaseName="[QAT-648][669][649][650]WCP_4418_TC_1.0_Customer Advocate";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			//login to Navigator with Role-A user
			LoginTestCase_Old1.LoginAsRoleAUser();
			
			verifyCustomerAdvocatePageDetails();
			
			//Logout from Navigator
			LoginTestCase_Old1.nav_Logout();
			
			//login to Navigator with entity 01 user
			LoginTestCase_Old1.LoginAsEntity01User();
			
			verifyCustomerAdvocatePageDetails();
			
			//Logout from Navigator
			LoginTestCase_Old1.nav_Logout();
			
			//login to Navigator with entity 02 user
			LoginTestCase_Old1.LoginAsEntity02User();
			
			verifyCustomerAdvocatePageDetails();
			
			//Logout from Navigator
			LoginTestCase_Old1.nav_Logout();
			
			//Login to Navigator with QaautoM user
			LoginTestCase_Old1.LoginAsQaautoMMultiOrgUser();
			
			//Selecting the Organization from drop down
			WebObjectUtil.selectWebList(UPMultiOrg.getNav_MOrg_SelectOrg(),null, null, 1);
			WebObjectUtil.clickElement(UPMultiOrg.getNav_MOrg_UsethisOrgButton());
			WebObjectUtil.explicitWait(5);
			HomeTestCase.nav_WindStreamToTierPointHomePopup();
			
			verifyCustomerAdvocatePageDetails();
			
			//Logout from Navigator
			LoginTestCase_Old1.nav_Logout();
			
		
		   } catch (Exception e) {
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyCustomerAdvocatePageforDiffUsers", "warn", "catch block:" +e.getMessage());
		}
	}
	
	
	
	
	
	
	
	/*====================================================================================================
	Method Name 	: verifyCustomerAdvocatePageDetails
	Description		: 
	Author 			: QAA03
	Creation Date 	: 03/31/2016
	Pre-Requisites	: 
	Revision History:
	====================================================================================================*/
	public static void verifyCustomerAdvocatePageDetails()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,Home);
			PageFactory.initElements(driver,CustAdvocate);
			
			
	 try {
		    //Navigating to Customer Advocate page
			WebObjectUtil.clickElement(Home.getNav_SupportTab());
			WebObjectUtil.clickElement(CustAdvocate.getNav_CustomerAdvocateLink());
			WebObjectUtil.waitForElementPresent(CustAdvocate.getNav_CustomerAdvocateData());
			WebObjectUtil.verifyElementPresent(CustAdvocate.getNav_CustomerAdvocateData());
		 
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyCustomerAdvocatePageDetails", "warn", "catch block:" +e.getMessage());  
		}
	 
	}
	
	
	
	@AfterMethod
	public static void afterEachMethod(){
			FrameworkUtil.updateTestCaseStatusinResult();
			
		}
	
	
	

}
