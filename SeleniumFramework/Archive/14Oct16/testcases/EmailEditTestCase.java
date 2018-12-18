package com.whs.navigator.testcases;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.EmailEditPageFactory;
import com.whs.navigator.testcases.LoginTestCase_Old1;

public class EmailEditTestCase {

	public static EmailEditPageFactory EmailEdit = new EmailEditPageFactory();

	/*==============================================================
	Test Script 	: navEmailEditPage
	Manual TestCase	: email not editable to non-privileged user
					  email editable to privileged user
	Description		: email address appears on screen and is not editable
					  email address field is editable
	Author 			: Sukur Babu
	Creation Date 	: 12/15/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test
public static void navEmailEditPageDisabled() throws InterruptedException
	{

		FrameworkUtil.sTestCaseName = "navEmailEditPageDisabled";
		FrameworkUtil.sManualTestCaseName="email not editable to non-privileged user";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		try 
		{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, EmailEdit);
			
			 //getting user name from properties file
			String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
			//getting password from properties file
			String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
			
			//Login to navigator application
			//LoginTestCase.nav_Login(sUserName, sPassword);
			LoginTestCase_Old1.LoginAsQaautoUser();
			
			VerifyEmailIdTextFieldDisabled();
			//log out Navigator
			LoginTestCase_Old1.nav_Logout();
			
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			LoggerUtil.log_type_error("Method:navEmailEditPageDisabled, Error MSG :" + e.getMessage());
		}
	}
	
	@Test
public static void navEmailEditPageEnabled() throws InterruptedException
	{

		FrameworkUtil.sTestCaseName = "navEmailEditPageEnabled";
		FrameworkUtil.sManualTestCaseName="email editable to privileged user";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		try 
		{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, EmailEdit);
			
			
			 //getting admin user name from properties file
			String sPrivilegedUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.EMAILEDIT.USERID");
			//getting admin password from properties file
			String sPrivilegedPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.EMAILEDIT.PWD");
			
			
			//Login to navigator application
			LoginTestCase_Old1.nav_Login(sPrivilegedUserName, sPrivilegedPassword);
			VerifyEmailIdTextFieldEnabled();
			//Login.nav_Signout();
			LoginTestCase_Old1.nav_Logout();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			LoggerUtil.log_type_error("Method:navEmailEditPageEnabled, Error MSG :" + e.getMessage());
		}
	}
	
	/*==============================================================
	Method Name 	: VerifyEmailIdTextFieldDisabled
	Description		: Is used to verify Email Id field is disabled
	Author 			: Sukur Babu
	Creation Date 	: 12/16/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void VerifyEmailIdTextFieldDisabled()
	{
		
			//MouseHover on Accounts tab
			WebObjectUtil.ClickAndMouseHover(EmailEdit.getnav_AccountTab());
			//Click on settings link from Accounts menu
			WebObjectUtil.clickElement(EmailEdit.getNav_AccountSettingsMenuLink());
			//Click Details link in Accounts Setting page
			WebObjectUtil.clickElement(EmailEdit.getnav_DetailsLink());
			//Get Email Id webelement
			WebElement EmailId=EmailEdit.getnav_EmailIdText();
			//Get the attribute type for Email Id field-We used to type attribute to check that the field is enabled or not.
			//Reason: We don't have any other attribute or menhod to verify. IsEnabled throwing true even if we see that the 
			// field is disabled.
			String sEmailIdAttr=EmailId.getAttribute("type");
			WebObjectUtil.compareString("hidden",sEmailIdAttr,true);
			//System.out.println(EmailId.isEnabled());
	}
	/*==============================================================
	Method Name 	: VerifyEmailIdTextFieldEnabled
	Description		: Is used to verify Email Id field is Enabled
	Author 			: Sukur Babu
	Creation Date 	: 12/16/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void VerifyEmailIdTextFieldEnabled()
	{
		
			//MouseHover on Accounts tab
			WebObjectUtil.ClickAndMouseHover(EmailEdit.getnav_AccountTab());
			//Click on settings link from Accounts menu
			WebObjectUtil.clickElement(EmailEdit.getNav_AccountSettingsMenuLink());
			//Click Details link in Accounts Setting page
			WebObjectUtil.clickElement(EmailEdit.getnav_DetailsLink());
			//Get Email Id webelement
			WebElement EmailId=EmailEdit.getnav_EmailIdText();
			//Get the attribute type for Email Id field-We used to type attribute to check that the field is enabled or not.
			//Reason: We don't have any other attribute or menhod to verify. IsEnabled throwing true even if we see that the 
			// field is disabled.
			String sEmailIdAttr=EmailId.getAttribute("type");
			WebObjectUtil.compareString("text",sEmailIdAttr,true);
			//System.out.println(EmailId.isEnabled());
	}
	
	
	//update each @test result in custom result file
	@AfterMethod
	public static void afterEachMethod(){
		FrameworkUtil.updateTestCaseStatusinResult();
		
	}
	
	
}
