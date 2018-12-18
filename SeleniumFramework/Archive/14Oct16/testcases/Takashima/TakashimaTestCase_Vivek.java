package com.whs.navigator.testcases.Takashima;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.CustomWebElementUtil;
import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.commonUtil.WebTableUtil;
import com.whs.navigator.pagefactory.EVDC_VM_PageFactory;


public class TakashimaTestCase_Vivek {
	 
	public static EVDC_VM_PageFactory EVDC_VMPF=new EVDC_VM_PageFactory();
/*==============================================================
TestScript  	: navValidateMultipleEdits
Manual TestCase	: QAT-1591-WCP_4375_TC_1.5_Websockets-> VM-> Edit VM->Multiple Edits 	
				  QAT-1589-WCP_4375_TC_1.5_Websockets-> VM-> Edit VM			 
Description		: Verify that the user is able to see message in feedback area when Multiple edits in the VM in navigator as well as in VCD
				  Verify that the user is able to see message in feedback area when edit the VM in navigator as well as in VCD.
Note			: not automating VCD part
Author 			: Vivek Kumar
Creation Date 	: 07/25/2016
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=1)
public void navValidateMultipleEdits()
{
	
	String sVMNameorStatus,sTestDescription, sHostName, sOld_GeneralDesc, sOld_GuestOSCustHostName, sWebTableTxt ;
	int iRowNbr;
	
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EVDC_VMPF);
	
	FrameworkUtil.sTestCaseName = "navValidateMultipleEdits";
	FrameworkUtil.sManualTestCaseName="QAT-1591-QAT-1589-WCP_4375_TC_1.5_Websockets-> VM-> Edit VM->Multiple Edits";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	
	
	sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
	sTestDescription= "test description"+ FrameworkUtil.sHostTimeStamp;
	sHostName="SeleniumTest-" + FrameworkUtil.sHostTimeStamp;
	//Login to Navigator Using QaAuto- A
	LoginTestCase_Old1.LoginAsQaautoAUser();
	
	//Navigate to Virtual Machine page
	EVDC_VM_AdvancedActions.navigateAndExpandVM(sVMNameorStatus);
	iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
	EVDC_VM_TestCase.stopRunningVM(iRowNbr);
	
	//Click on Edit VM Button
	EVDC_VM_TestCase.navVerifyClkEditBtn(iRowNbr);
	
	//Clicking in General Tab link
	WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralTab());
	//Updating info in Description input box
	sOld_GeneralDesc = EVDC_VMPF.getNav_EditDescriptionInput().getText().trim();
	WebObjectUtil.SetValueEdit(EVDC_VMPF.getNav_EditDescriptionInput(), sTestDescription);
	
	//Verifying Guest OS Customization Tab and Verify its landing page
	WebObjectUtil.clickAndVerifyElement(EVDC_VMPF.getNav_EditGuestOSCust(), EVDC_VMPF.getNav_GuestOSCustPwdResetText());
	
	//Editing Guest OS Customization
	WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGuestOSCust());
	sOld_GuestOSCustHostName=EVDC_VMPF.getNav_GuestOSHostNameEdit().getAttribute("value").trim();
	WebObjectUtil.SetValueEdit(EVDC_VMPF.getNav_GuestOSHostNameEdit(), sHostName);

	//Clicking on Save Button
	WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMSaveBtn());
	
	WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_VMEditChangePopUpTable());
	
	sWebTableTxt=WebTableUtil.getCellData(EVDC_VMPF.getNav_VMEditChangePopUpTable(), 2, 1);
	if(sWebTableTxt.equalsIgnoreCase("Description"))
	{
		WebObjectUtil.compareString(sOld_GeneralDesc, WebTableUtil.getCellData(EVDC_VMPF.getNav_VMEditChangePopUpTable(), 2, 2), true);
		WebObjectUtil.compareString(sTestDescription, WebTableUtil.getCellData(EVDC_VMPF.getNav_VMEditChangePopUpTable(), 2, 3), true);
	}
	
	
	sWebTableTxt=WebTableUtil.getCellData(EVDC_VMPF.getNav_VMEditChangePopUpTable(), 3, 1);
	if(sWebTableTxt.equalsIgnoreCase("Host Name"))
	{
		WebObjectUtil.compareString(sOld_GuestOSCustHostName, WebTableUtil.getCellData(EVDC_VMPF.getNav_VMEditChangePopUpTable(), 3, 2), true);
		WebObjectUtil.compareString(sHostName, WebTableUtil.getCellData(EVDC_VMPF.getNav_VMEditChangePopUpTable(), 3, 3), true);
	}
	
	WebObjectUtil.clickElement(EVDC_VMPF.getNav_NewEVDCPopUpOKBtn());		
	/////////////////////////////
	//Need to validate the feedback message  - Pending - need to check with client
	/////////////////////////////
	
	
}
	

/*==============================================================
TestScript  	: navValDeleteVM
Manual TestCase	: QAT- 1561- WCP_4375_TC_1.4_Websockets-> VM-> Delete VM		 
Description		:Verify that the user is able to see message in feedback area when delete the VM in navigator as well as in VCD. 
Note			: not automating VCD part
Author 			: Vivek Kumar
Creation Date 	: 07/26/2016
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=2)
public void navValDeleteVM()
{
	
	String sVMNameorStatus;
	
	FrameworkUtil.sTestCaseName = "navValDeleteVM";
	FrameworkUtil.sManualTestCaseName="QAT-1561-WCP_4375_TC_1.4_Websockets-> VM-> Delete VM	";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
	sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.DELETE.VM");
	//Login to Navigator Using QaAuto- A
	LoginTestCase_Old1.LoginAsQaautoAUser();
	
	//Navigate to Virtual Machine page
	EVDC_VM_AdvancedActions.navigateAndExpandVM(sVMNameorStatus);
	
	//Deleting VM
	EVDC_VM_AdvancedActions.verifyDeleteVM();
	
	//Logging Out
	EVDC_Overview_TestCase.EVDCLogout();    //LoginTestCase.nav_Logout();
	
	
}


/*==============================================================
TestScript  	: navValResetFunctionality
Manual TestCase	: QAT-1560-WCP_4375_TC_1.3_Websockets-> VM-> Reset VM 
Description		: Verify that the user is able to see message in feedback area when reset the VM in navigator as well as in VCD.
Note			: not automating VCD part
Author 			: Vivek Kumar
Creation Date 	: 07/26/2016
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=3)
public void navValResetFunctionality()
{
	
	String sVMNameorStatus,sExpUserFeedBack,sActUserFeedBack;
	int iRowNbr;
	
	FrameworkUtil.sTestCaseName = "navValResetFunctionality";
	FrameworkUtil.sManualTestCaseName="QAT-1560-WCP_4375_TC_1.3_Websockets-> VM-> Reset VM ";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	sExpUserFeedBack=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.RESET.USERFEEDBACK");
	
	sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS.RUNNING");
	//Login to Navigator Using QaAuto- A
	LoginTestCase_Old1.LoginAsQaautoAUser();
	
	//Navigate to Virtual Machine page
	EVDC_VM_AdvancedActions.navigateAndExpandVM(sVMNameorStatus);
	iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
	EVDC_VM_TestCase.startStoppedVM(iRowNbr);
	
	//Verifying and clicking on Reset button and Verifying Reset Message
	EVDC_VM_TestCase.navVerifyClkResetBtn(iRowNbr);
	
	//Verifying UserFeedBack message
	sActUserFeedBack=EVDC_VMPF.getNav_UserfeedBack().getText();
	WebObjectUtil.compareString(sExpUserFeedBack, sActUserFeedBack, true);
	//Logging Out
	EVDC_Overview_TestCase.EVDCLogout();    //LoginTestCase.nav_Logout();
	
}
/*==============================================================
TestScript  	: navValVMSuspendedFunctionality
Manual TestCase	: QAT-1559-WCP_4375_TC_1.2_Websockets-> VM-> Suspend VM
Description		: Verify that the user is able to see message in feedback area when suspend the VM in navigator as well as in VCD.
Note			: not automating VCD part
Author 			: Vivek Kumar
Creation Date 	: 07/26/2016
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=4)
public void navValVMSuspendedFunctionality()
{
	String sExpUserFeedBack,sVMNameorStatus,sActUserFeedBack;
	int iRowNbr;
	
	FrameworkUtil.sTestCaseName = "navValResetFunctionality";
	FrameworkUtil.sManualTestCaseName="QAT-1560-WCP_4375_TC_1.3_Websockets-> VM-> Reset VM ";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	sExpUserFeedBack=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.SUSPEND.USERMSG");
	
	sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS.RUNNING");
	//Login to Navigator Using QaAuto- A
	LoginTestCase_Old1.LoginAsQaautoAUser();
	
	//Navigate to Virtual Machine page
	EVDC_VM_AdvancedActions.navigateAndExpandVM(sVMNameorStatus);
	iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
	EVDC_VM_TestCase.startStoppedVM(iRowNbr);
	
	//Verifying and clicking on suspend button and Verifying Suspend Message
	EVDC_VM_TestCase.navVerifyClkSuspendBtn(iRowNbr);
	
	//Verifying UserFeedBack message
	sActUserFeedBack=EVDC_VMPF.getNav_UserfeedBack().getText();
	WebObjectUtil.compareString(sExpUserFeedBack, sActUserFeedBack, true);
	//Logging Out
	EVDC_Overview_TestCase.EVDCLogout();    //LoginTestCase.nav_Logout();
}


/*==============================================================
TestScript  	: navValStopFunctionality
Manual TestCase	: QAT- 1558- WCP_4375_TC_1.1_Websockets-> VM-> Stop VM
Description		: Verify that the user is able to see message in feedback area when stop the VM in navigator as well as VCD
Note			: not automating VCD part
Author 			: Vivek Kumar
Creation Date 	: 07/27/2016
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=5)
public void navValStopFunctionality()
{
	String sVMNameorStatus;
	int iRowNbr;
	
	FrameworkUtil.sTestCaseName = "navValStopFunctionality";
	FrameworkUtil.sManualTestCaseName="QAT- 1558- WCP_4375_TC_1.1_Websockets-> VM-> Stop VM";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
	sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS.RUNNING");
	//Login to Navigator Using QaAuto- A
	LoginTestCase_Old1.LoginAsQaautoAUser();
	
	//Navigate to Virtual Machine page
	EVDC_VM_AdvancedActions.navigateAndExpandVM(sVMNameorStatus);
	iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
	EVDC_VM_TestCase.startStoppedVM(iRowNbr);
	
	//Verifying and clicking on suspend button and Verifying Suspend Message
	EVDC_VM_TestCase.navVerifyClkStopBtn(iRowNbr);
	
	//Logging Out
	EVDC_Overview_TestCase.EVDCLogout();    //LoginTestCase.nav_Logout();
}


@AfterMethod
public static void afterEachMethod(){
		FrameworkUtil.updateTestCaseStatusinResult();
		
	}

}
