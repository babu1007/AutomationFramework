package com.whs.navigator.testcases;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.IACPageFactory;

public class IACTestcase {
    public static IACPageFactory IAC_PF =new IACPageFactory();
	public static boolean bLoginStatus=false;
	 public static String sUpdatedIPAdress; 
	/*==============================================================
	Method Name 	: IAC_Login
	Description		: we are login with username and password to the IAC application
	Author 			: NMR
	Creation Date 	: 12/08/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
   public static void IAC_login(String sUserName,String sPassword)
   {
	   boolean bLoginStatus=false;
	   if(!bLoginStatus)
		{
		  WebDriver driver = WebDriverUtil.getDriver();	
			PageFactory.initElements(driver, IAC_PF);
			try {

		    	WebDriverUtil.getDriver().get((String)FrameworkUtil.dictPropertyData.get("NAV.IAC.URL"));
				WebObjectUtil.explicitWait(5);
				
				WebObjectUtil.SetValueEdit(IAC_PF.getNavUserName(),sUserName );
				WebObjectUtil.explicitWait(3);
				WebObjectUtil.SetValueEdit(IAC_PF.getNavPassword(),sPassword );
				WebObjectUtil.explicitWait(3);
				WebObjectUtil.clickElement(IAC_PF.getNavSubmitBtn());
				
				WebObjectUtil.waitForPageLoad();
				bLoginStatus=true;
				//FrameworkUtil.takeScreenShot();
			} catch (Exception e) {
				LoggerUtil.setClassNameForLog("Verify Login");
				LoggerUtil.log_type_error("Login Failed with UserID - " + sUserName);
				bLoginStatus=false;
			}
		}

      }
   /*==============================================================
	Method Name 	: IAC_Logout
	Description		: we are log out to the IAC application
	Author 			: NMR
	Creation Date 	: 12/08/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
   public static void IAC_Logout() {
	   
	   WebDriver driver =WebDriverUtil.getDriver();
	   PageFactory.initElements(driver, IAC_PF);
	   
	   try {
		   
		   if(bLoginStatus || WebObjectUtil.isElementPresent(IAC_PF.getNavUserDropDown()))
			   
			   WebObjectUtil.clickElement(IAC_PF.getNavUserDropDown());
		       WebObjectUtil.explicitWait(2);
		       WebObjectUtil.clickElement(IAC_PF.getNavLogOutLink());
	  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Select Item from UserDropDown", "pass", "Item selected: Logout");
	   }
	   catch(Exception e) {
		   LoggerUtil.log_type_error("IAC Application - issue with Logout");
		   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage()+"null");
	   }
   }
   
   /*==============================================================
	MethodName 		: IACLogin
	Manual TestCase	: 
	Description		: login to IAC to suneeta user
	Author 			: QAA04
	Creation Date 	: 12/08/2015
	release Name    : Hague
	Pre-Requisites	:
	Revision History:
	
	==============================================================*/
public static void IACLogin() {
	  
	  String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.IAC.USERNAME");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.IAC.PASSWORD");
	  IACTestcase.IAC_login(sUserName, sPassword);
}
   
   /*==============================================================
   Method Name  	: selectMenuItem
   Manual TestCase	:
   Description		: selecting the item to the main manu drop down
   Author 			: QAA04
   Creation Date 	: 12/08/2015
   Pre-Requisites	:
   Revision History:
   ==============================================================*/
   public static void selectMenuItem(String sMenuItem) {
   	WebElement wIACMenuItemDropDrown;
   	String sIACMenuItemSelect;
   	WebDriver driver = WebDriverUtil.getDriver();
   	PageFactory.initElements(driver, IAC_PF);
   	
   	
   	 wIACMenuItemDropDrown = IAC_PF.getNavModuleMenu_DropDown();
       
        WebObjectUtil.selectWebList(wIACMenuItemDropDrown, sMenuItem, null, null);
        WebObjectUtil.explicitWait(5);
       
   	
   }
   
   /*==============================================================
   Method Name  	: ExpandServiceItem
   Manual TestCase	:
   Description		: Expanding the particular service item
   Author 			: QAA04
   Creation Date 	: 12/08/2015
   Pre-Requisites	:
   Revision History:
   ==============================================================*/
   public static void ExpandServiceItem(String sExpandServiceItemName){
   	String sExpandServiceItem;
   	WebElement wExpandServiceItem;
   	WebDriver driver = WebDriverUtil.getDriver();
   	PageFactory.initElements(driver, IAC_PF);
   	
   	 sExpandServiceItem= WebObjectUtil.getLocatorValueFromProperty("IAC.SERVICE.ITEM.EXPAND", "PARAMETER_SERVICEITEM_NAME", sExpandServiceItemName);
        wExpandServiceItem=WebObjectUtil.GetWebElement("XPATH", sExpandServiceItem, "Expand the service item"); 
        WebObjectUtil.clickElement(wExpandServiceItem);
     
   	
   }
   
   /*==============================================================
   Method Name  	: IAC_EditIPAdderess
   Manual TestCase	:
   Description		: updating the ipaddress for the load balancer module
   Author 			: QAA04
   Creation Date 	: 12/08/2015
   Pre-Requisites	:
   Revision History:
   ==============================================================*/
   public static void IAC_EditIPAdderess() {
   	String sTableFirstRow,sIPAddrs,sIPLast,sUpdatedIP,sFilterPopUp,sApplyBtn;
   	int iIPLast,iUpdatedIP;
   	String[] sIPLastDigit;
   	WebElement wFilterPOpUP,wApplyBtn,wTableRow;
   	WebDriver driver = WebDriverUtil.getDriver();
   	PageFactory.initElements(driver, IAC_PF);
   	
   	WebObjectUtil.clickElement(IAC_PF.getNavFilterandSrearchBtn());
   	WebObjectUtil.explicitWait(5);
   	
   	sFilterPopUp = (String) FrameworkUtil.dictPropertyData.get("NAV.IAC.SERVICE.ITEM.TABLE.FILTERANDSEARCH.POPUPBOX");
   	wFilterPOpUP = WebObjectUtil.getActiveElementasWebElement(sFilterPopUp);
   		 
   	if(WebObjectUtil.isElementPresent(wFilterPOpUP)) {
   		
   		WebObjectUtil.SetValueEdit(IAC_PF.getNavFilterandSearch_UniqueIdEditField(), "tstmash4077");
   		sApplyBtn = (String) FrameworkUtil.dictPropertyData.get("NAV.IAC.SERVICE.ITEM.TABLE.FILTERANDSEARCH.POPUP.APPLY.BUTTON");
   		wApplyBtn = WebObjectUtil.getActiveElementasWebElement(sApplyBtn);
   		WebObjectUtil.clickElement(wApplyBtn);
   		WebObjectUtil.explicitWait(5);
   	   sTableFirstRow = WebObjectUtil.getLocatorValueFromProperty("IAC.MANAGESERVICE.TABLE.FIRST.COLUMN", "PARAMETER_ROWNUMBER", 1+"");
   	   wTableRow= WebObjectUtil.GetWebElement("XPATH", sTableFirstRow, "manage service table row");
   	   WebObjectUtil.clickElement(wTableRow);
   	
   	   WebObjectUtil.explicitWait(5);
   	 sIPAddrs=  IAC_PF.getNavIPAddressEditField().getText();
    	sIPLastDigit = sIPAddrs.split(Pattern.quote("."));
   	sIPLast = sIPLastDigit[3];
   	iIPLast = Integer.parseInt(sIPLast);
   	iUpdatedIP = iIPLast+1;
   	sUpdatedIP = String.valueOf(iUpdatedIP);
   	sUpdatedIPAdress = sIPLastDigit[0]+"."+sIPLastDigit[1]+"."+sIPLastDigit[2]+"."+sUpdatedIP;
   	 
   	WebObjectUtil.clickElement(IAC_PF.getNavIPAddressEditField());
   	  
   	   WebObjectUtil.explicitWait(3);
   	   WebObjectUtil.clickElement(IAC_PF.getNavIPAddressEditField());
   	// WebElement wIPAddressEditField = WebObjectUtil.getActiveULElementasWebElement("//div[@id='generalInfoGrid']//input[@class='x-form-text x-form-field x-form-focus']");
   	
   	 WebObjectUtil.SetValueEdit(IAC_PF.getNavIPAddressEditInputField(), sUpdatedIPAdress);;
   	   
   	
   	   WebObjectUtil.clickElement(IAC_PF.getNavSaveBtn());
   	   WebObjectUtil.explicitWait(5);
   	}
   	else {
   		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verifying the filter and search popup box", "fail", "popup box is NOT displaying");
   		
   	}
   	 
   	

   	
   	
   }

   
   
   
   
   
   
   
   
}
