package com.whs.navigator.testcases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import com.whs.navigator.pagefactory.EVDC_FirewallPageFactory;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.EVDC_VM_PageFactory;
import com.whs.navigator.pagefactory.EntityBrowserPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.SmokeTestPageFactory;
import com.whs.navigator.pagefactory.DraasPageFactory;
import com.whs.navigator.pagefactory.CommonPageFactory;
import com.whs.navigator.pagefactory.TicketPageFactory;
import com.whs.navigator.testcases.TicketTestCase;
public class EVDC_Overview_TestCase {
	public static EVDC_OverviewPageFactory EVDC_OverviewPF= new EVDC_OverviewPageFactory();
	public static EVDC_VM_PageFactory EVDC_VMPF=new EVDC_VM_PageFactory();
	public static SmokeTestPageFactory Smoke= new SmokeTestPageFactory();
	public static HomePageFactory_old Home= new HomePageFactory_old();
	public static DraasPageFactory DRaaS= new DraasPageFactory();
	public static CommonPageFactory Common=new CommonPageFactory();
	public static TicketPageFactory Ticket=new TicketPageFactory();
	public static EntityBrowserPageFactory EBPanel = new EntityBrowserPageFactory();
	public static EVDC_FirewallPageFactory EVDC_FirewallPF = new EVDC_FirewallPageFactory();
	
	public static boolean sLoginExpandVM = false ;
	static boolean bVMStoppedStatus = false;
	static boolean bVMStartStatus = false ;
	static String sEVDCurl = null;

	public static String[] arrEntityNameListAsArray,arrParentEntityNameListAsArray,arrEVDCNameListAsArray;
	/*==============================================================
	TestScript  	: navEVDCListedInfo
	Manual TestCase	: Review the info in each EVDC listed. and Check for the existence of the EVDC info.
					: Check for the existence of the EVDC info.
	Description		: Review the info in each EVDC listed. and Check for the existence of the EVDC info.
	Author 			: Vivek Kumar
	Creation Date 	: 02/09/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	@Test(priority=1)
	public void navEVDCListedInfo() 
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navEVDCListedInfo";
			FrameworkUtil.sManualTestCaseName="1.Check for the existence of the EVDC info."+'\n' + "2.Review the info in each EVDC listed.";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			//Login to Navigator
			navEVDCLogin();
			//Verifying DataCenter Name and EVDc Portlet
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCname());
			//Verifying VM-Count
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_VMCountText());
			//Verifying Networks
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_Networks());
			//Verifying Firewall views
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_Firewall());
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_FirewallViewLink());
			//Verifying vCPU
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_vCPUs());
			//Verifying vRAM
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_vRam());
			//Verifying Storage
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_Storage());
			//Verifying vCloud Director
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_vCloudDirector());

			//Logging out from Navigator application
		//	LoginTestCase.nav_Logout();
			EVDCLogout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("Issue with identifying EVDC portlet and its listed info");
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
			LoggerUtil.log_type_error(e.getMessage());
		}
	
	}
	/*==============================================================
	TestScript  	: navEVDCNamelandingPage
	Manual TestCase	: Check EVDC name link 
	Description		: Verify EVDC landing page
	Author 			: Vivek Kumar
	Creation Date 	: 02/09/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=2)
	public void navEVDCNamelandingPage() 
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navEVDCNamelandingPage";
			FrameworkUtil.sManualTestCaseName="Check EVDC name link ";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Name and validating its landing page
			//WebObjectUtil.clickElement(EVDC.getNav_EVDCname());
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			
			//Logging out from Navigator application
			//LoginTestCase.nav_Logout();
			EVDCLogout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("Issue with identifying EVDC Name Landing Page");
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
			LoggerUtil.log_type_error(e.getMessage());
		}
	}
	

	/*==============================================================
	TestScript  	: navEVDCVMCountLink
	Manual TestCase	: Check VM count link
	Description		: Verify that the VM details page is displayed correctly when user click on the link.
	Author 			: Vivek Kumar
	Creation Date 	: 02/10/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=3)
	public void navEVDCVMCountLink()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);	
		
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navEVDCVMCountLink";
			FrameworkUtil.sManualTestCaseName=" Check VM count link ";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			//Login to Navigator
			navEVDCLogin();
			
					
			//Verifying VM-Count Link
			WebObjectUtil.clickByJS(EVDC_OverviewPF.getNav_VMCountNumberLink());
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_AddVMLink());
			//Logging out from Navigator application
			//LoginTestCase.nav_Logout();
			EVDCLogout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("Issue with VM-Count number Link");
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
	}
	

	/*==============================================================
	TestScript  	: navEVDCVNameFormat
	Manual TestCase	: EVDC name should follow this format: Datacenter location (displayed as City, State abbreviation) - Org name as shown in vCD
	Description		: Verify EVDC name is shown like these examples: 
						Charlotte, NC - 11Giraffes
						Nashville, TN - saffrontechn 
	Author 			: Vivek Kumar
	Creation Date 	: 02/10/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=4)
	public void navEVDCVNameFormat()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navEVDCVNameFormat";
			FrameworkUtil.sManualTestCaseName="EVDC name should follow this format: Datacenter location (displayed as City, State abbreviation) - Org name as shown in vCD";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			String sCity=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.CITY");
			String sState=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.STATE");
			String sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.ORG");;
			String sEVDCNameFormat=sCity+", "+ sState+" - "+sOrgName;
			//Login to Navigator
			navEVDCLogin();
			String ActualOrgFormat=EVDC_OverviewPF.getNav_EVDCname().getText();
			
			if(sEVDCNameFormat.equals(ActualOrgFormat))
			{
				LoggerUtil.log_type_info("EVDC name format verified");
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "EVDC name format verified", "pass", "");
			}
			else
			{
				LoggerUtil.log_type_error("Issue with EVDC name format ");
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Issue with EVDC name format", "fail", "");
				
			}
			//Logging out from Navigator application
			//LoginTestCase.nav_Logout();
			EVDCLogout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("Issue with EVDC name format ");
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	

	/*==============================================================
	TestScript  	: navValRunningVM
	Manual TestCase	: View an EVDC for an Org that has multiple VMs, but with not all of the VMs powered on.
	Description		: Verify that only powered-on VMs are included for CPU and Memory totals in the EVDC landing page.
	Author 			: Vivek Kumar
	Creation Date 	: 03/23/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=5)
	public void navValRunningVM()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);	
				
		String sCPUCount,sRAMCount;
		
		
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navValRunningVM";
			FrameworkUtil.sManualTestCaseName="View an EVDC for an Org that has multiple VMs, but with not all of the VMs powered on.";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

			//Login to Navigator
			navEVDCLogin();
			
			//Getting the vCPU and vRAM count
			sCPUCount=EVDC_OverviewPF.getNav_vCPUsvg().getText();
			sRAMCount=EVDC_OverviewPF.getNav_vRAMsvg().getText();
			
			sCPUCount=(sCPUCount.replace("vCPU", "")).trim();
			sRAMCount=(sRAMCount.replace("GB", "")).trim();
			//System.out.println(sCPUCount);
			//System.out.println(sRAMCount);
			
			//Clicking on EVDC Name and validating its landing page
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine(), EVDC_VMPF.getNav_AddVMLink());
			navValCPUnRAMCnt("Running",sCPUCount,sRAMCount);
			//Logging out from Navigator application
			//LoginTestCase.nav_Logout();
			EVDCLogout();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			LoggerUtil.log_type_error("Issue with EVDC - Running VM count and RAM count ");
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	TestScript  	: navEVDCSelector
	Manual TestCase	: Check EVDC org in the EVDC selector
	Description		: Verify the EVDCs that belong to the logged in Org appear in the list.
	Author 			: Vivek Kumar
	Creation Date 	: 02/10/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=6)
	public void navEVDCSelector()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		
		boolean bStatus=false;
		
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navEVDCSelector";
			FrameworkUtil.sManualTestCaseName="Check EVDC org in the EVDC selector";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			String sSelectorValue=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.NAME");
			//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Name and validating its landing page
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			String sSelectorText=EVDC_OverviewPF.getNav_EVDCOrgSelector().getText();
			//System.out.println(sSelectorValue + '\n'+ sSelectorText);
			bStatus=sSelectorValue.equalsIgnoreCase(sSelectorText);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Verifying Org - " + sSelectorText + " is diplaying correctly");
						
			//Logging out from Navigator application
			//LoginTestCase.nav_Logout();
			EVDCLogout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue Org name in the selector" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
	}
	

	
	/*==============================================================
	TestScript  	: navEVDCOverviewPortlet
	Manual TestCase	: View the EVDC overview page
	Description		: Verify all the porlets are displayed in the EVDC overview page: .
	Author 			: Vivek Kumar
	Creation Date 	: 02/10/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=7)
	public void navEVDCOverviewPortlet()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navEVDCOverviewPortlet";
			FrameworkUtil.sManualTestCaseName="View the EVDC overview page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			String sSelectorValue=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.NAME");
			//Login to Navigator
			navEVDCLogin();
			//Clicking on EVDC Name and validating its landing page
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			//Verifying Virtual Machine
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			//Verifying Catalogs
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCOverviewCatalogs());
			//Verifying Storage
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCOverviewStorage());
			//Verifying Cloud AV
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCOverviewCloudAV());
			//Verifying Cloud Migration
			//WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCOverviewCloudMigrations());
			//Verifying Firewall
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCOverviewFirewall());
			//Commenting the below code for feedback- as this got removed in new release
			//Verifying Feedback
			//WebObjectUtil.verifyElementPresent(EVDC.getNav_EVDCOverviewFeedback());
			//Networks
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCOverviewNetworks());
			//Verifying Bandwidth
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCOverviewBandwidth());
			//Compute Statistics
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCOverviewComputeStatistics());
			//Logging out from Navigator application
			//LoginTestCase.nav_Logout();
			
			EVDCLogout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with-portlet on the overview page" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
	}
	  /*=================================================================================================
   	TestScript  	: checkComputerStatisticsData
   	Manual TestCase	: CPPOC-3032 Checking Data Present under Computer Statistics
   	Description		: Checking CPU And Memory allocation Data Present under Computer Statistics
   	Author 			: QAA03
   	Creation Date 	: 08/04/2015
   	Pre-Requisites	:
   	Revision History:
   	======================================================================================================*/
	@Test(priority=12)	
	public static void CheckComputerStatisticsData()
	{
		 WebDriver driver = WebDriverUtil.getDriver();
		 PageFactory.initElements(driver, EVDC_OverviewPF);
		 
		 String sUserName,sPassword;
		                 
		try {
			FrameworkUtil.sTestCaseName = "CheckComputerStatisticsData";
			FrameworkUtil.sManualTestCaseName="Checking Data Present under Computer Statistics";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			                 
			//String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLE.USERID");
			//String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLE.PWD");
			
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.JONESSCHOOLSUPPLY.USERID.JEFFJONES");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.JONESSCHOOLSUPPLY.PWD.JEFFJONES");
			
			LoginTestCase_Old1.nav_Login(sUserName, sPassword);
			VerifyCSData();
			LoginTestCase_Old1.nav_Logout();
			
		} catch (Exception e) {
			LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "CheckComputerStatisticsData", "warn", "catch block:Could NOT access webelement" +e.getMessage());
		}
		

	}

	
	
	//######################################################################################
	//-------------------------------METHODS------------------------------------------------
	//######################################################################################
	
	/*==============================================================
	Method Name 	: navEVDCLogin
	Description		: This will Login to Navigator 
	Author 			: Vivek Kumar
	Creation Date 	: 02/09/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	public static boolean navEVDCLogin() 
	{
		boolean bStatus = false;
		WebDriver driver = WebDriverUtil.getDriver();
		
		try {
			//getting UserId from properties file
			String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.USERID.QAAUTO");
			//String sUserName = FrameworkUtil.getPropValues("NAV.EVDC.USERID");
			//getting password from properties file
			String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.PWD.QAAUTO");
			//Login to Navigator portlet 
			bStatus =LoginTestCase_Old1.nav_Login(sUserName,sPassword);
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with- navEVDCLogin" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage());
		}
		return bStatus;
	}	

	public static void EVDCLogout(){
		try {
			sLoginExpandVM = false ;
		/*	if (WebObjectUtil.isElementPresent(EVDC.getNav_EditGeneralCloseBtn())){
				EVDC.getNav_EditGeneralCloseBtn().click();
			}*/
			LoginTestCase_Old1.nav_Logout();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	/*==============================================================
	Method Name 	: navValCPUnRAMCnt
	Description		: This will validate the CPU n RAm count
	Author 			: Vivek Kumar
	Creation Date 	: 03/23/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/

	public static void navValCPUnRAMCnt(String VMStatus,String sCPUCount, String sRAMCount)
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);	
		
		int iRows,iCols,iRowVal = 0;
		WebElement wVMStatus,wRAM,wCPU;
		int vCPU, vCPUCount=0;
		double vRAMCount=0.0f;
		String vRAM, sSubString;
		
		try {
			//Getting the row count
			// iRows =driver.findElements(By.xpath("//*[@id='vmListExtGridPanel-body']/div/table/tbody/tr")).size();
			
			//Getting the column count			
			// iCols=driver.findElements(By.xpath("//*[@id='vmListExtGridPanel-body']/div/table/colgroup")).size();
			CustomWebElementUtil.loadCustomElement(EVDC_VMPF.getNav_VMWebTableParent(), "table");
			iRows=WebTableUtil.getRowCount(EVDC_VMPF.getNav_VMWebTableParent());
			//Dividing the total count by 2
			iRows=iRows/2;
			 for(int j=1;j<=iRows;j++)
				{
					//driver.findElements(By.xpath("//table/tbody/tr[" + j + "]/td/table/tbody/tr[1]/td[5]/div")).contains(text(),'stopped');
				// wVMStatus=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr[" + j + "]/td/table/tbody/tr[1]/td[5]/div");
				// wVMStatus=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr[" + j + "]/td/table/tbody/tr[1]","VM Status");
				//-- wVMStatus=WebObjectUtil.GetWebElement("xpath", "//table[" + j + "]/tbody/tr[1]/td[5]/div","VM Status");
				 //wVMStatus=WebTableUtil.getRowAsWebElement(EVDC.getNav_VMWebTable(), j);
				//-- String text = wVMStatus.getText();
				 
				 ////commented the above line(//--) and added the below line as part of EXTJS5 change-Vivek - 10082015
				 String text=CustomWebElementUtil.getCellData(j, 5).trim();
				// System.out.println("text- "+j + " - "  + text);
				 //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
				//-- if(wVMStatus != null)
				 if(text != null)
				 {
				
					if(text.contains(VMStatus))
					{
						// wCPU=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr[" + j + "]//td[6]/div","CPU");
					//--	wCPU=WebObjectUtil.GetWebElement("xpath", "//table[" + j + "]/tbody/tr[1]/td[6]/div","CPU");
					//--	 vCPU=Integer.parseInt(wCPU.getText());
						
						 //commented the above line(//--) and added the below line as part of EXTJS5 change-Vivek - 10082015
						vCPU=Integer.parseInt(CustomWebElementUtil.getCellData(j, 6).trim());
						 vCPUCount=vCPUCount+vCPU;
						// wRAM=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr[" + j + "]//td[7]/div","RAM");
						//-- wRAM=WebObjectUtil.GetWebElement("xpath", "//table[" + j + "]/tbody/tr[1]/td[7]/div","RAM");
						//-- vRAM=wRAM.getText();
						 
						 //commented the above line(//--) and added the below line as part of EXTJS5 change-Vivek - 10082015
						 vRAM=CustomWebElementUtil.getCellData(j, 7).trim();
						 if(vRAM.contains("GB"))
						 {
							 sSubString=vRAM.substring(0, 1);
							 //vRAMVal=Integer.parseInt(sSubString) * 512;
							int iActCnt=(Integer.parseInt(sSubString));
							 vRAMCount=vRAMCount+iActCnt ;
						 }
						 else if(vRAM.contains("MB"))
						 {
							 sSubString=vRAM.substring(0, 3);
							 if(sSubString.contains("512"))
							 {
								 vRAMCount= vRAMCount + 0.5;
								 
							 }
							 else if(sSubString.contains("256"))
							 {
								 vRAMCount= vRAMCount + 0.25;						 
							 }
							 else if(sSubString.contains("128"))
							 {
								 vRAMCount= vRAMCount + 0.13;						 
							 }
						 }
						 
						}
				 	}
				 
					//@@@@@@@@@@@@@@@@@@@@@@@@
				 
				}
			 
			 int iCPUCnt=Integer.parseInt(sCPUCount);
			 System.out.println("sCPUCount "+ sCPUCount + ", sRAMCount " +sRAMCount);
			 double dRAMCnt=Double.parseDouble(sRAMCount);
			 double roundOffvRAM = Math.round(vRAMCount * 100.0) / 100.0;
			 WebObjectUtil.explicitWait(5);
			 //System.out.println(roundOff);
			 if(iCPUCnt==vCPUCount)
			 {
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Powered On and CPU count @ Landing Page are equal "    , "pass","Expected Count = "+ sCPUCount + "Actual Count = "+iCPUCnt ) ;
				LoggerUtil.log_type_info("Expected Count = "+ sCPUCount + "Actual Count = "+iCPUCnt );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Powered On and CPU count @ Landing Page are not equal"   , "fail", "Expected Count = "+ sCPUCount + "Actual Count = "+iCPUCnt );
				LoggerUtil.log_type_error("Expected Count = "+ vCPUCount + "Actual Count = "+ iCPUCnt  );
			 }
			 
			 if(dRAMCnt==roundOffvRAM)
			 {
				 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Powered On and RAM count @ Landing Page are equal "    , "pass","Expected Count = "+ dRAMCnt + "Actual Count = "+roundOffvRAM ) ;
				LoggerUtil.log_type_info("Expected Count = "+ dRAMCnt + "Actual Count = "+roundOffvRAM );
				}
				else
				{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Powered On and RAM count @ Landing Page are not equal"   , "fail", "Expected Count = "+ dRAMCnt + "Actual Count = "+roundOffvRAM);
				LoggerUtil.log_type_error("Expected Count = "+ dRAMCnt + "Actual Count = "+roundOffvRAM);
			 }
			// System.out.println("vRAM =" + vRAMCount );
			// System.out.println("vCPUCount =" +vCPUCount);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	/*====================================================================================================
	Method Name 	: verifyCSData
	Description		: Verifying CPU And Memory allocation Data Present under Computer Statistics
	Author 			: SLP
	Creation Date 	: 08/04/2015
	Pre-Requisites	:
	Revision History:
	=====================================================================================================*/
		   
	public static void VerifyCSData()
	{
	     String sTooltipMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.STATISTIC.TOOLTIP");
	     String sDownloadSubMenuPNG = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.STATISTIC.DOWNLOAD.PNG");
	     String sDownloadSubMenJPEG = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.STATISTIC.DOWNLOAD.JPEG");
	     String sDownloadSubMenPDF = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.STATISTIC.DOWNLOAD.PDF");
	     String sDownloadSubMenSVG = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.STATISTIC.DOWNLOAD.SVG");
	     String sDownloadSubMenCSV = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.STATISTIC.DOWNLOAD.CSV");
	     String sDownloadSubMenXLS= (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.STATISTIC.DOWNLOAD.XLS");

	try {
		    WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname() );
		    WebObjectUtil.explicitWait(20);
			
		    WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getCS_CpuAllocationGraph());
		    WebObjectUtil.MouseHover(EVDC_OverviewPF.getCS_CpuAllocationGraph());		
		    WebObjectUtil.getToolTipsMsg(EVDC_OverviewPF.getCS_CpuAllocationGraph(), sTooltipMsg);
		
		
		    WebObjectUtil.clickElement(EVDC_OverviewPF.getCS_CpuAllocationMenu());
		
		    WebObjectUtil.VerifyTextUnderElement(EVDC_OverviewPF.getCS_CpuChartMenuData(), sDownloadSubMenuPNG);
		    WebObjectUtil.VerifyTextUnderElement(EVDC_OverviewPF.getCS_CpuChartMenuData(), sDownloadSubMenJPEG);
		    WebObjectUtil.VerifyTextUnderElement(EVDC_OverviewPF.getCS_CpuChartMenuData(), sDownloadSubMenPDF);
		    WebObjectUtil.VerifyTextUnderElement(EVDC_OverviewPF.getCS_CpuChartMenuData(), sDownloadSubMenSVG);
		    WebObjectUtil.VerifyTextUnderElement(EVDC_OverviewPF.getCS_CpuChartMenuData(), sDownloadSubMenCSV);
		    WebObjectUtil.VerifyTextUnderElement(EVDC_OverviewPF.getCS_CpuChartMenuData(), sDownloadSubMenXLS);
		

		
		    WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getCS_MemoryAllocationGraph());
		    WebObjectUtil.MouseHover(EVDC_OverviewPF.getCS_MemoryAllocationGraph());		
		    WebObjectUtil.getToolTipsMsg(EVDC_OverviewPF.getCS_MemoryAllocationGraph(), sTooltipMsg);
		
		
		    WebObjectUtil.clickElement(EVDC_OverviewPF.getCS_MemoryAllocationMenu());
		
		    WebObjectUtil.VerifyTextUnderElement(EVDC_OverviewPF.getCS_MemoryChartMenuData(), sDownloadSubMenuPNG);
		    WebObjectUtil.VerifyTextUnderElement(EVDC_OverviewPF.getCS_MemoryChartMenuData(), sDownloadSubMenJPEG);
		    WebObjectUtil.VerifyTextUnderElement(EVDC_OverviewPF.getCS_MemoryChartMenuData(), sDownloadSubMenPDF);
		    WebObjectUtil.VerifyTextUnderElement(EVDC_OverviewPF.getCS_MemoryChartMenuData(), sDownloadSubMenSVG);
		    WebObjectUtil.VerifyTextUnderElement(EVDC_OverviewPF.getCS_MemoryChartMenuData(), sDownloadSubMenCSV);
		    WebObjectUtil.VerifyTextUnderElement(EVDC_OverviewPF.getCS_MemoryChartMenuData(), sDownloadSubMenXLS);
	} catch (Exception e) {
		LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VerifyCSData", "warn", "catch block:Could NOT access webelement" +e.getMessage());
	}


	}

	 //___________________________ Gideon TestCases ________________________________________/// 
	
	/*==============================================================
	TestScript  	: navValPrivateCldOverviewPg
	Manual TestCase	: CPPOC-3073-Private Cloud_EVDC Overview page
	Description		: Verify Private cloud overview page
	Author 			: Vivek Kumar
	Creation Date 	: 09/01/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=28)
	public void navValPrivateCldOverviewPg()
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		
		PageFactory.initElements(driver, EVDC_VMPF);
		PageFactory.initElements(driver, EVDC_OverviewPF);
		PageFactory.initElements(driver, Smoke);
		
		
		String sUserName,sPassword,sExpectedOrgName,sActualOrgName;
		boolean bStatus;
				
		FrameworkUtil.sTestCaseName = "Gideon-navValPrivateCldOverviewPg";
		FrameworkUtil.sManualTestCaseName="CPPOC-3073-Private Cloud_EVDC Overview page";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		
		sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
		sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
				
		//Login
		//LoginTestCase.nav_Login(sUserName, sPassword);
		LoginTestCase_Old1.LoginAsGirUser();
		
		WebElement wPrivate=getFirstPrivateCloud();
		sExpectedOrgName=wPrivate.getText();
		wPrivate.click();
		//Navigating to overview page and getting list of Organization
		//WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
		
		//Verifying Portlets VM,Catalogs,Computer Statistics,Storage,Cloud AV,Firewall, Feedback, Networks and Bandwidth
		WebObjectUtil.verifyElementPresent(Smoke.getNav_VMportlet());
		WebObjectUtil.verifyElementPresent(Smoke.getNav_ComputeStatisticsportlet());
		WebObjectUtil.verifyElementPresent(Smoke.getNav_Catalogsportlet());
		WebObjectUtil.verifyElementPresent(Smoke.getNav_CloudAvportlet());
		WebObjectUtil.verifyElementPresent(Smoke.getNav_Storageportlet());
		WebObjectUtil.verifyElementPresent(Smoke.getNav_Firewallportlet());
		WebObjectUtil.verifyElementPresent(Smoke.getNav_Feedbackportlet());
		WebObjectUtil.verifyElementPresent(Smoke.getNav_Networksportlet());
		//This below line updated on 10/08/2015 for EXTJS5 by QAA03
		//WebObjectUtil.verifyElementPresent(Smoke.getNav_BandwidthPortlet());
		WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_BandwidthPortlet());
		//Need to verify Selector
		WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCOrgSelector());
		sActualOrgName=EVDC_OverviewPF.getNav_EVDCOrgSelector().getText();
		
		bStatus=sExpectedOrgName.equalsIgnoreCase(sActualOrgName);
		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Verifying Organization : Expected = "+ sExpectedOrgName+ " Actual= "+sActualOrgName);
		
		//Verifying breadcrumb link
		WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_HomeBreadCrumb());
		WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_EVDCBreadCrumb());
		
		//Logout
		LoginTestCase_Old1.nav_Logout();
		
	}
	
	
	/*==============================================================
	TestScript  	: navValPrivateCldNmingConvention
	Manual TestCase	: CPPOC-3078-Private Cloud_Naming convention & Multiple Cloud Identifiers
	Description		: Verify Private cloud naming convention
	Author 			: Vivek Kumar
	Creation Date 	: 08/31/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=27)
	public void navValPrivateCldNmingConvention()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		
		PageFactory.initElements(driver, EVDC_OverviewPF);
		PageFactory.initElements(driver, EVDC_VMPF);
		PageFactory.initElements(driver, Home);
		String sUserName,sPassword,sActualOrgName,sExpectedOrgName,sCloudFormat;
		WebElement wOrgName;
		String[] sArray;
		
		
	
		
		FrameworkUtil.sTestCaseName = "Gideon-navValPrivateCldNmingConvention";
		FrameworkUtil.sManualTestCaseName="CPPOC-3078-Private Cloud_Naming convention & Multiple Cloud Identifiers";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		
		sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
		sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
		sCloudFormat=(String) FrameworkUtil.dictPropertyData.get("NAV.GIDEON.PRIVATE.CLOUD.FORMAT");
		
		//Login
		//LoginTestCase.nav_Login(sUserName, sPassword);
		
		LoginTestCase_Old1.LoginAsGirUser();
		//Navigating to overview page and getting list of Organization
		WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
		WebObjectUtil.clickElement(EVDC_VMPF.getNav_EVDCSelectorDrpdwnArrow());
		String sOrgList=WebObjectUtil.getCustomWebListAllItemsAsText(EVDC_VMPF.getNav_EVDCSelectorList());
		//Going back to home page
		WebObjectUtil.ClickAndMouseHover(Home.getNav_MonitoringTab());
		WebObjectUtil.clickElement(Home.getNav_SummaryViewMenuLink());
		
		
		//Verifying Private Cloud organization format
		sArray=sOrgList.split("##");
		//System.out.println(sArray.length);
		for(int i=0;i<sArray.length;i++)
		{
			sExpectedOrgName=sArray[i];
			//wOrgName=WebObjectUtil.GetWebElement("xpath", "//h2[@id='edvc_1']/a[text()='"+sExpectedOrgName+"']", "Verifying " +sExpectedOrgName);
			  // This object is updated on 10/15/2015 By QAA04
			wOrgName = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.ORGNAME", "PARAMETER_ORGNAME", sExpectedOrgName );
			sActualOrgName=wOrgName.getText();
			if(sExpectedOrgName.equalsIgnoreCase(sActualOrgName) && sActualOrgName.startsWith(sCloudFormat))		
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Private Cloud", "Private Cloud org", "pass", "Private Cloud org - "+sActualOrgName);
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Private Cloud", "Private Cloud org", "warn", "not Private Cloud org  - "+sActualOrgName);
			}
		}

		//Logout
		LoginTestCase_Old1.nav_Logout();
	}
	
	/*==============================================================
	TestScript  	: navValCldMigrationNotPresent
	Manual TestCase	: CPPOC-3080-Private Cloud page_Migration Portlet display
	Description		: Verify cloud migration is not present
	Author 			: Vivek Kumar
	Creation Date 	: 08/31/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=25)
	public void navValCldMigrationNotPresent()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_VMPF);
		PageFactory.initElements(driver, EVDC_OverviewPF);
		PageFactory.initElements(driver, Home);
		
		boolean bStatus;
	
		
		FrameworkUtil.sTestCaseName = "Gideon-navValCldMigrationNotPresent";
		FrameworkUtil.sManualTestCaseName="CPPOC-3080-Private Cloud page_Migration Portlet display";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		String sUserName,sPassword;
		
		sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
		sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
		
		try {
			//.nav_Login(sUserName, sPassword);
			LoginTestCase_Old1.LoginAsGirUser();
			//Clicking on Private Cloud EVDC link and verifying its landing page
			WebElement wPrivate=getFirstPrivateCloud();
			wPrivate.click();
			
			//Verifying Cloud Migration is not present for Private Cloud
			bStatus=WebObjectUtil.isElementPresent(Home.getNav_CloudMigrationMenuLink());
			FrameworkUtil.updateCustomResultBasedOnStatus(!bStatus, "Cloud Migration should not be there for private cloud");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Logging out from Navigator application
		LoginTestCase_Old1.nav_Logout();
				
		
	}
	
	
//// Methods
	public static WebElement getFirstPrivateCloud()
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_VMPF);
		PageFactory.initElements(driver, EVDC_OverviewPF);
		
		
		
		String sCloudFormat,sPrivateCldName;
		WebElement wOrgName = null;
		boolean flag=false;
		
		sCloudFormat=(String) FrameworkUtil.dictPropertyData.get("NAV.GIDEON.PRIVATE.CLOUD.FORMAT");
		
		List<WebElement> OrgList=driver.findElements(By.xpath("//h2[@id='edvc_1']/a"));
		for(WebElement wb : OrgList)
		{
			wOrgName=wb;
			sPrivateCldName=wb.getText();
			if(sPrivateCldName.startsWith(sCloudFormat))		
			{
				flag=true;
			//	wOrgName = WebObjectUtil.GetWebElement("xpath", "//h2[@id='edvc_1']//a[text()='"+ sPrivateCldName +"']", "FirstPrivateCloudLink");
				   // This object is updated on 10/15/2015 By QAA04
				wOrgName = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.ORGNAME", "PARAMETER_ORGNAME", sPrivateCldName +"");
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Private Cloud", "Get Private Cloud Element", "done", "Private cloud portlet name - " + sPrivateCldName);
				return wOrgName;
				
			}
		}
		
		if(!flag)
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Private Cloud", "Get Private Cloud Element", "fail", "Private cloud portlet not available");
		}
		return wOrgName;
	}
	
	
	
	
	
	/*==============================================================
	TestScript  	: navValVCloudPg
	Manual TestCase	: CPPOC-3072-Verify that user is prompted to enter login and pwd when navigated to VCD from Cloud Services on WCP
					  CPPOC-3050-Verify that user is taken to their own private VCD page if they have a private VCD.
	Description		: Verify VCD page and its URL
	Author 			: Vivek Kumar
	Creation Date 	: 09/01/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=29)
	public void navValVCloudPg()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		
		PageFactory.initElements(driver, EVDC_OverviewPF);
		PageFactory.initElements(driver, Home);
		PageFactory.initElements(driver, Smoke);
		
		
		String sUserName,sPassword,sVCloudUrl;
	
				
		FrameworkUtil.sTestCaseName = "Gideon-navValVCloudPg";
		FrameworkUtil.sManualTestCaseName="CPPOC-3072-Private Cloud_EVDC Overview page";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		
		sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.TSTDEVCO1.TSTMAX02LASTT.USERID");
		sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.TSTDEVCO1.TSTMAX02LASTT.PASSWORD");
		sVCloudUrl=(String) FrameworkUtil.dictPropertyData.get("NAV.GIDEON.VCLOUD.URL");
		
		//Login
		//LoginTestCase.nav_Login(sUserName, sPassword);
		LoginTestCase_Old1.LoginAsTstMax02lasttUser();
		//Verifying VCloud login and its URL
		verifyVCloudDirectorLoginPage(sVCloudUrl);
	
		//Logout
		LoginTestCase_Old1.nav_Logout();
		
	}
	
	
	/*==============================================================
	Method Name       : verifyVCloudDirectorLoginPage
	Description       : to verify VCloud login and its Url
	Author            : Arul
	Creation Date     : 09/01/2015
	Pre-Requisites    :
	Revision History:
	==============================================================*/

	public static void verifyVCloudDirectorLoginPage(String sVCloudURL){
		
		String ParentWindowName,sEVDCName,sEVDCOrg;
		String[] arrEVDC;
		boolean bStatus;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Smoke);
		PageFactory.initElements(driver, EVDC_OverviewPF);
		
		try {
			/*FrameworkUtil.sTestCaseName = "verifyVCloudDirectorLoginPage";
			FrameworkUtil.sManualTestCaseName="SmokeTest-Verify vCloud Director login Page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			*/
			//	WebDriverUtil.getDriver().get(sSummaryURL);
			//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			//Getting the EVDC name for which vcloud should click
			sEVDCName=EVDC_OverviewPF.getNav_EVDCname().getText();
			arrEVDC=sEVDCName.split("-");
			sEVDCOrg=arrEVDC[arrEVDC.length-1].trim().toLowerCase();
			//Appending the sEVDCOrg with vCloud url
			sVCloudURL=sVCloudURL+sEVDCOrg+"/";
			
			WebObjectUtil.clickElement(Smoke.getNav_vCloudDirectorLink());
			
			ParentWindowName = driver.getWindowHandle();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebObjectUtil.explicitWait(20);
			WebObjectUtil.switchToWindow(2, null);
			//WebObjectUtil.switchToWindow(0, "VMware vCloud Director");
			
			bStatus=WebObjectUtil.compareString(driver.getTitle(), (String)FrameworkUtil.dictPropertyData.get("NAV.CLOUD.WINDOW.TITLE"), true);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying VCloud title");
			bStatus=WebObjectUtil.compareString(driver.getCurrentUrl(), sVCloudURL, true);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying VCloud url");
			//close the second window
			if (!driver.getWindowHandle().equalsIgnoreCase(ParentWindowName)){
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.close();
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Close Window", "done", "Close the new window");
			}
			driver.switchTo().window(ParentWindowName);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		
	}


	//// methods 
	public static void verifyStorageTierDetails(int iIndex){
		boolean sFlag = true;
		int iStorageElementCount,idx;
		String sAllocated,sCommited,sTierName,sAllocatedGraph,sCommitedGraph,sInfoIcon,sInfoIconText;
		WebElement wAllocated,wCommited,wTierName,wAllocatedGraph,wCommitedGraph,wInfoIcon,wInfoIconText;

		
		WebDriver driver = WebDriverUtil.getDriver();
		
		idx = iIndex;
		try {
/*
				sAllocated ="//*[@id='storage-chart-svg-" + idx + "']/*[name()='text'][1]";
				sCommited ="//*[@id='storage-chart-svg-" + idx + "']/*[name()='text'][2]";
				sAllocatedGraph ="//*[@id='storage-chart-svg-" + idx + "']/*[name()='rect'][1]";
				sCommitedGraph ="//*[@id='storage-chart-svg-" + idx + "']/*[name()='rect'][2]";
				//sTierName ="//div[@id='storage-chart-" + idx + "']//div[@class='spname']";
				sTierName ="//div[@id='storage-chart-" + idx + "']/div";*/
				/*if(idx==1)
				{
					sAllocated ="//li[3]//*[@id='storage-chart-svg-" + idx + "']/*[name()='text'][1]";
					sTierName ="//li[3]//div[@id='storage-chart-" + idx + "']/div";
				}
	*/
			/*	wAllocated = WebObjectUtil.GetWebElement("xpath", sAllocated, "sAllocated");
				wCommited = WebObjectUtil.GetWebElement("xpath", sCommited, "sCommited");
				wCommitedGraph = WebObjectUtil.GetWebElement("xpath", sCommitedGraph, "sCommitedGraph");
				wAllocatedGraph = WebObjectUtil.GetWebElement("xpath", sAllocatedGraph, "sAllocatedGraph");
				wTierName = WebObjectUtil.GetWebElement("xpath", sTierName, "sTierName");
*/
				  // This object is updated on 10/15/2015 By QAA04
				wAllocated = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.STORAGEPROFILE.ALLOCATED", "PARAMETER_INDEX", idx+"");
				wCommited = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.STORAGEPROFILE.COMMITED", "PARAMETER_INDEX", idx+"");
				wCommitedGraph = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.STORAGEPROFILE.COMMITEDGRAPH", "PARAMETER_INDEX", idx+"");
				wAllocatedGraph = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.STORAGEPROFILE.ALLOCATEDGRAPH", "PARAMETER_INDEX", idx+"");
				wTierName = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.STORAGEPROFILE.TIERNAME", "PARAMETER_INDEX", idx+"");
				try {
					verifyStorageElement(wTierName,"sTierName",true);
					verifyStorageElement(wAllocated,"sAllocated",true);
					verifyStorageElement(wCommited,"sCommited",false);
					if(wAllocatedGraph==null ){
						
						
						verifyStorageElement(wAllocatedGraph,"sAllocatedGraph",false);
					}
					else
					{
						verifyStorageElement(wAllocatedGraph,"sAllocatedGraph",true);
					}
					
					verifyStorageElement(wCommitedGraph,"sCommitedGraph",false);

				
				} catch (Exception e) {
					LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
				}
				
				

		} catch (Exception e) {
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
		}
	  
	}
	
	public static boolean verifyStorageElement(WebElement wStorageElement, String sStorageElementName,boolean bFailTestCase){
		boolean bStatus = false;
		
		//bStatus = WebObjectUtil.isElementPresent(wStorageElement);
		if (wStorageElement != null && WebObjectUtil.isElementPresent(wStorageElement) ){
			bStatus = WebObjectUtil.isElementPresent(wStorageElement);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), sStorageElementName , sStorageElementName, "pass", wStorageElement.getText() );
		}else{
			if (bFailTestCase)
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), sStorageElementName, sStorageElementName, "fail", "Element not present:" + sStorageElementName );
			else
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), sStorageElementName, sStorageElementName, "warn", "issue with Identifying element" + sStorageElementName );	
		}
	return bStatus;
	}
	
	/*==============================================================
	TestScript 		: nav_VerifyCloudAvPage
	Manual TestCase	: click on Security on menu bar and select Cloud AV
	Description		: verify The Title in Cloud AV page with Tstmax user
	Author 			: QAA04
	Creation Date 	: 08/26/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	//@Test(priority=11)
	 public void nav_VerifyCloudAvPage(){
		      
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Home);
		PageFactory.initElements(driver,EVDC_OverviewPF);
		PageFactory.initElements(driver, DRaaS);
		try {
			
		
		FrameworkUtil.sTestCaseName="nav_VerifyCloudAvPage";
		FrameworkUtil.sManualTestCaseName="(CPPOC-3349)click on Security on menu bar and select Cloud AV";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
	    String sUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.TSTMAX02.USERID");
	    String sPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.TSTMAX02.PASSWORD");
		LoginTestCase_Old1.nav_Login(sUserName, sPassword);
		
		
		WebObjectUtil.clickElement(Home.getNav_SecurityTab());
		WebObjectUtil.clickElement(Home.getNav_CloudAVMenuLink());
		WebObjectUtil.VerifyTextUnderElement(DRaaS.getNav_breadCrumbChain(), "Cloud AV");
		WebObjectUtil.explicitWait(5);
		WebObjectUtil.VerifyTextUnderElement(EVDC_OverviewPF.getNav_CloudAVPageTitle(), "Cloud Services - Anti-Virus / Anti-Malware");
		
		LoginTestCase_Old1.nav_Logout();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
	         	LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
	}
	 
	 //___________________________ Completed Gideon TestCases ________________________________________///
     //___________________________ Hague test cases __________________________________________________ ///
	 
	 /*==============================================================
	   	TestScript 		: VerifyEVDC_OverViewPage
	   	Manual TestCase	: QAT-236
	   	Description		: Verifying the EVDC_Overview page
	   	Author 			: QAA04
	   	Creation Date 	: 12/1/2015
	   	release Name    : Hague
	   	Pre-Requisites	:
	   	Revision History:
	   	
	   	==============================================================*/
	    @Test(priority=3)
	    public void VerifyEVDC_OverViewPage() {
	    	String sTestCaseName,sManualTestCaseName;
	    	WebDriver driver = WebDriverUtil.getDriver();
	    	try {
	    	PageFactory.initElements(driver, EVDC_OverviewPF);
	    	PageFactory.initElements(driver, EVDC_VMPF);
	    	
	    	  FrameworkUtil.sTestCaseName ="VerifyEVDC_OverViewPage";
	    	 FrameworkUtil.sManualTestCaseName ="(QAT-236)Hague-Verifying verifying the EVDC_Overview Page";
	    	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	    	// login to the navigator
	    	LoginTestCase_Old1.LoginAsSravuriUser();
	    	//Clicking on EVDC Name and validating its landing page
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_EVDCBreadCrumb());
			String sBreadCrumb = EVDC_VMPF.getNav_EVDCBreadCrumb().getText();
			//String sBreadCrumb = EVDC_Storage.getNav_breadCrumbChain().getText();
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(),FrameworkUtil.sElementName , "Verifying EVDC Overview the bread crumb chain", "pass", "EVDC Overview page bread crumb is - " + sBreadCrumb );
	    
			LoginTestCase_Old1.nav_Logout();
	    	}
	    	catch(Exception e) {
	    		LoggerUtil.log_type_error("issue with VerifyEVDC_OverViewPage test case");
	    		LoggerUtil.log_type_error(e.getMessage());
	    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception occured", "fail", e.getMessage()+"null");
	    	}
	    	}
	 
	 ///////////////////////////////// Methods //////////////////////////////////////
	 
	     
	    
	    
	/// ___________________ Completed Hague test cases ______________________________ ////
	    
	 //$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$PRIYANKA$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	 /*
		
		==============================================================
		TestScript  	: VerifyLoadBalPortlet()
		Manual TestCase	: Verify the Load Balancer portlet display on EVDC over view page		
		Description		: Verify the Load Balancer portlet display on EVDC over view page
		Author 			: Priyanka R
		Creation Date 	: 12/01/2015
		Release         : Hague
		Pre-Requisites	:
		Revision History:
		==============================================================
		@Test(priority=29)
		public void VerifyLoadBalPortlet()
		{
			WebDriver driver = WebDriverUtil.getDriver();
			
			PageFactory.initElements(driver, EVDC_OverviewPF);
			PageFactory.initElements(driver, Home);
			PageFactory.initElements(driver, Smoke);
			
			try {
			String sUserName,sPassword,sVCloudUrl;
		
					
			FrameworkUtil.sTestCaseName = "Hague-VerifyLoadBalPortlet";
			FrameworkUtil.sManualTestCaseName="Verify the Load Balancer portlet display on EVDC over view page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

			
			sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.HAUGE.HAWKEYE.USERID");
			sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.HAGUE.HAWKEYE.PASSWORD");
			
			
			//Login
			LoginTestCase.nav_Login(sUserName, sPassword);
			
			WebObjectUtil.clickElement(Home.getNav_HomeEVDCPortlet());
			WebObjectUtil.explicitWait(10);
			WebObjectUtil.waitForElementPresent(EVDC_OverviewPF.getNav_EVDCLoadBalancerPortlet());
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCLBInstances());
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCLBVips());
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCLBPools());
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCLBMembers());
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCLBInstancesVal());
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCLBVipsVal());
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCLBPoolsVal());
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCLBMembersVal());
		    WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCLBLink());
		    WebObjectUtil.explicitWait(10);
			//Logout
			LoginTestCase.nav_Logout();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
		         	LoggerUtil.log_type_error( "Issue With-VerifyLoadBalPortlet" +  e.getMessage());
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
			}
		
		}
	 
		==============================================================
		TestScript  	: VerifyLoadBalAddVIP()
		Manual TestCase	: Verify the Add VIP under Virtual IP in Load Balancer.		
		Description		: Verify the Add VIP under Virtual IP in Load Balancer.
		Author 			: Priyanka R
		Creation Date 	: 12/01/2015
		Release         : Hague
		Pre-Requisites	:
		Revision History:
		==============================================================
		@Test(priority=29)
		public void VerifyLoadBalAddVIP()
		{
			WebDriver driver = WebDriverUtil.getDriver();
			
			PageFactory.initElements(driver, EVDC_OverviewPF);
			PageFactory.initElements(driver, Ticket);
			PageFactory.initElements(driver, Home);
			
			try {
			String sUserName,sPassword;
			FrameworkUtil.sTestCaseName = "Hague-VerifLoadBalPortlet";
			FrameworkUtil.sManualTestCaseName="Verify the Load Balancer portlet display on EVDC over view page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

			
			sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.HAUGE.HAWKEYE.USERID");
			sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.HAGUE.HAWKEYE.PASSWORD");
			
			
			//Login
			LoginTestCase.nav_Login(sUserName, sPassword);
			
			VerifyAddAndSearchVIPTicket();

		    LoginTestCase.nav_Logout();
			
		}
			catch (Exception e) {
				// TODO Auto-generated catch block
		         	LoggerUtil.log_type_error( "Issue With-VerifyLoadBalAddVIP" +  e.getMessage());
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
			}
		
		}
		==============================================================
		TestScript  	: VerifyLoadBalAddVIPTicketDetails()
		Manual TestCase	: Verify the Add VIP under Virtual IP in Load Balancer.		
		Description		: Verify the Add VIP under Virtual IP in Load Balancer.
		Author 			: Priyanka R
		Creation Date 	: 12/01/2015
		Release         : Hague
		Pre-Requisites	:
		Revision History:
		==============================================================
		@Test(priority=29)
		public void VerifyLoadBalAddVIPTicketDetails()
		{
			WebDriver driver = WebDriverUtil.getDriver();
			
			PageFactory.initElements(driver, EVDC_OverviewPF);
			PageFactory.initElements(driver, Ticket);
			PageFactory.initElements(driver, Home);
			
			try {
			String sUserName,sPassword;
			FrameworkUtil.sTestCaseName = "Hague-VerifLoadBalPortlet";
			FrameworkUtil.sManualTestCaseName="Verify the Load Balancer portlet display on EVDC over view page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

			
			sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.HAUGE.HAWKEYE.USERID");
			sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.HAGUE.HAWKEYE.PASSWORD");
			
			
			//Login
			LoginTestCase.nav_Login(sUserName, sPassword);
			
			VerifyAddAndSearchVIPTicket();
			

		    LoginTestCase.nav_Logout();
			
		}
			catch (Exception e) {
				// TODO Auto-generated catch block
		         	LoggerUtil.log_type_error( "Issue With-VerifyLoadBalAddVIP" +  e.getMessage());
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
			}
		
		}
		==============================================================
		Method Name 	: VerifyAddAndSearchVIPTicket
		Description		: This will validate the CPU n RAm count
		Author 			: Priyanka R
		Creation Date 	: 12/3/15
		Pre-Requisites	:
		Release         : Hague
		Revision History:
		==============================================================	
		
	public static void VerifyAddAndSearchVIPTicket()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);
		PageFactory.initElements(driver, Ticket);
		PageFactory.initElements(driver, Home);
		
		try{
			String sSummary,sText;
			sSummary  = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.SUMMARY.SEARCH");
			sText = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.VIP.TICKET.SUCCESS.MSG");
			WebObjectUtil.clickElement(Home.getNav_HomeEVDCPortlet());
			WebObjectUtil.explicitWait(10);
		    WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCLBLink());
		    WebObjectUtil.explicitWait(10);
			WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_VirtualIPTab());
			WebObjectUtil.explicitWait(5);
			WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_LoadBalAddVIP());
			WebObjectUtil.explicitWait(5);
			WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_AddVirtualIPPopUp());
			WebObjectUtil.SetValueEdit(EVDC_OverviewPF.getNav_AddVirtualIPPopUp(), "UserTestText");
		    WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_AddVirtualIPPopUpOkBtn());
		    WebObjectUtil.waitForElementPresent(Common.getNav_CommonPopUp());
		    WebObjectUtil.VerifyTextUnderElement(Common.getNav_CommonPopUpMessage(), sText);
		    WebObjectUtil.clickElement(Common.getNav_CommonPopUpOKButton());
		    TicketTestCase.navigateToTicketPage();
		    WebObjectUtil.explicitWait(10);
		    TicketTestCase.searchTicket("Summary", sSummary);
		    WebObjectUtil.explicitWait(10);
		    TicketTestCase.SearcResultFound("Summary",3, sSummary);
		   
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
	         	LoggerUtil.log_type_error( "Issue with-VerifyAddAndSearchVIPTicket" +  e.getMessage());
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
	
	}
	
	
*/
	    
	///// _____________________ Corwin test cases _______________________________ ////
		
		 /*==============================================================
	   	TestScript 		: verifyMoreTextInFirewallPortlet
	   	Manual TestCase	: QAT-1340
	   	Description		: verify the firewall portlet values
	   	Author 			: QAA04
	   	Creation Date 	: 06/29/2015
	   	release Name    : Corwin
	   	Pre-Requisites	:
	   	Revision History:
	   	==============================================================*/
	    @Test(priority=12)
	    public void verifyMoreTextInFirewallPortlet(){
	    	
	    	WebDriver driver = WebDriverUtil.getDriver();
	    	PageFactory.initElements(driver, EVDC_FirewallPF);
	    	PageFactory.initElements(driver, Home);
	    	PageFactory.initElements(driver, EVDC_OverviewPF);
	    	try{
	    	FrameworkUtil.sTestCaseName="verifyMoreTextInFirewallPortlet";
	    	FrameworkUtil.sManualTestCaseName="(QAT-1340) Corwin - verify the firewall portlet values";
	    	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	    	
	    	// login to the navigator
	    	LoginTestCase_Old1.LoginAsQaautoAUser();
	    	
	    	WebObjectUtil.scrollElementAtPageCenter(EVDC_OverviewPF.getNav_EVDCname());
	    	WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
	    	
	    	
	    	WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_FirewallMoreText());
	    
	    	 WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_FirewallRulesText());
	         WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_FirewallRulesCount());
	         WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_FirewallVPNTunnelsText());
	         WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_FirewallVPNTunnelsCount());
	         WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_FirewallVPNUsersText());
	         WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_FirewallVPNUsersCount());
	         WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_FirewallNATSText());
	         WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_FirewallNATSCount());
	         WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_FirewallOutsideIpText());
	         WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_FirewallRulesCount());
	         WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_FirewallInsideIpText());
	         WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_FirewallInsideIpCount());
	      // log out
	      			LoginTestCase_Old1.nav_Logout();
	      		} catch (Exception e) {
	      			LoggerUtil.log_type_error("issue with- verifyMoreTextInFirewallPortlet Test Case" );
	      	 		LoggerUtil.log_type_error(e.getMessage());
	      	 		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	      	 	}
	         
	    }
	    
	    /// _______________________ Completed corwin test cases _________________________________ ///
		
		
	    
	    
	   /*==============================================================
		Method 	: verifyTicketDetails
		Description		: Verify user is able view ticket details like "Ticket Id","Summary","Severity","Priority","Last updated","Assigned To","Status".
		Author 			: Priyanka R
		Creation Date 	: 12/13/2015
		Pre-Requisites	:
		Revision History:
	==============================================================*/
	public void verifyTicketDetails()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Ticket);
		
		try {
			int iRow=1;
			String sSeverity,sPriority,sStatus,sDate,sTicketID,sCategory,sOrgname,sNotes;
			WebElement wCategory,wOrgname,wNotes;
			sTicketID=TicketTestCase.getTicketID(iRow);
			TicketTestCase.expandTable(iRow);
			TicketTestCase.verifyCreatedTicketDate();
			CustomWebElementUtil.loadCustomElement(Ticket.getNav_TicketsWebTable(), "table");
			sSeverity=CustomWebElementUtil.getCellData(1, 4);
			sPriority=CustomWebElementUtil.getCellData(1, 5);
			sDate=CustomWebElementUtil.getCellData(1, 6);
			wCategory=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "CREATED.TICKET.CATEGORY.VALUE", "PARAMETER_ROWNUMBER", iRow+"");
			wOrgname=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "CREATED.TICKET.ORG.VALUE", "PARAMETER_ROWNUMBER", iRow+"");
			sCategory=wCategory.getText();
			sOrgname=wOrgname.getText();		
			TicketTestCase.expandNotesTable(1);
            wNotes=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "CREATED.TICKET.NOTES.TEXT", "PARAMETER_TICKETID", sTicketID);
	        sNotes=wNotes.getText();
	        
	        
	        
		} catch (Exception e) {
			LoggerUtil.log_type_error( "Issue With-VerifyTicketDetails()" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		
		}
		
	}
	/////////////////////////////////Keffer Methods/////////////////////////////////////////////////////
	
	///***********************Arul*************************************************//
	
	public static void verifyEVDCnameForEntityAndItsChild(String[] arrEVDCnameAsArray){
		String sEVDCName;
		boolean bEVDCNameStatus=false;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,EVDC_OverviewPF);
		
		
		CustomWebElementUtil.loadCustomElement(EVDC_OverviewPF.getNav_EVDCViewHomeTable(), "table");
		for (int i=1;i<=CustomWebElementUtil.iRowCount;i++){
			sEVDCName=CustomWebElementUtil.getCellData(i, 1);
			
			for (String sEVDC :arrEVDCnameAsArray ){
				//System.out.println(sEVDCName + "--" + sEVDC);
				if (sEVDCName.trim().equalsIgnoreCase(sEVDC.trim())){
					bEVDCNameStatus=true;
					break;
				}
			}
			FrameworkUtil.updateCustomResultBasedOnStatus(bEVDCNameStatus, "EVDC name on Home page After roll On " + sEVDCName);
			bEVDCNameStatus=false;
		}
	}

	public static String[] getEVDCNameforEntityAndItsChild(String sEntityName){
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,EBPanel);

		
	    String sEVDCNameRunnTime = "",sEVDCName,sCurrentEntityName,sParentName=".Hosted Solutions";
	    String[] arrEVDCEntityNameList,arrEVDCNameList,arrEVDCNameListTemp,arrEVDCNameListTempEntity;
	    
	    sCurrentEntityName = EBPanel.getNav_EntityBrowserLink().getText();
	  
	    if (sCurrentEntityName.equalsIgnoreCase("Back to your Entity")){
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		}
	    /*
	   sCurrentEntityName = EBPanel.getNav_OrgNameTitleLink().getText();
		if (!sCurrentEntityName.equalsIgnoreCase(sEntityName)){
			EntityBrowserTestCase.selectOrgFromAllLevelsEB(sEntityName,"", "", "");
		}
		sCurrentEntityName = EBPanel.getNav_OrgNameTitleLink().getText();
	*/	
	    sCurrentEntityName = EBPanel.getNav_EntityBrowserLink().getText();
	   if (sCurrentEntityName.equalsIgnoreCase(sEntityName)){
		EVDC_VM_TestCase.getEVDCNameAsWebElement(" ");
		for (WebElement wEVDC : WebObjectUtil.webElementsList)
		{
			sEVDCName = wEVDC.getText();
			sEVDCNameRunnTime = sEVDCNameRunnTime+"!EVDC!"+(sEVDCName + "!ENTITY!" + sCurrentEntityName  + "!PARENT!" + sParentName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "getEVDC Name", "done", sEVDCName +" EVDC name before roll on for entity " + sCurrentEntityName );
		}
		sParentName=sCurrentEntityName;
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			String[] arrChildEntityList = EntityBrowserTestCase.getChildOrgNameListFromEBPanel(1);
			
			for (String sChild :arrChildEntityList){
				EntityBrowserTestCase.selectOrgFromAllLevelsEB(sChild,"", "", "");
				sCurrentEntityName = EBPanel.getNav_OrgNameTitleLink().getText();
				WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
		    	WebObjectUtil.explicitWait(5); 
				EVDC_VM_TestCase.getEVDCNameAsWebElement(" ");
				for (WebElement wEVDC : WebObjectUtil.webElementsList)
				{
					sEVDCName = wEVDC.getText();
					sEVDCNameRunnTime = sEVDCNameRunnTime+"!EVDC!"+(sEVDCName + "!ENTITY!" + sCurrentEntityName+ "!PARENT!" + sParentName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "getEVDC Name", "done", sEVDCName +" EVDC name before roll on for entity " + sCurrentEntityName );
					
				}
				WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
				WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
				WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
				sParentName=sCurrentEntityName;
			}
	   }else{
		   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "getEVDC Name", "warn", "Could not access " + sEntityName + ", pls check your inputs"); 
	   }	
	   
	   sCurrentEntityName = EBPanel.getNav_EntityBrowserLink().getText();
	  
	     if (sCurrentEntityName.equalsIgnoreCase("Back to your Entity")){
			WebObjectUtil.clickElement(EBPanel.getNav_CloseButton());
			}
	   
		arrEVDCEntityNameList =sEVDCNameRunnTime.split("!EVDC!");
		arrEVDCNameList = new String[arrEVDCEntityNameList.length-1];
		arrEVDCNameListAsArray = new String[arrEVDCEntityNameList.length-1];
		arrEntityNameListAsArray = new String[arrEVDCEntityNameList.length-1];
		arrParentEntityNameListAsArray = new String[arrEVDCEntityNameList.length-1];
		for (int e=1;e<=arrEVDCNameList.length;e++ ){
			arrEVDCNameListTemp = arrEVDCEntityNameList[e].split("!ENTITY!");
			arrEVDCNameList[e-1]=arrEVDCNameListTemp[0];
			arrEVDCNameListAsArray[e-1]=arrEVDCNameListTemp[0];
			arrEVDCNameListTempEntity = arrEVDCNameListTemp[1].split("!PARENT!");
			arrEntityNameListAsArray[e-1]=arrEVDCNameListTempEntity[0];
			arrParentEntityNameListAsArray[e-1]=arrEVDCNameListTempEntity[1];
		}
		
	   return arrEVDCNameList;
	}
public static boolean VerifyEVDCNameSearchAfterRollOn(String sSearchText){
		
		String sOrgNameRunTime;
		String[] sOrgName;
		boolean bSearchStatus=false;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);

	    try {
			//Verify Search box
			if (WebObjectUtil.isElementPresent(EVDC_OverviewPF.getNav_EVDCViewSearchEdit())){
			sOrgName = sSearchText.split(" ");
			WebObjectUtil.SetValueEdit(EVDC_OverviewPF.getNav_EVDCViewSearchEdit(), sOrgName[sOrgName.length-1]);
			WebObjectUtil.explicitWait(10);
			CustomWebElementUtil.loadCustomElement(EVDC_OverviewPF.getNav_EVDCViewHomeTable(), "table");
			sOrgNameRunTime = CustomWebElementUtil.getCellData(1, 1);
			sOrgNameRunTime = sOrgNameRunTime.toLowerCase();
			bSearchStatus=sOrgNameRunTime.contains(sOrgName[sOrgName.length-1]);
			FrameworkUtil.updateCustomResultBasedOnStatus(bSearchStatus, "Search EVDC name after roll ON, search result found:" + sOrgNameRunTime + ", and search text:" + sOrgName[sOrgName.length-1]);
			}else{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verify EVDC name seach", "warn", "EVDC Search field is not available, check where Roll up flag is ON" );
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return bSearchStatus;
	}

/////*******************************vivek*****************************//////
	
	
	/*====================================================================================================
	Method Name 	: verifyEVDCViewPagination
	Description		: it will verify the pagination
	Author 			: Vivek Kumar
	Creation Date 	: 01/05/2016
	Pre-Requisites	:
	Revision History:
	=====================================================================================================*/
	public static void verifyEVDCViewPagination()
	{
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);
				
		String sTotalPageNumber,sFrstPgEVDC,sSecondPgEVDC;
		int iRowCnt,iTotalPageNumber;
		
		try {
			//Loading the EVDC View table
			CustomWebElementUtil.loadCustomElement(EVDC_OverviewPF.getNav_EVDCViewHomeTable(), "table");
			iRowCnt=CustomWebElementUtil.iRowCount;
			
			sTotalPageNumber=EVDC_OverviewPF.getNav_EVDCViewTotalPage().getText();
			sTotalPageNumber=sTotalPageNumber.replace("of ", "");
			iTotalPageNumber=Integer.parseInt(sTotalPageNumber);
			
			if(iRowCnt==5)
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "EVDC count" , "Verifying EVDC Count", "pass", "EVDC count is 5");
				if(iTotalPageNumber>1)
				{
					sFrstPgEVDC=CustomWebElementUtil.getCellData(1, 1);
					WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCViewPageNextBtn());
					WebObjectUtil.explicitWait(5);
					
					//Loading the EVDC View table
					CustomWebElementUtil.loadCustomElement(EVDC_OverviewPF.getNav_EVDCViewHomeTable(), "table");
					sSecondPgEVDC=CustomWebElementUtil.getCellData(1, 1);
					
					if(!(sFrstPgEVDC.equals(sSecondPgEVDC)))
					{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Comparing EVDC" , "Verifying EVDC name from 1st page and 2nd page", "pass", "EVDC from 1st Page - "+sFrstPgEVDC + "/ EVDC from 2nd page - "+ sSecondPgEVDC);
					}
					else
					{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Comparing EVDC" , "Verifying EVDC name from 1st page and 2nd page", "fail", "EVDC from 1st Page - "+sFrstPgEVDC + "/ EVDC from 2nd page - "+ sSecondPgEVDC);
					}
				}
				else
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Comparing EVDC" , "Verifying EVDC Count", "pass", "EVDC count is less than or equal to 5, so Total page is "+iTotalPageNumber);	
				}
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "EVDC count" , "Verifying EVDC Count", "pass", "EVDC count is "+iRowCnt);
			}
		} catch (NumberFormatException e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
	}

	/*====================================================================================================
	Method Name 	: verifyEVDCViewTableHeader
	Description		: it will verify the header of EVDC View Table
	Author 			: Vivek Kumar
	Creation Date 	: 01/04/2016
	Pre-Requisites	:
	Revision History:
	=====================================================================================================*/
	public static void verifyEVDCViewTableHeader()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);
		
		try {
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCViewNameTab());
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCViewParentTab());
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCViewParentTab());
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCViewStorageTab());
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCViewNetworksTab());
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCViewvCPUsTab());
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCViewvRAMTab());
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCViewVMCountTab());
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}


	/*====================================================================================================
	Method Name 	: verParentChildEntityLink
	Description		: to verify that Parent Entity have link and Child entity should not have link
	Author 			: Vivek Kumar
	Creation Date 	: 12/29/2015
	Pre-Requisites	: Roll flag should be in OFF mode.
					click on the Entity browser link and then select the parent
					For example 
					WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
					EntityBrowserTestCase.selectOrgFromAllLevelsEB("TST Entity01", null, null, null);
	Revision History:
	=====================================================================================================*/
	public static void verParentChildEntityLink(boolean bVerifyEVDCLink, boolean bVerifyVCloudLink)
	{
		WebDriver driver= WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EBPanel);
		PageFactory.initElements(driver, EVDC_OverviewPF);
		PageFactory.initElements(driver, Home);
		
		String sEVDCNameRunnTime = null,sCurrentEntityName;
		String OrgName,sLink,sVerifyVCLDTitle;
		int iRowCnt;
		WebElement wEVDCName,wEVDCvCLD;
		
		 sVerifyVCLDTitle=(String) FrameworkUtil.dictPropertyData.get("NAV.VCLOUD.TITLE");
		
		try {
			
			sCurrentEntityName = EBPanel.getNav_EntityBrowserLink().getText();
			 if (!sCurrentEntityName.equalsIgnoreCase("Back to your Entity")){
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			}
			 
			//Clicking on EBPanel Tab
			WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
			WebObjectUtil.explicitWait(5);		
			EVDC_VM_TestCase.getEVDCNameAsWebElement(" ");
			for (WebElement wEVDC : WebObjectUtil.webElementsList)
			{
				//concatinating the EVDC name with ##
				sEVDCNameRunnTime = sEVDCNameRunnTime+"##"+wEVDC.getText();
				
			}
			//Converting EVDC name into Lower case
			sEVDCNameRunnTime=sEVDCNameRunnTime.toLowerCase();
			
			//Clicking on Entity Browsre link
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			
			//turning RollUp Button ON
			//WebObjectUtil.clickElement(EBPanel.getNav_EBPanelRollUpButton());
			EntityBrowserTestCase.setRollOnOffEBPanel(true);
			
			//Clicking on EBPanel Tab
			WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
			WebObjectUtil.explicitWait(5);
			//Loading the EVDC View table
			CustomWebElementUtil.loadCustomElement(EVDC_OverviewPF.getNav_EVDCViewHomeTable(), "table");
			iRowCnt=CustomWebElementUtil.iRowCount;
			
			
			String HandleBefore = driver.getWindowHandle();
			for(int i=1;i<=iRowCnt;i++)
			{
				CustomWebElementUtil.loadCustomElement(EVDC_OverviewPF.getNav_EVDCViewHomeTable(), "table");
				 OrgName=CustomWebElementUtil.getCellData(i, 1).toLowerCase();
				 sLink = (String) FrameworkUtil.dictDynamicPagePactory.get("NAV.EVDCVIEWTABLE.LINK");
				 sLink = sLink.replace("PARAMETER_ROWNUMBER", i+"");
				
				 
				 //Getting the link list for each row
				List<WebElement> wLinkList= driver.findElements(By.xpath(sLink));
				//System.out.println(wLinkList.size());
				//Checking the link count for each row
				if (wLinkList.size() > 0) 
				{
					
					if(sEVDCNameRunnTime.contains(OrgName))
					{
						
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "EVDC Name", "Verifying EVDC Link for Parent Entity", "pass", "EVDC Link verified  - "+OrgName);
						
						if(bVerifyEVDCLink)
						{
							wEVDCName = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.EVDCVIEWTABLE.EVDC", "PARAMETER_ROWNUMBER", i+"");
							WebObjectUtil.clickAndVerifyElement(wEVDCName, EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
							//driver.navigate().back();
							//WebObjectUtil.clickElement(Home.getNav_HomeBreadcrumb());
							WebObjectUtil.clickByJS(Home.getNav_HomeBreadcrumb());
							WebObjectUtil.explicitWait(5);
						}
						
						if(bVerifyVCloudLink)
						{
							
						   wEVDCvCLD=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.EVDCVIEWTABLE.VCLOUD", "PARAMETER_ROWNUMBER", i+"");
						   WebObjectUtil.scrollToElement(wEVDCvCLD);
						   WebObjectUtil.clickElement(wEVDCvCLD);
						   WebObjectUtil.explicitWait(5);
						   WebObjectUtil.switchToWindow(2, sVerifyVCLDTitle);
						   WebObjectUtil.explicitWait(5);
						   driver.close();
						  // WebObjectUtil.switchToParentWindow();
						   driver.switchTo().window(HandleBefore);
						   WebObjectUtil.explicitWait(3);
						}
					   
					   
					}
					else
					{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "EVDC Name", "Verifying EVDC Link for Parent Entity", "fail", "EVDC Link not verified - "+OrgName);
					}
				}
				else
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "EVDC Name", "Verifying EVDC link is not there for Child Entity", "pass", "Verified - EVDC Link is not there for - "+OrgName);
				}
			}
		} catch (Exception e) {
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
				
	}

	/*====================================================================================================
	Method Name 	: verifyVCldLnkNotThere
	Description		: to verify VCloud link should not be there
	Author 			: Vivek Kumar
	Creation Date 	: 01/05/2016
	Pre-Requisites	:
	Revision History:
	=====================================================================================================*/
	public static void verifyVCldLnkNotThere()
	{
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);
		
		int iRowCnt;
		WebElement wEVDCvCLD;
		
		try {
			//Loading the EVDC View table
			CustomWebElementUtil.loadCustomElement(EVDC_OverviewPF.getNav_EVDCViewHomeTable(), "table");
			iRowCnt=CustomWebElementUtil.iRowCount;

			for(int i=1;i<=iRowCnt;i++)
			{
				  wEVDCvCLD=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.EVDCVIEWTABLE.VCLOUD", "PARAMETER_ROWNUMBER", i+"");
				  if(wEVDCvCLD==null)
				  {
					  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "VCloud Link" , "Verifying VCloud Link not present", "pass", "VCloud Link not present for ROLE E"); 
				  }
				  else
				  {
					  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "VCloud Link" , "Verifying VCloud Link not present", "fail", "VCloud Link present for ROLE E"); 
				  }
			}
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
	}

	/*====================================================================================================
	Method Name 	: getEVDCNameWithEntityName
	Description		: get the EVDC name with entity name
	Author 			: Vivek Kumar
	Creation Date 	: 12/29/2015
	Pre-Requisites	:
	Revision History:
	=====================================================================================================*/
	public static String[] getEVDCNameWithEntityName(String sFrstEntity,String sSndEntity,String sThrdEntity, String sForthEntity)
	{
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EBPanel);
		
		
		String sEVDCNameRunnTime = "";
		String[] arrEVDC_Entity_List;
		String sParent=EBPanel.getNav_EntityBrowserLink().getText();
				
		EVDC_VM_TestCase.getEVDCNameAsWebElement(" ");
		for (WebElement wEVDC : WebObjectUtil.webElementsList)
		{
			//concatinating the EVDC name with ##
			sEVDCNameRunnTime = sEVDCNameRunnTime+"!EVDC!"+(wEVDC.getText() + "!P!" + sParent);
			
		}
		
		sParent=EBPanel.getNav_EntityBrowserLink().getText();;
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		
		
		EntityBrowserTestCase.selectOrgFromAllLevelsEB(sFrstEntity,"","","");
		EntityBrowserTestCase.arrOrgNameFromEBPanel=EntityBrowserTestCase.getChildOrgNameListFromEBPanel(2);
		
		
		
		//Getting the EVDC name format
		//Clicking on EBPanel Tab
		WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
		//sParent=EVDC_Overview.getNav_EVDCname().getText();
		WebObjectUtil.explicitWait(5);
		EVDC_VM_TestCase.getEVDCNameAsWebElement(" ");
		for (WebElement wEVDC : WebObjectUtil.webElementsList)
		{
			//concatinating the EVDC name with ##
			sEVDCNameRunnTime = sEVDCNameRunnTime+"!EVDC!"+(wEVDC.getText() + "!P!" + sParent);
			
		}
		
		
		//WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		String sChild;
		for(int i=0;i<EntityBrowserTestCase.arrOrgNameFromEBPanel.length;i++)
		{
			sChild=EntityBrowserTestCase.arrOrgNameFromEBPanel[i];
			sParent=EBPanel.getNav_EntityBrowserLink().getText();
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			EntityBrowserTestCase.selectOrgFromAllLevelsEB(sChild,"","","");
			WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
			WebObjectUtil.explicitWait(5);
			EVDC_VM_TestCase.getEVDCNameAsWebElement(" ");
			for (WebElement wEVDC : WebObjectUtil.webElementsList)
			{
				//concatinating the EVDC name with ##
				sEVDCNameRunnTime = sEVDCNameRunnTime+"!EVDC!"+(wEVDC.getText() + "!P!" + sParent);
				
			}
			//#######################################
			//Going back to main entity
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			WebObjectUtil.explicitWait(10);
			//Selecting the sFirst Entity
			EntityBrowserTestCase.selectOrgFromAllLevelsEB(sFrstEntity,"","","");
			//Clicking on EBPanel Tab
			WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
			WebObjectUtil.explicitWait(5);
		}
		
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		WebObjectUtil.explicitWait(2);
		//turning RollUp Button ON
		WebObjectUtil.clickElement(EBPanel.getNav_EBPanelRollUpButton());
		//Clicking on EBPanel Tab
		WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
		WebObjectUtil.explicitWait(5);
		arrEVDC_Entity_List = sEVDCNameRunnTime.split("!EVDC!");
		
		//Removing the first index from array as it contains empty
		arrEVDC_Entity_List = Arrays.copyOfRange(arrEVDC_Entity_List, 1, arrEVDC_Entity_List.length);
		
		return arrEVDC_Entity_List;
	}


	 ///////////////////////Keffer Methods //////////////////////////////
	
		/*====================================================================================================
		Method Name 	: verifyEVDCSelectorWithOrgName
		Description		: Verify EVDCSelector Name matches with Org Name
		Author 			: QAA03
		Creation Date 	: 01/13/2016
		Pre-Requisites	: 
		Revision History:
		====================================================================================================*/
		public static void verifyEVDCSelectorWithOrgName(String sOrgName)
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,EVDC_OverviewPF);
				String sEVDCSelect=null;
				boolean bEVDCSelStatus;
		
		 try {
			   
			    WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
				
				sEVDCSelect=EVDC_OverviewPF.getNav_EVDCOrgSelector().getText();
				
				String sEVDCName[]=sEVDCSelect.split("-");
				sOrgName =sOrgName.replaceAll("\\s+","");
				bEVDCSelStatus=sEVDCName[1].trim().equalsIgnoreCase(sOrgName);
				FrameworkUtil.updateCustomResultBasedOnStatus(bEVDCSelStatus, " EVDCSelector Displays Organization Selected "+sOrgName);
				
			 } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyEVDCSelectorWithOrgName", "warn", "catch block:" +e.getMessage());  
			}
		 
			
		}

		/*====================================================================================================
		Method Name 	: verifyNOEVDCPopupMsg
		Description		: verifying No EVDC Popup Message
		Author 			: QAA03
		Creation Date 	: 01/13/2016
		Pre-Requisites	: 
		Revision History:
		====================================================================================================*/
		public static void verifyNOEVDCPopupMsg()
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,EVDC_OverviewPF);
				String sNOEVDCMsg=null,sNOEVDCPopup=null;
		        boolean bNoEVDCPopupStatus;
		 try {
			    sNOEVDCPopup = (String)FrameworkUtil.dictPropertyData.get("NAV.NOEVDC.POPUP.MESSAGE");
			   
			    WebObjectUtil.explicitWait(5);
			    WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_NoEVDCPopUpMessage());
				
				sNOEVDCMsg =EVDC_OverviewPF.getNav_NoEVDCPopUpMessage().getText();
				
				bNoEVDCPopupStatus = sNOEVDCMsg.equalsIgnoreCase(sNOEVDCPopup);
				
				FrameworkUtil.updateCustomResultBasedOnStatus(bNoEVDCPopupStatus, "No EVDC Popup Message");
			    
				
			 } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyNOEVDCPopupMsg", "warn", "catch block:" +e.getMessage());  
			}
		 
			
		}
		
		/////////////////////////////////Closed Keffer Methods/////////////////////////////////////////////////////
		
		/*==============================================================
		TestScript  	: verifyNetworkDataforPrivateEVDC
		Manual TestCase	: QAT-512 - WCP_2620_TC5_Private Cloud_Networks display.
		Description		: Verifying Network data on home and in EVDC Overview page by clicking on private EVDC
		Author 			: QAA03
		Creation Date 	: 01/06/2016
		Release Name    : OOS
		Coverage        : First three steps are automated and navigator data is verified
		Pre-Requisites	:
		Revision History:
		==============================================================*/
			
		@Test(priority=9)
		public void verifyNetworkDataforPrivateEVDC()
		{
						WebDriver driver = WebDriverUtil.getDriver();
						PageFactory.initElements(driver,EVDC_OverviewPF);
						
						
						String sHomeNetcount=null;
					    int iHomeNetCount=0,iOverviewNetCount=0;
					    boolean bNetStatus;
					    
					try {
						FrameworkUtil.sTestCaseName = "verifyNetworkDataforPrivateEVDC";
						FrameworkUtil.sManualTestCaseName="QAT-512 - WCP_2620_TC5_Private Cloud_Networks display.";
						FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
						
						
						//Login to Navigator with giruser
						LoginTestCase_Old1.LoginAsGirUser();
						
						sHomeNetcount = EVDC_OverviewPF.getNav_PrivateEVDC_NetworkCount().getText();
						
						iHomeNetCount = Integer.parseInt(sHomeNetcount);
						
						//Clicking on Private EVDC Link
						WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_PrivateEVDCLink());
						
						CustomWebElementUtil.loadCustomElement(EVDC_OverviewPF.getNav_NetworksParentTable(), "table");
						
						iOverviewNetCount = CustomWebElementUtil.iRowCount;
						
						//Verifying Network data in the home and EVDC overview page
						bNetStatus = iHomeNetCount==iOverviewNetCount;
						
						FrameworkUtil.updateCustomResultBasedOnStatus(bNetStatus, "Network data for Private EVDC");
						
						//Logout from Navigator
						LoginTestCase_Old1.nav_Logout();
					
					   } catch (Exception e) {
						LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyNetworkDataforPrivateEVDC", "warn", "catch block:" +e.getMessage());
				}
			}
		
//// __________________________________ kyle test cases _____________________________________ ////
		
		
		
		/*==============================================================
		TestScript  	: navValStorageProfileInfo
		Manual TestCase	: QAT-1495-[NAVIGATOR], [NAVIGATOR] Summary View page (Home)
		Description		: Verify that Storage Profile info is displayed in the VM reports 
		Author 			: Vivek Kumar
		Creation Date 	: 06/22/2016
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		@Test(priority=3)
		public void navValHomePgStorageProfileInfo()
		{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, EVDC_OverviewPF);	
			
			FrameworkUtil.sTestCaseName = "Kyle-navValStorageProfileInfo";
			FrameworkUtil.sManualTestCaseName = "QAT-1495-[NAVIGATOR],[NAVIGATOR]Summary View page (Home)";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
			try {
				//Login to Navigator using whs.user as user
				LoginTestCase_Old1.LoginAsWHSUser();
				
				//Verifying vRAM and vCPU section
				WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_vCPUSection());
				WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_vRAMSection());
				
				//Verifying the vRAM and vCPU graph
				WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_vCPUSectionGraph());
				WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_vRAMSectionGraph());
				//Login Out
				LoginTestCase_Old1.nav_Logout();
			} catch (Exception e) {
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
			}
		}
		
		
		
		
		
/// ________________________________ Completed kyle test cases _____________________________ ////	
	//update each @Test result in custom result file
		@AfterMethod
		public static void afterEachMethod(){
			FrameworkUtil.updateTestCaseStatusinResult();
			if(WebDriverUtil.browser.equalsIgnoreCase("ie")){
				WebDriverUtil.quitWebDriver();
			}
			
			//Should be deleted after today's execution by Arul on 7/14/16
			WebDriverUtil.quitWebDriver();

		}

		@AfterTest
		public void afterTest(){
			if (sLoginExpandVM || LoginTestCase_Old1.bLoginStatus ){
			FrameworkUtil.sTestCaseName = "Logout";
			FrameworkUtil.sManualTestCaseName="Logout Navigator";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			LoginTestCase_Old1.nav_Logout();
			FrameworkUtil.updateTestCaseStatusinResult();
			}
		}
	
}
