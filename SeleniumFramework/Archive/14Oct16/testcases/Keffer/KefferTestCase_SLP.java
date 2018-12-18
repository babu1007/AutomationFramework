package com.whs.navigator.testcases.Keffer;

import java.util.Arrays;

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
import com.whs.navigator.pagefactory.AdminPageFactory;
import com.whs.navigator.pagefactory.DraasPageFactory;
import com.whs.navigator.pagefactory.EM7PageFactory;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.EVDC_VM_PageFactory;
import com.whs.navigator.pagefactory.EntityBrowserPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.LoadBalancerPageFactory;
import com.whs.navigator.pagefactory.TicketPageFactory;
import com.whs.navigator.pagefactory.UserPermissionMultiOrgPageFactory;
import com.whs.navigator.pagefactory.DraasPageFactory;
import com.whs.navigator.pagefactory.UserPermissionManageEntityPageFactory;
import com.whs.navigator.pagefactory.UserPermissionPageFactory;
import com.whs.navigator.pagefactory.CommonPageFactory;

public class KefferTestCase_SLP {
	
	public static EntityBrowserPageFactory EBPanel = new EntityBrowserPageFactory();
	public static UserPermissionMultiOrgPageFactory UPMultiOrg = new UserPermissionMultiOrgPageFactory();
	public static TicketPageFactory Ticket = new TicketPageFactory();	
	public static HomePageFactory_old Home = new HomePageFactory_old();
	public static AdminPageFactory Admin = new AdminPageFactory();
	public static EVDC_OverviewPageFactory EVDC_OverviewPF = new EVDC_OverviewPageFactory();
	public static DraasPageFactory Draas = new DraasPageFactory();
	public static UserPermissionManageEntityPageFactory ManageEntity= new UserPermissionManageEntityPageFactory();
	public static UserPermissionPageFactory UserPermission= new UserPermissionPageFactory();
	public static CommonPageFactory Common = new CommonPageFactory();
	
/*==============================================================
	TestScript  	: verifyRollupdisabledForNoChildOrg
	Manual TestCase	: [QAT-384] WCP_1294_TC_1.0_Toggle Roll Up Flag_Enabled_disabled
	Description		: Verifying Rollup button is disabled for organization not having children and enabled for organization having children
	Author 			: QAA03
	Creation Date 	: 12/23/2015
	Release Name    : Keffer
	Pre-Requisites	:
	Revision History:
==============================================================*/
	@Test(priority=41)
	public void verifyRollupdisabledForNoChildOrg()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,EBPanel);
			String sFLCOrg1=null,sFLCOrg2=null,sOrgRollupStatus=null,sParentorg=null;
		    boolean bFLCOrgRollupStatus;
		
		try {
			FrameworkUtil.sTestCaseName = "verifyRollupdisabledForNoChildOrg";
			FrameworkUtil.sManualTestCaseName="[QAT-384] WCP_1294_TC_1.0_Toggle Roll Up Flag_Enabled_disabled";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			
		    
		    sFLCOrg1 = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.AHOLIDAYTESTERS");
		    sFLCOrg2 = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
		    sParentorg = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.HOSTEDSOLUTIONS");
		    
		    //Login to Navigator with ishannon user 
		    LoginTestCase_Old1.LoginAsIshannonUser();
		    
		    //Verifying parent of child entity and set the respective parent to child
			AdminTestCase.verifyOrg(sFLCOrg1,sParentorg);
			
			//Logout from Navigator
			LoginTestCase_Old1.nav_Signout();
		    
		    //Login to navigator with Role-A user
			LoginTestCase_Old1.LoginAsRoleA();
			
			//Clicking on Entity Browser Link
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			
			//Selecting Organization from First level children
			EntityBrowserTestCase.selectOrgFromAllLevelsEB(sFLCOrg1,"", "", "");
			
			//Verifying Rollup Status for selected organization
			EntityBrowserTestCase.verifyRollupButtonStatusForOrg();
		    
		    //Selecting Organization from First level children
			EntityBrowserTestCase.selectOrgFromAllLevelsEB(sFLCOrg2,"", "", "");
			
			//Verifying Rollup Status for selected organization
			EntityBrowserTestCase.verifyRollupButtonStatusForOrg();
			
			//Logout from Navigator
			LoginTestCase_Old1.nav_Logout();
		
		   } catch (Exception e) {
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyRollupdisabledForNoChildOrg", "warn", "catch block:" +e.getMessage());
		}
    }
	/*==============================================================
	TestScript  	: verifyRollupStatusForMultiOrgUserOrgs
	Manual TestCase	: [QAT-369] WCP_1294_TC_2.0_Toggle Roll up Flag_MultiOrg
	Description		: Verifying Rollup status for multiorg users
	Author 			: QAA03
	Creation Date 	: 12/28/2015
	Release Name    : Keffer
	Pre-Requisites	:
	Revision History:
    ==============================================================*/
	@Test(priority=42)
	public void verifyRollupStatusForMultiOrgUserOrgs()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,EBPanel);
			PageFactory.initElements(driver,UPMultiOrg);
			PageFactory.initElements(driver,Ticket);
			PageFactory.initElements(driver,Home);
			
			String sOrg1toSelect=null,sFLCOrg=null,sOrg2toSelect=null;
			WebElement wOrgName;
		    
		
		try {
			FrameworkUtil.sTestCaseName = "verifyRollupStatusForMultiOrgUserOrgs";
			FrameworkUtil.sManualTestCaseName="[QAT-369] WCP_1294_TC_2.0_Toggle Roll up Flag_MultiOrg";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			
		    
		    sOrg1toSelect = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
		    sFLCOrg = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.FIRST.LEVEL.TST.ORGNAME");
		    sOrg2toSelect = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME1");
		    
			//Login to Navigator with testmultiorg-RoleA1 user
			LoginTestCase_Old1.LoginAsTstMultiOrgRoleA1User();
			
			//Selecting the Organization from dropdown
			WebObjectUtil.selectWebList(UPMultiOrg.getNav_MOrg_SelectOrg(),sOrg1toSelect, null, 0);
			WebObjectUtil.clickElement(UPMultiOrg.getNav_MOrg_UsethisOrgButton());
			WebObjectUtil.explicitWait(5);
			HomeTestCase.nav_WindStreamToTierPointHomePopup();
			
			// Navigating to the ticket page
			TicketTestCase.navigateToTicketPage();
			
			//Clicking on Entity Browser Link
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			
			//Selecting Organization from First level children
			EntityBrowserTestCase.selectOrgFromAllLevelsEB(sFLCOrg,"", "", "",1,true);
			
			//Clicking on EntityBrowser Tab
			WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
			
		    //Mouse over the organization name on top and selecting another organization
			WebObjectUtil.ClickAndMouseHover(UPMultiOrg.getNav_MOrg_OrgName());
			  
			wOrgName = WebObjectUtil.getWebElementFromDynamicLocator("xpath","EBPANEL.MULTLYORG.ORGNAMETOSELECT", "PARAMETER_ORGNAME", sOrg2toSelect +"");
			WebObjectUtil.clickElement(wOrgName);
			
			//Clicking on Entity Browser Link
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			
			//Verifying Rollup Status for selected organization
			EntityBrowserTestCase.verifyRollupButtonStatusForOrg();
		  			
			//Logout from Navigator
			LoginTestCase_Old1.nav_Logout();
		
		   } catch (Exception e) {
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyRollupStatusForMultiOrgUserOrgs", "warn", "catch block:" +e.getMessage());
		}
    }
	/*==============================================================
	TestScript  	: verifyEBFooterRollupFlagStatusbySelectingOrgs
	Manual TestCase	: [QAT-363] WCP_1294_TC_3.0_Toggle Roll up flag_UI issues
	Description		: Verifying EB Footer Rollup flag status
	Author 			: QAA03
	Creation Date 	: 12/28/2015
	Release Name    : Keffer
	Pre-Requisites	:
	Revision History:
==============================================================*/
	@Test(priority=43)
	public void verifyEBFooterRollupFlagStatusbySelectingOrgs()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,EBPanel);
			PageFactory.initElements(driver,Home);
						
			String sFLCOrg=null;
	
		try {
			FrameworkUtil.sTestCaseName = "verifyEBFooterRollupFlagStatusbySelectingOrgs";
			FrameworkUtil.sManualTestCaseName="[QAT-363] WCP_1294_TC_3.0_Toggle Roll up flag_UI issues";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			sFLCOrg = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.ABCTEST");
		   
		    
		    //Login to navigator with Role-A user
		 	LoginTestCase_Old1.LoginAsRoleA();
		
			//Verifying EBFooter Rollup flag Button is displayed
			WebObjectUtil.verifyElementPresent(EBPanel.getNav_EBPanelFooterRollUpButton());
			
			//Clicking on Entity Browser Link
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			
			EntityBrowserTestCase.setRollOnOffEBPanel(true);
			
			//Clicking on Entity Browser close icon
			WebObjectUtil.clickElement(EBPanel.getNav_CloseButton());
			
			//Verifying EBFooter Rollup flag status 
			EntityBrowserTestCase.verifyEBFooterRollupFlagStatusForOrg();
			
			//Clicking on Entity Browser Link
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			
			//Selecting Organization not having children  from First level children
			EntityBrowserTestCase.selectOrgFromAllLevelsEB(sFLCOrg,"", "", "");
			
			//Verifying Rollup flag status
			EntityBrowserTestCase.verifyRollupButtonStatusForOrg();
			
			//Logout from Navigator
			LoginTestCase_Old1.nav_Logout();
		
		   } catch (Exception e) {
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyEBFooterRollupFlagStatusbySelectingOrgs", "warn", "catch block:" +e.getMessage());
		}
    }
	/*==============================================================
	TestScript  	: verifyPageRefreshAfterClickingEBTab
	Manual TestCase	: [QAT-360] WCP_1294_TC_1.1_Toggle Roll up Flag_Page is not refreshed until click the link in EB tab
	Description		: Verifying after selecting organization from First level children, page is not refreshed unless clicks on EB tab
	Author 			: QAA03
	Creation Date 	: 12/29/2015
	Release Name    : Keffer
	Pre-Requisites	:
	Revision History:
==============================================================*/
	@Test(priority=44)
	public void verifyPageRefreshAfterClickingEBTab()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,EBPanel);
			PageFactory.initElements(driver,EVDC_OverviewPF);
						
			String sFLCOrg=null,sEBOrgName=null,sEVDCName=null,sEVDCNameEB=null, sParentorg=null;
			boolean bPageNotRefStatus,bEBOrgStatus,bPageRefStatus;
	
		try {
			FrameworkUtil.sTestCaseName = "verifyPageRefreshAfterClickingEBTab";
			FrameworkUtil.sManualTestCaseName="[QAT-360] WCP_1294_TC_1.1_Toggle Roll up Flag_Page is not refreshed until click the link in EB tab";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
				    
		    sFLCOrg = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
		    
            sParentorg = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.HOSTEDSOLUTIONS");
		    
		    //Login to Navigator with ishannon user 
		    LoginTestCase_Old1.LoginAsIshannonUser();
		    
		    //Verifying parent of child entity and set the respective parent to child
			AdminTestCase.verifyOrg(sFLCOrg,sParentorg);
			
			//Logout from Navigator
			LoginTestCase_Old1.nav_Signout();
		   
		    // Login to navigator with Role-A user
		 	LoginTestCase_Old1.LoginAsRoleA();
		 	
		    //Getting EVDC Name
			sEVDCName=EVDC_OverviewPF.getNav_EVDCname().getText();
			//Clicking on Entity Browser Link
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			
			//Selecting Organization from First level children
			EntityBrowserTestCase.selectOrgFromAllLevelsEB(sFLCOrg,"", "", "");
			
			//Clicking on Entity Browser Close Button
			WebObjectUtil.clickElement(EBPanel.getNav_CloseButton());
			
			 //Getting EVDC Name
			sEVDCNameEB=EVDC_OverviewPF.getNav_EVDCname().getText();
			
			//Verifying Page is not Refreshed
			bPageNotRefStatus = sEVDCNameEB.contentEquals(sEVDCName);
			FrameworkUtil.updateCustomResultBasedOnStatus(bPageNotRefStatus, "Page Not Refreshed Status");
			
			//Clicking on Entity Browser Link
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			
			//Selecting Organization from First level children
			EntityBrowserTestCase.selectOrgFromAllLevelsEB(sFLCOrg,"", "", "");
			
			//Getting the Entity Browser Tab name
			sEBOrgName =EBPanel.getNav_OrgNameTitleLink().getText();
			
			//Comparing Entity Browser Tab name with Entity selected from First level Children
			bEBOrgStatus=sEBOrgName.contentEquals(sFLCOrg);
			
			FrameworkUtil.updateCustomResultBasedOnStatus(bEBOrgStatus, "Entity selected from First level children and Entity Browser Tab name");
			
			//Clicking on Entity browser tab
			WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
			
			WebObjectUtil.waitForElementPresent(EVDC_OverviewPF.getNav_EVDCname());
			
			//Getting EVDC Name
			sEVDCNameEB=EVDC_OverviewPF.getNav_EVDCname().getText();
			
			//Verifying Page is Refreshed
			bPageNotRefStatus = !sEVDCNameEB.contentEquals(sEVDCName);
			FrameworkUtil.updateCustomResultBasedOnStatus(bPageNotRefStatus, "Page Refreshed Status");
	
			//Logout from Navigator
			LoginTestCase_Old1.nav_Logout();
		
		   } catch (Exception e) {
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyPageRefreshAfterClickingEBTab", "warn", "catch block:" +e.getMessage());
		}
    }
	/*==============================================================
	TestScript  	: verifyDataDisplaysForChildAndNoChildEntities
	Manual TestCase	: [QAT-348] WCP_1294_TC_1.2_Roll-up Flag_toggle between Entity View_Roll up View_from any page
	Description		: 
	Author 			: QAA03
	Creation Date 	: 01/13/2016
	Release Name    : Keffer
	Pre-Requisites	:
	Revision History:
==============================================================*/
	@Test(priority=45)
	public void verifyDataDisplaysForChildAndNoChildEntities()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,EBPanel);
			PageFactory.initElements(driver,Home);
			PageFactory.initElements(driver,EVDC_OverviewPF);
						
			String sFLCOrg=null,sSLCOrg=null,sTLCOrg=null,sFRLCOrg=null,sChildEntities=null;
            
	        
	        
		try {
			FrameworkUtil.sTestCaseName = "verifyDataDisplaysForChildAndNoChildEntities";
			FrameworkUtil.sManualTestCaseName="[QAT-348] WCP_1294_TC_1.2_Roll-up Flag_toggle between Entity View_Roll up View_from any page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			   
		    sFLCOrg = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
		    sSLCOrg = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY02");
		    sTLCOrg = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY03");
		    sFRLCOrg = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY04");
		    
		    //Login to Navigator with ishannon user 
		    LoginTestCase_Old1.LoginAsIshannonUser();
		    
			//precondition for step 6-setting child parent relationship to entities in the flow TST Entity01/TST Entity02/TST Entity03/TST Entity04
			AdminTestCase.setTstEntityParent();
			
			//Logout from Navigator
			LoginTestCase_Old1.nav_Signout();
		    
		    //Login to navigator with Role-A user
		 	LoginTestCase_Old1.LoginAsRoleA();
			
				
			//Clicking on Entity Browser Link
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			
			
			//Selecting Organization from First Level and Second Level Children
			EntityBrowserTestCase.selectOrgFromAllLevelsEB(sFLCOrg,sSLCOrg, "", "");
			
			//Clicking on Entity browser tab
			WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
			
			//Getting the EVDC Names of both Parent and child entity selected in an array		
			String sChildEVDCArray[] =KefferTestCase_Arul.getEVDCNameforEntityAndItsChild(sSLCOrg);
			
				
			//Clicking on Entity Browser Link to navigate to Parent - .HostedSolutions tab 
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			
			//Clicking on Entity Browser Link
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			
			//Selecting Org from First Level and setting Rollup flag button "ON" and selecting org from Second Level Children
			EntityBrowserTestCase.selectOrgFromAllLevelsEB(sFLCOrg,sSLCOrg, "", "",1,true);
			
			//Clicking on Entity browser tab
			WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
			
			sChildEntities = getParentChildEntitiesNames();	
			
			//Verifying EVDC names of array in the Home Page
		    KefferTestCase_Arul.verifyEVDCnameForEntityAndItsChild(sChildEVDCArray);
		
			 //Navigating to Tickets Page
			 TicketTestCase.navigateToTicketPage();
			
			 //Verifying Ticket Data Displayed for Selected Organization
			 verifyTicketDataPresentForOrg(sSLCOrg);
			 
			//Verifying Ticket Data Displayed for Selected Organization
			 verifyTicketDataPresentForOrg(sTLCOrg);
			 		 
			//KefferTestCase_NMR.verifyEntityUnderOrganizationColumn(sChildEntities);
			 
			//Clicking on Entity Browser Link
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			
			//Selecting Organization from First Level and Second Level Children
			EntityBrowserTestCase.selectOrgFromAllLevelsEB(sTLCOrg, sFRLCOrg, "", "");
			
			//Verifying Rollup button status
			EntityBrowserTestCase.verifyRollupButtonStatusForOrg();
			
			//Clicking on Entity browser tab
			WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
		
			//Verifying Organization Name in the Ticket
			verifyOrgNameinTicket(sFRLCOrg);
			
			//Navigating to home page
			WebObjectUtil.MouseHover(Home.getNav_MonitoringTab());
			WebObjectUtil.clickElement(Home.getNav_SummaryViewMenuLink());
			
			//Verify EVDCSelector Name matches with Org Name
			verifyEVDCSelectorWithOrgName(sFRLCOrg);
			 
			//Logout from Navigator
			LoginTestCase_Old1.nav_Logout();
		
		   } catch (Exception e) {
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyDataDisplaysForChildAndNoChildEntities", "warn", "catch block:" +e.getMessage());
		}
    }
	/*==============================================================
	TestScript  	: verifyChangeChildEntityForInvalidParent
	Manual TestCase	: [QAT-344] WCP_3462_TC_1.0_/Upgrade_Entity Management_Avoid Parent/child Deadlock
	Description		: Verifying the Error message when entered invalid parent for child entity
	Author 			: QAA03
	Creation Date 	: 12/28/2015
	Release Name    : Keffer
	Pre-Requisites	:
	Revision History:
==============================================================*/
	@Test(priority=46)
	public void verifyChangeChildEntityForInvalidParent()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,Admin);
			
						
			String sChildorg=null,sParentorg=null;
	
		try {
			FrameworkUtil.sTestCaseName = "verifyChangeChildEntityForParent";
			FrameworkUtil.sManualTestCaseName="[QAT-344] WCP_3462_TC_1.0_/Upgrade_Entity Management_Avoid Parent/child Deadlock";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			
		    sChildorg = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.AGCHEMICAL");
		    sParentorg = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.ASSETPOINT");
			
		    //Login to Navigator with ishannon user 
		    LoginTestCase_Old1.LoginAsIshannonUser();
		    
		    //Verifying parent of child entity and set the respective parent to child
			AdminTestCase.verifyOrg(sChildorg, sParentorg);
			
			AdminTestCase.verifyPassingInvalidParentErrorMessage(sParentorg,sChildorg);
			
			//Logout from Navigator
			LoginTestCase_Old1.nav_Signout();
		
		   } catch (Exception e) {
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyChangeChildEntityForInvalidParent", "warn", "catch block:" +e.getMessage());
		}
    }
	/*==============================================================
	TestScript  	: verifyPopUpWindowAndEBFooterRollupStatus
	Manual TestCase	: [QAT-342] WCP_3595_TC_1.0_Entity Browser_UI issues 
	Description		: 
	Author 			: QAA03
	Creation Date 	: 01/04/2016
	Release Name    : Keffer
	Pre-Requisites	:
	Revision History:
==============================================================*/
	@Test(priority=47)
	public void verifyPopUpWindowAndEBFooterRollupStatus()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,EBPanel);
			PageFactory.initElements(driver,Home);
			PageFactory.initElements(driver,Ticket);
			
			String sFLCOrg=null,sSLCOrg=null,sTLCOrg=null,sFRLCOrg=null,sOpenTktsCount=null,sOpenTktsCountRollOn=null,sOpenTktsCountRollOff=null;
			int iOpenTktsCount=0,iOpenTktsCountRollOn=0,iOpenTktsCountRollOff=0;
			boolean bRollonRefStatus,bRolloffRefStatus;
	
		try {
			FrameworkUtil.sTestCaseName = "verifyPopUpWindowAndEBFooterRollupStatus";
			FrameworkUtil.sManualTestCaseName="[QAT-342] WCP_3595_TC_1.0_Entity Browser_UI issues";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
					    
		    sFLCOrg = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
		    sSLCOrg = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY02");
		    sTLCOrg = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY03");
		    sFRLCOrg = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY04");
		    
		    //Login to Navigator with ishannon user 
		    LoginTestCase_Old1.LoginAsIshannonUser();
		    
			//precondition for step 6-setting child parent relationship to entities in the flow TST Entity01/TST Entity02/TST Entity03/TST Entity04
			AdminTestCase.setTstEntityParent();
			
			//Logout from Navigator
			LoginTestCase_Old1.nav_Signout();
		    
		    //Login to navigator with Role-A user
		 	LoginTestCase_Old1.LoginAsRoleA();
			
			//Clicking on Create Ticket link in ContactUs portlet
			WebObjectUtil.clickElement(Home.getnav_CreateTicketLink());
			//Verifying Create Ticket Popup Window
			WebObjectUtil.verifyElementPresent(Home.getnav_CreateTicketPopupWindow());
			
			// Navigating to the ticket page
			TicketTestCase.navigateToTicketPage();
			
			//Getting open tickets count
			sOpenTktsCount =Ticket.getNav_OpenTickets().getText();
			iOpenTktsCount= Integer.parseInt(sOpenTktsCount);
			
			//Clicking on Create Ticket Link
			WebObjectUtil.clickElement(Ticket.getNav_CreateTicketLink());
			//Verifying Create Ticket dialog box
			WebObjectUtil.verifyElementPresent(Ticket.getNav_CreateTicketDialog());
			
			//Clicking on Entity Browser Link
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			//Verifying Entity Browser popup window
			WebObjectUtil.verifyElementPresent(EBPanel.getNav_EntityBrowserTable());
			
			//Setting Rollup flag status "ON"
			EntityBrowserTestCase.setRollOnOffEBPanel(true);
			
			//Clicking on Entity browser tab
			WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
			
			//Verifying EB Footer Rollup flag status
			EntityBrowserTestCase.verifyEBFooterRollupFlagStatusForOrg();
			
			//Getting open tickets count
			sOpenTktsCountRollOn = Ticket.getNav_OpenTickets().getText();
			iOpenTktsCountRollOn = Integer.parseInt(sOpenTktsCountRollOn);
			
			//Verifying open tickets count after setting Rollup button "ON"
			bRollonRefStatus=iOpenTktsCountRollOn>iOpenTktsCount;
			FrameworkUtil.updateCustomResultBasedOnStatus(bRollonRefStatus, "Navigator page refreshed status");
			
			//Clicking on Entity Browser Link
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			
			//Setting Rollup flag status "OFF"
			EntityBrowserTestCase.setRollOnOffEBPanel(false);
			
			//Clicking on Entity browser tab
			WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
			
			//Verifying EB Footer Rollup flag status
			EntityBrowserTestCase.verifyEBFooterRollupFlagStatusForOrg();
			
			//Getting open tickets count
			sOpenTktsCountRollOff = Ticket.getNav_OpenTickets().getText();
			iOpenTktsCountRollOff = Integer.parseInt(sOpenTktsCountRollOff);
			
			//Verifying open tickets count after setting Rollup button "OFF"
			bRolloffRefStatus=iOpenTktsCountRollOff==iOpenTktsCount;
			FrameworkUtil.updateCustomResultBasedOnStatus(bRollonRefStatus, "Navigator page refreshed status");
			
			//Clicking on Entity Browser Link
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			
			//Selecting "TST Entity01" from first level children and set Rollup button "ON"
			EntityBrowserTestCase.selectOrgFromAllLevelsEB(sFLCOrg, "", "", "", 1, true);
			
			//Selecting "TST Entity02" from second level,"TST Entity03" from thirdlevel,"TST Entity04" from fourthlevel and checking Rollup button status
			EntityBrowserTestCase.selectOrgFromAllLevelsEB("", sSLCOrg,sTLCOrg,sFRLCOrg, 4, false);
			
			//Selecting "TST Entity03" from third level children
			EntityBrowserTestCase.selectOrgFromAllLevelsEB("", "",sTLCOrg,"", 3, false);
			
			//Verifying Rollup button status
			EntityBrowserTestCase.verifyRollupButtonStatusForOrg();
			
			//Logout from Navigator
			LoginTestCase_Old1.nav_Logout();
		
		   } catch (Exception e) {
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyPopUpWindowAndEBFooterRollupStatus", "warn", "catch block:" +e.getMessage());
		}
    }
	/*==============================================================
	TestScript  	: verifyC2CRlinksForDifferentUsers
	Manual TestCase	: [QAT-385] WCP_3327_TC_1.0_Cloud to Cloud Recovery_Location specific links
	Description		: Verifying C2CR product and its resources link for different users
	Author 			: QAA03
	Creation Date 	: 01/06/2016
	Release Name    : Keffer
	Pre-Requisites	:
	Revision History:
==============================================================*/
	@Test(priority=48)
	public void verifyC2CRlinksForDifferentUsers()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,Draas);
	
		try {
			FrameworkUtil.sTestCaseName = "verifyC2CRlinksForDifferentUsers";
			FrameworkUtil.sManualTestCaseName="[QAT-385] WCP_3327_TC_1.0_Cloud to Cloud Recovery_Location specific links";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		    //Login to Navigator with gir user 
		    LoginTestCase_Old1.LoginAsGirUser();
		    
		    //Verifying C2CR product and its resources
		    verifyC2CRProductPresentAndClickhereLink();
		   
		    //Logout from Navigator
			LoginTestCase_Old1.nav_Logout();
			
			//Login to Navigator with devco1 user 
		    LoginTestCase_Old1.LoginAsDevco();
		     
		    //Verifying C2CR product and its resources
		    verifyC2CRProductPresentAndClickhereLink();
		   
		    //Logout from Navigator
			LoginTestCase_Old1.nav_Logout();
		
		   } catch (Exception e) {
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyC2CRlinksForDifferentUsers", "warn", "catch block:" +e.getMessage());
		}
    }
	/*==============================================================
	TestScript  	: verifyEVDCForParentAndChildbySettingRollupButton
	Manual TestCase	: [QAT-358] WCP_1303_TC_3.1_Rollup_EVDC in table format_Parent entity has EVDCs_Child entities don't
	Description		: Verifying EVDC for parent and child entities by setting rollup button
	Author 			: QAA03
	Creation Date 	: 01/14/2016
	Release Name    : Keffer
	Pre-Requisites	:
	Revision History:
==============================================================*/
	@Test(priority=49)
	public void verifyEVDCForParentAndChildbySettingRollupButton()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,Admin);
			PageFactory.initElements(driver,EBPanel);
			PageFactory.initElements(driver,EVDC_OverviewPF);
			
						
			String sChildorg1=null,sChildorg2=null,sChildorg3=null,sParentorg1=null,sParentorg2=null,sChildorg4=null;
	        String sEVDCName=null,sParentName=null,sEntityName=null;
	        boolean bEVDCNameStatus,bParentNameStatus;
		try {
			FrameworkUtil.sTestCaseName = "verifyEVDCForParentAndChildbySettingRollupButton";
			FrameworkUtil.sManualTestCaseName="[QAT-358] WCP_1303_TC_3.1_Rollup_EVDC in table format_Parent entity has EVDCs_Child entities don't";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			
		    sChildorg1 = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.LEVEL1ORGA");
		    sChildorg2 = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.LEVEL2CASCADEORGA");
		    sChildorg3 = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.LEVEL3CASCADEORGA");
		    sChildorg4 = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY02");
		    sParentorg1 = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
		    sParentorg2 =(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.HOSTEDSOLUTIONS");
		    
			
		    //Login to Navigator with ishannon user 
		    LoginTestCase_Old1.LoginAsIshannonUser();
		    
		    //Verifying parent of child entity and set the respective parent to child
			AdminTestCase.verifyOrg(sChildorg1, sParentorg1);
			
			//Verifying parent of child entity and set the respective parent to child
			AdminTestCase.verifyOrg(sChildorg2, sParentorg1);
			
			//Verifying parent of child entity and set the respective parent to child
			AdminTestCase.verifyOrg(sChildorg3, sParentorg1);
			
			//Verifying parent of child entity and set the respective parent to child
			AdminTestCase.verifyOrg(sChildorg3, sParentorg1);
			
			//Verifying parent of child entity and set the respective parent to child
			AdminTestCase.verifyOrg(sChildorg4, sParentorg2);
			
			//Logout from Navigator
			LoginTestCase_Old1.nav_Signout();
			
			//Login to navigator with Role-A user
		 	LoginTestCase_Old1.LoginAsRoleA();
		 	
		 	//Clicking on Entity Browser Link
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			
			//Selecting Org from First Level and setting Rollup flag button "ON" 
			EntityBrowserTestCase.selectOrgFromAllLevelsEB(sParentorg1,"","","",1,true);
			
			//Clicking on Entity browser tab
			WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
			
			WebObjectUtil.explicitWait(5);
			
			//Getting the Entity Browser Name
			sEntityName=EBPanel.getNav_EntityBrowserLink().getText();
				
			CustomWebElementUtil.loadCustomElement(EVDC_OverviewPF.getNav_EVDCViewHomeTable(),"table");
		 	
			int iRowCount = CustomWebElementUtil.iRowCount;
			
			//Getting the EVDC name from EVDC table
			sEVDCName = CustomWebElementUtil.getCellData(1,1);
			
			//Getting the entity name under parent column of EVDC Table
			sParentName = CustomWebElementUtil.getCellData(1,2);
			
			//Splitting the Entity Browser name
			String sEntityNameArray[] = sEntityName.split(" ");
			
		
			sEntityNameArray[1]=sEntityNameArray[1].toLowerCase();
			
			//Comparing the entity name in EVDC name with Entity Browser name
			bEVDCNameStatus = sEVDCName.contains(sEntityNameArray[1]);
			
			FrameworkUtil.updateCustomResultBasedOnStatus(bEVDCNameStatus, " EVDC Name consists of the Entity " +sEntityName);
			
			bParentNameStatus = sParentName.equalsIgnoreCase(sParentorg2);
			
			//Comparing the Entity under Parent column with the parent entity
			FrameworkUtil.updateCustomResultBasedOnStatus(bParentNameStatus, " Entity under parent column of EVDC table " +sParentName);
			
			//Logout from Navigator
			LoginTestCase_Old1.nav_Logout();
			
			//Login to Navigator with ishannon user 
		    LoginTestCase_Old1.LoginAsIshannonUser();
		    
		    //Verifying parent of child entity and set the respective parent to child
			AdminTestCase.verifyOrg(sChildorg1, sParentorg2);
			
			//Verifying parent of child entity and set the respective parent to child
			AdminTestCase.verifyOrg(sChildorg2, sParentorg2);
			
			//Verifying parent of child entity and set the respective parent to child
			AdminTestCase.verifyOrg(sChildorg3, sParentorg2);
			
			//Verifying parent of child entity and set the respective parent to child
			AdminTestCase.verifyOrg(sChildorg4, sParentorg1);
			
			//Logout from Navigator
			LoginTestCase_Old1.nav_Signout();
			
		   } catch (Exception e) {
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyEVDCForParentAndChildbySettingRollupButton", "warn", "catch block:" +e.getMessage());
		}
    }
	/*==============================================================
	TestScript  	: verifyCorrectFormatOfPopUpOfNOEVDC
	Manual TestCase	: [QAT-368] WCP_3606_TC_1.0_Correct format for pop up message
	Description		: Verifying correct format of No EVDC PopUp message and Clicking on "yes" button -page navigates to home and "No"-Remains in EVDC Overview Page
	Author 			: QAA03
	Creation Date 	: 01/13/2016
	Release Name    : Keffer
	Pre-Requisites	:
	Revision History:
==============================================================*/
	@Test(priority=50)
	public void verifyCorrectFormatOfPopUpOfNOEVDC()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,EBPanel);
			PageFactory.initElements(driver,EVDC_OverviewPF);
						
			String sFLCOrg=null,sParentOrg=null,sEntityName=null;
			boolean bOrgStatus;
	
		try {
			FrameworkUtil.sTestCaseName = "verifyCorrectFormatOfPopUpOfNOEVDC";
			FrameworkUtil.sManualTestCaseName="[QAT-368] WCP_3606_TC_1.0_Correct format for pop up message ";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			
			sFLCOrg = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.ABCTEST");
			sParentOrg =(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.HOSTEDSOLUTIONS");
		    
		    //Login to navigator with Role-A user
		 	LoginTestCase_Old1.LoginAsRoleA();
		
		 	WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			
			//Clicking on Entity Browser Link
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			
			//Selecting Organization from First Level Children
			EntityBrowserTestCase.selectOrgFromAllLevelsEB(sFLCOrg, "","","");
			
			//Clicking on Entity browser tab
			WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
			
			//verifying No EVDC Popup Message
			verifyNOEVDCPopupMsg();
			
			//Clicking on "Yes" button of Popup Message
			WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_NoEVDCPopUpYesButton());
			
			//Verifying EVDC Link turned to EVDC Image
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCImage());
		
			//Clicking on Entity Browser Link
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			
			//Clicking on Entity Browser Link(Back to Entity)
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			
			//Getting Entity Name
			sEntityName = EBPanel.getNav_EntityBrowserLink().getText();
			
			//Checking the Organization to which page refreshed
            bOrgStatus = sEntityName.equalsIgnoreCase(sParentOrg);
			
			FrameworkUtil.updateCustomResultBasedOnStatus(bOrgStatus, "Home Page refreshed with Data"+sEntityName);
			
			//Navigating to EVDC Overview Page
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			
			//Clicking on Entity Browser Link
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			
			//Selecting Organization from First Level Children
			EntityBrowserTestCase.selectOrgFromAllLevelsEB(sFLCOrg, "","","");
			
			//Clicking on Entity browser tab
			WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
			
			//Clicking on "No" button of Popup Message
			WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_NoEVDCPopUpNoButton());
			
			//Verifying whether page is remained in EVDC Overview Page
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			
			//Logout from Navigator
			LoginTestCase_Old1.nav_Logout();
		
		   } catch (Exception e) {
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyCorrectFormatOfPopUpOfNOEVDC", "warn", "catch block:" +e.getMessage());
		}
    }
	
	/*=================================================================================================
	TestScript  	: verifyManageEntityCopyButtonDestinationField
	Manual TestCase	: [QAT-381] WCP_3398_TC_1.1_Manage Entities_Copy_add type_to destination entity text area
	Description		: verify Manage entity Copy Button Destination field is taking values according to the input
	Author 			: QAA03
	Creation Date 	: 01/14/2016
	Release Name    : Keffer
	Pre-Requisites	:
	Revision History:
	==========================================================================================================*/
	@Test(priority=51)
	public static void verifyManageEntityCopyButtonDestinationField()
	{
		             WebDriver driver = WebDriverUtil.getDriver();
	                              
	        		 PageFactory.initElements(driver,UserPermission);
	        		
	         		 String sEntityorg1=null,sEntityorg2=null;
		          
		        try {
					
					FrameworkUtil.sTestCaseName="verifyManageEntityCopyButtonDestinationField";
					FrameworkUtil.sManualTestCaseName="[QAT-381] WCP_3398_TC_1.1_Manage Entities_Copy_add type_to destination entity text area";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					
					sEntityorg1 = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
					sEntityorg2 = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY02");
				    
					//Navigating to permissions page with Role-A user
					UserPermissionManageEntityTestCase.navigateToManageEntityTab();
					
					//Verifying by entering "tst" in destination field of copy button
					verifyCopydestinationField(sEntityorg1, sEntityorg2, false);
					
					//Logout from Navigator
					LoginTestCase_Old1.nav_Logout();
		
				}   catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyPermissionsChangingParentChildEntities", "warn", "catch block:" +e.getMessage());
				}
		      
		       
	}
	/*====================================================================================================
	Method Name 	: verifyC2CRProductPresentAndClickhereLink
	Description		: Verifying C2CR product present and Click here link
	Author 			: QAA03
	Creation Date 	: 01/06/2016
	Pre-Requisites	:
	Revision History:
	====================================================================================================*/
	public static void verifyC2CRProductPresentAndClickhereLink()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,Draas);
			String sProdText=null;
				
     try { 
    	    sProdText = (String)FrameworkUtil.dictPropertyData.get("NAV.HOME.DRAAS.PRODUCT");
    	    if(WebObjectUtil.VerifyTextUnderElement(Draas.getNav_DraasC2CRProductText(),sProdText))
		    {
		    	if(WebObjectUtil.isElementPresent(Draas.getNav_DRaasClickHereLink()))
		    	{
		    		WebObjectUtil.clickElement(Draas.getNav_DRaasClickHereLink());
		    		WebObjectUtil.explicitWait(5);
		    		verifyC2CRProductresourcesLink();
		    	}
		    	else
		    	{
		    		 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "DraasClickHereLink", "warn", "Draas ClickHere Link is not present");
		    	}
		    }
    	
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyC2CRProductPresentAndClickhereLink", "warn", "catch block:" +e.getMessage());  
		}
		
	}
	
	/*====================================================================================================
	Method Name 	: verifyC2CRProductresourcesLink
	Description		: Verifying C2CR product resources url and link
	Author 			: QAA03
	Creation Date 	: 01/06/2016
	Pre-Requisites	:
	Revision History:
	====================================================================================================*/
	public static void verifyC2CRProductresourcesLink()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,Draas);
			String sParentWindowName=null,sC2CRProdChilink=null,sC2CRProdRallink=null;
			boolean bC2CRProdChiStatus,bC2CRProdRalStatus;
				
     try { 
    	 
    	    sC2CRProdChilink = (String)FrameworkUtil.dictPropertyData.get("NAV.DRAAS.C2CRPRODUCT.CHI");
			sC2CRProdRallink = (String)FrameworkUtil.dictPropertyData.get("NAV.DRAAS.C2CRPRODUCT.RAL");
			
    	     if(!WebObjectUtil.isElementPresent(Draas.getNav_DraasC2CRProductPopUpBox()))
    		   {
	    			sParentWindowName = driver.getWindowHandle();
	    			WebObjectUtil.switchToWindow(2,"");
	    			bC2CRProdChiStatus=WebObjectUtil.verifyUrl(sC2CRProdChilink);
	    			FrameworkUtil.updateCustomResultBasedOnStatus(bC2CRProdChiStatus, "C2CRProductResource-Chicago-IL url verified");
	    			driver.close();
	    		    driver.switchTo().window(sParentWindowName);
    			    
    		   }
    		else
    		{
    			if(Draas.getNav_DRaasC2CRProdChilink().getAttribute("href").contentEquals(sC2CRProdChilink))
    		     {
	    			   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "C2CRProductResource-Chicago-IL", "pass", "C2CRProductResource-Chicago-IL is a link as expected");
	    			   sParentWindowName =driver.getWindowHandle();
	    			   WebObjectUtil.clickElement(Draas.getNav_DRaasC2CRProdChilink());
	    			   WebObjectUtil.switchToWindow(2,"");
	    			   bC2CRProdChiStatus=WebObjectUtil.verifyUrl(sC2CRProdChilink);
	    			   FrameworkUtil.updateCustomResultBasedOnStatus(bC2CRProdChiStatus, "C2CRProductResource-Chicago-IL url verified");
	    	   		   driver.close();
	    			   driver.switchTo().window(sParentWindowName);
    	   		   
    		     }
    		   else
    		    {
    			      FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "C2CRProductResource-Chicago-IL", "warn", "C2CRProductResource-Chicago-IL is not a link");
    		    }
    		   if(Draas.getNav_DRaasC2CRProdRallink().getAttribute("href").contentEquals(sC2CRProdRallink))
    		   {
	    			   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "C2CRProductResource-Raleigh-NC", "pass", "C2CRProductResource-Raleigh-NC is a link as expected");
	    			   sParentWindowName =driver.getWindowHandle();
	    			   WebObjectUtil.clickElement(Draas.getNav_DRaasC2CRProdRallink());
	    			   WebObjectUtil.switchToWindow(2,"");
	    			   bC2CRProdRalStatus=WebObjectUtil.verifyUrl(sC2CRProdRallink);
	    			   FrameworkUtil.updateCustomResultBasedOnStatus(bC2CRProdRalStatus, "C2CRProductResource-Raleigh-NC url verified");
	    	   		   driver.close();
	    			   driver.switchTo().window(sParentWindowName);
    	   		   
    		   }
    		   else
    		   {
    			       FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "C2CRProductResource-Raleigh-NC", "warn", "C2CRProductResource-Raleigh-NC is not a link");
    		   }
    		}
    				    		

    	    
			  
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyC2CRProductresourcesLink", "warn", "catch block:" +e.getMessage());  
		}
		
	}
	
	/*====================================================================================================
	Method Name 	: getParentChildEntitiesNames
	Description		: Getting Parent and its Child entity Names in  one string seperated by commas
	Author 			: QAA03
	Creation Date 	: 01/12/2016
	Pre-Requisites	: 
	Revision History:
	====================================================================================================*/
	public static String getParentChildEntitiesNames()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,EBPanel);
			String sParentEntityName=null,sArrayChildEntityLists=null,sParentChildEntitiesSeperatedbyCommas=null;;
			int iChildEntityLists=0;
				
	 try {
		    sParentEntityName = EBPanel.getNav_EntityBrowserLink().getText();
			
			//Clicking on Entity Browser Link
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			 
			String[] arrChildEntityList = EntityBrowserTestCase.getChildOrgNameListFromEBPanel(1);
			
		    iChildEntityLists = arrChildEntityList.length;
			for(int i=0;i<iChildEntityLists;i++)
			{
				 sArrayChildEntityLists = ",".concat(arrChildEntityList[i]);
				 sParentChildEntitiesSeperatedbyCommas = sParentEntityName.concat(sArrayChildEntityLists);
			}
			//Clicking on Entity browser tab
			WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
		
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "getParentChildEntitiesNames", "warn", "catch block:" +e.getMessage());  
		}
	 return sParentChildEntitiesSeperatedbyCommas; 
		
	}

	/*====================================================================================================
	Method Name 	: verifyOrgNameinTicket
	Description		: Verify Organization Name in Ticket
	Author 			: QAA03
	Creation Date 	: 01/13/2016
	Pre-Requisites	: 
	Revision History:
	====================================================================================================*/
	public static void verifyOrgNameinTicket(String sOrgName)
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,Ticket);
			WebElement wTktExpander,wTicketExpOrgName;
			String sTicketExpOrgName=null;
			boolean bTktOrgStatus;
	
	 try {
		    wTktExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
			WebObjectUtil.clickElement(wTktExpander);
			
			wTicketExpOrgName = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER.ORGNAME", "PARAMETER_ROWNUMBER", 1 +"");                                                              
			sTicketExpOrgName=wTicketExpOrgName.getText();
			 
			bTktOrgStatus = sTicketExpOrgName.equalsIgnoreCase(sOrgName);
			
			FrameworkUtil.updateCustomResultBasedOnStatus(bTktOrgStatus, "OrgName in Ticket matched the selected Entity"+sOrgName);
		    
			
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyOrgNameinTicket", "warn", "catch block:" +e.getMessage());  
		}
	
	}
	
	/*====================================================================================================
	Method Name 	: verifyEVDCSelectorWithOrgName
	Description		: Verify EVDCSelector Name matches with Org Name
	Author 			: QAA03
	Creation Date 	: 01/13/2016
	Pre-Requisites	: 
	Revision History:
	====================================================================================================*/
	public static void verifyEVDCSelectorWithOrgName(String sOrgName)
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,EVDC_OverviewPF);
			String sEVDCSelect=null;
			boolean bEVDCSelStatus;
	
	 try {
		   
		    WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			
			sEVDCSelect=EVDC_OverviewPF.getNav_EVDCOrgSelector().getText();
			
			String sEVDCName[]=sEVDCSelect.split("-");
			sOrgName =sOrgName.replaceAll("\\s+","");
			bEVDCSelStatus=sEVDCName[1].trim().equalsIgnoreCase(sOrgName);
			FrameworkUtil.updateCustomResultBasedOnStatus(bEVDCSelStatus, " EVDCSelector Displays Organization Selected "+sOrgName);
			
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyEVDCSelectorWithOrgName", "warn", "catch block:" +e.getMessage());  
		}
	 
		
	}

	/*====================================================================================================
	Method Name 	: verifyTicketDataPresentForOrg
	Description		: Verify Ticket Data is present for the selected organization
	Author 			: QAA03
	Creation Date 	: 01/13/2016
	Pre-Requisites	: 
	Revision History:
	====================================================================================================*/
	public static void verifyTicketDataPresentForOrg(String sOrgName)
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,Ticket);
			WebElement wOrgName;
	
	 try {
		    WebObjectUtil.SetValueEdit(Ticket.getNav_TicketOrgWebList(),sOrgName);
		    
		    wOrgName = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.ORGNAME.EDIT", "PARAMATER_ORGNAME", sOrgName);
		    wOrgName.click();    
		    
		    WebObjectUtil.explicitWait(5);
		    CustomWebElementUtil.loadCustomElement(Ticket.getNav_TicketsWebTable(), "table");
		    int iRowCount = CustomWebElementUtil.iRowCount;
		    if(iRowCount>0)
		      {
		    	  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying Ticket Data", "pass", "Ticket Data for organization selected"+sOrgName);
		      }
		     else
		      {
		    	  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying Ticket Data", "fail", "No Ticket Data available for selected organization"+sOrgName);
		      }
		   
			
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyTicketDataPresentForOrg", "warn", "catch block:" +e.getMessage());  
		}
	
	}
	/*====================================================================================================
	Method Name 	: verifyNOEVDCPopupMsg
	Description		: verifying No EVDC Popup Message
	Author 			: QAA03
	Creation Date 	: 01/13/2016
	Pre-Requisites	: 
	Revision History:
	====================================================================================================*/
	public static void verifyNOEVDCPopupMsg()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,EVDC_OverviewPF);
			String sNOEVDCMsg=null,sNOEVDCPopup=null;
	        boolean bNoEVDCPopupStatus;
	 try {
		    sNOEVDCPopup = (String)FrameworkUtil.dictPropertyData.get("NAV.NOEVDC.POPUP.MESSAGE");
		   
		    WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_NoEVDCPopUpMessage());
			
			sNOEVDCMsg =EVDC_OverviewPF.getNav_NoEVDCPopUpMessage().getText();
			
			bNoEVDCPopupStatus = sNOEVDCMsg.equalsIgnoreCase(sNOEVDCPopup);
			
			FrameworkUtil.updateCustomResultBasedOnStatus(bNoEVDCPopupStatus, "No EVDC Popup Message");
		    
			
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyNOEVDCPopupMsg", "warn", "catch block:" +e.getMessage());  
		}
	 
		
	}
	
	/*==============================================================
	Method Name       : verifyCopydestinationField
	Description       : It will copy to destination
	Author            : QAA03
	Creation Date     : 01/14/2016
	Pre-Requisites    :
	Revision History:
	==============================================================*/
	public static void verifyCopydestinationField(String sEntity,String sDestination,boolean bFlag)
	{
		
		int iRowCount,iRowNo=0;
		WebElement wDest;
		String sConfirmMsg=null,sExpectedMessage=null,sActualMessage=null;
		boolean bStatus;
		
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, ManageEntity);
		PageFactory.initElements(driver,UserPermission);
		PageFactory.initElements(driver, Common);
		
		
		try {
			
			//User feedback message will change based on cascade checkbox, so fixing the same based on bFlag value.
			if(bFlag)
			{
				sExpectedMessage="Successfully copied permissions from "+sEntity+" to "+sDestination +" and its children";
			}
			else
			{
				sExpectedMessage="Successfully copied permissions from "+sEntity+" to "+sDestination;
			}
			
			//Clicking on Copy button
			UserPermissionManageEntityTestCase.clickonEditCopyIconManageEntity(sEntity, null, "copy");
			WebObjectUtil.explicitWait(5);
			
			WebObjectUtil.clickElement(ManageEntity.getNav_DestEntityDropDownArrow());
			WebObjectUtil.explicitWait(5);
			
			WebObjectUtil.SetValueEdit(ManageEntity.getNav_ManageEntityCopyEdit(),"tst" );
			WebObjectUtil.explicitWait(1);
			
			WebObjectUtil.verifyElementPresent(ManageEntity.getNav_CopyDestParentWebTable());
			
			WebObjectUtil.SetValueEdit(ManageEntity.getNav_ManageEntityCopyEdit(),sDestination );
			WebObjectUtil.explicitWait(1);
			//Loading the table
			CustomWebElementUtil.loadCustomElement(ManageEntity.getNav_CopyDestParentWebTable(), "table");
			//Getting the row count
			iRowCount=CustomWebElementUtil.iRowCount;
			
			//Looping and clicking on the Destination
			//for(int k=1;k<iRowCount;k++)
			for (WebElement wb : CustomWebElementUtil.rowsWebElementList)
			{
				iRowNo++;
/*	         	//WebElement wDest=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTreePanelPickerTree']//table["+k+"]/tbody/tr/td/div/span", "Copy DropDown");
				//wDest= WebObjectUtil.getWebElementFromDynamicLocator("xpath", "UP.MANAGEENTITY.COPY.DESTINATION", "PARAMETER_ROWNUMBER", k+"");
				wDest= WebObjectUtil.getWebElementFromDynamicLocator("xpath", "UP.MANAGEENTITY.COPY.DESTINATION", "PARAMETER_ROWNUMBER", iRowNo+"");
				//WebObjectUtil.MouseHover(wDest);
*/

				if(wb.getText().trim().equalsIgnoreCase(sDestination))
				{
					wDest= WebObjectUtil.getWebElementFromDynamicLocator("xpath", "UP.MANAGEENTITY.COPY.DESTINATION", "PARAMETER_ROWNUMBER", iRowNo+"");
					wDest.click();
					WebObjectUtil.explicitWait(5);
					
					//Verifying Submit,Cancel Button and Cascade CheckBox
					WebObjectUtil.verifyElementPresent(ManageEntity.getNav_EM_Copy_CascadeChkBox());
					WebObjectUtil.verifyElementPresent(UserPermission.getNav_EM_Edit_CancelBtn());
					WebObjectUtil.verifyElementPresent(ManageEntity.getNav_CopyDialogSubmitBtn());
					
					//Checking the cascade check box based on bFlag status
					WebObjectUtil.explicitWait(2);
					if(bFlag){
						WebObjectUtil.selectCheckRadioBox(ManageEntity.getNav_EM_Copy_CascadeChkBox());
					}
					
					//Clicking on submit button
					WebObjectUtil.explicitWait(2);
					WebObjectUtil.clickElement(ManageEntity.getNav_CopyDialogSubmitBtn());
					
					//Verifying pop confirmation
					WebObjectUtil.waitForElementPresent(Common.getNav_CommonPopUp());
					if(WebObjectUtil.isElementPresent(Common.getNav_CommonPopUp()))
					{
						sConfirmMsg=Common.getNav_CommonPopUpMessage().getText().trim();
						bStatus=sExpectedMessage.equals(sConfirmMsg);
						FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "PopUp Message -  "+sConfirmMsg);
						WebObjectUtil.clickElement(Common.getNav_CommonPopUpOKButton());
					}
					//Verifying the FeedBack message
					sActualMessage=Common.getNav_UsrFeedBack().getText().trim();
					bStatus=sExpectedMessage.equals(sActualMessage);
					FrameworkUtil.updateCustomResultBasedOnStatus(bStatus,"Actual Message -" +sActualMessage + "    Expected Message -" +sExpectedMessage);
					break;
				}
			}
			
			
			
			
		} catch (Exception e) {
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
	}
		
	
@AfterMethod
public static void afterEachMethod(){
		FrameworkUtil.updateTestCaseStatusinResult();
		
	}

}
