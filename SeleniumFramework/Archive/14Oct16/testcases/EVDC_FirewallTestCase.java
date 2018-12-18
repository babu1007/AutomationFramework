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
import com.whs.navigator.pagefactory.CommonPageFactory;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.EVDC_VM_PageFactory;
import com.whs.navigator.pagefactory.EntityBrowserPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.TicketPageFactory;
import com.whs.navigator.pagefactory.EVDC_FirewallPageFactory;
import com.whs.navigator.pagefactory.UserPermissionPageFactory;
import com.whs.navigator.testcases.FirewallTestCase_GOM;

public class EVDC_FirewallTestCase {
       
	public static EVDC_FirewallPageFactory Firewall = new EVDC_FirewallPageFactory();
    public static EVDC_OverviewPageFactory EVDC_Overview = new EVDC_OverviewPageFactory();
    public static TicketPageFactory Ticket = new TicketPageFactory();
    public static UserPermissionPageFactory UserPerm = new UserPermissionPageFactory();
    public static EVDC_VM_PageFactory EVDC_VMPF =new EVDC_VM_PageFactory();
    public static EntityBrowserPageFactory EBPANEL = new EntityBrowserPageFactory();
    public static CommonPageFactory Common = new CommonPageFactory();
    public static HomePageFactory_old Home = new HomePageFactory_old();
    
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
	// login as qaauto user --> updated by QAA04 -- 02/24/2016
	  //LoginTestCase.LoginAsQaautoUser();
	 
	  sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.USERID.QAAUTO");
	  sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.PWD.QAAUTO");
	  navLoginAndNavigatetoNATSPage(sUserName,sPassword);
	  WebObjectUtil.explicitWait(10);
	  // Added following wait for fixing. As per latest application. By Sukur Babu. B Dated on 24/06/2016
	  FirewallTestCase_GOM.waitForFeedbackMsgNotdisplayed();
	  
	  //Added by Sukur Babu . B for fixing. After refresh in wait function(above) page will there in Firewall tab. You need to navigate to Nat tab again.
		//Date on 27/06/2016
		WebObjectUtil.clickElement(Firewall.getNav_NATSLink());
		WebObjectUtil.waitForElementPresent(Firewall.getNav_AddNATSLink());
		
		if (Firewall.getNav_AddNATSLink().isDisplayed())
			  FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Add NATs link Displayed");
		  else
			  FrameworkUtil.updateCustomResultBasedOnStatus(false,  "Add NATs link Not Displayed");
		
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
	  
	  LoginTestCase_Old1.nav_Logout();
	  }
		catch(Exception e)
		{
			LoggerUtil.log_type_error("issue with- verifyNATTableDetails Test Case" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
}




//@Test(priority=64)
public void naverifyPDFbuttonUnderNATS() {
	  
	  WebDriver driver = WebDriverUtil.getDriver();
	  PageFactory.initElements(driver, Firewall);
	  PageFactory.initElements(driver, EVDC_Overview);
	  
	  FrameworkUtil.sTestCaseName = "Clark-verifyPDFbuttonUnderNATS";
	  FrameworkUtil.sManualTestCaseName = "verifyPDFbuttonUnderNATS is present or not";
	  FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	  
	//login as qaauto user --> updated by QAA04 -- 02/24/2016
	  LoginTestCase_Old1.LoginAsQaautoUser();
	  
	/*  String sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLE.USERID");
	  String sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLE.PWD");
	  LoginTestCase.nav_Login(sUserName, sPassword);*/
	  
	  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "DEVco1Login", "pass", "Login Sucess");
	  
	  WebObjectUtil.clickElement(EVDC_Overview.getNav_EVDCname());
	  WebObjectUtil.clickElement(EVDC_Overview.getNav_EVDCOverviewFirewall());
	  WebObjectUtil.clickElement(Firewall.getNATsLinkUnderFirewall());
	  WebObjectUtil.verifyElementPresent(Firewall.getPDFButtonUnderNATs());
	  
	  ///// log out ////////
	  LoginTestCase_Old1.nav_Logout();
	  
/*	    WebObjectUtil.ClickAndMouseHover(Clark.getUserLink());
	    WebObjectUtil.clickElement(Clark.getLogout());*/
}

/*==============================================================
TestScript  	: verifyButtonsUnderNetwork
Manual TestCase	: Verify Buttons displayed under NAT rule CPPOC-2807
Description		:Verify Buttos displayed under NAT rule
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

//login as qaauto user --> updated by QAA04 -- 02/24/2016
sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.USERID.QAAUTO");
sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.PWD.QAAUTO");
//LoginTestCase.nav_Login(sUserName, sPassword);
	
//WebObjectUtil.clickElement(Clark.getEVDC());
//WebObjectUtil.clickElement(Clark.getFirewall());
//WebObjectUtil.clickElement(Clark.getNATsLinkUnderFirewall());
navLoginAndNavigatetoNATSPage(sUserName,sPassword);
WebObjectUtil.explicitWait(15);
WebObjectUtil.clickElement(Firewall.getNav_networkExpanderunderNATs());
WebObjectUtil.explicitWait(15);
//WebObjectUtil.verifyElementPresent(Firewall.getNav_refreshButtonUnderNetwork());
WebObjectUtil.verifyElementPresent(Firewall.getNav_EditNATSRuleLink());
WebObjectUtil.verifyElementPresent(Firewall.getNav_deleteButtonUnderNetwork());
LoginTestCase_Old1.nav_Logout();
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
	
//LoginTestCase.nav_Login(sUserName, sPassword);
LoginTestCase_Old1.LoginAsQaautoUser();
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

 LoginTestCase_Old1.nav_Logout();
}
	catch(Exception e)
	{
		LoggerUtil.log_type_error("issue with- navVerifyPagenationUnderNATs Test Case" );
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
	  
	//login as qaauto user --> updated by QAA04 -- 02/24/2016
	  sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.USERID.QAAUTO");
	  sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.PWD.QAAUTO");
	  navLoginAndNavigatetoNATSPage(sUserName,sPassword);
	  
	  //WebObjectUtil.clickElement(pf.getEVDC());
	 // WebObjectUtil.clickElement(pf.getFirewall());
	 // WebObjectUtil.clickElement(pf.getNATsLinkUnderFirewall());
	  WebObjectUtil.explicitWait(10);
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
	  LoginTestCase_Old1.nav_Logout();
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

//LoginTestCase.nav_Login(sUserName,sPassword);
LoginTestCase_Old1.LoginAsQaautoUser();
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
	//login as qaauto user --> updated by QAA04 -- 02/24/2016
	 LoginTestCase_Old1.LoginAsQaautoUser();
	
	/*sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.USERID.RRAMDEV");
	sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.PASSWORD.RRAMDEV");
	LoginTestCase.nav_Login(sUserName, sPassword);*/
	//This line updated on 10/02/2015 for EXTJS5 by QAA03
	//WebObjectUtil.clickElement(UserPerm.getNav_EVDCPortalLink());
	WebObjectUtil.clickElement(EVDC_Overview.getNav_EVDCname());
	WebObjectUtil.waitForElementPresent(UserPerm.getNav_FirewallLink());
	WebObjectUtil.clickElement(UserPerm.getNav_FirewallLink());
//	WebObjectUtil.clickElement(UserPerm.getNav_EVDCPortalLink());
//	WebObjectUtil.waitForElementPresent(UserPerm.getNav_FirewallLink());
//	WebObjectUtil.clickElement(UserPerm.getNav_FirewallLink());
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
	LoginTestCase_Old1.nav_Logout();
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
	PageFactory.initElements(driver, Firewall);
	PageFactory.initElements(driver, EVDC_Overview);
	try {
	
	FrameworkUtil.sTestCaseName ="VerifyFirewallPage";
    FrameworkUtil.sManualTestCaseName ="(QAT-285)Hague-Verifying the Firewall page";
    FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	  // Login with devco user	
   //LoginTestCase.LoginAsDevcoUser();
   LoginTestCase_Old1.LoginAsQaautoUser();
	
	// Navigating to firewall page
	NavigateToFirewallPage();
	// virifying the firewall page(Nats,user access, site to site vpn)
	VerifyFirewallPageTabs();
/// navigating to home page
	navReturnHomePage();
	WebObjectUtil.explicitWait(10);
   /* WebElement wViewlink = WebObjectUtil.getActiveElementasWebElement("//div[@id='nav_org_maindev']//dd[@id='info_firewall1']/a");
	WebObjectUtil.clickElement(wViewlink);*/
   WebObjectUtil.clickElement(Firewall.getNavEVDCPortlet_FirewallVIewLink());
// virifying the firewall page(Nats,user access, site to site vpn)
	VerifyFirewallPageTabs();
	
	LoginTestCase_Old1.nav_Logout();
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
	//LoginTestCase.LoginAsDevcoUser();
	LoginTestCase_Old1.LoginAsQaautoUser();
	
  	WebObjectUtil.clickElement(EVDC_Overview.getNav_EVDCname());
  	WebObjectUtil.explicitWait(5);
  	// verifying the firewall counts in EVDC over view page
	VerifyfirewallPortletCount();
	
	
	LoginTestCase_Old1.nav_Logout();
	}
	catch(Exception e) {
		LoggerUtil.log_type_error("issue with VerifyFirewallPortlet test case");
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception occured", "fail", e.getMessage()+"null");
	}
	}




//__________________________ LefCourt test cases ______________________________________________ //

/*==============================================================
TestScript 		: verifyEVDCSelector
Manual TestCase	: QAT-434
Description		: Verify that EVDC selector has EVDC name in it.
Author 			: QAA04
Creation Date 	: 01/20/2016
Release Name    : Lefcourt
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=3)
public void navVerifyEVDCSelector() {
	
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EVDC_Overview);
	PageFactory.initElements(driver, Firewall);
	PageFactory.initElements(driver, EVDC_VMPF);
	
	FrameworkUtil.sTestCaseName ="verifyEVDCSelector";
	FrameworkUtil.sManualTestCaseName="(QAT-434) lefcourt - Verify that EVDC selector has EVDC name in it.";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	
	// login to the navigator
	//LoginTestCase.LoginAsDevcoUser();
	LoginTestCase_Old1.LoginAsQaautoUser();
	
	WebObjectUtil.clickElement(EVDC_Overview.getNav_EVDCname());
	WebObjectUtil.clickAndVerifyElement(EVDC_Overview.getNav_EVDCOverviewVirtualMachine(), EVDC_VMPF.getNav_VMWebTableParent());
	
	// verifying the evdc selector 
	VerifyEVDCSelectorForDevco();
	
	driver.navigate().back();
	WebObjectUtil.clickAndVerifyElement(EVDC_Overview.getNav_EVDCOverviewFirewall(),Firewall.getNav_NATSLink());


	// verifying the evdc selector 
		VerifyEVDCSelectorForDevco();
		
		// log out 
	LoginTestCase_Old1.nav_Logout();
}

/*==============================================================
TestScript 		: navVerifyEBPanelLinkInFirewallPage
Manual TestCase	: QAT-440
Description		: Firewalls page is displayed and Verify that EB panel is displayed.
Author 			: QAA04
Creation Date 	: 01/25/2016
Release Name    : Lefcourt
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=4)
public void navVerifyEBPanelLinkInFirewallPage(){
	
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, Firewall);
	PageFactory.initElements(driver, EBPANEL);
	try{
	FrameworkUtil.sTestCaseName="navVerifyEBPanelLinkInFirewallPage";
	FrameworkUtil.sManualTestCaseName="(QAT-440) lefcourt - Firewalls page is displayed and Verify that EB panel is displayed.";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	
	// login to the navigator
	//LoginTestCase.LoginAsDevcoUser();
	LoginTestCase_Old1.LoginAsQaautoUser();
	
	// navigating to the firewall page
	EVDC_FirewallTestCase.NavigateToFirewallPage();
	
	// verifying the ebpanel link
	WebObjectUtil.verifyElementPresent(EBPANEL.getNav_EntityBrowserLink());
	WebObjectUtil.clickElement(EBPANEL.getNav_EntityBrowserLink());
	WebObjectUtil.verifyElementPresent(EBPANEL.getNav_firstLevelChildrenEditBox());
	WebObjectUtil.verifyElementPresent(EBPANEL.getNav_OrgNameTitleLink());
	
	// log out 
	LoginTestCase_Old1.nav_Logout();
	}
	catch(Exception e){
		LoggerUtil.log_type_error("issue with navVerifyEBPanelLinkInFirewallPage test case");
	    LoggerUtil.log_type_error("Exception occured "+FrameworkUtil.sElementName);
	   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage());
	}
}



/*==============================================================
TestScript 		: navVerifyCreateEditDeleteImages
Manual TestCase	: QAT-447
Description		: verify that user cannot see any create , edit or delete icons and it is view only.
Author 			: QAA04
Creation Date 	: 01/27/2016
Release Name    : Lefcourt
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=5)
public void navVerifyCreateEditDeleteImages(){
	WebElement wCreateImage,wEditImage,wDeleteImage;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, Firewall);
	try{
	FrameworkUtil.sTestCaseName ="navVerifyCreateEditDeleteImages";
	FrameworkUtil.sManualTestCaseName="(QAT-447) lefcourt - verify that user cannot see any create , edit or delete icons and it is view only.";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	
	// login to the navigator
	LoginTestCase_Old1.LoginAsGirUser();
	//LoginTestCase.LoginAsQaautoUser();
	
	// navigating to the firewall page
	EVDC_FirewallTestCase.NavigateToFirewallPage();
	
	// expanding the first rule
	WebObjectUtil.clickElement(Firewall.getNav_FirstFirewallRuleExpander());
    WebObjectUtil.explicitWait(5);
    WebObjectUtil.verifyElementNOTPresent(Firewall.getNav_AddFireWallLink());
    
    // clicking on gom button
    WebObjectUtil.clickElement(Firewall.getNav_GOMLink());
    // expanding network objects
    WebObjectUtil.clickElement(Firewall.getNav_NetworkObjectExpander());
    
    WebObjectUtil.verifyElementNOTPresent(Firewall.getNav_NetworkExpander());
  // network expander is NOT visible so i commented these below lines 
    /*  
    wCreateImage = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.CREATEIMAGE", "PARAMETER_ROWNUMBER", 1+"");
    WebObjectUtil.verifyElementNOTPresent(wCreateImage);
    
    wEditImage = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.EDITIMAGE", "PARAMETER_ROWNUMBER", 1+"");
    WebObjectUtil.verifyElementNOTPresent(wEditImage);
   
    wDeleteImage = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.DELETEIMAGE", "PARAMETER_ROWNUMBER", 1+"");
    WebObjectUtil.verifyElementNOTPresent(wDeleteImage);
    */
    
    // logout 
    LoginTestCase_Old1.nav_Logout();

	}
catch(Exception e){
	LoggerUtil.log_type_error("issue with navVerifyCreateEditDeleteImages test case");
    LoggerUtil.log_type_error("Exception occured "+FrameworkUtil.sElementName);
   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage());
}
}



/// __________________________ Completed LefCourt test cases________________________________________//


///____________________________ Corwin test cases ______________________________________________ //



/*==============================================================
	TestScript 		: verifyNATEditErrorMsg
	Manual TestCase	: QAT-1252
	Description		: verify edit error message for NATs
	Author 			: QAA04
	Creation Date 	: 06/28/2015
	release Name    : Corwin
	Pre-Requisites	:
	Revision History:
	==============================================================*/
@Test(priority=5)
public void verifyNATEditErrorMsg(){
	WebElement wExpander;
	String sErrorMsg;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, Firewall);
	PageFactory.initElements(driver, Common);
	
	try {
		FrameworkUtil.sTestCaseName="verifyNATEditErrorMsg";
		FrameworkUtil.sManualTestCaseName="(QAT-1252) Corwin - verify edit error message for NATs";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		// login to the navigator
		LoginTestCase_Old1.LoginAsQaautoAUser();
		
		// navigating to the firewall page.
		EVDC_FirewallTestCase.NavigateToFirewallPage();
		
		FirewallTestCase_GOM.waitForFeedbackMsgNotdisplayed();
		
		// clicking on NATs tab.
		WebObjectUtil.clickElement(Firewall.getNav_NATSLink());
		
		wExpander = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FIREWALL.NAT.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
		WebObjectUtil.clickElement(wExpander);
		
		WebObjectUtil.clickElement(Firewall.getNav_EditButtonUnderNetwork());
		
		WebObjectUtil.clickElement(Firewall.getNav_EditNatSaveRuleButton());
		WebObjectUtil.explicitWait(3);
		if(Common.getNav_CommonPopUp().isDisplayed()){
			sErrorMsg = Common.getNav_CommonPopUpMessage().getText();;
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verifying the edit error msg", "pass", "Error msg - "+sErrorMsg);
		WebObjectUtil.clickElement(Common.getNav_PopUpOKBtn());
		WebObjectUtil.explicitWait(5);
		}
		// log out
		LoginTestCase_Old1.nav_Logout();
	} catch (Exception e) {
		LoggerUtil.log_type_error("issue with- verifyNATEditErrorMsg Test Case" );
 		LoggerUtil.log_type_error(e.getMessage());
 		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
 	}
}




/*==============================================================
	TestScript 		: verifyAddNatEditFields
	Manual TestCase	: QAT-1187
	Description		: 
	Author 			: QAA04
	Creation Date 	: 06/29/2015
	release Name    : Corwin
	Pre-Requisites	:
	Revision History:
	==============================================================*/
@Test(priority=7)  
public void verifyAddNatEditFields(){
	WebElement wExpander;
	String sOutSideInterfaceText,sErrorToolTip,sErrorMsg,sTooltipMsg;
	boolean bStatus;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, Firewall);
	PageFactory.initElements(driver, Common);
	
	try {
		FrameworkUtil.sTestCaseName="verifyAddNatEditFields";
		FrameworkUtil.sManualTestCaseName="(QAT-1187) Corwin - verify all edit fields in add nat window";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		// login to the navigator
		LoginTestCase_Old1.LoginAsQaautoAUser();
		
		// navigating to the firewall page.
		EVDC_FirewallTestCase.NavigateToFirewallPage();
		
		FirewallTestCase_GOM.waitForFeedbackMsgNotdisplayed();
		
		// clicking on NATs tab.
		WebObjectUtil.clickElement(Firewall.getNav_NATSLink());
		
		wExpander = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FIREWALL.NAT.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
		WebObjectUtil.clickElement(wExpander);
		
		WebObjectUtil.clickElement(Firewall.getNav_AddNATSLink());
		WebObjectUtil.explicitWait(2);
		
		WebObjectUtil.verifyElementPresent(Firewall.getNav_NatEdit_InsideInterfaceDropDownEditField());
		
		FirewallTestCase_GOM.SelectElementFromDropDown(Firewall.getNav_NatEdit_InsideInterfaceDropDownArrow(), "Global");
		
		WebObjectUtil.verifyElementPresent(Firewall.getNav_NatEdit_OutsideInterfaceEditField());
		sOutSideInterfaceText = Firewall.getNav_NatEdit_OutsideInterfaceEditField().getAttribute("value");
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Outside interface edit filed data", "pass", " - "+sOutSideInterfaceText);
		WebObjectUtil.verifyElementPresent(Firewall.getNav_NatEdit_PrivateIpAddressInputField());
		
		WebObjectUtil.SetValueEdit(Firewall.getNav_NatEdit_PrivateIpAddressInputField(), "1.1.1");
		WebObjectUtil.clickElement(Firewall.getNav_NatEdit_PrivateIpAddressInputField());
		sErrorToolTip = Firewall.getNav_NatEdit_PrivateIpAddressInputField().getAttribute("data-errorqtip");
		sErrorMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.NAT.ADDNATRULE.ERROR.TOOLTIP.MESSAGE");
		bStatus = sErrorToolTip.contains(sErrorMsg);
		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the private ipaddress edit field");
		WebObjectUtil.SetValueEdit(Firewall.getNav_NatEdit_PrivateIpAddressInputField(), "1.1.1.2");
		
		
		WebObjectUtil.SetValueEdit(Firewall.getNav_NatEdit_PublicIpAddressInputField(), "1.2.3");
		WebObjectUtil.clickElement(Firewall.getNav_NatEdit_PublicIpAddressInputField());
		sErrorToolTip = Firewall.getNav_NatEdit_PublicIpAddressInputField().getAttribute("data-errorqtip");
		sErrorMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.NAT.ADDNATRULE.ERROR.TOOLTIP.MESSAGE");
		bStatus = sErrorToolTip.contains(sErrorMsg);
		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the public ipaddress edit field");
		WebObjectUtil.SetValueEdit(Firewall.getNav_NatEdit_PublicIpAddressInputField(), "1.2.3.4");
		
		
		WebObjectUtil.clickElement(Firewall.getNav_NatEdit_InsideInterfaceIcon());;
	    sTooltipMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.NAT.ADDNATRULE.INSIDEINTERFACE.TOOLTIP");
		WebObjectUtil.getToolTipsMsg(Firewall.getNav_NatEdit_InsideInterfaceIcon(), sTooltipMsg);
	    
		WebObjectUtil.clickElement(Firewall.getNav_NatEdit_OutsideInterfaceIcon());;
	    sTooltipMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.NAT.ADDNATRULE.OUTSIDEINTERFACE.TOOLTIP");
		WebObjectUtil.getToolTipsMsg(Firewall.getNav_NatEdit_OutsideInterfaceIcon(), sTooltipMsg);
		
		WebObjectUtil.clickElement(Firewall.getNav_NatEdit_PrivateIpAddressIcon());;
	    sTooltipMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.NAT.ADDNATRULE.PRIVATEIPADDRESS.TOOLTIP");
		WebObjectUtil.getToolTipsMsg(Firewall.getNav_NatEdit_PrivateIpAddressIcon(), sTooltipMsg);
		
		WebObjectUtil.clickElement(Firewall.getNav_NatEdit_PublicIpAddressIcon());;
	    sTooltipMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.NAT.ADDNATRULE.PUBLICIPADDRESS.TOOLTIP");
		WebObjectUtil.getToolTipsMsg(Firewall.getNav_NatEdit_PublicIpAddressIcon(), sTooltipMsg);

	    WebObjectUtil.verifyElementPresent(Firewall.getNav_EditNatSaveRuleButton());
	    WebObjectUtil.verifyElementPresent(Firewall.getNav_EditNatCancelButton());
		
  // log out
		LoginTestCase_Old1.nav_Logout();
	} catch (Exception e) {
		LoggerUtil.log_type_error("issue with- verifyAddNatEditFields Test Case" );
 		LoggerUtil.log_type_error(e.getMessage());
 		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
 	}
	
}







/*==============================================================
	TestScript 		: VerifyCustomerPeerAddressValue
	Manual TestCase	: QAT-1342
	Description		: Verify the Customer Peer Address value
	Author 			: QAA04
	Creation Date 	: 07/01/2015
	release Name    : Corwin
	Pre-Requisites	:
	Revision History:
	==============================================================*/
@Test(priority=10)
public void VerifyCustomerPeerAddressValue(){
	WebElement wExpander,wCustomerAddressValue,wSiteToSiteVPNsRow;
	String sCustomerAddressValue,sSiteToSiteVPNsRow;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, Firewall);
	
	try {
		FrameworkUtil.sTestCaseName="VerifyCustomerPeerAddressValue";
		FrameworkUtil.sManualTestCaseName="(QAT-1342) Corwin - Verify the Customer Peer Address value";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		// login to navigator
		LoginTestCase_Old1.LoginAsAgentUser();
		
		// navigating to the firewall page
		EVDC_FirewallTestCase.NavigateToFirewallPage();
		
		// clicking on site to site vpn tab
		WebObjectUtil.clickElement(Firewall.getNav_SiteToSiteVPNsTab());
		
		wExpander = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.SITETOSITEVPNS.WEBTABLE.ROW.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
		WebObjectUtil.clickElement(wExpander);
		
		wCustomerAddressValue = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.SITETOSITEVPNS.WEBTABLE.CUSTOMERPEERADDERSS.VALUE", "PARAMETER_ROWNUMBER", 1+"");
		sCustomerAddressValue = wCustomerAddressValue.getText();
		
		wSiteToSiteVPNsRow = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.SITETOSITEVPNS.WEBTABLE.ROW.VALUE", "PARAMETER_ROWNUMBER", 1+"");
		sSiteToSiteVPNsRow = wCustomerAddressValue.getText();
				
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verify customer peer address value", "pass", " vlaue - "+sCustomerAddressValue);
		
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "site to site vpn webtable first row data", "pass", " vlaue - "+sSiteToSiteVPNsRow);
		
		// log out
		LoginTestCase_Old1.nav_Logout();
	} catch (Exception e) {
		LoggerUtil.log_type_error("issue with VerifyCustomerPeerAddressValue Test Case" );
 		LoggerUtil.log_type_error(e.getMessage());
 		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
 	}
}
/*
 * since script : verifyDeleteNATFunctionality is covering below script as well. commenting below one.
==============================================================
TestScript  	: verifyNATEdtDelBtnAfterDel
Manual TestCase	: QAT-1328-WCP_4758_TC_1.5_Delete NAT- Add NAT , Edit & Delete buttons are disabled
Description		: Delete NAT- Add NAT , Edit & Delete buttons are disabled
Note			: 
Author 			: Vivek Kumar
Creation Date 	: 06/14/2015
Pre-Requisites	:
Revision History:
==============================================================
@Test(priority=11)
public void verifyNATEdtDelBtnAfterDel()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, Firewall);
	PageFactory.initElements(driver, Common);
	
	FrameworkUtil.sTestCaseName = "verifyNATEdtDelBtnAfterDel";
	FrameworkUtil.sManualTestCaseName="QAT-1328-WCP_4758_TC_1.5_Delete NAT- Add NAT , Edit & Delete buttons are disabled";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	
	String sUserName,sPassword;
	WebElement wNATExpander;
	
	sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.USERID.QAAUTOA");
	sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.PWD.QAAUTOA");
	
	//Step 1- 3
	EVDC_FirewallTestCase.navLoginAndNavigatetoNATSPage(sUserName,sPassword);

	
	//Step - 4 - Expanding the first NAT 
	//Updated by QAA03 on 07/18/2016
	//wNATExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.FIREWALL.NAT.EXPANDER", "","");
	wNATExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.FIREWALL.NAT.EXPANDER", "PARAMETER_ROWNUMBER",""+1);
 	WebObjectUtil.clickElement(wNATExpander);
	
 	//Step - 5 - Deleting the NAT
 	WebObjectUtil.clickElement(Firewall.getNav_deleteButtonUnderNetwork());
 	WebObjectUtil.explicitWait(2);
 	WebObjectUtil.clickElement(Common.getNav_ConfirmPopUpOkBtn());
 	WebObjectUtil.clickElement(Common.getNav_CommonPopUpOKButton());
 	
 	// this below line is added by NMR - 07/11/2016
 	// log out
 	LoginTestCase.nav_Logout();
}

*/

///__________________________ Completed corwin test cases _______________________________________ ///

/// _________________________ matheson test cases __________________________ ///





/// __________________________ Completed matheson test cases__________________ ///

/////////////////////////// Methods /////////////////////////////////////////////////
/*==============================================================
Method Name 	: verifyExpectedTicket
Description		: 
Author 			: QAA04
Creation Date 	: 06/7/2016
Pre-Requisites	:
Release         : out of scope
Revision History:
==============================================================*/
public static void verifyExpectedTicket(String sExpectedSummaryText){
	int iRowCount;
	String sSummary;
	boolean bStatus;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, Ticket);
	
	TicketTestCase.searchTicket("Summary", sExpectedSummaryText);
	CustomWebElementUtil.loadCustomElement(Ticket.getNav_TicketsWebTableParent(), "table");
	iRowCount = CustomWebElementUtil.iRowCount;
	
	for(int i=1; i<=iRowCount; i++){
		sSummary = WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), i, 3);
		bStatus = sSummary.contains(sExpectedSummaryText);
		if(bStatus==true){
		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Expected ticket is dispalying in the ticket page");
	    break;
		}
	}
}
/*====================================================================================================
Method Name 	: VerifyEVDCSelectorForDevco
Description		: Verifying the expected EVDC selector 
Author 			: QAA04
Creation Date 	: 12/29/2016
Release Name    : Lefcourt
Pre-Requisites	:
Revision History:
=====================================================================================================*/
public void VerifyEVDCSelectorForDevco() {
	String sActualSelector,sExpectedSelector;
	boolean bStatus;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EVDC_Overview);
	try{
	// verifying the evdc selector
		sActualSelector=(String)FrameworkUtil.dictPropertyData.get("NAV.QAAUTO.EVDC.NAME");
		
		sExpectedSelector=EVDC_Overview.getNav_EVDCOrgSelector().getText();
		bStatus=sActualSelector.contains(sExpectedSelector);
		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Verifying Org - " + sExpectedSelector + " is diplaying correctly");

	}catch(Exception e){
	LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
	LoggerUtil.log_type_error(e.getMessage());
   }

}


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

/// _________________________ kyle test cases ___________________________________////


/*==============================================================
	TestScript 		: verifyFirewallVPNUsersCount
	Manual TestCase	: QAT-1484
	Description		: Verify the User Access VPNs data is displayed as per the count in evdc overview page.
	Author 			: QAA04
	Creation Date 	: 07/06/2016
	release Name    : Corwin
	Pre-Requisites	:
	Revision History:
	==============================================================*/
@Test(priority=1)
public void verifyFirewallVPNUsersCount(){
	String sVPNUsersCount;
	int iVPNUsersCount,iRowCount;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, Firewall);
	PageFactory.initElements(driver, EVDC_Overview);
	try{
	FrameworkUtil.sTestCaseName="verifyFirewallVPNUsersCount";
	FrameworkUtil.sManualTestCaseName="(QAT-1484) Kyle - Verify the User Access VPNs data is displayed as per the count in evdc overview page.";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	
	// login to the navigator
	LoginTestCase_Old1.LoginAsAgentUser();
	
	WebObjectUtil.clickElement(EVDC_Overview.getNav_EVDCname());
	WebObjectUtil.waitForElementPresent(EVDC_Overview.getNav_EVDCOverviewFirewall());
	
	sVPNUsersCount = EVDC_Overview.getNav_FirewallVPNUsersCount().getText();
	iVPNUsersCount = Integer.parseInt(sVPNUsersCount);
	if(iVPNUsersCount != 0){
		
		WebObjectUtil.clickElement(EVDC_Overview.getNav_EVDCOverviewFirewall());
		WebObjectUtil.waitForElementPresent(Firewall.getNav_UserAccessVPNsTab());
		WebObjectUtil.clickElement(Firewall.getNav_UserAccessVPNsTab());
		
		CustomWebElementUtil.loadCustomElement(Firewall.getNav_UserAccessVPN_WebTableParent(), "table");
		iRowCount = CustomWebElementUtil.iRowCount;
		
		if(iVPNUsersCount == iRowCount){
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying the user access vpns count ", "pass", "User access vpns count is matched -"+iVPNUsersCount);
		}else{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying the user access vpns count ", "fail", "User access vpns count - "+iRowCount+ " is not matched with Firewall portlet User VPNs count -"+iVPNUsersCount);
		}
	
	}else{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying the user access vpns count ", "fail", "The count should not be ZERO - " +iVPNUsersCount);
		
	}
	
	// log out
	LoginTestCase_Old1.nav_Logout();
} catch (Exception e) {
	LoggerUtil.log_type_error("issue with- verifyFirewallVPNUsersCount Test Case" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
}





//___________________________ Completed kyle test cases _______________________________///
//update each @test result in custom result file
	@AfterMethod
	public static void afterEachMethod(){
		FrameworkUtil.updateTestCaseStatusinResult();
		
		//Should be deleted after today's execution by Arul on 7/14/16
		WebDriverUtil.quitWebDriver();

	}
	
}
