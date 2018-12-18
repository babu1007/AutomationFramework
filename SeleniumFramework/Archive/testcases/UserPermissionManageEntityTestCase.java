package com.whs.navigator.testcases;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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
import com.whs.navigator.pagefactory.CommonPageFactory;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.EVDC_VM_AdvancedActions_PageFactory;
import com.whs.navigator.pagefactory.EVDC_VM_PageFactory;
import com.whs.navigator.pagefactory.UserPermissionManageEntityPageFactory;
import com.whs.navigator.pagefactory.TicketPageFactory;
import com.whs.navigator.pagefactory.UserPermissionMultiOrgPageFactory;
import com.whs.navigator.pagefactory.UserPermissionPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory;
public class UserPermissionManageEntityTestCase {
	
	//public static UserPermissionManageEntityPageFactory Eilerson = new UserPermissionManageEntityPageFactory();
	public static UserPermissionPageFactory UserPermission = new UserPermissionPageFactory();
	public static EVDC_OverviewPageFactory EVDC_OverviewPF=new EVDC_OverviewPageFactory();
	public static EVDC_VM_PageFactory EVDC_VMPF=new EVDC_VM_PageFactory();
	public static EVDC_VM_AdvancedActions_PageFactory EVDCVMADV_PF=new EVDC_VM_AdvancedActions_PageFactory();
	public static TicketPageFactory Ticket = new TicketPageFactory();
	static CommonPageFactory CommonPF = new CommonPageFactory();
	public static UserPermissionManageEntityPageFactory  ManageEntity =  new UserPermissionManageEntityPageFactory();
	public static CommonPageFactory Common = new CommonPageFactory();
	public static UserPermissionMultiOrgPageFactory UP_MultiOrg= new UserPermissionMultiOrgPageFactory();
	public static HomePageFactory Home = new HomePageFactory();
	
/////////********************************Arul Start***********************************///////////
	
	/*==============================================================
	TestScript  	: verifyColorManageEntityTable
	Manual TestCase	: [QAT-35]WCP_3381_TC_1.0_Manage Entities: Color pattern for entity names
	Description		:
	Author 			: Arul
	Creation Date 	: 11/17/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=1)
	public void verifyColorManageEntityTable()
	{
		String sUserName,sPassword;
		int iRowNo;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, ManageEntity);
		
		
		FrameworkUtil.sTestCaseName = "Permission-verifyColorManageEntityTable";
		FrameworkUtil.sManualTestCaseName= "[QAT-35]WCP_3381_TC_1.0_Manage Entities: Color pattern for entity names";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.USERID");
		sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.PASSWORD");
	
		UserPermissionTestCase.AccessToUserManagement(sUserName, sPassword);
		WebObjectUtil.clickElement(ManageEntity.getNav_Users_ManageEntityTab());
	
		verifyColorEachRowTable(ManageEntity.getNav_ManageEntityParentWebTable(),"x-grid-item-alt",false);

		iRowNo = clickonEditCopyIconManageEntity( "TST Entity01", "TST Entity02","edit");
		WebObjectUtil.clickElement(ManageEntity.getNav_ManageEntity_CancelBtn());
		verifyColorEachRowTable(ManageEntity.getNav_ManageEntityParentWebTable(),"x-grid-item-alt",false);
		
		LoginTestCase.nav_Logout();
		
	}
	


/*==============================================================
TestScript  	: verifyMsgwithNoModificationPermission
Manual TestCase	: [QAT-20]WCP_3389_TC_1.0_Manage Entities_Edit Successfully msg should not be displayed if no changes were made to Permissions
Description		:
Author 			: Arul
Creation Date 	: 11/17/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=2)
public void verifyMsgwithNoModificationPermission()
{
	String sUserName,sPassword,sActPopupMsg;
	int iRowNo;
	boolean bStatus=false;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, ManageEntity);
	PageFactory.initElements(driver, CommonPF);
	
	FrameworkUtil.sTestCaseName = "Permission-verifyMsgwithNoModificationPermission";
	FrameworkUtil.sManualTestCaseName= "[QAT-20]WCP_3389_TC_1.0_Manage Entities_Edit Successfully msg should not be displayed if no changes were made to Permissions";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

	sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.USERID");
	sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.PASSWORD");

	UserPermissionTestCase.AccessToUserManagement(sUserName, sPassword);
	WebObjectUtil.clickElement(ManageEntity.getNav_Users_ManageEntityTab());
	iRowNo = clickonEditCopyIconManageEntity( "TST Entity01", "TST Entity02","edit");
	WebObjectUtil.clickElement(ManageEntity.getNav_ManageEntityEdit_SaveBtn());
	WebObjectUtil.verifyElementPresent(CommonPF.getNav_CommonPopUp());
	sActPopupMsg = CommonPF.getNav_CommonPopUpMessage().getText();
	bStatus=sActPopupMsg.contains("Please modify at least one permission before saving");
	FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, sActPopupMsg);
	WebObjectUtil.clickElement(CommonPF.getNav_CommonPopUpOKButton());
	WebObjectUtil.clickElement(ManageEntity.getNav_ManageEntity_CancelBtn());
	LoginTestCase.nav_Logout();
	
}

/*==============================================================
TestScript  		: verifyEntityHasFullPermission
Manual TestCase		: WCP_Permissions_TC_Default Permissions
Description			:
Module/Release Name	: Eilerson
Author 				: Arularasu
Creation Date 		: 11/24/2015
Pre-Requisites		:
Revision History	:
==============================================================*/
@Test(priority=3)
public void verifyEntityHasFullPermission()
{
	String sUserName,sPassword;
	String[][] arrPermissionwithStatus = null;
	int iRowNo;
	boolean bHasPermission=false;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, ManageEntity);
	
	
	FrameworkUtil.sTestCaseName = "verifyEntityHasFullPermission";
	FrameworkUtil.sManualTestCaseName= "[QAT-57]WCP_Permissions_TC_Default Permissions";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

	sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.USERID");
	sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.PASSWORD");

	UserPermissionTestCase.AccessToUserManagement(sUserName, sPassword);
	WebObjectUtil.clickElement(ManageEntity.getNav_Users_ManageEntityTab());
	//UserPermissionManageEntityTestCase.clickonEditCopyIconManageEntity("TST Entity01", "TST Entity02", "edit");
	setFullPermissionManageEntity("TST Entity01", null,true);
	arrPermissionwithStatus = gettingPermissionLabelChkBoxStatus("TST Entity01",null);
	
	bHasPermission=arrPermissionwithStatus.toString().contains("false");
	FrameworkUtil.updateCustomResultBasedOnStatus(!bHasPermission, "Entity has full permission");
	
	LoginTestCase.nav_Logout();

}

	/*==============================================================
	TestScript  	: verifyColorManageEntityTable
	Manual TestCase	: [QAT-35]WCP_3381_TC_1.0_Manage Entities: Color pattern for entity names
	Description		:
	Author 			: Arul
	Creation Date 	: 11/17/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	//@Test(priority=4)
	public void verifyLoginLogoutSession()
	{
		String sUserName,sPassword;
		int iRowNo;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, ManageEntity);
		
		
		FrameworkUtil.sTestCaseName = "Permission-verifyColorManageEntityTable";
		FrameworkUtil.sManualTestCaseName= "[QAT-35]WCP_3381_TC_1.0_Manage Entities: Color pattern for entity names";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.USERID");
		sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.PASSWORD");
	
		
		LoginTestCase.nav_Login(sUserName, sPassword);
		
		LoginTestCase.nav_Logout();
		
		LoginTestCase.nav_Login(sUserName, sPassword);
		
		LoginTestCase.nav_Logout();
		
	}
	
/////////********************************Arul End***********************************///////////	
	
/////////********************************Vivek Start***********************************///////////	
	
	/*==============================================================
	TestScript 		: navValidatePermissionCopyandItsChild
	Manual TestCase	:QAT-66 WCP_3177_TC_1.0_Permissions_Copy Permissions to another entity
					 QAT-36 WCP_3177_TC_1.1_Permissions_Copy Permissions to another entity_Cascade to children
					 QAT-17 WCP_3383_TC_1.0_Manage Entities_Cascade to children' check box should be place next to Submit and Cancel buttons in the Copy page
	Description		: Permissions are copied properly from the source entity
	Author 			: Vivek Kumar
	Creation Date 	: 11/16/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	@Test(priority=11)
	public static void navValidatePermissionCopyandItsChild()
	{
		
		String sUserName,sPassword;
		String sEntity,sDestination,sChild1,sChild2,sChild3;
		
		/*
		sEntity="A Drinking Drinkers";
		sDestination="TST Entity01";
		sChild1="TST Entity02";
		sChild2="TST Entity03";
		sChild3="TST Entity04";*/
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, ManageEntity);
		PageFactory.initElements(driver, UserPermission);
		
		
			try {
				FrameworkUtil.sTestCaseName ="navValidatePermissionCopyandItsChild";
				FrameworkUtil.sManualTestCaseName="QAT-66,QAT36,QAT-17-WCP_3177_TC_1.0_Permissions_Copy Permissions to another entity";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
				
				sUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.USERID");
				sPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.PASSWORD");
				
				sDestination=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
				sEntity=(String)FrameworkUtil.dictPropertyData.get("NAV.UP.MANAGEENTITY.SOURCE.ENTITY");
				sChild1=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY02");
				sChild2=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY03");
				sChild3=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY04");
				
				
				//Login using Role-A
				//LoginTestCase.nav_Login(sUserName, sPassword);
				UserPermissionTestCase.AccessToUserManagement(sUserName, sPassword);
				
				//Clicking on "Manage Entity Tab"
				WebObjectUtil.clickAndVerifyElement(UserPermission.getNav_ManageEntityTab(), UserPermission.getNav_ManageEntityNameHeader());
				//Returning array value in aPermissionLstwithChkBox
				String[][] aPermissionLstwithChkBox=gettingPermissionLabelChkBoxStatus(sEntity,null);
				
				//Clicking on Copy link and selecting sEntity as dest and click on submit.
				//Verifying the confirm popup message and userfeedback message
				valManageEntityCopyFunction(sEntity,sDestination,true);
				//Cross verifying the destination entity labels and chkbox status with Src Entity
				valDestPermissionLstandChkBox(aPermissionLstwithChkBox,sDestination,null);
				valDestPermissionLstandChkBox(aPermissionLstwithChkBox,sDestination,sChild1);
				valDestPermissionLstandChkBox(aPermissionLstwithChkBox,sChild1,sChild2);
				valDestPermissionLstandChkBox(aPermissionLstwithChkBox,sChild2,sChild3);
				
				//Logout
				LoginTestCase.nav_Logout();
			} catch (Exception e) {
				LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
			}
	}
	
	
	
	/*==============================================================
	TestScript 		: valEditPermissionAfterLogin
	Manual TestCase	: QAT-65-WCP_3177_TC_1.2_Permissions_Copy Permissions to another entity_Login & Verify
	Description		: Uncheck AddVM and Edit VM and Copied to Entity01 and Verify the same and also @EVDC-VM Page.
	Author 			: Vivek Kumar
	Creation Date 	: 11/20/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=12)
	public static void valEditPermissionAfterLogin()
	{
		String sUserName,sPassword,sDestinationEntity,sSourceEntity,sEntityUserName,sEntityPassword;
		boolean bBtnStatus;
		int iRowNo;
		WebElement wEdit;
		

		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, ManageEntity);
		PageFactory.initElements(driver, UserPermission);
		PageFactory.initElements(driver,EVDC_VMPF);
		PageFactory.initElements(driver,EVDC_OverviewPF);
			
		FrameworkUtil.sTestCaseName ="valEditPermissionAfterLogin";
		FrameworkUtil.sManualTestCaseName="QAT-65-WCP_3177_TC_1.2_Permissions_Copy Permissions to another entity_Login & Verify";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		sUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.USERID");
		sPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.PASSWORD");
		
		sEntityUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.ENTITY.USERNAME");
		sEntityPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.ENTITY.PASSWORD");
		
		sSourceEntity=(String)FrameworkUtil.dictPropertyData.get("NAV.UP.MANAGEENTITY.SOURCE.ENTITY");
		sDestinationEntity=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
		
		
		
		try {
			//Login using Role-A
			//LoginTestCase.nav_Login(sUserName, sPassword);
			UserPermissionTestCase.AccessToUserManagement(sUserName, sPassword);
			
			//Clicking on "Manage Entity Tab"
			WebObjectUtil.clickAndVerifyElement(UserPermission.getNav_ManageEntityTab(), UserPermission.getNav_ManageEntityNameHeader());
			//Clicking on Edit pencil link
			clickonEditCopyIconManageEntity(sSourceEntity, null, "edit");
			
			//Unchecking the Permission - Edit VM and Add VM
			editPermissionManageEntity("Add VM,Edit VM", false, false);
			
			//Clicking on Edit and get the Permission level and CheckBox status
			//Returning array value in aPermissionLstwithChkBox
			String[][] aPermissionLstwithChkBox=gettingPermissionLabelChkBoxStatus(sSourceEntity,null);
			
			//Clicking on Copy link and selecting sEntity as dest and click on submit.
			//Verifying the confirm popup message and userfeedback message
			valManageEntityCopyFunction(sSourceEntity,sDestinationEntity,true);
			//Cross verifying the destination entity labels and chkbox status with Src Entity
			valDestPermissionLstandChkBox(aPermissionLstwithChkBox,sDestinationEntity,null);
			//Logout
			LoginTestCase.nav_Logout();
			
			//Login using entity01a
			LoginTestCase.nav_Login(sEntityUserName, sEntityPassword);
			
			//Navigate to EVDC-VM Page
			//Clicking on EVDC Name and validating its landing page
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			
			//Verifying "Add VM" link should not be there
			WebObjectUtil.verifyElementNOTPresent(EVDC_VMPF.getNav_AddVMLink());
			
			iRowNo = EVDC_VM_AdvancedActions.getRow_EVDC_VMTable(EVDC_VMPF.getNav_VMWebTableParent(),"Stopped","");
			//System.out.println("VM name: " + sVMName + "--" + iRowNo);
			//WebTableUtil.printEachCellText(EVDC.getNav_VMWebTable());
			if (iRowNo > 0 ){
				EVDC_VM_AdvancedActions.expandVMbyRowNum(iRowNo);
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VM Number at EVDC VM page", "fail", "VM number :" + iRowNo);
			}
			
			//Verifying "Edit VM" should not be there
			wEdit=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+ iRowNo+"]/td/table/tbody/tr[2]//a[contains(text(),'Edit')]","Edit Button");
			bBtnStatus=(wEdit==null);
			FrameworkUtil.updateCustomResultBasedOnStatus(bBtnStatus, "User "+ sEntityUserName +" unable to view Edit button");
			//Logging out from Navigator application
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}

	}
	
	
	/*==============================================================
	TestScript 		: valCascadeEditPermissionAfterLogin
	Manual TestCase	: QAT-39-WCP_3177_TC_1.3_Permissions_Copy Permissions to another entity_Cascade to children_Login and verify
	Description		: Uncheck view Tickets and check casacde ,Copied to Entity01 and Verify the same and also @Ticket Page.
	Author 			: Vivek Kumar
	Creation Date 	: 11/23/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=13)
	public static void valCascadeEditPermissionAfterLogin()
	{

		String sUserName,sPassword,sSourceEntity,sDestination,sChild1,sChild2,sChild3;
		String sEntityPassword,sEntity01UserName,sEntity02UserName,sEntity03UserName;
		
		
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, ManageEntity);
		PageFactory.initElements(driver, UserPermission);
		PageFactory.initElements(driver,EVDC_VMPF);
		PageFactory.initElements(driver,EVDC_OverviewPF);
		PageFactory.initElements(driver,Ticket);
			
		FrameworkUtil.sTestCaseName ="valCascadeEditPermissionAfterLogin";
		FrameworkUtil.sManualTestCaseName="QAT-39-WCP_3177_TC_1.3_Permissions_Copy Permissions to another entity_Cascade to children_Login and verify";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		sUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.USERID");
		sPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.PASSWORD");
		sDestination=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
		sSourceEntity=(String)FrameworkUtil.dictPropertyData.get("NAV.UP.MANAGEENTITY.SOURCE.5RIVERSYSTEM");
		sChild1=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY02");
		sChild2=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY03");
		sChild3=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY04");
		
		sEntity01UserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.ENTITY01.USERID");
		sEntity02UserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.ENTITY02.USERID");
		sEntity03UserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.ENTITY03.USERID");
		sEntityPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.ENTITY.PASSWORD");
		
		
		
		try {
			//Login using Role-A
			//LoginTestCase.nav_Login(sUserName, sPassword);
			UserPermissionTestCase.AccessToUserManagement(sUserName, sPassword);
			
			//Clicking on "Manage Entity Tab"
			WebObjectUtil.clickAndVerifyElement(UserPermission.getNav_ManageEntityTab(), UserPermission.getNav_ManageEntityNameHeader());
			//Clicking on Edit pencil link
			clickonEditCopyIconManageEntity(sSourceEntity, null, "edit");
			
			//Unchecking the Permission - View tickets
			editPermissionManageEntity("View tickets", false, false);
			
			//Clicking on Edit and get the Permission level and CheckBox status
			//Returning array value in aPermissionLstwithChkBox
			String[][] aPermissionLstwithChkBox=gettingPermissionLabelChkBoxStatus(sSourceEntity,null);
			
			//Clicking on Copy link and selecting sEntity as dest and click on submit.
			//Verifying the confirm popup message and userfeedback message
			valManageEntityCopyFunction(sSourceEntity,sDestination,true);
			//Cross verifying the destination entity labels and chkbox status with Src Entity
			valDestPermissionLstandChkBox(aPermissionLstwithChkBox,sDestination,null);
			valDestPermissionLstandChkBox(aPermissionLstwithChkBox,sDestination,sChild1);
			valDestPermissionLstandChkBox(aPermissionLstwithChkBox,sChild1,sChild2);
			valDestPermissionLstandChkBox(aPermissionLstwithChkBox,sChild2,sChild3);
			
			//Logout
			LoginTestCase.nav_Logout();
			//Login using entity01a and Verify that he cannot see ticket page
			TicketTestCase.ValUserNotViewTicketPage(sEntity01UserName,sEntityPassword);
			
			
			//Login using entity02a and Verify that he cannot see ticket page
			TicketTestCase.ValUserNotViewTicketPage(sEntity02UserName,sEntityPassword);
			
			
			//Login using entity01a and Verify that he cannot see ticket page
			TicketTestCase.ValUserNotViewTicketPage(sEntity03UserName,sEntityPassword);
		} catch (Exception e) {
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		
	}
	
	
	/*==============================================================
	TestScript 		: valCopyPermissionRepublish
	Manual TestCase	: QAT-46-WCP_3177_TC_1.0_Manage Entities_Copy Permissions_Republish first then change user role
	Description		: Manage Entities_Copy Permissions_Republish first then change user role
	Author 			: Vivek Kumar
	Creation Date 	: 11/23/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=14)
	public static void valCopyPermissionRepublish()
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, UserPermission);
		PageFactory.initElements(driver,EVDC_VMPF);
		PageFactory.initElements(driver,EVDC_OverviewPF);
		
		String sUserName,sPassword,sSourceEntity,sDestinationEntity,sEntityPassword,sEntityUserName;
		int iRowNo;
		WebElement wEdit;
		boolean bBtnStatus=false;
		
		
		FrameworkUtil.sTestCaseName ="valCopyPermissionRepublish";
		FrameworkUtil.sManualTestCaseName="QAT-46-WCP_3177_TC_1.0_Manage Entities_Copy Permissions_Republish first then change user role";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		
		
		sUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.USERID");
		sPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.PASSWORD");
		sEntityUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.ENTITY02.USERID");
		sEntityPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.ENTITY.PASSWORD");
		
		sSourceEntity=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
		sDestinationEntity=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY02");
		
		try {
			//Login using Role-A
			//LoginTestCase.nav_Login(sUserName, sPassword);
			UserPermissionTestCase.AccessToUserManagement(sUserName, sPassword);
			
			//Clicking on "Manage Entity Tab"
			WebObjectUtil.clickAndVerifyElement(UserPermission.getNav_ManageEntityTab(), UserPermission.getNav_ManageEntityNameHeader());
			//Clicking on Edit pencil link
			clickonEditCopyIconManageEntity(sSourceEntity, null, "edit");
			
			//Unchecking the Permission - Edit VM and Add VM
			editPermissionManageEntity("Add VM,Edit VM", false, false);
			//Clicking on copy and selecting destination as tst Entity02
			valManageEntityCopyFunction(sSourceEntity,sDestinationEntity,false);
			
			//Navigation to User Tab
			WebObjectUtil.clickAndVerifyElement(UserPermission.getNav_UsersTab(), UserPermission.getNav_PermissionUserAddUserLink());
			//Selecting org from "Select organization" dropdown
			UserPermissionTestCase.selectOrgFromUserPermission(sDestinationEntity, "TST Entity02_2954");
			//Setting the role for Entity02A
			UserPermissionTestCase.setUserPermission("entity02a", "Full Service Admin");
			
			//Logout
			LoginTestCase.nav_Logout();
			//#######################
			//#######################
			//Login using entity02a
			LoginTestCase.nav_Login(sEntityUserName, sEntityPassword);
			
			//Navigate to EVDC-VM Page
			//Clicking on EVDC Name and validating its landing page
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			
			//Verifying "Add VM" link should not be there
			WebObjectUtil.verifyElementNOTPresent(EVDC_VMPF.getNav_AddVMLink());
			
			iRowNo = EVDC_VM_AdvancedActions.getRow_EVDC_VMTable(EVDC_VMPF.getNav_VMWebTableParent(),"Stopped","");
			//System.out.println("VM name: " + sVMName + "--" + iRowNo);
			//WebTableUtil.printEachCellText(EVDC.getNav_VMWebTable());
			if (iRowNo > 0 ){
				EVDC_VM_AdvancedActions.expandVMbyRowNum(iRowNo);
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VM Number at EVDC VM page", "fail", "VM number :" + iRowNo);
			}
			
			//Verifying "Edit VM" should not be there
			wEdit=WebObjectUtil.GetWebElement("xpath", "//table["+iRowNo+"]//a[contains(text(),'Edit')]","Edit Button");
			bBtnStatus=(wEdit==null);
			FrameworkUtil.updateCustomResultBasedOnStatus(bBtnStatus, "User "+ sEntityUserName +" unable to view Edit button");
			//Logging out from Navigator application
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		
	}	
	
	
/////////********************************Vivek End***********************************/////////////////
	
/////////********************************Sukur Start***********************************/////////////////
	
	/*==============================================================
	TestScript 		: navValidateEdtdescendantpermFunctionality
	Manual TestCase	: QAT-45  --  WCP_1346_TC_1.0_Permissions_Edit descendant permissions
	Description		: Validate Edit descendant permissions functionality 
	Author 			: Sukur Babu. B
	Creation Date 	: 11/16/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	@Test(priority=21)
	public void navValidateEdtdescendantpermFunctionality() {
		String sOrgName1,sOrgName2;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, ManageEntity);
		PageFactory.initElements(driver, UserPermission);
		PageFactory.initElements(driver, EVDC_OverviewPF);
		PageFactory.initElements(driver, EVDC_VMPF);
		PageFactory.initElements(driver, EVDCVMADV_PF);
		try{
			String sExpSuccMsg,sActSuccMsg;
			boolean bEditFlag;
			FrameworkUtil.sTestCaseName ="navValidateEdtdescendantpermFunctionality";
			FrameworkUtil.sManualTestCaseName="QAT-45  -  WCP_1346_TC_1.0_Permissions_Edit descendant permissions";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			sOrgName1=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
			sOrgName2=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY02");
			navigateToManageEntityTab();
			
			
			//Click on TST Entity02 Edit icon
			clickonEditCopyIconManageEntity(sOrgName1, sOrgName2,"edit");
			bEditFlag=editPermissionManageEntity("Add VM,Edit VM",false,false);
			sExpSuccMsg="Entity " +sOrgName2 +" edited successfully";
			if(bEditFlag){
			sActSuccMsg=UserPermission.getNav_FeedBackArea().getText();
			if(sActSuccMsg.contains(sExpSuccMsg))
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element message verified", "pass",sExpSuccMsg +" is matching with actual message");
			else
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element message verified", "fail",sExpSuccMsg +" is not matching with actual message");
			}
			LoginTestCase.nav_Logout();			
			navLoginUsingEntity02aUser();
			navVerifyEditAndAddVMNotpresentInVMList();
			
			LoginTestCase.nav_Logout();
	
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
	         	LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
	}
	/*==============================================================
	TestScript 		: navValidateEdtdescendantpermCascadeFunctionality
	Manual TestCase	: WCP_1346_TC_1.1_Permissions_Edit descendant permissions_cascade to children
	Description		: Validate Edit descendant permissions after checking cascade to childeren functionality 
	Author 			: Sukur Babu. B
	Creation Date 	: 11/17/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	@Test(priority=22)
	public void navValidateEdtdescendantpermCascadeFunctionality() {
		String sOrgName,sExpSuccMsg,sActSuccMsg;
		boolean bEditFlag=false;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, ManageEntity);
		PageFactory.initElements(driver, UserPermission);
		PageFactory.initElements(driver, EVDC_OverviewPF);
		PageFactory.initElements(driver, EVDC_VMPF);
		try{
			FrameworkUtil.sTestCaseName ="navValidateEdtdescendantpermCascadeFunctionality";
			FrameworkUtil.sManualTestCaseName="QAT-50  -  WCP_1346_TC_1.1_Permissions_Edit descendant permissions_cascade to children";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
			navigateToManageEntityTab();
			
			
			//Click on TST Entity02 Edit icon
			clickonEditCopyIconManageEntity(sOrgName, null,"edit");
			editPermissionManageEntity("Add VM,Edit VM",false,true);
			sExpSuccMsg="Entity " +sOrgName +" edited successfully";
			if(bEditFlag){
				sActSuccMsg=UserPermission.getNav_FeedBackArea().getText();
				if(sActSuccMsg.contains(sExpSuccMsg))
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element message verified", "pass",sExpSuccMsg +" is matching with actual message");
				else
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element message verified", "fail",sExpSuccMsg +" is not matching with actual message");
				}
			LoginTestCase.nav_Logout();			
			navLoginUsingEntity01aUser();
			navVerifyEditAndAddVMNotpresentInVMList();
			///// log out
			
			LoginTestCase.nav_Logout();
			
			navLoginUsingEntity02aUser();
			navVerifyEditAndAddVMNotpresentInVMList();
			
			
			LoginTestCase.nav_Logout();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
	         	LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
	}
	/*==============================================================
	TestScript 		: navValidatepermFunctionalityForTickets
	Manual TestCase	: QAT-58  --  WCP_3382_TC_1.0_Manage Entity_user is able to edit tickets after permissions are removed
	Description		: Validate Edit descendant permissions functionality 
	Author 			: Sukur Babu. B
	Creation Date 	: 11/17/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	@Test(priority=23)
	public void navValidatepermFunctionalityForTickets() {
		String sOrgName,sExpSuccMsg,sActSuccMsg;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, ManageEntity);
		PageFactory.initElements(driver, UserPermission);
		PageFactory.initElements(driver, EVDC_OverviewPF);
		PageFactory.initElements(driver, EVDC_VMPF);
		PageFactory.initElements(driver, Ticket);
		try{
			boolean bEditFlag=false;
			FrameworkUtil.sTestCaseName ="navValidatepermFunctionalityForTickets";
			FrameworkUtil.sManualTestCaseName="QAT-58  --  WCP_3382_TC_1.0_Manage Entity_user is able to edit tickets after permissions are removed";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
			navigateToManageEntityTab();
			
			
			//Click on TST Entity01 Edit icon
			clickonEditCopyIconManageEntity(sOrgName, null,"edit");
			editPermissionManageEntity("Create Tickets,Edit tickets/Add Attachments",false,false);
			sExpSuccMsg="Entity " +sOrgName +" edited successfully";
			if(bEditFlag){
				sActSuccMsg=UserPermission.getNav_FeedBackArea().getText();
				if(sActSuccMsg.contains(sExpSuccMsg))
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element message verified", "pass",sExpSuccMsg +" is matching with actual message");
				else
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element message verified", "fail",sExpSuccMsg +" is not matching with actual message");
				}
			LoginTestCase.nav_Logout();	
			
			navLoginUsingEntity01aUser();
			//TicketTestCase.navigateToTicketPage();
			WebObjectUtil.ClickAndMouseHover(Ticket.getNav_SupportTabLink());
			WebObjectUtil.clickElement(Ticket.getNav_TicketsMenuLink());
			//TicketTestCase.getTicketID(1);
			WebObjectUtil.explicitWait(5);
			//WebObjectUtil.verifyElementNOTPresent(UserPermission.getNav_CreateTicketLink());
			WebObjectUtil.verifyElementNOTPresent(Ticket.getNav_CreateTicketLink());
			TicketTestCase.expandTable(1);
			
			WebObjectUtil.verifyElementNOTPresent(Ticket.getNav_TicketSaveUpdatesBtn());
			LoginTestCase.nav_Logout();	
		}
			catch (Exception e) {
				// TODO Auto-generated catch block
		         	LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
			}
		}
	/*==============================================================
	TestScript 		: navVerifyManageEntPDFandCSVicons
	Manual TestCase	: QAT-28  --  WCP_3143_TC_1.0_Manage Entitites_verify PDF and CSV Icons
	Description		: Validate Edit descendant permissions functionality 
	Author 			: Sukur Babu. B
	Creation Date 	: 11/17/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	@Test(priority=24)
	public void navVerifyManageEntPDFandCSVicons() {
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, ManageEntity);
		PageFactory.initElements(driver, UserPermission);
		
		try{
			FrameworkUtil.sTestCaseName ="navVerifyManageEntPDFandCSVicons";
			FrameworkUtil.sManualTestCaseName="QAT-28  --  WCP_3143_TC_1.0_Manage Entitites_verify PDF and CSV Icons";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			navigateToManageEntityTab();
			
			WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityCSVIconImg());
			WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityPDFIconImg());
			
			LoginTestCase.nav_Logout();	
		}
			catch (Exception e) {
				// TODO Auto-generated catch block
		         	LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
			}
		}
	/*==============================================================
	TestScript 		: navValidateAddVMandEditVMAfterEditPermissionandRoleChangeForTSTEntity01_2953
	Manual TestCase	: QAT-52  --  WCP_3424_TC_3.0_Manage Entities_Respect Roles_Republish first then change user role
	Description		: Validate Add VM and Edit VM not displayed after changing permission and role
	Author 			: Sukur Babu. B
	Creation Date 	: 11/17/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	@Test(priority=25)
	public void navValidateAddVMandEditVMAfterEditPermissionandRoleChangeForTSTEntity01_2953() {
		String sOrgNameToVerify,sOrgNameToSelect,sUser,sRoleToSelect,sExpSuccMsg,sActSuccMsg;
		boolean bEditFlag=false;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, ManageEntity);
		PageFactory.initElements(driver, UserPermission);
		PageFactory.initElements(driver, EVDC_OverviewPF);
		PageFactory.initElements(driver, EVDC_VMPF);
		try{
			FrameworkUtil.sTestCaseName ="navValidateAddVMandEditVMAfterEditPermissionandRoleChangeForTSTEntity01_2953";
			FrameworkUtil.sManualTestCaseName=" QAT-52  --  WCP_3424_TC_3.0_Manage Entities_Respect Roles_Republish first then change user role";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			sOrgNameToSelect=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY012953");
			sOrgNameToVerify=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
			sUser=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.ENTITY01.USERID");
			sRoleToSelect=(String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.ROLE3");
			navigateToManageEntityTab();
			
			
			//Click on TST Entity02 Edit icon
			clickonEditCopyIconManageEntity(sOrgNameToVerify, null,"edit");
			editPermissionManageEntity("Add VM,Edit VM",false,false);
			sExpSuccMsg="Entity " +sOrgNameToSelect +" edited successfully";
			
			if(bEditFlag){
				sActSuccMsg=UserPermission.getNav_FeedBackArea().getText();
				if(sActSuccMsg.contains(sExpSuccMsg))
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element message verified", "pass",sExpSuccMsg +" is matching with actual message");
				else
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element message verified", "fail",sExpSuccMsg +" is not matching with actual message");
				}
			WebObjectUtil.clickElement(UserPermission.getNav_UsersTab());
			UserPermissionTestCase.selectOrgFromUserPermission(sOrgNameToVerify,sOrgNameToSelect);
			
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
			
			if(!sRoleText.equalsIgnoreCase(sRoleToSelect))
				UserPermissionTestCase.setUserPermission(sUser,sRoleToSelect);
			
			LoginTestCase.nav_Logout();			
			navLoginUsingEntity01aUser();
			navVerifyEditAndAddVMNotpresentInVMList();
			///// log out
			
			LoginTestCase.nav_Logout();
	
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
	         	LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
	}
	
	/*==============================================================
	TestScript 		: navValidateDeleteVMdescendantpermCascadeFunctionality
	Manual TestCase	: QAT-33  -  WCP_1346_TC_1.1_Permissions_Edit descendant permissions_cascade to children
	Description		: Validate Edit descendant permissions after checking cascade to childeren functionality 
	Author 			: Sukur Babu. B
	Creation Date 	: 11/17/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	@Test(priority=26)
	public void navValidateDeleteVMdescendantpermCascadeFunctionality() {
		String sOrgName,sActSuccMsg,sExpSuccMsg;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, ManageEntity);
		PageFactory.initElements(driver, UserPermission);
		PageFactory.initElements(driver, EVDC_OverviewPF);
		PageFactory.initElements(driver, EVDC_VMPF);
		try{
			boolean bEditFlag=false;
			FrameworkUtil.sTestCaseName ="navValidateDeleteVMdescendantpermCascadeFunctionality";
			FrameworkUtil.sManualTestCaseName="QAT-33  -  WCP_1346_TC_1.1_Permissions_Edit descendant permissions_cascade to children";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.HOSTEDSOLUTIONS");
			navigateToManageEntityTab();
			//Click on TST Entity02 Edit icon
			clickonEditCopyIconManageEntity(sOrgName, null,"edit");
			editPermissionManageEntity("Delete VM",false,true);
			LoginTestCase.nav_Logout();
			
			navLoginUsinggiruserUser();
			navVerifyDeleteNotpresentInVMList();
			LoginTestCase.nav_Logout();
			
			navigateToManageEntityTab();
			//Click on TST Entity02 Edit icon
			clickonEditCopyIconManageEntity(sOrgName, null,"edit");
			editPermissionManageEntity("Delete VM",true,true);
			sExpSuccMsg="Entity " +sOrgName +" edited successfully";
			//if(bEditFlag){
				sActSuccMsg=UserPermission.getNav_FeedBackArea().getText();
				if(sActSuccMsg.contains(sExpSuccMsg))
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element message verified", "pass",sExpSuccMsg +" is matching with actual message");
				else
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element message verified", "fail",sExpSuccMsg +" is not matching with actual message");
				//}
			LoginTestCase.nav_Logout();
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
	         	LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
	}
	
	/*==============================================================
	TestScript 		: navValidateAddVMAfterEditPermissionandRoleChangeForTSTEntity03_2955
	Manual TestCase	: QAT-44  --  WCP_1346_TC_4.0_Manage Entities_edit/republish permissions to users_then change user role
	Description		: Validate Add VM and Edit VM not displayed after changing permission and role
	Author 			: Sukur Babu. B
	Creation Date 	: 11/17/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	@Test(priority=27)
	public void navValidateAddVMAfterEditPermissionandRoleChangeForTSTEntity03_2955() {
		String sOrgNameToVerify,sOrgNameToSelect,sUser,sRoleToSelect,sEntity1,sEntity2,sEntity3;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, ManageEntity);
		PageFactory.initElements(driver, UserPermission);
		PageFactory.initElements(driver, EVDC_OverviewPF);
		PageFactory.initElements(driver, EVDC_VMPF);
		try{
			FrameworkUtil.sTestCaseName ="navValidateAddVMAfterEditPermissionandRoleChangeForTSTEntity03_2955";
			FrameworkUtil.sManualTestCaseName=" QAT-44  --  WCP_1346_TC_4.0_Manage Entities_edit/republish permissions to users_then change user role";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			sOrgNameToSelect=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY03_2955");
			sOrgNameToVerify=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
			sUser=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.ENTITY03.USERID");
			sRoleToSelect=(String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.ROLE3");
			sEntity1=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
			//sEntity2=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY02");
			sEntity3=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY03");
			navigateToManageEntityTab();
			
			
			//Click on TST Entity02 Edit icon
			clickonEditCopyIconManageEntity(sEntity1, sEntity3,"edit");
			editPermissionManageEntity("Add VM",false,false);
			
			WebObjectUtil.clickElement(UserPermission.getNav_UsersTab());
			UserPermissionTestCase.selectOrgFromUserPermission(sEntity3,sOrgNameToSelect);
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
			
			if(!sRoleText.equalsIgnoreCase(sRoleToSelect))
			UserPermissionTestCase.setUserPermission(sUser,sRoleToSelect);
			
			LoginTestCase.nav_Logout();	
			
			navLoginUsingEntity03aUser();
			navVerifyAddVMNotpresentInVMList();
			LoginTestCase.nav_Logout();	
			
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
	         	LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
	}
	/*==============================================================
	TestScript 		: navValidateAddandEdtVMdescendantpermFunctionalityFortstbonanza
	Manual TestCase	: QAT-29  --  WCP_3405_TC_1.0_Manage Entities_Permissions are edited for an entity even though "Failure" msg is displayed
	Description		: Validate Edit descendant permissions functionality 
	Author 			: Sukur Babu. B
	Creation Date 	: 11/16/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	@Test(priority=28)
	public void navValidateAddandEdtVMdescendantpermFunctionalityFortstbonanza() {
		String sOrgName1,sOrgName2,sExpSuccMsg,sActSuccMsg;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, ManageEntity);
		PageFactory.initElements(driver, UserPermission);
		PageFactory.initElements(driver, EVDC_OverviewPF);
		PageFactory.initElements(driver, EVDC_VMPF);
		PageFactory.initElements(driver, EVDCVMADV_PF);
		try{
			boolean bEditFlag=false;
			FrameworkUtil.sTestCaseName ="navValidateAddandEdtVMdescendantpermFunctionalityFortstbonanza";
			FrameworkUtil.sManualTestCaseName="QAT-29  -  WCP_3405_TC_1.0_Manage Entities_Permissions are edited for an entity even though Failure msg is displayed";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			sOrgName1=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTBONANZA");
			sExpSuccMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.EDIT.PERMISSION.TSTBONANZA.FEEDBACK.MSG");
			//sOrgName2=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY02");
			navigateToManageEntityTab();
			
			
			//Click on TST Entity02 Edit icon
			clickonEditCopyIconManageEntity(sOrgName1, null,"edit");
			editPermissionManageEntity("Add VM,Edit VM",false,false);
			
			
			if(bEditFlag){
				sActSuccMsg=UserPermission.getNav_FeedBackArea().getText();
				if(sActSuccMsg.contains(sExpSuccMsg))
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element message verified", "pass",sExpSuccMsg +" is matching with actual message");
				else
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element message verified", "fail",sExpSuccMsg +" is not matching with actual message");
				}
			
			LoginTestCase.nav_Logout();	
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
	         	LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
	}
/////////********************************Sukur End***********************************/////////////////
	
/////////********************************QAA04 Start***********************************/////////////////
	/*==============================================================
	TestScript 		: navVerifyEditAndCopyIcons
    Manual TestCase	: CPPOC-3474/QAT-15
	Description		: Hover over to all entities and verify multiple edit and copy icons are not displaying
	Author 			: QAA04
	Creation Date 	: 09/09/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	

@Test(priority=31)
public void navVerifyEditAndCopyIcons() {
	int iEntityTableCount,iEditCount,iCopyCount;
	List<WebElement> EditBtn;
	List<WebElement> CopyBtn;
	WebElement wEditBtn,wCopyBtn;
	WebDriver driver = WebDriverUtil.getDriver();
	
	PageFactory.initElements(driver, ManageEntity);
	
	PageFactory.initElements(driver, UserPermission);
	
	try {
		
	
	FrameworkUtil.sTestCaseName="navVerifyEditAndCopyIcons";
	FrameworkUtil.sManualTestCaseName="(QAT-15)Hover over to all entities and verify multiple edit and copy icons are not displaying";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	
    String sUserName= (String) FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEA.USERID");
    String sPassword= (String) FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEA.PASSWORD");

    UserPermissionTestCase.AccessToUserManagement(sUserName, sPassword);

  //  WebObjectUtil.explicitWait(3);
	WebObjectUtil.clickElement(UserPermission.getNav_ManageEntityTab());
	iEntityTableCount = WebTableUtil.getRowCount(ManageEntity.getNav_Users_ManageEntityTable());
	for (int i=1;i<=iEntityTableCount; i++){
		
		//wEditBtn = WebObjectUtil.GetWebElement("xpath", "//table["+i+"]//img[contains(@src,'copy_Button_Icon.png')]", "Copy Icon on Row-" + i);
		EditBtn = WebDriverUtil.getDriver().findElements(By.xpath("//table["+i+"]//img[contains(@src,'copy_Button_Icon.png')]"));
		iEditCount = EditBtn.size();
		if(iEditCount == 1) {
		
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Copy Icon", "pass", "only one copy icons are displaying at a time"+i);
		} else{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Copy Icon", "fail", "multiple copy icons are displaying at a time");
		}
		
		//wCopyBtn = WebObjectUtil.GetWebElement("xpath", "//table["+i+"]//img[contains(@src,'Edit_Button_Icon.png')]", "Edit Icon on Row-" +i);
		CopyBtn = WebDriverUtil.getDriver().findElements(By.xpath("//table["+i+"]//img[contains(@src,'Edit_Button_Icon.png')]"));
		iCopyCount = CopyBtn.size();
		if (iCopyCount == 1 ){
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "edit Icon", "pass", "only one edit icons are displaying at a time"+i);
		} else{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "edit Icon", "fail", "multiple edit icons are displaying at a time");
		}
		
	}
	
	
	LoginTestCase.nav_Logout();
	
	}
	catch (Exception e) {
		LoggerUtil.log_type_error("Issue with - verifing multiple edit and copy icons");
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		LoggerUtil.log_type_error(e.getMessage());
	}
}
//-------------------------------------------------------------------------------------------------------------------------------------------------------------

/*	==============================================================
TestScript 		: navVerifyMnageEntityEditPermissions
Manual TestCase	: CPPOC-3473/QAT-25
Description		: Hover over to an entity and click on Edit button and verify it opens up an overlay of permissions
Author 			: QAA04
Creation Date 	: 09/10/2015
Pre-Requisites	:
Revision History:
==============================================================*/

@Test(priority=32)
public void navVerifyMnageEntityEditField() {
	int iEntityTableCount;
	WebElement wEntityRow;
	String sEditIcon;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, ManageEntity);
	PageFactory.initElements(driver, UserPermission);
	//PageFactory.initElements(driver, UP_MultiOrg);
	try {
		
	
	FrameworkUtil.sTestCaseName="navVerifyMnageEntityEditField";
	FrameworkUtil.sManualTestCaseName="(QAT-25)Hover over to an entity and click on Edit button and verify it opens up an overlay of permissions";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	
    String sUserName= (String) FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEA.USERID");
    String sPassword= (String) FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEA.PASSWORD");

    UserPermissionTestCase.AccessToUserManagement(sUserName, sPassword);

  //  WebObjectUtil.explicitWait(3);
	WebObjectUtil.clickElement(UserPermission.getNav_ManageEntityTab());
//	WebObjectUtil.explicitWait(3);
	WebObjectUtil.MouseHover(ManageEntity.getNav_ManageEntityTableRow());
	//wEntityRow = WebObjectUtil.GetWebElement("xpath", "//div[@id='idENENtitiesTreePanel']//table[1]//img[contains(@src,'Edit_Button_Icon.png')]", "Edit Icon");
	sEditIcon =WebObjectUtil.getLocatorValueFromProperty("UP.ENTITYMGMT.EDIT.ICON", "PARAMETER_ROWNUMBER", 1 +"");
	wEntityRow = WebObjectUtil.GetWebElement("XPATH", sEditIcon, "Edit icon");
	wEntityRow.click();
	WebObjectUtil.explicitWait(5);
	WebObjectUtil.selectCheckRadioBox(ManageEntity.getNav_ManageEntityEdit_ExpandAllCheckbox());
//	WebObjectUtil.isCheckRadioSelected(Eilerson.getNav_ManageEntityEdit_ExpandAllTitle());
 

	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_CatalogsTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_Catalogs_ViewCatalogsTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_Catalogs_EditCatalogItemTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_Catalogs_CreateCatalogItemTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_Catalogs_UploadNewImagetoCatalogTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_Catalogs_CopyCatalogItemTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_Catalogs_DeleteCatalogItemTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_DRaaSTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_DRaaS_ViewDRaaSTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_DRaaS_ViewDRaaSTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_DRaaS_DeleteDRaaSTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_EVDCOverviewTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_EVDCOverview_ViewEVDCTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_EVDCOverview_EditEVDCTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_EVDCOverview_CreateEVDCTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_FirewallTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_Firewall_ViewFirewallRulesTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_Firewall_EditFirewallRulesTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_Firewall_AddFirewallRulesTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_Firewall_DeleteFirewallRulesTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_LoadBalancerTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_LoadBalancer_ViewLoadbalancersTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_LoadBalancer_EditLoadbalancersTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_LoadBalancer_AddLoadbalancersTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_LogViewerPortlet_ViewLogsTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_LogViewerPortlet_ViewLogsTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_OthersTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_Others_EnableMonitoringTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_Others_DisableMonitoringTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_Others_SubscribetoNewProductTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_Others_AccessFormsTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_Others_AccessEM7Title());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_Others_ViewReportsTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_Others_CanWhitelabelTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_PermissionsTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_Permissions_ViewPermissionsTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_Permissions_EditPermissionsTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_TenancyTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_Tenancy_CanSeeChildrenTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_Tenancy_CanManageChildrenTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_Tenancy_CanSeeRollUpTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_TicketsTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_Tickets_ViewTicketsTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_Tickets_EditTicketsTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_Tickets_CreateTicketsTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_Tickets_AccessDetailedTicktingTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_UserInfoTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_UserInfo_AddUserTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_UserInfo_DeleteUserTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_UserInfo_EditUserTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_UserInfo_ResetPasswordTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_VirtualMechinesTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_VirtualMechines_ViewVMsTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_VirtualMechines_VMControlsTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_VirtualMechines_EditVMTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_VirtualMechines_AddVMTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_VirtualMechines_DeleteVMTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_VirtualMechines_CloneaVMTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_VirtualMechines_CloneaVMtoCatalogVMTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_VirtualMechines_AddVMtoMonotoringTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_VPNTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_VPN_ViewUserVPNsTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_VPN_EditUserVPNsTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_VPN_AddVPNsTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_VPN_ResetAddVPNTitle());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_ResetBtn());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_SaveBtn());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntity_CancelBtn());
	WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntityEdit_CascadetoChildrenTitle());
	WebObjectUtil.explicitWait(3);
	LoginTestCase.nav_Logout();
	
	}
	catch (Exception e) {
		LoggerUtil.log_type_error("Issue with -Manage entity edit page");
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		LoggerUtil.log_type_error(e.getMessage());
	}
}
/////////********************************QAA04 End***********************************/////////////////

/////////********************************QAA03 Start***********************************/////////////////

/*==============================================================
TestScript  	: verifyCancelbuttonUnderCopyManageEntity
Manual TestCase	: QAT-62 Manage Entities_Cancel button should be there under 'Copy' permissions option
Description		:
Author 			: QAA03
Creation Date 	: 11/17/2015
Release Name    : Eilerson
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=41)
public void verifyCancelbuttonUnderCopyManageEntity()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, ManageEntity);
	PageFactory.initElements(driver,UserPermission );
	String sUserName=null,sPassword=null,sEntitySelected=null,sButtonSelected=null;
	
	
	try {
		FrameworkUtil.sTestCaseName = "verifyCancelbuttonUnderCopyManageEntity";
		FrameworkUtil.sManualTestCaseName="QAT-62 Manage Entities_Cancel button should be there under 'Copy' permissions option";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.USERID");
	    sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.PASSWORD");
	    
		//Navigating to permissions page
		UserPermissionTestCase.AccessToUserManagement(sUserName, sPassword);
		
		//Clicking on Manage Entity Tab and verifying Manage Entity Table
		WebObjectUtil.clickAndVerifyElement(UserPermission.getNav_ManageEntityTab(), ManageEntity.getNav_ManageEntityParentWebTable());
		
		//Entity  selected from Manage entity table
		sEntitySelected = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
		//Button selected for the selected entity from Manage entity table
		sButtonSelected = "copy";
		
		//Passing the Child Entity as null
		clickonEditCopyIconManageEntity(sEntitySelected,null,sButtonSelected);
		
		//Verifying Copy window is displayed
		WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntity_CopyWindow());
		
		//Verifying Cancel button in copy window
		WebObjectUtil.verifyElementPresent(ManageEntity.getNav_ManageEntity_CancelBtn());
		//Clicking on Cancel button
		WebObjectUtil.clickElement(ManageEntity.getNav_ManageEntity_CancelBtn());
		
		LoginTestCase.nav_Logout();
		
	   } catch (Exception e) {
		LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyCancelbuttonUnderCopyManageEntity", "warn", "catch block:" +e.getMessage());
	}
}
	
/*=================================================================================================
TestScript  	: verifyUserUnabletoViewManageEntityTab
Manual TestCase	: QAT-49/CPPOC-3468 Verifying Role-C is unable to see the Manage Entities tab under Permissions page.
Description		: Verify Role-C is unable to see the Manage Entities tab under Permissions page.
Author 			: QAA03
Creation Date 	: 09/11/2015
Release Name    : Eilerson
Pre-Requisites	:
Revision History:
==========================================================================================================*/
@Test(priority=42)
public static void verifyUserUnabletoViewManageEntityTab()
{
	             WebDriver driver = WebDriverUtil.getDriver();
                 PageFactory.initElements(driver,UserPermission);
                             
	             String sUserName=null,sPassword=null;
	       
	        try {
				
				FrameworkUtil.sTestCaseName = "verifyUserUnabletoViewManageEntityTab";
				FrameworkUtil.sManualTestCaseName="QAT-49/CPPOC-3468 Verifying Role-C is unable to see the Manage Entities tab under Permissions page.";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				                 
				
				sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.ROLEC");
			    sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.PASSWORD");
				
			    UserPermissionTestCase.AccessToUserManagement(sUserName, sPassword);
			    WebObjectUtil.verifyElementNOTPresent(UserPermission.getNav_ManageEntityTab());
			    LoginTestCase.nav_Logout();
	
			} catch (Exception e) {
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyUserUnabletoViewManageEntityTab", "warn", "catch block:" +e.getMessage());
			}
	      
	       
}
/*=================================================================================================
TestScript  	: verifyPermissionsChangingParentChildEntities
Manual TestCase	: QAT-55/CPPOC-3601 Manage Entities_/Upgrade_Delete entity_Permissions
Description		: Verifying Permissions by changing parent for child entities
Author 			: QAA03
Creation Date 	: 11/24/2015
Release Name    : Eilerson
Pre-Requisites	:
Revision History:
==========================================================================================================*/
@Test(priority=43)
public static void verifyPermissionsChangingParentChildEntities()
{
	             WebDriver driver = WebDriverUtil.getDriver();
                // PageFactory.initElements(driver,Admin);
                 PageFactory.initElements(driver,ManageEntity);
         		 PageFactory.initElements(driver,UserPermission);
         		 PageFactory.initElements(driver,Common); 
         		 PageFactory.initElements(driver,EVDC_VMPF);
        		 PageFactory.initElements(driver,EVDC_OverviewPF);
        		 PageFactory.initElements(driver,EVDCVMADV_PF);
         		 
	             String sUserName=null,sPassword=null,sEntitySelected=null,sEntityorg1=null,sEntityorg2=null,sEntityorg3=null;
	             boolean bPerstatus;
	             String sPerEntity01[][] = new String[100][100];
	             String sPerEntity03[][] = new String[100][100];
	            		
	       
	        try {
				
				FrameworkUtil.sTestCaseName="verifyPermissionsChangingParentChildEntities";
				FrameworkUtil.sManualTestCaseName="QAT-55/CPPOC-3601 Manage Entities_/Upgrade_Delete entity_Permissions ";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
				sEntityorg1 = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY01");
				sEntityorg2 = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY02");
			    sEntityorg3 = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY03");
			    
 				sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ISHANNON.USERID");
			    sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ISHANNON.PASSWORD");
				
				
				//precondition for step 6-setting child parent relationship to entities in the flow TST Entity01/TST Entity02/TST Entity03/TST Entity04
				AdminTestCase.verifyTstEntityParentChildHierarchy();
				
				
				//Step 1 ,2 and 3 Navigating to Manage entity tab of permissions page with ROLE-A user
				navigateToManageEntityTab();
				//Step 4 and 5 - Clicking on edit icon and setting all permissions check for TST Entity01
				setFullPermissionManageEntity(sEntityorg1, null, true);
				WebObjectUtil.explicitWait(5);
				// Step 14 - Collecting the permissions of TST Entity01 in the array
				 sPerEntity01 = gettingPermissionLabelChkBoxStatus(sEntityorg1,null);
				
				
				 WebObjectUtil.explicitWait(5);
				//Step 7 Setting permissions different for child (TST Entity02) and cascading to its children
				clickonEditCopyIconManageEntity(sEntityorg1, sEntityorg2,"edit");
				editPermissionManageEntity("Add VM,Edit VM",false,true);
				
				//Step 8
				LoginTestCase.nav_Logout();
				
				
				//Step 9 to 13 // Changing the parent of TST Entity03 to TST Entity01 from TST Entity02 by logging in as ishannon user
				
				 sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ISHANNON.USERID");
				 sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ISHANNON.PASSWORD");

				 	
				LoginTestCase.nav_Login(sUserName, sPassword);
				
				AdminTestCase.verifyOrg(sEntityorg3,sEntityorg1);
					
				LoginTestCase.nav_Signout();
				
				//Navigating to Manage entity tab of permissions page with ROLE-A user
				navigateToManageEntityTab();
				
				//Clicking on edit icon and checking the permissions for TST Entity03
				//UserPermissionManageEntityTestCase.clickonEditCopyIconManageEntity(sEntityorg1,sEntityorg3,"edit");
			    sPerEntity03 = gettingPermissionLabelChkBoxStatus(sEntityorg1,sEntityorg3);
			    //Step 14 Verifying permissions are different for TST Entity01 and TST Entity03
				bPerstatus =!Arrays.deepEquals(sPerEntity01, sPerEntity03);
				FrameworkUtil.sElementName="Permission";
				FrameworkUtil.updateCustomResultBasedOnStatus(bPerstatus, "Permissions for TST Entity01 and TST Entity03 are different");
				
				
				//Step 15 and 16 - To match permissions for TST Entity03 to TST Entity01
				valManageEntityCopyFunction(sEntityorg1, sEntityorg3, false);
				//Step 17
				
				LoginTestCase.nav_Logout();
				//Step 18 to 21 - Logging to Navigator with Entity03a and verifying AddVM and EditVM in VM Page
				navLoginUsingEntity03aUser();
				
				WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
				WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine(),EVDC_VMPF.getNav_AddVMLink());
				
				//EVDC_VM_AdvancedActions.navigateAndExpandVM("Stopped");
				EVDC_VM_AdvancedActions.expandVMbyRowNum(1);
				EVDC_VM_TestCase.navVerifyEditBtn(1);
				
				
				LoginTestCase.nav_Logout();
	
			}   catch (Exception e) {
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyPermissionsChangingParentChildEntities", "warn", "catch block:" +e.getMessage());
			}
	      
	       
}

 
	/*==============================================================
	Method Name       : gettingPermissionLabelChkBoxStatus
	Description       : Getting the Permission label name and the check box status
	Author            : Vivek Kumar
	Creation Date     : 11/18/2015
	Pre-Requisites    :
	Revision History:
	==============================================================*/
	public static String[][] gettingPermissionLabelChkBoxStatus(String sParentEntity, String sChildEntity)
	{
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, ManageEntity);
		PageFactory.initElements(driver, UserPermission);
		
		
		int iRowCnt;
		String sLabelAttribute;
		String[][] multD = null;

		try {
			//Clicking on Edit pencil link
			clickonEditCopyIconManageEntity(sParentEntity, sChildEntity, "edit");
			//checking Expand All checkbox
			WebObjectUtil.selectCheckRadioBox(ManageEntity.getNav_ManageEntityEdit_ExpandAllCheckbox());
			
			//Getting the Permission label name and the check box status
			 CustomWebElementUtil.loadCustomElement(UserPermission.getNav_Users_ManageEntityEditParentWebTable(), "table");
			iRowCnt=CustomWebElementUtil.iRowCount;
			multD = new String[iRowCnt][2];
						
			for(int i=1;i<=iRowCnt;i++)
			{
				WebElement wEditPermissionLabel = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "UP.ENTITYMGMT.EDIT.PERMISSIONTREE.CHECKBOX.LABEL", "PARAMETER_ROWNUMBER",i+"");
			    String sPermissionNameActual = wEditPermissionLabel.getText().trim();
			    System.out.println(sPermissionNameActual);
			    multD[i-1][0]=sPermissionNameActual;
			    WebElement wEditPermissionExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "UP.ENTITYMGMT.EDIT.PERMISSIONTREE.EXPANDER", "PARAMETER_ROWNUMBER",i+"");
			    sLabelAttribute = wEditPermissionExpander.getAttribute("class"); 
			    if (!sLabelAttribute.contains("x-tree-expander")){
				
			    WebElement wEditPermissionCheckbox = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "UP.ENTITYMGMT.EDIT.PERMISSIONTREE.CHECKBOX", "PARAMETER_ROWNUMBER",i+"");
			    if(wEditPermissionCheckbox!=null)
			    {
			    	String sClassAttribute = wEditPermissionCheckbox.getAttribute("class");
			    	if (sClassAttribute.contains("checkbox-checked")){
			    		System.out.println("true");
			    		 multD[i-1][1]="true";
			    	}
			    	else
			    	{
			    		System.out.println("false");
			    		multD[i-1][1]="false";
			    	}
			     }
			    }
			}
		
			//Clicking on Cancel button
			/*if(WebObjectUtil.isElementPresent(UserPermission.getNav_EM_Edit_CancelBtn()))
			{
				WebObjectUtil.clickElement(UserPermission.getNav_EM_Edit_CancelBtn());
			}
			else
			{
				WebObjectUtil.clickElement(UserPermission.getNav_EM_Edit_ReCancelBtn());
			}*/
			WebObjectUtil.clickElement(UserPermission.getNav_EM_Edit_CloseImage());
			
			
		} catch (Exception e) {
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		return multD;
	}
	
	/////////////////////////////////////////Sukur Babu. B///////////////////////////////
	/*====================================================================================================
	Method Name 	: navigateToManageEntityTab
	Description		: Verifies access to permission page and navigate to Manage Entity tab
	Creation Date 	: 11/16/2015
	Pre-Requisites	:
	Revision History:
	=====================================================================================================*/
	public static void navigateToManageEntityTab(){
		try {
			String sUserName,sPassword;
			
			WebDriver driver=WebDriverUtil.getDriver();
			PageFactory.initElements(driver, UserPermission);
			
			sUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.ROLEA");
			sPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.PASSWORD");
			UserPermissionTestCase.AccessToUserManagement(sUserName, sPassword);
			WebObjectUtil.clickElement(UserPermission.getNav_ManageEntityTab());
		}
		catch (Exception e) {
			LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navigateToManageEntityTab", "warn", "catch block:Could NOT access webelement" +e.getMessage());	
		}
	}
	/*====================================================================================================
	Method Name 	: navLoginUsingEntity02aUser
	Description		: Login using Entity02
	Creation Date 	: 11/16/2015
	Pre-Requisites	:
	Revision History:
	=====================================================================================================*/
	public static void navLoginUsingEntity02aUser(){
		try {
			
			String sUserName,sPassword;
			sUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.ENTITY02.USERID");
			sPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.PASSWORD");
			LoginTestCase.nav_Login(sUserName, sPassword);
		}
		catch (Exception e) {
			LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navLoginUsingEntity02aUser", "warn", "catch block:Could NOT access webelement" +e.getMessage());	
		}
	}
	/*====================================================================================================
	Method Name 	: navLoginUsingEntity03aUser
	Description		: Login using Entity02
	Creation Date 	: 11/18/2015
	Pre-Requisites	:
	Revision History:
	=====================================================================================================*/
	public static void navLoginUsingEntity03aUser(){
		try {
			
			String sUserName,sPassword;
			sUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.ENTITY03.USERID");
			sPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.PASSWORD");
			LoginTestCase.nav_Login(sUserName, sPassword);
		}
		catch (Exception e) {
			LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navLoginUsingEntity02aUser", "warn", "catch block:Could NOT access webelement" +e.getMessage());	
		}
	}
	/*====================================================================================================
	Method Name 	: navLoginUsinggiruserUser
	Description		: Login using Entity02
	Creation Date 	: 11/18/2015
	Pre-Requisites	:
	Revision History:
	=====================================================================================================*/
	public static void navLoginUsinggiruserUser(){
		try {
			
			String sUserName,sPassword;
			sUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.GIRUSER");
			sPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.PASSWORD");
			LoginTestCase.nav_Login(sUserName, sPassword);
		}
		catch (Exception e) {
			LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navLoginUsingEntity02aUser", "warn", "catch block:Could NOT access webelement" +e.getMessage());	
		}
	}
	/*====================================================================================================
	Method Name 	: navLoginUsingEntity01aUser
	Description		: Login using Entity02
	Creation Date 	: 11/16/2015
	Pre-Requisites	:
	Revision History:
	=====================================================================================================*/
	public static void navLoginUsingEntity01aUser(){
		try {
			
			String sUserName,sPassword;
			sUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.ENTITY01.USERID");
			sPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.PASSWORD");
			LoginTestCase.nav_Login(sUserName, sPassword);
		}
		catch (Exception e) {
			LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navLoginUsingEntity01aUser", "warn", "catch block:Could NOT access webelement" +e.getMessage());	
		}
	}
	/*====================================================================================================
	Method Name 	: navVerifyEditAndAddVMNotpresentInVMList
	Description		: Verifies Edit VM and Add Virtual machines links are not available
	Creation Date 	: 11/16/2015
	Pre-Requisites	:
	Revision History:
	=====================================================================================================*/
	public static void navVerifyEditAndAddVMNotpresentInVMList(){
		try {
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			int iRowNo = EVDC_VM_AdvancedActions.getRow_EVDC_VMTable(EVDC_VMPF.getNav_VMWebTableParent(),"Stopped","");
			boolean bStatus;
			if (iRowNo > 0 ){
				bStatus = true;
				EVDC_VM_AdvancedActions.expandVMbyRowNum(iRowNo);
			}
			//EVDC_VM_AdvancedActions.navigateAndExpandVM("Stopped");
			int iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			//EVDC_VM_TestCase.navVerifyEditBtn(iRowNbr);
			WebElement wEdit = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.EDITVM", "PARAMETER_ROWNUMBER", iRowNbr+"");
			if(wEdit!=null)
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Edit VM Button" , "Button is still visible after removing permission" , "fail", "Edit button");
				//LoggerUtil.log_type_error("Edit button not verified");
				
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Edit VM Button" , "Button is not visible after removing permission " , "pass","Edit button verified");
				//LoggerUtil.log_type_info("Edit button verified" );
			}
			WebObjectUtil.verifyElementNOTPresent(EVDC_VMPF.getNav_AddVMLink());
		}
		catch (Exception e) {
			LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navVerifyEditAndAddVMNotpresentInVMList", "warn", "catch block:Could NOT access webelement" +e.getMessage());	
		}
	}
	
	
	/*====================================================================================================
	Method Name 	: navVerifyDeleteNotpresentInVMList
	Description		: Verifies Delete link is not available
	Creation Date 	: 11/18/2015
	Pre-Requisites	:
	Revision History:
	=====================================================================================================*/
	public static void navVerifyDeleteNotpresentInVMList(){
		try {
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, EVDCVMADV_PF);
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			int iRowNo = EVDC_VM_AdvancedActions.getRow_EVDC_VMTable(EVDC_VMPF.getNav_VMWebTableParent(),"Stopped","");
			boolean bStatus;
			if (iRowNo > 0 ){
				bStatus = true;
				EVDC_VM_AdvancedActions.expandVMbyRowNum(iRowNo);
			}
			WebObjectUtil.clickElement(EVDCVMADV_PF.getNav_EVDCAdvancedActionsLink());
			WebObjectUtil.verifyElementNOTPresent(EVDCVMADV_PF.getNav_EVDCDeleteVMLink());
		}
		catch (Exception e) {
			LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navVerifyEditAndAddVMNotpresentInVMList", "warn", "catch block:Could NOT access webelement" +e.getMessage());	
		}
	}
	/*====================================================================================================
	Method Name 	: navVerifyAddVMNotpresentInVMList
	Description		: Verifies  Add Virtual machines links are not available
	Creation Date 	: 11/16/2015
	Pre-Requisites	:
	Revision History:
	=====================================================================================================*/
	public static void navVerifyAddVMNotpresentInVMList(){
		try {
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, EVDCVMADV_PF);
			//PageFactory.initElements(driver, EVDCVMADV_PF);
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			int iRowNo = EVDC_VM_AdvancedActions.getRow_EVDC_VMTable(EVDC_VMPF.getNav_VMWebTableParent(),"Stopped","");
			boolean bStatus;
			if (iRowNo > 0 ){
				bStatus = true;
				EVDC_VM_AdvancedActions.expandVMbyRowNum(iRowNo);
			}
			//EVDC_VM_AdvancedActions.navigateAndExpandVM("Stopped");
			int iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			
			WebObjectUtil.verifyElementNOTPresent(EVDC_VMPF.getNav_AddVMLink());
		}
		catch (Exception e) {
			LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navVerifyEditAndAddVMNotpresentInVMList", "warn", "catch block:Could NOT access webelement" +e.getMessage());	
		}
	}

	
	  /*==============================================================
	  Method Name       : editPermissionManageEntity
	  Description       : Provide or remove permission by clicking on check box
	  Author            : Arularasu
	  Creation Date     : 11/11/2015
	  Pre-Requisites    :
	  Revision History: 
	  Notes             : To provide access pass bProvidePermission = true and to remove access pass bProvidePermission = false
						'sPermissionNames--If user wants to add/remove more than one permission then give list permission separated by comma
	  ==============================================================*/

	  public static boolean editPermissionManageEntity(String sPermissionNames,boolean bProvidePermission,boolean bCascadeChild){
		  	//String sExpSuccMsg,sActSuccMsg;
	        WebElement wEditPermissionLabel,wEditPermissionCheckbox;
	        String sPermissionNameActual,sPerName,sClassAttribute;
	        boolean bFlag = false;
          WebDriver driver = WebDriverUtil.getDriver();
	        PageFactory.initElements(driver, UserPermission);
	        PageFactory.initElements(driver, CommonPF);
	        PageFactory.initElements(driver, ManageEntity);
	      sPerName = sPermissionNames;
	      String[] sName = sPermissionNames.split(",");   
	      if(WebObjectUtil.verifyElementPresent(UserPermission.getNav_Users_ManageEntityEditParentWebTable())){
	            WebObjectUtil.selectCheckRadioBox(UserPermission.getNav_EM_Edit_ExpandAllCheckBox());
	            WebObjectUtil.explicitWait(3);
	            CustomWebElementUtil.loadCustomElement(UserPermission.getNav_Users_ManageEntityEditParentWebTable(), "table");
	            for (int i=0; i<sName.length;i++){
	            sPerName = sName[i];
	            for (int r=2;r<=CustomWebElementUtil.iRowCount;r++){
	                  wEditPermissionLabel = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "UP.ENTITYMGMT.EDIT.PERMISSIONTREE.CHECKBOX.LABEL", "PARAMETER_ROWNUMBER",r+"");
	                  sPermissionNameActual = wEditPermissionLabel.getText().trim();
	                  //System.out.println(sPermissionNameActual);
	                  if (sPermissionNameActual.equalsIgnoreCase(sPerName)){
	                        wEditPermissionCheckbox = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "UP.ENTITYMGMT.EDIT.PERMISSIONTREE.CHECKBOX", "PARAMETER_ROWNUMBER",r+"");
	                        sClassAttribute = wEditPermissionCheckbox.getAttribute("class");
	                        if (bProvidePermission == true ){
	                        	if (!sClassAttribute.contains("checkbox-checked")){
	                        		//Added by Sukur Babu. B Dated on 05-July-2016. To see the element at the ener of the screen as the element is going behind menu bar of the application
	                                WebObjectUtil.scrollElementAtPageCenter(wEditPermissionCheckbox);
	                        		wEditPermissionCheckbox.click();
	                        		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Provide access", "pass", "Access provided :" + sPermissionNameActual);
	                        		bFlag=true;
	                        	}else{
	                        		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Provide access", "done", "Access already Exist :" + sPermissionNameActual);
	                        		bFlag=false;
	                        	}
	                        }else{
	                        	if (sClassAttribute.contains("checkbox-checked")){
	                        		//Added by Sukur Babu. B Dated on 05-July-2016. To see the element at the ener of the screen as the element is going behind menu bar of the application
	                                WebObjectUtil.scrollElementAtPageCenter(wEditPermissionCheckbox);
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
	            	if (bCascadeChild){
	            		//Added by Sukur Babu. B Dated on 05-July-2016. To see the element at the ener of the screen as the element is going behind menu bar of the application
                        WebObjectUtil.scrollElementAtPageCenter(ManageEntity.getNav_EditEntityCascadeToChilderenCheckBox());
	  		    	  WebObjectUtil.clickElement(ManageEntity.getNav_EditEntityCascadeToChilderenCheckBox());
	  		      	}
	            	//Added by Sukur Babu. B Dated on 05-July-2016. To see the element at the ener of the screen as the element is going behind menu bar of the application
                    WebObjectUtil.scrollElementAtPageCenter(UserPermission.getNav_EM_Edit_SaveBtn());
	                  WebObjectUtil.clickElement(UserPermission.getNav_EM_Edit_SaveBtn());
	                  //sActSuccMsg=CommonPF.getNav_CommonPopUpMessage().getText();
	                 //System.out.println(CommonPF.getNav_CommonPopUpMessage().getText());
	                //Added by Sukur Babu. B Dated on 05-July-2016. To see the element at the ener of the screen as the element is going behind menu bar of the application
	                    WebObjectUtil.scrollElementAtPageCenter(CommonPF.getNav_CommonPopUpOKButton());
	                  WebObjectUtil.clickElement(CommonPF.getNav_CommonPopUpOKButton());
	                  WebObjectUtil.explicitWait(5);
	                  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Edit Permission MangeEntity", "pass", "Permission Edited" + CommonPF.getNav_CommonPopUpMessage().getText());
	                  return bFlag;
	            }else{
	                  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Edit Permission MangeEntity", "warn", "There are no change in permission, might be permission already provided/removed");
	                //Added by Sukur Babu. B Dated on 05-July-2016. To see the element at the ener of the screen as the element is going behind menu bar of the application
	                    WebObjectUtil.scrollElementAtPageCenter(UserPermission.getNav_nav_EM_Edit_CancelBtn());
	                  WebObjectUtil.clickElement(UserPermission.getNav_nav_EM_Edit_CancelBtn());
	                  return bFlag;
	            }
	      }  
	   return bFlag;   
	  }     


	  

/*====================================================================================================
  Method Name           : ClickonEditCopyIconManageEntity
  Description           : Click on Edit or Copy icon based on entity name passed  in Manage Entity
  Author                : Arularasu
  Creation Date   		: 11/19/2015
  Pre-Requisites  		:
  Revision History		:
  =====================================================================================================*/


  public static int clickonEditCopyIconManageEntity(String sParentEntity, String sChildEntity, String sBtnName)
  {
                 int iEMOrgRowNo=0,iEntityTableCount = 0,iTempRowNo=4;
                 WebElement wOrgElement,wEntityexpander, wRowAsElement = null,wBtnIcon;
                 String sRowText;
                 WebDriver driver = WebDriverUtil.getDriver();
     	        PageFactory.initElements(driver, UserPermission);

           
           try {
                CustomWebElementUtil.loadCustomElement(UserPermission.getNav_Users_ManageEntityParentWebTable(), "table");
                  iEntityTableCount = CustomWebElementUtil.iRowCount;
                  iEMOrgRowNo = CustomWebElementUtil.getRowByCellText(sParentEntity, 1);
                  wOrgElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "UP.ENTITYMGMT.EITITYTABLE.ORGNAME", "PARAMETER_ROWNUMBER", iEMOrgRowNo+"");
                  sRowText = wOrgElement.getText();
                  try {
                        if(  sChildEntity.trim().length() >0 ){               
                        // As four level organizations are there in EB , this loop will check for child four times
                              iTempRowNo = iTempRowNo + iEMOrgRowNo;
                              for(int i=1;i<=iTempRowNo;i++)
                        {
                              
                              wOrgElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "UP.ENTITYMGMT.EITITYTABLE.ORGNAME", "PARAMETER_ROWNUMBER", iEMOrgRowNo+"");
                              sRowText = wOrgElement.getText();
                              System.out.println(sRowText);
                              if(sRowText.equalsIgnoreCase(sChildEntity)){
                                    break;
                                    
                                }else{

                                    wEntityexpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "UP.ENTITYMGMT.EITITYTABLE.EXPANDER", "PARAMETER_ROWNUMBER", iEMOrgRowNo+"");
                                    if(wEntityexpander != null){
                                          WebObjectUtil.clickElement(wEntityexpander);
                                          WebObjectUtil.explicitWait(2);
                                          CustomWebElementUtil.loadCustomElement(UserPermission.getNav_Users_ManageEntityParentWebTable(), "table");
                                          iTempRowNo = iTempRowNo + (CustomWebElementUtil.iRowCount-iEntityTableCount);
                                          iEntityTableCount = CustomWebElementUtil.iRowCount;
                                          
                                    }
                                }
                              iEMOrgRowNo = iEMOrgRowNo+1;  
                              
                        }
                        }
                  } catch (Exception e) {
                        LoggerUtil.log_type_error("Child Entity passed as  null or empty - catch block:" + FrameworkUtil.sElementName + e.getMessage());
                  }
                  
                 
                  wRowAsElement = CustomWebElementUtil.getRowAsWebElement(iEMOrgRowNo);
                  //Added by Sukur Babu. B Dated on 05-July-2016. To see the element at the ener of the screen as the element is going behind menu bar of the application
                  WebObjectUtil.scrollElementAtPageCenter(wOrgElement);
                  WebObjectUtil.clickElement(wOrgElement);
                  wBtnIcon =  WebObjectUtil.getWebElementFromDynamicLocator("xpath", "UP.ENTITYMGMT.EITITYTABLE.EDIT.ICON", "PARAMETER_ROWNUMBER",iEMOrgRowNo+"");
                  
                  if(sBtnName.contains("edit")){
                        FrameworkUtil.sElementName = "Edit Icon";
                        WebObjectUtil.clickElement(wBtnIcon);
                        wBtnIcon =  WebObjectUtil.getWebElementFromDynamicLocator("xpath", "UP.ENTITYMGMT.EITITYTABLE.EDIT.ICON", "PARAMETER_ROWNUMBER",iEMOrgRowNo+"");
                  }else if(sBtnName.contains("copy")){
                        FrameworkUtil.sElementName = "Copy Icon";
                        wBtnIcon =  WebObjectUtil.getWebElementFromDynamicLocator("xpath", "UP.ENTITYMGMT.EITITYTABLE.COPY.ICON", "PARAMETER_ROWNUMBER",iEMOrgRowNo+"");
                        WebObjectUtil.clickElement(wBtnIcon);
                  }else{
                        FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Edit/Copy icon", "warn", "Pass the right button name");
                  }
                  

                  
            } catch (Exception e) {
                  LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName + e.getMessage());
                  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "ClickonEditCopyIconManageEntity", "warn", "catch block:" +e.getMessage());
            }
           return iEMOrgRowNo;
           
  }  
  


	/*==============================================================
	Method Name       : setFullPermissionManageEntity
	Description       : set full permission to entity which is passed through parameter.
	Author            : Arularasu
	Creation Date     : 11/23/2015
	Pre-Requisites    :
	Revision History:
	==============================================================*/
	public static void setFullPermissionManageEntity(String sParentEntity, String sChildEntity,boolean bCascadeChild){
		String sPermissionAcessList;
		WebElement wEditPermissionLabel,wEditPermissionCheckbox,wEditPermissionExpander;
        String sPermissionNameActual,sPerName,sClassAttribute,sLabelAttribute;
        boolean bFlag = false;
        
		
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, ManageEntity);
		PageFactory.initElements(driver, Common);
		PageFactory.initElements(driver, UserPermission);
	/*	
		sPermissionAcessList =(String)FrameworkUtil.dictPropertyData.get("NAV.UP.MANAGEENTITY.EDIT.ACCESS.LABEL.CATALOG");
		sPermissionAcessList =sPermissionAcessList + (String)FrameworkUtil.dictPropertyData.get("NAV.UP.MANAGEENTITY.EDIT.ACCESS.LABEL.DRAAS");
		sPermissionAcessList =sPermissionAcessList + (String)FrameworkUtil.dictPropertyData.get("NAV.UP.MANAGEENTITY.EDIT.ACCESS.LABEL.EVDC.OVERVIEW");
		sPermissionAcessList =sPermissionAcessList + (String)FrameworkUtil.dictPropertyData.get("NAV.UP.MANAGEENTITY.EDIT.ACCESS.LABEL.FIREWALL");
		sPermissionAcessList =sPermissionAcessList + (String)FrameworkUtil.dictPropertyData.get("NAV.UP.MANAGEENTITY.EDIT.ACCESS.LABEL.LOADBALANCER");
		sPermissionAcessList =sPermissionAcessList + (String)FrameworkUtil.dictPropertyData.get("NAV.UP.MANAGEENTITY.EDIT.ACCESS.LABEL.LOGVIEWER");
		sPermissionAcessList =sPermissionAcessList + (String)FrameworkUtil.dictPropertyData.get("NAV.UP.MANAGEENTITY.EDIT.ACCESS.LABEL.OTHERS");
		sPermissionAcessList =sPermissionAcessList + (String)FrameworkUtil.dictPropertyData.get("NAV.UP.MANAGEENTITY.EDIT.ACCESS.LABEL.PERMISSIONS");
		sPermissionAcessList =sPermissionAcessList + (String)FrameworkUtil.dictPropertyData.get("NAV.UP.MANAGEENTITY.EDIT.ACCESS.LABEL.TENANCY");
		sPermissionAcessList =sPermissionAcessList + (String)FrameworkUtil.dictPropertyData.get("NAV.UP.MANAGEENTITY.EDIT.ACCESS.LABEL.TICKETS");
		sPermissionAcessList =sPermissionAcessList + (String)FrameworkUtil.dictPropertyData.get("NAV.UP.MANAGEENTITY.EDIT.ACCESS.LABEL.USERINFO");
		sPermissionAcessList =sPermissionAcessList + (String)FrameworkUtil.dictPropertyData.get("NAV.UP.MANAGEENTITY.EDIT.ACCESS.LABEL.VM");
		sPermissionAcessList =sPermissionAcessList + (String)FrameworkUtil.dictPropertyData.get("NAV.UP.MANAGEENTITY.EDIT.ACCESS.LABEL.VPN");
		
*/		UserPermissionManageEntityTestCase.clickonEditCopyIconManageEntity(sParentEntity, sChildEntity, "edit");
		//UserPermissionManageEntityTestCase.editPermissionManageEntity(sPermissionAcessList, true, true);
		
	      if(WebObjectUtil.verifyElementPresent(UserPermission.getNav_Users_ManageEntityEditParentWebTable())){
	            WebObjectUtil.selectCheckRadioBox(UserPermission.getNav_EM_Edit_ExpandAllCheckBox());
	            WebObjectUtil.explicitWait(3);
	            CustomWebElementUtil.loadCustomElement(UserPermission.getNav_Users_ManageEntityEditParentWebTable(), "table");

	            for (int r=2;r<=CustomWebElementUtil.iRowCount;r++){
	                  wEditPermissionLabel = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "UP.ENTITYMGMT.EDIT.PERMISSIONTREE.CHECKBOX.LABEL", "PARAMETER_ROWNUMBER",r+"");
	                  sPermissionNameActual = wEditPermissionLabel.getText().trim();
	                  
			            wEditPermissionExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "UP.ENTITYMGMT.EDIT.PERMISSIONTREE.EXPANDER", "PARAMETER_ROWNUMBER",r+"");
			            sLabelAttribute = wEditPermissionExpander.getAttribute("class"); 
			            if (!sLabelAttribute.contains("x-tree-expander")){
	                        wEditPermissionCheckbox = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "UP.ENTITYMGMT.EDIT.PERMISSIONTREE.CHECKBOX", "PARAMETER_ROWNUMBER",r+"");
	                        sClassAttribute = wEditPermissionCheckbox.getAttribute("class");
	                     
	                        	if (!sClassAttribute.contains("checkbox-checked")){
	                        		wEditPermissionCheckbox.click();
	                        		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Provide access", "pass", "Access provided :" + sPermissionNameActual);
	                        		bFlag=true;
	                        		
	                        	}else{
	                        		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Provide access", "done", "Access already Exist :" + sPermissionNameActual);
	                        		
	                        	}
			            }

	            }
	
	            if (bFlag){
	            	WebObjectUtil.explicitWait(3);
	            	if (bCascadeChild==true && WebObjectUtil.isElementPresent(ManageEntity.getNav_EditEntityCascadeToChilderenCheckBox())){
	  		    	  WebObjectUtil.clickElement(ManageEntity.getNav_EditEntityCascadeToChilderenCheckBox());
	  		      	}
	                  WebObjectUtil.clickElement(UserPermission.getNav_EM_Edit_SaveBtn());
	                  WebObjectUtil.explicitWait(2);
	                  //sActSuccMsg=CommonPF.getNav_CommonPopUpMessage().getText();
	                 //System.out.println(CommonPF.getNav_CommonPopUpMessage().getText());
	                  WebObjectUtil.clickElement(Common.getNav_CommonPopUpOKButton());
	                  WebObjectUtil.explicitWait(3);
	                  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Edit Permission MangeEntity", "pass", "Permission Edited" + Common.getNav_CommonPopUpMessage().getText());      
	            }else{
	                  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Edit Permission MangeEntity", "warn", "There are no change in permission, might be permission already provided/removed");
	                  WebObjectUtil.clickElement(UserPermission.getNav_nav_EM_Edit_CancelBtn());
	            }
	      }  
		
	}

	
	/*==============================================================
	Method Name       : ValManageEntityCopyFunction
	Description       : It will copy to destination
	Author            : Vivek Kumar
	Creation Date     : 11/17/2015
	Pre-Requisites    :
	Revision History:
	==============================================================*/
	public static void valManageEntityCopyFunction(String sEntity,String sDestination,boolean bFlag)
	{
		
		int iRowCount,iRowNo=0;
		WebElement wDest;
		String sConfirmMsg,sExpectedMessage,sActualMessage;
		boolean bStatus;
		
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, ManageEntity);
		PageFactory.initElements(driver, Common);
		PageFactory.initElements(driver, UserPermission);
		
		try {
			//User feedback message will change based on cascade checkbox, so fixing the same based on bFlag value.
			if(bFlag)
			{
				sExpectedMessage="Successfully copied permissions from "+sEntity+" to "+sDestination +" and its children";
			}
			else
			{
				sExpectedMessage="Successfully copied permissions from "+sEntity+" to "+sDestination;
			}
			//Clicking on Copy button
			UserPermissionManageEntityTestCase.clickonEditCopyIconManageEntity(sEntity, null, "copy");
			WebObjectUtil.explicitWait(5);
			//Click on Dropdown arrow
			WebObjectUtil.clickElement(ManageEntity.getNav_DestEntityDropDownArrow());
			WebObjectUtil.explicitWait(5);
			
			
			//sDestination="TST Entity04";
			
			
			WebObjectUtil.clickElement(ManageEntity.getNav_ManageEntityCopyEdit());
			WebObjectUtil.explicitWait(1);
			WebObjectUtil.clickElement(ManageEntity.getNav_ManageEntityCopyEdit());
			WebObjectUtil.explicitWait(1);
			WebObjectUtil.clickElement(ManageEntity.getNav_ManageEntityCopyEdit());
			WebObjectUtil.explicitWait(1);
			WebObjectUtil.SetValueEdit(ManageEntity.getNav_ManageEntityCopyEdit(),sDestination );
			WebObjectUtil.explicitWait(1);
			//Loading the table
			CustomWebElementUtil.loadCustomElement(ManageEntity.getNav_CopyDestParentWebTable(), "table");
			//Getting the row count
			iRowCount=CustomWebElementUtil.iRowCount;
			
			//Looping and clicking on the Destination
			//for(int k=1;k<iRowCount;k++)
			for (WebElement wb : CustomWebElementUtil.rowsWebElementList)
			{
				iRowNo++;
/*	         	//WebElement wDest=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTreePanelPickerTree']//table["+k+"]/tbody/tr/td/div/span", "Copy DropDown");
				//wDest= WebObjectUtil.getWebElementFromDynamicLocator("xpath", "UP.MANAGEENTITY.COPY.DESTINATION", "PARAMETER_ROWNUMBER", k+"");
				wDest= WebObjectUtil.getWebElementFromDynamicLocator("xpath", "UP.MANAGEENTITY.COPY.DESTINATION", "PARAMETER_ROWNUMBER", iRowNo+"");
				//WebObjectUtil.MouseHover(wDest);
*/

				if(wb.getText().trim().equalsIgnoreCase(sDestination))
				{
					wDest= WebObjectUtil.getWebElementFromDynamicLocator("xpath", "UP.MANAGEENTITY.COPY.DESTINATION", "PARAMETER_ROWNUMBER", iRowNo+"");
					wDest.click();
					WebObjectUtil.explicitWait(5);
					
					//Verifying Submit,Cancel Button and Cascade CheckBox
					WebObjectUtil.verifyElementPresent(ManageEntity.getNav_EM_Copy_CascadeChkBox());
					WebObjectUtil.verifyElementPresent(UserPermission.getNav_EM_Edit_CancelBtn());
					WebObjectUtil.verifyElementPresent(ManageEntity.getNav_CopyDialogSubmitBtn());
					
					//Checking the cascade check box based on bFlag status
					WebObjectUtil.explicitWait(2);
					if(bFlag){
						WebObjectUtil.selectCheckRadioBox(ManageEntity.getNav_EM_Copy_CascadeChkBox());
					}
					
					//Clicking on submit button
					WebObjectUtil.explicitWait(2);
					WebObjectUtil.clickElement(ManageEntity.getNav_CopyDialogSubmitBtn());
					
					//Verifying pop confirmation
					WebObjectUtil.waitForElementPresent(Common.getNav_CommonPopUp());
					if(WebObjectUtil.isElementPresent(Common.getNav_CommonPopUp()))
					{
						sConfirmMsg=Common.getNav_CommonPopUpMessage().getText().trim();
						bStatus=sExpectedMessage.equals(sConfirmMsg);
						FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "PopUp Message -  "+sConfirmMsg);
						WebObjectUtil.clickElement(Common.getNav_CommonPopUpOKButton());
					}
					//Verifying the FeedBack message
					sActualMessage=Common.getNav_UsrFeedBack().getText().trim();
					bStatus=sExpectedMessage.equals(sActualMessage);
					FrameworkUtil.updateCustomResultBasedOnStatus(bStatus,"Actual Message -" +sActualMessage + "    Expected Message -" +sExpectedMessage);
					break;
				}
			}
			
			
		} catch (Exception e) {
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
	}
		
	 /*====================================================================================================
	  Method Name 		: verifyColorEachRowManageEntity
	  Description		: Verify the color pattern is White - Blue - White - Blue for given table
	  Author 			: Arul
	  Creation Date 	: 11/19/2015
	  Pre-Requisites	:
	  Revision History:
	  =====================================================================================================*/


	  public static int verifyColorEachRowTable(WebElement wWebTableElement,String sRoworTRTagClassValue, boolean bUseTRTag)
	  {
	  	           int iEMOrgRowNo=0,iTableCount = 0,iTempRowNo=4;
	  	           WebElement wOrgElement,wEntityexpander, wRowAsElement = null,wBtnIcon,wTrTagElement;
	  	           String sGetAttribute;
	  	           boolean bBlueColor=false;
	  	     
		     try {
		    	CustomWebElementUtil.loadCustomElement(wWebTableElement, "table");
	  			iTableCount = CustomWebElementUtil.iRowCount;
	  			wRowAsElement=CustomWebElementUtil.getRowAsWebElement(1);
	  			sGetAttribute = wRowAsElement.getAttribute("class");
	  			if (bUseTRTag){
	  			try {
					wTrTagElement = wRowAsElement.findElement(By.xpath("//tbody/tr[contains(@class,'-back')]"));
					if (wTrTagElement != null){
						sGetAttribute = wTrTagElement.getAttribute("class");
					}
				} catch (Exception e) {

				}
	  			}
					if (sGetAttribute.contains(sRoworTRTagClassValue)){
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verify Color of Row", "done", "First Row is Blue in Color, Row content: " + wRowAsElement.getText());
						bBlueColor=false;
					}else{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verify Color of Row", "done", "First Row is White in Color,  Row content:" + wRowAsElement.getText());
						bBlueColor=true;
					}
	  			
	  			for (int iRowNo=2; iRowNo<=iTableCount;iRowNo++){
	  				wRowAsElement=CustomWebElementUtil.getRowAsWebElement(iRowNo);
	  				//System.out.println(wRowAsElement.getText());
	  				sGetAttribute = wRowAsElement.getAttribute("class");
	  				if (bUseTRTag){
	  		  			try {
	  						//wTrTagElement = wRowAsElement.findElement(By.xpath("//tbody/tr[contains(@class,'-back')]"));
	  						//wTrTagElement = WebObjectUtil.GetWebElement("xpath", "//div[@id='wsCtlgs-body']//table["+ iRowNo +"]/tbody/tr[contains(@class,'-back')]", "TR Color locator");
	  						wTrTagElement = wWebTableElement.findElement(By.xpath("//table["+ iRowNo +"]/tbody/tr[contains(@class,'-back')]"));
	  						if (wTrTagElement != null){
	  							//System.out.println(wTrTagElement.getAttribute("class"));
	  							sGetAttribute = wTrTagElement.getAttribute("class");
	  						}
	  					} catch (Exception e) {

	  					}
	  		  		}
	  				if (sGetAttribute.contains(sRoworTRTagClassValue) ){
	  					if(bBlueColor){
	  					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verify Color of Row", "pass", iRowNo+" Row is Blue in Color,  Row content:" + wRowAsElement.getText() );
	  					bBlueColor=false;
	  					}else{
	  						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verify Color of Row", "fail", iRowNo+" Row is Blue in Color, but expected is White color,  Row content:" + wRowAsElement.getText());
	  	  					bBlueColor=true;
	  	  				}
	  				}else{
	  					if(!bBlueColor){
	  					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verify Color of Row", "pass", iRowNo+" Row is White in Color,  Row content:" + wRowAsElement.getText());
	  					bBlueColor=true;
	  					}else{
	  						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verify Color of Row", "fail", iRowNo+" Row is White in Color, but expected is Blue color,  Row content:" + wRowAsElement.getText());
	  	  					bBlueColor=false;
	  	  				}
	  				}
	  			}
				

				
	  		} catch (Exception e) {
	  			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName + e.getMessage());
	  			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyColorEachRowManageEntity", "warn", "catch block:" +e.getMessage());
	  		}
	  	     return iEMOrgRowNo;
	  	     
	  } 
	  
	  /*==============================================================
		Method Name       : valDestPermissionLstandChkBox
		Description       : Validating the Permission label name and the check box status that copied from src
		Author            : Vivek Kumar
		Creation Date     : 11/18/2015
		Pre-Requisites    :
		Revision History:
		==============================================================*/
		public static void valDestPermissionLstandChkBox(String[][] aPermissionLstwithChkBox,String sDestination,String sChild)
		{
			
			String flag,sPermissionNameActual,sClassAttribute,sLabelAttribute;
			boolean bStatus=false;
			int iRowCnt;
			
			
			try {
				//Clicking on Edit pencil link
				UserPermissionManageEntityTestCase.clickonEditCopyIconManageEntity(sDestination, sChild, "edit");	
				//checking Expand All checkbox
				WebObjectUtil.selectCheckRadioBox(ManageEntity.getNav_ManageEntityEdit_ExpandAllCheckbox());
				
				//loading the Edit Permission webtable
				CustomWebElementUtil.loadCustomElement(UserPermission.getNav_Users_ManageEntityEditParentWebTable(), "table");
				//Getting the count
				iRowCnt=CustomWebElementUtil.iRowCount;
				for(int i=1;i<=iRowCnt;i++)
					{
						WebElement wEditPermissionLabel = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "UP.ENTITYMGMT.EDIT.PERMISSIONTREE.CHECKBOX.LABEL", "PARAMETER_ROWNUMBER",i+"");
				        sPermissionNameActual = wEditPermissionLabel.getText().trim();
				        

				        
				       //Comparing with src Permission level and Dest Permission level
				        if(sPermissionNameActual.equals(aPermissionLstwithChkBox[i-1][0]))
				        {
				        	FrameworkUtil.updateCustomResultBasedOnStatus(true, "Src - " + (aPermissionLstwithChkBox[i-1][0]) + "/Dest - "+sPermissionNameActual);
				        	//======================================================================
				            WebElement wEditPermissionExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "UP.ENTITYMGMT.EDIT.PERMISSIONTREE.EXPANDER", "PARAMETER_ROWNUMBER",i+"");
				            sLabelAttribute = wEditPermissionExpander.getAttribute("class"); 
				            if (!sLabelAttribute.contains("x-tree-expander")){
				        	WebElement wEditPermissionCheckbox = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "UP.ENTITYMGMT.EDIT.PERMISSIONTREE.CHECKBOX", "PARAMETER_ROWNUMBER",i+"");
				             if(wEditPermissionCheckbox!=null)
				             {
				             	sClassAttribute = wEditPermissionCheckbox.getAttribute("class");
				             	if (sClassAttribute.contains("checkbox-checked")){
				             		flag="true";
				             		bStatus= (aPermissionLstwithChkBox[i-1][1]).equals(flag);
				             		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Src - " + (aPermissionLstwithChkBox[i-1][1]) + "/Dest - "+flag);
				             	}
				             	else
				             	{
				             		flag="false";
				             		bStatus=(aPermissionLstwithChkBox[i-1][1]).equals(flag);
				             		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Src - " + (aPermissionLstwithChkBox[i-1][1]) + "/Dest - "+flag);
				             	}
				             }
				             else
				             {
				            	 flag=null;
				            	// System.out.println(multD[i-1][1].trim());
				            	// String a=multD[i-1][1].trim();
				            	 bStatus= (aPermissionLstwithChkBox[i-1][1])==(flag);
				             	FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Src - " + (aPermissionLstwithChkBox[i-1][1]) + "/Dest - "+flag);
				             }
				        }
				        	//======================================================================
				        }
				        else
				        {
				        	System.out.println("Fail - "+sPermissionNameActual);
				        }
				    }
				//Clicking on Cancel button
				WebObjectUtil.clickElement(ManageEntity.getNav_EM_Edit_CloseIcon());
			} catch (Exception e) {
				LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
			} 
	    }
		
	
	//update each @test result in custom result file
			@AfterMethod
	public static void afterEachMethod(){
			FrameworkUtil.updateTestCaseStatusinResult();
				
	 }
	 
				
	
	
	
}
