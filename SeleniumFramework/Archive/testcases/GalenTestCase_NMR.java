package com.whs.navigator.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.CommonPageFactory;
import com.whs.navigator.pagefactory.IACPageFactory_NMR;
import com.whs.navigator.pagefactory.LoadBalancerPageFactory;

public class GalenTestCase_NMR {

	public static LoadBalancerPageFactory LoadBalancer = new LoadBalancerPageFactory();
    public static CommonPageFactory Common = new CommonPageFactory();

    
    
    
/*===================================================================
	TestScript 		: verifyVirtualIpTabIPAddressColumn
	Manual TestCase	: QAT-1410
	Description		: IP address are displayed in the Virtual IPs
	Author 			: QAA04
	Creation Date 	: 06/14/2016
	release Name    : 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
@Test(priority=1) 
public void verifyVirtualIpTabIPAddressColumn() {
	
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, LoadBalancer);
	try {

	PageFactory.initElements(driver, LoadBalancer);
	
	 FrameworkUtil.sTestCaseName ="verifyVirtualIpTabIPAddressColumn";
	 FrameworkUtil.sManualTestCaseName ="(QAT-1410) Galen -IP address are displayed in the Virtual IPs";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	/// Login to the navigator
	LoginTestCase.LoginAsHawkeyeUser();
	/// navigating to the load balancer page
	LoadBalancersTestCase.NavigatingToLoadBalancerPage();
	
	WebObjectUtil.verifyElementPresent(LoadBalancer.getNavVirtualIP_IpAddressCloumnHeader());
	
	// step 5 is related to IAC application.
    LoginTestCase.nav_Logout();
	}
	catch(Exception e){
		LoggerUtil.log_type_error("Issue with verifyVirtualIpTabIPAddressColumn test case");
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception accured", "fail", e.getMessage()+"null");
	}
	}
	
	

/*===================================================================
TestScript 		: verifyRefreshBtnDetails
Manual TestCase	: QAT-1406
Description		: Successful message is displayed in feedback area
Author 			: QAA04
Creation Date 	: 06/14/2016
release Name    : 
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=2) 
public void verifyRefreshBtnDetails(){
	WebElement wExpander,wRefreshBtn;
	String sExpander,sRefreshBtn,sSucessMsg,sFeedBackMsg;
	boolean bStatus;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, LoadBalancer);
	PageFactory.initElements(driver, Common);
	try {
     FrameworkUtil.sTestCaseName ="verifyRefreshBtnDetails";
	 FrameworkUtil.sManualTestCaseName ="(QAT-1406) Galen - Successful message is displayed in feedback area";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	/// Login to the navigator
	LoginTestCase.LoginAsHawkeyeUser();
	/// navigating to the load balancer page
	LoadBalancersTestCase.NavigatingToLoadBalancerPage();
	
	  sExpander = WebObjectUtil.getLocatorValueFromProperty("EVDC.LOADBALANCER.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
	   wExpander = WebObjectUtil.GetWebElement("XPATH", sExpander, "Expand Arrow");
	   wExpander.click();
	   WebObjectUtil.explicitWait(5);
	   
	   sRefreshBtn = WebObjectUtil.getLocatorValueFromProperty("EVDC.LOADBALANCER.EXPANDER.REFRESHDETAILS.BUTTON", "PARAMETER_ROWNUMBER", 1 +"");
	   wRefreshBtn = WebObjectUtil.GetWebElement("XPATH", sRefreshBtn, "RefreshDetailsButton");
	   WebObjectUtil.verifyElementPresent(wRefreshBtn);
	
	   WebObjectUtil.clickElement(wRefreshBtn);
	   WebObjectUtil.explicitWait(5);
	   sSucessMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.LOADBALNCER.FEEDBACK.MESSAGE");
	   sFeedBackMsg =Common.getNav_UsrFeedBack().getText();
		bStatus=sFeedBackMsg.contains(sSucessMsg);
		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Refresh details button sucess msg verified");
		
	   
    LoginTestCase.nav_Logout();
	}
	catch(Exception e){
		LoggerUtil.log_type_error("Issue with verifyRefreshBtnDetails test case");
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception accured", "fail", e.getMessage()+"null");
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
