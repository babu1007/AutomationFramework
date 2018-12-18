package com.whs.navigator.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;

import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.ServicesPageFactory;


public class ServiceTestCase {
	
	
	
	
	public static HomePageFactory_old HomePF = new HomePageFactory_old();
	public static ServicesPageFactory ServicesPF= new ServicesPageFactory();
	
//==================================================TALON====================================================
	/*==============================================================
	TestScript 		: validateAddServicesPageTextandContactNumber
	Manual TestCase	: VTalon QAT-741&747
	Description		:Verify that when user clicks on "Add Services" with "+" sign in portlet on landing page , user is navigated to Services marketing page with Services image and contact number on it along with Tierpoint text.
	Author 			: Sukur Babu
	Creation Date 	: 20/04/2016
	Pre-Requisites	:
	Revision History:
	
	==============================================================*/
	@Test(priority=1)
	public void validateAddServicesPageTextandContactNumber(){
		
		String sContactNumber;
		WebDriver driver = WebDriverUtil.getDriver();
		
	
		PageFactory.initElements(driver, ServicesPF);
		PageFactory.initElements(driver, HomePF);
		
		FrameworkUtil.sTestCaseName = "TalonQAT-741&747-validateAddServicesPageTextandContactNumber";
		FrameworkUtil.sManualTestCaseName="Verify that when user clicks on Add Services with + sign in portlet on landing page , user is navigated to Services marketing page with Services image and contact number on it along with Tierpoint text.";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		sContactNumber=(String)FrameworkUtil.dictPropertyData.get("NAV.SERVICES.CONTACT.NUMBER");
//		String sFireWallRuleToExpand=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.FIREWALLRULETOEXPAND");

		//LoginTestCase.LoginAsDevcoUser();
		//Changing the login to QaAuto as the script working with QaAuto User too - Vivek - 06302016
		LoginTestCase_Old1.LoginAsQaautoUser();
		WebObjectUtil.verifyElementPresent(HomePF.getNav_AddServicesLink());
		//WebObjectUtil.clickElement(HomePF.getNav_AddServicesLink());
		HomeTestCase.verifyBreadScrumb(HomePF.getNav_AddServicesLink(), "Services");
		WebObjectUtil.clickElement(HomePF.getNav_AddServicesLink());
		WebObjectUtil.verifyElementPresent(ServicesPF.getNav_ServicesImage());
		WebObjectUtil.verifyElementPresent(ServicesPF.getNav_ServicesTierPointText());
		WebObjectUtil.verifyElementPresent(ServicesPF.getNav_ServicesTierPointLearnMoreText());
		if(ServicesPF.getNav_ServicesTierPointLearnMoreText().getText().contains(sContactNumber))
			FrameworkUtil.updateCustomResultBasedOnStatus(true,sContactNumber+" is same as displayed in Services page TierPoint learn more... text");
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false,sContactNumber+" is same as displayed in Services page TierPoint learn more... text");
		
		LoginTestCase_Old1.nav_Logout();
		
	}
	//==================================================End of TALON====================================================

}
