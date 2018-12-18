package com.whs.navigator.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.EVDC_StorageProfilePageFactory;
import com.whs.navigator.pagefactory.UserPermissionPageFactory;
import com.whs.navigator.testcases.EVDC_VM_TestCase;
import com.whs.navigator.testcases.LoginTestCase;
import com.whs.navigator.testcases.UserPermissionTestCase;

public class ValenTestCase_Vivek {
	
	public static EVDC_StorageProfilePageFactory EVDC_Storage = new EVDC_StorageProfilePageFactory();
	static UserPermissionPageFactory UserPermission = new UserPermissionPageFactory();
	public static EVDC_OverviewPageFactory EVDC_OverviewPF = new EVDC_OverviewPageFactory();
	
/*==============================================================
TestScript  	: valLegacyOrgNotViewQuatoBtn
Manual TestCase	: QAT-1648 - WCP_5452_TC_1.4_Elastic Storage->Legacy org 
Description		: Verify that Legacy org user is unable to view Quota button in the storage tiers
Note			: Note: 11Giraffes org is legacy org To see org is legacy, go to chrome and login to navigator as giruser and go to storage page, 
				  Click Function F12 and verify the Cbu=false, then org is legacy org.
Author 			: Vivek Kumar
Creation Date 	: 08/02/2016
Pre-Requisites	:
Release	Name	: Valen
Revision History:
==============================================================*/
@Test(priority=1)
public void valLegacyOrgNotViewQuatoBtn()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EVDC_Storage);
	
	String sEVDCName;
	WebElement wEVDC_Org;
	int iQuotaBtnCnt;
	
	FrameworkUtil.sTestCaseName = "valLegacyOrgNotViewQuatoBtn";
	FrameworkUtil.sManualTestCaseName="QAT-1648 - WCP_5452_TC_1.4_Elastic Storage->Legacy org";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	
	sEVDCName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.EVDC.11GIRAFFE.ORG.NAME");
	
	//Login to Navigator as GirUser - Legacy Org
	LoginTestCase.LoginAsGirUser();
	
	//Click on Andover EVDC link
	wEVDC_Org=EVDC_VM_TestCase.getEVDCNameAsWebElement(sEVDCName);
	WebObjectUtil.clickElement(wEVDC_Org);
	
	//Click on Storage Profile
	WebObjectUtil.clickElement(EVDC_Storage.getNav_StorageLink());
	
	//Validating Quota  Button - should not visible for Legacy User
	iQuotaBtnCnt=EVDC_Storage.getNav_StorageProfileQuotaButton().size();
	FrameworkUtil.updateCustomResultBasedOnStatus((iQuotaBtnCnt==0), "Verify Quota Button not present");
	
	//Log Out
	LoginTestCase.nav_Logout();
	
	
}
	
/*==============================================================
TestScript  	: valRoleENotViewDelBtn
Manual TestCase	: QAT-1640 - WCP_5509_TC_1.2_Delete a Storage Tier via Ticket_view delete icon_Role-E 
Description		: Verify Full Server observer (Role-E) is not able to see the Delete button for a Storage Tier. 
Note			: Every org who has storage tier will have Delete button. Since this will create a ticket,
 				  this functionality is not whitelisted to any specific org.
Author 			: Vivek Kumar
Creation Date 	: 08/02/2016
Pre-Requisites	:
Release	Name	: Valen
Revision History:
==============================================================*/
@Test(priority=2)
public void valRoleENotViewDelBtn()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, UserPermission);
	PageFactory.initElements(driver, EVDC_OverviewPF);
	
	String sRoleObserver,sOrgNameToVerify,sOrgNameToSelect;
	int iDeleteBtnCnt;
		
	FrameworkUtil.sTestCaseName = "valRoleENotViewDelBtn";
	FrameworkUtil.sManualTestCaseName="QAT-1640 - WCP_5509_TC_1.2_Delete a Storage Tier via Ticket_view delete icon_Role-E";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	
	sRoleObserver = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.OBSERVER");
	sOrgNameToVerify=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTQAAUTO");
	sOrgNameToSelect=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTQAAUTO_2858");
	
	UserPermissionTestCase.AccessToUserManagement( "Role-A", "P@$$word");
	WebObjectUtil.verifyElementPresent(UserPermission.getNav_UsersTab());
	
	
	//arole-a,arole-c,arole-e,role-a,role-c,role-e
	UserPermissionTestCase.selectOrgFromUserPermission(sOrgNameToVerify,sOrgNameToSelect);
	WebObjectUtil.explicitWait(5);
	UserPermissionTestCase.setUserPermission("qaauto-e",sRoleObserver);

	//Log Out
	LoginTestCase.nav_Logout();
	
	//Login back as QaAuto-e
	LoginTestCase.LoginAsQaautoEUser();
	
	//Navigate to Storage Profile
	WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
    WebObjectUtil.clickElement(EVDC_Storage.getNav_StorageLink());
	
	//Validating Del  Button - should not visible for Observer
	iDeleteBtnCnt=EVDC_Storage.getNav_StorageProfileBlkDelBtn().size();
	FrameworkUtil.updateCustomResultBasedOnStatus((iDeleteBtnCnt==0), "Verify Delete Button not present");
	
	//Log Out
	LoginTestCase.nav_Logout();
	
}

	
	
	
	
	
	@AfterMethod
	public static void afterEachMethod(){
			FrameworkUtil.updateTestCaseStatusinResult();
			
		}

}
