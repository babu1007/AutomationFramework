package com.whs.navigator.testcases.dev.old;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import com.whs.navigator.commonUtil.WebTableUtil;
import com.whs.navigator.pagefactory.CommonPageFactory;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.EVDC_VM_AdvancedActions_PageFactory;
import com.whs.navigator.pagefactory.EVDC_VM_PageFactory;
import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.TicketPageFactory;
import com.whs.navigator.pagefactory.UserPermissionManageEntityPageFactory;
import com.whs.navigator.pagefactory.UserPermissionMultiOrgPageFactory;
import com.whs.navigator.pagefactory.UserPermissionPageFactory;
import com.whs.navigator.pagefactory.DraasPageFactory;


public class UserPermissionMultiOrgTestCase {
	
	static UserPermissionPageFactory UserPerm = new UserPermissionPageFactory();
	static UserPermissionPageFactory UserPermission = new UserPermissionPageFactory();
	static UserPermissionManageEntityPageFactory ManageEntity = new UserPermissionManageEntityPageFactory();
	static UserPermissionMultiOrgPageFactory UPMultiOrg = new UserPermissionMultiOrgPageFactory();
	static HomePageFactory_old HomePageFactory = new HomePageFactory_old();
	static DraasPageFactory Draas = new DraasPageFactory();
	static EVDC_VM_AdvancedActions_PageFactory EVDC = new EVDC_VM_AdvancedActions_PageFactory();
	static CommonPageFactory CommonPF = new CommonPageFactory();
	
	
	public static EVDC_VM_PageFactory EVDC_VMPF = new EVDC_VM_PageFactory();
	public static EVDC_OverviewPageFactory EVDC_OverviewPF = new EVDC_OverviewPageFactory();
	static HomeTestCase HomeTestcase = new HomeTestCase();
	public static TicketPageFactory Ticket = new TicketPageFactory();
	//public static ClarkTestCase Clark =new ClarkTestCase();
	
	
////#########################################################Vivek start##############################################
	/*==============================================================
	TestScript  	: navVerDocumentWithMultiOrg
	Manual TestCase	: Check Documents page with multiorguser
	Description		: Verify the below changes happened in the Document page:
						1. Make sure that page changes according to organization
						2. Make sure that org selector changes
						3. Make sure that data changes according to selected organization
	Author 			: Vivek Kumar
	Creation Date 	: 07/15/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=11)
	public void navVerDocumentWithMultiOrg()
	{

		String sUserName,sPassword,sOrgName;
		boolean bStatus;
		WebDriver driver = WebDriverUtil.getDriver();
  		PageFactory.initElements(driver, UserPermission);
  		PageFactory.initElements(driver, UPMultiOrg);
  		FrameworkUtil.sTestCaseName = "UserPermission-navVerDocumentWithMultiOrg";
  		FrameworkUtil.sManualTestCaseName= "Check Documents page with multiorguser";
  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
  		 
  		//Verifying document page with  Role A
  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.AROLE");
  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.AROLE");
  		sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
  		
  		loginNavigator(sUserName,sPassword);
  		navigateToDocument();
  		switchOraganization(sOrgName);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_DocumentLink());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Document page verified");
  			
  		sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME3");
  		switchOraganization(sOrgName);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_DocumentLink());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Document page verified");
  		//Logging out from Navigator application
  		LoginTestCase.nav_Logout();
  		
  		//Verifying document page with  Role C
  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.CROLE");
  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.CROLE");
  		sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
  		
  		loginNavigator(sUserName,sPassword);
  		navigateToDocument();
  		switchOraganization(sOrgName);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_DocumentLink());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Document page verified");
  			
  		sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME3");
  		switchOraganization(sOrgName);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_DocumentLink());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Document page verified");
  		//Logging out from Navigator application
  		LoginTestCase.nav_Logout();
  		
  		//Verifying document page with  Role E
  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.EROLE");
  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.EROLE");
  		sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
  		
  		loginNavigator(sUserName,sPassword);
  		navigateToDocument();
  		switchOraganization(sOrgName);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_DocumentLink());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Document page verified");
  			
  		sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME3");
  		switchOraganization(sOrgName);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_DocumentLink());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Document page verified");
  		//Logging out from Navigator application
  		LoginTestCase.nav_Logout();
	}
		
 	
	/*==============================================================
	TestScript  	: navVerAnnouncementWithMultiOrg
	Manual TestCase	: Check Announcement page with multiorguser
	Description		: Verify the below changes happened in the Announcement page:
					1. Make sure that page changes according to organization
					2. Make sure that org selector changes
					3. Make sure that data changes according to selected organization
	Author 			: Vivek Kumar
	Creation Date 	: 07/15/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	//@Test(priority=12)
	public void navVerAnnouncementWithMultiOrg()
	{

		String sUserName,sPassword,sOrgName;
		boolean bStatus;
		
		WebDriver driver = WebDriverUtil.getDriver();
  		PageFactory.initElements(driver, UserPermission);
  		PageFactory.initElements(driver, UPMultiOrg);
  		FrameworkUtil.sTestCaseName = "UserPermission-navVerAnnouncementWithMultiOrg";
  		FrameworkUtil.sManualTestCaseName= " Check Announcement page with multiorguser";
  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
  		
	  	//Verifying document page with  Role A
	  	sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.AROLE");
	  	sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.AROLE");
	  		  		
  		loginNavigator(sUserName,sPassword);
  		navigateToAnnouncement();
  		WebObjectUtil.explicitWait(5);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_ShowCalenderBtn());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Show Calender Verified");
  		
  	/*	bStatus=WebObjectUtil.isElementPresent(UserPermission.getNav_NewAnnouncementBtn());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "New Announcement Verified");
  		*/
  		
  		sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
  		switchOraganization(sOrgName);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_ShowCalenderBtn());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Show Calender Verified");
  		
  		sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME3");
  		switchOraganization(sOrgName);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_ShowCalenderBtn());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Show Calender Verified");
  		
  		//Logging out from Navigator application
  		LoginTestCase.nav_Logout();
  		
  		
  		//Verifying document page with  Role C
  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.CROLE");
  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.CROLE");
	  //sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
	  		
  		loginNavigator(sUserName,sPassword);
  		navigateToAnnouncement();
  		WebObjectUtil.explicitWait(5);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_ShowCalenderBtn());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Show Calender Verified");
  		/*
  		bStatus=WebObjectUtil.isElementPresent(UserPermission.getNav_NewAnnouncementBtn());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "New Announcement Verified");
  		*/
  		sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
  		switchOraganization(sOrgName);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_ShowCalenderBtn());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Show Calender Verified");
  		
  		sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME3");
  		switchOraganization(sOrgName);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_ShowCalenderBtn());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Show Calender Verified");
  		
  		LoginTestCase.nav_Logout();
  		
  		
  		//Verifying document page with  Role E
  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.EROLE");
  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.EROLE");
	  	//sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME3");
	  		
  		loginNavigator(sUserName,sPassword);
  		navigateToAnnouncement();
  		WebObjectUtil.explicitWait(5);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_ShowCalenderBtn());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Show Calender Verified");
  		/*
  		bStatus=WebObjectUtil.isElementPresent(UserPermission.getNav_NewAnnouncementBtn());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "New Announcement Verified");
  		*/
  		sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
  		switchOraganization(sOrgName);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_ShowCalenderBtn());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Show Calender Verified");
  		
  		sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME3");
  		switchOraganization(sOrgName);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_ShowCalenderBtn());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Show Calender Verified");
  		
  		//Logging out from Navigator application
  		LoginTestCase.nav_Logout();
  		 
	}
	
 	
	/*==============================================================
	TestScript  	: navVerCloudAPIWithMultiOrg
	Manual TestCase	: Check Cloud AV page with multiorguser
	Description		: Verify the below changes happened in the Cloud API page:
					1. Make sure that page changes according to organization
					2. Make sure that org selector changes
					3. Make sure that data changes according to selected organization
	Author 			: Vivek Kumar
	Creation Date 	: 07/17/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=13)
	public void navVerCloudAPIWithMultiOrg()
	{
		String sUserName,sPassword,sOrgName;
		boolean bStatus;
		
		WebDriver driver = WebDriverUtil.getDriver();
  		PageFactory.initElements(driver, UserPermission);
  		PageFactory.initElements(driver, UPMultiOrg);
  		FrameworkUtil.sTestCaseName = "UserPermission-navVerCloudAPIWithMultiOrg";
  		FrameworkUtil.sManualTestCaseName= "Check Cloud api page with multiorguser";
  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
  		
	  	//Verifying document page with  Role A
	  	sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.AROLE");
	  	sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.AROLE");
	  		  		
  		loginNavigator(sUserName,sPassword);
  		navigateToCloudAPI();
  		WebObjectUtil.explicitWait(5);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_CloudAPIImage());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Cloud API page verified");
  		
  		sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
  		switchOraganization(sOrgName);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_CloudAPIImage());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Cloud API page verified");
  		
  		sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME3");
  		switchOraganization(sOrgName);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_CloudAPIImage());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Cloud API page verified");
  		
  		
  		//Logging out from Navigator application
  		LoginTestCase.nav_Logout();
  		
  		
  		//Verifying document page with  Role C
	  	sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.CROLE");
	  	sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.CROLE");
	  		  		
  		loginNavigator(sUserName,sPassword);
  		navigateToCloudAPI();
  		WebObjectUtil.explicitWait(5);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_CloudAPIImage());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Cloud API page verified");
  		
  		sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
  		switchOraganization(sOrgName);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_CloudAPIImage());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Cloud API page verified");
  		
  		sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME3");
  		switchOraganization(sOrgName);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_CloudAPIImage());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Cloud API page verified");
  		
  		
  		//Logging out from Navigator application
  		LoginTestCase.nav_Logout();
  		
  		

  		//Verifying document page with  Role E
	  	sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.EROLE");
	  	sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.EROLE");
	  		  		
  		loginNavigator(sUserName,sPassword);
  		navigateToCloudAPI();
  		WebObjectUtil.explicitWait(5);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_CloudAPIImage());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Cloud API page verified");
  		
  		sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
  		switchOraganization(sOrgName);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_CloudAPIImage());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Cloud API page verified");
  		
  		sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME3");
  		switchOraganization(sOrgName);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_CloudAPIImage());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Cloud API page verified");
  		
  		//Logging out from Navigator application
  		LoginTestCase.nav_Logout();
  		
	}
	
	
	/*==============================================================
	TestScript  	: navVerCloudAVWithMultiOrg
	Manual TestCase	: Check Cloud AV page with multiorguser
	Description		: Verify the below changes happened in the Cloud AV page:
					1. Make sure that page changes according to organization
					2. Make sure that org selector changes
					3. Make sure that data changes according to selected organization
	Author 			: Vivek Kumar
	Creation Date 	: 07/20/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=14)
	public void navVerCloudAVWithMultiOrg()
	{
		String sUserName,sPassword,sOrgName;
		boolean bStatus;
		
		WebDriver driver = WebDriverUtil.getDriver();
  		PageFactory.initElements(driver, UserPermission);
  		PageFactory.initElements(driver, UPMultiOrg);
  		FrameworkUtil.sTestCaseName = "UserPermission-navVerCloudAVWithMultiOrg";
  		FrameworkUtil.sManualTestCaseName= "Check Cloud AV page with multiorguser";
  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
  		
	  	//Verifying document page with  Role A
	  	sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.AROLE");
	  	sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.AROLE");
	  		  		
  		loginNavigator(sUserName,sPassword);
  		//Navigate to cloud AV
  		navigateToCloudAV();
  		WebObjectUtil.explicitWait(5);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_CloudAVImage());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Cloud AV page verified");
  		
  		sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
  		switchOraganization(sOrgName);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_CloudAVImage());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Cloud AV page verified");
  		
  		sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME3");
  		switchOraganization(sOrgName);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_CloudAVImage());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Cloud AV page verified");
  		
  		//Logging out from Navigator application
  		LoginTestCase.nav_Logout();
  		
  		
  		//Verifying document page with  Role C
	  	sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.CROLE");
	  	sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.CROLE");
	  		  		
  		loginNavigator(sUserName,sPassword);
  		//Navigate to cloud AV
  		navigateToCloudAV();
  		WebObjectUtil.explicitWait(5);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_CloudAVImage());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Cloud AV page verified");
  		
  		sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
  		switchOraganization(sOrgName);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_CloudAVImage());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Cloud AV page verified");
  		
  		sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME3");
  		switchOraganization(sOrgName);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_CloudAVImage());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Cloud AV page verified");
  		
  		//Logging out from Navigator application
  		LoginTestCase.nav_Logout();
  		
  		
  		//Verifying document page with  Role E
	  	sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.EROLE");
	  	sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.EROLE");
	  		  		
  		loginNavigator(sUserName,sPassword);
  		//Navigate to cloud AV
  		navigateToCloudAV();
  		WebObjectUtil.explicitWait(5);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_CloudAVImage());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Cloud AV page verified");
  		
  		sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
  		switchOraganization(sOrgName);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_CloudAVImage());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Cloud AV page verified");
  		
  		sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME3");
  		switchOraganization(sOrgName);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_CloudAVImage());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Cloud AV page verified");
  		
  		//Logging out from Navigator application
  		LoginTestCase.nav_Logout();
  		
  		
	}
	
	/*==============================================================
	TestScript  	: navVerDDoSMitigationWithMultiOrg
	Manual TestCase	: Check DDoS Mitigation page with multiorguser
	Description		: Verify the below changes happened in the DDoS Mitigation page:
					1. Make sure that page changes according to organization
					2. Make sure that org selector changes
					3. Make sure that data changes according to selected organization
	Author 			: Vivek Kumar
	Creation Date 	: 07/20/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=15)
	public void navVerDDoSMitigationWithMultiOrg()
	{

		String sUserName,sPassword,sOrgName;
		boolean bStatus;
		
		WebDriver driver = WebDriverUtil.getDriver();
  		PageFactory.initElements(driver, UserPermission);
  		PageFactory.initElements(driver, UPMultiOrg);
  		FrameworkUtil.sTestCaseName = "UserPermission-navVerDDoSMitigationWithMultiOrg";
  		FrameworkUtil.sManualTestCaseName= "Check DDoS Mitigation page with multiorguser";
  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
  		
	  	//Verifying document page with  Role A
	  	sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.AROLE");
	  	sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.AROLE");
	  		  		
  		loginNavigator(sUserName,sPassword);
  		//Navigate to DDos Mitigation
  		navigateToDDosMitigation();
  		WebObjectUtil.explicitWait(5);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_DDosMitigationImage());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "DDos Mitigation page verified");

  		sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
  		switchOraganization(sOrgName);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_DDosMitigationImage());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "DDos Mitigation page verified");
  		
  		sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME3");
  		switchOraganization(sOrgName);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_DDosMitigationImage());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "DDos Mitigation page verified");
  		
  		//Logging out from Navigator application
  		LoginTestCase.nav_Logout();
  		
  		
  		//Verifying document page with  Role C
	  	sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.CROLE");
	  	sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.CROLE");
	  		  		
  		loginNavigator(sUserName,sPassword);
  		//Navigate to DDos Mitigation
  		navigateToDDosMitigation();
  		WebObjectUtil.explicitWait(5);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_DDosMitigationImage());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "DDos Mitigation page verified");

  		sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
  		switchOraganization(sOrgName);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_DDosMitigationImage());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "DDos Mitigation page verified");
  		
  		sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME3");
  		switchOraganization(sOrgName);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_DDosMitigationImage());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "DDos Mitigation page verified");
  		
  		//Logging out from Navigator application
  		LoginTestCase.nav_Logout();
  		
  		
  		//Verifying document page with  Role E
	  	sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.EROLE");
	  	sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.EROLE");
	  		  		
  		loginNavigator(sUserName,sPassword);
  		//Navigate to DDos Mitigation
  		navigateToDDosMitigation();
  		WebObjectUtil.explicitWait(5);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_DDosMitigationImage());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "DDos Mitigation page verified");

  		sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
  		switchOraganization(sOrgName);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_DDosMitigationImage());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "DDos Mitigation page verified");
  		
  		sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME3");
  		switchOraganization(sOrgName);
  		bStatus=WebObjectUtil.isElementPresent(UPMultiOrg.getNav_DDosMitigationImage());
  		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "DDos Mitigation page verified");
  		
  		//Logging out from Navigator application
  		LoginTestCase.nav_Logout();
  		
	}
	
	
	
	
	/*==============================================================
	Method Name 	: switchOraganization
	Description		: This method will switch to different org based on Parameter Value
	Author 			: Sukur Babu
	Creation Date 	: 09/07/2015
	Pre-Requisites	:
	Revision History:Change to single organization - Vivek 7/15/2015
	==============================================================*/
	
	public static void switchOraganization(String sOrgName)
	{
		String sOrgText;
        try{
              
             WebDriver driver = WebDriverUtil.getDriver();
        	 PageFactory.initElements(driver, UserPermission);
        	 PageFactory.initElements(driver, UPMultiOrg);     
              
              WebObjectUtil.ClickAndMouseHover(UPMultiOrg.getNav_OrganizationnameLink());
              
             /* WebElement wOrgItemTemp=WebObjectUtil.GetWebElement("xpath", "//li[@id='organization']/ul", sOrgName);
              WebObjectUtil.selectCustomWebList(wOrgItemTemp, 1);*/
              WebObjectUtil.ClickAndMouseHover(UPMultiOrg.getNav_OrganizationnameLink());
              //This line updated on 10/05/2015 for EXTJS5 by QAA03
              //WebElement wOrgItem=WebObjectUtil.GetWebElement("xpath", "//li[@id='organization']/ul/li/a[text()='"+sOrgName+"']", sOrgName);
              WebElement wOrgItem=WebObjectUtil.GetWebElement("xpath", "//li[@id='organization']//a[text()='"+sOrgName+"']", sOrgName);
              if(wOrgItem!=null)
              {
                    wOrgItem.click();
                    WebObjectUtil.explicitWait(5);
                    sOrgText=UPMultiOrg.getNav_OrganizationnameLink().getText();
                    if(sOrgText.equalsIgnoreCase(sOrgName))
                          FrameworkUtil.updateCustomResultBasedOnStatus(true, sOrgName + " organization displayed after selction" );
                    else
                          FrameworkUtil.updateCustomResultBasedOnStatus(false, sOrgName + " organization not displayed after selction" );
              }
              else
              {
            	  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Organization Value ", "fail", "null");
              }
            }
        catch(Exception e){
        	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
			LoggerUtil.log_type_error(e.getMessage());
        }
  }

	
	/*==============================================================
	Method Name 	: navigateToCloudAPI
	Description		: This will navigate to cloud API page
	Author 			: Vivek Kumar
	Creation Date 	: 15/07/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navigateToCloudAPI()
	{
		WebDriver driver = WebDriverUtil.getDriver();
  		PageFactory.initElements(driver, UserPermission);
  		PageFactory.initElements(driver, UPMultiOrg);
		//Clicking and Verifying Cloud API Link URL
		WebObjectUtil.ClickAndMouseHover(UserPermission.getNav_ServicesTab());
		WebObjectUtil.clickAndVerifyUrl(UPMultiOrg.getNav_CloudAPIMenuLink(),(String)FrameworkUtil.dictPropertyData.get("NAV.CLOUDAPIMENULINK.URL"));
		
	}
	
	
	/*==============================================================
	Method Name 	: navigateToDDosMitigation
	Description		: This will navigate to DDos Mitigation page
	Author 			: Vivek Kumar
	Creation Date 	: 20/07/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navigateToDDosMitigation()
	{
		WebDriver driver = WebDriverUtil.getDriver();
  		PageFactory.initElements(driver, UPMultiOrg);
  		
  		//Clicking and Verifying DDoSMitigation Link URL
		WebObjectUtil.ClickAndMouseHover(UPMultiOrg.getNav_SecurityTab());
		WebObjectUtil.clickAndVerifyUrl(UPMultiOrg.getNav_DDoSMitigationMenuLink(),(String)FrameworkUtil.dictPropertyData.get("NAV.DDOSMENULINK.URL"));
		
	}
	
	
	/*==============================================================
	Method Name 	: navigateToCloudAV
	Description		: This will navigate to cloud AV page
	Author 			: Vivek Kumar
	Creation Date 	: 20/07/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navigateToCloudAV()
	{
		WebDriver driver = WebDriverUtil.getDriver();
  		PageFactory.initElements(driver, UPMultiOrg);
		
		//Clicking and Verifying Cloud AV Link URL
  		WebObjectUtil.ClickAndMouseHover(UPMultiOrg.getNav_SecurityTab());
		WebObjectUtil.clickAndVerifyUrl(UPMultiOrg.getNav_CloudAVMenuLink(),(String)FrameworkUtil.dictPropertyData.get("NAV.CLOUDAVMENULINK.URL"));
		
	}
	
	

	/*==============================================================
	Method Name 	: navigateToDocument
	Description		: This will navigate to Document page
	Author 			: Vivek Kumar
	Creation Date 	: 15/07/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navigateToDocument()
	{

		//Clicking and Verifying Documents Link URL
		WebObjectUtil.ClickAndMouseHover(UserPermission.getNav_SupportTab());
		WebObjectUtil.clickAndVerifyUrl(UPMultiOrg.getNav_DocumentsMenuLink(),(String)FrameworkUtil.dictPropertyData.get("NAV.DOCUMENTSMENULINK.URL"));
		
	}
	
	

	/*==============================================================
	Method Name 	: navigateToAnnouncement
	Description		: This will navigate to Announcement page
	Author 			: Vivek Kumar
	Creation Date 	: 15/07/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navigateToAnnouncement()
	{
		//Clicking and Verifying Announcements Link URL
		WebObjectUtil.ClickAndMouseHover(UserPermission.getNav_SupportTab());
		WebObjectUtil.clickAndVerifyUrl(UPMultiOrg.getNav_AnnouncementsMenuLink(),(String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENTSMENULINK.URL"));
	}
	
  	
	
////#########################################################Vivek end##############################################
////?????????????????????????????????????????Sukur start????????????????????????????????????????????????????????????????
	@Test(priority=21)
	public void multiOrgUserAccessToEscaltionListpage()
	{
		try{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, UserPerm);	
		PageFactory.initElements(driver, UPMultiOrg);
		String sUserName,sPassword,sOrgName1,sOrgName2,sOrgText,sGiraffsEscalationData,sDevCoEscalationData,sTstDevcoEscalationData,sOrgName0;
		
		FrameworkUtil.sTestCaseName = "UserPermissions-multiOrgUserAccessToEscaltionListpage";
		FrameworkUtil.sManualTestCaseName="Verifying multi organization users ARole-A,ARole-C and ARole-E are able to access escalation list page";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		//11 Girafs user logs in and get the escaltion data and log out
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.11GIRAFFS.USERID.AROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.11GIRAFFS.PASSWORD.AROLE");
		LoginTestCase.nav_Login(sUserName,sPassword);
		NavigateToCriticalEscalationListPage();
		WebElement w11GirafEscalationTabelrow=WebTableUtil.getRowAsWebElement(UserPerm.getNav_CriticalEscalationListTable(), 1);
		sGiraffsEscalationData=w11GirafEscalationTabelrow.getText();
		LoginTestCase.nav_Logout();
		//TST Devco user logs in and get the eescaltion data and log out
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO.USERID.AROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO.PASSWORD.AROLE");
		LoginTestCase.nav_Login(sUserName,sPassword);
		NavigateToCriticalEscalationListPage();
		WebElement wTstDevcoEscalationTabelrow=WebTableUtil.getRowAsWebElement(UserPerm.getNav_CriticalEscalationListTable(), 1);
		sTstDevcoEscalationData=wTstDevcoEscalationTabelrow.getText();
		LoginTestCase.nav_Logout();
		//Multi org user logs in and verifies escalation data is matching or not
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.AROLE1");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.AROLE");
		
		sOrgName0=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME1");
		sOrgName1=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
		sOrgName2=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME3");
		loginNavigator(sUserName,sPassword);
		NavigateToCriticalEscalationListPage();
		//selectOrgs(sOrgName0);
		verifyEscalationDataForMultiOrg(sGiraffsEscalationData);
		selectOrgs(sOrgName1);
		verifyEscalationDataForMultiOrg(sTstDevcoEscalationData);
		selectOrgs(sOrgName2);
		LoginTestCase.nav_Logout();
		
		
		//Multi org user logs in and verifies escalation data is matching or not
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.CROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.CROLE");
		
		sOrgName1=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
		sOrgName2=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME3");
		loginNavigator(sUserName,sPassword);
		NavigateToCriticalEscalationListPage();
		verifyEscalationDataForMultiOrg(sGiraffsEscalationData);
		selectOrgs(sOrgName1);
		verifyEscalationDataForMultiOrg(sTstDevcoEscalationData);
		selectOrgs(sOrgName2);
		LoginTestCase.nav_Logout();
		
		//Multi org user logs in and verifies escalation data is matching or not
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.EROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.EROLE");
		
		sOrgName1=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
		sOrgName2=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME3");
		loginNavigator(sUserName,sPassword);
		NavigateToCriticalEscalationListPage();
		//verifyEscalationDataForMultiOrg(sGiraffsEscalationData);
		selectOrgs(sOrgName1);
		//verifyEscalationDataForMultiOrg(sTstDevcoEscalationData);
		selectOrgs(sOrgName2);
		LoginTestCase.nav_Logout();
		}
		catch(Exception e){
			LoggerUtil.log_type_error("issue with- multiOrgUserAccessToEscaltionListpage" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	
	}
	
	
	/*==============================================================
	TestScript 		: multiOrgUserAccessToEVDCOverviewpage
	Manual TestCase	: Check EVDC overview page with multiorguser
	Description		: Verifying multi organization users ARole-A,ARole-C and ARole-E are able to access EVDC Overview Page page
	Author 			: Sukur Babu. B
	Creation Date 	: 13/07/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	//@Test(priority=22)
	public void multiOrgUserAccessToEVDCOverviewpage()
	{
		try{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, UserPerm);	
		PageFactory.initElements(driver, UPMultiOrg);
		String sUserName,sPassword,sOrgName11Giraffes,sOrgNameTstDevco,sOrgNameTststarttrek,sOrgText,sExpEVDCStarTrekItem,sExpEVDC11GirItem,sExpEVDCTstDevcoItem;
		
		FrameworkUtil.sTestCaseName = "UserPermissions-multiOrgUserAccessToEVDCOverviewpage";
		FrameworkUtil.sManualTestCaseName="Verifying multi organization users ARole-A,ARole-C and ARole-E are able to access EVDC Overview page";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		//Verify ARole-A user is able to access Detailed Ticket System
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.AROLE1");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.AROLE");
		sOrgName11Giraffes=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME1");
		sOrgNameTstDevco=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
		sOrgNameTststarttrek=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME3");
		sExpEVDCStarTrekItem=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.EVDC.STARTTREK.ORG.NAME");
		sExpEVDC11GirItem=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.EVDC.11GIRAFFE.ORG.NAME");
		sExpEVDCTstDevcoItem=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.EVDC.TSTDEVCO.ORG.NAME");
		loginNavigator(sUserName,sPassword);
		NavigateToEVDCOverviewPage();
		//selectOrgs(sOrgName0);
		verifyEVDCDropdownItem(sExpEVDC11GirItem);
		selectEVDC(sExpEVDC11GirItem);
		verifyEVDCPageReflectsDataAsperOrg(sExpEVDC11GirItem);
		selectOrgs(sOrgNameTstDevco);
		verifyEVDCDropdownItem(sExpEVDCTstDevcoItem);
		selectEVDC(sExpEVDCTstDevcoItem);
		verifyEVDCPageReflectsDataAsperOrg(sExpEVDCTstDevcoItem);
		selectOrgs(sOrgNameTststarttrek);
		verifyEVDCDropdownItem(sExpEVDCStarTrekItem);
		selectEVDC(sExpEVDCStarTrekItem);
		verifyEVDCPageReflectsDataAsperOrg(sExpEVDCStarTrekItem);
		LoginTestCase.nav_Logout();
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.CROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.CROLE");
		loginNavigator(sUserName,sPassword);
		NavigateToEVDCOverviewPage();
		//selectOrgs(sOrgName1);
		verifyEVDCDropdownItem(sExpEVDC11GirItem);
		selectEVDC(sExpEVDC11GirItem);
		verifyEVDCPageReflectsDataAsperOrg(sExpEVDC11GirItem);
		selectOrgs(sOrgNameTstDevco);
		verifyEVDCDropdownItem(sExpEVDCTstDevcoItem);
		selectEVDC(sExpEVDCTstDevcoItem);
		verifyEVDCPageReflectsDataAsperOrg(sExpEVDCTstDevcoItem);
		selectOrgs(sOrgNameTststarttrek);
		verifyEVDCDropdownItem(sExpEVDCStarTrekItem);
		selectEVDC(sExpEVDCStarTrekItem);
		verifyEVDCPageReflectsDataAsperOrg(sExpEVDCStarTrekItem);
		LoginTestCase.nav_Logout();
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.EROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.EROLE");
		loginNavigator(sUserName,sPassword);
		NavigateToEVDCOverviewPage();
		verifyEVDCDropdownItem(sExpEVDC11GirItem);
		selectEVDC(sExpEVDC11GirItem);
		verifyEVDCPageReflectsDataAsperOrg(sExpEVDC11GirItem);
		selectOrgs(sOrgNameTstDevco);
		verifyEVDCDropdownItem(sExpEVDCTstDevcoItem);
		selectEVDC(sExpEVDCTstDevcoItem);
		verifyEVDCPageReflectsDataAsperOrg(sExpEVDCTstDevcoItem);
		selectOrgs(sOrgNameTststarttrek);
		verifyEVDCDropdownItem(sExpEVDCStarTrekItem);
		selectEVDC(sExpEVDCStarTrekItem);
		verifyEVDCPageReflectsDataAsperOrg(sExpEVDCStarTrekItem);
		LoginTestCase.nav_Logout();
		}
		catch(Exception e){
			LoggerUtil.log_type_error("issue with- multiOrgUserAccessToEVDCOverviewpage" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	
	}
	/*==============================================================
	TestScript 		: multiOrgUserAccessToEVDCVMpage
	Manual TestCase	: Check EVDC VM page with multiorguser
	Description		: Verifying multi organization users ARole-A,ARole-C and ARole-E are able to access EVDC VM Page page
	Author 			: Sukur Babu. B
	Creation Date 	: 13/07/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=23)
	public void multiOrgUserAccessToEVDCVMpage()
	{
		try{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, UserPerm);	
		PageFactory.initElements(driver, UPMultiOrg);
		String sUserName,sPassword,sOrgName1,sOrgName2,sOrgText,sGiraffsVMData,sTstDevcoVMData,sExpEVDCStarTrekItem,sExpEVDC11GirItem,sExpEVDCTstDevcoItem;
		String sOrgNameTstDevco,sOrgNameTststarttrek;
		FrameworkUtil.sTestCaseName = "UserPermissions-multiOrgUserAccessToEVDCVMpage";
		FrameworkUtil.sManualTestCaseName="Verifying multi organization users ARole-A,ARole-C and ARole-E are able to access EVDC VM page";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		//11 Girafs user logs in and get the escaltion data and log out
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.11GIRAFFS.USERID.AROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.11GIRAFFS.PASSWORD.AROLE");
		LoginTestCase.nav_Login(sUserName,sPassword);
		NavigateToVMPage();
		WebElement w11GirafVMTabelrow=WebTableUtil.getRowAsWebElement(UserPerm.getNav_VMWebTable(), 1);
		sGiraffsVMData=w11GirafVMTabelrow.getText();
		LoginTestCase.nav_Logout();
		//TST Devco user logs in and get the eescaltion data and log out
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO.USERID.AROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO.PASSWORD.AROLE");
		LoginTestCase.nav_Login(sUserName,sPassword);
		NavigateToVMPage();
		WebElement wTstDevcoVMTabelrow=WebTableUtil.getRowAsWebElement(UserPerm.getNav_VMWebTable(), 1);
		sTstDevcoVMData=wTstDevcoVMTabelrow.getText();
		LoginTestCase.nav_Logout();
		
		//Verify ARole-A user is able to access Detailed Ticket System
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.AROLE1");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.AROLE");
		
		sExpEVDCStarTrekItem=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.EVDC.STARTTREK.ORG.NAME");
		sExpEVDC11GirItem=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.EVDC.11GIRAFFE.ORG.NAME");
		sExpEVDCTstDevcoItem=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.EVDC.TSTDEVCO.ORG.NAME");
		
		sOrgNameTstDevco=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
		sOrgNameTststarttrek=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME3");
		
		loginNavigator(sUserName,sPassword);
		NavigateToVMPage();
		selectEVDC(sExpEVDC11GirItem);
		verifyVMDataForMultiOrg(sGiraffsVMData);
		selectOrgs(sOrgNameTstDevco);
		selectEVDC(sExpEVDCTstDevcoItem);
		WebObjectUtil.explicitWait(10);
		verifyVMDataForMultiOrg(sTstDevcoVMData);
		selectOrgs(sOrgNameTststarttrek);
		selectEVDC(sExpEVDCStarTrekItem);
		LoginTestCase.nav_Logout();
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.CROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.CROLE");
		loginNavigator(sUserName,sPassword);
		NavigateToVMPage();
		selectEVDC(sExpEVDC11GirItem);
		verifyVMDataForMultiOrg(sGiraffsVMData);
		selectOrgs(sOrgNameTstDevco);
		selectEVDC(sExpEVDCTstDevcoItem);
		verifyVMDataForMultiOrg(sTstDevcoVMData);
		selectOrgs(sOrgNameTststarttrek);
		selectEVDC(sExpEVDCStarTrekItem);
		LoginTestCase.nav_Logout();
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.EROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.EROLE");
		loginNavigator(sUserName,sPassword);
		NavigateToVMPage();
		selectEVDC(sExpEVDC11GirItem);
		verifyVMDataForMultiOrg(sGiraffsVMData);
		selectOrgs(sOrgNameTstDevco);
		selectEVDC(sExpEVDCTstDevcoItem);
		verifyVMDataForMultiOrg(sTstDevcoVMData);
		selectOrgs(sOrgNameTststarttrek);
		selectEVDC(sExpEVDCStarTrekItem);
		LoginTestCase.nav_Logout();
		}
		catch(Exception e){
			LoggerUtil.log_type_error("issue with- multiOrgUserAccessToEVDCVMpage" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	/*==============================================================
	TestScript 		: multiOrgUserAccessToEVDCCatalogpage
	Manual TestCase	: Check EVDC Catalog page with multiorguser
	Description		: Verifying multi organization users ARole-A,ARole-C and ARole-E are able to access EVDC Catalog Page page
	Author 			: Sukur Babu. B
	Creation Date 	: 13/07/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=24)
	public void multiOrgUserAccessToEVDCCatalogpage()
	{
		try{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, UserPerm);	
		PageFactory.initElements(driver, UPMultiOrg);
		String sUserName,sPassword,sOrgName1,sOrgName2,sOrgText,sGiraffsCtlgData,sTstDevcoCtlgData,sExpEVDCStarTrekItem,sExpEVDC11GirItem,sExpEVDCTstDevcoItem;
		String sOrgNameTstDevco,sOrgNameTststarttrek;
		
		FrameworkUtil.sTestCaseName = "UserPermissions-multiOrgUserAccessToEVDCCatalogpage";
		FrameworkUtil.sManualTestCaseName="Verifying multi organization users ARole-A,ARole-C and ARole-E are able to access EVDC Catalog page";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		//11 Girafs user logs in and get the escaltion data and log out
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.11GIRAFFS.USERID.AROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.11GIRAFFS.PASSWORD.AROLE");
		LoginTestCase.nav_Login(sUserName,sPassword);
		NavigateToCatalogPage();
		WebElement w11GirafCtlgTabelrow=WebTableUtil.getRowAsWebElement(UPMultiOrg.getNav_CatalogWsWebTable(), 1);
		sGiraffsCtlgData=w11GirafCtlgTabelrow.getText();
		
		LoginTestCase.nav_Logout();
		
		//TST Devco user logs in and get the eescaltion data and log out
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO.USERID.AROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO.PASSWORD.AROLE");
		LoginTestCase.nav_Login(sUserName,sPassword);
		NavigateToCatalogPage();
		WebElement wTstDevcoCtlgTabelrow=WebTableUtil.getRowAsWebElement(UPMultiOrg.getNav_CatalogWsWebTable(), 1);
		sTstDevcoCtlgData=wTstDevcoCtlgTabelrow.getText();
		LoginTestCase.nav_Logout();
		
		//Verify ARole-A user is able to access Detailed Ticket System
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.AROLE1");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.AROLE");
		
		sExpEVDCStarTrekItem=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.EVDC.STARTTREK.ORG.NAME");
		sExpEVDC11GirItem=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.EVDC.11GIRAFFE.ORG.NAME");
		sExpEVDCTstDevcoItem=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.EVDC.TSTDEVCO.ORG.NAME");
		
		sOrgNameTstDevco=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
		sOrgNameTststarttrek=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME3");
		
		loginNavigator(sUserName,sPassword);
		NavigateToCatalogPage();
		verifyCtlgDataForMultiOrg(sGiraffsCtlgData);
		selectOrgs(sOrgNameTstDevco);
		selectEVDC(sExpEVDCTstDevcoItem);
		verifyCtlgDataForMultiOrg(sTstDevcoCtlgData);
		selectOrgs(sOrgNameTststarttrek);
		selectEVDC(sExpEVDCStarTrekItem);
		LoginTestCase.nav_Logout();
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.CROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.CROLE");
		loginNavigator(sUserName,sPassword);
		NavigateToCatalogPage();
		verifyCtlgDataForMultiOrg(sGiraffsCtlgData);
		selectOrgs(sOrgNameTstDevco);
		selectEVDC(sExpEVDCTstDevcoItem);
		verifyCtlgDataForMultiOrg(sTstDevcoCtlgData);
		selectOrgs(sOrgNameTststarttrek);
		selectEVDC(sExpEVDCStarTrekItem);
		LoginTestCase.nav_Logout();
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.EROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.EROLE");
		loginNavigator(sUserName,sPassword);
		NavigateToCatalogPage();
		verifyCtlgDataForMultiOrg(sGiraffsCtlgData);
		selectOrgs(sOrgNameTstDevco);
		selectEVDC(sExpEVDCTstDevcoItem);
		verifyCtlgDataForMultiOrg(sTstDevcoCtlgData);
		selectOrgs(sOrgNameTststarttrek);
		selectEVDC(sExpEVDCStarTrekItem);
		LoginTestCase.nav_Logout();
		}
		catch(Exception e){
			LoggerUtil.log_type_error("issue with- multiOrgUserAccessToEVDCVMpage" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	/*==============================================================
	TestScript 		: multiOrgUserAccessToEVDCFirewallpage
	Manual TestCase	: Check EVDC Firewall page with multiorguser
	Description		: Verifying multi organization users ARole-A,ARole-C and ARole-E are able to access EVDC Firewall Page page
	Author 			: Sukur Babu. B
	Creation Date 	: 14/07/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=25)
	public void multiOrgUserAccessToEVDCFirewallpage()
	{
		try{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, UserPerm);	
		PageFactory.initElements(driver, UPMultiOrg);
		String sUserName,sPassword,sOrgName1,sOrgName2,sOrgText,sGiraffsFirewallData,sTstDevcoFirewallData,sExpEVDCStarTrekItem,sExpEVDC11GirItem,sExpEVDCTstDevcoItem;
		String sOrgNameTstDevco,sOrgNameTststarttrek;
		
		FrameworkUtil.sTestCaseName = "UserPermissions-multiOrgUserAccessToEVDCFirewallpage";
		FrameworkUtil.sManualTestCaseName="Verifying multi organization users ARole-A,ARole-C and ARole-E are able to access EVDC Firewall page";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		//11 Girafs user logs in and get the escaltion data and log out
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.11GIRAFFS.USERID.AROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.11GIRAFFS.PASSWORD.AROLE");
		
		System.out.println(sUserName +  "  " + sPassword);
		LoginTestCase.nav_Login(sUserName,sPassword);
		NavigateToFirewallPage();
		WebElement w11GirafFirewallTabelrow=WebTableUtil.getRowAsWebElement(UserPerm.getNav_FirewallTable(), 1);
		sGiraffsFirewallData=w11GirafFirewallTabelrow.getText();
		LoginTestCase.nav_Logout();
		
		//TST Devco user logs in and get the eescaltion data and log out
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO.USERID.AROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO.PASSWORD.AROLE");
		LoginTestCase.nav_Login(sUserName,sPassword);
		NavigateToFirewallPage();
		WebElement wTstDevcoFirewallTabelrow=WebTableUtil.getRowAsWebElement(UserPerm.getNav_FirewallTable(), 1);
		sTstDevcoFirewallData=wTstDevcoFirewallTabelrow.getText();
		LoginTestCase.nav_Logout();
		
		//Verify ARole-A user is able to access Detailed Ticket System
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.AROLE1");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.AROLE");
		
		sExpEVDCStarTrekItem=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.EVDC.STARTTREK.ORG.NAME");
		sExpEVDC11GirItem=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.EVDC.11GIRAFFE.ORG.NAME");
		sExpEVDCTstDevcoItem=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.EVDC.TSTDEVCO.ORG.NAME");
		
		sOrgNameTstDevco=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
		sOrgNameTststarttrek=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME3");
		
		loginNavigator(sUserName,sPassword);
		NavigateToFirewallPage();
		selectEVDC(sExpEVDC11GirItem);
		verifyFirwallDataForMultiOrg(sGiraffsFirewallData);
		selectOrgs(sOrgNameTstDevco);
		selectEVDC(sExpEVDCTstDevcoItem);
		verifyFirwallDataForMultiOrg(sTstDevcoFirewallData);
		selectOrgs(sOrgNameTststarttrek);
		selectEVDC(sExpEVDCStarTrekItem);
		LoginTestCase.nav_Logout();
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.CROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.CROLE");
		loginNavigator(sUserName,sPassword);
		NavigateToFirewallPage();
		selectEVDC(sExpEVDC11GirItem);
		verifyFirwallDataForMultiOrg(sGiraffsFirewallData);
		selectOrgs(sOrgNameTstDevco);
		selectEVDC(sExpEVDCTstDevcoItem);
		verifyFirwallDataForMultiOrg(sTstDevcoFirewallData);
		selectOrgs(sOrgNameTststarttrek);
		selectEVDC(sExpEVDCStarTrekItem);
		LoginTestCase.nav_Logout();
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.EROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.EROLE");
		loginNavigator(sUserName,sPassword);
		NavigateToFirewallPage();
		selectEVDC(sExpEVDC11GirItem);
		WebObjectUtil.explicitWait(10);
		verifyFirwallDataForMultiOrg(sGiraffsFirewallData);
		selectOrgs(sOrgNameTstDevco);
		selectEVDC(sExpEVDCTstDevcoItem);
		verifyFirwallDataForMultiOrg(sTstDevcoFirewallData);
		selectOrgs(sOrgNameTststarttrek);
		selectEVDC(sExpEVDCStarTrekItem);
		LoginTestCase.nav_Logout();
		}
		catch(Exception e){
			LoggerUtil.log_type_error("issue with- multiOrgUserAccessToEVDCFirewallpage" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	TestScript 		: multiOrgUserAccessToDNSpage
	Manual TestCase	: Check DNS page with multiorguser
	Description		: Verifying multi organization users ARole-A,ARole-C and ARole-E are able to access DNS Page page
	Author 			: Sukur Babu. B
	Creation Date 	: 15/07/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=26)
	public void multiOrgUserAccessToDNSpage()
	{
		try{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, UserPerm);
		PageFactory.initElements(driver, UPMultiOrg);
		String sUserName,sPassword,sOrgName1,sOrgName2,sOrgText,sDNSWarnMsg;
		
		FrameworkUtil.sTestCaseName = "UserPermissions-multiOrgUserAccessToDNSpage";
		FrameworkUtil.sManualTestCaseName="Verifying multi organization users ARole-A,ARole-C and ARole-E are able to access DNS page";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		//Verify ARole-A user is able to access Detailed Ticket System
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.AROLE1");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.AROLE");
		sOrgName1=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
		sOrgName2=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME3");
		
		sDNSWarnMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.MULTIORG.DNS.WARN.MSG");
		
		loginNavigator(sUserName,sPassword);
		NavigateToDNSPage();
		selectOrgs(sOrgName1);
		verifyDNSWarnMsg(sDNSWarnMsg);
		selectOrgs(sOrgName2);
		verifyDNSWarnMsg(sDNSWarnMsg);
		LoginTestCase.nav_Logout();
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.CROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.CROLE");
		loginNavigator(sUserName,sPassword);
		NavigateToDNSPage();
		selectOrgs(sOrgName1);
		verifyDNSWarnMsg(sDNSWarnMsg);
		selectOrgs(sOrgName2);
		verifyDNSWarnMsg(sDNSWarnMsg);
		LoginTestCase.nav_Logout();
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.EROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.EROLE");
		loginNavigator(sUserName,sPassword);
		NavigateToDNSPage();
		selectOrgs(sOrgName1);
		verifyDNSWarnMsg(sDNSWarnMsg);
		selectOrgs(sOrgName2);
		verifyDNSWarnMsg(sDNSWarnMsg);
		LoginTestCase.nav_Logout();
		}
		catch(Exception e){
			LoggerUtil.log_type_error("issue with- multiOrgUserAccessToDNSpage" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}

	
	//################################################################MULTI - ORG#############################################################################
	/*==============================================================
	Method Name 	: loginNavigator
	Description		: Login and click on Use this organization button and verifies .Hosted solution 
	is displayed as default organization name
	Author 			: Sukur Babu. B
	Creation Date 	: 09/07/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	public static void loginNavigator(String sUserName,String sPassword){
		PageFactory.initElements(WebDriverUtil.getDriver(), UPMultiOrg);
		try{
			String sExpMultiorgpagename,sActMultiorgpagename,sExpOrgName,sActOrgName;
			sExpMultiorgpagename=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.START.PAGE.NAME");
			sExpOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME1");
			LoginTestCase.nav_Login(sUserName,sPassword);
			//elementHighlight(UserPerm.getNav_MultOrgPageText());
			sActMultiorgpagename=UPMultiOrg.getNav_MultOrgPageText().getText();
			
			if(sExpMultiorgpagename.contains(sActMultiorgpagename))
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verify Select Organization page displays", "pass", "Select Organization page displayed");
			else
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verify Select Organization page displays", "fail", "Select Organization page not displayed");
			WebObjectUtil.clickElement(UPMultiOrg.getNav_UseThisOrgButton());
			//WebObjectUtil.waitForElementPresent(UserPerm.getNav_TicketPortalLink());
			WebObjectUtil.explicitWait(5);
			sActOrgName=UPMultiOrg.getNav_OrganizationnameLink().getText();
			if(sActOrgName.equalsIgnoreCase(sExpOrgName))
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verify expected default organization displays", "pass", "Expected Organization"+sExpOrgName+"displayed");
			else
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verify expected default organization displays", "fail", "Expected Organization"+sExpOrgName+" not displayed");
			
		}
		catch(Exception e){
			LoggerUtil.log_type_error("issue with- loginNavigator method" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	Method Name 	: selectOrgs
	Description		: Selects the organization and verifies whether seleted displayed or not 
	Author 			: Sukur Babu. B
	Creation Date 	: 09/07/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	public static void verifyEscalationDataForMultiOrg(String sOrgData){
		PageFactory.initElements(WebDriverUtil.getDriver(), UPMultiOrg);
		try{
			String sActOrgEscalationData;
			WebElement wEscalationDatarow=WebTableUtil.getRowAsWebElement(UserPerm.getNav_CriticalEscalationListTable(), 1);
			sActOrgEscalationData=wEscalationDatarow.getText();
			if(sActOrgEscalationData.equalsIgnoreCase(sOrgData))
				FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Organization Data is matching" );
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false, "Organization Data is not matching" );
			
		}
		catch(Exception e){
			LoggerUtil.log_type_error("issue with- verifyEscalationDataForMultiOrg method" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		}
	/*==============================================================
	Method Name 	: verifyVMDataForMultiOrg
	Description		: Verifies VM data based on selection of organization 
	Author 			: Sukur Babu. B
	Creation Date 	: 23/07/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
public static void verifyVMDataForMultiOrg(String sOrgData){
	PageFactory.initElements(WebDriverUtil.getDriver(), UPMultiOrg);
	try{
		String sActOrgVMData;
		WebElement wVMDatarow=WebTableUtil.getRowAsWebElement(UserPerm.getNav_VMWebTable(), 1);
		sActOrgVMData=wVMDatarow.getText();
		if(sActOrgVMData.equalsIgnoreCase(sOrgData))
			FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Organization Data is matching" );
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false, "Organization Data is not matching" );
		
	}
	catch(Exception e){
		LoggerUtil.log_type_error("issue with- verifyVMDataForMultiOrg method" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occurred", "fail", e.getMessage()+"null");
	}
}
/*==============================================================
Method Name 	: verifyCtlgDataForMultiOrg
Description		: Verifies Catalog data based on selection of organization 
Author 			: Sukur Babu. B
Creation Date 	: 23/07/2015
Pre-Requisites	:
Revision History:
==============================================================*/

public static void verifyCtlgDataForMultiOrg(String sOrgData){
	PageFactory.initElements(WebDriverUtil.getDriver(), UPMultiOrg);
try{
	String sActOrgCtlgData;
	WebElement wCtlgDatarow=WebTableUtil.getRowAsWebElement(UPMultiOrg.getNav_CatalogWsWebTable(), 1);
	sActOrgCtlgData=wCtlgDatarow.getText();
	if(sActOrgCtlgData.equalsIgnoreCase(sOrgData))
		FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Organization Data is matching" );
	else
		FrameworkUtil.updateCustomResultBasedOnStatus(false, "Organization Data is not matching" );
	
}
catch(Exception e){
	LoggerUtil.log_type_error("issue with- verifyCtlgDataForMultiOrg method" );
	LoggerUtil.log_type_error(e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occurred", "fail", e.getMessage()+"null");
}
}
/*==============================================================
Method Name 	: verifyFirwallDataForMultiOrg
Description		: Verifies Firewall data based on selection of organization 
Author 			: Sukur Babu. B
Creation Date 	: 23/07/2015
Pre-Requisites	:
Revision History:
==============================================================*/

public static void verifyFirwallDataForMultiOrg(String sOrgData){
	PageFactory.initElements(WebDriverUtil.getDriver(), UPMultiOrg);
try{
	String sActOrgFirewallData;
	WebElement wFirewallDatarow=WebTableUtil.getRowAsWebElement(UserPerm.getNav_FirewallTable(), 1);
	sActOrgFirewallData=wFirewallDatarow.getText();
	if(sActOrgFirewallData.equalsIgnoreCase(sOrgData))
		FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Organization Data is matching" );
	else
		FrameworkUtil.updateCustomResultBasedOnStatus(false, "Organization Data is not matching" );
	
}
catch(Exception e){
	LoggerUtil.log_type_error("issue with- verifyCtlgDataForMultiOrg method" );
	LoggerUtil.log_type_error(e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occurred", "fail", e.getMessage()+"null");
}
}
	//verifyEVDCDropdownItem();
	//verifyEVDCPageReflectsDataAsperOrg();
	/*==============================================================
	Method Name 	: verifyEVDCDropdownItem
	Description		: Selects the organization and verifies whether seleted displayed or not 
	Author 			: Sukur Babu. B
	Creation Date 	: 22/07/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	public static void verifyEVDCDropdownItem(String sExpItem){
		PageFactory.initElements(WebDriverUtil.getDriver(), UPMultiOrg);
		try{
			boolean bFndflag=false;
			String sItem;
			WebObjectUtil.explicitWait(3);
			WebObjectUtil.clickElement(UPMultiOrg.getNav_SelectEVDCText());
			WebObjectUtil.explicitWait(2);
			WebObjectUtil.ClickAndMouseHover(UPMultiOrg.getNav_EVDCSelectordropdown());
			WebObjectUtil.explicitWait(2);
			List<WebElement> webListItems = UPMultiOrg.getNav_EVDCSelectordropdown().findElements(By.tagName("li"));
			for (WebElement wb: webListItems){
				sItem =wb.getText() ;
				if (sItem.contains(sExpItem)){
					//WebObjectUtil.MouseHover(webElement);
					WebObjectUtil.explicitWait(2);
					bFndflag=true;
					break;
				}
				
			}
			if(bFndflag)
				FrameworkUtil.updateCustomResultBasedOnStatus(true, sExpItem + " is available in EVDC Selector drop down" );
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false, sExpItem + " is not available in EVDC Selector drop down" );
		}
		catch(Exception e){
			LoggerUtil.log_type_error("issue with- verifyEVDCDropdownItem method" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	/*==============================================================
	Method Name 	: verifyEVDCPageReflectsDataAsperOrg
	Description		: Selects the organization and verifies whether seleted displayed or not 
	Author 			: Sukur Babu. B
	Creation Date 	: 22/07/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	public static void verifyEVDCPageReflectsDataAsperOrg(String sEVDCItem){
		PageFactory.initElements(WebDriverUtil.getDriver(), UPMultiOrg);
		try{
			boolean bFndflag=false;
			String ssplitStr[],sReqItem;
			WebObjectUtil.explicitWait(5);
			ssplitStr=sEVDCItem.split("-");
			sReqItem=ssplitStr[1].trim();
			WebElement wEVDCNetworkItem=WebObjectUtil.GetWebElement("xpath", "//section[@id='networks']/div[@id='evdcNetworks']//div[contains(text(),'"+sReqItem+"')]", "EVDC Item");
			if(wEVDCNetworkItem!=null)
				FrameworkUtil.updateCustomResultBasedOnStatus(true, sReqItem + " is available after selecting EVDC item from EVDC selector" );
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false, sReqItem + " is not available after selecting EVDC item from EVDC selector" );
		}
		catch(Exception e){
			LoggerUtil.log_type_error("issue with- verifyEVDCPageReflectsDataAsperOrg method" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	//selectEVDC(sExpEVDCTstDevcoItem)
	/*==============================================================
	Method Name 	: selectEVDC
	Description		: Selects EVDC item 
	Author 			: Sukur Babu. B
	Creation Date 	: 22/07/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	public static void selectEVDC(String sEVDCItem){
		PageFactory.initElements(WebDriverUtil.getDriver(), UPMultiOrg);
		try{
			boolean bFndflag=false;
			String sItem;
			WebObjectUtil.ClickAndMouseHover(UPMultiOrg.getNav_EVDCSelectordropdown());
			List<WebElement> webListItems = UPMultiOrg.getNav_EVDCSelectordropdown().findElements(By.tagName("li"));
			for (WebElement wb1: webListItems){
				sItem =wb1.getText() ;
				if (sItem.contains(sEVDCItem)){
					//WebObjectUtil.MouseHover(webElement);
					WebObjectUtil.explicitWait(2);
					wb1.findElement(By.tagName("p")).click();
					bFndflag=true;
					break;
				}
			}
			
		}
		catch(Exception e){
			LoggerUtil.log_type_error("issue with- sEVDCItem method" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	Method Name 	: verifyDNSWarnMsg
	Description		: Verifies DNS Warning message
	Author 			: Sukur Babu. B
	Creation Date 	: 24/07/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	public static void verifyDNSWarnMsg(String sexpDNSMsg){
		PageFactory.initElements(WebDriverUtil.getDriver(), UPMultiOrg);
		try{
			WebDriver driver = WebDriverUtil.getDriver();
			String sTextOnPage = driver.findElement(By.tagName("body")).getText();
			 if (sTextOnPage.contains(sexpDNSMsg))
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), sexpDNSMsg+"is displayed" , "No Data found", "warn", "");
			else
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), sexpDNSMsg+"is not displayed now. Need to incorporate the logic in test case" , "No Data found", "warn", "");
		}
		catch(Exception e){
			LoggerUtil.log_type_error("issue with- verifyDNSWarnMsg method" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		}
	/*==============================================================
	Method Name 	: selectOrgs
	Description		: Selects the organization and verifies whether seleted displayed or not 
	Author 			: Sukur Babu. B
	Creation Date 	: 09/07/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	public static void selectOrgs(String sOrgName){
		PageFactory.initElements(WebDriverUtil.getDriver(), UPMultiOrg);
		try{
			String sOrgText;
			WebElement wOrgItem;
			//sOrgName1=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
			//sOrgName2=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME3");
			
			WebObjectUtil.ClickAndMouseHover(UPMultiOrg.getNav_OrganizationnameLink());
			//WebElement wOrgItem=WebObjectUtil.GetWebElement("xpath", "//li[@id='organization']/ul/li/a[text()='"+sOrgName+"']", sOrgName);
			
			// This object added by QAA04 -- 12/17/2015
			wOrgItem = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EBPANEL.MULTLYORG.ORGNAMETOSELECT", "PARAMETER_ORGNAME", sOrgName );

			//	WebElement wOrgItem=WebObjectUtil.GetWebElement("xpath", "//div[@id='org_user_wrapper']//ul//li//ul[@id='idMultiMenuOrgs']/li//a[text()='"+sOrgName+"']", sOrgName);
			if(wOrgItem!=null)
			{
				wOrgItem.click();
				WebObjectUtil.explicitWait(5);
				sOrgText=UPMultiOrg.getNav_OrganizationnameLink().getText();
				boolean bOrgname=sOrgText.equalsIgnoreCase(sOrgName);
                FrameworkUtil.updateCustomResultBasedOnStatus(bOrgname, sOrgText + " organization displayed after selction" );

				/*if(sOrgText.equalsIgnoreCase(sOrgName))
					FrameworkUtil.updateCustomResultBasedOnStatus(true, sOrgName + " organization displayed after selction" );
				else
					FrameworkUtil.updateCustomResultBasedOnStatus(false, sOrgName + " organization not displayed after selction" );
				*/
				
			}
			
		
				}
		catch(Exception e){
			LoggerUtil.log_type_error("issue with- selectOrgs method" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	/*==============================================================
	Method Name 	: changeOrgVerifyandSelectEVDCOrgListItem
	Description		: Selects the organization and verifies whether EVDC org data is changing accrodingly 
	Author 			: Sukur Babu. B
	Creation Date 	: 13/07/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void changeOrgVerifyandSelectEVDCOrgListItem()
	{
		PageFactory.initElements(WebDriverUtil.getDriver(), UPMultiOrg);
		try{
			String sOrgName1,sOrgName2,sOrgText,sExpEVDCHostedsolItem,sActEVDCHostedsolItem,sItem,sExpEVDC11GirItem,sExpEVDCTstDevcoItem;
			boolean bFndflag=false,bFndflag1=false,bFndflag2=false;
			sOrgName1=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
			sOrgName2=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME3");
			sExpEVDCHostedsolItem=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.EVDC.HOSTEDSOL.ORG.NAME");
			sExpEVDC11GirItem=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.EVDC.11GIRAFFE.ORG.NAME");
			sExpEVDCTstDevcoItem=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.EVDC.TSTDEVCO.ORG.NAME");
			sActEVDCHostedsolItem=UPMultiOrg.getNav_EVDCSelectorList().getText();
			if(sActEVDCHostedsolItem.equalsIgnoreCase(sExpEVDCHostedsolItem))
				FrameworkUtil.updateCustomResultBasedOnStatus(true, sExpEVDCHostedsolItem + " is matching with actual value of organization" );
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false, sExpEVDCHostedsolItem + " is not matching with actual value of organization" );
			WebObjectUtil.ClickAndMouseHover(UPMultiOrg.getNav_OrganizationnameLink());
			WebElement wOrgItem=WebObjectUtil.GetWebElement("xpath", "//li[@id='organization']/ul/li/a[text()='"+sOrgName1+"']", sOrgName1);
			if(wOrgItem!=null)
			{
				wOrgItem.click();
				WebObjectUtil.explicitWait(5);
				sOrgText=UPMultiOrg.getNav_OrganizationnameLink().getText();
				if(sOrgText.equalsIgnoreCase(sOrgName1))
					FrameworkUtil.updateCustomResultBasedOnStatus(true, sOrgName1 + " organization displayed after selction" );
				else
					FrameworkUtil.updateCustomResultBasedOnStatus(true, sOrgName1 + " organization not displayed after selction" );
				WebObjectUtil.ClickAndMouseHover(UPMultiOrg.getNav_EVDCSelectordropdown());
				List<WebElement> webListItems = UPMultiOrg.getNav_EVDCSelectordropdown().findElements(By.tagName("li"));
				for (WebElement wb: webListItems){
					sItem =wb.getText() ;
					if (sItem.contains(sExpEVDCHostedsolItem)){
						//WebObjectUtil.MouseHover(webElement);
						WebObjectUtil.explicitWait(2);
						bFndflag=true;
						break;
					}
					
				}
				if(bFndflag)
					FrameworkUtil.updateCustomResultBasedOnStatus(false, sExpEVDCHostedsolItem+" EVDC found in EVDC Selecter drop down for organization "+sOrgName1 );
				else
					FrameworkUtil.updateCustomResultBasedOnStatus(true, sExpEVDCHostedsolItem+" EVDC not found in EVDC Selecter drop down for organization "+sOrgName1 );
				List<WebElement> webListItems1 = UPMultiOrg.getNav_EVDCSelectordropdown().findElements(By.tagName("li"));
				for (WebElement wb1: webListItems1){
					sItem =wb1.getText() ;
					if (sItem.contains(sExpEVDC11GirItem)){
						//WebObjectUtil.MouseHover(webElement);
						WebObjectUtil.explicitWait(2);
						wb1.findElement(By.tagName("p")).click();
						WebObjectUtil.clickElement(UserPerm.getNav_FirewallLink());
						WebObjectUtil.explicitWait(5);
						//wb1.click();
						//wb1.click();
						bFndflag=true;
						break;
					}
					
					
			}
			if(bFndflag)
				FrameworkUtil.updateCustomResultBasedOnStatus(true, sExpEVDC11GirItem+" EVDC found in EVDC Selecter drop down for organization "+sOrgName1 );	
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false, sExpEVDC11GirItem+" EVDC not found in EVDC Selecter drop down for organization "+sOrgName1 );
			}
			
			
			WebObjectUtil.ClickAndMouseHover(UPMultiOrg.getNav_OrganizationnameLink());
			
			wOrgItem=WebObjectUtil.GetWebElement("xpath", "//li[@id='organization']/ul/li/a[text()='"+sOrgName2+"']", sOrgName2);
			if(wOrgItem!=null)
			{
				wOrgItem.click();
				WebObjectUtil.explicitWait(5);
				WebObjectUtil.clickElement(UPMultiOrg.getNav_SelectEVDCText());
				sOrgText=UPMultiOrg.getNav_OrganizationnameLink().getText();
				if(sOrgText.equalsIgnoreCase(sOrgName2))
					FrameworkUtil.updateCustomResultBasedOnStatus(true, sOrgName2 + " organization displayed after selction" );
				else
					FrameworkUtil.updateCustomResultBasedOnStatus(false, sOrgName2 + " organization not displayed after selction" );
				WebObjectUtil.ClickAndMouseHover(UPMultiOrg.getNav_EVDCSelectordropdown());
				List<WebElement> webListItems = UPMultiOrg.getNav_EVDCSelectordropdown().findElements(By.tagName("li"));
				for (WebElement wb: webListItems){
					sItem =wb.getText() ;
					if (sItem.contains(sExpEVDC11GirItem)){
						//WebObjectUtil.MouseHover(webElement);
						WebObjectUtil.explicitWait(2);
						bFndflag1=true;
						break;
					}
					if(bFndflag1)
						FrameworkUtil.updateCustomResultBasedOnStatus(false, sExpEVDC11GirItem+" EVDC found in EVDC Selecter drop down for organization "+sOrgName2 );
					else
						FrameworkUtil.updateCustomResultBasedOnStatus(true, sExpEVDC11GirItem+" EVDC not found in EVDC Selecter drop down for organization "+sOrgName2 );
				}
					List<WebElement> webListItems1 = UPMultiOrg.getNav_EVDCSelectordropdown().findElements(By.tagName("li"));
					for (WebElement wb1: webListItems1){
						sItem =wb1.getText() ;
						if (sItem.contains(sExpEVDCTstDevcoItem)){
							//WebObjectUtil.MouseHover(webElement);
							WebObjectUtil.explicitWait(2);
							wb1.findElement(By.tagName("p")).click();
							WebObjectUtil.clickElement(UserPerm.getNav_FirewallLink());
							WebObjectUtil.explicitWait(5);
							bFndflag2=true;
							break;
						}
						if(bFndflag2)
							FrameworkUtil.updateCustomResultBasedOnStatus(true, sExpEVDCTstDevcoItem+" EVDC found in EVDC Selecter drop down for organization "+sOrgName2 );
						else
							FrameworkUtil.updateCustomResultBasedOnStatus(false, sExpEVDCTstDevcoItem+" EVDC not found in EVDC Selecter drop down for organization "+sOrgName2 );
						
				}
			}
			}
			
		
				catch(Exception e){
					
				}
	}
	
	/*==============================================================
	Method Name 	: changeOrgandVerifyEVDCOrgListItem
	Description		: Selects the organization and verifies whether EVDC org data is changing accrodingly 
	Author 			: Sukur Babu. B
	Creation Date 	: 13/07/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void changeOrgandVerifyEVDCOrgListItem()
	{
		PageFactory.initElements(WebDriverUtil.getDriver(), UPMultiOrg);
		try{
			String sOrgName1,sOrgName2,sOrgText,sExpEVDCHostedsolItem,sActEVDCHostedsolItem,sItem,sExpEVDC11GirItem,sExpEVDCTstDevcoItem;
			boolean bFndflag=false,bFndflag1=false,bFndflag2=false;
			sOrgName1=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
			sOrgName2=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME3");
			sExpEVDCHostedsolItem=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.EVDC.HOSTEDSOL.ORG.NAME");
			sExpEVDC11GirItem=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.EVDC.11GIRAFFE.ORG.NAME");
			sExpEVDCTstDevcoItem=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.EVDC.TSTDEVCO.ORG.NAME");
			sActEVDCHostedsolItem=UPMultiOrg.getNav_EVDCSelectorList().getText();
			if(sActEVDCHostedsolItem.equalsIgnoreCase(sExpEVDCHostedsolItem))
				FrameworkUtil.updateCustomResultBasedOnStatus(true, sExpEVDCHostedsolItem + " is matching with actual value of organization" );
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false, sExpEVDCHostedsolItem + " is not matching with actual value of organization" );
			WebObjectUtil.ClickAndMouseHover(UPMultiOrg.getNav_OrganizationnameLink());
			WebElement wOrgItem=WebObjectUtil.GetWebElement("xpath", "//li[@id='organization']/ul/li/a[text()='"+sOrgName1+"']", sOrgName1);
			if(wOrgItem!=null)
			{
				wOrgItem.click();
				WebObjectUtil.explicitWait(5);
				sOrgText=UPMultiOrg.getNav_OrganizationnameLink().getText();
				if(sOrgText.equalsIgnoreCase(sOrgName1))
					FrameworkUtil.updateCustomResultBasedOnStatus(true, sOrgName1 + " organization displayed after selction" );
				else
					FrameworkUtil.updateCustomResultBasedOnStatus(true, sOrgName1 + " organization not displayed after selction" );
				WebObjectUtil.ClickAndMouseHover(UPMultiOrg.getNav_EVDCSelectordropdown());
				List<WebElement> webListItems = UPMultiOrg.getNav_EVDCSelectordropdown().findElements(By.tagName("li"));
				for (WebElement wb: webListItems){
					sItem =wb.getText() ;
					if (sItem.contains(sExpEVDCHostedsolItem)){
						//WebObjectUtil.MouseHover(webElement);
						WebObjectUtil.explicitWait(2);
						bFndflag=true;
						break;
					}
					
				}
				if(bFndflag)
					FrameworkUtil.updateCustomResultBasedOnStatus(false, sExpEVDCHostedsolItem+" EVDC found in EVDC Selecter drop down for organization "+sOrgName1 );
				else
					FrameworkUtil.updateCustomResultBasedOnStatus(true, sExpEVDCHostedsolItem+" EVDC not found in EVDC Selecter drop down for organization "+sOrgName1 );
				List<WebElement> webListItems1 = UPMultiOrg.getNav_EVDCSelectordropdown().findElements(By.tagName("li"));
				for (WebElement wb1: webListItems1){
					sItem =wb1.getText() ;
					if (sItem.contains(sExpEVDC11GirItem)){
						//WebObjectUtil.MouseHover(webElement);
						WebObjectUtil.explicitWait(2);
						wb1.findElement(By.tagName("p")).click();
						//WebObjectUtil.clickElement(UserPerm.getNav_FirewallLink());
						WebObjectUtil.explicitWait(5);
						//wb1.click();
						//wb1.click();
						bFndflag=true;
						break;
					}
					
					
			}
			if(bFndflag)
				FrameworkUtil.updateCustomResultBasedOnStatus(true, sExpEVDC11GirItem+" EVDC found in EVDC Selecter drop down for organization "+sOrgName1 );	
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false, sExpEVDC11GirItem+" EVDC not found in EVDC Selecter drop down for organization "+sOrgName1 );
			}
			
			
			WebObjectUtil.ClickAndMouseHover(UPMultiOrg.getNav_OrganizationnameLink());
			
			wOrgItem=WebObjectUtil.GetWebElement("xpath", "//li[@id='organization']/ul/li/a[text()='"+sOrgName2+"']", sOrgName2);
			if(wOrgItem!=null)
			{
				wOrgItem.click();
				WebObjectUtil.explicitWait(5);
				WebObjectUtil.clickElement(UPMultiOrg.getNav_SelectEVDCText());
				sOrgText=UPMultiOrg.getNav_OrganizationnameLink().getText();
				if(sOrgText.equalsIgnoreCase(sOrgName2))
					FrameworkUtil.updateCustomResultBasedOnStatus(true, sOrgName2 + " organization displayed after selction" );
				else
					FrameworkUtil.updateCustomResultBasedOnStatus(false, sOrgName2 + " organization not displayed after selction" );
				WebObjectUtil.ClickAndMouseHover(UPMultiOrg.getNav_EVDCSelectordropdown());
				List<WebElement> webListItems = UPMultiOrg.getNav_EVDCSelectordropdown().findElements(By.tagName("li"));
				for (WebElement wb: webListItems){
					sItem =wb.getText() ;
					if (sItem.contains(sExpEVDC11GirItem)){
						//WebObjectUtil.MouseHover(webElement);
						WebObjectUtil.explicitWait(2);
						bFndflag1=true;
						break;
					}
					if(bFndflag1)
						FrameworkUtil.updateCustomResultBasedOnStatus(false, sExpEVDC11GirItem+" EVDC found in EVDC Selecter drop down for organization "+sOrgName2 );
					else
						FrameworkUtil.updateCustomResultBasedOnStatus(true, sExpEVDC11GirItem+" EVDC not found in EVDC Selecter drop down for organization "+sOrgName2 );
				}
					List<WebElement> webListItems1 = UPMultiOrg.getNav_EVDCSelectordropdown().findElements(By.tagName("li"));
					for (WebElement wb1: webListItems1){
						sItem =wb1.getText() ;
						if (sItem.contains(sExpEVDCTstDevcoItem)){
							//WebObjectUtil.MouseHover(webElement);
							WebObjectUtil.explicitWait(2);
							wb1.findElement(By.tagName("p")).click();
							//WebObjectUtil.clickElement(UserPerm.getNav_FirewallLink());
							WebObjectUtil.explicitWait(5);
							bFndflag2=true;
							break;
						}
						if(bFndflag2)
							FrameworkUtil.updateCustomResultBasedOnStatus(true, sExpEVDCTstDevcoItem+" EVDC found in EVDC Selecter drop down for organization "+sOrgName2 );
						else
							FrameworkUtil.updateCustomResultBasedOnStatus(false, sExpEVDCTstDevcoItem+" EVDC not found in EVDC Selecter drop down for organization "+sOrgName2 );
						
				}
			}
			}
			
		
				catch(Exception e){
					
				}
	}


public static void elementHighlight(WebElement element) {
	WebDriver driver = WebDriverUtil.getDriver();
		for (int i = 0; i < 2; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);",element, "color: red; border: 3px solid red;");
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);",element, "");
			
			if (driver instanceof JavascriptExecutor) {
		        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", element);
		    }
		}
		if (driver instanceof JavascriptExecutor) {
	        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", element);}
	}
	/*==============================================================
	Method Name 	: NavigateToCriticalEscalationListPage
	Description		: Navigates critical escalation list page
	Author 			: Sukur Babu. B
	Creation Date 	: 09/07/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void NavigateToCriticalEscalationListPage()
	{
		
		PageFactory.initElements(WebDriverUtil.getDriver(), UserPerm);
		//LoginTestCase.nav_Login(sUserName, sPassword);
		WebObjectUtil.ClickAndMouseHover(UserPerm.getNav_AccountTab());
		WebObjectUtil.clickElement(UserPerm.getNav_EscalationListLink());
		WebObjectUtil.verifyElementPresent(UserPerm.getNav_CriticalEscalationListTab());
		WebObjectUtil.explicitWait(5);
		
	}
	/*==============================================================
	Method Name 	: NavigateToEVDCOverviewPage
	Description		: Navigates EVDC Overview page
	Author 			: Sukur Babu. B
	Creation Date 	: 13/07/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void NavigateToEVDCOverviewPage()
	{
		PageFactory.initElements(WebDriverUtil.getDriver(), UserPerm);
		WebObjectUtil.clickElement(UserPerm.getNav_EVDCPortalLink());
		WebObjectUtil.waitForElementPresent(UserPerm.getNav_FirewallLink());
		
	}
	/*==============================================================
	Method Name 	: NavigateToDNSPage
	Description		: Navigates DNS page
	Author 			: Sukur Babu. B
	Creation Date 	: 13/07/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void NavigateToDNSPage()
	{
		PageFactory.initElements(WebDriverUtil.getDriver(), UPMultiOrg);
		WebObjectUtil.ClickAndMouseHover(UPMultiOrg.getNav_ServicesLink());
		WebObjectUtil.clickElement(UPMultiOrg.getNav_DNSLink());
		WebObjectUtil.waitForElementPresent(UPMultiOrg.getNav_ZonesTable());
		
	}
	/*==============================================================
	Method Name 	: NavigateToVMPage
	Description		: Navigates EVDC VM page
	Author 			: Sukur Babu. B
	Creation Date 	: 13/07/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void NavigateToVMPage()
	{
		PageFactory.initElements(WebDriverUtil.getDriver(), UPMultiOrg);
		PageFactory.initElements(WebDriverUtil.getDriver(), UserPerm);
		PageFactory.initElements(WebDriverUtil.getDriver(), EVDC_OverviewPF);
		
		//WebObjectUtil.clickElement(UserPerm.getNav_EVDCPortalLink());
		WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
		WebObjectUtil.waitForElementPresent(UserPerm.getNav_FirewallLink());
		WebObjectUtil.clickElement(UPMultiOrg.getNav_VMLink());
		WebObjectUtil.waitForElementPresent(UserPerm.getNav_VMWebTable());
	}
	/*==============================================================
	Method Name 	: NavigateToCatalogPage
	Description		: Navigates EVDC Catalog page
	Author 			: Sukur Babu. B
	Creation Date 	: 13/07/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void NavigateToCatalogPage()
	{
		PageFactory.initElements(WebDriverUtil.getDriver(), UPMultiOrg);
		PageFactory.initElements(WebDriverUtil.getDriver(), UserPerm);
		PageFactory.initElements(WebDriverUtil.getDriver(), EVDC_OverviewPF);
		//WebObjectUtil.clickElement(UserPerm.getNav_EVDCPortalLink());
		// this objects added by NMR -- 12/04/2015
		WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
		WebObjectUtil.waitForElementPresent(UserPerm.getNav_FirewallLink());
		WebObjectUtil.clickElement(UPMultiOrg.getNav_CatalogPortletLink());
		WebObjectUtil.waitForElementPresent(UPMultiOrg.getNav_CatalogWindStreamLink());
	}
	/*==============================================================
	Method Name 	: NavigateToFirewallPage
	Description		: Navigates EVDC Firewall page
	Author 			: Sukur Babu. B
	Creation Date 	: 13/07/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void NavigateToFirewallPage()
	{
		PageFactory.initElements(WebDriverUtil.getDriver(), UPMultiOrg);
		PageFactory.initElements(WebDriverUtil.getDriver(), UserPerm);
		PageFactory.initElements(WebDriverUtil.getDriver(), EVDC_OverviewPF);
		int iRulesCount=0;
		//WebObjectUtil.clickElement(UserPerm.getNav_EVDCPortalLink());
		// This object is added by NMR  -- 12/04/15
		WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
		WebObjectUtil.waitForElementPresent(UserPerm.getNav_FirewallLink());
		WebObjectUtil.clickElement(UserPerm.getNav_FirewallLink());
		if(WebObjectUtil.isElementPresent(UPMultiOrg.getNav_InfoUnavailableText()))
		{
			iRulesCount=Integer.parseInt(UPMultiOrg.getNav_RulesCountText().getText());
			if(iRulesCount==0)
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Pop up displayed because rules count is Zero", "pass", "");
			else
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Pop up displayed even rules count is more than Zero", "fail", "");
			WebObjectUtil.clickElement(UPMultiOrg.getNav_InfoUnavailableOKButton());
		}
		else
			WebObjectUtil.waitForElementPresent(UserPerm.getNav_FirewallTable());
	}


////?????????????????????????????????????????Sukur end????????????????????????????????????????????????????????????????
	 static String giraffe11CA,giraffe11DA,giraffe11MjrA,giraffe11MnrA,giraffe11NA,giraffe11RT,giraffe11OT,giraffe11DN,giraffe11DD,giraffe11BW,giraffe11AO;
	 static String tstMultiorgCA,tstMultiorgDA,tstMultiorgMjrA,tstMultiorgMnrA,tstMultiorgNA,tstMultiorgRT,tstMultiorgOT,tstMultiorgDN,tstMultiorgDD,tstMultiorgBW,tstMultiorgAO;
	 static String tstMultiorg1CA,tstMultiorg1DA,tstMultiorg1MjrA,tstMultiorg1MnrA,tstMultiorg1NA,tstMultiorg1RT,tstMultiorg1OT,tstMultiorg1DN,tstMultiorg1DD,tstMultiorg1BW,tstMultiorg1AO;
	 static String sgirTkt1,sgirTkt2,sgirTkt3,ststDevTkt1,ststDevTkt2,ststDevTkt3,sMorgUsrTkt1,sMorgUsrTkt2,sMorgUsrTkt3;
	 static String tstDevcoCA,tstDevcoDA,tstDevcoMjrA,tstDevcoMnrA,tstDevcoNA,tstDevcoRT,tstDevcoOT,tstDevcoDN,tstDevcoDD,tstDevcoBW,tstDevcoAO;
		
	/*==============================================================
	TestScript  	: verifyHomePage()
	Manual TestCase	: Check Home page with Multiorguser
	Description		: Verify that page changes according to organization
	Author 			: Priyanka Rachupalli
	Creation Date 	: 07/10/2015
	Pre-Requisites	:
	Revision History:
	================================================================*/
	@Test(priority=31)
	public void verifyHomePage()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, UPMultiOrg); 
	try{
	FrameworkUtil.sTestCaseName = "MultiOrg-verifyHomePage";
	FrameworkUtil.sManualTestCaseName="1. Check Home page with Multiorguser";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	String sUserName1,sPassword1;
 	sUserName1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.AROLE");
 	sPassword1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.AROLE");
 	LoginTestCase.nav_Login(sUserName1, sPassword1);
 	navigateHomePage();
    VerifyMultiOrgsHomePage();
 	LoginTestCase.nav_Logout();
 	sUserName1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.CROLE");
 	sPassword1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.CROLE");
 	LoginTestCase.nav_Login(sUserName1, sPassword1);
 	navigateHomePage();
 	VerifyMultiOrgsHomePage();
 	LoginTestCase.nav_Logout();
 	sUserName1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.EROLE");
 	sPassword1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.EROLE");
 	LoginTestCase.nav_Login(sUserName1, sPassword1);
 	navigateHomePage();
 	VerifyMultiOrgsHomePage();
 	LoginTestCase.nav_Logout();
	}
	catch (Exception e) {
		LoggerUtil.log_type_error("issue with-MultiOrg- navHomePageLogin" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	/*==============================================================
	TestScript  	: verifyTicketsPage
	Manual TestCase	: Check Tickets page with multiorguser
	Description		: Verify that page changes according to organization
	Author 			: Priyanka Rachupalli
	Creation Date 	: 07/14/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=32)
	public void verifyTicketsPage()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, UPMultiOrg); 
	try{
	FrameworkUtil.sTestCaseName = "MultiOrg-verifyTicketsPage";
	FrameworkUtil.sManualTestCaseName="1. Verify that page changes according to organization";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	String sUserName1,sPassword1;
	sUserName1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.AROLE");
 	sPassword1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.AROLE");
 	LoginTestCase.nav_Login(sUserName1, sPassword1);
 	navigateHomePage();
 	WebObjectUtil.clickElement(UPMultiOrg.getNav_MultiOrgTicketslinkHome());
 	VerifyMultiOrgsTicketsPage();
 	LoginTestCase.nav_Logout();
 	sUserName1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.CROLE");
 	sPassword1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.CROLE");
 	LoginTestCase.nav_Login(sUserName1, sPassword1);
 	navigateHomePage();
 	WebObjectUtil.clickElement(UPMultiOrg.getNav_MultiOrgTicketslinkHome());
 	VerifyMultiOrgsTicketsPage();
 	LoginTestCase.nav_Logout();
 	sUserName1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.EROLE");
 	sPassword1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.EROLE");
 	LoginTestCase.nav_Login(sUserName1, sPassword1);
 	navigateHomePage();
 	WebObjectUtil.clickElement(UPMultiOrg.getNav_MultiOrgTicketslinkHome());
 	VerifyMultiOrgsTicketsPage();
 	LoginTestCase.nav_Logout();
 	
	}
	catch (Exception e) {
		LoggerUtil.log_type_error("issue with- navHomePageLogin" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	/*==============================================================
	TestScript  	: verifyDRAASPage
	Manual TestCase	: Check DRaaS page with multiorguser
	Description		: Verify that page changes according to organization
	Author 			: Priyanka Rachupalli
	Creation Date 	: 07/15/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=33)
	public void verifyDRAASPage()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Draas);
		PageFactory.initElements(driver,UPMultiOrg);
	try{
	FrameworkUtil.sTestCaseName = "MultiOrg-verifyDRAASPage";
	FrameworkUtil.sManualTestCaseName="1. Verify that page changes according to organization";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	String sUserName1,sPassword1;
	sUserName1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.AROLE");
 	sPassword1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.AROLE");
 	LoginTestCase.nav_Login(sUserName1, sPassword1);
 	navigateHomePage();
 	WebObjectUtil.clickElement(Draas.getNav_MultiOrgDraasLinkHome());
 	VerifyMultiOrgs();
 	LoginTestCase.nav_Logout();
	sUserName1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.CROLE");
 	sPassword1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.CROLE");
 	LoginTestCase.nav_Login(sUserName1, sPassword1);
 	navigateHomePage();
 	WebObjectUtil.clickElement(Draas.getNav_MultiOrgDraasLinkHome());
 	VerifyMultiOrgs();
 	LoginTestCase.nav_Logout();
	sUserName1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.EROLE");
 	sPassword1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.EROLE");
 	LoginTestCase.nav_Login(sUserName1, sPassword1);
 	navigateHomePage();
 	WebObjectUtil.clickElement(Draas.getNav_MultiOrgDraasLinkHome());
 	VerifyMultiOrgs();
 	LoginTestCase.nav_Logout();
	}
	catch (Exception e) {
		LoggerUtil.log_type_error("issue with- verifyDRAASPage" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	/*==============================================================
	TestScript  	: verifyBandwidthPage
	Manual TestCase	: Check Bandwidth page with multiorguser
	Description		: Verify that page changes according to organization
	Author 			: Priyanka Rachupalli
	Creation Date 	: 07/15/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=34)
	public void verifyBandwidthPage()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,UPMultiOrg);
	try{
	FrameworkUtil.sTestCaseName = "MultiOrg-verifyBandwidthPage()";
	FrameworkUtil.sManualTestCaseName="1.Verify that page changes according to organization";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	String sUserName1,sPassword1;
	sUserName1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.AROLE");
 	sPassword1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.AROLE");
 	LoginTestCase.nav_Login(sUserName1, sPassword1);
 	navigateHomePage();
    WebObjectUtil.clickElement(UPMultiOrg.getNav_Bandwidthlink());
    VerifyMultiOrgs();
 	LoginTestCase.nav_Logout();
 	sUserName1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.CROLE");
 	sPassword1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.CROLE");
 	LoginTestCase.nav_Login(sUserName1, sPassword1);
 	navigateHomePage();
    WebObjectUtil.clickElement(UPMultiOrg.getNav_Bandwidthlink());
    VerifyMultiOrgs();
 	LoginTestCase.nav_Logout();
 	sUserName1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.EROLE");
 	sPassword1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.EROLE");
 	LoginTestCase.nav_Login(sUserName1, sPassword1);
 	navigateHomePage();
    WebObjectUtil.clickElement(UPMultiOrg.getNav_Bandwidthlink());
    VerifyMultiOrgs();
 	LoginTestCase.nav_Logout();
	}
	catch (Exception e) {
		LoggerUtil.log_type_error("issue with- verifyBandwidthPage()" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	/*======================================================================
	Method Name 	: navigate to HomePage
	Description		: Make sure that page changes according to organization
	Author 			: Priyanka Rachupalli
	Creation Date 	: 07/13/2015
	Pre-Requisites	:
	Revision History:
	=========================================================================*/
	public static void navigateHomePage()
	{

        try{
           
      WebObjectUtil.ClickAndMouseHover(UPMultiOrg.getNav_MultiOrgIdDropdown());
      WebObjectUtil.clickElement(UPMultiOrg.getNav_UseThisOrgButton());
       }
	catch (Exception e) {
		LoggerUtil.log_type_error("issue with-MultiOrg- navigateHomePage" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
        
        }
	/*==============================================================
	Method Name 	: VerifyMultiOrgsHomePage
	Description		: Make sure that page changes according to organization
	Author 			: Priyanka Rachupalli
	Creation Date 	: 07/15/2015
	Pre-Requisites	:
	Revision History:
	=================================================================*/
	public static void VerifyMultiOrgsHomePage()
	{
		PageFactory.initElements(WebDriverUtil.getDriver(),UPMultiOrg);
		//PageFactory.initElements(WebDriverUtil.getDriver(),Ticket);
        try{
            String sOrg,x,sTNum1,sTNum2,sTNum3;
            
        	WebObjectUtil.explicitWait(15);
        	//WebObjectUtil.ClickAndMouseHover(UPMultiOrg.getNav_OrganizationnameLink());
            x=UPMultiOrg.getNav_OrganizationnameLink().getText();
            sOrg=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME1");
            if(sOrg.equalsIgnoreCase(x))
            FrameworkUtil.updateCustomResultBasedOnStatus(true, sOrg + " organization displayed after selction" );
            else
            FrameworkUtil.updateCustomResultBasedOnStatus(false, sOrg + " organization not displayed after selction" );
        	WebObjectUtil.VerifyTextOnPage(UPMultiOrg.getNav_MultiOrgHomeTicketNum().getText());
            sTNum1=UPMultiOrg.getNav_MultiOrgHomeTicketNum().getText();
            sOrg=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
            selectOrgs(sOrg);
            WebObjectUtil.VerifyTextOnPage(UPMultiOrg.getNav_MultiOrgHomeTicketNum().getText());
            sTNum2=UPMultiOrg.getNav_MultiOrgHomeTicketNum().getText();
            sOrg=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME3");
            selectOrgs(sOrg);
            WebObjectUtil.VerifyTextOnPage(UPMultiOrg.getNav_MultiOrgHomeTicketNum().getText());
            sTNum3=UPMultiOrg.getNav_MultiOrgHomeTicketNum().getText();
            if(sTNum1.equalsIgnoreCase(sTNum2))
        		FrameworkUtil.updateCustomResultBasedOnStatus(false, sTNum1 + " Warning: Ticket Numbers are same for both organizations, please check manually" );
                else
                FrameworkUtil.updateCustomResultBasedOnStatus(true,sTNum2 + "PASS" );
            if(sTNum2.equalsIgnoreCase(sTNum3))
        		FrameworkUtil.updateCustomResultBasedOnStatus(false, sTNum2 + "Warning: Ticket Numbers are same for both organizations, please check manually" );
                else
                FrameworkUtil.updateCustomResultBasedOnStatus(true,sTNum1 + "PASS" );
            if(sTNum1.equalsIgnoreCase(sTNum3))
        		FrameworkUtil.updateCustomResultBasedOnStatus(false, sTNum3 + "Warning: Ticket Numbers are same for both organizations, please check manually" );
                else
                FrameworkUtil.updateCustomResultBasedOnStatus(true,sTNum3 + "PASS" );
            
            }
      	catch (Exception e) {
      		LoggerUtil.log_type_error("issue with-MultiOrg- VerifyMultiOrgsHomePage" );
      		LoggerUtil.log_type_error(e.getMessage());
      		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
      		}
            }
	/*===============================================================
	Method Name 	: VerifyMultiOrgsTicketsPage
	Description		: Make sure that page changes according to organization
	Author 			: Priyanka Rachupalli
	Creation Date 	: 07/15/2015
	Pre-Requisites	:
	Revision History:
	=================================================================*/
	public static void VerifyMultiOrgsTicketsPage()
	{
		PageFactory.initElements(WebDriverUtil.getDriver(),UPMultiOrg);
		//PageFactory.initElements(WebDriverUtil.getDriver(),Ticket);
        try{
        	String sOrg,i,j;
            WebElement wExpander;
        	WebObjectUtil.ClickAndMouseHover(UPMultiOrg.getNav_OrganizationnameLink());
            i=UPMultiOrg.getNav_OrganizationnameLink().getText();
            sOrg=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME1");
           //WebObjectUtil.verifyElementPresent(UPMultiOrg.getNav_MultiOrgHostedSolTitle());
            //dynamic XPATH of Expand icon
          //This below line updated on 10/07/2015 for EXTJS5 by QAA03
    		//wExpander=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+1+"]//tr[1]/td[1]//div[@class='x-grid-row-expander']", "Arrow Expander");
            wExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTicketsGridPanel-body']/div/div/table[1]/tbody/tr/td/div/div[@class='x-grid-row-expander']", "Ticket Arrow Expander"); 
    		WebObjectUtil.clickElement(wExpander);
    		WebObjectUtil.explicitWait(5);
    		//WebObjectUtil.VerifyTextOnPage(UPMultiOrg.getNav_MultiOrgnameWebTable().getText());
    		
    		//This below line updated on 10/07/2015 for EXTJS5 by QAA03
    		// j=WebObjectUtil.GetWebElement("xpath", "//tr["+1+"]/td/table/tbody/tr[2]/td/div/div/section/table/tbody/tr[5]/td/div[2]/dl/dd", "Org Name").getText();
    		j=WebObjectUtil.GetWebElement("xpath", "//table[1]//table/tbody/tr[5]/td/div[@id='ticket_content']/dl/dt[text()='Organization']/../dd", "Organization name").getText();
             if(j.equalsIgnoreCase(sOrg))
                 FrameworkUtil.updateCustomResultBasedOnStatus(true, sOrg + " organization displayed after selction" );
              else
                 FrameworkUtil.updateCustomResultBasedOnStatus(false, sOrg + " organization not displayed after selction" );
    		sOrg =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
        	selectOrgs(sOrg);
        	//This below line updated on 10/07/2015 for EXTJS5 by QAA03
    		//wExpander=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+1+"]//tr[1]/td[1]//div[@class='x-grid-row-expander']", "Arrow Expander");
        	wExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTicketsGridPanel-body']/div/div/table[1]/tbody/tr/td/div/div[@class='x-grid-row-expander']", "Ticket Arrow Expander"); 
        	WebObjectUtil.clickElement(wExpander);
    		WebObjectUtil.explicitWait(5);
    		//WebObjectUtil.VerifyTextOnPage(UPMultiOrg.getNav_MultiOrgnameWebTable().getText());
    		//This below line updated on 10/07/2015 for EXTJS5 by QAA03
 	        //j=WebObjectUtil.GetWebElement("xpath", "//tr["+1+"]/td/table/tbody/tr[2]/td/div/div/section/table/tbody/tr[5]/td/div[2]/dl/dd", "Org Name").getText();
    		j=WebObjectUtil.GetWebElement("xpath", "//table[1]//table/tbody/tr[5]/td/div[@id='ticket_content']/dl/dt[text()='Organization']/../dd", "Organization name").getText();
        	if(j.equalsIgnoreCase(sOrg))
                FrameworkUtil.updateCustomResultBasedOnStatus(true, sOrg + " organization displayed after selction" );
            else
                FrameworkUtil.updateCustomResultBasedOnStatus(false, sOrg + " organization not displayed after selction" );
        	sOrg =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME3");
        	selectOrgs(sOrg);
        	//This below line updated on 10/07/2015 for EXTJS5 by QAA03
            //wExpander=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+1+"]//tr[1]/td[1]//div[@class='x-grid-row-expander']", "Arrow Expander");
        	wExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTicketsGridPanel-body']/div/div/table[1]/tbody/tr/td/div/div[@class='x-grid-row-expander']", "Ticket Arrow Expander"); 
        	WebObjectUtil.clickElement(wExpander);
    		WebObjectUtil.explicitWait(5);
    		//WebObjectUtil.VerifyTextOnPage(UPMultiOrg.getNav_MultiOrgnameWebTable().getText());
    		//This below line updated on 10/07/2015 for EXTJS5 by QAA03
    		//j=WebObjectUtil.GetWebElement("xpath", "//tr["+1+"]/td/table/tbody/tr[2]/td/div/div/section/table/tbody/tr[5]/td/div[2]/dl/dd", "Org Name").getText();
    		j=WebObjectUtil.GetWebElement("xpath", "//table[1]//table/tbody/tr[5]/td/div[@id='ticket_content']/dl/dt[text()='Organization']/../dd", "Organization name").getText();
        	if(j.equalsIgnoreCase(sOrg))
                FrameworkUtil.updateCustomResultBasedOnStatus(true, sOrg + " organization displayed after selction" );
            else
                FrameworkUtil.updateCustomResultBasedOnStatus(false, sOrg + " organization not displayed after selction" );

        }
      	catch (Exception e) {
      		LoggerUtil.log_type_error("issue with-MultiOrg- VerifyMultiOrgTicketsPage" );
      		LoggerUtil.log_type_error(e.getMessage());
      		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
      	    }
            }
	/*=======================================================================
	Method Name 	: VerifyMultiOrgs
	Description		: Make sure that page changes according to organization
	Author 			: Priyanka Rachupalli
	Creation Date 	: 07/15/2015
	Pre-Requisites	:
	Revision History:
	========================================================================*/
	public static void VerifyMultiOrgs()
	{

        try{
        	String sOrg,i;
        	WebObjectUtil.explicitWait(15);
        	WebObjectUtil.ClickAndMouseHover(UPMultiOrg.getNav_OrganizationnameLink());
            i=UPMultiOrg.getNav_OrganizationnameLink().getText();
            sOrg=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME1");
            boolean bOrgname=sOrg.equalsIgnoreCase(i);
            FrameworkUtil.updateCustomResultBasedOnStatus(bOrgname, sOrg + " organization displayed after selction" );
         /* if(sOrg.equalsIgnoreCase(i))
            {
            //FrameworkUtil.updateCustomResultBasedOnStatus(true, sOrg + " organization displayed after selction" );
            FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Org name is displayed according to selection", "pass", "");
            }
            else
            {
            //FrameworkUtil.updateCustomResultBasedOnStatus(false, sOrg + " organization not displayed after selction" );
            FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Org name is not displayed according to selection", "fail", "");
            }*/
            sOrg =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
        	selectOrgs(sOrg);
        	sOrg =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME3");
        	selectOrgs(sOrg);
           
            }
      	catch (Exception e) {
      		LoggerUtil.log_type_error("issue with-MultiOrg- VerifyMultiOrgs" );
      		LoggerUtil.log_type_error(e.getMessage());
      		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
      		}
            }
	/*==============================================================
	TestScript  	: verifyMultiOrgHomeDetails()
	Manual TestCase	: Check Home page with Multiorguser
	Description		: Verify values with GirUser and TestDevco user and
	                  Compare values for Testmultiorg user.
	Author 			: Priyanka Rachupalli
	Creation Date 	: 07/10/2015
	Pre-Requisites	:
	Revision History:
	================================================================*/
	@Test(priority=35)
	public void verifyMultiOrgHomeDetails()
	{
		PageFactory.initElements(WebDriverUtil.getDriver(),UPMultiOrg);
		PageFactory.initElements(WebDriverUtil.getDriver(),Ticket);
	try{
	String sOrg;
	FrameworkUtil.sTestCaseName = "MultiOrg-verifyMultiOrgHomeDetails";
	FrameworkUtil.sManualTestCaseName="1. Check Home page with Multiorguser";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	String sUserName1,sPassword1;
	sUserName1 = (String)FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
 	sPassword1 = (String)FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
 	LoginTestCase.nav_Login(sUserName1, sPassword1);
 	VerifyGirDetails();
 	LoginTestCase.nav_Logout();
 	sUserName1 = (String)FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLE.USERID");
 	sPassword1 = (String)FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLE.PWD");
 	LoginTestCase.nav_Login(sUserName1, sPassword1);
 	VerifyTstDevcodetails();
	LoginTestCase.nav_Logout();
 	sUserName1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.AROLE");
 	sPassword1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.AROLE");
 	LoginTestCase.nav_Login(sUserName1, sPassword1);
	navigateHomePage();
	VerifyMultiUsrHomeval();
 	VerifyCompareGir();
 	sOrg =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
	selectOrgs(sOrg);
	VerifyMultiUsrTstdevco();
	VerifyCompareTstDevco();
 	LoginTestCase.nav_Logout();
 	//LoginTestCase.nav_Login(sUserName1, sPassword1);
 	//VerifyGirDetails();
 	//LoginTestCase.nav_Logout();
 	sUserName1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.CROLE");
 	sPassword1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.CROLE");
 	LoginTestCase.nav_Login(sUserName1, sPassword1);
	navigateHomePage();
	VerifyMultiUsrHomeval();
 	VerifyCompareGir();
 	sOrg =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
	selectOrgs(sOrg);
	VerifyMultiUsrTstdevco();
	VerifyCompareTstDevco();
 	LoginTestCase.nav_Logout();
 	//LoginTestCase.nav_Login(sUserName1, sPassword1);
 	//VerifyGirDetails();
 	//LoginTestCase.nav_Logout();
 	sUserName1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.EROLE");
 	sPassword1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.EROLE");
 	LoginTestCase.nav_Login(sUserName1, sPassword1);
	navigateHomePage();
	VerifyMultiUsrHomeval();
 	VerifyCompareGir();
 	sOrg =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
	selectOrgs(sOrg);
	VerifyMultiUsrTstdevco();
	VerifyCompareTstDevco();
 	LoginTestCase.nav_Logout();
 
	}
	catch (Exception e) {
  		LoggerUtil.log_type_error("issue with-MultiOrg- verifyMultiOrgHomeDetails" );
  		LoggerUtil.log_type_error(e.getMessage());
  		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
  	    }
        }
	/*==============================================================
	TestScript  	: verifyMultiOrgTktDetails()
	Manual TestCase	: Check Ticket page with Multiorguser
	Description		: Verify values with GirUser and TestDevco user and
	                  Compare values for Testmultiorg user.
	Author 			: Priyanka Rachupalli
	Creation Date 	: 07/10/2015
	Pre-Requisites	:
	Revision History:
	================================================================*/
	@Test(priority=36)
	public void verifyMultiOrgTktDetails()
	{
		PageFactory.initElements(WebDriverUtil.getDriver(),UPMultiOrg);
		PageFactory.initElements(WebDriverUtil.getDriver(),Ticket);
		
	try{
	String sOrg;
	FrameworkUtil.sTestCaseName = "MultiOrg-verifyMultiOrgTktDetails";
	FrameworkUtil.sManualTestCaseName="1. Check Home page with Multiorguser";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	String sUserName1,sPassword1;
	sUserName1 = (String)FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
 	sPassword1 = (String)FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
 	LoginTestCase.nav_Login(sUserName1, sPassword1);
 	TicketTestCase.navigateToTicketPage();
 	VerifyGirTktDetails();
 	LoginTestCase.nav_Logout();
 	sUserName1 = (String)FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLE.USERID");
 	sPassword1 = (String)FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLE.PWD");
 	LoginTestCase.nav_Login(sUserName1, sPassword1);
 	TicketTestCase.navigateToTicketPage();
 	VerifyTstDevTktDetails();
 	LoginTestCase.nav_Logout();
 	sUserName1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.AROLE");
 	sPassword1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.AROLE");
 	LoginTestCase.nav_Login(sUserName1, sPassword1);
	navigateHomePage();
	TicketTestCase.navigateToTicketPage();
	VerifyMultiUsrTktDetails();
	VerifygirMorgTckts();
	sOrg =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
	selectOrgs(sOrg);
	VerifyMultiUsrTktDetails();
	VerifyTstDevMorgTckts();
	LoginTestCase.nav_Logout();
	sUserName1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.CROLE");
 	sPassword1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.CROLE");
 	LoginTestCase.nav_Login(sUserName1, sPassword1);
	navigateHomePage();
	TicketTestCase.navigateToTicketPage();
	VerifyMultiUsrTktDetails();
	VerifygirMorgTckts();
	sOrg =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
	selectOrgs(sOrg);
	VerifyMultiUsrTktDetails();
	VerifyTstDevMorgTckts();
	LoginTestCase.nav_Logout();
	sUserName1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.EROLE");
 	sPassword1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.EROLE");
 	LoginTestCase.nav_Login(sUserName1, sPassword1);
	navigateHomePage();
	TicketTestCase.navigateToTicketPage();
	VerifyMultiUsrTktDetails();
	VerifygirMorgTckts();
	sOrg =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
	selectOrgs(sOrg);
	VerifyMultiUsrTktDetails();
	VerifyTstDevMorgTckts();
	LoginTestCase.nav_Logout();
 	}
	catch (Exception e) {
  		LoggerUtil.log_type_error("issue with-MultiOrg- verifyMultiOrgTktDetails" );
  		LoggerUtil.log_type_error(e.getMessage());
  		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
  	    }
        }
	/*=======================================================================
	Method Name 	: VerifyGirTktDetails
	Description		: Make sure that page changes according to organization
	Author 			: Priyanka Rachupalli
	Creation Date 	: 07/15/2015
	Pre-Requisites	:
	Revision History:
	========================================================================*/
	public static void VerifyGirTktDetails()
	{
		PageFactory.initElements(WebDriverUtil.getDriver(),UPMultiOrg);
		PageFactory.initElements(WebDriverUtil.getDriver(),Ticket);
        try{
        	WebObjectUtil.explicitWait(20);
        	WebObjectUtil.VerifyTextOnPage(Ticket.getNav_OpenTicketNumbers().getText());
         	sgirTkt1=Ticket.getNav_OpenTicketNumbers().getText();
         	WebObjectUtil.VerifyTextOnPage(Ticket.getNav_WorkingTicketNumbers().getText());
         	sgirTkt2=Ticket.getNav_WorkingTicketNumbers().getText();
         	WebObjectUtil.VerifyTextOnPage(Ticket.getNav_ResolvedTicketNumbers().getText());
         	sgirTkt3=Ticket.getNav_ResolvedTicketNumbers().getText();
            }
        catch (Exception e) {
      		LoggerUtil.log_type_error("issue with-MultiOrg-VerifyGirTktDetails" );
      		LoggerUtil.log_type_error(e.getMessage());
      		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
      		}
            }
	/*=======================================================================
	Method Name 	: VerifyTstDevTktDetails
	Description		: Make sure that page changes according to organization
	Author 			: Priyanka Rachupalli
	Creation Date 	: 07/15/2015
	Pre-Requisites	:
	Revision History:
	========================================================================*/
	public static void VerifyTstDevTktDetails()
	{
		PageFactory.initElements(WebDriverUtil.getDriver(),UPMultiOrg);
		PageFactory.initElements(WebDriverUtil.getDriver(),Ticket);
        try{
        	WebObjectUtil.explicitWait(20);
        	WebObjectUtil.VerifyTextOnPage(Ticket.getNav_OpenTicketNumbers().getText());
         	ststDevTkt1=Ticket.getNav_OpenTicketNumbers().getText();
         	WebObjectUtil.VerifyTextOnPage(Ticket.getNav_WorkingTicketNumbers().getText());
         	ststDevTkt2=Ticket.getNav_WorkingTicketNumbers().getText();
         	WebObjectUtil.VerifyTextOnPage(Ticket.getNav_ResolvedTicketNumbers().getText());
         	ststDevTkt3=Ticket.getNav_ResolvedTicketNumbers().getText();
            }
        catch (Exception e) {
      		LoggerUtil.log_type_error("issue with-MultiOrg-VerifyTstDevTktDetails" );
      		LoggerUtil.log_type_error(e.getMessage());
      		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
      		}
            }
	/*=======================================================================
	Method Name 	: VerifyMultiUsrTktDetails
	Description		: Make sure that page changes according to organization
	Author 			: Priyanka Rachupalli
	Creation Date 	: 07/15/2015
	Pre-Requisites	:
	Revision History:
	========================================================================*/
	public static void VerifyMultiUsrTktDetails()
	{
		PageFactory.initElements(WebDriverUtil.getDriver(),UPMultiOrg);
		PageFactory.initElements(WebDriverUtil.getDriver(),Ticket);
        try{
        	WebObjectUtil.explicitWait(20);
        	WebObjectUtil.VerifyTextOnPage(Ticket.getNav_OpenTicketNumbers().getText());
         	sMorgUsrTkt1=Ticket.getNav_OpenTicketNumbers().getText();
         	sMorgUsrTkt2=Ticket.getNav_WorkingTicketNumbers().getText();
         	sMorgUsrTkt3=Ticket.getNav_ResolvedTicketNumbers().getText();
            }
        catch (Exception e) {
      		LoggerUtil.log_type_error("issue with-MultiOrg-VerifyMultiUsrTktDetails" );
      		LoggerUtil.log_type_error(e.getMessage());
      		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
      		}
            }
	/*=======================================================================
	Method Name 	: VerifygirMorgTckts
	Description		: Make sure that page changes according to organization
	Author 			: Priyanka Rachupalli
	Creation Date 	: 07/15/2015
	Pre-Requisites	:
	Revision History:
	========================================================================*/
	public static void VerifygirMorgTckts()
	{
		PageFactory.initElements(WebDriverUtil.getDriver(),UPMultiOrg);
		PageFactory.initElements(WebDriverUtil.getDriver(),Ticket);
        try{
        	if(sgirTkt1.equalsIgnoreCase(sMorgUsrTkt1))
     		   FrameworkUtil.updateCustomResultBasedOnStatus(true, sgirTkt1 + "Pass" );
                else
                FrameworkUtil.updateCustomResultBasedOnStatus(false,sgirTkt1 + "failed for Open Tickets" );
        	if(sgirTkt2.equalsIgnoreCase(sMorgUsrTkt2))
      		   FrameworkUtil.updateCustomResultBasedOnStatus(true, sgirTkt2 + "Pass" );
                 else
                 FrameworkUtil.updateCustomResultBasedOnStatus(false,sgirTkt2 + "failed for Working Tickets" );
        	if(sgirTkt3.equalsIgnoreCase(sMorgUsrTkt3))
       		   FrameworkUtil.updateCustomResultBasedOnStatus(true, sgirTkt3 + "Pass" );
                  else
                  FrameworkUtil.updateCustomResultBasedOnStatus(false,sgirTkt3 + "failed for Resolved Tickets" );
        	
            }
        catch (Exception e) {
      		LoggerUtil.log_type_error("issue with-MultiOrg-VerifygirMorgTckts" );
      		LoggerUtil.log_type_error(e.getMessage());
      		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
      		}
            }
	/*=======================================================================
	Method Name 	: VerifyTstDevMorgTckts
	Description		: Make sure that page changes according to organization
	Author 			: Priyanka Rachupalli
	Creation Date 	: 07/15/2015
	Pre-Requisites	:
	Revision History:
	========================================================================*/
	public static void VerifyTstDevMorgTckts()
	{
		PageFactory.initElements(WebDriverUtil.getDriver(),UPMultiOrg);
		PageFactory.initElements(WebDriverUtil.getDriver(),Ticket);
        try{
        	if(ststDevTkt1.equalsIgnoreCase(sMorgUsrTkt1))
     		   FrameworkUtil.updateCustomResultBasedOnStatus(true, ststDevTkt1 + "Pass" );
                else
                FrameworkUtil.updateCustomResultBasedOnStatus(false,ststDevTkt1 + "failed for Open Tickets" );
        	if(ststDevTkt2.equalsIgnoreCase(sMorgUsrTkt2))
      		   FrameworkUtil.updateCustomResultBasedOnStatus(true, ststDevTkt2 + "Pass" );
                 else
                 FrameworkUtil.updateCustomResultBasedOnStatus(false,ststDevTkt2 + "failed for Working Tickets" );
        	if(ststDevTkt3.equalsIgnoreCase(sMorgUsrTkt3))
       		   FrameworkUtil.updateCustomResultBasedOnStatus(true, ststDevTkt3 + "Pass" );
                  else
                  FrameworkUtil.updateCustomResultBasedOnStatus(false,ststDevTkt3 + "failed for Resolved Tickets" );
        	
            }
        catch (Exception e) {
      		LoggerUtil.log_type_error("issue with-MultiOrg-VerifyTstDevTktDetails" );
      		LoggerUtil.log_type_error(e.getMessage());
      		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
      		}
            }
	
	/*=======================================================================
	Method Name 	: VerifyGirDetails
	Description		: Make sure that page changes according to organization
	Author 			: Priyanka Rachupalli
	Creation Date 	: 07/15/2015
	Pre-Requisites	:
	Revision History:
	========================================================================*/
	public static void VerifyGirDetails()
	{
		PageFactory.initElements(WebDriverUtil.getDriver(),UPMultiOrg);
		PageFactory.initElements(WebDriverUtil.getDriver(),Ticket);
        try{
        	//String a[]=null;
        	WebObjectUtil.explicitWait(30);
        	//WebObjectUtil.VerifyTextOnPage(UPMultiOrg.getNav_HomeCriticalAlerts().getText());
        	giraffe11CA=UPMultiOrg.getNav_HomeCriticalAlerts().getText();
            giraffe11DA=UPMultiOrg.getNav_HomeDevicesAlerts().getText();
        	giraffe11MjrA=UPMultiOrg.getNav_HomeMajorAlerts().getText();
        	giraffe11MnrA=UPMultiOrg.getNav_HomeMinorAlerts().getText();
        	giraffe11NA=UPMultiOrg.getNav_HomeNoticeAlerts().getText();
        	giraffe11RT=UPMultiOrg.getNav_HomeResolvedTickets().getText();
        	giraffe11OT=UPMultiOrg.getNav_HomeOutstandingTickets().getText();
        	//giraffe11DN=UPMultiOrg.getNav_HomeDraasNumerator().getText();
        	//giraffe11DD=UPMultiOrg.getNav_HomeDraasDenominator().getText();
        	giraffe11BW=UPMultiOrg.getNav_HomeBandwidth().getText();
        	giraffe11AO=UPMultiOrg.getNav_HomeAndover11Giraffes().getText();
        	//giraffe11[11]=UPMultiOrg.getNav_HomePrivateCloud11Giraffes().getText();
            
            }
        catch (Exception e) {
      		LoggerUtil.log_type_error("issue with-MultiOrg- VerifyGirDetails" );
      		LoggerUtil.log_type_error(e.getMessage());
      		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
      		}
            }
	/*=======================================================================
	Method Name 	: VerifyTstDevcodetails()
	Description		: Make sure that page changes according to organization
	Author 			: Priyanka Rachupalli
	Creation Date 	: 07/15/2015
	Pre-Requisites	:
	Revision History:
	========================================================================*/
	public static void VerifyTstDevcodetails()
	{
		PageFactory.initElements(WebDriverUtil.getDriver(),UPMultiOrg);
		PageFactory.initElements(WebDriverUtil.getDriver(),Ticket);
        try{
        	//String b[]=null;
        	WebObjectUtil.explicitWait(30);
        	//WebObjectUtil.VerifyTextOnPage(UPMultiOrg.getNav_HomeCriticalAlerts().getText());
        	tstDevcoCA=UPMultiOrg.getNav_HomeCriticalAlerts().getText();
        	tstDevcoDA=UPMultiOrg.getNav_HomeDevicesAlerts().getText();
        	tstDevcoMjrA=UPMultiOrg.getNav_HomeMajorAlerts().getText();
        	tstDevcoMnrA=UPMultiOrg.getNav_HomeMinorAlerts().getText();
        	tstDevcoNA=UPMultiOrg.getNav_HomeNoticeAlerts().getText();
        	tstDevcoRT=UPMultiOrg.getNav_HomeResolvedTickets().getText();
        	tstDevcoOT=UPMultiOrg.getNav_HomeOutstandingTickets().getText();
        	//tstDevcoDN=UPMultiOrg.getNav_HomeDraasNumerator().getText();
        	//tstDevcoDD=UPMultiOrg.getNav_HomeDraasDenominator().getText();
        	tstDevcoBW=UPMultiOrg.getNav_HomeBandwidth().getText();
        	tstDevcoAO=UPMultiOrg.getNav_HomeAndoverTstDevco().getText();
                       
            }
        catch (Exception e) {
      		LoggerUtil.log_type_error("issue with-MultiOrg- VerifyTstDevcodetails()" );
      		LoggerUtil.log_type_error(e.getMessage());
      		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
      		}
            }
	

	/*=======================================================================
	Method Name 	: VerifyMultiUsr11Gir()
	Description		: Make sure that page changes according to organization
	Author 			: Priyanka Rachupalli
	Creation Date 	: 07/15/2015
	Pre-Requisites	:
	Revision History:
	========================================================================*/
	public static void VerifyMultiUsrHomeval()
	{
		PageFactory.initElements(WebDriverUtil.getDriver(),UPMultiOrg);
		PageFactory.initElements(WebDriverUtil.getDriver(),Ticket);
        try{
        	//String c[]=null;
        	WebObjectUtil.explicitWait(30);
        	//WebObjectUtil.VerifyTextOnPage(UPMultiOrg.getNav_HomeCriticalAlerts().getText());
        	tstMultiorgCA=UPMultiOrg.getNav_HomeCriticalAlerts().getText();
        	tstMultiorgDA=UPMultiOrg.getNav_HomeDevicesAlerts().getText();
        	tstMultiorgMjrA=UPMultiOrg.getNav_HomeMajorAlerts().getText();
        	tstMultiorgMnrA=UPMultiOrg.getNav_HomeMinorAlerts().getText();
        	tstMultiorgNA=UPMultiOrg.getNav_HomeNoticeAlerts().getText();
        	tstMultiorgRT=UPMultiOrg.getNav_HomeResolvedTickets().getText();
        	tstMultiorgOT=UPMultiOrg.getNav_HomeOutstandingTickets().getText();
        	//tstMultiorgDN=UPMultiOrg.getNav_HomeDraasNumerator().getText();
        	//tstMultiorgDD=UPMultiOrg.getNav_HomeDraasDenominator().getText();
        	tstMultiorgBW=UPMultiOrg.getNav_HomeBandwidth().getText();
        	tstMultiorgAO=UPMultiOrg.getNav_HomeAndover11Giraffes().getText();
        	//tstMultiorg[11]=UPMultiOrg.getNav_HomePrivateCloud11Giraffes().getText();
           
            
            }
        catch (Exception e) {
      		LoggerUtil.log_type_error("issue with-MultiOrg- VerifyMultiUsr11Gir()" );
      		LoggerUtil.log_type_error(e.getMessage());
      		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
      		}
            }
	/*=======================================================================
	Method Name 	: VerifyMultiUsrTstdevco()
	Description		: Make sure that page changes according to organization
	Author 			: Priyanka Rachupalli
	Creation Date 	: 07/15/2015
	Pre-Requisites	:
	Revision History:
	========================================================================*/
	public static void VerifyMultiUsrTstdevco()
	{
		PageFactory.initElements(WebDriverUtil.getDriver(),UserPerm);
        try{
        	//String c[]=null;
        	WebObjectUtil.explicitWait(20);
        	WebObjectUtil.VerifyTextOnPage(UPMultiOrg.getNav_HomeCriticalAlerts().getText());
        	tstMultiorg1CA=UPMultiOrg.getNav_HomeCriticalAlerts().getText();
        	tstMultiorg1DA=UPMultiOrg.getNav_HomeDevicesAlerts().getText();
        	tstMultiorg1MjrA=UPMultiOrg.getNav_HomeMajorAlerts().getText();
        	tstMultiorg1MnrA=UPMultiOrg.getNav_HomeMinorAlerts().getText();
        	tstMultiorg1NA=UPMultiOrg.getNav_HomeNoticeAlerts().getText();
        	tstMultiorg1RT=UPMultiOrg.getNav_HomeResolvedTickets().getText();
        	tstMultiorg1OT=UPMultiOrg.getNav_HomeOutstandingTickets().getText();
        	//tstMultiorg1DN=UPMultiOrg.getNav_HomeDraasNumerator().getText();
        	//tstMultiorg1DD=UPMultiOrg.getNav_HomeDraasDenominator().getText();
        	tstMultiorg1BW=UPMultiOrg.getNav_HomeBandwidth().getText();
        	tstMultiorg1AO=UPMultiOrg.getNav_HomeAndoverTstDevco().getText();
           
            
            }
        catch (Exception e) {
      		LoggerUtil.log_type_error("issue with-MultiOrg- VerifyMultiUsrTstdevco()" );
      		LoggerUtil.log_type_error(e.getMessage());
      		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
      		}
            }
	/*=======================================================================
	Method Name 	: VerifyCompareGir()
	Description		: Make sure that page changes according to organization
	Author 			: Priyanka Rachupalli
	Creation Date 	: 07/15/2015
	Pre-Requisites	:
	Revision History:
	========================================================================*/
	public static void VerifyCompareGir()
	{
		PageFactory.initElements(WebDriverUtil.getDriver(),UPMultiOrg);
		PageFactory.initElements(WebDriverUtil.getDriver(),Ticket);
        try{
        	
        	    if(giraffe11CA.equalsIgnoreCase(tstMultiorgCA))
                   FrameworkUtil.updateCustomResultBasedOnStatus(true, giraffe11CA + " displayed after selction" );
                   else
                   FrameworkUtil.updateCustomResultBasedOnStatus(false,giraffe11CA + "  not displayed after selction" );
        	    if(giraffe11DA.equalsIgnoreCase(tstMultiorgDA))
            	   FrameworkUtil.updateCustomResultBasedOnStatus(true, giraffe11DA + "  displayed after selction" );
                   else
                   FrameworkUtil.updateCustomResultBasedOnStatus(false,giraffe11DA + "  not displayed after selction" );
        	    if(giraffe11MjrA.equalsIgnoreCase(tstMultiorgMjrA))
                   FrameworkUtil.updateCustomResultBasedOnStatus(true, giraffe11MjrA + "  displayed after selction" );
                   else
                   FrameworkUtil.updateCustomResultBasedOnStatus(false,giraffe11MjrA + "  not displayed after selction" );
        	    if(giraffe11MnrA.equalsIgnoreCase(tstMultiorgMnrA))
                    FrameworkUtil.updateCustomResultBasedOnStatus(true, giraffe11MnrA + " displayed after selction" );
                    else
                    FrameworkUtil.updateCustomResultBasedOnStatus(false,giraffe11MnrA + " not displayed after selction" );
        	    if(giraffe11NA.equalsIgnoreCase(tstMultiorgNA))
                	FrameworkUtil.updateCustomResultBasedOnStatus(true, giraffe11NA + " displayed after selction" );
                    else
                    FrameworkUtil.updateCustomResultBasedOnStatus(false,giraffe11NA + " not displayed after selction" );
        	    if(giraffe11RT.equalsIgnoreCase(tstMultiorgRT))
                	FrameworkUtil.updateCustomResultBasedOnStatus(true, giraffe11RT + " displayed after selction" );
                    else
                    FrameworkUtil.updateCustomResultBasedOnStatus(false,giraffe11RT + " not displayed after selction" );
        	    if(giraffe11OT.equalsIgnoreCase(tstMultiorgOT))
                	FrameworkUtil.updateCustomResultBasedOnStatus(true, giraffe11OT + "  displayed after selction" );
                    else
                    FrameworkUtil.updateCustomResultBasedOnStatus(false,giraffe11OT + " not displayed after selction" );
        	   if(giraffe11BW.equalsIgnoreCase(tstMultiorgBW))
                	FrameworkUtil.updateCustomResultBasedOnStatus(true, giraffe11BW + " displayed after selction" );
                    else
                    FrameworkUtil.updateCustomResultBasedOnStatus(false,giraffe11BW + " not displayed after selction" );
        	    
        	   if(giraffe11AO.equalsIgnoreCase(tstMultiorgAO))
                	FrameworkUtil.updateCustomResultBasedOnStatus(true, giraffe11AO + " displayed after selction" );
                    else
                    FrameworkUtil.updateCustomResultBasedOnStatus(false,giraffe11AO + " not displayed after selction" );

        	  /*  if(giraffe11DN.equalsIgnoreCase(tstMultiorgDN))
                	FrameworkUtil.updateCustomResultBasedOnStatus(true, giraffe11DN + " displayed after selction" );
                    else
                    FrameworkUtil.updateCustomResultBasedOnStatus(false,giraffe11DN + " not displayed after selction" );
        	    if(giraffe11DD.equalsIgnoreCase(tstMultiorgDD))
                	FrameworkUtil.updateCustomResultBasedOnStatus(true, giraffe11DD + " displayed after selction" );
                    else
                    FrameworkUtil.updateCustomResultBasedOnStatus(false,giraffe11DD + " not displayed after selction" );
        */	    }
        	
            
        catch (Exception e) {
      		LoggerUtil.log_type_error("issue with-MultiOrg- VerifyCompareGir()" );
      		LoggerUtil.log_type_error(e.getMessage());
      		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
      		}
        }
	/*=======================================================================
	Method Name 	: VerifyCompareTstDevco()
	Description		: Make sure that page changes according to organization
	Author 			: Priyanka Rachupalli
	Creation Date 	: 07/15/2015
	Pre-Requisites	:
	Revision History:
	========================================================================*/
	public static void  VerifyCompareTstDevco()
	{
		PageFactory.initElements(WebDriverUtil.getDriver(),UPMultiOrg);
		PageFactory.initElements(WebDriverUtil.getDriver(),Ticket);
        try{
        	 if(tstDevcoCA.equalsIgnoreCase(tstMultiorg1CA))
      		   FrameworkUtil.updateCustomResultBasedOnStatus(true, tstDevcoCA + " displayed after selction" );
                 else
                 FrameworkUtil.updateCustomResultBasedOnStatus(false,tstDevcoCA + " not displayed after selction" );
      	    if(tstDevcoDA.equalsIgnoreCase(tstMultiorg1DA))
          	   FrameworkUtil.updateCustomResultBasedOnStatus(true, tstDevcoDA + " displayed after selction" );
                 else
                 FrameworkUtil.updateCustomResultBasedOnStatus(false,tstDevcoDA + " not displayed after selction" );
      	    if(tstDevcoMjrA.equalsIgnoreCase(tstMultiorg1MjrA))
                 FrameworkUtil.updateCustomResultBasedOnStatus(true, tstDevcoMjrA + " displayed after selction" );
                 else
                 FrameworkUtil.updateCustomResultBasedOnStatus(false,tstDevcoMjrA + " not displayed after selction" );
      	    if(tstDevcoMnrA.equalsIgnoreCase(tstMultiorg1MnrA))
                  FrameworkUtil.updateCustomResultBasedOnStatus(true, tstDevcoMnrA + " displayed after selction" );
                  else
                  FrameworkUtil.updateCustomResultBasedOnStatus(false,tstDevcoMnrA + " not displayed after selction" );
      	    if(tstDevcoNA.equalsIgnoreCase(tstMultiorg1NA))
              	FrameworkUtil.updateCustomResultBasedOnStatus(true, tstDevcoNA + " displayed after selction" );
                  else
                  FrameworkUtil.updateCustomResultBasedOnStatus(false,tstDevcoNA + " not displayed after selction" );
      	    if(tstDevcoRT.equalsIgnoreCase(tstMultiorg1RT))
              	FrameworkUtil.updateCustomResultBasedOnStatus(true, tstDevcoRT + " displayed after selction" );
                  else
                  FrameworkUtil.updateCustomResultBasedOnStatus(false,tstDevcoRT + " not displayed after selction" );
      	    if(tstDevcoOT.equalsIgnoreCase(tstMultiorg1OT))
              	FrameworkUtil.updateCustomResultBasedOnStatus(true, tstDevcoOT + " displayed after selction" );
                  else
                  FrameworkUtil.updateCustomResultBasedOnStatus(false,tstDevcoOT + " not displayed after selction" );
      	    if(tstDevcoBW.equalsIgnoreCase(tstMultiorg1BW))
              	FrameworkUtil.updateCustomResultBasedOnStatus(true, tstDevcoBW + " displayed after selction" );
                  else
                  FrameworkUtil.updateCustomResultBasedOnStatus(false,tstDevcoBW + " not displayed after selction" );
      	    if(tstDevcoAO.equalsIgnoreCase(tstMultiorg1AO))
              	FrameworkUtil.updateCustomResultBasedOnStatus(true, tstDevcoAO + " displayed after selction" );
                  else
                  FrameworkUtil.updateCustomResultBasedOnStatus(false,tstDevcoAO + " not displayed after selction" );
      	  /*
      	    if(tstDevcoDN.equalsIgnoreCase(tstMultiorg1DN))
            	FrameworkUtil.updateCustomResultBasedOnStatus(true, tstDevcoDN + " displayed after selction" );
                else
                FrameworkUtil.updateCustomResultBasedOnStatus(false,tstDevcoDN + " not displayed after selction" );
    	    
      	    if(tstDevcoDD.equalsIgnoreCase(tstMultiorg1DD))
            	FrameworkUtil.updateCustomResultBasedOnStatus(true, tstDevcoDD + " displayed after selction" );
                else
                FrameworkUtil.updateCustomResultBasedOnStatus(false,tstDevcoDD + " not displayed after selction" );
      	*/
        	
        }
	  
    
    catch (Exception e) {
  		LoggerUtil.log_type_error("issue with-MultiOrg- VerifyCompareTstDevco()" );
  		LoggerUtil.log_type_error(e.getMessage());
  		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
  		}   
}	    
//_______________________________________Gideon TestCases____________________________________//       	    
      	    
/*========================================================================================================
TestScript  	: verifyOrgDataBySelectingFromEBPanelMultiOrg
Manual TestCase	: CPPOC-3376,3350 Verifying EB name not updates at top of the page and updates in Tickets,EVDC,Dras and individual pages
      	                    and Checking organization selected from dropdown top of the pages reflects in Top And EB.
Description		: Verifying EB name not updates at top of the page and updates in Tickets,EVDC,Dras and individual pages
      	                    and Checking organization selected from dropdown top of the pages reflects in Top And EB.
Author 			: QAA03
Creation Date 	: 08/26/2015
Pre-Requisites	:
Revision History:
      	  	==========================================================================================================*/
      	  	
     @Test(priority=1)	
      public static void verifyOrgDataBySelectingFromEBPanelMultiOrg()
      	 {
      	  	 
      	  	WebDriver driver = WebDriverUtil.getDriver();
      	  	
      	    PageFactory.initElements(driver,UPMultiOrg);
      	  	PageFactory.initElements(driver, Ticket);
      	  	PageFactory.initElements(driver, EVDC);
      	  	String sUserName=null,sPassword=null,sOrgtoSelect=null;
      	  		       
      	  		                 
      try {
  				FrameworkUtil.sTestCaseName = "verifyOrgDataBySelectingFromEBPanelMultiOrg";
  				FrameworkUtil.sManualTestCaseName="CPPOC-3376,3350 Verifying EB name not updates at top of the page and updates in Tickets,EVDC,Dras and individual pages and Checking organization selected from dropdown top of the pages reflects in Top And EB";
  				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
  				           
  			    sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.AROLE");
  			    sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.AROLE");
  			    sOrgtoSelect = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
  			    
  				LoginTestCase.nav_Login(sUserName, sPassword);
  				
  			    WebObjectUtil.selectWebList(UPMultiOrg.getNav_MOrg_SelectOrg(), sOrgtoSelect, null, 0);
 			   
		        WebObjectUtil.clickElement(UPMultiOrg.getNav_MOrg_UsethisOrgButton());
		   
		        WebObjectUtil.explicitWait(2);
		        HomeTestCase.nav_WindStreamToTierPointHomePopup();
		        
		        selectOrgnameInOrgSelector(sOrgtoSelect);
		        
		        checkEBNotUpdateTopUpdateTicketEVDCDraasData();
  				
  				checkOrgDataDropDown();
  				
  				//checkEBUpdateTicketData();
  				//checkEBUpdateEVDCData();
  				//checkEBUpdateDraasData();
  				
  				LoginTestCase.nav_Logout();
      	  				
  			} catch (Exception e) {
  				LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
  				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyOrgDataBySelectingFromEBPanelMultiOrg", "warn", "catch block:Could NOT access webelement" +e.getMessage());
  			}
  		    
      	  	}
        
        
 /*==============================================================
	TestScript  	: navValEntityBrwsrMultiOrgData
	Manual TestCase	: CPPOC-3352-Support Entity Browser and multi-org_Verify data display on EVDC for the selected organization
	Description		: Support Entity Browser and multi-org_Verify data display on EVDC for the selected organization
	Author 			: Vivek Kumar
	Creation Date 	: 08/25/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=23)
	public void navValEntityBrwsrMultiOrgData()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		 
		PageFactory.initElements(driver,UPMultiOrg);
		PageFactory.initElements(driver, EVDC);
		PageFactory.initElements(driver, EVDC_VMPF);
		//This below line updated on 10/08/2015 for EXTJS5 by QAA03
		//PageFactory.initElements(driver, Byron);
		
		FrameworkUtil.sTestCaseName = "Gideon-navValEntityBrwsrMultiOrgData";
		FrameworkUtil.sManualTestCaseName="CPPOC-3352-Support Entity Browser and multi-org_Verify data display on EVDC for the selected organization";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		String sUserName,sPassword,sEBPanelTitle,sEnableStatus,sEBChild,sVMStatus,sOrganizationName;
		String sOrgName,sVMName,sExpectedFeedBack,sActualFeedBack,sExpectedDescription,sActualDescription,sEVDCName;		
		boolean bStatus, bEVDCVMstatus;
		int iRowNbr;
		
		
		sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.AROLE");
		sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.AROLE");
		sEBChild=(String) FrameworkUtil.dictPropertyData.get("NAV.GIDEON.ENTITYBROWSER.CHILD");
		sVMStatus=(String) FrameworkUtil.dictPropertyData.get("NAV.GIDEON.VM.STATUS.STOPPED");
		sOrgName=(String) FrameworkUtil.dictPropertyData.get("NAV.GIDEON.ORG.NAME");
		sExpectedFeedBack=(String) FrameworkUtil.dictPropertyData.get("NAV.GIDEON.EVDC.EDIT.FEEDBACK.MESSAGE");
		sExpectedDescription=(String) FrameworkUtil.dictPropertyData.get("NAV.GIDEON.EVDC.EDIT.DESCRIPTION");
		sEVDCName =(String) FrameworkUtil.dictPropertyData.get("NAV.GIDEON.EVDCNAME");
		
		LoginTestCase.nav_Login(sUserName, sPassword);
		
		//Selecting from dropdown
		WebObjectUtil.selectWebList(UPMultiOrg.getNav_MultiOrgDropDown(),sOrgName, null, null);
		WebObjectUtil.clickElement(UPMultiOrg.getNav_UseThisOgrBtn());
		WebObjectUtil.explicitWait(5);
		sOrganizationName=UPMultiOrg.getNav_OrganizationName().getText();
		
		bStatus=WebObjectUtil.compareString(sOrgName,sOrganizationName , true);
		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, sOrgName + " -  match with Organization name");
		//Clicking on EB Panel
		WebObjectUtil.clickElement(UPMultiOrg.getNav_EntityBrowserLink());
		//Selecting Org from EB panel
		//This below line updated on 10/08/2015 for EXTJS5 by QAA03
		//SelectOrgFromAllLevelsEB(sEBChild,"","","");
		EntityBrowserTestCase.selectOrgFromAllLevelsEB(sEBChild, "", "", "");
		//Verifying and Clicking on EB Panel Title
		sEBPanelTitle=UPMultiOrg.getNav_EBPanelTitle().getText();
		bStatus=WebObjectUtil.compareString(sEBChild, sEBPanelTitle, true);
		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, sEBPanelTitle + " - title verified");
		WebObjectUtil.clickElement(UPMultiOrg.getNav_EBPanelTitle());
		
		//Verifying the "Back to your entity" 
		WebObjectUtil.clickElement(UPMultiOrg.getNav_EntityBrowserLink());
		WebObjectUtil.explicitWait(3);
		sEnableStatus=UPMultiOrg.getNav_EntityBrowserLink().getAttribute("class");
		
		bStatus=sEnableStatus.contains("disabledFooter");
		FrameworkUtil.updateCustomResultBasedOnStatus(!bStatus, " 'Back to entity' is enabled to go back. ");
		WebObjectUtil.clickElement(UPMultiOrg.getNav_EBPanelCloseBtn());
		//This Lines are updated on 10/09/2015 for EXTJS5 by QAA03
		//Navigate to EvDC page and expand stopped VM
		//EVDC_VM_AdvancedActions.navigateAndExpandVM(sVMStatus);
		bEVDCVMstatus = EVDC_VM_TestCase.navigateToEVDCVMPage(sEVDCName);
		
		iRowNbr=EVDC_VM_AdvancedActions.getRow_EVDC_VMTable(EVDC_VMPF.getNav_VMWebTableParent(),"Stopped","");
		
		CustomWebElementUtil.loadCustomElement(EVDC_VMPF.getNav_VMWebTableParent(),"table");
		int iRowCount = CustomWebElementUtil.iRowCount;
		if(iRowCount!=0)
		{
			EVDC_VM_AdvancedActions.expandVMbyRowNum(iRowNbr);

			EVDC_VM_TestCase.stopRunningVM(iRowNbr);
			//iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			sVMName=EVDC_VM_TestCase.navGetVMName(iRowNbr);
			sExpectedDescription=sExpectedDescription + "_"+ FrameworkUtil.sTimeStamp;
			//Editing VM
			//Verifying and Clicking on Edit button
			EVDC_VM_TestCase.navVerifyClkEditBtn(iRowNbr);
			//Verifying General Tab link
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_EditGeneralTab());
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralTab());
			//Verifying Description text
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_EditDescriptionInput());
			WebObjectUtil.SetValueEdit(EVDC_VMPF.getNav_EditDescriptionInput(), sExpectedDescription);
			//Saving the update
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_EditVMSaveBtn());
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMSaveBtn());
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_NewEVDCPopUpOKBtn());
			WebObjectUtil.explicitWait(30);
			
			//Validating feedback message
			sExpectedFeedBack=sVMName + " " + sExpectedFeedBack;
			sActualFeedBack=EVDC_VMPF.getNav_UserfeedBack().getText();
			bStatus=WebObjectUtil.compareString(sExpectedFeedBack, sActualFeedBack, true);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, sActualFeedBack);
			WebDriverUtil.refreshBrowser();
			WebObjectUtil.explicitWait(30);
			EVDC_VM_AdvancedActions.expandVMbyRowNum(iRowNbr);
			//Verifying again the Edit description
			EVDC_VM_TestCase.navVerifyClkEditBtn(iRowNbr);
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralTab());
			WebObjectUtil.explicitWait(5);
			sActualDescription=EVDC_VMPF.getNav_EditDescriptionInput().getText();
			bStatus=WebObjectUtil.compareString(sExpectedDescription, sActualDescription, false);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, sActualDescription);
			
			//Closing the window
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralCloseBtn());
			
		}
		else
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VM Data", "fail", "No VMS present");
		}
		//Logout
		LoginTestCase.nav_Logout();
				
		
	}      
    
    
    
    
	/*========================================================================================================
	TestScript  	: verifyEBTicketsForSelectedOrg
	Manual TestCase	: CPPOC-3351 Verifying EB and Tickets for the selected organization
	Description		: Verifying EB and Tickets for the selected organization
	Author 			: QAA03
	Creation Date 	: 09/01/2015
	Pre-Requisites	:
	Revision History:
		==========================================================================================================*/
		
	@Test(priority=4)	
	public static void verifyEBTicketsForSelectedOrg()
		{
		 
			       WebDriver driver = WebDriverUtil.getDriver();
			      
					 
					PageFactory.initElements(driver,UPMultiOrg);
			       PageFactory.initElements(driver, Ticket);
			      
			       String sUserName=null,sPassword=null;
			       
			                 
			    try {
					FrameworkUtil.sTestCaseName = "verifyEBTicketsForSelectedOrg";
					FrameworkUtil.sManualTestCaseName="CPPOC-3351 Verifying EB and Tickets for the selected organization";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					           
				    sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.AROLE");
				    sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.AROLE");
					
					LoginTestCase.nav_Login(sUserName, sPassword);
					
					checkEBForSelectedOrg();
					
					TicketTestCase.verifyCreateTicket();
					
					LoginTestCase.nav_Logout();
					
				} catch (Exception e) {
					LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyEBTicketsForSelectedOrg", "warn", "catch block:Could NOT access webelement" +e.getMessage());
				}
			    
		}
    
    
	/*==============================================================
	TestScript 		: nav_VerifyFirewallCount
	Manual TestCase	: Verify the firewall count for testmultiorg-RoleA1 and giruser
	Description		: verify The firewall count is matched for two users
	Author 			: QAA04
	Creation Date 	: 08/27/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/

	@Test(priority=13)
	public void nav_VerifyFirewallCount(){
		 String sMulOrgFireCount,sGirFireCount;
		WebDriver driver = WebDriverUtil.getDriver();
		
		PageFactory.initElements(driver,UPMultiOrg);
	    PageFactory.initElements(driver, EVDC_OverviewPF);
		try{
	    	 

	    FrameworkUtil.sTestCaseName="EVDC-nav_VerifyFirewallCount";
	    FrameworkUtil.sManualTestCaseName="(CPPOC-3341)Verify the firewall count for testmultiorg-RoleA1 and giruser";
	    FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	   
	    String sUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.AROLE1");
	    String sPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.AROLE");
		LoginTestCase.nav_Login(sUserName, sPassword);
		
		
		WebObjectUtil.selectWebList(UPMultiOrg.getNav_orgDropDown(), "11Giraffes", null, null);
		WebObjectUtil.clickElement(UPMultiOrg.getNav_UseOrgButton());
		WebObjectUtil.explicitWait(5);
		WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
		WebObjectUtil.MouseHover(UPMultiOrg.getNav_FirewallPortlet());
	    sMulOrgFireCount=UPMultiOrg.getNav_RulesCountText().getText();
	    FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "MultiOrgFirewallCount", "pass", "Firewall Count is = "+sMulOrgFireCount);
	   // System.out.println(" count is = "+sMulOrgFireCount);
	    WebObjectUtil.clickElement(UPMultiOrg.getNav_FirewallLink());
	    WebObjectUtil.explicitWait(5);
	    WebObjectUtil.VerifyTextUnderElement(UPMultiOrg.getNav_FirewallRulesTab(), "Firewall Rules");
	    LoginTestCase.nav_Logout();
	    WebObjectUtil.explicitWait(10);
	  
	    ///Login with giruser
	    String sGirUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.11GIRAFFS.USERID.AROLE");
	    String sGirPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.11GIRAFFS.PASSWORD.AROLE");
		LoginTestCase.nav_Login(sGirUserName, sGirPassword);
		
	    
		WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
		WebObjectUtil.MouseHover(UPMultiOrg.getNav_FirewallPortlet());
	    sGirFireCount=UPMultiOrg.getNav_RulesCountText().getText();
	    FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "GirFirewallCount", "pass", "Firewall Count is = "+sGirFireCount);
	    // System.out.println(" count is = "+sGirFireCount);
	    WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCOverviewFirewall());
	    WebObjectUtil.VerifyTextUnderElement(UPMultiOrg.getNav_FirewallRulesTab(), "Firewall Rules");
	    
	    if(sMulOrgFireCount.contains(sGirFireCount))
	    {
	    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "VerifyFirewallCount", "pass", "Firewall Count is Same For Two Users");
	    }
	    else
	    {
	    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "VerifyFirewallCount", "fail", "Firewall Count is  Not Same For Two Users");
	    }
	     
	    LoginTestCase.nav_Logout();
	     }
	     catch (Exception e) {
				// TODO Auto-generated catch block
		         	LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
			}
	}     
    
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
   //#########################################################################################
		//METHODS
//#########################################################################################

        
 /*====================================================================================================
 Method Name 	: checkEBNotUpdateTop
 Description		: Checking EB name not updates at top of the page
 Author 			: QAA03
 Creation Date 	: 08/26/2015
 Pre-Requisites	:
 Revision History:
 ====================================================================================================*/

 public static void	checkEBNotUpdateTop()
 {
 	       String sUser=null,sEBOrgname=null,sFLCOrgname=null;
 	      // String sOrgtoSelect = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
 	        WebDriver driver = WebDriverUtil.getDriver();
 	       PageFactory.initElements(driver,UPMultiOrg);
 			PageFactory.initElements(driver,Ticket);
 	       
 	       try {
 			  // sUser=UPMultiOrg.getNav_MOrg_User().getText();
 			  /* WebObjectUtil.selectWebList(UPMultiOrg.getNav_MOrg_SelectOrg(), sOrgtoSelect, null, 0);
 			   
 			   WebObjectUtil.clickElement(UPMultiOrg.getNav_MOrg_UsethisOrgButton());
 			   
 			   WebObjectUtil.explicitWait(2);
 			  HomeTestCase.nav_WindStreamToTierPointHomePopup();*/
 			   sUser = UPMultiOrg.getNav_OrganizationName().getText();
 			   WebObjectUtil.clickElement(UPMultiOrg.getNav_Users_EntityBrowserLink());
 			   //getting first row data from FLC in EB
 			   sFLCOrgname = WebTableUtil.getCellData(UPMultiOrg.getNav_Users_EB_FLCOrgTable(), 1, 1);
 			  EntityBrowserTestCase.selectOrgFromAllLevelsEB(sFLCOrgname,"", "", "");
 			   sEBOrgname = UPMultiOrg.getNav_Users_EntityBrowserTab().getText();
 			   WebObjectUtil.clickElement(UPMultiOrg.getNav_Users_EntityBrowserTab());
 			   //Verifying EB name with the user
 			   if(!sUser.contentEquals(sEBOrgname))
 			   {
 				   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "OrgSelectedAndUser", "pass", "Org name in EB does not matched with the user as expected"); 
 			   }
 			   else
 			   {
 				   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "OrgSelectedAndUser", "fail", "Org name in EB matched with the user"); 
 			   }
 			  // WebObjectUtil.clickElement(UPMultiOrg.getNav_Users_EB_CloseTab());
 		} catch (Exception e) {
 			      
 			LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
 			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "checkEBNotUpdateTop", "warn", "catch block:Could NOT access webelement" +e.getMessage());
 		}
 }    
  /*====================================================================================================
  Method Name   	: checkOrgDataDropDown
  Description		: Checking organization selected from dropdown top of the pages reflects in Top And EB
  Author 			: QAA03
  Creation Date 	: 08/31/2015
  Pre-Requisites	:
  Revision History:
  ====================================================================================================*/
  public static void checkOrgDataDropDown()
  {
  	           WebElement wOrgName,wOrgNametoSelect;
  	           int iFirstOrg =1;
  	           String sOrgName=null,sEBName=null,sOrgtoSelect=null,sOrg2toSelect=null;
  	           
  	           sOrg2toSelect = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME1");
  	           WebDriver driver =WebDriverUtil.getDriver();
  	            PageFactory.initElements(driver,UPMultiOrg);
 			    PageFactory.initElements(driver,Ticket);
  	    try {
  	        	
   			      // WebObjectUtil.MouseHover(UPMultiOrg.getNav_MOrg_OrgName());
  				 WebObjectUtil.ClickAndMouseHover(UPMultiOrg.getNav_MOrg_OrgName());
  				   //wOrgName = WebObjectUtil.GetWebElement("xpath","//ul[@id='idMultiMenuOrgs']/li["+iFirstOrg+"]/a", "Orgname");        
  				   // This object is updated on 10/15/2015 By QAA04
  				   //wOrgName = WebObjectUtil.getWebElementFromDynamicLocator("xpath","EBPANEL.MULTLYORG.ORGNAME", "PARAMETER_FIRSTORGNAME", iFirstOrg +"");
  				   wOrgName = WebObjectUtil.getWebElementFromDynamicLocator("xpath","EBPANEL.MULTLYORG.ORGNAMETOSELECT", "PARAMETER_ORGNAME", sOrg2toSelect +"");
  				   WebObjectUtil.clickElement(wOrgName);
  				   sOrgName = UPMultiOrg.getNav_MOrg_OrgName().getText();
  				   sEBName = UPMultiOrg.getNav_Users_EntityBrowserLink().getText();
  				   
  				   if(sOrgName.equalsIgnoreCase(sEBName))
  				   {
  					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "OrgNameSelected", "pass", "Organization name selected equals to EBPanel name and Org selected is"+sOrgName); 
  				   }
  				   else
  				   {
  					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "OrgNameSelected", "fail", "Organization name selected not equals to EBPanel name and Org selected is"+sOrgName);
  				   }
  				 
  				   
  				/* WebObjectUtil.clickElement(UPMultiOrg.getNav_MOrg_OrgName());
  				 wOrgName = WebObjectUtil.getWebElementFromDynamicLocator("xpath","EBPANEL.MULTLYORG.ORGNAME", "PARAMETER_FIRSTORGNAME", (iFirstOrg+1) +"");
				   WebObjectUtil.clickElement(wOrgName);
				   
	  				 WebObjectUtil.clickElement(UPMultiOrg.getNav_MOrg_OrgName());
	  				 wOrgName = WebObjectUtil.getWebElementFromDynamicLocator("xpath","EBPANEL.MULTLYORG.ORGNAME", "PARAMETER_FIRSTORGNAME", (iFirstOrg+1) +"");
					   WebObjectUtil.clickElement(wOrgName);*/
					   
  				   // This object is updated on 10/15/2015 By QAA04
  				   //wOrgNametoSelect = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EBPANEL.MULTLYORG.ORGNAMETOSELECT", "PARAMETER_ORGNAME", sOrgtoSelect );
  				// wOrgNametoSelect = WebObjectUtil.getActiveElementByText("a", "TST Devco1");
				  // WebObjectUtil.clickElement(wOrgNametoSelect);
  				 
  			} catch (Exception e) {
  				
  				LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
  				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "checkOrgDataDropDown", "warn", "catch block:Could NOT access webelement" +e.getMessage());
 	      				
 	      			}
 	      }
  
 	     /*====================================================================================================
 Method Name 	: checkEBUpdateTicketData
 Description		: Checking EB name data updates in Tickets page
 Author 			: QAA03
 Creation Date 	: 08/26/2015
 Pre-Requisites	:
 Revision History:
 ====================================================================================================*/
 public static void checkEBUpdateTicketData()
 {
 	        WebDriver driver = WebDriverUtil.getDriver();
 	        String sTktsCountUser=null,sOpenTktsUser=null,sWorkingTktsUser=null,sPendingTktsUser=null;
 	        String sFLCOrgname=null,sTotalTktsUser=null,sTktsCountEntity=null,sOpenTktsEntity=null;
 	        int iTotalCountTktsUser=0, iTktsCountUser=0,iTktsCountEntity=0;
 	        
 	      PageFactory.initElements(driver,UPMultiOrg);
		  PageFactory.initElements(driver,Ticket);
 	        try {
 				sTktsCountUser = Ticket.getNav_TicketsCount().getText();
 				iTktsCountUser = Integer.parseInt(sTktsCountUser);
 				/*WebObjectUtil.clickElement(Ticket.getNav_TicketsLink());
 				sOpenTktsUser =Ticket.getNav_OpenTicketNumbers().getText();
 				sWorkingTktsUser = Ticket.getNav_WorkingTicketNumbers().getText();
 				sPendingTktsUser = Ticket.getNav_PendingTicketNumbers().getText();
 				iTotalCountTktsUser = Integer.parseInt(sOpenTktsUser)+ Integer.parseInt(sWorkingTktsUser)+Integer.parseInt(sPendingTktsUser);
 				sTotalTktsUser = String.valueOf(iTotalCountTktsUser);*/
 				
 				WebObjectUtil.clickElement(UPMultiOrg.getNav_Users_EntityBrowserLink());
 				//getting first row data from FLC in EB
 				sFLCOrgname = WebTableUtil.getCellData(UPMultiOrg.getNav_Users_EB_FLCOrgTable(), 1, 1);
 				EntityBrowserTestCase.selectOrgFromAllLevelsEB(sFLCOrgname,"", "", "");
 				WebObjectUtil.clickElement(UPMultiOrg.getNav_Users_EntityBrowserTab());
 				/*sOpenTktsEntity = Ticket.getNav_OpenTicketNumbers().getText();
 				WebObjectUtil.clickElement(UPMultiOrg.getNav_WindStremIcon());*/
 				WebObjectUtil.explicitWait(5);
 				sTktsCountEntity = Ticket.getNav_TicketsCount().getText();
 				iTktsCountEntity = Integer.parseInt(sTktsCountEntity);
 				
 				

 					if (iTktsCountEntity != iTktsCountUser)
 					{
 						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Ticketsdata", "pass", "Data is changing in tickets with respect to the entity selected in EB as Expected");
 					}
 					else
 					{
 					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Ticketsdata", "warn", "Data is not changing in tickets with respect to the entity selected in EB");
 					}

 			} catch (NumberFormatException e) {
 				
 				LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
 				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "checkEBUpdateTicketData", "warn", "catch block:Could NOT access webelement" +e.getMessage());
 			}
 }
   
    /*====================================================================================================
    Method Name 	: checkEBUpdateEVDCData
    Description		: Checking EB name data updates in EVDC page
    Author 			: QAA03
    Creation Date 	: 08/26/2015
    Pre-Requisites	:
    Revision History:
    ====================================================================================================*/
    public static void checkEBUpdateEVDCData()
    {
    	        WebDriver driver = WebDriverUtil.getDriver();
    	        
    	        String sEVDCUser=null,sEVDCEntity=null,sFLCOrgname=null;
    	        
    	          PageFactory.initElements(driver,UPMultiOrg);
     			  PageFactory.initElements(driver,Ticket);
    	          PageFactory.initElements(driver, EVDC_VMPF);
    	          PageFactory.initElements(driver, EVDC_OverviewPF);
    	          
     			  try {
    	        	if(!WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_EVDCMarketingImage()))
    	      	{
    				sEVDCUser = EVDC_OverviewPF.getNav_EVDCname().getText();
    				sFLCOrgname = WebTableUtil.getCellData(UPMultiOrg.getNav_Users_EB_FLCOrgTable(), 1, 1);
     				EntityBrowserTestCase.selectOrgFromAllLevelsEB(sFLCOrgname,"", "", "");
     				WebObjectUtil.clickElement(UPMultiOrg.getNav_Users_EntityBrowserTab());
    				
    				WebObjectUtil.explicitWait(10);
    				sEVDCEntity = EVDC_OverviewPF.getNav_EVDCname().getText();
    				
    				if(!sEVDCUser.contentEquals(sEVDCEntity))
    				{
    					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "EVDCdata", "pass", " EVDC data is changing with respect to the entity selected in EB as Expected");
    				}
    				else
    				{
    					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "EVDCdata", "fail", " EVDC data is not changing with respect to selected entity in EB");
    				}
    	      	}
    	        	else
    	       	{
    	        		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "NOEVDCdata", "warn", "No EVDC Found - EVDC Marketing Data is displayed for the Seleceted Organization");
    	       	}
    	        		
    			} catch (Exception e) {
    				    
    				LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
    				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "checkEBUpdateEVDCData", "warn", "catch block:Could NOT access webelement" +e.getMessage());
    			}
    	        
    }    
   /*====================================================================================================
   Method Name  	: checkEBUpdateDraasData
   Description		: Checking EB name data updates in Draas page
   Author 			: QAA03
   Creation Date 	: 08/26/2015
   Pre-Requisites	:
   Revision History:
   ====================================================================================================*/
     	   public static void checkEBUpdateDraasData()
     	   {
     		       WebDriver driver = WebDriverUtil.getDriver();
     	   	         String sDraasUserData=null,sDraasEntityData=null,sFLCOrgname=null;
     	   	        PageFactory.initElements(driver,UPMultiOrg);
    			    PageFactory.initElements(driver,Ticket);
     	   	         try {
     	   				sDraasUserData = UPMultiOrg.getNav_MOrg_DraasData().getText();
     	   				 WebObjectUtil.clickElement(UPMultiOrg.getNav_Users_EntityBrowserLink());
     	   				    //getting first row data from FLC in EB
     	   				 sFLCOrgname = WebTableUtil.getCellData(UPMultiOrg.getNav_Users_EB_FLCOrgTable(), 1, 1);
     	   				EntityBrowserTestCase.selectOrgFromAllLevelsEB(sFLCOrgname,"", "", "");
     	   				 WebObjectUtil.clickElement(UPMultiOrg.getNav_Users_EntityBrowserTab());
     	   				 sDraasEntityData = UPMultiOrg.getNav_MOrg_DraasData().getText();
     	   				 if(!sDraasUserData.contentEquals(sDraasEntityData))
     	   					{
     	   						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Draasdata", "pass", " Draas data is changing with respect to the entity selected in EB as Expected");
     	   					}
     	   					else
     	   					{
     	   						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Draasdata", "warn", " Draas data is not changing with respect to selected entity in EB");
     	   					}
     	   				 
     	   			} catch (Exception e) {
     	   				
     	   				LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
     	   				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "checkEBUpdateDraasData", "warn", "catch block:Could NOT access webelement" +e.getMessage());
     	   			}
     	   			 
     	   }
/*====================================================================================================
 Method Name 	: checkEBForSelectedOrg
Description		: Checking EB name for the selected Organization
Author 			: QAA03
Creation Date 	: 09/01/2015
Pre-Requisites	:
 Revision History:
 ====================================================================================================*/

     	   	     public static void checkEBForSelectedOrg()
     	   	     {
     	   	     	           String sFLCOrgname=null,sEBDisabled=null,sEBOrgname=null;
     	   	     	           String sOrgtoSelect = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
     	   	     	           boolean bOrgNameSelectedEB;
     	   	     	       
     	   	     	           WebDriver driver = WebDriverUtil.getDriver();
     	   	     	           PageFactory.initElements(driver,UPMultiOrg);
     	   	     	       try {
     	   	     			  
     	   	     			   WebObjectUtil.selectWebList(UPMultiOrg.getNav_MOrg_SelectOrg(), sOrgtoSelect, null, 0);
     	   	     			   WebObjectUtil.clickElement(UPMultiOrg.getNav_MOrg_UsethisOrgButton());
     	   	     			   
     	   	     			   WebObjectUtil.clickElement(UPMultiOrg.getNav_Users_EntityBrowserLink());
     	   	     			   //getting first row data from FLC in EB
     	   	     			   sFLCOrgname = WebTableUtil.getCellData(UPMultiOrg.getNav_Users_EB_FLCOrgTable(), 1, 1);
     	   	     			   EntityBrowserTestCase.selectOrgFromAllLevelsEB(sFLCOrgname,"", "", "");
     	   	     			   sEBDisabled=UPMultiOrg.getNav_Users_EntityBrowserLink().getAttribute("class");
     	   	     			   //checking EB grayed out 
     	   	     				if(sEBDisabled.contains("disabledFooter"))
     	   	     				{
     	   	     					FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Back to your Entity link is grayed out before selecting any first level chield from EB Panel");
     	   	     				}
     	   	     				else
     	   	     				{
     	   	     					FrameworkUtil.updateCustomResultBasedOnStatus(false,  "Back to your Entity link is not grayed out before selecting any first level chield from EB Panel");
     	   	     				}
     	   	     				sEBOrgname = UPMultiOrg.getNav_Users_EntityBrowserTab().getText();
     	   	     				bOrgNameSelectedEB = sEBOrgname.contentEquals(sFLCOrgname); 
     	   	     				// verifying org name selected displayed in EB
     	   	     				FrameworkUtil.updateCustomResultBasedOnStatus(bOrgNameSelectedEB, "Organization selected displayed on top of EB");
     	   	     				
     	   	     				WebObjectUtil.clickElement(UPMultiOrg.getNav_Users_EntityBrowserTab());
     	   	     			    //checking EB enabled
     	   	     				if(UPMultiOrg.getNav_Users_EntityBrowserLink().isEnabled())
     	   	     				{
     	   	     					FrameworkUtil.updateCustomResultBasedOnStatus(true,  "EB name is enabled");
     	   	     				}
     	   	     				else
     	   	     				{
     	   	     					FrameworkUtil.updateCustomResultBasedOnStatus(false,  "EB name is not enabled");
     	   	     				}

     	   	     		} catch (Exception e) {
     	   	     			      
     	   	     			LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
     	   	     			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "checkEBForSelectedOrg", "warn", "catch block:Could NOT access webelement" +e.getMessage());
     	   	     		}
     	   	     }
  /*====================================================================================================
 	  Method Name   	: checkEBNotUpdateTopUpdateTicketEVDCDraasData
 	  Description		: Checking EB name data updates in Tickets,EVDC and Draas page
 	  Author 			: QAA03
 	  Creation Date 	: 08/26/2015
 	  Pre-Requisites	:
 	  Revision History:
 ====================================================================================================*/
 public static void checkEBNotUpdateTopUpdateTicketEVDCDraasData()
 {
     	   WebDriver driver = WebDriverUtil.getDriver();
		   String sUser=null,sEBOrgname=null,sTktsCountUser=null,sEVDCUser=null,sDraasUserData=null,sDraasEntityData=null;
		   String sFLCOrgname=null,sTktsCountEntity=null,sEVDCEntity=null;
		   int iTktsCountUser=0,iTktsCountEntity=0;
		   
			  PageFactory.initElements(driver,EVDC_OverviewPF); 
			  PageFactory.initElements(driver,UPMultiOrg);
			  PageFactory.initElements(driver,Ticket);
    try {
    	    sUser = UPMultiOrg.getNav_OrganizationName().getText();
			sTktsCountUser = Ticket.getNav_TicketsCount().getText();
			iTktsCountUser = Integer.parseInt(sTktsCountUser);
			/*WebObjectUtil.clickElement(Ticket.getNav_TicketsLink());
			sOpenTktsUser =Ticket.getNav_OpenTicketNumbers().getText();
			sWorkingTktsUser = Ticket.getNav_WorkingTicketNumbers().getText();
			sPendingTktsUser = Ticket.getNav_PendingTicketNumbers().getText();
			iTotalCountTktsUser = Integer.parseInt(sOpenTktsUser)+ Integer.parseInt(sWorkingTktsUser)+Integer.parseInt(sPendingTktsUser);
			sTotalTktsUser = String.valueOf(iTotalCountTktsUser);*/
			sEVDCUser = EVDC_OverviewPF.getNav_EVDCname().getText();
			sDraasUserData = UPMultiOrg.getNav_MOrg_DraasData().getText();
			
			WebObjectUtil.clickElement(UPMultiOrg.getNav_Users_EntityBrowserLink());
			//getting first row data from FLC in EB
			sFLCOrgname = WebTableUtil.getCellData(UPMultiOrg.getNav_Users_EB_FLCOrgTable(), 1, 1);
			EntityBrowserTestCase.selectOrgFromAllLevelsEB(sFLCOrgname,"", "", "");
			sEBOrgname = UPMultiOrg.getNav_Users_EntityBrowserTab().getText();
			WebObjectUtil.clickElement(UPMultiOrg.getNav_Users_EntityBrowserTab());
			/*sOpenTktsEntity = Ticket.getNav_OpenTicketNumbers().getText();
			WebObjectUtil.clickElement(UPMultiOrg.getNav_WindStremIcon());*/
			WebObjectUtil.explicitWait(5);
			
			    //Verifying EB Name not updated at the Top Of the Page
			  if(!sUser.contentEquals(sEBOrgname))
			   {
				   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "OrgSelectedAndUser", "pass", "Org name in EB does not matched with the user as expected"); 
			   }
			   else
			   {
				   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "OrgSelectedAndUser", "fail", "Org name in EB matched with the user"); 
			   }
			  
				//Verifying EB Name updated in the Tickets Page
				sTktsCountEntity = Ticket.getNav_TicketsCount().getText();
				iTktsCountEntity = Integer.parseInt(sTktsCountEntity);
			
			
				if (iTktsCountEntity != iTktsCountUser)
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Ticketsdata", "pass", "Data is changing in tickets with respect to the entity selected in EB as Expected");
				}
				else
				{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Ticketsdata", "warn", "Data is not changing in tickets with respect to the entity selected in EB");
				}
				
				//Verifying EB Name updated in the EVDC Page
				
				if(!WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_EVDCMarketingImage()))
    	      	{
    				
    				sEVDCEntity = EVDC_OverviewPF.getNav_EVDCname().getText();
    				
    				 if(!sEVDCUser.contentEquals(sEVDCEntity))
    				 {
    					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "EVDCdata", "pass", " EVDC data is changing with respect to the entity selected in EB as Expected");
    				 }
    				 else
    				 {
    					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "EVDCdata", "fail", " EVDC data is not changing with respect to selected entity in EB");
    				 }
    	      	}
    	        	else
    	       	{
    	        		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "NOEVDCdata", "warn", "No EVDC Found - EVDC Marketing Data is displayed for the Seleceted Organization");
    	       	}
 	        		
				   //Verifying EB Name updated in the Draas Page
  	   				 sDraasEntityData = UPMultiOrg.getNav_MOrg_DraasData().getText();
  	   				 if(!sDraasUserData.contentEquals(sDraasEntityData))
  	   					{
  	   						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Draasdata", "pass", " Draas data is changing with respect to the entity selected in EB as Expected");
					}
					else
					{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Draasdata", "warn", " Draas data is not changing with respect to selected entity in EB");
					}
				 
	
		} catch (NumberFormatException e) {
			
			LoggerUtil.log_type_error("catch block: " + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "checkEBNotUpdateTopUpdateTicketEVDCDraasData", "warn", "catch block:Could NOT access webelement" +e.getMessage());
	  			}
 }	 
  	  
	     	   	     	       
 //___________________________ Completed Gideon TestCases ________________________________________///     

     	   	    
      
  ///////////////////////////////////Eilerson TestCases Start////////////////////////////////////// 
     	   	     
  	//------------------------------------ Sukur Start----------------------------------------------//
     	   	     
 /*==============================================================
	TestScript 		: navVerifyMultiOrgPermissionFunctionalityForEVDCVMEditFunctionality
	Manual TestCase	: WCP_1346_TC_3.1_Manage Entities_MultiOrg_Edit Permissions for descendants
	Description		: QAT-18 Login to Navigator as MultiOrg user and verify Permissions page.
	Author 			: Sukur Babu. B
	Creation Date 	: 11/12/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/

	@Test(priority=201)
	public void nav_VerifyMultiOrgPermissionFunctionalityForEVDCVMEditFunctionality(){
		 String sMulOrgFireCount,sGirFireCount;
		WebDriver driver = WebDriverUtil.getDriver();
		
		PageFactory.initElements(driver,UserPermission);
		PageFactory.initElements(driver,UPMultiOrg);
	    PageFactory.initElements(driver, EVDC_OverviewPF);
	    PageFactory.initElements(driver, ManageEntity);
		try{
	    	 

	    FrameworkUtil.sTestCaseName="UserPermMultiOrg-nav_VerifyMultiOrgPermissionFunctionalityForEVDCVMEditFunctionality";
	    FrameworkUtil.sManualTestCaseName="QAT-18 Login to Navigator as MultiOrg user and verify Permissions page.";
	    FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	   
	    String sUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.AROLE1");
	    String sPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.AROLE");
		String sOrgName1=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
	   
		LoginTestCase.nav_Login(sUserName, sPassword);
		
		
		WebObjectUtil.selectWebList(UPMultiOrg.getNav_orgDropDown(), "11Giraffes", null, null);
		WebObjectUtil.clickElement(UPMultiOrg.getNav_UseOrgButton());
		
		WebObjectUtil.explicitWait(1);
		HomeTestCase.nav_WindStreamToTierPointHomePopup();
		WebObjectUtil.clickElement(UPMultiOrg.getNav_AccountTab());
		WebObjectUtil.clickElement(UserPermission.getNav_PermissionsLink());
		
		selectOrgs(sOrgName1);
		
		String sEntityName=WebTableUtil.getCellData(UserPermission.getNav_Users_Table(), 2, 5);
		boolean bRes=sEntityName.contains(sOrgName1);
		if(bRes)
			FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Org name is matching with expected");
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false,  "Org name is not matching with expected");
		WebObjectUtil.clickElement(UserPermission.getNav__ManageEntityTab());
		WebElement wEntity=WebObjectUtil.GetWebElement("xpath", "//section[@id='user_management']//span[text()='"+sOrgName1+"']", "Entity");
		wEntity.click();
		WebObjectUtil.clickElement(ManageEntity.getNav_EditEntityFirstRowImg());
		
		UserPermissionManageEntityTestCase.editPermissionManageEntity("Add VM,Edit VM",false,false);
		
		
		WebObjectUtil.ClickAndMouseHover(UserPermission.getNav_MonitoringTab());
		WebObjectUtil.clickElement(UserPermission.getNav_SummaryViewLink());
		//WebObjectUtil.clickElement(UserPermission.getNav_EVDCNameLink());
		//WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
		WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
		WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
		int iRowNo = EVDC_VM_AdvancedActions.getRow_EVDC_VMTable(EVDC_VMPF.getNav_VMWebTableParent(),"Stopped","");
		boolean bStatus;
		if (iRowNo > 0 ){
			bStatus = true;
			EVDC_VM_AdvancedActions.expandVMbyRowNum(iRowNo);
		}
		//EVDC_VM_AdvancedActions.navigateAndExpandVM("Stopped");
		int iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
		//EVDC_VM_TestCase.navVerifyEditBtn(iRowNbr);
		WebElement wEdit = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.EDITVM", "PARAMETER_ROWNUMBER", iRowNbr+"");
		
		if(wEdit==null)
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button is still visible after removing permission" , "fail", "Edit button");
			//LoggerUtil.log_type_error("Edit button not verified");
			
		}
		else
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button is not visible after removing permission " , "pass","Edit button verified");
			//LoggerUtil.log_type_info("Edit button verified" );
		}
		WebObjectUtil.verifyElementNOTPresent(EVDC_VMPF.getNav_AddVMLink());
		
		WebObjectUtil.clickElement(UPMultiOrg.getNav_AccountTab());
		WebObjectUtil.clickElement(UserPermission.getNav_PermissionsLink());
		WebObjectUtil.clickElement(UserPermission.getNav__ManageEntityTab());
		WebElement wEntity1=WebObjectUtil.GetWebElement("xpath", "//section[@id='user_management']//span[text()='"+sOrgName1+"']", "Entity");
		wEntity1.click();
		WebObjectUtil.clickElement(ManageEntity.getNav_EditEntityFirstRowImg());
		UserPermissionManageEntityTestCase.editPermissionManageEntity("Add VM,Edit VM",true,false);
		
} catch (Exception e) {
	LoggerUtil.log_type_error("issue with- navVerifyMultiOrgPermissionFunctionalityForEVDCVMEditFunctionality()" );
	LoggerUtil.log_type_error(e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
		
	}
	
	//------------------------------------ Sukur End----------------------------------------------//
	
//------------------------------------ QAA04 Start----------------------------------------------//
	/*==============================================================
	TestScript 		: navVerifyOrgNameUnderEntityColumn
	Manual TestCase	: CPPOC-3404/QAT-26
	Description		: verify the Entity column shows Tst Devco1 org and Click on 11Giraffes verify the body is displayed or not
	Author 			: QAA04
	Creation Date 	: 09/03/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	@Test(priority=202)
	public void navVerifyOrgNameUnderEntityColumn() {
		String sMultiOrgName;
		WebDriver driver = WebDriverUtil.getDriver();
		//PageFactory.initElements(driver, ManageEntity);
		PageFactory.initElements(driver, UPMultiOrg);
		PageFactory.initElements(driver, UserPermission);
		try{
			FrameworkUtil.sTestCaseName ="navVerifyOrgNameUnderEntityColumn";
			FrameworkUtil.sManualTestCaseName="(QAT-26)verify the Entity column shows Tst Devco1 org";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			String sUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.AROLE1");
			String sPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.AROLE");
			LoginTestCase.nav_Login(sUserName, sPassword);
			
			sMultiOrgName=(String) FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
			
			// Selecting Org From SelectOrg
			WebObjectUtil.selectWebList(UPMultiOrg.getNav_orgDropDown(),sMultiOrgName,null, null);
			
			WebObjectUtil.clickElement(UPMultiOrg.getNav_UseOrgButton());
			
			//WebObjectUtil.explicitWait(5);
			WebObjectUtil.clickElement(UserPermission.getNav_AccountTab());
			WebObjectUtil.clickElement(UserPermission.getNav_PermissionsLink());
			//WebObjectUtil.explicitWait(5);
			//sMultiOrgName=(String) FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
			WebObjectUtil.VerifyTextUnderElement(UserPermission.getNav_OrgTitleInEntityColumn(),sMultiOrgName);
			WebObjectUtil.explicitWait(3);
			WebObjectUtil.clickElement(UPMultiOrg.getNav_Orglink());
			
			WebObjectUtil.clickElement(UserPermission.getNav_11GiraffesLinkUnderOrg());
			
			WebObjectUtil.verifyElementNOTPresent(UserPermission.getNav_AddUserLink());
			WebObjectUtil.explicitWait(3);
			
			///// log out
			
			LoginTestCase.nav_Logout();
			
			
			
		}
		catch (Exception e) {
			LoggerUtil.log_type_error("Issue with - verifing the Entity column shows Tst Devco1 org");
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
			LoggerUtil.log_type_error(e.getMessage());
		}
	}
	
	
	
	/*==============================================================
	TestScript 		: nav_VerifyPermisionsLink
	Manual TestCase	: CPPOC-3446/QAT-24
	Description		: verify the Permissions link
	Author 			: QAA04
	Creation Date 	: 09/04/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	
	@Test(priority=203)
	public void navVerifyPermissionsLink() {
		//intialize the variable QAA03-14/09/2015
		String sMultiOrgName;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, UPMultiOrg);
		PageFactory.initElements(driver, UserPermission);
		try{
			FrameworkUtil.sTestCaseName ="navVerifyPermissionsLink";
			FrameworkUtil.sManualTestCaseName="(QAT-24)verify the Permissions link Under Account Tab";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			String sUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.MULTIORG.USERID");
			String sPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.MULTIORG.PWD");
			LoginTestCase.nav_Login(sUserName, sPassword);
			
			sMultiOrgName=(String) FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
			WebObjectUtil.selectWebList(UPMultiOrg.getNav_orgDropDown(), sMultiOrgName, null, null);
			//WebObjectUtil.selectWebList(Eilerson.getNav_orgDropDown(), "TST Devco1", null, null);
			WebObjectUtil.clickElement(UPMultiOrg.getNav_UseOrgButton());
			WebObjectUtil.explicitWait(5);
			WebObjectUtil.clickElement(UserPermission.getNav_AccountTab());
			WebObjectUtil.verifyElementNOTPresent(UserPermission.getNav_PermissionsLink());
			WebObjectUtil.explicitWait(5);
		 
			
		///// log out
			
			LoginTestCase.nav_Logout();
			
							
		}
		catch (Exception e) {
			LoggerUtil.log_type_error("Issue with - verifing the Permissions link");
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
			LoggerUtil.log_type_error(e.getMessage());
		}
	}
			
	//------------------------------------ QAA04 End----------------------------------------------//
	
	
/////////********************************Vivek Start***********************************/////////////////
	
	/*==============================================================
	TestScript 		: valManageEntityMultiOrgCpyPermission
	Manual TestCase	: QAT-41-WCP_1346_TC_3.2_Manage Entities_MultiOrg_Copy Permissions
	Description		: Manage Entities_MultiOrg_Copy Permissions
	Author 			: Vivek Kumar
	Creation Date 	: 11/25/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=204)
	public static void valManageEntityMultiOrgCpyPermission()
	{
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, UPMultiOrg);
		PageFactory.initElements(driver, UserPermission);
		PageFactory.initElements(driver,EVDC_VMPF);
		PageFactory.initElements(driver,EVDC_OverviewPF);
		
		String sUserName,sPassword,sActOrgName,sExpOrgName,sSourceEntity,sDestination,sMultiOrg,sEVDCName;
		boolean bOrgStatus=false,bBtnStatus=false;
		String sAgentUserName,sAgentPassword;
		int iRowNo;
		WebElement wEdit,wEVDCName;
		
		
		FrameworkUtil.sTestCaseName ="valManageEntityMultiOrgCpyPermission";
		FrameworkUtil.sManualTestCaseName="QAT-41-WCP_1346_TC_3.2_Manage Entities_MultiOrg_Copy Permissions";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		
		
		sUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.AROLE1");
		sPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.AROLE");
		
		sAgentUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.TSTGETSMART.AGENT.USERID");
		sAgentPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.TSTGETSMART.AGENT.PASSWORD");
		
		sExpOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.UP.MANAGEENTITY.11GIRAFFES.ORG.NAME");
		sSourceEntity=(String)FrameworkUtil.dictPropertyData.get("NAV.UP.MANAGEENTITY.TSTDEVCO1.COPY.SRC");
		sDestination=(String)FrameworkUtil.dictPropertyData.get("NAV.UP.MANAGEENTITY.TSTGETSMART.COPY.DEST");
		sMultiOrg=(String)FrameworkUtil.dictPropertyData.get("NAV.UP.MANAGEENTITY.TSTDEVCO1.MULTIORG");
		sEVDCName=(String)FrameworkUtil.dictPropertyData.get("NAV.UP.EVDCNAME.TSTGETSMART");
		
		
		//Login using "testmultiorg-RoleA1"
		LoginTestCase.nav_Login(sUserName,sPassword);
		
		//Selecting "11 Giraffes"(value =763)from dropdown and click on "Use this org button
		WebObjectUtil.selectWebList(UPMultiOrg.getNav_MultiOrgDropDown(), null, "763", null);
		
		//Clicking on "Use this org" button
		WebObjectUtil.clickElement(UPMultiOrg.getNav_UseThisOrgButton());
		
		HomeTestCase.nav_WindStreamToTierPointHomePopup();
		sActOrgName=UPMultiOrg.getNav_OrganizationnameLink().getText().trim();
		bOrgStatus=sActOrgName.equalsIgnoreCase(sExpOrgName);
		FrameworkUtil.updateCustomResultBasedOnStatus(bOrgStatus, "Expected Organization "+sExpOrgName+"displayed");
		
		
		//Select Permission from Account tab
		WebObjectUtil.ClickAndMouseHover(UserPermission.getNav_AccountLink());
		WebObjectUtil.clickElement(UserPermission.getNav_PermissionsLink());
		WebDriverUtil.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		//Select "Tst Devco1" from top selector
		UserPermissionMultiOrgTestCase.switchOraganization(sMultiOrg);
	
		
		//Select Manage Entity tab
		WebObjectUtil.clickAndVerifyElement(UserPermission.getNav_ManageEntityTab(), UserPermission.getNav_ManageEntityNameHeader());
		//Clicking on Edit pencil link
		UserPermissionManageEntityTestCase.clickonEditCopyIconManageEntity(sSourceEntity, null, "edit");
	
		//Unchecking the Permission - Edit VM and Add VM
		UserPermissionManageEntityTestCase.editPermissionManageEntity("Add VM,Edit VM", false, false);
		
		//Clicking on Edit pencil link
		UserPermissionManageEntityTestCase.clickonEditCopyIconManageEntity(sSourceEntity, null, "copy");
		
		//Verifying the confirm popup message and userfeedback message
		UserPermissionManageEntityTestCase.valManageEntityCopyFunction(sSourceEntity,sDestination,false);
		//Logout
		LoginTestCase.nav_Logout();
		//###########################################
		//Login using Agent99
		//###########################################
		
		
		LoginTestCase.nav_Login(sAgentUserName, sAgentPassword);
		
		//Navigate to EVDC-VM Page
		//Clicking on EVDC Name and validating its landing page
		wEVDCName=EVDC_VM_TestCase.getEVDCNameAsWebElement(sEVDCName);
		WebObjectUtil.clickElement(wEVDCName);
	//	WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
		WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
		WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
		
		//Verifying "Add VM" link should not be there
		WebObjectUtil.verifyElementNOTPresent(EVDC_VMPF.getNav_AddVMLink());
		
		iRowNo = EVDC_VM_AdvancedActions.getRow_EVDC_VMTable(EVDC_VMPF.getNav_VMWebTableParent(),"Stopped","");
		//System.out.println("VM name: " + sVMName + "--" + iRowNo);
		//WebTableUtil.printEachCellText(EVDC.getNav_VMWebTable());
		if (iRowNo > 0 ){
			EVDC_VM_AdvancedActions.expandVMbyRowNum(iRowNo);
		}
		else
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VM Number at EVDC VM page", "fail", "VM number :" + iRowNo);
		}
		
		//Verifying "Edit VM" should not be there
		wEdit=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+ iRowNo+"]/td/table/tbody/tr[2]//a[contains(text(),'Edit')]","Edit Button");
		bBtnStatus=(wEdit==null);
		FrameworkUtil.updateCustomResultBasedOnStatus(bBtnStatus, "User "+ sAgentUserName +" unable to view Edit button");
		//Logging out from Navigator application
		LoginTestCase.nav_Logout();
		
		
		
	}
	
/////////********************************Vivek End***********************************/////////////////
	
	 ///////////////////////////////////Eilerson TestCases End////////////////////////////////////// 
	
 /*public static void editEntity(String sEntityName)
 {
         
       WebDriver driver = WebDriverUtil.getDriver();
       PageFactory.initElements(driver,UPMultiOrg);
	   try {
		   		WebElement wEntity=WebObjectUtil.GetWebElement("xpath", "//section//table[contains(@id,'treeview')]//span[text()='"+sEntityName+"']", "Entity Element");
		   		wEntity.click();
		   		
		   
		   
	   }
	  catch (Exception e) {
			LoggerUtil.log_type_error("issue with- editEntity()" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
			}
     	    			
    }*/


public static boolean selectOrgnameInOrgSelector(String sOrgName){
	String sOrgNameRunTime;
	boolean bFlag=false;
	WebElement wOrgName;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, UPMultiOrg);
	
	try {
		WebObjectUtil.clickElement(UPMultiOrg.getNav_MOrg_OrgName());
		wOrgName = WebObjectUtil.getWebElementFromDynamicLocator("xpath","EBPANEL.MULTLYORG.ORGNAMETOSELECT", "PARAMETER_ORGNAME", sOrgName);	
		wOrgName.click();
		bFlag=true;
	} catch (Exception e1) {
	try {
		WebObjectUtil.clickElement(UPMultiOrg.getNav_MOrg_OrgName());
		List<WebElement> wbs = UPMultiOrg.getNav_MOrg_OrgName().findElements(By.tagName("li"));
			for (int i=0;i<wbs.size()*2;i++ ){
				try {
					WebObjectUtil.ClickAndMouseHover(UPMultiOrg.getNav_MOrg_OrgName());
					wOrgName = WebObjectUtil.getWebElementFromDynamicLocator("xpath","EBPANEL.MULTLYORG.ORGNAME", "PARAMETER_FIRSTORGNAME", wbs.size()+"" );	
					wOrgName.click();
					   //WebObjectUtil.clickElement(wOrgName);
					   sOrgNameRunTime = UPMultiOrg.getNav_OrganizationName().getText();
					if (sOrgNameRunTime.equalsIgnoreCase(sOrgName))  {
						bFlag=true;
						break;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					WebDriverUtil.refreshBrowser();
					e.printStackTrace();
					
				} 
			}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
return bFlag;	
}
	
	//update each @test result in custom result file
	@AfterMethod
	public static void afterEachMethod(){
		FrameworkUtil.updateTestCaseStatusinResult();
		
	}

}
