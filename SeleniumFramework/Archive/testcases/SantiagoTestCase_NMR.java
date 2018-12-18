package com.whs.navigator.testcases;

import java.awt.Frame;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.media.rtc.webkitRTCPeerConnection;
import com.whs.navigator.commonUtil.CustomWebElementUtil;
import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.AnnouncementPageFactory;
import com.whs.navigator.pagefactory.FormPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory;
import com.whs.navigator.pagefactory.LogViewerPageFactory_NMR;

public class SantiagoTestCase_NMR {

public static LogViewerPageFactory_NMR Logviewer = new LogViewerPageFactory_NMR();
public static HomePageFactory Home = new HomePageFactory();	
public static FormPageFactory FormPF = new FormPageFactory();
public static AnnouncementPageFactory Announcement = new AnnouncementPageFactory();

	/*==============================================================
	TestScript 		: verifyAutomationRequestStatusRadioBtn
	Manual TestCase	: QAT-815
	Description		: 
	Author 			: QAA04
	Creation Date 	: 02/04/2016
	Release Name    : LefcourtSP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=1)
	public void verifyAutomationRequestStatusRadioBtn(){
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Logviewer);
		
		try {
			FrameworkUtil.sTestCaseName="verifyAutomationRequestStatusRadioBtn";
			FrameworkUtil.sManualTestCaseName="(QAT-815) Santigo - Verify that the Automation Request Status radio button";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to the navigator
			LoginTestCase.LoginAsARoleAUser();
			
			// navigating to the log viewer page
			navigatingToTheLogViewerPage();
			
			// verify automation request status radio button
			WebObjectUtil.verifyElementPresent(Logviewer.getNavAutomationRequestStatusRadioBtn());
			
			// log out
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("Issue with verifyAutomationRequestStatusRadioBtn test case");
			LoggerUtil.log_type_error("exception occured " +FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception occured", "fail", e.getMessage()+"null");
		}	
	}
	
	/*==============================================================
	TestScript 		: selectAutomationRequestStatusRadioBtn
	Manual TestCase	: QAT-800
	Description		: Firewall and Group Object Management logs are displayed
	Author 			: QAA04
	Creation Date 	: 04/06/2016
	Release Name    : LefcourtSP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/	
	@Test(priority=2)
	public void selectAutomationRequestStatusRadioBtn(){
		boolean bStatus;
		String sDropDownText,sText,sXpath;
		WebElement wDropDown;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Logviewer);
		try{
		FrameworkUtil.sTestCaseName="selectAutomationRequestStatusRadioBtn";
		FrameworkUtil.sManualTestCaseName="(QAT-800) Satiago - Firewall and Group Object Management logs are displayed";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		//login to the navigator
		LoginTestCase.LoginAsRoleAUser();
		
		// navigating to the log viewer page.
		navigatingToTheLogViewerPage();
		
		WebObjectUtil.selectCheckRadioBox(Logviewer.getNavAutomationRequestStatusRadioBtn());
		WebObjectUtil.explicitWait(5);
		
		sDropDownText = (String) FrameworkUtil.dictPropertyData.get("NAV.LOGVIEWER.IACSTATUSDROPDOWN.OPTION.TEXT");
		 sXpath = (String) FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
		WebObjectUtil.clickElement(Logviewer.getNavIACStatusDropDownArrow());
		 wDropDown = WebObjectUtil.getActiveElementasWebElement(sXpath);
		List<WebElement> webListItems = wDropDown.findElements(By.tagName("li"));
		for (WebElement weblist :webListItems){
			 sText = weblist.getText();
			bStatus = sText.equalsIgnoreCase(sDropDownText);
			if(bStatus==true){
		    	FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Firewall and Group Object Management is displaying");
		    	break;
		    }
		}
		// log out
		LoginTestCase.nav_Logout();
	} catch (Exception e) {
		LoggerUtil.log_type_error("Issue with selectAutomationRequestStatusRadioBtn test case");
		LoggerUtil.log_type_error("exception occured " +FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception occured", "fail", e.getMessage()+"null");
	}	
	}
	
	/*==============================================================
	TestScript 		: verifyLogviewerElementsForAutomationRequestStatus
	Manual TestCase	: QAT-816,QAT-819
	Description		: verify the logviewer webtable data
	Author 			: QAA04
	Creation Date 	: 04/11/2016
	Release Name    : LefcourtSP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/	
	@Test(priority=3)
	public void verifyLogviewerElementsForAutomationRequestStatus(){
		String sText,sDropDownText,sOrgText,sOrgDropDownText,sDateFrom,sDateTo,sRowText;
		WebElement wRow;
		int iRowNum;
		boolean bStatus;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Logviewer);
		
		try {
			FrameworkUtil.sTestCaseName="verifyLogviewerElementsForAutomationRequestStatus";
			FrameworkUtil.sManualTestCaseName="(QAT-816)(QAT-819) Santiago - verify the logviewer webtable data";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to the navigator 
			LoginTestCase.LoginAsARoleAUser();
			
			// navigating to the logviewer page
			navigatingToTheLogViewerPage();
			
			WebObjectUtil.selectCheckRadioBox(Logviewer.getNavAutomationRequestStatusRadioBtn());
			WebObjectUtil.explicitWait(3);
			
			WebObjectUtil.clickElement(Logviewer.getNavIACStatusDropDownEditBox());
			sText = Logviewer.getNavIACStatusDropDownEditBox().getAttribute("value");
			sDropDownText = (String) FrameworkUtil.dictPropertyData.get("NAV.LOGVIEWER.IACSTATUSDROPDOWN.OPTION.TEXT");
			
			bStatus = sText.equalsIgnoreCase(sDropDownText);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Firewall and Group Object Management is displaying");
			
			WebObjectUtil.clickElement(Logviewer.getNavOrgDropDownEditBox());
			sOrgText = Logviewer.getNavOrgDropDownEditBox().getAttribute("value");
			sOrgDropDownText =(String) FrameworkUtil.dictPropertyData.get("NAV.LOGVIEWER.ORG.DROPDOWN.OPTION.TEXT");
			
			bStatus = sOrgText.equalsIgnoreCase(sOrgDropDownText);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus,".Hosted Soluti_0 is displaying");

			 sDateFrom = Logviewer.getNavDateFromDivision().getAttribute("class");
			 bStatus = sDateFrom.contains("x-item-disabled");
			 FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "DateFrom field is disabled");
			 
			 sDateTo = Logviewer.getNavDateToDivision().getAttribute("class");
			 bStatus = sDateTo.contains("x-item-disabled");
			 FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "DateTo field is disabled");
			 
			 LefCourt_SP2TestCase_NMR.SelectElementFromDropDown(Logviewer.getNavOrgDropDownArrow(), "TST QAauto_2858");
			 
			 WebObjectUtil.clickElement(Logviewer.getNavViewLogBtn());
			 WebObjectUtil.explicitWait(5);
			 
			 WebObjectUtil.verifyElementPresent(Logviewer.getNavRequisitionIdColumnHeader());
			 WebObjectUtil.verifyElementPresent(Logviewer.getNavActionColumnHeader());
			 WebObjectUtil.verifyElementPresent(Logviewer.getNavDateCreatedColumnHeader());
			 WebObjectUtil.verifyElementPresent(Logviewer.getNavStatusColumnHeader());
			 
			 CustomWebElementUtil.loadCustomElement(Logviewer.getNavWebTableParent(), "table");
			 iRowNum = CustomWebElementUtil.iRowCount;
			 if(iRowNum != 0){
			 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Logviewer web table is NOT empty","pass", "Row count is "+iRowNum);
			 }else{
				 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Logviewer web table is empty","warn", "Row count is "+iRowNum);
			 }
			 
			 wRow = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.LOGVIEWER.WEBTABLE.ROW.DATA", "PARAMETER_ROWNUMBER", 1+"");
			 sRowText = wRow.getText();
			 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "WebTable row data", "pass", "First row data - "+sRowText);
			 
			 
			 // log out
			 LoginTestCase.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("Issue with verifyLogviewerElementsForAutomationRequestStatus test case");
			LoggerUtil.log_type_error("exception occured " +FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception occured", "fail", e.getMessage()+"null");
		}	
	}
	
	/*==============================================================
	TestScript 		: verifyTheResetFunctionality
	Manual TestCase	: QAT-820
	Description		: Go to Automation Request Status page and verify that the new value reset to old value.
	Author 			: QAA04
	Creation Date 	: 04/11/2016
	Release Name    : LefcourtSP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/	
	@Test(priority=4)
	public void verifyTheResetFunctionality(){
		String sText,sDropDownText,sOrgText,sOrgDropDownText,sOrgName;
		int iRowNum;
		boolean bStatus;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Logviewer);
		
		try {
			FrameworkUtil.sTestCaseName="verifyTheResetFunctionality";
			FrameworkUtil.sManualTestCaseName="(QAT-820) Santiago - Go to Automation Request Status page and verify that the new value reset to old value.";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to the navigator 
			LoginTestCase.LoginAsARoleAUser();
			
			// navigating to the logviewer page
			navigatingToTheLogViewerPage();
			
			WebObjectUtil.selectCheckRadioBox(Logviewer.getNavAutomationRequestStatusRadioBtn());
			WebObjectUtil.explicitWait(3);
			
			WebObjectUtil.clickElement(Logviewer.getNavIACStatusDropDownEditBox());
			sText = Logviewer.getNavIACStatusDropDownEditBox().getAttribute("value");
			sDropDownText = (String) FrameworkUtil.dictPropertyData.get("NAV.LOGVIEWER.IACSTATUSDROPDOWN.OPTION.TEXT");
			
			bStatus = sText.equalsIgnoreCase(sDropDownText);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Firewall and Group Object Management is displaying");
			
			WebObjectUtil.clickElement(Logviewer.getNavOrgDropDownEditBox());
			sOrgText = Logviewer.getNavOrgDropDownEditBox().getAttribute("value");
			sOrgDropDownText =(String) FrameworkUtil.dictPropertyData.get("NAV.LOGVIEWER.ORG.DROPDOWN.OPTION.TEXT");
			
			bStatus = sOrgText.equalsIgnoreCase(sOrgDropDownText);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus,".Hosted Soluti_0 is displaying");

			 sOrgName="TST QAauto_2858";
			 LefCourt_SP2TestCase_NMR.SelectElementFromDropDown(Logviewer.getNavOrgDropDownArrow(), sOrgName);
			 
			 WebObjectUtil.clickElement(Logviewer.getNavViewLogBtn());
			 WebObjectUtil.explicitWait(5);
			
			 CustomWebElementUtil.loadCustomElement(Logviewer.getNavWebTableParent(), "table");
			 iRowNum = CustomWebElementUtil.iRowCount;
			 if(iRowNum != 0){
			 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Logviewer web table is NOT empty","pass", "Row count is "+iRowNum);
			 }else{
				 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Logviewer web table is empty","warn", "Row count is "+iRowNum);
			 }
				
			 WebObjectUtil.clickElement(Logviewer.getNavResetBtn());
			 WebObjectUtil.explicitWait(5);
			 
			bStatus= WebObjectUtil.isCheckRadioSelected(Logviewer.getNavAutomationRequestStatusRadioBtn());
			 FrameworkUtil.updateCustomResultBasedOnStatus(!bStatus, "Automation request status radio btn is NOT selected");
			 
			 WebObjectUtil.selectCheckRadioBox(Logviewer.getNavAutomationRequestStatusRadioBtn());
			
			 WebObjectUtil.clickElement(Logviewer.getNavOrgDropDownEditBox());
			 sOrgText = Logviewer.getNavOrgDropDownEditBox().getAttribute("value");
			 sOrgDropDownText =(String) FrameworkUtil.dictPropertyData.get("NAV.LOGVIEWER.ORG.DROPDOWN.OPTION.TEXT");
			
			bStatus = sOrgText.equalsIgnoreCase(sOrgDropDownText);
			 FrameworkUtil.updateCustomResultBasedOnStatus(bStatus,".Hosted Soluti_0 is displaying in org drop down");

			 LefCourt_SP2TestCase_NMR.SelectElementFromDropDown(Logviewer.getNavOrgDropDownArrow(), sOrgName);
			        
			 // log out 
			 LoginTestCase.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("Issue with verifyTheResetFunctionality test case");
			LoggerUtil.log_type_error("exception occured " +FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception occured", "fail", e.getMessage()+"null");
		}	
	}
	
	/*==============================================================
	TestScript 		: verifyPDFandCSVIcons
	Manual TestCase	: QAT-821
	Description		: verify the pdf and csv icons
	Author 			: QAA04
	Creation Date 	: 04/13/2016
	Release Name    : LefcourtSP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/	
	@Test(priority=5)
	public void verifyPDFandCSVIcons(){
		String sPDFIcon,sCSVIcon;
		boolean bStatus;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Logviewer);
		
		try {
			FrameworkUtil.sTestCaseName="verifyPDFandCSVIcons";
			FrameworkUtil.sManualTestCaseName="(QAT-821)Santiago - verify the PDF and CSV icons";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to the navigator
			LoginTestCase.LoginAsRoleAUser();
			
			// navigate to log viewer page
			navigatingToTheLogViewerPage();
			
			WebObjectUtil.selectCheckRadioBox(Logviewer.getNavAutomationRequestStatusRadioBtn());
			WebObjectUtil.explicitWait(3);
			
			// verify the pdf and csv icons
			sPDFIcon = Logviewer.getNavPDFIcon().getAttribute("src");
			bStatus = sPDFIcon.contains("PDF");
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "PDF icon is displaying ");
			
			sPDFIcon = Logviewer.getNavCSVIcon().getAttribute("src");
			bStatus = sPDFIcon.contains("CSV");
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "CSV icon is displaying ");
			
			// log out
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("Issue with verifyPDFandCSVIcons test case");
			LoggerUtil.log_type_error("exception occured " +FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception occured", "fail", e.getMessage()+"null");
		}	
		
	}
	
	/*==============================================================
	TestScript 		: verifyAnnouncementPage
	Manual TestCase	: QAT-837
	Description		: Verify that the announcement welcome page is displayed
	Author 			: QAA04
	Creation Date 	: 04/13/2016
	Release Name    : LefcourtSP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/	
	@Test(priority=6)
	public void verifyAnnouncementPage(){
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,Announcement );
		PageFactory.initElements(driver, Home);
		try {
			FrameworkUtil.sTestCaseName="verifyAnnouncementPage";
			FrameworkUtil.sManualTestCaseName="(QAT-837) Santiago - Verify that the announcement welcome page is displayed";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to the navigator
			LoginTestCase.LoginAsQaautoAUser();
			
			// navigate to announcement page
			AnnouncementTestCase.navAnnouncementPage();
			
			// verifying the welcome page.
			WebObjectUtil.verifyElementPresent(Announcement.getNav_AnnouncementWelcomePage());
			
			WebObjectUtil.clickElement(Announcement.getNav_HomeBreadCrumb());
			WebObjectUtil.verifyElementPresent(Home.getNav_AnnouncementSection());
			
			// log out
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("Issue with verifyAnnouncementPage test case");
			LoggerUtil.log_type_error("exception occured " +FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception occured", "fail", e.getMessage()+"null");
		}	
		
	}
	
	//////////////////////////////////////////// METHODS ////////////////////////////////////////////////////////////////////////////////////
	
	/*==============================================================
	MethodName 		: navigatingToTheLogViewerPage
	Manual TestCase	: 
	Description		: 
	Author 			: 
	Creation Date 	: 04/01/2016
	release Name    : 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navigatingToTheLogViewerPage(){
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Logviewer);
        PageFactory.initElements(driver, Home);
        
		WebObjectUtil.ClickAndMouseHover(Home.getNav_SupportTab());
		//WebObjectUtil.clickElement(Home.getNav_LogViewerMenuLink());
		WebObjectUtil.clickAndVerifyElement(Home.getNav_LogViewerMenuLink(), Logviewer.getNavViewLogBtn());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	// after method
		@AfterMethod
		public void afterEachMethod(){
			FrameworkUtil.updateTestCaseStatusinResult();
			FrameworkUtil.sTestExecutionStatus=true;
		}
}
