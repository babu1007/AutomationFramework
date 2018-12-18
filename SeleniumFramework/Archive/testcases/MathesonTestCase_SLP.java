package com.whs.navigator.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.FirewallPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory;
import com.whs.navigator.pagefactory.MathesonPageFactory_SLP;
import com.whs.navigator.pagefactory.UserPermissionMultiOrgPageFactory;

public class MathesonTestCase_SLP {
	
	public static HomePageFactory Home = new HomePageFactory();
	public static MathesonPageFactory_SLP CustAdvocate = new MathesonPageFactory_SLP();
    public static UserPermissionMultiOrgPageFactory UPMultiOrg = new UserPermissionMultiOrgPageFactory();
    public static EVDC_OverviewPageFactory EVDC_OverviewPF = new EVDC_OverviewPageFactory();
    public static FirewallPageFactory Firewall = new FirewallPageFactory();
    
	/*==============================================================
	TestScript  	: verifyCustomerAdvocatePage
	Manual TestCase	: [QAT-648 ]WCP_4418_TC_1.0_Customer Advocate
	Description		: 
	Author 			: QAA03
	Creation Date 	: 03/31/2016
	Release Name    : Matheson
	Pre-Requisites	:
	Revision History:
  ==============================================================*/
	
	@Test(priority=91)
	public void verifyCustomerAdvocatePageforDiffUsers()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,Home);
			PageFactory.initElements(driver,CustAdvocate);
			PageFactory.initElements(driver,UPMultiOrg);
			
			
	
		try {
			FrameworkUtil.sTestCaseName ="verifyCustomerAdvocatePageforDiffUsers";
			FrameworkUtil.sManualTestCaseName="[QAT-648][669][649][650]WCP_4418_TC_1.0_Customer Advocate";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			//login to Navigator with Role-A user
			LoginTestCase.LoginAsRoleAUser();
			
			verifyCustomerAdvocatePageDetails();
			
			//Logout from Navigator
			LoginTestCase.nav_Logout();
			
			//login to Navigator with entity 01 user
			LoginTestCase.LoginAsEntity01User();
			
			verifyCustomerAdvocatePageDetails();
			
			//Logout from Navigator
			LoginTestCase.nav_Logout();
			
			//login to Navigator with entity 02 user
			LoginTestCase.LoginAsEntity02User();
			
			verifyCustomerAdvocatePageDetails();
			
			//Logout from Navigator
			LoginTestCase.nav_Logout();
			
			//Login to Navigator with QaautoM user
			LoginTestCase.LoginAsQaautoMMultiOrgUser();
			
			//Selecting the Organization from drop down
			WebObjectUtil.selectWebList(UPMultiOrg.getNav_MOrg_SelectOrg(),null, null, 1);
			WebObjectUtil.clickElement(UPMultiOrg.getNav_MOrg_UsethisOrgButton());
			WebObjectUtil.explicitWait(5);
			HomeTestCase.nav_WindStreamToTierPointHomePopup();
			
			verifyCustomerAdvocatePageDetails();
			
			//Logout from Navigator
			LoginTestCase.nav_Logout();
			
		
		   } catch (Exception e) {
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyCustomerAdvocatePageforDiffUsers", "warn", "catch block:" +e.getMessage());
		}
	}
	
	/*==============================================================
	TestScript  	: verifyChangeParentforABCTest
	Manual TestCase	: [QAT-651] WCP_4156_TC_1.0_Entity Management_Search for single entity_change parent 
	Description		: 
	Author 			: QAA03
	Creation Date 	: 04/01/2016
	Release Name    : Matheson
	Pre-Requisites	:
	Revision History:
  ==============================================================*/
	
	@Test(priority=92)
	public void verifyChangeParentforABCTest()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,Home);
			PageFactory.initElements(driver,CustAdvocate);
			PageFactory.initElements(driver,UPMultiOrg);
			
			String sChildorg=null,sParentorg1=null,sParentorg2=null;
			
	
		try {
			FrameworkUtil.sTestCaseName ="verifyChangeParentforABCTest";
			FrameworkUtil.sManualTestCaseName="[QAT-651] WCP_4156_TC_1.0_Entity Management_Search for single entity_change parent";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			sChildorg = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.ABCTEST");
			sParentorg1 = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
			sParentorg2 = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.HOSTEDSOLUTIONS");
			
			//Login to Navigator with ishannon user
			LoginTestCase.LoginAsIshannonUser();
			
			AdminTestCase.verifyOrg(sChildorg, sParentorg1);
			AdminTestCase.verifyOrg(sChildorg, sParentorg2);
			
			//Logout from Navigator
			LoginTestCase.nav_Signout();
		
		   } catch (Exception e) {
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyChangeParentforABCTest", "warn", "catch block:" +e.getMessage());
		}
	}
	
	/*==============================================================
	TestScript  	: verifyEditRuleDisableForSpecificDest
	Manual TestCase	: [QAT-726] WCP_4577_TC_1.0_Firewall rule-> System defined rule validation  
	Description		: 
	Author 			: QAA03
	Creation Date 	: 
	Release Name    : Matheson
	Pre-Requisites	: 
	Revision History: Already covered in different script 
  ==============================================================*/
	
	//@Test(priority=92)
	public void verifyEditRuleDisableForSpecificDest()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,EVDC_OverviewPF);
			PageFactory.initElements(driver,Firewall);
			String sInterfaceName=null,sInterfaceDesc=null;
	
		try {
			FrameworkUtil.sTestCaseName ="verifyEditRuleDisableForSpecificDest";
			FrameworkUtil.sManualTestCaseName="[QAT-726] WCP_4577_TC_1.0_Firewall rule-> System defined rule validation";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
			
			sInterfaceName = (String)FrameworkUtil.dictPropertyData.get("NAV.POTTERS.FIREWALL.INTERFACENAME.INTERFACE1");
			sInterfaceDesc = (String)FrameworkUtil.dictPropertyData.get("NAV.POTTERS.FIREWALL.INTERFACE1.DESCRIPTION");
			
			//Login to Navigator with potters user
			LoginTestCase.LoginAsPottersUser();
						
		    				
			//Navigating to Firewall Page
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCOverviewFirewall());
		
			AddFirewallRuleTestCase.expandInterface(sInterfaceName,sInterfaceDesc);
		
			//Logout from Navigator
			LoginTestCase.nav_Logout();
		
		   } catch (Exception e) {
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyEditRuleDisableForSpecificDest", "warn", "catch block:" +e.getMessage());
		}
	}
	
	/*====================================================================================================
	Method Name 	: verifyCustomerAdvocatePageDetails
	Description		: 
	Author 			: QAA03
	Creation Date 	: 03/31/2016
	Pre-Requisites	: 
	Revision History:
	====================================================================================================*/
	public static void verifyCustomerAdvocatePageDetails()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,Home);
			PageFactory.initElements(driver,CustAdvocate);
			
			
	 try {
		    //Navigating to Customer Advocate page
			WebObjectUtil.clickElement(Home.getNav_SupportTab());
			WebObjectUtil.clickElement(CustAdvocate.getNav_CustomerAdvocateLink());
			WebObjectUtil.waitForElementPresent(CustAdvocate.getNav_CustomerAdvocateData());
			WebObjectUtil.verifyElementPresent(CustAdvocate.getNav_CustomerAdvocateData());
		 
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyCustomerAdvocatePageDetails", "warn", "catch block:" +e.getMessage());  
		}
	 
	}
	
	@AfterMethod
	public static void afterEachMethod(){
			FrameworkUtil.updateTestCaseStatusinResult();
			
		}

}
