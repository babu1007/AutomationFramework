package com.whs.navigator.testcases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.james.mime4j.parser.MimeEntity;
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
import com.whs.navigator.pagefactory.DraasPageFactory;
import com.whs.navigator.pagefactory.EVDC_FirewallPageFactory;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.EVDC_VM_PageFactory;
import com.whs.navigator.pagefactory.EntityBrowserPageFactory;
import com.whs.navigator.pagefactory.TicketPageFactory;
import com.whs.navigator.pagefactory.UserPermissionPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.AdminPageFactory;
import com.whs.navigator.pagefactory.UserPermissionMultiOrgPageFactory;
import com.whs.navigator.pagefactory.CommonPageFactory;

public class EntityBrowserTestCase {
	public static HomePageFactory_old Home = new HomePageFactory_old();
	public static EntityBrowserPageFactory EBPanel = new EntityBrowserPageFactory();
	public static TicketPageFactory Ticket = new TicketPageFactory();
	public static TicketTestCase TicketTC =new TicketTestCase();
	public static UserPermissionPageFactory UserPerm = new UserPermissionPageFactory();
	public static UserPermissionTestCase UserPermTC=new UserPermissionTestCase();
	public static EVDC_OverviewPageFactory EVDC = new EVDC_OverviewPageFactory();
	public static EVDC_VM_PageFactory EVDCVM = new EVDC_VM_PageFactory();
	public static AdminPageFactory Admin = new AdminPageFactory();
	public static UserPermissionMultiOrgPageFactory UPMultiOrg = new UserPermissionMultiOrgPageFactory();
	public static  EVDC_FirewallPageFactory Firewall = new EVDC_FirewallPageFactory();
	public static DraasPageFactory Draas = new DraasPageFactory();
	public static CommonPageFactory Common = new CommonPageFactory();
	
	public static String sFirstRowChild;
	public static String[] arrOrgNameFromEBPanel;
	 
	/*====================================================================================================
	TestScript  	: verifyChildEntityCreatorCreateTicket
	Manual TestCase	: CPPOC-3017,3233 Verifying Child Entity and Creator in Created Ticket
	Description		: Verifying Child Entity and Creator in Created Ticket
	Author 			: QAA03
	Release Name    : Clark-Sp1
	Creation Date 	: 08/20/2015
	Pre-Requisites	: Corresponding parent and child entities should be created using "verifyParentChildEntity" method
	Revision History:
	======================================================================================================*/
	@Test(priority=98)
	public static void verifyChildEntityCreatorCreateTicket()
	{

	     WebDriver driver = WebDriverUtil.getDriver();
	     PageFactory.initElements(driver, EBPanel);
	     PageFactory.initElements(driver, Ticket);
	     String sUserName=null,sPassword=null,sChildorg=null,sParentorg=null;
	              
	 try {
			FrameworkUtil.sTestCaseName = "verifyChildEntityCreatorCreateTicket";
			FrameworkUtil.sManualTestCaseName="CPPOC-3017,3233 Verifying Child Entity and Creator in Created Ticket";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEA.USERID");
		    sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEA.PASSWORD");
			
			sChildorg = (String)FrameworkUtil.dictPropertyData.get("NAV.QA.UPGRADE.ENTITYMGT.CHILDORGNAME");
		    sParentorg = (String)FrameworkUtil.dictPropertyData.get("NAV.QA.UPGRADE.ENTITYMGT.PARENTORGNAME");
		    AdminTestCase.verifyParentChildEntity(sChildorg,sParentorg);
		    
		    
			//LoginTestCase.nav_Login(sUserName, sPassword);
			
			LoginTestCase_Old1.LoginAsRoleAUser();
			
			verifyOrgCreatorCreateTicket();
			LoginTestCase_Old1.nav_Logout();
			
		} catch (Exception e) {
			LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyChildEntityCreatorCreateTicket", "warn", "catch block:Could NOT access webelement" +e.getMessage());
		}
	}
	
	////////////////////////////////////////////////Taken From ByronTextCase.Java/////////////////////////////
	/*==============================================================
	TestScript  	: navValEntityNameMatchesWithOrgName
	Manual TestCase	: CPPOC-2797
	Description		: Validate Selected org is displayed at top EB panel and home page
	Author 			: Sukur Babu. B
	Creation Date 	: 28/07/2015
	Release Name    : Byron
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=50)
	public void navValEntityNameMatchesWithOrgName()
	{
		String sOrgToSelect;
		try{
		FrameworkUtil.sTestCaseName = "EBPanel-navValEntityNameMatchesWithOrgName";
		FrameworkUtil.sManualTestCaseName= "CPPOC-2797";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EBPanel);
		sOrgToSelect=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.ORGNAME.TO.TSTDEVCO");
		//login to catalog
		LoginTestCase_Old1.LoginAsARoleAUser();
						
		//Navigating to Catalog Page
		navSelectOrgFromEBPanel(sOrgToSelect);
		
		LoginTestCase_Old1.nav_Logout();
		}
		catch(Exception e)
		{
			LoggerUtil.log_type_error("issue with- navValEntityNameMatchesWithOrgName Test Case" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	

	/*==============================================================
	TestScript  	: navValBackWardEntityLinkFunctionality
	Manual TestCase	: CPPOC-2798
	Description		:Validate Backward Entity Link Functionality
	Author 			: Sukur Babu. B
	Creation Date 	: 28/07/2015
	Release Name    : Byron
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=51)
	public void navValBackWardEntityLinkFunctionality()
	{
		String sOrgToSelect,sLinkTxt,sDfltOrginEBPanel,sDefltOrginHomePage,sBackToUrEntityDisabled;
		try{
		FrameworkUtil.sTestCaseName = "EBPanel-navValBackWardEntityLinkFunctionality";
		FrameworkUtil.sManualTestCaseName= "CPPOC-2798";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EBPanel);
		sOrgToSelect=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.ORGNAME.TO.TSTDEVCO");
		sDfltOrginEBPanel=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.DEFAULT.ORG");
		sDefltOrginHomePage=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOMEPAGE.DEFAULT.ORG");
		//login to catalog
		LoginTestCase_Old1.LoginAsARoleAUser();
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		WebObjectUtil.explicitWait(5);
		sBackToUrEntityDisabled=EBPanel.getNav_EntityBrowserLink().getAttribute("class");
		if(sBackToUrEntityDisabled.contains("disabledFooter"))
			FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Back to your Entity link is grayed out before selecting any first level chield from EB Panel");
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false,  "Back to your Entity link is not grayed out before selecting any first level chield from EB Panel");
		//Navigating to Catalog Page
		navSelectOrgFromEBPanel(sOrgToSelect);
		sBackToUrEntityDisabled=EBPanel.getNav_EntityBrowserLink().getAttribute("class");
		if(sBackToUrEntityDisabled.contains("disabledFooter"))
			FrameworkUtil.updateCustomResultBasedOnStatus(false,  "Back to your Entity link is still grayed out after selecting first level chield from EB Panel");
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Back to your Entity link is not grayed out after selecting first level chield from EB Panel");
		//Click on Entity Browser link from EB panel
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		WebObjectUtil.waitForElementPresent(EBPanel.getNav_FirstLevelChildrenEditBox());
		sLinkTxt= EBPanel.getNav_EntityBrowserLink().getText();
		if(sLinkTxt.equalsIgnoreCase("Back to your Entity"))
		{
			FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Back to your Entity link displays in EB Panel" );
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			WebObjectUtil.explicitWait(5);
			sLinkTxt= EBPanel.getNav_EntityBrowserLink().getText();
			String sTag=EBPanel.getNav_EntityBrowserLink().getTagName();
			/*if(sTag.equalsIgnoreCase("a"))
				FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Back to Your Entity is displayed as link" );
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false,  "Back to Your Entity is not displayed as link" );*/
			if(sLinkTxt.equalsIgnoreCase(sDfltOrginEBPanel))
			{
				FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Default Orgnaization displayed after clicking Back to Your Entity link" );
				WebElement wOrgItemtoSelect=WebObjectUtil.GetWebElement("xpath", "//li[@id='organization']", "OrgItem");
				sLinkTxt=wOrgItemtoSelect.getText();
				if(sLinkTxt.equalsIgnoreCase(sDefltOrginHomePage))
					FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Default Orgnaization displayed in home page after clicking Back to Your Entity link" );
				else
					FrameworkUtil.updateCustomResultBasedOnStatus(false,  "Default Orgnaization is not displayed in home page after clicking Back to Your Entity link" );
			}
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false,  "Default Orgnaization is not displayed after clicking Back to Your Entity link" );
			
		}
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false,  "Back to your Entity link not displayed in EB Panel" );
		LoginTestCase_Old1.nav_Logout();
		}
		catch(Exception e)
		{
			LoggerUtil.log_type_error("issue with- navValEntityNameMatchesWithOrgName Test Case" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	TestScript  	: navValOrgDataBasedOnselectionOfOrgFromEBPanel
	Manual TestCase	: CPPOC-2802
	Description		: Validate Backward Entity Link Functionality
	Author 			: Sukur Babu. B
	Creation Date 	: 30/07/2015
	Release Name    : Byron
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=52)
	public void navValOrgDataBasedOnselectionOfOrgFromEBPanel()
	{
		String sOrgToSelect,sUserName,sPassword,sOrgName1,sTSTDevcoTicketOtStndingCnt,sTSTDevcoTicketRslvedCnt,sEBTSTDevcoTicketOtStndingCnt;
		String sEBTSTDevcoTicketRslvedCnt,sEBTSTDEVcoEVDCName,sTSTDEVcoEVDCName;
		try{
		FrameworkUtil.sTestCaseName = "EBPanel-navValOrgDataBasedOnselectionOfOrgFromEBPanel";
		FrameworkUtil.sManualTestCaseName= "CPPOC-2802";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EBPanel);
		PageFactory.initElements(driver, Ticket);
		
		sOrgToSelect=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.ORGNAME.TO.TSTDEVCO");
		//TST Devco Logsin and get ticket portlet count and evdc name
		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO.USERID.AROLE");
		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO.PASSWORD.AROLE");
		//LoginTestCase.nav_Login(sUserName,sPassword);
		LoginTestCase_Old1.LoginAsDevcoUser();
		//LoginTestCase.LoginAsQaautoUser();
		sTSTDevcoTicketOtStndingCnt=EBPanel.getNav_OutStandingTicketCntInHmPg().getText();
		sTSTDevcoTicketRslvedCnt=EBPanel.getNav_ResolvedTicketCntInHmPg().getText();
		sTSTDEVcoEVDCName=EBPanel.getNav_EVDCPortalLink().getText();
		LoginTestCase_Old1.nav_Logout();
		
		//login to catalog
		LoginTestCase_Old1.LoginAsARoleAUser();
		//Navigating to Catalog Page
		navSelectOrgFromEBPanel(sOrgToSelect);
		sEBTSTDevcoTicketOtStndingCnt=EBPanel.getNav_OutStandingTicketCntInHmPg().getText();
		sEBTSTDevcoTicketRslvedCnt=EBPanel.getNav_ResolvedTicketCntInHmPg().getText();
		sEBTSTDEVcoEVDCName=EBPanel.getNav_EVDCPortalLink().getText();
		
		if(Integer.parseInt(sEBTSTDevcoTicketOtStndingCnt)==Integer.parseInt(sTSTDevcoTicketOtStndingCnt))
			FrameworkUtil.updateCustomResultBasedOnStatus(true,  "TST Devco Outstanding ticket count is matching with the data displayed after selecting organization TST Devco from EB Panel" );
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false,  "TST Devco Outstanding ticket count is not matching with the data displayed after selecting organization TST Devco from EB Panel" );
		
		if(Integer.parseInt(sEBTSTDevcoTicketRslvedCnt)==Integer.parseInt(sTSTDevcoTicketRslvedCnt))
			FrameworkUtil.updateCustomResultBasedOnStatus(true,  "TST Devco Resolved ticket count is matching with the data displayed after selecting organization TST Devco from EB Panel" );
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false,  "TST Devco Resolved ticket count is not matching with the data displayed after selecting organization TST Devco from EB Panel" );
		
		if(sEBTSTDEVcoEVDCName.equalsIgnoreCase(sTSTDEVcoEVDCName))
			FrameworkUtil.updateCustomResultBasedOnStatus(true,  "TST Devco EVDC Name is matching with the data displayed after selecting organization TST Devco from EB Panel" );
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false,  "TST Devco EVDC Name is not matching with the data displayed after selecting organization TST Devco from EB Panel" );
		LoginTestCase_Old1.nav_Logout();
		}
		catch(Exception e)
		{
			LoggerUtil.log_type_error("issue with- navValOrgDataBasedOnselectionOfOrgFromEBPanel Test Case" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	

	/*==============================================================
	TestScript  	: navValAccesstoLinksFromEVDCPageAfterSelectingOrgFrmEBPanel
	Manual TestCase	: CPPOC-2840
	Description		:Validate whether user is having permission to view Firewall, VM and catalog pages after selecting Org from EB Panel
	Author 			: Sukur Babu. B
	Creation Date 	: 30/07/2015
	Release Name    : Byron
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=55)
	public void navValAccesstoLinksFromEVDCPageAfterSelectingOrgFrmEBPanel()
	{
		String sOrgToSelect;
		try{
		FrameworkUtil.sTestCaseName = "EBPanel-navValAccesstoLinksFromEVDCPageAfterSelectingOrgFrmEBPanel";
		FrameworkUtil.sManualTestCaseName= "CPPOC-2840";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EBPanel);
		PageFactory.initElements(driver, Ticket);
		PageFactory.initElements(driver, Home);
		PageFactory.initElements(driver, EVDC);
		sOrgToSelect=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.ORGNAME.TO.TSTDEVCO");
		//login to catalog
		LoginTestCase_Old1.LoginAsARoleAUser();
		
		navSelectOrgFromEBPanel(sOrgToSelect);
		
		navigateToEVDCPageFrmHmpgAndVerifyEVDCPageDisplay();
		WebObjectUtil.explicitWait(2);
		//WebObjectUtil.clickElement(EBPanel.getNav_WSLogo());
		//updated below lines by QAA03 on 07/22/2016
		//WebObjectUtil.clickElement(EBPanel.getNav_HomeBreadCrumb());
		//WebObjectUtil.clickElement(Home.getNav_HomeBreadcrumb());
		WebObjectUtil.clickByJS(Home.getNav_HomeBreadcrumb());
		WebObjectUtil.explicitWait(5);
		navigateToFirewallPageFrmEVDCAndVerifyFirewallPageDisplay();
		//WebObjectUtil.clickElement(EBPanel.getNav_WSLogo());
		//updated below lines by QAA03 on 07/22/2016
		//WebObjectUtil.clickElement(EBPanel.getNav_HomeBreadCrumb());
		WebObjectUtil.clickElement(Home.getNav_HomeBreadcrumb());
		WebObjectUtil.explicitWait(5);
		navigateToVMPageFrmHmPgAndVerifyVMPageDisplay();
		//WebObjectUtil.clickElement(EBPanel.getNav_WSLogo());
		//updated below lines by QAA03 on 07/22/2016
		//WebObjectUtil.clickElement(EBPanel.getNav_HomeBreadCrumb());
		WebObjectUtil.clickElement(Home.getNav_HomeBreadcrumb());
		WebObjectUtil.explicitWait(20);
		navigateToCtlgPageFrmHmPgAndVerifyCtlgPageDisplay();
		LoginTestCase_Old1.nav_Logout();
		}
		catch(Exception e)
		{
			LoggerUtil.log_type_error("issue with- navValAccesstoLinksFromEVDCPageAfterSelectingOrgFrmEBPanel Test Case" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
}
	/*==============================================================
	TestScript  	: navValEBPanelPopUpNotDisplayedinVMPage
	Manual TestCase	: CPPOC-2861
	Description		: Verify EBPanel Pop up Not displayed after doing browser refresh.
	Author 			: Sukur Babu. B
	Creation Date 	: 31/07/2015
	Release Name    : Byron
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=61)
	public void navValEBPanelPopUpNotDisplayedinVMPage()
	{
		String sOrgToSelect,sUserName,sPassword,sOrgName1,sTSTDevcoTicketOtStndingCnt,sTSTDevcoTicketRslvedCnt,sEBTSTDevcoTicketOtStndingCnt;
		String sEBTSTDevcoTicketRslvedCnt,sEBTSTDEVcoEVDCName,sTSTDEVcoEVDCName;
		try{
		FrameworkUtil.sTestCaseName = "EBPanel-navValEBPanelPopUpNotDisplayedinVMPage";
		FrameworkUtil.sManualTestCaseName= "CPPOC-2861";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EBPanel);
		PageFactory.initElements(driver, Ticket);
		PageFactory.initElements(driver, EVDC);
		
		
		
		//login to catalog
		LoginTestCase_Old1.LoginAsARoleAUser();
		navigateToVMPageFrmHmPgAndVerifyVMPageDisplay();
		driver.navigate().refresh();
		if(EBPanel.getNav_TopSliderIcon().isDisplayed())
			FrameworkUtil.updateCustomResultBasedOnStatus(false,  "EB Panel pop up displayed is displayed after browser refresh." );
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(true,  "EB Panel pop up not displayed after browser refresh." );
		LoginTestCase_Old1.nav_Logout();
		}
		catch(Exception e)
		{
			LoggerUtil.log_type_error("issue with- navValEBPanelPopUpNotDisplayedinVMPage Test Case" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	/*==============================================================
	TestScript  	: navValEBPanelPopUpNotDisplayedInTicketsPage
	Manual TestCase	: CPPOC-2852
	Description		: Verify EBPanel Pop up Not displayed after doing browser refresh.
	Author 			: Sukur Babu. B
	Creation Date 	: 31/07/2015
	Release Name    : Byron
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=62)
	public void navValEBPanelPopUpNotDisplayedInTicketsPage()
	{
		String sOrgToSelect,sUserName,sPassword,sOrgName1,sTSTDevcoTicketOtStndingCnt,sTSTDevcoTicketRslvedCnt,sEBTSTDevcoTicketOtStndingCnt;
		String sEBTSTDevcoTicketRslvedCnt,sEBTSTDEVcoEVDCName,sTSTDEVcoEVDCName;
		try{
		FrameworkUtil.sTestCaseName = "EBPanel-navValEBPanelPopUpNotDisplayedInTicketsPage";
		FrameworkUtil.sManualTestCaseName= "CPPOC-2852";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EBPanel);
		PageFactory.initElements(driver, Ticket);
		
		
		
		//login to catalog
		LoginTestCase_Old1.LoginAsARoleAUser();
		TicketTC.navigateToTicketPage();
		driver.navigate().refresh();
		if(EBPanel.getNav_TopSliderIcon().isDisplayed())
			FrameworkUtil.updateCustomResultBasedOnStatus(false,  "EB Panel pop up displayed is displayed after browser refresh." );
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(true,  "EB Panel pop up not displayed after browser refresh." );
		LoginTestCase_Old1.nav_Logout();
		}
		catch(Exception e)
		{
			LoggerUtil.log_type_error("issue with- navValEBPanelPopUpNotDisplayedInTicketsPage Test Case" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	
	



/*==============================================================
TestScript 		: validateOrgNameDisplayedInFirstLevelAreAllNotCAPS
Manual TestCase	:  CPPOC-2842
Description		: Verifying organizations displayed in FirstLevel Children are not in Caps
Author 			: Sukur Babu. B
Creation Date 	: 31/06/2015
Release Name    : Byron
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=60)
public void validateOrgNameDisplayedInFirstLevelAreAllNotCAPS(){
	String sTicketID,sID,sNotes;
	
	//TicketsPageFactory_Sukur Ticket = new TicketsPageFactory_Sukur();
	try {
		WebDriver driver = WebDriverUtil.getDriver();
		sNotes=(String)FrameworkUtil.dictPropertyData.get("NAV.CREATETICKET.NOTES");
		PageFactory.initElements(driver, TicketTestCase.Ticket);
		FrameworkUtil.sTestCaseName = "Tickets-validateOrgNameDisplayedInFirstLevelAreAllNotCAPS";
		FrameworkUtil.sManualTestCaseName="CPPOC-2842 Verifying organizations displayed in FirstLevel Children are not in Caps";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		PageFactory.initElements(driver, EBPanel);
		PageFactory.initElements(driver, Ticket);
		//login to catalog
		LoginTestCase_Old1.LoginAsARoleAUser();
		
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());   
		CheckOrgNamesNotCaps();
		LoginTestCase_Old1.nav_Logout();
		}
		catch(Exception e)
	{
		LoggerUtil.log_type_error("issue with- validateOrgNameDisplayedInFirstLevelAreAllNotCAPS Test Case" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
}
	
////////////////////////////////////////////////Taken From ByronTextCase.Java/////////////////////////////

/*==============================================================
Method Name 	: navEBPanelLogin
Description		: Login to Catalog using devco1
Author 			: Sukur Babu
Creation Date 	: 28/07/2015
Pre-Requisites	:
Revision History:
==============================================================*/
public static void navEBPanelLogin()
{
	String sUserName,sPassword;
	try{
	sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.USERID.AROLE");
	sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.PASSWORD.AROLE");
	//LoginTestCase.nav_Login(sUserName,sPassword);
	LoginTestCase_Old1.LoginAsARoleAUser();
	}
	catch(Exception e)
	{
		LoggerUtil.log_type_error("issue with- navEBPanelLogin method" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
}
/*==============================================================
Method Name 	: navSelectOrgFromEBPanel
Description		: Selects the organization from Entity Browser Panel based on the parameters
Ex: navSelectOrgFromEBPanel("1st Level WebTable, "Value")--Selects the organization from 1st lavel
children
Author 			: Sukur Babu
Creation Date 	: 28/07/2015
Pre-Requisites	:
Revision History:
==============================================================*/
public static void navSelectOrgFromEBPanel(String sOrgNameToSelect)
{
	String sActOrgNameinEBPanelBforeClick,sActOrgNameinEBPanelAftClerickinMainPage;
	
	try{
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		WebObjectUtil.waitForElementPresent(EBPanel.getNav_FirstLevelChildrenEditBox());
		WebObjectUtil.verifyElementPresent(EBPanel.getNav_FirstLevelChildrenEditBox());
		WebObjectUtil.SetValueEdit(EBPanel.getNav_FirstLevelChildrenEditBox(), sOrgNameToSelect);
		WebElement wOrgItemtoSelect=WebObjectUtil.GetWebElement("xpath", "//table[contains(@id,'table')]//div[text()='"+sOrgNameToSelect+"']", "OrgItem");
		wOrgItemtoSelect.click();
		sActOrgNameinEBPanelBforeClick=EBPanel.getNav_OrgNameTitleLink().getText();
		if(sActOrgNameinEBPanelBforeClick.equalsIgnoreCase(sOrgNameToSelect))
		{
			FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Selected Organization is displayed at top of EB Panel" );
			WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
			WebElement wOrgNameinMainPage=WebObjectUtil.GetWebElement("xpath", "//li[@id='organization']", "Displayed Org Name");
			sActOrgNameinEBPanelAftClerickinMainPage=wOrgNameinMainPage.getText();
			if(sActOrgNameinEBPanelAftClerickinMainPage.equalsIgnoreCase(sOrgNameToSelect))
				FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Selected Organization is displayed In Home Page" );
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false,  "Selected Organization is not displayed In Home Page" );
		}
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false,  "Selected Organization is not displayed at top of EB Panel" );
		
	}
	catch(Exception e)
	{
		LoggerUtil.log_type_error("issue with- navSelectOrgFromEBPanel method" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}		
}


/*==============================================================
TestScript  	: verifyEBTicketPage
Manual TestCase	: CPPOC-2859 Verify Ticket is Created after selecting org from entity browser
Description		: Verify Ticket is Created after selecting org from entity browser
Author 			: Priyanka Rachupalli
Creation Date 	: 29/07/2015
Release Name    : Byron
Pre-Requisites	:
Revision History:
==============================================================*/
		@Test(priority=1)
		public void verifyEBTicketPage()
		{
			PageFactory.initElements(WebDriverUtil.getDriver(),EBPanel);
			PageFactory.initElements(WebDriverUtil.getDriver(),Ticket);
			String sOrgToSelect;
			try{
			FrameworkUtil.sTestCaseName = "EBPanel-verifyEBTicketPage";
			FrameworkUtil.sManualTestCaseName= "CPPOC-2859 Verify Ticket is Created after selecting org from entity browser";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, EBPanel);
			sOrgToSelect=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.ORGNAME.TO.TSTDEVCO");
			//login to catalog
			LoginTestCase_Old1.LoginAsARoleAUser();
			//Navigating to Catalog Page
			navSelectOrgFromEBPanel(sOrgToSelect);
			TicketTestCase.navigateToTicketPage();
			WebObjectUtil.explicitWait(Ticket.getNav_CreateTicketLink());
			WebObjectUtil.clickElement(Ticket.getNav_CreateTicketLink());
			WebObjectUtil.explicitWait(Ticket.getNav_CreateTicketDialog());
			//Entering the "Ticket" values
			WebObjectUtil.verifyElementPresent(Ticket.getNav_CreateTicketDialog());
			WebObjectUtil.clickElement(Ticket.getNav_CreateTicketDialogSummary());
			Ticket.getNav_CreateTicketDialogSummary().sendKeys("Automation Development Test Ticket");
			WebObjectUtil.ClickAndMouseHover(Ticket.getNav_CreateTicketDialogSeverity());
			WebObjectUtil.clickElement(EBPanel.getNav_EBpanelTicketSev1());
			WebObjectUtil.ClickAndMouseHover(Ticket.getNav_CreateTicketDialogPriority());
			WebObjectUtil.clickElement(EBPanel.getNav_EBpanelNormalPriority());
			WebObjectUtil.ClickAndMouseHover(Ticket.getNav_CreateTicketDialogCategory());
			WebObjectUtil.clickElement(EBPanel.getNav_EBPanelCategory());
			WebObjectUtil.clickElement(Ticket.getNav_CreateTicketDialogAddNote());
	        Ticket.getNav_CreateTicketDialogAddNote().sendKeys("Test Note");
	        WebObjectUtil.clickElement(Ticket.getNav_CreateTicketDialogOkButton());
	        
	        //This updated on 10/01/2015 for EXTJS5 by QAA03
	        //WebObjectUtil.explicitWait(EBPanel.getNav_EBPanelCreateTktNotification());
	        WebObjectUtil.explicitWait(Ticket.getNav_CreateTicketNotification());
	        
	        //This updated on 10/01/2015 for EXTJS5 by QAA03
	       // WebObjectUtil.verifyElementPresent(EBPanel.getNav_EBPanelCreateTktNotification());
	        WebObjectUtil.verifyElementPresent(Ticket.getNav_CreateTicketNotification());
	        
	      //This updated on 10/01/2015 for EXTJS5 by QAA03
	        //WebObjectUtil.clickElement(EBPanel.getNav_EBPanelTicketOKbutton());
	        WebObjectUtil.clickElement(Ticket.getNav_CreateTicketNotificationOkButton());
	        
			LoginTestCase_Old1.nav_Logout();
			}
			catch(Exception e)
			{
				LoggerUtil.log_type_error("issue with- EBPanel-verifyEBTicketPage " );
				LoggerUtil.log_type_error(e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
			}
		}

 /*==============================================================
   TestScript  	    : verifyEBPerimissions
   Manual TestCase	: CPPOC-2863
   Description		: Verify Ticket is Created 
   Author 			: Priyanka Rachupalli
   Creation Date 	: 29/07/2015
   Release Name    : Byron
   Pre-Requisites	:
   Revision History:
  ==============================================================*/
			@Test(priority=2)
			public void verifyEBPerimissions()
			{
				PageFactory.initElements(WebDriverUtil.getDriver(),EBPanel);
				PageFactory.initElements(WebDriverUtil.getDriver(),Ticket);
				try{
				String sURL;
				sURL=(String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOL.PERIMISSIONS");
				FrameworkUtil.sTestCaseName = "EBPanel-verifyEBPerimissions";
				FrameworkUtil.sManualTestCaseName= "CPPOC-2863";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, EBPanel);
				//login to catalog
				LoginTestCase_Old1.LoginAsARoleAUser();
				WebObjectUtil.MouseHover(EBPanel.getNav_EBPanelAccountTab());
				//WebObjectUtil.MouseHover(EBPanel.getNav_EBPanelPerimissionsLink());
				//verify page URL
				WebObjectUtil.clickAndVerifyUrl(EBPanel.getNav_EBPanelPerimissionsLink(), sURL);
				LoginTestCase_Old1.nav_Logout();
					}
				catch(Exception e)
				{
					LoggerUtil.log_type_error("issue with- verifyEBPerimissions" );
					LoggerUtil.log_type_error(e.getMessage());
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
					}
				}
			/*==============================================================
			TestScript  	: verifyEBTicketPage
			Manual TestCase	: CPPOC-2859
			Description		: Verify Ticket is Created 
			Author 			: Priyanka Rachupalli
			Creation Date 	: 29/07/2015
			Release Name    : Byron
			Pre-Requisites	:
			Revision History:
			==============================================================*/
					@Test(priority=3)
					public void verifyEBTicketIcons()
					{
						PageFactory.initElements(WebDriverUtil.getDriver(),EBPanel);
						PageFactory.initElements(WebDriverUtil.getDriver(),Ticket);
						String sOrgToSelect;
						try{
						FrameworkUtil.sTestCaseName = "EBPanel-verifyEBTicketIcons";
						FrameworkUtil.sManualTestCaseName= "CPPOC-2862";
						FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
						WebDriver driver = WebDriverUtil.getDriver();
						PageFactory.initElements(driver, EBPanel);
						sOrgToSelect=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.ORGNAME.TO.TSTDEVCO");
						//login to catalog
						LoginTestCase_Old1.LoginAsARoleAUser();
						//Navigating to Catalog Page
						navSelectOrgFromEBPanel(sOrgToSelect);
						TicketTestCase.navigateToTicketPage();
						//validating Icons
						WebObjectUtil.verifyElementPresent(Ticket.getNav_TicketsCsvIcon());
						WebObjectUtil.verifyElementPresent(Ticket.getNav_TicketsPdfIcon());
						LoginTestCase_Old1.nav_Logout();
						}
						catch(Exception e)
						{
							LoggerUtil.log_type_error("issue with- verifyEBTicketIcons" );
							LoggerUtil.log_type_error(e.getMessage());
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
							}
						}
					/*==============================================================
					TestScript  	: verifyTktEBPopupChk
					Manual TestCase	: CPPOC-2873
					Description		: Verify Ticket is Created 
					Author 			: Priyanka Rachupalli
					Creation Date 	: 29/07/2015
					Release Name    : Byron
					Pre-Requisites	:
					Revision History:
					==============================================================*/
							@Test(priority=4)
							public void verifyTktEBPopupChk()
							{
								PageFactory.initElements(WebDriverUtil.getDriver(),EBPanel);
								PageFactory.initElements(WebDriverUtil.getDriver(),Ticket);
								String sOrgToSelect;
								try{
								FrameworkUtil.sTestCaseName = "verifyTktEBPopupChk";
								FrameworkUtil.sManualTestCaseName= "CPPOC-2873";
								FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
								WebDriver driver = WebDriverUtil.getDriver();
								PageFactory.initElements(driver, EBPanel);
								//login to catalog
								LoginTestCase_Old1.LoginAsARoleAUser();//Login to 'sravuri' Credentials 
								TicketTestCase.navigateToTicketPage();
								//Refresh browser
								driver.navigate().refresh();
								WebObjectUtil.explicitWait(20);
								WebObjectUtil.verifyElementPresent(EBPanel.getNav_EBPanelHostedSolFooter());
								LoginTestCase_Old1.nav_Logout();
								}
								catch(Exception e)
								{
									LoggerUtil.log_type_error("issue with- verifyTktEBPopupChk" );
									LoggerUtil.log_type_error(e.getMessage());
									FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
									}
							}

/*==============================================================
TestScript  	: verifyEVDCEBPopupChk
Manual TestCase	: CPPOC-2859
Description		: Verify Ticket is Created 
Author 			: Priyanka Rachupalli
Creation Date 	: 29/07/2015
Release Name    : Byron
Pre-Requisites	:
Revision History:
==============================================================*/
	@Test(priority=5)
	public void verifyEVDCEBPopupChk()
	{
		PageFactory.initElements(WebDriverUtil.getDriver(),EBPanel);
		PageFactory.initElements(WebDriverUtil.getDriver(),Ticket);
		PageFactory.initElements(WebDriverUtil.getDriver(),EVDC);
		try{
		FrameworkUtil.sTestCaseName = "verifyEVDCEBPopupChk";
		FrameworkUtil.sManualTestCaseName= "CPPOC-2838";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EBPanel);
		//sOrgToSelect=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.ORGNAME.TO.TSTDEVCO");
		//login to catalog
		LoginTestCase_Old1.LoginAsARoleAUser();
		WebObjectUtil.explicitWait(15);
		WebObjectUtil.clickElement(EVDC.getNav_EVDCname());
		WebObjectUtil.explicitWait(30);
		WebObjectUtil.clickElement(EVDC.getNav_EVDCOverviewVirtualMachine());
		WebObjectUtil.explicitWait(10);
		driver.navigate().refresh();
		WebObjectUtil.explicitWait(20);
		WebObjectUtil.verifyElementPresent(EVDC.getNav_EVDCOverviewVirtualMachine());
		WebObjectUtil.verifyElementPresent(EBPanel.getNav_EBPanelHostedSolFooter());
		LoginTestCase_Old1.nav_Logout();
		}
		catch(Exception e)
		{
			LoggerUtil.log_type_error("issue with- verifyEVDCEBPopupChk" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
			}
		}
	/*==============================================================
	Method Name 	: navigateToEVDCPageFrmHmpgAndVerifyEVDCPageDisplay
	Description		: Navigate To EVDC Page from Home Page and verify EVDC page displays
	Author 			: Sukru Babu
	Creation Date 	: 30/07/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navigateToEVDCPageFrmHmpgAndVerifyEVDCPageDisplay()
	{
			String sPageText;
			//updated below lines by QAA03 on 07/22/2016
			PageFactory.initElements(WebDriverUtil.getDriver(),EBPanel);
			PageFactory.initElements(WebDriverUtil.getDriver(),UserPerm);
			PageFactory.initElements(WebDriverUtil.getDriver(),EVDC);
		try{
			//This line updated on 10/02/2015 for EXTJS5 by QAA03
			//WebObjectUtil.clickElement(UserPerm.getNav_EVDCPortalLink());
			WebObjectUtil.clickElement(EVDC.getNav_EVDCname());
			
			WebObjectUtil.waitForElementPresent(UserPerm.getNav_FirewallLink());
			sPageText=EBPanel.getNav_BreadCrumbSection().getText();
			if(sPageText.equalsIgnoreCase("EVDC Overview"))
				FrameworkUtil.updateCustomResultBasedOnStatus(true,  "EVC Page Displayed" );
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false,  "EVC Page not Displayed" );
		}
		catch(Exception e)
		{
			LoggerUtil.log_type_error("issue with- navigateToEVDCPageFrmHmpgAndVerifyEVDCPageDisplay method" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	/*==============================================================
	Method Name 	: navigateToFirewallPageFrmHmPgAndVerifyFirewallPageDisplay
	Description		: Navigate To Firewall Page from Home Page and verify Firewall page displayed
	Author 			: Sukru Babu
	Creation Date 	: 30/07/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navigateToFirewallPageFrmEVDCAndVerifyFirewallPageDisplay()
	{
				
		try{
			UserPermTC.NavigateToFirewallPage();
			
		}
		catch(Exception e)
		{
			LoggerUtil.log_type_error("issue with- navigateToFirewallPageFrmEVDCAndVerifyFirewallPageDisplay method" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	/*==============================================================
	Method Name 	: navigateToVMPageFrmHmPgAndVerifyVMPageDisplay
	Description		: Navigate To VM Page from home Page and verify VM page displayed
	Author 			: Sukru Babu
	Creation Date 	: 30/07/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navigateToVMPageFrmHmPgAndVerifyVMPageDisplay()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		try{
			PageFactory.initElements(driver, UserPerm);
			PageFactory.initElements(driver, EVDC);
			//This two lines updated on 10/02/2015 for EXTJS5 by QAA03
			PageFactory.initElements(driver,EVDC);
			//WebObjectUtil.clickElement(UserPerm.getNav_EVDCPortalLink());
			WebObjectUtil.clickElement(EVDC.getNav_EVDCname());
			
			WebObjectUtil.waitForElementPresent(UserPerm.getNav_FirewallLink());
			WebObjectUtil.clickElement(EBPanel.getNav_VMLink());
			WebObjectUtil.explicitWait(5);
			WebObjectUtil.verifyElementPresent(EVDCVM.getNav_VMWebTableParent());
		}
		catch(Exception e)
		{
			LoggerUtil.log_type_error("issue with- navigateToVMPageFrmHmPgAndVerifyVMPageDisplay method" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	/*==============================================================
	Method Name 	: navigateToCtlgPageFrmHmPgAndVerifyCtlgPageDisplay
	Description		: Navigate To Catalog Page from Home Page and verify Catalog page displayed
	Author 			: Sukru Babu
	Creation Date 	: 30/07/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navigateToCtlgPageFrmHmPgAndVerifyCtlgPageDisplay()
	{
				
		try{
			//This line updated on 10/02/2015 for EXTJS5 by QAA03
			//WebObjectUtil.clickElement(UserPerm.getNav_EVDCPortalLink());
			WebObjectUtil.clickElement(EVDC.getNav_EVDCname());
			WebObjectUtil.waitForElementPresent(UserPerm.getNav_FirewallLink());
			WebObjectUtil.clickElement(EBPanel.getNav_CatalogLink());
			WebObjectUtil.explicitWait(5);
			WebObjectUtil.verifyElementPresent(EBPanel.getNav_CatalogWsWebTable());
		}
		catch(Exception e)
		{
			LoggerUtil.log_type_error("issue with- navigateToCtlgPageFrmHmPgAndVerifyCtlgPageDisplay method" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	/*==============================================================
	Method Name 	: CheckOrgNamesNotCaps
	Description		: Verify Org Name displayed in First Level Children are all not CAPS
	Author 			: QAA03
	Creation Date 	: 31/07/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/

public static void CheckOrgNamesNotCaps()
	{
		 boolean bCapFlag=true;
		 int Count = WebTableUtil.getRowCount(EBPanel.getNav_FirstLevelChildrenOrgTable());
		 try{
		 for(int i=1;i<=10;i++)
		 {
		  String S = WebTableUtil.getCellData(EBPanel.getNav_FirstLevelChildrenOrgTable(), i, 0);
	      	      
	     if(AllUpper(S))
	     {

	    	 bCapFlag=false;
	    	 break;	 
	     }
	    	
	     else
	     {
	    	 bCapFlag=true;
		 }
	     
		 }
		 if(bCapFlag)
			 	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "First Level Organisation", "pass", "All are not Caps in the Organisation name");	
		      else
		    	 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "First Level Organisation", "fail", "All are Caps in the Organisation name");
		 }
		 catch(Exception e)
		{
			LoggerUtil.log_type_error("issue with- CheckOrgNamesNotCaps method" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
  /*==============================================================
	Method Name 	: AllUpper
	Description		: Checks whetehr the string contains all upper case letters
	Author 			: QAA04
	Creation Date 	: 31/07/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/  
private  static boolean AllUpper(String s)
{
	for(char c:s.toCharArray())
	{
		if(Character.isLetter(c)&&Character.isLowerCase(c))
			return false;
	}
		return true;
}

//////////////// Completed Byron test cases ///////////////////////////////////////////////

/////_________________ Clark TestCases __________________________________________________//////



/*========================================================================================================
TestScript  	: verifyEntityHasParent
Manual TestCase	: CPPOC-3030,3029 Verifying Entity And Parent Columns Are Present and Entity has Parent
Description		: Verifying Entity And Parent Columns Are Present and Entity has Parent under Users tab
Author 			: QAA03
Creation Date 	: 08/18/2015
Release Name    : Clark-Sp1
Pre-Requisites	:
Revision History:
==========================================================================================================*/


@Test(priority=92)
public static void verifyEntityHasParent()
{

    WebDriver driver = WebDriverUtil.getDriver();
    PageFactory.initElements(driver, EBPanel);
    String sUserName=null,sPassword=null;
              
 try {
		FrameworkUtil.sTestCaseName = "verifyEntityHasParent";
		FrameworkUtil.sManualTestCaseName="CPPOC-3030,3029 Verifying Entity And Parent Columns Are Present and Entity has Parent";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		           
	    sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLE.USERID");
	    sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLE.PWD");
		
		//LoginTestCase.nav_Login(sUserName, sPassword);
	   // LoginTestCase.LoginAsDevcoUser();
	    LoginTestCase_Old1.LoginAsQaautoUser();
		verifyEntityUser();
		LoginTestCase_Old1.nav_Logout();
		
	} catch (Exception e) {
		LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyEntityHasParent", "warn", "catch block:Could NOT access webelement" +e.getMessage());
	}
 
}

/*====================================================================================================
TestScript  	: verifyEBPanelPopUpRefreshTickets
Manual TestCase	: CPPOC-2861 Verifying EBPanel Popup After Refreshing Tickets page
Description		: Verifying EBPanel Popup After Refreshing Tickets page
Author 			: QAA03
Creation Date 	: 08/19/2015
Release Name    : Clark-Sp1
Pre-Requisites	:
Revision History:
======================================================================================================*/
@Test(priority=93)
public static void verifyEBPanelPopUpRefreshTickets()
{

    WebDriver driver = WebDriverUtil.getDriver();
    PageFactory.initElements(driver, EBPanel);
    String sUserName=null,sPassword=null;
    
 try {
		FrameworkUtil.sTestCaseName = "verifyEBPanelPopUpRefreshTickets";
		FrameworkUtil.sManualTestCaseName="CPPOC-2861 Verifying EBPanel Popup After Refreshing Tickets Page";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

	    sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEA.USERID");
	    sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEA.PASSWORD");
		
		//LoginTestCase.nav_Login(sUserName, sPassword);
		LoginTestCase_Old1.LoginAsARoleAUser();
		verifyEBPanelTktRefresh();
		LoginTestCase_Old1.nav_Logout();
		
	} catch (Exception e) {
		LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyEBPanelPopUpRefreshTickets", "warn", "catch block:Could NOT access webelement" +e.getMessage());
	}
}

/*====================================================================================================
TestScript  	: verifyEBPanelPopUpVMRefresh
Manual TestCase	: CPPOC-2860 Verifying EBPanel Popup After VM Refresh
Description		: Verifying EBPanel Popup After Refreshing VM page
Author 			: QAA03
Creation Date 	: 08/19/2015
Release Name    : Clark-Sp1
Pre-Requisites	:
Revision History:
======================================================================================================*/

@Test(priority=94)
public static void verifyEBPanelPopUpVMRefresh()
{

    WebDriver driver = WebDriverUtil.getDriver();
    PageFactory.initElements(driver, EBPanel);
    String sUserName=null,sPassword=null;
              
 try {
		FrameworkUtil.sTestCaseName = "verifyEBPanelPopUpVMRefresh";
		FrameworkUtil.sManualTestCaseName="CPPOC-2860 Verifying EBPanel Popup After VM Refresh";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

	    sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEA.USERID");
	    sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEA.PASSWORD");
		
		//LoginTestCase.nav_Login(sUserName, sPassword);
	    LoginTestCase_Old1.LoginAsARoleAUser();
		verifyEBPanelVMRefrsh();
		LoginTestCase_Old1.nav_Logout();
		
	} catch (Exception e) {
		LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyEBPanelPopUpVMRefresh", "warn", "catch block:Could NOT access webelement" +e.getMessage());
	}
}

/*====================================================================================================
TestScript  	: verifyEBChildParent
Manual TestCase	: CPPOC-3025 Verifying Parent data is not present after entering child in EB
Description		: Verifying Parent data is not present after entering child in EB
Author 			: QAA03
Creation Date 	: 08/19/2015
Release Name    : Clark-Sp1
Pre-Requisites	:
Revision History:
======================================================================================================*/
@Test(priority=95)
public static void verifyEBChildParent()
{

    WebDriver driver = WebDriverUtil.getDriver();
    PageFactory.initElements(driver, EBPanel);
    PageFactory.initElements(driver, Ticket);
    String sUserName=null,sPassword=null;
              
 try {
		FrameworkUtil.sTestCaseName = "verifyEBChildParent";
		FrameworkUtil.sManualTestCaseName="CPPOC-3025 Verifying Parent data is not present after entering child in EB";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

	    sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEA.USERID");
	    sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEA.PASSWORD");
		
		//LoginTestCase.nav_Login(sUserName, sPassword);
	    LoginTestCase_Old1.LoginAsARoleAUser();
		verifyEBChildData();
		LoginTestCase_Old1.nav_Logout();
		
	} catch (Exception e) {
		LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyEBChildParent", "warn", "catch block:Could NOT access webelement" +e.getMessage());
	}
}

/*====================================================================================================
TestScript  	: verifyEBTicket
Manual TestCase	: CPPOC-3024 Verifying Ticket is editable after entering child in EB
Description		: Verifying Ticket is editable after entering child in EB
Author 			: QAA03
Creation Date 	: 08/20/2015
Release Name    : Clark-Sp1
Pre-Requisites	: Corresponding parent and child entities should be created using "verifyParentChildEntity" method 
Revision History:
======================================================================================================*/
@Test(priority=96)
public static void verifyEBTicket()
{

     WebDriver driver = WebDriverUtil.getDriver();
     PageFactory.initElements(driver, EBPanel);
     PageFactory.initElements(driver, Ticket);
     String sUserName=null,sPassword=null,sChildorg=null,sParentorg=null;
              
 try {
		FrameworkUtil.sTestCaseName = "verifyEBTicket";
		FrameworkUtil.sManualTestCaseName="CPPOC-3024 Verifying Ticket is editable after entering child in EB";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

	    sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEA.USERID");
	    sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEA.PASSWORD");
		
	    sChildorg = (String)FrameworkUtil.dictPropertyData.get("NAV.QA.UPGRADE.ENTITYMGT.CHILDORGNAME");
	    sParentorg = (String)FrameworkUtil.dictPropertyData.get("NAV.QA.UPGRADE.ENTITYMGT.PARENTORGNAME");
	   AdminTestCase.verifyParentChildEntity(sChildorg,sParentorg);
		//LoginTestCase.nav_Login(sUserName, sPassword);
		LoginTestCase_Old1.LoginAsARoleAUser();
		verifyTicketChildData();
		LoginTestCase_Old1.nav_Logout();
		
	} catch (Exception e) {
		LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyEBTicket", "warn", "catch block:Could NOT access webelement" +e.getMessage());
	}
}
/*====================================================================================================
TestScript  	: verifyGobackPreviousLevelOrgEB
Manual TestCase	: CPPOC-2844 Verifying User is able to go back to previous level organizations in EB
Description		: Verifying User is able to go back to previous level organizations in EB
Author 			: QAA03
Creation Date 	: 08/20/2015
Release Name    : Clark-Sp1
Pre-Requisites	: Corresponding parent and child entities should be created using "verifyParentChildEntity" method
Revision History:
======================================================================================================*/
@Test(priority=97)
public static void verifyGobackPreviousLevelOrgEB()
{

      WebDriver driver = WebDriverUtil.getDriver();
      PageFactory.initElements(driver, EBPanel);
      String sUserName=null,sPassword=null,sChildorg=null,sParentorg=null,sChildorg1=null;
 
              
 try {
		FrameworkUtil.sTestCaseName = "verifyGobackPreviousLevelOrgEB";
		FrameworkUtil.sManualTestCaseName="CPPOC-2844 Verifying User is able to go back to previous level organizations in EB";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

	    sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEA.USERID");
     sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEA.PASSWORD");
		
	    sChildorg = (String)FrameworkUtil.dictPropertyData.get("NAV.QA.UPGRADE.ENTITYMGT.CHILDORGNAME");
	    sParentorg = (String)FrameworkUtil.dictPropertyData.get("NAV.QA.UPGRADE.ENTITYMGT.PARENTORGNAME");
	    sChildorg1 = (String)FrameworkUtil.dictPropertyData.get("NAV.QA.UPGRADE.ENTITYMGT.CHILDORGNAME1");
	   AdminTestCase.verifyParentChildEntity(sChildorg,sParentorg);
	    AdminTestCase.verifyParentChildEntity(sChildorg1,sChildorg);
		
		//LoginTestCase.nav_Login(sUserName, sPassword);
	    LoginTestCase_Old1.LoginAsARoleAUser();
		verifyPreviousOrgEB();
		LoginTestCase_Old1.nav_Logout();
		
	} catch (Exception e) {
		LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyGobackPreviousLevelOrgEB", "warn", "catch block:Could NOT access webelement" +e.getMessage());
	}
}

/*====================================================================================================
TestScript  	: verifyDataTicketUserEntity
Manual TestCase	: CPPOC-3016 Verifying Ticket Data for User And Entity
Description		: Verifying Ticket Data for User And Entity
Author 			: QAA03
Creation Date 	: 08/21/2015
Release Name    : Clark-Sp1
Pre-Requisites	: Corresponding parent and child entities should be created using "verifyParentChildEntity" method
Revision History:
======================================================================================================*/

@Test(priority=99)
public static void verifyDataTicketUserEntity()
{

       WebDriver driver = WebDriverUtil.getDriver();
       PageFactory.initElements(driver, EBPanel);
       PageFactory.initElements(driver, Ticket);
       String sUserName=null,sPassword=null,sChildorg=null,sParentorg=null;
              
try {
		FrameworkUtil.sTestCaseName = "verifyDataTicketUserEntity";
		FrameworkUtil.sManualTestCaseName="CPPOC-3016 Verifying Ticket Data for User And Entity";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	    sChildorg = (String)FrameworkUtil.dictPropertyData.get("NAV.QA.UPGRADE.ENTITYMGT.CHILDORGNAME");
	    sParentorg = (String)FrameworkUtil.dictPropertyData.get("NAV.QA.UPGRADE.ENTITYMGT.PARENTORGNAME");

	    AdminTestCase.verifyParentChildEntity(sChildorg,sParentorg);
	    sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEA.USERID");
	    sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEA.PASSWORD");
       // LoginTestCase.nav_Login(sUserName, sPassword);
	    LoginTestCase_Old1.LoginAsARoleAUser();
		verifyTicketUserEntity();
		LoginTestCase_Old1.nav_Logout();
		
	} catch (Exception e) {
		LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyDataTicketUserEntity", "warn", "catch block:Could NOT access webelement" +e.getMessage());
	}
}



/*==============================================================
	TestScript  	: navValCreateTicketFunctionalityAfterSelectingOrgFromEBPanel
	Manual TestCase	: CPPOC-3017 
	Description		: Validate ticket created for selected organization from EB Panel
	Author 			: Sukur Babu. B
	Creation Date 	: 30/07/2015
	Release Name    : Clark-Sp1
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	//@Test(priority=71)
	public void navValCreateTicketFunctionalityAfterSelectingOrgFromEBPanel()
	{
		String sOrgToSelect,sUserName,sPassword,sOrgName,sFirstLevelOrgToSelect,sSecondLevelOrgToSelect,sSummaryText,sActSuccessMsg,sSuccessMsg;
		WebElement wExpander;
		try{
		FrameworkUtil.sTestCaseName = "EBPanel-navValCreateTicketFunctionalityAfterSelectingOrgFromEBPanel";
		FrameworkUtil.sManualTestCaseName= "CPPOC-3017  Validate ticket created for selected organization from EB Panel";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EBPanel);
		PageFactory.initElements(driver, Ticket);
		//sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO.USERID.AROLE");
		//sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO.PASSWORD.AROLE");
		//LoginTestCase.nav_Login(sUserName,sPassword);
		String sChildorg = (String)FrameworkUtil.dictPropertyData.get("NAV.QA.UPGRADE.ENTITYMGT.CHILDORGNAME");
	    String sParentorg = (String)FrameworkUtil.dictPropertyData.get("NAV.QA.UPGRADE.ENTITYMGT.PARENTORGNAME");
	    AdminTestCase.verifyParentChildEntity(sChildorg,sParentorg);
		sFirstLevelOrgToSelect=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.FIRST.LEVEL.ORGNAME");
		sSecondLevelOrgToSelect=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.SECOND.LEVEL.ORGNAME");
		//Role-A Login and verifies ticket count
		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.USERID.AROLE");
		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.PASSWORD.AROLE");
		//LoginTestCase.nav_Login(sUserName,sPassword);
		LoginTestCase_Old1.LoginAsARoleAUser();
		navSelectOrgFromEBPanel(EBPanel.getNav_FirstLevelChildrenEditBox(),sFirstLevelOrgToSelect);
		navSelectOrgFromEBPanel(EBPanel.getNav_SecondLevelChildrenEditBox(),sSecondLevelOrgToSelect);
		TicketTestCase.navigateToTicketPage();
		WebObjectUtil.clickElement(Ticket.getNav_CreateTicketLink());
		sOrgName=Ticket.getNav_OrganizationEdit().getAttribute("value");
		if(sOrgName.equalsIgnoreCase(sSecondLevelOrgToSelect))
			FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Expected Org Name displayed in Create Ticket window");
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false,  "Expected Org Name not displayed in Create Ticket window");
		String sSummary = (String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.SUMMARY.VALUE");
		sSuccessMsg="Successfully created the ticket";
		String sSummaryTs=sSummary+FrameworkUtil.sTimeStamp;
		WebObjectUtil.SetValueEdit(Ticket.getNav_SummaryEdit(), sSummaryTs);
		WebObjectUtil.clickElement(Ticket.getNav_CreateTicketOKButton());
		WebObjectUtil.waitForElementPresent(Ticket.getNav_ConfirmPopup());
		WebObjectUtil.explicitWait(5);
		sActSuccessMsg=Ticket.getNav_ConfirmPopup().getText();
		//Verify sucess message
		if(sActSuccessMsg.contains(sSuccessMsg))
			FrameworkUtil.updateCustomResultBasedOnStatus(true, sSuccessMsg+" is matching with actual Sucess message after creating the ticket");
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false, sSuccessMsg+" is not matching with actual Sucess message after creating the ticket");
		WebObjectUtil.clickElement(Ticket.getNav_ConfirmPopupOkBtn());
		WebObjectUtil.explicitWait(5);
		//WebElement wExpander=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr[1]//tr[1]/td[1]//div[@class='x-grid-row-expander']", "Ticket Arrow Expander");
		 // This object is updated on 10/13/2015 By QAA04
		wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
		wExpander.click();
		WebObjectUtil.explicitWait(5);
		sSummaryText=EBPanel.getNav_SummaryTextafterTcktExpand().getText();
		if(sSummaryText.equalsIgnoreCase(sSummaryTs))
			FrameworkUtil.updateCustomResultBasedOnStatus(true, "Ticket found for the selected org");
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false, "Ticket not found for the selected org");
		LoginTestCase_Old1.nav_Logout();
		}
		
		catch(Exception e)
		{
			LoggerUtil.log_type_error("issue with- navValCreateTicketFunctionalityAfterSelectingOrgFromEBPanel Test Case" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	/*====================================================================================================
	TestScript  	: verifyEBAddDisk
	Manual TestCase	: CPPOC-3237_WCP_1286_TC_1.0_Entity Browser_assign resources to entity
	Description		: Verifying Ticket Data for User And Entity
	Author 			: Priyanka 
	Creation Date 	: 08/17/2016
	Release Name    : Clark-Sp1
	Pre-Requisites	: 
	Revision History:
	======================================================================================================*/

	@Test(priority=99)
	public static void verifyEBAddDisk()
	{

	       WebDriver driver = WebDriverUtil.getDriver();
	       PageFactory.initElements(driver, EBPanel);
	       PageFactory.initElements(driver, Ticket);
	       String sUserName=null,sPassword=null,sChildorg=null,sParentorg=null;
	       String sVMStatus,sExpUserFeedBack,sActUserFeedback,sExpUserString,sVMName;
	       int iRowNbr;
	              
	try {
			FrameworkUtil.sTestCaseName = "verifyEBAddDisk";
			FrameworkUtil.sManualTestCaseName=" CPPOC-3237_WCP_1286_TC_1.0_Entity Browser_assign resources to entity";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		    sChildorg = (String)FrameworkUtil.dictPropertyData.get("NAV.QA.UPGRADE.ENTITYMGT.CHILDORGNAME");
		    sParentorg = (String)FrameworkUtil.dictPropertyData.get("NAV.QA.UPGRADE.ENTITYMGT.PARENTORGNAME");
		    LoginTestCase_Old1.LoginAsRoleAUser();
		    WebObjectUtil.explicitWait(EBPanel.getNav_EntityBrowserLink());
		    WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		    WebObjectUtil.explicitWait(6);
		    selectOrgFromAllLevelsEB(sParentorg,sChildorg,"","");
		    WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
		    WebObjectUtil.explicitWait(10);
		    sExpUserString=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.ADDDISK");
		    String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDC_VM_TestCase.EVDCLoginAndExpand("true");
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			EVDC_VM_TestCase.stopRunningVM(iRowNbr);
			//Verifying and Clicking on Edit button
			EVDC_VM_TestCase.navVerifyClkEditBtn(iRowNbr);
            WebObjectUtil.clickElement(EVDCVM.getNav_EditComputeStorage());
			//Thread.sleep(25000);
			WebObjectUtil.waitForElementPresent(EVDCVM.getNav_ComputeStorageAddDisk());
			WebObjectUtil.clickElement(EVDCVM.getNav_ComputeStorageAddDisk());
			WebObjectUtil.clickElement(EVDCVM.getNav_EditVMSaveBtn());
			if(WebObjectUtil.isElementPresent(EVDCVM.getNav_NewEVDCPopUpBody()))
			{
				WebObjectUtil.clickElement(EVDCVM.getNav_NewEVDCPopUpOKBtn());
			}
			else
			{
				WebObjectUtil.waitForElementPresent(EVDCVM.getNav_EditVMCommit());
				WebObjectUtil.clickElement(EVDCVM.getNav_EditVMCommit());
			}
			
			
			//Thread.sleep(60000);
			WebObjectUtil.waitForElementPresent(EVDCVM.getNav_RefreshPopUpMsg());
			WebObjectUtil.waitForElementNotPresent(EVDCVM.getNav_PlzWaitPopUpMsg());
			WebObjectUtil.waitForElementNotPresent(EVDCVM.getNav_RefreshPopUpMsg());
			EVDC_VM_TestCase.navClickErrBtn();
			sVMName=EVDC_VM_TestCase.navGetVMName(iRowNbr);
			//WebObjectUtil.waitForElementPresent(EVDC.);
			//WebObjectUtil.waitForElementNotPresent(EVDC.getNav_StartPopUpMsg());
			sActUserFeedback =EVDCVM.getNav_UserfeedBack().getText();
			sExpUserFeedBack=sVMName + " "+sExpUserString;
			//System.out.println(sActUserFeedback);
			if(sActUserFeedback.contains(sExpUserFeedBack))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message Verified "    , "pass",sExpUserFeedBack) ;
				LoggerUtil.log_type_info(" Message Verified  = " +sExpUserFeedBack );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message not Verified"   , "fail", "Expected :"+sExpUserFeedBack +", Actual :"+sActUserFeedback);
				LoggerUtil.log_type_error(" Message not Verified  =  " +sExpUserFeedBack );
			}
	}
	catch(Exception e)
	{
		LoggerUtil.log_type_error("issue with- navValCreateTicketFunctionalityAfterSelectingOrgFromEBPanel Test Case" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
}
//////////// ____________________ Hague test cases _________________________________________ ////////////////////////////////
	/*==============================================================
	TestScript  	: verifyDraasPageDataChangeswithSelectedOrgfromEB
	Manual TestCase	: [QAT-280] [WCP] Entity Browser- When a user navigate to DRaaS page from any other page, and chooses another entity from EB, verify the org name and DRaaS data are changing for the selected org from EB 
	Description		: When a user navigate to DRaaS page from any other page, and chooses another entity from EB, verify the org name and DRaaS data are changing for the selected org from EB
	Author 			: QAA03
	Creation Date 	: 12/03/2015
	Release Name    : Hague
	Pre-Requisites	:
	Revision History:
==============================================================*/
	@Test(priority=3)
	public void verifyDraasPageDataChangeswithSelectedOrgfromEB()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,Home);
			PageFactory.initElements(driver,Ticket);
			PageFactory.initElements(driver,EBPanel);
			PageFactory.initElements(driver,Draas);
				
			String sUserName=null,sPassword=null,sFLCOrg1=null,sFLCOrg2=null,sOrgNamefooter=null,sOrgNameTop=null;
			boolean bEntityStatus;
		
		
	try {
			FrameworkUtil.sTestCaseName = "verifyDraasPageDataChangeswithSelectedOrgfromEB";
			FrameworkUtil.sManualTestCaseName="[QAT-280] [WCP] Entity Browser- When a user navigate to DRaaS page from any other page,and chooses another entity from EB, verify the org name and DRaaS data are changing for the selected org from EB";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.ROLEA");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.PASSWORD");
			
			sFLCOrg1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.FIRST.LEVEL.ORGNAME");
			sFLCOrg2 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.SECOND.LEVEL.ORGNAME");
			    
		    //Login to Navigator
			//LoginTestCase.nav_Login(sUserName, sPassword);
			LoginTestCase_Old1.LoginAsARoleAUser();	
			//Navigating to Tickets Page
			WebObjectUtil.clickElement(Home.getNav_SupportTab());
			WebObjectUtil.clickAndVerifyElement(Ticket.getNav_TicketsMenuLink(),Ticket.getNav_CreateTicketLink());
			
			//Clicking on Entity Browser Panel footer
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			
			//Selecting the organization from First Level Children	
			EntityBrowserTestCase.selectOrgFromAllLevelsEB(sFLCOrg1, "", "", "");
			
			//Verifying Organization name in EB Footer and Top right Corner of Page
			verifyOrgNameInEBFooterAndTopCornerPage();
			
			//Navigating to Draas Page
		     WebObjectUtil.clickElement(Home.getNav_ServicesTab());
			//WebObjectUtil.clickByJS(Home.getNav_ServicesTab());
			WebObjectUtil.clickElement(Draas.getNav_DraaSLink());
			
			WebObjectUtil.verifyElementPresent(Draas.getNav_DraasSBRImage());
			WebObjectUtil.verifyElementPresent(Draas.getNav_DraasS2CRImage());
			WebObjectUtil.verifyElementPresent(Draas.getNav_DraasC2CRImage());
			
			//Clicking on Entity Browser Panel footer	
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			//Selecting the organization from First Level Children
			EntityBrowserTestCase.selectOrgFromAllLevelsEB(sFLCOrg2, "", "", "");
			
			//Verifying Organization name in EB Footer and Top right Corner of Page
			verifyOrgNameInEBFooterAndTopCornerPage();
			
			WebObjectUtil.verifyElementPresent(Draas.getNav_DraasSBRImage());
			WebObjectUtil.verifyElementNOTPresent(Draas.getNav_DraasS2CRImage());
			WebObjectUtil.verifyElementNOTPresent(Draas.getNav_DraasC2CRImage());
			
			LoginTestCase_Old1.nav_Logout();
				
	   } catch (Exception e) {
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyDraasPageDataChangeswithSelectedOrgfromEB", "warn", "catch block:" +e.getMessage());
		}
    }
	
	
	
	

	
//////// _________________________ Completed Hague test cases _______________________________ ////////////////////////////////
//// Methods

	/*====================================================================================================
	Method Name 	: verifyOrgNameInEBFooterAndTopCornerPage
	Description		: Verifying Organization name in EB Footer and Top right Corner of Page
	Author 			: QAA03
	Creation Date 	: 12/07/2015
	Pre-Requisites	:
	Revision History:
	====================================================================================================*/
	public static void verifyOrgNameInEBFooterAndTopCornerPage()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,EBPanel);
			String sOrgNamefooter=null,sOrgNameTop=null;
			boolean bEntityStatus;
				
     try {  
    	    sOrgNamefooter=EBPanel.getNav_OrgNameTitleLink().getText();
			//Clicking on Entity Browser Panel header
			WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
			
			sOrgNameTop=EBPanel.getNav_OrgName().getText();
			bEntityStatus=sOrgNamefooter.equals(sOrgNameTop);
			FrameworkUtil.updateCustomResultBasedOnStatus(bEntityStatus, "Entity displayed in EB footer and Org displayed in the top right corner");
    	   
			  
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyOrgNameInEBFooterAndTopCornerPage", "warn", "catch block:" +e.getMessage());  
		}
		
	}
	
	/*==============================================================
	Method Name 	: navSelectOrgFromEBPanel
	Description		: Selects the organization from Entity Browser Panel based on the parameters
	Ex: navSelectOrgFromEBPanel( "Value")--Selects the organization from 1st lavel
	children
	Author 			: Sukru Babu
	Creation Date 	: 17/08/2015
	Pre-Requisites	:
	Revision History: Added one parameter to function.
	==============================================================*/
	public static void navSelectOrgFromEBPanel(WebElement wLevelChldEditBox,String sOrgNameToSelect)
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EBPanel);
		String sActOrgNameinEBPanelBforeClick,sActOrgNameinEBPanelAftClerickinMainPage;
		WebElement wOrgItemtoSelect,wOrgNameinMainPage;
		try{
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			WebObjectUtil.waitForElementPresent(EBPanel.getNav_FirstLevelChildrenEditBox());
		
			WebObjectUtil.verifyElementPresent(wLevelChldEditBox, true);
			WebObjectUtil.SetValueEdit(wLevelChldEditBox, sOrgNameToSelect);
			//WebElement wOrgItemtoSelect=WebObjectUtil.GetWebElement("xpath", "//table[contains(@id,'table')]//div[text()='"+sOrgNameToSelect+"']", "OrgItem");
			 // This object is updated on 10/13/2015 By QAA04
			wOrgItemtoSelect = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EBPANEL.ORGNAME.SELECT", "PARAMETER_ORGNAMESELECT", sOrgNameToSelect);
			wOrgItemtoSelect.click();
			sActOrgNameinEBPanelBforeClick=EBPanel.getNav_OrgNameTitleLink().getText();
			if(sActOrgNameinEBPanelBforeClick.equalsIgnoreCase(sOrgNameToSelect))
			{
				FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Selected Organization is displayed at top of EB Panel" );
				WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
				//WebElement wOrgNameinMainPage=WebObjectUtil.GetWebElement("xpath", "//li[@id='organization']", "Displayed Org Name");
				 // This object is updated on 10/13/2015 By QAA04
				wOrgNameinMainPage = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "HOME.ORGNAME","","");
				sActOrgNameinEBPanelAftClerickinMainPage=wOrgNameinMainPage.getText();
				if(sActOrgNameinEBPanelAftClerickinMainPage.equalsIgnoreCase(sOrgNameToSelect))
					FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Selected Organization is displayed In Home Page" );
				else
					FrameworkUtil.updateCustomResultBasedOnStatus(false,  "Selected Organization is not displayed In Home Page" );
			}
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false,  "Selected Organization is not displayed at top of EB Panel" );
			
		}
		catch(Exception e)
		{
			LoggerUtil.log_type_error("issue with- navSelectOrgFromEBPanel method" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}		
	}
	
	// The following methods are already exist so commented- updated on 11/18/2015 by QAA03
	/*public static void VerifyParentChildEntity(String sChildorg,String sParentorg)
	{
	    
		try {
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, EBPanel);
			                 
			FrameworkUtil.sTestCaseName = "VerifyParentChildEntity";
			FrameworkUtil.sManualTestCaseName="CPPOC-3036 Verifying Parent And Child Entities";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

			               
			String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ISHANNON.USERID");
			String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ISHANNON.PASSWORD");
			
			LoginTestCase.nav_Login(sUserName, sPassword);
			
			
		    
			VerifyAndSelectOrg(sChildorg,sParentorg);
			LoginTestCase.nav_Signout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VerifyParentChildEntity", "warn", "catch block:Could NOT access webelement" +e.getMessage());
		}
		
	}
	
	public static void VerifyAndSelectOrg(String sChildorg,String sParentorg)
	  {
		    WebDriver driver = WebDriverUtil.getDriver();
		    PageFactory.initElements(driver, EBPanel);
		    String sUrl = (String)FrameworkUtil.dictPropertyData.get("NAV.QA.UPGRADE.URL"); 	
			//String sChildorg = (String)FrameworkUtil.dictPropertyData.get("NAV.QA.UPGRADE.ENTITYMGT.CHILDORGNAME");
		    //String sParentorg = (String)FrameworkUtil.dictPropertyData.get("NAV.QA.UPGRADE.ENTITYMGT.PARENTORGNAME");
		    
			int iRowCount;
			WebElement wChildorg,wParentorg;
			String sChildText;
			String sParentText;
			
			try {
				driver.get(sUrl);
				WebObjectUtil.clickElement(Admin.getUpgrade_EntityMgtTab());
						
				
				WebObjectUtil.clickElement(Admin.getUpgrade_EntityMgtDropdownArrow());
				WebObjectUtil.SetValueEdit(Admin.getUpgrade_EntityMgtOrgEdit(), sChildorg);
				WebObjectUtil.explicitWait(10);
				
			//	wChildorg=WebObjectUtil.GetWebElement("xpath", "//div[@id='x-auto-19']", "Child");
				 // This object is updated on 10/13/2015 By QAA04
				wChildorg = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EBPANEL.CHILDORG","","");
				selectOrg(wChildorg,sChildorg);
				
				iRowCount = WebTableUtil.getRowCount(Admin.getUpgrade_EntityMgtTable());
				
				for(int i=2;i<=iRowCount;i++)
				{
				//child
				sChildText = WebTableUtil.getCellData(Admin.getUpgrade_EntityMgtTable(), i, 1);
				
				// parent
				sParentText = WebTableUtil.getCellData(Admin.getUpgrade_EntityMgtTable(), i, 2);
				
				if(sChildText.contains(sChildorg) && sParentText.contains(sParentorg))
				{
					
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "ParentChildData", "pass", sChildorg + " is child of "+ sParentorg +" as expected ");
				}	
				else
				{
					WebObjectUtil.clickElement(Admin.getUpgrade_EntityMgtParentElement());
					WebObjectUtil.clickElement(Admin.getUpgrade_EM_ChangeParentButton());
					
					WebObjectUtil.clickElement(Admin.getUpgrade_EM_ChangeParentArrow());
					WebObjectUtil.SetValueEdit(Admin.getUpgrade_EM_ChangeParentText(),sParentorg);
					WebObjectUtil.explicitWait(10);
					//WebElement wParentorg=WebObjectUtil.GetWebElement("xpath", "//div[@id='x-auto-23']", "Parent");
					 // This object is updated on 10/13/2015 By QAA04
					wParentorg = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "BEPANEL.PARENTORG","","");
					selectOrg(wParentorg,sParentorg);
					
					WebObjectUtil.clickElement(Admin.getUpgrade_EM_CPTextSaveButton());
					WebObjectUtil.handleJSAlert();
					
					WebObjectUtil.clickElement(Admin.getUpgrade_EntityMgtDropdownArrow());
					WebObjectUtil.SetValueEdit(Admin.getUpgrade_EntityMgtOrgEdit(), sChildorg);
					WebObjectUtil.explicitWait(10);
					
				   // wChildorg=WebObjectUtil.GetWebElement("xpath", "//div[@id='x-auto-19']", "Child");
					 // This object is updated on 10/13/2015 By QAA04
					wChildorg = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EBPANEL.CHILDORG","","");
					selectOrg(wChildorg,sChildorg);
					
					//child
					sChildText = WebTableUtil.getCellData(Admin.getUpgrade_EntityMgtTable(), 2, 1);
					
					// parent
					sParentText = WebTableUtil.getCellData(Admin.getUpgrade_EntityMgtTable(), 2, 2);
					
					if(sChildText.contains(sChildorg) && sParentText.contains(sParentorg))
					{
						
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "ParentChildData", "pass",  sChildorg + " is child of "+ sParentorg +" as expected ");
					}	
					else
					{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "ParentChildData", "fail",  sChildorg + " is NOT child of "+ sParentorg);
				    }
				}
				
				}
			} catch (Exception e) {
				LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VerifyOrg", "warn", "catch block:Could NOT access webelement" +e.getMessage());
			}
			
			
		}
	
	public static boolean selectOrg(WebElement webElement,String sVisibleText){
		String sItem = null;
		boolean flag = false;
	    	try {
				if (WebObjectUtil.isElementPresent(webElement)){
					//WebObjectUtil.MouseHover(webElement);
					List<WebElement> webListItems = webElement.findElements(By.tagName("div"));
					for (WebElement wb: webListItems){
						sItem =wb.getText() ;
						if (sItem.contains(sVisibleText)){
							//WebObjectUtil.MouseHover(webElement);
							WebObjectUtil.explicitWait(2);
							wb.click();
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Select Item from Custom WebList", "pass", "Item selected: "+ sVisibleText);
							flag = true;
							break;
						}
					}
				}else{
	    			LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element NOT present", "fail", "Element not present/visible ");
	    		}
				if (!flag){
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Select Item from Custom WebList", "warn", "Item Not found/selected: "+ sVisibleText);	
				}
			} catch (Exception e) {
				LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "selectCustomWebList", "warn", "catch block:Could NOT access webelement" +e.getMessage());
			}
	    	return flag;
	}*/
	
/*====================================================================================================
Method Name 	: verifyEBPanelTktRefresh
Description		: Verifying EBPanel Popup After Refreshing Tickets page
Author 			: QAA03
Creation Date 	: 08/19/2015
Pre-Requisites	:
Revision History:
=====================================================================================================*/

public static void verifyEBPanelTktRefresh()
{
   try {
	   WebDriver driver = WebDriverUtil.getDriver();
	   PageFactory.initElements(driver, Home);
	   PageFactory.initElements(driver, EBPanel);
	   
		  WebObjectUtil.MouseHover(Home.getNav_SupportTab());
		  WebObjectUtil.clickElement(Home.getNav_TicketsMenuLink());
		
		  WebDriverUtil.refreshBrowser();
		  
		  if (!EBPanel.getNav_firstLevelChildrenOrgTable().isDisplayed())
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "EBPanelPopUp", "pass", "EBPanel has not Popsup after refreshing the page"); 
		}
		else
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "EBPanelPopUp", "fail", "EBPanel has Popsup after refreshing the page"); 
		}
	} catch (Exception e) {
		LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyEBPanelTktRefresh", "warn", "catch block:Could NOT access webelement" +e.getMessage());	
	}
}

/*====================================================================================================
Method Name 	: verifyEBPanelVMRefrsh
Description		: Verifying EBPanel Popup After Refreshing VM page
Author 			: QAA03
Creation Date 	: 08/19/2015
Pre-Requisites	:
Revision History:
=====================================================================================================*/

public static void verifyEBPanelVMRefrsh()
{
   try {
	   WebDriver driver = WebDriverUtil.getDriver();
	   PageFactory.initElements(driver, EVDC);
	   PageFactory.initElements(driver, EBPanel);
	   
		  WebObjectUtil.clickElement(EVDC.getNav_EVDCname());
		  WebObjectUtil.clickElement(EVDC.getNav_EVDCOverviewVirtualMachine());
		  WebDriverUtil.refreshBrowser();
		  
		  if (!EBPanel.getNav_firstLevelChildrenEditBox().isDisplayed())
		    {
		    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "EBPanelPopUp", "pass", "EBPanel has not Popsup after refreshing VM page"); 
		    }
		    else
		    {
		    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "EBPanelPopUp", "fail", "EBPanel has Popsup after refreshing VM page"); 
		    }
	} catch (Exception e) {
		LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyEBPanelVMRefrsh", "warn", "catch block:Could NOT access webelement" +e.getMessage());
	}
}
/*====================================================================================================
Method Name 	: verifyEBChildData
Description		: Verifying EBPanel child data
Author 			: QAA03
Creation Date 	: 08/19/2015
Pre-Requisites	:
Revision History:
=====================================================================================================*/


public static void verifyEBChildData()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, Ticket);
	PageFactory.initElements(driver, Home);
	PageFactory.initElements(driver, EBPanel);
       // String sFirstRowChild;
        int iExpandFirstRow=0;
  try {
		    WebObjectUtil.MouseHover(Ticket.getNav_SupportTabLink());
		    WebObjectUtil.clickElement(Home.getNav_TicketsMenuLink());
		    WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		   
			//clicking on the first org in FLC
		    sFirstRowChild = WebTableUtil.getRowAsWebElement(EBPanel.getNav_FirstLevelChildrenOrgTable(),iExpandFirstRow).getText();
            WebObjectUtil.clickElement(WebTableUtil.getRowAsWebElement(EBPanel.getNav_FirstLevelChildrenOrgTable(),iExpandFirstRow));
           WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());

           //expanding first row ticket
           expandTicketCheckChildOrg();
         
           WebObjectUtil.explicitWait(10);
         //more than one page tickets are displayed then navigating to last page
         if(Ticket.getNav_TicketLastPageIcon().isDisplayed() && Ticket.getNav_TicketLastPageIcon().isEnabled())
      {
         	
          WebObjectUtil.clickElement(Ticket.getNav_TicketLastPageIcon()); 
          WebObjectUtil.explicitWait(10);
          expandTicketCheckChildOrg();
      }
		
		  
		
	} catch (Exception e) {
		    LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
		    FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyEBChildData", "warn", "catch block:Could NOT access webelement" +e.getMessage());	
	}  
}

/*====================================================================================================
Method Name 	: expandTicketCheckChildOrg
Description		: Expanding Tickets and Checking organization
Author 			: QAA03
Creation Date 	: 08/19/2015
Pre-Requisites	:
Revision History:
=====================================================================================================*/

  
public static void expandTicketCheckChildOrg()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, Ticket);
try {
	         int iExpandFirstRow=1;
			  WebElement wExpander,wOrgText;
			  String sOrgText = null;
			  
			//This below line updated on 10/07/2015 for EXTJS5 by QAA03
			//wExpander=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+iExpandFirstRow+"]//tr[1]/td[1]//div[@class='x-grid-row-expander']", "Arrow Expander");
			 // wExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTicketsGridPanel-body']/div/div/table[1]/tbody/tr/td/div/div[@class='x-grid-row-expander']", "Ticket Arrow Expander");
			  // This object is updated on 10/13/2015 By QAA04
			  wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
			  WebObjectUtil.clickElement(wExpander);
			  
			//This below line updated on 10/07/2015 for EXTJS5 by QAA03
           // expanding the first row and checking the organization name
			  //wOrgText=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+iExpandFirstRow+"]//td/div[@id='ticket_content']/dl/dt[text()='Organization']/../dd", "Organization name");
			 // wOrgText=WebObjectUtil.GetWebElement("xpath", "//table[1]//table/tbody/tr[5]/td/div[@id='ticket_content']/dl/dt[text()='Organization']/../dd", "Organization name");
			  // This object is updated on 10/13/2015 By QAA04
			  wOrgText = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER.ORGNAME", "PARAMETER_ROWNUMBER", 1 +"");
			  sOrgText=wOrgText.getText();
           if(sOrgText.contains(sFirstRowChild))
           {
         	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "ChildOrganisation", "pass", "Only Child organisation data is present"); 
           }
           else
           {
                FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "ChildOrganisation", "fail", "Not Only Child organisation data is present");
           }
           WebObjectUtil.clickElement(wExpander);
		} catch (Exception e) {
			LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "expandTicketCheckChildOrg", "warn", "catch block:Could NOT access webelement" +e.getMessage());
		}
}

/*====================================================================================================
Method Name 	: verifyTicketChildData
Description		: Verifying child data in Tickets
Author 			: QAA03
Creation Date 	: 08/20/2015
Pre-Requisites	:
Revision History:
=====================================================================================================*/


public static void verifyTicketChildData()
{
try {
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EBPanel);
	PageFactory.initElements(driver, Ticket);
	PageFactory.initElements(driver, Home);
	     WebElement wExpander;
	   int  iExpandFirstRow=1;
	     String sTSummaryText=null,sTSummaryEditValue=null,sTSummaryValueAfterEdit=null;
	     
	     String sFLCOrgData = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.EB.FLCHILDORG");
	     String sSLCOrgData= (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.EB.SLCHILDORG");
	    
	     String sTSummaryEditText = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.EB.TICKETSUMMARYEDIT");
	     
	     WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
	    
	     selectOrgFromAllLevelsEB(sFLCOrgData, sSLCOrgData,"", "");
	     WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
	          
         WebObjectUtil.MouseHover(Ticket.getNav_SupportTabLink());
	     WebObjectUtil.clickElement(Home.getNav_TicketsMenuLink());
         WebObjectUtil.explicitWait(10);
        //This Line updated on 10/06/2015 by QAA03 for EXTJS5
        //expanding first row ticket and editing summary field 
		// wExpander=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+iExpandFirstRow+"]//tr[1]/td[1]//div[@class='x-grid-row-expander']", "Arrow Expander");
        // wExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTicketsGridPanel-body']/div/div/table[1]/tbody/tr/td/div/div[@class='x-grid-row-expander']", "Ticket Arrow Expander");
         // This object is updated on 10/13/2015 By QAA04
         wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
         WebObjectUtil.clickElement(wExpander);
		 sTSummaryText = Ticket.getNav_TicketSummaryEdit().getAttribute("value");
		 sTSummaryEditValue= sTSummaryText + sTSummaryEditText + FrameworkUtil.sTimeStamp;
		 // saving the ticket and verifying the edited value 
		 WebObjectUtil.SetValueEdit(Ticket.getNav_TicketSummaryEdit(),sTSummaryEditValue );
		 WebObjectUtil.clickElement(Ticket.getNav_TicketSaveUpdatesBtn());
		 WebObjectUtil.handleJSAlert();
		 sTSummaryValueAfterEdit = Ticket.getNav_TicketSummaryEdit().getAttribute("value");
		 if(sTSummaryValueAfterEdit.contentEquals(sTSummaryEditValue))
		 {
			 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "TicketSummaryEdited", "pass", "Ticket Summary field value edited");  
		 }
		 else
		 {
			 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "TicketSummaryEdited", "fail", "Ticket Summary field value not edited");
		 }
		 
		 
} catch (Exception e) {
	LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyTicketChildData", "warn", "catch block:Could NOT access webelement" +e.getMessage());	
}  
}

/*====================================================================================================
Method Name 	: verifyPreviousOrgEB
Description		: Verifying whether user is able to select the previous levels going back in EB
Author 			: QAA03
Creation Date 	: 08/20/2015
Pre-Requisites	:
Revision History:
=====================================================================================================*/


public static void verifyPreviousOrgEB()
{
String sFLCOrgData = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.EB.FLCHILDORG");
String sSLCOrgData= (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.EB.SLCHILDORG");
String sTLCOrgData = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.EB.TLCHILDORG");

WebElement wSLCOrgItemtoSelect=null,wFLCOrgItemtoSelect=null;

    WebDriver driver =WebDriverUtil.getDriver();
    PageFactory.initElements(driver, EBPanel);
    
try {
	WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
	 //selecting three levels children from EB
	 selectOrgFromAllLevelsEB(sFLCOrgData, sSLCOrgData, sTLCOrgData, "");
	//checking third level children organization
	 WebObjectUtil.VerifyTextUnderElement(EBPanel.getNav_OrgNameTitleLink(),sTLCOrgData);
	 //going back and checking second level children organization
	 WebObjectUtil.SetValueEdit(EBPanel.getNav_secondLevelChildrenEditBox(),sSLCOrgData);
	// wSLCOrgItemtoSelect=WebObjectUtil.GetWebElement("xpath", "//table[contains(@id,'table')]//div[text()='"+sSLCOrgData+"']", "SLCOrgItem");
	 // This object is updated on 10/13/2015 By QAA04
	 wSLCOrgItemtoSelect = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EBPANEL.SECONDLEVELORG.DATA", "PARAMETER_ORGDATA", sSLCOrgData);
	 wSLCOrgItemtoSelect.click(); 
	 
	 WebObjectUtil.VerifyTextUnderElement(EBPanel.getNav_OrgNameTitleLink(),sSLCOrgData);
	//going back and checking first level children organization
	 WebObjectUtil.SetValueEdit(EBPanel.getNav_SecondLevelChildrenEditBox(),sFLCOrgData);
	// wFLCOrgItemtoSelect=WebObjectUtil.GetWebElement("xpath", "//table[contains(@id,'table')]//div[text()='"+sFLCOrgData+"']", "FLCOrgItem");
	 // This object is updated on 10/13/2015 By QAA04
	 wFLCOrgItemtoSelect = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EBPANEL.FOURTHLEVELORG.DATA", "PARAMETER_ORGDATA", sFLCOrgData);
	 wFLCOrgItemtoSelect.click(); 
	 
	 WebObjectUtil.VerifyTextUnderElement(EBPanel.getNav_OrgNameTitleLink(),sFLCOrgData);
} catch (Exception e) {
	
	LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyPreviousOrgEB", "warn", "catch block:Could NOT access webelement" +e.getMessage());	
	
}
}

/*====================================================================================================
Method Name 	: verifyTicketUserEntity
Description		: Verifying Ticket And Service Logs for user and entities
Author 			: QAA03
Creation Date 	: 08/21/2015
Pre-Requisites	:
Revision History:
=====================================================================================================*/


public static void verifyTicketUserEntity()
{
    String sFLCOrgData = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.EB.FLCHILDORG");
    String sSLCOrgData= (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.EB.SLCHILDORG");
    String sFirstRowTicketID = null,sTktNotesID = null, sTktLogsID = null, sTktServiceLogsID = null;
    String sCFirstRowTicketID = null,sCTktNotesID = null, sCTktLogsID = null, sCTktServiceLogsID = null;
    WebElement wExpander,wTicketNotesExpander,wTicketLogsExpander,wTicketServiceLogsExpander;
    WebElement wCExpander,wCTicketNotesExpander,wCTicketLogsExpander,wCTicketServiceLogsExpander;
   int iExpandFirstRow=1;
    
   WebDriver driver =WebDriverUtil.getDriver();
   PageFactory.initElements(driver, EBPanel);
   PageFactory.initElements(driver, Ticket);
   PageFactory.initElements(driver, Home);
    try {
		   WebObjectUtil.MouseHover(Ticket.getNav_SupportTabLink());
		   WebObjectUtil.clickElement(Home.getNav_TicketsMenuLink());
		   //This Line updated on 10/06/2015 by QAA03 for EXTJS5
           //expanding the first row ticket for the user
		   //wExpander=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+iExpandFirstRow+"]//tr[1]/td[1]//div[@class='x-grid-row-expander']", "Arrow Expander");
		   //wExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTicketsGridPanel-body']/div/div/table[1]/tbody/tr/td/div/div[@class='x-grid-row-expander']", "Ticket Arrow Expander");
		   //This object is updated on 10/13/2015 By QAA04
		   WebObjectUtil.waitForElementPresent(Ticket.getNav_CreateTicketLink());
		   wExpander=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
		   WebObjectUtil.clickElement(wExpander);
		   
		   //This Line updated on 10/06/2015 by QAA03 for EXTJS5
		   //sFirstRowTicketID = WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1,3).trim();
		  sFirstRowTicketID = WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 2).trim();
		   sTktNotesID="tktNotesImg-"+sFirstRowTicketID;
		   sTktLogsID="tktLogsImg-" + sFirstRowTicketID;
		   sTktServiceLogsID="tktServiceLogsImg-" + sFirstRowTicketID;
		  
		  /* wTicketNotesExpander = WebObjectUtil.GetWebElement("id", sTktNotesID, "Ticket Notes Expander");
		   wTicketLogsExpander = WebObjectUtil.GetWebElement("id", sTktLogsID, "Ticket Logs Expander");
		   wTicketServiceLogsExpander = WebObjectUtil.GetWebElement("id", sTktServiceLogsID, "Ticket Service Logs Expander");
		  */
		   wTicketNotesExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER", "PARAMETER_TICKETID",  sFirstRowTicketID);
		   wTicketLogsExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.LOGS.EXPANDER", "PARAMETER_TICKETID",  sFirstRowTicketID);
		   wTicketServiceLogsExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.SERVICELOGS.EXPANDER", "PARAMETER_TICKETID",  sFirstRowTicketID);
		   
		   //verifying the notes,ticket logs and ticket service logs fields in the expanded ticket of user
		   WebObjectUtil.verifyElementPresent(wTicketNotesExpander);

		   WebObjectUtil.verifyElementPresent(wTicketLogsExpander);
		   
		   WebObjectUtil.verifyElementPresent(wTicketServiceLogsExpander);
		   
		   WebObjectUtil.explicitWait(20); 
		   WebObjectUtil.clickElement(wExpander);

		   WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());

		   selectOrgFromAllLevelsEB(sFLCOrgData, sSLCOrgData, "", "");
		   
		   WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
		   WebObjectUtil.explicitWait(10); 
		   //This Line updated on 10/06/2015 by QAA03 for EXTJS5
		   //expanding the first row ticket for the child
		   //wCExpander=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+iExpandFirstRow+"]//tr[1]/td[1]//div[@class='x-grid-row-expander']", "Arrow Expander");
		 //  wCExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTicketsGridPanel-body']/div/div/table[1]/tbody/tr/td/div/div[@class='x-grid-row-expander']", "Ticket Arrow Expander");
		   // This object is updated on 10/13/2015 By QAA04
		   wCExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
		   WebObjectUtil.clickElement(wCExpander);
		   
		   //This Line updated on 10/06/2015 by QAA03 for EXTJS5
		   //verifying the notes,ticket logs and ticket service logs fields in the expanded ticket of child
		   //sCFirstRowTicketID = WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 3).trim();
		   sCFirstRowTicketID = WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 2).trim();
		   
		   sCTktNotesID="tktNotesImg-"+sCFirstRowTicketID;
		   wCTicketNotesExpander = WebObjectUtil.GetWebElement("id", sCTktNotesID, "Ticket Notes Expander");
		  
		   WebObjectUtil.explicitWait(20);
		   WebObjectUtil.verifyElementPresent(wCTicketNotesExpander);
		   
		   
		   
		   sCTktLogsID="tktLogsImg-" + sCFirstRowTicketID;
		   sCTktServiceLogsID="tktServiceLogsImg-" + sCFirstRowTicketID;
		  
		   wCTicketLogsExpander = WebObjectUtil.GetWebElement("id", sCTktLogsID, "Ticket Logs Expander");
		   wCTicketServiceLogsExpander = WebObjectUtil.GetWebElement("id", sCTktServiceLogsID, "Ticket Service Logs Expander");
		 
		 		   
		   if(wCTicketLogsExpander == null && wCTicketServiceLogsExpander == null )
		   {
			   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Ticket Logs & Service Logs", "pass", "Ticket Logs & Service Logs are not present in child entity tickets as expected");  
		   }
		   else
		   {
			   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Ticket Logs & Service Logs", "fail", "Ticket Logs & Service Logs are present in child entity tickets");
		   }

		
	} catch (Exception e) {
		   
		LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyTicketUserEntity", "warn", "catch block:Could NOT access webelement" +e.getMessage());	
	}  
   
}

/*====================================================================================================
Method Name 	: verifyEntityUser
Description		: Verifying corresponding entities
Author 			: QAA03
Creation Date 	: 08/18/2015
Pre-Requisites	:
Revision History:
=====================================================================================================*/

public static void verifyEntityUser()
{
  String sColumn1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USERS.COLUMNADDED1");
  String sColumn2 = (String)FrameworkUtil.dictPropertyData.get("NAV.USERS.COLUMNADDED2");
  String sOrgName=null,sEntityText=null,sParentText=null,sEntityName=null,sParentName=null;
   WebDriver driver =WebDriverUtil.getDriver();
   PageFactory.initElements(driver, Home);
   PageFactory.initElements(driver, EBPanel);
  
  try {
	  
		 //WebObjectUtil.clickByJS(Home.getNav_AccountTab());
	     WebObjectUtil.clickElement(Home.getNav_AccountTab());
		 WebObjectUtil.clickElement(Home.getNav_PermissionsLink());
		 sOrgName = EBPanel.getNav_OrgName().getText();
		 sEntityText = EBPanel.getNav_Users_FirstRow_EntityColumn().getText();
		 sParentText = EBPanel.getNav_Users_FirstRow_ParentColumn().getText();
		 sEntityName = EBPanel.getNav_Users_EntityColumnName().getText();
		 sParentName = EBPanel.getNav_Users_ParentColumnName().getText();
		 //verifying entity text with the org and printing parent org name
		 if(sOrgName.contentEquals(sEntityText))
		 {
			 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "OrgAndEntityName", "pass", "Organisation And Entity Names Are Equal"); 
			  
		 }
		 else
		 {
			 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "OrgAndEntityName", "fail", "Organisation And Entity Names Are Not Equal");
		 }
		 
		     FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "EntityHasParent", "pass", "Entity has Parent Organisation" +sParentText);
		  //verifying entity and parent columns present   
		  if(sEntityName.contentEquals(sColumn1))
		  {
		    	 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "ColumnAddedEntity", "pass", "Entity added as Column");  
		  }
		  else
		  {
		    	 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "ColumnAddedEntity", "fail", "Entity not added as Column");  
		  }
		  if(sParentName.contentEquals(sColumn2))
		  {
		    	 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "ColumnAddedParent", "pass", "Parent added as Column");  
		  }
		  else
		  {
		    	 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "ColumnAddedParent", "fail", "Parent not added as Column"); 
		  }
	} catch (Exception e) {
		LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyEntityUser", "warn", "catch block:Could NOT access webelement" +e.getMessage());
	}
}

/*====================================================================================================
Method Name 	: selectOrgFromAllLevelsEB
Description		: Selecting Organisations from all levels in EB
Author 			: QAA03
Creation Date 	: 08/19/2015
Pre-Requisites	:
Revision History:
=====================================================================================================*/


public static boolean selectOrgFromAllLevelsEB(String FLCOrg,String SLCOrg,String TLCOrg,String FRLCOrg)
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EBPanel);
	
	boolean bEBOrgOrder = true;
    WebElement wFLCOrgItemtoSelect,wSLCOrgItemtoSelect,wTLCOrgItemtoSelect,wFRLCOrgItemtoSelect;
    PageFactory.initElements(WebDriverUtil.getDriver(), EBPanel);
     try {
     	//selecting organization from first level children in EB
			if(FLCOrg.length()>0 && FLCOrg!=null)
          {
			       WebObjectUtil.SetValueEdit(EBPanel.getNav_firstLevelChildrenEditBox(),FLCOrg);
			      // wFLCOrgItemtoSelect=WebObjectUtil.GetWebElement("xpath", "//div[@id='1stGrid']//table[contains(@id,'table')]//div[text()='"+FLCOrg+"']", "FLCOrgItem");
			      // wFLCOrgItemtoSelect=WebObjectUtil.GetWebElement("xpath", "//div[@id='1stGrid-body']//table//div[text()='"+FLCOrg+"']", "FLCOrgItem");
			       // This object is updated on 10/13/2015 By QAA04
			       wFLCOrgItemtoSelect = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EBPANEL.FIRSTLEVELORG.ITEM.SELECT", "PARAMETER_SELECTEDITEM", FLCOrg);
			      
			       if(wFLCOrgItemtoSelect != null)
			       {
				       wFLCOrgItemtoSelect.click();
			       }
			       else
			       {
			    	   FrameworkUtil.updateCustomResultBasedOnStatus(false, "Organization not found in First Level Children:"+FLCOrg);
			    	   bEBOrgOrder = false;
			       }
         }
		
			//selecting organization from second level children in EB
			if(SLCOrg.length()>0 && SLCOrg!=null)
          {
			      WebObjectUtil.SetValueEdit(EBPanel.getNav_secondLevelChildrenEditBox(),SLCOrg);
			      //wSLCOrgItemtoSelect=WebObjectUtil.GetWebElement("xpath", "//div[@id='2ndGrid']//table[contains(@id,'table')]//div[text()='"+SLCOrg+"']", "SLCOrgItem");
			     // wSLCOrgItemtoSelect=WebObjectUtil.GetWebElement("xpath", "//div[@id='2ndGrid-body']//table//div[text()='"+SLCOrg+"']", "SLCOrgItem");
			      // This object is updated on 10/13/2015 By QAA04
			      wSLCOrgItemtoSelect = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EBPANEL.SECONDLEVELORG.ITEM.SELECT", "PARAMETER_SELECTEDITEM", SLCOrg);
			      
			      if(wSLCOrgItemtoSelect != null)
			       {
				       wSLCOrgItemtoSelect.click();
			       }
			       else
			       {
			    	   FrameworkUtil.updateCustomResultBasedOnStatus(false, "Organization not found in Second Level Children:"+SLCOrg);
			    	   bEBOrgOrder = false;
			       }
          }
			 
		      
			//selecting organization from third level children in EB
			if(TLCOrg.length()>0 && TLCOrg!=null)
         {
			      WebObjectUtil.SetValueEdit(EBPanel.getNav_thirdLevelChildrenEditBox(),TLCOrg);
			      //wTLCOrgItemtoSelect=WebObjectUtil.GetWebElement("xpath", "//div[@id='3rdGrid']//table[contains(@id,'table')]//div[text()='"+TLCOrg+"']", "TLCOrgItem");
			      //wTLCOrgItemtoSelect=WebObjectUtil.GetWebElement("xpath", "//div[@id='3rdGrid-body']//table//div[text()='"+TLCOrg+"']", "TLCOrgItem");
			      // This object is updated on 10/13/2015 By QAA04
			      wTLCOrgItemtoSelect = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EBPANEL.THIRDLEVELORG.ITEM.SELECT", "PARAMETER_SELECTEDITEM", TLCOrg);
			      
			      if( wTLCOrgItemtoSelect != null)
			       {
				       wTLCOrgItemtoSelect.click();
			       }
			       else
			       {
			    	   FrameworkUtil.updateCustomResultBasedOnStatus(false, "Organization not found in Third Level Children:"+TLCOrg);
			    	   bEBOrgOrder = false;
			       }
          }
			
			//selecting organization from fourth level children in EB
			if(FRLCOrg.length()>0 && FRLCOrg!=null)
          {
			      WebObjectUtil.SetValueEdit(EBPanel.getNav_fourthLevelChildrenEditBox(),FRLCOrg);
			      //wFRLCOrgItemtoSelect=WebObjectUtil.GetWebElement("xpath", "//div[@id='4thGrid']//table[contains(@id,'table')]//div[text()='"+FRLCOrg+"']", "FRLCOrgItem");
			      //wFRLCOrgItemtoSelect=WebObjectUtil.GetWebElement("xpath", "//div[@id='4thGrid-body']//table//div[text()='"+FRLCOrg+"']", "FRLCOrgItem");
			      // This object is updated on 10/13/2015 By QAA04
			      wFRLCOrgItemtoSelect = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EBPANEL.FOURTHLEVELORG.ITEM.SELECT", "PARAMETER_SELECTEDITEM", FRLCOrg);
			      
			      if( wFRLCOrgItemtoSelect != null)
			       {
			    	   wFRLCOrgItemtoSelect.click();
			       }
			       else
			       {
			    	   FrameworkUtil.updateCustomResultBasedOnStatus(false, "Organization not found in Fourth Level Children:"+FRLCOrg);
			    	   bEBOrgOrder = false;
			       }
          }
		} catch (Exception e) {
			
			LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "selectOrgFromAllLevelsEB", "warn", "catch block:Could NOT access webelement" +e.getMessage());	
			
		}
          return bEBOrgOrder;
}


/*====================================================================================================
Method Name 	: verifyOrgCreatorCreateTicket
Description		: Verifying Organisation and Creator in the Newly Created Ticket
Author 			: QAA03
Creation Date 	: 08/20/2015
Pre-Requisites	:
Revision History:
=====================================================================================================*/


public static void verifyOrgCreatorCreateTicket()
{
  String sFLCOrgData = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.EB.FLCHILDORG");
  String sSLCOrgData= (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.EB.SLCHILDORG");
  String sTSummaryCreateValue= (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.EB.TICKETSUMMARYEDIT");
  String sCreateTkOrgName=null,sTSummaryValueAfterCreate=null,sTicketAfterCreatedOrgText=null;
  String sCreatorName=null,sCreatorAfterTicketCreated=null;
  WebElement wExpander,wTicketAfterCreatedOrgText,wExpanderCreator;
  int iExpandFirstRow=1;
  
  try {
 	    sCreatorName= (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.USERID.ROLEA");
		 WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		 //selecting two level children from EB
		 selectOrgFromAllLevelsEB(sFLCOrgData, sSLCOrgData, "", "");
		 
		 WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
		 
		 WebObjectUtil.MouseHover(Ticket.getNav_SupportTabLink());
		 WebObjectUtil.clickElement(Ticket.getNav_TicketsMenuLink());
		 WebObjectUtil.explicitWait(10);
		 
		 WebObjectUtil.clickElement(Ticket.getNav_CreateTicketLink());
		 sCreateTkOrgName=Ticket.getNav_CreateTicketDialogOrganization().getAttribute("value");
		 
		//verifying organization name in create field
		 if(sCreateTkOrgName.contentEquals(sSLCOrgData))
		 {
			 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName,"CreateTicketOrgName", "pass", "Create Ticket Organization name matches with the child entity selected");     	 
		 }
		 else
		 {
			 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName,"CreateTicketOrgName", "fail", "Create Ticket Organization name didnot match with the child entity selected"); 
		 }
		 //creating ticket by entering value in summary field
		 sTSummaryCreateValue = sTSummaryCreateValue + FrameworkUtil.sTimeStamp;
		 WebObjectUtil.SetValueEdit(Ticket.getNav_CreateTicketDialogSummary(), sTSummaryCreateValue);
		 WebObjectUtil.clickElement(Ticket.getNav_CreateTicketDialogOkButton());
		 //WebObjectUtil.handleJSAlert();
		 WebObjectUtil.clickElement(Ticket.getNav_ConfirmPopupOkBtn());
		 WebObjectUtil.explicitWait(15);
		 //This Line updated on 10/06/2015 by QAA03 for EXTJS5
		 //expanding the created ticket
		 //wExpander=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+iExpandFirstRow+"]//tr[1]/td[1]//div[@class='x-grid-row-expander']", "Arrow Expander");
		// wExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTicketsGridPanel-body']/div/div/table[1]/tbody/tr/td/div/div[@class='x-grid-row-expander']", "Ticket Arrow Expander");
		 // This object is updated on 10/13/2015 By QAA04
		 wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
		 WebObjectUtil.clickElement(wExpander);
		 sTSummaryValueAfterCreate = Ticket.getNav_TicketSummaryEdit().getAttribute("value");
		 
		 //checking the summary value in created ticket
		 if(sTSummaryValueAfterCreate.contentEquals(sTSummaryCreateValue))
		 {
			 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "TicketSummaryField", "pass", "New ticket is created");  
		 }
		 else
		 {
			 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "TicketSummaryField", "fail", "Ticket is not created");
		 }
		 //This Line updated on 10/06/2015 by QAA03 for EXTJS5
		 //Getting the creator name in the created ticket
		// wTicketAfterCreatedOrgText=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+iExpandFirstRow+"]//td/div[@id='ticket_content']/dl/dt[text()='Organization']/../dd", "Organization name");
		 //wTicketAfterCreatedOrgText=WebObjectUtil.GetWebElement("xpath", "//table[1]//table/tbody/tr[5]/td/div[@id='ticket_content']/dl/dt[text()='Organization']/../dd", "Organization name");
		 // This object is updated on 10/13/2015 By QAA04
		 wTicketAfterCreatedOrgText = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER.ORGNAME", "PARAMETER_ROWNUMBER", 1 +"");                                                              
		 sTicketAfterCreatedOrgText=wTicketAfterCreatedOrgText.getText();
		 
		//This Line updated on 10/06/2015 by QAA03 for EXTJS5
		// wExpanderCreator=WebObjectUtil.GetWebElement("xpath","//tr["+iExpandFirstRow+"]//tr[@class='x-grid-rowbody-tr']//div[@class='tkt_drop_down']/div[3]/dl/dt", "Ticket Created By");
		// wExpanderCreator=WebObjectUtil.GetWebElement("xpath", "//table[1]/tbody/tr[@class='x-grid-rowbody-tr']/td//div[@class='tkt_drop_down']/div[3]/dl/dt", "Ticket Created By");
		 // This object is updated on 10/13/2015 By QAA04
		 wExpanderCreator = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER.CREATEDBY", "PARAMETER_ROWNUMBER", 1 +"");
		 sCreatorAfterTicketCreated = wExpanderCreator.getText();
		 //checking the creator name matches the user logged in
		 if(sTicketAfterCreatedOrgText.contentEquals(sSLCOrgData))
		 {
		      FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "OrgnameAfterTicketCreated", "pass", "Organization name after ticket created matches child entity"); 
		 }
		 else
		 {
		      FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "OrgnameAfterTicketCreated", "fail", "Organization name after ticket created  not matches child entity");
		 }
		 if(sCreatorAfterTicketCreated.contentEquals(sCreatorName))
		 {
		      FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "CreatornameAfterTicketCreated", "pass", "Creator name after ticket created matches the user"); 
		 }
		 else
		 {
		      FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "CreatornameAfterTicketCreated", "fail", "Creator name after ticket created  not matches the user");
		 }
		 
	} catch (Exception e) {
		
		LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyOrgCreatorCreateTicket", "warn", "catch block:Could NOT access webelement" +e.getMessage());	
		
	}
  
}

/////__________________ Completed Clark TestCases _______________________________________/////

/////__________________ Eilerson TestCases Start _______________________________________/////

/*==============================================================
TestScript 		: navVerifyEVDCData
Manual TestCase	: CPPOC-3482/QAT-40
Description		: Verify the EVDC data is displayed for the selected entity from the Entity Browser
Author 			: QAA04
Creation Date 	: 09/09/2015
Pre-Requisites	:
Revision History:
==============================================================*/

@Test(priority=24)
public void navVerifyEVDCData() {
	String sFirstLevelOrgName,sEVDCTitle,sMultiOrgName,sEVDCName;
	boolean bStatus=false;
	WebDriver driver= WebDriverUtil.getDriver();
	PageFactory.initElements(driver, UPMultiOrg);
	
	PageFactory.initElements(driver, EBPanel);
	
	PageFactory.initElements(driver, EVDC);
	try {
		

	FrameworkUtil.sTestCaseName ="navVerifyEVDCData";
	FrameworkUtil.sManualTestCaseName ="(QAT-40)Verify the EVDC data is displayed for the selected entity from the Entity Browser";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	
	String sUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.AROLE1");
	String sPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.AROLE");
	//LoginTestCase.nav_Login(sUserName, sPassword);
	LoginTestCase_Old1.LoginAsTstMultiOrgRoleA1User(); // current user
	
	//LoginTestCase.LoginAsQaautoMMultiOrgUser(); // should be updated with qaauto-m
	
	sMultiOrgName=(String) FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
	WebObjectUtil.selectWebList(UPMultiOrg.getNav_orgDropDown(), sMultiOrgName, null, null);
	WebObjectUtil.clickElement(UPMultiOrg.getNav_UseOrgButton());
	WebObjectUtil.explicitWait(10);
	//HomeTestCase.nav_WindStreamToTierPointHomePopup();
	WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
	
	sFirstLevelOrgName=(String) FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.FIRST.LEVEL.TST.ORGNAME");
	EntityBrowserTestCase.selectOrgFromAllLevelsEB(sFirstLevelOrgName,"", "","");
	WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
	WebObjectUtil.explicitWait(5);
	sEVDCTitle=(String) FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.FIRST.LEVEL.TST.ORGNAME2");
			
	
	sEVDCName=EVDC.getNav_Home_EVDCPortletsDivision().getText();
	 bStatus =sEVDCName.contains(sEVDCTitle);
	FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "EVDC Data for Organization" +sFirstLevelOrgName);
	//WebObjectUtil.VerifyTextUnderElement(Eilerson.getNav_EVDCNameLink(), sEVDCTitle);
	
	
	LoginTestCase_Old1.nav_Logout();
	}
	catch (Exception e) {
		LoggerUtil.log_type_error("Issue with - Verifing the EVDC data is displayed for the selected org");
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		LoggerUtil.log_type_error(e.getMessage());
	}
}

/*==============================================================
TestScript 		: navVerifyEVDCPortal
Manual TestCase	: CPPOC-3428/QAT-60
Description		: Verify that Firewalls portlet does not have any Firewalls data.
Author 			: QAA04
Creation Date 	: 09/11/2015
Pre-Requisites	:
Revision History:
==============================================================*/

@Test(priority=25)
public void navVerifyEVDCPortal() {
	WebElement wSelectOrg;
	String sFirstLevelOrgName,sEVDCErrorMsg,sFirewallRule,sOrgName,sParentOrgName;
	int iFirewallRule;
	WebDriver driver = WebDriverUtil.getDriver();
	//PageFactory.initElements(driver, ManageEntity);
	PageFactory.initElements(driver, Firewall);
	PageFactory.initElements(driver, UPMultiOrg);
	PageFactory.initElements(driver, EBPanel);
	PageFactory.initElements(driver, EVDC);
	PageFactory.initElements(driver, Common);
	try {
		
	
	FrameworkUtil.sTestCaseName="navVerifyEVDCPortal";
	FrameworkUtil.sManualTestCaseName="(QAT-60)Verify that Firewalls portlet does not have any Firewalls data.";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	
    String sUserName= (String) FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLE.USERID");
    String sPassword= (String) FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLE.PWD");
   
    sParentOrgName= (String) FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
    sOrgName= (String) FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.FIRST.LEVEL.AAA.ORGNAME");
    
    
    // setting the permission
    AdminTestCase.verifyParentChildEntity(sOrgName, sParentOrgName);
    
    
   // LoginTestCase.nav_Login(sUserName, sPassword);
    LoginTestCase_Old1.LoginAsDevcoUser();
    //LoginTestCase.LoginAsQaautoUser();
    WebObjectUtil.clickElement(EVDC.getNav_EVDCname());
    sFirewallRule = Firewall.getNav_RulesCountText().getText();
    iFirewallRule = sFirewallRule.length();
    if(sFirewallRule != null){
    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Firewall Data", "pass", "Firewall Rule data  count is - " +sFirewallRule);
    }
    else {
    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Firewall Data", "fail", "Firewall Rule data is not diaplaying");
    }
    WebObjectUtil.explicitWait(5);
	WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
	
	sFirstLevelOrgName=(String) FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.FIRST.LEVEL.AAA.ORGNAME");
	EntityBrowserTestCase.selectOrgFromAllLevelsEB(sFirstLevelOrgName,"", "", "");
	/*wSelectOrg= WebObjectUtil.GetWebElement("XPATH", "//div[@id='1stGrid']//table[contains(@id,'-record-')]//div[text()='AAAA Benefits']", "Selecting AAAA Benefits Org");
	wSelectOrg.click();*/
	WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
	WebObjectUtil.explicitWait(5);
    
	if(WebObjectUtil.isElementPresent(Common.getNav_CommonPopUp()))
	{
		WebObjectUtil.clickElement(EVDC.getNav_NoEVDCPopUpNoButton());
	
	/*sEVDCErrorMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.AAA.EVDC.ERROR.MESSAGE");
    WebObjectUtil.VerifyTextUnderElement(Eilerson.getNav_EVDCErrorMsg(), sEVDCErrorMsg);
    WebObjectUtil.clickElement(Eilerson.getNav_EVDCErrorOkBtn());
    WebObjectUtil.explicitWait(5);
    
    WebObjectUtil.verifyElementNOTPresent(UserPermission.getNav_EVDCNameLink());*/
	 sFirewallRule = Firewall.getNav_RulesCountText().getText();
	    iFirewallRule = sFirewallRule.length();
	    if(iFirewallRule == 0){
	    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Firewall Data", "pass", "Firewall data is not dispalying as No EVDC is present for organization "+sFirstLevelOrgName+" as expected ");
	    }
	    else {
	    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Firewall Data", "fail", "Firewall data count is - " +sFirewallRule);
	    }
	}
	
	LoginTestCase_Old1.nav_Logout();
	
	}
	catch (Exception e) {
		LoggerUtil.log_type_error("Issue with -navVerifyEVDCPortal test case");
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		LoggerUtil.log_type_error(e.getMessage());
	}
}
/////__________________ Eilerson TestCases End _______________________________________/////


/////////////////////////////////******Keffer TestCases Start****************////////////////////////////////////

////........................................Vivek Start .................................................////

/*==============================================================
TestScript 		: verChildEntityNotClickable
Manual TestCase	: Keffer-QAT-372-WCP_3659_TC_1.0_Roll Up_EVDC overview page
Description		: When roll up flag is ON, verify Child entity EVDC name is not clickable and VDC link is not displayed in the EVDC table.
Author 			: Vivek Kumar
Creation Date 	: 12/23/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=101)
public void verChildEntityNotClickable()
{
	
	WebDriver driver =WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EBPanel);
	PageFactory.initElements(driver, EVDC);
	
	String sUserName,sPassword;
	
	
	try {
		FrameworkUtil.sTestCaseName ="verChildEntityNotClickable";
		FrameworkUtil.sManualTestCaseName="Keffer-QAT-372-WCP_3659_TC_1.0_Roll Up_EVDC overview page";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.USERID");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.PASSWORD");
		
		//Login to navigator
		//LoginTestCase.nav_Login(sUserName, sPassword);
		LoginTestCase_Old1.LoginAsRoleAUser();
		
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		//WebObjectUtil.clickElement(EBPanel.getNav_entityBrowserLink());
		selectOrgFromAllLevelsEB("TST Entity01","", "", "");
		arrOrgNameFromEBPanel=EntityBrowserTestCase.getChildOrgNameListFromEBPanel(2);
		
		//Verifying that Parent entity should have link and Child should not have link	
		EVDC_Overview_TestCase.verParentChildEntityLink(true,false);
		//Logout
		LoginTestCase_Old1.nav_Logout();
	} catch (Exception e) {
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
	
}

/*==============================================================
TestScript 		: verImmediateParent
Manual TestCase	: Keffer-QAT-371WCP_1303_TC_1.5_RollUp_EVDCs table_shows immediate parent_name is clickable_vCloud Director link
				  QAT-357-WCP_3726_TC_1.0_RollUp EVDC_User Permissions_Role-A
Description		: Verify the Parent column shows the immediate parent for that entity in that row
Author 			: Vivek Kumar
Creation Date 	: 12/29/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=102)
public static void verImmediateParent()
{
	
	
	
	WebDriver driver =WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EBPanel);
	PageFactory.initElements(driver, EVDC);
	
	String sUserName,sPassword;
	 int iRowCnt;
	String sEVDCName,sEVDCParent,sArrEVDCName = null,sArrEVDCParent = null;
	
	String[] arrEVDC_Entity_List;
	String[] arrEVDCInfo = null;
	boolean bFlag;
	
	
	
		FrameworkUtil.sTestCaseName ="verImmediateParent";
		FrameworkUtil.sManualTestCaseName="Keffer-QAT-371,357-WCP_1303_TC_1.5_RollUp_EVDCs table_shows immediate parent_name is clickable_vCloud Director link";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		//Login to Navigator with ishannon user 
	    LoginTestCase_Old1.LoginAsIshannonUser();
	    
		//precondition for -setting child parent relationship to entities in the flow TST Entity01/TST Entity02/TST Entity03/TST Entity04
		AdminTestCase.setTstEntityParent();
		
		//Logout from Navigator
		LoginTestCase_Old1.nav_Signout();
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.USERID");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.PASSWORD");
		
		
		//Login to navigator
		//LoginTestCase.nav_Login(sUserName, sPassword);
		LoginTestCase_Old1.LoginAsRoleAUser();
		
		
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		EntityBrowserTestCase.selectOrgFromAllLevelsEB("TST Entity01","","","");
		//Verifying that Parent entity should have link and Child should not have link	
		EVDC_Overview_TestCase.verParentChildEntityLink(true,true);	
		//Back to main entity
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		EntityBrowserTestCase.setRollOnOffEBPanel(false);
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		WebObjectUtil.explicitWait(5);
		
		//Getting the EVDC Name along with their parent entity into array
		arrEVDC_Entity_List=EVDC_Overview_TestCase.getEVDCNameWithEntityName("TST Entity01","","","");
	
		//Loading the EVDC View table
		CustomWebElementUtil.loadCustomElement(EVDC.getNav_EVDCViewHomeTable(), "table");
		iRowCnt=CustomWebElementUtil.iRowCount;
		
		//Verifying the available EVDC name with their Parent Entity
		for(int i=1;i<=iRowCnt;i++)
		{
			sEVDCName=CustomWebElementUtil.getCellData(i, 1).toLowerCase();
			sEVDCParent=CustomWebElementUtil.getCellData(i, 2).toLowerCase();
			bFlag=false;
		//==========================================	
			//for (String sEVDC :arrEVDC_Entity_List )
			for(int j=1;j<arrEVDC_Entity_List.length;j++)
			{
				arrEVDCInfo=arrEVDC_Entity_List[j].split("!P!");
				//Capturing EVDC name from Array
				sArrEVDCName=arrEVDCInfo[0];
				sArrEVDCName=sArrEVDCName.toLowerCase().trim();
				//Capturing EVDC- Parent entity from an array
				sArrEVDCParent=arrEVDCInfo[1];
				sArrEVDCParent=sArrEVDCParent.toLowerCase().trim();
				//Comparing the value from array with the value present at Home page under EVDC View Table
				if(sEVDCName.equals(sArrEVDCName) && sEVDCParent.equals(sArrEVDCParent) )
				{
					bFlag=true;
					break;
				}
			}
			//Based on Flag - Printing the result
			FrameworkUtil.updateCustomResultBasedOnStatus(bFlag, "Verified - EVDC Name - "+sArrEVDCName + ", Parent Entity - "+sArrEVDCParent);
		}
		
		//Verifying the EVDC View Table header
		EVDC_Overview_TestCase.verifyEVDCViewTableHeader();
	
		//Logout
		LoginTestCase_Old1.nav_Logout();
	}



/*==============================================================
TestScript 		: verifyEVDCViewTablePagination
Manual TestCase	: Keffer-QAT-370-WCP_1303_TC_1.1_Rollup_View EVDCs_five per page_pagination after five EVDCs
Description		: To verify pagination will be there if more than 5 EVDc are there
Author 			: Vivek Kumar
Creation Date 	: 01/05/2016
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=103)
public static void verifyEVDCViewTablePagination()
{
	WebDriver driver =WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EBPanel);
	

	String sUserName,sPassword;
	
	FrameworkUtil.sTestCaseName ="verifyEVDCViewTablePagination";
	FrameworkUtil.sManualTestCaseName="Keffer-QAT-370-WCP_1303_TC_1.1_Rollup_View EVDCs_five per page_pagination after five EVDCs";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	
	sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.USERID");
	sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.PASSWORD");
	
	
	//Login to navigator
	//LoginTestCase.nav_Login(sUserName, sPassword);
	LoginTestCase_Old1.LoginAsRoleAUser();
	//Clicking on EB link		
	WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
	//turning RollUp Button ON
	EntityBrowserTestCase.setRollOnOffEBPanel(true);
	
	//Clicking on EB Title link
	WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
	WebObjectUtil.explicitWait(5);
	//Verifying Pagination
	EVDC_Overview_TestCase.verifyEVDCViewPagination();
	//Login out
	LoginTestCase_Old1.nav_Logout();
	
}


/*==============================================================
TestScript 		: verifyEVDCLinkAndVCldNotThere
Manual TestCase	: Keffer-QAT-367WCP_3726_TC_1.2_RollUp EVDC_User Permissions_Role-E
Description		: Login to navigator with full service observer role (Role-E) and verify new roll up view EVDC table. Verify this user is able to go to EVDC overview page for his org only. Child entity EVDCs links are disabled. 
				  vCloud Director link is not available for all EVDCs as this user doesn't have permissions.
Author 			: Vivek Kumar
Creation Date 	: 01/05/2016
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=104)
public void verifyEVDCLinkAndVCldNotThere()
{
	
	WebDriver driver =WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EBPanel);
	PageFactory.initElements(driver, EVDC);
	
	String sUserName,sPassword;
	
	
	try {
		FrameworkUtil.sTestCaseName ="verifyEVDCLinkAndVCldNotThere";
		FrameworkUtil.sManualTestCaseName="Keffer-QAT-367WCP_3726_TC_1.2_RollUp EVDC_User Permissions_Role-E";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEE.USERID");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEE.PASSWORD");
		
		//Login to navigator
		//LoginTestCase.nav_Login(sUserName, sPassword);
		LoginTestCase_Old1.LoginAsRoleEUser();
		
		
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		//WebObjectUtil.clickElement(EBPanel.getNav_entityBrowserLink());
		EntityBrowserTestCase.selectOrgFromAllLevelsEB("TST Entity01","","","");
		//EntityBrowserTestCase.arrOrgNameFromEBPanel=EntityBrowserTestCase.getChildOrgNameListFromEBPanel(2);
		
		//Verifying that Parent entity should have link and Child should not have link	
		EVDC_Overview_TestCase.verParentChildEntityLink(true,false);
		
		//Verifying VCloud link should not be there for ROLE E
		EVDC_Overview_TestCase.verifyVCldLnkNotThere();
		//Logout
		LoginTestCase_Old1.nav_Logout();
	} catch (Exception e)
	{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");	
	}
}

/*==============================================================
TestScript 		: verifyParentEntityDoesntHaveEVDCAndChildHave
Manual TestCase	: Keffer-QAT-362-WCP_1303_TC_3.2_Rollup_EVDC in table format_Parent entity doesn't have EVDCs_Child entities do
Description		: When Roll Up Flag is ON, and Parent entity doesn't have any EVDCs but Child entities do, Verify EVDCs are displayed in a table format for the child entities.
Author 			: Vivek Kumar
Creation Date 	: 01/06/2016
Pre-Requisites	:For this Test Case, Please use the following entities: 
					(Tst Entity01 and Tst Entity02 have EVDCs, RootLevelCascadeOrg doesn't have any EVDCs) 
					Tst Entity01 is a child entity of RootLevelCascadeOrg, 
					Tst Entity02 is a child entity of RootLevelCascadeOrg
Revision History:
==============================================================*/
@Test(priority=140)
public static void verifyParentEntityDoesntHaveEVDCAndChildHave()
{
	WebDriver driver=WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EBPanel);
			
	String sEVDCName,sEVDCParent,sArrEVDCName = null,sArrEVDCParent = null;
	
	String[] arrEVDC_Entity_List;
	String[] arrEVDCInfo = null;
	boolean bFlag;
	int iRowCnt;
	
	String sUserName,sPassword;
	
	FrameworkUtil.sTestCaseName ="verifyParentEntityDoesntHaveEVDCAndChildHave";
	FrameworkUtil.sManualTestCaseName="Keffer-QAT-362-WCP_1303_TC_3.2_Rollup_EVDC in table format_Parent entity doesn't have EVDCs_Child entities do";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	
	//Setting the Child entity for RootLevelCascadeOrg
	AdminTestCase.verifyParentChildEntity("TST Entity01", "RootLevelCascadeOrg");
	AdminTestCase.verifyParentChildEntity("TST Entity02", "RootLevelCascadeOrg");
	
	//Login to application
	sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.USERID");
	sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.PASSWORD");
	
	//Login to navigator
	//LoginTestCase.nav_Login(sUserName, sPassword);
	LoginTestCase_Old1.LoginAsRoleAUser();
	
	WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
	//EntityBrowserTestCase.selectOrgFromAllLevelsEB("RootLevelCascadeOrg", null, null, null);
	//Verifying that Parent entity should have link and Child should not have link	
	EVDC_Overview_TestCase.verParentChildEntityLink(true,true);	
	//Back to main entity
	WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
	EntityBrowserTestCase.setRollOnOffEBPanel(false);
	WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
	WebObjectUtil.explicitWait(5);
	
	
	//Getting the EVDC Name along with their parent entity into array
	arrEVDC_Entity_List=EVDC_Overview_TestCase.getEVDCNameWithEntityName("RootLevelCascadeOrg","","","");
	
	WebObjectUtil.scrollToElement(EVDC.getNav_EVDCViewHomeTable());
	//WebObjectUtil.scrollElementAtPageCenter(EVDC.getNav_EVDCViewHomeTable());
	
	//Loading the EVDC View table
	CustomWebElementUtil.loadCustomElement(EVDC.getNav_EVDCViewHomeTable(), "table");
	//CustomWebElementUtil.loadCustomElement(EVDC_Overview.getNav_EVDCViewHomeTable(), "table");
	iRowCnt=CustomWebElementUtil.iRowCount;
	
	//Verifying the available EVDC name with their Parent Entity
	for(int i=1;i<=iRowCnt;i++)
	{
		
		sEVDCName=CustomWebElementUtil.getCellData(i, 1).toLowerCase();
		sEVDCParent=CustomWebElementUtil.getCellData(i, 2).toLowerCase();
		/*WebElement wEVDCName = CustomWebElementUtil.getCellAsWebElement(i,1);
		//wEVDCName.click();
		WebElement wEVDCName1 = wEVDCName.findElement(By.tagName("a"));
		sEVDCName =wEVDCName1.getText().toLowerCase();
		WebElement wEVDCParent =CustomWebElementUtil.getCellAsWebElement(i,2);*/
		//sEVDCParent=wEVDCParent.findElement(By.tagName("div")).getText().toLowerCase();
		bFlag=false;
	//==========================================	
		//for (String sEVDC :arrEVDC_Entity_List )
		for(int j=0;j<arrEVDC_Entity_List.length;j++)
		{
			arrEVDCInfo=arrEVDC_Entity_List[j].split("!P!");
			//Capturing EVDC name from Array
			sArrEVDCName=arrEVDCInfo[0];
			sArrEVDCName=sArrEVDCName.toLowerCase().trim();
			//Capturing EVDC- Parent entity from an array
			sArrEVDCParent=arrEVDCInfo[1];
			sArrEVDCParent=sArrEVDCParent.toLowerCase().trim();
			//Comparing the value from array with the value present at Home page under EVDC View Table
			if(sEVDCName.equals(sArrEVDCName) && sEVDCParent.equals(sArrEVDCParent) )
			{
				bFlag=true;
				break;
			}
		}
		//Based on Flag - Printing the result
		FrameworkUtil.updateCustomResultBasedOnStatus(bFlag, "Verified - EVDC Name - "+sArrEVDCName + ", Parent Entity - "+sArrEVDCParent);
	}
	//Logout
	LoginTestCase_Old1.nav_Logout();
	
	AdminTestCase.verifyParentChildEntity("TST Entity01", ".HOSTEDSOLUTIONS");
	AdminTestCase.verifyParentChildEntity("TST Entity02", "TST Entity01");
}


/*==============================================================
TestScript 		: verifyEVDCFormatAndColumns
Manual TestCase	: QAT-338-WCP_1303_TC_1.2_RollUp_EVDCs in table format_Verify Columns
				  QAT-340-WCP_1303_TC_1.4_RollUp_EVDCs in table format_Sort by any column
				  QAT-350-WCP_1303_TC_1.0_RollUp_View EVDCs in table format
				  QAT-366-WCP_1303_TC_1.3_RollUp_EVDCs in table format_view PDF and CSV reports
Description		: EVDCs are correctly displayed in table format for 'tst entity02 and tst entity03' with the following columns:
 				  Name, Parents, VM Count, Networks, vCPUs, vRAM, and Storage.
 				  vCloud Director links are displayed next to Storage column
Author 			: Vivek Kumar
Creation Date 	: 01/12/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=106)
public void verifyEVDCFormatAndColumns()
{
	WebDriver driver=WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EBPanel);
	PageFactory.initElements(driver, EVDC);
	
	String sUserName,sPassword;
	
	FrameworkUtil.sTestCaseName ="verifyEVDCFormatAndColumns";
	FrameworkUtil.sManualTestCaseName="QAT-338,340,350,366-WCP_1303_TC_1.2_RollUp_EVDCs in table format_Verify Columns";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	
	//Login to Navigator with ishannon user 
    LoginTestCase_Old1.LoginAsIshannonUser();
    
	//precondition for -setting child parent relationship to entities in the flow TST Entity01/TST Entity02/TST Entity03/TST Entity04
	AdminTestCase.setTstEntityParent();
	
	//Logout from Navigator
	LoginTestCase_Old1.nav_Signout();
	
	//Login to application
	sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.USERID");
	sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.PASSWORD");
	
	//Login to navigator
	//LoginTestCase.nav_Login(sUserName, sPassword);
	LoginTestCase_Old1.LoginAsRoleAUser();

	//Clicking on Entity Browser Link
	WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
	
	
	//Selecting Organization from First Level and Second Level Children
	EntityBrowserTestCase.selectOrgFromAllLevelsEB("TST Entity01","TST Entity02", "", "");
	
	//Clicking on Entity browser tab
	WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
	
	//Getting the EVDC Names of both Parent and child entity Selected in an array		
	String sChildEVDCArray[] =EVDC_Overview_TestCase.getEVDCNameforEntityAndItsChild("TST Entity02");
	
		
	//Clicking on Entity Browser Link to navigate to Parent - .HostedSolutions 
	WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
	WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
	
	//Clicking on Entity Browser Link
	WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
	
	//Selecting Org from First Level and setting Rollup flag button "ON" and selecting org from Second Level Children
	EntityBrowserTestCase.selectOrgFromAllLevelsEB("TST Entity01","TST Entity02", "", "",1,true);
	
	//Clicking on Entity browser tab
	WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
	
	//Verifying EVDC names of array in the Home Page
	EVDC_Overview_TestCase.verifyEVDCnameForEntityAndItsChild(sChildEVDCArray);

	 //Verify PDF reports
    WebObjectUtil.verifyElementPresent(EVDC.getNav_EVDCViewPDFIcon());
    //Verify CSV reports
    WebObjectUtil.verifyElementPresent(EVDC.getNav_EVDCViewCSVIcon());

	
	//Verifying the EVDC View Table header
    EVDC_Overview_TestCase.verifyEVDCViewTableHeader();

	//Logout
	LoginTestCase_Old1.nav_Logout();
	
}

/*==============================================================
TestScript 		: verifyStaticImgForNoEVDC
Manual TestCase	: QAT-343-WCP_1303_TC_3.0_Rollup_EVDC in table format_No EVDCs
Description		: A Static image is displayed since these entities (parent and child) don't have any EVDCs
Author 			: Vivek Kumar
Creation Date 	: 01/13/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=107)
public void verifyStaticImgForNoEVDC()
{
	WebDriver driver=WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EBPanel);
	PageFactory.initElements(driver, EVDC);
	
	String sUserName,sPassword;
	
	FrameworkUtil.sTestCaseName ="verifyStaticImgForNoEVDC";
	FrameworkUtil.sManualTestCaseName="QAT-343-WCP_1303_TC_3.0_Rollup_EVDC in table format_No EVDCs";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	
	//Setting the Child entity for RootLevelCascadeOrg
	//AdminTestCase.verifyParentChildEntity("Level1OrgA", "RootLevelCascadeOrg");
	
	LoginTestCase_Old1.LoginAsIshannonUser();
	AdminTestCase.verifyOrg("RootLevelCascadeOrg", ".Hosted Solutions");
	AdminTestCase.verifyOrg("Level1OrgA", "RootLevelCascadeOrg");
	AdminTestCase.verifyOrg("Level2CascadeOrgA", "Level1OrgA");
	AdminTestCase.verifyOrg("Level3CascadeOrgA", "Level2CascadeOrgA");
	AdminTestCase.verifyOrg("Level4CascadeOrgA", "Level3CascadeOrgA");
	LoginTestCase_Old1.nav_Signout();
	
	//Login to application
	sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.USERID");
	sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.PASSWORD");
	
	//Login to navigator
	//LoginTestCase.nav_Login(sUserName, sPassword);
	LoginTestCase_Old1.LoginAsRoleAUser();

	//Clicking on Entity Browser Link
	WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
	
	
	//Selecting Organization from First Level and Second Level Children
	EntityBrowserTestCase.selectOrgFromAllLevelsEB("RootLevelCascadeOrg","Level1OrgA", "", "");
	
	//Clicking on Entity browser tab
	WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
	WebObjectUtil.explicitWait(5);
	//Getting the EVDC Names of both Parent and child entity Selected in an array		
	//String sChildEVDCArray[] =KefferTestCase_Arul.getEVDCNameforEntityAndItsChild("Level1OrgA");
	WebObjectUtil.verifyElementPresent(EVDC.getNav_EVDCImage());
		
	//Clicking on Entity Browser Link to navigate to Parent - .HostedSolutions 
	WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
	WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
	
	//Clicking on Entity Browser Link
	WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
	
	//Selecting Org from First Level and setting Rollup flag button "ON" and selecting org from Second Level Children
	selectOrgFromAllLevelsEB("RootLevelCascadeOrg","Level1OrgA", "", "",1,true);
	
	//Clicking on Entity browser tab
	WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
	WebObjectUtil.explicitWait(5);
	//Verifying EVDC names of array in the Home Page
	//KefferTestCase_Arul.verifyEVDCnameForEntityAndItsChild(sChildEVDCArray);
	
	//Need to add line to validate image
	//--------------------not seeing any image if it is roll on-------------------
	WebObjectUtil.verifyElementPresent(EVDC.getNav_EVDCImageAfterRollOn());

	//Logout
	LoginTestCase_Old1.nav_Logout();
	
	LoginTestCase_Old1.LoginAsIshannonUser();
	
	AdminTestCase.verifyOrg("Level1OrgA", ".Hosted Solutions");
	AdminTestCase.verifyOrg("Level2CascadeOrgA", ".Hosted Solutions");
	AdminTestCase.verifyOrg("Level3CascadeOrgA", ".Hosted Solutions");
	AdminTestCase.verifyOrg("Level4CascadeOrgA", ".Hosted Solutions");
	LoginTestCase_Old1.nav_Signout();
	
}



/*==============================================================
TestScript 		: verifyEVDCTableAndChildNotClickable
Manual TestCase	: Keffer_QAt-356-WCP_3726_TC_1.1_RollUp EVDC_User Permissions_Role-C
Description		: Scroll down to EVDC table and verify child EVDC name is not displayed as a clickable link and VCD link is not available for child EVDC
Author 			: Vivek Kumar
Creation Date 	: 01/13/2016
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=108)
public void verifyEVDCTableAndChildNotClickable()
{
	
	WebDriver driver =WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EBPanel);
	PageFactory.initElements(driver, EVDC);
	
	String sUserName,sPassword;
		
	
	FrameworkUtil.sTestCaseName ="verifyEVDCTableAndChildNotClickable";
	FrameworkUtil.sManualTestCaseName="Keffer_QAT-356-WCP_3726_TC_1.1_RollUp EVDC_User Permissions_Role-C";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	
	//Login to Navigator with ishannon user 
    LoginTestCase_Old1.LoginAsIshannonUser();
    
	//precondition for -setting child parent relationship to entities in the flow TST Entity01/TST Entity02/TST Entity03/TST Entity04
	AdminTestCase.setTstEntityParent();
	
	//Logout from Navigator
	LoginTestCase_Old1.nav_Signout();
	
	sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
	sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
	
	
	//Login to navigator
	//LoginTestCase.nav_Login(sUserName, sPassword);
	LoginTestCase_Old1.LoginAsARoleCUser();
	
	
	WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
	selectOrgFromAllLevelsEB("TST Entity01","", "","");
	//Verifying that Parent entity should have link and Child should not have link	
	EVDC_Overview_TestCase.verParentChildEntityLink(true,true);	
	
	 
    //Verify PDF reports
    WebObjectUtil.verifyElementPresent(EVDC.getNav_EVDCViewPDFIcon());
    //Verify CSV reports
    WebObjectUtil.verifyElementPresent(EVDC.getNav_EVDCViewCSVIcon());


	//Logout
	LoginTestCase_Old1.nav_Logout();
	
	
}
////........................................Vivek End .................................................////

////........................................QAA03 Start .................................................////

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
@Test(priority=111)
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
		LoginTestCase_Old1.LoginAsRoleAUser();
		
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
TestScript  	: verifyEBFooterRollupFlagStatusbySelectingOrgs
Manual TestCase	: [QAT-363] WCP_1294_TC_3.0_Toggle Roll up flag_UI issues
Description		: Verifying EB Footer Rollup flag status
Author 			: QAA03
Creation Date 	: 12/28/2015
Release Name    : Keffer
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=112)
public void verifyEBFooterRollupFlagStatusbySelectingOrgs()
{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,EBPanel);
		PageFactory.initElements(driver,Home);
					
		String sChildorg=null,sParentorg=null;

	try {
		FrameworkUtil.sTestCaseName = "verifyEBFooterRollupFlagStatusbySelectingOrgs";
		FrameworkUtil.sManualTestCaseName="[QAT-363] WCP_1294_TC_3.0_Toggle Roll up flag_UI issues";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		sChildorg = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.ABCTEST");
	    sParentorg = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.HOSTEDSOLUTIONS");
	    
		//Login to Navigator with ishannon user
		LoginTestCase_Old1.LoginAsIshannonUser();
		
		AdminTestCase.verifyOrg(sChildorg, sParentorg);
				
		//Logout from Navigator
		LoginTestCase_Old1.nav_Signout();
	    
	    //Login to navigator with Role-A user
	 	LoginTestCase_Old1.LoginAsRoleAUser();
	
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
		EntityBrowserTestCase.selectOrgFromAllLevelsEB(sChildorg,"", "", "");
		
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
@Test(priority=113)
public void verifyPageRefreshAfterClickingEBTab()
{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,EBPanel);
		PageFactory.initElements(driver,EVDC);
					
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
	 	LoginTestCase_Old1.LoginAsRoleAUser();
	 	
	    //Getting EVDC Name
		sEVDCName=EVDC.getNav_EVDCname().getText();
		//Clicking on Entity Browser Link
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		
		//Selecting Organization from First level children
		EntityBrowserTestCase.selectOrgFromAllLevelsEB(sFLCOrg,"", "", "");
		
		//Clicking on Entity Browser Close Button
		WebObjectUtil.clickElement(EBPanel.getNav_CloseButton());
		
		 //Getting EVDC Name
		sEVDCNameEB=EVDC.getNav_EVDCname().getText();
		
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
		
		WebObjectUtil.waitForElementPresent(EVDC.getNav_EVDCname());
		
		//Getting EVDC Name
		sEVDCNameEB=EVDC.getNav_EVDCname().getText();
		
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
@Test(priority=114)
public void verifyDataDisplaysForChildAndNoChildEntities()
{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,EBPanel);
		PageFactory.initElements(driver,Home);
		PageFactory.initElements(driver,EVDC);
					
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
	 	LoginTestCase_Old1.LoginAsRoleAUser();
		
			
		//Clicking on Entity Browser Link
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		
		
		//Selecting Organization from First Level and Second Level Children
		EntityBrowserTestCase.selectOrgFromAllLevelsEB(sFLCOrg,sSLCOrg, "", "");
		
		//Clicking on Entity browser tab
		WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
		
		WebObjectUtil.explicitWait(5);
		//Getting the EVDC Names of both Parent and child entity selected in an array		
		String sChildEVDCArray[] =EVDC_Overview_TestCase.getEVDCNameforEntityAndItsChild(sSLCOrg);
		
			
		//Clicking on Entity Browser Link to navigate to Parent - .HostedSolutions tab 
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		
		//Clicking on Entity Browser Link
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		
		//Selecting Org from First Level and setting Rollup flag button "ON" and selecting org from Second Level Children
		EntityBrowserTestCase.selectOrgFromAllLevelsEB(sFLCOrg,sSLCOrg, "", "",1,true);
		
		//Clicking on Entity browser tab
		WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
		WebObjectUtil.explicitWait(5);
		sChildEntities = getParentChildEntitiesNames();	
		
		//Verifying EVDC names of array in the Home Page
		EVDC_Overview_TestCase.verifyEVDCnameForEntityAndItsChild(sChildEVDCArray);
	
		 //Navigating to Tickets Page
		 TicketTestCase.navigateToTicketPage();
		
		 //Verifying Ticket Data Displayed for Selected Organization
		 TicketTestCase.verifyTicketDataPresentForOrg(sSLCOrg);
		 
		//Verifying Ticket Data Displayed for Selected Organization
		 TicketTestCase.verifyTicketDataPresentForOrg(sTLCOrg);
		 		 
		//KefferTestCase_NMR.verifyEntityUnderOrganizationColumn(sChildEntities);
		 
		//Clicking on Entity Browser Link
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		
		//Selecting Organization from First Level and Second Level Children
		EntityBrowserTestCase.selectOrgFromAllLevelsEB(sTLCOrg, sFRLCOrg, "", "");
		
		//Verifying Rollup button status
		EntityBrowserTestCase.verifyRollupButtonStatusForOrg();
		
		//Clicking on Entity browser tab
		WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
		WebObjectUtil.explicitWait(5);
		//Verifying Organization Name in the Ticket
		TicketTestCase.verifyOrgNameinTicket(sFRLCOrg);
		
		//Navigating to home page
		WebObjectUtil.MouseHover(Home.getNav_MonitoringTab());
		WebObjectUtil.clickElement(Home.getNav_SummaryViewMenuLink());
		
		//Verify EVDCSelector Name matches with Org Name
		EVDC_Overview_TestCase.verifyEVDCSelectorWithOrgName(sFRLCOrg);
		 
		//Logout from Navigator
		LoginTestCase_Old1.nav_Logout();
	
	   } catch (Exception e) {
		LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyDataDisplaysForChildAndNoChildEntities", "warn", "catch block:" +e.getMessage());
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
@Test(priority=115)
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
	 	LoginTestCase_Old1.LoginAsRoleAUser();
		
		//Clicking on Create Ticket link in ContactUs portlet
		WebObjectUtil.clickElement(Home.getnav_CreateTicketLink());
		WebObjectUtil.explicitWait(5);
		//Verifying Create Ticket Popup Window
		WebObjectUtil.verifyElementPresent(Home.getnav_CreateTicketPopupWindow());
		
		// Navigating to the ticket page
		TicketTestCase.navigateToTicketPage();
		
		//Getting open tickets count
		sOpenTktsCount =Ticket.getNav_OpenTickets().getText();
		iOpenTktsCount= Integer.parseInt(sOpenTktsCount);
		
		//Clicking on Create Ticket Link
		WebObjectUtil.clickElement(Ticket.getNav_CreateTicketLink());
		
		WebObjectUtil.explicitWait(5);
				
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
		WebObjectUtil.explicitWait(5);
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
		WebObjectUtil.explicitWait(5);
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
TestScript  	: verifyEVDCForParentAndChildbySettingRollupButton
Manual TestCase	: [QAT-358] WCP_1303_TC_3.1_Rollup_EVDC in table format_Parent entity has EVDCs_Child entities don't
Description		: Verifying EVDC for parent and child entities by setting rollup button
Author 			: QAA03
Creation Date 	: 01/14/2016
Release Name    : Keffer
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=116)
public void verifyEVDCForParentAndChildbySettingRollupButton()
{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,Admin);
		PageFactory.initElements(driver,EBPanel);
		PageFactory.initElements(driver,EVDC);
		
					
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
		AdminTestCase.verifyOrg(sChildorg4, sParentorg2);
		
		//Logout from Navigator
		LoginTestCase_Old1.nav_Signout();
		
		//Login to navigator with Role-A user
	 	LoginTestCase_Old1.LoginAsRoleAUser();
	 	
	 	//Clicking on Entity Browser Link
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		
		//Selecting Org from First Level and setting Rollup flag button "ON" 
		EntityBrowserTestCase.selectOrgFromAllLevelsEB(sParentorg1,"","","",1,true);
		
		//Clicking on Entity browser tab
		WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
		
		WebObjectUtil.explicitWait(5);
		
		//Getting the Entity Browser Name
		sEntityName=EBPanel.getNav_EntityBrowserLink().getText();
			
		CustomWebElementUtil.loadCustomElement(EVDC.getNav_EVDCViewHomeTable(),"table");
	 	
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
@Test(priority=117)
public void verifyCorrectFormatOfPopUpOfNOEVDC()
{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,EBPanel);
		PageFactory.initElements(driver,EVDC);
					
		String sFLCOrg=null,sParentOrg=null,sEntityName=null;
		boolean bOrgStatus;

	try {
		FrameworkUtil.sTestCaseName = "verifyCorrectFormatOfPopUpOfNOEVDC";
		FrameworkUtil.sManualTestCaseName="[QAT-368] WCP_3606_TC_1.0_Correct format for pop up message ";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		
		sFLCOrg = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.ABCTEST");
		sParentOrg =(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.HOSTEDSOLUTIONS");
	    
		
	    
		//Login to Navigator with ishannon user
		LoginTestCase_Old1.LoginAsIshannonUser();
		
		AdminTestCase.verifyOrg(sFLCOrg, sParentOrg);
				
		//Logout from Navigator
		LoginTestCase_Old1.nav_Signout();
		
	    //Login to navigator with Role-A user
	 	LoginTestCase_Old1.LoginAsRoleAUser();
	
	 	WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
		
		//Clicking on Entity Browser Link
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		
		//Selecting Organization from First Level Children
		EntityBrowserTestCase.selectOrgFromAllLevelsEB(sFLCOrg, "","","");
		
		//Clicking on Entity browser tab
		WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
		WebObjectUtil.explicitWait(5);
		//verifying No EVDC Popup Message
		EVDC_Overview_TestCase.verifyNOEVDCPopupMsg();
		
		//Clicking on "Yes" button of Popup Message
		WebObjectUtil.clickElement(EVDC.getNav_NoEVDCPopUpYesButton());
		WebObjectUtil.explicitWait(5);
		//Verifying EVDC Link turned to EVDC Image
		WebObjectUtil.verifyElementPresent(EVDC.getNav_EVDCImage());
	
		//Clicking on Entity Browser Link
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		
		//Clicking on Entity Browser Link(Back to Entity)
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		WebObjectUtil.explicitWait(5);
		//Getting Entity Name
		sEntityName = EBPanel.getNav_EntityBrowserLink().getText();
		
		//Checking the Organization to which page refreshed
        bOrgStatus = sEntityName.equalsIgnoreCase(sParentOrg);
		
		FrameworkUtil.updateCustomResultBasedOnStatus(bOrgStatus, "Home Page refreshed with Data"+sEntityName);
		
		//Navigating to EVDC Overview Page
		WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
		
		//Clicking on Entity Browser Link
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		
		//Selecting Organization from First Level Children
		EntityBrowserTestCase.selectOrgFromAllLevelsEB(sFLCOrg, "","","");
		
		//Clicking on Entity browser tab
		WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
		WebObjectUtil.explicitWait(5);
		//Clicking on "No" button of Popup Message
		WebObjectUtil.clickElement(EVDC.getNav_NoEVDCPopUpNoButton());
		
		//Verifying whether page is remained in EVDC Overview Page
		WebObjectUtil.verifyElementPresent(EVDC.getNav_EVDCOverviewVirtualMachine());
		
		//Logout from Navigator
		LoginTestCase_Old1.nav_Logout();
	
	   } catch (Exception e) {
		LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyCorrectFormatOfPopUpOfNOEVDC", "warn", "catch block:" +e.getMessage());
	}
}

////........................................QAA03 End .................................................////

////........................................QAA04 Start .................................................////

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
@Test(priority=141)
 public void verifyOrganizationColumnUnderEntity02Org() {
	 String sTestEntity1,sTestEntity2,sTestEntity3;
	 WebDriver driver = WebDriverUtil.getDriver();
	 PageFactory.initElements(driver, EBPanel);
	
	 try { 
	 FrameworkUtil.sTestCaseName="verifyOrganizationColumnUnderEntity02Org";
	 FrameworkUtil.sManualTestCaseName="(QAT-382)Keffer - Verify the tickets displayed are for tst entity 02 and tst entity03 org";
	 FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
      
	 //Login to Navigator with ishannon user 
	 LoginTestCase_Old1.LoginAsIshannonUser();
	    
	 //precondition for -setting child parent relationship to entities in the flow TST Entity01/TST Entity02/TST Entity03/TST Entity04
	 AdminTestCase.setTstEntityParent();
		
	 //Logout from Navigator
	 LoginTestCase_Old1.nav_Signout();
	 
	 //Login to navigator with rola-a user
	 LoginTestCase_Old1.LoginAsRoleAUser();
	 
	 sTestEntity1 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
	 sTestEntity2 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY02");
	 sTestEntity3 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY03");

	
	 WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
	 // selecting the org from entity browser 
	 EntityBrowserTestCase.selectOrgFromAllLevelsEB(sTestEntity1,sTestEntity2,"","");
	 WebObjectUtil.clickElement(EBPanel.getNav_EBPanelRollUpButton());
	 WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
	 WebObjectUtil.explicitWait(5);
	 // Navigating to the ticket page
	 TicketTestCase.navigateToTicketPage();
	 // verifying the Organization column entity 
	 String sOrgNames ="TST Entity02,TST Entity03";
	 TicketTestCase.verifyEntityUnderOrganizationColumn(sOrgNames);
	 
	 
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
@Test(priority=142)
public  void verifyOrganizationColumnUnderEntity01Org() {
	String sTestEntity1,sTestEntity2,sTestEntity3;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EBPanel);
	 
	try {
	FrameworkUtil.sTestCaseName ="verifyOrganizationColumnUnderEntity01Org";
	FrameworkUtil.sManualTestCaseName = "(QAT-378)Keffer - Verify the tickets displayed are for tst entity 01 and tst entity02";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	 
	//Login to Navigator with ishannon user 
    LoginTestCase_Old1.LoginAsIshannonUser();
    
	//precondition for -setting child parent relationship to entities in the flow TST Entity01/TST Entity02/TST Entity03/TST Entity04
	AdminTestCase.setTstEntityParent();
	
	//Logout from Navigator
	LoginTestCase_Old1.nav_Signout();
	 
	 // Login to navigator with rola-a user
	 LoginTestCase_Old1.LoginAsRoleAUser();
	 
	 sTestEntity1 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
	 sTestEntity2 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY02");
	 sTestEntity3 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY03");

	
	
	 WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
	 // selecting the org from entity browser 
	 EntityBrowserTestCase.selectOrgFromAllLevelsEB(sTestEntity1,"","","");
	 WebObjectUtil.clickElement(EBPanel.getNav_EBPanelRollUpButton());
	 WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
	 WebObjectUtil.explicitWait(5);
	 // Navigating to the ticket page
	 TicketTestCase.navigateToTicketPage();
	 // verifying the Organization column entity 
	 String sOrgNames ="TST Entity01,TST Entity02";
	 TicketTestCase.verifyEntityUnderOrganizationColumn(sOrgNames);
	 
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
@Test(priority=123)
public void verifyOpenWorkingPendingResolvedTicketsAfterRollOn() {
	     String sTestEntity1,sTestEntity2,sTestEntity3;
	     boolean bPDFIcon,bCSVIcon;
	     WebDriver driver = WebDriverUtil.getDriver();
		 PageFactory.initElements(driver, EBPanel);
		 PageFactory.initElements(driver, Ticket);
		
		 try { 
		 FrameworkUtil.sTestCaseName="verifyOpenWorkingPendingResolvedTicketsAfterRollOn";
		 FrameworkUtil.sManualTestCaseName="(QAT-376),(QAT-375),(QAT-374) and (QAT-351) Keffer - Verify the open working pending outstanding ticket counts in outstanding, closed less then 6 months state and verify the pdf and csv icons";
		 FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		  
		 //Login to Navigator with ishannon user 
		 LoginTestCase_Old1.LoginAsIshannonUser();
		    
		 //precondition for-setting child parent relationship to entities in the flow TST Entity01/TST Entity02/TST Entity03/TST Entity04
		 AdminTestCase.setTstEntityParent();
			
		 //Logout from Navigator
		 LoginTestCase_Old1.nav_Signout();
		 
		 // Login to navigator with rola-a user
		 LoginTestCase_Old1.LoginAsRoleAUser();
		 
		 sTestEntity1 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
		 sTestEntity2 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY02");
		 sTestEntity3 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY03");

		
		 WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		 // selecting the org from entity browser 
		 EntityBrowserTestCase.selectOrgFromAllLevelsEB(sTestEntity1,sTestEntity2,"","");
		 WebObjectUtil.clickElement(EBPanel.getNav_EBPanelRollUpButton());
		 WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
		 WebObjectUtil.explicitWait(5);
		 // Navigating to the ticket page
		 TicketTestCase.navigateToTicketPage();
		 // verifying the Organization column entity 
		 String sOrgNames ="TST Entity02,TST Entity03";
		 TicketTestCase.verifyEntityUnderOrganizationColumn(sOrgNames);
		 
		 // verifying the pdf and csv icons 
			bPDFIcon = Ticket.getNav_TicketsPdfIcon().getAttribute("src").contains("PDF");
			FrameworkUtil.updateCustomResultBasedOnStatus(bPDFIcon, "verifying the PDF icon");
			
			bCSVIcon = Ticket.getNav_TicketsCsvIcon().getAttribute("src").contains("CSV");
			FrameworkUtil.updateCustomResultBasedOnStatus(bCSVIcon, "verifying the CSV icon");
		
 
		 // verifying the outstanding state open,pending,working,resolved tickets counts 
			TicketTestCase.verifyTicketCountAfterRollOn(sTestEntity1+","+sTestEntity2,Ticket.getNav_Outstanding());
 		 
			 // verifying the closed less then 6 months state open,pending,working,resolved tickets counts 
			TicketTestCase.verifyTicketCountAfterRollOn(sTestEntity1+","+sTestEntity2,Ticket.getNav_ClosedLess());
			
			 // verifying the closed more then 6 months state open,pending,working,resolved tickets counts 
			TicketTestCase.verifyTicketCountAfterRollOn(sTestEntity1+","+sTestEntity2,Ticket.getNav_ClosedMore());
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
@Test(priority=124)
public void verifyPDFandCSVIconsForClosedlessThenState() {
	    String sTestEntity1,sTestEntity2,sTestEntity3;
		 WebDriver driver = WebDriverUtil.getDriver();
		 PageFactory.initElements(driver, EBPanel);
		 PageFactory.initElements(driver, Ticket);
		
		 boolean bPDFIcon,bCSVIcon;
		 try { 
		 FrameworkUtil.sTestCaseName="verifyPDFandCSVIconsForClosedlessThenState";
		 FrameworkUtil.sManualTestCaseName="(QAT-373)Keffer - Verify the pdf and csv icons in closed less then 6 months state";
		 FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		  
		//Login to Navigator with ishannon user 
		  LoginTestCase_Old1.LoginAsIshannonUser();
		    
		//precondition for - setting child parent relationship to entities in the flow TST Entity01/TST Entity02/TST Entity03/TST Entity04
		AdminTestCase.setTstEntityParent();
			
		//Logout from Navigator
		LoginTestCase_Old1.nav_Signout();
		 
		 // Login to navigator with rola-a user
		 LoginTestCase_Old1.LoginAsRoleAUser();
		
		 sTestEntity1 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
		 sTestEntity2 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY02");
		 sTestEntity3 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY03");

		
		 WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		 
		 // selecting the org from entity browser 
		 EntityBrowserTestCase.selectOrgFromAllLevelsEB(sTestEntity1,sTestEntity2,"","");
		 WebObjectUtil.clickElement(EBPanel.getNav_EBPanelRollUpButton());
		 WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
		 WebObjectUtil.explicitWait(5);
		 // Navigating to the ticket page
		 TicketTestCase.navigateToTicketPage();
		 
		 // verifying the Organization column entity 
		 String sOrgNames ="TST Entity02,TST Entity03";
		 TicketTestCase.verifyEntityUnderOrganizationColumn(sOrgNames);
		 
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
@Test(priority=125)
public void navCreateTicketUnderTestEntity03() {
	String sOrgNames,sTestEntity1,sTestEntity2,sTestEntity3;
	WebElement wExpander;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EBPanel);
	PageFactory.initElements(driver, Ticket);
	try {
	FrameworkUtil.sTestCaseName="navCreateTicketUnderTestEntity03";
	FrameworkUtil.sManualTestCaseName="(QAT-364) Keffer - Create a ticket under tst Entity 03 org";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);

	//Login to Navigator with ishannon user 
    LoginTestCase_Old1.LoginAsIshannonUser();
    
	//precondition for -setting child parent relationship to entities in the flow TST Entity01/TST Entity02/TST Entity03/TST Entity04
	AdminTestCase.setTstEntityParent();
	
	//Logout from Navigator
	LoginTestCase_Old1.nav_Signout();
	 
	 // Login to navigator with rola-a user
	 LoginTestCase_Old1.LoginAsRoleAUser();
	 
	 sTestEntity1 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
	 sTestEntity2 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY02");
	 sTestEntity3 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY03");

	 WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
	  
	 // selecting the org from entity browser 
	 EntityBrowserTestCase.selectOrgFromAllLevelsEB(sTestEntity1,"","","", 1, true);
	 EntityBrowserTestCase.selectOrgFromAllLevelsEB("", sTestEntity2, sTestEntity3,"", 3, false);
	 /*EntityBrowserTestCase.selectOrgFromAllLevelsEB(sTestEntity1,null, null, null);
	 WebObjectUtil.clickElement(Entity.getNav_EBPanelRollUpButton());
	 WebObjectUtil.explicitWait(3);
	 EntityBrowserTestCase.selectOrgFromAllLevelsEB(null,sTestEntity2, sTestEntity3, null);
	 WebObjectUtil.clickElement(Entity.getNav_EBPanelRollUpButton());*/
	 WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
	 WebObjectUtil.explicitWait(10);
     // Updated below line by QAA03 on 07/12/2016
	 TicketTestCase.navigateToTicketPage();
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
@Test(priority=126)
public void verifyPDFandCSVIconsForClosedmoreThenState() {
	     String sTestEntity1,sTestEntity2,sTestEntity3;
		 WebDriver driver = WebDriverUtil.getDriver();
		 PageFactory.initElements(driver, EBPanel);
		 PageFactory.initElements(driver, Ticket);
		 
		 boolean bPDFIcon,bCSVIcon;
		 try { 
		 FrameworkUtil.sTestCaseName="verifyPDFandCSVIconsForClosedmoreThenState";
		 FrameworkUtil.sManualTestCaseName="(QAT-361)Keffer - Verify the pdf and csv icons in closed more then 6 months state";
		 FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		  
		//Login to Navigator with ishannon user 
		 LoginTestCase_Old1.LoginAsIshannonUser();
		    
		//precondition for-setting child parent relationship to entities in the flow TST Entity01/TST Entity02/TST Entity03/TST Entity04
		AdminTestCase.setTstEntityParent();
			
		//Logout from Navigator
		LoginTestCase_Old1.nav_Signout();
		 
		 // Login to navigator with rola-a user
		 LoginTestCase_Old1.LoginAsRoleAUser();
		 
		 sTestEntity1 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
		 sTestEntity2 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY02");
		 sTestEntity3 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY03");

		
		 WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		 
		 // selecting the org from entity browser 
		 EntityBrowserTestCase.selectOrgFromAllLevelsEB(sTestEntity1,sTestEntity2,"","");
		 WebObjectUtil.clickElement(EBPanel.getNav_EBPanelRollUpButton());
		 WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
		 WebObjectUtil.explicitWait(5);
		 // Navigating to the ticket page
		 TicketTestCase.navigateToTicketPage();
		 
		 // verifying the Organization column entity 
		 String sOrgNames ="TST Entity02,TST Entity03";
		 TicketTestCase.verifyEntityUnderOrganizationColumn(sOrgNames);
		 
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
@Test(priority=127)
public void navVerifyTstEntity02Count() {
	String sOrgNames,sTestEntity1,sTestEntity2,sTestEntity3;
	int iOpenTktCnt,iWorkingTktCnt,iPendingTktCnt,iResolvedTktCnt,iExpectedOpenTktCnt,iExpectedWorkingTktCnt,iExpectedPendingTktCnt,iExpectedResolvedTktCnt;
	boolean bOpenTktCnt,bWorkingTktCnt,bPendingTktCnt,bResolvedTktCnt;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver,EBPanel);
	PageFactory.initElements(driver, Ticket);
	try {
	FrameworkUtil.sTestCaseName="navVerifyTstEntity02Count";
	FrameworkUtil.sManualTestCaseName="(QAT-354) keffer - Verify the tickets display are for 'tst entity02' and counts at top panel";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);

	//Login to Navigator with ishannon user 
    LoginTestCase_Old1.LoginAsIshannonUser();
    
	//precondition for-setting child parent relationship to entities in the flow TST Entity01/TST Entity02/TST Entity03/TST Entity04
	AdminTestCase.setTstEntityParent();
	
	//Logout from Navigator
	LoginTestCase_Old1.nav_Signout();
	
	// Login to navigator with rola-a user
	 LoginTestCase_Old1.LoginAsRoleAUser();
	 
	 sTestEntity1 = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
	 sTestEntity2 = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY02");
	 sTestEntity3 = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY03");

	
	
	 // Navigating to the ticket page
	 TicketTestCase.navigateToTicketPage();
	 
	 WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
	// selecting the org from entity browser 
	 EntityBrowserTestCase.selectOrgFromAllLevelsEB(sTestEntity1,sTestEntity2,"","");
	 WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
	 WebObjectUtil.explicitWait(5);
	 
	 iOpenTktCnt = TicketTestCase.getTicketCountFromHeader(Ticket.getNav_OpenTicketNumbers());
     iWorkingTktCnt = TicketTestCase.getTicketCountFromHeader(Ticket.getNav_WorkingTicketNumbers());
     iPendingTktCnt = TicketTestCase.getTicketCountFromHeader(Ticket.getNav_PendingTicketNumbers());
     iResolvedTktCnt = TicketTestCase.getTicketCountFromHeader(Ticket.getNav_ResolvedTicketNumbers());
	 
	 
	 WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
	 // selecting the org from entity browser 
	// EntityBrowserTestCase.selectOrgFromAllLevelsEB(sTestEntity1,null, null, null);
	 WebObjectUtil.clickElement(EBPanel.getNav_EBPanelRollUpButton());
	 WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
	 WebObjectUtil.explicitWait(5);
	
	 // verifying the Organization column entity 
	 sOrgNames ="TST Entity02,TST Entity03";
	 TicketTestCase.verifyEntityUnderOrganizationColumn(sOrgNames);
	 
	 WebObjectUtil.clickElement(Ticket.getNav_TicketOrgWebListArrow());
	 WebObjectUtil.selectCustomWebList(Ticket.getNav_TicketOrgWebListDropDown(), sTestEntity2);
	
	 TicketTestCase.verifyEntityUnderOrganizationColumn(sTestEntity2);
	 
	
	
	 // verifying the closed outstanding state open,pending,working,resolved tickets counts 
	//	KefferTestCase_Arul.verifyTicketCountAfterRollOn(sTestEntity2,Ticket.getNav_Outstanding());
	
		
		 WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		 WebObjectUtil.clickElement(EBPanel.getNav_EBPanelRollUpButton());
		 WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
		 WebObjectUtil.explicitWait(5);
		
		 
		iExpectedOpenTktCnt = TicketTestCase.getTicketCountFromHeader(Ticket.getNav_OpenTicketNumbers());
        iExpectedWorkingTktCnt = TicketTestCase.getTicketCountFromHeader(Ticket.getNav_WorkingTicketNumbers());
        iExpectedPendingTktCnt = TicketTestCase.getTicketCountFromHeader(Ticket.getNav_PendingTicketNumbers());
        iExpectedResolvedTktCnt = TicketTestCase.getTicketCountFromHeader(Ticket.getNav_ResolvedTicketNumbers());
	
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
@Test(priority=128) 
public void VerifyOrganizationColumnforTstEntity01(){
	String sOrgname,sTestEntity1,sTestEntity2,sTestEntity3;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EBPanel);
	try {
	FrameworkUtil.sTestCaseName="VerifyOrganizationColumnforTstEntity01";
	FrameworkUtil.sManualTestCaseName="(QAT-339) Keffer-Verify the tickets displayed are for tst entity 01 and tst entity02 with a new column added Organization";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);

	//Login to Navigator with ishannon user 
    LoginTestCase_Old1.LoginAsIshannonUser();
    
	//precondition for-setting child parent relationship to entities in the flow TST Entity01/TST Entity02/TST Entity03/TST Entity04
	AdminTestCase.setTstEntityParent();
	
	//Logout from Navigator
	LoginTestCase_Old1.nav_Signout();
	 
	 // loging to the navigator
	 LoginTestCase_Old1.LoginAsRoleAUser();
	 
	 sTestEntity1 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
	 sTestEntity2 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY02");
	 sTestEntity3 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY03");

	 
	 // selecting the org from the entity browser
	 WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
	 EntityBrowserTestCase.selectOrgFromAllLevelsEB(sTestEntity1,"","","", 1, true);
	 WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
	 WebObjectUtil.explicitWait(5);
	 // navigating to the ticket page
	 TicketTestCase.navigateToTicketPage();
	 
	 // verifying the entity under organization column
	  sOrgname ="TST Entity01,TST Entity02";
	  TicketTestCase.verifyEntityUnderOrganizationColumn(sOrgname);
	
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
@Test(priority=129)
public void navVerifyvCPUvRAMandStorageColumnsValues() {
	String sTestEntity1,sCPUCount,sRAMCount,sAllocatedData,sAllocatedGB;
	WebElement wEVDCName;
	String[] sActualAllocatedData,sExpectedAllocatedData;
	Float fAllocatedData,fExpectedAllocatedData;
	boolean bAllocatedData;
	
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EBPanel);
	PageFactory.initElements(driver, EVDC);
	try {
		FrameworkUtil.sTestCaseName="navVerifyvCPUvRAMandStorageColumnsValues";
		FrameworkUtil.sManualTestCaseName="(QAT-346) On the home page in the EVDC block, verify the values displayed under vCPUs, vRAM, and Storage columns";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		//Login to Navigator with ishannon user 
	    LoginTestCase_Old1.LoginAsIshannonUser();
	    
		//precondition for -setting child parent relationship to entities in the flow TST Entity01/TST Entity02/TST Entity03/TST Entity04
		AdminTestCase.setTstEntityParent();
		
		//Logout from Navigator
		LoginTestCase_Old1.nav_Signout();
		 
		 //Login to the navigator
		 LoginTestCase_Old1.LoginAsRoleAUser();
		 
		 sTestEntity1 = (String) FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
		 
		 // clicking on entity browser link 
		 WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		 EntityBrowserTestCase.selectOrgFromAllLevelsEB(sTestEntity1,"","","", 1, true);
		 WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
		 WebObjectUtil.explicitWait(10);
		
		//Loading the EVDC web table
		 WebObjectUtil.scrollToElement(EVDC.getNav_EVDCViewHomeTable());
		 CustomWebElementUtil.loadCustomElement(EVDC.getNav_EVDCViewHomeTable(), "table");
		 sCPUCount = CustomWebElementUtil.getCellData(1,5);
		 sRAMCount = CustomWebElementUtil.getCellData(1,6);
		 sAllocatedData = CustomWebElementUtil.getCellData(1,7);
			
		//Getting the integer value from RAM count
			sRAMCount=sRAMCount.replace("(GB)", "").trim();
			
			
			sActualAllocatedData = sAllocatedData.split(" ");
			fAllocatedData = Float.valueOf(sActualAllocatedData[0]);
		 
			 
		 //wEVDCName = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.EVDCVIEWTABLE.EVDC", "PARAMETER_ROWNUMBER", 1+"");
			wEVDCName = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.EVDCVIEWTABLE.EVDC", "PARAMETER_ROWNUMBER", 2+"");	
		 WebObjectUtil.clickElement(wEVDCName);
		 
		 sAllocatedGB =EVDC.getNav_StoragePortlet_AllocatedData().getText();
		 sExpectedAllocatedData = sAllocatedGB.split(" ");
		 fExpectedAllocatedData = Float.valueOf(sExpectedAllocatedData[0]);
		
		 // validating the allocated data 
		 bAllocatedData =fAllocatedData.equals(fExpectedAllocatedData);
		 FrameworkUtil.updateCustomResultBasedOnStatus(bAllocatedData, "Data is matched "+sAllocatedData);
		 
		 // clicking on virtual machine link
		 WebObjectUtil.clickElement(EVDC.getNav_EVDCOverviewVirtualMachine());
		 
		 WebObjectUtil.explicitWait(10);
		 
		 // verifying the vCPU and vRAM count
		 EVDC_VM_TestCase.navValidateCPUnRAMCnt("Running",sCPUCount,sRAMCount);
		 
			
		 // log out 
		 LoginTestCase_Old1.nav_Logout();
		 
	}catch(Exception e){
		LoggerUtil.log_type_error("issue with navVerifyvCPUvRAMandStorageColumnsValues test case");
		LoggerUtil.log_type_error("exception occured " +FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exceptio occured", "fail", " "+e.getMessage());
	}
}


////........................................QAA04 End .................................................////
   //////.....................................Arul Start............................................///////

/*==============================================================
TestScript  	: verifyEVDCNameSearchAfterRollOnTest
Manual TestCase	: [QAT-349] WCP_1303_TC_1.6_RollUp_EVDCs in table format_Search Box 	
Description		: verify user is able to search EVDC name by typing anything. 
Author 			: Arularasu
Creation Date 	: 01/13/2016
Release Name    : Keffer
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=131)
public void verifyEVDCNameSearchAfterRollOnTest(){
	
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver,EBPanel);
	PageFactory.initElements(driver, EVDC);
    
try {
	FrameworkUtil.sTestCaseName = "verifyEVDCNameSearchAfterRollOnTest";
	FrameworkUtil.sManualTestCaseName="[QAT-349]verify user is able to search EVDC name by typing anything.";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	
	 // Login to navigator with rola-a user
	 LoginTestCase_Old1.LoginAsRoleAUser();	 
	 
	 WebObjectUtil.explicitWait(2);
    // HomeTestCase.nav_WindStreamToTierPointHomePopup();
     
	WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
	EntityBrowserTestCase.setRollOnOffEBPanel(true);
	WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
	WebObjectUtil.explicitWait(5);
	EVDC_Overview_TestCase.VerifyEVDCNameSearchAfterRollOn("ll");
	EVDC.getNav_EVDCViewSearchEdit().clear();
	WebObjectUtil.explicitWait(5);
	EVDC_Overview_TestCase.VerifyEVDCNameSearchAfterRollOn("orc");
		
    //Logout from Navigator
	LoginTestCase_Old1.nav_Logout();
	
  } catch (Exception e) {
		LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyEVDCNameSearchAfterRollOn", "fail", "catch block:" +e.getMessage());
	}
	
}

///////.......................................Arul End...........................................//////

//// ________________________________________ Matheson test cases _____________________________________ ////

/*==============================================================
TestScript  	: verifyCoopersHawkOrgName
Manual TestCase	: QAT-674-WCP_4570_TC_1.0_Tickets_Org name shows \_roll up on_select from organization drop down
Description		: verify the org name doesn't show "\" (when an org has 's in the name - ex. cooper's hawk)
Author 			: Priyanka R
Creation Date 	: 04/04/2016
Pre-Requisites	: 
Release         : Matheson
Revision History: Script updated by QAA03 by changing the elements on 07/15/2015
================================================================*/
		@Test(priority=201)
		public void verifyCoopersHawkOrgName()
		{
			int iRow=1;
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, Ticket);
			PageFactory.initElements(driver, EBPanel);
		
			try{
				boolean bRollOn = true;
				String sItem="/",sText=null;;
			    String sOrgName= (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.COOPER.COOPERSHAWK");
			    FrameworkUtil.sTestCaseName = "verifyCoopersHawkOrgName";
				FrameworkUtil.sManualTestCaseName="QAT-674-WCP_4570_TC_1.0_Tickets_Org name shows roll up on_select from organization drop down";
		       	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		        
		       	
		       	//Login to Navigator Portlet
				LoginTestCase_Old1.LoginAsRoleAUser();
				//WebObjectUtil.explicitWait(5);
				WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
				//WebObjectUtil.clickElement(EBPanel.getNav_EBPanelHostedSolFooter());
				//WebObjectUtil.explicitWait(10);
                EntityBrowserTestCase.setRollOnOffEBPanel(bRollOn);
				WebObjectUtil.explicitWait(5);
				//WebObjectUtil.clickElement(EBPanel.getNav_EBPanelHostedSolFooter());
				WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
				//WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
				//WebObjectUtil.explicitWait(8);
				TicketTestCase.navigateToTicketPage();
				WebObjectUtil.explicitWait(5);
				TicketTestCase.verifyTicketDataPresentForOrg(sOrgName);
				
				//String sText= EBPanel.getNav_TicketsOrgDropdownlist().getText();
				
				 
				 CustomWebElementUtil.loadCustomElement(Ticket.getNav_TicketsWebTable(), "table");
				 sText= CustomWebElementUtil.getCellData(1, 4);
				
				WebObjectUtil.explicitWait(3);
				if(!(sText.contains(sItem)))
				{
				LoggerUtil.log_type_info(sItem +" is not present");
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName ,sItem , "pass","Verified");
				}
				else
				{
				LoggerUtil.log_type_error(sItem +" is present");
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName ,sItem , "fail"," not Verified");
				}
				//Logout from Navigator
				LoginTestCase_Old1.nav_Logout();
				
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navContactUsCreateticket", "warn", "catch block:" +e.getMessage());  
			}
		}




/// _________________________________________ Completed matheson test cases ___________________________ ////
          /////__________________ Keffer TestCases Method _______________________________________/////

/*====================================================================================================
Method Name 	: selectOrgFromAllLevelsEB
Description		: Selecting Organisations from all levels in EB and setting Rollup flag status for any level children by passing 1 to 4
Author 			: QAA03
Creation Date 	: 12/28/2015
Pre-Requisites	: pass "iLevelChildren" as 1 for setting Rollup flag status for firstlevel children and 2 for second level and so on
Revision History:
=====================================================================================================*/


public static boolean selectOrgFromAllLevelsEB(String FLCOrg,String SLCOrg,String TLCOrg,String FRLCOrg,int iLevelChildren,boolean bRollStatus)
{
	boolean bEBOrgOrder = true;
    WebElement wFLCOrgItemtoSelect,wSLCOrgItemtoSelect,wTLCOrgItemtoSelect,wFRLCOrgItemtoSelect;
    PageFactory.initElements(WebDriverUtil.getDriver(), EBPanel);
     try {
      
     	//selecting organization from first level children in EB and setting Rollup flag status
			if(FLCOrg.length()>0 && FLCOrg!=null)
          {
			       WebObjectUtil.SetValueEdit(EBPanel.getNav_firstLevelChildrenEditBox(),FLCOrg);
			     
			       wFLCOrgItemtoSelect = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EBPANEL.FIRSTLEVELORG.ITEM.SELECT", "PARAMETER_SELECTEDITEM", FLCOrg);
			      
			       if(wFLCOrgItemtoSelect != null)
			       {
				       wFLCOrgItemtoSelect.click();
			       
				       if(iLevelChildren==1)
			           {					    	   
			    	         setRollOnOffEBPanel(bRollStatus); 
			           }
				  
			       }
			         
			       else
			       {
			    	   FrameworkUtil.updateCustomResultBasedOnStatus(false, "Organization not found in First Level Children:"+FLCOrg);
			    	   bEBOrgOrder = false;
			       }
			      
         }
		
			//selecting organization from second level children in EB and setting Rollup flag status
			if(SLCOrg.length()>0 && SLCOrg!=null)
          {
			      WebObjectUtil.SetValueEdit(EBPanel.getNav_secondLevelChildrenEditBox(),SLCOrg);
			     
			      wSLCOrgItemtoSelect = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EBPANEL.SECONDLEVELORG.ITEM.SELECT", "PARAMETER_SELECTEDITEM", SLCOrg);
			      
			      if(wSLCOrgItemtoSelect != null)
			       {
				       wSLCOrgItemtoSelect.click();
				       if(iLevelChildren==2)
				       {
				    	   setRollOnOffEBPanel(bRollStatus); 
				       }
			       }
			       else
			       {
			    	   FrameworkUtil.updateCustomResultBasedOnStatus(false, "Organization not found in Second Level Children:"+SLCOrg);
			    	   bEBOrgOrder = false;
			       }
			      
          }
			 
		      
			//selecting organization from third level children in EB and setting Rollup flag status
			if(TLCOrg.length()>0 && TLCOrg!=null)
         {
			      WebObjectUtil.SetValueEdit(EBPanel.getNav_thirdLevelChildrenEditBox(),TLCOrg);
			      
			      wTLCOrgItemtoSelect = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EBPANEL.THIRDLEVELORG.ITEM.SELECT", "PARAMETER_SELECTEDITEM", TLCOrg);
			      
			      if( wTLCOrgItemtoSelect != null)
			       {
				       wTLCOrgItemtoSelect.click();
				       if(iLevelChildren==3)
				       {
				    	   setRollOnOffEBPanel(bRollStatus); 
				       }
			       }
			       else
			       {
			    	   FrameworkUtil.updateCustomResultBasedOnStatus(false, "Organization not found in Third Level Children:"+TLCOrg);
			    	   bEBOrgOrder = false;
			       }
			      
          }
			
			//selecting organization from fourth level children in EB and setting Rollup flag status
			if(FRLCOrg.length()>0 && FRLCOrg!=null)
          {
			      WebObjectUtil.SetValueEdit(EBPanel.getNav_fourthLevelChildrenEditBox(),FRLCOrg);
			    
			      wFRLCOrgItemtoSelect = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EBPANEL.FOURTHLEVELORG.ITEM.SELECT", "PARAMETER_SELECTEDITEM", FRLCOrg);
			      
			      if( wFRLCOrgItemtoSelect != null)
			       {
			    	   wFRLCOrgItemtoSelect.click();
			    	   if(iLevelChildren==4)
				       {
			    		   setRollOnOffEBPanel(bRollStatus); 
				       }
			       }
          
			       else
			       {
			    	   FrameworkUtil.updateCustomResultBasedOnStatus(false, "Organization not found in Fourth Level Children:"+FRLCOrg);
			    	   bEBOrgOrder = false;
			       }
          }
     }      
         
		
		 catch (Exception e) {
			
			LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "selectOrgFromAllLevelsEB", "warn", "catch block:Could NOT access webelement" +e.getMessage());	
			
		}
          return bEBOrgOrder;
}


/*====================================================================================================
Method Name 	: verifyRollupButtonStatusForOrg
Description		: Verifying Rollup Status for Organizations with children or without children
Author 			: QAA03
Creation Date 	: 12/23/2015
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static String verifyRollupButtonStatusForOrg()
{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,EBPanel);
		String sOrgName=null,sOrgRollup=null,sOrgRollupStatus=null;
		
			
 try {
	    sOrgName =EBPanel.getNav_OrgNameTitleLink().getText();
	    sOrgRollup =EBPanel.getNav_EBPanelRollUpButton().getAttribute("class");
	if(sOrgRollup.contains("disabled"))
		{
		 sOrgRollupStatus = "DISABLED";
		 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "RollupStatus", "pass", "Rollup Status "+sOrgRollupStatus+" for organization not having children"+sOrgName);
		}
		else if(sOrgRollup.contains("rollon"))
		{
	      sOrgRollupStatus ="ON";
	      FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "RollupStatus", "pass", "Rollup Status enabled and "+sOrgRollupStatus+" for organization having children"+sOrgName);
	    }
	   else if(sOrgRollup.contains("default"))
	    {
		   sOrgRollupStatus ="OFF";
		   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "RollupStatus", "pass", "Rollup Status enabled and "+sOrgRollupStatus+" for organization having children"+sOrgName);
	    }
	   else
	   {
		   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "RollupStatus", "fail", "Rollup Status "+sOrgRollupStatus+" for organization"+sOrgName);
	   }
		

	 } catch (Exception e) {
		// TODO Auto-generated catch block
		LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyRollupButtonStatusForOrg", "warn", "catch block:" +e.getMessage());  
	}
 return sOrgRollupStatus; 
	
}
/*====================================================================================================
Method Name 	: verifyEBFooterRollupFlagStatusForOrg
Description		: Verifying EB Footer Rollup Status for Organization selected in EB
Author 			: QAA03
Creation Date 	: 01/04/2016
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static String verifyEBFooterRollupFlagStatusForOrg()
{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,EBPanel);
		String sOrgRollup=null,sOrgEBFooterRollupStatus=null;
		
			
 try {
	    
	    sOrgRollup =EBPanel.getNav_EBPanelFooterRollUpButton().getAttribute("class");
	   if(WebObjectUtil.isElementPresent(EBPanel.getNav_EBPanelFooterRollUpButton()))
	   {
		   if(sOrgRollup.contains("rollon"))
		{
	      sOrgEBFooterRollupStatus ="ON";
	      FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "EBFooterRollupStatus", "pass", "EB Footer Rollup flag Status is "+sOrgEBFooterRollupStatus);
	    }
		   else if(sOrgRollup.contains("default"))
	    {
		   sOrgEBFooterRollupStatus ="OFF";
		   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "EBFooterRollupStatus", "pass", "EB Footer Rollup flag Status is "+sOrgEBFooterRollupStatus);
	    }
	   }
	   else
	   {
		   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "EBFooterRollupStatus", "fail", "EB Footer Rollup flag is not present");
	   }
		

	 } catch (Exception e) {
		// TODO Auto-generated catch block
		LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyEBFooterRollupFlagStatusForOrg", "warn", "catch block:" +e.getMessage());  
	}
 return sOrgEBFooterRollupStatus; 
	
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
Method Name 	: setRollOnOffEBPanel
Description		: set roll ON or OFF on entity browser window
Author 			: Arul
Creation Date 	: 12/28/2015
Pre-Requisites	:
Revision History:
=====================================================================================================*/

public static boolean setRollOnOffEBPanel(boolean bRollOn){
	boolean bRollOnOff=false;
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,EBPanel);
			String sOrgName=null,sOrgRollupStatus=null;
			
				
     try {
    	    sOrgName =EBPanel.getNav_OrgNameTitleLink().getText();
    	    sOrgRollupStatus =EBPanel.getNav_EBPanelRollUpButton().getAttribute("class");
    	  if (bRollOn == true && sOrgRollupStatus.contains("disabled")==false ){
	    	    if(sOrgRollupStatus.contains("rollon")){
			      FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "RollupStatus", "pass", "Rollup Status already ON for organization "+sOrgName);
			      bRollOnOff=true;
			    }
				else{
				   WebObjectUtil.clickElement(EBPanel.getNav_EBPanelRollUpButton());
				   bRollOnOff=true;
				   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "RollupStatus", "pass", "Rollup Status ON for organization "+sOrgName);
				}
		   }else if (bRollOn == false && sOrgRollupStatus.contains("disabled")==false ){
			   if(sOrgRollupStatus.contains("rollon")==false){
				      FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "RollupStatus", "pass", "Rollup Status already OFF for organization "+sOrgName);
				      bRollOnOff=false;
				    }
					else{
					   WebObjectUtil.clickElement(EBPanel.getNav_EBPanelRollUpButton());
					   bRollOnOff=false;
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "RollupStatus", "pass", "Rollup Status OFF for organization "+sOrgName);
					}
    	   } else{
					 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "RollupStatus", "warn", "Rollup is disabled for organization  "+sOrgName);
					}
					 
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "setRollOnOffEBPanel", "warn", "catch block:" +e.getMessage());  
		}

	return bRollOnOff;
}
/*====================================================================================================
Method Name 	: getOrgNameFromEBPanel
Description		: Getting Org Name from EB Panel based on parameter
Author 			: Vivek Kumar
Creation Date 	: 
Pre-Requisites	:
Revision History:
=====================================================================================================*/
public static String[] getChildOrgNameListFromEBPanel(int iEntityLevel)
{
	WebDriver driver=WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EBPanel);
	
	
	WebElement wEntity = null;
	switch(iEntityLevel)
	{
	case 1: wEntity=EBPanel.getNav_FirstLevelChildrenOrgTable() ;
    break;
    
	case 2: wEntity=EBPanel.getNav_SecondLevelChildrenOrgTable() ;
    break;
    
	case 3: wEntity=EBPanel.getNav_ThirdLevelChildrenOrgTable() ;
    break;
    
	case 4: wEntity=EBPanel.getNav_FourthLevelChildrenOrgTable() ;
    break;
	default: 
    FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Entity Level", "InvalidEntity Child", "warn", "Please pass valid child Entity number");
	}
	
	
	//##############################
	CustomWebElementUtil.loadCustomElement(wEntity, "table");
	int iRowCnt=CustomWebElementUtil.iRowCount;
	arrOrgNameFromEBPanel=new String[iRowCnt];
	for(int i=0;i<iRowCnt;i++)
	{
		arrOrgNameFromEBPanel[i]=CustomWebElementUtil.getRowAsWebElement(i+1).getText();
	}
	
	return arrOrgNameFromEBPanel;
	
}

//// ______________________________ Corwin test cases ____________________________________________ ////

/*==============================================================
TestScript  	: verifyEBFooterLongOrgName
Manual TestCase	: QAT-1348-WCP_4925_TC_Entity Browser_Longer org names display in EB footer
Description		: Verify that when an Org has longer names, it is displayed correctly in EB footer
Author 			: Priyanka
Creation Date 	: 06/08/2016
Pre-Requisites	:
Release Name    : Corwin
Revision History:
==============================================================*/
	@Test(priority=2)
	public void verifyEBFooterLongOrgName()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Ticket);
		PageFactory.initElements(driver, Home);
		PageFactory.initElements(driver, EBPanel);
		
		try {
			String sOrgNameToSelect=(String)FrameworkUtil.dictPropertyData.get("NAV.EBPANEL.ORG.SELECT.NAME");
			
			FrameworkUtil.sTestCaseName = "verifyEBFooterLongOrgName";
			FrameworkUtil.sManualTestCaseName=" QAT-1348-WCP_4925_TC_Entity Browser_Longer org names display in EB footer";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
         
			LoginTestCase_Old1.LoginAsRoleAUser();
			WebObjectUtil.explicitWait(5);
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			//EntityBrowserTestCase.navSelectOrgFromEBPanel(sOrgNameToSelect);
			EntityBrowserTestCase.selectOrgFromAllLevelsEB(sOrgNameToSelect,"","","");
			WebObjectUtil.explicitWait(3);
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			WebObjectUtil.explicitWait(3);
			WebObjectUtil.getToolTipsMsg(EBPanel.getNav_EntityBrowserLink(), sOrgNameToSelect);
			
			LoginTestCase_Old1.nav_Logout();
		}

		catch (Exception e) {
					LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
				
				}
				}







//// _________________________________ Completed corwin test cases _________________________________ ///

@AfterMethod
public static void afterEachMethod(){
	FrameworkUtil.updateTestCaseStatusinResult();
	if(WebDriverUtil.browser.equalsIgnoreCase("ie")){
		WebDriverUtil.quitWebDriver();
	}
	
	
	//Should be deleted after today's execution by Arul on 7/14/16
	WebDriverUtil.quitWebDriver();

}

}
