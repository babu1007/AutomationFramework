package com.whs.navigator.testcases.Lefcourt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.FormPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.LogViewerPageFactory_NMR;

public class LefCourt_SP1TestCase_NMR {
	
	public static EVDC_OverviewPageFactory EVDC_OverviewPF = new EVDC_OverviewPageFactory();
	public static HomePageFactory_old HomePF = new HomePageFactory_old();
	public static LogViewerPageFactory_NMR LogViewerPF = new LogViewerPageFactory_NMR();
	public static FormPageFactory Form = new FormPageFactory();
	/*==============================================================
	TestScript  	: navVerifyCloudMigrarionPortlet
	Manual TestCase	: QAT-479
	Description		: Verify that Cloud Migration portlet is removed.
	Author 			: QAA04
	Creation Date 	: 02/02/2016
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=1)
	public void navVerifyCloudMigrarionPortlet(){
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);
		try{
			
		
		FrameworkUtil.sTestCaseName="navVerifyCloudMigrarionPortlet";
		FrameworkUtil.sManualTestCaseName="(QAT-479) LefCourtSP1 - Verify that Cloud Migration portlet is removed.";
	    FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	
	    // login to the navigator
	  //  LoginTestCase.LoginAsDevco();
	    LoginTestCase_Old1.LoginAsQaautoUser();
	    
	    // navigating to the evdc overveiw page
	    WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
	    
	    // verify cloud migraions portlet not present
	    WebObjectUtil.verifyElementNOTPresent(EVDC_OverviewPF.getNav_EVDCOverviewCloudMigrations());
	    
	    // logout 
	    LoginTestCase_Old1.nav_Logout();
		}
		catch(Exception e){
			LoggerUtil.log_type_error("Issue with navVerifyCloudMigrarionPortlet test case");
			LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage()+"null");
		}
	}

	
	/*==============================================================
	TestScript  	: navVerifyCloudmigrationsLink
	Manual TestCase	: QAT-478
	Description		: Verify that from the drop down, "Cloud Migrations" option is removed.
	Author 			: QAA04
	Creation Date 	: 02/02/2016
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=2)
	public void navVerifyCloudmigrationsLink(){
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, HomePF);
		try{
		FrameworkUtil.sTestCaseName="navVerifyCloudmigrationsLink";
		FrameworkUtil.sManualTestCaseName="(QAT-478) LefCourtSP1 - Verify that from the drop down, Cloud Migrations option is removed.";
	    FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
	    // login to the navigator
	//    LoginTestCase.LoginAsDevco();
	    LoginTestCase_Old1.LoginAsQaautoUser();
	    
	    // verifying cloud migrations link not present in the menu tabs
	    WebObjectUtil.ClickAndMouseHover(HomePF.getNav_ServicesTab());
       WebObjectUtil.verifyElementNOTPresent(HomePF.getNav_CloudMigrationMenuLink());
       
       // logout 
       LoginTestCase_Old1.nav_Logout();
       
	}
	catch(Exception e){
		LoggerUtil.log_type_error("Issue with navVerifyCloudmigrationsLink test case");
		LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage()+"null");
	}
}
	/*==============================================================
	TestScript  	: verifyServerColumnNOTPresentInLogViewerWebTable
	Manual TestCase	: QAT-477
	Description		: Verify that "server" column is removed from Log Viewer
	Author 			: QAA04
	Creation Date 	: 02/02/2016
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=3)
	public void verifyServerColumnNOTPresentInLogViewerWebTable(){
		WebElement wSelectDate;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, LogViewerPF);
		PageFactory.initElements(driver, HomePF);
		try{
		FrameworkUtil.sTestCaseName="verifyServerColumnNOTPresentInLogViewerWebTable";
		FrameworkUtil.sManualTestCaseName="(QAT-477) LefCourtSP1 - Verify that server column is removed from Log Viewer";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		// login to the navigator
		//LoginTestCase.LoginAsDevco();
		LoginTestCase_Old1.LoginAsQaautoUser();
		
		// navigating to the log viewer page
		WebObjectUtil.ClickAndMouseHover(HomePF.getNav_SupportTab());
		WebObjectUtil.clickElement(HomePF.getNav_LogViewerMenuLink());
		
		// selecting the date
		WebObjectUtil.clickElement(LogViewerPF.getNavStartDateIcon());
		WebObjectUtil.clickElement(LogViewerPF.getNavStartDateIcon_PreviousMonthIcon());
		
		wSelectDate = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.LOGVIEWER.STARTDATEICON.SELECT.DATE", "PARAMETER_ROWNUMBER,PARAMETER_COLUMNNUMBER", 2+","+1);
		WebObjectUtil.clickElement(wSelectDate);
		
		WebObjectUtil.clickElement(LogViewerPF.getNavViewLogBtn());
		WebObjectUtil.explicitWait(5);
       WebObjectUtil.verifyElementNOTPresent(LogViewerPF.getNavServerColumn());
       
       
       // log out 
       LoginTestCase_Old1.nav_Logout();
		}
		catch(Exception e){
			LoggerUtil.log_type_error("Issue with navVerifyServerColumn test case");
			LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage()+"null");
		}
		
	}
	
	/*==============================================================
	TestScript  	: verifyFormsApprovedStatus
	Manual TestCase	: QAT-4
	Description		: Under the Forms Approval Status, confirm the text over the status bar reads "Forms Approved".
	Author 			: QAA04
	Creation Date 	: 05/17/2016
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=4)
	public static void verifyFormsApprovedStatus(){
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Form);
		
		try {
			FrameworkUtil.sTestCaseName="verifyFormsApprovedStatus";
			FrameworkUtil.sManualTestCaseName="(QAT-4) LefCourtSP1 - Under the Forms Approval Status, confirm the text over the status bar reads Forms Approved.";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to the navigator
			LoginTestCase_Old1.LoginAsQaautoAUser();
			
			// navigate to form page.
			FormTestCase.navToFormsPage();
			
			// verifying the forms approved status
			WebObjectUtil.verifyElementPresent(Form.getNav_FormsApprovalStatus());
			
			// log out
			LoginTestCase_Old1.nav_Logout();
		}catch(Exception e){
				LoggerUtil.log_type_error("Issue with verifyFormsApprovedStatus test case");
				LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage()+"null");
			}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	// After method
	@AfterMethod
	public static void afterMethod(){
		FrameworkUtil.updateTestCaseStatusinResult();
		FrameworkUtil.sTestExecutionStatus=true;
	}
}
