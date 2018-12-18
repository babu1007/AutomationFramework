package com.whs.navigator.testcases.Talon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.PhysicalServicesPageFactory;
import com.whs.navigator.pagefactory.ReportsPageFactory;
import com.whs.navigator.pagefactory.SmokeTestPageFactory;

public class TalonTestCase_SLP {
	
		 public static HomePageFactory_old Home = new HomePageFactory_old();
		 public static ReportsPageFactory Report = new ReportsPageFactory();
		 public static PhysicalServicesPageFactory PDC = new PhysicalServicesPageFactory();
		 public static SmokeTestPageFactory SmokeTest = new SmokeTestPageFactory();
		 
		/*==============================================================
		TestScript  	: verifyReportsPageForentity03a
		Manual TestCase	: [QAT-864] WCP_4798_TC_1.0_Reports page display on navigator
        Description		: Verify that when user clicks on Reports under Monitoring tab in the menu on landing page, Reports page is displayed
		Author 			: QAA03
		Creation Date 	: 08/03/2016
		Release Name    : Talon
		Pre-Requisites	: 
		Revision History:
	  ==============================================================*/
		
		@Test(priority=31)
		public void verifyReportsPageForentity03a()
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, Report);
				PageFactory.initElements(driver, Home);
				
			    
								
			try {
				FrameworkUtil.sTestCaseName = "Reports-verifyReportsPageForentity03a";
				FrameworkUtil.sManualTestCaseName="[QAT-864] WCP_4798_TC_1.0_Reports page display on navigator";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
														
			    // Login to navigator with entity03a user
				com.whs.navigator.testcases.LoginTestCase_Old1.LoginAsEntity03User();
				
				WebObjectUtil.clickElement(Home.getNav_MonitoringTab());
				WebObjectUtil.clickElement(Home.getNav_ReportMenuLink());
				WebObjectUtil.verifyElementPresent(Report.getNavStorageReportsLink());
	                      			
				// Logout from Navigator
				com.whs.navigator.testcases.LoginTestCase_Old1.nav_Logout();
			
			   } catch (Exception e) {
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyReportsPageForentity03a", "warn", "catch block:" +e.getMessage());
			}
		}
		
		/*==============================================================
		TestScript  	: verifyPortletPresentwhenOrghasPhysicalDC
		Manual TestCase	: [QAT-863] WCP_4799_TC_1.0_Porlets on landing page are displayed correctly with out error message when org has physical dc
        Description		: Verify that when an org has Physical DC, all portlets on landing page are displayed correctly without error message
		Author 			: QAA03
		Creation Date 	: 08/04/2016
		Release Name    : Talon
		Pre-Requisites	: 
		Revision History:
	  ==============================================================*/
		
		@Test(priority=32)
		public void verifyPortletPresentwhenOrghasPhysicalDC()
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, PDC);
				PageFactory.initElements(driver, SmokeTest);
				
			    boolean bPhysicalDCStatus=false;
								
			try {
				FrameworkUtil.sTestCaseName = "PDC-verifyPortletPresentwhenOrghasPhysicalDC";
				FrameworkUtil.sManualTestCaseName="[QAT-863] WCP_4799_TC_1.0_Porlets on landing page are displayed correctly with out error message when org has physical dc";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
														
			    // Login to navigator with entity03a user
				com.whs.navigator.testcases.LoginTestCase_Old1.LoginAsEntity03User();
				
				bPhysicalDCStatus = WebObjectUtil.verifyElementPresent(PDC.getNav_PhysicalServicesPortlet());
				
				if(bPhysicalDCStatus)
				{
					WebObjectUtil.verifyElementPresent(SmokeTest.getNav_DevicesAlertsPortlet());
					WebObjectUtil.verifyElementPresent(SmokeTest.getNav_TicketsPortlet());
					WebObjectUtil.verifyElementPresent(SmokeTest.getNav_DraasPortlet());
					WebObjectUtil.verifyElementPresent(SmokeTest.getNav_BandwidthPortlet());
					WebObjectUtil.verifyElementPresent(SmokeTest.getNav_AnnouncementsPortlet());
					WebObjectUtil.verifyElementPresent(SmokeTest.getNav_ContactPortlet());
					WebObjectUtil.verifyElementPresent(SmokeTest.getNav_Feedbackportlet());
					WebObjectUtil.verifyElementPresent(SmokeTest.getNav_EVDCPortlet());
					
				}
				else
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Physical services DC Portlet", "Physical services DC Portlet", "fail", "Physical services DC Portlet  is not present for entity03a user" );
				}
	                      			
				// Logout from Navigator
				com.whs.navigator.testcases.LoginTestCase_Old1.nav_Logout();
			
			   } catch (Exception e) {
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyPortletPresentwhenOrghasPhysicalDC", "warn", "catch block:" +e.getMessage());
			}
		}
		
		/*==============================================================
		TestScript  	: verifyPurchaseAddCloudEVDCnotPresent
		Manual TestCase	: [QAT-853] WCP_4785_TC_1.0_Purchase Additional Cloud EVDC link is removed on landing page
        Description		: Verify that when user logs into navigator, user should not see Purchase Additional Cloud EVDC link under the EVDC portlet
		Author 			: QAA03
		Creation Date 	: 08/04/2016
		Release Name    : Talon
		Pre-Requisites	: 
		Revision History:
	  ==============================================================*/
		
		@Test(priority=33)
		public void verifyPurchaseAddCloudEVDCnotPresent()
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, Home);
				String sAddEVDC=null;
				boolean bAddEVDCStatus=false;
			    
								
			try {
				FrameworkUtil.sTestCaseName = "Home-verifyPurchaseAddCloudEVDCnotPresent";
				FrameworkUtil.sManualTestCaseName="[QAT-853] WCP_4785_TC_1.0_Purchase Additional Cloud EVDC link is removed on landing page";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
				sAddEVDC=(String)FrameworkUtil.dictPropertyData.get("NAV.PURCHASE.ADDITIONAL.CLOUDEVDC");
				
			    // Login to navigator with Qaauto user
				com.whs.navigator.testcases.LoginTestCase_Old1.LoginAsQaautoUser();
				
				bAddEVDCStatus = WebObjectUtil.VerifyTextNotPresentOnPage(sAddEVDC);
				
				FrameworkUtil.updateCustomResultBasedOnStatus(bAddEVDCStatus, "Purchase Additional Cloud EVDC not present");
	                      			
				// Logout from Navigator
				com.whs.navigator.testcases.LoginTestCase_Old1.nav_Logout();
			
			   } catch (Exception e) {
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyPurchaseAddCloudEVDCnotPresent", "warn", "catch block:" +e.getMessage());
			}
		}
		
		@AfterMethod
		public static void afterEachMethod(){
				FrameworkUtil.updateTestCaseStatusinResult();
				
			}

}
