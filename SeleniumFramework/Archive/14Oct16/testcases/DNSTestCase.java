package com.whs.navigator.testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import com.whs.navigator.commonUtil.WebTableUtil;
import com.whs.navigator.pagefactory.DNSPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.SmokeTestPageFactory;

public class DNSTestCase {

	public static DNSPageFactory DNS_PF = new DNSPageFactory();
	public static SmokeTestPageFactory Smoke =new SmokeTestPageFactory();
	public static HomePageFactory_old Home = new HomePageFactory_old();
	/*==============================================================
	TestScript  	: verifyZoneNameunderSenderPolicyinDNSPage
	Manual TestCase	: QAT-1413 - WCP_4603_TC_1.6_Alilgning DNS UI New Design- Name field Data display for Sender Policy Tab when Name is same as zone name--Verification in Blue Cat
	Description		: verifying the sender policy data for the zone name selected 
	Author 			: QAA03
	Creation Date 	: 26/05/2016
	Release Name    : DNS_PF
	Coverage        : First six steps are automated
	Pre-Requisites	:
	Revision History:
	==============================================================*/
		
	@Test(priority=1)
	public void verifyZoneNameunderSenderPolicyinDNSPage()
	{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver,DNS_PF);
					
					String sULElement=null,sZoneName=null;
				
				
				try {
					FrameworkUtil.sTestCaseName = "verifyZoneNameunderSenderPolicyinDNSPage";
					FrameworkUtil.sManualTestCaseName="QAT-1413 - WCP_4603_TC_1.6_Alilgning DNS UI New Design- Name field Data display for Sender Policy Tab when Name is same as zone name--Verification in Blue Cat.";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					
					sULElement = (String)FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
					sZoneName = (String)FrameworkUtil.dictPropertyData.get("NAV.DNS.ZONENAME");
					
					//Login to Navigator with devco1 user
					LoginTestCase_Old1.LoginAsDevcoUser();
					
					//Navigating to DNS Page
					navToDNSPage();
					
					//Selecting the zone name from the drop down
					WebObjectUtil.clickElement(DNS_PF.getNav_DNS_ZoneNameDropdownArrow());
					
					WebObjectUtil.selectCustomWebList(DNS_PF.getNav_DNS_ZoneNameDropdownArrow(), sULElement, sZoneName, 1);
					
					//Clicking on Sender Policy tab and verifying the zone data
					clickSenderPolicyTabAndVerifyData(sZoneName);
					
					//Logout from Navigator
					LoginTestCase_Old1.nav_Logout();
				
				   } catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyZoneNameunderSenderPolicyinDNSPage", "warn", "catch block:" +e.getMessage());
			}
		}
	
	/*==============================================================
	TestScript  	: verifyZoneNameunderTextTabinDNSPage
	Manual TestCase	: QAT-1412 - WCP_4603_TC_1.5_Alilgning DNS UI New Design- Name field Data display for Text Tab when Name is same as zone name--Verification in Blue Cat
	Description		: verifying the Text data for the zone name selected  
	Author 			: QAA03
	Creation Date 	: 27/05/2016
	Release Name    : DNS_PF
	Coverage        : First six steps are automated
	Pre-Requisites	:
	Revision History:
	==============================================================*/
		
	@Test(priority=2)
	public void verifyZoneNameunderTextTabinDNSPage()
	{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver,DNS_PF);
					
					String sULElement=null,sZoneName=null;
				
				
				try {
					FrameworkUtil.sTestCaseName = "verifyZoneNameunderTextTabinDNSPage";
					FrameworkUtil.sManualTestCaseName="QAT-1412 - WCP_4603_TC_1.5_Alilgning DNS UI New Design- Name field Data display for Text Tab when Name is same as zone name--Verification in Blue Cat.";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					
					sULElement = (String)FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
					sZoneName = (String)FrameworkUtil.dictPropertyData.get("NAV.DNS.ZONENAME");
					
					//Login to Navigator with devco1 user
					LoginTestCase_Old1.LoginAsDevcoUser();
					
					//Navigating to DNS Page
					navToDNSPage();
					
					//Selecting the zone name from the drop down
					WebObjectUtil.clickElement(DNS_PF.getNav_DNS_ZoneNameDropdownArrow());
					
					WebObjectUtil.selectCustomWebList(DNS_PF.getNav_DNS_ZoneNameDropdownArrow(), sULElement, sZoneName, 1);
					
					//Clicking on Text tab and verifying the zone data
					clickTextTabAndVerifyData(sZoneName);
					
					//Logout from Navigator
					LoginTestCase_Old1.nav_Logout();
				
				   } catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyZoneNameunderTextTabinDNSPage", "warn", "catch block:" +e.getMessage());
			}
		}
	
	/*==============================================================
	TestScript  	: verifyZoneNameunderMailExchangerTabinDNSPage
	Manual TestCase	: QAT-1411 -WCP_4603_TC_1.4_Alilgning DNS UI New Design- Name field Data display for Mail Exchanger Tab when Name is same as zone name--Verification in Blue Cat
	Description		: verifying the mail exchanger data for the zone name selected  
	Author 			: QAA03
	Creation Date 	: 31/05/2016
	Release Name    : DNS_PF
	Coverage        : First six steps are automated
	Pre-Requisites	:
	Revision History:
	==============================================================*/
		
	@Test(priority=3)
	public void verifyZoneNameunderMailExchangerTabinDNSPage()
	{
					WebDriver driver = WebDriverUtil.getDriver();
				    PageFactory.initElements(driver,DNS_PF);
				    
					String sULElement=null,sZoneName=null;
				
				
				try {
					FrameworkUtil.sTestCaseName = "verifyZoneNameunderMailExchangerTabinDNSPage";
					FrameworkUtil.sManualTestCaseName="QAT-1411 -WCP_4603_TC_1.4_Alilgning DNS UI New Design- Name field Data display for Mail Exchanger Tab when Name is same as zone name--Verification in Blue Cat.";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					
					sULElement = (String)FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
					sZoneName = (String)FrameworkUtil.dictPropertyData.get("NAV.DNS.ZONENAME");
					
					//Login to Navigator with devco1 user
					LoginTestCase_Old1.LoginAsDevcoUser();
					
					//Navigating to DNS Page
					navToDNSPage();
					
					//Selecting the zone name from the drop down
					WebObjectUtil.clickElement(DNS_PF.getNav_DNS_ZoneNameDropdownArrow());
					
					WebObjectUtil.selectCustomWebList(DNS_PF.getNav_DNS_ZoneNameDropdownArrow(), sULElement, sZoneName, 1);
					
					//Clicking on Mail Exchanger tab and verifying the zone data
					clickMailExchangerTabAndVerifyData(sZoneName);
					
					//Logout from Navigator
					LoginTestCase_Old1.nav_Logout();
				
				   } catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyZoneNameunderMailExchangerTabinDNSPage", "warn", "catch block:" +e.getMessage());
			}
		}
	
	/*==============================================================
	TestScript  	: verifyZoneNameunderHostTabinDNSPage
	Manual TestCase	: QAT-1408 WCP_4603_TC_1.3_Alilgning DNS UI New Design- Name field Data display for Host Tab when Name is same as zone name--Verification in Blue Cat
	Description		: verifying the host data for the zone name selected 
	Author 			: QAA03
	Creation Date 	: 31/05/2016
	Release Name    : DNS_PF
	Coverage        : First six steps are automated
	Pre-Requisites	:
	Revision History:
	==============================================================*/
		
	@Test(priority=4)
	public void verifyZoneNameunderHostTabinDNSPage()
	{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver,DNS_PF);
					
					String sULElement=null,sZoneName=null;
				
				
				try {
					FrameworkUtil.sTestCaseName = "verifyZoneNameunderHostTabinDNSPage";
					FrameworkUtil.sManualTestCaseName="QAT-1408 WCP_4603_TC_1.3_Alilgning DNS UI New Design- Name field Data display for Host Tab when Name is same as zone name--Verification in Blue Cat.";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					
					sULElement = (String)FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
					sZoneName = (String)FrameworkUtil.dictPropertyData.get("NAV.DNS.ZONENAME");
					
					//Login to Navigator with devco1 user
					LoginTestCase_Old1.LoginAsDevcoUser();
					
					//Navigating to DNS Page
					navToDNSPage();
					
					//Selecting the zone name from the drop down
					WebObjectUtil.clickElement(DNS_PF.getNav_DNS_ZoneNameDropdownArrow());
					
					WebObjectUtil.selectCustomWebList(DNS_PF.getNav_DNS_ZoneNameDropdownArrow(), sULElement, sZoneName, 1);
					
					//Clicking on Host tab and verifying the zone data
					clickHostTabAndVerifyData(sZoneName);
					
					//Logout from Navigator
					LoginTestCase_Old1.nav_Logout();
				
				   } catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyZoneNameunderHostTabinDNSPage", "warn", "catch block:" +e.getMessage());
			}
		}
	
	
	/// ______________________________ Galen test cases ___________________________________________________ /////
	
	
	/*==============================================================
	TestScript  	: verifyDNSZone
	Manual TestCase	: QAT-1500_WCP_4603_TC_1.2_Alilgning DNS UI New Design- Zone name- data display in Tabs for selected Zones
	Description		: Verify when a ticket is cloned from an existing ticket, 
	                  users that were added to original ticket also appear as 
	                  watchers for this cloned ticket in EM7.
	Author 			: Priyanka
	Creation Date 	: 06/08/2016
	Pre-Requisites	:
	Release Name    : Galen
	Revision History:
	==============================================================*/
	@Test(priority=1)
	public void verifyDNSZone()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Home);
		PageFactory.initElements(driver, DNS_PF);
		
	try {
	int iHostTableRows,iAliasTableRows,iMailExchangerTableRows,iTextTableRows,iSenderPolicyTableRows;
	String sModuleName=(String)FrameworkUtil.dictPropertyData.get("NAV.CREATE.TICKET.RELEASE.NAME");
	String sZoneName=(String)FrameworkUtil.dictPropertyData.get("NAV.CREATE.ZONE.NAME");
	FrameworkUtil.sTestCaseName = "verifyDNSZone";
	FrameworkUtil.sManualTestCaseName="QAT-1500_WCP_4603_TC_1.2_Alilgning DNS UI New Design- Zone name- data display in Tabs for selected Zones";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	//give brief comment - NMR 07/21/2016
	// LoginTestCase.LoginAsQaautoUser();
	LoginTestCase_Old1.LoginAsDevcoUser();
	WebObjectUtil.MouseHover(Home.getNav_ServicesTab());
	WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
	WebObjectUtil.explicitWait(10);
	//WebObjectUtil.clickElement(DNS_PF.getNav_ZoneNameDropdownIcon());
	SelectDropdownVal(sZoneName);
	WebObjectUtil.explicitWait(3);
	iHostTableRows=WebTableUtil.getRowCount(DNS_PF.getNav_ZoneNameHostTable());
	WebObjectUtil.clickElement(DNS_PF.getNav_DNSAliasTab());
	WebObjectUtil.explicitWait(5);
	if(iHostTableRows!=0)
		FrameworkUtil.updateCustomResultBasedOnStatus(true, "All"+iHostTableRows+" Rows are displayed");
    else
    FrameworkUtil.updateCustomResultBasedOnStatus(false, "Please check manually HostTable rows are missing");
    iAliasTableRows=WebTableUtil.getRowCount(DNS_PF.getNav_ZoneNameAliasTable());
	WebObjectUtil.clickElement(DNS_PF.getNav_DNSMailExchangerTab());
	WebObjectUtil.explicitWait(5);
	if(iAliasTableRows!=0)
		FrameworkUtil.updateCustomResultBasedOnStatus(true, "All"+iAliasTableRows+" Rows are displayed");
    else
        FrameworkUtil.updateCustomResultBasedOnStatus(false, "Please check manually Alias Table rows are missing");
	iMailExchangerTableRows=WebTableUtil.getRowCount(DNS_PF.getNav_ZoneNameMailExchangerTable());
	WebObjectUtil.clickElement(DNS_PF.getNav_DNSTextTab());
	WebObjectUtil.explicitWait(5);
	if(iMailExchangerTableRows!=0)
		FrameworkUtil.updateCustomResultBasedOnStatus(true, "All"+iMailExchangerTableRows+" Rows are displayed");
    else
        FrameworkUtil.updateCustomResultBasedOnStatus(false, "Please check manually Mail Exchanger Table rows are missing");

	iTextTableRows=WebTableUtil.getRowCount(DNS_PF.getNav_ZoneNameMailTextTable());
	WebObjectUtil.clickElement(DNS_PF.getNav_DNSSenderPolicyTab());
	WebObjectUtil.explicitWait(5);
	iSenderPolicyTableRows=WebTableUtil.getRowCount(DNS_PF.getNav_ZoneNameMailSenderPolicyTable());
	if(iSenderPolicyTableRows!=0)
		FrameworkUtil.updateCustomResultBasedOnStatus(true, "All"+iSenderPolicyTableRows+" Rows are displayed");
    else
        FrameworkUtil.updateCustomResultBasedOnStatus(false, "Please check manually Sender Policy Table rows are missing");

	//give brief comment - NMR 07/21/2016  
	LoginTestCase_Old1.nav_Logout();
	}
	
	catch (Exception e) {
				LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
	
	}
	}
	/*==============================================================
	TestScript  	: verifyDNSZoneDropdown()
	Manual TestCase	: QAT1497_WCP_4603_TC_1.2_Alilgning DNS UI New Design- Zone name drop down
	Description		: Verify when a ticket is cloned from an existing ticket, 
	                  users that were added to original ticket also appear as 
	                  watchers for this cloned ticket in EM7.
	Author 			: Priyanka
	Creation Date 	: 06/08/2016
	Pre-Requisites	:
	Release Name    : Galen
	Revision History:
	==============================================================*/
	@Test(priority=2)
	public void verifyDNSZoneDropdown()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Home);
		PageFactory.initElements(driver, DNS_PF);
		
	try {
	String sDropDownItems, sActualDropDownItems,sUlXpath;
	WebElement wDNSZoneNameDropDownList;
	sDropDownItems=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.ZONE.NAME.DROPDOWN.VALUES");
	FrameworkUtil.sTestCaseName = "verifyDNSZoneDropdown()";
	FrameworkUtil.sManualTestCaseName="QAT1497_WCP_4603_TC_1.2_Alilgning DNS UI New Design- Zone name drop down";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		//give brief comment - NMR 07/21/2016
		// LoginTestCase.LoginAsQaautoUser();
		LoginTestCase_Old1.LoginAsDevcoUser();
	    WebObjectUtil.clickElement(Home.getNav_ServicesTab());
	    WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
	    WebObjectUtil.explicitWait(10);
	    WebObjectUtil.clickElement(DNS_PF.getNav_ZoneNameDropdownIcon());
	    WebObjectUtil.explicitWait(3);
	  //give brief comment - NMR 07/21/2016
	    wDNSZoneNameDropDownList = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "CUSTOM.WEBLIST.XPATH", "", "");
	    WebObjectUtil.verifyElementPresent(wDNSZoneNameDropDownList);
	    sActualDropDownItems=WebObjectUtil.getCustomWebListItems(wDNSZoneNameDropDownList);
	    WebObjectUtil.explicitWait(5);
	    verifyingDNSZoneDropDownItems(sDropDownItems,sActualDropDownItems);
	  //Logout from Navigator
		LoginTestCase_Old1.nav_Logout();
	}
	
	catch (Exception e) {
				LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
	}
	}
	/*==============================================================
	TestScript  	: verifyDNSSenderPolicyTab()
	Manual TestCase	: QAT1493_WCP_4603_TC_1.10_Alilgning DNS UI New Design- TTL(secs) Data display for Sender Policy Tab
	Description		: Verify that data is displayed in TTL(secs) column for Sender Policy tab 
	Author 			: Priyanka
	Creation Date 	: 06/08/2016
	Pre-Requisites	:
	Release Name    : Galen
	Revision History:
	==============================================================*/
	@Test(priority=3)
	public void verifyDNSSenderPolicyTab()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Home);
		PageFactory.initElements(driver, DNS_PF);
		
		try {
			String[] arrString = null;
			String sHeaderItems, sActualHeaderItems,sTableText,sSeconds;
			String sZoneName=(String)FrameworkUtil.dictPropertyData.get("NAV.CREATE.ZONE.NAME");
			boolean bStatus;
			sHeaderItems=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.ZONE.NAME.HEADER.VALUES");
	sSeconds=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.SENDER.POLICY.TTL.VALUE");
	FrameworkUtil.sTestCaseName = "verifyDNSSenderPolicyTab()";
	FrameworkUtil.sManualTestCaseName="QAT1493_WCP_4603_TC_1.10_Alilgning DNS UI New Design- TTL(secs) Data display for Sender Policy Tab";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		//give brief comment - NMR 07/21/2016
		// LoginTestCase.LoginAsQaautoUser();
	LoginTestCase_Old1.LoginAsDevcoUser();
	WebObjectUtil.MouseHover(Home.getNav_ServicesTab());
	WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
	WebObjectUtil.explicitWait(10);
	
	SelectDropdownVal(sZoneName);
	WebObjectUtil.explicitWait(8);
	WebObjectUtil.clickElement(DNS_PF.getNav_DNSSenderPolicyTab());
	WebObjectUtil.explicitWait(5);
	arrString=sHeaderItems.split("@@");
	sActualHeaderItems=DNS_PF.getNav_SenderPolicyColumnHeader().getText();
	// this below line is updated by NMR - 07/18/2016
		for (int i=0; i<=(arrString.length)-1; i++){
	//for (int i=0; i<=arrString.length; i++){
		if (sActualHeaderItems.contains(arrString[i])){
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "Value is Present", "pass", "Header String Verified: " + arrString[i]);
		
		bStatus=true;
	}
	else{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "value is not present", "warn", "Header String Not Present/Verified: " + arrString[i] );
		}
	}
	sTableText=DNS_PF.getNav_ZoneNameMailSenderPolicyTable().getText();
	if (sTableText.contains(sSeconds)){
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Seconds" , "Value is Present", "pass", "Header String Verified: " + sSeconds);
		
	}
	else{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Seconds" , "value is not present", "warn", "Header String Not Present/Verified: " +sSeconds );
		}
	//give brief comment - NMR 07/21/2016
	//Logout from Navigator
	LoginTestCase_Old1.nav_Logout();
	}
	
	
	catch (Exception e) {
				LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
	}
	}
	
	
	/*==============================================================
	TestScript  	: verifyDNSTextTab()
	Manual TestCase	: QAT1492_WCP_4603_TC_1.10_Alilgning DNS UI New Design- TTL(secs) Data display for Text Tab
	Description		: Verify that data is displayed in TTL(secs) column for Text tab 
	Author 			: Priyanka
	Creation Date 	: 06/08/2016
	Pre-Requisites	:
	Release Name    : Galen
	Revision History:
	==============================================================*/
	@Test(priority=4)
	public void verifyDNSTextTab()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Home);
		PageFactory.initElements(driver, DNS_PF);
		
		try {
			String[] arrString = null;
			String sHeaderItems, sActualHeaderItems,sTableText,sSeconds,sDropdownVal;
			boolean bStatus;
			sHeaderItems=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.ZONE.NAME.HEADER.VALUES");
			sDropdownVal=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.ZONE1INFOBLOX");
	sSeconds=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.SENDER.POLICY.TTL.VALUE");
	FrameworkUtil.sTestCaseName = "verifyDNSSTextTab()";
	FrameworkUtil.sManualTestCaseName="QAT1492_WCP_4603_TC_1.10_Alilgning DNS UI New Design- TTL(secs) Data display for Text Tab";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		//give brief comment - NMR 07/21/2016
		// LoginTestCase.LoginAsQaautoUser();
	LoginTestCase_Old1.LoginAsDevcoUser();
	WebObjectUtil.MouseHover(Home.getNav_ServicesTab());
	WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
	WebObjectUtil.explicitWait(10);
	//WebObjectUtil.clickElement(DNS_PF.getNav_ZoneNameDropdownIcon());
	//WebObjectUtil.explicitWait(10);
	//SelectDropdownVal(sDropdownVal);
	SelectDropdownVal(sDropdownVal);
	WebObjectUtil.explicitWait(8);
	WebObjectUtil.clickElement(DNS_PF.getNav_DNSTextTab());
	WebObjectUtil.explicitWait(5);
	arrString=sHeaderItems.split("@@");
	sActualHeaderItems=DNS_PF.getNav_TextColumnHeader().getText();
	// this below line is updated by NMR - 07/18/2016
	for (int i=0; i<=(arrString.length)-1; i++){
	//for (int i=0; i<=arrString.length; i++){
		if (sActualHeaderItems.contains(arrString[i])){
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "Value is Present", "pass", "Header String Verified: " + arrString[i]);
		
		bStatus=true;
	}
	else{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "value is not present", "warn", "Header String Not Present/Verified: " + arrString[i] );
		}
	}
		WebObjectUtil.explicitWait(5);
		// this below line is updated by NMR - 07/18/2016
		sTableText=DNS_PF.getNav_ZoneNameMailTextTable().getText();
		//sTableText=DNS_PF.getNav_ZoneNameMailTextTable().getText();
	if (sTableText.contains(sSeconds)){
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Seconds" , "Value is Present", "pass", "Header String Verified: " + sSeconds);
		
	}
	else{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Seconds" , "value is not present", "warn", "Header String Not Present/Verified: " +sSeconds );
		}
	//give brief comment - NMR 07/21/2016
	//Logout from Navigator
	LoginTestCase_Old1.nav_Logout();
	}
	
	
	catch (Exception e) {
				LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
	}
	}
	
	/*==============================================================
	TestScript  	: verifyMailExchangerTab()
	Manual TestCase	: QAT1491_WCP_4603_TC_1.10_Alilgning DNS UI New Design- TTL(secs) Data display for Mail Exchanger Tab
	Description		: Verify that data is displayed in TTL(secs) column for Text tab 
	Author 			: Priyanka
	Creation Date 	: 06/08/2016
	Pre-Requisites	:
	Release Name    : Galen
	Revision History:
	==============================================================*/
	@Test(priority=5)
	public void verifyMailExchangerTab()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Home);
		PageFactory.initElements(driver, DNS_PF);
		
		try {
			String[] arrString = null;
			String sHeaderItems, sActualHeaderItems,sTableText,sSeconds;
			boolean bStatus;
			sHeaderItems=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.ZONE.NAME.HEADER.VALUES");
			String sDropdownVal=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.ZONE1INFOBLOX");
	sSeconds=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.SENDER.POLICY.TTL.VALUE");
	FrameworkUtil.sTestCaseName = "verifyMailExchangerTab()";
	FrameworkUtil.sManualTestCaseName="QAT1491_WCP_4603_TC_1.10_Alilgning DNS UI New Design- TTL(secs) Data display for Mail Exchanger Tab";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		//give brief comment - NMR 07/21/2016
		// LoginTestCase.LoginAsQaautoUser();
	LoginTestCase_Old1.LoginAsDevcoUser();
	WebObjectUtil.MouseHover(Home.getNav_ServicesTab());
	WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
	WebObjectUtil.explicitWait(10);
	//give brief comment - NMR 07/21/2016
	//WebObjectUtil.clickElement(DNS_PF.getNav_ZoneNameDropdownIcon());
	//WebObjectUtil.explicitWait(10);
	SelectDropdownVal(sDropdownVal);
	WebObjectUtil.explicitWait(8);
	WebObjectUtil.clickElement(DNS_PF.getNav_DNSMailExchangerTab());
	WebObjectUtil.explicitWait(5);
	arrString=sHeaderItems.split("@@");
	sActualHeaderItems=DNS_PF.getNav_MailExchangerColumnHeader().getText();
	// this below line is updated by NMR - 07/18/2016
	for (int i=0; i<=(arrString.length)-1; i++){
	//for (int i=0; i<=arrString.length; i++){
		if (sActualHeaderItems.contains(arrString[i])){
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "Value is Present", "pass", "Header String Verified: " + arrString[i]);
	}
	else{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "value is not present", "warn", "Header String Not Present/Verified: " + arrString[i] );
		}
	}
	WebObjectUtil.explicitWait(5);
	sTableText=DNS_PF.getNav_ZoneNameMailExchangerTable().getText();
	if (sTableText.contains(sSeconds)){
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Seconds" , "Value is Present", "pass", "Header String Verified: " + sSeconds);
	}
	else{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Seconds" , "value is not present", "warn", "Header String Not Present/Verified: " +sSeconds );
		}
	}
	
	
	catch (Exception e) {
				LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
	}
		//Logout from Navigator
		LoginTestCase_Old1.nav_Logout();
	}
	
	
	/*==============================================================
	TestScript  	: verifyAliasTab()
	Manual TestCase	: QAT1490_WCP_4603_TC_1.10_Alilgning DNS UI New Design- TTL(secs) Data display for Alias Tab
	Description		: Verify that data is displayed in TTL(secs) column for Alias tab 
	Author 			: Priyanka
	Creation Date 	: 06/08/2016
	Pre-Requisites	:
	Release Name    : Galen
	Revision History:
	==============================================================*/
	@Test(priority=6)
	public void verifyAliasTab()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Home);
		PageFactory.initElements(driver, DNS_PF);
		
		try {
			String[] arrString = null;
			String sHeaderItems, sActualHeaderItems,sTableText,sSeconds;
			boolean bStatus;
			String sDropdownVal=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.ZONE1INFOBLOX");
			sHeaderItems=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.ZONE.NAME.HEADER.VALUES");
	sSeconds=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.SENDER.POLICY.TTL.VALUE");
	FrameworkUtil.sTestCaseName = "verifyAliasTab()";
	FrameworkUtil.sManualTestCaseName="QAT1490_WCP_4603_TC_1.10_Alilgning DNS UI New Design- TTL(secs) Data display for Alias Tab";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		//give brief comment - NMR 07/21/2016
		// LoginTestCase.LoginAsQaautoUser();
	LoginTestCase_Old1.LoginAsDevcoUser();
	WebObjectUtil.MouseHover(Home.getNav_ServicesTab());
	WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
	WebObjectUtil.explicitWait(10);
	//WebObjectUtil.clickElement(DNS_PF.getNav_ZoneNameDropdownIcon());
	//WebObjectUtil.explicitWait(10);
	SelectDropdownVal(sDropdownVal);
	WebObjectUtil.explicitWait(8);
	WebObjectUtil.clickElement(DNS_PF.getNav_DNSAliasTab());
	WebObjectUtil.explicitWait(5);
	arrString=sHeaderItems.split("@@");
	//give brief comment - NMR 07/21/2016
	sActualHeaderItems=DNS_PF.getNav_AliasColumnHeader().getText();
	// this below line is updated by NMR - 07/18/2016
	for (int i=0; i<=(arrString.length)-1; i++){
	//	for (int i=1; i<=arrString.length; i++){
		if (sActualHeaderItems.contains(arrString[i])){
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "Value is Present", "pass", "Header String Verified: " + arrString[i]);
	}
	else{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "value is not present", "warn", "Header String Not Present/Verified: " + arrString[i] );
		}
	}
	WebObjectUtil.explicitWait(5);
	// this below line is updated by NMR - 07/18/2016
	sTableText=DNS_PF.getNav_ZoneNameAliasTable().getText();
	//sTableText=DNS_PF.getNav_ZoneNameMailExchangerTable().getText();
	if (sTableText.contains(sSeconds)){
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Seconds" , "Value is Present", "pass", "Header String Verified: " + sSeconds);
	}
	else{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Seconds" , "value is not present", "warn", "Header String Not Present/Verified: " +sSeconds );
		}
	//Logout from Navigator
	LoginTestCase_Old1.nav_Logout();
	}
	
	
	catch (Exception e) {
				LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
				}
	}
	/*==============================================================
	TestScript  	: verifyDNSFileds
	Manual TestCase	: QAT1488_WCP_4603_TC_1.1_Alilgning DNS UI New Design-Data display for Sender Policy Tab
	Description		: Verify that data is displayed under Sender Policy Tab on DNS page
	Author 			: Priyanka
	Creation Date 	: 06/08/2016
	Pre-Requisites	:
	Release Name    : Galen
	Revision History:
	==============================================================*/
	@Test(priority=7)
	public void verifyDNSFileds()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Home);
		PageFactory.initElements(driver, DNS_PF);
		
		try {
			int iRowCount;
			String[] arrString = null;
			WebElement wColumnName=WebObjectUtil.getWebElementFromDynamicLocator("xpath","DNS.SENDERPOLICY.FIRST.COLUMN.NAME","","");
	WebElement wFirstRowElement=WebObjectUtil.getWebElementFromDynamicLocator("xpath","DNS.SENDERPOLICY.FIRST.ROW.NAME","","");
	String sHeaderItems, sActualHeaderItems,sTableText,sSeconds;
	boolean bStatus;
	int iRowLength;
	sHeaderItems=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.ZONE.NAME.HEADER.VALUES");
	sSeconds=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.SENDER.POLICY.TTL.VALUE");
	FrameworkUtil.sTestCaseName = "verifyDNSFileds";
	FrameworkUtil.sManualTestCaseName="QAT1488_WCP_4603_TC_1.1_Alilgning DNS UI New Design-Data display for Sender Policy Tab";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		//give brief comment - NMR 07/21/2016
		//LoginTestCase.LoginAsQaautoUser();
	LoginTestCase_Old1.LoginAsDevcoUser();
	WebObjectUtil.MouseHover(Home.getNav_ServicesTab());
	WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
	WebObjectUtil.explicitWait(10);
	WebObjectUtil.clickElement(DNS_PF.getNav_ZoneNameDropdownIcon());
	WebObjectUtil.explicitWait(3);
	//WebObjectUtil.verifyElementPresent(DNS_PF.getNav_ZoneNameDropdownList());
	WebElement wDNSZoneNameDropDownList = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "CUSTOM.WEBLIST.XPATH", "", "");
	WebObjectUtil.verifyElementPresent(wDNSZoneNameDropDownList);
	WebObjectUtil.clickElement(DNS_PF.getNav_ZoneNameDropdownIcon());
	WebObjectUtil.explicitWait(3);
	WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNSHostTab());
	WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNSPdfIcon());
	WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNSCsvIcon());
	WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNSAliasTab());
	WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNSMailExchangerTab());
	WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNSTextTab());
	WebObjectUtil.clickElement(DNS_PF.getNav_DNSSenderPolicyTab());
	iRowLength=WebTableUtil.getRowCount(DNS_PF.getNav_ZoneNameMailSenderPolicyTable());
	WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNSSenderPolicyTab());
	sActualHeaderItems=DNS_PF.getNav_SenderPolicyColumnHeader().getText();
	// this below line is updated by NMR - 07/18/2016
		WebObjectUtil.explicitWait(5);
		arrString=sHeaderItems.split("@@");
	// this below line is updated by NMR - 07/18/2016
		for (int i=0; i<=(arrString.length)-1; i++){
	//for (int i=0; i<=arrString.length; i++){
		if (sActualHeaderItems.contains(arrString[i])){
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "Value is Present", "pass", "Header String Verified: " + arrString[i]);
	}
	else{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "value is not present", "warn", "Header String Not Present/Verified: " + arrString[i] );
				}
	        }
			WebObjectUtil.explicitWait(3);
	       NavigatorCommonMethods.verifyColumnSort(wColumnName,wFirstRowElement,iRowLength);
	     //Logout from Navigator
			LoginTestCase_Old1.nav_Logout();
		}
	
	catch (Exception e) {
		LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
	}
	       }
	
	/*==============================================================
	TestScript  	: verifyTextTabFileds
	Manual TestCase	: QAT1487_WCP_4603_TC_1.1_Alilgning DNS UI New Design-Data display for Text Tab
	Description		:Verify that data is displayed under Text Tab on DNS page
	Author 			: Priyanka
	Creation Date 	: 06/08/2016
	Pre-Requisites	:
	Release Name    : Galen
	Revision History:
	==============================================================*/
	@Test(priority=8)
	public void verifyTextTabFileds()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Home);
		PageFactory.initElements(driver, DNS_PF);
		
		try {
			int iRowCount;
			String[] arrString = null;
			WebElement wDNSZoneNameDropDownList;
			WebElement wColumnName=WebObjectUtil.getWebElementFromDynamicLocator("xpath","DNS.SENDERPOLICY.FIRST.COLUMN.NAME","","");
	WebElement wFirstRowElement=WebObjectUtil.getWebElementFromDynamicLocator("xpath","DNS.SENDERPOLICY.FIRST.ROW.NAME","","");
	String sHeaderItems, sActualHeaderItems,sTableText,sSeconds;
	boolean bStatus;
	int iRowLength;
	sHeaderItems=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.ZONE.NAME.HEADER.VALUES");
	sSeconds=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.SENDER.POLICY.TTL.VALUE");
	FrameworkUtil.sTestCaseName = "verifyTextTabFileds";
	FrameworkUtil.sManualTestCaseName="QAT1487_WCP_4603_TC_1.1_Alilgning DNS UI New Design-Data display for Text Tab";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	//give brief comment - NMR 07/21/2016
	//LoginTestCase.LoginAsQaautoUser();
	LoginTestCase_Old1.LoginAsDevcoUser();
	WebObjectUtil.MouseHover(Home.getNav_ServicesTab());
	WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
	WebObjectUtil.explicitWait(10);
	WebObjectUtil.clickElement(DNS_PF.getNav_ZoneNameDropdownIcon());
	WebObjectUtil.explicitWait(3);
	wDNSZoneNameDropDownList = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "CUSTOM.WEBLIST.XPATH", "", "");
	WebObjectUtil.verifyElementPresent(wDNSZoneNameDropDownList);
	WebObjectUtil.explicitWait(5);
	/*sActualDropDownItems=WebObjectUtil.getCustomWebListItems(wDNSZoneNameDropDownList);
	WebObjectUtil.explicitWait(5);
	verifyingDNSZoneDropDownItems(sDropDownItems,sActualDropDownItems);*/
	//WebObjectUtil.verifyElementPresent(DNS_PF.getNav_ZoneNameDropdownList());
	//give brief comment - NMR 07/21/2016
	WebObjectUtil.clickElement(DNS_PF.getNav_ZoneNameDropdownIcon());
	WebObjectUtil.explicitWait(3);
	WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNSHostTab());
	WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNSPdfIcon());
	WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNSCsvIcon());
	WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNSAliasTab());
	WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNSMailExchangerTab());
	WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNSSenderPolicyTab());
	WebObjectUtil.clickElement(DNS_PF.getNav_DNSTextTab());
	iRowLength=WebTableUtil.getRowCount(DNS_PF.getNav_ZoneNameMailTextTable());
	 wDNSZoneNameDropDownList = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "CUSTOM.WEBLIST.XPATH", "", "");
	WebObjectUtil.verifyElementPresent(wDNSZoneNameDropDownList);
	sActualHeaderItems=DNS_PF.getNav_TextColumnHeader().getText();
	// this below line is updated by NMR - 07/18/2016
		WebObjectUtil.explicitWait(5);
		arrString=sHeaderItems.split("@@");
	// this below line is updated by NMR - 07/18/2016
		for (int i=0; i<=(arrString.length)-1; i++){ 
	//for (int i=0; i<=arrString.length; i++){
		if (sActualHeaderItems.contains(arrString[i])){
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "Value is Present", "pass", "Header String Verified: " + arrString[i]);
	}
	else{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "value is not present", "warn", "Header String Not Present/Verified: " + arrString[i] );
				}
	        }
			WebObjectUtil.explicitWait(3);
	       NavigatorCommonMethods.verifyColumnSort(wColumnName,wFirstRowElement,iRowLength);
	     //Logout from Navigator
			LoginTestCase_Old1.nav_Logout();  
		}
	
	catch (Exception e) {
		LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
	}
	       }			
	
	/*==============================================================
	TestScript  	: verifyAliasTabFileds
	Manual TestCase	: QAT1486_WCP_4603_TC_1.1_Alilgning DNS UI New Design-Data display for Alias Tab
	Description		:Verify that data is displayed under Alias Tab on DNS page
	Author 			: Priyanka
	Creation Date 	: 06/08/2016
	Pre-Requisites	:
	Release Name    : Galen
	Revision History:
	==============================================================*/
	@Test(priority=9)
	public void verifyAliasTabFileds()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Home);
		PageFactory.initElements(driver, DNS_PF);
		
		try {
			int iRowCount;
			String[] arrString = null;
			WebElement wColumnName=WebObjectUtil.getWebElementFromDynamicLocator("xpath","DNS.SENDERPOLICY.FIRST.COLUMN.NAME","","");
	WebElement wFirstRowElement=WebObjectUtil.getWebElementFromDynamicLocator("xpath","DNS.SENDERPOLICY.FIRST.ROW.NAME","","");
	String sHeaderItems, sActualHeaderItems,sTableText,sSeconds;
	boolean bStatus;
	int iRowLength;
	sHeaderItems=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.ZONE.NAME.HEADER.VALUES");
	sSeconds=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.SENDER.POLICY.TTL.VALUE");
	FrameworkUtil.sTestCaseName = "verifyAliasTabFileds";
	FrameworkUtil.sManualTestCaseName="QAT1486_WCP_4603_TC_1.1_Alilgning DNS UI New Design-Data display for Alias Tab";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		//give brief comment - NMR 07/21/2016
		//LoginTestCase.LoginAsQaautoUser();
	LoginTestCase_Old1.LoginAsDevcoUser();
	WebObjectUtil.MouseHover(Home.getNav_ServicesTab());
	WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
	WebObjectUtil.explicitWait(10);
	WebObjectUtil.clickElement(DNS_PF.getNav_ZoneNameDropdownIcon());
	WebObjectUtil.explicitWait(3);
	WebElement wDNSZoneNameDropDownList = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "CUSTOM.WEBLIST.XPATH", "", "");
	WebObjectUtil.verifyElementPresent(wDNSZoneNameDropDownList);
	WebObjectUtil.clickElement(DNS_PF.getNav_ZoneNameDropdownIcon());
	WebObjectUtil.explicitWait(3);
	WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNSHostTab());
	WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNSPdfIcon());
	WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNSCsvIcon());
	WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNSTextTab());
	WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNSMailExchangerTab());
	WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNSSenderPolicyTab());
	WebObjectUtil.clickElement(DNS_PF.getNav_DNSAliasTab());
	iRowLength=WebTableUtil.getRowCount(DNS_PF.getNav_ZoneNameAliasTable());
	WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNSAliasTab());
	sActualHeaderItems=DNS_PF.getNav_AliasColumnHeader().getText();
	// this below line is updated by NMR - 07/18/2016
		WebObjectUtil.explicitWait(5);
		arrString=sHeaderItems.split("@@");
	// this below line is updated by NMR - 07/18/2016
		for (int i=0; i<=(arrString.length)-1; i++){
	//for (int i=0; i<=arrString.length; i++){
		if (sActualHeaderItems.contains(arrString[i])){
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "Value is Present", "pass", "Header String Verified: " + arrString[i]);
	}
	else{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "value is not present", "warn", "Header String Not Present/Verified: " + arrString[i] );
				}
	        }
			WebObjectUtil.explicitWait(3);
	       NavigatorCommonMethods.verifyColumnSort(wColumnName,wFirstRowElement,iRowLength);
	     //Logout from Navigator
			LoginTestCase_Old1.nav_Logout();  
		}
	
	catch (Exception e) {
		LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
	}
	       }	
	
	/*==============================================================
	TestScript  	: verifyMailExchangerTabFileds
	Manual TestCase	: QAT1485_WCP_4603_TC_1.1_Alilgning DNS UI New Design-Data display for Mail Exchanger Tab
	Description		: Verify that data is displayed under Mail Exchanger Tab on DNS page
	Author 			: Priyanka
	Creation Date 	: 06/08/2016
	Pre-Requisites	:
	Release Name    : Galen
	Revision History:
	==============================================================*/
	@Test(priority=10)
	public void verifyMailExchangerTabFileds()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Home);
		PageFactory.initElements(driver, DNS_PF);
		
		try {
			int iRowCount;
			String[] arrString = null;
			WebElement wColumnName=WebObjectUtil.getWebElementFromDynamicLocator("xpath","DNS.SENDERPOLICY.FIRST.COLUMN.NAME","","");
	WebElement wFirstRowElement=WebObjectUtil.getWebElementFromDynamicLocator("xpath","DNS.SENDERPOLICY.FIRST.ROW.NAME","","");
	String sHeaderItems, sActualHeaderItems,sTableText,sSeconds;
	boolean bStatus;
	int iRowLength;
	sHeaderItems=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.ZONE.NAME.HEADER.VALUES");
	sSeconds=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.SENDER.POLICY.TTL.VALUE");
	FrameworkUtil.sTestCaseName = "verifyMailExchangerTabFileds";
	FrameworkUtil.sManualTestCaseName="QAT1485_WCP_4603_TC_1.1_Alilgning DNS UI New Design-Data display for Mail Exchanger Tab";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		//give brief comment - NMR 07/21/2016
		//LoginTestCase.LoginAsQaautoUser();
	LoginTestCase_Old1.LoginAsDevcoUser();
	WebObjectUtil.MouseHover(Home.getNav_ServicesTab());
	WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
	WebObjectUtil.explicitWait(10);
	WebObjectUtil.clickElement(DNS_PF.getNav_ZoneNameDropdownIcon());
	WebObjectUtil.explicitWait(10);
	WebElement wDNSZoneNameDropDownList = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "CUSTOM.WEBLIST.XPATH", "", "");
	WebObjectUtil.verifyElementPresent(wDNSZoneNameDropDownList);
	WebObjectUtil.clickElement(DNS_PF.getNav_ZoneNameDropdownIcon());
	WebObjectUtil.explicitWait(3);
	WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNSHostTab());
	WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNSPdfIcon());
	WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNSCsvIcon());
	WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNSTextTab());
	WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNSAliasTab());
	WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNSSenderPolicyTab());
	WebObjectUtil.clickElement(DNS_PF.getNav_DNSMailExchangerTab());
	iRowLength=WebTableUtil.getRowCount(DNS_PF.getNav_ZoneNameMailExchangerTable());
	WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNSMailExchangerTab());
	sActualHeaderItems=DNS_PF.getNav_MailExchangerColumnHeader().getText();
	// this below line is updated by NMR - 07/18/2016
	WebObjectUtil.explicitWait(5);
	arrString=sHeaderItems.split("@@");
	// this below line is updated by NMR - 07/18/2016
		for (int i=0; i<=(arrString.length)-1; i++){
	//for (int i=0; i<=arrString.length; i++){
		if (sActualHeaderItems.contains(arrString[i])){
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "Value is Present", "pass", "Header String Verified: " + arrString[i]);
	}
	else{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "value is not present", "warn", "Header String Not Present/Verified: " + arrString[i] );
				}
	        }
			WebObjectUtil.explicitWait(3);
	       NavigatorCommonMethods.verifyColumnSort(wColumnName,wFirstRowElement,iRowLength);
	     //Logout from Navigator
			LoginTestCase_Old1.nav_Logout();  
		}
	
	catch (Exception e) {
		LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
	}
	       }
	
	/*==============================================================
	TestScript  	: verifyHostTab()
	Manual TestCase	: QAT1417_WCP_4603_TC_1.10_Alilgning DNS UI New Design- TTL(secs) Data display for Host Tab
	Description		: Verify that data is displayed in TTL(secs) column for Host tab 
	Author 			: Priyanka
	Creation Date 	: 06/08/2016
	Pre-Requisites	:
	Release Name    : Galen
	Revision History:
	==============================================================*/
	@Test(priority=11)
	public void verifyHostTab()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Home);
		PageFactory.initElements(driver, DNS_PF);
		
		try {
			String[] arrString = null;
			String sHeaderItems, sActualHeaderItems,sTableText,sSeconds;
			boolean bStatus;
			String sZoneName=(String)FrameworkUtil.dictPropertyData.get("NAV.CREATE.ZONE.NAME");
			sHeaderItems=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.ZONE.NAME.HEADER.VALUES");
	sSeconds=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.SENDER.POLICY.TTL.VALUE");
	FrameworkUtil.sTestCaseName = "verifyHostTab()";
	FrameworkUtil.sManualTestCaseName="QAT1417_WCP_4603_TC_1.10_Alilgning DNS UI New Design- TTL(secs) Data display for Host Tab";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		//give brief comment - NMR 07/21/2016
		// LoginTestCase.LoginAsQaautoUser();
	LoginTestCase_Old1.LoginAsDevcoUser();
	WebObjectUtil.MouseHover(Home.getNav_ServicesTab());
	WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
	WebObjectUtil.explicitWait(10);
	//WebObjectUtil.clickElement(DNS_PF.getNav_ZoneNameDropdownIcon());
	//WebObjectUtil.explicitWait(10);
	SelectDropdownVal(sZoneName);
	WebObjectUtil.explicitWait(8);
	WebObjectUtil.clickElement(DNS_PF.getNav_DNSHostTab());
	WebObjectUtil.explicitWait(5);
	arrString=sHeaderItems.split("@@");
	sActualHeaderItems=DNS_PF.getNav_HostColumnHeader().getText();
	// this below line is updated by NMR - 07/18/2016
		for (int i=0; i<=(arrString.length)-1; i++){
	//for (int i=0; i<=arrString.length; i++){
		if (sActualHeaderItems.contains(arrString[i])){
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "Value is Present", "pass", "Header String Verified: " + arrString[i]);
		bStatus=true;
	}
	else{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "value is not present", "warn", "Header String Not Present/Verified: " + arrString[i] );
		}
	}
	sTableText=DNS_PF.getNav_ZoneNameHostTable().getText();
	if (sTableText.contains(sSeconds)){
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Seconds" , "Value is Present", "pass", "Header String Verified: " + sSeconds);
		
	}
	else{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Seconds" , "value is not present", "warn", "Header String Not Present/Verified: " +sSeconds );
		}
	//Logout from Navigator
	LoginTestCase_Old1.nav_Logout();
	}
	
	
	catch (Exception e) {
				LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
	}
	}
	
	/*==============================================================
	TestScript  	: verifyHostTabFileds
	Manual TestCase	: QAT1399_WCP_4603_TC_1.1_Alilgning DNS UI New Design-Data display for Host Tab
	Description		: Verify that data is displayed under Host Tab on DNS page
	Author 			: Priyanka
	Creation Date 	: 06/08/2016
	Pre-Requisites	:
	Release Name    : Galen
	Revision History:
	==============================================================*/
	@Test(priority=12)
	public void verifyHostTabFileds()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Home);
		PageFactory.initElements(driver, DNS_PF);
		
		try {
			int iRowCount;
			String sHeaderItems, sActualHeaderItems,sTableText,sSeconds;
			String[] arrString = null;
			WebElement wColumnName=WebObjectUtil.getWebElementFromDynamicLocator("xpath","DNS.SENDERPOLICY.FIRST.COLUMN.NAME","","");
	WebElement wFirstRowElement=WebObjectUtil.getWebElementFromDynamicLocator("xpath","DNS.SENDERPOLICY.FIRST.ROW.NAME","","");
	WebElement wColumnName1=WebObjectUtil.getWebElementFromDynamicLocator("xpath","DNS.SENDERPOLICY.SECOND.COLUMN.NAME","","");
	WebElement wFirstRowElement1=WebObjectUtil.getWebElementFromDynamicLocator("xpath","DNS.SENDERPOLICY.SECOND.ROW.NAME","","");
	WebElement wColumnName2=WebObjectUtil.getWebElementFromDynamicLocator("xpath","DNS.SENDERPOLICY.THIRD.COLUMN.NAME","","");
	WebElement wFirstRowElement2=WebObjectUtil.getWebElementFromDynamicLocator("xpath","DNS.SENDERPOLICY.THIRD.ROW.NAME","","");
	// this below element is added by NMR - 07/18/2016
	sHeaderItems=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.ZONE.NAME.HEADER.VALUES");
	
	boolean bStatus;
	int iRowLength;
	sHeaderItems=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.ZONE.NAME.HEADER.VALUES");
	sSeconds=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.SENDER.POLICY.TTL.VALUE");
	FrameworkUtil.sTestCaseName = "verifyHostTabFileds";
	FrameworkUtil.sManualTestCaseName="QAT1399_WCP_4603_TC_1.1_Alilgning DNS UI New Design-Data display for Host Tab";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		//give brief comment - NMR 07/21/2016
		//LoginTestCase.LoginAsQaautoUser();
	LoginTestCase_Old1.LoginAsDevcoUser();
	WebObjectUtil.MouseHover(Home.getNav_ServicesTab());
	WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
	WebObjectUtil.explicitWait(10);
	WebObjectUtil.clickElement(DNS_PF.getNav_ZoneNameDropdownIcon());
	WebObjectUtil.explicitWait(3);
	WebElement wDNSZoneNameDropDownList = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "CUSTOM.WEBLIST.XPATH", "", "");
	WebObjectUtil.verifyElementPresent(wDNSZoneNameDropDownList);
	WebObjectUtil.clickElement(DNS_PF.getNav_ZoneNameDropdownIcon());
	WebObjectUtil.explicitWait(3);
	WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNSHostTab());
	WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNSPdfIcon());
	WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNSCsvIcon());
	WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNSAliasTab());
	WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNSMailExchangerTab());
	WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNSSenderPolicyTab());
	WebObjectUtil.clickElement(DNS_PF.getNav_DNSHostTab());
	iRowLength=WebTableUtil.getRowCount(DNS_PF.getNav_ZoneNameHostTable());
	WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNSHostTab());
	// this below line is updated by NMR - 07/18/2016
	arrString=sHeaderItems.split("@@");
	WebObjectUtil.explicitWait(3);
	sActualHeaderItems=DNS_PF.getNav_HostColumnHeader().getText();
	// this below line is updated by NMR - 07/18/2016
		for (int i=0; i<=(arrString.length)-1; i++){
	//for (int i=0; i<=arrString.length; i++){
		if (sActualHeaderItems.contains(arrString[i])){
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "Value is Present", "pass", "Header String Verified: " + arrString[i]);
	}
	else{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "value is not present", "warn", "Header String Not Present/Verified: " + arrString[i] );
				}
	        }
			WebObjectUtil.explicitWait(3);
			NavigatorCommonMethods.verifyColumnSort(wColumnName,wFirstRowElement,iRowLength);
			NavigatorCommonMethods.verifyColumnNotSorted(wColumnName1,wFirstRowElement1,iRowLength);
	       NavigatorCommonMethods.verifyColumnNotSorted(wColumnName2,wFirstRowElement2,iRowLength);
	       LoginTestCase_Old1.nav_Logout(); 
		}
	
	catch (Exception e) {
	LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
	}
	       }
	

	//// __________________________ Completed galen test cases ____________________________________________ ///
	
	
	////__________________________________Takashima TestCases______________________________________________ ///
	
	/*==============================================================
	TestScript  	: verifyAllTabsDataDisplayedZone()
	Manual TestCase	: QAT-1596-WCP_5223_TC_1.1_Convert DNS Services to Infoblox
	Description		: Verify that when an org does not have data in Infoblox, it displays data from Bluecat on Navigator . 
	Author 			: Priyanka R
	Creation Date 	: 07/12/2016
	Pre-Requisites	: 
	Release         : Takashima
	Revision History: Only Navigator part is automated 
	==============================================================*/
	@Test(priority=1)
	public void verifyAllTabsDataDisplayedZone()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, DNS_PF);
		PageFactory.initElements(driver, Home);
		try{
	String sActualDropDownItems,sNewZone,sZoneName;
	FrameworkUtil.sTestCaseName = "DNS-verifyAllTabsDataDisplayedZone";
	FrameworkUtil.sManualTestCaseName="QAT-1596-WCP_5223_TC_1.1_Convert DNS Services to Infoblox";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	sZoneName=(String)FrameworkUtil.dictPropertyData.get("NAV.SELECT.NEW.ZONE.NAME");
	//Login to Navigator Portlet
	
	LoginTestCase_Old1.LoginAsPuppyloveUser();
	
	
	//WebObjectUtil.MouseHover(Home.getNav_ServicesTab());
	WebObjectUtil.clickElement(Home.getNav_ServicesTab());
	WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
	WebObjectUtil.explicitWait(10);
	//WebObjectUtil.clickElement(DNS_PF.getNav_ZoneNameDropdownIcon());
   //WebObjectUtil.selectCustomWebList(DNS.getNav_ZoneNameDropdownList(),sULElement,sZoneName,2);
	    SelectDropdownVal(sZoneName);
	    VerifyTabsData();
	 
		LoginTestCase_Old1.nav_Logout();
	}
	catch (Exception e) {
		// TODO Auto-generated catch block
	LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAllTabsDataDisplayedZone", "warn", "catch block:" +e.getMessage());  
					}
	}
	
	/*==============================================================
	TestScript  	: verifyAllTabsDataDisplayed()
	Manual TestCase	: QAT-1597-WCP_5223_TC_1.2_Convert DNS Services to Infoblox_Back end Verification
	                  QAT-1594-WCP_5223_TC_1.0_Convert DNS Services to Infoblox
	Description		: Verify the data on Navigator for DNS is matching with the data in InfoBlox for a selected Zone. 
	Author 			: Priyanka R
	Creation Date 	: 07/12/2016
	Pre-Requisites	: 
	Release         : Takashima
	Revision History: Only Navigator part is automated 
	==============================================================*/
	@Test(priority=2)
	public void verifyAllTabsDataDisplayed()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, DNS_PF);
		PageFactory.initElements(driver, Home);
		try{
			String sActualDropDownItems,sNewZone,sZoneName;
		    FrameworkUtil.sTestCaseName = "DNS-verifyAllTabsDataDisplayed";
	FrameworkUtil.sManualTestCaseName="QAT-1597-WCP_5223_TC_1.2_QAT-1594-WCP_5223_TC_1.0";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	sZoneName=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.ZONE1INFOBLOX");
	//Login to Navigator Portlet
		
		LoginTestCase_Old1.LoginAsDevcoUser();
		//Commented below line by QAA03 on 07/20/2016
		
		//WebObjectUtil.MouseHover(Home.getNav_ServicesTab());
		WebObjectUtil.clickElement(Home.getNav_ServicesTab());
		WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
		WebObjectUtil.explicitWait(10);
		//WebObjectUtil.clickElement(DNS_PF.getNav_ZoneNameDropdownIcon());
	  //WebObjectUtil.selectCustomWebList(DNS.getNav_ZoneNameDropdownList(),sULElement,sZoneName,2);
	    SelectDropdownVal(sZoneName);
	    VerifyTabsData();
	 
		LoginTestCase_Old1.nav_Logout();
	}
	catch (Exception e) {
		// TODO Auto-generated catch block
	LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAllTabsDataDisplayed", "warn", "catch block:" +e.getMessage());  
					}
	}
	
	/*==============================================================
	TestScript  	: verifyDnsLink
	Manual TestCase	: QAT-1583-WCP_5644_TC_1.0_DNS page message display when there are no Records for DNS for Org
	Description		: Verify that when there are no DNS records for any org, user is displayed with a message that records are not available. 
	Author 			: Priyanka R
	Creation Date 	: 07/12/2016
	Pre-Requisites	: 
	Release         : Takashima
	Revision History: Only Navigator part is automated 
	==============================================================*/
	@Test(priority=3)
	public void verifyDnsLink()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, DNS_PF);
		PageFactory.initElements(driver, Home);
		try{
	FrameworkUtil.sTestCaseName = "DNS-verifyDnsLink";
	FrameworkUtil.sManualTestCaseName="QAT-1583-WCP_5644_TC_1.0_DNS page message display when there are no Records for DNS for Org";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	String sDNSRecordsMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.NO.RECORDS.AVAILABLE");
	//Login to Navigator Portlet
	LoginTestCase_Old1.LoginAsQaautoAUser();
	//Commented below lines by QAA03 on 07/20/2016
	//WebObjectUtil.explicitWait(5);
	//WebObjectUtil.MouseHover(Home.getNav_ServicesTab());
	WebObjectUtil.clickElement(Home.getNav_ServicesTab());
	WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
	WebObjectUtil.explicitWait(10);
	WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNSRecordsArea());
	String sActualDNSNoteMsg=DNS_PF.getNav_DNSNoRecordsNote().getText().trim();
	if(sDNSRecordsMsg.contains(sActualDNSNoteMsg))
	{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "Value is Present", "pass", "DNS Records Not available Note is displayed " + sActualDNSNoteMsg);
		
	}
	else{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "value is not present", "warn", "Displayed Note:" + sActualDNSNoteMsg );
			}
		LoginTestCase_Old1.nav_Logout();
	}
	catch (Exception e) {
		// TODO Auto-generated catch block
	LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyDnsLink", "warn", "catch block:" +e.getMessage());  
		}
	}

	
	
	/////////////////////////////////////////// METHODS ////////////////////////////////////////////////
	
	/*==============================================================
	Method Name		: VerifyTabsData
	Description		: Verifying values are available from all tabs
	Author 			: Priyanka 
	Creation Date 	: 11/04/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void VerifyTabsData()
		{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, DNS_PF);
		
		int iHostTableRows,iAliasTableRows,iMailExchangerTableRows,iTextTableRows,iSenderPolicyTableRows;
		
		WebObjectUtil.explicitWait(5);
		iHostTableRows=WebTableUtil.getRowCount(DNS_PF.getNav_ZoneNameHostTable());
		WebObjectUtil.clickElement(DNS_PF.getNav_DNSAliasTab());
		WebObjectUtil.explicitWait(5);
		iAliasTableRows=WebTableUtil.getRowCount(DNS_PF.getNav_ZoneNameAliasTable());
		WebObjectUtil.clickElement(DNS_PF.getNav_DNSMailExchangerTab());
		WebObjectUtil.explicitWait(5);
		iMailExchangerTableRows=WebTableUtil.getRowCount(DNS_PF.getNav_ZoneNameMailExchangerTable());
		WebObjectUtil.clickElement(DNS_PF.getNav_DNSTextTab());
		WebObjectUtil.explicitWait(5);
		iTextTableRows=WebTableUtil.getRowCount(DNS_PF.getNav_ZoneNameTextTable());
		WebObjectUtil.clickElement(DNS_PF.getNav_DNSSenderPolicyTab());
		WebObjectUtil.explicitWait(5);
		iSenderPolicyTableRows=WebTableUtil.getRowCount(DNS_PF.getNav_ZoneNameSenderPolicyTable());
		if((iHostTableRows!=0) && (iAliasTableRows!=0) && (iMailExchangerTableRows!=0) && (iTextTableRows!=0) && (iSenderPolicyTableRows!=0))
		{
			FrameworkUtil.updateCustomResultBasedOnStatus(true, "All tables are displayed");
			           }
	else{
		FrameworkUtil.updateCustomResultBasedOnStatus(false, "Please check manually some table rows are missing");
				        }
	
	}
	
	/*==============================================================
	Method Name 	: verifyingDNSZoneDropDownItems
	Description		: This will verify the dropdown items
	Author 			: Priyanka R
	Creation Date 	: 06/13/2016
	Pre-Requisites	:
	Revision History: 
	==============================================================*/
	public static void verifyingDNSZoneDropDownItems(String sDropDownItems, String sActualDropDownItems)
	{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver,DNS_PF);
	
	
	String[] aDropDownItem;
	//sDropDownItems=(String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.SEARCHBY.ITEMS.DROPDOWN");
	//Split the sDropDownItems
	try {
	aDropDownItem=sDropDownItems.split("@@");
	for(String sItem:aDropDownItem)
	{
	//System.out.println(sItem);
	if(sActualDropDownItems.contains(sItem))
	{
	LoggerUtil.log_type_info(sItem +" is present");
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName ,sItem , "pass","Verified");
	}
	else
	{
	LoggerUtil.log_type_error(sItem +" is not present");
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName ,sItem , "fail"," not Verified");
	}
	}
	}
	catch (Exception e) {
		LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
	}
	}
	
	
	/*====================================================================================================
	Method Name 	: navToDNSPage
	Description		: Navigating to DNS Page
	Author 			: QAA03
	Creation Date 	: 05/26/2016
	Pre-Requisites	: 
	Revision History:
	====================================================================================================*/
	public static void navToDNSPage()
	{
		  
						WebDriver driver = WebDriverUtil.getDriver();
						PageFactory.initElements(driver,Smoke);
		              
				 try {
					    //Navigating to DNS Page
						WebObjectUtil.clickElement(Smoke.getNav_ServicesMenu());
						WebObjectUtil.clickAndVerifyElement(Smoke.getNav_DNSSubMenuLink(),Smoke.getNav_DNSHostTab());
						WebObjectUtil.explicitWait(2);
					   
					 } catch (Exception e) {
						// TODO Auto-generated catch block
						LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navToDNSPage", "warn", "catch block:" +e.getMessage());  
					}
				
	}
	
	/*====================================================================================================
	Method Name 	: clickSenderPolicyTabAndVerifyData
	Description		: Clicking on Sender Policy tab and verifying the zone data
	Author 			: QAA03
	Creation Date 	: 05/26/2016
	Pre-Requisites	: 
	Revision History:
	====================================================================================================*/
	public static void clickSenderPolicyTabAndVerifyData(String sZoneName)
	{
		  
						WebDriver driver = WebDriverUtil.getDriver();
						PageFactory.initElements(driver,DNS_PF);
		                int iRowNo=0,iColCount=0;
		                String sCellData=null,sColData=null;
		                List<String> sSenderPolicyRowData =new ArrayList<String>();
		                boolean bZoneStatus;
				 try {
					    WebObjectUtil.clickElement(DNS_PF.getNav_DNS_SenderPolicyTab());
					    
					    //Verifying table columns under sender policy tab
					    WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNS_SenderPolicyNameColumn());
					    WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNS_SenderPolicyDataColumn());
					    WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNS_SenderPolicyTTLColumn());
					    
					    CustomWebElementUtil.loadCustomElement(DNS_PF.getNav_DNS_SenderPolicyWebTableParent(), "table");
					    iRowNo =CustomWebElementUtil.getRowByCellText(sZoneName, 1);
					    
					    //verifying the sender policy table contains the data with the selected zone
					    if(iRowNo>0)
					    {
					    	  iColCount = CustomWebElementUtil.getColumnCount(iRowNo);
					    	  
					         for(int i=1;i<=iColCount;i++)
					         {
					    	        sColData =CustomWebElementUtil.getCellData(iRowNo, i);
					    	        sSenderPolicyRowData.add(sColData);			    
					          }
					         FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Sender Policy Zone Data", "pass", "Sender Policy Data for the selected zone"+sSenderPolicyRowData);
					    }
					    else
					    {
					    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Sender Policy Zone Data", "fail", "No Sender Policy Data is present for the selected zone");
					    }
					    
					   
					 } catch (Exception e) {
						// TODO Auto-generated catch block
						LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "clickSenderPolicyTabAndVerifyData", "warn", "catch block:" +e.getMessage());  
					}
				
	}
	
	/*====================================================================================================
	Method Name 	: clickTextTabAndVerifyData
	Description		: Clicking on Text tab and verifying the zone data
	Author 			: QAA03
	Creation Date 	: 05/27/2016
	Pre-Requisites	: 
	Revision History:
	====================================================================================================*/
	public static void clickTextTabAndVerifyData(String sZoneName)
	{
		  
						WebDriver driver = WebDriverUtil.getDriver();
						PageFactory.initElements(driver,DNS_PF);
		                int iRowNo=0,iColCount=0;
		                String sCellData=null,sColData=null;
		                List<String> sTextRowData =new ArrayList<String>();
		                boolean bZoneStatus;
				 try {
					    WebObjectUtil.clickElement(DNS_PF.getNav_DNS_TextTab());
					    
					   //Verifying table columns under text tab
					    WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNS_TextNameColumn());
					    WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNS_TextDataColumn());
					    WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNS_TextTTLColumn());
					    
					    CustomWebElementUtil.loadCustomElement(DNS_PF.getNav_DNS_TextWebTableParent(), "table");
					    WebObjectUtil.explicitWait(DNS_PF.getNav_DNS_TextWebTableParent());
					    iRowNo =CustomWebElementUtil.getRowByCellText(sZoneName, 1);
					    
					    //verifying the text table contains the data with the selected zone
					    if(iRowNo>0)
					    {
					    	  iColCount = CustomWebElementUtil.getColumnCount(iRowNo);
					    	  
					         for(int i=1;i<=iColCount;i++)
					         {
					    	        sColData =CustomWebElementUtil.getCellData(iRowNo, i);
					    	        sTextRowData.add(sColData);			    
					          }
					         FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Text Zone Data", "pass", "Text Data for the selected zone"+sTextRowData);
					    }
					    else
					    {
					    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Text Zone Data", "warn", "No Text Data is present for the selected zone");
					    }
					    
					   
					 } catch (Exception e) {
						// TODO Auto-generated catch block
						LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "clickTextTabAndVerifyData", "warn", "catch block:" +e.getMessage());  
					}
				
	}
	
	/*====================================================================================================
	Method Name 	: clickMailExchangerTabAndVerifyData
	Description		: Clicking on Mail Exchanger tab and verifying the zone data
	Author 			: QAA03
	Creation Date 	: 05/31/2016
	Pre-Requisites	: 
	Revision History:
	====================================================================================================*/
	public static void clickMailExchangerTabAndVerifyData(String sZoneName)
	{
		  
						WebDriver driver = WebDriverUtil.getDriver();
						PageFactory.initElements(driver,DNS_PF);
						
		                int iRowNo=0,iColCount=0;
		                String sCellData=null,sColData=null;
		                List<String> sMailExchangerRowData =new ArrayList<String>();
		                boolean bZoneStatus;
				 try {
					    WebObjectUtil.clickElement(DNS_PF.getNav_DNS_MailExchangerTab());
					    
					    //Verifying table columns under mail exchanger tab
					    WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNS_MailExchangerNameColumn());
					    WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNS_MailExchangerDataColumn());
					    WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNS_MailExchangerTTLColumn());
					    
					    CustomWebElementUtil.loadCustomElement(DNS_PF.getNav_DNS_MailExchangerWebTableParent(), "table");
					    iRowNo =CustomWebElementUtil.getRowByCellText(sZoneName, 1);
					    
					    //verifying the mail exchanger table contains the data with the selected zone 
					    if(iRowNo>0)
					    {
					    	  iColCount = CustomWebElementUtil.getColumnCount(iRowNo);
					    	  
					         for(int i=1;i<=iColCount;i++)
					         {
					    	        sColData =CustomWebElementUtil.getCellData(iRowNo, i);
					    	        sMailExchangerRowData.add(sColData);			    
					          }
					         FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Mail Exchanger Zone Data", "pass", "Mail Exchanger Data for the selected zone"+sMailExchangerRowData);
					    }
					    else
					    {
					    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Mail Exchanger Zone Data", "fail", "No Mail Exchanger Data is present for the selected zone");
					    }
					    
					   
					 } catch (Exception e) {
						// TODO Auto-generated catch block
						LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "clickMailExchangerTabAndVerifyData", "warn", "catch block:" +e.getMessage());  
					}
				
	}
	
	/*====================================================================================================
	Method Name 	: clickHostTabAndVerifyData
	Description		: Clicking on Host tab and verifying the zone data
	Author 			: QAA03
	Creation Date 	: 05/31/2016
	Pre-Requisites	: 
	Revision History:
	====================================================================================================*/
	public static void clickHostTabAndVerifyData(String sZoneName)
	{
		  
						WebDriver driver = WebDriverUtil.getDriver();
						PageFactory.initElements(driver,DNS_PF);
						PageFactory.initElements(driver,Smoke);
						
		                int iRowNo=0,iColCount=0;
		                String sCellData=null,sColData=null;
		                List<String> sHostRowData =new ArrayList<String>();
		                boolean bZoneStatus;
				 try {
					    WebObjectUtil.clickElement(Smoke.getNav_DNSHostTab());
					    
					    //Verifying table columns under host tab
					    WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNS_HostNameColumn());
					    WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNS_HostDataColumn());
					    WebObjectUtil.verifyElementPresent(DNS_PF.getNav_DNS_HostTTLColumn());
					    
					    CustomWebElementUtil.loadCustomElement(DNS_PF.getNav_DNS_HostWebTableParent(), "table");
					    WebObjectUtil.explicitWait(DNS_PF.getNav_DNS_HostWebTableParent());
					    iRowNo =CustomWebElementUtil.getRowByCellText(sZoneName, 1);
					    
					    //verifying the host table contains the data with the selected zone
					    if(iRowNo>0)
					    {
					    	  iColCount = CustomWebElementUtil.getColumnCount(iRowNo);
					    	  
					         for(int i=1;i<=iColCount;i++)
					         {
					    	        sColData =CustomWebElementUtil.getCellData(iRowNo, i);
					    	        sHostRowData.add(sColData);			    
					          }
					         FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Host Zone Data", "pass", "Host Data for the selected zone"+sHostRowData);
					    }
					    else
					    {
					    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Host Zone Data", "warn", "No Host Data is present for the selected zone");
					    }
					    
					   
					 } catch (Exception e) {
						// TODO Auto-generated catch block
						LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "clickHostTabAndVerifyData", "warn", "catch block:" +e.getMessage());  
					}
				
	}
	/*==============================================================
	Method Name		: SelectDropdownVal
	Description		: Selecting value from dropdown using visible text
	Author 			: Priyanka 
	Creation Date 	: 11/04/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void SelectDropdownVal(String sZoneName)
		{
			WebObjectUtil.clickElement(DNS_PF.getNav_ZoneNameDropdownIcon());
			WebElement wDNSZoneNameDropDownList = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "CUSTOM.WEBLIST.XPATH", "", "");
			
			//WebObjectUtil.explicitWait(10);
			//WebObjectUtil.selectCustomWebList(wDNSZoneNameDropDownList, sZoneName);
			
			List<WebElement> webListItems = wDNSZoneNameDropDownList.findElements(By.tagName("li"));

			for (WebElement wb: webListItems){
				if (wb.getText().equalsIgnoreCase(sZoneName)){
					wb.click();
					WebObjectUtil.explicitWait(5);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Select Item from Custom WebList", "pass", "Item selected: "+ sZoneName);
					break;
				}
			}

		}
	
	//update each @test result in custom result file
    @AfterMethod
    public static void afterEachMethod(){
	FrameworkUtil.updateTestCaseStatusinResult();
	FrameworkUtil.sTestExecutionStatus = true;
	//Startup_debug.quitWebDriver();
      }
	
}
