package com.whs.navigator.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.EVDC_FirewallPageFactory;
import com.whs.navigator.pagefactory.FirewallPageFactory;

public class TakashimaTestCase_NMR {

	public static FirewallPageFactory Firewall_GOM = new FirewallPageFactory();
	public static EVDC_FirewallPageFactory FirewallPF = new EVDC_FirewallPageFactory();
	
	/*==============================================================
	TestScript 		: verifyServiceObjectsColumnHeaders
	Manual TestCase	: QAT-1595
	Description		: Verify the Columns in Service Objects
	Author 			: QAA04
	Creation Date 	: 07/26/2016
	Release Name    : Takashima
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=1)
	public void verifyServiceObjectsColumnHeaders(){
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Firewall_GOM);
		PageFactory.initElements(driver, FirewallPF);
		
		try {
			FrameworkUtil.sTestCaseName="verifyServiceObjectsColumnHeaders";
			FrameworkUtil.sManualTestCaseName="(QAT-1595) Firewall_GOM - Verify the Columns in Service Objects";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to the navigator
				LoginTestCase.LoginAsQaautoUser();
					
			 // navigating to the firewall page
					EVDC_FirewallTestCase.NavigateToFirewallPage();
					
					// wait for the feedback message not displayed
					LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
							
					//Clicking on GOM link and verifying its landing page
					WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
					
					WebObjectUtil.explicitWait(5);
					
					//Expanding the Services Object
					WebObjectUtil.clickElement(FirewallPF.getNav_ServiceObjectsExpander());
					WebObjectUtil.explicitWait(5);
			
					WebObjectUtil.verifyElementPresent(Firewall_GOM.getNav_ServiceObjects_Protocol_ColumnHeader());
					WebObjectUtil.verifyElementPresent(Firewall_GOM.getNav_ServiceObjects_ServiceEnd_ColumnHeader());
					WebObjectUtil.verifyElementPresent(Firewall_GOM.getNav_ServiceObjects_Port_ColumnHeader());
					WebObjectUtil.verifyElementPresent(Firewall_GOM.getNav_ServiceObjects_Discription_ColumnHeader());
	
					//Clicking on Service Create Image
					WebObjectUtil.clickElement(FirewallPF.getNav_GOMServiceCreateImg());
					WebObjectUtil.explicitWait(3);
					//verifying Create Window
					WebObjectUtil.verifyElementPresent(FirewallPF.getNav_GOMServiceCreateWindow());
					
					WebObjectUtil.verifyElementPresent(Firewall_GOM.getNav_Service_ObjectTypeDropDownArrow());
					WebObjectUtil.verifyElementPresent(Firewall_GOM.getNav_Service_FromExistingGrpTable());
					WebObjectUtil.verifyElementPresent(Firewall_GOM.getNav_Service_ObjectTypeNewObjRadioBtn());
					WebObjectUtil.verifyElementPresent(Firewall_GOM.getNav_Service_ObjectTypeNewObjName());
					WebObjectUtil.verifyElementPresent(Firewall_GOM.getNav_Service_ObjectTypePortRangeStart());
					WebObjectUtil.verifyElementPresent(FirewallPF.getNav_Service_ObjectTypePortRangeEnd());
					WebObjectUtil.verifyElementPresent(Firewall_GOM.getNav_Service_NewNameEdit());
					WebObjectUtil.verifyElementPresent(FirewallPF.getNav_Service_GrpDescTextArea());
					WebObjectUtil.verifyElementPresent(Firewall_GOM.getNav_Service_ObjectTypeTransferRight());
					WebObjectUtil.verifyElementPresent(Firewall_GOM.getNav_Service_ObjectTypeSaveBtn());
					
					// log out
					LoginTestCase.nav_Logout();
		}catch(Exception e){
			LoggerUtil.log_type_error("Issue with verifyServiceObjectsColumnHeaders test case");
			LoggerUtil.log_type_error("exception occured " +FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception occured", "fail", e.getMessage()+"null");
		}
}
	
	
	
	// after method
		@AfterMethod
		public void afterEachMethod(){
			FrameworkUtil.updateTestCaseStatusinResult();
			FrameworkUtil.sTestExecutionStatus=true;
		}
}
