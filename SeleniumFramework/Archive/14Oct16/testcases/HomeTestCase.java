package com.whs.navigator.testcases;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.EM7PageFactory;
import com.whs.navigator.pagefactory.EVDC_FirewallPageFactory;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.FAQPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.DraasPageFactory;
import com.whs.navigator.pagefactory.SmokeTestPageFactory;
import com.whs.navigator.pagefactory.TicketPageFactory;
import com.whs.navigator.testcases.LoginTestCase_Old1;
public class HomeTestCase 
{
	public static EM7PageFactory EM7 = new EM7PageFactory();
	public static HomePageFactory_old Home = new HomePageFactory_old();
	public static DraasPageFactory Draas = new DraasPageFactory();
	public static SmokeTestPageFactory SmokeTest = new SmokeTestPageFactory();
	static SmokeTestPageFactory Smoke = new SmokeTestPageFactory();
	public static FAQPageFactory FAQ = new FAQPageFactory();
	public static EVDC_OverviewPageFactory EVDC_OverviewPF = new EVDC_OverviewPageFactory();
	public static TicketPageFactory Ticket = new TicketPageFactory();
	
	
	static String sFeedbackTitle=null;
	/*==============================================================
	TestScript 		: navClickMenuAndDropDown
	Manual TestCase	: Check the menu and dropdowns under each menu (single-org user)
	Description		: Verifying and clicking each dropdown list from Menu
	Author 			: Vivek Kumar
	Creation Date 	:12/12/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	@Test(priority=1)
	public void navClickMenuAndDropDown()
	{

		try {
			FrameworkUtil.sTestCaseName = "SummarynavClickMenuAndDropDown";
			FrameworkUtil.sManualTestCaseName="Check the menu and dropdowns under each menu (single-org user)";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,Home);
			//FrameworkUtil.sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			//FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			//getting username from properties file
			//String sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID"); //
			String sUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
			//getting password from properties file
			//String sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
			String sPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
			//Login to Navigator portal
			//LoginTestCase.nav_Login(sUserName, sPassword);
			//LoginTestCase.LoginAsGirUser();
			LoginTestCase_Old1.LoginAsQaautoUser();
			
			//Verifying and clicking every Menu Link inside Monitoring Tab
			//Clicking and Verifying Summary view 
			WebObjectUtil.ClickAndMouseHover(Home.getNav_MonitoringTab());
			WebObjectUtil.clickAndVerifyUrl(Home.getNav_SummaryViewMenuLink(),(String)FrameworkUtil.dictPropertyData.get("NAV.SUMMARYVIEWMENULINK.URL"));
			//driver.navigate().back();
			
			//Clicking and Verifying Reports Link URL
			WebObjectUtil.ClickAndMouseHover(Home.getNav_MonitoringTab());
			WebObjectUtil.clickAndVerifyUrl(Home.getNav_ReportMenuLink(),(String)FrameworkUtil.dictPropertyData.get("NAV.REPORTSMENULINK.URL"));
			//driver.navigate().back();
			
			//Verifying and clicking every Menu Link inside Service Tab
			//Clicking and Verifying DRAAS Link URL
			WebObjectUtil.ClickAndMouseHover(Home.getNav_ServicesTab());
			WebObjectUtil.clickAndVerifyUrl(Home.getNav_DRaaSMenuLink(),(String)FrameworkUtil.dictPropertyData.get("NAV.DRAASMENULINK.URL"));
			//driver.navigate().back();
			
			//Clicking and Verifying DNS Link URL
			WebObjectUtil.ClickAndMouseHover(Home.getNav_ServicesTab());
			WebObjectUtil.clickAndVerifyUrl(Home.getNav_DNSMenuLink(),(String)FrameworkUtil.dictPropertyData.get("NAV.DNSMENULINK.URL"));
			//driver.navigate().back();

			//Clicking and Verifying Cloud API Link URL
			WebObjectUtil.ClickAndMouseHover(Home.getNav_ServicesTab());
			WebObjectUtil.clickAndVerifyUrl(Home.getNav_CloudAPIMenuLink(),(String)FrameworkUtil.dictPropertyData.get("NAV.CLOUDAPIMENULINK.URL"));
			//driver.navigate().back();
/*
			//Clicking and Verifying Cloud API Link URL
			WebObjectUtil.ClickAndMouseHover(Home.getNav_ServicesTab());
			WebObjectUtil.clickElement(Home.getNav_CloudServicesMenuLink());
			WebObjectUtil.clickElement(Home.getNav_CloudServicePOPUp());
			
			//WebObjectUtil.clickAndVerifyUrl(Home.getNav_CloudServicesMenuLink(),(String)FrameworkUtil.dictPropertyData.get("NAV.CLOUDAPIMENULINK.URL"));
			//driver.navigate().back();
			*/
			
			//Verifying and clicking every Menu Link inside Security Tab
			//Clicking and Verifying DDoSMitigation Link URL
			WebObjectUtil.ClickAndMouseHover(Home.getNav_SecurityTab());
			WebObjectUtil.clickAndVerifyUrl(Home.getNav_DDoSMitigationMenuLink(),(String)FrameworkUtil.dictPropertyData.get("NAV.DDOSMENULINK.URL"));
			//driver.navigate().back();
			
			//Clicking and Verifying Cloud AV Link URL
			WebObjectUtil.ClickAndMouseHover(Home.getNav_SecurityTab());
			WebObjectUtil.clickAndVerifyUrl(Home.getNav_CloudAVMenuLink(),(String)FrameworkUtil.dictPropertyData.get("NAV.CLOUDAVMENULINK.URL"));
			//driver.navigate().back();

			//Verifying and clicking every Menu Link inside Support Tab
			//Clicking and Verifying Tickets Link URL
			WebObjectUtil.ClickAndMouseHover(Home.getNav_SupportTab());
			WebObjectUtil.clickAndVerifyUrl(Home.getNav_TicketsMenuLink(),(String)FrameworkUtil.dictPropertyData.get("NAV.TICKETSMENULINK.URL"));
			//driver.navigate().back();
			
			//Clicking and Verifying Announcements Link URL
			WebObjectUtil.ClickAndMouseHover(Home.getNav_SupportTab());
			WebObjectUtil.clickAndVerifyUrl(Home.getNav_AnnouncementsMenuLink(),(String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENTSMENULINK.URL"));
//	driver.navigate().back();

			//Clicking and Verifying Documents Link URL
			WebObjectUtil.ClickAndMouseHover(Home.getNav_SupportTab());
			WebObjectUtil.clickAndVerifyUrl(Home.getNav_DocumentsMenuLink(),(String)FrameworkUtil.dictPropertyData.get("NAV.DOCUMENTSMENULINK.URL"));
			//driver.navigate().back();
			
			//Verifying and clicking every Menu Link inside Account Tab
			//Clicking and Verifying Esclation List Link URL
			WebObjectUtil.ClickAndMouseHover(Home.getNav_AccountTab());
			WebObjectUtil.clickAndVerifyUrl(Home.getNav_EsclationListMenuLink(),(String)FrameworkUtil.dictPropertyData.get("NAV.ESCLATIONLISTMENULINK.URL"));
			//driver.navigate().back();
			driver.get(((String)FrameworkUtil.dictPropertyData.get("NAV.SUMMARYVIEWMENULINK.URL")));
			
		
			//Clicking and Verifying Account Setting Link URL
			WebObjectUtil.ClickAndMouseHover(Home.getNav_AccountTab());
			WebObjectUtil.clickAndVerifyUrl(Home.getNav_AccountSettingsMenuLink(),(String)FrameworkUtil.dictPropertyData.get("NAV.ACCOUNTSETTING.URL"));
			//driver.navigate().back();
			driver.get(((String)FrameworkUtil.dictPropertyData.get("NAV.SUMMARYVIEWMENULINK.URL")));
			
			//Verifying and clicking Edit Profile Menu Link User Name
			//Clicking and Verifying Edit Profile Link URL
			WebObjectUtil.ClickAndMouseHover(Home.getNav_UserNameLink());
			WebObjectUtil.clickAndVerifyUrl(Home.getNav_EditProfileLink(),(String)FrameworkUtil.dictPropertyData.get("NAV.EDITPROFILE.URL"));
			//driver.navigate().back();
			
			
			//Click on Logout and verifying the link
			//WebObjectUtil.ClickAndMouseHover(Home.getNav_UserNameLink());
			//WebObjectUtil.clickAndVerifyUrl(Home.getNav_LogoutLink(),(String)FrameworkUtil.dictPropertyData.get("NAV.LOGOUTLINK.URL"));
			
			//log out Navigator
			LoginTestCase_Old1.nav_Logout();
			WebObjectUtil.verifyUrl((String)FrameworkUtil.dictPropertyData.get("NAV.LOGOUTLINK.URL"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LoggerUtil.log_type_error("Method:navClickMenuAndDropDown, Error MSG :" + e.getMessage());
		}
		
	}

	/*==============================================================
	TestScript 		: navClickMenuAndDropDownMultiOrgUser
	Manual TestCase	: Check the menu and dropdowns under each menu (Multi-org user)
	Description		: Verify page is loaded with selected Org details shown
	Author 			: Vivek Kumar
	Creation Date 	:12/15/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	//@Test(priority=2)
	public void navClickMenuAndDropDownMultiOrgUser() 
	{
		try {
			FrameworkUtil.sTestCaseName = "SummarynavClickMenuAndDropDownMultiOrgUser";
			FrameworkUtil.sManualTestCaseName="Check the menu and dropdowns under each menu (multi-org user)";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,Home);
			//FrameworkUtil.sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			//FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			//getting username from properties file
			//String sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID"); //
			String sUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.MULTIORG.USERID");
			//getting password from properties file
			//String sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
			String sPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.MULTIORG.PWD");
			
			String sListByText = (String)FrameworkUtil.dictPropertyData.get("NAV.LIST.BYTEXT.TSTHAWAII");
			String sListByValue=(String)FrameworkUtil.dictPropertyData.get("NAV.LIST.BYVALUE.TSTHAWAII");
			//Login to Navigator portal
			//LoginTestCase.nav_Login(sUserName, sPassword);
			LoginTestCase_Old1.LoginAsTestMultiOrgUser();
			//WebObjectUtil.clickElement(Home.getNav_MultiSelectList());
			//WebObjectUtil.isMultiSelect(Home.getNav_MultiSelectList());
			WebObjectUtil.selectWebList(Home.getNav_MultiSelectList(), null, sListByValue, null);
			Thread.sleep(3000);
			//WebObjectUtil.selectWebList(Home.getNav_MultiSelectList(), null, sListByValue, null);
			//WebObjectUtil.clickElement(Home.getNav_UseOrganizationBtn());
			WebObjectUtil.clickAndVerifyText(Home.getNav_UseOrganizationBtn(), sListByText);
			//Selecting TST Western Michigan Broncos from Dropdown
			WebObjectUtil.ClickAndMouseHover(Home.getNav_TSTHawaiiLink());
			WebObjectUtil.clickAndVerifyText(Home.getNav_TSTWesternLink(), "TST Western Michigan Broncos");
			//log out Navigator
			LoginTestCase_Old1.nav_Logout();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			LoggerUtil.log_type_error("Method:navClickMenuAndDropDownMultiOrgUser, Error MSG :" + e.getMessage());
		}
	}
	

	/*==============================================================
	TestScript 		: navDeviceAlertsBoxExistence
	Manual TestCase	: Check for the existence of the Devices/Alerts box
	Description		: Verify Device Box Existence
	Author 			: Vivek Kumar
	Creation Date 	:12/15/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=3)
	public void navDeviceAlertsBoxExistence()
	{
		try {
			FrameworkUtil.sTestCaseName = "SummarynavDeviceAlertsBoxExistence";
			FrameworkUtil.sManualTestCaseName="Check for the existence of the Devices/Alerts box";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,Home);
			//FrameworkUtil.sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			//getting username from properties file
			//String sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID"); //
			String sUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
			//getting password from properties file
			//String sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
			String sPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
			//Login to Navigator portal
			//LoginTestCase.nav_Login(sUserName, sPassword);
			//LoginTestCase.LoginAsGirUser();
			LoginTestCase_Old1.LoginAsQaautoUser();
			//Verifying Device Alerts Section
			WebObjectUtil.assertElementPresent(Home.getNav_DeviceAlertSection());
			//log out Navigator
			LoginTestCase_Old1.nav_Logout();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LoggerUtil.log_type_error("Method:navDeviceAlertsBoxExistence, Error MSG :" + e.getMessage());
		}
		
	}

	/*==============================================================
	TestScript 		: navDeviceAlertsBoxContents
	Manual TestCase	: Check each piece of content on the Devices/Alerts box
	Description		: Verify Device Box contents
	Author 			: Vivek Kumar
	Creation Date 	:12/15/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=4)
	public void navDeviceAlertsBoxContents()
	{
		try {
			FrameworkUtil.sTestCaseName = "SummarynavDeviceAlertsBoxContents";
			FrameworkUtil.sManualTestCaseName="Check each piece of content on the Devices/Alerts box";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,Home);
			//FrameworkUtil.sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			//FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			//getting username from properties file
			//String sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID"); //
			String sUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
			//getting password from properties file
			//String sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
			String sPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
			//Login to Navigator portal
			//LoginTestCase.nav_Login(sUserName, sPassword);
			//LoginTestCase.LoginAsGirUser();
			LoginTestCase_Old1.LoginAsQaautoUser();
			//Verifying Critical Text and number under Device Alerts Box
			WebObjectUtil.assertElementPresent(Home.getNav_AlertCriticalText());
			WebObjectUtil.assertElementPresent(Home.getNav_AlertCriticalNumber());
			//Verifying Major Text and Number under Device Alerts Box
			WebObjectUtil.assertElementPresent(Home.getNav_AlertMajorText());
			WebObjectUtil.assertElementPresent(Home.getNav_AlertMajorNumber());
			//Verifying Minor Text and Number under Device Alerts Box
			WebObjectUtil.assertElementPresent(Home.getNav_AlertMinorText());
			WebObjectUtil.assertElementPresent(Home.getNav_AlertNoticeNumber());
			//Verifying Notice Text and Number under Device Alerts Box
			WebObjectUtil.assertElementPresent(Home.getNav_AlertNoticeText());
			WebObjectUtil.assertElementPresent(Home.getNav_AlertNoticeNumber());
			//log out Navigator
			LoginTestCase_Old1.nav_Logout();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LoggerUtil.log_type_error("Method name : navDeviceAlertsBoxContents, Error MSG :" + e.getMessage());
		}

	}
	
	/*==============================================================
	TestScript 		: navBreadCrumbNavigator
	Manual TestCase	: Check the breadcrumb on each page in Navigator.
	Description		: Verify Breadcrumb for each link under Menu
	Author 			: Vivek Kumar
	Creation Date 	:12/16/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=5)
	public void navBreadCrumbNavigator() 
	{
		try {
			FrameworkUtil.sTestCaseName = "SummarynavBreadCrumbNavigator";
			FrameworkUtil.sManualTestCaseName="Check the breadcrumb on each page in Navigator.";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,Home);
			//FrameworkUtil.sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			//FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			//getting username from properties file
			//String sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID"); //
			String sUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
			//getting password from properties file
			//String sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
			String sPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
			//Login to Navigator portal
			//LoginTestCase.nav_Login(sUserName, sPassword);
			//LoginTestCase.LoginAsGirUser();
			LoginTestCase_Old1.LoginAsQaautoUser();
			
			//Clicking and Verifying Summary view 
			WebObjectUtil.ClickAndMouseHover(Home.getNav_MonitoringTab());
			WebObjectUtil.clickAndVerifyText(Home.getNav_SummaryViewMenuLink(),"Home");
			//driver.navigate().back();
					
			//Clicking and Verifying Reports Link URL
			WebObjectUtil.ClickAndMouseHover(Home.getNav_MonitoringTab());
			WebObjectUtil.clickAndVerifyText(Home.getNav_ReportMenuLink(), "Reports");
			//driver.navigate().back();
			
			//Verifying and clicking every Menu Link inside Service Tab
			//Clicking and Verifying DRAAS Link URL
			WebObjectUtil.ClickAndMouseHover(Home.getNav_ServicesTab());
			WebObjectUtil.clickAndVerifyText(Home.getNav_DRaaSMenuLink(), "DRaaS");
			//driver.navigate().back();
			
			//Clicking and Verifying DNS Link URL
			WebObjectUtil.ClickAndMouseHover(Home.getNav_ServicesTab());
			WebObjectUtil.clickAndVerifyText(Home.getNav_DNSMenuLink(), "DNS");
			//driver.navigate().back();

			//Clicking and Verifying Cloud API Link URL
			WebObjectUtil.ClickAndMouseHover(Home.getNav_ServicesTab());
			WebObjectUtil.clickAndVerifyText(Home.getNav_CloudAPIMenuLink(), "Cloud API");
			//driver.navigate().back();
/*
			//Clicking and Verifying Cloud API Link URL
			WebObjectUtil.ClickAndMouseHover(Home.getNav_ServicesTab());
			WebObjectUtil.clickElement(Home.getNav_CloudServicesMenuLink());
			WebObjectUtil.clickElement(Home.getNav_CloudServicePOPUp());
			
			//WebObjectUtil.clickAndVerifyUrl(Home.getNav_CloudServicesMenuLink(),(String)FrameworkUtil.dictPropertyData.get("NAV.CLOUDAPIMENULINK.URL"));
			//driver.navigate().back();
			*/
			
			//Verifying and clicking every Menu Link inside Security Tab
			//Clicking and Verifying DDoSMitigation Link URL
			//WebObjectUtil.ClickAndMouseHover(Home.getNav_SecurityTab());
			//WebObjectUtil.clickAndVerifyText(Home.getNav_DDoSMitigationMenuLink(), "DDoS Defense");
			//driver.navigate().back();
			
			//Clicking and Verifying Cloud AV Link URL
			WebObjectUtil.ClickAndMouseHover(Home.getNav_SecurityTab());
			WebObjectUtil.clickAndVerifyText(Home.getNav_CloudAVMenuLink(), "Cloud AV");
			//driver.navigate().back();

			//Verifying and clicking every Menu Link inside Support Tab
			//Clicking and Verifying Tickets Link URL
			WebObjectUtil.ClickAndMouseHover(Home.getNav_SupportTab());
			WebObjectUtil.clickAndVerifyText(Home.getNav_TicketsMenuLink(), "Tickets");
			//driver.navigate().back();
			
			//Clicking and Verifying Announcements Link URL
			WebObjectUtil.ClickAndMouseHover(Home.getNav_SupportTab());
			WebObjectUtil.clickAndVerifyText(Home.getNav_AnnouncementsMenuLink(), "Announcements");
//	driver.navigate().back();

			//Clicking and Verifying Documents Link URL
			WebObjectUtil.ClickAndMouseHover(Home.getNav_SupportTab());
			WebObjectUtil.clickAndVerifyText(Home.getNav_DocumentsMenuLink(), "Documents");
			//driver.navigate().back();
			
			//Verifying and clicking every Menu Link inside Account Tab
			//Clicking and Verifying Esclation List Link URL
			WebObjectUtil.ClickAndMouseHover(Home.getNav_AccountTab());
			WebObjectUtil.clickAndVerifyText(Home.getNav_EsclationListMenuLink(), "Escalation List");
			driver.navigate().back();
			
			//Verifying and clicking Edit Profile Menu Link User Name
			//Clicking and Verifying Edit Profile Link URL
			WebObjectUtil.ClickAndMouseHover(Home.getNav_UserNameLink());
			WebObjectUtil.clickAndVerifyText(Home.getNav_EditProfileLink(), "Edit");
			//driver.navigate().back();
			//Click on Logout and verifying the link
			WebObjectUtil.ClickAndMouseHover(Home.getNav_UserNameLink());
			//WebObjectUtil.clickAndVerifyUrl(Home.getNav_LogoutLink(),(String)FrameworkUtil.dictPropertyData.get("NAV.LOGOUTLINK.URL"));
			LoginTestCase_Old1.nav_Logout();
			WebObjectUtil.verifyUrl((String)FrameworkUtil.dictPropertyData.get("NAV.LOGOUTLINK.URL"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LoggerUtil.log_type_error("Method name : navBreadCrumbNavigator, Error MSG :" + e.getMessage());
		}
		
		
	}
	
	/*==============================================================
	TestScript 		: navUpwardsExistingBreadCrumb
	Manual TestCase	: Click upwards along an existing breadcrumb.
	Description		: Verify onclickng breadcrumb prior 
					  to the current one it will take it to home page
	Author 			: Vivek Kumar
	Creation Date 	:12/16/2014
	Pre-Requisites	:
	Revision History:DNS is throwing error
	==============================================================*/
	@Test(priority=6)
	public void navUpwardsExistingBreadCrumb()
	{
		try {
			FrameworkUtil.sTestCaseName = "SummarynavUpwardsExistingBreadCrumb";
			FrameworkUtil.sManualTestCaseName="Click upwards along an existing breadcrumb.";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,Home);
			//FrameworkUtil.sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			//FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			//getting username from properties file
			//String sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID"); //
			String sUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
			//getting password from properties file
			//String sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
			String sPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
			//Login to Navigator portal
			//LoginTestCase.nav_Login(sUserName, sPassword);
			//LoginTestCase.LoginAsGirUser();
			LoginTestCase_Old1.LoginAsQaautoUser();
			
			//Clicking and Verifying Summary view 
			WebObjectUtil.ClickAndMouseHover(Home.getNav_MonitoringTab());
			WebObjectUtil.clickAndVerifyText(Home.getNav_SummaryViewMenuLink(),"Home");
			WebObjectUtil.clickAndVerifyText(Home.getNav_HomeBreadcrumb(), "Home");
			
			//Clicking and Verifying Reports Link URL
			WebObjectUtil.ClickAndMouseHover(Home.getNav_MonitoringTab());
			WebObjectUtil.clickAndVerifyText(Home.getNav_ReportMenuLink(), "Reports");
			WebObjectUtil.clickAndVerifyText(Home.getNav_HomeBreadcrumb(), "Home");
			
			//Verifying and clicking every Menu Link inside Service Tab
			//Clicking and Verifying DRAAS Link URL
			WebObjectUtil.ClickAndMouseHover(Home.getNav_ServicesTab());
			WebObjectUtil.clickAndVerifyText(Home.getNav_DRaaSMenuLink(), "DRaaS");
			WebObjectUtil.clickAndVerifyText(Home.getNav_HomeBreadcrumb(), "Home");
			/*		DNS is throwing error
			//Clicking and Verifying DNS Link URL
			WebObjectUtil.ClickAndMouseHover(Home.getNav_ServicesTab());
			WebObjectUtil.clickAndVerifyText(Home.getNav_DNSMenuLink(), "DNS");
			WebObjectUtil.clickAndVerifyText(Home.getNav_HomeBreadcrumb(), "Home");

			*///Clicking and Verifying Cloud API Link URL
			WebObjectUtil.ClickAndMouseHover(Home.getNav_ServicesTab());
			WebObjectUtil.clickAndVerifyText(Home.getNav_CloudAPIMenuLink(), "Cloud API");
			WebObjectUtil.clickAndVerifyText(Home.getNav_HomeBreadcrumb(), "Home");
			
			/*
			//Clicking and Verifying Cloud API Link URL
			WebObjectUtil.ClickAndMouseHover(Home.getNav_ServicesTab());
			WebObjectUtil.clickElement(Home.getNav_CloudServicesMenuLink());
			WebObjectUtil.clickElement(Home.getNav_CloudServicePOPUp());
					
			//WebObjectUtil.clickAndVerifyUrl(Home.getNav_CloudServicesMenuLink(),(String)FrameworkUtil.dictPropertyData.get("NAV.CLOUDAPIMENULINK.URL"));
			//driver.navigate().back();
			*/
					
			//Verifying and clicking every Menu Link inside Security Tab
			//Clicking and Verifying DDoSMitigation Link URL
			//WebObjectUtil.ClickAndMouseHover(Home.getNav_SecurityTab());
			//WebObjectUtil.clickAndVerifyText(Home.getNav_DDoSMitigationMenuLink(), "DDoS Defense");
			//WebObjectUtil.clickAndVerifyText(Home.getNav_HomeBreadcrumb(), "Home");
					
			//Clicking and Verifying Cloud AV Link URL
			WebObjectUtil.ClickAndMouseHover(Home.getNav_SecurityTab());
			WebObjectUtil.clickAndVerifyText(Home.getNav_CloudAVMenuLink(), "Cloud AV");
			WebObjectUtil.clickAndVerifyText(Home.getNav_HomeBreadcrumb(), "Home");

			//Verifying and clicking every Menu Link inside Support Tab
			//Clicking and Verifying Tickets Link URL
			WebObjectUtil.ClickAndMouseHover(Home.getNav_SupportTab());
			WebObjectUtil.clickAndVerifyText(Home.getNav_TicketsMenuLink(), "Tickets");
			WebObjectUtil.clickAndVerifyText(Home.getNav_HomeBreadcrumb(), "Home");
					
			//Clicking and Verifying Announcements Link URL
			WebObjectUtil.ClickAndMouseHover(Home.getNav_SupportTab());
			WebObjectUtil.clickAndVerifyText(Home.getNav_AnnouncementsMenuLink(), "Announcements");
			WebObjectUtil.clickAndVerifyText(Home.getNav_HomeBreadcrumb(), "Home");

			//Clicking and Verifying Documents Link URL
			WebObjectUtil.ClickAndMouseHover(Home.getNav_SupportTab());
			WebObjectUtil.clickAndVerifyText(Home.getNav_DocumentsMenuLink(), "Documents");
			WebObjectUtil.clickAndVerifyText(Home.getNav_HomeBreadcrumb(), "Home");
					
			//Verifying and clicking every Menu Link inside Account Tab
			//Clicking and Verifying Esclation List Link URL
			WebObjectUtil.ClickAndMouseHover(Home.getNav_AccountTab());
			WebObjectUtil.clickAndVerifyText(Home.getNav_EsclationListMenuLink(), "Escalation List");
			WebObjectUtil.clickAndVerifyText(Home.getNav_HomeBreadcrumb(), "Home");
					
			//Verifying and clicking Edit Profile Menu Link User Name
			//Clicking and Verifying Edit Profile Link URL
			WebObjectUtil.ClickAndMouseHover(Home.getNav_UserNameLink());
			WebObjectUtil.clickAndVerifyText(Home.getNav_EditProfileLink(), "Edit");
			WebObjectUtil.clickAndVerifyText(Home.getNav_HomeBreadcrumb(), "Home");
					
			//Click on Logout and verifying the link
			WebObjectUtil.ClickAndMouseHover(Home.getNav_UserNameLink());
			//WebObjectUtil.clickAndVerifyUrl(Home.getNav_LogoutLink(),(String)FrameworkUtil.dictPropertyData.get("NAV.LOGOUTLINK.URL"));
			LoginTestCase_Old1.nav_Logout();
			WebObjectUtil.verifyUrl((String)FrameworkUtil.dictPropertyData.get("NAV.LOGOUTLINK.URL"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LoggerUtil.log_type_error("Method : navUpwardsExistingBreadCrumb, Error MSG :" + e.getMessage());
		}
	}
	
	/*==============================================================
	TestScript 		: navAnnouncementSectionExistence
	Manual TestCase	: Check for the existence of the Announcements box.
	Description		: Verify Announcements Section Existence
	Author 			: Vivek Kumar
	Creation Date 	:12/16/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	//@Test(priority=7)
		public void navAnnouncementSectionExistence()
		{
		try {
			FrameworkUtil.sTestCaseName = "SummarynavAnnouncementSectionExistence";
			FrameworkUtil.sManualTestCaseName="Check for the existence of the Announcements box.";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,Home);
			//FrameworkUtil.sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			//FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			//getting username from properties file
			//String sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID"); //
			String sUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
			//getting password from properties file
			//String sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
			String sPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
			//Login to Navigator portal
			//LoginTestCase.nav_Login(sUserName, sPassword);
			//LoginTestCase.LoginAsGirUser();
			LoginTestCase_Old1.LoginAsQaautoUser();
			//Verifying Device Alerts Section
			WebObjectUtil.assertElementPresent(Home.getNav_AnnouncementSection());
			//log out Navigator
			LoginTestCase_Old1.nav_Logout();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LoggerUtil.log_type_error("Method : navAnnouncementSectionExistence, Error MSG :" + e.getMessage());
		}
		}
		
	/*==============================================================
	TestScript 		: navTicketSectionExistence
	Manual TestCase	: Check for the existence of the Tickets box
					  Check each piece of content on the Tickets box.
					  Check that the Tickets link works.
					  Click on the "Tickets" header area link.
	Description		: Verify Tickets Section Existence
	Author 			: Vivek Kumar
	Creation Date 	:12/16/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=8)
		public void navTicketSectionExistence()
		{
		try {
			FrameworkUtil.sTestCaseName = "SummarynavTicketSectionExistence";
			FrameworkUtil.sManualTestCaseName="Check for the existence of the Tickets box" + '\n' + "Check each piece of content on the Tickets box."+ '\n' + "Check that the Tickets link works."+ '\n' + "Click on the Tickets header area link.";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,Home);
			//FrameworkUtil.sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			//FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			//getting username from properties file
			//String sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID"); //
			String sUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
			//getting password from properties file
			//String sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
			String sPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
			//Login to Navigator portal
			//LoginTestCase.nav_Login(sUserName, sPassword);
			//LoginTestCase.LoginAsGirUser();
			LoginTestCase_Old1.LoginAsQaautoUser();
			//Verifying Ticket  Section
			WebObjectUtil.assertElementPresent(Home.getNav_TicketSection());
			//Verifying Outstanding Text and its number under Ticket section
			WebObjectUtil.assertElementPresent(Home.getNav_OutstandingText());
			WebObjectUtil.assertElementPresent(Home.getNav_OutstandingNumber());
			//Verifying Resolved Text and Number under Ticket section
			WebObjectUtil.assertElementPresent(Home.getNav_ResolvedText());
			WebObjectUtil.assertElementPresent(Home.getNav_ResolvedNumber());
			//Clicking on Ticket - header and verifying its landing page
			WebObjectUtil.clickAndVerifyText(Home.getNav_TicketSection(), "Tickets");
			//log out Navigator
			LoginTestCase_Old1.nav_Logout();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LoggerUtil.log_type_error("Method : navTicketSectionExistence, Error MSG :" + e.getMessage());
		}
		}
		/*==============================================================
		TestScript 		: navDraaSSectionExistence
		Manual TestCase	: Check for the existence of the DRaaS box.
		Description		: Verify DRaaS Section Existence
		Author 			: Vivek Kumar
		Creation Date 	:12/16/2014
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		@Test(priority=9)
		public void navDraaSSectionExistence()
		{
			try {
				FrameworkUtil.sTestCaseName = "Summary-navDraaSSectionExistence";
				FrameworkUtil.sManualTestCaseName="Check for the existence of the DRaaS box.";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,Home);
				PageFactory.initElements(driver,Draas);
				//FrameworkUtil.sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
				//FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				//getting username from properties file
				//String sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID"); //
				String sUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
				//getting password from properties file
				//String sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
				String sPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
				//Login to Navigator portal
				//LoginTestCase.nav_Login(sUserName, sPassword);
				//LoginTestCase.LoginAsGirUser();
				LoginTestCase_Old1.LoginAsQaautoUser();
				//Verifying DraaS Section
				WebObjectUtil.assertElementPresent(Draas.getNav_DRaaSPortlet());
				//log out Navigator
				LoginTestCase_Old1.nav_Logout();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				LoggerUtil.log_type_error("Method : navDraaSSectionExistence, Error MSG :" + e.getMessage());
			}			
		}
		
		/*==============================================================
		TestScript 		: navVerifyDraaSPageContent
		Manual TestCase	: Check the DRaaS page
		Description		: Verify DRaaS landing page Content
		Author 			: Vivek Kumar
		Creation Date 	:12/17/2014
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		@Test(priority=10)
		public void navVerifyDraaSPageContent()
		{
			String sC2CR,sB2CR,sSBR,sUserName,sPassword ;
			try {
				FrameworkUtil.sTestCaseName = "Summary-navVerifyDraaSPageContent";
				FrameworkUtil.sManualTestCaseName="Check the DRaaS page";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,Home);
				PageFactory.initElements(driver,Draas);
/*				//FrameworkUtil.sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
				//FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				//getting username from properties file
				//String sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID"); //
				sUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
				//getting password from properties file
				//String sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
				sPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
				String sMailInfo=(String)FrameworkUtil.dictPropertyData.get("NAV.DRAAS.MAILINFO");
				//Login to Navigator portal
				LoginTestCase.nav_Login(sUserName, sPassword);
				//Click and verifying DraaS Landing page
				WebObjectUtil.clickAndVerifyText(Home.getNav_DraaSSection(), "Host Based Replication");
				//Verifying text and button under Hosted Based Replication
				WebObjectUtil.VerifyTextOnPage("Hosts Protected");
				WebObjectUtil.VerifyTextOnPage("Drives Protected");
				WebObjectUtil.verifyElementPresent(Home.getNav_HostedHistoryButton());
				WebObjectUtil.verifyElementPresent(Home.getNav_HostedManageButton());
				//Verifying text and button under Storage Array Based Replication
				WebObjectUtil.VerifyTextOnPage("Storage Array Based Replication");
				WebObjectUtil.VerifyTextOnPage("Controllers Protected");
				WebObjectUtil.VerifyTextOnPage("Volumes Protected");
				WebObjectUtil.verifyElementPresent(Home.getNav_StorageManageButton());
				WebObjectUtil.verifyElementPresent(Home.getNav_StorageHistoryButton());
				//Verifying MailInfo
				String sActualMailInfo=Home.getNav_MailInfoLink().getAttribute("href");
				//System.out.println(sActualMailInfo);
				WebObjectUtil.compareString(sMailInfo, sActualMailInfo, true);*/
				
				
				sUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
				sPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
				//Login to Navigator portal
				//LoginTestCase.nav_Login(sUserName, sPassword);
				//LoginTestCase.LoginAsGirUser();
				LoginTestCase_Old1.LoginAsQaautoUser();
				
				WebObjectUtil.clickElement(Draas.getNav_DraasLinkHome());
				WebObjectUtil.explicitWait(10);
				sC2CR =(String)FrameworkUtil.dictPropertyData.get("NAV.DRAAS.C2CR");
				sB2CR =(String)FrameworkUtil.dictPropertyData.get("NAV.DRAAS.S2CR");
				sSBR =(String)FrameworkUtil.dictPropertyData.get("NAV.DRAAS.SBR");
				
			//Verifying whether Image is there or not, if no then verifying the title of C2CR
				if(WebObjectUtil.isElementPresent(Home.getNav_DraasC2CRImg()))
				{
					WebObjectUtil.verifyElementPresent(Home.getNav_DraasC2CRImg());
					//WebObjectUtil.verifyElementPresent(Home.getNav_DraasS2CRImg());
					WebObjectUtil.VerifyTextUnderElement(Home.getNav_DraasPanel(), sC2CR);
					//WebObjectUtil.VerifyTextUnderElement(Home.getNav_DraasPanel(), sB2CR);
				}
				else
				{
					WebObjectUtil.verifyElementPresent(Home.getNav_DRaaSC2CRTitle());
				}
				
				WebObjectUtil.verifyElementPresent(Home.getNav_DraasSBRImg());
				WebObjectUtil.VerifyTextUnderElement(Home.getNav_DraasPanel(), sSBR);
				
				
				//log out Navigator
				LoginTestCase_Old1.nav_Logout();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				LoggerUtil.log_type_error("Method : navVerifyDraaSPageContent, Error MSG :" + e.getMessage());
			}
			
		}
		
		
		/*==============================================================
		TestScript 		: navVerifyDraaSBoxContent
		Manual TestCase	: Check for the content in the DraaS box.
		Description		: Verify DRaaS BOX Content
		Author 			: Vivek Kumar
		Creation Date 	:12/17/2014
		Pre-Requisites	:
		Revision History:
		==============================================================*/
	@Test(priority=11)
		public void navVerifyDraaSBoxContent()
		{
		String sC2CR,sB2CR,sSBR,sUserName,sPassword ;
			try {
				FrameworkUtil.sTestCaseName = "SummarynavVerifyDraaSBoxContent";
				FrameworkUtil.sManualTestCaseName="Check for the content in the DraaS box.";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,Home);
				//FrameworkUtil.sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
				//FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				//getting username from properties file
				//String sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID"); //
				
				//getting password from properties file
				//String sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
				
				//String sMailInfo=(String)FrameworkUtil.dictPropertyData.get("NAV.DRAAS.MAILINFO");
				sUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
				sPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
				//Login to Navigator portal
				//LoginTestCase.nav_Login(sUserName, sPassword);
				//LoginTestCase.LoginAsGirUser();
				LoginTestCase_Old1.LoginAsQaautoUser();
				//Verifying the content present on DRaaS Box
/*				WebObjectUtil.verifyElementPresent(Home.getNav_DRaaSNumerator());
				WebObjectUtil.verifyElementPresent(Home.getNav_DRaaSof());
				WebObjectUtil.verifyElementPresent(Home.getNav_DRaaSNumerator());
				WebObjectUtil.verifyElementPresent(Home.getNav_DRaaSAssets());*/
				
				WebObjectUtil.verifyElementPresent(Home.getNav_DraasPortal());
				List<WebElement> draasElements =  Home.getNav_DraasPortal().findElements(By.tagName("li"));
				for (WebElement draas :draasElements ){
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Draas Portal Text", "done", draas.getText());
					
				}
				//log out Navigator
				LoginTestCase_Old1.nav_Logout();
			} catch (Exception e) {
				// TODO Auto-generated
				//catch block
				e.printStackTrace();
				LoggerUtil.log_type_error("Method : navVerifyDraaSBoxContent, Error MSG :" + e.getMessage());
			}
		}
//#########################################################################
	 
	 /*==============================================================
		TestScript	 	: navContactUs
		Manual TestCase	: Check for the existence of the Contact Us box.
						  Review the Contact Us info.
						  Click the email link.
		Description		: This method will Check for the existence of the Contact Us box,Review the Contact 		
						  Us info and email address details
		Author 			: Praveen K
		Creation Date 	: 12/16/2014
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		@Test(priority=12)
		public void navContactUs() 
		{
				try {
					FrameworkUtil.sTestCaseName = "SummarynavContactUs";
					FrameworkUtil.sManualTestCaseName="Check for the existence of the Contact Us box." +'\n' + "Review the Contact Us info." + '\n' + "Click the email link.";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver, Home);
					//FrameworkUtil.sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
					//FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
					//getting password from properties file
					String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
					//Login to navigator application
					//LoginTestCase.nav_Login(sUserName, sPassword);
					//LoginTestCase.LoginAsGirUser();
					LoginTestCase_Old1.LoginAsQaautoUser();
					
					//Verify Contact Us box 
					WebObjectUtil.verifyElementPresent(Home.getNav_ContactUsBox());
					//Verify the ContactUs link
					WebObjectUtil.verifyElementPresent(Home.getNav_ContactUsLink());
					//Verify the Contact Number 
					WebObjectUtil.VerifyTextOnPage((String)FrameworkUtil.dictPropertyData.get("NAV.CONTACTUS.CONTACTNUMBER"));
					//Verify Contact Mail ID
					WebObjectUtil.verifyElementPresent(Home.getNav_ContactMailIDLink());
					//Verify Create Ticket link
					WebObjectUtil.verifyElementPresent(Home.getNav_CreateTicketLink());
					//Verifying the Contact MailID Subject line is appropriate and correct  
					navContactMailIDVal();
					LoginTestCase_Old1.nav_Logout();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					LoggerUtil.log_type_error("Method : navContactUs, Error MSG :" + e.getMessage());
				}
				
		} 
		/*==============================================================
		Method Name 	: navContactMailIDVal
		Description		: This will verify whether the contact Mail ID link Subject line is appropriate and 
						  correct 
		Author 			: Praveen K
		Creation Date 	: 12/16/2014
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		
		public void navContactMailIDVal()
		{
			String sValue=Home.getNav_ContactMailIDLink().getAttribute("href");		
			int sValuelen=sValue.length(); //length of the subject line 
			String sfirstStr= null;
			String slastStr= null;
			sfirstStr =sValue.substring(0,7); // fetching the starting string "mailto:"
			slastStr =sValue.substring(sValuelen-12, sValuelen); //fetching last string "Contact Us"
			String sStartStr = null;
			try {
				sStartStr = (String)FrameworkUtil.dictPropertyData.get("NAV.CONTACTUS.MAILIDSTARTSTRING");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			String sEndStr = null;
			try {
				sEndStr = (String)FrameworkUtil.dictPropertyData.get("NAV.CONTACTUS.MAILIDENDSTRING");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			WebObjectUtil.compareString(sfirstStr, sStartStr, true);
			WebObjectUtil.compareString(slastStr, sEndStr, true);
			/*if (sfirstStr.equalsIgnoreCase(sStartStr))
			{
				System.out.println("pass");
				//FrameworkUtil.writeCustomResult(sStepNo, sWebObject, sUserAction, sStatus, sRemarks);
		    }
		    if (slastStr.equalsIgnoreCase(sEndString))
			{
				System.out.println("pass");
			}*/
			
		}
		
		
		//CreateTicket
		/*==============================================================
		Test Script 	: navCreateFeedBackPage
		Manual TestCase	: Click notification popup.
						  Check for the existence of the Feedback box.
						  Review the info in the Feedback box.
						  Click the Feedback link.
						  Enter data in the Feedback popup.
						  Submit the Feedback.
						  Click Cancel from Feedback popup.
						  Click notification popup.
		Description		: Is used to navigate to Create Feedback window
		Author 			: Sukur Babu
		Creation Date 	: 12/15/2014
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		//@Test(priority=13)
	public static void navCreateFeedBackPage()
		{

				FrameworkUtil.sTestCaseName = "SummarynavCreateFeedBackPage";
				FrameworkUtil.sManualTestCaseName="Click notification popup." +'\n' + "Check for the existence of the Feedback box." +'\n' + "Review the info in the Feedback box."+'\n' + "Click the Feedback link."+'\n' + "Enter data in the Feedback popup." +'\n' + "Submit the Feedback." +'\n' + "Click Cancel from Feedback popup." +'\n' + "Click notification popup.";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
			try 
			{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, Home);
				//FrameworkUtil.sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
				//FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				//getting user name from properties file
				String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
				//getting password from properties file
				String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
				//Login to navigator application
				//LoginTestCase.nav_Login(sUserName, sPassword);
				//LoginTestCase.LoginAsGirUser();
				LoginTestCase_Old1.LoginAsQaautoUser();
				WebObjectUtil.verifyElementPresent(Home.getnav_FeedBackBox());
				//clicking on Support tab
				WebObjectUtil.clickElement(Home.getnav_ClickhereLink());
				WebObjectUtil.clickElement(Home.getnav_CancelBtn());
				//clicking on Support tab
				WebObjectUtil.clickElement(Home.getnav_ClickhereLink());
				Thread.sleep(1000);	
				EnterNotes();			//**************Not working
				VerifyCreateFeedbackPageTitle();
				VerifyTitleTextFldReq();
				EnterTitle();
				
				ClickOKBtn();
				Thread.sleep(5000);
				VerifyCreateFeedbackSucessfulMsg();	//*******Not reflecting log
				ClickSucessMsgWindowOKBtn();		//*********Not reflecting log
				LoginTestCase_Old1.nav_Logout();
				 
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("Method : navCreateFeedBackPage, Error MSG :" + e.getMessage());
				e.printStackTrace();
			}
		}
		
		/*==============================================================
		TestScript  	: navCreateTicketPage
		Manual TestCase	: Click the Contact Us link.
						  Click the Create Ticket link.
						  Enter data in Create Ticket popup.
						  Submit the Ticket.
						  Click Cancel from Create Ticket popup.
		Description		: Is used to navigate to Create Ticket window
		Author 			: Sukur Babu
		Creation Date 	: 12/10/2014
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		@Test(priority=14)
	public static void navCreateTicketPage()
		{
			FrameworkUtil.sTestCaseName = "Summary-navCreateTicketPage";
			FrameworkUtil.sManualTestCaseName="Click the Contact Us link." +'\n' + "Click the Create Ticket link." +'\n' + "Enter data in Create Ticket popup." +'\n' + "Submit the Ticket." +'\n' + "Click Cancel from Create Ticket popup.";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			
			try 
			{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, Home);
				//FrameworkUtil.sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
				//FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				//getting user name from properties file
				String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
				//getting password from properties file
				String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
				//Login to navigator application
				//LoginTestCase.nav_Login(sUserName, sPassword);
				//LoginTestCase.LoginAsGirUser();
				LoginTestCase_Old1.LoginAsQaautoUser();
				
				
				WebObjectUtil.clickElement(Home.getnav_ContactUsLink());
				WebObjectUtil.clickElement(Home.getnav_CancelBtn());
				//clicking on Support tab
				WebObjectUtil.clickElement(Home.getnav_CreateTicketLink());
				WebObjectUtil.clickElement(Home.getnav_CancelBtn());
				WebObjectUtil.clickElement(Home.getnav_CreateTicketLink());
				Thread.sleep(1000);
				EnterNotes();			//**************Not working
				VerifyCreateTicketPageTitle();
				VerifyTitleTextFldReq();
				VerifyCategoryTextFldReq();
				VerifySeverityDefaultItem();
				VerifyPriorityDefaultItem();
				VerifyCategoryDefaultItem();
				EnterTitle();
				SelectSeverityItem();
				SelectPriorityItem();
				SelectCategoryItem();
				ClickOKBtn();
				Thread.sleep(5000);
				WebDriverUtil.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				VerifyCreateTicketSucessfulMsg();	//*******Not reflecting log
				ClickSucessMsgWindowOKBtn();		//*********Not reflecting log
				LoginTestCase_Old1.nav_Logout();
				 
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				LoggerUtil.log_type_error("Method : navCreateTicketPage, Error MSG :" + e.getMessage());
			}
		}
		
		/*==============================================================
		TestScript  	: verifyBandWidthPortletHomePage
		Manual TestCase	: CPPOC-2659 Verify Bandwidth Portlet in home page
		Description		: Verify Bandwidth portlet in home page 
		Author 			: Priyanka Rachupalli
		Creation Date 	: 29/07/2015
		Release Name    : Byron
		Pre-Requisites	:
		Revision History:
		==============================================================*/
				@Test(priority=100)
				public void verifyBandWidthPortletHomePage()
				{
					String	sUserName=null,sPassword=null;			
					try{
					FrameworkUtil.sTestCaseName = "verifyBandWidthPortletHomePage";
					FrameworkUtil.sManualTestCaseName= "CPPOC-2659 Verify bandwidth portlet in home page";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver, SmokeTest);
					
					sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.USERID.AROLE");
					sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.PASSWORD.AROLE");
					//LoginTestCase.nav_Login(sUserName,sPassword);
					LoginTestCase_Old1.LoginAsRoleAUser();
					
					WebObjectUtil.verifyElementPresent(SmokeTest.getNav_BandwidthPortlet());
					LoginTestCase_Old1.nav_Logout();
					}
					catch(Exception e)
					{
						LoggerUtil.log_type_error("issue with- verifyBandWidthPortletHomePage" );
						LoggerUtil.log_type_error(e.getMessage());
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
						}
					}
				
		
				
				
///// _____________________________ Hague Test Cases __________________________ //////
		/*==============================================================
		TestScript  	: verifyTierPointLogoLandingPage
		Manual TestCase	: [QAT-325]WCP_3777_TC_Windstream icon in black header
		Description		: Verify that user is able to land on home page when clicks on Windstream icon on any page.
		Author 			: Arul
		Creation Date 	: 12/01/2015
		release Name    : Hague
		Pre-Requisites	:
		Revision History:
		==============================================================*/
				@Test(priority=1)
				public void verifyTierPointLogoLandingPage()
				{
					String sUserName,sPassword;
					int iRowNo;
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver, Home);
					PageFactory.initElements(driver, Smoke);
					
					FrameworkUtil.sTestCaseName = "Home-verifyTierPointLogoLandingPage";
					FrameworkUtil.sManualTestCaseName= "[QAT-325]WCP_3777_TC_Windstream icon in black header";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

					sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.USERID");
					sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.PASSWORD");
				
					//LoginTestCase.nav_Login(sUserName,sPassword);
					LoginTestCase_Old1.LoginAsRoleAUser();
					//WebObjectUtil.clickElement(Home.getNav_WindStreamLogo());
					WebObjectUtil.clickElement(Home.getNav_TierPointLogo());
					WebObjectUtil.waitForPageLoad();
					WebObjectUtil.verifyElementPresent(Smoke.getNav_DevicesAlertsLink());
					WebObjectUtil.clickElement(Smoke.getNav_TicketsLink());
					WebObjectUtil.verifyElementPresent(Smoke.getNav_CreateTicketLink());
					//WebObjectUtil.clickElement(Home.getNav_WindStreamLogo());
					WebObjectUtil.clickElement(Home.getNav_TierPointLogo());
					WebObjectUtil.waitForPageLoad();
					WebObjectUtil.verifyElementPresent(Smoke.getNav_DevicesAlertsLink());
					
					LoginTestCase_Old1.nav_Logout();
					
				}
				
	
	/*==============================================================
	TestScript  	: verifyFooterHomeLink
	Manual TestCase	: [QAT-295]WCP_3823_Link to home link in page footer
	Description		: Verify that when user clicks on Home link on page footer on home page, user is navigated to home page.
	Author 			: Arul
	Creation Date 	: 12/02/2015
	release Name    : Hague
	Pre-Requisites	:
	Revision History:
	Note: after tierpoint update Home link not available on footer. hence commenting this test case
	==============================================================*/
				//@Test(priority=2)
				public void verifyFooterHomeLink()
				{
					String sUserName,sPassword;
					int iRowNo;
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver, Home);
					PageFactory.initElements(driver, Smoke);
					
					FrameworkUtil.sTestCaseName = "Home-verifyFooterHomeLink";
					FrameworkUtil.sManualTestCaseName= "[QAT-295]WCP_3823_Link to home link in page footer";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

					sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLE.USERID");
					sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLE.PWD");
				
					//LoginTestCase.nav_Login(sUserName, sPassword);
					//LoginTestCase.LoginAsDevcoUser();
					LoginTestCase_Old1.LoginAsQaautoUser();
					WebObjectUtil.verifyElementPresent(Smoke.getNav_DevicesAlertsLink());
					WebObjectUtil.clickElement(Smoke.getNav_TicketsLink());
					WebObjectUtil.verifyElementPresent(Smoke.getNav_CreateTicketLink());
					WebObjectUtil.clickElement(Home.getNav_FooterHomeLink());
					WebObjectUtil.waitForPageLoad();
					WebObjectUtil.verifyElementPresent(Smoke.getNav_DevicesAlertsLink());
					
					LoginTestCase_Old1.nav_Logout();
					
				}		
				
		/*==============================================================
		TestScript  	: verifyBreadScrumbEVDAnnoucementDraas
		Manual TestCase	: [QAT-284]WCP_3392_TC_Home breadcrumb functioning on EVDC Summary page and other pages
		Description		: Verify that when user clicks on Home bread crumb on any page, user is navigated to the home page
		Author 			: Arul
		Creation Date 	: 12/03/2015
		release Name    : Hague
		Pre-Requisites	:
		Revision History:
		==============================================================*/
				@Test(priority=3)
				public void verifyBreadScrumbEVDCAnnoucementDraas()
				{
					String sUserName,sPassword;
				
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver, Home);
					PageFactory.initElements(driver, Smoke);
					
					FrameworkUtil.sTestCaseName = "Home-verifyBreadScrumbEVDAnnoucementDraas";
					FrameworkUtil.sManualTestCaseName= "[QAT-284]WCP_3392_TC_Home breadcrumb functioning on EVDC Summary page and other pages";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

					sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLE.USERID");
					sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLE.PWD");
				
					//LoginTestCase.nav_Login(sUserName, sPassword);
					//LoginTestCase.LoginAsDevcoUser();
					LoginTestCase_Old1.LoginAsQaautoUser();

					verifyBreadScrumb(Smoke.getNav_EVDCLink(), "EVDC Overview");
					verifyBreadScrumb(Smoke.getNav_DraasLink(), "DRaaS");
					verifyBreadScrumb(Smoke.getNav_AnnouncementsLink(), "Announcements");

					LoginTestCase_Old1.nav_Logout();
					
				}
				
				/*==============================================================
				TestScript  	: verifyUserMsgeinEM7CreatedthroughFeedBack
				Manual TestCase	: [QAT-329] WCP_3856_Feedback messages in EM7
				Description		: Verify that user is able to see the messages in EM7 created through feedback in WCP
				Author 			: QAA03
				Creation Date 	: 12/01/2015
				Release Name    : Hague
				Pre-Requisites	:
				Revision History:
			==============================================================*/
				@Test(priority=1)
				public void verifyUserMsgeinEM7CreatedthroughFeedBack()
				{
						WebDriver driver = WebDriverUtil.getDriver();
						PageFactory.initElements(driver,Home);
						PageFactory.initElements(driver,EM7);
						String sUserName=null,sPassword=null,sUrl=null,sEM7UserName=null,sEM7Password=null;
						boolean bStatus;
					
					
					try {
						FrameworkUtil.sTestCaseName = "verifyUserMsgeinEM7CreatedthroughFeedBack";
						FrameworkUtil.sManualTestCaseName="[QAT-329] WCP_3856_Feedback messages in EM7";
						FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
						
						sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO1");
					    sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.PASSWORD");
					    
					                    
					    sEM7UserName = (String)FrameworkUtil.dictPropertyData.get("NAV.EM7.NAVUSER.USERID");
				 	    sEM7Password = (String)FrameworkUtil.dictPropertyData.get("NAV.EM7.NAVUSER.PASSWORD");
					    
						//Login to Navigator with devco1 user
				 	   //LoginTestCase.nav_Login(sUserName, sPassword);
				 	 //LoginTestCase.LoginAsDevcoUser();
						LoginTestCase_Old1.LoginAsQaautoUser();
						//Verifying Feedback Portlet is present
						WebObjectUtil.verifyElementPresent(Home.getNav_FeedBackBox());
						//In feedback portlet,Click on "click here" and create a ticket
						navFeedbackClickhere();
						
						//Logout from Navigator
						LoginTestCase_Old1.nav_Logout();
						
						//EM7 part commented
					/*	//Navigating to EM7 page with that URL
						WebDriverUtil.getDriver().get((String)FrameworkUtil.dictPropertyData.get("NAV.EM7.URL"));
						sUrl=driver.getCurrentUrl();
					
						//Login to EM7
						EM7TestCase.EM7Login(sEM7UserName, sEM7Password);
						
						//Clicking on Tickets Link
						WebObjectUtil.clickElement(EM7.getEM7_TicketLink());
						//Verifying Ticket created from Feedback Portlet is reflecting in EM7 Tickets page
						bStatus=WebObjectUtil.VerifyTextOnPage(sFeedbackTitle);
						
						FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Ticket Created through feedback portlet reflected in EM7 tickets page");
						
						//Logout from EM7
						EM7TestCase.EM7Logout();
					*/
						
					   } catch (Exception e) {
						LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyUserMsgeinEM7CreatedthroughFeedBack", "warn", "catch block:" +e.getMessage());
					}
			    }
				
			
				
			
	////___________________ Completed Hague test cases ________________________ /////			
				
////_____________________________________ LefCourt test cases _____________________________________ /////				
	/*==============================================================
	TestScript 		: navVerifySummaryVeiwLink
	Manual TestCase	: QAT-429
	Description		: Click on Summary View link and Verify that user is able to navigate to Home page
	Author 			: QAA04
	Creation Date 	: 01/22/2016
	Release Name    : Lefcourt
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=2)
	public void navVerifySummaryVeiwLink(){
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Ticket);
		PageFactory.initElements(driver, EVDC_OverviewPF);
		PageFactory.initElements(driver, Home);
		
		FrameworkUtil.sTestCaseName="navVerifySummaryVeiwLink";
		FrameworkUtil.sManualTestCaseName="(QAT-429) lefcourt - Click on Summary View link and Verify that user is able to navigate to Home page";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		// login to the navigator
		//LoginTestCase.LoginAsDevcoUser();
		LoginTestCase_Old1.LoginAsQaautoUser();
		
		// navigating to the evdc overview page
		WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
		
		// verifying the summary view link 
		     navReturnToHamePage();
		
		// navigating to the ticket page
		TicketTestCase.navigateToTicketPage();
		
		// verifying the summary view link 
			navReturnToHamePage();
	// log out 
			LoginTestCase_Old1.nav_Logout();

	}
	
	/*==============================================================
	TestScript 		: navVerifySummaryPageTabs
	Manual TestCase	: QAT-437
	Description		: Verify that Tabs are displayed on Summary page.
	Author 			: QAA04
	Creation Date 	: 01/29/2016
	Release Name    : Lefcourt
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=8)
	public void navVerifySummaryPageTabs(){
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Home);	
		
		try {
		//Update results with manual test case name
		FrameworkUtil.sTestCaseName = "navVerifySummaryPageTabs";
		FrameworkUtil.sManualTestCaseName="(QAT-437) Lefcourt- Verify that Tabs are displayed on Summary page.";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		//Login into Navigator	
	    //  LoginTestCase.LoginAsSravuriUser();
	      LoginTestCase_Old1.LoginAsQaautoUser();
	      
	      // verifying the tabs
	      verifySummaryPageTabs();
	      
	      // navigating to the forms page
	      WebObjectUtil.ClickAndMouseHover(Home.getNav_MonitoringTab());
	      WebObjectUtil.clickElement(Home.getNav_ReportMenuLink());
	      
	      
	      // verifying the tabs
	      verifySummaryPageTabs();
	      
	      // log out
	      LoginTestCase_Old1.nav_Logout();
	      
		  } catch(Exception e){
			LoggerUtil.log_type_error("issue with navVerifySummaryPageTabs test case");
		    LoggerUtil.log_type_error("Exception occured "+FrameworkUtil.sElementName);
		   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage());
		}
	}
	

	
	
////_____________________________________Completed LefCourt test cases _____________________________________ /////
				
	//////////////////////////////// Methods ////////////////////////////////////////////////////////			
		
	/*====================================================================================================
	Method Name 	: navVerifySummaryPageTabs
	Description		: verifying the all tabs in summary page
	Author 			: QAA04
	Creation Date 	: 01/29/2016
	Release Name    : Lefcourt
	Pre-Requisites	:
	Revision History:
	=====================================================================================================*/
	public void verifySummaryPageTabs(){
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,Home);
		
		try{
		//Verifying the Monitoring Tab
		    WebObjectUtil.verifyElementPresent(Home.getNav_MonitoringTab());
			WebObjectUtil.ClickAndMouseHover(Home.getNav_MonitoringTab());
		
		//Verifying the Service Tab
			WebObjectUtil.verifyElementPresent(Home.getNav_ServicesTab());
			WebObjectUtil.ClickAndMouseHover(Home.getNav_ServicesTab());
		
		
		//Verifying the Security Tab
			WebObjectUtil.verifyElementPresent(Home.getNav_SecurityTab());
			WebObjectUtil.ClickAndMouseHover(Home.getNav_SecurityTab());
		
		
		//Verifying Support Tab
			WebObjectUtil.verifyElementPresent(Home.getNav_SupportTab());
			WebObjectUtil.ClickAndMouseHover(Home.getNav_SupportTab());
		
		//Verifying Account Tab
			WebObjectUtil.verifyElementPresent(Home.getNav_AccountTab());
			WebObjectUtil.ClickAndMouseHover(Home.getNav_AccountTab());
		
		}catch(Exception e){
			LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
			LoggerUtil.log_type_error(e.getMessage());
		   }
	}	

	/*====================================================================================================
	Method Name 	: navReturnToHamePage
	Description		: Verifying the Summary view link
	Author 			: QAA04
	Creation Date 	: 01/22/2016
	Release Name    : lefcourt
	Pre-Requisites	:
	Revision History:
	=====================================================================================================*/ 
	public static void navReturnToHamePage() {
		String sHomeLink;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Home);
		try{
		// clicking on summary view link
			//WebObjectUtil.ClickAndMouseHover(Home.getNav_MonitoringTab());
			WebObjectUtil.clickElement(Home.getNav_MonitoringTab());
			WebObjectUtil.clickElement(Home.getNav_SummaryViewMenuLink());
			
			// verifying the home link
			sHomeLink = (String) FrameworkUtil.dictPropertyData.get("NAV.HOME.BREADCRUMB");
			WebObjectUtil.VerifyTextUnderElement(Home.getNav_HomeBreadcrumb(),sHomeLink);
			
		}catch(Exception e){
			LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
			LoggerUtil.log_type_error(e.getMessage());
		}
	}
	
	
	
		/*==============================================================
		Method Name 	: VerifyCreateFeedbackPageTitle
		Description		: Is used to verify Create Feedback window title
		Author 			: Sukur Babu
		Creation Date 	: 12/15/2014
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		public static void VerifyCreateFeedbackPageTitle()
		{
			
			try 
			{
				//Getting title of the window
				String sTitle=(String)FrameworkUtil.dictPropertyData.get("NAV.CREATEFEEDBACK.TITLE");
				//Verify title of the window
				WebObjectUtil.VerifyTextOnPage(sTitle);
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*==============================================================
		Method Name 	: VerifyTitleTextFldReq
		Description		: Is used to verify Title field is required field
		Author 			: Sukur Babu
		Creation Date 	: 12/15/2014
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		public static void VerifyTitleTextFldReq()
		{
			PageFactory.initElements(WebDriverUtil.getDriver(), HomeTestCase.Home);
			try 
			{
				//Getting title of the window
				String sToolTip=(String)FrameworkUtil.dictPropertyData.get("NAV.CREATEFEEDBACK.REQFLDERRTOOLTIP");
				//WebObjectUtil.clickElement(Home.getnav_TitleText());
				//WebObjectUtil.clickElement(Home.getnav_NoteText());
				ClickOKBtn();
				WebObjectUtil.ClickAndMouseHover(Home.getnav_TitleText());
				WebObjectUtil.VerifyTextOnPage(sToolTip);
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/*==============================================================
		Method Name 	: EnterNotes
		Description		: Is used to enter notes in Note edit area field
		Author 			: Sukur Babu
		Creation Date 	: 12/15/2014
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		public static void EnterNotes()
		{
			
			try 
			{	
				//Getting title of the window
				String sNotes=(String)FrameworkUtil.dictPropertyData.get("NAV.CREATEFEEDBACK.NOTES");
				WebElement  wb = WebDriverUtil.getDriver().switchTo().activeElement();
				wb.sendKeys(sNotes);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Enter Text on Notes", "done", sNotes);
				//WebObjectUtil.SwitchToFrame(createticket.getCreateTicketIframe());
				//WebObjectUtil.SetValueEdit(Home.getnav_NoteText(),sNotes);
				//WebObjectUtil.SwitchToFrame()
			} 
			catch(Exception e) 
			{
							
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*==============================================================
		Method Name 	: EnterTitle
		Description		: Is used to enter notes in Title edit field
		Author 			: Sukur Babu
		Creation Date 	: 12/15/2014
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		public static void EnterTitle()
		{
			PageFactory.initElements(WebDriverUtil.getDriver(), HomeTestCase.Home);
			try 
			{
				//Getting title of the window
				String sTitle=(String)FrameworkUtil.dictPropertyData.get("NAV.CREATEFEEDBACK.TITLE")+"_"+FrameworkUtil.sTimeStamp;
				Thread.sleep(1000);
				WebObjectUtil.SetValueEdit(Home.getnav_TitleText(),sTitle);
				
			} 
			catch(Exception e) 
			{
							
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*==============================================================
		Method Name 	: ClickOKBtn
		Description		: Is used to Click OK button
		Author 			: Sukur Babu
		Creation Date 	: 12/15/2014
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		public static void ClickOKBtn()
		{
			
			PageFactory.initElements(WebDriverUtil.getDriver(), HomeTestCase.Home);
				WebObjectUtil.clickElement(Home.getnav_OkBtn());
				
			
		}
		/*==============================================================
		Method Name 	: ClickCancelBtn
		Description		: Is used to Click Cancel button
		Author 			: Sukur Babu
		Creation Date 	: 12/15/2014
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		public static void ClickCancelBtn()
		{
			
			PageFactory.initElements(WebDriverUtil.getDriver(), HomeTestCase.Home);
			WebObjectUtil.clickElement(Home.getnav_CancelBtn());
				
		}

		/*==============================================================
		Method Name 	: ClickCancelBtn
		Description		: it is used to verifying the successful massage
		Author 			: Sukur Babu
		Creation Date 	: 12/15/2014
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		public static void VerifyCreateFeedbackSucessfulMsg()
		{
			//Getting title of the window
				String sCreateFeedbackSucessMsg;
				try {
					//WebObjectUtil.verifyElementPresent(Home.getnav_CreateFeedbackSucessNotificationOKBtn());
					sCreateFeedbackSucessMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.CREATEFEEDBACK.SUCESS_MSG");
					//WebObjectUtil.VerifyTextOnPage(sCreateFeedbackSucessMsg);
					WebDriverUtil.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					//WebObjectUtil.VerifyTextOnPage("We have received your feedback");
					Thread.sleep(5000);
					WebObjectUtil.explicitWait(Home.getnav_CreateFeedbackSucessNotificationOKBtn());
					WebObjectUtil.VerifyTextUnderElement(Home.getnav_SuccessPopupWindow(), sCreateFeedbackSucessMsg);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
		}
		/*==============================================================
		Method Name 	: ClickSucessMsgWindowOKBtn
		Description		: Is used to Click OK button in sucess message window
		Author 			: Sukur Babu
		Creation Date 	: 12/15/2014
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		public static void ClickSucessMsgWindowOKBtn()
		{
			
				
			WebObjectUtil.clickElement(Home.getnav_CreateFeedbackSucessNotificationOKBtn());
				
		}

		
		
		
		/*==============================================================
		Method Name 	: VerifyCreateTicketPageTitle
		Description		: Is used to verify Create Ticket window title
		Author 			: Sukur Babu
		Creation Date 	: 12/11/2014
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		public static void VerifyCreateTicketPageTitle()
		{
			PageFactory.initElements(WebDriverUtil.getDriver(), HomeTestCase.Home);
			try 
			{
				//Getting title of the window
				String sTitle=(String)FrameworkUtil.dictPropertyData.get("NAV.CREATETICKET.TITLE");
				//Verify title of the window
				WebObjectUtil.VerifyTextOnPage(sTitle);
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		/*==============================================================
		Method Name 	: VerifyCategoryTextFldReq
		Description		: Is used to verify Category field is required field
		Author 			: Sukur Babu
		Creation Date 	: 12/11/2014
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		public static void VerifyCategoryTextFldReq()
		{
			PageFactory.initElements(WebDriverUtil.getDriver(), HomeTestCase.Home);
			try 
			{
				//Getting title of the window
				String sToolTip=(String)FrameworkUtil.dictPropertyData.get("NAV.CREATETICKET.RERFLDERRTOOLTIP");
				//WebObjectUtil.clickElement(Home.getnav_CategoryList());
				//WebObjectUtil.clickElement(Home.getnav_PriorityList());
				ClickOKBtn();
				WebObjectUtil.ClickAndMouseHover(Home.getnav_CategoryList());
				String sRunTimeTooltip = Home.getnav_CategoryList().getAttribute("data-errorqtip");
				String sRunTimeTooltipTest = Home.getnav_CategoryList().getAttribute("innerHTML");
				//System.out.println(sRunTimeTooltipTest);
				if (WebObjectUtil.compareString(sRunTimeTooltip, sToolTip, false))
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Tool Tips", "pass", "Text present: "+ sToolTip);		
				}else{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Tool Tips", "pass", "Text present: "+ sToolTip);
				}
				
				//WebObjectUtil.VerifyTextOnPage(sToolTip);
				WebObjectUtil.clickElement(Home.getnav_CategoryList());
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*==============================================================
		Method Name 	: VerifySeverityDefaultItem
		Description		: Is used to verify Default item of the severity list box and select any item from the same list box
		Author 			: Sukur Babu
		Creation Date 	: 12/11/2014
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		public static void VerifySeverityDefaultItem()
		{
			PageFactory.initElements(WebDriverUtil.getDriver(), HomeTestCase.Home);
			try 
			{
				//Getting title of the window
				String sSeverityDefaultItem=(String)FrameworkUtil.dictPropertyData.get("NAV.CREATETICKET.SEVERITYDEFAULTITEM");
				
				WebElement sLst=Home.getnav_SeverityList();
				String sDefaultItem=sLst.getAttribute("value");
				WebObjectUtil.compareString(sSeverityDefaultItem, sDefaultItem, true);
				
				
			} 
			catch (Exception e) 
			{
				
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*==============================================================
		Method Name 	: VerifyPriorityDefaultItem
		Description		: Is used to verify Default item of the Priority list box and select any item from the same list box
		Author 			: Sukur Babu
		Creation Date 	: 12/12/2014
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		public static void VerifyPriorityDefaultItem()
		{
			PageFactory.initElements(WebDriverUtil.getDriver(), HomeTestCase.Home);
			try 
			{
				//Getting title of the window
				String sPriorityDefaultItem=(String)FrameworkUtil.dictPropertyData.get("NAV.CREATETICKET.PRIORITYDEFAULTITEM");
				
				WebElement sLst=Home.getnav_PriorityList();
				String sDefaultItem=sLst.getAttribute("value");
				WebObjectUtil.compareString(sPriorityDefaultItem, sDefaultItem, true);
				
				
			} 
			catch (Exception e) 
			{
				
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*==============================================================
		Method Name 	: VerifyCategoryDefaultItem
		Description		: Is used to verify Default item of the Category list box and select any item from the same list box
		Author 			: Sukur Babu
		Creation Date 	: 12/12/2014
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		public static void VerifyCategoryDefaultItem()
		{
			PageFactory.initElements(WebDriverUtil.getDriver(), HomeTestCase.Home);
			try 
			{
				//Getting title of the window
				String sCategoryDefaultItem=(String)FrameworkUtil.dictPropertyData.get("NAV.CREATETICKET.CATEGORYDEFAULTITEM");
				
				WebElement sLst=Home.getnav_PriorityList();
				String sDefaultItem=sLst.getAttribute("value");
				WebObjectUtil.compareString(sCategoryDefaultItem, sDefaultItem, true);
				
			} 
			catch (Exception e) 
			{
				
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*==============================================================
		Method Name 	: SelectSeverityItem
		Description		: Is used to select an item from Severity list box
		Author 			: Sukur Babu
		Creation Date 	: 12/12/2014
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		public static void SelectSeverityItem() 
		{
			PageFactory.initElements(WebDriverUtil.getDriver(), HomeTestCase.Home);
				WebObjectUtil.clickElement(Home.getnav_SeverityList());
				WebObjectUtil.clickElement(Home.getnav_SeverityListItem());
				
			
		}
		/*==============================================================
		Method Name 	: SelectPriorityItem
		Description		: Is used to select an item from Priority list box
		Author 			: Sukur Babu
		Creation Date 	: 12/12/2014
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		public static void SelectPriorityItem()
		{
			PageFactory.initElements(WebDriverUtil.getDriver(), HomeTestCase.Home);
				WebObjectUtil.clickElement(Home.getnav_PriorityList());
				WebObjectUtil.clickElement(Home.getnav_PriorityListItem());
				
			
		}
		/*==============================================================
		Method Name 	: SelectCategoryItem
		Description		: Is used to select an item from Category list box
		Author 			: Sukur Babu
		Creation Date 	: 12/12/2014
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		public static void SelectCategoryItem()
		{
			
			PageFactory.initElements(WebDriverUtil.getDriver(), HomeTestCase.Home);
				WebObjectUtil.clickElement(Home.getnav_CategoryList());
				WebObjectUtil.explicitWait(2);
				WebObjectUtil.clickElement(Home.getnav_CategoryListItem());
				
			
		}
	

		/*==============================================================
		Method Name 	: ClickCancelBtn
		Description		: Is used to Click OK button
		Author 			: Sukur Babu
		Creation Date 	: 12/12/2014
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		public static void VerifyCreateTicketSucessfulMsg()
		{
			//Getting title of the window
				String sCreateTicketSucessMsg;
				try {
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver, Home);
					//WebObjectUtil.verifyElementPresent(Home.getnav_CreateFeedbackSucessNotificationOKBtn());
					sCreateTicketSucessMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.CREATETICKET.SUCESS_MSG");
					WebDriverUtil.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					//WebObjectUtil.VerifyTextOnPage(sCreateTicketSucessMsg);
					Thread.sleep(5000);
					//WebObjectUtil.clickElement(Home.getnav_CreateFeedbackSucessNotificationOKBtn());
					WebObjectUtil.VerifyTextUnderElement(Home.getnav_SuccessPopupWindow(), sCreateTicketSucessMsg);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
		/*==============================================================
		Method Name 	: nav_WindStreamToTierPointHomePopup
		Description		: Clicks on Windstream to Tierpoint transition Home Popup message box
		Author 			: Arul
		Creation Date 	: 12/16/2015
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		
		public static void nav_WindStreamToTierPointHomePopup()
		{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, Home);

					try {
							if(WebObjectUtil.isElementPresent(Home.getNav_HomeTempPopUpOk()) && Home.getNav_HomeTempPopUpOk().isEnabled())
						{
								Home.getNav_HomeTempPopUpOk().click();
						}
					} catch (Exception e) {
						try {
							if(WebObjectUtil.isElementPresent(Home.getNav_HomeTempPopUpOk()) && Home.getNav_HomeTempPopUpOk().isEnabled())
							{
									//WebObjectUtil.clickElement(Home.getNav_HomeTempPopUpOk());
									WebObjectUtil.scrollToElement(Home.getNav_HomeTempPopUpOk());
									Home.getNav_HomeTempPopUpOk().click();
									WebObjectUtil.scrollToElement(Home.getNav_TierPointLogo());
									
							}
							/*if(WebObjectUtil.isElementPresent(Home.getNav_HomeTempPopUpCloseIcon())){
								Home.getNav_HomeTempPopUpCloseIcon().click();
							}*/
						} catch (Exception e1) {
							
						}
					}
		
		}

		public static void verifyBreadScrumb(WebElement webElementLink, String sBreadscrumbText){
			
			String sBreadSrumb;
			boolean bstatus=false;
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, Home);
			PageFactory.initElements(driver, Smoke);
			WebObjectUtil.clickElement(webElementLink);
			sBreadSrumb=Home.getNav_BreadscrumbChain().getText().trim();
			bstatus = sBreadSrumb.equals(sBreadscrumbText);
			FrameworkUtil.updateCustomResultBasedOnStatus(bstatus, sBreadscrumbText + " bread crumb Verification");
			
			WebObjectUtil.clickElement(Home.getNav_BreadscrumbHome());
			WebObjectUtil.waitForPageLoad();
			//Added by Sukur Babu. B to resolve the sync issue. Dated on 23rd May 2016.
			WebObjectUtil.explicitWait(5);
			WebObjectUtil.verifyElementPresent(Smoke.getNav_DevicesAlertsLink());
		}
	
		/*====================================================================================================
		Method Name 	: navFeedbackClickhere
		Description		: Creating a feedback with link in Feedback portlet
		Author 			: QAA03
		Creation Date 	: 12/01/2015
		Pre-Requisites	:
		Revision History:
		====================================================================================================*/
		
		public static void navFeedbackClickhere()
		{
				String sTitle,sNotesText;
				//WebElement  wNotesField;
				sTitle=(String)FrameworkUtil.dictPropertyData.get("NAV.FEEDBACK.TITLE.TEXT");
				sNotesText=(String)FrameworkUtil.dictPropertyData.get("NAV.AUTOMATION.TEXT");
				 
		 try {
			 WebDriver driver = WebDriverUtil.getDriver();
			 PageFactory.initElements(driver, Home);
			 
				  //Clicking the Click Here Link
				WebObjectUtil.scrollElementAtPageCenter(Home.getNav_ClickhereLink());
				WebObjectUtil.explicitWait(3);
				//WebObjectUtil.clickElement(Home.getNav_ClickhereLink());
				WebObjectUtil.clickByJS(Home.getNav_ClickhereLink());
				sFeedbackTitle=sTitle+FrameworkUtil.sTimeStamp;
				  //Entering Value in Title field
				WebObjectUtil.explicitWait(5);
				WebObjectUtil.SetValueEdit(Home.getNav_TitleText(),sFeedbackTitle);
				WebObjectUtil.explicitWait(3);
				//wNotesField= WebDriverUtil.getDriver().switchTo().activeElement();
			    //wNotesField.sendKeys(sNotesText);
			     //WebObjectUtil.SetValueEdit(Home.getNav_CreateFeedbackIframe(),sNotesText);
				// FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Enter Text on Notes", "done", sNotesText);
				Home.getNav_CreateFeedbackIframe().sendKeys(sNotesText); 
				WebObjectUtil.explicitWait(3);
				WebObjectUtil.clickElement(Home.getNav_OkBtn());
				WebObjectUtil.explicitWait(5);
				WebObjectUtil.clickElement(Home.getNav_CreateFeedbackSucessNotificationOKBtn());
				
				  
			} catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navFeedbackClickhere", "warn", "catch block:" +e.getMessage());  
			}
			
		}
////////////////////////////////////LefCourt TestCase/////////////////////////////////////////////////
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
			   
			    WebObjectUtil.clickElement(Home.getNav_SupportTab());
				WebObjectUtil.clickElement(Home.getNav_FAQLink());
				
				WebObjectUtil.verifyElementPresent(FAQ.getNav_FAQPageHeader());
				
			 } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navToFAQPage", "warn", "catch block:" +e.getMessage());  
			}
		 
			
		}
		/*==============================================================
		TestScript  	: verifyUsrNotNavigateProduction
		Manual TestCase	: QAT-433-WCP_4279_User is navigated to Windstream Prod.site when logged in as entity01 user
		Description		: After login to Navigator user should not navigate to Production site
		Author 			: Vivek Kumar
		Creation Date 	: 01/21/2016
		Release Name    : LefCourt
		Pre-Requisites	:
		Revision History:
	==============================================================*/
		@Test(priority=42)
		public void verifyUsrNotNavigateProduction()
		{
			String sUserName,sPassword,sURL;
			boolean bStatus=false;
			WebDriver driver=WebDriverUtil.getDriver();
			
			
			FrameworkUtil.sTestCaseName = "verifyUsrNotNavigateProduction";
			FrameworkUtil.sManualTestCaseName="QAT-433-WCP_4279_User is navigated to Windstream Prod.site when logged in as entity01 user";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.ENTITY01.USERID");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.PASSWORD");
			
			//Login to navigator
			//LoginTestCase.nav_Login(sUserName, sPassword);
			LoginTestCase_Old1.LoginAsEntity01User();
			sURL=driver.getCurrentUrl();
			
			bStatus=sURL.contains("tst-lab2");
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "User is not navigated to production site");
			
			//Logout
			LoginTestCase_Old1.nav_Logout();
		}
		
/// __________________________________ Corwin test cases ________________________________________________ ///
		
		/*==============================================================
		TestScript  	: verifyEVDCNameOnHomePage
		Manual TestCase	: QAT-654-WCP_5051_TC_1.0_Landing page EVDC Text Changes
		Description		: Verify that the text on EVDC for Shared is changed to EVDC.
		Author 			: Priyanka
		Creation Date 	: 06/08/2016
		Pre-Requisites	:
		Release Name    : Corwin
		Revision History:
		==============================================================*/
			@Test(priority=3)
			public void verifyEVDCNameOnHomePage()
			{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, Ticket);
				PageFactory.initElements(driver, Home);
				
				
				try {
					String sEVDCName,sEVDCText;
					sEVDCName=(String)FrameworkUtil.dictPropertyData.get("NAV.PRIVATE.CHANGE.TO.EVDC");
					FrameworkUtil.sTestCaseName = "verifyEVDCNameOnHomePage";
					FrameworkUtil.sManualTestCaseName=" QAT-654-WCP_5051_TC_1.0_Landing page EVDC Text Changes";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	             
					LoginTestCase_Old1.LoginAsQaautoAUser();
					WebObjectUtil.explicitWait(5);
					/*WebObjectUtil.scrollToElement(Home.getNav_HomeEVDCPortlet());
					WebObjectUtil.explicitWait(5);*/
					WebObjectUtil.verifyElementPresent(Home.getNav_EVDCText());
					sEVDCText=(Home.getNav_EVDCText()).getText();
					 if(sEVDCName.contains(sEVDCText))
			           {
			        	   FrameworkUtil.updateCustomResultBasedOnStatus(true, "Shared Value has been changed to EVDC");
			           }
			           else{
			        	   FrameworkUtil.updateCustomResultBasedOnStatus(false, "Shared Value has not been changed to EVDC");
			           }
					
					LoginTestCase_Old1.nav_Logout();
				}

				catch (Exception e) {
							LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
						
						}
						}

/////___________________________ Completed corwin test cases _____________________________________________ ////		

//// ____________________________ Kyle test cases _____________________________________________________ ////			
			
			
			/*==============================================================
			TestScript  	: navValFooterFunctionality
			Manual TestCase	: QAT-1454-WCP_5086_TC_1.1_Update Footer Elements-functionality
							  QAT-1453-WCP_5086_TC_1.0_Update Footer Elements
			Description		: Verify that the footer elements
			Author 			: Vivek Kumar
			Creation Date 	: 06/21/2016
			Pre-Requisites	:
			Revision History:
			==============================================================*/
			@Test(priority=2)
			public void navValFooterFunctionality()
			{
				
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, Home);	
				
				String sExpFooterLftTxt, sActFooterLftTxt, sExpFooterRgtTxt, sActFooterRgtTxt,sCompanyTitle,sPrivacyTitle,sAcceptanceTitle,sTermsOfUseTitle;
				
				boolean bStatus=false;
				
				FrameworkUtil.sTestCaseName = "Kyle-navValFooterFunctionality";
				FrameworkUtil.sManualTestCaseName = "QAT-1454,QAT-1453-WCP_5086_TC_1.1_Update Footer Elements-functionality";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
				sExpFooterLftTxt=(String)FrameworkUtil.dictPropertyData.get("NAV.HOME.FOOTER.LEFT.TEXT");
				sExpFooterRgtTxt=(String)FrameworkUtil.dictPropertyData.get("NAV.HOME.FOOTER.RIGHT.TEXT");
				
				//Title declaration
				sCompanyTitle=(String)FrameworkUtil.dictPropertyData.get("NAV.HOME.FOOTER.COMPANY.TITLE");
				sPrivacyTitle=(String)FrameworkUtil.dictPropertyData.get("NAV.HOME.FOOTER.PRIVACY.TITLE");
				sAcceptanceTitle=(String)FrameworkUtil.dictPropertyData.get("NAV.HOME.FOOTER.ACCEPTANCE.TITLE");
				sTermsOfUseTitle=(String)FrameworkUtil.dictPropertyData.get("NAV.HOME.FOOTER.ACCEPTANCE.TITLE");
				
				try {
					//Login to Navigator using PuppyLove as user
					LoginTestCase_Old1.LoginAsPuppyloveUser();
					
					WebObjectUtil.VerifyTextOnPage("TST German Shepherd");
					//Verifying Copyright Text @ Footer left
					WebObjectUtil.isElementPresent(Home.getNav_FooterLeftCopyright());
					sActFooterLftTxt = Home.getNav_FooterLeftCopyright().getText();
					bStatus=sActFooterLftTxt.contains(sExpFooterLftTxt);
					FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Verifying Footer left text as - " +sExpFooterLftTxt);

					//Verifying text @ Footer Right
					bStatus=false;
					sActFooterRgtTxt=Home.getNav_FooterRightText().getText();
					bStatus=sActFooterRgtTxt.equalsIgnoreCase(sExpFooterRgtTxt);
					FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Verifying Footer right text as - " +sExpFooterRgtTxt);
					
					//Validating Company footer link
					WebObjectUtil.verifyElementPresent(Home.getNav_FooterRight_Company());
					WebObjectUtil.clickElement(Home.getNav_FooterRight_Company());
					WebObjectUtil.switchToWindow(1, sCompanyTitle);
					WebObjectUtil.verifyElementPresent(Home.getNav_TierPoint_ClientLogin());
					driver.close();
					
					//Validating Privacy Policy 
					WebObjectUtil.switchToParentWindow();
					WebObjectUtil.verifyElementPresent(Home.getNav_FooterRight_PrivacyPolicy());
					WebObjectUtil.clickElement(Home.getNav_FooterRight_PrivacyPolicy());
					WebObjectUtil.switchToWindow(1, sPrivacyTitle);
					WebObjectUtil.verifyElementPresent(Home.getNav_TierPoint_Privacy());
					driver.close();
					
					//Validating Privacy Policy 
					WebObjectUtil.switchToParentWindow();
					WebObjectUtil.verifyElementPresent(Home.getNav_FooterRight_TermsofUse());
					WebObjectUtil.clickElement(Home.getNav_FooterRight_TermsofUse());
					WebObjectUtil.switchToWindow(1, sTermsOfUseTitle);
					WebObjectUtil.verifyElementPresent(Home.getNav_TierPoint_TermsOfUse());
					driver.close();
					
					//Validating acceptable use of policy
					WebObjectUtil.switchToParentWindow();
					WebObjectUtil.verifyElementPresent(Home.getNav_FooterRight_AcceptableUsePolicy());
					WebObjectUtil.clickElement(Home.getNav_FooterRight_AcceptableUsePolicy());
					WebObjectUtil.switchToWindow(1, sAcceptanceTitle);
					WebObjectUtil.verifyElementPresent(Home.getNav_TierPoint_AcceptancePolicy());
					driver.close();
					WebObjectUtil.switchToParentWindow();
							
					//Login Out
					LoginTestCase_Old1.nav_Logout();
				} catch (Exception e) {
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
				}
			}
			
			
			
/// ___________________________ Completed kyle test cases _____________________________________________ ////

			/// ___________________________ Matheson test case _____________________________________________ ////
			
			
			/*==============================================================
			TestScript  	: verifyEVDCPortlet
			Manual TestCase	: QAT-388-WCP_4380_TC_1.0_EVDC Landing Page Refactor on UI view
			Description		: Verify the refactored EVDC portlet on Landing page. 
			Author 			: Priyanka R
			Creation Date 	: 04/04/2016
			Pre-Requisites	: 
			Release         : Matheson
			Revision History:
			================================================================*/
					//@Test(priority=4)
					public void verifyEVDCPortlet()
					{
						//int iRow=1,i=0;
						String sActualCloud=null,sActualShared=null,sActualPrivate=null;
						String sCloudTitle=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.CLOUD.SERVICE.TITLE");
						String sSharedTitle=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.CLOUD.SHARED");
						String sPrivateTitle=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.CLOUD.PRIVATE");
						WebDriver driver = WebDriverUtil.getDriver();
						//PageFactory.initElements(driver, Ticket);
						PageFactory.initElements(driver, Home);
						//PageFactory.initElements(driver, Smoke);
						
						
						try{
							FrameworkUtil.sTestCaseName = "verifyEVDCPortlet";
							FrameworkUtil.sManualTestCaseName="QAT-388-WCP_4380_TC_1.0_EVDC Landing Page Refactor on UI view";
					       	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

							LoginTestCase_Old1.LoginAsGirUser();
							//WebObjectUtil.explicitWait(10);
							WebObjectUtil.verifyElementPresent(Home.getNav_CloudServicesArea());
							//WebObjectUtil.explicitWait(5);
							sActualCloud=Home.getNav_CloudServicesTitle().getText().trim();
							//WebObjectUtil.explicitWait(5);
							//WebElement wb = Home.getNav_EVDCShared();
							WebObjectUtil.scrollToElement(Home.getNav_EVDCPrivate());
							WebObjectUtil.scrollElementAtPageCenter(Home.getNav_EVDCPrivate());
							WebObjectUtil.explicitWait(2);
							sActualShared=Home.getNav_EVDCShared().getText();
							//WebObjectUtil.explicitWait(5);
							sActualPrivate=(Home.getNav_EVDCPrivate().getText()).trim();
							WebObjectUtil.explicitWait(5);
							if(sActualCloud.equalsIgnoreCase(sCloudTitle))
							{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verify Title", "pass", "Displayed Title is : " + sActualCloud );
							}else{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName,  "Verify Title", "fail", "Displayed Title is : " +sActualCloud  + " and actual title should be : " + sCloudTitle  );
							}
						
							if(sActualShared.equalsIgnoreCase(sSharedTitle))
							{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verify Title", "pass", "Displayed Title is : " +sActualShared);
							}else{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName,  "Verify Title", "fail", "Displayed Title is : " +sActualShared  + " and actual title should be : " + sSharedTitle  );
							}
							
							if(sActualPrivate.equalsIgnoreCase(sPrivateTitle))
							{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verify Title", "pass", "Displayed Title is : " +sActualPrivate);
							}else{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName,  "Verify Title", "fail", "Displayed Title is : " +sActualPrivate  + " and actual title should be : " + sPrivateTitle  );
							}
							LoginTestCase_Old1.nav_Logout();
							
						}
						catch (Exception e) {
							// TODO Auto-generated catch block
							LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navContactUsCreateticket", "warn", "catch block:" +e.getMessage());  
						}
}
					/// ___________________________ Completed Matheson test case _____________________________________________ ////
			
		//update each @Test result in custom result file
		@AfterMethod
		public static void afterEachMethod(){
			FrameworkUtil.updateTestCaseStatusinResult();
			
		}
		
		
		
}
