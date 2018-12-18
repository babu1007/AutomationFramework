package com.whs.navigator.testcases.zathras;

import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.CustomWebElementUtil;
import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.commonUtil.WebTableUtil;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.EVDC_VM_PageFactory;
import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.LogViewerPageFactory;
import com.whs.navigator.testcases.EVDC_VM_AdvancedActions;
import com.whs.navigator.testcases.EVDC_VM_TestCase;
import com.whs.navigator.testcases.LoginTestCase;

public class ZathrasTestCase_Vivek {
	
	public static EVDC_OverviewPageFactory EVDC_OverviewPF= new EVDC_OverviewPageFactory();
	public static EVDC_VM_PageFactory EVDC_VMPF=new EVDC_VM_PageFactory();
	public static HomePageFactory_old Home = new HomePageFactory_old();
	public static LogViewerPageFactory Logviewer = new LogViewerPageFactory();
	
	
	/*==============================================================
	TestScript  	: navEVDCVMMultipleEdit
	Manual TestCase	: QAT-1768,QAT-1767 - WCP_5755_TC_1.1_VM-> Edit VM-> Multiple edits-> Log viewer
	Description		: Verify that user is able to see multiple VM edits status and edits information in the logviewer page.
	Note			: 
	Author 			: Vivek Kumar
	Creation Date 	: 09/13/2015
	Release			: Zathras
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=1)
	public void navEVDCVMMultipleEdit()
	{
		
		String sVMNameorStatus, sTestDescription = null, sHostName;
		int iRowNbr;
		
		FrameworkUtil.sTestCaseName = "EVDC-navEVDCVMMultipleEdit";
		FrameworkUtil.sManualTestCaseName="QAT-1768,QAT-1767 - WCP_5755_TC_1.1_VM-> Edit VM-> Multiple edits-> Log viewer";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		sTestDescription=sTestDescription+ "_"+ FrameworkUtil.sTimeStamp;
		sHostName="SeleniumTest-" + FrameworkUtil.sHostTimeStamp;
		
		//Login as QAauto-a
		LoginTestCase.LoginAsQaautoAUser();
		
		//Navigate to EVDC-VM page
		sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
		//Navigating to EVDC-VM page
		//Clicking on EVDC Name and validating its landing page
		WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
		WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine(),EVDC_VMPF.getNav_AddVMLink());
		
		
		EVDC_VM_AdvancedActions.refreshAndExpandVM(sVMNameorStatus);
		iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
		EVDC_VM_TestCase.stopRunningVM(iRowNbr);
		
		
		//Verifying and Clicking on Edit button
		EVDC_VM_TestCase.navVerifyClkEditBtn(iRowNbr);
		
		//Verifying and update General Tab link
		WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_EditGeneralTab());
		WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralTab());
		WebObjectUtil.SetValueEdit(EVDC_VMPF.getNav_EditDescriptionInput(), sTestDescription);
		
		//Click on Compute Storage and update the same
		WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditComputeStorage());
		WebObjectUtil.clickElement(EVDC_VMPF.getNav_ComputeStorageAddDisk());
		
		//Click and update NICs
		WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditNICs());
		WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_NICsAddNIC());
		
		//Click and Update Guest customization
		WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGuestOSCust());
		WebObjectUtil.SetValueEdit(EVDC_VMPF.getNav_GuestOSHostNameEdit(), sHostName);
		
		//Clicking on Save Button
		WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMSaveBtn());
		
		/////////////////////////////
		//Pending  Feedback message
		/////////////////////////////
		
		//Navigate to logviewer page
		WebObjectUtil.ClickAndMouseHover(Home.getNav_SupportTab());
		WebObjectUtil.clickElement(Home.getNav_LogViewerMenuLink());
		
		String sUserAction, sStatus;
		
		//Verifying Edit-VM in log Viewer
		CustomWebElementUtil.loadCustomElement(Logviewer.getNavWebTableParent(), "table");
		iRowNbr = CustomWebElementUtil.iRowCount;
		
		if(iRowNbr>0)
		{
			for(int r=1;r<=iRowNbr;r++)
			{
				sUserAction=WebTableUtil.getCellData(Logviewer.getNavWebTableParent(), r, 2);
				if(sUserAction.equalsIgnoreCase("Edit VM"))
				{
					sStatus=WebTableUtil.getCellData(Logviewer.getNavWebTableParent(), r, 5);
					if(sStatus.contains("SUCCESS"))
					{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Logviewer EDIT VM Status","pass", "Status is " +sStatus);
					}
					else
					{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Logviewer EDIT VM Status","fail", "Status is " +sStatus);
					}
					break;
				}
			}
				
		}
		else
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Logviewer table ","fail", "Empty");
		}
		
		//Logout
		LoginTestCase.nav_Logout();
		
		
		
	}
	

}
