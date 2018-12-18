package com.whs.navigator.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.CommonPageFactory;
import com.whs.navigator.pagefactory.EVDC_FirewallPageFactory;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.EVDC_VM_PageFactory;
import com.whs.navigator.pagefactory.EntityBrowserPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.TicketPageFactory;
import com.whs.navigator.pagefactory.UserPermissionPageFactory;

public class FirewallTestCase_VPN {

	public static EVDC_FirewallPageFactory Firewall = new EVDC_FirewallPageFactory();
    public static EVDC_OverviewPageFactory EVDC_Overview = new EVDC_OverviewPageFactory();
    public static TicketPageFactory Ticket = new TicketPageFactory();
    public static UserPermissionPageFactory UserPerm = new UserPermissionPageFactory();
    public static EVDC_VM_PageFactory EVDC_VMPF =new EVDC_VM_PageFactory();
    public static EntityBrowserPageFactory EBPANEL = new EntityBrowserPageFactory();
    public static CommonPageFactory Common = new CommonPageFactory();
    public static HomePageFactory_old Home = new HomePageFactory_old();
    
    
    
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
      
      String sUserName,sPassword,sNatTitle,sNatNotes,sNewNotes,sExpEditNatConfirmMsg,sTxt,sEditNatConfirmMsg,sExpServirity,sExpPriority,SExpSts;
      String sActServirity,sActPriority,SActSts;
      try{
    	
      WebDriver driver = WebDriverUtil.getDriver();
      PageFactory.initElements(driver, EVDC_Overview);
      PageFactory.initElements(driver, Firewall);
      
      FrameworkUtil.sTestCaseName = "Clark-ValidateADDNATFunctionality";
      FrameworkUtil.sManualTestCaseName = "Verify NAT Table Details - CPPOC-2804";
      FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
      
      sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.USERID.QAAUTO");
      sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.PWD.QAAUTO");
    /*  sNatTitle=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.NATS.EDIT.TITLE");
      sNatNotes=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.NATS.EDIT.NOTE");
      sExpEditNatConfirmMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.NATS.EDIT.CONFIRM.MSG");
      
      sExpServirity=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.NATS.EXP.TKT.SEVERITY");
      sExpPriority=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.NATS.EXP.TKT.PRIORITY");
      SExpSts=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.NATS.EXP.TKT.STATUS");
      
    		  
      sTxt="SELENIUM TEST"+FrameworkUtil.sTimeStamp;
      sNewNotes=sNatNotes+sTxt;*/
    //login as qaauto user --> updated by QAA04 -- 02/24/2016
    	 // LoginTestCase.LoginAsQaautoUser();
      EVDC_FirewallTestCase.navLoginAndNavigatetoNATSPage(sUserName,sPassword);
      // Added following wait for fixing. As per latest application. By Sukur Babu. B Dated on 24/06/2016
      FirewallTestCase_GOM.waitForFeedbackMsgNotdisplayed();
      WebObjectUtil.clickElement(Firewall.getNav_NATSLink());
      WebObjectUtil.explicitWait(5);
      WebObjectUtil.clickElement(Firewall.getNav_AddNATSLink());
      WebObjectUtil.explicitWait(15);
      
      //WebObjectUtil.waitForElementPresent(Firewall.getNav_EditNatTitleInput());
      /*WebObjectUtil.SetValueEdit(Firewall.getNav_EditNatTitleInput(), sNewNotes);
      WebObjectUtil.explicitWait(3);
      driver.switchTo().frame(Firewall.getNav_EditNATSNotesFrame());

      WebElement element = driver.findElement(By.cssSelector("body"));
      //Enter Notes
      element.sendKeys(sNewNotes);
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
      searchTicket("Summary",sTxt, sNewNotes,sNewNotes);
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
      */
      WebObjectUtil.clickElement(Firewall.getNav_AddNatInsideInterfaceDropdown());
      WebObjectUtil.selectCustomWebList(Firewall.getNav_AddNATBoundList(), 1);
      WebObjectUtil.SetValueEdit(Firewall.getNav_PublicIpAddressEditBox(),"101.12.65.111");  
      WebObjectUtil.SetValueEdit(Firewall.getNav_PrivateIPAddressEditBox(),"102.13.66.112");
      WebObjectUtil.explicitWait(5);
      WebObjectUtil.clickElement(Firewall.getNav_AddNATSaveRuleBtn());
      WebObjectUtil.explicitWait(5);
      WebObjectUtil.clickElement(Firewall.getNav_AddNatPopUpOKBtn());
      WebObjectUtil.explicitWait(5);
    //  FirewallTestCase_GOM.waitForFeedbackMsgNotdisplayed();
      
      LoginTestCase_Old1.nav_Logout();
      
      }
    	catch(Exception e)
    	{
    		LoggerUtil.log_type_error("issue with- ValidateADDNATFunctionality Test Case" );
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
    @Test(priority=55)
    public void navValDeleteNATFunctionality() 
    {
    	WebElement wNATExpander;
    	String sUserName,sPassword,sNatTitle,sNatNotes,sEditNatConfirmMsg,sExpEditNatConfirmMsg,sTxt,sNewNotes;
    	try{
    	FrameworkUtil.sTestCaseName = "Clark-navValDeleteNATFunctionality";
    	FrameworkUtil.sManualTestCaseName= "Verify NAT Delete functionality - CPPOC-2823";
    	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
    	WebDriver driver = WebDriverUtil.getDriver();
    	PageFactory.initElements(driver, Firewall);
    	
    	//login as qaauto user --> updated by QAA04 -- 02/24/2016
    	sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.USERID.QAAUTO");
    	sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.PWD.QAAUTO");
    	sNatTitle=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.NATS.EDIT.TITLE");
    	sNatNotes=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.NATS.EDIT.NOTE");
    	sExpEditNatConfirmMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.NATS.EDIT.CONFIRM.MSG");
    	sTxt="SELENIUM TEST"+FrameworkUtil.sTimeStamp;
    	sNewNotes=sNatNotes+sTxt;
    	 
    	//login to catalog
    	EVDC_FirewallTestCase.navLoginAndNavigatetoNATSPage(sUserName,sPassword);
    // Added following wait for fixing. As per latest application. By Sukur Babu. B Dated on 24/06/2016
    	  FirewallTestCase_GOM.waitForFeedbackMsgNotdisplayed();
    	//Added by Sukur Babu . B for fixing. After refresh in wait function(above) page will there in Firewall tab. You need to navigate to Nat tab again.
   		//Date on 27/06/2016
   		WebObjectUtil.clickElement(Firewall.getNav_NATSLink());
   		WebObjectUtil.waitForElementPresent(Firewall.getNav_AddNATSLink());
    	 //// this object is updated as part of EXTJS5 on 10/07/2015 by QAA04
    	//WebElement wNATExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='natPanel-body']//table[1]/tbody/tr[1]/td[1]/div/div", "NAT Rule expander");
    	//WebElement wNATExpander=WebObjectUtil.GetWebElement("xpath", "//div/div[2]/div/div[2]/div/table/tbody/tr/td/table/tbody/tr[1]//div/div", "NAT Rule expander");
    	 // This object is updated on 10/13/2015 By QAA04
    	wNATExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.NAT.RULE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
    	wNATExpander.click();
   /* 	WebObjectUtil.waitForElementPresent(Firewall.getNav_deleteButtonUnderNetwork());
    	WebObjectUtil.clickElement(Firewall.getNav_EditNATSRuleLink());
    	WebObjectUtil.waitForElementPresent(Firewall.getNav_EditNatTitleInput());
    	WebObjectUtil.SetValueEdit(Firewall.getNav_EditNatTitleInput(), sNatTitle+sTxt);
    	driver.switchTo().frame(Firewall.getNav_EditNATSNotesFrame());
    	//Ticket.getNav_NotesFrame().click();
    	//WebElement element =
    	WebElement element = driver.findElement(By.cssSelector("body"));
    	//Enter Notes
    	element.sendKeys(sNewNotes);
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
    	searchTicket("Summary",sTxt, sNewNotes,sNewNotes);*/
    	WebObjectUtil.explicitWait(15);
    	WebObjectUtil.clickElement(Firewall.getNav_deleteButtonUnderNetwork());
    	WebObjectUtil.clickElement(Firewall.getNav_AddNatPopUpOKBtn());
    	FirewallTestCase_GOM.waitForFeedbackMsgNotdisplayed();
    	LoginTestCase_Old1.nav_Logout();
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
   		String sUserName,sPassword,sNatTitle,sNatNotes,sEditNatConfirmMsg,sExpEditNatConfirmMsg,sTxt,sNewTitle,sFeedBackMsg,sMsg;
   		WebElement wNATExpander;
   		boolean bStatus;
   		try{
   		FrameworkUtil.sTestCaseName = "Clark-navValEditNATFunctionality";
   		FrameworkUtil.sManualTestCaseName= "Validate NAT EDit functionality - CPPOC-2841";
   		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
   		WebDriver driver = WebDriverUtil.getDriver();
   		PageFactory.initElements(driver, Firewall);
   		
   		//login as qaauto user --> updated by QAA04 -- 02/24/2016
   		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.USERID.QAAUTO");
   		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.PWD.QAAUTO");
   		sNatTitle=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.NATS.EDIT.TITLE");
   		sNatNotes=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.NATS.EDIT.NOTE");
   		sExpEditNatConfirmMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.NATS.EDIT.CONFIRM.MSG");
   		sTxt="SELENIUM TEST"+FrameworkUtil.sTimeStamp;
   		sNewTitle=sNatTitle+sTxt;
   		//login to catalog
   		EVDC_FirewallTestCase.navLoginAndNavigatetoNATSPage(sUserName,sPassword);
   		// This object is updated on 10/07/15
   	//	WebElement wNATExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='natPanel-body']//table[1]/tbody/tr[1]/td[1]/div/div", "NAT Rule expander");
   		//WebElement wNATExpander=WebObjectUtil.GetWebElement("xpath", "//div/div[2]/div/div[2]/div/table/tbody/tr/td/table/tbody/tr[1]//div/div", "NAT Rule expander");
   		//Added following wait function for updating as per application. By Sukur Babu. B Dated on 24/
   		FirewallTestCase_GOM.waitForFeedbackMsgNotdisplayed();
   		//Added by Sukur Babu . B for fixing. After refresh in wait function(above) page will there in Firewall tab. You need to navigate to Nat tab again.
   				//Date on 27/06/2016
   		WebObjectUtil.clickElement(Firewall.getNav_NATSLink());
   		WebObjectUtil.waitForElementPresent(Firewall.getNav_AddNATSLink());
   		// This object is updated on 10/13/2015 By QAA04
   		wNATExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.NAT.RULE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
   		wNATExpander.click();
   		WebObjectUtil.waitForElementPresent(Firewall.getNav_EditNATSRuleLink());
   		WebObjectUtil.clickElement(Firewall.getNav_EditNATSRuleLink());
   		/* //WebObjectUtil.waitForElementPresent(Firewall.getNav_EditNatTitleInput());
   		WebObjectUtil.explicitWait(15);
   		WebObjectUtil.SetValueEdit(Firewall.getNav_EditNatTitleInput(),sNewTitle );
   		WebObjectUtil.explicitWait(3);
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
   		searchTicket("Summary",sTxt, sNatTitle+sTxt,sNatNotes+sTxt);*/
   		WebObjectUtil.explicitWait(10);
   		 WebObjectUtil.clickElement(Firewall.getNav_AddNatInsideInterfaceDropdown());
   		  WebObjectUtil.selectCustomWebList(Firewall.getNav_AddNATBoundList(), 1);
   		  WebObjectUtil.SetValueEdit(Firewall.getNav_PublicIpAddressEditBox(),"156.12.65.132");  
   		  WebObjectUtil.SetValueEdit(Firewall.getNav_PrivateIPAddressEditBox(),"178.13.66.156");
   		  WebObjectUtil.explicitWait(5);
   		  WebObjectUtil.clickElement(Firewall.getNav_AddNATSaveRuleBtn());
   		  WebObjectUtil.explicitWait(5);
   		  WebObjectUtil.clickElement(Firewall.getNav_AddNatPopUpOKBtn());
   		//  these below lines are added by NMR - 06/17/2016
   		  WebObjectUtil.explicitWait(15);
   		 // WebObjectUtil.getActiveElementasWebElement()
   		  //WebObjectUtil.clickElement(Common.getNav_CommonPopUpOKButtonwithID());
   		  
   		  WebObjectUtil.clickElement(Common.getNav_CommonPopUpOKButton());
   		  
   		  WebObjectUtil.explicitWait(5);
   		//Added following wait function for updating as per application. By Sukur Babu. B Dated on 24/
   			FirewallTestCase_GOM.waitForFeedbackMsgNotdisplayed();
   		  sMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.NATS.EDIT.CONFIRM.MSG");
   		  
   		  sFeedBackMsg = Common.getNav_UsrFeedBack().getText();
   		  bStatus = sFeedBackMsg.contains(sMsg);
   		  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifying the edit functionality", "pass", ""+sFeedBackMsg);
   		  FirewallTestCase_GOM.waitForFeedbackMsgNotdisplayed();
   		  LoginTestCase_Old1.nav_Logout();
   		}
   		catch(Exception e)
   		{
   			LoggerUtil.log_type_error("issue with- navValEditNATFunctionality Test Case" );
   			LoggerUtil.log_type_error(e.getMessage());
   			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
   		}
   	}
   	
    
   	/*==============================================================
	TestScript 		: navCreateTicketInFirewallPage
	Manual TestCase	: QAT-1477
	Description		: Create a ticket in firewall page and verify that ticket in ticket page.
	Author 			: QAA04
	Creation Date 	: 06/07/2015
	release Name    : Corwin
	Pre-Requisites	:
	Revision History:
	
	==============================================================*/
@Test(priority=1)
public void navCreateTicketInFirewallPage(){
	String sCreateTicket;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, Firewall);
	PageFactory.initElements(driver, Home);
	try{
	FrameworkUtil.sTestCaseName="navCreateTicketInFirewallPage";
	FrameworkUtil.sManualTestCaseName="(QAT-1477) Corwin - Create a ticket on firewall verify that in to ticket page";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	
	// login to the navigator
	LoginTestCase_Old1.LoginAsQaautoUser();
	
	// navigating to the firewall page.
	EVDC_FirewallTestCase.NavigateToFirewallPage();

	FirewallTestCase_GOM.waitForFeedbackMsgNotdisplayed();
	sCreateTicket = (String) FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.CREATE.TICKTE.TITLE");
	WebObjectUtil.clickElement(Firewall.getNav_CreateTicketLink());
	NavigatorCommonMethods.submitDialogForCreateTicket(sCreateTicket);
	driver.navigate().refresh();
	WebObjectUtil.clickElement(Home.getNav_TierPointLogo());
	WebObjectUtil.explicitWait(3);
	
	// navigating to the ticket page.
	TicketTestCase.navigateToTicketPage();
	
   TicketTestCase.searchTicket("Summary", sCreateTicket);
   EVDC_FirewallTestCase.verifyExpectedTicket(sCreateTicket);
   
   // log out
   LoginTestCase_Old1.nav_Logout();
}catch (Exception e) {
	// TODO Auto-generated catch block
    LoggerUtil.log_type_error("Issue With-navCreateTicketInFirewallPage" +  e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
	}
}
    
/*==============================================================
TestScript 		: navCreateTicketInFirewallPage
Manual TestCase	: QAT-1478
Description		: Create a ticket in site to site vpn tab on firewall and verify that in to ticket page
Author 			: QAA04
Creation Date 	: 06/09/2015
release Name    : Corwin
Pre-Requisites	:
Revision History:

==============================================================*/
@Test(priority=2)
public void verifyFirewallTicketInTicketPage(){
String sCreateTicket,sSiteToSiteCreateTicket;
WebDriver driver = WebDriverUtil.getDriver();
PageFactory.initElements(driver, Firewall);
PageFactory.initElements(driver, Home);
try{
FrameworkUtil.sTestCaseName="navCreateTicketInFirewallPage";
FrameworkUtil.sManualTestCaseName="(QAT-1478) Corwin - Create a ticket in site to site vpn tab on firewall and verify that in to ticket page";
FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);

// login to the navigator
//LoginTestCase.LoginAsEntity02User();;
LoginTestCase_Old1.LoginAsQaautoUser();

// navigating to the firewall page.
EVDC_FirewallTestCase.NavigateToFirewallPage();

FirewallTestCase_GOM.waitForFeedbackMsgNotdisplayed();
WebObjectUtil.clickElement(Firewall.getNavFirewall_SiteToSiteVPNsTab());
WebObjectUtil.explicitWait(5);
sCreateTicket = (String) FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.CREATE.TICKTE.TITLE");
sSiteToSiteCreateTicket = "SiteToSiteVPN_"+sCreateTicket;
WebObjectUtil.clickElement(Firewall.getNavFirewall_AddSiteToSiteVPNLink());
NavigatorCommonMethods.submitDialogForCreateTicket(sSiteToSiteCreateTicket);
driver.navigate().refresh();
WebObjectUtil.clickElement(Home.getNav_TierPointLogo());
WebObjectUtil.explicitWait(3);

// navigating to the ticket page.
TicketTestCase.navigateToTicketPage();

TicketTestCase.searchTicket("Summary", sSiteToSiteCreateTicket);
EVDC_FirewallTestCase.verifyExpectedTicket(sCreateTicket);

// log out
LoginTestCase_Old1.nav_Logout();
}catch (Exception e) {
// TODO Auto-generated catch block
LoggerUtil.log_type_error( "Issue With-navCreateTicketInFirewallPage" +  e.getMessage());
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
}
}


/*==============================================================
TestScript 		: verifyDeleteNATFunctionality
Manual TestCase	: QAT-1328,QAT-1326
Description		: verify Edit and Delete buttons are disabled.
Author 			: QAA04
Creation Date 	: 06/24/2015
release Name    : Corwin
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=3)
public void verifyDeleteNATFunctionality(){
WebElement wExpander;
String sSucessMsg,sNATSucessMsg,sFeedBackMsg,sMsg,sDisabled,sFailedDeleteMsg;
boolean bStatus;
WebDriver driver = WebDriverUtil.getDriver();
PageFactory.initElements(driver, Firewall);
PageFactory.initElements(driver, Common);
try {
	FrameworkUtil.sTestCaseName="verifyDeleteNATFunctionality";
	FrameworkUtil.sManualTestCaseName="(QAT-1328)(QAT-1326) Corwin - verify Edit and Delete buttons are disabled.";
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
	
	WebObjectUtil.clickElement(Firewall.getNav_deleteButtonUnderNetwork());
	WebObjectUtil.explicitWait(3);
	WebObjectUtil.clickElement(Common.getNav_ConfirmPopUpOkBtn());
	WebObjectUtil.explicitWait(3);
	WebObjectUtil.clickElement(Common.getNav_CommonPopUpOKButton());
	WebObjectUtil.explicitWait(2);
	sNATSucessMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.NAT.DELETE.SUCESS.MESSAGE");
	sSucessMsg = Common.getNav_UsrFeedBack().getText();
	bStatus = sSucessMsg.contains(sNATSucessMsg);
	FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the sucess message");
	
	driver.navigate().refresh();
	WebObjectUtil.explicitWait(3);
	sFeedBackMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.WAITING.FEEDBACK.MSG");
	sMsg = Common.getNav_UsrFeedBack().getText();
	bStatus = sMsg.contains(sFeedBackMsg);
	FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the feed back message");
	
	WebObjectUtil.clickElement(Firewall.getNav_NATSLink());
	
	WebObjectUtil.verifyElementNOTPresent(Firewall.getNav_AddNATSLink());
	wExpander = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FIREWALL.NAT.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
	WebObjectUtil.clickElement(wExpander);
	
	sDisabled = Firewall.getNav_deleteButtonUnderNetwork().getAttribute("Style");
	bStatus = sDisabled.contains("pointer-events: none");
	FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Delete button is disabled");
	
	sDisabled = Firewall.getNav_EditButtonUnderNetwork().getAttribute("Style");
	bStatus = sDisabled.contains("pointer-events: none");
	FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Edit button is disabled");
	
    FirewallTestCase_GOM.waitForFeedbackMsgNotdisplayed();
    sFailedDeleteMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.NAT.FAILED.DELETE.FEEDBACK.MESSAGE");
    sFeedBackMsg = Common.getNav_UsrFeedBack().getText();
	
	bStatus = sFeedBackMsg.equalsIgnoreCase(sFailedDeleteMsg);
	FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the failed delete msg");
	
	// log out
	LoginTestCase_Old1.nav_Logout();
} catch (Exception e) {
	LoggerUtil.log_type_error("issue with- verifyDeleteNATFunctionality Test Case" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
}


/*==============================================================
TestScript 		: verifyEditNATFunctionality
Manual TestCase	: QAT-1325
Description		: verify Edit and Delete buttons are disabled.
Author 			: QAA04
Creation Date 	: 06/27/2015
release Name    : Corwin
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=4)
public void verifyEditNATFunctionality(){
WebElement wExpander;
String sSucessMsg,sNATSucessMsg,sFeedBackMsg,sMsg,sDisabled,sFailedDeleteMsg;
boolean bStatus;
WebDriver driver = WebDriverUtil.getDriver();
PageFactory.initElements(driver, Firewall);
PageFactory.initElements(driver, Common);
try {
	FrameworkUtil.sTestCaseName="verifyEditNATFunctionality";
	FrameworkUtil.sManualTestCaseName="(QAT-1325) Corwin - verify edit failed feed back message for NATs";
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
	WebObjectUtil.explicitWait(3);
	WebObjectUtil.SetValueEdit(Firewall.getNav_NatEdit_PublicIpAddressInputField(), "2.2.3.4");
	WebObjectUtil.clickElement(Firewall.getNav_EditNatSaveRuleButton());
	WebObjectUtil.explicitWait(3);
	WebObjectUtil.clickElement(Common.getNav_ConfirmPopUpOkBtn());
	WebObjectUtil.explicitWait(3);
	WebObjectUtil.clickElement(Common.getNav_CommonPopUpOKButton());
	WebObjectUtil.explicitWait(5);
	sNATSucessMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.NAT.EDIT.SUCESS.MESSAGE");
	sSucessMsg = Common.getNav_UsrFeedBack().getText();
	bStatus = sSucessMsg.contains(sNATSucessMsg);
	FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the sucess message"+sSucessMsg);
	
	driver.navigate().refresh();
	WebObjectUtil.explicitWait(3);
	sFeedBackMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.WAITING.FEEDBACK.MSG");
	sMsg = Common.getNav_UsrFeedBack().getText();
	bStatus = sMsg.contains(sFeedBackMsg);
	FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the feed back message");

    FirewallTestCase_GOM.waitForFeedbackMsgNotdisplayed();
    sFailedDeleteMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.NAT.FAILED.EDIT.FEEDBACK.MESSAGE");
    sFeedBackMsg = Common.getNav_UsrFeedBack().getText();
	
	bStatus = sFeedBackMsg.equalsIgnoreCase(sFailedDeleteMsg);
	FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the failed edit msg");
	
	// log out
	LoginTestCase_Old1.nav_Logout();
} catch (Exception e) {
	LoggerUtil.log_type_error("issue with- verifyEditNATFunctionality Test Case" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
}
    
/*==============================================================
TestScript 		: verifyAddNATFailedFeedBackMsg
Manual TestCase	: QAT-1240
Description		: Verify the failed rule
Author 			: QAA04
Creation Date 	: 06/28/2015
release Name    : Corwin
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=6)
public void verifyAddNATFailedFeedBackMsg(){

WebElement wExpander;
String sSucessMsg,sNATSucessMsg,sFeedBackMsg,sMsg,sDisabled,sFailedDeleteMsg;
boolean bStatus;
WebDriver driver = WebDriverUtil.getDriver();
PageFactory.initElements(driver, Firewall);
PageFactory.initElements(driver, Common);
try {
	FrameworkUtil.sTestCaseName="verifyAddNATFailedFeedBackMsg";
	FrameworkUtil.sManualTestCaseName="(QAT-1240) Corwin - Verify the failed rule";
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
	FirewallTestCase_GOM.SelectElementFromDropDown(Firewall.getNav_NatEdit_InsideInterfaceDropDownArrow(), "Global");
	WebObjectUtil.SetValueEdit(Firewall.getNav_NatEdit_PrivateIpAddressInputField(), "1.1.1.1");
	WebObjectUtil.SetValueEdit(Firewall.getNav_NatEdit_PublicIpAddressInputField(), "1.2.3.4");
	WebObjectUtil.clickElement(Firewall.getNav_EditNatSaveRuleButton());
	WebObjectUtil.explicitWait(3);
	WebObjectUtil.clickElement(Common.getNav_ConfirmPopUpOkBtn());
	WebObjectUtil.explicitWait(3);
	WebObjectUtil.clickElement(Common.getNav_CommonPopUpOKButton());
	WebObjectUtil.explicitWait(5);
	sNATSucessMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.NAT.ADD.SUCESS.MESSAGE");
	sSucessMsg = Common.getNav_UsrFeedBack().getText();
	bStatus = sSucessMsg.contains(sNATSucessMsg);
	FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the sucess message "+sSucessMsg);
	
	driver.navigate().refresh();
	WebObjectUtil.explicitWait(3);
	sFeedBackMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.WAITING.FEEDBACK.MSG");
	sMsg = Common.getNav_UsrFeedBack().getText();
	bStatus = sFeedBackMsg.contains(sMsg);
	FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the feed back message");

    FirewallTestCase_GOM.waitForFeedbackMsgNotdisplayed();
    sFailedDeleteMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.NAT.FAILED.ADD.FEEDBACK.MESSAGE");
    sFeedBackMsg = Common.getNav_UsrFeedBack().getText();
	
	bStatus = sFeedBackMsg.equalsIgnoreCase(sFailedDeleteMsg);
	FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the failed edit msg");
	
	// log out
	LoginTestCase_Old1.nav_Logout();
} catch (Exception e) {
	LoggerUtil.log_type_error("issue with- verifyAddNATFailedFeedBackMsg Test Case" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
}   
	
/*==============================================================
TestScript 		: verifyResetPasswordButtonFunctionality
Manual TestCase	: QAT-1338,QAT-1339
Description		: Verify the failed rule
Author 			: QAA04
Creation Date 	: 06/30/2015
release Name    : Corwin
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=8)
public void verifyResetPasswordButtonFunctionality(){
String sResetSucessMsg,sSucessMsg,sFeedBackMsg,sMsg,sFailedResetMsg,sResetPassword,sResetErrorMsg,sResetFeildErrorMsg;
WebElement wExpander;
boolean bStatus;
WebDriver driver = WebDriverUtil.getDriver();
PageFactory.initElements(driver, Firewall);
PageFactory.initElements(driver, Common);
try {
	FrameworkUtil.sTestCaseName="verifyResetPasswordButtonFunctionality";
	FrameworkUtil.sManualTestCaseName="(QAT-1338)(QAT-1339) Corwin - Verify the reset password failed feed back message";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	
	// login to the navigator
//	LoginTestCase.LoginAsQaautoAUser();
	LoginTestCase_Old1.LoginAsAgentUser();
	
	// navigating to the firewall page.
	EVDC_FirewallTestCase.NavigateToFirewallPage();
	
	FirewallTestCase_GOM.waitForFeedbackMsgNotdisplayed();
	
	// clicking on NATs tab.
	WebObjectUtil.clickElement(Firewall.getNav_UserAccessVPNsTab());
	
	wExpander = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.USERACCESSVPN.WEBTABLE.ROW.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
	WebObjectUtil.clickElement(wExpander);
	WebObjectUtil.explicitWait(2);
	WebObjectUtil.clickElement(Firewall.getNav_UserAccessVPN_ResetPasswordBtn());
	WebObjectUtil.explicitWait(3);
	sResetPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.GIDEON.EVDC.EDIT.DESCRIPTION");
	WebObjectUtil.SetValueEdit(Firewall.getNav_UserAccessVPN_ResetPasswordEditField(), sResetPassword);
	WebObjectUtil.clickElement(Firewall.getNav_UserAccessVPN_ResetPasswordEditField());
	sResetErrorMsg = Firewall.getNav_UserAccessVPN_ResetPasswordEditField().getAttribute("data-errorqtip");
	sResetFeildErrorMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.USERACCESSVPN.RESETPASSWORD.FIELD.ERROR.MESSAGE");
	bStatus = sResetErrorMsg.contains(sResetFeildErrorMsg);
	FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, sResetFeildErrorMsg+" - text verified");
	
	sResetPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.USERACCESSVPN.RESETPASSWORD");
	WebObjectUtil.SetValueEdit(Firewall.getNav_UserAccessVPN_ResetPasswordEditField(), sResetPassword);
	
	//WebObjectUtil.clickElement(Common.getNav_ConfirmPopUpOkBtn());
	WebObjectUtil.explicitWait(3);
	WebObjectUtil.clickElement(Firewall.getNav_UserAccessVpn_ResetPassword_ConfirmPopupOkBtn());
	WebObjectUtil.explicitWait(5);
	sResetSucessMsg = (String) FrameworkUtil.dictPropertyData.get("NAT.FIREWALL.USERACCESSVPN.RESETPASSWORD.SUCESS.MESSAGE");
	sSucessMsg = Common.getNav_UsrFeedBack().getText();
	bStatus = sSucessMsg.contains(sResetSucessMsg);
	FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the sucess message -" +sSucessMsg);
	
	driver.navigate().refresh();
	WebObjectUtil.explicitWait(3);
	sFeedBackMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.WAITING.FEEDBACK.MSG");
	sMsg = Common.getNav_UsrFeedBack().getText();
	bStatus = sFeedBackMsg.contains(sMsg);
	FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the feed back message");

    FirewallTestCase_GOM.waitForFeedbackMsgNotdisplayed();
    sFailedResetMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.USERACCESSVPN.RESETPASSWORD.FAILED.FEEDBACK.MESSAGE");
    sFeedBackMsg = Common.getNav_UsrFeedBack().getText();
	
	bStatus = sFeedBackMsg.equalsIgnoreCase(sFailedResetMsg);
	FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the failed reset password msg");
	
	// log out
	LoginTestCase_Old1.nav_Logout();
} catch (Exception e) {
	LoggerUtil.log_type_error("issue with- verifyResetPasswordButtonFunctionality Test Case" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
}
	
/*==============================================================
TestScript 		: verifyUserAcessTabDeleteButtonFunctionality
Manual TestCase	: QAT-1337
Description		: Verify the delete failed feed back message
Author 			: QAA04
Creation Date 	: 06/30/2015
release Name    : Corwin
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=9) 
public void verifyUserAcessTabDeleteButtonFunctionality(){

String sDeleteSucessMsg,sSucessMsg,sFeedBackMsg,sMsg,sFailedResetMsg;
WebElement wExpander;
boolean bStatus;
WebDriver driver = WebDriverUtil.getDriver();
PageFactory.initElements(driver, Firewall);
PageFactory.initElements(driver, Common);
try {
	FrameworkUtil.sTestCaseName="verifyUserAcessTabDeleteButtonFunctionality";
	FrameworkUtil.sManualTestCaseName="(QAT-1337) Corwin - Verify the delete failed feed back message";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	
	// login to the navigator
//	LoginTestCase.LoginAsQaautoAUser();
	LoginTestCase_Old1.LoginAsAgentUser();
	
	// navigating to the firewall page.
	EVDC_FirewallTestCase.NavigateToFirewallPage();
	
	FirewallTestCase_GOM.waitForFeedbackMsgNotdisplayed();
	
	// clicking on NATs tab.
	WebObjectUtil.clickElement(Firewall.getNav_UserAccessVPNsTab());
	
	wExpander = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.USERACCESSVPN.WEBTABLE.ROW.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
	WebObjectUtil.clickElement(wExpander);
	
	WebObjectUtil.clickElement(Firewall.getNav_UserAccessVPN_DeleteBtn());
	WebObjectUtil.explicitWait(3);
	WebObjectUtil.clickElement(Common.getNav_ConfirmPopUpOkBtn());
	WebObjectUtil.explicitWait(3);
//	WebObjectUtil.clickElement(Common.getNav_CommonPopUpOKButton());
//	WebObjectUtil.explicitWait(5);
	sDeleteSucessMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.USERACCESSVPN.DELETE.SUCESS.MESSAGE");
	sSucessMsg = Common.getNav_UsrFeedBack().getText();
	bStatus = sSucessMsg.contains(sDeleteSucessMsg);
	FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the sucess message -"+sSucessMsg);
	
	driver.navigate().refresh();
	WebObjectUtil.explicitWait(3);
	sFeedBackMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.WAITING.FEEDBACK.MSG");
	sMsg = Common.getNav_UsrFeedBack().getText();
	bStatus = sFeedBackMsg.contains(sMsg);
	FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the feed back message");

    FirewallTestCase_GOM.waitForFeedbackMsgNotdisplayed();
    sFailedResetMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.NAT.FAILED.DELETE.FEEDBACK.MESSAGE");
    sFeedBackMsg = Common.getNav_UsrFeedBack().getText();
	
	bStatus = sFeedBackMsg.equalsIgnoreCase(sFailedResetMsg);
	FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the failed reset password msg");
	
	// log out
	LoginTestCase_Old1.nav_Logout();
} catch (Exception e) {
	LoggerUtil.log_type_error("issue with- verifyResetPasswordButtonFunctionality Test Case" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
}

/////__________________________ Completed Hague test cases _________________________ //////
//update each @test result in custom result file
@AfterMethod
public static void afterEachMethod(){
	FrameworkUtil.updateTestCaseStatusinResult();
	//Should be deleted after today's execution by Arul on 7/14/16
	WebDriverUtil.quitWebDriver();	
}


}
