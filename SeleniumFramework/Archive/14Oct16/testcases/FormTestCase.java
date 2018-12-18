package com.whs.navigator.testcases;

import java.util.List;

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
import com.whs.navigator.pagefactory.CommonPageFactory;
import com.whs.navigator.pagefactory.DraasPageFactory;
import com.whs.navigator.pagefactory.EM7PageFactory;
import com.whs.navigator.pagefactory.EntityBrowserPageFactory;
import com.whs.navigator.pagefactory.FormPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.SmokeTestPageFactory;
import com.whs.navigator.pagefactory.TicketPageFactory;

public class FormTestCase {
	
	        public static HomePageFactory_old Home = new HomePageFactory_old();
			public static EntityBrowserPageFactory EBPanel = new EntityBrowserPageFactory();
			public static SmokeTestPageFactory SmokeTest = new SmokeTestPageFactory();
			public static FormPageFactory Form = new FormPageFactory();
			public static CommonPageFactory Common = new CommonPageFactory();
			public static DraasPageFactory DRaaS = new DraasPageFactory();
			public static EM7PageFactory EM7 = new EM7PageFactory();
			public static NavigatorCommonMethods Nav_CommonMethod = new NavigatorCommonMethods();
			public static TicketPageFactory Ticket = new TicketPageFactory();
			
			public static int iDelete = 0;
			
	//------------Talon------------------------------------------------------------
			
 /*==============================================================
TestScript 		: valPhoneNumberAndEmailAddFormat
Manual TestCase	: QAT-520,QAT-527
Description		: Verify the phone number and email address format.
Author 			: QAA04
Creation Date 	: 06/13/2016
Release Name    : Talon
Pre-Requisites	:
Revision History:
// this test case is already covered by sukur babu
==============================================================*/
 @Test(priority=1)
	public void valPhoneNumberAndEmailAddFormat(){
		String sOrgName,sFeedBackMsg,sErrorMsg,sFormName;
		boolean bStatus;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Form);
		
		try {
			FrameworkUtil.sTestCaseName="valPhoneNumberAndEmailAddFormat";
			FrameworkUtil.sManualTestCaseName="(QAT-520)(QAT-527) Talon - Verify the phone number and email address format.";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to the navigator
			LoginTestCase_Old1.LoginAsQaautoAUser();

            // navigating to the forms page.
			FormTestCase.navToFormsPage();
			sFormName = "Contact Information";
			// navigate to incomplete forms page.
			getSalesOrderByFormName(sFormName);
			
			// clicking on the form arrow icon
		//	clickOnFormsArrowIcon(sFormName);
			
			WebObjectUtil.clickElement(Form.getNav_ContactInfoAddContactLink());
			WebObjectUtil.explicitWait(3);
			    
			fillContactInfoEditFields(1,"Selenium", "Test", "SeleniumTest@gmail.com", "United States (+1)","9874561230", "12345.0", "United States (+1)", "9197651234", "Do not contact for escalation", "Data Center Access Only", true);
			
		  // verify the phone number format
			verifyPhoneNumberFormat(Form.getNav_ContactInfoCellPhoneAreaCodeNumberInput());
			
			// verify email format
			verifyEmailAddressFormat(Form.getNav_ContactInfoEmailInput());
			
			
			/*// clicking on save btn
			WebObjectUtil.clickElement(Form.getNav_ContactInfoSaveButton());
			WebObjectUtil.explicitWait(5);
			
			sFeedBackMsg= Form.getNav_FormFeedBackArea().getText();
			sErrorMsg= (String) FrameworkUtil.dictPropertyData.get("NAV.REQUIRED.TESTDATA.SAVE.BUTTON.CLICK.FEEDBACK.MESSAGE");
			// verifying the feed back error msg.
			bStatus = sErrorMsg.contains(sFeedBackMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "validating the feed back error message");
			
			WebObjectUtil.SetValueEdit(Form.getNav_ContactInfoAreaCodePhoneNumberInput(), "9874561230");
			WebObjectUtil.clickElement(Form.getNav_ContactInfoAreaCodePhoneNumberInput());
			WebObjectUtil.clickElement(Form.getNav_ContactInfoEmailInput());
			WebObjectUtil.explicitWait(2);
			
			WebObjectUtil.clickElement(Form.getNav_ContactInfoSaveButton());
			
			sFeedBackMsg= Form.getNav_FormFeedBackArea().getText();
			sErrorMsg= (String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTIMFORMATION.SAVE.BUTTON.SUCCESS.MESSAGE");
			// verifying the feed back error msg.
			bStatus = sErrorMsg.contains(sFeedBackMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "validating the feed back error message");
		*/
		// log out
			LoginTestCase_Old1.nav_Logout();
		
		} catch (Exception e) {
			LoggerUtil.log_type_error("Issue with valPhoneNumberAndEmailAddFormat test case");
			LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage()+"null");
		   }
	 }
 
 
 /*==============================================================
TestScript 		: verifyContactFormPage
Manual TestCase	: QAT-736,
Description		: Verify that user is navigated to Forms 3.0 new contact form page
Author 			: QAA04
Creation Date 	: 05/06/2016
Release Name    : Talon
Pre-Requisites	:
Revision History:
==============================================================*/
  @Test(priority=2)
  public void verifyContactFormPage(){
	  String sFormName;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Form);
        PageFactory.initElements(driver, DRaaS);
        
		try {
			FrameworkUtil.sTestCaseName="verifyContactFormPage";
			FrameworkUtil.sManualTestCaseName="(QAT-736) Talon - Verify that user is navigated to Forms 3.0 new contact form page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			                           
			// login to the navigator
			LoginTestCase_Old1.LoginAsQaautoAUser();

			//navigating to the forms page.
			FormTestCase.navToFormsPage();
			sFormName = "Contact Information";
			// navigate to incomplete forms page.
			getSalesOrderByFormName(sFormName);
			
			// clicking on the form arrow icon
        //	clickOnFormsArrowIcon(sFormName);
			
			WebObjectUtil.explicitWait(3);
          WebObjectUtil.VerifyTextUnderElement(DRaaS.getNav_breadCrumbChain(), "Forms3");
          // verifying the add contact form page.
          WebObjectUtil.verifyElementPresent(Form.getNav_ContactInfoAddContactFormsHeader());
          
          
		   // log out
		   LoginTestCase_Old1.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("Issue with verifyContactFormPage test case");
			LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage()+"null");
		   }	  
  }

  
  /*==============================================================
 	TestScript 		: verifyReviewAndSubmitPage
 	Manual TestCase	: QAT-734,QAT-814,QAT-862,QAT-846,QAT-849,QAT-836
 	Description		: Verify that user is not displayed with Review and Submit button
 	Author 			: QAA04
 	Creation Date 	: 05/06/2016
 	Release Name    : Talon
 	Pre-Requisites	:
 	Revision History:
 	==============================================================*/ 
 	@Test(priority=3)  
 	  public void verifyReviewAndSubmitPage(){
 		int iForms,iFormNumber;
 		String sFormName,sSalesOrder,sFeedBackMsg,sSucessMsg,sFirstName, sLastName, sEmail, sPhoneCountryCodeVisibleText, sPhoneNumber, sExtn, sCellCountryCodeVisibleText, sCellNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText;
     	String sFirstNameValue,sLstNameValue,sEmailValue,sPhoneCountryCode,sPhoneAreaCode,sPhoneExtn,sCellCountryCode,sCellAreaCode,sEscalation,sUserRole;
 		WebElement wFirstName,wLastName,wEmail,wWorkPhoneCountryCodeDropDown,wWorkPhoneAreaCode,wWorkPhoneExtn,wCellCountryCodeDropDown,wCellAreaCode,wEscalationDropdown,wUserRoleDropDown;
 		boolean bStatus,bReviewBtnDisplay;
 		WebDriver driver = WebDriverUtil.getDriver();
 		PageFactory.initElements(driver, Form);
 		
 		try {
 			FrameworkUtil.sTestCaseName="verifyReviewAndSubmitPage";
 			FrameworkUtil.sManualTestCaseName="(QAT-734)(QAT-814)(QAT-862)(QAT-846)(QAT-849)(QAT-836) Talon - Verify that user is not displayed with Review and Submit button";
 			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
 			
 			// login to the navigator
 						LoginTestCase_Old1.LoginAsQaautoAUser();
 						
 						// navigating to the form page
 						FormTestCase.navToFormsPage();
 						sFormName = "Contact Information";
 						sSalesOrder = getSalesOrderByFormName(sFormName);
 				
 				        sFirstName= (String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.FIRSTNAME.EDITFIELD.VALUE");
 				        sLastName=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.LASTNAME.EDITFIELD.VALUE");
 				        sEmail=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.EMAIL.EDITFIELD.VALUE");
 				        sPhoneCountryCodeVisibleText=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.PHONE.COUNTRYCODE.VISIBLE.TEXT");
 				        sPhoneNumber=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.PHONE.NUMBER.EDITFIELD.VALUE");
 				        sExtn=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.PHONE.EXTN.EDITFIELD.VALUE");
 				        sCellCountryCodeVisibleText=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.CELL.COUNTRYCODE.VISIBLE.TEXT");
 				        sCellNumber=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.CELL.NUMBER.EDITFIELD.VALUE");
 				        sEscalationDropDownVisibleText=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.ESCALATION.VISIBLE.TEXT");
 				        sUserRoleDropDownVisibleText=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.USERROLE.VISIBLE.TEXT");

 						WebObjectUtil.clickElement(Form.getNav_ContactInfoAddContactLink());
 						WebObjectUtil.explicitWait(3);
 						
 				        iFormNumber =fillContactInfoEditFields(1,sFirstName, sLastName, sEmail, sPhoneCountryCodeVisibleText, sPhoneNumber, sExtn, sCellCountryCodeVisibleText, sCellNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText, true);
 						WebObjectUtil.explicitWait(3);
 						
 				        WebObjectUtil.clickElement(Form.getNav_ContactInfoSaveButton());
 				        WebObjectUtil.explicitWait(3);
 						sFeedBackMsg= Form.getNav_FormFeedBackArea().getText();
 						sSucessMsg= (String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTIMFORMATION.SAVE.BUTTON.SUCCESS.MESSAGE");
 						// verifying the feed back error msg.
 						bStatus = sSucessMsg.contains(sSucessMsg);
 						FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "validating the feed back sucess message");
 					
 						WebObjectUtil.clickElement(Form.getNav_ContactInfoAddContactLink());
 						WebObjectUtil.explicitWait(3);
 						fillContactInfoEditFields(iFormNumber+1,sFirstName, sLastName, sEmail, sPhoneCountryCodeVisibleText, sPhoneNumber, sExtn, sCellCountryCodeVisibleText, sCellNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText, false);
 						
 						// clicking on save and continue btn
 						WebObjectUtil.clickElement(Form.getNav_ContactInfoSaveAndCOntinueButton());
 						WebObjectUtil.explicitWait(5);
 						 
 						// clicking on contact information link
 						WebObjectUtil.clickElement(Form.getNav_ContactInfoReviewAndSubmitBtn());
 					    WebObjectUtil.explicitWait(7);	
 					    FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Forms URL", "Get Forms url while submit", "done", "Forms URL:" + driver.getCurrentUrl() );
 					   
 					    bReviewBtnDisplay = Form.getNav_ContactInfoReviewAndSubmitBtn().isDisplayed();
 					    FrameworkUtil.updateCustomResultBasedOnStatus(!bReviewBtnDisplay, "verifying Review Submit button not displaying(after submit)");
 						//WebObjectUtil.verifyElementNOTPresent(Form.getNav_ContactInfoReviewAndSubmitBtn());
 						WebObjectUtil.verifyElementPresent(Form.getNav_ReviewAndSubmit_ContactInformationLink());
 						WebObjectUtil.clickElement(Form.getNav_ReviewAndSubmit_ContactInformationLink());
 					    WebObjectUtil.explicitWait(5);
 					    FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Forms URL after submit(contact Info page)", "Get Forms url after submit", "done", "Forms URL:" + driver.getCurrentUrl() );
 					   
 					    contactFormEditFieldDataValidation(1, sFirstName, sLastName, sEmail, sPhoneCountryCodeVisibleText, sPhoneNumber, sExtn, sCellCountryCodeVisibleText, sCellNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText);
 					    contactFormEditFieldDataValidation(2, sFirstName, sLastName, sEmail, sPhoneCountryCodeVisibleText, sPhoneNumber, sExtn, sCellCountryCodeVisibleText, sCellNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText);
 					   
 						// log out 
 						LoginTestCase_Old1.nav_Logout();
 			} catch (Exception e) {
 			LoggerUtil.log_type_error("Issue with verifyReviewAndSubmitPage test case");
 			LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
 			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage()+"null");
 		   }
 		
 	}
 	
  
 	/*==============================================================
	TestScript 		: fillMoreThenOneAddContactForm
	Manual TestCase	: QAT-852
	Description		: verify that new contact form is displayed under the above two filled in forms and user is able to see all the 3 forms
	Author 			: QAA04
	Creation Date 	: 05/13/2016
	Release Name    : Talon
	Pre-Requisites	:
	Revision History:
	==============================================================*/ 
	@Test(priority=4) 
	public void fillMoreThenOneAddContactForm(){
		int iForms,iFormNumber,iFormNum;
		String sFormName,sSalesOrder,sFeedBackMsg,sSucessMsg,sFirstName, sLastName, sEmail, sPhoneCountryCodeVisibleText, sPhoneNumber, sExtn, sCellCountryCodeVisibleText, sCellNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Form);
		
		try {
			FrameworkUtil.sTestCaseName="fillMoreThenOneAddContactForm";
			FrameworkUtil.sManualTestCaseName="(QAT-852) Talon - verify that new contact form is displayed under the above two filled in forms and user is able to see all the 3 forms";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to the navigator
			LoginTestCase_Old1.LoginAsQaautoAUser();
			
			// navigating to the form page
			FormTestCase.navToFormsPage();
			sFormName = "Contact Information";
			
			
		    getSalesOrderByFormName(sFormName);
			
			
			 sFirstName= (String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.FIRSTNAME.EDITFIELD.VALUE");
		        sLastName=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.LASTNAME.EDITFIELD.VALUE");
		        sEmail=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.EMAIL.EDITFIELD.VALUE");
		        sPhoneCountryCodeVisibleText=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.PHONE.COUNTRYCODE.VISIBLE.TEXT");
		        sPhoneNumber=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.PHONE.NUMBER.EDITFIELD.VALUE");
		        sExtn=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.PHONE.EXTN.EDITFIELD.VALUE");
		        sCellCountryCodeVisibleText=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.CELL.COUNTRYCODE.VISIBLE.TEXT");
		        sCellNumber=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.CELL.NUMBER.EDITFIELD.VALUE");
		        sEscalationDropDownVisibleText=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.ESCALATION.VISIBLE.TEXT");
		        sUserRoleDropDownVisibleText=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.USERROLE.VISIBLE.TEXT");

		        
				WebObjectUtil.clickElement(Form.getNav_ContactInfoAddContactLink());
			    WebObjectUtil.explicitWait(3);
			    
		        iFormNum=1;
		        iFormNumber =fillContactInfoEditFields(iFormNum,sFirstName, sLastName, sEmail, sPhoneCountryCodeVisibleText, sPhoneNumber, sExtn, sCellCountryCodeVisibleText, sCellNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText, true);
				WebObjectUtil.explicitWait(3);
			// fillContactInfoEditFields(1,"Selenium", "Test1", "SeleniumTest@gmail.com", "United States (+1)","9874561230", "12345.0", "United States (+1)", "9197651234", "Do not contact for escalation", "Data Center Access Only", true);
		   
				WebObjectUtil.clickElement(Form.getNav_ContactInfoAddContactLink());
			    WebObjectUtil.explicitWait(3);
			    
			    iFormNum = iFormNum+1;
			    iFormNumber = fillContactInfoEditFields(iFormNum,sFirstName, sLastName, sEmail, sPhoneCountryCodeVisibleText, sPhoneNumber, sExtn, sCellCountryCodeVisibleText, sCellNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText, false);
			   // fillContactInfoEditFields(2,"Selenium", "Test2", "SeleniumTest@gmail.com", "United States (+1)","9874561230", "12345.0", "United States (+1)", "9197651234", "Do not contact for escalation", "Data Center Access Only", false);
			  
			    
			   WebObjectUtil.clickElement(Form.getNav_ContactInfoAddContactLink());
			   WebObjectUtil.explicitWait(3);
			   
			   iFormNum = iFormNum+1;
			   fillContactInfoEditFields(iFormNum,sFirstName, sLastName, sEmail, sPhoneCountryCodeVisibleText, sPhoneNumber, sExtn, sCellCountryCodeVisibleText, sCellNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText, false);

			   WebObjectUtil.GetWebElement("name", "firstName", "Contact Form First name field");
			   iForms= WebObjectUtil.iWebElementsCount;
			
			   //iForms =driver.findElements(By.xpath("//div[contains(@id,'contactInfo_')]")).size();
			
			if(iForms==3){
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verifying the forms", "pass", +iForms+" Contact forms are displaying in the page");
			}
			else{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verifying the forms", "fail", +iForms+" Contact forms are displaying in the page");
			}
			// log out
			LoginTestCase_Old1.nav_Logout();
		}  catch (Exception e) {
			LoggerUtil.log_type_error("Issue with fillMoreThenOneAddContactForm test case");
			LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage()+"null");
		   }
	}
	
	/*==============================================================
	TestScript 		: verifyReviewAndSubmitPageForMoreContactForms
	Manual TestCase	: QAT-849
	Description		: Verify that Review and Submit button is not displayed as form is submitted.
	Author 			: QAA04
	Creation Date 	: 05/13/2016
	Release Name    : Talon
	Pre-Requisites	:
	Revision History:
	merged in to test(priority=5) test case.
	==============================================================*/ 
	//@Test(priority=5) 
	public void verifyReviewAndSubmitPageForMoreContactForms(){
		int iForms;
		
		String sFormName,sSalesOrder,sFeedBackMsg,sSucessMsg,sFirstName, sLastName, sEmail, sPhoneCountryCodeVisibleText, sPhoneNumber, sExtn, sCellCountryCodeVisibleText, sCellNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText;
		boolean bStatus;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Form);
		
		try {
			FrameworkUtil.sTestCaseName="verifyReviewAndSubmitPageForMoreContactForms";
			FrameworkUtil.sManualTestCaseName="(QAT-849) Talon - Verify that Review and Submit button is not displayed as form is submitted.";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to the navigator
			LoginTestCase_Old1.LoginAsQaautoAUser();
			
			// navigating to the form page
			FormTestCase.navToFormsPage();
			sFormName = "Contact Information";
			sSalesOrder = getSalesOrderByFormName(sFormName);
			
			// navigating to the form3 page.
		//	navigatingToForm3Page(sSalesOrder, sFormName);
			
			sFirstName= (String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.FIRSTNAME.EDITFIELD.VALUE");
	        sLastName=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.LASTNAME.EDITFIELD.VALUE");
	        sEmail=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.EMAIL.EDITFIELD.VALUE");
	        sPhoneCountryCodeVisibleText=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.PHONE.COUNTRYCODE.VISIBLE.TEXT");
	        sPhoneNumber=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.PHONE.NUMBER.EDITFIELD.VALUE");
	        sExtn=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.PHONE.EXTN.EDITFIELD.VALUE");
	        sCellCountryCodeVisibleText=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.CELL.COUNTRYCODE.VISIBLE.TEXT");
	        sCellNumber=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.CELL.NUMBER.EDITFIELD.VALUE");
	        sEscalationDropDownVisibleText=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.ESCALATION.VISIBLE.TEXT");
	        sUserRoleDropDownVisibleText=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.USERROLE.VISIBLE.TEXT");
			
			WebObjectUtil.clickElement(Form.getNav_ContactInfoAddContactLink());
			WebObjectUtil.explicitWait(3);
			
			fillContactInfoEditFields(1,sFirstName, sLastName, sEmail, sPhoneCountryCodeVisibleText, sPhoneNumber, sExtn, sCellCountryCodeVisibleText, sCellNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText, true);
			WebObjectUtil.explicitWait(3);
			
			/// fillContactInfoEditFields(1,"Selenium", "Test1", "SeleniumTest@gmail.com", "United States (+1)","9874561230", "12345.0", "United States (+1)", "9197651234", "Do not contact for escalation", "Data Center Access Only", false);
			WebObjectUtil.explicitWait(3);
			
	        WebObjectUtil.clickElement(Form.getNav_ContactInfoSaveButton());
			
			sFeedBackMsg= Form.getNav_FormFeedBackArea().getText();
			sSucessMsg= (String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTIMFORMATION.SAVE.BUTTON.SUCCESS.MESSAGE");
			// verifying the feed back error msg.
			bStatus = sSucessMsg.contains(sSucessMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "validating the feed back sucess message");
		
			WebObjectUtil.clickElement(Form.getNav_ContactInfoAddContactLink());
			WebObjectUtil.explicitWait(3);
			fillContactInfoEditFields(2,sFirstName, sLastName, sEmail, sPhoneCountryCodeVisibleText, sPhoneNumber, sExtn, sCellCountryCodeVisibleText, sCellNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText, false);
			WebObjectUtil.explicitWait(3);
			//fillContactInfoEditFields(2,"Selenium", "Test1", "SeleniumTest@gmail.com", "United States (+1)","9874561230", "12345.0", "United States (+1)", "9197651234", "Do not contact for escalation", "Data Center Access Only", false);
			
			// clicking on save and continue btn
			WebObjectUtil.clickElement(Form.getNav_ContactInfoSaveAndCOntinueButton());
			WebObjectUtil.explicitWait(5);
			
			// clicking on contact information link
			//	WebObjectUtil.clickElement(Form.getNav_ContactInfoReviewAndSubmitBtn());
			    WebObjectUtil.explicitWait(5);	
			 
				WebObjectUtil.verifyElementNOTPresent(Form.getNav_ContactInfoReviewAndSubmitBtn());
				WebObjectUtil.verifyElementPresent(Form.getNav_ReviewAndSubmit_ContactInformationLink());
				WebObjectUtil.clickElement(Form.getNav_ReviewAndSubmit_ContactInformationLink());
			    WebObjectUtil.explicitWait(5);
			    contactFormEditFieldDataValidation(1, sFirstName, sLastName, sEmail, sPhoneCountryCodeVisibleText, sPhoneNumber, sExtn, sCellCountryCodeVisibleText, sCellNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText);
			    contactFormEditFieldDataValidation(2, sFirstName, sLastName, sEmail, sPhoneCountryCodeVisibleText, sPhoneNumber, sExtn, sCellCountryCodeVisibleText, sCellNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText);
			   
			
			
			
			// log out 
			LoginTestCase_Old1.nav_Logout();
			
		  }  catch (Exception e) {
			LoggerUtil.log_type_error("Issue with verifyReviewAndSubmitPageForMoreContactForms test case");
			LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage()+"null");
		   }
		}
	
	/*==============================================================
	TestScript 		: verifyReviewAndSubmitPageForRejectedForms
	Manual TestCase	: QAT-848,QAT-818,QAT-733,QAT-730
	Description		: verify that new contact form is displayed under the above two filled in forms and user is able to see all the 3 forms
	Author 			: QAA04
	Creation Date 	: 05/19/2016
	Release Name    : Talon
	Pre-Requisites	:
	Revision History:
	==============================================================*/ 
	@Test(priority=6) 
	public void verifyReviewAndSubmitPageForRejectedForms(){
		int iForms,iFormNumber;
		
		String sFormName,sSalesOrder,sFeedBackMsg,sSucessMsg,sFirstName, sLastName, sEmail, sPhoneCountryCodeVisibleText, sPhoneNumber, sExtn, sCellCountryCodeVisibleText, sCellNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText;
		boolean bStatus,bReviewBtnDisplay;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Form);
		
		try {
			FrameworkUtil.sTestCaseName="verifyReviewAndSubmitPageForRejectedForms";
			FrameworkUtil.sManualTestCaseName="(QAT-848)(QAT-818)(QAT-733)(QAT-730) Talon - Verify that Review and Submit button is not visible to user as the form is submitted";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to the navigator
			LoginTestCase_Old1.LoginAsQaautoAUser();
			
			// navigating to the form page
			FormTestCase.navToFormsPage();
			sFormName = "Contact Information";
			
			// navigate to form3 page.
	       navigateToRejectedForm3Page(sFormName);
			
	       sFirstName= (String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.FIRSTNAME.EDITFIELD.VALUE");
	        sLastName=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.LASTNAME.EDITFIELD.VALUE");
	        sEmail=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.EMAIL.EDITFIELD.VALUE");
	        sPhoneCountryCodeVisibleText=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.PHONE.COUNTRYCODE.VISIBLE.TEXT");
	        sPhoneNumber=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.PHONE.NUMBER.EDITFIELD.VALUE");
	        sExtn=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.PHONE.EXTN.EDITFIELD.VALUE");
	        sCellCountryCodeVisibleText=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.CELL.COUNTRYCODE.VISIBLE.TEXT");
	        sCellNumber=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.CELL.NUMBER.EDITFIELD.VALUE");
	        sEscalationDropDownVisibleText=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.ESCALATION.VISIBLE.TEXT");
	        sUserRoleDropDownVisibleText=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.USERROLE.VISIBLE.TEXT");
			
			WebObjectUtil.clickElement(Form.getNav_ContactInfoAddContactLink());
			WebObjectUtil.explicitWait(3);
	       
	        iFormNumber =fillContactInfoEditFields(1,sFirstName, sLastName, sEmail, sPhoneCountryCodeVisibleText, sPhoneNumber, sExtn, sCellCountryCodeVisibleText, sCellNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText, true);
			WebObjectUtil.explicitWait(3);
			
	        WebObjectUtil.clickElement(Form.getNav_ContactInfoSaveButton());
			
			sFeedBackMsg= Form.getNav_FormFeedBackArea().getText();
			sSucessMsg= (String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTIMFORMATION.SAVE.BUTTON.SUCCESS.MESSAGE");
			// verifying the feed back error msg.
			bStatus = sSucessMsg.contains(sSucessMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "validating the feed back sucess message");
		
			
			WebObjectUtil.clickElement(Form.getNav_ContactInfoAddContactLink());
			WebObjectUtil.explicitWait(3);
			fillContactInfoEditFields(iFormNumber+1,sFirstName, sLastName, sEmail, sPhoneCountryCodeVisibleText, sPhoneNumber, sExtn, sCellCountryCodeVisibleText, sCellNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText, false);
			
			// clicking on save and continue btn
			WebObjectUtil.clickElement(Form.getNav_ContactInfoSaveAndCOntinueButton());
			WebObjectUtil.explicitWait(5);
			

			// clicking on contact information link
				WebObjectUtil.clickElement(Form.getNav_ContactInfoReviewAndSubmitBtn());
			    WebObjectUtil.explicitWait(5);	
			    
			    FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Forms URL", "Get Forms url before submit", "done", "Forms URL:" + driver.getCurrentUrl() );
			    
			    bReviewBtnDisplay = Form.getNav_ContactInfoReviewAndSubmitBtn().isDisplayed();
			    FrameworkUtil.updateCustomResultBasedOnStatus(!bReviewBtnDisplay, "verifying Review Submit button not displaying(after submit)");
				//WebObjectUtil.verifyElementNOTPresent(Form.getNav_ContactInfoReviewAndSubmitBtn());
				WebObjectUtil.verifyElementPresent(Form.getNav_ReviewAndSubmit_ContactInformationLink());
				WebObjectUtil.clickElement(Form.getNav_ReviewAndSubmit_ContactInformationLink());
			    WebObjectUtil.explicitWait(5);
			    contactFormEditFieldDataValidation(1, sFirstName, sLastName, sEmail, sPhoneCountryCodeVisibleText, sPhoneNumber, sExtn, sCellCountryCodeVisibleText, sCellNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText);
			    contactFormEditFieldDataValidation(2, sFirstName, sLastName, sEmail, sPhoneCountryCodeVisibleText, sPhoneNumber, sExtn, sCellCountryCodeVisibleText, sCellNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText);
			   
			
			// log out 
			LoginTestCase_Old1.nav_Logout();
			
		  }  catch (Exception e) {
			LoggerUtil.log_type_error("Issue with verifyReviewAndSubmitPageForMoreContactForms test case");
			LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage()+"null");
		   }
		}
	
 /*==============================================================
	TestScript 		: verifyEM7LoginPage
	Manual TestCase	: QAT-735
	Description		: Verify that user is navigated to old PHP Forms site and is displayed with old Contact form to fill in.
	Author 			: QAA04
	Creation Date 	: 05/20/2016
	Release Name    : Talon
	Pre-Requisites	:
	Revision History:
	==============================================================*/
   @Test(priority=7)
   public void verifyEM7LoginPage(){
	   String sFormName,sFormOrderType;
	   WebDriver driver = WebDriverUtil.getDriver();
	   PageFactory.initElements(driver, Form);
	   
	   try {
		   FrameworkUtil.sTestCaseName="verifyEM7LoginPage";
		   FrameworkUtil.sManualTestCaseName="(QAT-735) Talon - Verify that user is navigated to old PHP Forms site and is displayed with old Contact form to fill in.";
		   FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		   sFormOrderType = (String)FrameworkUtil.dictPropertyData.get("NAV.FORMS.ORDERTYPE.SALESORDER"); 
		   // login to the navigator
		   LoginTestCase_Old1.LoginAsQaautoAUser();
		   
		   // navigating to the forms page.
		   FormTestCase.navToFormsPage();
		   sFormName = "Contact Information";
		 // verify em7 login page.
		  //navigateToEM7Page(sFormName);
		   verifyEM7LoginPagefromFormsPage(sFormName,sFormOrderType);
		 
		   // log out
		   LoginTestCase_Old1.nav_Logout();
	} catch (Exception e) {
		LoggerUtil.log_type_error("Issue with verifyEM7LoginPage test case");
		LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage()+"null");
	   }
   }
   
	
   /*==============================================================
	TestScript 		: verifyContactInformationEditFields
	Manual TestCase	: QAT-836
	Description		: Verify that form is submitted and user is landed on review and submit page agian
	Author 			: QAA04
	Creation Date 	: 05/23/2016
	Release Name    : Talon
	Pre-Requisites	:
	Revision History:
	merged in to test(priority=5) test case.
	==============================================================*/ 
	//@Test(priority=8) 
	public void verifyContactInformationEditFields(){
		int iForms;
		String sFormName,sSalesOrder,sFeedBackMsg,sSucessMsg,sFirstName, sLastName, sEmail, sPhoneCountryCodeVisibleText, sPhoneNumber, sExtn, sCellCountryCodeVisibleText, sCellNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText;
    	String sFirstNameValue,sLstNameValue,sEmailValue,sPhoneCountryCode,sPhoneAreaCode,sPhoneExtn,sCellCountryCode,sCellAreaCode,sEscalation,sUserRole;
		WebElement wFirstName,wLastName,wEmail,wWorkPhoneCountryCodeDropDown,wWorkPhoneAreaCode,wWorkPhoneExtn,wCellCountryCodeDropDown,wCellAreaCode,wEscalationDropdown,wUserRoleDropDown;
		boolean bStatus;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Form);
		
		try {
			
			FrameworkUtil.sTestCaseName="verifyContactInformationEditFields";
			FrameworkUtil.sManualTestCaseName="(QAT-836) Talon - Verify that form is submitted and user is landed on review and submit page agian";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to the navigator
			LoginTestCase_Old1.LoginAsQaautoAUser();
			
			// navigating to the form page
			FormTestCase.navToFormsPage();
			sFormName = "Contact Information";
			sSalesOrder = getSalesOrderByFormName(sFormName);
	
	        sFirstName= (String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.FIRSTNAME.EDITFIELD.VALUE");
	        sLastName=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.LASTNAME.EDITFIELD.VALUE");
	        sEmail=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.EMAIL.EDITFIELD.VALUE");
	        sPhoneCountryCodeVisibleText=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.PHONE.COUNTRYCODE.VISIBLE.TEXT");
	        sPhoneNumber=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.PHONE.NUMBER.EDITFIELD.VALUE");
	        sExtn=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.PHONE.EXTN.EDITFIELD.VALUE");
	        sCellCountryCodeVisibleText=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.CELL.COUNTRYCODE.VISIBLE.TEXT");
	        sCellNumber=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.CELL.NUMBER.EDITFIELD.VALUE");
	        sEscalationDropDownVisibleText=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.ESCALATION.VISIBLE.TEXT");
	        sUserRoleDropDownVisibleText=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.USERROLE.VISIBLE.TEXT");
			
			WebObjectUtil.clickElement(Form.getNav_ContactInfoAddContactLink());
			WebObjectUtil.explicitWait(3);
			
			fillContactInfoEditFields(1,sFirstName, sLastName, sEmail, sPhoneCountryCodeVisibleText, sPhoneNumber, sExtn, sCellCountryCodeVisibleText, sCellNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText, true);
			WebObjectUtil.explicitWait(3);
			
	        WebObjectUtil.clickElement(Form.getNav_ContactInfoSaveButton());
	        WebObjectUtil.explicitWait(3);
			sFeedBackMsg= Form.getNav_FormFeedBackArea().getText();
			sSucessMsg= (String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTIMFORMATION.SAVE.BUTTON.SUCCESS.MESSAGE");
			// verifying the feed back error msg.
			bStatus = sSucessMsg.contains(sSucessMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "validating the feed back sucess message");
		
			WebObjectUtil.clickElement(Form.getNav_ContactInfoAddContactLink());
			WebObjectUtil.explicitWait(3);
			fillContactInfoEditFields(2,sFirstName, sLastName, sEmail, sPhoneCountryCodeVisibleText, sPhoneNumber, sExtn, sCellCountryCodeVisibleText, sCellNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText, false);
			
			// clicking on save and continue btn
			WebObjectUtil.clickElement(Form.getNav_ContactInfoSaveAndCOntinueButton());
			WebObjectUtil.explicitWait(5);
			
			// clicking on contact information link
		//	WebObjectUtil.clickElement(Form.getNav_ReviewAndSubmit_ContactInformationLink());
		    WebObjectUtil.explicitWait(5);	
            
		    contactFormEditFieldDataValidation(1, sFirstName, sLastName, sEmail, sPhoneCountryCodeVisibleText, sPhoneNumber, sExtn, sCellCountryCodeVisibleText, sCellNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText);
		    contactFormEditFieldDataValidation(2, sFirstName, sLastName, sEmail, sPhoneCountryCodeVisibleText, sPhoneNumber, sExtn, sCellCountryCodeVisibleText, sCellNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText);
		   
		
		
			// log out 
			LoginTestCase_Old1.nav_Logout();
			
		  }  catch (Exception e) {
			LoggerUtil.log_type_error("Issue with verifyReviewAndSubmitPageForMoreContactForms test case");
			LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage()+"null");
		   }
		}
	

    /*==============================================================
	TestScript  	: verifyContactFormChanges
	Manual TestCase	: QAT-537-WCP_CPPOC-4503_TC-2.00_Contact Form_Confirm Changes_Colors and Format
	Description		: Confirm the ability to access the Contact Form through WCP.
	Author 			: PRachupalli
	Creation Date 	: 05/06/16
	Pre-Requisites	:
	Revision History:
	
	==============================================================*/
		@Test(priority=1)
		public void verifyContactFormChanges()
		{
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, Ticket);
			PageFactory.initElements(driver, Form);
			PageFactory.initElements(driver, Common);
			try {
				String sToolTipMsgs=(String) FrameworkUtil.dictPropertyData.get("FORM.TOOL.TIP.MESSAGE");
				String sDeleteClr,sActualclr="rgba(255, 255, 255, 1)";
				FrameworkUtil.sTestCaseName = "verifyContactFormChanges";
				FrameworkUtil.sManualTestCaseName="QAT-537-WCP_CPPOC-4503_TC-2.00_Contact Form_Confirm Changes_Colors and Format";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
				//String sFormName="Sales Order 002-99-000247";
				//Commented above line and added below line as searchContactFormSalesOrder accept forms not not sales order by Arul on 7/5/16
				String sFormName = "Contact Information";
				//Login to Navigator
				LoginTestCase_Old1.LoginAsQaautoAUser();
				WebObjectUtil.explicitWait(15);
				/*WebObjectUtil.clickElement(Ticket.getNav_SupportTabLink());
				//WebObjectUtil.explicitWait(5);
				WebObjectUtil.clickElement(Home.getNav_BuildReqMenuLink());*/
				// navigating to the form page
				FormTestCase.navToFormsPage();
				WebObjectUtil.explicitWait(5);
				//searchContactFormSalesOrder(sFormName);
				getSalesOrderByFormName(sFormName);
				
				WebObjectUtil.clickElement(Form.getNav_ContactInfoAddContactLink());
				WebObjectUtil.explicitWait(3);
				
				WebObjectUtil.verifyElementPresent(Form.getNav_EditFormDeleteButton());
				sDeleteClr=Form.getNav_EditFormDeleteButton().getCssValue("color");
				if(sDeleteClr.equalsIgnoreCase(sActualclr))
			//	if(sDeleteClr.contains(sActualclr))
				   {
				   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "" , "", "pass", "Displayed color is :"+ sDeleteClr );
				   }
				else
				   {
				   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "" , "", "fail", "Displayed color is :"+ sDeleteClr );
				   }
				WebObjectUtil.verifyElementPresent(Form.getNav_EditFormResetButton());
				WebObjectUtil.clickElement(Form.getNav_EditFormResetButton());
			//	WebObjectUtil.clickElement(Form.getNav_ResetContactFormOkButton());
				WebObjectUtil.explicitWait(2);
				WebObjectUtil.clickElement(Common.getNav_PopUpOKBtn());
				
				WebObjectUtil.clickElement(Form.getNav_ContactInfoSaveButton());
				WebObjectUtil.getToolTipsMsg(Form.getNav_ContactInfoFirstNameInput(), sToolTipMsgs);
				WebObjectUtil.getToolTipsMsg(Form.getNav_ContactInfoLastNameInput(), sToolTipMsgs);
				WebObjectUtil.getToolTipsMsg(Form.getNav_ContactInfoEmailInput(), sToolTipMsgs);
				WebObjectUtil.getToolTipsMsg(Form.getNav_ContactInfoAreaCodePhoneNumberInput(), sToolTipMsgs);
				//WebObjectUtil.iWebElementsCount:Form.getNav_ContactInfoDeleteButton();
				
				List <WebElement> wDeleteBtn =  driver.findElements(By.xpath("//span[text()='Delete']"));
				
				for(WebElement e : wDeleteBtn)
				{
					WebObjectUtil.clickElement(Form.getNav_ContactInfoDeleteButton());
					WebObjectUtil.explicitWait(3);
				}
	
				// log out
				LoginTestCase_Old1.nav_Logout();
			} catch (Exception e) {
				LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
			
			}
			
		}
    
		/*====================================================================================================

	    Method Name       : searchContactFormSalesOrder

	    Description       : It will search for Sales order which have Contact form incomplete

	    Author                  : Vivek Kumar

	    Creation Date     : 04/26/2016

	    Module Name     : Forms

	    Pre-Requisites    :

	    Revision History:



	    ====================================================================================================*/

	    public static String searchContactFormSalesOrder(String sFormName)

	    {

	                WebElement wSalesOrder, wIncompleteForms,wContinueImg;

	                String sIncompleteForms,sSalesOrderNumber = null,sFormsname;

	                int iRowCnt,iSalesPortletCnt;

	                boolean bFlag=false;

	               

	                WebDriver driver = WebDriverUtil.getDriver();

	                PageFactory.initElements(driver, Form);

	               

	          try {

	                //Getting the list of All Sales Order block

	                List<WebElement> webListItems = Form.getNav_SalesOrderPortlet();

	                iSalesPortletCnt=webListItems.size();

	               

	                //iterate through all and looking for Sales Order Which have Contact Info form

	                for(int i=1;i<=iSalesPortletCnt;i++)

	                {

	                      wIncompleteForms=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.FORMS.INCOMPLETEFORMS", "PARAMETER_ROWNUMBER", i+"");

	                      sIncompleteForms=wIncompleteForms.getText();

	                      //Looking for Sales order which have at least 1 incomplete form

	                      if(!sIncompleteForms.contains("0"))

	                      {

	                            wSalesOrder=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.FORMS.SALESORDER.LINK", "PARAMETER_ROWNUMBER", i+"");

	                            //Capturing the Sales Order value

	                            sSalesOrderNumber=wSalesOrder.getText();

	                            //Clicking on Sales Order

	                            WebObjectUtil.clickElement(wSalesOrder);

	                            WebObjectUtil.explicitWait(2);

	                            //Clicking on Incomplete Form Block

	                            WebObjectUtil.clickElement(Form.getNav_IncompleteFormBlk());

	                           

	                            //Load table for Incomplete list
	                       if(WebObjectUtil.isElementPresent(Form.getNav_IncompleteFormsTable())){
	                            CustomWebElementUtil.loadCustomElement(Form.getNav_IncompleteFormsTable(), "table");

	                            //Get the row count

	                            iRowCnt=CustomWebElementUtil.iRowCount;

	                            //looping through incomplete form table

	                            for(int j=1;j<=iRowCnt;j++)

	                            {

	                                  //Getting the Form name and verifying with sFormName

	                                  sFormsname=CustomWebElementUtil.getCellData(j, 1);

	                                  if(sFormsname.equalsIgnoreCase(sFormName))

	                                  {

	                                        //Clicking on Continue image

	                                        wContinueImg=CustomWebElementUtil.getRowAsWebElement(j).findElement(By.xpath("//a/img[contains(@src,'Continue')]"));

	                                        WebObjectUtil.clickElement(wContinueImg);

	                                        bFlag=true;

	                                        break;

	                                  }

	                                  else

	                                  {

	                                        sSalesOrderNumber=null;

	                                  }

	                            }

	                      }

	                            if(bFlag)

	                            {

	                                  break;

	                            }

	                            else

	                            {

	                                  WebDriverUtil.getDriver().navigate().back();

	                                  WebObjectUtil.explicitWait(5);

	                            }

	                      }

	                }

	                if(sSalesOrderNumber==null)

	                {

	                      FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Looking for "+sFormName , "fail",sFormName+" not found");

	                }

	          } catch (Exception e) {

	                String sCurrentMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();

	                LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);

	                FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName ,sCurrentMethodName, "warn", "catch block:" +e.getMessage());

	          }

	         

	          return sSalesOrderNumber;

	         

	    }
	 
 	
 
 /*==============================================================
 MethodName 		: verifyEmailAddressFormat
 Manual TestCase	: 
 Description		:
 Author 			: QAA04
 Creation Date 	: 05/17/2016
 release Name    : 
 Pre-Requisites	:
 Revision History:
 ==============================================================*/
 public static void verifyEmailAddressFormat(WebElement wEditField){
 	
 	try {
 		
 		String sEmail;
 		boolean bStatus=false;
 		String sEmailPattern = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
 		
 		sEmail = wEditField.getAttribute("value");
 		bStatus = sEmail.matches(sEmailPattern);
 		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the format");
 	} catch (Exception e) {
 		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
 	}
 }

 
 /*==============================================================
 MethodName 		: verifyPhoneNumberFormat
 Manual TestCase	: 
 Description		:
 Author 			: QAA04
 Creation Date 	: 05/11/2016
 release Name    : 
 Pre-Requisites	:
 Revision History:
 ==============================================================*/
 public static void verifyPhoneNumberFormat(WebElement wEditField){
 	
 	try {
 		//String phone = "123-456-9999";
 		String sPhone;
 		boolean bStatus=false;
 		String sPhoneNumberPattern = "(\\d-)?\\d{3}-?\\d{3}-\\d{4}";
 		//String sPhoneNumberPattern = "\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}";
 		sPhone = wEditField.getAttribute("value");
 		bStatus = sPhone.matches(sPhoneNumberPattern);
 		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the format");
 	} catch (Exception e) {
 		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
 	}	
 }
 /*==============================================================
 MethodName 		: navigateToEM7Page
 Manual TestCase	: 
 Description		:
 Author 			: QAA04
 Creation Date 	: 05/23/2016
 release Name    : 
 Pre-Requisites	:
 Revision History: Method name is changed and updated with form order type parameter and form header name validation
 by QAA03
 ==============================================================*/
 //public void navigateToEM7Page(String sFormName){
 public static void verifyEM7LoginPagefromFormsPage(String sFormName,String sFormOrderType){
 	WebElement wSalesOrderLink,wContinueImg;
 	int iSalesOrderCount,iRowCnt = 0;
 	String sFormsname,sFormStatus,sSalesOrderNumber;
 	boolean bStatus = false;
 	WebDriver driver = WebDriverUtil.getDriver();
 	PageFactory.initElements(driver, Form);
 	PageFactory.initElements(driver, EM7);
 	
 	try {
 		//Getting the list of All Sales Order block
 		List<WebElement> webListItems = Form.getNav_SalesOrderPortlet();
 		iSalesOrderCount=webListItems.size();
 		
 		//iterate through all and looking for Sales Order Which have Contact Info form
 		for(int i=1;i<=iSalesOrderCount;i++)
 		{
 			wSalesOrderLink=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.FORMS.SALESORDER.LINK", "PARAMETER_ROWNUMBER", i+"");
 			WebObjectUtil.scrollElementAtPageCenter(wSalesOrderLink);
 			sSalesOrderNumber = wSalesOrderLink.getText();
 			
 			if(sSalesOrderNumber.contains(sFormOrderType))
 	{
 			WebObjectUtil.clickElement(wSalesOrderLink);
 			WebObjectUtil.explicitWait(4);
 			//Clicking on Incomplete Form Block
 			WebObjectUtil.clickElement(Form.getNav_IncompleteFormBlk());
 			
 			try {
				iRowCnt=0;
				//Load table for Incomplete list
				if (WebObjectUtil.isElementPresent(Form.getNav_IncompleteFormsTable())){
				CustomWebElementUtil.loadCustomElement(Form.getNav_IncompleteFormsTable(), "table");
				//Get the row count 
				iRowCnt=CustomWebElementUtil.iRowCount;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println( sSalesOrderNumber + " might not have any forms, catch block : " + e.getMessage() );
			}
 			if(iRowCnt>1)
 			{
 				for(int j=1;j<=iRowCnt;j++)
 				{
 				//Getting the Form name and verifying with sFormName
 				sFormsname=CustomWebElementUtil.getCellData(j, 1);
 				sFormStatus=CustomWebElementUtil.getCellData(j, 3);
 				
 				if(sFormsname.equalsIgnoreCase(sFormName)&& sFormStatus.equalsIgnoreCase("continue"))
 				{
 					bStatus=true;
 					//Clicking on Continue image
 					wContinueImg=CustomWebElementUtil.getRowAsWebElement(j).findElement(By.xpath("//a/img[contains(@src,'Continue')]"));
 					WebObjectUtil.clickElement(wContinueImg);
 					WebObjectUtil.explicitWait(10);
 					WebObjectUtil.switchToWindow(1, "Customer Build Requirements Portal - Login");
 					bStatus = WebObjectUtil.verifyElementPresent(EM7.getEM7_LoginUserID());
 					driver.close();
 					WebObjectUtil.switchToParentWindow();
 					//driver.switchTo().defaultContent();
 					break;
 					
 				}
 				}	
 			}if(bStatus==true){
 				break;
 			}
 			
 	    }
 	
     else{
 				continue;
 		}
 			
 				WebDriverUtil.getDriver().navigate().back();
 				WebObjectUtil.explicitWait(5);	
 		}
 				
 				if(bStatus==false)
 				{
 					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "More than one Incomplete form" , "warn", "No Sales order have more than one incomplete form");
 				}
 		
 	} catch (Exception e) {
 		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
 	}
 }

 /*==============================================================
 MethodName 		: fillContactInfoEditFields
 Manual TestCase	: 
 Description		:
 Author 			: QAA04
 Creation Date 	: 05/10/2016
 release Name    : 
 Pre-Requisites	:
 Revision History:
 ==============================================================*/

 public static int fillContactInfoEditFields(int ContactFormIndex, String sFirstName, String sLastName, String sEmail, String sPhoneCountryCodeVisibleText, String sPhoneNumber, String sExtn,String sCellCountryCodeVisibleText, String sCellNumber, String sEscalationDropDownVisibleText, String sUserRoleDropDownVisibleText,boolean bDeleteExistingForm){
 	boolean bStatus;
 	//int iDelete = 0;
 	WebDriver driver = WebDriverUtil.getDriver();
 	PageFactory.initElements(driver, Form);
 	PageFactory.initElements(driver, Common);
 	try {
 		bStatus = WebObjectUtil.isElementPresent(Form.getNav_ContactInfoFirstNameInput());
 		if(bStatus && bDeleteExistingForm==true){
 			//delete = (List<WebElement>) Form.getNav_ContactInfoDeleteButton().getSize();
 			iDelete = driver.findElements(By.xpath("//span[text()='Delete']")).size();
 			//int iDelete = delete.size();
 		    
 			    for(int i=1; i<=iDelete; i++){
 					WebObjectUtil.clickElement(Form.getNav_ContactInfoDeleteButton());
 					WebObjectUtil.explicitWait(3);
 					WebObjectUtil.clickElement(Common.getNav_PopUpOKBtn());
 					WebObjectUtil.explicitWait(5);
 		          }
 			   if(bDeleteExistingForm==true){
 			    WebObjectUtil.clickElement(Form.getNav_ContactInfoAddContactLink());
 			    WebObjectUtil.explicitWait(3);
 			    ContactFormIndex = iDelete+1;
 				fillRequiredFields(ContactFormIndex, sFirstName, sLastName, sEmail, sPhoneCountryCodeVisibleText, sPhoneNumber, sExtn, sCellCountryCodeVisibleText, sCellNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText);
 			   }
 			   }else{
 			//WebObjectUtil.clickElement(Form.getNav_ContactInfoAddContactLink());
 			//WebObjectUtil.explicitWait(5);
 			iDelete = driver.findElements(By.xpath("//span[text()='Delete']")).size();
 			fillRequiredFields(ContactFormIndex, sFirstName, sLastName, sEmail, sPhoneCountryCodeVisibleText, sPhoneNumber, sExtn, sCellCountryCodeVisibleText, sCellNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText);
 		}
 	} catch (Exception e) {
 		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
 		}
 	return iDelete+1;
 	
 }
 /*==============================================================
 MethodName 		: navigateToRejectedForm3Page
 Manual TestCase	: 
 Description		:
 Author 			: QAA04
 Creation Date 	: 05/20/2016
 release Name    : 
 Pre-Requisites	:
 Revision History:
 ==============================================================*/
 public static void navigateToRejectedForm3Page(String sRejectedFormName){
 	int iRow;
 	WebElement wFormName,wExpander,wForm3Link;
 	String sFormName;
 	WebDriver driver = WebDriverUtil.getDriver();
 	PageFactory.initElements(driver, Form);
 	
 	try {
 		CustomWebElementUtil.loadCustomElement(Form.getNav_RejectdFormWebTableParent(), "table");
 		iRow = CustomWebElementUtil.iRowCount;
 		
 		for(int i=1; i<=iRow; i++){
 			
 			wFormName = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.REJECTEDFORM.WEBTABLE.REJECTEDFORM.NAME", "PARAMETER_ROWNUMBER", i+"");
 			sFormName = wFormName.getText();
 			if(sFormName.equalsIgnoreCase(sRejectedFormName)){
 				
 				wExpander = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.REJECTEDFORM.WEBTABLE.REJECTEDFORM.EXPANDER", "PARAMETER_ROWNUMBER", i+"");
 				WebObjectUtil.clickElement(wExpander);
 				WebObjectUtil.explicitWait(5);
 				wForm3Link = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.REJECTEDFORM.WEBTABLE.FORM3PAGE.LINK",  "PARAMETER_ROWNUMBER", i+"");
 			    WebObjectUtil.clickElement(wForm3Link); 
 			    WebObjectUtil.explicitWait(5);
 			    WebObjectUtil.verifyElementPresent(Form.getNav_ContactInfoAddContactFormsHeader());
 			    break;   
 			}
 			
 			
 		}
 	 } catch (Exception e) {
 		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
 	}
 	
 	
 }

 /*==============================================================
 MethodName 		: fillRequiredFields
 Manual TestCase	: 
 Description		:
 Author 			: QAA04
 Creation Date 	: 05/12/2016
 release Name    : 
 Pre-Requisites	:
 Revision History:
 ==============================================================*/
 public static void fillRequiredFields(int ContactFormIndex, String sFirstName, String sLastName, String sEmail, String sPhoneCountryCodeVisibleText, String sPhoneNumber, String sExtn,String sCellCountryCodeVisibleText, String sCellNumber, String sEscalationDropDownVisibleText, String sUserRoleDropDownVisibleText){
 	boolean bStatus=false;
 	WebElement wFirstName,wLastName,wEmail,wWorkPhoneCountryCodeDropDown,wWorkPhoneAreaCode,wWorkPhoneExtn,wCellCountryCodeDropDown,wCellAreaCode,wEscalationDropdown,wUserRoleDropDown;
 	WebDriver driver = WebDriverUtil.getDriver();
 	PageFactory.initElements(driver, Form);

 	try {
 	   /*if(ContactFormIndex == true){
 		  ContactFormIndex = iDelete+1;
 	   }*/
 		//WebObjectUtil.clickElement(Form.getNav_ContactInfoFirstNameInput());
 		wFirstName = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.CONTACTINFORMATION.FORM3.FIRSTNAME.EDITFIELD", "PARAMETER_FORMNUMBER", ContactFormIndex+"");
 		//sFirstName = sFirstName + ContactFormIndex;
 		WebObjectUtil.SetValueEdit(wFirstName, sFirstName);
 		
 		wLastName = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.CONTACTINFORMATION.FORM3.LASTNAME.EDITFIELD", "PARAMETER_FORMNUMBER", ContactFormIndex+"");
 		WebObjectUtil.SetValueEdit(wLastName, sLastName);
 		
 		wEmail = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.CONTACTINFORMATION.FORM3.EMAIL.EDITFIELD", "PARAMETER_FORMNUMBER", ContactFormIndex+"");
 		WebObjectUtil.SetValueEdit(wEmail, sEmail);
 		
 		wWorkPhoneCountryCodeDropDown = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.CONTACTINFORMATION.FORM3.WORKPHONE.COUNTRYCODE.DROPDOWN.ARROW", "PARAMETER_FORMNUMBER", ContactFormIndex+"");
 		Nav_CommonMethod.SelectElementFromDropDown(wWorkPhoneCountryCodeDropDown, sPhoneCountryCodeVisibleText);
 		
 		wWorkPhoneAreaCode = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.CONTACTINFORMATION.FORM3.WORKPHONE.AREACODE.EDITFIELD", "PARAMETER_FORMNUMBER", ContactFormIndex+"");
 		WebObjectUtil.SetValueEdit(wWorkPhoneAreaCode, sPhoneNumber);
 		  
 		wWorkPhoneExtn = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.CONTACTINFORMATION.FORM3.WORKPHONE.EXTN.EDITFIELD", "PARAMETER_FORMNUMBER", ContactFormIndex+"");
 		WebObjectUtil.SetValueEdit(wWorkPhoneExtn, sExtn);
 		
 		wCellCountryCodeDropDown = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.CONTACTINFORMATION.FORM3.CELLPHONE.COUNTRYCODE.DROPDOWN.ARROW", "PARAMETER_FORMNUMBER", ContactFormIndex+"");
 		Nav_CommonMethod.SelectElementFromDropDown(wCellCountryCodeDropDown, sCellCountryCodeVisibleText);
 		
 		wCellAreaCode = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.CONTACTINFORMATION.FORM3.CELLPHONE.AREACODE.EDITFIELD", "PARAMETER_FORMNUMBER", ContactFormIndex+"");
 		WebObjectUtil.SetValueEdit(wCellAreaCode, sCellNumber);
 		
 		wEscalationDropdown = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.CONTACTINFORMATION.FORM3.ESCALATION.DROPDOWN.ARROW", "PARAMETER_FORMNUMBER", ContactFormIndex+"");
 		Nav_CommonMethod.SelectElementFromDropDown(wEscalationDropdown, sEscalationDropDownVisibleText);
 		
 		wUserRoleDropDown = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.CONTACTINFORMATION.FORM3.USERROLE.DROPDOWN.ARROW", "PARAMETER_FORMNUMBER", ContactFormIndex+"");
 		Nav_CommonMethod.SelectElementFromDropDown(wUserRoleDropDown, sUserRoleDropDownVisibleText);
 		
 		
 		
 		
 		
 /*	//use dynamic pf example //[@id='contactInfo_1']//input[@name='firstName']
 		bStatus = WebObjectUtil.isElementPresent(Form.getNav_ContactInfoFirstNameInput());
 		WebObjectUtil.SetValueEdit(Form.getNav_ContactInfoFirstNameInput(), sFirstName);
 		WebObjectUtil.SetValueEdit(Form.getNav_ContactInfoLastNameInput(), sLastName);
 		WebObjectUtil.SetValueEdit(Form.getNav_ContactInfoEmailInput(), sEmail);
 		WebObjectUtil.SetValueEdit(Form.getNav_ContactInfoAreaCodePhoneNumberInput(), sPhoneNumber);
 		
 		LefCourt_SP2TestCase_NMR.SelectElementFromDropDown(Form.getNav_ContactInfoEscalationDropDownArrow(), sEscalationDropDownVisibleText);
 		LefCourt_SP2TestCase_NMR.SelectElementFromDropDown(Form.getNav_ContactInfoUserRoleDropDownArrow(), sUserRoleDropDownVisibleText);
 */
 	} catch (Exception e) {
 		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
 		}

 }

 
 
 /*====================================================================================================
	Method Name 	: getSalesOrderByFormName
	Description		: It will search for Sales order which have Contact form incomplete
	Author 			: Vivek Kumar
	Creation Date 	: 04/26/2016
	Module Name     : Forms
	Pre-Requisites	: 
	Revision History: This method is updated by adding formsordertype parameter and forms header name validation
	and present in KyleTestCase_SLP file by QAA03

	====================================================================================================*/
	public static String getSalesOrderByFormName(String sFormName)
	{
			WebElement wSalesOrder, wIncompleteForms,wContinueImg;
			String sIncompleteForms,sSalesOrderNumber = null,sFormsname,sFormStatus;
			int iRowCnt=0,iSalesPortletCnt;
			boolean bFlag=false,bContStatus=false;
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, Form);
			
		try {	
			//Getting the list of All Sales Order block
			List<WebElement> webListItems = Form.getNav_SalesOrderPortlet();
			iSalesPortletCnt=webListItems.size();
			
			//iterate through all and looking for Sales Order Which have Contact Info form
			for(int i=1;i<=iSalesPortletCnt;i++)
			{
				wIncompleteForms=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.FORMS.INCOMPLETEFORMS", "PARAMETER_ROWNUMBER", i+"");
				sIncompleteForms=wIncompleteForms.getText();
				//Looking for Sales order which have at least 1 incomplete form
			//	if(!sIncompleteForms.contains("0"))
			//	{
					wSalesOrder=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.FORMS.SALESORDER.LINK", "PARAMETER_ROWNUMBER", i+"");
					WebObjectUtil.scrollElementAtPageCenter(wSalesOrder);
					//Capturing the Sales Order value
					sSalesOrderNumber=wSalesOrder.getText();
					//Clicking on Sales Order
					
					WebObjectUtil.clickElement(wSalesOrder);
					WebObjectUtil.explicitWait(2);
					//Clicking on Incomplete Form Block
					WebObjectUtil.clickElement(Form.getNav_IncompleteFormBlk());
					
					try {
						iRowCnt=0;
						//Load table for Incomplete list
						if (WebObjectUtil.isElementPresent(Form.getNav_IncompleteFormsTable())){
						CustomWebElementUtil.loadCustomElement(Form.getNav_IncompleteFormsTable(), "table");
						//Get the row count 
						iRowCnt=CustomWebElementUtil.iRowCount;
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println( sSalesOrderNumber + " might not have any forms, catch block : " + e.getMessage() );
					}
					if(iRowCnt==0)
					{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "No Incomplete form" , "done","Sales order -"+sSalesOrderNumber+" - Does not have incomplete form");
						WebDriverUtil.getDriver().navigate().back();
						WebObjectUtil.explicitWait(5);
					}
					else
					{
					
					//looping through incomplete form table
					for(int j=1;j<=iRowCnt;j++)
					{
						//Getting the Form name and verifying with sFormName
						sFormsname=CustomWebElementUtil.getCellData(j, 1);
						sFormStatus=CustomWebElementUtil.getCellData(j, 3);
						if(sFormsname.equalsIgnoreCase(sFormName)&& sFormStatus.equalsIgnoreCase("continue"))
						{
							//Clicking on Continue image
							wContinueImg=CustomWebElementUtil.getRowAsWebElement(j).findElement(By.xpath("//a/img[contains(@src,'Continue')]"));
							//WebObjectUtil.clickElement(wContinueImg);
							bContStatus=WebObjectUtil.isElementPresent(wContinueImg);
							if(bContStatus)
							{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Incomplete form" , "pass","Sales order -"+sSalesOrderNumber+" - have incomplete form");	
								if(navigatingToForm3Page(sSalesOrderNumber, sFormName)){
								bFlag=true;
								break;
								}
							}
							
						}
						/*else
						{
							sSalesOrderNumber=null;
						}*/
					}
					
					if(bFlag)
					{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Looking for "+sFormName , "pass",sFormName+"  found Under -" + sSalesOrderNumber);
						break;
					}
					else
					{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Looking for "+sFormName , "done",sFormName+" not found" + "for Sale Order " +sSalesOrderNumber );
						sSalesOrderNumber=null;
						WebDriverUtil.getDriver().navigate().back();
						WebObjectUtil.explicitWait(5);
					}
				//}
				}
			}
			if(sSalesOrderNumber==null)
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Looking for "+sFormName , "fail",sFormName+" not found");
			}
		} catch (Exception e) {
			String sCurrentMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName ,sCurrentMethodName, "warn", "catch block:" +e.getMessage());
		}
		
		//WebDriverUtil.getDriver().navigate().back();
		//WebObjectUtil.explicitWait(5);
		return sSalesOrderNumber;
		
	}
	
	

	/*==============================================================
	MethodName 		: navigatingToForm3Page
	Manual TestCase	: 
	Description		:
	Author 			: QAA04
	Creation Date 	: 05/02/2016
	release Name    : 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
   public static boolean navigatingToForm3Page(String sSalesOrderNumber, String sFormsName){
	int iRow = 0;
	WebElement wFormName,wFormIcon,wSalesOrderNumber;
	String sFormName,sUrl;
	String[] arrURL;
	boolean bStatus=false;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, Form);
	
	try {
		
		
		if(!WebObjectUtil.isElementPresent(Form.getNav_IncompleteFormBlk())){
			wSalesOrderNumber = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORMS.SALES.ORDER.LINK", "PARAMETER_SALESORDERNAME", sSalesOrderNumber);
			// clicking on sales order number
			WebObjectUtil.clickElement(wSalesOrderNumber);
			//WebObjectUtil.explicitWait(5);
		}
		CustomWebElementUtil.loadCustomElement(Form.getNav_IncompleteFormsTable(), "table");
		iRow = CustomWebElementUtil.iRowCount;
	
		sUrl = driver.getCurrentUrl();
		arrURL = sUrl.split(".com");
		sUrl = arrURL[0] + ".com";
		
		for(int i=1; i<=iRow; i++){
			wFormName=WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORMS.INCOMPLETEFORMS.WEBTABLE.FORM.NAME", "PARAMETER_ROWNUMBER", i+"");
			sFormName = wFormName.getText();
			
			if(sFormName.equalsIgnoreCase(sFormsName)){
				
				wFormIcon = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORMS.INCOMPLETEFORMS.WEBTABLE.FORM.ARROW.ICON", "PARAMETER_ROWNUMBER", i+"");
				// verifying the FormsArrowIcon url against current url
				bStatus = verifyFormsIconUrl(wFormIcon, sUrl);
				if (bStatus){
				WebObjectUtil.clickElement(wFormIcon);
				WebObjectUtil.explicitWait(5);
				WebObjectUtil.verifyElementPresent(Form.getNav_ContactInfoAddContactLink());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Navigate to form3 page", "pass", "Success : Navigated to Form3 page, Current Sales order number: " + sSalesOrderNumber + " and form name : " + sFormsName);
				break;
				}else{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Navigate to form3 page", "warn",  sSalesOrderNumber + " navigates to outside of Navigator(EM7) for form : " + sFormsName );
				//WebObjectUtil.switchToWindow(2, null);
				//verify EM7 login page
				}
			}
			
		}
		
	} catch (Exception e) {
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
	return bStatus;	
}

   /*==============================================================
   MethodName 		: verifyFormsIconUrl
   Manual TestCase	: 
   Description		:
   Author 			: QAA04
   Creation Date 	: 05/06/2016
   release Name    : 
   Pre-Requisites	:
   Revision History:
   ==============================================================*/
   public static boolean verifyFormsIconUrl(WebElement wUrlElement,String sURLToValidate){
   	String sCurrentUrl,sUrl;
   	String[] arrURL;
   	boolean bStatus = false;
   	WebDriver driver = WebDriverUtil.getDriver();
   	PageFactory.initElements(driver, Form);
   	
   	try {
   	//	wUrlElement = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORMS.INCOMPLETEFORMS.WEBTABLE.FORM.ARROW.ICON", "PARAMETER_ROWNUMBER", 1+"");
   		//sUrl = wUrlElement.getAttribute("src");
   		sUrl = wUrlElement.getAttribute("href");
   		// verifying the url
   		bStatus =sUrl.contains(sURLToValidate);
   	//	FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the url");
   	} catch (Exception e) {
   		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
   	}
   	return bStatus;
   	
   }

   
   /*==============================================================
   MethodName 		: navigateToEM7Page
   Manual TestCase	: 
   Description		:
   Author 			: QAA04
   Creation Date 	: 05/23/2016
   release Name    : 
   Pre-Requisites	:
   Revision History:
   ==============================================================*/
    public static void contactFormEditFieldDataValidation(int ContactFormIndex, String sFirstName, String sLastName, String sEmail, String sPhoneCountryCodeVisibleText, String sPhoneNumber, String sExtn,String sCellCountryCodeVisibleText, String sCellNumber, String sEscalationDropDownVisibleText, String sUserRoleDropDownVisibleText){
   	 
   	   String sFirstNameValue,sLstNameValue,sEmailValue,sPhoneCountryCode,sPhoneAreaCode,sPhoneExtn,sCellCountryCode,sCellAreaCode,sEscalation,sUserRole,sReadonly;
   		WebElement wFirstName,wLastName,wEmail,wWorkPhoneCountryCodeDropDown,wWorkPhoneAreaCode,wWorkPhoneExtn,wCellCountryCodeDropDown,wCellAreaCode,wEscalationDropdown,wUserRoleDropDown;
   		boolean bStatus;
   	 
   	 try {
   		/// verifying the first form data
   		    wFirstName = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.CONTACTINFORMATION.FORM3.FIRSTNAME.EDITFIELD", "PARAMETER_FORMNUMBER", ContactFormIndex+"");
   		    bStatus = IsEnabledFormEditField(wFirstName);
   		    validateFormEditFieldData(wFirstName, sFirstName);
   		    
   			wLastName = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.CONTACTINFORMATION.FORM3.LASTNAME.EDITFIELD", "PARAMETER_FORMNUMBER", ContactFormIndex+"");
   			bStatus = IsEnabledFormEditField(wLastName);
   			validateFormEditFieldData(wLastName, sLastName);
   			
   			wEmail = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.CONTACTINFORMATION.FORM3.EMAIL.EDITFIELD", "PARAMETER_FORMNUMBER", ContactFormIndex+"");
   			bStatus = IsEnabledFormEditField(wEmail);
   			validateFormEditFieldData(wEmail, sEmail);
   			
   			wWorkPhoneCountryCodeDropDown =  WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.CONTACTINFORMATION.FORM3.WORKPHONE.COUNTRYCODE.EDITFIELD", "PARAMETER_FORMNUMBER", ContactFormIndex+"");
   			bStatus = IsEnabledFormEditField(wWorkPhoneCountryCodeDropDown);
   			validateFormEditFieldData(wWorkPhoneCountryCodeDropDown, sPhoneCountryCodeVisibleText);
   			
   			wWorkPhoneAreaCode = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.CONTACTINFORMATION.FORM3.WORKPHONE.AREACODE.EDITFIELD", "PARAMETER_FORMNUMBER", ContactFormIndex+"");
   			bStatus = IsEnabledFormEditField(wWorkPhoneAreaCode);
   			validateFormEditFieldData(wWorkPhoneAreaCode, sPhoneNumber);
   						  
   			wWorkPhoneExtn = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.CONTACTINFORMATION.FORM3.WORKPHONE.EXTN.EDITFIELD", "PARAMETER_FORMNUMBER", ContactFormIndex+"");
   			bStatus = IsEnabledFormEditField(wWorkPhoneExtn);
   			validateFormEditFieldData(wWorkPhoneExtn, sExtn);
   						
   			wCellCountryCodeDropDown = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.CONTACTINFORMATION.FORM3.CELL.COUNTRYCODE.EDITFIELD", "PARAMETER_FORMNUMBER", ContactFormIndex+"");
   			bStatus = IsEnabledFormEditField(wCellCountryCodeDropDown);
   			validateFormEditFieldData(wCellCountryCodeDropDown, sCellCountryCodeVisibleText);
   			
   			wCellAreaCode = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.CONTACTINFORMATION.FORM3.CELLPHONE.AREACODE.EDITFIELD", "PARAMETER_FORMNUMBER", ContactFormIndex+"");
   			bStatus = IsEnabledFormEditField(wCellAreaCode);
   			validateFormEditFieldData(wCellAreaCode, sCellNumber);
   			
   			wEscalationDropdown = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.CONTACTINFORMATION.FORM3.ESCALATION.EDITFIELD", "PARAMETER_FORMNUMBER", ContactFormIndex+"");
   			bStatus = IsEnabledFormEditField(wEscalationDropdown);
   			validateFormEditFieldData(wEscalationDropdown, sEscalationDropDownVisibleText);
   			
   			wUserRoleDropDown = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.CONTACTINFORMATION.FORM3.USERROLE.EDITFIELD", "PARAMETER_FORMNUMBER", ContactFormIndex+"");
   			bStatus = IsEnabledFormEditField(wUserRoleDropDown);
   			validateFormEditFieldData(wUserRoleDropDown, sUserRoleDropDownVisibleText);
   			
   	} catch (Exception e) {
   		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
   	}
   	  
    }

    
    /*==============================================================
    MethodName 		: 
    Manual TestCase	: 
    Description		:
    Author 			: QAA04
    Creation Date   	: 05/26/2016
    release Name       : 
    Pre-Requisites  	:
    Revision History   :
    ==============================================================*/
    public static void validateFormEditFieldData(WebElement wEditFieldWebElement, String sFieldExistingData){
   	 String sFirstNameValue;
   	 boolean bStatus = false;
   	 try{
   	 sFirstNameValue = wEditFieldWebElement.getAttribute("value");
   		bStatus = sFieldExistingData.equalsIgnoreCase(sFirstNameValue);
   		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the edit field existing data");
    } catch (Exception e) {
   		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
   	}  
   	 
    }
    
    
    /*==============================================================
    MethodName 		: IsEnabledFormEditField
    Manual TestCase	: 
    Description		:
    Author 			: QAA04
    Creation Date 	: 05/23/2016
    release Name    : 
    Pre-Requisites	:
    Revision History:
    ==============================================================*/
    public static boolean IsEnabledFormEditField(WebElement wDynamicWebElement){
   	 WebElement wFirstName;
   	 String sReadonly;
   	 boolean bStatus = false;
   	 try {
   		//wFirstName = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", sDynamicXpath, "PARAMETER_FORMNUMBER", iDynamicXpathParameter+"");
   		    sReadonly = wDynamicWebElement.getAttribute("readonly");
   		    bStatus = sReadonly.equalsIgnoreCase("readonly");
   		    
   		   FrameworkUtil.updateCustomResultBasedOnStatus(!bStatus, "verifying the edit field is enabled or not");
   	 } catch (Exception e) {
   			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
   		}
   	return bStatus; 
    }
  
	//-------End of Talon release------------------------------------------------------------
			
		//Leftcourt Sp1---------------------------------------------------------------------
			
			/*==============================================================
			TestScript  	: verifyFormsApprovedStatus
			Manual TestCase	: QAT-4
			Description		: Under the Forms Approval Status, confirm the text over the status bar reads "Forms Approved".
			Author 			: QAA04
			Creation Date 	: 05/17/2016
			Pre-Requisites	:
			Revision History:
			==============================================================*/
			@Test(priority=4)
			public static void verifyFormsApprovedStatus(){
				
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, Form);
				
				try {
					FrameworkUtil.sTestCaseName="verifyFormsApprovedStatus";
					FrameworkUtil.sManualTestCaseName="(QAT-4) LefCourtSP1 - Under the Forms Approval Status, confirm the text over the status bar reads Forms Approved.";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
					
					// login to the navigator
					LoginTestCase_Old1.LoginAsQaautoAUser();
					
					// navigate to form page.
					FormTestCase.navToFormsPage();
					
					// verifying the forms approved status
					WebObjectUtil.verifyElementPresent(Form.getNav_FormsApprovalStatus());
					
					// log out
					LoginTestCase_Old1.nav_Logout();
				}catch(Exception e){
						LoggerUtil.log_type_error("Issue with verifyFormsApprovedStatus test case");
						LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage()+"null");
					}
				
				
				
				
			}
			
			
		//End of Lefcourt Sp1---------------------------------------------------
			
			
			/*==============================================================
			TestScript  	: verifyFormsPageDisplay
			Manual TestCase	: [QAT-475] [QAT-476] WCP_4307_TC_1.0_Forms 3.0_Dashboard_Build Requirements(Forms) link under support tab
			Description		: Verify that user is able to navigate to Forms dashboard page when clicks on Build Requirements Forms under support tab
			Author 			: QAA03
			Creation Date 	: 01/21/2016
			Release Name    : LefCourt
			Pre-Requisites	:
			Revision History:
		   ==============================================================*/
			@Test(priority=2)
			public void verifyFormsPageDisplay()
			{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver,Home);
					PageFactory.initElements(driver,EBPanel);
					
				
				try {
					FrameworkUtil.sTestCaseName = "verifyFormsPageDisplay";
					FrameworkUtil.sManualTestCaseName="[QAT-475][QAT-476] WCP_4307_TC_1.0_Forms 3.0_Dashboard_Build Requirements(Forms) link under support tab";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					
					
				    //Login to navigator with efgha user
					LoginTestCase_Old1.LoginAsEfghaUser();
					
					//Navigating to Forms Page
					navToFormsPage();
					
					//Verifying EBPanel is not present in forms page
					WebObjectUtil.verifyElementNOTPresent(EBPanel.getNav_EntityBrowserLink());
					
					//Logout from Navigator
					LoginTestCase_Old1.nav_Logout();
				
				   } catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyFormsPageDisplay", "warn", "catch block:" +e.getMessage());
				}
		    }
			/*==============================================================
			TestScript  	: verifyFeedBackPortletOnFormsPage
			Manual TestCase	: [QAT-472] WCP_3270_TC_1.1_Forms 3.0_Dashboard_Feedback Portlet display on Build Requirements(Forms) page
			Description		: Verify that user is able to view Feedback Portlet on Build Requirements (Forms) page
			Author 			: QAA03
			Creation Date 	: 01/21/2016
			Release Name    : LefCourt
			Pre-Requisites	:
			Revision History:
		   ==============================================================*/
			@Test(priority=3)
			public void verifyFeedBackPortletOnFormsPage()
			{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver,Home);
					PageFactory.initElements(driver,SmokeTest);
					
					
				
				try {
					FrameworkUtil.sTestCaseName = "verifyFeedBackPortletOnFormsPage";
					FrameworkUtil.sManualTestCaseName="[QAT-472]WCP_3270_TC_1.1_Forms 3.0_Dashboard_Feedback Portlet display on Build Requirements(Forms) page";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					
					
				    //Login to navigator with efgha user
					LoginTestCase_Old1.LoginAsEfghaUser();
					
					//Navigating to Forms Page
					navToFormsPage();
					
					//Verifying Feedback Portlet
					WebObjectUtil.verifyElementPresent(Home.getnav_FeedBackBox());
					//Verifying Click here link
					WebObjectUtil.verifyElementPresent(Home.getNav_ClickhereLink());
					WebObjectUtil.explicitWait(5);
				    HomeTestCase.navFeedbackClickhere();
				    WebObjectUtil.explicitWait(5);
					//Clicking on Feedback link
					WebObjectUtil.scrollToElement(SmokeTest.getNav_FeedbackLink());
					WebObjectUtil.explicitWait(5);
					WebObjectUtil.clickElement(SmokeTest.getNav_FeedbackLink());
					WebObjectUtil.explicitWait(5);
					//WebObjectUtil.waitForElementPresent(Home.getNav_CreateTicketPopupWindow());
					//Verifying feedback window 
					WebObjectUtil.verifyElementPresent(Home.getNav_CreateTicketPopupWindow());
					
					//Logout from Navigator
					LoginTestCase_Old1.nav_Logout();
				
				   } catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyFeedBackPortletOnFormsPage", "warn", "catch block:" +e.getMessage());
				}
		    }
			
///____________________ LefCourt test cases _______________________________________________________________ ////
			
			
/*==============================================================
TestScript 		: navVerifyFormsFooter
Manual TestCase	: QAT-430
Description		: Forms Dashboard page is displayed. Verify that the footer of the page
Author 			: QAA04
Creation Date 	: 01/28/2016
Release Name    : Lefcourt
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=1)
public void navVerifyFormsFooter(){
	
	int iSize,i=1;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, Home);	
	
	try {
	//Update results with manual test case name
	FrameworkUtil.sTestCaseName = "navVerifyFormsFooter";
	FrameworkUtil.sManualTestCaseName="(QAT-430) Lefcourt- Forms Dashboard page is displayed. Verify that the footer of the page";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	//Login into Navigator	
      LoginTestCase_Old1.LoginAsEfghaUser();
      
      // navigating to the forms page
      WebObjectUtil.clickElement(Home.getNav_SupportTab());
      WebObjectUtil.clickElement(Home.getNav_BuildReqMenuLink());
      WebObjectUtil.explicitWait(5);
      WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.FOOTER.SECTIONS", "", "");
      iSize = WebObjectUtil.webElementsList.size(); 
      FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying forms footer", "pass", "form footer section count " +iSize);
      
      for (WebElement wb : WebObjectUtil.webElementsList){
    	 String sData = wb.getText(); 
    	  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying forms footer", "pass", ""+i+" Footer section data " +sData);
      i++;
      }
      
      LoginTestCase_Old1.nav_Logout();
	  } catch(Exception e){
  		LoggerUtil.log_type_error("issue with navVerifyFormsFooter test case");
  	    LoggerUtil.log_type_error("Exception occured "+FrameworkUtil.sElementName);
  	   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage());
  	}
 }
			
			
			
			
			
			
//// ______________________ Completed lefcourt test cases _________________________________________________ ////
	
/// _________________________________ Kyle test case _______________________________________________ ///

/*==============================================================
TestScript  	: verifyFormpagehasTicketclickedonTicketNumber
Manual TestCase	: [QAT-1592][1584][1585] WCP_5227_TC_1.6_Forms display on navigator when created through Forms 2.0 manage tab_Left Menu on Forms page
Description		: Verify that when user creates forms through Forms2.0 Manage Tab, those are displayed on Forms 3.0 page and when user lands on the Forms page,
 the left hand menu shows Ticket Number for that Form 
Author 			: QAA03
Creation Date 	: 06/24/2016
Release Name    : Kyle
Pre-Requisites	: 
Revision History:
==============================================================*/

@Test(priority=44)
public void verifyFormpagehasTicketclickedonTicketNumber()
{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Form);
		String sFormName=null,sFormOrderType=null;
	
						
	try {
		FrameworkUtil.sTestCaseName = "Forms-verifyFormpagehasTicketclickedonTicketNumber";
		FrameworkUtil.sManualTestCaseName="[QAT-1592][1584][1585] WCP_5227_TC_1.6_Forms display on navigator when created through Forms 2.0 manage tab_Left Menu on Forms page";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		sFormName=(String)FrameworkUtil.dictPropertyData.get("NAV.FORMS.FORMNAME");
		sFormOrderType = (String)FrameworkUtil.dictPropertyData.get("NAV.FORMS.ORDERTYPE.TICKET");
		
															
	    // Login to navigator with Qaauto-A user
		LoginTestCase_Old1.LoginAsQaautoAUser();
		
		// Navigating to Forms Page
        FormTestCase.navToFormsPage();
        
        // Getting the sales order with order type specified which is having only one incomplete form
        getSalesOrderByFormName(sFormName, sFormOrderType,true);
                  			
		// Logout from Navigator
		LoginTestCase_Old1.nav_Logout();
	
	   } catch (Exception e) {
		LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyFormpagehasTicketclickedonTicketNumber", "warn", "catch block:" +e.getMessage());
	}
}

/*==============================================================
TestScript  	: verifyContactFormCreatedThroughTicketisinReadOnlyformat
Manual TestCase	: [QAT-1593] WCP_5227_TC_1.7_Forms display on navigator when created through Forms 2.0 manage tab_Read Only
Description		: Verify that when user creates forms through Forms2.0 Manage Tab, those are displayed on Forms 3.0 page and when there is only contact form on the ticket, it is navigated to Forms 3.0 Contact Form.
When user completed the form and submits it. Verify that the form is displayed in Read Only mode and uneditable
Author 			: QAA03
Creation Date 	: 07/06/2016
Release Name    : Kyle
Pre-Requisites	: 
Revision History:
==============================================================*/

@Test(priority=55)
public void verifyContactFormCreatedThroughTicketisinReadOnlyformat()
{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Form);
		String sFormName=null,sFormOrderType=null,sFeedBackMsg=null,sSucessMsg=null;
		String sFirstName, sLastName, sEmail, sPhoneCountryCodeVisibleText, sPhoneNumber, sExtn, sCellCountryCodeVisibleText, sCellNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText;
		boolean bDeleteExistingForm=false,bStatus=false,bReviewBtnStatus=false;
		int iFormnumber=0;
	try {
		FrameworkUtil.sTestCaseName = "Forms-verifyContactFormCreatedThroughTicketisinReadOnlyformat";
		FrameworkUtil.sManualTestCaseName="[QAT-1593] WCP_5227_TC_1.7_Forms display on navigator when created through Forms 2.0 manage tab_Read Only";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		sFormName=(String)FrameworkUtil.dictPropertyData.get("NAV.FORMS.FORMNAME");
		sFormOrderType = (String)FrameworkUtil.dictPropertyData.get("NAV.FORMS.ORDERTYPE.TICKET");
		
		sFirstName= (String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.FIRSTNAME.EDITFIELD.VALUE");
        sLastName=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.LASTNAME.EDITFIELD.VALUE");
        sEmail=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.EMAIL.EDITFIELD.VALUE");
        sPhoneCountryCodeVisibleText=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.PHONE.COUNTRYCODE.VISIBLE.TEXT");
        sPhoneNumber=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.PHONE.NUMBER.EDITFIELD.VALUE");
        sExtn=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.PHONE.EXTN.EDITFIELD.VALUE");
        sCellCountryCodeVisibleText=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.CELL.COUNTRYCODE.VISIBLE.TEXT");
        sCellNumber=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.CELL.NUMBER.EDITFIELD.VALUE");
        sEscalationDropDownVisibleText=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.ESCALATION.VISIBLE.TEXT");
        sUserRoleDropDownVisibleText=(String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTINFORMATION.USERROLE.VISIBLE.TEXT");
														
	    // Login to navigator with Qaauto-A user
		LoginTestCase_Old1.LoginAsQaautoAUser();
		
		// Navigating to Forms Page
        FormTestCase.navToFormsPage();
        
        // Getting the sales order with order type specified which is having only one incomplete form
        getSalesOrderByFormName(sFormName, sFormOrderType,true);
              
        
	    
	    iFormnumber =fillContactInfoEditFields(1, sFirstName, sLastName, sEmail, sPhoneCountryCodeVisibleText, sPhoneNumber, sExtn, sCellCountryCodeVisibleText, sCellNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText, bDeleteExistingForm);
	    
	    // verify the phone number formate
		//TalonTestCase_NMR.verifyPhoneNumberFormate(Forms.getNav_ContactInfoCellPhoneAreaCodeNumberInput());
		
		// verify email formate
	    //TalonTestCase_NMR.verifyEmiailAddressFormate(Forms.getNav_ContactInfoEmailInput());
	    
	    
		//include comments if necessary
		WebObjectUtil.scrollToElement(Form.getNav_ContactInfoSaveButton());
        WebObjectUtil.clickElement(Form.getNav_ContactInfoSaveButton());
	    WebObjectUtil.explicitWait(3);
		sFeedBackMsg= Form.getNav_FormFeedBackArea().getText();
		sSucessMsg= (String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTIMFORMATION.SAVE.BUTTON.SUCCESS.MESSAGE");
		// verifying the feed back error message.
		bStatus = sSucessMsg.contains(sSucessMsg);
		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "validating the feed back sucess message");
		
		// clicking on save and continue btn
		WebObjectUtil.clickElement(Form.getNav_ContactInfoSaveAndCOntinueButton());
		
		
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Forms URL", "Get Forms url before submit", "done", "Forms URL:" + driver.getCurrentUrl() );
		    
		WebObjectUtil.verifyElementPresent(Form.getNav_ContactInfoReviewAndSubmitBtn());
		//WebObjectUtil.clickElement(Forms.getNav_ContactInfoReviewAndSubmitBtn());
	    WebObjectUtil.explicitWait(7);	
	 
	    FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Forms URL", "Get Forms url after submit", "done", "Forms URL:" + driver.getCurrentUrl() );
	    
	    bReviewBtnStatus = !Form.getNav_ContactInfoReviewAndSubmitBtn().isDisplayed();
	    FrameworkUtil.updateCustomResultBasedOnStatus(bReviewBtnStatus, "Review And Submit button not displaying(after submit)");
	    //include comments
	    WebObjectUtil.verifyElementPresent(Form.getNav_Forms_ReviewAndSubmit_LeftMenuButton());
	    WebObjectUtil.clickElement(Form.getNav_Forms_ReviewAndSubmit_LeftMenuButton());
	    WebObjectUtil.verifyElementPresent(Form.getNav_Forms_ReviewAndSubmit_LeftMenuWindow());
	    
		WebObjectUtil.verifyElementPresent(Form.getNav_ReviewAndSubmit_ContactInformationLink());
		WebObjectUtil.clickElement(Form.getNav_ReviewAndSubmit_ContactInformationLink());
	    WebObjectUtil.explicitWait(5);
	    contactFormEditFieldDataValidation(1, sFirstName, sLastName, sEmail, sPhoneCountryCodeVisibleText, sPhoneNumber, sExtn, sCellCountryCodeVisibleText, sCellNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText);
	    
		// Logout from Navigator
		LoginTestCase_Old1.nav_Logout();
	
	   } catch (Exception e) {
		LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyContactFormCreatedThroughTicketisinReadOnlyformat", "warn", "catch block:" +e.getMessage());
	}
}

/*==============================================================
TestScript  	: verifyMoreThanOneFormnavigatestoEM7Page
Manual TestCase	: [QAT-1586] WCP_5227_TC_1.2_Forms display on navigator when created through Forms 2.0 manage tab
Description		: Verify that when user creates forms through Forms2.0 Manage Tab, those are displayed on Forms 3.0 page and when there is any other form 
along with contact form on the ticket it is navigated to Forms2.0 
Author 			: QAA03
Creation Date 	: 06/24/2016
Release Name    : Kyle
Pre-Requisites	: 
Revision History:
==============================================================*/

@Test(priority=46)
public void verifyMoreThanOneFormnavigatestoEM7Page()
{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Form);
		String sFormName=null,sFormOrderType=null;
	
						
	try {
		FrameworkUtil.sTestCaseName = "Forms-verifyMoreThanOneFormnavigatestoEM7Page";
		FrameworkUtil.sManualTestCaseName="[QAT-1586] WCP_5227_TC_1.2_Forms display on navigator when created through Forms 2.0 manage tab";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		sFormName=(String)FrameworkUtil.dictPropertyData.get("NAV.FORMS.FORMNAME");
		sFormOrderType = (String)FrameworkUtil.dictPropertyData.get("NAV.FORMS.ORDERTYPE.TICKET");
		
															
	    // Login to navigator with Qaauto-A user
		LoginTestCase_Old1.LoginAsQaautoAUser();
		
		// Navigating to Forms Page
        FormTestCase.navToFormsPage();
        
        // Verifying when more than one incomplete form present, it navigates to EM7 Page
        //getSalesOrderMoreThanOneIncompleteForms(sFormName,sFormOrderType);
        verifyEM7LoginPagefromFormsPage(sFormName,sFormOrderType);
                  			
		// Logout from Navigator
		LoginTestCase_Old1.nav_Logout();
	
	   } catch (Exception e) {
		LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyMoreThanOneFormnavigatestoEM7Page", "warn", "catch block:" +e.getMessage());
	}
}

/*==============================================================
TestScript  	: verifySalesOrderDetailPopUpWindowSorting
Manual TestCase	: [QAT-1511][1501] WCP_5178_TC_1.2_Enhancements to Sales order detail popup_Sort by Details column. 
Description		: On Sales Order detail popup, Verify user is able to sort sales order details by Details column
Author 			: QAA03
Creation Date 	: 06/28/2016
Release Name    : Kyle
Pre-Requisites	: 
Revision History:
==============================================================*/

@Test(priority=47)
public void verifySalesOrderDetailPopUpWindowSorting()
{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Form);
		
						
	try {
		FrameworkUtil.sTestCaseName = "Forms-verifySalesOrderDetailPopUpWindowSorting";
		FrameworkUtil.sManualTestCaseName="[QAT-1511][1501] WCP_5178_TC_1.2_Enhancements to Sales order detail popup_Sort by Details column.";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	
		
		 // Login to navigator with qaauto-A user
		LoginTestCase_Old1.LoginAsQaautoAUser();
							
		// Navigating to Forms Page
        FormTestCase.navToFormsPage();
                          
        //Getting the list of All Sales Order block and clicking on the first sales order link
        clickOnFirstSalesOrderPortletLink();
        
        //Verifying sales order header name in the page
        WebObjectUtil.verifyElementPresent(Form.getNav_FormsSalesOrderSelectedHeaderNameButton());
        
		//Verifying Sales order popup window table detail column sorting
		verifySalesOrderPopUpWindowSorting();
    			
		// Logout from Navigator
		LoginTestCase_Old1.nav_Logout();
	
	   } catch (Exception e) {
		LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifySalesOrderDetailPopUpWindowSorting", "warn", "catch block:" +e.getMessage());
	}
}

/*==============================================================
TestScript  	: validateSalesOrderDetailPopUpWindowDetails
Manual TestCase	: [QAT-1502][1455][1510] WCP_5031_TC_1.0_Forms3.0-Dashboard-Add Sales Order detail to forms dashboard on any Sales Order-Pop up Details. 
Description		: On Sales Order detail popup, Verify user is able to export sales order to PDF and CSV.
Author 			: QAA03
Creation Date 	: 06/29/2016
Release Name    : Kyle
Pre-Requisites	: 
Revision History:
==============================================================*/

@Test(priority=48)
public void validateSalesOrderDetailPopUpWindowDetails()
{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Form);
		
						
	try {
		FrameworkUtil.sTestCaseName = "Forms-validateSalesOrderDetailPopUpWindowDetails";
		FrameworkUtil.sManualTestCaseName="[QAT-1502][1455][1510] WCP_5031_TC_1.0_Forms3.0-Dashboard-Add Sales Order detail to forms dashboard on any Sales Order-Pop up Details";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	
		
		 // Login to navigator with qaauto-A user
		LoginTestCase_Old1.LoginAsQaautoAUser();
							
		// Navigating to Forms Page
        FormTestCase.navToFormsPage();
                          
        // Getting the list of All Sales Order block and clicking on the first sales order link
        clickOnFirstSalesOrderPortletLink();
        
        // Verifying all the fields, icons, table in the sales order popup window
		validateSalesOrderPopUpwindowfields();
    			
		// Logout from Navigator
		LoginTestCase_Old1.nav_Logout();
	
	   } catch (Exception e) {
		LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "validateSalesOrderDetailPopUpWindowDetails", "warn", "catch block:" +e.getMessage());
	}
}


/*==============================================================
TestScript  	: validateSalesOrderDetailPopUpWindowTable
Manual TestCase	: [QAT-1509] WCP_5178_TC_1.0_Enhancements to Sales order detail popup_Expand all checkbox. 
Description		: On Sales Order detail popup, verify all twisties expands and collapses when checked/unchecked expand all checkbox 
Author 			: QAA03
Creation Date 	: 06/29/2016
Release Name    : Kyle
Pre-Requisites	: 
Revision History:
==============================================================*/

@Test(priority=49)
public void validateSalesOrderDetailPopUpWindowTable()
{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Form);
		
						
	try {
		FrameworkUtil.sTestCaseName = "Forms-validateSalesOrderDetailPopUpWindowTable";
		FrameworkUtil.sManualTestCaseName="[QAT-1509] WCP_5178_TC_1.0_Enhancements to Sales order detail popup_Expand all checkbox";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	
		
		 // Login to navigator with qaauto-A user
		LoginTestCase_Old1.LoginAsQaautoAUser();
							
		// Navigating to Forms Page
        FormTestCase.navToFormsPage();
                          
        //Getting the list of All Sales Order block and clicking on the first sales order link
        clickOnFirstSalesOrderPortletLink();
        
        //Verifying the data in the sales order popup window table
		validateSalesOrderPopUpwindowTable();
    			
		// Logout from Navigator
		LoginTestCase_Old1.nav_Logout();
	
	   } catch (Exception e) {
		LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "validateSalesOrderDetailPopUpWindowTable", "warn", "catch block:" +e.getMessage());
	}
}

/*==============================================================
TestScript  	: clickCIMPopUpButtonandValidateDetails
Manual TestCase	: [QAT-1452][1451][1450] WCP_5030_TC_1.3_Forms3.0 Dashboard_My CIM Button UI Display. 
Description		: Verify the UI display for My CIM button on Sales Oder Page. Verify the UI in all browsers. 
Author 			: QAA03
Creation Date 	: 06/30/2016
Release Name    : Kyle
Pre-Requisites	: 
Revision History:
==============================================================*/

@Test(priority=50)
public void clickCIMPopUpButtonandValidateDetails()
{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Form);
		
						
	try {
		FrameworkUtil.sTestCaseName = "Forms-clickCIMPopUpButtonandValidateDetails";
		FrameworkUtil.sManualTestCaseName="[QAT-1452][1451][1450] WCP_5030_TC_1.3_Forms3.0 Dashboard_My CIM Button UI Display";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	
		
		 // Login to navigator with qaauto-A user
		LoginTestCase_Old1.LoginAsQaautoAUser();
							
		// Navigating to Forms Page
        FormTestCase.navToFormsPage();
                          
        //Getting the list of All Sales Order block and clicking on the first sales order link
        clickOnFirstSalesOrderPortletLink();
        // include comments for mycim button
        WebObjectUtil.verifyElementPresent(Form.getNav_Forms_MYCIMButton());
        
        WebObjectUtil.clickElement(Form.getNav_Forms_MYCIMButton());
        
        //Verifying the data in the CIM Popup Window details
		validateCIMPopUpwindowDetails();
    			
		// Logout from Navigator
		LoginTestCase_Old1.nav_Logout();
	
	   } catch (Exception e) {
		LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "clickCIMPopUpButtonandValidateDetails", "warn", "catch block:" +e.getMessage());
	}
}

/*==============================================================
TestScript  	: verifyCIMButtonForSalesOrderinFormsandCompletedOrders
Manual TestCase	: [QAT-318] WCP_5030_TC_1.0_Forms3.0 Dashboard_My CIM Button. 
Description		: Verify that when user clicks on any sales order from incompleted orders or completed orders section, 
user is able to see My CIM button on the sales order page
Author 			: QAA03
Creation Date 	: 07/01/2016
Release Name    : Kyle
Pre-Requisites	: 
Revision History:
==============================================================*/

@Test(priority=51)
public void verifyCIMButtonForSalesOrderinFormsandCompletedOrders()
{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Form);
		
						
	try {
		FrameworkUtil.sTestCaseName = "Forms-verifyCIMButtonForSalesOrderinFormsandCompletedOrders";
		FrameworkUtil.sManualTestCaseName="[QAT-318] WCP_5030_TC_1.0_Forms3.0 Dashboard_My CIM Button.";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	
		
		 // Login to navigator with puppylove user
		LoginTestCase_Old1.LoginAsPuppyloveUser();
							
		// Navigating to Forms Page
        FormTestCase.navToFormsPage();
                          
        //Getting the list of All Sales Order block and clicking on the first sales order link
        clickOnFirstSalesOrderPortletLink();
        
        WebObjectUtil.verifyElementPresent(Form.getNav_Forms_MYCIMButton());
        //include comments
        WebObjectUtil.verifyElementPresent(Form.getNav_FormsBreadCrumb());
        
        WebObjectUtil.clickElement(Form.getNav_FormsBreadCrumb());
        
        // Verifying the sales order in completed orders section has CIM Button
        verifyCIMButtonForSalesOrderinCompletedOrders();
        
        // Logout from Navigator
		LoginTestCase_Old1.nav_Logout();
	
	   } catch (Exception e) {
		LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyCIMButtonForSalesOrderinFormsandCompletedOrders", "warn", "catch block:" +e.getMessage());
	}
}

/*==============================================================
TestScript  	: verifyTicketSalesNumberCreatedinEM7Page
Manual TestCase	: [QAT-1587] WCP_5227_TC_1.3_Forms display on navigator when created through Forms 2.0 manage tab_Create Forms on Forms2.0.
Description		: Verify that user is able to create Forms in Forms2.0 under manage tab. 
Author 			: QAA03
Creation Date 	: 07/05/2016
Release Name    : Kyle
Pre-Requisites	: Steps 1 to 10 are manually executed and created Ticket number "Ticket 070516" 
Steps 11 to 13 are automated 
Revision History:
==============================================================*/

@Test(priority=52)
public void verifyTicketSalesNumberCreatedinEM7Page()
{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Form);
		int iSalesPortletCnt=0,iRowCount=0;
		WebElement wSalesOrder,wRowElement;
		String sSalesOrderNumber=null,sTicketNumber=null,sCompletedSales=null;
		boolean bFlag=false;
						
	try {
		FrameworkUtil.sTestCaseName ="Forms-verifyTicketSalesNumberCreatedinEM7Page";
		FrameworkUtil.sManualTestCaseName="[QAT-1587] WCP_5227_TC_1.3_Forms display on navigator when created through Forms 2.0 manage tab_Create Forms on Forms2.0.";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	
		sTicketNumber =(String) FrameworkUtil.dictPropertyData.get("NAV.FORMS.SALESORDER.TICKETNUMBER.EM7");
		
		 // Login to navigator with qaauto-A user
		LoginTestCase_Old1.LoginAsQaautoAUser();
		
		// Navigating to Forms Page
        FormTestCase.navToFormsPage();
        
        // Search for required Sales Order or Ticket Number in Sales Order Portlet
        searchSalesOrTicketNumberinSalesOrderPortlet(sTicketNumber);
           //is this intentionally commente? If so delete the code if the steps are already available in the method               
        /*List<WebElement> webListItems = Forms.getNav_SalesOrderPortlet();
		iSalesPortletCnt=webListItems.size();
	
		//iterate through all and looking for Sales Order Which required
		for(int i=1;i<=iSalesPortletCnt;i++)
		{
			
				wSalesOrder=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.FORMS.SALESORDER.LINK", "PARAMETER_ROWNUMBER", i+"");
				WebObjectUtil.scrollElementAtPageCenter(wSalesOrder);
				//Capturing the Sales Order value
				sSalesOrderNumber=wSalesOrder.getText();
				
				
				if(sSalesOrderNumber.contains(sTicketNumber))
				{
					bFlag=true;
					break;
				}
				else
				{
					continue;
				}
					
		}
		if(bFlag)
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Ticket Sales Number" , "pass", "Ticket Number present in the InCompleted Sales Order Portlet");
		}
		else
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Ticket Sales Number" , "fail", "Ticket Number not present in the InCompleted Sales Order Portlet and Check under the Completed Sales Orders Section");
		}*/
			   /* CustomWebElementUtil.loadCustomElement(Forms.getNav_Forms_CompletedOrdersSection(), "table");
			    iRowCount = CustomWebElementUtil.iRowCount;
			    
			    for(int i=1;i<=iRowCount;i++)
			    {
			    	wRowElement =CustomWebElementUtil.getRowAsWebElement(i);
			    	sCompletedSales =wRowElement.findElement(By.tagName("a")).getText();
			    	if(sCompletedSales.contains(sTicketNumber))
			    	{
			    		
			    	}
			    	else
			    	{
			    		continue;
			    	}
			    }*/
		
        
        // Logout from Navigator
		LoginTestCase_Old1.nav_Logout();
	
		} catch (Exception e) {
		LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyTicketSalesNumberCreatedinEM7Page", "warn", "catch block:" +e.getMessage());
	}
}
/*==============================================================
TestScript  	: validateTicketNumberinRejectedSectionAndSubmitForm
Manual TestCase	: [QAT-1590] WCP_5227_TC_1.5_Forms display on navigator when created through Forms 2.0 manage tab_Rejected Forms section 
Description		: Verify that when user creates forms through Forms2.0 Manage Tab, and the forms are rejected, the rejected forms appear in Rejected Forms portlet. 
Also, when user clicks on Continue to complete the rejected form verify that user is navigated to Forms3.0 Contact Form page when user has only Contact Form and is navigated to Forms2.0 login page if user has any other form along with Contact Form. 
Author 			: QAA03
Creation Date 	: 07/12/2016
Release Name    : Kyle
Pre-Requisites	: Steps 1 to 7 are manually executed and created Ticket number "Ticket 345678" ,  Steps 8 to 13 are automated
Revision History:
==============================================================*/

@Test(priority=53)
public void validateTicketNumberinRejectedSectionAndSubmitForm()
{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Form);
		String sTicketNumber=null;
		boolean bReviewBtnStatus=false;				
	try {
		FrameworkUtil.sTestCaseName = "Forms-validateTicketNumberinRejectedSectionAndSubmitForm";
		FrameworkUtil.sManualTestCaseName="[QAT-1590] WCP_5227_TC_1.5_Forms display on navigator when created through Forms 2.0 manage tab_Rejected Forms section";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	
		sTicketNumber =(String) FrameworkUtil.dictPropertyData.get("NAV.FORMS.REJECTEDFORM.TICKETNUMBER.QAT1590");
		
		 // Login to navigator with qaauto-A user
		LoginTestCase_Old1.LoginAsQaautoAUser();
							
		// Navigating to Forms Page
        FormTestCase.navToFormsPage();
       
        //Search for required Sales Order or Ticket Number in Rejected Forms Portlet
        searchSalesOrTicketNumberinRejectedFormsPortlet(sTicketNumber);
        
        // Completing the form by clicking on review and submit button for the rejected ticket number 
        //include Comments
        WebObjectUtil.clickElement(Form.getNav_ContactInfoSaveAndCOntinueButton());
        WebObjectUtil.verifyElementPresent(Form.getNav_ContactInfoReviewAndSubmitBtn());
       // WebObjectUtil.clickElement(Forms.getNav_ContactInfoReviewAndSubmitBtn());
        bReviewBtnStatus = !Form.getNav_ContactInfoReviewAndSubmitBtn().isDisplayed();
	    FrameworkUtil.updateCustomResultBasedOnStatus(bReviewBtnStatus, "Review And Submit button not displaying(after submit)");
       
    			
		// Logout from Navigator
		LoginTestCase_Old1.nav_Logout();
	
	   } catch (Exception e) {
		LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "validateTicketNumberinRejectedSectionAndSubmitForm", "warn", "catch block:" +e.getMessage());
	}
}

/*==============================================================
TestScript  	: validateTicketNumberSalesOrderinCompletedSection
Manual TestCase	: [QAT-1588][QAT-1555] WCP_5227_TC_1.4_Forms display on navigator when created through Forms 2.0 manage tab_Completed Orders section
Description		: Verify that when user creates forms through Forms2.0 Manage Tab, and the forms are completed and approved, the Ticket number is displayed in Completed Orders Portlet
Author 			: QAA03
Creation Date 	: 07/11/2016
Release Name    : Kyle/Takashima
Pre-Requisites	: Steps 1 to 7 are manually executed and created Ticket number "Ticket 234567" ,  Steps 8 to 9 are automated
Revision History:
==============================================================*/

@Test(priority=54)
public void validateTicketNumberSalesOrderinCompletedSection()
{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Form);
		String sTicketNumber=null,sCompleteOrderColumn=null,sColumnName=null;
		boolean bColumnStatus;
						
	try {
		FrameworkUtil.sTestCaseName = "Forms-validateTicketNumberSalesOrderinCompletedSection";
		FrameworkUtil.sManualTestCaseName="[QAT-1588][QAT-1555] WCP_5227_TC_1.4_Forms display on navigator when created through Forms 2.0 manage tab_Completed Orders section";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	
		sTicketNumber =(String) FrameworkUtil.dictPropertyData.get("NAV.FORMS.COMPLETEDORDER.TICKETNUMBER.QAT1588");
		sColumnName=(String)FrameworkUtil.dictPropertyData.get("NAV.FORMS.COMPLETEDORDER.COLUMNNAME");
		 // Login to navigator with qaauto-A user
		LoginTestCase_Old1.LoginAsQaautoAUser();
							
		// Navigating to Forms Page
        FormTestCase.navToFormsPage();
        
        if(WebObjectUtil.isElementPresent(Form.getNav_Forms_CompletedOrdersSection()))
  		{
        	sCompleteOrderColumn = Form.getNav_Forms_CompletedOrders_FirstColumn().getText();
             bColumnStatus = sColumnName.contains(sCompleteOrderColumn);
             FrameworkUtil.updateCustomResultBasedOnStatus(bColumnStatus, "Column Name "+sCompleteOrderColumn+" is in Completed Orders Portlet");
             
            // Search for required Sales Order or Ticket Number in Completed order section
             searchSalesOrTicketNumberinCompletedOrderdPortlet(sTicketNumber);
  		}
        else
        {
        	 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Completed Order Portlet", "No Completed Order Portlet", "fail", "NO Completed order portlet is present in forms page");
        }
        
        
    			
		// Logout from Navigator
		LoginTestCase_Old1.nav_Logout();
	
	   } catch (Exception e) {
		LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "validateTicketNumberSalesOrderinCompletedSection", "warn", "catch block:" +e.getMessage());
	}
}








/*====================================================================================================
Method Name 	: getSalesOrderByFormName
Description		: It will search for Sales order with order type passed(either salesorder or ticket) which have Contact form incomplete
Author 			: Vivek Kumar
Creation Date 	: 04/26/2016
Module Name     : Forms
Pre-Requisites	: 
Revision History: Updated with adding FormOrderType parameter and sales order header part by QAA03 0n 06/23/2016

====================================================================================================*/
public static String getSalesOrderByFormName(String sFormName,String sFormOrderType, boolean bNavigatetoForms)
{
		WebElement wSalesOrder, wIncompleteForms,wContinueImg;
		String sIncompleteForms,sSalesOrderNumber = null,sFormsname,sFormStatus,sSelectedFormsSalesOrder=null;
		int iRowCnt=0,iSalesPortletCnt;
		boolean bFlag=false,bContStatus=false,bOrderStatus=false;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Form);
		
	try {	
		//Getting the list of All Sales Order block
		List<WebElement> webListItems = Form.getNav_SalesOrderPortlet();
		iSalesPortletCnt=webListItems.size();
	OuterLoop:
		//iterate through all and looking for Sales Order Which have Contact Info form
		for(int i=1;i<=iSalesPortletCnt;i++)
		{
			wIncompleteForms=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.FORMS.INCOMPLETEFORMS", "PARAMETER_ROWNUMBER", i+"");
			sIncompleteForms=wIncompleteForms.getText();
			//Looking for Sales order which have at least 1 incomplete form
		//	if(!sIncompleteForms.contains("0"))
		//	{
				wSalesOrder=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.FORMS.SALESORDER.LINK", "PARAMETER_ROWNUMBER", i+"");
				WebObjectUtil.scrollElementAtPageCenter(wSalesOrder);
				//Capturing the Sales Order value
				sSalesOrderNumber=wSalesOrder.getText();
				
				//Clicking on Sales Order (or) ticket number depending on FormOrderType passed
				if(sSalesOrderNumber.contains(sFormOrderType))
		{
				WebObjectUtil.clickElement(wSalesOrder);
				WebObjectUtil.explicitWait(2);
				//Clicking on Incomplete Form Block
				WebObjectUtil.clickElement(Form.getNav_IncompleteFormBlk());
				try {
					
					//Load table for Incomplete list
					if (WebObjectUtil.isElementPresent(Form.getNav_IncompleteFormsTable())){
					CustomWebElementUtil.loadCustomElement(Form.getNav_IncompleteFormsTable(), "table");
					//Get the row count 
					iRowCnt=CustomWebElementUtil.iRowCount;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println( sSalesOrderNumber + " might not have any forms, catch block : " + e.getMessage() );
				}
				/*//Load table for Incomplete list
				CustomWebElementUtil.loadCustomElement(Forms.getNav_IncompleteFormsTable(), "table");
				//Get the row count 
				iRowCnt=CustomWebElementUtil.iRowCount;*/
				
				WebObjectUtil.verifyElementPresent(Form.getNav_FormsSalesOrderSelectedHeaderNameButton());
				
				sSelectedFormsSalesOrder = Form.getNav_FormsSalesOrderSelectedHeaderNameButton().getText();
				bOrderStatus = sSelectedFormsSalesOrder.contains(sFormOrderType);
				FrameworkUtil.updateCustomResultBasedOnStatus(bOrderStatus, "Sales Order form selected is "+sSelectedFormsSalesOrder+" and forms count for selected sales order"+iRowCnt);
				
				if(iRowCnt==0)
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "No Incomplete form" , "done","Sales order -"+sSalesOrderNumber+" - Does not have incomplete form");
					WebDriverUtil.getDriver().navigate().back();
					WebObjectUtil.explicitWait(5);
				}
				else
				{
				
				//looping through incomplete form table
				for(int j=1;j<=iRowCnt;j++)
				{
					//Getting the Form name and verifying with sFormName
					sFormsname=CustomWebElementUtil.getCellData(j, 1);
					sFormStatus=CustomWebElementUtil.getCellData(j, 3);
					if(sFormsname.equalsIgnoreCase(sFormName)&& sFormStatus.equalsIgnoreCase("continue"))
					{
						//Clicking on Continue image
						wContinueImg=CustomWebElementUtil.getRowAsWebElement(j).findElement(By.xpath("//a/img[contains(@src,'Continue')]"));
						//WebObjectUtil.clickElement(wContinueImg);
						bContStatus=WebObjectUtil.isElementPresent(wContinueImg);
						if(bContStatus && bNavigatetoForms)
						{
							
							if(navigatingToForm3Page(sSalesOrderNumber, sFormName)){
							bFlag=true;
							break;
							}
						}
						else
						{
							break OuterLoop;
						}
						
					}
					/*else
					{
						sSalesOrderNumber=null;
					}*/
				}
				
				
				if(bFlag)
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Looking for "+sFormName , "pass",sFormName+"  found Under -" + sSalesOrderNumber);
					break;
				}
				else
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Looking for "+sFormName , "done",sFormName+" not found" + "for Sale Order " +sSalesOrderNumber );
					sSalesOrderNumber=null;
					WebDriverUtil.getDriver().navigate().back();
					WebObjectUtil.explicitWait(5);
				}
			//}
			}
		}
				else
				{
					continue;
				}
		}
				
		if(sSalesOrderNumber==null)
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Looking for "+sFormName , "fail",sFormName+" not found");
		}
	} catch (Exception e) {
		String sCurrentMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName ,sCurrentMethodName, "warn", "catch block:" +e.getMessage());
	}
	
	//WebDriverUtil.getDriver().navigate().back();
	//WebObjectUtil.explicitWait(5);
	return sSalesOrderNumber;
	
}

/*====================================================================================================
Method Name       : searchSalesOrTicketNumberinCompletedOrderdPortlet
  Description       : It will search for required Sales Order or Ticket Number in Completed Order Portlet
Author            : QAA03
Creation Date     : 07/11/2016
Module Name       : Forms
Pre-Requisites    :
Revision History  : 
====================================================================================================*/

public static boolean searchSalesOrTicketNumberinCompletedOrderdPortlet(String sSalesOrTicketNumber)

{
            WebElement wSalesElement;
	        String sSalesorderNumber=null;
	        int iRowCount=0;
            boolean bFlag=false;

            WebDriver driver = WebDriverUtil.getDriver();
            PageFactory.initElements(driver, Form);


      try {
do{    
    	   CustomWebElementUtil.loadCustomElement(Form.getNav_Forms_CompletedOrdersSection(), "table");
		   iRowCount = CustomWebElementUtil.iRowCount;
		    
		    for(int i=1;i<=iRowCount;i++)
		    {
		    	// include description
		    	wSalesElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.FORM.COMPLETEDORDERS.SALESORDER", "PARAMETER_ROWNUMBER", ""+i);
		    	sSalesorderNumber = wSalesElement.getText();
		    	if(sSalesorderNumber.contentEquals(sSalesOrTicketNumber))
		    	{
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Search SalesOrder or Ticket Number" ,"pass", "SalesOrder or Ticket number found in the Completed Order Portlet and it is " +sSalesorderNumber);
		    		bFlag=true;
		    		break;
		    	}
		    	else
		    	{
		    		continue;
		    	}

		    } 
		    if(!bFlag)
		    {
		            WebObjectUtil.clickElement(Form.getNav_Forms_CompletedOrders_PageOrdersNextButton());
		    }
		
	}while((!Form.getNav_Forms_CompletedOrders_PageOrdersNextButton().getAttribute("class").contains("disabled"))&&(!bFlag));

          if(!bFlag)
          {
              FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Search SalesOrder or Ticket Number" ,"fail", "SalesOrder or Ticket number not found in the Completed Order Portlet and searched number is " +sSalesOrTicketNumber);
          }
     
      } catch (Exception e) {

            String sCurrentMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();

            LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);

            FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName ,sCurrentMethodName, "warn", "catch block:" +e.getMessage());

      }

      return bFlag;

}

/*====================================================================================================
Method Name       : searchSalesOrTicketNumberinRejectedFormsPortlet
  Description       : It will search for required Sales Order or Ticket Number in Rejected Forms Portlet
Author            : QAA03
Creation Date     : 07/12/2016
Module Name       : Forms
Pre-Requisites    :
Revision History  : 
====================================================================================================*/

public static boolean searchSalesOrTicketNumberinRejectedFormsPortlet(String sSalesOrTicketNumber)

{
            WebElement wRejExpander,wRejFormLink;
	        String sTicketNumber=null;
	        int iRowCount=0;
            boolean bFlag=false;

            WebDriver driver = WebDriverUtil.getDriver();
            PageFactory.initElements(driver, Form);


      try {
    	  
    	  CustomWebElementUtil.loadCustomElement(Form.getNav_RejectdFormWebTableParent(), "table");
    	  iRowCount = CustomWebElementUtil.iRowCount;
  		
  		for(int i=1; i<=iRowCount; i++)
  			
  		{	
  				
  				wRejExpander = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.REJECTEDFORM.WEBTABLE.REJECTEDFORM.EXPANDER", "PARAMETER_ROWNUMBER", i+"");
  				WebObjectUtil.clickElement(wRejExpander);
  				
  				wRejFormLink = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.REJECTEDFORM.WEBTABLE.FORM3PAGE.LINK",  "PARAMETER_ROWNUMBER", i+"");
  			// include description
  				WebObjectUtil.clickElement(wRejFormLink); 
  			    WebObjectUtil.explicitWait(5);
  			    WebObjectUtil.verifyElementPresent(Form.getNav_ContactInfoAddContactFormsHeader());
  			    WebObjectUtil.clickElement(Form.getNav_Forms_ReviewAndSubmit_LeftMenuButton());
  			    WebObjectUtil.verifyElementPresent(Form.getNav_Forms_ReviewAndSubmit_LeftMenuWindow());
  			    sTicketNumber = Form.getNav_Forms_ReviewAndSubmit_LeftMenuWindow_TicketNumber().getText(); 
  			    WebObjectUtil.clickElement(Form.getNav_Forms_ReviewAndSubmit_LeftMenuButton());
  			    
  			    if(sTicketNumber.contentEquals(sSalesOrTicketNumber))
  			    {
  			    	FrameworkUtil.sElementName="Search SalesOrder or Ticket Number";
  			    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Search SalesOrder or Ticket Number" ,"pass", "SalesOrder or Ticket number found in the Rejected forms Portlet and it is " +sTicketNumber);
  			    	bFlag =true;
  			    	break;
  			    }
  			    else
  			    {
  			    	WebDriverUtil.getDriver().navigate().back();
  			    	continue;
  			    }
  			
  		}
  		if(!bFlag)
        {
            FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Search SalesOrder or Ticket Number" ,"fail", "SalesOrder or Ticket number not found in the Rejected forms Portlet and searched number is " +sSalesOrTicketNumber);
        }

      } catch (Exception e) {

            String sCurrentMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();

            LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);

            FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName ,sCurrentMethodName, "warn", "catch block:" +e.getMessage());

      }

      return bFlag;

}

/*====================================================================================================
Method Name       : searchContactFormSalesOrder
  Description       : It will search for required Sales Order or Ticket Number in Sales Order Portlet
Author            : Vivek Kumar
Creation Date     : 04/26/2016
Module Name       : Forms
Pre-Requisites    :
Revision History  : Updated method by changing name "searchSalesOrTicketNumberinSalesOrderPortlet", parameter and return type by QAA03
0n 07/11/2016
====================================================================================================*/

public static boolean searchSalesOrTicketNumberinSalesOrderPortlet(String sSalesOrTicketNumber)

{

            WebElement wSalesOrder, wIncompleteForms;
            String sIncompleteForms,sSalesOrderNumber = null;
            int iRowCnt=0,iSalesPortletCnt=0;
            boolean bFlag=false;

            WebDriver driver = WebDriverUtil.getDriver();
            PageFactory.initElements(driver, Form);


      try {

            //Getting the list of All Sales Order block

            List<WebElement> webListItems = Form.getNav_SalesOrderPortlet();

            iSalesPortletCnt=webListItems.size();

            if(iSalesPortletCnt==0)
            {
            	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "No SalesOrder or Ticket Number" ,"warn", "No SalesOrder or Ticket number present in the Sales Order Portlet");
            }
           

            //iterate through all and looking for required Sales Order or Ticket Number from Sales Order Portlet

            for(int i=1;i<=iSalesPortletCnt;i++)
            {
                  wSalesOrder=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.FORMS.SALESORDER.LINK", "PARAMETER_ROWNUMBER", i+"");

                  //Capturing the Sales Order value
                  sSalesOrderNumber=wSalesOrder.getText();

                  if(sSalesOrderNumber.contains(sSalesOrTicketNumber))
                  {
                	  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Search SalesOrder or Ticket Number" ,"pass", "Sales Order or Ticket number found in the Sales Order portlet and it is" +sSalesOrderNumber);
                	  bFlag=true;
                	  break;
                  }
                  else
                  {
                	  continue;
                  }
            }
            if(!bFlag)
            
            {
            	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Search SalesOrder or Ticket Number" ,"fail", "Sales Order or Ticket number not found in the Sales Order portlet and the searched number is "+sSalesOrTicketNumber);
            }
                       

      } catch (Exception e) {

            String sCurrentMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();

            LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);

            FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName ,sCurrentMethodName, "warn", "catch block:" +e.getMessage());

      }

      return bFlag;

}

/*====================================================================================================
Method Name 	: verifyCIMButtonForSalesOrderinCompletedOrders
Description		: Verifying the sales order in completed orders section has CIM Button
Author 			: QAA03
Creation Date 	: 07/05/2016
Module Name     : Forms
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static void verifyCIMButtonForSalesOrderinCompletedOrders()
{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,Form);
		int iRowCount=0,iSalesRow=0;
		WebElement wSalesElement;
		String sSalesorderName=null,sOrdersPage=null,sOrdersCount[];
		boolean bFlag=false,bCIMStatus;
		int iOrdersCount=0;
 try {
	do
	{
	    		   CustomWebElementUtil.loadCustomElement(Form.getNav_Forms_CompletedOrdersSection(), "table");
				   iRowCount = CustomWebElementUtil.iRowCount;
				    
				    for(int i=1;i<=iRowCount;i++)
				    {
				    	wSalesElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.FORM.COMPLETEDORDERS.SALESORDER", "PARAMETER_ROWNUMBER", ""+i);
				    	sSalesorderName = wSalesElement.getText();
				    	if(sSalesorderName.contains("-"))
				    	{
				    		iSalesRow=i;
				    		bFlag=true;
				    		break;
				    	}
				    	else
				    	{
				    		continue;
				    	}
				    	/*WebObjectUtil.clickElement(wSalesElement);
				    	WebObjectUtil.waitForElementPresent(Forms.getNav_FormsSalesOrderSelectedHeaderNameButton());
				    	sHeaderName = Forms.getNav_FormsSalesOrderSelectedHeaderNameButton().getText();
				    	if(sHeaderName.startsWith("Sales Order"))
				    	{
				    		bCIMStatus =WebObjectUtil.verifyElementPresent(Forms.getNav_Forms_MYCIMButton());
				    		FrameworkUtil.updateCustomResultBasedOnStatus(bCIMStatus, "CIM Button in the sales order page");
				    		bFlag=true;
				    		break;
				    	}
				    	else
				    	{
				    		WebDriverUtil.getDriver().navigate().back();
				    		continue;
				    	}
				    	*/
				    }
				    if(!bFlag)
				    {
	    		            WebObjectUtil.clickElement(Form.getNav_Forms_CompletedOrders_PageOrdersNextButton());
				    }
	    		
	   	}while((!Form.getNav_Forms_CompletedOrders_PageOrdersNextButton().getAttribute("class").contains("disabled"))&&(!bFlag));
	    	
	    	wSalesElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.FORM.COMPLETEDORDERS.SALESORDER", "PARAMETER_ROWNUMBER", ""+iSalesRow);
	    	WebObjectUtil.clickElement(wSalesElement);
	    	WebObjectUtil.waitForElementPresent(Form.getNav_FormsSalesOrderSelectedHeaderNameButton());
	    	bCIMStatus =WebObjectUtil.verifyElementPresent(Form.getNav_Forms_MYCIMButton());
	    	WebDriverUtil.getDriver().navigate().back();
    		FrameworkUtil.updateCustomResultBasedOnStatus(bCIMStatus, "CIM Button in the sales order page");
	    	/*sOrdersPage = Forms.getNav_Forms_CompletedOrders_PageOrdersCount().getText();
	    	sOrdersCount = sOrdersPage.split("");
	    	iOrdersCount = Integer.parseInt(sOrdersCount[1]);
	    	if(iOrdersCount>=2)
	    	{
	    		WebObjectUtil.clickElement(Forms.getNav_Forms_CompletedOrders_PageOrdersNextButton());
	    		
	    	}*/
	    
	
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyCIMButtonForSalesOrderinCompletedOrders", "warn", "catch block:" +e.getMessage());  
	}
 
	
}

/*====================================================================================================
Method Name 	: clickOnFirstSalesOrderPortletLink
Description		: Getting the list of All Sales Order block and clicking on the first sales order link
Author 			: QAA03
Creation Date 	: 06/28/2016
Module Name     : Forms
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static void clickOnFirstSalesOrderPortletLink()
{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,Form);
		String sIncompleteForms=null,sSalesOrderNumber=null;
	    int iSalesPortletCount=0;
	    WebElement wIncompleteForms,wSalesOrder;
		
 try {
	 
	   
	    List<WebElement> webListItems = Form.getNav_SalesOrderPortlet();
		iSalesPortletCount=webListItems.size();
		
		if(iSalesPortletCount>0)
		{
			wIncompleteForms=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.FORMS.INCOMPLETEFORMS", "PARAMETER_ROWNUMBER", 1+"");
			sIncompleteForms=wIncompleteForms.getText();
			
			wSalesOrder=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.FORMS.SALESORDER.LINK", "PARAMETER_ROWNUMBER", 1+"");
			WebObjectUtil.scrollElementAtPageCenter(wSalesOrder);
			//Capturing the Sales Order value
			sSalesOrderNumber=wSalesOrder.getText();
			
			WebObjectUtil.clickElement(wSalesOrder);
			
			
		}
		else
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "No sales order" ,"fail", "No Salesorder portlet present in the forms page");
		}
		
        
 
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "clickOnFirstSalesOrderPortletLink", "warn", "catch block:" +e.getMessage());  
	}
 
	
}

/*====================================================================================================
Method Name 	: validateCIMPopUpwindowDetails
Description		: // include description
Author 			: QAA03
Creation Date 	: 06/30/2016
Module Name     : Forms
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static void validateCIMPopUpwindowDetails()
{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,Form);
		
		
 try {
	    WebObjectUtil.verifyElementPresent(Form.getNav_Forms_MYCIMPopUpWindow());
	    
	    WebObjectUtil.verifyElementPresent(Form.getNav_Forms_MYCIMPopUp_Name());
	    
	    WebObjectUtil.verifyElementPresent(Form.getNav_Forms_MYCIMPopUp_Designation());
	    
	    WebObjectUtil.verifyElementPresent(Form.getNav_Forms_MYCIMPopUp_CIMPhone());
	    
	    WebObjectUtil.verifyElementPresent(Form.getNav_Forms_MYCIMPopUp_TierPointPhone());
	    
	    WebObjectUtil.verifyElementPresent(Form.getNav_Forms_MYCIMPopUp_CIMEmail());
	    
	    WebObjectUtil.verifyElementPresent(Form.getNav_Forms_MYCIMPopUp_SupportEmail());
	    
	    WebObjectUtil.verifyElementPresent(Form.getNav_Forms_MYCIMPopUp_PhoneImage());
	    
	    WebObjectUtil.verifyElementPresent(Form.getNav_Forms_MYCIMPopUp_EmailImage());
	    
       
 
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "validateCIMPopUpwindowDetails", "warn", "catch block:" +e.getMessage());  
	}
}


/*====================================================================================================
Method Name 	: validateSalesOrderPopUpwindowTable
Description		: // include description
Author 			: QAA03
Creation Date 	: 06/29/2016
Module Name     : Forms
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static void validateSalesOrderPopUpwindowTable()
{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,Form);
		WebElement wRowElement;
		String sFirstRowNotExp=null,sFirstRowAfterExp=null;
		boolean bCheckStatus;
		
 try {
	 
	   WebObjectUtil.clickElement(Form.getNav_FormsSalesOrderSelectedHeaderNameButton());
        
       WebObjectUtil.verifyElementPresent(Form.getNav_FormsSalesOrderWindow());
       
       WebObjectUtil.clickElement(Form.getNav_FormsSalesOrderWindowExpandAllCheckbox());
       
       CustomWebElementUtil.loadCustomElement(Form.getNav_FormsSalesOrderWindowWebTable(), "table");
        	                              
       wRowElement = CustomWebElementUtil.getRowAsWebElement(1);
        
       sFirstRowNotExp = wRowElement.getText();
        	                
       WebObjectUtil.clickElement(Form.getNav_FormsSalesOrderWindowExpandAllCheckbox());
        
       CustomWebElementUtil.loadCustomElement(Form.getNav_FormsSalesOrderWindowWebTable(), "table");
        
       wRowElement = CustomWebElementUtil.getRowAsWebElement(1);
        
       sFirstRowAfterExp = wRowElement.getText();
        
       bCheckStatus = !sFirstRowNotExp.contentEquals(sFirstRowAfterExp);
        
       FrameworkUtil.updateCustomResultBasedOnStatus(bCheckStatus, "Expand all Checkbox for Sales Order Popup Window Table");
       
       
 
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "validateSalesOrderPopUpwindowTable", "warn", "catch block:" +e.getMessage());  
	}

}
/*====================================================================================================
Method Name 	: validateSalesOrderPopUpwindowfields
Description		: Verifying all the fields, icons, table in the sales order popup window
Author 			: QAA03
Creation Date 	: 06/29/2016
Module Name     : Forms
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static void validateSalesOrderPopUpwindowfields()
{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,Form);
		
		
 try {
	 
	   WebObjectUtil.clickElement(Form.getNav_FormsSalesOrderSelectedHeaderNameButton());
        
       WebObjectUtil.verifyElementPresent(Form.getNav_FormsSalesOrderWindow());
       
       WebObjectUtil.verifyElementPresent(Form.getNav_FormsSalesOrderPopUpPDFIcon());
       
       WebObjectUtil.verifyElementPresent(Form.getNav_FormsSalesOrderPopUpCSVIcon());
       
       WebObjectUtil.verifyElementPresent(Form.getNav_FormsSalesOrderPopUpHeadername());
       
       WebObjectUtil.verifyElementPresent(Form.getNav_FormsSalesOrderWindowExpandAllCheckbox());
       
       WebObjectUtil.verifyElementPresent(Form.getNav_FormsSalesOrderDetailColumn());
       
       WebObjectUtil.verifyElementPresent(Form.getNav_FormsSalesOrderQuantityColumn());
       
       WebObjectUtil.verifyElementPresent(Form.getNav_FormsSalesOrderWindowWebTable());
       
       
 
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "validateSalesOrderPopUpwindowfields", "warn", "catch block:" +e.getMessage());  
	}
 }

/*====================================================================================================
Method Name 	: verifySalesOrderPopUpWindowSorting
Description		: Verifying Sales order popup window table detail column sorting
Author 			: QAA03
Creation Date 	: 06/28/2016
Module Name     : Forms
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static void verifySalesOrderPopUpWindowSorting()
{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,Form);
		int iRowCount=0;
		WebElement wRowElement;
		String sFirstRowElement=null,sLastRowElement=null;
		boolean bSortStatus;
 try {
	 
	    WebObjectUtil.clickElement(Form.getNav_FormsSalesOrderSelectedHeaderNameButton());
        
        WebObjectUtil.verifyElementPresent(Form.getNav_FormsSalesOrderWindow());
        
        //WebObjectUtil.clickElement(Forms.getNav_FormsSalesOrderWindowExpandAllCheckbox());
        
        WebObjectUtil.clickElement(Form.getNav_FormsSalesOrderDetailColumn());
        
        CustomWebElementUtil.loadCustomElement(Form.getNav_FormsSalesOrderWindowWebTable(), "table");
        
        iRowCount = CustomWebElementUtil.iRowCount;
        
        wRowElement = CustomWebElementUtil.getRowAsWebElement(1);
        
        sFirstRowElement = wRowElement.getText();
        	                
        WebObjectUtil.clickElement(Form.getNav_FormsSalesOrderDetailColumn());
        
        CustomWebElementUtil.loadCustomElement(Form.getNav_FormsSalesOrderWindowWebTable(), "table");
        
        wRowElement = CustomWebElementUtil.getRowAsWebElement(iRowCount);
        
        sLastRowElement = wRowElement.getText();
        
        bSortStatus = sFirstRowElement.contentEquals(sLastRowElement);
        
        FrameworkUtil.updateCustomResultBasedOnStatus(bSortStatus, "Sorting for Sales Order Popup Window Columns");
        
        /*NavigatorCommonMethods.verifyColumnSort(Forms.getNav_FormsSalesOrderDetailColumn(), wRowElement, iRowCount);
        
        WebObjectUtil.clickElement(Forms.getNav_FormsSalesOrderQuantityColumn());
        
        NavigatorCommonMethods.verifyColumnNotSorted(Forms.getNav_FormsSalesOrderQuantityColumn(), wRowElement, iRowCount);*/
        
        
		
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifySalesOrderPopUpWindowSorting", "warn", "catch block:" +e.getMessage());  
	}
 
	
}

/// _______________________________ Completed kyle test cases ____________________________________ ////
/*====================================================================================================
			Method Name 	: navToFormsPage
			Description		: Navigating to Forms Page
			Author 			: QAA03
			Creation Date 	: 01/21/2016
			Pre-Requisites	: 
			Revision History:
			====================================================================================================*/
			public static void navToFormsPage()
			{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver,Home);
					PageFactory.initElements(driver,Form);
					
			 try {
				 if (WebDriverUtil.browser.equalsIgnoreCase("ie")){
						NavigatorCommonMethods.navigateToModuleThroughURL("form");
						return;
					}
				    WebObjectUtil.clickElement(Home.getNav_SupportTab());
				  //WebObjectUtil.clickByJS(Home.getNav_SupportTab());
					WebObjectUtil.clickElement(Home.getNav_BuildReqMenuLink());
					WebObjectUtil.explicitWait(5);
					WebObjectUtil.verifyElementPresent(Form.getNav_FormsPageHeader());
					
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navToFormsPage", "warn", "catch block:" +e.getMessage());  
				}
		}
			@AfterMethod
			public static void afterEachMethod(){
					FrameworkUtil.updateTestCaseStatusinResult();
					//Should be deleted after today's execution by Arul on 7/14/16
					WebDriverUtil.quitWebDriver();	
				}

}
