package com.whs.navigator.testcases.Lefcourt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.media.rtc.webkitRTCPeerConnection;
import com.whs.navigator.commonUtil.CustomWebElementUtil;
import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.commonUtil.WebTableUtil;
import com.whs.navigator.pagefactory.CatalogPageFactory;
import com.whs.navigator.pagefactory.EVDC_FirewallPageFactory;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.EVDC_VM_AdvancedActions_PageFactory;
import com.whs.navigator.pagefactory.EVDC_VM_PageFactory;
import com.whs.navigator.pagefactory.EntityBrowserPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.ReportsPageFactory;
import com.whs.navigator.pagefactory.TicketPageFactory;
import com.whs.navigator.pagefactory.UserPermissionPageFactory;

public class LefCourtTestCase_NMR {
	
	public static TicketPageFactory Ticket = new TicketPageFactory();
    public static EVDC_OverviewPageFactory EVDC_OverviewPF = new EVDC_OverviewPageFactory();
    public static HomePageFactory_old Home = new HomePageFactory_old();
    public static EVDC_VM_PageFactory EVDC_VMPF = new EVDC_VM_PageFactory();
    public static EVDC_FirewallPageFactory FirewallPF = new EVDC_FirewallPageFactory();
    public static EntityBrowserPageFactory EBPANEL = new EntityBrowserPageFactory();
    public static UserPermissionPageFactory UserPermission = new UserPermissionPageFactory();
    public static CatalogPageFactory Catalog = new CatalogPageFactory();
    public static EVDC_VM_AdvancedActions_PageFactory VM_Advanced = new EVDC_VM_AdvancedActions_PageFactory();
    public static ReportsPageFactory Report = new ReportsPageFactory();
    
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
	
	/// navigating to the ticket page
	TicketTestCase.navigateToTicketPage();
	
	// searching the ticket
	sTicketID= (String) FrameworkUtil.dictPropertyData.get("NAV.LEFCOURT.TICKET.SERACHBY.TICKETID");
	TicketTestCase.searchTicket("Ticket ID", sTicketID);
	WebObjectUtil.explicitWait(10);
	// expanding the ticket
	wExpander = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
    WebObjectUtil.clickElement(wExpander);
    
    wNotes = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "TICKET.NOTES.EXPANDER", "PARAMETER_TICKETID",sTicketID);
    WebObjectUtil.clickElement(wNotes);
    
    WebObjectUtil.explicitWait(15);
   
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
    
    	
    sNotesCount = (String) FrameworkUtil.dictPropertyData.get("NAV.LEFCOURT.TICKET.NOTES.COUNT");
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
TestScript 		: navVerifySummaryVeiwLink
Manual TestCase	: QAT-429
Description		: Click on Summary View link and Verify that user is able to navigate to Home page
Author 			: QAA04
Creation Date 	: 01/22/2016
Release Name    : Lefcourt
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=2)
public void navVerifySummaryVeiwLink(){
	
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, Ticket);
	PageFactory.initElements(driver, EVDC_OverviewPF);
	PageFactory.initElements(driver, Home);
	
	FrameworkUtil.sTestCaseName="navVerifySummaryVeiwLink";
	FrameworkUtil.sManualTestCaseName="(QAT-429) lefcourt - Click on Summary View link and Verify that user is able to navigate to Home page";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	
	// login to the navigator
//	LoginTestCase.LoginAsDevco();
	LoginTestCase_Old1.LoginAsQaautoUser();
	
	// navigating to the evdc overview page
	WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
	
	// verifying the summary view link 
	     navReturnToHamePage();
	
	// navigating to the ticket page
	TicketTestCase.navigateToTicketPage();
	
	// verifying the summary view link 
		navReturnToHamePage();
// log out 
		LoginTestCase_Old1.nav_Logout();

}

/*==============================================================
TestScript 		: verifyEVDCSelector
Manual TestCase	: QAT-434
Description		: Verify that EVDC selector has EVDC name in it.
Author 			: QAA04
Creation Date 	: 01/20/2016
Release Name    : Lefcourt
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=3)
public void navVerifyEVDCSelector() {
	
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EVDC_OverviewPF);
	PageFactory.initElements(driver, FirewallPF);
	PageFactory.initElements(driver, EVDC_VMPF);
	
	FrameworkUtil.sTestCaseName ="verifyEVDCSelector";
	FrameworkUtil.sManualTestCaseName="(QAT-434) lefcourt - Verify that EVDC selector has EVDC name in it.";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	
	// login to the navigator
	//LoginTestCase.LoginAsDevco();
	LoginTestCase_Old1.LoginAsQaautoUser();
	
	WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
	WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine(), EVDC_VMPF.getNav_VMWebTableParent());
	
	// verifying the evdc selector 
	VerifyEVDCSelectorForDevco();
	
	driver.navigate().back();
	WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCOverviewFirewall(),FirewallPF.getNav_NATSLink());


	// verifying the evdc selector 
		VerifyEVDCSelectorForDevco();
		
		// log out 
	LoginTestCase_Old1.nav_Logout();
}

/*==============================================================
TestScript 		: navVerifyEBPanelLinkInFirewallPage
Manual TestCase	: QAT-440
Description		: Firewalls page is displayed and Verify that EB panel is displayed.
Author 			: QAA04
Creation Date 	: 01/25/2016
Release Name    : Lefcourt
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=4)
public void navVerifyEBPanelLinkInFirewallPage(){
	
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, FirewallPF);
	PageFactory.initElements(driver, EBPANEL);
	try{
	FrameworkUtil.sTestCaseName="navVerifyEBPanelLinkInFirewallPage";
	FrameworkUtil.sManualTestCaseName="(QAT-440) lefcourt - Firewalls page is displayed and Verify that EB panel is displayed.";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	
	// login to the navigator
	//LoginTestCase.LoginAsDevco();
	LoginTestCase_Old1.LoginAsQaautoUser();
	
	// navigating to the firewall page
	EVDC_FirewallTestCase.NavigateToFirewallPage();
	
	// verifying the ebpanel link
	WebObjectUtil.verifyElementPresent(EBPANEL.getNav_EntityBrowserLink());
	WebObjectUtil.clickElement(EBPANEL.getNav_EntityBrowserLink());
	WebObjectUtil.verifyElementPresent(EBPANEL.getNav_firstLevelChildrenEditBox());
	WebObjectUtil.verifyElementPresent(EBPANEL.getNav_OrgNameTitleLink());
	
	// log out 
	LoginTestCase_Old1.nav_Logout();
	}
	catch(Exception e){
		LoggerUtil.log_type_error("issue with navVerifyEBPanelLinkInFirewallPage test case");
	    LoggerUtil.log_type_error("Exception occured "+FrameworkUtil.sElementName);
	   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage());
	}
}

/*==============================================================
TestScript 		: navVerifyCreateEditDeleteImages
Manual TestCase	: QAT-447
Description		: verify that user cannot see any create , edit or delete icons and it is view only.
Author 			: QAA04
Creation Date 	: 01/27/2016
Release Name    : Lefcourt
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=5)
public void navVerifyCreateEditDeleteImages(){
	WebElement wCreateImage,wEditImage,wDeleteImage;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, FirewallPF);
	try{
	FrameworkUtil.sTestCaseName ="navVerifyCreateEditDeleteImages";
	FrameworkUtil.sManualTestCaseName="(QAT-447) lefcourt - verify that user cannot see any create , edit or delete icons and it is view only.";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	
	// login to the navigator
	//LoginTestCase.LoginAsGirUser();
	LoginTestCase_Old1.LoginAsQaautoUser();
	
	// navigating to the firewall page
	EVDC_FirewallTestCase.NavigateToFirewallPage();
	
	// expanding the first rule
	WebObjectUtil.clickElement(FirewallPF.getNav_FirstFirewallRuleExpander());
    WebObjectUtil.explicitWait(5);
    WebObjectUtil.verifyElementNOTPresent(FirewallPF.getNav_AddFireWallLink());
    
    // clicking on gom button
    WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
    // expanding network objects
    WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
    
    WebObjectUtil.verifyElementNOTPresent(FirewallPF.getNav_NetworkExpander());
  // network expander is NOT visible so i commented these below lines 
    /*  
    wCreateImage = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.CREATEIMAGE", "PARAMETER_ROWNUMBER", 1+"");
    WebObjectUtil.verifyElementNOTPresent(wCreateImage);
    
    wEditImage = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.EDITIMAGE", "PARAMETER_ROWNUMBER", 1+"");
    WebObjectUtil.verifyElementNOTPresent(wEditImage);
   
    wDeleteImage = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.DELETEIMAGE", "PARAMETER_ROWNUMBER", 1+"");
    WebObjectUtil.verifyElementNOTPresent(wDeleteImage);
    */
    
    // logout 
    LoginTestCase_Old1.nav_Logout();

	}
catch(Exception e){
	LoggerUtil.log_type_error("issue with navVerifyCreateEditDeleteImages test case");
    LoggerUtil.log_type_error("Exception occured "+FrameworkUtil.sElementName);
   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage());
}
}


/*==============================================================
TestScript 		: navMoveUserToEscalationList
Manual TestCase	: QAT-462
Description		: User is added successfully and appears on Critical Escalation List tab
Author 			: QAA04
Creation Date 	: 01/28/2016
Release Name    : Lefcourt
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=6)
public void navMoveUserToEscalationList(){
	String sUserName = null,sFeedbackMsg,sFdMsg;
	int iRowNum,iRowCount;
	WebElement wRowExpander,wAddCELlink;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, UserPermission);	
	
	try {
	//Update results with manual test case name
	FrameworkUtil.sTestCaseName = "navMoveUserToEscalationList";
	FrameworkUtil.sManualTestCaseName="(QAT-462) lefcourt - User is added successfully and appears on Critical Escalation List tab";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	//Login into Navigator	
      LoginTestCase_Old1.LoginAsRoleAUser();
	
	//Navigate to Critical Escalation list page
	UserPermissionTestCase.NavigateToCriticalEscalationListPage();
	//Click on Authorization Contact List tab
	WebObjectUtil.clickElement(UserPermission.getNav_AuthorizedContactListTab());
	WebObjectUtil.explicitWait(20);
	
	CustomWebElementUtil.loadCustomElement(UserPermission.getNav_AuthorizedContactListTableParent(), "table");
	iRowNum = CustomWebElementUtil.iRowCount;
	
	for(int i=1; i<=iRowNum; i++) {
		CustomWebElementUtil.loadCustomElement(UserPermission.getNav_AuthorizedContactListTableParent(), "table");
	    sUserName = CustomWebElementUtil.getCellData(i, 2);
	    
      
        // WebElement wRow = WebObjectUtil.GetWebElement("xpath", "//table[" + i + "]//div[@class='x-grid-row-expander']", "Expand Row Button");
	    wRowExpander = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.ESCALATION.AUTHORIZEDCONTACTLIST.WEBTABLE.EXPANDER", "PARAMETER_ROWNUMBER", i+""); 
	    WebObjectUtil.clickElement(wRowExpander);
	    WebObjectUtil.explicitWait(3);
	    wAddCELlink = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.ESCALATION.AUTHORIZEDCONTACTLIST.ADDTOCRITICALESCALATIONLIST.LINK", "PARAMETER_ROWNUMBER", i+"");
	    WebObjectUtil.clickElement(wAddCELlink);
	    
	    if(WebObjectUtil.isElementPresent(UserPermission.getNav_ConfirmPopup())){
	    	 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifing +Add to Critical Escalation List link", "pass", "+Add to Critical Escalation List button is NOT grayed out for this "+sUserName+ " user");
		WebObjectUtil.clickElement(UserPermission.getNav_ConfirmPopupOkBtn());
	    break;
	     }else{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "+Add to Critical Escalation List button", "Verifing +Add to Critical Escalation List link Enabled or Not", "Done", "+Add to Critical Escalation List button is grayed out for this "+sUserName+ " user");
			}    
	    
	}
	sFeedbackMsg="Successfully added "+ sUserName +" to the Critical Escalation List";
	WebObjectUtil.explicitWait(30);
	//Verify the confirmation message displayed in FeedBack area
	sFdMsg=UserPermission.getNav_FeedBackArea().getText();
	boolean bFeedbackMsgC = sFdMsg.trim().equalsIgnoreCase(sFeedbackMsg.trim());
	FrameworkUtil.updateCustomResultBasedOnStatus(bFeedbackMsgC,sFeedbackMsg);
	
	driver.navigate().refresh();
	WebObjectUtil.waitForElementPresent(UserPermission.getNav_CriticalEscalationListTab());
	WebObjectUtil.clickElement(UserPermission.getNav_CriticalEscalationListTab());
	WebObjectUtil.explicitWait(20);
	CustomWebElementUtil.loadCustomElement(UserPermission.getNav_CriticalEscalationListTable(), "table");
	iRowCount = CustomWebElementUtil.iRowCount;
	
	for(int i=1; i<=iRowCount; i++){
		
		CustomWebElementUtil.loadCustomElement(UserPermission.getNav_CriticalEscalationListTable(), "table");
		String sUser = CustomWebElementUtil.getCellData(i, 2);
		
		if(sUserName.equalsIgnoreCase(sUser)){
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifing the added user", "pass", ""+sUserName+" user is successfully added to the critical escalation list");
		break;
		}
		
	}
	
// log out 
	LoginTestCase_Old1.nav_Logout();
	
     } catch(Exception e){
    		LoggerUtil.log_type_error("issue with navMoveUserToEscalationList test case");
    	    LoggerUtil.log_type_error("Exception occured "+FrameworkUtil.sElementName);
    	   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage());
    	}
   }

/*==============================================================
TestScript 		: navVerifyFormsFooter
Manual TestCase	: QAT-430
Description		: Forms Dashboard page is displayed. Verify that the footer of the page
Author 			: QAA04
Creation Date 	: 01/28/2016
Release Name    : Lefcourt
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=7)
public void navVerifyFormsFooter(){
	
	int iSize,i=1;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, Home);	
	
	try {
	//Update results with manual test case name
	FrameworkUtil.sTestCaseName = "navVerifyFormsFooter";
	FrameworkUtil.sManualTestCaseName="(QAT-430) Lefcourt- Forms Dashboard page is displayed. Verify that the footer of the page";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	//Login into Navigator	
      LoginTestCase_Old1.LoginAsEfghaUser();
      
      // navigating to the forms page
      WebObjectUtil.ClickAndMouseHover(Home.getNav_SupportTab());
      WebObjectUtil.clickElement(Home.getNav_BuildReqMenuLink());
      WebObjectUtil.explicitWait(5);
      WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.FORM.FOOTER.SECTIONS", "null", "null");
      iSize = WebObjectUtil.webElementsList.size(); 
      FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying forms footer", "pass", "form footer section count " +iSize);
      
      for (WebElement wb : WebObjectUtil.webElementsList){
    	 String sData = wb.getText(); 
    	  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying forms footer", "pass", ""+i+" Footer section data " +sData);
      i++;
      }
      
      LoginTestCase_Old1.nav_Logout();
	  } catch(Exception e){
  		LoggerUtil.log_type_error("issue with navVerifyFormsFooter test case");
  	    LoggerUtil.log_type_error("Exception occured "+FrameworkUtil.sElementName);
  	   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage());
  	}
 }

/*==============================================================
TestScript 		: navVerifySummaryPageTabs
Manual TestCase	: QAT-437
Description		: Verify that Tabs are displayed on Summary page.
Author 			: QAA04
Creation Date 	: 01/29/2016
Release Name    : Lefcourt
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=8)
public void navVerifySummaryPageTabs(){
	
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, Home);	
	
	try {
	//Update results with manual test case name
	FrameworkUtil.sTestCaseName = "navVerifySummaryPageTabs";
	FrameworkUtil.sManualTestCaseName="(QAT-437) Lefcourt- Verify that Tabs are displayed on Summary page.";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	//Login into Navigator	
      LoginTestCase_Old1.LoginAsSravuriUser();
      
      // verifying the tabs
      verifySummaryPageTabs();
      
      // navigating to the forms page
      WebObjectUtil.ClickAndMouseHover(Home.getNav_MonitoringTab());
      WebObjectUtil.clickElement(Home.getNav_ReportMenuLink());
      
      
      // verifying the tabs
      verifySummaryPageTabs();
      
      // log out
      LoginTestCase_Old1.nav_Logout();
      
	  } catch(Exception e){
		LoggerUtil.log_type_error("issue with navVerifySummaryPageTabs test case");
	    LoggerUtil.log_type_error("Exception occured "+FrameworkUtil.sElementName);
	   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage());
	}
}

/*==============================================================
TestScript 		: navVerifyVMGridColors
Manual TestCase	: QAT-446
Description		: verify that the colors on VM page are matching with the colors on Catalogs page
Author 			: QAA04
Creation Date 	: 01/29/2016
Release Name    : Lefcourt
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=9)
public void navVerifyVMGridColors(){
	WebElement wExpand;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EVDC_VMPF);
	PageFactory.initElements(driver, Catalog);
	PageFactory.initElements(driver, EVDC_OverviewPF);
	PageFactory.initElements(driver, VM_Advanced);
	
	try{
	FrameworkUtil.sTestCaseName="navVerifyVMGridColors";
	FrameworkUtil.sManualTestCaseName="(QAT-446) LefCourt - Verify that the colors on VM page are matching with the colors on Catalogs page";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);

	//login to the navigator
	//LoginTestCase.LoginAsDevco();
	LoginTestCase_Old1.LoginAsQaautoUser();
	
	// navigate to vm page 
   WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
   WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
   
   wExpand = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "EVDC.VM.VMTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
   WebObjectUtil.clickElement(wExpand);
   WebObjectUtil.clickElement(EVDC_VMPF.getNav_StorageDetailsLink());
   UserPermissionManageEntityTestCase.verifyColorEachRowTable(EVDC_VMPF.getNav_StorageDetailsWebTableParent(),"x-grid-item-alt",false);
   
   // return to home
   navReturnToHamePage();
   
   // navigate to catalog page
  	CatalogTestCase.navigateCatalogPage();
	WebObjectUtil.clickElement(Catalog.getNav_CatalogWindStreamLink());
	//WebObjectUtil.clickElement(Catalog.getNav_CatalogWindStreamFirstExpander());
	
	UserPermissionManageEntityTestCase.verifyColorEachRowTable(Catalog.getNav_SharedObjectsWebTableParent(),"lavender-back",true);
	
	  // return to home
	   navReturnToHamePage();
	   
	// navigate to vm page 
	   WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
	   WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
	   
	   wExpand = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "EVDC.VM.VMTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
	   WebObjectUtil.clickElement(wExpand);
	   
	   WebObjectUtil.clickElement(VM_Advanced.getNav_EVDCAdvancedActionsLink());
	   WebObjectUtil.explicitWait(5);
	   WebObjectUtil.verifyElementPresent(VM_Advanced.getNav_EVDCSaveVMTemplateLink());
	   WebObjectUtil.verifyElementPresent(VM_Advanced.getNav_EVDCDeleteVMLink());
	   WebObjectUtil.verifyElementPresent(VM_Advanced.getNav_EVDCcopyVMLink());
	   
	   // log out 
	   LoginTestCase_Old1.nav_Logout();
	   
      } catch(Exception e){
		LoggerUtil.log_type_error("issue with navVerifyVMGridColors test case");
	    LoggerUtil.log_type_error("Exception occured "+FrameworkUtil.sElementName);
	   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage());
	}
}

/*==============================================================
TestScript 		: verifyReportsGraphColor
Manual TestCase	: QAT-548
Description		: Verify the Green line shows Allocated values and Blue line shows Committed
Author 			: QAA04
Creation Date 	: 02/08/2016
Release Name    : Lefcourt
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=10)
public void verifyReportsGraphColor() {
	WebElement wCustomDropdown,wPODDropdown,wTierDropdown,wDateDropdown,wElement;
	String sULElementXpath,sPrint,sPng,sJpeg,sPdf,sSvg;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, Home);
	PageFactory.initElements(driver, Report);
	try {
	FrameworkUtil.sTestCaseName="verifyReportsGraphColor";
	FrameworkUtil.sManualTestCaseName="(QAT-548) lefCourt - Verify the Green line shows Allocated values and Blue line shows Committed";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);

	// login to the navigator
    //LoginTestCase.LoginAsTstMax02lasttUser();
    LoginTestCase_Old1.LoginAsQaautoUser();
    
    // navigating to the report page
    WebObjectUtil.ClickAndMouseHover(Home.getNav_MonitoringTab());
    WebObjectUtil.clickElement(Home.getNav_ReportMenuLink());
    
    // clicking on storage reports link
    WebObjectUtil.clickElement(Report.getNavStorageReportsLink());
    
    WebObjectUtil.clickElement(Report.getNavCustomerTieredStorageLevelsDropDownArrow());
    sULElementXpath = (String) FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
    wCustomDropdown =WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
    WebObjectUtil.selectCustomWebList(wCustomDropdown, "Virtual Storage");
    
    WebObjectUtil.explicitWait(3);
    WebObjectUtil.clickElement(Report.getNavPODDropDownArrow());
    sULElementXpath = (String) FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
    wPODDropdown =WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
    WebObjectUtil.selectCustomWebList(wPODDropdown, "NSH");
    // CustomWebElementUtil.selectCustomWebList(Report.getNavCustomerTieredStorageLevelsDropDown_Elements(), "NSH", null);
   // WebObjectUtil.selectCustomWebList(Report.getNavCustomerTieredStorageLevelsDropDown_Elements(), "NSH");
    
    WebObjectUtil.explicitWait(3);
    WebObjectUtil.clickElement(Report.getNavTierDropDownArrow());
    sULElementXpath = (String) FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
    wTierDropdown =WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
    WebObjectUtil.selectCustomWebList(wTierDropdown, "WCS Storage - Capacity Tier - Recurring");
    // WebObjectUtil.selectCustomWebList(Report.getNavCustomerTieredStorageLevelsDropDown_Elements(), "WCS Storage - Capacity Tier - Recurring");
    
    WebObjectUtil.explicitWait(3);
    WebObjectUtil.clickElement(Report.getNavDateDropDownArrow());
    sULElementXpath = (String) FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
    wDateDropdown =WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
    WebObjectUtil.selectCustomWebList(wDateDropdown, "2015-10");
    // WebObjectUtil.selectCustomWebList(Report.getNavCustomerTieredStorageLevelsDropDown_Elements(), "2015-10");
    
    sPrint = (String) FrameworkUtil.dictPropertyData.get("NAV.REPORTS.GRAPH.CHARTCONTEXTMENU.PRINT.ELEMENT");
    sPng = (String) FrameworkUtil.dictPropertyData.get("NAV.REPORTS.GRAPH.CHARTCONTEXTMENU.PNG.ELEMENT");
    sJpeg = (String) FrameworkUtil.dictPropertyData.get("NAV.REPORTS.GRAPH.CHARTCONTEXTMENU.JPEG.ELEMENT");
    sPdf = (String) FrameworkUtil.dictPropertyData.get("NAV.REPORTS.GRAPH.CHARTCONTEXTMENU.PDF.ELEMENT");
    sSvg = (String) FrameworkUtil.dictPropertyData.get("NAV.REPORTS.GRAPH.CHARTCONTEXTMENU.SVG.ELEMENT");
    
    WebObjectUtil.explicitWait(5);
    WebObjectUtil.isElementPresent(Report.getNavReportsGraph());
    WebObjectUtil.clickElement(Report.getNavGraphContextMenu());
    wElement = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.REPORTS.VIRTUALSTORAGE.GRAPHCONTEXTMENU.ELEMENT", "PARAMETER_CHARTELEMENTNAME", sPrint);
    WebObjectUtil.verifyElementPresent(wElement);
    wElement = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.REPORTS.VIRTUALSTORAGE.GRAPHCONTEXTMENU.ELEMENT", "PARAMETER_CHARTELEMENTNAME", sPng);
    WebObjectUtil.verifyElementPresent(wElement);
    wElement = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.REPORTS.VIRTUALSTORAGE.GRAPHCONTEXTMENU.ELEMENT", "PARAMETER_CHARTELEMENTNAME", sJpeg);
    WebObjectUtil.verifyElementPresent(wElement);
    wElement = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.REPORTS.VIRTUALSTORAGE.GRAPHCONTEXTMENU.ELEMENT", "PARAMETER_CHARTELEMENTNAME", sPdf);
    WebObjectUtil.verifyElementPresent(wElement);
    wElement = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.REPORTS.VIRTUALSTORAGE.GRAPHCONTEXTMENU.ELEMENT", "PARAMETER_CHARTELEMENTNAME", sSvg);
    WebObjectUtil.verifyElementPresent(wElement);
    WebObjectUtil.ClickAndMouseHover(Report.getNavReportsGraph());
    WebObjectUtil.explicitWait(3);
    WebObjectUtil.verifyElementPresent(Report.getNavAllocatedGraph_GreenColorLine());
    WebObjectUtil.verifyElementPresent(Report.getNavCommittedGraph_BlueColorline());
    
    // log out 
    LoginTestCase_Old1.nav_Logout();
	} catch(Exception e){
		LoggerUtil.log_type_error("issue with verifyReportsGraphColor test case");
	    LoggerUtil.log_type_error("Exception occured "+FrameworkUtil.sElementName);
	   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage());
	}

}



/////////////////////////////////// Methods /////////////////////////////////////////////////////////
/*====================================================================================================
Method Name 	: navReturnToHamePage
Description		: Verifying the Summary view link
Author 			: QAA04
Creation Date 	: 01/22/2016
Release Name    : lefcourt
Pre-Requisites	:
Revision History:
=====================================================================================================*/ 
public void navReturnToHamePage() {
	String sHomeLink;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, Home);
	try{
	// clicking on summary view link
		WebObjectUtil.ClickAndMouseHover(Home.getNav_MonitoringTab());
		WebObjectUtil.clickElement(Home.getNav_SummaryViewMenuLink());
		
		// verifying the home link
		sHomeLink = (String) FrameworkUtil.dictPropertyData.get("NAV.HOME.BREADCRUMB");
		WebObjectUtil.VerifyTextUnderElement(Home.getNav_HomeBreadcrumb(),sHomeLink);
		
	}catch(Exception e){
		LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
		LoggerUtil.log_type_error(e.getMessage());
	}
}


/*====================================================================================================
Method Name 	: VerifyEVDCSelectorForDevco
Description		: Verifying the expected EVDC selector 
Author 			: QAA04
Creation Date 	: 12/29/2016
Release Name    : Lefcourt
Pre-Requisites	:
Revision History:
=====================================================================================================*/
public void VerifyEVDCSelectorForDevco() {
	String sActualSelector,sExpectedSelector;
	boolean bStatus;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EVDC_OverviewPF);
	try{
	// verifying the evdc selector
		sActualSelector=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.NAME");
		
		sExpectedSelector=EVDC_OverviewPF.getNav_EVDCOrgSelector().getText();
		bStatus=sActualSelector.contains(sExpectedSelector);
		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Verifying Org - " + sExpectedSelector + " is diplaying correctly");

	}catch(Exception e){
	LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
	LoggerUtil.log_type_error(e.getMessage());
   }

}
/*====================================================================================================
Method Name 	: navVerifySummaryPageTabs
Description		: verifying the all tabs in summary page
Author 			: QAA04
Creation Date 	: 01/29/2016
Release Name    : Lefcourt
Pre-Requisites	:
Revision History:
=====================================================================================================*/
public void verifySummaryPageTabs(){
	
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver,Home);
	
	try{
	//Verifying the Monitoring Tab
	    WebObjectUtil.verifyElementPresent(Home.getNav_MonitoringTab());
		WebObjectUtil.ClickAndMouseHover(Home.getNav_MonitoringTab());
	
	//Verifying the Service Tab
		WebObjectUtil.verifyElementPresent(Home.getNav_ServicesTab());
		WebObjectUtil.ClickAndMouseHover(Home.getNav_ServicesTab());
	
	
	//Verifying the Security Tab
		WebObjectUtil.verifyElementPresent(Home.getNav_SecurityTab());
		WebObjectUtil.ClickAndMouseHover(Home.getNav_SecurityTab());
	
	
	//Verifying Support Tab
		WebObjectUtil.verifyElementPresent(Home.getNav_SupportTab());
		WebObjectUtil.ClickAndMouseHover(Home.getNav_SupportTab());
	
	//Verifying Account Tab
		WebObjectUtil.verifyElementPresent(Home.getNav_AccountTab());
		WebObjectUtil.ClickAndMouseHover(Home.getNav_AccountTab());
	
	}catch(Exception e){
		LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
		LoggerUtil.log_type_error(e.getMessage());
	   }
}


//update each @test result in custom result file
		@AfterMethod
		public static void afterEachMethod(){
			FrameworkUtil.updateTestCaseStatusinResult();
			FrameworkUtil.sTestExecutionStatus = true;

		}





}
