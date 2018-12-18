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
import com.whs.navigator.pagefactory.EVDCPageFactory;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.EVDC_VM_AdvancedActions_PageFactory;
import com.whs.navigator.pagefactory.EVDC_VM_PageFactory;



public class EVDC_VM_AdvancedActions {
	
	//public static EVDCPageFactory EVDC= new EVDCPageFactory();
	public static EVDC_VM_PageFactory EVDC_VMPF = new EVDC_VM_PageFactory();
	public static EVDC_OverviewPageFactory EVDC_OverviewPF = new EVDC_OverviewPageFactory();
	
	public static  EVDC_VM_AdvancedActions_PageFactory EVDC_Advanced= new EVDC_VM_AdvancedActions_PageFactory();
	public static String sVMName,sVMstatus;
	public static int iVisibleVMRowNum;
	
	/*==============================================================
	TestScript 		: EVDC_VerifyAdvanced_Actions_Links
	Manual TestCase	: Verifying Login success using Valid credential
	Description		: Verifying Login success using Valid credential
	Author 			: Arularasu
	Creation Date 	: 03/16/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	@Test(priority=1)
	public void EVDC_VerifyAdvanced_Actions_Links(){
		int iRowNo=0;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,EVDC_VMPF);
		PageFactory.initElements(driver,EVDC_OverviewPF);
		PageFactory.initElements(driver,EVDC_Advanced);
		
		FrameworkUtil.sTestCaseName = "EVDC_VerifyAdvanced_Actions_Links";
		FrameworkUtil.sManualTestCaseName="Verify links under EVDC Advanced action, TC: VM 88";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		
		try {
		  // 	EVDC_Overview_TestCase.navEVDCLogin();
		//	navigateAndExpandVM("RHEL5-32-bit_Automation");   //navigateAndExpandVM("Stopped");
			
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDC_VM_TestCase.EVDCLoginAndExpand(sVMNameorStatus);
			
			WebObjectUtil.clickAndVerifyElement(EVDC_Advanced.getNav_EVDCAdvancedActionsLink(),EVDC_Advanced.getNav_EVDCMountMediaLink());
			WebObjectUtil.verifyElementPresent(EVDC_Advanced.getNav_EVDCEjectMediaLink());
			WebObjectUtil.verifyElementPresent(EVDC_Advanced.getNav_EVDCSaveVMTemplateLink());

			EVDC_Overview_TestCase.EVDCLogout();    //LoginTestCase.nav_Logout();
	
		} catch (Exception e) {
			LoggerUtil.log_type_error("Exception occured:" + e.getMessage());
		}
	}
	
	
	
	/*==============================================================
	TestScript 		: EVDC_Advanced_MountMediaDialog
	Manual TestCase	: Verify EVDC Advanced MountMediaDialog, TC: VM 89 & 90
	Description		: Verify EVDC Advanced MountMediaDialog, TC: VM 89 & 90
	Author 			: Arularasu
	Creation Date 	: 03/17/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	@Test(priority=2)
	public void EVDC_Advanced_MountMediaDialog(){
		int iRowNo=0;
		String sNoMountMedia,sMediaMsg;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,EVDC_VMPF);
		PageFactory.initElements(driver,EVDC_OverviewPF);
		PageFactory.initElements(driver,EVDC_Advanced);
		
		FrameworkUtil.sTestCaseName = "EVDC_Advanced_MountMediaDialog";
		FrameworkUtil.sManualTestCaseName="Verify EVDC Advanced MountMediaDialog, TC: VM 89 & 90";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		sNoMountMedia = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.MOUNTMEDIA.UNAVAILABLEMSG");
		
		
		try {
			//EVDC_Overview_TestCase.navEVDCLogin();
			//navigateAndExpandVM("RHEL5-32-bit_Automation");   //navigateAndExpandVM("Stopped");
	
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDC_VM_TestCase.EVDCLoginAndExpand(sVMNameorStatus);
			
			WebObjectUtil.clickAndVerifyElement(EVDC_Advanced.getNav_EVDCAdvancedActionsLink(),EVDC_Advanced.getNav_EVDCMountMediaLink());
			//WebObjectUtil.clickAndVerifyElement(EVDC_Advanced.getNav_EVDCMountMediaLink(),EVDC_Advanced.getNav_EVDCMountMediaParentDiv());
			WebObjectUtil.clickElement(EVDC_Advanced.getNav_EVDCMountMediaLink());
			WebObjectUtil.explicitWait(3);
			if(WebObjectUtil.isElementPresent(EVDC_Advanced.getNav_EVDCConfirmPopup())){
				sMediaMsg = EVDC_Advanced.getNav_EVDCConfirmPopup().getText();
				if (sMediaMsg.contains(sNoMountMedia)){
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "No Mount Media", "warn", "No Media to Mount :" + sMediaMsg);
				}else{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "No Mount Media", "fail", "No Media to Mount :" + sMediaMsg);
				}
				WebObjectUtil.clickElement(EVDC_Advanced.getNav_EVDCConfirmPopupOkBtn());
			}else if (WebObjectUtil.isElementPresent(EVDC_Advanced.getNav_EVDCMountMediaParentDiv()))
			{
				WebObjectUtil.verifyElementPresent(EVDC_Advanced.getNav_EVDCMountNameTableHeader());
				WebObjectUtil.verifyElementPresent(EVDC_Advanced.getNav_EVDCMountCatalogTableHeader());
				WebObjectUtil.verifyElementPresent(EVDC_Advanced.getNav_EVDCStorageUsedTableHeader());
				WebObjectUtil.verifyElementPresent(EVDC_Advanced.getNav_EVDCMountMediaInsertBtn());
				WebObjectUtil.verifyElementPresent(EVDC_Advanced.getNav_EVDCMountMediaCancelBtn());
			
			}else{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "issue with Mount Media", "fail", "issue with Mount Media");
			}
			//closeDialog(EVDC_Advanced.getNav_EVDCmountIsoPopupClose());
			EVDC_Overview_TestCase.EVDCLogout();    //LoginTestCase.nav_Logout();
	
		} catch (Exception e) {
			LoggerUtil.log_type_error("Exception occured:" + e.getMessage());
		}
	}
	
	
	/*==============================================================
	TestScript 		: EVDC_Advanced_MountMediaSuccess
	Manual TestCase	: Verify success of MountMedia , TC: VM 91 & 92
	Description		: Verify success of MountMedia , TC: VM 91 & 92
	Author 			: Arularasu
	Creation Date 	: 03/18/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	@Test(priority=3)
	public void EVDC_Advanced_MountMediaSuccess(){
		int iRowNo=0;
		try {
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,EVDC_VMPF);
			PageFactory.initElements(driver,EVDC_OverviewPF);
			PageFactory.initElements(driver,EVDC_Advanced);
			
			FrameworkUtil.sTestCaseName = "EVDC_Advanced_MountMediaSuccess";
			FrameworkUtil.sManualTestCaseName="Verify success of MountMedia , TC: VM 91 & 92";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			//EVDC_Overview_TestCase.navEVDCLogin();
			//navigateAndExpandVM("RHEL5-32-bit_Automation");   //navigateAndExpandVM("Stopped");
			
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDC_VM_TestCase.EVDCLoginAndExpand(sVMNameorStatus);
			
			verifyMountMedia();
			
			//closeDialog(EVDC_Advanced.getNav_EVDCmountIsoPopupClose());
			EVDC_Overview_TestCase.EVDCLogout();    //LoginTestCase.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("Exception occured:" + e.getMessage());
		}
	
	}
	
	
	/*==============================================================
	TestScript 		: EVDC_Advanced_EjectMediaDialog
	Manual TestCase	: Verify EVDC Advanced EjectMediaDialog, TC:VM-94,95,96
	Description		: Verify EVDC Advanced EjectMediaDialog, TC:VM-94,95,96
	Author 			: Arularasu
	Creation Date 	: 03/18/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	@Test(priority=4)
	public void EVDC_Advanced_EjectMediaDialog(){
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,EVDC_VMPF);
		PageFactory.initElements(driver,EVDC_OverviewPF);
		PageFactory.initElements(driver,EVDC_Advanced);
		
		FrameworkUtil.sTestCaseName = "EVDC_Advanced_EjectMediaDialog";
		FrameworkUtil.sManualTestCaseName="Verify EVDC Advanced EjectMediaDialog, TC: VM-94,95,96";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		
		try {
			//EVDC_Overview_TestCase.navEVDCLogin();
			//navigateAndExpandVM("RHEL5-32-bit_Automation");   //navigateAndExpandVM("Stopped");
			
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDC_VM_TestCase.EVDCLoginAndExpand(sVMNameorStatus);
			
			verifyEjectMedia();
		
			//closeDialog(EVDC_Advanced.getNav_EVDCEjectIsoPopupClose());
			EVDC_Overview_TestCase.EVDCLogout();    //LoginTestCase.nav_Logout();
	
		} catch (Exception e) {
			LoggerUtil.log_type_error("Exception occured:" + e.getMessage());
		}
	}
	
	
	
	
	/*==============================================================
	TestScript 		: EVDC_Advanced_SaveVMasTemplate
	Manual TestCase	: Verify save VM as Template success, TC: VM-98,99,100,101
	Description		: Verify save VM as Template success, TC: VM-98,99,100,101
	Author 			: Arularasu
	Creation Date 	: 03/19/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	@Test(priority=5)
	public void EVDC_Advanced_SaveVMasTemplate(){
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,EVDC_VMPF);
		PageFactory.initElements(driver,EVDC_OverviewPF);
		PageFactory.initElements(driver,EVDC_Advanced);
		
		FrameworkUtil.sTestCaseName = "EVDC_Advanced_SaveVMasTemplate";
		FrameworkUtil.sManualTestCaseName="Verify save VM as Template success, TC: VM-98,99,100,101";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		
		
		try {
			
			
	String sVMName = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.SAVEASTEMPLATE.VMNAME") ;
	/*EVDC_Overview_TestCase.navEVDCLogin();
			if (!navigateAndExpandVM(sVMName))
			{
				navigateAndExpandVM("RHEL5-32-bit_Automation");   //navigateAndExpandVM("Stopped");
			}
*/
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDC_VM_TestCase.EVDCLoginAndExpand(sVMNameorStatus);
			
			saveVMasTemplate();
	
	
			//closeDialog(EVDC_Advanced.getNav_EVDC_Advanced_Dialog_Close());
			EVDC_Overview_TestCase.EVDCLogout();    //LoginTestCase.nav_Logout();
	
		} catch (Exception e) {
			LoggerUtil.log_type_error("Exception occured:" + e.getMessage());
		}
	}
	
	/*==============================================================
	TestScript 		: EVDC_Advanced_SaveVMasTemplateErrorWithMountMedia
	Manual TestCase	: Verify error message on Save VM as template , TC: VM-103
	Description		: Verify error message on Save VM as template , TC: VM-103
	Author 			: Arularasu
	Creation Date 	: 03/20/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=6)
	public void EVDC_Advanced_SaveVMasTemplateErrorWithMountMedia(){
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,EVDC_VMPF);
		PageFactory.initElements(driver,EVDC_OverviewPF);
		PageFactory.initElements(driver,EVDC_Advanced);
		
		FrameworkUtil.sTestCaseName = "EVDC_SaveVMasTemplateErrorWithMountMediaVMasTemplate";
		FrameworkUtil.sManualTestCaseName="Verify error message on Save VM as template , TC: VM-103";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		//navigateToEVDCAdvancedActions("Stopped");
		//EVDCTestCase.navEVDCLogin();
		//verifyMountMedia();
		
		try {
			
			String sVMName = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.SAVEASTEMPLATE.VMNAME") ;
/*			EVDCTestCase.navEVDCLogin();
			if (!navigateAndExpandVM(sVMName))
			{
				navigateAndExpandVM("test_Tomsmultivapp_abhi_local");   //navigateAndExpandVM("Stopped");
			}*/
			
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDC_VM_TestCase.EVDCLoginAndExpand(sVMNameorStatus);
			
			
			verifyMountMedia();
			//Verify save VM as Template dialog
			WebObjectUtil.clickElement(EVDC_Advanced.getNav_EVDCAdvancedActionsLink());
			//WebObjectUtil.clickAndVerifyElement(EVDC_Advanced.getNav_EVDCAdvancedActionsLink(),EVDC_Advanced.getNav_EVDCSaveVMTemplateLink());
		//	WebObjectUtil.clickAndVerifyElement(EVDC_Advanced.getNav_EVDCSaveVMTemplateLink(),EVDC_Advanced.getNav_EVDCsaveAsTemplateWindow());

			
			if (saveVMasTemplate()){
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "SaveVMasTemplateErrorWithMountMedia", "pass", "Template not created as expected" );
			}
	
	
			//closeDialog(EVDC_Advanced.getNav_EVDC_Advanced_Dialog_Close());
			EVDC_Overview_TestCase.EVDCLogout();    //LoginTestCase.nav_Logout();
	
		} catch (Exception e) {
			LoggerUtil.log_type_error("Exception occured:" + e.getMessage());
		}
	}
	
	
	
	public static boolean navigateAndExpandVM(String VMnameOrStatus){
		boolean bStatus = false;
		int iRowNo;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,EVDC_VMPF);
		PageFactory.initElements(driver,EVDC_OverviewPF);
		PageFactory.initElements(driver,EVDC_Advanced);
		
		try {
			//Login to Navigator
			//EVDCTestCase.navEVDCLogin();
			
			//Clicking on EVDC Name and validating its landing page
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine(),EVDC_VMPF.getNav_AddVMLink());
				//iRowNo = getRow_EVDC_VMTable(EVDC_Advanced.getNav_EVDCVMTable(),VMnameOrStatus,"");
			//iRowNo = getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),VMnameOrStatus,"");
			iRowNo = getRow_EVDC_VMTable(EVDC_VMPF.getNav_VMWebTableParent(),VMnameOrStatus,"");
			//System.out.println("VM name: " + sVMName + "--" + iRowNo);
			//WebTableUtil.printEachCellText(EVDC.getNav_VMWebTable());
			if (iRowNo > 0 ){
				bStatus = true;
				expandVMbyRowNum(iRowNo);
			}
		} catch (Exception e) {
			LoggerUtil.log_type_error("Exception occured:" + e.getMessage());
		}

		return bStatus;
	}
	
	
	public static void expandVMbyRowNum(int iRowNum){
		WebElement expandArrow;
		try {
			//expandArrow = WebObjectUtil.GetWebElement("xpath", "//tr[" + iRowNum + "]//div[@class='x-grid-row-expander']","expandArrow");
			//String sExpanderLocator = WebObjectUtil.getLocatorValueFromProperty("EVDC.VM.VMTABLE.EXPANDER", "PARAMETER_ROWNUMBER", iRowNum+"");
			//expandArrow = WebObjectUtil.GetWebElement("xpath", sExpanderLocator,"expandArrow");
			// This object is updated on 10/15/2015 By QAA04
			expandArrow = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.EXPANDER", "PARAMETER_ROWNUMBER", iRowNum +"");

			if (iRowNum > 0 && expandArrow != null  ){
				expandArrow.click();
				//System.out.println("expanding VM row success");
				LoggerUtil.log_type_info("expanding VM row success");
			}else{
				//System.out.println("expanding VM row failure");
				LoggerUtil.log_type_error("expanding VM row failure");
			}
		} catch (Exception e) {
			LoggerUtil.log_type_error("Exception occured:" + e.getMessage());
		}
	}
	
	
	static int getRow_EVDC_VMTable(WebElement webTable,String sSearchString,String sOSType){
		int index =0;
		int isearchIndex = 0;
		String sOS;
		WebElement wRowElement;
		try {
			

			
			List<WebElement> rowsList = webTable.findElements(By.tagName("table"));
			for (int i=0; i<=rowsList.size(); i+=1){
				String sText = rowsList.get(i).getText();
				//System.out.println(sText);
				wRowElement = rowsList.get(i);
				//if (sText.contains("Managed") || sText.contains("Unmanaged") || (WebTableUtil.getCellData(wRowElement, i, 3).length()) > 0 ){
				if (sText.contains("Managed") || sText.contains("Unmanaged")  ){
					index++;
					if (sText.contains(sSearchString)){
						isearchIndex = index;
						
						//updated as part of EXTJS5 on 10-07-15 by Arul
/*						sVMName = WebTableUtil.getCellData(webTable, i, 3);
						sVMstatus = WebTableUtil.getCellData(webTable, i, 6);
						iVisibleVMRowNum = isearchIndex;
						*/
						CustomWebElementUtil.loadCustomElement(webTable, "table");
						sVMName=CustomWebElementUtil.getCellData(isearchIndex, 3);
						sVMstatus=CustomWebElementUtil.getCellData(isearchIndex, 5);
						iVisibleVMRowNum = isearchIndex;
						
						
						//To pick first stopped VM by passing empty OS type 
						if (sOSType.length() == 0 ){
							break;	
						}
						//To pick stopped VM based on OS type
						sOS = getOSType_EVDC_VMTable(webTable,index);
						if (sOS.equalsIgnoreCase(sOSType)){
						System.out.println(sText);
						break;
						}
					}
				}

			}
		} catch (Exception e) {
			LoggerUtil.log_type_error("Exception occured:" + e.getMessage());
		}
		return isearchIndex;
		
	}
	
	
	private static String getOSType_EVDC_VMTable(WebElement webTable,int iRowNum){
		WebElement sOSImg ;
		String sOpSys = "";
		try {
			// row expand arrow
			//webTable.findElement(By.xpath("//tr[" + iRowNum + "]//div[@class='x-grid-row-expander']"));
			
			// os of given row no.
			sOSImg = webTable.findElement(By.xpath("//tr[" + iRowNum + "]//td/div/img"));
			System.out.println(webTable.findElement(By.xpath("//tr[" + iRowNum + "]")).getText());
			if (sOSImg.isDisplayed()){
				String sSRC = sOSImg.getAttribute("src");
				if (sSRC.contains("MicrosoftWindows")){
					sOpSys = "windows";
				}else if (sSRC.contains("Linux")|| sSRC.contains("RedHat") ){
					sOpSys = "linux";
				}
			
			}
		} catch (Exception e) {
			LoggerUtil.log_type_error("Exception occured:" + e.getMessage());
		}
		return sOpSys;
		}

		
		

	
	public static boolean verifySuccessMsgOnPage(String sSuccessMsg){
		boolean bStatus = false;
		try {
			//verify eject success on EVDC main page
			WebObjectUtil.waitForElementPresent(EVDC_Advanced.getNav_EVDCConfirmPopupOkBtn());
			boolean bSuccessMsg = EVDC_Advanced.getNav_EVDCSuccessMsg().getText().contains(sSuccessMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bSuccessMsg, sSuccessMsg);
			WebDriverUtil.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			if (bSuccessMsg){
				bStatus = true;
			}
		} catch (Exception e) {
			LoggerUtil.log_type_error("Exception occured:" + e.getMessage());
		}
		return bStatus;
	}
	
	
	public static boolean verifySuccessMsg(WebElement webElement, String sSuccessMsg){
		boolean bStatus = false;

		try {
			String sText = webElement.getText();
			boolean bSuccessMsg = sText.contains(sSuccessMsg);
			//FrameworkUtil.updateCustomResultBasedOnStatus(bSuccessMsg, sSuccessMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bSuccessMsg, sText);
			WebDriverUtil.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			if (bSuccessMsg){
				bStatus = true;
			}
		} catch (Exception e) {
			LoggerUtil.log_type_error("Exception occured:" + e.getMessage());
		}
		return bStatus;
	}
	
	 private static void closeDialog(WebElement DialogElement){
		  try {
			if (WebObjectUtil.isElementPresent(DialogElement)){
				  DialogElement.click();
			  }
		} catch (Exception e) {
			LoggerUtil.log_type_error("Exception occured:" + e.getMessage());
		}
		  
		 }

	 public static boolean verifyMountMedia(){
		 boolean bStatus = false;
		 String sNoMountMedia,sMediaMsg;
		 
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,EVDC_VMPF);
			PageFactory.initElements(driver,EVDC_OverviewPF);
			PageFactory.initElements(driver,EVDC_Advanced);
		 try {		
			 sNoMountMedia = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.MOUNTMEDIA.UNAVAILABLEMSG");
				WebObjectUtil.clickAndVerifyElement(EVDC_Advanced.getNav_EVDCAdvancedActionsLink(),EVDC_Advanced.getNav_EVDCMountMediaLink());
				//WebObjectUtil.clickAndVerifyElement(EVDC_Advanced.getNav_EVDCMountMediaLink(),EVDC_Advanced.getNav_EVDCMountMediaParentDiv());
				WebObjectUtil.clickElement(EVDC_Advanced.getNav_EVDCMountMediaLink());
				WebObjectUtil.explicitWait(3);
				if(WebObjectUtil.isElementPresent(EVDC_Advanced.getNav_EVDCConfirmPopup())){
					sMediaMsg = EVDC_Advanced.getNav_EVDCConfirmPopup().getText();
					if (sMediaMsg.contains(sNoMountMedia)){
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "No Mount Media", "warn", "No Media to Mount :" + sMediaMsg);
					}else{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "No Mount Media", "fail", "No Media to Mount :" + sMediaMsg);
					}
					WebObjectUtil.clickElement(EVDC_Advanced.getNav_EVDCConfirmPopupOkBtn());
				}else if (WebObjectUtil.isElementPresent(EVDC_Advanced.getNav_EVDCMountMediaParentDiv()))
				
				{
					String sMountMediaName = WebTableUtil.getCellData(EVDC_Advanced.getNav_EVDCMountMediaTable(), 1, 1);
					
					//click on first row of the table
					EVDC_Advanced.getNav_EVDCMountMediaTable().findElement(By.tagName("tr")).click();

					//click on insert button
					WebObjectUtil.clickElement(EVDC_Advanced.getNav_EVDCMountMediaInsertBtn());
/*					
					WebObjectUtil.waitForElementPresent(EVDC_Advanced.getNav_EVDCConfirmPopup());
					//verify confirm popup
					WebObjectUtil.verifyElementPresent(EVDC_Advanced.getNav_EVDCConfirmPopup());
					WebObjectUtil.verifyElementPresent(EVDC_Advanced.getNav_EVDCConfirmPopupOkBtn());
					WebObjectUtil.verifyElementPresent(EVDC_Advanced.getNav_EVDCConfirmPopupCancelBtn());

					String sConfirmMsg = "Are you sure you want to mount " + sMountMediaName + " on "+ sVMName + "?";
					String s = EVDC_Advanced.getNav_EVDCConfirmPopup().getText();
					//boolean bConfirmMsg = WebObjectUtil.compareString(EVDC_Advanced.getNav_EVDCConfirmPopup().getText(), sConfirmMsg, false);
					boolean bConfirmMsg = EVDC_Advanced.getNav_EVDCConfirmPopup().getText().contains(sConfirmMsg);
					FrameworkUtil.updateCustomResultBasedOnStatus(bConfirmMsg,sConfirmMsg);
					//WebObjectUtil.clickElement(EVDC_Advanced.getNav_EVDCConfirmPopupOkBtn());
					*/	
					
					WebObjectUtil.verifyElementPresent(EVDC_Advanced.getNav_EVDCConfirmNewPopup());
					WebObjectUtil.verifyElementPresent(EVDC_Advanced.getNav_EVDCConfirmNewPopupOKBtn());
					WebObjectUtil.verifyElementPresent(EVDC_Advanced.getNav_EVDCConfirmNewPopupCancelBtn());
					
					String sConfirmMsg = "Are you sure you want to mount " + sMountMediaName + " on "+ sVMName + "?";
					String sActualMsg = EVDC_Advanced.getNav_EVDCConfirmNewPopup().getText();
					boolean bConfirmMsg = sActualMsg.contains(sConfirmMsg);
					FrameworkUtil.updateCustomResultBasedOnStatus(bConfirmMsg,sConfirmMsg);
					WebObjectUtil.clickElement(EVDC_Advanced.getNav_EVDCConfirmNewPopupOKBtn());

					WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_RefreshPopUpMsg());
					String sSuccessMsg = "Successfully mounted " + sMountMediaName + " on " + sVMName;
					//boolean bSuccessMsg = WebObjectUtil.compareString(EVDC_Advanced.getNav_EVDCConfirmPopup().getText(), sConfirmMsg, false);
					boolean bSuccessMsg = EVDC_Advanced.getNav_EVDCConfirmPopup().getText().contains(sSuccessMsg);
					FrameworkUtil.updateCustomResultBasedOnStatus(bSuccessMsg,sSuccessMsg);
					WebObjectUtil.clickElement(EVDC_Advanced.getNav_EVDCConfirmPopupOkBtn());

					WebObjectUtil.waitForElementPresent(EVDC_Advanced.getNav_EVDCConfirmPopupOkBtn());
					//FrameworkUtil.updateCustomResultBasedOnStatus(WebObjectUtil.compareString(EVDC_Advanced.getNav_EVDCConfirmPopup().getText(), sConfirmMsg, false),sSuccessMsg);
					bSuccessMsg = EVDC_Advanced.getNav_EVDCSuccessMsg().getText().contains(sSuccessMsg);
					FrameworkUtil.updateCustomResultBasedOnStatus(bSuccessMsg, sSuccessMsg);
				
				}else{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "issue with Mount Media", "fail", "issue with Mount Media");
				}
		

				bStatus =true;
			} catch (Exception e) {
				LoggerUtil.log_type_error("Exception occured:" + e.getMessage());
			}
		 return bStatus;
	 }
	
	 
	 public static boolean verifyEjectMedia(){
		 boolean bStatus = false,bSuccessMsg=false,bEjectUnavailableMsg=false;
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,EVDC_VMPF);
			PageFactory.initElements(driver,EVDC_OverviewPF);
			PageFactory.initElements(driver,EVDC_Advanced);
		 try {			
				
				//Verify Eject media dialog
				WebObjectUtil.clickAndVerifyElement(EVDC_Advanced.getNav_EVDCAdvancedActionsLink(),EVDC_Advanced.getNav_EVDCEjectMediaLink());
				//WebObjectUtil.clickAndVerifyElement(EVDC_Advanced.getNav_EVDCEjectMediaLink(),EVDC_Advanced.getNav_EVDCEjectIsoPopup());
				String sEjectUnavailableMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.EJECTMEDIA.UNAVAILABLEMSG");
				WebObjectUtil.clickElement(EVDC_Advanced.getNav_EVDCEjectMediaLink());
				WebObjectUtil.explicitWait(3);
				String sEjectUnavailablefeedbackMsg = EVDC_Advanced.getNav_EVDCSuccessMsg().getText();
				bEjectUnavailableMsg = sEjectUnavailablefeedbackMsg.contains(sEjectUnavailableMsg);
				if (!bEjectUnavailableMsg){
				WebObjectUtil.verifyElementPresent(EVDC_Advanced.getNav_EVDCEjectIsoPopup());
				WebObjectUtil.verifyElementPresent(EVDC_Advanced.getNav_EVDC_Advanced_Dialog_OkBtn());
				WebObjectUtil.verifyElementPresent(EVDC_Advanced.getNav_EVDC_Advanced_Dialog_CancelBtn());
				
				//verify text present on Eject dialog
				String sConfirmMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.EJECTMEDIA.CONFIRMMSG");
				boolean bConfirmMsg = EVDC_Advanced.getNav_EVDCEjectIsoPopup().getText().contains(sConfirmMsg);
				FrameworkUtil.updateCustomResultBasedOnStatus(bConfirmMsg,sConfirmMsg);
				WebObjectUtil.clickElement(EVDC_Advanced.getNav_EVDC_Advanced_Dialog_OkBtn());
				
				//verify text present on confirmation dialog
				WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_RefreshPopUpMsg());
				String sSuccessMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.EJECTMEDIA.SUCCESSMSG");
				//boolean bSuccessMsg = WebObjectUtil.compareString(EVDC_Advanced.getNav_EVDCConfirmPopup().getText(), sConfirmMsg, false);
				bSuccessMsg = EVDC_Advanced.getNav_EVDCConfirmPopup().getText().contains(sSuccessMsg);
				FrameworkUtil.updateCustomResultBasedOnStatus(bSuccessMsg,sSuccessMsg);
				WebObjectUtil.clickElement(EVDC_Advanced.getNav_EVDCConfirmPopupOkBtn());
			
				
				//verify eject success on EVDC main page
				WebObjectUtil.waitForElementPresent(EVDC_Advanced.getNav_EVDCConfirmPopupOkBtn());
				bSuccessMsg = EVDC_Advanced.getNav_EVDCSuccessMsg().getText().contains(sSuccessMsg);
				FrameworkUtil.updateCustomResultBasedOnStatus(bSuccessMsg, sSuccessMsg);
				//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				}else{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "No Media to Eject", "warn", sEjectUnavailablefeedbackMsg );
				}
				bStatus =true;
			} catch (Exception e) {
				LoggerUtil.log_type_error("Exception occured:" + e.getMessage());
			}
		 return bStatus;
	 }
	
	 
	 
	 public static boolean saveVMasTemplate(){
		 boolean bStatus = false;
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,EVDC_VMPF);
			PageFactory.initElements(driver,EVDC_OverviewPF);
			PageFactory.initElements(driver,EVDC_Advanced);
			String sMainPageSuccessMsg,sPopupMsg;
			try {
				String sTemplateName = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.SAVEASTEMPLATE.NAME") + FrameworkUtil.sTimeStamp;
				String sTemplateDesc = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.SAVEASTEMPLATE.DESC");
				String sTemplateDest = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.SAVEASTEMPLATE.DESTINATION");
				
				//Verify save VM as Template dialog
				WebObjectUtil.clickAndVerifyElement(EVDC_Advanced.getNav_EVDCAdvancedActionsLink(),EVDC_Advanced.getNav_EVDCSaveVMTemplateLink());
				WebObjectUtil.clickAndVerifyElement(EVDC_Advanced.getNav_EVDCSaveVMTemplateLink(),EVDC_Advanced.getNav_EVDCsaveAsTemplateWindow());
				WebObjectUtil.verifyElementPresent(EVDC_Advanced.getNav_EVDCsaveAsTemplateNameEdit());
				WebObjectUtil.verifyElementPresent(EVDC_Advanced.getNav_EVDCsaveAsTemplateDescEdit());
				WebObjectUtil.verifyElementPresent(EVDC_Advanced.getNav_EVDCsaveToCatalogCombo());
				WebObjectUtil.verifyElementPresent(EVDC_Advanced.getNav_EVDC_Advanced_Dialog_CancelBtn());
				WebObjectUtil.verifyElementPresent(EVDC_Advanced.getNav_EVDC_Advanced_Dialog_SaveBtn());
				
				
				WebObjectUtil.SetValueEdit(EVDC_Advanced.getNav_EVDCsaveAsTemplateNameEdit(), sTemplateName);
				WebObjectUtil.SetValueEdit(EVDC_Advanced.getNav_EVDCsaveAsTemplateDescEdit(), sTemplateDesc);
				WebObjectUtil.clickElement(EVDC_Advanced.getNav_EVDCsaveToCatalogCombo());
				//WebObjectUtil.waitForElementPresent(EVDC_Advanced.getNav_EVDCsaveToCatalogComboDropDown());

				//WebObjectUtil.selectCustomWebList(EVDC_Advanced.getNav_EVDCsaveToCatalogComboDropDown(), sTemplateDest);
				WebObjectUtil.selectCustomWebList(EVDC_Advanced.getNav_EVDCsaveToCatalogComboDropDown(), 1);
				//WebObjectUtil.selectCustomWebList(EVDC_Advanced.getNav_EVDCsaveToCatalogComboDropDown(), 1);
				WebObjectUtil.clickElement(EVDC_Advanced.getNav_EVDC_Advanced_Dialog_SaveBtn());
				WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_RefreshPopUpMsg());
				
/*				//if (WebObjectUtil.getToolTipsMsg(EVDC_Advanced.getNav_EVDCsaveToCatalogComboParentObject(), "Required Field")){
				if (!WebObjectUtil.isElementPresent(EVDC_Advanced.getNav_EVDCConfirmPopup())){
					WebObjectUtil.clickElement(EVDC_Advanced.getNav_EVDCsaveToCatalogCombo());
					WebElement item = WebObjectUtil.getElementbyTagNameValue("li", sTemplateDest,"Template Dest");
					item.click();
					WebObjectUtil.clickElement(EVDC_Advanced.getNav_EVDC_Advanced_Dialog_SaveBtn());
				}*/
				
				//verify text present on save vm as template dialog
				String sConfirmMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.SAVEASTEMPLATE.CONFIRMMSG") + " " + sVMName + " as template "+ sTemplateName + "?";
				String sConfirmText = EVDC_Advanced.getNav_EVDCConfirmNewPopup().getText();
				boolean bConfirmMsg = sConfirmText.regionMatches(true,0, sConfirmMsg, 0, 0);
				FrameworkUtil.updateCustomResultBasedOnStatus(bConfirmMsg,sConfirmMsg);
				//WebObjectUtil.clickElement(EVDC_Advanced.getNav_EVDC_Advanced_Dialog_OkBtn());
				WebObjectUtil.clickElement(EVDC_Advanced.getNav_EVDCConfirmNewPopupOKBtn());
				
				//verify text present on confirmation dialog
				WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_RefreshPopUpMsg());
				String sSuccessMsg = sTemplateName + " " + (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.SAVEASTEMPLATE.SUCCESSMSG");
				String sGetSuccessMsg = EVDC_Advanced.getNav_EVDCConfirmPopup().getText();
				if (!sGetSuccessMsg.contains("Save VM As Template Failed")){
					//boolean bSuccessMsg = WebObjectUtil.compareString(EVDC_Advanced.getNav_EVDCConfirmPopup().getText(), sConfirmMsg, false);
				    sPopupMsg=	EVDC_Advanced.getNav_EVDCConfirmPopup().getText();
				    
					boolean bSuccessMsg = sPopupMsg.regionMatches(true,0, sSuccessMsg, 0, 0);
				   
					FrameworkUtil.updateCustomResultBasedOnStatus(bSuccessMsg,sSuccessMsg);
					WebObjectUtil.clickElement(EVDC_Advanced.getNav_EVDCConfirmPopupOkBtn());
					
					//verify Save VM as Template success on EVDC main page
					//WebObjectUtil.waitForElementPresent(EVDC_Advanced.getNav_EVDCConfirmPopupOkBtn());
					sMainPageSuccessMsg=EVDC_Advanced.getNav_EVDCSuccessMsg().getText();
					bSuccessMsg = sMainPageSuccessMsg.regionMatches(true,0, sSuccessMsg, 0, 0);
					FrameworkUtil.updateCustomResultBasedOnStatus(bSuccessMsg, sSuccessMsg);

					
				}else{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verify element/text", "fail", sGetSuccessMsg );
					WebObjectUtil.clickElement(EVDC_Advanced.getNav_EVDC_Advanced_Dialog_OkBtn());
				}
				WebDriverUtil.getDriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				bStatus =true;
			} catch (Exception e) {
				LoggerUtil.log_type_error("Exception occured:" + e.getMessage());
			}
	return bStatus ;
	 }
	 
	 
	 public static boolean verifyDeleteVM(){
		 boolean bStatus = false;
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,EVDC_VMPF);
			PageFactory.initElements(driver,EVDC_OverviewPF);
			PageFactory.initElements(driver,EVDC_Advanced);
		 try {			
				
				//Verify Delete VM dialog
				WebObjectUtil.clickAndVerifyElement(EVDC_Advanced.getNav_EVDCAdvancedActionsLink(),EVDC_Advanced.getNav_EVDCDeleteVMLink());
				WebObjectUtil.clickAndVerifyElement(EVDC_Advanced.getNav_EVDCDeleteVMLink(),EVDC_Advanced.getNav_EVDCDeleteVMPopup());

				
				//verify text present on Delete dialog
				String sConfirmMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.DELETEVM.CONFIRMMSG");
				sConfirmMsg = sConfirmMsg + " " + sVMName + " ?";
				boolean bConfirmMsg = EVDC_Advanced.getNav_EVDCDeleteVMPopup().getText().contains(sConfirmMsg);
				FrameworkUtil.updateCustomResultBasedOnStatus(bConfirmMsg,sConfirmMsg);
				WebObjectUtil.clickElement(EVDC_Advanced.getNav_EVDCDeleteVMBtn());
				
				//verify text present on confirmation dialog
				WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_RefreshPopUpMsg());
				String sSuccessMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.DELETEVM.SUCCESSMSG");
				sSuccessMsg = sSuccessMsg + " " + sVMName;
				boolean bSuccessMsg = EVDC_Advanced.getNav_EVDCConfirmPopup().getText().contains(sSuccessMsg);
				FrameworkUtil.updateCustomResultBasedOnStatus(bSuccessMsg,sSuccessMsg);
				WebObjectUtil.clickElement(EVDC_Advanced.getNav_EVDCConfirmPopupOkBtn());
			
				
				//verify Delete success on EVDC main page
				WebObjectUtil.waitForElementNotPresent(EVDC_Advanced.getNav_EVDCConfirmPopupOkBtn());
				bSuccessMsg = EVDC_Advanced.getNav_EVDCSuccessMsg().getText().contains(sSuccessMsg);
				FrameworkUtil.updateCustomResultBasedOnStatus(bSuccessMsg, sSuccessMsg);
				//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				bStatus =true;
			} catch (Exception e) {
				LoggerUtil.log_type_error("Exception occured:" + e.getMessage());
			}
		 return bStatus;
	 }
	 
	 

	 public static boolean verifyCopyVM(){
		 boolean bStatus = false,bSuccessMsg;
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,EVDC_VMPF);
			PageFactory.initElements(driver,EVDC_OverviewPF);
			PageFactory.initElements(driver,EVDC_Advanced);
		 try {			
				
				//Verify Copy VM dialog
				WebObjectUtil.clickAndVerifyElement(EVDC_Advanced.getNav_EVDCAdvancedActionsLink(),EVDC_Advanced.getNav_EVDCcopyVMLink());
				WebObjectUtil.clickAndVerifyElement(EVDC_Advanced.getNav_EVDCcopyVMLink(),EVDC_Advanced.getNav_EVDCcopyVMnameEdit());

				String sNewVMname = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.COPYVM.VMNAME");
				sNewVMname = sNewVMname + FrameworkUtil.sTimeStamp;
				WebObjectUtil.SetValueEdit(EVDC_Advanced.getNav_EVDCcopyVMnameEdit(), sNewVMname);
				if (WebObjectUtil.isElementPresent(EVDC_Advanced.getNav_EVDCcopyVMnameParentDropdown()))
				{
					WebObjectUtil.clickElement(EVDC_Advanced.getNav_EVDCcopyVMnameParentDropdown());
					WebObjectUtil.explicitWait(2);
					WebObjectUtil.selectCustomWebList(EVDC_Advanced.getNav_EVDCcopyVMnameDropdown(), 1);
					WebObjectUtil.explicitWait(2);
					WebObjectUtil.clickElement(EVDC_Advanced.getNav_EVDCcopyVMBotton());
				}
				//WebObjectUtil.clickElement(EVDC_Advanced.getNav_EVDCcopyVMBtn());
				
				//verify text present on Copy dialog
				String sConfirmMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.COPYVM.CONFIRMMSG");
				sConfirmMsg = sConfirmMsg + " " + sVMName + " as " + sNewVMname + " ?";
				boolean bConfirmMsg = EVDC_Advanced.getNav_EVDCcopyVMPopup().getText().contains(sConfirmMsg);
				FrameworkUtil.updateCustomResultBasedOnStatus(bConfirmMsg,sConfirmMsg);
				//WebObjectUtil.clickElement(EVDC_Advanced.getNav_EVDCConfirmPopupOkBtn());
				WebObjectUtil.clickElement(EVDC_Advanced.getNav_EVDCcopyOkBtn());
				
				//verify text present on confirmation dialog
				//WebObjectUtil.waitForElementNotPresent(EVDC.getNav_RefreshPopUpMsg());
				String sSuccessMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.COPYVM.SUCCESSMSG");
				sSuccessMsg = sSuccessMsg + " " + sVMName + " as " + sNewVMname + " has been successfully submitted" ;
				if (WebObjectUtil.isElementPresent(EVDC_Advanced.getNav_EVDCConfirmPopup())){
					bSuccessMsg = EVDC_Advanced.getNav_EVDCConfirmPopup().getText().contains(sSuccessMsg);
					FrameworkUtil.updateCustomResultBasedOnStatus(bSuccessMsg,sSuccessMsg);
					WebObjectUtil.clickElement(EVDC_Advanced.getNav_EVDCConfirmPopupOkBtn());
				}
				
				//verify Copy success on EVDC main page
				//WebObjectUtil.waitForElementNotPresent(EVDC_Advanced.getNav_EVDCConfirmPopupOkBtn());
				bSuccessMsg = EVDC_Advanced.getNav_EVDCSuccessMsg().getText().contains(sSuccessMsg);
				FrameworkUtil.updateCustomResultBasedOnStatus(bSuccessMsg, sSuccessMsg);
				//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				bStatus =true;
			} catch (Exception e) {
				LoggerUtil.log_type_error("Exception occured:" + e.getMessage());
			}
		 return bStatus;
	 }
	 

	 //UserPermission for Role E
		public static boolean navigateAndExpandVMforRoleE(String VMnameOrStatus){
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,EVDC_VMPF);
			PageFactory.initElements(driver,EVDC_OverviewPF);
			PageFactory.initElements(driver,EVDC_Advanced);
			boolean bStatus = false;
			try {
				
				int iRowNo;
				//Clicking on EVDC Name and validating its landing page

				WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
				WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine(),EVDC_VMPF.getNav_PDFImg());
					//iRowNo = getRow_EVDC_VMTable(EVDC_Advanced.getNav_EVDCVMTable(),VMnameOrStatus,"");
				iRowNo = getRow_EVDC_VMTable(EVDC_VMPF.getNav_VMWebTable(),VMnameOrStatus,"");
				
				if (iRowNo > 0 ){
					bStatus = true;
					expandVMbyRowNum(iRowNo);
				}
				iVisibleVMRowNum = iRowNo;
			} catch (Exception e) {
				LoggerUtil.log_type_error("Exception occured:" + e.getMessage());
			}

			return bStatus;
		}
	 
		
		public static boolean refreshAndExpandVM(String VMnameOrStatus){
			boolean bStatus = false;
			int iRowNo;
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,EVDC_VMPF);
			PageFactory.initElements(driver,EVDC_OverviewPF);
			PageFactory.initElements(driver,EVDC_Advanced);
			
			try {
				WebDriverUtil.refreshBrowser();
				iRowNo = getRow_EVDC_VMTable(EVDC_VMPF.getNav_VMWebTable(),VMnameOrStatus,"");
				if (iRowNo > 0 ){
					bStatus = true;
					expandVMbyRowNum(iRowNo);
				}
			} catch (Exception e) {
				LoggerUtil.log_type_error("Exception occured:" + e.getMessage());
			}

			return bStatus;
		}
		
	 
	//update each @test result in custom result file
	@AfterMethod
	public static void afterEachMethod(){
		FrameworkUtil.updateTestCaseStatusinResult();
		
	}
	
	
}
