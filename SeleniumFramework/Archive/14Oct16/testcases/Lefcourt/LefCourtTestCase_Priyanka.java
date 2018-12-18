package com.whs.navigator.testcases.Lefcourt;
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

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;

public class LefCourtTestCase_Priyanka {
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
			PageFactory.initElements(driver, FireWall);
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
				String sAddStoreTierNote=(String)FrameworkUtil.dictPropertyData.get("NAV.STORAGE.TIER.NOTE");
				String sRemoveSCR=(String)FrameworkUtil.dictPropertyData.get("NAV.REMOVE.S2CR.SUMMARY");
				sTitleVal=sTitleVal+"_"+ FrameworkUtil.sTimeStamp;	
				//sHostName=sHostName+"_"+ FrameworkUtil.sTimeStamp;
				sAddStoreTierTitle="Selenium"+"_"+FrameworkUtil.sTimeStamp;
				
				//Login to Navigator Portlet
				LoginTestCase_Old1.nav_Login(sUserName,sPassword);
				
				WebObjectUtil.explicitWait(5);
	             WebObjectUtil.clickElement(Smoke.getNav_PrivateEVDC());
	             WebObjectUtil.explicitWait(5);
	             
	             //WebObjectUtil.waitForElementPresent(Smoke.getNav_Firewallportlet());
	             WebObjectUtil.clickElement(FireWall.getNav_FirewallOpenTicket());
	             WebObjectUtil.SetValueEdit(FireWall.getNav_FireWallTicketTitle(), sTitleVal);
	             WebObjectUtil.clickElement(EVDC_VMPF.getNav_AddStorageTierOkBtn());
	             WebObjectUtil.explicitWait(5);
	             WebObjectUtil.clickElement(Common.getNav_CommonPopUpOKButton());
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
	        	   FrameworkUtil.updateCustomResultBasedOnStatus(true, "Assigned to appropriate queue");
	           }
	           else{
	        	   FrameworkUtil.updateCustomResultBasedOnStatus(false, "Not Assigned to appropriate queue");
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
			   sQueuevalue=wQueuenameChk.getText().trim();  
	           if(sQueuevalue.equalsIgnoreCase(sActualQueueValue1))
	           {
	        	   FrameworkUtil.updateCustomResultBasedOnStatus(true, "Assigned to appropriate queue");
	           }
	           else{
	        	   FrameworkUtil.updateCustomResultBasedOnStatus(false, "Not Assigned to appropriate queue");
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
			   sQueuevalue=wQueuenameChk.getText().trim();  
	           if(sQueuevalue.equalsIgnoreCase(sActualQueueValue2))
	           {
	        	   FrameworkUtil.updateCustomResultBasedOnStatus(true, "Assigned to appropriate queue");
	           }
	           else{
	        	   FrameworkUtil.updateCustomResultBasedOnStatus(false, "Not Assigned to appropriate queue");
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
	        	   FrameworkUtil.updateCustomResultBasedOnStatus(true, "Assigned to appropriate queue");
	           }
	           else{
	        	   FrameworkUtil.updateCustomResultBasedOnStatus(false, "Not Assigned to appropriate queue");
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
			String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.USERID");
			
			String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.PASSWORD");
			
			String sLongNotes = (String)FrameworkUtil.dictPropertyData.get("NAV.LEFCOURT.TICKET.LONG.NOTES");
			//Login to Navigator Portlet
			LoginTestCase_Old1.nav_Login(sUserName,sPassword);
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
			WebElement wNotesTable = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.NOTES.EXPANDER.WNOTESTABLE", "PARAMETER_TICKETID",  sTicketID);
			  
		 	//if(Ticket.getNav_NotesWebTable().isDisplayed())
		 if(wNotesTable!=null)
		    {
			 TicketTestCase.expandTable(2);
		    }
		 else{
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
			WebObjectUtil.clickElement(Ticket.getNav_ExpandAllNoteCheckbox());
			WebObjectUtil.explicitWait(5);
			 WebObjectUtil.VerifyTextOnPage("Tickets");
			 String sID="tktLogsImg-" + sTicketID;
			 WebElement wTicketLogsExpander=WebObjectUtil.GetWebElement("id", sID, "Ticket Logs Expander");
			 //Expand Notes
			 wTicketLogsExpander.click();
			 WebObjectUtil.explicitWait(5);
			 WebObjectUtil.verifyElementPresent(Ticket.getNav_TicketLogsTable());
			 WebObjectUtil.explicitWait(5);
			 String sServID="tktServiceLogsImg-" + sTicketID;
			 WebElement wTicketServiceLogsExpander=WebObjectUtil.GetWebElement("id", sServID, "Notes Expander");
			 //Expand Notes
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
						String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.USERID");
						
						String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.PASSWORD");
						
						String sLongNotes = (String)FrameworkUtil.dictPropertyData.get("NAV.LEFCOURT.TICKET.LONG.NOTES");
						//Login to Navigator Portlet
						LoginTestCase_Old1.nav_Login(sUserName,sPassword);
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
					        String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLE.USERID");
							
							String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLE.PWD");
							//Login to Navigator Portlet
							LoginTestCase_Old1.nav_Login(sUserName,sPassword);
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
		String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.USERID.AROLE");
		
		String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.PASSWORD.AROLE");
		
		//Login to Navigator Portlet
		LoginTestCase_Old1.nav_Login(sUserName,sPassword);

			
		//Verify Create Ticket link - clarification required
		WebObjectUtil.verifyElementPresent(Home.getNav_CreateTicketLink());
		//Create Contact ticket and verify ticket is created
		navContactUsCreateticket();
		
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
		        String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.EFGHA.USERID");
				
				String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.EFGHA.PASSWORD");
				//Login to Navigator Portlet
				LoginTestCase_Old1.nav_Login(sUserName,sPassword);
				WebObjectUtil.ClickAndMouseHover(Ticket.getNav_SupportTabLink());
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
              }
			catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navContactUsCreateticket", "warn", "catch block:" +e.getMessage());  
			}
		}
		
		
/////////////////////////////////////methods///////////////////////////////////////
	
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
					
			
					
					//update each @test result in custom result file
					@AfterMethod
					public static void afterEachMethod(){
					FrameworkUtil.updateTestCaseStatusinResult();
						}
}
		
	
