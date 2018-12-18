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
import com.whs.navigator.pagefactory.EVDC_FirewallPageFactory;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.CommonPageFactory;
public class NavigatorCommonMethods {

	public static HomePageFactory_old Home = new HomePageFactory_old();
	public static EVDC_FirewallPageFactory FirewallPF = new EVDC_FirewallPageFactory();
	public static CommonPageFactory Common = new CommonPageFactory();
	public static EVDC_OverviewPageFactory EVDC_Overview = new EVDC_OverviewPageFactory();

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
/*==============================================================
MethodName 		: SelectElementFromDropDown
Manual TestCase	: 
Description		: Select the element for the custom drop down by visible text
Author 			: QAA04
Creation Date 	: 02/10/2016
release Name    : 
Pre-Requisites	:
Revision History:
==============================================================*/
public static void SelectElementFromDropDown(WebElement wDropDownArrow, String sDropDownVisibleText){
	WebElement wTypeDropdown;
	String sXpath;
	try{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, FirewallPF);
	
	 WebObjectUtil.clickElement(wDropDownArrow);
	 sXpath = (String) FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
	 wTypeDropdown =WebObjectUtil.getActiveElementasWebElement(sXpath);
	 WebObjectUtil.selectCustomWebList(wTypeDropdown, sDropDownVisibleText);
	}catch(Exception e){
		LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
		LoggerUtil.log_type_error(e.getMessage());
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
		if(WebObjectUtil.isElementPresent(Common.getNav_CreateTicketPopupOKBtn()))
		{
			
			WebObjectUtil.clickElement(Common.getNav_CreateTicketPopupOKBtn());
		}
		else
		{
			WebObjectUtil.clickElement(Home.getNav_SubmitBtn());
		}
		
		WebObjectUtil.explicitWait(5);
		//if(WebObjectUtil.isElementPresent(Home.getNav_CreateFeedbackSucessNotificationOKBtn())){
		if(WebObjectUtil.isElementPresent(Common.getNav_CommonPopUpOKButton())){
			bStatus=true;
			//WebObjectUtil.clickElement(Home.getNav_CreateFeedbackSucessNotificationOKBtn());
			WebObjectUtil.clickElement(Common.getNav_CommonPopUpOKButton());
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
	

/*==============================================================
Method Name		: createTicketDialogSubmit
Description		: It will fill title and notes(Frame) and submit the dialog to create ticket
Author 			: Vivek
Creation Date 	: 06/22/2016
Pre-Requisites	: 
Revision History:

==============================================================*/
public static String createTicketDialogSubmit( String sModuleName){
	boolean bStatus = false;
	String sTitle = null,sNotes;
	 WebDriver driver = WebDriverUtil.getDriver();
	 PageFactory.initElements(driver, Home);
	 
	try {
		sTitle="SelTst_"+FrameworkUtil.date_yyyyMMdd()+ "_"+FrameworkUtil.date_HHmmss()+"_"+ sModuleName ;
		sNotes = sTitle + "_Notes";
		WebObjectUtil.SetValueEdit(Home.getNav_TitleText(),sTitle);
		WebObjectUtil.explicitWait(2);
		Home.getNav_CreateFeedbackIframe().sendKeys(sNotes); 
		WebObjectUtil.explicitWait(2);
		WebObjectUtil.clickElement(Home.getNav_SubmitBtn());
		
		
		WebObjectUtil.explicitWait(5);
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return sTitle;
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



public static void navigateToModuleThroughURL(String sModuleName){
	
	String sEVDC=null;
	
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EVDC_Overview);
	
	try {
		String sBaseUrl = driver.getCurrentUrl();
		String[] arrURL = sBaseUrl.split(".com"); 
		sBaseUrl=arrURL[0]+".com";
		
		
		try {
			sEVDC = EVDC_Overview.getNav_EVDCname().getAttribute("href");
			if (sEVDC.contains("currEvdc")){
			String[] arrEVDC = sEVDC.split("\\?");
			sEVDC = arrEVDC[arrEVDC.length-1];
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sFirewall=sBaseUrl + "/firewall?" + sEVDC ;
		String sVM=sBaseUrl + sBaseUrl + "/virtual-machines?" + sEVDC ;
		String sCatalog= sBaseUrl + "/catalogs?" + sEVDC ;
		String sLoadBalancer= sBaseUrl + "/load-balancers?" + sEVDC ;
		String sStorageProfile= sBaseUrl + "/storage-profiles?" + sEVDC ;
		String sBandWidth=sBaseUrl + "/reports/bandwidth";
		
String sMonitoring=sBaseUrl + "/en/home#";
String sSummary=sBaseUrl + "/en/web/guest/home";
String sDeviceMonitoring="https://tst-lab2-em7.lab.hostedsolutions.com/";
String sReports=sBaseUrl + "/en/reports";
String sServices=sBaseUrl + "/en/home#";
String sDraaS=sBaseUrl + "/en/draas";
String sDns=sBaseUrl + "/en/dns";
String sCloudApi=sBaseUrl + "/en/cloudapi";
String sCloudService="https://vcloud-lab3.lab.hostedsolutions.com/cloud/org/tstqaauto/";
String sSecurity=sBaseUrl + "/en/home#";
String sDdos=sBaseUrl + "/en/ddos";
String sCloudAV=sBaseUrl + "/en/cloudav";
String sSupport=sBaseUrl + "/en/home#";
String sTickets=sBaseUrl + "/en/tickets";
String sForms=sBaseUrl + "/en/forms";
String sAnnoucement=sBaseUrl + "/en/announcements";
String sDocument=sBaseUrl + "/en/documents";
String sFaq=sBaseUrl + "/en/faq";
String sCustomerAdvocate=sBaseUrl + "/en/customer-advocate";
String sLogViewer=sBaseUrl + "/en/log-viewer";
String sRNF=sBaseUrl + "/en/home#";
String Account=sBaseUrl + "/en/home#";
String sAccountSetting=sBaseUrl + "/en/group/control_panel/manage?p_p_id=2&p_p_lifecycle=0&p_p_state=maximized&p_p_mode=view";
String sPermission=sBaseUrl + "/en/permissions";
String sEscalation=sBaseUrl + "/en/escalation_list";

		sModuleName = sModuleName.toLowerCase();
switch (sModuleName) {
case "summary":
	driver.get(sSummary);
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Navigate through URL", "Navigate to Module:"+sModuleName, "done", "Navigated to:"+sSummary);
	break;
	
case "devicemonitoring":
	driver.get(sDeviceMonitoring);
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Navigate through URL", "Navigate to Module:"+sModuleName, "done", "Navigated to:"+sDeviceMonitoring);
	break;
	

case "report":
	driver.get(sReports);
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Navigate through URL", "Navigate to Module:"+sModuleName, "done", "Navigated to:"+sReports);
	break;
	
	
case "draas":
	driver.get(sDraaS);
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Navigate through URL", "Navigate to Module:"+sModuleName, "done", "Navigated to:"+sDraaS);
	break;
case "dns":
	driver.get(sDns);
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Navigate through URL", "Navigate to Module:"+sModuleName, "done", "Navigated to:"+sDns);
	break;
		
case "cloudapi":
	driver.get(sCloudApi);
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Navigate through URL", "Navigate to Module:"+sModuleName, "done", "Navigated to:"+sCloudApi);
	break;
	
case "cloudservice":
	driver.get(sCloudService);
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Navigate through URL", "Navigate to Module:"+sModuleName, "done", "Navigated to:"+sCloudService);
	break;
	
case "ddos":
	driver.get(sDdos);
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Navigate through URL", "Navigate to Module:"+sModuleName, "done", "Navigated to:"+sDdos);
	break;
	
case "cloudav":
	driver.get(sCloudAV);
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Navigate through URL", "Navigate to Module:"+sModuleName, "done", "Navigated to:"+sCloudAV);
	break;
	
case "ticket":
	driver.get(sTickets);
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Navigate through URL", "Navigate to Module:"+sModuleName, "done", "Navigated to:"+sTickets);
	break;
	
case "form":
	driver.get(sForms);
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Navigate through URL", "Navigate to Module:"+sModuleName, "done", "Navigated to:"+sForms);
	break;
	
case "annoucement":
	driver.get(sAnnoucement);
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Navigate through URL", "Navigate to Module:"+sModuleName, "done", "Navigated to:"+sAnnoucement);
	break;

case "document":
	driver.get(sDocument);
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Navigate through URL", "Navigate to Module:"+sModuleName, "done", "Navigated to:"+sDocument);
	break;
	
case "customeradvocate":
	driver.get(sCustomerAdvocate);
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Navigate through URL", "Navigate to Module:"+sModuleName, "done", "Navigated to:"+sCustomerAdvocate);
	break;
	
case "faq":
	driver.get(sFaq);
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Navigate through URL", "Navigate to Module:"+sModuleName, "done", "Navigated to:"+sFaq);
	break;
	
	
case "logviewer":
	driver.get(sLogViewer);
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Navigate through URL", "Navigate to Module:"+sModuleName, "done", "Navigated to:"+sLogViewer);
	break;
	
case "accountsetting":
	driver.get(sAccountSetting);
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Navigate through URL", "Navigate to Module:"+sModuleName, "done", "Navigated to:"+sAccountSetting);
	break;
	
case "userpermission":
	driver.get(sPermission);
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Navigate through URL", "Navigate to Module:"+sModuleName, "done", "Navigated to:"+sPermission);
	break;
	
case "escalation":
	driver.get(sEscalation);
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Navigate through URL", "Navigate to Module:"+sModuleName, "done", "Navigated to:"+sEscalation);
	break;
	
case "requestnewfeature":
	driver.get(sRNF);
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Navigate through URL", "Navigate to Module:"+sModuleName, "done", "Navigated to:"+sRNF);
	break;
	
case "firewall":
	driver.get(sFirewall);
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Navigate through URL", "Navigate to Module:"+sModuleName, "done", "Navigated to:"+sFirewall);
	break;
	
case "calalog":
	driver.get(sCatalog);
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Navigate through URL", "Navigate to Module:"+sModuleName, "done", "Navigated to:"+sCatalog);
	break;
	
	
case "virtualmachine":
	driver.get(sVM);
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Navigate through URL", "Navigate to Module:"+sModuleName, "done", "Navigated to:"+sVM);
	break;
	
case "storageprofile":
	driver.get(sStorageProfile);
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Navigate through URL", "Navigate to Module:"+sModuleName, "done", "Navigated to:"+sStorageProfile);
	break;
	
case "loadbalancer":
	driver.get(sLoadBalancer);
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Navigate through URL", "Navigate to Module:"+sModuleName, "done", "Navigated to:"+sLoadBalancer);
	break;
	
case "bandwidth":
	driver.get(sBandWidth);
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Navigate through URL", "Navigate to Module:"+sModuleName, "done", "Navigated to:"+sBandWidth);
	break;
	
		
	default:
		driver.get(sBaseUrl);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Navigate through URL", "Navigated to default:"+sModuleName, "warn", "Navigated to:"+sBaseUrl);
		break;
		
		
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


}




}
