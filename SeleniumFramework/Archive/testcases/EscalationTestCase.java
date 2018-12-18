package com.whs.navigator.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
import com.whs.navigator.pagefactory.CatalogPageFactory;
import com.whs.navigator.pagefactory.EM7PageFactory;
import com.whs.navigator.pagefactory.EVDCPageFactory;
import com.whs.navigator.pagefactory.EVDC_VM_AdvancedActions_PageFactory;
import com.whs.navigator.pagefactory.EscalationPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory;
import com.whs.navigator.pagefactory.SmokeTestPageFactory;
import com.whs.navigator.pagefactory.UserPermissionPageFactory;
import com.whs.navigator.commonUtil.CustomWebElementUtil;

public class EscalationTestCase {
	
	public static  EscalationPageFactory Escalation = new EscalationPageFactory();
	 public static UserPermissionPageFactory UserPermission = new UserPermissionPageFactory();
	 public static EM7PageFactory EM7 = new EM7PageFactory();
	 ///_____________________ Hague test cases ________________________________ ///
	 /*==============================================================
		TestScript 		: VerifyEscalationPage
		Manual TestCase	: QAT-292
		Description		: Verifing the pdf and csv icons
		Author 			: QAA04
		Creation Date 	: 11/30/2015
		release Name    : Hague
		Pre-Requisites	:
		Revision History:
		
		==============================================================*/
	    @Test(priority=1) 
	  
		  public void VerifyEscalationPage() {
	      String sCE_PDFIcon,sCE_CSVIcon;
	      boolean bCE_PDF,bCE_CSV;
	      try {
	      WebDriver driver =WebDriverUtil.getDriver();
		  PageFactory.initElements(driver, Escalation);
		 
		   FrameworkUtil.sTestCaseName ="VerifyEscalationPage";
		  FrameworkUtil.sManualTestCaseName="(QAT-292)Hague- verifying the pdf and csv icons";
		  FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		 // login to navigator
		 LoginTestCase.LoginAsRoleA();
		  UserPermissionTestCase.NavigateToCriticalEscalationListPage(); 
		  WebObjectUtil.explicitWait(10);
		  // verifying pdf and csv icons
		  WebObjectUtil.verifyElementPresent(Escalation.getNavCriticalEscalationPDFIcon());
		  sCE_PDFIcon =Escalation.getNavCriticalEscalationPDFIcon().getAttribute("style");
		  bCE_PDF = sCE_PDFIcon.contains("PDF");
		  FrameworkUtil.updateCustomResultBasedOnStatus(bCE_PDF, sCE_PDFIcon);
		  WebObjectUtil.verifyElementPresent(Escalation.getNavCriticalEscalationCSVIcon());
		  sCE_CSVIcon =Escalation.getNavCriticalEscalationCSVIcon().getAttribute("style");
		  bCE_CSV = sCE_CSVIcon.contains("CSV");
		  FrameworkUtil.updateCustomResultBasedOnStatus(bCE_PDF, sCE_CSVIcon);
		  // verifying the pdf and csv icons under authorized contact list tab
		  AuthorizedContactListPDFandCSVIcons();
		  // verifying the pdf and csv icons under deprovisedUsersList tab
		// DeprovisedUsersListPDFandCSVIcons();
		  
		  LoginTestCase.nav_Logout();
	      }
	      catch(Exception e) {
	    	  LoggerUtil.log_type_error("issue with VerifyEscalationPage test case");
	    	  LoggerUtil.log_type_error(e.getMessage());
	    	  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception accured", "fail", e.getMessage()+"null");
	      }
	  }



		/*==============================================================
		TestScript  	: verifyEscaltionListBrokenForOrg
		Manual TestCase	: [QAT-276] [WCP] Escalation List- Verify that the user with critical contact as Abuse is displayed on WCP for that org.
		Description		: Verify that the user with critical contact as Abuse is displayed on WCP for that org.
		Author 			: QAA03
		Creation Date 	: 12/04/2015
		Release Name    : Hague
		Pre-Requisites	:
		Revision History: Selecting username "ATest-E" and Organization "TST Devco1" from UserAccount Table
		EM7 -Registry - User Accounts -Edit Account Properties - "Save" button issue -so commented - QAA03
	==============================================================*/
		@Test(priority=4)
		public void verifyEscaltionListBrokenForOrg()
		{
			    WebDriver driver = WebDriverUtil.getDriver();
			    PageFactory.initElements(driver,EM7);
			    
			    PageFactory.initElements(driver,UserPermission);
			
			    String sUserName=null,sPassword=null,sUrl=null,sEM7UserName=null,sEM7Password=null,sUserToSelect=null,sOrgToSelect=null;
			    WebElement wRowelement,wRowActionsButton,wAccountText;
				int iRowNumber=1;
				String sParentWindowName=null,sCriticalContact=null,sAccText=null;
			   		
			
			try {
				FrameworkUtil.sTestCaseName ="verifyEscaltionListBrokenForOrg";
				FrameworkUtil.sManualTestCaseName="[QAT-276] [WCP] Escalation List- Verify that the user with critical contact as Abuse is displayed on WCP for that org.";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
				
				sEM7UserName = (String)FrameworkUtil.dictPropertyData.get("NAV.EM7.NAVUSER.USERID");
		 	    sEM7Password = (String)FrameworkUtil.dictPropertyData.get("NAV.EM7.NAVUSER.PASSWORD");
		 	    
				sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO1");
			    sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.PASSWORD");
			    
			    sUserToSelect = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.ATESTE");
			    sOrgToSelect = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
			    
			    sCriticalContact = (String)FrameworkUtil.dictPropertyData.get("NAV.EM7.USERACC.EDIT.CRITICALCONTACT");
			    sAccText=(String)FrameworkUtil.dictPropertyData.get("NAV.AUTOMATION.TEXT");
			    
			    WebDriverUtil.getDriver().get((String)FrameworkUtil.dictPropertyData.get("NAV.EM7.URL"));
				sUrl=driver.getCurrentUrl();
				
			    //Login to EM7
				EM7TestCase.EM7Login(sEM7UserName, sEM7Password);
				
				//Navigating to User Accounts Page in EM7
				navigatingToUserAccInEM7Page();
				
				// Clicking on Actions button for the row  selected by org and user
				clickActionsButtonbySelUserAndOrgNameInEM7(sOrgToSelect,sUserToSelect);
			    sParentWindowName = driver.getWindowHandle();
				//Switching to second window
			    
				WebObjectUtil.switchToWindow(2,"");
				
				WebObjectUtil.selectWebList(EM7.getEM7_UserAcc_EditAccProp_CriContact(),null,sCriticalContact,0);
			    
				//WebObjectUtil.MouseHover(EM7.getEM7_UserAcc_EditAccProp_SaveButton());
				WebObjectUtil.explicitWait(1);
				
				EM7.getEM7_UserAcc_EditAccProp_SaveButton().click();
				//WebObjectUtil.clickElement(EM7.getEM7_UserAcc_EditAccProp_SaveButton());
				/*JavascriptExecutor js = null;
				if (driver instanceof JavascriptExecutor) {
				    js = (JavascriptExecutor)driver;
				}
				js.executeScript("return confirmStd('save changes to this account?');");*/
				//WebObjectUtil.clickByActions(EM7.getEM7_UserAcc_EditAccProp_SaveButton());
			   // WebObjectUtil.clickElement(EM7.getEM7_UserAcc_EditAccProp_SaveButton());
			    WebObjectUtil.handleJSAlert();
			    
			    WebObjectUtil.verifyElementPresent(EM7.getEM7_UserAcc_EditAccProp_UpdatedSuccessfulMsg());
			    //Closing the second window
				driver.close();
				
				//Switching to parent window
				driver.switchTo().window(sParentWindowName);
				//Logout from EM7
				EM7TestCase.EM7Logout();               
			    
				//Navigating to Navigator page with that URL
				WebDriverUtil.getDriver().get((String)FrameworkUtil.dictPropertyData.get("NAV.QA.URL"));
				sUrl=driver.getCurrentUrl();
			    
				//Login to Navigator with devco1 user
				LoginTestCase.nav_Login(sUserName, sPassword);
				
				UserPermissionTestCase.NavigateToCriticalEscalationListPage();
				
				verifyLevelinCriticalEscalation(sUserToSelect,sCriticalContact);
				//Logout from Navigator
				LoginTestCase.nav_Logout();
				
				
				
			   } catch (Exception e) {
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyEscaltionListBrokenForOrg", "warn", "catch block:" +e.getMessage());
			}
	    }
		
	


		
		
	
	 ///_____________________ Completed Hague test cases ________________________________ ///
	
	/////////////////// Methods ////////////////////////////////////    
	    
	    /*==============================================================
		Method Name		: AuthorizedContactListPDFandCSVIcons
		Manual TestCase	: QAT-292
		Description		: Verifing the pdf and csv icons under Authorized contact list tab
		Author 			: QAA04
		Creation Date 	: 11/30/2015
		release Name    : Hague
		Pre-Requisites	:
		Revision History:
		
		==============================================================*/
	  public static void AuthorizedContactListPDFandCSVIcons() {
		  String sAC_PDFIcon,sAC_CSVIcon;
		  boolean bAC_PDF,bAC_CSV;
		  WebDriver driver = WebDriverUtil.getDriver();
		  PageFactory.initElements(driver, Escalation);
		  PageFactory.initElements(driver, UserPermission);
		  WebObjectUtil.clickElement(UserPermission.getNav_AuthorizedContactListTab());
		  WebObjectUtil.explicitWait(10);
		  WebObjectUtil.verifyElementPresent(Escalation.getNavAuthorizedContactList_PDFIcon());
		  sAC_PDFIcon =Escalation.getNavAuthorizedContactList_PDFIcon().getAttribute("style");
		  bAC_PDF = sAC_PDFIcon.contains("PDF");
		  FrameworkUtil.updateCustomResultBasedOnStatus(bAC_PDF, sAC_PDFIcon);
		  WebObjectUtil.verifyElementPresent(Escalation.getNavAuthorizedContactList_CSVIcon());
		  sAC_CSVIcon =Escalation.getNavAuthorizedContactList_CSVIcon().getAttribute("style");
		  bAC_CSV = sAC_CSVIcon.contains("CSV");
		  FrameworkUtil.updateCustomResultBasedOnStatus(bAC_CSV, sAC_CSVIcon);
	  }
	  
	  
	  /*==============================================================
		Method Name 	: DeprovisedUsersListPDFandCSVIcons
		Manual TestCase	: QAT-292
		Description		: Verifing the pdf and csv icons under deprovised users list
		Author 			: QAA04
		Creation Date 	: 11/30/2015
		release Name    : Hague
		Pre-Requisites	:
		Revision History:
		
		==============================================================*/
	  public static void DeprovisedUsersListPDFandCSVIcons() {
		  WebDriver driver = WebDriverUtil.getDriver();
		  PageFactory.initElements(driver, Escalation);
		  WebObjectUtil.clickElement(Escalation.getNavDeprovisedUsersLisTab());
		  WebObjectUtil.explicitWait(5);
		  WebObjectUtil.verifyElementPresent(Escalation.getNavDeprovisedUsersList_PdfIcon());
		  WebObjectUtil.verifyElementPresent(Escalation.getNavDeprovisedUsersList_CSVIcon());
		  
	  }
	    
	  /*====================================================================================================
		Method Name 	: verifyLevelinCriticalEscalation
		Description		: Verifying Level for User in Critical Escalation
		Author 			: QAA03
		Creation Date 	: 12/09/2015
		Pre-Requisites	:
		Revision History:
		====================================================================================================*/
		public static void verifyLevelinCriticalEscalation(String sUserToSelect,String sLevel)
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,UserPermission);
				String sCriticalLevel=null;
				int iRowNumber=0;
				WebElement wLevelElement;
				boolean bCriticalLevelStatus;
				
	     try {
	    	    CustomWebElementUtil.loadCustomElement(UserPermission.getNav_CriticalEscalationListTable(), "table");
	    	    iRowNumber = CustomWebElementUtil.getRowByCellText(sUserToSelect, 1);
	    	    wLevelElement=WebObjectUtil.getWebElementFromDynamicLocator("xpath","NAV.ESCALATION.CRITICAL.LEVEL.COLUMN", "PARAMETER_ROWNUMBER",iRowNumber+"");
	    	    sCriticalLevel = wLevelElement.getText();
	    	    bCriticalLevelStatus = sCriticalLevel.equalsIgnoreCase(sLevel);
	    	    FrameworkUtil.updateCustomResultBasedOnStatus(bCriticalLevelStatus, "Level for "+sUserToSelect+" in Critical Escalatiom");
	    	    
			 } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyLevelinCriticalEscalation", "warn", "catch block:" +e.getMessage());  
			}
			
		}
		/*====================================================================================================
		Method Name 	: navigatingToUserAccInEM7Page
		Description		: Navigating to User Accounts Page in EM7
		Author 			: QAA03
		Creation Date 	: 12/02/2015
		Pre-Requisites	:
		Revision History:
		====================================================================================================*/
		public static void navigatingToUserAccInEM7Page()
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,EM7);
			
	     try {   	
	    	    WebObjectUtil.clickElement(EM7.getEM7_RegistryButton());
				WebObjectUtil.clickElement(EM7.getEM7_Reg_AccountsButton());
				WebObjectUtil.clickElement(EM7.getEM7_Reg_Acc_UserAccButton());
				  
			 } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navigatingToUserAccInEM7Page", "warn", "catch block:" +e.getMessage());  
			}
			
		}
		
		/*====================================================================================================
		Method Name 	: clickActionsButtonbySelUserAndOrgNameInEM7
		Description		: Clicking on Actions button by selecting organization and user in UserAccounts Table in EM7
		Author 			: QAA03
		Creation Date 	: 12/08/2015
		Pre-Requisites	:
		Revision History:
		====================================================================================================*/
		public static void clickActionsButtonbySelUserAndOrgNameInEM7(String sOrgToSelect,String sUserToSelect)
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,EM7);
				int iRowNumber=1;
				WebElement wRowelement,wRowActionsButton;
				
			
	     try {
	    	    WebObjectUtil.waitForElementPresent(EM7.getEM7_Reg_Acc_UserTable());
				
				WebObjectUtil.SetValueEdit(EM7.getEM7_UserAcc_PriOrgEntryBox(), sOrgToSelect);
				WebObjectUtil.SetValueEdit(EM7.getEM7_UserAcc_UserEntryBox(), sUserToSelect);
				
				WebObjectUtil.waitForElementPresent(EM7.getEM7_Reg_Acc_UserTable());
				//Clicking on Edit Account Properties with organization selected from Users Table
				CustomWebElementUtil.loadCustomElement(EM7.getEM7_Reg_Acc_UserTable(), "tr");
			    //iRowNumber = CustomWebElementUtil.getRowByCellText(sOrgToSelect,1);
			    wRowelement=CustomWebElementUtil.getRowAsWebElement(iRowNumber);
			    wRowActionsButton = WebObjectUtil.getWebElementFromDynamicLocator("xpath","EM7.REGISTRY.ACC.USERACC.TABLE.EDITACCPROPERTIES", "PARAMETER_ROWNUMBER", iRowNumber+"");
			    WebObjectUtil.clickElement(wRowActionsButton);
			
			 } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "clickActionsButtonbySelUserAndOrgNameInEM7", "warn", "catch block:" +e.getMessage());  
			}
			
		}
	//update each @test result in custom result file
			@AfterMethod
			public static void afterEachMethod(){
				FrameworkUtil.updateTestCaseStatusinResult();
				FrameworkUtil.sTestExecutionStatus = true;
				
			}
}