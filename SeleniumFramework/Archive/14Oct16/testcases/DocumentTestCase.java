package com.whs.navigator.testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FileDownloader;
import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.commonUtil.WebTableUtil;
import com.whs.navigator.pagefactory.DashboardPageFactory;
import com.whs.navigator.pagefactory.DocumentPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.LoginPageFactory;


public class DocumentTestCase {
	
	
	public static DocumentPageFactory document = new DocumentPageFactory();
	public static DashboardPageFactory dashboard = new DashboardPageFactory();
	public static LoginPageFactory Login = new LoginPageFactory();
	public static HomePageFactory_old Home = new HomePageFactory_old();
	private static String sPDFUrl;
	
	/*==============================================================
	Method Name 	: navDocumentPage
	Description		: the below method will navigate till document page
	Author 			: Vivek Kumar
	Creation Date 	: 12/02/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public void navDocumentPage() 
	{
		
		try 
		{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, dashboard);
			PageFactory.initElements(driver, document);
			Actions builder = new Actions(driver) ;
			//getting username from properties file
			String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
			//getting password from properties file
			String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
			//Login to navigator application
			//LoginTestCase.nav_Login(sUserName, sPassword);
			//LoginTestCase.LoginAsGirUser();
			
			LoginTestCase_Old1.LoginAsQaautoUser();
			WebObjectUtil.explicitWait(3);
			//clicking on Support tab
			WebObjectUtil.clickElement(dashboard.getNav_SupportTab());
			//builder.moveToElement(dashboard.getNav_SupportTab()).perform();
			WebObjectUtil.explicitWait(3);
			//clicking on Document link
			//WebObjectUtil.clickElement(dashboard.getNav_DocumentMenuLink());
			WebObjectUtil.clickElement(dashboard.getNav_DocumentMenuLink());
			WebObjectUtil.explicitWait(10);
			//verifying Document landing page
			WebObjectUtil.assertElementPresent(document.getNav_DocumentLink());
		
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			LoggerUtil.log_type_error("Method:navDocumentPage, Error MSG :" + e.getMessage());
		}
	}
	/*==============================================================
	TestScript 		: viewDocumentPage
	Manual TestCase	: View document page
	Description		: Verifying browser navigates to particular documents page
	Author 			: Vivek Kumar
	Creation Date 	: 12/02/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=1)
	public void viewDocumentPage() 
	{

		try {
			PageFactory.initElements(WebDriverUtil.getDriver(), document);
			FrameworkUtil.sTestCaseName = "DocumentviewDocumentPage";
			FrameworkUtil.sManualTestCaseName="View document page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			navDocumentPage();
			//Logging out from Navigator application
			LoginTestCase_Old1.nav_Logout();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LoggerUtil.log_type_error("Method:viewDocumentPage, Error MSG :" + e.getMessage());
		}
	}
	
	/*==============================================================
	TestScript 		: downloadDocument
	Manual TestCase	: Download document
	Description		: Verifying clicking on Download button it should navigate to PDF page
	Author 			: Vivek Kumar
	Creation Date 	:12/02/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=2)
	public void downloadDocument() 
	{
		
		String sPDFPath,sTitle,sURL;
		boolean bStatus;

		try {
			PageFactory.initElements(WebDriverUtil.getDriver(), document);
			FrameworkUtil.sTestCaseName = "DocumentdownloadDocument";
			FrameworkUtil.sManualTestCaseName="Download document";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			navDocumentPage();
			
			//verifying and clicking PDF link
			WebObjectUtil.clickElement(document.getNav_DocumentPDFLink());
			//Add as per latest application change by Arul on 5/20/16
			WebObjectUtil.verifyElementPresent(document.getNav_DownloadBtn());
			
			verifyDownloadDocument();
			
			//the below lines are moved into above method
			
			/*if (WebDriverUtil.browser.equalsIgnoreCase("IE") )
			//if (!WebObjectUtil.isElementPresent(document.getPDFcontainer()))
			{
				sPDFPath = FileDownloader.fileDownload(document.getNav_DownloadBtn());
				if (sPDFPath.contains(".pdf")){
					LoggerUtil.writeStatusLog(true, "PDF file download", "PDF file validated by FileDownloader");
				}
			}else{
				
				//Capturing URL from the inputbox and navigating the same
				WebObjectUtil.scrollElementAtPageCenter(document.getNav_DownloadLink());
				sURL= document.getNav_DownloadLink().getAttribute("href");
				
				//verifying and Clicking Download button
				WebObjectUtil.clickElement(document.getNav_DownloadBtn());
				WebObjectUtil.explicitWait(10);
				
				//verifying PDF page
				if(WebDriverUtil.browser.equals("FIREFOX")){
					WebObjectUtil.assertElementPresent(document.getPDFcontainer());
				}
				else if(WebDriverUtil.browser.equals("CHROME"))
				{
					//WebObjectUtil.assertElementPresent(document.getPDFcontainer_Chrome());
					sTitle=WebDriverUtil.getDriver().getTitle();
					bStatus=sURL.contains(sTitle);
					FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "PDF page for chrome verified");
				}
			}
			
			*/
			//click on back button
			WebDriverUtil.getDriver().navigate().back();
			//Logging out from Navigator application
			LoginTestCase_Old1.nav_Logout();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LoggerUtil.log_type_error("Method:downloadDocument, Error MSG :" + e.getMessage());
		}
		
	}
	
	/*==============================================================
	TestScript 		: navigatePDFURL
	Manual TestCase	: Test URL
	Description		: Verifying that url is navigating to PDF page
	Author 			: Vivek Kumar
	Creation Date 	: 12/02/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=3)
	public void navigatePDFURL() 
	{

		String sURL, sTitle;
		boolean bStatus;
		
		try {
			PageFactory.initElements(WebDriverUtil.getDriver(), document);
			FrameworkUtil.sTestCaseName = "DocumentnavigatePDFURL";
			FrameworkUtil.sManualTestCaseName="Test URL";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			navDocumentPage();
			//verifying and clicking PDF link
			WebObjectUtil.clickElement(document.getNav_DocumentPDFLink());
			WebObjectUtil.explicitWait(10);
			//Capturing URL from the inputbox and navigating the same
			//sURL= document.getNav_PDFUrlText().getAttribute("value");
			WebObjectUtil.scrollElementAtPageCenter(document.getNav_DownloadLink());
			sURL= document.getNav_DownloadLink().getAttribute("href");
			WebObjectUtil.clickElement(document.getNav_DownloadLink());
			//verifying PDF page
			if (!WebDriverUtil.browser.equalsIgnoreCase("IE") ){
				WebDriverUtil.navigateTo(sURL);
				WebObjectUtil.explicitWait(5);
				if(WebDriverUtil.browser.equals("FIREFOX")){
					
					WebObjectUtil.explicitWait(5);
					WebObjectUtil.assertElementPresent(document.getPDFcontainer());
				}
				else if(WebDriverUtil.browser.equals("CHROME"))
				{
					//WebObjectUtil.assertElementPresent(document.getPDFcontainer_Chrome());
					sTitle=WebDriverUtil.getDriver().getTitle();
					bStatus=sURL.contains(sTitle);
					FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "PDF page for chrome verified");
				}
			}
			//click on back button
			WebDriverUtil.getDriver().navigate().back();
			//Logging out from Navigator application
			LoginTestCase_Old1.nav_Logout();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error("Method:navigatePDFURL, Error MSG :" + e.getMessage());
		}
				
	}
	/*==============================================================
	TestScript 		: permissionDenied
	Manual TestCase	: can't get file when logged out
	Description		: Verifying that User cannot access PDF url after logging out
	Author 			: Vivek Kumar
	Creation Date 	: 12/02/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=5)
	public void permissionDenied()
	{

		try {
			PageFactory.initElements(WebDriverUtil.getDriver(), document);
			PageFactory.initElements(WebDriverUtil.getDriver(), Login);
			FrameworkUtil.sTestCaseName = "DocumentpermissionDenied";
			FrameworkUtil.sManualTestCaseName="can't get file when logged out";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			navDocumentPage();
			//verifying and clicking PDF link
			WebObjectUtil.clickElement(document.getNav_DocumentPDFLink());
			//Capturing URL from the inputbox and navigating the same
			String sPDFUrl= document.getNav_PDFUrlText().getAttribute("value");
			//Logging out from Navigator application
			LoginTestCase_Old1.nav_Logout();
			//Navigate the URL after logout
			WebDriverUtil.navigateTo(sPDFUrl);
			//Verifying error message
			//WebObjectUtil.assertElementPresent(document.getErrorMsg());
			WebObjectUtil.verifyElementPresent(Login.getNav_submitBtn());
			WebDriverUtil.getDriver().navigate().back();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LoggerUtil.log_type_error("Method:permissionDenied, Error MSG :" + e.getMessage());
		}
	}
	/*==============================================================
	TestScript 		: PDFVersionHistory
	Manual TestCase	: Version history
	Description		: Clicking on any Version history link and it should 
					  navigate to PDF page
	Author 			: Vivek Kumar
	Creation Date 	: 12/02/2014
	Pre-Requisites	:
	Revision History: 
	==============================================================*/
	//Commented below test cases , due to latest document page change, we could not see history details.
	//@Test(priority=4)
	public void PDFVersionHistory() 
	{
		try {
			FrameworkUtil.sTestCaseName = "DocumentPDFVersionHistory";
			FrameworkUtil.sManualTestCaseName="Version history";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			navDocumentPage();
			//verifying and clicking PDF link
			WebObjectUtil.clickElement(document.getNav_DocumentPDFLink());
			//Capturing URL from the inputbox and navigating the same
			sPDFUrl = document.getNav_PDFUrlText().getAttribute("value");
			
			WebObjectUtil.verifyElementPresent(document.getPDFVersionHistory());
			
			FileDownloader.fileDownload(document.getPDFVersionHistory());
			/*			
			//clicking on version number
			WebObjectUtil.clickElement(document.getPDFVersionHistory());
			
			//verifying PDF page
			WebObjectUtil.assertElementPresent(document.getPDFcontainer());
			*/
			//click on back button
			WebDriverUtil.getDriver().navigate().back();
			//Logging out from Navigator application
			LoginTestCase_Old1.nav_Logout();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LoggerUtil.log_type_error("Method:PDFVersionHistory, Error MSG :" + e.getMessage());
		}
		
	}
	
	// _____________________________________ Kyle test cases _________________________________________ //
	
	
	 /*==============================================================
	TestScript  	: verifyAddOrgSpecificDocsForDiffusers
	Manual TestCase	: [QAT-1457] WCP-5230-TC_1.0_Support-> Add Org Specific docs
	Description		: //include description from testcase
	Author 			: QAA03
	Creation Date 	: 06/20/2016
	Release Name    : Kyle
	Pre-Requisites	:
	Revision History:
  ==============================================================*/
	
	@Test(priority=41)
	public void verifyAddOrgSpecificDocsForDiffusers()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, Home);
			PageFactory.initElements(driver, document);
			
					
		try {
			FrameworkUtil.sTestCaseName = "Document-verifyAddOrgSpecificDocsForDiffusers";
			FrameworkUtil.sManualTestCaseName="[QAT-1457] WCP-5230-TC_1.0_Support-> Add Org Specific docs";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			//Login to navigator with Role-A user
			LoginTestCase_Old1.LoginAsRoleAUser();
			
			WebObjectUtil.clickElement(Home.getNav_SupportTab());
			
			//Verifying add org specific docs link present for hosted solutions user
			WebObjectUtil.verifyElementPresent(document.getNav_SupportTab_AddOrgSpecificDocsLink());
			
			//Logout from Navigator
			LoginTestCase_Old1.nav_Logout();
			
		    //Login to navigator with Qaauto-A user
			LoginTestCase_Old1.LoginAsQaautoAUser();
			
            WebObjectUtil.clickElement(Home.getNav_SupportTab());
			
            //Verifying add org specific docs link not present for non hosted solutions user
			WebObjectUtil.verifyElementNOTPresent(document.getNav_SupportTab_AddOrgSpecificDocsLink());
							
			//Logout from Navigator
			LoginTestCase_Old1.nav_Logout();
		
		   } catch (Exception e) {
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAddOrgSpecificDocsForDiffusers", "warn", "catch block:" +e.getMessage());
		}
	}
	
	 
	 /*==============================================================
		TestScript  	: verifyAddOrgSpecificDocsPage
		Manual TestCase	: [QAT-1458] WCP-5230-TC_1.1_Support-> Add Org Specific docs page
		Description		: //include Description from testcase
		Author 			: QAA03
		Creation Date 	: 06/20/2016
		Release Name    : Kyle
		Pre-Requisites	:
		Revision History:
	  ==============================================================*/
		
		@Test(priority=42)
		public void verifyAddOrgSpecificDocsPage()
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, Home);
				PageFactory.initElements(driver, document);
				
						
			try {
				FrameworkUtil.sTestCaseName = "Add Org Specific Document-verifyAddOrgSpecificDocsPage";
				FrameworkUtil.sManualTestCaseName="[QAT-1458] WCP-5230-TC_1.1_Support-> Add Org Specific docs page";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
				//Login to navigator with Role-A user
				LoginTestCase_Old1.LoginAsRoleAUser();
				
				//Navigating to Add Org Specific Docs Page
				navAddOrgSpecificDocsPage();
				
				//update comments if necessary
				WebObjectUtil.verifyElementPresent(document.getNav_AddOrgSpecificDocs_OrganizationDropDown());
				
				WebObjectUtil.verifyElementPresent(document.getNav_AddOrgSpecificDocs_UploadDocumentField());
				
				WebObjectUtil.verifyElementPresent(document.getNav_AddOrgSpecificDocs_BrowseButton());
				
				WebObjectUtil.verifyElementPresent(document.getNav_AddOrgSpecificDocs_ResetButton());
				
				WebObjectUtil.verifyElementPresent(document.getNav_AddOrgSpecificDocs_SubmitButton());
				
				//WebObjectUtil.clickElement(document.getNav_AddOrgSpecificDocs_BrowseButton());
				
				
				
				//Logout from Navigator
				LoginTestCase_Old1.nav_Logout();
				
			    } catch (Exception e) {
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAddOrgSpecificDocsPage", "warn", "catch block:" +e.getMessage());
			}
		}
	
		/*==============================================================
		TestScript  	: verifyDocumentUploadedforUser
		Manual TestCase	: [QAT-1464] WCP-5230-TC_1.3_Support-> Documents
		Description		: //include Description from testcase
		Author 			: QAA03
		Creation Date 	: 06/22/2016
		Release Name    : Kyle
		Pre-Requisites	: [QAT-1461] should be done manually as it is related to uploading documents
		Revision History:
	  ==============================================================*/
		
		@Test(priority=43)
		public void verifyDocumentUploadedforUser()
		{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, Home);
				PageFactory.initElements(driver, document);
				String sULElementXpath=null;
						
			try {
				FrameworkUtil.sTestCaseName = "Document-verifyDocumentUploadedforUser";
				FrameworkUtil.sManualTestCaseName="[QAT-1464] WCP-5230-TC_1.3_Support-> Documents";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
				sULElementXpath = (String)FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
				
													
			    // Login to navigator with Qaauto-A user
				LoginTestCase_Old1.LoginAsQaautoAUser();
				
				// Navigating to Document Page
                navDocumentPage();
                
				// Verifying folder present for the organization name and clicking on the organization
                verifyDownloadDocumentUnderOrgFolder();
                
                // Verifying document present for the organization name and clicking on the document
                verifyDownloadDocumentUnderOrgdocument();
                
                // Verifying the search document page
				WebObjectUtil.verifyElementPresent(document.getNav_Document_SearchDocument());
				
			//	driver.navigate().back();
				// Verifying the document by clicking on download button
				verifyDownloadDocument();
													
				// Logout from Navigator
				LoginTestCase_Old1.nav_Logout();
			
			   } catch (Exception e) {
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyDocumentUploadedforUser", "warn", "catch block:" +e.getMessage());
			}
		}
	
	
	
	
	
	
	
	
	
	
	
		/*==============================================================
		Method Name 	: verifyDownloadDocumentUnderOrgdocument
		Description		: Verifying document present for the organization name and clicking on the document
		Author 			: QAA03
		Creation Date 	: 06/22/2016
		Module Name     : Document
		Pre-Requisites	: 
		Revision History:
		==============================================================*/
		public static void verifyDownloadDocumentUnderOrgdocument()
		{
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, document);
			int iRownumber=0;
			String sDocument=null;
			WebElement wRowElement;
	   try {
		    sDocument=(String)FrameworkUtil.dictPropertyData.get("NAV.DOCUMENT.FOLDER.SEARCHDOCUMENT");
		     
		    //Verifying document present for the organization name and clicking on the document
		    WebObjectUtil.verifyElementPresent(document.getNav_Document_ObjectsTable());
			   
			iRownumber = WebTableUtil.getRowByCellText(document.getNav_Document_ObjectsTable(), sDocument, 1, 1);
			   
			wRowElement =WebTableUtil.getCellAsWebElement(document.getNav_Document_ObjectsTable(), iRownumber+1,1);
			 
			wRowElement.findElement(By.tagName("span")).click();
							
			//WebObjectUtil.clickElement(wRowElement);
				
			} catch (Exception e) {
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyDownloadDocumentUnderOrgdocument", "fail", e.getMessage()+"null");
				LoggerUtil.log_type_error(e.getMessage());
			}

		} 
	
		/*==============================================================
		Method Name 	: verifyDownloadDocumentUnderOrgFolder
		Description		: Verifying folder present for the organization name and clicking on the organization
		Author 			: QAA03
		Creation Date 	: 06/22/2016
		Module Name     : Document
		Pre-Requisites	: 
		Revision History:
		==============================================================*/
		public static void verifyDownloadDocumentUnderOrgFolder()
		{
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, document);
			int iRownumber=0;
			String sOrgName=null;
			WebElement wRowElement;
	   try {
		   
		    sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.DOCUMENT.FOLDER.ORGANIZATION");
		    
		         
		   /* CustomWebElementUtil.loadCustomElement(document.getNav_Document_FolderTable(), "tr");
			
			iRownumber = CustomWebElementUtil.getRowByCellText(sOrgName, 1);
			
			wRowElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.DOCUMENT.FOLDER.ORGANIZATION", "PARAMETER_ROWNUMBER,PARAMETER_ORG", iRownumber+","+sOrgName);
			
			WebObjectUtil.clickElement(wRowElement);*/
		   
		      
		   //Verifying folder present for the organization name and clicking on the organization
		   WebObjectUtil.verifyElementPresent(document.getNav_Document_FolderTable());
		   
		   iRownumber = WebTableUtil.getRowByCellText(document.getNav_Document_FolderTable(), sOrgName, 1,1);
		   
		   wRowElement =WebTableUtil.getCellAsWebElement(document.getNav_Document_FolderTable(), iRownumber+1,1);
		   
		   wRowElement.findElement(By.tagName("Strong")).click();
		  // WebObjectUtil.clickElement(wRowElement);
				
			} catch (Exception e) {
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyDownloadDocumentUnderOrgFolder", "fail", e.getMessage()+"null");
				LoggerUtil.log_type_error(e.getMessage());
			}

		} 
		/*==============================================================
		Method Name 	: navAddOrgSpecificDocsPage
		Description		: Navigating to Add Org Specific Docs Page
		Author 			: QAA03
		Creation Date 	: 06/22/2016
		Module Name     : Add specific document
		Pre-Requisites	: 
		Revision History:
		==============================================================*/
		public static void navAddOrgSpecificDocsPage()
		{
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, document);
			
			
	   try {
		     
		    WebObjectUtil.clickElement(Home.getNav_SupportTab());
			
			WebObjectUtil.verifyElementPresent(document.getNav_SupportTab_AddOrgSpecificDocsLink());
			
			WebObjectUtil.clickElement(document.getNav_SupportTab_AddOrgSpecificDocsLink());
			
			WebObjectUtil.verifyElementPresent(document.getNav_AddOrgSpecificDocs_OrgSpecificDocsTable());	
				
			} catch (Exception e) {
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navAddOrgSpecificDocsPage", "fail", e.getMessage()+"null");
				LoggerUtil.log_type_error(e.getMessage());
			}

		} 
	// __________________________________ Completed kyle test cases _________________________________________ ///
	/*==============================================================
	Method Name 	: verifyDownloadDocument
	Description		: 
	Author 			: QAA03
	Creation Date 	: 06/22/2016
	Pre-Requisites	: 
	Revision History:
	==============================================================*/
	public static void verifyDownloadDocument()
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, document);
		String sPDFPath,sTitle,sURL;
		boolean bStatus;
		
   try {
	     if (WebDriverUtil.browser.equalsIgnoreCase("IE") )
			//if (!WebObjectUtil.isElementPresent(document.getPDFcontainer()))
			{
				sPDFPath = FileDownloader.fileDownload(document.getNav_DownloadBtn());
				if (sPDFPath.contains(".pdf")){
					LoggerUtil.writeStatusLog(true, "PDF file download", "PDF file validated by FileDownloader");
				}
			}else{
				
				//Capturing URL from the inputbox and navigating the same
				WebObjectUtil.scrollElementAtPageCenter(document.getNav_DownloadLink());
				sURL= document.getNav_DownloadLink().getAttribute("href");
				
				//verifying and Clicking Download button
				WebObjectUtil.clickElement(document.getNav_DownloadBtn());
				WebObjectUtil.explicitWait(10);
				
				//verifying PDF page
				if(WebDriverUtil.browser.equals("FIREFOX")){
					WebObjectUtil.assertElementPresent(document.getPDFcontainer());
				}
				else if(WebDriverUtil.browser.equals("CHROME"))
				{
					//WebObjectUtil.assertElementPresent(document.getPDFcontainer_Chrome());
					sTitle=WebDriverUtil.getDriver().getTitle();
					bStatus=sURL.contains(sTitle);
					FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "PDF page for chrome verified");
				}
			}
			
			
			
			
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyDownloadDocument", "fail", e.getMessage()+"null");
			LoggerUtil.log_type_error(e.getMessage());
		}

	}

	//update each @test result in custom result file
	@AfterMethod
	public static void afterEachMethod(){
		FrameworkUtil.updateTestCaseStatusinResult();
		
	}
	
	
}
