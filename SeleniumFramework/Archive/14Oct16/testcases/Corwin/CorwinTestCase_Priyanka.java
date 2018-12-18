package com.whs.navigator.testcases.Corwin;
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
import com.whs.navigator.pagefactory.HomePageFactory_old;
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
import com.whs.navigator.testcases.LoginTestCase_Old1;
import com.whs.navigator.testcases.NavigatorCommonMethods;
import com.whs.navigator.pagefactory.PhysicalServicesPageFactory;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;

public class CorwinTestCase_Priyanka {
	public static HomePageFactory_old Home = new HomePageFactory_old();
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
	
	/*==============================================================
	TestScript  	: verifyCreateTktfrmDiffSystems
	Manual TestCase	: QAT-1462-WCP_3415_TC_1.3_Ticket watchers_Clone Ticket
	Description		: Verify when a ticket is cloned from an existing ticket, 
	                  users that were added to original ticket also appear as 
	                  watchers for this cloned ticket in EM7.
	Author 			: Priyanka
	Creation Date 	: 06/08/2016
	Pre-Requisites	:
	Release Name    : Corwin
	Revision History:
	==============================================================*/
		@Test(priority=1)
		public void verifyCreateTktEntity02Usr()
		{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, Ticket);
			PageFactory.initElements(driver, Home);
			
			try {
				String sModuleName=(String)FrameworkUtil.dictPropertyData.get("NAV.CREATE.TICKET.RELEASE.NAME");
				FrameworkUtil.sTestCaseName = "verifyCreateTktEntity02Usr";
				FrameworkUtil.sManualTestCaseName="QAT-1462-WCP_3415_TC_1.3_Ticket watchers_Clone Ticket";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
                LoginTestCase_Old1.LoginAsEntity02User();
                WebObjectUtil.explicitWait(5);
                TicketTestCase.navigateToCreateTicketPage();
                NavigatorCommonMethods.submitDialogForCreateTicket(sModuleName);
				LoginTestCase_Old1.nav_Logout();
			}

			catch (Exception e) {
						LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
					
					}
					}

		/*==============================================================
		TestScript  	: verifyEBFooterLongOrgName
		Manual TestCase	: QAT-1348-WCP_4925_TC_Entity Browser_Longer org names display in EB footer
		Description		: Verify that when an Org has longer names, it is displayed correctly in EB footer
		Author 			: Priyanka
		Creation Date 	: 06/08/2016
		Pre-Requisites	:
		Release Name    : Corwin
		Revision History:
		==============================================================*/
			@Test(priority=2)
			public void verifyEBFooterLongOrgName()
			{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, Ticket);
				PageFactory.initElements(driver, Home);
				PageFactory.initElements(driver, EBPanel);
				
				try {
					String sOrgNameToSelect=(String)FrameworkUtil.dictPropertyData.get("NAV.EBPANEL.ORG.SELECT.NAME");
					
					FrameworkUtil.sTestCaseName = "verifyEBFooterLongOrgName";
					FrameworkUtil.sManualTestCaseName=" QAT-1348-WCP_4925_TC_Entity Browser_Longer org names display in EB footer";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	             
					LoginTestCase_Old1.LoginAsRoleAUser();
					WebObjectUtil.explicitWait(5);
					WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
					//EntityBrowserTestCase.navSelectOrgFromEBPanel(sOrgNameToSelect);
					EntityBrowserTestCase.selectOrgFromAllLevelsEB(sOrgNameToSelect,"","","");
					WebObjectUtil.explicitWait(3);
					WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
					WebObjectUtil.explicitWait(3);
					WebObjectUtil.getToolTipsMsg(EBPanel.getNav_EntityBrowserLink(), sOrgNameToSelect);
					
					LoginTestCase_Old1.nav_Logout();
				}

				catch (Exception e) {
							LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
						
						}
						}
			
			/*==============================================================
			TestScript  	: verifyEVDCNameOnHomePage
			Manual TestCase	: QAT-654-WCP_5051_TC_1.0_Landing page EVDC Text Changes
			Description		: Verify that the text on EVDC for Shared is changed to EVDC.
			Author 			: Priyanka
			Creation Date 	: 06/08/2016
			Pre-Requisites	:
			Release Name    : Corwin
			Revision History:
			==============================================================*/
				@Test(priority=3)
				public void verifyEVDCNameOnHomePage()
				{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver, Ticket);
					PageFactory.initElements(driver, Home);
					PageFactory.initElements(driver, EBPanel);
					
					try {
						String sEVDCName,sEVDCText;
						sEVDCName=(String)FrameworkUtil.dictPropertyData.get("NAV.PRIVATE.CHANGE.TO.EVDC");
						FrameworkUtil.sTestCaseName = "verifyEVDCNameOnHomePage";
						FrameworkUtil.sManualTestCaseName=" QAT-654-WCP_5051_TC_1.0_Landing page EVDC Text Changes";
						FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		             
						LoginTestCase_Old1.LoginAsQaautoAUser();
						WebObjectUtil.explicitWait(5);
						/*WebObjectUtil.scrollToElement(Home.getNav_HomeEVDCPortlet());
						WebObjectUtil.explicitWait(5);*/
						WebObjectUtil.verifyElementPresent(Home.getNav_EVDCText());
						sEVDCText=(Home.getNav_EVDCText()).getText();
						 if(sEVDCName.contains(sEVDCText))
				           {
				        	   FrameworkUtil.updateCustomResultBasedOnStatus(true, "Shared Value has been changed to EVDC");
				           }
				           else{
				        	   FrameworkUtil.updateCustomResultBasedOnStatus(false, "Shared Value has not been changed to EVDC");
				           }
						
						LoginTestCase_Old1.nav_Logout();
					}

					catch (Exception e) {
								LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
							
							}
							}
					
				/*==============================================================
				TestScript  	: VerifyPhysicalDCPortlet
				Manual TestCase	: QAT-1473-WCP_4381_TC_1.4_White List for Physical DC portlet on landing page
				Description		: Verify the Physical DC portlet displays on landing page only if the org is whitelisted. 
				Author 			: Priyanka
				Creation Date 	: 06/08/2016
				Pre-Requisites	:
				Release Name    : Corwin
				Revision History:
				==============================================================*/
					@Test(priority=4)
					public void VerifyPhysicalDCPortlet()
					{
						WebDriver driver = WebDriverUtil.getDriver();
						PageFactory.initElements(driver, Ticket);
						PageFactory.initElements(driver, Home);
						PageFactory.initElements(driver, PDC);
						
						try {
							FrameworkUtil.sTestCaseName = "VerifyPhysicalDCPortlet";
							FrameworkUtil.sManualTestCaseName="QAT-1473-WCP_4381_TC_1.4_White List for Physical DC portlet on landing page";
							FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

						    LoginTestCase_Old1.LoginAsEntity03User();
						    WebObjectUtil.explicitWait(10);
						    WebObjectUtil.scrollToElement(PDC.getNav_PhysicalServicePortletArea());
							WebObjectUtil.verifyElementPresent(PDC.getNav_PhysicalServicePortletArea());
							VerifyPDCIcons();
							LoginTestCase_Old1.nav_Logout();
							LoginTestCase_Old1.LoginAsEntity04User();
							WebObjectUtil.explicitWait(5);
							WebObjectUtil.verifyElementNOTPresent(PDC.getNav_PhysicalServicePortletArea());
							LoginTestCase_Old1.nav_Logout();
						}

						catch (Exception e) {
									LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
									FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
								
								}
								}
		
		/*==============================================================
		TestScript  	: VerifyPhysicalDCPortletData
		Manual TestCase	: QAT-397_QAT-394_QAT_970-WCP_4381_TC_1.1_Physical DC portlet on landing page data display
		                 WCP_4381_TC_1.0_Physical DC portlet on landing page
		                 WCP_4381_TC_1.3_Physical DC portlet on landing page data display for Firewalls, Load Balancers, Servers=-DB Verification
		Description		: Verify the Physical DC portlet displays on landing page only if the org is whitelisted. 
		Author 			: Priyanka
		Creation Date 	: 06/08/2016
		Pre-Requisites	:
		Release Name    : Corwin
		Revision History:
		==============================================================*/
			@Test(priority=5)
			public void VerifyPhysicalDCPortletData()
			{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, Ticket);
				PageFactory.initElements(driver, Home);
				PageFactory.initElements(driver, EBPanel);
				
				try {
					String sActualPortletName,sPortletName,sFirewallCount,sLBCount,sServerCount;
				    sPortletName=(String)FrameworkUtil.dictPropertyData.get("NAV.PDC.PORTLET.NAME");
					FrameworkUtil.sTestCaseName = "VerifyPhysicalDCPortletName";
					FrameworkUtil.sManualTestCaseName="QAT-397-WCP_4381_TC_1.1_WCP_4381_TC_1.0_WCP_4381_TC_1.3_WCP_4381_TC_1.3_";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

				    LoginTestCase_Old1.LoginAsEntity03User();
				    WebObjectUtil.explicitWait(10);
				    WebObjectUtil.scrollToElement(PDC.getNav_PhysicalServicePortletArea());
				    WebObjectUtil.verifyElementPresent(PDC.getNav_PhysicalServicePortletArea());
				    sActualPortletName=(PDC.getNav_PhysicalServicesHeaderTitle()).getText().trim();
				    if(sPortletName.equalsIgnoreCase(sActualPortletName))
			           {
			        	   FrameworkUtil.updateCustomResultBasedOnStatus(true, "Shared Value has been changed to EVDC");
			           }
			           else{
			        	   FrameworkUtil.updateCustomResultBasedOnStatus(false, "Shared Value has not been changed to EVDC");
			           }
				    WebObjectUtil.verifyElementPresent(PDC.getNav_PDCFirewallCount());
				    WebObjectUtil.verifyElementPresent(PDC.getNav_PDCLoadBalancersCount());
				    WebObjectUtil.verifyElementPresent(PDC.getNav_PDCServersCount());
				    VerifyPDCIcons();
				    sFirewallCount=PDC.getNav_PDCFirewallCount().getText();
				    sLBCount=PDC.getNav_PDCLoadBalancersCount().getText();
				    sServerCount=PDC.getNav_PDCServersCount().getText();
				    FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Firewall Count is"+""+sFirewallCount, "LoadBalancer Count is"+""+sLBCount, "Server Count is : " + sServerCount);
				    LoginTestCase_Old1.nav_Logout();
				}

				catch (Exception e) {
							LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
						
						}
						}
			
					
				
						
	//#######################################METHODS####################################
						
						/*==============================================================
						Method Name       : VerifyPDCIcons
						Description       : it will verify that user can not see Ticket Page
						Author            : Priyanka Rachupalli
						Creation Date     : 11/23/2015
						Pre-Requisites    :
						Release           : Corwin
						Revision History  :
						==============================================================*/
						public static void VerifyPDCIcons()
						{
							WebDriver driver = WebDriverUtil.getDriver();
							PageFactory.initElements(driver,PDC);
							
							boolean bTicketStatus=true;
							
							try {
								WebObjectUtil.verifyElementPresent(PDC.getNav_PhysicalServicesIcon());
								WebObjectUtil.verifyElementPresent(PDC.getNav_PhysicalServicesHeader());
								WebObjectUtil.verifyElementPresent(PDC.getNav_PhysicalSrvcSecondaryIcon());
								WebObjectUtil.verifyElementPresent(PDC.getNav_PhysicalServicesLocationName());
								WebObjectUtil.verifyElementPresent(PDC.getNav_PhysicalServicesServerIcon());
								WebObjectUtil.verifyElementPresent(PDC.getNav_PhysicalServicesFirewallIcon());
								WebObjectUtil.verifyElementPresent(PDC.getNav_PhysicalServicesLoadBalIcon());
								WebObjectUtil.verifyElementPresent(PDC.getNav_PhysicalServicesStorageIcon());
								WebObjectUtil.verifyElementPresent(PDC.getNav_PhysicalServicesDeviceIcon());
								WebObjectUtil.verifyElementPresent(PDC.getNav_PhysicalServicesDeviceLink());
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
