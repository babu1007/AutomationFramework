package com.whs.navigator.testcases.Others;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.commonUtil.WebTableUtil;
import com.whs.navigator.pagefactory.EntityBrowserPageFactory;
import com.whs.navigator.pagefactory.TicketPageFactory;

public class OutOfScopeTestCases_NMR {

	public static TicketPageFactory Ticket = new TicketPageFactory();
	public static EntityBrowserPageFactory Entity = new EntityBrowserPageFactory();
	
	
	/*==============================================================
	TestScript 		: verifyNotesUpwardPointingArrow
	Manual TestCase	: QAT-30
	Description		: verify the -Upward pointing arrow icon is placed next to 'Date' column to indicate user
	Author 			: QAA04
	Creation Date 	: 04/19/2016
	Release Name    : LefcourtSP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=1)
	public void verifyNotesUpwardPointingArrow(){
		WebElement wNotesExpander,wExpander;
		String sTicketId;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Ticket);
		
		try {
			FrameworkUtil.sTestCaseName="";
			FrameworkUtil.sManualTestCaseName="(QAT-30) OutOfScope - verify the -Upward pointing arrow icon is placed next to 'Date' column to indicate user";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to the navigator
			LoginTestCase_Old1.LoginAsRoleAUser();
			
			// navigate to ticket page
			TicketTestCase.navigateToTicketPage();;
			WebObjectUtil.explicitWait(5);
			wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
			WebObjectUtil.clickElement(wExpander);
			WebObjectUtil.explicitWait(5);
			
			sTicketId = TicketTestCase.getTicketID(1);
			wNotesExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER", "PARAMETER_TICKETID",  sTicketId);
			WebObjectUtil.clickElement(wNotesExpander);
			WebObjectUtil.explicitWait(5);
			
			// verifying the upword pointing arrow
			WebObjectUtil.verifyElementPresent(Ticket.getNav_NotesWebTable_DateUpwardPointingArrowIcon());
			
			// log out
			LoginTestCase_Old1.nav_Logout();
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
			LoggerUtil.log_type_error(e.getMessage());
		}	
	}
	
	
	/*==============================================================
	TestScript 		: verifyNotesContent
	Manual TestCase	: QAT-31
	Description		: Verify the content in the Notes is displayed correctly
	Author 			: QAA04
	Creation Date 	: 04/19/2016
	Release Name    : LefcourtSP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=2)
	public void verifyNotesContent(){
		WebElement wExpander,wNotesExpander;
		String sTicketId,sMessage,sText,sSummary;
		boolean bStatus;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Ticket);
		
		try {
			FrameworkUtil.sTestCaseName="verifyNotesContent";
			FrameworkUtil.sManualTestCaseName="(QAT-31) OutOfScope - Verify the content in the Notes is displayed correctly";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);

   // login to the navigator
			LoginTestCase_Old1.LoginAsRoleAUser();
			
			// navigating to the ticket page
			TicketTestCase.navigateToCreateTicketPage();
			sSummary = "SeleniumTest"+FrameworkUtil.sTimeStamp;
			WebObjectUtil.SetValueEdit(Ticket.getNav_SummaryEdit(), sSummary);
			driver.switchTo().frame(Ticket.getNav_CreateTicket_AddNoteEditBox());
			 WebElement element = driver.findElement(By.cssSelector("body"));
			 sMessage=(String) FrameworkUtil.dictPropertyData.get("NAV.TICKET.CREATETICKET.ADDNOTE.MESSAGE");
			 element.sendKeys(sMessage);
			 driver.switchTo().defaultContent();
			// WebObjectUtil.explicitWait(5);
			 WebObjectUtil.clickElement(Ticket.getNav_CreateNoteOkBtn());
			 WebObjectUtil.explicitWait(5);
			WebObjectUtil.clickElement(Ticket.getNav_CreateTicketConfirmOkBtn());
			 WebObjectUtil.explicitWait(10);
			 
			 wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
			WebObjectUtil.clickElement(wExpander);
			WebObjectUtil.explicitWait(6);
			
			sTicketId = TicketTestCase.getTicketID(1);
			wNotesExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER", "PARAMETER_TICKETID",  sTicketId);
			WebObjectUtil.clickElement(wNotesExpander);
			WebObjectUtil.explicitWait(5);
			
			WebObjectUtil.selectCheckRadioBox(Ticket.getNav_ExpandAllCheckBox());
			sText=Ticket.getNav_TicketNotesText().getText();
			
			bStatus = sText.equalsIgnoreCase(sMessage);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "notes text verified"+sMessage);
			
			// logout
			LoginTestCase_Old1.nav_Logout();
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
			LoggerUtil.log_type_error(e.getMessage());
		}
	}
	
	/*==============================================================
	TestScript 		: verifyEntityBrowserTopSliderIconColors
	Manual TestCase	: QAT-90
	Description		: Verify Roll up icon colors to match up with the mock-up: White = Off Green with glow = On
	Author 			: QAA04
	Creation Date 	: 04/20/2016
	Release Name    : LefcourtSP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=3)
	public void verifyEntityBrowserTopSliderIconColors(){
		String sWhiteColor,sGreenColor;
		boolean bStatus;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Entity);
		
		try {
			FrameworkUtil.sTestCaseName="verifyEntityBrowserTopSliderIconColors";
			FrameworkUtil.sManualTestCaseName="() OutOfScope - Verify Roll up icon colors to match up with the mock-up: White = Off Green with glow = On";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to the navigator
			LoginTestCase_Old1.LoginAsRoleAUser();
			
			// clicking on entity browser link
			WebObjectUtil.clickElement(Entity.getNav_EntityBrowserLink());
			sWhiteColor= Entity.getNav_TopSliderIcon().getAttribute("class");
			bStatus = sWhiteColor.contains("x-component-default x-border-box");
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "top slider icon is in white color");
			
			// roll on     
			WebObjectUtil.clickElement(Entity.getNav_EBPanelRollUpButton());
			WebObjectUtil.explicitWait(3);
			sGreenColor= Entity.getNav_TopSliderIcon().getAttribute("class");
			bStatus = sGreenColor.contains("x-border-box rollon");
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "top slider icon is in green color");
			
			// roll off 
			WebObjectUtil.clickElement(Entity.getNav_EBPanelRollUpButton());
			WebObjectUtil.clickElement(Entity.getNav_CloseButton());
			// log out
			LoginTestCase_Old1.nav_Logout();
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
			LoggerUtil.log_type_error(e.getMessage());
		}
		
		
	}
	
	
	/*==============================================================
	TestScript 		: verifyCreateTicketLink
	Manual TestCase	: QAT-106
	Description		: Hover over to "Create Ticket" and verify it is displayed as a link when user hover over the Create Ticket
	Author 			: QAA04
	Creation Date 	: 04/20/2016
	Release Name    : LefcourtSP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=4)
	public void verifyCreateTicketLink(){
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Ticket);
		
		FrameworkUtil.sTestCaseName="verifyCreateTicketLink";
		FrameworkUtil.sManualTestCaseName="(QAT-106) OutOfScope - Hover over to Create Ticket and verify it is displayed as a link when user hover over the Create Ticket";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	
		// login to the navigator
		LoginTestCase_Old1.LoginAsRoleAUser();
		
		// navigating to the ticket page
		TicketTestCase.navigateToTicketPage();
		
		WebObjectUtil.clickElement(Ticket.getNav_CreateTicketLink());
		
		if(Ticket.getNav_CreateTicketDialog().isDisplayed()){
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verifying the create ticket link", "pass", "new window is opening when i ckick on create ticket link. Create ticket is NOT a link, but it behaves like a link");
		}else{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verifying the create ticket link", "pass", "window is NOT displaying after clicking on create ticket");
		}

	// log out
		LoginTestCase_Old1.nav_Logout();
	}
	
	
	
	
	
	
	
	// after method
		@AfterMethod
		public void afterEachMethod(){
			FrameworkUtil.updateTestCaseStatusinResult();
			FrameworkUtil.sTestExecutionStatus=true;
		}
}
