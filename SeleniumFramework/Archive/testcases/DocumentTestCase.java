package com.whs.navigator.testcases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FileDownloader;
import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.DashboardPageFactory;
import com.whs.navigator.pagefactory.DocumentPageFactory;


public class DocumentTestCase {
	
	
	public static DocumentPageFactory document = new DocumentPageFactory();
	public static DashboardPageFactory dashboard = new DashboardPageFactory();
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
			LoginTestCase.nav_Login(sUserName, sPassword);
			//clicking on Support tab
			WebObjectUtil.clickElement(dashboard.getNav_SupportTab());
			builder.moveToElement(dashboard.getNav_SupportTab()).perform();
			Thread.sleep(2000);
			//clicking on Document link
			WebObjectUtil.clickElement(dashboard.getNav_DocumentMenuLink());
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
			FrameworkUtil.sTestCaseName = "DocumentviewDocumentPage";
			FrameworkUtil.sManualTestCaseName="View document page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			navDocumentPage();
			//Logging out from Navigator application
			LoginTestCase.nav_Logout();
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

		try {
			FrameworkUtil.sTestCaseName = "DocumentdownloadDocument";
			FrameworkUtil.sManualTestCaseName="Download document";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			navDocumentPage();
			//verifying and clicking PDF link
			WebObjectUtil.clickElement(document.getNav_DocumentPDFLink());
			

			
			if (WebDriverUtil.browser.equalsIgnoreCase("IE") )
			//if (!WebObjectUtil.isElementPresent(document.getPDFcontainer()))
			{
				String sPDFPath = FileDownloader.fileDownload(document.getNav_DownloadBtn());
				if (sPDFPath.contains(".pdf")){
					LoggerUtil.writeStatusLog(true, "PDF file download", "PDF file validated by FileDownloader");
				}
			}else{
				//verifying and Clicking Download button
				WebObjectUtil.clickElement(document.getNav_DownloadBtn());
				//verifying PDF page
				WebObjectUtil.assertElementPresent(document.getPDFcontainer());
			}
			
			//click on back button
			WebDriverUtil.getDriver().navigate().back();
			//Logging out from Navigator application
			LoginTestCase.nav_Logout();
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

		try {
			FrameworkUtil.sTestCaseName = "DocumentnavigatePDFURL";
			FrameworkUtil.sManualTestCaseName="Test URL";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			navDocumentPage();
			//verifying and clicking PDF link
			WebObjectUtil.clickElement(document.getNav_DocumentPDFLink());
			//Capturing URL from the inputbox and navigating the same
			String sURL= document.getNav_PDFUrlText().getAttribute("value");
			
			//verifying PDF page
			if (!WebDriverUtil.browser.equalsIgnoreCase("IE") ){
				WebDriverUtil.navigateTo(sURL);
				WebObjectUtil.assertElementPresent(document.getPDFcontainer());
			}
			//click on back button
			WebDriverUtil.getDriver().navigate().back();
			//Logging out from Navigator application
			LoginTestCase.nav_Logout();
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
			FrameworkUtil.sTestCaseName = "DocumentpermissionDenied";
			FrameworkUtil.sManualTestCaseName="can't get file when logged out";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			navDocumentPage();
			//verifying and clicking PDF link
			WebObjectUtil.clickElement(document.getNav_DocumentPDFLink());
			//Capturing URL from the inputbox and navigating the same
			String sPDFUrl= document.getNav_PDFUrlText().getAttribute("value");
			//Logging out from Navigator application
			LoginTestCase.nav_Logout();
			//Navigate the URL after logout
			WebDriverUtil.navigateTo(sPDFUrl);
			//Verifying error message
			WebObjectUtil.assertElementPresent(document.getErrorMsg());
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
	@Test(priority=4)
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
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LoggerUtil.log_type_error("Method:PDFVersionHistory, Error MSG :" + e.getMessage());
		}
		
	}

	//update each @test result in custom result file
	@AfterMethod
	public static void afterEachMethod(){
		FrameworkUtil.updateTestCaseStatusinResult();
		
	}
	
	
}
