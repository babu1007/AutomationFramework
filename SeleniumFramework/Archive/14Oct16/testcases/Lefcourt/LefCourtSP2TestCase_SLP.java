package com.whs.navigator.testcases.Lefcourt;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.sun.jna.StringArray;
import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.commonUtil.WebTableUtil;
import com.whs.navigator.pagefactory.AddFirewallPageFactory;
import com.whs.navigator.pagefactory.AnnouncementPageFactory;
import com.whs.navigator.pagefactory.CommonPageFactory;
import com.whs.navigator.pagefactory.EVDC_FirewallPageFactory;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.EVDC_VM_PageFactory;
import com.whs.navigator.pagefactory.EntityBrowserPageFactory;
import com.whs.navigator.pagefactory.FirewallPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.TicketPageFactory;
import com.whs.navigator.pagefactory.UserPermissionMultiOrgPageFactory;


public class LefCourtSP2TestCase_SLP {
	
	 
	 public static EVDC_OverviewPageFactory EVDC_OverviewPF = new EVDC_OverviewPageFactory();
	 public static EntityBrowserPageFactory EBPanel = new EntityBrowserPageFactory();
	 public static TicketPageFactory Ticket = new TicketPageFactory();
	 public static EVDC_FirewallPageFactory Firewall = new EVDC_FirewallPageFactory();
	 public static AddFirewallPageFactory AddFirewall = new AddFirewallPageFactory();
	 
	 
	 /*==============================================================
		TestScript  	: verifyAllAddFirewallRuleFieldIcons
		Manual TestCase	: [QAT-536][531][524] WCP_3031_TC_2.3_Firewall ->Add Firewall rule page-> Validate all the fields,PDF and CSV reports
		Description		: 
		Author 			: QAA03
		Creation Date 	: 03/23/2016
		Release Name    : LefCourt-SP2
		Pre-Requisites	:
		Revision History:
	  ==============================================================*/
		
		@Test(priority=41)
		public void verifyAllAddFirewallRuleFieldIcons()
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,EVDC_OverviewPF);
				PageFactory.initElements(driver,Firewall);
				PageFactory.initElements(driver,AddFirewall);
				
				String sInterfaceName=null,sInterfaceDesc=null;
				boolean bAddFirewallCloseStatus=false;
		
			try {
				FrameworkUtil.sTestCaseName = "verifyAllAddFirewallRuleFieldIcons";
				FrameworkUtil.sManualTestCaseName="[QAT-536][531][524] WCP_3031_TC_2.3_Firewall ->Add Firewall rule page-> Validate all the fields,PDF and CSV reports";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
				sInterfaceName = (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.INTERFACENAME.INTERFACE1");
				sInterfaceDesc = (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.INTERFACE1.DESCRIPTION");
				
			    //Login to navigator with entity02 user
				LoginTestCase_Old1.LoginAsEntity02User();
							
				//Navigating to Firewall Page
				WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
				WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCOverviewFirewall());
				
				
				AddFirewallRuleTestCase.expandInterface(sInterfaceName,sInterfaceDesc);
				
				
				WebObjectUtil.verifyElementPresent(Firewall.getNav_Firewall_PDFIcon());
				WebObjectUtil.verifyElementPresent(Firewall.getNav_Firewall_CSVIcon());
				
				//Clicking on Add Firewall link
				WebObjectUtil.clickElement(Firewall.getNav_AddFireWallLink());
				
				verifyAddFirewallfields();
				
				NavigatorCommonMethods.verifyPDFAndCSVIcons();
								
				//Clicking on Add Firewall cancel button
				WebObjectUtil.clickElement(AddFirewall.getNav_AddFirewallCancelButton());
				
				//Verifying Add firewall window closed
				bAddFirewallCloseStatus =!Firewall.getNav_AddFireWallWindow().isDisplayed();
				//Please pass values using properties file-by Priyanka
				FrameworkUtil.updateCustomResultBasedOnStatus(bAddFirewallCloseStatus, "Add Firewall Window closed");
				
				//Logout from Navigator
				 LoginTestCase_Old1.nav_Logout();
			
			   } catch (Exception e) {
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAllAddFirewallRuleFieldIcons", "warn", "catch block:" +e.getMessage());
			}
		}
	 /*==============================================================
	TestScript  	: verifyAddFirewallRuleDataDropdownFields
	Manual TestCase	: [QAT-725][724][723] WCP_3031_TC_1.27_Firewall-> Add Firewall rule-> Service Type drop down, destination type and source type field Validations.
	Description		: 
	Author 			: QAA03
	Creation Date 	: 03/21/2016
	Release Name    : LefCourt-SP2
	Pre-Requisites	:
	Revision History:
  ==============================================================*/
	
	@Test(priority=42)
	public void verifyAddFirewallRuleDataDropdownFields()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,EVDC_OverviewPF);
			PageFactory.initElements(driver,Firewall);
			PageFactory.initElements(driver,AddFirewall);
			
			String sInterfaceName=null,sInterfaceDesc=null;
			boolean bAddFirewallCloseStatus=false;
	
		try {
			FrameworkUtil.sTestCaseName = "verifyAddFirewallRuleDataDropdownFields";
			FrameworkUtil.sManualTestCaseName="[QAT-725][724][723][690] WCP_3031_TC_1.27_Firewall-> Add Firewall rule-> Service Type drop down, destination type and source type field Validations";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			sInterfaceName = (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.INTERFACENAME.INTERFACE1");
			sInterfaceDesc = (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.INTERFACE1.DESCRIPTION");
			
		    //Login to navigator with entity02 user
			LoginTestCase_Old1.LoginAsEntity02User();
						
			//Navigating to Firewall Page
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCOverviewFirewall());
			WebObjectUtil.explicitWait(5);
			/*//Clicking on First interface
			WebObjectUtil.clickElement(Firewall.getNav_FirstFirewallRuleExpander());
			WebObjectUtil.waitForElementPresent(Firewall.getNav_AddFireWallLink());*/
			
			AddFirewallRuleTestCase.expandInterface(sInterfaceName,sInterfaceDesc);
			
			//Clicking on Add Firewall link
			WebObjectUtil.clickElement(Firewall.getNav_AddFireWallLink());
			
			//Verifying Add Firewall Source Type Dropdown fields
			verifyAddFirewallSourceTypefield();
			
			//Verifying Add Firewall Destination Type Dropdown fields
			verifyAddFirewallDestinationTypefield();
			
			//Verifying Add Firewall Service Type Dropdown fields
			verifyAddFirewallServiceTypefield();
			
			//Selecting "Any" from Destination dropdown and verifying the status
			selectandvalAnyItemfromDestinationdropdown();
			
			//Selecting "Host" from Destination dropdown and verifying the status
			selectandvalHostItemfromDestinationdropdown();
			
			//Selecting "Network" from Destination dropdown and verifying the status
			selectandvalNetworkItemfromDestinationdropdown();
			
			//Selecting "Object" from Destination dropdown and verifying the status
			selectandvalObjectItemfromDestinationdropdown();
			
			//Selecting " Group Object" from Destination dropdown and verifying the status
			selectandvalGroupObjectItemfromDestinationdropdown();
			
			//Selecting "Any" from Source dropdown and verifying the status
			selectandvalAnyItemfromSourcedropdown();
			
			//Selecting "Host" from Source dropdown and verifying the status
			selectandvalHostItemfromSourcedropdown();
			
			//Selecting "Network" from Source dropdown and verifying the status
			selectandvalNetworkItemfromSourcedropdown();
			
			//Selecting "Object" from Source dropdown and verifying the status
			selectandvalObjectItemfromSourcedropdown();
			
			//Selecting " Group Object" from Source dropdown and verifying the status
			selectandvalGroupObjectItemfromSourcedropdown();
			
			//Selecting "Protocol" from  service type dropdown and verifying the status
			selectandvalProtocolItemfromServiceTypedropdown();
			
			//Selecting "ICMP" from  Protocol type dropdown and verifying the status
			selectandvalICMPItemfromProtocoldropdown();
			
			//Selecting "TCP" from  Protocol type dropdown and verifying the status
			selectandvalTCPItemfromProtocoldropdown();
			
			//Selecting "UDP" from  Protocol type dropdown and verifying the status
			selectandvalUDPItemfromProtocoldropdown();
			
			//Selecting "Service Group" from service type dropdown and verifying the status
			selectandvalServiceGroupItemfromServiceTypedropdown();
			
			//Clicking on Add Firewall cancel button
			WebObjectUtil.clickElement(AddFirewall.getNav_AddFirewallCancelButton());
			
			//Verifying Add firewall window closed
			bAddFirewallCloseStatus =!Firewall.getNav_AddFireWallWindow().isDisplayed();
			FrameworkUtil.updateCustomResultBasedOnStatus(bAddFirewallCloseStatus, "Add Firewall Window closed");
			
			//Logout from Navigator
			 LoginTestCase_Old1.nav_Logout();
			 
			 //Login to navigator with Qaauto user
			LoginTestCase_Old1.LoginAsQaautoUser();
							
			//Navigating to Firewall Page
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCOverviewFirewall());
			
			AddFirewallRuleTestCase.expandInterface(sInterfaceName,sInterfaceDesc);
				
			//Clicking on Add Firewall link
			WebObjectUtil.clickElement(Firewall.getNav_AddFireWallLink());
				
			//Verifying Add Firewall Source Type Dropdown fields
			verifyAddFirewallSourceTypefield();
				
			//Verifying Add Firewall Destination Type Dropdown fields
			verifyAddFirewallDestinationTypefield();
			
			//Verifying Add Firewall Service Type Dropdown fields
			verifyAddFirewallServiceTypefield();
			
			//Clicking on Add Firewall cancel button
			WebObjectUtil.clickElement(AddFirewall.getNav_AddFirewallCancelButton());
			
			//Verifying Add firewall window closed
			bAddFirewallCloseStatus =!Firewall.getNav_AddFireWallWindow().isDisplayed();
			FrameworkUtil.updateCustomResultBasedOnStatus(bAddFirewallCloseStatus, "Add Firewall Window closed");
			
			//Logout from Navigator
			LoginTestCase_Old1.nav_Logout();
		
		   } catch (Exception e) {
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAddFirewallRuleDataDropdownFields", "warn", "catch block:" +e.getMessage());
		}
	}
	 /*==============================================================
		TestScript  	: verifyTicketsPageForOrghasApostrophe
		Manual TestCase	: [QAT-391] WCP_4175_TC_1.0_Tickets_user should be able to view tickets when org name has apostrophe.
		Description		: 
		Author 			: QAA03
		Creation Date 	: 02/29/2016
		Release Name    : LefCourt-SP2
		Pre-Requisites	:
		Revision History:
	  ==============================================================*/
		
		@Test(priority=43)
		public void verifyTicketsPageForOrghasApostrophe()
		{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,Ticket);
			PageFactory.initElements(driver,EBPanel);
			String sTktsCountUser=null,sTicketOrg=null,sParentorg=null,sChildorg=null,sTicketCountEntity=null,sSubOrg=null;
			String sOrgNameTop=null;
			WebElement wTktExpander,wTicketOrg;
			boolean bTicketCountStatus,bTopOrgSlashstatus;
		
			try {
				FrameworkUtil.sTestCaseName ="verifyTicketsPageForOrghasApostrophe";
				FrameworkUtil.sManualTestCaseName="[QAT-391] WCP_4175_TC_1.0_Tickets_user should be able to view tickets when org name has apostrophe.";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
				sParentorg =(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.HOSTEDSOLUTIONS");
				sChildorg = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.COOPERSHAWK");
				sSubOrg = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.COOPER.COOPERSHAWK");
			    //Login to navigator with coopertest user
				LoginTestCase_Old1.LoginAsCoopertestUser();
				sOrgNameTop = EBPanel.getNav_OrgName().getText();
				
				/*if(!sOrgNameTop.contains("\\"))
				  {
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName,"Organization name at Top", "pass", "Organizaion name at top doesnt contain slash");     	 
				   }
					 
				else
				   {
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName,"Organization name at Top", "fail", "Organizaion name at top contain slash"); 
				   }*/
				bTopOrgSlashstatus = !sOrgNameTop.contains("\\");
				FrameworkUtil.updateCustomResultBasedOnStatus(bTopOrgSlashstatus, "Organizaion name at top has no slash");
				//Getting ticket count in home page
				sTktsCountUser = Ticket.getNav_TicketsCount().getText();
			    TicketTestCase.navigateToTicketPage();
			    
			    expandTicketAndverifyOrg(sChildorg);
			   
				//Logout from Navigator
				LoginTestCase_Old1.nav_Logout();
				
				//Login to navigator with ishannon user
				LoginTestCase_Old1.LoginAsIshannonUser();
				//Setting child to parent
				AdminTestCase.verifyOrg(sChildorg, sParentorg);
				//Logout from Navigator
				LoginTestCase_Old1.nav_Signout();
				
				//Login to navigator with Role-A user
				LoginTestCase_Old1.LoginAsRoleAUser();
				
				WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
				EntityBrowserTestCase.selectOrgFromAllLevelsEB(sSubOrg,"","","");
				WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
				WebObjectUtil.explicitWait(10);
				//Getting Ticket count in home page
				sTicketCountEntity = Ticket.getNav_TicketsCount().getText();
				
				bTicketCountStatus = sTktsCountUser.contentEquals(sTicketCountEntity);
				//Please pass status value from properties file.- by Priyanka 
				FrameworkUtil.updateCustomResultBasedOnStatus(bTicketCountStatus, "Tickets count for selected organization");
				
                TicketTestCase.navigateToTicketPage();
			    expandTicketAndverifyOrg(sChildorg); 
			    
			    //Going back to parent organization
			    WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			    WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			    WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			    EntityBrowserTestCase.setRollOnOffEBPanel(true);
			    
			    EntityBrowserTestCase.verifyTicketDataPresentForOrg(sSubOrg);
				//Logout from Navigator
				LoginTestCase_Old1.nav_Logout();
			
			   } catch (Exception e) {
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyTicketsPageForOrghasApostrophe", "warn", "catch block:" +e.getMessage());
			}
		}
		
		
		 /*==============================================================
		TestScript  	: verifyAdvanceoptionremovedinTicketsSearchDropdown
		Manual TestCase	: [QAT-182] WCP_4009_TC_1.0_Tickets: Advanced All search is removed
		Description		: 
		Author 			: QAA03
		Creation Date 	: 03/11/2016
		Release Name    : LefCourt-SP2
		Pre-Requisites	:
		Revision History:
	  ==============================================================*/
		
		@Test(priority=44)
		public void verifyAdvanceoptionremovedinTicketsSearchDropdown()
		{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,Ticket);
			
			int iRowCount=0;
			String sAdvanceSearch=null,sSearchitem=null;
			WebElement wSearchitem;
		
			try {
				FrameworkUtil.sTestCaseName = "verifyAdvanceoptionremovedinTicketsSearchDropdown";
				FrameworkUtil.sManualTestCaseName="[QAT-182] WCP_4009_TC_1.0_Tickets: Advanced All search is removed";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
				sAdvanceSearch =(String)FrameworkUtil.dictPropertyData.get("NAV.TICKETS.SEARCHDROPDOWN.ITEM");
				
			     //Login to navigator with Role-A user
				 LoginTestCase_Old1.LoginAsRoleAUser();
				
				 //Navigating to Tickets Page
				 WebObjectUtil.ClickAndMouseHover(Ticket.getNav_SupportTabLink());
				 WebObjectUtil.clickElement(Ticket.getNav_TicketsLink());
				 WebObjectUtil.explicitWait(5);
				 
				 //Clicking on Searchby Dropdown
				 WebObjectUtil.clickElement(Ticket.getNav_TicketSearchByDropdown());
				 
				 //Getting the list of elements under search dropdown
				 List<WebElement> wSearchitems = WebDriverUtil.getDriver().findElements(By.xpath("//ul[@class='x-list-plain']//li"));
				 //Size of list of elements under search dropdown
				 iRowCount = wSearchitems.size();
				 
				 //Verifying "Advance All" option not available under the search dropdown 
				 for(int i=1;i<=iRowCount;i++)
				{
					wSearchitem = WebObjectUtil.getWebElementFromDynamicLocator("xpath","NAV.COMMON.SEARCHDROPDOWN.ITEMS","PARAMETER_ROWNUMBER",i+"");
					sSearchitem = wSearchitem.getText();
					if(!sSearchitem.contains(sAdvanceSearch))
					   {
						   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName,"Tickets SearchDropdown", "pass", "Tickets SearchDropdown does not contain"+sAdvanceSearch);     	 
					   }
						 
					else
					   {
						   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName,"Tickets SearchDropdown", "fail", "Tickets SearchDropdown contain"+sAdvanceSearch); 
					   }
				}
							
				 //Logout from Navigator
				 LoginTestCase_Old1.nav_Logout();
			
			   } catch (Exception e) {
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAdvanceoptionremovedinTicketsSearchDropdown", "warn", "catch block:" +e.getMessage());
			}
		}
		
		
		
		/*====================================================================================================
		Method Name 	: expandTicketAndverifyOrg
		Description		: 
		Author 			: QAA03
		Creation Date 	: 03/01/2016
		Pre-Requisites	: 
		Revision History:
		====================================================================================================*/
		public static void expandTicketAndverifyOrg(String sOrgname)
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,EBPanel);
				WebElement wTktExpander,wTicketOrg;
				String sTicketOrg=null;
				boolean bOrgStatus;
					
		 try {
			    wTktExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
				WebObjectUtil.clickElement(wTktExpander);
				
				wTicketOrg = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER.ORGNAME", "PARAMETER_ROWNUMBER", 1 +"");                                                              
				sTicketOrg=wTicketOrg.getText();
				bOrgStatus = sTicketOrg.contentEquals(sOrgname); 
				FrameworkUtil.updateCustomResultBasedOnStatus(bOrgStatus, "Organization name in ticket and organization selected");
				WebObjectUtil.clickElement(wTktExpander); 			
			    
			 } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "expandTicketAndverifyOrg", "warn", "catch block:" +e.getMessage());  
			}
		 
		}
	
		/*====================================================================================================
		Method Name 	: verifyAddFirewallServiceTypefield
		Description		: Verifying Add Firewall Service Type Dropdown fields
		Author 			: QAA03
		Creation Date 	: 03/18/2016
		Pre-Requisites	: 
		Revision History:
		====================================================================================================*/
		public static void verifyAddFirewallServiceTypefield()
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,AddFirewall);
				//int iServiceTypeElements=0;
				WebElement wDropDown;
				String sULElementXpath=null,sProtocol=null,sServiceGroup=null;
		try {	
				
			 sULElementXpath = (String) FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
			 sProtocol = (String) FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.ADDFIREWALL.SERVICETYPEDROPDOWN.PROTOCOL");
			 sServiceGroup = (String) FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.ADDFIREWALL.SERVICETYPEDROPDOWN.SERVICEGROUP");
			 
			 WebObjectUtil.clickElement(AddFirewall.getNav_AddFirewallServiceTypeDropdown());
			 wDropDown=WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
			 //Getting the list of elements under search dropdown
			// List<WebElement> wServiceTypeitems = WebDriverUtil.getDriver().findElements(By.xpath("//ul[@class='x-list-plain']//li"));
			 //Size of list of elements under search dropdown
			// iServiceTypeElements = wServiceTypeitems.size();
			// String[] sServiceTypeElements = new String [iServiceTypeElements];
			String[] sServiceItems={sProtocol,sServiceGroup};
			
			 /*for(int i=0;i<iServiceTypeElements;i++)
			 {
				 wServiceTypeElements = WebObjectUtil.getWebElementFromDynamicLocator("xpath","NAV.COMMON.SEARCHDROPDOWN.ITEMS","PARAMETER_ROWNUMBER",(i+1)+""); 
				 sServiceTypeElement= wServiceTypeElements.getText();
				 sServiceTypeElements[i]=sServiceTypeElement;
			 }*/
			 AddFirewallRuleTestCase.validateWebListItems(wDropDown,sServiceItems);
			 WebObjectUtil.clickElement(AddFirewall.getNav_AddFirewallServiceTypeDropdown());
			 
			 // bServiceTypeStatus=sServiceTypeElements.contains("Protocol")&&sServiceTypeElements.contains("Service Group");
			// FrameworkUtil.updateCustomResultBasedOnStatus(bServiceTypeStatus, "Service Type Dropdown Elements");
			
			 } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAddFirewallServiceTypefield", "warn", "catch block:" +e.getMessage());  
			}
		 
		}
		/*====================================================================================================
		Method Name 	: selectandvalProtocolItemfromServiceTypedropdown
		Description		: Selecting "Protocol" from Add Firewall Service type drop down elements and verifying the status
		Author 			: QAA03
		Creation Date 	: 03/18/2016
		Pre-Requisites	: 
		Revision History:
		====================================================================================================*/
		public static void selectandvalProtocolItemfromServiceTypedropdown()
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,AddFirewall);
				
				String sULelement=null,sProtocol=null;
			    boolean bPortStatus;
			    
		 try {
			    sULelement = (String)FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
			    sProtocol = (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.ADDFIREWALL.SERVICETYPEDROPDOWN.PROTOCOL");
			    
			    WebObjectUtil.clickElement(AddFirewall.getNav_AddFirewallServiceTypeDropdown());
			    WebObjectUtil.selectCustomWebList(AddFirewall.getNav_AddFirewallServiceTypeDropdown(),sULelement,sProtocol,0);
			    
			    bPortStatus =AddFirewall.getNav_AddFirewallProtocolEdit().isEnabled()&& AddFirewall.getNav_AddFirewallPortEdit().isEnabled();
			    if(bPortStatus)
			    {
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName," "+sProtocol+" selected from service type dropdown", "pass", "Protocol and Protocol/port status is enabled");     	 
				}
					 
				else
				{
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName," "+sProtocol+" selected from service type dropdown", "fail", "Protocol and Protocol/port status is disabled"); 
				}
		     } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "selectandvalProtocolItemfromServiceTypedropdown", "warn", "catch block:" +e.getMessage());  
			}
		 
		}
	
		/*====================================================================================================
		Method Name 	: selectandvalICMPItemfromProtocoldropdown
		Description		: Selecting "ICMP" from Add Firewall Protocol type drop down elements and verifying the port status
		Author 			: QAA03
		Creation Date 	: 03/18/2016
		Pre-Requisites	: 
		Revision History:
		====================================================================================================*/
		public static void selectandvalICMPItemfromProtocoldropdown()
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,AddFirewall);
				
				String sULelement=null,sICMP=null;
			    boolean bPortStatus;
			    
		 try {
			    sULelement = (String)FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
			    sICMP = (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.ADDFIREWALL.PROTOCOL/PORTDROPDOWN.ICMP");
			    
			    WebObjectUtil.clickElement(AddFirewall.getNav_AddFirewallProtocolDropdown());
			    WebObjectUtil.selectCustomWebList(AddFirewall.getNav_AddFirewallProtocolDropdown(),sULelement,sICMP,0);
			    
			    bPortStatus = !AddFirewall.getNav_AddFirewallPortEdit().isEnabled();
			    if(bPortStatus)
			    {
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName," "+sICMP+" selected from Protocol dropdown", "pass", "port status is disabled as expected");     	 
				}
					 
				else
				{
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName," "+sICMP+" selected from Protocol dropdown", "fail", "port status"); 
				}
		     } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "selectandvalICMPItemfromProtocoldropdown", "warn", "catch block:" +e.getMessage());  
			}
		 
		}
		
		/*====================================================================================================
		Method Name 	: selectandvalTCPItemfromProtocoldropdown
		Description		: Selecting "TCP" from Add Firewall Protocol type drop down elements and verifying the status
		Author 			: QAA03
		Creation Date 	: 03/18/2016
		Pre-Requisites	: 
		Revision History:
		====================================================================================================*/
		public static void selectandvalTCPItemfromProtocoldropdown()
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,AddFirewall);
				
				String sULelement=null,sTCP=null;
			    boolean bPortStatus;
			    
		 try {
			    sULelement = (String)FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
			    sTCP = (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.ADDFIREWALL.PROTOCOL/PORTDROPDOWN.TCP");
			    
			    WebObjectUtil.clickElement(AddFirewall.getNav_AddFirewallProtocolDropdown());
			    WebObjectUtil.selectCustomWebList(AddFirewall.getNav_AddFirewallProtocolDropdown(),sULelement,sTCP,0);
			    
			    bPortStatus = AddFirewall.getNav_AddFirewallPortEdit().isEnabled();
			    if(bPortStatus)
			    {
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName," "+sTCP+" selected from Protocol dropdown", "pass", "Port status is enabled");     	 
				}
					 
				else
				{
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName," "+sTCP+" selected from Protocol dropdown", "fail", "Port status is disabled"); 
				}
		     } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "selectandverifyTCPfromProtocoldropdown", "warn", "catch block:" +e.getMessage());  
			}
		 
		}
		/*====================================================================================================
		Method Name 	: selectandvalUDPItemfromProtocoldropdown
		Description		: Selecting "UDP" from Add Firewall Protocol type drop down elements and verifying the status
		Author 			: QAA03
		Creation Date 	: 03/18/2016
		Pre-Requisites	: 
		Revision History:
		====================================================================================================*/
		public static void selectandvalUDPItemfromProtocoldropdown()
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,AddFirewall);
				
				String sULelement=null,sUDP=null;
			    boolean bPortStatus;
			    
		 try {
			    sULelement = (String)FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
			    sUDP = (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.ADDFIREWALL.PROTOCOL/PORTDROPDOWN.UDP");
			    
			    WebObjectUtil.clickElement(AddFirewall.getNav_AddFirewallProtocolDropdown());
			    WebObjectUtil.selectCustomWebList(AddFirewall.getNav_AddFirewallProtocolDropdown(),sULelement,sUDP,0);
			    
			    bPortStatus = AddFirewall.getNav_AddFirewallPortEdit().isEnabled();
			    if(bPortStatus)
			    {
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName," "+sUDP+" selected from Protocol dropdown", "pass", "Port status is enabled");     	 
				}
					 
				else
				{
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName," "+sUDP+" selected from Protocol dropdown", "fail", "Port status is disabled"); 
				}
		     } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "selectandvalUDPItemfromProtocoldropdown", "warn", "catch block:" +e.getMessage());  
			}
		 
		}
		/*====================================================================================================
		Method Name 	: selectandvalServiceGroupItemfromServiceType
		Description		: Selecting "Service Group" from Add Firewall Service type drop down elements and verifying the status
		Author 			: QAA03
		Creation Date 	: 03/18/2016
		Pre-Requisites	: 
		Revision History:
		====================================================================================================*/
		public static void selectandvalServiceGroupItemfromServiceTypedropdown()
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,AddFirewall);
				
				String sULelement=null,sServiceGroup=null;
			    boolean bPortStatus;
			    
		 try {
			    sULelement = (String)FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
			    sServiceGroup = (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.ADDFIREWALL.SERVICETYPEDROPDOWN.SERVICEGROUP");
			    
			    WebObjectUtil.clickElement(AddFirewall.getNav_AddFirewallServiceTypeDropdown());
			    WebObjectUtil.selectCustomWebList(AddFirewall.getNav_AddFirewallServiceTypeDropdown(),sULelement,"Service Group",0);
			    
			    bPortStatus = AddFirewall.getNav_AddFirewallProtocolEdit().isEnabled()&& !AddFirewall.getNav_AddFirewallPortEdit().isEnabled();
			    //Please use UpdateCustomResultBassedOnStatus method to avoid more lines of code-by priyanka
			    if(bPortStatus)
			    {
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, " "+sServiceGroup+" selected from Servicetype dropdown", "pass", "Protocol status is enabled and Port status is disabled as expected");     	 
				}
					 
				else
				{
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName," "+sServiceGroup+" selected from Servicetype dropdown", "fail", "Protocol status is disabled"); 
				}
		     } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "selectandvalServiceGroupItemfromServiceTypedropdown", "warn", "catch block:" +e.getMessage());  
			}
		 
		}
		/*====================================================================================================
		Method Name 	: selectandvalAnyItemfromDestinationdropdown
		Description		: Selecting "Any" from Add Firewall destination drop down elements and verifying the status
		Author 			: QAA03
		Creation Date 	: 03/21/2016
		Pre-Requisites	: 
		Revision History:
		====================================================================================================*/
		public static void selectandvalAnyItemfromDestinationdropdown()
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,AddFirewall);
				
				String sULelement=null,sDestAny=null;
			    boolean  bDestStatus;
			    
		 try {
			 
			    sULelement = (String)FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
			    sDestAny = (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.ADDFIREWALL.SOURCE/DESTINATIONDROPDOWN.ANY");
			    
			    WebObjectUtil.clickElement(AddFirewall.getNav_AddFirewallDestinationDropdown());
			    WebObjectUtil.selectCustomWebList(AddFirewall.getNav_AddFirewallDestinationDropdown(),sULelement,sDestAny,0);
			    
			    bDestStatus = !AddFirewall.getNav_AddFirewallDestIPEdit().isEnabled();
			  //Please use UpdateCustomResultBassedOnStatus method to avoid more lines of code-by Priyanka
			    if( bDestStatus)
			    {
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName," "+sDestAny+"field selected from Destination dropdown", "pass", "Destination field status is disabled as expected");     	 
				}
					 
				else
				{
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName," "+sDestAny+"field selected from Destination dropdown", "fail", "Destination field status"); 
				}
		     } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "selectandvalAnyItemfromDestinationdropdown", "warn", "catch block:" +e.getMessage());  
			}
		 
		}
		/*====================================================================================================
		Method Name 	: selectandvalHostItemfromDestinationdropdown
		Description		: Selecting "Host" from Add Firewall destination drop down elements and verifying the status
		Author 			: QAA03
		Creation Date 	: 03/21/2016
		Pre-Requisites	: 
		Revision History:
		====================================================================================================*/
		public static void selectandvalHostItemfromDestinationdropdown()
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,AddFirewall);
				
				String sULelement=null,sDestHost=null;
			    boolean  bDestStatus;
			    
		 try {
			    sULelement = (String)FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
			    sDestHost = (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.ADDFIREWALL.SOURCE/DESTINATIONDROPDOWN.HOST");
			    
			    WebObjectUtil.clickElement(AddFirewall.getNav_AddFirewallDestinationDropdown());
			    WebObjectUtil.selectCustomWebList(AddFirewall.getNav_AddFirewallDestinationDropdown(),sULelement,sDestHost,0);
			    
			    bDestStatus = AddFirewall.getNav_AddFirewallDestIPEdit().isEnabled();
			  //Please use UpdateCustomResultBassedOnStatus method to avoid more lines of code-by Priyanka
			    if( bDestStatus)
			    {
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName," "+sDestHost+"field selected from Destination dropdown", "pass", "Destination field status is enabled");     	 
				}
					 
				else
				{
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName," "+sDestHost+"field selected from Destination dropdown", "fail", "Destination field status is disabled"); 
				}
		     } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "selectandvalHostItemfromDestinationdropdown", "warn", "catch block:" +e.getMessage());  
			}
		 
		}
		
		/*====================================================================================================
		Method Name 	: selectandvalNetworkItemfromDestinationdropdown
		Description		: Selecting "Network" from Add Firewall destination drop down elements and verifying the status
		Author 			: QAA03
		Creation Date 	: 03/21/2016
		Pre-Requisites	: 
		Revision History:
		====================================================================================================*/
		public static void selectandvalNetworkItemfromDestinationdropdown()
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,AddFirewall);
				
				String sULelement=null,sDestNetwork=null;
			    boolean  bDestStatus;
			    
		 try {
			    sULelement = (String)FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
			    sDestNetwork = (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.ADDFIREWALL.SOURCE/DESTINATIONDROPDOWN.NETWORK");
			    
			    WebObjectUtil.clickElement(AddFirewall.getNav_AddFirewallDestinationDropdown());
			    WebObjectUtil.selectCustomWebList(AddFirewall.getNav_AddFirewallDestinationDropdown(),sULelement,sDestNetwork,0);
			    
			    bDestStatus = AddFirewall.getNav_AddFirewallDestIPEdit().isEnabled()&&AddFirewall.getNav_AddFirewallDestMaskEdit().isEnabled();
			  //Please use UpdateCustomResultBassedOnStatus method to avoid more lines of code-by Priyanka
			    if( bDestStatus)
			    {
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName," "+sDestNetwork+"field selected from Destination dropdown", "pass", "Destination field and Subnet mask status is enabled");     	 
				}
					 
				else
				{
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName," "+sDestNetwork+"field selected from Destination dropdown", "fail", "Destination field and Subnet mask status is disabled"); 
				}
		     } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "selectandvalNetworkItemfromDestinationdropdown", "warn", "catch block:" +e.getMessage());  
			}
		 
		}
		/*====================================================================================================
		Method Name 	: selectandvalObjectItemfromDestinationdropdown
		Description		: Selecting "Object" from Add Firewall Destination drop down elements and verifying the status
		Author 			: QAA03
		Creation Date 	: 03/21/2016
		Pre-Requisites	: 
		Revision History:
		====================================================================================================*/
		public static void selectandvalObjectItemfromDestinationdropdown()
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,AddFirewall);
				
				String sULelement=null,sDestObject=null;
			    boolean  bDestStatus;
			    
		 try {
			    sULelement = (String)FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
			    sDestObject = (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.ADDFIREWALL.SOURCE/DESTINATIONDROPDOWN.OBJECT");
			    
			    WebObjectUtil.clickElement(AddFirewall.getNav_AddFirewallDestinationDropdown());
			    WebObjectUtil.selectCustomWebList(AddFirewall.getNav_AddFirewallDestinationDropdown(),sULelement,sDestObject,0);
			    
			    bDestStatus = AddFirewall.getNav_AddFirewallDestIPEdit().isEnabled();
			  //Please use UpdateCustomResultBassedOnStatus method to avoid more lines of code-by Priyanka
			    if( bDestStatus)
			    {
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName," "+sDestObject+"field selected from Destination dropdown", "pass", "Destination field status is enabled");     	 
				}
					 
				else
				{
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName," "+sDestObject+"field selected from Destination dropdown", "fail", "Destination field status is disabled"); 
				}
		     } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "selectandvalObjectItemfromDestinationdropdown", "warn", "catch block:" +e.getMessage());  
			}
		 
		}
		/*====================================================================================================
		Method Name 	: selectandvalGroupObjectItemfromDestinationdropdown
		Description		: Selecting "Group Object" from Add Firewall Destination drop down elements and verifying the status
		Author 			: QAA03
		Creation Date 	: 03/21/2016
		Pre-Requisites	: 
		Revision History:
		====================================================================================================*/
		public static void selectandvalGroupObjectItemfromDestinationdropdown()
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,AddFirewall);
				
				String sULelement=null,sDestGroupObject=null;
			    boolean  bDestStatus;
			    
		 try {
			    sULelement = (String)FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
			    sDestGroupObject = (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.ADDFIREWALL.SOURCE/DESTINATIONDROPDOWN.GROUPOBJECT");
			    
			    WebObjectUtil.clickElement(AddFirewall.getNav_AddFirewallDestinationDropdown());
			    WebObjectUtil.selectCustomWebList(AddFirewall.getNav_AddFirewallDestinationDropdown(),sULelement,sDestGroupObject,0);
			    
			    bDestStatus = AddFirewall.getNav_AddFirewallDestIPEdit().isEnabled();
			  //Please use UpdateCustomResultBassedOnStatus method to avoid more lines of code-by Priyanka
			    if(bDestStatus)
			    {
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName," "+sDestGroupObject+"field selected from Destination dropdown", "pass", "Destination field status is enabled");     	 
				}
					 
				else
				{
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName," "+sDestGroupObject+"field selected from Destination dropdown", "fail", "Destination field status is disabled"); 
				}
		     } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "selectandvalGroupObjectItemfromDestinationdropdown", "warn", "catch block:" +e.getMessage());  
			}
		 
		}
		/*====================================================================================================
		Method Name 	: selectandvalAnyItemfromSourcedropdown
		Description		: Selecting "Any" from Add Firewall Source drop down elements and verifying the status
		Author 			: QAA03
		Creation Date 	: 03/21/2016
		Pre-Requisites	: 
		Revision History:
		====================================================================================================*/
		public static void selectandvalAnyItemfromSourcedropdown()
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,AddFirewall);
				
				String sULelement=null,sSourceAny=null;
			    boolean  bSourceStatus;
			    
		 try {
			 
			    sULelement = (String)FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
			    sSourceAny = (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.ADDFIREWALL.SOURCE/DESTINATIONDROPDOWN.ANY");
			    
			    WebObjectUtil.clickElement(AddFirewall.getNav_AddFirewallSourceDropdown());
			    WebObjectUtil.selectCustomWebList(AddFirewall.getNav_AddFirewallSourceDropdown(),sULelement,sSourceAny,0);
			    
			    bSourceStatus = !AddFirewall.getNav_AddFirewallSourceIPEdit().isEnabled();
			  //Please use UpdateCustomResultBassedOnStatus method to avoid more lines of code-by Priyanka
			    if( bSourceStatus)
			    {
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName," "+sSourceAny+"field selected from Source dropdown", "pass", "Source field status is disabled as expected");     	 
				}
					 
				else
				{
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName," "+sSourceAny+"field selected from Source dropdown", "fail", "Source field status"); 
				}
		     } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "selectandvalAnyItemfromSourcedropdown", "warn", "catch block:" +e.getMessage());  
			}
		 
		}
		/*====================================================================================================
		Method Name 	: selectandvalHostItemfromSourcedropdown
		Description		: Selecting "Host" from Add Firewall Source drop down elements and verifying the status
		Author 			: QAA03
		Creation Date 	: 03/21/2016
		Pre-Requisites	: 
		Revision History:
		====================================================================================================*/
		public static void selectandvalHostItemfromSourcedropdown()
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,AddFirewall);
				
				String sULelement=null,sSourceHost=null;
			    boolean  bSourceStatus;
			    
		 try {
			    sULelement = (String)FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
			    sSourceHost = (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.ADDFIREWALL.SOURCE/DESTINATIONDROPDOWN.HOST");
			    
			    WebObjectUtil.clickElement(AddFirewall.getNav_AddFirewallSourceDropdown());
			    WebObjectUtil.selectCustomWebList(AddFirewall.getNav_AddFirewallSourceDropdown(),sULelement,sSourceHost,0);
			    
			    bSourceStatus = AddFirewall.getNav_AddFirewallSourceIPEdit().isEnabled();
			  //Please use UpdateCustomResultBassedOnStatus method to avoid more lines of code-by Priyanka
			    if( bSourceStatus)
			    {
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName," "+sSourceHost+"field selected from Source dropdown", "pass", "Destination field status is enabled");     	 
				}
					 
				else
				{
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName," "+sSourceHost+"field selected from Source dropdown", "fail", "Destination field status is disabled"); 
				}
		     } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "selectandvalHostItemfromSourcedropdown", "warn", "catch block:" +e.getMessage());  
			}
		 
		}
		
		/*====================================================================================================
		Method Name 	: selectandvalNetworkItemfromSourcedropdown
		Description		: Selecting "Network" from Add Firewall Source drop down elements and verifying the status
		Author 			: QAA03
		Creation Date 	: 03/21/2016
		Pre-Requisites	: 
		Revision History:
		====================================================================================================*/
		public static void selectandvalNetworkItemfromSourcedropdown()
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,AddFirewall);
				
				String sULelement=null,sSourceNetwork=null;
			    boolean  bSourceStatus;
			    
		 try {
			    sULelement = (String)FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
			    sSourceNetwork = (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.ADDFIREWALL.SOURCE/DESTINATIONDROPDOWN.NETWORK");
			    
			    WebObjectUtil.clickElement(AddFirewall.getNav_AddFirewallSourceDropdown());
			    WebObjectUtil.selectCustomWebList(AddFirewall.getNav_AddFirewallSourceDropdown(),sULelement,sSourceNetwork,0);
			    
			    bSourceStatus = AddFirewall.getNav_AddFirewallSourceIPEdit().isEnabled()&&AddFirewall.getNav_AddFirewallSourceMaskEdit().isEnabled();
			  //Please use UpdateCustomResultBassedOnStatus method to avoid more lines of code-by Priyanka
			    if( bSourceStatus)
			    {
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName," "+sSourceNetwork+"field selected from Source dropdown", "pass", "Source field and Subnet mask status is enabled");     	 
				}
					 
				else
				{
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName," "+sSourceNetwork+"field selected from Source dropdown", "fail", "Source field and Subnet mask status is disabled"); 
				}
		     } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "selectandvalNetworkItemfromSourcedropdown", "warn", "catch block:" +e.getMessage());  
			}
		 
		}
		/*====================================================================================================
		Method Name 	: selectandvalObjectItemfromSourcedropdown
		Description		: Selecting "Object" from Add Firewall Source drop down elements and verifying the status
		Author 			: QAA03
		Creation Date 	: 03/21/2016
		Pre-Requisites	: 
		Revision History:
		====================================================================================================*/
		public static void selectandvalObjectItemfromSourcedropdown()
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,AddFirewall);
				
				String sULelement=null,sSourceObject=null;
			    boolean  bSourceStatus;
			    
		 try {
			    sULelement = (String)FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
			    sSourceObject = (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.ADDFIREWALL.SOURCE/DESTINATIONDROPDOWN.OBJECT");
			    
			    WebObjectUtil.clickElement(AddFirewall.getNav_AddFirewallSourceDropdown());
			    WebObjectUtil.selectCustomWebList(AddFirewall.getNav_AddFirewallSourceDropdown(),sULelement,sSourceObject,0);
			    
			    bSourceStatus = AddFirewall.getNav_AddFirewallSourceIPEdit().isEnabled();
			  //Please use UpdateCustomResultBassedOnStatus method to avoid more lines of code-by Priyanka
			    if( bSourceStatus)
			    {
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName," "+sSourceObject+"field selected from Source dropdown", "pass", "Source field status is enabled");     	 
				}
					 
				else
				{
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName," "+sSourceObject+"field selected from Source dropdown", "fail", "Source field status is disabled"); 
				}
		     } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "selectandvalObjectItemfromSourcedropdown", "warn", "catch block:" +e.getMessage());  
			}
		 
		}
		/*====================================================================================================
		Method Name 	: selectandvalGroupObjectItemfromSourcedropdown
		Description		: Selecting "Group Object" from Add Firewall Source drop down elements and verifying the status
		Author 			: QAA03
		Creation Date 	: 03/21/2016
		Pre-Requisites	: 
		Revision History:
		====================================================================================================*/
		public static void selectandvalGroupObjectItemfromSourcedropdown()
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,AddFirewall);
				
				String sULelement=null,sSourceGroupObject=null;
			    boolean  bSourceStatus;
			    
		 try {
			    sULelement = (String)FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
			    sSourceGroupObject = (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.ADDFIREWALL.SOURCE/DESTINATIONDROPDOWN.GROUPOBJECT");
			    
			    WebObjectUtil.clickElement(AddFirewall.getNav_AddFirewallSourceDropdown());
			    WebObjectUtil.selectCustomWebList(AddFirewall.getNav_AddFirewallSourceDropdown(),sULelement,sSourceGroupObject,0);
			    
			    bSourceStatus = AddFirewall.getNav_AddFirewallSourceIPEdit().isEnabled();
			  //Please use UpdateCustomResultBassedOnStatus method to avoid more lines of code-by Priyanka
			    if(bSourceStatus)
			    {
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName," "+sSourceGroupObject+"field selected from Source dropdown", "pass", "Source field status is enabled");     	 
				}
					 
				else
				{
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName," "+sSourceGroupObject+"field selected from Source dropdown", "fail", "Source field status is disabled"); 
				}
		     } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "selectandvalGroupObjectItemfromSourcedropdown", "warn", "catch block:" +e.getMessage());  
			}
		 
		}
		/*====================================================================================================
		Method Name 	: verifyAddFirewallSourceTypefield
		Description		: Verifying Add Firewall Source Type Dropdown fields
		Author 			: QAA03
		Creation Date 	: 03/18/2016
		Pre-Requisites	: 
		Revision History:
		====================================================================================================*/
		public static void verifyAddFirewallSourceTypefield()
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,AddFirewall);
				
				WebElement wDropDown;
				String sULElementXpath=null,sAny=null,sHost=null,sNetwork=null,sObject=null,sGroupObject=null;
				/*List<String> sServiceTypeElements = new ArrayList<String>();
				boolean bServiceTypeStatus;*/
				
		 try {
             sULElementXpath = (String)FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
             sAny = (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.ADDFIREWALL.SOURCE/DESTINATIONDROPDOWN.ANY");
             sHost = (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.ADDFIREWALL.SOURCE/DESTINATIONDROPDOWN.HOST");
             sNetwork = (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.ADDFIREWALL.SOURCE/DESTINATIONDROPDOWN.NETWORK");
             sObject = (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.ADDFIREWALL.SOURCE/DESTINATIONDROPDOWN.OBJECT");
             sGroupObject = (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.ADDFIREWALL.SOURCE/DESTINATIONDROPDOWN.GROUPOBJECT");
             
             WebObjectUtil.clickElement(AddFirewall.getNav_AddFirewallSourceDropdown());
			 wDropDown=WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
			 
			
			 //Getting the list of elements under search dropdown
			// List<WebElement> wServiceTypeitems = WebDriverUtil.getDriver().findElements(By.xpath("//ul[@class='x-list-plain']//li"));
			 //Size of list of elements under search dropdown
			// iServiceTypeElements = wServiceTypeitems.size();
			 String[] sSourceItems={sAny,sHost,sNetwork,sObject,sGroupObject};
			/* for(int i=1;i<=iServiceTypeElements;i++)
			 {
				 wServiceTypeElements = WebObjectUtil.getWebElementFromDynamicLocator("xpath","NAV.COMMON.SEARCHDROPDOWN.ITEMS","PARAMETER_ROWNUMBER",i+""); 
				 sServiceTypeElement= wServiceTypeElements.getText();
				 sServiceTypeElements.add(sServiceTypeElement);
				 
			 }*/
			 AddFirewallRuleTestCase.validateWebListItems(wDropDown, sSourceItems);
			 WebObjectUtil.clickElement(AddFirewall.getNav_AddFirewallSourceDropdown());
			/* bServiceTypeStatus=sServiceTypeElements.contains("Protocol")&&sServiceTypeElements.contains("Service Group");
			 FrameworkUtil.updateCustomResultBasedOnStatus(bServiceTypeStatus, "Service Type Dropdown Elements");*/
			
			 } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAddFirewallSourceTypefield", "warn", "catch block:" +e.getMessage());  
			}
		 
		}
		/*====================================================================================================
		Method Name 	: verifyAddFirewallDestinationTypefield
		Description		: Verifying Add Firewall Destination Type Dropdown fields
		Author 			: QAA03
		Creation Date 	: 03/18/2016
		Pre-Requisites	: 
		Revision History:
		====================================================================================================*/
		public static void verifyAddFirewallDestinationTypefield()
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,AddFirewall);
				//int iServiceTypeElements=0;
				WebElement wDropDown;
				String sULElementXpath=null,sAny=null,sHost=null,sNetwork=null,sObject=null,sGroupObject=null;
				/*List<String> sServiceTypeElements = new ArrayList<String>();
				boolean bServiceTypeStatus;*/
				
		 try {
			 sULElementXpath = (String) FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
			 sAny = (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.ADDFIREWALL.SOURCE/DESTINATIONDROPDOWN.ANY");
             sHost = (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.ADDFIREWALL.SOURCE/DESTINATIONDROPDOWN.HOST");
             sNetwork = (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.ADDFIREWALL.SOURCE/DESTINATIONDROPDOWN.NETWORK");
             sObject = (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.ADDFIREWALL.SOURCE/DESTINATIONDROPDOWN.OBJECT");
             sGroupObject = (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.ADDFIREWALL.SOURCE/DESTINATIONDROPDOWN.GROUPOBJECT");
             
			 WebObjectUtil.clickElement(AddFirewall.getNav_AddFirewallDestinationDropdown());
			 wDropDown=WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
			 
			 //Getting the list of elements under search dropdown
			 List<WebElement> wServiceTypeitems = WebDriverUtil.getDriver().findElements(By.xpath("//ul[@class='x-list-plain']//li"));
			 //Size of list of elements under search dropdown
			// iServiceTypeElements = wServiceTypeitems.size();
			 String[] sDestinationItems={sAny,sHost,sNetwork,sObject,sGroupObject};
			 /*for(int i=1;i<=iServiceTypeElements;i++)
			 {
				 wServiceTypeElements = WebObjectUtil.getWebElementFromDynamicLocator("xpath","NAV.COMMON.SEARCHDROPDOWN.ITEMS","PARAMETER_ROWNUMBER",i+""); 
				 sServiceTypeElement= wServiceTypeElements.getText();
				 sServiceTypeElements.add(sServiceTypeElement);
			 }*/
			 AddFirewallRuleTestCase.validateWebListItems(wDropDown,sDestinationItems);
			 WebObjectUtil.clickElement(AddFirewall.getNav_AddFirewallDestinationDropdown());
			/* bServiceTypeStatus=sServiceTypeElements.contains("Protocol")&&sServiceTypeElements.contains("Service Group");
			 FrameworkUtil.updateCustomResultBasedOnStatus(bServiceTypeStatus, "Service Type Dropdown Elements");
			*/
			 } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAddFirewallDestinationTypefield", "warn", "catch block:" +e.getMessage());  
			}
		 
		}
		
		/*====================================================================================================
		Method Name 	: verifyAddFirewallfields
		Description		: Verifying Add Firewall fields
		Author 			: QAA03
		Creation Date 	: 03/23/2016
		Pre-Requisites	: 
		Revision History:
		====================================================================================================*/
		public static void verifyAddFirewallfields()
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,AddFirewall);
				
				
		 try {
			 //Please add appropriate comments for the following code
			 //Verifying all the fields in add firewall window
			    WebObjectUtil.verifyElementPresent(AddFirewall.getNav_AddFirewallSeqNumEdit());
				WebObjectUtil.verifyElementPresent(AddFirewall.getNav_AddFirewallSourceTypeEdit());
				WebObjectUtil.verifyElementPresent(AddFirewall.getNav_AddFirewallSourceIPEdit());
				WebObjectUtil.verifyElementPresent(AddFirewall.getNav_AddFirewallDestTypeEdit());
				WebObjectUtil.verifyElementPresent(AddFirewall.getNav_AddFirewallDestIPEdit());
				WebObjectUtil.verifyElementPresent(AddFirewall.getNav_AddFirewallServiceTypeEdit());
				WebObjectUtil.verifyElementPresent(AddFirewall.getNav_AddFirewallProtocolEdit());
				WebObjectUtil.verifyElementPresent(AddFirewall.getNav_AddFirewallAction());
				WebObjectUtil.verifyElementPresent(AddFirewall.getNav_AddFirewallStatus());
				WebObjectUtil.verifyElementPresent(AddFirewall.getNav_SaveFirewallRuleButton());
				WebObjectUtil.verifyElementPresent(AddFirewall.getNav_AddFirewallCancelButton());
			 
			 } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAddFirewallfields", "warn", "catch block:" +e.getMessage());  
			}
		 
		}
	
	@AfterMethod
	public static void afterEachMethod(){
			FrameworkUtil.updateTestCaseStatusinResult();
			
		}

}
