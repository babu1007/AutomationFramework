package com.whs.navigator.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.CustomWebElementUtil;
import com.whs.navigator.commonUtil.FileDownloader;
import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.commonUtil.WebTableUtil;
import com.whs.navigator.pagefactory.DocumentPageFactory;
import com.whs.navigator.pagefactory.DraasPageFactory;
import com.whs.navigator.pagefactory.FormPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.List;

public class KyleTestCase_SLP {
	
	 public static HomePageFactory Home = new HomePageFactory();
	 public static DocumentPageFactory document = new DocumentPageFactory();
	 public static FormPageFactory Forms = new FormPageFactory();
	 
	 /*==============================================================
		TestScript  	: verifyAddOrgSpecificDocsForDiffusers
		Manual TestCase	: [QAT-1457] WCP-5230-TC_1.0_Support-> Add Org Specific docs
		Description		: //include description from testcase
		Author 			: QAA03
		Creation Date 	: 06/20/2016
		Release Name    : Kyle
		Pre-Requisites	:
		Revision History:
	  ==============================================================*/
		
		@Test(priority=41)
		public void verifyAddOrgSpecificDocsForDiffusers()
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, Home);
				PageFactory.initElements(driver, document);
				
						
			try {
				FrameworkUtil.sTestCaseName = "Document-verifyAddOrgSpecificDocsForDiffusers";
				FrameworkUtil.sManualTestCaseName="[QAT-1457] WCP-5230-TC_1.0_Support-> Add Org Specific docs";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
				//Login to navigator with Role-A user
				LoginTestCase.LoginAsRoleAUser();
				
				WebObjectUtil.clickElement(Home.getNav_SupportTab());
				
				//Verifying add org specific docs link present for hosted solutions user
				WebObjectUtil.verifyElementPresent(document.getNav_SupportTab_AddOrgSpecificDocsLink());
				
				//Logout from Navigator
				LoginTestCase.nav_Logout();
				
			    //Login to navigator with Qaauto-A user
				LoginTestCase.LoginAsQaautoAUser();
				
                WebObjectUtil.clickElement(Home.getNav_SupportTab());
				
                //Verifying add org specific docs link not present for non hosted solutions user
				WebObjectUtil.verifyElementNOTPresent(document.getNav_SupportTab_AddOrgSpecificDocsLink());
								
				//Logout from Navigator
				LoginTestCase.nav_Logout();
			
			   } catch (Exception e) {
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAddOrgSpecificDocsForDiffusers", "warn", "catch block:" +e.getMessage());
			}
		}
		
		 
		 /*==============================================================
			TestScript  	: verifyAddOrgSpecificDocsPage
			Manual TestCase	: [QAT-1458] WCP-5230-TC_1.1_Support-> Add Org Specific docs page
			Description		: //include Description from testcase
			Author 			: QAA03
			Creation Date 	: 06/20/2016
			Release Name    : Kyle
			Pre-Requisites	:
			Revision History:
		  ==============================================================*/
			
			@Test(priority=42)
			public void verifyAddOrgSpecificDocsPage()
			{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver, Home);
					PageFactory.initElements(driver, document);
					
							
				try {
					FrameworkUtil.sTestCaseName = "Add Org Specific Document-verifyAddOrgSpecificDocsPage";
					FrameworkUtil.sManualTestCaseName="[QAT-1458] WCP-5230-TC_1.1_Support-> Add Org Specific docs page";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					
					//Login to navigator with Role-A user
					LoginTestCase.LoginAsRoleAUser();
					
					//Navigating to Add Org Specific Docs Page
					navAddOrgSpecificDocsPage();
					
					//update comments if necessary
					WebObjectUtil.verifyElementPresent(document.getNav_AddOrgSpecificDocs_OrganizationDropDown());
					
					WebObjectUtil.verifyElementPresent(document.getNav_AddOrgSpecificDocs_UploadDocumentField());
					
					WebObjectUtil.verifyElementPresent(document.getNav_AddOrgSpecificDocs_BrowseButton());
					
					WebObjectUtil.verifyElementPresent(document.getNav_AddOrgSpecificDocs_ResetButton());
					
					WebObjectUtil.verifyElementPresent(document.getNav_AddOrgSpecificDocs_SubmitButton());
					
					//WebObjectUtil.clickElement(document.getNav_AddOrgSpecificDocs_BrowseButton());
					
					
					
					//Logout from Navigator
					LoginTestCase.nav_Logout();
					
				    } catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAddOrgSpecificDocsPage", "warn", "catch block:" +e.getMessage());
				}
			}
		
			/*==============================================================
			TestScript  	: verifyDocumentUploadedforUser
			Manual TestCase	: [QAT-1464] WCP-5230-TC_1.3_Support-> Documents
			Description		: //include Description from testcase
			Author 			: QAA03
			Creation Date 	: 06/22/2016
			Release Name    : Kyle
			Pre-Requisites	: [QAT-1461] should be done manually as it is related to uploading documents
			Revision History:
		  ==============================================================*/
			
			@Test(priority=43)
			public void verifyDocumentUploadedforUser()
			{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver, Home);
					PageFactory.initElements(driver, document);
					String sULElementXpath=null;
							
				try {
					FrameworkUtil.sTestCaseName = "Document-verifyDocumentUploadedforUser";
					FrameworkUtil.sManualTestCaseName="[QAT-1464] WCP-5230-TC_1.3_Support-> Documents";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					
					sULElementXpath = (String)FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
					
														
				    // Login to navigator with Qaauto-A user
					LoginTestCase.LoginAsQaautoAUser();
					
					// Navigating to Document Page
	                navDocumentPage();
	                
					// Verifying folder present for the organization name and clicking on the organization
	                verifyDownloadDocumentUnderOrgFolder();
	                
	                // Verifying document present for the organization name and clicking on the document
	                verifyDownloadDocumentUnderOrgdocument();
	                
	                // Verifying the search document page
					WebObjectUtil.verifyElementPresent(document.getNav_Document_SearchDocument());
					
					// Verifying the document by clicking on download button
					verifyDownloadDocument();
														
					// Logout from Navigator
					LoginTestCase.nav_Logout();
				
				   } catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyDocumentUploadedforUser", "warn", "catch block:" +e.getMessage());
				}
			}
			
			/*==============================================================
			TestScript  	: verifyFormpagehasTicketclickedonTicketNumber
			Manual TestCase	: [QAT-1592][1584][1585] WCP_5227_TC_1.6_Forms display on navigator when created through Forms 2.0 manage tab_Left Menu on Forms page
			Description		: //include description from testcase 
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
					PageFactory.initElements(driver, Forms);
					String sFormName=null,sFormOrderType=null;
				
									
				try {
					FrameworkUtil.sTestCaseName = "Forms-verifyFormpagehasTicketclickedonTicketNumber";
					FrameworkUtil.sManualTestCaseName="[QAT-1592][1584][1585] WCP_5227_TC_1.6_Forms display on navigator when created through Forms 2.0 manage tab_Left Menu on Forms page";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					
					sFormName=(String)FrameworkUtil.dictPropertyData.get("NAV.FORMS.FORMNAME");
					sFormOrderType = (String)FrameworkUtil.dictPropertyData.get("NAV.FORMS.ORDERTYPE.TICKET");
					
																		
				    // Login to navigator with Qaauto-A user
					LoginTestCase.LoginAsQaautoAUser();
					
					// Navigating to Forms Page
	                FormTestCase.navToFormsPage();
	                
	                // Getting the sales order with order type specified which is having only one incomplete form
	                getSalesOrderByFormName(sFormName, sFormOrderType,true);
	                          			
					// Logout from Navigator
					LoginTestCase.nav_Logout();
				
				   } catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyFormpagehasTicketclickedonTicketNumber", "warn", "catch block:" +e.getMessage());
				}
			}
			
			/*==============================================================
			TestScript  	: verifyContactFormCreatedThroughTicketisinReadOnlyformat
			Manual TestCase	: [QAT-1593] WCP_5227_TC_1.7_Forms display on navigator when created through Forms 2.0 manage tab_Read Only
			Description		: //include description from testcase 
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
					PageFactory.initElements(driver, Forms);
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
					LoginTestCase.LoginAsQaautoAUser();
					
					// Navigating to Forms Page
	                FormTestCase.navToFormsPage();
	                
	                // Getting the sales order with order type specified which is having only one incomplete form
	                getSalesOrderByFormName(sFormName, sFormOrderType,true);
	                      
	                
				    
				    iFormnumber =TalonTestCase_NMR.fillContactInfoEditFields(1, sFirstName, sLastName, sEmail, sPhoneCountryCodeVisibleText, sPhoneNumber, sExtn, sCellCountryCodeVisibleText, sCellNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText, bDeleteExistingForm);
				    
				    // verify the phone number formate
					//TalonTestCase_NMR.verifyPhoneNumberFormate(Forms.getNav_ContactInfoCellPhoneAreaCodeNumberInput());
					
					// verify email formate
				    //TalonTestCase_NMR.verifyEmiailAddressFormate(Forms.getNav_ContactInfoEmailInput());
				    
				    
					//include comments if necessary
					WebObjectUtil.scrollToElement(Forms.getNav_ContactInfoSaveButton());
			        WebObjectUtil.clickElement(Forms.getNav_ContactInfoSaveButton());
				    WebObjectUtil.explicitWait(3);
					sFeedBackMsg= Forms.getNav_FormFeedBackArea().getText();
					sSucessMsg= (String) FrameworkUtil.dictPropertyData.get("NAV.FORM.CONTACTIMFORMATION.SAVE.BUTTON.SUCCESS.MESSAGE");
					// verifying the feed back error message.
					bStatus = sSucessMsg.contains(sSucessMsg);
					FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "validating the feed back sucess message");
					
					// clicking on save and continue btn
					WebObjectUtil.clickElement(Forms.getNav_ContactInfoSaveAndCOntinueButton());
					
					
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Forms URL", "Get Forms url before submit", "done", "Forms URL:" + driver.getCurrentUrl() );
					    
					WebObjectUtil.verifyElementPresent(Forms.getNav_ContactInfoReviewAndSubmitBtn());
					//WebObjectUtil.clickElement(Forms.getNav_ContactInfoReviewAndSubmitBtn());
				    WebObjectUtil.explicitWait(7);	
				 
				    FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Forms URL", "Get Forms url after submit", "done", "Forms URL:" + driver.getCurrentUrl() );
				    
				    bReviewBtnStatus = !Forms.getNav_ContactInfoReviewAndSubmitBtn().isDisplayed();
				    FrameworkUtil.updateCustomResultBasedOnStatus(bReviewBtnStatus, "Review And Submit button not displaying(after submit)");
				    //include comments
				    WebObjectUtil.verifyElementPresent(Forms.getNav_Forms_ReviewAndSubmit_LeftMenuButton());
				    WebObjectUtil.clickElement(Forms.getNav_Forms_ReviewAndSubmit_LeftMenuButton());
				    WebObjectUtil.verifyElementPresent(Forms.getNav_Forms_ReviewAndSubmit_LeftMenuWindow());
				    
					WebObjectUtil.verifyElementPresent(Forms.getNav_ReviewAndSubmit_ContactInformationLink());
					WebObjectUtil.clickElement(Forms.getNav_ReviewAndSubmit_ContactInformationLink());
				    WebObjectUtil.explicitWait(5);
				    TalonTestCase_NMR.contactFormEditFieldDataValidation(1, sFirstName, sLastName, sEmail, sPhoneCountryCodeVisibleText, sPhoneNumber, sExtn, sCellCountryCodeVisibleText, sCellNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText);
				    
					// Logout from Navigator
					LoginTestCase.nav_Logout();
				
				   } catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyContactFormCreatedThroughTicketisinReadOnlyformat", "warn", "catch block:" +e.getMessage());
				}
			}
			
			/*==============================================================
			TestScript  	: verifyMoreThanOneFormnavigatestoEM7Page
			Manual TestCase	: [QAT-1586] WCP_5227_TC_1.2_Forms display on navigator when created through Forms 2.0 manage tab
			Description		: //include description from testcase
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
					PageFactory.initElements(driver, Forms);
					String sFormName=null,sFormOrderType=null;
				
									
				try {
					FrameworkUtil.sTestCaseName = "Forms-verifyMoreThanOneFormnavigatestoEM7Page";
					FrameworkUtil.sManualTestCaseName="[QAT-1586] WCP_5227_TC_1.2_Forms display on navigator when created through Forms 2.0 manage tab";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					
					sFormName=(String)FrameworkUtil.dictPropertyData.get("NAV.FORMS.FORMNAME");
					sFormOrderType = (String)FrameworkUtil.dictPropertyData.get("NAV.FORMS.ORDERTYPE.TICKET");
					
																		
				    // Login to navigator with Qaauto-A user
					LoginTestCase.LoginAsQaautoAUser();
					
					// Navigating to Forms Page
	                FormTestCase.navToFormsPage();
	                
	                // Verifying when more than one incomplete form present, it navigates to EM7 Page
	                //getSalesOrderMoreThanOneIncompleteForms(sFormName,sFormOrderType);
	                TalonTestCase_NMR.verifyEM7LoginPagefromFormsPage(sFormName,sFormOrderType);
	                          			
					// Logout from Navigator
					LoginTestCase.nav_Logout();
				
				   } catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyMoreThanOneFormnavigatestoEM7Page", "warn", "catch block:" +e.getMessage());
				}
			}
			
			/*==============================================================
			TestScript  	: verifySalesOrderDetailPopUpWindowSorting
			Manual TestCase	: [QAT-1511][1501] WCP_5178_TC_1.2_Enhancements to Sales order detail popup_Sort by Details column. 
			Description		: //include description from testcase
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
					PageFactory.initElements(driver, Forms);
					
									
				try {
					FrameworkUtil.sTestCaseName = "Forms-verifySalesOrderDetailPopUpWindowSorting";
					FrameworkUtil.sManualTestCaseName="[QAT-1511][1501] WCP_5178_TC_1.2_Enhancements to Sales order detail popup_Sort by Details column.";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
					
					 // Login to navigator with qaauto-A user
					LoginTestCase.LoginAsQaautoAUser();
										
					// Navigating to Forms Page
	                FormTestCase.navToFormsPage();
	                                  
	                //Getting the list of All Sales Order block and clicking on the first sales order link
	                clickOnFirstSalesOrderPortletLink();
	                
	                //Verifying sales order header name in the page
	                WebObjectUtil.verifyElementPresent(Forms.getNav_FormsSalesOrderSelectedHeaderNameButton());
	                
					//Verifying Sales order popup window table detail column sorting
					verifySalesOrderPopUpWindowSorting();
	            			
					// Logout from Navigator
					LoginTestCase.nav_Logout();
				
				   } catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifySalesOrderDetailPopUpWindowSorting", "warn", "catch block:" +e.getMessage());
				}
			}
			
			/*==============================================================
			TestScript  	: validateSalesOrderDetailPopUpWindowDetails
			Manual TestCase	: [QAT-1502][1455][1510] WCP_5031_TC_1.0_Forms3.0-Dashboard-Add Sales Order detail to forms dashboard on any Sales Order-Pop up Details. 
			Description		: //include description from testcase 
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
					PageFactory.initElements(driver, Forms);
					
									
				try {
					FrameworkUtil.sTestCaseName = "Forms-validateSalesOrderDetailPopUpWindowDetails";
					FrameworkUtil.sManualTestCaseName="[QAT-1502][1455][1510] WCP_5031_TC_1.0_Forms3.0-Dashboard-Add Sales Order detail to forms dashboard on any Sales Order-Pop up Details";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
					
					 // Login to navigator with qaauto-A user
					LoginTestCase.LoginAsQaautoAUser();
										
					// Navigating to Forms Page
	                FormTestCase.navToFormsPage();
	                                  
	                // Getting the list of All Sales Order block and clicking on the first sales order link
	                clickOnFirstSalesOrderPortletLink();
	                
	                // Verifying all the fields, icons, table in the sales order popup window
					validateSalesOrderPopUpwindowfields();
	            			
					// Logout from Navigator
					LoginTestCase.nav_Logout();
				
				   } catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "validateSalesOrderDetailPopUpWindowDetails", "warn", "catch block:" +e.getMessage());
				}
			}
			
			
			/*==============================================================
			TestScript  	: validateSalesOrderDetailPopUpWindowTable
			Manual TestCase	: [QAT-1509] WCP_5178_TC_1.0_Enhancements to Sales order detail popup_Expand all checkbox. 
			Description		: //include description from testcase 
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
					PageFactory.initElements(driver, Forms);
					
									
				try {
					FrameworkUtil.sTestCaseName = "Forms-validateSalesOrderDetailPopUpWindowTable";
					FrameworkUtil.sManualTestCaseName="[QAT-1509] WCP_5178_TC_1.0_Enhancements to Sales order detail popup_Expand all checkbox";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
					
					 // Login to navigator with qaauto-A user
					LoginTestCase.LoginAsQaautoAUser();
										
					// Navigating to Forms Page
	                FormTestCase.navToFormsPage();
	                                  
	                //Getting the list of All Sales Order block and clicking on the first sales order link
	                clickOnFirstSalesOrderPortletLink();
	                
	                //Verifying the data in the sales order popup window table
					validateSalesOrderPopUpwindowTable();
	            			
					// Logout from Navigator
					LoginTestCase.nav_Logout();
				
				   } catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "validateSalesOrderDetailPopUpWindowTable", "warn", "catch block:" +e.getMessage());
				}
			}
			
			/*==============================================================
			TestScript  	: clickCIMPopUpButtonandValidateDetails
			Manual TestCase	: [QAT-1452][1451][1450] WCP_5030_TC_1.3_Forms3.0 Dashboard_My CIM Button UI Display. 
			Description		: //include description from testcase 
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
					PageFactory.initElements(driver, Forms);
					
									
				try {
					FrameworkUtil.sTestCaseName = "Forms-clickCIMPopUpButtonandValidateDetails";
					FrameworkUtil.sManualTestCaseName="[QAT-1452][1451][1450] WCP_5030_TC_1.3_Forms3.0 Dashboard_My CIM Button UI Display";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
					
					 // Login to navigator with qaauto-A user
					LoginTestCase.LoginAsQaautoAUser();
										
					// Navigating to Forms Page
	                FormTestCase.navToFormsPage();
	                                  
	                //Getting the list of All Sales Order block and clicking on the first sales order link
	                clickOnFirstSalesOrderPortletLink();
	                // include comments for mycim button
	                WebObjectUtil.verifyElementPresent(Forms.getNav_Forms_MYCIMButton());
	                
	                WebObjectUtil.clickElement(Forms.getNav_Forms_MYCIMButton());
	                
	                //Verifying the data in the CIM Popup Window details
					validateCIMPopUpwindowDetails();
	            			
					// Logout from Navigator
					LoginTestCase.nav_Logout();
				
				   } catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "clickCIMPopUpButtonandValidateDetails", "warn", "catch block:" +e.getMessage());
				}
			}
			
			/*==============================================================
			TestScript  	: verifyCIMButtonForSalesOrderinFormsandCompletedOrders
			Manual TestCase	: [QAT-318] WCP_5030_TC_1.0_Forms3.0 Dashboard_My CIM Button. 
			Description		: //include description from testcase 
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
					PageFactory.initElements(driver, Forms);
					
									
				try {
					FrameworkUtil.sTestCaseName = "Forms-verifyCIMButtonForSalesOrderinFormsandCompletedOrders";
					FrameworkUtil.sManualTestCaseName="[QAT-318] WCP_5030_TC_1.0_Forms3.0 Dashboard_My CIM Button.";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
					
					 // Login to navigator with puppylove user
					LoginTestCase.LoginAsPuppyloveUser();
										
					// Navigating to Forms Page
	                FormTestCase.navToFormsPage();
	                                  
	                //Getting the list of All Sales Order block and clicking on the first sales order link
	                clickOnFirstSalesOrderPortletLink();
	                
	                WebObjectUtil.verifyElementPresent(Forms.getNav_Forms_MYCIMButton());
	                //include comments
	                WebObjectUtil.verifyElementPresent(Forms.getNav_FormsBreadCrumb());
	                
	                WebObjectUtil.clickElement(Forms.getNav_FormsBreadCrumb());
	                
	                // Verifying the sales order in completed orders section has CIM Button
	                verifyCIMButtonForSalesOrderinCompletedOrders();
	                
	                // Logout from Navigator
					LoginTestCase.nav_Logout();
				
				   } catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyCIMButtonForSalesOrderinFormsandCompletedOrders", "warn", "catch block:" +e.getMessage());
				}
			}
			
			/*==============================================================
			TestScript  	: verifyTicketSalesNumberCreatedinEM7Page
			Manual TestCase	: [QAT-1587] WCP_5227_TC_1.3_Forms display on navigator when created through Forms 2.0 manage tab_Create Forms on Forms2.0.
			Description		: //include description from testcase 
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
					PageFactory.initElements(driver, Forms);
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
					LoginTestCase.LoginAsQaautoAUser();
					
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
					LoginTestCase.nav_Logout();
				
					} catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyTicketSalesNumberCreatedinEM7Page", "warn", "catch block:" +e.getMessage());
				}
			}
			/*==============================================================
			TestScript  	: validateTicketNumberinRejectedSectionAndSubmitForm
			Manual TestCase	: [QAT-1590] WCP_5227_TC_1.5_Forms display on navigator when created through Forms 2.0 manage tab_Rejected Forms section 
			Description		: //include description from testcase 
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
					PageFactory.initElements(driver, Forms);
					String sTicketNumber=null;
					boolean bReviewBtnStatus=false;				
				try {
					FrameworkUtil.sTestCaseName = "Forms-validateTicketNumberinRejectedSectionAndSubmitForm";
					FrameworkUtil.sManualTestCaseName="[QAT-1590] WCP_5227_TC_1.5_Forms display on navigator when created through Forms 2.0 manage tab_Rejected Forms section";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
					sTicketNumber =(String) FrameworkUtil.dictPropertyData.get("NAV.FORMS.REJECTEDFORM.TICKETNUMBER.QAT1590");
					
					 // Login to navigator with qaauto-A user
					LoginTestCase.LoginAsQaautoAUser();
										
					// Navigating to Forms Page
	                FormTestCase.navToFormsPage();
	               
	                //Search for required Sales Order or Ticket Number in Rejected Forms Portlet
	                searchSalesOrTicketNumberinRejectedFormsPortlet(sTicketNumber);
	                
	                // Completing the form by clicking on review and submit button for the rejected ticket number 
	                //include Comments
	                WebObjectUtil.clickElement(Forms.getNav_ContactInfoSaveAndCOntinueButton());
	                WebObjectUtil.verifyElementPresent(Forms.getNav_ContactInfoReviewAndSubmitBtn());
	               // WebObjectUtil.clickElement(Forms.getNav_ContactInfoReviewAndSubmitBtn());
	                bReviewBtnStatus = !Forms.getNav_ContactInfoReviewAndSubmitBtn().isDisplayed();
				    FrameworkUtil.updateCustomResultBasedOnStatus(bReviewBtnStatus, "Review And Submit button not displaying(after submit)");
	               
	            			
					// Logout from Navigator
					LoginTestCase.nav_Logout();
				
				   } catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "validateTicketNumberinRejectedSectionAndSubmitForm", "warn", "catch block:" +e.getMessage());
				}
			}
			
			/*==============================================================
			TestScript  	: validateTicketNumberSalesOrderinCompletedSection
			Manual TestCase	: [QAT-1588][QAT-1555] WCP_5227_TC_1.4_Forms display on navigator when created through Forms 2.0 manage tab_Completed Orders section
			Description		: //include description from testcase 
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
					PageFactory.initElements(driver, Forms);
					String sTicketNumber=null,sCompleteOrderColumn=null,sColumnName=null;
					boolean bColumnStatus;
									
				try {
					FrameworkUtil.sTestCaseName = "Forms-validateTicketNumberSalesOrderinCompletedSection";
					FrameworkUtil.sManualTestCaseName="[QAT-1588][QAT-1555] WCP_5227_TC_1.4_Forms display on navigator when created through Forms 2.0 manage tab_Completed Orders section";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
					sTicketNumber =(String) FrameworkUtil.dictPropertyData.get("NAV.FORMS.COMPLETEDORDER.TICKETNUMBER.QAT1588");
					sColumnName=(String)FrameworkUtil.dictPropertyData.get("NAV.FORMS.COMPLETEDORDER.COLUMNNAME");
					 // Login to navigator with qaauto-A user
					LoginTestCase.LoginAsQaautoAUser();
										
					// Navigating to Forms Page
	                FormTestCase.navToFormsPage();
	                
	                if(WebObjectUtil.isElementPresent(Forms.getNav_Forms_CompletedOrdersSection()))
	          		{
	                	sCompleteOrderColumn = Forms.getNav_Forms_CompletedOrders_FirstColumn().getText();
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
					LoginTestCase.nav_Logout();
				
				   } catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "validateTicketNumberSalesOrderinCompletedSection", "warn", "catch block:" +e.getMessage());
				}
			}
			
			/*==============================================================
			Method Name 	: navAddOrgSpecificDocsPage
			Description		: Navigating to Add Org Specific Docs Page
			Author 			: QAA03
			Creation Date 	: 06/22/2016
			Module Name     : Add specific document
			Pre-Requisites	: 
			Revision History:
			==============================================================*/
			public static void navAddOrgSpecificDocsPage()
			{
				
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, document);
				
				
		   try {
			     
			    WebObjectUtil.clickElement(Home.getNav_SupportTab());
				
				WebObjectUtil.verifyElementPresent(document.getNav_SupportTab_AddOrgSpecificDocsLink());
				
				WebObjectUtil.clickElement(document.getNav_SupportTab_AddOrgSpecificDocsLink());
				
				WebObjectUtil.verifyElementPresent(document.getNav_AddOrgSpecificDocs_OrgSpecificDocsTable());	
					
				} catch (Exception e) {
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navAddOrgSpecificDocsPage", "fail", e.getMessage()+"null");
					LoggerUtil.log_type_error(e.getMessage());
				}

			} 
			
			/*==============================================================
			Method Name 	: navDocumentPage
			Description		: Navigating to Document Page
			Author 			: QAA03
			Creation Date 	: 06/22/2016
			Module Name     : Document
			Pre-Requisites	: 
			Revision History:
			==============================================================*/
			public static void navDocumentPage()
			{
				
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, document);
				
				
		   try {
			     
			    WebObjectUtil.clickElement(Home.getNav_SupportTab());
				
				WebObjectUtil.clickElement(document.getNav_DocumentLink());
				
				WebObjectUtil.waitForElementPresent(document.getNav_Document_TierPointDocsImg());
				
				WebObjectUtil.verifyElementPresent(document.getNav_Document_TierPointDocsImg());		
					
				} catch (Exception e) {
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navDocumentPage", "fail", e.getMessage()+"null");
					LoggerUtil.log_type_error(e.getMessage());
				}

			} 
			
			/*==============================================================
			Method Name 	: verifyDownloadDocumentUnderOrgFolder
			Description		: Verifying folder present for the organization name and clicking on the organization
			Author 			: QAA03
			Creation Date 	: 06/22/2016
			Module Name     : Document
			Pre-Requisites	: 
			Revision History:
			==============================================================*/
			public static void verifyDownloadDocumentUnderOrgFolder()
			{
				
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, document);
				int iRownumber=0;
				String sOrgName=null;
				WebElement wRowElement;
		   try {
			   
			    sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.DOCUMENT.FOLDER.ORGANIZATION");
			    
			         
			   /* CustomWebElementUtil.loadCustomElement(document.getNav_Document_FolderTable(), "tr");
				
				iRownumber = CustomWebElementUtil.getRowByCellText(sOrgName, 1);
				
				wRowElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.DOCUMENT.FOLDER.ORGANIZATION", "PARAMETER_ROWNUMBER,PARAMETER_ORG", iRownumber+","+sOrgName);
				
				WebObjectUtil.clickElement(wRowElement);*/
			   
			      
			   //Verifying folder present for the organization name and clicking on the organization
			   WebObjectUtil.verifyElementPresent(document.getNav_Document_FolderTable());
			   
			   iRownumber = WebTableUtil.getRowByCellText(document.getNav_Document_FolderTable(), sOrgName, 1,1);
			   
			   wRowElement =WebTableUtil.getCellAsWebElement(document.getNav_Document_FolderTable(), iRownumber+1,1);
			   
			   wRowElement.findElement(By.tagName("Strong")).click();
			  // WebObjectUtil.clickElement(wRowElement);
					
				} catch (Exception e) {
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyDownloadDocumentUnderOrgFolder", "fail", e.getMessage()+"null");
					LoggerUtil.log_type_error(e.getMessage());
				}

			} 
			
			/*==============================================================
			Method Name 	: verifyDownloadDocumentUnderOrgdocument
			Description		: Verifying document present for the organization name and clicking on the document
			Author 			: QAA03
			Creation Date 	: 06/22/2016
			Module Name     : Document
			Pre-Requisites	: 
			Revision History:
			==============================================================*/
			public static void verifyDownloadDocumentUnderOrgdocument()
			{
				
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, document);
				int iRownumber=0;
				String sDocument=null;
				WebElement wRowElement;
		   try {
			    sDocument=(String)FrameworkUtil.dictPropertyData.get("NAV.DOCUMENT.FOLDER.SEARCHDOCUMENT");
			     
			    //Verifying document present for the organization name and clicking on the document
			    WebObjectUtil.verifyElementPresent(document.getNav_Document_ObjectsTable());
				   
				iRownumber = WebTableUtil.getRowByCellText(document.getNav_Document_ObjectsTable(), sDocument, 1, 1);
				   
				wRowElement =WebTableUtil.getCellAsWebElement(document.getNav_Document_ObjectsTable(), iRownumber+1,1);
				 
				wRowElement.findElement(By.tagName("span")).click();
								
				//WebObjectUtil.clickElement(wRowElement);
					
				} catch (Exception e) {
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyDownloadDocumentUnderOrgdocument", "fail", e.getMessage()+"null");
					LoggerUtil.log_type_error(e.getMessage());
				}

			} 
			
			/*==============================================================
			Method Name 	: verifyDownloadDocument
			Description		: Verifying the document by clicking on download button
			Author 			: QAA03
			Creation Date 	: 06/22/2016
			Module Name     : Document
			Pre-Requisites	: 
			Revision History:
			==============================================================*/
			public static void verifyDownloadDocument()
			{
				
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, document);
				String sPDFPath,sTitle,sURL;
				boolean bStatus;
				
		   try {
			     if (WebDriverUtil.browser.equalsIgnoreCase("IE") )
					//if (!WebObjectUtil.isElementPresent(document.getPDFcontainer()))
					{
						sPDFPath = FileDownloader.fileDownload(document.getNav_DownloadBtn());
						if (sPDFPath.contains(".pdf")){
							LoggerUtil.writeStatusLog(true, "PDF file download", "PDF file validated by FileDownloader");
						}
					}else{
						
						//Capturing URL from the inputbox and navigating the same
						WebObjectUtil.scrollElementAtPageCenter(document.getNav_DownloadLink());
						sURL= document.getNav_DownloadLink().getAttribute("href");
						
						//verifying and Clicking Download button
						WebObjectUtil.clickElement(document.getNav_DownloadBtn());
						WebObjectUtil.explicitWait(10);
						
						//verifying PDF page
						if(WebDriverUtil.browser.equals("FIREFOX")){
							WebObjectUtil.assertElementPresent(document.getPDFcontainer());
						}
						else if(WebDriverUtil.browser.equals("CHROME"))
						{
							//WebObjectUtil.assertElementPresent(document.getPDFcontainer_Chrome());
							sTitle=WebDriverUtil.getDriver().getTitle();
							bStatus=sURL.contains(sTitle);
							FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "PDF page for chrome verified");
						}
					}
					
					
					
					
				} catch (Exception e) {
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyDownloadDocument", "fail", e.getMessage()+"null");
					LoggerUtil.log_type_error(e.getMessage());
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
					PageFactory.initElements(driver, Forms);
					
				try {	
					//Getting the list of All Sales Order block
					List<WebElement> webListItems = Forms.getNav_SalesOrderPortlet();
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
							WebObjectUtil.clickElement(Forms.getNav_IncompleteFormBlk());
							try {
								
								//Load table for Incomplete list
								if (WebObjectUtil.isElementPresent(Forms.getNav_IncompleteFormsTable())){
								CustomWebElementUtil.loadCustomElement(Forms.getNav_IncompleteFormsTable(), "table");
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
							
							WebObjectUtil.verifyElementPresent(Forms.getNav_FormsSalesOrderSelectedHeaderNameButton());
							
							sSelectedFormsSalesOrder = Forms.getNav_FormsSalesOrderSelectedHeaderNameButton().getText();
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
										
										if(TalonTestCase_NMR.navigatingToForm3Page(sSalesOrderNumber, sFormName)){
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
			Method Name 	: getSalesOrderMoreThanOneIncompleteForms
			Description		: Getting the sales order with order type specified which is more than  one incomplete form
			Author 			: QAA03
			Creation Date 	: 06/23/2016
			Module Name     : Forms
			Pre-Requisites	: 
			Revision History: 

			====================================================================================================
			public static String getSalesOrderMoreThanOneIncompleteForms(String sFormName,String sFormOrderType)
			{
					WebElement wSalesOrder,wContinueImg;
					String sSalesOrderNumber = null,sFormsname=null,sFormStatus=null,sSelectedFormsSalesOrder=null;
					int iRowCnt,iSalesPortletCnt;
					boolean bFlag=false,bContStatus=false,bOrderStatus=false;
					
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver, Forms);
					
				try {	
					//Getting the list of All Sales Order block
					List<WebElement> webListItems = Forms.getNav_SalesOrderPortlet();
					iSalesPortletCnt=webListItems.size();
					
					//iterate through all and looking for Sales Order Which have Contact Info form
					for(int i=1;i<=iSalesPortletCnt;i++)
					{
						//wIncompleteForms=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.FORMS.INCOMPLETEFORMS", "PARAMETER_ROWNUMBER", i+"");
						//sIncompleteForms=wIncompleteForms.getText();
						//Looking for Sales order which have at least 1 incomplete form
					//	if(!sIncompleteForms.contains("0"))
					//	{
							wSalesOrder=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.FORMS.SALESORDER.LINK", "PARAMETER_ROWNUMBER", i+"");
							WebObjectUtil.scrollElementAtPageCenter(wSalesOrder);
							//Capturing the Sales Order value
							sSalesOrderNumber=wSalesOrder.getText();
							//Clicking on Sales Order
							
							if(sSalesOrderNumber.contains(sFormOrderType))
					{
							WebObjectUtil.clickElement(wSalesOrder);
							WebObjectUtil.explicitWait(2);
							//Clicking on Incomplete Form Block
							WebObjectUtil.clickElement(Forms.getNav_IncompleteFormBlk());
							
							//Load table for Incomplete list
							CustomWebElementUtil.loadCustomElement(Forms.getNav_IncompleteFormsTable(), "table");
							//Get the row count 
							iRowCnt=CustomWebElementUtil.iRowCount;
							
                            WebObjectUtil.verifyElementPresent(Forms.getNav_FormsSalesOrderSelectedHeaderName());
							
							sSelectedFormsSalesOrder = Forms.getNav_FormsSalesOrderSelectedHeaderName().getText();
							bOrderStatus = sSelectedFormsSalesOrder.contains(sFormOrderType);
							FrameworkUtil.updateCustomResultBasedOnStatus(bOrderStatus, "Sales Order form selected is "+sSelectedFormsSalesOrder+" and forms count for selected sales order"+iRowCnt);
							if(iRowCnt>1)
							{
								for(int j=1;j<=iRowCnt;j++){
									
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
										
										if(TalonTestCase_NMR.navigatingToForm3Page(sSalesOrderNumber, sFormName)){
										bFlag=true;
										break;
										}
									}
									}	
							}
							}
							else
							{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Not required sales order form" , "warn","Sales order -"+sSalesOrderNumber+" - Does not have more incomplete forms");
								WebDriverUtil.getDriver().navigate().back();
								WebObjectUtil.explicitWait(5);
							
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
					*/
			
			
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
					PageFactory.initElements(driver,Forms);
					String sIncompleteForms=null,sSalesOrderNumber=null;
				    int iSalesPortletCount=0;
				    WebElement wIncompleteForms,wSalesOrder;
					
			 try {
				 
				   
				    List<WebElement> webListItems = Forms.getNav_SalesOrderPortlet();
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
					PageFactory.initElements(driver,Forms);
					int iRowCount=0;
					WebElement wRowElement;
					String sFirstRowElement=null,sLastRowElement=null;
					boolean bSortStatus;
			 try {
				 
				    WebObjectUtil.clickElement(Forms.getNav_FormsSalesOrderSelectedHeaderNameButton());
	                
	                WebObjectUtil.verifyElementPresent(Forms.getNav_FormsSalesOrderWindow());
	                
	                //WebObjectUtil.clickElement(Forms.getNav_FormsSalesOrderWindowExpandAllCheckbox());
	                
	                WebObjectUtil.clickElement(Forms.getNav_FormsSalesOrderDetailColumn());
	                
	                CustomWebElementUtil.loadCustomElement(Forms.getNav_FormsSalesOrderWindowWebTable(), "table");
	                
	                iRowCount = CustomWebElementUtil.iRowCount;
	                
	                wRowElement = CustomWebElementUtil.getRowAsWebElement(1);
	                
	                sFirstRowElement = wRowElement.getText();
	                	                
	                WebObjectUtil.clickElement(Forms.getNav_FormsSalesOrderDetailColumn());
	                
	                CustomWebElementUtil.loadCustomElement(Forms.getNav_FormsSalesOrderWindowWebTable(), "table");
	                
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
					PageFactory.initElements(driver,Forms);
					
					
			 try {
				 
				   WebObjectUtil.clickElement(Forms.getNav_FormsSalesOrderSelectedHeaderNameButton());
	                
	               WebObjectUtil.verifyElementPresent(Forms.getNav_FormsSalesOrderWindow());
	               
	               WebObjectUtil.verifyElementPresent(Forms.getNav_FormsSalesOrderPopUpPDFIcon());
	               
	               WebObjectUtil.verifyElementPresent(Forms.getNav_FormsSalesOrderPopUpCSVIcon());
	               
	               WebObjectUtil.verifyElementPresent(Forms.getNav_FormsSalesOrderPopUpHeadername());
	               
	               WebObjectUtil.verifyElementPresent(Forms.getNav_FormsSalesOrderWindowExpandAllCheckbox());
	               
	               WebObjectUtil.verifyElementPresent(Forms.getNav_FormsSalesOrderDetailColumn());
	               
	               WebObjectUtil.verifyElementPresent(Forms.getNav_FormsSalesOrderQuantityColumn());
	               
	               WebObjectUtil.verifyElementPresent(Forms.getNav_FormsSalesOrderWindowWebTable());
	               
	               
	         
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "validateSalesOrderPopUpwindowfields", "warn", "catch block:" +e.getMessage());  
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
					PageFactory.initElements(driver,Forms);
					WebElement wRowElement;
					String sFirstRowNotExp=null,sFirstRowAfterExp=null;
					boolean bCheckStatus;
					
			 try {
				 
				   WebObjectUtil.clickElement(Forms.getNav_FormsSalesOrderSelectedHeaderNameButton());
	                
	               WebObjectUtil.verifyElementPresent(Forms.getNav_FormsSalesOrderWindow());
	               
	               WebObjectUtil.clickElement(Forms.getNav_FormsSalesOrderWindowExpandAllCheckbox());
	               
	               CustomWebElementUtil.loadCustomElement(Forms.getNav_FormsSalesOrderWindowWebTable(), "table");
	                	                              
	               wRowElement = CustomWebElementUtil.getRowAsWebElement(1);
	                
	               sFirstRowNotExp = wRowElement.getText();
	                	                
	               WebObjectUtil.clickElement(Forms.getNav_FormsSalesOrderWindowExpandAllCheckbox());
	                
	               CustomWebElementUtil.loadCustomElement(Forms.getNav_FormsSalesOrderWindowWebTable(), "table");
	                
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
					PageFactory.initElements(driver,Forms);
					
					
			 try {
				    WebObjectUtil.verifyElementPresent(Forms.getNav_Forms_MYCIMPopUpWindow());
				    
				    WebObjectUtil.verifyElementPresent(Forms.getNav_Forms_MYCIMPopUp_Name());
				    
				    WebObjectUtil.verifyElementPresent(Forms.getNav_Forms_MYCIMPopUp_Designation());
				    
				    WebObjectUtil.verifyElementPresent(Forms.getNav_Forms_MYCIMPopUp_CIMPhone());
				    
				    WebObjectUtil.verifyElementPresent(Forms.getNav_Forms_MYCIMPopUp_TierPointPhone());
				    
				    WebObjectUtil.verifyElementPresent(Forms.getNav_Forms_MYCIMPopUp_CIMEmail());
				    
				    WebObjectUtil.verifyElementPresent(Forms.getNav_Forms_MYCIMPopUp_SupportEmail());
				    
				    WebObjectUtil.verifyElementPresent(Forms.getNav_Forms_MYCIMPopUp_PhoneImage());
				    
				    WebObjectUtil.verifyElementPresent(Forms.getNav_Forms_MYCIMPopUp_EmailImage());
				    
		           
	         
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "validateCIMPopUpwindowDetails", "warn", "catch block:" +e.getMessage());  
				}
			 
				
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
					PageFactory.initElements(driver,Forms);
					int iRowCount=0,iSalesRow=0;
					WebElement wSalesElement;
					String sSalesorderName=null,sOrdersPage=null,sOrdersCount[];
					boolean bFlag=false,bCIMStatus;
					int iOrdersCount=0;
			 try {
				do
				{
				    		   CustomWebElementUtil.loadCustomElement(Forms.getNav_Forms_CompletedOrdersSection(), "table");
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
				    		            WebObjectUtil.clickElement(Forms.getNav_Forms_CompletedOrders_PageOrdersNextButton());
							    }
				    		
				   	}while((!Forms.getNav_Forms_CompletedOrders_PageOrdersNextButton().getAttribute("class").contains("disabled"))&&(!bFlag));
				    	
				    	wSalesElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.FORM.COMPLETEDORDERS.SALESORDER", "PARAMETER_ROWNUMBER", ""+iSalesRow);
				    	WebObjectUtil.clickElement(wSalesElement);
				    	WebObjectUtil.waitForElementPresent(Forms.getNav_FormsSalesOrderSelectedHeaderNameButton());
				    	bCIMStatus =WebObjectUtil.verifyElementPresent(Forms.getNav_Forms_MYCIMButton());
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
		                PageFactory.initElements(driver, Forms);


		          try {

		                //Getting the list of All Sales Order block

		                List<WebElement> webListItems = Forms.getNav_SalesOrderPortlet();

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
		                PageFactory.initElements(driver, Forms);


		          try {
            do{    
		        	   CustomWebElementUtil.loadCustomElement(Forms.getNav_Forms_CompletedOrdersSection(), "table");
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
		    		            WebObjectUtil.clickElement(Forms.getNav_Forms_CompletedOrders_PageOrdersNextButton());
					    }
		    		
		    	}while((!Forms.getNav_Forms_CompletedOrders_PageOrdersNextButton().getAttribute("class").contains("disabled"))&&(!bFlag));
            
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
		                PageFactory.initElements(driver, Forms);


		          try {
		        	  
		        	  CustomWebElementUtil.loadCustomElement(Forms.getNav_RejectdFormWebTableParent(), "table");
		        	  iRowCount = CustomWebElementUtil.iRowCount;
		      		
		      		for(int i=1; i<=iRowCount; i++)
		      			
		      		{	
		      				
		      				wRejExpander = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.REJECTEDFORM.WEBTABLE.REJECTEDFORM.EXPANDER", "PARAMETER_ROWNUMBER", i+"");
		      				WebObjectUtil.clickElement(wRejExpander);
		      				
		      				wRejFormLink = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.REJECTEDFORM.WEBTABLE.FORM3PAGE.LINK",  "PARAMETER_ROWNUMBER", i+"");
		      			// include description
		      				WebObjectUtil.clickElement(wRejFormLink); 
		      			    WebObjectUtil.explicitWait(5);
		      			    WebObjectUtil.verifyElementPresent(Forms.getNav_ContactInfoAddContactFormsHeader());
		      			    WebObjectUtil.clickElement(Forms.getNav_Forms_ReviewAndSubmit_LeftMenuButton());
		      			    WebObjectUtil.verifyElementPresent(Forms.getNav_Forms_ReviewAndSubmit_LeftMenuWindow());
		      			    sTicketNumber = Forms.getNav_Forms_ReviewAndSubmit_LeftMenuWindow_TicketNumber().getText(); 
		      			    WebObjectUtil.clickElement(Forms.getNav_Forms_ReviewAndSubmit_LeftMenuButton());
		      			    
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
		 

		@AfterMethod
		public static void afterEachMethod(){
				FrameworkUtil.updateTestCaseStatusinResult();
				
			}

}
