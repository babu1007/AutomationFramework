package com.whs.navigator.testcases;

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
import com.whs.navigator.pagefactory.EVDC_FirewallPageFactory;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.EntityBrowserPageFactory;
import com.whs.navigator.pagefactory.FirewallPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory;
import com.whs.navigator.pagefactory.LoadBalancerPageFactory;
import com.whs.navigator.pagefactory.PhysicalServicesPageFactory;
import com.whs.navigator.pagefactory.ReportsPageFactory;
import com.whs.navigator.pagefactory.TicketPageFactory;

public class CorwinTestCase_NMR {

	public static LoadBalancerPageFactory LoadBalancer = new LoadBalancerPageFactory();
	public static CommonPageFactory Common = new CommonPageFactory();
	public static FirewallPageFactory Firewall = new FirewallPageFactory();
	public static HomePageFactory Home = new HomePageFactory();
	public static TicketPageFactory Ticket = new TicketPageFactory();
	public static EntityBrowserPageFactory Entity = new EntityBrowserPageFactory();
	public static PhysicalServicesPageFactory PhysicalDC = new PhysicalServicesPageFactory();
	public static ReportsPageFactory Reports = new ReportsPageFactory();
	public static EVDC_FirewallPageFactory EVDC_FirewallPF = new EVDC_FirewallPageFactory();
	public static EVDC_OverviewPageFactory EVDC_Overview = new EVDC_OverviewPageFactory();
	
	 /*==============================================================
   	TestScript 		: verifyVirtaulIPAddEditDeleteFunctionality
   	Manual TestCase	: QAT-1499
   	Description		: verify the add and edit and delete functionality in virtualip tab
   	Author 			: QAA04
   	Creation Date 	: 06/06/2015
   	release Name    : Corwin
   	Pre-Requisites	:
   	Revision History:
   	
   	==============================================================*/
    @Test(priority=1) 
    public void verifyVirtaulIPAddEditDeleteFunctionality(){
    	WebElement wExpaner,wEditBtn,wDeleteBtn;
    	WebDriver driver = WebDriverUtil.getDriver();
    	PageFactory.initElements(driver, LoadBalancer);
    	
    	try {
			FrameworkUtil.sTestCaseName="verifyAddEditDeleteFunctionality";
			FrameworkUtil.sManualTestCaseName="(QAT-1499) Corwin - verify the add and edit and delete functionality in virtualip tab";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			/// Login to the navigator
			LoginTestCase.LoginAsHawkeyeUser();
			/// navigating to the load balancer page
			LoadBalancersTestCase.NavigatingToLoadBalancerPage();
			
			// creating the virtual ip.
			WebObjectUtil.clickElement(LoadBalancer.getNavVirtualIpTab_AddVIPLink());
			WebObjectUtil.explicitWait(3);
			NavigatorCommonMethods.submitDialogForCreateTicket("VirtualIP_Add");
			
			
			WebObjectUtil.clickElement(LoadBalancer.getNavVirtualIpTab());
			wExpaner = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "EVDC.LOADBALANCER.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
			WebObjectUtil.clickElement(wExpaner);
			
			wEditBtn = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "EVDC.LOADBALANCER.EXPANDER.EDIT.BUTTON", "PARAMETER_ROWNUMBER", 1 +"");
			WebObjectUtil.clickElement(wEditBtn);
			WebObjectUtil.explicitWait(3);
			NavigatorCommonMethods.submitDialogForCreateTicket("VirtualIP_Edit");
   
			wDeleteBtn = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "EVDC.LOADBALANCER.EXPANDER.DELETE.BUTTON", "PARAMETER_ROWNUMBER", 1 +"");
			WebObjectUtil.clickElement(wDeleteBtn);
			WebObjectUtil.explicitWait(3);
			driver.switchTo().frame(LoadBalancer.getNavVirtualIp_AddVIPFrame());
			WebObjectUtil.clickElement(Common.getNav_PopUpOKBtn());
			driver.switchTo().defaultContent();
			
			// we need verify these three tickets in ticket page
			
			
			
			// log out
			LoginTestCase.nav_Logout();
    	}catch (Exception e) {
			// TODO Auto-generated catch block
		    LoggerUtil.log_type_error( "Issue With-verifyVirtaulIPAddEditDeleteFunctionality" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
			}
    }
	
	
    /*==============================================================
   	TestScript 		: verifyInstanceAddEditDeleteFunctionality
   	Manual TestCase	: QAT-1498
   	Description		: verify the add and edit and delete functionality for instance tab
   	Author 			: QAA04
   	Creation Date 	: 06/07/2015
   	release Name    : Corwin
   	Pre-Requisites	:
   	Revision History:
   	
   	==============================================================*/
    @Test(priority=2)
    public void verifyInstanceAddEditDeleteFunctionality(){
    	
    	WebElement wExpaner,wEditBtn,wDeleteBtn;
    	WebDriver driver = WebDriverUtil.getDriver();
    	PageFactory.initElements(driver, LoadBalancer);
    	
    	try {
			FrameworkUtil.sTestCaseName="verifyInstanceAddEditDeleteFunctionality";
			FrameworkUtil.sManualTestCaseName="(QAT-1498) Corwin - verify the add and edit and delete functionality in instance tab";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			/// Login to the navigator
			LoginTestCase.LoginAsHawkeyeUser();
			/// navigating to the load balancer page
			LoadBalancersTestCase.NavigatingToLoadBalancerPage();
			
			WebObjectUtil.clickElement(LoadBalancer.getNavInstanceTab());
			// creating the instance.
			WebObjectUtil.clickElement(LoadBalancer.getNavInstancesTab_AddLoadBalancerLink());
			WebObjectUtil.explicitWait(3);
			NavigatorCommonMethods.submitDialogForCreateTicket("Instance_AddLoadBalancer");
			
			
			WebObjectUtil.clickElement(LoadBalancer.getNavInstanceTab());
			wExpaner = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "EVDC.INSTANCE.LOADBALANCER.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
			WebObjectUtil.clickElement(wExpaner);
			
			wEditBtn = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "EVDC.INSTANCE.LOADBALANCER.EXPANDER.EDIT.BUTTON", "PARAMETER_ROWNUMBER", 1 +"");
			WebObjectUtil.clickElement(wEditBtn);
			WebObjectUtil.explicitWait(3);
			NavigatorCommonMethods.submitDialogForCreateTicket("Instance_Edit");
   
			wDeleteBtn = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "EVDC.INSTANCE.LOADBALANCER.EXPANDER.DELETE.BUTTON", "PARAMETER_ROWNUMBER", 1 +"");
			WebObjectUtil.clickElement(wDeleteBtn);
			WebObjectUtil.explicitWait(3);
			driver.switchTo().frame(LoadBalancer.getNavVirtualIp_AddVIPFrame());
			WebObjectUtil.clickElement(Common.getNav_PopUpOKBtn());
			driver.switchTo().defaultContent();
			
			// we need verify these three tickets in ticket page
			
			// log out
			LoginTestCase.nav_Logout();
    	}catch (Exception e) {
			// TODO Auto-generated catch block
		    LoggerUtil.log_type_error( "Issue With-verifyInstanceAddEditDeleteFunctionality" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
			}
 	
    }
    
    
    /*==============================================================
   	TestScript 		: verifyPoolsAddEditDeleteFunctionality
   	Manual TestCase	: QAT-1494
   	Description		: verify the add and edit and delete functionality for pools tab
   	Author 			: QAA04
   	Creation Date 	: 06/09/2015
   	release Name    : Corwin
   	Pre-Requisites	:
   	Revision History:
   	
   	==============================================================*/
    @Test(priority=3)
    public void verifyPoolsAddEditDeleteFunctionality(){
    	
    	WebElement wExpaner,wEditBtn,wDeleteBtn;
    	WebDriver driver = WebDriverUtil.getDriver();
    	PageFactory.initElements(driver, LoadBalancer);
    	
    	try {
			FrameworkUtil.sTestCaseName="verifyInstanceAddEditDeleteFunctionality";
			FrameworkUtil.sManualTestCaseName="(QAT-1494) Corwin - verify the add and edit and delete functionality in pools tab";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			/// Login to the navigator
			LoginTestCase.LoginAsHawkeyeUser();
			/// navigating to the load balancer page
			LoadBalancersTestCase.NavigatingToLoadBalancerPage();
			
			WebObjectUtil.clickElement(LoadBalancer.getNavPoolsTab());
			// creating the instance.
			WebObjectUtil.clickElement(LoadBalancer.getNavPools_AddLB());
			WebObjectUtil.explicitWait(3);
			NavigatorCommonMethods.submitDialogForCreateTicket("Pools_AddLoadBalancer");
			
			
			WebObjectUtil.clickElement(LoadBalancer.getNavPoolsTab());
			wExpaner = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "EVDC.POOL.LOADBALANCER.TABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
			WebObjectUtil.clickElement(wExpaner);
			
			wEditBtn = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "EVDC.POOL.LOADBALANCER.EXPANDER.EDIT.BUTTON", "PARAMETER_ROWNUMBER", 1 +"");
			WebObjectUtil.clickElement(wEditBtn);
			WebObjectUtil.explicitWait(3);
			NavigatorCommonMethods.submitDialogForCreateTicket("Instance_Edit");
   
			wDeleteBtn = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "EVDC.POOL.LOADBALANCER.EXPANDER.DELETE.BUTTON", "PARAMETER_ROWNUMBER", 1 +"");
			WebObjectUtil.clickElement(wDeleteBtn);
			WebObjectUtil.explicitWait(3);
			driver.switchTo().frame(LoadBalancer.getNavVirtualIp_AddVIPFrame());
			WebObjectUtil.clickElement(Common.getNav_PopUpOKBtn());
			driver.switchTo().defaultContent();
			
			// we need verify these three tickets in ticket page
			
			// log out
			LoginTestCase.nav_Logout();
    	}catch (Exception e) {
			// TODO Auto-generated catch block
		    LoggerUtil.log_type_error( "Issue With-verifyInstanceAddEditDeleteFunctionality" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
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
    @Test(priority=4)
    public void navCreateTicketInFirewallPage(){
    	String sCreateTicket;
    	WebDriver driver = WebDriverUtil.getDriver();
    	PageFactory.initElements(driver, Firewall);
    	PageFactory.initElements(driver, EVDC_FirewallPF);
    	try{
    	FrameworkUtil.sTestCaseName="navCreateTicketInFirewallPage";
    	FrameworkUtil.sManualTestCaseName="(QAT-1477) Corwin - Create a ticket on firewall verify that in to ticket page";
    	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
    	
    	// login to the navigator
    	LoginTestCase.LoginAsQaautoUser();
    	
    	// navigating to the firewall page.
    	EVDC_FirewallTestCase.NavigateToFirewallPage();
    
    	
    	sCreateTicket = (String) FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.CREATE.TICKTE.TITLE");
    	WebObjectUtil.clickElement(EVDC_FirewallPF.getNav_CreateTicketLink());
    	NavigatorCommonMethods.submitDialogForCreateTicket(sCreateTicket);
    	driver.navigate().refresh();
    	WebObjectUtil.clickElement(Home.getNav_TierPointLogo());
    	WebObjectUtil.explicitWait(3);
    	
    	// navigating to the ticket page.
    	TicketTestCase.navigateToTicketPage();
    	
       TicketTestCase.searchTicket("Summary", sCreateTicket);
       verifyExpectedTicket(sCreateTicket);
       
       // log out
       LoginTestCase.nav_Logout();
    }catch (Exception e) {
		// TODO Auto-generated catch block
	    LoggerUtil.log_type_error( "Issue With-navCreateTicketInFirewallPage" +  e.getMessage());
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
    @Test(priority=5)
    public void verifyFirewallTicketInTicketPage(){
    	String sCreateTicket,sSiteToSiteCreateTicket;
    	WebDriver driver = WebDriverUtil.getDriver();
    	PageFactory.initElements(driver, Firewall);
    	PageFactory.initElements(driver, EVDC_FirewallPF);
    	try{
    	FrameworkUtil.sTestCaseName="navCreateTicketInFirewallPage";
    	FrameworkUtil.sManualTestCaseName="(QAT-1478) Corwin - Create a ticket in site to site vpn tab on firewall and verify that in to ticket page";
    	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
    	
    	// login to the navigator
    	//LoginTestCase.LoginAsEntity02User();;
    	LoginTestCase.LoginAsQaautoUser();
    	
    	// navigating to the firewall page.
    	EVDC_FirewallTestCase.NavigateToFirewallPage();
        WebObjectUtil.clickElement(EVDC_FirewallPF.getNavFirewall_SiteToSiteVPNsTab());
    	WebObjectUtil.explicitWait(5);
    	sCreateTicket = (String) FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.CREATE.TICKTE.TITLE");
    	sSiteToSiteCreateTicket = "SiteToSiteVPN_"+sCreateTicket;
    	WebObjectUtil.clickElement(EVDC_FirewallPF.getNavFirewall_AddSiteToSiteVPNLink());
    	NavigatorCommonMethods.submitDialogForCreateTicket(sSiteToSiteCreateTicket);
    	driver.navigate().refresh();
    	WebObjectUtil.clickElement(Home.getNav_TierPointLogo());
    	WebObjectUtil.explicitWait(3);
    	
    	// navigating to the ticket page.
    	TicketTestCase.navigateToTicketPage();
    	
       TicketTestCase.searchTicket("Summary", sSiteToSiteCreateTicket);
       verifyExpectedTicket(sCreateTicket);
       
       // log out
       LoginTestCase.nav_Logout();
    }catch (Exception e) {
		// TODO Auto-generated catch block
	    LoggerUtil.log_type_error( "Issue With-navCreateTicketInFirewallPage" +  e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
    }
    
    
    /*==============================================================
   	TestScript 		: verifyPhysicalDCPortletObjects
   	Manual TestCase	: QAT-294
   	Description		: Verify that Physical DC portlet is displayed and verify that the counts for Servers, Load Balancers, Firewalls along with Storage and Device monitor link are displayed.
   	Author 			: QAA04
   	Creation Date 	: 06/08/2015
   	release Name    : Corwin
   	Pre-Requisites	:
   	Revision History:
   	==============================================================*/
    @Test(priority=6)
    public void verifyPhysicalDCPortletObjects(){
    	String sFLCOrgData,sSLCOrgData,sServers,sLoadBalancers,sFirewall;
    	WebDriver driver = WebDriverUtil.getDriver();
    	PageFactory.initElements(driver, Entity);
    	PageFactory.initElements(driver, Home);
    	PageFactory.initElements(driver, PhysicalDC);
    	try{
    	FrameworkUtil.sTestCaseName="verifyPhysicalDCPortletObjects";
    	FrameworkUtil.sManualTestCaseName="(QAT-294) Corwin - Verify that Physical DC portlet is displayed and verify that the counts for Servers, Load Balancers, Firewalls along with Storage and Device monitor link are displayed.";
    	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
    	
    	// login to the navigator
    	LoginTestCase.LoginAsEntity01User();
    	
    	// select org from entity browser
    	 sFLCOrgData = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY02");
	      sSLCOrgData= (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY03");
	    
	     WebObjectUtil.clickElement(Entity.getNav_EntityBrowserLink());
	    
	     EntityBrowserTestCase.selectOrgFromAllLevelsEB(sFLCOrgData, sSLCOrgData,"", "");
	     WebObjectUtil.clickElement(Entity.getNav_OrgNameTitleLink());
	     
	     // verifying the org title
	     WebObjectUtil.VerifyTextUnderElement(Home.getNav_OrgNameTitle(), sSLCOrgData);
	  
	     WebObjectUtil.verifyElementPresent(PhysicalDC.getNav_PhysicalServicesPortlet());
	     
	     sServers = WebTableUtil.getCellData(PhysicalDC.getNav_PDCWebTableParent(), 1, 2);
	     FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Serveers count in PDC portlet", "pass", "The count is -" +sServers);
	     
	     sLoadBalancers = WebTableUtil.getCellData(PhysicalDC.getNav_PDCWebTableParent(), 1, 4);
	     FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "LoadBalancers count in PDC portlet", "pass", "The count is -" +sLoadBalancers);
	     
	     sFirewall = WebTableUtil.getCellData(PhysicalDC.getNav_PDCWebTableParent(), 3, 2);
	     FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Firewall count in PDC portlet", "pass", "The count is -" +sFirewall);
	     
	     /*WebObjectUtil.verifyElementPresent(PhysicalDC.getNav_PhysicalServicesPortlet());
	     sServers = PhysicalDC.getNav_PDCServersCount().getText();
	     FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Serveers count in PDC portlet", "pass", "The count is -" +sServers);
    	
	     sLoadBalancers = PhysicalDC.getNav_PDCLoadBalancersCount().getText();
	     FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "LoadBalancers count in PDC portlet", "pass", "The count is -" +sLoadBalancers);
    	
	     sFirewall = PhysicalDC.getNav_PDCFirewallCount().getText();
	     FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Firewall count in PDC portlet", "pass", "The count is -" +sFirewall);
	    	*/
	     WebObjectUtil.verifyElementPresent(PhysicalDC.getNav_PDCStorageTitle());
    	WebObjectUtil.verifyElementPresent(PhysicalDC.getNav_PDCDeviceMonitorLink());
    	
    	// log out
    	LoginTestCase.nav_Logout();
    	}catch (Exception e) {
    		// TODO Auto-generated catch block
    	    LoggerUtil.log_type_error( "Issue With-verifyPhysicalDCPortletObjects" +  e.getMessage());
    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
    		}
    }
    
    
    /*==============================================================
   	TestScript 		: verifyGraphForTwoStorageTiers
   	Manual TestCase	: QAT-1350,QAT-321
   	Description		: Verify that date is selected and a graph is displayed.
   	Author 			: QAA04
   	Creation Date 	: 06/08/2015
   	release Name    : Corwin
   	Pre-Requisites	:
   	Revision History:
   	==============================================================*/
    @Test(priority=7)
    public void verifyGraphForTwoStorageTiers(){
    	WebDriver driver = WebDriverUtil.getDriver();
    	PageFactory.initElements(driver, Reports);
    	
    	try {
			FrameworkUtil.sTestCaseName="verifyGraphForTwoStorageTiers";
			FrameworkUtil.sManualTestCaseName="(QAT-1350)(QAT-321) Corwin - Verify that date is selected and a graph is displayed.";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to the navigator
			LoginTestCase.LoginAsEntity03User();
			
			// navigating to the reports page.  
			 ReportsTestCase.navigateToReportsPage();
			
			 // clicking on storage reports link
			 WebObjectUtil.clickElement(Reports.getNavStorageReportsLink());
			
			 // selecting physical storage 
			 FirewallTestCase.SelectElementFromDropDown(Reports.getNavCustomerTieredStorageLevelsDropDownArrow(), "Physical Storage");
				   
			 // selecting RAL from POD drop down
			 FirewallTestCase.SelectElementFromDropDown(Reports.getNavPhysicalStoragePODDropDownArrow(), "RAL");
			 
			 FirewallTestCase.SelectElementFromDropDown(Reports.getNavPhysicalStorageTierDropDownArrow(), "SAN Storage - Capacity Tier - Recurring");
			
			 // selecting date 
			 FirewallTestCase.SelectElementFromDropDown(Reports.getNavPhysicalStorageDateDropDownArrow(), "2016-06");
			 WebObjectUtil.explicitWait(5);
			 WebObjectUtil.ClickAndMouseHover(Reports.getNavReportsGraph());
			 WebObjectUtil.verifyElementPresent(Reports.getNavAllocatedGraph_GreenColorLine());
			 WebObjectUtil.verifyElementPresent(Reports.getNavCommittedGraph_BlueColorline());
			    
			// selecting physical storage 
			 FirewallTestCase.SelectElementFromDropDown(Reports.getNavCustomerTieredStorageLevelsDropDownArrow(), "Virtual Storage");
				   
			 // step 11
			 // POD drop down NOT displaying for the virtual storage.
			
    	
			// log out
	    	LoginTestCase.nav_Logout();
	    	}catch (Exception e) {
	    		// TODO Auto-generated catch block
	    	    LoggerUtil.log_type_error( "Issue With-verifyGraphForTwoStorageTiers" +  e.getMessage());
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
    @Test(priority=8)
    public void verifyDeleteNATFunctionality(){
    	WebElement wExpander;
    	String sSucessMsg,sNATSucessMsg,sFeedBackMsg,sMsg,sDisabled,sFailedDeleteMsg;
    	boolean bStatus;
    	WebDriver driver = WebDriverUtil.getDriver();
    	PageFactory.initElements(driver, Firewall);
    	PageFactory.initElements(driver, EVDC_FirewallPF);
    	PageFactory.initElements(driver, Common);
    	try {
			FrameworkUtil.sTestCaseName="verifyDeleteNATFunctionality";
			FrameworkUtil.sManualTestCaseName="(QAT-1328)(QAT-1326) Corwin - verify Edit and Delete buttons are disabled.";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to the navigator
			LoginTestCase.LoginAsQaautoAUser();
			
			// navigating to the firewall page.
			EVDC_FirewallTestCase.NavigateToFirewallPage();
			
			FirewallTestCase.waitForFeedbackMsgNotdisplayed();
			
			// clicking on NATs tab.
			WebObjectUtil.clickElement(EVDC_FirewallPF.getNav_NATSLink());
			
			wExpander = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FIREWALL.NAT.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
			WebObjectUtil.clickElement(wExpander);
			
			WebObjectUtil.clickElement(EVDC_FirewallPF.getNav_deleteButtonUnderNetwork());
			WebObjectUtil.explicitWait(3);
			WebObjectUtil.clickElement(Common.getNav_CommonPopUpOkBtn());
			WebObjectUtil.explicitWait(3);
			WebObjectUtil.clickElement(Common.getNav_PopUpOKBtn());
			WebObjectUtil.explicitWait(3);
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
			
			WebObjectUtil.clickElement(EVDC_FirewallPF.getNav_NATSLink());
			
			WebObjectUtil.verifyElementNOTPresent(EVDC_FirewallPF.getNav_AddNATSLink());
			wExpander = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FIREWALL.NAT.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
			WebObjectUtil.clickElement(wExpander);
			
			sDisabled = EVDC_FirewallPF.getNav_deleteButtonUnderNetwork().getAttribute("Style");
			bStatus = sDisabled.contains("pointer-events: none");
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Delete button is disabled");
			
			sDisabled = EVDC_FirewallPF.getNav_EditButtonUnderNetwork().getAttribute("Style");
			bStatus = sDisabled.contains("pointer-events: none");
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Edit button is disabled");
			
		    FirewallTestCase.waitForFeedbackMsgNotdisplayed();
		    sFailedDeleteMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.NAT.FAILED.DELETE.FEEDBACK.MESSAGE");
		    sFeedBackMsg = Common.getNav_UsrFeedBack().getText();
			
			bStatus = sFeedBackMsg.equalsIgnoreCase(sFailedDeleteMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the failed delete msg");
			
			// log out
			LoginTestCase.nav_Logout();
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
    @Test(priority=9)
    public void verifyEditNATFunctionality(){
    	WebElement wExpander;
    	String sSucessMsg,sNATSucessMsg,sFeedBackMsg,sMsg,sDisabled,sFailedDeleteMsg;
    	boolean bStatus;
    	WebDriver driver = WebDriverUtil.getDriver();
    	PageFactory.initElements(driver, Firewall);
    	PageFactory.initElements(driver, EVDC_FirewallPF);
    	PageFactory.initElements(driver, Common);
    	try {
			FrameworkUtil.sTestCaseName="verifyEditNATFunctionality";
			FrameworkUtil.sManualTestCaseName="(QAT-1325) Corwin - verify edit failed feed back message for NATs";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to the navigator
			LoginTestCase.LoginAsQaautoAUser();
			
			// navigating to the firewall page.
			EVDC_FirewallTestCase.NavigateToFirewallPage();
			
			FirewallTestCase.waitForFeedbackMsgNotdisplayed();
			
			// clicking on NATs tab.
			WebObjectUtil.clickElement(EVDC_FirewallPF.getNav_NATSLink());
			
			wExpander = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FIREWALL.NAT.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
			WebObjectUtil.clickElement(wExpander);
			
			WebObjectUtil.clickElement(EVDC_FirewallPF.getNav_EditButtonUnderNetwork());
			WebObjectUtil.explicitWait(3);
			WebObjectUtil.SetValueEdit(EVDC_FirewallPF.getNav_NatEdit_PublicIpAddressInputField(), "2.2.3.4");
			WebObjectUtil.clickElement(EVDC_FirewallPF.getNav_EditNatSaveRuleButton());
			WebObjectUtil.explicitWait(3);
			WebObjectUtil.clickElement(Common.getNav_CommonPopUpOkBtn());
			WebObjectUtil.explicitWait(3);
			WebObjectUtil.clickElement(Common.getNav_PopUpOKBtn());
			WebObjectUtil.explicitWait(5);
			sNATSucessMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.NAT.EDIT.SUCESS.MESSAGE");
			sSucessMsg = Common.getNav_UsrFeedBack().getText();
			bStatus = sSucessMsg.contains(sNATSucessMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the sucess message");
			
			driver.navigate().refresh();
			WebObjectUtil.explicitWait(3);
			sFeedBackMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.WAITING.FEEDBACK.MSG");
			sMsg = Common.getNav_UsrFeedBack().getText();
			bStatus = sMsg.contains(sFeedBackMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the feed back message");
		
		    FirewallTestCase.waitForFeedbackMsgNotdisplayed();
		    sFailedDeleteMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.NAT.FAILED.EDIT.FEEDBACK.MESSAGE");
		    sFeedBackMsg = Common.getNav_UsrFeedBack().getText();
			
			bStatus = sFeedBackMsg.equalsIgnoreCase(sFailedDeleteMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the failed edit msg");
			
			// log out
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with- verifyEditNATFunctionality Test Case" );
	 		LoggerUtil.log_type_error(e.getMessage());
	 		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	 	}
    }
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
    @Test(priority=10)
    public void verifyNATEditErrorMsg(){
    	WebElement wExpander;
    	String sErrorMsg;
    	WebDriver driver = WebDriverUtil.getDriver();
    	PageFactory.initElements(driver, EVDC_FirewallPF);
    	PageFactory.initElements(driver, Common);
    	
    	try {
			FrameworkUtil.sTestCaseName="verifyNATEditErrorMsg";
			FrameworkUtil.sManualTestCaseName="(QAT-1252) Corwin - verify edit error message for NATs";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to the navigator
			LoginTestCase.LoginAsQaautoAUser();
			
			// navigating to the firewall page.
			EVDC_FirewallTestCase.NavigateToFirewallPage();
			
			FirewallTestCase.waitForFeedbackMsgNotdisplayed();
			
			// clicking on NATs tab.
			WebObjectUtil.clickElement(EVDC_FirewallPF.getNav_NATSLink());
			
			wExpander = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FIREWALL.NAT.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
			WebObjectUtil.clickElement(wExpander);
			
			WebObjectUtil.clickElement(EVDC_FirewallPF.getNav_EditButtonUnderNetwork());
			
			WebObjectUtil.clickElement(EVDC_FirewallPF.getNav_EditNatSaveRuleButton());
			WebObjectUtil.explicitWait(3);
			if(Common.getNav_CommonPopUp().isDisplayed()){
				sErrorMsg = Common.getNav_CommonPopUpMessage().getText();;
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verifying the edit error msg", "pass", "Error msg - "+sErrorMsg);
			WebObjectUtil.clickElement(Common.getNav_PopUpOKBtn());
			WebObjectUtil.explicitWait(5);
			}
			// log out
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with- verifyNATEditErrorMsg Test Case" );
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
    @Test(priority=11)
    public void verifyAddNATFailedFeedBackMsg(){
    	
    	WebElement wExpander;
    	String sSucessMsg,sNATSucessMsg,sFeedBackMsg,sMsg,sDisabled,sFailedDeleteMsg;
    	boolean bStatus;
    	WebDriver driver = WebDriverUtil.getDriver();
    	PageFactory.initElements(driver, EVDC_FirewallPF);
    	PageFactory.initElements(driver, Common);
    	try {
			FrameworkUtil.sTestCaseName="verifyAddNATFailedFeedBackMsg";
			FrameworkUtil.sManualTestCaseName="(QAT-1240) Corwin - Verify the failed rule";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to the navigator
			LoginTestCase.LoginAsQaautoAUser();
			
			// navigating to the firewall page.
			EVDC_FirewallTestCase.NavigateToFirewallPage();
			
			FirewallTestCase.waitForFeedbackMsgNotdisplayed();
			
			// clicking on NATs tab.
			WebObjectUtil.clickElement(EVDC_FirewallPF.getNav_NATSLink());
			
			wExpander = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FIREWALL.NAT.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
			WebObjectUtil.clickElement(wExpander);
			
			WebObjectUtil.clickElement(EVDC_FirewallPF.getNav_AddNATSLink());
			WebObjectUtil.explicitWait(2);
			FirewallTestCase.SelectElementFromDropDown(EVDC_FirewallPF.getNav_NatEdit_InsideInterfaceDropDownArrow(), "Global");
			WebObjectUtil.SetValueEdit(EVDC_FirewallPF.getNav_NatEdit_PrivateIpAddressInputField(), "1.1.1.1");
			WebObjectUtil.SetValueEdit(EVDC_FirewallPF.getNav_NatEdit_PublicIpAddressInputField(), "1.2.3.4");
			WebObjectUtil.clickElement(EVDC_FirewallPF.getNav_EditNatSaveRuleButton());
			WebObjectUtil.explicitWait(3);
			WebObjectUtil.clickElement(Common.getNav_CommonPopUpOkBtn());
			WebObjectUtil.explicitWait(3);
			WebObjectUtil.clickElement(Common.getNav_PopUpOKBtn());
			WebObjectUtil.explicitWait(5);
			sNATSucessMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.NAT.ADD.SUCESS.MESSAGE");
			sSucessMsg = Common.getNav_UsrFeedBack().getText();
			bStatus = sSucessMsg.contains(sNATSucessMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the sucess message");
			
			driver.navigate().refresh();
			WebObjectUtil.explicitWait(3);
			sFeedBackMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.WAITING.FEEDBACK.MSG");
			sMsg = Common.getNav_UsrFeedBack().getText();
			bStatus = sFeedBackMsg.contains(sMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the feed back message");
		
		    FirewallTestCase.waitForFeedbackMsgNotdisplayed();
		    sFailedDeleteMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.NAT.FAILED.ADD.FEEDBACK.MESSAGE");
		    sFeedBackMsg = Common.getNav_UsrFeedBack().getText();
			
			bStatus = sFeedBackMsg.equalsIgnoreCase(sFailedDeleteMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the failed edit msg");
			
			// log out
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with- verifyAddNATFailedFeedBackMsg Test Case" );
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
    @Test(priority=12)  
    public void verifyAddNatEditFields(){
    	WebElement wExpander;
    	String sOutSideInterfaceText,sErrorToolTip,sErrorMsg,sTooltipMsg;
    	boolean bStatus;
    	WebDriver driver = WebDriverUtil.getDriver();
    	PageFactory.initElements(driver, EVDC_FirewallPF);
    	PageFactory.initElements(driver, Common);
    	
    	try {
			FrameworkUtil.sTestCaseName="verifyAddNatEditFields";
			FrameworkUtil.sManualTestCaseName="(QAT-1187) Corwin - verify all edit fields in add nat window";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to the navigator
			LoginTestCase.LoginAsQaautoAUser();
			
			// navigating to the firewall page.
			EVDC_FirewallTestCase.NavigateToFirewallPage();
			
			FirewallTestCase.waitForFeedbackMsgNotdisplayed();
			
			// clicking on NATs tab.
			WebObjectUtil.clickElement(EVDC_FirewallPF.getNav_NATSLink());
			
			wExpander = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FIREWALL.NAT.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
			WebObjectUtil.clickElement(wExpander);
			
			WebObjectUtil.clickElement(EVDC_FirewallPF.getNav_AddNATSLink());
			WebObjectUtil.explicitWait(2);
			
			WebObjectUtil.verifyElementPresent(EVDC_FirewallPF.getNav_NatEdit_InsideInterfaceDropDownEditField());
			
			FirewallTestCase.SelectElementFromDropDown(EVDC_FirewallPF.getNav_NatEdit_InsideInterfaceDropDownArrow(), "Global");
			
			WebObjectUtil.verifyElementPresent(EVDC_FirewallPF.getNav_NatEdit_OutsideInterfaceEditField());
			sOutSideInterfaceText = EVDC_FirewallPF.getNav_NatEdit_OutsideInterfaceEditField().getAttribute("value");
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Outside interface edit filed data", "pass", " - "+sOutSideInterfaceText);
			WebObjectUtil.verifyElementPresent(EVDC_FirewallPF.getNav_NatEdit_PrivateIpAddressInputField());
			
			WebObjectUtil.SetValueEdit(EVDC_FirewallPF.getNav_NatEdit_PrivateIpAddressInputField(), "1.1.1");
			WebObjectUtil.clickElement(EVDC_FirewallPF.getNav_NatEdit_PrivateIpAddressInputField());
			sErrorToolTip = EVDC_FirewallPF.getNav_NatEdit_PrivateIpAddressInputField().getAttribute("data-errorqtip");
			sErrorMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.NAT.ADDNATRULE.ERROR.TOOLTIP.MESSAGE");
			bStatus = sErrorToolTip.contains(sErrorMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the private ipaddress edit field");
			WebObjectUtil.SetValueEdit(EVDC_FirewallPF.getNav_NatEdit_PrivateIpAddressInputField(), "1.1.1.2");
			
			
			WebObjectUtil.SetValueEdit(EVDC_FirewallPF.getNav_NatEdit_PublicIpAddressInputField(), "1.2.3");
			WebObjectUtil.clickElement(EVDC_FirewallPF.getNav_NatEdit_PublicIpAddressInputField());
			sErrorToolTip = EVDC_FirewallPF.getNav_NatEdit_PublicIpAddressInputField().getAttribute("data-errorqtip");
			sErrorMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.NAT.ADDNATRULE.ERROR.TOOLTIP.MESSAGE");
			bStatus = sErrorToolTip.contains(sErrorMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the public ipaddress edit field");
			WebObjectUtil.SetValueEdit(EVDC_FirewallPF.getNav_NatEdit_PublicIpAddressInputField(), "1.2.3.4");
			
			
			WebObjectUtil.clickElement(EVDC_FirewallPF.getNav_NatEdit_InsideInterfaceIcon());;
		    sTooltipMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.NAT.ADDNATRULE.INSIDEINTERFACE.TOOLTIP");
			WebObjectUtil.getToolTipsMsg(EVDC_FirewallPF.getNav_NatEdit_InsideInterfaceIcon(), sTooltipMsg);
		    
			WebObjectUtil.clickElement(EVDC_FirewallPF.getNav_NatEdit_OutsideInterfaceIcon());;
		    sTooltipMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.NAT.ADDNATRULE.OUTSIDEINTERFACE.TOOLTIP");
			WebObjectUtil.getToolTipsMsg(EVDC_FirewallPF.getNav_NatEdit_OutsideInterfaceIcon(), sTooltipMsg);
			
			WebObjectUtil.clickElement(EVDC_FirewallPF.getNav_NatEdit_PrivateIpAddressIcon());;
		    sTooltipMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.NAT.ADDNATRULE.PRIVATEIPADDRESS.TOOLTIP");
			WebObjectUtil.getToolTipsMsg(EVDC_FirewallPF.getNav_NatEdit_PrivateIpAddressIcon(), sTooltipMsg);
			
			WebObjectUtil.clickElement(EVDC_FirewallPF.getNav_NatEdit_PublicIpAddressIcon());;
		    sTooltipMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.NAT.ADDNATRULE.PUBLICIPADDRESS.TOOLTIP");
			WebObjectUtil.getToolTipsMsg(EVDC_FirewallPF.getNav_NatEdit_PublicIpAddressIcon(), sTooltipMsg);
	
		    WebObjectUtil.verifyElementPresent(EVDC_FirewallPF.getNav_EditNatSaveRuleButton());
		    WebObjectUtil.verifyElementPresent(EVDC_FirewallPF.getNav_EditNatCancelButton());
			
      // log out
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with- verifyAddNatEditFields Test Case" );
	 		LoggerUtil.log_type_error(e.getMessage());
	 		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	 	}
    	
    }
    
    /*==============================================================
   	TestScript 		: verifyMoreTextInFirewallPortlet
   	Manual TestCase	: QAT-1340
   	Description		: verify the firewall portlet values
   	Author 			: QAA04
   	Creation Date 	: 06/29/2015
   	release Name    : Corwin
   	Pre-Requisites	:
   	Revision History:
   	==============================================================*/
    @Test(priority=13)
    public void verifyMoreTextInFirewallPortlet(){
    	
    	WebDriver driver = WebDriverUtil.getDriver();
    	PageFactory.initElements(driver, EVDC_FirewallPF);
    	PageFactory.initElements(driver, Home);
    	PageFactory.initElements(driver, EVDC_Overview);
    	try{
    	FrameworkUtil.sTestCaseName="verifyMoreTextInFirewallPortlet";
    	FrameworkUtil.sManualTestCaseName="(QAT-1340) Corwin - verify the firewall portlet values";
    	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
    	
    	// login to the navigator
    	LoginTestCase.LoginAsQaautoAUser();
    	
    	WebObjectUtil.scrollElementAtPageCenter(EVDC_Overview.getNav_EVDCname());
    	WebObjectUtil.clickElement(EVDC_Overview.getNav_EVDCname());
    	
    	
    	WebObjectUtil.verifyElementPresent(EVDC_Overview.getNav_FirewallMoreText());
    
    	 WebObjectUtil.verifyElementPresent(EVDC_Overview.getNav_FirewallRulesText());
         WebObjectUtil.verifyElementPresent(EVDC_Overview.getNav_FirewallRulesCount());
         WebObjectUtil.verifyElementPresent(EVDC_Overview.getNav_FirewallVPNTunnelsText());
         WebObjectUtil.verifyElementPresent(EVDC_Overview.getNav_FirewallVPNTunnelsCount());
         WebObjectUtil.verifyElementPresent(EVDC_Overview.getNav_FirewallVPNUsersText());
         WebObjectUtil.verifyElementPresent(EVDC_Overview.getNav_FirewallVPNUsersCount());
         WebObjectUtil.verifyElementPresent(EVDC_Overview.getNav_FirewallNATSText());
         WebObjectUtil.verifyElementPresent(EVDC_Overview.getNav_FirewallNATSCount());
         WebObjectUtil.verifyElementPresent(EVDC_Overview.getNav_FirewallOutsideIpText());
         WebObjectUtil.verifyElementPresent(EVDC_Overview.getNav_FirewallRulesCount());
         WebObjectUtil.verifyElementPresent(EVDC_Overview.getNav_FirewallInsideIpText());
         WebObjectUtil.verifyElementPresent(EVDC_Overview.getNav_FirewallInsideIpCount());
      // log out
      			LoginTestCase.nav_Logout();
      		} catch (Exception e) {
      			LoggerUtil.log_type_error("issue with- verifyMoreTextInFirewallPortlet Test Case" );
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
    @Test(priority=14)
    public void verifyResetPasswordButtonFunctionality(){
    	String sResetSucessMsg,sSucessMsg,sFeedBackMsg,sMsg,sFailedResetMsg,sResetPassword,sResetErrorMsg,sResetFeildErrorMsg;
    	WebElement wExpander;
    	boolean bStatus;
    	WebDriver driver = WebDriverUtil.getDriver();
    	PageFactory.initElements(driver, EVDC_FirewallPF);
    	PageFactory.initElements(driver, Common);
    	try {
			FrameworkUtil.sTestCaseName="verifyResetPasswordButtonFunctionality";
			FrameworkUtil.sManualTestCaseName="(QAT-1338)(QAT-1339) Corwin - Verify the reset password failed feed back message";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to the navigator
		//	LoginTestCase.LoginAsQaautoAUser();
			LoginTestCase.LoginAsAgentUser();
			
			// navigating to the firewall page.
			EVDC_FirewallTestCase.NavigateToFirewallPage();
			
			FirewallTestCase.waitForFeedbackMsgNotdisplayed();
			
			// clicking on NATs tab.
			WebObjectUtil.clickElement(EVDC_FirewallPF.getNav_UserAccessVPNsTab());
			
			wExpander = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.USERACCESSVPN.WEBTABLE.ROW.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
			WebObjectUtil.clickElement(wExpander);
			WebObjectUtil.explicitWait(2);
			WebObjectUtil.clickElement(EVDC_FirewallPF.getNav_UserAccessVPN_ResetPasswordBtn());
			WebObjectUtil.explicitWait(3);
			sResetPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.GIDEON.EVDC.EDIT.DESCRIPTION");
			WebObjectUtil.SetValueEdit(EVDC_FirewallPF.getNav_UserAccessVPN_ResetPasswordEditField(), sResetPassword);
			WebObjectUtil.clickElement(EVDC_FirewallPF.getNav_UserAccessVPN_ResetPasswordEditField());
			sResetErrorMsg = EVDC_FirewallPF.getNav_UserAccessVPN_ResetPasswordEditField().getAttribute("data-errorqtip");
			sResetFeildErrorMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.USERACCESSVPN.RESETPASSWORD.FIELD.ERROR.MESSAGE");
			bStatus = sResetErrorMsg.contains(sResetFeildErrorMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, sResetFeildErrorMsg+" - text verified");
			
			sResetPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.USERACCESSVPN.RESETPASSWORD");
			WebObjectUtil.SetValueEdit(EVDC_FirewallPF.getNav_UserAccessVPN_ResetPasswordEditField(), sResetPassword);
			
			//WebObjectUtil.clickElement(Common.getNav_CommonPopUpOkBtn());
			WebObjectUtil.explicitWait(3);
			WebObjectUtil.clickElement(Common.getNav_PopUpOKBtn());
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
		
		    FirewallTestCase.waitForFeedbackMsgNotdisplayed();
		    sFailedResetMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.USERACCESSVPN.RESETPASSWORD.FAILED.FEEDBACK.MESSAGE");
		    sFeedBackMsg = Common.getNav_UsrFeedBack().getText();
			
			bStatus = sFeedBackMsg.equalsIgnoreCase(sFailedResetMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the failed reset password msg");
			
			// log out
			LoginTestCase.nav_Logout();
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
    @Test(priority=15) 
    public void verifyUserAcessTabDeleteButtonFunctionality(){
    	
    	String sDeleteSucessMsg,sSucessMsg,sFeedBackMsg,sMsg,sFailedResetMsg;
    	WebElement wExpander;
    	boolean bStatus;
    	WebDriver driver = WebDriverUtil.getDriver();
    	PageFactory.initElements(driver, EVDC_FirewallPF);
    	PageFactory.initElements(driver, Common);
    	try {
			FrameworkUtil.sTestCaseName="verifyUserAcessTabDeleteButtonFunctionality";
			FrameworkUtil.sManualTestCaseName="(QAT-1337) Corwin - Verify the delete failed feed back message";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to the navigator
		//	LoginTestCase.LoginAsQaautoAUser();
			LoginTestCase.LoginAsAgentUser();
			
			// navigating to the firewall page.
			EVDC_FirewallTestCase.NavigateToFirewallPage();
			
			FirewallTestCase.waitForFeedbackMsgNotdisplayed();
			
			// clicking on NATs tab.
			WebObjectUtil.clickElement(EVDC_FirewallPF.getNav_UserAccessVPNsTab());
			
			wExpander = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.USERACCESSVPN.WEBTABLE.ROW.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
			WebObjectUtil.clickElement(wExpander);
			
			WebObjectUtil.clickElement(EVDC_FirewallPF.getNav_UserAccessVPN_DeleteBtn());
			WebObjectUtil.explicitWait(3);
			WebObjectUtil.clickElement(Common.getNav_CommonPopUpOkBtn());
			WebObjectUtil.explicitWait(3);
			WebObjectUtil.clickElement(Common.getNav_PopUpOKBtn());
			WebObjectUtil.explicitWait(5);
			sDeleteSucessMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.NAT.DELETE.SUCESS.MESSAGE");
			sSucessMsg = Common.getNav_UsrFeedBack().getText();
			bStatus = sSucessMsg.contains(sDeleteSucessMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the sucess message -"+sSucessMsg);
			
			driver.navigate().refresh();
			WebObjectUtil.explicitWait(3);
			sFeedBackMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.WAITING.FEEDBACK.MSG");
			sMsg = Common.getNav_UsrFeedBack().getText();
			bStatus = sFeedBackMsg.contains(sMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the feed back message");
		
		    FirewallTestCase.waitForFeedbackMsgNotdisplayed();
		    sFailedResetMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.NAT.FAILED.DELETE.FEEDBACK.MESSAGE");
		    sFeedBackMsg = Common.getNav_UsrFeedBack().getText();
			
			bStatus = sFeedBackMsg.equalsIgnoreCase(sFailedResetMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the failed reset password msg");
			
			// log out
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with- verifyResetPasswordButtonFunctionality Test Case" );
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
    @Test(priority=16)
    public void VerifyCustomerPeerAddressValue(){
    	WebElement wExpander,wCustomerAddressValue,wSiteToSiteVPNsRow;
    	String sCustomerAddressValue,sSiteToSiteVPNsRow;
    	WebDriver driver = WebDriverUtil.getDriver();
    	PageFactory.initElements(driver, EVDC_FirewallPF);
    	
    	try {
			FrameworkUtil.sTestCaseName="VerifyCustomerPeerAddressValue";
			FrameworkUtil.sManualTestCaseName="(QAT-1342) Corwin - Verify the Customer Peer Address value";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to navigator
			LoginTestCase.LoginAsAgentUser();
			
			// navigating to the firewall page
			EVDC_FirewallTestCase.NavigateToFirewallPage();
			
			// clicking on site to site vpn tab
			WebObjectUtil.clickElement(EVDC_FirewallPF.getNav_SiteToSiteVPNsTab());
			
			wExpander = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.SITETOSITEVPNS.WEBTABLE.ROW.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
			WebObjectUtil.clickElement(wExpander);
			
			wCustomerAddressValue = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.SITETOSITEVPNS.WEBTABLE.CUSTOMERPEERADDERSS.VALUE", "PARAMETER_ROWNUMBER", 1+"");
			sCustomerAddressValue = wCustomerAddressValue.getText();
			
			wSiteToSiteVPNsRow = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.SITETOSITEVPNS.WEBTABLE.ROW.VALUE", "PARAMETER_ROWNUMBER", 1+"");
			sSiteToSiteVPNsRow = wCustomerAddressValue.getText();
					
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verify customer peer address value", "pass", " vlaue - "+sCustomerAddressValue);
			
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "site to site vpn webtable first row data", "pass", " vlaue - "+sSiteToSiteVPNsRow);
			
			// log out
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with VerifyCustomerPeerAddressValue Test Case" );
	 		LoggerUtil.log_type_error(e.getMessage());
	 		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	 	}
  }
    
    
    
    
    
    
    
    
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
	
	
////////________________________________________________________________________________//////////////////// 
//update each @test result in custom result file
	@AfterMethod
	public static void afterEachMethod(){
		FrameworkUtil.updateTestCaseStatusinResult();
		FrameworkUtil.sTestExecutionStatus = true;
}
}