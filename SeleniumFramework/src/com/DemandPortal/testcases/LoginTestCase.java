package com.DemandPortal.testcases;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.DemandPortal.pagefactory.LoginTestPageFactory;
import com.commonUtils.FrameworkUtil;
import com.commonUtils.LoggerUtil;
import com.commonUtils.WebDriverUtil;
import com.commonUtils.WebObjectUtil;

public class LoginTestCase {
	//String sSummaryURL = LoginTestCase.sSummaryURL;
	
	public static LoginTestPageFactory LoginTest = new LoginTestPageFactory();
	
	static WebDriver driver;  
	//static WebDriver driver=WebDriverUtil.webdriver;
	
	@Test(priority=1)
	public void loginSukur(){
		//WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, LoginTest);
		driver=WebDriverUtil.getDriver();
		try {
			FrameworkUtil.sTestCaseName = "loginSESA402879";
			FrameworkUtil.sManualTestCaseName="Login into Demand Portal using Sesa 402879 credentials";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			WebElement e=driver.findElement(By.name("q"));
			WebObjectUtil.SetValueEdit(e, "sukurbabu100778@gmail.com");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			e.printStackTrace();
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		
	}
	
	//update each @Test result in custom result file
	@AfterMethod
	public void afterEachMethod(){
		FrameworkUtil.updateTestCaseStatusinResult();
		
	}
	
	@AfterTest
	public void afterTest(){
		FrameworkUtil.sTestCaseName = "Logout";
		FrameworkUtil.sManualTestCaseName="SmokeTest-Logout Navigator";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		/*if (LoginTestCase.bLoginStatus)
		LoginTestCase.nav_Logout();*/
		FrameworkUtil.updateTestCaseStatusinResult();
		
		//verifyPermissionsPage();
		
	}
	
	
}