package com.whs.navigator.testcases.zathras;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.CustomWebElementUtil;
import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.CommonPageFactory;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.AnnouncementPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.SmokeTestPageFactory;
import com.whs.navigator.testcases.LoginTestCase;


public class ZathrasTestCase_SLP {
	
	 public static CommonPageFactory Common = new CommonPageFactory();
	 public static AnnouncementPageFactory Announcement = new AnnouncementPageFactory();
	 public static SmokeTestPageFactory SmokeTest = new SmokeTestPageFactory();
	 public static HomePageFactory_old Home = new HomePageFactory_old();
	 public static EVDC_OverviewPageFactory EVDC_Overview = new EVDC_OverviewPageFactory();
	 
	/*==============================================================
	TestScript  	: verifyHybridAnnouncementinHomePage
	Manual TestCase	: [Announcement-QAT-1730-Zathras] WCP_6149_TC_1.0_Announcements- Hybrid IT
   Description		: Verify that Hybrid IT announcement will be display for all the users.
	Author 			: QAA03
	Creation Date 	: 09/20/2016
	Release Name    : Zathras
	Pre-Requisites	: 
	Revision History:
 ==============================================================*/
	
	@Test(priority=31)
	public void verifyHybridAnnouncementinHomePage()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,Announcement);
			PageFactory.initElements(driver,SmokeTest);
		    int iAnnMenuCount=0,iFirstAnn=0,iTemp=0;
		    String sAnnouncementDetail=null,sAnnouncementText=null;
		    WebElement wAnnouncementText,wAnnouncementDot;
			boolean bAnnStatus=false;				
		try {
			FrameworkUtil.sTestCaseName = "verifyHybridAnnouncementinHomePage";
			FrameworkUtil.sManualTestCaseName="[Announcement-QAT-1730-Zathras] WCP_6149_TC_1.0_Announcements- Hybrid IT";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
													
		   
			LoginTestCase.LoginAsQaautoAUser();
			
			WebObjectUtil.verifyElementPresent(SmokeTest.getNav_AnnouncementsPortlet());
			
			WebObjectUtil.clickElement(Announcement.getNav_AnnouncementPauseButton());
			CustomWebElementUtil.loadCustomElement(Announcement.getNav_AnnouncementMenuView(), "li");
			iAnnMenuCount = CustomWebElementUtil.iRowCount;
			if(iAnnMenuCount>0)
			{
				iFirstAnn=3;
				wAnnouncementDot = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.ANNOUNCEMENT.MENU.ANNOUNCEMENTDOTS", "PARAMETER_DOTS", iFirstAnn+""); 
				WebObjectUtil.clickElement(wAnnouncementDot);
				iTemp= iFirstAnn-2;
				wAnnouncementText = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.ANNOUNCEMENT.MENU.ANNOUNCEMENTTEXT", "PARAMETER_DOTS", iTemp+"");
				   
				   if(wAnnouncementText.getAttribute("style").contains("/announcements-portlet/resources/images/Welcome_announcement3.png"))
				   {
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Announcement", "pass", "Announcement present in Anouncement portlet of Home page");
					   WebObjectUtil.clickElement(wAnnouncementText);
					   sAnnouncementText=driver.getCurrentUrl();
					   bAnnStatus = sAnnouncementText.contains("hybrid");
					   FrameworkUtil.updateCustomResultBasedOnStatus(bAnnStatus, "Hybrid announcement is first announcement in announcement portlet of home page");
				   }
				   else
				   {
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Announcement Detail Text", "fail", "Announcement Detail text not present in Anouncement portlet of Home page");   
				   }
			}
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Announcement", "fail", "Announcements are not present in Anouncement portlet of Home page");
			
			LoginTestCase.nav_Logout();
			
		   } catch (Exception e) {
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyHybridAnnouncementinHomePage", "warn", "catch block:" +e.getMessage());
		}
	}
	/*==============================================================
	TestScript  	: verifyBandWidthLinkNavigation
	Manual TestCase	: [Home-QAT-1733-Zathras] WCP_6137_TC_1.0_Bandwidth reports links
   Description		: Verify that user is navigate to bandwidth reports correctly
	Author 			: QAA03
	Creation Date 	: 09/20/2016
	Release Name    : Zathras
	Pre-Requisites	: 
	Revision History:
 ==============================================================*/
	
	@Test(priority=32)
	public void verifyBandWidthLinkNavigation()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,SmokeTest);
			PageFactory.initElements(driver,EVDC_Overview);
			PageFactory.initElements(driver,Home);
			String sHBwData=null,sEVDcBwDdata=null;
			boolean bBWStatus=false;
		try {
			FrameworkUtil.sTestCaseName = "verifyBandWidthLinkNavigation";
			FrameworkUtil.sManualTestCaseName="[Home-QAT-1733-Zathras] WCP_6137_TC_1.0_Bandwidth reports links";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
													
		   
			LoginTestCase.LoginAsQaautoAUser();
			
			WebObjectUtil.verifyElementPresent(SmokeTest.getNav_BandwidthPortlet());
			WebObjectUtil.clickElement(SmokeTest.getNav_BandwidthLink());
			WebObjectUtil.verifyElementPresent(SmokeTest.getNav_NetworkFirstGraphHeader());
			sHBwData = SmokeTest.getNav_NetworkFirstGraphHeader().getText();
			
			WebObjectUtil.clickElement(Home.getNav_BreadscrumbHome());
			WebObjectUtil.explicitWait(5);
			
			WebObjectUtil.clickElement(EVDC_Overview.getNav_EVDCname());
		    WebObjectUtil.clickElement(EVDC_Overview.getNav_EVDCOverviewBandwidth());
		    WebObjectUtil.verifyElementPresent(SmokeTest.getNav_NetworkFirstGraphHeader());
		    sEVDcBwDdata = SmokeTest.getNav_NetworkFirstGraphHeader().getText();
		    
		    bBWStatus=sHBwData.equalsIgnoreCase(sHBwData);
		    
		    FrameworkUtil.updateCustomResultBasedOnStatus(bBWStatus, "Navigation of Bandwidth from Home and EVDC Overview Page");
			
			LoginTestCase.nav_Logout();
			
		   } catch (Exception e) {
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyBandWidthLinkNavigation", "warn", "catch block:" +e.getMessage());
		}
	}
	
	
	@AfterMethod
	public static void afterEachMethod(){
			FrameworkUtil.updateTestCaseStatusinResult();
			
		}

}


