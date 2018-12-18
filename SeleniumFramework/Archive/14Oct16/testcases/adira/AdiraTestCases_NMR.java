package com.whs.navigator.testcases.adira;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.testcases.FormTestCase;
import com.whs.navigator.testcases.LoginTestCase;
import com.whs.navigator.testcases.adira.FormPageFactory_NMR;
import com.whs.navigator.testcases.Talon.TalonTestCase_Vivek;

public class AdiraTestCases_NMR {

	public static FormPageFactory_NMR Form = new FormPageFactory_NMR();
	
	
	 /*==============================================================
	TestScript 		: 
	Manual TestCase	: 
	Description		: 
	Author 			: QAA04
	Creation Date 	: 
	Release Name    : 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=1)
	public void verifyNetwrokNameEditFieldFunctionality(){
		
	String sNetworkName;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, Form);
	
	
		FrameworkUtil.sTestCaseName="";
		FrameworkUtil.sManualTestCaseName="";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		// login to the navigator
		LoginTestCase.LoginAsKirkjUser();

		
        // navigating to the forms page.
		FormTestCase.navToFormsPage();
		
		sNetworkName = (String) FrameworkUtil.dictPropertyData.get("NAV.FORM.NETWORK.TOPOLOGY.NAME");
		// navigate to form3 page.
		TalonTestCase_Vivek.getSalesOrderByFormName(sNetworkName);
	
	
	}
	
	
	
	//__________________________________________________________________________________________________________

	@AfterMethod
	public void afterMethod(){
		FrameworkUtil.updateTestCaseStatusinResult();
		FrameworkUtil.sTestExecutionStatus=true;
	}
	
}
