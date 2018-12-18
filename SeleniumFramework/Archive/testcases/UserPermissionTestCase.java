package com.whs.navigator.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.crypto.dsig.keyinfo.PGPData;

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
import com.whs.navigator.pagefactory.CommonPageFactory;
import com.whs.navigator.pagefactory.EVDCPageFactory;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.EVDC_VM_AdvancedActions_PageFactory;
import com.whs.navigator.pagefactory.EVDC_VM_PageFactory;
import com.whs.navigator.pagefactory.FirewallPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory;
import com.whs.navigator.pagefactory.SmokeTestPageFactory;
import com.whs.navigator.pagefactory.UserPermissionPageFactory;
import com.whs.navigator.commonUtil.CustomWebElementUtil;
import com.whs.navigator.pagefactory.HomePageFactory;
import com.whs.navigator.pagefactory.TicketPageFactory;
import com.whs.navigator.pagefactory.DraasPageFactory;

public class UserPermissionTestCase {
	static UserPermissionPageFactory UserPermission = new UserPermissionPageFactory();
    static HomePageFactory HomePageFactory = new HomePageFactory();
	public static CatalogPageFactory Catalog=new CatalogPageFactory();
	public static EVDC_OverviewPageFactory EVDC_Overview= new EVDC_OverviewPageFactory();
	public static EVDC_VM_PageFactory EVDC_VMPF=new EVDC_VM_PageFactory();
	public static EVDC_VM_AdvancedActions_PageFactory EVDC_Advanced= new EVDC_VM_AdvancedActions_PageFactory();
	public static SmokeTestPageFactory smokeTest = new SmokeTestPageFactory();
	static CommonPageFactory CommonPF = new CommonPageFactory();
	public static HomePageFactory Home = new HomePageFactory();
	public static TicketPageFactory Ticket=new TicketPageFactory();
	public static DraasPageFactory Draas=new DraasPageFactory();
	public static FirewallPageFactory Firewall = new FirewallPageFactory();
    //static HomeTestCase HomeTestcase = new HomeTestCase();


	/*==============================================================
	TestScript 		: viewUserManagementPortal
	Manual TestCase	: Verify given user able to view User Management Portal
	Description		: Verify given user able to view User Management Portal
	Author 			: Arularasu
	Creation Date 	: 04/06/2015
	Pre-Requisites	:
	Revision History:
	
	==============================================================*/
	@Test(priority=1)
	public void viewUserManagementPortal(){
		String sUserName;
		String sPassword;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, UserPermissionTestCase.UserPermission);
		FrameworkUtil.sTestCaseName = "UserPermission-viewUserManagementPortal";
		FrameworkUtil.sManualTestCaseName="Verify given user able to view User Management Portal";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		AccessToUserManagement(sUserName, sPassword);
		LoginTestCase.nav_Logout();
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
		AccessToUserManagement(sUserName, sPassword);
		LoginTestCase.nav_Logout();
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
		noAccessToUserManagement(sUserName, sPassword);
		LoginTestCase.nav_Logout();
	}
	
	
	/*==============================================================
	TestScript 		: editRoleUserManagementPortal
	Manual TestCase	: Verify given user able to Edit role(change role) User Management Portal
	Description		: Verify given user able to Edit role(change role) User Management Portal
	Author 			: Arularasu
	Creation Date 	: 04/21/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=2)
	public void editRoleUserManagementPortal(){
		String sUserName;
		String sPassword;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, UserPermissionTestCase.UserPermission);
		FrameworkUtil.sTestCaseName = "UserPermission-editRoleUserManagementPortal";
		FrameworkUtil.sManualTestCaseName="Verify given user able to Edit role(change role) User Management Portal";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		AccessToUserManagement( sUserName, sPassword);
		WebObjectUtil.verifyElementPresent(UserPermission.getNav_UsersTab());
		editUserPermission();
		LoginTestCase.nav_Logout();
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
		AccessToUserManagement( sUserName, sPassword);
		WebObjectUtil.verifyElementPresent(UserPermission.getNav_UsersTab());
		editUserPermission();
		LoginTestCase.nav_Logout();
		

		
	}
	
	/*==============================================================
	TestScript 		: addRoleUserManagementPortal
	Manual TestCase	: Verify given user able to Add Role
	Description		: Verify given user able to Add Role
	Author 			: Arularasu
	Creation Date 	: 04/22/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=3)
	public void addRoleUserManagementPortal(){
		String sUserName;
		String sPassword;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, UserPermissionTestCase.UserPermission);
		FrameworkUtil.sTestCaseName = "UserPermission-addRoleUserManagementPortal";
		FrameworkUtil.sManualTestCaseName="Verify given user able to Add Role";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		AccessToUserManagement( sUserName, sPassword);
		WebObjectUtil.verifyElementPresent(UserPermission.getNav_UsersTab());
		addRoleUserPermission();
		LoginTestCase.nav_Logout();
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
		AccessToUserManagement( sUserName, sPassword);
		WebObjectUtil.verifyElementPresent(UserPermission.getNav_UsersTab());
		addRoleUserPermission();
		LoginTestCase.nav_Logout();
		

		
	}
	
	/*==============================================================
	TestScript 		: copyEditDeleteRoleUserManagementPortal
	Manual TestCase	: Verify given user able to Add Role
	Description		: Verify given user able to Add Role
	Author 			: Arularasu
	Creation Date 	: 04/24/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=4)
	public void copyEditDeleteRoleUserManagementPortal(){
		String sUserName,sNewRoleName;
		String sPassword;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, UserPermissionTestCase.UserPermission);
		FrameworkUtil.sTestCaseName = "UserPermission-copyEditDeleteRoleUserManagementPortal";
		FrameworkUtil.sManualTestCaseName="Verify given user able to Copy, Edit and Delete roles";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		AccessToUserManagement( sUserName, sPassword);
		WebObjectUtil.verifyElementPresent(UserPermission.getNav_UsersTab());
		sNewRoleName = copyRoleManageRoles();
		editRoleManageRoles(sNewRoleName);
		deleteRoleManageRoles(sNewRoleName);
		LoginTestCase.nav_Logout();
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
		AccessToUserManagement( sUserName, sPassword);
		WebObjectUtil.verifyElementPresent(UserPermission.getNav_UsersTab());
		sNewRoleName = copyRoleManageRoles();
		editRoleManageRoles(sNewRoleName);
		deleteRoleManageRoles(sNewRoleName);
		LoginTestCase.nav_Logout();
		

		
	}
	
	
	/*==============================================================
	TestScript 		: ViewTickets
	Manual TestCase	: Verify given user able to view ticket
	Description		: Verify given user able to view ticket
	Author 			: Arularasu
	Creation Date 	: 04/08/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=10)
	public void ViewTickets(){
		String sUserName;
		String sPassword;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, UserPermissionTestCase.UserPermission);
		FrameworkUtil.sTestCaseName = "UserPermission-ViewTickets";
		FrameworkUtil.sManualTestCaseName="Verify given users able to view Ticker details";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		AccessToViewTicket(sUserName, sPassword);
		LoginTestCase.nav_Logout();
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
		AccessToViewTicket(sUserName, sPassword);
		LoginTestCase.nav_Logout();
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
		AccessToViewTicket(sUserName, sPassword);
		LoginTestCase.nav_Logout();
	}
	

	/*==============================================================
	TestScript 		: editTickets
	Manual TestCase	: Verify given user able to view ticket
	Description		: Verify given user able to view ticket
	Author 			: Arularasu
	Creation Date 	: 04/10/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	@Test(priority=11)
	public void editTickets(){
		String sUserName;
		String sPassword;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, UserPermissionTestCase.UserPermission);
		FrameworkUtil.sTestCaseName = "UserPermission-editTickets";
		FrameworkUtil.sManualTestCaseName="Verify given users able to Edit Ticker details";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		AccessToEditTicket(sUserName, sPassword);
		LoginTestCase.nav_Logout();
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
		AccessToEditTicket(sUserName, sPassword);
		LoginTestCase.nav_Logout();
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
		AccessToEditTicket(sUserName, sPassword);
		LoginTestCase.nav_Logout();
	}
	

	
	
	
	/*==============================================================
	TestScript 		: accessToMountMedia
	Manual TestCase	: Verify given user able to Mount Media successfully
	Description		: Verify given user able to Mount Media successfully
	Author 			: Arularasu
	Creation Date 	: 04/27/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=20)
	public void accessToMountMedia(){
		String sUserName;
		String sPassword;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, UserPermissionTestCase.UserPermission);
		FrameworkUtil.sTestCaseName = "UserPermission-accessToMountMedia";
		FrameworkUtil.sManualTestCaseName="Verify given user able to Mount Media successfully";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		LoginTestCase.nav_Login(sUserName, sPassword);
		EVDC_VM_AdvancedActions.navigateAndExpandVM("Stopped");    //EVDC_VM_AdvancedActions.navigateAndExpandVM("test_Tomsmultivapp_abhi_local");
		EVDC_VM_AdvancedActions.verifyMountMedia();
		LoginTestCase.nav_Logout();
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
		LoginTestCase.nav_Login(sUserName, sPassword);
		EVDC_VM_AdvancedActions.navigateAndExpandVM("Stopped");    //EVDC_VM_AdvancedActions.navigateAndExpandVM("test_Tomsmultivapp_abhi_local");
		EVDC_VM_AdvancedActions.verifyMountMedia();
		LoginTestCase.nav_Logout();

	}
	
	
	/*==============================================================
	TestScript 		: noAccessToAdvancedAction
	Manual TestCase	: Verify given user unable to access advanced action
	Description		: Verify given user unable to access advanced action
	Author 			: Arularasu
	Creation Date 	: 04/28/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=21)
	public void noAccessToAdvancedAction(){
		String sUserName;
		String sPassword;
		boolean bAdvActions,bStatus;
		int iRowNo;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, UserPermissionTestCase.UserPermission);
		PageFactory.initElements(driver, EVDC_Advanced);
		PageFactory.initElements(driver, EVDC_Overview);
		PageFactory.initElements(driver, EVDC_VMPF);
		
		FrameworkUtil.sTestCaseName = "UserPermission-noAccessToAdvancedAction";
		FrameworkUtil.sManualTestCaseName="Verify given user unable to access advanced action";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
		LoginTestCase.nav_Login(sUserName, sPassword);
		//EVDC_VM_AdvancedActions.navigateAndExpandVM("Stopped");    //EVDC_VM_AdvancedActions.navigateAndExpandVM("test_Tomsmultivapp_abhi_local");
		
		WebObjectUtil.clickAndVerifyElement(EVDC_Overview.getNav_EVDCname(), EVDC_Overview.getNav_EVDCOverviewVirtualMachine());
		WebObjectUtil.clickElement(EVDC_Overview.getNav_EVDCOverviewVirtualMachine());
		iRowNo = EVDC_VM_AdvancedActions.getRow_EVDC_VMTable(EVDC_VMPF.getNav_VMWebTable(),"Stopped","");
		if (iRowNo > 0 ){
			bStatus = true;
			EVDC_VM_AdvancedActions.expandVMbyRowNum(iRowNo);
		}
		bAdvActions = WebObjectUtil.isElementPresent(EVDC_Advanced.getNav_EVDCAdvancedActionsLink()); 
		if (!bAdvActions){
			FrameworkUtil.updateCustomResultBasedOnStatus(true, "user ROLE-E does not have access to Advanced Actions");
		}else{
			FrameworkUtil.updateCustomResultBasedOnStatus(false, "user ROLE-E have access to Advanced Actions but should not");
		}
		
		LoginTestCase.nav_Logout();
		

	}
	
	
	/*==============================================================
	TestScript 		: accessToEjectMedia
	Manual TestCase	: Verify given user able to Eject Media successfully
	Description		: Verify given user able to Eject Media successfully
	Author 			: Arularasu
	Creation Date 	: 04/28/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=22)
	public void accessToEjectMedia(){
		String sUserName;
		String sPassword;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, UserPermissionTestCase.UserPermission);
		FrameworkUtil.sTestCaseName = "UserPermission-accessToEjectMedia";
		FrameworkUtil.sManualTestCaseName="Verify given user able to Eject Media successfully";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		LoginTestCase.nav_Login(sUserName, sPassword);
		EVDC_VM_AdvancedActions.navigateAndExpandVM("Stopped");    //EVDC_VM_AdvancedActions.navigateAndExpandVM("test_Tomsmultivapp_abhi_local");
		EVDC_VM_AdvancedActions.verifyEjectMedia();
		LoginTestCase.nav_Logout();
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
		LoginTestCase.nav_Login(sUserName, sPassword);
		EVDC_VM_AdvancedActions.navigateAndExpandVM("Stopped");    //EVDC_VM_AdvancedActions.navigateAndExpandVM("test_Tomsmultivapp_abhi_local");
		EVDC_VM_AdvancedActions.verifyEjectMedia();
		LoginTestCase.nav_Logout();

	}
	
	
	
	/*==============================================================
	TestScript 		: accessToSaveVMasTemplate
	Manual TestCase	: Verify given user able to  Save VM as Template  successfully
	Description		: Verify given user able to  Save VM as Template  successfully
	Author 			: Arularasu
	Creation Date 	: 04/29/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=23)
	public void accessToSaveVMasTemplate(){
		String sUserName;
		String sPassword;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, UserPermissionTestCase.UserPermission);
		FrameworkUtil.sTestCaseName = "UserPermission-accessToSaveVMasTemplate";
		FrameworkUtil.sManualTestCaseName="Verify given user able to  Save VM as Template  successfully";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		LoginTestCase.nav_Login(sUserName, sPassword);
		EVDC_VM_AdvancedActions.navigateAndExpandVM("Stopped");    //EVDC_VM_AdvancedActions.navigateAndExpandVM("test_Tomsmultivapp_abhi_local");
		String sTemplateName = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.SAVEASTEMPLATE.NAME") ;
		FrameworkUtil.dictPropertyData.put("NAV.EVDC.SAVEASTEMPLATE.NAME", sTemplateName+"_"+sUserName+"_");
		EVDC_VM_AdvancedActions.saveVMasTemplate();
		LoginTestCase.nav_Logout();
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
		LoginTestCase.nav_Login(sUserName, sPassword);
		EVDC_VM_AdvancedActions.navigateAndExpandVM("Stopped");    //EVDC_VM_AdvancedActions.navigateAndExpandVM("test_Tomsmultivapp_abhi_local");
		FrameworkUtil.dictPropertyData.put("NAV.EVDC.SAVEASTEMPLATE.NAME", sTemplateName+"_"+sUserName+"_");
		EVDC_VM_AdvancedActions.saveVMasTemplate();
		LoginTestCase.nav_Logout();

	}


	/*==============================================================
	TestScript 		: accessToDeleteVM
	Manual TestCase	: Verify given user able to  Delete VM successfully
	Description		: Verify given user able to  Delete VM successfully
	Author 			: Arularasu
	Creation Date 	: 04/29/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=24)
	public void accessToDeleteVM(){
		String sUserName;
		String sPassword;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, UserPermissionTestCase.UserPermission);
		FrameworkUtil.sTestCaseName = "UserPermission-accessToDeleteVM";
		FrameworkUtil.sManualTestCaseName="Verify given user able to  Delete VM successfully";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		LoginTestCase.nav_Login(sUserName, sPassword);
		EVDC_VM_AdvancedActions.navigateAndExpandVM("Stopped");    //EVDC_VM_AdvancedActions.navigateAndExpandVM("test_Tomsmultivapp_abhi_local");
		EVDC_VM_AdvancedActions.verifyDeleteVM();
		LoginTestCase.nav_Logout();
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
		LoginTestCase.nav_Login(sUserName, sPassword);
		EVDC_VM_AdvancedActions.navigateAndExpandVM("Stopped");    //EVDC_VM_AdvancedActions.navigateAndExpandVM("test_Tomsmultivapp_abhi_local");
		EVDC_VM_AdvancedActions.verifyDeleteVM();
		LoginTestCase.nav_Logout();

	}
	
	

	/*==============================================================
	TestScript 		: accessToCopyVM
	Manual TestCase	: Verify given user able to  Copy VM successfully
	Description		: Verify given user able to  Copy VM successfully
	Author 			: Arularasu
	Creation Date 	: 04/29/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=25)
	public void accessToCopyVM(){
		String sUserName;
		String sPassword;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, UserPermissionTestCase.UserPermission);
		FrameworkUtil.sTestCaseName = "UserPermission-accessToCopyVM";
		FrameworkUtil.sManualTestCaseName="Verify given user able to  Copy VM successfully";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		//FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sTestCaseName , "TestcaseName", "Done", FrameworkUtil.sTestCaseName);
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		LoginTestCase.nav_Login(sUserName, sPassword);
		EVDC_VM_AdvancedActions.navigateAndExpandVM("Stopped");    //EVDC_VM_AdvancedActions.navigateAndExpandVM("test_Tomsmultivapp_abhi_local");
		EVDC_VM_AdvancedActions.verifyCopyVM();
		LoginTestCase.nav_Logout();
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
		LoginTestCase.nav_Login(sUserName, sPassword);
		EVDC_VM_AdvancedActions.navigateAndExpandVM("Stopped");    //EVDC_VM_AdvancedActions.navigateAndExpandVM("test_Tomsmultivapp_abhi_local");
		EVDC_VM_AdvancedActions.verifyCopyVM();
		LoginTestCase.nav_Logout();

	}
	
	
	
	
	/*==============================================================
	MethodName 		: AccessToUserManagement
	Manual TestCase	: Verify given user able to view User Management Portal
	Description		: Verify given user able to view User Management Portal
	Author 			: Arularasu
	Creation Date 	: 03/26/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void AccessToUserManagement(String sUserName,String sPassword){

		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, UserPermissionTestCase.UserPermission);
		LoginTestCase.nav_Login(sUserName, sPassword);
		//String sUMUrl = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.URL");
		//WebDriverUtil.getDriver().get(sUMUrl);
		
		//Click Account Link 
		WebObjectUtil.ClickAndMouseHover(UserPermission.getNav_AccountLink());
		WebObjectUtil.clickElement(UserPermission.getNav_PermissionsLink());
		WebDriverUtil.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		String sUnAvailableMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.UNAVAILABLE");
		String sUnAvailableText =UserPermission.getNav_UserManagementUnAvaiableErrorMsg().getText();
		if (sUnAvailableText.contains(sUnAvailableMsg)){
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Access User Permission Portal", "fail", "User Permission Portal is down");
		}
		
		WebObjectUtil.verifyElementPresent(UserPermission.getNav_UsersTab());
		boolean bStatus = WebObjectUtil.isElementPresent(UserPermission.getNav_UsersTab());
		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, sUserName + " has User permission");
		
		
	}
	
	
	/*==============================================================
	MethodName 		: noAccessToUserManagement
	Manual TestCase	: Verify given user should not have access to view User Management Portal
	Description		: Verify given user  should not have access to view User Management Portal
	Author 			: Arularasu
	Creation Date 	: 03/26/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	void noAccessToUserManagement(String sUserName,String sPassword){
		
		LoginTestCase.nav_Login(sUserName, sPassword);
		
		//Click Account Link 
		WebObjectUtil.ClickAndMouseHover(UserPermission.getNav_AccountLink());
		//WebObjectUtil.clickElement(UserPermission.getNav_PermissionsLink());
		WebDriverUtil.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		boolean bStatus = WebObjectUtil.isElementPresent(UserPermission.getNav_PermissionsLink());
		//check for User tab not present
		if (!bStatus){
			FrameworkUtil.updateCustomResultBasedOnStatus(true, sUserName + " do not have access to User Permission");
		}else{
			FrameworkUtil.updateCustomResultBasedOnStatus(false, sUserName + " have access to User Permission, but should not");
		}
		String sUnAvailableMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.UNAVAILABLE");
		String sUnAvailableText =UserPermission.getNav_UserManagementUnAvaiableErrorMsg().getText();
		if (sUnAvailableText.contains(sUnAvailableMsg)){
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Access User Permission Portal", "fail", "User Permission Portal is down");
		}
/*		boolean bStatus = WebObjectUtil.isElementPresent(UserPermission.getNav_UsersTab());
		//check for User tab not present
		if (!bStatus){
		FrameworkUtil.updateCustomResultBasedOnStatus(true, sUserName + " do not have access to User Permission");
		}*/
		
	}
	
	/*==============================================================
	MethodName 		: editUserPermission
	Manual TestCase	: Verify given user able to Edit role(change role) User Management Portal
	Description		: Verify given user able to Edit role(change role) User Management Portal
	Author 			: Arularasu
	Creation Date 	: 04/15/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void editUserPermission(){
		String sSuccessMsg,sRole1,sRole2,sSelectedItem,sUser_name,sUserRoleDropDownLocator,sUserRoleWebListLocator;
		String sRoleName;
		WebElement wUserRoleDropDown,wUserRoleWebList;

		//System.out.println(WebTableUtil.getRowCount(UserPermission.getNav_UserTable()));
		sUser_name  = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.USERNAME");
		sSuccessMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.EDITROLE.FEEDBACKMSG") + sUser_name;
		sRole1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.ROLE1");
		sRole2 = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.ROLE2");
		int iRowNo = WebTableUtil.getRowByCellText(UserPermission.getNav_UserTable(), sUser_name, 0,1);
		WebElement row = WebTableUtil.getRowAsWebElement(UserPermission.getNav_UserTable(), iRowNo);
		WebObjectUtil.clickElement(row);
		//System.out.println(row.getText());
		
		//This line Updated on 10/13/2015 by QAA03 for EXTJS5
		//sUserRoleWebListLocator = "//tr[" + iRowNo + "]//td[4]//div[contains(@class,'x-grid-cell-inner')]";
		//sUserRoleWebListLocator = "//table[" + iRowNo + "]//td[4]//div[contains(@class,'x-grid-cell-inner')]//div[contains(@class,'x-form-arrow-trigger-default')]";
		sUserRoleWebListLocator ="//div[@id='userListPanel-body']//table[" + iRowNo + "]/tbody/tr/td[4]/div[contains(@class,'x-grid-cell-inner')]//div[contains(@class,'x-form-arrow-trigger-default')]";
		wUserRoleWebList = WebObjectUtil.GetWebElement("xpath", sUserRoleWebListLocator, "UserRoleWebList");
		WebObjectUtil.clickElement(wUserRoleWebList);
		WebObjectUtil.explicitWait(2);
/*		WebObjectUtil.clickElement(wUserRoleWebList);
		WebObjectUtil.explicitWait(2);
		WebObjectUtil.clickElement(wUserRoleWebList);
		WebObjectUtil.explicitWait(2);
		WebObjectUtil.clickElement(UserPermission.getNav_UserRoleDropDownAsEdit());
*/
	/*
		//sUserRoleDropDownLocator = "//tr[" + iRowNo + "]//td//div//div[contains(@class,'x-form-trigger x-form-trigger-default x-form-arrow-trigger x-form-arrow-trigger-default')]/..";
		sUserRoleDropDownLocator = "//tr[" + iRowNo + "]//td//div//div[contains(@class,'x-form-trigger x-form-trigger-default x-form-arrow-trigger x-form-arrow-trigger-default')]";
		wUserRoleDropDown = WebObjectUtil.GetWebElement("xpath", sUserRoleDropDownLocator, "UserRoleDropDown");
		
		WebObjectUtil.explicitWait(2);
		//WebObjectUtil.ClickAndMouseHover(wUserRoleDropDown);
	*/	if (!WebObjectUtil.isElementPresent(UserPermission.getNav_UserRoleDropDown())){
			WebObjectUtil.clickElement(wUserRoleWebList);
		}

		sSelectedItem = UserPermission.getNav_UserRoleDropDownAsEdit().getAttribute("value");
		
		if (!WebObjectUtil.isElementPresent(UserPermission.getNav_UserRoleDropDown())){
			WebObjectUtil.clickElement(wUserRoleWebList);
		}
		
		if (sSelectedItem.equalsIgnoreCase(sRole1)){
		WebObjectUtil.selectCustomWebList(UserPermission.getNav_UserRoleDropDown(), sRole2);
		sRoleName = sRole2;
		}else{
		WebObjectUtil.selectCustomWebList(UserPermission.getNav_UserRoleDropDown(), sRole1);
		sRoleName = sRole1;
		}
		//WebDriverUtil.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebObjectUtil.explicitWait(5);
		WebObjectUtil.VerifyTextUnderElement(UserPermission.getNav_Feedbackportlet(), sSuccessMsg);

	}
	
		
	/*==============================================================
	MethodName 		: addRoleUserPermission
	Manual TestCase	: add new user role under User Management Portal
	Description		: add new user role under User Management Portal
	Author 			: Arularasu
	Creation Date 	: 04/21/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void addRoleUserPermission(){
		String sPopupMsg,sFeedbackMsg,sFirstName,sLasttName,sEmail,sPhone,sCell;
	
		try {
			sPopupMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.ADDROLE.POPUPMSG");
			sFeedbackMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.ADDROLE.FEEDBACKMSG");
			sFirstName = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.ADDROLE.FIRSTNAME")+ FrameworkUtil.sTimeStamp;
			sLasttName = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.ADDROLE.LASTNAME");
			sEmail = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.ADDROLE.EMAIL");
			sPhone = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.ADDROLE.PHONE");
			sCell = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.ADDROLE.CELL");

			WebObjectUtil.waitForPageLoad();
			WebObjectUtil.clickElement(UserPermission.getNav_AddUserRoleLink());
			WebObjectUtil.SetValueEdit(UserPermission.getNav_FirstNameEdit(), sFirstName);
			WebObjectUtil.SetValueEdit(UserPermission.getNav_LastNameEdit(), sLasttName);
			WebObjectUtil.SetValueEdit(UserPermission.getNav_EmailAddressEdit(), sEmail);
			WebObjectUtil.SetValueEdit(UserPermission.getNav_PhoneEdit(), sPhone);
			WebObjectUtil.SetValueEdit(UserPermission.getNav_CellEdit(), sCell);
			WebObjectUtil.explicitWait(3);
			WebObjectUtil.clickElement(UserPermission.getNav_AddUserOKbtn());
			
			WebObjectUtil.waitForElementNotPresent(UserPermission.getNav_ProgressBar());
			WebObjectUtil.VerifyTextUnderElement(UserPermission.getNav_ConfirmPopup(), sPopupMsg);
			WebObjectUtil.clickElement(UserPermission.getNav_ConfirmPopupOkBtn());
			WebObjectUtil.VerifyTextUnderElement(UserPermission.getNav_Feedbackportlet(), sFeedbackMsg);
		} catch (Exception e) {
			LoggerUtil.log_type_error("Exception Occured :" + e.getMessage());
	    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception Occured", "warn", "Exception Occured :" + e.getMessage());
	     
		}
	}
	
	/*==============================================================
	MethodName 		: copyRoleManageRoles
	Manual TestCase	: copy existing role as new user role under User Management Portal
	Description		: copy existing role as new user role under User Management Portal
	Author 			: Arularasu
	Creation Date 	: 04/23/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static String copyRoleManageRoles(){
		String sRoleName,sRoleNameLocator,sGetSuccessMsg,sCopySuccessMsg,sSuccessMsg;
		WebElement RoleName;
		
		sCopySuccessMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.COPYROLE.SUCCESSMSG");
		sRoleName = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.MANAGE.ROLENAME");

		WebObjectUtil.clickElement(UserPermission.getNav_ManageRolesTab());
		WebDriverUtil.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		int iRoleIndex = getRoleIndex(sRoleName);
		//This below lines updated on 10/13/2015 by QAA03 for EXTJS5
		 //sRoleNameLocator = "idRolePanel" + iRoleIndex + "_header_hd-textEl";
		//RoleName = WebObjectUtil.GetWebElement("id", sRoleNameLocator, "Role Name");
		 sRoleNameLocator = "idRolePanel" + iRoleIndex;
		 RoleName = WebObjectUtil.GetWebElement("xpath", "//div[@id='"+sRoleNameLocator+"']//div[contains(@id,'-textEl')]", "Role Name");
		 WebObjectUtil.clickElement(RoleName);
		
		String sCopyLocator = "//div[@id='idRolePanel" + iRoleIndex + "']//span[text()='Copy']";
		WebElement CopyBtn = WebObjectUtil.GetWebElement("xpath", sCopyLocator, "Copy Button");
		WebObjectUtil.clickElement(CopyBtn);
		
		
		//String sRoleSaveAs =  (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.NEWROLENAME")+ FrameworkUtil.sTimeStamp;
		String sRoleSaveAs =  (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.NEWROLENAME")+ FrameworkUtil.date_yyyyMMdd()+ "_" + FrameworkUtil.date_HHmmss();
		WebObjectUtil.SetValueEdit(UserPermission.getNav_SaveRoleAsEdit(), sRoleSaveAs);
		WebObjectUtil.clickElement(UserPermission.getNav_SaveBtn());
		
		
		if(WebObjectUtil.isElementPresent(UserPermission.getNav_ConfirmPopup())){
			sGetSuccessMsg = UserPermission.getNav_popupMsg().getText();
			boolean bStatus = sGetSuccessMsg.equalsIgnoreCase(sCopySuccessMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, sGetSuccessMsg);
			WebObjectUtil.clickElement(UserPermission.getNav_PopupOkBtn());
		}
		return sRoleSaveAs;
	}
	
	/*==============================================================
	MethodName 		: copyRoleManageRoles
	Manual TestCase	: copy existing role as new user role under User Management Portal
	Description		: copy existing role as new user role under User Management Portal
	Author 			: Arularasu
	Creation Date 	: 04/23/2015
	Pre-Requisites	:
	Revision History:Updated by Sukur Babu. Added a parameter sRoleName
	==============================================================*/
	public static String copyRoleManageRoles(String sRoleName){
		String sRoleNameLocator,sGetSuccessMsg,sCopySuccessMsg,sSuccessMsg;
		WebElement RoleName;
		
		sCopySuccessMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.COPYROLE.SUCCESSMSG");
		//sRoleName = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.MANAGE.ROLENAME");

		WebObjectUtil.clickElement(UserPermission.getNav_ManageRolesTab());
		WebDriverUtil.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		int iRoleIndex = getRoleIndex(sRoleName);
		//This below lines updated on 10/13/2015 by QAA03 for EXTJS5
		 //sRoleNameLocator = "idRolePanel" + iRoleIndex + "_header_hd-textEl";
		//RoleName = WebObjectUtil.GetWebElement("id", sRoleNameLocator, "Role Name");
		 sRoleNameLocator = "idRolePanel" + iRoleIndex;
		 RoleName = WebObjectUtil.GetWebElement("xpath", "//div[@id='"+sRoleNameLocator+"']//div[contains(@id,'-textEl')]", "Role Name");
		 WebObjectUtil.clickElement(RoleName);
		
		String sCopyLocator = "//div[@id='idRolePanel" + iRoleIndex + "']//span[text()='Copy']";
		WebElement CopyBtn = WebObjectUtil.GetWebElement("xpath", sCopyLocator, "Copy Button");
		WebObjectUtil.clickElement(CopyBtn);
		
		
		//String sRoleSaveAs =  (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.NEWROLENAME")+ FrameworkUtil.sTimeStamp;
		String sRoleSaveAs =  (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.NEWROLENAME")+ FrameworkUtil.date_yyyyMMdd()+ "_" + FrameworkUtil.date_HHmmss();
		WebObjectUtil.SetValueEdit(UserPermission.getNav_SaveRoleAsEdit(), sRoleSaveAs);
		WebObjectUtil.clickElement(UserPermission.getNav_SaveBtn());
		
		
		if(WebObjectUtil.isElementPresent(UserPermission.getNav_ConfirmPopup())){
			sGetSuccessMsg = UserPermission.getNav_popupMsg().getText();
			boolean bStatus = sGetSuccessMsg.equalsIgnoreCase(sCopySuccessMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, sGetSuccessMsg);
			WebObjectUtil.clickElement(UserPermission.getNav_PopupOkBtn());
		}
		return sRoleSaveAs;
	}
		

	/*==============================================================
	MethodName 		: editRoleManageRoles
	Manual TestCase	: copy existing role as new user role under User Management Portal
	Description		: copy existing role as new user role under User Management Portal
	Author 			: Arularasu
	Creation Date 	: 04/24/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void editRoleManageRoles(String sNewRoleName){
		String sRoleName,sRoleNameLocator,sGetSuccessMsg,sEditSuccessMsg;
		int iRoleIndex;
		WebElement RoleName;
		
		sEditSuccessMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.EDITROLE.SUCCESSMSG");
		
			iRoleIndex = getRoleIndex(sNewRoleName);
			//This below lines updated on 10/13/2015 by QAA03 for EXTJS5
			 //sRoleNameLocator = "idRolePanel" + iRoleIndex + "_header_hd-textEl";
			//RoleName = WebObjectUtil.GetWebElement("id", sRoleNameLocator, "Role Name");
			 sRoleNameLocator = "idRolePanel" + iRoleIndex;
			 RoleName = WebObjectUtil.GetWebElement("xpath", "//div[@id='"+sRoleNameLocator+"']//div[contains(@id,'-textEl')]", "Role Name");
			
			
			WebObjectUtil.clickElement(RoleName);
			
			String sEditLocator = "//div[@id='idRolePanel" + iRoleIndex + "']//span[text()='Edit']";
			WebElement EditBtn = WebObjectUtil.GetWebElement("xpath", sEditLocator, "Edit Button");
			WebObjectUtil.clickElement(EditBtn);
			
			WebObjectUtil.clickElement(UserPermission.getNav_EditRole_ExpandAllCheckBox());
			WebObjectUtil.clickElement(UserPermission.getNav_EditRole_AddUserCheckBox());
			WebObjectUtil.clickElement(UserPermission.getNav_EditRole_DeleteUserCheckBox());
			WebObjectUtil.clickElement(UserPermission.getNav_EditRole_SaveBtn());
			
			//WebDriverUtil.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_ConfirmPopup());
			sGetSuccessMsg = UserPermission.getNav_popupMsg().getText();
			boolean bStatus = sGetSuccessMsg.equalsIgnoreCase(sEditSuccessMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, sGetSuccessMsg);
			WebObjectUtil.clickElement(UserPermission.getNav_PopupOkBtn());
			WebObjectUtil.VerifyTextUnderElement(UserPermission.getNav_Feedbackportlet(), sEditSuccessMsg);
	
		}
		
	/*==============================================================
	MethodName 		: deleteRoleManageRoles
	Manual TestCase	: copy existing role as new user role under User Management Portal
	Description		: copy existing role as new user role under User Management Portal
	Author 			: Arularasu
	Creation Date 	: 04/24/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void deleteRoleManageRoles(String sRoleName){
		String sRoleNameLocator,sDeleteLocator,sGetSuccessMsg,sDeleteSuccessMsg,sFeedbackMsg;
		int iRoleIndex;
		WebElement RoleName;
		
		sDeleteSuccessMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.DELETEROLE.SUCCESSMSG");
		sFeedbackMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.DELETEROLE.FEEDBACKMSG");
		
			iRoleIndex = getRoleIndex(sRoleName);
			//This below lines updated on 10/13/2015 by QAA03 for EXTJS5
			 //sRoleNameLocator = "idRolePanel" + iRoleIndex + "_header_hd-textEl";
			//RoleName = WebObjectUtil.GetWebElement("id", sRoleNameLocator, "Role Name");
			 sRoleNameLocator = "idRolePanel" + iRoleIndex;
			 RoleName = WebObjectUtil.GetWebElement("xpath", "//div[@id='"+sRoleNameLocator+"']//div[contains(@id,'-textEl')]", "Role Name");
			WebObjectUtil.clickElement(RoleName);
			
			sDeleteLocator = "//div[@id='idRolePanel" + iRoleIndex + "']//span[text()='Delete']";
			WebElement DeleteBtn = WebObjectUtil.GetWebElement("xpath", sDeleteLocator, "Delete Button");
			WebObjectUtil.clickElement(DeleteBtn);
			
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_ConfirmPopup());
			sGetSuccessMsg = UserPermission.getNav_popupMsg().getText();
			boolean bStatus = sGetSuccessMsg.equalsIgnoreCase(sDeleteSuccessMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, sGetSuccessMsg);
			WebObjectUtil.clickElement(UserPermission.getNav_PopupOkBtn());
			WebObjectUtil.VerifyTextUnderElement(UserPermission.getNav_Feedbackportlet(), sFeedbackMsg);
	
		}
	
	/*==============================================================
	MethodName 		: AccessToViewTicket
	Manual TestCase	: view User Management Portal
	Description		: view User Management Portal
	Author 			: Arularasu
	Creation Date 	: 04/06/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void AccessToViewTicket(String sUserName,String sPassword){
		LoginTestCase.nav_Login(sUserName, sPassword);
		WebObjectUtil.clickElement(UserPermission.getNav_TicketPortalLink());
		//boolean bstatus = WebObjectUtil.isElementPresent(UserPermission.getNav_TicketTable());
		//boolean bstatus = WebObjectUtil.isElementPresent(UserPermission.getNav_TicketOrgWebList());
		boolean bstatus = WebObjectUtil.isElementPresent(UserPermission.getNav_CreateTicketLink());
		FrameworkUtil.updateCustomResultBasedOnStatus(bstatus, sUserName + " access to User Management portal" );
		
	}
	
	/*==============================================================
	MethodName 		: AccessToEditTicket
	Manual TestCase	: view User Management Portal
	Description		: view User Management Portal
	Author 			: Arularasu
	Creation Date 	: 04/15/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void AccessToEditTicket(String sUserName,String sPassword){
		WebElement NoteiFrame;
		boolean bstatus,bDetailsStatus;
		String spopupUpdateErrMsg,spopupNoteErrMsg,sPopupMsg,sDetailValue,sTicketDetails, sNotesDetails ;
		
		LoginTestCase.nav_Login(sUserName, sPassword);
		WebObjectUtil.clickElement(UserPermission.getNav_TicketPortalLink());
		WebObjectUtil.waitForPageLoad();
		bstatus = WebObjectUtil.isElementPresent(UserPermission.getNav_TicketOrgWebList());
		if (bstatus){
		WebObjectUtil.SetValueEdit(UserPermission.getNav_TicketSearchByList(), "Ticket ID or Title");
		WebObjectUtil.SetValueEdit(UserPermission.getNav_TicketSearchEdit(), "selenium");
		WebObjectUtil.clickElement(UserPermission.getNav_TicketSearchBtn());
		WebDriverUtil.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebObjectUtil.explicitWait(5);
		WebObjectUtil.clickElement(UserPermission.getNav_TicketTableRow1());
		WebObjectUtil.clickElement(UserPermission.getNav_DetailsTab());
		
		sTicketDetails = (String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.DETAILS") + "_" + sUserName + "_" + FrameworkUtil.sTimeStamp;
		spopupUpdateErrMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.UPDATE.ERRORMSG");
		spopupNoteErrMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.NOTE.ERRORMSG");
		sNotesDetails = (String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.NOTE.DESCRIPTION") + FrameworkUtil.sTimeStamp;
		WebObjectUtil.SetValueEdit(UserPermission.getNav_DetailsEdit(), sTicketDetails);
		WebObjectUtil.clickElement(UserPermission.getNav_NotesTab());
		
		//notes part. issue with entering data to note section
		WebObjectUtil.clickElement(UserPermission.getNav_CreateNoteBtn());
		WebObjectUtil.waitForElementPresent(UserPermission.getNav_CreateNoteOkBtn());

		//notes element (iframe)
		NoteiFrame = WebObjectUtil.GetWebElement("xpath", "//div[@id='notesHtmleditor-inputCmp']//iframe", "Notes iFrame");
		NoteiFrame.sendKeys(sNotesDetails);
		//WebObjectUtil.SetValueEdit(NoteiFrame,sNotesDetails);
		
		WebObjectUtil.clickElement(UserPermission.getNav_CreateNoteOkBtn());
		WebObjectUtil.waitForElementNotPresent(UserPermission.getNav_ProgressBar());
		
		sPopupMsg = UserPermission.getNav_popupMsg().getText();
		if(sPopupMsg.contains(spopupUpdateErrMsg)|| sPopupMsg.contains(spopupNoteErrMsg) ){
			FrameworkUtil.updateCustomResultBasedOnStatus(false, sPopupMsg);
			WebObjectUtil.clickElement(UserPermission.getNav_PopupOkBtn());
		}
		
		WebObjectUtil.clickElement(UserPermission.getNav_DetailsTab());
		WebObjectUtil.clickElement(UserPermission.getNav_UpdateTicketBtn());
		WebObjectUtil.waitForElementNotPresent(UserPermission.getNav_ProgressBar());
		
		sDetailValue = UserPermission.getNav_DetailsEdit().getAttribute("value");
		bDetailsStatus = sDetailValue.equalsIgnoreCase(sTicketDetails);
		FrameworkUtil.updateCustomResultBasedOnStatus(bDetailsStatus, sDetailValue);

		
		sPopupMsg = UserPermission.getNav_popupMsg().getText();
		if(sPopupMsg.contains(spopupUpdateErrMsg)|| sPopupMsg.contains(spopupNoteErrMsg) ){
			FrameworkUtil.updateCustomResultBasedOnStatus(false, sPopupMsg);
			WebObjectUtil.clickElement(UserPermission.getNav_PopupOkBtn());
		}
		}
		/*else{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verify element/text", "fail", "Issue with accessing Ticket page" );	
		}	*/
		
	}
	
	
	/*==============================================================
	MethodName 		: getRoleIndex
	Manual TestCase	: get index based on Role name User Management Portal
	Description		: get index based on Role name User Management Portal
	Author 			: Arularasu
	Creation Date 	: 04/15/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	static int getRoleIndex(String sRoleName){
		String sRoleID,sRole ;
		WebElement roleElement;
		int iRoleIndex = 0;
	
		try {
			//This line updated on 10/13/2015 by QAA03 for EXTJS5
			//List<WebElement> roles = WebDriverUtil.getDriver().findElements(By.xpath("//div[@id='idRolePanels-body']//span[contains(@id,'_header_hd-textEl')]"));
			List<WebElement> roles = WebDriverUtil.getDriver().findElements(By.xpath("//div[@id='idRolePanels-body']//div[contains(@id,'-textEl')]"));
			for (int i=0; i<=roles.size(); i++){
				//This line updated on 10/13/2015 by QAA03 for EXTJS5
				 //sRoleID = "idRolePanel" + i + "_header_hd-textEl"; //index starts with 0
				sRoleID = "idRolePanel" + i ;
				 roleElement = WebObjectUtil.GetWebElement("id", sRoleID, "Role Name");
				 if (roleElement != null ){
					 sRole=roleElement.getText();
					 if (sRole.contains(sRoleName)){
						 iRoleIndex=i;
						 break;
					 }
				 }
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LoggerUtil.log_type_error("Exception occured :" + e.getMessage());
		}
		
		return iRoleIndex;
	}
	
	
	
	/*==============================================================
	MethodName 		: getRoleElementByIndex
	Manual TestCase	: get WebElement from index and text passed 
	Description		: get WebElement from index and text passed
	Author 			: Arularasu
	Creation Date 	: 04/15/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	static WebElement getRoleElementByIndex(int iRoleIndex, String sSearchText){
		String sRoleID,sRole ;
		WebElement roleElement = null;
		try{
				 sRoleID = "idRolePanel" + iRoleIndex + "_header_hd-textEl"; //index starts with 0
				 roleElement = WebObjectUtil.GetWebElement("id", sRoleID, "Role Name");
				 if (roleElement != null ){
					 sRole=roleElement.getText();
					 if (sRole.contains(sSearchText)){
						 iRoleIndex=0;
					 }
				 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LoggerUtil.log_type_error("Exception occured :" + e.getMessage());
		}
		
		return roleElement ;
	}
	
	
	
	
	
		
		@Test(priority=10)
	      public void AccessToCreateTicketTest(){
	            
	            WebDriver driver = WebDriverUtil.getDriver();
	            PageFactory.initElements(driver, UserPermission);     
	            PageFactory.initElements(driver, HomePageFactory);
	            PageFactory.initElements(driver, Ticket);
	            String sUserName,sPassword;
	            
	            FrameworkUtil.sTestCaseName = "UserPermissions-Create Ticket";
	            FrameworkUtil.sManualTestCaseName="UP-11 Verify users ARole-A,ARole-C and ARole-E are able to Create Ticket";
	            FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	            //Verify ARole-A user is able to create Ticket
	            sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
	            sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
	            
	            LoginTestCase.nav_Login(sUserName, sPassword);
	            //AccessToCreateTicket();
	            TicketTestCase.verifyCreateTicket();
	            LoginTestCase.nav_Logout();
	            
	            //Verify ARole-C user is able to create Ticket
	            sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
	            sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
	                        
	            LoginTestCase.nav_Login(sUserName, sPassword);
	            //AccessToCreateTicket();
	            TicketTestCase.verifyCreateTicket();
	            LoginTestCase.nav_Logout();
	            
	            //Verify ARole-E user is able to create Ticket
	            sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
	            sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
	                                    
	            LoginTestCase.nav_Login(sUserName, sPassword);
	            //AccessToCreateTicket();
	            TicketTestCase.verifyCreateTicket();
	            LoginTestCase.nav_Logout();
	      }

	      
	      @Test(priority=0)
		  	public void setUserRole(){
		  		String sUserName;
		  		String sPassword;
		  		String sRoleAdmin,sRoleUser,sRoleObserver;
		  		
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, UserPermission);
		  		FrameworkUtil.sTestCaseName = "UserPermission-setUserRole";
		  		FrameworkUtil.sManualTestCaseName="Verify given user able to Edit role(change role) User Management Portal";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  		
		  		
		  		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		  		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		  		
		  		sRoleAdmin = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.ADMIN");
		  		sRoleUser = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.USER");
		  		sRoleObserver = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.OBSERVER");
		  		
		  		AccessToUserManagement( sUserName, sPassword);
		  		WebObjectUtil.verifyElementPresent(UserPermission.getNav_UsersTab());
		  		
		  		//arole-a,arole-c,arole-e,role-a,role-c,role-e
		  		setUserPermission("arole-a",sRoleAdmin);
		  		setUserPermission("arole-c",sRoleUser);
		  		setUserPermission("arole-e",sRoleObserver);
		  		setUserPermission("role-a",sRoleAdmin);
		  		setUserPermission("role-c",sRoleUser);
		  		setUserPermission("role-e",sRoleObserver);
		  		LoginTestCase.nav_Logout();
		  		
		  	}
		  	
		  	
	      /*==============================================================
		  	MethodName 		: setUserPermission
		  	Manual TestCase	: Verify given user able to Edit role(change role) User Management Portal
		  	Description		: Verify given user able to Edit role(change role) User Management Portal
		  	Author 			: Arularasu
		  	Creation Date 	: 04/15/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	public static void setUserPermission(String sUserName, String sUserRole){
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, UserPermission);
		  		String sSuccessMsg,sRoleAdmin,sRoleUser,sRoleObserver,sSelectedItem,sUser_name,sUserRoleDropDownLocator,sUserRoleWebListLocator;
		  		String sRoleName,sUserNameRunTime;
		  		WebElement sUserRoleDropDown,sUserRoleWebList,sUserRoleDropDownArrow,wUserRoleDropCell;
		  		int iLoopcount=0;

		  		try {
					//System.out.println(WebTableUtil.getRowCount(UserPermission.getNav_UserTable()));
					sUser_name  = sUserName;  //(String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.USERNAME");
					sSuccessMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.EDITROLE.FEEDBACKMSG") + sUser_name;
					int iRowNo = WebTableUtil.getRowByCellText(UserPermission.getNav_UserTable(), sUser_name, 0,1);
					sUserNameRunTime = WebTableUtil.getCellData(UserPermission.getNav_UserTable(), iRowNo, 1);
					if (!sUserNameRunTime.equalsIgnoreCase(sUser_name))
						iRowNo =iRowNo+ WebTableUtil.getRowByCellText(UserPermission.getNav_UserTable(), sUser_name, iRowNo+1,1);
					
					WebElement row = WebTableUtil.getRowAsWebElement(UserPermission.getNav_UserTable(), iRowNo);
					WebObjectUtil.clickElement(row);

					/*wUserRoleDropCell = WebTableUtil.getCellAsWebElement(UserPermission.getNav_UserTable(), 1, 4)	;
					wUserRoleDropCell.click();
					sUserRoleDropDownArrow = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "UP.USERTABLE.ROLEDROPDOWN.ARROW", "PARAMETER_ROWNUMBER", iRowNo+"");
					sUserRoleDropDownArrow.click();
					*///WebObjectUtil.clickElement(sUserRoleDropDownArrow);
					//System.out.println(row.getText());
					
					WebObjectUtil.explicitWait(2);
					String sULElementXpath = (String) FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
					sUserRoleWebList = WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
					WebObjectUtil.explicitWait(2);
					if (sUserRoleWebList == null){
						WebObjectUtil.clickElement(UserPermission.getNav_UserRoleDropDownArrow());
						WebObjectUtil.explicitWait(2);
						sULElementXpath = (String) FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
						sUserRoleWebList = WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
					}
					
					WebObjectUtil.selectCustomWebList(sUserRoleWebList, sUserRole);
					
					
					sSelectedItem = UserPermission.getNav_UserRoleDropDownAsEdit().getAttribute("value");
					sUserNameRunTime = WebTableUtil.getCellData(UserPermission.getNav_UserTable(), iRowNo, 1);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "User role" , "Select user role", "done", sUserNameRunTime + " user role: "+ sSelectedItem);
					//This line updated on 10/13/2015 by QAA03 for EXTJS5
					//sUserRoleWebListLocator = "//tr[" + iRowNo + "]//td[4]//div[contains(@class,'x-grid-cell-inner')]";
					/*sUserRoleWebListLocator = "//div[@id='userListPanel-body']//table[" + iRowNo + "]/tbody/tr/td[4]/div[contains(@class,'x-grid-cell-inner')]";
					sUserRoleWebList = WebObjectUtil.GetWebElement("xpath", sUserRoleWebListLocator, "UserRoleWebList");
					WebObjectUtil.clickElement(sUserRoleWebList);
					WebObjectUtil.explicitWait(2);
	
					do
					{
					iLoopcount++;
					WebObjectUtil.clickElement(UserPermission.getNav_UserRoleDropDownAsEdit());
					
					//sUserRoleDropDownLocator = "//tr[" + iRowNo + "]//td//div//div[contains(@class,'x-form-trigger x-form-trigger-default x-form-arrow-trigger x-form-arrow-trigger-default')]/..";
					sUserRoleDropDownLocator="//div[@class='x-boundlist-list-ct x-unselectable']/ul/li[text()='"+ sUserRole +"']";
					sUserRoleDropDown = WebObjectUtil.GetWebElement("xpath", sUserRoleDropDownLocator, "UserRoleDropDown");
					}
					while (sUserRoleDropDown == null || iLoopcount >=3);
					
					
					
					WebObjectUtil.explicitWait(2);
					//WebObjectUtil.ClickAndMouseHover(sUserRoleDropDown);
					WebObjectUtil.clickElement(sUserRoleDropDown)*/;
					
					/*String sULelementXpath = (String) FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
					//WebElement wULelement = WebObjectUtil.getActiveULElementasWebElement(sULelementXpath);
					sRoleAdmin = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.ADMIN");
					sRoleUser = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.USER");
					sRoleObserver = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.OBSERVER");
					
					sSelectedItem = UserPermission.getNav_UserRoleDropDownAsEdit().getAttribute("value");
					
					//WebObjectUtil.clickElement(UserPermission.getNav_UserRoleDropDownAsEdit());
					if (!sSelectedItem.equalsIgnoreCase(sUserRole)){
					//WebObjectUtil.selectCustomWebList(UserPermission.getNav_UserRoleDropDown(), sUserRole);
					WebObjectUtil.selectCustomWebList(sUserRoleWebList,sULelementXpath, sUserRole,1);
					WebObjectUtil.explicitWait(5);
					
					}else{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "User role" , "Select user role", "done", sUser_name + " user already has right role: "+ sUserRole);
					}
	//	WebObjectUtil.VerifyTextUnderElement(UserPermission.getNav_Feedbackportlet(), sSuccessMsg);
					//WebDriverUtil.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
*/
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		  	}
	  	
	  	
	  	
///////////////////////////////////////////////////////////////////////////////////////////////////////
	    		
/////############################################# vivek  #############################################################

	     
			
		  	/*==============================================================
		  	TestScript  	: navViewEVDC
		  	Manual TestCase	: EVDC- > View EVDC 
		  	Description		: Verify that the below users are able to view the EVDC portlet  successfully.
		  						1. Role A: Full Service Admin 
		  						2. Role C:Full Service User  
		  						3. Role E:Full Service Observer 
		  	Author 			: Vivek Kumar
		  	Creation Date 	: 03/30/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=1)
		  	public void navViewEVDC()
		  	{
		  		
		  		String sUserName,sPassword;
		  		String sEVDCUser;
		  		
		  		FrameworkUtil.sTestCaseName = "UserPermission-navViewEVDC";
		  		FrameworkUtil.sManualTestCaseName="EVDC- > View EVDC - TC:UP-10";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  		
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, UserPermission);	
		  		
		  		//Login with A Role and verifying
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		  		navValidateEVDCPortletMultiUsr(sUserName,sPassword);
		  		
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
		  		navValidateEVDCPortletMultiUsr(sUserName,sPassword);
		  		
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
		  		navValidateEVDCPortletMultiUsr(sUserName,sPassword);
		  		
		  		
		  	}
		  	
		  	/*==============================================================
		  	TestScript  	: navAccessvCloudDirRoleE
		  	Manual TestCase	:EVDC- > Access vCloud Director  TCID-UP- 12
		  	Description		: Verify that the below user is unable to access vCloud Director successfully.
		  						1. Role E: Full Service Observer
		  	Author 			: Vivek Kumar
		  	Creation Date 	: 03/30/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=12)
		  	public void navAccessvCloudDirRoleE()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navAccessvCloudDirRoleE";
		  		FrameworkUtil.sManualTestCaseName="VDC- > Access vCloud Director- TC:UP-12";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  			
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, UserPermission);
		  		
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		boolean bCloudStatus=WebObjectUtil.isElementPresent(UserPermission.getNav_vCloudDirectorLink());
		  	
		  		if(!bCloudStatus)
		  		{
		  			LoggerUtil.log_type_info("User with role -ARole-E could not able to access vCloud");
		  			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "User with role -ARole-E could not able to access vCloud", "PASS", "");
		  			
		  		}
		  		else
		  		{
		  			LoggerUtil.log_type_error("User with role -ARole-E could  able to access vCloud");
		  			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "User with role -ARole-E could  able to access vCloud", "FAIL", "");
		  			
		  		}
		  		
		  		//Logging out from Navigator application
		  		LoginTestCase.nav_Logout();
		  	}
		  	
		  	/*==============================================================
		  	TestScript  	: navAccessvCloudDirRoleAnC
		  	Manual TestCase	:EVDC- > Access vCloud Director TC ID- 11
		  	Description		: Verify that the below users are able to access vCloud Director successfully.
		  						1. Role A: Full Service Admin 
		  						2. Role C:Full Service User  
		  	Author 			: Vivek Kumar
		  	Creation Date 	: 03/30/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=11)
		  	public void navAccessvCloudDirRoleAnC()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navAccessvCloudDirRoleAnC";
		  		FrameworkUtil.sManualTestCaseName="EVDC- > Access vCloud Director- TC:UP-11";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  			
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, UserPermission);
		  		
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		boolean bCloudStatus=WebObjectUtil.isElementPresent(UserPermission.getNav_vCloudDirectorLink());
		  		FrameworkUtil.updateCustomResultBasedOnStatus(bCloudStatus, "User with Role-A can access vCloud Director");
		  		//Logging out from Navigator application
		  		LoginTestCase.nav_Logout();
		  		
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		 bCloudStatus=WebObjectUtil.isElementPresent(UserPermission.getNav_vCloudDirectorLink());
		  		FrameworkUtil.updateCustomResultBasedOnStatus(bCloudStatus, "User with Role-C can access vCloud Director");
		  		
		  		//Logging out from Navigator application
		  		LoginTestCase.nav_Logout();
		  	}
		  	
		  	
		  	/*==============================================================
		  	TestScript  	: navEVDCViewVMs
		  	Manual TestCase	: EVDC- > View VMs TC ID-UP 13
		  	Description		: Verify that the below users are able to view VMs.
		  						1. Role A: Full Service Admin 
		  						2. Role C:Full Service User  
		  						3. Role E:Full Service Observer 
		  	Author 			: Vivek Kumar
		  	Creation Date 	: 03/30/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=13)
		  	public void navEVDCViewVMs()
		  	{
		  		
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navEVDCViewVMs";
		  		FrameworkUtil.sManualTestCaseName="EVDC- > View VMs, TC ID-UP 13";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  			
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, UserPermission);
		  		//Validating for Role-A
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		  		navEVDCViewVM(sUserName,sPassword);
		  		//Validating for Role-C
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
		  		navEVDCViewVM(sUserName,sPassword);
		  		//Validating for Role-E
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
		  		navEVDCViewVM(sUserName,sPassword);
		  		
		  	}
		  	
		  	
		  	/*==============================================================
		  	TestScript  	: navEVDCVMStart
		  	Manual TestCase	: EVDC- > VM Controls (Start) - TC ID :-UP-14
		  	Description		: Verify that the below users are able to start the VMs.
		  						1. Role A: Full Service Admin 
		  						2. Role C:Full Service User   
		  	Author 			: Vivek Kumar
		  	Creation Date 	: 03/30/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=14)
		  	public void navEVDCVMStart()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navEVDCVMStart";
		  		FrameworkUtil.sManualTestCaseName="EVDC- > VM Controls (Start) - TC ID :-UP-14";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  			
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, UserPermission);
		  		
		  		
		  		
		  		//Validating for Role-A
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		  		navEVDCValVMStart(sUserName,sPassword);
		  		
		  		//Validating for Role-C
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
		  		navEVDCValVMStart(sUserName,sPassword);
		  		
		  	}
		  	
		  	
		  	
		  	/*==============================================================
		  	TestScript  	: navEVDCVMStop
		  	Manual TestCase	: EVDC- > VM Controls (Stop)- TC ID - UP-15
		  	Description		:Verify that the below users are able to stop the VMs.
		  						1. Role A: Full Service Admin 
		  						2. Role C:Full Service User  
		  	Author 			: Vivek Kumar
		  	Creation Date 	: 04/02/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=15)
		  	public void navEVDCVMStop()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navEVDCVMStop";
		  		FrameworkUtil.sManualTestCaseName="EVDC- > VM Controls (Stop)- TC ID - UP-15";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  			
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, UserPermission);
		  		
		  		//Validating for Role-A, that it can stop VM
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		  		navEVDCValVMStop(sUserName,sPassword);
		  		
		  		//Validating for Role-C, that it can stop VM
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
		  		navEVDCValVMStop(sUserName,sPassword);
		  	}
		  	
		  	

		  	/*==============================================================
		  	TestScript  	: navEVDCVMSuspend
		  	Manual TestCase	: EVDC- > VM Controls (Suspend)- TC ID - UP-16
		  	Description		:Verify that the below users are able to suspend the VMs.
		  						1. Role A: Full Service Admin 
		  						2. Role C:Full Service User   
		  	Author 			: Vivek Kumar
		  	Creation Date 	: 04/02/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=16)
		  	public void navEVDCVMSuspend()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navEVDCVMSuspend";
		  		FrameworkUtil.sManualTestCaseName="EVDC- > VM Controls (Suspend)- TC ID - UP-16";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  			
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, UserPermission);
		  		
		  		//Validating for Role-A, that it can Suspend VM
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		  		navEVDCValVMSuspend(sUserName,sPassword);
		  		
		  		//Validating for Role-C, that it can Suspend VM
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
		  		navEVDCValVMSuspend(sUserName,sPassword);
		  	}
		  	
		  	

		  	/*==============================================================
		  	TestScript  	: navEVDCVMReset
		  	Manual TestCase	: EVDC- > VM Controls (Reset)- TC ID - UP-17
		  	Description		: Verify that the below users are able to reset the VMs.
		  						1. Role A: Full Service Admin 
		  						2. Role C:Full Service User   
		  	Author 			: Vivek Kumar
		  	Creation Date 	: 04/02/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=17)
		  	public void navEVDCVMReset()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navEVDCVMReset";
		  		FrameworkUtil.sManualTestCaseName="EVDC- > VM Controls (Reset)- TC ID - UP-17";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  			
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, UserPermission);
		  		
		  		//Validating for Role-A, that it can Suspend VM
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		  		navEVDCValVMReset(sUserName,sPassword);
		  		
		  		//Validating for Role-C, that it can Suspend VM
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
		  		navEVDCValVMReset(sUserName,sPassword);
		  	}
		  	
		  	
		  	/*==============================================================
		  	TestScript  	: navEVDCVMCreateTicket
		  	Manual TestCase	: EVDC- > VM Controls (Create a Ticket)- TC ID - UP-18
		  	Description		: Verify that the below users are able to Create a Ticket.
		  						1. Role A: Full Service Admin 
		  						2. Role C:Full Service User    
		  	Author 			: Vivek Kumar
		  	Creation Date 	: 04/02/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	//@Test(priority=18)
		  	public void navEVDCVMCreateTicket()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navEVDCVMCreateTicket";
		  		FrameworkUtil.sManualTestCaseName="EVDC- > VM Controls (Create a Ticket)- TC ID - UP-18";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  			
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, UserPermission);
		  		
		  		//Validating for Role-A, that it can Suspend VM
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		  		navEVDCValVMCreateTicket(sUserName,sPassword);
		  		
		  		//Validating for Role-C, that it can Suspend VM
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
		  		navEVDCValVMCreateTicket(sUserName,sPassword);
		  	}
		  	
		  	
		  	
		  	/*==============================================================
		  	TestScript  	: navEVDCVMControls
		  	Manual TestCase	: EVDC- >VM Controls (KVM)- TC ID - UP-19
		  	Description		: Verify that the below users are able to access VM Console
		  						1. Role A: Full Service Admin 
		  						2. Role C:Full Service User   
		  	Author 			: Vivek Kumar
		  	Creation Date 	: 04/08/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=19)
		  	public void navEVDCVMControls()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navEVDCVMControls";
		  		FrameworkUtil.sManualTestCaseName="EVDC- >VM Controls (KVM)- TC ID - UP-19";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  			
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, UserPermission);
		  		
		  		//Validating for Role-A, that it can access console
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		  		navEVDCValConsole(sUserName,sPassword);
		  		
		  		//Validating for Role-C, that it can access Console
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
		  		navEVDCValConsole(sUserName,sPassword);
		  		
		  	}
		  	
		  	/*==============================================================
		  	TestScript  	: navEVDCVMStartNotVisible
		  	Manual TestCase	: EVDC- >VM Controls (Start) - UP-20
		  	Description		:Verify that the below user is unable to view start button.
		  						1. Role E:Full Service Observer  
		  	Author 			: Vivek Kumar
		  	Creation Date 	: 04/09/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=20)
		  	public void navEVDCVMStartNotVisible()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navEVDCVMStartNotVisible";
		  		FrameworkUtil.sManualTestCaseName="EVDC- >VM Controls (Start) - UP-20";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  			
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, UserPermission);
		  		
		  		//Validating for Role-A, that it can access console
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
		  		//Login to Navigator with E -Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		
		  		EVDC_VM_AdvancedActions.navigateAndExpandVMforRoleE("Stopped");
		  		int iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum ;
		  		
		  			String sLocationValue = "//table/tbody/tr[" + iRowNbr + "]/td/table/tbody/tr[2]//a[contains(text(),'Start')]";
		  			WebElement startVM = WebObjectUtil.GetWebElement("xpath", sLocationValue,"Start Button");
		  			//boolean bStatus=WebObjectUtil.isElementPresent(startVM);
		  			
		  			if(startVM==null)
		  			{
		  				LoggerUtil.log_type_info("User with Role-E is unable to view Start button");
		  				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "User with Role-E is unable to view Start button", "pass", "");
		  				
		  			}
		  			else
		  			{
		  				LoggerUtil.log_type_error("User with Role-E is able to view Start button");
		  				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "User with Role-E is able to view Start button", "fail", "");
		  				
		  			}
		  		
		  		//Logging out from Navigator application
		  		LoginTestCase.nav_Logout();
		  		
		  	}
		  	
		  	/*==============================================================
		  	TestScript  	: navEVDCVMStopNotVisible
		  	Manual TestCase	: EVDC- >VM Controls (Stop) - UP-21
		  	Description		:Verify that the below user is unable to view stop button.
		  						1. Role E:Full Service Observer  
		  	Author 			: Vivek Kumar
		  	Creation Date 	: 04/09/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=21)
		  	public void navEVDCVMStopNotVisible()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navEVDCVMStopNotVisible";
		  		FrameworkUtil.sManualTestCaseName= "EVDC- >VM Controls (Stop) - UP-21";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  			
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, UserPermission);
		  		
		  		//Validating for Role-A, that it can access console
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
		  		//Login to Navigator with E -Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		
		  		EVDC_VM_AdvancedActions.navigateAndExpandVMforRoleE("Running");
		  		int iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum ;
		  		
		  			String sLocationValue = "//table/tbody/tr["+ iRowNbr+"]/td/table/tbody/tr[2]//a[contains(text(),'Stop')]";
		  			WebElement stopVM = WebObjectUtil.GetWebElement("xpath", sLocationValue,"Suspend Button");
		  			//boolean bStatus=WebObjectUtil.isElementPresent(startVM);
		  			
		  			if(stopVM==null)
		  			{
		  				LoggerUtil.log_type_info("User with Role-E is unable to view Stop button");
		  				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "User with Role-E is unable to view Stop button", "pass", "");
		  				
		  			}
		  			else
		  			{
		  				LoggerUtil.log_type_error("User with Role-E is able to view Stop button");
		  				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "User with Role-E is able to view Stop button", "fail", "");
		  				
		  			}
		  		
		  		//Logging out from Navigator application
		  		LoginTestCase.nav_Logout();
		  		
		  	}
		  	
		  	/*==============================================================
		  	TestScript  	: navEVDCVMSuspendNotVisible
		  	Manual TestCase	: EVDC- >VM Controls (Suspend) - UP-22
		  	Description		:Verify that the below user is unable to view suspend button.
		  						1. Role E:Full Service Observer  
		  	Author 			: Vivek Kumar
		  	Creation Date 	: 04/09/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=22)
		  	public void navEVDCVMSuspendNotVisible()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navEVDCVMSuspendNotVisible";
		  		FrameworkUtil.sManualTestCaseName= "EVDC- >VM Controls (Suspend) - UP-22";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  			
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, UserPermission);
		  		
		  		//Validating for Role-A, that it can access console
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
		  		//Login to Navigator with E -Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		
		  		EVDC_VM_AdvancedActions.navigateAndExpandVMforRoleE("Running");
		  		int iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum ;
		  		
		  			//String sLocationValue ="//table/tbody/tr["+ iRowNbr+"]/td/table/tbody/tr[2]//a[contains(text(),'Suspend')]";
		  		   // String sLocationValue  ="//table["+ iRowNbr+"]//a[contains(text(),'Suspend')]";
		  		    
		  			//WebElement suspendVM = WebObjectUtil.GetWebElement("xpath", sLocationValue,"Suspend Button");
		  		    WebElement suspendVM = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.SUSPEND.BUTTON", "PARAMETER_ROWNUMBER", iRowNbr+"");
		  			//boolean bStatus=WebObjectUtil.isElementPresent(startVM);
		  			
		  			if(suspendVM==null)
		  			{
		  				LoggerUtil.log_type_info("User with Role-E is unable to view Suspend button");
		  				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "User with Role-E is unable to view Suspend button as expected", "pass", "");
		  				
		  			}
		  			else
		  			{
		  				LoggerUtil.log_type_error("User with Role-E is able to view Suspend button");
		  				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "User with Role-E is able to view Stop Suspend", "fail", "");
		  				
		  			}
		  		
		  		//Logging out from Navigator application
		  		LoginTestCase.nav_Logout();
		  	}
		  	
		  	

		  	/*==============================================================
		  	TestScript  	: navEVDCVMResetNotVisible
		  	Manual TestCase	: EVDC- >VM Controls (reset) - UP-23
		  	Description		:Verify that the below user is unable to view reset button.
		  						1. Role E:Full Service Observer  
		  	Author 			: Vivek Kumar
		  	Creation Date 	: 04/09/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=23)
		  	public void navEVDCVMResetNotVisible()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navEVDCVMResetNotVisible";
		  		FrameworkUtil.sManualTestCaseName= "EVDC- >VM Controls (reset) - UP-23";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  			
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, UserPermission);
		  		
		  		//Validating for Role-A, that it can access console
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
		  		//Login to Navigator with E -Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		
		  		EVDC_VM_AdvancedActions.navigateAndExpandVMforRoleE("Running");
		  		int iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum ;
		  		
		  			String sLocationValue ="//table/tbody/tr["+ iRowNbr+"]/td/table/tbody/tr[2]//a[contains(text(),'Reset')]";
		  			WebElement resetVM = WebObjectUtil.GetWebElement("xpath", sLocationValue,"Reset Button");
		  			//boolean bStatus=WebObjectUtil.isElementPresent(startVM);
		  			
		  			if(resetVM==null)
		  			{
		  				LoggerUtil.log_type_info("User with Role-E is unable to view Reset button");
		  				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "User with Role-E is unable to view Reset button", "pass", "");
		  				
		  			}
		  			else
		  			{
		  				LoggerUtil.log_type_error("User with Role-E is unable to view Reset button");
		  				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "User with Role-E is able to view Stop Reset", "fail", "");
		  				
		  			}
		  		
		  		//Logging out from Navigator application
		  		LoginTestCase.nav_Logout();
		  	}
		  	
		  	/*==============================================================
		  	TestScript  	: navEVDCVMCreateTicketNotVisible
		  	Manual TestCase	: EVDC- >VM Controls (Create a ticket) - UP-24
		  	Description		:Verify that the below user is unable to view create a ticket button.
		  						1. Role E:Full Service Observer  
		  	Author 			: Vivek Kumar
		  	Creation Date 	: 04/09/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=24)
		  	public void navEVDCVMCreateTicketNotVisible()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navEVDCVMCreateTicketNotVisible";
		  		FrameworkUtil.sManualTestCaseName= "EVDC- >VM Controls (Create a ticket) - UP-24";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  			
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, UserPermission);
		  		
		  		//Validating for Role-A, that it can access console
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
		  		//Login to Navigator with E -Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		
		  		EVDC_VM_AdvancedActions.navigateAndExpandVMforRoleE("Running");
		  		int iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum ;
		  		
		  			String sLocationValue ="//table//tr[" + iRowNbr + "]//div[@id='vm_button_start_modify']//img";
		  			WebElement createTicketVM = WebObjectUtil.GetWebElement("xpath", sLocationValue,"Reset Button");
		  			//boolean bStatus=WebObjectUtil.isElementPresent(startVM);
		  			
		  			if(createTicketVM==null)
		  			{
		  				LoggerUtil.log_type_info("User with Role-E is unable to view Create a ticke button");
		  				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "User with Role-E is unable to view Create a ticke button", "pass", "");
		  				
		  			}
		  			else
		  			{
		  				LoggerUtil.log_type_error("User with Role-E is unable to view Create a ticke button");
		  				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "User with Role-E is able to view Stop Create a ticke", "fail", "");
		  				
		  			}
		  		
		  		//Logging out from Navigator application
		  		LoginTestCase.nav_Logout();
		  	}
		  	
		  	
		  	/*==============================================================
		  	TestScript  	: navEVDCVMEditUpdate
		  	Manual TestCase	: EVDC- > VM -> Edit VM - UP-26
		  	Description		:Verify that the below users are able to Edit the VMs.
		  						1. Role A: Full Service Admin 
		  						2. Role C:Full Service User  
		    
		  	Author 			: Vivek Kumar
		  	Creation Date 	: 04/14/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=26)
		  	public void navEVDCVMEditUpdate()
		  	{
		  		String sUserName,sPassword;
		  		int iRowNbr;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navEVDCVMEditUpdate";
		  		FrameworkUtil.sManualTestCaseName= "EVDC- > VM -> Edit VM - UP-26";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  			
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, UserPermission);
		  		PageFactory.initElements(driver, EVDC_Overview);
				PageFactory.initElements(driver, EVDC_VMPF);
		  		
		  		//Validating for Role-A, that it can access console
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		  		//Login to Navigator with A-Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		
		  		EVDC_VM_AdvancedActions.navigateAndExpandVMforRoleE("Stopped");
		  		iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum ;
		  		//Clicking on Edit button
		  		EVDC_VM_TestCase.navVerifyClkEditBtn(iRowNbr);
		  		navEditDescriptionUpdate(iRowNbr,sUserName);
		  		
		  		
		  		
		  		//Validating for Role-A, that it can access console
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
		  		//Login to Navigator with A-Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		EVDC_VM_AdvancedActions.navigateAndExpandVMforRoleE("Stopped");
		  		iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum ;
		  		//Clicking on Edit button
		  		EVDC_VM_TestCase.navVerifyClkEditBtn(iRowNbr);
		  		navEditDescriptionUpdate(iRowNbr,sUserName);
		  		
		  	}
		  	
		  	
		  	/*==============================================================
		  	TestScript  	: navEVDCVMEditUpdatenotVisible
		  	Manual TestCase	: EVDC- > VM -> Edit VM - UP-27
		  	Description		: Verify that the below user is unable to see Edit buttonin the VM.
		  						1. Role E:Full Service Observer 
		   	Author 			: Vivek Kumar
		  	Creation Date 	: 04/14/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=27)
		  	public void navEVDCVMEditUpdatenotVisible()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navEVDCVMCreateTicketNotVisible";
		  		FrameworkUtil.sManualTestCaseName= "EVDC- >VM Controls (Create a ticket) - UP-24";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  			
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, UserPermission);
		  		
		  		//Validating for Role-A, that it cannot access Edit
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
		  		//Login to Navigator with E -Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		
		  		EVDC_VM_AdvancedActions.navigateAndExpandVMforRoleE("Stopped");
		  		int iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum ;
		  		
		  			
		  			
		  			WebElement wEdit=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+ iRowNbr+"]/td/table/tbody/tr[2]//a[contains(text(),'Edit')]","Edit Button");
		  			if(wEdit==null)
		  			{
		  				LoggerUtil.log_type_info("User with Role-E is unable to view Edit Button");
		  				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Edit Button", "pass", "Role-E is unable to view Edit button");
		  				
		  			}
		  			else
		  			{
		  				LoggerUtil.log_type_error("User with Role-E is unable to view Edit button button");
		  				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Edit Button", "fail", "Role-E is unable to view Edit button");
		  				
		  			}
		  		
		  		//Logging out from Navigator application
		  		LoginTestCase.nav_Logout();
		  	}
		  	
		  	
		  	/*==============================================================
		  	TestScript  	: navEVDCVMAddVM
		  	Manual TestCase	:EVDC- > VM -> Add VM - UP-28
		  	Description		: Verify that the below users are able to Add VM
		  						1. Role A: Full Service Admin 
		  						2. Role C:Full Service User  

		   	Author 			: Vivek Kumar
		  	Creation Date 	: 04/14/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=28)
		  	public void navEVDCVMAddVM()
		  	{
		  		
		  		String sVMName,sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navEVDCVMAddVM";
		  		FrameworkUtil.sManualTestCaseName="EVDC- > VM -> Add VM - UP-28";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  		
		  		
		  		sVMName=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.ADDVM.NAMETEMPLATE");
		  		
		  		try {
		  			sVMName=sVMName + FrameworkUtil.date_yyyyMMdd()+"_" + FrameworkUtil.date_HHmmss() ;
		  			WebDriver driver = WebDriverUtil.getDriver();
		  			PageFactory.initElements(driver, UserPermission);
		  			PageFactory.initElements(driver, EVDC_Overview);
		  			PageFactory.initElements(driver, EVDC_VMPF);
		  			
		  			//Validating for Role-A, that it can access console
		  			sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		  			sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		  			//Login to Navigator with A-Role
		  			LoginTestCase.nav_Login(sUserName,sPassword);
		  			navAddVM(sVMName,sUserName);
		  			
		  			//Validating for Role-C, that it can accessAdd VM
		  			sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
		  			sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
		  			//Login to Navigator with A-Role
		  			LoginTestCase.nav_Login(sUserName,sPassword);
		  			
		  			sVMName=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.ADDVM.NAMETEMPLATE");
		  			sVMName=sVMName + FrameworkUtil.date_yyyyMMdd()+"_" + FrameworkUtil.date_HHmmss() ;
		  			navAddVM(sVMName,sUserName);
		  			
		  		} catch (Exception e) {
		  			// TODO Auto-generated catch block
		  			e.printStackTrace();
		  		}
		  	}
		  	
		  	/*==============================================================
		  	TestScript  	: navEVDCVMAddVMnotVisible
		  	Manual TestCase	:EVDC- > VM -> Add VM - UP-29
		  	Description		: Verify that the below user is unable to see Add VM linf in the VM page
		  						1. Role E:Full Service Observer 
		   	Author 			: Vivek Kumar
		  	Creation Date 	: 04/14/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=29)
		  	public void navEVDCVMAddVMnotVisible()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navEVDCVMAddVMnotVisible";
		  		FrameworkUtil.sManualTestCaseName="EVDC- > VM -> Add VM - UP-29";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  		
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, UserPermission);
		  		PageFactory.initElements(driver, EVDC_Overview);
				PageFactory.initElements(driver, EVDC_VMPF);
		  		
		  		//Validating for Role-A, that it cannot access console
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
		  		//Login to Navigator with A-Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		
		  		//Clicking on EVDC Link
		  		WebObjectUtil.clickAndVerifyElement(EVDC_Overview.getNav_EVDCname(), EVDC_Overview.getNav_EVDCOverviewVirtualMachine());
		  		//Clicking on Virtual machine
		  		WebObjectUtil.clickElement(EVDC_Overview.getNav_EVDCOverviewVirtualMachine());
		  		boolean flag=WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_AddVMLink());
		  		//WebElement flag=EVDC.getNav_AddVMLink();
		  		if(flag==false)
		  		{
		  			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Add VM" , "pass", sUserName + " -not able to see add VMs.") ;
		  			LoggerUtil.log_type_info(sUserName + " - User not able to see Add VM " );
		  		}
		  		else
		  		{
		  			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Add VM" , "fail",sUserName + " able to see add VMs.") ;
		  			LoggerUtil.log_type_error(sUserName + " - User able to see Add VM " );
		  		}	
		  		
		  		//Logging out from Navigator application
		  		LoginTestCase.nav_Logout();
		  	}
		  	
		  	
		  	/*==============================================================
		  	TestScript  	: navEVDCVMControlsnotVisible
		  	Manual TestCase	: EVDC- >VM Controls (KVM)- TC ID - UP-25
		  	Description		: Verify that the below users are unable to access VM Console
		  						1. Role E: Full Service Admin 		
		  	Author 			: Vivek Kumar
		  	Creation Date 	: 04/15/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=25)
		  	public void navEVDCVMControlsnotVisible()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navEVDCVMStopNotVisible";
		  		FrameworkUtil.sManualTestCaseName= "EVDC- >VM Controls (Stop) - UP-21";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  			
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, UserPermission);
		  		
		  		//Validating for Role-A, that it can access console
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
		  		//Login to Navigator with E -Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		
		  		EVDC_VM_AdvancedActions.navigateAndExpandVMforRoleE("Stopped");
		  		int iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum ;
		  		
		  			String sLocationValue = "//tr[" + iRowNbr + "]//div/a/img[@alt='vm console']";
		  			WebElement wConsoleVM = WebObjectUtil.GetWebElement("xpath", sLocationValue,"Suspend Button");
		  			//boolean bStatus=WebObjectUtil.isElementPresent(startVM);
		  			
		  			if(wConsoleVM==null)
		  			{
		  				LoggerUtil.log_type_info("User with Role-E is unable to view Console ");
		  				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "User with Role-E is unable to view Console", "pass", "");
		  				
		  			}
		  			else
		  			{
		  				LoggerUtil.log_type_error("User with Role-E is unable to view Console");
		  				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "User with Role-E is able to view Console", "fail", "");
		  				
		  			}
		  		
		  		//Logging out from Navigator application
		  		LoginTestCase.nav_Logout();
		  		
		  	}
		  	
		  	
		  	/*==============================================================
		  	TestScript  	: navCatalogViewWSandPrivate
		  	Manual TestCase	: EVDC- >Catalogs page -> View Windstream Objects and Private Objects UP-63
		  	Description		: Verify that the below users are able to view Windstream and Private  Objects successfully.
		  						1. Role A: Full Service Admin 
		  						2. Role C:Full Service User  
		  						3. Role E:Full Service Observer  		
		  	Author 			: Vivek Kumar
		  	Creation Date 	: 04/22/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=63)
		  	public void navCatalogViewWSandPrivate()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navCatalogViewWSandPrivate";
		  		FrameworkUtil.sManualTestCaseName= " EVDC- >Catalogs page -> View Windstream Objects and Private Objects UP-63";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  			
		  			
		  		//Validating for Role-A, that it can access console
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		  		//Login to Navigator with E -Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		CatalogTestCase.validateWindStreamandPrivatePg();
		  		//Logging out from Navigator application
		  		LoginTestCase.nav_Logout();
		  		
		  		//Validating for Role-C, that it can access console
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
		  		//Login to Navigator with E -Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		CatalogTestCase.validateWindStreamandPrivatePg();
		  		//Logging out from Navigator application
		  		LoginTestCase.nav_Logout();
		  		
		  		//Validating for Role-E, that it can access console
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
		  		//Login to Navigator with E -Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		CatalogTestCase.validateWindStreamandPrivatePg();
		  		//Logging out from Navigator application
		  		LoginTestCase.nav_Logout();
		  		
		  	}
		  	
		  	/*==============================================================
		  	TestScript  	: navCatalogEditPrivateItem
		  	Manual TestCase	: EVDC- >Catalogs page ->  Edit Private Catalog items UP-64
		  	Description		: Verify that the below users are able to Edit private Catalog items successfully.
		  						1. Role A: Full Service Admin 
		  						2. Role C:Full Service User  		
		  	Author 			: Vivek Kumar
		  	Creation Date 	: 04/22/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=64)
		  	public void navCatalogEditPrivateItem()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navCatalogEditPrivateItem";
		  		FrameworkUtil.sManualTestCaseName= " EVDC- >Catalogs page ->  Edit Private Catalog items UP-64";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, Catalog);
		  			
		  		//Validating for Role-A, 
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		  		//Login to Navigator with E -Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		WebObjectUtil.clickAndVerifyElement(Catalog.getNav_CatalogPrivateLink(), Catalog.getNav_CatalogPrivatePDFImg());
		  		//Editing Item under Private WebTable
		  		CatalogTestCase.expandCatalogPrivateTable();
		  		CatalogTestCase.settingNameandDescEdit();
		  		//Logging out from Navigator application
		  		LoginTestCase.nav_Logout();
		  		
		  		
		  		//Validating for Role-C, 
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
		  		//Login to Navigator with E -Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		WebObjectUtil.clickAndVerifyElement(Catalog.getNav_CatalogPrivateLink(), Catalog.getNav_CatalogPrivatePDFImg());
		  		//Editing Item under Private WebTable
		  		CatalogTestCase.expandCatalogPrivateTable();
		  		CatalogTestCase.settingNameandDescEdit();
		  		//Logging out from Navigator application
		  		LoginTestCase.nav_Logout();
		  	}
		  	
		  	
		  	/*==============================================================
		  	TestScript  	: navCatalogEditnotVisible
		  	Manual TestCase	: EVDC- >Catalogs page ->  Edit Private Catalog items UP-65
		  	Description		: Verify that the below user is unable to Edit private Catalog items 
		  						1. Role E:Full Service Observer    		
		  	Author 			: Vivek Kumar
		  	Creation Date 	: 04/22/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=65)
		  	public void navCatalogEditnotVisible()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navCatalogEditnotVisible";
		  		FrameworkUtil.sManualTestCaseName= " EVDC- >Catalogs page ->  Edit Private Catalog items UP-65";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, Catalog);
		  			
		  		//Validating for Role-E, 
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
		  		//Login to Navigator with E -Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		WebObjectUtil.clickAndVerifyElement(Catalog.getNav_CatalogPrivateLink(), Catalog.getNav_CatalogPrivatePDFImg());
		  		//Editing Item under Private WebTable
		  		CatalogTestCase.expandCatalogPrivateTable();
		  		//Verifying that Edit button should not be there for Role E
		  		boolean bEditStatus=WebObjectUtil.isElementPresent(Catalog.getNav_CatalogPrivateWebTableEdit());
		  	
		  		if(!bEditStatus)
		  		{
		  			FrameworkUtil.updateCustomResultBasedOnStatus(true, "Role E user is unable to Edit private Catalog items");
		  		}
		  		else
		  		{
		  			FrameworkUtil.updateCustomResultBasedOnStatus(false, "Role E user is able to Edit private Catalog items");
		  		}
		  		//Logging out from Navigator application
		  		LoginTestCase.nav_Logout();
		  	}
		  	
		  	
		  	
		  	

		  	/*==============================================================
		  	TestScript  	: navCatalogWindStreamCopy
		  	Manual TestCase	: EVDC- >Catalogs page ->  Windstream Objects- > Copy UP-66
		  	Description		: Verify that the below users are able to copy Windstream object items successfully.
		  						1. Role A: Full Service Admin 
		  						2. Role C:Full Service User	
		  	Author 			: Vivek Kumar
		  	Creation Date 	: 04/22/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=66)
		  	public void navCatalogWindStreamCopy()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navCatalogWindStreamCopy";
		  		FrameworkUtil.sManualTestCaseName= " EVDC- >Catalogs page ->  Windstream Objects- > Copy UP-66";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, Catalog);
		  			
		  		//Validating for Role-A, 
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		  		//Login to Navigator with E -Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		CatalogTestCase.valWindSteamCopyFunctionality();
		  			
		  		//Validating for Role-C,
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
		  		//Login to Navigator with E -Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		CatalogTestCase.valWindSteamCopyFunctionality();
		  		
		  	}
		  	
		  	

		  	/*==============================================================
		  	TestScript  	: navCatalogWindStreamCopynotVisible
		  	Manual TestCase	: EVDC- >Catalogs page ->  Windstream Objects- > Copy UP-67
		  	Description		: Verify that the below user is unable to copy Windstream Catalog items 
		  						1. Role E:Full Service Observer    
		  	Author 			: Vivek Kumar
		  	Creation Date 	: 04/22/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=67)
		  	public void navCatalogWindStreamCopynotVisible()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navCatalogWindStreamCopynotVisible";
		  		FrameworkUtil.sManualTestCaseName= " EVDC- >Catalogs page ->  Windstream Objects- > Copy UP-67";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, Catalog);
		  			
		  		//Validating for Role-E, 
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
		  		//Login to Navigator with E -Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		//Expanding the very first item
		  		WebObjectUtil.clickElement(Catalog.getNav_CatalogWindStreamFirstExpander());
		  		boolean bCopyBtnStatus=WebObjectUtil.isElementPresent(Catalog.getNav_CatalogWindStreamCopyBtn());
		  	
		  		if(!bCopyBtnStatus)
		  		{
		  			FrameworkUtil.updateCustomResultBasedOnStatus(true, "Role E user is unable to copy Windstream Catalog items ");
		  		}
		  		else
		  		{
		  			FrameworkUtil.updateCustomResultBasedOnStatus(false, "Role E user is able to copy Windstream Catalog items ");
		  		}
		  		//Logging out from Navigator application
		  		LoginTestCase.nav_Logout();
		  	}
		  	
		  	/*==============================================================
		  	TestScript  	: navCatalogPrivateCopy
		  	Manual TestCase	: EVDC- >Catalogs page ->  Private Objects- > Copy UP-68
		  	Description		: Verify that the below users are able to copy Private object items successfully.
		  						1. Role A: Full Service Admin 
		  						2. Role C:Full Service User	
		  	Author 			: Vivek Kumar
		  	Creation Date 	: 04/24/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=68)
		  	public void navCatalogPrivateCopy()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navCatalogPrivateCopy";
		  		FrameworkUtil.sManualTestCaseName= "  EVDC- >Catalogs page ->  Private Objects- > Copy UP-68";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, Catalog);
		  			
		  		//Validating for Role-A, 
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		  		//Login to Navigator with A -Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		CatalogTestCase.valPrivateCopyFunctionality();
		  			
		  		//Validating for Role-C
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
		  		//Login to Navigator with E -Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		CatalogTestCase.valPrivateCopyFunctionality();
		  		
		  	}
		  	
		  	/*==============================================================
		  	TestScript  	: navCatalogPrivateCopyNotVisible
		  	Manual TestCase	: EVDC- >Catalogs page ->  Private Objects- > Copy UP-69
		  	Description		: Verify that the below user is unable to copy Private Catalog items 
		  						1. Role E:Full Service Observer    
		  	Author 			: Vivek Kumar
		  	Creation Date 	: 04/24/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=69)
		  	public void navCatalogPrivateCopyNotVisible()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navCatalogPrivateCopyNotVisible";
		  		FrameworkUtil.sManualTestCaseName= "  EVDC- >Catalogs page ->  Private Objects- > Copy UP-69";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, Catalog);
		  			
		  		//Validating for Role-E
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
		  		//Login to Navigator with E -Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateLink());
		  		//Expanding the very first item
		  		int iRowCnt=WebTableUtil.getRowCount(Catalog.getNav_CatalogPrivateWebTable());
		  		if(iRowCnt>0)
		  		{
		  			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateFirstExpander());
		  			boolean bCopyBtnStatus=WebObjectUtil.isElementPresent(Catalog.getNav_CatalogPrivateCopyBtn());
		  			
		  			if(!bCopyBtnStatus)
		  			{
		  				FrameworkUtil.updateCustomResultBasedOnStatus(true, "Role E user is unable to copy Private Catalog items ");
		  			}
		  			else
		  			{
		  				FrameworkUtil.updateCustomResultBasedOnStatus(false, "Role E user is able to copy Private Catalog items ");
		  			}
		  		}
		  		else
		  		{
		  			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Issue with Private Object WebTable", "fail", "Items not found under PrivateObjects");
		  		}
		  		
		  		//Logging out from Navigator application
		  		LoginTestCase.nav_Logout();
		  	}
		  	
		  	
		  	

		  	/*==============================================================
		  	TestScript  	: navCatalogWindStreamDeploy
		  	Manual TestCase	: EVDC- >Catalogs page -> Windstream Objects- > Deploy UP-70
		  	Description		: Verify that the below users are able to deploy Windstream object item successfully.
		  						1. Role A: Full Service Admin 
		  						2. Role C:Full Service User  
		  	Author 			: Vivek Kumar
		  	Creation Date 	: 04/23/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=70)
		  	public void navCatalogWindStreamDeploy()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navCatalogWindStreamDeploy";
		  		FrameworkUtil.sManualTestCaseName= "EVDC- >Catalogs page -> Windstream Objects- > Deploy UP-70";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, Catalog);
		  			
		  		//Validating for Role-A, that it can access console
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		  		//Login to Navigator with E -Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		CatalogTestCase.valWindStreamDeployFunctionality();
		  		
		  		//Validating for Role-C, that it can access console
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
		  		//Login to Navigator with E -Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		CatalogTestCase.valWindStreamDeployFunctionality();
		  		
		  	}
		  	

		  	/*==============================================================
		  	TestScript  	: navCatalogWindStreamDeploynotVisible
		  	Manual TestCase	: EVDC- >Catalogs page -> Windstream Objects- > Deploy UP-71
		  	Description		: Verify that the below user is unable to Deploy Windstream Catalog items 
		  						1. Role E:Full Service Observer    
		  	Author 			: Vivek Kumar
		  	Creation Date 	: 04/23/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=71)
		  	public void navCatalogWindStreamDeploynotVisible()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navCatalogWindStreamDeploynotVisible";
		  		FrameworkUtil.sManualTestCaseName= "EVDC- >Catalogs page -> Windstream Objects- > Deploy UP-71";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, Catalog);
		  			
		  		//Validating for Role-E, that it can access console
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
		  		//Login to Navigator with E -Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		//Expanding the very first item
		  		WebObjectUtil.clickElement(Catalog.getNav_CatalogWindStreamFirstExpander());
		  		boolean bCopyBtnStatus=WebObjectUtil.isElementPresent(Catalog.getNav_CatalogWindStreamDeployBtn());
		  	
		  		if(!bCopyBtnStatus)
		  		{
		  			FrameworkUtil.updateCustomResultBasedOnStatus(true, "Role E user is unable to deploy Windstream Catalog items ");
		  		}
		  		else
		  		{
		  			FrameworkUtil.updateCustomResultBasedOnStatus(false, "Role E user is able to deploy Windstream Catalog items ");
		  		}
		  		//Logging out from Navigator application
		  		LoginTestCase.nav_Logout();
		  	}
		  	
		  	
		  	/*==============================================================
		  	TestScript  	: navCatalogPrivateDeploy
		  	Manual TestCase	: EVDC- >Catalogs page -> Private Objects- > Deploy UP-72
		  	Description		: Verify that the below users are able to deploy Windstream object item successfully.
		  						1. Role A: Full Service Admin 
		  						2. Role C:Full Service User  
		  	Author 			: Vivek Kumar
		  	Creation Date 	: 04/23/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=72)
		  	public void navCatalogPrivateDeploy()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navCatalogPrivateDeploy";
		  		FrameworkUtil.sManualTestCaseName= "EVDC- >Catalogs page -> Private Objects- > Deploy UP-72";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, Catalog);
		  			
		  		//Validating for Role-A, 
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		  		//Login to Navigator with A -Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		CatalogTestCase.valPrivateDeployFunctionality();
		  		
		  		//Validating for Role-C, 
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
		  		//Login to Navigator with C -Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		CatalogTestCase.valPrivateDeployFunctionality();
		  		
		  	}
		  	/*==============================================================
		  	TestScript  	: navCatalogPrivateDeployNotVisible
		  	Manual TestCase	: EVDC- >Catalogs page -> Private Objects- > Deploy UP-73
		  	Description		: Verify that the below user is unable to Deploy Windstream Catalog items 
		  						1. Role E:Full Service Observer    
		  	Author 			: Vivek Kumar
		  	Creation Date 	: 04/24/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=73)
		  	public void navCatalogPrivateDeployNotVisible()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navCatalogPrivateDeployNotVisible";
		  		FrameworkUtil.sManualTestCaseName= "EVDC- >Catalogs page -> Private Objects- > Deploy UP-73";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, Catalog);
		  			
		  		//Validating for Role-E
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
		  		//Login to Navigator with E -Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateLink());
		  		//Expanding the very first item
		  		int iRowCnt=WebTableUtil.getRowCount(Catalog.getNav_CatalogPrivateWebTable());
		  		if(iRowCnt>0)
		  		{
		  			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateFirstExpander());
		  			boolean bCopyBtnStatus=WebObjectUtil.isElementPresent(Catalog.getNav_CatalogPrivateDeployBtn());
		  		
		  			if(!bCopyBtnStatus)
		  			{
		  				FrameworkUtil.updateCustomResultBasedOnStatus(true, "Role E user is unable to deploy Private Catalog items ");
		  			}
		  			else
		  			{
		  				FrameworkUtil.updateCustomResultBasedOnStatus(false, "Role E user is able to deploy Private Catalog items ");
		  			}
		  		}
		  		else
		  		{
		  			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Issue with Private Object WebTable", "fail", "Items not found under PrivateObjects");
		  		}
		  		
		  		//Logging out from Navigator application
		  		LoginTestCase.nav_Logout();
		  	}
		  	
		  	/*==============================================================
		  	TestScript  	: navCatalogPrivateDelete
		  	Manual TestCase	: EVDC- >Catalogs page ->  Private Objects- > Delete  UP-74
		  	Description		:Verify that the below users are able to Delete Private object item successfully.
		  						1. Role A: Full Service Admin 
		  						2. Role C:Full Service User  
		    	Author 			: Vivek Kumar
		  	Creation Date 	: 04/28/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=74)
		  	public void navCatalogPrivateDelete()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navCatalogPrivateDelete";
		  		FrameworkUtil.sManualTestCaseName= "EVDC- >Catalogs page ->  Private Objects- > Delete  UP-74";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, Catalog);
		  			
		  		//Validating for Role-A
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		  		//Login to Navigator with A-Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		//Validating Delete Functionality for Private Object
		  		CatalogTestCase.navPrivateObjectDeleteFunctionality();
		  		
		  	    //Validating for Role-C
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
		  		//Login to Navigator with A-Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		//Validating Delete Functionality for Private Object
		  		CatalogTestCase.navPrivateObjectDeleteFunctionality();
		  	}
		  	
		  	
		  	
		  	/*==============================================================
		  	TestScript  	: navCatalogPrivateDeleteNotVisible
		  	Manual TestCase	: EVDC- >Catalogs page ->  Private Objects- > Delete   UP-75
		  	Description		: Verify that the below user is unable to delete the Private Catalog items 
		  						1. Role E:Full Service Observer   
		  	Author 			: Vivek Kumar
		  	Creation Date 	: 04/24/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=75)
		  	public void navCatalogPrivateDeleteNotVisible()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navCatalogPrivateDeleteNotVisible";
		  		FrameworkUtil.sManualTestCaseName= "EVDC- >Catalogs page ->  Private Objects- > Delete   UP-75";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, Catalog);
		  			
		  		//Validating for Role-E
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
		  		//Login to Navigator with E -Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateLink());
		  		int iRowCnt=WebTableUtil.getRowCount(Catalog.getNav_CatalogPrivateWebTable());
		  		if(iRowCnt>0)
		  		{
		  			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateFirstExpander());
		  			boolean bMoveBtnStatus=WebObjectUtil.isElementPresent(Catalog.getNav_CatalogPrivateDeleteBtn());
		  			if(!bMoveBtnStatus)
		  			{
		  				FrameworkUtil.updateCustomResultBasedOnStatus(true, "Role E user is unable to Delete the Private Catalog items ");
		  			}
		  			else
		  			{
		  				FrameworkUtil.updateCustomResultBasedOnStatus(false, "Role E user is able to Delete the Private Catalog items ");
		  			}
		  		}
		  		else
		  		{
		  			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Issue with Private Object WebTable", "fail", "Items not found under PrivateObjects");
		  		}
		  		
		  		//Logging out from Navigator application
		  		LoginTestCase.nav_Logout();
		  		
		  	}
		  	
		  	/*==============================================================
		  	TestScript  	: navCatalogPrivateMove
		  	Manual TestCase	: EVDC- >Catalogs page ->  Private Objects- > Move  UP-76
		  	Description		: Verify that the below users are able to Move the Private object item successfully.
		  						1. Role A: Full Service Admin 
		  						2. Role C:Full Service User   
		  	Author 			: Vivek Kumar
		  	Creation Date 	: 04/24/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=76)
		  	public void navCatalogPrivateMove()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navCatalogPrivateMove";
		  		FrameworkUtil.sManualTestCaseName= "EVDC- >Catalogs page ->  Private Objects- > Move  UP-76";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, Catalog);
		  			
		  		//Validating for Role-A
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		  		//Login to Navigator with A -Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		//Validating Move Functionality
		  		CatalogTestCase.valPrivateMoveFunctionality();
		  		
		  		//Validating for Role-C
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
		  		//Login to Navigator with C -Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		//Validating Move Functionality
		  		CatalogTestCase.valPrivateMoveFunctionality();
		  	}
		  	
		  	
		  	
		  	/*==============================================================
		  	TestScript  	: navCatalogPrivateMoveNotVisible
		  	Manual TestCase	: EVDC- >Catalogs page ->  Private Objects- > Move  UP-77
		  	Description		: Verify that the below user is unable to move the Private Catalog items 
		  						1. Role E:Full Service Observer   
		  	Author 			: Vivek Kumar
		  	Creation Date 	: 04/24/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=77)
		  	public void navCatalogPrivateMoveNotVisible()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navCatalogPrivateMoveNotVisible";
		  		FrameworkUtil.sManualTestCaseName= "EVDC- >Catalogs page ->  Private Objects- > Move  UP-77";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, Catalog);
		  			
		  		//Validating for Role-E
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
		  		//Login to Navigator with E -Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateLink());
		  		int iRowCnt=WebTableUtil.getRowCount(Catalog.getNav_CatalogPrivateWebTable());
		  		if(iRowCnt>0)
		  		{
		  			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateFirstExpander());
		  			boolean bMoveBtnStatus=WebObjectUtil.isElementPresent(Catalog.getNav_CatalogPrivateMoveBtn());
		  			if(!bMoveBtnStatus)
		  			{
		  				FrameworkUtil.updateCustomResultBasedOnStatus(true, "Role E user is unable to move the Private Catalog items ");
		  			}
		  			else
		  			{
		  				FrameworkUtil.updateCustomResultBasedOnStatus(false, "Role E user is able to move the Private Catalog items ");
		  			}
		  		}
		  		else
		  		{
		  			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Issue with Private Object WebTable", "fail", "Items not found under PrivateObjects");
		  		}
		  		//Logging out from Navigator application
		  		LoginTestCase.nav_Logout();
		  	}
		  	
		  	/*==============================================================
		  	TestScript  	: navCatalogPrivateObjectManage
		  	Manual TestCase	: EVDC- >Catalogs page ->  Private Objects- > Manage Catalogs UP-78
		  	Description		: Verify that the below users are able to view the catalog list successfully.
		  						1. Role A: Full Service Admin 
		  						2. Role C:Full Service User  
		  						3. Role E:Full Service Observer   		
		  	Author 			: Vivek Kumar
		  	Creation Date 	: 04/27/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=78)
		  	public void navCatalogPrivateObjectManage()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navCatalogPrivateObjectManage";
		  		FrameworkUtil.sManualTestCaseName= " EVDC- >Catalogs page ->  Private Objects- > Manage Catalogs UP-78";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, Catalog);
		  			
		  		//Validating for Role-A, that it can access console
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		  		//Login to Navigator with A-Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		CatalogTestCase.navPrivateObjectManageCatalog(sUserName);
		  		
		  		//Validating for Role-C, that it can access console
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
		  		//Login to Navigator with C-Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		CatalogTestCase.navPrivateObjectManageCatalog(sUserName);
		  		
		  		//Validating for Role-E, that it can access console
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
		  		//Login to Navigator with E-Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		CatalogTestCase.navPrivateObjectManageCatalog(sUserName);
		  	}
		  	
		  	
		  	/*==============================================================
		  	TestScript  	: navCatalogPrivateAddCatalog
		  	Manual TestCase	: EVDC- >Catalogs page ->  Private Objects- > Manage Catalogs- > Add Catalog UP-79
		  	Description		: Verify that the below users are able to view the catalog list successfully.
		  						1. Role A: Full Service Admin 
		  						2. Role C:Full Service User  
		  	Author 			: Vivek Kumar
		  	Creation Date 	: 04/23/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=79)
		  	public void navCatalogPrivateAddCatalog()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navCatalogPrivateAddCatalog";
		  		FrameworkUtil.sManualTestCaseName= "EVDC- >Catalogs page ->  Private Objects- > Manage Catalogs- > Add Catalog UP-79";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, Catalog);
		  			
		  		//Validating for Role-A, that it can access console
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		  		//Login to Navigator with A -Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		//validating Add catalog functionality
		  		CatalogTestCase.valPrivateAddCatalogFunctionality(sUserName);
		  		
		  		//Validating for Role-C, that it can access console
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
		  		//Login to Navigator with C -Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		//validating Add catalog functionality
		  		CatalogTestCase.valPrivateAddCatalogFunctionality(sUserName);
		  	}
		  	
		  	/*==============================================================
		  	TestScript  	: navCatalogPrivateAddCatalogNotVisible
		  	Manual TestCase	: EVDC- >Catalogs page ->  Private Objects- > Manage Catalogs- > Add Catalog  UP-80
		  	Description		:Verify that the below user is unable to view Add Catalog in the Manage Catalog page
		  						1. Role E:Full Service Observer 
		    	Author 			: Vivek Kumar
		  	Creation Date 	: 04/28/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=80)
		  	public void navCatalogPrivateAddCatalogNotVisible()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navCatalogPrivateAddCatalogNotVisible";
		  		FrameworkUtil.sManualTestCaseName= " EVDC- >Catalogs page ->  Private Objects- > Manage Catalogs- > Add Catalog  UP-80";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, Catalog);
		  			
		  		//Validating for Role-E, that it can access console
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
		  		//Login to Navigator with E -Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		//Clicking on Private Object Link
		  		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateLink());
		  		//Clicking ManageCatalog
		  		//WebObjectUtil.clickAndVerifyElement(Catalog.getNav_CatalogPrivateManageCatalogBtn(), Catalog.getNav_CatalogPrivateAddCatalogLink());
		  		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateManageCatalogBtn());
		  		boolean bAddCatalogStatus=WebObjectUtil.isElementPresent(Catalog.getNav_CatalogPrivateAddCatalogLink());
		  		if(!bAddCatalogStatus)
		  		{
		  			FrameworkUtil.updateCustomResultBasedOnStatus(true, "Role E user is unable to view add Catalog in the Manage Catalog Page ");
		  		}
		  		else
		  		{
		  			FrameworkUtil.updateCustomResultBasedOnStatus(false, "Role E user is able to view add Catalog in the Manage Catalog Page ");
		  		}
		  		
		  		//Logging out from Navigator application
		  		LoginTestCase.nav_Logout();
		  	}
		  	
		  	
		  	
		  	/*==============================================================
		  	TestScript  	: navCatalogPrivateAddCatalogEdit
		  	Manual TestCase	: EVDC- >Catalogs page ->  Private Objects- > Manage Catalogs- > Edit catalog UP-81
		  	Description		: Verify that the below users are able to edit the catalog item successfully.
		  						1. Role A: Full Service Admin 
		  						2. Role C:Full Service User 
		  	Author 			: Vivek Kumar
		  	Creation Date 	: 04/23/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=81)
		  	public void navCatalogPrivateAddCatalogEdit()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navCatalogPrivateAddCatalogEdit";
		  		FrameworkUtil.sManualTestCaseName= " EVDC- >Catalogs page ->  Private Objects- > Manage Catalogs- > Edit catalog UP-81";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, Catalog);
		  			
		  		//Validating for Role-A, that it can access console
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		  		//Login to Navigator with A-Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		//Validate Manage Catlog Edit Functionality
		  		CatalogTestCase.valPrivateAddCatalogEditFunctionality(sUserName);
		  		
		  		//Validating for Role-C, that it can access console
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
		  		//Login to Navigator with C -Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		//Validate Manage Catlog Edit Functionality
		  		CatalogTestCase.valPrivateAddCatalogEditFunctionality(sUserName);
		  		

		  	}
		  	
		  	/*==============================================================
		  	TestScript  	: navCatalogPrivateAddCatalogEditNotVisible
		  	Manual TestCase	: EVDC- >Catalogs page ->  Private Objects- > Manage Catalogs- > Edit catalog  UP-82
		  	Description		: Verify that the below user is unable to edit Catalog item 
		  						1. Role E:Full Service Observer  
		    	Author 			: Vivek Kumar
		  	Creation Date 	: 04/28/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=82)
		  	public void navCatalogPrivateAddCatalogEditNotVisible()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navCatalogPrivateAddCatalogEditNotVisible";
		  		FrameworkUtil.sManualTestCaseName= "EVDC- >Catalogs page ->  Private Objects- > Manage Catalogs- > Edit catalog  UP-82";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, Catalog);
		  			
		  		//Validating for Role-E, that it can access console
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
		  		//Login to Navigator with E -Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		
		  		//Clicking on Private Object Link
		  		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateLink());
		  		//Clicking ManageCatalog
		  		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateManageCatalogBtn());
		  		WebObjectUtil.explicitWait(2);
		  		int iRowCnt=WebTableUtil.getRowCount(Catalog.getNav_CatalogPrivateManageCatalogWebTable());
		  		
		  		if(iRowCnt>0){
		  			/*WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateAddCatalogFirstExpander());
		  			boolean bEditStatus=WebObjectUtil.isElementPresent(Catalog.getNav_CatalogPrivateAddCatalogEditBtn());
		  			*/
		  			boolean bEditStatus=WebObjectUtil.isElementPresent(Catalog.getNav_CatalogPrivateAddCatalogFirstExpander());
		  			if(!bEditStatus)
		  			{
		  				FrameworkUtil.updateCustomResultBasedOnStatus(true, "Role E user is unable to Edit Catalog Item ");
		  			}
		  			else
		  			{
		  				FrameworkUtil.updateCustomResultBasedOnStatus(false, "Role E user is able to Edit CAtalog item");
		  			}
		  			//closing the Manage Catlow window
		  			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateAddCatalogCloseBtn());
		  			
		  			}
		  		else
		  		{
		  			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Issue with Private Object Manage Catalog  WebTable", "fail", "Items not found under PrivateObjects");
		  		}
		  		
		  		//Logging out from Navigator application
		  		LoginTestCase.nav_Logout();
		  	}
		  	
		  	/*==============================================================
		  	TestScript  	: navCatalogPrivateManageCatalogDelete
		  	Manual TestCase	: EVDC- >Catalogs page ->  Private Objects- > Manage Catalogs- > Delete catalog  UP-83
		  	Description		: Verify that the below users are able to deleted the catalog item successfully.
		  						1. Role A: Full Service Admin 
		  						2. Role C:Full Service User 
		    	Author 			: Vivek Kumar
		  	Creation Date 	: 04/28/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=83)
		  	public void navCatalogPrivateManageCatalogDelete()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navCatalogPrivateManageCatalogDelete";
		  		FrameworkUtil.sManualTestCaseName= "EVDC- >Catalogs page ->  Private Objects- > Manage Catalogs- > Delete catalog  UP-83";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, Catalog);
		  			
		  		//Validating for Role-A, that it can access console
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		  		//Login to Navigator with A-Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		CatalogTestCase.navPrivateObjectManageCatalogDeleteFunctionality();
		  		
		  		//Validating for Role-C, that it can access console
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
		  		//Login to Navigator with C-Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		CatalogTestCase.navPrivateObjectManageCatalogDeleteFunctionality();
		  		
		  	}
		  	
		  	
		  	
		  	
		  	/*==============================================================
		  	TestScript  	: navCatalogPrivateManageCatalogDeleteNotVisible
		  	Manual TestCase	: EVDC- >Catalogs page ->  Private Objects- > Manage Catalogs- > Delete catalog  UP-84
		  	Description		: Verify that the below user is unable to delete Catalog item 
		  						1. Role E:Full Service Observer  
		    	Author 			: Vivek Kumar
		  	Creation Date 	: 04/28/2015
		  	Pre-Requisites	:
		  	Revision History:
		  	==============================================================*/
		  	@Test(priority=84)
		  	public void navCatalogPrivateManageCatalogDeleteNotVisible()
		  	{
		  		String sUserName,sPassword;
		  		FrameworkUtil.sTestCaseName = "UserPermission-navCatalogPrivateManageCatalogDeleteNotVisible";
		  		FrameworkUtil.sManualTestCaseName= "EVDC- >Catalogs page ->  Private Objects- > Manage Catalogs- > Delete catalog  UP-84";
		  		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		  		WebDriver driver = WebDriverUtil.getDriver();
		  		PageFactory.initElements(driver, Catalog);
		  			
		  		//Validating for Role-E, that it can access console
		  		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
		  		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
		  		//Login to Navigator with E -Role
		  		LoginTestCase.nav_Login(sUserName,sPassword);
		  		//Navigate to Catalog Page
		  		CatalogTestCase.navigateCatalogPage();
		  		
		  		//Clicking on Private Object Link
		  		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateLink());
		  		//clicking on ManageCatalog Button
		  		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateManageCatalogBtn());
		  		WebObjectUtil.explicitWait(2);
		  		int iRowCnt=WebTableUtil.getRowCount(Catalog.getNav_CatalogPrivateManageCatalogWebTable());
		  		if(iRowCnt>0)
		  		{
		  			//Expand the first Catalog
		  			/*WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateAddCatalogFirstExpander());
		  			boolean bDeleteStatus=WebObjectUtil.isElementPresent(Catalog.getNav_CatalogPrivateAddCatalogEditBtn());
		  			*/
		  			boolean bDeleteStatus=WebObjectUtil.isElementPresent(Catalog.getNav_CatalogPrivateAddCatalogFirstExpander());
		  			if(!bDeleteStatus)
		  			{
		  				FrameworkUtil.updateCustomResultBasedOnStatus(true, "Role E user is unable to Delete Catalog Item ");
		  			}
		  			else
		  			{
		  				FrameworkUtil.updateCustomResultBasedOnStatus(false, "Role E user is able to Delete CAtalog item");
		  			}
		  			//closing the Manage Catlow window
		  			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateAddCatalogCloseBtn());
		  			
		  		}
		  		else
		  		{
		  			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Issue with Private Object Manage Catalog  WebTable", "fail", "Items not found under PrivateObjects");
		  		}
		  		
		  		//Logging out from Navigator application
		  		LoginTestCase.nav_Logout();
		  		
		  	}
		  	
		  	

		
	//#######################################################################################################
								//METHODS
	//#######################################################################################################	
		
		/*==============================================================
		Method Name 	: navValidateEVDCPortletMultiUsr
		Description		: Verify that the below users are able to view the EVDC portlet  successfully.
							1. Role A: Full Service Admin 
							2. Role C:Full Service User  
							3. Role E:Full Service Observer 
		Author 			: Vivek Kumar
		Creation Date 	: 03/31/2015
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		public void navValidateEVDCPortletMultiUsr(String sUserName,String sPassword)
		{
			LoginTestCase.nav_Login(sUserName,sPassword);
			
			String sEVDCUser;
			//Verifying EVDC portlet at the bottom of homepage
			WebObjectUtil.verifyElementPresent(UserPermission.getNav_UPEVDCPortletParent());
			//Getting the EVDC User Name 
			sEVDCUser=UserPermission.getNav_EVDCNameLink().getText();
			LoggerUtil.log_type_info("EVDC User Name = "+ sEVDCUser);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "EVDC User Name", "DONE", sEVDCUser);
			
			//Logging out from Navigator application
			LoginTestCase.nav_Logout();
		}
		
		
		/*==============================================================
		Method Name 	: navEVDCViewVM
		Description		: User with role can view VMs
		Author 			: Vivek Kumar
		Creation Date 	: 03/31/2015
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		public void navEVDCViewVM(String sUserName,String sPassword)
		{
			LoginTestCase.nav_Login(sUserName,sPassword);
			WebObjectUtil.clickAndVerifyElement(UserPermission.getNav_EVDCNameLink(), UserPermission.getNav_EVDCOrgSelector());
			//WebObjectUtil.selectCustomWebList(UserPermission.getNav_EVDCOrgSelector(), "Andover, MA - Navigator");
			WebObjectUtil.ClickAndMouseHover(UserPermission.getNav_EVDCOrgSelector());
			WebObjectUtil.selectCustomWebList(UserPermission.getNav_EVDCOrgSelectorDropDown(), 1);
			WebObjectUtil.clickElement(UserPermission.getNav_EVDCOverviewVirtualMachineLink());
			boolean bAddVMStatus=WebObjectUtil.isElementPresent(UserPermission.getNav_VMTable());
			FrameworkUtil.updateCustomResultBasedOnStatus(bAddVMStatus, sUserName +" can view VMs");
			//Logging out from Navigator application
			LoginTestCase.nav_Logout();
		}
		
		
		/*==============================================================
		Method Name 	: navEVDCVMStart
		Description		: User with role can start VMs
		Author 			: Vivek Kumar
		Creation Date 	: 03/31/2015
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		public void navEVDCValVMStart(String sUserName,String sPassword )
		{
			
			WebDriver driver = WebDriverUtil.getDriver();
			
			PageFactory.initElements(driver, EVDC_Overview);
			PageFactory.initElements(driver, EVDC_VMPF);
			LoginTestCase.nav_Login(sUserName,sPassword);
			navigateAndExpandVMUserPermission("Stopped");
			int iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum ;
			if (iRowNbr > 0 ){
				//This line updated on 10/13/2015 by QAA03 for EXTJS5
				//String sLocationValue = "//table/tbody/tr[" + iRowNbr + "]/td/table/tbody/tr[2]//a[contains(text(),'Start')]";
				String sLocationValue = "//table[" + iRowNbr + "]/tbody/tr[2]/td//a[text()='Start']";
				WebElement startBtn = WebObjectUtil.GetWebElement("xpath", sLocationValue,"Start Button");
				//startVM.click();
				WebObjectUtil.clickElement(startBtn);
			}
			//boolean bVMStartStatus=WebObjectUtil.isElementPresent(UserPermission.getNav_StartPopUpMsg());
			//FrameworkUtil.updateCustomResultBasedOnStatus(bVMStartStatus, sUserName + " able to start VM");
			if(WebObjectUtil.isElementPresent(UserPermission.getNav_StartPopUpMsg()))
			{
				WebObjectUtil.waitForElementNotPresent(UserPermission.getNav_StartPopUpMsg());
			}
			//Verifying the success message
			String sExpectedStartMsg,sVMName,sExpectedMessage,sActualMessage;
			sVMName=EVDC_VM_TestCase.navGetVMName(iRowNbr);
			sExpectedStartMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.START.USERMSG");
			sExpectedMessage=sVMName + " " + sExpectedStartMsg;
			//Getting text from appliaction
			sActualMessage=EVDC_VMPF.getNav_UserfeedBack().getText();
			if(EVDC_VM_TestCase.navEVDCValExpectedActualMsg(sExpectedMessage,sActualMessage))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Start VM "    , "pass",sUserName + " -users is able to start the VMs.") ;
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Start VM "    , "fail",sUserName + " -users is not able to start the VMs.") ;
			}
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//Logging out from Navigator application
			LoginTestCase.nav_Logout();
		}
		
		
		/*==============================================================
		Method Name 	: navEVDCValVMStop
		Description		: User with role can stop VMs
		Author 			: Vivek Kumar
		Creation Date 	: 04/02/2015
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		public void navEVDCValVMStop(String sUserName,String sPassword )
		{
			
			WebDriver driver = WebDriverUtil.getDriver();
			
			PageFactory.initElements(driver, EVDC_Overview);
			PageFactory.initElements(driver, EVDC_VMPF);
			LoginTestCase.nav_Login(sUserName,sPassword);
			
			navigateAndExpandVMUserPermission("Running");
			int iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum ;
			if (iRowNbr > 0 ){
				//This line updated on 10/13/2015 for EXTJS5 by QAA03
				//String sLocationValue = "//table/tbody/tr["+ iRowNbr+"]/td/table/tbody/tr[2]//a[contains(text(),'Stop')]";
				String sLocationValue = "//table["+ iRowNbr+"]/tbody/tr[2]//a[text()='Stop']";
				WebElement wStopVM = WebObjectUtil.GetWebElement("xpath", sLocationValue,"Stop Button");
				//wStopVM.click();
				WebObjectUtil.clickElement(wStopVM);
			}
			//boolean bVMStartStatus=WebObjectUtil.isElementPresent(UserPermission.getNav_StartPopUpMsg());
			//FrameworkUtil.updateCustomResultBasedOnStatus(bVMStartStatus, sUserName + " able to stop VM");
			WebObjectUtil.waitForElementNotPresent(UserPermission.getNav_StopPopUpMsg());
			WebObjectUtil.explicitWait(30);
			//Verifying Success message
			String sExpectedStopMsg,sVMName,sExpectedMessage,sActualMessage;
			sVMName=EVDC_VM_TestCase.navGetVMName(iRowNbr);
			sExpectedStopMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.STOP.USERMSG");
			sExpectedMessage=sVMName + " " + sExpectedStopMsg;
			
			//Getting text from appliaction
			sActualMessage=EVDC_VMPF.getNav_UserfeedBack().getText();
			if(EVDC_VM_TestCase.navEVDCValExpectedActualMsg(sExpectedMessage,sActualMessage))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Stop VM "    , "pass",sUserName + " -users is able to stop the VMs.") ;
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Stop VM "    , "fail",sUserName + " -users is not able to stop the VMs.") ;
			}
			
			//Logging out from Navigator application
			LoginTestCase.nav_Logout();
		}
		
		
		/*==============================================================
		Method Name 	: navEVDCValVMSuspend
		Description		: User with role can suspend VMs
		Author 			: Vivek Kumar
		Creation Date 	: 04/02/2015
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		public void navEVDCValVMSuspend(String sUserName,String sPassword )
		{
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, EVDC_Overview);
			PageFactory.initElements(driver, EVDC_VMPF);
			LoginTestCase.nav_Login(sUserName,sPassword);
			
			navigateAndExpandVMUserPermission("Running");
			int iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum ;
			iRowNbr=startVM( iRowNbr);
			if (iRowNbr > 0 ){
				//This line updated on 10/13/2015 for EXTJS5 by QAA03
				//String sLocationValue = "//table/tbody/tr["+ iRowNbr+"]/td/table/tbody/tr[2]//a[contains(text(),'Suspend')]";
				String sLocationValue = "//table["+ iRowNbr+"]/tbody/tr[2]//a[text()='Suspend']";
				WebElement wSuspendVM = WebObjectUtil.GetWebElement("xpath", sLocationValue,"Suspend Button");
				//wStopVM.click();
				WebObjectUtil.clickElement(wSuspendVM);
			}
			//boolean bVMStartStatus=WebObjectUtil.isElementPresent(UserPermission.getNav_StartPopUpMsg());
			//FrameworkUtil.updateCustomResultBasedOnStatus(bVMStartStatus, sUserName + " able to Suspend VM");
			WebObjectUtil.waitForElementNotPresent(UserPermission.getNav_SuspendPopUpMsg());
			//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			//Verifying Success message
			//Verifying Success message
				String sExpectedStopMsg,sVMName,sExpectedMessage,sActualMessage;
				sVMName=EVDC_VM_TestCase.navGetVMName(iRowNbr);
				sExpectedStopMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.SUSPEND.USERMSG");
				sExpectedMessage=sVMName + " " + sExpectedStopMsg;
					
				//Getting text from appliaction
				sActualMessage=EVDC_VMPF.getNav_UserfeedBack().getText();
				if(EVDC_VM_TestCase.navEVDCValExpectedActualMsg(sExpectedMessage,sActualMessage))
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " suspend VM "    , "pass",sUserName + " -users is able to suspend the VMs.") ;
				}
				else
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " suspend VM "    , "fail",sUserName + " -users is not able to suspend the VMs.") ;
				}
			//Logging out from Navigator application
			LoginTestCase.nav_Logout();
		}
		
		
		/*==============================================================
		Method Name 	: navEVDCValVMReset
		Description		: User with role can Reset VMs
		Author 			: Vivek Kumar
		Creation Date 	: 04/02/2015
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		public void navEVDCValVMReset(String sUserName,String sPassword )
		{
			
			WebDriver driver = WebDriverUtil.getDriver();
			
			PageFactory.initElements(driver, EVDC_Overview);
			PageFactory.initElements(driver, EVDC_VMPF);
			LoginTestCase.nav_Login(sUserName,sPassword);
			
			navigateAndExpandVMUserPermission("Running");
			int iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum ;
			iRowNbr=startVM( iRowNbr);
			if (iRowNbr > 0 ){
				// This line updated on 10/13/2015 for EXTJS5 by QAA03
				//String sLocationValue = "//table/tbody/tr["+ iRowNbr+"]/td/table/tbody/tr[2]//a[contains(text(),'Reset')]";
				String sLocationValue = "//table["+ iRowNbr+"]/tbody/tr[2]//a[text()='Reset']";
				WebElement wResetVM = WebObjectUtil.GetWebElement("xpath", sLocationValue,"Reset Button");
				//wStopVM.click();
				WebObjectUtil.clickElement(wResetVM);
			
					//boolean bVMStartStatus=WebObjectUtil.isElementPresent(UserPermission.getNav_StartPopUpMsg());
					//FrameworkUtil.updateCustomResultBasedOnStatus(bVMStartStatus, sUserName + " able to Reset VM");
					WebObjectUtil.waitForElementNotPresent(UserPermission.getNav_RefreshPopUpMsg());
					//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
					String sExpectedStopMsg,sVMName,sExpectedMessage,sActualMessage;
					sVMName=EVDC_VM_TestCase.navGetVMName(iRowNbr);
					sExpectedStopMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.RESET.USERMSG");
					sExpectedMessage=sVMName + " " + sExpectedStopMsg;
						
					//Getting text from appliaction
					sActualMessage=EVDC_VMPF.getNav_UserfeedBack().getText();
					if(EVDC_VM_TestCase.navEVDCValExpectedActualMsg(sExpectedMessage,sActualMessage))
					{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " reset VM "    , "pass",sUserName + " -users is able to reset the VMs.") ;
					}
					else
					{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " reset VM "    , "fail",sUserName + " -users is not able to reset the VMs.") ;
					}
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "reset VM "    , "fail", " -No VM is in running status.") ;
				
			}
			//Logging out from Navigator application
			LoginTestCase.nav_Logout();
		}
		
		
		/*==============================================================
		Method Name 	: navEVDCValVMCreateTicket
		Description		: User with role can create a ticket
		Author 			: Vivek Kumar
		Creation Date 	: 04/02/2015
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		public void navEVDCValVMCreateTicket(String sUserName,String sPassword )
		{
			
			WebDriver driver = WebDriverUtil.getDriver();
			
			PageFactory.initElements(driver, EVDC_Overview);
			PageFactory.initElements(driver, EVDC_VMPF);
			LoginTestCase.nav_Login(sUserName,sPassword);
			
			navigateAndExpandVMUserPermission("Stopped");
			int iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum ;
			EVDC_VM_TestCase.VMCreateTicket(iRowNbr);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			//Logging out from Navigator application
			LoginTestCase.nav_Logout();
		}
		
		/*==============================================================
		Method Name 	: navEVDCValConsole
		Description		: User with role can access console
		Author 			: Vivek Kumar
		Creation Date 	: 04/08/2015
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		public void navEVDCValConsole(String sUserName,String sPassword )
		{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, EVDC_Overview);
			PageFactory.initElements(driver, EVDC_VMPF);
			
			try {
				LoginTestCase.nav_Login(sUserName,sPassword);
				navigateAndExpandVMUserPermission("Running");
				int iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum ;
				iRowNbr=startVM( iRowNbr);
				EVDC_VM_TestCase.navValConsole(iRowNbr);
				//Closing Console window
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_ConsoleClose());
				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				//Logging out from Navigator application
				LoginTestCase.nav_Logout();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		/*==============================================================
		Method Name 	: navEditDescriptionUpdate
		Description		: User with role A &C can access Edit
		Author 			: Vivek Kumar
		Creation Date 	: 04/14/2015
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		public void navEditDescriptionUpdate(int iRowNbr,String sUserName)
		{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, UserPermission);
			PageFactory.initElements(driver, EVDC_Overview);
			PageFactory.initElements(driver, EVDC_VMPF);
			PageFactory.initElements(driver, Catalog);
			
			String sTestDescription="test description";
			String sExpectedMessage,sVMName = null,sExpSuccessMsg = null,sActualMessage;
			sExpSuccessMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.ADDDISK");
			
			try {
				sVMName=EVDC_VM_TestCase.navGetVMName(iRowNbr);
				//Updating info in Description input box
				WebObjectUtil.SetValueEdit(EVDC_VMPF.getNav_EditDescriptionInput(), sTestDescription);
				//clicking on Save Edit
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMSaveBtn());
				if(WebObjectUtil.isElementPresent(Catalog.getNav_NewCatalogPopUpBody()))
				{
					WebObjectUtil.clickElement(Catalog.getNav_NewCatalogPopUpOKBtn());
				}
				else
				{
					WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMCommit());
				}
				
				//WebObjectUtil.waitForElementPresent(EVDC.getNav_PlzWaitPopUpMsg());
				Thread.sleep(2000);
				WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_PlzWaitPopUpMsg());
				//Thread.sleep(10000);
				if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_GuestOSChangeSIDErrMsg())&& (EVDC_VMPF.getNav_GuestOSChangeSIDErrMsg().isDisplayed()))
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VM Update failed" , "fail",EVDC_VMPF.getNav_GuestOSChangeSIDErrMsg().getText() );
					LoggerUtil.log_type_error("VM Update failed" + EVDC_VMPF.getNav_GuestOSChangeSIDErrMsg().getText());
					WebObjectUtil.clickElement(EVDC_VMPF.getNav_GuestOSErrorMsgOKBtn());
					
				}
				/*
				if(WebObjectUtil.isElementPresent(EVDC.getNav_RefreshPopUpMsg()))
				{
					WebObjectUtil.waitForElementNotPresent(EVDC.getNav_RefreshPopUpMsg());
				}*/
				
				sExpectedMessage=sVMName + sExpSuccessMsg;
				sActualMessage=EVDC_VMPF.getNav_UserfeedBack().getText();
				boolean flag=EVDC_VM_TestCase.navEVDCValExpectedActualMsg(sExpectedMessage,sActualMessage);
				if(flag)
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Edit tab" , "pass", sUserName + " able to Edit the VMs.") ;
					LoggerUtil.log_type_info(sUserName + " users are able to Edit the VMs." );
				}
				else
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Edit Tab" , "fail",sUserName + "not able to Edit the VMs.") ;
					LoggerUtil.log_type_error(sUserName + " not to Edit the VMs." );
				}
				
				
				//Logging out from Navigator application
				LoginTestCase.nav_Logout();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "exception occured" , "fail",e.getMessage()) ;
			}
			
		}
		
		/*==============================================================
		Method Name 	: navAddVM
		Description		: User with role A &C can access Add VM
		Author 			: Vivek Kumar
		Creation Date 	: 04/14/2015
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		public void navAddVM(String sVMName,String sUserName)
		{
			WebDriver driver=WebDriverUtil.getDriver();
			PageFactory.initElements(driver, EVDC_Overview);
			PageFactory.initElements(driver, EVDC_VMPF);
			
			try {
				//Clicking on EVDC Link
				WebObjectUtil.clickAndVerifyElement(EVDC_Overview.getNav_EVDCname(), EVDC_Overview.getNav_EVDCOverviewVirtualMachine());
				//Clicking on Virtual machine
				WebObjectUtil.clickAndVerifyElement(EVDC_Overview.getNav_EVDCOverviewVirtualMachine(), EVDC_VMPF.getNav_AddVMLink());
				WebObjectUtil.clickAndVerifyElement(EVDC_VMPF.getNav_AddVMLink(), EVDC_VMPF.getNav_AddVMSelectVMType());
				
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_VMSelectType());
				//Clicking and selecting on Blank VM
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_AddVMfromTemplate());
				//Clicking on WindStream object
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_AddVMWindstreamObject());
				Thread.sleep(5000);
				//Clicking on first Template
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_ClickingVMfromTemplate());
				//Adding VM
				boolean flag=EVDC_VM_TestCase.navAddVMDialogSubmit(sVMName);
				if(flag)
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Add VM" , "pass", sUserName + " able to add VMs.") ;
					LoggerUtil.log_type_info(sUserName + " users are able to Add VMs." );
				}
				else
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Add VM" , "fail",sUserName + "not able to add VMs.") ;
					LoggerUtil.log_type_error(sUserName + " not able to Add VMs." );
				}	
				
				
				//Logging out from Navigator application
				LoginTestCase.nav_Logout();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		/*==============================================================
		Method Name 	: startVM
		Description		: starting the stopped vm
		Author 			: Vivek Kumar
		Creation Date 	: 05/20/2015
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		public int startVM(int iRowNbr)
		{
			
		try {
			if(iRowNbr==0)
			{
				iRowNbr=1;
				EVDC_VM_AdvancedActions.expandVMbyRowNum(iRowNbr);
				//This line updated on 10/13/2015 by QAA03 for EXTJS5
				//String sLocationValue = "//table/tbody/tr[" + iRowNbr + "]/td/table/tbody/tr[2]//a[contains(text(),'Start')]";
				String sLocationValue = "//table[" + iRowNbr + "]/tbody/tr[2]/td//a[text()='Start']";
				WebElement startBtn = WebObjectUtil.GetWebElement("xpath", sLocationValue,"Start Button");
				//startVM.click();
				WebObjectUtil.clickElement(startBtn);
				WebObjectUtil.waitForElementPresent(UserPermission.getNav_RefreshPopUpMsg());
				WebObjectUtil.waitForElementNotPresent(UserPermission.getNav_RefreshPopUpMsg());
				WebDriverUtil.refreshBrowser();
				EVDC_VM_AdvancedActions.expandVMbyRowNum(iRowNbr);
				
				
			}
		} catch (Exception e) {
			LoggerUtil.log_type_error("Exception occured:" + e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage());

		}
			return iRowNbr;
		}
		
		
		
		
		
		 //UserPermission for Role A & C
		 public static boolean navigateAndExpandVMUserPermission(String VMnameOrStatus){
				boolean bStatus = false;
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, EVDC_Overview);
				PageFactory.initElements(driver, EVDC_VMPF);
				
				try {
					
					//Login to Navigator
					//EVDCTestCase.navEVDCLogin()
					int iRowNo;
					//Clicking on EVDC Name and validating its landing page

					WebObjectUtil.clickAndVerifyElement(EVDC_Overview.getNav_EVDCname(), EVDC_Overview.getNav_EVDCOverviewVirtualMachine());
					WebObjectUtil.clickAndVerifyElement(EVDC_Overview.getNav_EVDCOverviewVirtualMachine(),EVDC_VMPF.getNav_AddVMLink());
						//iRowNo = getRow_EVDC_VMTable(EVDC_Advanced.getNav_EVDCVMTable(),VMnameOrStatus,"");
					iRowNo = EVDC_VM_AdvancedActions.getRow_EVDC_VMTable(EVDC_VMPF.getNav_VMWebTable(),VMnameOrStatus,"");
					if (iRowNo > 0 ){
						bStatus = true;
						EVDC_VM_AdvancedActions.expandVMbyRowNum(iRowNo);
					}
					EVDC_VM_AdvancedActions.iVisibleVMRowNum = iRowNo;
				} catch (Exception e) {
					LoggerUtil.log_type_error("Exception occured:" + e.getMessage());
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage());
				}

				return bStatus;
			}
			
		 
		 
		 //UserPermission for Role E
			public static boolean navigateAndExpandVMforRoleE(String VMnameOrStatus){
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, EVDC_VMPF);
				PageFactory.initElements(driver, EVDC_Overview);
				boolean bStatus = false;
				try {
					
					int iRowNo;
					//Clicking on EVDC Name and validating its landing page

					WebObjectUtil.clickAndVerifyElement(EVDC_Overview.getNav_EVDCname(), EVDC_Overview.getNav_EVDCOverviewVirtualMachine());
					WebObjectUtil.clickAndVerifyElement(EVDC_Overview.getNav_EVDCOverviewVirtualMachine(),EVDC_VMPF.getNav_PDFImg());
						//iRowNo = getRow_EVDC_VMTable(EVDC_Advanced.getNav_EVDCVMTable(),VMnameOrStatus,"");
					iRowNo = EVDC_VM_AdvancedActions.getRow_EVDC_VMTable(EVDC_VMPF.getNav_VMWebTable(),VMnameOrStatus,"");
					
					if (iRowNo > 0 ){
						bStatus = true;
						EVDC_VM_AdvancedActions.expandVMbyRowNum(iRowNo);
					}
					EVDC_VM_AdvancedActions.iVisibleVMRowNum = iRowNo;
				} catch (Exception e) {
					LoggerUtil.log_type_error("Exception occured:" + e.getMessage());
				}

				return bStatus;
			}
		 
			
	/////############################################# vivek  #############################################################


//####################################  Sukur   ####################################################
		/*==============================================================
		TestScript 		: UserPermission
		Manual TestCase	: Reports page is viewable by given users
		Description		: Verifying the Reports page display with users ARole-A,CRole-C and ERole-E
		Author 			: Sukur Babu. B
		Creation Date 	: 01/06/2015
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		@Test(priority=101)
		public void AccessToviewReportsTest(){
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, UserPermission);	
			String sUserName;
			String sPassword;
		
			FrameworkUtil.sTestCaseName = "UserPermissions-AccessToviewReportsTest";
			FrameworkUtil.sManualTestCaseName="Verify access to Reports for given user";
			//Update results with Manual test case name
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			//Read user name and password from properties file
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
			//Verify the Reports page is viewable by User ARole-A
			AccessToViewReports(sUserName, sPassword);
			//Log out from Navigator
			LoginTestCase.nav_Logout();
			//Read user name and password from properties file
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
			//Verify the Reports page is viewable by User CRole-C
			AccessToViewReports(sUserName, sPassword);
			//Log out from Navigator
			LoginTestCase.nav_Logout();
			//Read user name and password from properties file
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
			//Verify the Reports page is viewable by User ERole-E
			AccessToViewReports(sUserName, sPassword);
			//Log out from Navigator
			LoginTestCase.nav_Logout();
		}
		/*==============================================================
		TestScript 		: UserPermission
		Manual TestCase	: Given user is able to perform add user
		Description		: Verifying the add user functionality is accessible with users ARole-A
		Author 			: Sukur Babu. B
		Creation Date 	: 04/07/2015
		Pre-Requisites	:
		Revision History:Commented validation of add user functionality test statements as per Sirisha's comments
		==============================================================*/
		@Test(priority=102)
		public void AccessToAddUser()
		{
			try {
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, UserPermission);	
			
			String sUserNameA,sUserNameC,sUserNameE ;
			String sPasswordA,sPasswordC,sPasswordE;
			String sConfirmMsg = "Successfully created a ticket with TicketId";
			String sFeedbackMsg="Successfully created a ticket with TicketId";
			//Read user name and password from properties file
			sUserNameA = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
			sPasswordA = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
			
			
			//Update results with manual test case name
			FrameworkUtil.sTestCaseName = "UserPermissions-AccessToAddUser";
			FrameworkUtil.sManualTestCaseName="Verify that given user is  having access to Add User";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			//Login into Navigator	
			LoginTestCase.nav_Login(sUserNameA, sPasswordA);
			//Navigate to Critical Escalation list page
			NavigateToCriticalEscalationListPage();
			//Click on Authorization Contact List tab
			WebObjectUtil.clickElement(UserPermission.getNav_AuthorizedContactListTab());
			WebObjectUtil.explicitWait(20);
			//-----------------------------------------------------------------------------------
			//updated below 2 lines as part of EXTJS5 updation by QAA03 on 22sep2015
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_AddUserRoleLink());
			WebObjectUtil.verifyElementPresent(UserPermission.getNav_AddUserRoleLink());
			
			
/*			WebObjectUtil.waitForElementPresent(UserPermission.getNav_AddUserLink());
			WebObjectUtil.verifyElementPresent(UserPermission.getNav_AddUserLink());*/
			//-----------------------------------------------------------------------------------
			//Click on Add User button
			/*WebObjectUtil.clickElement(UserPermission.getNav_AddUserLink());
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_AddUserWindowOkButton());
			//Enter all required field values in Add user pop up window
			EnterAllRequiredFieldsInAddUserPopupWindow();
			//Thread.sleep(2000);
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_AddUserWindowOkButton());
			//Click on OK button in Add user pop up window
			WebObjectUtil.clickElement(UserPermission.getNav_AddUserWindowOkButton());
			//WebObjectUtil.waitForElementPresent(UserPermission.getNav_PopupWindow());
			//Verify the confirmation message displayed in the pop up window
			WebObjectUtil.verifyElementPresent(UserPermission.getNav_AddUserSucessMessage());
			//boolean bConfirmMsg = UserPermission.getNav_PopupWindow().getText().contains(sConfirmMsg);
			//FrameworkUtil.updateCustomResultBasedOnStatus(bConfirmMsg,sConfirmMsg);
			WebObjectUtil.clickElement(UserPermission.getNav_AddUserSucessMessageOKButton());
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_FeedBackArea());
			//Verify the confirmation message displayed in FeedBack area
			boolean bFeedbackMsgC = UserPermission.getNav_FeedBackArea().getText().contains(sFeedbackMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bFeedbackMsgC,sFeedbackMsg);*/
			//Log out from Navigator
			LoginTestCase.nav_Logout();
			sUserNameC = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
			sPasswordC = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
			
			
			LoginTestCase.nav_Login(sUserNameC, sPasswordC);
			//Navigate to Critical Escalation list page
			NavigateToCriticalEscalationListPage();
			//Click on Authorization Contact List tab
			WebObjectUtil.clickElement(UserPermission.getNav_AuthorizedContactListTab());
			//-----------------------------------------------------------------------------------
			//updated below 2 lines as part of EXTJS5 updation by QAA03 on 22sep2015
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_AddUserRoleLink());
			WebObjectUtil.verifyElementPresent(UserPermission.getNav_AddUserRoleLink());
			
			/*WebObjectUtil.waitForElementPresent(UserPermission.getNav_AddUserLink());
			WebObjectUtil.verifyElementPresent(UserPermission.getNav_AddUserLink());*/
			//-----------------------------------------------------------------------------------
			//Click on Add User button
			/*WebObjectUtil.clickElement(UserPermission.getNav_AddUserLink());
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_AddUserWindowOkButton());
			//Enter all required field values in Add user pop up window
			EnterAllRequiredFieldsInAddUserPopupWindow();
			//Thread.sleep(2000);
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_AddUserWindowOkButton());
			//Click on OK button in Add user pop up window
			WebObjectUtil.clickElement(UserPermission.getNav_AddUserWindowOkButton());
			//WebObjectUtil.waitForElementPresent(UserPermission.getNav_PopupWindow());
			//Verify the confirmation message displayed in the pop up window
			WebObjectUtil.verifyElementPresent(UserPermission.getNav_AddUserSucessMessage());
			//boolean bConfirmMsg = UserPermission.getNav_PopupWindow().getText().contains(sConfirmMsg);
			//FrameworkUtil.updateCustomResultBasedOnStatus(bConfirmMsg,sConfirmMsg);
			WebObjectUtil.clickElement(UserPermission.getNav_AddUserSucessMessageOKButton());
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_FeedBackArea());
			//Verify the confirmation message displayed in FeedBack area
			boolean bFeedbackMsgC = UserPermission.getNav_FeedBackArea().getText().contains(sFeedbackMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bFeedbackMsgC,sFeedbackMsg);*/
			//Log out from Navigator
			LoginTestCase.nav_Logout();
			sUserNameE = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
			sPasswordE = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
			
			LoginTestCase.nav_Login(sUserNameE, sPasswordE);
			//Navigate to Critical Escalation list page
			NavigateToCriticalEscalationListPage();
			//Click on Authorization Contact List tab
			WebObjectUtil.clickElement(UserPermission.getNav_AuthorizedContactListTab());
			//-----------------------------------------------------------------------------------
			//updated below 2 lines as part of EXTJS5 updation by QAA03 on 22sep2015
			//WebObjectUtil.waitForElementPresent(UserPermission.getNav_AddUserLink());
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_AddUserRoleLink());
			//-----------------------------------------------------------------------------------
			WebObjectUtil.clickElement(UserPermission.getNav_AuthorizedContactListTab());
			
			//updated below 2 lines as part of EXTJS5 updation by QAA03 on 22sep2015
			
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_AddUserRoleLink());
			WebObjectUtil.verifyElementPresent(UserPermission.getNav_AddUserRoleLink());
			
			/*WebObjectUtil.waitForElementPresent(UserPermission.getNav_AddUserLink());
			WebObjectUtil.verifyElementPresent(UserPermission.getNav_AddUserLink());*/
			//-----------------------------------------------------------------------------------
			//Click on Add User button
			/*WebObjectUtil.clickElement(UserPermission.getNav_AddUserLink());
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_AddUserWindowOkButton());
			//Enter all required field values in Add user pop up window
			EnterAllRequiredFieldsInAddUserPopupWindow();
			//Thread.sleep(2000);
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_AddUserWindowOkButton());
			//Click on OK button in Add user pop up window
			WebObjectUtil.clickElement(UserPermission.getNav_AddUserWindowOkButton());
			//WebObjectUtil.waitForElementPresent(UserPermission.getNav_PopupWindow());
			//Verify the confirmation message displayed in the pop up window
			WebObjectUtil.verifyElementPresent(UserPermission.getNav_AddUserSucessMessage());
			//boolean bConfirmMsg = UserPermission.getNav_PopupWindow().getText().contains(sConfirmMsg);
			//FrameworkUtil.updateCustomResultBasedOnStatus(bConfirmMsg,sConfirmMsg);
			WebObjectUtil.clickElement(UserPermission.getNav_AddUserSucessMessageOKButton());
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_FeedBackArea());
			//Verify the confirmation message displayed in FeedBack area
			boolean bFeedbackMsgC = UserPermission.getNav_FeedBackArea().getText().contains(sFeedbackMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bFeedbackMsgC,sFeedbackMsg);*/
			LoginTestCase.nav_Logout();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		/*==============================================================
		TestScript 		: UserPermission
		Manual TestCase	: Given user is not able to perform add user
		Description		: Verifying the add user functionality is not accessible with users CRole-C and ERole-E
		Author 			: Sukur Babu. B
		Creation Date 	: 04/07/2015
		Pre-Requisites	:
		Revision History:Commented as per discussion with Sirisha. As all users have access to add user.Dated on 01012015
		==============================================================*/
	/*	@Test(priority=103)
		public void NoAccessToAddUser()
		{
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, UserPermission);	
			
			String sUserName1 ;
			String sPassword1;
			//Read user id and password from properties file
			sUserName1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
			sPassword1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
			//Update results with manual test case name
			FrameworkUtil.sTestCaseName = "UserPermissions-NoAccessToAddUser";
			FrameworkUtil.sManualTestCaseName="Verify that given user is not having access to Add User";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			//Login into Navigator
			LoginTestCase.nav_Login(sUserName1, sPassword1);
			//Navigate to Critical Escalation List Page
			NavigateToCriticalEscalationListPage();
			//Click on Authorized Contact List tab
			WebObjectUtil.clickElement(UserPermission.getNav_AuthorizedContactListTab());
			//Verify the Add User Link is not visible to CRole-C user
			boolean bCUserStatus=WebObjectUtil.isElementPresent(UserPermission.getNav_AddUserLink());
			if(!bCUserStatus)
				FrameworkUtil.updateCustomResultBasedOnStatus(true, sUserName1 + " don't have access to Add User" );
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false, sUserName1 + " has access to Add User" );
			//Log out from Navigator
			LoginTestCase.nav_Logout();
			//Read user id and password from properties file
			sUserName1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
			sPassword1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
			//Login into Navigator
			LoginTestCase.nav_Login(sUserName1, sPassword1);
			//Navigate to Critical Escalation List Page
			NavigateToCriticalEscalationListPage();
			//Click on Authorized Contact List tab
			WebObjectUtil.clickElement(UserPermission.getNav_AuthorizedContactListTab());
			//Verify the Add User Link is not visible to ERole-E user
			boolean bEUserStatus=WebObjectUtil.isElementPresent(UserPermission.getNav_AddUserLink());
			if(!bEUserStatus)
				FrameworkUtil.updateCustomResultBasedOnStatus(true, sUserName1 + " don't have access to Add User" );
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false, sUserName1 + " has access to Add User" );
			LoginTestCase.nav_Logout();
	}*/
		/*==============================================================
		TestScript 		: UserPermission
		Manual TestCase	: Given user is able to perform Delete user
		Description		: Verifying the Delete user functionality is  accessible with users ARole-A
		Author 			: Sukur Babu. B
		Creation Date 	: 04/08/2015
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		@Test(priority=104)
		public void AccessToDeleteUser()
		{
			
			try {
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, UserPermission);	
				
				String sUserName1 ;
				String sPassword1;
				String sUserToDelete;
				//Read user name, password and user to delete from properties file
				sUserName1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
				sPassword1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
				sUserToDelete = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERNAMETODELETE");
				//Update results with Manual test case name
				FrameworkUtil.sTestCaseName = "UserPermissions-AccessToDeleteUser";
				FrameworkUtil.sManualTestCaseName="Verify that given user is able to Delete User from the list";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				//Log into Navigaotr
				LoginTestCase.nav_Login(sUserName1, sPassword1);
				//Navigate to Critical Escalation list page
				NavigateToCriticalEscalationListPage();
				Thread.sleep(3000);
				WebObjectUtil.waitForElementPresent(UserPermission.getNav_CriticalEscalationListTable());
				//Get the row number from the table by passing the user name to delete
				int RowNumber=WebTableUtil.getRowByCellText(UserPermission.getNav_CriticalEscalationListTable(), sUserToDelete, 1,1);
				RowNumber=RowNumber+1;
				//Get the Delete link with in the required row
				WebElement DeleteLinkWebElement = WebObjectUtil.GetWebElement("xpath", "//tr["+RowNumber+"]//div/a[@class='greenlink']","Delete Link");
				//Click on Delete link
				WebObjectUtil.clickElement(DeleteLinkWebElement);
				WebObjectUtil.waitForElementPresent(UserPermission.getNav_PopupWindow());
				//String sMessage=DeleteLinkWebElement.getText();
				//Verify the confirmation message in the pop up window
				String sConfirmMsg="Are you sure you want to remove "+ sUserToDelete +" from the Critical Escalation List?";
				String sMessage=UserPermission.getNav_PopupWindow().getText();
				if(sMessage.contains(sConfirmMsg))
					FrameworkUtil.updateCustomResultBasedOnStatus(true,sConfirmMsg);
				else
					FrameworkUtil.updateCustomResultBasedOnStatus(false,sConfirmMsg);
				WebObjectUtil.clickElement(UserPermission.getNav_DeleteUserWindowOkButton());
				Thread.sleep(5000);
				//Verify the confirmation message in the Feed back area
				String sFeedbackMsg="Removed "+sUserToDelete +" from the Critical Escalation List";
				String sAppFeedbackMsg = UserPermission.getNav_FeedBackArea().getText();
				//FrameworkUtil.updateCustomResultBasedOnStatus(bFeedbackMsg,sFeedbackMsg);
				if (sAppFeedbackMsg.equalsIgnoreCase(sFeedbackMsg))
					FrameworkUtil.updateCustomResultBasedOnStatus(true,sFeedbackMsg);
				else
					FrameworkUtil.updateCustomResultBasedOnStatus(false,sFeedbackMsg);
				//Log out from Navigator
				LoginTestCase.nav_Logout();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
		/*==============================================================
		TestScript 		: UserPermission
		Manual TestCase	: Given user is not able to perform Delete user
		Description		: Verifying the Delete user functionality is  not accessible for users CRole-C and ERole-E
		Author 			: Sukur Babu. B
		Creation Date 	: 04/09/2015
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		//Test cases changed, now ARole-C & Arole-E also should have access to delete user.
		//@Test(priority=105)
		public void NoAccessToDeleteUser()
		{
			
			try {
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, UserPermission);	
				
				String sUserName1 ;
				String sPassword1;
				String sUserToDelete;
				
				sUserName1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
				sPassword1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
				sUserToDelete = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERNAMETODELETE");
				
				FrameworkUtil.sTestCaseName = "UserPermissions-NoAccessToDeleteUser";
				FrameworkUtil.sManualTestCaseName="Verify that given user is Not able to Delete User from the list";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				//Log into Navigator
				LoginTestCase.nav_Login(sUserName1, sPassword1);
				//Navigate to Critical Escalation List page
				NavigateToCriticalEscalationListPage();
				
				WebObjectUtil.waitForElementPresent(UserPermission.getNav_CriticalEscalationListTable());
				//int RowNumberC=WebTableUtil.getRowByCellText(UserPermission.getNav_CriticalEscalationListTable(), sUserToDelete, 1);
				int RowNumberC=WebTableUtil.getRowByCellText(UserPermission.getNav_CriticalEscalationListTable(), sUserToDelete, 1,1);
				
				RowNumberC=RowNumberC+1;
				//Verify Delete link is not visible to the user CRoleC
				WebElement UserCDeleteLinkWebElement = WebObjectUtil.GetWebElement("xpath", "//tr["+RowNumberC+"]//div/a[@class='greenlink']","Delete Link");
				FrameworkUtil.sElementName = "Delete Link";
				if(UserCDeleteLinkWebElement==null)
					FrameworkUtil.updateCustomResultBasedOnStatus(true, sUserName1 + " don't have access to Delete User" );
				else
					FrameworkUtil.updateCustomResultBasedOnStatus(false, sUserName1 + " has access to Delete User" );
				//Log Out from Navigator
				LoginTestCase.nav_Logout();
				sUserName1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
				sPassword1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
				//Log into Navigator
				LoginTestCase.nav_Login(sUserName1, sPassword1);
				//Navigate to Critical Escalation List page
				NavigateToCriticalEscalationListPage();
				
				WebObjectUtil.waitForElementPresent(UserPermission.getNav_CriticalEscalationListTable());
				int RowNumberE=WebTableUtil.getRowByCellText(UserPermission.getNav_CriticalEscalationListTable(), sUserToDelete, 1,1);
				FrameworkUtil.sElementName = "Delete Link";
				RowNumberE=RowNumberE+1;
				//Verify Delete link is not visible to the user ERoleE
				WebElement UserEDeleteLinkWebElement = WebObjectUtil.GetWebElement("xpath", "//tr["+RowNumberE+"]//div/a[@class='greenlink']","Delete Link");
				
				if(UserEDeleteLinkWebElement==null)
					FrameworkUtil.updateCustomResultBasedOnStatus(true, sUserName1 + " don't have access to Delete User" );
				else
					FrameworkUtil.updateCustomResultBasedOnStatus(false, sUserName1 + " has access to Delete User" );
				LoginTestCase.nav_Logout();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		/*==============================================================
		TestScript 		: UserPermission
		Manual TestCase	: Given user is able to perform Edit user
		Description		: Verifying the Edit user functionality is accessible for users ARole-A
		Author 			: Sukur Babu. B
		Creation Date 	: 04/10/2015
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		@Test(priority=106)
		public void AccessToEditUser()
		{
			
			try {
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, UserPermission);	
				
				String sUserNameA ,sUserNameC,sUserNameE;
				String sPasswordA,sPasswordC,sPasswordE;
				String sUserToEdit;
				sUserNameA = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
				sPasswordA = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
				sUserToEdit = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERNAMETOEDIT");
				
				FrameworkUtil.sTestCaseName = "UserPermissions-AccessToEditUser";
				FrameworkUtil.sManualTestCaseName="Verify that given user is  having access to Edit User";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				//Log into Navigator
				LoginTestCase.nav_Login(sUserNameA, sPasswordA);
				//Navigate to Critical Escalation list page
				NavigateToCriticalEscalationListPage();
				WebObjectUtil.waitForElementPresent(UserPermission.getNav_AuthorizedContactListTab());
				//Click on Authorized Contact List tab
				WebObjectUtil.clickElement(UserPermission.getNav_AuthorizedContactListTab());
				WebObjectUtil.explicitWait(20);
				WebObjectUtil.waitForElementPresent(UserPermission.getNav_AuthorizedContactListTableParent());
				
				
				//This Three lines updated on 10/14/2015 for EXTJS5 by QAA03
				//int sRowNumber=WebTableUtil.getRowByCellText(UserPermission.getNav_AuthorizedContactListTable(), sUserToEdit, 0,3);
				//WebElement RowAswebElement = WebObjectUtil.GetWebElement("xpath", "//tr[" + sRowNumber + "]//div[@class='x-grid-row-expander']", "Expand Row Button");
				CustomWebElementUtil.loadCustomElement(UserPermission.getNav_AuthorizedContactListTableParent(), "table");
				int iRowNumber = CustomWebElementUtil.getRowByCellText(sUserToEdit, 1);
			   // WebElement wRow = CustomWebElementUtil.getRowAsWebElement(iRowNumber);
			    WebElement wRow = WebObjectUtil.GetWebElement("xpath", "//table[" + iRowNumber + "]//div[@class='x-grid-row-expander']", "Expand Row Button");
				WebTableUtil.expandTableRowByRowNum(iRowNumber, wRow);
				
				WebObjectUtil.verifyElementPresent(UserPermission.getNav_AddtoCriticalEscalationListLink());
				LoginTestCase.nav_Logout();
				sUserNameC = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
				sPasswordC = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
				//Log into Navigator
				LoginTestCase.nav_Login(sUserNameC, sPasswordC);
				//Navigate to Critical Escalation list page
				NavigateToCriticalEscalationListPage();
				WebObjectUtil.waitForElementPresent(UserPermission.getNav_AuthorizedContactListTab());
				//Click on Authorized Contact List tab
				WebObjectUtil.clickElement(UserPermission.getNav_AuthorizedContactListTab());
				WebObjectUtil.explicitWait(20);
				WebObjectUtil.waitForElementPresent(UserPermission.getNav_AuthorizedContactListTableParent());
				
				
				//This Three lines updated on 10/14/2015 for EXTJS5 by QAA03
				//int sRowNumberC=WebTableUtil.getRowByCellText(UserPermission.getNav_AuthorizedContactListTableParent(), sUserToEdit, 0,3);
				//WebElement RowAswebElementC = WebObjectUtil.GetWebElement("xpath", "//tr[" + iRowNumber + "]//div[@class='x-grid-row-expander']", "Expand Row Button");
				//tr[2]//img[contains(text(),'Interface - 2')]
				CustomWebElementUtil.loadCustomElement(UserPermission.getNav_AuthorizedContactListTableParent(), "table");
				int iRowNumberC = CustomWebElementUtil.getRowByCellText(sUserToEdit, 1);
				WebElement wRowC = WebObjectUtil.GetWebElement("xpath", "//table[" + iRowNumberC + "]//div[@class='x-grid-row-expander']", "Expand Row Button");
				WebTableUtil.expandTableRowByRowNum(iRowNumberC, wRowC);
				
				WebObjectUtil.verifyElementPresent(UserPermission.getNav_AddtoCriticalEscalationListLink());
				LoginTestCase.nav_Logout();
				sUserNameE = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
				sPasswordE = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
				//Log into Navigator
				LoginTestCase.nav_Login(sUserNameE, sPasswordE);
				//Navigate to Critical Escalation list page
				NavigateToCriticalEscalationListPage();
				WebObjectUtil.waitForElementPresent(UserPermission.getNav_AuthorizedContactListTab());
				//Click on Authorized Contact List tab
				WebObjectUtil.clickElement(UserPermission.getNav_AuthorizedContactListTab());
				WebObjectUtil.explicitWait(20);
				WebObjectUtil.waitForElementPresent(UserPermission.getNav_AuthorizedContactListTableParent());
				
				//This Three lines updated on 10/14/2015 for EXTJS5 by QAA03
				//int sRowNumberE=WebTableUtil.getRowByCellText(UserPermission.getNav_AuthorizedContactListTableParent(), sUserToEdit, 0,3);
				//WebElement RowAswebElementE = WebObjectUtil.GetWebElement("xpath", "//tr[" + iRowNumber + "]//div[@class='x-grid-row-expander']", "Expand Row Button");
				//tr[2]//img[contains(text(),'Interface - 2')]
				CustomWebElementUtil.loadCustomElement(UserPermission.getNav_AuthorizedContactListTableParent(), "table");
				int iRowNumberE = CustomWebElementUtil.getRowByCellText(sUserToEdit, 1);
				 WebElement wRowE = WebObjectUtil.GetWebElement("xpath", "//table[" + iRowNumberE + "]//div[@class='x-grid-row-expander']", "Expand Row Button");
				WebTableUtil.expandTableRowByRowNum(iRowNumberE, wRowE);
				
				WebObjectUtil.verifyElementPresent(UserPermission.getNav_AddtoCriticalEscalationListLink());
				LoginTestCase.nav_Logout();
			/*	//Click on Add to Critical Escalation List link after expanding required row
				WebObjectUtil.clickElement(UserPermission.getNav_AddtoCriticalEscalationListLink());
				WebObjectUtil.waitForElementPresent(UserPermission.getNav_PopupWindow());
				//Verify Confirmation message displayed in pop up window
				String sConfirmMsg="Are you sure you want to add "+ sUserToEdit +" to the Critical Escalation List?";
				//Are you sure you want to add ARole E to the Critical Escalation List?
				boolean bConfirmMsg = UserPermission.getNav_PopupWindow().getText().contains(sConfirmMsg);
				FrameworkUtil.updateCustomResultBasedOnStatus(bConfirmMsg,sConfirmMsg);
				WebObjectUtil.verifyElementPresent(UserPermission.getNav_EditUserWindowOkButton());
				WebObjectUtil.clickElement(UserPermission.getNav_EditUserWindowOkButton());
				Thread.sleep(5000);
				WebObjectUtil.waitForElementPresent(UserPermission.getNav_FeedBackArea());
				//Verify confirmation message in Feedback area
				String sFeedbackMsg="Successfully added "+sUserToEdit+" to the Critical Escalation List";
				boolean bFeedbackMsg = UserPermission.getNav_FeedBackArea().getText().contains(sFeedbackMsg);
				FrameworkUtil.updateCustomResultBasedOnStatus(bFeedbackMsg,sFeedbackMsg);*/
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		/*==============================================================
		TestScript 		: UserPermission
		Manual TestCase	: Given user is not able to perform Edit user
		Description		: Verifying the Edit user functionality is not accessible for users CRole-C and ERole-E
		Author 			: Sukur Babu. B
		Creation Date 	: 04/13/2015
		Pre-Requisites	:
		Revision History:Commented as per discussion with Sirisha. As all users have access to add user.Dated on 01012015
		==============================================================*/
	/*	@Test(priority=107)
		public void NoAccessToEditUser()
		{
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, UserPermission);	
			
			String sUserName1 ;
			String sPassword1;
			String sUserToEdit;
			
			sUserName1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
			sPassword1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
			sUserToEdit = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERNAMETOEDIT");
			
			FrameworkUtil.sTestCaseName = "UserPermissions-NoAccessToEditUser";
			FrameworkUtil.sManualTestCaseName="Verify that given user is not having access to Edit User";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			//Log into Navigator
			LoginTestCase.nav_Login(sUserName1, sPassword1);
			//Navigate to Critical Escalation list page
			NavigateToCriticalEscalationListPage();
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_AuthorizedContactListTab());
			//Click on Authorized Contact List tab
			WebObjectUtil.clickElement(UserPermission.getNav_AuthorizedContactListTab());
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_AuthorizedContactListTable());
			int sRowNumber=WebTableUtil.getRowByCellText(UserPermission.getNav_AuthorizedContactListTable(), sUserToEdit, 0,3);
			//Verify Add To Critical Escalation List link is not visible to CRole-C user
			WebElement UserCExpandButton = WebObjectUtil.GetWebElement("xpath", "//tr[" + sRowNumber + "]//div[@class='x-grid-row-expander']", "Expand Row Button");
			if(UserCExpandButton==null )
				FrameworkUtil.updateCustomResultBasedOnStatus(true, sUserName1 + " don't have access to Edit User" );
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false, sUserName1 + " has access to Edit User" );		
			//Log out from navigator
			LoginTestCase.nav_Logout();
			sUserName1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
			sPassword1 = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
			//Log into Navigator
			LoginTestCase.nav_Login(sUserName1, sPassword1);
			//Navigate to Critical Escalation list page
			NavigateToCriticalEscalationListPage();
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_AuthorizedContactListTab());
			//Click on Authorized Contact List tab
			WebObjectUtil.clickElement(UserPermission.getNav_AuthorizedContactListTab());
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_AuthorizedContactListTable());
			int sRowNumber1=WebTableUtil.getRowByCellText(UserPermission.getNav_AuthorizedContactListTable(), sUserToEdit, 0,3);
			//Verify Add To Critical Escalation List link is not visible to ERole-E user
			WebElement UserEExpandButton = WebObjectUtil.GetWebElement("xpath", "//tr[" + sRowNumber1 + "]//div[@class='x-grid-row-expander']", "Expand Row Button");
			if(UserEExpandButton==null )
				FrameworkUtil.updateCustomResultBasedOnStatus(true, sUserName1 + " don't have access to Edit User" );
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false, sUserName1 + " has access to Edit User" );	
		}*/
		/*==============================================================
		TestScript 		: UserPermission
		Manual TestCase	: Given user is able view to perform DRaas
		Description		: Verifying the DRaas page display with users ARole-A,CRole-C and ERole-E
		Author 			: Sukur Babu. B
		Creation Date 	: 04/13/2015
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		@Test(priority=108)
		public void AccessToviewDRaaS(){
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, UserPermission);	
			String sUserName;
			String sPassword;
			
			FrameworkUtil.sTestCaseName = "UserPermissions-AccessToviewDRaaS";
			FrameworkUtil.sManualTestCaseName="Verify access to DRaaS for given user";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.DRAAS.AROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.DRAAS.AROLE");
			//Verify DRaas page display for given users
			AccessToViewDRaas(sUserName, sPassword);
			//Log out from Navigator
			LoginTestCase.nav_Logout();
			
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.DRAAS.CROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.DRAAS.CROLE");
			//Verify DRaas page display for given users
			AccessToViewDRaas(sUserName, sPassword);
			//Log out from Navigator
			LoginTestCase.nav_Logout();
			
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.DRAAS.EROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.DRAAS.EROLE");
			//Verify DRaas page display for given users
			AccessToViewDRaas(sUserName, sPassword);
			//Log out from Navigator
			LoginTestCase.nav_Logout();
		}
		/*==============================================================
		TestScript 		: UserPermission
		Manual TestCase	: Given user is able view Forms page
		Description		: Verifying the Forms page display for users ARole-A and CRole-C 
		Author 			: Sukur Babu. B
		Creation Date 	: 04/14/2015
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		
		@Test(priority=109)
		public void AccessToviewFormsTest(){
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, UserPermission);	
			PageFactory.initElements(driver, smokeTest);
			String sUserName,sPassword,sFormsUserName,sFormsPassword;
			
			
			FrameworkUtil.sTestCaseName = "UserPermissions-AccessToviewFormsTest";
			FrameworkUtil.sManualTestCaseName="Verify access to Forms for given user";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
			//sFormsUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.FORMSUSERID");
			//sFormsPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.FORMSPASSWORD");
			//Verify DRaas page display for given users
			//AccessToViewForms(sUserName,sPassword,sFormsUserName,sFormsPassword);
			
			//since form loads within navigator as per application change changed the form validation by Arul 10/30/15
			LoginTestCase.nav_Login(sUserName, sPassword);
			WebObjectUtil.clickAndVerifyElement(smokeTest.getNav_SupportMenuLink(), smokeTest.getNav_BuildReq_Forms_SubMenuLink());
			WebObjectUtil.clickElement(smokeTest.getNav_BuildReq_Forms_SubMenuLink());
			WebObjectUtil.explicitWait(10);
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_BuildReqPageHeader());
			LoginTestCase.nav_Logout();
			//AccessToViewForms(sUserName,sPassword);
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
			//Verify given user can see Forms page
			//since form loads within navigator as per application change changed the form validation by Arul 10/30/15
			LoginTestCase.nav_Login(sUserName, sPassword);
			WebObjectUtil.clickAndVerifyElement(smokeTest.getNav_SupportMenuLink(), smokeTest.getNav_BuildReq_Forms_SubMenuLink());
			WebObjectUtil.clickElement(smokeTest.getNav_BuildReq_Forms_SubMenuLink());
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_BuildReqPageHeader());
			LoginTestCase.nav_Logout();
			//AccessToViewForms(sUserName,sPassword);
			//Log out from Navigator
			LoginTestCase.nav_Logout();
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
			//Verify given user can see Forms page
			//since form loads within navigator as per application change changed the form validation by Arul 10/30/15
			LoginTestCase.nav_Login(sUserName, sPassword);
			WebObjectUtil.clickAndVerifyElement(smokeTest.getNav_SupportMenuLink(), smokeTest.getNav_BuildReq_Forms_SubMenuLink());
			WebObjectUtil.clickElement(smokeTest.getNav_BuildReq_Forms_SubMenuLink());
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_BuildReqPageHeader());
			LoginTestCase.nav_Logout();
			//AccessToViewForms(sUserName,sPassword);
		}
		/*==============================================================
		TestScript 		: UserPermission
		Manual TestCase	: Given user is not able view Forms page
		Description		: Verifying the Forms page not displayed for users ARole-E 
		Author 			: Sukur Babu. B
		Creation Date 	: 04/14/2015
		Pre-Requisites	:
		Revision History:
		==============================================================
		@Test(priority=109)
		public void NoAccessToviewForms(){
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, UserPermission);	
			String sUserName,sPassword,sFormsUserName,sFormsPassword;
			
			
			FrameworkUtil.sTestCaseName = "UserPermissions-ViewForms";
			FrameworkUtil.sManualTestCaseName="Verify no access to Forms for given user";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
			//sFormsUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.FORMSUSERID");
			//sFormsPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.FORMSPASSWORD");
			//Verify DRaas page display for given users
			//AccessToViewForms(sUserName,sPassword,sFormsUserName,sFormsPassword);
			NoAccessToViewForms(sUserName,sPassword);
			//Log out from Navigator
			LoginTestCase.nav_Logout();
			
		}*/
		/*==============================================================
		TestScript 		: UserPermission
		Manual TestCase	: Given users are able access EM7
		Description		: Verifying the EM7 is accessible for users ARole-A,ARole-C and ARole-E 
		Author 			: Sukur Babu. B
		Creation Date 	: 04/14/2015
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		@Test(priority=10101)
		public void AccessToEM7(){
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, UserPermission);	
			String sUserName,sPassword,sFormsUserName,sFormsPassword;
			
			FrameworkUtil.sTestCaseName = "UserPermissions-AccessToEM7";
			FrameworkUtil.sManualTestCaseName="Verify access to EM7 for given users";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			//Verify ARole-A user is able to login into EM7
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
			String sEM7Url=(String)FrameworkUtil.dictPropertyData.get("NAV.EM7.URL");
			WebDriverUtil.getDriver().get(sEM7Url);
			WebObjectUtil.SetValueEdit(UserPermission.getEM7_LoginUserID(), sUserName);
	        WebObjectUtil.SetValueEdit(UserPermission.getEM7_LoginPwd(), sPassword);
	        WebObjectUtil.clickElement(UserPermission.getEM7_LoginSubmit());
	        //This below lines updated on 10/14/2015 for EXTJS5 by QAA03
			// WebObjectUtil.verifyElementPresent(UserPermission.getEM7_SignOutLink());
			//WebObjectUtil.clickElement(UserPermission.getEM7_SignOutLink());
			WebObjectUtil.clickElement(UserPermission.getEM7_ToolBoxIcon());
			WebObjectUtil.verifyElementPresent(UserPermission.getEM7_Logoff());
			WebObjectUtil.clickElement(UserPermission.getEM7_Logoff());
	        //driver.close();
	       //Verify ARole-B user is able to login into EM7
	        sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
			//sEM7Url=(String)FrameworkUtil.dictPropertyData.get("NAV.EM7.URL");
			WebDriverUtil.getDriver().get(sEM7Url);
			WebObjectUtil.SetValueEdit(UserPermission.getEM7_LoginUserID(), sUserName);
	        WebObjectUtil.SetValueEdit(UserPermission.getEM7_LoginPwd(), sPassword);
	        WebObjectUtil.clickElement(UserPermission.getEM7_LoginSubmit());
	        //This below lines updated on 10/14/2015 for EXTJS5 by QAA03
			// WebObjectUtil.verifyElementPresent(UserPermission.getEM7_SignOutLink());
			//WebObjectUtil.clickElement(UserPermission.getEM7_SignOutLink());
			WebObjectUtil.clickElement(UserPermission.getEM7_ToolBoxIcon());
			WebObjectUtil.verifyElementPresent(UserPermission.getEM7_Logoff());
			WebObjectUtil.clickElement(UserPermission.getEM7_Logoff());
	        //driver.close();
	       //Verify ARole-E user is able to login into EM7
	        sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
			WebDriverUtil.getDriver().get(sEM7Url);
			WebObjectUtil.SetValueEdit(UserPermission.getEM7_LoginUserID(), sUserName);
	        WebObjectUtil.SetValueEdit(UserPermission.getEM7_LoginPwd(), sPassword);
	        WebObjectUtil.clickElement(UserPermission.getEM7_LoginSubmit());
	        //This below lines updated on 10/14/2015 for EXTJS5 by QAA03
			// WebObjectUtil.verifyElementPresent(UserPermission.getEM7_SignOutLink());
			//WebObjectUtil.clickElement(UserPermission.getEM7_SignOutLink());
			WebObjectUtil.clickElement(UserPermission.getEM7_ToolBoxIcon());
			WebObjectUtil.verifyElementPresent(UserPermission.getEM7_Logoff());
			WebObjectUtil.clickElement(UserPermission.getEM7_Logoff());
	        //driver.close();
		}
		
		/*==============================================================
		TestScript 		: UserPermission
		Manual TestCase	: Given users are able to create ticket
		Description		: Verifying users ARole-A,ARole-C and ARole-E are ablt to create ticket
		Author 			: Sukur Babu. B
		Creation Date 	: 04/15/2015
		Pre-Requisites	:
		Revision History:
		==============================================================*/
	/*	@Test(priority=1010)
		public void AccessToCreateTicketTest(){
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, UserPermission);	
			PageFactory.initElements(driver, HomePageFactory);
			String sUserName,sPassword;
			
			FrameworkUtil.sTestCaseName = "UserPermissions-Create Ticket";
			FrameworkUtil.sManualTestCaseName="Verify users ARole-A,ARole-C and ARole-E are able to Create Ticket";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			//Verify ARole-A user is able to create Ticket
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
			
			LoginTestCase.nav_Login(sUserName, sPassword);
			AccessToCreateTicket();
			LoginTestCase.nav_Logout();
			
			//Verify ARole-C user is able to create Ticket
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
					
			LoginTestCase.nav_Login(sUserName, sPassword);
			AccessToCreateTicket();
			LoginTestCase.nav_Logout();
			
			//Verify ARole-E user is able to create Ticket
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
							
			LoginTestCase.nav_Login(sUserName, sPassword);
			AccessToCreateTicket();
			LoginTestCase.nav_Logout();
		}*/
		/*==============================================================
		TestScript 		: UserPermission
		Manual TestCase	: Given users are able to access Detailed Ticket System
		Description		: Verifying users ARole-A,ARole-C and ARole-E are able to access Detailed Ticket System
		Author 			: Sukur Babu. B
		Creation Date 	: 04/15/2015
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		@Test(priority=1011)
		public void AccessToDetailedTickettingSystemTest()
		{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, UserPermission);	
			String sUserName,sPassword;
			
			FrameworkUtil.sTestCaseName = "UserPermissions-AccessToDetailedTickettingSystemTest";
			FrameworkUtil.sManualTestCaseName="Verify users ARole-A,ARole-C and ARole-E are able to Create Ticket";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			//Verify ARole-A user is able to access Detailed Ticket System
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
			
			LoginTestCase.nav_Login(sUserName, sPassword);
			AccessToDetailedTickettingSystem(sUserName,sPassword);
			LoginTestCase.nav_Logout();
			
			//Verify ARole-A user is able to access Detailed Ticket System
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
					
			LoginTestCase.nav_Login(sUserName, sPassword);
			AccessToDetailedTickettingSystem(sUserName,sPassword);
			LoginTestCase.nav_Logout();
			
			//Verify ARole-E user is able to access Detailed Ticket System
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
							
			LoginTestCase.nav_Login(sUserName, sPassword);
			AccessToDetailedTickettingSystem(sUserName,sPassword);
			LoginTestCase.nav_Logout();
		}
		
		@Test(priority=1012)
		public void AccessToAddDriveTest()
	      {
	            try
	            {
	            WebDriver driver = WebDriverUtil.getDriver();
	            PageFactory.initElements(driver, UserPermission); 
	            PageFactory.initElements(driver, Draas);
	            String sUserName,sPassword,sHostName,sHostIpAddress,sDrivesToAdd,sAddDriveConfirmMsg,sAddDriveFeedBackMsg;
	            boolean bAddDriveConfirmMsg,bAddDriveFeedBackMsg;
	            
	            FrameworkUtil.sTestCaseName = "UserPermissions-AddDrive";
	            FrameworkUtil.sManualTestCaseName="Verify users giruser and singuser1 are able to add drive";
	            FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	            
	            //Verify giruser is able to create a drive
	            sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.DRAAS.AROLE");
	            sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.DRAAS.AROLE");
	            LoginTestCase.nav_Login(sUserName, sPassword);
	            WebObjectUtil.ClickAndMouseHover(UserPermission.getNav_ServicesTab());
	            WebObjectUtil.clickElement(UserPermission.getNav_DRaaSLink());
	            WebObjectUtil.explicitWait(5);
	            //WebObjectUtil.waitForElementPresent(UserPermission.getNav_HostBasedReplicationText());
	            WebObjectUtil.waitForElementPresent(Draas.getNav_MoreDraasProducts());
	            //WebObjectUtil.verifyElementPresent(UserPermission.getNav_HostBasedReplicationAddDrive());
	            WebObjectUtil.verifyElementPresent(Draas.getNav_SCRAddDrive());
	            //String HostBasedReplicationAddDrive_Sts=UserPermission.getNav_HostBasedReplicationAddDrive().getAttribute("unselectable");
	            if (Draas.getNav_SCRAddDrive().isEnabled())
	            {
	                  FrameworkUtil.updateCustomResultBasedOnStatus(true,"Host Based Replication AddDrive link is enabled for user "+sUserName);
	                  WebObjectUtil.clickElement(Draas.getNav_SCRAddDrive());
	                  sHostName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.DRAAS.HOSTNAME");
	                   sHostIpAddress = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.DRAAS.HOSTIPADDRESS");
	                   sDrivesToAdd = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.DRAAS.DRIVESTOADD");
	                  EnterDataforAddDrive(sHostName,sHostIpAddress,sDrivesToAdd);
	                  WebObjectUtil.explicitWait(5);
	                  
	                  WebObjectUtil.clickElement(UserPermission.getNav_SaveDrive());
	                  //Thread.sleep(10000);
	                  //Thread.sleep(10000);
	                  WebObjectUtil.explicitWait(20);
	                  //UserPermission.getNav_SaveDrive().click();
	                  WebObjectUtil.waitForElementPresent(UserPermission.getNav_PopupWindow());
	                   sAddDriveConfirmMsg="Successfully created a ticket with TicketId";
	                   bAddDriveConfirmMsg = UserPermission.getNav_PopupWindow().getText().contains(sAddDriveConfirmMsg);
	                  if(bAddDriveConfirmMsg)
	                        FrameworkUtil.updateCustomResultBasedOnStatus(true,sAddDriveConfirmMsg);
	                  else
	                        FrameworkUtil.updateCustomResultBasedOnStatus(false,"User "+sUserName+" Failed in Adding a Drive");
	                  WebObjectUtil.clickElement(UserPermission.getNav_PopupWindowOkButton());
	                   sAddDriveFeedBackMsg="Successfully created a ticket with TicketId";
	                   bAddDriveFeedBackMsg = UserPermission.getNav_FeedBackArea().getText().contains(sAddDriveConfirmMsg);
	                  if(bAddDriveFeedBackMsg)
	                        FrameworkUtil.updateCustomResultBasedOnStatus(true,sAddDriveFeedBackMsg);
	                  else
	                        FrameworkUtil.updateCustomResultBasedOnStatus(false,"User "+sUserName+" Failed in Adding a Drive");
	                  LoginTestCase.nav_Logout();
	                  
	            }
	            else
	            {
	                  FrameworkUtil.updateCustomResultBasedOnStatus(false,"Host Based Replication AddDrive link is disabled for user "+sUserName);
	                  LoginTestCase.nav_Logout();
	            }
	             
	            //Verify singuser1 is able to create a drive
	            sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.DRAAS.CROLE");
	            sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.DRAAS.CROLE");
	            LoginTestCase.nav_Login(sUserName, sPassword);
	            WebObjectUtil.ClickAndMouseHover(UserPermission.getNav_ServicesTab());
	            WebObjectUtil.clickElement(UserPermission.getNav_DRaaSLink());
	            //WebObjectUtil.waitForElementPresent(UserPermission.getNav_StorageArrayBasedReplicationText());
	            WebObjectUtil.waitForElementPresent(Draas.getNav_SBRText());
	            WebObjectUtil.explicitWait(5);
	            String StorageBasedReplicationAddDriveLink_Sts=Draas.getNav_SBRAddDrive().getAttribute("unselectable");
	            if (!StorageBasedReplicationAddDriveLink_Sts.equalsIgnoreCase("on"))
	            {
	                  FrameworkUtil.updateCustomResultBasedOnStatus(false,"Storage Based Replication AddDrivelink is disabled for user "+sUserName);
	                  LoginTestCase.nav_Logout();
	            }
	            else
	            {
	                  FrameworkUtil.updateCustomResultBasedOnStatus(true,"Storage Based Replication AddDrivelink is enabled for user "+sUserName);
	                 //WebObjectUtil.clickElement(UserPermission.getNav_StorageArrayBasedReplicationAddDrive());
	            
	                  WebObjectUtil.clickElement(Draas.getNav_SBRAddDrive());
	                  String sSourceStorageControllerName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.DRAAS.SOURCESTORAGECONTROLLERNAME");
	                   String sSourceStorageControllerIP = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.DRAAS.SOURCESTORAGECONTROLLERIP");
	                   String sSourceVolumeName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.DRAAS.SOURCEVOLUMENAME");
	                  //EnterDataforAddDrive(sSourceStorageControllerName,sSourceStorageControllerIP,sSourceVolumeName);
	                  WebObjectUtil.SetValueEdit(UserPermission.getNav_SourceStorageControllerName(), sSourceStorageControllerName);
	                  WebObjectUtil.SetValueEdit(UserPermission.getNav_SourceStorageControllerIP(), sSourceStorageControllerIP);
	                  WebObjectUtil.SetValueEdit(UserPermission.getNav_SourceVolumeName(), sSourceVolumeName);
	                  WebObjectUtil.explicitWait(5);
	                  
	                  WebObjectUtil.clickElement(UserPermission.getNav_SaveDrive());
	                  //Thread.sleep(10000);
	                  WebObjectUtil.explicitWait(30);
	                  //UserPermission.getNav_SaveDrive().click();
	                  WebObjectUtil.waitForElementPresent(UserPermission.getNav_PopupWindow());
	                   sAddDriveConfirmMsg="Successfully created a ticket with TicketId";
	                   bAddDriveConfirmMsg = UserPermission.getNav_PopupWindow().getText().contains(sAddDriveConfirmMsg);
	                  if(bAddDriveConfirmMsg)
	                        FrameworkUtil.updateCustomResultBasedOnStatus(true,sAddDriveConfirmMsg);
	                  else
	                        FrameworkUtil.updateCustomResultBasedOnStatus(false,"User "+sUserName+" Failed in Adding a Drive");
	                  //WebObjectUtil.clickElement(UserPermission.getNav_);
	                  WebObjectUtil.clickElement(UserPermission.getNav_PopupWindowOkButton());
	                   sAddDriveFeedBackMsg="Successfully created a ticket with TicketId";
	                   bAddDriveFeedBackMsg = UserPermission.getNav_FeedBackArea().getText().contains(sAddDriveConfirmMsg);
	                  if(bAddDriveFeedBackMsg)
	                        FrameworkUtil.updateCustomResultBasedOnStatus(true,sAddDriveFeedBackMsg);
	                  else
	                        FrameworkUtil.updateCustomResultBasedOnStatus(false,"User "+sUserName+" Failed in Adding a Drive");
	                  
	                  LoginTestCase.nav_Logout();
	            }
	             
	            
	      } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	      }
	      }

		
		@Test(priority=1013)
		public void NoAccessToAddDriveTest()
		{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, UserPermission);	
			String sUserName,sPassword;
			
			FrameworkUtil.sTestCaseName = "UserPermissions-NoAccessToAddDriveTest";
			FrameworkUtil.sManualTestCaseName="Verify user Test_E is not able to add drive";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			//Verify giruser is able to create a drive
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.DRAAS.EROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.DRAAS.EROLE");
			NoAccessToAddDrive(sUserName,sPassword);
			LoginTestCase.nav_Logout();
		}
		@Test(priority=1014)
		public void AccessToDeleteDrive()
		{
			try {
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, UserPermission);
			PageFactory.initElements(driver, Draas);
			
			String sUserName ;
			String sPassword;
			String sDriveToDelete;
			
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.DRAAS.AROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.DRAAS.AROLE");
			sDriveToDelete = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.DRAAS.DRIVETODELETE");
			
			FrameworkUtil.sTestCaseName = "UserPermissions-DRaaS-AccessToDeleteDrive";
			FrameworkUtil.sManualTestCaseName="Verify that given user is able to Delete Drive";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			//Log into Navigator
			LoginTestCase.nav_Login(sUserName, sPassword);
			
			WebObjectUtil.ClickAndMouseHover(UserPermission.getNav_ServicesTab());
			WebObjectUtil.clickElement(UserPermission.getNav_DRaaSLink());
			//WebObjectUtil.waitForElementPresent(UserPermission.getNav_HostBasedReplicationText());
			//WebObjectUtil.verifyElementPresent(UserPermission.getNav_HostBasedReplicationAddDrive());
			WebObjectUtil.waitForElementPresent(Draas.getNav_MoreDraasProducts());
			
			//WebObjectUtil.clickElement(UserPermission.getNav_ManageDriveButton());
			WebObjectUtil.clickElement(Draas.getNav_SCRManageBtn());
			//WebObjectUtil.waitForElementPresent(UserPermission.getNav_ManageDriveTable());
			//WebObjectUtil.verifyElementPresent(UserPermission.getNav_ManageDriveTable());
			WebObjectUtil.waitForElementPresent(Draas.getNav_SCRManageDriveTable());
			WebObjectUtil.verifyElementPresent(Draas.getNav_SCRManageDriveTable());
			Thread.sleep(5000);
			//int sRowNumber=WebTableUtil.getRowByCellText(UserPermission.getNav_ManageDriveTable(), sDriveToDelete, 0,1);
			int sRowNumber=WebTableUtil.getRowByCellText(Draas.getNav_SCRManageDriveTable(), sDriveToDelete, 0,1);
			//Verify Add To Critical Escalation List link is not visible to CRole-C user
			//WebElement DeleteLink = WebObjectUtil.GetWebElement("xpath", "//table//tr["+sRowNumber+"]//a[contains(text(),'Delete')]", "Delete Link");
			WebElement DeleteLink = WebObjectUtil.GetWebElement("xpath", "//table["+sRowNumber+"]//div[contains(@class,'x-grid-cell-inner')]//a[contains(text(),'Delete')]", "Delete Link");
			
			if(DeleteLink==null )
				FrameworkUtil.updateCustomResultBasedOnStatus(false, sUserName + " don't have access to Delete Drive" );
			else
			{
				DeleteLink.click();
				WebObjectUtil.waitForElementPresent(UserPermission.getNav_DeleteDrivePopup());
				WebObjectUtil.verifyElementPresent(UserPermission.getNav_DeleteDrivePopup());
				//WebObjectUtil.verifyElementPresent(UserPermission.getNav_DeleteDriveMsg());
				WebObjectUtil.verifyElementPresent(Draas.getNav_SCRDeleteDriveMsg());
				WebObjectUtil.clickElement(UserPermission.getNav_DeleteDrivePopupOKButton());
				WebObjectUtil.waitForElementPresent(UserPermission.getNav_FeedBackArea());
				FrameworkUtil.updateCustomResultBasedOnStatus(true, sUserName + " has access to Delete Drive" );
				LoginTestCase.nav_Logout();
			}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@Test(priority=1015)
		public void NoAccessToDeleteDrive()
		{
			try {
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, UserPermission);
			PageFactory.initElements(driver, Draas);
			
			String sUserName ;
			String sPassword;
			String sDriveToDelete;
			
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.DRAAS.EROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.DRAAS.EROLE");
			sDriveToDelete = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.DRAAS.DRIVETODELETE");
			
			FrameworkUtil.sTestCaseName = "UserPermissions-DRaaS-NoAccessToDeleteDrive";
			FrameworkUtil.sManualTestCaseName="Verify that given user is not able to access Delete Drive";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			//Log into Navigator
			LoginTestCase.nav_Login(sUserName, sPassword);
			
			WebObjectUtil.ClickAndMouseHover(UserPermission.getNav_ServicesTab());
			WebObjectUtil.clickElement(UserPermission.getNav_DRaaSLink());
			//WebObjectUtil.waitForElementPresent(UserPermission.getNav_HostBasedReplicationText());
			WebObjectUtil.waitForElementPresent(Draas.getNav_MoreDraasProducts());
			//WebObjectUtil.verifyElementPresent(UserPermission.getNav_HostBasedReplicationAddDrive());
			
			//WebObjectUtil.clickElement(UserPermission.getNav_ManageDriveButton());
			WebObjectUtil.clickElement(Draas.getNav_SCRManageBtn());
			Thread.sleep(5000);
			//int sRowNumber=WebTableUtil.getRowByCellText(UserPermission.getNav_ManageDriveTable(), sDriveToDelete, 0,1);
			int sRowNumber=WebTableUtil.getRowByCellText(Draas.getNav_SCRManageDriveTable(), sDriveToDelete, 0,1);
			//Verify Add To Critical Escalation List link is not visible to CRole-C user
			//WebElement DeleteLink = WebObjectUtil.GetWebElement("xpath", "//tr["+sRowNumber+"]//div[contains(@class,'x-grid-cell-inner')]//a[contains(text(),'Delete')]", "Delete Link");
			WebElement DeleteLink = WebObjectUtil.GetWebElement("xpath", "//table["+sRowNumber+"]//div[contains(@class,'x-grid-cell-inner')]//a[contains(text(),'Delete')]", "Delete Link");
			if(DeleteLink==null )
				FrameworkUtil.updateCustomResultBasedOnStatus(true, sUserName + " don't have access to Delete Drive as expected" );
			else
			{
				
				FrameworkUtil.updateCustomResultBasedOnStatus(false, sUserName +  " has access to Delete Drive" );	
			}
			LoginTestCase.nav_Logout();
			
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Test(priority=1016)
		public void AccessToViewFirewall()
		{
			try {
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, UserPermission);	
			
			String sUserName ;
			String sPassword;
			String sFireWallToExpand;	
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.FIREWALL.AROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.AROLE");
			sFireWallToExpand=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.FIREWALLTOEXPAND");
			
			FrameworkUtil.sTestCaseName = "UserPermissions-AccessToViewFirewall";
			FrameworkUtil.sManualTestCaseName="Verify that given user is able to view Firewall page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			AccessToFirewall(sUserName,sPassword,sFireWallToExpand);
			LoginTestCase.nav_Logout();
			
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.FIREWALL.CROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.CROLE");
			sFireWallToExpand=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.FIREWALLTOEXPAND");
			AccessToFirewall(sUserName,sPassword,sFireWallToExpand);
			LoginTestCase.nav_Logout();
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.FIREWALL.EROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.EROLE");
			sFireWallToExpand=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.FIREWALLTOEXPAND");
			LoginTestCase.nav_Login(sUserName, sPassword);
			WebObjectUtil.clickElement(EVDC_Overview.getNav_EVDCname());
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_FirewallLink());
			WebObjectUtil.clickElement(UserPermission.getNav_FirewallLink());
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_FirewallTable());
			
			int sRowNumber=WebTableUtil.getRowByCellText(UserPermission.getNav_FirewallTable(), sFireWallToExpand, 0,1);
			WebElement ExpandWebElement = WebObjectUtil.GetWebElement("xpath", "//table//tr["+sRowNumber+"]//img[contains(@id,'firewallsummary')]","Delete Link");
			ExpandWebElement.click();
			Thread.sleep(5000);
			boolean bAddFirewallTableSts=WebObjectUtil.isElementPresent(UserPermission.getNav_FirewallRuleTable());
			if(bAddFirewallTableSts)
			{
				FrameworkUtil.updateCustomResultBasedOnStatus(true, sUserName + " has access to view FireWall Informaton" );
			}
			else
			{
				FrameworkUtil.updateCustomResultBasedOnStatus(false, sUserName + " is not having access to view FireWall Informaton" );
			}
			LoginTestCase.nav_Logout();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		@Test(priority=106)
		public void NoAccessToAddFirewallRule()
		{
			try {
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, UserPermission);	
			
			String sUserName ;
			String sPassword;
			String sFireWallToExpand;	
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.FIREWALL.EROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.EROLE");
			sFireWallToExpand=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.FIREWALLTOEXPAND");
			
			FrameworkUtil.sTestCaseName = "UserPermissions-NoAccessToAddFirewallRule";
			FrameworkUtil.sManualTestCaseName="Verify that given user is not able to add Firewall rule";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			LoginTestCase.nav_Login(sUserName, sPassword);
			
			WebObjectUtil.clickElement(EVDC_Overview.getNav_EVDCname());
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_FirewallLink());
			WebObjectUtil.clickElement(UserPermission.getNav_FirewallLink());
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_FirewallTable());
			
			int iRowNumber=WebTableUtil.getRowByCellText(UserPermission.getNav_FirewallTable(), sFireWallToExpand, 0,1);
			//WebElement ExpandWebElement = WebObjectUtil.GetWebElement("xpath", "//table//tr["+sRowNumber+"]//img[contains(@id,'firewallsummary')]","Delete Link");
			WebElement ExpandWebElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.EXPANDER","PARAMETER_ROWNUMBER",iRowNumber+"");
			//ExpandWebElement.click();
			//boolean bAddFirewallLinkSts=WebObjectUtil.isElementPresent(UserPermission.getNav_AddFireWallLink());
			ExpandWebElement.click();
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_FirewallRuleTable());
			boolean bAddFireWallRulelink;
			bAddFireWallRulelink=WebObjectUtil.isElementPresent(UserPermission.getNav_AddFireWallLink());

			if(bAddFireWallRulelink)
			{
				FrameworkUtil.updateCustomResultBasedOnStatus(false, sUserName + " is  having access to Add FireWall rule" );
			}
			else
			{
				FrameworkUtil.updateCustomResultBasedOnStatus(true, sUserName + " is not having access to Add FireWall rule" );
			}
			LoginTestCase.nav_Logout();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		
		@Test(priority=1017)
		public static void AccessToAddFirewallRuleTest(){
			{
				try {
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver, UserPermission);	
					
					String sUserName ;
					String sPassword;
					String sFireWallToExpand;	
					sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.FIREWALL.AROLE");
					sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.AROLE");
					sFireWallToExpand=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.FIREWALLTOEXPAND");
					
					//WebObjectUtil.selectCustomWebList(webElement, sVisibleText).
					FrameworkUtil.sTestCaseName = "UserPermissions-AccessToAddFirewallRule";
					FrameworkUtil.sManualTestCaseName="Verify that given user is able to add a firewall rule";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					//AccessToFirewall(sUserName,sPassword,sFireWallToExpand);
					AccessToAddFirewallRule(sUserName,sPassword,sFireWallToExpand);
					LoginTestCase.nav_Logout();
					
					sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.FIREWALL.CROLE");
					sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.CROLE");
					sFireWallToExpand=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.FIREWALLTOEXPAND");
					AccessToAddFirewallRule(sUserName,sPassword,sFireWallToExpand);
					LoginTestCase.nav_Logout();
					}
					catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		@Test(priority=1018)
		public void AccessToMoveFirewallRule()
		{
			try {
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, UserPermission);	
			
			String sUserName;
			String sPassword;
			String sFireWallToExpand,sFireWallRuleToExpand,sSequenceNumber;	
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.FIREWALL.AROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.AROLE");
			sFireWallToExpand=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.FIREWALLTOEXPAND");
			sFireWallRuleToExpand=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.FIREWALLRULETOEXPAND");
			sSequenceNumber=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.FIREWALL.SEQUENCENUMBER");
			
			FrameworkUtil.sTestCaseName = "UserPermissions-AccessToMoveFirewallRule";
			FrameworkUtil.sManualTestCaseName="Verify that given user is able to Move firewall rule";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			AccessToFirewall(sUserName,sPassword,sFireWallToExpand);
			
			//int sRowNumber=WebTableUtil.getRowByCellText(UserPermission.getNav_FirewallTable(), sFireWallToExpand, 0,1);
			//WebElement ExpandWebElement = WebObjectUtil.GetWebElement("xpath", "//table//tr["+sRowNumber+"]//img[contains(@id,'firewallsummary')]","Expand Interface");
			//ExpandWebElement.click();
			//boolean bAddFirewallLinkSts=WebObjectUtil.isElementPresent(UserPermission.getNav_AddFireWallLink());
			//ExpandWebElement.click();
			//WebObjectUtil.waitForElementPresent(UserPermission.getNav_FirewallRuleTable());
			
			int sRowNumber=WebTableUtil.getRowByCellText(UserPermission.getNav_FirewallTable(), sFireWallRuleToExpand, 0,1);
			WebElement ExpandRuleWebElement = WebObjectUtil.GetWebElement("xpath", "//section//table//tr["+sRowNumber+"]/td/table//div[contains(@class,'x-grid-row-expander')]","Expand Firewall Rule");
			//ExpandWebElement.click();
			//boolean bAddFirewallLinkSts=WebObjectUtil.isElementPresent(UserPermission.getNav_AddFireWallLink());
			ExpandRuleWebElement.click();
			WebObjectUtil.explicitWait(10);
			//WebObjectUtil.waitForElementPresent(UserPermission.getNav_MoveLink());
			//WebObjectUtil.clickElement(UserPermission.getNav_MoveLink());
			WebElement MoveRuleWebElement=WebObjectUtil.GetWebElement("xpath", "//section//table//tr["+sRowNumber+"]/td/table//span[contains(@id,'fwEdit-moveButton-fwRuID')]/a[contains(text(),'Move')]","Move Firewall Rule");
			if(MoveRuleWebElement.isDisplayed())
				FrameworkUtil.updateCustomResultBasedOnStatus(true,"User "+sUserName+" is able to Move FireWall Rule" );
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false,"User "+sUserName+" is not able to Move FireWall Rule" );
			/*MoveRuleWebElement.click();
			WebObjectUtil.explicitWait(10);
			WebObjectUtil.SetValueEdit(UserPermission.getNav_SequenceNumberinFirewallRuleTable(), sSequenceNumber);
			//WebObjectUtil.clickElement(UserPermission.getNav_SaveEditsLink());
			WebElement SaveEditsWebElement=WebObjectUtil.GetWebElement("xpath", "//section//table//tr["+sRowNumber+"]/td/table//span[contains(@id,'fwEdit-saveButton-fwRuID')]/a[contains(text(),'Save Edits')]","Save Edits Button");
			SaveEditsWebElement.click();
			
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_ConfirmNewPopup());
			//WebObjectUtil.clickElement(UserPermission.getNav_PopupWindowOkButton());
			
			String sFirewallMoveMsg="Successfully created a ticket with TicketId";
			boolean bFirewallMoveMsg = UserPermission.getNav_ConfirmNewPopup().getText().contains(sFirewallMoveMsg);
			if(bFirewallMoveMsg)
				FrameworkUtil.updateCustomResultBasedOnStatus(true,sFirewallMoveMsg);
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false,"User "+sUserName+" Failed in moving a firewall rule");
			WebObjectUtil.clickElement(UserPermission.getNav_ConfirmNewPopupOKBtn());
			 String sFirewallMoveFeedBackMsg="Successfully created a ticket with TicketId";
			 boolean bFirewallMoveFeedBackMsg = UserPermission.getNav_FeedBackArea().getText().contains(sFirewallMoveFeedBackMsg);
			if(bFirewallMoveFeedBackMsg)
				FrameworkUtil.updateCustomResultBasedOnStatus(true,sFirewallMoveFeedBackMsg);
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false,"User "+sUserName+" Failed in moving a firewall rule");*/
						
			LoginTestCase.nav_Logout();
			
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.FIREWALL.CROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.CROLE");
			sFireWallToExpand=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.FIREWALLTOEXPAND");
			
			//LoginTestCase.nav_Login(sUserName, sPassword);
			AccessToFirewall(sUserName,sPassword,sFireWallToExpand);
			//LoginTestCase.nav_Login(sUserName, sPassword);
			//int sRowNumberUserC=WebTableUtil.getRowByCellText(UserPermission.getNav_FirewallTable(), sFireWallToExpand, 0,1);
			//WebElement ExpandWebElementUserC = WebObjectUtil.GetWebElement("xpath", "//table//tr["+sRowNumberUserC+"]//img[contains(@id,'firewallsummary')]","Expand Interface");
			//ExpandWebElement.click();
			//boolean bAddFirewallLinkSts=WebObjectUtil.isElementPresent(UserPermission.getNav_AddFireWallLink());
			//ExpandWebElementUserC.click();
			///WebObjectUtil.waitForElementPresent(UserPermission.getNav_FirewallRuleTable());
			
			int sRowNumberC=WebTableUtil.getRowByCellText(UserPermission.getNav_FirewallTable(), sFireWallRuleToExpand, 0,1);
			WebElement ExpandRuleWebElementC = WebObjectUtil.GetWebElement("xpath", "//section//table//tr["+sRowNumberC+"]/td/table//div[contains(@class,'x-grid-row-expander')]","Expand Firewall Rule");
			//ExpandWebElement.click();
			//boolean bAddFirewallLinkSts=WebObjectUtil.isElementPresent(UserPermission.getNav_AddFireWallLink());
			ExpandRuleWebElementC.click();
			WebObjectUtil.explicitWait(10);
			//WebObjectUtil.waitForElementPresent(UserPermission.getNav_MoveLink());
			//WebObjectUtil.clickElement(UserPermission.getNav_MoveLink());
			WebElement MoveRuleWebElementC=WebObjectUtil.GetWebElement("xpath", "//section//table//tr["+sRowNumberC+"]/td/table//span[contains(@id,'fwEdit-moveButton-fwRuID')]/a[contains(text(),'Move')]","Move Firewall Rule");
			if(MoveRuleWebElementC.isDisplayed())
				FrameworkUtil.updateCustomResultBasedOnStatus(true,"User "+sUserName+" is able to Move FireWall Rule" );
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false,"User "+sUserName+" is not able to Move FireWall Rule" );
			/*MoveRuleWebElementC.click();
			WebObjectUtil.explicitWait(10);
			WebObjectUtil.SetValueEdit(UserPermission.getNav_SequenceNumberinFirewallRuleTable(), sSequenceNumber);
			//WebObjectUtil.clickElement(UserPermission.getNav_SaveEditsLink());
			WebElement SaveEditsWebElementC=WebObjectUtil.GetWebElement("xpath", "//section//table//tr["+sRowNumberC+"]/td/table//span[contains(@id,'fwEdit-saveButton-fwRuID')]/a[contains(text(),'Save Edits')]","Save Edits Button");
			SaveEditsWebElementC.click();
			
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_ConfirmNewPopup());
			
			String sFirewallMoveMsgUserC="Successfully created a ticket with TicketId";
			boolean bFirewallMoveMsgUserC = UserPermission.getNav_ConfirmNewPopup().getText().contains(sFirewallMoveMsgUserC);
			if(bFirewallMoveMsgUserC)
				FrameworkUtil.updateCustomResultBasedOnStatus(true,sFirewallMoveMsgUserC);
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false,"User "+sUserName+" Failed in moving a firewall rule");
			WebObjectUtil.clickElement(UserPermission.getNav_ConfirmNewPopupOKBtn());
			 String sFirewallMoveFeedBackMsgUserC="Successfully created a ticket with TicketId";
			 boolean bFirewallMoveFeedBackMsgUserC = UserPermission.getNav_FeedBackArea().getText().contains(sFirewallMoveFeedBackMsgUserC);
			if(bFirewallMoveFeedBackMsgUserC)
				FrameworkUtil.updateCustomResultBasedOnStatus(true,sFirewallMoveFeedBackMsgUserC);
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false,"User "+sUserName+" Failed in moving a firewall rule");*/
		
			LoginTestCase.nav_Logout();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		@Test(priority=1019)
		public void NoAccessToMoveFirewallRule()
		{
			try {
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, UserPermission);	
			
			String sUserName ;
			String sPassword;
			String sFireWallToExpand,sFireWallRuleToExpand,sSequenceNumber;	
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.FIREWALL.EROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.EROLE");
			sFireWallToExpand=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.FIREWALLTOEXPAND");
			sFireWallRuleToExpand=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.FIREWALLRULETOEXPAND");
			//sSequenceNumber=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.FIREWALL.SEQUENCENUMBER");
			
			FrameworkUtil.sTestCaseName = "UserPermissions-NoAccessToMoveFirewallRule";
			FrameworkUtil.sManualTestCaseName="Verify that given user is not able to Move firewall rule";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			LoginTestCase.nav_Login(sUserName, sPassword);
			
			WebObjectUtil.clickElement(EVDC_Overview.getNav_EVDCname());
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_FirewallLink());
			WebObjectUtil.clickElement(UserPermission.getNav_FirewallLink());
			WebObjectUtil.explicitWait(5);
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_FirewallTable());
			
			int sRowNumber=WebTableUtil.getRowByCellText(UserPermission.getNav_FirewallTable(), sFireWallToExpand, 0,1);
			WebElement ExpandWebElement = WebObjectUtil.GetWebElement("xpath", "//table//tr["+sRowNumber+"]//img[contains(@id,'firewallsummary')]","Expand Interface");
			//ExpandWebElement.click();
			//boolean bAddFirewallLinkSts=WebObjectUtil.isElementPresent(UserPermission.getNav_AddFireWallLink());
			ExpandWebElement.click();
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_FirewallRuleTable());
			
			sRowNumber=WebTableUtil.getRowByCellText(UserPermission.getNav_FirewallTable(), sFireWallRuleToExpand, 0,1);
			WebElement ExpandRuleWebElement = WebObjectUtil.GetWebElement("xpath", "//section//table//tr["+sRowNumber+"]/td/table//div[contains(@class,'x-grid-row-expander')]","Expand Firewall Rule");
			
			if(ExpandRuleWebElement==null)
				FrameworkUtil.updateCustomResultBasedOnStatus(true,"User "+sUserName+"is not able to Move Firewall rule");
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false,"User "+sUserName+" is able to Move a firewall rule");
						
			LoginTestCase.nav_Logout();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@Test(priority=1020)
		public void NoAccessToEditFirewallRule()
		{
			try {
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, UserPermission);	
			
			String sUserName ;
			String sPassword;
			String sFireWallToExpand,sFireWallRuleToExpand,sSequenceNumber;	
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.FIREWALL.EROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.EROLE");
			sFireWallToExpand=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.FIREWALLTOEXPAND");
			sFireWallRuleToExpand=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.FIREWALLRULETOEXPAND");
			//sSequenceNumber=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.FIREWALL.SEQUENCENUMBER");
			
			FrameworkUtil.sTestCaseName = "UserPermissions-NoAccessToEditFirewallRule";
			FrameworkUtil.sManualTestCaseName="Verify that given user is not able to Edit firewall rule";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			LoginTestCase.nav_Login(sUserName, sPassword);
			
			WebObjectUtil.clickElement(EVDC_Overview.getNav_EVDCname());
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_FirewallLink());
			WebObjectUtil.clickElement(UserPermission.getNav_FirewallLink());
			WebObjectUtil.explicitWait(10);
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_FirewallTable());
			
			int sRowNumber=WebTableUtil.getRowByCellText(UserPermission.getNav_FirewallTable(), sFireWallToExpand, 0,1);
			WebElement ExpandWebElement = WebObjectUtil.GetWebElement("xpath", "//table//tr["+sRowNumber+"]//img[contains(@id,'firewallsummary')]","Expand Interface");
			//ExpandWebElement.click();
			//boolean bAddFirewallLinkSts=WebObjectUtil.isElementPresent(UserPermission.getNav_AddFireWallLink());
			ExpandWebElement.click();
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_FirewallRuleTable());
			
			sRowNumber=WebTableUtil.getRowByCellText(UserPermission.getNav_FirewallTable(), sFireWallRuleToExpand, 0,1);
			WebElement ExpandRuleWebElement = WebObjectUtil.GetWebElement("xpath", "//section//table//tr["+sRowNumber+"]/td/table//div[contains(@class,'x-grid-row-expander')]","Expand Firewall Rule");
			
			if(ExpandRuleWebElement==null)
				FrameworkUtil.updateCustomResultBasedOnStatus(true,"User "+sUserName+"is not able to Edit Firewall rule");
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false,"User "+sUserName+" is able to Edit a firewall rule");
				
			
			
			LoginTestCase.nav_Logout();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		@Test(priority=1021)
		public void NoAccessToDeleteFirewallRule()
		{
			try {
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, UserPermission);	
			
			String sUserName ;
			String sPassword;
			String sFireWallToExpand,sFireWallRuleToExpand,sSequenceNumber;	
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.FIREWALL.EROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.EROLE");
			sFireWallToExpand=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.FIREWALLTOEXPAND");
			sFireWallRuleToExpand=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.FIREWALLRULETOEXPAND");
			//sSequenceNumber=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.FIREWALL.SEQUENCENUMBER");
			
			FrameworkUtil.sTestCaseName = "UserPermissions-NoAccessToDeleteFirewallRule";
			FrameworkUtil.sManualTestCaseName="Verify that given user is not able to Move firewall rule";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			LoginTestCase.nav_Login(sUserName, sPassword);
			
			WebObjectUtil.clickElement(EVDC_Overview.getNav_EVDCname());
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_FirewallLink());
			WebObjectUtil.clickElement(UserPermission.getNav_FirewallLink());
			WebObjectUtil.explicitWait(10);
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_FirewallTable());
			
			int sRowNumber=WebTableUtil.getRowByCellText(UserPermission.getNav_FirewallTable(), sFireWallToExpand, 0,1);
			WebElement ExpandWebElement = WebObjectUtil.GetWebElement("xpath", "//table//tr["+sRowNumber+"]//img[contains(@id,'firewallsummary')]","Expand Interface");
			//ExpandWebElement.click();
			//boolean bAddFirewallLinkSts=WebObjectUtil.isElementPresent(UserPermission.getNav_AddFireWallLink());
			ExpandWebElement.click();
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_FirewallRuleTable());
			
			sRowNumber=WebTableUtil.getRowByCellText(UserPermission.getNav_FirewallTable(), sFireWallRuleToExpand, 0,1);
			WebElement ExpandRuleWebElement = WebObjectUtil.GetWebElement("xpath", "//section//table//tr["+sRowNumber+"]/td/table//div[contains(@class,'x-grid-row-expander')]","Expand Firewall Rule");
			
			if(ExpandRuleWebElement==null)
				FrameworkUtil.updateCustomResultBasedOnStatus(true,"User "+sUserName+"is not able to Delete Firewall rule");
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false,"User "+sUserName+" is able to Delete a firewall rule");
						
			LoginTestCase.nav_Logout();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		@Test(priority=1050)
		public void AccessToEditFirewallRule()
		{
			try {
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, UserPermission);	
			
			String sUserName ;
			String sPassword;
			String sFireWallToExpand,sFireWallRuleToExpand,sSequenceNumber;	
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.FIREWALL.AROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.AROLE");
			sFireWallToExpand=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.FIREWALLTOEXPAND");
			sFireWallRuleToExpand=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.FIREWALLRULETOEXPAND");
			sSequenceNumber=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.FIREWALL.SEQUENCENUMBER");
			
			FrameworkUtil.sTestCaseName = "UserPermissions-AccessToEditFirewallRule";
			FrameworkUtil.sManualTestCaseName="Verify that given user is able to Edit firewall rule";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			AccessToFirewall(sUserName,sPassword,sFireWallToExpand);
			
			/*int sRowNumber=WebTableUtil.getRowByCellText(UserPermission.getNav_FirewallTable(), sFireWallToExpand, 0,1);
			WebElement ExpandWebElement = WebObjectUtil.GetWebElement("xpath", "//table//tr["+sRowNumber+"]//img[contains(@id,'firewallsummary')]","Expand Interface");
			//ExpandWebElement.click();
			WebObjectUtil.explicitWait(15);
			//boolean bAddFirewallLinkSts=WebObjectUtil.isElementPresent(UserPermission.getNav_AddFireWallLink());
			ExpandWebElement.click();*/
			WebObjectUtil.explicitWait(25);
			//WebObjectUtil.waitForElementPresent(UserPermission.getNav_FirewallRuleTable());
			
			int sRowNumber=WebTableUtil.getRowByCellText(UserPermission.getNav_FirewallRuleTable(), sFireWallRuleToExpand, 0,1);
			WebElement ExpandRuleWebElement = WebObjectUtil.GetWebElement("xpath", "//section//table//tr["+sRowNumber+"]/td/table//div[contains(@class,'x-grid-row-expander')]","Expand Firewall Rule");
			//ExpandWebElement.click();
			//boolean bAddFirewallLinkSts=WebObjectUtil.isElementPresent(UserPermission.getNav_AddFireWallLink());
			ExpandRuleWebElement.click();
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_MoveLink());
			WebObjectUtil.verifyElementPresent(UserPermission.getNav_EditLink());
			/*WebObjectUtil.SetValueEdit(UserPermission.getNav_SequenceNumberinFirewallRuleTable(), sSequenceNumber);
			WebObjectUtil.clickElement(UserPermission.getNav_SaveEditsLink());
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_PopupWindow());
			WebObjectUtil.clickElement(UserPermission.getNav_PopupWindowOkButton());
			///_________________________NEEED TO UPDATE FOLLOWING MESSAGES TEXT_______________________
			String sFirewallMoveMsg="Successfully created a ticket with TicketId";
			boolean bFirewallMoveMsg = UserPermission.getNav_PopupWindow().getText().contains(sFirewallMoveMsg);
			if(bFirewallMoveMsg)
				FrameworkUtil.updateCustomResultBasedOnStatus(true,sFirewallMoveMsg);
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false,"User "+sUserName+" Failed in moving a firewall rule");
			WebObjectUtil.clickElement(UserPermission.getNav_PopupWindowOkButton());
			 String sFirewallMoveFeedBackMsg="Successfully created a ticket with TicketId";
			 boolean bFirewallMoveFeedBackMsg = UserPermission.getNav_FeedBackArea().getText().contains(sFirewallMoveFeedBackMsg);
			if(bFirewallMoveFeedBackMsg)
				FrameworkUtil.updateCustomResultBasedOnStatus(true,sFirewallMoveFeedBackMsg);
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false,"User "+sUserName+" Failed in moving a firewall rule");
						///_________________________NEEED TO UPDATE FOLLOWING MESSAGES TEXT_______________________*/
			
			LoginTestCase.nav_Logout();
			
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.FIREWALL.CROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.CROLE");
			sFireWallToExpand=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.FIREWALLTOEXPAND");
			AccessToFirewall(sUserName,sPassword,sFireWallToExpand);
		
			//LoginTestCase.nav_Login(sUserName, sPassword);
			/*int sRowNumberC=WebTableUtil.getRowByCellText(UserPermission.getNav_FirewallTable(), sFireWallToExpand, 0,1);
			WebElement ExpandWebElementC = WebObjectUtil.GetWebElement("xpath", "//table//tr["+sRowNumber+"]//img[contains(@id,'firewallsummary')]","Expand Interface");
			//ExpandWebElement.click();
			//boolean bAddFirewallLinkSts=WebObjectUtil.isElementPresent(UserPermission.getNav_AddFireWallLink());
			ExpandWebElementC.click();
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_FirewallRuleTable());*/
			
			int sRowNumberC=WebTableUtil.getRowByCellText(UserPermission.getNav_FirewallRuleTable(), sFireWallRuleToExpand, 0,1);
			WebElement ExpandRuleWebElementC = WebObjectUtil.GetWebElement("xpath", "//section//table//tr["+sRowNumber+"]/td/table//div[contains(@class,'x-grid-row-expander')]","Expand Firewall Rule");
			//ExpandWebElement.click();
			//boolean bAddFirewallLinkSts=WebObjectUtil.isElementPresent(UserPermission.getNav_AddFireWallLink());
			ExpandRuleWebElementC.click();
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_MoveLink());
			WebObjectUtil.verifyElementPresent(UserPermission.getNav_EditLink());
			/*WebObjectUtil.SetValueEdit(UserPermission.getNav_SequenceNumberinFirewallRuleTable(), sSequenceNumber);
			WebObjectUtil.clickElement(UserPermission.getNav_SaveEditsLink());
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_PopupWindow());
			WebObjectUtil.clickElement(UserPermission.getNav_PopupWindowOkButton());
			///_________________________NEEED TO UPDATE FOLLOWING MESSAGES TEXT_______________________
			String sFirewallMoveMsgUserC="Successfully created a ticket with TicketId";
			boolean bFirewallMoveMsgUserC = UserPermission.getNav_PopupWindow().getText().contains(sFirewallMoveMsgUserC);
			if(bFirewallMoveMsgUserC)
				FrameworkUtil.updateCustomResultBasedOnStatus(true,sFirewallMoveMsgUserC);
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false,"User "+sUserName+" Failed in editing a firewall rule");
			WebObjectUtil.clickElement(UserPermission.getNav_PopupWindowOkButton());
			 String sFirewallMoveFeedBackMsgUserC="Successfully created a ticket with TicketId";
			 boolean bFirewallMoveFeedBackMsgUserC = UserPermission.getNav_FeedBackArea().getText().contains(sFirewallMoveFeedBackMsgUserC);
			if(bFirewallMoveFeedBackMsgUserC)
				FrameworkUtil.updateCustomResultBasedOnStatus(true,sFirewallMoveFeedBackMsgUserC);
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false,"User "+sUserName+" Failed in editing a firewall rule");
						///_________________________NEEED TO UPDATE FOLLOWING MESSAGES TEXT_______________________*/
			LoginTestCase.nav_Logout();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		@Test(priority=1051)
		public void AccessToDeleteFirewallRule()
		{
			try {
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, UserPermission);	
			
			String sUserName ;
			String sPassword;
			String sFireWallToExpand,sFireWallRuleToExpand,sSequenceNumber;	
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.FIREWALL.AROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.AROLE");
			sFireWallToExpand=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.FIREWALLTOEXPAND");
			sFireWallRuleToExpand=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.FIREWALLRULETOEXPAND");
			sSequenceNumber=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.FIREWALL.SEQUENCENUMBER");
			
			FrameworkUtil.sTestCaseName = "UserPermissions-AccessToDeleteFirewallRule";
			FrameworkUtil.sManualTestCaseName="Verify that given user is able to Edit firewall rule";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			AccessToFirewall(sUserName,sPassword,sFireWallToExpand);
			
			/*int sRowNumber=WebTableUtil.getRowByCellText(UserPermission.getNav_FirewallTable(), sFireWallToExpand, 0,1);
			WebElement ExpandWebElement = WebObjectUtil.GetWebElement("xpath", "//table//tr["+sRowNumber+"]//img[contains(@id,'firewallsummary')]","Expand Interface");
			//ExpandWebElement.click();
			//boolean bAddFirewallLinkSts=WebObjectUtil.isElementPresent(UserPermission.getNav_AddFireWallLink());
			ExpandWebElement.click();
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_FirewallRuleTable());*/
			
			//int sRowNumber=WebTableUtil.getRowByCellText(UserPermission.getNav_FirewallTable(), sFireWallRuleToExpand, 0,1);
			//WebElement ExpandRuleWebElement = WebObjectUtil.GetWebElement("xpath", "//section//table//tr[1]/td/table//div[contains(@class,'x-grid-row-expander')]","Expand Firewall Rule");
			//ExpandWebElement.click();
			//boolean bAddFirewallLinkSts=WebObjectUtil.isElementPresent(UserPermission.getNav_AddFireWallLink());
			// This line updated on 10/14/2015 for EXTJS5 by QAA03
			WebElement ExpandRuleWebElement = WebObjectUtil.GetWebElement("xpath", "//div[@class='x-grid-item-container']//table[1]//div[contains(@class,'x-grid-row-expander')]","Expand Firewall Rule");
			ExpandRuleWebElement.click();
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_MoveLink());
			WebObjectUtil.verifyElementPresent(UserPermission.getNav_DeleteLink());
			/*WebObjectUtil.clickElement(UserPermission.getNav_DeleteLink());
			WebObjectUtil.SetValueEdit(UserPermission.getNav_SequenceNumberinFirewallRuleTable(), sSequenceNumber);
			WebObjectUtil.clickElement(UserPermission.getNav_SaveEditsLink());
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_PopupWindow());
			WebObjectUtil.clickElement(UserPermission.getNav_PopupWindowOkButton());
			///_________________________NEEED TO UPDATE FOLLOWING MESSAGES TEXT_______________________
			String sFirewallMoveMsg="Successfully created a ticket with TicketId";
			boolean bFirewallMoveMsg = UserPermission.getNav_PopupWindow().getText().contains(sFirewallMoveMsg);
			if(bFirewallMoveMsg)
				FrameworkUtil.updateCustomResultBasedOnStatus(true,sFirewallMoveMsg);
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false,"User "+sUserName+" Failed in moving a firewall rule");
			WebObjectUtil.clickElement(UserPermission.getNav_PopupWindowOkButton());
			 String sFirewallMoveFeedBackMsg="Successfully created a ticket with TicketId";
			 boolean bFirewallMoveFeedBackMsg = UserPermission.getNav_FeedBackArea().getText().contains(sFirewallMoveFeedBackMsg);
			if(bFirewallMoveFeedBackMsg)
				FrameworkUtil.updateCustomResultBasedOnStatus(true,sFirewallMoveFeedBackMsg);
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false,"User "+sUserName+" Failed in moving a firewall rule");
						///_________________________NEEED TO UPDATE FOLLOWING MESSAGES TEXT_______________________*/
			
			LoginTestCase.nav_Logout();
			
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.FIREWALL.CROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.CROLE");
			sFireWallToExpand=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.FIREWALLTOEXPAND");
			AccessToFirewall(sUserName,sPassword,sFireWallToExpand);
			/*sRowNumber=WebTableUtil.getRowByCellText(UserPermission.getNav_FirewallTable(), sFireWallRuleToExpand, 0,1);
			WebElement ExpandRuleWebElementC = WebObjectUtil.GetWebElement("xpath", "//section//table//tr["+sRowNumber+"]/td/table//div[contains(@class,'x-grid-row-expander')]","Expand Firewall Rule");
			ExpandRuleWebElementC.click();*/
			//boolean bAddFirewallLinkSts=WebObjectUtil.isElementPresent(UserPermission.getNav_AddFireWallLink());
			//ExpandRuleWebElement.click();
			// This line updated on 10/14/2015 for EXTJS5 by QAA03
			WebElement ExpandRuleWebElementC = WebObjectUtil.GetWebElement("xpath", "//div[@class='x-grid-item-container']//table[1]//div[contains(@class,'x-grid-row-expander')]","Expand Firewall Rule");
			ExpandRuleWebElementC.click();
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_MoveLink());
			WebObjectUtil.verifyElementPresent(UserPermission.getNav_DeleteLink());
			LoginTestCase.nav_Logout();
			
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		
		//@Test(priority=1052)
		public void accessToDisableMonitoring(){
			String sUserName;
			String sPassword;
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, UserPermissionTestCase.UserPermission);
			EVDCPageFactory EVDC = new EVDCPageFactory();
		  //  EVDC_VM_AdvancedActions_PageFactory EVDC_Advanced = new EVDC_VM_AdvancedActions_PageFactory();
			FrameworkUtil.sTestCaseName = "UserPermission-accessToDisableMonitoring";
			FrameworkUtil.sManualTestCaseName="Verify given user able to disable monitoring";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
			LoginTestCase.nav_Login(sUserName, sPassword);
			WebObjectUtil.clickElement(EVDC_Overview.getNav_EVDCname());
			//WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			WebObjectUtil.clickElement(UserPermission.getNav_EVDCOverviewVirtualMachine());
			int sRowNumber=WebTableUtil.getRowByCellText(UserPermission.getNav_VMWebTable(), "Stopped", 0,1);
		    WebElement OpenEyeIcon =WebObjectUtil.GetWebElement("xpath","//tr["+sRowNumber+"]//td[10]//img[@src='/virtual-machines-portlet/resources/images/ClosedEye_Icon.png']","Open Eye");
			
			
			
			
			
			
			EVDC_VM_AdvancedActions.navigateAndExpandVM("Stopped");    //EVDC_VM_AdvancedActions.navigateAndExpandVM("test_Tomsmultivapp_abhi_local");
			
			LoginTestCase.nav_Logout();
			
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
			LoginTestCase.nav_Login(sUserName, sPassword);
			EVDC_VM_AdvancedActions.navigateAndExpandVM("Stopped");    //EVDC_VM_AdvancedActions.navigateAndExpandVM("test_Tomsmultivapp_abhi_local");
			
			LoginTestCase.nav_Logout();

		}
		
		
		
		public static void AccessToFirewall(String sUserName,String sPassword,String sFireWallToExpand){
			//Log into Navigator
			try {
					LoginTestCase.nav_Login(sUserName, sPassword);
					
					WebObjectUtil.clickElement(EVDC_Overview.getNav_EVDCname());
					WebObjectUtil.waitForElementPresent(UserPermission.getNav_FirewallLink());
					WebObjectUtil.clickElement(UserPermission.getNav_FirewallLink());
					WebObjectUtil.waitForElementPresent(UserPermission.getNav_FirewallTable());
					
					int sRowNumber=WebTableUtil.getRowByCellText(UserPermission.getNav_FirewallTable(), sFireWallToExpand, 0,1);
					WebElement ExpandWebElement = WebObjectUtil.GetWebElement("xpath", "//table//tr["+sRowNumber+"]//img[contains(@id,'firewallsummary')]","Delete Link");
					ExpandWebElement.click();
					WebObjectUtil.waitForElementPresent(UserPermission.getNav_AddFireWallLink());
					Thread.sleep(5000);
					boolean bAddFirewallLinkSts=WebObjectUtil.isElementPresent(UserPermission.getNav_AddFireWallLink());
					if(bAddFirewallLinkSts)
					{
						FrameworkUtil.updateCustomResultBasedOnStatus(true, sUserName + " has access to view FireWall Informaton" );
					}
					else
					{
						FrameworkUtil.updateCustomResultBasedOnStatus(false, sUserName + " is not having access to view FireWall Informaton" );
					}
					
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static void AccessToAddFirewallRule(String sUserName,String sPassword,String sFireWallToExpand){
            /*String sSequenceNumber,sSource,sSourceMask,sDestination,sDestinationMask,sProtocol,sPort;*/
            AccessToFirewall(sUserName,sPassword,sFireWallToExpand);
            //WebObjectUtil.verifyElementPresent(UserPermission.getNav_AddFireWallLink());
            /*WebObjectUtil.clickElement(UserPermission.getNav_AddFireWallLink());
            WebObjectUtil.waitForElementPresent(UserPermission.getNav_AddFireWallWindow());
            sSequenceNumber=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.FIREWALL.SEQUENCENUMBER");
            sSource=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.FIREWALL.SOURCE");
            sSourceMask=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.FIREWALL.SOURCEMASK");
            sDestination=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.FIREWALL.DESTINATION");
            sDestinationMask=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.FIREWALL.DESTINATIONMASK");
            sProtocol=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.FIREWALL.PROTOCOL");
            sPort=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.FIREWALL.PORT");
            
            WebObjectUtil.SetValueEdit(UserPermission.getNav_SequenceNumber(), sSequenceNumber);
            //WebObjectUtil.SetValueEdit(UserPermission.getNav_Source(), sSource);
            WebObjectUtil.ClickAndMouseHover(UserPermission.getNav_SourceDropDownIcon());
            WebObjectUtil.selectCustomWebList(UserPermission.getNav_SourceList(), 1);
            WebObjectUtil.ClickAndMouseHover(UserPermission.getNav_DestinationDownIcon());
            WebObjectUtil.selectCustomWebList(UserPermission.getNav_DestinationList(), 1);
            WebObjectUtil.ClickAndMouseHover(UserPermission.getNav_ProtocolDownIcon());
            WebObjectUtil.selectCustomWebList(UserPermission.getNav_ProtocolList(), 2);
            WebObjectUtil.SetValueEdit(UserPermission.getNav_PortName(), sPort);
            WebObjectUtil.clickElement(UserPermission.getNav_FirewallSaveButton());
            WebObjectUtil.waitForElementPresent(UserPermission.getNav_ConfirmNewPopup()); 
            WebObjectUtil.verifyElementPresent(UserPermission.getNav_ConfirmNewPopup());
            WebObjectUtil.verifyElementPresent(UserPermission.getNav_ConfirmNewPopupOKBtn());
            WebObjectUtil.clickElement(UserPermission.getNav_ConfirmNewPopupOKBtn());*/
      }

		
		
		public static void NoAccessToAddDrive(String sUserName,String sPassword){
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, Draas);
			LoginTestCase.nav_Login(sUserName, sPassword);
			WebObjectUtil.ClickAndMouseHover(UserPermission.getNav_ServicesTab());
			WebObjectUtil.clickElement(UserPermission.getNav_DRaaSLink());
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_HostBasedReplicationText());
			boolean bAddDriveSts=UserPermission.getNav_HostBasedReplicationAddDrive().isEnabled();
			if(bAddDriveSts)
				FrameworkUtil.updateCustomResultBasedOnStatus(true,"User "+sUserName+" is not having access to Add Drive");
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false,"User "+sUserName+" is able to Add A drive");
		}
		
		
		public static void AccessToViewDRaas(String sUserName,String sPassword){
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, Draas);
			LoginTestCase.nav_Login(sUserName, sPassword);
			WebObjectUtil.ClickAndMouseHover(UserPermission.getNav_ServicesTab());
			
			WebObjectUtil.clickElement(UserPermission.getNav_DRaaSLink());
			//boolean bstatus = WebObjectUtil.isElementPresent(UserPermission.getNav_HostBasedReplicationText());
			boolean bstatus = WebObjectUtil.isElementPresent(Draas.getNav_MoreDraasProducts());
			FrameworkUtil.updateCustomResultBasedOnStatus(bstatus, sUserName + " access to DRaaS" );
			//boolean bstatus1 = WebObjectUtil.isElementPresent(UserPermission.getNav_StorageArrayBasedReplicationText());
			//FrameworkUtil.updateCustomResultBasedOnStatus(bstatus1, sUserName + " access to DRaaS" );
		}
		
		public static void AccessToViewReports(String sUserName,String sPassword){
			LoginTestCase.nav_Login(sUserName, sPassword);
			//WebObjectUtil.clickElement(UserPermission.getNav_MonitoringLink());
			//System.out.println(WebObjectUtil.isElementPresent(UserPermission.getnav_MonitoringTab()));
			WebObjectUtil.ClickAndMouseHover(UserPermission.getNav_MonitoringTab());
			
			WebObjectUtil.clickElement(UserPermission.getNav_ReportLink());
			boolean bstatus = WebObjectUtil.isElementPresent(UserPermission.getNav_NetworkReportLink());
			FrameworkUtil.updateCustomResultBasedOnStatus(bstatus, sUserName + " access to Reports" );
			
		}
		public static void AccessToCreateTicket()
		{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, UserPermission);	
			PageFactory.initElements(driver, HomePageFactory);	
			
			WebObjectUtil.ClickAndMouseHover(HomePageFactory.getNav_SupportTab());
			WebObjectUtil.clickElement(HomePageFactory.getNav_TicketsMenuLink());
			WebObjectUtil.clickElement(UserPermission.getNav_CreateTicketLink());
			WebObjectUtil.waitForElementPresent(HomePageFactory.getnav_TitleText());
			HomeTestCase.EnterTitle();	
			HomeTestCase.SelectSeverityItem();
			HomeTestCase.SelectPriorityItem();
			HomeTestCase.SelectCategoryItem();
			HomeTestCase.ClickOKBtn();
			
			WebObjectUtil.waitForElementNotPresent(HomePageFactory.getnav_TitleText());
			
		}
		public static void AccessToDetailedTickettingSystem(String sUserName,String sPassword )
		{
			String ParentWindowName ;
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, UserPermission);	
			PageFactory.initElements(driver, HomePageFactory);	
			ParentWindowName =driver.getWindowHandle();
			WebObjectUtil.ClickAndMouseHover(HomePageFactory.getNav_SupportTab());
			WebObjectUtil.clickElement(HomePageFactory.getNav_TicketsMenuLink());	
			WebObjectUtil.clickElement(UserPermission.getNav_DetailTicketSystem());
			WebObjectUtil.switchToWindow(2, null);
			WebObjectUtil.waitForElementPresent(UserPermission.getEM7_LoginUserID());
			WebObjectUtil.SetValueEdit(UserPermission.getEM7_LoginUserID(), sUserName);
	        WebObjectUtil.SetValueEdit(UserPermission.getEM7_LoginPwd(), sPassword);
	        WebObjectUtil.clickElement(UserPermission.getEM7_LoginSubmit());
	        //This below lines updated on 10/14/2015 for EXTJS5 by QAA03
	       // WebObjectUtil.verifyElementPresent(UserPermission.getEM7_SignOutLink());
	        //WebObjectUtil.clickElement(UserPermission.getEM7_SignOutLink());
	        WebObjectUtil.clickElement(UserPermission.getEM7_ToolBoxIcon());
	        WebObjectUtil.verifyElementPresent(UserPermission.getEM7_Logoff());
	        WebObjectUtil.clickElement(UserPermission.getEM7_Logoff());
	        driver.close();
	        driver.switchTo().window(ParentWindowName);
			
		}	
		public static void AccessToViewForms(String sUserName,String sPassword,String sFormsUserId,String sFormsPassword){
			LoginTestCase.nav_Login(sUserName, sPassword);
			WebObjectUtil.ClickAndMouseHover(UserPermission.getNav_SupportTab());
			WebObjectUtil.ClickAndMouseHover(UserPermission.getNav_FormsLink());
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_FormsUserInput());
			WebObjectUtil.SetValueEdit(UserPermission.getNav_FormsUserInput(), sFormsUserId);
			WebObjectUtil.SetValueEdit(UserPermission.getNav_FormsPasswordInput(), sFormsPassword);
			WebObjectUtil.clickElement(UserPermission.getNav_FormsSubmitButton());
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_FormsHomePageText());
			WebObjectUtil.verifyElementPresent(UserPermission.getNav_FormsHomePageText());
			LoginTestCase.nav_Logout();
		}
		public static void NoAccessToViewForms(String sUserName,String sPassword,String sFormsUserId,String sFormsPassword){
			LoginTestCase.nav_Login(sUserName, sPassword);
			WebObjectUtil.ClickAndMouseHover(UserPermission.getNav_SupportTab());
		}
		public static void NoAccessToViewForms(String sUserName,String sPassword){
			LoginTestCase.nav_Login(sUserName, sPassword);
			WebObjectUtil.ClickAndMouseHover(UserPermission.getNav_SupportTab());
			boolean bFormsLinkSts=WebObjectUtil.isElementPresent(UserPermission.getNav_FormsLink());
			if(!bFormsLinkSts)
				FrameworkUtil.updateCustomResultBasedOnStatus(true, sUserName + " don't have access to Forms" );
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false, sUserName + " is able access to Forms" );
		}
		
		public static void AccessToViewForms(String sUserName,String sPassword){
			LoginTestCase.nav_Login(sUserName, sPassword);
			WebObjectUtil.ClickAndMouseHover(UserPermission.getNav_SupportTab());
			WebObjectUtil.ClickAndMouseHover(UserPermission.getNav_FormsLink());
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_FormsUserInput());
			WebObjectUtil.SetValueEdit(UserPermission.getNav_FormsUserInput(), sUserName);
			WebObjectUtil.SetValueEdit(UserPermission.getNav_FormsPasswordInput(), sPassword);
			WebObjectUtil.clickElement(UserPermission.getNav_FormsSubmitButton());
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_FormsHomePageText());
			WebObjectUtil.verifyElementPresent(UserPermission.getNav_FormsHomePageText());
			LoginTestCase.nav_Logout();
			
		}
		
		public static void NavigateToEscalationListPage()
		{
			//LoginTestCase.nav_Login(sUserName, sPassword);
			WebObjectUtil.ClickAndMouseHover(UserPermission.getNav_AccountTab());
			WebObjectUtil.clickElement(UserPermission.getNav_EscalationListLink());
			WebObjectUtil.verifyElementPresent(UserPermission.getNav_CriticalEscalationListTab());
			//FrameworkUtil.updateCustomResultBasedOnStatus(bstatus, "Escalation List Page displayed for the user "+sUserName );
		}
		
		
		public static void EnterAllRequiredFieldsInAddUserPopupWindow()
		{
			String sFirstName,sLastName,sEmailAddress;
			
			sFirstName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.FIRSTNAME");
			sLastName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.LASTNAME");
			sEmailAddress = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.EMAILADDRESS");
			
			//-----------------------------------------------------------------------------------
			//updated below 2 lines as part of EXTJS5 updation by QAA03 on 22sep2015
			
			/*WebObjectUtil.SetValueEdit(UserPermission.getNav_AddUserWindowFirstNameInput(), sFirstName);
			WebObjectUtil.SetValueEdit(UserPermission.getNav_AddUserWindowLastNameInput(), sLastName);
			WebObjectUtil.SetValueEdit(UserPermission.getNav_AddUserWindowemailAddressInput(), sEmailAddress);*/
			
			WebObjectUtil.SetValueEdit(UserPermission.getNav_FirstNameEdit(), sFirstName);
			WebObjectUtil.SetValueEdit(UserPermission.getNav_LastNameEdit(), sLastName);
			WebObjectUtil.SetValueEdit(UserPermission.getNav_EmailAddressEdit(), sEmailAddress);
			//-----------------------------------------------------------------------------------
		}
		
		
		public static void NavigateToCriticalEscalationListPage()
		{
			/// driver initialization by -- QAA04 12/1/2015
			WebDriver driver =WebDriverUtil.getDriver();
			PageFactory.initElements(driver, UserPermission);
			
			//LoginTestCase.nav_Login(sUserName, sPassword);
			WebObjectUtil.ClickAndMouseHover(UserPermission.getNav_AccountTab());
			WebObjectUtil.clickElement(UserPermission.getNav_EscalationListLink());
			WebObjectUtil.verifyElementPresent(UserPermission.getNav_CriticalEscalationListTab());
			
		}

		
		

		public static void EnterDataforAddDrive(String sHostname,String sHostIpAddress,String sDrivesToAdd)
		{
			WebObjectUtil.SetValueEdit(UserPermission.getNav_HostName(), sHostname);
			WebObjectUtil.SetValueEdit(UserPermission.getNav_HostIpAddress(), sHostIpAddress);
			WebObjectUtil.SetValueEdit(UserPermission.getNav_DrivesToAdd(), sDrivesToAdd);
		}

		

		/*==============================================================
		Method Name 	: NavigateToFirewallPage
		Description		: Navigates EVDC Firewall page
		Author 			: Sukur Babu. B
		Creation Date 	: 13/07/2015
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		public static void NavigateToFirewallPage()
		{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,UserPermission );
			PageFactory.initElements(driver,EVDC_VMPF);
			PageFactory.initElements(driver,EVDC_Overview);
			PageFactory.initElements(driver, Firewall);
			
			int iRulesCount=0;
			//This line updated on 10/02/2015 for EXTJS5 by QAA03
			//WebObjectUtil.clickElement(EVDC_Overview.getNav_EVDCname());
			WebObjectUtil.clickElement(EVDC_Overview.getNav_EVDCname());
			WebObjectUtil.waitForElementPresent(UserPermission.getNav_FirewallLink());
			WebObjectUtil.clickElement(UserPermission.getNav_FirewallLink());
			
			//This line updated on 10/02/2015 for EXTJS5 by Arul
			//if(UserPermission.getNav_InfoUnavailableText().isDisplayed())
			if(WebObjectUtil.isElementPresent(UserPermission.getNav_InfoUnavailableText()))	
			{
				
				iRulesCount=Integer.parseInt(Firewall.getNav_RulesCountText().getText());
				if(iRulesCount==0)
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Pop up displayed because rules count is Zero", "pass", "");
				else
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Pop up displayed even rules count is more than Zero", "fail", "");
				WebObjectUtil.clickElement(UserPermission.getNav_InfoUnavailableOKButton());
			}
			else
				WebObjectUtil.waitForElementPresent(UserPermission.getNav_FirewallTable());
		}
			

		/*==============================================================
		TestScript 		: editRoleBeforeAssignToUser
		Manual TestCase	: Verify given user able to Add Role
		Description		: Verify given user able to Add Role
		Author 			: Arularasu
		Creation Date 	: 08/14/2015
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		@Test(priority=101)
		public void editRoleBeforeAssignToUser(){
			String sUserName,sNewRoleName,sOrgName,sRoleSaveAs,sUser_Name;
			String sPassword;
			WebElement wOrgSelectorList;
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, UserPermissionTestCase.UserPermission);
			FrameworkUtil.sTestCaseName = "UserPermission-CPPOC3452-editRoleBeforeAssignToUser";
			FrameworkUtil.sManualTestCaseName="Verify that the user is able to see permissions correctly with the updated custom role";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
			/*	
			sOrgName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.ORGANISATION.SELECTOR.NAME");
			sUser_Name = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.AGENT13.USERNAME");
		*/	
			sOrgName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.ENTITY.ORGANISATION.SELECTOR.NAME");
			sUser_Name = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.ENTITY.USERNAME");
			
		//sRoleSaveAs =  (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.NEWROLENAME")+ FrameworkUtil.sTimeStamp;
			AccessToUserManagement( sUserName, sPassword);
			
			sNewRoleName = copyRoleManageRoles();
			//sNewRoleName = sNewRoleName + "_" + "CPPOC3452";
			
			editRoleManageRoles(sNewRoleName);
			WebDriverUtil.refreshBrowser();
			WebObjectUtil.clickElement(UserPermission.getNav_UsersTab());
			WebObjectUtil.clickElement(UserPermission.getNav_OrgSelectDropDown());
			WebObjectUtil.SetValueEdit(UserPermission.getNav_OrgSelectDropDown(), sOrgName);
			wOrgSelectorList = WebObjectUtil.GetWebElement("xpath", "//div[@class='x-boundlist-list-ct x-unselectable']/ul/li[text()='"+ sOrgName +"']", "Orgname:" +sOrgName );
			if (!(wOrgSelectorList == null)){
				WebObjectUtil.clickElement(wOrgSelectorList);
			}
			WebObjectUtil.explicitWait(5);
			editUserPermission(sNewRoleName,sUser_Name);
			
			LoginTestCase.nav_Logout();
			/*
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.AGENT13.USERNAME");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.AGENT13.PASSWORD");
			*/
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.ENTITY.USERNAME");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.ENTITY.PASSWORD");
			LoginTestCase.nav_Login(sUserName, sPassword);
	
			//EVDC_VM_AdvancedActions.navigateAndExpandVM("Stopped")	;
			navVerifyEditBtnNotPresent();
			
			
		}	

		/*==============================================================
		TestScript 		: editRoleAfterAssignToUser
		Manual TestCase	: Verify given user able to Add Role
		Description		: Verify given user able to Add Role
		Author 			: Arularasu
		Creation Date 	: 08/14/2015
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		@Test(priority=102)
		public void editRoleAfterAssignToUser(){
			String sUserName,sNewRoleName,sOrgName,sRoleSaveAs,sUser_Name;
			String sPassword;
			WebElement wOrgSelectorList;
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, UserPermissionTestCase.UserPermission);
			FrameworkUtil.sTestCaseName = "UserPermission-CPPOC3448-editRoleAfterAssignToUser";
			FrameworkUtil.sManualTestCaseName="Verify that the user is able to see permissions correctly with the updated custom role";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		/*	
			sOrgName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.ORGANISATION.SELECTOR.NAME");
			sUser_Name = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.AGENT13.USERNAME");
		*/	
			sOrgName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.ENTITY.ORGANISATION.SELECTOR.NAME");
			sUser_Name = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.ENTITY.USERNAME");
			
			//sRoleSaveAs =  (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.NEWROLENAME")+ FrameworkUtil.sTimeStamp;
			AccessToUserManagement( sUserName, sPassword);
			
			sNewRoleName = copyRoleManageRoles();
			//sNewRoleName = sNewRoleName + "_" + "CPPOC3448";
			WebDriverUtil.refreshBrowser();
			WebObjectUtil.clickElement(UserPermission.getNav_UsersTab());
			WebObjectUtil.clickElement(UserPermission.getNav_OrgSelectDropDown());
			WebObjectUtil.SetValueEdit(UserPermission.getNav_OrgSelectDropDown(), sOrgName);
			wOrgSelectorList = WebObjectUtil.GetWebElement("xpath", "//div[@class='x-boundlist-list-ct x-unselectable']/ul/li[text()='"+ sOrgName +"']", "Orgname:" +sOrgName );
			if (!(wOrgSelectorList == null)){
				WebObjectUtil.clickElement(wOrgSelectorList);
			}
			WebObjectUtil.explicitWait(5);
			editUserPermission(sNewRoleName,sUser_Name);
			WebObjectUtil.clickElement(UserPermission.getNav_ManageRolesTab());
			WebDriverUtil.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			editRoleManageRoles(sNewRoleName);
			
			
			LoginTestCase.nav_Logout();
	/*
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.AGENT13.USERNAME");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.AGENT13.PASSWORD");
			*/
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.ENTITY.USERNAME");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.ENTITY.PASSWORD");		
			LoginTestCase.nav_Login(sUserName, sPassword);
	
			//EVDC_VM_AdvancedActions.navigateAndExpandVM("Stopped")	;
			navVerifyEditBtnNotPresent();
			
			
		}	

		/*==============================================================
		MethodName 		: editUserPermission
		Manual TestCase	: Verify given user able to Edit role(change role) User Management Portal
		Description		: Verify given user able to Edit role(change role) User Management Portal
		Author 			: Arularasu
		Creation Date 	: 08/14/2015
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		public static void editUserPermission(String sRoleName,String sUserName){
			String sSuccessMsg,sRole1,sRole2,sSelectedItem,sUser_name,sUserRoleDropDownLocator,sUserRoleWebListLocator;
			//String sRoleName;
			WebElement sUserRoleDropDown,sUserRoleWebList, wOrgSelectorList;

			sSuccessMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.EDITROLE.FEEDBACKMSG") + sUserName;
			int iRowNo = WebTableUtil.getRowByCellText(UserPermission.getNav_UserTable(), sUserName, 0,1);
			WebElement row = WebTableUtil.getRowAsWebElement(UserPermission.getNav_UserTable(), iRowNo);
			WebObjectUtil.clickElement(row);
			//System.out.println(row.getText());
			
			
			//sUserRoleWebListLocator = "//tr[" + iRowNo + "]//td[4]//div[contains(@class,'x-grid-cell-inner')]";
			//sUserRoleWebList = WebObjectUtil.GetWebElement("xpath", sUserRoleWebListLocator, "UserRoleWebList");
			sUserRoleWebListLocator = "//table[" + iRowNo + "]//td[4]//div[contains(@class,'x-grid-cell-inner')]";
			sUserRoleWebList = WebObjectUtil.GetWebElement("xpath", sUserRoleWebListLocator, "");
			WebObjectUtil.clickElement(sUserRoleWebList);
			WebObjectUtil.explicitWait(2);

			wOrgSelectorList = WebObjectUtil.GetWebElement("xpath", "//div[@class='x-boundlist-list-ct x-unselectable']/ul/li[text()='"+ sRoleName +"']", "sRoleName:" +sRoleName );
			if (wOrgSelectorList == null){
				WebObjectUtil.clickElement(sUserRoleWebList);
				WebObjectUtil.explicitWait(2);
				WebObjectUtil.clickElement(UserPermission.getNav_UserRoleDropDownAsEdit());
				
			}
			wOrgSelectorList = WebObjectUtil.GetWebElement("xpath", "//div[@class='x-boundlist-list-ct x-unselectable']/ul/li[text()='"+ sRoleName +"']", "sRoleName:" +sRoleName );
			WebObjectUtil.clickElement(wOrgSelectorList);
			WebObjectUtil.explicitWait(5);
			WebObjectUtil.VerifyTextUnderElement(UserPermission.getNav_Feedbackportlet(), sSuccessMsg);
	
		}
		
		
	     /*==============================================================
	      Method Name       : navVerifyEditBtn
	      Description       : This will verify Edit buttons
	      Author                  : Vivek Kumar
	      Creation Date     : 02/17/2015
	      Pre-Requisites    :
	      Revision History: modified method to verify Edit button not present
	      ==============================================================*/
	      public static void navVerifyEditBtnNotPresent()
	      {
	            
	            WebDriver driver = WebDriverUtil.getDriver();
	        	PageFactory.initElements(driver,EVDC_VMPF);
				PageFactory.initElements(driver,EVDC_Overview);
	            WebElement wEdit;
	            int iRowNbr=1;
	            try {
	            	WebObjectUtil.clickAndVerifyElement(EVDC_Overview.getNav_EVDCname(), EVDC_Overview.getNav_EVDCOverviewVirtualMachine());
	    			WebObjectUtil.clickAndVerifyElement(EVDC_Overview.getNav_EVDCOverviewVirtualMachine(),EVDC_VMPF.getNav_VMWebTable());
	    			FrameworkUtil.updateCustomResultBasedOnStatus(!WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_AddVMLink()),"Add VM link should not present");
	    			
	    			EVDC_VM_AdvancedActions.expandVMbyRowNum(iRowNbr);
	    			 // This line updated on 14/10/2015 for EXTJS5 by QAA03
	                 // wEdit=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+ iRowNbr+"]/td/table/tbody/tr[2]//a[contains(text(),'Edit')]","Edit Button");
	    			wEdit=WebObjectUtil.GetWebElement("xpath", "//table["+ iRowNbr+"]/tbody/tr[2]/td//a[contains(text(),'Edit')]","Edit Button");


	                  if(wEdit ==null){
	                        FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Edit VM button NOT present as expected" , "pass","Edit button NOT present -  verified");
	                        LoggerUtil.log_type_info("Edit button NOT present as expected -  verified" );
	                  }
	                  else
	                  {
	                        FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Edit VM button NOT present as expected" , "fail", "Edit button present - expected is it should not be present");
	                        LoggerUtil.log_type_error("Edit button present - expected is it should not be present");
	                  }
	            } catch (Exception e) {
	                  LoggerUtil.log_type_error("issue with- navVerifyEditBtn" );
	                  LoggerUtil.log_type_error(e.getMessage());
	                  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	            }
	      }

	    	



/// ___________________ Clark TestCaases ___________________________ ////

/*==============================================================
TestScript 		: nav_verifyTheColumnsUnderUsersTab
Manual TestCase	: click on permissions link and verify Entity and Parent columns under users tab
Description		: click on permissions link and verify Entity and Parent columns under users tab with Role-A user
Author 			: QAA02
Creation Date 	: 08/18/2014
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=103)
public void nav_verifyTheColumnsUnderUsersTab() {
	
	  WebDriver driver = WebDriverUtil.getDriver();
	  PageFactory.initElements(driver, UserPermission);
	  PageFactory.initElements(driver, Home);
	  try {
		  

	  FrameworkUtil.sTestCaseName="Clark-nav_verifyTheColumnsUnderUsersTab";
	  FrameworkUtil.sManualTestCaseName="(CPPOC-3029)click on permissions link and verify Entity and Parent columns under users tab";
	  FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	  
	  String sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEA.USERID");
	  String sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEA.PASSWORD");
	  LoginTestCase.nav_Login(sUserName, sPassword);
	  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Role-ALogin", "Pass", "Login Sucess");

   WebObjectUtil.MouseHover(Home.getNav_AccountTab());
   WebObjectUtil.clickElement(Home.getNav_PermissionsLink());
   
   WebObjectUtil.verifyElementPresent(UserPermission.getNav_entityColumnUnderPermissionsTab());
   String entityTitle = UserPermission.getNav_entityColumnUnderPermissionsTab().getText();
   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "VerifyEntityColumn", "Pass", "ColumnTitleVerified= "+entityTitle);
   
   WebObjectUtil.verifyElementPresent(UserPermission.getNav_parentsColumnUnderPermissionsTab());
   String parenetTitle = UserPermission.getNav_parentsColumnUnderPermissionsTab().getText();
   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "VerifyParentColumn", "Pass", "ColumnTitleVerified= "+parenetTitle);

   LoginTestCase.nav_Logout();
	  }
	catch (Exception e) {
	// TODO Auto-generated catch block
     	LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
}
}




/*====================================================================================================
Method Name 	    : selectOrgFromUserPermission
Description		: Selecting organization from Select Organization tab from Users permission page
Author 			: QAA03
Creation Date 	: 11/17/2015
Pre-Requisites	:
Revision History:
=====================================================================================================*/

public static void selectOrgFromUserPermission(String sOrgname,String sOrgnametoSelect)
{
	
	WebDriver driver=WebDriverUtil.getDriver();
	PageFactory.initElements(driver, UserPermission);
	
	             WebElement wOrgname;
	         
	        try {
	        	//Entering the organization in the select Org tab in users permission page 
	        	WebObjectUtil.SetValueEdit(UserPermission.getNav_SelectOrgEditBox(),sOrgnametoSelect);
	        	//wOrgname  = WebObjectUtil.GetWebElement("xpath", "//div[contains(@id,'boundlist-')]//li[text()='"+sOrgnametoSelect+"']", "OrganizationName");
	        	wOrgname  = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "UP.USERS.SELECTORG", "PARAMETER_ORGNAME",sOrgnametoSelect);
	        	//if the organization is present in drop down then clicking on it
			       if(wOrgname!= null)
			       {
			    	   wOrgname.click();
			    	   WebObjectUtil.explicitWait(5);
			    	   WebObjectUtil.VerifyTextUnderElement(UserPermission.getNav_Users_EntityColumn(),sOrgname);
			       }
			      
			       else
			       {
			    	   FrameworkUtil.updateCustomResultBasedOnStatus(false, "Organization not found"+sOrgnametoSelect);
			    	   
			       }
			} catch (Exception e) {
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "selectOrgFromUserPermission", "warn", "catch block:" +e.getMessage());
			}
}	      	       


/*==============================================================
Method Name       : editPermissionManageRoles
Description       : Provide or remove permission by clicking on check box on Manage Roles Tab.
Author            : Arularasu
Creation Date     : 11/24/2015
Pre-Requisites    :
Revision History: 
Notes             : To provide access pass bProvidePermission = true and to remove access pass bProvidePermission = false
					'sPermissionNames--If user wants to add/remove more than one permission then give list permission separated by comma
==============================================================*/

public static boolean editPermissionManageRoles(String sPermissionNames,boolean bProvidePermission){
	  	//String sExpSuccMsg,sActSuccMsg;
      WebElement wEditPermissionLabel,wEditPermissionCheckbox;
      String sPermissionNameActual,sPerName,sClassAttribute;
      boolean bFlag = false;
    WebDriver driver = WebDriverUtil.getDriver();
      PageFactory.initElements(driver, UserPermission);
      PageFactory.initElements(driver, CommonPF);
      
    sPerName = sPermissionNames;
    String[] sName = sPermissionNames.split(",");   
    if(WebObjectUtil.verifyElementPresent(UserPermission.getNav_EditRole_ParentWebTable())){
          WebObjectUtil.selectCheckRadioBox(UserPermission.getNav_EditRole_ExpandAllCheckBox());
          WebObjectUtil.explicitWait(3);
          CustomWebElementUtil.loadCustomElement(UserPermission.getNav_EditRole_ParentWebTable(), "table");
          for (int i=0; i<sName.length;i++){
          sPerName = sName[i];
          for (int r=2;r<=CustomWebElementUtil.iRowCount;r++){
                wEditPermissionLabel = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "UP.ROLEMGMT.EDIT.PERMISSIONTREE.CHECKBOX.LABEL", "PARAMETER_ROWNUMBER",r+"");
                sPermissionNameActual = wEditPermissionLabel.getText().trim();
                //System.out.println(sPermissionNameActual);
                if (sPermissionNameActual.equalsIgnoreCase(sPerName)){
                      wEditPermissionCheckbox = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "UP.ROLEMGMT.EDIT.PERMISSIONTREE.CHECKBOX", "PARAMETER_ROWNUMBER",r+"");
                      sClassAttribute = wEditPermissionCheckbox.getAttribute("class");
                      if (bProvidePermission == true ){
                      	if (!sClassAttribute.contains("checkbox-checked")){
                      		wEditPermissionCheckbox.click();
                      		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Provide access", "pass", "Access provided :" + sPermissionNameActual);
                      		bFlag=true;
                      	}else{
                      		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Provide access", "done", "Access already Exist :" + sPermissionNameActual);
                      		bFlag=false;
                      	}
                      }else{
                      	if (sClassAttribute.contains("checkbox-checked")){
                      		wEditPermissionCheckbox.click();
                      		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Remove access", "pass", "Access removed :" + sPermissionNameActual);
                      		bFlag=true;
                      	}else{
                      		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Remove access", "done", "Already do not have access :" + sPermissionNameActual);
                      		bFlag=false;
                      	}
                      }

                      break;
                }
          }
    }
          if (bFlag){
          	WebObjectUtil.explicitWait(3);
                WebObjectUtil.clickElement(UserPermission.getNav_EditRole_SaveBtn());
                //sActSuccMsg=CommonPF.getNav_CommonPopUpMessage().getText();
               //System.out.println(CommonPF.getNav_CommonPopUpMessage().getText());
                WebObjectUtil.clickElement(CommonPF.getNav_CommonPopUpOKButton());
                WebObjectUtil.explicitWait(3);
                FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Edit Permission MangeEntity", "pass", "Permission Edited" + CommonPF.getNav_CommonPopUpMessage().getText());
                return bFlag;
          }else{
                FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Edit Permission MangeEntity", "warn", "There are no change in permission, might be permission already provided/removed");
                WebObjectUtil.clickElement(UserPermission.getNav_nav_EM_Edit_CancelBtn());
                return bFlag;
          }
    }  
 return bFlag;   
}     



/////_______________________ Completed Clark Test Cases _______________________________   //////


//////////////////////////////////////Eilerson TestCases Start////////////////////////////////////////////////////////

/////////********************************Arul Start***********************************///////////	


/*==============================================================
TestScript  	: verifyAccessToPermissionPage
Manual TestCase	: [QAT-61]WCP_3412_TC_1.0_Permissions_admin user is unable to see Users info"
Description		:
Author 			: Arul
Creation Date 	: 11/17/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=201)
public void verifyAccessToPermissionPage()
{
	String sUserName,sPassword,sActPopupMsg;
	int iRowNo;
	boolean bStatus=false;
	WebDriver driver = WebDriverUtil.getDriver();
	//PageFactory.initElements(driver, ManageEntity);
	PageFactory.initElements(driver, CommonPF);
	
	FrameworkUtil.sTestCaseName = "Permission-verifyAccessToPermissionPage";
	FrameworkUtil.sManualTestCaseName= "[QAT-61]WCP_3412_TC_1.0_Permissions_admin user is unable to see Users info";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

	sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ISHANNON.USERID");
	sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ISHANNON.PASSWORD");

	AccessToUserManagement(sUserName, sPassword);

	LoginTestCase.nav_Signout();
	
}
/////////*********************************************Arul End***********************************///////////

/////////*********************************************Sukur Start***********************************///////////

/*==============================================================
TestScript 		: navValidateAddVMandEditVMEditPermissionandRoleChangeBforeAssignedToUser
Manual TestCase	: QAT-54  --  WCP_3424_TC_2.0_ Manage Entity_Edit Custom role_change role permission before assigned to the user
Description		: Validate Add VM and Edit VM not displayed after changing permission and role
Author 			: Sukur Babu. B
Creation Date 	: 11/17/2015
Pre-Requisites	:
Revision History:
==============================================================*/

@Test(priority=202)
public void navValidateAddVMandEditVMEditPermissionandRoleChangeBforeAssignedToUser() {
	String sOrgNameToVerify,sOrgNameToSelect,sUser,sRoleToSelect,sExpSuccMsg,sActSuccMsg,sRoleNameLocator;
	boolean bEditFlag=false;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, UserPermission);
	PageFactory.initElements(driver, EVDC_Overview);
	PageFactory.initElements(driver, EVDC_VMPF);
	try{
		FrameworkUtil.sTestCaseName ="navValidateAddVMandEditVMEditPermissionandRoleChangeBforeAssignedToUser";
		FrameworkUtil.sManualTestCaseName=" QAT-54  --  WCP_3424_TC_2.0_ Manage Entity_Edit Custom role_change role permission before assigned to the user";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		sOrgNameToSelect=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY012953");
		sOrgNameToVerify=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
		sUser=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.ENTITY01.USERID");
		sRoleToSelect=(String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.ROLE3");
		UserPermissionManageEntityTestCase.navigateToManageEntityTab();
		//WebObjectUtil.clickElement(UserPermission.getNav_Mana);
		String sRole=copyRoleManageRoles(sRoleToSelect);
		
		int iRoleIndex = getRoleIndex(sRole);
		sRoleNameLocator = "idRolePanel" + iRoleIndex;
		WebElement wRoleName = WebObjectUtil.GetWebElement("xpath", "//div[@id='"+sRoleNameLocator+"']//div[contains(@id,'-textEl')]", "Role Name");
		WebObjectUtil.clickElement(wRoleName);
		
		String sEditLocator = "//div[@id='idRolePanel" + iRoleIndex + "']//span[text()='Edit']";
		WebElement EditBtn = WebObjectUtil.GetWebElement("xpath", sEditLocator, "Edit Button");
		WebObjectUtil.clickElement(EditBtn);
		editPermissionManageRoles("Add VM,Edit VM",false);
		WebDriverUtil.refreshBrowser();
		WebObjectUtil.clickElement(UserPermission.getNav_UsersTab());
		selectOrgFromUserPermission(sOrgNameToVerify,sOrgNameToSelect);
		
		
		String sSuccessMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.EDITROLE.FEEDBACKMSG") + sUser;
		int iRowNo = WebTableUtil.getRowByCellText(UserPermission.getNav_UserTable(), sUser, 0,1);
		//WebElement row = WebTableUtil.getRowAsWebElement(UserPermission.getNav_UserTable(), iRowNo);
		//WebObjectUtil.clickElement(row);

		String sUserRoleWebListLocator = "//div[@id='userListPanel-body']//table[" + iRowNo + "]/tbody/tr/td[4]/div[contains(@class,'x-grid-cell-inner')]";
		WebElement wUserRoleWebList = WebObjectUtil.GetWebElement("xpath", sUserRoleWebListLocator, "UserRoleWebList");
		String sRoleText=wUserRoleWebList.getText();
		//WebObjectUtil.clickElement(wUserRoleWebList);
		//WebObjectUtil.explicitWait(2);
		//WebObjectUtil.clickElement(UserPermission.getNav_UserRoleDropDownAsEdit());
		
		//Instead of passing "Full Service Admin" passing "sRole" -returned from "copyRoleManageRoles" method-updated QAA03
		//if(!sRoleText.equalsIgnoreCase(sRoleToSelect))
		if(!sRoleText.equalsIgnoreCase(sRole))
		
		//UserPermissionTestCase.setUserPermission(sUser,sRoleToSelect);
			
			setUserPermission(sUser,sRole);
		
		LoginTestCase.nav_Logout();			
		UserPermissionManageEntityTestCase.navLoginUsingEntity01aUser();
		UserPermissionManageEntityTestCase.navVerifyEditAndAddVMNotpresentInVMList();
		LoginTestCase.nav_Logout();	
	}
	catch (Exception e) {
		LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navVerifyEditAndAddVMNotpresentInVMList", "warn", "catch block:Could NOT access webelement" +e.getMessage());	
	}
}
/*==============================================================
TestScript 		: navValidateAddVMandEditVMEditPermissionandRoleChangeAfterAssignedToUser
Manual TestCase	: QAT-23  --  WCP_3424_TC_1.0_Manage Entities_Edit Custom role_change role permission after assigned to the user
Description		: Validate Add VM and Edit VM not displayed after changing permission and role
Author 			: Sukur Babu. B
Creation Date 	: 11/25/2015
Pre-Requisites	:
Revision History:
==============================================================*/

@Test(priority=203)
public void navValidateAddVMandEditVMEditPermissionandRoleChangeAfterAssignedToUser() {
	String sOrgNameToVerify,sOrgNameToSelect,sUser,sRoleToSelect,sExpSuccMsg,sActSuccMsg,sRoleNameLocator;
	boolean bEditFlag=false;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, UserPermission);
	PageFactory.initElements(driver, EVDC_Overview);
	PageFactory.initElements(driver, EVDC_VMPF);
	try{
		FrameworkUtil.sTestCaseName ="navValidateAddVMandEditVMEditPermissionandRoleChangeAfterAssignedToUser";
		FrameworkUtil.sManualTestCaseName=" QAT-23  --  WCP_3424_TC_1.0_Manage Entities_Edit Custom role_change role permission after assigned to the user";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		sOrgNameToSelect=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY012953");
		sOrgNameToVerify=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
		sUser=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.ENTITY01.USERID");
		sRoleToSelect=(String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.ROLE3");
		UserPermissionManageEntityTestCase.navigateToManageEntityTab();
		//WebObjectUtil.clickElement(UserPermission.getNav_Mana);
		String sRole=copyRoleManageRoles(sRoleToSelect);
		WebDriverUtil.refreshBrowser();
		WebObjectUtil.clickElement(UserPermission.getNav_UsersTab());
		selectOrgFromUserPermission(sOrgNameToVerify,sOrgNameToSelect);
		
		String sSuccessMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.EDITROLE.FEEDBACKMSG") + sUser;
		int iRowNo = WebTableUtil.getRowByCellText(UserPermission.getNav_UserTable(), sUser, 0,1);
		WebElement row = WebTableUtil.getRowAsWebElement(UserPermission.getNav_UserTable(), iRowNo);
		WebObjectUtil.clickElement(row);

		String sUserRoleWebListLocator = "//div[@id='userListPanel-body']//table[" + iRowNo + "]/tbody/tr/td[4]/div[contains(@class,'x-grid-cell-inner')]";
		WebElement wUserRoleWebList = WebObjectUtil.GetWebElement("xpath", sUserRoleWebListLocator, "UserRoleWebList");
		String sRoleText=wUserRoleWebList.getText();
		//WebObjectUtil.clickElement(wUserRoleWebList);
		//WebObjectUtil.explicitWait(2);
		//WebObjectUtil.clickElement(UserPermission.getNav_UserRoleDropDownAsEdit());
		
		if(!sRoleText.equalsIgnoreCase(sRole))
				setUserPermission(sUser,sRole);
		
		
		/*int iRoleIndex = UserPermissionTestCase.getRoleIndex(sRole);
		sRoleNameLocator = "idRolePanel" + iRoleIndex;
		WebElement wRoleName = WebObjectUtil.GetWebElement("xpath", "//div[@id='"+sRoleNameLocator+"']//div[contains(@id,'-textEl')]", "Role Name");
		WebObjectUtil.clickElement(wRoleName);
		
		String sEditLocator = "//div[@id='idRolePanel" + iRoleIndex + "']//span[text()='Edit']";
		WebElement EditBtn = WebObjectUtil.GetWebElement("xpath", sEditLocator, "Edit Button");
		WebObjectUtil.clickElement(EditBtn);*/
		WebObjectUtil.clickElement(UserPermission.getNav_ManageRolesTab());
		WebDriverUtil.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		int iRoleIndex = getRoleIndex(sRole);
		sRoleNameLocator = "idRolePanel" + iRoleIndex;
		WebElement wRoleName = WebObjectUtil.GetWebElement("xpath", "//div[@id='"+sRoleNameLocator+"']//div[contains(@id,'-textEl')]", "Role Name");
		WebObjectUtil.clickElement(wRoleName);
		
		String sEditLocator = "//div[@id='idRolePanel" + iRoleIndex + "']//span[text()='Edit']";
		WebElement EditBtn = WebObjectUtil.GetWebElement("xpath", sEditLocator, "Edit Button");
		WebObjectUtil.clickElement(EditBtn);
		editPermissionManageRoles("Add VM,Edit VM",false);
		
		
		LoginTestCase.nav_Logout();			
		UserPermissionManageEntityTestCase.navLoginUsingEntity01aUser();
		UserPermissionManageEntityTestCase.navVerifyEditAndAddVMNotpresentInVMList();
		LoginTestCase.nav_Logout();	
	}
	catch (Exception e) {
		LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navVerifyEditAndAddVMNotpresentInVMList", "warn", "catch block:Could NOT access webelement" +e.getMessage());	
	}
}
/////////*********************************************Sukur End***********************************///////////

/////////*********************************************QAA04 Start***********************************///////////

/*==============================================================
TestScript 		: nav_VerifyRoleForRramAndRramdevUsers
Manual TestCase	: CPPOC-3425/QAT-56
Description		: Verify role for rram and rramdav users with different Org
Author 			: QAA04
Creation Date 	: 09/03/2015
Pre-Requisites	:
Revision History:
============================================================== */

@Test(priority=204)
public void navVerifyRole() {
	String sRramRoleTitle,sTstDevTile,sRamdevRoleTitle;
	WebDriver driver= WebDriverUtil.getDriver();
	//PageFactory.initElements(driver, ManageEntity);
	PageFactory.initElements(driver, UserPermission);
	try {
		

	FrameworkUtil.sTestCaseName ="navVerifyRole";
	FrameworkUtil.sManualTestCaseName ="(QAT-56)Verify role for rram and rramdav users with diffarent Org";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	
	String sUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEA.USERID");
	String sPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEA.PASSWORD");
	
	UserPermissionTestCase.AccessToUserManagement(sUserName, sPassword);
	
	//LoginTestCase.nav_Login(sUserName, sPassword);
 
   WebObjectUtil.clickElement(UserPermission.getNav_AccountTab());
   WebObjectUtil.clickElement(UserPermission.getNav_PermissionsLink());
   WebObjectUtil.explicitWait(5);
   
   
     WebObjectUtil.isElementPresent(UserPermission.getNav_RramUserTitle());
	 sRramRoleTitle =  UserPermission.getNav_RoleTitleForRramUser().getText();
	 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verify Role For rram user", "Pass", "Role is assigned for rram user = "+sRramRoleTitle);  
	 WebObjectUtil.explicitWait(10);
	 
    sTstDevTile= (String) FrameworkUtil.dictPropertyData.get("NAV.USER.PERMISSIONS.ORG.NAME");
	WebObjectUtil.SetValueEdit(UserPermission.getNav_SelectOrgEditBox(),sTstDevTile );
//	WebObjectUtil.explicitWait(3);
	WebObjectUtil.clickElement(UserPermission.getNav_TstDevcoTitle());
   // WebObjectUtil.explicitWait(5);
	WebObjectUtil.isElementPresent(UserPermission.getNav_RramdevUserTitle());
	
	sRamdevRoleTitle = UserPermission.getNav_RoleTitleForRramdevUser().getText();
	 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verify Role For rramdev user", "Pass", "Role is assigned for rramdev user = "+sRamdevRoleTitle);  
	
	///// log out
		
		LoginTestCase.nav_Logout();
	
	
	}
	catch (Exception e) {
		LoggerUtil.log_type_error("Issue with - Verifing role for rram and rramdav users");
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		LoggerUtil.log_type_error(e.getMessage());
	}

}
/////////*********************************************QAA04 End***********************************///////////
//////////////////////////////////////Eilerson TestCases End////////////////////////////////////////////////////////

//update each @test result in custom result file
		@AfterMethod
		public static void afterEachMethod(){
			FrameworkUtil.updateTestCaseStatusinResult();
			FrameworkUtil.sTestExecutionStatus = true;
			
		}
	

}






