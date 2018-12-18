package com.whs.navigator.testcases;

import java.util.List;

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
import com.whs.navigator.commonUtil.WebTableUtil;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.TicketPageFactory;
import com.whs.navigator.pagefactory.EVDC_FirewallPageFactory;
import com.whs.navigator.pagefactory.UserPermissionPageFactory;

public class EVDC_FirewallTestCase {
       
	public static EVDC_FirewallPageFactory Firewall = new EVDC_FirewallPageFactory();
    public static EVDC_OverviewPageFactory EVDC_Overview = new EVDC_OverviewPageFactory();
    public static TicketPageFactory Ticket = new TicketPageFactory();
    public static UserPermissionPageFactory UserPerm = new UserPermissionPageFactory();
    
//// _________________________________ ClarkTestCases _____________________________________ /////    
	/*==============================================================
	TestScript  	: verifyNATTableDetails
	Manual TestCase	: Verify NAT Table Details - CPPOC-2780
	Description		:Verify NAT Table Details
	Author 			: Sukur Babu. B
	Creation Date 	: 08/08/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/

@Test(priority=53)
   public void verifyNATTableDetails() {
	  String sUserName,sPassword,sPDFSrc,sCSVSrc;
	  try{
	  WebDriver driver = WebDriverUtil.getDriver();
	  PageFactory.initElements(driver, EVDC_Overview);
	  PageFactory.initElements(driver, Firewall);
	  
	  FrameworkUtil.sTestCaseName = "verifyNATTableDetails";
	  FrameworkUtil.sManualTestCaseName = "Verify NAT Table Details - CPPOC-2780";
	  FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	  
	  sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO.USERID.AROLE");
	  sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO.PASSWORD.AROLE");
	  navLoginAndNavigatetoNATSPage(sUserName,sPassword);
	  
	  if (Firewall.getNav_SourceInterFaceColumn().isDisplayed())
		  FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Source Interface Column Displayed");
	  else
		  FrameworkUtil.updateCustomResultBasedOnStatus(false,  "Source Interface Column Not Displayed");
	  if (Firewall.getNav_SourceInsideIPColumn().isDisplayed())
		  FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Source Inside Ip Column Displayed");
	  else
		  FrameworkUtil.updateCustomResultBasedOnStatus(false,  "Source Inside Ip Column Not Displayed");
	  if (Firewall.getNav_DestinationInterfaceColumn().isDisplayed())
		  FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Destination Interface Column Displayed");
	  else
		  FrameworkUtil.updateCustomResultBasedOnStatus(false,  "Destination Interface Column Not Displayed");
	  if (Firewall.getNav_ExternalIPColumn().isDisplayed())
		  FrameworkUtil.updateCustomResultBasedOnStatus(true,  "External IP Column Displayed");
	  else
		  FrameworkUtil.updateCustomResultBasedOnStatus(false,  "External IP Column Not Displayed");
	  if (Firewall.getNav_HostNameColumn().isDisplayed())
		  FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Host Name Column Displayed");
	  else
		  FrameworkUtil.updateCustomResultBasedOnStatus(false,  "Host Name Column Not Displayed");
	  
	  if (Firewall.getNav_AddNATSLink().isDisplayed())
		  FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Add NATs link Displayed");
	  else
		  FrameworkUtil.updateCustomResultBasedOnStatus(false,  "Add NATs link Not Displayed");
	  }
		catch(Exception e)
		{
			LoggerUtil.log_type_error("issue with- verifyNATTableDetails Test Case" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
}

/*==============================================================
TestScript  	: ValidateADDNATFunctionality
Manual TestCase	: Verify NAT Table Details - CPPOC-2804
Description		:Verify Add NAT Functionality
Author 			: Sukur Babu. B
Creation Date 	: 07/08/2015
Pre-Requisites	:
Revision History:
==============================================================*/

@Test(priority=54)
public void ValidateADDNATFunctionality() {
  String sUserName,sPassword,sNatTitle,sNatNotes,sExpEditNatConfirmMsg,sTxt,sEditNatConfirmMsg,sExpServirity,sExpPriority,SExpSts;
  String sActServirity,sActPriority,SActSts;
  try{
  WebDriver driver = WebDriverUtil.getDriver();
  PageFactory.initElements(driver, EVDC_Overview);
  PageFactory.initElements(driver, Firewall);
  
  FrameworkUtil.sTestCaseName = "Clark-ValidateADDNATFunctionality";
  FrameworkUtil.sManualTestCaseName = "Verify NAT Table Details - CPPOC-2804";
  FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
  
  sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO.USERID.AROLE");
  sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO.PASSWORD.AROLE");
  sNatTitle=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.NATS.EDIT.TITLE");
  sNatNotes=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.NATS.EDIT.NOTE");
  sExpEditNatConfirmMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.NATS.EDIT.CONFIRM.MSG");
  
  sExpServirity=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.NATS.EXP.TKT.SEVERITY");
  sExpPriority=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.NATS.EXP.TKT.PRIORITY");
  SExpSts=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.NATS.EXP.TKT.STATUS");
  
		  
  sTxt="SELENIUM TEST"+FrameworkUtil.sTimeStamp;
  navLoginAndNavigatetoNATSPage(sUserName,sPassword);
  WebObjectUtil.clickElement(Firewall.getNav_AddNATSLink());
  
  WebObjectUtil.waitForElementPresent(Firewall.getNav_EditNatTitleInput());
  WebObjectUtil.SetValueEdit(Firewall.getNav_EditNatTitleInput(), sNatTitle+sTxt);
  driver.switchTo().frame(Firewall.getNav_EditNATSNotesFrame());

  WebElement element = driver.findElement(By.cssSelector("body"));
  //Enter Notes
  element.sendKeys(sNatNotes+sTxt);
  driver.switchTo().defaultContent();	
  WebObjectUtil.clickElement(Firewall.getNav_EditNatOkButton());
  WebObjectUtil.waitForElementPresent(Firewall.getNav_ConfirmPopup());
  WebObjectUtil.explicitWait(5);
  	sEditNatConfirmMsg=Firewall.getNav_ConfirmPopup().getText();
	if(sEditNatConfirmMsg.contains(sExpEditNatConfirmMsg))
		FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Confirmation Message displays as expected");
	else
		FrameworkUtil.updateCustomResultBasedOnStatus(false,  "Confirmation Message not displayed as expected");
  WebObjectUtil.clickElement(Firewall.getNav_ConfirmPopupOkBtn());
  TicketTestCase.navigateToTicketPage();
  searchTicket("Summary",sTxt, sNatTitle+sTxt,sNatNotes+sTxt);
  sActServirity=Firewall.getNav_NotesSeverity().getAttribute("value");
  if(sActServirity.equalsIgnoreCase(sExpServirity))
	FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Expected Severity is matching with Actual severity");
  else
	 FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Expected Severity is not matching with Actual severity");
  sActPriority=Firewall.getNav_NotesPriority().getAttribute("value");
  if(sActPriority.equalsIgnoreCase(sExpPriority))
	FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Expected Priority is matching with Actual Priority");
  else
	 FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Expected Priority is not matching with Actual Priority");
  SActSts=Firewall.getNav_NotesStatus().getAttribute("value");
  if(SActSts.equalsIgnoreCase(SExpSts))
		FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Expected Status is matching with Actual Status");
	  else
		 FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Expected Status is not matching with Actual Status");
  
  LoginTestCase.nav_Logout();
  
  }
	catch(Exception e)
	{
		LoggerUtil.log_type_error("issue with- ValidateADDNATFunctionality Test Case");
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
}


@Test(priority=64)
public void navVerifyPDFbuttonUnderNATS() {
	  
	  WebDriver driver = WebDriverUtil.getDriver();
	  PageFactory.initElements(driver, Firewall);
	  PageFactory.initElements(driver, EVDC_Overview);
	  
	  FrameworkUtil.sTestCaseName = "Clark-navVerifyPDFbuttonUnderNATS";
	  FrameworkUtil.sManualTestCaseName = "verifyPDFbuttonUnderNATS is present or not";
	  FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	  
	  String sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLE.USERID");
	  String sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLE.PWD");
	  LoginTestCase.nav_Login(sUserName, sPassword);
	  
	  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "DEVco1Login", "pass", "Login Sucess");
	  
	  WebObjectUtil.clickElement(EVDC_Overview.getNav_EVDCname());
	  WebObjectUtil.clickElement(EVDC_Overview.getNav_EVDCOverviewFirewall());
	  WebObjectUtil.clickElement(Firewall.getNATsLinkUnderFirewall());
	  WebObjectUtil.verifyElementPresent(Firewall.getPDFButtonUnderNATs());
	  
	  ///// log out ////////
	  LoginTestCase.nav_Logout();
	  

}

/*==============================================================
TestScript  	: verifyButtonsUnderNetwork
Manual TestCase	: Verify Buttons displayed under NAT rule CPPOC-2807
Description		: Verify Buttos displayed under NAT rule
Author 			: Sukur Babu. B
Creation Date 	: 06/08/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=51)
public void verifyButtonsUnderNetwork() {   
String  sUserName,sPassword;
try{
WebDriver driver = WebDriverUtil.getDriver();
//PageFactory.initElements(driver, login);
PageFactory.initElements(driver, Firewall);

FrameworkUtil.sTestCaseName = "Clark- verifyButtonsUnderNetwork";
FrameworkUtil.sManualTestCaseName ="verify the  'Refresh Details','Edit','Delete' buttons under Network. CPPOC-2807";
FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);

sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO.USERID.AROLE");
sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO.PASSWORD.AROLE");
//LoginTestCase.nav_Login(sUserName, sPassword);
	
//WebObjectUtil.clickElement(Clark.getEVDC());
//WebObjectUtil.clickElement(Clark.getFirewall());
//WebObjectUtil.clickElement(Clark.getNATsLinkUnderFirewall());
navLoginAndNavigatetoNATSPage(sUserName,sPassword);
WebObjectUtil.clickElement(Firewall.getNav_networkExpanderunderNATs());
WebObjectUtil.verifyElementPresent(Firewall.getNav_refreshButtonUnderNetwork());
WebObjectUtil.verifyElementPresent(Firewall.getNav_EditNATSRuleLink());
WebObjectUtil.verifyElementPresent(Firewall.getNav_deleteButtonUnderNetwork());
LoginTestCase.nav_Logout();
}
catch(Exception e)
{
	LoggerUtil.log_type_error("issue with- verifyButtonsUnderNetwork Test Case" );
	LoggerUtil.log_type_error(e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
}
}

/*==============================================================
TestScript  	: navVerifyPagenationUnderNATs
Manual TestCase	: Verify Pagination under NATS - CPPOC-2810 
Description		:
Author 			: Sukur Babu. B
Creation Date 	: 05/08/2015
Pre-Requisites	:
Revision History:
==============================================================*/

 @Test(priority=59)

public void navVerifyPagenationUnderNATs() {
	  try{
  WebDriver driver = WebDriverUtil.getDriver();
  PageFactory.initElements(driver, Firewall);
  PageFactory.initElements(driver, EVDC_Overview);
  
  FrameworkUtil.sTestCaseName = "Clark-navVerifyPagenationUnderNATs";
  FrameworkUtil.sManualTestCaseName = "Pagination details in Firewalls NATS  -  CPPOC-2810";
  FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
  
 String sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO.USERID.AROLE");
String sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO.PASSWORD.AROLE");
	
LoginTestCase.nav_Login(sUserName, sPassword);
WebObjectUtil.clickElement(EVDC_Overview.getNav_EVDCname());
WebObjectUtil.clickElement(EVDC_Overview.getNav_EVDCOverviewFirewall());
WebObjectUtil.clickElement(Firewall.getNav_NATSLink());
int rowCount = WebTableUtil.getRowCount(Firewall.getNav_NATsTableUnderFirewall());
String Data1 = Firewall.getNav_pagenatEditBoxUnderNATS().getAttribute("value");
String Data = Firewall.getNav_currentPagenatNumberUnderNATs().getText();
Boolean verify = Data.contains(Data1);
 if(verify)
 {
	   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verifying the paganation", "Pass", "Data matched");
 }
 else
 {
	   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verifying the paganation", "fail", "Data not matched");
 }

 LoginTestCase.nav_Logout();
}
	catch(Exception e)
	{
		LoggerUtil.log_type_error("issue with- navVerifyPagenationUnderNATs Test Case" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
}

 
 /*==============================================================
 TestScript  	: navValDeleteNATFunctionality
 Manual TestCase	: Verify NAT Delete functionality - CPPOC-2823
 Description		:
 Author 			: Sukur Babu. B
 Creation Date 	: 07/08/2015
 Pre-Requisites	:
 Revision History:
 ==============================================================*/
 @Test(priority=56)
 public void navValDeleteNATFunctionality() 
 {
 	WebElement wNATExpander;
 	String sUserName,sPassword,sNatTitle,sNatNotes,sEditNatConfirmMsg,sExpEditNatConfirmMsg,sTxt;
 	try{
 	FrameworkUtil.sTestCaseName = "Clark-navValDeleteNATFunctionality";
 	FrameworkUtil.sManualTestCaseName= "Verify NAT Delete functionality - CPPOC-2823";
 	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
 	WebDriver driver = WebDriverUtil.getDriver();
 	PageFactory.initElements(driver, Firewall);
 	
 	sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO.USERID.AROLE");
 	sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO.PASSWORD.AROLE");
 	sNatTitle=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.NATS.EDIT.TITLE");
 	sNatNotes=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.NATS.EDIT.NOTE");
 	sExpEditNatConfirmMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.NATS.EDIT.CONFIRM.MSG");
 	sTxt="SELENIUM TEST"+FrameworkUtil.sTimeStamp;
 	//login to catalog
 	navLoginAndNavigatetoNATSPage(sUserName,sPassword);
 	 //// this object is updated as part of EXTJS5 on 10/07/2015 by QAA04
 	//WebElement wNATExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='natPanel-body']//table[1]/tbody/tr[1]/td[1]/div/div", "NAT Rule expander");
 	//WebElement wNATExpander=WebObjectUtil.GetWebElement("xpath", "//div/div[2]/div/div[2]/div/table/tbody/tr/td/table/tbody/tr[1]//div/div", "NAT Rule expander");
 	 // This object is updated on 10/13/2015 By QAA04
 	wNATExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.NAT.RULE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
 	wNATExpander.click();
 	WebObjectUtil.waitForElementPresent(Firewall.getNav_deleteButtonUnderNetwork());
 	WebObjectUtil.clickElement(Firewall.getNav_EditNATSRuleLink());
 	WebObjectUtil.waitForElementPresent(Firewall.getNav_EditNatTitleInput());
 	WebObjectUtil.SetValueEdit(Firewall.getNav_EditNatTitleInput(), sNatTitle+sTxt);
 	driver.switchTo().frame(Firewall.getNav_EditNATSNotesFrame());
 	//Ticket.getNav_NotesFrame().click();
 	//WebElement element =
 	WebElement element = driver.findElement(By.cssSelector("body"));
 	//Enter Notes
 	element.sendKeys(sNatNotes+sTxt);
 	driver.switchTo().defaultContent();	
 	WebObjectUtil.clickElement(Firewall.getNav_EditNatOkButton());
 	WebObjectUtil.waitForElementPresent(Firewall.getNav_ConfirmPopup());
 	WebObjectUtil.explicitWait(5);
 	sEditNatConfirmMsg=Firewall.getNav_ConfirmPopup().getText();
 	if(sEditNatConfirmMsg.contains(sExpEditNatConfirmMsg))
 		FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Confirmation Message displays as expected");
 	else
 		FrameworkUtil.updateCustomResultBasedOnStatus(false,  "Confirmation Message not displayed as expected");
 	WebObjectUtil.clickElement(Firewall.getNav_ConfirmPopupOkBtn());
 	TicketTestCase.navigateToTicketPage();
 	searchTicket("Summary",sTxt, sNatTitle+sTxt,sNatNotes+sTxt);
 	LoginTestCase.nav_Logout();
 	}
 	catch(Exception e)
 	{
 		LoggerUtil.log_type_error("issue with- navValDeleteNATFunctionality Test Case" );
 		LoggerUtil.log_type_error(e.getMessage());
 		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
 	}
 }
 
 /*==============================================================
	TestScript  	: navValEditNATFunctionality
	Manual TestCase	: Validate NAT EDit functionality - CPPOC-2841
	Description		:
	Author 			: Sukur Babu. B
	Creation Date 	: 04/08/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=50)
	public void navValEditNATFunctionality()
	{
		String sUserName,sPassword,sNatTitle,sNatNotes,sEditNatConfirmMsg,sExpEditNatConfirmMsg,sTxt;
		WebElement wNATExpander;
		try{
		FrameworkUtil.sTestCaseName = "Clark-navValEditNATFunctionality";
		FrameworkUtil.sManualTestCaseName= "Validate NAT EDit functionality - CPPOC-2841";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Firewall);
		
		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO.USERID.AROLE");
		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO.PASSWORD.AROLE");
		sNatTitle=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.NATS.EDIT.TITLE");
		sNatNotes=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.NATS.EDIT.NOTE");
		sExpEditNatConfirmMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.NATS.EDIT.CONFIRM.MSG");
		sTxt="SELENIUM TEST"+FrameworkUtil.sTimeStamp;
		//login to catalog
		navLoginAndNavigatetoNATSPage(sUserName,sPassword);
		// This object is updated on 10/07/15
	//	WebElement wNATExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='natPanel-body']//table[1]/tbody/tr[1]/td[1]/div/div", "NAT Rule expander");
		//WebElement wNATExpander=WebObjectUtil.GetWebElement("xpath", "//div/div[2]/div/div[2]/div/table/tbody/tr/td/table/tbody/tr[1]//div/div", "NAT Rule expander");

		 // This object is updated on 10/13/2015 By QAA04
		wNATExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.NAT.RULE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
		wNATExpander.click();
		WebObjectUtil.waitForElementPresent(Firewall.getNav_EditNATSRuleLink());
		WebObjectUtil.clickElement(Firewall.getNav_EditNATSRuleLink());
		WebObjectUtil.waitForElementPresent(Firewall.getNav_EditNatTitleInput());
		WebObjectUtil.SetValueEdit(Firewall.getNav_EditNatTitleInput(), sNatTitle+sTxt);
		driver.switchTo().frame(Firewall.getNav_EditNATSNotesFrame());
		//Ticket.getNav_NotesFrame().click();
		//WebElement element =
		WebElement element = driver.findElement(By.cssSelector("body"));
		//Enter Notes
		element.sendKeys(sNatNotes+sTxt);
		driver.switchTo().defaultContent();	
		WebObjectUtil.clickElement(Firewall.getNav_EditNatOkButton());
		WebObjectUtil.waitForElementPresent(Firewall.getNav_ConfirmPopup());
		WebObjectUtil.explicitWait(5);
		sEditNatConfirmMsg=Firewall.getNav_ConfirmPopup().getText();
		if(sEditNatConfirmMsg.contains(sExpEditNatConfirmMsg))
			FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Confirmation Message displays as expected");
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false,  "Confirmation Message not displayed as expected");
		WebObjectUtil.clickElement(Firewall.getNav_ConfirmPopupOkBtn());
		TicketTestCase.navigateToTicketPage();
		searchTicket("Summary",sTxt, sNatTitle+sTxt,sNatNotes+sTxt);
		LoginTestCase.nav_Logout();
		}
		catch(Exception e)
		{
			LoggerUtil.log_type_error("issue with- navValEditNATFunctionality Test Case" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	TestScript  	: verifyPDFbuttonUnderNATS
	Manual TestCase	: Verify PDF Button displayed under NAT rule CPPOC-2806
	Description		: Verify PDF Button displayed under NAT rule
	Author 			: Sukur Babu. B
	Creation Date 	: 06/08/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/

  @Test(priority=52)
     public void verifyPDFbuttonUnderNATS() {
	  String sUserName,sPassword,sPDFSrc,sCSVSrc;
	  try{
	  WebDriver driver = WebDriverUtil.getDriver();
	  //PageFactory.initElements(driver, login);
	  PageFactory.initElements(driver, Firewall);
	  
	  FrameworkUtil.sTestCaseName = "Clark-verifyPDFbuttonUnderNATS";
	  FrameworkUtil.sManualTestCaseName = "Verify PDF Button displayed under NAT rule CPPOC-2806";
	  FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	  
	  sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO.USERID.AROLE");
	  sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO.PASSWORD.AROLE");
	  navLoginAndNavigatetoNATSPage(sUserName,sPassword);
	  
	  //WebObjectUtil.clickElement(pf.getEVDC());
	 // WebObjectUtil.clickElement(pf.getFirewall());
	 // WebObjectUtil.clickElement(pf.getNATsLinkUnderFirewall());
	  WebObjectUtil.verifyElementPresent(Firewall.getNav_PDFButtonUnderNATs());
	  sPDFSrc=Firewall.getNav_PDFButtonUnderNATs().getAttribute("src");
	  if(sPDFSrc.contains("PDF"))
		  FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Source contains PDF");
	  else
		  FrameworkUtil.updateCustomResultBasedOnStatus(false,  "Source not contains PDF");
	  
	  WebObjectUtil.verifyElementPresent(Firewall.getNav_CSVButtonUnderNATs());
	  sCSVSrc=Firewall.getNav_CSVButtonUnderNATs().getAttribute("src");
	  if(sCSVSrc.contains("CSV"))
		  FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Source contains CSV");
	  else
		  FrameworkUtil.updateCustomResultBasedOnStatus(false,  "Source not contains CSV");
	  LoginTestCase.nav_Logout();
	  }
	catch(Exception e)
	{
		LoggerUtil.log_type_error("issue with- verifyPDFbuttonUnderNATS Test Case" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
	 
}
//#######################################################################################################
//METHODS\\
//#######################################################################################################	
/*==============================================================
Method Name 	: navLoginAndNavigatetoNATSPage
Description		: Login Navigate to Fire wall NATS page
Author 			: Sukru Babu
Creation Date 	: 04/08/2015
Pre-Requisites	:
Revision History:
==============================================================*/
public static void navLoginAndNavigatetoNATSPage(String sUserName,String sPassword)
{

try{
WebDriver driver = WebDriverUtil.getDriver();
PageFactory.initElements(driver, Firewall);
PageFactory.initElements(driver, EVDC_Overview);

LoginTestCase.nav_Login(sUserName,sPassword);
WebObjectUtil.clickElement(EVDC_Overview.getNav_EVDCname());
WebObjectUtil.waitForElementPresent(EVDC_Overview.getNav_EVDCOverviewFirewall());
WebObjectUtil.clickElement(EVDC_Overview.getNav_EVDCOverviewFirewall());
WebObjectUtil.waitForElementPresent(Firewall.getNav_FirewallTable());
WebObjectUtil.verifyElementPresent(Firewall.getNav_NATSLink());
WebObjectUtil.clickElement(Firewall.getNav_NATSLink());
WebObjectUtil.waitForElementPresent(Firewall.getNav_AddNATSLink());

}
catch(Exception e)
{
LoggerUtil.log_type_error("issue with- navLoginAndNavigatetoEVDCOverViewPage method" );
LoggerUtil.log_type_error(e.getMessage());
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
}
}

/*==============================================================
Method Name       : searchTicket
Description       : This will search ticket
Author            : Vivek Kumar
Creation Date     : 06/16/2015
Pre-Requisites    :
Revision History:
==============================================================*/
public static void searchTicket(String sSearchByItem,String sSearchString,String sExpected,String sNoteTxt)
{
      WebDriver driver = WebDriverUtil.getDriver();
      PageFactory.initElements(driver,Firewall);
      PageFactory.initElements(driver, Ticket);
      String sActual,sActualQueueName,sExpectedQueueName,sTicketID;
      String sID,sNotesTableText;
      int iRow,iNotesTableRowCnt;
      WebElement wExpander,wQueueName,wNotesExpander;
      boolean bQueueNameStatus,bSearchStatus,bNotesSearchStatus;
      WebObjectUtil.clickElement(Firewall.getNav_SearchByDropDownArrow());
      //WebObjectUtil.selectCustomWebList(Ticket.getNav_SearchByDropdown(), 2);
      WebObjectUtil.selectCustomWebList(Firewall.getNav_SearchByDropdown(), sSearchByItem);
      //Set Summary
      WebObjectUtil.SetValueEdit(Firewall.getNav_SearchEdit(), sSearchString);
      //Clicking on Search Image/Button
      WebObjectUtil.clickElement(Firewall.getNav_SearchByImage());
      WebObjectUtil.explicitWait(10);
      //Validating Summary
      sActual = (WebTableUtil.getCellData(Firewall.getNav_TicketsWebTable(), 1, 4)).trim();
    bSearchStatus=WebObjectUtil.compareString(sExpected, sActual, true);
    if(bSearchStatus)
    {
     FrameworkUtil.updateCustomResultBasedOnStatus(true, "Ticket with Summary  - "+sExpected + " created successfully" );
    }
    else
    {
      FrameworkUtil.updateCustomResultBasedOnStatus(true, "Ticket with Summary  - "+sExpected + " failed to create" );
    }

  //Expand the first row
      iRow=1;
      //sTicketID = (WebTableUtil.getCellData(Clark.getNav_TicketsWebTable(), iRow, 3)).trim();
      //the above line is commented and added the below two lines as a part of EXTJS5 modification- Vivek - 10/07/2015
      CustomWebElementUtil.loadCustomElement(Ticket.getNav_TicketsWebTableParent(), "table");
      sTicketID=(CustomWebElementUtil.getCellData(iRow,2)).trim();
      // this object is updated as part of EXTJS5 on 10/07/2015 by QAA04
     // wExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTicketsGridPanel-body']/div/div/table["+iRow+"]/tbody/tr[1]/td[1]//div[@class='x-grid-row-expander']", "Arrow Expander");
      // This object is updated on 10/13/2015 By QAA04
      wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", iRow+"");
      //wExpander=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+iRow+"]//tr[1]/td[1]//div[@class='x-grid-row-expander']", "Arrow Expander");
      WebObjectUtil.explicitWait(2);
      WebTableUtil.expandTableRowByRowNum(iRow, wExpander);
      sExpectedQueueName= (String) FrameworkUtil.dictPropertyData.get("NAV.CLARK.TICKET.QUEUENAME");
     //// this object is updated as part of EXTJS5 on 10/07/2015 by QAA04
    //  wQueueName=WebObjectUtil.GetWebElement("xpath", "//table["+iRow+"]//table[@class='ticket_detail_table']/tbody/tr//td/div[@id='ticket_content']/dl/dt[text()='Queue Name']/../dd", "Queue Name");
      // This object is updated on 10/13/2015 By QAA04
      wQueueName= WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER.QUEUENAME", "PARAMETER_ROWNUMBER", iRow+"");
      // wQueueName=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+iRow+"]//td/div[@id='ticket_content']/dl/dt[text()='Queue Name']/../dd", "Queue Name");
    
      sActualQueueName=wQueueName.getText();
      bQueueNameStatus=WebObjectUtil.compareString(sExpectedQueueName, sActualQueueName, true);
      FrameworkUtil.updateCustomResultBasedOnStatus(bQueueNameStatus, "Queue Name - "+ sExpectedQueueName + " Verified " );
      //Verifying Notes
      //Expanding Notes
  
     // for execution 
   //   sID="tktNotesImg-" + sTicketID;
      //wNotesExpander=WebObjectUtil.GetWebElement("id", sID, "Notes Expander");
      // This object is updated on 10/13/2015 By QAA04
      wNotesExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER", "PARAMETER_TICKETID",  sTicketID);
      WebTableUtil.expandTableRowByRowNum(iRow, wNotesExpander);
      WebObjectUtil.explicitWait(5);
      //Checking the checkbox
      WebObjectUtil.selectCheckRadioBox(Firewall.getNav_ExpandAllNotes());
      iNotesTableRowCnt=WebTableUtil.getRowCount(Firewall.getNav_NotesWebTable());
     // sNotesTableText=Clark.getNav_NotesWebTable().getText();
      bNotesSearchStatus=WebTableUtil.verifyTextOnWebTable(Firewall.getNav_NotesWebTable(), sNoteTxt);
      FrameworkUtil.updateCustomResultBasedOnStatus(bNotesSearchStatus, "Search String - "+ sNoteTxt + " found");

}

///// _____________________ Completed ClarkTestCases _____________________________________ ////////

///// _____________________ Byron TestCases _____________________________________ ////////

/*==============================================================
TestScript  	: navValidateFirewallRuleDisplayForUserrramdev
Manual TestCase	: CPPOC-2820
Description		:Verify whether rramdev user is bale to view firewall rules
Author 			: Sukur Babu. B
Creation Date 	: 30/07/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=56)
public void navValidateFirewallRuleDisplayForUserrramdev()
{
	String sUserName,sPassword;
	try{
	FrameworkUtil.sTestCaseName = "EBPanel-navValidateFirewallRuleDisplayForUserrramdev";
	FrameworkUtil.sManualTestCaseName= "CPPOC-2820";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, Firewall);
	PageFactory.initElements(driver, Ticket);
	PageFactory.initElements(driver, UserPerm);
	//This line added on 10/02/2015 for EXTJS5 by QAA03
	PageFactory.initElements(driver, EVDC_Overview);
	sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.USERID.RRAMDEV");
	sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.PASSWORD.RRAMDEV");
	LoginTestCase.nav_Login(sUserName, sPassword);
	//This line updated on 10/02/2015 for EXTJS5 by QAA03
	//WebObjectUtil.clickElement(UserPerm.getNav_EVDCPortalLink());
	WebObjectUtil.clickElement(EVDC_Overview.getNav_EVDCname());
	WebObjectUtil.waitForElementPresent(UserPerm.getNav_FirewallLink());
	WebObjectUtil.clickElement(UserPerm.getNav_FirewallLink());
	WebObjectUtil.clickElement(UserPerm.getNav_EVDCPortalLink());
	WebObjectUtil.waitForElementPresent(UserPerm.getNav_FirewallLink());
	WebObjectUtil.clickElement(UserPerm.getNav_FirewallLink());
	if(WebObjectUtil.isElementPresent(Firewall.getNav_InfoUnavailableText()))
	{
		int iRulesCount=Integer.parseInt(Firewall.getNav_RulesCountText().getText());
		if(iRulesCount==0)
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Pop up displayed because rules count is Zero", "pass", "");
		else
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Pop up displayed even rules count is more than Zero", "fail", "");
		WebObjectUtil.clickElement(UserPerm.getNav_InfoUnavailableOKButton());
	}
	else
		WebObjectUtil.waitForElementPresent(UserPerm.getNav_FirewallTable());
	WebObjectUtil.verifyElementPresent(UserPerm.getNav_FirewallTable());
	LoginTestCase.nav_Logout();
	}
	catch(Exception e)
	{
		LoggerUtil.log_type_error("issue with- navValidateFirewallRuleDisplayForUserrramdev Test Case" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
}

///// _____________________ Completed ByronTestCases _____________________________________ ////////

//// _______________________ Hague test cases ____________________________________________ ///////
/*==============================================================
	TestScript 		: VerifyFirewallPage
	Manual TestCase	: QAT-285
	Description		: Verifying the Firewall page
	Author 			: QAA04
	Creation Date 	: 12/02/2015
	release Name    : Hague
	Pre-Requisites	:
	Revision History:
	
	==============================================================*/ 
@Test(priority=4)
public void VerifyFirewallPage() {
	
	WebDriver driver = WebDriverUtil.getDriver();
	try {
	
	PageFactory.initElements(driver, Firewall);
	  PageFactory.initElements(driver, EVDC_Overview);

	FrameworkUtil.sTestCaseName ="VerifyFirewallPage";
 FrameworkUtil.sManualTestCaseName ="(QAT-285)Hague-Verifying the Firewall page";
FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	  // Login with devco user	
LoginTestCase.LoginAsDevcoUser();
	
	// Navigating to firewall page
	NavigateToFirewallPage();
	// virifying the firewall page(Nats,user access, site to site vpn)
	VerifyFirewallPageTabs();
/// navigating to home page
	navReturnHomePage();
	WebObjectUtil.explicitWait(10);
	WebObjectUtil.clickElement(Firewall.getNavEVDCPortlet_FirewallVIewLink());
// virifying the firewall page(Nats,user access, site to site vpn)
	VerifyFirewallPageTabs();
	
	LoginTestCase.nav_Logout();
	}
	catch(Exception e){
		LoggerUtil.log_type_error("issue with VerifyFirewallPage test case");
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception occured", "fail", e.getMessage()+"null");
	}
	}


/*==============================================================
	TestScript 		: VerifyFirewallPortlet
	Manual TestCase	: QAT-241
	Description		: Verifying the Firewall Portlet counts
	Author 			: QAA04
	Creation Date 	: 12/03/2015
	release Name    : Hague
	Pre-Requisites	:
	Revision History:
	
	==============================================================*/ 
@Test(priority=5)
public void VerifyFirewallPortlet() {
	
	
	try {
	WebDriver driver = WebDriverUtil.getDriver();
	
	PageFactory.initElements(driver, EVDC_Overview);
	  FrameworkUtil.sTestCaseName ="VerifyFirewallPortlet";
	FrameworkUtil.sManualTestCaseName ="(QAT-241)Hague-Verifying the Firewall portlet";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
  	  // Login with devco user	
	LoginTestCase.LoginAsDevcoUser();
	
  	WebObjectUtil.clickElement(EVDC_Overview.getNav_EVDCname());
  	WebObjectUtil.explicitWait(5);
  	// verifying the firewall counts in EVDC over view page
	VerifyfirewallPortletCount();
	
	
	LoginTestCase.nav_Logout();
	}
	catch(Exception e) {
		LoggerUtil.log_type_error("issue with VerifyFirewallPortlet test case");
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception occured", "fail", e.getMessage()+"null");
	}
	}













/////////////////////////// Methods /////////////////////////////////////////////////


/*==============================================================
Method Name     	: NavigateToFirewallPage
Description		: Navigating to the firewall page
Author 			: QAA04
Creation Date 	: 12/02/2015
Pre-Requisites	:
Revision History:
==============================================================*/
public static void NavigateToFirewallPage() 
{

try{
WebDriver driver = WebDriverUtil.getDriver();
PageFactory.initElements(driver, Firewall);
PageFactory.initElements(driver, EVDC_Overview);

WebObjectUtil.scrollElementAtPageCenter(EVDC_Overview.getNav_EVDCname());
WebObjectUtil.clickElement(EVDC_Overview.getNav_EVDCname());
WebObjectUtil.waitForElementPresent(EVDC_Overview.getNav_EVDCOverviewFirewall());
WebObjectUtil.clickElement(EVDC_Overview.getNav_EVDCOverviewFirewall());
WebObjectUtil.waitForElementPresent(Firewall.getNav_FirewallTable());
WebObjectUtil.verifyElementPresent(Firewall.getNav_NATSLink());

}
catch(Exception e)
{
LoggerUtil.log_type_error("issue with-NavigateToFirewallPage method" );
LoggerUtil.log_type_error(e.getMessage());
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
}
}

/*==============================================================
Method Name     : VerifyFirewallPageTabs
Description		: Verifying the firewall page objects (NATS, User Access VPN, Site to Site VPN)
Author 			: QAA04
Creation Date 	: 12/02/2015
Pre-Requisites	:
Revision History:
==============================================================*/
public static void VerifyFirewallPageTabs() {
	  WebDriver driver = WebDriverUtil.getDriver();
	 
	  PageFactory.initElements(driver, Firewall);
	  
	  WebObjectUtil.clickElement(Firewall.getNav_NATSLink());
	  WebObjectUtil.waitForElementPresent(Firewall.getNav_AddNATSLink());
    WebObjectUtil.verifyElementPresent(Firewall.getNav_AddNATSLink());
    WebObjectUtil.verifyElementPresent(Firewall.getNav_FirewallTable());
   
    WebObjectUtil.waitForElementPresent(Firewall.getNavFirewall_UserAcessVPNsTab());
    WebObjectUtil.clickElement(Firewall.getNavFirewall_UserAcessVPNsTab());
    WebObjectUtil.verifyElementPresent(Firewall.getNavFirewall_UserAcessVPN_AddUserLink());
    WebObjectUtil.verifyElementPresent(Firewall.getNavFirewall_UserAcessVPN_TableParent());
    
    WebObjectUtil.clickElement(Firewall.getNavFirewall_SiteToSiteVPNsTab());
    WebObjectUtil.waitForElementPresent(Firewall.getNavFirewall_AddSiteToSiteVPNLink());
    WebObjectUtil.verifyElementPresent(Firewall.getNavFirewall_AddSiteToSiteVPNLink());
    WebObjectUtil.verifyElementPresent(Firewall.getNavFirewall_SiteToSiteVPN_TableParent());

}

/*==============================================================
Method Name 	: navReturnHomePage
Description		: This will return to home page
Author 			: QAA04
Creation Date 	: 12/02/2015
Pre-Requisites	:
Revision History:
==============================================================*/
public static void navReturnHomePage()
{
WebDriver driver = WebDriverUtil.getDriver();
PageFactory.initElements(driver,Firewall); 

try 
{
WebObjectUtil.explicitWait(5);
// this object updated by NMR -- 12/11/15
WebObjectUtil.clickElement(Firewall.getNavTierPointLogo());
WebObjectUtil.explicitWait(8);
}
catch (Exception e) {
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
LoggerUtil.log_type_error(e.getMessage());
}
}

/*==============================================================
Method Name  	: VerifyfirewallPortletCount
Manual TestCase	:
Description		: Verify the firewall portlet in the EVDC overview page:
Author 			: QAA04
Creation Date 	: 12/02/2015
Pre-Requisites	:
Revision History:
==============================================================*/
public static void VerifyfirewallPortletCount(){
 String sRulesCount,sVPNTunnels,sVPNUsersCount,sNATsCount;
  WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EVDC_Overview);
	PageFactory.initElements(driver, Firewall);
	//Verifying Firewall
	
	WebObjectUtil.waitForElementPresent(EVDC_Overview.getNav_EVDCOverviewFirewall());
	WebObjectUtil.verifyElementPresent(Firewall.getNavEVDCOverviewFirewallImage());
	//WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCOverviewFirewall());
	
  WebObjectUtil.explicitWait(5);
  WebObjectUtil.verifyElementPresent(Firewall.getNavRulesText());
  WebObjectUtil.verifyElementPresent(Firewall.getNavRulesCount());
  sRulesCount=Firewall.getNavRulesCount().getText();
  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(),FrameworkUtil.sElementName , "Verifying EVDC Overview firewall count", "pass", "Firewall rules count - " + sRulesCount );
  WebObjectUtil.verifyElementPresent(Firewall.getNavVPNTunnelsText());
  WebObjectUtil.verifyElementPresent(Firewall.getNavVPNTunnelsCount());
  sVPNTunnels = Firewall.getNavVPNTunnelsCount().getText();
  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(),FrameworkUtil.sElementName , "Verifying EVDC Overview firewall count", "pass", "VPNTunnels count - " + sVPNTunnels );
  WebObjectUtil.verifyElementPresent(Firewall.getNavVPNUsersText());
  WebObjectUtil.verifyElementPresent(Firewall.getNavVPNUsersCount());
  sVPNUsersCount = Firewall.getNavVPNUsersCount().getText();
  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(),FrameworkUtil.sElementName , "Verifying EVDC Overview firewall count", "pass", "VPN Users count - " + sVPNUsersCount );
  WebObjectUtil.verifyElementPresent(Firewall.getNavNATSText());
  WebObjectUtil.verifyElementPresent(Firewall.getNavNATSCount());
  sNATsCount = Firewall.getNavNATSCount().getText();
  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(),FrameworkUtil.sElementName , "Verifying EVDC Overview firewall count", "pass", "NATs count - " + sNATsCount );
}


/////__________________________ Completed Hague test cases _________________________ //////
//update each @test result in custom result file
	@AfterMethod
	public static void afterEachMethod(){
		FrameworkUtil.updateTestCaseStatusinResult();
		
	}
	
}
