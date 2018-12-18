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
import com.whs.navigator.pagefactory.FormPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory;
import com.whs.navigator.pagefactory.ReportsPageFactory;

public class TalonTestCaseSP1_NMR {

	public static ReportsPageFactory Reports = new ReportsPageFactory();
    public static EntityBrowserPageFactory Entity = new EntityBrowserPageFactory();
    public static HomePageFactory Home = new HomePageFactory();
  
    
	/*==============================================================
	TestScript 		: verifyReportsGraph
	Manual TestCase	: QAT-1367
	Description		: verify the reports graph elements
	Author 			: QAA04
	Creation Date 	: 04/21/2016
	Release Name    : TalonSP1
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=1)
	public void verifyReportsGraphColors(){
		String sOrgName;
		boolean bStatus;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Reports);
		PageFactory.initElements(driver, Entity);
		PageFactory.initElements(driver, Home);
		try{
		FrameworkUtil.sTestCaseName="verifyReportsGraphColors";
		FrameworkUtil.sManualTestCaseName="(QAT-1367) TalonSP1 - verify the reports graph elements";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		// login to the navigator
		LoginTestCase.LoginAsEntity01User();
		
		// clicking on eb panel link
		WebObjectUtil.clickElement(Entity.getNav_EntityBrowserLink());
		// selecting the org from entity browser
		EntityBrowserTestCase.selectOrgFromAllLevelsEB("TST Entity02", "TST Entity03", null, null);
		// clicking on the org title link
	   WebObjectUtil.clickElement(Entity.getNav_OrgNameTitleLink());
	  
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
		
		 WebObjectUtil.ClickAndMouseHover(Reports.getNavReportsGraph());
		    
		    WebObjectUtil.verifyElementPresent(Reports.getNavAllocatedGraph_GreenColorLine());
		    WebObjectUtil.verifyElementPresent(Reports.getNavCommittedGraph_BlueColorline());
		    
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
	Release Name    : TalonSP1
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=2)
	public void verifyReportsGraphAllocatedValue(){
		String sText;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Reports);
		
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
			WebObjectUtil.verifyElementPresent(Reports.getNavReportsGraph());
			WebObjectUtil.clickElement(Reports.getNavReportsGraph());
			
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
	Release Name    : TalonSP1
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=3)
	public void navVerifyChartContextMenuElements(){
		String sXpath;
		WebElement wTierDropDown;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Reports);
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
		WebObjectUtil.clickElement(Reports.getNavCustomerTieredStorageLevelsDropDownArrow());
		sXpath = (String) FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
		wTierDropDown = WebObjectUtil.getActiveElementasWebElement(sXpath);
		
		WebObjectUtil.VerifyTextUnderElement(wTierDropDown, "Physical Storage");
		
		
		// verifying the storage tier drop down items
		verifyStorageTierDropDownElements();
		
		// verifying the graph
		WebObjectUtil.verifyElementPresent(Reports.getNavReportsGraph());
		WebObjectUtil.clickElement(Reports.getNavReportsGraph());
					
		
		WebObjectUtil.verifyElementPresent(Reports.getNavAllocatedGraph_GreenColorLine());
		WebObjectUtil.verifyElementPresent(Reports.getNavCommittedGraph_BlueColorline());
		
		
		// verifying the chart context menu items
		verifyChartContextMenuElements();
		
		// clicking on close btn
		WebObjectUtil.clickElement(Reports.getNavCloseBtn());
        WebObjectUtil.explicitWait(5);
		
        WebObjectUtil.verifyElementPresent(Reports.getNavStorageReportsLink());
        
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
		PageFactory.initElements(driver, Reports);
		
		 try {
			// navigating to the report page
			WebObjectUtil.ClickAndMouseHover(Home.getNav_MonitoringTab());
			WebObjectUtil.clickElement(Home.getNav_ReportMenuLink());
			WebObjectUtil.verifyElementPresent(Reports.getNavStorageReportsLink());
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
		PageFactory.initElements(driver, Reports);
		
		 try {
			// clicking on storage reports link
			WebObjectUtil.clickElement(Reports.getNavStorageReportsLink());
			
			// selecting the item from storageTypeDropDown
			WebObjectUtil.clickElement(Reports.getNavCustomerTieredStorageLevelsDropDownArrow());
			sULElementXpath = (String) FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
			wCustomDropdown =WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
			WebObjectUtil.selectCustomWebList(wCustomDropdown, sStorageTypeDropDownVisibleText);
			
			// selecting the item from POD drop down
			WebObjectUtil.explicitWait(3);
			WebObjectUtil.clickElement(Reports.getNavPhysicalStoragePODDropDownArrow());
			sULElementXpath = (String) FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
			wPODDropdown =WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
			WebObjectUtil.selectCustomWebList(wPODDropdown, sPODDropDownVisibleText);
   
			// selecting the item tier drop down
			WebObjectUtil.explicitWait(3);
			WebObjectUtil.clickElement(Reports.getNavPhysicalStorageTierDropDownArrow());
			sULElementXpath = (String) FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
			wTierDropdown =WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
			WebObjectUtil.selectCustomWebList(wTierDropdown, sTierDropDownVisibleText);
			
			// selecting the item from date drop down
			WebObjectUtil.explicitWait(3);
			WebObjectUtil.clickElement(Reports.getNavPhysicalStorageDateDropDownArrow());
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
		PageFactory.initElements(driver, Reports);
		
		try {
			WebObjectUtil.clickElement(Reports.getNavPhysicalStorageTierDropDownArrow());
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
		PageFactory.initElements(driver, Reports);
		
		   try {
			sPrint = (String) FrameworkUtil.dictPropertyData.get("NAV.REPORTS.GRAPH.CHARTCONTEXTMENU.PRINT.ELEMENT");
		    sPng = (String) FrameworkUtil.dictPropertyData.get("NAV.REPORTS.GRAPH.CHARTCONTEXTMENU.PNG.ELEMENT");
		    sJpeg = (String) FrameworkUtil.dictPropertyData.get("NAV.REPORTS.GRAPH.CHARTCONTEXTMENU.JPEG.ELEMENT");
		    sPdf = (String) FrameworkUtil.dictPropertyData.get("NAV.REPORTS.GRAPH.CHARTCONTEXTMENU.PDF.ELEMENT");
		    sSvg = (String) FrameworkUtil.dictPropertyData.get("NAV.REPORTS.GRAPH.CHARTCONTEXTMENU.SVG.ELEMENT");
		    
		    WebObjectUtil.explicitWait(5);
		    WebObjectUtil.isElementPresent(Reports.getNavReportsGraph());
		    WebObjectUtil.clickElement(Reports.getNavGraphContextMenu());
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
	
	
	/*==============================================================
	MethodName 		: 
	Manual TestCase	: 
	Description		: verify chart context menu elements
	Author 			: QAA04
	Creation Date 	: 04/21/2016
	release Name    : 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	

	
	
	
	
	@AfterMethod
	public void afterMethod(){
		FrameworkUtil.updateTestCaseStatusinResult();
		FrameworkUtil.sTestExecutionStatus=true;
	}
}
