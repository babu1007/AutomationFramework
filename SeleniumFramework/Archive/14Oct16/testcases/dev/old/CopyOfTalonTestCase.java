package com.whs.navigator.testcases.dev.old;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.crypto.dsig.keyinfo.PGPData;


import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




import com.whs.navigator.commonUtil.CustomWebElementUtil;
import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.commonUtil.WebTableUtil;
import com.whs.navigator.pagefactory.CommonPageFactory;
//import com.whs.navigator.pagefactory.EVDC_FirewallPageFactory;
import com.whs.navigator.pagefactory.FirewallPageFactory;
import com.whs.navigator.pagefactory.FormPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.ServicesPageFactory;
//import com.whs.navigator.pagefactory.AddFirewallPageFactory;
import com.whs.navigator.pagefactory.UserPermissionPageFactory;
import com.whs.navigator.commonUtil.CustomWebElementUtil;


public class CopyOfTalonTestCase {

	static CommonPageFactory CommonPF = new CommonPageFactory();
	public static FirewallPageFactory Firewall = new FirewallPageFactory();
	public static HomePageFactory_old HomePF = new HomePageFactory_old();
	public static UserPermissionPageFactory UserPermission=new UserPermissionPageFactory();
	public static ServicesPageFactory ServicesPF= new ServicesPageFactory();
	//public static EVDC_FirewallPageFactory EVDC_Firewall=new EVDC_FirewallPageFactory();
    static HomeTestCase HomeTestcase = new HomeTestCase();
    static AddFirewallRuleTestCase AddFirewallRuleTestcase = new AddFirewallRuleTestCase();
    static TalonTestCase_Vivek TalonTestCase_Vivek=new TalonTestCase_Vivek();
    static FormTestCase FormTC=new FormTestCase();
    static TalonTestCase_NMR TalonTestCase_NMR=new TalonTestCase_NMR();
    static FormPageFactory FormPF=new FormPageFactory();
	//String sFileNamePath=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.ADD.EXCEL.FILE.PATH");
	

	/*==============================================================
	TestScript 		: validateAddServicesPageTextandContactNumber
	Manual TestCase	: VTalon QAT-741&747
	Description		:Verify that when user clicks on "Add Services" with "+" sign in portlet on landing page , user is navigated to Services marketing page with Services image and contact number on it along with Tierpoint text.
	Author 			: Sukur Babu
	Creation Date 	: 20/04/2016
	Pre-Requisites	:
	Revision History:
	
	==============================================================*/
	@Test(priority=1)
	public void validateAddServicesPageTextandContactNumber(){
		
		String sContactNumber;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, CopyOfTalonTestCase.Firewall);
		PageFactory.initElements(driver, UserPermission);
		PageFactory.initElements(driver, CommonPF);
		PageFactory.initElements(driver, ServicesPF);
		PageFactory.initElements(driver, HomePF);
		PageFactory.initElements(driver, FormPF);
		FrameworkUtil.sTestCaseName = "TalonQAT-741&747-validateAddServicesPageTextandContactNumber";
		FrameworkUtil.sManualTestCaseName="Verify that when user clicks on Add Services with + sign in portlet on landing page , user is navigated to Services marketing page with Services image and contact number on it along with Tierpoint text.";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		sContactNumber=(String)FrameworkUtil.dictPropertyData.get("NAV.SERVICES.CONTACT.NUMBER");
//		String sFireWallRuleToExpand=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.FIREWALLRULETOEXPAND");

		LoginTestCase.LoginAsDevcoUser();
		WebObjectUtil.verifyElementPresent(HomePF.getNav_AddServicesLink());
		//WebObjectUtil.clickElement(HomePF.getNav_AddServicesLink());
		HomeTestCase.verifyBreadScrumb(HomePF.getNav_AddServicesLink(), "Services");
		WebObjectUtil.clickElement(HomePF.getNav_AddServicesLink());
		WebObjectUtil.verifyElementPresent(ServicesPF.getNav_ServicesImage());
		WebObjectUtil.verifyElementPresent(ServicesPF.getNav_ServicesTierPointText());
		WebObjectUtil.verifyElementPresent(ServicesPF.getNav_ServicesTierPointLearnMoreText());
		if(ServicesPF.getNav_ServicesTierPointLearnMoreText().getText().contains(sContactNumber))
			FrameworkUtil.updateCustomResultBasedOnStatus(true,sContactNumber+" is same as displayed in Services page TierPoint learn more... text");
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false,sContactNumber+" is same as displayed in Services page TierPoint learn more... text");
		
		LoginTestCase.nav_Logout();
		
		
		
	}
	
	/*==============================================================
	TestScript 		: testFieldValidationforSalesForm
	Manual TestCase	: 
	Description		:
	Author 			: Sukur Babu
	Creation Date 	: 25/04/2016
	Pre-Requisites	:
	Revision History:
	
	==============================================================*/
	@Test(priority=2)
	public void testFieldValidationforSalesForm(){
		
		String sFileNamePath,sSheetName;
		String sCellData = null;
		XSSFSheet xSheet;
		FileInputStream file;
		
		String sSveAndCntBtnFDBKMsg,sSveBtnFDBKMsg,sFrstNameReqMsg,sLstNameReqMsg,sEmailReqMsg,sWrkPhneReqMsg;
		String sFrstNameInvldMsg,sLstNameInvldMsg,sEmailInvldMsg,sWrkPhneInvldMsg,sCelPhneInvldMsg;
		String sActFeedBackMsg = null;
		int iFrstNmeColVal,iLstNmeColVal,iEmailColVal,iWrkPhneColVal,iExtnColVal,iCellPhneColVal,iExeFlagColVal,iStsColVal,iTypeOfValColVal,iFieldsToValidateColVal;
		//int sExcelWrkPhoneVal,sExcelExtnVal,sExcelCellPhoneVal;
		String sExcelWrkPhoneVal,sExcelExtnVal,sExcelCellPhoneVal,sExcelFirstNameVal,sExcelLstNameVal,sExcelEmailVal,sExcelStatusVal,sExeFlagVal,sExcelTypeOfValidationVal,sExcelFieldsToValidateVal;
		String[] sFieldsNeedToValidateArray;
		String sEscalationValList,sUserRoleValList;
		String sExcelWrkPhoneCntryVal,sExcelCellPhoneCntryVal,sExcelEscalationVal,sExcelUserRoleVal;
		 int iWrkPhneCntryColVal,iCellPhneCntryColVal,iEscalationColVal,iUserRoleColVal;
		WebElement wFirstNameElement,wLastNameElement,wEmailNameElement,wWrkPhoneElement,wCellPhoneElement;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, CopyOfTalonTestCase.Firewall);
		PageFactory.initElements(driver, UserPermission);
		PageFactory.initElements(driver, CommonPF);
		PageFactory.initElements(driver, ServicesPF);
		PageFactory.initElements(driver, HomePF);
		PageFactory.initElements(driver, FormPF);
		
		FrameworkUtil.sTestCaseName = "testFieldValidationforSalesForm";
		FrameworkUtil.sManualTestCaseName="Talon- Field Level Validation Test cases";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		//Read all required field error messages and invalid data validation messages from properties file
		
//		String sActFirstNameToolTipMsg=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
		
		
		//Get the firewall rule test data file path
		sFileNamePath=(String)FrameworkUtil.dictPropertyData.get("NAV.FRMS.FLD.VAL.EXCEL.FILE.PATH");
		//Get the firewall rule test data sheet
		sSheetName=(String)FrameworkUtil.dictPropertyData.get("NAV.FRMS.FLD.VAL.EXCEL.SHEET");
		
//		sSveAndCntBtnFDBKMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.REQUIRED.TESTDATA.SAVEANDCONTINUE.BUTTON.CLICK.FEEDBACK.MESSAGE");
//		sSveBtnFDBKMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.REQUIRED.TESTDATA.SAVE.BUTTON.CLICK.FEEDBACK.MESSAGE");
//		sFrstNameReqMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.REQUIRED.TESTDATA.FIRSTNAME.TEXT.TABOUT.TOOLTIP.MESSAGE");
//		sLstNameReqMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.REQUIRED.TESTDATA.LASTNAME.TEXT.TABOUT.TOOLTIP.MESSAGE");
//		sEmailReqMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.REQUIRED.TESTDATA.EMAIL.TEXT.TABOUT.TOOLTIP.MESSAGE");
//		sWrkPhneReqMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.REQUIRED.TESTDATA.WORKPHONE.TEXT.TABOUT.TOOLTIP.MESSAGE");
//		
//		sFrstNameInvldMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.INVALID.TESTDATA.FIRSTNAME.TEXT.TABOUT.TOOLTIP.MESSAGE");
//		sLstNameInvldMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.INVALID.TESTDATA.LASTNAME.TEXT.TABOUT.TOOLTIP.MESSAGE");
//		sEmailInvldMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.INVALID.TESTDATA.EMAIL.TEXT.TABOUT.TOOLTIP.MESSAGE");
//		sWrkPhneInvldMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.INVALID.TESTDATA.WORKPHONE.TEXT.TABOUT.TOOLTIP.MESSAGE");
//		sCelPhneInvldMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.INVALID.TESTDATA.CELLPHONE.TEXT.TABOUT.TOOLTIP.MESSAGE");
		
		sEscalationValList=(String)FrameworkUtil.dictPropertyData.get("NAV.ESCALATION.LIST.VALUES");
		sUserRoleValList=(String)FrameworkUtil.dictPropertyData.get("NAV.RSER.ROLE.LIST.VALUES");
		
		XSSFWorkbook xWrkBook=AddFirewallRuleTestCase.getWB(sFileNamePath);
		xSheet=xWrkBook.getSheet(sSheetName);
			
		iExeFlagColVal=AddFirewallRuleTestCase.getColumnNumber(xSheet,"Execute");
		iFrstNmeColVal=AddFirewallRuleTestCase.getColumnNumber(xSheet,"First Name");
		iLstNmeColVal=AddFirewallRuleTestCase.getColumnNumber(xSheet,"Last Name");
		iEmailColVal=AddFirewallRuleTestCase.getColumnNumber(xSheet,"Email Address");
		iWrkPhneCntryColVal=AddFirewallRuleTestCase.getColumnNumber(xSheet,"Work Phone Country");
		iWrkPhneColVal=AddFirewallRuleTestCase.getColumnNumber(xSheet,"Work Phone");
		iExtnColVal=AddFirewallRuleTestCase.getColumnNumber(xSheet,"Extn");
		iCellPhneCntryColVal=AddFirewallRuleTestCase.getColumnNumber(xSheet,"Cell Phone Country");
		iCellPhneColVal=AddFirewallRuleTestCase.getColumnNumber(xSheet,"Cell Phone");
		iEscalationColVal=AddFirewallRuleTestCase.getColumnNumber(xSheet,"Escalation");
		iUserRoleColVal	=	AddFirewallRuleTestCase.getColumnNumber(xSheet,"User Role");
		iTypeOfValColVal=AddFirewallRuleTestCase.getColumnNumber(xSheet,"Type Of Validation R/T/L/D");
		iFieldsToValidateColVal=AddFirewallRuleTestCase.getColumnNumber(xSheet,"Fields Validate");
		iStsColVal=AddFirewallRuleTestCase.getColumnNumber(xSheet,"Status");
		
		LoginTestCase.LoginAsQaautoAUser();

		//Navigate to Sales Order Form. GET IT FROM VIVEK AND IT BELOW
		FormTC.navToFormsPage();
		String sSalesNumber=TalonTestCase_Vivek.getSalesOrderByFormName("Contact Information");
		System.out.println(sSalesNumber);
		//TalonTestCase_NMR.navigatingToForm3Page(sSalesNumber,"Contact Information");
		//Once Vivek function is ready then i need to remove following 2 lines
//		WebObjectUtil.clickElement(FormPF.getNav_SalesOrder());
//		WebObjectUtil.clickElement(FormPF.getNav_SSalesOrderFormContinueButton());
		if(!WebObjectUtil.isElementPresent(FormPF.getNav_ContactInfoFirstNameInput()))	
			WebObjectUtil.clickElement(FormPF.getNav_ContactInfoAddContactLink());
		else
		{
			WebObjectUtil.clickElement(FormPF.getNav_ContactInfoResetButton());
			WebObjectUtil.verifyElementPresent(CommonPF.getNav_CommonPopUpOKButton());
			WebObjectUtil.clickElement(CommonPF.getNav_CommonPopUpOKButton());
		}
		int iRowCnt=xSheet.getLastRowNum();
        for(int row=1;row<=iRowCnt;row++)
        {
        	//Read the execution flag value from excel. If y, perform the field validation for the test data rule
        	sExeFlagVal=AddFirewallRuleTestCase.getExcelCellData(xSheet,row,iExeFlagColVal);
        	//please pass any character value using properties file
        	if(sExeFlagVal.equalsIgnoreCase("y"))
        	{
        		
        		//Read all the data from excel sheet
	        	sExcelFirstNameVal=AddFirewallRuleTestCase.getExcelCellData(xSheet,row,iFrstNmeColVal);
	        	sExcelLstNameVal=AddFirewallRuleTestCase.getExcelCellData(xSheet,row,iLstNmeColVal);
	        	sExcelEmailVal=AddFirewallRuleTestCase.getExcelCellData(xSheet,row,iEmailColVal);
	        	sExcelWrkPhoneCntryVal=AddFirewallRuleTestCase.getExcelCellData(xSheet,row,iWrkPhneCntryColVal);
//	        	sExcelWrkPhoneVal=Integer.parseInt(AddFirewallRuleTestCase.getExcelCellData(xSheet,row,iWrkPhneColVal));
//	        	sExcelExtnVal=Integer.parseInt(AddFirewallRuleTestCase.getExcelCellData(xSheet,row,iExtnColVal));
	        	sExcelWrkPhoneVal=AddFirewallRuleTestCase.getExcelCellData(xSheet,row,iWrkPhneColVal);
	        	sExcelExtnVal=AddFirewallRuleTestCase.getExcelCellData(xSheet,row,iExtnColVal);
	        	sExcelCellPhoneCntryVal=AddFirewallRuleTestCase.getExcelCellData(xSheet,row,iCellPhneCntryColVal);
//	        	sExcelCellPhoneVal=Integer.parseInt(AddFirewallRuleTestCase.getExcelCellData(xSheet,row,iCellPhneColVal));
	        	sExcelCellPhoneVal=AddFirewallRuleTestCase.getExcelCellData(xSheet,row,iCellPhneColVal);
	        	sExcelEscalationVal=AddFirewallRuleTestCase.getExcelCellData(xSheet,row,iEscalationColVal);
	        	sExcelUserRoleVal=AddFirewallRuleTestCase.getExcelCellData(xSheet,row,iUserRoleColVal);
	        	//sExcelStatusVal=AddFirewallRuleTestCase.getExcelCellData(xSheet,row,iStsColVal);
	        	//Split Work Phone and get Area code, etc into varaible
	        	sExcelTypeOfValidationVal=AddFirewallRuleTestCase.getExcelCellData(xSheet,row,iTypeOfValColVal);
	        	sExcelFieldsToValidateVal=AddFirewallRuleTestCase.getExcelCellData(xSheet,row,iFieldsToValidateColVal);
	        	

	        	wFirstNameElement=FormPF.getNav_ContactInfoFirstNameInput();
				wLastNameElement=FormPF.getNav_ContactInfoLastNameInput();
				wEmailNameElement=FormPF.getNav_ContactInfoEmailInput();
	        	wWrkPhoneElement=FormPF.getNav_ContactInfoAreaCodePhoneNumberInput();
	        	wCellPhoneElement=FormPF.getNav_ContactInfoCellPhoneAreaCodeNumberInput();
	        	switch(sExcelTypeOfValidationVal)
	        	{
	        	case "REQUIRED":
	        		validateRequiredFieldsAftrSaveAndContinueBtnClick( sExcelFieldsToValidateVal, wFirstNameElement, sExcelFirstNameVal, wLastNameElement, sExcelLstNameVal, wEmailNameElement, sExcelEmailVal, wWrkPhoneElement,sExcelWrkPhoneVal,xWrkBook,xSheet,row,iStsColVal);
	        		break;
	        	case "INVALID":
	        		validateInvlidDataFieldsAftrSaveAndContinueBtnClick( sExcelFieldsToValidateVal, wFirstNameElement, sExcelFirstNameVal, wLastNameElement, sExcelLstNameVal, wEmailNameElement, sExcelEmailVal, wWrkPhoneElement,sExcelWrkPhoneVal,wCellPhoneElement,sExcelCellPhoneVal,xWrkBook,xSheet,row,iStsColVal);
	        		
	        		break;
	        	case "DEFAULT":
	        		validateDefaultValueDisplayedinField( sExcelFieldsToValidateVal, sExcelFirstNameVal, sExcelLstNameVal, sExcelEmailVal, sExcelWrkPhoneVal, sExcelWrkPhoneCntryVal, sExcelExtnVal, sExcelCellPhoneCntryVal, sExcelCellPhoneVal, sExcelEscalationVal, sExcelUserRoleVal, xWrkBook, xSheet, row, iStsColVal);
	        		break;
	        	case "LENGTH":
	        		validateLengthOfFieldsAftrSaveAndContinueBtnClick( sExcelFieldsToValidateVal,  sExcelFirstNameVal,  sExcelLstNameVal,sExcelEmailVal, sExcelWrkPhoneVal,  sExcelExtnVal,  sExcelCellPhoneVal, xWrkBook, xSheet, row, iStsColVal);
	        		break;
	        	case "VALID":
	        		String[] sEscalationitems=sEscalationValList.split(",");
	        		String[] sUserRolesitems=sUserRoleValList.split(",");
	        		for(int i=0;i<sEscalationitems.length;i++)
	        		{
	        			for(int j=0;j<sUserRolesitems.length;j++)
	        				fillAndSaveFormwithdifferentEscalationAndUserRoleItems(sExcelFirstNameVal, sExcelLstNameVal, sExcelEmailVal, sExcelWrkPhoneVal, sExcelWrkPhoneCntryVal, sExcelExtnVal, sExcelCellPhoneCntryVal, sExcelCellPhoneVal, sEscalationitems[i], sUserRolesitems[j]);
	        		}
	        		
	        	default:
	        		
	        		System.out.println("Check the type of validation in Forms input data excel file for the row  "+row);
	        		//FrameworkUtil.updateCustomResultBasedOnStatus(false, "Check the type of validation in Forms input data excel file for the row  "+row);
	        		//FrameworkUtil.writeCustomResult(sStepNo, sWebObject, sUserAction, sStatus, sRemarks);
	        		break;
	        	
	        		
	        	}

        	}
	
        }
        AddFirewallRuleTestCase.saveExcel(xWrkBook,sFileNamePath);
		LoginTestCase.LoginAsDevcoUser();
		
	}
	public static void fillAndSaveFormwithdifferentEscalationAndUserRoleItems(String sExcelFirstNameVal,String sExcelLstNameVal,String sExcelEmailVal,String sExcelWrkPhoneVal,String sExcelWrkPhoneCntryVal,String sExcelExtnVal,String sExcelCellPhoneCntryVal,String sExcelCellPhoneVal,String sExcelEscalationVal,String sExcelUserRoleVal)
	{
		String sSuccFeedBackMsg,sActFeedBackMsg;
		sSuccFeedBackMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.FORM.SUCESS.FEEDBACK.MESSAGE");
		String sULElementXpath = (String) FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
		WebElement wDropDown;
		
		WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoFirstNameInput(), sExcelFirstNameVal);
		WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoLastNameInput(), sExcelLstNameVal);
		WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoEmailInput(), sExcelEmailVal);
		//WebObjectUtil.SetValueEdit(FormPF., sExcelWrkPhoneCntryVal);
		WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoAreaCodePhoneNumberInput(), sExcelWrkPhoneVal);
		WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoPhoneExtInput(),sExcelExtnVal);
		//WebObjectUtil.SetValueEdit(sExcelCellPhoneCntryVal);
		WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoCellPhoneAreaCodeNumberInput(),sExcelCellPhoneVal);
		System.out.println(sExcelEscalationVal.length());
		WebObjectUtil.clickElement(FormPF.getNav_ContactInfoEscalationDropDownArrow());
		wDropDown=WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
		WebObjectUtil.selectCustomWebList(wDropDown, sExcelEscalationVal);
		
		WebObjectUtil.clickElement(FormPF.getNav_ContactInfoUserRoleDropDownArrow());
		wDropDown=WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
		WebObjectUtil.selectCustomWebList(wDropDown, sExcelUserRoleVal);
		
	//	WebObjectUtil.clickElement(FormPF.getNav_ContactInfoSaveAndCOntinueButton());
		WebObjectUtil.clickElement(FormPF.getNav_ContactInfoSaveButton());
		WebObjectUtil.explicitWait(10);
		//Verify the feed back message after clicking Save and continue button
		sActFeedBackMsg=FormPF.getNav_FormFeedBackArea().getText();
		if(sActFeedBackMsg.equalsIgnoreCase(sSuccFeedBackMsg))
		{
			FrameworkUtil.updateCustomResultBasedOnStatus(true, sSuccFeedBackMsg+" is same as actual feed back message after clicking save/Save and continue by selecting Escalation item as "+sExcelEscalationVal+" and User Role item as "+sExcelUserRoleVal+" and actual feed back message for referrence is "+sActFeedBackMsg);
			//AddFirewallRuleTestCase.writeExcelData(xSheet,row,iStsColVal,"Executed and Observed that Passed");
			//AddFirewallRuleTestCase.fillExcelCellCOlor(xWrkBook,xSheet,row,iStsColVal,"GREEN");

		}else{
			FrameworkUtil.updateCustomResultBasedOnStatus(false, sSuccFeedBackMsg+" is not same as actual feed back message after clicking save/Save and continue by selecting Escalation item as "+sExcelEscalationVal+" and User Role item as "+sExcelUserRoleVal+" and actual feed back message for referrence is "+sActFeedBackMsg);
			//AddFirewallRuleTestCase.writeExcelData(xSheet,row,iStsColVal,"Executed and observed that Failed. For details verfiy Selenium HTML results");
			//AddFirewallRuleTestCase.fillExcelCellCOlor(xWrkBook,xSheet,row,iStsColVal,"RED");
			
			
			
		}
	}
	
	public static void validateRequiredFieldsAftrSaveAndContinueBtnClick(String sExcelFieldsToValidateVal,WebElement wFirstNameElemen,String sExcelFirstNameVal,WebElement wLastNameElement,String sExcelLstNameVal,WebElement wEmailNameElement,String sExcelEmailVal,WebElement wWrkPhoneElement,String sExcelWrkPhoneVal,XSSFWorkbook xWrkBook,XSSFSheet xSheet,int row,int iStsColVal)
	{

		String sActualErrorToolTipEntireText,sActFirstNameToolTipMsg = null,sActFeedBackMsg = null;
		String sSveBtnFDBKMsg,sLstNameReqMsg,sEmailReqMsg,sWrkPhneReqMsg,sSveAndCntBtnFDBKMsg,sFrstNameReqMsg;
		String[] sFieldsNeedToValidateArray;
		String sActFirstNameToolTipMsgFN,sActFirstNameToolTipMsgLN,sActFirstNameToolTipMsgEA,sActFirstNameToolTipMsgPN;
		//Enter all field values except first name, click on Save and Continue and verify feed back message and First name tool tip message
		boolean bFValTabOutSts=false,bSACValSts=false;	
		String sAllFldsToolTipMsg = null;
		sSveAndCntBtnFDBKMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.REQUIRED.TESTDATA.SAVEANDCONTINUE.BUTTON.CLICK.FEEDBACK.MESSAGE");
		sSveBtnFDBKMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.REQUIRED.TESTDATA.SAVE.BUTTON.CLICK.FEEDBACK.MESSAGE");
		sFrstNameReqMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.REQUIRED.TESTDATA.FIRSTNAME.TEXT.TABOUT.TOOLTIP.MESSAGE");
		sLstNameReqMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.REQUIRED.TESTDATA.LASTNAME.TEXT.TABOUT.TOOLTIP.MESSAGE");
		sEmailReqMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.REQUIRED.TESTDATA.EMAIL.TEXT.TABOUT.TOOLTIP.MESSAGE");
		sWrkPhneReqMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.REQUIRED.TESTDATA.WORKPHONE.TEXT.TABOUT.TOOLTIP.MESSAGE");

		sFieldsNeedToValidateArray=sExcelFieldsToValidateVal.split(",");
		if(sFieldsNeedToValidateArray.length==5)
		{
			FormPF.getNav_ContactInfoFirstNameInput().click();
			FormPF.getNav_ContactInfoFirstNameInput().clear();
			FormPF.getNav_ContactInfoLastNameInput().click();
			FormPF.getNav_ContactInfoLastNameInput().clear();
			FormPF.getNav_ContactInfoEmailInput().click();
			FormPF.getNav_ContactInfoEmailInput().clear();
			FormPF.getNav_ContactInfoAreaCodePhoneNumberInput().click();
			FormPF.getNav_ContactInfoAreaCodePhoneNumberInput().clear();
			
			//Click on Save and Continue button
			WebObjectUtil.clickElement(FormPF.getNav_ContactInfoSaveAndCOntinueButton());
			WebObjectUtil.explicitWait(10);
			//Verify the feed back message after clicking Save and continue button
			sActFeedBackMsg=FormPF.getNav_FormFeedBackArea().getText();
			if(sActFeedBackMsg.equalsIgnoreCase(sSveAndCntBtnFDBKMsg))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area object", "Required Field Validation After Save", "done", "Validating Test Data Row "+row );
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area object", "Required Field Validations After Save", "pass", "Expected is matching with Actual. Actual feedback messages is : " +sActFeedBackMsg);
				//AddFirewallRuleTestCase.writeExcelData(xSheet,row,iStsColVal,"Executed and Observed that Passed");
				//AddFirewallRuleTestCase.fillExcelCellCOlor(xWrkBook,xSheet,row,iStsColVal,"GREEN");
				bSACValSts=true;
			}else{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area object", "Required Field Validation After Save", "done", "Validating Test Data Row "+row );
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area object", "Required Field Validations After Save", "fail", "Expected message :"+sSveAndCntBtnFDBKMsg+" is not matching with Actual. Actual feedback messages is : " +sActFeedBackMsg);
				//AddFirewallRuleTestCase.writeExcelData(xSheet,row,iStsColVal,"Executed and observed that Failed. For details verfiy Selenium HTML results");
				//AddFirewallRuleTestCase.fillExcelCellCOlor(xWrkBook,xSheet,row,iStsColVal,"RED");
				bSACValSts=false;
			}
			FormPF.getNav_ContactInfoFirstNameInput().click();
			sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoFirstNameInput().getAttribute("data-errorqtip");
			sActFirstNameToolTipMsgFN=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
			FormPF.getNav_ContactInfoLastNameInput().click();
			sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoLastNameInput().getAttribute("data-errorqtip");
			sActFirstNameToolTipMsgLN=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
			FormPF.getNav_ContactInfoEmailInput().click();
			sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoEmailInput().getAttribute("data-errorqtip");
			sActFirstNameToolTipMsgEA=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
			FormPF.getNav_ContactInfoAreaCodePhoneNumberInput().click();
			sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoAreaCodePhoneNumberInput().getAttribute("data-errorqtip");
			sActFirstNameToolTipMsgPN=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
			sAllFldsToolTipMsg=sActFirstNameToolTipMsgFN+",  "+sActFirstNameToolTipMsgLN+",  "+sActFirstNameToolTipMsgEA+",  "+sActFirstNameToolTipMsgPN+" messages displayed for individual fields";
			if(sActFirstNameToolTipMsgFN.equalsIgnoreCase(sFrstNameReqMsg) && sActFirstNameToolTipMsgLN.equalsIgnoreCase(sLstNameReqMsg) && sActFirstNameToolTipMsgEA.equalsIgnoreCase(sEmailReqMsg) && sActFirstNameToolTipMsgPN.equalsIgnoreCase(sWrkPhneReqMsg))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Individual Object tool tip text", "Required Field Validation After tab out from each field", "done", "Validating Test Data Row "+row );
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Individual Object tool tip text", "Required Field Validation After tab out from each field", "pass", "Individual required tool tip validation message is matching with Actual. Actual required tool tip messages for all fields is : " +sAllFldsToolTipMsg);
				
				bFValTabOutSts=true;
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Individual Object tool tip text", "Required Field Validation After tab out from each field", "done", "Validating Test Data Row "+row );
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Individual Object tool tip text", "Required Field Validation After tab out from each field", "fail", "Individual required tool tip validation message is not matching with Actual. Actual required tool tip messages for all fields is : " +sAllFldsToolTipMsg);
				
			//	sAllFldsToolTipMsg=sActFirstNameToolTipMsgFN+",  "+sActFirstNameToolTipMsgLN+",  "+sActFirstNameToolTipMsgEA+",  "+sActFirstNameToolTipMsgPN+" messages displayed for individual fields";
				//FrameworkUtil.updateCustomResultBasedOnStatus(false, "Required field error tool tip message is not matching with actual error tool tip message for one/any of the field First Name, Last Name, Email Address and Work phone and messages are "+sAllFldsToolTipMsg);
				bFValTabOutSts=false;
			}
			
			////printResult(bSACValSts, bFValTabOutSts,xWrkBook,xSheet,row,iStsColVal,sActFeedBackMsg, sAllFldsToolTipMsg);
		}
		else
		{	
			for(int fc=0;fc<sFieldsNeedToValidateArray.length;fc++)
			{
				switch(sFieldsNeedToValidateArray[fc])
				{
					case "First Name":
						//Click in First Name field to set the focus and clear the field
						FormPF.getNav_ContactInfoFirstNameInput().click();
						FormPF.getNav_ContactInfoFirstNameInput().clear();
						//Click back on first name field to see the error tool tip message
						FormPF.getNav_ContactInfoFirstNameInput().click();
						//Get tool tip message
						sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoFirstNameInput().getAttribute("data-errorqtip");
						sActFirstNameToolTipMsg=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
						if(sActFirstNameToolTipMsg.equalsIgnoreCase(sFrstNameReqMsg))
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "First Name Edit field", "First Name Required Field Validation After tab out", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"First Name required error tool tip message "+ sFrstNameReqMsg+" is same as actual message after tab out with out entering value in First Name field. And Actual message is  "+sActFeedBackMsg);
							bFValTabOutSts=true;
						}
						else
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "First Name Edit field", "First Name Required Field Validation After tab out", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"First Name required error tool tip message "+ sFrstNameReqMsg+" is not same as actual message after tab out with out entering value in First Name field. And Actual message is  "+sActFeedBackMsg);
							bFValTabOutSts=false;
						}
							//Fill all field values
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoLastNameInput(), sExcelLstNameVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoEmailInput(), sExcelEmailVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoAreaCodePhoneNumberInput(), sExcelWrkPhoneVal);
						//Click on Save and Continue button
						WebObjectUtil.clickElement(FormPF.getNav_ContactInfoSaveAndCOntinueButton());
						WebObjectUtil.explicitWait(10);
						//Verify the feed back message after clicking Save and continue button
						sActFeedBackMsg=FormPF.getNav_FormFeedBackArea().getText();
						if(sActFeedBackMsg.equalsIgnoreCase(sSveAndCntBtnFDBKMsg))
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area", "First Name Required Field Validation After Save", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Feed back area text message "+sSveAndCntBtnFDBKMsg+" is same as actual message after clicking Save button with out entering value in First Name field. And Actual message is  "+sActFeedBackMsg);
							bSACValSts=true;
						}else
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area", "First Name Required Field Validation After Save", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Feed back area text message "+sSveAndCntBtnFDBKMsg+" is not same as actual message after clicking Save button with out entering value in First Name field. And Actual message is  "+sActFeedBackMsg);
							bSACValSts=false;
						}
						//printResult(bSACValSts, bFValTabOutSts,xWrkBook,xSheet,row,iStsColVal,sActFeedBackMsg, sAllFldsToolTipMsg);
						break;
					case "Last Name":
						
						//Click in First Name field to set the focus and clear the field
						FormPF.getNav_ContactInfoLastNameInput().click();
						FormPF.getNav_ContactInfoLastNameInput().clear();
						//Click back on first name field to see the error tool tip message
						FormPF.getNav_ContactInfoLastNameInput().click();
						//Get tool tip message
						sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoLastNameInput().getAttribute("data-errorqtip");
						sActFirstNameToolTipMsg=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
						if(sActFirstNameToolTipMsg.equalsIgnoreCase(sLstNameReqMsg))
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Last Name Edit field", "Last Name Required Field Validation After tab out", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Last Name required error tool tip message "+ sLstNameReqMsg+" is same as actual message after tab out with out entering value in Last Name field. And Actual message is  "+sActFeedBackMsg);
							bFValTabOutSts=true;
						}
						else
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Last Name Edit field", "Last Name Required Field Validation After tab out", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Last Name required error tool tip message "+ sLstNameReqMsg+" is not same as actual message after tab out with out entering value in Last Name field. And Actual message is  "+sActFeedBackMsg);
							bFValTabOutSts=false;
						}
						//Fill all field values
						
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoFirstNameInput(), sExcelFirstNameVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoEmailInput(), sExcelEmailVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoAreaCodePhoneNumberInput(), sExcelWrkPhoneVal);
						//Click on Save and Continue button
						WebObjectUtil.clickElement(FormPF.getNav_ContactInfoSaveAndCOntinueButton());
						WebObjectUtil.explicitWait(10);
						//Verify the feed back message after clicking Save and continue button
						sActFeedBackMsg=FormPF.getNav_FormFeedBackArea().getText();
						if(sActFeedBackMsg.equalsIgnoreCase(sSveAndCntBtnFDBKMsg))
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area", "Last Name Required Field Validation After Save", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Feed back area text message "+sSveAndCntBtnFDBKMsg+" is same as actual message after clicking Save button with out entering value in Last Name field. And Actual message is  "+sActFeedBackMsg);
							bSACValSts=true;
						}else
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area", "Last Name Required Field Validation After Save", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Feed back area text message "+sSveAndCntBtnFDBKMsg+" is not same as actual message after clicking Save button with out entering value in last Name field. And Actual message is  "+sActFeedBackMsg);
							bSACValSts=false;
						}
						//printResult(bSACValSts, bFValTabOutSts,xWrkBook,xSheet,row,iStsColVal,sActFeedBackMsg, sAllFldsToolTipMsg);
						break;
					case "Email Address":
							
						//Click in First Name field to set the focus and clear the field
						FormPF.getNav_ContactInfoEmailInput().click();
						FormPF.getNav_ContactInfoEmailInput().clear();
						//Click back on first name field to see the error tool tip message
						FormPF.getNav_ContactInfoEmailInput().click();
						//Get tool tip message
						sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoEmailInput().getAttribute("data-errorqtip");
						sActFirstNameToolTipMsg=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
						if(sActFirstNameToolTipMsg.equalsIgnoreCase(sEmailReqMsg))
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Email Address Edit field", "Email Address Required Field Validation After tab out", "done", "Validating Test Data Row "+row );FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Email Address Edit field", "Email Address Required Field Validation After tab out", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Email Address required error tool tip message "+ sEmailReqMsg+" is same as actual message after tab out with out entering value in Email Address field. And Actual message is  "+sActFeedBackMsg);
							bFValTabOutSts=true;
						}
						else
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Email Address Edit field", "Email Address Required Field Validation After tab out", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Email Address required error tool tip message "+ sEmailReqMsg+" is not same as actual message after tab out with out entering value in Email Address field. And Actual message is  "+sActFeedBackMsg);
							bFValTabOutSts=false;
						}
						//Fill all field values
						
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoFirstNameInput(), sExcelFirstNameVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoLastNameInput(), sExcelLstNameVal);
						//WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoEmailInput(), sExcelEmailVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoAreaCodePhoneNumberInput(), sExcelWrkPhoneVal);
						//Click on Save and Continue button
						WebObjectUtil.clickElement(FormPF.getNav_ContactInfoSaveAndCOntinueButton());
						WebObjectUtil.explicitWait(10);
						//Verify the feed back message after clicking Save and continue button
						sActFeedBackMsg=FormPF.getNav_FormFeedBackArea().getText();
						if(sActFeedBackMsg.equalsIgnoreCase(sSveAndCntBtnFDBKMsg))
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area", "Email Address Required Field Validation After Save", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Feed back area text message "+sSveAndCntBtnFDBKMsg+" is same as actual message after clicking Save button with out entering value in Email Address field. And Actual message is  "+sActFeedBackMsg);
							bSACValSts=true;
						}else
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area", "Email Address Required Field Validation After Save", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Feed back area text message "+sSveAndCntBtnFDBKMsg+" is not same as actual message after clicking Save button with out entering value in Email Address field. And Actual message is  "+sActFeedBackMsg);
							bSACValSts=false;
						}
						//printResult(bSACValSts, bFValTabOutSts,xWrkBook,xSheet,row,iStsColVal,sActFeedBackMsg, sAllFldsToolTipMsg);
						break;
					case "Work Phone":
							
						//Click in First Name field to set the focus and clear the field
						FormPF.getNav_ContactInfoAreaCodePhoneNumberInput().click();
						FormPF.getNav_ContactInfoAreaCodePhoneNumberInput().clear();
						//Click back on first name field to see the error tool tip message
						FormPF.getNav_ContactInfoAreaCodePhoneNumberInput().click();
						//Get tool tip message
						sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoAreaCodePhoneNumberInput().getAttribute("data-errorqtip");
						sActFirstNameToolTipMsg=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
						if(sActFirstNameToolTipMsg.equalsIgnoreCase(sWrkPhneReqMsg))
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Work Phone Edit field", "Work Phone Required Field Validation After tab out", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Work Phone required error tool tip message "+ sWrkPhneReqMsg+" is same as actual message after tab out with out entering value in Work Phone field. And Actual message is  "+sActFeedBackMsg);
							bFValTabOutSts=true;
						}
						else
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Work Phone Edit field", "Work Phone Required Field Validation After tab out", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Work Phone required error tool tip message "+ sWrkPhneReqMsg+" is not same as actual message after tab out with out entering value in Work Phone field. And Actual message is  "+sActFeedBackMsg);
							bFValTabOutSts=false;
						}
						//Fill all field values
						
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoFirstNameInput(), sExcelFirstNameVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoLastNameInput(), sExcelLstNameVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoEmailInput(), sExcelEmailVal);
						//WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoAreaCodePhoneNumberInput(), sExcelWrkPhoneVal);
						//Click on Save and Continue button
						WebObjectUtil.clickElement(FormPF.getNav_ContactInfoSaveAndCOntinueButton());
						WebObjectUtil.explicitWait(10);
						//Verify the feed back message after clicking Save and continue button
						sActFeedBackMsg=FormPF.getNav_FormFeedBackArea().getText();
						if(sActFeedBackMsg.equalsIgnoreCase(sSveAndCntBtnFDBKMsg))
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area", "Work Phone Required Field Validation After Save", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Feed back area text message "+sSveAndCntBtnFDBKMsg+" is same as actual message after clicking Save button with out entering value in Work Phone field. And Actual message is  "+sActFeedBackMsg);
							bSACValSts=true;
						}else
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area", "Work Phone Required Field Validation After Save", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Feed back area text message "+sSveAndCntBtnFDBKMsg+" is not same as actual message after clicking Save button with out entering value in Work Phone field. And Actual message is  "+sActFeedBackMsg);
							bSACValSts=false;
						}
						//printResult(bSACValSts, bFValTabOutSts,xWrkBook,xSheet,row,iStsColVal,sActFeedBackMsg, sAllFldsToolTipMsg);	
						break;
				}
	
	
			}
		}
	}

	public static void validateInvlidDataFieldsAftrSaveAndContinueBtnClick(String sExcelFieldsToValidateVal,WebElement wFirstNameElemen,String sExcelFirstNameVal,WebElement wLastNameElement,String sExcelLstNameVal,WebElement wEmailNameElement,String sExcelEmailVal,WebElement wWrkPhoneElement,String sExcelWrkPhoneVal,WebElement wCellPhoneElement,String sExcelCellPhoneVal,XSSFWorkbook xWrkBook,XSSFSheet xSheet,int row,int iStsColVal)
	{

		String sActualErrorToolTipEntireText,sActFirstNameToolTipMsg,sActFeedBackMsg = null,sAllFldsToolTipMsg = null;
		String sSveBtnFDBKMsg,sSveAndCntBtnFDBKMsg;
		String sFrstNameInvldMsg,sLstNameInvldMsg,sEmailInvldMsg,sWrkPhneInvldMsg,sCelPhneInvldMsg;
		String[] sFieldsNeedToValidateArray;
		String sActFirstNameToolTipMsgFN,sActFirstNameToolTipMsgLN,sActFirstNameToolTipMsgEA,sActFirstNameToolTipMsgPN,sActFirstNameToolTipMsgCN;
		//Enter all field values except first name, click on Save and Continue and verify feed back message and First name tool tip message
		boolean bSACValSts	,bFValTabOutSts;		
		sSveAndCntBtnFDBKMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.REQUIRED.TESTDATA.SAVEANDCONTINUE.BUTTON.CLICK.FEEDBACK.MESSAGE");
		sSveBtnFDBKMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.REQUIRED.TESTDATA.SAVE.BUTTON.CLICK.FEEDBACK.MESSAGE");
		
		sFrstNameInvldMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.INVALID.TESTDATA.FIRSTNAME.TEXT.TABOUT.TOOLTIP.MESSAGE");
		sLstNameInvldMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.INVALID.TESTDATA.LASTNAME.TEXT.TABOUT.TOOLTIP.MESSAGE");
		sEmailInvldMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.INVALID.TESTDATA.EMAIL.TEXT.TABOUT.TOOLTIP.MESSAGE");
		sWrkPhneInvldMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.INVALID.TESTDATA.WORKPHONE.TEXT.TABOUT.TOOLTIP.MESSAGE");
		sCelPhneInvldMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.INVALID.TESTDATA.CELLPHONE.TEXT.TABOUT.TOOLTIP.MESSAGE");

		sFieldsNeedToValidateArray=sExcelFieldsToValidateVal.split(",");
		if(sFieldsNeedToValidateArray.length==6)
		{
			//Fill all field values
			WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoFirstNameInput(), sExcelFirstNameVal);
			WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoLastNameInput(), sExcelLstNameVal);
			WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoEmailInput(), sExcelEmailVal);
			WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoAreaCodePhoneNumberInput(), sExcelWrkPhoneVal);
			
			WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoCellPhoneAreaCodeNumberInput(), sExcelCellPhoneVal);
			//WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoAreaCodePhoneNumberInput(), sExcelWrkPhoneVal);
			
			//Click on Save and Continue button
			WebObjectUtil.clickElement(FormPF.getNav_ContactInfoSaveAndCOntinueButton());
			WebObjectUtil.explicitWait(10);
			//Verify the feed back message after clicking Save and continue button
			sActFeedBackMsg=FormPF.getNav_FormFeedBackArea().getText();
			if(sActFeedBackMsg.equalsIgnoreCase(sSveAndCntBtnFDBKMsg))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area object", "Invalid Data Field Validation After Save", "done", "Validating Test Data Row "+row );
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area object", "Invalid Data Field Validations After Save", "pass", "Expected is matching with Actual. Actual feedback messages is : " +sActFeedBackMsg);
				//FrameworkUtil.updateCustomResultBasedOnStatus(true, sSveAndCntBtnFDBKMsg+" is same as actual message after clicking Save and continue by leaving all fields  empty. And Actual message is  "+sActFeedBackMsg);
				//AddFirewallRuleTestCase.writeExcelData(xSheet,row,iStsColVal,"Executed and Observed that Passed");
				//AddFirewallRuleTestCase.fillExcelCellCOlor(xWrkBook,xSheet,row,iStsColVal,"GREEN");
				bSACValSts=true;
			}else{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area object", "Invalid Data Field Validation After Save", "done", "Validating Test Data Row "+row );
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area object", "Invalid Data Field Validations After Save", "fail", "Expected message :"+sSveAndCntBtnFDBKMsg+" is not matching with Actual. Actual feedback messages is : " +sActFeedBackMsg);
				//FrameworkUtil.updateCustomResultBasedOnStatus(false, sSveAndCntBtnFDBKMsg+" is not same as actual message after clicking Save and continue by leaving all fields  empty. And Actual message for referrence is    "+sActFeedBackMsg);
				//AddFirewallRuleTestCase.writeExcelData(xSheet,row,iStsColVal,"Executed and observed that Failed. For details verfiy Selenium HTML results");
				//AddFirewallRuleTestCase.fillExcelCellCOlor(xWrkBook,xSheet,row,iStsColVal,"RED");
				bSACValSts=false;
			}
			FormPF.getNav_ContactInfoFirstNameInput().click();
			sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoFirstNameInput().getAttribute("data-errorqtip");
			sActFirstNameToolTipMsgFN=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
			FormPF.getNav_ContactInfoLastNameInput().click();
			sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoLastNameInput().getAttribute("data-errorqtip");
			sActFirstNameToolTipMsgLN=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
			FormPF.getNav_ContactInfoEmailInput().click();
			sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoEmailInput().getAttribute("data-errorqtip");
			sActFirstNameToolTipMsgEA=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
			FormPF.getNav_ContactInfoAreaCodePhoneNumberInput().click();
			sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoAreaCodePhoneNumberInput().getAttribute("data-errorqtip");
			sActFirstNameToolTipMsgPN=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
			//Check following code.
			FormPF.getNav_ContactInfoAreaCodePhoneNumberInput().click();
			sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoCellPhoneAreaCodeNumberInput().getAttribute("data-errorqtip");
			sActFirstNameToolTipMsgCN=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
			sAllFldsToolTipMsg=sActFirstNameToolTipMsgFN+",  "+sActFirstNameToolTipMsgLN+",  "+sActFirstNameToolTipMsgEA+",  "+sActFirstNameToolTipMsgPN+",  "+sActFirstNameToolTipMsgCN+" messages displayed for individual fields";
			if(sActFirstNameToolTipMsgFN.equalsIgnoreCase(sFrstNameInvldMsg) && sActFirstNameToolTipMsgLN.equalsIgnoreCase(sLstNameInvldMsg) && sActFirstNameToolTipMsgEA.equalsIgnoreCase(sEmailInvldMsg) && sActFirstNameToolTipMsgPN.equalsIgnoreCase(sWrkPhneInvldMsg)&& sActFirstNameToolTipMsgCN.equalsIgnoreCase(sCelPhneInvldMsg))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Individual Object tool tip text", "Invalid Data Field Validation After tab out from each field", "done", "Validating Test Data Row "+row );
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Individual Object tool tip text", "Invalid Data Field Validation After tab out from each field", "pass", "Individual invalid data tool tip validation message is matching with Actual. Actual Invalid Data tool tip messages for all fields is : " +sAllFldsToolTipMsg);
				//FrameworkUtil.updateCustomResultBasedOnStatus(true,"Required field error tool tip message is matching with actual error tool tip message for First Name, Last Name, Email Address and Work phone fields" );
				
				bFValTabOutSts=true;
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Individual Object tool tip text", "Invalid Data Field Validation After tab out from each field", "done", "Validating Test Data Row "+row );
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Individual Object tool tip text", "Invalid Data Field Validation After tab out from each field", "fail", "Individual Invalid Data tool tip validation message is not matching with Actual. Actual Invalid Data tool tip messages for all fields is : " +sAllFldsToolTipMsg);
				
			//	sAllFldsToolTipMsg=sActFirstNameToolTipMsgFN+",  "+sActFirstNameToolTipMsgLN+",  "+sActFirstNameToolTipMsgEA+",  "+sActFirstNameToolTipMsgPN+" messages displayed for individual fields";
				//FrameworkUtil.updateCustomResultBasedOnStatus(false, "Required field error tool tip message is not matching with actual error tool tip message for one/any of the field First Name, Last Name, Email Address and Work phone and messages are "+sAllFldsToolTipMsg);
				bFValTabOutSts=false;
			}
			
			//printResult(bSACValSts, bFValTabOutSts,xWrkBook,xSheet,row,iStsColVal,sActFeedBackMsg, sAllFldsToolTipMsg);
		}
		else
		{	
			for(int fc=0;fc<sFieldsNeedToValidateArray.length;fc++)
			{
				switch(sFieldsNeedToValidateArray[fc])
				{
					case "First Name":
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoFirstNameInput(), sExcelFirstNameVal);
						//Click back on first name field to see the error tool tip message
						FormPF.getNav_ContactInfoFirstNameInput().click();
						//Get tool tip message
						sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoFirstNameInput().getAttribute("data-errorqtip");
						sActFirstNameToolTipMsg=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
						
						if(sActFirstNameToolTipMsg.equalsIgnoreCase(sFrstNameInvldMsg))
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "First Name Edit field", "First Name inalid data Field Validation After tab out", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"First Name invalid data error tool tip message "+ sFrstNameInvldMsg+" is same as actual message after tab out by entering invlaid value in First Name field. And Actual message is  "+sActFeedBackMsg);
							bFValTabOutSts=true;
						}
						else
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "First Name Edit field", "First Name Required Field Validation After tab out", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"First Name required error tool tip message "+ sFrstNameInvldMsg+" is not same as actual message after tab out by entering invlaid value in First Name field. And Actual message is  "+sActFeedBackMsg);
							bFValTabOutSts=false;
						}
						//Fill all field values
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoLastNameInput(), sExcelLstNameVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoEmailInput(), sExcelEmailVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoAreaCodePhoneNumberInput(), sExcelWrkPhoneVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoCellPhoneAreaCodeNumberInput(), sExcelCellPhoneVal);
						
						//						Click on Save and Continue button
						WebObjectUtil.clickElement(FormPF.getNav_ContactInfoSaveAndCOntinueButton());
						WebObjectUtil.explicitWait(10);
						//Verify the feed back message after clicking Save and continue button
						sActFeedBackMsg=FormPF.getNav_FormFeedBackArea().getText();
						if(sActFeedBackMsg.equalsIgnoreCase(sSveAndCntBtnFDBKMsg))
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area", "First Name Invalid data Field Validation After Save", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Feed back area text message "+sSveAndCntBtnFDBKMsg+" is same as actual message after clicking Save button by entering invlid value in First Name field. And Actual message is  "+sActFeedBackMsg);
							bSACValSts=true;
						}else
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area", "First Name Invalid data Field Validation After Save", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Feed back area text message "+sSveAndCntBtnFDBKMsg+" is not same as actual message after clicking Save button by entering invalid value in First Name field. And Actual message is  "+sActFeedBackMsg);
							bSACValSts=false;
						}
						//printResult(bSACValSts, bFValTabOutSts,xWrkBook,xSheet,row,iStsColVal,sActFeedBackMsg, sActFirstNameToolTipMsg);
						break;
					case "Last Name":
						
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoFirstNameInput(), sExcelFirstNameVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoLastNameInput(), sExcelLstNameVal);
						FormPF.getNav_ContactInfoLastNameInput().click();
						sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoLastNameInput().getAttribute("data-errorqtip");
						sActFirstNameToolTipMsg=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
						
						if(sActFirstNameToolTipMsg.equalsIgnoreCase(sLstNameInvldMsg))
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Last Name Edit field", "Last Name inalid data Field Validation After tab out", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Last Name invalid data error tool tip message "+ sLstNameInvldMsg+" is same as actual message after tab out by entering invlaid value in Last Name field. And Actual message is  "+sActFeedBackMsg);
							bFValTabOutSts=true;
						}
						else
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Last Name Edit field", "Last Name Required Field Validation After tab out", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Last Name required error tool tip message "+ sLstNameInvldMsg+" is not same as actual message after tab out by entering invlaid value in Last Name field. And Actual message is  "+sActFeedBackMsg);
							bFValTabOutSts=false;
						}
						//Fill all field values						
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoEmailInput(), sExcelEmailVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoAreaCodePhoneNumberInput(), sExcelWrkPhoneVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoCellPhoneAreaCodeNumberInput(), sExcelCellPhoneVal);
						//Click on Save and Continue button
						WebObjectUtil.clickElement(FormPF.getNav_ContactInfoSaveAndCOntinueButton());
						WebObjectUtil.explicitWait(10);
						//Verify the feed back message after clicking Save and continue button
						sActFeedBackMsg=FormPF.getNav_FormFeedBackArea().getText();
						if(sActFeedBackMsg.equalsIgnoreCase(sSveAndCntBtnFDBKMsg))
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area", "Last Name Invalid data Field Validation After Save", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Feed back area text message "+sSveAndCntBtnFDBKMsg+" is same as actual message after clicking Save button by entering invlid value in Last Name field. And Actual message is  "+sActFeedBackMsg);
							bSACValSts=true;
						}else
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area", "Last Name Invalid data Field Validation After Save", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Feed back area text message "+sSveAndCntBtnFDBKMsg+" is not same as actual message after clicking Save button by entering invalid value in Last Name field. And Actual message is  "+sActFeedBackMsg);
							bSACValSts=false;
						}
						//printResult(bSACValSts, bFValTabOutSts,xWrkBook,xSheet,row,iStsColVal,sActFeedBackMsg, sActFirstNameToolTipMsg);
						break;
					case "Email Address":
							
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoFirstNameInput(), sExcelFirstNameVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoFirstNameInput(), sExcelLstNameVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoEmailInput(), sExcelEmailVal);
						FormPF.getNav_ContactInfoEmailInput().click();
						//Get tool tip message
						sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoLastNameInput().getAttribute("data-errorqtip");
						sActFirstNameToolTipMsg=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
						if(sActFirstNameToolTipMsg.equalsIgnoreCase(sEmailInvldMsg))
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Email Address Edit field", "Email Address inalid data Field Validation After tab out", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Email Address invalid data error tool tip message "+ sEmailInvldMsg+" is same as actual message after tab out by entering invlaid value in Email Address field. And Actual message is  "+sActFeedBackMsg);
							bFValTabOutSts=true;
						}
						else
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Email Address Edit field", "Email Address Required Field Validation After tab out", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Email Address required error tool tip message "+ sEmailInvldMsg+" is not same as actual message after tab out by entering invlaid value in Email Address field. And Actual message is  "+sActFeedBackMsg);
							bFValTabOutSts=false;
						}
						//
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoAreaCodePhoneNumberInput(), sExcelWrkPhoneVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoCellPhoneAreaCodeNumberInput(), sExcelCellPhoneVal);
						//Click on Save and Continue button
						WebObjectUtil.clickElement(FormPF.getNav_ContactInfoSaveAndCOntinueButton());
						WebObjectUtil.explicitWait(10);
						//Verify the feed back message after clicking Save and continue button
						sActFeedBackMsg=FormPF.getNav_FormFeedBackArea().getText();
						if(sActFeedBackMsg.equalsIgnoreCase(sSveAndCntBtnFDBKMsg))
						
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area", "Email address Invalid data Field Validation After Save", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Feed back area text message "+sSveAndCntBtnFDBKMsg+" is same as actual message after clicking Save button by entering invlid value in Email Address field. And Actual message is  "+sActFeedBackMsg);
							bSACValSts=true;
						}else
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area", "Email Address Invalid data Field Validation After Save", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Feed back area text message "+sSveAndCntBtnFDBKMsg+" is not same as actual message after clicking Save button by entering invalid value in Email Address field. And Actual message is  "+sActFeedBackMsg);
							bSACValSts=false;
						}
						//printResult(bSACValSts, bFValTabOutSts,xWrkBook,xSheet,row,iStsColVal,sActFeedBackMsg, sActFirstNameToolTipMsg);
						break;
					case "Work Phone":
							
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoFirstNameInput(), sExcelFirstNameVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoFirstNameInput(), sExcelLstNameVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoEmailInput(), sExcelEmailVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoAreaCodePhoneNumberInput(), sExcelWrkPhoneVal);
						//Click back on first name field to see the error tool tip message
						FormPF.getNav_ContactInfoAreaCodePhoneNumberInput().click();
						//Get tool tip message
						sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoLastNameInput().getAttribute("data-errorqtip");
						sActFirstNameToolTipMsg=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
						
						if(sActFirstNameToolTipMsg.equalsIgnoreCase(sWrkPhneInvldMsg))
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Work phone Edit field", "Work phone inalid data Field Validation After tab out", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Work phone invalid data error tool tip message "+ sWrkPhneInvldMsg+" is same as actual message after tab out by entering invlaid value in Work phone field. And Actual message is  "+sActFeedBackMsg);
							bFValTabOutSts=true;
						}
						else
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Work phone Edit field", "Work phone Required Field Validation After tab out", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Work phone required error tool tip message "+ sWrkPhneInvldMsg+" is not same as actual message after tab out by entering invlaid value in Work phone field. And Actual message is  "+sActFeedBackMsg);
							bFValTabOutSts=false;
						}
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoCellPhoneAreaCodeNumberInput(), sExcelCellPhoneVal);
						//Click on Save and Continue button
						WebObjectUtil.clickElement(FormPF.getNav_ContactInfoSaveAndCOntinueButton());
						WebObjectUtil.explicitWait(10);
						//Verify the feed back message after clicking Save and continue button
						sActFeedBackMsg=FormPF.getNav_FormFeedBackArea().getText();
						if(sActFeedBackMsg.equalsIgnoreCase(sSveAndCntBtnFDBKMsg))
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area", "Work Phone Invalid data Field Validation After Save", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Feed back area text message "+sSveAndCntBtnFDBKMsg+" is same as actual message after clicking Save button by entering invlid value in Work Phone field. And Actual message is  "+sActFeedBackMsg);
							bSACValSts=true;
						}else
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area", "Work Phone Invalid data Field Validation After Save", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Feed back area text message "+sSveAndCntBtnFDBKMsg+" is not same as actual message after clicking Save button by entering invalid value in Work Phone field. And Actual message is  "+sActFeedBackMsg);
							bSACValSts=false;
						}
						//printResult(bSACValSts, bFValTabOutSts,xWrkBook,xSheet,row,iStsColVal,sActFeedBackMsg, sActFirstNameToolTipMsg);	
						break;
					case "Cell Phone":
						
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoFirstNameInput(), sExcelFirstNameVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoFirstNameInput(), sExcelLstNameVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoEmailInput(), sExcelEmailVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoAreaCodePhoneNumberInput(), sExcelWrkPhoneVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoCellPhoneAreaCodeNumberInput(), sExcelCellPhoneVal);
						//Click back on first name field to see the error tool tip message
						FormPF.getNav_ContactInfoCellPhoneAreaCodeNumberInput().click();
						//Get tool tip message
						sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoLastNameInput().getAttribute("data-errorqtip");
						sActFirstNameToolTipMsg=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
						if(sActFirstNameToolTipMsg.equalsIgnoreCase(sCelPhneInvldMsg))
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Cell phone Edit field", "Cell phone inalid data Field Validation After tab out", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Work phone invalid data error tool tip message "+ sCelPhneInvldMsg+" is same as actual message after tab out by entering invlaid value in Cell phone field. And Actual message is  "+sActFeedBackMsg);
							bFValTabOutSts=true;
						}
						else
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Cell phone Edit field", "Cell phone Required Field Validation After tab out", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Work phone required error tool tip message "+ sCelPhneInvldMsg+" is not same as actual message after tab out by entering invlaid value in Cell phone field. And Actual message is  "+sActFeedBackMsg);
							bFValTabOutSts=false;
						}
						//Click on Save and Continue button
						WebObjectUtil.clickElement(FormPF.getNav_ContactInfoSaveAndCOntinueButton());
						WebObjectUtil.explicitWait(10);
						//Verify the feed back message after clicking Save and continue button
						sActFeedBackMsg=FormPF.getNav_FormFeedBackArea().getText();
						if(sActFeedBackMsg.equalsIgnoreCase(sSveAndCntBtnFDBKMsg))
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area", "Cell Phone Invalid data Field Validation After Save", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Feed back area text message "+sSveAndCntBtnFDBKMsg+" is same as actual message after clicking Save button by entering invlid value in Cell Phone field. And Actual message is  "+sActFeedBackMsg);
							bSACValSts=true;
						}else
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area", "Cell Phone Invalid data Field Validation After Save", "done", "Validating Test Data Row "+row );
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Feed back area text message "+sSveAndCntBtnFDBKMsg+" is not same as actual message after clicking Save button by entering invalid value in Cell Phone field. And Actual message is  "+sActFeedBackMsg);
							bSACValSts=false;
						}
						//printResult(bSACValSts, bFValTabOutSts,xWrkBook,xSheet,row,iStsColVal,sActFeedBackMsg, sActFirstNameToolTipMsg);	
						break;
				}
			}
		}
			
	}
	
	public static void validateLengthOfFieldsAftrSaveAndContinueBtnClick(String sExcelFieldsToValidateVal,String sExcelFirstNameVal,String sExcelLstNameVal,String sExcelEmailVal,String sExcelWrkPhoneVal,String sExcelExtnVal,String sExcelCellPhoneVal,XSSFWorkbook xWrkBook,XSSFSheet xSheet,int row,int iStsColVal)
		{

			String sActualErrorToolTipEntireText,sActFirstNameToolTipMsg,sActFeedBackMsg = null,sAllFldsToolTipMsg;
			String sSveBtnFDBKMsg,sSveAndCntBtnFDBKMsg;
			String sFrstNameMaxLengthMsg,sLstNameMaxLengthMsg,sEmailMaxLengthMsg,sWrkPhneMaxLengthMsg,sWrkPhneExtnLengthMsg,sCelPhneMaxLengthMsg,sActFirstNameToolTipMsgPNExt,sActFirstNameToolTipMsgCELNUM;
			String[] sFieldsNeedToValidateArray;
			String sActFirstNameToolTipMsgFN,sActFirstNameToolTipMsgLN,sActFirstNameToolTipMsgEA,sActFirstNameToolTipMsgPN;
			boolean bSACValSts,bFValTabOutSts;
			sSveAndCntBtnFDBKMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.REQUIRED.TESTDATA.SAVEANDCONTINUE.BUTTON.CLICK.FEEDBACK.MESSAGE");
			sSveBtnFDBKMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.REQUIRED.TESTDATA.SAVE.BUTTON.CLICK.FEEDBACK.MESSAGE");
			
			sFrstNameMaxLengthMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.MAX.LENGTH.TESTDATA.FIRSTNAME.TEXT.TABOUT.TOOLTIP.MESSAGE");
			sLstNameMaxLengthMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.MAX.LENGTH.TESTDATA.LASTNAME.TEXT.TABOUT.TOOLTIP.MESSAGE");
			sEmailMaxLengthMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.MAX.LENGTH.TESTDATA.EMAIL.TEXT.TABOUT.TOOLTIP.MESSAGE");
			sWrkPhneMaxLengthMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.MAX.LENGTH.TESTDATA.WORKPHONE.TEXT.TABOUT.TOOLTIP.MESSAGE");
			sWrkPhneExtnLengthMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.MAX.LENGTH.TESTDATA.WORKPHONE.EXTN.TEXT.TABOUT.TOOLTIP.MESSAGE");
			sCelPhneMaxLengthMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.MAX.LENGTH.TESTDATA.CELLPHONE.TEXT.TABOUT.TOOLTIP.MESSAGE");

			sFieldsNeedToValidateArray=sExcelFieldsToValidateVal.split(",");
			if(sFieldsNeedToValidateArray.length==6)
			{
				//Fill all field values
				WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoFirstNameInput(), sExcelFirstNameVal);
				WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoLastNameInput(), sExcelLstNameVal);
				WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoEmailInput(), sExcelEmailVal);
				WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoAreaCodePhoneNumberInput(), sExcelWrkPhoneVal);
				WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoPhoneExtInput(), sExcelExtnVal);
				WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoCellPhoneAreaCodeNumberInput(), sExcelCellPhoneVal);

				//Click on Save and Continue button
				WebObjectUtil.clickElement(FormPF.getNav_ContactInfoSaveAndCOntinueButton());
				WebObjectUtil.explicitWait(10);
				//Verify the feed back message after clicking Save and continue button
				sActFeedBackMsg=FormPF.getNav_FormFeedBackArea().getText();
				if(sActFeedBackMsg.equalsIgnoreCase(sSveAndCntBtnFDBKMsg))
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area object", "Max length Field Validation After Save", "done", "Validating Test Data Row "+row );
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area object", "Max length Field Validations After Save", "pass", "Expected is matching with Actual. Actual feedback messages is : " +sActFeedBackMsg);
					//AddFirewallRuleTestCase.writeExcelData(xSheet,row,iStsColVal,"Executed and Observed that Passed");
					//AddFirewallRuleTestCase.fillExcelCellCOlor(xWrkBook,xSheet,row,iStsColVal,"GREEN");
					bSACValSts=true;
				}else{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area object", "Max length Field Validation After Save", "done", "Validating Test Data Row "+row );
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area object", "Max length Field Validations After Save", "fail", "Expected message :"+sSveAndCntBtnFDBKMsg+" is not matching with Actual. Actual feedback messages is : " +sActFeedBackMsg);
					//AddFirewallRuleTestCase.writeExcelData(xSheet,row,iStsColVal,"Executed and observed that Failed. For details verfiy Selenium HTML results");
					//AddFirewallRuleTestCase.fillExcelCellCOlor(xWrkBook,xSheet,row,iStsColVal,"RED");
					bSACValSts=false;
				}
				FormPF.getNav_ContactInfoFirstNameInput().click();
				sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoFirstNameInput().getAttribute("data-errorqtip");
				sActFirstNameToolTipMsgFN=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
				FormPF.getNav_ContactInfoLastNameInput().click();
				sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoLastNameInput().getAttribute("data-errorqtip");
				sActFirstNameToolTipMsgLN=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
				FormPF.getNav_ContactInfoEmailInput().click();
				sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoEmailInput().getAttribute("data-errorqtip");
				sActFirstNameToolTipMsgEA=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
				FormPF.getNav_ContactInfoAreaCodePhoneNumberInput().click();
				sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoAreaCodePhoneNumberInput().getAttribute("data-errorqtip");
				sActFirstNameToolTipMsgPN=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
				
				FormPF.getNav_ContactInfoPhoneExtInput().click();
				sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoPhoneExtInput().getAttribute("data-errorqtip");
				sActFirstNameToolTipMsgPNExt=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
				
				FormPF.getNav_ContactInfoCellPhoneAreaCodeNumberInput().click();
				sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoAreaCodePhoneNumberInput().getAttribute("data-errorqtip");
				sActFirstNameToolTipMsgCELNUM=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");

				FormPF.getNav_ContactInfoAreaCodePhoneNumberInput().click();
				sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoAreaCodePhoneNumberInput().getAttribute("data-errorqtip");
				sActFirstNameToolTipMsgPN=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
				sAllFldsToolTipMsg=sActFirstNameToolTipMsgFN+",  "+sActFirstNameToolTipMsgLN+",  "+sActFirstNameToolTipMsgEA+",  "+sActFirstNameToolTipMsgPN+" messages displayed for individual fields";
				if(sActFirstNameToolTipMsgFN.equalsIgnoreCase(sFrstNameMaxLengthMsg) && sActFirstNameToolTipMsgLN.equalsIgnoreCase(sLstNameMaxLengthMsg) && sActFirstNameToolTipMsgEA.equalsIgnoreCase(sEmailMaxLengthMsg) && sActFirstNameToolTipMsgPN.equalsIgnoreCase(sWrkPhneMaxLengthMsg) && sActFirstNameToolTipMsgPNExt.equalsIgnoreCase(sWrkPhneExtnLengthMsg)&& sActFirstNameToolTipMsgCELNUM.equalsIgnoreCase(sCelPhneMaxLengthMsg))
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Individual Object tool tip text", "Max length Field Validation After tab out from each field", "done", "Validating Test Data Row "+row );
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Individual Object tool tip text", "Max length Field Validation After tab out from each field", "pass", "Individual max length tool tip validation message is matching with Actual. Actual Max length tool tip messages for all fields is : " +sAllFldsToolTipMsg);
					
					bFValTabOutSts=true;
				}
				else
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Individual Object tool tip text", "Max length Field Validation After tab out from each field", "done", "Validating Test Data Row "+row );
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Individual Object tool tip text", "Max length Field Validation After tab out from each field", "fail", "Individual max length tool tip validation message is not matching with Actual. Actual Max length tool tip messages for all fields is : " +sAllFldsToolTipMsg);
					
				//	sAllFldsToolTipMsg=sActFirstNameToolTipMsgFN+",  "+sActFirstNameToolTipMsgLN+",  "+sActFirstNameToolTipMsgEA+",  "+sActFirstNameToolTipMsgPN+" messages displayed for individual fields";
					//FrameworkUtil.updateCustomResultBasedOnStatus(false, "Required field error tool tip message is not matching with actual error tool tip message for one/any of the field First Name, Last Name, Email Address and Work phone and messages are "+sAllFldsToolTipMsg);
					bFValTabOutSts=false;
				}
				//printResult(bSACValSts, bFValTabOutSts,xWrkBook,xSheet,row,iStsColVal,sActFeedBackMsg, sAllFldsToolTipMsg);
			}
			else

			{	
				for(int fc=0;fc<sFieldsNeedToValidateArray.length;fc++)
				{
					switch(sFieldsNeedToValidateArray[fc])
					{
						case "First Name":
							WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoFirstNameInput(), sExcelFirstNameVal);
							//Click back on first name field to see the error tool tip message
							FormPF.getNav_ContactInfoFirstNameInput().click();
							//Get tool tip message
							sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoFirstNameInput().getAttribute("data-errorqtip");
							sActFirstNameToolTipMsg=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
							if(sActFirstNameToolTipMsg.equalsIgnoreCase(sFrstNameMaxLengthMsg))
							{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "First Name Edit field", "First Name max length Field Validation After tab out", "done", "Validating Test Data Row "+row );
								FrameworkUtil.updateCustomResultBasedOnStatus(true,"First Name max length error tool tip message "+ sFrstNameMaxLengthMsg+" is same as actual message after tab out by entering more than max length value in First Name field. And Actual message is  "+sActFeedBackMsg);
								//FrameworkUtil.updateCustomResultBasedOnStatus(true, sFrstNameReqMsg+" is same as actual message after tab out with out entering value in field. And Actual message is  "+sActFeedBackMsg);
								bFValTabOutSts=true;
							}
							else
							{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "First Name Edit field", "First Name max length Field Validation After tab out", "done", "Validating Test Data Row "+row );
								FrameworkUtil.updateCustomResultBasedOnStatus(true,"First Name max length error tool tip message "+ sFrstNameMaxLengthMsg+" is not same as actual message after tab out by entering more than max length value in First Name field. And Actual message is  "+sActFeedBackMsg);
								//FrameworkUtil.updateCustomResultBasedOnStatus(false, sFrstNameReqMsg+" is not same as actual message after tab out with out entering value in field. And Actual message for referrence is  "+sActFeedBackMsg);
								bFValTabOutSts=false;
							}
							//Fill all field values
							WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoLastNameInput(), sExcelLstNameVal);
							WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoEmailInput(), sExcelEmailVal);
							WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoAreaCodePhoneNumberInput(), sExcelWrkPhoneVal);
							WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoCellPhoneAreaCodeNumberInput(), sExcelCellPhoneVal);
							//Click on Save and Continue button
							WebObjectUtil.clickElement(FormPF.getNav_ContactInfoSaveAndCOntinueButton());
							WebObjectUtil.explicitWait(10);
							//Verify the feed back message after clicking Save and continue button
							sActFeedBackMsg=FormPF.getNav_FormFeedBackArea().getText();
							if(sActFeedBackMsg.equalsIgnoreCase(sSveAndCntBtnFDBKMsg))
							{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area", "First Name max length Field Validation After Save", "done", "Validating Test Data Row "+row );
								FrameworkUtil.updateCustomResultBasedOnStatus(true,"Feed back area text message "+sSveAndCntBtnFDBKMsg+" is same as actual message after clicking Save button by entering more than max length text value in First Name field. And Actual message is  "+sActFeedBackMsg);
								bSACValSts=true;
							}else
							{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area", "First Name max length Field Validation After Save", "done", "Validating Test Data Row "+row );
								FrameworkUtil.updateCustomResultBasedOnStatus(true,"Feed back area text message "+sSveAndCntBtnFDBKMsg+" is not same as actual message after clicking Save button by entering more than max length text value in First Name field. And Actual message is  "+sActFeedBackMsg);
								bSACValSts=false;
							}
							//printResult(bSACValSts, bFValTabOutSts,xWrkBook,xSheet,row,iStsColVal,sActFeedBackMsg, sActFirstNameToolTipMsg);
							break;
						case "Last Name":
							
							WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoFirstNameInput(), sExcelFirstNameVal);
							WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoFirstNameInput(), sExcelLstNameVal);
							FormPF.getNav_ContactInfoFirstNameInput().click();
							sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoLastNameInput().getAttribute("data-errorqtip");
							sActFirstNameToolTipMsg=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
							if(sActFirstNameToolTipMsg.equalsIgnoreCase(sLstNameMaxLengthMsg))
							{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Last Name Edit field", "Last Name max length Field Validation After tab out", "done", "Validating Test Data Row "+row );
								FrameworkUtil.updateCustomResultBasedOnStatus(true,"Last Name max length error tool tip message "+ sLstNameMaxLengthMsg+" is same as actual message after tab out by entering more than max length value in Last Name field. And Actual message is  "+sActFeedBackMsg);
								//FrameworkUtil.updateCustomResultBasedOnStatus(true, sFrstNameReqMsg+" is same as actual message after tab out with out entering value in field. And Actual message is  "+sActFeedBackMsg);
								bFValTabOutSts=true;
							}
							else
							{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Last Name Edit field", "Last Name max length Field Validation After tab out", "done", "Validating Test Data Row "+row );
								FrameworkUtil.updateCustomResultBasedOnStatus(false,"Last Name max length error tool tip message "+ sLstNameMaxLengthMsg+" is not same as actual message after tab out by entering more than max length value in Last Name field. And Actual message is  "+sActFeedBackMsg);
								//FrameworkUtil.updateCustomResultBasedOnStatus(false, sFrstNameReqMsg+" is not same as actual message after tab out with out entering value in field. And Actual message for referrence is  "+sActFeedBackMsg);
								bFValTabOutSts=false;
							}
							//Fill all field values						
							WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoEmailInput(), sExcelEmailVal);
							WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoAreaCodePhoneNumberInput(), sExcelWrkPhoneVal);
							WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoCellPhoneAreaCodeNumberInput(), sExcelCellPhoneVal);
							//Click on Save and Continue button
							WebObjectUtil.clickElement(FormPF.getNav_ContactInfoSaveAndCOntinueButton());
							WebObjectUtil.explicitWait(10);
							//Verify the feed back message after clicking Save and continue button
							sActFeedBackMsg=FormPF.getNav_FormFeedBackArea().getText();
							if(sActFeedBackMsg.equalsIgnoreCase(sSveAndCntBtnFDBKMsg))
							{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area", "Last Name max length Field Validation After Save", "done", "Validating Test Data Row "+row );
								FrameworkUtil.updateCustomResultBasedOnStatus(true,"Feed back area text message "+sSveAndCntBtnFDBKMsg+" is same as actual message after clicking Save button by entering more than max length text value in Last Name field. And Actual message is  "+sActFeedBackMsg);
								bSACValSts=true;
							}else
							{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area", "Last Name max length Field Validation After Save", "done", "Validating Test Data Row "+row );
								FrameworkUtil.updateCustomResultBasedOnStatus(true,"Feed back area text message "+sSveAndCntBtnFDBKMsg+" is not same as actual message after clicking Save button by entering more than max length text value in Last Name field. And Actual message is  "+sActFeedBackMsg);
								bSACValSts=false;
							}
							//printResult(bSACValSts, bFValTabOutSts,xWrkBook,xSheet,row,iStsColVal,sActFeedBackMsg, sActFirstNameToolTipMsg);
							break;
						case "Email Address":
								
							WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoFirstNameInput(), sExcelFirstNameVal);
							WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoFirstNameInput(), sExcelLstNameVal);
							WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoEmailInput(), sExcelEmailVal);
							FormPF.getNav_ContactInfoEmailInput().click();
							//Get tool tip message
							sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoLastNameInput().getAttribute("data-errorqtip");
							sActFirstNameToolTipMsg=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
							
							if(sActFirstNameToolTipMsg.equalsIgnoreCase(sEmailMaxLengthMsg))
							{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Email Address Edit field", "Last Name max length Field Validation After tab out", "done", "Validating Test Data Row "+row );
								FrameworkUtil.updateCustomResultBasedOnStatus(true,"Email Address max length error tool tip message "+ sEmailMaxLengthMsg+" is same as actual message after tab out by entering more than max length value in Last Name field. And Actual message is  "+sActFeedBackMsg);
								//FrameworkUtil.updateCustomResultBasedOnStatus(true, sFrstNameReqMsg+" is same as actual message after tab out with out entering value in field. And Actual message is  "+sActFeedBackMsg);
								bFValTabOutSts=true;
							}
							else
							{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Email Address Edit field", "Email Address max length Field Validation After tab out", "done", "Validating Test Data Row "+row );
								FrameworkUtil.updateCustomResultBasedOnStatus(false,"Email Address max length error tool tip message "+ sEmailMaxLengthMsg+" is not same as actual message after tab out by entering more than max length value in Email Address field. And Actual message is  "+sActFeedBackMsg);
								//FrameworkUtil.updateCustomResultBasedOnStatus(false, sFrstNameReqMsg+" is not same as actual message after tab out with out entering value in field. And Actual message for referrence is  "+sActFeedBackMsg);
								bFValTabOutSts=false;
							}
							WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoAreaCodePhoneNumberInput(), sExcelWrkPhoneVal);
							WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoCellPhoneAreaCodeNumberInput(), sExcelCellPhoneVal);
							//Click on Save and Continue button
							WebObjectUtil.clickElement(FormPF.getNav_ContactInfoSaveAndCOntinueButton());
							WebObjectUtil.explicitWait(10);
							//Verify the feed back message after clicking Save and continue button
							sActFeedBackMsg=FormPF.getNav_FormFeedBackArea().getText();
							if(sActFeedBackMsg.equalsIgnoreCase(sSveAndCntBtnFDBKMsg))
							{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area", "Email Address max length Field Validation After Save", "done", "Validating Test Data Row "+row );
								FrameworkUtil.updateCustomResultBasedOnStatus(true,"Feed back area text message "+sSveAndCntBtnFDBKMsg+" is same as actual message after clicking Save button by entering more than max length text value in Email Address field. And Actual message is  "+sActFeedBackMsg);
								bSACValSts=true;
							}else
							{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area", "Email Address max length Field Validation After Save", "done", "Validating Test Data Row "+row );
								FrameworkUtil.updateCustomResultBasedOnStatus(true,"Feed back area text message "+sSveAndCntBtnFDBKMsg+" is not same as actual message after clicking Save button by entering more than max length text value in Email Address field. And Actual message is  "+sActFeedBackMsg);
								bSACValSts=false;
							}
							//printResult(bSACValSts, bFValTabOutSts,xWrkBook,xSheet,row,iStsColVal,sActFeedBackMsg, sActFirstNameToolTipMsg);
						case "Work Phone":
								
							WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoFirstNameInput(), sExcelFirstNameVal);
							WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoFirstNameInput(), sExcelLstNameVal);
							WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoEmailInput(), sExcelEmailVal);
							WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoAreaCodePhoneNumberInput(), sExcelWrkPhoneVal);
							//Click back on first name field to see the error tool tip message
							FormPF.getNav_ContactInfoAreaCodePhoneNumberInput().click();
							//Get tool tip message
							sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoLastNameInput().getAttribute("data-errorqtip");
							sActFirstNameToolTipMsg=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
							if(sActFirstNameToolTipMsg.equalsIgnoreCase(sWrkPhneMaxLengthMsg))
							{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Work Phone Edit field", "Work Phone max length Field Validation After tab out", "done", "Validating Test Data Row "+row );
								FrameworkUtil.updateCustomResultBasedOnStatus(true,"Work Phone max length error tool tip message "+ sEmailMaxLengthMsg+" is same as actual message after tab out by entering more than max length value in Work Phone field. And Actual message is  "+sActFeedBackMsg);
								//FrameworkUtil.updateCustomResultBasedOnStatus(true, sFrstNameReqMsg+" is same as actual message after tab out with out entering value in field. And Actual message is  "+sActFeedBackMsg);
								bFValTabOutSts=true;
							}
							else
							{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Work Phone Edit field", "Work Phone max length Field Validation After tab out", "done", "Validating Test Data Row "+row );
								FrameworkUtil.updateCustomResultBasedOnStatus(false,"Work Phone max length error tool tip message "+ sEmailMaxLengthMsg+" is not same as actual message after tab out by entering more than max length value in Work Phone field. And Actual message is  "+sActFeedBackMsg);
								//FrameworkUtil.updateCustomResultBasedOnStatus(false, sFrstNameReqMsg+" is not same as actual message after tab out with out entering value in field. And Actual message for referrence is  "+sActFeedBackMsg);
								bFValTabOutSts=false;
							}
							WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoCellPhoneAreaCodeNumberInput(), sExcelCellPhoneVal);
							//Click on Save and Continue button
							WebObjectUtil.clickElement(FormPF.getNav_ContactInfoSaveAndCOntinueButton());
							WebObjectUtil.explicitWait(10);
							//Verify the feed back message after clicking Save and continue button
							sActFeedBackMsg=FormPF.getNav_FormFeedBackArea().getText();
							if(sActFeedBackMsg.equalsIgnoreCase(sSveAndCntBtnFDBKMsg))
							{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area", "Work Phone max length Field Validation After Save", "done", "Validating Test Data Row "+row );
								FrameworkUtil.updateCustomResultBasedOnStatus(true,"Feed back area text message "+sSveAndCntBtnFDBKMsg+" is same as actual message after clicking Save button by entering more than max length text value in Work Phone field. And Actual message is  "+sActFeedBackMsg);
								bSACValSts=true;
							}else
							{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area", "Work Phone max length Field Validation After Save", "done", "Validating Test Data Row "+row );
								FrameworkUtil.updateCustomResultBasedOnStatus(true,"Feed back area text message "+sSveAndCntBtnFDBKMsg+" is not same as actual message after clicking Save button by entering more than max length text value in Work Phone field. And Actual message is  "+sActFeedBackMsg);
								bSACValSts=false;
							}
							//printResult(bSACValSts, bFValTabOutSts,xWrkBook,xSheet,row,iStsColVal,sActFeedBackMsg, sActFirstNameToolTipMsg);
							break;
						case "Extn":
							
							WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoFirstNameInput(), sExcelFirstNameVal);
							WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoFirstNameInput(), sExcelLstNameVal);
							WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoEmailInput(), sExcelEmailVal);
							WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoAreaCodePhoneNumberInput(), sExcelWrkPhoneVal);
							WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoPhoneExtInput(), sExcelWrkPhoneVal);
							//Click back on first name field to see the error tool tip message
							FormPF.getNav_ContactInfoPhoneExtInput().click();
							//Get tool tip message
							sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoLastNameInput().getAttribute("data-errorqtip");
							sActFirstNameToolTipMsg=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
							if(sActFirstNameToolTipMsg.equalsIgnoreCase(sWrkPhneExtnLengthMsg))
							{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Extension Edit field", "Extension max length Field Validation After tab out", "done", "Validating Test Data Row "+row );
								FrameworkUtil.updateCustomResultBasedOnStatus(true,"Work Phone max length error tool tip message "+ sWrkPhneExtnLengthMsg+" is same as actual message after tab out by entering more than max length value in Extension field. And Actual message is  "+sActFeedBackMsg);
								//FrameworkUtil.updateCustomResultBasedOnStatus(true, sFrstNameReqMsg+" is same as actual message after tab out with out entering value in field. And Actual message is  "+sActFeedBackMsg);
								bFValTabOutSts=true;
							}
							else
							{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Extension Edit field", "Extension max length Field Validation After tab out", "done", "Validating Test Data Row "+row );
								FrameworkUtil.updateCustomResultBasedOnStatus(false,"Work Phone max length error tool tip message "+ sWrkPhneExtnLengthMsg+" is not same as actual message after tab out by entering more than max length value in Extension field. And Actual message is  "+sActFeedBackMsg);
								//FrameworkUtil.updateCustomResultBasedOnStatus(false, sFrstNameReqMsg+" is not same as actual message after tab out with out entering value in field. And Actual message for referrence is  "+sActFeedBackMsg);
								bFValTabOutSts=false;
							}
							WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoCellPhoneAreaCodeNumberInput(), sExcelCellPhoneVal);
							//Click on Save and Continue button
							WebObjectUtil.clickElement(FormPF.getNav_ContactInfoSaveAndCOntinueButton());
							WebObjectUtil.explicitWait(10);
							//Verify the feed back message after clicking Save and continue button
							sActFeedBackMsg=FormPF.getNav_FormFeedBackArea().getText();
							if(sActFeedBackMsg.equalsIgnoreCase(sSveAndCntBtnFDBKMsg))
							{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area", "Extension max length Field Validation After Save", "done", "Validating Test Data Row "+row );
								FrameworkUtil.updateCustomResultBasedOnStatus(true,"Feed back area text message "+sSveAndCntBtnFDBKMsg+" is same as actual message after clicking Save button by entering more than max length text value in Extension field. And Actual message is  "+sActFeedBackMsg);
								bSACValSts=true;
							}else
							{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area", "Extension Address max length Field Validation After Save", "done", "Validating Test Data Row "+row );
								FrameworkUtil.updateCustomResultBasedOnStatus(true,"Feed back area text message "+sSveAndCntBtnFDBKMsg+" is not same as actual message after clicking Save button by entering more than max length text value in Extension field. And Actual message is  "+sActFeedBackMsg);
								bSACValSts=false;
							}
							//printResult(bSACValSts, bFValTabOutSts,xWrkBook,xSheet,row,iStsColVal,sActFeedBackMsg, sActFirstNameToolTipMsg);
							break;
						case "Cell Phone":
							
							WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoFirstNameInput(), sExcelFirstNameVal);
							WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoFirstNameInput(), sExcelLstNameVal);
							WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoEmailInput(), sExcelEmailVal);
							WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoAreaCodePhoneNumberInput(), sExcelWrkPhoneVal);
							WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoCellPhoneAreaCodeNumberInput(), sExcelCellPhoneVal);
							//Click back on first name field to see the error tool tip message
							FormPF.getNav_ContactInfoCellPhoneAreaCodeNumberInput().click();
							//Get tool tip message
							sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoLastNameInput().getAttribute("data-errorqtip");
							sActFirstNameToolTipMsg=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
							if(sActFirstNameToolTipMsg.equalsIgnoreCase(sCelPhneMaxLengthMsg))
							{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Cell Phone Edit field", "Cell Phone max length Field Validation After tab out", "done", "Validating Test Data Row "+row );
								FrameworkUtil.updateCustomResultBasedOnStatus(true,"Cell Phone max length error tool tip message "+ sCelPhneMaxLengthMsg+" is same as actual message after tab out by entering more than max length value in cell Phone field. And Actual message is  "+sActFeedBackMsg);
								//FrameworkUtil.updateCustomResultBasedOnStatus(true, sFrstNameReqMsg+" is same as actual message after tab out with out entering value in field. And Actual message is  "+sActFeedBackMsg);
								bFValTabOutSts=true;
							}
							else
							{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Cell Phone Edit field", "Cell Phone max length Field Validation After tab out", "done", "Validating Test Data Row "+row );
								FrameworkUtil.updateCustomResultBasedOnStatus(false,"Cell Phone max length error tool tip message "+ sCelPhneMaxLengthMsg+" is not same as actual message after tab out by entering more than max length value in cell Phone field. And Actual message is  "+sActFeedBackMsg);
								//FrameworkUtil.updateCustomResultBasedOnStatus(false, sFrstNameReqMsg+" is not same as actual message after tab out with out entering value in field. And Actual message for referrence is  "+sActFeedBackMsg);
								bFValTabOutSts=false;
							}
							//Click on Save and Continue button
							WebObjectUtil.clickElement(FormPF.getNav_ContactInfoSaveAndCOntinueButton());
							WebObjectUtil.explicitWait(10);
							//Verify the feed back message after clicking Save and continue button
							sActFeedBackMsg=FormPF.getNav_FormFeedBackArea().getText();
							if(sActFeedBackMsg.equalsIgnoreCase(sSveAndCntBtnFDBKMsg))
							{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area", "Cell Phone max length Field Validation After Save", "done", "Validating Test Data Row "+row );
								FrameworkUtil.updateCustomResultBasedOnStatus(true,"Feed back area text message "+sSveAndCntBtnFDBKMsg+" is same as actual message after clicking Save button by entering more than max length text value in Cell Phone field. And Actual message is  "+sActFeedBackMsg);
								bSACValSts=true;
							}else
							{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Feed back area", "Cell Phone Address max length Field Validation After Save", "done", "Validating Test Data Row "+row );
								FrameworkUtil.updateCustomResultBasedOnStatus(true,"Feed back area text message "+sSveAndCntBtnFDBKMsg+" is not same as actual message after clicking Save button by entering more than max length text value in Cell Phone field. And Actual message is  "+sActFeedBackMsg);
								bSACValSts=false;
							}
							//printResult(bSACValSts, bFValTabOutSts,xWrkBook,xSheet,row,iStsColVal,sActFeedBackMsg, sActFirstNameToolTipMsg);
					}

				}
				}
	}
	
	
	public static void validateDefaultValueDisplayedinField(String sExcelFieldsToValidateVal,String sExcelFirstNameVal,String sExcelLstNameVal,String sExcelEmailVal,String sExcelWrkPhoneVal,String sExcelExtnVal,String sExcelWrkPhoneExtnVal,String sExcelCellPhoneCntryVal,String sExcelCellPhoneVal,String sExcelEscalationVal,String sExcelUserRoleVal,XSSFWorkbook xWrkBook,XSSFSheet xSheet,int row,int iStsColVal)
	{

		String sFrstNamDefVal,sLstNamDefVal,sEmailAddDefVal,sWrkPhoneCountryDropDownDefVal,sWrkPhoneDefVal,sWrkPhoneExtnDefVal,sCelPhoneCountryDropDownDefVal,sCelPhoneDefVal,sEscalationDropDownDefVal,sUserRoleDropDownDefVal;
		String sActFrstNamDefVal,sActLstNamDefVal,sActEmailAddDefVal,sActWrkPhoneCountryDropDownDefVal,sActWrkPhoneDefVal,sActWrkPhoneExtnDefVal,sActCelPhoneCountryDropDownDefVal,sActCelPhoneDefVal,sActEscalationDropDownDefVal,sActUserRoleDropDownDefVal;
		String[] sFieldsNeedToValidateArray;
		String sAllFldsDefaultVal;
		boolean bAllFldsDefValSts,bFldDefValSts;
		if(!WebObjectUtil.isElementPresent(FormPF.getNav_ContactInfoFirstNameInput()))	
			WebObjectUtil.clickElement(FormPF.getNav_ContactInfoAddContactLink());
		else
		{
			WebObjectUtil.clickElement(FormPF.getNav_ContactInfoResetButton());
			WebObjectUtil.verifyElementPresent(CommonPF.getNav_CommonPopUpOKButton());
			WebObjectUtil.clickElement(CommonPF.getNav_CommonPopUpOKButton());
		}		
		
//		sFrstNamDefVal=(String)FrameworkUtil.dictPropertyData.get("NAV.DEFAULT.TESTDATA.FIRSTNAME.TEXT");
//		sLstNamDefVal=(String)FrameworkUtil.dictPropertyData.get("NAV.DEFAULT.TESTDATA.LASTTNAME.TEXT");
//		sEmailAddDefVal=(String)FrameworkUtil.dictPropertyData.get("NAV.DEFAULT.TESTDATA.EMAILADDRESS.TEXT");
//		sWrkPhoneCountryDropDownDefVal=(String)FrameworkUtil.dictPropertyData.get("NAV.DEFAULT.TESTDATA.WORKPHONE.COUNTRY.TEXT");
//		sWrkPhoneDefVal=(String)FrameworkUtil.dictPropertyData.get("NAV.DEFAULT.TESTDATA.WORKPHONE.COUNTRY.TEXT");
//		sWrkPhoneExtnDefVal=(String)FrameworkUtil.dictPropertyData.get("NAV.DEFAULT.TESTDATA.WORKPHONE.COUNTRY.TEXT");
//		sCelPhoneCountryDropDownDefVal=(String)FrameworkUtil.dictPropertyData.get("NAV.DEFAULT.TESTDATA.CELLPHONE.COUNTRY.TEXT");
//		sCelPhoneDefVal=(String)FrameworkUtil.dictPropertyData.get("NAV.DEFAULT.TESTDATA.CELLPHONE.COUNTRY.TEXT");
//		sEscalationDropDownDefVal=(String)FrameworkUtil.dictPropertyData.get("NAV.DEFAULT.TESTDATA.ESCALATION.TEXT");
//		sUserRoleDropDownDefVal=(String)FrameworkUtil.dictPropertyData.get("NAV.DEFAULT.TESTDATA.USERROLE.TEXT");
		
		sFieldsNeedToValidateArray=sExcelFieldsToValidateVal.split(",");
		if(sFieldsNeedToValidateArray.length==10)
		{

			sActFrstNamDefVal=FormPF.getNav_ContactInfoFirstNameInput().getAttribute("value");
			sActLstNamDefVal=FormPF.getNav_ContactInfoLastNameInput().getAttribute("value");
			sActEmailAddDefVal=FormPF.getNav_ContactInfoEmailInput().getAttribute("value");
			sActWrkPhoneCountryDropDownDefVal=FormPF.getNav_ContactInfoWorkPhoneCountryInput().getAttribute("value");
			sActWrkPhoneDefVal=FormPF.getNav_ContactInfoAreaCodePhoneNumberInput().getAttribute("value");
			sActWrkPhoneExtnDefVal=FormPF.getNav_ContactInfoPhoneExtInput().getAttribute("value");
			sActCelPhoneCountryDropDownDefVal=FormPF.getNav_ContactInfoCellPhoneCountryInput().getAttribute("value");
			sActCelPhoneDefVal=FormPF.getNav_ContactInfoCellPhoneAreaCodeNumberInput().getAttribute("value");
			sActEscalationDropDownDefVal=FormPF.getNav_ContactInfoEscalationInput().getAttribute("value");
			sActUserRoleDropDownDefVal=	FormPF.getNav_ContactInfoUserRoleInput().getAttribute("value");	
			
			sAllFldsDefaultVal=sActFrstNamDefVal+",  "+sActLstNamDefVal+",  "+sActEmailAddDefVal+",  "+sActWrkPhoneCountryDropDownDefVal+",  "+sActWrkPhoneDefVal+",  "+sActWrkPhoneExtnDefVal+",  "+sActCelPhoneCountryDropDownDefVal+",  "+sActCelPhoneDefVal+",  "+sActEscalationDropDownDefVal+",  "+sActUserRoleDropDownDefVal+" messages displayed for individual fields";
			
			if(sActFrstNamDefVal.equalsIgnoreCase(sExcelFirstNameVal) &&
				sActLstNamDefVal.equalsIgnoreCase(sExcelLstNameVal) &&
				sActEmailAddDefVal.equalsIgnoreCase(sExcelEmailVal) &&
				sActWrkPhoneCountryDropDownDefVal.equalsIgnoreCase(sExcelCellPhoneCntryVal) &&
				sActWrkPhoneDefVal.equalsIgnoreCase(sExcelWrkPhoneVal) &&
				sActWrkPhoneExtnDefVal.equalsIgnoreCase(sExcelWrkPhoneExtnVal) &&
				sActCelPhoneCountryDropDownDefVal.equalsIgnoreCase(sExcelCellPhoneCntryVal) &&
				sActCelPhoneDefVal.equalsIgnoreCase(sExcelCellPhoneVal) &&
				sActEscalationDropDownDefVal.equalsIgnoreCase(sExcelEscalationVal) &&
				sActUserRoleDropDownDefVal.equalsIgnoreCase(sExcelUserRoleVal))
				{
					FrameworkUtil.updateCustomResultBasedOnStatus(true,"Default values displayed in fields matched with expected values. For referrence default values displayed in fields are "+  sAllFldsDefaultVal);
					//bAllFldsDefValSts=true;
				}
				else
				{
					
					FrameworkUtil.updateCustomResultBasedOnStatus(false,"Default values displayed in fields are not matched with expected values. For referrence default values displayed in fields are "+  sAllFldsDefaultVal);
					//bAllFldsDefValSts=false;
				}

		}
		else
		{	
			for(int fc=0;fc<sFieldsNeedToValidateArray.length;fc++)
			{
				switch(sFieldsNeedToValidateArray[fc])
				{
			
				  
					case "First Name":
						sActFrstNamDefVal=FormPF.getNav_ContactInfoFirstNameInput().getAttribute("value");
						if(sActFrstNamDefVal.equalsIgnoreCase(sExcelFirstNameVal))
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Default value "+sActFrstNamDefVal+" is displayed and is matching with expected");
						else
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Default value "+sActFrstNamDefVal+" is displayed and is not matching with expected");
						break;
					case "Last Name":
						sActLstNamDefVal=FormPF.getNav_ContactInfoLastNameInput().getAttribute("value");
						if(sActLstNamDefVal.equalsIgnoreCase(sExcelLstNameVal))
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Default value "+sActLstNamDefVal+" is displayed and is matching with expected");
						else
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Default value "+sActLstNamDefVal+" is displayed and is not matching with expected");
						break;
					case "Email Address":
						sActEmailAddDefVal=FormPF.getNav_ContactInfoEmailInput().getAttribute("value");
						if(sActEmailAddDefVal.equalsIgnoreCase(sExcelEmailVal))
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Default value "+sActEmailAddDefVal+" is displayed and is matching with expected");
						else
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Default value "+sActEmailAddDefVal+" is displayed and is not matching with expected");
						break;
						
					case "Work Phone Country":
						sActWrkPhoneCountryDropDownDefVal=FormPF.getNav_ContactInfoWorkPhoneCountryInput().getAttribute("value");
						if(sActWrkPhoneCountryDropDownDefVal.equalsIgnoreCase(sExcelCellPhoneCntryVal))
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Default value "+sActWrkPhoneCountryDropDownDefVal+" is displayed and is matching with expected");
						else
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Default value "+sActWrkPhoneCountryDropDownDefVal+" is displayed and is not matching with expected");
						break;
					case "Work Phone":
						sActWrkPhoneDefVal=FormPF.getNav_ContactInfoAreaCodePhoneNumberInput().getAttribute("value");
						if(sActWrkPhoneDefVal.equalsIgnoreCase(sExcelWrkPhoneVal))
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Default value "+sActWrkPhoneDefVal+" is displayed and is matching with expected");
						else
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Default value "+sActWrkPhoneDefVal+" is displayed and is not matching with expected");
						break;
					
						 
					case "Extn":
						sActWrkPhoneExtnDefVal=FormPF.getNav_ContactInfoPhoneExtInput().getAttribute("value");
						if(sActWrkPhoneExtnDefVal.equalsIgnoreCase(sExcelExtnVal))
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Default value "+sActWrkPhoneExtnDefVal+" is displayed and is matching with expected");
						else
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Default value "+sActWrkPhoneExtnDefVal+" is displayed and is not matching with expected");
						break;	
					case "Cell Phone Country":
						sActCelPhoneCountryDropDownDefVal=FormPF.getNav_ContactInfoCellPhoneCountryInput().getAttribute("value");
						if(sActCelPhoneCountryDropDownDefVal.equalsIgnoreCase(sExcelCellPhoneCntryVal))
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Default value "+sActCelPhoneCountryDropDownDefVal+" is displayed and is matching with expected");
						else
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Default value "+sActCelPhoneCountryDropDownDefVal+" is displayed and is not matching with expected");
						break;	
						
					case "Cell Phone":
						sActCelPhoneDefVal=FormPF.getNav_ContactInfoCellPhoneCountryInput().getAttribute("value");
						if(sActCelPhoneDefVal.equalsIgnoreCase(sExcelCellPhoneVal))
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Default value "+sActCelPhoneDefVal+" is displayed and is matching with expected");
						else
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Default value "+sActCelPhoneDefVal+" is displayed and is not matching with expected");
						break;
					case "Escalation":
						sActEscalationDropDownDefVal=FormPF.getNav_ContactInfoEscalationInput().getAttribute("value");
						if(sActEscalationDropDownDefVal.equalsIgnoreCase(sExcelEscalationVal))
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Default value "+sActEscalationDropDownDefVal+" is displayed and is matching with expected");
						else
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Default value "+sActEscalationDropDownDefVal+" is displayed and is not matching with expected");
						break;
					case "User Role":
						sActUserRoleDropDownDefVal=FormPF.getNav_ContactInfoUserRoleInput().getAttribute("value");
						if(sActUserRoleDropDownDefVal.equalsIgnoreCase(sExcelUserRoleVal))
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Default value "+sActUserRoleDropDownDefVal+" is displayed and is matching with expected");
						else
							FrameworkUtil.updateCustomResultBasedOnStatus(true,"Default value "+sActUserRoleDropDownDefVal+" is displayed and is not matching with expected");
						break;
				}
	
	
			}
		}
	}
		
/*
	public static void validateMaxLengthDataFieldsAftrSaveAndContinueBtnClick(String sExcelFieldsToValidateVal,WebElement wFirstNameElemen,String sExcelFirstNameVal,WebElement wLastNameElement,String sExcelLstNameVal,WebElement wEmailNameElement,String sExcelEmailVal,WebElement wWrkPhoneElement,String sExcelWrkPhoneVal,WebElement wWrkPhoneExtnElement,String sExcelExtnVal,WebElement wCellPhoneElement,String sExcelCellPhoneVal,XSSFWorkbook xWrkBook,XSSFSheet xSheet,int row,int iStsColVal)
	{

		String sActualErrorToolTipEntireText,sActFirstNameToolTipMsg,sActFeedBackMsg = null,sAllFldsToolTipMsg = null,sWrkPhneExtInvldMsg;
		String sSveBtnFDBKMsg,sSveAndCntBtnFDBKMsg;
		String sFrstNameInvldMsg,sLstNameInvldMsg,sEmailInvldMsg,sWrkPhneInvldMsg,sCelPhneInvldMsg;
		String[] sFieldsNeedToValidateArray;
		String sActFirstNameToolTipMsgFN,sActFirstNameToolTipMsgLN,sActFirstNameToolTipMsgEA,sActFirstNameToolTipMsgPN,sActFirstNameToolTipMsgCN;
		//Enter all field values except first name, click on Save and Continue and verify feed back message and First name tool tip message
		boolean bSACValSts	,bFValTabOutSts;		
		sSveAndCntBtnFDBKMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.REQUIRED.TESTDATA.SAVEANDCONTINUE.BUTTON.CLICK.FEEDBACK.MESSAGE");
		sSveBtnFDBKMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.REQUIRED.TESTDATA.SAVE.BUTTON.CLICK.FEEDBACK.MESSAGE");
		
		sFrstNameInvldMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.MAX.LENGTH.TESTDATA.FIRSTNAME.TEXT.TABOUT.TOOLTIP.MESSAGE");
		sLstNameInvldMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.MAX.LENGTH.TESTDATA.LASTNAME.TEXT.TABOUT.TOOLTIP.MESSAGE");
		sEmailInvldMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.MAX.LENGTH.TESTDATA.EMAIL.TEXT.TABOUT.TOOLTIP.MESSAGE");
		sWrkPhneInvldMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.MAX.LENGTH.TESTDATA.WORKPHONE.TEXT.TABOUT.TOOLTIP.MESSAGE");
		sWrkPhneExtInvldMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.MAX.LENGTH.TESTDATA.WORKPHONE.EXTN.TEXT.TABOUT.TOOLTIP.MESSAGE");
		sCelPhneInvldMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.MAX.LENGTH.TESTDATA.CELLPHONE.TEXT.TABOUT.TOOLTIP.MESSAGE");

		sFieldsNeedToValidateArray=sExcelFieldsToValidateVal.split(",");
		if(sFieldsNeedToValidateArray.length==5)
		{
			//Fill all field values
			WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoFirstNameInput(), sExcelFirstNameVal);
			WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoLastNameInput(), sExcelLstNameVal);
			WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoEmailInput(), sExcelEmailVal);
			WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoAreaCodePhoneNumberInput(), sExcelWrkPhoneVal);
			WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfo, sExcelWrkPhoneVal);
			//Click on Save and Continue button
			WebObjectUtil.clickElement(FormPF.getNav_ContactInfoSaveAndCOntinueButton());
			WebObjectUtil.explicitWait(10);
			//Verify the feed back message after clicking Save and continue button
			sActFeedBackMsg=FormPF.getNav_FormFeedBackArea().getText();
			if(sActFeedBackMsg.equalsIgnoreCase(sSveAndCntBtnFDBKMsg))
			{
				//FrameworkUtil.updateCustomResultBasedOnStatus(true, sSveAndCntBtnFDBKMsg+" is same as actual message after clicking Save and continue by leaving all fields  empty. And Actual message is  "+sActFeedBackMsg);
				//AddFirewallRuleTestCase.writeExcelData(xSheet,row,iStsColVal,"Executed and Observed that Passed");
				//AddFirewallRuleTestCase.fillExcelCellCOlor(xWrkBook,xSheet,row,iStsColVal,"GREEN");
				bSACValSts=true;
			}else{
				//FrameworkUtil.updateCustomResultBasedOnStatus(false, sSveAndCntBtnFDBKMsg+" is not same as actual message after clicking Save and continue by leaving all fields  empty. And Actual message for referrence is    "+sActFeedBackMsg);
				//AddFirewallRuleTestCase.writeExcelData(xSheet,row,iStsColVal,"Executed and observed that Failed. For details verfiy Selenium HTML results");
				//AddFirewallRuleTestCase.fillExcelCellCOlor(xWrkBook,xSheet,row,iStsColVal,"RED");
				bSACValSts=false;
			}
			FormPF.getNav_ContactInfoFirstNameInput().click();
			sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoFirstNameInput().getAttribute("data-errorqtip");
			sActFirstNameToolTipMsgFN=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
			FormPF.getNav_ContactInfoLastNameInput().click();
			sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoLastNameInput().getAttribute("data-errorqtip");
			sActFirstNameToolTipMsgLN=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
			FormPF.getNav_ContactInfoEmailInput().click();
			sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoEmailInput().getAttribute("data-errorqtip");
			sActFirstNameToolTipMsgEA=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
			FormPF.getNav_ContactInfoAreaCodePhoneNumberInput().click();
			sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoAreaCodePhoneNumberInput().getAttribute("data-errorqtip");
			sActFirstNameToolTipMsgPN=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
			//Check following code.
			FormPF.getNav_ContactInfoAreaCodePhoneNumberInput().click();
			sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoCellPhoneAreaCodeNumberInput().getAttribute("data-errorqtip");
			sActFirstNameToolTipMsgCN=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
			sAllFldsToolTipMsg=sActFirstNameToolTipMsgFN+",  "+sActFirstNameToolTipMsgLN+",  "+sActFirstNameToolTipMsgEA+",  "+sActFirstNameToolTipMsgPN+" messages displayed for individual fields";
			if(sActFirstNameToolTipMsgFN.equalsIgnoreCase(sFrstNameInvldMsg) && sActFirstNameToolTipMsgLN.equalsIgnoreCase(sLstNameInvldMsg) && sActFirstNameToolTipMsgEA.equalsIgnoreCase(sEmailInvldMsg) && sActFirstNameToolTipMsgPN.equalsIgnoreCase(sWrkPhneInvldMsg)&& sActFirstNameToolTipMsgCN.equalsIgnoreCase(sCelPhneInvldMsg))
			{
				//FrameworkUtil.updateCustomResultBasedOnStatus(true,"Required field error tool tip message is matching with actual error tool tip message for First Name, Last Name, Email Address and Work phone fields" );
				
				bFValTabOutSts=true;
			}
			else
			{
				
			//	sAllFldsToolTipMsg=sActFirstNameToolTipMsgFN+",  "+sActFirstNameToolTipMsgLN+",  "+sActFirstNameToolTipMsgEA+",  "+sActFirstNameToolTipMsgPN+" messages displayed for individual fields";
				//FrameworkUtil.updateCustomResultBasedOnStatus(false, "Required field error tool tip message is not matching with actual error tool tip message for one/any of the field First Name, Last Name, Email Address and Work phone and messages are "+sAllFldsToolTipMsg);
				bFValTabOutSts=false;
			}
			
			//printResult(bSACValSts, bFValTabOutSts,xWrkBook,xSheet,row,iStsColVal,sActFeedBackMsg, sAllFldsToolTipMsg);
		}
		else
		{	
			for(int fc=0;fc<sFieldsNeedToValidateArray.length;fc++)
			{
				switch(sFieldsNeedToValidateArray[fc])
				{
					case "First Name":
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoFirstNameInput(), sExcelFirstNameVal);
						//Click back on first name field to see the error tool tip message
						FormPF.getNav_ContactInfoFirstNameInput().click();
						//Get tool tip message
						sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoFirstNameInput().getAttribute("data-errorqtip");
						sActFirstNameToolTipMsg=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
						
						if(sActFirstNameToolTipMsg.equalsIgnoreCase(sFrstNameInvldMsg))
						{
							//FrameworkUtil.updateCustomResultBasedOnStatus(true, sFrstNameReqMsg+" is same as actual message after tab out with out entering value in field. And Actual message is  "+sActFeedBackMsg);
							bFValTabOutSts=true;
						}
						else
						{
							//FrameworkUtil.updateCustomResultBasedOnStatus(false, sFrstNameReqMsg+" is not same as actual message after tab out with out entering value in field. And Actual message for referrence is  "+sActFeedBackMsg);
							bFValTabOutSts=false;
						}
						//Fill all field values
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoLastNameInput(), sExcelLstNameVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoEmailInput(), sExcelEmailVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoAreaCodePhoneNumberInput(), sExcelWrkPhoneVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoCellPhoneAreaCodeNumberInput(), sExcelCellPhoneVal);
						
						//						Click on Save and Continue button
						WebObjectUtil.clickElement(FormPF.getNav_ContactInfoSaveAndCOntinueButton());
						WebObjectUtil.explicitWait(10);
						//Verify the feed back message after clicking Save and continue button
						sActFeedBackMsg=FormPF.getNav_FormFeedBackArea().getText();
						if(sActFeedBackMsg.equalsIgnoreCase(sSveAndCntBtnFDBKMsg))
						{
							//FrameworkUtil.updateCustomResultBasedOnStatus(true, sSveAndCntBtnFDBKMsg+" is same as actual message after clicking Save and continue by leaving First Name field is empty. And Actual message is  "+sActFeedBackMsg);
							bSACValSts=true;
						}else
						{
							//FrameworkUtil.updateCustomResultBasedOnStatus(false, sSveAndCntBtnFDBKMsg+" is not same as actual message after clicking Save and continue by leaving First Name field is empty. And Actual message for referrence is    "+sActFeedBackMsg);
							bSACValSts=false;
						}
						//printResult(bSACValSts, bFValTabOutSts,xWrkBook,xSheet,row,iStsColVal,sActFeedBackMsg, sActFirstNameToolTipMsg);
						break;
					case "Last Name":
						
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoFirstNameInput(), sExcelFirstNameVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoFirstNameInput(), sExcelLstNameVal);
						FormPF.getNav_ContactInfoFirstNameInput().click();
						sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoLastNameInput().getAttribute("data-errorqtip");
						sActFirstNameToolTipMsg=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
						
						if(sActFirstNameToolTipMsg.equalsIgnoreCase(sLstNameInvldMsg))
						{
							//FrameworkUtil.updateCustomResultBasedOnStatus(true, sFrstNameReqMsg+" is same as actual message after tab out with out entering value in field. And Actual message is  "+sActFeedBackMsg);
							bFValTabOutSts=true;
						}
						else
						{
							//FrameworkUtil.updateCustomResultBasedOnStatus(false, sFrstNameReqMsg+" is not same as actual message after tab out with out entering value in field. And Actual message for referrence is  "+sActFeedBackMsg);
							bFValTabOutSts=false;
						}
						//Fill all field values						
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoEmailInput(), sExcelEmailVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoAreaCodePhoneNumberInput(), sExcelWrkPhoneVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoCellPhoneAreaCodeNumberInput(), sExcelCellPhoneVal);
						//Click on Save and Continue button
						WebObjectUtil.clickElement(FormPF.getNav_ContactInfoSaveAndCOntinueButton());
						WebObjectUtil.explicitWait(10);
						//Verify the feed back message after clicking Save and continue button
						sActFeedBackMsg=FormPF.getNav_FormFeedBackArea().getText();
						if(sActFeedBackMsg.equalsIgnoreCase(sSveAndCntBtnFDBKMsg))
							//FrameworkUtil.updateCustomResultBasedOnStatus(true, sSveAndCntBtnFDBKMsg+" is same as actual message after clicking Save and continue by leaving Last Name field is empty. And Actual message is  "+sActFeedBackMsg);
							bSACValSts=true;
						else
							//FrameworkUtil.updateCustomResultBasedOnStatus(false, sSveAndCntBtnFDBKMsg+" is not same as actual message after clicking Save and continue by leaving Last Name field is empty. And Actual message for referrence is    "+sActFeedBackMsg);
							bSACValSts=false;
						//printResult(bSACValSts, bFValTabOutSts,xWrkBook,xSheet,row,iStsColVal,sActFeedBackMsg, sActFirstNameToolTipMsg);
						break;
					case "Email Address":
							
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoFirstNameInput(), sExcelFirstNameVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoFirstNameInput(), sExcelLstNameVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoEmailInput(), sExcelEmailVal);
						FormPF.getNav_ContactInfoEmailInput().click();
						//Get tool tip message
						sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoLastNameInput().getAttribute("data-errorqtip");
						sActFirstNameToolTipMsg=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
						if(sActFirstNameToolTipMsg.equalsIgnoreCase(sEmailInvldMsg))
						{
							//FrameworkUtil.updateCustomResultBasedOnStatus(true, sFrstNameReqMsg+" is same as actual message after tab out with out entering value in field. And Actual message is  "+sActFeedBackMsg);
							bFValTabOutSts=true;
						}
						else
						{
							//FrameworkUtil.updateCustomResultBasedOnStatus(false, sFrstNameReqMsg+" is not same as actual message after tab out with out entering value in field. And Actual message for referrence is  "+sActFeedBackMsg);
							bFValTabOutSts=false;
						}
						//
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoAreaCodePhoneNumberInput(), sExcelWrkPhoneVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoCellPhoneAreaCodeNumberInput(), sExcelCellPhoneVal);
						//Click on Save and Continue button
						WebObjectUtil.clickElement(FormPF.getNav_ContactInfoSaveAndCOntinueButton());
						WebObjectUtil.explicitWait(10);
						//Verify the feed back message after clicking Save and continue button
						sActFeedBackMsg=FormPF.getNav_FormFeedBackArea().getText();
						if(sActFeedBackMsg.equalsIgnoreCase(sSveAndCntBtnFDBKMsg))
						
							//FrameworkUtil.updateCustomResultBasedOnStatus(true, sSveAndCntBtnFDBKMsg+" is same as actual message after clicking Save and continue by leaving Email Address field is empty. And Actual message is  "+sActFeedBackMsg);
							bSACValSts=true;
						
							else
							//FrameworkUtil.updateCustomResultBasedOnStatus(false, sSveAndCntBtnFDBKMsg+" is not same as actual message after clicking Save and continue by leaving Email Address field is empty. And Actual message for referrence is    "+sActFeedBackMsg);
							bSACValSts=true;
						//printResult(bSACValSts, bFValTabOutSts,xWrkBook,xSheet,row,iStsColVal,sActFeedBackMsg, sActFirstNameToolTipMsg);
						break;
					case "Work Phone":
							
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoFirstNameInput(), sExcelFirstNameVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoFirstNameInput(), sExcelLstNameVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoEmailInput(), sExcelEmailVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoAreaCodePhoneNumberInput(), sExcelWrkPhoneVal);
						//Click back on first name field to see the error tool tip message
						FormPF.getNav_ContactInfoAreaCodePhoneNumberInput().click();
						//Get tool tip message
						sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoLastNameInput().getAttribute("data-errorqtip");
						sActFirstNameToolTipMsg=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
						
						if(sActFirstNameToolTipMsg.equalsIgnoreCase(sWrkPhneInvldMsg))
						{
							//FrameworkUtil.updateCustomResultBasedOnStatus(true, sFrstNameReqMsg+" is same as actual message after tab out with out entering value in field. And Actual message is  "+sActFeedBackMsg);
							bFValTabOutSts=true;
						}
						else
						{
							//FrameworkUtil.updateCustomResultBasedOnStatus(false, sFrstNameReqMsg+" is not same as actual message after tab out with out entering value in field. And Actual message for referrence is  "+sActFeedBackMsg);
							bFValTabOutSts=false;
						}
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoCellPhoneAreaCodeNumberInput(), sExcelCellPhoneVal);
						//Click on Save and Continue button
						WebObjectUtil.clickElement(FormPF.getNav_ContactInfoSaveAndCOntinueButton());
						WebObjectUtil.explicitWait(10);
						//Verify the feed back message after clicking Save and continue button
						sActFeedBackMsg=FormPF.getNav_FormFeedBackArea().getText();
						if(sActFeedBackMsg.equalsIgnoreCase(sSveAndCntBtnFDBKMsg))
							//FrameworkUtil.updateCustomResultBasedOnStatus(true, sSveAndCntBtnFDBKMsg+" is same as actual message after clicking Save and continue by leaving Work Phone field is empty. And Actual message is  "+sActFeedBackMsg);
							bSACValSts=true;
						else
							//FrameworkUtil.updateCustomResultBasedOnStatus(false, sSveAndCntBtnFDBKMsg+" is not same as actual message after clicking Save and continue by leaving Work Phone field is empty. And Actual message for referrence is    "+sActFeedBackMsg);
							bSACValSts=true;
						//printResult(bSACValSts, bFValTabOutSts,xWrkBook,xSheet,row,iStsColVal,sActFeedBackMsg, sActFirstNameToolTipMsg);	
						break;
					case "Cell Phone":
						
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoFirstNameInput(), sExcelFirstNameVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoFirstNameInput(), sExcelLstNameVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoEmailInput(), sExcelEmailVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoAreaCodePhoneNumberInput(), sExcelWrkPhoneVal);
						WebObjectUtil.SetValueEdit(FormPF.getNav_ContactInfoCellPhoneAreaCodeNumberInput(), sExcelCellPhoneVal);
						//Click back on first name field to see the error tool tip message
						FormPF.getNav_ContactInfoCellPhoneAreaCodeNumberInput().click();
						//Get tool tip message
						sActualErrorToolTipEntireText=FormPF.getNav_ContactInfoLastNameInput().getAttribute("data-errorqtip");
						sActFirstNameToolTipMsg=StringUtils.substringBetween(sActualErrorToolTipEntireText, "<li>", "</li>");
						if(sActFirstNameToolTipMsg.equalsIgnoreCase(sCelPhneInvldMsg))
						{
							//FrameworkUtil.updateCustomResultBasedOnStatus(true, sFrstNameReqMsg+" is same as actual message after tab out with out entering value in field. And Actual message is  "+sActFeedBackMsg);
							bFValTabOutSts=true;
						}
						else
						{
							//FrameworkUtil.updateCustomResultBasedOnStatus(false, sFrstNameReqMsg+" is not same as actual message after tab out with out entering value in field. And Actual message for referrence is  "+sActFeedBackMsg);
							bFValTabOutSts=false;
						}
						//Click on Save and Continue button
						WebObjectUtil.clickElement(FormPF.getNav_ContactInfoSaveAndCOntinueButton());
						WebObjectUtil.explicitWait(10);
						//Verify the feed back message after clicking Save and continue button
						sActFeedBackMsg=FormPF.getNav_FormFeedBackArea().getText();
						if(sActFeedBackMsg.equalsIgnoreCase(sSveAndCntBtnFDBKMsg))
							//FrameworkUtil.updateCustomResultBasedOnStatus(true, sSveAndCntBtnFDBKMsg+" is same as actual message after clicking Save and continue by leaving Work Phone field is empty. And Actual message is  "+sActFeedBackMsg);
							bSACValSts=true;
						else
							//FrameworkUtil.updateCustomResultBasedOnStatus(false, sSveAndCntBtnFDBKMsg+" is not same as actual message after clicking Save and continue by leaving Work Phone field is empty. And Actual message for referrence is    "+sActFeedBackMsg);
							bSACValSts=true;
						//printResult(bSACValSts, bFValTabOutSts,xWrkBook,xSheet,row,iStsColVal,sActFeedBackMsg, sActFirstNameToolTipMsg);	
						break;
				}
			}
		}
			
	}
	
*/
public static void printResult(boolean bSACValSts,boolean bFValTabOutSts,XSSFWorkbook xWrkBook,XSSFSheet xSheet,int row,int iStsColVal,String sActFeedBackMsg,String sAllFldsToolTipMsg)
{
	if(!bSACValSts && !bFValTabOutSts)
	{
		FrameworkUtil.updateCustomResultBasedOnStatus(false, "Test Data Input Row  "+row+". Field error tool tip message and feedback message is not matching with actual error tool tip message after tab out and Save and continue for one/any of the field First Name, Last Name, Email Address and Work phone and messages are "+sAllFldsToolTipMsg+" and actual feed back message is "+sActFeedBackMsg);
		AddFirewallRuleTestCase.writeExcelData(xSheet,row,iStsColVal,"Executed and observed that Failed. For details verfiy Selenium HTML results");
		AddFirewallRuleTestCase.fillExcelCellCOlor(xWrkBook,xSheet,row,iStsColVal,"GREEN");
	}
	else if(bSACValSts && bFValTabOutSts)
	{
		FrameworkUtil.updateCustomResultBasedOnStatus(true, "Test Data Input Row  "+row+". Field error tool tip message and feedback message is matching with actual error tool tip message after tab out and Save and continue for one/any of the field First Name, Last Name, Email Address and Work phone and messages are "+sAllFldsToolTipMsg+" and actual feed back message is "+sActFeedBackMsg);
		AddFirewallRuleTestCase.writeExcelData(xSheet,row,iStsColVal,"Executed and observed that Passed.");
		AddFirewallRuleTestCase.fillExcelCellGREENCOlor(xWrkBook,xSheet,row,iStsColVal,"GREEN");
	}
	else if(!bSACValSts || !bFValTabOutSts)
	{
		if(!bSACValSts)
		{
			FrameworkUtil.updateCustomResultBasedOnStatus(false, "Test Data Input Row  "+row+". Feed back message is not matching with actual feed back message after Save and continue for one/any of the field First Name, Last Name, Email Address and Work phone and feed back message is "+sActFeedBackMsg);
			AddFirewallRuleTestCase.writeExcelData(xSheet,row,iStsColVal,"Executed and observed that Failed. For details verfiy Selenium HTML results");
			AddFirewallRuleTestCase.fillExcelCellCOlor(xWrkBook,xSheet,row,iStsColVal,"RED");
		}
		else if(!bFValTabOutSts)
		{
			FrameworkUtil.updateCustomResultBasedOnStatus(false, "Test Data Input Row  "+row+". Required field error tool tip message is not matching with actual error tool tip message after tab out for one/any of the field First Name, Last Name, Email Address and Work phone and messages are "+sAllFldsToolTipMsg);
			AddFirewallRuleTestCase.writeExcelData(xSheet,row,iStsColVal,"Executed and observed that Failed. For details verfiy Selenium HTML results");
			AddFirewallRuleTestCase.fillExcelCellCOlor(xWrkBook,xSheet,row,iStsColVal,"RED");
		}
	}
	else if(bSACValSts || bFValTabOutSts)
	{
		if(bSACValSts)
		{
			FrameworkUtil.updateCustomResultBasedOnStatus(true, "Test Data Input Row  "+row+". Feed back message is not matching with actual feed back message after Save and continue for one/any of the field First Name, Last Name, Email Address and Work phone and feed back message is "+sActFeedBackMsg);
			AddFirewallRuleTestCase.writeExcelData(xSheet,row,iStsColVal,"Executed and observed that Passed.");
			AddFirewallRuleTestCase.fillExcelCellGREENCOlor(xWrkBook,xSheet,row,iStsColVal,"GREEN");
			//AddFirewallRuleTestCase.fill
		}
		else if(bFValTabOutSts)
		{
			FrameworkUtil.updateCustomResultBasedOnStatus(true, "Test Data Input Row  "+row+". Required field error tool tip message is not matching with actual error tool tip message after tab out for one/any of the field First Name, Last Name, Email Address and Work phone and messages are "+sAllFldsToolTipMsg);
			AddFirewallRuleTestCase.writeExcelData(xSheet,row,iStsColVal,"Executed and observed that Passed.");
			AddFirewallRuleTestCase.fillExcelCellGREENCOlor(xWrkBook,xSheet,row,iStsColVal,"GREEN");
		}
	}
}
		//update each @test result in custom result file
		@AfterMethod
		public static void afterEachMethod(){
			FrameworkUtil.updateTestCaseStatusinResult();
			FrameworkUtil.sTestExecutionStatus = true;
			
		}
	

}






