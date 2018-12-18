package com.whs.navigator.testcases.dev.old;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.CloudServicesPageFactory;


public class CloudServicesTestCase {

	
	public static CloudServicesPageFactory cloudServices = new CloudServicesPageFactory();
	
	/*==============================================================
	TestScript 		: singleCloudService
	Manual TestCase	: User with single Cloud Services
	Description		: Verifying the User with single Cloud Services can access VMware vCloud Director
					  
	Author 			: Arularasu
	Creation Date 	: 01/27/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test
	public void singleCloudService(){
		String ParentWindowName;
		
		FrameworkUtil.sTestCaseName = "singleCloudService";
		FrameworkUtil.sManualTestCaseName = "User with single Cloud Services";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		//FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName);
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, cloudServices);
		try {
		
		//Capturing UserName and Password from properties file
		String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLE.USERID");
		String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLE.PWD");
		
		//login to Navigator as test
		LoginTestCase.nav_Login(sUserName, sPassword);
		
		//check for login success
		//WebObjectUtil.assertElementPresent(dashboard.getNav_UserNameLink());
		WebObjectUtil.VerifyTextOnPage((String)FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLE.USERFULLNAME"));
		
		//Clicking and Verifying Cloud API Link URL
		ParentWindowName = driver.getWindowHandle();
		WebObjectUtil.ClickAndMouseHover(cloudServices.getNav_ServicesTab());
		WebObjectUtil.clickElement(cloudServices.getNav_CloudServicesMenuLink());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebObjectUtil.switchToWindow(2, null);
		//WebObjectUtil.switchToWindow(0, "VMware vCloud Director");
		WebObjectUtil.compareString(driver.getTitle(), (String)FrameworkUtil.dictPropertyData.get("NAV.CLOUD.WINDOW.TITLE"), true);
		boolean bstatus =WebObjectUtil.compareString(driver.getCurrentUrl(), (String)FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLEUSER.URL"), true);
		//close the second window
		if (!driver.getWindowHandle().equalsIgnoreCase(ParentWindowName)){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.close();
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Close Window", "done", "Close the new window");
		}
		driver.switchTo().window(ParentWindowName);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		
	
			if (bstatus){
			LoggerUtil.writeStatusLog(true, "VM access", "User with single Cloud Services navigates to VM window for user " + sUserName );
			}else{
				LoggerUtil.writeStatusLog(bstatus, "VM access", "FAILURE: User with single Cloud Services NOT navigates to VM window for user " + sUserName);	
			}
		//sign out Navigator
		LoginTestCase.nav_Logout();
		} catch (Exception e) {
			e.printStackTrace();
			LoggerUtil.log_type_error(e.getMessage());
			LoggerUtil.log_type_error("issue with single user Cloud Services");
		}
	}
	
	/*==============================================================
	TestScript 		: noCloudService
	Manual TestCase	: User with no Cloud Services
	Description		: Verifying the User with No Cloud Services landing to Cloud service page
					  
	Author 			: Arularasu
	Creation Date 	: 01/28/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	
	@Test
	public void noCloudService(){
				
		FrameworkUtil.sTestCaseName = "noCloudService";
		FrameworkUtil.sManualTestCaseName = "User with No Cloud Services";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		//FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName);
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, cloudServices);
		try {
		
		//Capturing UserName and Password from properties file
		String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.NOCLOUD.USERID");
		String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.NOCLOUD.PWD");
		
		//login to Navigator as test
		LoginTestCase.nav_Login(sUserName, sPassword);
		
		//check for login success
		//WebObjectUtil.assertElementPresent(dashboard.getNav_UserNameLink());
		WebObjectUtil.VerifyTextOnPage((String)FrameworkUtil.dictPropertyData.get("NAV.NOCLOUD.USERFULLNAME"));
			
		//Clicking and Verifying Cloud API Link URL
	
		WebObjectUtil.ClickAndMouseHover(cloudServices.getNav_ServicesTab());
		WebObjectUtil.clickElement(cloudServices.getNav_CloudServicesMenuLink());
		//verify Cloud Services marketing page
		WebObjectUtil.assertElementPresent(cloudServices.getNav_CloudServicesTitle());
		
	
		//sign out Navigator
		LoginTestCase.nav_Logout();
		} catch (Exception e) {
			e.printStackTrace();
			LoggerUtil.log_type_error(e.getMessage());
			LoggerUtil.log_type_error("issue with No user Cloud Services");
		}
	}


	/*==============================================================
	TestScript 		: multiCloudService
	Manual TestCase	: User with single Cloud Services
	Description		: Verifying the User with multi Cloud Services can access VMware vCloud Director for all user
					  
	Author 			: Arularasu
	Creation Date 	: 01/29/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	//@Test
	public void multiCloudService(){
		String sWebElementGetterName;
		WebElement webElement;
		
		FrameworkUtil.sTestCaseName = "multiCloudService";
		FrameworkUtil.sManualTestCaseName = "User with Multi Cloud Services";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		//FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName);
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, cloudServices);
		try {
		
		//Capturing UserName and Password from properties file
		String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
		String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
		
		//login to Navigator as test
		LoginTestCase.nav_Login(sUserName, sPassword);
		
		//check for login success
		WebObjectUtil.VerifyTextOnPage((String)FrameworkUtil.dictPropertyData.get("NAV.TEST.USERFULLNAME"));
		
		webElement = cloudServices.getNav_Lab3PrivateCloudLink();
		sWebElementGetterName = FrameworkUtil.sElementName ;
		clickAndVerifyCloudService(webElement,sWebElementGetterName);
		
		webElement = cloudServices.getNav_Andover_MA_Link();
		sWebElementGetterName = FrameworkUtil.sElementName ;
		clickAndVerifyCloudService(webElement,sWebElementGetterName);
		
		webElement = cloudServices.getNav_Charlotte_NC_Link();
		sWebElementGetterName = FrameworkUtil.sElementName ;
		clickAndVerifyCloudService(webElement,sWebElementGetterName);
			
		//sign out Navigator
		LoginTestCase.nav_Logout();
		} catch (Exception e) {
			e.printStackTrace();
			LoggerUtil.log_type_error(e.getMessage());
			LoggerUtil.log_type_error("issue with No user Cloud Services");
		}
	}
	
	/*==============================================================
	MethodName 		: clickAndVerifyCloudService
	Description		: click on cloud service link and check vCloud page is opening
					  
	Author 			: Arularasu
	Creation Date 	: 01/29/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	private void clickAndVerifyCloudService(WebElement LinkAswebElement,String sWebElementGetterName){
		//Clicking and Verifying Cloud API Link URL
		
			try {
				WebDriver driver = WebDriverUtil.getDriver();
				WebObjectUtil.ClickAndMouseHover(cloudServices.getNav_ServicesTab());
				WebObjectUtil.clickElement(cloudServices.getNav_CloudServicesMenuLink());
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				FrameworkUtil.sElementName = sWebElementGetterName ;
				WebObjectUtil.clickElement(LinkAswebElement);
				Thread.sleep(10000);
				boolean bstatus =WebObjectUtil.compareString(driver.getCurrentUrl(), (String)FrameworkUtil.dictPropertyData.get("NAV.CLOUD.MULTIUSER.URL"), true);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "vCloud window", "pass", "Title: " + driver.getTitle() );
				driver.navigate().back();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				if (bstatus){
					LoggerUtil.writeStatusLog(true, "VM access", "User with Multi Cloud Services navigates to VM window for user "  );
					}else{
						LoggerUtil.writeStatusLog(bstatus, "VM access", "FAILURE: User with Multi Cloud Services NOT navigates to VM window for user " );	
					}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				LoggerUtil.log_type_error(e.getMessage());
				LoggerUtil.log_type_error("issue with Multi user Cloud Services");
			}
		
	}
	
	//update each @test result in custom result file
	@AfterMethod
	public static void afterEachMethod(){
		FrameworkUtil.updateTestCaseStatusinResult();
		
	}
	
	

	
	
}
