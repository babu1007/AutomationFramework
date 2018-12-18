package com.whs.navigator.testcases.Keffer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.Page;
import com.whs.navigator.commonUtil.CustomWebElementUtil;
import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.commonUtil.WebTableUtil;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.EVDC_VM_PageFactory;
import com.whs.navigator.pagefactory.EntityBrowserPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.TicketPageFactory;

public class KefferTestCase_NMR {

	public static EntityBrowserPageFactory Entity = new EntityBrowserPageFactory();
	public static EVDC_OverviewPageFactory EVDC_Overview=new EVDC_OverviewPageFactory();
	public static EVDC_VM_PageFactory EVDC_VMPF=new EVDC_VM_PageFactory();
	public static HomePageFactory_old Home=new HomePageFactory_old();
	public static TicketPageFactory Ticket = new TicketPageFactory();
 
	
/*==============================================================
TestScript 		: verifyOrganizationColumnUnderEntity02Org
Manual TestCase	: QAT-382
Description		: Verify the tickets displayed are for tst entity 02 and tst entity03
Author 			: QAA04
Creation Date 	: 12/28/2015
Release Name    : Keffer
Pre-Requisites	:
Revision History:
==============================================================*/	
@Test(priority=61)
 public void verifyOrganizationColumnUnderEntity02Org() {
	 String sTestEntity1,sTestEntity2,sTestEntity3;
	 WebDriver driver = WebDriverUtil.getDriver();
	 PageFactory.initElements(driver, Entity);
	
	 try { 
	 FrameworkUtil.sTestCaseName="verifyOrganizationColumnUnderEntity02Org";
	 FrameworkUtil.sManualTestCaseName="(QAT-382)Keffer - Verify the tickets displayed are for tst entity 02 and tst entity03 org";
	 FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
      
	 //set the child and parent entity with admin user
	 AdminTestCase.verifyTstEntityParentChildHierarchy();
	 
	 // Login to navigator with rola-a user
	 LoginTestCase_Old1.LoginAsRoleAUser();
	 
	 sTestEntity1 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
	 sTestEntity2 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY02");
	 sTestEntity3 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY03");

	
	 WebObjectUtil.clickElement(Entity.getNav_EntityBrowserLink());
	 // selecting the org from entity browser 
	 EntityBrowserTestCase.selectOrgFromAllLevelsEB(sTestEntity1,sTestEntity2, null, null);
	 WebObjectUtil.clickElement(Entity.getNav_EBPanelRollUpButton());
	 WebObjectUtil.clickElement(Entity.getNav_OrgNameTitleLink());
	 // Navigating to the ticket page
	 TicketTestCase.navigateToTicketPage();
	 // verifying the Organization column entity 
	 String sOrgNames ="TST Entity02,TST Entity03";
	 verifyEntityUnderOrganizationColumn(sOrgNames);
	 
	 
	 // log out
	 LoginTestCase_Old1.nav_Logout();
	 }
	 catch(Exception e) {
		 LoggerUtil.log_type_error("Issue with verifyOrganizationColumnUnderEntity02Org test case");
		 LoggerUtil.log_type_error("Exception occured " + e.getMessage());
		 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage());
	 }
 }
 

/*==============================================================
TestScript 		: verifyOrganizationColumnUnderEntity01Org
Manual TestCase	: QAT-378
Description		: Verify the tickets displayed are for tst entity 01 and tst entity02
Author 			: QAA04
Creation Date 	: 12/28/2015
Release Name    : Keffer
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=62)
public  void verifyOrganizationColumnUnderEntity01Org() {
	String sTestEntity1,sTestEntity2,sTestEntity3;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, Entity);
	 
	try {
	FrameworkUtil.sTestCaseName ="verifyOrganizationColumnUnderEntity01Org";
	FrameworkUtil.sManualTestCaseName = "(QAT-378)Keffer - Verify the tickets displayed are for tst entity 01 and tst entity02";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	 
	//set the child and parent entity with admin user
	 AdminTestCase.verifyTstEntityParentChildHierarchy();
	 
	 // Login to navigator with rola-a user
	 LoginTestCase_Old1.LoginAsRoleAUser();
	 
	 sTestEntity1 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
	 sTestEntity2 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY02");
	 sTestEntity3 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY03");

	
	
	 WebObjectUtil.clickElement(Entity.getNav_EntityBrowserLink());
	 // selecting the org from entity browser 
	 EntityBrowserTestCase.selectOrgFromAllLevelsEB(sTestEntity1,null, null, null);
	 WebObjectUtil.clickElement(Entity.getNav_EBPanelRollUpButton());
	 WebObjectUtil.clickElement(Entity.getNav_OrgNameTitleLink());
	 // Navigating to the ticket page
	 TicketTestCase.navigateToTicketPage();
	 // verifying the Organization column entity 
	 String sOrgNames ="TST Entity01,TST Entity02";
	 verifyEntityUnderOrganizationColumn(sOrgNames);
	 
	 // log out
	 LoginTestCase_Old1.nav_Logout();
	 }
	 catch(Exception e) {
		 LoggerUtil.log_type_error("Issue with verifyOrganizationColumnUnderEntity01Org test case");
		 LoggerUtil.log_type_error("Exception occured " + e.getMessage());
		 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage());
	 }
	
}

/*==============================================================
TestScript 		: verifyOpenWorkingPendingResolvedTicketsAfterRollOn
Manual TestCase	: QAT-375,QAT-376,QAT-374,QAT-351
Description		: Verify the open working pending outstanding ticket counts in outstanding state, and verify the pdf and csv icons
Author 			: QAA04
Creation Date 	: 12/30/2015
Release Name    : Keffer
Pre-Requisites	:
Revision History:
==============================================================*/	
@Test(priority=63)
public void verifyOpenWorkingPendingResolvedTicketsAfterRollOn() {
	     String sTestEntity1,sTestEntity2,sTestEntity3;
	     boolean bPDFIcon,bCSVIcon;
	     WebDriver driver = WebDriverUtil.getDriver();
		 PageFactory.initElements(driver, Entity);
		 PageFactory.initElements(driver, Ticket);
		
		 try { 
		 FrameworkUtil.sTestCaseName="verifyOpenWorkingPendingResolvedTicketsForTwoStates";
		 FrameworkUtil.sManualTestCaseName="(QAT-376),(QAT-375),(QAT-374) and (QAT-351) Keffer - Verify the open working pending outstanding ticket counts in outstanding, closed less then 6 months state and verify the pdf and csv icons";
		 FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		  
		 //set the child and parent entity with admin user
		 AdminTestCase.verifyTstEntityParentChildHierarchy();
		 
		 // Login to navigator with rola-a user
		 LoginTestCase_Old1.LoginAsRoleAUser();
		 
		 sTestEntity1 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
		 sTestEntity2 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY02");
		 sTestEntity3 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY03");

		
		 WebObjectUtil.clickElement(Entity.getNav_EntityBrowserLink());
		 // selecting the org from entity browser 
		 EntityBrowserTestCase.selectOrgFromAllLevelsEB(sTestEntity1,sTestEntity2, null, null);
		 WebObjectUtil.clickElement(Entity.getNav_EBPanelRollUpButton());
		 WebObjectUtil.clickElement(Entity.getNav_OrgNameTitleLink());
		 // Navigating to the ticket page
		 TicketTestCase.navigateToTicketPage();
		 // verifying the Organization column entity 
		 String sOrgNames ="TST Entity02,TST Entity03";
		 verifyEntityUnderOrganizationColumn(sOrgNames);
		 
		 // verifying the pdf and csv icons 
			bPDFIcon = Ticket.getNav_TicketsPdfIcon().getAttribute("src").contains("PDF");
			FrameworkUtil.updateCustomResultBasedOnStatus(bPDFIcon, "verifying the PDF icon");
			
			bCSVIcon = Ticket.getNav_TicketsCsvIcon().getAttribute("src").contains("CSV");
			FrameworkUtil.updateCustomResultBasedOnStatus(bCSVIcon, "verifying the CSV icon");
		
 
		 // verifying the outstanding state open,pending,working,resolved tickets counts 
			KefferTestCase_Arul.verifyTicketCountAfterRollOn(sTestEntity1+","+sTestEntity2,Ticket.getNav_Outstanding());
 		 
			 // verifying the closed less then 6 months state open,pending,working,resolved tickets counts 
			KefferTestCase_Arul.verifyTicketCountAfterRollOn(sTestEntity1+","+sTestEntity2,Ticket.getNav_ClosedLess());
			
			 // verifying the closed more then 6 months state open,pending,working,resolved tickets counts 
			KefferTestCase_Arul.verifyTicketCountAfterRollOn(sTestEntity1+","+sTestEntity2,Ticket.getNav_ClosedMore());
		 // log out
		 LoginTestCase_Old1.nav_Logout();
 }
 catch(Exception e) {
	 LoggerUtil.log_type_error("Issue with verifyOpenWorkingPendingResolvedTicketsInOutstandingState test case");
	 LoggerUtil.log_type_error("Exception occured " + e.getMessage());
	 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage());
 }
}
/*==============================================================
TestScript 		: verifyPDFandCSVIconsForClosedlessThenState
Manual TestCase	: QAT-373
Description		: Verify the pdf and csv icons in closed less then 6 months state
Author 			: QAA04
Creation Date 	: 12/30/2015
Release Name    : Keffer
Pre-Requisites	:
Revision History:

==============================================================*/	
@Test(priority=64)
public void verifyPDFandCSVIconsForClosedlessThenState() {
	    String sTestEntity1,sTestEntity2,sTestEntity3;
		 WebDriver driver = WebDriverUtil.getDriver();
		 PageFactory.initElements(driver, Entity);
		 PageFactory.initElements(driver, Ticket);
		
		 boolean bPDFIcon,bCSVIcon;
		 try { 
		 FrameworkUtil.sTestCaseName="verifyPDFandCSVIconsForClosedlessThenState";
		 FrameworkUtil.sManualTestCaseName="(QAT-373)Keffer - Verify the pdf and csv icons in closed less then 6 months state";
		 FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		  
		 //set the child and parent entity with admin user
		 AdminTestCase.verifyTstEntityParentChildHierarchy();
		 
		 // Login to navigator with rola-a user
		 LoginTestCase_Old1.LoginAsRoleAUser();
		
		 sTestEntity1 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
		 sTestEntity2 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY02");
		 sTestEntity3 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY03");

		
		 WebObjectUtil.clickElement(Entity.getNav_EntityBrowserLink());
		 
		 // selecting the org from entity browser 
		 EntityBrowserTestCase.selectOrgFromAllLevelsEB(sTestEntity1,sTestEntity2, null, null);
		 WebObjectUtil.clickElement(Entity.getNav_EBPanelRollUpButton());
		 WebObjectUtil.clickElement(Entity.getNav_OrgNameTitleLink());
		 
		 // Navigating to the ticket page
		 TicketTestCase.navigateToTicketPage();
		 
		 // verifying the Organization column entity 
		 String sOrgNames ="TST Entity02,TST Entity03";
		 verifyEntityUnderOrganizationColumn(sOrgNames);
		 
		 // selecting closed less then 6 months from organization drop down
		 WebObjectUtil.clickElement(Ticket.getNav_TicketOutstandingList());
		 WebObjectUtil.selectCustomWebList(Ticket.getNav_TicketOutstandingDropdown(), "Closed (Less than 6 months)");
		 
		 // verifying the pdf and csv icons 
		bPDFIcon = Ticket.getNav_TicketsPdfIcon().getAttribute("src").contains("PDF");
		FrameworkUtil.updateCustomResultBasedOnStatus(bPDFIcon, "verifying the PDF icon");
		
		bCSVIcon = Ticket.getNav_TicketsCsvIcon().getAttribute("src").contains("CSV");
		FrameworkUtil.updateCustomResultBasedOnStatus(bCSVIcon, "verifying the CSV icon");
		
		
		 
// log out
 LoginTestCase_Old1.nav_Logout();
 }
 catch(Exception e) {
	 LoggerUtil.log_type_error("Issue with verifyPDFandCSVIconsForClosedlessThenState test case");
	 LoggerUtil.log_type_error("Exception occured " + e.getMessage());
	 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage());
 }
}

/*==============================================================
TestScript 		: navCreateTicketUnderTestEntity03
Manual TestCase	: QAT-364
Description		: Create a ticket under tst Entity 03 org
Author 			: QAA04
Creation Date 	: 01/04/2016
Release Name    : Keffer
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=65)
public void navCreateTicketUnderTestEntity03() {
	String sOrgNames,sTestEntity1,sTestEntity2,sTestEntity3;
	WebElement wExpander;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, Entity);
	PageFactory.initElements(driver, Ticket);
	try {
	FrameworkUtil.sTestCaseName="navCreateTicketUnderTestEntity03";
	FrameworkUtil.sManualTestCaseName="(QAT-364) Keffer - Create a ticket under tst Entity 03 org";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);

	 //set the child and parent entity with admin user
	 AdminTestCase.verifyTstEntityParentChildHierarchy();
	 
	 // Login to navigator with rola-a user
	 LoginTestCase_Old1.LoginAsRoleAUser();
	 
	 sTestEntity1 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
	 sTestEntity2 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY02");
	 sTestEntity3 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY03");

	 WebObjectUtil.clickElement(Entity.getNav_EntityBrowserLink());
	  
	 // selecting the org from entity browser 
	 EntityBrowserTestCase.selectOrgFromAllLevelsEB(sTestEntity1, null, null, null, 1, true);
	 EntityBrowserTestCase.selectOrgFromAllLevelsEB("", sTestEntity2, sTestEntity3,"", 3, false);
	 /*EntityBrowserTestCase.selectOrgFromAllLevelsEB(sTestEntity1,null, null, null);
	 WebObjectUtil.clickElement(Entity.getNav_EBPanelRollUpButton());
	 WebObjectUtil.explicitWait(3);
	 EntityBrowserTestCase.selectOrgFromAllLevelsEB(null,sTestEntity2, sTestEntity3, null);
	 WebObjectUtil.clickElement(Entity.getNav_EBPanelRollUpButton());*/
	 WebObjectUtil.clickElement(Entity.getNav_OrgNameTitleLink());
	

	 // verifying the create ticket
	 TicketTestCase.verifyCreateTicket();
/*	 wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
	 WebObjectUtil.clickElement(wExpander);*/
	 WebElement wOrgName= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "TICKET.TICKETTABLE.EXPANDER.ORGNAME", "PARAMETER_ROWNUMBER", 1+"");
	 boolean bOrgname = wOrgName.getText().equalsIgnoreCase(sTestEntity3);
	 FrameworkUtil.updateCustomResultBasedOnStatus(bOrgname, wOrgName.getText());
	
	 // log out 
	 LoginTestCase_Old1.nav_Logout();
}
catch(Exception e) {
	 LoggerUtil.log_type_error("Issue with navCreateTicketUnderTestEntity03 test case");
	 LoggerUtil.log_type_error("Exception occured " + e.getMessage());
	 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage());
}
}

/*==============================================================
TestScript 		: verifyPDFandCSVIconsForClosedmoreThenState
Manual TestCase	: QAT-361
Description		: Verify the pdf and csv icons in closed more then 6 months state
Author 			: QAA04
Creation Date 	: 1/04/2016
Release Name    : Keffer
Pre-Requisites	:
Revision History:

==============================================================*/	
@Test(priority=66)
public void verifyPDFandCSVIconsForClosedmoreThenState() {
	     String sTestEntity1,sTestEntity2,sTestEntity3;
		 WebDriver driver = WebDriverUtil.getDriver();
		 PageFactory.initElements(driver, Entity);
		 PageFactory.initElements(driver, Ticket);
		 
		 boolean bPDFIcon,bCSVIcon;
		 try { 
		 FrameworkUtil.sTestCaseName="verifyPDFandCSVIconsForClosedmoreThenState";
		 FrameworkUtil.sManualTestCaseName="(QAT-361)Keffer - Verify the pdf and csv icons in closed more then 6 months state";
		 FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		  
		 //set the child and parent entity with admin user
		 AdminTestCase.verifyTstEntityParentChildHierarchy();
		 
		 // Login to navigator with rola-a user
		 LoginTestCase_Old1.LoginAsRoleAUser();
		 
		 sTestEntity1 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
		 sTestEntity2 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY02");
		 sTestEntity3 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY03");

		
		 WebObjectUtil.clickElement(Entity.getNav_EntityBrowserLink());
		 
		 // selecting the org from entity browser 
		 EntityBrowserTestCase.selectOrgFromAllLevelsEB(sTestEntity1,sTestEntity2, null, null);
		 WebObjectUtil.clickElement(Entity.getNav_EBPanelRollUpButton());
		 WebObjectUtil.clickElement(Entity.getNav_OrgNameTitleLink());
		 
		 // Navigating to the ticket page
		 TicketTestCase.navigateToTicketPage();
		 
		 // verifying the Organization column entity 
		 String sOrgNames ="TST Entity02,TST Entity03";
		 verifyEntityUnderOrganizationColumn(sOrgNames);
		 
		 // selecting closed less then 6 months from organization drop down
		 WebObjectUtil.clickElement(Ticket.getNav_TicketOutstandingList());
		 WebObjectUtil.selectCustomWebList(Ticket.getNav_TicketOutstandingDropdown(), "Closed (More than 6 months)");
		 
		 // verifying the pdf and csv icons 
		bPDFIcon = Ticket.getNav_TicketsPdfIcon().getAttribute("src").contains("PDF");
		FrameworkUtil.updateCustomResultBasedOnStatus(bPDFIcon, "verifying the PDF icon");
		
		bCSVIcon = Ticket.getNav_TicketsCsvIcon().getAttribute("src").contains("CSV");
		FrameworkUtil.updateCustomResultBasedOnStatus(bCSVIcon, "verifying the CSV icon");
	
		
		
		 
// log out
 LoginTestCase_Old1.nav_Logout();
 }
 catch(Exception e) {
	 LoggerUtil.log_type_error("Issue with verifyPDFandCSVIconsForClosedmoreThenState test case");
	 LoggerUtil.log_type_error("Exception occured " + e.getMessage());
	 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage());
 }
}

/*==============================================================
TestScript 		: navVerifyTstEntity02Count
Manual TestCase	: QAT-354
Description		: Verify the pdf and csv icons in closed more then 6 months state
Author 			: QAA04
Creation Date 	: 1/05/2016
Release Name    : Keffer
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=67)
public void navVerifyTstEntity02Count() {
	String sOrgNames,sTestEntity1,sTestEntity2,sTestEntity3;
	int iOpenTktCnt,iWorkingTktCnt,iPendingTktCnt,iResolvedTktCnt,iExpectedOpenTktCnt,iExpectedWorkingTktCnt,iExpectedPendingTktCnt,iExpectedResolvedTktCnt;
	boolean bOpenTktCnt,bWorkingTktCnt,bPendingTktCnt,bResolvedTktCnt;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver,Entity);
	PageFactory.initElements(driver, Ticket);
	try {
	FrameworkUtil.sTestCaseName="navVerifyTstEntity02Count";
	FrameworkUtil.sManualTestCaseName="(QAT-354) keffer - Verify the tickets display are for 'tst entity02' and counts at top panel";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);

	 //set the child and parent entity with admin user
	 AdminTestCase.verifyTstEntityParentChildHierarchy();
	 
	 // Login to navigator with rola-a user
	 LoginTestCase_Old1.LoginAsRoleAUser();
	 
	 sTestEntity1 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
	 sTestEntity2 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY02");
	 sTestEntity3 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY03");

	
	
	 // Navigating to the ticket page
	 TicketTestCase.navigateToTicketPage();
	 
	 WebObjectUtil.clickElement(Entity.getNav_EntityBrowserLink());
	// selecting the org from entity browser 
	 EntityBrowserTestCase.selectOrgFromAllLevelsEB(sTestEntity1,sTestEntity2, null, null);
	 WebObjectUtil.clickElement(Entity.getNav_OrgNameTitleLink());
	 WebObjectUtil.explicitWait(5);
	 
	 iOpenTktCnt = KefferTestCase_Arul.getTicketCountFromHeader(Ticket.getNav_OpenTicketNumbers());
     iWorkingTktCnt = KefferTestCase_Arul.getTicketCountFromHeader(Ticket.getNav_WorkingTicketNumbers());
     iPendingTktCnt = KefferTestCase_Arul.getTicketCountFromHeader(Ticket.getNav_PendingTicketNumbers());
     iResolvedTktCnt = KefferTestCase_Arul.getTicketCountFromHeader(Ticket.getNav_ResolvedTicketNumbers());
	 
	 
	 WebObjectUtil.clickElement(Entity.getNav_EntityBrowserLink());
	 // selecting the org from entity browser 
	// EntityBrowserTestCase.selectOrgFromAllLevelsEB(sTestEntity1,null, null, null);
	 WebObjectUtil.clickElement(Entity.getNav_EBPanelRollUpButton());
	 WebObjectUtil.clickElement(Entity.getNav_OrgNameTitleLink());
	WebObjectUtil.explicitWait(5);
	
	 // verifying the Organization column entity 
	 sOrgNames ="TST Entity02,TST Entity03";
	 verifyEntityUnderOrganizationColumn(sOrgNames);
	 
	 WebObjectUtil.clickElement(Ticket.getNav_TicketOrgWebListArrow());
	 WebObjectUtil.selectCustomWebList(Ticket.getNav_TicketOrgWebListDropDown(), sTestEntity2);
	
	 verifyEntityUnderOrganizationColumn(sTestEntity2);
	 
	
	
	 // verifying the closed outstanding state open,pending,working,resolved tickets counts 
	//	KefferTestCase_Arul.verifyTicketCountAfterRollOn(sTestEntity2,Ticket.getNav_Outstanding());
	
		
		 WebObjectUtil.clickElement(Entity.getNav_EntityBrowserLink());
		 WebObjectUtil.clickElement(Entity.getNav_EBPanelRollUpButton());
		 WebObjectUtil.clickElement(Entity.getNav_OrgNameTitleLink());
		 WebObjectUtil.explicitWait(5);
		
		 
		iExpectedOpenTktCnt = KefferTestCase_Arul.getTicketCountFromHeader(Ticket.getNav_OpenTicketNumbers());
        iExpectedWorkingTktCnt = KefferTestCase_Arul.getTicketCountFromHeader(Ticket.getNav_WorkingTicketNumbers());
        iExpectedPendingTktCnt = KefferTestCase_Arul.getTicketCountFromHeader(Ticket.getNav_PendingTicketNumbers());
        iExpectedResolvedTktCnt = KefferTestCase_Arul.getTicketCountFromHeader(Ticket.getNav_ResolvedTicketNumbers());
	
        bOpenTktCnt=(iOpenTktCnt==iExpectedOpenTktCnt);
        FrameworkUtil.updateCustomResultBasedOnStatus(bOpenTktCnt, "Open ticket count is matched");
        
        bWorkingTktCnt=(iOpenTktCnt==iExpectedOpenTktCnt);
        FrameworkUtil.updateCustomResultBasedOnStatus(bWorkingTktCnt, "Working ticket count is matched");
        
        bPendingTktCnt=(iOpenTktCnt==iExpectedOpenTktCnt);
        FrameworkUtil.updateCustomResultBasedOnStatus(bPendingTktCnt, "Pending ticket count is matched");
        
        bResolvedTktCnt=(iOpenTktCnt==iExpectedOpenTktCnt);
        FrameworkUtil.updateCustomResultBasedOnStatus(bResolvedTktCnt, "Resolved ticket count is matched");
        
	// log out
	 LoginTestCase_Old1.nav_Logout();
	}
	 catch(Exception e) {
		 LoggerUtil.log_type_error("Issue with navVerifyTstEntity02Count test case");
		 LoggerUtil.log_type_error("Exception occured " +FrameworkUtil.sElementName);
		 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage());
	 }

}

/*==============================================================
TestScript 		: VerifyOrganizationColumnforTstEntity01
Manual TestCase	: QAT-339
Description		: Verify the tickets displayed are for tst entity 01 and tst entity02 with a new column added Organization
Author 			: QAA04
Creation Date 	: 1/06/2016
Release Name    : Keffer
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=68) 
public void VerifyOrganizationColumnforTstEntity01(){
	String sOrgname,sTestEntity1,sTestEntity2,sTestEntity3;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, Entity);
	try {
	FrameworkUtil.sTestCaseName="VerifyOrganizationColumnforTstEntity01";
	FrameworkUtil.sManualTestCaseName="(QAT-339) Keffer-Verify the tickets displayed are for tst entity 01 and tst entity02 with a new column added Organization";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);

	 //set the child and parent entity with admin user
	 AdminTestCase.verifyTstEntityParentChildHierarchy();
	 
	 // loging to the navigator
	 LoginTestCase_Old1.LoginAsRoleAUser();
	 
	 sTestEntity1 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
	 sTestEntity2 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY02");
	 sTestEntity3 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY03");

	 
	 // selecting the org from the entity browser
	 WebObjectUtil.clickElement(Entity.getNav_EntityBrowserLink());
	 EntityBrowserTestCase.selectOrgFromAllLevelsEB(sTestEntity1, null, null, null, 1, true);
	 WebObjectUtil.clickElement(Entity.getNav_OrgNameTitleLink());
	 
	 // navigating to the ticket page
	 TicketTestCase.navigateToTicketPage();
	 
	 // verifying the entity under organization column
	 sOrgname ="TST Entity01,TST Entity02";
	verifyEntityUnderOrganizationColumn(sOrgname);
	
	// log out 
	LoginTestCase_Old1.nav_Logout();
    }
	catch(Exception e){
		LoggerUtil.log_type_error("issue with VerifyOrganizationColumnforTstEntity01 test case");
		LoggerUtil.log_type_error("Exception occured "+FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception occured", "fail", e.getMessage());
	}
}
/*==============================================================
TestScript 		: navVerifyvCPUvRAMandStorageColumnsValues
Manual TestCase	: QAT-346
Description		: On the home page in the EVDC block, verify the values displayed under vCPUs, vRAM, and Storage columns
Author 			: QAA04
Creation Date 	: 1/12/2016
Release Name    : Keffer
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=69)
public void navVerifyvCPUvRAMandStorageColumnsValues() {
	String sTestEntity1,sCPUCount,sRAMCount,sAllocatedData,sAllocatedGB;
	WebElement wEVDCName;
	String[] sActualAllocatedData,sExpectedAllocatedData;
	Float fAllocatedData,fExpectedAllocatedData;
	boolean bAllocatedData;
	
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, Entity);
	PageFactory.initElements(driver, EVDC_Overview);
	try {
		FrameworkUtil.sTestCaseName="navVerifyvCPUvRAMandStorageColumnsValues";
		FrameworkUtil.sManualTestCaseName="(QAT-346) On the home page in the EVDC block, verify the values displayed under vCPUs, vRAM, and Storage columns";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		 //set the child and parent entity with admin user
		 AdminTestCase.verifyTstEntityParentChildHierarchy();
		 
		 // loging to the navigator
		 LoginTestCase_Old1.LoginAsRoleAUser();
		 
		 sTestEntity1 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
		 
		 // clicking on entity browser link 
		 WebObjectUtil.clickElement(Entity.getNav_EntityBrowserLink());
		 EntityBrowserTestCase.selectOrgFromAllLevelsEB(sTestEntity1, null, null, null, 1, true);
		 WebObjectUtil.clickElement(Entity.getNav_OrgNameTitleLink());
		 
		//Loading the EVDC web table
			CustomWebElementUtil.loadCustomElement(EVDC_Overview.getNav_EVDCViewHomeTable(), "table");
			sCPUCount = CustomWebElementUtil.getCellData(1,5);
			sRAMCount = CustomWebElementUtil.getCellData(1,6);
			sAllocatedData = CustomWebElementUtil.getCellData(1,7);
			
		//Getting the integer value from RAM count
			sRAMCount=sRAMCount.replace("(GB)", "").trim();
			
			
			sActualAllocatedData = sAllocatedData.split(" ");
			fAllocatedData = Float.valueOf(sActualAllocatedData[0]);
		 
			 
		 wEVDCName = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.EVDCVIEWTABLE.EVDC", "PARAMETER_ROWNUMBER", 1+"");
		 WebObjectUtil.clickElement(wEVDCName);
		 
		 sAllocatedGB =EVDC_Overview.getNav_StoragePortlet_AllocatedData().getText();
		 sExpectedAllocatedData = sAllocatedGB.split(" ");
		 fExpectedAllocatedData = Float.valueOf(sExpectedAllocatedData[0]);
		
		 // validating the allocated data 
		 bAllocatedData =fAllocatedData.equals(fExpectedAllocatedData);
		 FrameworkUtil.updateCustomResultBasedOnStatus(bAllocatedData, "Data is matched "+sAllocatedData);
		 
		 // clicking on virtual machine link
		 WebObjectUtil.clickElement(EVDC_Overview.getNav_EVDCOverviewVirtualMachine());
		 
		
		 
		 // verifying the vCPU and vRAM count
		 navValidateCPUnRAMCnt("Running",sCPUCount,sRAMCount);
		 
			
		 // log out 
		 LoginTestCase_Old1.nav_Logout();
		 
	}catch(Exception e){
		LoggerUtil.log_type_error("issue with navVerifyvCPUvRAMandStorageColumnsValues test case");
		LoggerUtil.log_type_error("exception occured " +FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exceptio occured", "fail", " "+e.getMessage());
	}
}

/////////////////////////////////// Methods /////////////////////////////////////////////////////////
/*====================================================================================================
Method Name 	: verifyEntityUnderOrganizationColumn
Description		: Tickets - Verifying the expected entity name in the organization column 
Author 			: QAA04
Creation Date 	: 12/29/2015
Release Name    : Keffer
Pre-Requisites	:
Revision History:
=====================================================================================================*/
 public static void verifyEntityUnderOrganizationColumn(String sEntityNamesWithCommaSeparated) {
	 
	 WebDriver driver = WebDriverUtil.getDriver();
	 PageFactory.initElements(driver, Ticket);
	 int iOrgColumnNum,iTableCount,iTempIndex,iEntityLength;
	 String sOrganizationColumn,sEntityName,sOrgName;
	 WebElement wOraganizationColumn;
	 boolean bFlag;
	 String[] sEntityOrg;
	try {
	 // verifying the organization column in the web table 
	 iOrgColumnNum = TicketTestCase.getTicketTableColumnIndex("Organization");
     if(iOrgColumnNum>=1) {
	    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(),FrameworkUtil.sElementName, "Verifying the organization column", "pass","Organization column is displaying ");
	    }else {
	    	
	    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verifying the organization column", "fail", "Organization column is NOT dispalying in the table");
	    }
   
    // getting the table row count 
      CustomWebElementUtil.loadCustomElement(Ticket.getNav_TicketsWebTableParent(), "table");
     
      iTableCount = CustomWebElementUtil.iRowCount;
      iTempIndex=0;
	  
      for(int i=1; i<=iTableCount; i=i+4) {
		bFlag=false;
		iTempIndex++;
	 //  sOrganizationColumn = WebObjectUtil.getLocatorValueFromProperty("TICKET.TICKETTABLE.ORGANIZATION.COLUMN.HEADER", "PARAMETER_ROWNUMBER", iTempIndex+"");
	 //  wOraganizationColumn = WebObjectUtil.GetWebElement("XPATH", sOrganizationColumn, "Oraganization column entities");
		wOraganizationColumn = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "TICKET.TICKETTABLE.ORGANIZATION.COLUMN.HEADER", "PARAMETER_ROWNUMBER", iTempIndex+"");
		sEntityName = wOraganizationColumn.getText();
	  
	   sEntityOrg =sEntityNamesWithCommaSeparated.split(",");
	   iEntityLength = sEntityOrg.length;
	   
	      for(int j=0; j<=iEntityLength-1; j++){
		   
	        sOrgName = sEntityOrg[j];
	        // verifying the organization column cell data with respective the given parameters 
		      if(sEntityName.equalsIgnoreCase(sOrgName)) {
		    	  bFlag=true; 
		    	  break;
			   }
	          
	        }
	 
	     if(bFlag)
	      {
	    	  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verifying the Org entity", "pass", " - "+sEntityName);
	      }
	     else
	      {
	    	  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verifying the Org entity", "fail", "it is NOT Expected entity org - "+sEntityName);
	      }
	   
	   }
	}catch(Exception e) {
		LoggerUtil.log_type_error("exception occured"+FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verifyEntityUnderOrganizationColumn", "fail", "Catch block: "+e.getMessage());
	}
 }
 
 /*====================================================================================================
 Method Name 	: navValidateCPUnRAMCnt
 Description	: validating the vCPU count and vRAM count in the vm page
 Author 		: QAA04
 Creation Date 	: 01/13/2015
 Release Name   : Keffer
 Pre-Requisites	:
 Revision History:
 =====================================================================================================*/
 public static void navValidateCPUnRAMCnt(String VMStatus,String sCPUCount, String sRAMCount)
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_Overview);	
		PageFactory.initElements(driver, EVDC_VMPF);	
		
		int iRows,iCols,iRowVal = 0;
		WebElement wVMStatus,wRAM,wCPU;
		int vCPU, vCPUCount=0;
		double vRAMCount=0.0f;
		String vRAM, sSubString;
		
		try {
			
			// getting the row count 
			 List<WebElement> wVmTable = driver.findElements(By.xpath("//div[@id='vmListExtGridPanel-body']//table"));
			 iRows = wVmTable.size();
			
			for(int j=0;j<iRows*2;j++)
			 	
			 {
				 String text=WebTableUtil.getCellData(EVDC_VMPF.getNav_VMWebTable(), j+1, 5);
				 // System.out.println(text);
				 				
				 if(text.contains(VMStatus))
					{
						
						 //commented the above line(//--) and added the below line as part of EXTJS5 change-Vivek - 10082015
						vCPU=Integer.parseInt(WebTableUtil.getCellData(EVDC_VMPF.getNav_VMWebTable(), j+1, 6).trim());
						 vCPUCount=vCPUCount+vCPU;
						//System.out.println(WebTableUtil.getCellData(EVDC_VMPF.getNav_VMWebTable(), j, 2));
						
						 //commented the above line(//--) and added the below line as part of EXTJS5 change-Vivek - 10082015
						 vRAM=WebTableUtil.getCellData(EVDC_VMPF.getNav_VMWebTable(), j+1, 7).trim();
						 if(vRAM.contains("GB"))
						 {
							 sSubString=vRAM.substring(0, 1);
							 //vRAMVal=Integer.parseInt(sSubString) * 512;
							int iActCnt=(Integer.parseInt(sSubString));
							 vRAMCount=vRAMCount+iActCnt ;
						 }
						 else if(vRAM.contains("MB"))
						 {
							 sSubString=vRAM.substring(0, 3);
							 if(sSubString.contains("512"))
							 {
								 vRAMCount= vRAMCount + 0.5;
								 
							 }
							 else if(sSubString.contains("256"))
							 {
								 vRAMCount= vRAMCount + 0.25;						 
							 }
							 else if(sSubString.contains("128"))
							 {
								 vRAMCount= vRAMCount + 0.13;						 
							 }
						 }
						 
						}
				 	}
	
			 int iCPUCnt=Integer.parseInt(sCPUCount);
			 System.out.println("sCPUCount "+ sCPUCount + ", sRAMCount " +sRAMCount);
			 double dRAMCnt=Double.parseDouble(sRAMCount);
			 double roundOffvRAM = Math.round(vRAMCount * 100.0) / 100.0;
			 WebObjectUtil.explicitWait(5);
			 //System.out.println(roundOff);
			 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Home page vCPU count ", "pass", " - " +iCPUCnt);
			 if(iCPUCnt==vCPUCount)
			 {
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Powered On and CPU count @ Landing Page are equal "    , "pass","Expected Count = "+ sCPUCount + "Actual Count = "+iCPUCnt ) ;
				LoggerUtil.log_type_info("Expected Count = "+ sCPUCount + "Actual Count = "+iCPUCnt );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Powered On and CPU count @ Landing Page are not equal"   , "fail", "Expected Count = "+ sCPUCount + "Actual Count = "+iCPUCnt );
				LoggerUtil.log_type_error("Expected Count = "+ sCPUCount + "Actual Count = "+ iCPUCnt  );
			 }
			 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Home page vRAM count ", "pass", " - " +dRAMCnt);
			 if(dRAMCnt==roundOffvRAM)
			 {
				 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Powered On and RAM count @ Landing Page are equal "    , "pass","Expected Count = "+ dRAMCnt + "Actual Count = "+roundOffvRAM ) ;
				LoggerUtil.log_type_info("Expected Count = "+ dRAMCnt + "Actual Count = "+roundOffvRAM );
				}
				else
				{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Powered On and RAM count @ Landing Page are not equal"   , "fail", "Expected Count = "+ dRAMCnt + "Actual Count = "+roundOffvRAM);
				LoggerUtil.log_type_error("Expected Count = "+ dRAMCnt + "Actual Count = "+roundOffvRAM);
			 }
			// System.out.println("vRAM =" + vRAMCount );
			// System.out.println("vCPUCount =" +vCPUCount);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}

//update each @test result in custom result file
		@AfterMethod
		public static void afterEachMethod(){
			FrameworkUtil.updateTestCaseStatusinResult();
			FrameworkUtil.sTestExecutionStatus = true;
			
		}
 
}
