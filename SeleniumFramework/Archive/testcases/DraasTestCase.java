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
import com.whs.navigator.commonUtil.WebTableUtil;
import com.whs.navigator.pagefactory.DraasPageFactory;
import com.whs.navigator.pagefactory.CommonPageFactory;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory;

public class DraasTestCase {
	public static DraasPageFactory Draas =new DraasPageFactory();
	public static CommonPageFactory Common=new CommonPageFactory();
	public static HomePageFactory Home= new HomePageFactory();
//**********************These TestScripts are taken From Clark-Start*********************************************//
	/*==============================================================
	TestScript 		: nav_verifyPDFandCSVlinks
	Manual TestCase	: Verify the PDF link and CSV link under DRaaS page
	Description		: Verify the PDF link and CSV link under DRaaS page with Agent user
	Author 			: QAA02
	Creation Date 	: 08/17/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=101)
	public void nav_verifyPDFandCSVlinks() {
		
		String sActualTitlePDF,sActualTitleCSV;
		boolean verifyPDF,verifyCSV;
		  WebDriver driver = WebDriverUtil.getDriver();
		  PageFactory.initElements(driver, Draas);
		 try{
			 
		 
		  FrameworkUtil.sTestCaseName="Clark-nav_verifyPDFandCSVlinks";
		  FrameworkUtil.sManualTestCaseName="(CPPOC-3256)Verify the PDF link and CSV link under DRaaS page";
		  FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		  
		  String sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.TSTGETSMART.AGENT.USERID");
		  String sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.TSTGETSMART.AGENT.PASSWORD");
		  LoginTestCase.nav_Login(sUserName, sPassword);
		  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "agentLogin", "Pass", "Login Sucess");
		  
		  
		  WebObjectUtil.clickElement(Draas.getNav_DraasLink());
		 
		 if(WebObjectUtil.verifyElementPresent(Draas.getNav_PDFLink()))
		 {
		  sActualTitlePDF = Draas.getNav_PDFLink().getAttribute("alt");
		  	 
		  
		  verifyPDF = sActualTitlePDF.contains("PDF");
		 FrameworkUtil.updateCustomResultBasedOnStatus(verifyPDF, "Verify PDF");
		 }
		 else
		 {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "VerifyPDFlink", "fail", "pdflinkText is not verifeid");
		 }
		  
		
		    
		
		if(WebObjectUtil.verifyElementPresent(Draas.getNav_CSVLink()))
		{
		   sActualTitleCSV = Draas.getNav_CSVLink().getAttribute("alt");
		 
		
		   verifyCSV = sActualTitleCSV.contains("CSV");
		  FrameworkUtil.updateCustomResultBasedOnStatus(verifyCSV, "Verify CSV");
	}
	else
	{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "VerifyCSVlink", "fail", "pdflinkText is not verifeid");
	}

		 
		 
		 
		  LoginTestCase.nav_Logout();
		 }
		catch (Exception e) {
		// TODO Auto-generated catch block
	     	LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
	}
		  
	}
	
	/*==============================================================
	TestScript 		: nav_ClickOnManageLinkAndVerifyItNavigatesToAnotherPage
	Manual TestCase	: click on Manage link and verify it navigates user to another page to learn more about the product
	Description		: click on Manage link and verify it navigates user to another page to learn more about the product with Agent user
	Author 			: QAA02
	Creation Date 	: 08/17/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=102)
	public void nav_ClickOnManageLinkAndVerifyItNavigatesToAnotherPage() {
		
		  WebDriver driver = WebDriverUtil.getDriver();
		  PageFactory.initElements(driver, Draas);
		  try {
			  
		
		  FrameworkUtil.sTestCaseName="Clark-nav_ClickOnManageLinkAndVerifyItNavigatesToAnotherPage";
		  FrameworkUtil.sManualTestCaseName="(CPPOC-3255)click on Manage link and verify it navigates user to another page to learn more about the product";
		  FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		  
		  //String sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.TSTGETSMART.AGENT.USERID");
		  String sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
		  String sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.TSTGETSMART.AGENT.PASSWORD");
		  LoginTestCase.nav_Login(sUserName, sPassword);
		  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "agentLogin", "Pass", "Login Sucess");

	      WebObjectUtil.clickElement(Draas.getNav_DraasLink());
	      WebObjectUtil.explicitWait(5);
	      
			//Clicking on Learn More link and verifying its landing page
			WebObjectUtil.clickAndVerifyElement(Draas.getNav_DRaasLearnMoreLnk(), Draas.getNav_DRaaSProdtPage());
			
			//as per latest update commented below part and added above linke to verify learn more instead of manage link by Arul 10/30/15
	/*      WebObjectUtil.clickElement(Clark.getNav_manageLink());
	      
	      String serviceTitle = (String) FrameworkUtil.dictPropertyData.get("NAV.WINDSTREAMBUSINESS.PRODUCT.SERVICE.TITLE");
	      
	      WebObjectUtil.switchToWindow(2, "serviceTitle");
	      
	      WebObjectUtil.verifyElementPresent(Clark.getNav_TitleUnderDisasterRecoverypage());
	      WebObjectUtil.explicitWait(5);
	      WebObjectUtil.switchToParentWindow();*/
	      
	      LoginTestCase.nav_Logout();

		  }
		catch (Exception e) {
		// TODO Auto-generated catch block
	     	LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
	}
	  
	  
	}
	
	/*==============================================================
	TestScript 		: nav_VerifyTheDotsInDRaasPortlet
	Manual TestCase	: Hover over to DRaaS portlet and verify the number of dots Present in the portlet
	Description		: Hover over to DRaaS portlet and verify the number of dots Present in the portlet with Agent user
	Author 			: QAA02
	Creation Date 	: 08/18/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=104)
	public void nav_VerifyTheDotsInDRaasPortlet() {
		
		  WebDriver driver = WebDriverUtil.getDriver();
		  PageFactory.initElements(driver, Draas);
		  try {
			  
		
		  FrameworkUtil.sTestCaseName="Clark-nav_VerifyTheDotsInDRaasPortlet";
		  FrameworkUtil.sManualTestCaseName="(CPPOC-3254)Hover over to DRaaS portlet and verify the number of dots Present in the portlet";
		  FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		  
		 
		   String sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.TSTGETSMART.AGENT.USERID");
		  String sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.TSTGETSMART.AGENT.PASSWORD");
		  LoginTestCase.nav_Login(sUserName, sPassword);
		  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "AGENTLogin", "Pass", "Login Sucess");


	  WebObjectUtil.clickElement(Draas.getNav_DraasLink());
		  WebObjectUtil.explicitWait(5);
	  
		  List<WebElement>ProductList;
	  int iproducts=0;
	    if(WebObjectUtil.isElementPresent(Draas.getNav_productsDivisionunderDRaasPage())) {
		
	        ProductList = Draas.getNav_productsDivisionunderDRaasPage().findElements(By.xpath("//div[contains(@id,'rPanel_header-innerCt')]"));
	    	//    ProductList = (List<WebElement>) Clark.getNav_productsUnderDRaaasPage().getSize();
	        iproducts=ProductList.size();
	        FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "ProductsListInDRaaSPortlet", "Pass", "Product Count In DRaaS Portlet "+iproducts);

	 }
	 else
	 {
		 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "ProductsListInDRaaSPortlet", "warn", "Products are not present in DRaaS Portlet");
	 }  
		  
	WebObjectUtil.explicitWait(5);
	  driver.navigate().back();
	  //WebObjectUtil.clickElement(Clark.getNav_breadCrumbChainHomeLink());
	  WebObjectUtil.explicitWait(3);
	  WebObjectUtil.MouseHover(Draas.getNav_DRaaSPortlet());  // change to navigate to home
	  	 
	 List<WebElement> dotsList;
	   int idots=0;
	   if (WebObjectUtil.isElementPresent(Draas.getNav_DotsInDRaaSPortlet())){
			dotsList = Draas.getNav_DotsInDRaaSPortlet().findElements(By.tagName("div"));
			idots= dotsList.size();
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "DotsListInDRaaSPortlet", "Pass", "Dots Count In DRaaS Portlet= "+idots);
	   }
	 
	   
	 if(idots==iproducts)
	 {
		 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Matched", "Pass", "Product Count In DRaaS Page is same as dots in DRaaS portlet");
		 
	 }
	 else
	 {
		 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "NotMatched", "fail", "Product Count In DRaaS Page is not same as dots in DRaaS portlet");
	 }  
	 WebObjectUtil.explicitWait(5);
	 
	 
	 LoginTestCase.nav_Logout();
		  }
		catch (Exception e) {
		// TODO Auto-generated catch block
	     	LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
	}
	}
	
	/*==============================================================
	TestScript  	: navVerifyAddManageHistoryNotAvailable
	Manual TestCase	: CPPOC-3220,3219-Regardless of the user permissions,
					  Add Drive link, Manage and History buttons are hidden if they are no products
	Description		: Regardless of the user permissions,
					  Add Drive link, Manage and History buttons are hidden if they are no products
	Author 			: Vivek Kumar
	Creation Date 	: 08/19/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=16)
	public void navVerifyAddManageHistoryNotAvailable()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Draas);
		
		String sUserName,sPassword;
		boolean bStatus;
		
		
		FrameworkUtil.sTestCaseName = "Clark-navVerifyAddManageHistoryNotAvailable";
		FrameworkUtil.sManualTestCaseName="CPPOC-3220,3219-Regardless of the user permissions,Add Drive link, Manage and History buttons are hidden";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEE.USERID");
		sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEE.PASSWORD");
		LoginTestCase.nav_Login(sUserName, sPassword);
		
		//Navigating to Draas Page
		navigateToDraaS(sUserName);
		
		//Verifying Add Drive,Manage,History are not available
		bStatus=WebObjectUtil.isElementPresent(Draas.getNav_SCRAddDrive());
		FrameworkUtil.updateCustomResultBasedOnStatus(!bStatus, "Add drive is not available");
		
		bStatus=WebObjectUtil.isElementPresent(Draas.getNav_SCRManageBtn());
		FrameworkUtil.updateCustomResultBasedOnStatus(!bStatus, "Manage Button is not available");
		
		bStatus=WebObjectUtil.isElementPresent(Draas.getNav_SCRHistoryBtn());
		FrameworkUtil.updateCustomResultBasedOnStatus(!bStatus, "History is not available");
		
		
		//Logout
		LoginTestCase.nav_Logout();
		
	}
	
	/*==============================================================
	TestScript  	: navRoleEViewDraasPage
	Manual TestCase	: CPPOC-3217 - A user with Role-E permissions is able to view DRaaS page
	Description		: A user with Role-E permissions is able to view DRaaS page
	Author 			: Vivek Kumar
	Creation Date 	: 08/12/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=4)
	public void navRoleEViewDraasPage()
	{
	WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Draas);
		
		String sUserName,sPassword;
		boolean bStatus;
		
		
		FrameworkUtil.sTestCaseName = "Clark-navRoleEViewDraasPage";
		FrameworkUtil.sManualTestCaseName="CPPOC-3217-A user with Role-E permissions is able to view DRaaS page";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.EROLE");
		sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.EROLE");
		LoginTestCase.nav_Login(sUserName, sPassword);
		
		//Navigating to Draas Page
		navigateToDraaS(sUserName);
		
		//Logout
		LoginTestCase.nav_Logout();
	
	}
	
	/*==============================================================
	TestScript  	: navVerifySBRNotShwnOnMarktng
	Manual TestCase	: CPPOC-3167-On DRaaS detail page, verify SBR is not shown on marketing page if products are showing.
	Description		: On DRaaS detail page, verify SBR is not shown on marketing page if products are showing.
	Author 			: Vivek Kumar
	Creation Date 	: 08/19/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=15)
	public void navVerifySBRNotShwnOnMarktng()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Draas);
		
		String sUserName,sPassword;
		boolean bStatus;
		
		FrameworkUtil.sTestCaseName = "Clark-navVerifySBRNotShwnOnMarktng";
		FrameworkUtil.sManualTestCaseName="CPPOC-3167-On DRaaS detail page, verify SBR is not shown on marketing page if products are showing.";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
		sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
		LoginTestCase.nav_Login(sUserName, sPassword);
		
		//Click and verifying DraaS Landing page
		navigateToDraaS(sUserName);
		
		if(WebObjectUtil.isElementPresent(Draas.getNav_SBRImage()))
		{
			bStatus=WebObjectUtil.isElementPresent(Draas.getNav_SBRProduct());
			FrameworkUtil.updateCustomResultBasedOnStatus(!bStatus, "SBR product is there in Marketing page and not available as product");
		}
		//Logout
		LoginTestCase.nav_Logout();
	}
	
	/*==============================================================
	TestScript  	: navVerifyAddDriveManageHistorySCR
	Manual TestCase	: CPPOC-3162 -HBR is replaced with Server to Cloud Recovery across pages
	Description		: HBR is replaced with Server to Cloud Recovery across pages
	Author 			: Vivek Kumar
	Creation Date 	: 08/12/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=5)
	public void navVerifyAddDriveManageHistorySCR()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Draas);
		
		String sUserName,sPassword;
		boolean bStatus;
		
		
		FrameworkUtil.sTestCaseName = "Clark-navVerifyAddDriveManageHistorySCR";
		FrameworkUtil.sManualTestCaseName="CPPOC-3162-HBR is replaced with Server to Cloud Recovery across pages";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.DRAAS.AROLE");
		sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.DRAAS.AROLE");
		LoginTestCase.nav_Login(sUserName, sPassword);
		
		//Navigating to Draas Page
		navigateToDraaS(sUserName);
		
		//Verifying Add Drive,Manage,History and their landing dialog
		WebObjectUtil.clickAndVerifyElement(Draas.getNav_SCRAddDrive(), Draas.getNav_AddDriveDialog());
		WebObjectUtil.clickElement(Draas.getNav_SCRAddDriveWindowClose());
		WebObjectUtil.explicitWait(2);
		
		WebObjectUtil.clickAndVerifyElement(Draas.getNav_SCRManageBtn(), Draas.getNav_ManageBtnDialog());
		WebObjectUtil.clickElement(Draas.getNav_ManageHistoryDialogClose());
		WebObjectUtil.explicitWait(2);
		
		WebObjectUtil.clickAndVerifyElement(Draas.getNav_SCRHistoryBtn(), Draas.getNav_HistoryBtnDialog());
		WebObjectUtil.clickElement(Draas.getNav_ManageHistoryDialogClose());
		WebObjectUtil.explicitWait(2);
		
		//Verifying SCR Link
		WebObjectUtil.verifyElementPresent(Draas.getNav_SCRLink());
		//Logout
		LoginTestCase.nav_Logout();
		
		
	}
	
	/*==============================================================
	TestScript  	: navVerifyAddDriveSBRPDFCSV
	Manual TestCase	: CPPOC-3161 -Verify SBR name (Storage Based Replication) is matching with PDF and CSV reports, and Add Drive link on DRaaS detail page. (On PDF and CSV reports, it was showing up as Storage Array Based Replication)
	Description		: SBR name is displayed as "Storage Based Replication" on all pages
	Author 			: Vivek Kumar
	Creation Date 	: 08/13/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=6)
	public void navVerifyAddDriveSBRPDFCSV()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Draas);
		
		String sUserName,sPassword;
		boolean bStatus, bPDFStatus,bCSVStatus;;
		String sSBRText,sPDFText,sCSVText;
		
		
		FrameworkUtil.sTestCaseName = "Clark-navVerifyAddDriveSBRPDFCSV";
		FrameworkUtil.sManualTestCaseName="CPPOC-3161Verify SBR name is matching with PDF and CSV reports";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.DRAAS.CROLE");
		sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.DRAAS.CROLE");
		LoginTestCase.nav_Login(sUserName, sPassword);
		
		//Click and verifying DraaS Landing page
		navigateToDraaS(sUserName);
		//Verifying SBR
		WebObjectUtil.verifyElementPresent(Draas.getNav_SBRProduct());
		sSBRText=Draas.getNav_SBRProduct().getText();
		if(sSBRText.contains("Storage Based Replication"))
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verifying product", "pass","Storage Based Replication");
		}
		else
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verifying product", "fail","Storage Based Replication");
		}
			
		//Verifying Add link
		WebObjectUtil.clickAndVerifyElement(Draas.getNav_SBRAddDrive(), Draas.getNav_SBRAddDriveWindow());
		WebObjectUtil.clickElement(Draas.getNav_SBRADDDriveWindowClose());
		WebObjectUtil.explicitWait(2);
		
		sPDFText=Draas.getNav_PDFLinkUnderDraas().getAttribute("alt");
		sCSVText=Draas.getNav_CSVLinkUnderDraas().getAttribute("alt");
		
		bPDFStatus=sPDFText.contains("PDF");
		FrameworkUtil.updateCustomResultBasedOnStatus(bPDFStatus, " Verifying PDF File");
		
		bCSVStatus=sCSVText.contains("CSV");
		FrameworkUtil.updateCustomResultBasedOnStatus(bPDFStatus, " Verifying CSV File");
		
		//Logout
		LoginTestCase.nav_Logout();
	}
	
	/*==============================================================
	TestScript  	: navVerifyDRaas
	Manual TestCase	:CPPOC-3160-Verify DRaaS name is displayed as "DRaaS" across pages instead of "Draas"
	Description		: Verify DRaaS name is displayed as "DRaaS" across pages instead of "Draas"
	Author 			: Vivek Kumar
	Creation Date 	: 08/13/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=7)
	public void navVerifyDRaas()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Draas);
		
		String sUserName,sPassword,sText;
		boolean bStatus;
		
		FrameworkUtil.sTestCaseName = "Clark-navVerifyDRaas";
		FrameworkUtil.sManualTestCaseName="CPPOC-3160-Verify DRaaS name is displayed as 'DRaaS' across pages instead of 'Draas'";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.DRAAS.CROLE");
		sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.DRAAS.CROLE");
		LoginTestCase.nav_Login(sUserName, sPassword);
		
		//Click and verifying DraaS Landing page
		navigateToDraaS(sUserName);
		
		sText=Draas.getNav_DRaaSBreadCrumb().getText();
		FrameworkUtil.updateCustomResultBasedOnStatus(sText.equals("DRaaS"),"Verify DRaaS text ");
		
		//Logout
		LoginTestCase.nav_Logout();
	}
	
	/*==============================================================
	TestScript  	: navVerifyLearnMore
	Manual TestCase	:CPPOC-3149-Verify on DRaaS detail page, when user clicks on "Learn More" link, it opens on same page.
	Description		: Verify on DRaaS detail page, when user clicks on "Learn More" link, it opens on same page.
	Author 			: Vivek Kumar
	Creation Date 	: 08/13/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=8)
	public void navVerifyLearnMore()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Draas);
		
		String sUserName,sPassword;
		boolean bStatus;
		
		FrameworkUtil.sTestCaseName = "Clark-navVerifyLearnMore";
		FrameworkUtil.sManualTestCaseName="CPPOC-3149-Verify on DRaaS detail page, when user clicks on 'Learn More' link, it opens on same page.";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.TSTDEVCO1.RRAMDEV.USERID");
		sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.TSTDEVCO1.RRAMDEV.PASSWORD");
		LoginTestCase.nav_Login(sUserName, sPassword);
		
		//Click and verifying DraaS Landing page
		navigateToDraaS(sUserName);
		
		//Clicking on Learn More link and verifying its landing page
		WebObjectUtil.clickAndVerifyElement(Draas.getNav_DRaasLearnMoreLnk(), Draas.getNav_DRaaSProdtPage());
		
		//Logout
		LoginTestCase.nav_Logout();
		
	}
	
	/*==============================================================
	TestScript  	: navVerifyAbleCollapseTwistys
	Manual TestCase	:CPPOC-3148-On a DRaaS detail page, verify user is able to collapse all twistys.
	Description		: On a DRaaS detail page, verify user is able to collapse all twistys.
	Author 			: Vivek Kumar
	Creation Date 	: 08/14/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=9)
	public void navVerifyAbleCollapseTwistys()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Draas);
		
		String sUserName,sPassword,sText;
		boolean bStatus;
		
		FrameworkUtil.sTestCaseName = "Clark-navVerifyAbleCollapseTwistys";
		FrameworkUtil.sManualTestCaseName="CPPOC-3148-On a DRaaS detail page, verify user is able to collapse all twistys.";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.TSTDEVCO1.RRAMDEV.USERID");
		sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.TSTDEVCO1.RRAMDEV.PASSWORD");
		LoginTestCase.nav_Login(sUserName, sPassword);
		
		//Click and verifying DraaS Landing page
		navigateToDraaS(sUserName);
		
		//Collapsing More DRaaS product
		if(WebObjectUtil.isElementPresent(Draas.getNav_MoreDRaaSPdtExpander()))
		{
			WebObjectUtil.clickElement(Draas.getNav_MoreDRaaSPdtExpander());
			WebObjectUtil.explicitWait(5);
			sText=Draas.getNav_MoreDRaaSPdtExpander().getAttribute("src");
			bStatus=sText.contains("Compress_Arrow");
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "User can collapse 'More DRaaS Product' twistys");
		}
		else
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verifying Product", "warn","'More DRaaS Product'not available");
		}
		
		
		//Collapsing S2CR
		if(WebObjectUtil.isElementPresent(Draas.getNav_S2CRExpander()))
		{
			WebObjectUtil.clickElement(Draas.getNav_S2CRExpander());
			WebObjectUtil.explicitWait(5);
			sText=Draas.getNav_S2CRExpander().getAttribute("src");
			bStatus=sText.contains("Compress_Arrow");
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "User can collapse 'S2CR' twistys");	
		}
		else
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verifying Product", "warn","'S2CR'not available");
		}
		
		
		//Collapsing SBR
		if(WebObjectUtil.isElementPresent(Draas.getNav_SBRExpander()))
		{
			WebObjectUtil.clickElement(Draas.getNav_SBRExpander());
			WebObjectUtil.explicitWait(5);
			sText=Draas.getNav_SBRExpander().getAttribute("src");
			bStatus=sText.contains("Compress_Arrow");
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "User can collapse 'SBR' twistys");
		}
		else
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verifying Product", "warn","'SBR'not available");
		}
		
		
		
		//Collapsing SRM
		if(WebObjectUtil.isElementPresent(Draas.getNav_SRMExpander()))
		{
			WebObjectUtil.clickElement(Draas.getNav_SRMExpander());
			WebObjectUtil.explicitWait(5);
			sText=Draas.getNav_SRMExpander().getAttribute("src");
			bStatus=sText.contains("Compress_Arrow");
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "User can collapse 'SRM' twistys");
		}
		else
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verifying Product", "warn","'SBR'not available");
		}
		
		//Collapsing C2CR
		if(WebObjectUtil.isElementPresent(Draas.getNav_C2CRExpander()))
		{
			WebObjectUtil.clickElement(Draas.getNav_C2CRExpander());
			WebObjectUtil.explicitWait(5);
			sText=Draas.getNav_C2CRExpander().getAttribute("src");
			bStatus=sText.contains("Compress_Arrow");
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "User can collapse 'C2CR' twistys");
		}
		else
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verifying Product", "warn","'C2CR' not available");
		}
		
		
		//Logout
		LoginTestCase.nav_Logout();
		
	}
	
	/*==============================================================
	TestScript  	: navVerifyDeleteTicketCreation
	Manual TestCase	: CPPOC-3140-Verify a confirmation message or "ticket is successfully created" message displays 
					  when user click on "Delete" link on "Manage" button
	Description		: Verify a confirmation message or "ticket is successfully created" message displays 
					  when user click on "Delete" link on "Manage" button.
	Author 			: Vivek Kumar
	Creation Date 	: 08/17/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=10)
	public void navVerifyDeleteTicketCreation()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Draas);
		
		String sUserName,sPassword,sConfirmMsg = null,sUserActualMessage;
		boolean bStatus,flag=false;
		int iRowcnt;
		WebElement wDeleteLink;
		
		
		FrameworkUtil.sTestCaseName = "Clark-navVerifyDeleteTicketCreation";
		FrameworkUtil.sManualTestCaseName=" CPPOC-3140-Verify a confirmation message or 'ticket is successfully created' message.";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
		sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
		LoginTestCase.nav_Login(sUserName, sPassword);
		
		//Click and verifying DraaS Landing page
		navigateToDraaS(sUserName);
		//clicking on Manage btn and verifying the delete functionality
		VerifyDeleteFunctionality();
	
		//verifying Ticket
		
		String Arr[];
		String sTicketID;
		if(flag){
			Arr=sConfirmMsg.split(":");
			sTicketID=Arr[1].trim();
			
			//Navigate to Ticket pg
			TicketTestCase.navigateToTicketPage();
			//Serching ticket with TicketId
			TicketTestCase.searchTicket("Ticket ID", sTicketID);
			WebObjectUtil.explicitWait(5);
			TicketTestCase.SearcResultFound("TicketID",3, sTicketID);
			
		}
		//Logout
		LoginTestCase.nav_Logout();
	}
	
	/*==============================================================
	TestScript  	: navVerifyAddManageHistoryNotAppears
	Manual TestCase	: CPPOC-3138-If a user doesn't have any DRaaS products (Products=0), Add Drive link, Manage and History buttons are hidden. 
	Description		: If a user doesn't have any DRaaS products (Products=0), Add Drive link, Manage and History buttons are hidden. 
	Author 			: Vivek Kumar
	Creation Date 	: 08/17/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	//@Test(priority=11)
	public void navVerifyAddManageHistoryNotAppears()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Draas);
		
		String sUserName,sPassword,sActualSBRPrdt1,sActualSBRPrdt2,sExpectedSBRPrdt1,sExpectedSBRPrdt2;
		boolean bStatus,flag=false;
		int iSBRPrdtValue1,iSBRPrdtValue2;
		WebElement wDeleteLink;
		
		
		FrameworkUtil.sTestCaseName = "Clark-navVerifyAddManageHistoryNotAppears";
		FrameworkUtil.sManualTestCaseName="CPPOC-3138-If a user doesn't have any DRaaS products (Products=0), Add Drive link, Manage and History buttons are hidden.";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		sExpectedSBRPrdt1=(String) FrameworkUtil.dictPropertyData.get("NAV.CLARK.DRaaS.SBR.PRODUCT1");
		sExpectedSBRPrdt2=(String) FrameworkUtil.dictPropertyData.get("NAV.CLARK.DRaaS.SBR.PRODUCT2");
		
		
		sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.TSTDEVCO1.SRAVURIDEV.USERID");
		sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.TSTDEVCO1.SRAVURIDEV.PASSWORD");
		LoginTestCase.nav_Login(sUserName, sPassword);
		
		//Click and verifying DraaS Landing page
		navigateToDraaS(sUserName);
		
		WebTableUtil.printEachCellText(Draas.getNav_StorageBsedRepPrdtTable());
		sActualSBRPrdt1=WebTableUtil.getCellData(Draas.getNav_StorageBsedRepPrdtTable(), 1, 1);
		iSBRPrdtValue1=Integer.parseInt(WebTableUtil.getCellData(Draas.getNav_StorageBsedRepPrdtTable(), 1, 2));
		
		sActualSBRPrdt2=WebTableUtil.getCellData(Draas.getNav_StorageBsedRepPrdtTable(), 2, 1);
		iSBRPrdtValue2=Integer.parseInt(WebTableUtil.getCellData(Draas.getNav_StorageBsedRepPrdtTable(), 2, 2));
		
		
		
		if(sActualSBRPrdt1.equals(sExpectedSBRPrdt1) && iSBRPrdtValue1==0 && sActualSBRPrdt2.equals(sExpectedSBRPrdt2) && iSBRPrdtValue2==0)
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verifying SBR with 0 product", "pass","Verified");
			
			//Verifying that Add Drive, Manage and History is not there with product 0
			bStatus=WebObjectUtil.isElementPresent(Draas.getNav_SBRAddDrive());
			FrameworkUtil.updateCustomResultBasedOnStatus(!bStatus, "Add Drive is not available");
			
			bStatus=WebObjectUtil.isElementPresent(Draas.getNav_SBRManageBtn());
			FrameworkUtil.updateCustomResultBasedOnStatus(!bStatus, "Manage Btn is not available");
			
			bStatus=WebObjectUtil.isElementPresent(Draas.getNav_SBRHistoryBtn());
			FrameworkUtil.updateCustomResultBasedOnStatus(!bStatus, "History Btn is not available");
			
			WebDriverUtil.refreshBrowser();
			WebObjectUtil.explicitWait(5);
			
			
			bStatus=WebObjectUtil.isElementPresent(Draas.getNav_SBRAddDrive());
			FrameworkUtil.updateCustomResultBasedOnStatus(!bStatus, "Add Drive is not available after Refresh");
			
			bStatus=WebObjectUtil.isElementPresent(Draas.getNav_SBRManageBtn());
			FrameworkUtil.updateCustomResultBasedOnStatus(!bStatus, "Manage Btn is not available after Refresh");
			
			bStatus=WebObjectUtil.isElementPresent(Draas.getNav_SBRHistoryBtn());
			FrameworkUtil.updateCustomResultBasedOnStatus(!bStatus, "History Btn is not available after Refresh");
			
			
		}
		else
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verifying SBR with 0 product", "fail","SBR is having product more than 0");
		}
		
		//Logout
		LoginTestCase.nav_Logout();
		
	}
	
	/*==============================================================
	TestScript  	: navVerifyMarketingPgOtherThanSRM
	Manual TestCase	: CPPOC-3097-WCP user who doesn't have any DRaaS products, 
					  verify user is only able to view 3 product marketing pages because SRM product will never be shown as a more. 
	Description		:  The SRM product will never be shown as a More.
	Author 			: Vivek Kumar
	Creation Date 	: 08/18/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=12)
	public void navVerifyMarketingPgOtherThanSRM()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Draas);
		
		
		String sUserName,sPassword;
		boolean bStatus;
		
		FrameworkUtil.sTestCaseName = "Clark-navVerifyMarketingPgOtherThanSRM";
		FrameworkUtil.sManualTestCaseName="CPPOC-3097-WCP user who doesn't have any DRaaS products,verify user is only able to view 3 product marketing pages because SRM product will never be shown as a more. ";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.USERID.AROLE");
		sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.PASSWORD.AROLE");
		LoginTestCase.nav_Login(sUserName, sPassword);
		
		//Click and verifying DraaS Landing page
		navigateToDraaS(sUserName);
		
		
		
		String sImageSrc,sImageName;
		int iIndex;
		
		List<WebElement> ImageList=Draas.getNav_Image().findElements(By.tagName("img"));
		if(ImageList.size()==3)
		{
			for(WebElement wImg:ImageList)
			{
				sImageSrc=wImg.getAttribute("src");
				String Arr[];
				Arr=sImageSrc.split("/");
				iIndex=Arr.length-1;
				sImageName=Arr[iIndex];
				
				if(sImageName.contains("srm")){
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verifying SRM should not available ", "fail","SRM is available");
				}
				else
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verifying Product Marketing image", "pass",sImageName + " - image available");
				}
				
			}
		}
		
			
		//Logout
		LoginTestCase.nav_Logout();
	}
	
	/*==============================================================
	TestScript  	: VerifyClarkDraasPdfIcon
	Manual TestCase	: CPPOC-3096
	Description		:  When a user click on the PDF report in the 
	                   DRaaS detail page, a blank page is displayed
	Author 			: Priyanka R
	Creation Date 	: 10/8/15
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=85)
	public void VerifyClarkDraasPdfIcon()

	{
		//Scope is fixed to validate the "PDF" Icon being displayed.
		PageFactory.initElements(WebDriverUtil.getDriver(),Draas);
	
try{
	    String sUserName=null,sPassword=null;
		FrameworkUtil.sTestCaseName = "Clark-VerifyClarkDraasPdfIcon()";
		FrameworkUtil.sManualTestCaseName= "CPPOC-3096";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Draas);
		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.USERID.AROLE");
		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.EBPANEL.PASSWORD.AROLE");
		LoginTestCase.nav_Login(sUserName,sPassword);
		WebObjectUtil.clickElement(Draas.getNav_MultiOrgDraasLinkHome());
		WebObjectUtil.explicitWait(15);
		WebObjectUtil.verifyElementPresent(Draas.getNav_ClarkDraasPdficon());
		
		LoginTestCase.nav_Logout();
	}catch(Exception e)
		{
			LoggerUtil.log_type_error("issue with- Clark-VerifyClarkDraasPdfIcon" );
			LoggerUtil.log_type_error(e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	TestScript  	: navVerifyAddDrive
	Manual TestCase	: CPPOC-3005-If products are displayed, verify user is able to click "Add Drive" link and perform the action.
	Description		: If products are displayed, verify user is able to click "Add Drive" link and perform the action.
	Author 			: Vivek Kumar
	Creation Date 	: 08/19/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=17)
	public void navVerifyAddDrive()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Draas);
		
		String sUserName,sPassword,sIPAddress,sDriveName,sHostOS,sVersion,sRecoveryDest;
		boolean bStatus;
		
		
		FrameworkUtil.sTestCaseName = "Clark-navVerifyAddDrive";
		FrameworkUtil.sManualTestCaseName="CPPOC-3005-If products are displayed, verify user is able to click 'Add Drive' link and perform the action.";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
		sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
		sIPAddress=(String) FrameworkUtil.dictPropertyData.get("NAV.CLARK.DRaaS.ADDDRIVE.IPADDRESS");
		sDriveName=(String) FrameworkUtil.dictPropertyData.get("NAV.CLARK.DRaaS.ADDDRIVE.DRIVE");
		sHostOS=(String) FrameworkUtil.dictPropertyData.get("NAV.CLARK.DRaaS.ADDDRIVE.HOST.OS");
		sVersion=(String) FrameworkUtil.dictPropertyData.get("NAV.CLARK.DRaaS.ADDDRIVE.VERSION");
		sRecoveryDest=(String) FrameworkUtil.dictPropertyData.get("NAV.CLARK.DRaaS.ADDDRIVE.RECOVERY.DEST");
		
		
		
		LoginTestCase.nav_Login(sUserName, sPassword);
		
		//Navigating to Draas Page
		navigateToDraaS(sUserName);
		
		//Clicking on Add Drive Link		
		WebObjectUtil.clickElement(Draas.getNav_SCRAddDrive());
		
		//Inputting Add Drive
		WebObjectUtil.SetValueEdit(Draas.getNav_AddDriveHostName(), "SeleniumTest12345");
		WebObjectUtil.SetValueEdit(Draas.getNav_AddDriveHostIP(), sIPAddress);
		WebObjectUtil.SetValueEdit(Draas.getNav_AddDriveToAdd(), sDriveName);
		
		WebObjectUtil.selectCheckRadioBox(Draas.getNav_AddDriveNewHostChkBox());
		
		WebObjectUtil.SetValueEdit(Draas.getNav_AddDriveHostOS(), sHostOS);
		WebObjectUtil.SetValueEdit(Draas.getNav_AddDriveVersion(), sVersion);
		
		WebObjectUtil.selectCheckRadioBox(Draas.getNav_AddDriveVMServerRadioBtn());
		WebObjectUtil.SetValueEdit(Draas.getNav_AddDriveRecoveryDest(), sRecoveryDest);
		WebObjectUtil.explicitWait(3);
		//Clicking on save btn
		WebObjectUtil.clickElement(Draas.getNav_AddDriveSaveBtn());
		
		WebObjectUtil.explicitWait(10);
		WebObjectUtil.verifyElementPresent(Draas.getNav_PopUp());
		String sConfirmMsg=Common.getNav_PopUpMessage().getText().trim();
		WebObjectUtil.clickElement(Common.getNav_PopUpOKBtn());
		
			
		String sUserActualMessage=Draas.getNav_FeedBack().getText().trim();
		
		bStatus=WebObjectUtil.compareString(sConfirmMsg, sUserActualMessage, true);
		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, sUserActualMessage);
		
		//Logout
		LoginTestCase.nav_Logout();
	}
	
	/*==============================================================
	TestScript  	: navVerifyUserCanAccessHistory
	Manual TestCase	:CPPOC-3004-Verify user is able to click/view History button for existing DRaaS products.
	Description		: Verify user is able to click/view History button for existing DRaaS products. 
	Author 			: Vivek Kumar
	Creation Date 	: 08/18/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=13)
	public void navVerifyUserCanAccessHistory()
	{
		
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Draas);
		
		
		String sUserName,sPassword;
		boolean bStatus;
		
		FrameworkUtil.sTestCaseName = "Clark-navVerifyUserCanAccessHistory";
		FrameworkUtil.sManualTestCaseName="CPPOC-3004-Verify user is able to click/view History button for existing DRaaS products.";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
		sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
		LoginTestCase.nav_Login(sUserName, sPassword);
		
		//Click and verifying DraaS Landing page
		navigateToDraaS(sUserName);


		WebObjectUtil.clickAndVerifyElement(Draas.getNav_SCRHistoryBtn(), Draas.getNav_HistoryBtnDialog());
		WebObjectUtil.clickElement(Draas.getNav_ManageHistoryDialogClose());
		WebObjectUtil.explicitWait(2);
		
		//Logout
		LoginTestCase.nav_Logout();
	}
	
	/*==============================================================
	TestScript  	: navVerifyUserCanAccessLearnMore
	Manual TestCase	:CPPOC-3002-When a user clicks on "Learn More" link, 
					 verify it navigates user to more DRaaS products information page.
	Description		:When clicked on the "Learn more" link, it navigates user to get more DRaaS products information
	Author 			: Vivek Kumar
	Creation Date 	: 08/19/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=14)
	public void navVerifyUserCanAccessLearnMore()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Draas);
		
		String sUserName,sPassword;
		boolean bStatus;
		
		FrameworkUtil.sTestCaseName = "Clark-navVerifyLearnMore";
		FrameworkUtil.sManualTestCaseName="CPPOC-3002-Verify on DRaaS detail page, when user clicks on 'Learn More' link, it opens on same page.";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
		sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
		LoginTestCase.nav_Login(sUserName, sPassword);
		
		//Click and verifying DraaS Landing page
		navigateToDraaS(sUserName);
		
		//Clicking on Learn More link and verifying its landing page
		WebObjectUtil.clickAndVerifyElement(Draas.getNav_DRaasLearnMoreLnk(), Draas.getNav_DRaaSProdtPage());
		
		//Logout
		LoginTestCase.nav_Logout();
	}
	
	/*==============================================================
	TestScript 		: nav_VerifyTheDotsInDRaaSROLEA
	Manual TestCase	: Hover over to DRaaS portlet and verify the number of dots Present in the portlet
	Description		: Hover over to DRaaS portlet and verify the number of dots Present in the portlet
	Author 			: QAA02
	Creation Date 	: 08/20/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
 @Test(priority=108)
    public void nav_VerifyTheDotsInDRaaSROLEA() {
  	
  	  WebDriver driver = WebDriverUtil.getDriver();
  	  PageFactory.initElements(driver, Draas);
  	  try {
  		  
  	
  	  FrameworkUtil.sTestCaseName="Clark-nav_VerifyTheDotsInDRaaSROLEA";
  	  FrameworkUtil.sManualTestCaseName="(CPPOC-2998)Hover over to DRaaS portlet and verify the number of dots Present in the portlet";
  	  FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
  	  
  	  String sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEA.USERID");
	  String sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEA.PASSWORD");
  	  LoginTestCase.nav_Login(sUserName, sPassword);
  	  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "ROLEALogin", "Pass", "Login Sucess");
	
 
	  WebObjectUtil.clickElement(Draas.getNav_DraasLink());
  	  WebObjectUtil.explicitWait(5);
	  
  	  List<WebElement>ProductList;
	  int iproducts=0;
        if(WebObjectUtil.isElementPresent(Draas.getNav_productsDivisionunderDRaasPage())) {
    	
            ProductList = Draas.getNav_productsDivisionunderDRaasPage().findElements(By.xpath("//span[contains(@id,'rPanel_header_hd-textEl')]"));
	    	//    ProductList = (List<WebElement>) Clark.getNav_productsUnderDRaaasPage().getSize();
            iproducts=ProductList.size();
            FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "ProductsListInDRaaSPortlet", "Pass", "Product Count In DRaaS Portlet= "+iproducts);
    
     }
     else
     {
    	 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "ProductsListInDRaaSPortlet", "warn", "Products are not present in DRaaS Portlet");
     }  
  	  
    WebObjectUtil.explicitWait(5);
	  
      WebObjectUtil.clickElement(Draas.getNav_breadCrumbChainHomeLink());
      WebObjectUtil.explicitWait(3);
	  WebObjectUtil.MouseHover(Draas.getNav_DRaaSPortlet()); 
	  	 
	 List<WebElement> dotsList;
	   int idots=0;

	   if (!WebObjectUtil.isElementPresent(Draas.getNav_DotsInDRaaSPortlet())){

			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "DotsListInDRaaSPortlet", "Pass", "Dots are not present in DRaaS Portlet as expected");
	   }
	   else
	   {
			dotsList = Draas.getNav_DotsInDRaaSPortlet().findElements(By.tagName("div"));
			idots= dotsList.size();
		   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "DotsListInDRaaSPortlet", "fail",  "Dots Count In DRaaS Portlet= "+idots);
	   }
	 
	   
	 if(idots==iproducts)
	 {
		 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Matched", "Pass", "Product Count In DRaaS Page is same as dots in DRaaS portlet");
		 
	 }
	 else
	 {
		 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "NotMatched", "fail", "Product Count In DRaaS Page is not same as dots in DRaaS portlet");
	 }  
     WebObjectUtil.explicitWait(5);
     
     
     LoginTestCase.nav_Logout();
  	  }
  	catch (Exception e) {
		// TODO Auto-generated catch block
         	LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
	}
	}
 
 
 
 
 /*==============================================================
	TestScript 		: nav_VerifyTheProductTitles
	Manual TestCase	: Hover over to DRaaS portlet and verify the product title is updated when selected different dots
	Description		: Hover over to DRaaS portlet and verify the product title is updated when selected different dots with Agent user
	Author 			: QAA02
	Creation Date 	: 08/21/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
 @Test(priority=109)
    public void nav_VerifyTheProductTitles() {
	 
  	  WebDriver driver = WebDriverUtil.getDriver();
  	  PageFactory.initElements(driver, Draas);
  	  try {
  		  

  	WebElement wProductTitle,wDot,wTitle;
	 String sProductTitle;
  	 int i;
  	 int k=2; 
  	  FrameworkUtil.sTestCaseName="Clark-nav_VerifyTheProductTitles";
  	  FrameworkUtil.sManualTestCaseName="(CPPOC-2999)Hover over to DRaaS portlet and verify the product title is updated when selected different dots";
  	  FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
  	  
      String sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.TSTGETSMART.AGENT.USERID");
  	  String sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.TSTGETSMART.AGENT.PASSWORD");
  	  LoginTestCase.nav_Login(sUserName, sPassword);
  	  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "AGENTLogin", "Pass", "Login Sucess");
  	
  	  List<WebElement> dotsList;
	   int idots=0;
	  
	   if (WebObjectUtil.isElementPresent(Draas.getNav_DotsInDRaaSPortlet())){
			
		   
		    dotsList = Draas.getNav_DotsInDRaaSPortlet().findElements(By.tagName("div"));
		    idots= dotsList.size();
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "DotsListInDRaaSPortlet", "Pass", "Dots Count In DRaaS Portlet= "+idots);
			 String Arr[] = new String[idots];
		
			  
			
			for( i=1; i<=idots; i++)
			{
				
				WebObjectUtil.explicitWait(5);
				//WebElement wDot=WebObjectUtil.GetWebElement("xpath", "//section[@id='draas']//div[@class='bx-pager bx-default-pager']//div["+i+"]/a", "Dots");
				 // This object is updated on 10/13/2015 By QAA04
				wDot = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.DRAAS.DOT","PARAMETER_VALUE",i+"");
				WebObjectUtil.clickElement(wDot);
				WebObjectUtil.explicitWait(5);
				
				
				//WebElement wTitle=WebObjectUtil.GetWebElement("xpath", "//div["+i+"]/div[@class='draas_header_text']", "DRaaS Title Header");
				 // This object is updated on 10/13/2015 By QAA04
				wTitle = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.DRAASPORTLET.PRODUCT.TITLE","PARAMETER_VALUE",i+"");
				String sTitle=wTitle.getText();
				WebObjectUtil.VerifyTextUnderElement(wTitle, sTitle);
				Arr[i-1]=sTitle;
		
			
		//navigate to DRaas Page
			WebObjectUtil.clickElement(Draas.getNav_DraasLink()); 
		
			  if(WebObjectUtil.isElementPresent(Draas.getNav_productsDivisionunderDRaasPage())) {
			
				 // wProductTitle=WebObjectUtil.GetWebElement("xpath", "//div[@id='idMainContainer-innerCt']/div/div["+ k +"]//span", "DRaaS Product Title Header");
				  // This object is updated on 10/13/2015 By QAA04
				  wProductTitle = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.DRAAS.PRODUCT.TITLE", "PARAMATER_VALUE",  k +"");
				  sProductTitle = wProductTitle.getText();
				  if (sProductTitle.contains(Arr[i-1])){
					  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verify Product title", "pass", "Product Title verified" + sProductTitle);
				  }else{
					  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verify Product title", "fail", "Product Title NOT verified" + sProductTitle);
				  }
				
			  }
		       k++;
		        WebObjectUtil.explicitWait(5);
	            driver.navigate().back();
		        //WebObjectUtil.ClickAndMouseHover(Clark.getNav_breadCrumbChainHomeLink());
	   }
 }
			else
	   {
		   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "DotsListInDRaaSPortlet", "fail", "Dots are not present in DRaaS Portlet");
	   } 
	   LoginTestCase.nav_Logout();
  	  }
  	catch (Exception e) {
		// TODO Auto-generated catch block
         	LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
	}

  }
	
	/*==============================================================
	Method Name 	: navigateToDraaS
	Description		: This will navigate to draas
	Author 			: Vivek Kumar
	Creation Date 	: 08/19/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navigateToDraaS(String sUserName)
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Draas);
		
		boolean bStatus;
		//Click and verifying DraaS Landing page
		bStatus=WebObjectUtil.clickAndVerifyText(Draas.getNav_DraaSSection(), "Name");
		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus,sUserName +" able to view Draas Page");
	}
	
	/*==============================================================
	Method Name 	: VerifyDeleteFunctionality
	Description		: This will validate delete functionality
	Author 			: Vivek Kumar
	Creation Date 	: 08/19/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void VerifyDeleteFunctionality()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Draas);
		
		int iRowcnt;
		WebElement wDeleteLink;
		String sConfirmMsg,sUserActualMessage;
		boolean bStatus,flag;
		
		//Clicking on Manage button
		WebObjectUtil.clickElement(Draas.getNav_SCRManageBtn());
		
		if(WebObjectUtil.isElementPresent(Draas.getNav_ManageBtnDialog()))
		{
			iRowcnt=WebTableUtil.getRowCount(Draas.getNav_ManageBtnDialogTable());
			if(iRowcnt>0)
			{
				//wDeleteLink=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr[1]//a[text()='Delete']", "Delete Link");
				 // This object is updated on 10/13/2015 By QAA04
				wDeleteLink = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.DRAAS.DELETELINK","","");
				WebObjectUtil.clickElement(wDeleteLink);
				WebObjectUtil.verifyElementPresent(Draas.getNav_DeleteWindowConfirmationDialog());
				WebObjectUtil.clickElement(Draas.getNav_DeleteWindowDialogOKBtn());
				
				WebObjectUtil.explicitWait(10);
				WebObjectUtil.verifyElementPresent(Draas.getNav_PopUp());
				sConfirmMsg=Common.getNav_PopUpMessage().getText().trim();
				WebObjectUtil.clickElement(Common.getNav_PopUpOKBtn());
				
				//Closing Delete Popup
				WebObjectUtil.clickElement(Draas.getNav_ManageHistoryDialogClose());
				
				sUserActualMessage=Draas.getNav_FeedBack().getText().trim();
				
				bStatus=WebObjectUtil.compareString(sConfirmMsg, sUserActualMessage, true);
				FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, sUserActualMessage);
				flag=true;

			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verifying Manage Table- Row", "warn",iRowcnt + " row  available");
			}
		}
		else
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verifying Manage Table", "fail","Manage dialog not displayed");
		}
	}
	/* ==============================================================
	TestScript 		: nav_VerifyStorageBasedReplicationTitle
	Manual TestCase	: click on Add Drive link, and verify SBR is displayed as Storage Based Replication instead of Storage Array Based Replication
	Description		: click on Add Drive link, and verify SBR is displayed as Storage Based Replication instead of Storage Array Based Replication
	Author 			: QAA02
	Creation Date 	: 08/19/2015
	Pre-Requisites	:
	Revision History:
	============================================================== */
 //Already covered By Vivek
 @Test(priority=106)
 public void nav_VerifyStorageBasedReplicationTitle() {
	 
	 WebDriver driver = WebDriverUtil.getDriver();
	 PageFactory.initElements(driver, Draas);
	 try {
		 

	 FrameworkUtil.sTestCaseName ="Clark-nav_VerifyStorageBasedReplicationTitle";
	 FrameworkUtil.sManualTestCaseName ="(CPPOC-3161)click on Add Drive link, and verify SBR is displayed as Storage Based Replication instead of Storage Array Based Replication";
	 FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	 
	String sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.DRAAS.CROLE");
	String sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.DRAAS.CROLE");
	 LoginTestCase.nav_Login(sUserName, sPassword);
	 
	 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(),FrameworkUtil.sElementName, "ROLE-ELogin", "Pass", "Login Sucess");
	 
	 
	 WebObjectUtil.clickElement(Draas.getNav_DraasLink());
     WebObjectUtil.isElementPresent(Draas.getNav_StorageBasedReplicationProductTitle());
	 WebObjectUtil.verifyElementPresent(Draas.getNav_PDFLink());
     WebObjectUtil.verifyElementPresent(Draas.getNav_CSVLink());
     
     String pdfTitle = Draas.getNav_PDFLink().getAttribute("alt");
     boolean verifyPdf = pdfTitle.contains("PDF");
     FrameworkUtil.updateCustomResultBasedOnStatus(verifyPdf, "verifyPdf");
     
     String csvTitle = Draas.getNav_CSVLink().getAttribute("alt");
     boolean verifycsv = csvTitle.contains("CSV");
     FrameworkUtil.updateCustomResultBasedOnStatus(verifycsv, "verifycsv");
     
     WebObjectUtil.clickElement(Draas.getNav_AddDriveLinkUnderSBR());
     WebObjectUtil.explicitWait(5);
     WebObjectUtil.clickElement(Draas.getNav_CancelBtnAddDriverLinkUnderSBR());
     WebObjectUtil.explicitWait(5);
     
     WebObjectUtil.VerifyTextUnderElement(Draas.getNav_StorageBasedReplicationProductTitle(), "Storage Based Replication");
   
     LoginTestCase.nav_Logout();
	 }
	 catch (Exception e) {
			// TODO Auto-generated catch block
	         	LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
 }
	///____________________ Gideon testcases ______________________________________ /////
	
	/*==============================================================
	TestScript 		: nav_LearnMoreLink
	Manual TestCase	: Click on Learn More link on DRaaS page
	Description		: verify The Title in learm more page 
	Author 			: QAA04
	Creation Date 	: 08/26/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=12)
	public void nav_LearnMoreLink() {
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,Draas);
		PageFactory.initElements(driver,Home);
		try {
		FrameworkUtil.sTestCaseName="DRaaS-nav_LearnMoreLink";
		FrameworkUtil.sManualTestCaseName="(CPPOC-3238)Click on Learn More link on DRaaS page";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);

		String sUserName =(String)FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
	    String sPassword =(String)FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
		LoginTestCase.nav_Login(sUserName, sPassword);
		
		
		
		WebObjectUtil.clickElement(Home.getNav_ServicesTab());
		WebObjectUtil.clickElement(Draas.getNav_DraasLink());
		WebObjectUtil.clickElement(Draas.getNav_DRaasLearnMoreLnk());
		WebObjectUtil.explicitWait(5);
		WebObjectUtil.VerifyTextUnderElement(Draas.getNav_breadCrumbChain(), "DRaaS Products");
		WebObjectUtil.explicitWait(3);
		WebObjectUtil.VerifyTextUnderElement(Draas.getNav_TitleInLearnMoreLink(), "DRaaS Features");


		LoginTestCase.nav_Logout();

	}
		catch (Exception e) {
			// TODO Auto-generated catch block
	         	LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}

	}

	////__________________________ completed GideonTestCase ________________________ ////
	
//**********************These TestScripts are taken From Clark-End*********************************************//	
	//update each @test result in custom result file
		@AfterMethod
		public static void afterEachMethod(){
			FrameworkUtil.updateTestCaseStatusinResult();
			
		}
		
}
