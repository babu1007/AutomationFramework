package com.whs.navigator.testcases;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.EM7PageFactory;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.EVDC_VM_PageFactory;

public class EM7TestCase {
	
	public static EVDC_OverviewPageFactory EVDC_Overview= new EVDC_OverviewPageFactory();
	public static EVDC_VM_PageFactory EVDC_VMPF= new EVDC_VM_PageFactory();
	public static EM7PageFactory EM7=new EM7PageFactory();
	
	
	/*==============================================================
	TestScript  	: navVMOSManagedInfo
	Manual TestCase	: Check that VM OS Managed info displays properly.
	Description		: Verify that the correct term appears for the correct status (Managed, Unmanaged). TESTING NOTE:
						- For any VM where any device was found in to be Monitored, 
						it will be checked if any of the found devices are associated with any of the OS-Managed SKUs.
						 If so, the VM will be considered to be OS Managed.
	Author 			: Vivek Kumar
	Creation Date 	: 03/24/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=1)
	public void navVMOSManagedInfo()
	{
		
		try {
			FrameworkUtil.sTestCaseName = "EVDC-navVMOSManagedInfo";
			FrameworkUtil.sManualTestCaseName=" Check that VM OS Managed info displays properly.";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, EVDC_Overview);
			PageFactory.initElements(driver, EVDC_VMPF);
			
			//Login to Navigator
			EVDC_Overview_TestCase.navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC_Overview.getNav_EVDCname(), EVDC_Overview.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC_Overview.getNav_EVDCOverviewVirtualMachine(), EVDC_VMPF.getNav_AddVMLink());
			navClickMoniterandManagedOS("ClosedEye_Icon","Managed");
			//Logging out from Navigator application
			LoginTestCase_Old1.nav_Logout();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LoggerUtil.log_type_error("Issue with -navVMOSManagedInfo ");
			LoggerUtil.log_type_error(e.getMessage());
		}
		
	}
	
	
	/*==============================================================
	TestScript  	: navVMMonitoredInfoDisplay
	Manual TestCase	: Check that VM Monitored info displays properly.
	Description		: Verify that the correct icon appears for the correct status (open eye for Monitored VM, closed eye for Not Monitored VM). 
						TESTING NOTE:
						- For any VM in vCD, we will check em7 for any device with a matching name and org. 
						If any match is found, that VM will be considered to be Monitored.
	Author 			: Vivek Kumar
	Creation Date 	: 03/25/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=2)
	public void navVMMonitoredInfoDisplay()
	{
		
		try {
			String sURL, sExpId,sActId;
			String [] Arr;
			FrameworkUtil.sTestCaseName = "EVDC-navVMMonitoredInfoDisplay";
			FrameworkUtil.sManualTestCaseName="Check that VM Monitored info displays properly";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			//sURL.lastIndexOf(str)
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, EVDC_Overview);
			PageFactory.initElements(driver, EVDC_VMPF);
			PageFactory.initElements(driver, EM7);
			
			//Login to Navigator
			EVDC_Overview_TestCase.navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC_Overview.getNav_EVDCname(), EVDC_Overview.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC_Overview.getNav_EVDCOverviewVirtualMachine(), EVDC_VMPF.getNav_AddVMLink());
			
			sURL=navClickMoniterandManagedOS("ClosedEye_Icon","");
			//Commented By Sukur Babu. B Dated on 26 May 2016 as per discussion with Arul, No need to Execute EM7 test scripts
			/*Arr=sURL.split("&");
			Arr=Arr[1].split("=");
			sExpId=Arr[1].trim();
			//System.out.println(Arr[1]);
			WebObjectUtil.switchToWindow(1, "Hosted Solutions Dashboard");
			//Login to EM7
			WebObjectUtil.SetValueEdit(EM7.getEM7_LoginUserID(), "navuser");
			WebObjectUtil.SetValueEdit(EM7.getEM7_LoginPwd(), "AyPee3ye");
			WebObjectUtil.clickAndVerifyElement(EM7.getEM7_LoginSubmit(), EM7.getEM7_TopMenu());
			sActId=EM7.getEM7_MonitoredID().getText().trim();
			boolean bStatus=WebObjectUtil.compareString(sExpId, sActId, true);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "did value in the Managed Icon is same as id in EM7 appliaction");
			WebObjectUtil.clickElement(EM7.getEM7_CloseBtn());
			WebObjectUtil.switchToWindow(0, "Virtual Machines - Home");*/
			
			//Logging out from Navigator application
			LoginTestCase_Old1.nav_Logout();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LoggerUtil.log_type_error("Issue with -navVMMonitoredInfoDisplay ");
			LoggerUtil.log_type_error(e.getMessage());
		}
		
	}
	
	
	
	/*==============================================================
	Method Name 	: navClickMoniterandManagedOS
	Description		: This will click on Monitored and Managed OS VM
	Author 			: Vivek Kumar
	Creation Date 	: 03/24/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static String navClickMoniterandManagedOS(String Monitored,String OSManaged)
	{
		int iRowCnt,iRow=0;
		String sMonitored,sOSManaged;
		String sURL=null;
		boolean flag=false;
		
		WebDriver driver = WebDriverUtil.getDriver();
		iRowCnt =driver.findElements(By.xpath("//*[@id='vmListExtGridPanel-body']/div/table/tbody/tr")).size();
		
		if(OSManaged.isEmpty())
		{
			OSManaged="Unmanaged";
		}
		
		for(int i=1;i<=iRowCnt;i++)
		{
				sOSManaged=driver.findElement(By.xpath("//table/tbody/tr[" + i + "]//td[11]/div")).getText();
					if((sOSManaged.contains("Managed"))|| (sOSManaged.contains("Unmanaged")))
					{
						sMonitored=driver.findElement(By.xpath("//table/tbody/tr[" + i + "]//td[10]//img")).getAttribute("src");
						
						if((!sMonitored.contains(Monitored)) && (WebObjectUtil.compareString(sOSManaged, OSManaged, true)))
						{
							flag=true;
							iRow=i;
							break;
						}
					}
					else
					{
						break;
					}
		}
				
		
		if(flag)
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName ,"OS Managed and Moniterd VM Found" , "pass", "");
			LoggerUtil.log_type_info("OS Managed and Moniterd VM Found");
			sURL=driver.findElement(By.xpath("//table/tbody/tr[" + iRow + "]//td[10]//a")).getAttribute("href");
			driver.findElement(By.xpath("//table/tbody/tr[" + iRow + "]//td[10]//img")).click();
		}
		else
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName ,"VM with OS Managed and Moniterd not Found " , "warn", "");
			LoggerUtil.log_type_warn("VM with OS Managed and Moniterd not Found ");
		}
		return sURL;
	}
	
	
	@Test	
	public static void VerifyUpgradeProcess()
		{
		
		      WebDriver driver = WebDriverUtil.getDriver();
		      PageFactory.initElements(driver, EM7);
	
		 
		      String sUrl = (String)FrameworkUtil.dictPropertyData.get("EM7.URL");                
		      String sUserName = (String)FrameworkUtil.dictPropertyData.get("EM7.ACCOUNT");
	 	      String sPassword = (String)FrameworkUtil.dictPropertyData.get("EM7.PWD");
			
	          String sNavUrl = (String)FrameworkUtil.dictPropertyData.get("NAV.QA.UPGRADE.URL");    
		      String sNavUserName = (String)FrameworkUtil.dictPropertyData.get("EM7.REGISTRY.ACC.USERACC.CREATE.ACCLOGINNAME");
		      String sNavPassword = (String)FrameworkUtil.dictPropertyData.get("EM7.REGISTRY.ACC.USERACC.CREATE.PASSWORD");
		      String sNavMessage = (String)FrameworkUtil.dictPropertyData.get("NAV.QA.UPGRADE.ERRORMESSAGE");
		 
		                 
		   try {
			   FrameworkUtil.sTestCaseName = "VerifyUpgradeProcess";
			   FrameworkUtil.sManualTestCaseName="Verify upgrade process when user name is too long. ";
			   FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

			   driver.get(sUrl);
			   EM7Login(sUserName, sPassword);
			
			  // EM7CreateUser();
			
			   EM7Logout();
			
			  // driver.get(sNavUrl);
				
			  // NavUpgradeUser(sNavUserName,sNavPassword);
			  // WebObjectUtil.VerifyTextOnPage(sNavMessage);
		} catch (Exception e) {
			
			   LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
			   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VerifyUpgradeProcess", "warn", "catch block:Could NOT access webelement" +e.getMessage());
		}
		
	}

	public static void EM7Login(String sAccount,String sPwd)
	{
		 try {
			   WebDriver driver = WebDriverUtil.getDriver();
			    PageFactory.initElements(driver, EM7);
			 
			   WebObjectUtil.SetValueEdit(EM7.getEM7_Account(),sAccount);
			   WebObjectUtil.SetValueEdit(EM7.getEM7_Password(),sPwd);
			   WebObjectUtil.clickElement(EM7.getEM7_SignIn());
			    
		} catch (Exception e) {
			
			   LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
			   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "EM7Login", "warn", "catch block:Could NOT access webelement" +e.getMessage());
		}
		    
	}


	public static void EM7CreateUser()
	{
		       String sFirstname = (String)FrameworkUtil.dictPropertyData.get("EM7.REGISTRY.ACC.USERACC.CREATE.FIRSTNAME");
		       String sLastname = (String)FrameworkUtil.dictPropertyData.get("EM7.REGISTRY.ACC.USERACC.CREATE.LASTNAME");
		       String sAccLoginname = (String)FrameworkUtil.dictPropertyData.get("EM7.REGISTRY.ACC.USERACC.CREATE.ACCLOGINNAME");
		       String sPrimaryEmail = (String)FrameworkUtil.dictPropertyData.get("EM7.REGISTRY.ACC.USERACC.CREATE.ACCPRIMARYEMAIL");
		       String sAccPassword = (String)FrameworkUtil.dictPropertyData.get("EM7.REGISTRY.ACC.USERACC.CREATE.PASSWORD");
		       String sAccConfirmPassword = (String)FrameworkUtil.dictPropertyData.get("EM7.REGISTRY.ACC.USERACC.CREATE.CONFIRMPASSWORD");
		       String sOrgname = (String)FrameworkUtil.dictPropertyData.get("EM7.REGISTRY.ACC.USERACC.CREATE.ORGNAME");
		       String sAcctype = (String)FrameworkUtil.dictPropertyData.get("EM7.REGISTRY.ACC.USERACC.CREATE.ACCTYPE");
		       String sAccTemplate = (String)FrameworkUtil.dictPropertyData.get("EM7.REGISTRY.ACC.USERACC.CREATE.ACCTEMPLATE");
		  
		   try {
			   
			   WebObjectUtil.clickElement(EM7.getEM7_TimeZonePopUpWindow());
			   WebObjectUtil.clickElement(EM7.getEM7_RegistryButton());
			   WebObjectUtil.clickElement(EM7.getEM7_Reg_AccountsButton());
			   WebObjectUtil.clickElement(EM7.getEM7_Reg_Acc_UserAccButton());
			   WebObjectUtil.clickElement(EM7.getEM7_Reg_Acc_UserAcc_CreateButton());
			   WebObjectUtil.explicitWait(5);
			   WebObjectUtil.switchToWindow(2, "");
			
					
			    WebObjectUtil.SetValueEdit(EM7.getEM7_NewAcc_Firstname(), sFirstname);
				WebObjectUtil.SetValueEdit(EM7.getEM7_NewAcc_Lastname(), sLastname);
			    WebObjectUtil.SetValueEdit(EM7.getEM7_NewAcc_AccLoginname(), sAccLoginname);
			    WebObjectUtil.SetValueEdit(EM7.getEM7_NewAcc_PrimaryEmail(), sPrimaryEmail);
			    WebObjectUtil.SetValueEdit(EM7.getEM7_NewAcc_Password(), sAccPassword);
			    WebObjectUtil.SetValueEdit(EM7.getEM7_NewAcc_ConfirmPassword(),sAccConfirmPassword);
			    WebObjectUtil.deSelectCheckBox(EM7.getEM7_NewAcc_ReqPasswordReset());
			    WebObjectUtil.selectWebList(EM7.getEM7_NewAcc_SelectOrg(), sOrgname, null, null);
			    WebObjectUtil.selectWebList(EM7.getEM7_NewAcc_AccType(), sAcctype, null, null);
			    WebObjectUtil.handleJSAlert();
			
			    WebObjectUtil.selectWebList(EM7.getEM7_NewAcc_AccTemplate(),sAccTemplate , null, null);	
			    WebObjectUtil.explicitWait(10);
			    WebObjectUtil.clickElement(EM7.getEM7_NewAcc_SaveButton());
			    WebObjectUtil.handleJSAlert();
			    WebObjectUtil.handleJSAlert();
			    WebObjectUtil.clickElement(EM7.getEM7_NewAcc_CloseButton());
			    WebObjectUtil.switchToParentWindow();
		} catch (Exception e) {
			
			    LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
			    FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "EM7CreateUser", "warn", "catch block:Could NOT access webelement" +e.getMessage());
		} 
		
	}

	public static void EM7Logout()
	{
				WebDriver driver = WebDriverUtil.getDriver();
			    PageFactory.initElements(driver, EM7);
		 try {
			    
			    WebObjectUtil.clickElement(EM7.getEM7_NewAcc_ToolBoxButton());
			    WebObjectUtil.clickElement(EM7.getEM7_NewAcc_Logout());
			 
		} catch (Exception e) {
			
			    LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
			    FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "EM7Logout", "warn", "catch block:Could NOT access webelement" +e.getMessage());
		}
	}

	public static void NavUpgradeUser(String sAccount,String sPwd)
	{
		 try {
			 
			//    WebObjectUtil.SetValueEdit(EM7.getNav_Upgrade_Username(),sAccount);
			//    WebObjectUtil.SetValueEdit(EM7.getNav_Upgrade_Password(),sPwd);
			 //   WebObjectUtil.clickElement(EM7.getNav_Upgrade_UpgradeButton());
			    
		} catch (Exception e) {
			
			   LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
			   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "NavUpgradeUser", "warn", "catch block:Could NOT access webelement" +e.getMessage());
		}
		
		    
	}


	/*==============================================================
	Method name  	: verifyCloseEM7LoginPage
	
	Description		: Verifies EM7 login page and if EM7 login page opened as separate window then close the same
	Author 			: Arularasu
	Creation Date 	: 06/07/2016
	Pre-Requisites	:
	Revision History:
	==============================================================*/
public static boolean verifyCloseEM7LoginPage(WebElement webElement){
	
	int iWindowCount = 0;
	String sEM7Url = null;
	boolean bStatus = false;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EM7);
	
	try {
		WebObjectUtil.clickElement(webElement);
		WebObjectUtil.explicitWait(10);
		
		Set<String>windows = driver.getWindowHandles();
		iWindowCount = windows.size();
		if (windows.size() > 1){
			WebObjectUtil.switchToWindow(iWindowCount, null);
		}
		
		sEM7Url =driver.getCurrentUrl();
		bStatus = sEM7Url.contains("em7");
		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Verify url contains string like EM7");
		WebObjectUtil.verifyElementPresent(EM7.getEM7_LoginSubmit());

		if (windows.size() > 1 && bStatus==true ){
			driver.close();
			WebObjectUtil.switchToParentWindow();
			driver.switchTo().defaultContent();
		}else{
			driver.navigate().back();
			WebObjectUtil.switchToParentWindow();
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return bStatus;
}
	

	
	
	
}
