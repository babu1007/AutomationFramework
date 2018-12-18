package com.whs.navigator.testcases.dev.old;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.AccountPageFactory;

public class AccountTestCase {

	AccountPageFactory Account = new AccountPageFactory();
	
	/*==============================================================
	Method Name 	: navAccount
	Description		: This Method will Check for the existence of the following links under Account tab - Account Settings link 
					  and respective screens are loaded or not
	                  Details,Password, Phone Numbers and Display Settings
	Author 			: Praveen K
	Creation Date 	: 12/18/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public void navAccount() 
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, Account);				
			String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
			//getting password from properties file
			String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
			//Login to navigator application
			LoginTestCase.nav_Login(sUserName, sPassword);
			
			//Click Account Link 
			//WebObjectUtil.clickElement(Account.getNav_AccountLink());
			WebObjectUtil.ClickAndMouseHover(Account.getNav_AccountLink());
			
			//Click on Account Settings link
			WebObjectUtil.clickElement(Account.getNav_AccountSettingsLink());
					
			//Verify the Account Settings screen 
			WebObjectUtil.verifyElementPresent(Account.getNav_DetailsLink());
			
	} 

    /*==============================================================
	Test SCript Name: ClickDetailsLink
	Manual TestCase	: Details link
	Description		: This Test will Click on the Details link and verify the Details screen existence  
	Author 			: Praveen K
	Creation Date 	: 12/18/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=1)
	public void ClickDetailsLink()
	{
		try {
			FrameworkUtil.sTestCaseName = "AccountClickDetailsLink";
			FrameworkUtil.sManualTestCaseName="Details link";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			//Navigating to Account Settings screen
			navAccount();
			
			//Verify the Details screen displayed or not 
			WebObjectUtil.clickAndVerifyElement(Account.getNav_DetailsLink(), Account.getNav_FirstNameTextBox());
			
			//Logout of the application
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("Method:ClickDetailsLink, Error MSG :" + e.getMessage());
		}

	}
	
    /*==============================================================
	Test Script Name: ClickPasswordsLink
	Manual TestCase	: Password link
	Description		: This Test will Click on the Passwords link and verify the Password screen existence  
	Author 			: Praveen K
	Creation Date 	: 12/18/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=2)
	public void ClickPasswordsLink() 
	{
		try {
			FrameworkUtil.sTestCaseName = "AccountClickPasswordsLink";
			FrameworkUtil.sManualTestCaseName="Password link";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			//Navigating to Account Settings screen
			navAccount();
			
			//Verify the Password screen displayed or not 
			WebObjectUtil.clickAndVerifyElement(Account.getNav_PasswordLink(), Account.getNav_CurrentPasswordTextBox());
			
			//Logout of the application
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("Method:ClickPasswordsLink, Error MSG :" + e.getMessage());
		}

	}
	
    /*==============================================================
	Test Script Name: ClickPhoneNumbersLink
	Manual TestCase	: Phone Numbers link
	Description		: This Test will Click on the Phone Numbers link and verify the Phone Numbers screen existence  
	Author 			: Praveen K
	Creation Date 	: 12/18/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=3)
	public void ClickPhoneNumbersLink() 
	{
		try {
			FrameworkUtil.sTestCaseName = "AccountClickPhoneNumbersLink";
			FrameworkUtil.sManualTestCaseName="Phone Numbers link";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			//Navigating to Account Settings screenPhone
			navAccount();
			
			//Verify the Phone Numbers screen displayed or not 
			WebObjectUtil.clickAndVerifyElement(Account.getNav_PhoneNumberLink(), Account.getNav_PhoneNumberTextBox());
			
			//Logout of the application
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("Method:ClickPhoneNumbersLink, Error MSG :" + e.getMessage());
		}

	}
	
    /*==============================================================
	Test Script Name: ClickDisplaySettingsLink
	Manual TestCase	: Display Settings link
	Description		: This Test will Click on the Display Settings link and verify the Display Settings screen existence  
	Author 			: Praveen K
	Creation Date 	: 12/18/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=4)
	public void ClickDisplaySettingsLink() 
	{
		try {
			FrameworkUtil.sTestCaseName = "AccountClickDisplaySettingsLink";
			FrameworkUtil.sManualTestCaseName="Display Settings link";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			//Navigating to Account Settings screen
			navAccount();
			
			//Verify the Display Settings screen displayed or not 
			WebObjectUtil.clickAndVerifyElement(Account.getNav_DisplaySettingsLink(), Account.getNav_GreetingsTextBox());
			
			//Logout of the application
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("Method:ClickDisplaySettingsLink, Error MSG :" + e.getMessage());
		}

	}
	
    /*==============================================================
	Test Script Name: EditDetails
	Manual TestCase	: Edit Details
	Description		: This Test will Edit the details in Details screen, save the edited details and reset the details to old details  
	Author 			: Praveen K
	Creation Date 	: 12/23/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=5)
	public void EditDetails() 
	{
		
		try {
			FrameworkUtil.sTestCaseName = "AccountEditDetails";
			FrameworkUtil.sManualTestCaseName="Edit Details";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			//Navigating to Account Settings screen
			navAccount();
			
			//Verify the Details screen displayed or not 
			WebObjectUtil.clickAndVerifyElement(Account.getNav_DetailsLink(), Account.getNav_FirstNameTextBox());
			
			//Input the New data and Save the details 
			String sNewFirstName = (String)FrameworkUtil.dictPropertyData.get("NAV.ACCOUNT.NEWFIRSTNAME");
			navEditDetails(sNewFirstName);

			

			
			//Reset the data to old data and Save details
			String sFirstNameOld = (String)FrameworkUtil.dictPropertyData.get("NAV.ACCOUNT.OLDFIRSTNAME");
			navEditDetails(sFirstNameOld);
			
			//Logout of the application
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("Method:EditDetails, Error MSG :" + e.getMessage());
		}

	}
	
    /*==============================================================
	Method Name		: navEditDetails
	Description		: This Method will Edit the details in Details screen and save the edited details  
	Author 			: Praveen K
	Creation Date 	: 12/23/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public void navEditDetails(String sFirstName) 
	{
		//Enter Data in First Name field
		WebObjectUtil.SetValueEdit(Account.getNav_FirstNameTextBox(), sFirstName);
		
		WebDriverUtil.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Click on Save button
		WebObjectUtil.clickElement(Account.getNav_SaveButton());
		
		WebDriverUtil.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Verify the Saved Success Message
		WebObjectUtil.verifyElementPresent(Account.getNav_SavedSuccessMessage());
	}
    /*==============================================================
	Test Script Name: EditDisplaySettings
	Manual TestCase	: Edit Display Settings
	Description		: This Test will Edit the details in Display Settings screen, save the edited details and reset the details to old details  
	Author 			: Praveen K
	Creation Date 	: 12/23/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=6)
	public void EditDisplaySettings() 
	{
		try {
			FrameworkUtil.sTestCaseName = "AccountEditDisplaySetting";
			FrameworkUtil.sManualTestCaseName="Edit Display Settings";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			//Navigating to Account Settings screen
			navAccount();
			
			//Verify the Display Settings screen displayed or not 
			WebObjectUtil.clickAndVerifyElement(Account.getNav_DisplaySettingsLink(), Account.getNav_GreetingsTextBox());
			
			//Input the New data and Save the details
			String sNewLanguage = (String)FrameworkUtil.dictPropertyData.get("NAV.ACCOUNT.LIST.BYVALUE.NEWLANGUAGE");
			String sNewGreetingsText = (String)FrameworkUtil.dictPropertyData.get("NAV.ACCOUNT.NEWGREETINGSTEXT");
			navEditDisplaySettings(sNewLanguage,sNewGreetingsText);
			
			//Reset the data to old data and Save details
			String sOldLanguage = (String)FrameworkUtil.dictPropertyData.get("NAV.ACCOUNT.LIST.BYVALUE.OLDLANGUAGE");
			String sOldGreetingsText = (String)FrameworkUtil.dictPropertyData.get("NAV.ACCOUNT.OLDGREETINGSTEXT");
			navEditDisplaySettings(sOldLanguage,sOldGreetingsText);
			
			//Logout of the application
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("Method:EditDisplaySettings, Error MSG :" + e.getMessage());
		}

	}
    /*==============================================================
	Method Name		: navEditDisplaySettings
	Description		: This Method will Edit the details in Display Settings screen and save the edited details  
	Author 			: Praveen K
	Creation Date 	: 12/23/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public void navEditDisplaySettings(String sLanguage,String sGreetingsText) 
	{
		//Select Language from drop down
		WebObjectUtil.selectWebList(Account.getNav_LanguageListBox(), null, sLanguage, null);
		
		//Enter Greetings Text
		WebObjectUtil.SetValueEdit(Account.getNav_GreetingsTextBox(), sGreetingsText);
		
		//Click on Save Button
		WebObjectUtil.clickElement(Account.getNav_SaveButton());
		
		//Verify the Saved Success message
		WebObjectUtil.verifyElementPresent(Account.getNav_SavedSuccessMessage());
	}
	
    /*==============================================================
	Test Script Name: AddEditPhoneNumbers
	Manual TestCase	: Add/Edit Phone Number(s)
	Description		: This Test will Add and Edit the Phone Number details
	Author 			: Praveen K
	Creation Date 	: 12/29/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=7)
	public void AddEditPhoneNumbers() 
	{
		try {
			FrameworkUtil.sTestCaseName = "AccountAddEditPhoneNumbers";
			FrameworkUtil.sManualTestCaseName="Add/Edit Phone Number(s)";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			//Navigating to Account Settings screen
			navAccount();
			
			//Verify the Phone Numbers screen displayed or not 
			WebObjectUtil.clickAndVerifyElement(Account.getNav_PhoneNumberLink(), Account.getNav_PhoneNumberTextBox());
			
			//Input the New data and Save the details
			String sNewPhoneNumber = (String)FrameworkUtil.dictPropertyData.get("NAV.ACCOUNT.NEWPHONENUMBER");
			String sNewPhoneExtension = (String)FrameworkUtil.dictPropertyData.get("NAV.ACCOUNT.NEWPHONEEXTENSION");
			navAddEditPhoneNummber(sNewPhoneNumber,sNewPhoneExtension);
			
			//Reset the data to old data and Save details
			String sOldPhoneNumber = (String)FrameworkUtil.dictPropertyData.get("NAV.ACCOUNT.OLDPHONENUMBER");
			String sOldPhoneExtension = (String)FrameworkUtil.dictPropertyData.get("NAV.ACCOUNT.OLDPHONEEXTENSION");
			navAddEditPhoneNummber(sOldPhoneNumber,sOldPhoneExtension);
			
			//Logout of the application
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("Method:AddEditPhoneNumbers, Error MSG :" + e.getMessage());
		}

	}
	
    /*==============================================================
	Test Script Name: navAddEditPhoneNummber
	Description		: This Method will Add and Edit the Phone Number under Phone Number section  
	Author 			: Praveen K
	Creation Date 	: 12/29/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public void navAddEditPhoneNummber(String sPhoneNumber, String sPhoneExtension)
	{
		//Enter Phone Number
		WebObjectUtil.SetValueEdit(Account.getNav_PhoneNumberTextBox(), sPhoneNumber);
		
		//Enter Phone Extension
		WebObjectUtil.SetValueEdit(Account.getNav_PhoneExtensionTextBox(), sPhoneExtension);
		
		//Click on Save Button
		WebObjectUtil.clickElement(Account.getNav_SaveButton());
		
		//Verify the Saved success message
		WebObjectUtil.verifyElementPresent(Account.getNav_SavedSuccessMessage());
	}
	
	/*==============================================================
	Test Script Name: ChangeReminder
	Manual TestCase	: Change Reminder
	Description		: This Test will Change the existing data in Reminder section and updates to the old data
	Author 			: Praveen K
	Creation Date 	: 12/29/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=8)
	public void ChangeReminder() 
	{
		try {
			FrameworkUtil.sTestCaseName = "AccountChangeReminder";
			FrameworkUtil.sManualTestCaseName="Change Reminder";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			//Navigating to Account Settings screen
			navAccount();
			
			//Verify the Password screen displayed or not 
			WebObjectUtil.clickAndVerifyElement(Account.getNav_PasswordLink(), Account.getNav_CurrentPasswordTextBox());
			
			//Input the New data and Save the details
			String sNewReminderQuestion = (String)FrameworkUtil.dictPropertyData.get("NAV.ACCOUNT.LIST.BYVALUE.NEWREMINDERQUESTION");
			String sNewReminderAnswer = (String)FrameworkUtil.dictPropertyData.get("NAV.ACCOUNT.NEWREMINDERANSWER");
			navChangeReminder(sNewReminderQuestion,sNewReminderAnswer);
			
			//Reset the data to old data and Save details
			String sOldReminderQuestion = (String)FrameworkUtil.dictPropertyData.get("NAV.ACCOUNT.LIST.BYVALUE.OLDREMINDERQUESTION");
			String sOldReminderAnswer = (String)FrameworkUtil.dictPropertyData.get("NAV.ACCOUNT.OLDREMINDERANSWER");
			navChangeReminder(sOldReminderQuestion,sOldReminderAnswer);
			
			//Logout of the application
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("Method:ChangeReminder, Error MSG :" + e.getMessage());
		}

	}
	
	/*==============================================================
	Method Name		: navChangeReminder
	Description		: This Method will Change the Reminder question and Answer details   
	Author 			: Praveen K
	Creation Date 	: 12/29/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public void navChangeReminder(String sReminderQuestion, String sReminderAnswer)
	{
		//Select the Reminder Question from drop down
		WebObjectUtil.selectWebList(Account.getNav_ReminderQuestionListBox(), null, sReminderQuestion, null);
		
		//Enter the Reminder Answer
		WebObjectUtil.SetValueEdit(Account.getNav_ReminderAnswerTextBox(), sReminderAnswer);
		
		//Click on Save Button
		WebObjectUtil.clickElement(Account.getNav_SaveButton());
		
		//Verify the Saved success Message
		WebObjectUtil.verifyElementPresent(Account.getNav_SavedSuccessMessage());
	}
	
	
	//update each @test result in custom result file
	@AfterMethod
	public static void afterEachMethod(){
		FrameworkUtil.updateTestCaseStatusinResult();
		
	}
	
	
}
