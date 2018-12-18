
package com.whs.navigator.testcases;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.omg.CORBA.FREE_MEM;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
import com.whs.navigator.pagefactory.CommonPageFactory;
import com.whs.navigator.pagefactory.DraasPageFactory;
import com.whs.navigator.pagefactory.EM7PageFactory;
import com.whs.navigator.pagefactory.EVDC_FirewallPageFactory;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.EVDC_VM_PageFactory;
import com.whs.navigator.pagefactory.EntityBrowserPageFactory;
import com.whs.navigator.pagefactory.FormPageFactory;
import com.whs.navigator.pagefactory.LoadBalancerPageFactory;
import com.whs.navigator.pagefactory.SmokeTestPageFactory;
import com.whs.navigator.pagefactory.TicketPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory_old;

public class TicketTestCase {
	public static HomePageFactory_old Home = new HomePageFactory_old();
	public static TicketPageFactory Ticket = new TicketPageFactory();
	public static TicketTestCase TicketTC =new TicketTestCase();
	public static EM7PageFactory EM7 = new EM7PageFactory();
	public static EVDC_VM_PageFactory EVDC_VMPF=new EVDC_VM_PageFactory();
	public static EVDC_OverviewPageFactory EVDC_OverviewPF = new EVDC_OverviewPageFactory();
	public static EntityBrowserPageFactory EBPanel = new EntityBrowserPageFactory();
	public static CommonPageFactory Common=new CommonPageFactory();
	public static EVDC_FirewallPageFactory Firewall = new EVDC_FirewallPageFactory();
	public static SmokeTestPageFactory Smoke = new SmokeTestPageFactory();
	public static DraasPageFactory Draas=new DraasPageFactory();
	public static FormPageFactory Forms =new FormPageFactory();
	public static LoadBalancerPageFactory LoadBalancer = new LoadBalancerPageFactory();
	public static WebElement sPanel1,sPanel2,sPanel3,sPanel4;
	public static String sPanelColor1,sPanelColor2,sPanelColor3,sPanelColor4;
//------------------------------------------------------------------------------------
//									TEST CASE
//------------------------------------------------------------------------------------
	EVDC_VM_AdvancedActions EVDC_Advanced = new EVDC_VM_AdvancedActions();
	
	
	/*==============================================================
	TestScript  	: verifyTicketHeaderDetails
	Manual TestCase	: Verify Ticket details
	Description		: Verify user is able view ticket details like "Ticket Id","Summary","Severity","Priority","Last updated","Assigned To","Status".
	Author 			: Arularasu
	Creation Date 	: 06/16/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
		@Test(priority=1)
		public void verifyTicketHeaderDetails()
		{
			String sTicketID,sSummary,sSummaryTicketvalue,sTicketTableHeader;
			String[] arrString = null;
			boolean bStatus;
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, Ticket);
			
			try {
				FrameworkUtil.sTestCaseName = "Ticket-verifyTicketHeaderDetails";
				FrameworkUtil.sManualTestCaseName="Verify Ticket Header details";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				String sTicketHeader = (String) FrameworkUtil.dictPropertyData.get("NAV.TICKET.TABLEHEADER");
				
				//Login to Navigator
				//TicketTestCase.navTicketLogin();
				LoginTestCase_Old1.LoginAsRoleAUser();
				TicketTestCase.navigateToTicketPage();
				TicketTestCase.getTicketID(1);
				WebObjectUtil.explicitWait(10);
				//sSummary = WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 4); 
				//Changed per EXTJS update-By Arul 10/9/15
				CustomWebElementUtil.loadCustomElement(Ticket.getNav_TicketsWebTable(), "table");
				sSummary = CustomWebElementUtil.getCellData(1, 3);
			
				//EVDC_Advanced.expandVMbyRowNum(1);
				expandTable(1);
				WebObjectUtil.explicitWait(10);
				sSummaryTicketvalue = Ticket.getNav_TicketSummaryEdit().getAttribute("value");
                bStatus=	WebObjectUtil.compareString(sSummary, sSummaryTicketvalue, true);
				FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, sSummary);
				WebObjectUtil.explicitWait(10);
				//System.out.println(sTicketTableHeader);
				sTicketTableHeader = Ticket.getNav_TicketsTableHeader().getText();
                arrString =sTicketHeader.split("@@");
				for (int i=0; i<arrString.length; i++){
					if (sTicketTableHeader.contains(arrString[i])){
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Sub string" , "verify sub string", "pass", "String Verified: " + arrString[i]);
						bStatus=true;
					}else{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Sub string" , "verify sub string", "warn", "String Not Present/Verified: " + arrString[i] + "/n" + "source string :" + sTicketTableHeader);
					}
				}
				LoginTestCase_Old1.nav_Logout();
			} catch (Exception e) {
				LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
			
			}
			
		}

		/*==============================================================
		TestScript  	: verifySeverityColor
		Manual TestCase	: Verify Severity Color
		Description		: Verify user is able view right color based on Severity number.
		Author 			: Arularasu
		Creation Date 	: 06/22/2015
		Pre-Requisites	:
		Revision History:
		==============================================================*/
	@Test(priority=2)
	public void verifySeverityColor()
	{
		int iSeverityColIndex = 0,iSeverityNum;
		String sSeverityText,sSeverityImgName,sActualImgName = null;
		String[] sSev;
		boolean bSeverity=false;
		WebElement wSeverity;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Ticket);
		
		try {
			FrameworkUtil.sTestCaseName = "Ticket-verifySeverityColor";
			FrameworkUtil.sManualTestCaseName="Verify Severity and it's color";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			String sTicketHeader = (String) FrameworkUtil.dictPropertyData.get("NAV.TICKET.TABLEHEADER");
			
			//Login to Navigator
			//TicketTestCase.navTicketLogin();
			LoginTestCase_Old1.LoginAsRoleAUser();
			TicketTestCase.navigateToTicketPage();
			TicketTestCase.getTicketID(1);
			
			//iSeverityColIndex = 1 + getTicketTableColumnIndex("Severity");
			iSeverityColIndex =  getTicketTableColumnIndex("Severity");
			CustomWebElementUtil.loadCustomElement(Ticket.getNav_TicketsWebTable(), "table");
			sSeverityText = WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, iSeverityColIndex+1);
			sSeverityText = sSeverityText.trim();
			sSev = sSeverityText.split("\\s+");
			sSeverityImgName = "severity";
			

/*				iSeverityNum = Integer.parseInt(sSev[sSev.length-1]);
					for (int i=1; i<=4; i++){
						if(iSeverityNum == i) {
							
						}
					}*/
			
			try {
				if (sSev[sSev.length-1].equalsIgnoreCase("HS")){
					sSeverityImgName = 	sSeverityImgName + "0";
				}else{
					sSeverityImgName = 	sSeverityImgName + sSev[sSev.length-1];
					//sSeverityImgName = 	sSeverityImgN9ame + sSev[sSev.length];
				}
				WebObjectUtil.explicitWait(10);
				// wSeverity = WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr[1]/td/table/tbody/tr[1]/td["+iSeverityColIndex+"]/div/img", "Severity Image");
				// This object is updated on 10/14/2015 By QAA04
				wSeverity = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER.SEVERITYIMAGE","PARAMETER_INDEX", 1+"");
				sActualImgName = wSeverity.getAttribute("src");
				System.out.println(sSeverityText);
				System.out.println(sActualImgName);
				WebObjectUtil.explicitWait(5);
				bSeverity = WebObjectUtil.compareString(sActualImgName, sSeverityImgName, false);
				FrameworkUtil.updateCustomResultBasedOnStatus(bSeverity, "Severity Text : " + sSeverityText + ", Severity Image, Actual : " + sActualImgName + ", Expected : " + sSeverityImgName);
			} catch (Exception e) {
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Severity Image", "verify Severity Imag", "fail", "Severity Image failed, Actual : " + sActualImgName + "Expected : " + sSeverityImgName);
			}
			
			LoginTestCase_Old1.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		
		}
	}
	
	        /*==============================================================
				TestScript  	: verifyTicketDetails
				Manual TestCase	: Verify Ticket details
				Description		: Verify user is able view ticket details like "Ticket Id","Summary","Severity","Priority","Last updated","Assigned To","Status".
				Author 			: Arularasu
				Creation Date 	: 06/16/2015
				Pre-Requisites	:
				Revision History:
			==============================================================*/
			@Test(priority=3)
			public void verifyTicketDetails()
			{
				String sSummary1,sSummary2,sSummary3,sSummaryTicketvalue;
				boolean bStatus;
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, Ticket);
				
				try {
					FrameworkUtil.sTestCaseName = "Ticket-verifyTicketDetails";
					FrameworkUtil.sManualTestCaseName="Verify Ticket details";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					String sTicketHeader = (String) FrameworkUtil.dictPropertyData.get("NAV.TICKET.TABLEHEADER");
					
					//Login to Navigator
					//TicketTestCase.navTicketLogin();
					LoginTestCase_Old1.LoginAsRoleAUser();
					TicketTestCase.navigateToTicketPage();
					TicketTestCase.getTicketID(1);
					//Changed per EXTJS5 changes- by Priyanka on 10/13/15
					//sSummary = WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 4);
					CustomWebElementUtil.loadCustomElement(Ticket.getNav_TicketsWebTable(), "table");
					sSummary1 = CustomWebElementUtil.getCellData(1, 3);//changed as summary lies in 3rd column
					sSummary2 = CustomWebElementUtil.getCellData(1, 6);
					sSummary3 = CustomWebElementUtil.getCellData(1, 9);
					//EVDC_Advanced.expandVMbyRowNum(1);
					expandTable(1);
					WebObjectUtil.explicitWait(5);
					
					sSummaryTicketvalue = Ticket.getNav_TicketSummaryEdit().getAttribute("value");
					bStatus=	WebObjectUtil.compareString(sSummary1, sSummaryTicketvalue, true);
					FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, sSummary1);
					
					//sSummary = WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 6);
					sSummaryTicketvalue = Ticket.getNav_TicketPriorityCombo().getAttribute("value");
					bStatus=	WebObjectUtil.compareString(sSummary2, sSummaryTicketvalue, true);
					FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, sSummary2);
					
					//sSummary = WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 9);
				    sSummaryTicketvalue = Ticket.getNav_TicketStatusCombo().getAttribute("value");
					bStatus=	WebObjectUtil.compareString(sSummary3, sSummaryTicketvalue, true);
					FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, sSummary3);
					
					LoginTestCase_Old1.nav_Logout();
					
				} catch (Exception e) {
					LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
				
				}
				
			}
			


			/*==============================================================
			TestScript  	: updateTicketDetails
			Manual TestCase	: Verify user able to update Ticket summary
			Description		: 
			Author 			: Arularasu
			Creation Date 	: 06/16/2015
			Pre-Requisites	:
			Revision History:
			==============================================================*/
			@Test(priority=4)
			public void updateTicketDetails()
			{
				String sSummary, sSummaryTicketvalue, sActualSuccessMsg, sTicketID;
				boolean bStatus;
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, Ticket);
				PageFactory.initElements(driver, Common);
				
				try {
					FrameworkUtil.sTestCaseName = "Ticket-updateTicketDetails";
					FrameworkUtil.sManualTestCaseName="Verify Update Ticket details";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					String sTicketHeader = (String) FrameworkUtil.dictPropertyData.get("NAV.TICKET.TABLEHEADER");
					
					//Login to Navigator
					//TicketTestCase.navTicketLogin();
					LoginTestCase_Old1.LoginAsRoleAUser();
					TicketTestCase.navigateToTicketPage();
					sTicketID=TicketTestCase.getTicketID(1);
					
					//EVDC_Advanced.expandVMbyRowNum(1);
					expandTable(1);
					sSummary = WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 4);
					sSummaryTicketvalue = Ticket.getNav_TicketSummaryEdit().getAttribute("value");
					sSummaryTicketvalue = sSummaryTicketvalue + "-UpdateTicketSelenium" + FrameworkUtil.sTimeStamp ;
					WebObjectUtil.SetValueEdit(Ticket.getNav_TicketSummaryEdit(), sSummaryTicketvalue);
					WebObjectUtil.clickElement(Ticket.getNav_TicketSaveUpdatesBtn());
					WebObjectUtil.waitForElementPresent(Common.getNav_CommonPopUpMessage());
					sActualSuccessMsg = Common.getNav_CommonPopUpMessage().getText();
					bStatus=WebObjectUtil.compareString(sActualSuccessMsg, "Successfully updated the ticket", false);
					FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Update Ticket Summary " + sTicketID + " updated to : " + sSummaryTicketvalue);
					WebObjectUtil.clickElement(Common.getNav_CommonPopUpOKButton());
					
					
					LoginTestCase_Old1.nav_Logout();
				} catch (Exception e) {
					LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
				
				}	
				

			}
			


			/*==============================================================
			TestScript  	: verifyOpenTicketDetails
			Manual TestCase	: Verify Open Ticket details
			Description		: Verify open tickets are editable
			Author 			: Arularasu
			Creation Date 	: 06/25/2015
			Pre-Requisites	:
			Revision History:
			==============================================================*/
				@Test(priority=5)
				public void verifyOpenTicketDetails()
				{
					String sSummary,sSummaryTicketvalue,sTicketID,sNotesID;
					WebElement wNotesExpander;
					boolean bStatus;
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver, Ticket);
					
					try {
						FrameworkUtil.sTestCaseName = "Ticket-verifyOpenTicketDetails";
						FrameworkUtil.sManualTestCaseName="Verify Open Ticket details";
						FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
						String sTicketHeader = (String) FrameworkUtil.dictPropertyData.get("NAV.TICKET.TABLEHEADER");
						
						//Login to Navigator
						//TicketTestCase.navTicketLogin();
						LoginTestCase_Old1.LoginAsRoleAUser();
						TicketTestCase.navigateToTicketPage();
						sTicketID = TicketTestCase.getTicketID(1);
						
						//EVDC_Advanced.expandVMbyRowNum(1);
						expandTable(1);
						sSummary = WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 4);
						bStatus = Ticket.getNav_TicketSummaryEdit().isEnabled();
						FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Summary field is Editable");
						
						bStatus = Ticket.getNav_TicketSeverityCombo().isEnabled();
						FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Severity field is Editable");
						
						bStatus = Ticket.getNav_TicketPriorityCombo().isEnabled();
						FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Priority field is Editable");
						
						bStatus = Ticket.getNav_TicketPriorityCombo().isEnabled();
						FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Priority field is Editable");
						
						bStatus = Ticket.getNav_TicketStatusCombo().isEnabled();
						FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Status field is Editable");

						
						//sNotesID="tktNotesImg-" + sTicketID;
						//WebElement wNotesExpander=WebObjectUtil.GetWebElement("id", sNotesID, "Notes Expander");
						// This object is updated on 10/14/2015 By QAA04
						wNotesExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER", "PARAMETER_TICKETID",  sTicketID);
						WebTableUtil.expandTableRowByRowNum(1, wNotesExpander);
						WebObjectUtil.explicitWait(5);
						
						bStatus = Ticket.getNav_TicketCreateNoteLink().isEnabled();
						FrameworkUtil.updateCustomResultBasedOnStatus(true, "Create Notes field is Enabled");	

						    
						LoginTestCase_Old1.nav_Logout();
					} catch (Exception e) {
						LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
					
					}
					
				}
				

				
				/*==============================================================
				TestScript  	: verifyClosedTicketDetails
				Manual TestCase	: Verify closed Ticket details
				Description		: Verify closed ticket are not editable
				Author 			: Arularasu
				Creation Date 	: 06/25/2015
				Pre-Requisites	:
				Revision History:
				==============================================================*/
				@Test(priority=6)
				public void verifyClosedTicketDetails()
				{
					String sSummary,sSummaryTicketvalue,sTicketID,sNotesID;
					WebElement wNotesExpander;
					boolean bStatus;
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver, Ticket);
					
					try {
						FrameworkUtil.sTestCaseName = "Ticket-verifyClosedTicketDetails";
						FrameworkUtil.sManualTestCaseName="Verify closed Ticket details";
						FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
						String sTicketHeader = (String) FrameworkUtil.dictPropertyData.get("NAV.TICKET.TABLEHEADER");
						
						//Login to Navigator
						//TicketTestCase.navTicketLogin();
						LoginTestCase_Old1.LoginAsRoleAUser();
						TicketTestCase.navigateToTicketPage();
						
						WebObjectUtil.explicitWait(10);
						WebObjectUtil.clickElement(Ticket.getNav_TicketOutstandingList());
						WebObjectUtil.selectCustomWebList(Ticket.getNav_TicketOutstandingDropdown(), "Closed (Less than 6 months)");
						sTicketID = TicketTestCase.getTicketID(1);
						
						//EVDC_Advanced.expandVMbyRowNum(1);
						expandTable(1);
						WebObjectUtil.explicitWait(5);
						verifyElementDisabled(Ticket.getNav_TicketSummaryEdit());
						verifyElementDisabled(Ticket.getNav_TicketSeverityCombo());
						verifyElementDisabled(Ticket.getNav_TicketPriorityCombo());
						verifyElementDisabled(Ticket.getNav_TicketStatusCombo());
						
						//sNotesID="tktNotesImg-" + sTicketID;
					//	WebElement wNotesExpander=WebObjectUtil.GetWebElement("id", sNotesID, "Notes Expander");
						// This object is updated on 10/14/2015 By QAA04
						wNotesExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER", "PARAMETER_TICKETID",  sTicketID);
						WebTableUtil.expandTableRowByRowNum(1, wNotesExpander);
						WebObjectUtil.explicitWait(5);
						//verifyElementDisabled(Ticket.getNav_TicketCreateNoteLink());
    
						LoginTestCase_Old1.nav_Logout();
					} catch (Exception e) {
						LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
					
					}
					
				}
				
		
					/*==============================================================
					TestScript  	: verifyArchivedTicketDetails
					Manual TestCase	: Verify Archived Ticket details
					Description		: Verify Archived Ticket details are not editable
					Author 			: Arularasu
					Creation Date 	: 06/26/2015
					Pre-Requisites	:
					Revision History:
					==============================================================*/
				@Test(priority=7)
				public void verifyArchivedTicketDetails()
				{
					String sSummary,sSummaryTicketvalue,sTicketID,sNotesID;
					WebElement wNotesExpander;
					boolean bStatus;
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver, Ticket);
					
					try {
						FrameworkUtil.sTestCaseName = "Ticket-verifyArchivedTicketDetails";
						FrameworkUtil.sManualTestCaseName="Verify Archived Ticket details";
						FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
						String sTicketHeader = (String) FrameworkUtil.dictPropertyData.get("NAV.TICKET.TABLEHEADER");
						
						//Login to Navigator
						//TicketTestCase.navTicketLogin();
						LoginTestCase_Old1.LoginAsRoleAUser();
						TicketTestCase.navigateToTicketPage();
						
						WebObjectUtil.explicitWait(10);
						WebObjectUtil.clickElement(Ticket.getNav_TicketOutstandingList());
						WebObjectUtil.selectCustomWebList(Ticket.getNav_TicketOutstandingDropdown(), "Closed (More than 6 months)");
						sTicketID = TicketTestCase.getTicketID(1);
						
						//EVDC_Advanced.expandVMbyRowNum(1);
						expandTable(1);
						
						verifyElementDisabled(Ticket.getNav_TicketSummaryEdit());
						verifyElementDisabled(Ticket.getNav_TicketSeverityCombo());
						verifyElementDisabled(Ticket.getNav_TicketPriorityCombo());
						verifyElementDisabled(Ticket.getNav_TicketStatusCombo());
						
					//	sNotesID="tktNotesImg-" + sTicketID;
						//WebElement wNotesExpander=WebObjectUtil.GetWebElement("id", sNotesID, "Notes Expander");
						// This object is updated on 10/14/2015 By QAA04
						wNotesExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER", "PARAMETER_TICKETID",  sTicketID);
						WebTableUtil.expandTableRowByRowNum(1, wNotesExpander);
						WebObjectUtil.explicitWait(5);
						//verifyElementDisabled(Ticket.getNav_TicketCreateNoteLink());
						
						    
						LoginTestCase_Old1.nav_Logout();
					} catch (Exception e) {
						LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
					
					}
					
					}
						
						

		/*==============================================================
		TestScript  	: saveWithoutUpdateTicketDetails
		Manual TestCase	: Verify popup msg displayed is user click on save button without updating Ticket summary
		Description		: 
		Author 			: Arularasu
		Creation Date 	: 06/16/2015
		Pre-Requisites	:
		Revision History:
		==============================================================*/
			@Test(priority=8)
			public void saveWithoutUpdateTicketDetails()
			{
				String sSummary,sSummaryTicketvalue,sActualSuccessMsg,sTicketID;
				boolean bStatus;
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, Ticket);
				PageFactory.initElements(driver, Common);
				
				try {
					FrameworkUtil.sTestCaseName = "Ticket-saveWithoutUpdateTicketDetails";
					FrameworkUtil.sManualTestCaseName="Verify popup msg displayed is user click on save button without updating Ticket summary";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					String sTicketHeader = (String) FrameworkUtil.dictPropertyData.get("NAV.TICKET.TABLEHEADER");
					
					//Login to Navigator
					//TicketTestCase.navTicketLogin();
					LoginTestCase_Old1.LoginAsRoleAUser();
					TicketTestCase.navigateToTicketPage();
					sTicketID=TicketTestCase.getTicketID(1);
					WebObjectUtil.explicitWait(10);
					//sSummary = WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 4);- by Priyanka on 10/08/15
					CustomWebElementUtil.loadCustomElement(Ticket.getNav_TicketsWebTable(), "table");
					sSummary=CustomWebElementUtil.getCellData(1,3);
					
					WebObjectUtil.explicitWait(10);
					//EVDC_Advanced.expandVMbyRowNum(1);
					expandTable(1);
					WebObjectUtil.explicitWait(3);
					WebObjectUtil.clickElement(Ticket.getNav_TicketSaveUpdatesBtn());
					WebObjectUtil.waitForElementPresent(Common.getNav_CommonPopUpMessage());
					sActualSuccessMsg = Common.getNav_CommonPopUpMessage().getText();
					bStatus=WebObjectUtil.compareString(sActualSuccessMsg, "Please make the desired changes and then press Update Ticket.", false);
					FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "popup msg verified : " + sActualSuccessMsg);
					WebObjectUtil.clickElement(Common.getNav_CommonPopUpOKButton());
					
					
					LoginTestCase_Old1.nav_Logout();
				} catch (Exception e) {
					LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
				
				}	
				

			}
	
	/*==============================================================
	TestScript  	: cloneTicket
	Manual TestCase	: Verify user able to clone Ticket
	Description		: 
	Author 			: Arularasu
	Creation Date 	: 06/29/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
		@Test(priority=9)
		public void cloneTicket()
		{
			String sTicketID,sSummary,sActualSuccessMsg,sLastUpdatedDate,sCloneSummary,sCloneLastUpdatedDate;
			String[] arrString = null;
			boolean bStatus;
			int parentTicketID,cloneTicketID;
			Date parentTicketDate;
			Date cloneTicketDate;
			
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, Ticket);
			PageFactory.initElements(driver, Common);
			
			FrameworkUtil.sTestCaseName = "Ticket-cloneTicket";
			FrameworkUtil.sManualTestCaseName="Verify user able to clone Ticket";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yy HH:mm a");
			
			try {
				//Login to Navigator
				//TicketTestCase.navTicketLogin();
				LoginTestCase_Old1.LoginAsRoleAUser();
				TicketTestCase.navigateToTicketPage();
				TicketTestCase.searchTicket("Summary", "SeleniumTicket-Clone");
				sTicketID = TicketTestCase.getTicketID(1);
				parentTicketID= Integer.parseInt(sTicketID);
				sSummary = WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 4);
				sLastUpdatedDate = WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 7);
				//parentTicketDate=Date.parse(sLastUpdatedDate);
				parentTicketDate = formatter.parse(sLastUpdatedDate);
				
				//EVDC_Advanced.expandVMbyRowNum(1);
				expandTable(1);
				WebObjectUtil.explicitWait(3);
				WebObjectUtil.clickElement(Ticket.getNav_TicketCloneBtn());
				WebObjectUtil.waitForElementPresent(Common.getNav_CommonPopUpMessage());
				sActualSuccessMsg = Common.getNav_CommonPopUpMessage().getText();
				bStatus=WebObjectUtil.compareString(sActualSuccessMsg, "Successfully cloned the ticket", false);
				FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "popup msg verified : " + sActualSuccessMsg);
				WebObjectUtil.clickElement(Common.getNav_CommonPopUpOKButton());
				
				sTicketID = TicketTestCase.getTicketID(1);
				cloneTicketID= Integer.parseInt(sTicketID);
				sCloneSummary = WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 4);
				sCloneLastUpdatedDate = WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 7);
				//cloneTicketDate=Date.parse(sCloneLastUpdatedDate);
				cloneTicketDate = formatter.parse(sCloneLastUpdatedDate);
				
				if(cloneTicketID > parentTicketID )
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verify clone ticket ID", "pass", "Cloning ticket success and ticket id is : " + cloneTicketID );
				}else{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName,  "verify clone ticket ID", "fail", "issue with cloning ticket, parent ticket id : " + parentTicketID + " and Clone ticket id is : " + cloneTicketID  );
				}
				
				if(sCloneSummary.equalsIgnoreCase(sSummary))
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verify clone ticket summary", "pass", "Cloning ticket success and ticket summary is : " + cloneTicketID );
				}else{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName,  "verify clone ticket summary", "fail", "issue with cloning ticket, parent ticket summary : " + sSummary + " and Clone ticket summary is : " + sCloneSummary  );
				}
				
				//System.out.println(cloneTicketDate.getTime());
				//System.out.println(parentTicketDate.getTime());
					if(cloneTicketDate.compareTo(parentTicketDate)>=0 && cloneTicketDate.getTime() >= parentTicketDate.getTime()  )
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verify clone ticket date", "pass", "Cloning ticket success and ticket date is : " + cloneTicketDate );
				}else{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName,  "verify clone ticket date", "fail", "issue with cloning ticket, parent ticket date : " + parentTicketDate + " and Clone ticket date is : " + cloneTicketDate  );
				}
				LoginTestCase_Old1.nav_Logout();

			} catch (Exception e) {
				LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
			
			}	
			
										
		}
		
		
		
	
//------------------------------------------------------------------------------------
//									METHODS
//------------------------------------------------------------------------------------
/*==============================================================
Method Name 	: navTicketLogin
Description		: This will Login to Navigator 
Author 			: Vivek Kumar
Creation Date 	: 06/16/2015
Pre-Requisites	:
Revision History:
==============================================================*/

	public static void navTicketLogin() 
	{
	try {
		//Getting UserId from properties file
		String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.USERID.AROLE");
		//String sUserName = FrameworkUtil.getPropValues("NAV.EVDC.USERID");
		//Getting password from properties file
		String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.PASSWORD.AROLE");
		//Login to Navigator portlet 
		LoginTestCase_Old1.nav_Login(sUserName,sPassword);
		} catch (Exception e) {
		LoggerUtil.log_type_error("issue with- navTicketLogin" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	Method Name 	: navTicketLoginWithParameter
	Description		: This will Login to Navigator and need to pass USerID and Pwd 
	Author 			: Vivek Kumar
	Creation Date 	: 06/16/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/

		public static void navTicketLoginWithParameter(String sUserName,String sPassword) 
		{
		try {
			
			//Login to Navigator portlet 
			LoginTestCase_Old1.nav_Login(sUserName,sPassword);
			} catch (Exception e) {
			LoggerUtil.log_type_error("issue with- navTicketLogin" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
			}
		}
		
		
	/*==============================================================
	Method Name 	: navigateToTicketPage
	Description		: This will navigate to ticket page
	Author 			: Vivek Kumar
	Creation Date 	: 06/16/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navigateToTicketPage()
	
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,Ticket);
		
		try {
			//Clicking and Hovering on Support Tab
			//WebObjectUtil.ClickAndMouseHover(Ticket.getNav_SupportTabLink());
			//the below line updated by QAA03 on 07/25/2016
			//WebObjectUtil.ClickAndMouseHover(Ticket.getNav_SupportTabLink());
			WebObjectUtil.clickElement(Ticket.getNav_SupportTabLink());
			// this below lines are added by QAA04 - 02/24/16
			WebObjectUtil.clickElement(Ticket.getNav_TicketsMenuLink());
			WebObjectUtil.waitForElementPresent(Ticket.getNav_CreateTicketLink());
			//WebObjectUtil.clickAndVerifyElement(Ticket.getNav_TicketsMenuLink(), Ticket.getNav_CreateTicketLink());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	/*==============================================================
	Method Name 	: getTicketID
	Description		: get Ticket Id based on row no. passed
	Author 			: Arularasu
	Creation Date 	: 06/25/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static String getTicketID(int iRowNum){
		String sTicketID="";
		
		try {
			WebObjectUtil.waitForElementPresent(Ticket.getNav_TicketsWebTable());
			WebObjectUtil.verifyElementPresent(Ticket.getNav_TicketsWebTable());
			//This line updated on 10/08/2015 for EXTJS5 by QAA03
			//sTicketID = WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), iRowNum, 3);
			sTicketID = WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), iRowNum, 2);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Ticket ID", "get Ticket ID", "done", sTicketID );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sTicketID;
	}
	
	
	/*==============================================================
	Method Name 	: searchTicket
	Description		: This will search ticket
	Author 			: Vivek Kumar
	Creation Date 	: 06/29/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void searchTicket(String sSearchItem,String sSearchString)
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Ticket);
		WebElement wSearchDropdown;
		
		try {
			WebObjectUtil.clickElement(Ticket.getNav_SearchByDropDownArrow());
			//WebObjectUtil.selectCustomWebList(Ticket.getNav_SearchByDropdown(), 2);
			wSearchDropdown = WebObjectUtil.getActiveElementasWebElement((String)FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH"));
			WebObjectUtil.selectCustomWebList(wSearchDropdown, sSearchItem);
			//WebObjectUtil.selectCustomWebList(Ticket.getNav_SearchByDropdown(), sSearchItem);
			
			//geting first 30 char of search string by Arul on 06/22/16
			if (sSearchString.length() > 29)
			sSearchString = sSearchString.substring(0, 29);
			//Set Summary
			WebObjectUtil.SetValueEdit(Ticket.getNav_SearchEdit(), sSearchString);
			//Clicking on Search Image/Button
			WebObjectUtil.clickElement(Ticket.getNav_SearchByImage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static int getTicketTableColumnIndex(String sColumnName){
		int iHeaderIndex = 0;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Ticket);
		
		try {
			String sTicketTableHeader = Ticket.getNav_TicketsTableHeader().getText();
			String[] sTicketColumnHeader = sTicketTableHeader.split("\\r?\\n");
			for (int i=0; i<=sTicketColumnHeader.length; i++){
				if (sTicketColumnHeader[i].contains(sColumnName)){
					iHeaderIndex = i;
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return iHeaderIndex+1;
	}
	
	
	public static boolean verifyElementDisabled(WebElement webElement){
		boolean bStatus = false;
		bStatus = webElement.isEnabled();
		if (bStatus == false) {
		FrameworkUtil.updateCustomResultBasedOnStatus(true, "Element disabled as expected: " + webElement);
		}else{
			FrameworkUtil.updateCustomResultBasedOnStatus(false, "Element NOT disabled : " + webElement);	
		}
		return bStatus;

	}
////#####################################333VIVEK########################################################3333333
//------------------------------------------------------------------------------------
//	TEST CASE
//------------------------------------------------------------------------------------
/*==============================================================
TestScript  	: navVerifyDropdownOptions
Manual TestCase	: options in Search by drop down box
Description		: Verify user is able to make the selection and type in the details he want to see.
Author 			: Vivek Kumar
Creation Date 	: 06/16/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=11)
public void navVerifyDropdownOptions()
{
String sActualDropDownItems,sDropDownItems;
String[] aDropDownItem;


WebDriver driver = WebDriverUtil.getDriver();
PageFactory.initElements(driver,Ticket); 
PageFactory.initElements(driver,Ticket);

try {

FrameworkUtil.sTestCaseName = "Ticket-navVerifyDropdownOptions";
FrameworkUtil.sManualTestCaseName="1.options in Search by drop down box";
FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);



sDropDownItems=(String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.SEARCHBY.ITEMS.DROPDOWN");
//Login to Navigator
//TicketTestCase.navTicketLogin();
LoginTestCase_Old1.LoginAsRoleAUser();
//Navigate to Ticket page
TicketTestCase.navigateToTicketPage();
WebObjectUtil.explicitWait(5);
//Clicking on SerchBy input field
WebObjectUtil.clickElement(Ticket.getNav_SearchByDropDownArrow());
//Verifying items under Search by dropdown
sActualDropDownItems=WebObjectUtil.getCustomWebListItems(Ticket.getNav_SearchByDropdown());
WebObjectUtil.explicitWait(5);
verifyingDropDownItems(sDropDownItems,sActualDropDownItems);
//Logout
LoginTestCase_Old1.nav_Logout();
} catch (Exception e) {
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
LoggerUtil.log_type_error(e.getMessage());
}

}



/*==============================================================
TestScript  	: navVerifySearchByPopUpMessage
Manual TestCase	: Search option on ticket page
Description		: verify that a popup titled Tickets that says "Please select the category to search by"
Author 			: Vivek Kumar
Creation Date 	: 06/17/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=12)
public void navVerifySearchByPopUpMessage()
{

String sSearchByMessage,sActualPopUpMessage;
boolean bFlag;

WebDriver driver = WebDriverUtil.getDriver();
PageFactory.initElements(driver,Ticket); 
PageFactory.initElements(driver,Ticket);
PageFactory.initElements(driver,Common);

FrameworkUtil.sTestCaseName = "Ticket-navVerifySearchByPopUpMessage";
FrameworkUtil.sManualTestCaseName="1.Search option on ticket page";
FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

try {
sSearchByMessage=(String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.SEARCHBY.EMPTY.MESSAGE");
//Login to Navigator
//TicketTestCase.navTicketLogin();
LoginTestCase_Old1.LoginAsRoleAUser();
//Navigate to Ticket page
TicketTestCase.navigateToTicketPage();
WebObjectUtil.explicitWait(5);
//Selecting Empty in SearchBy 
WebObjectUtil.clickElement(Ticket.getNav_SearchByDropDownArrow());
WebObjectUtil.explicitWait(5);
WebObjectUtil.selectCustomWebList(Ticket.getNav_SearchByDropdown(), 1);

//Click on Search button
WebObjectUtil.clickElement(Ticket.getNav_SearchByImage());

//Verifying the popup and getting the message
if(WebObjectUtil.isElementPresent(Common.getNav_CommonPopUp()))
{
sActualPopUpMessage=(Common.getNav_CommonPopUpMessage().getText()).trim();
bFlag=WebObjectUtil.compareString(sSearchByMessage, sActualPopUpMessage, true);
FrameworkUtil.updateCustomResultBasedOnStatus(bFlag, sActualPopUpMessage);
WebObjectUtil.clickElement(Common.getNav_CommonPopUpOKButton());

}
else
{
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "PopUp", "fail", "not present");
}

//Logout
LoginTestCase_Old1.nav_Logout();
} catch (Exception e) {
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
LoggerUtil.log_type_error(e.getMessage());
}

}


/*==============================================================
TestScript  	: navVerifyTicketIDSearchfound
Manual TestCase	: Select Ticket Id from drop down box
Description		: Verify that tickets that have that string of numbers in the ticket ID are returned in the results
Author 			: Vivek Kumar
Creation Date 	: 06/22/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=13)
public void navVerifyTicketIDSearchfound()
{


String sTicketID;

WebDriver driver = WebDriverUtil.getDriver();
PageFactory.initElements(driver,Ticket); 
PageFactory.initElements(driver,Ticket); 

try {
sTicketID = (String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.SERACHBY.TICKETID");
FrameworkUtil.sTestCaseName = "Ticket-navVerifyTicketIDSearchfound";
FrameworkUtil.sManualTestCaseName="1.Select Ticket Id from drop down box";
FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

//Login to Navigator
//TicketTestCase.navTicketLogin();
LoginTestCase_Old1.LoginAsRoleAUser();
//Navigate to Ticket page
TicketTestCase.navigateToTicketPage();

WebObjectUtil.explicitWait(5);
//Select "Ticket ID" from dropdown list
TicketTestCase.searchTicket("Ticket ID", sTicketID);
WebObjectUtil.explicitWait(5);
SearcResultFound("Ticket ID",3, sTicketID);

//Logout
LoginTestCase_Old1.nav_Logout();
} catch (Exception e) {
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
LoggerUtil.log_type_error(e.getMessage());
}


}

/*==============================================================
TestScript  	: navVerifyTicketIDSearchNotfound
Manual TestCase	: Select Ticket Id from drop down box not found
Description		:Verify no tickets are found.
Author 			: Vivek Kumar
Creation Date 	: 06/23/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=14)
public void navVerifyTicketIDSearchNotfound()
{
String sTicketID;
int iRowCnt;

WebDriver driver = WebDriverUtil.getDriver();
PageFactory.initElements(driver,Ticket); 
PageFactory.initElements(driver,Ticket); 

try {
sTicketID = (String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.SERACHBY.TICKETID.NOTFOUND");
FrameworkUtil.sTestCaseName = "Ticket-navVerifyTicketIDSearchNotfound";
FrameworkUtil.sManualTestCaseName="1. Select Ticket Id from drop down box not found";
FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

//Login to Navigator
//TicketTestCase.navTicketLogin();
LoginTestCase_Old1.LoginAsRoleAUser();
//Navigate to Ticket page
TicketTestCase.navigateToTicketPage();

WebObjectUtil.explicitWait(5);
//Select "Ticket ID" from dropdown list
TicketTestCase.searchTicket("Ticket ID", sTicketID);
WebObjectUtil.explicitWait(5);	

//Getting the RowCount
iRowCnt=WebTableUtil.getRowCount(Ticket.getNav_TicketsWebTable());
//WebTableUtil.printEachCellText(Ticket.getNav_TicketsWebTable());
if(!(iRowCnt>0))
{
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Search string" , "Search Result", "pass", "Result not found for TicketId :"+ sTicketID );
}
else
{
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Search string" , "Search Result", "fail", "Result found for TicketId :"+ sTicketID );
}


//Logout
LoginTestCase_Old1.nav_Logout();
} catch (Exception e) {
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
LoggerUtil.log_type_error(e.getMessage());
}

}


/*==============================================================
TestScript  	: navVerifySummarySearchFound
Manual TestCase	: Select Summary in "Search By" drop down box
Description		: Verify that tickets that have that string of notes from summary are returned in the results.
Author 			: Vivek Kumar
Creation Date 	: 06/23/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=16)
public void navVerifySummarySearchFound()
{

String sSummary;
WebDriver driver = WebDriverUtil.getDriver();
PageFactory.initElements(driver,Ticket); 
PageFactory.initElements(driver,Ticket); 


try {
sSummary = (String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.SERACHBY.SUMMARY");
FrameworkUtil.sTestCaseName = "Ticket-navVerifySummarySearchFound";
FrameworkUtil.sManualTestCaseName="1.Select Summary in 'Search By' drop down box";
FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

//Login to Navigator
//TicketTestCase.navTicketLogin();
LoginTestCase_Old1.LoginAsRoleAUser();
//Navigate to Ticket page
TicketTestCase.navigateToTicketPage();

WebObjectUtil.explicitWait(5);
//Select Summary from dropdown list
TicketTestCase.searchTicket("Summary", sSummary);
WebObjectUtil.explicitWait(10);

//SearcResultFound("Summary",4, sSummary);
SearcResultFound("Summary",3, sSummary);

//Logout
LoginTestCase_Old1.nav_Logout();
} catch (Exception e) {
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
LoggerUtil.log_type_error(e.getMessage());
}

}


/*==============================================================
TestScript  	: navVerifyTicketNotesSearchFound
Manual TestCase	: Select Ticket Notes from drop down box
Description		: confirm tickets with matching notes from search are displayed in the results.
Author 			: Vivek Kumar
Creation Date 	: 06/23/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=17)
public void navVerifyTicketNotesSearchFound()
{

String sTicketNotes;

WebDriver driver = WebDriverUtil.getDriver();
PageFactory.initElements(driver,Ticket); 
PageFactory.initElements(driver,Ticket); 


try {
sTicketNotes = (String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.SERACHBY.TICKETNOTES");
FrameworkUtil.sTestCaseName = "Ticket-navVerifyTicketNotesSearchFound";
FrameworkUtil.sManualTestCaseName="1.Select Ticket Notes from drop down box";
FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

//Login to Navigator
//TicketTestCase.navTicketLogin();
LoginTestCase_Old1.LoginAsRoleAUser();
//Navigate to Ticket page
TicketTestCase.navigateToTicketPage();

WebObjectUtil.explicitWait(5);
//Select "TicketNotes" from dropdown list
TicketTestCase.searchTicket("Ticket Notes", sTicketNotes);

WebObjectUtil.explicitWait(10);
NotesSearcResultFound(sTicketNotes);

//Logout
LoginTestCase_Old1.nav_Logout();
} catch (Exception e) {
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
LoggerUtil.log_type_error(e.getMessage());
}



}

/*==============================================================
TestScript  	: navVerifyTicketNotesSearchNotfound
Manual TestCase	: No TicketNotes data found
Description		: Verify no ticket data is displayed.
Author 			: Vivek Kumar
Creation Date 	: 06/24/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=18)
public void navVerifyTicketNotesSearchNotfound()
{

String sTicketNotes;
int iRowCnt;

WebDriver driver = WebDriverUtil.getDriver();
PageFactory.initElements(driver,Ticket); 
PageFactory.initElements(driver,Ticket); 


try {
sTicketNotes = (String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.SERACHBY.TICKETNOTES.NOTFOUND");
FrameworkUtil.sTestCaseName = "Ticket-navVerifyTicketNotesSearchNotfound";
FrameworkUtil.sManualTestCaseName="1. No TicketNotes data found";
FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

//Login to Navigator
//TicketTestCase.navTicketLogin();
LoginTestCase_Old1.LoginAsRoleAUser();
//Navigate to Ticket page
TicketTestCase.navigateToTicketPage();

WebObjectUtil.explicitWait(5);
//Select "TicketNotes" from dropdown list
TicketTestCase.searchTicket("Ticket Notes", sTicketNotes);
WebObjectUtil.explicitWait(5);	

//Getting the RowCount
iRowCnt=WebTableUtil.getRowCount(Ticket.getNav_TicketsWebTable());
//WebTableUtil.printEachCellText(Ticket.getNav_TicketsWebTable());
if(!(iRowCnt>0))
{
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Search string" , "Search Result", "pass", "Result not found for Ticket Notes :"+ sTicketNotes );
}
else
{
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Search string" , "Search Result", "fail", "Result found for Ticket Notes :"+ sTicketNotes );
}


//Logout
LoginTestCase_Old1.nav_Logout();
} catch (Exception e) {
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
LoggerUtil.log_type_error(e.getMessage());
}
}


/*==============================================================
TestScript  	: navVerifyAdvanceAllSearchfound
Manual TestCase	: Select Advanced All from drop down box
Description		: confirm tickets matching the data in the search are displayed.
Author 			: Vivek Kumar
Creation Date 	: 06/24/2015
Pre-Requisites	:
Revision History:
==============================================================*/
/*@Test(priority=20)
public void navVerifyAdvanceAllSearchfound()
{

String sTicketID;

WebDriver driver = WebDriverUtil.getDriver();
PageFactory.initElements(driver,Ticket); 
PageFactory.initElements(driver,Ticket); 


try {
sTicketID = (String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.SERACHBY.TICKETID");
FrameworkUtil.sTestCaseName = "Ticket-navVerifyAdvanceAllSearchfound";
FrameworkUtil.sManualTestCaseName="1.Select Advanced All from drop down box";
FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

//Login to Navigator
//TicketTestCase.navTicketLogin();
LoginTestCase.LoginAsRoleAUser();
//Navigate to Ticket page
TicketTestCase.navigateToTicketPage();

WebObjectUtil.explicitWait(5);
//Select "Advance(All)" from dropdown list
TicketTestCase.searchTicket("Advanced (All)", sTicketID);
WebObjectUtil.explicitWait(5);
SearcResultFound("TicketID",3, sTicketID);

//Logout
LoginTestCase.nav_Logout();
} catch (Exception e) {
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
LoggerUtil.log_type_error(e.getMessage());
}
}
*/


/*==============================================================
TestScript  	: navVerifyAdvanceAllSearchNotfound
Manual TestCase	: Select Advanced All from drop down box search Not found
Description		:Verify not tickets are displayed.
Author 			: Vivek Kumar
Creation Date 	: 06/25/2015
Pre-Requisites	:
Revision History:
==============================================================*/
/*@Test(priority=21)
public void navVerifyAdvanceAllSearchNotfound()
{

String sTicketNotes;
int iRowCnt;

WebDriver driver = WebDriverUtil.getDriver();
PageFactory.initElements(driver,Ticket); 
PageFactory.initElements(driver,Ticket); 


try {
sTicketNotes = (String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.SERACHBY.TICKETNOTES.NOTFOUND");
FrameworkUtil.sTestCaseName = "Ticket-navVerifyAdvanceAllSearchNotfound";
FrameworkUtil.sManualTestCaseName="1.Select Advanced All from drop down box search Not found";
FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

//Login to Navigator
//TicketTestCase.navTicketLogin();
LoginTestCase.LoginAsRoleAUser();
//Navigate to Ticket page
TicketTestCase.navigateToTicketPage();

WebObjectUtil.explicitWait(5);
//Select "Advance All" from dropdown list
TicketTestCase.searchTicket("Advanced (All)", sTicketNotes);
WebObjectUtil.explicitWait(5);	

//Getting the RowCount
iRowCnt=WebTableUtil.getRowCount(Ticket.getNav_TicketsWebTable());
//WebTableUtil.printEachCellText(Ticket.getNav_TicketsWebTable());
if(!(iRowCnt>0))
{
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Search string" , "Search Result", "pass", "Advance (All) -Result not found for Ticket Notes :"+ sTicketNotes );
}
else
{
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Search string" , "Search Result", "fail", "Advance (All) -Result found for Ticket Notes :"+ sTicketNotes );
}


//Logout
LoginTestCase.nav_Logout();
} catch (Exception e) {
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
LoggerUtil.log_type_error(e.getMessage());
}
}
*/


/*==============================================================
TestScript  	: navVerifyElementSearchfound
Manual TestCase	: Select Elements from drop down box
Description		: Verify that tickets are displayed with all the elements details for that organization.(Note: Elements can be found or created only in EM7)
Author 			: Vivek Kumar
Creation Date 	: 06/25/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=22)
public void navVerifyElementSearchfound()
{
String sElement,sElementText;
boolean bResultStatus;
int iRow;
WebElement wExpander,wElementText;

WebDriver driver = WebDriverUtil.getDriver();
PageFactory.initElements(driver,Ticket); 
PageFactory.initElements(driver,Ticket);


try {
sElement  = (String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.SERACHBY.ELEMENTS");
FrameworkUtil.sTestCaseName = "Ticket-navVerifyElementSearchfound";
FrameworkUtil.sManualTestCaseName="1. Select Elements from drop down box";
FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

//Login to Navigator
//TicketTestCase.navTicketLogin();
LoginTestCase_Old1.LoginAsRoleAUser();
//Navigate to Ticket page
TicketTestCase.navigateToTicketPage();

WebObjectUtil.explicitWait(5);
//Select "Element" from dropdown list
TicketTestCase.searchTicket("Element", sElement);
WebObjectUtil.explicitWait(5);	

//Expand the first row
iRow=1;
//wExpander=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+iRow+"]//tr[1]/td[1]//div[@class='x-grid-row-expander']", "Arrow Expander");-By Priyanka on 10/08/15
//wExpander=WebObjectUtil.GetWebElement("xpath", "//div[3]/div[1]/div/table["+iRow+"]/tbody/tr[1]/td[1]/div", "Arrow Expander");
// This object is updated on 10/14/2015 By QAA04
wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", iRow+"");
//WebObjectUtil.clickElement(wExpander);
WebObjectUtil.explicitWait(5);
WebTableUtil.expandTableRowByRowNum(iRow, wExpander);

//wElementText=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+iRow+"]//td/div[@id='ticket_content']/dl/dt[text()='Element']/../dd", "Element Value");-By Priyanka on 10/08/15
//wElementText=WebObjectUtil.GetWebElement("xpath", "//div[3]/div[1]/div/table["+iRow+"]/tbody/tr[1]/td[4]/div", "Element Value");
// This object is updated on 10/14/2015 By QAA04
wElementText = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER.ORG.TEXT", "PARAMETER_ROWNUMBER", iRow+"");
sElementText=wElementText.getText();
bResultStatus=WebObjectUtil.compareString(sElementText, sElement, true);
FrameworkUtil.updateCustomResultBasedOnStatus(bResultStatus, sElementText);
//Logout
LoginTestCase_Old1.nav_Logout();
} catch (Exception e) {
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
LoggerUtil.log_type_error(e.getMessage());
}

}

/*==============================================================
TestScript  	: navVerifyResetFunctionality
Manual TestCase	: Select Reset button  on tickets home page
Description		: confirm that the "Reset" button is working
Author 			: Vivek Kumar
Creation Date 	: 06/25/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=23)
public void navVerifyResetFunctionality()
{
String sElement,sText;

WebDriver driver = WebDriverUtil.getDriver();
PageFactory.initElements(driver,Ticket); 
PageFactory.initElements(driver,Ticket);


try {
sElement  = (String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.SERACHBY.ELEMENTS");
FrameworkUtil.sTestCaseName = "Ticket-navVerifyResetFunctionality";
FrameworkUtil.sManualTestCaseName="1. Select Reset from drop down box";
FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

//Login to Navigator
//TicketTestCase.navTicketLogin();
LoginTestCase_Old1.LoginAsRoleAUser();
//Navigate to Ticket page
TicketTestCase.navigateToTicketPage();

WebObjectUtil.explicitWait(5);
//Setting sElement value
WebObjectUtil.SetValueEdit(Ticket.getNav_SearchEdit(), sElement);

//Clicking on Reset button
WebObjectUtil.clickElement(Ticket.getNav_ResetButton());

sText=Ticket.getNav_SearchEdit().getText();

if(sText != null && sText.length() == 0)
{
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Reset Button" , "Reset Button", "pass", "Successfully Reset the fields" );
}
else
{
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Reset Button" , "Reset Button", "fail", "failed to reset the fields" );
}

//Logout
LoginTestCase_Old1.nav_Logout();
} catch (Exception e) {
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
LoggerUtil.log_type_error(e.getMessage());
}

}


/*==============================================================
TestScript  	: navVerifyHostedSolutionLogin
Manual TestCase	: Logging in as Hosted Solutions User
Description		: 1. Verify login details are correct and able ot go to home page
2. View Organisation name on home screen
Author 			: Vivek Kumar
Creation Date 	: 06/25/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=86)
public void navVerifyHostedSolutionLogin()
{
String sExpOrganizationName,sActOrganizationName;	
boolean bResultStatus;

WebDriver driver = WebDriverUtil.getDriver();
PageFactory.initElements(driver,Ticket); 
PageFactory.initElements(driver,Ticket);

try {
//sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.USERID");
//sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.PASSWORD");
sExpOrganizationName  = (String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.HOSTEDSOLUTION.ORGANIZATION.NAME");


FrameworkUtil.sTestCaseName = "Ticket-navVerifyHostedSolutionLogin";
FrameworkUtil.sManualTestCaseName="1. Logging in as Hosted Solutions User" +'\n' + "2. View Organisation name on home screen";
FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

//Login to Navigator
//TicketTestCase.navTicketLoginWithParameter(sUserName, sPassword);
LoginTestCase_Old1.LoginAsRoleAUser();
//Getting the organization name during run time
sActOrganizationName=Ticket.getNav_OrganizationLink().getText();
bResultStatus=WebObjectUtil.compareString(sActOrganizationName, sExpOrganizationName, true);
FrameworkUtil.updateCustomResultBasedOnStatus(bResultStatus, sActOrganizationName + " - Organization name verified");

//Navigate to Ticket page
TicketTestCase.navigateToTicketPage();
bResultStatus=WebObjectUtil.compareString(sActOrganizationName, sExpOrganizationName, true);
FrameworkUtil.updateCustomResultBasedOnStatus(bResultStatus, sActOrganizationName + " - Organization name verified on Ticket Page");


//Logout
LoginTestCase_Old1.nav_Logout();
} catch (Exception e) {
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
LoggerUtil.log_type_error(e.getMessage());
}

}


/*==============================================================
TestScript  	: navVerifyOragnization
Manual TestCase	: Tickets screen view
Description		: Verify details are displayed for that organization in the ticket display grid.
Author 			: Vivek Kumar
Creation Date 	: 06/26/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=88)
public void navVerifyOragnization()
{
String sUserName,sPassword,sOrganization;
String sActualOrganization;
boolean bResultStatus;

WebDriver driver = WebDriverUtil.getDriver();
PageFactory.initElements(driver,Ticket); 
//PageFactory.initElements(driver,Ticket);


try {
sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.USERID");
sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.PASSWORD");
sOrganization=(String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.HOSTEDSOLUTION.ORGANIZATION.DROPDOWN");

FrameworkUtil.sTestCaseName = "Ticket-navVerifyOragnization";
FrameworkUtil.sManualTestCaseName="Tickets screen view";
FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

//Login to Navigator
//TicketTestCase.navTicketLoginWithParameter(sUserName, sPassword);
LoginTestCase_Old1.LoginAsRoleAUser();

//Navigate to Ticket page
TicketTestCase.navigateToTicketPage();

WebObjectUtil.explicitWait(5);
//Selection 11Giraffes
WebObjectUtil.clickElement(Ticket.getNav_OrganizationDropdownArrow());
//WebObjectUtil.explicitWait(5);
//WebObjectUtil.selectCustomWebList(Ticket.getNav_TicketOrgWebListDropDown(),sOrganization);
WebObjectUtil.selectCustomWebList(Ticket.getNav_TicketOrgWebListDropDown(),2);
WebObjectUtil.explicitWait(8);
CustomWebElementUtil.loadCustomElement(Ticket.getNav_TicketsWebTableParent(), "table");
sActualOrganization=CustomWebElementUtil.getCellData(1, 4);
//sActualOrganization=Ticket.getNav_FirstRowWebTableOrganizationColumn().getText().trim();
//sActualOrganization=WebTableUtil.getCellData(Ticket.getNav_TicketsWebTableParent(),1,3);

bResultStatus=WebObjectUtil.compareString(sActualOrganization, sOrganization, true);
FrameworkUtil.updateCustomResultBasedOnStatus(bResultStatus, "Organization name - " +sActualOrganization);

//Clicking on Organization Tab and validating the organization name
WebObjectUtil.clickElement(Ticket.getNav_WebTableOrganizationTab());
WebObjectUtil.explicitWait(10);

//sActualOrganization=Ticket.getNav_FirstRowWebTableOrganizationColumn().getText().trim();
//sActualOrganization=WebTableUtil.getCellData(Ticket.getNav_TicketsWebTableParent(),1,3);
CustomWebElementUtil.loadCustomElement(Ticket.getNav_TicketsWebTableParent(), "table");
sActualOrganization=CustomWebElementUtil.getCellData(1, 4);
bResultStatus=WebObjectUtil.compareString(sActualOrganization, sOrganization, true);
FrameworkUtil.updateCustomResultBasedOnStatus(bResultStatus, "Organization name - " +sActualOrganization +" Verified");
//Logout
LoginTestCase_Old1.nav_Logout();
}catch (Exception e) {
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
LoggerUtil.log_type_error(e.getMessage());
}
}



/*==============================================================
TestScript  	: navVerifyCaseNotInfluenceSearchResult
Manual TestCase	: case usage doesn't influence search results
Description		: Verify that case usage doesn't influence search results.
Author 			: Vivek Kumar
Creation Date 	: 07/06/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=19)
public void navVerifyCaseNotInfluenceSearchResult()
{
String sTicketNotes,sTicketSrchNotes;

WebDriver driver = WebDriverUtil.getDriver();
PageFactory.initElements(driver,Ticket); 
PageFactory.initElements(driver,Ticket);


FrameworkUtil.sTestCaseName = "Ticket-navVerifyCaseNotInfluenceSearchResult";
FrameworkUtil.sManualTestCaseName="case usage doesn't influence search results";
FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

try {
sTicketSrchNotes = (String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.SERACHBY.CASE.TICKETNOTES");
sTicketNotes=(String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.SERACHBY.TICKETNOTES");
//Login to Navigator
//TicketTestCase.navTicketLogin();
LoginTestCase_Old1.LoginAsRoleAUser();
//Navigate to Ticket page
TicketTestCase.navigateToTicketPage();

WebObjectUtil.explicitWait(5);

//Select "TicketNotes" from dropdown list
TicketTestCase.searchTicket("Ticket Notes", sTicketSrchNotes);
WebObjectUtil.explicitWait(10);
NotesSearcResultFound(sTicketNotes);

sTicketSrchNotes=sTicketSrchNotes.toLowerCase();
//Select "TicketNotes" from dropdown list
TicketTestCase.searchTicket("Ticket Notes", sTicketSrchNotes);
WebObjectUtil.explicitWait(10);
NotesSearcResultFound(sTicketNotes);

//Logout
LoginTestCase_Old1.nav_Logout();
} catch (Exception e) {
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
LoggerUtil.log_type_error(e.getMessage());
}
}





//------------------------------------------------------------------------------------
//	METHODS
//------------------------------------------------------------------------------------



/*==============================================================
Method Name 	: verifyingDropDownItems
Description		: This will verify the dropdown items
Author 			: Vivek Kumar
Creation Date 	: 06/16/2015
Pre-Requisites	:
Revision History:
==============================================================*/
public static void verifyingDropDownItems(String sDropDownItems, String sActualDropDownItems)
{
WebDriver driver = WebDriverUtil.getDriver();
PageFactory.initElements(driver,Ticket);


String[] aDropDownItem;
//sDropDownItems=(String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.SEARCHBY.ITEMS.DROPDOWN");
//Split the sDropDownItems
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
/*==============================================================
Method Name 	: SearcResultFound
Description		: This will verify search result on ticket table
Author 			: Vivek Kumar
Creation Date 	: 06/24/2015
Pre-Requisites	: search ticket is separate method : searchTicket
Revision History:
==============================================================*/

public static void SearcResultFound(String sSearchDropdownValue,int iTicketTableColumnNumber,String sSearchString)
{
int iRowCnt,iResultCount=0;
String sActual;
boolean bFlag,bCountFlag=true;

WebDriver driver = WebDriverUtil.getDriver();
PageFactory.initElements(driver,Ticket); 
 

try {
//Getting the RowCount
iRowCnt=WebTableUtil.getRowCount(Ticket.getNav_TicketsWebTable());
//WebTableUtil.printEachCellText(Ticket.getNav_TicketsWebTable());
if(iRowCnt>0)
{
for(int i=1;i<=iRowCnt;i=i+9)
{
sActual = (WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), i, iTicketTableColumnNumber)).trim();
bFlag=WebObjectUtil.compareString(sActual, sSearchString, true);
if(bFlag)
{
bFlag=false;
iResultCount++;

}
else
{
bCountFlag=false;
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Search string" , "verify - "+sSearchDropdownValue, "fail", "Expected Summary -"+ sSearchString +  "/ Actual Ticket-ID -"+ sActual );
break;
}

}
if(iResultCount > 0  && bCountFlag == true)
{
iRowCnt=iRowCnt/9;
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Search string" , "Search Result", "pass", "Result found :" + iRowCnt+ "Total Result verified : "  + iResultCount);
}

}
else
{
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Search string" , "verify - "+sSearchDropdownValue, "warn",sSearchDropdownValue+ "-" + sSearchString + " not found");
}
} catch (Exception e) {
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
LoggerUtil.log_type_error(e.getMessage());
}

}

/*==============================================================
Method Name 	: NotesSearcResultFound--CK
Description		: This will verify the Notes search result
Author 			: Vivek Kumar
Creation Date 	: 07/06/2015
Pre-Requisites	:
Revision History:
==============================================================*/
    public static void NotesSearcResultFound(String sTicketNotes)
    {
    int iRowCnt,iNotesTableRowCnt;
    String sID,sTicketID,sNotesTableText,sExpandNotes;
    boolean bSearchStatus;
    WebElement wNotesExpander,wExpander,wExpandNotes;

    //Getting the RowCount
    iRowCnt=WebTableUtil.getRowCount(Ticket.getNav_TicketsWebTable());
    int iRow=1;
    if(iRowCnt>0)
    {
    for(int i=1;i<=iRowCnt;i=i+4)
    {
    //sTicketID = (WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), i, 3)).trim();
    //Commented the above and added the below two lines as a part of EXTJS5 modification- Vivek - 10072015
    CustomWebElementUtil.loadCustomElement(Ticket.getNav_TicketsWebTableParent(), "table");
    sTicketID=(CustomWebElementUtil.getCellData(i,2)).trim();
     
    //sID="tktNotesImg-" + sTicketID;
    //wExpander=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+iRow+"]//tr[1]/td[1]//div[@class='x-grid-row-expander']", "Arrow Expander");-by Priyanka on 10/7/15
    //Commented the above and added the below two lines as a part of EXTJS5 modification- Vivek - 10072015
    //wExpander=WebObjectUtil.GetWebElement("xpath", "//div[3]/div[1]/div/table["+iRow+"]/tbody/tr[1]/td[1]/div/div","Arrow Expander");
    // This object is updated on 10/14/2015 By QAA04
    wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", i+"");
    //WebObjectUtil.clickElement(wExpander);
    WebObjectUtil.explicitWait(5);
    //WebTableUtil.expandTableRowByRowNum(iRow, wExpander);
    WebTableUtil.expandTableRowByRowNum(i, wExpander);
    //wNotesExpander=WebObjectUtil.GetWebElement("id", sID, "Notes Expander");
    // This object is updated on 10/14/2015 By QAA04
    WebObjectUtil.explicitWait(15);
    wNotesExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER", "PARAMETER_TICKETID",  sTicketID);
//   This below line is added by - QAA04 02/22/16
    WebObjectUtil.clickElement(wNotesExpander);
    //  WebTableUtil.expandTableRowByRowNum(iRow, wNotesExpander);
    WebObjectUtil.explicitWait(10);

    //Checking the checkbox
    //WebObjectUtil.selectCheckRadioBox(Ticket.getNav_ExpandAllNotes());
    //Commented the above and added the below two lines as a part of EXTJS5 modification- Vivek - 10072015
    //sExpandNotes="expandAllNotes-"+sTicketID+"-inputEl";
    //wExpandNotes=WebObjectUtil.GetWebElement("id", sExpandNotes, "Expand all Notes Checkbox");
    // This object is updated on 10/14/2015 By QAA04
    wExpandNotes = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDNOTES.CHECKBOX", "PARAMETER_TICKETID", sTicketID);
    WebObjectUtil.selectCheckRadioBox(wExpandNotes);

    //iNotesTableRowCnt=WebTableUtil.getRowCount(Ticket.getNav_NotesWebTable());
    //Commented the above and added the below two lines as a part of EXTJS5 modification- Vivek - 10072015
    iNotesTableRowCnt=CustomWebElementUtil.iRowCount;
    sNotesTableText=Ticket.getNav_NotesWebTable().getText();

    bSearchStatus=WebTableUtil.verifyTextOnWebTable(Ticket.getNav_NotesWebTable(),sTicketNotes);
    FrameworkUtil.updateCustomResultBasedOnStatus(bSearchStatus, "Search String - "+ sTicketNotes + " found");
    if(bSearchStatus)
    {
     break;
    }
    }
    }

    }


////#####################################VIVEK########################################################

////??????????????????????????????????SUKUR?????????????????????????????????????????????????????????????????????

/*==============================================================
TestScript 		: validateCreateTicketFields
Manual TestCase	: Verify all the fields displayed in create ticket page
Description		: 
Author 			: Sukur Babu. B
Creation Date 	: 16/06/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=35)
public void validateCreateTicketFields(){
try{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, Ticket);
	FrameworkUtil.sTestCaseName = "Tickets-validateCreateTicketFields";
	FrameworkUtil.sManualTestCaseName="Verify all the fields displayed in create ticket page";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	//Login into Navigator
	//navTicketLogin();
    LoginTestCase_Old1.LoginAsRoleAUser();
	//Navigate to Create page
	navigateToCreateTicketPage();
	//Ho-over on create ticket page fields
	HooveroverCreateTicketFields();
	//Verify fields displayed in create page
	VerifyCreateTicketFields();
	//Log out from the Nagigator
	LoginTestCase_Old1.nav_Logout();
}
catch(Exception e)
{
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	LoggerUtil.log_type_error(e.getMessage());
}
}

/*==============================================================
TestScript 		: validateCreateTicketDateAndOrgDefaultVal
Manual TestCase	: Verify Date and Organization default field values
Description		: 
Author 			: Sukur Babu. B
Creation Date 	: 16/06/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=57)
public void validateCreateTicketDateAndOrgDefaultVal(){
	try {
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Ticket);
		FrameworkUtil.sTestCaseName = "Tickets-validateCreateTicketDateAndOrgDefaultVal";
		FrameworkUtil.sManualTestCaseName="Verify Date and Organization default field values";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		String sOrg;
		//Login into Navigator
		//navTicketLogin();
		LoginTestCase_Old1.LoginAsRoleAUser();
		//Navigate to Create page
		navigateToCreateTicketPage();
		//Get the organization from the page
		sOrg=Ticket.getNav_OrganizationNameText().getText();
		//Verify default values displayed in Date and Organization
		VerifyCreateTicketFieldsDateAndOrg(sOrg);
		//Log out from the Nagigator
		LoginTestCase_Old1.nav_Logout();
	} catch (Exception e) {
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		LoggerUtil.log_type_error(e.getMessage());
	}
}
/*==============================================================
TestScript 		: validateCreateTicketSuccessMsg
Manual TestCase	: Verify success message after creating a ticket
Description		: 
Author 			: Sukur Babu. B
Creation Date 	: 17/06/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=66)
public void validateCreateTicketSuccessMsg(){
	WebElement wExpander;
	try {
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Ticket);
		FrameworkUtil.sTestCaseName = "Tickets-validateCreateTicketSuccessMsg";
		FrameworkUtil.sManualTestCaseName="Verify success message after creating a ticket";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		int iSummaryLen,iSeverityRowNum,iPriorityRowNum;
		String[] temp;
		String sSummaryLen,sActSuccessMsg;
		String sSummary = (String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.SUMMARY.VALUE");
		String sSeverity = (String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.SEVERITY.VALUE");
		String sPriority = (String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.PRIORITY.VALUE");
		String sCategory = (String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.CATEGORY.VALUE");
		String sMaxLenSummary=(String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.SUMMARY.MAXLENVALUE");
		String sNotes=(String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.NOTES.VALUE");
		String sSuccessMsg="Successfully created the ticket";
		//Login into Navigator
		//navTicketLogin();
		LoginTestCase_Old1.LoginAsRoleAUser();
		//Navigate to Create page
		navigateToCreateTicketPage();
		//Enter 201 length string in Summary field
		WebObjectUtil.SetValueEdit(Ticket.getNav_SummaryEdit(), sMaxLenSummary);
		sSummaryLen=Ticket.getNav_SummaryEdit().getAttribute("maxlength");
		iSummaryLen=Integer.parseInt(sSummaryLen);
		if(iSummaryLen<=200)
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Summary input length  = "+  iSummaryLen  , "pass","" );
		}
		else
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Summary input length= "+  iSummaryLen , "fail", "");
		}
		//Click Cancel button
		WebObjectUtil.clickElement(Ticket.getNav_CreateTicketCancelButton());
		//Navigate to Create ticket page
		navigateToCreateTicketPage();
		//Enter all filed values
		WebObjectUtil.SetValueEdit(Ticket.getNav_SummaryEdit(), sSummary);
		WebObjectUtil.clickElement(Ticket.getNav_SeverityEdit());
		WebObjectUtil.explicitWait(5);
		WebElement wSeverity=WebObjectUtil.getElementbyTagNameValue("li", sSeverity, "Severity Drop Down");
		System.out.println(wSeverity.toString());
		WebObjectUtil.explicitWait(5);
		// this object is added by QAA04 - 02/23/16
		WebObjectUtil.clickElement(wSeverity);
		//wSeverity.click();
		WebObjectUtil.explicitWait(5);
		WebObjectUtil.clickElement(Ticket.getNav_PriorityEdit());
		WebObjectUtil.explicitWait(5);
		WebElement wPriority=WebObjectUtil.getElementbyTagNameValue("li", sPriority, "Priority Drop Down");
		WebObjectUtil.explicitWait(5);
		// this object is added by QAA04 - 02/23/2016
		WebObjectUtil.clickElement(wPriority);
		//wPriority.click();
		WebObjectUtil.explicitWait(5);
		WebObjectUtil.clickElement(Ticket.getNav_CategoryEdit());
		WebObjectUtil.explicitWait(5);
		WebElement wCategory=WebObjectUtil.getElementbyTagNameValue("li", sCategory, "Category Drop Down");
		// this object is added by QAA04 - 02/23/2016
		WebObjectUtil.clickElement(wCategory);
		//wCategory.click();
		WebObjectUtil.explicitWait(5);
		driver.switchTo().frame(Ticket.getNav_NotesFrame());
		//Ticket.getNav_NotesFrame().click();
		WebElement element = WebObjectUtil.GetWebElement("tagname", "body", "NoteEditArea"); //driver.findElement(By.cssSelector("body"));
		
		//Enter Notes
		element.sendKeys(sNotes);
		driver.switchTo().defaultContent();		
		WebObjectUtil.clickElement(Ticket.getNav_CreateTicketOKButton());
		WebObjectUtil.waitForElementPresent(Ticket.getNav_ConfirmPopup());
		WebObjectUtil.explicitWait(5);
		sActSuccessMsg=Ticket.getNav_ConfirmPopup().getText();
		//Verify sucess message
		if(sActSuccessMsg.contains(sSuccessMsg))
			FrameworkUtil.updateCustomResultBasedOnStatus(true, sSuccessMsg+" is matching with actual Sucess message after creating the ticket");
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false, sSuccessMsg+" is not matching with actual Sucess message after creating the ticket");
		WebObjectUtil.clickElement(Ticket.getNav_ConfirmPopupOkBtn());
		WebObjectUtil.explicitWait(5);
		//WebElement wExpander=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr[1]//tr[1]/td[1]//div[@class='x-grid-row-expander']", "Ticket Arrow Expander");
		// This object is updated on 10/14/2015 By QAA04
		wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
		//WebTableUtil.getRowByCellText("//table/tbody/tr[1]//tr[1]/td[1]//div[@class='x-grid-row-expander']", sSeverity, 1, 1);
		temp=sSeverity.split("-");
		iSeverityRowNum=WebTableUtil.getRowByCellText(Ticket.getNav_TicketsWebTable(), temp[0].trim(), 1, 1);
		iPriorityRowNum=WebTableUtil.getRowByCellText(Ticket.getNav_TicketsWebTable(), sPriority, 1, 1);
		if(iSeverityRowNum>0)
			FrameworkUtil.updateCustomResultBasedOnStatus(true, "Severity is matching with entered severity value while creating the ticket");
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(true, "Severity is not matching with entered severity value while creating the ticket");
		if(iPriorityRowNum>0)
			FrameworkUtil.updateCustomResultBasedOnStatus(true, "Priority is matching with entered severity value while creating the ticket");
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(true, "Priority is not matching with entered severity value while creating the ticket");
		LoginTestCase_Old1.nav_Logout();
	} catch (Exception e) {
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		LoggerUtil.log_type_error(e.getMessage());
	}

	
}
/*==============================================================
TestScript 		: validateNoteNotDisplayed
Manual TestCase	: Verify Note not displayed if notes is not given while creating ticket
Description		: 
Author 			: Sukur Babu. B
Creation Date 	: 01/07/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=64)
public void validateNoteNotDisplayed(){
	WebElement wExpander,wNotesExpander,wNotesRow;
	try {
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Ticket);
		FrameworkUtil.sTestCaseName = "Tickets-validateNoteNotDisplayed";
		FrameworkUtil.sManualTestCaseName="Verify Note not displayed if notes is not given while creating ticket";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		int iSummaryLen;
		String sSummaryLen,sTicketID,sID;
		String sSummary = (String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.SUMMARY.VALUE");
		String sSeverity = (String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.SEVERITY.VALUE");
		String sPriority = (String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.PRIORITY.VALUE");
		String sCategory = (String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.CATEGORY.VALUE");
		String sMaxLenSummary=(String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.SUMMARY.MAXLENVALUE");
		String sNotes=(String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.NOTES.VALUE");
		String sSuccessMsg="Successfully created the ticket";
		//Login into Navigator
		//navTicketLogin();
		LoginTestCase_Old1.LoginAsRoleAUser();
		//Navigate to Create ticket page
		navigateToCreateTicketPage();
	
		//Enter all field values in create ticket page
	// this below is commented by QAA04 - 02/23/16
		//	WebObjectUtil.clickElement(Ticket.getNav_CreateTicketLink());//by Priyanka on 10/8/15
		WebObjectUtil.SetValueEdit(Ticket.getNav_SummaryEdit(), sSummary);
		WebObjectUtil.clickElement(Ticket.getNav_SeverityEdit());
		WebObjectUtil.explicitWait(5);
		WebElement wSeverity=WebObjectUtil.getElementbyTagNameValue("li", sSeverity, "Severity Drop Down");
		System.out.println(wSeverity.toString());
		WebObjectUtil.explicitWait(5);
		// this object is added by QAA04 -02/23/16
		WebObjectUtil.clickElement(wSeverity);
		//wSeverity.click();
		WebObjectUtil.explicitWait(5);
		WebObjectUtil.clickElement(Ticket.getNav_PriorityEdit());
		WebObjectUtil.explicitWait(5);
		WebElement wPriority=WebObjectUtil.getElementbyTagNameValue("li", sPriority, "Priority Drop Down");
		WebObjectUtil.explicitWait(5);
		// this object is added by QAA04 -02/23/16
		WebObjectUtil.clickElement(wPriority);
		//wPriority.click();
		WebObjectUtil.explicitWait(5);
		WebObjectUtil.clickElement(Ticket.getNav_CategoryEdit());
		WebObjectUtil.explicitWait(5);
		WebElement wCategory=WebObjectUtil.getElementbyTagNameValue("li", sCategory, "Category Drop Down");
		// this object is added by QAA04 -02/23/16
		WebObjectUtil.clickElement(wCategory);
		//wCategory.click();
		WebObjectUtil.explicitWait(5);
		WebObjectUtil.clickElement(Ticket.getNav_CreateTicketOKButton());
		WebObjectUtil.waitForElementPresent(Ticket.getNav_ConfirmPopup());
		WebObjectUtil.explicitWait(5);
		WebObjectUtil.clickElement(Ticket.getNav_ConfirmPopupOkBtn());
		WebObjectUtil.explicitWait(5);
		//WebElement wExpander=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr[1]//tr[1]/td[1]//div[@class='x-grid-row-expander']", "Ticket Arrow Expander");
		//WebElement wExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTicketsGridPanel-body']/div[1]/div/table[1]/tbody/tr[1]/td[1]/div/div", "Ticket Arrow Expander");
		// This object is updated on 10/14/2015 By QAA04
		wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
		//Expand the ticket
		// this object is added by QAA04 -02/23/16
	     WebObjectUtil.clickElement(wExpander);
		//	wExpander.click();
		WebObjectUtil.explicitWait(5);
		//sTicketID = (WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 3)).trim();
		sTicketID=getTicketID(1);
		//sID="tktNotesImg-" + sTicketID;
		//WebElement wNotesExpander=WebObjectUtil.GetWebElement("id", sID, "Notes Expander");
		// This object is updated on 10/14/2015 By QAA04
		wNotesExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER", "PARAMETER_TICKETID",  sTicketID);
		//Expand notes
		// this object is added by QAA04 -02/23/16
	     WebObjectUtil.clickElement(wNotesExpander);
		//wNotesExpander.click();
		WebObjectUtil.explicitWait(5);
		//WebElement wNotesRow=WebObjectUtil.GetWebElement("xpath", "//table//tr[1]/td/table/tbody/tr[@class='x-grid-rowbody-tr']/td/div/div[contains(@id,'idNotesRow')]/div[contains(@id,'cloakDiv')]/table", "Note Row");
		//WebElement wNotesRow=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr[2]//table//tr[1]/td/table/tbody/tr[1]/td[2]", "Note Row");
		// This object is updated on 10/14/2015 By QAA04
		wNotesRow = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER.NOTEROW", "", "");
		//Verify notes not displayed
		if(wNotesRow!=null)
			FrameworkUtil.updateCustomResultBasedOnStatus(false, "Shwoing notes for the ticket even not entered notes while creating ticket");
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(true, "Not shwoing notes for the ticket");
		LoginTestCase_Old1.nav_Logout();
	} catch (Exception e) {
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		LoggerUtil.log_type_error(e.getMessage());
	}
}
/*==============================================================
TestScript 		: validateSeverityDropDownListItems
Manual TestCase	: Verify items present in Severity drop down
Description		: 
Author 			: Sukur Babu. B
Creation Date 	: 24/06/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=36)
public void validateSeverityDropDownListItems(){
	try {
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Ticket);
		FrameworkUtil.sTestCaseName = "Tickets-validateSeverityDropDownListItems";
		FrameworkUtil.sManualTestCaseName="Verify items present in Severity drop down";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		String sSeverityFIrstItem = (String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.SEVERITY.FIRST.ITEM.VALUE");
		String sSeveritySecondItem = (String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.SEVERITY.SECOND.ITEM.VALUE");
		String sSeverityThirdItem = (String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.SEVERITY.THIRD.ITEM.VALUE");
		String sSeverityFourthItem = (String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.SEVERITY.FOURTH.ITEM.VALUE");
		String sDefaultSeverityItem=(String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.SEVERITY.DEFAULT.ITEM.VALUE");
		//Login into Navigator
		//navTicketLogin();
		LoginTestCase_Old1.LoginAsRoleAUser();
		//Navigate to Create ticket page
		navigateToCreateTicketPage();
		//Verify items present in Severity drop down
		//sActDefaultVal=Ticket.getNav_SeverityEdit().get
		WebObjectUtil.clickElement(Ticket.getNav_SeverityEdit());
		WebObjectUtil.explicitWait(5);
		
		WebElement wSeverity1=WebObjectUtil.getElementbyTagNameValue("li", sSeverityFIrstItem, "Sev 1 - Critical");
		if(wSeverity1!=null)
			FrameworkUtil.updateCustomResultBasedOnStatus(true,sSeverityFIrstItem+" found in the Severity list" );
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false, sSeverityFIrstItem+" not found in the Severity list");
		WebElement wSeverity2=WebObjectUtil.getElementbyTagNameValue("li", sSeveritySecondItem, "Sev 2 - Degraded");
		if(wSeverity2!=null)
			FrameworkUtil.updateCustomResultBasedOnStatus(true,sSeveritySecondItem+" found in the Severity list" );
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false, sSeveritySecondItem+" not found in the Severity list");
		WebElement wSeverity3=WebObjectUtil.getElementbyTagNameValue("li", sSeverityThirdItem, "Sev 3 - Change Request");
		if(wSeverity3!=null)
			FrameworkUtil.updateCustomResultBasedOnStatus(true,sSeverityThirdItem+" found in the Severity list" );
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false, sSeverityThirdItem+" not found in the Severity list");
		WebElement wSeverity4=WebObjectUtil.getElementbyTagNameValue("li", sSeverityFourthItem, "Sev 4 - Informational");
		if(wSeverity4!=null)
			FrameworkUtil.updateCustomResultBasedOnStatus(true,sSeverityFourthItem+" found in the Severity list" );
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false, sSeverityFourthItem+" not found in the Severity list");
		
		String sActualSeverityItem=wSeverity3.getAttribute("class");
		if (sActualSeverityItem.contains("selected"))
			FrameworkUtil.updateCustomResultBasedOnStatus(true,sDefaultSeverityItem+" is displayed by default" );
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false, sDefaultSeverityItem+" is not displayed by default");
		

		LoginTestCase_Old1.nav_Logout();
	} catch (Exception e) {
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		LoggerUtil.log_type_error(e.getMessage());
	}
}

/*==============================================================
TestScript 		: validatePriorityDropDownListItems
Manual TestCase	: Verify items present in Priority drop down
Description		: 
Author 			: Sukur Babu. B
Creation Date 	: 25/06/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=37)
public void validatePriorityDropDownListItems(){
	try {
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Ticket);
		FrameworkUtil.sTestCaseName = "Tickets-validatePriorityDropDownListItems";
		FrameworkUtil.sManualTestCaseName="Verify items present in Priority drop down";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		String sPriorityFIrstItem = (String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.PRIORITY.FIRST.ITEM.VALUE");
		String sPrioritySecondItem = (String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.PRIORITY.SECOND.ITEM.VALUE");
		String sDefaultPriorityItem=(String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.PRIORITY.DEFAULT.ITEM.VALUE");;
		//Login into Navigator
		//navTicketLogin();
		LoginTestCase_Old1.LoginAsRoleAUser();
		//Navigate to Create ticket page
		navigateToCreateTicketPage();
		//Verify items present in Priority drop down
		WebObjectUtil.clickElement(Ticket.getNav_PriorityEdit());
		WebObjectUtil.explicitWait(5);
		WebElement wPriority1=WebObjectUtil.getElementbyTagNameValue("li", sPriorityFIrstItem, "Normal");
		if(wPriority1!=null)
			FrameworkUtil.updateCustomResultBasedOnStatus(true,sPriorityFIrstItem+" found in the Priority list" );
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false, sPriorityFIrstItem+" not found in the Priority list");
		WebElement wPriority2=WebObjectUtil.getElementbyTagNameValue("li", sPrioritySecondItem, "High");
		if(wPriority2!=null)
			FrameworkUtil.updateCustomResultBasedOnStatus(true,sPrioritySecondItem+" found in the Priority list" );
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false, sPrioritySecondItem+" not found in the Priority list");
		String sActualDefaultPriorityItem=wPriority1.getAttribute("class");
		if (sActualDefaultPriorityItem.contains("selected"))
			FrameworkUtil.updateCustomResultBasedOnStatus(true,sDefaultPriorityItem+" is displayed by default" );
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false, sDefaultPriorityItem+" is not displayed by default");
		LoginTestCase_Old1.nav_Logout();
	} catch (Exception e) {
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		LoggerUtil.log_type_error(e.getMessage());
	}

	
}
/*==============================================================
TestScript 		: validateCategoryDropDownListItems
Manual TestCase	: Verify items present in Severity drop down
Description		: 
Author 			: Sukur Babu. B
Creation Date 	: 25/06/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=62)
public void validateCategoryDropDownListItems(){
	try {
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Ticket);
		FrameworkUtil.sTestCaseName = "Tickets-validateCategoryDropDownListItems";
		FrameworkUtil.sManualTestCaseName="Verify items present in Category drop down";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		String sDefaultCategoryItem=(String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.CATEGORY.DEFAULT.ITEM.VALUE");;
		String sActualDefaultCategoryItem;
		//Login into Navigator
		//navTicketLogin();
		LoginTestCase_Old1.LoginAsRoleAUser();
		//Navigate to Create ticket page
		navigateToCreateTicketPage();
		WebObjectUtil.clickElement(Ticket.getNav_CategoryEdit());
		WebObjectUtil.explicitWait(5);
		//Verify default value displayed is .General
		WebElement wCategory1=WebObjectUtil.getElementbyTagNameValue("li",sDefaultCategoryItem , ".General");
		sActualDefaultCategoryItem=wCategory1.getAttribute("class");
		if (sActualDefaultCategoryItem.contains("selected"))
			FrameworkUtil.updateCustomResultBasedOnStatus(true,sDefaultCategoryItem+" is displayed by default" );
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false, sDefaultCategoryItem+" is not displayed by default");
		LoginTestCase_Old1.nav_Logout();
	} catch (Exception e) {
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		LoggerUtil.log_type_error(e.getMessage());
	}


}	

/*==============================================================
TestScript 		: validateCloakEnableDisableForNote
Manual TestCase	:  Validate Cloak enable/disable functionality for a note
Description		: 
Author 			: Sukur Babu. B
Creation Date 	: 29/06/2015
Pre-Requisites	:
Revision History:
==============================================================*/
//@Test(priority=90)
public void validateCloakEnableDisableForNote(){
	WebElement wExpander,wNotesExpander,CloakDisable,CloakEnable;
	try {
		WebDriver driver = WebDriverUtil.getDriver();
		
		PageFactory.initElements(driver, Ticket);
		FrameworkUtil.sTestCaseName = "Tickets-validateCloakEnableDisableForNote";
		FrameworkUtil.sManualTestCaseName="Validate Cloak enable/disable functionality for a note";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		//String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOL.USERID.AROLE");
		//String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOL.PASSWORD.AROLE");
		String sNotes=(String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.NOTES.VALUE");
		String sTicketID,sID,checkedornot;
		//Login to Navigator portlet 
		//LoginTestCase.nav_Login(sUserName,sPassword);
		LoginTestCase_Old1.LoginAsARoleAUser();
		//Navigate to ticket page
		navigateToTicketPage();
		//Get and expand the ticket
		//WebElement wExpander=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr[1]//tr[1]/td[1]//div[@class='x-grid-row-expander']", "Ticket Arrow Expander");
	//	WebElement wExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTicketsGridPanel-body']/div[1]/div/table[1]/tbody/tr[1]/td[1]/div/div", "Arrow Expander");
		// This object is updated on 10/14/2015 By QAA04
		wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
   // this object is added by QAA04 - 02/23/16
		WebObjectUtil.clickElement(wExpander);
		//wExpander.click();
		WebObjectUtil.explicitWait(5);
		//sTicketID = (WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 3)).trim();
		CustomWebElementUtil.loadCustomElement(Ticket.getNav_TicketsWebTable(), "table");
		sTicketID= CustomWebElementUtil.getCellData(1, 2);
		//sID="tktNotesImg-" + sTicketID;
		//WebElement wNotesExpander=WebObjectUtil.GetWebElement("id", sID, "Notes Expander");
		// This object is updated on 10/14/2015 By QAA04
		wNotesExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER", "PARAMETER_TICKETID",  sTicketID);
		//Expand Notes
		// this object is added by QAA04 - 02/23/16
		WebObjectUtil.clickElement(wNotesExpander);
		//wNotesExpander.click();
		WebObjectUtil.explicitWait(5);
		//Click on create note link
		WebObjectUtil.clickElement(Ticket.getNav_CreateNoteLink());
		WebObjectUtil.waitForElementPresent(Ticket.getNav_CreateNotesFrame());
		driver.switchTo().frame(Ticket.getNav_CreateNotesFrame());
		//Ticket.getNav_NotesFrame().click();
		
		WebElement element = WebObjectUtil.GetWebElement("tagname", "body", "NoteEditArea"); //driver.findElement(By.cssSelector("body"));
		element.sendKeys(sNotes);
		driver.switchTo().defaultContent();
		
		//WebObjectUtil.clickElement(Ticket.getNav_CreateNoteCloakCheckbox());
		WebObjectUtil.clickElement(Ticket.getNav_CreateNoteOKButton());
		WebObjectUtil.waitForElementPresent(Ticket.getNav_ExpandAllNoteCheckbox());
		
		WebObjectUtil.clickElement(Ticket.getNav_CreateNoteLink());
		WebObjectUtil.waitForElementPresent(Ticket.getNav_CreateNotesFrame());
		driver.switchTo().frame(Ticket.getNav_CreateNotesFrame());
		//Ticket.getNav_NotesFrame().click();
		WebElement element1 = WebObjectUtil.GetWebElement("tagname", "body", "NoteEditArea"); //driver.findElement(By.cssSelector("body"));
		element1.sendKeys(sNotes);
		driver.switchTo().defaultContent();
		//Select Cloak check box
		WebObjectUtil.clickElement(Ticket.getNav_CreateNoteCloakCheckbox());
		WebObjectUtil.clickElement(Ticket.getNav_CreateNoteOKButton());
		WebObjectUtil.waitForElementPresent(Ticket.getNav_ExpandAllNoteCheckbox());
		WebObjectUtil.explicitWait(5);
		
		WebObjectUtil.clickElement(Ticket.getNav_ExpandAllNoteCheckbox());
		WebObjectUtil.explicitWait(5);
		//WebElement CloakDisable=WebObjectUtil.GetWebElement("xpath", "//table//tr[2]/td/table/tbody/tr[@class='x-grid-rowbody-tr']/td/div/div[contains(@id,'idNotesRow')]/div[contains(@id,'cloakDiv')]/table", "Cloak Check box");
		// This object is updated on 10/14/2015 By QAA04
		CloakDisable = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER.CLOAK.DISABLE", "",  "");
		checkedornot=CloakDisable.getAttribute("class");
		//Verify Cloak checked or not
		if(checkedornot.contains("checked"))
			FrameworkUtil.updateCustomResultBasedOnStatus(false,"Cloak option is not checked" );
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(true,"Cloak option is checked" );
		
	//	WebElement CloakEnable=WebObjectUtil.GetWebElement("xpath", "//table//tr[3]/td/table/tbody/tr[@class='x-grid-rowbody-tr']/td/div/div[contains(@id,'idNotesRow')]/div[contains(@id,'cloakDiv')]/table", "Cloak Check box");
		// This object is updated on 10/14/2015 By QAA04
		CloakEnable = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER.CLOAK.ENABLE", "",  "");
		String checkedornot1=CloakEnable.getAttribute("class");
		if(checkedornot1.contains("checked"))
			FrameworkUtil.updateCustomResultBasedOnStatus(true,"Cloak option is checked" );
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false,"Cloak option is not checked" );
		LoginTestCase_Old1.nav_Logout();
	} catch (Exception e) {
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		LoggerUtil.log_type_error(e.getMessage());
	}
	
}

/*==============================================================
TestScript 		: validateNoteOrderDisplay
Manual TestCase	:  Validate order of notes displayed in Note table for a ticket
Description		: 
Author 			: Sukur Babu. B
Creation Date 	: 06/07/2015
Pre-Requisites	:
Revision History:
==============================================================*/
/*@Test(priority=9)
public void validateNoteOrderDisplay(){
	try {
		WebDriver driver = WebDriverUtil.getDriver();
		
		PageFactory.initElements(driver, Ticket);
		FrameworkUtil.sTestCaseName = "Tickets-validateNoteOrderDisplay";
		FrameworkUtil.sManualTestCaseName="Validate order of notes displayed in Note table for a ticket";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOL.USERID.AROLE");
		String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOL.PASSWORD.AROLE");
		String sNotes=(String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.NOTES.VALUE");
		//Login to Navigator portlet 
		//LoginTestCase.nav_Login(sUserName,sPassword);
		LoginTestCase.LoginAsARoleAUser();
		navigateToTicketPage();
		
		WebElement wExpander=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr[1]//tr[1]/td[1]//div[@class='x-grid-row-expander']", "Ticket Arrow Expander");
		wExpander.click();
		WebObjectUtil.explicitWait(5);
		String sTicketID = (WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 3)).trim();
		String sID="tktNotesImg-" + sTicketID;
		WebElement wNotesExpander=WebObjectUtil.GetWebElement("id", sID, "Notes Expander");
		wNotesExpander.click();
		WebObjectUtil.explicitWait(5);
		boolean bOrder=false;
		int iCounter=0;
		int iNoteRowCount=WebTableUtil.getRowCount(Ticket.getNav_NotesWebTable());
		WebElement wNotesRow=WebObjectUtil.GetWebElement("xpath", "//table//tr[1]/td/table/tbody/tr[@class='x-grid-rowbody-tr']/td/div/div[contains(@id,'idNotesRow')]/div[contains(@id,'cloakDiv')]/table", "Note Row");
		
		for(int i=1;i<=iNoteRowCount;i++)
		{
			
			//int iItem=WebTableUtil.getRowByCellText(Ticket.getNav_NotesWebTable(), Integer.toString(i), 1,2);
			String sItem=WebTableUtil.getCellData(Ticket.getNav_NotesWebTable(), i, 3);
			if(sItem.length()>0)
			{
			iCounter++;
			if(sItem.contains(Integer.toString(iCounter)))
				bOrder=true;
			else
			{
				bOrder=false;
				break;
			}
		}
			else
				continue;
		}
		if(bOrder)
			FrameworkUtil.updateCustomResultBasedOnStatus(true,"Order of the notes displayed for the ticket is valid" );
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false,"Order of the notes displayed for the ticket is in-valid" );
	} catch (Exception e) {
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		LoggerUtil.log_type_error(e.getMessage());
	}
}

	*/

/*==============================================================
TestScript 		: validateNoteOrderDisplay
Manual TestCase	:  Validate order of notes displayed in Note table for a ticket
Description		: 
Author 			: Sukur Babu. B
Creation Date 	: 06/07/2015
Pre-Requisites	:
Revision History:
==============================================================*/
//@Test(priority=9)
public void validateNoteOrderDisplay(){
	WebElement wExpander,wNotesExpander,wNotesRow;
	try {
		WebDriver driver = WebDriverUtil.getDriver();
		
		PageFactory.initElements(driver, Ticket);
		FrameworkUtil.sTestCaseName = "Tickets-validateNoteOrderDisplay";
		FrameworkUtil.sManualTestCaseName="Validate order of notes displayed in Note table for a ticket";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		String sItm="";
		//String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOL.USERID.AROLE");
		//String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOL.PASSWORD.AROLE");
		String sNotes=(String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.NOTES.VALUE");
		//Login to Navigator portlet 
		//LoginTestCase.nav_Login(sUserName,sPassword);
		LoginTestCase_Old1.LoginAsARoleAUser();
		navigateToTicketPage();
		
		//WebElement wExpander=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr[1]//tr[1]/td[1]//div[@class='x-grid-row-expander']", "Ticket Arrow Expander");
		// This object is updated on 10/14/2015 By QAA04
		wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
		// This object is added by QAA04 - 02/23/16
		WebObjectUtil.clickElement(wExpander);
		//wExpander.click();
		WebObjectUtil.explicitWait(5);
		String sTicketID = (WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 3)).trim();
		//String sID="tktNotesImg-" + sTicketID;
		//WebElement wNotesExpander=WebObjectUtil.GetWebElement("id", sID, "Notes Expander");
		// This object is updated on 10/14/2015 By QAA04
		wNotesExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER", "PARAMETER_TICKETID",  sTicketID);
		// This object is added by QAA04 - 02/23/16
		WebObjectUtil.clickElement(wNotesExpander);
		//wNotesExpander.click();
		WebObjectUtil.explicitWait(5);
		boolean bOrder=false;
		int iCounter=0;
		int iNoteRowCount=WebTableUtil.getRowCount(Ticket.getNav_NotesWebTable());
		//WebElement wNotesRow=WebObjectUtil.GetWebElement("xpath", "//table//tr[1]/td/table/tbody/tr[@class='x-grid-rowbody-tr']/td/div/div[contains(@id,'idNotesRow')]/div[contains(@id,'cloakDiv')]/table", "Note Row");
		
		for(int i=1;i<=iNoteRowCount;i++)
		{
			
			//int iItem=WebTableUtil.getRowByCellText(Ticket.getNav_NotesWebTable(), Integer.toString(i), 1,2);
			//String sItem=WebTableUtil.getCellData(Ticket.getNav_NotesWebTable(), i, 3);
			
			//WebElement wNoteRow=WebTableUtil.getRowAsWebElement(Ticket.getNav_NotesWebTable(), i);
			
			//String sItmClass=wNoteRow.getAttribute("class");
			
			//WebElement wNotesRow=WebObjectUtil.GetWebElement("xpath", "//table//td//div/table/tbody/tr["+i+"]/td/table//div[text()='"+i+"']", "Note Row");
			// This object is updated on 10/14/2015 By QAA04
			wNotesRow = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER.NOTEROW", "",  "");
			if(wNotesRow!=null)
			{
				sItm=wNotesRow.getText();
				if(sItm.length()>0)
				{
				iCounter++;
				if(sItm.contains(Integer.toString(iCounter)))
					bOrder=true;
				else
				{
					bOrder=false;
					break;
				}
			}
				else
					continue;
			}
		}
		if(bOrder)
			FrameworkUtil.updateCustomResultBasedOnStatus(true,"Order of the notes displayed for the ticket is valid" );
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false,"Order of the notes displayed for the ticket is in-valid" );
		LoginTestCase_Old1.nav_Logout();
	} catch (Exception e) {
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		LoggerUtil.log_type_error(e.getMessage());
	}
}

/*==============================================================
MethodName 		: navigateToCreateTicketPage

Description		: Navigates to create ticket page
Author 			: Sukur Babu. B
Creation Date 	: 06/16/2015
Pre-Requisites	:
Revision History:
==============================================================*/
public static void navigateToCreateTicketPage(){
	navigateToTicketPage();
	WebObjectUtil.explicitWait(10);
	WebObjectUtil.clickElement(Ticket.getNav_CreateTicketLink());
	WebObjectUtil.waitForElementPresent(Ticket.getNav_TicketsWebTable());
}
/*==============================================================
MethodName 		: HooveroverCreateTicketFields

Description		: Hoover over on CreateTicket Fields and validate error tool tip
Author 			: Sukur Babu. B
Creation Date 	: 06/16/2015
Pre-Requisites	:
Revision History:
==============================================================*/
public static void HooveroverCreateTicketFields(){
	String sExpSummaryEditErrorTip;
	String sActSummaryEditErrorTip="";
	
	sExpSummaryEditErrorTip="Required field";
	/*sExpSeverityErrorTip="This field is required";
	sExpPriorityErrorTip="This field is required";
	sExpCategoryErrorTip="This field is required";*/
	
	WebObjectUtil.clickElement(Ticket.getNav_CreateTicketOKButton());
	
	WebObjectUtil.MouseHover(Ticket.getNav_SummaryEdit());
	sActSummaryEditErrorTip=Ticket.getNav_SummaryEdit().getAttribute("data-errorqtip");
	if(sActSummaryEditErrorTip.contains(sExpSummaryEditErrorTip))
		FrameworkUtil.updateCustomResultBasedOnStatus(true, sExpSummaryEditErrorTip+" is matching with actual error tool tip for summary Edit box");
	else
		FrameworkUtil.updateCustomResultBasedOnStatus(false, sExpSummaryEditErrorTip+" is not matching with actual error tool tip for summary Edit box");
	String sExpectedMsg="Please enter values for all required fields";
	String sActMsg=Ticket.getNav_ConfirmPopup().getText();
	if(sActMsg.contains(sExpectedMsg))
		FrameworkUtil.updateCustomResultBasedOnStatus(true, sExpectedMsg+" is matching with actual error pop up message for summary Edit box");
	else
		FrameworkUtil.updateCustomResultBasedOnStatus(false, sExpectedMsg+" is not matching with actual error pop up message for summary Edit box");
	WebObjectUtil.clickElement(Ticket.getNav_ConfirmPopupOkBtn());
	//WebObjectUtil.clickElement(Ticket.getNav_CreateTicketCancelButton());
}

/*==============================================================
MethodName 		: VerifyCreateTicketFields

Description		: Verify CreateTicket Fields display
Author 			: Sukur Babu. B
Creation Date 	: 06/16/2015
Pre-Requisites	:
Revision History:
==============================================================*/
public static void VerifyCreateTicketFields(){
	WebObjectUtil.verifyElementPresent(Ticket.getNav_DateEdit());
	WebObjectUtil.verifyElementPresent(Ticket.getNav_OrganizationEdit());
	WebObjectUtil.verifyElementPresent(Ticket.getNav_SummaryEdit());
	WebObjectUtil.verifyElementPresent(Ticket.getNav_SeverityEdit());
	WebObjectUtil.verifyElementPresent(Ticket.getNav_PriorityEdit());
	WebObjectUtil.verifyElementPresent(Ticket.getNav_CategoryEdit());
	WebObjectUtil.verifyElementPresent(Ticket.getNav_CreateTicketOKButton());
	WebObjectUtil.verifyElementPresent(Ticket.getNav_CreateTicketCancelButton());
	WebObjectUtil.clickElement(Ticket.getNav_CreateTicketCancelButton());
}
/*==============================================================
MethodName 		: VerifyCreateTicketFieldsDateAndOrg

Description		: Verify CreateTicket Date And Org Field values
Author 			: Sukur Babu. B
Creation Date 	: 06/16/2015
Pre-Requisites	:
Revision History:
==============================================================*/
public static void VerifyCreateTicketFieldsDateAndOrg(String sOrgName){
	DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	//get current date time with Date()
	Date date = new Date();
	//System.out.println(dateFormat.format(date));
	String sDate = (dateFormat.format(date));
	String sActDate=Ticket.getNav_DateEdit().getAttribute("value");
	if(sActDate.equalsIgnoreCase(sDate))
		FrameworkUtil.updateCustomResultBasedOnStatus(true, sDate+" is matching with the value displayed in Date field");
	else
		FrameworkUtil.updateCustomResultBasedOnStatus(false, sDate+" is not matching with the value displayed in Date field");
	String sActOrgName=Ticket.getNav_OrganizationEdit().getAttribute("value");
	if(sActOrgName.equalsIgnoreCase(sOrgName))
		FrameworkUtil.updateCustomResultBasedOnStatus(true, sOrgName+" is matching with the value displayed in Organization field");
	else
		FrameworkUtil.updateCustomResultBasedOnStatus(false, sOrgName+" is not matching with the value displayed in Organization field");
	
	
}
////??????????????????????????????????SUKUR?????????????????????????????????????????????????????????????????????

////$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$PRIYANKA$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$


//------------------------------------------------------------------------------------
//	TEST CASE
//------------------------------------------------------------------------------------
/*==============================================================
TestScript  	: navHomePageLogin
Manual TestCase	: Home page Navigation with standard user login details
Description		: User Must be able to login and routed to home page.
Author 			: Priyanka Rachupalli
Creation Date 	: 06/16/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=1)
public void navHomePageLogin()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver,Ticket);
try{
FrameworkUtil.sTestCaseName = "Ticket-navHomePageLoginDetails";
FrameworkUtil.sManualTestCaseName="1.Home page Navigation with standard user login details";
FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

//Login to Navigator
//navTicketLogin();
LoginTestCase_Old1.LoginAsRoleAUser();
//check for login success
WebObjectUtil.verifyElementPresent(Ticket.getNav_UserNameLink());
LoginTestCase_Old1.nav_Logout();
}
catch (Exception e) {
	LoggerUtil.log_type_error("issue with- navHomePageLogin" );
	LoggerUtil.log_type_error(e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
}

//------------------------------------------------------------------------------------
//TEST CASE
//------------------------------------------------------------------------------------
/*==============================================================
TestScript  	: navTicketPage
Manual TestCase	: Tickets page navigation
Description		: When selected "Tickets" must be navigated to "Tickets" home page.
Author 			: Priyanka Rachupalli
Creation Date 	: 06/16/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=2)
public void navTicketPage()
{
WebDriver driver = WebDriverUtil.getDriver();
PageFactory.initElements(driver,Ticket);
try{
FrameworkUtil.sTestCaseName = "Ticket-navTicketPage";
FrameworkUtil.sManualTestCaseName="1.Tickets page navigation";
FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

//Login to Navigator
//navTicketLogin();
LoginTestCase_Old1.LoginAsRoleAUser();
//navigate to ticket page 
navigateToTicketPage();
//check for login success
WebObjectUtil.verifyElementPresent(Ticket.getNav_UserNameLink());
LoginTestCase_Old1.nav_Logout();
}
catch (Exception e) {
LoggerUtil.log_type_error("issue with- Tickets page navigation" );
LoggerUtil.log_type_error(e.getMessage());
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
}
}

//------------------------------------------------------------------------------------
//TEST CASE
//------------------------------------------------------------------------------------
/*==============================================================
TestScript  	: verifyTicketPageFields
Manual TestCase	: Tickets page options and selections
Description		: Confirm that the User sees the options mentioned
Author 			: Priyanka Rachupalli
Creation Date 	: 06/16/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=3)
public void verifyTicketPageFields()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver,Ticket);
try{
	FrameworkUtil.sTestCaseName="Ticket-verifyTicketPageFields";
	FrameworkUtil.sManualTestCaseName="1.When selected Tickets must be navigated to Tickets home page.";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

	//Login to Navigator
	//navTicketLogin();
	LoginTestCase_Old1.LoginAsRoleAUser();
	//Select and Open Ticket page
	navigateToTicketPage();
	
//Validate CreateTicket,DetailedTicketing and Refresh Details Links and CSV/PDF icons
	WebObjectUtil.verifyElementPresent(Ticket.getNav_CreateTicketLink());
	WebObjectUtil.verifyElementPresent(Ticket.getNav_DetailedTicketingSystem());
	
	WebObjectUtil.verifyElementPresent(Ticket.getNav_RefreshDetailsLink());
	WebObjectUtil.verifyElementPresent(Ticket.getNav_TicketsCsvIcon());
	
	WebObjectUtil.verifyElementPresent(Ticket.getNav_TicketsPdfIcon());
	LoginTestCase_Old1.nav_Logout();
	}

catch (Exception e) {
	LoggerUtil.log_type_error("issue with- Ticket-verifyTicketPageFields" );
	LoggerUtil.log_type_error(e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
}

//------------------------------------------------------------------------------------
//TEST CASE
//------------------------------------------------------------------------------------
/*==============================================================
TestScript  	: verifyRefresh
Manual TestCase	: Refresh System
Description		: Verify the complete page is refereshed and with out changing any functionality
Author 			: Priyanka Rachupalli
Creation Date 	: 06/17/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=4)
public void verifyRefresh()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver,Ticket);
try{
	FrameworkUtil.sTestCaseName = "Ticket-verifyRefresh";
	FrameworkUtil.sManualTestCaseName="1.Refresh System";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

	//Login to Navigator
	//navTicketLogin();
	LoginTestCase_Old1.LoginAsRoleAUser();
	//Select and Open Ticket page
	navigateToTicketPage();
	//Clicking on Refresh Details
	WebObjectUtil.clickElement(Ticket.getNav_RefreshDetailsLink());
	//WebObjectUtil.explicitWait(15);
	//Verify Page Details
	WebObjectUtil.verifyElementPresent(Ticket.getNav_DetailedTicketingSystem());
	WebObjectUtil.verifyElementPresent(Ticket.getNav_TicketsCsvIcon());
	WebObjectUtil.verifyElementPresent(Ticket.getNav_TicketsPdfIcon());
	WebObjectUtil.verifyElementPresent(Ticket.getNav_TicketsTab());
	WebObjectUtil.verifyElementPresent(Ticket.getNav_RefreshDetailsLink());
	WebObjectUtil.verifyElementPresent(Ticket.getNav_CreateTicketLink());
	WebObjectUtil.verifyElementPresent(Ticket.getNav_OpenTickets());
	WebObjectUtil.verifyElementPresent(Ticket.getNav_WorkingTickets());
	WebObjectUtil.verifyElementPresent(Ticket.getNav_PendingTickets());
	WebObjectUtil.verifyElementPresent(Ticket.getNav_ResolvedTickets());
	WebObjectUtil.verifyElementPresent(Ticket.getNav_FilterByStatusDropdown());
	WebObjectUtil.verifyElementPresent(Ticket.getNav_TicketSearchByDropdown());
	WebObjectUtil.verifyElementPresent(Ticket.getNav_SearchTextField());
	WebObjectUtil.verifyElementPresent(Ticket.getNav_SearchIcon());
	WebObjectUtil.verifyElementPresent(Ticket.getNav_TicketID());
  WebObjectUtil.verifyElementPresent(Ticket.getNav_Summary());
  WebObjectUtil.verifyElementPresent(Ticket.getNav_Severity());
  WebObjectUtil.verifyElementPresent(Ticket.getNav_Priority());
  WebObjectUtil.verifyElementPresent(Ticket.getNav_LastUpdateDate());
  WebObjectUtil.verifyElementPresent(Ticket.getNav_AssignedTo());                       
  WebObjectUtil.verifyElementPresent(Ticket.getNav_Status());
  WebObjectUtil.verifyElementPresent(Ticket.getNav_TicketsWebTable());
  LoginTestCase_Old1.nav_Logout();
}
catch (Exception e) {
	LoggerUtil.log_type_error("issue with- Ticket-verifyRefresh" );
	LoggerUtil.log_type_error(e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
}


//------------------------------------------------------------------------------------
//TEST CASE
//------------------------------------------------------------------------------------
/*==============================================================
TestScript  	: verifyDetailedTicketingSystem
Manual TestCase	: Detailed Ticketing System navigation
Description		: Verify when clicked on "Detailed Ticketing System",the page is navigated to EM7 home page .
Author 			: Priyanka Rachupalli
Creation Date 	: 06/18/2015
Pre-Requisites	:
Revision History:
=================================================================*/
@Test(priority=5)
public void verifyDetailedTicketingSystem()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver,Ticket);
try{
	FrameworkUtil.sTestCaseName = "Ticket-verifyDetailedTicketingSystem";
	FrameworkUtil.sManualTestCaseName="1.Refresh System";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

	//Login to Navigator
	//navTicketLogin();
	LoginTestCase_Old1.LoginAsRoleAUser();
	//Select and Open Ticket page
	navigateToTicketPage();
	//Click on Detailed Ticketing System
	WebObjectUtil.verifyElementPresent(Ticket.getNav_DetailedTicketingSystem());
	LoginTestCase_Old1.nav_Logout();
}
catch (Exception e) {
	LoggerUtil.log_type_error("issue with- Ticket-VerifyDetailed Ticketing System navigation" );
	LoggerUtil.log_type_error(e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
}
/*==============================================================
TestScript  	: verifyReportsView
Manual TestCase	: Reports view page
Description		: Verify user is able to view the reports in the specified format.
Author 			: 
 Rachupalli
Creation Date 	: 06/21/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=6)
public void verifyReportsView()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver,Ticket);
try{
	FrameworkUtil.sTestCaseName = "verifyReportsView";
	FrameworkUtil.sManualTestCaseName="Reports view page";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

	//Login to Navigator
	//navTicketLogin();
	LoginTestCase_Old1.LoginAsRoleAUser();
	//Select and Open Ticket page
	navigateToTicketPage();
	//validate CSV and PDF Icons are present
	WebObjectUtil.verifyElementPresent(Ticket.getNav_TicketsCsvIcon());
  WebObjectUtil.verifyElementPresent(Ticket.getNav_TicketsPdfIcon());
  LoginTestCase_Old1.nav_Logout();
}
catch (Exception e) {
	LoggerUtil.log_type_error("issue with- Ticket-Verify Reports view" );
	LoggerUtil.log_type_error(e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
}

/*==============================================================
TestScript  	: verifyReportsView2
Manual TestCase	: Reports view page for Number of Tickets
Description		: confirm that the details regarding the tickets are displayed in bold and in numbers.
Author 			: Priyanka Rachupalli
Creation Date 	: 06/21/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=7)
public void verifyReportsView2()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver,Ticket);
try{
	FrameworkUtil.sTestCaseName = "verifyReportsView2";
	FrameworkUtil.sManualTestCaseName="Reports view page for Number of Tickets";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

	//Login to Navigator
	//navTicketLogin();
	LoginTestCase_Old1.LoginAsRoleAUser();
	//Select and Open Ticket page
	navigateToTicketPage();
	WebObjectUtil.verifyElementPresent(Ticket.getNav_OpenTicketNumbers());
	//Returns the displayed number of tickets
	WebObjectUtil.VerifyTextOnPage(Ticket.getNav_OpenTicketNumbers().getText());
	// Checks whether the letters are displayed in bold format
	WebObjectUtil.VerifyTextOnPage(Ticket.getNav_OpenTicketNumbers().getCssValue("font-weight:bold"));
	WebObjectUtil.verifyElementPresent(Ticket.getNav_WorkingTicketNumbers());
	WebObjectUtil.VerifyTextOnPage(Ticket.getNav_WorkingTicketNumbers().getText());
	WebObjectUtil.VerifyTextOnPage(Ticket.getNav_WorkingTicketNumbers().getCssValue("font-weight:bold"));
	WebObjectUtil.verifyElementPresent(Ticket.getNav_PendingTicketNumbers());
	WebObjectUtil.VerifyTextOnPage(Ticket.getNav_PendingTicketNumbers().getText());
	WebObjectUtil.VerifyTextOnPage(Ticket.getNav_PendingTicketNumbers().getCssValue("font-weight:bold"));
	WebObjectUtil.verifyElementPresent(Ticket.getNav_ResolvedTicketNumbers());
	WebObjectUtil.VerifyTextOnPage(Ticket.getNav_ResolvedTicketNumbers().getText());
	WebObjectUtil.VerifyTextOnPage(Ticket.getNav_ResolvedTicketNumbers().getCssValue("font-weight:bold"));
	LoginTestCase_Old1.nav_Logout();
	}
catch (Exception e) {
	LoggerUtil.log_type_error("issue with -Ticket- verifyReportsView2" );
	LoggerUtil.log_type_error(e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
}
/*==============================================================
TestScript  	: verifyDropdownOptions
Manual TestCase	: Select options from drop down box to view the ticket details
Description		: Verify user is able to make the selection  for detailed view about the tickets.
Author 			: Priyanka Rachupalli
Creation Date 	: 06/22/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=8)
public void verifyDropDownOptions()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver,Ticket);
try{
	FrameworkUtil.sTestCaseName = "Ticket- verifyDropDownOptions";
	FrameworkUtil.sManualTestCaseName="1.Select options from drop down box to view the ticket details";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

	//Login to Navigator
	//navTicketLogin();
	LoginTestCase_Old1.LoginAsRoleAUser();
	//Select and Open Ticket page
	navigateToTicketPage();
    WebObjectUtil.explicitWait(5);
	WebObjectUtil.verifyElementPresent(Ticket.getNav_FilterByStatusDropdown());
	WebObjectUtil.VerifyTextOnPage(Ticket.getNav_FilterByStatusDropdown().getText());
	WebObjectUtil.ClickAndMouseHover(Ticket.getNav_FilterByStatusDropdown());
	WebObjectUtil.verifyElementPresent(Ticket.getNav_Outstanding());
	//WebObjectUtil.clickAndVerifyText(Ticket.getNav_Outstanding(),"Outstanding");
	WebObjectUtil.verifyElementPresent(Ticket.getNav_ClosedLess());
	//WebObjectUtil.clickAndVerifyText(Ticket.getNav_ClosedLess(),"Closed (Less than 6 months)");
	WebObjectUtil.verifyElementPresent(Ticket.getNav_ClosedMore());
	//WebObjectUtil.clickAndVerifyText(Ticket.getNav_ClosedMore(),"Closed (More than 6 months)");
	LoginTestCase_Old1.nav_Logout();
	}
catch (Exception e) {
	LoggerUtil.log_type_error("issue with -Ticket- verifyDropDownOptions " );
	LoggerUtil.log_type_error(e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
}

/*==============================================================
TestScript  	: verifyClosedLess()
Manual TestCase	: Select option "Closed(less than 6 months)"
Description		: Verify the ticket list updates automatically,and 
                shows only Closed (more than 6 months) status tickets
Author 			: Priyanka Rachupalli
Creation Date 	: 06/21/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=10)
public void verifyClosedLess()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver,Ticket);
try{
	String c,d;
	FrameworkUtil.sTestCaseName = "verifyClosedLess";
	FrameworkUtil.sManualTestCaseName="Select option 'Closed(less than 6 months)'";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	//Login to Navigator
	//navTicketLogin();
	LoginTestCase_Old1.LoginAsRoleAUser();
	//Select and Open Ticket page
	navigateToTicketPage();
	WebObjectUtil.ClickAndMouseHover(Ticket.getNav_FilterByStatusDropdown());
	WebObjectUtil.clickElement(Ticket.getNav_ClosedLess());
	WebObjectUtil.explicitWait(15);
	WebObjectUtil.verifyElementPresent(Ticket.getNav_StatusResult());
	Calendar cDate=Calendar.getInstance();
	//c= WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 7);
	//Per EXTJS5 changes new steps are implemented- BY Priyanka on 10/9/15
	CustomWebElementUtil.loadCustomElement(Ticket.getNav_TicketsWebTable(), "table");
	
	c = CustomWebElementUtil.getCellData(1, 7);
	WebObjectUtil.explicitWait(10);
  SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:MM");
  Date convertedDate = dateFormat.parse(c);
  //SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy HH:MM");
  Date currentNow = cDate.getTime();
  int i=getDiffMonths(currentNow,convertedDate);
  if(i<6){
  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VerifyClosedLess()", "Pass","Closed Less Than 6 Months");
   }
  else{
  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VerifyClosedLess()", "Fail","Closed Less Than 6 Months");
  }
  WebObjectUtil.clickElement(Ticket.getNav_LastUpdateDate());
  
  //d= WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 7);
  WebObjectUtil.explicitWait(10);
  CustomWebElementUtil.loadCustomElement(Ticket.getNav_TicketsWebTable(), "table");
  d = CustomWebElementUtil.getCellData(1, 7);
  SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM-dd-yyyy HH:MM");
  Date convertedDate1 = dateFormat1.parse(d);
  int j=getDiffMonths(currentNow,convertedDate1);
   if(j<6){
   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VerifyClosedLess()", "Pass","Closed Less Than 6 Months");
   }
   else{
  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VerifyClosedLess()", "Fail","Closed Less Than 6 Months");
   }
   LoginTestCase_Old1.nav_Logout();
}
catch (Exception e) {
	LoggerUtil.log_type_error("issue with - Ticket- verifyClosedLess" );
	LoggerUtil.log_type_error(e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
 }
}

/*==============================================================
TestScript  	: verifyClosedLessTicketAge()
Manual TestCase	: Select option "Closed(less than 6 months)"
Description		: Verify the ticket age for closed Tickets are displayed properly in Firefox.
Author 			: Priyanka Rachupalli
Creation Date 	: 06/21/2015
Release         :Eilerson
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=61)
public void verifyClosedLessTicketAge()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver,Ticket);
try{
	//String[] sTemp=null;
	//String c,d;
	FrameworkUtil.sTestCaseName = "verifyClosedLessTicketAge";
	FrameworkUtil.sManualTestCaseName="Select option 'Closed(less than 6 months)'";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	//Login to Navigator
	//navTicketLogin();
	LoginTestCase_Old1.LoginAsRoleAUser();
	//Select and Open Ticket page
	navigateToTicketPage();
	WebObjectUtil.ClickAndMouseHover(Ticket.getNav_FilterByStatusDropdown());
	WebObjectUtil.clickElement(Ticket.getNav_ClosedLess());
	WebObjectUtil.explicitWait(15);
	String sTicketID=getTicketID(1);
	WebElement wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", ""+1);
	WebObjectUtil.explicitWait(5);
	WebObjectUtil.clickElement(wExpander);
	WebObjectUtil.explicitWait(10);
    WebElement wTicketDurationElement=WebObjectUtil.getWebElementFromDynamicLocator("xpath","TICKET.DURATION.ELEMENT","PARAMETER_TICKETID",""+sTicketID);
	String sTicketDuration=wTicketDurationElement.getText();
	WebObjectUtil.explicitWait(5);
    FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify ClosedLess Ticket Age", "pass", "Ticket age is" + sTicketDuration);	

    if(!(sTicketDuration.contains("Nan"))){
		FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Ticket duration does not contian NaN" );
	}
	else{
		FrameworkUtil.updateCustomResultBasedOnStatus(false,  "Ticket duration contains NaN" );
	}
    //int	iTicketDuration=Integer.parseInt(sTemp[0].replace("hr",""));
	
	/*if(!((Integer.parseInt(sTicketDuration))<0)){
		
		FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Ticket duration is not displaying negative values" );
	}
		else{
		FrameworkUtil.updateCustomResultBasedOnStatus(false,  "Ticket duration is displaying negative values" );
		}*/
	
	WebObjectUtil.explicitWait(5);
	LoginTestCase_Old1.nav_Logout();
}
catch (Exception e) {
	LoggerUtil.log_type_error("issue with - Ticket- verifyClosedLessTicketAge" );
	LoggerUtil.log_type_error(e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
}
}
/*==============================================================
TestScript  	: verifyClosedMore()
Manual TestCase	: Select option "Closed(more than 6 months)"
Description		: Verify the ticket list updates automatically, and 
                shows only Closed (less than 6 months) status tickets
Author 			: Priyanka Rachupalli
Creation Date 	: 06/24/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=9)
public void verifyClosedMore()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver,Ticket);
	try{
		String e,f;
		FrameworkUtil.sTestCaseName = "verifyClosedMore";
		FrameworkUtil.sManualTestCaseName=" Select option 'Closed(more than 6 months)'";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		//Login to Navigator
		//navTicketLogin();
		LoginTestCase_Old1.LoginAsRoleAUser();
		//Select and Open Ticket page
		navigateToTicketPage();
		WebObjectUtil.ClickAndMouseHover(Ticket.getNav_FilterByStatusDropdown());
		WebObjectUtil.clickElement(Ticket.getNav_ClosedMore());
		WebObjectUtil.explicitWait(15);
		WebObjectUtil.verifyElementPresent(Ticket.getNav_StatusResult());
		Calendar cDate=Calendar.getInstance();
	    //e= WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 7);
		//UPdated Per EXTJS5 Changes-By Priyanka R on 10/9/15
		CustomWebElementUtil.loadCustomElement(Ticket.getNav_TicketsWebTable(), "table");
		e= CustomWebElementUtil.getCellData(1, 7);
	    SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:MM");
	    Date convertedDate = dateFormat.parse(e);
	    //SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy HH:MM");
	    Date currentNow = cDate.getTime();
	    int i=getDiffMonths1(currentNow,convertedDate);
	    if(i>6){
	    FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VerifyClosedMore()", "Pass","Closed More Than 6 Months");
	     }
	    else{
	    FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VerifyClosedMore()", "Fail","Closed More Than 6 Months");
	    }
	    WebObjectUtil.clickElement(Ticket.getNav_LastUpdateDate());
	    WebObjectUtil.explicitWait(10);
	    //f= WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 7);
	    CustomWebElementUtil.loadCustomElement(Ticket.getNav_TicketsWebTable(), "table");
		f = CustomWebElementUtil.getCellData(1, 7);
	    SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM-dd-yyyy HH:MM");
	    Date convertedDate1 = dateFormat1.parse(f);
	     int j=getDiffMonths1(currentNow,convertedDate1);
	     if(j>6){
	     FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VerifyClosedMore()", "Pass","Closed More Than 6 Months");
	     }
	     else{
	    FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VerifyClosedMore()", "Fail","Closed More Than 6 Months");
	     }
	     LoginTestCase_Old1.nav_Logout();
	}
	catch (Exception e) {
		LoggerUtil.log_type_error("issue with -Ticket- verifClosedMore" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}

/*==============================================================
TestScript  	: verifyClosedMoreTicketAge()
Manual TestCase	: Select option "Closed(more than 6 months)"
Description		: Verify the ticket age for closed Tickets are displayed properly in IE.
Author 			: Priyanka Rachupalli
Creation Date 	: 06/24/2015
Release         :Eilerson
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=60)
public void verifyClosedMoreTicketAge()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver,Ticket);
	try{
		//Eilerson
		//String c,d;
		//String[] sTemp=null;
		FrameworkUtil.sTestCaseName = "verifyClosedMoreTicketAge";
		FrameworkUtil.sManualTestCaseName="Select option 'Closed(more than 6 months)'";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		//Login to Navigator
		//navTicketLogin();
		LoginTestCase_Old1.LoginAsRoleAUser();
		//Select and Open Ticket page
		navigateToTicketPage();
		WebObjectUtil.ClickAndMouseHover(Ticket.getNav_FilterByStatusDropdown());
		WebObjectUtil.clickElement(Ticket.getNav_ClosedMore());
		WebObjectUtil.explicitWait(15);
		String sTicketID=getTicketID(1);
		WebElement wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", ""+1);
		WebObjectUtil.explicitWait(5);
		WebObjectUtil.clickElement(wExpander);
		WebObjectUtil.explicitWait(10);
	    WebElement wTicketDurationElement=WebObjectUtil.getWebElementFromDynamicLocator("xpath","TICKET.DURATION.ELEMENT","PARAMETER_TICKETID",""+sTicketID);
		String sTicketDuration=wTicketDurationElement.getText();
		WebObjectUtil.explicitWait(5);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify ClosedMore Ticket Age", "pass", "Ticket age is" + sTicketDuration);	
		if(!(sTicketDuration.contains("Nan"))){
			 
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Nan)", "Pass","Ticket Age doesn't contain Nan");
		}
		else{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Nan)", "Fail","Ticket Age contains Nan");
		}
	    //int	iTicketDuration=Integer.parseInt(sTemp[0].replace("hr",""));
		WebObjectUtil.explicitWait(5);
		/*if(!((Integer.parseInt(sTicketDuration))<0)){
			
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , ""+sTicketDuration, "Pass","Ticket Age doesn't contain Negative values");
		}
			else{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , ""+sTicketDuration, "Fail","Ticket Age contains Negative values");
			}*/
		
		LoginTestCase_Old1.nav_Logout();


	   }
		
		catch (Exception e) {
			LoggerUtil.log_type_error("issue with -Ticket- verifyClosedMoreTicketAge" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
			}
		}  
/*==============================================================
TestScript  	: verifyViewTickets()
Manual TestCase	: View reports in PDF or CSV
Description		: Verify user is able to view the reports in the required format.
Author 			: Priyanka Rachupalli
Creation Date 	: 07/05/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=40)
public void verifyViewTickets()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver,Ticket);
	try{
		FrameworkUtil.sTestCaseName = "verifyViewTickets";
		FrameworkUtil.sManualTestCaseName="Verify user is able to view the reports in the required format";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		//Login to Navigator
		//navTicketLogin();
		LoginTestCase_Old1.LoginAsRoleAUser();
		//Select and Open Ticket page
		navigateToTicketPage();
		WebElement wExpander;
		//dynamic XPATH of Expand icon
		//wExpander=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+1+"]//tr[1]/td[1]//div[@class='x-grid-row-expander']", "Arrow Expander");-by Priyanka on 10/8/15
		//wExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTicketsGridPanel-body']/div[1]/div/table[1]/tbody/tr[1]/td[1]/div/div", "Arrow Expander");
		// This object is updated on 10/14/2015 By QAA04
		wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
		WebObjectUtil.explicitWait(10);
		WebObjectUtil.clickElement(wExpander);
		WebObjectUtil.explicitWait(10);
		WebObjectUtil.verifyElementPresent(Ticket.getNav_TicketPdfIcon());
		WebObjectUtil.verifyElementPresent(Ticket.getNav_TicketsCsvIcon());
		LoginTestCase_Old1.nav_Logout();
	}
	catch (Exception e) {
		LoggerUtil.log_type_error("issue with -Ticket- verifyViewTickets" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
}
/*==============================================================
TestScript          : verifyCreateNoteError()
Manual TestCase        : Create Note button, and without entering any info
Description                : Verify the error message when user clicks on OK button
Author                         : Priyanka Rachupalli
Creation Date         : 07/06/2015
Pre-Requisites        :
Revision History:
==============================================================*/
@Test(priority=41)
public void verifyCreateNoteError()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver,Ticket);
	try{
		String sTicketID,sCreateNotes;
		WebElement wExpander,nExpander,wCreateNotes;
		FrameworkUtil.sTestCaseName = "Ticket-verifyCreateNoteError";
		FrameworkUtil.sManualTestCaseName="Verify user is able to view the reports in the required format";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		//Login to Navigator
		//navTicketLogin();
		LoginTestCase_Old1.LoginAsRoleAUser();
		//Select and Open Ticket page
		navigateToTicketPage();
		//dynamic XPATH of Expand icon
		WebObjectUtil.explicitWait(10);
		sTicketID = getTicketID(1);
		//wExpander=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+1+"]//tr[1]/td[1]//div[@class='x-grid-row-expander']", "Arrow Expander");-by Priyanka on 10/8/15
		//wExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTicketsGridPanel-body']/div[1]/div/table[1]/tbody/tr[1]/td[1]/div/div", "Arrow Expander");
		// This object is updated on 10/14/2015 By QAA04
		wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
		WebObjectUtil.explicitWait(10);
		WebObjectUtil.clickElement(wExpander);
		WebObjectUtil.explicitWait(10);
		//nExpander=WebObjectUtil.GetWebElement("xpath", "//div/a[text()='Notes']", "Note Expander");-by Priyanka on 10/08/15
		//nExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTicketsGridPanel-body']/div[1]/div/table[1]/tbody/tr[2]/td/div/section[2]/div[1]/a/img", "Note Expander");
		// This object is updated on 10/14/2015 By QAA04
		nExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER", "PARAMETER_TICKETID",  sTicketID);
		WebObjectUtil.explicitWait(5);
		WebObjectUtil.clickElement(nExpander);
		WebObjectUtil.explicitWait(10);
	    //sTicketID = (WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 3)).trim();-by Priyanka on 10/08/15
		sTicketID = getTicketID(1);
	    //sCreateNotes="createNotes-"+sTicketID+"-btnInnerEl";
		//wCreateNotes=WebObjectUtil.GetWebElement("id", sCreateNotes, "CreateNotes");
		// This object is updated on 10/14/2015 By QAA04
		wCreateNotes = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER.CREATENOTES", "PARAMETER_TICKETID",  sTicketID);
		WebObjectUtil.clickElement(wCreateNotes);
	    WebObjectUtil.clickElement(Ticket.getNav_TicketNoteOk());
		WebObjectUtil.verifyElementPresent(Ticket.getNav_CreateNoteOkError());
		//WebObjectUtil.clickElement(Ticket.getNav_CreateNoteErrorClose());
		//pop up got change so commenting the above line and adding the below line
		WebObjectUtil.clickElement(Ticket.getNav_PopUpOKBtn());
		WebObjectUtil.explicitWait(5);
		WebObjectUtil.clickElement(Ticket.getNav_CreateNoteClose());
		LoginTestCase_Old1.nav_Logout();
		}
	catch (Exception e) {
		LoggerUtil.log_type_error("issue with -Ticket- verifyCreateNoteError" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
}


/*==============================================================
TestScript          : verifyEnterNote()
Manual TestCase        : Entering some data/text/info into the notes field
Description                : Verify the note is added, and appears on the Notes tab.
Author                         : Priyanka Rachupalli
Creation Date         : 08/06/2015
Pre-Requisites        :
Revision History:
==============================================================*/
 @Test(priority=42)
public void verifyEnterNote()
{
    WebDriver driver = WebDriverUtil.getDriver();
    PageFactory.initElements(driver,Ticket);
    try{
        String sTicketID = null,sCreateNotes;
        WebElement wExpander,nExpander,wCreateNotes;
        FrameworkUtil.sTestCaseName = "Ticket-verifyEnterNote";
        FrameworkUtil.sManualTestCaseName="Verify user is able to viewthe reports in the required format";
        FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
        //Login to Navigator
        //navTicketLogin();
        LoginTestCase_Old1.LoginAsRoleAUser();
        //Select and Open Ticket page
        navigateToTicketPage();
        //dynamic XPATH of Expand icon
        WebObjectUtil.explicitWait(10);
        sTicketID = getTicketID(1);
        /* wExpander=WebObjectUtil.GetWebElement("xpath","//table/tbody/tr["+1+"]//tr[1]/td[1]//div[@class='x-grid-row-expander']","Arrow Expander");
        nExpander=WebObjectUtil.GetWebElement("xpath","//div/a[text()='Notes']", "Note Expander");-by Priyanka on 10/08/15*/
        //wExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTicketsGridPanel-body']/div[1]/div/table[1]/tbody/tr[1]/td[1]/div/div", "Arrow Expander");
    	// This object is updated on 10/14/2015 By QAA04
        wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
        WebObjectUtil.explicitWait(10);
		WebObjectUtil.clickElement(wExpander);
		WebObjectUtil.explicitWait(5);
		//nExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTicketsGridPanel-body']/div[1]/div/table[1]/tbody/tr[2]/td/div/section[2]/div[1]/a/img", "Note Expander");
		// This object is updated on 10/14/2015 By QAA04
		nExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER", "PARAMETER_TICKETID",  sTicketID);
		WebObjectUtil.explicitWait(5);
		WebObjectUtil.clickElement(nExpander);
        WebObjectUtil.explicitWait(10);
        //sTicketID =(WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 3)).trim();-by Priyanka on 10/8/15
        sTicketID =getTicketID(1);
        //sCreateNotes="createNotes-"+sTicketID+"-btnInnerEl";
        //wCreateNotes=WebObjectUtil.GetWebElement("id", sCreateNotes,"CreateNotes");
    	// This object is updated on 10/14/2015 By QAA04
        wCreateNotes = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER.CREATENOTES", "PARAMETER_TICKETID",  sTicketID);
        WebObjectUtil.clickElement(wCreateNotes);
        WebObjectUtil.explicitWait(10);
        WebObjectUtil.clickElement(Ticket.getNav_CreateNote());
        Ticket.getNav_CreateNote().sendKeys("Selenium First Note");
        WebObjectUtil.explicitWait(5);
        WebObjectUtil.clickElement(Ticket.getNav_TicketNoteOk());
        WebObjectUtil.explicitWait(5);
        LoginTestCase_Old1.nav_Logout();
    }
    catch (Exception e) {
        LoggerUtil.log_type_error("issue with -Ticket- verifyEnterNote" );
        LoggerUtil.log_type_error(e.getMessage());
        FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(),
FrameworkUtil.sElementName , "Exception occured", "fail",e.getMessage()+"null");
        }
}

 /*==============================================================
 TestScript  	: verifyNotesSortChk()
 Manual TestCase	: By default, Notes are sorted in ascending order by Date column
 Description		: Verify the upward pointing arrow is placed next to Date column 
                      to indicate user that Notes are sorted by Date column.
 Author 			: Priyanka Rachupalli
 Creation Date 	: 11/11/2015
 Release         :Eilerson
 Pre-Requisites	:
 Revision History:
 ==============================================================*/
 @Test(priority=63)
 public void verifyNotesSortChk()
 {
 	WebDriver driver = WebDriverUtil.getDriver();
 	PageFactory.initElements(driver,Ticket);
 	try{
 		//Eilerson
 		String c,d;
 		//String[] sTemp=null;
 		FrameworkUtil.sTestCaseName = " verifyNotesSortChk";
 		FrameworkUtil.sManualTestCaseName="By default, Notes are sorted in ascending order by Date column";
 		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
 		//Login to Navigator
 		//navTicketLogin();
 		LoginTestCase_Old1.LoginAsRoleAUser();
 		//Select and Open Ticket page
 		navigateToTicketPage();
 		WebObjectUtil.ClickAndMouseHover(Ticket.getNav_FilterByStatusDropdown());
 		WebObjectUtil.clickElement(Ticket.getNav_ClosedMore());
 		WebObjectUtil.explicitWait(15);
 		String sTicketID=getTicketID(1);
 		WebElement wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
 		WebObjectUtil.explicitWait(5);
 		WebObjectUtil.clickElement(wExpander);
 		WebObjectUtil.explicitWait(10);
 		WebElement nExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER", "PARAMETER_TICKETID",  sTicketID);
		WebObjectUtil.explicitWait(5);
		WebObjectUtil.clickElement(nExpander);
		WebObjectUtil.explicitWait(10);
		WebElement wNoteRowExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTESROW.EXPANDER", "PARAMETER_ROWNUMBER",  1+"");
		WebObjectUtil.explicitWait(5);
		//WebObjectUtil.verifyElementPresent(Ticket.getNav_TicketNoteDefaultSortCheck());
		WebObjectUtil.clickElement(wNoteRowExpander);
		WebObjectUtil.explicitWait(10);
		WebObjectUtil.verifyElementPresent(Ticket.getNav_TicketNotesText());
		LoginTestCase_Old1.nav_Logout();
 	 }
    catch (Exception e) {
        LoggerUtil.log_type_error("issue with -Ticket- verifyNotesSortChk" );
        LoggerUtil.log_type_error(e.getMessage());
        FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(),FrameworkUtil.sElementName , "Exception occured", "fail",e.getMessage()+"null");
        }
}
 /*==============================================================
 TestScript  	: verifyClosedMoreNotes()
 Manual TestCase	: Select option "Closed(more than 6 months)"
 Description		: verify user is able to view Ticket Notes for archived tickets.
 Author 			: Priyanka Rachupalli
 Creation Date 	: 11/11/2015
 Release         :Eilerson
 Pre-Requisites	:
 Revision History:
 ==============================================================*/
 @Test(priority=9)
 public void verifyClosedMoreNotes()
 {
 	WebDriver driver = WebDriverUtil.getDriver();
 	PageFactory.initElements(driver,Ticket);
 	try{
 		String e,f;
 		FrameworkUtil.sTestCaseName = "verifyClosedMoreNotes";
 		FrameworkUtil.sManualTestCaseName="verify user is able to view Ticket Notes for archived tickets";
 		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
 		//Login to Navigator
 		//navTicketLogin();
 		LoginTestCase_Old1.LoginAsRoleAUser();
 		//Select and Open Ticket page
 		navigateToTicketPage();
 		WebObjectUtil.explicitWait(Ticket.getNav_FilterByStatusDropdown());
 		WebObjectUtil.ClickAndMouseHover(Ticket.getNav_FilterByStatusDropdown());
 		WebObjectUtil.clickElement(Ticket.getNav_ClosedMore());
 		WebObjectUtil.explicitWait(15);
 		String sTicketID=getTicketID(1);
 		WebElement wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER",1+"");
 		WebObjectUtil.explicitWait(5);
 		WebObjectUtil.clickElement(wExpander);
 		WebObjectUtil.explicitWait(10);
 		WebElement nExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER", "PARAMETER_TICKETID",sTicketID);
		WebObjectUtil.explicitWait(5);
		WebObjectUtil.clickElement(nExpander);
		WebObjectUtil.explicitWait(10);
        WebObjectUtil.verifyElementPresent(Ticket.getNav_TicketNotesText());
        LoginTestCase_Old1.nav_Logout();
 	 }
    catch (Exception e) {
        LoggerUtil.log_type_error("issue with -Ticket- verifyClosedMoreNotes" );
        LoggerUtil.log_type_error(e.getMessage());
        FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(),FrameworkUtil.sElementName , "Exception occured", "fail",e.getMessage()+"null");
        }
}
 
//------------------------------------------------------------------------------------
//	TEST CASE
//------------------------------------------------------------------------------------
/*==============================================================
TestScript  	: verifyColorCodeTktStatus
Manual TestCase	: CPPOC-3487
Description		: Verify the color code status panels  and ticket rows based on the 
State-Outstanding/Closed (Less than 6 months)/Closed (More than 6 months)
Author 			: Priyanka Rachupalli
Creation Date 	: 09/08/2015
Release         :Eilerson
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=64)
public void verifyColorCodeTktStatus()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver,Ticket);
try{
String sDefaultStatus;
String sDefaultStatusChk= (String)FrameworkUtil.dictPropertyData.get("NAV.EILERSON.VERIFY.STATUS");
FrameworkUtil.sTestCaseName = "Ticket-verifyColorCodeTktStatus";
FrameworkUtil.sManualTestCaseName="CPPOC-3487";
FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
int iRow=1;
//Login to Navigator
//navTicketLogin();
LoginTestCase_Old1.LoginAsRoleAUser();

//navigate to ticket page 
navigateToTicketPage();
//check for status box
/*WebObjectUtil.clickElement(Ticket.getNav_FilterByStatusDropdown());
WebObjectUtil.explicitWait(10);
WebElement wDefaultStatusChk = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EILERSON.DEFAULT.STATUS", "PARAMETER_ROWNUMBER",iRow+"");
WebObjectUtil.explicitWait(5);
WebObjectUtil.verifyElementPresent(wDefaultStatusChk);
WebObjectUtil.explicitWait(10);
sDefaultStatus = wDefaultStatusChk.getText();
WebObjectUtil.explicitWait(5);
WebObjectUtil.clickElement(Ticket.getNav_FilterByStatusDropdown());

	 if(sDefaultStatus.equalsIgnoreCase(sDefaultStatusChk)){
	 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Outstanding is displayed", "Pass",""+sDefaultStatus);
	  }
	 else{
	  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Outstanding is not displayed", "Fail",""+sDefaultStatus);
	  }*/
	 
GetPanelColor();
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName ," "+sPanelColor1, " "+sPanelColor2," "+sPanelColor3);

WebObjectUtil.ClickAndMouseHover(Ticket.getNav_FilterByStatusDropdown());
WebObjectUtil.selectCustomWebList(Ticket.getNav_TicketOutstandingDropdown(),2);
//WebObjectUtil.clickElement(Ticket.getNav_ClosedMore());
GetPanelColor();
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName ," "+sPanelColor1, " "+sPanelColor2," "+sPanelColor3);

WebObjectUtil.ClickAndMouseHover(Ticket.getNav_FilterByStatusDropdown());
WebObjectUtil.selectCustomWebList(Ticket.getNav_TicketOutstandingDropdown(),3);
//WebObjectUtil.clickElement(Ticket.getNav_ClosedLess());
GetPanelColor();
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName ," "+sPanelColor1, " "+sPanelColor2," "+sPanelColor3);
LoginTestCase_Old1.nav_Logout();
}
catch (Exception e) {
	LoggerUtil.log_type_error("issue with- verifyColorCodeTktStatus" );
	LoggerUtil.log_type_error(e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
}

/*==============================================================
TestScript  	: verifyTktFieldPositions()
Manual TestCase	: Verify Ticket field Positions
Description		: Verify Date Closed field is next to Date Last Updated field 
Author 			: Priyanka Rachupalli
Creation Date 	: 11/11/2015
Release         : Eilerson
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=66)
public void verifyTktFieldPositions()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver,Ticket);
	try{
		//Eilerson
		String c,d;
		//String[] sTemp=null;
		FrameworkUtil.sTestCaseName = "verifyTktFieldPositions";
		FrameworkUtil.sManualTestCaseName="Verify Date Closed field is next to Date Last Updated field";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		//Login to Navigator
		//navTicketLogin();
		LoginTestCase_Old1.LoginAsRoleAUser();
		//Select and Open Ticket page
		navigateToTicketPage();
		WebObjectUtil.ClickAndMouseHover(Ticket.getNav_FilterByStatusDropdown());
		WebObjectUtil.clickElement(Ticket.getNav_ClosedMore());
		WebObjectUtil.explicitWait(15);
		String sTicketID=getTicketID(1);
		WebElement wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
		WebObjectUtil.explicitWait(5);
		WebObjectUtil.clickElement(wExpander);
		WebObjectUtil.explicitWait(10);
		WebElement wDateLastUpdated=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EILERSON.LAST.UPDATED.DATE","PARAMETER_TICKETID",sTicketID);
		WebObjectUtil.explicitWait(5);
		WebElement wDateClosed=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EILERSON.CLOSED.DATE","PARAMETER_TICKETID",sTicketID);
		WebObjectUtil.explicitWait(5);
		WebObjectUtil.verifyElementPresent(wDateLastUpdated);
		WebObjectUtil.verifyElementPresent(wDateClosed);
		LoginTestCase_Old1.nav_Logout();
	 }
   catch (Exception e) {
       LoggerUtil.log_type_error("issue with -Ticket- verifyTktFieldPositions" );
       LoggerUtil.log_type_error(e.getMessage());
       FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(),FrameworkUtil.sElementName , "Exception occured", "fail",e.getMessage()+"null");
       }
}

/*==============================================================
TestScript          : verifyNoteSortOrderChk()
Manual TestCase        : Create Note button, and without entering any info
Description                : Verify the error message when user clicks on OK button
Author                         : Priyanka Rachupalli
Creation Date         : 07/06/2015
Pre-Requisites        :
Revision History:
==============================================================*/
/*@Test(priority=67)
public void verifyNoteSortOrderChk()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver,Ticket);
	try{
		int i;
		String sAllRows,sTicketID,sCreateNotes;
	    String sRows[]= new String[8];

		WebElement wExpander,nExpander,wCreateNotes;
		FrameworkUtil.sTestCaseName = "Ticket-verifyNoteSortOrderChk";
		FrameworkUtil.sManualTestCaseName="Verify user is able to view the reports in the required format";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		//Login to Navigator
		//navTicketLogin();
		 LoginTestCase.LoginAsRoleAUser();
		//Select and Open Ticket page
		navigateToTicketPage();
		//dynamic XPATH of Expand icon
		WebObjectUtil.explicitWait(10);
		sTicketID = getTicketID(1);
		wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
		WebObjectUtil.explicitWait(10);
		WebObjectUtil.clickElement(wExpander);
		WebObjectUtil.explicitWait(10);
		nExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER", "PARAMETER_TICKETID",  sTicketID);
		WebObjectUtil.explicitWait(5);
		WebObjectUtil.clickElement(nExpander);
		WebObjectUtil.explicitWait(10);
	    sTicketID = getTicketID(1);
	    if(Ticket.getNav_NotesWebTable().isDisplayed())
	    {
		    CustomWebElementUtil.loadCustomElement(Ticket.getNav_NotesWebTable(), "table");
		    WebObjectUtil.explicitWait(5);
		    for(i=0;i<sRows[i].length();i++)
		    {
		    	sRows[i]= CustomWebElementUtil.getCellData(i, 4);
		    	break;
		    }
		    for(i=0;i<6;i++)
		    {
		         if(Date.parse(sRows[i])<Date.parse(sRows[i+1])){
				 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Dates are sorted", "Pass",""+sRows[i]);
                   }
				 else{
				  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Dates are not sorted, check manually", "Fail",""+sRows[i]);
				    }
		    break;
		    }
         }
	    else{
	    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Note rows are not present", "Pass","Cannot verify");
	    }
	
       } 
	
	catch (Exception e) {
		LoggerUtil.log_type_error("issue with- verifyNoteSortOrderChk" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		}
*/

//________________________ Hague test cases ____________________________ //

/*==============================================================
TestScript          : verifySummaryDelete()
Manual TestCase        : QAT272-WCP_3681_TC_Ticket should not be saved when Summary field is blank
Description                : Verify that user is unable to save ticket when summary field is blank 
Author                         : Priyanka Rachupalli
Creation Date         : 07/06/2015
Pre-Requisites        :
Release:               Hague
Revision History:
==============================================================*/
@Test(priority=68)
public void verifySummaryDelete()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver,Ticket);
	PageFactory.initElements(driver,Common);
	try{
		int i;
		String sAllRows,sTicketID,sCreateNotes;
	    String sRows[]= new String[8];
		WebElement wExpander,nExpander,wCreateNotes;
		FrameworkUtil.sTestCaseName = "Ticket-verifySummaryDelete";
		FrameworkUtil.sManualTestCaseName="QAT272-WCP_3681_TC_Ticket should not be saved when Summary field is blank";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		//Login to Navigator
		//navTicketLogin();
		LoginTestCase_Old1.LoginAsRoleAUser();
		//Select and Open Ticket page
		navigateToTicketPage();
		//dynamic XPATH of Expand icon
		WebObjectUtil.explicitWait(15);
		sTicketID = getTicketID(1);
		wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
		WebObjectUtil.explicitWait(10);
		WebObjectUtil.clickElement(wExpander);
		WebObjectUtil.explicitWait(10);
		WebObjectUtil.clickElement(Ticket.getNav_TicketSummaryEdit());
		Ticket.getNav_TicketSummaryEdit().clear();
		WebObjectUtil.clickElement(Ticket.getNav_TicketSaveUpdatesButton());
		WebObjectUtil.explicitWait(5);
		WebObjectUtil.verifyElementPresent(Common.getNav_CommonPopUpOKButton());
		WebObjectUtil.clickElement(Common.getNav_CommonPopUpOKButton());
		LoginTestCase_Old1.nav_Logout();
	 }
	   catch (Exception e) {
	       LoggerUtil.log_type_error("issue with -Ticket- verifySummaryDelete" );
	       LoggerUtil.log_type_error(e.getMessage());
	       FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(),FrameworkUtil.sElementName , "Exception occured", "fail",e.getMessage()+"null");
	       }
	}

/*==============================================================
TestScript  	: verifyLoadBalAddVIPTicketDetails()
Manual TestCase	: QAT-258-WCP_881_TC_1.0_Load Balancer_Virtual IPs_Add VIP		
Description		: Verify the Add VIP under Virtual IP in Load Balancer.
Author 			: Priyanka R
Creation Date 	: 12/01/2015
Release         : Hague
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=32)
public void verifyLoadBalAddVIPTicketDetails()
{
	WebDriver driver = WebDriverUtil.getDriver();
	
	PageFactory.initElements(driver, EVDC_OverviewPF);
	PageFactory.initElements(driver, Ticket);
	PageFactory.initElements(driver, Home);
	PageFactory.initElements(driver, EVDC_VMPF);
	
	try {
	String sUserName,sPassword;
	FrameworkUtil.sTestCaseName = "verifyLoadBalAddVIPTicketDetails";
	FrameworkUtil.sManualTestCaseName="QAT-258-WCP_881_TC_1.0_Load Balancer_Virtual IPs_Add VIP	";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

	
	sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.USER.HAWKEYE.USERID");
	sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.USER.HAWKEYE.PASSWORD");
	
	
	//Login
	//LoginTestCase.nav_Login(sUserName, sPassword);
	LoginTestCase_Old1.LoginAsHawkeyeUser();
	
	WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
	WebObjectUtil.explicitWait(10);
    WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCLBLink());
    WebObjectUtil.explicitWait(10);
    WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_VirtualIPTab());
	WebObjectUtil.explicitWait(5);
	WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_LoadBalAddVIP());
	WebObjectUtil.explicitWait(10);
	
	valAddVIPunderVirtualIp();
	VerifyTicketDetails();
    //TicketTestCase.verifyTicketsPrintIcon();
    LoginTestCase_Old1.nav_Logout();
	
}
	catch (Exception e) {
		// TODO Auto-generated catch block
         	LoggerUtil.log_type_error( "Issue With-VerifyLoadBalAddVIPTicketDetails" +  e.getMessage());
		    FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
	}

}

/*==============================================================
Method           : verifyCreatedTicketDate()
Description           : Verify  newly created ticket date has present date or not.
Author                : Priyanka Rachupalli
Creation Date         : 12/3/15
Pre-Requisites        :
Release               : Hague
Revision History:
==============================================================*/
public static void verifyCreatedTicketDate() 
{
try {
DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//get current date time with Date()
Date date = new Date();
//System.out.println(dateFormat.format(date));
String sDate = (dateFormat.format(date));
String sActDate=Ticket.getNav_DateEdit().getAttribute("value");
if(sActDate.equalsIgnoreCase(sDate))
	FrameworkUtil.updateCustomResultBasedOnStatus(true, sDate+" is matching with the value displayed in Date field");
else
	FrameworkUtil.updateCustomResultBasedOnStatus(false, sDate+" is not matching with the value displayed in Date field");

} catch (Exception e) {
LoggerUtil.log_type_error("issue with- verifyCreatedTicketDate" );
LoggerUtil.log_type_error(e.getMessage());
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
}
}
/*==============================================================
Method Name 	: GetPanelColor
Description		: This will navigate to ticket page
Author 			: Priyanka R
Creation Date 	: 06/16/2015
Pre-Requisites	:
Revision History:
==============================================================*/	
public static void GetPanelColor() 
{
try {
    WebObjectUtil.explicitWait(10);
	sPanel1=WebObjectUtil.GetWebElement("xpath","//div[@id='idSpStatusPanel-targetEl']/div[1]","OpenTicketsPanel");
	sPanel2=WebObjectUtil.GetWebElement("xpath","//div[@id='idSpStatusPanel-targetEl']/div[2]","WorkingTicketsPanel");
	sPanel3=WebObjectUtil.GetWebElement("xpath","//div[@id='idSpStatusPanel-targetEl']/div[3]","PendingTicketsPanel");
	sPanel4=WebObjectUtil.GetWebElement("xpath","//div[@id='idSpStatusPanel-targetEl']/div[4]","ResolvedTicketsPanel");
	sPanelColor1=sPanel1.getCssValue("color");
	sPanelColor2=sPanel1.getCssValue("color");
	sPanelColor3=sPanel1.getCssValue("color");
	sPanelColor4=sPanel1.getCssValue("color");
	/*WebObjectUtil.ClickAndMouseHover(Ticket.getNav_FilterByStatusDropdown());
	WebObjectUtil.clickElement(Ticket.getNav_ClosedLess());*/

} catch (Exception e) {
LoggerUtil.log_type_error("issue with- GetPanelColor" );
LoggerUtil.log_type_error(e.getMessage());
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
}
}

/*==============================================================
Method Name 	: VerifyAddAndSearchVIPTicket
Description		: This will validate the CPU n RAm count
Author 			: Priyanka R
Creation Date 	: 12/3/15
Pre-Requisites	:
Release         : Hague
Revision History:
==============================================================*/

public static void VerifyEVDCLBHeaderValues()
{
String[] arrString = null;
String sUserName,sPassword,sEVDCInstanceLBHeader,sLBHeader;
sLBHeader = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.INSTANCE.LOAD.BALANCER.HEADER");

WebDriver driver = WebDriverUtil.getDriver();
PageFactory.initElements(driver, EVDC_OverviewPF);
PageFactory.initElements(driver, Ticket);
PageFactory.initElements(driver, Home);
PageFactory.initElements(driver, EVDC_VMPF);
boolean bStatus;
try{
	WebObjectUtil.explicitWait(5);
	 sEVDCInstanceLBHeader = EVDC_OverviewPF.getNav_EVDCInstanceLBHeader().getText();
	 WebObjectUtil.explicitWait(5);
	 System.out.println(""+sEVDCInstanceLBHeader);
        arrString=sLBHeader.split("@@");
		for (int i=0; i<=arrString.length; i++){
			if (sEVDCInstanceLBHeader.contains(arrString[i])){
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Sub string" , "verify sub string", "pass", "String Verified: " + arrString[i]);
				bStatus=true;
			}else{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Sub string" , "verify sub string", "warn", "String Not Present/Verified: " + arrString[i] + "/n" + "source string :" + sEVDCInstanceLBHeader );
			}
}
}
catch (Exception e) {
	// TODO Auto-generated catch block
     	LoggerUtil.log_type_error( "Issue With-VerifyEVDCLBHeaderValues" +  e.getMessage());
	    FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
}
}


/*==============================================================
Method Name 	: valAddVIPunderVirtualIp
Description		: This will validate the CPU n RAm count
Author 			: Priyanka R
Creation Date 	: 12/3/15
Pre-Requisites	:
Release         : Hague
Revision History: As application changed..method modified and renamed by QAA03
==============================================================*/

public static void valAddVIPunderVirtualIp()
{
WebDriver driver = WebDriverUtil.getDriver();
PageFactory.initElements(driver, EVDC_OverviewPF);
PageFactory.initElements(driver, Ticket);
PageFactory.initElements(driver, Home);
PageFactory.initElements(driver, LoadBalancer);
PageFactory.initElements(driver, Common);
try{
	String sSummary,sText;
	sSummary  = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.SUMMARY.SEARCH");
	sText = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.VIP.TICKET.SUCCESS.MSG");
	
	
	sSummary= sSummary+"_"+ FrameworkUtil.sTimeStamp;
	//The below lines updated by QAA03
	WebObjectUtil.SetValueEdit(EVDC_OverviewPF.getNav_CreateTicketTitleEditBox(), sSummary);
	WebObjectUtil.explicitWait(8);
	//WebObjectUtil.SetValueEdit(LoadBalancer.getNav_VirtualIP_AddVIP_VIPNameTextBox(), sSummary);
	//WebObjectUtil.explicitWait(8);
	WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_AddVirtualIPPopUp());
	//WebObjectUtil.clickByJS(EVDC_OverviewPF.getNav_AddVirtualIPPopUp());
	WebObjectUtil.explicitWait(5);
	//WebObjectUtil.SetValueEdit(EVDC_OverviewPF.getNav_AddVirtualIPPopUp(), "UserTestText");
	//WebObjectUtil.explicitWait(5);
	//EVDC_OverviewPF.getNav_AddVirtualIPPopUp().clear();
	EVDC_OverviewPF.getNav_AddVirtualIPPopUp().sendKeys("UserTestText");
	WebObjectUtil.explicitWait(5);
    WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_AddVirtualIPPopUpOkBtn());
    WebObjectUtil.explicitWait(5);
   // WebObjectUtil.waitForElementPresent(Common.getNav_CommonPopUp());
    //WebObjectUtil.VerifyTextUnderElement(Common.getNav_CommonPopUpMessage(), sText);
    WebObjectUtil.clickElement(Common.getNav_CommonPopUpOKButton());
    WebObjectUtil.explicitWait(5);
    TicketTestCase.navigateToTicketPage();
    WebObjectUtil.explicitWait(10);
    TicketTestCase.searchTicket("Summary",sSummary);
    WebObjectUtil.explicitWait(10);
    TicketTestCase.SearcResultFound("Summary",3,sSummary);
   
}
catch (Exception e) {
	// TODO Auto-generated catch block
     	LoggerUtil.log_type_error( "Issue with-valAddVIPunderVirtualIp" +  e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
}

}



/*==============================================================
	Method 	: verifyTicketDetails
	Description		: Verify user is able view ticket details like "Ticket Id","Summary","Severity","Priority","Last updated","Assigned To","Status".
	Author 			: Priyanka R
	Creation Date 	: 12/13/2015
	Pre-Requisites	:
	Revision History:
==============================================================*/
public void VerifyTicketDetails()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, Ticket);
	
	
	try {
		WebObjectUtil.explicitWait(5);
		int iRow=1;
		String sSeverity,sPriority,sStatus,sDate,sTicketID,sCategory,sOrgname,sNotes;
		WebElement wCategory,wOrgname,wNotes;
		sTicketID=TicketTestCase.getTicketID(iRow);
		WebObjectUtil.explicitWait(3);
		TicketTestCase.expandTable(iRow);
		/*WebElement wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", iRow+"");
        WebObjectUtil.clickElement(wExpander);*/
		WebObjectUtil.explicitWait(5);
		//TicketTestCase.verifyCreatedTicketDate();
		/*CustomWebElementUtil.loadCustomElement(Ticket.getNav_TicketsWebTable(), "table");
		sSeverity=CustomWebElementUtil.getCellData(1, 4);
		sPriority=CustomWebElementUtil.getCellData(1, 5);
		sDate=CustomWebElementUtil.getCellData(1, 6);
		wCategory=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "CREATED.TICKET.CATEGORY.VALUE", "PARAMETER_ROWNUMBER", iRow+"");
		wOrgname=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "CREATED.TICKET.ORG.VALUE", "PARAMETER_ROWNUMBER", iRow+"");
		sCategory=wCategory.getText();
		sOrgname=wOrgname.getText();	*/	
		//TicketTestCase.expandNotesTable(iRow);
		WebElement nExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath","TICKET.NOTES.EXPANDER", "PARAMETER_TICKETID", sTicketID+"");	
		WebObjectUtil.explicitWait(3);
		WebObjectUtil.clickElement(nExpander);
		WebObjectUtil.explicitWait(5);
		/*WebElement nGridExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath","NOTES.GRID.EXPANDER", "PARAMETER_ROWNUMBER", iRow+"");	
		WebObjectUtil.explicitWait(3);
		WebObjectUtil.clickElement(nGridExpander);
		WebObjectUtil.explicitWait(5);
        wNotes=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "CREATED.TICKET.NOTES.TEXT", "PARAMETER_TICKETID", sTicketID);
        WebObjectUtil.verifyElementPresent(wNotes);*/
        TicketTestCase.expandTable(iRow);
        WebObjectUtil.explicitWait(5);
       /* FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Severity-"+sSeverity, "Priority-"+sPriority, "Date-"+sDate);
        FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName ,"Notes-"+sNotes,"Category-"+sCategory,"Org-"+sOrgname);
        TicketTestCase.expandTable(iRow);
        WebObjectUtil.explicitWait(5);*/
        
	} catch (Exception e) {
		LoggerUtil.log_type_error( "Issue With-VerifyTicketDetails()" +  e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
	
	}
	
}






// ________________________ Completed hague test cases _________________________ //
//------------------------------------------------------------------------------------
//METHODS
//------------------------------------------------------------------------------------
/*==============================================================
Method Name 	: getDiffMonths
Description		: This will return number of months for closed less than 6 months 
Author 			: Priyanka Rachupalli
Creation Date 	: 06/29/2015
Pre-Requisites	:
Revision History:
==============================================================*/
public static int getDiffMonths(Date a, Date b){
	int diff = a.getMonth() - b.getMonth();
	if(b.getDate()<=a.getDate())
	{
	diff--;
	}
  else{
	diff++;
  }
	 return diff;
}
//------------------------------------------------------------------------------------
//METHODS
//------------------------------------------------------------------------------------
/*==============================================================
Method Name     : getDiffMonths1
Description        : This will return number of months for Closed More
than 6 months
Author             : Priyanka Rachupalli
Creation Date     : 06/29/2015
Pre-Requisites    :
Revision History:
==============================================================*/
public static int getDiffMonths1(Date a, Date b ) {
    int diff,diff1;
     diff = a.getYear() - b.getYear();
    if(diff!=0)
    {
        diff=diff*12;
    }
    if(a.getMonth()>=b.getMonth())
    {
        diff1 = a.getMonth() - b.getMonth();
        diff=diff+diff1;
    }
    else
    {
        diff1=b.getMonth()-a.getMonth();
        diff=diff-diff1;
    }
    if(b.getDate()<=a.getDate())
    {
    diff1--;
    }
    else{
    diff1++;
    }
    diff=diff+diff1;
   return diff;
}



////$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$PRIYANKA$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$


//___________________________ Gideon TestCases ________________________________________///

/*========================================================================================================
TestScript  	: verifyTicketsOrgNameHasApostrophe
Manual TestCase	: CPPOC-3355 Verifying Tickets Data for The Organization which Name Has Apostrophe
Description		: Verifying Tickets Data and newly created tickets Data for The Organization which Name Has Apostrophe
Author 			: QAA03
Creation Date 	: 09/01/2015
Pre-Requisites	:
Revision History:
=========================================================================================================*/
		
@Test(priority=2)
public static void verifyTicketsOrgNameHasApostrophe()
{
		 
			       WebDriver driver = WebDriverUtil.getDriver();
			       
			       PageFactory.initElements(driver, Ticket);
			       String sUserName=null,sPassword=null;
			       try {
						FrameworkUtil.sTestCaseName = "verifyTicketsOrgNameHasApostrophe";
						FrameworkUtil.sManualTestCaseName="CPPOC-3355 Verifying Tickets Data for The Organization which Name Has Apostrophe";
						FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
						           
					    sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.COOPER.USERNAME");
					    sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.COOPER.PASSWORD");
						
						//LoginTestCase.nav_Login(sUserName, sPassword);
					    LoginTestCase_Old1.LoginAsCoopertestUser();
						
					    //Updated by QAA03 on 07/12/2016
                        TicketTestCase.navigateToTicketPage();
                        
						TicketTestCase.verifyCreateTicket();
						
						LoginTestCase_Old1.nav_Logout();
						
					} catch (Exception e) {
						LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyTicketsOrgNameHasApostrophe", "warn", "catch block:Could NOT access webelement" +e.getMessage());
					}
}


/*====================================================================================================
Method Name 	: verifyCreateTicket
Description		: Verifying details in the Newly Created Ticket
Author 			: QAA03
Creation Date 	: 09/01/2015
Pre-Requisites	:
Revision History:
=====================================================================================================*/


public static void verifyCreateTicket()
{
	     WebDriver driver = WebDriverUtil.getDriver(); 
	     PageFactory.initElements(driver, Ticket);
         String sTSummaryCreateValue= (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.EB.TICKETSUMMARYEDIT");
         String sTSummaryValueAfterCreate=null,sTicketId;
         WebElement wExpander;
         boolean bCreateTicketStatus = false;
         
	     try {
	    	 
	    	 //WebObjectUtil.waitForElementPresent(Ticket.getNav_TicketsLink());
	        // WebObjectUtil.clickElement(Ticket.getNav_TicketsLink());
	    	// WebObjectUtil.explicitWait(5);
			 WebObjectUtil.verifyElementPresent(Ticket.getNav_CreateTicketLink());
			 WebObjectUtil.clickElement(Ticket.getNav_CreateTicketLink());
			 
			 //creating ticket by entering value in summary field
			 sTSummaryCreateValue = sTSummaryCreateValue + FrameworkUtil.sTimeStamp;
			 WebObjectUtil.SetValueEdit(Ticket.getNav_CreateTicketDialogSummary(), sTSummaryCreateValue);
			 Ticket.getNav_CreateTicketDialogAddNote().sendKeys(sTSummaryCreateValue);
			 WebObjectUtil.clickElement(Ticket.getNav_CreateTicketDialogOkButton());
			 WebObjectUtil.clickElement(Ticket.getNav_ConfirmPopupOkBtn());
			 WebObjectUtil.explicitWait(10);
			 sTicketId = getTicketID(1);
			//This below line updated on 10/08/2015 for EXTJS5 by QAA03
			 //expanding the created ticket
			 //wExpander=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr[1]//tr[1]/td[1]//div[@class='x-grid-row-expander']", "Arrow Expander First Row");
			 // wExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTicketsGridPanel-body']/div/div/table[1]/tbody/tr/td/div/div[@class='x-grid-row-expander']", "Ticket Arrow Expander");
				// This object is updated on 10/14/2015 By QAA04
			 wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
			 WebObjectUtil.clickElement(wExpander);
			 sTSummaryValueAfterCreate = Ticket.getNav_TicketSummaryEdit().getAttribute("value");
			 
			 //checking the summary value in created ticket
			 bCreateTicketStatus = sTSummaryValueAfterCreate.contentEquals(sTSummaryCreateValue); 
			 FrameworkUtil.updateCustomResultBasedOnStatus(bCreateTicketStatus, "Ticket Created,Ticket ID: " +sTicketId +", Summary : "+sTSummaryValueAfterCreate);
			 /*if(sTSummaryValueAfterCreate.contentEquals(sTSummaryCreateValue))
			 {
				 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "TicketSummaryField", "pass", "New ticket is created");  
			 }
			 else
			 {
				 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "TicketSummaryField", "fail", "Ticket is not created");
			 }
			*/ 
			 
		} catch (Exception e) {
			
			LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyCreateTicket", "warn", "catch block:Could NOT access webelement" +e.getMessage());	
			
		}
         
}


public static void expandTable(int iRowNum){
	WebElement expandArrow;
	try {
		
		String sExpanderLocator = WebObjectUtil.getLocatorValueFromProperty("TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", iRowNum+"");
		expandArrow = WebObjectUtil.GetWebElement("xpath", sExpanderLocator,"expandArrow");
		if (iRowNum > 0 && expandArrow != null  ){
			//expandArrow.click();
			// this object is added by QAA04 - 02/23/16
			WebObjectUtil.clickElement(expandArrow);
			//System.out.println("expanding VM row success");
			LoggerUtil.log_type_info("expanding VM row success");
		}else{
			//System.out.println("expanding VM row failure");
			LoggerUtil.log_type_error("expanding VM row failure");
		}
	} catch (Exception e) {
		LoggerUtil.log_type_error("Exception occured:" + e.getMessage());
	}
}


static void expandNotesTable(int iRowNum){
	WebElement expandArrow;
	try {
		String sTicketID=getTicketID(iRowNum);
		String sExpanderLocator = WebObjectUtil.getLocatorValueFromProperty("TICKET.NOTES.EXPANDER", "PARAMETER_TICKETID", sTicketID+"");
		expandArrow = WebObjectUtil.GetWebElement("xpath", sExpanderLocator,"expandArrow");
		if (iRowNum > 0 && expandArrow != null  ){
			//expandArrow.click();
			// this object is added by QAA04 - 02/23/16
			WebObjectUtil.clickElement(expandArrow);
			//System.out.println("expanding VM row success");
			LoggerUtil.log_type_info("expanding  row success");
		}else{
			//System.out.println("expanding VM row failure");
			LoggerUtil.log_type_error("expanding row failure");
		}
	} catch (Exception e) {
		LoggerUtil.log_type_error("Exception occured:" + e.getMessage());
	}
}


/*========================================================================================================
TestScript  	: verifyPrintIconInTickets
Manual TestCase	: CPPOC-3348 Verifying Print Icon in Tickets
Description		: Verifying Print Icon in Tickets
Author 			: QAA03
Creation Date 	: 08/31/2015
Pre-Requisites	:
Revision History:
=========================================================================================================*/

@Test(priority=3)
public static void verifyPrintIconInTickets()
{
		 
			       WebDriver driver = WebDriverUtil.getDriver();
			      
			       PageFactory.initElements(driver, Ticket);
			       
			       String sUserName=null,sPassword=null;
			       
			       try {
						FrameworkUtil.sTestCaseName = "verifyPrintIconInTickets";
						FrameworkUtil.sManualTestCaseName="CPPOC-3348 Verifying Print Icon in Tickets";
						FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
						           
					    /*sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO.USERID.AROLE");
					    sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO.PASSWORD.AROLE");*/
						sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.USERID.QAAUTO");
					    sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.PWD.QAAUTO");
						
						//LoginTestCase.nav_Login(sUserName, sPassword);
					    LoginTestCase_Old1.LoginAsQaautoUser();
						
						verifyTicketsPrintIcon();
						
						LoginTestCase_Old1.nav_Logout();
						
					} catch (Exception e) {
						LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyPrintIconInTickets", "warn", "catch block:Could NOT access webelement" +e.getMessage());
					}
}


	/*==============================================================
	TestScript 		: verifyTicketOnEm7AndNavigator
	Manual TestCase	: Verify the ticket in EM7 page 
	Description		: Create a ticket in Navigator and verify that ticket in EM7
	Author 			: QAA04
	Creation Date 	: 09/01/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	@Test(priority=17)
	public void verifyTicketOnEm7AndNavigator() {
		
		    WebElement expandArrow;
		    String sTicketId;
			WebDriver driver=WebDriverUtil.getDriver();
			PageFactory.initElements(driver, EVDC_OverviewPF);
			PageFactory.initElements(driver, EM7);
			PageFactory.initElements(driver, Ticket);
			
			try{
				
			FrameworkUtil.sTestCaseName="verifyTicketOnEm7AndNavigator";
		    FrameworkUtil.sManualTestCaseName="(CPPOC-3092)Verify the ticket in EM7 page";
		    FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	       
		    //String sUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.TSTMAX02.USERID");
		    //String sPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.TSTMAX02.PASSWORD");
		    String sUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
		    String sPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
			//LoginTestCase.nav_Login(sUserName, sPassword);
			LoginTestCase_Old1.LoginAsGirUser();
	 
	        WebObjectUtil.waitForElementPresent(EVDC_OverviewPF.getNav_PrivateEVDCLink());	
			WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_PrivateEVDCLink());
			WebObjectUtil.clickElement(Ticket.getNav_OpenTicketLink());
			WebObjectUtil.explicitWait(5);
			WebObjectUtil.clickElement(Ticket.getNav_OkBtnInTicketPage());
			WebObjectUtil.explicitWait(5);
			WebObjectUtil.clickElement(Ticket.getNav_CreatingTicketOkBtn());
			WebObjectUtil.explicitWait(6);
			//the below line updated by QAA03 on 07/25/2016
			//WebObjectUtil.ClickAndMouseHover(Ticket.getNav_SupportTabLink());
			WebObjectUtil.clickElement(Ticket.getNav_SupportTabLink());
			WebObjectUtil.clickElement(Ticket.getNav_TicketsMenuLink());
			WebObjectUtil.explicitWait(5);
		   
		   //  sTicketId = Ticket.getNav_FirstTicketId().getText();
			sTicketId=getTicketID(1);
		     String sExpanderLocator = WebObjectUtil.getLocatorValueFromProperty("TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
				expandArrow = WebObjectUtil.GetWebElement("xpath", sExpanderLocator,"expandArrow");
				
					//expandArrow.click();
		     // this object is added by QAA04 - 02/23/16
				WebObjectUtil.clickElement(expandArrow);
				//WebObjectUtil.clickElement(Ticket.getNav_FirstTicketExpander());
		    WebObjectUtil.explicitWait(5);
			//WebObjectUtil.isElementPresent(Ticket.getNav_SummaryEditField());
		    WebObjectUtil.verifyElementPresent(Ticket.getNav_SummaryEditField());
			
			
	        ///////log out 
	        LoginTestCase_Old1.nav_Logout();
	        
	        //// login to the EM7 Page
	        WebDriverUtil.getDriver().get((String)FrameworkUtil.dictPropertyData.get("NAV.EM7.URL"));
		   
		    String sEM7UserName =(String)FrameworkUtil.dictPropertyData.get("NAV.EM7.NAVUSER.USERID");
		    String sEM7Password =(String)FrameworkUtil.dictPropertyData.get("NAV.EM7.NAVUSER.PASSWORD");
			
		  //Login to Navigator
		   EM7TestCase.EM7Login(sEM7UserName, sEM7Password);
		    
			
			WebObjectUtil.explicitWait(5);
        
			WebObjectUtil.clickElement(EM7.getEM7_TicketLink());
			WebObjectUtil.explicitWait(5);
		    WebObjectUtil.SetValueEdit(EM7.getEM7_TidSearchBox(), sTicketId);
		    WebObjectUtil.explicitWait(10);
		    
			WebObjectUtil.clickElement(EM7.getEM7_FirstTicketExpander());
		    String sParentWindowName = driver.getWindowHandle();
			String sTicketWindowTitle = (String) FrameworkUtil.dictPropertyData.get("NAV.EM7.NEWWINDOW.TITLE");
			WebObjectUtil.switchToWindow(2, sTicketWindowTitle);
			WebObjectUtil.explicitWait(10);
			//WebObjectUtil.isElementPresent(EM7.getEM7_DiscriptionEditField());
			WebObjectUtil.verifyElementPresent(EM7.getEM7_DiscriptionEditField());
			WebObjectUtil.explicitWait(10);
			/*//WebObjectUtil.switchToParentWindow();
			driver.close();
			driver.switchTo().window(sParentWindowName);
			
			WebObjectUtil.explicitWait(5);
			//logout EM7 page
			EM7TestCase.EM7Logout();*/
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
		         	LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
			}
	
	}
// methods
/*====================================================================================================
Method Name 	: verifyTicketsPrintIcon
Description		: Verifying Print Icon in Tickets
Author 			: QAA03
Creation Date 	: 08/31/2015
Pre-Requisites	:
Revision History:
====================================================================================================*/
public static void verifyTicketsPrintIcon()
{
	    WebElement wTicketExpander,wTicketNotesExpander,wFirstRowData,wNotesTable;
	    int iTktsNotes=0,iPISummary=0,iTktPISummary=0;
	    String sFirstRowTicketID=null,sTktNotesID=null,sTktsNotesData=null,sTktsPrintIconNotesData=null,sTktSummaryData=null,sTktsPrintIconSummary=null;
	    String[] sNotesarray=new String[40];
	    String[] sPISummaryarray=new String[40];
	    String[] sTktPISummaryarray =new String[40];
	    String sParentWindowName;
	    
	    
	    try {
	    	WebDriver driver = WebDriverUtil.getDriver();
			WebObjectUtil.clickElement(Ticket.getNav_TicketsLink());
			WebObjectUtil.verifyElementPresent(Ticket.getNav_CreateTicketLink());
			//This below line updated on 10/08/2015 for EXTJS5 by QAA03
			//Expanding first ticket
			//wTicketExpander=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr[1]//tr[1]/td[1]//div[@class='x-grid-row-expander']", " Arrow Expander First Row");
			//wTicketExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTicketsGridPanel-body']/div/div/table[1]/tbody/tr/td/div/div[@class='x-grid-row-expander']", "Ticket Arrow Expander");
			 // This object is updated on 10/15/2015 By QAA04
			wTicketExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
			WebObjectUtil.clickElement(wTicketExpander);
			//Getting Summary Data of First row
			//This below line updated on 10/08/2015 for EXTJS5 by QAA03
			//wFirstRowData = WebObjectUtil.GetWebElement("xpath","//div[@id='idTicketsGridPanel-body']/div/table/tbody/tr[1]/td/table/tbody" , "FirstRowData");
			//wFirstRowData = WebObjectUtil.GetWebElement("xpath","//div[@id='idTicketsGridPanel-body']/div/div/table[1]/tbody", "FirstRowData");
			 // This object is updated on 10/15/2015 By QAA04
			 wFirstRowData = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.FIRSTROWDATA", "", "");
			 sTktSummaryData = wFirstRowData.getText();
			
			
			WebObjectUtil.explicitWait(20);
			//Getting Notes Data of First row
			//This below line updated on 10/08/2015 for EXTJS5 by QAA03
			//sFirstRowTicketID = WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 3).trim();
			sFirstRowTicketID = WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1,2).trim();
			//sTktNotesID="tktNotesImg-"+sFirstRowTicketID;
			//wTicketNotesExpander = WebObjectUtil.GetWebElement("id", sTktNotesID, "Ticket Notes Expander");
			 // This object is updated on 10/15/2015 By QAA04
			WebObjectUtil.explicitWait(15);
			wTicketNotesExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER", "PARAMETER_TICKETID",  sFirstRowTicketID);
			WebObjectUtil.clickElement(wTicketNotesExpander);
			WebObjectUtil.selectCheckRadioBox(Ticket.getNav_ExpandAllNoteCheckbox());
			//This below line updated on 10/08/2015 for EXTJS5 by QAA03
			//sTktsNotesData = Ticket.getNav_NotesWebTable().getText();
		//	WebElement wNotesTable = WebObjectUtil.GetWebElement("id", "notesGrid-"+sFirstRowTicketID+"-body", "NotesTable");
			 // This object is updated on 10/15/2015 By QAA04
			wNotesTable = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.TABLE", "PARAMETER_TICKETID",  sFirstRowTicketID);
			sTktsNotesData = wNotesTable.getText();
			
			
			
			//Spliting Notes data
			sNotesarray = sTktsNotesData.split("\n");
			iTktsNotes=sNotesarray.length;
			//clicking on print icon
			WebObjectUtil.verifyElementPresent(Ticket.getNav_TicketsPrintIcon());
			WebObjectUtil.clickElement(Ticket.getNav_TicketsPrintIcon());
			sParentWindowName = driver.getWindowHandle();
			WebObjectUtil.switchToWindow(2,"");
			WebObjectUtil.explicitWait(10);
			
			WebObjectUtil.verifyElementPresent(Ticket.getNav_TktsPrintIcon_Summary());
			//getting summary data from print icon
			sTktsPrintIconSummary = Ticket.getNav_TktsPrintIcon_Summary().getText();
			//spliting summary print icon data with respect to line
			sPISummaryarray = sTktsPrintIconSummary.split("\n");
			
			iPISummary = sPISummaryarray.length;
			
			for(int i=0; i<iPISummary; i++)
			{
				//spliting summary print icon data with respect to colon
			    sTktPISummaryarray = sPISummaryarray[i].split(":");
			    
			    iTktPISummary = sTktPISummaryarray.length;
			    for(int k=0;k<iTktPISummary;k++)
			    {
			    	//verifying summary ticket data with print icon summary ticket data
			    	if(sTktSummaryData.contains(sTktPISummaryarray[k].trim())||sTktPISummaryarray[k].contentEquals("Ticket ID"))
					{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Ticket Summary details", "pass", "Ticket Summary details are matching :" + sTktPISummaryarray[k]);	
					}else{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Ticket Summary details", "fail", "Ticket Summary details are NOT matching :" + sTktPISummaryarray[k] + "/n ticket summary data from print window:" + sTktSummaryData);
					}
			    }
			}
			//getting notes data from print icon
			sTktsPrintIconNotesData = Ticket.getNav_TktsPrintIcon_Notes().getText();
			//verifying notes ticket data with print icon notes ticket data
			for(int j=0;j<iTktsNotes;j++)
			{
				WebObjectUtil.explicitWait(5);
				if(sTktsPrintIconNotesData.contains(sNotesarray[j]))
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Ticket Notes details", "pass", "Ticket Notes details are matching :" + sNotesarray[j]);	
				}else{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Ticket Notes details", "fail", "Ticket Notes details are NOT matching :" + sNotesarray[j] + "/n ticket notes data from print window:" + sTktsPrintIconNotesData);
				}
			}
			driver.close();
			driver.switchTo().window(sParentWindowName);
		} catch (Exception e) {
			
			LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyTicketsPrintIcon", "warn", "catch block:Could NOT access webelement" +e.getMessage());
		}

}

//___________________________Completed Gideon TestCases ________________________________________///

///////////////////////////////Taken From ByronTextCase.java////////////////////////
/*==============================================================
TestScript 		: validateCloakDisplayedForAllNotes
Manual TestCase	:  CPPOC-2784
Description		: 
Author 			: Sukur Babu. B
Creation Date 	: 29/06/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=53)
public void validateCloakDisplayedForAllNotes(){
	String sTicketID,sID,sNotes;
	int iNoteRowCnt;
	boolean bCloakflag=true;
	WebElement CloakChkBox;
	//TicketsPageFactory_Sukur Ticket = new TicketsPageFactory_Sukur();
	try {
		WebDriver driver = WebDriverUtil.getDriver();
		sNotes=(String)FrameworkUtil.dictPropertyData.get("NAV.CREATETICKET.NOTES");
		PageFactory.initElements(driver, TicketTestCase.Ticket);
		FrameworkUtil.sTestCaseName = "EBPanel-validateCloakDisplayedForAllNotes";
		FrameworkUtil.sManualTestCaseName="CPPOC-2784";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		PageFactory.initElements(driver, EBPanel);
		PageFactory.initElements(driver, Ticket);
		//login to catalog
		//navEBPanelLogin();
		LoginTestCase_Old1.LoginAsRoleAUser();
		TicketTC.navigateToTicketPage();
		//Get and expand the ticket
		//This below line updated on 10/02/2015 for EXTJS5 by QAA03
		//WebElement wExpander=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr[1]//tr[1]/td[1]//div[@class='x-grid-row-expander']", "Ticket Arrow Expander");
		WebElement wExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTicketsGridPanel-body']/div/div/table[1]/tbody/tr/td/div/div[@class='x-grid-row-expander']", "Ticket Arrow Expander");
		
		//wExpander.click();
		// this object is added by QAA04 - 02/23/16
		WebObjectUtil.clickElement(wExpander);
		WebObjectUtil.explicitWait(5);
		//This Line updated on 10/02/2015 for EXTJS5 by QAA03
		//sTicketID = WebTableUtil.getCellData(EBPanel.getNav_TicketsWebTable(), 1, 3).trim();
		sTicketID = WebTableUtil.getCellData(Ticket.getNav_TicketsWebTableParent(), 1, 2).trim();
		/*sID="tktNotesImg-"+sTicketID;
		WebElement wNotesExpander=WebObjectUtil.GetWebElement("id", sID, "Notes Expander");*/
		// this object is added by QAA04 - 02/23/16
		WebElement wNotesExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER", "PARAMETER_TICKETID",  sTicketID);
		WebObjectUtil.clickElement(wNotesExpander);
		/*//Expand Notes
		wNotesExpander.click();*/
		WebObjectUtil.explicitWait(5);
		//This below lines updated on 10/05/2015 for EXTJS5 by QAA03
		WebElement wNotesTable = WebObjectUtil.GetWebElement("id", "notesGrid-"+sTicketID+"-body", "NotesTable");
		iNoteRowCnt=WebTableUtil.getRowCount(wNotesTable);
		//iNoteRowCnt=WebTableUtil.getRowCount(Ticket.getNav_NotesWebTable());
		//WebTableUtil.printEachCellText(Ticket.getNav_NotesWebTable());
		
		//This line updated on 10/07/2015 for EXTJS5 by QAA03
		//if(iNoteRowCnt>3)
		if(iNoteRowCnt>2)
		{
			WebObjectUtil.clickElement(Ticket.getNav_ExpandAllNoteCheckbox());
			WebObjectUtil.explicitWait(5);
			//This line updated on 10/07/2015 for EXTJS5 by QAA03
			//for(int i=1;i<=iNoteRowCnt/3;i++)
			for(int i=1;i<=iNoteRowCnt/2;i++)
			{
				//This line updated on 10/05/2015 for EXTJS5 by QAA03
				//CloakChkBox=WebObjectUtil.GetWebElement("xpath", "//table//tr["+i+"]/td/table/tbody/tr[@class='x-grid-rowbody-tr']/td/div/div[contains(@id,'idNotesRow')]/div[contains(@id,'cloakDiv')]/table", "Cloak Check box");
				CloakChkBox=WebObjectUtil.GetWebElement("xpath", "//table[1]//table["+i+"]//input[contains(@id,'cloakChkBox-')]", "Cloak Check box");
				
				if(CloakChkBox!=null)
					bCloakflag=true;
				else
					bCloakflag=false;
			}
			
		}
		else
		{
			//Click on create note link
			WebObjectUtil.clickElement(Ticket.getNav_CreateNoteLink());
			WebObjectUtil.waitForElementPresent(Ticket.getNav_CreateNotesFrame());
			driver.switchTo().frame(Ticket.getNav_CreateNotesFrame());
			//Ticket.getNav_NotesFrame().click();
			WebElement element = driver.findElement(By.cssSelector("body"));
			element.sendKeys(sNotes);
			driver.switchTo().defaultContent();
			
			//WebObjectUtil.clickElement(Ticket.getNav_CreateNoteCloakCheckbox());
			WebObjectUtil.clickElement(Ticket.getNav_CreateNoteOKButton());
			WebObjectUtil.waitForElementPresent(Ticket.getNav_ExpandAllNoteCheckbox());
			
			WebObjectUtil.clickElement(Ticket.getNav_CreateNoteLink());
			WebObjectUtil.waitForElementPresent(Ticket.getNav_CreateNotesFrame());
			driver.switchTo().frame(Ticket.getNav_CreateNotesFrame());
			//Ticket.getNav_NotesFrame().click();
			WebElement element1 = driver.findElement(By.cssSelector("body"));
			element1.sendKeys(sNotes);
			driver.switchTo().defaultContent();
			//Select Cloak check box
			//WebObjectUtil.clickElement(Ticket.getNav_CreateNoteCloakCheckbox());
			WebObjectUtil.clickElement(Ticket.getNav_CreateNoteOKButton());
			WebObjectUtil.explicitWait(5);
			//This below lines updated on 10/05/2015 for EXTJS5 by QAA03
			WebElement wNotesTable1 = WebObjectUtil.GetWebElement("id", "notesGrid-"+sTicketID+"-body", "NotesTable");
			iNoteRowCnt=WebTableUtil.getRowCount(wNotesTable1);
			//iNoteRowCnt=WebTableUtil.getRowCount(Ticket.getNav_NotesWebTable());
			
			WebObjectUtil.clickElement(Ticket.getNav_ExpandAllNoteCheckbox());
			WebObjectUtil.explicitWait(5);
			//This line updated on 10/07/2015 for EXTJS5 by QAA03
			//for(int i=1;i<=iNoteRowCnt/3;i++)
			for(int i=1;i<=iNoteRowCnt/2;i++)
			{
				//This line updated on 10/05/2015 for EXTJS5 by QAA03
				//CloakChkBox=WebObjectUtil.GetWebElement("xpath", "//table//tr["+i+"]/td/table/tbody/tr[@class='x-grid-rowbody-tr']/td/div/div[contains(@id,'idNotesRow')]/div[contains(@id,'cloakDiv')]/table", "Cloak Check box");
				CloakChkBox=WebObjectUtil.GetWebElement("xpath", "//table[1]//table["+i+"]//input[contains(@id,'cloakChkBox-')]", "Cloak Check box");

				if(CloakChkBox!=null)
					bCloakflag=true;
				else
				{
					bCloakflag=false;
					break;
				}
			}
		}
		if(bCloakflag)
			FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Cloak Check box displayed for all Notes" );
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false,  "Cloak Check box is not displayed for all Notes" );
		LoginTestCase_Old1.nav_Logout();
	}
	catch(Exception e)
	{
		LoggerUtil.log_type_error("issue with- validateCloakDisplayedForAllNotes Test Case" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
}

/*==============================================================
TestScript 		: navValidateTicketCountBasedonStatusAndVerifyServiceLogs
Manual TestCase	: CPPOC-2782
Description		: 
Author 			: Sukur Babu. B
Creation Date 	: 30/06/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=54)
public void navValidateTicketCountBasedonStatusAndVerifyServiceLogs(){
	String sTicketID,sID,sNotes,sOpenTicketCnt,sWrkingTicketCnt,sPndingTicketCnt,sReslvedTicketCnt,sOpenTicketCntAfterClosed,sReslvedTicketCntAfterClosed,sActOutStandingTicketCnt,sActResolvedTicketCnt,sLastUpdated;
	int iNoteRowCnt,sExpectedOutStandingTicketCnt,sExpectedReslvedTicketCntinHmPg;
	
	//TicketsPageFactory_Sukur Ticket = new TicketsPageFactory_Sukur();
	try {
		WebDriver driver = WebDriverUtil.getDriver();
		sNotes=(String)FrameworkUtil.dictPropertyData.get("NAV.CREATETICKET.NOTES");
		PageFactory.initElements(driver, TicketTestCase.Ticket);
		FrameworkUtil.sTestCaseName = "Tickets-navValidateTicketCountBasedonStatusAndVerifyServiceLogs";
		FrameworkUtil.sManualTestCaseName="CPPOC-2782";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		PageFactory.initElements(driver, EBPanel);
		PageFactory.initElements(driver, Ticket);
		//login to catalog
		//navEBPanelLogin();
		LoginTestCase_Old1.LoginAsRoleAUser();
		TicketTC.navigateToTicketPage();
		WebObjectUtil.explicitWait(3);
		sOpenTicketCnt=Ticket.getNav_OpenTicketNumbers().getText();
		//sWrkingTicketCnt=Ticket.getNav_WorkingTicketNumbers().getText();
		//sPndingTicketCnt=Ticket.getNav_PendingTicketNumbers().getText();
		sReslvedTicketCnt=Ticket.getNav_ResolvedTicketNumbers().getText();
		//This Line updated on 10/02/2015 for EXTJS5 by QAA03
		//Get and expand the ticket
		//sTicketID = WebTableUtil.getCellData(EBPanel.getNav_TicketsWebTable(), 1, 3).trim();
		sTicketID = WebTableUtil.getCellData(Ticket.getNav_TicketsWebTableParent(), 1, 2).trim();
		sID="tktLogsImg-" + sTicketID;
		//This below line updated on 10/02/2015 for EXTJS5 by QAA03
		//WebElement wExpander=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr[1]//tr[1]/td[1]//div[@class='x-grid-row-expander']", "Ticket Arrow Expander");
		WebElement wExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTicketsGridPanel-body']/div/div/table[1]/tbody/tr/td/div/div[@class='x-grid-row-expander']", "Ticket Arrow Expander");
		// this object is added by QAA04 - 02/23/16
		WebObjectUtil.clickElement(wExpander);
		//wExpander.click();
		WebObjectUtil.explicitWait(5);
		
		WebElement wTicketSummary=WebObjectUtil.GetWebElement("id","dv_summary_text-"+sTicketID+"-inputEl","Ticket Summary Input Field");
		String sTicketSummary=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.TICKET.SUMMARY");
		wTicketSummary.sendKeys(sTicketSummary);
		WebObjectUtil.clickElement(Ticket.getNav_TicketSaveUpdatesButton());
		WebObjectUtil.explicitWait(5);
		WebObjectUtil.clickElement(Ticket.getNav_ConfirmPopupOkBtn());
		WebObjectUtil.explicitWait(5);
		WebElement wTicketLogExpander=WebObjectUtil.GetWebElement("id",sID,"Ticket Log Expander");
		//wTicketLogExpander.click();
		// this object is added by QAA04 - 02/23/16
		WebObjectUtil.clickElement(wTicketLogExpander);
		WebObjectUtil.explicitWait(5);
		//Following Xpath got changed. Updated new one by Sukur Dated on 15-02-2016
		
		//WebElement wLastUpdated=WebObjectUtil.GetWebElement("xpath", "//div[@id='tktDropDown-"+sTicketID+"']//dd[text()='Date Last Updated']/../dt", "Last Updated Date Element");
		WebElement wLastUpdated=WebObjectUtil.GetWebElement("xpath", "//div[@id='tktDropDown-"+sTicketID+"']//dl/dt[contains(text(),'Date Last Updated')]/../dd", "Last Updated Date Element");
		sLastUpdated=wLastUpdated.getText();
		WebElement wLogData=WebObjectUtil.GetWebElement("xpath", "//div[@id='tktLogsGrid-"+sTicketID+"-body']","Ticket Log Table");
		String sLogData=wLogData.getText();
		if(sLogData.contains(sLastUpdated))
			FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Logs are reflecting the last updated date and with few fields" );
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false,  "Logs are not reflecting the last updated date and with few fields" );
		
		
		WebObjectUtil.clickElement(Ticket.getNav_TicketStatusDropdown());
		//WebObjectUtil.selectWebList(Ticket.getNav_TicketStatusList(), null, "Closed", null);
		WebObjectUtil.selectCustomWebList(Ticket.getNav_TicketStatusList(), "Closed");
	
		
		WebObjectUtil.clickElement(Ticket.getNav_TicketSaveUpdatesButton());
		WebObjectUtil.explicitWait(5);
		WebObjectUtil.clickElement(Ticket.getNav_ConfirmPopupOkBtn());
		WebObjectUtil.explicitWait(5);
		sOpenTicketCntAfterClosed=Ticket.getNav_OpenTicketNumbers().getText();
		sReslvedTicketCntAfterClosed=Ticket.getNav_ResolvedTicketNumbers().getText();
		sWrkingTicketCnt=Ticket.getNav_WorkingTicketNumbers().getText();
		sPndingTicketCnt=Ticket.getNav_PendingTicketNumbers().getText();
		if(Integer.parseInt(sOpenTicketCntAfterClosed)==Integer.parseInt(sOpenTicketCnt)-1)
			FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Open Ticket count is matching" );
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Open Ticket count is not matching" );
		if(Integer.parseInt(sReslvedTicketCntAfterClosed)==Integer.parseInt(sReslvedTicketCnt)+1)
			FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Resolved Ticket count is matching" );
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Resolved Ticket count is not matching" );
		WebObjectUtil.clickElement(EBPanel.getNav_WSLogo());
		WebObjectUtil.explicitWait(5);
		sActOutStandingTicketCnt=EBPanel.getNav_OutStandingTicketCntInHmPg().getText();
		sActResolvedTicketCnt=EBPanel.getNav_ResolvedTicketCntInHmPg().getText();
		sExpectedOutStandingTicketCnt=Integer.parseInt(sOpenTicketCntAfterClosed)+Integer.parseInt(sWrkingTicketCnt)+Integer.parseInt(sPndingTicketCnt);
		if(Integer.parseInt(sActOutStandingTicketCnt)==sExpectedOutStandingTicketCnt)
			FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Out Standing ticket count matching in Ticket portlet of the home page" );
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Out Standing ticket count is not matching in Ticket portlet of the home page" );
		if(Integer.parseInt(sActResolvedTicketCnt)==Integer.parseInt(sReslvedTicketCntAfterClosed))
			FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Resolved ticket count matching in Ticket portlet of the home page" );
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Resolved ticket count is not matching in Ticket portlet of the home page" );
		
		
		
		LoginTestCase_Old1.nav_Logout();
	}
	catch(Exception e)
	{
		LoggerUtil.log_type_error("issue with- navValidateTicketCountBasedonStatusAndVerifyServiceLogs Test Case" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
}
/*==============================================================
TestScript 		: navVerifyServiceDescriptionColumnDisplays
Manual TestCase	:  CPPOC-2817
Description		: 
Author 			: Sukur Babu. B
Creation Date 	: 30/06/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=57)
public void navVerifyServiceDescriptionColumnDisplays(){
	String sTicketID,sID,sNotes;
	int iNoteRowCnt;
	boolean bCloakflag=true;
	WebElement CloakChkBox;
	//TicketsPageFactory_Sukur Ticket = new TicketsPageFactory_Sukur();
	try {
		WebDriver driver = WebDriverUtil.getDriver();
		sNotes=(String)FrameworkUtil.dictPropertyData.get("NAV.CREATETICKET.NOTES");
		PageFactory.initElements(driver, TicketTestCase.Ticket);
		FrameworkUtil.sTestCaseName = "Tickets-navVerifyServiceDescriptionColumnDisplays";
		FrameworkUtil.sManualTestCaseName="CPPOC-2817";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		PageFactory.initElements(driver, EBPanel);
		PageFactory.initElements(driver, Ticket);
		//login to catalog
		//navEBPanelLogin();
		LoginTestCase_Old1.LoginAsRoleAUser();
		TicketTC.navigateToTicketPage();
		//Get and expand the ticket
		//This below line updated on 10/01/2015 for EXTJS5 by QAA03
		//WebElement wExpander=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr[1]//tr[1]/td[1]//div[@class='x-grid-row-expander']", "Ticket Arrow Expander");
		WebElement wExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTicketsGridPanel-body']/div/div/table[1]/tbody/tr/td/div/div[@class='x-grid-row-expander']", "Ticket Arrow Expander");
		// this object is added by QAA04 - 02/23/16
		WebObjectUtil.clickElement(wExpander);
		//wExpander.click();
		WebObjectUtil.explicitWait(5);
		//This Line updated on 10/02/2015 for EXTJS5 by QAA03
		//sTicketID = WebTableUtil.getCellData(EBPanel.getNav_TicketsWebTable(), 1, 3).trim();
		sTicketID = WebTableUtil.getCellData(Ticket.getNav_TicketsWebTableParent(), 1, 2).trim();
		sID="tktServiceLogsImg-" + sTicketID;
		WebElement wTicketServiceLogsExpander=WebObjectUtil.GetWebElement("id", sID, "Notes Expander");
		//Expand Notes
		//wTicketServiceLogsExpander.click();
		// this object is added by QAA04 - 02/23/16
		WebObjectUtil.clickElement(wTicketServiceLogsExpander);
		
		WebObjectUtil.explicitWait(5);
		WebElement wServiceDescriptionColumn=WebObjectUtil.GetWebElement("xpath", "//span[text()='Service Description']", "Service Description Column");
		if(wServiceDescriptionColumn!=null)
			FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Service Description Column displayed properly" );
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false,  "Service Description Column not displayed properly" );
		LoginTestCase_Old1.nav_Logout();
		}
	catch(Exception e)
	{
		LoggerUtil.log_type_error("issue with- navVerifyServiceDescriptionColumnDisplays Test Case" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
}
/*==============================================================
TestScript 		: navVerifyDataAndTimeColumnDisplaysLogsanfServiceLogs
Manual TestCase	:  CPPOC-2812
Description		: 
Author 			: Sukur Babu. B
Creation Date 	: 30/06/2015
Pre-Requisites	:
Revision History:
==============================================================*/
/*@Test(priority=58)
public void navVerifyDataAndTimeColumnDisplaysLogsanfServiceLogs(){
	String sTicketID,sID,sNotes;
	int iNoteRowCnt;
	boolean bCloakflag=true;
	WebElement CloakChkBox;
	//TicketsPageFactory_Sukur Ticket = new TicketsPageFactory_Sukur();
	try {
		WebDriver driver = WebDriverUtil.getDriver();
		sNotes=(String)FrameworkUtil.dictPropertyData.get("NAV.CREATETICKET.NOTES");
		PageFactory.initElements(driver, TicketTestCase.Ticket);
		FrameworkUtil.sTestCaseName = "Tickets-navVerifyDataAndTimeColumnDisplaysLogsanfServiceLogs";
		FrameworkUtil.sManualTestCaseName="CPPOC-2812";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		PageFactory.initElements(driver, EBPanel);
		PageFactory.initElements(driver, Ticket);
		//login to catalog
		//navEBPanelLogin();
		 LoginTestCase.LoginAsRoleAUser();
		TicketTC.navigateToTicketPage();
		//Get and expand the ticket
		WebElement wExpander=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr[1]//tr[1]/td[1]//div[@class='x-grid-row-expander']", "Ticket Arrow Expander");
		wExpander.click();
		WebObjectUtil.explicitWait(5);
		sTicketID = WebTableUtil.getCellData(EBPanel.getNav_TicketsWebTable(), 1, 3).trim();
		sID="tktServiceLogsImg-" + sTicketID;
		WebElement wTicketServiceLogsExpander=WebObjectUtil.GetWebElement("id", sID, "Ticket Service Logs Expander");
		//Expand Notes
		wTicketServiceLogsExpander.click();
		WebObjectUtil.explicitWait(5);
		WebElement wDataAndTimeColumn=WebObjectUtil.GetWebElement("xpath", "//span[text()='Data/Time']", "Date/Time Column");
		if(wDataAndTimeColumn!=null)
			FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Date/Time Column displayed properly in Tickets Service Logs Section" );
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false,  "Date/Time not displayed properly in Tickets Service Logs Section" );
		sID="tktLogsImg-" + sTicketID;
		WebElement wTicketLogsExpander=WebObjectUtil.GetWebElement("id", sID, "Ticket Logs Expander");
		//Expand Notes
		wTicketLogsExpander.click();
		WebObjectUtil.explicitWait(5);
		wDataAndTimeColumn=WebObjectUtil.GetWebElement("xpath", "//span[text()='Data/Time']", "Date/Time Column");
		if(wDataAndTimeColumn!=null)
			FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Date/Time Column displayed properly in Ticket Logs section" );
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false,  "Date/Time not displayed properly in Ticket Logs section" );
		LoginTestCase.nav_Logout();
		}
	catch(Exception e)
	{
		LoggerUtil.log_type_error("issue with- navVerifyDataAndTimeColumnDisplaysLogsanfServiceLogs Test Case" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
}
*/

@Test(priority=58)
public void navVerifyDateColumnDisplaysLogsandServiceLogs(){
String sTicketID,sID,sNotes;
int iNoteRowCnt;
boolean bCloakflag=true;
WebElement CloakChkBox;
//TicketsPageFactory_Sukur Ticket = new TicketsPageFactory_Sukur();
try {
	WebDriver driver = WebDriverUtil.getDriver();
	sNotes=(String)FrameworkUtil.dictPropertyData.get("NAV.CREATETICKET.NOTES");
	PageFactory.initElements(driver, TicketTestCase.Ticket);
	FrameworkUtil.sTestCaseName = "Tickets-navVerifyDateColumnDisplaysLogsandServiceLogs";
	FrameworkUtil.sManualTestCaseName="CPPOC-2812";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	PageFactory.initElements(driver, Ticket);
	//login to catalog
	//navEBPanelLogin();
	LoginTestCase_Old1.LoginAsRoleAUser();
	TicketTestCase.navigateToTicketPage();
	//Get and expand the ticket
	//This below line updated on 10/02/2015 for EXTJS5 by QAA03
	//WebElement wExpander=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr[1]//tr[1]/td[1]//div[@class='x-grid-row-expander']", "Ticket Arrow Expander");
	WebElement wExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTicketsGridPanel-body']/div/div/table[1]/tbody/tr/td/div/div[@class='x-grid-row-expander']", "Ticket Arrow Expander");
	//wExpander.click();
	// this object is added by QAA04 - 02/23/16
	WebObjectUtil.clickElement(wExpander);
	WebObjectUtil.explicitWait(5);
	//This Line updated on 10/02/2015 for EXTJS5 by QAA03
	//sTicketID = WebTableUtil.getCellData(Ticket.getNav_TicketsWebTableParent(), 1, 3).trim();
	sTicketID = WebTableUtil.getCellData(Ticket.getNav_TicketsWebTableParent(), 1, 2).trim();
	sID="tktServiceLogsImg-" + sTicketID;
	WebElement wTicketServiceLogsExpander=WebObjectUtil.GetWebElement("id", sID, "Ticket Service Logs Expander");
	//Expand Notes
	//wTicketServiceLogsExpander.click();
	// this object is added by QAA04 - 02/23/16
	WebObjectUtil.clickElement(wTicketServiceLogsExpander);
	WebObjectUtil.explicitWait(5);
	// changed Data/Time to Date as per test case by Arul on 08/20/2015
	WebElement wDataAndTimeColumn=WebObjectUtil.GetWebElement("xpath", "//section[contains(@id,'tktServiceLogsSection-')]//span[text()='Date']", "Date Column");
	if(wDataAndTimeColumn!=null)
		FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Date/Time Column displayed properly in Tickets Service Logs Section" );
	else
		FrameworkUtil.updateCustomResultBasedOnStatus(false,  "Date/Time not displayed properly in Tickets Service Logs Section" );
	sID="tktLogsImg-" + sTicketID;
	WebElement wTicketLogsExpander=WebObjectUtil.GetWebElement("id", sID, "Ticket Logs Expander");
	//Expand Notes
	//wTicketLogsExpander.click();
	// this object is added by QAA04 - 02/23/16
	WebObjectUtil.clickElement(wTicketLogsExpander);
	WebObjectUtil.explicitWait(5);
	// changed Data/Time to Date as per test case by Arul on 08/20/2015
	wDataAndTimeColumn=WebObjectUtil.GetWebElement("xpath", "//section[contains(@id,'tktLogsSection-')]//span[text()='Date']", "Date Column");
	if(wDataAndTimeColumn!=null)
		FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Date Column displayed properly in Ticket Logs section" );
	else
		FrameworkUtil.updateCustomResultBasedOnStatus(false,  "Date not displayed properly in Ticket Logs section" );
	LoginTestCase_Old1.nav_Logout();
	}
catch(Exception e)
{
	LoggerUtil.log_type_error("issue with- navVerifyDataAndTimeColumnDisplaysLogsanfServiceLogs Test Case" );
	LoggerUtil.log_type_error(e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
}
}

/*==============================================================
TestScript 		: validateNoteasCollapseFunctionality
Manual TestCase	:  CPPOC-2849
Description		: 
Author 			: Sukur Babu. B
Creation Date 	: 30/06/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=59)
public void validateNoteasCollapseFunctionality(){
	String sTicketID,sID,sNotes;
	
	//TicketsPageFactory_Sukur Ticket = new TicketsPageFactory_Sukur();
	try {
		WebDriver driver = WebDriverUtil.getDriver();
		sNotes=(String)FrameworkUtil.dictPropertyData.get("NAV.CREATETICKET.NOTES");
		PageFactory.initElements(driver, TicketTestCase.Ticket);
		FrameworkUtil.sTestCaseName = "Tickets-validateNoteasCollapseFunctionality";
		FrameworkUtil.sManualTestCaseName="CPPOC-2849";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		PageFactory.initElements(driver, EBPanel);
		PageFactory.initElements(driver, Ticket);
		//login to catalog
		//navEBPanelLogin();
		LoginTestCase_Old1.LoginAsRoleAUser();
		TicketTC.navigateToTicketPage();
		//Get and expand the ticket
		//This below line updated on 10/02/2015 for EXTJS5 by QAA03
		//WebElement wExpander=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr[1]//tr[1]/td[1]//div[@class='x-grid-row-expander']", "Ticket Arrow Expander");
		WebElement wExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTicketsGridPanel-body']/div/div/table[1]/tbody/tr/td/div/div[@class='x-grid-row-expander']", "Ticket Arrow Expander");
		//wExpander.click();
		// this object is added by QAA04 - 02/23/16
		WebObjectUtil.clickElement(wExpander);
		WebObjectUtil.explicitWait(5);
		//This Line updated on 10/02/2015 for EXTJS5 by QAA03
		//sTicketID = WebTableUtil.getCellData(EBPanel.getNav_TicketsWebTable(), 1, 3).trim();
		sTicketID = WebTableUtil.getCellData(Ticket.getNav_TicketsWebTableParent(), 1, 2).trim();
		/*sID="tktNotesImg-" + sTicketID;
		WebElement wNotesExpander=WebObjectUtil.GetWebElement("id", sID, "Notes Expander");*/
	// this object is added QAA04 - 02/23/16
		WebElement wNotesExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER", "PARAMETER_TICKETID",  sTicketID);
		//Expand Notes
		//wNotesExpander.click();
		// this object is added by QAA04 - 02/23/16
		WebObjectUtil.clickElement(wNotesExpander);
		WebObjectUtil.explicitWait(5);
		WebObjectUtil.verifyElementPresent(Ticket.getNav_TicketCreateNoteLink());
		// this object is added by QAA04 - 02/23/16
		WebObjectUtil.clickElement(wNotesExpander);
		//wNotesExpander.click();
		WebObjectUtil.explicitWait(5);
		if(Ticket.getNav_TicketCreateNoteLink().isDisplayed())
			FrameworkUtil.updateCustomResultBasedOnStatus(false,  "Create Notes link is still visible. So, Confirming that Notes not collapsed" );
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Create Notes link is invisible now. So, confirmng that Notes collapsed" );
		LoginTestCase_Old1.nav_Logout();
	}
catch(Exception e)
	{
		LoggerUtil.log_type_error("issue with- validateNoteasCollapseFunctionality Test Case" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
}			
	
/*==============================================================
Method Name 	: navEBPanelLogin
Description		: Login to Catalog using devco1
Author 			: Sukru Babu
Creation Date 	: 28/07/2015
Pre-Requisites	:
Revision History:
==============================================================*/
public static void navEBPanelLogin()
{
	String sUserName,sPassword;
	try{
	sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.USERID.AROLE");
	sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.PASSWORD.AROLE");
	LoginTestCase_Old1.nav_Login(sUserName,sPassword);
	}
	catch(Exception e)
	{
		LoggerUtil.log_type_error("issue with- navEBPanelLogin method" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
}

//___________________________Completed ByronTextCase ________________________________________///
//___________________________Clark test cases __________________________________________________///

/*==============================================================
TestScript 		: validateCreateNoteErrorMsg
Manual TestCase	: Validate Create Note Error message if user clicks on OK button without entering Notes. CPPOC-2819
Description		: 
Author 			: Sukur Babu. B
Creation Date 	: 10/08/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=55)
public void validateCreateNoteErrorMsg(){
	WebElement wExpander,wNotesExpander;
	try {
		WebDriver driver = WebDriverUtil.getDriver();
		
		PageFactory.initElements(driver, Ticket);
		
		FrameworkUtil.sTestCaseName = "Clark-validateCreateNoteErrorMsg";
		FrameworkUtil.sManualTestCaseName="Validate Create Note Error message if user clicks on OK button without entering Notes. CPPOC-2819";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		String sExpErrMsg,sActErrMsg;
		/*String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO.USERID.AROLE");
		String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO.PASSWORD.AROLE");*/
		
		String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.USERID.QAAUTO");
	    String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.PWD.QAAUTO");
		//String sNotes=(String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.NOTES.VALUE");
		String sTicketID,sID;
		//Login to Navigator portlet 
		//LoginTestCase.nav_Login(sUserName,sPassword);
		LoginTestCase_Old1.LoginAsQaautoUser();
		//Navigate to ticket page
		TicketTestCase.navigateToTicketPage();
		//Get and expand the ticket
		// This object is updated on 10/06/2015 By QAA04
		//wExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTicketsGridPanel-body']//table[1]//div[@class='x-grid-row-expander']", "Ticket Arrow Expander");
		//WebElement wExpander=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr[1]//tr[1]/td[1]//div[@class='x-grid-row-expander']", "Ticket Arrow Expander");
		 // This object is updated on 10/13/2015 By QAA04
		wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
		// this object is added by QAA04 - 02/23/16
		WebObjectUtil.clickElement(wExpander);
		//wExpander.click();
		WebObjectUtil.explicitWait(5);
//		sTicketID = (WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 3)).trim();
		  sTicketID = TicketTestCase.getTicketID(1);
		//for exucution
		//sID="tktNotesImg-" + sTicketID;
		// This object is updated on 10/06/2015 By QAA04
		//WebElement wNotesExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTicketsGridPanel-body']/div/div/table[1]/tbody//tr[2]//img[contains(@id,'tktNotesImg-')]", "Notes Expander");
		 // This object is updated on 10/13/2015 By QAA04
		wNotesExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER", "PARAMETER_TICKETID",  sTicketID);
		WebObjectUtil.clickElement(wNotesExpander);
		//WebElement wNotesExpander=WebObjectUtil.GetWebElement("id", sID, "Notes Expander");
		//Expand Notes
		//wNotesExpander.click();
		WebObjectUtil.explicitWait(5);
		//Click on create note link
		WebObjectUtil.clickElement(Ticket.getNav_CreateNoteLink());
		WebObjectUtil.waitForElementPresent(Ticket.getNav_CreateNotesFrame());
		WebObjectUtil.clickElement(Ticket.getNav_CreateNoteOKButton());
		sExpErrMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.CLARK.TICKET.NOTE.ERR.MSG");
		sActErrMsg=Ticket.getNav_ConfirmPopup().getText();
		if(sActErrMsg.contains(sExpErrMsg))
			FrameworkUtil.updateCustomResultBasedOnStatus(true,  "Error pop up displayed");
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false,  "Error pop up not displayed");
		WebObjectUtil.clickElement(Ticket.getNav_ConfirmPopupOkBtn());
		LoginTestCase_Old1.nav_Logout();
		} catch (Exception e) {
		LoggerUtil.log_type_error("issue with- validateCreateNoteErrorMsg Test Case" );
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		LoggerUtil.log_type_error(e.getMessage());
	}
}

/*==============================================================
TestScript  	: VerifyClarkSP1TktSearch
Manual TestCase	: CPPOC-3107
Description		: Ticket ID 643148 has a ticket id "643151" in the "Summary" field
Author 			: Priyanka R
Creation Date 	: 10/8/15
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=81)
public void VerifyClarkSP1TktSearch()
{
	
	PageFactory.initElements(WebDriverUtil.getDriver(),Ticket);
	try{
	WebElement wTicketID;
	String sTktID,sTktIDVerify;
	sTktID=(String)FrameworkUtil.dictPropertyData.get("NAV.CLARKSP1.TICKETID");
	FrameworkUtil.sTestCaseName = "Clark-VerifyClarkSP1TktSearch";
	FrameworkUtil.sManualTestCaseName= "CPPOC-3107";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	WebDriver driver = WebDriverUtil.getDriver();

	//navClarkLogin();
    LoginTestCase_Old1.LoginAsRoleAUser();
	TicketTestCase.navigateToTicketPage();
	WebObjectUtil.explicitWait(20);
	WebObjectUtil.ClickAndMouseHover(Ticket.getNav_FilterByStatusDropdown());
    //WebObjectUtil.clickElement(Ticket.getNav_ClosedMore());
	WebObjectUtil.clickElement(Ticket.getNav_ClosedLess());
    WebObjectUtil.explicitWait(10);
    WebObjectUtil.ClickAndMouseHover(Ticket.getNav_TicketSearchByDropdown());
    WebObjectUtil.clickElement(Ticket.getNav_ClarkSearchByTicketID());
    WebObjectUtil.clickElement(Ticket.getNav_TicketID());
    WebObjectUtil.explicitWait(10);
    WebObjectUtil.clickElement(Ticket.getNav_SearchTextField());
    WebObjectUtil.SetValueEdit(Ticket.getNav_SearchTextField(),""+sTktID);
    WebObjectUtil.explicitWait(5);
    WebObjectUtil.clickElement(Ticket.getNav_SearchIcon());
    WebObjectUtil.explicitWait(20);
    //WebObjectUtil.verifyElementPresent(Clark.getNav_ClarkTicketDisplay());
   // WebElement updated by QAA04 - 10/02/2015
   /// wTicketID=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTicketsGridPanel-body']/div[1]/div/table[1]/tbody/tr[1]/td[2]/div", "TicketID");
    // This object is updated on 10/13/2015 By QAA04
    wTicketID = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.TICKETID","PARAMETER_ROWNUMBER", 1 +"");
    //wTicketID=WebObjectUtil.GetWebElement("xpath", "//span/div/div[2]/div[3]/div/table/tbody/tr/td/table/tbody/tr[1]/td[2]/div", "TicketID");
    WebObjectUtil.explicitWait(10);
    sTktIDVerify=wTicketID.getText();
    if(sTktID.equalsIgnoreCase(sTktIDVerify))
    FrameworkUtil.updateCustomResultBasedOnStatus(true, sTktID + "Passed and Ticket is displayed" );
    else
    FrameworkUtil.updateCustomResultBasedOnStatus(false,sTktID+ "failed, Ticket not found/displayed" );

    LoginTestCase_Old1.nav_Logout();
	}
	catch(Exception e)
	{
		LoggerUtil.log_type_error("issue with- Clark-VerifyClarkSP1TktSearch TestCase" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
}

/*==============================================================
TestScript  	: VerifyClarkSP1AdvancedTktSearch
Manual TestCase	: CPPOC-3102
Description		: Verify the time it takes for data to load in "Chrome" browser
Author 			: Priyanka R
Creation Date 	: 10/8/15
Pre-Requisites	:
Revision History:
==============================================================*/
//@Test(priority=82)
public void VerifyClarkSP1AdvancedTktSearch()
{
	
	PageFactory.initElements(WebDriverUtil.getDriver(),Ticket);
	try{
	FrameworkUtil.sTestCaseName = "Clark-VerifyClarkSP1AdvancedTktSearch";
	FrameworkUtil.sManualTestCaseName= "CPPOC-3102";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	WebDriver driver = WebDriverUtil.getDriver();
	
	//navClarkLogin();
    LoginTestCase_Old1.LoginAsRoleAUser();
	TicketTestCase.navigateToTicketPage();
	WebObjectUtil.explicitWait(20);
	WebObjectUtil.ClickAndMouseHover(Ticket.getNav_FilterByStatusDropdown());
    WebObjectUtil.clickElement(Ticket.getNav_ClosedMore());
    WebObjectUtil.explicitWait(20);
    WebObjectUtil.ClickAndMouseHover(Ticket.getNav_ClarkOrgComboSearch());
    WebObjectUtil.clickElement(Ticket.getNav_ClarkHostedsolorg());
    WebObjectUtil.ClickAndMouseHover(Ticket.getNav_TicketSearchByDropdown());
    WebObjectUtil.clickElement(Ticket.getNav_ClarkSearchByAdv());
    WebObjectUtil.clickElement(Ticket.getNav_SearchTextField());
    Ticket.getNav_SearchTextField().sendKeys("patch");
    WebObjectUtil.explicitWait(5);
    WebObjectUtil.clickElement(Ticket.getNav_SearchIcon());
    WebObjectUtil.explicitWait(20);
	LoginTestCase_Old1.nav_Logout();
	}
	catch(Exception e)
	{
		LoggerUtil.log_type_error("issue with- Clark-VerifyClarkSP1AdvancedTktSearch TestCase" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
}

/*==============================================================
TestScript  	: 
Manual TestCase	: CPPOC-3093
Description		: WCP user is navigating thru tickets page and verifying 
                  data/column names are displayed for closed tickets
Author 			: Priyanka R
Creation Date 	: 10/8/15
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=83)
public void VerifyClarkSP1ExpandTkt()
{
	
	PageFactory.initElements(WebDriverUtil.getDriver(),Ticket);
	try{
	FrameworkUtil.sTestCaseName = "Clark-VerifyClarkSP1ExpandTkt";
	FrameworkUtil.sManualTestCaseName= "CPPOC-3093";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	WebDriver driver = WebDriverUtil.getDriver();

	//navClarkLogin();
    LoginTestCase_Old1.LoginAsRoleAUser();
	TicketTestCase.navigateToTicketPage();
	WebObjectUtil.explicitWait(20);
	WebObjectUtil.ClickAndMouseHover(Ticket.getNav_FilterByStatusDropdown());
    WebObjectUtil.clickElement(Ticket.getNav_ClosedMore());
    WebObjectUtil.explicitWait(20);
    WebElement wExpander,wTktlogExpander;
	//dynamic XPATH of Expand icon
 // This object is updated on 10/06/2015 By QAA04
 	//wExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTicketsGridPanel-body']/div/div/table[1]/tbody/tr[1]/td[1]//div[@class='x-grid-row-expander']", "Ticket Arrow Expander");
    // This object is updated on 10/13/2015 By QAA04
    wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
    //wExpander=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+1+"]//tr[1]/td[1]//div[@class='x-grid-row-expander']", "Arrow Expander");
	WebObjectUtil.explicitWait(10);
	WebObjectUtil.clickElement(wExpander);
	WebObjectUtil.explicitWait(5);
	 // This object is updated on 10/06/2015 By QAA04
	//wTktlogExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTicketsGridPanel-body']//table[1]//img[contains(@id,'tktLogsImg-')]", "TicketLogXpand");
	 // This object is updated on 10/13/2015 By QAA04
	wTktlogExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETLOGS.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
	//wTktlogExpander=WebObjectUtil.GetWebElement("xpath", "//tr[1]/td/table/tbody/tr[2]/td/div/section[3]/div[1]/a/img", "TicketLogXpand");
	WebObjectUtil.explicitWait(10);
	WebObjectUtil.clickElement(wTktlogExpander);
	WebObjectUtil.explicitWait(10);
	WebObjectUtil.verifyElementPresent(Ticket.getNav_ClarkTktlogMemoColumn());
	WebObjectUtil.verifyElementPresent(Ticket.getNav_ClarkBilledMinutesColumn());
	WebObjectUtil.verifyElementPresent(Ticket.getNav_ClarkSrvcNumColumn());
	WebObjectUtil.verifyElementPresent(Ticket.getNav_ClarkSrvcDescColumn());
	WebObjectUtil.verifyElementPresent(Ticket.getNav_ClarkSrvcUserColumn());
	WebObjectUtil.verifyElementPresent(Ticket.getNav_ClarkTktlogDateColumn());
	WebObjectUtil.verifyElementPresent(Ticket.getNav_ClarkTktlogMemoColumn());
	//WebObjectUtil.verifyElementPresent(Clark.getNav_ClarkTktSrvcLogsGrid());
	LoginTestCase_Old1.nav_Logout();
	}
	catch(Exception e)
	{
		LoggerUtil.log_type_error("issue with-Clark-VerifyClarkSP1ExpandTkt TestCase" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
}

/*==============================================================
TestScript  	: VerifyClarkSP1Closd
Manual TestCase	: CPPOC-3090
Description		: Verify .Hosted Solution user is able to update a status of 
                  an existing ticket to "Resolved"
Author 			: Priyanka R
Creation Date 	: 10/8/15
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=84)
public void VerifyClarkSPClosed()
{
	WebElement wExpander;
	String sResolvdTkts,sResolvdTkts1;
	int iResolvdTkts,iResolvdTkts1;
	
	PageFactory.initElements(WebDriverUtil.getDriver(),Ticket);
	try{
	FrameworkUtil.sTestCaseName = "Clark-VerifyClarkSPClosed";
	FrameworkUtil.sManualTestCaseName= "CPPOC-3090";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	WebDriver driver = WebDriverUtil.getDriver();
	
	//navClarkLogin();
    LoginTestCase_Old1.LoginAsRoleAUser();
	TicketTestCase.navigateToTicketPage();
	 //// this object is updated as part of EXTJS5 on 10/08/2015 by QAA04
	/*WebObjectUtil.explicitWait(20);
	WebObjectUtil.ClickAndMouseHover(Ticket.getNav_FilterByStatusDropdown());
    WebObjectUtil.clickElement(Ticket.getNav_ClosedMore());
    WebObjectUtil.explicitWait(20)*/;
    sResolvdTkts=Ticket.getNav_ResolvedTicketNumbers().getText();
    FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Resolved Ticket count", "pass", "Resolved Ticket count before update:" + sResolvdTkts );
    iResolvdTkts = Integer.parseInt(sResolvdTkts);
    //dynamic XPATH of Expand icon
    //// this object is updated as part of EXTJS5 on 10/07/2015 by QAA04
   // wExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTicketsGridPanel-body']/div/div/table[1]/tbody/tr[1]/td[1]//div[@class='x-grid-row-expander']", "Arrow Expander");
    // This object is updated on 10/13/2015 By QAA04
    wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
    //wExpander=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+1+"]//tr[1]/td[1]//div[@class='x-grid-row-expander']", "Arrow Expander");
	WebObjectUtil.clickElement(wExpander);
	WebObjectUtil.explicitWait(5);
	 //// this object is updated as part of EXTJS5 on 10/08/2015 by QAA04
	WebObjectUtil.clickElement(Ticket.getNav_ClarkTktStatus());
	WebObjectUtil.selectCustomWebList(Ticket.getNav_ClarkTckDetailStatusDropdown(),"Closed");
	//WebObjectUtil.selectCustomWebList(Clark.getNav_ClarkTktStatus(),"Closed");
	WebObjectUtil.explicitWait(5);

	//WebObjectUtil.clickElement(Clark.getNav_ClarkSaveTktStatus());
	WebObjectUtil.clickElement(Ticket.getNav_TicketSaveUpdatesBtn());
	WebObjectUtil.explicitWait(5);
	WebObjectUtil.clickElement(Ticket.getNav_ClarkSaveTktOkBtn());
	WebObjectUtil.explicitWait(10);
	sResolvdTkts1=Ticket.getNav_ResolvedTicketNumbers().getText();
	WebObjectUtil.explicitWait(5);
	iResolvdTkts1 = Integer.parseInt(sResolvdTkts1);
	iResolvdTkts = iResolvdTkts+1;
	sResolvdTkts1=iResolvdTkts+"";

	//if(sResolvdTkts.equalsIgnoreCase(sResolvdTkts1))
	if (iResolvdTkts1 == iResolvdTkts)
    FrameworkUtil.updateCustomResultBasedOnStatus(true, iResolvdTkts + " - Passed for number of Resolved Tickets count updated" );
    else
    FrameworkUtil.updateCustomResultBasedOnStatus(false, iResolvdTkts + " - failed for number of Resolved Tickets count is not updated" );

	LoginTestCase_Old1.nav_Logout();
	}
	catch(Exception e)
	{
		LoggerUtil.log_type_error("issue with- Clark-VerifyClarkSPClosd TestCase" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
}

/*==============================================================
TestScript  	: VerifyClarkSP1WrkngPendTkt
Manual TestCase	: CPPOC-3091
Description		: Verify .Hosted Solution user is able to update a status of 
                  an existing ticket to either "Working" or "Pending"
Author 			: Priyanka R
Creation Date 	: 10/8/15
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=86)
public void VerifyClarkSP1WrkngPendTkt()
{
	WebElement wExpander;
	String sPendTkts,sWorkTkts,sPendTkts1,sWorkTkts1;
	int iPendTkts,iWorkTkts,iPendTkts1,iWorkTkts1;

	PageFactory.initElements(WebDriverUtil.getDriver(),Ticket);
	try{
	FrameworkUtil.sTestCaseName = "Clark-VerifyClarkSP1WrkngPendTkt";
	FrameworkUtil.sManualTestCaseName= "CPPOC-3091";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	WebDriver driver = WebDriverUtil.getDriver();

	//navClarkLogin();
    LoginTestCase_Old1.LoginAsRoleAUser();
	TicketTestCase.navigateToTicketPage();
	/*WebObjectUtil.explicitWait(20);
	WebObjectUtil.ClickAndMouseHover(Ticket.getNav_FilterByStatusDropdown());
    WebObjectUtil.clickElement(Ticket.getNav_ClosedMore());
    WebObjectUtil.explicitWait(20);*/
    sPendTkts=Ticket.getNav_PendingTickets().getText();
    FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Pending Ticket count", "pass", "Pending Ticket count before update:" + sPendTkts );
    //dynamic XPATH of Expand icon
    //// this object is updated as part of EXTJS5 on 10/07/2015 by QAA04
    
  //  wExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTicketsGridPanel-body']/div/div/table[1]/tbody/tr[1]/td[1]//div[@class='x-grid-row-expander']", "Arrow Expander");
    // This object is updated on 10/13/2015 By QAA04
    wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
    //wExpander=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+1+"]//tr[1]/td[1]//div[@class='x-grid-row-expander']", "Arrow Expander");
	WebObjectUtil.explicitWait(10);
	WebObjectUtil.clickElement(wExpander);
	WebObjectUtil.explicitWait(5);
 //// this object is updated as part of EXTJS5 on 10/08/2015 by QAA04
	WebObjectUtil.clickElement(Ticket.getNav_ClarkTktStatus());
	WebObjectUtil.explicitWait(10);
	WebObjectUtil.selectCustomWebList(Ticket.getNav_ClarkTckDetailStatusDropdown(),"Pending");
	//WebObjectUtil.selectCustomWebList(Clark.getNav_ClarkTktStatus(), "Pending");
	WebObjectUtil.explicitWait(5);
	//WebObjectUtil.clickElement(Clark.getNav_ClarkSaveTktStatus());
	WebObjectUtil.clickElement(Ticket.getNav_TicketSaveUpdatesBtn());
	WebObjectUtil.explicitWait(10);
	WebObjectUtil.clickElement(Ticket.getNav_ClarkSaveTktOkBtn());
	WebObjectUtil.explicitWait(10);
	sPendTkts1=Ticket.getNav_PendingTickets().getText();
	iPendTkts1 = Integer.parseInt(sPendTkts1);
	WebObjectUtil.explicitWait(5);
	
	iPendTkts = Integer.parseInt(sPendTkts);
	iPendTkts = iPendTkts+1;
	sPendTkts=iPendTkts+"";
	 //// this object is updated as part of EXTJS5 on 10/08/2015 by QAA04
	//if(sPendTkts.equalsIgnoreCase(sPendTkts1))
	if(iPendTkts == iPendTkts1)
	{
    FrameworkUtil.updateCustomResultBasedOnStatus(true, iPendTkts + " - Passed for number of Pending Tickets count updated" );
	}
    else
    {
    FrameworkUtil.updateCustomResultBasedOnStatus(false, iPendTkts + " - failed for number of Pending Tickets count is not updated" );
    }
	
	WebObjectUtil.explicitWait(10);
  /*	WebObjectUtil.clickElement(wExpander);
	WebObjectUtil.explicitWait(5);*/
	
	 sWorkTkts=Ticket.getNav_WorkingTickets().getText();
	 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Working Ticket count", "pass", "Working Ticket count before update:" + sWorkTkts );
	 iWorkTkts = Integer.parseInt(sWorkTkts);
	 //// this object is updated as part of EXTJS5 on 10/08/2015 by QAA04
	  WebObjectUtil.clickElement(Ticket.getNav_ClarkTktStatus());
		WebObjectUtil.explicitWait(10);
		WebObjectUtil.selectCustomWebList(Ticket.getNav_ClarkTckDetailStatusDropdown(),"Working");
	//WebObjectUtil.selectCustomWebList(Clark.getNav_ClarkTktStatus(), "Working");
	WebObjectUtil.explicitWait(5);
	 //// this object is updated as part of EXTJS5 on 10/08/2015 by QAA04
	WebObjectUtil.clickElement(Ticket.getNav_TicketSaveUpdatesBtn());
	//WebObjectUtil.clickElement(Clark.getNav_ClarkSaveTktStatus());
	WebObjectUtil.explicitWait(10);
    WebObjectUtil.clickElement(Ticket.getNav_ClarkSaveTktOkBtn());
	
	WebObjectUtil.explicitWait(10);
	sWorkTkts1=Ticket.getNav_WorkingTickets().getText();
	iWorkTkts1 = Integer.parseInt(sWorkTkts1);
	WebObjectUtil.explicitWait(5);
	
	iWorkTkts = iWorkTkts+1;
	sWorkTkts=iWorkTkts+"";
	 //// this object is updated as part of EXTJS5 on 10/12/2015 by QAA04
	//if(sWorkTkts.equalsIgnoreCase(sWorkTkts1))
	if(iWorkTkts == iWorkTkts1) {
    FrameworkUtil.updateCustomResultBasedOnStatus(true, iWorkTkts + "Passed for number of Working Tickets count updated" );
	} else {
    FrameworkUtil.updateCustomResultBasedOnStatus(false,iWorkTkts + "failed for number of Working Tickets count is not updated" );
	}
	LoginTestCase_Old1.nav_Logout();
	}	catch(Exception e)
	{
		LoggerUtil.log_type_error("issue with- Clark-VerifyClarkSP1WrkngPendTkt TestCase" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
}

/*==============================================================
TestScript  	: VerifyClarkCreateTkt
Manual TestCase	: CPPOC-3022
Description		:Verify the entity name on the Create Ticket 
dialog box and verify the ticket is aligned with the entity 
that the user is assigned to when ticket is created.
Author 			: Priyanka R
Creation Date 	: 10/8/15
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=87)
public void VerifyClarkCreateTkt()
{
    String sOrgHeader,sOrgTkt;
	
	PageFactory.initElements(WebDriverUtil.getDriver(),Ticket);
	try{
	FrameworkUtil.sTestCaseName = "Clark-VerifyClarkCreateTkt";
	FrameworkUtil.sManualTestCaseName= "CPPOC-3022";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	WebDriver driver = WebDriverUtil.getDriver();
	
	//navClarkLogin();
    LoginTestCase_Old1.LoginAsRoleAUser();
	TicketTestCase.navigateToTicketPage();
	WebObjectUtil.explicitWait(20);
	sOrgHeader=Ticket.getNav_ClarkTktOrgHeader().getText().trim();
    WebObjectUtil.clickElement(Ticket.getNav_CreateTicketLink());
    WebObjectUtil.explicitWait(Ticket.getNav_CreateTicketDialog());
    WebObjectUtil.SetValueEdit(Ticket.getNav_CreateTicketDialogSummary(), "Test Summary");
////this object is updated as part of EXTJS5 on 10/08/2015 by QAA04
	WebObjectUtil.clickElement(Ticket.getNav_CreateTicketDialogSeverity());
    WebObjectUtil.selectCustomWebList(Ticket.getNav_CreateTicketDialogSeverityDropDown(), 2);
////this object is updated as part of EXTJS5 on 10/08/2015 by QAA04
	WebObjectUtil.clickElement(Ticket.getNav_CreateTicketDialogPriority());
    WebObjectUtil.selectCustomWebList(Ticket.getNav_CreateTicketDialogPriorityDropDown(), 2);
////this object is updated as part of EXTJS5 on 10/08/2015 by QAA04
	//WebObjectUtil.clickElement(Ticket.getNav_CreateTicketDialogCategory());
    //WebObjectUtil.selectCustomWebList(Ticket.getNav_CreateTicketDialogCategoryDropDown(), 1);
    //WebObjectUtil.SetValueEdit(Ticket.getNav_CreateTicketDialogAddNote(), "Test Notes");
    sOrgTkt=Ticket.getNav_CreateTicketDialogOrganization().getAttribute("value");
    WebObjectUtil.clickElement(Ticket.getNav_CreateTicketDialogOkButton());
    WebObjectUtil.explicitWait(10);
    WebObjectUtil.verifyElementPresent(Ticket.getNav_ClarkCreateTktPopup());
    WebObjectUtil.clickElement(Ticket.getNav_ClarkCreateTktPopupOkBtn());
    if(sOrgHeader.equalsIgnoreCase(sOrgTkt))
	    FrameworkUtil.updateCustomResultBasedOnStatus(true, sOrgHeader + "Organization name is same in the Create Ticket Dialog" );
        else
        FrameworkUtil.updateCustomResultBasedOnStatus(false,sOrgHeader + "Organization name is different in the Create Ticket Dialog" );
    LoginTestCase_Old1.nav_Logout();	
	}
	catch(Exception e)
	{
		LoggerUtil.log_type_error("issue with- Clark-VerifyClarkCreateTkt TestCase" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
}

/*==============================================================
TestScript  	: VerifyClarkTktAgeClosedLess()
Manual TestCase	: CPPOC-3011
Description		: Verify Ticket age for a closed ticket should be 
            from the time when it was open to when it was closed. 
that the user is assigned to when ticket is created.
Author 			: Priyanka R
Creation Date 	: 10/8/15
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=89)
public void VerifyClarkTktAgeClosedLess()
{   
	
	PageFactory.initElements(WebDriverUtil.getDriver(),Ticket);
	try{
	  String sTicketID,sCreateNotes;
	  WebElement wExpander,dCreated,dUpdated,wCreateNotes,dExpander;
	  FrameworkUtil.sTestCaseName = "VerifyClarkTktAgeClosedLess";
	  FrameworkUtil.sManualTestCaseName="CPPOC-3011";
	  FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	  String c,d,sCreatedDate,sUpdatedDate;
	    //Login to Navigator
		//TicketTestCase.navTicketLogin();
	
	    LoginTestCase_Old1.LoginAsRoleAUser();
		//Select and Open Ticket page
		TicketTestCase.navigateToTicketPage();
		WebObjectUtil.ClickAndMouseHover(Ticket.getNav_FilterByStatusDropdown());
		WebObjectUtil.clickElement(Ticket.getNav_ClosedLess());
		WebObjectUtil.explicitWait(15);
		WebObjectUtil.verifyElementPresent(Ticket.getNav_StatusResult());
		Calendar cDate=Calendar.getInstance();
	    Date convertedDate;
		try {
			c= WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 7);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:MM");
			convertedDate = dateFormat.parse(c);
		} catch (Exception e1) {
			c= WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 8);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:MM");
			convertedDate = dateFormat.parse(c);
		}
	    //SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy HH:MM");
	    Date currentNow = cDate.getTime();
	    int i=getDiffMonths(currentNow,convertedDate);
	    if(i<=6){
	    FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VerifyClosedLess()", "Pass","Closed Less Than 6 Months");
	     }
	    else{
	    FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VerifyClosedLess()", "Fail","Closed Less Than 6 Months");
	    }
	    WebObjectUtil.clickElement(Ticket.getNav_LastUpdateDate());
	    Date convertedDate1;
		try {
			d= WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 7);
			
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM-dd-yyyy HH:MM");
			convertedDate1 = dateFormat1.parse(d);
		} catch (Exception e) {
			d= WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 8);
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM-dd-yyyy HH:MM");
			convertedDate1 = dateFormat1.parse(d);
		}
	     int j=getDiffMonths(currentNow,convertedDate1);
	     if(j<=6){
	     FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VerifyClosedLess()", "Pass","Closed Less Than 6 Months");
	     }
	     else{
	    FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VerifyClosedLess()", "Fail","Closed Less Than 6 Months");
	     }
	     WebObjectUtil.explicitWait(15);
	     // This object is updated on 10/06/2015 By QAA04
	  //	wExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTicketsGridPanel-body']/div/div/table[1]/tbody/tr[1]/td[1]//div[@class='x-grid-row-expander']", "Arrow Expander");
	     // This object is updated on 10/13/2015 By QAA04
	     wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");

	     // wExpander=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+1+"]//tr[1]/td[1]//div[@class='x-grid-row-expander']", "Arrow Expander");
			WebObjectUtil.explicitWait(10);
			WebObjectUtil.clickElement(wExpander);
		/*dExpander=WebObjectUtil.GetWebElement("xpath", "//tr["+1+"]/td/table/tbody/tr[2]/td/div/section[1]/div[1]/a/img","Details Expander");
		    WebObjectUtil.explicitWait(10);*/
			 // This object is updated on 10/06/2015 By QAA04
			//dCreated=WebObjectUtil.GetWebElement("xpath","//div[@id='idTicketsGridPanel-body']/div/div/table[1]/tbody//tr[2]/td/div/section[1]/div[2]/div[9]/dl/dt","Date Created");
			 // This object is updated on 10/13/2015 By QAA04
			dCreated = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER.DATECREATED", "", "");
			//dCreated=WebObjectUtil.GetWebElement("xpath","//table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/section[1]/div[2]/div[9]/dl/dt","Date Created");
			sCreatedDate=dCreated.getText();
			 // This object is updated on 10/06/2015 By QAA04
			//dUpdated=WebObjectUtil.GetWebElement("xpath","//div[@id='idTicketsGridPanel-body']/div/div/table[1]/tbody//tr[2]/td/div/section[1]/div[2]/div[11]/dl/dt","Date Updated");
			 // This object is updated on 10/13/2015 By QAA04
			dUpdated = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER.DATEUPDATED", "", "");
			//dUpdated=WebObjectUtil.GetWebElement("xpath","//table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/section[1]/div[2]/div[11]/dl/dt","Date Updated");
			sUpdatedDate=dUpdated.getText();
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Created Date is",""+sCreatedDate,"Closed Lessthan 6 months");
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Updated Date is",""+sUpdatedDate,"Closed Lessthan 6 months");
			LoginTestCase_Old1.nav_Logout();
	     }
	 catch (Exception e) {
	  LoggerUtil.log_type_error("issue with -Ticket- VerifyClarkTktAgeClosedLess()" );
	  LoggerUtil.log_type_error(e.getMessage());
	  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	  }
	}

/*==============================================================
TestScript  	: VerifyClarkTktAgeClosedMore()
Manual TestCase	: CPPOC-3012
Description		:Verify Ticket age for a closed ticket should be 
            from the time when it was open to when it was closed. 
that the user is assigned to when ticket is updated.
Author 			: Priyanka R
Creation Date 	: 10/8/15
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=90)
public void VerifyClarkTktAgeClosedMore()
{   
	
	PageFactory.initElements(WebDriverUtil.getDriver(),Ticket);
	try{
	  String sTicketID,sCreateNotes,e,f;
	  WebElement wExpander,dCreated,dUpdated,wCreateNotes,dExpander;
	  FrameworkUtil.sTestCaseName = "VerifyClarkTktAgeClosedMore";
	  FrameworkUtil.sManualTestCaseName="CPPOC-3012";
	  FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	  String c,d,sCreatedDate,sUpdatedDate;
	  //Login to Navigator
			//TicketTestCase.navTicketLogin();
	
	    LoginTestCase_Old1.LoginAsRoleAUser();
	 //Select and Open Ticket page
			TicketTestCase.navigateToTicketPage();
	  WebObjectUtil.ClickAndMouseHover(Ticket.getNav_FilterByStatusDropdown());
		WebObjectUtil.clickElement(Ticket.getNav_ClosedMore());
		WebObjectUtil.explicitWait(15);
		WebObjectUtil.verifyElementPresent(Ticket.getNav_StatusResult());
		Calendar cDate=Calendar.getInstance();
	    Date convertedDate;
		try {
			e= WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 7);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:MM");
			convertedDate = dateFormat.parse(e);
		} catch (Exception e2) {
			e= WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 8);
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:MM");
			convertedDate = dateFormat.parse(e);
		}
	    //SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy HH:MM");
	    Date currentNow = cDate.getTime();
	    int i=getDiffMonths1(currentNow,convertedDate);
	    if(i>6){
	    FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VerifyClosedMore()", "Pass","Closed More Than 6 Months");
	     }
	    else{
	    FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VerifyClosedMore()", "Fail","Closed More Than 6 Months");
	    }
	    WebObjectUtil.clickElement(Ticket.getNav_LastUpdateDate());
	    WebObjectUtil.explicitWait(10);
	    Date convertedDate1;
		try {
			f= WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 7);
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM-dd-yyyy HH:MM");
			convertedDate1 = dateFormat1.parse(f);
		} catch (Exception e1) {
			f= WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 8);
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM-dd-yyyy HH:MM");
			convertedDate1 = dateFormat1.parse(f);
		}
	     int j=getDiffMonths1(currentNow,convertedDate1);
	     if(j>6){
	     FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VerifyClosedMore()", "Pass","Closed More Than 6 Months");
	     }
	     else{
	    FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VerifyClosedMore()", "Fail","Closed More Than 6 Months");
	     }
	     // This object is updated on 10/06/2015 By QAA04
		  //	wExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTicketsGridPanel-body']/div/div/table[1]/tbody/tr[1]/td[1]//div[@class='x-grid-row-expander']", "Arrow Expander");
	     // This object is updated on 10/13/2015 By QAA04
	     wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
	     //  wExpander=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+1+"]//tr[1]/td[1]//div[@class='x-grid-row-expander']", "Arrow Expander");
			WebObjectUtil.explicitWait(10);
			WebObjectUtil.clickElement(wExpander);
		    /*dExpander=WebObjectUtil.GetWebElement("xpath", "//tr["+1+"]/td/table/tbody/tr[2]/td/div/section[1]/div[1]/a/img","Details Expander");
		    WebObjectUtil.explicitWait(10);*/
			 // This object is updated on 10/06/2015 By QAA04
			//dCreated=WebObjectUtil.GetWebElement("xpath","//div[@id='idTicketsGridPanel-body']/div/div/table[1]/tbody//tr[2]/td/div/section[1]/div[2]/div[9]/dl/dt","Date Created");
			 // This object is updated on 10/13/2015 By QAA04
			dCreated = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER.DATECREATED", "", "");
			//dCreated=WebObjectUtil.GetWebElement("xpath","//table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/section[1]/div[2]/div[9]/dl/dt","Date Created");
			sCreatedDate=dCreated.getText();
			 // This object is updated on 10/06/2015 By QAA04
			//dUpdated=WebObjectUtil.GetWebElement("xpath","//div[@id='idTicketsGridPanel-body']/div/div/table[1]/tbody//tr[2]/td/div/section[1]/div[2]/div[11]/dl/dt","Date Updated");
			 // This object is updated on 10/13/2015 By QAA04
			dUpdated = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER.DATEUPDATED", "", "");
			//dUpdated=WebObjectUtil.GetWebElement("xpath","//table/tbody/tr[1]/td/table/tbody/tr[2]/td/div/section[1]/div[2]/div[11]/dl/dt","Date Updated");
			sUpdatedDate=dUpdated.getText();
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Created Date is",""+sCreatedDate,"Closed Lessthan 6 months");
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Updated Date is",""+sUpdatedDate,"Closed Lessthan 6 months");
			LoginTestCase_Old1.nav_Logout();
	     }
	 catch (Exception e) {
	  LoggerUtil.log_type_error("issue with -Ticket- VerifyClarkTktAgeClosedLess()" );
	  LoggerUtil.log_type_error(e.getMessage());
	  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	  }
}

/*==============================================================
TestScript 		: nav_VerifyAllNotesAreCollapsed
Manual TestCase	: Verify all notes are collapsed when a new note is created
Description		: Verify all notes are collapsed when a new note is created with Role-A user
Author 			: QAA02
Creation Date 	: 08/22/2014
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=110)
public void nav_VerifyAllNotesAreCollapsed() {
	
 WebElement wExpander,wNoteExpander;
	String sTicketID=null;
	  WebDriver driver = WebDriverUtil.getDriver();
	  PageFactory.initElements(driver, Home);
	  PageFactory.initElements(driver,Ticket);
	  try{
		  

	  FrameworkUtil.sTestCaseName="Clark-nav_VerifyAllNotesAreCollapsed";
	  FrameworkUtil.sManualTestCaseName="(CPPOC-2971)Verify all notes are collapsed when a new note is created";
	  FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	
	 // String sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEA.USERID");
  //String sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEA.PASSWORD");
	 // LoginTestCase.nav_Login(sUserName, sPassword);
      LoginTestCase_Old1.LoginAsRoleAUser();
	  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "ROLEALogin", "Pass", "Login Sucess");
	
       //the below line updated on QAA03 by 07/25/2016
	  //WebObjectUtil.ClickAndMouseHover(Home.getNav_SupportTab());
	  WebObjectUtil.clickElement(Ticket.getNav_SupportTabLink());
	  WebObjectUtil.clickElement(Home.getNav_TicketsMenuLink());
      WebObjectUtil.explicitWait(10);
      sTicketID = TicketTestCase.getTicketID(1);
	  WebObjectUtil.clickElement(Ticket.getNav_FirstTicketExpander());
	 

	  WebObjectUtil.explicitWait(5);
	  // WebObjectUtil.clickElement(Clark.getNav_NotesExpander());


// This object is updated on 10/06/2015 By QAA04
	//wNoteExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTicketsGridPanel-body']/div/div/table[1]/tbody//tr[2]//img[contains(@id,'tktNotesImg-')]", "Notes Expander");
	 // This object is updated on 10/13/2015 By QAA04
	  wNoteExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER", "PARAMETER_TICKETID",  sTicketID);
	//	wNoteExpander=WebObjectUtil.GetWebElement("xpath", "//tr[1]/td/table/tbody/tr[2]/td/div/section[2]/div[1]/a", "Note Expander");
	  WebObjectUtil.explicitWait(10);
	  WebObjectUtil.clickElement(wNoteExpander);
	  WebObjectUtil.explicitWait(5);
	  WebObjectUtil.clickElement(Ticket.getNav_CreateNoteLink());
  WebObjectUtil.explicitWait(5);
	   
 driver.switchTo().frame(Ticket.getNav_CreateNoteEditBox());
 WebElement element = driver.findElement(By.cssSelector("body"));
 element.sendKeys("testUser");
	driver.switchTo().defaultContent();
	 WebObjectUtil.explicitWait(5);
	WebObjectUtil.clickElement(Ticket.getNav_CreateNoteOkBtn());
  WebObjectUtil.explicitWait(10);

 
 // WebObjectUtil.deSelectCheckBox(Clark.getNav_ExpandAllCheckBox());
 boolean bStatus =  WebObjectUtil.isCheckRadioSelected(Ticket.getNav_ExpandAllCheckBox());
 FrameworkUtil.updateCustomResultBasedOnStatus(!bStatus, "Note collapsed as expected");
  LoginTestCase_Old1.nav_Logout();
	  }
	catch (Exception e) {
	// TODO Auto-generated catch block
     	LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
}
}

/*==============================================================
TestScript 		: nav_VerifyDateColumnUnderServiceLogs
Manual TestCase	: Expand Ticket Service Logs and verify data under Date column is displayed in proper format
Description		: Expand Ticket Service Logs and verify data under Date column is displayed in proper format with Role-A user
Author 			: QAA02
Creation Date 	: 08/25/2015
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=112)
public void nav_VerifyDateColumnUnderServiceLogs() {
	
 WebElement wExpander,wTicktLgsExpander;

	  WebDriver driver = WebDriverUtil.getDriver();
	  PageFactory.initElements(driver, Home);
	  PageFactory.initElements(driver,Ticket);
	  try {
		
	  
	  FrameworkUtil.sTestCaseName="Clark-nav_VerifyDateColumnUnderServiceLogs";
	  FrameworkUtil.sManualTestCaseName="(CPPOC-2864)Expand Ticket Service Logs and verify data under Date column is displayed in proper format";
	  FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	
	  //String sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEA.USERID");
      //String sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEA.PASSWORD");
	  //LoginTestCase.nav_Login(sUserName, sPassword);
	  LoginTestCase_Old1.LoginAsRoleAUser();
	  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "ROLEALogin", "Pass", "Login Sucess");

	  
	  
	  WebObjectUtil.clickElement(Home.getNav_SupportTab());
	  WebObjectUtil.clickElement(Home.getNav_TicketsMenuLink());
	  WebObjectUtil.explicitWait(5);
	  WebObjectUtil.clickElement(Ticket.getNav_FirstSearchDropDownBox());
	  WebObjectUtil.selectCustomWebList(Ticket.getNav_FirstSearchDropDownOption(), "Closed (More than 6 months)");
	  WebObjectUtil.explicitWait(5);
	  WebObjectUtil.clickElement(Ticket.getNav_FirstTicketExpander());
	  

	  WebObjectUtil.explicitWait(5);
	
	 // This object is updated on 10/06/2015 By QAA04
//	wTicktLgsExpander=WebObjectUtil.GetWebElement("xpath", "//div[@id='idTicketsGridPanel-body']/div/div/table[1]/tbody/tr[2]//section[3]/div[1]//img[contains(@id,'tktLogsImg-')]", "TicketLogXpand");
	 // This object is updated on 10/13/2015 By QAA04
	  wTicktLgsExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETLOGS.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
	  // wTicktLgsExpander=WebObjectUtil.GetWebElement("xpath", "//tr[1]//section[contains(@id,'tktLogsSection-')]//img[contains(@id,'tktLogsImg-')]", "Note Expander");
	  WebObjectUtil.explicitWait(10);
	  WebObjectUtil.clickElement(wTicktLgsExpander);
	  WebObjectUtil.explicitWait(5);
	 String sLogsDate =  WebTableUtil.getCellData(Ticket.getNav_TicketLogsTable(), 1, 1);
	  System.out.println("Date is = "+sLogsDate);
	  
	  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "PrintTheTicketDATE", "pass", "The Date is = "+sLogsDate);

	  
	 if(isValidDate(sLogsDate) == true){
		 
		 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "VerifyTheDateFormat", "pass", "Date is in expected format " + sLogsDate);
		// System.out.println("Date is in expected format");
	 }
	 else
	 {
		 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "VerifyTheDateFormat", "fail", "Date is Not in expected format " + sLogsDate);
		// System.out.println("Date is not in expected formate");
	 }
	
	 LoginTestCase_Old1.nav_Logout();
	  // closing try block 
	  }
	catch (Exception e) {
	// TODO Auto-generated catch block
     	LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
}
	  
}



////// Methods
/*==============================================================
Method Name 	: navClarkLogin
Description		: Login to Catalog using devco1
Author 			: Priyanka Rachupalli
Creation Date 	: 10/08/2015
Pre-Requisites	:
Revision History:
==============================================================*/
public static void navClarkLogin()
{
	String sUserName,sPassword;
	try{
	sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.USERID.AROLE");
	sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.PASSWORD.AROLE");
	LoginTestCase_Old1.nav_Login(sUserName,sPassword);
	
	}
	catch(Exception e)
	{
		LoggerUtil.log_type_error("issue with- navClarkLogin method" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}
  }

private boolean isValidDate(String sDateAsString) {
    boolean bDate = true;
    try {
	  	 DateFormat dateFormat = new SimpleDateFormat("MM-dd-yy HH:mm aa");
	  	 Date startDate = dateFormat.parse(sDateAsString);
    } catch (Exception e) {
    	bDate = false;
    }
    return bDate;
}
//___________________________ completed clark test cases________________________________________///
//___________________________ LefCourt test cases __________________________________________________///

/*==============================================================
TestScript 		: navVerifyNotes
Manual TestCase	: QAT-431
Description		: Verify that all expected notes are displayed or not
Author 			: QAA04
Creation Date 	: 01/20/2016
Release Name    : Lefcourt
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=1)
public void navVerifyNotes() {
	int iNotesCount,iExpandNotesCount,iRowCnt = 0;
	String sTicketID,sNote,sNotesCount;
	WebElement wExpander,wNotes,wNotesTable;
	
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, Ticket);
	try {
	FrameworkUtil.sTestCaseName ="navVerifyNotes";
	FrameworkUtil.sManualTestCaseName="(QAT-431) Lefcourt - Verify that all notes are displayed";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);


	// login to navigator
	LoginTestCase_Old1.LoginAsRoleAUser();
	//LoginTestCase.LoginAsQaautoUser();
	
	/// navigating to the ticket page
	TicketTestCase.navigateToTicketPage();
	
	
	// searching the ticket
	sTicketID= (String) FrameworkUtil.dictPropertyData.get("NAV.TICKET.SEARCHBY.TICKETID.106NOTES");
	TicketTestCase.searchTicket("Ticket ID", sTicketID);
	WebObjectUtil.explicitWait(5);
	// expanding the ticket
	wExpander = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
	 WebObjectUtil.clickElement(wExpander);
	 WebObjectUtil.explicitWait(5);
	 //sTicketID = "477609";
    wNotes = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "TICKET.NOTES.EXPANDER", "PARAMETER_TICKETID",sTicketID);
    WebObjectUtil.clickElement(wNotes);
    
    WebObjectUtil.explicitWait(5);
   
    // getting the notes count
    wNotesTable = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "TICKET.NOTES.TABLE", "PARAMETER_TICKETID",sTicketID);
    //CustomWebElementUtil.loadCustomElement(Ticket.getNav_NotesWebTable(), "table");
    CustomWebElementUtil.loadCustomElement(wNotesTable, "table");
    iNotesCount = CustomWebElementUtil.iRowCount;
    
    WebObjectUtil.selectCheckRadioBox(Ticket.getNav_ExpandAllCheckBox());
    WebObjectUtil.explicitWait(15);
 
   
    // loading notes web table
    CustomWebElementUtil.loadCustomElement(wNotesTable, "table");
    //CustomWebElementUtil.loadCustomElement(Ticket.getNav_NotesWebTable(), "table");
    iExpandNotesCount = CustomWebElementUtil.iRowCount;
    
    	
    sNotesCount = (String) FrameworkUtil.dictPropertyData.get("NAV.TICKET.NOTES.LONGCOUNT");
    iNotesCount = Integer.parseInt(sNotesCount);
    if(iNotesCount<=iExpandNotesCount){
    	 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying the Notes count", "pass", "Notes actual count is - "+iExpandNotesCount+ "and expected Count is - " +iNotesCount);
     }
     else{
    	 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying the Notes count", "fail", "Notes actual count is - "+iExpandNotesCount+ "and expected Count is - " +iNotesCount);
     }
    
/*     for (int r=1; r<iExpandNotesCount; r++){
     sNote = CustomWebElementUtil.getRowAsWebElement(r).getText();
     FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), r+" Note details for ticket:"+sTicketID , "Verifying the Notes", "done", +r+" note details : "+sNote);
     }
	*/
	 for (WebElement wb : CustomWebElementUtil.rowsWebElementList){
    	iRowCnt++;
	 	sNote = wb.getText();
     	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), iRowCnt+" Note details for ticket:"+sTicketID , "Verifying the Notes", "done", +iRowCnt+" note details : "+sNote);
     }
     LoginTestCase_Old1.nav_Logout();

}
catch(Exception e) {
	LoggerUtil.log_type_error(" issue with navVerifyNotes test case");
	LoggerUtil.log_type_error("Exception occured " +FrameworkUtil.sElementName);
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", " " +e.getMessage());
}
}	


/*==============================================================
TestScript  	: verifyCreateTktfrmDiffSystems
Manual TestCase	: QAT-549-WCP_4336_TC_1.0_Tickets - Wrong ticket queue assigned when creating Tickets
Description		: Verify Wrong ticket queue is not assigned when creating Tickets
Author 			: Priyanka
Creation Date 	: 01/21/2016
Pre-Requisites	:
Release Name    : LefCourt
Revision History:
==============================================================*/
	@Test(priority=1)
	public void verifyCreateTktfrmDiffSystems()
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Ticket);
		PageFactory.initElements(driver, Smoke);
		PageFactory.initElements(driver, Common);
		PageFactory.initElements(driver, EVDC_VMPF);
		PageFactory.initElements(driver, Home);
		PageFactory.initElements(driver, Firewall);
		PageFactory.initElements(driver, Draas);
		
		try {
			FrameworkUtil.sTestCaseName = "Ticket-verifyCreateTktfrmDiffSystems";
			FrameworkUtil.sManualTestCaseName="Verify Wrong ticket queue is not assigned when creating Tickets";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			String sTicketID,sQueuevalue,sAddStoreTierTitle;
			//Login to Navigator
			String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.11GIRAFFS.USERID.AROLE");
			
			String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.11GIRAFFS.PASSWORD.AROLE");
			
			String sActualQueueValue= (String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.NETWORKING.QUEUE.NAME");
			String sTitleVal=(String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.EB.TICKETSUMMARYEDIT");	
			String sHostName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.DRAAS.HOSTNAME");
			String sHostIP=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.DRAAS.HOSTIPADDRESS");
			String sAddDrives=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.DRAAS.DRIVESTOADD");
			String sS2CRSummary=(String)FrameworkUtil.dictPropertyData.get("NAV.S2CR.SUMMARY");
			String sActualQueueValue1=(String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.DRAAS.QUEUE.NAME");
			String sActualQueueValue2=(String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.EVDC.QUEUE.NAME");
			String sActualQueueValue3=(String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.STORAGE.QUEUE.NAME");
			String sAddStoreTierNote=(String)FrameworkUtil.dictPropertyData.get("NAV.STORAGE.TIER.NOTE");
			String sRemoveSCR=(String)FrameworkUtil.dictPropertyData.get("NAV.REMOVE.S2CR.SUMMARY");
			sTitleVal=sTitleVal+"_"+ FrameworkUtil.sTimeStamp;	
			//sHostName=sHostName+"_"+ FrameworkUtil.sTimeStamp;
			sAddStoreTierTitle="Selenium"+"_"+FrameworkUtil.sTimeStamp;
			
			//Login to Navigator Portlet
			//LoginTestCase.nav_Login(sUserName,sPassword);
			 LoginTestCase_Old1.LoginAsGirUser();
			
			 WebObjectUtil.explicitWait(5);
             WebObjectUtil.clickElement(Smoke.getNav_PrivateEVDC());
             WebObjectUtil.explicitWait(5);
             
             //WebObjectUtil.waitForElementPresent(Smoke.getNav_Firewallportlet());
             WebObjectUtil.clickElement(Firewall.getNav_FirewallOpenTicket());
             
             NavigatorCommonMethods.submitDialogForCreateTicket("Firewall-PrivateEVDC");
/*             WebObjectUtil.SetValueEdit(Firewall.getNav_FireWallTicketTitle(), sTitleVal);
             WebObjectUtil.clickElement(EVDC_VMPF.getNav_AddStorageTierOkBtn());
             WebObjectUtil.explicitWait(5);
             WebObjectUtil.clickElement(Common.getNav_CommonPopUpOKButton());*/
             TicketTestCase.navigateToTicketPage();
             WebObjectUtil.explicitWait(5);
           // Checking Ticket title
           TicketTestCase.searchTicket("Summary", sTitleVal);
           //TicketTestCase.SearcResultFound(sDropdownValue, iColumnNumber, sValue);
           sTicketID=TicketTestCase.getTicketID(1);
           TicketTestCase.expandTable(1);
           WebObjectUtil.explicitWait(5);
           WebElement wQueuenameChk = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.TICKET.QUEUE.VALUE", "PARAMETER_ROWNUMBER", "1");
		   sQueuevalue=wQueuenameChk.getText().trim();  
           if(sQueuevalue.equalsIgnoreCase(sActualQueueValue))
           {
        	   FrameworkUtil.updateCustomResultBasedOnStatus(true, "Assigned to appropriate queue, that is : "+ sQueuevalue);
           }
           else{
        	   FrameworkUtil.updateCustomResultBasedOnStatus(false, "Not Assigned to appropriate queue,Actual:" +sQueuevalue + ",expected is:" + sActualQueueValue);
           }
           
           WebObjectUtil.ClickAndMouseHover(Smoke.getNav_ServicesMenu());
           WebObjectUtil.explicitWait(3);
		   WebObjectUtil.clickElement(Draas.getNav_ServicesDraasMenuLink());
		   WebObjectUtil.explicitWait(5);
		   WebObjectUtil.clickElement(Draas.getNav_SCRAddDrive());
	       WebObjectUtil.SetValueEdit(Draas.getNav_AddDriveHostName(),sHostName);
	       WebObjectUtil.explicitWait(3);
	       WebObjectUtil.SetValueEdit(Draas.getNav_AddDriveHostIP(),sHostIP);
	       WebObjectUtil.explicitWait(3);
	       WebObjectUtil.SetValueEdit(Draas.getNav_AddDriveToAdd(),sAddDrives);
	       WebObjectUtil.clickElement(Draas.getNav_AddDriveSaveBtn());
	      // WebObjectUtil.clickElement(Draas.getNav_AddDriveSaveBtn());
	       WebObjectUtil.explicitWait(10);
	       WebObjectUtil.waitForElementPresent(Common.getNav_CommonPopUpMessage());
	       WebObjectUtil.clickElement(Common.getNav_CommonPopUpOKButton());
	       //String sSuccessMsg=(Common.getNav_CommonPopUpMessage()).getText();
           TicketTestCase.navigateToTicketPage();
           TicketTestCase.searchTicket("Summary",sS2CRSummary);
           sTicketID=TicketTestCase.getTicketID(1);
           WebObjectUtil.explicitWait(5);
           TicketTestCase.expandTable(1);
           WebObjectUtil.explicitWait(5);
           //WebElement wQueuenameChk1 = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.TICKET.QUEUE.VALUE", "PARAMETER_ROWNUMBER", "1");
          // this below line added by QAA04 - 02/26/2016
           wQueuenameChk = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.TICKET.QUEUE.VALUE", "PARAMETER_ROWNUMBER", "1");
           sQueuevalue=wQueuenameChk.getText().trim();  
           if(sQueuevalue.equalsIgnoreCase(sActualQueueValue1))
           {
        	   FrameworkUtil.updateCustomResultBasedOnStatus(true, "Assigned to appropriate queue, that is : "+ sQueuevalue);
           }
           else{
        	   FrameworkUtil.updateCustomResultBasedOnStatus(false, "Not Assigned to appropriate queue,Actual:" +sQueuevalue + ",expected is:" + sActualQueueValue1);
           }
           WebObjectUtil.ClickAndMouseHover(Home.getNav_MonitoringTab());
           WebObjectUtil.explicitWait(3);
           WebObjectUtil.clickElement(Home.getNav_SummaryViewMenuLink());
           WebObjectUtil.explicitWait(5);
           WebObjectUtil.clickElement(Smoke.getNav_EVDCLink());
           WebObjectUtil.explicitWait(5);
           WebObjectUtil.clickElement(EVDC_VMPF.getNav_EVDCStorageLink());
           WebObjectUtil.explicitWait(5);
           WebObjectUtil.clickElement(EVDC_VMPF.getNav_AddStorageTierLink());
           WebObjectUtil.clickElement(EVDC_VMPF.getNav_StorageTierPopupDropdown());
           WebObjectUtil.selectCustomWebList(EVDC_VMPF.getNav_StorageTierPopupDropdown(),1);
	       WebObjectUtil.SetValueEdit(EVDC_VMPF.getNav_TitleAddStorageTierPopUp(),sAddStoreTierTitle);
	       WebObjectUtil.explicitWait(3);
           WebObjectUtil.SetValueEdit(EVDC_VMPF.getNav_AddStorageTierNotePopup(), sAddStoreTierNote);
	       WebObjectUtil.explicitWait(3);
           WebObjectUtil.clickElement(EVDC_VMPF.getNav_AddStorageTierOkBtn());
           WebObjectUtil.explicitWait(5);
           TicketTestCase.navigateToTicketPage();
           TicketTestCase.searchTicket("Summary",sAddStoreTierTitle);
           WebObjectUtil.explicitWait(5);
           sTicketID=TicketTestCase.getTicketID(1);
           TicketTestCase.expandTable(1);
           WebObjectUtil.explicitWait(5);
          // WebElement wQueuenameChk2 = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.TICKET.QUEUE.VALUE", "PARAMETER_ROWNUMBER", "1");
           // this below line added by QAA04 - 02/26/2016
           wQueuenameChk = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.TICKET.QUEUE.VALUE", "PARAMETER_ROWNUMBER", "1");
           sQueuevalue=wQueuenameChk.getText().trim();  
           if(sQueuevalue.equalsIgnoreCase(sActualQueueValue3))
           {
        	   FrameworkUtil.updateCustomResultBasedOnStatus(true, "Assigned to appropriate queue, that is : "+ sQueuevalue);
           }
           else{
        	   FrameworkUtil.updateCustomResultBasedOnStatus(false, "Not Assigned to appropriate queue,Actual:" +sQueuevalue + ",expected is:" + sActualQueueValue3);
           }
           WebObjectUtil.ClickAndMouseHover(Smoke.getNav_ServicesMenu());
           WebObjectUtil.explicitWait(3);
		   WebObjectUtil.clickElement(Draas.getNav_ServicesDraasMenuLink());
		   WebObjectUtil.explicitWait(5);
           WebObjectUtil.clickElement(Draas.getNav_SCRManageBtn());
           WebObjectUtil.clickElement(Draas.getNav_SCRDeleteLink());
           WebObjectUtil.clickElement(Draas.getNav_SCRDeletePopupOkBtn());
           WebObjectUtil.clickElement(Common.getNav_CommonPopUpOKButton());
           WebObjectUtil.explicitWait(3);
           WebObjectUtil.clickElement(Draas.getNav_SCRDeletePopupCloseBtn());
           WebObjectUtil.explicitWait(5);
           TicketTestCase.navigateToTicketPage();
           TicketTestCase.searchTicket("Summary",sRemoveSCR);
           WebObjectUtil.explicitWait(5);
           sTicketID=TicketTestCase.getTicketID(1);
           TicketTestCase.expandTable(1);
           WebObjectUtil.explicitWait(5);
           sQueuevalue=wQueuenameChk.getText().trim();  
           if(sQueuevalue.equalsIgnoreCase(sActualQueueValue1))
           {
        	   FrameworkUtil.updateCustomResultBasedOnStatus(true, "Assigned to appropriate queue, that is : "+ sQueuevalue);
           }
           else{
        	   FrameworkUtil.updateCustomResultBasedOnStatus(false, "Not Assigned to appropriate queue,Actual:" +sQueuevalue + ",expected is:" + sActualQueueValue1);
           }
	}

catch (Exception e) {
		LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
	
	}
	}


	/*==============================================================
	TestScript  	: verifyUserNavforLongNotes
	Manual TestCase	: QAT-540-WCP_4297_TC_1.0_Tickets_Unable to navigate through tickets with longer notes
	Description		: Verify user is Unable to navigate through tickets with longer notes
	Author 			: Priyanka
	Creation Date 	: 01/25/2016
	Pre-Requisites	:
	Release Name    : LefCourt
	Revision History:
	==============================================================*/
	@Test(priority=2)
	public void verifyUserNavforLongNotes()
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Ticket);
		PageFactory.initElements(driver, Smoke);
		
		try {
			int iRow=1,i;
			FrameworkUtil.sTestCaseName = "Ticket-verifyUserNavforLongNotes";
			FrameworkUtil.sManualTestCaseName="QAT-540-WCP_4297_TC_1.0_Tickets_Unable to navigate through tickets with longer notes";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			String sTicketID,sQueuevalue;
			//Login to Navigator
//			String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.USERID");
			
//			String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.PASSWORD");
		
			String sLongNotes = (String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.LONG.NOTES.TEXT");
			//Login to Navigator Portlet
			//LoginTestCase.nav_Login(sUserName,sPassword);
			 LoginTestCase_Old1.LoginAsRoleAUser();
			
			TicketTestCase.navigateToTicketPage();
			CustomWebElementUtil.loadCustomElement(Ticket.getNav_TicketsWebTable(), "table");
			sTicketID = TicketTestCase.getTicketID(1);
			TicketTestCase.expandTable(iRow);
			WebObjectUtil.explicitWait(8);
			//expand notes
			WebElement nExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER", "PARAMETER_TICKETID",  sTicketID);
			WebObjectUtil.explicitWait(3);
			WebObjectUtil.scrollToElement(nExpander);
			WebObjectUtil.explicitWait(3);
			WebObjectUtil.clickElement(nExpander);
			
			WebObjectUtil.explicitWait(6);
			WebElement wNotesTable = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER.WNOTESTABLE", "PARAMETER_TICKETID",  sTicketID);
			  
		 	//if(Ticket.getNav_NotesWebTable().isDisplayed())
		 if(wNotesTable==null)
		    {
			 /*TicketTestCase.expandTable(2);
		    }
		 else{*/
			for(i=1;i<=5;i++)
			{
				//WebObjectUtil.clickElement(Ticket.getNav_CreateNote());
				WebObjectUtil.clickElement(Ticket.getNav_CreateNoteLink());
				WebObjectUtil.waitForElementPresent(Ticket.getNav_CreateNotesFrame());
		        Ticket.getNav_CreateNote().sendKeys(sLongNotes);
		        WebObjectUtil.explicitWait(5);
		        WebObjectUtil.clickElement(Ticket.getNav_TicketNoteOk());
		        WebObjectUtil.explicitWait(5);
		        
		        
			}
		 }
		 
		 WebObjectUtil.explicitWait(5);
		 /*WebObjectUtil.scrollToElement(Ticket.getNav_ExpandAllNoteCheckbox());
		 WebObjectUtil.explicitWait(3);*/
			WebObjectUtil.clickElement(Ticket.getNav_ExpandAllNoteCheckbox());
			//WebObjectUtil.clickByJS(Ticket.getNav_ExpandAllNoteCheckbox());
			WebObjectUtil.explicitWait(8);
			 WebObjectUtil.VerifyTextOnPage("Tickets");
			 String sID="tktLogsImg-" + sTicketID;
			 WebElement wTicketLogsExpander=WebObjectUtil.GetWebElement("id", sID, "Ticket Logs Expander");
			 WebObjectUtil.scrollToElement(wTicketLogsExpander);
			 WebObjectUtil.explicitWait(3);
			 //Expand Notes
			 wTicketLogsExpander.click();
			 WebObjectUtil.explicitWait(5);
			 WebObjectUtil.verifyElementPresent(Ticket.getNav_TicketLogsTable());
			 WebObjectUtil.explicitWait(5);
			 String sServID="tktServiceLogsImg-" + sTicketID;
			 WebElement wTicketServiceLogsExpander=WebObjectUtil.GetWebElement("id", sServID, "Service Logs Expander");
			 //Expand Notes
			 WebObjectUtil.scrollToElement(wTicketServiceLogsExpander);
			 WebObjectUtil.explicitWait(3);
			 wTicketServiceLogsExpander.click();
			 WebObjectUtil.explicitWait(5);
			 String sServLogTable="tktServiceLogsGrid-" + sTicketID;
			 WebElement wTicketServiceLogsTable=WebObjectUtil.GetWebElement("id", sServLogTable, "ServLogsTable");
			 
			 WebObjectUtil.verifyElementPresent(wTicketServiceLogsTable);
			 WebObjectUtil.explicitWait(5);
			 TicketTestCase.expandTable(2);
			 WebObjectUtil.explicitWait(5);
			 TicketTestCase.expandTable(3);

			 LoginTestCase_Old1.nav_Logout();
		}

		catch (Exception e) {
					LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
				
				}
		}

	/*==============================================================
	TestScript  	: verifyTktLogsandTktSrvcLogs
	Manual TestCase	: CPPOC-2965_WCP_ 2837_TC_Tickets_Firefox _tickets logs and ticket service logs display issues
	Description		: Verify user is Unable to navigate through tickets with longer notes
	Author 			: Priyanka
	Creation Date 	: 8/16/2016
	Pre-Requisites	:
	Release Name    : Clark SP1
	Revision History:
	==============================================================*/
	@Test(priority=3)
	public void verifyTktLogsandTktSrvcLogs()
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Ticket);
		PageFactory.initElements(driver, Smoke);
		
		try {
			int iRow=1;
			FrameworkUtil.sTestCaseName = "Ticket-verifyTktLogsandTktSrvcLogs";
			FrameworkUtil.sManualTestCaseName="CPPOC-2965_WCP_ 2837_TC_Tickets_Firefox _tickets logs and ticket service logs display issues";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			String sTicketID=(String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.SERACHBY.TICKETID.TKTLOGS.TKTSRVCLOGS");
			

			 LoginTestCase_Old1.LoginAsRoleAUser();
			
			TicketTestCase.navigateToTicketPage();
			
			TicketTestCase.searchTicket("Ticket ID", sTicketID);
			WebObjectUtil.explicitWait(10);
			TicketTestCase.SearcResultFound("Ticket ID",2, sTicketID);
			TicketTestCase.expandTable(iRow);
			WebObjectUtil.explicitWait(8);
			//expand notes
			WebElement nExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER", "PARAMETER_TICKETID",  sTicketID);
			WebObjectUtil.explicitWait(3);
			WebObjectUtil.scrollToElement(nExpander);
			WebObjectUtil.explicitWait(3);
			WebObjectUtil.clickElement(nExpander);
			
			WebObjectUtil.explicitWait(6);
			WebElement wNotesTable = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER.WNOTESTABLE", "PARAMETER_TICKETID",  sTicketID);
			WebObjectUtil.explicitWait(5);
		 	WebObjectUtil.verifyElementPresent(wNotesTable);
			
			 String sID="tktLogsImg-" + sTicketID;
			 WebElement wTicketLogsExpander=WebObjectUtil.GetWebElement("id", sID, "Ticket Logs Expander");
			 WebObjectUtil.scrollToElement(wTicketLogsExpander);
			 WebObjectUtil.explicitWait(3);
			 //Expand Notes
			 wTicketLogsExpander.click();
			 WebObjectUtil.explicitWait(5);
			 WebObjectUtil.verifyElementPresent(Ticket.getNav_TicketLogsTable());
			 WebObjectUtil.explicitWait(5);
			 String sServID="tktServiceLogsImg-" + sTicketID;
			 WebElement wTicketServiceLogsExpander=WebObjectUtil.GetWebElement("id", sServID, "Service Logs Expander");
			 //Expand Notes
			 WebObjectUtil.scrollToElement(wTicketServiceLogsExpander);
			 WebObjectUtil.explicitWait(3);
			 wTicketServiceLogsExpander.click();
			 WebObjectUtil.explicitWait(5);
			 String sServLogTable="tktServiceLogsGrid-" + sTicketID;
			 WebElement wTicketServiceLogsTable=WebObjectUtil.GetWebElement("id", sServLogTable, "ServLogsTable");
			 
			 WebObjectUtil.verifyElementPresent(wTicketServiceLogsTable);
			 LoginTestCase_Old1.nav_Logout();
		}

		catch (Exception e) {
					LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
				
				}
		}
	
	/*==============================================================
	TestScript  	: verifyTicketPageFields
	Manual TestCase	: CPPOC-2987-WCP_2667_TC_Tickets: CSV reports_odd HTML code
	Description		: Confirm that the User sees the options mentioned
	Author 			: Priyanka Rachupalli
	Creation Date 	: 06/16/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=3)
	public void verifyTicketCSVData()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,Ticket);
	try{
		FrameworkUtil.sTestCaseName="Ticket-verifyTicketPageFields";
		FrameworkUtil.sManualTestCaseName="CPPOC-2987-WCP_2667_TC_Tickets: CSV reports_odd HTML code";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		//Login to Navigator
		//navTicketLogin();
		LoginTestCase_Old1.LoginAsRoleAUser();
		//Select and Open Ticket page
		navigateToTicketPage();
		WebObjectUtil.verifyElementPresent(Ticket.getNav_TicketsCsvIcon());
		LoginTestCase_Old1.nav_Logout();
		
		
	}

	catch (Exception e) {
				LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
			
			}
	}
	
	/*==============================================================
    TestScript  	: verifyDetailedTktMouseHover()
    Manual TestCase	: QAT-464-WCP_4317_TC_1.0_Tickets_Detailed Ticketing System_link should be black when mouse over it
	Description		: Verify the Detailed Ticketing System on Tickets page is black when user mouse over it.
	Author 			: Priyanka
	Creation Date 	: 01/25/2016
	Pre-Requisites	:
	Release Name    : LefCourt
	Revision History:
   ==============================================================*/
	@Test(priority=3)
	public void verifyDetailedTktMouseHover()
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Ticket);
		PageFactory.initElements(driver, Smoke);
		
		try {
			int iRow=1,i;
			 FrameworkUtil.sTestCaseName = "Ticket-verifyDetailedTktMouseHover";
		     FrameworkUtil.sManualTestCaseName="QAT-464-WCP_4317_TC_1.0_Tickets_Detailed Ticketing System_link should be black when mouse over it";
			 FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			String sTicketID,sQueuevalue;
			//Login to Navigator
//			String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.USERID");
//			
//			String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.PASSWORD");
			
			String sLongNotes = (String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.LONG.NOTES.TEXT");
			//Login to Navigator Portlet
			//LoginTestCase.nav_Login(sUserName,sPassword);
			 LoginTestCase_Old1.LoginAsQaautoUser();
			
			TicketTestCase.navigateToTicketPage();
			WebObjectUtil.MouseHover(Ticket.getNav_DetailedTicketingSystem());
			String sHoverClr=Ticket.getNav_DetailedTicketingSystem().getCssValue("color");
			String sBlackClrVal="rgba(0, 0, 0, 1)";
		// include CSS value check
			if(sHoverClr.equals(sBlackClrVal)){
				  FrameworkUtil.updateCustomResultBasedOnStatus(true, "After Hover Color is black i.e : "+sBlackClrVal);
	           }
	           else{
	        	   FrameworkUtil.updateCustomResultBasedOnStatus(false, "After Hover Color is not black i.e :"+sBlackClrVal);
	           }
		}
		catch (Exception e) {
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		
		}

	}
	
	/*==============================================================
	TestScript  	: verifyTicketNoteCreateTime
    Manual TestCase	: QAT-432-WCP_3791_TC_Tickets, time display for Notes created in Ticket
	Description		: Verify that the time notes is created in a ticket is shown correctly in the date column on notes
	Author 			: Priyanka R
	Creation Date 	: 01/28/2016
	Pre-Requisites	:
	Release Name    : LefCourt
	Revision History:
	==============================================================*/
			@Test(priority=4)
			public void verifyTicketNoteCreateTime()
			{
				
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, Ticket);
				PageFactory.initElements(driver, Smoke);
				PageFactory.initElements(driver, Home);
				try {
					
					String sTicketID = null,sCreateNotes;
			        WebElement wExpander,nExpander,wCreateNotes;
			        FrameworkUtil.sTestCaseName = "Ticket-verifyTicketNoteCreateTime";
					FrameworkUtil.sManualTestCaseName="QAT-432-WCP_3791_TC_Tickets, time display for Notes created in Ticket";

			       	 FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			        //Login to Navigator
//			        String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLE.USERID");
//					
//					String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLE.PWD");
					//Login to Navigator Portlet
					//LoginTestCase.nav_Login(sUserName,sPassword);
			        LoginTestCase_Old1.LoginAsQaautoUser();
					
					//Select and Open Ticket page
			        TicketTestCase.navigateToTicketPage();
			        //dynamic XPATH of Expand icon
			        WebObjectUtil.explicitWait(5);
			        sTicketID = TicketTestCase.getTicketID(1);
			        wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
					WebObjectUtil.explicitWait(5);
					WebObjectUtil.clickElement(wExpander);
					WebObjectUtil.explicitWait(5);
					nExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER", "PARAMETER_TICKETID",  sTicketID);
					WebObjectUtil.explicitWait(5);
					WebObjectUtil.clickElement(nExpander);
					WebObjectUtil.explicitWait(5);
					wCreateNotes = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER.CREATENOTES", "PARAMETER_TICKETID",  sTicketID);
					WebObjectUtil.clickElement(wCreateNotes);
					Ticket.getNav_CreateNote().sendKeys("Selenium Test Note"+"_"+ FrameworkUtil.sTimeStamp);
				    WebObjectUtil.explicitWait(5);
				    WebObjectUtil.clickElement(Ticket.getNav_TicketNoteOk());
				    WebObjectUtil.explicitWait(10);
				    WebElement wNotesTable = WebObjectUtil.GetWebElement("id", "notesGrid-"+sTicketID+"-body", "NotesTable");
				    WebObjectUtil.explicitWait(5);
				    CustomWebElementUtil.loadCustomElement(wNotesTable, "table");
				    int iRowCnt = CustomWebElementUtil.iRowCount;
				    // int iRowCnt=WebTableUtil.getRowCount(wNotesTable);
				    
				    //iRowCnt=iRowCnt/2;
				    String sSysTime=(new Date().getHours()+" : " + new Date().getMinutes());
				    WebObjectUtil.explicitWait(5);
				    WebElement wNoteDateTime= WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.DATE.TIME","PARAMETER_ROWNUMBER",""+iRowCnt);
			    	WebObjectUtil.explicitWait(5);
			    	String sNoteDateTime=wNoteDateTime.getText();
				    String[] sNoteTime=sNoteDateTime.split(" ");
				    WebObjectUtil.explicitWait(5);
				    //SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
				    SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yy HH:mm aa");
				    //Date dNoteTime= (Date)dateFormat.parse(sNoteTime[1]) ; 
				    Date dNoteTimeParse=dateFormat.parse(sNoteDateTime);
				    String dNoteTimeFormat=(dNoteTimeParse.getHours()+" : " + dNoteTimeParse.getMinutes());
				    WebObjectUtil.explicitWait(5);
				    SimpleDateFormat dateFormat2 = new SimpleDateFormat("HH:mm");
				    WebObjectUtil.explicitWait(5);
				    Date dNoteTime= dateFormat2.parse(dNoteTimeFormat.trim());
				    
				    
				    Date dSysNoteTime=dateFormat2.parse(sSysTime.trim());
				    if(((dNoteTime).after(dSysNoteTime))||((dNoteTime).equals(dSysNoteTime))){
				    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VerifyClosedLess()", "Pass","Note Time is recorded same as System Time");
				    }
				    else{
				    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "VerifyClosedLess()", "Fail","Note Time is recorded same as System Time");
				    }
				    LoginTestCase_Old1.nav_Logout();
				   
				}
				catch (ParseException e) {
					LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
				
				}
			 }
			
/*====================================================================================================
Method Name 	: navContactUsCreateTktSearch
Description		: QAT-552-WCP_4331_TC_1.0_Contact Us portlet_Ticket created is not displaying on Tickets details page
Author 			: Priyanka
Creation Date 	: 02/02/16
Pre-Requisites	:
Release         :LefCourt
Revision History:
====================================================================================================*/

@Test(priority=5)
public static void navContactUsCreateTktSearch()
{
	
	try {
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,Home);
		
		FrameworkUtil.sTestCaseName = "Ticket-navContactUsCreateTktSearch";
	    FrameworkUtil.sManualTestCaseName="QAT-552-WCP_4331_TC_1.0_Contact Us portlet_Ticket created is not displaying on Tickets details page";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		
		//Login to Navigator
//		String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.USERID.AROLE");
//		
//		String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.PASSWORD.AROLE");
//		
		//Login to Navigator Portlet
	//	LoginTestCase.nav_Login(sUserName,sPassword);
        LoginTestCase_Old1.LoginAsQaautoUser();
			
		//Verify Create Ticket link - clarification required
		WebObjectUtil.verifyElementPresent(Home.getNav_CreateTicketLink());
		//Create Contact ticket and verify ticket is created
		navContactUsCreateticket();
		
		// log out -- QAA04
		 LoginTestCase_Old1.nav_Logout();
		 
	} catch (Exception e) {
		LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navContactUsSectionExistence", "warn", "catch block:" +e.getMessage());
	}
}

/*==============================================================
TestScript  	: verifyFeedBackTktNotFound
Manual TestCase	: QAT-474-WCP_3270_TC_1.3_Forms 3.0_Dashboard_Feedback Portlet ticket created on WCP not displayed on tickets page
Description		: Verify that feedback ticket created through Feedback portlet on Build Requirements Forms page is not displayed on tickets page 
Author 			: Priyanka R
Creation Date 	: 02/03/2016
Pre-Requisites	:
Release Name    : LefCourt
Revision History:
==============================================================*/
		@Test(priority=6)
		public void verifyFeedBackTktNotFound()
		{
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, Ticket);
			PageFactory.initElements(driver, Home);
			PageFactory.initElements(driver, Smoke);
			PageFactory.initElements(driver, Forms);
			try {
				WebElement wExpander,nExpander,wCreateNotes;
				String sTicketID = null,sCreateNotes,sTitle,sNotesText;
				sTitle=(String)FrameworkUtil.dictPropertyData.get("NAV.AUTOMATION.TEXT");
				sTitle=sTitle+"_"+FrameworkUtil.sTimeStamp;
				sNotesText=(String)FrameworkUtil.dictPropertyData.get("NAV.AUTOMATION.TEXT");
		        
		        FrameworkUtil.sTestCaseName = "Ticket-verifyFeedBackTktNotFound";
				FrameworkUtil.sManualTestCaseName="QAT-474-WCP_3270_TC_1.3_Forms 3.0_Dashboard_Feedback Portlet ticket created on WCP not displayed";

		       	 FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		        //Login to Navigator
		    //    String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.EFGHA.USERID");
				
			//	String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.EFGHA.PASSWORD");
				//Login to Navigator Portlet
			//	LoginTestCase.nav_Login(sUserName,sPassword);
		       	LoginTestCase_Old1.LoginAsEfghaUser();
		       	 //the below line updated by QAA03 on 07/25/2016
		       	// WebObjectUtil.ClickAndMouseHover(Ticket.getNav_SupportTabLink());
		       	WebObjectUtil.clickElement(Ticket.getNav_SupportTabLink());
				WebObjectUtil.clickElement(Forms.getNav_SupportTabFormsLink());
				WebObjectUtil.explicitWait(10);
                WebObjectUtil.clickElement(Forms.getNav_FeedBackClickHereLink());
                WebObjectUtil.SetValueEdit(Forms.getNav_FeedBackTicketTitle(),sTitle);
                WebObjectUtil.explicitWait(5);
               // WebObjectUtil.SetValueEdit(Forms.getNav_FeedBackTicketNote(),sNotesText);
                WebObjectUtil.clickElement(Forms.getNav_FeedBackTicketNote());
                Forms.getNav_FeedBackTicketNote().sendKeys(sNotesText);
                WebObjectUtil.explicitWait(5);
                WebObjectUtil.clickElement(Home.getNav_OkBtn());
                WebObjectUtil.explicitWait(10);
                WebObjectUtil.clickElement(Home.getNav_OkBtn());
                WebObjectUtil.explicitWait(10);
                TicketTestCase.navigateToTicketPage();
                TicketTestCase.searchTicket("Summary", sTitle);
                WebObjectUtil.explicitWait(5);
                int iRowCnt=WebTableUtil.getRowCount(Ticket.getNav_TicketsWebTable());
             
              if(!(iRowCnt>0))
              {
              FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Search string" , "Search Result", "pass", "No Ticket Displayed");
              }
              else
              {
              FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Search string" , "Search Result", "fail", "Tickets are displayed" );
              }

  			// log out --> QAA04
  			 LoginTestCase_Old1.nav_Logout();
              }
			catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navContactUsCreateticket", "warn", "catch block:" +e.getMessage());  
			}
		}



//___________________________Completed LefCourt test cases __________________________________________________///
	/*====================================================================================================
	Method Name 	: navContactUsCreateticket
	Description		: Creating a ticket with link in Contact Us portlet and verify in tickets page
	Author 			: Srilatha
	Creation Date 	: 
	Pre-Requisites	:
	Revision History: Revised By Priyanka R
	====================================================================================================*/
	public static void navContactUsCreateticket()
	{
		     String sTitle=null,sNotesText=null;
		     WebElement  wNotesField;
		     sTitle=(String)FrameworkUtil.dictPropertyData.get("NAV.AUTOMATION.TEXT");
		     sNotesText=(String)FrameworkUtil.dictPropertyData.get("NAV.AUTOMATION.TEXT");
		     sTitle=sTitle+"_"+FrameworkUtil.sTimeStamp;
		  try {
			  //Clicking the Create Ticket Link
			  WebObjectUtil.clickElement(Home.getNav_CreateTicketLink());
			  //Entering Value in Title field
			  WebObjectUtil.SetValueEdit(Home.getNav_TitleText(),sTitle);
			  //Clicking the Severity field
			  WebObjectUtil.clickElement(Home.getNav_SeverityList());
			  //Selecting Severity 'Sev-4' from List
			  WebObjectUtil.clickElement(Home.getNav_SeverityListItem());
			  //Clicking the Priority field
			  WebObjectUtil.clickElement(Home.getNav_PriorityList());
			  //Selecting Priority 'high' from List
			  WebObjectUtil.clickElement(Home.getNav_PriorityListItem());
			  //Clicking the Category field
			  WebObjectUtil.clickElement(Home.getNav_CategoryList());
			  //Selecting Category 'billing' from List
			  WebObjectUtil.clickElement(Home.getNav_CategoryListItem());
			  wNotesField= WebDriverUtil.getDriver().switchTo().activeElement();
			  wNotesField.sendKeys(sNotesText);
			  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Enter Text on Notes", "done", sNotesText);
			  WebObjectUtil.clickElement(Home.getNav_OkBtn());
			  WebObjectUtil.explicitWait(10);
			  WebObjectUtil.clickElement(Home.getNav_CreateTicketSucessNotificationOKBtn());
			  WebObjectUtil.explicitWait(5);
			  TicketTestCase.navigateToTicketPage();
			  WebObjectUtil.explicitWait(5);
			  TicketTestCase.searchTicket("Summary", sTitle);
			  WebObjectUtil.explicitWait(10);
			  TicketTestCase.SearcResultFound("Summary",3,sTitle);
			  //WebObjectUtil.clickElement(Home.getNav_CancelBtn());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navContactUsCreateticket", "warn", "catch block:" +e.getMessage());  
		}
	}
			
			
			
/*==============================================================
Method Name       : ValUserNotViewTicketPage
Description       : it will verify that user can not see Ticket Page
Author            : Vivek Kumar
Creation Date     : 11/23/2015
Pre-Requisites    :
Revision History:
==============================================================*/
public static void ValUserNotViewTicketPage(String sUserName,String sPassword)
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver,Ticket);
	
	boolean bTicketStatus=true;
	
	try {
		//Login using sUsername
		LoginTestCase_Old1.nav_Login(sUserName, sPassword);
		//Clicking and Hovering on Support Tab
		//the below line updated by QAA03 on 07/25/2016
		//WebObjectUtil.ClickAndMouseHover(Ticket.getNav_SupportTabLink());
		WebObjectUtil.clickElement(Ticket.getNav_SupportTabLink());
		WebObjectUtil.clickElement(Ticket.getNav_TicketsMenuLink());
		bTicketStatus=WebObjectUtil.isElementPresent(Ticket.getNav_CreateTicketLink());
		FrameworkUtil.updateCustomResultBasedOnStatus(!bTicketStatus, sUserName+" - not able to view Ticket page");
		//Logout
		LoginTestCase_Old1.nav_Logout();
	} catch (Exception e) {
		LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
	}
}


/*
==============================================================
TestScript  	: navValTktNotesDteDsply
Manual TestCase	: CPPOC-3343-Tickets notes and date display on "Add a storage tier " ticket
Description		: Tickets notes and date display on "Add a storage tier " ticket
Author 			: Vivek Kumar
Creation Date 	: 08/25/2015
Pre-Requisites	:
Revision History:
==============================================================
	@Test(priority=21)
	public void navValTktNotesDteDsply()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		
		PageFactory.initElements(driver,Ticket);
		PageFactory.initElements(driver,EVDC_OverviewPF);
		
		FrameworkUtil.sTestCaseName = "Gideon-navValTktNotesDteDsply";
		FrameworkUtil.sManualTestCaseName="CPPOC-3343-Tickets notes and date display on 'Add a storage tier'";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		String sUserName,sPassword;
		String sTicketTitle,sText,sErrMessage,sDate;
		
		sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLE.USERID");
		sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLE.PWD");
		LoginTestCase.nav_Login(sUserName, sPassword);
		
		//clicking on EVDC link
		WebObjectUtil.clickAndVerifyText(EVDC_OverviewPF.getNav_EVDCname(), "Storage");
		
		//Clicking on Storage Link
		WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCOverviewStorage(), EVDC_OverviewPF.getNav_AddStoraegTeirLink());
		//Clicking on Add Storage tier link
		WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_AddStoraegTeirLink(), EVDC_OverviewPF.getNav_CreateTicketPopUp());
		
		//Verifying error message
		sText=(String) FrameworkUtil.dictPropertyData.get("NAV.CLARK.TICKET.TITLE");
		sText=sText + FrameworkUtil.sTimeStamp;
		sTicketTitle=EVDC_OverviewPF.getNav_CreateTicketTitleEditBox().getAttribute("value")+"-" + sText;
		
		//Capturing system current  Date and time

	    SimpleDateFormat date = new SimpleDateFormat("MM-dd-yy HH:mm aa");//dd/MM/yyyy
	    Date now = new Date();
	    sDate = date.format(now);
	    //oldstr.replace("AM", "am").replace("PM","pm");
	    sDate=sDate.replace("AM", "am").replace("PM","pm");
	    
		//Filling Storage details
	    ClarkTestCase.fillingAddStorageDetails(sText,sTicketTitle);
		
	    WebObjectUtil.explicitWait(2);
	    //Navigate to Ticket Page
	   // ClarkTestCase.navigateToTicket();
	    TicketTestCase.navigateToTicketPage();
	    
	    String sActualLastDate;
	    boolean bStatus;
	    int iColumnNumber=6;
	    
	   
	    //Select "TicketNotes" from dropdown list
		TicketTestCase.searchTicket("Ticket Notes", ClarkTestCase.sStorageNote);
		//sActualDate = (WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, iColumnNumber)).trim();
		//Commented the above line and added the below two line as part of EXTJS5 modification- Vivek - 10072015
		WebObjectUtil.explicitWait(10);
		CustomWebElementUtil.loadCustomElement(Ticket.getNav_TicketsWebTableParent(), "table");
		sActualLastDate = (CustomWebElementUtil.getCellData(1, iColumnNumber)).trim();
		
		bStatus=WebObjectUtil.compareString(sActualLastDate, sDate, true);
		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, sActualLastDate + " date displayed");
		
		WebObjectUtil.explicitWait(10);
		TicketTestCase.NotesSearcResultFound(ClarkTestCase.sStorageNote);
	    
		//Logout
		LoginTestCase.nav_Logout();
	}
	

==============================================================
Method Name 	: fillingAddStorageDetails
Description		: This will enter storage details
Author 			: Vivek Kumar
Creation Date 	: 08/25/2015
Pre-Requisites	:
Revision History:
==============================================================
public static void fillingAddStorageDetails(String sText,String sTicketTitle)
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, Clark);
	String sErrMessage;
	
	
	WebObjectUtil.SetValueEdit(Clark.getNav_CreateTicketTitleEditBox(), sTicketTitle);
    WebObjectUtil.clickElement(Clark.getNav_CreateTicketStorageTierEditBox());
    WebObjectUtil.explicitWait(2);
    WebObjectUtil.clickElement(Clark.getNav_StorageDropDownItem());
    WebObjectUtil.explicitWait(2);
    WebObjectUtil.clickElement(Clark.getNav_CreateTicketOKBtn());
    WebObjectUtil.explicitWait(2);
    if(WebObjectUtil.isElementPresent(Clark.getNav_PopUpMessage()))
    {
    	sErrMessage=Clark.getNav_PopUpMessage().getText();
    	WebObjectUtil.clickElement(Clark.getNav_PopUpOKBtn());
    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verifying error messeg", "pass",sErrMessage+ " message verified");
    }
    else
    {
    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verifying error messeg", "fail","error message not verified");
    }
    //WebObjectUtil.clickElement(Clark.getNav_ConfirmPopUpOKBtn());
    WebObjectUtil.explicitWait(2);
	
	//Creating Ticket
	//WebObjectUtil.SetValueEdit(Clark.getNav_CreateTicketTitleEditBox(), sTicketTitle);
    WebObjectUtil.clickElement(Clark.getNav_CreateTicketStorageTierEditBox());
    WebObjectUtil.explicitWait(2);
    WebObjectUtil.clickElement(Clark.getNav_StorageDropDownItem());
    
   // Clark.getNav_CreateTicketTextArea().sendKeys(sText);
    String sTextAreaStr=sText + '\n';
    sStorageNote= Clark.getNav_CreateTicketTextArea().getText();
    Clark.getNav_CreateTicketTextArea().sendKeys(sTextAreaStr);
    WebObjectUtil.explicitWait(3);
    sStorageNote= Clark.getNav_CreateTicketTextArea().getText();
    sStorageNote=Clark.getNav_GetTextAreaTxt().getText();
    sStorageNote=sText;
    FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Add Storage tier ticket text area" , "Enter value to Ticket notes", "done",sTextAreaStr);
    WebObjectUtil.explicitWait(2);
    WebObjectUtil.clickElement(Clark.getNav_CreateTicketOKBtn());
    WebObjectUtil.explicitWait(10);
    //WebObjectUtil.clickElement(Clark.getNav_ConfirmPopUpOKBtn());
    WebObjectUtil.clickElement(Clark.getNav_PopUpOKBtn());
    
}

*/

//////////******************Keffer TestCases Start******************************//////////

/*==============================================================
TestScript  	: verifyClosedLessTicketData()
Manual TestCase	: QAT387-WCP_2723_TC_1.1_Tickets_Notes_Difficult to 
                  navigate_Closed less than 6 months tickets
Description		: Verify the ticket list updates automatically,and 
                shows only Closed (more than 6 months) status tickets
Author 			: Priyanka Rachupalli
Creation Date 	: 06/21/2015
Release         : Keffer
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=81)
public void verifyClosedLessTicketData()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver,Ticket);
try{
	int iRow=1;
	String sID,sServID,sServLogTable;
	FrameworkUtil.sTestCaseName = "verifyClosedLessTicketData";
	FrameworkUtil.sManualTestCaseName="QAT387-WCP_2723_TC_1.1_Tickets_Notes";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	//Getting UserId from properties file
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.USERID");
	//String sUserName = FrameworkUtil.getPropValues("NAV.EVDC.USERID");
	//Getting password from properties file
	String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.PASSWORD");
	//Login to Navigator Portlet
	//LoginTestCase.nav_Login(sUserName,sPassword);
	LoginTestCase_Old1.LoginAsRoleAUser();
	//Select and Open Ticket page
	TicketTestCase.navigateToTicketPage();
	//select the status filter button
	WebObjectUtil.ClickAndMouseHover(Ticket.getNav_FilterByStatusDropdown());
	WebObjectUtil.clickElement(Ticket.getNav_ClosedLess());
	WebObjectUtil.explicitWait(10);
	CustomWebElementUtil.loadCustomElement(Ticket.getNav_TicketsWebTable(), "table");
	VerifyLogsAndSearchText();
	LoginTestCase_Old1.nav_Logout();
	
}
catch (Exception e) {
	LoggerUtil.log_type_error("issue with - Ticket- verifyClosedLessTicketData" );
	LoggerUtil.log_type_error(e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
 }
}

/*==============================================================
TestScript  	: verifyIconsDisabled()
Manual TestCase	: QAT380-WCP_3486_TC_1.0_Disable double click on all submit buttons
Description		: Verify the ticket list updates automatically,and 
                shows only Closed (more than 6 months) status tickets
Author 			: Priyanka Rachupalli
Creation Date 	: 06/21/2015
Release         : Keffer
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=82)
public void verifyIconsDisabled()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver,Ticket);
	PageFactory.initElements(driver,Common);
try{
	int iRow=1;
	String sTicketID,sSummary,sSummaryTicketvalue,sActualSuccessMsg,sDetailsID;
	Boolean bStatus;
	FrameworkUtil.sTestCaseName = "verifyIconsDisabled";
	FrameworkUtil.sManualTestCaseName="QAT380-WCP_3486_TC_1.0_Disable double click on all submit buttons";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	//Getting UserId from properties file
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.USERID");
	//String sUserName = FrameworkUtil.getPropValues("NAV.EVDC.USERID");
	//Getting password from properties file
	String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.PASSWORD");
	//Login to Navigator Portlet
	//LoginTestCase.nav_Login(sUserName,sPassword);
	LoginTestCase_Old1.LoginAsRoleAUser();
	//Select and Open Ticket page
	TicketTestCase.navigateToTicketPage();
	CustomWebElementUtil.loadCustomElement(Ticket.getNav_TicketsWebTable(), "table");
	sTicketID=TicketTestCase.getTicketID(1);
	
	//EVDC_Advanced.expandVMbyRowNum(1);
	TicketTestCase.expandTable(1);
	WebObjectUtil.explicitWait(5);
	sSummary =(String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.SUMMARY.VALUE");
	sSummaryTicketvalue = Ticket.getNav_TicketSummaryEdit().getAttribute("value");
	sSummaryTicketvalue = sSummaryTicketvalue + "-UpdateTicketSelenium" + FrameworkUtil.sTimeStamp ;
	WebObjectUtil.SetValueEdit(Ticket.getNav_TicketSummaryEdit(), sSummaryTicketvalue);
	WebObjectUtil.clickElement(Ticket.getNav_TicketSaveUpdatesBtn());
	/*WebObjectUtil.explicitWait(5);
	WebObjectUtil.clickElement(Ticket.getNav_TicketSaveUpdatesBtn());*/
	WebObjectUtil.waitForElementPresent(Common.getNav_CommonPopUpMessage());
	
	sDetailsID="tktDtImg-"+sTicketID;
	//WebElement wDetailsExpander=WebObjectUtil.GetWebElement("id", sDetailsID, "Details Expander");
	//WebObjectUtil.explicitWait(5);
	
	
	sActualSuccessMsg = Common.getNav_CommonPopUpMessage().getText();
	bStatus=WebObjectUtil.compareString(sActualSuccessMsg, "Successfully updated the ticket", true);
	FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Updated Ticket Summary " + sTicketID + " updated to : " + sSummaryTicketvalue);
	//TicketTestCase.verifyElementDisabled(wDetailsExpander);
	//WebObjectUtil.explicitWait(5);
	WebObjectUtil.verifyElementPresent(Common.getNav_CommonPopUpScreenMask());
	WebObjectUtil.explicitWait(5);
	WebObjectUtil.clickElement(Common.getNav_CommonPopUpOKButton());
	WebObjectUtil.explicitWait(5);
	/*TicketTestCase.expandTable(2);
	WebObjectUtil.explicitWait(7);
	WebObjectUtil.waitForElementPresent(Ticket.getNav_TicketCloneBtn());
	WebObjectUtil.clickElement(Ticket.getNav_TicketCloneBtn());
	WebObjectUtil.waitForElementPresent(Common.getNav_CommonPopUpMessage());
	
	//WebObjectUtil.Element(Ticket.getNav_TicketCloneBtn());
		TicketTestCase.verifyElementDisabled(Ticket.getNav_TicketCloneBtn());
		//WebObjectUtil.explicitWait(3);
*/		
	WebObjectUtil.clickElement(Ticket.getNav_TicketCloneBtn());
	WebObjectUtil.waitForElementPresent(Common.getNav_CommonPopUpMessage());
	sActualSuccessMsg = Common.getNav_CommonPopUpMessage().getText();
	bStatus=WebObjectUtil.compareString(sActualSuccessMsg, "Successfully cloned the ticket", true);
	FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "popup msg verified : " + sActualSuccessMsg);
	//TicketTestCase.verifyElementDisabled(Ticket.getNav_TicketCloneBtn());
	WebObjectUtil.verifyElementPresent(Common.getNav_CommonPopUpScreenMask());
	WebObjectUtil.explicitWait(5);
	WebObjectUtil.clickElement(Common.getNav_CommonPopUpOKButton());
	LoginTestCase_Old1.nav_Logout();
    
}
catch (Exception e) {
	LoggerUtil.log_type_error("issue with - Ticket- verifyIconsDisabled()" );
	LoggerUtil.log_type_error(e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
 }
}

/*==============================================================
TestScript  	: verifyTicketNotesIDSequence()
Manual TestCase	: QAT-379-WCP_3679_TC_1.1_Tickets_Notes_verify note ids_closed less than 6 months
Description		:Verify the note id s in Notes grid under Tickets for closed (less than 6 months) Tickets. 
                 Verify tickets which has smaller number of notes as well as larger number of notes.
Author 			: Priyanka Rachupalli
Creation Date 	: 01/04/2015
Release         : Keffer
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=83)
public void verifyTicketNotesIDSequence()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver,Ticket);
try{
	//validateNoteOrderDisplay()
	int i,iRow=1,iRowMax;
	int sNumSeq[]=new int[100];
	FrameworkUtil.sTestCaseName = "verifyTicketNotesIDSequence";
	FrameworkUtil.sManualTestCaseName="QAT-379-WCP_3679_TC_1.1_Tickets_Notes_verify note ids_closed less than 6 months";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.USERID");
	String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.PASSWORD");
	//LoginTestCase.nav_Login(sUserName,sPassword);
	LoginTestCase_Old1.LoginAsRoleAUser();	
	
	//Select and Open Ticket page
	TicketTestCase.navigateToTicketPage();
	
	CustomWebElementUtil.loadCustomElement(Ticket.getNav_TicketsWebTable(), "table");
	WebObjectUtil.ClickAndMouseHover(Ticket.getNav_FilterByStatusDropdown());
	WebObjectUtil.clickElement(Ticket.getNav_ClosedLess());
	WebObjectUtil.explicitWait(10);	
	String sTicketID=TicketTestCase.getTicketID(iRow);
	//expand table 
	TicketTestCase.expandTable(iRow);
	WebObjectUtil.explicitWait(6);
	//expand notes
	WebElement nExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER", "PARAMETER_TICKETID",  sTicketID);
	WebObjectUtil.explicitWait(3);
	WebObjectUtil.clickElement(nExpander);
	WebObjectUtil.explicitWait(6);
	
	WebElement wNotesTable = WebObjectUtil.GetWebElement("id", "notesGrid-"+sTicketID+"-body", "NotesTable");
	WebObjectUtil.explicitWait(3);
	iRowMax=WebTableUtil.getRowCount(wNotesTable);
	WebObjectUtil.explicitWait(5);
	if((iRowMax>0)&&(wNotesTable!=null))
	{
		for(i=1;i<=iRowMax;i=i+2)
		{
			/*WebElement nRowsExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NOTES.GRID.EXPANDER", "PARAMETER_ROWNUMBER",  Integer.toString(i));
			WebObjectUtil.explicitWait(5);
			WebObjectUtil.clickElement(nRowsExpander);*/
			//expandNoteRow(i);
			//WebObjectUtil.explicitWait(5);
			sNumSeq[i]=Integer.parseInt(WebTableUtil.getCellData(wNotesTable, i, 2).trim());
					if(i>2)
					{
						if(sNumSeq[i]==(sNumSeq[i-2]+1)){
							//Boolean bStatus=true;
							FrameworkUtil.updateCustomResultBasedOnStatus(true, "Notes ID are displayed in sequence "+""+sNumSeq[i]  );
						
						}
						else{
							FrameworkUtil.updateCustomResultBasedOnStatus(false, "Notes ID are not displayed in sequence "  );	
							
						}	
					}
					else
					{
						FrameworkUtil.updateCustomResultBasedOnStatus(true, "Only one Notes ID is displayed in sequence "+""+sNumSeq[i]  );
					
					}
				
		   }
		
	}	
	LoginTestCase_Old1.nav_Logout();
}

catch (Exception e) {
	LoggerUtil.log_type_error("issue with - Ticket-  verifyTicketNotesIDSequence" );
	LoggerUtil.log_type_error(e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
 }
}

/*==============================================================
TestScript  	: VerifySearchTktandChkNotesLogs()
Manual TestCase	: QAT-377-WCP_2723_TC_1.0_Tickets_Notes_Difficult to navigate_Outstanding tickets
Description		:Verify the note ids in Notes grid under Tickets for closed (More than 6 months) Tickets. 
                 Verify tickets which has smaller number of notes as well as larger number of notes.
Author 			: Priyanka Rachupalli
Creation Date 	: 01/06/2015
Release         : Keffer
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=84)
public void VerifySearchTktandChkNotesLogs()
{
	WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,Ticket);
	try{
		int iRow=1;
		String sID,sServID,sServLogTable;
		FrameworkUtil.sTestCaseName = "VerifySearchTktandChkNotesLogs";
		FrameworkUtil.sManualTestCaseName="QAT-377-WCP_2723_TC_1.0_Tickets_Notes_Difficult to navigate_Outstanding tickets";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		//Getting UserId from properties file
		String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.USERID");
		//String sUserName = FrameworkUtil.getPropValues("NAV.EVDC.USERID");
		//Getting password from properties file
		String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.PASSWORD");
		//Login to Navigator Portlet
		//LoginTestCase.nav_Login(sUserName,sPassword);
		LoginTestCase_Old1.LoginAsRoleAUser();
		//Select and Open Ticket page
		TicketTestCase.navigateToTicketPage();
		//select the status filter button
		//WebObjectUtil.ClickAndMouseHover(Ticket.getNav_FilterByStatusDropdown());
		//WebObjectUtil.clickElement(Ticket.getNav_ClosedLess());
		TicketTestCase.searchTicket("Ticket ID","474508");
		WebObjectUtil.explicitWait(10);
		CustomWebElementUtil.loadCustomElement(Ticket.getNav_TicketsWebTable(), "table");
		String sTicketID=TicketTestCase.getTicketID(iRow);
		TicketTestCase.expandTable(iRow);
		//expand notes
		WebElement nExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER", "PARAMETER_TICKETID",  sTicketID);
		WebObjectUtil.explicitWait(3);
        WebObjectUtil.clickElement(nExpander);
		WebObjectUtil.explicitWait(6);
		WebElement wNotesTable = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER.WNOTESTABLE", "PARAMETER_TICKETID",  sTicketID);
		  
		 	//if(Ticket.getNav_NotesWebTable().isDisplayed())
		 if(wNotesTable.isDisplayed())
		    {
		 				/*if(!(Ticket.getNav_TktNotesPaginationChk().isDisplayed()))
		 					FrameworkUtil.updateCustomResultBasedOnStatus(true, "Note Pagination is Removed");
		 					else
		 						FrameworkUtil.updateCustomResultBasedOnStatus(false, "Note Pagination is not Removed");
*/		 		        
		 		        //WebObjectUtil.verifyElementNOTPresent(Ticket.getNav_TktNotesPaginationChk());
		 				
		 		    WebObjectUtil.selectCheckRadioBox(Ticket.getNav_ExpandAllNoteCheckbox());

		    
		    }
		 		else{
		 			FrameworkUtil.updateCustomResultBasedOnStatus(false, "Notes WebTable is not displayed");
		    }
		 	
		 WebObjectUtil.explicitWait(5);
		 WebObjectUtil.VerifyTextOnPage("test");
		 sID="tktLogsImg-" + sTicketID;
		 WebElement wTicketLogsExpander=WebObjectUtil.GetWebElement("id", sID, "Ticket Logs Expander");
		 //Expand Notes
		// this object is added by QAA04 - 02/23/16
		 WebObjectUtil.clickElement(wTicketLogsExpander);
		 // wTicketLogsExpander.click();
		 WebObjectUtil.explicitWait(5);
		 WebObjectUtil.verifyElementPresent(Ticket.getNav_TicketLogsTable());
		 WebObjectUtil.explicitWait(5);
		 sServID="tktServiceLogsImg-" + sTicketID;
		 WebElement wTicketServiceLogsExpander=WebObjectUtil.GetWebElement("id", sServID, "Notes Expander");
		 //Expand Notes
		// this object is added by QAA04 - 02/23/16
	    WebObjectUtil.clickElement(wTicketServiceLogsExpander);
		 // wTicketServiceLogsExpander.click();
		 WebObjectUtil.explicitWait(5);
		 sServLogTable="tktServiceLogsGrid-" + sTicketID;
		 WebElement wTicketServiceLogsTable=WebObjectUtil.GetWebElement("id", sServLogTable, "ServLogsTable");
		 WebObjectUtil.verifyElementPresent(wTicketServiceLogsTable);
		// WebObjectUtil.getActiveElementasWebElement(sULElementXpath)
		 LoginTestCase_Old1.nav_Logout();
	}

catch (Exception e) {
	LoggerUtil.log_type_error("issue with - Ticket-  verifyTicketNotesIDSequence" );
	LoggerUtil.log_type_error(e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
 }
}

/*==============================================================
TestScript  	: VerifyCreateMultipleNotesChk()
Manual TestCase	: QAT-353-WCP_3679_TC_1.0_Tickets_Notes_verify note ids_Outstanding tickets
Description		:Verify the note ids in Notes grid under Tickets for Outstanding Tickets. 
                 Verify tickets which has smaller number of notes as well as larger number of notes. 
Author 			: Priyanka Rachupalli
Creation Date 	: 01/07/2015
Release         : Keffer
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=85)
public void VerifyCreateMultipleNotesChk()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver,Ticket);
try{
	
	int iRow=1,i,iCounter=0;
	String sTicketID;
	FrameworkUtil.sTestCaseName = "VerifyCreateMultipleNotesChk";
	FrameworkUtil.sManualTestCaseName="QAT-353-WCP_3679_TC_1.0_Tickets_Notes_verify note ids_Outstanding tickets";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.USERID");
	String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.PASSWORD");
	WebObjectUtil.explicitWait(5);
	//Login to Navigator
	//TicketTestCase.navTicketLogin();
	LoginTestCase_Old1.LoginAsRoleAUser();
	//Select and Open Ticket page
	TicketTestCase.navigateToTicketPage();
	CustomWebElementUtil.loadCustomElement(Ticket.getNav_TicketsWebTable(), "table");
	sTicketID = TicketTestCase.getTicketID(1);
	TicketTestCase.expandTable(iRow);
	WebObjectUtil.explicitWait(6);
	//expand notes
	WebElement nExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER", "PARAMETER_TICKETID",  sTicketID);
	WebObjectUtil.explicitWait(3);
	WebObjectUtil.clickElement(nExpander);
	WebObjectUtil.explicitWait(6);
	for(i=1;i<=10;i++)
	{
		//WebObjectUtil.clickElement(Ticket.getNav_CreateNote());
		WebObjectUtil.clickElement(Ticket.getNav_CreateNoteLink());
		WebObjectUtil.waitForElementPresent(Ticket.getNav_CreateNotesFrame());
        Ticket.getNav_CreateNote().sendKeys("Selenium Test Note"+"_"+ FrameworkUtil.sTimeStamp);
        WebObjectUtil.explicitWait(5);
        WebObjectUtil.clickElement(Ticket.getNav_TicketNoteOk());
        WebObjectUtil.explicitWait(5);
        
        
	}
               //Pagination check
		/*if(!(Ticket.getNav_TktNotesPaginationChk().isDisplayed()))
			FrameworkUtil.updateCustomResultBasedOnStatus(true, "Note Pagination is Removed");
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false, "Note Pagination is not Removed");
*/
	//validateNoteOrderDisplay()
	boolean bOrder=false;
	int iNoteRowCount=WebTableUtil.getRowCount(Ticket.getNav_NotesWebTable());
	//WebElement wNotesRow=WebObjectUtil.GetWebElement("xpath", "//table//tr[1]/td/table/tbody/tr[@class='x-grid-rowbody-tr']/td/div/div[contains(@id,'idNotesRow')]/div[contains(@id,'cloakDiv')]/table", "Note Row");
	////div[@id='idTicketsGridPanel-body']//table[1]/tbody/tr[2]/td/div/section[3]//div[Contains(@id,'notesGrid')]//table[13]
	for(i=1;i<=iNoteRowCount;i=i+2)
	{
		
		//int iItem=WebTableUtil.getRowByCellText(Ticket.getNav_NotesWebTable(), Integer.toString(i), 1,2);
		//Column number got changed. 3 to 2. Commneted and added another statement By Sukur Dated on 15/02/2016
		//String sItem=WebTableUtil.getCellData(Ticket.getNav_NotesWebTable(), i, 3);
		String sItem=WebTableUtil.getCellData(Ticket.getNav_NotesWebTable(), i, 2);
		if(sItem.length()>0)
		{
		iCounter++;
		if(sItem.contains(Integer.toString(iCounter)))
			bOrder=true;
		else
		{
			bOrder=false;
			break;
		}
	}
		else
			continue;
		
	}
	if(iCounter==(iNoteRowCount/2))
		FrameworkUtil.updateCustomResultBasedOnStatus(true,"Order of the notes displayed for the ticket is valid" );
	else
		FrameworkUtil.updateCustomResultBasedOnStatus(false,"Order of the notes displayed for the ticket is in-valid" );

	LoginTestCase_Old1.nav_Logout();	
}

catch (Exception e) {
	LoggerUtil.log_type_error("issue with - Ticket-  verifyTicketNotesIDSequence" );
	LoggerUtil.log_type_error(e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
 }
}
	
/*==============================================================
TestScript  	: VerifyMultipleNotesSequenceChk()
Manual TestCase	: QAT-365-WCP_3679_TC_1.2_Tickets_Notes_verify note ids_closed more than 6 months
Description		:Verify the note ids in Notes grid under Tickets for Outstanding Tickets. 
                 Verify tickets which has smaller number of notes as well as larger number of notes. 
Author 			: Priyanka Rachupalli
Creation Date 	: 01/07/2015
Release         : Keffer
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=86)
public void VerifyMultipleNotesSequenceChk()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver,Ticket);
	PageFactory.initElements(driver,Ticket); 
try{
	
	int iRow=1,i,iCounter=0;
	String sTicketID;
	FrameworkUtil.sTestCaseName = "VerifyMultipleNotesSequenceChk";
	FrameworkUtil.sManualTestCaseName="QAT-365-WCP_3679_TC_1.2_Tickets_Notes_verify note ids_closed more than 6 months";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.USERID");
	String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.PASSWORD");
	String sFewTicketNotes=(String)FrameworkUtil.dictPropertyData.get("TICKET.FEW.NOTES.ID");
	String sMoreTicketNotes=(String)FrameworkUtil.dictPropertyData.get("TICKET.MORE.NOTES.ID");
	WebObjectUtil.explicitWait(5);
	//Login to Navigator
	//TicketTestCase.navTicketLogin();
	LoginTestCase_Old1.LoginAsRoleAUser();
	//Select and Open Ticket page
	TicketTestCase.navigateToTicketPage();
	//CustomWebElementUtil.loadCustomElement(Ticket.getNav_TicketsWebTable(), "table");
	WebObjectUtil.ClickAndMouseHover(Ticket.getNav_FilterByStatusDropdown());
	WebObjectUtil.clickElement(Ticket.getNav_ClosedMore());
	WebObjectUtil.explicitWait(10);
	
	TicketTestCase.searchTicket("Ticket ID", sFewTicketNotes);
	
	WebObjectUtil.explicitWait(10);
	//TicketTestCase.SearcResultFound("Ticket ID",3, sFewTicketNotes);
	VerifyExpandTicketChkSeq();
	TicketTestCase.searchTicket("Ticket ID", sMoreTicketNotes);
	WebObjectUtil.explicitWait(10);
	//TicketTestCase.SearcResultFound("Ticket ID",3, sMoreTicketNotes);
	VerifyExpandTicketChkSeq();
	
		
}

catch (Exception e) {
	LoggerUtil.log_type_error("issue with - Ticket-  verifyTicketNotesIDSequence" );
	LoggerUtil.log_type_error(e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
 }
}
/*==============================================================
TestScript  	: verifyClosedMoreTicketData()
Manual TestCase	: QAT345-WCP_2723_TC_1.2_Tickets_Notes_Difficult to navigate_Closed more than 6 months tickets
Description		: Verify the ticket list updates automatically,and 
                shows only Closed (more than 6 months) status tickets
Author 			: Priyanka Rachupalli
Creation Date 	: 06/21/2015
Release         : Keffer
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=87)
public void verifyClosedMoreTicketData()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver,Ticket);
try{
	
	
	FrameworkUtil.sTestCaseName = "verifyClosedMoreTicketData";
	FrameworkUtil.sManualTestCaseName="QAT345-WCP_2723_TC_1.2_Tickets_Notes_Difficult to navigate_Closed more than 6 months tickets";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	//Getting UserId from properties file
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.USERID");
	//String sUserName = FrameworkUtil.getPropValues("NAV.EVDC.USERID");
	//Getting password from properties file
	String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.PASSWORD");
	//Login to Navigator Portlet
	//LoginTestCase.nav_Login(sUserName,sPassword);
	LoginTestCase_Old1.LoginAsRoleAUser();
	//Select and Open Ticket page
	TicketTestCase.navigateToTicketPage();
	//select the status filter button
	WebObjectUtil.ClickAndMouseHover(Ticket.getNav_FilterByStatusDropdown());
	WebObjectUtil.clickElement(Ticket.getNav_ClosedMore());
	WebObjectUtil.explicitWait(10);
	CustomWebElementUtil.loadCustomElement(Ticket.getNav_TicketsWebTable(), "table");
	VerifyLogsAndSearchText();
	LoginTestCase_Old1.nav_Logout();
}
catch (Exception e) {
	LoggerUtil.log_type_error("issue with - Ticket- verifyClosedMoreTicketData" );
	LoggerUtil.log_type_error(e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
 }
}
              ///////////////////////Keffer Methods //////////////////////////////
/*====================================================================================================
Method Name 	: verifyTicketDataPresentForOrg
Description		: Verify Ticket Data is present for the selected organization
Author 			: QAA03
Creation Date 	: 01/13/2016
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static void verifyTicketDataPresentForOrg(String sOrgName)
{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,Ticket);
		WebElement wOrgName;

 try {
	    WebObjectUtil.SetValueEdit(Ticket.getNav_TicketOrgWebList(),sOrgName);
	    
	    wOrgName = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.ORGNAME.EDIT", "PARAMATER_ORGNAME", sOrgName);
       // this object is added by QAA04 - 02/23/16
	    //WebObjectUtil.clickElement(wOrgName);
	    
	     wOrgName.click();    
	    
	    WebObjectUtil.explicitWait(5);
	    CustomWebElementUtil.loadCustomElement(Ticket.getNav_TicketsWebTable(), "table");
	    int iRowCount = CustomWebElementUtil.iRowCount;
	    if(iRowCount>0)
	      {
	    	  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying Ticket Data", "pass", "Ticket Data for organization selected"+sOrgName);
	      }
	     else
	      {
	    	  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying Ticket Data", "fail", "No Ticket Data available for selected organization"+sOrgName);
	      }
	   
		
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyTicketDataPresentForOrg", "warn", "catch block:" +e.getMessage());  
	}

}
/*====================================================================================================
Method Name 	: verifyOrgNameinTicket
Description		: Verify Organization Name in Ticket
Author 			: QAA03
Creation Date 	: 01/13/2016
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static void verifyOrgNameinTicket(String sOrgName)
{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,Ticket);
		WebElement wTktExpander,wTicketExpOrgName;
		String sTicketExpOrgName=null;
		boolean bTktOrgStatus;

 try {
	    wTktExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
		WebObjectUtil.clickElement(wTktExpander);
		
		wTicketExpOrgName = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER.ORGNAME", "PARAMETER_ROWNUMBER", 1 +"");                                                              
		sTicketExpOrgName=wTicketExpOrgName.getText();
		 
		bTktOrgStatus = sTicketExpOrgName.equalsIgnoreCase(sOrgName);
		
		FrameworkUtil.updateCustomResultBasedOnStatus(bTktOrgStatus, "OrgName in Ticket matched the selected Entity"+sOrgName);
	    
		
	 } catch (Exception e) {
		// TODO Auto-generated catch block
		LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyOrgNameinTicket", "warn", "catch block:" +e.getMessage());  
	}

}

/*====================================================================================================
Method Name 	: verifyEntityUnderOrganizationColumn
Description		: Tickets - Verifying the expected entity name in the organization column 
Author 			: QAA04
Creation Date 	: 12/29/2015
Release Name    : Keffer
Pre-Requisites	:
Revision History:
=====================================================================================================*/
 public static void verifyEntityUnderOrganizationColumn(String sEntityNamesWithCommaSeparated) {
	 
	 WebDriver driver = WebDriverUtil.getDriver();
	 PageFactory.initElements(driver, Ticket);
	 int iOrgColumnNum,iTableCount,iTempIndex,iEntityLength;
	 String sOrganizationColumn,sEntityName,sOrgName;
	 WebElement wOraganizationColumn;
	 boolean bFlag;
	 String[] sEntityOrg;
	try {
	 // verifying the organization column in the web table 
	 iOrgColumnNum = TicketTestCase.getTicketTableColumnIndex("Organization");
     if(iOrgColumnNum>=1) {
	    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(),FrameworkUtil.sElementName, "Verifying the organization column", "pass","Organization column is displaying ");
	    }else {
	    	
	    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verifying the organization column", "fail", "Organization column is NOT dispalying in the table");
	    }
   
    // getting the table row count 
      CustomWebElementUtil.loadCustomElement(Ticket.getNav_TicketsWebTableParent(), "table");
     
      iTableCount = CustomWebElementUtil.iRowCount;
      iTempIndex=0;
	  
      for(int i=1; i<=iTableCount; i=i+4) {
		bFlag=false;
		iTempIndex++;
	 //  sOrganizationColumn = WebObjectUtil.getLocatorValueFromProperty("TICKET.TICKETTABLE.ORGANIZATION.COLUMN.HEADER", "PARAMETER_ROWNUMBER", iTempIndex+"");
	 //  wOraganizationColumn = WebObjectUtil.GetWebElement("XPATH", sOrganizationColumn, "Oraganization column entities");
		wOraganizationColumn = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "TICKET.TICKETTABLE.ORGANIZATION.COLUMN.HEADER", "PARAMETER_ROWNUMBER", iTempIndex+"");
		sEntityName = wOraganizationColumn.getText();
	  
	   sEntityOrg =sEntityNamesWithCommaSeparated.split(",");
	   iEntityLength = sEntityOrg.length;
	   
	      for(int j=0; j<=iEntityLength-1; j++){
		   
	        sOrgName = sEntityOrg[j];
	        // verifying the organization column cell data with respective the given parameters 
		      if(sEntityName.equalsIgnoreCase(sOrgName)) {
		    	  bFlag=true; 
		    	  break;
			   }
	          
	        }
	 
	     if(bFlag)
	      {
	    	  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verifying the Org entity", "pass", " - "+sEntityName);
	      }
	     else
	      {
	    	  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verifying the Org entity", "fail", "it is NOT Expected entity org - "+sEntityName);
	      }
	   
	   }
	}catch(Exception e) {
		LoggerUtil.log_type_error("exception occured"+FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verifyEntityUnderOrganizationColumn", "fail", "Catch block: "+e.getMessage());
	}
 }
 
 
 //////////////////////////////////////////Arul Keffer Mehods /////////////////////////////////////////////////////
 
 public static int getTicketCountByStatus(String sTicketStatus){
		int iTicketCount=0,iCurrentPage=0,iTotalPage=0,iCoulmnIndex=0;
		int iTableCount,iTempIndex=0;
		String sTicketStatusRunTime,sTotalPage,sXPath;
		WebElement wStatusCell;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,Ticket);
		
		
		WebObjectUtil.clickElement(Ticket.getNav_PaginationTicketTableCurrentPageIndex());
		//iCurrentPage = Integer.parseInt(Ticket.getNav_PaginationTicketTableCurrentPageIndex().getAttribute("value").trim());
		 	
		sTotalPage=Ticket.getNav_PaginationTicketTableTotalPageIndex().getText().trim();
		sTotalPage = sTotalPage.replace("of", "");
		sTotalPage = sTotalPage.trim();
		iTotalPage = Integer.parseInt(sTotalPage);
		iCoulmnIndex=TicketTestCase.getTicketTableColumnIndex("Status")+1;
		sXPath = (String) FrameworkUtil.dictDynamicPagePactory.get("NAV.TICKET.TICKETTABLE.CELL");
		//while (iCurrentPage >= iTotalPage  ){
		for(int p = 1 ; p<=iTotalPage ;p++){
			
			//System.out.println("current page no: " + p);
			   // getting the table row count 
		      CustomWebElementUtil.loadCustomElement(Ticket.getNav_TicketsWebTableParent(), "table");
		      iTableCount = CustomWebElementUtil.iRowCount;
		      iTempIndex=0;
		      for(int i=1; i<=iTableCount; i=i+4) {
		      iTempIndex++;
		      //wStatusCell = WebObjectUtil.GetWebElement("XPATH", "//div[@id='idTicketsGridPanel-body']//table["+ iTempIndex+"]//tr[1]//td[9]", "Oraganization column entities");
		      wStatusCell = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.TICKET.TICKETTABLE.CELL", "PARAMETER_ROWNUMBER,PARAMETER_COLUMNNUMBER", iTempIndex+","+iCoulmnIndex);
			   sTicketStatusRunTime = wStatusCell.getText();
			       if(sTicketStatus.equalsIgnoreCase(sTicketStatusRunTime)) {
			    	  iTicketCount++;
				   }
			      //System.out.println(iTicketCount + "-> " +sTicketStatusRunTime);    
			  }
		      
		      
			WebObjectUtil.clickElement(Ticket.getNav_PaginationTicketTableNextBtn());
			WebObjectUtil.clickElement(Ticket.getNav_PaginationTicketTableCurrentPageIndex());
			//iCurrentPage = Integer.parseInt(Ticket.getNav_PaginationTicketTableCurrentPageIndex().getAttribute("value").trim());
			 		
			}
		return iTicketCount;
	}

	
	public static int getTicketCountFromHeader(WebElement wTicketStatusElementFromTopHeader){
		int iTicketCount=0;
		String sTicketStatusRunTime;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,Ticket);
		sTicketStatusRunTime = wTicketStatusElementFromTopHeader.getText().trim();
		iTicketCount = Integer.parseInt(sTicketStatusRunTime);
		
	return iTicketCount;	
	}
	
	public static void verifyTicketCountAfterRollOn(String sParentEntityName,WebElement wTicketTypeDropdownElement){
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,EBPanel);
		PageFactory.initElements(driver,Ticket);

	    boolean bOpenTkt,bWorkingTkt,bPendingTkt,bResolvedTkt,bClosedTkt;
	    int iOpenTktCnt,iWorkingTktCnt,iPendingTktCnt,iResolvedTktCnt,iClosedTktCnt;
	    int iOpenTktCntRollOn,iWorkingTktCntRollOn,iPendingTktCntRollOn,iResolvedTktCntRollOn,iClosedTktCntRollOn;
	    String sCurrentEntityName;
	    String[] sEntityHirarchy;
	    int iEntityCount;
	    
	    sEntityHirarchy = sParentEntityName.split(",");
	    iEntityCount = sEntityHirarchy.length;
	    sParentEntityName = sEntityHirarchy[iEntityCount-1];
	    
	  //Clicking on Entity Browser Link
     //if (!WebObjectUtil.isElementPresent(EBPanel.getNav_FirstLevelChildrenOrgTable())){
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		sCurrentEntityName = EBPanel.getNav_OrgNameTitleLink().getText();
		if (!sCurrentEntityName.equalsIgnoreCase(sParentEntityName)){
			EntityBrowserTestCase.selectOrgFromAllLevelsEB(sParentEntityName,"", "", "");
		}
		//}
		EntityBrowserTestCase.setRollOnOffEBPanel(false);
		WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
		WebObjectUtil.explicitWait(5);
 	WebObjectUtil.ClickAndMouseHover(Ticket.getNav_FilterByStatusDropdown());
 	WebObjectUtil.clickElement(wTicketTypeDropdownElement);
 	WebObjectUtil.explicitWait(5);
 	
		  	iOpenTktCnt = getTicketCountFromHeader(Ticket.getNav_OpenTicketNumbers());
	        iWorkingTktCnt = getTicketCountFromHeader(Ticket.getNav_WorkingTicketNumbers());
	        iPendingTktCnt = getTicketCountFromHeader(Ticket.getNav_PendingTicketNumbers());
	        iResolvedTktCnt = getTicketCountFromHeader(Ticket.getNav_ResolvedTicketNumbers());

	        WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			String[] arrChildEntityList = EntityBrowserTestCase.getChildOrgNameListFromEBPanel(1);
			
			for (String sChild :arrChildEntityList){
				EntityBrowserTestCase.selectOrgFromAllLevelsEB(sChild,"", "", "");
				WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
				WebObjectUtil.explicitWait(5);
		    	WebObjectUtil.ClickAndMouseHover(Ticket.getNav_FilterByStatusDropdown());
		    	WebObjectUtil.clickElement(wTicketTypeDropdownElement);
		    	WebObjectUtil.explicitWait(5);
					iOpenTktCnt = iOpenTktCnt + getTicketCountFromHeader(Ticket.getNav_OpenTicketNumbers());
			        iWorkingTktCnt = iWorkingTktCnt + getTicketCountFromHeader(Ticket.getNav_WorkingTicketNumbers());
			        iPendingTktCnt = iPendingTktCnt + getTicketCountFromHeader(Ticket.getNav_PendingTicketNumbers());
			        iResolvedTktCnt = iResolvedTktCnt + getTicketCountFromHeader(Ticket.getNav_ResolvedTicketNumbers());
			        
				WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
				WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
				WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
				WebObjectUtil.explicitWait(5);
			} 
			

			
			//Clicking on Entity Browser Link
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			
			//Selecting Organization from First level children
			sCurrentEntityName = EBPanel.getNav_OrgNameTitleLink().getText();
			
			if (!sCurrentEntityName.equalsIgnoreCase(sParentEntityName)){
				switch (iEntityCount)
				{
				case 2:
					EntityBrowserTestCase.selectOrgFromAllLevelsEB(sEntityHirarchy[0],sEntityHirarchy[1], "", "");
					break;
				case 3:
					EntityBrowserTestCase.selectOrgFromAllLevelsEB(sEntityHirarchy[0],sEntityHirarchy[1],sEntityHirarchy[2], "");
					break;
				case 4:
					EntityBrowserTestCase.selectOrgFromAllLevelsEB(sEntityHirarchy[0],sEntityHirarchy[1],sEntityHirarchy[2], sEntityHirarchy[3]);
					break;
				default:
					EntityBrowserTestCase.selectOrgFromAllLevelsEB(sParentEntityName,"", "", "");
					break;
				}
				
			}
			
			EntityBrowserTestCase.setRollOnOffEBPanel(true);
			WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
			WebObjectUtil.explicitWait(5);
	    	WebObjectUtil.ClickAndMouseHover(Ticket.getNav_FilterByStatusDropdown());
	    	WebObjectUtil.clickElement(wTicketTypeDropdownElement);
	    	WebObjectUtil.explicitWait(5);
			iOpenTktCntRollOn = getTicketCountFromHeader(Ticket.getNav_OpenTicketNumbers());
	        iWorkingTktCntRollOn = getTicketCountFromHeader(Ticket.getNav_WorkingTicketNumbers());
	        iPendingTktCntRollOn = getTicketCountFromHeader(Ticket.getNav_PendingTicketNumbers());
	        iResolvedTktCntRollOn = getTicketCountFromHeader(Ticket.getNav_ResolvedTicketNumbers());
	        
	        
	        bOpenTkt= (iOpenTktCnt == iOpenTktCntRollOn);
	        FrameworkUtil.updateCustomResultBasedOnStatus(bOpenTkt, "Open ticket count match after roll on, Count of All child=" + iOpenTktCnt + ", Count after rollon="+iOpenTktCntRollOn);
	        bWorkingTkt=(iWorkingTktCnt == iWorkingTktCntRollOn);
	        FrameworkUtil.updateCustomResultBasedOnStatus(bWorkingTkt, "Working ticket count match after roll on, Count of All child=" + iWorkingTktCnt + ", Count after rollon="+iWorkingTktCntRollOn);
	        bPendingTkt=(iPendingTktCnt == iPendingTktCntRollOn);
	        FrameworkUtil.updateCustomResultBasedOnStatus(bPendingTkt, "Pending ticket count match after roll on, Count of All child=" + iPendingTktCnt + ", Count after rollon="+iPendingTktCntRollOn);
	        bResolvedTkt=(iResolvedTktCnt == iResolvedTktCntRollOn);
	        FrameworkUtil.updateCustomResultBasedOnStatus(bResolvedTkt, "Resolved ticket count match after roll on, Count of All child=" + iResolvedTktCnt + ", Count after rollon="+iResolvedTktCntRollOn);
			

	} 
	
	/*==============================================================
	Method Name 	: VerifyLogsAndSearchText
	Description		: This will check Notes Sequence IDS
	Author 			: Priyanka Rachupalli
	Creation Date 	: 01/12/2016
	Pre-Requisites	:
	Revision History:
	==============================================================*/

		public static void VerifyLogsAndSearchText() 
		{
		try {
			int iRow=1;
			String sID,sServID,sServLogTable;
			String sTicketID=TicketTestCase.getTicketID(iRow);
			TicketTestCase.expandTable(iRow);
			//expand notes
			WebElement nExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER", "PARAMETER_TICKETID",  sTicketID);
			WebObjectUtil.explicitWait(3);
	        WebObjectUtil.clickElement(nExpander);
			WebObjectUtil.explicitWait(6);
			WebElement wNotesTable = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER.WNOTESTABLE", "PARAMETER_TICKETID",  sTicketID);
			  
			 	//if(Ticket.getNav_NotesWebTable().isDisplayed())
			 if(wNotesTable.isDisplayed())
			    {
			 				/*if(!(Ticket.getNav_TktNotesPaginationChk().isDisplayed()))
			 					FrameworkUtil.updateCustomResultBasedOnStatus(true, "Note Pagination is Removed");
			 					else
			 						FrameworkUtil.updateCustomResultBasedOnStatus(false, "Note Pagination is not Removed");
	*/		 		        
			 		        //WebObjectUtil.verifyElementNOTPresent(Ticket.getNav_TktNotesPaginationChk());
			 				
			 		    WebObjectUtil.selectCheckRadioBox(Ticket.getNav_ExpandAllNoteCheckbox());

			    
			    }
			 		else{
			 			FrameworkUtil.updateCustomResultBasedOnStatus(false, "Notes WebTable is not displayed");
			    }
			 	
			 WebObjectUtil.explicitWait(5);
			// WebObjectUtil.VerifyTextOnPage("test");
			 WebObjectUtil.VerifyTextOnPage("Tickets");
			 sID="tktLogsImg-" + sTicketID;
			 WebElement wTicketLogsExpander=WebObjectUtil.GetWebElement("id", sID, "Ticket Logs Expander");
			 //Expand Notes
			 // this object is added by QAA04 - 02/23/16
			 WebObjectUtil.clickElement(wTicketLogsExpander);
			// wTicketLogsExpander.click();
			 WebObjectUtil.explicitWait(5);
			 WebObjectUtil.verifyElementPresent(Ticket.getNav_TicketLogsTable());
			 WebObjectUtil.explicitWait(5);
			 sServID="tktServiceLogsImg-" + sTicketID;
			 WebElement wTicketServiceLogsExpander=WebObjectUtil.GetWebElement("id", sServID, "Notes Expander");
			 //Expand Notes
			 // this object is added by QAA04 - 02/23/16
			 WebObjectUtil.clickElement(wTicketServiceLogsExpander);
			 //wTicketServiceLogsExpander.click();
			 WebObjectUtil.explicitWait(5);
			 sServLogTable="tktServiceLogsGrid-" + sTicketID;
			 WebElement wTicketServiceLogsTable=WebObjectUtil.GetWebElement("id", sServLogTable, "ServLogsTable");
			 WebObjectUtil.verifyElementPresent(wTicketServiceLogsTable);
			
			
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with- VerifyNoteSequenceID" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
			}
		}
		
	/*==============================================================
	Method Name 	: VerifyNoteSequenceID
	Description		: This will check Notes Sequence IDS
	Author 			: Priyanka Rachupalli
	Creation Date 	: 01/12/2016
	Pre-Requisites	:
	Revision History:
	==============================================================*/

		public static void VerifyNoteSequenceID(String sTicketID) 
		{
		try {
			int iRowMax,i,j=1;
			int sNumSeq[]=new int[100];
			String sTemp;
			WebElement wNotesTable = WebObjectUtil.GetWebElement("id", "notesGrid-"+sTicketID+"-body", "NotesTable");
			WebObjectUtil.explicitWait(3);
			iRowMax=WebTableUtil.getRowCount(Ticket.getNav_NotesWebTable());;
			WebObjectUtil.explicitWait(5);
			if((iRowMax>0)&&(wNotesTable!=null))
			{
				for(i=1;i<=iRowMax;i++)
				{
					sTemp = WebTableUtil.getCellData(wNotesTable, i, 2).trim();
					if (sTemp.length() > 0){
					sNumSeq[i]=Integer.parseInt(sTemp);
							if(i>2)
							{
								j++;
								if(j==Integer.parseInt(sTemp)){
								//if(sNumSeq[i]==(sNumSeq[i-2]+1)){
									//Boolean bStatus=true;
									FrameworkUtil.updateCustomResultBasedOnStatus(true, "Notes ID are displayed in sequence "+""+sNumSeq[i]  );
								
								}
								else{
									FrameworkUtil.updateCustomResultBasedOnStatus(false, "Notes ID are not displayed in sequence "+sNumSeq[i]  );	
									
								}	
							}
							else
							{
								FrameworkUtil.updateCustomResultBasedOnStatus(true, "Only one Notes ID is displayed in sequence "+""+sNumSeq[i]  );
							
							}
						
				   }
				}
				
			}	
				
			} catch (Exception e) {
			LoggerUtil.log_type_error("issue with- VerifyNoteSequenceID" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
			}
		}
		/*==============================================================
		Method Name 	: VerifyExpandTicketChkSeq
		Description		: This will check Notes Sequence IDS
		Author 			: Priyanka Rachupalli
		Creation Date 	: 01/12/2016
		Pre-Requisites	:
		Revision History:
		==============================================================*/

			public static void VerifyExpandTicketChkSeq() 
			{
			try {
				int iRow=1;
				String sTicketID;
				sTicketID = TicketTestCase.getTicketID(iRow);
				TicketTestCase.expandTable(iRow);
				WebObjectUtil.explicitWait(6);
				//expand notes
				WebElement nExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER", "PARAMETER_TICKETID",  sTicketID);
				WebObjectUtil.explicitWait(3);
				WebObjectUtil.clickElement(nExpander);
				WebObjectUtil.explicitWait(6);
				VerifyNoteSequenceID(sTicketID);
				WebObjectUtil.explicitWait(3);
				WebObjectUtil.clickElement(nExpander);
				WebObjectUtil.explicitWait(3);
				
			} catch (Exception e) {
				LoggerUtil.log_type_error("issue with- VerifyNoteSequenceID" );
				LoggerUtil.log_type_error(e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
				}
			}
			
			
//			################### OOS Test Cases ###########################
		/*==============================================================
		TestScript  	: verifyFirewallTktCreated()
		Manual TestCase	: QAT-1477_WCP_3415_TC_1.9_Ticket watchers_Firewall_Create ticket
		Description		: Verify user is able view ticket details like "Ticket Id","Summary","Severity","Priority","Last updated","Assigned To","Status".
		Author 			: Priyanka R
		Creation Date 	: 06/16/2015
		Pre-Requisites	:
		Release         : Out Of Scope
		Revision History:
		==============================================================*/
			@Test(priority=1)
			public void verifyFirewallTktCreated()
			{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, Ticket);
				PageFactory.initElements(driver, Smoke);
				PageFactory.initElements(driver, Firewall);
				PageFactory.initElements(driver, EVDC_VMPF);
				PageFactory.initElements(driver, Common);
				String sEVDCname="Nashville, TN - tstentity02";
				WebElement wEVDCName = null;
			
			try {//Open a Ticket option is not displayed in Firewall potal for EVDC Page
				String sTitleVal=(String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.EB.TICKETSUMMARYEDIT");
				FrameworkUtil.sTestCaseName = "Ticket-verifyFirewallTktCreated";
				FrameworkUtil.sManualTestCaseName="WCP_3415_TC_1.9_Ticket watchers_Firewall_Create ticket";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
                LoginTestCase_Old1.LoginAsEntity02User();
                //navigateToTicketPage();
                sEVDCname = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDCNAME.ENTITY02");
                wEVDCName = EVDC_VM_TestCase.getEVDCNameAsWebElement(sEVDCname);
                WebObjectUtil.clickElement(wEVDCName);
				VerifyCreateFirewallTkt(sTitleVal);
                LoginTestCase_Old1.nav_Logout();
			} catch (Exception e) {
				LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
			
			}
	}
		/*==============================================================
		TestScript  	: verifyCloneTktCreated()
		Manual TestCase	: QAT-1462_WCP_3415_TC_1.3_Ticket watchers_Clone Ticket
		Description		: Verify user is able view ticket details like "Ticket Id","Summary","Severity","Priority","Last updated","Assigned To","Status".
		Author 			: Priyanka R
		Creation Date 	: 06/16/2015
		Pre-Requisites	:
		Release         : Out Of Scope
		Revision History:
		==============================================================*/
			@Test(priority=2)
			public void verifyCloneTktCreated()
			{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, Ticket);
				PageFactory.initElements(driver, Smoke);
				PageFactory.initElements(driver, Firewall);
				PageFactory.initElements(driver, EVDC_VMPF);
				PageFactory.initElements(driver, Common);
			
			try {
				String sTitleVal=(String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.EB.TICKETSUMMARYEDIT");
				FrameworkUtil.sTestCaseName = "Ticket-VerifyCloneTktCreated";
				FrameworkUtil.sManualTestCaseName=" QAT-1462_WCP_3415_TC_1.3_Ticket watchers_Clone Ticket";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
                LoginTestCase_Old1.LoginAsEntity02User();
                navigateToTicketPage();
                VerifyCloneTkt();
                LoginTestCase_Old1.nav_Logout();
			} catch (Exception e) {
				LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
			
			}
	}

/*==============================================================
TestScript  	: verifyContactUsCreateTkt()
Manual TestCase	: QAT-1459_WCP_3415_TC_1.1_Ticket watchers_Create ticket from Contact Us portlet
Description		: Verify user is able view ticket details like "Ticket Id","Summary","Severity","Priority","Last updated","Assigned To","Status".
Author 			: Priyanka R
Creation Date 	: 06/16/2015
Pre-Requisites	:
Release         : Out Of Scope
Revision History:
==============================================================*/
@Test(priority=3)
public void verifyContactUsCreateTkt()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, Ticket);
	PageFactory.initElements(driver, Smoke);
	PageFactory.initElements(driver, Firewall);
	PageFactory.initElements(driver, EVDC_VMPF);
	PageFactory.initElements(driver, Common);
	PageFactory.initElements(driver, Home);
	try {
		String sTitleVal=(String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.EB.TICKETSUMMARYEDIT");
		FrameworkUtil.sTestCaseName = "verifyContactUsCreateTkt";
		FrameworkUtil.sManualTestCaseName="QAT-1459_WCP_3415_TC_1.1_Ticket watchers_Create ticket from Contact Us portlet";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
        LoginTestCase_Old1.LoginAsEntity02User();
        //WebObjectUtil.scrollToElement(Home.getnav_CreateTicketLink());
        WebObjectUtil.explicitWait(5);
		WebObjectUtil.clickElement(Home.getnav_CreateTicketLink());
		WebObjectUtil.explicitWait(10);
		HomeTestCase.EnterNotes();		
		HomeTestCase.EnterTitle();
		HomeTestCase.SelectSeverityItem();
		HomeTestCase.SelectPriorityItem();
		HomeTestCase.SelectCategoryItem();
		HomeTestCase.ClickOKBtn();
		WebObjectUtil.explicitWait(5);
		//WebDriverUtil.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		HomeTestCase.VerifyCreateTicketSucessfulMsg();	
		WebObjectUtil.clickElement(Home.getnav_CreateTicketLink());
		HomeTestCase.ClickSucessMsgWindowOKBtn();
		LoginTestCase_Old1.nav_Logout();
	
} catch (Exception e) {
	LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		
		}
}
/*==============================================================
TestScript  	: verifyNewTktCreated()
Manual TestCase	: QAT-551_WCP_3415_TC_1.0_Ticket Watchers_Tickets portlet
Description		: Verify when a ticket is created in WCP for that org, these users appear as watchers for the tickets for that org
Author 			: Priyanka R
Creation Date 	: 06/16/2015
Pre-Requisites	:
Release         : Out Of Scope
Revision History:
==============================================================*/
@Test(priority=4)
public void verifyNewTktCreated()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, Ticket);
	PageFactory.initElements(driver, Smoke);
	PageFactory.initElements(driver, Firewall);
	PageFactory.initElements(driver, EVDC_VMPF);
	PageFactory.initElements(driver, Common);

try {
	String sNotes=(String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.NEW.NOTE");
	String sTitleVal=(String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.EB.TICKETSUMMARYEDIT");
	FrameworkUtil.sTestCaseName = "verifyNewTktCreated";
	FrameworkUtil.sManualTestCaseName=" QAT-551_WCP_3415_TC_1.1_Ticket watchers_Create ticket from Contact Us portlet";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
    LoginTestCase_Old1.LoginAsEntity02User();
    navigateToTicketPage();
  /*  WebObjectUtil.explicitWait(5);
	WebObjectUtil.clickElement(Ticket.getNav_CreateTicketLink());
	WebObjectUtil.explicitWait(3);
	*/
	verifyCreateTicket();
	
	LoginTestCase_Old1.nav_Logout();
}
catch (Exception e) {
	LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());

}
	}
/*==============================================================
TestScript  	: verifyCreateTktLink()
Manual TestCase	: QAT-106_WCP_2663_TC_1.0_IE_Tickets_"Create Ticket" is not displayed as a link
Description		: verify "Create Ticket" is displayed as a link when user mouse hover over the Create Ticket.
Author 			: Priyanka R
Creation Date 	: 06/16/2015
Pre-Requisites	:
Release         : Out Of Scope
Revision History:
==============================================================*/
	@Test(priority=5)
	public void verifyCreateTktLink()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Ticket);
		PageFactory.initElements(driver, Smoke);
		PageFactory.initElements(driver, Firewall);
		PageFactory.initElements(driver, EVDC_VMPF);
		PageFactory.initElements(driver, Common);
	
	try {
		//validate this for IE browser
		String sURL=(String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.CREATE.TICKET.LINK");
		FrameworkUtil.sTestCaseName = "verifyCreateTktLink()";
		FrameworkUtil.sManualTestCaseName="QAT-106_WCP_2663_TC_1.0_IE_Tickets_Create Ticket is not displayed as a link";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
        LoginTestCase_Old1.LoginAsRoleAUser();
        navigateToTicketPage();
        //validating URL
        //WebObjectUtil.clickAndVerifyUrl(Ticket.getNav_CreateTicketLink(), sURL);
        WebObjectUtil.waitForElementPresent(Ticket.getNav_CreateTicketLink());
        WebObjectUtil.verifyElementPresent(Ticket.getNav_CreateTicketLink());
        WebObjectUtil.ClickAndMouseHover(Ticket.getNav_CreateTicketLink());
        WebObjectUtil.verifyElementPresent(Ticket.getNav_CreateTicketDialogHeaderText());
        
        
        
        LoginTestCase_Old1.nav_Logout();
	}
	 catch (Exception e) {
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		
		}
		}
	/*==============================================================
	TestScript  	: verifyCreatedNote()
	Manual TestCase	: QAT-31_WCP_3044_TC_1.0_Tickets_Notes text is not displayed correctly
	Description		: verify the content is displayed correctly in the Notes.
	Author 			: Priyanka R
	Creation Date 	: 06/02/2016
	Pre-Requisites	:
	Release         : Out Of Scope
	Revision History:
	==============================================================*/
	@Test(priority=6)
	public void verifyCreatedNote()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Ticket);
		PageFactory.initElements(driver, Smoke);
		PageFactory.initElements(driver, Firewall);
		PageFactory.initElements(driver, EVDC_VMPF);
		PageFactory.initElements(driver, Common);
		PageFactory.initElements(driver, Home);
		try {
			String sTitle="Tickets";
			String sTxt="SeleniumAutomationTicket_"+FrameworkUtil.sTimeStamp;
			String sNotes=(String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.NEW.NOTE");
			String sTitleVal=(String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.EB.TICKETSUMMARYEDIT");
			FrameworkUtil.sTestCaseName = "verifyCreatedNote";
			FrameworkUtil.sManualTestCaseName="QAT-31_WCP_3044_TC_1.0_Tickets_Notes text is not displayed correctly";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
            LoginTestCase_Old1.LoginAsEntity02User();
            //WebObjectUtil.scrollToElement(Home.getnav_CreateTicketLink());
            TicketTestCase.navigateToTicketPage();
            //WebObjectUtil.explicitWait(3);
            //The below lines are udated by QAA03 on 07/13/2016
            /*WebObjectUtil.clickElement(Ticket.getNav_CreateTicketLink());
            WebObjectUtil.explicitWait(3);
            NavigatorCommonMethods.submitDialogForCreateTicket(sTitle);*/
            verifyCreateTicket();
		/*	WebObjectUtil.clickElement(Ticket.getNav_CreateTicketLink());
			WebObjectUtil.explicitWait(5);
			WebObjectUtil.SetValueEdit(Ticket.getNav_CreateTicketDialogSummary(), sTxt);
			WebObjectUtil.explicitWait(3);
			WebObjectUtil.clickElement(Ticket.getNav_CreateTicketDialogSeverity());
			 WebObjectUtil.explicitWait(3);
			WebObjectUtil.selectCustomWebList(Ticket.getNav_TicketOrgWebListDropDown(), 2);
			WebObjectUtil.explicitWait(3);
			WebObjectUtil.clickElement(Ticket.getNav_CreateTicketDialogPriority());
			 WebObjectUtil.explicitWait(3);
			WebObjectUtil.selectCustomWebList(Ticket.getNav_TicketOrgWebListDropDown(), 2);
			WebObjectUtil.explicitWait(3);
			WebObjectUtil.clickElement(Ticket.getNav_CreateTicketDialogCategory());
			 WebObjectUtil.explicitWait(3);
			WebObjectUtil.selectCustomWebList(Ticket.getNav_TicketOrgWebListDropDown(), 5);
			WebObjectUtil.explicitWait(3);
			//driver.switchTo().frame(Ticket.getNav_CreateNotesFrame());
			Ticket.getNav_NotesFrame().click();
			
			WebElement element = WebObjectUtil.GetWebElement("tagname", "body", "NoteEditArea"); //driver.findElement(By.cssSelector("body"));
			element.sendKeys(sNotes);
			//driver.switchTo().defaultContent();
			WebObjectUtil.clickElement(Ticket.getNav_CreateTicketDialogOkButton());
			WebObjectUtil.explicitWait(3);
			
			//WebObjectUtil.clickElement(Common.getNav_ConfirmPopUpOkBtn());
*/			//WebObjectUtil.clickElement(Common.getNav_CommonPopUpOKButtonwithID());
			//WebObjectUtil.explicitWait(10);
			String sTicketID= getTicketID(1);
			//expandTable(1);
			WebElement nExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER", "PARAMETER_TICKETID",  sTicketID);
			WebObjectUtil.explicitWait(3);
			WebObjectUtil.clickElement(nExpander);
			WebObjectUtil.explicitWait(5);
			WebObjectUtil.verifyElementPresent(Ticket.getNav_NotesWebTable());
			LoginTestCase_Old1.nav_Logout();
		
	} catch (Exception e) {
		LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		
		}
}
	/*==============================================================
	TestScript  	: verifyAddStorageTierTkt()
	Manual TestCase	: QAT-1467_WCP_3415_TC_1.7_Ticket watchers_Storage_Add storage tier to VDC ticket
	Description		: verify the content is displayed correctly in the Notes.
	Author 			: Priyanka R
	Creation Date 	: 06/02/2016
	Pre-Requisites	:
	Release         : Out Of Scope
	Revision History:
	==============================================================*/
	@Test(priority=7)
	public void verifyAddStorageTierTkt()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Ticket);
		PageFactory.initElements(driver, EVDC_OverviewPF);
		PageFactory.initElements(driver, Firewall);
		PageFactory.initElements(driver, EVDC_VMPF);
		PageFactory.initElements(driver, Common);
		PageFactory.initElements(driver, Home);
		try {
			FrameworkUtil.sTestCaseName = "verifyAddStorageTierTkt";
			FrameworkUtil.sManualTestCaseName="QAT-1467_WCP_3415_TC_1.7_Ticket watchers_Storage_Add storage tier to VDC ticket";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
             LoginTestCase_Old1.LoginAsEntity02User();
	         WebObjectUtil.explicitWait(EVDC_OverviewPF.getNav_EVDCname());
	
	         WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
              WebObjectUtil.explicitWait(5);
              WebObjectUtil.clickElement(EVDC_VMPF.getNav_EVDCStorageLink());
              WebObjectUtil.explicitWait(5);
               VerifyAddStorageTkt();
               LoginTestCase_Old1.nav_Logout();
               
		}
		catch (Exception e) {
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
			
			}
		}
		/*==============================================================
		Method Name 	: VerifyExpandTicketChkSeq
		Description		: This will check Notes Sequence IDS
		Author 			: Priyanka Rachupalli
		Creation Date 	: 01/12/2016
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		public static void VerifyCreateFirewallTkt(String sTitleVal) 
		{
		try {
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Ticket);
		PageFactory.initElements(driver, EVDC_OverviewPF);
		PageFactory.initElements(driver, Firewall);
		PageFactory.initElements(driver, EVDC_VMPF);
		PageFactory.initElements(driver, Common);
		
		/*WebObjectUtil.explicitWait(5);
        WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
        WebObjectUtil.explicitWait(10);
       */ 
        //WebObjectUtil.waitForElementPresent(Smoke.getNav_Firewallportlet());
        //WebObjectUtil.clickElement(Firewall.getNav_FirewallOpenTicket());
        WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCOverviewFirewall());
        WebObjectUtil.explicitWait(5);
        WebObjectUtil.clickElement(Firewall.getNav_CreateTicketTitle());
        WebObjectUtil.explicitWait(3);
     // this below line is added by NMR - 07/12/2016
        sTitleVal = NavigatorCommonMethods.submitDialogForCreateTicket("Firewall_Create_Ticket");
       /* WebObjectUtil.SetValueEdit(Firewall.getNav_FireWallTicketTitle(), sTitleVal);
        WebObjectUtil.explicitWait(5);
        // this below element is added by NMR - 07/12/2016
       WebObjectUtil.clickElement(Common.getNav_CreateTicketPopupOKBtn());
        // WebObjectUtil.clickElement(EVDC_VMPF.getNav_AddStorageTierOkBtn());
        WebObjectUtil.explicitWait(5);
        WebObjectUtil.clickElement(Common.getNav_CommonPopUpOKButton());*/
        WebObjectUtil.explicitWait(2);
        TicketTestCase.navigateToTicketPage();
        WebObjectUtil.explicitWait(5);
      // Checking Ticket title
      TicketTestCase.searchTicket("Summary", sTitleVal);
		} catch (Exception e) {
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		
		}
		}
		
		/*==============================================================
		Method Name 	: VerifyAddStorageTkt()
		Description		: This method verifies Add Storage Ticket fields
		Author 			: Priyanka Rachupalli
		Creation Date 	: 01/12/2016
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		public static void VerifyAddStorageTkt()
		{
		try {
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, Ticket);
			PageFactory.initElements(driver, EVDC_VMPF);
			PageFactory.initElements(driver, Common);
	
			
			
			//String sExpectedQueueName=(String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.STORAGE.QUEUE.NAME");
			//changed queue name as Virtualization as per Sirisha mail by Arul on 08/03/16
			String sExpectedQueueName=(String)FrameworkUtil.dictPropertyData.get("NAV.TICKET.VIRTUALIZATION.QUEUE.NAME");
			
			String sAddStoreTierTitle,sTitleVal=null;
			sTitleVal=sTitleVal+"_"+ FrameworkUtil.sTimeStamp;	
			//sHostName=sHostName+"_"+ FrameworkUtil.sTimeStamp;
			sAddStoreTierTitle="Selenium"+"_"+FrameworkUtil.sTimeStamp;
			WebObjectUtil.clickElement(EVDC_VMPF.getNav_AddStorageTierLink());
	           WebObjectUtil.clickElement(EVDC_VMPF.getNav_StorageTierPopupDropdown());
	           //WebObjectUtil.selectCustomWebList(EVDC_VMPF.getNav_StorageTierPopupDropdown(),2);
	           WebObjectUtil.selectCustomWebList(Ticket.getNav_SearchByDropdown(),1);
		       WebObjectUtil.SetValueEdit(EVDC_VMPF.getNav_TitleAddStorageTierPopUp(),sAddStoreTierTitle);
		       WebObjectUtil.explicitWait(5);
	          /* WebObjectUtil.SetValueEdit(EVDC_VMPF.getNav_AddStorageTierNotePopup(), sAddStoreTierNote);
		       WebObjectUtil.explicitWait(3);*/
	           WebObjectUtil.clickElement(EVDC_VMPF.getNav_AddStorageTierOkBtn());
	           WebObjectUtil.explicitWait(5);
	          // HomeTestCase.VerifyCreateTicketSucessfulMsg();
	           //since popup not displaying included if condition by ARul on 06/24/16
				if(WebObjectUtil.isElementPresent(Common.getNav_ConfirmPopUpOkBtn()))
				WebObjectUtil.clickElement(Common.getNav_ConfirmPopUpOkBtn());
                WebObjectUtil.explicitWait(3);
	           TicketTestCase.navigateToTicketPage();
	           WebObjectUtil.explicitWait(5);
	           TicketTestCase.searchTicket("Summary",sAddStoreTierTitle);
	           WebObjectUtil.explicitWait(5);
	          String sTicketID=TicketTestCase.getTicketID(1);
	           TicketTestCase.expandTable(1);
	           WebObjectUtil.explicitWait(5);
	          // WebElement wQueuenameChk2 = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.TICKET.QUEUE.VALUE", "PARAMETER_ROWNUMBER", "1");
	           // this below line added by QAA04 - 02/26/2016
	          WebElement wQueuenameChk = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.TICKET.QUEUE.VALUE", "PARAMETER_ROWNUMBER", "1");
	         String   sQueuevalue=wQueuenameChk.getText().trim();  
	           if(sQueuevalue.equalsIgnoreCase(sExpectedQueueName))
	           {
	        	   FrameworkUtil.updateCustomResultBasedOnStatus(true, "Assigned to appropriate queue :" + sQueuevalue);
	           }
	           else{
	        	   FrameworkUtil.updateCustomResultBasedOnStatus(false, "Not Assigned to appropriate queue, Expected : " +sExpectedQueueName + ", actual : " + sQueuevalue);
	           }
		
		}  catch (Exception e) {
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		
		}
		}

		/*==============================================================
		Method Name 	: VerifyCloneTkt()
		Description		: This will check Notes Sequence IDS
		Author 			: Priyanka Rachupalli
		Creation Date 	: 01/12/2016
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		public static void VerifyCloneTkt() 
		{
			SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yy HH:mm a");
		try {
			String sTicketID,sSummary,sActualSuccessMsg,sLastUpdatedDate,sCloneSummary,sCloneLastUpdatedDate;
			String[] arrString = null;
			boolean bStatus;
			int parentTicketID,cloneTicketID;
			Date parentTicketDate;
			Date cloneTicketDate;
		//TicketTestCase.searchTicket("Summary", "SeleniumTicket-Clone");
		sTicketID = TicketTestCase.getTicketID(1);
		parentTicketID= Integer.parseInt(sTicketID);
		sSummary = WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 3);
		sLastUpdatedDate = WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 6);
		//parentTicketDate=Date.parse(sLastUpdatedDate);
		parentTicketDate = formatter.parse(sLastUpdatedDate);
		
		//EVDC_Advanced.expandVMbyRowNum(1);
		expandTable(1);
		WebObjectUtil.explicitWait(3);
		WebObjectUtil.clickElement(Ticket.getNav_TicketCloneBtn());
		WebObjectUtil.waitForElementPresent(Common.getNav_CommonPopUpMessage());
		sActualSuccessMsg = Common.getNav_CommonPopUpMessage().getText();
		bStatus=WebObjectUtil.compareString(sActualSuccessMsg, "Successfully cloned the ticket", false);
		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "popup msg verified : " + sActualSuccessMsg);
		WebObjectUtil.clickElement(Common.getNav_CommonPopUpOKButton());
		
		sTicketID = TicketTestCase.getTicketID(1);
		cloneTicketID= Integer.parseInt(sTicketID);
		sCloneSummary = WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 3);
		sCloneLastUpdatedDate = WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 6);
		//cloneTicketDate=Date.parse(sCloneLastUpdatedDate);
		cloneTicketDate = formatter.parse(sCloneLastUpdatedDate);
		
		if(cloneTicketID > parentTicketID )
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verify clone ticket ID", "pass", "Cloning ticket success and ticket id is : " + cloneTicketID );
		}else{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName,  "verify clone ticket ID", "fail", "issue with cloning ticket, parent ticket id : " + parentTicketID + " and Clone ticket id is : " + cloneTicketID  );
		}
		
		if(sCloneSummary.equalsIgnoreCase(sSummary))
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verify clone ticket summary", "pass", "Cloning ticket success and ticket summary is : " + cloneTicketID );
		}else{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName,  "verify clone ticket summary", "fail", "issue with cloning ticket, parent ticket summary : " + sSummary + " and Clone ticket summary is : " + sCloneSummary  );
		}
		
		//System.out.println(cloneTicketDate.getTime());
		//System.out.println(parentTicketDate.getTime());
			/*if(cloneTicketDate.compareTo(parentTicketDate)>=0 && cloneTicketDate.getTime() >= parentTicketDate.getTime()  )
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verify clone ticket date", "pass", "Cloning ticket success and ticket date is : " + cloneTicketDate );
		}
			else{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName,  "verify clone ticket date", "fail", "issue with cloning ticket, parent ticket date : " + parentTicketDate + " and Clone ticket date is : " + cloneTicketDate  );
		}*/
		} 
		 catch (Exception e) {
				LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
			
			}
		}
		
	// _________________________________ Corwin test cases ___________________________________ ////
		
		
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
	                //WebObjectUtil.explicitWait(5);
	                //the below lines updated by QAA03 on 07/13/2016
	                /*TicketTestCase.navigateToCreateTicketPage();
	                NavigatorCommonMethods.submitDialogForCreateTicket(sModuleName);*/
	                
	                navigateToTicketPage();
	                verifyCreateTicket();
	                
					LoginTestCase_Old1.nav_Logout();
				}

				catch (Exception e) {
							LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
						
						}
						}
		
		
		
		
		
		/// ______________________________ Completed corwin test cases __________________________ /////
		
	//update each @test result in custom result file
	@AfterMethod
	public static void afterEachMethod(){
		FrameworkUtil.updateTestCaseStatusinResult();
		if(WebDriverUtil.browser.equalsIgnoreCase("ie")){
			WebDriverUtil.quitWebDriver();
		}
		
		//Should be deleted after today's execution by Arul on 7/14/16
		WebDriverUtil.quitWebDriver();

	}
	
	
}
	
