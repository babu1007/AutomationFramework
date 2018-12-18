					package com.whs.navigator.testcases;
					import java.lang.reflect.Array;
import java.text.ParseException;
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
import com.whs.navigator.pagefactory.HomePageFactory;
import com.whs.navigator.pagefactory.LoadBalancerPageFactory;
import com.whs.navigator.pagefactory.SmokeTestPageFactory;
import com.whs.navigator.pagefactory.DraasPageFactory;
import com.whs.navigator.pagefactory.CommonPageFactory;
import com.whs.navigator.pagefactory.TicketPageFactory;
import com.whs.navigator.testcases.TicketTestCase;
import com.whs.navigator.pagefactory.FirewallPageFactory;
import com.whs.navigator.pagefactory.EM7PageFactory;
import com.whs.navigator.pagefactory.FormPageFactory;
import com.whs.navigator.pagefactory.EntityBrowserPageFactory;
import com.whs.navigator.testcases.LoginTestCase;
import com.whs.navigator.testcases.NavigatorCommonMethods;
import com.whs.navigator.pagefactory.PhysicalServicesPageFactory;
import com.whs.navigator.pagefactory.DNSPageFactory;
import com.whs.navigator.testcases.LoadBalancersTestCase;
					


					import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
					
				    	public class GalenTestCase_Priyanka  {
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
						public static PhysicalServicesPageFactory PDC =new PhysicalServicesPageFactory();
						public static DNSPageFactory DNS =new DNSPageFactory();
						public static LoadBalancerPageFactory LoadBalancer = new LoadBalancerPageFactory();
						
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
						PageFactory.initElements(driver, Ticket);
						PageFactory.initElements(driver, Home);
						PageFactory.initElements(driver, DNS);
						
					try {
					int iHostTableRows,iAliasTableRows,iMailExchangerTableRows,iTextTableRows,iSenderPolicyTableRows;
					String sModuleName=(String)FrameworkUtil.dictPropertyData.get("NAV.CREATE.TICKET.RELEASE.NAME");
					String sZoneName=(String)FrameworkUtil.dictPropertyData.get("NAV.CREATE.ZONE.NAME");
					String sULElement = (String)FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
					FrameworkUtil.sTestCaseName = "verifyDNSZone";
					FrameworkUtil.sManualTestCaseName="QAT-1500_WCP_4603_TC_1.2_Alilgning DNS UI New Design- Zone name- data display in Tabs for selected Zones";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					// LoginTestCase.LoginAsQaautoUser();
				    //driver.navigate().refresh();
					//LoginTestCase.nav_Logout();
					LoginTestCase.LoginAsDevcoUser();
					WebObjectUtil.MouseHover(Home.getNav_ServicesTab());
					WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
					WebObjectUtil.explicitWait(10);
					WebObjectUtil.clickElement(DNS.getNav_ZoneNameDropdownIcon());
					WebObjectUtil.selectCustomWebList(DNS.getNav_ZoneNameDropdownList(),sULElement,sZoneName,2);
					//WebObjectUtil.selectCustomWebList(DNS.getNav_ZoneNameDropdownList(), sZoneName);
					
					WebObjectUtil.explicitWait(8);
					iHostTableRows=WebTableUtil.getRowCount(DNS.getNav_ZoneNameHostTable());
					WebObjectUtil.clickElement(DNS.getNav_DNSAliasTab());
					WebObjectUtil.explicitWait(8);
					iAliasTableRows=WebTableUtil.getRowCount(DNS.getNav_ZoneNameAliasTable());
					WebObjectUtil.clickElement(DNS.getNav_DNSMailExchangerTab());
					WebObjectUtil.explicitWait(8);
					iMailExchangerTableRows=WebTableUtil.getRowCount(DNS.getNav_ZoneNameMailExchangerTable());
					WebObjectUtil.clickElement(DNS.getNav_DNSTextTab());
					WebObjectUtil.explicitWait(8);
					iTextTableRows=WebTableUtil.getRowCount(DNS.getNav_ZoneNameTextTable());
					WebObjectUtil.clickElement(DNS.getNav_DNSSenderPolicyTab());
					WebObjectUtil.explicitWait(8);
					iSenderPolicyTableRows=WebTableUtil.getRowCount(DNS.getNav_ZoneNameSenderPolicyTable());
					if((iHostTableRows!=0) && (iAliasTableRows!=0) && (iMailExchangerTableRows!=0) && (iTextTableRows!=0) && (iSenderPolicyTableRows!=0))
					{
						FrameworkUtil.updateCustomResultBasedOnStatus(true, "All tables are displayed");
							           }
					else{
						FrameworkUtil.updateCustomResultBasedOnStatus(false, "Please check manually some table rows are missing");
								        }
					    LoginTestCase.nav_Logout();
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
						PageFactory.initElements(driver, Ticket);
						PageFactory.initElements(driver, Home);
						PageFactory.initElements(driver, DNS);
						
					try {
					String sDropDownItems, sActualDropDownItems;
					sDropDownItems=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.ZONE.NAME.DROPDOWN.VALUES");
					FrameworkUtil.sTestCaseName = "verifyDNSZoneDropdown()";
					FrameworkUtil.sManualTestCaseName=" QAT1497_WCP_4603_TC_1.2_Alilgning DNS UI New Design- Zone name drop down";
						FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					   // LoginTestCase.LoginAsQaautoUser();
						LoginTestCase.LoginAsDevcoUser();
					    WebObjectUtil.MouseHover(Home.getNav_ServicesTab());
					    WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
					    WebObjectUtil.explicitWait(10);
					    WebObjectUtil.clickElement(DNS.getNav_ZoneNameDropdownIcon());
					    WebObjectUtil.explicitWait(3);
					    WebObjectUtil.verifyElementPresent(DNS.getNav_ZoneNameDropdownList());
					    sActualDropDownItems=WebObjectUtil.getCustomWebListItems(DNS.getNav_ZoneNameDropdownList());
					    WebObjectUtil.explicitWait(5);
					    verifyingDNSZoneDropDownItems(sDropDownItems,sActualDropDownItems);
					    LoginTestCase.nav_Logout();
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
						PageFactory.initElements(driver, Ticket);
						PageFactory.initElements(driver, Home);
						PageFactory.initElements(driver, DNS);
						
						try {
							String[] arrString = null;
							String sHeaderItems, sActualHeaderItems,sTableText,sSeconds;
							String sZoneName=(String)FrameworkUtil.dictPropertyData.get("NAV.CREATE.ZONE.NAME");
							String sULElement = (String)FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
                            boolean bStatus;
							sHeaderItems=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.ZONE.NAME.HEADER.VALUES");
					sSeconds=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.SENDER.POLICY.TTL.VALUE");
					FrameworkUtil.sTestCaseName = "verifyDNSSenderPolicyTab()";
					FrameworkUtil.sManualTestCaseName="QAT1493_WCP_4603_TC_1.10_Alilgning DNS UI New Design- TTL(secs) Data display for Sender Policy Tab";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					   // LoginTestCase.LoginAsQaautoUser();
					LoginTestCase.LoginAsDevcoUser();
					WebObjectUtil.MouseHover(Home.getNav_ServicesTab());
					WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
					WebObjectUtil.explicitWait(10);
					WebObjectUtil.clickElement(DNS.getNav_ZoneNameDropdownIcon());
					WebObjectUtil.explicitWait(10);
					WebObjectUtil.selectCustomWebList(DNS.getNav_ZoneNameDropdownList(),sULElement,sZoneName,2);
					WebObjectUtil.explicitWait(8);
					WebObjectUtil.clickElement(DNS.getNav_DNSSenderPolicyTab());
					WebObjectUtil.explicitWait(5);
					arrString=sHeaderItems.split("@@");
					sActualHeaderItems=DNS.getNav_SenderPolicyColumnHeader().getText();
					for (int i=0; i<=arrString.length; i++){
						if (sActualHeaderItems.contains(arrString[i])){
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "Value is Present", "pass", "Header String Verified: " + arrString[i]);
						
						bStatus=true;
					}
					else{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "value is not present", "warn", "Header String Not Present/Verified: " + arrString[i] );
						}
					}
					sTableText=DNS.getNav_ZoneNameSenderPolicyTable().getText();
					if (sTableText.contains(sSeconds)){
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Seconds" , "Value is Present", "pass", "Header String Verified: " + sSeconds);
						
					}
					else{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Seconds" , "value is not present", "warn", "Header String Not Present/Verified: " +sSeconds );
						}
					 LoginTestCase.nav_Logout();
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
						PageFactory.initElements(driver, Ticket);
						PageFactory.initElements(driver, Home);
						PageFactory.initElements(driver, DNS);
						
						try {
							String[] arrString = null;
							String sHeaderItems, sActualHeaderItems,sTableText,sSeconds;
							boolean bStatus;
							sHeaderItems=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.ZONE.NAME.HEADER.VALUES");
					sSeconds=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.SENDER.POLICY.TTL.VALUE");
					FrameworkUtil.sTestCaseName = "verifyDNSSTextTab()";
					FrameworkUtil.sManualTestCaseName="QAT1492_WCP_4603_TC_1.10_Alilgning DNS UI New Design- TTL(secs) Data display for Text Tab";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					   // LoginTestCase.LoginAsQaautoUser();
					LoginTestCase.LoginAsDevcoUser();
					WebObjectUtil.MouseHover(Home.getNav_ServicesTab());
					WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
					WebObjectUtil.explicitWait(10);
					WebObjectUtil.clickElement(DNS.getNav_ZoneNameDropdownIcon());
					WebObjectUtil.explicitWait(10);
					WebObjectUtil.selectCustomWebList(DNS.getNav_ZoneNameDropdownList(), 7);
					WebObjectUtil.explicitWait(8);
					WebObjectUtil.clickElement(DNS.getNav_DNSTextTab());
					WebObjectUtil.explicitWait(5);
					arrString=sHeaderItems.split("@@");
					sActualHeaderItems=DNS.getNav_TextColumnHeader().getText();
					for (int i=0; i<=arrString.length; i++){
						if (sActualHeaderItems.contains(arrString[i])){
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "Value is Present", "pass", "Header String Verified: " + arrString[i]);
						
						bStatus=true;
					}
					else{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "value is not present", "warn", "Header String Not Present/Verified: " + arrString[i] );
						}
					}
						WebObjectUtil.explicitWait(5);
					sTableText=DNS.getNav_ZoneNameTextTable().getText();
					if (sTableText.contains(sSeconds)){
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Seconds" , "Value is Present", "pass", "Header String Verified: " + sSeconds);
						
					}
					else{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Seconds" , "value is not present", "warn", "Header String Not Present/Verified: " +sSeconds );
						}
					 LoginTestCase.nav_Logout();
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
						PageFactory.initElements(driver, Ticket);
						PageFactory.initElements(driver, Home);
						PageFactory.initElements(driver, DNS);
						
						try {
							String[] arrString = null;
							String sHeaderItems, sActualHeaderItems,sTableText,sSeconds;
							boolean bStatus;
							sHeaderItems=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.ZONE.NAME.HEADER.VALUES");
					sSeconds=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.SENDER.POLICY.TTL.VALUE");
					FrameworkUtil.sTestCaseName = "verifyMailExchangerTab()";
					FrameworkUtil.sManualTestCaseName="QAT1491_WCP_4603_TC_1.10_Alilgning DNS UI New Design- TTL(secs) Data display for Mail Exchanger Tab";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					   // LoginTestCase.LoginAsQaautoUser();
					LoginTestCase.LoginAsDevcoUser();
					WebObjectUtil.MouseHover(Home.getNav_ServicesTab());
					WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
					WebObjectUtil.explicitWait(10);
					WebObjectUtil.clickElement(DNS.getNav_ZoneNameDropdownIcon());
					WebObjectUtil.explicitWait(10);
					WebObjectUtil.selectCustomWebList(DNS.getNav_ZoneNameDropdownList(), 7);
					WebObjectUtil.explicitWait(8);
					WebObjectUtil.clickElement(DNS.getNav_DNSMailExchangerTab());
					WebObjectUtil.explicitWait(5);
					arrString=sHeaderItems.split("@@");
					sActualHeaderItems=DNS.getNav_MailExchangerColumnHeader().getText();
					for (int i=0; i<=arrString.length; i++){
						if (sActualHeaderItems.contains(arrString[i])){
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "Value is Present", "pass", "Header String Verified: " + arrString[i]);
					}
					else{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "value is not present", "warn", "Header String Not Present/Verified: " + arrString[i] );
						}
					}
					WebObjectUtil.explicitWait(5);
					sTableText=DNS.getNav_ZoneNameMailExchangerTable().getText();
					if (sTableText.contains(sSeconds)){
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Seconds" , "Value is Present", "pass", "Header String Verified: " + sSeconds);
					}
					else{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Seconds" , "value is not present", "warn", "Header String Not Present/Verified: " +sSeconds );
						}
					 LoginTestCase.nav_Logout();
					}
					
					
					catch (Exception e) {
								LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
					}
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
						PageFactory.initElements(driver, Ticket);
						PageFactory.initElements(driver, Home);
						PageFactory.initElements(driver, DNS);
						
						try {
							String[] arrString = null;
							String sHeaderItems, sActualHeaderItems,sTableText,sSeconds;
							boolean bStatus;
							sHeaderItems=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.ZONE.NAME.HEADER.VALUES");
					sSeconds=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.SENDER.POLICY.TTL.VALUE");
					FrameworkUtil.sTestCaseName = "verifyAliasTab()";
					FrameworkUtil.sManualTestCaseName="QAT1490_WCP_4603_TC_1.10_Alilgning DNS UI New Design- TTL(secs) Data display for Alias Tab";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					   // LoginTestCase.LoginAsQaautoUser();
					LoginTestCase.LoginAsDevcoUser();
					WebObjectUtil.MouseHover(Home.getNav_ServicesTab());
					WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
					WebObjectUtil.explicitWait(10);
					WebObjectUtil.clickElement(DNS.getNav_ZoneNameDropdownIcon());
					WebObjectUtil.explicitWait(10);
					WebObjectUtil.selectCustomWebList(DNS.getNav_ZoneNameDropdownList(), 7);
					WebObjectUtil.explicitWait(8);
					WebObjectUtil.clickElement(DNS.getNav_DNSAliasTab());
					WebObjectUtil.explicitWait(5);
					arrString=sHeaderItems.split("@@");
					sActualHeaderItems=DNS.getNav_AliasColumnHeader().getText();
					for (int i=0; i<=arrString.length; i++){
					if (sActualHeaderItems.contains(arrString[i])){
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "Value is Present", "pass", "Header String Verified: " + arrString[i]);
					}
					else{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "value is not present", "warn", "Header String Not Present/Verified: " + arrString[i] );
						}
					}
					WebObjectUtil.explicitWait(5);
					sTableText=DNS.getNav_ZoneNameMailExchangerTable().getText();
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
						 LoginTestCase.nav_Logout();
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
						PageFactory.initElements(driver, Ticket);
						PageFactory.initElements(driver, Home);
						PageFactory.initElements(driver, DNS);
						
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
					   //LoginTestCase.LoginAsQaautoUser();
					LoginTestCase.LoginAsDevcoUser();
					WebObjectUtil.MouseHover(Home.getNav_ServicesTab());
					WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
					WebObjectUtil.explicitWait(10);
					WebObjectUtil.clickElement(DNS.getNav_ZoneNameDropdownIcon());
					WebObjectUtil.explicitWait(10);
					WebObjectUtil.verifyElementPresent(DNS.getNav_ZoneNameDropdownList());
					WebObjectUtil.clickElement(DNS.getNav_ZoneNameDropdownIcon());
					WebObjectUtil.explicitWait(3);
					WebObjectUtil.verifyElementPresent(DNS.getNav_DNSHostTab());
					WebObjectUtil.verifyElementPresent(DNS.getNav_DNSPdfIcon());
					WebObjectUtil.verifyElementPresent(DNS.getNav_DNSCsvIcon());
					WebObjectUtil.verifyElementPresent(DNS.getNav_DNSAliasTab());
					WebObjectUtil.verifyElementPresent(DNS.getNav_DNSMailExchangerTab());
					WebObjectUtil.verifyElementPresent(DNS.getNav_DNSTextTab());
					WebObjectUtil.clickElement(DNS.getNav_DNSSenderPolicyTab());
					iRowLength=WebTableUtil.getRowCount(DNS.getNav_ZoneNameSenderPolicyTable());
					WebObjectUtil.verifyElementPresent(DNS.getNav_DNSSenderPolicyTab());
					sActualHeaderItems=DNS.getNav_SenderPolicyColumnHeader().getText();
					for (int i=0; i<=arrString.length; i++){
						if (sActualHeaderItems.contains(arrString[i])){
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "Value is Present", "pass", "Header String Verified: " + arrString[i]);
					}
					else{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "value is not present", "warn", "Header String Not Present/Verified: " + arrString[i] );
								}
					        }
							WebObjectUtil.explicitWait(3);
					       NavigatorCommonMethods.verifyColumnSort(wColumnName,wFirstRowElement,iRowLength);
					       LoginTestCase.nav_Logout();
					        
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
						PageFactory.initElements(driver, Ticket);
						PageFactory.initElements(driver, Home);
						PageFactory.initElements(driver, DNS);
						
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
					FrameworkUtil.sTestCaseName = "verifyTextTabFileds";
					FrameworkUtil.sManualTestCaseName="QAT1487_WCP_4603_TC_1.1_Alilgning DNS UI New Design-Data display for Text Tab";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					//LoginTestCase.LoginAsQaautoUser();
					LoginTestCase.LoginAsDevcoUser();
					WebObjectUtil.MouseHover(Home.getNav_ServicesTab());
					WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
					WebObjectUtil.explicitWait(10);
					WebObjectUtil.clickElement(DNS.getNav_ZoneNameDropdownIcon());
					WebObjectUtil.explicitWait(10);
					WebObjectUtil.verifyElementPresent(DNS.getNav_ZoneNameDropdownList());
					WebObjectUtil.clickElement(DNS.getNav_ZoneNameDropdownIcon());
					WebObjectUtil.explicitWait(3);
					WebObjectUtil.verifyElementPresent(DNS.getNav_DNSHostTab());
					WebObjectUtil.verifyElementPresent(DNS.getNav_DNSPdfIcon());
					WebObjectUtil.verifyElementPresent(DNS.getNav_DNSCsvIcon());
					WebObjectUtil.verifyElementPresent(DNS.getNav_DNSAliasTab());
					WebObjectUtil.verifyElementPresent(DNS.getNav_DNSMailExchangerTab());
					WebObjectUtil.verifyElementPresent(DNS.getNav_DNSSenderPolicyTab());
					WebObjectUtil.clickElement(DNS.getNav_DNSTextTab());
					iRowLength=WebTableUtil.getRowCount(DNS.getNav_ZoneNameTextTable());
					WebObjectUtil.verifyElementPresent(DNS.getNav_DNSTextTab());
					sActualHeaderItems=DNS.getNav_TextColumnHeader().getText();
					for (int i=0; i<=arrString.length; i++){
						if (sActualHeaderItems.contains(arrString[i])){
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "Value is Present", "pass", "Header String Verified: " + arrString[i]);
					}
					else{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "value is not present", "warn", "Header String Not Present/Verified: " + arrString[i] );
								}
					        }
							WebObjectUtil.explicitWait(3);
					       NavigatorCommonMethods.verifyColumnSort(wColumnName,wFirstRowElement,iRowLength);
					       LoginTestCase.nav_Logout();  
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
						PageFactory.initElements(driver, Ticket);
						PageFactory.initElements(driver, Home);
						PageFactory.initElements(driver, DNS);
						
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
					   //LoginTestCase.LoginAsQaautoUser();
					LoginTestCase.LoginAsDevcoUser();
					WebObjectUtil.MouseHover(Home.getNav_ServicesTab());
					WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
					WebObjectUtil.explicitWait(10);
					WebObjectUtil.clickElement(DNS.getNav_ZoneNameDropdownIcon());
					WebObjectUtil.explicitWait(10);
					WebObjectUtil.verifyElementPresent(DNS.getNav_ZoneNameDropdownList());
					WebObjectUtil.clickElement(DNS.getNav_ZoneNameDropdownIcon());
					WebObjectUtil.explicitWait(3);
					WebObjectUtil.verifyElementPresent(DNS.getNav_DNSHostTab());
					WebObjectUtil.verifyElementPresent(DNS.getNav_DNSPdfIcon());
					WebObjectUtil.verifyElementPresent(DNS.getNav_DNSCsvIcon());
					WebObjectUtil.verifyElementPresent(DNS.getNav_DNSTextTab());
					WebObjectUtil.verifyElementPresent(DNS.getNav_DNSMailExchangerTab());
					WebObjectUtil.verifyElementPresent(DNS.getNav_DNSSenderPolicyTab());
					WebObjectUtil.clickElement(DNS.getNav_DNSAliasTab());
					iRowLength=WebTableUtil.getRowCount(DNS.getNav_ZoneNameAliasTable());
					WebObjectUtil.verifyElementPresent(DNS.getNav_DNSAliasTab());
					sActualHeaderItems=DNS.getNav_AliasColumnHeader().getText();
					for (int i=0; i<=arrString.length; i++){
						if (sActualHeaderItems.contains(arrString[i])){
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "Value is Present", "pass", "Header String Verified: " + arrString[i]);
					}
					else{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "value is not present", "warn", "Header String Not Present/Verified: " + arrString[i] );
								}
					        }
							WebObjectUtil.explicitWait(3);
					       NavigatorCommonMethods.verifyColumnSort(wColumnName,wFirstRowElement,iRowLength);
					       LoginTestCase.nav_Logout();  
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
						PageFactory.initElements(driver, Ticket);
						PageFactory.initElements(driver, Home);
						PageFactory.initElements(driver, DNS);
						
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
					   //LoginTestCase.LoginAsQaautoUser();
					LoginTestCase.LoginAsDevcoUser();
					WebObjectUtil.MouseHover(Home.getNav_ServicesTab());
					WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
					WebObjectUtil.explicitWait(10);
					WebObjectUtil.clickElement(DNS.getNav_ZoneNameDropdownIcon());
					WebObjectUtil.explicitWait(10);
					WebObjectUtil.verifyElementPresent(DNS.getNav_ZoneNameDropdownList());
					WebObjectUtil.clickElement(DNS.getNav_ZoneNameDropdownIcon());
					WebObjectUtil.explicitWait(3);
					WebObjectUtil.verifyElementPresent(DNS.getNav_DNSHostTab());
					WebObjectUtil.verifyElementPresent(DNS.getNav_DNSPdfIcon());
					WebObjectUtil.verifyElementPresent(DNS.getNav_DNSCsvIcon());
					WebObjectUtil.verifyElementPresent(DNS.getNav_DNSTextTab());
					WebObjectUtil.verifyElementPresent(DNS.getNav_DNSAliasTab());
					WebObjectUtil.verifyElementPresent(DNS.getNav_DNSSenderPolicyTab());
					WebObjectUtil.clickElement(DNS.getNav_DNSMailExchangerTab());
					iRowLength=WebTableUtil.getRowCount(DNS.getNav_ZoneNameMailExchangerTable());
					WebObjectUtil.verifyElementPresent(DNS.getNav_DNSMailExchangerTab());
					sActualHeaderItems=DNS.getNav_MailExchangerColumnHeader().getText();
					for (int i=0; i<=arrString.length; i++){
						if (sActualHeaderItems.contains(arrString[i])){
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "Value is Present", "pass", "Header String Verified: " + arrString[i]);
					}
					else{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "value is not present", "warn", "Header String Not Present/Verified: " + arrString[i] );
								}
					        }
							WebObjectUtil.explicitWait(3);
					       NavigatorCommonMethods.verifyColumnSort(wColumnName,wFirstRowElement,iRowLength);
					       LoginTestCase.nav_Logout();  
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
						PageFactory.initElements(driver, Ticket);
						PageFactory.initElements(driver, Home);
						PageFactory.initElements(driver, DNS);
						
						try {
							String[] arrString = null;
							String sHeaderItems, sActualHeaderItems,sTableText,sSeconds;
							boolean bStatus;
							String sZoneName=(String)FrameworkUtil.dictPropertyData.get("NAV.CREATE.ZONE.NAME");
							String sULElement = (String)FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
							sHeaderItems=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.ZONE.NAME.HEADER.VALUES");
					sSeconds=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.SENDER.POLICY.TTL.VALUE");
					FrameworkUtil.sTestCaseName = "verifyHostTab()";
					FrameworkUtil.sManualTestCaseName="QAT1417_WCP_4603_TC_1.10_Alilgning DNS UI New Design- TTL(secs) Data display for Host Tab";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					   // LoginTestCase.LoginAsQaautoUser();
					LoginTestCase.LoginAsDevcoUser();
					WebObjectUtil.MouseHover(Home.getNav_ServicesTab());
					WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
					WebObjectUtil.explicitWait(10);
					WebObjectUtil.clickElement(DNS.getNav_ZoneNameDropdownIcon());
					WebObjectUtil.explicitWait(10);
					WebObjectUtil.selectCustomWebList(DNS.getNav_ZoneNameDropdownList(),sULElement,sZoneName,2);
					WebObjectUtil.explicitWait(8);
					WebObjectUtil.clickElement(DNS.getNav_DNSHostTab());
					WebObjectUtil.explicitWait(5);
					arrString=sHeaderItems.split("@@");
					sActualHeaderItems=DNS.getNav_HostColumnHeader().getText();
					for (int i=0; i<=arrString.length; i++){
						if (sActualHeaderItems.contains(arrString[i])){
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "Value is Present", "pass", "Header String Verified: " + arrString[i]);
						bStatus=true;
					}
					else{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Header" , "value is not present", "warn", "Header String Not Present/Verified: " + arrString[i] );
						}
					}
					sTableText=DNS.getNav_ZoneNameHostTable().getText();
					if (sTableText.contains(sSeconds)){
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Seconds" , "Value is Present", "pass", "Header String Verified: " + sSeconds);
						
					}
					else{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Seconds" , "value is not present", "warn", "Header String Not Present/Verified: " +sSeconds );
						}
					 LoginTestCase.nav_Logout();
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
						PageFactory.initElements(driver, Ticket);
						PageFactory.initElements(driver, Home);
						PageFactory.initElements(driver, DNS);
						
						try {
							int iRowCount;
							String[] arrString = null;
							WebElement wColumnName=WebObjectUtil.getWebElementFromDynamicLocator("xpath","DNS.SENDERPOLICY.FIRST.COLUMN.NAME","","");
					WebElement wFirstRowElement=WebObjectUtil.getWebElementFromDynamicLocator("xpath","DNS.SENDERPOLICY.FIRST.ROW.NAME","","");
					WebElement wColumnName1=WebObjectUtil.getWebElementFromDynamicLocator("xpath","DNS.SENDERPOLICY.SECOND.COLUMN.NAME","","");
					WebElement wFirstRowElement1=WebObjectUtil.getWebElementFromDynamicLocator("xpath","DNS.SENDERPOLICY.SECOND.ROW.NAME","","");
					WebElement wColumnName2=WebObjectUtil.getWebElementFromDynamicLocator("xpath","DNS.SENDERPOLICY.THIRD.COLUMN.NAME","","");
					WebElement wFirstRowElement2=WebObjectUtil.getWebElementFromDynamicLocator("xpath","DNS.SENDERPOLICY.THIRD.ROW.NAME","","");
					String sHeaderItems, sActualHeaderItems,sTableText,sSeconds;
					boolean bStatus;
					int iRowLength;
					sHeaderItems=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.ZONE.NAME.HEADER.VALUES");
					sSeconds=(String)FrameworkUtil.dictPropertyData.get("NAV.DNS.SENDER.POLICY.TTL.VALUE");
					FrameworkUtil.sTestCaseName = "verifyHostTabFileds";
					FrameworkUtil.sManualTestCaseName="QAT1399_WCP_4603_TC_1.1_Alilgning DNS UI New Design-Data display for Host Tab";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					   //LoginTestCase.LoginAsQaautoUser();
					LoginTestCase.LoginAsDevcoUser();
					WebObjectUtil.MouseHover(Home.getNav_ServicesTab());
					WebObjectUtil.clickElement(Home.getNav_DNSMenuLink());
					WebObjectUtil.explicitWait(10);
					WebObjectUtil.clickElement(DNS.getNav_ZoneNameDropdownIcon());
					WebObjectUtil.explicitWait(10);
					WebObjectUtil.verifyElementPresent(DNS.getNav_ZoneNameDropdownList());
					WebObjectUtil.clickElement(DNS.getNav_ZoneNameDropdownIcon());
					WebObjectUtil.explicitWait(3);
					WebObjectUtil.verifyElementPresent(DNS.getNav_DNSHostTab());
					WebObjectUtil.verifyElementPresent(DNS.getNav_DNSPdfIcon());
					WebObjectUtil.verifyElementPresent(DNS.getNav_DNSCsvIcon());
					WebObjectUtil.verifyElementPresent(DNS.getNav_DNSAliasTab());
					WebObjectUtil.verifyElementPresent(DNS.getNav_DNSMailExchangerTab());
					WebObjectUtil.verifyElementPresent(DNS.getNav_DNSSenderPolicyTab());
					WebObjectUtil.clickElement(DNS.getNav_DNSHostTab());
					iRowLength=WebTableUtil.getRowCount(DNS.getNav_ZoneNameHostTable());
					WebObjectUtil.verifyElementPresent(DNS.getNav_DNSHostTab());
					sActualHeaderItems=DNS.getNav_HostColumnHeader().getText();
					for (int i=0; i<=arrString.length; i++){
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
					       LoginTestCase.nav_Logout(); 
						}
					
					catch (Exception e) {
					LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
					}
					       }
												
					/*==============================================================
					TestScript  	: verifyLoadBalancerAddVIP()
					Manual TestCase	: QAT1419_WCP-5224-TC_1.0_Load Balancer -> Virtual IPs -> Public IP addresses
					Description		: Verify that data is displayed under Host Tab on DNS page
					Author 			: Priyanka
					Creation Date 	: 06/08/2016
					Pre-Requisites	:
					Release Name    : Galen
					Revision History:
					==============================================================*/
					@Test(priority=14)
					public void verifyLoadBalancerAddVIP()
					{
						WebDriver driver = WebDriverUtil.getDriver();
						PageFactory.initElements(driver, LoadBalancer);
						PageFactory.initElements(driver, Common);
						PageFactory.initElements(driver, DNS);
						
						try {	
					/*Automation note: error message is displayed for specific scenario. We don't have org that meats this criteria now.*/
					FrameworkUtil.sTestCaseName = "verifyLoadBalancerAddVIP()";
					FrameworkUtil.sManualTestCaseName="QAT1419_WCP-5224-TC_1.0_Load Balancer -> Virtual IPs -> Public IP addresses";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					LoginTestCase.LoginAsHawkeyeUser();
					LoadBalancersTestCase.NavigatingToLoadBalancerPage();
					WebObjectUtil.clickElement(LoadBalancer.getNavVirtualIpTab());
					WebObjectUtil.waitForElementPresent(LoadBalancer.getNavVirtualIpTab_AddVIPLink());
					WebObjectUtil.clickElement(LoadBalancer.getNavVirtualIpTab_AddVIPLink());
					WebObjectUtil.explicitWait(3);
					WebObjectUtil.verifyElementPresent(Common.getNav_CommonPopUpBox());
					WebObjectUtil.clickElement(Common.getNav_CommonPopUpOkBtn());
					LoginTestCase.nav_Logout();
					}
					
					catch (Exception e) {
					LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
					}
					       }
					
					/*==============================================================
					TestScript  	: verifyLoadBalancerDeleteVIP()
					Manual TestCase	: QAT1407_WCP-4892-TC_1.0_Load Balancer -> Virtual IPs -> Delete
					Description		: Verify that the user is able to Delete the VIP successfully.
					Author 			: Priyanka
					Creation Date 	: 06/24/2016
					Pre-Requisites	:
					Release Name    : Galen
					Revision History:
					==============================================================*/
					@Test(priority=15)
					public void verifyLoadBalancerDeleteVIP()
					{
						WebDriver driver = WebDriverUtil.getDriver();
						PageFactory.initElements(driver, LoadBalancer);
						PageFactory.initElements(driver, Common);
						PageFactory.initElements(driver, DNS);
						
						try {	
					/*Automation note: error message is displayed for specific scenario. We don't have org that meats this criteria now.*/
					FrameworkUtil.sTestCaseName = "verifyLoadBalancerDeleteVIP()";
					FrameworkUtil.sManualTestCaseName=" QAT1407_WCP-4892-TC_1.0_Load Balancer -> Virtual IPs -> Delete";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					LoginTestCase.LoginAsHawkeyeUser();
					LoadBalancersTestCase.NavigatingToLoadBalancerPage();
					WebObjectUtil.clickElement(LoadBalancer.getNavVirtualIpTab());
					WebObjectUtil.waitForElementPresent(LoadBalancer.getNavVirtualIpTab_AddVIPLink());
					WebObjectUtil.clickElement(LoadBalancer.getNavVirtualIpTab_AddVIPLink());
					WebObjectUtil.explicitWait(3);
					//add steps to change the vip details
					WebObjectUtil.verifyElementPresent(Common.getNav_CommonPopUpBox());
					WebObjectUtil.clickElement(Common.getNav_CommonPopUpOkBtn());
					String sExpander = WebObjectUtil.getLocatorValueFromProperty("EVDC.LOADBALANCER.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
					WebElement wExpander = WebObjectUtil.GetWebElement("XPATH", sExpander, "Expand Arrow");
					wExpander.click();
					WebObjectUtil.explicitWait(5);
					String sDeleteBtn =  WebObjectUtil.getLocatorValueFromProperty("EVDC.LOADBALANCER.EXPANDER.DELETE.BUTTON", "PARAMETER_ROWNUMBER", 1 +"");
					WebElement wDeleteBtn = WebObjectUtil.GetWebElement("XPATH", sDeleteBtn, "Delete button");
					WebObjectUtil.clickElement(wDeleteBtn);
					String sEditBtn = WebObjectUtil.getLocatorValueFromProperty("EVDC.LOADBALANCER.EXPANDER.EDIT.BUTTON", "PARAMETER_ROWNUMBER", 1 +"");
					WebElement wEditBtn = WebObjectUtil.GetWebElement("XPATH", sEditBtn, "EditButton");
				
					String sRefreshBtn = WebObjectUtil.getLocatorValueFromProperty("EVDC.LOADBALANCER.EXPANDER.REFRESHDETAILS.BUTTON", "PARAMETER_ROWNUMBER", 1 +"");
					WebElement wRefreshBtn = WebObjectUtil.GetWebElement("XPATH", sRefreshBtn, "RefreshDetailsButton");
					
					WebObjectUtil.explicitWait(5);
					WebObjectUtil.clickElement(LoadBalancer.getNavPopUp_OkBtn());
					driver.navigate().refresh();
					TicketTestCase.verifyElementDisabled(wDeleteBtn);
					TicketTestCase.verifyElementDisabled(wEditBtn);
					TicketTestCase.verifyElementDisabled(wRefreshBtn);
					WebObjectUtil.explicitWait(350);
					WebObjectUtil.verifyElementPresent(Common.getNav_UsrFeedBack());
					LoginTestCase.nav_Logout();
					}
					
					catch (Exception e) {
					LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
					}
					       }
					
					
					/*==============================================================
					TestScript  	: verifyLoadBalancerEditVIP()
					Manual TestCase	: QAT1405_WCP_4891_TC_1.1_Load Balancer -> Edit VIP functionality
					Description		: Verify that the user is able to Edit the VIP successfully.
					Author 			: Priyanka
					Creation Date 	: 06/24/2016
					Pre-Requisites	:
					Release Name    : Galen
					Revision History:
					==============================================================*/
					@Test(priority=16)
					public void verifyLoadBalancerEditVIP()
					{
						WebDriver driver = WebDriverUtil.getDriver();
						PageFactory.initElements(driver, LoadBalancer);
						PageFactory.initElements(driver, Common);
						PageFactory.initElements(driver, DNS);
						
						try {	
					/*Automation note: error message is displayed for specific scenario. We don't have org that meats this criteria now.*/
					FrameworkUtil.sTestCaseName = "verifyLoadBalancerEditVIP()";
					FrameworkUtil.sManualTestCaseName="QAT1405_WCP_4891_TC_1.1_Load Balancer -> Edit VIP functionality";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					LoginTestCase.LoginAsHawkeyeUser();
					LoadBalancersTestCase.NavigatingToLoadBalancerPage();
					WebObjectUtil.clickElement(LoadBalancer.getNavVirtualIpTab());
					WebObjectUtil.waitForElementPresent(LoadBalancer.getNavVirtualIpTab_AddVIPLink());
					String sExpander = WebObjectUtil.getLocatorValueFromProperty("EVDC.LOADBALANCER.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
					WebElement wExpander = WebObjectUtil.GetWebElement("XPATH", sExpander, "Expand Arrow");
					//WebObjectUtil.clickElement(wExpander);
					wExpander.click();
					WebObjectUtil.explicitWait(5);
					String sDeleteBtn =  WebObjectUtil.getLocatorValueFromProperty("EVDC.LOADBALANCER.EXPANDER.DELETE.BUTTON", "PARAMETER_ROWNUMBER", 1 +"");
					WebElement wDeleteBtn = WebObjectUtil.GetWebElement("XPATH", sDeleteBtn, "Delete button");
					
					String sEditBtn = WebObjectUtil.getLocatorValueFromProperty("EVDC.LOADBALANCER.EXPANDER.EDIT.BUTTON", "PARAMETER_ROWNUMBER", 1 +"");
					WebElement wEditBtn = WebObjectUtil.GetWebElement("XPATH", sEditBtn, "EditButton");
					
					String sRefreshBtn = WebObjectUtil.getLocatorValueFromProperty("EVDC.LOADBALANCER.EXPANDER.REFRESHDETAILS.BUTTON", "PARAMETER_ROWNUMBER", 1 +"");
					WebElement wRefreshBtn = WebObjectUtil.GetWebElement("XPATH", sRefreshBtn, "RefreshDetailsButton");
					
					WebObjectUtil.clickElement(wEditBtn);
					//need to include source code for editing the data
					WebObjectUtil.clickElement(LoadBalancer.getNavPopUp_OkBtn());
					WebObjectUtil.explicitWait(5);
					WebObjectUtil.verifyElementPresent(Common.getNav_UsrFeedBack());
				
					
					driver.navigate().refresh();
					WebObjectUtil.verifyElementNOTPresent(wEditBtn);
					TicketTestCase.verifyElementDisabled(wDeleteBtn);
					TicketTestCase.verifyElementDisabled(wEditBtn);
					TicketTestCase.verifyElementDisabled(wRefreshBtn);
					WebObjectUtil.explicitWait(350);
					wExpander.click();
					//need to include edit data check, also edit VIP fail check 
					WebObjectUtil.verifyElementPresent(Common.getNav_UsrFeedBack());
					
					
					LoginTestCase.nav_Logout();
					}
					
					catch (Exception e) {
					LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
					}
					       }
					/*==============================================================
					TestScript  	: verifyLoadBalancerAddVIPDetails()
					Manual TestCase	: QAT1403_WCP_4890_TC_1.4_Load Balancer -> Add VIP functionality
					Description		: Verify that the user is able to submit the ADD VIP successfully
					Author 			: Priyanka
					Creation Date 	: 06/24/2016
					Pre-Requisites	:
					Release Name    : Galen
					Revision History:
					==============================================================*/
					@Test(priority=16)
					public void verifyLoadBalancerAddVIPDetails()
					{
						WebDriver driver = WebDriverUtil.getDriver();
						PageFactory.initElements(driver, LoadBalancer);
						PageFactory.initElements(driver, Common);
						PageFactory.initElements(driver, DNS);
						
						try {	
					/*Automation note: error message is displayed for specific scenario. We don't have org that meats this criteria now.*/
					FrameworkUtil.sTestCaseName = "verifyLoadBalancerAddVIPDetails()";
					FrameworkUtil.sManualTestCaseName=" QAT1403_WCP_4890_TC_1.4_Load Balancer -> Add VIP functionality";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					LoginTestCase.LoginAsHawkeyeUser();
					LoadBalancersTestCase.NavigatingToLoadBalancerPage();
					WebObjectUtil.clickElement(LoadBalancer.getNavVirtualIpTab());
					WebObjectUtil.waitForElementPresent(LoadBalancer.getNavVirtualIpTab_AddVIPLink());
					WebObjectUtil.clickElement(LoadBalancer.getNavVirtualIpTab_AddVIPLink());
					
					WebObjectUtil.clickElement(LoadBalancer.getNavPopUp_OkBtn());
					WebObjectUtil.explicitWait(5);
					WebObjectUtil.verifyElementPresent(Common.getNav_UsrFeedBack());
					driver.navigate().refresh();
					String sExpander = WebObjectUtil.getLocatorValueFromProperty("EVDC.LOADBALANCER.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
					WebElement wExpander = WebObjectUtil.GetWebElement("XPATH", sExpander, "Expand Arrow");
					//WebObjectUtil.clickElement(wExpander);
					wExpander.click();
					WebObjectUtil.explicitWait(5);
					String sDeleteBtn =  WebObjectUtil.getLocatorValueFromProperty("EVDC.LOADBALANCER.EXPANDER.DELETE.BUTTON", "PARAMETER_ROWNUMBER", 1 +"");
					WebElement wDeleteBtn = WebObjectUtil.GetWebElement("XPATH", sDeleteBtn, "Delete button");
					
					String sEditBtn = WebObjectUtil.getLocatorValueFromProperty("EVDC.LOADBALANCER.EXPANDER.EDIT.BUTTON", "PARAMETER_ROWNUMBER", 1 +"");
					WebElement wEditBtn = WebObjectUtil.GetWebElement("XPATH", sEditBtn, "EditButton");
					
					String sRefreshBtn = WebObjectUtil.getLocatorValueFromProperty("EVDC.LOADBALANCER.EXPANDER.REFRESHDETAILS.BUTTON", "PARAMETER_ROWNUMBER", 1 +"");
					WebElement wRefreshBtn = WebObjectUtil.GetWebElement("XPATH", sRefreshBtn, "RefreshDetailsButton");
					
					//need to include source code for editing the data
					TicketTestCase.verifyElementDisabled(wDeleteBtn);
					TicketTestCase.verifyElementDisabled(wEditBtn);
					TicketTestCase.verifyElementDisabled(wRefreshBtn);
					WebObjectUtil.explicitWait(350);
					//expand newly created VIP
					wExpander.click();
					//need to include edit data check, also edit VIP fail check 
					WebObjectUtil.verifyElementPresent(Common.getNav_UsrFeedBack());
					
					LoginTestCase.nav_Logout();
					}
					
					catch (Exception e) {
					LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
					}
				    }
					
					/*==============================================================
					TestScript  	: verifyLoadBalancerAddVIPReset()
					Manual TestCase	: QAT1402_WCP_4890_TC_1.3_Load Balancer -> Add VIP-> Reset
					Description		: Verify the Reset the page once user clicks on Reset button in the AddVIP page
					Author 			: Priyanka
					Creation Date 	: 06/24/2016
					Pre-Requisites	:
					Release Name    : Galen
					Revision History:
					==============================================================*/
					@Test(priority=14)
					public void verifyLoadBalancerAddVIPReset()
					{
						WebDriver driver = WebDriverUtil.getDriver();
						PageFactory.initElements(driver, LoadBalancer);
						PageFactory.initElements(driver, Common);
						PageFactory.initElements(driver, DNS);
						
						try {	
					/*Automation note: error message is displayed for specific scenario. We don't have org that meats this criteria now.*/
					FrameworkUtil.sTestCaseName = " verifyLoadBalancerAddVIPReset()";
					FrameworkUtil.sManualTestCaseName=" QAT1402_WCP_4890_TC_1.3_Load Balancer -> Add VIP-> Reset";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					LoginTestCase.LoginAsHawkeyeUser();
					LoadBalancersTestCase.NavigatingToLoadBalancerPage();
					WebObjectUtil.clickElement(LoadBalancer.getNavVirtualIpTab());
					WebObjectUtil.waitForElementPresent(LoadBalancer.getNavVirtualIpTab_AddVIPLink());
					WebObjectUtil.clickElement(LoadBalancer.getNavVirtualIpTab_AddVIPLink());
					WebObjectUtil.explicitWait(3);
					WebObjectUtil.verifyElementPresent(Common.getNav_CommonPopUpBox());
					WebObjectUtil.clickElement(Common.getNav_CommonPopUpOkBtn());
					//WebObjectUtil.
					LoginTestCase.nav_Logout();
					}
					
					catch (Exception e) {
					LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
					}
					       }	
					
					/*==============================================================
					TestScript  	: verifyLoadBalancerVIPCount()
					Manual TestCase	: QAT1401_WCP_4890_TC_1.2_Load Balancer link
					Description		: Verify that user is able to go to the Load balancer page when user 
					                  clicks on Loadbalancer link in EVDC portlet and EVDC overview page
					Author 			: Priyanka
					Creation Date 	: 06/30/2016
					Pre-Requisites	:
					Release Name    : Galen
					Revision History:
					==============================================================*/
					@Test(priority=15)
					public void  verifyLoadBalancerVIPCount()
					{
						WebDriver driver = WebDriverUtil.getDriver();
						PageFactory.initElements(driver, LoadBalancer);
						PageFactory.initElements(driver, Home);
						PageFactory.initElements(driver, EVDC_OverviewPF);
						
						try {
					String sEVDC_LBCount;
					/*Automation note: error message is displayed for specific scenario. We don't have org that meats this criteria now.*/
					FrameworkUtil.sTestCaseName = "verifyLoadBalancerVIPCount()";
					FrameworkUtil.sManualTestCaseName="QAT1401_WCP_4890_TC_1.2_Load Balancer link";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					//LoginTestCase.LoginAsHawkeyeUser();
					LoginTestCase.LoginAsAgentUser();
					LoadBalancersTestCase.NavigatingToLoadBalancerPage();
					WebObjectUtil.explicitWait(5);
					WebObjectUtil.ClickAndMouseHover(Home.getNav_MonitoringTab());
					WebObjectUtil.clickElement(Home.getNav_SummaryViewMenuLink());
					WebObjectUtil.explicitWait(5);
					WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
					WebObjectUtil.waitForElementPresent(EVDC_OverviewPF.getNav_EVDCOverViewLink());
					WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCLBVipsVal());
					sEVDC_LBCount=(EVDC_OverviewPF.getNav_EVDCLBVipsVal().getText()).trim();
					WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCLBLink());
					WebObjectUtil.explicitWait(5);
					int iActEVDC_LBCount= WebTableUtil.getRowCount(LoadBalancer.getNavVirtulIPTableParent());
					
					if(iActEVDC_LBCount==(Integer.parseInt(sEVDC_LBCount))){
						
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Value" , "Values are same", "pass", "Value Displayed" + iActEVDC_LBCount);
					}
					else{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Value" , "values are different", "warn", "Value Displayed on LB page: " + iActEVDC_LBCount );
					}
					
					LoginTestCase.nav_Logout();
					}
					
					catch (Exception e) {
					LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
					}
					       }
					
					/*==============================================================
					TestScript  	: verifyLoadBalancerEditVIPFields()
					Manual TestCase	: QAT1404_WCP_4891_TC_1.0_Load Balancer->Virtual IPs-> Edit VIP
					Description		: Verify that Edit VIP is displayed correctly.
					Author 			: Priyanka
					Creation Date 	: 06/30/2016
					Pre-Requisites	:
					Release Name    : Galen
					Revision History:
					==============================================================*/
					@Test(priority=16)
					public void  verifyLoadBalancerEditVIPFields()
					{
						WebDriver driver = WebDriverUtil.getDriver();
						PageFactory.initElements(driver, LoadBalancer);
						PageFactory.initElements(driver, Home);
						PageFactory.initElements(driver, EVDC_OverviewPF);
						
						try {
					String sEVDC_LBCount;
					/*Automation note: error message is displayed for specific scenario. We don't have org that meats this criteria now.*/
					FrameworkUtil.sTestCaseName = "verifyLoadBalancerEditVIPFields()";
					FrameworkUtil.sManualTestCaseName=" QAT1404_WCP_4891_TC_1.0_Load Balancer->Virtual IPs-> Edit VIP";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					//LoginTestCase.LoginAsHawkeyeUser();
					LoginTestCase.LoginAsAgentUser();
					LoadBalancersTestCase.NavigatingToLoadBalancerPage();
					WebObjectUtil.explicitWait(5);
					WebObjectUtil.clickElement(LoadBalancer.getNavVirtualIpTab());
					String sExpander = WebObjectUtil.getLocatorValueFromProperty("EVDC.LOADBALANCER.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
					WebElement wExpander = WebObjectUtil.GetWebElement("XPATH", sExpander, "Expand Arrow");
					//WebObjectUtil.clickElement(wExpander);
					wExpander.click();
					WebObjectUtil.explicitWait(5);
					String sEditBtn = WebObjectUtil.getLocatorValueFromProperty("EVDC.LOADBALANCER.EXPANDER.EDIT.BUTTON", "PARAMETER_ROWNUMBER", 1 +"");
					WebElement wEditBtn = WebObjectUtil.GetWebElement("XPATH", sEditBtn, "EditButton");
					WebObjectUtil.clickElement(wEditBtn);
					WebObjectUtil.explicitWait(3);
					
					WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_EditVIPPoolNamedropdownfield());
					WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_EditVIPServerProfiledropdownfield());
					WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_EditVIPClientProfiledropdownfield());
					WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_EditVIPServicePortdropdownfield());
					WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_EditVIPProfiledropdownfield());
					WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_EditVIPDefaultPersistencedropdownfield());
					WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_EditVIPFallBackProfiledropdownfield());
					WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_EditVIPResetButton());
					WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_EditVIPSubmitButton());
					WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_EditVIPCloseButton());
					WebObjectUtil.clickElement(LoadBalancer.getNav_EditVIPCloseButton());
					WebObjectUtil.explicitWait(3);
					LoginTestCase.nav_Logout();
					}
					
					catch (Exception e) {
					LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
					}
					       }
					

					/*==============================================================
					TestScript  	: verifyLoadBalancerAddVIPFields()
					Manual TestCase	: QAT1398_WCP_4890_TC_1.0_Load Balancer->Virtual IPs-> Add VIP page
					Description		: Verify that ADD VIP page is displayed correctly.
					Author 			: Priyanka
					Creation Date 	: 06/30/2016
					Pre-Requisites	:
					Release Name    : Galen
					Revision History:
					==============================================================*/
					@Test(priority=17)
					public void  verifyLoadBalancerAddVIPFields()
					{
						WebDriver driver = WebDriverUtil.getDriver();
						PageFactory.initElements(driver, LoadBalancer);
						PageFactory.initElements(driver, Home);
						PageFactory.initElements(driver, EVDC_OverviewPF);
						
						try {
					String sEVDC_LBCount;
					/*Automation note: error message is displayed for specific scenario. We don't have org that meats this criteria now.*/
					FrameworkUtil.sTestCaseName = "verifyLoadBalancerAddVIPFields()";
					FrameworkUtil.sManualTestCaseName="QAT1398_WCP_4890_TC_1.0_Load Balancer->Virtual IPs-> Add VIP page";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					//LoginTestCase.LoginAsHawkeyeUser();
					LoginTestCase.LoginAsAgentUser();
					LoadBalancersTestCase.NavigatingToLoadBalancerPage();
					WebObjectUtil.explicitWait(5);
					WebObjectUtil.clickElement(LoadBalancer.getNavVirtualIpTab());
					String sExpander = WebObjectUtil.getLocatorValueFromProperty("EVDC.LOADBALANCER.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
					WebElement wExpander = WebObjectUtil.GetWebElement("XPATH", sExpander, "Expand Arrow");
					//WebObjectUtil.clickElement(wExpander);
					wExpander.click();
					WebObjectUtil.explicitWait(5);
					//need to insert Add VIP buttons
					WebObjectUtil.clickElement(LoadBalancer.getNavVirtualIpTab_AddVIPLink());
					WebObjectUtil.explicitWait(5);
					WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_EditVIPPoolNamedropdownfield());
					WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_EditVIPServerProfiledropdownfield());
					WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_EditVIPClientProfiledropdownfield());
					WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_EditVIPServicePortdropdownfield());
					WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_EditVIPProfiledropdownfield());
					WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_EditVIPDefaultPersistencedropdownfield());
					WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_EditVIPFallBackProfiledropdownfield());
					WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_EditVIPResetButton());
					WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_EditVIPSubmitButton());
					WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_EditVIPCloseButton());
					WebObjectUtil.clickElement(LoadBalancer.getNav_EditVIPCloseButton());
					WebObjectUtil.explicitWait(3);
					LoginTestCase.nav_Logout();
					}
					
					catch (Exception e) {
					LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
					}
					       }
					
					
					/*==============================================================
					TestScript  	: verifyLoadBalancerAddVIPFieldsVal()
					Manual TestCase	: QAT-1400_WCP_4890_TC_1.1_Load Balancer->Virtual IPs-> Add VIP page- validation
					Description		: Verify that ADD VIP field validations are displayed correctly.
					Author 			: Priyanka
					Creation Date 	: 06/30/2016
					Pre-Requisites	:
					Release Name    : Galen
					Revision History:
					==============================================================*/
					@Test(priority=17)
					public void  verifyLoadBalancerAddVIPFieldsVal()
					{
						WebDriver driver = WebDriverUtil.getDriver();
						PageFactory.initElements(driver, LoadBalancer);
						PageFactory.initElements(driver, Home);
						PageFactory.initElements(driver, EVDC_OverviewPF);
						
						try {
					//need to implement ADD VIP functionality for completing the test case
							
					String sEVDC_LBCount;
					/*Automation note: error message is displayed for specific scenario. We don't have org that meats this criteria now.*/
					FrameworkUtil.sTestCaseName = "verifyLoadBalancerAddVIPFieldsVal()";
					FrameworkUtil.sManualTestCaseName="QAT1398_WCP_4890_TC_1.0_Load Balancer->Virtual IPs-> Add VIP pageQAT-1400_WCP_4890_TC_1.1_Load Balancer->Virtual IPs-> Add VIP page- validation";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					//LoginTestCase.LoginAsHawkeyeUser();
					LoginTestCase.LoginAsAgentUser();
					LoadBalancersTestCase.NavigatingToLoadBalancerPage();
					WebObjectUtil.explicitWait(5);
					WebObjectUtil.clickElement(LoadBalancer.getNavVirtualIpTab());
					String sExpander = WebObjectUtil.getLocatorValueFromProperty("EVDC.LOADBALANCER.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
					WebElement wExpander = WebObjectUtil.GetWebElement("XPATH", sExpander, "Expand Arrow");
					//WebObjectUtil.clickElement(wExpander);
					wExpander.click();
					WebObjectUtil.explicitWait(5);
					//need to insert Add VIP buttons
					WebObjectUtil.clickElement(LoadBalancer.getNavVirtualIpTab_AddVIPLink());
					WebObjectUtil.explicitWait(5);
					WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_EditVIPPoolNamedropdownfield());
					WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_EditVIPServerProfiledropdownfield());
					WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_EditVIPClientProfiledropdownfield());
					WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_EditVIPServicePortdropdownfield());
					WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_EditVIPProfiledropdownfield());
					WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_EditVIPDefaultPersistencedropdownfield());
					WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_EditVIPFallBackProfiledropdownfield());
					WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_EditVIPResetButton());
					WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_EditVIPSubmitButton());
					WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_EditVIPCloseButton());
					WebObjectUtil.clickElement(LoadBalancer.getNav_EditVIPCloseButton());
					WebObjectUtil.explicitWait(3);
					LoginTestCase.nav_Logout();
					}
					
					catch (Exception e) {
					LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
					}
					       }
					
				
					//###################################Methods#######################################

					
					
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
					PageFactory.initElements(driver,DNS);
					
					
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
					
					//update each @test result in custom result file
					@AfterMethod
					public static void afterEachMethod(){
					FrameworkUtil.updateTestCaseStatusinResult();
						}
					}
