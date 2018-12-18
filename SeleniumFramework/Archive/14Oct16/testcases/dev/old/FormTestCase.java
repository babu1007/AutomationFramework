package com.whs.navigator.testcases.dev.old;

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
import com.whs.navigator.pagefactory.FormPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.SmokeTestPageFactory;

public class FormTestCase {
	
	        public static HomePageFactory_old Home = new HomePageFactory_old();
			public static EntityBrowserPageFactory EBPanel = new EntityBrowserPageFactory();
			public static SmokeTestPageFactory SmokeTest = new SmokeTestPageFactory();
			public static FormPageFactory Form = new FormPageFactory();
			
		
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
			@Test(priority=2)
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
					LoginTestCase.LoginAsEfghaUser();
					
					//Navigating to Forms Page
					navToFormsPage();
					
					//Verifying EBPanel is not present in forms page
					WebObjectUtil.verifyElementNOTPresent(EBPanel.getNav_EntityBrowserLink());
					
					//Logout from Navigator
					LoginTestCase.nav_Logout();
				
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
			@Test(priority=3)
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
					LoginTestCase.LoginAsEfghaUser();
					
					//Navigating to Forms Page
					navToFormsPage();
					
					//Verifying Feedback Portlet
					WebObjectUtil.verifyElementPresent(Home.getnav_FeedBackBox());
					//Verifying Click here link
					WebObjectUtil.verifyElementPresent(Home.getNav_ClickhereLink());
					
				    HomeTestCase.navFeedbackClickhere();
					WebObjectUtil.explicitWait(5);
					//Clicking on Feedback link
					WebObjectUtil.scrollToElement(SmokeTest.getNav_FeedbackLink());
					WebObjectUtil.clickElement(SmokeTest.getNav_FeedbackLink());
					WebObjectUtil.explicitWait(5);
					//WebObjectUtil.waitForElementPresent(Home.getNav_CreateTicketPopupWindow());
					//Verifying feedback window 
					WebObjectUtil.verifyElementPresent(Home.getNav_CreateTicketPopupWindow());
					
					//Logout from Navigator
					LoginTestCase.nav_Logout();
				
				   } catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyFeedBackPortletOnFormsPage", "warn", "catch block:" +e.getMessage());
				}
		    }
			
///____________________ LefCourt test cases _______________________________________________________________ ////
			
			
/*==============================================================
TestScript 		: navVerifyFormsFooter
Manual TestCase	: QAT-430
Description		: Forms Dashboard page is displayed. Verify that the footer of the page
Author 			: QAA04
Creation Date 	: 01/28/2016
Release Name    : Lefcourt
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=1)
public void navVerifyFormsFooter(){
	
	int iSize,i=1;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, Home);	
	
	try {
	//Update results with manual test case name
	FrameworkUtil.sTestCaseName = "navVerifyFormsFooter";
	FrameworkUtil.sManualTestCaseName="(QAT-430) Lefcourt- Forms Dashboard page is displayed. Verify that the footer of the page";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	//Login into Navigator	
      LoginTestCase.LoginAsEfghaUser();
      
      // navigating to the forms page
      WebObjectUtil.ClickAndMouseHover(Home.getNav_SupportTab());
      WebObjectUtil.clickElement(Home.getNav_BuildReqMenuLink());
      WebObjectUtil.explicitWait(5);
      WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.FOOTER.SECTIONS", "null", "null");
      iSize = WebObjectUtil.webElementsList.size(); 
      FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying forms footer", "pass", "form footer section count " +iSize);
      
      for (WebElement wb : WebObjectUtil.webElementsList){
    	 String sData = wb.getText(); 
    	  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying forms footer", "pass", ""+i+" Footer section data " +sData);
      i++;
      }
      
      LoginTestCase.nav_Logout();
	  } catch(Exception e){
  		LoggerUtil.log_type_error("issue with navVerifyFormsFooter test case");
  	    LoggerUtil.log_type_error("Exception occured "+FrameworkUtil.sElementName);
  	   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage());
  	}
 }
			
			
			
			
			
			
//// ______________________ Completed lefcourt test cases _________________________________________________ ////
			/*====================================================================================================
			Method Name 	: navToFormsPage
			Description		: Navigating to Forms Page
			Author 			: QAA03
			Creation Date 	: 01/21/2016
			Pre-Requisites	: 
			Revision History:
			====================================================================================================*/
			public static void navToFormsPage()
			{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver,Home);
					PageFactory.initElements(driver,Form);
					
			 try {
				 
				    WebObjectUtil.ClickAndMouseHover(Home.getNav_SupportTab());
				  //WebObjectUtil.clickByJS(Home.getNav_SupportTab());
					WebObjectUtil.clickElement(Home.getNav_BuildReqMenuLink());
					WebObjectUtil.explicitWait(5);
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
