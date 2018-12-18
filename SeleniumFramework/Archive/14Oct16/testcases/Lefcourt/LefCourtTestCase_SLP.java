package com.whs.navigator.testcases.Lefcourt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.EntityBrowserPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.SmokeTestPageFactory;
import com.whs.navigator.pagefactory.FAQPageFactory;
import com.whs.navigator.pagefactory.FormPageFactory;

public class LefCourtTestCase_SLP {
	
	    public static HomePageFactory_old Home = new HomePageFactory_old();
		public static EntityBrowserPageFactory EBPanel = new EntityBrowserPageFactory();
		public static SmokeTestPageFactory SmokeTest = new SmokeTestPageFactory();
		public static FAQPageFactory FAQ = new FAQPageFactory();
		public static FormPageFactory Form = new FormPageFactory();
		
	  /*==============================================================
		TestScript  	: verifyFAQPageDisplay
		Manual TestCase	: [QAT-550] WCP_3662_TC_1.0_FAQ page
		Description		: Verify user is able to Navigate to FAQ page from Support tab.
		Author 			: QAA03
		Creation Date 	: 01/21/2016
		Release Name    : LefCourt
		Pre-Requisites	:
		Revision History:
	  ==============================================================*/
		@Test(priority=41)
		public void verifyFAQPageDisplay()
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,Home);
				
				
			
			try {
				FrameworkUtil.sTestCaseName = "verifyFAQPageDisplay";
				FrameworkUtil.sManualTestCaseName="[QAT-550] WCP_3662_TC_1.0_FAQ page";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
				
			    //Login to navigator with Role-A user
				LoginTestCase_Old1.LoginAsRoleAUser();
				
				//Navigating to FAQ Page
				navToFAQPage();
				
				//Logout from Navigator
				LoginTestCase_Old1.nav_Logout();
			
			   } catch (Exception e) {
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyFAQPageDisplay", "warn", "catch block:" +e.getMessage());
			}
	    }
		
		/*==============================================================
		TestScript  	: verifyFormsPageDisplay
		Manual TestCase	: [QAT-475] [QAT-476] WCP_4307_TC_1.0_Forms 3.0_Dashboard_Build Requirements(Forms) link under support tab
		Description		: Verify that user is able to navigate to Forms dashboard page when clicks on Build Requirements Forms under support tab
		Author 			: QAA03
		Creation Date 	: 01/21/2016
		Release Name    : LefCourt
		Pre-Requisites	:
		Revision History:
	   ==============================================================*/
		@Test(priority=42)
		public void verifyFormsPageDisplay()
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,Home);
				PageFactory.initElements(driver,EBPanel);
				
			
			try {
				FrameworkUtil.sTestCaseName = "verifyFormsPageDisplay";
				FrameworkUtil.sManualTestCaseName="[QAT-475][QAT-476] WCP_4307_TC_1.0_Forms 3.0_Dashboard_Build Requirements(Forms) link under support tab";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
				
			    //Login to navigator with efgha user
				LoginTestCase_Old1.LoginAsEfghaUser();
				
				//Navigating to Forms Page
				navToFormsPage();
				
				//Verifying EBPanel is not present in forms page
				WebObjectUtil.verifyElementNOTPresent(EBPanel.getNav_EntityBrowserLink());
				
				//Logout from Navigator
				LoginTestCase_Old1.nav_Logout();
			
			   } catch (Exception e) {
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyFormsPageDisplay", "warn", "catch block:" +e.getMessage());
			}
	    }
		/*==============================================================
		TestScript  	: verifyFeedBackPortletOnFormsPage
		Manual TestCase	: [QAT-472] WCP_3270_TC_1.1_Forms 3.0_Dashboard_Feedback Portlet display on Build Requirements(Forms) page
		Description		: Verify that user is able to view Feedback Portlet on Build Requirements (Forms) page
		Author 			: QAA03
		Creation Date 	: 01/21/2016
		Release Name    : LefCourt
		Pre-Requisites	:
		Revision History:
	   ==============================================================*/
		@Test(priority=43)
		public void verifyFeedBackPortletOnFormsPage()
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,Home);
				PageFactory.initElements(driver,SmokeTest);
				
				
			
			try {
				FrameworkUtil.sTestCaseName = "verifyFeedBackPortletOnFormsPage";
				FrameworkUtil.sManualTestCaseName="[QAT-472]WCP_3270_TC_1.1_Forms 3.0_Dashboard_Feedback Portlet display on Build Requirements(Forms) page";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
				
			    //Login to navigator with efgha user
				LoginTestCase_Old1.LoginAsEfghaUser();
				
				//Navigating to Forms Page
				navToFormsPage();
				
				//Verifying Feedback Portlet
				WebObjectUtil.verifyElementPresent(Home.getnav_FeedBackBox());
				//Verifying Click here link
				WebObjectUtil.verifyElementPresent(Home.getNav_ClickhereLink());
				
			    HomeTestCase.navFeedbackClickhere();
				WebObjectUtil.explicitWait(5);
				//Clicking on Feedback link
				WebObjectUtil.clickElement(SmokeTest.getNav_FeedbackLink());
				WebObjectUtil.waitForElementPresent(Home.getNav_CreateTicketPopupWindow());
				//Verifying feedback window 
				WebObjectUtil.verifyElementPresent(Home.getNav_CreateTicketPopupWindow());
				
				//Logout from Navigator
				LoginTestCase_Old1.nav_Logout();
			
			   } catch (Exception e) {
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyFeedBackPortletOnFormsPage", "warn", "catch block:" +e.getMessage());
			}
	    }
		
		/*====================================================================================================
		Method Name 	: navToFAQPage
		Description		: Navigating to FAQ Page
		Author 			: QAA03
		Creation Date 	: 
		Pre-Requisites	: 
		Revision History:
		====================================================================================================*/
		public static void navToFAQPage()
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,Home);
				PageFactory.initElements(driver,FAQ);
				
		 try {
			   
			    WebObjectUtil.MouseHover(Home.getNav_SupportTab());
				WebObjectUtil.clickElement(Home.getNav_FAQLink());
				
				WebObjectUtil.verifyElementPresent(FAQ.getNav_FAQPageHeader());
				
			 } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navToFAQPage", "warn", "catch block:" +e.getMessage());  
			}
		 
			
		}
		
		/*====================================================================================================
		Method Name 	: navToFormsPage
		Description		: Navigating to Forms Page
		Author 			: QAA03
		Creation Date 	: 
		Pre-Requisites	: 
		Revision History:
		====================================================================================================*/
		public static void navToFormsPage()
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,Home);
				PageFactory.initElements(driver,Form);
				
		 try {
			 
			    WebObjectUtil.MouseHover(Home.getNav_SupportTab());
				WebObjectUtil.clickElement(Home.getNav_BuildReqMenuLink());
				
				WebObjectUtil.verifyElementPresent(Form.getNav_FormsPageHeader());
				
			 } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navToFormsPage", "warn", "catch block:" +e.getMessage());  
			}
		 
			
		}
		@AfterMethod
		public static void afterEachMethod(){
				FrameworkUtil.updateTestCaseStatusinResult();
				
			}

}

