package com.whs.navigator.testcases;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.CustomWebElementUtil;
import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.commonUtil.WebTableUtil;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.EVDC_VM_PageFactory;
import com.whs.navigator.pagefactory.EscalationPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory;
import com.whs.navigator.pagefactory.LoadBalancerPageFactory;
import com.whs.navigator.pagefactory.LoginPageFactory;
import com.whs.navigator.pagefactory.SmokeTestPageFactory;
import com.whs.navigator.pagefactory.DraasPageFactory;
import com.whs.navigator.pagefactory.CommonPageFactory;
import com.whs.navigator.pagefactory.TicketPageFactory;
import com.whs.navigator.testcases.TicketTestCase;
import com.whs.navigator.pagefactory.FirewallPageFactory;
import com.whs.navigator.pagefactory.EM7PageFactory;
import com.whs.navigator.pagefactory.FormPageFactory;
import com.whs.navigator.pagefactory.EntityBrowserPageFactory;
import com.whs.navigator.pagefactory.FormPageFactory;
import com.whs.navigator.testcases.LoginTestCase;
import com.whs.navigator.pagefactory.UserPermissionPageFactory;
import com.whs.navigator.testcases.EntityBrowserTestCase;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
public class TalonTestCase_Priyanka {
	
	public static HomePageFactory Home = new HomePageFactory();
	public static TicketPageFactory Ticket = new TicketPageFactory();
	public static TicketTestCase TicketTC =new TicketTestCase();
	public static SmokeTestPageFactory Smoke = new SmokeTestPageFactory();
	public static EVDC_VM_PageFactory EVDC_VMPF=new EVDC_VM_PageFactory();
	public static EVDC_OverviewPageFactory EVDC_OverviewPF = new EVDC_OverviewPageFactory();
	public static EntityBrowserPageFactory EBPanel = new EntityBrowserPageFactory();
	public static CommonPageFactory Common=new CommonPageFactory();
	public static DraasPageFactory Draas=new DraasPageFactory();
	public static FirewallPageFactory FireWall=new FirewallPageFactory();
	public static FormPageFactory Forms =new FormPageFactory();
	public static UserPermissionPageFactory UserPermission = new UserPermissionPageFactory(); 
	public static  EscalationPageFactory Escalation = new EscalationPageFactory();
	public static LoginPageFactory login = new LoginPageFactory();
	public static FormPageFactory Form =  new FormPageFactory();
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
			PageFactory.initElements(driver, Home);
			PageFactory.initElements(driver, Form);
			
			try {
				
				String sToolTipMsgs=(String) FrameworkUtil.dictPropertyData.get("FORM.TOOL.TIP.MESSAGE");
				String sFormOrderType = (String)FrameworkUtil.dictPropertyData.get("NAV.FORMS.ORDERTYPE.TICKET");
				String sDeleteClr,sActualclr="white";
				FrameworkUtil.sTestCaseName = "verifyContactFormChanges";
				FrameworkUtil.sManualTestCaseName="QAT-537-WCP_CPPOC-4503_TC-2.00_Contact Form_Confirm Changes_Colors and Format";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
				String sFormName="Contact Information";
				//Login to Navigator
				LoginTestCase.LoginAsQaautoAUser();
				WebObjectUtil.explicitWait(5);
				WebObjectUtil.ClickAndMouseHover(Ticket.getNav_SupportTabLink());
				//WebObjectUtil.explicitWait(5);
				WebObjectUtil.clickElement(Home.getNav_BuildReqMenuLink());
				WebObjectUtil.explicitWait(5);
				//searchContactFormSalesOrder(sFormName);
				KyleTestCase_SLP.getSalesOrderByFormName(sFormName, sFormOrderType, true);
				WebObjectUtil.clickElement(Forms.getNav_ContactInfoAddContactLink());
				WebObjectUtil.explicitWait(5);
				WebObjectUtil.verifyElementPresent(Form.getNav_EditFormDeleteButton());
				sDeleteClr=Form.getNav_EditFormDeleteButton().getCssValue("color");
				if(sDeleteClr.equalsIgnoreCase(sActualclr))
				   {
				   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "" , "", "pass", "Displayed color is :"+ sDeleteClr );
				   }
				else
				   {
				   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "" , "", "fail", "Displayed color is :"+ sDeleteClr );
				   }
				TalonTestCase_NMR.fillRequiredFields(1, "USER", "Automation" , "Test@gmail.com", "United States(+1)", "541-754-3010", "3010", "United States(+1)", "9848022338","Do not contact for escalation", "Cloud Portal Access - User");
				WebObjectUtil.explicitWait(3);
				WebObjectUtil.verifyElementPresent(Form.getNav_EditFormResetButton());
				WebObjectUtil.clickElement(Form.getNav_EditFormResetButton());
				WebObjectUtil.clickElement(Form.getNav_ResetContactFormOkButton());
				WebObjectUtil.explicitWait(3);
				WebObjectUtil.clickElement(Forms.getNav_ContactInfoSaveButton());
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
	
				
			} catch (Exception e) {
				LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
			
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

		public static void fillContactInfoEditFields(String sFirstName, String sLastName, String sEmail, String sPhoneNumber, String sEscalationDropDownVisibleText, String sUserRoleDropDownVisibleText){
			boolean bStatus;
			int iDelete;
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, Form);
			PageFactory.initElements(driver, Common);
			try {
				bStatus = WebObjectUtil.verifyElementPresent(Form.getNav_ContactInfoFirstNameInput());
				if(bStatus){
					//delete = (List<WebElement>) Form.getNav_ContactInfoDeleteButton().getSize();
					iDelete = driver.findElements(By.xpath("//span[text()='Delete']")).size();
					//int iDelete = delete.size();
				    
					    for(int i=1; i<=iDelete; i++){
							WebObjectUtil.clickElement(Form.getNav_ContactInfoDeleteButton());
							WebObjectUtil.explicitWait(3);
							WebObjectUtil.clickElement(Common.getNav_PopUpOKBtn());
							WebObjectUtil.explicitWait(5);
				          }
					   
					    WebObjectUtil.clickElement(Form.getNav_ContactInfoAddContactLink());
					    WebObjectUtil.explicitWait(3);
					   fillRequiredFields(sFirstName, sLastName, sEmail, sPhoneNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText);
					
				}else{
					WebObjectUtil.clickElement(Form.getNav_ContactInfoAddContactLink());
					WebObjectUtil.explicitWait(5);
					fillRequiredFields(sFirstName, sLastName, sEmail, sPhoneNumber, sEscalationDropDownVisibleText, sUserRoleDropDownVisibleText);
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
		Creation Date 	: 05/10/2016
		release Name    : 
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		public static void fillRequiredFields(String sFirstName, String sLastName, String sEmail, String sPhoneNumber, String sEscalationDropDownVisibleText, String sUserRoleDropDownVisibleText){
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, Form);
			
			try {
				WebObjectUtil.SetValueEdit(Form.getNav_ContactInfoFirstNameInput(), sFirstName);
				WebObjectUtil.SetValueEdit(Form.getNav_ContactInfoLastNameInput(), sLastName);
				WebObjectUtil.SetValueEdit(Form.getNav_ContactInfoEmailInput(), sEmail);
				WebObjectUtil.SetValueEdit(Form.getNav_ContactInfoAreaCodePhoneNumberInput(), sPhoneNumber);
				
				LefCourt_SP2TestCase_NMR.SelectElementFromDropDown(Form.getNav_ContactInfoEscalationDropDownArrow(), sEscalationDropDownVisibleText);
				LefCourt_SP2TestCase_NMR.SelectElementFromDropDown(Form.getNav_ContactInfoUserRoleDropDownArrow(), sUserRoleDropDownVisibleText);
			
			} catch (Exception e) {
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
				}

		}


	

    
    

	
	//update each @test result in custom result file
		@AfterMethod
		public static void afterEachMethod(){
		FrameworkUtil.updateTestCaseStatusinResult();

}
}
