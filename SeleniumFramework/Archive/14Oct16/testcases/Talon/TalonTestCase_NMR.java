package com.whs.navigator.testcases.Talon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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
import com.whs.navigator.pagefactory.FormPageFactory;

public class TalonTestCase_NMR {
	public static FormPageFactory Form = new FormPageFactory();
	public static DraasPageFactory DRaaS = new DraasPageFactory();
	public static CommonPageFactory Common = new CommonPageFactory();
	public static EM7PageFactory EM7 = new EM7PageFactory();
	
	public static int iDelete = 0;
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
				TalonTestCase_Vivek.getSalesOrderByFormName(sFormName);
				
				// clicking on the form arrow icon
			//	clickOnFormsArrowIcon(sFormName);
				
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
				TalonTestCase_Vivek.getSalesOrderByFormName(sFormName);
				
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
						sSalesOrder = TalonTestCase_Vivek.getSalesOrderByFormName(sFormName);
				
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
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Forms URL", "Get Forms url before submit", "done", "Forms URL:" + driver.getCurrentUrl() );
 					    
						// clicking on contact information link
						WebObjectUtil.clickElement(Form.getNav_ContactInfoReviewAndSubmitBtn());
					    WebObjectUtil.explicitWait(7);	
					 
					    FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Forms URL", "Get Forms url after submit", "done", "Forms URL:" + driver.getCurrentUrl() );
					    
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
			
			
		    TalonTestCase_Vivek.getSalesOrderByFormName(sFormName);
			
			
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

		        iFormNumber =fillContactInfoEditFields(1,sFirstName, sLastName, sEmail, sPhoneCountryCodeVisibleText, sPhoneNumber, sExtn, sCellCountryCodeVisibleText, sCellNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText, true);
				WebObjectUtil.explicitWait(3);
			// fillContactInfoEditFields(1,"Selenium", "Test1", "SeleniumTest@gmail.com", "United States (+1)","9874561230", "12345.0", "United States (+1)", "9197651234", "Do not contact for escalation", "Data Center Access Only", true);
		   
				WebObjectUtil.clickElement(Form.getNav_ContactInfoAddContactLink());
			    WebObjectUtil.explicitWait(3);
			
			    iFormNumber = fillContactInfoEditFields(iFormNumber+1,sFirstName, sLastName, sEmail, sPhoneCountryCodeVisibleText, sPhoneNumber, sExtn, sCellCountryCodeVisibleText, sCellNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText, false);
			   // fillContactInfoEditFields(2,"Selenium", "Test2", "SeleniumTest@gmail.com", "United States (+1)","9874561230", "12345.0", "United States (+1)", "9197651234", "Do not contact for escalation", "Data Center Access Only", false);
			   WebObjectUtil.clickElement(Form.getNav_ContactInfoAddContactLink());
			   WebObjectUtil.explicitWait(3);
			   
			   iFormNum = iFormNumber+1;
			   fillContactInfoEditFields(iFormNum,sFirstName, sLastName, sEmail, sPhoneCountryCodeVisibleText, sPhoneNumber, sExtn, sCellCountryCodeVisibleText, sCellNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText, false);

			iForms =driver.findElements(By.xpath("//div[contains(@id,'contactInfo_')]")).size();
			
			if(iForms==3){
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verifying the forms", "pass", +iForms+"Contact forms are displaying in the page");
			}
			else{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verifying the forms", "warn", +iForms+"Contact forms are displaying in the page");
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
			sSalesOrder = TalonTestCase_Vivek.getSalesOrderByFormName(sFormName);
			
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
		   sFormOrderType = (String)FrameworkUtil.dictPropertyData.get("NAV.FORMS.ORDERTYPE2"); 
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
			sSalesOrder = TalonTestCase_Vivek.getSalesOrderByFormName(sFormName);
	
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
	
	//////////////////////////////////////////////////// METHODS //////////////////////////////////////////////////////////////////////////////////////
	
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
			fillRequiredFields(ContactFormIndex, sFirstName, sLastName, sEmail, sPhoneCountryCodeVisibleText, sPhoneNumber, sExtn, sCellCountryCodeVisibleText, sCellNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText);
		}
	} catch (Exception e) {
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	return iDelete+1;
	
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
		WebObjectUtil.SetValueEdit(wFirstName, sFirstName);
		
		wLastName = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.CONTACTINFORMATION.FORM3.LASTNAME.EDITFIELD", "PARAMETER_FORMNUMBER", ContactFormIndex+"");
		WebObjectUtil.SetValueEdit(wLastName, sLastName);
		
		wEmail = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.CONTACTINFORMATION.FORM3.EMAIL.EDITFIELD", "PARAMETER_FORMNUMBER", ContactFormIndex+"");
		WebObjectUtil.SetValueEdit(wEmail, sEmail);
		
		wWorkPhoneCountryCodeDropDown = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.CONTACTINFORMATION.FORM3.WORKPHONE.COUNTRYCODE.DROPDOWN.ARROW", "PARAMETER_FORMNUMBER", ContactFormIndex+"");
	    LefCourt_SP2TestCase_NMR.SelectElementFromDropDown(wWorkPhoneCountryCodeDropDown, sPhoneCountryCodeVisibleText);
		
		wWorkPhoneAreaCode = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.CONTACTINFORMATION.FORM3.WORKPHONE.AREACODE.EDITFIELD", "PARAMETER_FORMNUMBER", ContactFormIndex+"");
		WebObjectUtil.SetValueEdit(wWorkPhoneAreaCode, sPhoneNumber);
		  
		wWorkPhoneExtn = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.CONTACTINFORMATION.FORM3.WORKPHONE.EXTN.EDITFIELD", "PARAMETER_FORMNUMBER", ContactFormIndex+"");
		WebObjectUtil.SetValueEdit(wWorkPhoneExtn, sExtn);
		
		wCellCountryCodeDropDown = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.CONTACTINFORMATION.FORM3.CELLPHONE.COUNTRYCODE.DROPDOWN.ARROW", "PARAMETER_FORMNUMBER", ContactFormIndex+"");
		LefCourt_SP2TestCase_NMR.SelectElementFromDropDown(wCellCountryCodeDropDown, sCellCountryCodeVisibleText);
		
		wCellAreaCode = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.CONTACTINFORMATION.FORM3.CELLPHONE.AREACODE.EDITFIELD", "PARAMETER_FORMNUMBER", ContactFormIndex+"");
		WebObjectUtil.SetValueEdit(wCellAreaCode, sCellNumber);
		
		wEscalationDropdown = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.CONTACTINFORMATION.FORM3.ESCALATION.DROPDOWN.ARROW", "PARAMETER_FORMNUMBER", ContactFormIndex+"");
		LefCourt_SP2TestCase_NMR.SelectElementFromDropDown(wEscalationDropdown, sEscalationDropDownVisibleText);
		
		wUserRoleDropDown = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.CONTACTINFORMATION.FORM3.USERROLE.DROPDOWN.ARROW", "PARAMETER_FORMNUMBER", ContactFormIndex+"");
		LefCourt_SP2TestCase_NMR.SelectElementFromDropDown(wUserRoleDropDown, sUserRoleDropDownVisibleText);
		
		
		
		
		
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
	int iSalesOrderCount,iRowCnt;
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
			
			//Load table for Incomplete list
			CustomWebElementUtil.loadCustomElement(Form.getNav_IncompleteFormsTable(), "table");
			//Get the row count 
			iRowCnt=CustomWebElementUtil.iRowCount;
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
					WebObjectUtil.switchToParentWindow();
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
 
 
 
//__________________________________________________________________________________________________________

@AfterMethod
public void afterMethod(){
	FrameworkUtil.updateTestCaseStatusinResult();
	FrameworkUtil.sTestExecutionStatus=true;
}
}
