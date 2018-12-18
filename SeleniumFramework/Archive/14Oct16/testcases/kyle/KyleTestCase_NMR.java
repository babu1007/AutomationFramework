package com.whs.navigator.testcases.kyle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.CustomWebElementUtil;
import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.EVDC_FirewallPageFactory;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;

public class KyleTestCase_NMR {

	public static EVDC_FirewallPageFactory EVDC_Firewall = new EVDC_FirewallPageFactory();
	public static EVDC_OverviewPageFactory EVDC_Overview = new EVDC_OverviewPageFactory();

	
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
		PageFactory.initElements(driver, EVDC_Firewall);
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
			WebObjectUtil.waitForElementPresent(EVDC_Firewall.getNav_UserAccessVPNsTab());
			WebObjectUtil.clickElement(EVDC_Firewall.getNav_UserAccessVPNsTab());
			
			CustomWebElementUtil.loadCustomElement(EVDC_Firewall.getNav_UserAccessVPN_WebTableParent(), "table");
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
	
	
	
////////________________________________________________________________________________//////////////////// 
//update each @test result in custom result file
@AfterMethod
public static void afterEachMethod(){
	FrameworkUtil.updateTestCaseStatusinResult();
	FrameworkUtil.sTestExecutionStatus = true;
}	
	
}
