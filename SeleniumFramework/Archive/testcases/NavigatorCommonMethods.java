package com.whs.navigator.testcases;

import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.CommonPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory;


public class NavigatorCommonMethods {
        
	public static CommonPageFactory Common = new CommonPageFactory();
	public static HomePageFactory Home = new HomePageFactory();

/*==============================================================
Method Name		: clickOnExpander
Description		: Expand the expander by click On it
Author 			: Arul
Creation Date 	: 03/08/2016
Pre-Requisites	: 
Revision History:

==============================================================*/
public static void clickOnExpander(WebElement webElement) {
	WebDriver driver = WebDriverUtil.getDriver();
	try {
		if (webElement.isEnabled() && webElement.isDisplayed()) {
			WebObjectUtil.scrollToElement(webElement);
			webElement.sendKeys(Keys.ENTER);
			webElement.sendKeys(Keys.RETURN);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Click on expander", "Done", "");
		} else {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Click on expander", "warn", "issue with finding an element");
		}
	
	} catch (Exception e) {
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Click on expander", "warn", "catch block:Unable to Click on expander" +e.getMessage());
	}
}


public static void mouseClick(WebElement webElement){
	Robot robot;

	try {
	robot = new Robot();
	robot.delay(1000);
	robot.mouseMove(webElement.getLocation().getX(), webElement.getSize().height);
	robot.delay(1000);
	robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
	robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	robot.delay(1000);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}



/*==============================================================
Method Name		: submitDialogForCreateTicket
Description		: It will fill title and notes(Frame) and submit the dialog to create ticket
Author 			: Arul
Creation Date 	: 06/06/2016
Pre-Requisites	: 
Revision History:

==============================================================*/
public static String submitDialogForCreateTicket( String sModuleName){
	boolean bStatus = false;
	String sTitle = null,sNotes;
	 WebDriver driver = WebDriverUtil.getDriver();
	 PageFactory.initElements(driver, Home);
	 PageFactory.initElements(driver, Common);
	try {
		sTitle="SelTst_"+FrameworkUtil.date_yyyyMMdd()+ "_"+FrameworkUtil.date_HHmmss()+"_"+ sModuleName ;
		sNotes = sTitle + "_Notes";
		WebObjectUtil.SetValueEdit(Home.getNav_TitleText(),sTitle);
		WebObjectUtil.explicitWait(2);
		Home.getNav_CreateFeedbackIframe().sendKeys(sNotes); 
		WebObjectUtil.explicitWait(2);
		
		WebObjectUtil.clickElement(Home.getNav_OkBtn());
		WebObjectUtil.explicitWait(5);
		//if(WebObjectUtil.isElementPresent(Home.getNav_CreateFeedbackSucessNotificationOKBtn())
		if(WebObjectUtil.isElementPresent(Common.getNav_CommonPopUpOKButtonwithID()))
		{
			bStatus=true;
			//WebObjectUtil.clickElement(Home.getNav_CreateFeedbackSucessNotificationOKBtn());
			WebObjectUtil.clickElement(Common.getNav_CommonPopUpOKButtonwithID());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Submit dialog (to create ticket)", "pass", "Dialog submited successfully, Title:" + sTitle + ",  notes:" + sNotes);
		}else{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Submit dialog (to create ticket)", "warn", "Dialog submited successfully, Title:" + sTitle + ",  notes:" + sNotes);
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return sTitle;
}
	/*====================================================================================================
	Method Name 	: verifyPDFAndCSVIcons
	Description		: Verifying PDF and CSV Icons
	Author 			: QAA03
	Creation Date 	: 03/23/2016
	Pre-Requisites	: 
	Revision History:
	====================================================================================================*/
	public static void verifyPDFAndCSVIcons()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,Common);
			String sPDFLinkText=null,sCSVLinkText=null;
			boolean bPDFStatus,bCSVStatus;
	 try {
		    //Verifying PDF Icon on VM Machine portlet
			WebObjectUtil.verifyElementPresent(Common.getNav_PDFLink());
			//Verifying the PDF Icon contains "format=pdf"
			sPDFLinkText=Common.getNav_PDFLink().getAttribute("href");
			 bPDFStatus= sPDFLinkText.contains("format=pdf");
			 FrameworkUtil.updateCustomResultBasedOnStatus(bPDFStatus, "PDF link contains  format=pdf");
						
			//Verifying CSV Icon on VM Machine portlet
			WebObjectUtil.verifyElementPresent(Common.getNav_CSVLink());
			//Verifying the CSV Icon contains "format=csv"
			sCSVLinkText=Common.getNav_CSVLink().getAttribute("href");
			bCSVStatus=sCSVLinkText.contains("format=csv");
			FrameworkUtil.updateCustomResultBasedOnStatus(bCSVStatus, "CSV link contains format=csv");
			
		   
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyPDFAndCSVIcons", "warn", "catch block:" +e.getMessage());  
		}
	 
	}
	/*==============================================================
	Method Name 	: verifyColumnSort
	Description		: This will verify the Column Sorting
	Author 			: Priyanka R
	Creation Date 	: 06/13/2016
	Pre-Requisites	:
	Revision History: 
	==============================================================*/
	public static void verifyColumnSort(WebElement wColumnName, WebElement wFirstRowElement, int iRowLength)
	
	{
		WebDriver driver = WebDriverUtil.getDriver();
		String sFirstRowElement,sNewFirstRowElement;
		try {
	if(iRowLength>1){
	sFirstRowElement=wFirstRowElement.getText();		
	WebObjectUtil.clickElement(wColumnName);
	
	sNewFirstRowElement=wFirstRowElement.getText();
	if(!(sFirstRowElement.equals(sNewFirstRowElement)))
	{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "FirstRowElement" , "Values are Different", "pass", "Sorting is Passed");
	}
	else
	{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "FirstRowElement" , "Values are Same", "warn", "Sorting is Failed,check manually");
	}
	}
	else{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Only one row is present" , "Sorting", "warn", "Sorting  Cannot be verified");
	}
	
	}
	catch (Exception e) {
		LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
	}
	}
	
	/*==============================================================
	Method Name 	: verifyColumnNotSorted
	Description		: This will verify the Column Sorting
	Author 			: Priyanka R
	Creation Date 	: 06/13/2016
	Pre-Requisites	:
	Revision History: 
	==============================================================*/
	public static void verifyColumnNotSorted(WebElement wColumnName, WebElement wFirstRowElement, int iRowLength)
	
	{
		WebDriver driver = WebDriverUtil.getDriver();
		String sFirstRowElement,sNewFirstRowElement;
		try {
	if(iRowLength>1){
	sFirstRowElement=wFirstRowElement.getText();		
	WebObjectUtil.clickElement(wColumnName);
	sNewFirstRowElement=wFirstRowElement.getText();
	if((sFirstRowElement.equals(sNewFirstRowElement)))
	{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "FirstRowElement" , "Values are Different", "pass", "Sorting is Passed");
	}
	else
	{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "FirstRowElement" , "Values are Same", "warn", "Sorting is Failed,check manually");
	}
	}
	else{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Only one row is present" , "Sorting", "warn", "Sorting  Cannot be verified");
	}
	
	}
	catch (Exception e) {
		LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
	}
	}
}
