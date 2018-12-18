package com.whs.navigator.testcases.valen;

import java.util.List;

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
import com.whs.navigator.pagefactory.EVDC_StorageProfilePageFactory;
import com.whs.navigator.pagefactory.EVDC_VM_PageFactory;
import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.UserPermissionManageEntityPageFactory;
import com.whs.navigator.pagefactory.UserPermissionPageFactory;
import com.whs.navigator.testcases.EVDC_StorageProfileTestCase;
import com.whs.navigator.testcases.EVDC_VM_AdvancedActions;
import com.whs.navigator.testcases.EVDC_VM_TestCase;
import com.whs.navigator.testcases.LoginTestCase_Old1;
import com.whs.navigator.testcases.NavigatorCommonMethods;
import com.whs.navigator.testcases.TicketTestCase;
import com.whs.navigator.testcases.UserPermissionManageEntityTestCase;
import com.whs.navigator.testcases.UserPermissionTestCase;

public class ValenTestCase_Vivek {
	
	public static EVDC_StorageProfilePageFactory EVDC_Storage = new EVDC_StorageProfilePageFactory();
	static UserPermissionPageFactory UserPermission = new UserPermissionPageFactory();
	public static UserPermissionManageEntityPageFactory  ManageEntity =  new UserPermissionManageEntityPageFactory();
	public static EVDC_OverviewPageFactory EVDC_OverviewPF = new EVDC_OverviewPageFactory();
	public static CommonPageFactory Common = new CommonPageFactory();
	public static HomePageFactory_old Home = new HomePageFactory_old();
	public static EVDC_VM_PageFactory EVDC_VMPF= new EVDC_VM_PageFactory();
	

	@Test
	public void login()
	{
		LoginTestCase_Old1.nav_TierPointLogin("QaAuto", "P@$$word");
		System.out.println("hello");
	}
	
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
	
	FrameworkUtil.sTestCaseName = "Valen-valLegacyOrgNotViewQuatoBtn";
	FrameworkUtil.sManualTestCaseName="QAT-1648 - WCP_5452_TC_1.4_Elastic Storage->Legacy org";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	
	sEVDCName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.EVDC.11GIRAFFE.ORG.NAME");
	
	//Login to Navigator as GirUser - Legacy Org
	LoginTestCase_Old1.LoginAsGirUser();
	
	//Click on Andover EVDC link
	wEVDC_Org=EVDC_VM_TestCase.getEVDCNameAsWebElement(sEVDCName);
	WebObjectUtil.clickElement(wEVDC_Org);
	
	//Click on Storage Profile
	WebObjectUtil.clickElement(EVDC_Storage.getNav_StorageLink());
	
	//Validating Quota  Button - should not visible for Legacy User
	iQuotaBtnCnt=EVDC_Storage.getNav_StorageProfileQuotaButton().size();
	FrameworkUtil.updateCustomResultBasedOnStatus((iQuotaBtnCnt==0), "Verify Quota Button not present");
	
	//Log Out
	LoginTestCase_Old1.nav_Logout();
	
	
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
	try {
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, UserPermission);
		PageFactory.initElements(driver, EVDC_OverviewPF);
		PageFactory.initElements(driver, EVDC_Storage);
		
		String sRoleObserver,sOrgNameToVerify,sOrgNameToSelect,sUserName;
		int iDeleteBtnCnt;
			
		FrameworkUtil.sTestCaseName = "Valen-valRoleENotViewDelBtn";
		FrameworkUtil.sManualTestCaseName="QAT-1640 - WCP_5509_TC_1.2_Delete a Storage Tier via Ticket_view delete icon_Role-E";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		sRoleObserver = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.OBSERVER");
		sUserName= (String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.USERID.QAAUTOE");
		sOrgNameToVerify=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTQAAUTO");
		sOrgNameToSelect=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTQAAUTO_2858");
		
		setPreConditionRoleChange(sUserName,sRoleObserver,sOrgNameToVerify,sOrgNameToSelect);
		
		//Login back as QaAuto-e
		LoginTestCase_Old1.LoginAsQaautoEUser();
		
		//Navigate to Storage Profile
		WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
		WebObjectUtil.clickElement(EVDC_Storage.getNav_StorageLink());
		
		//Validating Del  Button - should not visible for Observer
		iDeleteBtnCnt=EVDC_Storage.getNav_StorageProfileBlkDelBtn().size();
		FrameworkUtil.updateCustomResultBasedOnStatus((iDeleteBtnCnt==0), "Verify Delete Button not present");
		
		//Log Out
		LoginTestCase_Old1.nav_Logout();
	} catch (Exception e) {
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyFAQPageDisplay", "warn", "catch block:" +e.getMessage());
	}
	
}

/*==============================================================
TestScript  	: valRoleCnADelBtnVisible
Manual TestCase	: QAT-1635- QAT-1634-WCP_5509_TC_1.1_Delete a Storage Tier via Ticket_view delete icon_Role-C
Description		: Verify Full Server user (Role-c) is able to see the Delete button for a Storage Tier. 
Note			: Every org who has storage tier will have Delete button. 
				  Since this will create a ticket, this functionality is not whitelisted to any specific org.
Author 			: Vivek Kumar
Creation Date 	: 08/03/2016
Pre-Requisites	:
Release	Name	: Valen
Revision History:
==============================================================*/
@Test(priority=3)
public void valRoleCnRoleADelBtnVisible()
{
	FrameworkUtil.sTestCaseName = "Valen-valRoleCnRoleADelBtnVisible";
	FrameworkUtil.sManualTestCaseName="QAT-1635-QAT-1634-WCP_5509_TC_1.1_Delete a Storage Tier via Ticket_view delete icon_Role-C and with Role-A";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	
	String sRoleObserver,sUserName,sOrgNameToVerify,sOrgNameToSelect;
	
	try {

			sRoleObserver = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.USER");
			sUserName= (String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.USERID.QAAUTOC");
			sOrgNameToVerify=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTQAAUTO");
			sOrgNameToSelect=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTQAAUTO_2858");
			
			setPreConditionRoleChange(sUserName,sRoleObserver,sOrgNameToVerify,sOrgNameToSelect);
		
			//Login back as QaAuto-C
			LoginTestCase_Old1.LoginAsQaautoCUser();
			
			//Navigate to Storage Profile page
			EVDC_StorageProfileTestCase.navigateToStorageTierPage();
			
			//Validating Delete Btn for each storage blk
			navValidateDelBtnStorageBlk();
			
			//Log Out
			LoginTestCase_Old1.nav_Logout();
			

			sRoleObserver = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.ADMIN");
			sUserName= (String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.USERID.QAAUTOA");
			sOrgNameToVerify=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTQAAUTO");
			sOrgNameToSelect=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTQAAUTO_2858");
			
			setPreConditionRoleChange(sUserName,sRoleObserver,sOrgNameToVerify,sOrgNameToSelect);
			
			//Login back as QaAuto-A
			LoginTestCase_Old1.LoginAsQaautoAUser();
			
			//Navigate to Storage Profile page
			EVDC_StorageProfileTestCase.navigateToStorageTierPage();
			
			//Validating Delete Btn for each storage blk
			navValidateDelBtnStorageBlk();
			
			//Log Out
			LoginTestCase_Old1.nav_Logout();
	} catch (Exception e) {
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyFAQPageDisplay", "warn", "catch block:" +e.getMessage());
	}
			
}

/*==============================================================
TestScript  	: valUserCannotSeeAddDeleteQuota
Manual TestCase	: QAT-1646-WCP_5452_TC_1.2_Elastic Storage->Full service Observer-> View Add Storage Tier, Quota and Delete
Description		: Verify that full service Observer is unable to view Add Storage Tier link, Quota & Delete buttons
Note			: Tst Racestop3 org has proper data setup for Elastic storage tiers.
Author 			: Vivek Kumar
Creation Date 	: 08/03/2016
Pre-Requisites	:
Release	Name	: Valen
Revision History:
==============================================================*/
@Test(priority=4)
public void valUserCannotSeeAddDeleteQuota()
{
	int iDeleteBtnCnt,iQuotaBtnCnt;
	
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EVDC_OverviewPF);
	PageFactory.initElements(driver, EVDC_Storage);
	
	String sRoleObserver,sUserName,sOrgNameToVerify,sOrgNameToSelect;
	
	FrameworkUtil.sTestCaseName = "Valen-valUserCannotSeeAddDeleteQuota";
	FrameworkUtil.sManualTestCaseName="QAT-1646-WCP_5452_TC_1.2_Elastic Storage->Full service Observer-> View Add Storage Tier, Quota and Delete";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	
	try {
		sRoleObserver = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.OBSERVER");
		sUserName= (String)FrameworkUtil.dictPropertyData.get("NAV.TST.RACESTOP3.USERID.RACING3T");
		sOrgNameToVerify=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTRACESTOP");
		sOrgNameToSelect=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTRACESTOP3_3166");
		
		setPreConditionRoleChange(sUserName,sRoleObserver,sOrgNameToVerify,sOrgNameToSelect);
			
		//Login back as QaAuto-C
		LoginTestCase_Old1.LoginAsRacing3tUser();
		
		//Navigate to Storage Profile page
		WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
		WebObjectUtil.clickElement(EVDC_Storage.getNav_StorageLink());
		
		//Validating Del  Button - should not visible for Observer
		iDeleteBtnCnt=EVDC_Storage.getNav_StorageProfileBlkDelBtn().size();
		FrameworkUtil.updateCustomResultBasedOnStatus((iDeleteBtnCnt==0), "Verify Delete Button not present");
		
		//Validating Quota Btn not there for any Storage 
		iQuotaBtnCnt=EVDC_Storage.getNav_StorageProfileQuotaButton().size();
		FrameworkUtil.updateCustomResultBasedOnStatus((iQuotaBtnCnt==0), "Verify Quota Button not present");
		
		//Validate Add Storage Link not present
		WebObjectUtil.verifyElementNOTPresent(EVDC_Storage.getNav_AddStoraegTeirLink());
		
		//Log Out
		LoginTestCase_Old1.nav_Logout();
	} catch (Exception e) {
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyFAQPageDisplay", "warn", "catch block:" +e.getMessage());
	}
	
}

/*==============================================================
TestScript  	: valUserViewQuotaDelnAddTierLnk
Manual TestCase	: QAT- 1645-QAT- 1644WCP_5452_TC_1.1_Elastic Storage->Full service User-> View Add Storage Tier, Quota and Delete
Description		: Verify that full service user is able to view Add Storage Tier link, Quota & Delete buttons 
Note			: Tst Racestop3 org has proper data setup for Elastic storage tiers.
Author 			: Vivek Kumar
Creation Date 	: 08/04/2016
Pre-Requisites	:
Release	Name	: Valen
Revision History:
==============================================================*/
@Test(priority=5)
public void valUserViewQuotaDelnAddTierLnk()
{
	
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EVDC_Storage);
	
	String sRoleObserver,sUserName,sOrgNameToVerify,sOrgNameToSelect;
	
	FrameworkUtil.sTestCaseName = "Valen-valUserViewQuotaDelnAddTierLnk";
	FrameworkUtil.sManualTestCaseName="QAT- 1645-QAT-1644-WCP_5452_TC_1.1_Elastic Storage->Full service User-> View Add Storage Tier, Quota and Delete";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	
	try {
		sRoleObserver = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.USER");
		sUserName= (String)FrameworkUtil.dictPropertyData.get("NAV.TST.RACESTOP3.USERID.ABHI.RACESTOP");
		sOrgNameToVerify=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTRACESTOP");
		sOrgNameToSelect=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTRACESTOP3_3166");
		
		setPreConditionRoleChange(sUserName,sRoleObserver,sOrgNameToVerify,sOrgNameToSelect);
		
		//Login back as AbhiRace Stop
		LoginTestCase_Old1.LoginAsAbhiRaceStopUser();
		
		//Navigate to Storage Profile page
		EVDC_StorageProfileTestCase.navigateToStorageTierPage();
		
		//Validating Delete Btn for each storage blk
		navValidateDelBtnStorageBlk();
		
		//Validating Quota Btn for each storage blk
		navValidateQuotaBtnStorageBlk();
		
		//Validating Add Tier link
		WebObjectUtil.verifyElementPresent(EVDC_Storage.getNav_AddStoraegTeirLink());
		
		//Log Out
		LoginTestCase_Old1.nav_Logout();
		
		//===========================RaceStop.user===============================================
		
		sRoleObserver = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.ADMIN");
		sUserName= (String)FrameworkUtil.dictPropertyData.get("NAV.TST.RACESTOP3.USERID.RACESTOP.USER");
		sOrgNameToVerify=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTRACESTOP");
		sOrgNameToSelect=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTRACESTOP3_3166");
		
		setPreConditionRoleChange(sUserName,sRoleObserver,sOrgNameToVerify,sOrgNameToSelect);
		
		//Login back as AbhiRace Stop
		LoginTestCase_Old1.LoginAsRaceStopUser();
		
		//Navigate to Storage Profile page
		EVDC_StorageProfileTestCase.navigateToStorageTierPage();
		
		//Validating Delete Btn for each storage blk
		navValidateDelBtnStorageBlk();
		//Validating Quota Btn for each storage blk
		navValidateQuotaBtnStorageBlk();
		
		//Validating Add Tier link
		WebObjectUtil.verifyElementPresent(EVDC_Storage.getNav_AddStoraegTeirLink());
		
		//Log Out
		LoginTestCase_Old1.nav_Logout();
		
	} catch (Exception e) {
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyFAQPageDisplay", "warn", "catch block:" +e.getMessage());
	}
	
}

/*==============================================================
TestScript  	: valDelStorageProfilewithAllocatedValue
Manual TestCase	: QAT-1641-WCP_5509_TC_2.0_Delete a Storage Tier via Ticket_tier with allocated values
Description		: When a user clicks on delete icon for a storage tier who has allocated values, verify a popup message is displayed for confirmation. 
				  User can then choose the option 'yes' or 'no' to proceed further.
Note			: Every org who has storage tier will have Delete button. Since this will create a ticket, this functionality is not whitelisted to any specific org.
Author 			: Vivek Kumar
Creation Date 	: 08/05/2016
Pre-Requisites	:
Release	Name	: Valen
Revision History:Earlier the queue name was Storage and now it isVirtualization
==============================================================*/
@Test(priority=6)
public void valDelStorageProfilewithAllocatedValue()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EVDC_Storage);
	PageFactory.initElements(driver, Common);
	
	int iAllocatedValCnt = 0,iAllocatedVal,iRowNum;
	List<WebElement> wAllocatedList;
	String sAllocatedVal, sExpectedMsg,sActualMsg,sFeedBackMsg,sTicketId,sQueueName,sRoleObserver,sUserName;
	String sOrgNameToVerify,sOrgNameToSelect;
	String[] sAllocated,aFeedBackMsg;
	WebElement wDeleteBtn,wQueueName;
	
	FrameworkUtil.sTestCaseName = "Valen-valDelStorageProfilewithAllocatedValue";
	FrameworkUtil.sManualTestCaseName="QAT-1641-WCP_5509_TC_2.0_Delete a Storage Tier via Ticket_tier with allocated values";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	
	sExpectedMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.STORAGEPROFILE.POPUP.CONFIRM.MESSAGE");
	sRoleObserver = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.ADMIN");
	sUserName= (String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.USERID.QAAUTOA");
	sOrgNameToVerify=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTQAAUTO");
	sOrgNameToSelect=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTQAAUTO_2858");
	
	setPreConditionRoleChange(sUserName,sRoleObserver,sOrgNameToVerify,sOrgNameToSelect);
	
	//Login Navigator using QaAuto-a as user
	LoginTestCase_Old1.LoginAsQaautoAUser();
	
	//Navigate to StorageProfile
	EVDC_StorageProfileTestCase.navigateToStorageTierPage();
	
	wAllocatedList=EVDC_Storage.getNav_StorageProfileAllocatedValueSVG();
	for (WebElement wb:wAllocatedList ){
		
		sAllocatedVal = wb.getText();
		sAllocated=sAllocatedVal.split(" ");
		iAllocatedVal = Integer.parseInt(sAllocated[0]);
		if(iAllocatedVal>0){
			break;
		}
		iAllocatedValCnt++;
	}
	//Click on Delete btn
	wDeleteBtn = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.DELETE.BUTTON", "PARAMETER_ROWNUMBER", iAllocatedValCnt+"");
	WebObjectUtil.clickElement(wDeleteBtn);
	
	//Verifying popup message is displayed for confirmation
	sActualMsg=EVDC_Storage.getNav_StorageProfilePopUpConfirmBox().getText().trim();
	FrameworkUtil.updateCustomResultBasedOnStatus(sActualMsg.contains(sExpectedMsg), "Expected Message verified - "+sExpectedMsg + " and Actual message - "+sActualMsg );
	
	//Click on Cancel Btn
	WebObjectUtil.clickElement(Common.getNav_PopUpNoButton());
	
	//Click on Delete Button again
	WebObjectUtil.clickElement(wDeleteBtn);
	
	//Click on Yes button this time
	WebObjectUtil.clickElement(Common.getNav_PopUpYesButton());
	
	//Click on Cancel btn of ticket popup
	WebObjectUtil.clickElement(Common.getNav_PopUpCancelButton());
	
	//Click on Delete Button again
	WebObjectUtil.clickElement(wDeleteBtn);
	
	//Click on Yes button this time
	WebObjectUtil.clickElement(Common.getNav_PopUpYesButton());
	
	//Click on X(close) button of ticket popup
	WebObjectUtil.clickElement(Common.getNav_DialogCloseIcon());
	
	//Click on Delete Button again
	WebObjectUtil.clickElement(wDeleteBtn);
	
	//Click on Yes button this time
	WebObjectUtil.clickElement(Common.getNav_PopUpYesButton());
	
	
	//Submitting the ticket
	NavigatorCommonMethods.submitDialogForCreateTicket("Storage Profile");
	
	//Getting Ticket id from feedback message
	sFeedBackMsg=Common.getNav_UsrFeedBack().getText();
	aFeedBackMsg=sFeedBackMsg.split(":");
	sTicketId = aFeedBackMsg[1].trim();
	
	//Navigate to Ticket Page
	TicketTestCase.navigateToTicketPage();
	
	TicketTestCase.searchTicket("Ticket ID",sTicketId);
	TicketTestCase.SearcResultFound("Ticket ID", 2, sTicketId);
	
	//Expanding 1st found ticket
	iRowNum=1;
	TicketTestCase.expandTable(iRowNum);
	//Verifying that Queue is of type Storage
	sQueueName = WebObjectUtil.getLocatorValueFromProperty("TICKET.TICKETTABLE.EXPANDER.QUEUENAME", "PARAMETER_ROWNUMBER", iRowNum+"");
	wQueueName = WebObjectUtil.GetWebElement("xpath", sQueueName,"QueueName");
	sQueueName=wQueueName.getText().trim();
	FrameworkUtil.updateCustomResultBasedOnStatus(sQueueName.equalsIgnoreCase("Virtualization"), "Validating Queue name is storage");
	
	//Log Out
	LoginTestCase_Old1.nav_Logout();
	
}


/*==============================================================
TestScript  	: valDelStorageProfilewithNoAllocatedValue
Manual TestCase	: QAT-1643-WCP_5509_TC_2.1_Delete a Storage Tier via Ticket_tier with no allocated values
Description		: When a user clicks on delete icon for a storage tier who has no allocated values, verify a Delete storage tier pop up box is displayed.
 				  When a user clicks yes, it creates a ticket and ticket is displayed on a tickets page. 
Note			: Every org who has storage tier will have Delete button. Since this will create a ticket, this functionality is not whitelisted to any specific org.
Author 			: Vivek Kumar
Creation Date 	: 08/08/2016
Pre-Requisites	:
Release	Name	: Valen
Revision History:
==============================================================*/
@Test(priority=7)
public void valDelStorageProfilewithNoAllocatedValue()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EVDC_Storage);
	PageFactory.initElements(driver, Common);
	
	int iAllocatedValCnt = 0,iAllocatedVal,iRowNum,iProfileCnt=0;
	List<WebElement> wAllocatedList, wStorageProfileName;
	String sAllocatedVal, sFeedBackMsg,sTicketId,sQueueName,sRoleObserver,sUserName,sOrgNameToVerify,sOrgNameToSelect;
	String[] sAllocated,aFeedBackMsg;
	WebElement wDeleteBtn,wQueueName;
	boolean bStatus=false;
	
	FrameworkUtil.sTestCaseName = "Valen-valDelStorageProfilewithNoAllocatedValue";
	FrameworkUtil.sManualTestCaseName="QAT-1643-QAT-1643-WCP_5509_TC_2.1_Delete a Storage Tier via Ticket_tier with no allocated values";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	
	sRoleObserver = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.ADMIN");
	sUserName= (String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.USERID.QAAUTOA");
	sOrgNameToVerify=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTQAAUTO");
	sOrgNameToSelect=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTQAAUTO_2858");
	
	setPreConditionRoleChange(sUserName,sRoleObserver,sOrgNameToVerify,sOrgNameToSelect);
	
	//Login Navigator using QaAuto-a as user
	LoginTestCase_Old1.LoginAsQaautoAUser();
	
	//Navigate to StorageProfile
	EVDC_StorageProfileTestCase.navigateToStorageTierPage();
	
	wAllocatedList=EVDC_Storage.getNav_StorageProfileAllocatedValueSVG();
	wStorageProfileName=EVDC_Storage.getNav_StorageProfile_TierNames();
	for (WebElement wb:wAllocatedList ){
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Storage Tier Name", "Get Storage Tier name", "done", wStorageProfileName.get(iProfileCnt).getText());
		sAllocatedVal = wb.getText();
		sAllocated=sAllocatedVal.split(" ");
		iAllocatedVal = Integer.parseInt(sAllocated[0]);
		if(iAllocatedVal==0){
			bStatus=true;
			break;
		}
		iAllocatedValCnt++;
		iProfileCnt++;
	}
	
	if(bStatus)
	{
		//Click on Delete btn
		wDeleteBtn = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.DELETE.BUTTON", "PARAMETER_ROWNUMBER", iAllocatedValCnt+"");
		WebObjectUtil.clickElement(wDeleteBtn);
		
			
		//Click on Cancel btn of ticket popup
		WebObjectUtil.clickElement(Common.getNav_PopUpCancelButton());
		
		//Click on Delete Button again
		WebObjectUtil.clickElement(wDeleteBtn);
		
		//Click on X(close) button of ticket popup
		WebObjectUtil.clickElement(Common.getNav_DialogCloseIcon());
		
		//Click on Delete Button again
		WebObjectUtil.clickElement(wDeleteBtn);
		
		/*//Click on Yes button this time
		WebObjectUtil.clickElement(Common.getNav_PopUpYesButton());*/
		
		
		//Submitting the ticket
		NavigatorCommonMethods.submitDialogForCreateTicket("Storage Profile");
		
		//Getting Ticket id from feedback message
		sFeedBackMsg=Common.getNav_UsrFeedBack().getText();
		aFeedBackMsg=sFeedBackMsg.split(":");
		sTicketId = aFeedBackMsg[1].trim();
		
		//Navigate to Ticket Page
		TicketTestCase.navigateToTicketPage();
		
		TicketTestCase.searchTicket("Ticket ID",sTicketId);
		TicketTestCase.SearcResultFound("Ticket ID", 2, sTicketId);
		
		//Expanding 1st found ticket
		iRowNum=1;
		TicketTestCase.expandTable(iRowNum);
		//Verifying that Queue is of type Storage
		sQueueName = WebObjectUtil.getLocatorValueFromProperty("TICKET.TICKETTABLE.EXPANDER.QUEUENAME", "PARAMETER_ROWNUMBER", iRowNum+"");
		wQueueName = WebObjectUtil.GetWebElement("xpath", sQueueName,"QueueName");
		sQueueName=wQueueName.getText().trim();
		FrameworkUtil.updateCustomResultBasedOnStatus(sQueueName.equalsIgnoreCase("Virtualization"), "Validating Queue name is storage");
		
	}
	else
	{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Storage Profile with no Allocated Value", "fail", "No Storage profile with 0(Zero) allocated value");
	}
	
	//Log Out
	LoginTestCase_Old1.nav_Logout();
}



/*==============================================================
TestScript  	: valDelStorageprofilePermission
Manual TestCase	: QAT- 1647 -WCP_5509_TC_3.0_Delete a Storage Tier via Ticket_Uncheck Delete Storage permission for Role-A
Description		: Full Service Admin user (Role-A) is able to delete storage tier via ticket. But, when Delete Storage Permissions are unchecked at entity level, 
				  verify this user is not able to view the delete button for storage tiers. 
Note			: 
Author 			: Vivek Kumar
Creation Date 	: 08/08/2016
Pre-Requisites	:
Release	Name	: Valen
Revision History:
==============================================================*/
@Test(priority=8)
public void valDelStorageprofilePermission()
{
	String sUserName,sRoleObserver,sOrgNameToVerify,sOrgNameToSelect;
	int iDeleteBtnCnt;
	
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, ManageEntity);
	PageFactory.initElements(driver, UserPermission);
	PageFactory.initElements(driver, Home);
	
	FrameworkUtil.sTestCaseName = "Valen-valDelStorageprofilePermission";
	FrameworkUtil.sManualTestCaseName="QAT- 1647 -WCP_5509_TC_3.0_Delete a Storage Tier via Ticket_Uncheck Delete Storage permission for Role-A";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	
	sRoleObserver = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.ADMIN");
	sUserName= (String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.USERID.QAAUTOA");
	sOrgNameToVerify=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTQAAUTO");
	sOrgNameToSelect=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTQAAUTO_2858");
	
	setPreConditionRoleChange(sUserName,sRoleObserver,sOrgNameToVerify,sOrgNameToSelect);
	
	//Login Navigator using QaAuto-a as user
	LoginTestCase_Old1.LoginAsQaautoAUser();

	//Navigate to Storage Profile page
	EVDC_StorageProfileTestCase.navigateToStorageTierPage();
	
	//Validating Delete Btn for each storage blk
	navValidateDelBtnStorageBlk();
	
	//Navigate to Permission Page
	WebObjectUtil.clickElement(UserPermission.getNav_AccountLink());
	WebObjectUtil.clickElement(UserPermission.getNav_PermissionsLink());
	//Clicking on Manage Entity Tab
	WebObjectUtil.clickElement(ManageEntity.getNav_Users_ManageEntityTab());
	
	//Clicking on Edit pencil link
	UserPermissionManageEntityTestCase.clickonEditCopyIconManageEntity("TST QAauto", null, "edit");
	
	//Unchecking the Permission - Delete Storage
	UserPermissionManageEntityTestCase.editPermissionManageEntity("Delete Storage", false, false);
	
	//Navigating back to Storage Profile
	WebObjectUtil.ClickAndMouseHover(Home.getNav_MonitoringTab());
	WebObjectUtil.clickAndVerifyText(Home.getNav_SummaryViewMenuLink(),"Home");
	EVDC_StorageProfileTestCase.navigateToStorageTierPage();
	
	//Validating Del  Button - should not visible for Observer
	iDeleteBtnCnt=EVDC_Storage.getNav_StorageProfileBlkDelBtn().size();
	FrameworkUtil.updateCustomResultBasedOnStatus((iDeleteBtnCnt==0), "Verify Delete Button not present");
	
	//Log Out
	LoginTestCase_Old1.nav_Logout();
	
}

/*==============================================================
TestScript  	: valUnChkEditStoragePermission
Manual TestCase	: QAT-1765-WCP_5453_TC_3.0.0_Change Quota_Uncheck Edit storage permissions
Description		: When 'Edit storage' permissions are unchecked for an org, 
				  verify users for that org are unable to view Quota button for any tier on storage profiles page.
Note			: 
Author 			: Vivek Kumar
Creation Date 	: 08/10/2016
Pre-Requisites	:
Release	Name	: Valen
Revision History:
==============================================================*/
@Test(priority=9)
public void valUnChkEditStoragePermission()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, ManageEntity);
	PageFactory.initElements(driver, UserPermission);
	PageFactory.initElements(driver, EVDC_Storage);
	PageFactory.initElements(driver, EVDC_OverviewPF);
	PageFactory.initElements(driver, Home);
	
	String sUserName,sRoleObserver,sOrgNameToVerify,sOrgNameToSelect;
	int iQuotaBtnCnt;
	
	FrameworkUtil.sTestCaseName = "Valen-valUnChkEditStoragePermission";
	FrameworkUtil.sManualTestCaseName="QAT-1765-WCP_5453_TC_3.0.0_Change Quota_Uncheck Edit storage permissions";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	
	sRoleObserver = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.ADMIN");
	sUserName= (String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.USERID.QAAUTOA");
	sOrgNameToVerify=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTQAAUTO");
	sOrgNameToSelect=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTQAAUTO_2858");
	
	setPreConditionRoleChange(sUserName,sRoleObserver,sOrgNameToVerify,sOrgNameToSelect);
	
	//Login Navigator using QaAuto-a as user
	LoginTestCase_Old1.LoginAsQaautoAUser();
	
	//Navigate to Permission Page
	WebObjectUtil.clickElement(UserPermission.getNav_AccountLink());
	WebObjectUtil.clickElement(UserPermission.getNav_PermissionsLink());
	//Clicking on Manage Entity Tab
	WebObjectUtil.clickElement(ManageEntity.getNav_Users_ManageEntityTab());
	
	//Clicking on Edit pencil link
	UserPermissionManageEntityTestCase.clickonEditCopyIconManageEntity("TST QAauto", null, "edit");
	
	//Unchecking the Permission - Delete Storage
	UserPermissionManageEntityTestCase.editPermissionManageEntity("Edit Storage", false, false);
	
	//Navigating back to Storage Profile
	WebObjectUtil.ClickAndMouseHover(Home.getNav_MonitoringTab());
	WebObjectUtil.clickAndVerifyText(Home.getNav_SummaryViewMenuLink(),"Home");

	//Navigate to Storage Profile Page
	WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
	WebObjectUtil.clickElement(EVDC_Storage.getNav_StorageLink());
	
	//Validating Quota Btn not there for any Storage 
	iQuotaBtnCnt=EVDC_Storage.getNav_StorageProfileQuotaButton().size();
	FrameworkUtil.updateCustomResultBasedOnStatus((iQuotaBtnCnt==0), "Verify Quota Button not present");
	
	//Log Out
	LoginTestCase_Old1.nav_Logout();
	
}


/*==============================================================
TestScript  	: valUnChkViewStoragePermission
Manual TestCase	: QAT-1764-WCP_5452_TC_1.8_View EVDC Storage Prifiles_uncheck View Permissions
Description		: When 'View storage'permissions are unchecked for an org, 
				  verify users for that org are unable to view storage profiles page..
Note			: 
Author 			: Vivek Kumar
Creation Date 	: 08/11/2016
Pre-Requisites	:
Release	Name	: Valen
Revision History:
==============================================================*/
@Test(priority=10)
public void valUnChkViewStoragePermission()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, ManageEntity);
	PageFactory.initElements(driver, UserPermission);
	PageFactory.initElements(driver, EVDC_Storage);
	PageFactory.initElements(driver, EVDC_OverviewPF);
	PageFactory.initElements(driver, Home);
	
	String sUserName,sRoleObserver,sOrgNameToVerify,sOrgNameToSelect;
	int iStorageProfileBlkCnt;
	
	
	FrameworkUtil.sTestCaseName = "Valen-valUnChkViewStoragePermission";
	FrameworkUtil.sManualTestCaseName="QAT-1764-WCP_5452_TC_1.8_View EVDC Storage Prifiles_uncheck View Permissions";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	
	sRoleObserver = (String)FrameworkUtil.dictPropertyData.get("NAV.USERROLE.ADMIN");
	sUserName= (String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.USERID.QAAUTOA");
	sOrgNameToVerify=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTQAAUTO");
	sOrgNameToSelect=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTQAAUTO_2858");
	
	setPreConditionRoleChange(sUserName,sRoleObserver,sOrgNameToVerify,sOrgNameToSelect);
	
	//Login Navigator using QaAuto-a as user
	LoginTestCase_Old1.LoginAsQaautoAUser();
	
	//Navigate to Permission Page
	WebObjectUtil.clickElement(UserPermission.getNav_AccountLink());
	WebObjectUtil.clickElement(UserPermission.getNav_PermissionsLink());
	//Clicking on Manage Entity Tab
	WebObjectUtil.clickElement(ManageEntity.getNav_Users_ManageEntityTab());
	
	//Clicking on Edit pencil link
	UserPermissionManageEntityTestCase.clickonEditCopyIconManageEntity("TST QAauto", null, "edit");
	
	//Unchecking the Permission - Delete Storage
	UserPermissionManageEntityTestCase.editPermissionManageEntity("View Storage", false, false);
	
	//Navigating back to Storage Profile
	WebObjectUtil.ClickAndMouseHover(Home.getNav_MonitoringTab());
	WebObjectUtil.clickAndVerifyText(Home.getNav_SummaryViewMenuLink(),"Home");

	//Navigate to Storage Profile Page
	WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
	WebObjectUtil.clickElement(EVDC_Storage.getNav_StorageLink());
	
	//Verifyling Storge Profile page should be blank
	iStorageProfileBlkCnt=EVDC_Storage.getNav_StorageProfileBlk().size();
	FrameworkUtil.updateCustomResultBasedOnStatus((iStorageProfileBlkCnt==0), "Verify Delete Button present for each Storage Profile Block");
	WebObjectUtil.verifyElementNOTPresent(EVDC_Storage.getNav_AddStoraegTeirLink());
	
	//Log Out
	LoginTestCase_Old1.nav_Logout();
}

/*==============================================================
TestScript  	: navValAlloctionIncreaseWithNewVM
Manual TestCase	: QAT-1746-WCP_6022_TC_1.0_Storage_allocation value_update when increase allocation for a tier
Description		: When allocation is increased for a storage tier (ex- by adding a new vm using that tier, etc), 
				  verify the allocation increases on the storage profile page for that tier.
Note			: 
Author 			: Vivek Kumar
Creation Date 	: 08/11/2016
Pre-Requisites	:
Release	Name	: Valen
Revision History:
==============================================================*/
@Test(priority=11)
public void navValAlloctionIncreaseWithNewVM()
{
	
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EVDC_Storage);
	PageFactory.initElements(driver, EVDC_OverviewPF);
	PageFactory.initElements(driver, Home);
	PageFactory.initElements(driver, EVDC_VMPF);
	
	List<WebElement> wAllocatedList, wStorageProfileName;
	WebElement wDropdown;
	String sStorageProfileName,sAllocatedValue,sDropdownValue;
	int iStorageAllocatedValue,iIncreaseStorageAllocatedValue;
	String[] aAllocated;
	String sVMName,sFeedBackMsg,sAddVMMessage;
	boolean bDeploy,bStatus=false;
	
	
	FrameworkUtil.sTestCaseName = "Valen-navValAlloctionIncreaseWithNewVM";
	FrameworkUtil.sManualTestCaseName="QAT-1746-WCP_6022_TC_1.0_Storage_allocation value_update when increase allocation for a tier";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	
	sDropdownValue = (String)FrameworkUtil.dictPropertyData.get("NAV.STORAGEPROFILE.ADDVM.DROPDOWN");
	sVMName=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.ADDVM.NAME");
	sFeedBackMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FEEDBACK.MESSAGE");
	sAddVMMessage=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.ADDVM.FEEDBACK.MESSAGE");
	
	sVMName=sVMName + "_" + FrameworkUtil.date_yyyyMMdd()+ "_" + FrameworkUtil.date_HHmmss();
	sAddVMMessage =sAddVMMessage+ " " +"\"" +sVMName+ "\"";
	//Login to Navigator using KirkJ as user
	LoginTestCase_Old1.LoginAsKirkjUser();
	
	//Clicking on EVDC link
	WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
	
	//Clicking on Storage Profile
	WebObjectUtil.clickElement(EVDC_Storage.getNav_StorageLink());
	
	wAllocatedList=EVDC_Storage.getNav_StorageProfileAllocatedValueSVG();
	wStorageProfileName=EVDC_Storage.getNav_StorageProfile_TierNames();
	
	//Capturing Storage Profile Name and its allocated value
	sStorageProfileName=wStorageProfileName.get(0).getText().trim();
	sAllocatedValue = wAllocatedList.get(0).getText();
	aAllocated=sAllocatedValue.split(" ");
	iStorageAllocatedValue = Integer.parseInt(aAllocated[0].trim());
	
	//Clicking on Evdc Overview breadcrumb
	WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCOverViewLink());
	
	//Clicking on Virtual Machine Portlet
	WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
	
	//Adding VM based on Storage profile 
	WebObjectUtil.clickAndVerifyElement(EVDC_VMPF.getNav_AddVMLink(), EVDC_VMPF.getNav_AddVMSelectVMType());
	WebObjectUtil.clickElement(EVDC_VMPF.getNav_VMSelectType());
		
	//Verify the content under WebList and clicking VM from Template
	WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_AddVMBlankVM());
	WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_AddVMfromTemplate());
	WebObjectUtil.clickElement(EVDC_VMPF.getNav_AddVMfromTemplate());
	
	//Verifying the Tab
	WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_AddVMWindstreamObject());
	WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_AddVMPrivateObject());
	
	//Click on Shared Object
	WebObjectUtil.clickElement(EVDC_VMPF.getNav_AddVMWindstreamObject());
	//Clicking on first Template
	WebObjectUtil.clickElement(EVDC_VMPF.getNav_ClickingVMfromTemplate());
	
	//Click on Close button - AddVM popup
	WebObjectUtil.clickElement(EVDC_VMPF.getNav_AddVMTemplatePopupCloseIcon());
	
	//again Clicking on first Template
	WebObjectUtil.clickElement(EVDC_VMPF.getNav_ClickingVMfromTemplate());
	
	//Click on Cancel btn
	WebObjectUtil.clickElement(EVDC_VMPF.getNav_AddVMTemplatePopUpCancelBtn());
	
	//Again Click on the first Template
	WebObjectUtil.clickElement(EVDC_VMPF.getNav_ClickingVMfromTemplate());
	
	WebObjectUtil.SetValueEdit(EVDC_VMPF.getNav_VMBlankVMNameEdit(), sVMName);
	WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_VMBlankStorageProfile());
	WebObjectUtil.ClickAndMouseHover(EVDC_VMPF.getNav_VMBlankVMDropDown());

	//Select from dropdown
	wDropdown = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.ADDVM.STORAGEPROFILE.DROPDOWN", "PARAMETER_ROWNUMBER", sDropdownValue);
	WebObjectUtil.clickElement(wDropdown);

	//Clicking OK Btn
	WebObjectUtil.clickElement(EVDC_VMPF.getNav_VMBlankVMOKBtn());
	WebObjectUtil.explicitWait(8);
	//clicking confirmation - OK Btn
	if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_NewEVDCPopUpBody()))
	{
		WebObjectUtil.clickElement(EVDC_VMPF.getNav_NewEVDCPopUpOKBtn());
	}
	else
	{
		WebObjectUtil.clickElement(EVDC_VMPF.getNav_VMBlankconfirmOKBtn());
	}
	
	//Validating Feedback message
	navValidateFeedBackMessage(sFeedBackMsg,sAddVMMessage,false);
	
	//Verifying deploy state of the recent created VM
	bDeploy=navValidateVMDeploy(sVMName);
	if(bDeploy)
	{
		bStatus=waitForVMStateAfterDeployment(sVMName);
	}
	if(bStatus)
	{
		//Clicking on Evdc Overview breadcrumb
		WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCOverViewLink());
		//Clicking on Storage Profile
		WebObjectUtil.clickElement(EVDC_Storage.getNav_StorageLink());
		
		wAllocatedList=EVDC_Storage.getNav_StorageProfileAllocatedValueSVG();
		wStorageProfileName=EVDC_Storage.getNav_StorageProfile_TierNames();
		
		//Capturing Storage Profile Name and its allocated value
		sStorageProfileName=wStorageProfileName.get(0).getText().trim();
		sAllocatedValue = wAllocatedList.get(0).getText();
		aAllocated=sAllocatedValue.split(" ");
		iIncreaseStorageAllocatedValue = Integer.parseInt(aAllocated[0].trim());
		if(iIncreaseStorageAllocatedValue>iStorageAllocatedValue)
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Validate Storage Profile allocated value" , "pass","Allocated value increase" );
		}
		else
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Validate Storage Profile allocated value" , "fail","Allocated value not increased" );
		}
		
	}
	else
	{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , sVMName + " is not in Stopped State" , "fail","" );
	}
	//Log Out
	LoginTestCase_Old1.nav_Logout();
	
}

/*==============================================================
TestScript  	: navDelQuotaBtnNotForPrivateCld
Manual TestCase	: QAT-1718-QAT-1720-WCP_5509_TC_1.0_Delete a Storage Tier via Ticket_Private Cloud
Description		: Confirm Delete button is not there for storage tiers in Private cloud. 
Note			: 
Author 			: Vivek Kumar
Creation Date 	: 08/12/2016
Pre-Requisites	:
Release	Name	: Valen
Revision History:
==============================================================*/
@Test(priority=12)
public void navDelQuotaBtnNotForPrivateCld()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EVDC_OverviewPF);
	PageFactory.initElements(driver, EVDC_Storage);
	
	int iDeleteBtnCnt,iQuotaBtnCnt;
	
	FrameworkUtil.sTestCaseName = "Valen-navDelQuotaBtnNotForPrivateCld";
	FrameworkUtil.sManualTestCaseName="QAT-1718-1720-WCP_5509_TC_1.0_Delete a Storage Tier via Ticket_Private Cloud";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	
	
	//Login to Navigator using GirUser as user
	LoginTestCase_Old1.LoginAsGirUser();
	
	//Clicking on Private EVDC Link
	WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_PrivateEVDCLink());
	
	//Clicking on Storage Profile
	WebObjectUtil.clickElement(EVDC_Storage.getNav_StorageLink());
	
	//Validating Del  Button - should not visible for Observer
	iDeleteBtnCnt=EVDC_Storage.getNav_StorageProfileBlkDelBtn().size();
	FrameworkUtil.updateCustomResultBasedOnStatus((iDeleteBtnCnt==0), "Verify Delete Button not present");
	
	//Validating Quota  Button - should not visible for Legacy User
	iQuotaBtnCnt=EVDC_Storage.getNav_StorageProfileQuotaButton().size();
	FrameworkUtil.updateCustomResultBasedOnStatus((iQuotaBtnCnt==0), "Verify Quota Button not present");
	
	//LogOut
	LoginTestCase_Old1.nav_Logout();
}


/*==============================================================
TestScript  	: valConsoleFireFox
Manual TestCase	: QAT-1716-WCP_4496_TC_1.1_VM-> VMWare Console-> Firefox
Description		: Verify that Console is displaying correctly in all OS types 
				 (Windows, redhat & Linux) of VMs in Firefox browser. 
Note			: 
Author 			: Vivek Kumar
Creation Date 	: 08/15/2016
Pre-Requisites	:Windows, Redhat and Linux OS VMs should be there in the VM page 
Release	Name	: Valen
Revision History:
==============================================================*/
@Test(priority=13)
public void valConsoleFireFox()
{
	FrameworkUtil.sTestCaseName = "Valen-valConsoleFireFox";
	FrameworkUtil.sManualTestCaseName="QAT-1716-WCP_4496_TC_1.1_VM-> VMWare Console-> Firefox";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	
	String sVMNameorStatus;
	int iRowNbr;
	WebElement wConsole;
	
	 sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.WINDOWS.VMNAME.OR.STATUS");
	
	//Login to Navigator as QAauto-a as user
	LoginTestCase_Old1.LoginAsQaautoAUser();
	
	//============================================
	//Navigate to VM page and expand Window VM
	EVDC_VM_AdvancedActions.navigateAndExpandVM(sVMNameorStatus);	
	
	iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
	EVDC_VM_TestCase.startStoppedVM(iRowNbr);
	
	//Click on console
	wConsole=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.CONSOLE.IMAGE", "PARAMETER_ROWNUMBER", iRowNbr+"");
	WebObjectUtil.clickElement(wConsole);
	
	//Verifying full-screen image
	WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_ConsoleFullScreenImage());
	
	//Pending Fullscreen code
	
	//Closing Console window
	WebObjectUtil.clickElement(EVDC_VMPF.getNav_ConsoleClose());
	
	//============================================
	//Validation of console for Linux VM
	sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS.RUNNING");
	iRowNbr = EVDC_VM_AdvancedActions.getRow_EVDC_VMTable(EVDC_VMPF.getNav_VMWebTableParent(),sVMNameorStatus,"");
	EVDC_VM_TestCase.startStoppedVM(iRowNbr);
	//Click on console
	wConsole=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.CONSOLE.IMAGE", "PARAMETER_ROWNUMBER", iRowNbr+"");
	WebObjectUtil.clickElement(wConsole);
	
	//Verifying full-screen image
	WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_ConsoleFullScreenImage());
	
	//Pending Fullscreen code- for Chrome and Firefox 
	if(WebDriverUtil.browser.equalsIgnoreCase("ie"))
	{
		//Click on Full SCreen image
		WebObjectUtil.clickElement(EVDC_VMPF.getNav_ConsoleFullScreenImage());
		
	}
	
	//Closing Console window
	WebObjectUtil.clickElement(EVDC_VMPF.getNav_ConsoleClose());
	
	//============================================
	//Validation of console for RedHat VM
	sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.REDHAT.VMNAME.OR.STATUS");
	iRowNbr = EVDC_VM_AdvancedActions.getRow_EVDC_VMTable(EVDC_VMPF.getNav_VMWebTableParent(),sVMNameorStatus,"");
	EVDC_VM_TestCase.startStoppedVM(iRowNbr);
	//Click on console
	wConsole=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.CONSOLE.IMAGE", "PARAMETER_ROWNUMBER", iRowNbr+"");
	WebObjectUtil.clickElement(wConsole);
	
	//Verifying full-screen image
	WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_ConsoleFullScreenImage());
	
	//Pending Fullscreen code
	
	//Closing Console window
	WebObjectUtil.clickElement(EVDC_VMPF.getNav_ConsoleClose());
		
	//LogOut
	LoginTestCase_Old1.nav_Logout();	
	
}

//======================================================================================================
//							METHOD
//======================================================================================================

/*====================================================================================================
Method Name 	:waitForVMStateAfterDeployment
Description		: It will wait for deployment of VM
Author 			: Vivek Kumar
Creation Date 	: 08/12/2016
Module Name     : 
Pre-Requisites	: 
Revision History: 

====================================================================================================*/
public boolean waitForVMStateAfterDeployment(String sVMName)
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EVDC_VMPF);	
	
	int iRowNo;
	String sStatusText,sEVDCOrgName;
	boolean bStatus=false;
	int iCnt=0;
	sEVDCOrgName=EVDC_VM_TestCase.navGetEVDCOrgName();
	sVMName=sEVDCOrgName+"-"+sVMName.toLowerCase();
	
	do
	{
		driver.navigate().refresh();
	    WebObjectUtil.explicitWait(5);
	    iCnt=iCnt+5;
	    CustomWebElementUtil.loadCustomElement(EVDC_VMPF.getNav_VMWebTableParent(), "table");
		iRowNo =CustomWebElementUtil.getRowByCellText(sVMName, 1);
		sStatusText = CustomWebElementUtil.getCellData(iRowNo, 5).trim();
	    
		if(WebObjectUtil.compareString("Stopped", sStatusText, false) || iCnt==180)
		{
			bStatus=true;
			break;
		}
		
	}
	
	while(sStatusText.equalsIgnoreCase("Deploying"));
	return bStatus;
	
	
}

/*====================================================================================================
Method Name 	: navValidateVMDeploy
Description		: It will validate deployment of VM
Author 			: Vivek Kumar
Creation Date 	: 08/12/2016
Module Name     : 
Pre-Requisites	: 
Revision History: 

====================================================================================================*/
public static boolean navValidateVMDeploy(String sVMName)
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EVDC_VMPF);
	
	String sEVDCOrgName,sStatusText;
	int iRowNo;
	boolean bFlag=false;
	
	sEVDCOrgName=EVDC_VM_TestCase.navGetEVDCOrgName();
	sVMName=sEVDCOrgName+"-"+sVMName.toLowerCase();
	CustomWebElementUtil.loadCustomElement(EVDC_VMPF.getNav_VMWebTableParent(), "table");
	iRowNo =CustomWebElementUtil.getRowByCellText(sVMName, 1);
	sStatusText = CustomWebElementUtil.getCellData(iRowNo, 5).trim();
	
	
	if(WebObjectUtil.compareString("Deploying", sStatusText, true))
	{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , sVMName + " is Deploying successfully" , "pass","" );
		LoggerUtil.log_type_info(sVMName + " is deployed successfully" );
		bFlag=true;
	}
	else
	{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , sVMName + " is not deployed Successfully" , "fail", "");
		LoggerUtil.log_type_error(sVMName + " is not deployed Successfully"  );
	}
	return bFlag;
	
}

/*====================================================================================================
Method Name 	: navValidateFeedBackMessage
Description		: It will validate feedback message based on parameter provided
Author 			: Vivek Kumar
Creation Date 	: 08/12/2016
Module Name     : 
Pre-Requisites	: 
Revision History: 

====================================================================================================*/
public static boolean navValidateFeedBackMessage(String sExpectedFeedBackMsg, String  sExpectedMsg, boolean bCompare)
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EVDC_VMPF);
	
	String sActualFeedBackMsg = null;
	String sActualMsg = null;
	int iRowCnt;
	WebElement wActualMsg;
	boolean bFlag=false;
	
	if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_NewFeedBackMsg()))
	{
		sActualFeedBackMsg = EVDC_VMPF.getNav_NewFeedBackMsg().getText().trim();
		if(sActualFeedBackMsg.equalsIgnoreCase(sExpectedFeedBackMsg))
		{
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_NewFeedBackMsg());
			if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_NewFeedBackNotificationTablePopup()))
			{
				iRowCnt=WebTableUtil.getRowCount(EVDC_VMPF.getNav_NewFeedBackNotificationTablePopup());
				for(int i=1;i<=iRowCnt;i++)
				{
					sActualMsg=WebTableUtil.getCellData(EVDC_VMPF.getNav_NewFeedBackNotificationTablePopup(), i, 1);
					//Handling string compare based on boolean valu
					if(bCompare)
					{
						if(sActualMsg.equalsIgnoreCase(sExpectedMsg))//handle exact compare too
						{
							bFlag=true;
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verify Feedback message", "pass", "Actual - "+sActualMsg + "  Expected - "+sExpectedMsg );
							break;
						}	
					}
					else
					{
						if(sActualMsg.contains(sExpectedMsg))//handle exact compare too
						{
							bFlag=true;
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verify Feedback message", "pass", "Actual - "+sActualMsg + "  Expected - "+sExpectedMsg );
							break;
						}
					}
					
				}
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_NotificationPopupCloseBtn());
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verify Feedback Notification popup", "fail", "Feedback Notification popup not available");
			}
		}
		else
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verify Feedback message", "fail", "Actual - "+sActualFeedBackMsg + "  Expected - "+sExpectedFeedBackMsg );
		}
	}
	else
	{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verify Feedback message", "fail", "New Feedback message not available");
	}
	return bFlag;
	
	
}


/*====================================================================================================
Method Name 	: navValidateDelBtnStorageBlk
Description		: It will validate that there is delete button for each storage profile block
Author 			: Vivek Kumar
Creation Date 	: 08/03/2016
Module Name     : Valen Release - Storage profile
Pre-Requisites	: 
Revision History: 

====================================================================================================*/
	public void navValidateDelBtnStorageBlk()
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_Storage);
		
		int iDeleteBtnCnt, iStorageProfileBlkCnt;
		
		try {
						
			//Validating Del  Button should present for each Storage profile block 
			iDeleteBtnCnt=EVDC_Storage.getNav_StorageProfileBlkDelBtn().size();
			iStorageProfileBlkCnt=EVDC_Storage.getNav_StorageProfileBlk().size();
			FrameworkUtil.updateCustomResultBasedOnStatus((iDeleteBtnCnt==iStorageProfileBlkCnt), "Verify Delete Button present for each Storage Profile Block");
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyFAQPageDisplay", "warn", "catch block:" +e.getMessage());
		}
	}
	
/*====================================================================================================
Method Name 	: navValidateQuotaBtnStorageBlk
Description		: It will validate that there is Quota button for each storage profile block
Author 			: Vivek Kumar
Creation Date 	: 08/04/2016
Module Name     : Valen Release - Storage profile
Pre-Requisites	: 
Revision History: 

====================================================================================================*/
public void navValidateQuotaBtnStorageBlk()
{
	
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EVDC_Storage);
	
	int iQuotaBtnCnt, iStorageProfileBlkCnt;
	
	try {
		
		//Validating Del  Button should present for each Storage profile block 
		iQuotaBtnCnt=EVDC_Storage.getNav_StorageProfileQuotaButton().size();
		iStorageProfileBlkCnt=EVDC_Storage.getNav_StorageProfileBlk().size();
		FrameworkUtil.updateCustomResultBasedOnStatus((iQuotaBtnCnt==iStorageProfileBlkCnt), "Verify Quota Button present for each Storage Profile Block");
	} catch (Exception e) {
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyFAQPageDisplay", "warn", "catch block:" +e.getMessage());
	}
}

/*====================================================================================================
Method Name 	: setPreCondition
Description		: It will set pre condition based on Manual Test Case
Author 			: Vivek Kumar
Creation Date 	: 08/04/2016
Module Name     : Valen Release - Storage profile
Pre-Requisites	: 
Revision History: 

====================================================================================================*/	
	public void setPreConditionRoleChange(String sUserName,String sRoleName, String sOrgNameToVerify, String sOrgNameToSelect)
	{
		String sAdminUser, sAdminPwd;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, UserPermission);
		/*sOrgNameToVerify=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTQAAUTO");
		sOrgNameToSelect=(String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTQAAUTO_2858");*/
		//Admin Userid and Password
		sAdminUser=(String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.USERID.AROLEA");
		sAdminPwd=(String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.PWD.AROLEA");
		
		//Navigating to User Management page
		UserPermissionTestCase.AccessToUserManagement(sAdminUser,sAdminPwd);
		WebObjectUtil.verifyElementPresent(UserPermission.getNav_UsersTab());
		sUserName=sUserName.toLowerCase();
		//arole-a,arole-c,arole-e,role-a,role-c,role-e
		UserPermissionTestCase.selectOrgFromUserPermission(sOrgNameToVerify,sOrgNameToSelect);
		WebObjectUtil.explicitWait(5);
		UserPermissionTestCase.setUserPermission(sUserName,sRoleName);

		//Log Out
		LoginTestCase_Old1.nav_Logout();
		
	}
	
	
	@AfterMethod
	public static void afterEachMethod(){
			FrameworkUtil.updateTestCaseStatusinResult();
			
		}

}
