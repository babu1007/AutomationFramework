package com.whs.navigator.testcases.dev.old;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;

public class TestScriptTemplate {

	
	/*==============================================================
	TestScript  	: scriptNameStartsWithSmallLetter
	Manual TestCase	: [Jira No] Manual test case name / short description if no Manual test case name 
	Description		: detailed description about test cases with validation point
	Author 			: Author name
	Creation Date 	: Date of test script creation
	Release Name    : name of release which the test case belongs to.
	Pre-Requisites	: pre-condition if any
	Revision History: update revision history if we do any change in script as per application change.
	==============================================================*/
	
	@Test(priority=1)
	public void scriptNameStartsWithSmallLetter()
	{
		// variable declaration
		// webdriver initiation, Example : WebDriver driver = WebDriverUtil.getDriver();
		// page factory initiation, Example : PageFactory.initElements(driver,pagefactoryname);
		
		try {
			
			// Assigning test script name to variable
			FrameworkUtil.sTestCaseName = "ModuleName-scriptNameStartsWithSmallLetter";
			// Assigning manual test case(s) name to variable
			FrameworkUtil.sManualTestCaseName="[Jira No] Manual test case name / short description if no Manual test case name";
			// updating script name in result
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			

			//Manual Test Step-1
		    //Login to Application (navigator)
			//LoginTestCase.LoginAsQaautoUser();
			
			
			//Manual Test Step-2

			//Manual Test Step-3

			//Manual Test Step-4

			//Manual Test Step-5

			//Manual Test Step-6

			//Manual Test Step-7

			//Manual Test Step-8

			//Manual Test Step-9

			//Manual Test Step-10
			//Logout from Application (navigator)
			//LoginTestCase.nav_Logout();
			//LoginTestCase.nav_Signout();
			
			
			
		   } catch (Exception e) {
			String sCurrentMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName ,sCurrentMethodName, "fail", "catch block:" +e.getMessage());
		}
		
	}
	
	
	
	
	
	/*====================================================================================================
	Method Name 	: MethodNameStartsWithSmallLetter
	Description		: Details description about method with purpose like navigateto,verify etc
	Author 			: Author name
	Creation Date 	: Date of Method creation
	Module Name     : Module name which this method belongs to.
	Pre-Requisites	: pre-condition if any
	Revision History: update revision history if we do any change in script as per application change.

	====================================================================================================*/
	public static void MethodNameStartsWithSmallLetter()
	{
		// variable declaration
		// webdriver initiation, Example : WebDriver driver = WebDriverUtil.getDriver();
		// page factory initiation, Example : PageFactory.initElements(driver,pagefactoryname);
		
		try {
			
			//set of code
			
		   } catch (Exception e) {
			String sCurrentMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName ,sCurrentMethodName, "warn", "catch block:" +e.getMessage());
		}
		
	}
}
