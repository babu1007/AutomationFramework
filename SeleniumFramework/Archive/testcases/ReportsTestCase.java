package com.whs.navigator.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.EntityBrowserPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory;
import com.whs.navigator.pagefactory.ReportsPageFactory;
import com.whs.navigator.testcases.FirewallTestCase;

public class ReportsTestCase {

	public static HomePageFactory Home = new HomePageFactory();
	public static ReportsPageFactory Report = new ReportsPageFactory();
	public static EntityBrowserPageFactory Entity = new EntityBrowserPageFactory();
	
	
	
///////////////////////////////////////////////QAA04////////////////////////////////////////////////////////////////////////////////////

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
		LoginTestCase.LoginAsEntity03User();
	    
	/*    // navigating to the report page
	    WebObjectUtil.ClickAndMouseHover(Home.getNav_MonitoringTab());
	    WebObjectUtil.clickElement(Home.getNav_ReportMenuLink());
	    
	    // clicking on storage reports link
	    WebObjectUtil.clickElement(Report.getNavStorageReportsLink());
	    
	    WebObjectUtil.clickElement(Report.getNavCustomerTieredStorageLevelsDropDownArrow());
	    sULElementXpath = (String) FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
	    wCustomDropdown =WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
	    //WebObjectUtil.selectCustomWebList(wCustomDropdown, "Virtual Storage");
	    WebObjectUtil.selectCustomWebList(wCustomDropdown, "Physical Storage");
	    
	    WebObjectUtil.explicitWait(3);
	    WebObjectUtil.scrollToElement(Report.getNavPODDropDownArrow());
	    WebObjectUtil.explicitWait(8);
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
	    */
	    

		   // navigate to report page
			navigateToReportsPage();
			
			// selecting the item from customer tiered storage levels
			selectCustomerTieredStorageLevelsDropDownItems("Physical Storage", "RAL", "SAN Storage - Capacity Tier - Recurring", "2016-04");
		
			
	    sPrint = (String) FrameworkUtil.dictPropertyData.get("NAV.REPORTS.GRAPH.CHARTCONTEXTMENU.PRINT.ELEMENT");
	    sPng = (String) FrameworkUtil.dictPropertyData.get("NAV.REPORTS.GRAPH.CHARTCONTEXTMENU.PNG.ELEMENT");
	    sJpeg = (String) FrameworkUtil.dictPropertyData.get("NAV.REPORTS.GRAPH.CHARTCONTEXTMENU.JPEG.ELEMENT");
	    sPdf = (String) FrameworkUtil.dictPropertyData.get("NAV.REPORTS.GRAPH.CHARTCONTEXTMENU.PDF.ELEMENT");
	    sSvg = (String) FrameworkUtil.dictPropertyData.get("NAV.REPORTS.GRAPH.CHARTCONTEXTMENU.SVG.ELEMENT");
	    
	    WebObjectUtil.explicitWait(5);
	    WebObjectUtil.isElementPresent(Report.getNavReportsGraph());
	    WebObjectUtil.clickElement(Report.getNavGraphContextMenu());
	    wElement = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.REPORTS.VIRTUALSTORAGE.GRAPHCONTEXTMENU.ELEMENT", "PARAMETER_CHARTELEMENTNAME", sPrint);
	    FrameworkUtil.sElementName = "NAV.REPORTS.GRAPH.CHARTCONTEXTMENU.PRINT.ELEMENT";
	    WebObjectUtil.verifyElementPresent(wElement);
	    wElement = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.REPORTS.VIRTUALSTORAGE.GRAPHCONTEXTMENU.ELEMENT", "PARAMETER_CHARTELEMENTNAME", sPng);
	    FrameworkUtil.sElementName = "NAV.REPORTS.GRAPH.CHARTCONTEXTMENU.PNG.ELEMENT";
	    WebObjectUtil.verifyElementPresent(wElement);
	    wElement = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.REPORTS.VIRTUALSTORAGE.GRAPHCONTEXTMENU.ELEMENT", "PARAMETER_CHARTELEMENTNAME", sJpeg);
	    FrameworkUtil.sElementName = "NAV.REPORTS.GRAPH.CHARTCONTEXTMENU.JPEG.ELEMENT";
	    WebObjectUtil.verifyElementPresent(wElement);
	    wElement = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.REPORTS.VIRTUALSTORAGE.GRAPHCONTEXTMENU.ELEMENT", "PARAMETER_CHARTELEMENTNAME", sPdf);
	    FrameworkUtil.sElementName = "NAV.REPORTS.GRAPH.CHARTCONTEXTMENU.PDF.ELEMENT";
	    WebObjectUtil.verifyElementPresent(wElement);
	    wElement = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.REPORTS.VIRTUALSTORAGE.GRAPHCONTEXTMENU.ELEMENT", "PARAMETER_CHARTELEMENTNAME", sSvg);
	    FrameworkUtil.sElementName = "NAV.REPORTS.GRAPH.CHARTCONTEXTMENU.SVG.ELEMENT";
	    WebObjectUtil.verifyElementPresent(wElement);
	    //WebObjectUtil.ClickAndMouseHover(Report.getNavReportsGraph());
	    WebObjectUtil.explicitWait(3);
	    WebObjectUtil.verifyElementPresent(Report.getNavAllocatedGraph_GreenColorLine());
	    WebObjectUtil.verifyElementPresent(Report.getNavCommittedGraph_BlueColorline());
	    
	    // log out 
	    LoginTestCase.nav_Logout();
		} catch(Exception e){
			LoggerUtil.log_type_error("issue with verifyReportsGraphColor test case");
		    LoggerUtil.log_type_error("Exception occured "+FrameworkUtil.sElementName);
		   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage());
		}

	}
	 
	
	
	
///__________________________________________ TalonSP1TestCases _________________________________________________________________ /////
	
	
	/*==============================================================
	TestScript 		: verifyReportsGraph
	Manual TestCase	: QAT-1367
	Description		: verify the reports graph elements
	Author 			: QAA04
	Creation Date 	: 04/21/2016
	Release Name    : LefcourtSP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=1)
	public void verifyReportsGraph(){
		String sOrgName;
		boolean bStatus;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Report);
		PageFactory.initElements(driver, Entity);
		PageFactory.initElements(driver, Home);
		try{
		FrameworkUtil.sTestCaseName="verifyReportsGraph";
		FrameworkUtil.sManualTestCaseName="(QAT-1367) TalonSP1 - verify the reports graph elements";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		//Login to Navigator with ishannon user 
	    LoginTestCase.LoginAsIshannonUser();
	    
		//precondition for child parent relationship to entities in the flow TST Entity01/TST Entity02/TST Entity03/TST Entity04
		AdminTestCase.setTstEntityParent();
		
		//Logout from Navigator
		LoginTestCase.nav_Signout();
		
		// login to the navigator
		LoginTestCase.LoginAsEntity01User();
		
		// clicking on eb panel link
		WebObjectUtil.clickElement(Entity.getNav_EntityBrowserLink());
		// selecting the org from entity browser
		EntityBrowserTestCase.selectOrgFromAllLevelsEB("TST Entity02", "TST Entity03", null, null);
		// clicking on the org title link
	   WebObjectUtil.clickElement(Entity.getNav_OrgNameTitleLink());
	   WebObjectUtil.explicitWait(15);
	   sOrgName = Home.getNav_OrgNameTitle().getText();
	   bStatus = sOrgName.equalsIgnoreCase("TST Entity03");
	   FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "TST Entity03 org is displaying");
	
	   // navigate to report page
		navigateToReportsPage();
		
		// selecting the item from customer tiered storage levels
		selectCustomerTieredStorageLevelsDropDownItems("Physical Storage", "RAL", "SAN Storage - Capacity Tier - Recurring", "2016-04");
		// verify the storage tier drop down elements
		verifyStorageTierDropDownElements();
		
		// verify chart context menu elements
		verifyChartContextMenuElements();
		
		 //WebObjectUtil.ClickAndMouseHover(Report.getNavReportsGraph());
		    
		    WebObjectUtil.verifyElementPresent(Report.getNavAllocatedGraph_GreenColorLine());
		    WebObjectUtil.verifyElementPresent(Report.getNavCommittedGraph_BlueColorline());
		    
		    // log out 
		    LoginTestCase.nav_Logout();
			} catch(Exception e){
				LoggerUtil.log_type_error("issue with verifyReportsGraph test case");
			    LoggerUtil.log_type_error("Exception occured "+FrameworkUtil.sElementName);
			   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage());
			}
	}
	
	
	/*==============================================================
	TestScript 		: verifyReportsGraphAllocatedValue
	Manual TestCase	: (QAT-1350)(QAT-1332)
	Description		: Verify that date is selected and a graph is displayed
	Author 			: QAA04
	Creation Date 	: 04/22/2016
	Release Name    : LefcourtSP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=2)
	public void verifyReportsGraphAllocatedValue(){
		String sText;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Report);
		
		try {
			FrameworkUtil.sTestCaseName="verifyReportsGraphAllocatedValue";
			FrameworkUtil.sManualTestCaseName="(QAT-1350)(QAT-1332) Talonsp1 - Verify that date is selected and a graph is displayed";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to the navigator
			LoginTestCase.LoginAsEntity03User();
			
			// navigate to reports page
			navigateToReportsPage();
			
			// selecting the item from customer tiered storage levels
			selectCustomerTieredStorageLevelsDropDownItems("Physical Storage", "RAL", "SAN Storage - Capacity Tier - Recurring", "2016-04");
					
			// verify the storage tier drop down elements
			verifyStorageTierDropDownElements();
			WebObjectUtil.explicitWait(5);
			// verifying the graph
			WebObjectUtil.verifyElementPresent(Report.getNavReportsGraph());
			//WebObjectUtil.clickElement(Report.getNavReportsGraph());
			
		/// mouse over is NOT working so we could not get the allocated value.
			/*WebObjectUtil.MouseHover(Reports.getNavCommittedGraph_BlueColorline());
		  
			sText = Reports.getNavAllocatedValueInGB().getText();
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verifying the allocated value", "pass", "Allocated value is - "+sText);
			*/
			
			// log out
			LoginTestCase.nav_Logout();
			
		} catch (Exception e) {
			LoggerUtil.log_type_error("issue with verifyReportsGraphAllocatedValue test case");
		    LoggerUtil.log_type_error("Exception occured "+FrameworkUtil.sElementName);
		   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage());
		}
	}
	
	
	
	/*==============================================================
	TestScript 		: navVerifyChartContextMenuElements
	Manual TestCase	: QAT-1330,QAT-1327,QAT-1188
	Description		: Verify that Storage Reports page is closed and user is landed on Reports page
	Author 			: QAA04
	Creation Date 	: 04/25/2016
	Release Name    : LefcourtSP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=3)
	public void navVerifyChartContextMenuElements(){
		String sXpath;
		WebElement wTierDropDown;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Report);
		try{
		FrameworkUtil.sTestCaseName="navVerifyChartContextMenuElements";
		FrameworkUtil.sManualTestCaseName="(QAT-1330)(QAT-1327)(QAT-1188) TalonSP1 - Verify that Storage Reports page is closed and user is landed on Reports page";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		// login to the navigator
		LoginTestCase.LoginAsEntity03User();
		
		// navigating to the reports page.
		navigateToReportsPage();
		
		// selecting the item from customer tiered storage levels
		selectCustomerTieredStorageLevelsDropDownItems("Physical Storage", "RAL", "SAN Storage - Capacity Tier - Recurring", "2016-04");
				
		WebObjectUtil.explicitWait(3);
		// verifying the storage type drop down elements.
		WebObjectUtil.clickElement(Report.getNavCustomerTieredStorageLevelsDropDownArrow());
		sXpath = (String) FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
		wTierDropDown = WebObjectUtil.getActiveElementasWebElement(sXpath);
		
		WebObjectUtil.VerifyTextUnderElement(wTierDropDown, "Physical Storage");
		
		
		// verifying the storage tier drop down items
		verifyStorageTierDropDownElements();
		
		// verifying the graph
		WebObjectUtil.verifyElementPresent(Report.getNavReportsGraph());
		//WebObjectUtil.clickElement(Report.getNavReportsGraph());
					
		
		WebObjectUtil.verifyElementPresent(Report.getNavAllocatedGraph_GreenColorLine());
		WebObjectUtil.verifyElementPresent(Report.getNavCommittedGraph_BlueColorline());
		
		
		// verifying the chart context menu items
		verifyChartContextMenuElements();
		
		// clicking on close btn
		WebObjectUtil.clickElement(Report.getNavCloseBtn());
        WebObjectUtil.explicitWait(5);
		
        WebObjectUtil.verifyElementPresent(Report.getNavStorageReportsLink());
        
        // log out
		LoginTestCase.nav_Logout();
	}catch (Exception e) {
		LoggerUtil.log_type_error("issue with navVerifyChartContextMenuElements test case");
	    LoggerUtil.log_type_error("Exception occured "+FrameworkUtil.sElementName);
	   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage());
	}
}
	
	
	
//////////////////////////////////////////////////// METHODS ////////////////////////////////////////////////////
	
	/*==============================================================
	MethodName 		: navigateToReportsPage
	Manual TestCase	: 
	Description		: navigate to reports page
	Author 			: QAA04
	Creation Date 	: 04/21/2016
	release Name    : 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navigateToReportsPage(){
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Home);
		PageFactory.initElements(driver, Report);
		
		 try {
			// navigating to the report page
			WebObjectUtil.ClickAndMouseHover(Home.getNav_MonitoringTab());
			WebObjectUtil.clickElement(Home.getNav_ReportMenuLink());
			WebObjectUtil.verifyElementPresent(Report.getNavStorageReportsLink());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*==============================================================
	MethodName 		: selectCustomerTieredStorageLevelsDropDownItems
	Manual TestCase	: 
	Description		: select the items from customer tiered storage drop down
	Author 			: QAA04
	Creation Date 	: 04/21/2016
	release Name    : 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	public static void selectCustomerTieredStorageLevelsDropDownItems(String sStorageTypeDropDownVisibleText, String sPODDropDownVisibleText, String sTierDropDownVisibleText, String sDateDropDownVisibleText){
		
		String sULElementXpath;
		WebElement wCustomDropdown,wPODDropdown,wTierDropdown,wDateDropdown;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Report);
		
		 try {
			// clicking on storage reports link
			WebObjectUtil.clickElement(Report.getNavStorageReportsLink());
			
			// selecting the item from storageTypeDropDown
			WebObjectUtil.clickElement(Report.getNavCustomerTieredStorageLevelsDropDownArrow());
			sULElementXpath = (String) FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
			wCustomDropdown =WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
			WebObjectUtil.selectCustomWebList(wCustomDropdown, sStorageTypeDropDownVisibleText);
			
			// selecting the item from POD drop down
			WebObjectUtil.explicitWait(3);
			WebObjectUtil.clickElement(Report.getNavPhysicalStoragePODDropDownArrow());
			sULElementXpath = (String) FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
			wPODDropdown =WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
			WebObjectUtil.selectCustomWebList(wPODDropdown, sPODDropDownVisibleText);
   
			// selecting the item tier drop down
			WebObjectUtil.explicitWait(3);
			WebObjectUtil.clickElement(Report.getNavPhysicalStorageTierDropDownArrow());
			sULElementXpath = (String) FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
			wTierDropdown =WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
			WebObjectUtil.selectCustomWebList(wTierDropdown, sTierDropDownVisibleText);
			
			// selecting the item from date drop down
			WebObjectUtil.explicitWait(3);
			WebObjectUtil.clickElement(Report.getNavPhysicalStorageDateDropDownArrow());
			sULElementXpath = (String) FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
			wDateDropdown =WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
			WebObjectUtil.selectCustomWebList(wDateDropdown, sDateDropDownVisibleText);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
	}
	
	
	/*==============================================================
	MethodName 		: verifyStorageTierDropDownElements
	Manual TestCase	: 
	Description		: verify storage tier drop down items
	Author 			: QAA04
	Creation Date 	: 04/21/2016
	release Name    : 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void verifyStorageTierDropDownElements(){
		String sXpath;
		WebElement wTierDropDown;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Report);
		
		try {
			WebObjectUtil.clickElement(Report.getNavPhysicalStorageTierDropDownArrow());
			sXpath = (String) FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
			wTierDropDown = WebObjectUtil.getActiveElementasWebElement(sXpath);
			
			WebObjectUtil.VerifyTextUnderElement(wTierDropDown, "SAN Storage - Capacity Tier - Recurring");
			WebObjectUtil.VerifyTextUnderElement(wTierDropDown, "SAN Storage - Guaranteed HPerf Tier - Recurring");
			WebObjectUtil.VerifyTextUnderElement(wTierDropDown, "SAN Storage - High-Performance Tier - Recurring");
			WebObjectUtil.VerifyTextUnderElement(wTierDropDown, "SAN Storage - Performance Tier - Recurring");
			WebObjectUtil.VerifyTextUnderElement(wTierDropDown, "NAS Storage - Capacity Tier - Recurring");
			WebObjectUtil.VerifyTextUnderElement(wTierDropDown, "NAS Storage - Guaranteed HPerf Tier - Recurring");
			WebObjectUtil.VerifyTextUnderElement(wTierDropDown, "NAS Storage - High-Performance Tier - Recurring");
			WebObjectUtil.VerifyTextUnderElement(wTierDropDown, "NAS Storage - Performance Tier - Recurring");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*==============================================================
	MethodName 		: verifyChartContextMenuElements
	Manual TestCase	: 
	Description		: verify chart context menu elements
	Author 			: QAA04
	Creation Date 	: 04/21/2016
	release Name    : 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void verifyChartContextMenuElements(){
		String sPrint,sPng,sJpeg,sPdf,sSvg;
		WebElement wElement;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Report);
		
		   try {
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
///__________________________________________ Completed TalonSP1TestCases__________________________________________________________///////
///___________________________________________ out of scope test cases ____________________________________________________________///////
	
	
	/*==============================================================
	TestScript 		: verifyGraphForEachStorageTier
	Manual TestCase	: QAT-1366,QAT-1363
	Description		: Verify that date is selected and a graph is displayed for each storage tier
	Author 			: QAA04
	Creation Date 	: 06/02/2016
	Release Name    : Out of scope
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=51)
	public void verifyGraphForEachStorageTier(){
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Report);
		
		try {
			FrameworkUtil.sTestCaseName="verifyGraphForEachStorageTier";
			FrameworkUtil.sManualTestCaseName="(QAT-1366)(QAT-1363) Out of scope - Verify that date is selected and a graph is displayed for each storage tier";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to the navigator
			LoginTestCase.LoginAsEntity03User();
			
			// navigating to the reports page.  
			navigateToReportsPage();
			
			 // clicking on storage reports link
			 WebObjectUtil.clickElement(Report.getNavStorageReportsLink());
			
			 // selecting physical storage 
			 FirewallTestCase.SelectElementFromDropDown(Report.getNavCustomerTieredStorageLevelsDropDownArrow(), "Physical Storage");
				   
			 // selecting RAL from POD drop down
			 FirewallTestCase.SelectElementFromDropDown(Report.getNavPhysicalStoragePODDropDownArrow(), "RAL");
			 
			 FirewallTestCase.SelectElementFromDropDown(Report.getNavPhysicalStorageTierDropDownArrow(), "SAN Storage - Capacity Tier - Recurring");
			
			 // selecting date 
			 FirewallTestCase.SelectElementFromDropDown(Report.getNavPhysicalStorageDateDropDownArrow(), "2016-06");
			 WebObjectUtil.explicitWait(5);
			// WebObjectUtil.ClickAndMouseHover(Report.getNavReportsGraph());
			 WebObjectUtil.verifyElementPresent(Report.getNavAllocatedGraph_GreenColorLine());
			 WebObjectUtil.verifyElementPresent(Report.getNavCommittedGraph_BlueColorline());
			    
   //  selecting SAN Storage - Guaranteed HPerf Tier - Recurring from the tier drop down
			 FirewallTestCase.SelectElementFromDropDown(Report.getNavPhysicalStorageTierDropDownArrow(), "SAN Storage - Guaranteed HPerf Tier - Recurring");
			  // selecting date 
			 FirewallTestCase.SelectElementFromDropDown(Report.getNavPhysicalStorageDateDropDownArrow(), "2016-06");
			 WebObjectUtil.explicitWait(5);
			// WebObjectUtil.ClickAndMouseHover(Report.getNavReportsGraph());
			 WebObjectUtil.verifyElementPresent(Report.getNavAllocatedGraph_GreenColorLine());
			 WebObjectUtil.verifyElementPresent(Report.getNavCommittedGraph_BlueColorline());
			    
			 //  selecting SAN Storage - High-Performance Tier - Recurring from the tier drop down
			 FirewallTestCase.SelectElementFromDropDown(Report.getNavPhysicalStorageTierDropDownArrow(), "SAN Storage - High-Performance Tier - Recurring");
			  // selecting date 
			 FirewallTestCase.SelectElementFromDropDown(Report.getNavPhysicalStorageDateDropDownArrow(), "2016-06");
			 WebObjectUtil.explicitWait(5);
			 //WebObjectUtil.ClickAndMouseHover(Report.getNavReportsGraph());
			 WebObjectUtil.verifyElementPresent(Report.getNavAllocatedGraph_GreenColorLine());
			 WebObjectUtil.verifyElementPresent(Report.getNavCommittedGraph_BlueColorline());
			   
			 //  selecting SAN Storage - Performance Tier - Recurring from the tier drop down
			 FirewallTestCase.SelectElementFromDropDown(Report.getNavPhysicalStorageTierDropDownArrow(), "SAN Storage - Performance Tier - Recurring");
			  // selecting date 
			 FirewallTestCase.SelectElementFromDropDown(Report.getNavPhysicalStorageDateDropDownArrow(), "2016-06");
			 WebObjectUtil.explicitWait(5);
			 //WebObjectUtil.ClickAndMouseHover(Report.getNavReportsGraph());
			 WebObjectUtil.verifyElementPresent(Report.getNavAllocatedGraph_GreenColorLine());
			 WebObjectUtil.verifyElementPresent(Report.getNavCommittedGraph_BlueColorline());
			    
           //  selecting NAS Storage - Capacity Tier - Recurring from the tier drop down
			 FirewallTestCase.SelectElementFromDropDown(Report.getNavPhysicalStorageTierDropDownArrow(), "NAS Storage - Capacity Tier - Recurring");
			  // selecting date 
			 FirewallTestCase.SelectElementFromDropDown(Report.getNavPhysicalStorageDateDropDownArrow(), "2016-06");
			 WebObjectUtil.explicitWait(5);
			 //WebObjectUtil.ClickAndMouseHover(Report.getNavReportsGraph());
			 WebObjectUtil.verifyElementPresent(Report.getNavAllocatedGraph_GreenColorLine());
			 WebObjectUtil.verifyElementPresent(Report.getNavCommittedGraph_BlueColorline());
			    
			 //  selecting NAS Storage - Guaranteed HPerf Tier - Recurring from the tier drop down
			 FirewallTestCase.SelectElementFromDropDown(Report.getNavPhysicalStorageTierDropDownArrow(), "NAS Storage - Guaranteed HPerf Tier - Recurring");
			  // selecting date 
			 FirewallTestCase.SelectElementFromDropDown(Report.getNavPhysicalStorageDateDropDownArrow(), "2016-06");
			 WebObjectUtil.explicitWait(5);
			 //WebObjectUtil.ClickAndMouseHover(Report.getNavReportsGraph());
			 WebObjectUtil.verifyElementPresent(Report.getNavAllocatedGraph_GreenColorLine());
			 WebObjectUtil.verifyElementPresent(Report.getNavCommittedGraph_BlueColorline());
			 
			 //  selecting NAS Storage - High-Performance Tier - Recurring from the tier drop down
			 FirewallTestCase.SelectElementFromDropDown(Report.getNavPhysicalStorageTierDropDownArrow(), "NAS Storage - High-Performance Tier - Recurring");
			  // selecting date 
			 FirewallTestCase.SelectElementFromDropDown(Report.getNavPhysicalStorageDateDropDownArrow(), "2016-06");
			 WebObjectUtil.explicitWait(5);
			 //WebObjectUtil.ClickAndMouseHover(Report.getNavReportsGraph());
			 WebObjectUtil.verifyElementPresent(Report.getNavAllocatedGraph_GreenColorLine());
			 WebObjectUtil.verifyElementPresent(Report.getNavCommittedGraph_BlueColorline());
			 
			 //  selecting NAS Storage - Performance Tier - Recurring from the tier drop down
			 FirewallTestCase.SelectElementFromDropDown(Report.getNavPhysicalStorageTierDropDownArrow(), "NAS Storage - Performance Tier - Recurring");
			  // selecting date 
			 FirewallTestCase.SelectElementFromDropDown(Report.getNavPhysicalStorageDateDropDownArrow(), "2016-06");
			 WebObjectUtil.explicitWait(5);
			// WebObjectUtil.ClickAndMouseHover(Report.getNavReportsGraph());
			 WebObjectUtil.verifyElementPresent(Report.getNavAllocatedGraph_GreenColorLine());
			 WebObjectUtil.verifyElementPresent(Report.getNavCommittedGraph_BlueColorline());
			 
			 
			// log out
			 LoginTestCase.nav_Logout();
		}catch (Exception e) {
			LoggerUtil.log_type_error("issue with verifyGraphForEachStorageTier test case");
		    LoggerUtil.log_type_error("Exception occured "+FrameworkUtil.sElementName);
		   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage());
		}
	}
	
	
	
	
//////////////////////////////////////////////////////////QAA04//////////////////////////////////////////////////////////////////////////////////////////	
	
	
	
	//update each @Test result in custom result file
	@AfterMethod
	public static void afterEachMethod(){
		FrameworkUtil.updateTestCaseStatusinResult();
		
	}
	
	
	
}
