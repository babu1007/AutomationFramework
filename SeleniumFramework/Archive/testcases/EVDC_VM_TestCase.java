package com.whs.navigator.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.CustomWebElementUtil;
import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.commonUtil.WebTableUtil;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.EVDC_VM_PageFactory;
import com.whs.navigator.pagefactory.HomePageFactory;

public class EVDC_VM_TestCase {
	
	public static EVDC_OverviewPageFactory EVDC_OverviewPF= new EVDC_OverviewPageFactory();
	public static EVDC_VM_PageFactory EVDC_VMPF=new EVDC_VM_PageFactory();
	public static HomePageFactory Home = new HomePageFactory();
	public static boolean sLoginExpandVM = false ;
	static boolean bVMStoppedStatus = false;
	static boolean bVMStartStatus = false ;
	static String sEVDCurl = null;

	

	/*==============================================================
	TestScript  	: navPDF_CSV_IconValidation
	Manual TestCase	: Check for export to PDF feature on Virtual machines page
					  Check for export to CSV feature on Virtual machines page
	Description		: Verifying the PDF Icon and its URL contains "format=pdf". and
					  Verifying the CSV Icon and its URL contains "format=pdf".
	Note			: We are not verifying the PDF and CSV content
	Author 			: Vivek Kumar
	Creation Date 	: 02/13/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=8)
	public void navPDF_CSV_IconValidation() 
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		String sUserName,sPassword,sPDFLnkTxt,sCSVLnkTxt;
		boolean bPDFStatus=false, bCSVStatus=false;
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navPDF_CSV_IconValidation";
			FrameworkUtil.sManualTestCaseName="1.Check for export to PDF feature on Virtual machines page" + '\n' + "2.Check for export to CSV feature on Virtual machines page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			EVDC_Overview_TestCase.navEVDCLogin();
			//Verifying DataCenter Name and EVDc Portlet
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCname());
			//Verifying VM-Count
			WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_VMCountNumberLink());
			//Verifying PDF Icon on VM Machine portlet
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_PDFImg());
			//Verifying the PDF Icon contains "format=pdf"
			 sPDFLnkTxt=EVDC_VMPF.getNav_PDFLink().getAttribute("href");
			 bPDFStatus= sPDFLnkTxt.contains("format=pdf");
			 FrameworkUtil.updateCustomResultBasedOnStatus(bPDFStatus, "PDF link contains  format=pdf");
						
			//Verifying CSV Icon on VM Machine portlet
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_CSVImg());
			//Verifying the CSV Icon contains "format=csv"
			sCSVLnkTxt=EVDC_VMPF.getNav_CSVLink().getAttribute("href");
			bCSVStatus=sCSVLnkTxt.contains("format=csv");
			FrameworkUtil.updateCustomResultBasedOnStatus(bCSVStatus, "CSV link contains format=csv");
			
			//Logging out from Navigator application
			//LoginTestCase.nav_Logout();
			EVDC_Overview_TestCase.EVDCLogout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-PDF and CSV link Validation" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	

	/*==============================================================
	TestScript  	: navEVDCVMTabListedInfo
	Manual TestCase	: View Virtual Machines page
	Description		:Verify the following columns of data appear, and in the order: and Verify Breadcrumb is correct (Home >  EVDC Overview > Virtual Machines).
	Author 			: Vivek Kumar
	Creation Date 	: 02/16/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=9)
		public void navEVDCVMTabListedInfo()
		{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, EVDC_OverviewPF);	
			PageFactory.initElements(driver, EVDC_VMPF);
		
			String sActText=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.TABLIST");
			String sExpBreadCrumb=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.BREADCRUMB");
			String[] sActArr;
			String[] sExpArr;
			String sExpDelimiter = "\\n"; 
			String sActDelimiter = "#";
			String sHomeBreadCrumb,sEVDCBreadCrumb,sVMBreadCrumb;
			String sActBreadCrumb;
				try {
					FrameworkUtil.sTestCaseName = "EVDC-navEVDCVMTabListedInfo";
					FrameworkUtil.sManualTestCaseName="View Virtual Machines page";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
										
					//Login to Navigator
					EVDC_Overview_TestCase.navEVDCLogin();
					WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_VMCountNumberLink(), EVDC_VMPF.getNav_AddVMLink());
					//Verifying BreadCrumn
					sHomeBreadCrumb=EVDC_VMPF.getNav_HomeBreadCrumb().getText();
					sEVDCBreadCrumb=EVDC_VMPF.getNav_EVDCBreadCrumb().getText();
					sVMBreadCrumb=EVDC_VMPF.getNav_VMBreadCrumb().getText();
					sActBreadCrumb= sHomeBreadCrumb +">" +sEVDCBreadCrumb+">" +sVMBreadCrumb;
					//comparing Actual Breadcrumb and Expected Breadcrumb
					if(sExpBreadCrumb.contains(sActBreadCrumb))
					{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "BreadCrumb -Verified " , "pass", sExpBreadCrumb);
						LoggerUtil.log_type_info(sExpBreadCrumb + " - Verified ");
					}
					else
					{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "BreadCrumb -not Verified " , "fail", sExpBreadCrumb);
						LoggerUtil.log_type_error(sExpBreadCrumb + " - not Verified ");
					}
					
					//Verifying The TAB List in order
					String sExpText=EVDC_VMPF.getNav_VMTabList().getText();
					sActArr=sExpText.split(sExpDelimiter);
					sExpArr=sActText.split(sActDelimiter);
					//System.out.println("Length ExpArr= " + ExpArr.length + " Length ActErr = " + ActArr.length);
					if(sActArr.length==sExpArr.length)
					{
						//System.out.println("Length ExpArr= " + ExpArr.length + " Length ActErr = " + ActArr.length);
						for(int i=0;i<sActArr.length;i++)
						{
							String ActWord=sActArr[i].trim();
							String ExpWord=sExpArr[i].trim();
							if(ActWord.equals(ExpWord))
							{

								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "ActArr -Verified " , "pass", sActArr[i]);
								LoggerUtil.log_type_info(sActArr[i] + "Verified ");
							}
							else
							{

								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "ActArr -not Verified " , "fail", sActArr[i]);
								LoggerUtil.log_type_error(sActArr[i] + "not Verified ");
							}
						}
					}
					//Logging out from Navigator application
					//LoginTestCase.nav_Logout();
					EVDC_Overview_TestCase.EVDCLogout();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("issue with-Tab List or BreadCrumb" );
					LoggerUtil.log_type_error(e.getMessage());
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
				}
		}
	
	/*==============================================================
	TestScript  	: navVMListBtns
	Manual TestCase	: Check VM list page buttons
	Description		:Verify the Create a Ticket, Start, Stop, Reset, and Suspend, Edit VM and Refresh Details buttons are displayed each VM.
	Author 			: Vivek Kumar
	Creation Date 	: 02/17/2015
	Pre-Requisites	: VM should be in Stopped state
	Revision History:
	==============================================================*/
	@Test(priority=18)
	public void navVMListBtns()
	{	
		////String sVMStatus;
		int iRowNbr;
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navVMListBtns";
			FrameworkUtil.sManualTestCaseName="1.Check VM list page buttons" + '\n' + "2. Check that Edit VM button appears in the VM";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			String sVMNameorStatus;

			sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDCLoginAndExpand(sVMNameorStatus);

			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
		
			stopRunningVM(iRowNbr);
			
		//	if (bVMStoppedStatus){
			//Verifying button
			navVerifyEditBtn(iRowNbr);
			//Verifying Refresh button
			navVerifyRefreshBtn(iRowNbr);
			//Verifying create a Ticket button
			navVerifyCreateTicketBtn(iRowNbr);
			//Verifying Start button
			navVerifyStartBtn(iRowNbr);
			//Verifying Stop button
			navVerifyStopBtn(iRowNbr);
			//verifying reset button
			navVerifyResetBtn(iRowNbr);
			//verifying Suspend button
			navVerifySuspendBtn(iRowNbr);
			
			
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-VM Status" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}

	/*==============================================================
	TestScript  	: navValNetworkDetails
	Manual TestCase	: Check Network details in the Virtual Machines page
	Description		:Verify Network Details Page
	Author 			: Vivek Kumar
	Creation Date 	: 02/17/2015
	Pre-Requisites	: VM should be in Stopped state
	Revision History:
	==============================================================*/
	@Test(priority=19)
	public void navValNetworkDetails()
	{	
		////String sVMStatus;
		int iRowNbr;
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValNetworkDetails";
			FrameworkUtil.sManualTestCaseName="Check Network details in the Virtual Machines page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
							
			
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");

			EVDCLoginAndExpand(sVMNameorStatus);
		

			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			stopRunningVM(iRowNbr);
			
			
			//Verifying Network Details Page
			navVerifyNetworkDetails(iRowNbr);
			
			
			//Logging out from Navigator application
			//LoginTestCase.nav_Logout();
			
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-Network Details" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	

	/*==============================================================
	TestScript  	: navValStorageDetails
	Manual TestCase	: Check Storage Details in the Virtual Machines page
	Description		:Verify Storage Details Page
	Author 			: Vivek Kumar
	Creation Date 	: 02/18/2015
	Pre-Requisites	: VM should be in Stopped state
	Revision History:
	==============================================================*/
	@Test(priority=20)
	public void navValStorageDetails()
	{
		////String sVMStatus;
		int iRowNbr;
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValStorageDetails";
			FrameworkUtil.sManualTestCaseName="Check Storage Details in the Virtual Machines page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
			/*//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
			//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			//Expaned Stopped VM
			//iRowNbr=navEVDCWebTable(sVMStatus);
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,"");
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}*/
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDCLoginAndExpand(sVMNameorStatus);
			
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			stopRunningVM(iRowNbr);
			
			//Verifying Storage Details
			navVerifyStorageDetails(iRowNbr);
			
			
			//Logging out from Navigator application
			//LoginTestCase.nav_Logout();
			
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-Storage Details" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
	}
	

	/*==============================================================
	TestScript  	: navValVMStart
	Manual TestCase	: Check VM start functionality
	Description		: Check VM start functionality
	Author 			: Vivek Kumar
	Creation Date 	: 02/18/2015
	Pre-Requisites	: VM should be in Stopped state
	Revision History:
	==============================================================*/
	@Test(priority=21)
	public void navValVMStart() 
	{
		//String sVMStatus;
		int iRowNbr;
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValVMStart";
			FrameworkUtil.sManualTestCaseName="Check VM start functionality";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
			/*//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
			//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			//Expaned Stopped VM
		//	iRowNbr=navEVDCWebTable(sVMStatus);
			
			//iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,"");
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),"test_Tomsmultivapp_abhi_local","");
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}
			//System.out.println(EVDC_VM_AdvancedActions_EXTJS.sVMstatus);
			if(EVDC_VM_AdvancedActions_EXTJS.sVMstatus.contains("Running"))
			{
				navVerifyClkStopBtn(iRowNbr);
				//Thread.sleep(3000);
			}*/
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDCLoginAndExpand(sVMNameorStatus);
			
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;	
			stopRunningVM(iRowNbr);
			
			//Verifying and clicking on Start button and Verifying Start Message
			navVerifyClkStartBtn(iRowNbr);
			//Thread.sleep(5000);
			//WebObjectUtil.waitForElementPresent(EVDC.getNav_AddVMLink());
			//Logging out from Navigator application
			//EVDCLogout();
			
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-Start button" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	

	/*==============================================================
	TestScript  	: navValVMReset
	Manual TestCase	: Check VM reset functionality
	Description		:Check VM reset functionality
	Author 			: Vivek Kumar
	Creation Date 	: 02/18/2015
	Pre-Requisites	: VM should be in Stopped state
	Revision History:
	==============================================================*/
	@Test(priority=22)
	public void navValVMReset() 
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		String sVMStatus, sExpUserFeedBack, sActUserFeedBack;
		int iRowNbr;
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValVMReset";
			FrameworkUtil.sManualTestCaseName="Check VM Reset functionality";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
			sExpUserFeedBack=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.RESET.USERFEEDBACK");
			/*//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
			
			//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			//Expand Stopped VM
			//iRowNbr=navEVDCWebTable(sVMStatus);
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,"");
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}
			*/
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDCLoginAndExpand(sVMNameorStatus);
			
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;	
			stopRunningVM(iRowNbr);
			
			//Verifying and clicking on Reset button and Verifying Reset Message
			navVerifyClkResetBtn(iRowNbr);
			//Verifying UserFeedBack Button
			//Thread.sleep(50000);
			sActUserFeedBack=EVDC_VMPF.getNav_UserfeedBack().getText();
			if(sActUserFeedBack.contains(sExpUserFeedBack))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Message verified " , "pass",sExpUserFeedBack);
				LoggerUtil.log_type_info("Message " +sExpUserFeedBack+ " verified" );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Message not  verified " , "fail","Expected :"+sExpUserFeedBack +", Actual :"+sActUserFeedBack);
				
				LoggerUtil.log_type_error("Message " +sExpUserFeedBack+ " not verified" );
			}
			//Thread.sleep(5000);
			//WebObjectUtil.waitForElementPresent(EVDC.getNav_AddVMLink());
			//Logging out from Navigator application
		//	EVDCLogout();
			
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-Reset button" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	TestScript  	: navValVMStartReset
	Manual TestCase	: Check VM reset functionality
	Description		:Check VM Start and reset functionality
	Author 			: Vivek Kumar
	Creation Date 	: 02/18/2015
	Pre-Requisites	: VM should be in Stopped state
	Revision History:
	==============================================================*/
	@Test(priority=23)
	public void navValVMStartReset() throws InterruptedException
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		//String sVMStatus;
		int iRowNbr;
		
			try {
				FrameworkUtil.sTestCaseName = "EVDC-navValVMStartReset";
				FrameworkUtil.sManualTestCaseName="Check VM Reset functionality";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					
				//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
				/*
				//Login to Navigator
				navEVDCLogin();
				//Clicking on EVDC Link
				WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
				//Clicking on Virtual machine
				WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
				//Expand Stopped VM
				//iRowNbr=navEVDCWebTable(sVMStatus);
				iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,"");
				if (iRowNbr > 0 ){

					EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
				}
				*/
				String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
				EVDCLoginAndExpand(sVMNameorStatus);
				
				iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
				stopRunningVM(iRowNbr);
				
				//Verifying and clicking on Start button and Verifying Start Message
				navVerifyClkStartBtn(iRowNbr);
				Thread.sleep(30000);
				//Verifying and clicking on Reset button and Verifying Reset Message
				navVerifyClkResetBtn(iRowNbr);
				//Thread.sleep(30000);
				WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_AddVMLink());
				//Logging out from Navigator application
			//	EVDCLogout();
				
			} catch (Exception e) {
				LoggerUtil.log_type_error("issue with-Reset button" );
				LoggerUtil.log_type_error(e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
			}
		
	}
	
	
	/*==============================================================
	TestScript  	: navValVMStartSuspend
	Manual TestCase	: Check VM Suspend functionality
	Description		:Check VM Start and suspend functionality
	Author 			: Vivek Kumar
	Creation Date 	: 02/18/2015
	Pre-Requisites	: VM should be in Stopped state
	Revision History:
	==============================================================*/
	@Test(priority=24)
	public void navValVMStartSuspend() 
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		//String sVMStatus;
		int iRowNbr;
		
			try {
				FrameworkUtil.sTestCaseName = "EVDC-navValVMStartSuspend";
				FrameworkUtil.sManualTestCaseName="Check VM Suspend functionality";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					
				//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
				/*
				//Login to Navigator
				navEVDCLogin();
				//Clicking on EVDC Link
				WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
				//Clicking on Virtual machine
				WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
				//Expand Stopped VM
				//iRowNbr=navEVDCWebTable(sVMStatus);
				iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,"");
				if (iRowNbr > 0 ){

					EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
				}*/
				String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
				EVDCLoginAndExpand(sVMNameorStatus);
				
				iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
				stopRunningVM(iRowNbr);
				
				//Verifying and clicking on Start button and Verifying Start Message
				navVerifyClkStartBtn(iRowNbr);
				//Thread.sleep(30000);
				//Verifying and clicking on suspend button and Verifying suspend Message
				navVerifyClkSuspendBtn(iRowNbr);
				//Thread.sleep(30000);
				//WebObjectUtil.waitForElementPresent(EVDC.getNav_AddVMLink());
				//Logging out from Navigator application
				//EVDCLogout();
				
			} catch (Exception e) {
				LoggerUtil.log_type_error("issue with-Suspend button" );
				LoggerUtil.log_type_error(e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
			}
		
	}
	
	/*==============================================================
	TestScript  	: navValVMRefresh
	Manual TestCase	: Check  VM Refresh Details functionality
	Description		: Verify the VM is refreshed and "<VM name> successfully refreshed!" message is displayed.
	Author 			: Vivek Kumar
	Creation Date 	: 02/19/2015
	Pre-Requisites	: VM should be in Stopped state
	Revision History:
	==============================================================*/
	@Test(priority=25)
	public void navValVMRefresh() 
	{
		String sVMStatus,sVMName,sActUserFeedback,sExpUserFeedBack;
		int iRowNbr;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
			try {
				FrameworkUtil.sTestCaseName = "EVDC-navValVMRefresh";
				FrameworkUtil.sManualTestCaseName="Check  VM Refresh Details functionality";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					
				//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
				/*
				//Login to Navigator
				navEVDCLogin();
				//Clicking on EVDC Link
				WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
				//Clicking on Virtual machine
				WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
				//Expand Stopped VM
				//iRowNbr=navEVDCWebTable(sVMStatus);
				iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,"");
				if (iRowNbr > 0 ){

					EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
				}
				
				sVMName=navGetVMName(iRowNbr);*/
				String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
				EVDCLoginAndExpand(sVMNameorStatus);
				
				iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
				stopRunningVM(iRowNbr);
/*				if(!EVDC_VM_AdvancedActions_EXTJS.sVMstatus.contains("Stopped"))
				{
					navVerifyClkStopBtn(iRowNbr);
					//Thread.sleep(3000);
				
				}*/
				sVMName=navGetVMName(iRowNbr);
				
				//Verifying and clicking on Refresh button and Verifying Refresh Message
				navVerifyClkRefreshBtn(iRowNbr);
				//Thread.sleep(60000);
				//WebObjectUtil.waitForElementPresent(EVDC.getNav_AddVMLink());
				//Fetching the UserFeedBack
				
				sActUserFeedback =EVDC_VMPF.getNav_UserfeedBack().getText();
				sExpUserFeedBack=sVMName+" successfully refreshed!";
				
				//System.out.println(sActUserFeedback + '\n' + sExpUserFeedBack );
				
				if(sActUserFeedback.contains(sExpUserFeedBack))
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Refresh Message Verified " , "pass", sExpUserFeedBack);
					LoggerUtil.log_type_info("Refresh Message Verified " + sExpUserFeedBack );
				}
				else
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Refresh Message not Verified " , "fail", "Expected :"+sExpUserFeedBack +", Actual :"+sActUserFeedback);
					LoggerUtil.log_type_error("Refresh Message not Verified  "+ sExpUserFeedBack);
				}
				//Logging out from Navigator application
				
				//EVDCLogout();
				
			} catch (Exception e) {
				LoggerUtil.log_type_error("issue with-Refresh button/message" );
				LoggerUtil.log_type_error(e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
			}
	}
	
	/*==============================================================
	TestScript  	: navValVMConsole
	Manual TestCase	: View Console icon 
	Description		: Verify the VM console and Console Windows.
	Author 			: Vivek Kumar
	Creation Date 	: 02/19/2015
	Pre-Requisites	: VM should be in Running state
	Revision History:
	==============================================================*/
	@Test(priority=107)
	public void navValVMConsole()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		//String sVMStatus;
		int iRowNbr;
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValVMConsole";
			FrameworkUtil.sManualTestCaseName="View Console icon ";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
			//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.RUNNING.STATUS");
			/*
			//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			//Expand Stopped VM
			//iRowNbr=navEVDCWebTable(sVMStatus);
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,"");
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}*/
			
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.WINDOWS.VMNAME.OR.STATUS");
			EVDCLoginAndExpand(sVMNameorStatus);
			
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			startStoppedVM(iRowNbr);
/*			if(!EVDC_VM_AdvancedActions_EXTJS.sVMstatus.contains("Running"))
			{
				
				navVerifyClkStartBtn(iRowNbr);
				//Thread.sleep(3000);
				//Clicking Refresh Button and verifying message
				//navVerifyClkRefreshBtn(iRowNbr);
			}*/
			
			//Verifying Console Window
			navValConsole(iRowNbr);
			//Closing Console window
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_ConsoleClose());
			
			
			//Logging out from Navigator application
			WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_AddVMLink());
			//EVDCLogout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-Console button/message" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
	}
	
	/*==============================================================
	TestScript  	: navValUnixVMConsole
	Manual TestCase	: View Unix VM Console window page 
	Description		: Verify the ctrl-alt-delete button does not exist for a Unix VM.
	Author 			: Vivek Kumar
	Creation Date 	: 03/16/2015
	Pre-Requisites	: VM should be in Running state and OS Should be UNIX
	Revision History:
	==============================================================*/
	@Test(priority=59)
	public void navValUnixVMConsole()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		String sVMStatus,sOS;
		int iRowNbr;
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValUnixVMConsole";
			FrameworkUtil.sManualTestCaseName="View Unix VM Console window page ";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
			//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.RUNNING.STATUS");
			sOS=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.OS.UNIX");
			/*//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			//Expand Stopped VM
		//	iRowNbr= navEVDCWebTableOSnStatus(sVMStatus,sOS);
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,sOS);
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}*/
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS.RUNNING");
			EVDCLoginAndExpand(sVMNameorStatus);
			
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			
			startStoppedVM(iRowNbr);

			//Verifying Console Window
			navValConsole(iRowNbr);
			//Verifying Ctrl+Alt+Del btn is not there for Unix
			WebObjectUtil.explicitWait(3);
			if(!EVDC_VMPF.getNav_ConsoleCtrlAltDelBtn().isDisplayed())
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Btn not there for Unix VM" , "pass", "ALT+CTRL+DEL");
				LoggerUtil.log_type_info("ALT+CTRL+DEL BTN is not there for UNIX VM");
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Btn is there for Unix VM" , "fail", "ALT+CTRL+DEL");
				LoggerUtil.log_type_error("ALT+CTRL+DEL BTN is  there for UNIX VM");
			}
			//Closing Console window
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_ConsoleClose());
		
			//Logging out from Navigator application
			//WebObjectUtil.waitForElementPresent(EVDC.getNav_AddVMLink());
			EVDC_Overview_TestCase.EVDCLogout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-Unix Console button/message" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
	}
	
	

	/*==============================================================
	TestScript  	: navValEditGeneralTab
	Manual TestCase	: Check Edit VM General tab fields  
	Description		: Verify that below fields are displayed in the General tab: 1. VM Name 2. Operating System Family 3. Operating System 4. Description 5. Storage Profile 6. Cancel button 7. Save Edit button
	Author 			: Vivek Kumar
	Creation Date 	: 02/20/2015
	Pre-Requisites	: VM should be in Stopped state
	Revision History:
	==============================================================*/
	@Test(priority=26)
	public void navValEditGeneralTab()
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		//String sVMStatus;
		int iRowNbr;
		
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValEditGeneralTab";
			FrameworkUtil.sManualTestCaseName="Check Edit VM General tab fields ";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
			//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
			
			/*//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			//Expand Stopped VM
			//iRowNbr=navEVDCWebTable(sVMStatus);
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,"");
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}*/
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDCLoginAndExpand(sVMNameorStatus);
			
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			stopRunningVM(iRowNbr);
			
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
			//Verifying General Tab link
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_EditGeneralTab());
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralTab());
			//Verifying VM Name text
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_EditGeneralVMName());
			//Verifying Operating System Family text
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_EditGeneralOperatingSystemFamily());
			//Verifying OS text
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_EditGeneralOS());
			//Verifying Description text
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_EditGeneralDescription());
			//Verifying Storage Profile text
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_EditGeneralStorageprofile());
			//Verifying Save Button
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_EditVMSaveBtn());
			//Verifying Cancel Button
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_EditVMCancelBtn());
			//Closing the window
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralCloseBtn());

			//Logging out from Navigator application
			//EVDCLogout();
			
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-Edit General Window" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	
	/*==============================================================
	TestScript  	: navValEditVMNameRequired
	Manual TestCase	: Check required fields in General tab 
	Description		: Verify that VM Name is the required field in the General page
	Author 			: Vivek Kumar
	Creation Date 	: 02/20/2015
	Pre-Requisites	: VM should be in Stopped state
	Revision History:
	==============================================================*/
	@Test(priority=27)
	public void navValEditVMNameRequired()
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		//String sVMStatus;
		int iRowNbr;
		
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValEditVMNameRequired";
			FrameworkUtil.sManualTestCaseName="Check required fields in General tab  ";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
			//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
			
			/*//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			//Expand Stopped VM
			//iRowNbr=navEVDCWebTable(sVMStatus);
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,"");
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}*/
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDCLoginAndExpand(sVMNameorStatus);
			
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			
			stopRunningVM(iRowNbr);

			
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
			//Clicking in General Tab link
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralTab());
			//Verifying the star- which is indication of Mandatory field
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_EditVMNameRequired());
			//Closing the window
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralCloseBtn());

			//Logging out from Navigator application
		//	WebObjectUtil.waitForElementNotPresent(EVDC.getNav_EditGeneralCloseBtn());
			//EVDCLogout();
			
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-Edit VM required Field" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	
	/*==============================================================
	TestScript  	: navValEditVMNameLength
	Manual TestCase	: Edit VM General tab->VM Name data validation 
	Description		: Verify that the user is not able to enter more than the field limit in the VM Name.
	Author 			: Vivek Kumar
	Creation Date 	: 02/20/2015
	Pre-Requisites	: VM should be in Stopped state
	Revision History:
	==============================================================*/
	@Test(priority=28)
	public void navValEditVMNameLength()
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		String sVMStatus,sVMNameInputLt;
		int iRowNbr,iVMNameInputLt;
	
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValEditVMNameLength";
			FrameworkUtil.sManualTestCaseName="Edit VM General tab->VM Name data validation   ";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
			//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
			
			/*//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			//Expand Stopped VM
			//iRowNbr=navEVDCWebTable(sVMStatus);
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,"");
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}*/
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDCLoginAndExpand(sVMNameorStatus);
			
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			stopRunningVM(iRowNbr);

			
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
			//Clicking in General Tab link
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralTab());
			//Fetching the maxlength of the input box
			sVMNameInputLt=EVDC_VMPF.getNav_EditVMNameInput().getAttribute("maxlength");
			iVMNameInputLt=Integer.parseInt(sVMNameInputLt);
			if(iVMNameInputLt<81)
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VM Name input length  = "+  sVMNameInputLt  , "pass","" );
				LoggerUtil.log_type_info("VM Name input length = " +sVMNameInputLt );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VM Name input length= "+  sVMNameInputLt , "fail", "");
				LoggerUtil.log_type_error("VM Name input length = " +sVMNameInputLt + " and it is not equal to 80 ");
			}
			//Closing the window
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralCloseBtn());

			//Logging out from Navigator application
			
			//EVDCLogout();
			
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-Edit VM Name input length" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	TestScript  	: navValEditUpdateClose
	Manual TestCase	: Edit VM General tab->Check Close icon
					  Check that Edit VM works
	Description		: Verify that closes the Edit VM panel and edits are not saved.
					  Verify that Edit VM overlay opens to allow edits.
	Author 			: Vivek Kumar
	Creation Date 	: 02/20/2015
	Pre-Requisites	: VM should be in Stopped state
	Revision History:
	==============================================================*/
	@Test(priority=29)
	public void navValEditUpdateClose()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		//String sVMStatus;
		String sTestDescription= "test description", sGettext;
		int iRowNbr;
	
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValEditUpdateClose";
			FrameworkUtil.sManualTestCaseName="1.Edit VM General tab->Check Close icon "+ '\n' + "2.Check that Edit VM works";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			sTestDescription=sTestDescription+ "_"+ FrameworkUtil.sTimeStamp;	
			//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
			
			/*//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			//Expand Stopped VM
			//iRowNbr=navEVDCWebTable(sVMStatus);
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,"");
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}*/
			
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDCLoginAndExpand(sVMNameorStatus);
			
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			
			stopRunningVM(iRowNbr);
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
			//Clicking in General Tab link
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralTab());
			//Updating info in Description input box
			WebObjectUtil.SetValueEdit(EVDC_VMPF.getNav_EditDescriptionInput(), sTestDescription);
			//Closing the window
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralCloseBtn());
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
			//Clicking in General Tab link
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralTab());
			//Retrieving text from Description input box
			sGettext=EVDC_VMPF.getNav_EditDescriptionInput().getText();
			if(!sGettext.contains(sTestDescription))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Description field has not been updated " , "pass", "");
				LoggerUtil.log_type_info("Description field has not been updated" );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Description field has  been updated " , "fail", "");
				LoggerUtil.log_type_error("Description field has been updated");
			}
			//Closing the window
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralCloseBtn());
			
			//Logging out from Navigator application
			
			//EVDCLogout();
			
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-Edit Description Input" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	
	/*==============================================================
	TestScript  	: navValEditUpdateCancel
	Manual TestCase	: Edit VM General tab->Check Cancel button
	Description		: Verify that the closes the Edit VM panel and edits are not saved.
	Author 			: Vivek Kumar
	Creation Date 	: 02/20/2015
	Pre-Requisites	: VM should be in Stopped state
	Revision History:
	==============================================================*/
	@Test(priority=30)
	public void navValEditUpdateCancel()
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		//String sVMStatus;
		String sTestDescription= "test description", sGettext;
		int iRowNbr;
	
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValEditUpdateCancel";
			FrameworkUtil.sManualTestCaseName="Edit VM General tab->Check Cancel button ";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			sTestDescription=sTestDescription+"_"+FrameworkUtil.sTimeStamp;
			//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
			
			/*//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			//Expand Stopped VM
			//iRowNbr=navEVDCWebTable(sVMStatus);
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,"");
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}*/
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDCLoginAndExpand(sVMNameorStatus);
			
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			
			stopRunningVM(iRowNbr);
			
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
			//Clicking in General Tab link
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralTab());
			//Updating info in Description input box
			WebObjectUtil.SetValueEdit(EVDC_VMPF.getNav_EditDescriptionInput(), sTestDescription);
			//Closing the window
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMCancelBtn());
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
			//Clicking in General Tab link
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralTab());
			//Retrieving text from Description input box
			sGettext=EVDC_VMPF.getNav_EditDescriptionInput().getText();
			if(!sGettext.contains(sTestDescription))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Description field has not been updated " , "pass", "");
				LoggerUtil.log_type_info("Description field has not been updated" );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Description field has  been updated " , "fail", "");
				LoggerUtil.log_type_error("Description field has been updated");
			}
			//Closing the window
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralCloseBtn());
			
			//Logging out from Navigator application
			
		//	EVDCLogout();
			
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-Edit Description Input" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	TestScript  	: navValEditDescriptionLength
	Manual TestCase	: Edit VM General tab->Description field length 
	Description		: Verify the error message if entered more than max length in Description  
	Author 			: Vivek Kumar
	Creation Date 	: 02/20/2015
	Pre-Requisites	: VM should be in Stopped state
	Revision History:
	==============================================================*/
	@Test(priority=31)
	public void navValEditDescriptionLength()
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		String sVMStatus,sDescriptionInputLt;
		int iRowNbr,iDescriptionInputLt;
	
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValEditDescriptionLength";
			FrameworkUtil.sManualTestCaseName="Edit VM General tab->Description field length ";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
			//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
			
			/*//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			//Expand Stopped VM
			//iRowNbr=navEVDCWebTable(sVMStatus);
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,"");
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}*/
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDCLoginAndExpand(sVMNameorStatus);
			
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			
			stopRunningVM(iRowNbr);
			
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
			//Clicking in General Tab link
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralTab());
			//Fetching the maxlength of the Descritpion input box
			sDescriptionInputLt=EVDC_VMPF.getNav_EditDescriptionInput().getAttribute("maxlength");
			iDescriptionInputLt=Integer.parseInt(sDescriptionInputLt);
			if(iDescriptionInputLt<257)
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Description input length  = "+  sDescriptionInputLt  , "pass","" );
				LoggerUtil.log_type_info("Description input length = " +sDescriptionInputLt );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VM Name input length= "+  sDescriptionInputLt , "fail", "");
				LoggerUtil.log_type_error("Description input length = " +sDescriptionInputLt + " and it is not equal to 256 ");
			}
			//Closing the window
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralCloseBtn());

			//Logging out from Navigator application
			
			//EVDCLogout();
			
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-Edit  Description input length" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	
	/*==============================================================
	TestScript  	: navValEditRunningVMErrMsg
	Manual TestCase	: Check that Edit VM works only on Stopped VMs and Feedback area
	Description		: Verify that the closes the Edit VM panel and edits are not saved.
	Author 			: Vivek Kumar
	Creation Date 	: 02/20/2015
	Pre-Requisites	: VM should be in Running state
	Revision History:
	==============================================================*/
	@Test(priority=60)
	public void navValEditRunningVMErrMsg()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		String sVMStatus,sActUserFeedBack, sExpUserFeedBack;
		int iRowNbr;
	
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValEditRunningVMErrMsg";
			FrameworkUtil.sManualTestCaseName="Check that Edit VM works only on Stopped VMs and Feedback area ";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
			//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.RUNNING.STATUS");
			sExpUserFeedBack=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.EDIT.RUNNING.VM");
			/*//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			//Expand Running VM
			//iRowNbr=navEVDCWebTable(sVMStatus);
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,"");
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}*/
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS.RUNNING");
			EVDCLoginAndExpand(sVMNameorStatus);
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			
			startStoppedVM(iRowNbr);
			
			
			//Verifying and Clicking on Edit button
			//navVerifyClkEditBtn(iRowNbr);
			
			//WebElement wEdit=WebObjectUtil.GetWebElement("xpath", "//table["+iRowNbr+"]//a[text()='Edit VM']","Edit Button");
			WebElement wEdit;
			
			/*String sEditVM= WebObjectUtil.getLocatorValueFromProperty("EVDC.VM.VMTABLE.EDITVM", "PARAMETER_ROWNUMBER", iRowNbr+"");
			wEdit=WebObjectUtil.GetWebElement("xpath", sEditVM,"Edit VM Button");
			*/
		
			wEdit = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.EDITVM", "PARAMETER_ROWNUMBER", iRowNbr+"");
			if(wEdit != null)
			{

				//wEdit.click();
				WebObjectUtil.clickElement(wEdit);
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Edit Button "    , "fail","Issue With Edit Button") ;
			}
			
			//Fetching the maxlength of the Descritpion input box
			sActUserFeedBack=EVDC_VMPF.getNav_UserfeedBack().getText();
			//System.out.println(sActUserFeedBack);
			if(sActUserFeedBack.contains(sExpUserFeedBack))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Error Message Verified "    , "pass",sExpUserFeedBack) ;
				LoggerUtil.log_type_info("Error Message Verified  = " +sExpUserFeedBack );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Error Message not Verified"   , "fail", "Expected :"+sExpUserFeedBack +", Actual :"+sActUserFeedBack);
				LoggerUtil.log_type_error("Error Message Verified  =  " +sExpUserFeedBack );
			}
			

			//Logging out from Navigator application
			
			//EVDCLogout();
			
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-navValEditRunningVMErrMsg" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	TestScript  	: navValEditComputStorageAddChkDsk
	Manual TestCase	: Edit VM Compute & Storage tab->Check Add Disk link functionality
					  Edit VM Compute & Storage tab->Check Add Disk confirmation message
	Description		: Verify that the user is able to save the Disk info successfully.
	Author 			: Vivek Kumar
	Creation Date 	: 02/23/2015
	Pre-Requisites	: VM should be in Stopped state
	Revision History:
	==============================================================*/
	@Test(priority=100)
	public void navValEditComputStorageAddChkDsk() 
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		String sVMStatus,sExpUserFeedBack,sActUserFeedback,sExpUserString,sVMName;
		int iRowNbr;
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValEditComputStorageAddChkDsk";
			FrameworkUtil.sManualTestCaseName="1.Edit VM Compute & Storage tab->Check Add Disk link functionality" + '\n' + "2. Edit VM Compute & Storage tab->Check Add Disk confirmation message";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
			//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
			sExpUserString=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.ADDDISK");
			/*//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			//Expand Stopped VM
			//iRowNbr=navEVDCWebTable(sVMStatus);
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,"");
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}*/
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDCLoginAndExpand(sVMNameorStatus);
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			stopRunningVM(iRowNbr);
			
			
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
			
			//navChkEnableGuestCustomization();
			
			//EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			//navVerifyClkEditBtn(iRowNbr);
			
			
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditComputeStorage());
			//Thread.sleep(25000);
			WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_ComputeStorageAddDisk());
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_ComputeStorageAddDisk());
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMSaveBtn());
			if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_NewEVDCPopUpBody()))
			{
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_NewEVDCPopUpOKBtn());
			}
			else
			{
				WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_EditVMCommit());
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMCommit());
			}
			
			
			//Thread.sleep(60000);
			WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_RefreshPopUpMsg());
			WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_PlzWaitPopUpMsg());
			WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_RefreshPopUpMsg());
			navClickErrBtn();
			sVMName=navGetVMName(iRowNbr);
			//WebObjectUtil.waitForElementPresent(EVDC.);
			//WebObjectUtil.waitForElementNotPresent(EVDC.getNav_StartPopUpMsg());
			sActUserFeedback =EVDC_VMPF.getNav_UserfeedBack().getText();
			sExpUserFeedBack=sVMName + sExpUserString;
			//System.out.println(sActUserFeedback);
			if(sActUserFeedback.contains(sExpUserFeedBack))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message Verified "    , "pass",sExpUserFeedBack) ;
				LoggerUtil.log_type_info(" Message Verified  = " +sExpUserFeedBack );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message not Verified"   , "fail", "Expected :"+sExpUserFeedBack +", Actual :"+sActUserFeedback);
				LoggerUtil.log_type_error(" Message not Verified  =  " +sExpUserFeedBack );
			}
					
				
			//Logging out from Navigator application
		
		//	EVDCLogout();
					
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-Adding Disk" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	/*==============================================================
	TestScript  	: navValEditComputStorageTab
	Manual TestCase	: Edit VM Compute & Storage tab->Check Compute & Storage tab fields
	Description		: Verify that below fields are displayed in the Compute & Storage tab:
					  1. Hardware 2. Number of vCPUs 3. Total vRAM 4. vCPU Hot Add 5. vRAM Hot Add 6. Disks 7. Add Disk 8. Cancel and Save Edits buttons
	Author 			: Vivek Kumar
	Creation Date 	: 02/23/2015
	Pre-Requisites	: VM should be in Stopped state
	Revision History:
	==============================================================*/
	@Test(priority=33)
	public void navValEditComputStorageTab()
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		//String sVMStatus;
		int iRowNbr;
		
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValEditComputStorageTab";
			FrameworkUtil.sManualTestCaseName=" Edit VM Compute & Storage tab->Check Compute & Storage tab fields";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
			//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
			/*//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			//Expand Running VM
			//iRowNbr=navEVDCWebTable(sVMStatus);
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,"");
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}*/
			
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDCLoginAndExpand(sVMNameorStatus);
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			stopRunningVM(iRowNbr);
			
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditComputeStorage());
			//Verifying all the tab 
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_ComputeStorageTotalvRAM());
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_ComputeStoragevCPUHotAdd());
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_ComputeStoragevRAMHotAdd());
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_ComputeStorageNumOfvCPUs());
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_ComputeStorageHardware());
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_ComputeStorageDisk());
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_ComputeStorageAddDisk());
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_EditVMSaveBtn());
			if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_NewEVDCPopUpBody()))
			{
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_NewEVDCPopUpCancelBtn());
			}
			else
			{
				WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_EditVMCancelBtn());
			}
			
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralCloseBtn());
			
			
			//Logging out from Navigator application
			
		//	EVDCLogout();
			
			
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-Tab under compute and Storage" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
	}
	
	/*==============================================================
	TestScript  	: navValComputStorageAddDelIcon
	Manual TestCase	: Edit VM Compute & Storage tab->Check icon appears next to the name of added and deleted item
	Description		: Verify that icon appears next to name of added and deleted disk items.
	Author 			: Vivek Kumar
	Creation Date 	: 02/24/2015
	Pre-Requisites	: VM should be in Stopped state
	Revision History:
	==============================================================*/
	@Test(priority=101)
	public void navValComputStorageAddDelIcon()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		//String sVMStatus;
		int iRowNbr;
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValComputStorageAddDelIcon";
			FrameworkUtil.sManualTestCaseName=" Edit VM Compute & Storage tab->Check Compute & Storage tab fields";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
			//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
			/*//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			//Expand Running VM
			//iRowNbr=navEVDCWebTable(sVMStatus);
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,"");
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}*/
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDCLoginAndExpand(sVMNameorStatus);
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			stopRunningVM(iRowNbr);
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
			
			navChkEnableGuestCustomization();
			EVDC_VM_AdvancedActions.expandVMbyRowNum(iRowNbr);
			navVerifyClkEditBtn(iRowNbr);
			
			//Verifying Add and Delete Disk Icon
			 navComputeStorageAddDeleteDiskIconAppears(iRowNbr);
			//Logging out from Navigator application
			// WebObjectUtil.waitForElementPresent(EVDC.getNav_AddVMLink());
			//EVDCLogout();
			 
			
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-Add/Delete Icon" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	TestScript  	: navValComputStorageAddDelMsg
	Manual TestCase	: Edit VM Compute & Storage tab->Check undo Delete functionality.
	Description		: Verify that the confirmation message appears at the top of the screen.
	Author 			: Vivek Kumar
	Creation Date 	: 02/25/2015
	Pre-Requisites	: VM should be in Stopped state
	Revision History:
	==============================================================*/
	@Test(priority=102)
	public void navValComputStorageAddDelMsg()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		//String sVMStatus;
		int iRowNbr;
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValComputStorageAddDelMsg";
			FrameworkUtil.sManualTestCaseName="Edit VM Compute & Storage tab->Check undo Delete functionality.";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
			//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
			/*//Logi
			 * 
			 * n to Navigator
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			//Expand Stopped VM
			//iRowNbr=navEVDCWebTable(sVMStatus);
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,"");
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}*/
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDCLoginAndExpand(sVMNameorStatus);
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			stopRunningVM(iRowNbr);
			
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
			
			navChkEnableGuestCustomization();
			EVDC_VM_AdvancedActions.expandVMbyRowNum(iRowNbr);
			navVerifyClkEditBtn(iRowNbr);
			
			//Verifying Add and Delete Disk Icon
			navComputeStorageAddUndoDeleteDiskMsg(iRowNbr);
			//Logging out from Navigator application
			//WebObjectUtil.waitForElementPresent(EVDC.getNav_AddVMLink());
			//EVDCLogout();
			 
			
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-Add/Delete User Msg" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	

	/*==============================================================
	TestScript  	: navValNICTab
	Manual TestCase	: Edit VM NIC tab ->NICs tab 
	Description		:Verify the below columns are there :
				   	 NIC ID, Primary NIC, Network, IP Mode , IP Address and Status columns    
					 Verify the Add NIC link is available 
					 Verify that the Cancel and Save Edits buttons are there.                                                                                                        

	Author 			: Vivek Kumar
	Creation Date 	: 02/26/2015
	Pre-Requisites	: VM should be in Stopped state
	Revision History:
	==============================================================*/
	@Test(priority=36)
	public void navValNICTab()
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		int iRowNbr;
		//String sVMStatus;
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValNICTab";
			FrameworkUtil.sManualTestCaseName=" Edit VM NIC tab ->NICs tab .";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
			//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
			/*//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			//Expand Stopped VM
			//iRowNbr=navEVDCWebTable(sVMStatus);
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,"");
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}*/
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDCLoginAndExpand(sVMNameorStatus);
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			stopRunningVM(iRowNbr);
			
			
			
			//clicking Edit Button
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
			//Clicking NICs Tab
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditNICs());
			//Verifying NIC Id
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_NICsNICID());
			//Verifying Primary NIC
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_NICsPrimaryNIC());
			//Verifying Network
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_NICsNetwork());
			//Verifying IP Mode
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_NICsIPMode());
			//Verifying IP Address
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_NICsIPAddress());
			//Verifying Status
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_NICsStatus());
			//Verifying Add Nic
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_NICsAddNIC());
			//Verifying Save button
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_EditVMSaveBtn());
			//Verifying Cancel Button
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_EditVMCancelBtn());
			//Closing Window
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralCloseBtn());
			
			//Logging out from Navigator application
			//WebObjectUtil.waitForElementPresent(EVDC.getNav_AddVMLink());
			//EVDCLogout();
			
			
			
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-NICs Tab" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
	}
	
	/*==============================================================
	TestScript  	: navValNICSliderStatus
	Manual TestCase	: Edit VM NIC tab ->Check NICs status
	Description		: Verify that the user is able to change the status by sliding the status.                      
	Author 			: Vivek Kumar
	Creation Date 	: 03/17/2015
	Pre-Requisites	: VM should be in Stopped state
	Revision History:
	==============================================================*/
	@Test(priority=37)
	public void navValNICSliderStatus()
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		
		int iRowNbr;
		String sNicID,sNICPrimary,sNICSlider,sNICStatus;
		WebElement wNICPrimary,wNICSlider, wNICTable;
		boolean bRadioStatus,bflag=false;
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValNICSliderStatus";
			FrameworkUtil.sManualTestCaseName="Edit VM NIC tab ->Check NICs status";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
			//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
			
			/*//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			//Expand Stopped VM
			//iRowNbr=navEVDCWebTable(sVMStatus);
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,"");
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}*/
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDCLoginAndExpand(sVMNameorStatus);
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			stopRunningVM(iRowNbr);
			//clicking Edit Button
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
			//Clicking NICs Tab
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditNICs());
			//###############################################################################
			
			
			//String sNICTable="//div[@id='editNicsPanel-body']/div/table/tbody";
			//WebElement wNICTable=WebObjectUtil.GetWebElement("xpath", sNICTable, "NIC Table");
			// This object is updated on 10/14/2015 By QAA04
			wNICTable = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.NICTABLE", "", "");
			int iRowCount = WebTableUtil.getRowCount(wNICTable);
			
			for(int i=1;i<=iRowCount;i++)
			{
				sNicID =	WebTableUtil.getCellData(wNICTable, i, 1);
				//WebElement wRadioStatus=	WebTableUtil.getCellAsWebElement(wNICTable, i, 2);
				//boolean bRadioStatus=WebObjectUtil.isCheckRadioSelected(wRadioStatus);
				//sNICPrimary = "nicPrimary-" + sNicID;
				//wNICPrimary = WebObjectUtil.GetWebElement("id", sNICPrimary, "NIC Primary");
				// This object is updated on 10/14/2015 By QAA04
				wNICPrimary = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.NICTABLE.PRIMARY", "PARAMETER_NICID", sNicID);
				bRadioStatus=WebObjectUtil.isCheckRadioSelected(wNICPrimary);
				if(!bRadioStatus)
				{
					bflag=true;
					//sNICSlider="connected-"+sNicID;
					//wNICSlider=WebObjectUtil.GetWebElement("id", sNICSlider, "NIC Slider");
					// This object is updated on 10/14/2015 By QAA04
					wNICSlider = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.NICTABLE.NICSLIDER", "PARAMETER_NICID", sNicID);
					sNICStatus=wNICSlider.getAttribute("src");
					if(sNICStatus.contains("Off_Slider"))
					{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Slider is disconnect before click "    , "pass","") ;
						LoggerUtil.log_type_info("Slider is disconnect before click" );
						WebObjectUtil.clickElement(wNICSlider);
						
						sNICStatus=wNICSlider.getAttribute("src");
						if(sNICStatus.contains("On_Slider"))
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Slider is connected after click "    , "pass","") ;
							LoggerUtil.log_type_info("Slider is connected after click" );
						}
						else
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Still SLider is disconnect after click"   , "fail", "");
							LoggerUtil.log_type_error("Still SLider is disconnect after click" );
						}
						
					}
					else if(sNICStatus.contains("On_Slider"))
					{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Slider is connect before click "    , "pass","") ;
						LoggerUtil.log_type_info("Slider is connect before click" );
						WebObjectUtil.clickElement(wNICSlider);
						
						sNICStatus=wNICSlider.getAttribute("src");
						if(sNICStatus.contains("Off_Slider"))
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Slider is disconnected after click "    , "pass","") ;
							LoggerUtil.log_type_info("Slider is disconnected after click" );
						}
						else
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Still SLider is connected after click"   , "fail", "");
							LoggerUtil.log_type_error("Still SLider is connected after click" );
						}
						
					}
					//Closing Window
					WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralCloseBtn());
					break;
				}
				
			}
			
			if(!bflag)
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Edit NIC Address", "warn", "Could not find non-primary NIC");
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralCloseBtn());
			}

			
			
			/*
			//###############################################################################
			//Getting the status of first NIC
			sNICStatus=EVDC.getNav_NICStatusSlider().getAttribute("src");
			if(sNICStatus.contains("Off_Slider"))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Slider is disconnect before click "    , "pass","") ;
				LoggerUtil.log_type_info("Slider is disconnect before click" );
				WebObjectUtil.clickElement(EVDC.getNav_NICStatusSlider());
				
				sNICStatus=EVDC.getNav_NICStatusSlider().getAttribute("src");
				if(sNICStatus.contains("On_Slider"))
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Slider is connected after click "    , "pass","") ;
					LoggerUtil.log_type_info("Slider is connected after click" );
				}
				else
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Still SLider is disconnect after click"   , "fail", "");
					LoggerUtil.log_type_error("Still SLider is disconnect after click" );
				}
				
			}
			else if(sNICStatus.contains("On_Slider"))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Slider is connect before click "    , "pass","") ;
				LoggerUtil.log_type_info("Slider is connect before click" );
				WebObjectUtil.clickElement(EVDC.getNav_NICStatusSlider());
				
				sNICStatus=EVDC.getNav_NICStatusSlider().getAttribute("src");
				if(sNICStatus.contains("Off_Slider"))
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Slider is disconnected after click "    , "pass","") ;
					LoggerUtil.log_type_info("Slider is disconnected after click" );
				}
				else
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Still SLider is connected after click"   , "fail", "");
					LoggerUtil.log_type_error("Still SLider is connected after click" );
				}
				
			}
			//Closing Window
			WebObjectUtil.clickElement(EVDC.getNav_EditGeneralCloseBtn());
			
			*///Logging out from Navigator application
			//WebObjectUtil.waitForElementPresent(EVDC.getNav_AddVMLink());
		//	EVDCLogout();
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LoggerUtil.log_type_error("issue with-NICs Slider Status" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
	}
	
	
	
	
	/*==============================================================
	TestScript  	: navValAddNIC
	Manual TestCase	: Edit VM NIC tab -> Add  NIC
	Description		: Verify that the user is able to save the new NIC info successfully.                      
	Author 			: Vivek Kumar
	Creation Date 	: 02/26/2015
	Pre-Requisites	: VM should be in Stopped state
	Revision History:
	==============================================================*/
	@Test(priority=103)
	public void navValAddNIC()
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		int iRowNbr;
		String sVMStatus, sExpUserString,sVMName,sActUserFeedback,sExpUserFeedBack ;
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValAddNIC";
			FrameworkUtil.sManualTestCaseName="Edit VM NIC tab -> Add  NIC.";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
			//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
			sExpUserString=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.ADDDISK");
			/*//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			//Expand Stopped VM
			//iRowNbr=navEVDCWebTable(sVMStatus);
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,"");
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}*/
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDCLoginAndExpand(sVMNameorStatus);
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			stopRunningVM(iRowNbr);
			
			//clicking Edit Button
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
			//Clicking NICs Tab
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditNICs());
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_NICsAddNIC());
			//clciking on Save
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMSaveBtn());
			if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_NewEVDCPopUpBody()))
			{
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_NewEVDCPopUpOKBtn());
			}
			else
			{
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMCommit());
			}
			
			Thread.sleep(50000);
			WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_PlzWaitPopUpMsg());
			navClickErrBtn();
			sVMName=navGetVMName(iRowNbr);
			//WebObjectUtil.waitForElementPresent(EVDC.getNav_UserfeedBack());
			sActUserFeedback =EVDC_VMPF.getNav_UserfeedBack().getText();
			sExpUserFeedBack=sVMName+ sExpUserString;
			if(sActUserFeedback.contains(sExpUserFeedBack))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message Verified "    , "pass",sExpUserFeedBack) ;
				LoggerUtil.log_type_info(" Message Verified  = " +sExpUserFeedBack );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message not Verified"   , "fail", "Expected :"+sExpUserFeedBack +", Actual :"+sActUserFeedback);
				LoggerUtil.log_type_error(" Message not Verified  =  " +sExpUserFeedBack );
			}
			
			
			
			//Logging out from Navigator application
			//WebObjectUtil.waitForElementPresent(EVDC.getNav_AddVMLink());
			//EVDCLogout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-Add NIC" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
	}
	
	
	/*==============================================================
	TestScript  	: navValAddNICCancelBtn
	Manual TestCase	: Edit VM NIC tab ->Check Add NIC cancel button functionality
	Description		:Verify that the user is not able to save the new NIC info successfully.                      
	Author 			: Vivek Kumar
	Creation Date 	: 02/26/2015
	Pre-Requisites	: VM should be in Stopped state
	Revision History:
	==============================================================*/
	@Test(priority=39)
	public void navValAddNICCancelBtn()
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		int iRowNbr;
		String sVMStatus, sExpUserFeedback,sVMName,sActUserFeedback,sNICLimitMsg;
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValAddNICCancelBtn";
			FrameworkUtil.sManualTestCaseName=" Edit VM NIC tab ->Check Add NIC cancel button functionality";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
			//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
			sExpUserFeedback=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.CANCELNIC.MESSAGE");
			sNICLimitMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.NIC.LIMIT.MSG");
			/*//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			//Expand Stopped VM
			//iRowNbr=navEVDCWebTable(sVMStatus);
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,"");
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}*/
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDCLoginAndExpand(sVMNameorStatus);
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			stopRunningVM(iRowNbr);
			
			//clicking Edit Button
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
			//Clicking NICs Tab
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditNICs());
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_NICsAddNIC());
			//clciking on cancel btn
			if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_NewEVDCPopUpBody()))
			{
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_NewEVDCPopUpCancelBtn());
			}
			else
			{
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMCancelBtn());
			}
		
			Thread.sleep(5000);
			//WebObjectUtil.waitForElementPresent(EVDC.getNav_UserfeedBack());
			sActUserFeedback=EVDC_VMPF.getNav_UserfeedBack().getText();
			if(sActUserFeedback.contains(sExpUserFeedback))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , sExpUserFeedback , "pass","User not able to the NIC info") ;
				LoggerUtil.log_type_info(" Message Verified  = " +sExpUserFeedback + " i.e. User not able to the NIC info");
				
			}
			else if(sActUserFeedback.contains(sNICLimitMsg))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message  Verified"   , "warn", sNICLimitMsg);
				LoggerUtil.log_type_warn(" Message  Verified  =  " +sNICLimitMsg );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message not Verified"   , "fail", "Expected :"+sExpUserFeedback +", Actual :"+sActUserFeedback);
				LoggerUtil.log_type_error(" Message not Verified  =  " +sExpUserFeedback );
			}
			
			
			
			//Logging out from Navigator application
			//WebObjectUtil.waitForElementPresent(EVDC.getNav_AddVMLink());
			//EVDCLogout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-Cancel  NIC btn" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
	}
	
	
	/*==============================================================
	TestScript  	: navValNICIPAddressEditable
	Manual TestCase	: Edit VM NIC tab ->Check IP address is editable
	Description		: Verify that user is able to edit the existing NIC ip address.                     
	Author 			: Vivek Kumar
	Creation Date 	: 03/20/2015
	Pre-Requisites	: VM should be in Stopped state
	Revision History:
	==============================================================*/
	//@Test(priority=40)
	public void navValNICIPAddressEditable()
	{
		
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		String sVMStatus,sExpUserFeedback,sNICIPAddress,sActUserFeedback,sVMName,sNicID,sIPmode;
		String sNICAddress,sNICPrimary;
		int iRowNbr;
		boolean bflag=false,bRadioStatus;
		WebElement wIPmode,wNICAddress,wNICPrimary,wNICTable;
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValNICIPAddressEditable";
			FrameworkUtil.sManualTestCaseName=" Edit VM NIC tab ->Check IP address is editable";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
			//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
			sExpUserFeedback=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.ADDDISK");
			sNICIPAddress=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.NIC.IPADDRESS");
			
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDCLoginAndExpand(sVMNameorStatus);
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			stopRunningVM(iRowNbr);
			
			//clicking Edit Button
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
			sVMName=navGetVMName(iRowNbr);
			//Clicking NICs Tab
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditNICs());
			
			//###############################################
			//int iRowCnt =driver.findElements(By.xpath(".//div[@id='editNicsPanel-body']/div/table/tbody/tr")).size();
			//String sNICTable="//div[@id='editNicsPanel-body']/div/table/tbody";
			//WebElement wNICTable=WebObjectUtil.GetWebElement("xpath", sNICTable, "NIC Table");
			// This object is updated on 10/14/2015 By QAA04
			wNICTable = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.NICTABLE", "", "");
			int iRowCount = WebTableUtil.getRowCount(wNICTable);
			
			//WebTableUtil.printEachCellText(wNICTable);
			for(int i=1;i<=iRowCount;i++)
			{
				sNicID =	WebTableUtil.getCellData(wNICTable, i, 1);
				//WebElement wRadioStatus=	WebTableUtil.getCellAsWebElement(wNICTable, i, 2);
				//boolean bRadioStatus=WebObjectUtil.isCheckRadioSelected(wRadioStatus);
				//sNICPrimary = "nicPrimary-" + sNicID;
				//wNICPrimary = WebObjectUtil.GetWebElement("id", sNICPrimary, "NIC Primary");
				// This object is updated on 10/14/2015 By QAA04
				wNICPrimary = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.NICTABLE.PRIMARY", "PARAMETER_NICID", sNicID);
				bRadioStatus=WebObjectUtil.isCheckRadioSelected(wNICPrimary);
				//nicPrimary
				if(!bRadioStatus)
				{
					bflag=true;
					
					//sIPmode = "ipMode-" + sNicID;
				//	wIPmode = WebObjectUtil.GetWebElement("id", sIPmode, "IP Mode");
					// This object is updated on 10/14/2015 By QAA04
					wIPmode = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.NICTABLE.IPMODE", "PARAMETER_NICID", sNicID);
					WebObjectUtil.explicitWait(5);
					WebObjectUtil.selectWebList(wIPmode, null, "MANUAL", null);
					WebObjectUtil.explicitWait(5);
					WebObjectUtil.getElementbyTagNameValue("option", "Static Manual", "IP Mode");
					//WebObjectUtil.selectWebList(wIPmode, "Static Manual", null, null);
					WebObjectUtil.explicitWait(2);
					//sNICAddress="nicip-" + sNicID;
				//wNICAddress = WebObjectUtil.GetWebElement("id", sNICAddress, "NIC Address");
					// This object is updated on 10/14/2015 By QAA04
					wNICAddress = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.NICTABLE.NICADDRESS", "PARAMETER_NICID", sNicID);
					//Editing IP Address
					WebObjectUtil.SetValueEdit(wNICAddress, sNICIPAddress);
					//Saving and Commiting 
					WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMSaveBtn());
					Thread.sleep(3000);
					if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_NewEVDCPopUpBody()))
					{
						WebObjectUtil.clickElement(EVDC_VMPF.getNav_NewEVDCPopUpOKBtn());
					}
					else
					{
						WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMCommit());
					}
					
					
				
					WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_PlzWaitPopUpMsg());
					
					sExpUserFeedback = sVMName + " " +sExpUserFeedback;
					//System.out.println(sExpUserFeedback);
					sActUserFeedback=EVDC_VMPF.getNav_UserfeedBack().getText();
					//System.out.println(sActUserFeedback);
					navEVDCValExpectedActualMsg(sExpUserFeedback,sActUserFeedback);
					
					break;
					
				}
			}
			if(!bflag)
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Edit NIC Address", "warn", "Could not find non-primary NIC");
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralCloseBtn());
			}


			//###############################################
			
	
					
			
			
			//Logging out from Navigator application
			//EVDCLogout();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			LoggerUtil.log_type_error("issue with-IP Address- Editable" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
		
	}
	
	/*==============================================================
	TestScript  	: navValNICIPModeFunctionality
	Manual TestCase	: Edit VM NIC tab ->Check IP Mode functionality in NICs tab
	Description		: Verify below changes:                                                                                              
	 					- If IP Pool is selected, the IP Address field is not editable
						- If Static Manual is selected, the IP Address field is editable, and a result the IP Address field becomes a required field.
						- If DHCP is selected, the IP Address field is not editable                    
	Author 			: Vivek Kumar
	Creation Date 	: 03/20/2015
	Pre-Requisites	: VM should be in Stopped state
	Revision History:
	==============================================================*/
	
	@Test(priority=41)
	public void navValNICIPModeFunctionality()
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		//String sVMStatus;
		int iRowNbr;
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValNICIPModeFunctionality";
			FrameworkUtil.sManualTestCaseName="Edit VM NIC tab ->Check IP Mode functionality in NICs tab";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
			//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
			
			/*//Login to Navigator 
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			//Expand Stopped VM
			//iRowNbr=navEVDCWebTable(sVMStatus);
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,"");
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}*/
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDCLoginAndExpand(sVMNameorStatus);
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			stopRunningVM(iRowNbr);
			
			//clicking Edit Button
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
			
			//Clicking NICs Tab
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditNICs());
			
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_NICIPMode());
	
			//Selecting IP Mode as IP Pool
			WebObjectUtil.selectCustomWebList(EVDC_VMPF.getNav_NICIPModelist(), "IP Pool");
			//WebObjectUtil.selectWebList(EVDC.getNav_NICIPMode(), null, "IP Pool", null);
			if(!EVDC_VMPF.getNav_NICIPAddress().isEnabled())
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " IP Address field is disabled for IP POOL mode"   , "pass", "");
				LoggerUtil.log_type_info("IP Address field is disabled for IP POOL mode" );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " IP Address field is enabled for IP POOL mode"   , "fail", "");
				LoggerUtil.log_type_error("IP Address field is enabled for IP POOL mode" );
			}
			
			//Selecting IP Mode as Static
			//WebObjectUtil.selectWebList(EVDC.getNav_NICIPMode(), null, "MANUAL", null);
			//WebObjectUtil.selectWebList(EVDC.getNav_NICIPMode(), null, "Static Manual", null);
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_NICIPMode());
			WebObjectUtil.selectCustomWebList(EVDC_VMPF.getNav_NICIPModelist(), "Static Manual");
			if(EVDC_VMPF.getNav_NICIPAddress().isEnabled())
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " IP Address field is enabled for Static Manual mode"   , "pass", "");
				LoggerUtil.log_type_info("IP Address field is enabled for Static Manual mode" );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " IP Address field is disabled for Static Manual mode"   , "fail", "");
				LoggerUtil.log_type_error("IP Address field is diaabled for Static Manual mode" );
			}
			
			//Selecting IP Mode as DHCP
			//WebObjectUtil.selectWebList(EVDC.getNav_NICIPMode(), null, "DHCP", null);
		//	WebObjectUtil.selectWebList(EVDC.getNav_NICIPModelist(), null, "DHCP", null);
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_NICIPMode());
			WebObjectUtil.selectCustomWebList(EVDC_VMPF.getNav_NICIPModelist(), "DHCP");
			if(!EVDC_VMPF.getNav_NICIPAddress().isEnabled())
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " IP Address field is disabled for DHCP mode"   , "pass", "");
				LoggerUtil.log_type_info("IP Address field is disabled for DHCP mode" );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " IP Address field is enabled for DHCP mode"   , "fail", "");
				LoggerUtil.log_type_error("IP Address field is enabled for DHCP mode" );
			}
			
			//Closing the NIC window
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralCloseBtn());
						
			//Logging out from Navigator application
			//EVDCLogout();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			LoggerUtil.log_type_error("issue with-IP Mode-Functionality" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
		
	}
	
	
	
	
	/*==============================================================
	TestScript  	: navVal2AddDelNICMsg
	Manual TestCase	: Edit VM NIC tab -> Check multiple add and delete confirmation message
	Description		:Verify that the confirmation message like 
					 " 2 NICs have been added and 2 NICs have been deleted " appears at the top of the screen.                      
	Author 			: Vivek Kumar
	Creation Date 	: 02/27/2015
	Pre-Requisites	: VM should be in Stopped state
	Revision History:
	==============================================================*/
	@Test(priority=104)
	public void navVal2AddDelNICMsg()
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		//String sVMStatus;
		int iRowNbr, iRows,iRowCnt=0;
		
		try {
			
			FrameworkUtil.sTestCaseName = "EVDC-navVal2AddDelNICMsg";
			FrameworkUtil.sManualTestCaseName="Edit VM NIC tab -> Check multiple add and delete confirmation message";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
			//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
			
			/*//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			//Expand Stopped VM
			//iRowNbr=navEVDCWebTable(sVMStatus);
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,"");
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}*/
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDCLoginAndExpand(sVMNameorStatus);
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			stopRunningVM(iRowNbr);
			
			//clicking Edit Button
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
			
			/*navChkEnableGuestCustomization();
			EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			navVerifyClkEditBtn(iRowNbr);*/
			//Clicking NICs Tab
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditNICs());
			
			//Deleting two NIC
			iRowCnt =driver.findElements(By.xpath(".//div[@id='editNicsPanel-body']/div/table/tbody/tr")).size();
			if(!(iRowCnt>1))
			{	
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_NICsAddNIC());
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_NICsAddNIC());
				Thread.sleep(3000);
				//clciking on Save
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMSaveBtn());
				if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_NewEVDCPopUpBody()))
				{
					WebObjectUtil.clickElement(EVDC_VMPF.getNav_NewEVDCPopUpOKBtn());
				}
				else
				{
					WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_EditVMCommit());
					WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMCommit());
				}
				
				
				//Thread.sleep(3000);
				WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_PlzWaitPopUpMsg());
				WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_RefreshPopUpMsg());
				//WebObjectUtil.waitForElementPresent(EVDC.getNav_GuestOSErrorMsgOKBtn());
				/*if(EVDC.getNav_GuestOSErrorMsgOKBtn().isDisplayed())
				{
					
					String StrText=EVDC.getNav_NICAddDelErrMsg().getText();
					LoggerUtil.log_type_warn(StrText);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Warning PopUpMessage "    , "fail", StrText) ;
					WebObjectUtil.clickElement(EVDC.getNav_GuestOSErrorMsgOKBtn());
					//WebObjectUtil.waitForElementNotPresent(EVDC.getNav_GuestOSErrorMsgOKBtn());
					
				}*/
				//Thread.sleep(50000);
				navClickErrBtn();
								
				//Verifying and Clicking on Edit button
				navVerifyClkEditBtn(iRowNbr);
				//Clicking NICs Tab
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditNICs());
				
			}
			//##############################################################################
			
			
			String sNICTable,sNicID,sNICPrimary;
			int iRowCount,iDeleteCount=1;
			boolean bRadioStatus,bFlag=false;
			WebElement wNICPrimary,wDelete,wNICTable;
			
			//sNICTable="//div[@id='editNicsPanel-body']/div/table/tbody";
			//WebElement wNICTable=WebObjectUtil.GetWebElement("xpath", sNICTable, "NIC Table");
			// This object is updated on 10/14/2015 By QAA04
			wNICTable = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.NICTABLE", "", "");
			iRowCount = WebTableUtil.getRowCount(wNICTable);
			
			for(int i=1;i<=iRowCount;i++)
			{
				sNicID =	WebTableUtil.getCellData(wNICTable, i, 1);
				//WebElement wRadioStatus=	WebTableUtil.getCellAsWebElement(wNICTable, i, 2);
				//boolean bRadioStatus=WebObjectUtil.isCheckRadioSelected(wRadioStatus);
				//sNICPrimary = "nicPrimary-" + sNicID;
				//wNICPrimary = WebObjectUtil.GetWebElement("id", sNICPrimary, "NIC Primary");
				// This object is updated on 10/14/2015 By QAA04
				wNICPrimary = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.NICTABLE.PRIMARY", "PARAMETER_NICID", sNicID);
				bRadioStatus=WebObjectUtil.isCheckRadioSelected(wNICPrimary);
				
				if(!bRadioStatus && iDeleteCount < 3)
				{
					//wDelete=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+i+"]/td[7]/div/a","Delete Link");
					// This object is updated on 10/14/2015 By QAA04
					wDelete = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.NICTABLE.DELETELINK", "PARAMETER_VALUE", i+"");
					  String sText=wDelete.getText();
					  //System.out.println(sText);
					  if(sText.equalsIgnoreCase("Delete"))
					  {
						 // wDelete.click();
						  WebObjectUtil.clickElement(wDelete);
						//  bFlag=true;
						
					  }
					  iDeleteCount++;
				}	
			}
			
			iRowCount = WebTableUtil.getRowCount(wNICTable);
			//##############################################################################
			
			
			String sExpectedMsg,sActualMsg;
				
			
				if(iRowCount<9)
				{
					navEVDCValAddDelNIC(iRowNbr);
				}
				else if(iRowCount<10)
				{
					
				   sExpectedMsg="1 NIC has been added and 2 NICs have been deleted pending save edits.";
					
					WebObjectUtil.clickElement(EVDC_VMPF.getNav_NICsAddNIC());
					
					//clciking on Save
					WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMSaveBtn());
					if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_NewEVDCPopUpBody()))
					{
						WebObjectUtil.clickElement(EVDC_VMPF.getNav_NewEVDCPopUpOKBtn());
					}
					else
					{
						WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_EditVMCommit());
						WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMCommit());
					}
					sActualMsg=EVDC_VMPF.getNav_UserfeedBack().getText();
					boolean bFeedbackStatus=WebObjectUtil.compareString(sExpectedMsg, sActualMsg, true);
					FrameworkUtil.updateCustomResultBasedOnStatus(bFeedbackStatus, sActualMsg);
					//Thread.sleep(3000);
					//WebObjectUtil.waitForElementPresent(EVDC.getNav_RefreshPopUpMsg());
					WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_RefreshPopUpMsg());
					//WebObjectUtil.waitForElementPresent(EVDC.getNav_GuestOSErrorMsgOKBtn());
					//if(WebObjectUtil.isElementPresent(EVDC.getNav_GuestOSErrorMsgOKBtn()))
					if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_GuestOSErrorMsgOKBtn()))
					{
						
						LoggerUtil.log_type_error(EVDC_VMPF.getNav_GuestOSErrorMsgOKBtn().getText());
						String ErrText=EVDC_VMPF.getNav_NICAddDelErrMsg().getText();
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Erro POPUP Message ", "fail",ErrText ) ;
						WebObjectUtil.clickElement(EVDC_VMPF.getNav_GuestOSErrorMsgOKBtn());
						//WebObjectUtil.waitForElementNotPresent(EVDC.getNav_GuestOSErrorMsgOKBtn());
						
					}
				}
				
				else
				{
					 	sExpectedMsg="2 NICs have been deleted pending save edits.";
					 
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "NIC  count ", "warn","Already 10 NIC is there, we can not add more NIC" ) ;
						//clciking on Save
						WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMSaveBtn());
						if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_NewEVDCPopUpBody()))
						{
							WebObjectUtil.clickElement(EVDC_VMPF.getNav_NewEVDCPopUpOKBtn());
						}
						else
						{
							WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_EditVMCommit());
							WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMCommit());
						}
						sActualMsg=EVDC_VMPF.getNav_UserfeedBack().getText();
						
						boolean bFeedbackStatus=WebObjectUtil.compareString(sExpectedMsg, sActualMsg, true);
						FrameworkUtil.updateCustomResultBasedOnStatus(bFeedbackStatus, sActualMsg);
						//WebObjectUtil.waitForElementPresent(EVDC.getNav_RefreshPopUpMsg());
						WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_RefreshPopUpMsg());
				}
					
					
			
			
				
			//Logging out from Navigator application
			//WebObjectUtil.waitForElementPresent(EVDC.getNav_AddVMLink());
			//EVDCLogout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-Add/Delete NIC message" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
	}
	
	/*==============================================================
	TestScript  	: navValAdd10NIC
	Manual TestCase	: Edit VM NIC tab ->Check Add 10 NICs functionality
	Description		:Verify that the user is able to add 10 Nics successfully.                     
	Author 			: Vivek Kumar
	Creation Date 	: 03/19/2015
	Pre-Requisites	: VM should be in Stopped state
	Revision History:
	==============================================================*/
	@Test(priority=105)
	public void navValAdd10NIC()
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		String sVMStatus,sExpUserMessage,sActUserMessage;
		int iRowNbr, iRows,iCount,iNICMaxCnt;
		
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValAdd10NIC";
			FrameworkUtil.sManualTestCaseName=" Edit VM NIC tab ->Check Add 10 NICs functionality";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
			//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
			sExpUserMessage=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.NIC.LIMIT.MSG");
			iNICMaxCnt=Integer.parseInt((String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.NIC.MAXCOUNT"));
			
			/*
			//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			//Expand Stopped VM
			//iRowNbr=navEVDCWebTable(sVMStatus);
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,"");
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}*/
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDCLoginAndExpand(sVMNameorStatus);
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			stopRunningVM(iRowNbr);
			
			//clicking Edit Button
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
			
			navChkEnableGuestCustomization();
			EVDC_VM_AdvancedActions.expandVMbyRowNum(iRowNbr);
			navVerifyClkEditBtn(iRowNbr);
			
			//Clicking NICs Tab
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditNICs());
			//Getting the NIC row count
			iRows=WebTableUtil.getRowCount(EVDC_VMPF.getNav_NICWebTable());
		//	System.out.println(iRows)
			
			if(iRows<iNICMaxCnt)
			{
				iCount=iNICMaxCnt-iRows;
				for(int i=1;i<=iCount;i++)
				{
					//Clicking on Add NIC link
					WebObjectUtil.clickElement(EVDC_VMPF.getNav_NICsAddNIC());
				}
			}
			iRows=WebTableUtil.getRowCount(EVDC_VMPF.getNav_NICWebTable());
			if(iRows==iNICMaxCnt)
			{
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_NICsAddNIC());
				sActUserMessage=EVDC_VMPF.getNav_UserfeedBack().getText();
				//validating Actual message and Expected message
				if(WebObjectUtil.compareString(sExpUserMessage, sActUserMessage, true))
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , sExpUserMessage , "pass"," user can add 10 Nics successfully.") ;
					LoggerUtil.log_type_info(" Message Verified  = " +sExpUserMessage + " i.e.user can add 10 Nics successfully.");
					
				}
				else
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message not Verified"   , "fail", "Expected :"+sExpUserMessage +", Actual :"+sActUserMessage);
					LoggerUtil.log_type_error(" Message not Verified  =  " +sExpUserMessage );
				}
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Total NIC after adding " + iRows   , "fail", "");
				LoggerUtil.log_type_error(" Total NIC after adding  =  " +iRows );
			}
			//Closing Window
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralCloseBtn());
			
			//Logging out from Navigator application
			//WebObjectUtil.waitForElementPresent(EVDC.getNav_AddVMLink());
			//EVDCLogout();
		
				
			//Logging out from Navigator application
			//WebObjectUtil.waitForElementPresent(EVDC.getNav_AddVMLink());
		//	EVDCLogout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-Check Add 10 NICs functionality" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
	}
	

	
	
	
	/*==============================================================
	TestScript  	: navValMultipleAddDeletion
	Manual TestCase	: Check multiple add and delete confirmation message
	Description		:Verify that the confirmation message like " 2 Disks have been added and 2 Disks have been deleted " 
	`				  appears at the top of the screen.                     
	Author 			: Vivek Kumar
	Creation Date 	: 03/16/2015
	Pre-Requisites	: VM should be in Stopped state and OS should be RED HAT
	Revision History:
	==============================================================*/
	@Test(priority=44)
	public void navValMultipleAddDeletion()
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		String sVMStatus,sExpUserString,sActUserString,sExpAddMultipleAddDelMsg,sActAddMultipleAddDelMsg;
		String sOS,sVMName;
		int iRowNbr;
		
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValMultipleAddDeletion";
			FrameworkUtil.sManualTestCaseName="Check multiple add and delete confirmation message";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
			//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
			sOS=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.OPERATINGSYSTEM");
			sExpUserString=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.ADDDISK");
			sExpAddMultipleAddDelMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.MULTIPLE.ADDDEL.MSG");
		
			/*//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			//Expand Stopped VM
			//iRowNbr=navEVDCWebTableOSnStatus(sVMStatus,sOS);
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,sOS);
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}*/
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.REDHAT.VMNAME.OR.STATUS");
			EVDCLoginAndExpand(sVMNameorStatus);
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			stopRunningVM(iRowNbr);
			
			//clicking Edit Button
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
			navChkEnableGuestCustomization();
			EVDC_VM_AdvancedActions.expandVMbyRowNum(iRowNbr);
			navVerifyClkEditBtn(iRowNbr);
			
			sVMName=navGetVMName(iRowNbr);
			//Clicking on Compute Storage
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditComputeStorage());
			//Deleting two disk
			navEVDCDeleteDisk();
			navEVDCDeleteDisk();
			//Adding two disk
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_ComputeStorageAddDisk());
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_ComputeStorageAddDisk());
			//Saving and commiting
			//EVDC.getNav_EditVMSaveBtn().click();
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMSaveBtn());
			if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_NewEVDCPopUpBody()))
			{
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_NewEVDCPopUpOKBtn());
			}
			else
			{
				WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_EditVMCommit());
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMCommit());
			}
			sActAddMultipleAddDelMsg=EVDC_VMPF.getNav_UserfeedBack().getText().trim();
			WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_PlzWaitPopUpMsg());
			WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_PlzWaitPopUpMsg());
			WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_RefreshPopUpMsg());
			navClickErrBtn();
			//Thread.sleep(5000);
			
		/*	System.out.println(sExpAddMultipleAddDelMsg);
			System.out.println(sActAddMultipleAddDelMsg);
			
			System.out.println(sExpAddMultipleAddDelMsg.equalsIgnoreCase(sActAddMultipleAddDelMsg));*/
			if(WebObjectUtil.compareString(sExpAddMultipleAddDelMsg, sActAddMultipleAddDelMsg, true))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message Verified "    , "pass",sExpAddMultipleAddDelMsg) ;
				LoggerUtil.log_type_info(" Message Verified  = " +sExpAddMultipleAddDelMsg );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message not Verified"   , "fail", "Expected :"+sExpAddMultipleAddDelMsg +", Actual :"+sActAddMultipleAddDelMsg);
				LoggerUtil.log_type_error(" Message not Verified  =  " +sExpAddMultipleAddDelMsg );
			}
	
			sExpUserString=   sVMName+sExpUserString;
			sActUserString=EVDC_VMPF.getNav_UserfeedBack().getText().trim();
			
			/*System.out.println(sExpUserString);
			System.out.println(sActUserString);*/
			if(WebObjectUtil.compareString(sExpUserString, sActUserString, true))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message Verified "    , "pass",sActUserString) ;
				LoggerUtil.log_type_info(" Message Verified  = " +sActUserString );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message not Verified"   , "fail", "Expected :"+sExpUserString +", Actual :"+sActUserString);
				LoggerUtil.log_type_error(" Message not Verified  =  " +sActUserString );
			}
			
			//Logging out from Navigator application
			//WebObjectUtil.waitForElementPresent(EVDC.getNav_AddVMLink());
			//EVDCLogout();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
	}
	
	
	
	
	
	/*==============================================================
	TestScript  	: navValNegativeErrMsg
	Manual TestCase	: Edit VM Compute & Storage tab->Check negative values in Number of vCPUs & Total vRAM fields
	Description		:Verify that user is not allowed to enter negative values in the Compute & Storage fields. 
					 Verify the error message when hover over the field                      
	Author 			: Vivek Kumar
	Creation Date 	: 02/27/2015
	Pre-Requisites	: VM should be in Stopped state
	Revision History:
	==============================================================*/
	@Test(priority=45)
	public void navValNegativeErrMsg()
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		
		String sVMStatus,sExpErrorMsg,sActErrorMsg;
		int iRowNbr;
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValNegativeErrMsg";
			FrameworkUtil.sManualTestCaseName="Edit VM Compute & Storage tab->Check negative values in Number of vCPUs & Total vRAM fields";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
			//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
			sExpErrorMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.NegError.MESSAGE");
			/*//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			//Expand Stopped VM
			//iRowNbr=navEVDCWebTable(sVMStatus);
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,"");
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}*/
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDCLoginAndExpand(sVMNameorStatus);
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			stopRunningVM(iRowNbr);
			
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
			//Add Disk
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditComputeStorage());
			//Clicking on Add button
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_ComputeStorageAddDisk());
			//Inputting negative value in vCPU
			WebObjectUtil.SetValueEdit(EVDC_VMPF.getNav_ComputeStoragevCPUEdit(), "-");
			//Verifying Error message
			
			WebObjectUtil.getToolTipsMsg(EVDC_VMPF.getNav_ComputeStoragevCPUEdit(),sExpErrorMsg);
			/*WebObjectUtil.MouseHover(EVDC.getNav_ComputeStoragevCPUEdit());
			sActErrorMsg=EVDC.getNav_ComputeStoragevCPUTooltipMsg().getText();
			//System.out.println(sExpErrorMsg);
			//System.out.println(sActErrorMsg);
			if(sActErrorMsg.contains(sExpErrorMsg))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message Verified "    , "pass",sExpErrorMsg) ;
				LoggerUtil.log_type_info(" Message Verified  = " +sExpErrorMsg );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message not Verified"   , "fail", sExpErrorMsg);
				LoggerUtil.log_type_error(" Message not Verified  =  " +sExpErrorMsg );
			}*/
			//Closing the Edit Window
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralCloseBtn());
			//Logging out from Navigator application
			//WebObjectUtil.waitForElementPresent(EVDC.getNav_AddVMLink());
			//EVDCLogout();
			 
			
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-Error Message- tool tip" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
	}
	
	
	/*==============================================================
	TestScript  	: navValvCPUandvRAMmaxlength
	Manual TestCase	: Edit VM Compute & Storage tab->Check max length values in Number of vCPUs & Total vRAM fields
	Description		: Verify that user is not allowed to enter more than max values in the Compute & Storage fields.                   
	Author 			: Vivek Kumar
	Creation Date 	: 03/23/2015
	Pre-Requisites	: VM should be in Stopped state
	Revision History:
	==============================================================*/
	@Test(priority=46)
	public void navValvCPUandvRAMMaxLength()
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		String sVMStatus,sVCPUToolTipMessage,sVCPUSize,sVRAMSize,sVRAMToolTipMessage;
		int iRowNbr;
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValvCPUandvRAMmaxlength";
			FrameworkUtil.sManualTestCaseName="Edit VM Compute & Storage tab->Check max length values in Number of vCPUs & Total vRAM fields";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
			//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
			sVCPUToolTipMessage=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.COMPUTESTORAGE.VCPU.TOOLTIP.MESSAGE");
			sVCPUSize=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.COMPUTESTORAGE.VCPU.SIZE");
			sVRAMSize=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.COMPUTESTORAGE.VRAM.SIZE");
			sVRAMToolTipMessage=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.COMPUTESTORAGE.VRAM.TOOLTIP.MESSAGE");
			/*//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			//Expand Stopped VM
			//iRowNbr=navEVDCWebTable(sVMStatus);
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,"");
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}*/
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDCLoginAndExpand(sVMNameorStatus);
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			stopRunningVM(iRowNbr);
			
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
		/*	
			navChkEnableGuestCustomization();
			EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			navVerifyClkEditBtn(iRowNbr);
			*/
			
			//Add Disk
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditComputeStorage());
			//Clicking on Add button
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_ComputeStorageAddDisk());
			//Setting value in vCPU edit
			WebObjectUtil.SetValueEdit(EVDC_VMPF.getNav_ComputeStoragevCPUEdit(),sVCPUSize );
			//capturing the value
			WebObjectUtil.MouseHover(EVDC_VMPF.getNav_ComputeStoragevCPUEdit());
			//
			if(WebObjectUtil.getToolTipsMsg(EVDC_VMPF.getNav_ComputeStoragevCPUEdtParent(), sVCPUToolTipMessage))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message Verified "    , "pass",sVCPUToolTipMessage) ;
				LoggerUtil.log_type_info(" Message Verified  = " +sVCPUToolTipMessage );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message not Verified"   , "fail", sVCPUToolTipMessage);
				LoggerUtil.log_type_error(" Message not Verified  =  " +sVCPUToolTipMessage );
			}
			
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_ComputeStorageRAMUnit());
			WebObjectUtil.selectCustomWebList(EVDC_VMPF.getNav_ComputeStorageRAMUnitDropDown(), "GB");
			
			//Setting value in vRAm Edit
			WebObjectUtil.SetValueEdit(EVDC_VMPF.getNav_ComputeStoragevRAMEdit(), sVRAMSize);
			//capturing the value
			WebObjectUtil.MouseHover(EVDC_VMPF.getNav_ComputeStoragevRAMEdit());
			//
			if(WebObjectUtil.getToolTipsMsg(EVDC_VMPF.getNav_ComputeStoragevRAMEdtParent(), sVRAMToolTipMessage))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message Verified "    , "pass",sVRAMToolTipMessage) ;
				LoggerUtil.log_type_info(" Message Verified  = " +sVRAMToolTipMessage );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message not Verified"   , "fail", sVRAMToolTipMessage);
				LoggerUtil.log_type_error(" Message not Verified  =  " +sVRAMToolTipMessage );
			}
			
			//Closing the window
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralCloseBtn());
			
			//Logging out from Navigator application
			
			//EVDCLogout();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
			LoggerUtil.log_type_error("issue with-ComputeStorage-ToolTip Message" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		 
		
		
	}
	

	/*==============================================================
	TestScript  	: navValVMNameErrMsg
	Manual TestCase	: Edit VM General tab->Check Edit VM error messages in General tab
	Description		:Verify the field error messages in General tab. 
	Author 			: Vivek Kumar
	Creation Date 	: 02/27/2015
	Pre-Requisites	: VM should be in Stopped state
	Revision History:
	==============================================================*/
	@Test(priority=47)
	public void navValVMNameErrMsg()
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		String sVMStatus,sExpErrorMsg, sActErrorMsg;
		int iRowNbr;
		
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValVMNameErrMsg";
			FrameworkUtil.sManualTestCaseName="Check Edit VM General tab fields ";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			sExpErrorMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VMNAME.ERROR.MESSAGE");
			//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
			/*
			//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			//Expand Stopped VM
		//	iRowNbr=navEVDCWebTable(sVMStatus);
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,"");
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}*/
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDCLoginAndExpand(sVMNameorStatus);
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			stopRunningVM(iRowNbr);
		
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
			//Verifying General Tab link
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_EditGeneralTab());
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralTab());
			//Verifying VM Name text
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_EditGeneralVMName());
			//inputting blank space
			WebObjectUtil.SetValueEdit(EVDC_VMPF.getNav_EditVMNameInput(), "");
		
			//WebObjectUtil.getToolTipsMsg(EVDC.getNav_EditGeneralVMNameErrMsg(), sExpErrorMsg);
			WebObjectUtil.getToolTipsMsg(EVDC_VMPF.getNav_EditVMNameInput(), sExpErrorMsg);
			/*WebObjectUtil.MouseHover(EVDC.getNav_EditVMNameInput());
			sActErrorMsg=EVDC.getNav_EditGeneralVMNameErrMsg().getText();
			if(sActErrorMsg.contains(sExpErrorMsg))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message Verified "    , "pass",sExpErrorMsg) ;
				LoggerUtil.log_type_info(" Message Verified  = " +sExpErrorMsg );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message not Verified"   , "fail", sExpErrorMsg);
				LoggerUtil.log_type_error(" Message not Verified  =  " +sExpErrorMsg );
			}*/
			//Closing the window
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralCloseBtn());

			//Logging out from Navigator application
			//WebObjectUtil.waitForElementPresent(EVDC.getNav_AddVMLink());
			//EVDCLogout();
			
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-Edit General Window" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	

	/*==============================================================
	TestScript  	: navValGeneralTooltipMsg
	Manual TestCase	: Check that tooltips work for Edit VM overlay.
	Description		: Verify appropriate text appears in each info box that appears for each specific area. Please refer to the attached doc. 
	Author 			: Vivek Kumar
	Creation Date 	: 02/27/2015
	Pre-Requisites	: VM should be in Stopped state
	Revision History:
	==============================================================*/
	@Test(priority=48)
	public void navValGeneralTooltipMsg()
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		String sVMStatus,sVMNameToolTipMsg,sOSFamilyToolTipMsg,sOSToolTipMsg,sStorageProfileToolTipMsg;
		int iRowNbr;
		
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValGeneralTooltipMsg";
			FrameworkUtil.sManualTestCaseName="Check that tooltips work for Edit VM overlay. ";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			
			//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
			sVMNameToolTipMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VMNAME.TOOLTIP.MESSAGE");
			sOSFamilyToolTipMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.OSFAMILY.TOOLTIP.MESSAGE");
			sOSToolTipMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.OS.TOOLTIP.MESSAGE");
			sStorageProfileToolTipMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.STORAGEPROFILE.TOOLTIP.MESSAGE");
			/*//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			//Expand Stopped VM
			//iRowNbr=navEVDCWebTable(sVMStatus);
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,"");
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}*/
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDCLoginAndExpand(sVMNameorStatus);
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			stopRunningVM(iRowNbr);
			
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
			//Verifying General Tab link
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_EditGeneralTab());
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralTab());
			//Verifying VM Name text
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_EditGeneralVMName());
			//verifying the tool tip for VM Name
			WebObjectUtil.getToolTipsMsg(EVDC_VMPF.getNav_EditVMNameToolTipMsg(), sVMNameToolTipMsg);
			//WebObjectUtil.ClickAndMouseHover(EVDC.getNav_EditVMNameToolTipMsg());
			//WebObjectUtil.VerifyTextOnPage(sVMNameToolTipMsg);
			//Verifying Tooltip for OS Family
			WebObjectUtil.getToolTipsMsg(EVDC_VMPF.getNav_EditOSFamilyToolTipMsg(), sOSFamilyToolTipMsg);
			
			//Verifying OS tooltip message
			WebObjectUtil.getToolTipsMsg(EVDC_VMPF.getNav_EditOSToolTipMsg(), sOSToolTipMsg);
			
			//Verifying Storage Profile Tool Tip Message
			WebObjectUtil.getToolTipsMsg(EVDC_VMPF.getNav_EditStorageProfileToolTipMsg(), sStorageProfileToolTipMsg);
			
					
			//Closing the window
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralCloseBtn());

			//Logging out from Navigator application
			//WebObjectUtil.waitForElementPresent(EVDC.getNav_AddVMLink());
			//EVDCLogout();
			
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-Edit General Tool tip" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*###############################################################
	 ################################################################
	 Guest OS Customization Tab
	 */

	/*==============================================================
	TestScript  	: navValGuestOSCustPage
	Manual TestCase	: Edit VM Guest OS Customization tab-> Check Guest OS Customization tab fields
	Description		: Verify the fields that are displayed in the Guest OS Customization page 
	Author 			: Vivek Kumar
	Creation Date 	: 03/02/2015
	Pre-Requisites	: VM should be in Stopped state
	Revision History:
	==============================================================*/
	@Test(priority=49)
	public void navValGuestOSCustPage()
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		//String sVMStatus;
		int iRowNbr;
		
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValGuestOSCustPage";
			FrameworkUtil.sManualTestCaseName="Edit VM Guest OS Customization tab-> Check Guest OS Customization tab fields ";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			
			//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
			
			/*//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			//Expand Stopped VM
			//iRowNbr=navEVDCWebTable(sVMStatus);
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,"");
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}*/
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDCLoginAndExpand(sVMNameorStatus);
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			stopRunningVM(iRowNbr);
			
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
			//Verifying Guest OS Customization Tab and Verify its landing page
			WebObjectUtil.clickAndVerifyElement(EVDC_VMPF.getNav_EditGuestOSCust(), EVDC_VMPF.getNav_GuestOSCustPwdResetText());
			//Closing the window
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralCloseBtn());

			//Logging out from Navigator application
			//WebObjectUtil.waitForElementPresent(EVDC.getNav_AddVMLink());
			//EVDCLogout();
			
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-Guest OS customization Landing Page" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	TestScript  	: navValHostNameFieldLt
	Manual TestCase	: Edit VM Guest OS Customization tab ->Check Host Name field length
	Description		: Verify that user is not allowed to enter more than 15 characters in the Host Name field.
	Author 			: Vivek Kumar
	Creation Date 	: 03/02/2015
	Pre-Requisites	: VM should be in Stopped state
	Revision History:
	==============================================================*/
	@Test(priority=50)
	public void navValHostNameFieldLt()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		String sVMNameorStatus,sHostNameLength;
		int iHostNameLength;
		
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValHostNameFieldLt";
			FrameworkUtil.sManualTestCaseName="Edit VM Guest OS Customization tab ->Check Host Name field length ";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					
			//Validating Host Name for Windows VM
			 sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.WINDOWS.VMNAME.OR.STATUS");
			 sHostNameLength=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.WINDOWS.HOSTNAME.LENGTH");
			iHostNameLength=Integer.parseInt(sHostNameLength);
			navValHostNameFldLt(sVMNameorStatus,iHostNameLength);
			
			//Validating Host Name for NON-Windows VM
			 sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			 sHostNameLength=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.NON.WINDOWS.HOSTNAME.LENGTH");
			iHostNameLength=Integer.parseInt(sHostNameLength);
			navValHostNameFldLt(sVMNameorStatus,iHostNameLength);
			
			
			
			//Logging out from Navigator application
			//EVDCLogout();
			
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-Host Name Field length" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	TestScript  	: navValUserNameRequired
	Manual TestCase	: Edit VM Guest OS Customization tab ->Check required fields
	Description		: Verify the message that is displayed as "The User Name field must be filled" in the top left side. 
	Author 			: Vivek Kumar
	Creation Date 	: 03/02/2015
	Pre-Requisites	: VM should be in Stopped state and OS should be WINDOWS
	Revision History:
	==============================================================*/
	@Test(priority=51)
	public void navValUserNameRequired()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		String sVMStatus,sExpErrorMessage,sActErrorMessage,OS;
		int iRowNbr;
		
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValUserNameRequired";
			FrameworkUtil.sManualTestCaseName=" Edit VM Guest OS Customization tab ->Check required fields";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			
			//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
			sExpErrorMessage=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.GUSET.OS.CHANGESID.ERROR.MESSAGE");
			OS=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.OS.WINDOWS");
			/*//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			//Expand Stopped VM
		//	iRowNbr=navEVDCWebTable(sVMStatus);
			//iRowNbr=navEVDCWebTableOSnStatus(sVMStatus,OS);
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,OS);
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}*/

			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.WINDOWS.VMNAME.OR.STATUS");
			EVDCLoginAndExpand(sVMNameorStatus);
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			stopRunningVM(iRowNbr);
			
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
			//Verifying Guest OS Customization Tab and Verify its landing page
			WebObjectUtil.clickAndVerifyElement(EVDC_VMPF.getNav_EditGuestOSCust(), EVDC_VMPF.getNav_GuestOSCustPwdResetText());
			//Enable Guest Customization and Change SID
			WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_GustCustomizationChkBox());
			WebObjectUtil.deSelectCheckBox(EVDC_VMPF.getNav_GustCustomizationChkBox());
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_GustCustomizationChkBox());
			//Enable Change SID
			WebObjectUtil.deSelectCheckBox(EVDC_VMPF.getNav_GuestOSChangeSID());
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_GuestOSChangeSID());
			
			//Clicking on Save Button
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMSaveBtn());
			//Click on Commit
			if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_NewEVDCPopUpBody()))
			{
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_NewEVDCPopUpOKBtn());
			}
			else
			{
				WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_EditVMCommit());
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMCommit());
			}
			
			//Thread.Sleep(60000);
			WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_RefreshPopUpMsg());
			
			//Verifying the error message
			/*sActErrorMessage=EVDC.getNav_GuestOSChangeSIDErrMsg().getText();
			//System.out.println(sActErrorMessage);
			if(sActErrorMessage.contains(sExpErrorMessage))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "pop msg Message Verified" , "pass",sActErrorMessage );
				LoggerUtil.log_type_info("Message Verified = " +sActErrorMessage );
				WebObjectUtil.clickElement(EVDC.getNav_GuestOSErrorMsgOKBtn());
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "pop msg Message Not Verified " , "fail", sActErrorMessage);
				LoggerUtil.log_type_error("Message not Verified = " +sActErrorMessage );
			}*/
			//Thread.Sleep(10000);
			//WebObjectUtil.waitForElementPresent(EVDC.getNav_GuestOSErrorMsgOKBtn());
			//Cl;icking on OK Btn
			
			
			//Logging out from Navigator application
			
			//EVDCLogout();
			
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-Change SID Error message" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	
	/*==============================================================
	TestScript  	: navValChkSaveEdtBtn
	Manual TestCase	: Edit VM Guest OS Customization tab ->Check Save Edits button  
	Description		: Verify that the Guest OS Customization data saved successfully 
	Author 			: Vivek Kumar
	Creation Date 	: 03/04/2015
	Pre-Requisites	: VM should be in Stopped state
	Revision History:
	==============================================================*/
	@Test(priority=52)
	public void navValChkSaveEdtBtn()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		String sVMStatus,sExpMessage,sActMessage,sVMName,sUserMessage;
		int iRowNbr;
		
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValChkSaveEdtBtn";
			FrameworkUtil.sManualTestCaseName="Edit VM Guest OS Customization tab ->Check Save Edits button ";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			
			//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
			sUserMessage=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.ADDDISK");
			/*//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			//Expand Stopped VM
			//iRowNbr=navEVDCWebTable(sVMStatus);
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,"");
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}*/
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDCLoginAndExpand(sVMNameorStatus);
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			stopRunningVM(iRowNbr);
			sVMName=navGetVMName(iRowNbr);
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
			//Verifying Guest OS Customization Tab and Verify its landing page
			WebObjectUtil.clickAndVerifyElement(EVDC_VMPF.getNav_EditGuestOSCust(), EVDC_VMPF.getNav_GuestOSCustPwdResetText());
			//Enable Guest Customization and Change SID
			WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_GustCustomizationChkBox());
			WebObjectUtil.deSelectCheckBox(EVDC_VMPF.getNav_GustCustomizationChkBox());
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_GustCustomizationChkBox());
			//Enable Change SID
			WebObjectUtil.deSelectCheckBox(EVDC_VMPF.getNav_GuestOSChangeSID());
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_GuestOSChangeSID());
			
			//Clicking on Save Button
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMSaveBtn());
			//Click on Commit
			if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_NewEVDCPopUpBody()))
			{
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_NewEVDCPopUpOKBtn());
			}
			else
			{
				WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_EditVMCommit());
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMCommit());
			}
			
			WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_RefreshPopUpMsg());
			WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_RefreshPopUpMsg());
			//Thread.sleep(60000);
			navClickErrBtn();
			//Verifying the error message
			
			sActMessage=EVDC_VMPF.getNav_UserfeedBack().getText();
			sExpMessage=sVMName+ " " + sUserMessage;
			//System.out.println(sActErrorMessage);
			if(sActMessage.contains(sExpMessage))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Message Verified" , "pass",sActMessage );
				LoggerUtil.log_type_info("Message Verified = " +sActMessage );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Message Not Verified " , "fail", "Expected :"+sExpMessage +", Actual :"+sActMessage);
				LoggerUtil.log_type_error("Message not Verified = " +sActMessage );
			}


			//Logging out from Navigator application
			//WebObjectUtil.waitForElementPresent(EVDC.getNav_AddVMLink());
			//EVDCLogout();
			
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with- Save button" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	
	/*==============================================================
	TestScript  	: navValChkCancelEdtBtn
	Manual TestCase	: Edit VM Guest OS Customization tab ->Check Cancel button    
	Description		: Verify that the Guest OS Customization data is not saved successfully.   
	Author 			: Vivek Kumar
	Creation Date 	: 03/04/2015
	Pre-Requisites	: VM should be in Stopped state
	Revision History:
	==============================================================*/
	@Test(priority=53)
	public void navValChkCancelEdtBtn()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		//String sVMStatus;
		int iRowNbr;
		
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValChkCancelEdtBtn";
			FrameworkUtil.sManualTestCaseName="Edit VM Guest OS Customization tab ->Check Cancel button  ";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			
			//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
			/*
			//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			//Expand Stopped VM
			//iRowNbr=navEVDCWebTable(sVMStatus);
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,"");
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}*/
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDCLoginAndExpand(sVMNameorStatus);
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			stopRunningVM(iRowNbr);
			
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
			//Verifying Guest OS Customization Tab and Verify its landing page
			WebObjectUtil.clickAndVerifyElement(EVDC_VMPF.getNav_EditGuestOSCust(), EVDC_VMPF.getNav_GuestOSCustPwdResetText());
			//Enable Guest Customization and Change SID
			Thread.sleep(3000);
			WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_GustCustomizationChkBox());
			WebObjectUtil.deSelectCheckBox(EVDC_VMPF.getNav_GustCustomizationChkBox());
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_GustCustomizationChkBox());
			//Enable Change SID
			WebObjectUtil.deSelectCheckBox(EVDC_VMPF.getNav_GuestOSChangeSID());
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_GuestOSChangeSID());
			
			//Click on Cancel button
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMCancelBtn());
			
			if(EVDC_VMPF.getNav_AddVMLink().isDisplayed())
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Guest OS Customization data is not saved successfully" , "pass","" );
				LoggerUtil.log_type_info("Guest OS Customization data is not saved successfully" );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "There is a problem with Cancel Button" , "fail", "");
				LoggerUtil.log_type_error("There is a problem with Cancel Button"  );
			}
			
			//Logging out from Navigator application
			//WebObjectUtil.waitForElementPresent(EVDC.getNav_AddVMLink());
		//	EVDCLogout();
			
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-Cancel Button" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	
	/*==============================================================
	TestScript  	: navValChngSIDnJoinDomailFlds
	Manual TestCase	: Edit VM->Edit VM Guest OS Customization tab -> Change SID and Join Domain fields.  
	Description		: Verify that the Change SID and Join Domain fields are disabled for non windows operating system VM. 
	Author 			: Vivek Kumar
	Creation Date 	: 03/05/2015
	Pre-Requisites	: VM should be in Stopped state and OS should be RED HAT
	Revision History:
	==============================================================*/
	@Test(priority=54)
	public void navValChngSIDnJoinDomailFlds()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		String sVMStatus,OS;
		int iRowNbr;
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValChngSIDnJoinDomailFlds";
			FrameworkUtil.sManualTestCaseName="Edit VM->Edit VM Guest OS Customization tab -> Change SID and Join Domain fields.  ";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			
			//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
			OS=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.OPERATINGSYSTEM");
			
			/*//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			//Expand Stopped VM
			//iRowNbr=navEVDCWebTableOSnStatus(sVMStatus,OS);
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,OS);
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}*/
			
			
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			EVDCLoginAndExpand(sVMNameorStatus);
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			stopRunningVM(iRowNbr);
			
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
			
			WebObjectUtil.clickAndVerifyElement(EVDC_VMPF.getNav_EditGuestOSCust(), EVDC_VMPF.getNav_GuestOSCustPwdResetText());
			//Enable Guest Customization and Change SID
			Thread.sleep(5000);
			
			//Enable Change SID
			if(!EVDC_VMPF.getNav_GuestOSChangeSID().isEnabled())
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Change SID is disabled for non-Windows OS" , "pass","" );
				LoggerUtil.log_type_info("Change SID is disabled for non-Windows OS" );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Change SID is enabled for non-Windows OS" , "fail", "");
				LoggerUtil.log_type_error("Change SID is enabled for non-Windows OS"  );
			}
			
			//Enable Join Domain
			if(!EVDC_VMPF.getNav_GuestJoinDomain().isEnabled())
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Join Domain is disabled for non-Windows OS" , "pass","" );
				LoggerUtil.log_type_info("Join Domain is disabled for non-Windows OS" );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Join Domain is enabled for non-Windows OS" , "fail", "");
				LoggerUtil.log_type_error("Join Domain is enabled for non-Windows OS"  );
			}
			
			//Closing the window
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralCloseBtn());
			
			//Logging out from Navigator application
		//	WebObjectUtil.waitForElementPresent(EVDC.getNav_AddVMLink());
			//EVDCLogout();
			
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-ChangeSID/Join DOmain" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	TestScript  	: navValLocalAdminPwdChkBox
	Manual TestCase	: Edit VM-> Guest OS Customization tab validations  
	Description		: Verify that the Allow local administrator password check box is enabled after edit/save VM.  
	Author 			: Vivek Kumar
	Creation Date 	: 03/10/2015
	Pre-Requisites	: VM should be in Stopped state and OS should be RED HAT
	Revision History:
	==============================================================*/
	@Test(priority=106)
	public void navValLocalAdminPwdChkBox()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		FrameworkUtil.sTestCaseName = "EVDC-navValLocalAdminPwdChkBox";
		FrameworkUtil.sManualTestCaseName="Edit VM-> Guest OS Customization tab validations  ";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		try {
			navEVDCVerifyLocalAdmin();
			//Logging out from Navigator application
			//EVDCLogout();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	
	/*==============================================================
	TestScript  	: navValPwdRadioBtn
	Manual TestCase	: Edit VM-> Guest OS Customization tab validations  
	Description		: Verify that the radio buttons are not editable when allow local administrator password check box is disabled in the Guest OS Customization tab.
	Author 			: Vivek Kumar
	Creation Date 	: 03/11/2015
	Pre-Requisites	: VM should be in Stopped state and OS should be RED HAT
	Revision History:
	==============================================================*/
	@Test(priority=56)
	public void navValPwdRadioBtn()
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		FrameworkUtil.sTestCaseName = "EVDC-navValPwdRadioBtn";
		FrameworkUtil.sManualTestCaseName="Edit VM-> Guest OS Customization tab validations(Here we are verifying Pwd radio Btn)";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		String sVMStatus,OS;
		int iRowNbr;
		//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
		OS=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.OPERATINGSYSTEM");
		
		try {
			/*//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			//Expand Stopped VM
			//iRowNbr=navEVDCWebTableOSnStatus(sVMStatus,OS);
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatus,OS);
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}
			*/
			
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.REDHAT.VMNAME.OR.STATUS");
			EVDCLoginAndExpand(sVMNameorStatus);
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			stopRunningVM(iRowNbr);
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
			
			
			WebObjectUtil.clickAndVerifyElement(EVDC_VMPF.getNav_EditGuestOSCust(), EVDC_VMPF.getNav_GuestOSCustPwdResetText());
			//Verifying Gusest Customization check box
			//Thread.sleep(3000);
			WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_GustCustomizationChkBox());
			WebObjectUtil.selectCheckRadioBox(EVDC_VMPF.getNav_GustCustomizationChkBox());
			
			//Verifying Admin Chk box- Enabled or Disabled
			boolean bAdminChkBoxval=WebObjectUtil.isCheckRadioSelected(EVDC_VMPF.getNav_GuestAdminPwdChkBox());
			if(!bAdminChkBoxval)
			{
				boolean bAutoGenPwd=EVDC_VMPF.getNav_GusetOSAutoGenPwd().isEnabled();
				boolean bSpecificPwd=EVDC_VMPF.getNav_GuestOSSpecificPwd().isEnabled();
				
				if((!bAutoGenPwd) && (!bSpecificPwd))
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "AutoGenPwd and Specic Pwd btns radio btn are diabled" , "pass","" );
					LoggerUtil.log_type_info("AutoGenPwd and Specic Pwd btns radio btn are diabled" );
				}
				else
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "AutoGenPwd and Specic Pwd btns radio btn are enabled" , "fail", "");
					LoggerUtil.log_type_error("AutoGenPwd and Specic Pwd btns radio btn are enabled"  );
				}
			}
			else
			{
				//Uncheking the local Admin pwd chkbox
				WebObjectUtil.deSelectCheckBox(EVDC_VMPF.getNav_GuestAdminPwdChkBox());
				//Verifying the AutoGenPwd and Specific Pwd
				boolean bAutoGenPwd=EVDC_VMPF.getNav_GusetOSAutoGenPwd().isEnabled();
				boolean bSpecificPwd=EVDC_VMPF.getNav_GuestOSSpecificPwd().isEnabled();
				
				if((!bAutoGenPwd) && (!bSpecificPwd))
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "AutoGenPwd and Specic Pwd btns radio btn are diabled" , "pass","" );
					LoggerUtil.log_type_info("AutoGenPwd and Specic Pwd btns radio btn are diabled" );
				}
				else
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "AutoGenPwd and Specic Pwd btns radio btn are enabled" , "fail", "");
					LoggerUtil.log_type_error("AutoGenPwd and Specic Pwd btns radio btn are enabled"  );
				}
			}
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralCloseBtn());
			//Logging out from Navigator application
			//WebObjectUtil.waitForElementPresent(EVDC.getNav_AddVMLink());
		//	EVDCLogout();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			LoggerUtil.log_type_error("issue with-Pwd Chk box - Enabled/disabled" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
		
		
	}
	
	
	/*==============================================================
	TestScript  	: navValuserFeedBackMsg
	Manual TestCase	: Check that user feedback is appropriate based on Edit VM action taken.
	Description		: Verify the following user feedback messages appear:
						1. "<vm-name> successfully reset!"  
						- Also verify green check icon appears to left of message.
						2. "<vm-name> successfully stopped!"
						- Also verify green check icon appears to left of message.
						3. "<vm-name> successfully started!"
						- Also verify green check icon appears to left of message.
						4. "<vm-name> successfully suspended!"
						- Also verify green check icon appears to left of message.
						5. "<vm-name> successfully refreshed!"
						- Also verify green check icon appears to left of message.
						6. "<vm-name> successfully updated!
						- Also verify green check icon appears to left of message.
						7.  VM needs to be stopped before making changes! Please stop the VM before editing.  
						- Also verify red warning icon appears to left of message.
	Author 			: Vivek Kumar
	Creation Date 	: 03/19/2015
	Pre-Requisites	: VM should be in Stopped state and Running state also.
					First it should perform action on Running VM and then Stopped VM
	Revision History:
	==============================================================*/
	@Test(priority=57)
	public void navValuserFeedBackMsg()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		String sVMStatusRunning,sVMStatusStop, sVMName,sTestDescription="test description";
		String sExpResetMsg,sExpectedStopMsg,sExpStartMsg,sExpSuspendedMsg,sExpRefreshMsg,sExpSuccessMsg;
		String sExpectedMessage, sActualMessage;
		int iRowNbr;
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValuserFeedBackMsg";
			FrameworkUtil.sManualTestCaseName="Check that user feedback is appropriate based on Edit VM action taken. ";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			sTestDescription=sTestDescription+FrameworkUtil.sTimeStamp;
			sVMStatusRunning=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.RUNNING.STATUS");
			sVMStatusStop=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
			sExpResetMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.RESET.USERMSG");
			//sExpectedStopMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.STOP.USERMSG");
			//sExpStartMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.START.USERMSG");
			sExpSuspendedMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.SUSPEND.USERMSG");
			sExpRefreshMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.REFRESH.USERMSG");
			sExpSuccessMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.ADDDISK");
			/*//Login to Navigator 
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			*/
			/*		
			/
			//Expand Start VM
			//iRowNbr=navEVDCWebTable(sVMStatusRunning);
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatusRunning,"");
			//iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),"test_Tomsmultivapp_abhi_local","");
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}*/
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS.RUNNING");
			EVDCLoginAndExpand(sVMNameorStatus);
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			startStoppedVM(iRowNbr);
			sVMName=navGetVMName(iRowNbr);
			//#########################################################
			//Verifying that we can not edit when VM is running
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verifying that we can not edit when VM is running" , "Done","");
		//	============
			//navVerifyClkEditBtn(iRowNbr);
			
			//WebElement wEdit=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+ iRowNbr+"]/td/table/tbody/tr[2]//a[contains(text(),'Edit')]","Edit Button");
			
			WebElement wEdit = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.EDITVM", "PARAMETER_ROWNUMBER", iRowNbr+"");
			
			if(wEdit != null)
			{

				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button verified " , "pass","Edit button verified");
				LoggerUtil.log_type_info("Edit button verified" );
				//wEdit.click();
				WebObjectUtil.clickElement(wEdit);
				
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button not verified" , "fail", "Edit button ");
				LoggerUtil.log_type_error("Edit button not verified");
			}
//			============
			sExpectedMessage=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.EDIT.RUNNING.VM");
			sActualMessage=EVDC_VMPF.getNav_UserfeedBack().getText();
			navEVDCValExpectedActualMsg(sExpectedMessage,sActualMessage);
			WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_UserfeedBackImage());
			//#########################################################
			
			
			
			//Clicking Reset Button and verifying the userfeedback msg
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Clicking Reset Button and verifying the userfeedback msg" , "Done","");
			navVerifyClkResetBtn(iRowNbr);
			sExpectedMessage=sVMName + " " + sExpResetMsg;
			
			//Getting text from appliaction
			sActualMessage=EVDC_VMPF.getNav_UserfeedBack().getText();
			navEVDCValExpectedActualMsg(sExpectedMessage,sActualMessage);
			WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_UserfeedBackImage());
						
			
					
			///Clicking Stop Button and verifying the userfeedback msg
//----------------navVerifyClkStopBtn(iRowNbr);
			/*sExpectedMessage=sVMName + " " + sExpStopMsg;
			//Getting text from appliaction
			sActualMessage=EVDC.getNav_UserfeedBack().getText();
			navEVDCValExpectedActualMsg(sExpectedMessage,sActualMessage);
			WebObjectUtil.isElementPresent(EVDC.getNav_UserfeedBackImage());*/
			
			
			//Clicking start Button and verifying the userfeedback msg
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Clicking start Button and verifying the userfeedback msg" , "Done","");
			navVerifyClkStartBtn(iRowNbr);
			/*sExpectedMessage=sVMName + " " + sExpStartMsg;
			//Getting text from appliaction
			sActualMessage=EVDC.getNav_UserfeedBack().getText();
			navEVDCValExpectedActualMsg(sExpectedMessage,sActualMessage);
			WebObjectUtil.isElementPresent(EVDC.getNav_UserfeedBackImage());*/
			
		
			//Expand Stop VM
		//	iRowNbr=navEVDCWebTable(sVMStatusStop);
			/*iRowNbr = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMStatusStop,"");
			if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}*/
			WebDriverUtil.refreshBrowser();
			
			EVDCLoginAndExpand(sVMNameorStatus);
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			//stopRunningVM(iRowNbr);
//-------///Clicking Stop Button and verifying the userfeedback msg
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Clicking Stop Button and verifying the userfeedback msg" , "Done","");
			navVerifyClkStopBtn(iRowNbr);
			
			sVMName=navGetVMName(iRowNbr);
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
			//Clicking in General Tab link
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralTab());
			//Updating info in Description input box
			WebObjectUtil.SetValueEdit(EVDC_VMPF.getNav_EditDescriptionInput(), sTestDescription);
			//clicking on Save Edit
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMSaveBtn());
			if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_NewEVDCPopUpBody()))
			{
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_NewEVDCPopUpOKBtn());
			}
			else
			{
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMCommit());
			}
			
			
			WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_PlzWaitPopUpMsg());
			//Thread.sleep(2000);
			WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_RefreshPopUpMsg());
			//Thread.sleep(10000);
			if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_GuestOSChangeSIDErrMsg())&& (EVDC_VMPF.getNav_GuestOSChangeSIDErrMsg().isDisplayed()))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VM Update failed" , "fail",EVDC_VMPF.getNav_GuestOSChangeSIDErrMsg().getText() );
				LoggerUtil.log_type_error("VM Update failed" + EVDC_VMPF.getNav_GuestOSChangeSIDErrMsg().getText());
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_GuestOSErrorMsgOKBtn());
				
			}
			
			
			sExpectedMessage=sVMName +  sExpSuccessMsg;
			sActualMessage=EVDC_VMPF.getNav_UserfeedBack().getText();
			navEVDCValExpectedActualMsg(sExpectedMessage,sActualMessage);
			WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_UserfeedBackImage());
			
			//Clicking Suspend button and verifying userfeedback msg
			WebDriverUtil.refreshBrowser();
			EVDCLoginAndExpand(sVMNameorStatus);
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			navVerifyClkStartBtn(iRowNbr);		
			WebDriverUtil.refreshBrowser();
			EVDCLoginAndExpand(sVMNameorStatus);
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Clicking Suspend button and verifying userfeedback msg" , "Done","");
			navVerifyClkSuspendBtn(iRowNbr);
			sExpectedMessage=sVMName + " " + sExpSuspendedMsg;
			//Getting text from appliaction
			sActualMessage=EVDC_VMPF.getNav_UserfeedBack().getText();
			navEVDCValExpectedActualMsg(sExpectedMessage,sActualMessage);
			WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_UserfeedBackImage());
			
			//Clicking Refresh Button and verifying message
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Clicking Refresh Button and verifying message" , "Done","");
			navVerifyClkRefreshBtn(iRowNbr);
			sExpectedMessage=sVMName + " " + sExpRefreshMsg;
			//Getting text from appliaction
			sActualMessage=EVDC_VMPF.getNav_UserfeedBack().getText();
			navEVDCValExpectedActualMsg(sExpectedMessage,sActualMessage);
			WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_UserfeedBackImage());
			
			
			//Logging Out
			//EVDCLogout();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
		//e.printStackTrace();
		LoggerUtil.log_type_error("issue with-user feedback" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
	}
	

	/*###############################################################
	 ################################################################
	 Add Virtual Machine
	 */
	/*==============================================================
	TestScript  	: navValAddVM
	Manual TestCase	: Add VM
	Description		: Verify that the user is able to click on Add VM link
	Author 			: Vivek Kumar
	Creation Date 	: 03/02/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=10)
	public void navValAddVM()
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValAddVM";
			FrameworkUtil.sManualTestCaseName="Verify that the user is able to click on Add VM link";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			
			//Login to Navigator
			EVDC_Overview_TestCase.navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine(), EVDC_VMPF.getNav_AddVMLink());
			WebObjectUtil.clickAndVerifyElement(EVDC_VMPF.getNav_AddVMLink(), EVDC_VMPF.getNav_AddVMSelectVMType());
			//closing the window
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_AddVMCloseVM());
			//Logging out from Navigator application
			//WebObjectUtil.waitForElementPresent(EVDC.getNav_AddVMLink());
			EVDC_Overview_TestCase.EVDCLogout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-Add VM Type/Landing Page" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
	}
	
	/*==============================================================
	TestScript  	: navValVMTemplate
	Manual TestCase	:1. Add VM - >VM Type  - >VM from Template 
					 2. Add VM - Types of VM Selections
	Description		: Verify that the user is able  to select VM from Template.              
	 				  Verify that the Add Vm page is displayed with  Windstream Catalogs and Private Catalogs templates
	Author 			: Vivek Kumar
	Creation Date 	: 03/02/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=11)
	public void navValVMTemplate()
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValVMTemplate";
			FrameworkUtil.sManualTestCaseName="1. Add VM - >VM Type  - >VM from Template " + '\n' + "2. Add VM - Types of VM Selections";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			
			//Login to Navigator
			EVDC_Overview_TestCase.navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine(), EVDC_VMPF.getNav_AddVMLink());
			WebObjectUtil.clickAndVerifyElement(EVDC_VMPF.getNav_AddVMLink(), EVDC_VMPF.getNav_AddVMSelectVMType());
		
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_VMSelectType());
			//Verify the content under WebList
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_AddVMBlankVM());
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_AddVMfromTemplate());
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_AddVMfromTemplate());
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_AddVMWindstreamObject());
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_AddVMWindstreamObject());
			//closing the window
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_AddVMCloseVM());
			//Logging out from Navigator application
			//WebObjectUtil.waitForElementNotPresent(EVDC.getNav_AddVMCloseVM());
			EVDC_Overview_TestCase.EVDCLogout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-Add VM Template" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
	}
	
	/*==============================================================
	TestScript  	: navValBlankVM
	Manual TestCase	: Add VM - >VM Type  - > Blank VM
	Description		: Verify that the VM Name and Storage Profile fields are displayed In the diff page. 
	Author 			: Vivek Kumar
	Creation Date 	: 03/02/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=12)
	public void navValBlankVM()
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		

		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValBlankVM";
			FrameworkUtil.sManualTestCaseName="1. Add VM - >VM Type  - >VM from Template " + '\n' + "2. Add VM - Types of VM Selections";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			
			//Login to Navigator
			EVDC_Overview_TestCase.navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine(), EVDC_VMPF.getNav_AddVMLink());
			WebObjectUtil.clickAndVerifyElement(EVDC_VMPF.getNav_AddVMLink(), EVDC_VMPF.getNav_AddVMSelectVMType());
			
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_VMSelectType());
			//Clicking and slecting on Blank VM
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_AddVMBlankVM());
			
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_VMBlankVMName());
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_VMBlankStorageProfile());
			//Closing Blank VM window
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_VMBlankVMCloseWindow());
			//closing the window
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_AddVMCloseVM());
			//Logging out from Navigator application
			//WebObjectUtil.waitForElementNotPresent(EVDC.getNav_AddVMCloseVM());;
			EVDC_Overview_TestCase.EVDCLogout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-Add VM Template" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
	}
	
	
	/*==============================================================
	TestScript  	: navValAddBlankVMCreate
	Manual TestCase	: Add VM - >VM Type  - > VM From Template - > Add VM creation
	Description		: 1. Verify that the user is able to add VM Successfully.
	 				  2. Add VM -> New VM deploy icon
	 				  3. Check message when tried to add VM
	 				  4.Check start the VM after adding VM
	Author 			: Vivek Kumar
	Creation Date 	: 03/02/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=13)
	public void navValAddBlankVMCreate()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		String sVMName,sExpUserMsg,sActUserMsg,sEVDCOrgName;
		sVMName=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.ADDVM.NAME");
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValAddBlankVMCreate";
			FrameworkUtil.sManualTestCaseName="1. Add VM - >VM Type  - > VM From Template - > Add VM creation"+'\n'+" 2. Add VM -> New VM deploy icon"+'\n'+"3. Check message when tried to add VM"+'\n'+"4.Check start the VM after adding VM";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			sVMName=sVMName + "_"+FrameworkUtil.sTimeStamp;
			
			//Login to Navigator
			EVDC_Overview_TestCase.navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			sEVDCOrgName=navGetEVDCOrgName();
			
			 
			
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine(), EVDC_VMPF.getNav_AddVMLink());
			
			WebObjectUtil.clickAndVerifyElement(EVDC_VMPF.getNav_AddVMLink(), EVDC_VMPF.getNav_AddVMSelectVMType());
			navAddBlankVM(sVMName);
			
			//int iRow=navEVDCWebTable("Deploying");
			//============================================================
			//Getting the EVDC in the below foramt is a part of EXTJS5 change - Vivek- 10082015
			sVMName=sEVDCOrgName+"-"+sVMName.toLowerCase();
			//int iRowNo = EVDC_VM_AdvancedActions.getRow_EVDC_VMTable(EVDC.getNav_VMWebTableParent(),sVMName,"");
			CustomWebElementUtil.loadCustomElement(EVDC_VMPF.getNav_VMWebTableParent(), "table");
			int iRowNo =CustomWebElementUtil.getRowByCellText(sVMName, 1);
			//WebElement wVMStatus=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr[" + iRowNo + "]/td/table/tbody/tr[1]/td[5]/div","VM Status");
			
			
			//String sStatusText = wVMStatus.getText();
			String sStatusText = CustomWebElementUtil.getCellData(iRowNo, 5).trim();
			
					
			if(WebObjectUtil.compareString("Deploying", sStatusText, true))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , sVMName + " is Deploying successfully" , "pass","" );
				LoggerUtil.log_type_info(sVMName + " is deployed successfully" );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , sVMName + " is not deployed Successfully" , "fail", "");
				LoggerUtil.log_type_error(sVMName + " is not deployed Successfully"  );
			}
			
			//============================================================
			//Logging out from Navigator application
			//WebObjectUtil.waitForElementPresent(EVDC.getNav_AddVMLink());
			EVDC_Overview_TestCase.EVDCLogout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-Add Balnk VM " );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
			
	/*==============================================================
	TestScript  	: navValBlankVMField
	Manual TestCase	: Add VM - > check fields
	Description		:Verify that the user is able to see below fields in the Add VM page:
	 				  VM Name field, Storage Profile dropdown field, Cancel and OK buttons
	Author 			: Vivek Kumar
	Creation Date 	: 03/02/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=14)
	public void navValBlankVMField()
	{

		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValBlankVMField";
			FrameworkUtil.sManualTestCaseName="Add VM - > check fields";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			
			//Login to Navigator
			EVDC_Overview_TestCase.navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine(), EVDC_VMPF.getNav_AddVMLink());
			WebObjectUtil.clickAndVerifyElement(EVDC_VMPF.getNav_AddVMLink(), EVDC_VMPF.getNav_AddVMSelectVMType());
			
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_VMSelectType());
			//Clicking and slecting on Blank VM
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_AddVMBlankVM());
			
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_VMBlankVMName());
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_VMBlankVMNameEdit());
			//WebObjectUtil.verifyElementPresent(EVDC.getNav_VMBlankStorageProfile());
			WebObjectUtil.ClickAndMouseHover(EVDC_VMPF.getNav_VMBlankVMDropDown());
		//	WebObjectUtil.verifyElementPresent(EVDC.getNav_VMBlankVMAny());
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_VMBlankVMEMCSAN());
			
			//verifying OK Btn
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_VMBlankVMOKBtn());
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_VMBlankCancelBtn());
			//Closing VM Blank window
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_VMBlankVMCloseWindow());
			//Closing VM Blank Window
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_AddVMCloseVM());
			//Logging out from Navigator application
			//WebObjectUtil.waitForElementPresent(EVDC.getNav_AddVMLink());
			EVDC_Overview_TestCase.EVDCLogout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with- Balnk VM fields" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	TestScript  	: navValDeleteFailedVM
	Manual TestCase	: Virtual Machines  -> Delete VM
	Description		:Verify that user is able to delete the Failed VM successfully.
	Author 			: Vivek Kumar
	Creation Date 	: 03/03/2015
	Pre-Requisites	:VM Should be in Failed State
	Revision History:
	==============================================================*/
	@Test(priority=15)
	public void navValDeleteFailedVM() 
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		int iRowNbr;
		String sVMStatus;
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValDeleteFailedVM";
			FrameworkUtil.sManualTestCaseName="Virtual Machines  -> Delete VM ";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			
			sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS.FAILED");
			
			//Login to Navigator
			EVDC_Overview_TestCase.navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine(), EVDC_VMPF.getNav_AddVMLink());
			//Expand Stopped VM
			//iRowNbr=navEVDCWebTable(sVMStatus);
			iRowNbr = EVDC_VM_AdvancedActions.getRow_EVDC_VMTable(EVDC_VMPF.getNav_VMWebTable(),sVMStatus,"");
			/*if (iRowNbr > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			}*/
			
			if(iRowNbr>0)
			{
				//Verifying and Clicking on Delete Link
				navDeleteFailedVM(iRowNbr);
				//Thread.sleep(10000);
			}
			
			//Logging out from Navigator application
			//WebObjectUtil.waitForElementPresent(EVDC.getNav_AddVMLink());
			EVDC_Overview_TestCase.EVDCLogout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with- Delete Failed VM" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
	}
	
	/*==============================================================
	TestScript  	: navValVMfromTemplate
	Manual TestCase	: Add VM from templates
	Description		: Verify that the VM is not failed and successfully deployed in the Navigator.
	Author 			: Vivek Kumar
	Creation Date 	: 03/03/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=16)
	public void navValVMfromTemplate()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		String sVMName=null;
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValVMfromTemplate";
			FrameworkUtil.sManualTestCaseName="Add VM from templates";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			sVMName=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.ADDVM.NAMETEMPLATE");
			sVMName =sVMName + "_" + FrameworkUtil.sTimeStamp;
			//Login to Navigator
			EVDC_Overview_TestCase.navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine(), EVDC_VMPF.getNav_AddVMLink());
			
			WebObjectUtil.clickAndVerifyElement(EVDC_VMPF.getNav_AddVMLink(), EVDC_VMPF.getNav_AddVMSelectVMType());
			navAddVMFromTemplate(sVMName);
			
		//	Thread.sleep(10000);
			//Logging out from Navigator application
		//	WebObjectUtil.waitForElementPresent(EVDC.getNav_AddVMLink());
			EVDC_Overview_TestCase.EVDCLogout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with- ADD VM from Template" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
	}
	
	/*==============================================================
	TestScript  	: navValVMNameField
	Manual TestCase	: Add VM - > VM Name field validation
	Description		: Verify that the user is not able to enter more than 32 characters in the VM Name field.                                                                                            
	  				  Verify that the user is not able to enter numbers and special characters in the VM Name filed
	Author 			: Vivek Kumar
	Creation Date 	: 03/03/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=17)
	public void navValVMNameField()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		String sVMName;

		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValVMNameField";
			FrameworkUtil.sManualTestCaseName="Add VM - > VM Name field validation";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			sVMName=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.ADDVM.33CHARACTER");
			
			//Login to Navigator
			EVDC_Overview_TestCase.navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine(), EVDC_VMPF.getNav_AddVMLink());
			WebObjectUtil.clickAndVerifyElement(EVDC_VMPF.getNav_AddVMLink(), EVDC_VMPF.getNav_AddVMSelectVMType());
			
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_VMSelectType());
			//Clicking and slecting on Blank VM
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_AddVMBlankVM());
			//Setting VM Name>32 character
			WebObjectUtil.SetValueEdit(EVDC_VMPF.getNav_VMBlankVMNameEdit(), sVMName);
			WebObjectUtil.MouseHover(EVDC_VMPF.getNav_VMBlankVMNameEdit());
			
			//Verifying the Alert message
			WebObjectUtil.getToolTipsMsg(EVDC_VMPF.getNav_VMBlankVMNameEdit(), "Only 32 characters are allowed on the VM name");
			//WebObjectUtil.verifyElementPresent(EVDC.getNav_VMNameValidation());
			
			
			
			//Closing VM Blank window
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_VMBlankVMCloseWindow());
			//Closing VM Blank Window
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_AddVMCloseVM());
			//Logging out from Navigator application
		//	WebObjectUtil.waitForElementPresent(EVDC.getNav_AddVMLink());
			EVDC_Overview_TestCase.EVDCLogout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with- VM Name Validation" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	
	/*==============================================================
	TestScript  	: EVDC_CreateTicket
	Manual TestCase	: Check VM Create a ticket functionality
	Description		: Create Ticker from VM table                                                                                         
	  				  
	Author 			: Arularasu
	Creation Date 	: 03/23/2015
	Pre-Requisites	: VM should be in Stopped state
	Revision History:
	==============================================================*/
	@Test(priority=61)
	public void EVDC_CreateTicket(){
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		
		try {
			
			FrameworkUtil.sTestCaseName = "EVDC_CreateTicket";
			FrameworkUtil.sManualTestCaseName="Create ticker from EVDC stopped VM";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			int iRowNbr;
			/*navEVDCLogin();
			int iRowNo;
			//Clicking on EVDC Name and validating its landing page

			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(),EVDC.getNav_AddVMLink());
		
			iRowNo = EVDC_VM_AdvancedActions_EXTJS.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),"Stopped","");
			if (iRowNo > 0 ){

				EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNo);
			}
*/			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
			//String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.RUNNING.STATUS");
			EVDCLoginAndExpand(sVMNameorStatus);
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
				
			stopRunningVM(iRowNbr);
			
			VMCreateTicket(iRowNbr);
			//EVDCLogout();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	//////////////____________________ Hague test cases _______________________________________ ////////
	
	/*==============================================================
	TestScript  	: verifyNoNetworksAddVM
	Manual TestCase	: [QAT-267] [WCP] EVDC - Virtual Machines- Verify that user is able to add new VM for an org that does not have any Networks.  
	Description		: Verify that user is able to add new VM for an org that does not have any Networks.
	Author 			: QAA03
	Creation Date 	: 12/09/2015
	Release Name    : Hague
	Pre-Requisites	:
	Revision History:
==============================================================*/
	@Test(priority=7)
	public void verifyNoNetworksAddVM()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,EVDC_OverviewPF);
			PageFactory.initElements(driver, EVDC_VMPF);
				
			String sUserName=null,sPassword=null,sVMName=null;
		
		try {
			FrameworkUtil.sTestCaseName = "verifyNoNetworksAddVM";
			FrameworkUtil.sManualTestCaseName="[QAT-267] [WCP] EVDC - Virtual Machines- Verify that user is able to add new VM for an org that does not have any Networks.";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			// Username need to be added
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO1");
		    sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.PASSWORD");
		
		    sVMName=(String)FrameworkUtil.dictPropertyData.get("NAV.AUTOMATION.TEXT");
			sVMName =sVMName + "_" + FrameworkUtil.sTimeStamp;
			
			//Login to Navigator with devco1 user
			LoginTestCase.nav_Login(sUserName, sPassword);
			//Verifying Network count in Home and EVDC page
			verifyNetworkCountinHomeAndEVDCPage();
			
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine(), EVDC_VMPF.getNav_AddVMLink());
			// Clicking on Add Virtual Machine Link
			WebObjectUtil.clickAndVerifyElement(EVDC_VMPF.getNav_AddVMLink(), EVDC_VMPF.getNav_AddVMSelectVMType());
			EVDC_VM_TestCase.navAddBlankVM(sVMName);
			// Clicking on Add Virtual Machine Link
			WebObjectUtil.clickAndVerifyElement(EVDC_VMPF.getNav_AddVMLink(), EVDC_VMPF.getNav_AddVMSelectVMType());
			EVDC_VM_TestCase.navAddVMFromTemplate(sVMName);
			
			//Logout from Navigator
			LoginTestCase.nav_Logout();
	
		   } catch (Exception e) {
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyNoNetworksAddVM", "warn", "catch block:" +e.getMessage());
		}
    }
		
	
	
	/*==============================================================
	TestScript  	: verifyCreateTicketVMinTicketsPage
	Manual TestCase	: [QAT-239] Verify that when user clicks on Create Ticket in a VM and VM is in running state, user is able to create a ticket and is reflecting in Tickets Page 
	Description		: Verifying Created Ticket in VM is reflecting in Tickets Page
	Author 			: QAA03
	Creation Date 	: 12/14/2015
	Release Name    : Hague
	Pre-Requisites	:
	Revision History:
==============================================================*/
	@Test(priority=9)
	public void verifyCreateTicketVMinTicketsPage()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,EVDC_OverviewPF);
			PageFactory.initElements(driver, EVDC_VMPF);
				
			String sUserName=null,sPassword=null,sVMStatus=null,sVMCreateTicketID=null,sTicketID=null;
			int iRowNbr=0;
			boolean bTktIDStatus; 
		
		try {
			FrameworkUtil.sTestCaseName = "verifyCreateTicketVMinTicketsPage";
			FrameworkUtil.sManualTestCaseName="[QAT-239 ][QAT-239] Verify that when user clicks on Create Ticket in a VM and VM is in running state, user is able to create a ticket and is reflecting in Tickets Page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO1");
		    sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.PASSWORD");
		
		    sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.RUNNING.STATUS");
			
			
			//Login to Navigator with devco1 user
			LoginTestCase.nav_Login(sUserName, sPassword);
			EVDC_VM_AdvancedActions.navigateAndExpandVM(sVMStatus);
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			sVMCreateTicketID = EVDC_VM_TestCase.VMCreateTicket(iRowNbr);
			
			TicketTestCase.navigateToTicketPage();
			sTicketID = TicketTestCase.getTicketID(1);
			
			bTktIDStatus = sVMCreateTicketID.contentEquals(sTicketID);
			
			FrameworkUtil.updateCustomResultBasedOnStatus(bTktIDStatus, "Ticket created ID through VM and ID in Tickets Page");
			
			//Logout from Navigator
			LoginTestCase.nav_Logout();
	
		   } catch (Exception e) {
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyCreateTicketVMinTicketsPage", "warn", "catch block:" +e.getMessage());
		}
    }
	
	
	
	/*==============================================================
	TestScript 		: valVMStoppedEdtSuccess
	Manual TestCase	: Hague-QAT-266-WCP_3033_TC_VM edit update failed when VM is in stopped status
	Description		: Verify that user is able to edit a VM when VM is in stopped status.
	Author 			: Vivek Kumar
	Creation Date 	: 12/03/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=4)
	public void valVMStoppedEdtSuccess()
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		String sUserName,sPassword;
		String sVMStatus,sExpUserFeedBack,sActUserFeedback,sExpUserString,sVMName,sVMNameorStatus;
		int iRowNbr;
		try {
			FrameworkUtil.sTestCaseName = "EVDC-valVMStoppedEdtSuccess";
			FrameworkUtil.sManualTestCaseName="Hague-QAT-266-1.Edit VM Compute & Storage tab->Check Add Disk link functionality" + '\n' + "2. Edit VM Compute & Storage tab->Check Add Disk confirmation message";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
			//sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
			sExpUserString=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.ADDDISK");
			
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.KIRKJ.USERID");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.KIRKJ.PASSWORD");
			
			sVMNameorStatus="Stopped";
			
			LoginTestCase.nav_Login(sUserName, sPassword);
			
			//Navigating to EVDC-VM page
			//Clicking on EVDC Name and validating its landing page
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine(),EVDC_VMPF.getNav_AddVMLink());
			
			
			EVDC_VM_AdvancedActions.refreshAndExpandVM(sVMNameorStatus);
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			EVDC_VM_TestCase.stopRunningVM(iRowNbr);
			
			
			//Verifying and Clicking on Edit button
			EVDC_VM_TestCase.navVerifyClkEditBtn(iRowNbr);
			
			//navChkEnableGuestCustomization();
			
			//EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(iRowNbr);
			//navVerifyClkEditBtn(iRowNbr);
			
			
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditComputeStorage());
			//Thread.sleep(25000);
			WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_ComputeStorageAddDisk());
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_ComputeStorageAddDisk());
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMSaveBtn());
			if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_NewEVDCPopUpBody()))
			{
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_NewEVDCPopUpOKBtn());
			}
			else
			{
				WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_EditVMCommit());
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMCommit());
			}
			
			
			//Thread.sleep(60000);
			WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_RefreshPopUpMsg());
			WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_PlzWaitPopUpMsg());
			WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_RefreshPopUpMsg());
			EVDC_VM_TestCase.navClickErrBtn();
			sVMName=EVDC_VM_TestCase.navGetVMName(iRowNbr);
			//WebObjectUtil.waitForElementPresent(EVDC.);
			//WebObjectUtil.waitForElementNotPresent(EVDC.getNav_StartPopUpMsg());
			sActUserFeedback =EVDC_VMPF.getNav_UserfeedBack().getText();
			sExpUserFeedBack=sVMName + sExpUserString;
			//System.out.println(sActUserFeedback);
			if(sActUserFeedback.contains(sExpUserFeedBack))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message Verified "    , "pass",sExpUserFeedBack) ;
				LoggerUtil.log_type_info(" Message Verified  = " +sExpUserFeedBack );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message not Verified"   , "fail", "Expected :"+sExpUserFeedBack +", Actual :"+sActUserFeedback);
				LoggerUtil.log_type_error(" Message not Verified  =  " +sExpUserFeedBack );
			}
					
				
			//Logout
			LoginTestCase.nav_Logout();
					
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-Adding Disk" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
		
	}
	
	/*==============================================================
	TestScript  	: VerifyVMPortlet()
	Manual TestCase	: QAT-234-WCP_3407_TC_User can add VM to org with multiple VDCs		
	Description		: Verify the Load Balancer portlet display on EVDC over view page
	Author 			: Priyanka R
	Creation Date 	: 12/01/2015
	Release         : Hague
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=30)
	public void VerifyVMPortlet()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		
		PageFactory.initElements(driver, EVDC_OverviewPF);
		PageFactory.initElements(driver, EVDC_VMPF);
		PageFactory.initElements(driver, Home);
	
		
		try {
		String sUserName,sPassword,sVMName,sEVDCOrgName;

				
		FrameworkUtil.sTestCaseName = "Hague-VerifyVMPortlet";
		FrameworkUtil.sManualTestCaseName="QAT-234-WCP_3407_TC_User can add VM to org with multiple VDCs";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		
		sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLE.USERID");
		sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLE.PWD");
		
		
		//Login
		LoginTestCase.nav_Login(sUserName, sPassword);
		sVMName=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.ADDVM.NAME");
		WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
		WebObjectUtil.explicitWait(10);
		
		sEVDCOrgName=EVDC_VM_TestCase.navGetEVDCOrgName();
		
		//WebObjectUtil.clickElement(EVDC_VMPF.getNav_EVDCVMLink());
		
		sVMName=sVMName + "_"+FrameworkUtil.sTimeStamp;
		WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
		WebObjectUtil.explicitWait(10);
		
		WebObjectUtil.clickElement(EVDC_VMPF.getNav_AddVMLink());
					
		
		EVDC_VM_TestCase.navAddBlankVM(sVMName);
		
	    WebObjectUtil.explicitWait(5);		
		
		WebObjectUtil.clickAndVerifyElement(EVDC_VMPF.getNav_AddVMLink(), EVDC_VMPF.getNav_AddVMSelectVMType());
		EVDC_VM_TestCase.navAddVMFromTemplate(sVMName);
		
		} catch (Exception e) {
			LoggerUtil.log_type_error( "Issue With-VerifyTicketDetails()" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		
		}
		
	}
	
////////// __________________________ Completed hague test cases _____________________________ ///////////
//######################################################################################
//-------------------------------METHODS------------------------------------------------
//######################################################################################
		
		public static void EVDCLoginAndExpand(String sVMNameorStatus)
		{
			sLoginExpandVM = false ;
			
			if (!sLoginExpandVM){
				//sLoginExpandVM = EVDC_VM_AdvancedActions_EXTJS.navigateAndExpandVM("Stopped");
				sLoginExpandVM = EVDC_Overview_TestCase.navEVDCLogin();
				EVDC_VM_AdvancedActions.navigateAndExpandVM(sVMNameorStatus);	
				
			}
			else
			{
				EVDC_VM_AdvancedActions.refreshAndExpandVM(sVMNameorStatus);
			}
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Get VM and its State" , "VM Name and State ", "Done", EVDC_VM_AdvancedActions.sVMName + "//"+ EVDC_VM_AdvancedActions.sVMstatus);
		}
		
		
	
	public static boolean stopRunningVM(int iRowNum ){
		boolean bStatus = false;
		WebElement wStop;
		String sCurrentVMState;
		
		PageFactory.initElements(WebDriverUtil.getDriver(), EVDC_VMPF);
		
		if(!EVDC_VM_AdvancedActions.sVMstatus.contains("Stopped"))
		{
			//wStop=WebObjectUtil.GetWebElement("xpath", "//table["+ iRowNum+"]//a[text()='Stop']","Stop Button");
			// This object is updated on 10/14/2015 By QAA04
			wStop = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.STOP", "PARAMETER_ROWNUMBER", iRowNum+"");
			if(wStop != null)
			{
	
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button verified " , "pass","Stop button verified");
				LoggerUtil.log_type_info("Stop button verified" );
				//wStop.click();
				WebObjectUtil.clickElement(wStop);
				//WebObjectUtil.explicitWait(10);
				WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_StopPopUpMsg());
				bStatus = true;
				WebDriverUtil.refreshBrowser();
				//bStatus=WebTableUtil.verifyTextPresentOnRow(EVDC.getNav_VMWebTable(), EVDC_VM_AdvancedActions_EXTJS.iVisibleVMRowNum, "Stopped");
				EVDC_VM_AdvancedActions.expandVMbyRowNum(EVDC_VM_AdvancedActions.iVisibleVMRowNum);
				
			}
	
		}else{
			bStatus = true;
		}
		WebObjectUtil.explicitWait(10);
		
		/*int iCurrentRowNo = WebTableUtil.getRowByCellText(EVDC.getNav_VMWebTable(), EVDC_VM_AdvancedActions.sVMName, 0, 1);
		sCurrentVMState = WebTableUtil.getRowAsWebElement(EVDC.getNav_VMWebTable(), iCurrentRowNo).getText();*/
		//Commented the above two lines and added the below 3 lines as a part of EXTJS5 change - Vivek - 10082015
		CustomWebElementUtil.loadCustomElement(EVDC_VMPF.getNav_VMWebTableParent(), "table");
		int iCurrentRowNo=CustomWebElementUtil.getRowByCellText( EVDC_VM_AdvancedActions.sVMName, 1);
		sCurrentVMState=CustomWebElementUtil.getCellData(iCurrentRowNo, 5);
		
		if(!sCurrentVMState.contains("Stopped")){
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Stop VM " , "warn","VM did not STOP even after clicking on Stop button and row content is :" + sCurrentVMState);	
		}
	
			return bStatus;
		}
	
	/*==============================================================
	Method Name 	: navVerifyEditBtn
	Description		: This will verify Edit buttons
	Author 			: Vivek Kumar
	Creation Date 	: 02/17/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navVerifyEditBtn(int iRowNbr)
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		WebElement wEdit;
		try {
			//wEdit=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+ iRowNbr+"]/td/table/tbody/tr[2]//a[contains(text(),'Edit')]","Edit Button");
		
			wEdit = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.EDITVM", "PARAMETER_ROWNUMBER", iRowNbr+"");
			if(wEdit !=null)
			{
	
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button verified " , "pass","Edit button verified");
				LoggerUtil.log_type_info("Edit button verified" );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button not verified" , "fail", "Edit button ");
				LoggerUtil.log_type_error("Edit button not verified");
			}
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with- navVerifyEditBtn" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	/*==============================================================
	Method Name 	: navVerifyRefreshBtn
	Description		: This will verify Refresh buttons
	Author 			: Vivek Kumar
	Creation Date 	: 02/17/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navVerifyRefreshBtn(int iRowNbr)
	{
		
		//WebDriver driver = WebDriverUtil.getDriver();
		WebElement wRefresh;
		try {
			//wRefresh=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+ iRowNbr+"]/td/table/tbody//a[contains(text(),'Refresh')]","Refresh Button");
			//wRefresh=WebObjectUtil.GetWebElement("xpath", "//table["+ iRowNbr+"]//a[text()='Refresh Details']", "Refresh Button");
			// This object is updated on 10/14/2015 By QAA04
			wRefresh = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.REFRESH", "PARAMETER_ROWNUMBER", iRowNbr+"");
			if(wRefresh != null)
			{
	
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button verified " , "pass","Refresh button verified");
				LoggerUtil.log_type_info("Refresh button verified" );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button not verified" , "fail", "Refresh button ");
				LoggerUtil.log_type_error("Refresh button not verified");
			}
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with- navVerifyRefreshBtn" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	Method Name 	: navVerifyCreateTicketBtn
	Description		: This will verify Create Ticket buttons
	Author 			: Vivek Kumar
	Creation Date 	: 02/17/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navVerifyCreateTicketBtn(int iRowNbr)
	{
		
		//WebDriver driver = WebDriverUtil.getDriver();
		WebElement wCreateTicket;
		try {
			//wCreateTicket=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+ iRowNbr+"]/td/table/tbody/tr[2]//a[contains(text(),'Create a Ticket')]","CreateTicket Button");
			//wCreateTicket=WebObjectUtil.GetWebElement("xpath", "//table["+ iRowNbr+"]//a[text()='Create a Ticket']", "Create a Ticket");
			// This object is updated on 10/14/2015 By QAA04
			wCreateTicket = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.CREATETICKET.BUTTON", "PARAMETER_ROWNUMBER", iRowNbr+"");
			if(wCreateTicket != null)
			{
	
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button verified " , "pass","Create Ticket button verified");
				LoggerUtil.log_type_info("Create Ticket button verified" );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button not verified" , "fail", "Create Ticket button ");
				LoggerUtil.log_type_error("Create Ticket button not verified");
			}
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with- navVerifyCreateTicketBtn" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	Method Name 	: navVerifyStartBtn
	Description		: This will verify Start buttons
	Author 			: Vivek Kumar
	Creation Date 	: 02/17/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navVerifyStartBtn(int iRowNbr)
	{
		WebElement wStart;
		//WebDriver driver = WebDriverUtil.getDriver();
		try {
		//	wStart=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+ iRowNbr+"]/td/table/tbody/tr[2]//a[contains(text(),'Start')]","Start Button");
			//wStart=WebObjectUtil.GetWebElement("xpath", "//table["+ iRowNbr+"]//a[text()='Start']", "Start Button");
			// This object is updated on 10/14/2015 By QAA04
			wStart = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.START", "PARAMETER_ROWNUMBER", iRowNbr+"");
			if(wStart != null)
			{
	
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button verified " , "pass","Start button verified");
				LoggerUtil.log_type_info("Start button verified" );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button not verified" , "fail", "Start button ");
				LoggerUtil.log_type_error("Start button not verified");
			}
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with- navVerifyStartBtn" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	
	/*==============================================================
	Method Name 	: navVerifyStopBtn
	Description		: This will verify Stop buttons
	Author 			: Vivek Kumar
	Creation Date 	: 02/17/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navVerifyStopBtn(int iRowNbr)
	{
		
		//WebDriver driver = WebDriverUtil.getDriver();
		WebElement wStop;
		try {
			//wStop=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+ iRowNbr+"]/td/table/tbody/tr[2]//a[contains(text(),'Stop')]","Stop Button");
			//wStop=WebObjectUtil.GetWebElement("xpath", "//table["+iRowNbr+"]//a[text()='Stop']","Stop Button");
			// This object is updated on 10/14/2015 By QAA04
			wStop = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.STOP", "PARAMETER_ROWNUMBER", iRowNbr+"");
			if(wStop != null)
			{
	
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button verified " , "pass","Stop button verified");
				LoggerUtil.log_type_info("Stop button verified" );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button not verified" , "fail", "Stop button ");
				LoggerUtil.log_type_error("Stop button not verified");
			}
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with- navVerifyStopBtn" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	Method Name 	: navVerifyResetBtn
	Description		: This will verify reset buttons
	Author 			: Vivek Kumar
	Creation Date 	: 02/17/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navVerifyResetBtn(int iRowNbr)
	{
		
		//WebDriver driver = WebDriverUtil.getDriver();
		WebElement wReset;
		try {
		//	wReset=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+ iRowNbr+"]/td/table/tbody/tr[2]//a[contains(text(),'Reset')]","Reset Button");
			//wReset=WebObjectUtil.GetWebElement("xpath", "//table["+ iRowNbr+"]//a[text()='Reset']","Reset Button");
			// This object is updated on 10/14/2015 By QAA04
			wReset = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.RESET", "PARAMETER_ROWNUMBER", iRowNbr+"");
			if(wReset != null)
			{

				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button verified " , "pass","Reset button verified");
				LoggerUtil.log_type_info("Reset button verified" );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button not verified" , "fail", "Reset button ");
				LoggerUtil.log_type_error("Reset button not verified");
			}
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with- navVerifyResetBtn" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	
	/*==============================================================
	Method Name 	: navVerifySuspendBtn
	Description		: This will verify reset buttons
	Author 			: Vivek Kumar
	Creation Date 	: 02/17/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navVerifySuspendBtn(int iRowNbr)
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		WebElement wSuspend;
		try {
			//wSuspend=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+ iRowNbr+"]/td/table/tbody/tr[2]//a[contains(text(),'Suspend')]","Suspend Button");
			//String sSuspend=WebObjectUtil.getLocatorValueFromProperty("EVDC.VM.VMTABLE.SUSPEND.BUTTON", "PARAMETER_ROWNUMBER", iRowNbr+"");
			//wSuspend=WebObjectUtil.GetWebElement("xpath", sSuspend,"Suspend Button");
			// This object is updated on 10/14/2015 By QAA04
			wSuspend = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.SUSPEND.BUTTON", "PARAMETER_ROWNUMBER", iRowNbr+"");
			
			if(wSuspend != null)
			{

				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button verified " , "pass","Suspend button verified");
				LoggerUtil.log_type_info("Suspend button verified" );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button not verified" , "fail", "Suspend button ");
				LoggerUtil.log_type_error("Suspend button not verified");
			}
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with- navVerifySuspendBtn" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	Method Name 	: navVerifyNetworkDetails
	Description		: This will verify Network Details
	Author 			: Vivek Kumar
	Creation Date 	: 02/17/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navVerifyNetworkDetails(int iRowNbr)
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		WebElement wNetworkDetail;
		try {
			//wNetworkDetail=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+ iRowNbr +"]/td/table/tbody/tr[2]//a[contains(text(),'Network Details')]/img","Network Detail Button");
			//String sNetworkDetails=WebObjectUtil.getLocatorValueFromProperty("EVDC.VM.VMTABLE.NETWORKDETAILS.EXPANDER", "PARAMETER_ROWNUMBER", iRowNbr+"");
		//	wNetworkDetail=WebObjectUtil.GetWebElement("xpath", sNetworkDetails,"Delete Button");
			// This object is updated on 10/14/2015 By QAA04
			wNetworkDetail = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.NETWORKDETAILS.EXPANDER", "PARAMETER_ROWNUMBER", iRowNbr+"");
			if(wNetworkDetail != null)
			{
				//wNetworkDetail.click();
				WebObjectUtil.clickElement(wNetworkDetail);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button verified " , "pass","Network Details button verified");
				LoggerUtil.log_type_info("Network Detail button verified and clicked " );
				WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_NetworkNICIDTab());
				WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_NetworkNICIPTab());
				WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_NetworkStatusTab());
				WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_NetworkPrimaryTab());
				WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_NetworkMACAddressTab());
				WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_NetworkTab());
							
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button verified" , "fail", "Network details not Verified");
				LoggerUtil.log_type_error("Network details not Verified"); 
			}
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with- navVerifyNetworkDetails" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	Method Name 	: navVerifyStorageDetails
	Description		: This will verify Storage Details
	Author 			: Vivek Kumar
	Creation Date 	: 02/18/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navVerifyStorageDetails(int iRowNbr)
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		WebElement wStorageDetail;
		try {
			//wStorageDetail=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+iRowNbr+"]/td/table/tbody/tr[2]//a[contains(text(),'Storage Details')]/img","Storage Details");
			//String sStorageDetailExpander=WebObjectUtil.getLocatorValueFromProperty("EVDC.VM.VMTABLE.STORAGEDETAILS.EXPANDER", "PARAMETER_ROWNUMBER", iRowNbr+"");
			//wStorageDetail=WebObjectUtil.GetWebElement("xpath", sStorageDetailExpander,"Storage Details");
			// This object is updated on 10/14/2015 By QAA04
			wStorageDetail = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.STORAGEDETAILS.EXPANDER", "PARAMETER_ROWNUMBER", iRowNbr+"");
			
			if(wStorageDetail != null)
			{
				//wStorageDetail.click();
				WebObjectUtil.clickElement(wStorageDetail);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button verified " , "pass","Storage Details button verified");
				LoggerUtil.log_type_info("Storage Detail button verified and clicked " );
				WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_StorageDiskName());
				WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_StorageName());
				WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_StorageSCSI());
							
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button verified" , "fail", "Storage details not Verified");
				LoggerUtil.log_type_error("Storage details not Verified"); 
			}
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with- navVerifyStorageDetails" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");

		}
	}

	/*==============================================================
	Method Name 	: navVerifyClkStartBtn
	Description		: This will verify  and click Start buttons
	Author 			: Vivek Kumar
	Creation Date 	: 02/18/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static boolean navVerifyClkStartBtn(int iRowNbr)
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		WebElement wStart;
		boolean bflag=false;
		String sActStartMsg=null, sExpStartMsg;
		sExpStartMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.START.MESSAGE");
		try {
			//wStart=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+ iRowNbr+"]/td/table/tbody/tr[2]//a[contains(text(),'Start')]","Start Button");
			//wStart=WebObjectUtil.GetWebElement("xpath", "//table["+ iRowNbr+"]//a[text()='Start']", "Start Button");
			// This object is updated on 10/14/2015 By QAA04
			wStart = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.START", "PARAMETER_ROWNUMBER", iRowNbr+"");
			
			if(wStart != null)
			{

				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button verified " , "pass","Start button verified");
				LoggerUtil.log_type_info("Stop button verified" );
				//wStop.click();
				WebObjectUtil.clickElement(wStart);
				
				//Thread.sleep(1000);
				WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_StartPopUpMsg());
				WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_StartPopUpMsg());
				/*//sActStartMsg=EVDC.getNav_StartPopUpMsg().getText();
				//System.out.println(" Actual Messgae = " +sActResetMsg);
				navEVDCValExpectedActualMsg(sExpStartMsg,sActStartMsg);
				*/
				bflag=true;
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button not verified" , "fail", "Start button ");
				LoggerUtil.log_type_error("Start button not verified");
			}
			
			
			//##########################################################################
			
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with- navVerifyClkStartBtn" );

			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
			LoggerUtil.log_type_error(e.getMessage());
			
		}
		//###############################
		
		WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_StartPopUpMsg());
		
		String sExpectedStartMsg,sVMName,sExpectedMessage,sActualMessage;
		sVMName=navGetVMName(iRowNbr);
		sExpectedStartMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.START.USERMSG");
		sExpectedMessage=sVMName + " " + sExpectedStartMsg;
		//System.out.println(sExpectedMessage);
		//Getting text from appliaction
		sActualMessage=EVDC_VMPF.getNav_UserfeedBack().getText();
		//System.out.println(sActualMessage);
		bflag = navEVDCValExpectedActualMsg(sExpectedMessage,sActualMessage);
		WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_UserfeedBackImage());
		
/*		WebDriverUtil.refreshBrowser();
		bflag = WebTableUtil.verifyTextPresentOnRow(EVDC.getNav_VMWebTable(), EVDC_VM_AdvancedActions_EXTJS.iVisibleVMRowNum, "Running");
		*/
		return bflag;
	}
	
	/*==============================================================
	Method Name 	: navGetVMName
	Description		: This will fetch the VM name
	Author 			: Vivek Kumar
	Creation Date 	: 02/19/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static String navGetVMName(int iRowNbr)
	{
		String sVMName = null;

		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		WebElement wb, wVMName;
		try {
			//wVMName=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+ iRowNbr +"]//td[2]/div/div","VM Name");
			//wVMName=WebObjectUtil.GetWebElement("xpath", "//table["+ iRowNbr +"]//td[@data-columnid='table_col_vm_name']/div/div","VM Name");
			// This object is updated on 10/14/2015 By QAA04
			wVMName = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.VMNAME", "PARAMETER_ROWNUMBER", iRowNbr+"");
			if(wVMName != null)
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VM Name field virified" , "pass","");
				LoggerUtil.log_type_info("VM Name field virified" );
				//wVMName=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+ iRowNbr +"]//td[2]/div/div");
				sVMName=wVMName.getText();
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VM Name field not verified" , "fail", "");
				LoggerUtil.log_type_error("VM Name field not virified"); 
			}
			
			
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with- navGetVMName" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		return sVMName;
	}
	
	/*==============================================================
	Method Name 	: navEVDCValExpectedActualMsg
	Description		: This will compare Expected and actual message and print the result
	Author 			: Vivek Kumar
	Creation Date 	: 03/19/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static boolean navEVDCValExpectedActualMsg(String sExpectedMsg,String sActualMsg)
	{
		boolean flag=false;
		try {
			if(WebObjectUtil.compareString(sExpectedMsg, sActualMsg, true))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message Verified "    , "pass",sActualMsg) ;
				LoggerUtil.log_type_info(" Message Verified  = " +sExpectedMsg );
				flag=true;
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message not Verified"   , "fail", "Expected :"+sExpectedMsg +", Actual :"+sActualMsg);
				LoggerUtil.log_type_error(" Message not Verified  =  " +sExpectedMsg );
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		return flag;
	}

	/*==============================================================
	Method Name 	: navVerifyClkResetBtn
	Description		: This will verify and click reset buttons
	Author 			: Vivek Kumar
	Creation Date 	: 02/18/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navVerifyClkResetBtn(int iRowNbr)
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_VMPF);
		String sActResetMsg = null, sExpResetMsg;
		WebElement wReset;
		sExpResetMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.RESET.MESSGAE");
		
		
		try {
			//wReset=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+ iRowNbr+"]/td/table/tbody/tr[2]//a[contains(text(),'Reset')]","Reset Button");
			//wReset=WebObjectUtil.GetWebElement("xpath", "//table["+ iRowNbr+"]//a[text()='Reset']","Reset Button");
			// This object is updated on 10/14/2015 By QAA04
			wReset = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.RESET", "PARAMETER_ROWNUMBER", iRowNbr+"");
			if(wReset != null)
			{

				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button verified " , "pass","Reset button verified");
				LoggerUtil.log_type_info("Reset button verified" );
				//wReset.click();
				WebObjectUtil.clickElement(wReset);
				
				WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_PlzWaitPopUpMsg());
				WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_ResetPopUpMsg());
				//navEVDCValExpectedActualMsg(sExpResetMsg,sActResetMsg);
				
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button not verified" , "fail", "Reset button ");
				LoggerUtil.log_type_error("Reset button not verified");
			}
			
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button not verified " , "fail", "navVerifyClkResetBtn");
			LoggerUtil.log_type_error("issue with- navVerifyClkResetBtn" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
	}
	
	/*==============================================================
	Method Name 	: navVerifyClkSuspendBtn
	Description		: This will verify and click reset and Verify popup message buttons
	Author 			: Vivek Kumar
	Creation Date 	: 02/17/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navVerifyClkSuspendBtn(int iRowNbr)
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		WebElement wSuspend;
		String sActSuspendtMsg,sExpSuspendMsg,sSuspendErrMsg;
		sExpSuspendMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.SUSPEND.MESSAGE");
		sSuspendErrMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.SUSPEND.ERRMSG");
		try {
			//wSuspend=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+ iRowNbr+"]/td/table/tbody/tr[2]//a[contains(text(),'Suspend')]","Suspend Button");
			//String sSuspend=WebObjectUtil.getLocatorValueFromProperty("EVDC.VM.VMTABLE.SUSPEND.BUTTON", "PARAMETER_ROWNUMBER", iRowNbr+"");
			//wSuspend=WebObjectUtil.GetWebElement("xpath", sSuspend,"Suspend Button");
			// This object is updated on 10/14/2015 By QAA04
			wSuspend = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.SUSPEND.BUTTON", "PARAMETER_ROWNUMBER", iRowNbr+"");
			if(wSuspend != null)
			{

				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button verified " , "pass","Suspend button verified");
				LoggerUtil.log_type_info("Suspend button verified" );
				//wSuspend.click();
				WebObjectUtil.clickElement(wSuspend);
				WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_SuspendPopUpMsg());
				WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_SuspendPopUpMsg());
				//###############################################
				while(EVDC_VMPF.getNav_UserfeedBack().getText().contains(sSuspendErrMsg))
				{
					System.out.println(EVDC_VMPF.getNav_UserfeedBack().getText());
					LoggerUtil.log_type_warn(EVDC_VMPF.getNav_UserfeedBack().getText());
					Thread.sleep(10000);
					//wSuspend.click();
					WebObjectUtil.clickElement(wSuspend);
				}
				
				
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button not verified" , "fail", "Suspend button ");
				LoggerUtil.log_type_error("Suspend button not verified");
			}
			WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_SuspendPopUpMsg());
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Message not verified" , "fail", "navVerifyClkSuspendBtn");
			LoggerUtil.log_type_error("issue with- navVerifyClkSuspendBtn" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	

	/*==============================================================
	Method Name 	: navVerifyClkRefreshBtn
	Description		: This will click and Verify Refresh Messgae
	Author 			: Vivek Kumar
	Creation Date 	: 02/19/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navVerifyClkRefreshBtn(int iRowNbr)
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		String sActStartMsg, sExpStartMsg,sRefreshErrMsg;
		WebElement wRefresh;
		WebElement wStop;
		sExpStartMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.REFRESH.MESSAGE");
		sRefreshErrMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.REFRESH.ERRMSG");
		try {
			//wRefresh=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+ iRowNbr+"]/td/table/tbody//a[contains(text(),'Refresh')]","Refresh Button");
			//wRefresh=WebObjectUtil.GetWebElement("xpath", "//table["+ iRowNbr+"]//a[text()='Refresh Details']", "Refresh Button");
			// This object is updated on 10/14/2015 By QAA04
			wRefresh = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.REFRESH", "PARAMETER_ROWNUMBER", iRowNbr+"");
			if(wRefresh != null)
			{

				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button verified " , "pass","Refresh button verified");
				LoggerUtil.log_type_info("Refresh button verified" );
				//wRefresh.click();
				WebObjectUtil.clickElement(wRefresh);
				
				
		
				while(EVDC_VMPF.getNav_UserfeedBack().getText().contains(sRefreshErrMsg))
				{
					//System.out.println(EVDC.getNav_UserfeedBack().getText());
					LoggerUtil.log_type_warn(EVDC_VMPF.getNav_UserfeedBack().getText());
					//wStop=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+ iRowNbr+"]/td/table/tbody/tr[2]//a[contains(text(),'Stop')]","Stop Button");
					//wStop=WebObjectUtil.GetWebElement("xpath", "//table["+ iRowNbr+"]//a[text()='Stop']", "Stop Button");
					// This object is updated on 10/14/2015 By QAA04
					wStop = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.STOP", "PARAMETER_ROWNUMBER", iRowNbr+"");
					//wStop.click();
					WebObjectUtil.clickElement(wStop);
					//WebObjectUtil.waitForElementPresent(EVDC.getNav_RefreshPopUpMsg());
					WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_RefreshPopUpMsg());
				}
							
				
				WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_RefreshPopUpMsg());
				
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Refresh button/message not verified" , "fail", "navVerifyClkRefreshBtn ");
				LoggerUtil.log_type_error("Refresh button not verified");
			}
			
			WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_PlzWaitPopUpMsg());
			WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_RefreshPopUpMsg());
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Refresh popup is not displaying" , "fail", "");
			LoggerUtil.log_type_error("issue with- navVerifyClkRefreshBtn" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	public static boolean startStoppedVM(int iRowNum ){
		boolean bStatus = false;
		WebElement wStart;
		String sCurrentVMState;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		if(!EVDC_VM_AdvancedActions.sVMstatus.contains("Running"))
		{
			//wStart=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+ iRowNum+"]/td/table/tbody/tr[2]//a[contains(text(),'Start')]","Start Button");
			//String sStart = WebObjectUtil.getLocatorValueFromProperty("EVDC.VM.VMTABLE.START.BUTTON", "PARAMETER_ROWNUMBER", iRowNum+"");
			//wStart=WebObjectUtil.GetWebElement("xpath", sStart,"Stop Button");
			// This object is updated on 10/14/2015 By QAA04
			// This object is updated on 10/14/2015 By QAA04
			// This object is updated on 10/14/2015 By QAA04
			wStart = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.START.BUTTON", "PARAMETER_ROWNUMBER", iRowNum+"");
			if(wStart != null)
			{

				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button verified " , "pass","Start button verified");
				LoggerUtil.log_type_info("Stop button verified" );
				//wStop.click();
				WebObjectUtil.clickElement(wStart);
				//WebObjectUtil.explicitWait(10);
				WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_StartPopUpMsg());
				
				bStatus = true;
				WebDriverUtil.refreshBrowser();
				//bStatus=WebTableUtil.verifyTextPresentOnRow(EVDC.getNav_VMWebTable(), EVDC_VM_AdvancedActions_EXTJS.iVisibleVMRowNum, "Stopped");
				EVDC_VM_AdvancedActions.expandVMbyRowNum(EVDC_VM_AdvancedActions.iVisibleVMRowNum);
			}
	/*		if ( navVerifyClkStartBtn(iRowNum)){
			//Clicking Refresh Button and verifying message
			//navVerifyClkRefreshBtn(iRowNbr);
			//WebDriverUtil.refreshBrowser();
			EVDC_VM_AdvancedActions_EXTJS.expandVMbyRowNum(EVDC_VM_AdvancedActions_EXTJS.iVisibleVMRowNum);
			bStatus = true;
		}*/
			else{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "startStoppedVM" , "startStoppedVM" , "warn", "Issue with Starting VM");
			}
		}
		/*int iCurrentRowNo = WebTableUtil.getRowByCellText(EVDC.getNav_VMWebTable(), EVDC_VM_AdvancedActions.sVMName, 1, 1);
		sCurrentVMState = WebTableUtil.getRowAsWebElement(EVDC.getNav_VMWebTable(), iCurrentRowNo).getText();*/
		//Commented the above two lines and added the below 3 lines as a part of EXTJS5 change - Vivek - 10082015
		CustomWebElementUtil.loadCustomElement(EVDC_VMPF.getNav_VMWebTableParent(), "table");
		int iCurrentRowNo=CustomWebElementUtil.getRowByCellText( EVDC_VM_AdvancedActions.sVMName, 1);
		sCurrentVMState=CustomWebElementUtil.getCellData(iCurrentRowNo, 5);
		
		//sCurrentVMState = WebTableUtil.getRowAsWebElement(EVDC.getNav_VMWebTable(), EVDC_VM_AdvancedActions_EXTJS.iVisibleVMRowNum).getText();
		//String sCurrentVMState = WebTableUtil.getCellData(EVDC.getNav_VMWebTable(), iRowNum, 5);
		if(!sCurrentVMState.contains("Running")){
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Start VM " , "warn","VM did not START even after clicking on Start button and row content is :" + sCurrentVMState);	
		}

		
	return bStatus;
	}
	
	/*==============================================================
	Method Name 	: navValConsole
	Description		: This will click and Verify console window
	Author 			: Vivek Kumar
	Creation Date 	: 02/19/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navValConsole(int iRowNbr) throws InterruptedException
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		WebElement wb ;
		Thread.sleep(5000);
		try {
		//	wb = WebObjectUtil.GetWebElement("xpath", "//tr[" + iRowNbr + "]//div/a/img[@alt='vm console']","Console Image");
			//wb = WebObjectUtil.GetWebElement("xpath", "//tr[" + iRowNbr + "]//tr[2]//div//img[@alt='vm console']","Console Image");

			//String sConsole= WebObjectUtil.getLocatorValueFromProperty("EVDC.VM.VMTABLE.CONSOLE.IMAGE", "PARAMETER_ROWNUMBER", iRowNbr+"");
			// This object is updated on 10/14/2015 By QAA04
			wb=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.CONSOLE.IMAGE", "PARAMETER_ROWNUMBER", iRowNbr+"");
			//wb=WebObjectUtil.GetWebElement("xpath", sConsole,"Console Image");
			
			if(wb != null)
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VM Console Icon" , "pass","");
				LoggerUtil.log_type_info("VM console icon verified" );
				//wb.click();
				WebObjectUtil.clickElement(wb);
				Thread.sleep(10000);
				WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_ConsoleClose());
				//Verifying Console Window
				if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_ConsoleWindow()))
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VM Console Window" , "pass","");
					LoggerUtil.log_type_info("VM console window verified" );
					/*//Closing Console window
					WebObjectUtil.clickElement(EVDC.getNav_ConsoleClose());*/
				}
				else
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VM Console window" , "fail", "");
					LoggerUtil.log_type_error("VM console Window verified"); 
				}
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VM Console icon" , "fail", "");
				LoggerUtil.log_type_error("VM console icon verified"); 
			}
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with- navValConsole" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
	}
	

	/*==============================================================
	Method Name 	: navVerifyClkEditBtn
	Description		: This will verify Edit buttons
	Author 			: Vivek Kumar
	Creation Date 	: 02/17/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navVerifyClkEditBtn(int iRowNbr)
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		WebElement wEdit;
		try {
			//wEdit=WebObjectUtil.GetWebElement("xpath", "//table["+iRowNbr+"]//a[text()='Edit VM']","Edit Button");
			
			wEdit = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.EDITVM", "PARAMETER_ROWNUMBER", iRowNbr+"");
			if(wEdit != null)
			{

				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button verified " , "pass","Edit button verified");
				LoggerUtil.log_type_info("Edit button verified" );
				//wEdit.click();
				WebObjectUtil.clickElement(wEdit);
				if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_EditGeneralTab()))
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Edit window verified " , "pass","");
					LoggerUtil.log_type_info("Edit Window verified" );
				}
				else
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button Window not verified" , "fail", "");
					LoggerUtil.log_type_error("Edit window not verified");
				}
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button not verified" , "fail", "Edit button ");
				LoggerUtil.log_type_error("Edit button not verified");
			}
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with- navVerifyClkEditBtn" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	/*==============================================================
	Method Name 	: navChkEnableGuestCustomization
	Description		: This check whether "EnableGuestCustomization" is enabled or not, if yes, then uncheck the checkbox
	Author 			: Vivek Kumar
	Creation Date 	: 05/25/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navChkEnableGuestCustomization()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		try {
			//clicking on Guest Customization tab
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGuestOSCust());
			
			
			WebObjectUtil.deSelectCheckBox(EVDC_VMPF.getNav_GustCustomizationChkBox());
			
			//Clicking on Save Button
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMSaveBtn());
			//Click on Commit
			if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_NewEVDCPopUpBody()))
			{
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_NewEVDCPopUpOKBtn());
			}
			else
			{
				WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_EditVMCommit());
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMCommit());
			}
			
			//Thread.Sleep(60000);
			WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_RefreshPopUpMsg());
			navClickErrBtn();
			WebDriverUtil.refreshBrowser();
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}

	/*==============================================================
	Method Name 	: navClickErrBtn
	Description		: This will click ok for pop up error msg
	Author 			: Vivek Kumar
	Creation Date 	: 03/05/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static  boolean navClickErrBtn() 
	{ 
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		boolean flag=false;
		try {
			
		
			if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_GuestOSChangeSIDErrMsg()))
			{
				
				//WebObjectUtil.waitForElementPresent(EVDC.getNav_GuestOSErrorMsgOKBtn());
				//Clicking on OK Btn
				String sErrorText=EVDC_VMPF.getNav_GuestOSChangeSIDErrMsg().getText();
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_GuestOSErrorMsgOKBtn());
				
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Error popup", "fail", sErrorText);
				//WebObjectUtil.waitForElementNotPresent(EVDC.getNav_GuestOSChangeSIDErrMsg());
				flag=true;
			}
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with- navClickErrBtn" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		return flag;
	}
	
	/*==============================================================
	Method Name 	: navComputeStorageDeleteDiskIconAppears 
	Description		: This will verify Icon for newly add or delete DIsk
	Author 			: Vivek Kumar
	Creation Date 	: 02/24/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public  void  navComputeStorageAddDeleteDiskIconAppears(int iRowNbr) throws InterruptedException
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		int iRows;
		WebElement wb;
		WebElement wDelete,wUndoDelete;
		
		try {
			
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditComputeStorage());
			Thread.sleep(2000);
			//Clicking on Add button
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_ComputeStorageAddDisk());
			//Getting the current Row Count
			iRows=navEditComputeStorageDiskTable();
			//System.out.println(iRows);
			//wb=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+iRows+"]/td[5]/div/a[contains(text(),'Undo Add')]/../../../../tr["+iRows+"]//img","Add Link");
			//String sUndoAddImage= WebObjectUtil.getLocatorValueFromProperty("EVDC.VM.VMTABLE.COMPUTESTORAGETABLE.UNDOADD.IMAGE", "PARAMETER_ROWNUMBER", iRows+"");
			//wb=WebObjectUtil.GetWebElement("xpath", sUndoAddImage,"Undo Add Image");
			// This object is updated on 10/14/2015 By QAA04
			wb = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.COMPUTESTORAGETABLE.UNDOADD.IMAGE", "PARAMETER_ROWNUMBER", iRows+"");
			
			if(wb != null)
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verifying ! image for Add Disk" , "pass","Image Verified");
				LoggerUtil.log_type_info("! image verified-  Add Disk" );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verifying ! image for Add Disk" , "fail", "Image not verified");
				LoggerUtil.log_type_error("! image not verified- Add Disk"); 
			}
			//Saving and commiting 
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMSaveBtn());
			if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_NewEVDCPopUpBody()))
			{
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_NewEVDCPopUpOKBtn());
			}
			else
			{
				WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_EditVMCommit());
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMCommit());
			}
		
			WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_RefreshPopUpMsg());
			WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_PlzWaitPopUpMsg());
			WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_RefreshPopUpMsg());
			//Thread.sleep(20000);
			navClickErrBtn();
			
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditComputeStorage());
			Thread.sleep(2000);
			//getting the current row count after adding Disk
			
			int iRowsafterAdd=navEditComputeStorageDiskTable();
			//Clicking on Delete link and verifying ! ICON
			if(iRows==iRowsafterAdd)
			{
			//	wDelete=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+iRows+"]/td[5]/div/a[contains(text(),'Delete')]","Delete Link");

				//String sDelete= WebObjectUtil.getLocatorValueFromProperty("EVDC.VM.VMTABLE.COMPUTESTORAGETABLE.DELETE.LINK", "PARAMETER_ROWNUMBER", iRows+"");
				//wDelete=WebObjectUtil.GetWebElement("xpath", sDelete,"Delete Button");
				// This object is updated on 10/14/2015 By QAA04
				wDelete = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.COMPUTESTORAGETABLE.DELETE.LINK", "PARAMETER_ROWNUMBER", iRows+"");
				//wDelete.click();
				WebObjectUtil.clickElement(wDelete);
				//wUndoDelete=WebObjectUtil.GetWebElement("xpath","//table/tbody/tr["+iRows+"]/td[5]/div/a[contains(text(),'Undo Delete')]/../../../../tr["+iRows+"]//img","Undo Delete Link");

				//String sUndoDelete= WebObjectUtil.getLocatorValueFromProperty("EVDC.VM.VMTABLE.COMPUTESTORAGETABLE.UNDODELETE.IMAGE", "PARAMETER_ROWNUMBER", iRows+"");
				///wUndoDelete=WebObjectUtil.GetWebElement("xpath", sUndoDelete,"Undo Delete Image");
				// This object is updated on 10/14/2015 By QAA04
				wUndoDelete = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.COMPUTESTORAGETABLE.UNDODELETE.IMAGE", "PARAMETER_ROWNUMBER", iRows+"");
				if(wUndoDelete != null)
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verifying ! image for Delete Disk" , "pass","Image Verified");
					LoggerUtil.log_type_info("! image verified- Delete Disk" );
				}
				else
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verifying ! image for Delete Disk" , "fail", "Image not verified");
					LoggerUtil.log_type_error("! image not verified- Delete Disk"); 
				}
				//Saving and commiting 
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMSaveBtn());
				if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_NewEVDCPopUpBody()))
				{
					WebObjectUtil.clickElement(EVDC_VMPF.getNav_NewEVDCPopUpOKBtn());
				}
				else
				{
					WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_EditVMCommit());
					WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMCommit());
				}
				//Thread.sleep(60000);
				
				WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_RefreshPopUpMsg());
				WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_RefreshPopUpMsg());
				navClickErrBtn();
				//WebObjectUtil.clickElement(EVDC.getNav_EditGeneralCloseBtn());
			}
			else
			{
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralCloseBtn());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Add Disk in Compute Storage", "fail", "Disk not added");
			}
		
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with- navComputeStorageAddDeleteDiskIconAppears" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	Method Name 	: navEditComputeStorageDiskTable
	Description		: This will return total rows 
	Author 			: Vivek Kumar
	Creation Date 	: 02/24/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static int navEditComputeStorageDiskTable()
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		int iRows = 0;
		try {
		
			//iRows=driver.findElements(By.xpath("//*[@id='editDisksPanel-body']/div/table/tbody/tr")).size();
			//iRows=driver.findElements(By.xpath("//div[@id='editDisksPanel-body']//table")).size();
			/*WebElement wComputeTable=WebObjectUtil.GetWebElement("xpath", "//div[@id='editDisksPanel-body']//table", "Compute Storage Table");
			iRows=WebTableUtil.getRowCount(wComputeTable);*/
			
			CustomWebElementUtil.loadCustomElement(EVDC_VMPF.getNav_VMComputeStorageWebTableParent(), "table");
			iRows=CustomWebElementUtil.iRowCount;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		return iRows;
	}
	
	

	/*==============================================================
	Method Name 	: navComputeStorageAddUndoDeleteDiskIconAppears 
	Description		: This will verify Add and Undo Delete Msg
	Author 			: Vivek Kumar
	Creation Date 	: 02/25/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void  navComputeStorageAddUndoDeleteDiskMsg(int iRowNbr) throws InterruptedException
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		int iRows;
		String sExpUserString;
		WebElement wDelete,wUndoAdd,wUndoDelete;
		sExpUserString=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.ADDDISK");
		//iRows=navEditComputeStorageDiskTable();
		
		try {
			
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditComputeStorage());
			//Thread.sleep(10000);
			//Getting the row count
			iRows=navEditComputeStorageDiskTable();
			if(iRows==0)
			{
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_ComputeStorageAddDisk());
				//Saving and commiting 
				//Thread.sleep(10000);
				//WebObjectUtil.waitForElementPresent(EVDC.getNav_EditVMSaveBtn());
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMSaveBtn());
				//WebObjectUtil.waitForElementPresent(EVDC.getNav_EditVMCommit());
				if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_NewEVDCPopUpBody()))
				{
					WebObjectUtil.clickElement(EVDC_VMPF.getNav_NewEVDCPopUpOKBtn());
				}
				else
				{
					WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMCommit());
				}
		
				WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_RefreshPopUpMsg());
				WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_PlzWaitPopUpMsg());
				WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_RefreshPopUpMsg());
				//Thread.sleep(60000);
				
				
				if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_EVDCcommonPopUp()))
				{
					String sErrTxt=EVDC_VMPF.getNav_EVDCcommonPopUp().getText();
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Popup Error message" , "fail",sErrTxt);
					LoggerUtil.log_type_error("Error message -" + sErrTxt);
					
					WebObjectUtil.clickElement(EVDC_VMPF.getNav_GuestOSErrorMsgOKBtn());
				}
				
				//Verifying and Clicking on Edit button
				navVerifyClkEditBtn(iRowNbr);
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditComputeStorage());
			}
			
			
		
			
			//Clicking on Add button
				
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_ComputeStorageAddDisk());
			//Getting the current Row Count
			iRows=navEditComputeStorageDiskTable();
			//System.out.println(iRows);
			
		//	wUndoAdd=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+iRows+"]/td[5]/div/a[contains(text(),'Undo Add')]/../../../../tr["+iRows+"]//img","Undo Delete Link");
			//String sUndoAdd= WebObjectUtil.getLocatorValueFromProperty("EVDC.VM.VMTABLE.COMPUTESTORAGETABLE.UNDOADD.IMAGE", "PARAMETER_ROWNUMBER", iRows+"");
			//wUndoAdd=WebObjectUtil.GetWebElement("xpath", sUndoAdd,"Undo Add Link");
			// This object is updated on 10/14/2015 By QAA04
			wUndoAdd = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.COMPUTESTORAGETABLE.UNDOADD.IMAGE", "PARAMETER_ROWNUMBER", iRows+"");
			if(wUndoAdd != null)
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verifying ! image for Add Disk" , "pass","Image Verified");
				LoggerUtil.log_type_info("! image verified-  Add Disk" );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verifying ! image for Add Disk" , "fail", "Image not verified");
				LoggerUtil.log_type_error("! image not verified- Add Disk"); 
			}
			//Saving and commiting 
			navSaveNCommit(iRowNbr,sExpUserString);
			
			/*if(WebObjectUtil.isElementPresent(EVDC.getNav_ComputeStorageErrMsg()))
			{
				String sErrTxt=EVDC.getNav_ComputeStorageErrMsg().getText();
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Popup Error message" , "fail",sErrTxt);
				LoggerUtil.log_type_error("Error message -" + sErrTxt);
				
				WebObjectUtil.clickElement(EVDC.getNav_GuestOSErrorMsgOKBtn());
			}*/
			
			
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditComputeStorage());
			//Thread.sleep(10000);
			//Clicking on Delete link and verifying ! ICON
			
			//wDelete=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+iRows+"]/td[5]/div/a[contains(text(),'Delete')]","Delete Link");
			//wDelete=WebObjectUtil.GetWebElement("xpath", "//table["+iRows+"]/tbody/tr[1]/td[5]/div/a[contains(text(),'Delete')]","Delete Link");
			// This object is updated on 10/14/2015 By QAA04
			wDelete = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.COMPUTESTORAGETABLE.DELETE.LINK", "PARAMETER_ROWNUMBER", iRows+"");
			//wDelete.click();
			WebObjectUtil.clickElement(wDelete);
			//Saving and going Back
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMSaveBtn());
			//WebObjectUtil.waitForElementPresent(EVDC.getNav_EditVMGoBack());
			//Thread.sleep(3000);
			if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_NewEVDCPopUpBody()))
			{
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_NewEVDCPopUpCancelBtn());
			}
			else
			{
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMGoBack());
			}
			
			
			//wUndoDelete=WebObjectUtil.GetWebElement("xpath", "//table["+iRows+"]/tbody/tr[1]/td[5]/div/a[contains(text(),'Undo Delete')]","Undo Delete Link");
			// This object is updated on 10/14/2015 By QAA04
			wUndoDelete = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.COMPUTESTORAGETABLE.UNDODELETE.IMAGE", "PARAMETER_ROWNUMBER", iRows+"");
			if(wUndoDelete != null)
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Undo delete - verified" , "pass","");
				LoggerUtil.log_type_info(" Undo delete - verified" );
				//Clicking on Undo Link
				//wUndoDelete.click();
				WebObjectUtil.clickElement(wUndoDelete);
				//Saving and commiting 
				navSaveNCommit(iRowNbr,sExpUserString);
				
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Undo delete - not verified" , "fail", "");
				LoggerUtil.log_type_error(" Undo delete - not verified"); 
			}
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with- navComputeStorageAddUndoDeleteDiskMsg" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}	
	

	/*==============================================================
	Method Name 	: navSaveNCommit(int iRowNbr)
	Description		: This will Save, commit and Verify the message
	Author 			: Vivek Kumar
	Creation Date 	: 02/25/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	public static void navSaveNCommit(int iRowNbr,String sExpUserString)
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		try {
			//Saving and commiting 
			//WebObjectUtil.waitForElementPresent(EVDC.getNav_EditVMSaveBtn());
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMSaveBtn());
			//WebObjectUtil.waitForElementPresent(EVDC.getNav_EditVMCommit());
			if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_NewEVDCPopUpBody()))
			{
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_NewEVDCPopUpOKBtn());
			}
			else
			{
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMCommit());
			}
		
			//WebObjectUtil.waitForElementPresent(EVDC.getNav_EVDCcommonPopUp());
			
			//if(WebObjectUtil.isElementPresent(EVDC.getNav_EVDCcommonPopUp()))
			//if(WebObjectUtil.isElementPresent(EVDC.getNav_GuestOSErrorMsgOKBtn()))
			
			if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_EVDCcommonPopUp()))
			{
				//String sErrTxt=EVDC.getNav_ComputeStorageErrMsg().getText();
				String sErrTxt=EVDC_VMPF.getNav_EVDCcommonPopUp().getText();
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Popup Error message" , "fail",sErrTxt);
				LoggerUtil.log_type_error("Error message -" + sErrTxt);
				
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_GuestOSErrorMsgOKBtn());
			}
			
				WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_RefreshPopUpMsg());
				WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_RefreshPopUpMsg());
			
			//Verifying Add Message
			//Thread.sleep(60000);
			//WebObjectUtil.waitForElementPresent(EVDC.getNav_UserfeedBack());
			String sVMName,sActUserFeedback,sExpUserFeedBack;
			sVMName=navGetVMName(iRowNbr);
			sActUserFeedback=EVDC_VMPF.getNav_UserfeedBack().getText();
			sExpUserFeedBack=sVMName  + sExpUserString;
			if(sActUserFeedback.contains(sExpUserFeedBack))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message Verified "    , "pass",sActUserFeedback) ;
				LoggerUtil.log_type_info(" Message Verified  = " +sActUserFeedback );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message not Verified"   , "fail", "Expected :"+sExpUserFeedBack +", Actual :"+sActUserFeedback);
				LoggerUtil.log_type_error(" Message not Verified  =  " +sActUserFeedback );
			}
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with- navSaveNCommit" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	Method Name 	: navEVDCValAddDelNIC
	Description		: This will verify add n delete NIC message
	Author 			: Vivek Kumar
	Creation Date 	: 03/17/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public void navEVDCValAddDelNIC(int iRowNbr)
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		try {
			String sVMStatus, sExpUserString,sVMName,sActUserFeedback,sExpUserFeedBack;
			String sActAddDelMultipleNicMsg,sExpAddDelMultipleNicMsg, sNICLimitMsg,sExpDelMultipleNIC,sMultiAddSingleDel;
			
			sExpUserString=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.ADDDISK");
			sExpAddDelMultipleNicMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.ADDDELMULTIPLE.NIC.MSG");
			sNICLimitMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.NIC.LIMIT.MSG");
			sExpDelMultipleNIC=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.DELMULTIPLE.NIC.MSG");
			sMultiAddSingleDel=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.MULTIPLEADD.SINGLEDELETE.NIC.MSG");
			
			WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_NICsAddNIC());
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_NICsAddNIC());
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_NICsAddNIC());
			//Thread.sleep(3000);
			//clciking on Save
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMSaveBtn());
			if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_NewEVDCPopUpBody()))
			{
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_NewEVDCPopUpOKBtn());
			}
			else
			{
				WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_EditVMCommit());
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMCommit());
			}
			
			Thread.sleep(1000);
			sActAddDelMultipleNicMsg =EVDC_VMPF.getNav_UserfeedBack().getText();
			//Thread.sleep(20000);
			//if(WebObjectUtil.isElementPresent(EVDC.getNav_GuestOSErrorMsgOKBtn()))
			//if(EVDC.getNav_GuestOSErrorMsgOKBtn().isDisplayed())
			if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_GuestOSErrorMsgOKBtn()))
			{
				
				String StrText=EVDC_VMPF.getNav_NICAddDelErrMsg().getText();
				LoggerUtil.log_type_warn(StrText);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Warning PopUpMessage "    , "warn", StrText) ;
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_GuestOSErrorMsgOKBtn());
				//WebObjectUtil.waitForElementNotPresent(EVDC.getNav_GuestOSErrorMsgOKBtn());
				
			}
			//Thread.sleep(2000);
			//WebObjectUtil.waitForElementNotPresent(EVDC.getNav_PlzWaitPopUpMsg());
			WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_RefreshPopUpMsg());
			//WebObjectUtil.waitForElementPresent(EVDC.getNav_RefreshPopUpMsg());
			//sActAddDelMultipleNicMsg =EVDC.getNav_UserfeedBack().getText();
			//System.out.println(sActAddDelMultipleNicMsg);
			//System.out.println(sExpAddDelMultipleNicMsg);
			//System.out.println(sActAddMultipleNicMsg);
			
			if(sActAddDelMultipleNicMsg.contains(sExpAddDelMultipleNicMsg))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message Verified "    , "pass",sActAddDelMultipleNicMsg) ;
				LoggerUtil.log_type_info(" Message Verified  = " +sActAddDelMultipleNicMsg );
			}
			else if(sActAddDelMultipleNicMsg.contains(sNICLimitMsg))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message  Verified"   , "warn", sNICLimitMsg);
				LoggerUtil.log_type_warn(" Message  Verified  =  " +sNICLimitMsg );
			}
			else if(sActAddDelMultipleNicMsg.contains(sMultiAddSingleDel))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message Verified "    , "pass",sActAddDelMultipleNicMsg) ;
				LoggerUtil.log_type_info(" Message Verified  = " +sActAddDelMultipleNicMsg );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message not Verified"   , "fail", "Expected : " +sExpAddDelMultipleNicMsg + ", Actual : "+sActAddDelMultipleNicMsg);
				LoggerUtil.log_type_error(" Message not Verified  =  " +sActAddDelMultipleNicMsg );
			}
			//WebObjectUtil.waitForElementNotPresent(EVDC.getNav_RefreshPopUpMsg());
			//WebObjectUtil.waitForElementPresent(EVDC.getNav_GuestOSErrorMsgOKBtn());
			/*if(EVDC.getNav_GuestOSErrorMsgOKBtn().isDisplayed())
			{
				
				String StrText=EVDC.getNav_NICAddDelErrMsg().getText();
				LoggerUtil.log_type_warn(StrText);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Warning PopUpMessage "    , "warn", StrText) ;
				WebObjectUtil.clickElement(EVDC.getNav_GuestOSErrorMsgOKBtn());
				//WebObjectUtil.waitForElementNotPresent(EVDC.getNav_GuestOSErrorMsgOKBtn());
				
			}*/
			//Thread.sleep(50000);
			//navClickErrBtn();
			sVMName=navGetVMName(iRowNbr);
			//WebObjectUtil.waitForElementPresent(EVDC.getNav_UserfeedBack());
			sActUserFeedback =EVDC_VMPF.getNav_UserfeedBack().getText();
			sExpUserFeedBack=sVMName + " " + sExpUserString;
			if(sActUserFeedback.contains(sExpUserFeedBack))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message Verified "    , "pass",sActUserFeedback) ;
				LoggerUtil.log_type_info(" Message Verified  = " +sActUserFeedback );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message not Verified"   , "fail", "Expected : " +sExpUserFeedBack + ", Actual : "+sActUserFeedback);
				LoggerUtil.log_type_error(" Message not Verified  =  " +sActUserFeedback );
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
	}
	
	/*==============================================================
	Method Name 	: navEVDCDeleteDisk
	Description		: This will delete disk
	Author 			: Vivek Kumar
	Creation Date 	: 03/16/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	

	public static void navEVDCDeleteDisk()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		int iRows=0;
		WebElement wDelete;
		boolean bFlag=false;		
		  try {
			//iRows =driver.findElements(By.xpath("//*[@id='editDisksPanel-body']/div/table/tbody/tr")).size();
			  iRows=driver.findElements(By.xpath("//div[@id='editDisksPanel-body']//table")).size();
			  System.out.println(bFlag);
			  System.out.println(iRows);
			  if(iRows>0)
			  {
				  for(int i=1;i<=iRows;i++)
				  {
					 // wDelete=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+i+"]/td[5]/div/a","Delete Link");
					 // String sDelete = WebObjectUtil.getLocatorValueFromProperty("EVDC.VM.VMTABLE.COMPUTESTORAGETABLE.DELETE.LINK", "PARAMETER_ROWNUMBER", i+"");
					//  wDelete=WebObjectUtil.GetWebElement("xpath", sDelete,"Delete Link");
					// This object is updated on 10/14/2015 By QAA04
					  wDelete = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.COMPUTESTORAGETABLE.DELETE.LINK", "PARAMETER_ROWNUMBER", i +"");
					  if(!(wDelete==null))  
					{
						String sText=wDelete.getText();
						  //System.out.println(sText);
						  if(sText.equalsIgnoreCase("Delete"))
						  {
							 // wDelete.click();
							  WebObjectUtil.clickElement(wDelete);
							  bFlag=true;
							  break;
						  }
					}
					  
					  /*boolean bStatus=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]/div/a[(text()='Delete')]")).isDisplayed();
					  if(bStatus)
					  {
						  driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]/div/a[(text()='Delete')]")).click();
						 bFlag=true;
						 break;
					  }*/
				  }
			  }
			  else
			  {
				  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "There is no Delete Disk link - no Rows" , "fail", "");
				 LoggerUtil.log_type_error("There is no Delete Disk link - no Rows"  );
			  }
			  if(bFlag)
			  {
				 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Clicking on Delete disk link" , "pass","" );
				 LoggerUtil.log_type_info("Clicking on Delete disk link" );
				
			  }
			  else
			  {
				 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "There is no Delete Disk link" , "fail", "");
				 LoggerUtil.log_type_error("There is no Delete Disk link"  );
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	Method Name 	: navValHostNameFldLt()
	Description		: This will validate the Host field input box length for Windows machine and Linux machine
					
	Author 			: Vivek Kumar
	Creation Date 	: 05/25/2015
	Pre-Requisites	:
	Revision History: As per sirisha, for windows machine the length should be 15 and for non-windows it will be 63
	==============================================================*/

	public void navValHostNameFldLt(String sVMNameorStatus,int iHostNameLength)
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		int iRowNbr,iDescriptionInputLt;
		WebElement wOSStatus;
		String sDescriptionInputLt,sWINDOWS,sOS,sREDHAT,sUNIX;
		
		EVDCLoginAndExpand(sVMNameorStatus);
		iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
		stopRunningVM(iRowNbr);
		//###########################################################
		//Getting the OS Name using image
		//wOSStatus=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+iRowNbr+"]//td[4]/div/img","OS Status");
		//wOSStatus=WebObjectUtil.GetWebElement("xpath", "//table["+iRowNbr+"]/tbody/tr[1]/td[4]/div/img","OS Status");
		// This object is updated on 10/14/2015 By QAA04
		wOSStatus = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.OSSTATUS", "PARAMETER_VALUE",iRowNbr +"");
		sOS = wOSStatus.getAttribute("src");
		sWINDOWS=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.OS.WINDOWS");
		sREDHAT=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.REDHAT");
		sUNIX=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.OS.UNIX");
		
		//Verifying and Clicking on Edit button
		navVerifyClkEditBtn(iRowNbr);
		//Verifying Guest OS Customization Tab and Verify its landing page
		WebObjectUtil.clickAndVerifyElement(EVDC_VMPF.getNav_EditGuestOSCust(), EVDC_VMPF.getNav_GuestOSCustPwdResetText());
		
		
		//Fetching the maxlength of the Descritpion input box
		
		sDescriptionInputLt=EVDC_VMPF.getNav_GuestOSHostNameEdit().getAttribute("maxlength");
		iDescriptionInputLt=Integer.parseInt(sDescriptionInputLt);
//		System.out.println(iDescriptionInputLt);
		if(sOS.contains(sWINDOWS))
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VM OS type" , "done","WINDOWS" );
			if(iDescriptionInputLt==iHostNameLength)
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Description input length  = "+  sDescriptionInputLt  , "pass","" );
				LoggerUtil.log_type_info("Description input length = " +sDescriptionInputLt );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VM Name input length= "+  sDescriptionInputLt , "fail", "User Can enter more than 15 character");
				LoggerUtil.log_type_error("Description input length = " +sDescriptionInputLt + " and User Can enter more than 15 character ");
			}
		}
		
		else if(sOS.contains(sREDHAT) ||sOS.contains(sUNIX) )
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VM OS type" , "done","NON-WINDOWS" );
			if(iDescriptionInputLt==iHostNameLength)
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Description input length  = "+  sDescriptionInputLt  , "pass","" );
				LoggerUtil.log_type_info("Description input length = " +sDescriptionInputLt );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VM Name input length= "+  sDescriptionInputLt , "fail", "User Can enter more than 15 character");
				LoggerUtil.log_type_error("Description input length = " +sDescriptionInputLt + " and User Can enter more than 15 character ");
			}
		}
			
		//Closing the window
		WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralCloseBtn());
	}
	/*==============================================================
	Method Name 	: navEVDCVerifyLocalAdmin
	Description		: This will verify the local Admin check box is enabled or not
	Author 			: Vivek Kumar
	Creation Date 	: 03/11/2015
	Pre-Requisites	: VM should be in Stop state and OS should be RedHat 
	Revision History:
	==============================================================*/
	public void navEVDCVerifyLocalAdmin()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		try {
			String sVMStatus,OS;
			int iRowNbr;
			////sVMStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.STATUS");
		//	OS=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.VM.OPERATINGSYSTEM");
			/*
			//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(), EVDC.getNav_AddVMLink());
			//Expand Stopped VM
			iRowNbr=navEVDCWebTableOSnStatus(sVMStatus,OS);
			*/
			String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.REDHAT.VMNAME.OR.STATUS");
			/*if (!sLoginExpandVM){
				//sLoginExpandVM = EVDC_VM_AdvancedActions_EXTJS.navigateAndExpandVM("Stopped");
				sLoginExpandVM = EVDC_VM_AdvancedActions_EXTJS.navigateAndExpandVM(sVMNameorStatus);
				
			}
			iRowNbr = EVDC_VM_AdvancedActions_EXTJS.iVisibleVMRowNum;
			
			stopRunningVM(iRowNbr);*/
			
			EVDCLoginAndExpand(sVMNameorStatus);
			iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
			stopRunningVM(iRowNbr);
			
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
			
			navChkEnableGuestCustomization();
			EVDC_VM_AdvancedActions.expandVMbyRowNum(iRowNbr);
			navVerifyClkEditBtn(iRowNbr);
			
			
			WebObjectUtil.clickAndVerifyElement(EVDC_VMPF.getNav_EditGuestOSCust(), EVDC_VMPF.getNav_GuestOSCustPwdResetText());
			//Verifying Gusest Customization check box
			Thread.sleep(3000);
			
		//	boolean bAdminChkBoxval=WebObjectUtil.isCheckRadioSelected(EVDC.getNav_GuestAdminPwdChkBox());
			boolean bCutomizedChkBoxVal=WebObjectUtil.isCheckRadioSelected(EVDC_VMPF.getNav_GustCustomizationChkBox());
			
			if(bCutomizedChkBoxVal)
			{
				//navValidateAllowLocalAdmin(iRowNbr);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Allow Local Admin checkbox " , "warn","Allow Local Admin checkbox is already checked" );
				 LoggerUtil.log_type_warn("Allow Local Admin checkbox is already checked" );
				 WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralCloseBtn());
				
			}
			else
			{
				WebObjectUtil.selectCheckRadioBox(EVDC_VMPF.getNav_GustCustomizationChkBox());
				navValidateAllowLocalAdmin(iRowNbr);
			}
		} catch (InterruptedException e) {
			LoggerUtil.log_type_error("issue with-Allow Local Admin Checkbox" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
	}
	/*==============================================================
	Method Name 	: navValidateAllowLocalAdmin
	Description		: This will enable/disable Allow Local Admin
	Author 			: Vivek Kumar
	Creation Date 	: 03/10/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public void navValidateAllowLocalAdmin(int iRowNbr)
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		boolean bAdminChkBoxval=WebObjectUtil.isCheckRadioSelected(EVDC_VMPF.getNav_GuestAdminPwdChkBox());
		
		try {
			if(bAdminChkBoxval)
			{
				WebObjectUtil.deSelectCheckBox(EVDC_VMPF.getNav_GuestAdminPwdChkBox());
				//Thread.sleep(5000);
				WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_EditVMSaveBtn());
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMSaveBtn());
				//Thread.sleep(5000);
				if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_NewEVDCPopUpBody()))
				{
					WebObjectUtil.clickElement(EVDC_VMPF.getNav_NewEVDCPopUpOKBtn());
				}
				else
				{
					//WebObjectUtil.waitForElementPresent(EVDC.getNav_EditVMCommit());
					WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMCommit());
				}
				
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Disabling Allow Local Admin and commiting" , "done","" );
				//Thread.sleep(60000);
				navEVDCEditPOPUp();
				//Verifying and Clicking on Edit button
				navVerifyClkEditBtn(iRowNbr);
				WebObjectUtil.clickAndVerifyElement(EVDC_VMPF.getNav_EditGuestOSCust(), EVDC_VMPF.getNav_GuestOSCustPwdResetText());
				bAdminChkBoxval=WebObjectUtil.isCheckRadioSelected(EVDC_VMPF.getNav_GuestAdminPwdChkBox());
				if(!bAdminChkBoxval)
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "disabled" , "pass","Allow Local Admin is disabled after Save" );
					LoggerUtil.log_type_info("Allow Local Admin is disabled after Save" );
				}
				else
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "enabled" , "fail", "Allow Local Admin is still enabled after save");
					LoggerUtil.log_type_error("Allow Local Admin is still enabled after save"  );
				}
				
				//Verifying and Clicking on Edit button
				navVerifyClkEditBtn(iRowNbr);
				WebObjectUtil.clickAndVerifyElement(EVDC_VMPF.getNav_EditGuestOSCust(), EVDC_VMPF.getNav_GuestOSCustPwdResetText());
				navEnableAllowLocalAdmin(iRowNbr);				
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralCloseBtn());
			}
			else
			{
				navEnableAllowLocalAdmin(iRowNbr);
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralCloseBtn());
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	Method Name 	: navEVDCEditPOPUp
	Description		: This will verify the popup
	Author 			: Vivek Kumar
	Creation Date 	: 03/10/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public void navEVDCEditPOPUp()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		try {
			WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_EVDCcommonPopUp());
		//	if(EVDC.getNav_EVDCcommonPopUp().isDisplayed())
			if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_EVDCcommonPopUp()))
			{
				String sErrorTxt=EVDC_VMPF.getNav_EVDCcommonPopUp().getText();
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "POP Up displayed" , "fail", sErrorTxt);
				LoggerUtil.log_type_error("Pop up Displayed - " + sErrorTxt );
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_GuestOSErrorMsgOKBtn());
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	Method Name 	: navEnableAllowLocalAdmin
	Description		: This will enable Allow Local Admin
	Author 			: Vivek Kumar
	Creation Date 	: 03/10/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public void navEnableAllowLocalAdmin(int iRowNbr)
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		boolean bAdminChkBoxval;
		 
		try {
			//Thread.sleep(5000);
			WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_GuestAdminPwdChkBox());
			WebObjectUtil.selectCheckRadioBox(EVDC_VMPF.getNav_GuestAdminPwdChkBox());
			//Thread.sleep(5000);
			WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_EditVMSaveBtn());
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMSaveBtn());
			//Thread.sleep(5000);
			if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_NewEVDCPopUpBody()))
			{
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_NewEVDCPopUpOKBtn());
			}
			else
			{
				//WebObjectUtil.waitForElementPresent(EVDC.getNav_EditVMCommit());
				WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditVMCommit());
			}
			
			
			
		//	WebObjectUtil.waitForElementPresent(EVDC.getNav_RefreshPopUpMsg());
			WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_RefreshPopUpMsg());
			
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "enabling Allow Local Admin and commiting" , "done","" );
			//Thread.sleep(60000);
			navEVDCEditPOPUp();
			//Verifying and Clicking on Edit button
			navVerifyClkEditBtn(iRowNbr);
			WebObjectUtil.clickAndVerifyElement(EVDC_VMPF.getNav_EditGuestOSCust(), EVDC_VMPF.getNav_GuestOSCustPwdResetText());
			bAdminChkBoxval=WebObjectUtil.isCheckRadioSelected(EVDC_VMPF.getNav_GuestAdminPwdChkBox());
			Thread.sleep(10000);
			if(bAdminChkBoxval)
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Allow Local Admin is enabled after Save" , "pass","" );
				LoggerUtil.log_type_info("Allow Local Admin is enabled after Save" );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Allow Local Admin is still disabled after save" , "fail", "");
				LoggerUtil.log_type_error("Allow Local Admin is still diabled after save"  );
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	/*==============================================================
	Method Name 	: navVerifyClkStopBtn
	Description		: This will verify and click Stop buttons
	Author 			: Vivek Kumar
	Creation Date 	: 02/17/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static boolean navVerifyClkStopBtn(int iRowNbr)
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		String sExpStopMsg,sActStopMsg,sStopErrMsg;
		String sExpectedStopMsg;
		String sVMName,sVMStatus=null;
		boolean bflag=false;
		WebElement wStop,wVMStatus;
		sExpectedStopMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.STOP.USERMSG");
		sExpStopMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.STOP.MESSAGE");
		sStopErrMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.STOP.ERRMSG");
		sVMName=navGetVMName(iRowNbr);
		try {
			//wStop=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+ iRowNbr+"]/td/table/tbody/tr[2]//a[contains(text(),'Stop')]","Stop Button");
			//wStop=WebObjectUtil.GetWebElement("xpath", "//table[]//a[text()='Stop']","Stop Button");
			// This object is updated on 10/14/2015 By QAA04
			//wStop = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.STOP", "PARAMETER_ROWNUMBER", 1+"");
			wStop = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.STOP.BUTTON", "PARAMETER_ROWNUMBER", iRowNbr+"");
			if(wStop != null)
			{

				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button verified " , "pass","Stop button verified");
				LoggerUtil.log_type_info("Stop button verified" );
				//wStop.click();
				WebObjectUtil.clickElement(wStop);
				//##############################################
				while(EVDC_VMPF.getNav_UserfeedBack().getText().contains(sStopErrMsg))
				{
					System.out.println(EVDC_VMPF.getNav_UserfeedBack().getText());
					LoggerUtil.log_type_warn(EVDC_VMPF.getNav_UserfeedBack().getText());
					Thread.sleep(20000);
					//driver.findElement(By.xpath("//table/tbody/tr["+ iRowNbr+"]/td/table/tbody/tr[2]//a[contains(text(),'Stop')]")).click();
					WebObjectUtil.clickElement(wStop);
				}
							
				//##############################################
				/*WebObjectUtil.waitForElementPresent(EVDC.getNav_StopPopUpMsg());
				WebObjectUtil.verifyElementPresent(EVDC.getNav_StopPopUpMsg());
				sActStopMsg=EVDC.getNav_StopPopUpMsg().getText();*/
				WebObjectUtil.waitForElementNotPresent(EVDC_VMPF.getNav_StopPopUpMsg());
				//System.out.println(" Actual Messgae = " +sActResetMsg);
				//navEVDCValExpectedActualMsg(sExpStopMsg,sActStopMsg);
				bflag=true;

				//wVMStatus=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr[" + iRowNbr + "]/td/table/tbody/tr[1]/td[5]/div","VM Status");
				//wVMStatus=WebObjectUtil.GetWebElement("xpath", "//table[" + iRowNbr + "]//td[@data-columnid='table_col_state']/div","VM Status");
				// This object is updated on 10/14/2015 By QAA04
				wVMStatus = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.VMSTATUS", "PARAMETER_ROWNUMBER", iRowNbr+"");
				Thread.sleep(5000);
				sVMStatus = wVMStatus.getText();
				
				if (!sVMStatus.equalsIgnoreCase("stopped") ){
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Stopped Status" , "fail", "VM status is not in Stopped status and current status :" + sVMStatus);
					navVerifyClkRefreshBtn(iRowNbr);
					//wVMStatus=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr[" + iRowNbr + "]/td/table/tbody/tr[1]/td[5]/div","VM Status");
					//wVMStatus=WebObjectUtil.GetWebElement("xpath", "//table[" + iRowNbr + "]//td[@data-columnid='table_col_state']/div","VM Status");
					// This object is updated on 10/14/2015 By QAA04
					wVMStatus = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.VMSTATUS", "PARAMETER_ROWNUMBER", iRowNbr+"");
					wVMStatus.click();
					sVMStatus = wVMStatus.getText();
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VM refresh" , "warn", "VM status after refresh :" + sVMStatus);
					if (!sVMStatus.equalsIgnoreCase("stopped") ){
							
						bflag=false;
					}
				}
				
				
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Button not verified" , "fail", "Stop button ");
				LoggerUtil.log_type_error("Stop button not verified");
			}
			//WebObjectUtil.waitForElementNotPresent(EVDC.getNav_StopPopUpMsg());
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			//#######################################
			Thread.sleep(5000);
			String sExpectedMessage,sActualMessage;
			sExpectedMessage=sVMName + " " + sExpectedStopMsg;
			
			//Getting text from appliaction
			sActualMessage=EVDC_VMPF.getNav_UserfeedBack().getText();
			navEVDCValExpectedActualMsg(sExpectedMessage,sActualMessage);
			WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_UserfeedBackImage());
			//#######################################
			
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with- navVerifyStopBtn" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		//###########################################################

		/*WebDriverUtil.refreshBrowser();
		bflag=WebTableUtil.verifyTextPresentOnRow(EVDC.getNav_VMWebTable(), EVDC_VM_AdvancedActions_EXTJS.iVisibleVMRowNum, "Stopped");
		*/
		
		return bflag;
		
	}
	

	/*==============================================================
	Method Name 	: navGetEVDCOrgName
	Description		: This will get organization name from EVDC Selector
	Author 			: Vivek Kumar
	Creation Date 	: 10/08/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static String navGetEVDCOrgName()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		String sOrgName = null;
		try {
			String[] arrayOrgname;
			sOrgName=EVDC_VMPF.getNav_EVDCSelectorEdit().getText();
			arrayOrgname=sOrgName.split("-");
			sOrgName=arrayOrgname[(arrayOrgname.length)-1].trim();
		} catch (Exception e) {
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage());
		}
		return sOrgName;
	}
	/*==============================================================
	Method Name 	: navAddVMDialogSubmit
	Description		: This will Add VM
	Author 			: Vivek Kumar
	Creation Date 	: 03/03/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static boolean navAddVMDialogSubmit(String sVMName) 
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		String sExpUserMsg,sActUserMsg;
		boolean bFlag=false;
		sExpUserMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.ADDVM.SUCCESS.MESSAGE");
		try {
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_VMBlankVMName());
			WebObjectUtil.SetValueEdit(EVDC_VMPF.getNav_VMBlankVMNameEdit(), sVMName);
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_VMBlankStorageProfile());
			WebObjectUtil.ClickAndMouseHover(EVDC_VMPF.getNav_VMBlankVMDropDown());
		//	WebObjectUtil.clickElement(EVDC.getNav_VMBlankVMAny());
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_VMBlankVMEMCSAN());

			
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
			
			Thread.sleep(10000);
			WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_UserfeedBack());
			sActUserMsg=EVDC_VMPF.getNav_UserfeedBack().getText();
			if(sActUserMsg.contains(sExpUserMsg))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message Verified "    , "pass",sExpUserMsg) ;
				LoggerUtil.log_type_info(" Message Verified  = " +sExpUserMsg );
				bFlag=true;
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message not Verified"   , "fail", "Expected : " +sExpUserMsg + ", Actual : "+sActUserMsg);
				LoggerUtil.log_type_error(" Message not Verified  =  " +sExpUserMsg );
			}
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with- navAddVM" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		return bFlag;
	}
	
	/*==============================================================
	Method Name 	: navDeleteFailedVM(int iRowNbr)
	Description		: This will delete the failed VM
	Author 			: Vivek Kumar
	Creation Date 	: 03/03/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navDeleteFailedVM(int iRowNbr)
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		WebElement wDelete;
		try {
			//wDelete=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr[" + iRowNbr + "]/td/table/tbody/tr[1]/td[11]/div/a[contains(text(),'Delete')]","Delete Link");
			//wDelete=WebObjectUtil.GetWebElement("xpath", "//table[" + iRowNbr + "]/tbody/tr[1]/td[11]/div/a[contains(text(),'Delete')]","Delete Link");
			// This object is updated on 10/14/2015 By QAA04
			wDelete = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.FAILEDVM", "PARAMETER_ROWNUMBER", iRowNbr+"");
			if(wDelete != null)
			{
				//wDelete.click();
				WebObjectUtil.clickElement(wDelete);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Clicking Delete Link "    , "pass","") ;
				LoggerUtil.log_type_info("Clicking Delete Link "  );
				//Thread.sleep(5000);
				//WebObjectUtil.waitForElementPresent(EVDC.getNav_ConfirmDelete());
				if(EVDC_VMPF.getNav_NewEVDCPopUpBody().isDisplayed())
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Clicking Confirm Delete Button "    , "pass","") ;
					LoggerUtil.log_type_info("Clicking Confirm Delete Button "  );
					//EVDC.getNav_ConfirmDelete().click();
					if(WebObjectUtil.isElementPresent(EVDC_VMPF.getNav_NewEVDCPopUpBody()))
					{
						WebObjectUtil.clickElement(EVDC_VMPF.getNav_NewEVDCPopUpOKBtn());
					}
					else
					{
						WebObjectUtil.clickElement(EVDC_VMPF.getNav_ConfirmDelete());
					}
					
				}
				else
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Confirm Delete Button not found"   , "fail", "");
					LoggerUtil.log_type_error("Confirm Delete Button not found"  );
				}
				
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Delete Link not found"   , "warn", "");
				LoggerUtil.log_type_warn(" Delete Link not found"  );
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
			LoggerUtil.log_type_error("issue with- navDeleteFailedVM" );
			LoggerUtil.log_type_error(e.getMessage());
		}
		
		
	}
	/*==============================================================
	Method Name 	: VMCreateTicket
	Description		: Create Ticket from VM 
	Author 			: Arularasu
	Creation Date 	: 03/23/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static String VMCreateTicket(int iRowNum){
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		boolean bStatus = false;
		WebElement createTicket;
		String sVMCreateTicketId=null;
		
		try {
			String sNotes = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.CREATETICKET.NOTES");
		//	String sLocatorValue = "//table//tr[" + iRowNum + "]//div[@id='vm_button_start_modify']//img";
			//String sLocatorValue= WebObjectUtil.getLocatorValueFromProperty("EVDC.VM.VMTABLE.CREATETICKET.BUTTON", "PARAMETER_ROWNUMBER", iRowNum+"");
			//WebElement creatTicket = WebObjectUtil.GetWebElement("xpath", sLocatorValue,"Create Ticket button");
			// This object is updated on 10/14/2015 By QAA04
			createTicket = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.CREATETICKET.BUTTON", "PARAMETER_ROWNUMBER", iRowNum+"");
			//creatTicket.click();
			  WebObjectUtil.clickElement(createTicket);
			//EVDC.getNav_VMCreateTicketBtn().click();
			WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_VMcreateTicketTitleEdit());
			/*WebElement  ticketNotes = WebDriverUtil.getDriver().switchTo().activeElement();
			ticketNotes.sendKeys(sNotes);*/
			
			WebObjectUtil.SetValueEdit(EVDC_VMPF.getNav_VMcreateTicketTitleEdit(),"EVDC Create Ticket");
			//This below line is updated by QAA03
			//WebObjectUtil.SetValueEdit(EVDC_VMPF.getNav_VMcreateTicketNoteEdit(),"EVDC Note Ticket");
			EVDC_VMPF.getNav_VMcreateTicketNoteEdit().sendKeys("EVDC Note Ticket");

			WebElement createBtn = WebObjectUtil.getElementbyTagNameValue("span","Create","Create Ticket button");
			WebObjectUtil.clickElement(createBtn);
			String sSuccessMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.CREATETICKET.SUCCESSMSG");
			EVDC_VM_AdvancedActions.verifySuccessMsg(EVDC_VMPF.getNav_EVDCcommonPopUp(),sSuccessMsg);
			WebObjectUtil.waitForElementPresent(EVDC_VMPF.getNav_GuestOSErrorMsgOKBtn());
            sVMCreateTicketId = EVDC_VMPF.getNav_VMcreateTicketID().getText();
            
			WebElement oKBtn = WebObjectUtil.getElementbyTagNameValue("span","OK","Ok btn");
			WebObjectUtil.clickElement(oKBtn);
			//EVDC.getNav_GuestOSErrorMsgOKBtn();
			
			EVDC_VM_AdvancedActions.verifySuccessMsg(EVDC_VMPF.getNav_UserfeedBack(),sSuccessMsg);
			bStatus = true;	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		return sVMCreateTicketId;
	}

	
	
	
	/*==============================================================
	Method Name 	: getEVDCNameAsWebElement
	Description		: Get EVDC element by passing its name
	Author 			: Arul
	Creation Date 	: 10/02/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/	
public static WebElement getEVDCNameAsWebElement(String sEVDCName){
	String sEVDCNameRunnTime;
	WebElement wEVDCName;
	
	// This object is updated on 10/14/2015 By QAA04
	//wEVDCName = WebObjectUtil.GetWebElement("xpath", "//main/div/section[@class='rectangle long evdc']//h2[@id='edvc_1']/a", "EVDC Name");
	wEVDCName = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.NAME", "", "");
	for (WebElement wEVDC : WebObjectUtil.webElementsList){
		sEVDCNameRunnTime = wEVDC.getText();
		if(sEVDCNameRunnTime.equalsIgnoreCase(sEVDCName)){
			wEVDCName = wEVDC;
			break;
		}
	}
	return wEVDCName;
}
/*==============================================================
Method Name 	: navigateToEVDCVMPage
Description		: Navigates to EVDC and VM Page
Author 			: QAA03
Creation Date 	: 10/09/2015
Pre-Requisites	:
Revision History:
==============================================================*/
	
public static boolean navigateToEVDCVMPage(String sEVDCName)
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EVDC_VMPF);
	PageFactory.initElements(driver, EVDC_OverviewPF);
	boolean bStatus=false;
	WebElement wEVDCNamelink;
	if (sEVDCName == null || sEVDCName.length() <= 0){
		WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
	}else{
	wEVDCNamelink = getEVDCNameAsWebElement(sEVDCName);
	wEVDCNamelink.click();
	}
	WebObjectUtil.explicitWait(5);
	/*WebObjectUtil.verifyElementPresent(EVDC.getNav_EVDCOverviewVirtualMachine());
	WebObjectUtil.clickElement(EVDC.getNav_EVDCOverviewVirtualMachine());
	WebObjectUtil.verifyElementPresent(EVDC.getNav_AddVMLink());*/
	WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine(), EVDC_VMPF.getNav_AddVMLink());
	bStatus = true;
	return bStatus;
	
}
/*==============================================================
Method Name 	: navAddBlankVM
Description		: This will Add Blank VM
Author 			: Vivek Kumar
Creation Date 	: 12/09/2015
Pre-Requisites	:
Revision History:
==============================================================*/
public static void navAddBlankVM(String sVMName) 
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EVDC_VMPF);
	
	
	try {
		 WebObjectUtil.clickElement(EVDC_VMPF.getNav_VMSelectType());
		
		//Verify the content under WebList
		WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_AddVMBlankVM());
		WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_AddVMfromTemplate());
		WebObjectUtil.clickElement(EVDC_VMPF.getNav_AddVMBlankVM());
		
		//Verifying and Clicking and slecting on Blank VM
		//WebObjectUtil.verifyElementPresent(EVDC.getNav_AddVMBlankVM());
		//WebObjectUtil.clickElement(EVDC.getNav_AddVMBlankVM());
		//Adding VM
		navAddVMDialogSubmit(sVMName);
		
	} catch (Exception e) {
		LoggerUtil.log_type_error("issue with- navAddBlankVM" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
	
}

/*==============================================================
Method Name 	: navAddVMFromTemplate
Description		: This will Add VM from template
Author 			: Vivek Kumar
Creation Date 	: 12/09/2015
Pre-Requisites	:
Revision History:
==============================================================*/
public static void navAddVMFromTemplate(String sVMName) 
{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_VMPF);
		
	try {
		
		WebObjectUtil.clickElement(EVDC_VMPF.getNav_VMSelectType());
		//Clicking and slecting on  VM from Template
		WebObjectUtil.clickElement(EVDC_VMPF.getNav_AddVMfromTemplate());
		//Clicking on WindStream object
		WebObjectUtil.clickElement(EVDC_VMPF.getNav_AddVMWindstreamObject());
		Thread.sleep(2000);
		//Clicking on first Template
		WebObjectUtil.clickElement(EVDC_VMPF.getNav_ClickingVMfromTemplate());
		//Adding VM
		navAddVMDialogSubmit(sVMName);
		
		
	} catch (Exception e) {
		LoggerUtil.log_type_error("issue with- navAddVMFromTemplate" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
	
}

/*====================================================================================================
Method Name 	: verifyNetworkCountinHomeAndEVDCPage
Description		: Verifying Network Count in Home and EVDC Overview Page
Author 			: QAA03
Creation Date 	: 12/09/2015
Pre-Requisites	:
Revision History:
====================================================================================================*/
public static void verifyNetworkCountinHomeAndEVDCPage()
{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,Home);
		PageFactory.initElements(driver,EVDC_OverviewPF);
		
		WebElement wNetworksNumber;
		String sHomeNetworkNo=null;
		int iEVDCNetworkNo,iHomeNetworkNo;
	
 try { 
	   
	    //wNetworksNumber= WebObjectUtil.getWebElementFromDynamicLocator("xpath", "HOME.EVDCPORTLET.NETWORK.NUMBER", "PARAMETER_EVDC_NAME", sEVDCName);
	    //WebObjectUtil.verifyElementPresent(wNetworksNumber);
	    //sHomeNetworkNo  = wNetworksNumber.getText();
	    sHomeNetworkNo = Home.getNav_HomeEVDCNetworkNo().getText();
	    iHomeNetworkNo = Integer.parseInt(sHomeNetworkNo);
	    
	    //Click on EVDC Name
	    WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
	    //Getting the Count of Network table
		CustomWebElementUtil.loadCustomElement(EVDC_OverviewPF.getNav_NetworksParentTable(), "table");
		iEVDCNetworkNo = CustomWebElementUtil.iRowCount;
		
		FrameworkUtil.updateCustomResultBasedOnStatus(iHomeNetworkNo==iEVDCNetworkNo,"Network Count in Home and EVDC Overview Page");
	    
		  
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyNetworkCountinHomeAndEVDCPage", "warn", "catch block:" +e.getMessage());  
	}
	
}

	

	//update each @Test result in custom result file
		@AfterMethod
		public static void afterEachMethod(){
			FrameworkUtil.updateTestCaseStatusinResult();
			
		}

		@AfterTest
		public void afterTest(){
			if (sLoginExpandVM || LoginTestCase.bLoginStatus ){
			FrameworkUtil.sTestCaseName = "Logout";
			FrameworkUtil.sManualTestCaseName="Logout Navigator";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			LoginTestCase.nav_Logout();
			FrameworkUtil.updateTestCaseStatusinResult();
			}
		}
	
}
	