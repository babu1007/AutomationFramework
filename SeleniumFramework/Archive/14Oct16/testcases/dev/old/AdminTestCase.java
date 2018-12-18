package com.whs.navigator.testcases.dev.old;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.CustomWebElementUtil;
import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.commonUtil.WebTableUtil;
import com.whs.navigator.pagefactory.AdminPageFactory;
import com.whs.navigator.pagefactory.EM7PageFactory;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.EntityBrowserPageFactory;

public class AdminTestCase {

	public static AdminPageFactory Admin = new AdminPageFactory();
	public static EM7PageFactory EM7 = new EM7PageFactory();
	public static EntityBrowserPageFactory EBPanel = new EntityBrowserPageFactory();
	public static EVDC_OverviewPageFactory EVDC_OverviewPF =new EVDC_OverviewPageFactory();
	
	
	static List<String> sChildOrgListFromEB = new ArrayList<String>();
	static List<String> sChildOrgList =new ArrayList<String>();
	
//___________________________ Gideon TestCases ________________________________________///
	/*==============================================================
	TestScript 		: nav_SearchUserOnEM7Page
	Manual TestCase	: Search UserName in EM7 page
	Description		: Create a username in Navigator and verify that username in EM7
	Author 			: QAA04
	Creation Date 	: 08/27/2015
	Release Name    : Gideon
	Pre-Requisites	:
	Revision History:
	==============================================================*/

		@Test(priority=15)
		public void nav_SearchUserOnEM7Page() {
			String sUpgradeUrl,sFirstName,sLastName,sPhoneNumber,sEmail;
			WebDriver driver=WebDriverUtil.getDriver();
			PageFactory.initElements(driver, Admin);
			PageFactory.initElements(driver, EM7);
			try{
			
			FrameworkUtil.sTestCaseName="Em7-nav_SearchUserOnEM7Page";
		    FrameworkUtil.sManualTestCaseName="(CPPOC-3068)Search UserName in EM7 page";
		    FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		    
		    String sUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ISHANNON.USERID");
		    String sPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ISHANNON.PASSWORD");
			LoginTestCase.nav_Login(sUserName, sPassword);
			
			
			// Navigating to the Upgrade page
			WebDriverUtil.getDriver().get((String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ISHANNON.UPGRADE.URL"));
			
			 sUpgradeUrl=driver.getCurrentUrl();
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "NavigateToUpgradeUrl", "pass", "The current url = "+sUpgradeUrl);
			WebObjectUtil.explicitWait(5);
			
			WebObjectUtil.clickElement(Admin.getNav_EmployeOnboardingLink());
			 sFirstName=(String) FrameworkUtil.dictPropertyData.get("NAV.EMPLOYEEONBOARDING.FIRSTNAME");
			WebObjectUtil.SetValueEdit(Admin.getNav_FirstNameEditBox(), sFirstName);
		    sLastName=(String) FrameworkUtil.dictPropertyData.get("NAV.EMPLOYEEONBOARDING.LASTNAME");
			WebObjectUtil.SetValueEdit(Admin.getNav_LastNameEditBox(),sLastName);
		    sPhoneNumber=(String) FrameworkUtil.dictPropertyData.get("NAV.EMPLOYEEONBOARDING.PHONE");
			WebObjectUtil.SetValueEdit(Admin.getNav_PhoneEditBox(), sPhoneNumber);
			 sEmail=(String) FrameworkUtil.dictPropertyData.get("NAV.EMPLOYEEONBOARDING.EMAILID");
			WebObjectUtil.SetValueEdit(Admin.getNav_EmailEditBox(), sEmail);
			WebObjectUtil.explicitWait(2);
			WebObjectUtil.clickElement(Admin.getNav_GenerateUsrNmeButton());
			WebObjectUtil.explicitWait(2);
			
		
			
			WebObjectUtil.selectCheckRadioBox(Admin.getNav_WhsStorageRadioBtn());
			WebObjectUtil.explicitWait(5);
			WebObjectUtil.clickElement(Admin.getNav_SubmitBtn());
	        
		    /////log out ishnnon user
			LoginTestCase.nav_Signout();
		    
		    //// login to the EM7 Page
		    WebDriverUtil.getDriver().get((String)FrameworkUtil.dictPropertyData.get("NAV.EM7.URL"));
		   
		    String sEM7UserName =(String)FrameworkUtil.dictPropertyData.get("NAV.EM7.NAVUSER.USERID");
		    String sEM7Password =(String)FrameworkUtil.dictPropertyData.get("NAV.EM7.NAVUSER.PASSWORD");
			
		  //Login to Navigator
		    EM7TestCase.EM7Login(sEM7UserName, sEM7Password);
		    //EVDCTestCase.navEVDCLogin();
			
			WebObjectUtil.explicitWait(5);
			WebObjectUtil.clickElement(EM7.getEM7_RegistryButton());
			WebObjectUtil.clickElement(EM7.getEM7_AccountsLink());
			WebObjectUtil.clickElement(EM7.getEM7_UserAccountsLink());
			WebObjectUtil.explicitWait(5);
			WebObjectUtil.SetValueEdit(EM7.getEM7_UserNameSearchBox(), "stester");
			WebObjectUtil.explicitWait(10);
			WebObjectUtil.VerifyTextUnderElement(EM7.getEM7_ActiveState(), "Active");
			WebObjectUtil.VerifyTextUnderElement(EM7.getEM7_LDAPADState(), "LDAP/AD");
			WebObjectUtil.explicitWait(3);
			//logout EM7 page
			EM7TestCase.EM7Logout();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
		         	LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
			}
		}
		
		
		/*==============================================================
		TestScript 		: nav_VerifyOnboardingPage
		Manual TestCase	: Verify the fields in Employee Onboarding page
		Description		: verify all the fields in the Employee onboarding page
		Author 			: QAA04
		Creation Date 	: 08/27/2015
		Release Name    : Gideon
		Pre-Requisites	:
		Revision History:
		==============================================================*/

		@Test(priority=14)
		public void nav_VerifyOnboardingPage()
		{
			String sUpgradeUrl;
			WebDriver driver=WebDriverUtil.getDriver();
			PageFactory.initElements(driver, Admin);
			try{
				
			FrameworkUtil.sTestCaseName="EVDC-nav_VerifyOnboardingPage";
		    FrameworkUtil.sManualTestCaseName="(CPPOC-3062)Verify the fields in Employee Onboarding page";
		    FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		   
		    String sUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ISHANNON.USERID");
		    String sPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ISHANNON.PASSWORD");
			LoginTestCase.nav_Login(sUserName, sPassword);
			
			
			// Navigating to the Upgrade page
			WebDriverUtil.getDriver().get((String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ISHANNON.UPGRADE.URL"));
			
			 sUpgradeUrl=driver.getCurrentUrl();
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "NavigateToUpgradeUrl", "pass", "The current url = "+sUpgradeUrl);
			WebObjectUtil.explicitWait(5);
			
			///Employee Onboarding page
			WebObjectUtil.isElementPresent(Admin.getNav_EmployeOnboardingLink());
			WebObjectUtil.VerifyTextUnderElement(Admin.getNav_EmployeOnboardingLink(), "Employee Onboarding");
			WebObjectUtil.clickElement(Admin.getNav_EmployeOnboardingLink());
			
			WebObjectUtil.isElementPresent(Admin.getNav_FirstNameTitle());
			
			WebObjectUtil.verifyElementPresent(Admin.getNav_FirstNameEditBox());
			WebObjectUtil.isElementPresent(Admin.getNav_LastNameTitle());
			
			WebObjectUtil.verifyElementPresent(Admin.getNav_LastNameEditBox());
			WebObjectUtil.isElementPresent(Admin.getNav_PhoneNumberTitle());
			
			WebObjectUtil.verifyElementPresent(Admin.getNav_PhoneEditBox());
			WebObjectUtil.isElementPresent(Admin.getNav_EmailTitle());
			
			WebObjectUtil.verifyElementPresent(Admin.getNav_EmailEditBox());
			WebObjectUtil.isElementPresent(Admin.getNav_UserNameTitle());
			
			WebObjectUtil.verifyElementPresent(Admin.getNav_UserNameEditBox());
			WebObjectUtil.isElementPresent(Admin.getNav_GenerateUsrNmeButton());
			
			WebObjectUtil.isElementPresent(Admin.getNav_WhsNetworkingTitle());
			
		    WebObjectUtil.isElementPresent(Admin.getNav_whsSalesTitle());
			
			WebObjectUtil.isElementPresent(Admin.getNav_WhsStorageTitle());
		   
			WebObjectUtil.isElementPresent(Admin.getNav_WhsVirtualizationTitle());
			
			WebObjectUtil.explicitWait(5);
			WebObjectUtil.selectCheckRadioBox(Admin.getNav_WhsNetworkingRadioBtn());
			WebObjectUtil.isCheckRadioSelected(Admin.getNav_whsSalesRadioBtn());
			WebObjectUtil.isCheckRadioSelected(Admin.getNav_WhsStorageRadioBtn());
			WebObjectUtil.isCheckRadioSelected(Admin.getNav_WhsVirtualizationBtn());
			WebObjectUtil.explicitWait(5);
			WebObjectUtil.isElementPresent(Admin.getNav_SubmitBtn());
			
			WebObjectUtil.isElementPresent(Admin.getNav_ResetBtn());
			
			
			
			/////log out ishnnon user
			
			LoginTestCase.nav_Signout();
			WebObjectUtil.explicitWait(2);
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
		         	LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
			}
		}
		
		/*==============================================================
		TestScript 		: nav_EmailErrorMessage
		Manual TestCase	: Verify the email error Message in employee Onboarding page
		Description		: Verify the email error messages after clicking on submit button
		Author 			: QAA04
		Creation Date 	: 09/1/2015
		Release Name    : Gideon
		Pre-Requisites	:
		Revision History:
		==============================================================*/

		@Test(priority=18)
		public void nav_EmailErrorMessage() {
			String sUpgradeUrl,sFirstName,sLastName,sPhoneNumber,sEmail,sErrorMassage,sEmailEorrorMsg;
			boolean bStatus;
			WebDriver driver=WebDriverUtil.getDriver();
			PageFactory.initElements(driver, Admin);
			PageFactory.initElements(driver, EM7);
			try{
			
			FrameworkUtil.sTestCaseName="Em7-nav_EmailErrorMessage";
		    FrameworkUtil.sManualTestCaseName="(CPPOC-3081)Verify the email error Message in employee Onboarding page ";
		    FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		    
		    String sUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ISHANNON.USERID");
		    String sPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ISHANNON.PASSWORD");
			LoginTestCase.nav_Login(sUserName, sPassword);
			
			
			// Navigating to the Upgrade page
			WebDriverUtil.getDriver().get((String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ISHANNON.UPGRADE.URL"));
			
			 sUpgradeUrl=driver.getCurrentUrl();
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "NavigateToUpgradeUrl", "pass", "The current url = "+sUpgradeUrl);
			WebObjectUtil.explicitWait(5);
			
			WebObjectUtil.clickElement(Admin.getNav_EmployeOnboardingLink());
			 sFirstName=(String) FrameworkUtil.dictPropertyData.get("NAV.EMPLOYEEONBOARDING.FIRSTNAME");
			WebObjectUtil.SetValueEdit(Admin.getNav_FirstNameEditBox(), sFirstName);
		     sLastName=(String) FrameworkUtil.dictPropertyData.get("NAV.EMPLOYEEONBOARDING.LASTNAME");
			WebObjectUtil.SetValueEdit(Admin.getNav_LastNameEditBox(),sLastName);
			 sPhoneNumber=(String) FrameworkUtil.dictPropertyData.get("NAV.EMPLOYEEONBOARDING.PHONE");
			WebObjectUtil.SetValueEdit(Admin.getNav_PhoneEditBox(), sPhoneNumber);
			 sEmail=(String) FrameworkUtil.dictPropertyData.get("NAV.EMPLOYEEONBOARDING.EMAIL");
			WebObjectUtil.SetValueEdit(Admin.getNav_EmailEditBox(), sEmail);
			WebObjectUtil.explicitWait(2);
			WebObjectUtil.clickElement(Admin.getNav_GenerateUsrNmeButton());
			WebObjectUtil.explicitWait(2);
			WebObjectUtil.selectCheckRadioBox(Admin.getNav_WhsStorageRadioBtn());
			WebObjectUtil.explicitWait(5);
			WebObjectUtil.clickElement(Admin.getNav_SubmitBtn());
	        WebObjectUtil.explicitWait(7);
	        
	        sErrorMassage =	Admin.getNav_EmailErrorMsg().getText();
			
			 sEmailEorrorMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EMPLOYEE.EMAIL.ERROR.MASSAGE");
			  bStatus =  sErrorMassage.contains(sEmailEorrorMsg);
		    FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Verify email error massage");
			 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Email error massage", "pass", "error massage  = "+sErrorMassage);
				    WebObjectUtil.explicitWait(10);  
		    /////log out ishnnon user
			LoginTestCase.nav_Signout();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
		         	LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
			}
		
		}
		

		//___________________________ Completed Gideon TestCases ________________________________________///
		///______________________________ Clark Test Cases __________________________________________///

				/*========================================================================================================
				TestScript  	: verifyParentChildEntityChange
				Manual TestCase	: CPPOC-3036 Verifying Parent And Child Entities can be changed
				Description		: Verifying whether we can change parent and child entities
				Author 			: QAA01
				Creation Date 	: 08/17/2015
				Release Name    : Clark-Sp1
				Pre-Requisites	:
				Revision History:
				======================================================================================================*/

				@Test(priority=91)
				public static void verifyParentChildEntityChange()
				{
				       WebDriver driver = WebDriverUtil.getDriver();
				       PageFactory.initElements(driver, EBPanel);
				       PageFactory.initElements(driver, Admin);
				       String sChildorg=null,sParentorg=null;
				       
				try {
						  FrameworkUtil.sTestCaseName = "verifyParentChildEntityChange";
						  FrameworkUtil.sManualTestCaseName="CPPOC-3036 Verifying Parent And Child Entities can be changed";
						  FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
						  
						  sChildorg = (String)FrameworkUtil.dictPropertyData.get("NAV.QA.UPGRADE.ENTITYMGT.CHILDORGNAME");
						  sParentorg = (String)FrameworkUtil.dictPropertyData.get("NAV.QA.UPGRADE.ENTITYMGT.PARENTORGNAME");
						  verifyParentChildEntity(sChildorg,sParentorg);
						} catch (Exception e) {
							
							LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyParentChildEntityChange", "warn", "catch block:Could NOT access webelement" +e.getMessage());	
						}
				}

	
		
		/*========================================================================================================
		TestScript  	: verifyParentForChildEntityList
		Manual TestCase	: CPPOC-3222 Verifying Parent for corresponding child entities in Entity Management List
		Description		: Verifying Parent for corresponding child entities in EM List
		Author 			: QAA01
		Creation Date 	: 08/25/2015
		Release Name    : Clark-Sp1
		Pre-Requisites	:
		Revision History:
		======================================================================================================*/


		@Test(priority=100)
		public static void verifyParentForChildEntityList()
		{
		   WebDriver driver = WebDriverUtil.getDriver();
		   PageFactory.initElements(driver, Admin);
		   String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ISHANNON.USERID");
		   String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ISHANNON.PASSWORD");
		   
		   
		try {
			  FrameworkUtil.sTestCaseName = "verifyParentForChildEntityList";
			  FrameworkUtil.sManualTestCaseName="CPPOC-3222 Verifying Parent for corresponding child entities in EM List";
			  FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			  
			  LoginTestCase.nav_Login(sUserName, sPassword);
			
			  verifyParentCountEMList();
				
			  LoginTestCase.nav_Signout();
			  
			} catch (Exception e) {
				
				LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyParentForChildEntityList", "warn", "catch block:Could NOT access webelement" +e.getMessage());	
			}
		}

		//// _____________________________ Completed Clark Test Cases __________________________________ //////////
		
		
	//// _____________________________ Eilerson Test Cases Start __________________________________ //////////
		
	//// _____________________________ QAA03 Start __________________________________ //////////
		
		
		
		/*=================================================================================================
		TestScript  	: verifyUserSelectParentEntityDropdownEM 
		Manual TestCase	: QAT-42/CPPOC-3420 Under Entity Management tab, when changing a parent for an entity, verify user is only able to select and choose entity from the drop down list.
		Description		: Under Entity Management tab, when changing a parent for an entity, verify user is only able to select and choose entity from the drop down list.
		Author 			: QAA03
		Creation Date 	: 09/03/2015
		Release Name    : Eilerson
		Pre-Requisites	:
		Revision History:
		==========================================================================================================*/
		   
		@Test(priority=101)
		public static void verifyUserSelectParentEntityDropdownEM()
		{
				     WebDriver driver = WebDriverUtil.getDriver();
				     PageFactory.initElements(driver, Admin);
				 
				     String sUserName = null,sPassword = null;
				                 
				try {
					FrameworkUtil.sTestCaseName = "verifyUserSelectParentEntityDropdownEM";
					FrameworkUtil.sManualTestCaseName="QAT-42/CPPOC-3420 Under Entity Management tab, when changing a parent for an entity, verify user is only able to select and choose entity from the drop down list.";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					                 
					sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ISHANNON.USERID");
				    sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ISHANNON.PASSWORD");
					
					LoginTestCase.nav_Login(sUserName, sPassword);
					verifyUserSelectParentEntityDropdown();
					LoginTestCase.nav_Signout();
					
				} catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyUserSelectParentEntityDropdownEM", "warn", "catch block:" +e.getMessage());
				}
		}
		/*=================================================================================================
		TestScript  	: verifyTstEntityParentChildHierarchy 
		Manual TestCase	: QAT-37/CPPOC-3442 Under Entity Management tab,Verify changing parents for different child entities.
		Description		: Under Entity Management tab,Verify changing parents for different child entities
		Author 			: QAA03
		Creation Date 	: 09/03/2015
		Release Name    : Eilerson
		Pre-Requisites	:
		Revision History:
		==========================================================================================================*/
		   
		@Test(priority=102)
		public static void verifyTstEntityParentChildHierarchy()
		{
				     WebDriver driver = WebDriverUtil.getDriver();
				     PageFactory.initElements(driver, Admin);
				 
				     String sUserName = null,sPassword = null;
				                 
				try {
					/*FrameworkUtil.sTestCaseName = "verifyTstEntityParentChildHierarchy";
					FrameworkUtil.sManualTestCaseName="QAT-37/CPPOC-3442 Under Entity Management tab,Verify changing parents for differnt child entities.";
					//FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					                 */
					sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ISHANNON.USERID");
				    sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ISHANNON.PASSWORD");
					
					LoginTestCase.nav_Login(sUserName, sPassword);
					setTstEntityParent();
					LoginTestCase.nav_Signout();
					
				} catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyTstEntityParentChildHierarchy", "warn", "catch block:" +e.getMessage());
				}
		}
		//// _____________________________ Eilerson Test Cases End __________________________________ //////////		
		
		
////// _____________________________ Hague Test cases ________________________________________________ ///////////
		/*==============================================================
		TestScript  	: verifyImpersonationinEVDCSelector
		Manual TestCase	: [QAT-298] WCP_2630_TC_Impresonation in the EVDC selector
		Description		: Verify the Impersonation in EVDC selector
		Author 			: QAA03
		Creation Date 	: 12/02/2015
		Release Name    : Hague
		Pre-Requisites	:
		Revision History:
	==============================================================*/
		@Test(priority=2)
		public void verifyImpersonationinEVDCSelector()
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,Admin);
				PageFactory.initElements(driver,EVDC_OverviewPF);
				
				
				String sUserName=null,sPassword=null,sOrgToselect=null,sSubOrgToSelect=null,sParentWindowName=null;
				String sEVDCName=null,sEVDCSelector=null,sEVDCPrivateName=null,sULelementXpath=null;
				boolean bStatus;
			
			
			try {
				FrameworkUtil.sTestCaseName = "verifyImpersonationinEVDCSelector";
				FrameworkUtil.sManualTestCaseName="[QAT-298] WCP_2630_TC_Impresonation in the EVDC selector";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
				sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ISHANNON.USERID");
			    sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ISHANNON.PASSWORD");
			    
			    sOrgToselect = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.11GIRAFFES.CHILD");
			    sSubOrgToSelect = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.GIRUSER");
			    
			    sEVDCPrivateName = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.NAME.PRIVATE.CLOUD");
			    sULelementXpath = (String) FrameworkUtil.dictDynamicPagePactory.get("NAV.EVDC.SELECTOR");
			    
				//Login to Navigator
				LoginTestCase.nav_Login(sUserName, sPassword);
				
				//Navigating to Organizations Page in Control Panel
				navigatingToControlPanelOrgPage();
				
			    //Clicking on actions button with respect to selected organization in Organization Table
				navAdminClickActionsButtonOrg(sOrgToselect);
				
				//Clicking on view users link
				WebObjectUtil.clickElement(Admin.getNav_Admin_ViewUsersLink());
				
				//Clicking on actions button with respect to selected organization in Organization Table
				navAdminClickActionsButtonOrg(sSubOrgToSelect);
			
				//Clicking on impersonate user link
				WebObjectUtil.clickElement(Admin.getNav_Admin_ImpersonateUserLink());
				
				sParentWindowName = driver.getWindowHandle();
				//Switching to second window
				WebObjectUtil.switchToWindow(2,"");
				
				//Getting EVDC Name
				sEVDCName=EVDC_OverviewPF.getNav_EVDCname().getText();	
				
				//Clicking on EVDC Name and validating its landing page
				WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
				WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCOrgSelector());
				
				//Getting EVDC Selector Name
				sEVDCSelector=EVDC_OverviewPF.getNav_EVDCOrgSelector().getText();
				
				//Comparing EVDC Name And EVDC Selector Name
				bStatus=sEVDCName.equalsIgnoreCase(sEVDCSelector);
				FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Data on EVDC selector and Data on EVDC name");
				// Need to execute manually dropdown selection so commented - QAA03
				/*WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCLoadBalancerPortlet());
				WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCOrgSelector());
				WebObjectUtil.selectCustomWebList(EVDC_OverviewPF.getNav_EVDCOrgSelector(),sULelementXpath,sEVDCPrivateName,2);
				WebObjectUtil.verifyElementPresent(Home.getNav_FeedBackBox());*/
				
				
				WebObjectUtil.explicitWait(5);
				//Closing the second window
				driver.close();
				
				//Switching to parent window
				driver.switchTo().window(sParentWindowName);
				
				//logging out from navigator
				LoginTestCase.nav_Signout();
				
			   } catch (Exception e) {
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyImpersonationinEVDCSelector", "warn", "catch block:" +e.getMessage());
			}
	    }		
		
	
	/////________________________________ Completed Hague test cases _____________________________________ ///////////////	
		/*====================================================================================================
		Method Name 	: navigatingToControlPanelOrgPage
		Description		: Navigating to Organizations page in Control Panel
		Author 			: QAA03
		Creation Date 	: 12/02/2015
		Pre-Requisites	:
		Revision History:
		====================================================================================================*/
		public static void navigatingToControlPanelOrgPage()
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,Admin);
				
					
	     try {   	
	    	    WebObjectUtil.MouseHover(Admin.getNav_Admin_ManageTab());
				WebObjectUtil.clickElement(Admin.getNav_Admin_ControlPanelLink());
				WebObjectUtil.waitForElementPresent(Admin.getNav_Admin_ControlPanelText());
				WebObjectUtil.verifyElementPresent(Admin.getNav_Admin_ControlPanelText());
				WebObjectUtil.clickElement(Admin.getNav_Admin_OrganizationsLink());
				  
			 } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navigatingToControlPanelOrgPage", "warn", "catch block:" +e.getMessage());  
			}
			
		}
		
		/*====================================================================================================
		Method Name 	: navAdminClickActionsButtonOrg
		Description		: Clicking on actions button with respect to selected organization in Organization Table
		Author 			: QAA03
		Creation Date 	: 12/02/2015
		Pre-Requisites	:
		Revision History:
		====================================================================================================*/
		public static void navAdminClickActionsButtonOrg(String sOrganization)
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,Admin);
				WebElement wRowActionsButton;
				int iRowNumber=0;
					
	     try {
	        	CustomWebElementUtil.loadCustomElement(Admin.getNav_Admin_OrganizationsParentWebTable(), "tr");
			    iRowNumber = CustomWebElementUtil.getRowByCellText(sOrganization,1);
			    wRowActionsButton = WebObjectUtil.getWebElementFromDynamicLocator("xpath","ADMIN.MANAGE.CONTROLPANEL.ORGS.ORGTABLE.ACTIONSBUTTON", "PARAMETER_ROWNUMBER", iRowNumber+"");
				WebObjectUtil.clickElement(wRowActionsButton);
				
				  
			 } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navAdminClickActionsButtonOrg", "warn", "catch block:" +e.getMessage());  
			}
			
		}
		
		/*====================================================================================================
		Method Name 	: verifyParentCountEMList
		Description		: Verifying Parents for corresponding child from Entity Management
		Author 			: QAA01
		Creation Date 	: 08/25/2015
		Pre-Requisites	:
		Revision History:
		=====================================================================================================*/


		public static void verifyParentCountEMList()
		{
		    WebDriver driver = WebDriverUtil.getDriver();
		    PageFactory.initElements(driver, Admin);
		    PageFactory.initElements(driver, EBPanel);
		    String sUrl = (String)FrameworkUtil.dictPropertyData.get("NAV.QA.UPGRADE.URL");
		    String sFLCOrgData = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.EB.FLCHILDORG");
		    int iSLCCount=0,iChildOrgCount=0,iChildOrgEBCount=0;
		    String sChildOrgName=null;
		    
		    boolean bStatus = true;
		    try {
				   driver.get(sUrl);
				   WebObjectUtil.clickElement(Admin.getUpgrade_EntityMgtTab());
				  //Counts entities from entity management dropdown 
				   countEntities();	
				   //if more than one page entities are there,it counts all pages
				   while(Admin.getUpgrade_EntityMgt_Nextbutton().isEnabled())
				   {
					   WebObjectUtil.clickElement(Admin.getUpgrade_EntityMgt_Nextbutton());
					   countEntities();
				   }
				   //selects entity from FLC in EB
				   WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
				   EntityBrowserTestCase.selectOrgFromAllLevelsEB(sFLCOrgData, "", "", "");
				   iSLCCount = WebTableUtil.getRowCount(EBPanel.getNav_secondLevelChildrenOrgTable());
				   //counts entities from SLC corresponding to parent entity in FLC in EB
				   for(int i=1;i<=iSLCCount;i++)
				   {
					   sChildOrgName = WebTableUtil.getCellData(EBPanel.getNav_secondLevelChildrenOrgTable(),i,1);
					   sChildOrgListFromEB.add(sChildOrgName);

				   }
				   
				   iChildOrgCount = sChildOrgList.size();
				   iChildOrgEBCount= sChildOrgListFromEB.size();
				  //verifies whether entities matches in EB and EM 
				   if(iChildOrgCount == iChildOrgEBCount )
				   {
					   for(int i=0;i<iChildOrgCount;i++)
					   {
			   
						   if (!sChildOrgList.get(i).equals(sChildOrgList.get(i)))
						   {
							  bStatus = false;
						   }
						   
					   }
					   FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Organizations are Matching");
				   }
				   else{
					   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "ChildOrgs", "fail", "Child Organizations are not matching"); 
				   }
				   			 
			} catch (Exception e) {
				LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyParentCountEMList", "warn", "catch block:Could NOT access webelement" +e.getMessage());	
			}

		}

		/*====================================================================================================
		Method Name 	: countEntities
		Description		: Counting Entities from Entity Management
		Creation Date 	: 08/25/2015
		Pre-Requisites	:
		Revision History:
		=====================================================================================================*/
		public static void countEntities()
		{
			 WebDriver driver = WebDriverUtil.getDriver();
			    PageFactory.initElements(driver, Admin);
			    
		    int iEMRowCount=0;
		    String sParentText = null,sChildText=null ;

		try {
			   
			   iEMRowCount = WebTableUtil.getRowCount(Admin.getUpgrade_EntityMgtTable());
			
		  for(int i=2;i<iEMRowCount;i++)
		 {
			   sParentText = WebTableUtil.getCellData(Admin.getUpgrade_EntityMgtTable(), i,2);
			   if(sParentText.contentEquals("4D Global"))
			   {
				   sChildText = WebTableUtil.getCellData(Admin.getUpgrade_EntityMgtTable(), i,1);
				   sChildOrgList.add(sChildText);
				   
			   }
			   
		 }
		} catch (Exception e) {
			LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "countEntities", "warn", "catch block:Could NOT access webelement" +e.getMessage());	
		}
		}
		
		/*====================================================================================================
		Method Name 	: verifyParentChildEntity
		Description		: Verifying the parent and corresponding child entities
		Author 			: QAA01
		Creation Date 	: 08/17/2015
		Pre-Requisites	:
		Revision History:
		=====================================================================================================*/

		public static void verifyParentChildEntity(String sChildorg,String sParentorg)
		{
			WebDriver driver = WebDriverUtil.getDriver();
		    PageFactory.initElements(driver, Admin);
		   
		   String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ISHANNON.USERID");
		   String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ISHANNON.PASSWORD");
		try {
		 	
			  LoginTestCase.nav_Login(sUserName, sPassword);
			//Checking whether the required parent and child entities are present
			  verifyOrg(sChildorg,sParentorg);
			
			  LoginTestCase.nav_Signout();
			
		} catch (Exception e) {
			LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyParentChildEntity", "warn", "catch block:Could NOT access webelement" +e.getMessage());
		}

		}


		
		/*====================================================================================================
		Method Name 	: verifyUserSelectParentEntityDropdown
		Description		: Verify valid and invalid Parents Selected for the same child in EM
		Author 			: QAA03
		Creation Date 	: 09/03/2015
		Pre-Requisites	:
		Revision History:
		=====================================================================================================*/

		public static void verifyUserSelectParentEntityDropdown()
		{
			    WebDriver driver = WebDriverUtil.getDriver();
			    PageFactory.initElements(driver, Admin);
			    
			    String sUrl = (String)FrameworkUtil.dictPropertyData.get("NAV.QA.UPGRADE.URL"); 	
			    String sChildorg = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY03"); 
			    String sParentorg1 = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.INVALID");
			    String sParentorg2 = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");

			    WebElement wChildorg,wParentOrg;
				boolean bParentOrgstatus = false;
				String sChildText=null,sParentText=null;
				
				
				try {
					driver.get(sUrl);
					WebObjectUtil.clickElement(Admin.getUpgrade_EntityMgtTab());
							
					//selecting the child from drop down
					WebObjectUtil.clickElement(Admin.getUpgrade_EntityMgtDropdownArrow());
					WebObjectUtil.SetValueEdit(Admin.getUpgrade_EntityMgtOrgEdit(), sChildorg);
					WebObjectUtil.explicitWait(2);
					//wChildorg=WebObjectUtil.GetWebElement("xpath", "//div[@id='x-auto-19']", "Child");
					wChildorg = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EBPANEL.CHILDORG","","");
					//selecting organization from drop down box in EM
					selectOrg(wChildorg,sChildorg);
					
					WebObjectUtil.clickElement(Admin.getUpgrade_EntityMgtParentElement());
					WebObjectUtil.clickElement(Admin.getUpgrade_EM_ChangeParentButton());
					//changing the parent
					WebObjectUtil.clickElement(Admin.getUpgrade_EM_ChangeParentArrow());
					WebObjectUtil.SetValueEdit(Admin.getUpgrade_EM_ChangeParentText(),sParentorg1);
					WebObjectUtil.clickElement(Admin.getUpgrade_EM_CPTextSaveButton());
				
					bParentOrgstatus =WebObjectUtil.isElementPresent(Admin.getUpgrade_EMErrorIcon());
					if(bParentOrgstatus)
					{
				    FrameworkUtil.updateCustomResultBasedOnStatus( bParentOrgstatus, "Not Able to Save Entity");
			        }
							
					WebObjectUtil.clickElement(Admin.getUpgrade_EMCancelButton());
					WebObjectUtil.clickElement(Admin.getUpgrade_EntityMgtParentElement());
					WebObjectUtil.clickElement(Admin.getUpgrade_EM_ChangeParentButton());
					//changing the parent
					WebObjectUtil.clickElement(Admin.getUpgrade_EM_ChangeParentArrow());
					WebObjectUtil.SetValueEdit(Admin.getUpgrade_EM_ChangeParentText(),sParentorg2);
					WebObjectUtil.explicitWait(2);
					//wParentOrg=WebObjectUtil.GetWebElement("xpath", "//div[@id='x-auto-23']", "Parent");
					wParentOrg = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EBPANEL.PARENTORG","","");
					//selecting organization from drop down box in EM
					selectOrg(wParentOrg,sParentorg2);
					
					WebObjectUtil.clickElement(Admin.getUpgrade_EM_CPTextSaveButton());
					WebObjectUtil.handleJSAlert();
					WebObjectUtil.clickElement(Admin.getUpgrade_EntityMgtDropdownArrow());
					WebObjectUtil.SetValueEdit(Admin.getUpgrade_EntityMgtOrgEdit(), sChildorg);
					WebObjectUtil.explicitWait(10);
					
				    //wChildorg=WebObjectUtil.GetWebElement("xpath", "//div[@id='x-auto-19']", "Child");
					wChildorg = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EBPANEL.CHILDORG","","");
				    //selecting organization from drop down box in EM
					selectOrg(wChildorg,sChildorg);
					
					//child
					sChildText = WebTableUtil.getCellData(Admin.getUpgrade_EntityMgtTable(), 2, 1);
					
					// parent
					sParentText = WebTableUtil.getCellData(Admin.getUpgrade_EntityMgtTable(), 2, 2);
					
					if(sChildText.contains(sChildorg) && sParentText.contains(sParentorg2))
					{
						
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "ParentChildData", "pass", "Parent and child entities are as expected");
					}	
					else
					{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "ParentChildData", "fail", "Parent and child entities are not as expected");
				    }
				    
				    
				} catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyUserSelectParentEntityDropdown", "warn", "catch block:" +e.getMessage());
				}
			
			}
		
		/*====================================================================================================
		Method Name 	: verifyOrg
		Description		: Verifying and setting the parents for corresponding child entities
		Author 			: QAA01
		Creation Date 	: 08/17/2015
		Pre-Requisites	:
		Revision History:
		=====================================================================================================*/

		public static void verifyOrg(String sChildorg,String sParentorg)
		{
		 WebDriver driver = WebDriverUtil.getDriver();
		 PageFactory.initElements(driver, Admin);
		 String sUrl = (String)FrameworkUtil.dictPropertyData.get("NAV.QA.UPGRADE.URL"); 	
			   
			int iRowCount;
			WebElement wChildorg,wParentorg;
			String sChildText=null, sParentText=null;
			
			
			try {
				//driver.get(sUrl);
				WebDriverUtil.navigateTo(sUrl);
				WebObjectUtil.clickElement(Admin.getUpgrade_EntityMgtTab());
						
				//selecting the child from dropdown
				WebObjectUtil.clickElement(Admin.getUpgrade_EntityMgtDropdownArrow());
				WebObjectUtil.SetValueEdit(Admin.getUpgrade_EntityMgtOrgEdit(), sChildorg);
				WebObjectUtil.explicitWait(10);
				
				//wChildorg=WebObjectUtil.GetWebElement("xpath", "//div[@id='x-auto-19']", "Child");
				 // This object is updated on 10/13/2015 By QAA04
				wChildorg = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EBPANEL.CHILDORG","","");
				selectOrg(wChildorg,sChildorg);
				
				iRowCount = WebTableUtil.getRowCount(Admin.getUpgrade_EntityMgtTable());
				
				for(int i=2;i<=iRowCount;i++)
				{
				//child
				sChildText = WebTableUtil.getCellData(Admin.getUpgrade_EntityMgtTable(), i, 1);
				
				// parent
				sParentText = WebTableUtil.getCellData(Admin.getUpgrade_EntityMgtTable(), i, 2);
				
				if(sChildText.contains(sChildorg) && sParentText.contains(sParentorg))
				{
					
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "ParentChildData", "pass", "Parent and child entities are as expected ");
				}	
				else
				{
					WebObjectUtil.clickElement(Admin.getUpgrade_EntityMgtParentElement());
					WebObjectUtil.clickElement(Admin.getUpgrade_EM_ChangeParentButton());
					WebObjectUtil.explicitWait(5);
					//changing the parent
					WebObjectUtil.clickElement(Admin.getUpgrade_EM_ChangeParentArrow());
					WebObjectUtil.SetValueEdit(Admin.getUpgrade_EM_ChangeParentText(),sParentorg);
					WebObjectUtil.explicitWait(10);
					//WebElement wParentorg=WebObjectUtil.GetWebElement("xpath", "//div[@id='x-auto-23']", "Parent");
					 // This object is updated on 10/13/2015 By QAA04
					wParentorg = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EBPANEL.PARENTORG","","");
					selectOrg(wParentorg,sParentorg);
					
					WebObjectUtil.clickElement(Admin.getUpgrade_EM_CPTextSaveButton());
					WebObjectUtil.handleJSAlert();
					//selecting the child
					WebObjectUtil.clickElement(Admin.getUpgrade_EntityMgtDropdownArrow());
					WebObjectUtil.SetValueEdit(Admin.getUpgrade_EntityMgtOrgEdit(), sChildorg);
					WebObjectUtil.explicitWait(10);
					
				   // wChildorg=WebObjectUtil.GetWebElement("xpath", "//div[@id='x-auto-19']", "Child");
					 // This object is updated on 10/13/2015 By QAA04
					wChildorg = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EBPANEL.CHILDORG","","");
					selectOrg(wChildorg,sChildorg);
					
					//child
					sChildText = WebTableUtil.getCellData(Admin.getUpgrade_EntityMgtTable(), 2, 1);
					
					// parent
					sParentText = WebTableUtil.getCellData(Admin.getUpgrade_EntityMgtTable(), 2, 2);
					
					if(sChildText.contains(sChildorg) && sParentText.contains(sParentorg))
					{
						
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "ParentChildData", "pass", "Parent and child entities are as expected");
					}	
					else
					{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "ParentChildData", "fail", "Parent and child entities are not as expected");
				    }
				}
				
				}
			} catch (Exception e) {
				LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyOrg", "warn", "catch block:Could NOT access webelement" +e.getMessage());
			}
			
			
		}
      /*====================================================================================================
		Method Name 	: selectOrg
		Description		: Selecting Organisations listed in as div type
		Author 			: Vivek
		Creation Date 	: 08/17/2015
		Pre-Requisites	:
		Revision History:
      =====================================================================================================*/
				
		
		public static boolean selectOrg(WebElement webElement,String sVisibleText){
			String sItem = null;
			boolean flag = false;
		    	try {
					if (WebObjectUtil.isElementPresent(webElement)){
						//WebObjectUtil.MouseHover(webElement);
						List<WebElement> webListItems = webElement.findElements(By.tagName("div"));
						for (WebElement wb: webListItems){
							sItem =wb.getText() ;
							if (sItem.contains(sVisibleText)){
								//WebObjectUtil.MouseHover(webElement);
								WebObjectUtil.explicitWait(2);
								wb.click();
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Select Item from Custom WebList", "pass", "Item selected: "+ sVisibleText);
								flag = true;
								break;
							}
						}
					}else{
		    			LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
			    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element NOT present", "fail", "Element not present/visible ");
		    		}
					if (!flag){
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Select Item from Custom WebList", "warn", "Item Not found/selected: "+ sVisibleText);	
					}
				} catch (Exception e) {
					LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "selectCustomWebList", "warn", "catch block:Could NOT access webelement" +e.getMessage());
				}
		    	return flag;
		}
		
		/*====================================================================================================
		Method Name 	: setTstEntityParent
		Description		: Setting Selected Parents for the Different Childs in both Entity Management and Entity Browser
		Author 			: QAA03
		Creation Date 	: 09/03/2015
		Pre-Requisites	:
		Revision History:
		=====================================================================================================*/

		public static void setTstEntityParent()
		{
			    WebDriver driver = WebDriverUtil.getDriver();
			    PageFactory.initElements(driver, EBPanel);
			    
			    String sMainOrg= (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.HOSTEDSOLUTIONS"); 
			    String sChildorg1 = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
			    String sChildorg2 = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY02");
			    String sChildorg3 = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY03");
			    String sChildorg4 = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY04");
			    
			    String sParentorg1 = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");	    
			    String sParentorg2 = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY02");
			    String sParentorg3 = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY03");
			    boolean bOrgOrder = false;
			
				
				try {
					// creating the parent as hosted solutions  for the TST Entity01
					verifyOrg(sChildorg1,sMainOrg);
					// creating the parent as TST Entity01  for the TST Entity02
					verifyOrg(sChildorg2,sParentorg1);
					// creating the parent as TST Entity02  for the TST Entity03
					verifyOrg(sChildorg3,sParentorg2);
					// creating the parent as TST Entity03  for the TST Entity04
					verifyOrg(sChildorg4,sParentorg3);
			
				    WebDriverUtil.refreshBrowser();
				    
				    WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
				    //checking the parent and child order is same in EB as created above
				    bOrgOrder = EntityBrowserTestCase.selectOrgFromAllLevelsEB(sChildorg1, sChildorg2, sChildorg3,sChildorg4);
				    FrameworkUtil.updateCustomResultBasedOnStatus(bOrgOrder, "EB Organizations have child entities as expected ");
				    
				} catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "setTstEntityParent", "warn", "catch block:" +e.getMessage());
				}
				
				
			}
		
		/////////***********************Keffer TestCase Method***************************//////////
		
		/*====================================================================================================
		Method Name 	: verifyPassingInvalidParentErrorMessage
		Description		: By passing invalid parent to child entity and verifying error message
		Author 			: QAA03
		Creation Date 	: 12/28/2015
		Pre-Requisites	:
		Revision History:
		=====================================================================================================*/

		public static void verifyPassingInvalidParentErrorMessage(String sChildorg,String sParentorg)
		{
		 WebDriver driver = WebDriverUtil.getDriver();
		 PageFactory.initElements(driver, Admin);
		 String sChangeParentErrorMsg = null,sAlertChangeParentMsg=null;
		 boolean bErrorMsgVerifiedStatus;
		 sChangeParentErrorMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.CHANGEPARENT.ERRORMESSAGE");
		 
			   
			int iRowCount;
			WebElement wChildorg,wParentorg;
			String sChildText=null, sParentText=null;
			
			
			try {
				
				WebObjectUtil.SetValueEdit(Admin.getUpgrade_EntityMgtOrgEdit(), sChildorg);
				WebObjectUtil.explicitWait(10);
				
				//wChildorg=WebObjectUtil.GetWebElement("xpath", "//div[@id='x-auto-19']", "Child");
				 // This object is updated on 10/13/2015 By QAA04
				wChildorg = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EBPANEL.CHILDORG","","");
				AdminTestCase.selectOrg(wChildorg,sChildorg);
				
				iRowCount = WebTableUtil.getRowCount(Admin.getUpgrade_EntityMgtTable());
				
				for(int i=2;i<=iRowCount;i++)
				{
				//child
				sChildText = WebTableUtil.getCellData(Admin.getUpgrade_EntityMgtTable(), i, 1);
				
				// parent
				sParentText = WebTableUtil.getCellData(Admin.getUpgrade_EntityMgtTable(), i, 2);
				
				if(sChildText.contains(sChildorg) && sParentText.contains(sParentorg))
				{
					
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "ParentChildData", "pass", "Parent and child entities are as expected ");
				}	
				else
				{
					WebObjectUtil.clickElement(Admin.getUpgrade_EntityMgtParentElement());
					WebObjectUtil.verifyElementPresent(Admin.getUpgrade_EM_ChangeParentButton());
					WebObjectUtil.clickElement(Admin.getUpgrade_EM_ChangeParentButton());
					//changing the parent
					WebObjectUtil.clickElement(Admin.getUpgrade_EM_ChangeParentArrow());
					WebObjectUtil.SetValueEdit(Admin.getUpgrade_EM_ChangeParentText(),sParentorg);
					WebObjectUtil.explicitWait(10);
					//WebElement wParentorg=WebObjectUtil.GetWebElement("xpath", "//div[@id='x-auto-23']", "Parent");
					 // This object is updated on 10/13/2015 By QAA04
					wParentorg = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EBPANEL.PARENTORG","","");
					AdminTestCase.selectOrg(wParentorg,sParentorg);
					
					//WebObjectUtil.clickElement(Admin.getUpgrade_EM_CPTextSaveButton());
					Admin.getUpgrade_EM_CPTextSaveButton().click();
					
					
					sAlertChangeParentMsg =WebObjectUtil.handleJSAlert();
					bErrorMsgVerifiedStatus = sAlertChangeParentMsg.contentEquals(sChangeParentErrorMsg);
					FrameworkUtil.updateCustomResultBasedOnStatus(bErrorMsgVerifiedStatus, "Change Parent Error Message");
					
				}
				
				}
			} catch (Exception e) {
				LoggerUtil.log_type_error("catch block: " + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyPassingInvalidParentErrorMessage", "warn", "catch block:Could NOT access webelement" +e.getMessage());
			}
			
			
		}


		
//update each @test result in custom result file
    @AfterMethod
    public static void afterEachMethod(){
	FrameworkUtil.updateTestCaseStatusinResult();
	FrameworkUtil.sTestExecutionStatus = true;
	
      }
}