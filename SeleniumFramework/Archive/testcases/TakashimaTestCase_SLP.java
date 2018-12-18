package com.whs.navigator.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.FormPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory;

public class TakashimaTestCase_SLP {
	 public static FormPageFactory Forms = new FormPageFactory();
	 public static HomePageFactory Home = new HomePageFactory();
	 
	/*==============================================================
	TestScript  	: verifyResetPasswordPageNotdisplayedAfterLogin
	Manual TestCase	: [QAT-1550] WCP_5548_TC_1.0_Remove WOL popup
	Description		: 
	Author 			: QAA03
	Creation Date 	: 07/14/2016
	Release Name    : Takashima
	Pre-Requisites	: 
	Revision History:
  ==============================================================*/
	
	@Test(priority=31)
	public void verifyResetPasswordPageNotdisplayedAfterLogin()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, Forms);
			PageFactory.initElements(driver, Home);
			String sCompleteOrderColumn=null,sColumnName=null;
		    boolean bColumnStatus=false;
							
		try {
			FrameworkUtil.sTestCaseName = "ResetPassword-verifyResetPasswordPageNotdisplayedAfterLogin";
			FrameworkUtil.sManualTestCaseName="[QAT-1550] WCP_5548_TC_1.0_Remove WOL popup";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
													
		    // Login to navigator with Qaauto-A user
			LoginTestCase.LoginAsQaautoAUser();
			
			WebObjectUtil.verifyElementNOTPresent(Home.getNav_HomeTempPopUpOk());
                      			
			// Logout from Navigator
			LoginTestCase.nav_Logout();
		
		   } catch (Exception e) {
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyResetPasswordPageNotdisplayedAfterLogin", "warn", "catch block:" +e.getMessage());
		}
	}
	
	/*==============================================================
	TestScript  	: verifyLeftMenuWindowonForms3Page
	Manual TestCase	: [QAT-1556] WCP_5640_TC_1.0_Change label name from EM7 Ticket to Ticket # in the Menu on Forms page.
	Description		: 
	Author 			: QAA03
	Creation Date 	: 07/14/2016
	Release Name    : Takashima
	Pre-Requisites	: 
	Revision History:
  ==============================================================*/
	
	@Test(priority=32)
	public void verifyLeftMenuWindowonForms3Page()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, Forms);
			String sFormName=null,sFormOrderType=null,sTicketNumber=null,sColumnName=null,sMenuTicketNumber=null,sMenuTicketText;
			String sTktNumber [];
		    boolean bMenuStatus=false;
							
		try {
			FrameworkUtil.sTestCaseName = "Forms-verifyLeftMenuWindowonForms3Page";
			FrameworkUtil.sManualTestCaseName="[QAT-1556] WCP_5640_TC_1.0_Change label name from EM7 Ticket to Ticket # in the Menu on Forms page.";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			sFormName=(String)FrameworkUtil.dictPropertyData.get("NAV.FORMS.FORMNAME");
			sFormOrderType = (String)FrameworkUtil.dictPropertyData.get("NAV.FORMS.ORDERTYPE.TICKET");
			sColumnName=(String)FrameworkUtil.dictPropertyData.get("NAV.FORMS.COMPLETEDORDER.COLUMNNAME");
																
		    // Login to navigator with Qaauto-A user
			LoginTestCase.LoginAsQaautoAUser();
			
			// Navigating to Forms Page
            FormTestCase.navToFormsPage();
           
            // Getting the sales order with order type specified which is having only one incomplete form
            sTicketNumber =KyleTestCase_SLP.getSalesOrderByFormName(sFormName, sFormOrderType,true);
            
            sTktNumber = sTicketNumber.split(" ");
            
            WebObjectUtil.verifyElementPresent(Forms.getNav_Forms_ReviewAndSubmit_LeftMenuButton());
		    WebObjectUtil.clickElement(Forms.getNav_Forms_ReviewAndSubmit_LeftMenuButton());
		    WebObjectUtil.verifyElementPresent(Forms.getNav_Forms_ReviewAndSubmit_LeftMenuWindow());
		    
		    WebObjectUtil.clickElement(Forms.getNav_Forms_ReviewAndSubmit_LeftMenuWindow());
		    
		    sMenuTicketText = Forms.getNav_Forms_ReviewAndSubmit_LeftMenuWindow_TicketText().getText();
		    sMenuTicketNumber = Forms.getNav_Forms_ReviewAndSubmit_LeftMenuWindow_TicketNumber().getText();
		    
		    bMenuStatus = sMenuTicketText.contains(sColumnName) && sMenuTicketNumber.contains(sTktNumber[1]);
		    
		    FrameworkUtil.updateCustomResultBasedOnStatus(bMenuStatus, "Left menu bar contains Customer Dashboard "+sMenuTicketText+" and Ticket Number " +sMenuTicketNumber);
		    
             			
            // Logout from Navigator
			LoginTestCase.nav_Logout();
		
		   } catch (Exception e) {
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyLeftMenuWindowonForms3Page", "warn", "catch block:" +e.getMessage());
		}
	}
	

	@AfterMethod
	public static void afterEachMethod(){
			FrameworkUtil.updateTestCaseStatusinResult();
			
		}

}
