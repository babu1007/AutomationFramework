package com.whs.navigator.testcases.dev.old;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.SmokeTestPageFactory;

public class SmokeTestCase {
	public static SmokeTestPageFactory smokeTest = new SmokeTestPageFactory();
	static String sSummaryURL;
	
	
	@Test(priority=1)
	public void homePagePortletsLinks(){
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, smokeTest);
		
		try {
			FrameworkUtil.sTestCaseName = "homePageportletsLinks";
			FrameworkUtil.sManualTestCaseName="SmokeTest-Verify Home Page portlets & Links";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
/*			
			String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.USERID");
			String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.PASSWORD");
			LoginTestCase.nav_Login(sUserName, sPassword);
*/
			WebDriverUtil.getDriver().get(sSummaryURL);
			
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_DevicesAlertsPortlet());
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_DevicesAlertsLink());
			
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_TicketsPortlet());
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_TicketsLink());
			
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_DraasPortlet());
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_DraasLink());
			
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_BandwidthPortlet());
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_BandwidthLink());
			
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_AnnouncementsPortlet());
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_AnnouncementsLink());
			
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_ContactPortlet());
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_ContactUsLink());
			
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_Feedbackportlet());
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_FeedbackLink());
			
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_EVDCPortlet());
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_EVDCLink());

			WebObjectUtil.verifyElementPresent(smokeTest.getNav_PurchaseEVDCLink());
			
			//LoginTestCase.nav_Logout();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		
		
		
	}
	@Test(priority=2)
	public void verifyTicketsPage(){
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, smokeTest);
		
		try {
			FrameworkUtil.sTestCaseName = "verifyTicketsPage";
			FrameworkUtil.sManualTestCaseName="SmokeTest-Verify Tickets Page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			//verifyPageLoading(smokeTest.getNav_TicketsLink(),smokeTest.getNav_SearchByWebList(),"Click on Tickets Link","Verify Ticket Page");
			verifyPageLoading(smokeTest.getNav_TicketsLink(),smokeTest.getNav_CreateTicketLink(),"Click on Tickets Link","Verify Ticket Page");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		
	}
	
	
	@Test(priority=3)
	public void verifyDRaaSPage(){
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, smokeTest);
		
		try {
			FrameworkUtil.sTestCaseName = "verifyDRaaSPage";
			FrameworkUtil.sManualTestCaseName="SmokeTest-Verify DRaaS Page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			//verifyPageLoading(smokeTest.getNav_DraasLink(),smokeTest.getNav_HosBasedReplicationText(),"Click on DRaaS Link","Verify DRaaS Page");
			verifyPageLoading(smokeTest.getNav_DraasLink(),smokeTest.getNav_MoreDraasProducts(),"Click on DRaaS Link","Verify DRaaS Page");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		
	}
	
	@Test(priority=4)
	public void verifyBandwidthPage(){
		
		String sMsg = "You do not have any bandwidth reports available. If you wish to have a bandwidth report, please submit a ticket.";
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, smokeTest);
		
		try {
			FrameworkUtil.sTestCaseName = "verifyBandwidthPage";
			FrameworkUtil.sManualTestCaseName="SmokeTest-Verify Bandwidth Page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			//verifyPageLoading(smokeTest.getNav_BandwidthLink(),smokeTest.getNav_NetworkFirstGraphHeader(),"Click on Bandwidth Link","Verify Bandwidth Page");
			WebDriverUtil.getDriver().get(sSummaryURL);
			WebDriverUtil.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

			WebObjectUtil.clickElement(smokeTest.getNav_BandwidthLink());
			WebDriverUtil.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			WebDriverUtil.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			if (WebObjectUtil.isElementPresent(smokeTest.getNav_NetworkFirstGraphHeader())){
				WebObjectUtil.verifyElementPresent(smokeTest.getNav_NetworkFirstGraphHeader());
			}else if (WebObjectUtil.VerifyTextOnPage(sMsg)) {
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Verify Bandwidth page" , "Bandwidth msg", "warn", "Bandwidth msg displayed like : " + sMsg);
			}else{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Verify Bandwidth page" , "Bandwidth msg/Element", "fail", "Bandwidth page NOT loaded as expected" );	
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		
	}
	
	@Test(priority=5)
	public void verifyAnnouncementsPage(){
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, smokeTest);
		
		try {
			FrameworkUtil.sTestCaseName = "verifyAnnouncementsPage";
			FrameworkUtil.sManualTestCaseName="SmokeTest-Verify Announcements Page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			//verifyPageLoading(smokeTest.getNav_AnnouncementsLink(),smokeTest.getNav_ShowCalendarBtn(),"Click on Announcements Link","Verify Announcements Page");
			verifyPageLoading(smokeTest.getNav_AnnouncementsLink(),smokeTest.getNav_ViewCalender(),"Click on Announcements Link","Verify Announcements Page");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		
	}
	
	
	
	@Test(priority=6)
	public void verifyContactUsPage(){
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, smokeTest);
		
		try {
			FrameworkUtil.sTestCaseName = "verifyContactUsPage";
			FrameworkUtil.sManualTestCaseName="SmokeTest-Verify ContactUs Page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			verifyPageLoading(smokeTest.getNav_ContactUsLink(),smokeTest.getNav_CreateTicketHeader(),"Click on ContactUs Link","Verify ContactUs Page");
			WebObjectUtil.clickElement(smokeTest.getNav_CreateTicketCancelBtn());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		
	}
	
	@Test(priority=7)
	public void verifyFeedbackPage(){
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, smokeTest);
		
		try {
			FrameworkUtil.sTestCaseName = "verifyFeedbackPage";
			FrameworkUtil.sManualTestCaseName="SmokeTest-Verify Feedback Page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			verifyPageLoading(smokeTest.getNav_FeedbackLink(),smokeTest.getNav_FeedbackHeader(),"Click on Feedback Link","Verify Feedback Page");
			WebObjectUtil.clickElement(smokeTest.getNav_FeedbackCancelBtn());

			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		
	}
	
	@Test(priority=8)
	public void verifyReportsPage(){
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, smokeTest);
		
		try {
			FrameworkUtil.sTestCaseName = "verifyReportsPage";
			FrameworkUtil.sManualTestCaseName="SmokeTest-Verify Reports Page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			/*WebObjectUtil.ClickAndMouseHover(smokeTest.getNav_MonitoringTab());
			WebObjectUtil.clickAndVerifyUrl(smokeTest.getNav_DeviceMonitorMenuLink(),(String)FrameworkUtil.dictPropertyData.get("NAV.REPORTSMENULINK.URL"));
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_NetworkReportsLink());
*/
			ClickMenuAndverifyPageLoading(smokeTest.getNav_MonitoringMenu(),smokeTest.getNav_ReportsSubMenuLink(),smokeTest.getNav_NetworkReportsLink(),"Monitoring Menu","Reports SubMenuLink","NetworkReportsLink");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		
	}
	
	//@Test(priority=9)
	public void verifyCloudMigrationsPage(){
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, smokeTest);
		
		try {
			FrameworkUtil.sTestCaseName = "verifyCloudMigrationsPage";
			FrameworkUtil.sManualTestCaseName="SmokeTest-Verify Cloud Migrations Page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
/*			WebObjectUtil.ClickAndMouseHover(smokeTest.getNav_ServicesMenu());
			WebObjectUtil.clickElement(smokeTest.getNav_CloudMigrationsSubMenuLink());
			System.out.println(driver.findElement(By.tagName("body")).getText());*/
			
			//ClickMenuAndverifyPageLoading(smokeTest.getNav_ServicesMenu(),smokeTest.getNav_CloudMigrationsSubMenuLink(),smokeTest.getNav_CloudMigrationsHeader(),"Services Menu","CloudMigrations SubMenuLink","CloudMigrationsHeader");
			ClickMenuAndverifyPageLoading(smokeTest.getNav_ServicesMenu(),smokeTest.getNav_CloudMigrationsSubMenuLink(),smokeTest.getNav_CloudMigrationsHeaderImg(),"Services Menu","CloudMigrations SubMenuLink","CloudMigrationsHeader");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		
	}
	
	@Test(priority=10)
	public void verifyDNSPage(){
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, smokeTest);
		
		try {
			FrameworkUtil.sTestCaseName = "verifyDNSPage";
			FrameworkUtil.sManualTestCaseName="SmokeTest-Verify DNS Page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			//ClickMenuAndverifyPageLoading(smokeTest.getNav_ServicesMenu(),smokeTest.getNav_DNSSubMenuLink(),smokeTest.getNav_AddVMLink(),"Services Menu","DNS SubMenuLink","AddVMLink");
			ClickMenuAndverifyPageLoading(smokeTest.getNav_ServicesMenu(),smokeTest.getNav_DNSSubMenuLink(),smokeTest.getNav_DNSTableHeader(),"Services Menu","DNS SubMenuLink","AddVMLink");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		
	}
	
	
	@Test(priority=11)
	public void verifyDocumentsPage(){
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, smokeTest);
		
		try {
			FrameworkUtil.sTestCaseName = "verifyDocumentsPage";
			FrameworkUtil.sManualTestCaseName="SmokeTest-Verify Documents Page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			ClickMenuAndverifyPageLoading(smokeTest.getNav_SupportMenuLink(),smokeTest.getNav_DocumentsSubMenuLink(),smokeTest.getNav_DocumentsImg(),"Support Menu","Documents SubMenuLink","Documents Img");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		
	}
	
	
	
	@Test(priority=12)
	public void verifyCloudAPIPage(){
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, smokeTest);
		
		try {
			FrameworkUtil.sTestCaseName = "verifyCloudAPIPage";
			FrameworkUtil.sManualTestCaseName="SmokeTest-Verify Cloud API Page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			//ClickMenuAndverifyPageLoading(smokeTest.getNav_ServicesMenu(),smokeTest.getNav_CloudAPISubMenuLink(),smokeTest.getNav_CloudAPIHeader(),"Services Menu","CloudAPI SubMenuLink","CloudAPI Header");
			ClickMenuAndverifyPageLoading(smokeTest.getNav_ServicesMenu(),smokeTest.getNav_CloudAPISubMenuLink(),smokeTest.getNav_CloudAPIHeaderImg(),"Services Menu","CloudAPI SubMenuLink","CloudAPI Header Img");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		
	}
	
	
	@Test(priority=13)
	public void verifyDDoSPage(){
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, smokeTest);
		
		try {
			FrameworkUtil.sTestCaseName = "verifyDDoSPage";
			FrameworkUtil.sManualTestCaseName="SmokeTest-Verify DDoS Mitigation Page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			//ClickMenuAndverifyPageLoading(smokeTest.getNav_SecurityMenuLink(),smokeTest.getNav_DDoSMitigationSubMenuLink(),smokeTest.getNav_DDoSHeader(),"Security Menu","DDoSMitigation SubMenuLink","DDoSMitigation Header");
			ClickMenuAndverifyPageLoading(smokeTest.getNav_SecurityMenuLink(),smokeTest.getNav_DDoSMitigationSubMenuLink(),smokeTest.getNav_DDoSHeaderImg(),"Security Menu","DDoSMitigation SubMenuLink","DDoSMitigation Header");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		
	}
	
	@Test(priority=14)
	public void verifyCloudAVPage(){
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, smokeTest);
		
		try {
			FrameworkUtil.sTestCaseName = "verifyCloudAVPage";
			FrameworkUtil.sManualTestCaseName="SmokeTest-Verify Cloud AV Page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			//ClickMenuAndverifyPageLoading(smokeTest.getNav_SecurityMenuLink(),smokeTest.getNav_CloudAVSubMenuLink(),smokeTest.getNav_CloudAVHeader(),"Security Menu","Cloud AV SubMenuLink","Cloud AV Header");
			ClickMenuAndverifyPageLoading(smokeTest.getNav_SecurityMenuLink(),smokeTest.getNav_CloudAVSubMenuLink(),smokeTest.getNav_CloudAVHeaderImg(),"Security Menu","Cloud AV SubMenuLink","Cloud AV Header");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		
	}
	
	
	@Test(priority=15)
	public void verifyAccountSettingsPage(){
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, smokeTest);
		
		try {
			FrameworkUtil.sTestCaseName = "verifyAccountSettingsPage";
			FrameworkUtil.sManualTestCaseName="SmokeTest-Verify Account Settings Page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			ClickMenuAndverifyPageLoading(smokeTest.getNav_AccountMenuLink(),smokeTest.getNav_AccountSettingsSubMenuLink(),smokeTest.getNav_ControlPanelHeader(),"Account Menu","Account Settings SubMenuLink","Control Panel Header");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		
	}
	
	
	@Test(priority=16)
	public void verifyEscalationPage(){
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, smokeTest);
		
		try {
			FrameworkUtil.sTestCaseName = "verifyEscalationPage";
			FrameworkUtil.sManualTestCaseName="SmokeTest-Verify Escalation List Page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			ClickMenuAndverifyPageLoading(smokeTest.getNav_AccountMenuLink(),smokeTest.getNav_EscalationListSubMenuLink(),smokeTest.getNav_EscalationHeader(),"Account Menu","Escalation List SubMenuLink","Escalation Header");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		
	}
	
	
	@Test(priority=17)
	public void verifyDeviceMonitorEM7Page(){
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, smokeTest);
		
		try {
			FrameworkUtil.sTestCaseName = "verifyDeviceMonitorEM7Page";
			FrameworkUtil.sManualTestCaseName="SmokeTest-Verify DeviceMonitor EM7 Page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			verifyPageLoading(smokeTest.getNav_DevicesAlertsLink(),smokeTest.getNav_EM7_SignInBtn(),"Click on Devices/Alerts Link","Verify Device Monitor EM7 Login Page");
			driver.navigate().back();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		
	}
	
	
	@Test(priority=18)
	public void verifyBuildReqPage(){
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, smokeTest);
		
		try {
			FrameworkUtil.sTestCaseName = "verifyBuildReqPage";
			FrameworkUtil.sManualTestCaseName="SmokeTest-Verify BuildReq(EM7 Login) Page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			//ClickMenuAndverifyPageLoading(smokeTest.getNav_SupportMenuLink(),smokeTest.getNav_BuildReq_Forms_SubMenuLink(),smokeTest.getNav_EM7LoginText(),"Support Menu","Build Requirements (Forms) SubMenuLink","EM7 Login Text");
			ClickMenuAndverifyPageLoading(smokeTest.getNav_SupportMenuLink(),smokeTest.getNav_BuildReq_Forms_SubMenuLink(),smokeTest.getNav_BuildReqPageHeader(),"Support Menu","Build Requirements (Forms) SubMenuLink","Build Requirements page Header");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		
	}
	
	
	@Test(priority=19)
	public void verifyFirewallPage(){
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, smokeTest);
		
		try {
			FrameworkUtil.sTestCaseName = "verifyFirewallPage";
			FrameworkUtil.sManualTestCaseName="SmokeTest-Verify Firewall Page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			WebDriverUtil.getDriver().get(sSummaryURL);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement wEVDCname;
			String sEVDCNameTestData;
			sEVDCNameTestData = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.NAME");
			wEVDCname = getEVDCNameAsWebElement(sEVDCNameTestData);
			wEVDCname.click();
				
			//WebObjectUtil.clickElement(smokeTest.getNav_EVDCLink());
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebObjectUtil.clickElement(smokeTest.getNav_FirewallLink());
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_EVDCselectorList());
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_FeedbackArea());
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_CSVicon());
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_PDFicon());
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_FirewallTable());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		
	}
	
	
	
	@Test(priority=20)
	public void verifyCatalogsPage(){
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, smokeTest);
		
		try {
			FrameworkUtil.sTestCaseName = "verifyCatalogsPage";
			FrameworkUtil.sManualTestCaseName="SmokeTest-Verify Catalogs Page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			WebDriverUtil.getDriver().get(sSummaryURL);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			WebElement wEVDCname;
			String sEVDCNameTestData;
			sEVDCNameTestData = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.NAME");
			wEVDCname = getEVDCNameAsWebElement(sEVDCNameTestData);
			wEVDCname.click();
			
			//WebObjectUtil.clickElement(smokeTest.getNav_EVDCLink());
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebObjectUtil.clickElement(smokeTest.getNav_CatalogsLink());
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_EVDCselectorList());
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_FeedbackArea());
			
			WebObjectUtil.clickElement(smokeTest.getNav_WindstreamObjectsTab());
			WebObjectUtil.explicitWait(3);
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_WHSObjCSVicon());
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_WHSObjPDFicon());
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_WindstreamObjectsTable());
			
			WebObjectUtil.clickElement(smokeTest.getNav_PrivateObjectsTab());
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_PvtObjCSVicon());
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_PvtObjPDFicon());
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_PrivateObjectsTable());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		
	}
	
	@Test(priority=21)
	public void verifyVMPage(){
		WebElement wEVDCname;
		String sEVDCNameTestData;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, smokeTest);
		
		try {
			FrameworkUtil.sTestCaseName = "verifyVMPage";
			FrameworkUtil.sManualTestCaseName="SmokeTest-Verify Virtual Machine Page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			WebDriverUtil.getDriver().get(sSummaryURL);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			sEVDCNameTestData = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.NAME");
			wEVDCname = getEVDCNameAsWebElement(sEVDCNameTestData);
			wEVDCname.click();
			
			//WebObjectUtil.clickElement(smokeTest.getNav_EVDCLink());
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebObjectUtil.clickElement(smokeTest.getNav_VMLink());
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_EVDCselectorList());
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_FeedbackArea());
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_CSVicon());
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_PDFicon());
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_AddVMLink());
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_VMtable());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		
	}
	
	
	@Test(priority=22)
	public void verifyEVDCOverviewPage(){
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, smokeTest);
		
		try {
			FrameworkUtil.sTestCaseName = "verifyEVDCOverviewPage";
			FrameworkUtil.sManualTestCaseName="SmokeTest-Verify EVDC Overview Page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			WebDriverUtil.getDriver().get(sSummaryURL);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			WebElement wEVDCname;
			String sEVDCNameTestData;
			sEVDCNameTestData = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.NAME");
			wEVDCname = getEVDCNameAsWebElement(sEVDCNameTestData);
			wEVDCname.click();
			

			
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_EVDCselectorList());
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_VMportlet());
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_Catalogsportlet());
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_ComputeStatisticsportlet());
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_Storageportlet());
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_CloudAvportlet());
			//WebObjectUtil.verifyElementPresent(smokeTest.getNav_CloudMigrationsportlet());
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_Firewallportlet());
			//WebObjectUtil.verifyElementPresent(smokeTest.getNav_Feedbackportlet());
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_Bandwidthportlet());
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_Networksportlet());
			WebObjectUtil.verifyElementPresent(smokeTest.getNav_LoadBalancersportlet());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		
	}
	
	
	
	@Test(priority=24)
	public void verifyVCloudDirectorLoginPage(){
		
		String ParentWindowName;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, smokeTest);
		
		try {
			FrameworkUtil.sTestCaseName = "verifyVCloudDirectorLoginPage";
			FrameworkUtil.sManualTestCaseName="SmokeTest-Verify vCloud Director login Page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			WebDriverUtil.getDriver().get(sSummaryURL);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebObjectUtil.clickElement(smokeTest.getNav_vCloudDirectorLink());
			
			ParentWindowName = driver.getWindowHandle();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebObjectUtil.switchToWindow(2, null);
			//WebObjectUtil.switchToWindow(0, "VMware vCloud Director");
			WebObjectUtil.compareString(driver.getTitle(), (String)FrameworkUtil.dictPropertyData.get("NAV.CLOUD.WINDOW.TITLE"), true);
			WebObjectUtil.compareString(driver.getCurrentUrl(), (String)FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLEUSER.URL"), true);
			//close the second window
			if (!driver.getWindowHandle().equalsIgnoreCase(ParentWindowName)){
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.close();
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Close Window", "done", "Close the new window");
			}
			driver.switchTo().window(ParentWindowName);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		
	}
	
	
	public void verifyPageLoading(WebElement homePageElement, WebElement verifyElement,String sHomePageObjectName,String sVerifyObjectName){
		
		try {
			WebDriverUtil.getDriver().get(sSummaryURL);
			WebDriverUtil.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			FrameworkUtil.sElementName = sHomePageObjectName;
			WebObjectUtil.clickElement(homePageElement);
			WebDriverUtil.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			FrameworkUtil.sElementName = sVerifyObjectName;
			WebObjectUtil.verifyElementPresent(verifyElement);
			WebDriverUtil.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		
	}
	
	public void ClickMenuAndverifyPageLoading(WebElement menuElement,WebElement subMenuElement, WebElement verifyElement,String sMenuElementName,String sSubMenuElement, String sVerifyObjectName){
		
		try {
			WebDriverUtil.getDriver().get(sSummaryURL);
			WebDriverUtil.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			FrameworkUtil.sElementName = sMenuElementName;
			WebObjectUtil.ClickAndMouseHover(menuElement);
			FrameworkUtil.sElementName = sSubMenuElement;
			WebObjectUtil.clickElement(subMenuElement);
			WebObjectUtil.explicitWait(10);
			WebDriverUtil.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			FrameworkUtil.sElementName = sVerifyObjectName;
			WebObjectUtil.verifyElementPresent(verifyElement);
			WebDriverUtil.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		
	}
		
	
	//@Test(priority=100)
		public void verifyPermissionsPage(){
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, smokeTest);
			
			try {
				FrameworkUtil.sTestCaseName = "verifyPermissionsPage";
				FrameworkUtil.sManualTestCaseName="SmokeTest-Verify Permissions Page";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
				String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
				String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
				LoginTestCase.nav_Login(sUserName, sPassword);
		
				ClickMenuAndverifyPageLoading(smokeTest.getNav_AccountMenuLink(),smokeTest.getNav_PermissionsSubMenuLink(),smokeTest.getNav_UsersTab(),"Account Menu","Permissions SubMenuLink","User tab");
				
				LoginTestCase.nav_Logout();
				FrameworkUtil.updateTestCaseStatusinResult();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
			}
			
		}
		
	public static WebElement getEVDCNameAsWebElement(String sEVDCName){
		String sEVDCNameRunnTime,sEVDCLocator;
		WebElement wEVDCName;
		sEVDCLocator = (String) FrameworkUtil.dictDynamicPagePactory.get("EVDC.NAME");
		wEVDCName = WebObjectUtil.GetWebElement("xpath", sEVDCLocator, "EVDC Name");
		for (WebElement wEVDC : WebObjectUtil.webElementsList){
			sEVDCNameRunnTime = wEVDC.getText();
			if(sEVDCNameRunnTime.equalsIgnoreCase(sEVDCName)){
				wEVDCName = wEVDC;
				break;
			}
		}
		return wEVDCName;
	}	
		
	//update each @Test result in custom result file
	@AfterMethod
	public void afterEachMethod(){
		FrameworkUtil.updateTestCaseStatusinResult();
		
	}
	
	@BeforeTest
	public void beforeTest(){
		
		FrameworkUtil.sTestCaseName = "Login";
		FrameworkUtil.sManualTestCaseName="SmokeTest-Login to Navigator";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.USERID");
		String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.PASSWORD");
		LoginTestCase.nav_Login(sUserName, sPassword);
		
		sSummaryURL = (String)FrameworkUtil.dictPropertyData.get("NAV.QA.URL");
		//sSummaryURL = smokeTest.getNav_HomeBreadScrumb().getAttribute("href");
		//sSummaryURL=sSummaryURL.replace("/home", "/navigator");
		WebDriverUtil.getDriver().get(sSummaryURL);
		
		FrameworkUtil.updateTestCaseStatusinResult();
		
	}
	
	@AfterTest
	public void afterTest(){
		FrameworkUtil.sTestCaseName = "Logout";
		FrameworkUtil.sManualTestCaseName="SmokeTest-Logout Navigator";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		LoginTestCase.nav_Logout();
		FrameworkUtil.updateTestCaseStatusinResult();
		
		verifyPermissionsPage();
		
	}
	
	
}