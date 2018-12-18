package com.whs.navigator.testcases;

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
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.EntityBrowserPageFactory;
import com.whs.navigator.pagefactory.TicketPageFactory;
import com.whs.navigator.pagefactory.UserPermissionMultiOrgPageFactory;

public class KefferTestCase_Arul {
	
	public static String[] arrEntityNameListAsArray,arrParentEntityNameListAsArray,arrEVDCNameListAsArray;
	
	
	public static EntityBrowserPageFactory EBPanel = new EntityBrowserPageFactory();
	static UserPermissionMultiOrgPageFactory UPMultiOrg = new UserPermissionMultiOrgPageFactory();
	static TicketPageFactory Ticket = new TicketPageFactory();
	public static EVDC_OverviewPageFactory EVDC_Overview= new EVDC_OverviewPageFactory();
	
	
	/*==============================================================
	TestScript  	: verifyTicketCountforEntityandItsChildAfterRollOn
	Manual TestCase	: [QAT-383,QAT-352] Verify the counts at top are summed across all of my children. 	
	Description		:  Multiorg user with roll up flag ON, I see tickets for my entity and my child entities. Verify the counts at top are summed across all of my children.
	Author 			: Arularasu
	Creation Date 	: 12/23/2015
	Release Name    : Keffer
	Pre-Requisites	:
	Revision History:
==============================================================*/
	@Test(priority=81)
	public void verifyTicketCountforEntityandItsChildAfterRollOn()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,EBPanel);
			PageFactory.initElements(driver,UPMultiOrg);
			PageFactory.initElements(driver,Ticket);
			String sUserName=null,sPassword=null,sTstDevco;
		    
		try {
			FrameworkUtil.sTestCaseName = "verifyTicketCountforEntityandItsChildAfterRollOn";
			FrameworkUtil.sManualTestCaseName="[QAT-383,QAT-352] Verify the counts at top are summed across all of my children.";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.AROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.AROLE");
		    sTstDevco = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
		    
		    
			/*sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.MULTIORG.USERID.QAAUTOM");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.MULTIORG.PWD.QAAUTOM");
		   */ 
			LoginTestCase.nav_Login(sUserName, sPassword);
			
		    WebObjectUtil.selectWebList(UPMultiOrg.getNav_MOrg_SelectOrg(), sTstDevco, null, 0);
		   
	        WebObjectUtil.clickElement(UPMultiOrg.getNav_MOrg_UsethisOrgButton());
	   
	        WebObjectUtil.explicitWait(2);
	        HomeTestCase.nav_WindStreamToTierPointHomePopup();
	        TicketTestCase.navigateToTicketPage();
	        WebObjectUtil.explicitWait(10);
	        //verify ticket count for outstanding tickets
	        verifyTicketCountAfterRollOn(sTstDevco,Ticket.getNav_Outstanding());
	        verifyTicketCountAfterRollOn(sTstDevco,Ticket.getNav_ClosedLess());
	    	
	    	verifyTicketCountAfterRollOn(sTstDevco,Ticket.getNav_ClosedMore());
	    	
	    	// for jira QAT-352 to verify PDF and CSV icons
	    	WebObjectUtil.verifyElementPresent(Ticket.getNav_TicketsPdfIcon());
	    	WebObjectUtil.verifyElementPresent(Ticket.getNav_TicketsCsvIcon());
	 		//Logout from Navigator
			LoginTestCase.nav_Logout();
		
		   } catch (Exception e) {
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyTicketCountforEntityandItsChildAfterRollOn", "warn", "catch block:" +e.getMessage());
		}
    }
	
	
	/*==============================================================
	TestScript  	: verifyRollOnOffforMultiOrgUsers
	Manual TestCase	: [QAT-386] WCP_1303_TC_4.1_Rollup_MultiOrg_View EVDCs for parent/child entities. 	
	Description		: Multiorg user and verify the EVDCs are displayed for entity and it's children. 
	Author 			: Arularasu
	Creation Date 	: 01/04/2016
	Release Name    : Keffer
	Pre-Requisites	:
	Revision History:
==============================================================*/
	@Test(priority=82)
	public void verifyRollOnOffforMultiOrgUsers()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,EBPanel);
			PageFactory.initElements(driver,UPMultiOrg);
			PageFactory.initElements(driver,Ticket);
			PageFactory.initElements(driver,EVDC_Overview);
			
			String sUserName=null,sPassword=null,sTstDevco,sCurrentEntityName,s11Giraffe,sRollOnStatus;
		    String sEVDCNameRunnTime = "",sEVDCName;
		    String[] arrEVDCEntityNameList,arrEVDCNameList = null,arrEVDCNameListTemp;
		    boolean bEVDCNameStatus = false;
		try {
			FrameworkUtil.sTestCaseName = "verifyRollOnOffforMultiOrgUsers";
			FrameworkUtil.sManualTestCaseName="[QAT-386] WCP_1303_TC_4.1_Rollup_MultiOrg_View EVDCs for parent/child entities";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.AROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.AROLE");
		    sTstDevco = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
		    s11Giraffe = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME1");
		    
		    
		/*	sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.MULTIORG.USERID.QAAUTOM");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.MULTIORG.PWD.QAAUTOM");
			*/
			LoginTestCase.nav_Login(sUserName, sPassword);
			
		    WebObjectUtil.selectWebList(UPMultiOrg.getNav_MOrg_SelectOrg(), sTstDevco, null, 0);
		   
	        WebObjectUtil.clickElement(UPMultiOrg.getNav_MOrg_UsethisOrgButton());
	   
	        WebObjectUtil.explicitWait(2);
	        HomeTestCase.nav_WindStreamToTierPointHomePopup();

	        //verify parent - child EVDC name for Devco1 
	        arrEVDCNameList = getEVDCNameforEntityAndItsChild(sTstDevco);

			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			//WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			sCurrentEntityName = EBPanel.getNav_OrgNameTitleLink().getText();
			 if (!sCurrentEntityName.equalsIgnoreCase("Back to your Entity")){
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			}
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
	        sCurrentEntityName = EBPanel.getNav_OrgNameTitleLink().getText();
			if (!sCurrentEntityName.equalsIgnoreCase(sTstDevco)){
				
				EntityBrowserTestCase.selectOrgFromAllLevelsEB(sTstDevco,"", "", "");
			}
			
			EntityBrowserTestCase.setRollOnOffEBPanel(true);
			WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
			
			
			verifyEVDCnameForEntityAndItsChild(arrEVDCNameList);
	
		
			//verify parent - child EVDC name for 11Giraffe
			UserPermissionMultiOrgTestCase.selectOrgnameInOrgSelector(s11Giraffe);
			
			arrEVDCNameList = getEVDCNameforEntityAndItsChild(s11Giraffe);
			
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			//WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			sCurrentEntityName = EBPanel.getNav_OrgNameTitleLink().getText();
			 if (!sCurrentEntityName.equalsIgnoreCase("Back to your Entity")){
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			}
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
	        sCurrentEntityName = EBPanel.getNav_OrgNameTitleLink().getText();
			if (!sCurrentEntityName.equalsIgnoreCase(s11Giraffe)){
				
				EntityBrowserTestCase.selectOrgFromAllLevelsEB(s11Giraffe,"", "", "");
			}
			
			EntityBrowserTestCase.setRollOnOffEBPanel(true);
			WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
			
			
			verifyEVDCnameForEntityAndItsChild(arrEVDCNameList);
			
	 		//Logout from Navigator
			LoginTestCase.nav_Logout();
		
		   } catch (Exception e) {
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyRollOnOffforMultiOrgUsers", "warn", "catch block:" +e.getMessage());
		}
    }
	
	
	
	/*==============================================================
	TestScript  	: verifyEVDCtableAfterRollOn
	Manual TestCase	: [QAT-347]  For multiorg user and verify the EVDCs are displayed in table format for entity and it's children. 	
	Description		: Login to Navigator as multiorg user and verify the EVDCs are displayed in table format for entity and it's children.
	Author 			: Arularasu
	Creation Date 	: 01/05/2016
	Release Name    : Keffer
	Pre-Requisites	:
	Revision History:
==============================================================*/
	@Test(priority=83)
	public void verifyEVDCtableAfterRollOn()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,EBPanel);
			PageFactory.initElements(driver,UPMultiOrg);
			PageFactory.initElements(driver,Ticket);
			PageFactory.initElements(driver, EVDC_Overview);
			String sUserName=null,sPassword=null,sTstDevco,sCurrentEntityName,sOrgNameRunTime,sOrgNameSearch;
			String[] arrEVDCNameList,sOrgName;
			boolean bFlag=false;
		    
		try {
			FrameworkUtil.sTestCaseName = "verifyEVDCtableAfterRollOn";
			FrameworkUtil.sManualTestCaseName="[QAT-347] for multiorg user and verify the EVDCs are displayed in table format for entity and it's children.";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.AROLE");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.AROLE");
		    sTstDevco = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
		    
		   /* 
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.MULTIORG.USERID.QAAUTOM");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.MULTIORG.PWD.QAAUTOM");
			*/
			LoginTestCase.nav_Login(sUserName, sPassword);
			
		    WebObjectUtil.selectWebList(UPMultiOrg.getNav_MOrg_SelectOrg(), sTstDevco, null, 0);
		   
	        WebObjectUtil.clickElement(UPMultiOrg.getNav_MOrg_UsethisOrgButton());
	   
	        WebObjectUtil.explicitWait(2);
	        HomeTestCase.nav_WindStreamToTierPointHomePopup();

	        //Verify Parent column shows immediate parent for the entity
	        arrEVDCNameList = getEVDCNameforEntityAndItsChild(sTstDevco);
	        
	        sCurrentEntityName = EBPanel.getNav_EntityBrowserLink().getText();
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			
			if (!sCurrentEntityName.equalsIgnoreCase(sTstDevco)){
				WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			}
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			EntityBrowserTestCase.setRollOnOffEBPanel(true);
			WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
			
			//Verify the Columns
	        KeferTestCase_Vivek.verifyEVDCViewTableHeader();
	        
	        
	        //Verify Paginations

	        
	        //Verify PDF reports
	        WebObjectUtil.verifyElementPresent(EVDC_Overview.getNav_EVDCViewPDFIcon());
	        //Verify CSV reports
	        WebObjectUtil.verifyElementPresent(EVDC_Overview.getNav_EVDCViewCSVIcon());
	        
	        //Verify values for vCPUs, vRAM, and Storage

	        //Verify table is sortable - Out of Scope
	        
	      	WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			EntityBrowserTestCase.setRollOnOffEBPanel(false);
			WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
	        //Click on vCloud Director link and verify & Verify EVDC name is displayed as a clickable link
	        KeferTestCase_Vivek.verParentChildEntityLink(true, true);	        
	        
	        
	        
	        //Verify Search box
	        sOrgName = sTstDevco.split(" ");
	        WebObjectUtil.SetValueEdit(EVDC_Overview.getNav_EVDCViewSearchEdit(), sOrgName[sOrgName.length-1]);
	        WebObjectUtil.explicitWait(5);
	        CustomWebElementUtil.loadCustomElement(EVDC_Overview.getNav_EVDCViewHomeTable(), "table");
	        sOrgNameRunTime = CustomWebElementUtil.getCellData(1, 1);
	        sOrgNameSearch = sOrgName[sOrgName.length-1];
	        sOrgNameSearch = sOrgNameSearch.toLowerCase();
	        bFlag= sOrgNameRunTime.contains(sOrgNameSearch);
	        FrameworkUtil.updateCustomResultBasedOnStatus(bFlag, "Search EVDC name after roll ON, search text:" + sOrgNameSearch);
	        //Logout from Navigator
			LoginTestCase.nav_Logout();
		
		   } catch (Exception e) {
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyTicketCountforEntityandItsChildAfterRollOn", "warn", "catch block:" +e.getMessage());
		}
    }
	
	
	
	
	/*==============================================================
	TestScript  	: verifyEVDCNameSearchAfterRollOnTest
	Manual TestCase	: [QAT-349] WCP_1303_TC_1.6_RollUp_EVDCs in table format_Search Box 	
	Description		: verify user is able to search EVDC name by typing anything. 
	Author 			: Arularasu
	Creation Date 	: 01/13/2016
	Release Name    : Keffer
	Pre-Requisites	:
	Revision History:
==============================================================*/
	@Test(priority=84)
	public void verifyEVDCNameSearchAfterRollOnTest(){
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,EBPanel);
		PageFactory.initElements(driver, EVDC_Overview);
	    
	try {
		FrameworkUtil.sTestCaseName = "verifyEVDCNameSearchAfterRollOnTest";
		FrameworkUtil.sManualTestCaseName="[QAT-349]verify user is able to search EVDC name by typing anything.";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		 // Login to navigator with rola-a user
		 LoginTestCase.LoginAsRoleA();	 
		 
		 WebObjectUtil.explicitWait(2);
	     HomeTestCase.nav_WindStreamToTierPointHomePopup();
	     
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		EntityBrowserTestCase.setRollOnOffEBPanel(true);
		WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
		
		VerifyEVDCNameSearchAfterRollOn("ll");
		EVDC_Overview.getNav_EVDCViewSearchEdit().clear();
		WebObjectUtil.explicitWait(5);
		VerifyEVDCNameSearchAfterRollOn("orc");
			
        //Logout from Navigator
		LoginTestCase.nav_Logout();
		
	  } catch (Exception e) {
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyEVDCNameSearchAfterRollOn", "fail", "catch block:" +e.getMessage());
		}
		
	}
	
	
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
	

	public static String[] getEVDCNameforEntityAndItsChild(String sEntityName){
	
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,EBPanel);

		
	    String sEVDCNameRunnTime = "",sEVDCName,sCurrentEntityName,sParentName=".Hosted Solutions";
	    String[] arrEVDCEntityNameList,arrEVDCNameList,arrEVDCNameListTemp,arrEVDCNameListTempEntity;
	    
        sCurrentEntityName = EBPanel.getNav_EntityBrowserLink().getText();
      
        if (sCurrentEntityName.equalsIgnoreCase("Back to your Entity")){
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		}
        /*
       sCurrentEntityName = EBPanel.getNav_OrgNameTitleLink().getText();
		if (!sCurrentEntityName.equalsIgnoreCase(sEntityName)){
			EntityBrowserTestCase.selectOrgFromAllLevelsEB(sEntityName,"", "", "");
		}
		sCurrentEntityName = EBPanel.getNav_OrgNameTitleLink().getText();
	*/	
        sCurrentEntityName = EBPanel.getNav_EntityBrowserLink().getText();
       if (sCurrentEntityName.equalsIgnoreCase(sEntityName)){
    	EVDC_VM_TestCase.getEVDCNameAsWebElement(" ");
		for (WebElement wEVDC : WebObjectUtil.webElementsList)
		{
			sEVDCName = wEVDC.getText();
			sEVDCNameRunnTime = sEVDCNameRunnTime+"!EVDC!"+(sEVDCName + "!ENTITY!" + sCurrentEntityName  + "!PARENT!" + sParentName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "getEVDC Name", "done", sEVDCName +" EVDC name before roll on for entity " + sCurrentEntityName );
		}
		sParentName=sCurrentEntityName;
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			String[] arrChildEntityList = EntityBrowserTestCase.getChildOrgNameListFromEBPanel(1);
			
			for (String sChild :arrChildEntityList){
				EntityBrowserTestCase.selectOrgFromAllLevelsEB(sChild,"", "", "");
				sCurrentEntityName = EBPanel.getNav_OrgNameTitleLink().getText();
				WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
		    	  
				EVDC_VM_TestCase.getEVDCNameAsWebElement(" ");
				for (WebElement wEVDC : WebObjectUtil.webElementsList)
				{
					sEVDCName = wEVDC.getText();
					sEVDCNameRunnTime = sEVDCNameRunnTime+"!EVDC!"+(sEVDCName + "!ENTITY!" + sCurrentEntityName+ "!PARENT!" + sParentName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "getEVDC Name", "done", sEVDCName +" EVDC name before roll on for entity " + sCurrentEntityName );
					
				}
				WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
				WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
				WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
				sParentName=sCurrentEntityName;
			}
       }else{
    	   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "getEVDC Name", "warn", "Could not access " + sEntityName + ", pls check your inputs"); 
       }	
       
       sCurrentEntityName = EBPanel.getNav_EntityBrowserLink().getText();
      
         if (sCurrentEntityName.equalsIgnoreCase("Back to your Entity")){
 		WebObjectUtil.clickElement(EBPanel.getNav_CloseButton());
 		}
       
		arrEVDCEntityNameList =sEVDCNameRunnTime.split("!EVDC!");
		arrEVDCNameList = new String[arrEVDCEntityNameList.length-1];
		arrEVDCNameListAsArray = new String[arrEVDCEntityNameList.length-1];
		arrEntityNameListAsArray = new String[arrEVDCEntityNameList.length-1];
		arrParentEntityNameListAsArray = new String[arrEVDCEntityNameList.length-1];
		for (int e=1;e<=arrEVDCNameList.length;e++ ){
			arrEVDCNameListTemp = arrEVDCEntityNameList[e].split("!ENTITY!");
			arrEVDCNameList[e-1]=arrEVDCNameListTemp[0];
			arrEVDCNameListAsArray[e-1]=arrEVDCNameListTemp[0];
			arrEVDCNameListTempEntity = arrEVDCNameListTemp[1].split("!PARENT!");
			arrEntityNameListAsArray[e-1]=arrEVDCNameListTempEntity[0];
			arrParentEntityNameListAsArray[e-1]=arrEVDCNameListTempEntity[1];
		}
		
       return arrEVDCNameList;
	}
	
	public static void verifyEVDCnameForEntityAndItsChild(String[] arrEVDCnameAsArray){
		String sEVDCName;
		boolean bEVDCNameStatus=false;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,EVDC_Overview);
		
		
		CustomWebElementUtil.loadCustomElement(EVDC_Overview.getNav_EVDCViewHomeTable(), "table");
		for (int i=1;i<=CustomWebElementUtil.iRowCount;i++){
			sEVDCName=CustomWebElementUtil.getCellData(i, 1);
			
			for (String sEVDC :arrEVDCnameAsArray ){
				//System.out.println(sEVDCName + "--" + sEVDC);
				if (sEVDCName.trim().equalsIgnoreCase(sEVDC.trim())){
					bEVDCNameStatus=true;
					break;
				}
			}
			FrameworkUtil.updateCustomResultBasedOnStatus(bEVDCNameStatus, "EVDC name on Home page After roll On " + sEVDCName);
			bEVDCNameStatus=false;
		}
	}
	
	public static boolean VerifyEVDCNameSearchAfterRollOn(String sSearchText){
		
		String sOrgNameRunTime;
		String[] sOrgName;
		boolean bSearchStatus=false;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_Overview);

	    try {
			//Verify Search box
			if (WebObjectUtil.isElementPresent(EVDC_Overview.getNav_EVDCViewSearchEdit())){
			sOrgName = sSearchText.split(" ");
			WebObjectUtil.SetValueEdit(EVDC_Overview.getNav_EVDCViewSearchEdit(), sOrgName[sOrgName.length-1]);
			WebObjectUtil.explicitWait(5);
			CustomWebElementUtil.loadCustomElement(EVDC_Overview.getNav_EVDCViewHomeTable(), "table");
			sOrgNameRunTime = CustomWebElementUtil.getCellData(1, 1);
			sOrgNameRunTime = sOrgNameRunTime.toLowerCase();
			bSearchStatus=sOrgNameRunTime.contains(sOrgName[sOrgName.length-1]);
			FrameworkUtil.updateCustomResultBasedOnStatus(bSearchStatus, "Search EVDC name after roll ON, search result found:" + sOrgNameRunTime + ", and search text:" + sOrgName[sOrgName.length-1]);
			}else{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verify EVDC name seach", "warn", "EVDC Search field is not available, check where Roll up flag is ON" );
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return bSearchStatus;
	}
/*	public static void verifyEVDCnameAndItsParentForEntityAndItsChildMultiOrg(String[] arrEVDCnameAsArray){
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,EVDC_Overview);
		
		String sEVDCName,sParent=".Hosted Solutions";
		boolean bEVDCNameStatus=false;
		CustomWebElementUtil.loadCustomElement(EVDC_Overview.getNav_EVDCViewHomeTable(), "table");
		for (int i=1;i<=CustomWebElementUtil.iRowCount;i++){
			sEVDCName=CustomWebElementUtil.getCellData(i, 1);
			System.out.println(sEVDCName);
			for (String sEVDC :arrEVDCnameAsArray ){
				if (sEVDCName.equalsIgnoreCase(sEVDC)){
					bEVDCNameStatus=true;
					break;
				}
			}
			FrameworkUtil.updateCustomResultBasedOnStatus(bEVDCNameStatus, "EVDC name on Home page After roll On " + sEVDCName);
			bEVDCNameStatus=false;
		}
	}*/
	
	//update each @test result in custom result file
			@AfterMethod
			public static void afterEachMethod(){
				FrameworkUtil.updateTestCaseStatusinResult();
				FrameworkUtil.sTestExecutionStatus = true;
				
			}
	 
			
			
}

