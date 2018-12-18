package com.whs.navigator.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.CommonPageFactory;
import com.whs.navigator.pagefactory.EVDC_FirewallPageFactory;

public class CorwinTestCase_Vivek {
	public static EVDC_FirewallPageFactory Firewall = new EVDC_FirewallPageFactory();
	public static CommonPageFactory Common = new CommonPageFactory();
	/*==============================================================
	TestScript  	: verifyNATEdtDelBtnAfterDel
	Manual TestCase	: QAT-1328-WCP_4758_TC_1.5_Delete NAT- Add NAT , Edit & Delete buttons are disabled
	Description		: Delete NAT- Add NAT , Edit & Delete buttons are disabled
	Note			: 
	Author 			: Vivek Kumar
	Creation Date 	: 06/14/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=1)
	public void verifyNATEdtDelBtnAfterDel()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Firewall);
		PageFactory.initElements(driver, Common);
		
		FrameworkUtil.sTestCaseName = "verifyNATEdtDelBtnAfterDel";
		FrameworkUtil.sManualTestCaseName="QAT-1328-WCP_4758_TC_1.5_Delete NAT- Add NAT , Edit & Delete buttons are disabled";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		String sUserName,sPassword;
		WebElement wNATExpander;
		
		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.USERID.QAAUTOA");
		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.PWD.QAAUTOA");
		
		//Step 1- 3
		EVDC_FirewallTestCase.navLoginAndNavigatetoNATSPage(sUserName,sPassword);
	
		
		//Step - 4 - Expanding the first NAT 
		wNATExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.FIREWALL.NAT.EXPANDER", "","");
	 	WebObjectUtil.clickElement(wNATExpander);
		
	 	//Step - 5 - Deleting the NAT
	 	WebObjectUtil.clickElement(Firewall.getNav_deleteButtonUnderNetwork());
	 	WebObjectUtil.clickElement(Firewall.getNav_Network_ConfirmPopupOkBtn());
	 	WebObjectUtil.clickElement(Common.getNav_CommonPopUpOKButton());
	 	
	}

}
