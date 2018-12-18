package com.whs.navigator.testcases;
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
import com.whs.navigator.pagefactory.EM7PageFactory;
import com.whs.navigator.pagefactory.EntityBrowserPageFactory;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;



public class KefferTestCase_Priyanka {
	public static EVDC_OverviewPageFactory EVDC_OverviewPF= new EVDC_OverviewPageFactory();
	public static EVDC_VM_PageFactory EVDC_VMPF=new EVDC_VM_PageFactory();
	public static SmokeTestPageFactory Smoke= new SmokeTestPageFactory();
	public static HomePageFactory Home= new HomePageFactory();
	public static DraasPageFactory DRaaS= new DraasPageFactory();
	public static CommonPageFactory Common=new CommonPageFactory();
	public static TicketPageFactory Ticket=new TicketPageFactory();
	public static LoadBalancerPageFactory LoadBalancer = new LoadBalancerPageFactory();

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
	@Test(priority=31)
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
		LoginTestCase.nav_Login(sUserName,sPassword);
		//Select and Open Ticket page
		TicketTestCase.navigateToTicketPage();
		//select the status filter button
		WebObjectUtil.ClickAndMouseHover(Ticket.getNav_FilterByStatusDropdown());
		WebObjectUtil.clickElement(Ticket.getNav_ClosedLess());
		WebObjectUtil.explicitWait(10);
		CustomWebElementUtil.loadCustomElement(Ticket.getNav_TicketsWebTable(), "table");
		VerifyLogsAndSearchText();
		LoginTestCase.nav_Logout();
		
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
	@Test(priority=32)
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
		LoginTestCase.nav_Login(sUserName,sPassword);
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
		
		//WebObjectUtil.clickElement(Ticket.getNav_TicketCloneBtn());
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
		LoginTestCase.nav_Logout();
	    
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
	@Test(priority=33)
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
		LoginTestCase.nav_Login(sUserName,sPassword);
		
		
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
		LoginTestCase.nav_Logout();
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
	@Test(priority=34)
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
			LoginTestCase.nav_Login(sUserName,sPassword);
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
			 wTicketLogsExpander.click();
			 WebObjectUtil.explicitWait(5);
			 WebObjectUtil.verifyElementPresent(Ticket.getNav_TicketLogsTable());
			 WebObjectUtil.explicitWait(5);
			 sServID="tktServiceLogsImg-" + sTicketID;
			 WebElement wTicketServiceLogsExpander=WebObjectUtil.GetWebElement("id", sServID, "Notes Expander");
			 //Expand Notes
			 wTicketServiceLogsExpander.click();
			 WebObjectUtil.explicitWait(5);
			 sServLogTable="tktServiceLogsGrid-" + sTicketID;
			 WebElement wTicketServiceLogsTable=WebObjectUtil.GetWebElement("id", sServLogTable, "ServLogsTable");
			 WebObjectUtil.verifyElementPresent(wTicketServiceLogsTable);
			// WebObjectUtil.getActiveElementasWebElement(sULElementXpath)
			 LoginTestCase.nav_Logout();
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
	@Test(priority=35)
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
		TicketTestCase.navTicketLogin();
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
		if(iCounter==(iNoteRowCount/2))
			FrameworkUtil.updateCustomResultBasedOnStatus(true,"Order of the notes displayed for the ticket is valid" );
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false,"Order of the notes displayed for the ticket is in-valid" );

		LoginTestCase.nav_Logout();	
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
	@Test(priority=36)
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
		TicketTestCase.navTicketLogin();
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
	@Test(priority=37)
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
		LoginTestCase.nav_Login(sUserName,sPassword);
		//Select and Open Ticket page
		TicketTestCase.navigateToTicketPage();
		//select the status filter button
		WebObjectUtil.ClickAndMouseHover(Ticket.getNav_FilterByStatusDropdown());
		WebObjectUtil.clickElement(Ticket.getNav_ClosedMore());
		WebObjectUtil.explicitWait(10);
		CustomWebElementUtil.loadCustomElement(Ticket.getNav_TicketsWebTable(), "table");
		VerifyLogsAndSearchText();
		LoginTestCase.nav_Logout();
	}
	catch (Exception e) {
		LoggerUtil.log_type_error("issue with - Ticket- verifyClosedMoreTicketData" );
		LoggerUtil.log_type_error(e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	 }
	}

	
	
//----------------------------------------------Methods---------------------------------------------\\

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
			 wTicketLogsExpander.click();
			 WebObjectUtil.explicitWait(5);
			 WebObjectUtil.verifyElementPresent(Ticket.getNav_TicketLogsTable());
			 WebObjectUtil.explicitWait(5);
			 sServID="tktServiceLogsImg-" + sTicketID;
			 WebElement wTicketServiceLogsExpander=WebObjectUtil.GetWebElement("id", sServID, "Notes Expander");
			 //Expand Notes
			 wTicketServiceLogsExpander.click();
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
			int iRowMax,i;
			int sNumSeq[]=new int[100];
			WebElement wNotesTable = WebObjectUtil.GetWebElement("id", "notesGrid-"+sTicketID+"-body", "NotesTable");
			WebObjectUtil.explicitWait(3);
			iRowMax=WebTableUtil.getRowCount(Ticket.getNav_NotesWebTable());;
			WebObjectUtil.explicitWait(5);
			if((iRowMax>0)&&(wNotesTable!=null))
			{
				for(i=1;i<=iRowMax;i=i+2)
				{
					
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
			
	
	//update each @test result in custom result file
		@AfterMethod
		public static void afterEachMethod(){
			FrameworkUtil.updateTestCaseStatusinResult();
			
		}

	}