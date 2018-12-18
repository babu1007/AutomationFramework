package com.whs.navigator.testcases.valen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.EVDC_StorageProfilePageFactory;
import com.whs.navigator.pagefactory.ReportsPageFactory;
import com.whs.navigator.testcases.LoginTestCase_Old1;
import com.whs.navigator.testcases.ReportsTestCase;

public class ValenTestCases {

	public static ReportsPageFactory Reports = new ReportsPageFactory();
	public static EVDC_StorageProfilePageFactory Storage = new EVDC_StorageProfilePageFactory();
	
	/*==============================================================
	TestScript 		: verifyReportsBreadCrumb
	Manual TestCase	: (QAT-1649)(QAT-1642)(QAT-1639)
	Description		: Verify that the bread crumb
	Author 			: QAA04
	Creation Date 	: 08/01/2016
	Release Name    : Valen
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=1)
	public void verifyReportsBreadCrumb(){
		String sBreadCrumb,sActualBreadCrumb;
		boolean bStatus;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Reports);
		PageFactory.initElements(driver, Storage);
		
		try {
			FrameworkUtil.sTestCaseName="Reports-verifyReportsBreadCrumb";
			FrameworkUtil.sManualTestCaseName="(QAT-1649)(QAT-1642)(QAT-1639) Reports - Verify that the bread crumb shows as,Home->Reports->Network";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to the navigator
			LoginTestCase_Old1.LoginAsQaautoAUser();
			
			// navigating to the reports page
			ReportsTestCase.navigateToReportsPage();
			
			WebObjectUtil.clickElement(Reports.getNavNetworkReports());
			
			// verifying the network portlets
			WebObjectUtil.verifyElementPresent(Reports.getNavNetworkPortlets());
			
			// verifying the bread crumb
			sActualBreadCrumb =Reports.getNavBreadCrumbChain().getText();
			
			
			sBreadCrumb= (String) FrameworkUtil.dictPropertyData.get("NAV.REPORTS.BREAD.CRUMB");
			
			bStatus = sActualBreadCrumb.equalsIgnoreCase(sBreadCrumb);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Verifying the bread crumb - "+sActualBreadCrumb);
			
			WebObjectUtil.clickElement(Storage.getNav_breadCrumbChain());
			
			// verifying the network portlets
			WebObjectUtil.verifyElementPresent(Reports.getNavNetworkPortlets());
					
			// log out
			LoginTestCase_Old1.nav_Logout();
		}catch (Exception e) {
			LoggerUtil.log_type_error("issue with verifyReportsBreadCrumb test case");
		    LoggerUtil.log_type_error("Exception occured "+FrameworkUtil.sElementName);
		   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage());
		}
		
	}
	
	
	
	//update each @Test result in custom result file
		@AfterMethod
		public static void afterEachMethod(){
			FrameworkUtil.updateTestCaseStatusinResult();
			
		}
			
	
}
