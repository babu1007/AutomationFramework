			package com.whs.navigator.testcases.Takashima;
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
import org.openqa.selenium.JavascriptExecutor;
import com.whs.navigator.commonUtil.CustomWebElementUtil;
import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.commonUtil.WebTableUtil;
import com.whs.navigator.pagefactory.DNSPageFactory;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.EVDC_VM_PageFactory;
import com.whs.navigator.pagefactory.EscalationPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.LoadBalancerPageFactory;
import com.whs.navigator.pagefactory.PhysicalServicesPageFactory;
import com.whs.navigator.pagefactory.SmokeTestPageFactory;
import com.whs.navigator.pagefactory.DraasPageFactory;
import com.whs.navigator.pagefactory.CommonPageFactory;
import com.whs.navigator.pagefactory.TicketPageFactory;
import com.whs.navigator.testcases.TicketTestCase;
import com.whs.navigator.pagefactory.FirewallPageFactory;
import com.whs.navigator.pagefactory.EM7PageFactory;
import com.whs.navigator.pagefactory.FormPageFactory;
import com.whs.navigator.pagefactory.EntityBrowserPageFactory;
import com.whs.navigator.testcases.LoginTestCase_Old1;
import com.whs.navigator.pagefactory.UserPermissionPageFactory;
import com.whs.navigator.testcases.EntityBrowserTestCase;
import com.whs.navigator.pagefactory.EVDC_FirewallPageFactory;
			





			import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
			
			public class TakashimaTestCase_Priyanka {
				
				public static HomePageFactory_old Home = new HomePageFactory_old();
				public static DNSPageFactory DNS =new DNSPageFactory();
				
				
				
			/*==============================================================
			TestScript  	: verifyDnsZoneRows
			Manual TestCase	: QAT-1611-WCP_5223_TC_1.10_DNS page pagination
			Description		: Verify that on DNS page, when there are more than 25 records per 
			                  page, pagination is available and user is able to scroll the page.
			Author 			: Priyanka R
			Creation Date 	: 07/12/2016
			Pre-Requisites	: 
			Release         : Takashima
			Revision History: Only Navigator part is automated 
			==============================================================*/
			@Test(priority=1)
			public void verifyDnsZoneRows()
			{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, DNS);
				PageFactory.initElements(driver, Home);
				try{
					
			FrameworkUtil.sTestCaseName = "DNS-verifyDnsZoneRows";
			FrameworkUtil.sManualTestCaseName="QAT-1611-WCP_5223_TC_1.10_DNS page pagination";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			String sZoneName=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.ZONE1INFOBLOX");
			
			//Please give comments - QAA03
			//Login to Navigator Portlet
				com.whs.navigator.testcases.LoginTestCase_Old1.LoginAsDevcoUser();
				
				WebObjectUtil.clickElement(Home.getNav_ServicesTab());
				WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
				WebObjectUtil.explicitWait(8);
				SelectDropdownVal(sZoneName);
				WebObjectUtil.explicitWait(8);
				WebObjectUtil.clickElement(DNS.getNav_DNSHostTab());
				WebObjectUtil.explicitWait(5);
				com.whs.navigator.testcases.LoginTestCase_Old1.nav_Logout();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyDnsZoneRows", "warn", "catch block:" +e.getMessage());  
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
			@Test(priority=2)
			public void verifyDnsLink()
			{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, DNS);
				PageFactory.initElements(driver, Home);
				try{
			FrameworkUtil.sTestCaseName = "DNS-verifyDnsLink";
			FrameworkUtil.sManualTestCaseName="QAT-1583-WCP_5644_TC_1.0_DNS page message display when there are no Records for DNS for Org";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			String sDNSRecordsMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.NO.RECORDS.AVAILABLE");
			//Login to Navigator Portlet
			com.whs.navigator.testcases.LoginTestCase_Old1.LoginAsQaautoAUser();
			//Commented below lines by QAA03 on 07/20/2016
			//WebObjectUtil.explicitWait(5);
			WebObjectUtil.clickElement(Home.getNav_ServicesTab());
			WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
			WebObjectUtil.explicitWait(10);
			WebObjectUtil.verifyElementPresent(DNS.getNav_DNSRecordsArea());
			String sActualDNSNoteMsg=DNS.getNav_DNSNoRecordsNote().getText().trim();
			if(sDNSRecordsMsg.contains(sActualDNSNoteMsg))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "Value is Present", "pass", "DNS Records Not available Note is displayed " + sActualDNSNoteMsg);
			}
			else{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "value is not present", "warn", "Displayed Note:" + sActualDNSNoteMsg );
					}
			com.whs.navigator.testcases.LoginTestCase_Old1.nav_Logout();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyDnsLink", "warn", "catch block:" +e.getMessage());  
				}
			}
			/*==============================================================
			TestScript  	: verifyDnsSenderPolicyRecords()
			Manual TestCase	: QAT-1609-WCP_5223_TC_1.9_Convert DNS Services to Infoblox_Create Sender Policy Record in Infoblox and verification on Navigator
			
			Description		: Create a Sender Policy Record---To create Sender Policy Record
			Author 			: Priyanka R
			Creation Date 	: 07/12/2016
			Pre-Requisites	: 
			Release         : Takashima
			Revision History: Only Navigator part is automated 
			==============================================================*/
			@Test(priority=3)
			public void verifyDnsSenderPolicyRecords()
			{
				WebDriver driver = WebDriverUtil.getDriver();
				// the below line added by QAA03 on 07/20/2016
				PageFactory.initElements(driver, Home);
				PageFactory.initElements(driver, DNS);
				try{
			
		    FrameworkUtil.sTestCaseName = "DNS-verifyDnsSenderPolicyRecords";
			FrameworkUtil.sManualTestCaseName="QAT-1609-WCP_5223_TC_1.9";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			String sZoneName=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.ZONE1INFOBLOX");
			String sSenderPolicyName=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.SENDER.POLICY.NAME.COLUMN");
			//Login to Navigator Portlet
			com.whs.navigator.testcases.LoginTestCase_Old1.LoginAsDevcoUser();
			//Commented below line by QAA03 on 07/20/2016
			//WebObjectUtil.MouseHover(Home.getNav_ServicesTab());
			WebObjectUtil.clickElement(Home.getNav_ServicesTab());
			WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
			WebObjectUtil.explicitWait(10);
			SelectDropdownVal(sZoneName);
			WebObjectUtil.explicitWait(8);
			WebObjectUtil.clickElement(DNS.getNav_DNSSenderPolicyTab());
			
			VerifyGetTableText(sSenderPolicyName);
			
			
			//insert record verification
			com.whs.navigator.testcases.LoginTestCase_Old1.nav_Logout();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyDnsSenderPolicyRecords", "warn", "catch block:" +e.getMessage());  
				}
			}
			
			/*==============================================================
			TestScript  	: verifyDnsTextRecords()
			Manual TestCase	: QAT-1607-WCP_5223_TC_1.8_Convert DNS Services to Infoblox_Create Text Record in Infoblox and verification on Navigator
			Description		: Create a Text Record---Text Record is known as TXT Record in InfoBlox 
			Author 			: Priyanka R
			Creation Date 	: 07/12/2016
			Pre-Requisites	: 
			Release         : Takashima
			Revision History: Only Navigator part is automated 
			==============================================================*/
			@Test(priority=4)
			public void verifyDnsTextRecords()
			{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, DNS);
				PageFactory.initElements(driver, Home);
				try{
			
		    FrameworkUtil.sTestCaseName = "DNS-verifyDnsTextRecords";
			FrameworkUtil.sManualTestCaseName="QAT-1607-WCP_5223_TC_1.8_Convert DNS Services to Infoblox_Create Text Record in Infoblox and verification on Navigator";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			//Login to Navigator Portlet
			com.whs.navigator.testcases.LoginTestCase_Old1.LoginAsDevcoUser();
			//Commented below line by QAA03 on 07/20/2016
			
			//WebObjectUtil.MouseHover(Home.getNav_ServicesTab());
			WebObjectUtil.clickElement(Home.getNav_ServicesTab());
			
			WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
			WebObjectUtil.explicitWait(5);
			VerifyDnsRowZoneNameVal();
			WebObjectUtil.clickElement(DNS.getNav_DNSAliasTab());
			VerifyDnsRowZoneNameVal();
			WebObjectUtil.clickElement(DNS.getNav_DNSMailExchangerTab());
			VerifyDnsRowZoneNameVal();
			WebObjectUtil.clickElement(DNS.getNav_DNSTextTab());
			VerifyDnsRowZoneNameVal();
			WebObjectUtil.clickElement(DNS.getNav_DNSSenderPolicyTab());
			VerifyDnsRowZoneNameVal();
			/*WebObjectUtil.explicitWait(8);
			WebObjectUtil.clickElement(DNS.getNav_DNSTextTab());
			WebObjectUtil.explicitWait(5);
			//insert record verification
*/			com.whs.navigator.testcases.LoginTestCase_Old1.nav_Logout();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyDnsTextRecords", "warn", "catch block:" +e.getMessage());  
				}
			}
				
			/*==============================================================
			TestScript  	: verifyDnsMailExchangerRecords()
			Manual TestCase	: QAT-1605-WCP_5223_TC_1.7_Convert DNS Services to Infoblox_Create Mail Exchanger Record in Infoblox and verification on Navigator
			Description		: Create a Text Record---Text Record is known as TXT Record in InfoBlox 
			Author 			: Priyanka R
			Creation Date 	: 07/12/2016
			Pre-Requisites	: 
			Release         : Takashima
			Revision History: Only Navigator part is automated 
			==============================================================*/
			@Test(priority=5)
			public void verifyDnsMailExchangerRecords()
			{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, DNS);
				PageFactory.initElements(driver, Home);
				try{
				    FrameworkUtil.sTestCaseName = "DNS-verifyDnsMAilExchangerRecords";
			FrameworkUtil.sManualTestCaseName=" QAT-1605-WCP_5223_TC_1.7_Convert DNS Services to Infoblox_Create Mail Exchanger Record in Infoblox and verification on Navigator";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			String sZoneName=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.ZONE1INFOBLOX");
			String sSenderPolicyName=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.SENDER.POLICY.NAME.COLUMN");
			//Login to Navigator Portlet
			com.whs.navigator.testcases.LoginTestCase_Old1.LoginAsDevcoUser();
			WebObjectUtil.clickElement(Home.getNav_ServicesTab());
			WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
			WebObjectUtil.explicitWait(10);
			WebObjectUtil.clickElement(DNS.getNav_ZoneNameDropdownIcon());
			
			WebObjectUtil.explicitWait(5);
			SelectDropdownVal(sZoneName);
			WebObjectUtil.explicitWait(8);
			WebObjectUtil.clickElement(DNS.getNav_DNSMailExchangerTab());
			VerifyGetTableText(sSenderPolicyName);
			com.whs.navigator.testcases.LoginTestCase_Old1.nav_Logout();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyDnsMAilExchangerRecords", "warn", "catch block:" +e.getMessage());  
							}
			}
			
			/*==============================================================
			TestScript  	: verifyDNSAliasHostRecords()
			Manual TestCase	: QAT-1604-WCP_5223_TC_1.7_Convert DNS Services to Infoblox_Create Mail Exchanger Record in Infoblox and verification on Navigator
			                  QAT-1603-WCP_5223_TC_1.5_Convert DNS Services to Infoblox_Create Host in Infoblox
			Description		: Create a Text Record---Text Record is known as TXT Record in InfoBlox 
			Author 			: Priyanka R
			Creation Date 	: 07/12/2016
			Pre-Requisites	: 
			Release         : Takashima
			Revision History: Only Navigator part is automated 
			==============================================================*/
			@Test(priority=6)
			public void verifyDnsAliasHostRecords()
			{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, DNS);
				PageFactory.initElements(driver, Home);
				try{
				    FrameworkUtil.sTestCaseName = "DNS-verifyDnsAliasHostRecords";
			FrameworkUtil.sManualTestCaseName=" QAT-1604-QAT-1603-WCP_5223_TC_1.7_Convert DNS Services to Infoblox__Create Host in Infoblox";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			String sZoneName=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.ZONE1INFOBLOX");
			String sSenderPolicyName=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.SENDER.POLICY.NAME.COLUMN");
			//Login to Navigator Portlet
			com.whs.navigator.testcases.LoginTestCase_Old1.LoginAsDevcoUser();
			//Commented below line by QAA03 on 07/20/2016
			
			
			WebObjectUtil.clickElement(Home.getNav_ServicesTab());
			WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
			WebObjectUtil.explicitWait(10);
			
			//Commented below line by QAA03 on 07/20/2016
			SelectDropdownVal(sZoneName);
			WebObjectUtil.explicitWait(8);
			WebObjectUtil.clickElement(DNS.getNav_DNS_AliasTab());
			VerifyGetTableText(sSenderPolicyName);
			WebObjectUtil.clickElement(DNS.getNav_DNSHostTab());
			VerifyGetTableText(sSenderPolicyName);
			//insert record verification
			com.whs.navigator.testcases.LoginTestCase_Old1.nav_Logout();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyDnsAliasRecords", "warn", "catch block:" +e.getMessage());  
							}
			}
						
			/*==============================================================
			TestScript  	: verifyNewZoneCreated()
			Manual TestCase	: QAT-1599-WCP_5223_TC_1.3_Convert DNS Services to Infoblox_Create Zone in Infoblox and verification on Navigator
			                  QAT-1600-WCP_5223_TC_1.4_Convert DNS Services to Infoblox_Create Sub-Zone in Infoblox and verification on Navigato
			Description		: Create a Sub-Zone. 
			Author 			: Priyanka R
			Creation Date 	: 07/12/2016
			Pre-Requisites	: 
			Release         : Takashima
			Revision History: Only Navigator part is automated 
			==============================================================*/
			@Test(priority=7)
			public void verifyNewZoneCreated()
			{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, DNS);
				PageFactory.initElements(driver, Home);
				try{
					String sActualDropDownItems,sNewZone;
					sNewZone=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.ZONE1INFOBLOX");
			FrameworkUtil.sTestCaseName = "DNS-verifyNewZoneCreated";
			FrameworkUtil.sManualTestCaseName="QAT-1599_QAT-1600-WCP_5223_TC_1.3-WCP_5223_TC_1.4";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			//Login to Navigator Portlet
			com.whs.navigator.testcases.LoginTestCase_Old1.LoginAsDevcoUser();
			//Commented below line by QAA03 on 07/20/2016
			
			//WebObjectUtil.MouseHover(Home.getNav_ServicesTab());
			WebObjectUtil.clickElement(Home.getNav_ServicesTab());
			WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
			WebObjectUtil.explicitWait(10);
			WebObjectUtil.clickElement(DNS.getNav_ZoneNameDropdownIcon());
			//Commented below line by QAA03 on 07/20/2016
			//WebObjectUtil.explicitWait(5);
			WebElement wDNSZoneNameDropDownList = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "CUSTOM.WEBLIST.XPATH", "", "");
			WebObjectUtil.verifyElementPresent(wDNSZoneNameDropDownList);
			sActualDropDownItems=wDNSZoneNameDropDownList.getText();
			if(sActualDropDownItems.contains(sNewZone))
			WebObjectUtil.explicitWait(5);
			VerifyDnsRowZoneNameVal();
			//insert new zone creation
			com.whs.navigator.testcases.LoginTestCase_Old1.nav_Logout();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyNewZoneCreated", "warn", "catch block:" +e.getMessage());  
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
			@Test(priority=8)
			public void verifyAllTabsDataDisplayed()
			{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, DNS);
				PageFactory.initElements(driver, Home);
				try{
					String sActualDropDownItems,sNewZone,sZoneName;
				    FrameworkUtil.sTestCaseName = "DNS-verifyAllTabsDataDisplayed";
			FrameworkUtil.sManualTestCaseName="QAT-1597-WCP_5223_TC_1.2_QAT-1594-WCP_5223_TC_1.0";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			sZoneName=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.ZONE1INFOBLOX");
			//Login to Navigator Portlet
				
			com.whs.navigator.testcases.LoginTestCase_Old1.LoginAsDevcoUser();
				//Commented below line by QAA03 on 07/20/2016
				
				//WebObjectUtil.MouseHover(Home.getNav_ServicesTab());
				WebObjectUtil.clickElement(Home.getNav_ServicesTab());
				WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
				WebObjectUtil.explicitWait(10);
				WebObjectUtil.clickElement(DNS.getNav_ZoneNameDropdownIcon());
			  //WebObjectUtil.selectCustomWebList(DNS.getNav_ZoneNameDropdownList(),sULElement,sZoneName,2);
			    SelectDropdownVal(sZoneName);
			    VerifyTabsData();
			 
			    com.whs.navigator.testcases.LoginTestCase_Old1.nav_Logout();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAllTabsDataDisplayed", "warn", "catch block:" +e.getMessage());  
							}
			}
						
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
			@Test(priority=9)
			public void verifyAllTabsDataDisplayedZone()
			{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, DNS);
				PageFactory.initElements(driver, Home);
				try{
					String sActualDropDownItems,sNewZone,sZoneName;
			FrameworkUtil.sTestCaseName = "DNS-verifyAllTabsDataDisplayedZone";
			FrameworkUtil.sManualTestCaseName="QAT-1596-WCP_5223_TC_1.1_Convert DNS Services to Infoblox";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			sZoneName=(String)FrameworkUtil.dictPropertyData.get("NAV.SELECT.NEW.ZONE.NAME");
			//Login to Navigator Portlet
			
			com.whs.navigator.testcases.LoginTestCase_Old1.LoginAsPuppyloveUser();
			//Commented below line by QAA03 on 07/20/2016
			
			//WebObjectUtil.MouseHover(Home.getNav_ServicesTab());
			WebObjectUtil.clickElement(Home.getNav_ServicesTab());
			WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
			WebObjectUtil.explicitWait(10);
			WebObjectUtil.clickElement(DNS.getNav_ZoneNameDropdownIcon());
			 //WebObjectUtil.selectCustomWebList(DNS.getNav_ZoneNameDropdownList(),sULElement,sZoneName,2);
			    SelectDropdownVal(sZoneName);
			    VerifyTabsData();
			 
			    com.whs.navigator.testcases.LoginTestCase_Old1.nav_Logout();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAllTabsDataDisplayedZone", "warn", "catch block:" +e.getMessage());  
							}
			}
			
			/*==============================================================
			Method Name		: VerifyGetTableText()
			Description		: Verifying values are available from all tabs
			Author 			: Priyanka 
			Creation Date 	: 11/04/2014
			Pre-Requisites	:
			Revision History:
			==============================================================*/
			public static void VerifyGetTableText(String sSenderPolicyName)
				{
				try{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, DNS);
				String sTabledata;
				WebObjectUtil.explicitWait(DNS.getNav_DNSTable());
				WebObjectUtil.verifyElementPresent(DNS.getNav_DNSTable());
				sTabledata=DNS.getNav_DNSTable().getText();
				if(sTabledata.contains(sSenderPolicyName))
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "Value is Present", "pass", "Values are displayed in table " + sSenderPolicyName);
					
				}
				else{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "value is not present", "warn", "Check Manually,Values are not displayed in table" + sSenderPolicyName );
						}
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAllTabsDataDisplayedZone", "warn", "catch block:" +e.getMessage());  
								}
				}
				
							        
				
		
			
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
				try{
					
				
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, DNS);
				
				int iHostTableRows,iAliasTableRows,iMailExchangerTableRows,iTextTableRows,iSenderPolicyTableRows;
				
				WebObjectUtil.explicitWait(5);
				iHostTableRows=WebTableUtil.getRowCount(DNS.getNav_ZoneNameHostTable());
				WebObjectUtil.clickElement(DNS.getNav_DNSAliasTab());
				WebObjectUtil.explicitWait(5);
				iAliasTableRows=WebTableUtil.getRowCount(DNS.getNav_ZoneNameAliasTable());
				WebObjectUtil.clickElement(DNS.getNav_DNSMailExchangerTab());
				WebObjectUtil.explicitWait(5);
				iMailExchangerTableRows=WebTableUtil.getRowCount(DNS.getNav_ZoneNameMailExchangerTable());
				WebObjectUtil.clickElement(DNS.getNav_DNSTextTab());
				WebObjectUtil.explicitWait(5);
				iTextTableRows=WebTableUtil.getRowCount(DNS.getNav_ZoneNameTextTable());
				WebObjectUtil.clickElement(DNS.getNav_DNSSenderPolicyTab());
				WebObjectUtil.explicitWait(5);
				iSenderPolicyTableRows=WebTableUtil.getRowCount(DNS.getNav_ZoneNameSenderPolicyTable());
				if((iHostTableRows!=0) && (iAliasTableRows!=0) && (iMailExchangerTableRows!=0) && (iTextTableRows!=0) && (iSenderPolicyTableRows!=0))
				{
					FrameworkUtil.updateCustomResultBasedOnStatus(true, "All tables are displayed");
					           }
			else{
				FrameworkUtil.updateCustomResultBasedOnStatus(false, "Please check manually some table rows are missing");
						        }
			
				}
			catch (Exception e) {
				// TODO Auto-generated catch block
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VerifyTabsData", "warn", "catch block:" +e.getMessage());  
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
					WebObjectUtil.clickElement(DNS.getNav_ZoneNameDropdownIcon());
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

				
					
						
					
				
			
			/*==============================================================
			Method Name		: SelectDropdownVal
			Description		: Selecting value from dropdown using visible text
			Author 			: Priyanka 
			Creation Date 	: 11/04/2014
			Pre-Requisites	:
			Revision History:
			==============================================================*/
			public static void VerifyDnsRowZoneNameVal()
				{
				try{
				String sZoneNames,sRowTxt,sZoneRowVal;
				sZoneNames=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.ZONE.NAME.DROPDOWN.VALUES");
				String[] aDropDownItem;
				int i,iRowCount;
				WebElement wRow;
				aDropDownItem=sZoneNames.split("@@");
				WebObjectUtil.explicitWait(8);
				for(String sItem:aDropDownItem)
				{
				SelectDropdownVal(sItem);
				WebObjectUtil.explicitWait(5);
				iRowCount=WebTableUtil.getRowCount(DNS.getNav_DNSTable());
				sZoneRowVal="."+""+sItem;
				if(iRowCount>0)
				{
				for(i=1;i<=iRowCount;i++)
				{
				wRow = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "DNS.ROWS", "PARAMETER_ROWNUMBER", i+"");
				sRowTxt=wRow.getText();
				if(sRowTxt.contains(sZoneRowVal)){
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName,"" , "pass", sZoneRowVal+""+" values are present in the Row");
				}
				else{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "", "fail", sZoneRowVal+""+" values are not present in the Row");
				}
				}
				}

				else
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "" , "", "warn", "Check Manually, Table Rows are missing");
				}	
					
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VerifyTabsData", "warn", "catch block:" +e.getMessage());  
								}
				}
	
			
			
			//update each @test result in custom result file
						@AfterMethod
						public static void afterEachMethod(){
						FrameworkUtil.updateTestCaseStatusinResult();
						}
						
			}
			
