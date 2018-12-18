package com.whs.navigator.testcases.Lefcourt;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;

public class LefcourtTestCases_Vivek {
	
/*==============================================================
	TestScript  	: verifyUsrNotNavigateProduction
	Manual TestCase	: QAT-433-WCP_4279_User is navigated to Windstream Prod.site when logged in as entity01 user
	Description		: After login to Navigator user should not navigate to Production site
	Author 			: Vivek Kumar
	Creation Date 	: 01/21/2016
	Release Name    : LefCourt
	Pre-Requisites	:
	Revision History:
==============================================================*/
	@Test(priority=1)
	public void verifyUsrNotNavigateProduction()
	{
		String sUserName,sPassword,sURL;
		boolean bStatus=false;
		WebDriver driver=WebDriverUtil.getDriver();
		
		
		FrameworkUtil.sTestCaseName = "verifyUsrNotNavigateProduction";
		FrameworkUtil.sManualTestCaseName="QAT-433-WCP_4279_User is navigated to Windstream Prod.site when logged in as entity01 user";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.ENTITY01.USERID");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.PASSWORD");
		
		//Login to navigator
		LoginTestCase_Old1.nav_Login(sUserName, sPassword);
		sURL=driver.getCurrentUrl();
		
		bStatus=sURL.contains("tst-lab2");
		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "User is not navigated to production site");
		
		//Logout
		LoginTestCase_Old1.nav_Logout();
	}
	
	/*==============================================================
	TestScript  	: verifyVMPgDisplayRoleE
	Manual TestCase	: QAT-13-WCP_4243_VM page dispaly on Firefox
	Description		: verify Role E can view the page if we expand VM
	Author 			: Vivek Kumar
	Creation Date 	: 01/21/2016
	Release Name    : LefCourt
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=2)
	public void verifyVMPgDisplayRoleE()
	{
		String sUserName,sPassword;
		int iRowNbr;
		
		FrameworkUtil.sTestCaseName = "verifyVMPgDisplayRoleE";
		FrameworkUtil.sManualTestCaseName="QAT-13-WCP_4243_VM page display on Firefox";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEE.USERID");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEE.PASSWORD");
		
		//Login to navigator
		LoginTestCase_Old1.nav_Login(sUserName, sPassword);
		
		//Navigate to EVDC-VM
		EVDC_VM_AdvancedActions.navigateAndExpandVMforRoleE("Stopped");
  		iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum ;
  		
  		//Verifying the refresh button
  		EVDC_VM_TestCase.navVerifyClkRefreshBtn(iRowNbr);
		
  		//Logout
		LoginTestCase_Old1.nav_Logout();
	}
	
	
	/*==============================================================
	TestScript  	: verifyPageDiscrepancies
	Manual TestCase	: QAT-446-WCP_4378_VM page discrepancies
	Description		: NOTE: These discrepancies are in Chrome browser. 
						Verify that the grid color on VM page is consistent with all the pages in portal. 
						Verify that Advanced Actions items are displayed properly.
	Author 			: Vivek Kumar
	Creation Date 	: 01/25/2016
	Release Name    : LefCourt
	Pre-Requisites	:
	Revision History: Actually this TC for Chrome but we have developed for FF
	==============================================================*/
	//@Test(priority=3)
	public void verifyPageDiscrepancies()
	{
		String sUserName,sPassword;
		int iRowNbr;
		
		FrameworkUtil.sTestCaseName = "verifyPageDiscrepancies";
		FrameworkUtil.sManualTestCaseName="QAT-446-WCP_4378_VM page discrepancies";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.USERID.QAAUTO");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.PWD.QAAUTO");
		
		//Login to navigator
		LoginTestCase_Old1.nav_Login(sUserName, sPassword);
		
		//Clicking on EVDC
		
	}
	
	//update each @Test result in custom result file
	@AfterMethod
	public static void afterEachMethod(){
		FrameworkUtil.updateTestCaseStatusinResult();
		
	}

}
