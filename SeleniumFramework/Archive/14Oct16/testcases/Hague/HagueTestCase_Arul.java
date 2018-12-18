package com.whs.navigator.testcases.Hague;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.SmokeTestPageFactory;

public class HagueTestCase_Arul {
static HomePageFactory_old Home = new HomePageFactory_old();
static SmokeTestPageFactory Smoke = new SmokeTestPageFactory();

	


	
	
	

	


	
	

	
	
	//update each @test result in custom result file
	@AfterMethod
	public static void afterEachMethod(){
			FrameworkUtil.updateTestCaseStatusinResult();
				
	 }
	
}
