package com.whs.navigator.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.EM7PageFactory;
import com.whs.navigator.pagefactory.EVDCPageFactory;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.EVDC_VM_PageFactory;

public class EM7_EVDCTestCase {
	
	public static EVDC_OverviewPageFactory EVDC_Overview= new EVDC_OverviewPageFactory();
	public static EVDC_VM_PageFactory EVDC_VMPF =new EVDC_VM_PageFactory();
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
			PageFactory.initElements(driver, EM7);
			
			//Login to Navigator
			EVDC_Overview_TestCase.navEVDCLogin();
			//Clicking on EVDC Link
			WebObjectUtil.clickAndVerifyElement(EVDC_Overview.getNav_EVDCname(), EVDC_Overview.getNav_EVDCOverviewVirtualMachine());
			//Clicking on Virtual machine
			WebObjectUtil.clickAndVerifyElement(EVDC_Overview.getNav_EVDCOverviewVirtualMachine(), EVDC_VMPF.getNav_AddVMLink());
			navClickMoniterandManagedOS("ClosedEye_Icon","Managed");
			//Logging out from Navigator application
			LoginTestCase.nav_Logout();
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
			Arr=sURL.split("&");
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
			WebObjectUtil.switchToWindow(0, "Virtual Machines - Home");
			
			//Logging out from Navigator application
			LoginTestCase.nav_Logout();
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
	
	

}
