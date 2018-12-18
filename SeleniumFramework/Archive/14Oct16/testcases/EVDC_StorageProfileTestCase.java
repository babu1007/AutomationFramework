package com.whs.navigator.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.EVDC_StorageProfilePageFactory;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.CommonPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.SmokeTestPageFactory;

public class EVDC_StorageProfileTestCase {
	
	public static EVDC_StorageProfilePageFactory EVDC_Storage = new EVDC_StorageProfilePageFactory();
	public static EVDC_OverviewPageFactory EVDC_OverviewPF = new EVDC_OverviewPageFactory();
	public static CommonPageFactory Common = new CommonPageFactory();
	static HomePageFactory_old Home = new HomePageFactory_old();
	static SmokeTestPageFactory Smoke = new SmokeTestPageFactory();
	
	/*==============================================================
	TestScript  	: navVerifyBreadCrumbInStorageDetailsPage
	Manual TestCase	: Verify the bread Crumb in Storage Details page - CPPOC-3028
	Description		:
	Author 			: Sukur Babu. B
	Creation Date 	: 05/08/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	   @Test(priority=57)
	   
	   public void navVerifyBreadCrumbInStorageDetailsPage() {

		   try{
				WebDriver driver = WebDriverUtil.getDriver();
				
				PageFactory.initElements(driver, EVDC_Storage);
				PageFactory.initElements(driver, EVDC_OverviewPF);
				
				FrameworkUtil.sTestCaseName = "Clark-navVerifyBreadCrumbInStorageDetailsPage";
				FrameworkUtil.sManualTestCaseName = "Verify the bread Crumb in Storage Details page - CPPOC-3028";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
				
				String sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO.USERID.AROLE");
				String sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO.PASSWORD.AROLE");
				//LoginTestCase.nav_Login(sUserName, sPassword);
				LoginTestCase_Old1.LoginAsQaautoUser();
				
			    
		
		       WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
		       WebObjectUtil.clickElement(EVDC_Storage.getNav_StorageLink());
		       WebObjectUtil.explicitWait(5);
		       //WebObjectUtil.verifyElementPresent(pf.getBreadCrumbChain());
		       WebObjectUtil.VerifyTextUnderElement(EVDC_Storage.getNav_breadCrumbChain(), "Storage Profiles");
		
		       LoginTestCase_Old1.nav_Logout();
		}
		catch(Exception e)
		{
			LoggerUtil.log_type_error("issue with- navVerifyBreadCrumbInStorageDetailsPage Test Case" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}


	}
	   
	   /*==============================================================
	   TestScript  	: navVerifyEVDCSelectorInStorageDetailsPage
	   Manual TestCase	: Verify the EVDC Selector in Storage Details page - CPPOC-3027
	   Description		:
	   Author 			: Sukur Babu. B
	   Creation Date 	: 05/08/2015
	   Pre-Requisites	:
	   Revision History:
	   ==============================================================*/

	    @Test(priority=58)
	    public void navVerifyEVDCSelectorInStorageDetailsPage() {
		try{
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, EVDC_Storage);
			PageFactory.initElements(driver, EVDC_OverviewPF);
			
		FrameworkUtil.sTestCaseName = "Clark-navVerifyEVDCSelectorInStorageDetailsPage";
		FrameworkUtil.sManualTestCaseName = "Verify the EVDC Selector in Storage Details page - CPPOC-3027";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);

		String sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO.USERID.AROLE");
		String sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO.PASSWORD.AROLE");
		
		//LoginTestCase.nav_Login(sUserName, sPassword);
		LoginTestCase_Old1.LoginAsQaautoUser();
		    

	   WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
	   WebObjectUtil.clickElement(EVDC_Storage.getNav_StorageLink());
	   WebObjectUtil.explicitWait(5);
	  // WebObjectUtil.verifyElementPresent(pf.getEVDC_Selector());
	 // WebObjectUtil.VerifyTextUnderElement(EVDC_OverviewPF.getNav_EVDCOrgSelector(), "Andover, MA - tstdevco1");
	   WebObjectUtil.VerifyTextUnderElement(EVDC_OverviewPF.getNav_EVDCOrgSelector(), "Nashville, TN - tstqaauto");
	    
	  
	    LoginTestCase_Old1.nav_Logout();
		}
		catch(Exception e)
		{
			LoggerUtil.log_type_error("issue with- navVerifyEVDCSelectorInStorageDetailsPage Test Case" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	    /*==============================================================
		   TestScript  	    : verifyEachStorageTierDetailsOnStoragePage
		   Manual TestCase	: CPPOC-2774 (CPPOC-3026, CPPOC-2980, CPPOC-2431),Storage Tier details in Storage details page
		   Description		:
		   Author 			: Arul
		   Creation Date 	: 
		   Pre-Requisites	:
		   Revision History:
		   ==============================================================*/
	// This TestScript is Combination of jira nos 2774,2768,2773 and 3026 from Clark   
	    @Test(priority=10)
	    public void verifyEachStorageTierDetailsOnStoragePage(){
	    	int iStorageElementCount;
	    	String sInfoIcon;
	    	WebElement wInfoIcon;
	    	
	    	WebDriver driver = WebDriverUtil.getDriver();
	    	PageFactory.initElements(driver, EVDC_Storage);
			PageFactory.initElements(driver, EVDC_OverviewPF);
			PageFactory.initElements(driver, Common);
	    	
	    	try {
	    		FrameworkUtil.sTestCaseName = "verifyEachStorageTierDetailsOnStoragePage";
	    		FrameworkUtil.sManualTestCaseName="CPPOC-2774 (CPPOC-3026, CPPOC-2980, CPPOC-2431),Storage Tier details in Storage details page";
	    		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	    		
	    		String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.USERID");
	    		String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.PASSWORD");
	    		//LoginTestCase.nav_Login(sUserName, sPassword);
	    		LoginTestCase_Old1.LoginAsQaautoUser();
	    				
	    	    WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
	    	    WebObjectUtil.clickElement(EVDC_Storage.getNav_StorageLink());
	    	    WebObjectUtil.verifyElementPresent(EVDC_Storage.getNav_AddStoraegTeirLink());
	    	    WebObjectUtil.verifyElementPresent(Common.getNav_PdfIcon());
	    	    WebObjectUtil.verifyElementPresent(Common.getNav_CsvIcon());
	    	   // verifyStorageTierDetails();	
	    	    
	    		//List<WebElement> wStorageValues = Clark.getNav_StoragePortletFirstTierStorageValue();
	    		List<WebElement> wStorageTier = driver.findElements(By.xpath("//section[@id='storageProfileCharts']/div[@class='sp_rect']"));
	    		iStorageElementCount= wStorageTier.size();
	    		for (int iIndex=0; iIndex<iStorageElementCount;iIndex++ ){
	    			verifyStorageTierDetails(iIndex);
	    			
	    			
	    			sInfoIcon ="//div[@id='storage-chart-" + iIndex + "']/div/span/img[@alt='infoIcon']";
	    			wInfoIcon = WebObjectUtil.GetWebElement("xpath", sInfoIcon, "sInfoIcon");
	    			FrameworkUtil.sElementName = "wInfoIcon";
	    			WebObjectUtil.verifyElementPresent(wInfoIcon);
	    		}
	    		
	    		
	    /*			
	    	String sStorageText;
	    	int iStorageElementCount;	    
	    		//List<WebElement> wStorageValues = Clark.getNav_StoragePortletFirstTierStorageValue();
	    	    List<WebElement> wStorageValues = driver.findElements(By.xpath("//div[@id='storage-chart-0']//svg:tspan"));
	    	    iStorageElementCount= wStorageValues.size();
	    	    if (iStorageElementCount != 4){
	    	    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Storage Elements count", "fail", "Expected : 4 and actual : " +iStorageElementCount );
	    	    }
	    	    for (WebElement wStorage : wStorageValues){
	    	    	sStorageText =wStorage.getText();
	    	    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Element", "pass", sStorageText);
	    	    	
	    	    }
	    	  */
	    	    
	    /*		    WebObjectUtil.verifyElementPresent(Clark.getNav_StoragePortletFirstTierSliderAllocated());
	    	    FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Allocated memory", "done", Clark.getNav_StoragePortletFirstTierSliderAllocated().getText() );
	    	    WebObjectUtil.verifyElementPresent(Clark.getNav_StoragePortletFirstTierSliderCommitted());
	    	    FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Allocated memory", "done", Clark.getNav_StoragePortletFirstTierSliderCommitted().getText() );
	    	    */

	    	    
	    	    LoginTestCase_Old1.nav_Logout();
	    	    
	    	} catch (Exception e) {
	    		// TODO Auto-generated catch block
	    		LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
	    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
	    	}
	    }
	    /*==============================================================
		   TestScript  	    : verifyEachStorageTierOnStoragePortlet
		   Manual TestCase	: CPPOC-2767 (CPPOC-2945, CPPOC-2980, CPPOC-2431),Storage Tier details in Storage portlet under EVDC over view page
		   Description		:
		   Author 			: Arul
		   Creation Date 	: 
		   Pre-Requisites	:
		   Revision History:
		   ==============================================================*/
	    @Test(priority=11)
	    public void verifyEachStorageTierOnStoragePortlet(){
	    	int iStorageElementCount;
	    	String sDotIcon;
	    	WebElement wDotIcon;
	    	
	    	WebDriver driver = WebDriverUtil.getDriver();
	    	PageFactory.initElements(driver, EVDC_Storage);
			PageFactory.initElements(driver, EVDC_OverviewPF);
	    	
	    	try {
	    		FrameworkUtil.sTestCaseName = "verifyEachStorageTierOnStoragePortlet";
	    		FrameworkUtil.sManualTestCaseName="CPPOC-2767 (CPPOC-2945, CPPOC-2980, CPPOC-2431),Storage Tier details in Storage portlet under EVDC over view page";
	    		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	    		
	    		String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.USERID");
	    		String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.PASSWORD");
	    		//LoginTestCase.nav_Login(sUserName, sPassword);
	    		LoginTestCase_Old1.LoginAsQaautoUser();
	    				
	    	    WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());

	    	    
	    		//List<WebElement> wStorageValues = Clark.getNav_StoragePortletFirstTierStorageValue();
	    		List<WebElement> wStorageTier = driver.findElements(By.xpath("//div[@id='chart_storage']//div[@class='bx-pager-item']"));
	    		iStorageElementCount= wStorageTier.size();
	    		for (int iIndex=0; iIndex<iStorageElementCount;iIndex++ ){

	    			//sDotIcon ="//div[@id='chart_storage']//div[@class='bx-pager-item']/a[@data-slide-index='" + iIndex + "']";
	    			//wDotIcon = WebObjectUtil.GetWebElement("xpath", sDotIcon, "sDotIcon");
	    			 // This object is updated on 10/13/2015 By QAA04
	    			wDotIcon = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.STORAGE.DOTICON", "PARAMATER_INDEXNUMBER",  iIndex +"");
	    			WebObjectUtil.clickElement(wDotIcon);
	    			WebObjectUtil.explicitWait(2);
	    			verifyStorageTierDetails(iIndex);

	    			
	    		}

	    		LoginTestCase_Old1.nav_Logout();
	    	    
	    	} catch (Exception e) {
	    		// TODO Auto-generated catch block
	    		LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
	    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
	    	}
	    }

	    /*==============================================================
		Method Name 	: verifyStorageTierDetails
		Description		: verifying all StorageTier Details in Storage Profile Page
		Author 			: Arul
		Creation Date 	: 
		Pre-Requisites	:
		Revision History:
		==============================================================*/



	    public static void verifyStorageTierDetails(int iIndex){
	    	boolean sFlag = true;
	    	int iStorageElementCount,idx;
	    	String sAllocated,sCommited,sTierName,sAllocatedGraph,sCommitedGraph,sInfoIcon,sInfoIconText;
	    	WebElement wAllocated,wCommited,wTierName,wAllocatedGraph,wCommitedGraph,wInfoIcon,wInfoIconText;

	    	
	    	WebDriver driver = WebDriverUtil.getDriver();
	    	
	    	idx = iIndex;
	    	try {

	    			/*sAllocated ="//*[@id='storage-chart-svg-" + idx + "']/*[name()='text'][1]";
	    			sCommited ="//*[@id='storage-chart-svg-" + idx + "']/*[name()='text'][2]";
	    			sAllocatedGraph ="//*[@id='storage-chart-svg-" + idx + "']/*[name()='rect'][1]";
	    			sCommitedGraph ="//*[@id='storage-chart-svg-" + idx + "']/*[name()='rect'][2]";
	    			//sTierName ="//div[@id='storage-chart-" + idx + "']//div[@class='spname']";
	    			sTierName ="//div[@id='storage-chart-" + idx + "']/div";

	    			wAllocated = WebObjectUtil.GetWebElement("xpath", sAllocated, "sAllocated");
	    		    wCommited = WebObjectUtil.GetWebElement("xpath", sCommited, "sCommited");
	    			wCommitedGraph = WebObjectUtil.GetWebElement("xpath", sCommitedGraph, "sCommitedGraph");
	    			wAllocatedGraph = WebObjectUtil.GetWebElement("xpath", sAllocatedGraph, "sAllocatedGraph");
	    			wTierName = WebObjectUtil.GetWebElement("xpath", sTierName, "sTierName");
	    */
	    			wAllocated = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.STORAGEPROFILE.ALLOCATED", "PARAMETER_INDEX", idx+"");
	    			//wCommited = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.STORAGEPROFILE.COMMITED", "PARAMETER_INDEX", idx+"");
	    			//wCommitedGraph = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.STORAGEPROFILE.COMMITEDGRAPH", "PARAMETER_INDEX", idx+"");
	    			wAllocatedGraph = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.STORAGEPROFILE.ALLOCATEDGRAPH", "PARAMETER_INDEX", idx+"");
	    			wTierName = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.STORAGEPROFILE.TIERNAME", "PARAMETER_INDEX", idx+"");
	    			
	    			try {
	    				verifyStorageElement(wTierName,"sTierName",true);
	    				verifyStorageElement(wAllocated,"sAllocated",true);
	    				//verifyStorageElement(wCommited,"sCommited",true);
	    				verifyStorageElement(wAllocatedGraph,"sAllocatedGraph",false);
	    				//verifyStorageElement(wCommitedGraph,"sCommitedGraph",false);

	    			/*	
	    				FrameworkUtil.sElementName = "sTierName";
	    				WebObjectUtil.verifyElementPresent(wTierName);
	    				FrameworkUtil.sElementName = "wAllocated";
	    				WebObjectUtil.verifyElementPresent(wAllocated);
	    				FrameworkUtil.sElementName = "wCommited";
	    				WebObjectUtil.verifyElementPresent(wCommited);
	    				FrameworkUtil.sElementName = "wAllocatedGraph";
	    				WebObjectUtil.verifyElementPresent(wAllocatedGraph);
	    				FrameworkUtil.sElementName = "wCommitedGraph";
	    				WebObjectUtil.verifyElementPresent(wCommitedGraph);

	    				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "wTierName" , "sTierName", "done", wTierName.getText() );
	    				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "wAllocated" , "sAllocated", "done", wAllocated.getText() );
	    				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "wAllocatedGraph" , "sAllocatedGraph", "done", wAllocatedGraph.getText() );
	    				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "wCommited" , "sCommited", "done", wCommited.getText() );
	    				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "wCommitedGraph" , "sCommitedGraph", "done", wCommitedGraph.getText() );
	    	*/
	    /*					sInfoIcon ="//div[@id='storage-chart-" + idx + "']/div/span/img[@alt='infoIcon']";
	    				sInfoIconText ="//div[@id='storage-chart-" + idx + "']/div/span/span";
	    				wInfoIcon = WebObjectUtil.GetWebElement("xpath", sInfoIcon, "sInfoIcon");
	    				FrameworkUtil.sElementName = "wInfoIcon";
	    				WebObjectUtil.verifyElementPresent(wInfoIcon);
	    				
	    				WebObjectUtil.clickElement(wInfoIcon);
	    				wInfoIconText = WebObjectUtil.GetWebElement("xpath", sInfoIconText, "sInfoIconText");
	    				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "wInfoIconText" , "sInfoIconText", "done", wInfoIconText.getText() );
	    				WebObjectUtil.MouseHover(wTierName);
	    				
	    				
	    			*/	
	    			} catch (Exception e) {
	    				LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
	    			}
	    			
	    			

	    	} catch (Exception e) {
	    		LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
	    	}
	      
	    }

	    /*==============================================================
		Method Name 	: verifyStorageElement
		Description		: verifying Storage Element in Storage Profile Page
		Author 			: Arul
		Creation Date 	: 
		Pre-Requisites	:
		Revision History:
		==============================================================*/

	    public static boolean verifyStorageElement(WebElement wStorageElement, String sStorageElementName,boolean bFailTestCase){
	    	boolean bStatus = false;
	    	
	    	//bStatus = WebObjectUtil.isElementPresent(wStorageElement);
	    	if (wStorageElement != null && WebObjectUtil.isElementPresent(wStorageElement) ){
	    		bStatus = WebObjectUtil.isElementPresent(wStorageElement);
	    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), sStorageElementName , sStorageElementName, "pass", wStorageElement.getText() );
	    	}else{
	    		if (bFailTestCase)
	    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), sStorageElementName, sStorageElementName, "fail", "Element not present:" + sStorageElementName );
	    		else
	    			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), sStorageElementName, sStorageElementName, "warn", "issue with Identifying element" + sStorageElementName );	
	    	}
	    return bStatus;
	    }
 //////////////////////////////////////////// GideonTestCases /////////////////////////////////// 
	    
	    /*==============================================================
		TestScript  	: navValStoragePgDsply
		Manual TestCase	: CPPOC-3342-Storage page dispaly when user clicks on storage portlet
		Description		: Storage page dispaly when user clicks on storage portlet
		Author 			: Vivek Kumar
		Creation Date 	: 08/25/2015
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		@Test(priority=22)
		public void navValStoragePgDsply()
		{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, EVDC_OverviewPF);
			
			FrameworkUtil.sTestCaseName = "Gideon-navValStoragePgDsply";
			FrameworkUtil.sManualTestCaseName="CPPOC-3342-Storage page dispaly when user clicks on storage portlet";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

			String sUserName,sPassword;
			boolean bStatus;
			
			
			sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLE.USERID");
			sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLE.PWD");
			//LoginTestCase.nav_Login(sUserName, sPassword);
			LoginTestCase_Old1.LoginAsQaautoUser();
			
			//clicking on EVDC link
			//WebObjectUtil.clickAndVerifyText(EVDC_OverviewPF.getNav_EVDCname(), "Storage");
			WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
			WebObjectUtil.explicitWait(10);
			//Clicking on Storage Link
			bStatus=WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCOverviewStorage(), EVDC_OverviewPF.getNav_AddStoraegTeirLink());
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Storage page displayed");
			
			//Logout
			LoginTestCase_Old1.nav_Logout();
			
		}
	    
		/*==============================================================
		TestScript  	: navValCldGraphValidation
		Manual TestCase	:CPPOC-3079-Private Cloud_Graph display for VM Utilization/Storage Portlet and Storage Page
		Description		: Verify Cloud Graph
		Author 			: Vivek Kumar
		Creation Date 	: 08/31/2015
		Pre-Requisites	:
		Revision History:
		==============================================================*/
		@Test(priority=26)
		public void navValCldGraphValidation()
		{
			WebDriver driver = WebDriverUtil.getDriver();
			
			PageFactory.initElements(driver, EVDC_OverviewPF);
			
			
			
			boolean bStatus;
			int iStorageElementCount;
			
		
			
			FrameworkUtil.sTestCaseName = "Gideon-navValCldGraphValidation";
			FrameworkUtil.sManualTestCaseName="CPPOC-3079-Private Cloud_Graph display for VM Utilization/Storage Portlet and Storage Page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

			String sUserName,sPassword,sDotIcon;
			WebElement wDotIcon;
			
			sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
			sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
			
			//LoginTestCase.nav_Login(sUserName, sPassword);
			LoginTestCase_Old1.LoginAsGirUser();
			
			//Clicking on Private Cloud EVDC link and verifying its landing page
			//WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
			WebElement wPrivate=EVDC_Overview_TestCase.getFirstPrivateCloud();
			
			//wPrivate.click();
			WebObjectUtil.clickByJS(wPrivate);
			
			WebObjectUtil.verifyElementPresent( EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			
		//Verifying Storage graph and allocated text and "commited" should not be there at portlet
			List<WebElement> wStorageTier = driver.findElements(By.xpath("//div[@id='chart_storage']//div[@class='bx-pager-item']"));
			iStorageElementCount= wStorageTier.size();
			for (int iIndex=0; iIndex<iStorageElementCount;iIndex++ ){

				//sDotIcon ="//div[@id='chart_storage']//div[@class='bx-pager-item']/a[@data-slide-index='" + iIndex + "']";
				//wDotIcon = WebObjectUtil.GetWebElement("xpath", sDotIcon, "sDotIcon");
				 // This object is updated on 10/15/2015 By QAA04
				wDotIcon = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.STORAGE.DOTICON", "PARAMATER_INDEXNUMBER",  iIndex +"");    
				WebObjectUtil.clickElement(wDotIcon);
				WebObjectUtil.explicitWait(2);
				verifyStorageTierDetails(iIndex);
		}
			
			//Clicking Storage portlet and verfying its landing page
			//Clicking on Storage Link
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCOverviewStorage(), EVDC_OverviewPF.getNav_AddStoraegTeirLink());
			
			List<WebElement> wStoragePage = driver.findElements(By.xpath("//section[@id='storageProfileCharts']/div[@class='sp_rect']"));
			iStorageElementCount= wStoragePage.size();
			for (int iIndex=0; iIndex<iStorageElementCount;iIndex++ ){
				verifyStorageTierDetails(iIndex);
			}

			//Logout
			LoginTestCase_Old1.nav_Logout();
			
		} 
		
////////////////////////////// Completed GideonTestCases ////////////////////////////////////////   
		
		

/*==============================================================
Method Name 	: verifyStorageElementNotPresent
Description		: verifying Storage Element NOT Present in Storage Profile Page
Author 			: Arul
Creation Date 	: 
Pre-Requisites	:
Revision History:
==============================================================*/

public static void verifyCommitElementNotPresent(){

	int iStorageElementCount;
	WebElement wCommited;
	WebDriver driver = WebDriverUtil.getDriver();
	
	try {
		List<WebElement> wStorageTier = driver.findElements(By.xpath("//section[@id='storageProfileCharts']/div[@class='sp_rect']"));
		iStorageElementCount= wStorageTier.size();
		for (int iIndex=0; iIndex<iStorageElementCount;iIndex++ ){
			wCommited = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.STORAGEPROFILE.COMMITED", "PARAMETER_INDEX", iIndex+"");
			
			if (wCommited==null){
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Commit Element", "pass", "Success:Commit Element NOT present as expected ");
			}else{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Commit Element", "fail", "Failure:Commit Element present, but expected is Commit element should not present");
			}
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

}
///////// _____________________Hague Test cases ________________________________///
/*==============================================================
TestScript  	: verifyCommitNotPresent
Manual TestCase	: [QAT-256]Verify that "Committed" values are not displayed for customers who are Non-CBU(ie. Legacy).
Description		: Verify that "Committed" values are not displayed for customers who are Non-CBU(ie. Legacy).
Author 			: Arul
Creation Date 	: 12/07/2015
release Name    : Hague
Pre-Requisites	:
Revision History:
==============================================================*/

// do not execute script with user "JEFF.PARLANCE" as it does not have EVDC
//@Test(priority=4)
public void verifyCommitNotPresent()
{
	String sUserName,sPassword;
	
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, Home);
	PageFactory.initElements(driver, Smoke);

	
	FrameworkUtil.sTestCaseName = "Home-verifyCommitNotPresent";
	FrameworkUtil.sManualTestCaseName= "[QAT-256]Verify that 'Committed' values are not displayed for customers who are Non-CBU(ie. Legacy).";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

	sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.USERID.JEFF.PARLANCE");
	sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.PASSWORD.JEFF.PARLANCE");

	LoginTestCase_Old1.nav_Login(sUserName, sPassword);
	EVDC_StorageProfileTestCase.navigateToStorageTierPage();
	EVDC_StorageProfileTestCase.verifyCommitElementNotPresent();


	LoginTestCase_Old1.nav_Logout();
	
}



//// ___________________ Completed Hague test cases _____________________________ /////

/// _________________________ Kyle test cases _________________________________________ ///

/*==============================================================
TestScript  	: valEVDCStorageProfilePortlet
Manual TestCase	: QAT-833-WCP_5231_TC_1.0_EVDC Overview page- Storage
Description		: Verify that the Storage reporting portlet is displayed stacked tiers instead of carousal 
Author 			: Vivek Kumar
Creation Date 	: 06/22/2016
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=4)
public void valEVDCStorageProfilePortlet()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EVDC_OverviewPF);	
	PageFactory.initElements(driver, EVDC_Storage);	
	
	int iCirleSize;
	WebElement wToolTipText;
	String sStorageProfileToolTip;
	
	FrameworkUtil.sTestCaseName = "Kyle-valEVDCStorageProfilePortlet";
	FrameworkUtil.sManualTestCaseName = "QAT-833-WCP_5231_TC_1.0_EVDC Overview page- Storage";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);

	sStorageProfileToolTip=(String) FrameworkUtil.dictDynamicPagePactory.get("NAV.EVDC.STORAGE.PORTLET.TOOLTIP.MESSAGE");
						
	try {
		//Login to Navigator using QaAuto
		LoginTestCase_Old1.LoginAsQaautoAUser();
		
		//Navigate to EVDC-VM page
		WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
		
		//Getting the total count of circle
		//List<WebElement> lstStorageProfileCircle  = driver.findElements(By.xpath(EVDC_StorageProfile.getNav_StorageProfileCircle()));
		iCirleSize= EVDC_Storage.getNav_StorageProfileCircle().size();
		if(iCirleSize<9)
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verifying Max number of tiers dispayed is 8 ", "pass", "Max number of tiers displayed "+iCirleSize);
			//Capturing the tooltip message for each circle available at Storage portlet
			for(WebElement toolTipElement : EVDC_Storage.getNav_StorageProfileCircle())
			{
				WebObjectUtil.clickElement(toolTipElement);
				WebObjectUtil.explicitWait(2);
				wToolTipText=WebObjectUtil.getActiveElementasWebElement(sStorageProfileToolTip);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "ToolTip Message on EVDC- Storage portlet ", "pass",wToolTipText.getText());
			}
		}
		else
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verifying Max number of tiers dispayed is 8 ", "fail", "Max number of tiers displayed "+iCirleSize);
		}
		//Login Out
		LoginTestCase_Old1.nav_Logout();
	} catch (Exception e) {
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
	}

}






/// _________________________ Completed kyle test cases _______________________________________ ////
public static boolean navigateToStorageTierPage(){
	boolean bStatus = false;
	try {
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_Storage);
		PageFactory.initElements(driver, EVDC_OverviewPF);
	//	WebObjectUtil.scrollElementAtPageCenter(EVDC_OverviewPF.getNav_EVDCname());
		WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
		WebObjectUtil.clickElement(EVDC_Storage.getNav_StorageLink());
		bStatus= WebObjectUtil.verifyElementPresent(EVDC_Storage.getNav_AddStoraegTeirLink());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return bStatus;
}
	  //update each @test result in custom result file
		@AfterMethod
		public static void afterEachMethod(){
			FrameworkUtil.updateTestCaseStatusinResult();
			
			//Should be deleted after today's execution by Arul on 7/14/16
			WebDriverUtil.quitWebDriver();

		}
		


}
