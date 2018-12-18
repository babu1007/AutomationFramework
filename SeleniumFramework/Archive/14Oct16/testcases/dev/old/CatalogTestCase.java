package com.whs.navigator.testcases.dev.old;

import java.util.List;

import org.openqa.selenium.By;
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
import com.whs.navigator.commonUtil.WebTableUtil;
import com.whs.navigator.pagefactory.CatalogPageFactory;


public class CatalogTestCase {
	public static CatalogPageFactory Catalog =new CatalogPageFactory();
	
	/*==============================================================
	TestScript  	: navValCatalogLinkPageObjects
	Manual TestCase	:1. Catalogs link 
					 2. Catalogs page
					 3. Catalogs page -> Windstream Objects and Private Objects
	Description		: 	Validate Catalog Link @ EVDC overview page, its landing page and objects(Private and Windstream	)
	Author 			: Vivek Kumar
	Creation Date 	: 05/07/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=1)
	public void navValCatalogLinkPageObjects()
	{
		FrameworkUtil.sTestCaseName = "Catalog-navValCatalogLinkPageObjects";
		FrameworkUtil.sManualTestCaseName= "1. Catalogs link " + '\n' +" 2. Catalogs page"+'\n'+"3. Catalogs page -> Windstream Objects and Private Objects";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		//login to catalog
		navCatalogLogin();
		//Navigating to Catalog Page
		navigateCatalogPage();
		//validating Windstream and Private Objects
		validateWindStreamandPrivatePg();
		//Logging out from Navigator application
		LoginTestCase.nav_Logout();
	}
	
	
	/*==============================================================
	TestScript  	: navValCatalogWSExpandSCopyDeployBtn
	Manual TestCase	:1. Catalogs page -> Windstream Objects
					 2. Catalogs page -> Windstream Objects -> Expand Object
	Description		: 	Verify that the Windstream Objects are displayed under the Windstream Objects tab
						Verify that the Copy and Deploy buttons are displayed when you expand the Windstream catalogs
	Author 			: Vivek Kumar
	Creation Date 	: 05/08/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=2)
	public void navValCatalogWSExpandSCopyDeployBtn()
	{
		FrameworkUtil.sTestCaseName = "Catalog-navValCatalogWSExpandSCopyDeployBtn";
		FrameworkUtil.sManualTestCaseName= "1. Catalogs page -> Windstream Objects " + '\n' +" 2. Catalogs page -> Windstream Objects -> Expand Object";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		//login to catalog
		navCatalogLogin();
		//Navigating to Catalog Page
		navigateCatalogPage();
		//Clicking on WindStream Object and Validating
		WebObjectUtil.clickElement(Catalog.getNav_CatalogWindStreamLink());
		WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogWindStreamPDFImg());
		//Expand the first WS object
		//Expanding the very first item
		WebObjectUtil.clickElement(Catalog.getNav_CatalogWindStreamFirstExpander());
		//Verifying the Copy and Deploy Btn
		WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogWindStreamCopyBtn());
		WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogWindStreamDeployBtn());
		//Logging out from Navigator application
		LoginTestCase.nav_Logout();
	}

	/*==============================================================
	TestScript  	: navValCatalogWindStreamCopyObjects
	Manual TestCase	:1. Catalogs page -> Windstream Objects -> Copy Object
					 2. Catalogs page -> Windstream Objects -> Copy page fields
					 3. Catalogs page -> Windstream Objects -> Check Copy function
					 4. Catalogs page -> Windstream Objects -> Copy -> Check Copy successful message in the Feedback area
	Description		: 	Verify that the user is able to see the page when we click on the Copy button
						Verify that the below fileds are there in the Copy page: 
						1. New Name field                                                                                                     
						2. Destination dropdown field                                                                                  
						3. Cancel and Copy buttons
						
						Verify the Copy  Windstream Template page is displayed with "This template <Name> will be copied"
						Verify the OK and Cancel buttons
						Verify the message like "  Please wait while the template is copied" 
						Verify the "Copy Successful:: Copy Catalog Successful " message is displayed in the feedback area. 
						 
	Author 			: Vivek Kumar
	Creation Date 	: 05/08/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=3)
	public void navValCatalogWindStreamCopyObjects()
	{
		FrameworkUtil.sTestCaseName = "Catalog-navValCatalogWindStreamCopyObjects";
		FrameworkUtil.sManualTestCaseName= "1.  Catalogs page -> Windstream Objects -> Copy Object " + '\n' +" 2. Catalogs page -> Windstream Objects -> Copy page fields"+ '\n' +" 3. Catalogs page -> Windstream Objects -> Check Copy function"+ '\n' +" 4. Catalogs page -> Windstream Objects -> Copy -> Check Copy successful message in the Feedback area";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		//login to catalog
		navCatalogLogin();
		//Navigating to Catalog Page
		navigateCatalogPage();
		
		//Verifying all the objects @Copy page and copy functionality under WindStream
		valWindStreamCopyPageAllObjects();
	}
	
	
	/*==============================================================
	TestScript  	: navValCatalogPrivateCopyObjects
	Manual TestCase	:1. Catalogs page -> Private Objects -> Copy Object
					 2.Catalogs page -> Private Objects -> Copy page fields
					 3. Catalogs page -> Private Objects -> Check Copy function
					 4. Catalogs page -> Private Objects -> Copy -> Check Copy successful message in the Feedback area
	Description		: 	Verify that the user is able to see the page when we click on the Copy button
						Verify that the below fileds are there in the Copy page: 
						1. New Name field                                                                                                     
						2. Destination dropdown field                                                                                  
						3. Cancel and Copy buttons
						
						Verify the Copy  Private Template page is displayed with "This template <Name> will be copied"
						Verify the OK and Cancel buttons
						Verify the message like "  Please wait while the template is copied" 
						Verify the "Copy Successful:: Copy Catalog Successful " message is displayed in the feedback area. 
						 
	Author 			: Vivek Kumar
	Creation Date 	: 05/08/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=4)
	public void navValCatalogPrivateCopyObjects()
	{
		FrameworkUtil.sTestCaseName = "Catalog-navValCatalogPrivateCopyObjects";
		FrameworkUtil.sManualTestCaseName= "1.  Catalogs page -> Private Objects -> Copy Object " + '\n' +" 2. Catalogs page -> Private Objects -> Copy page fields"+ '\n' +" 3. Catalogs page -> Private Objects -> Check Copy function"+ '\n' +" 4. Catalogs page -> Private Objects -> Copy -> Check Copy successful message in the Feedback area";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		//login to catalog
		navCatalogLogin();
		//Navigating to Catalog Page
		navigateCatalogPage();
		valPrivateCopyPageAllObjects();
		
	}
	
	/*==============================================================
	Test Script		: navValCatalogPrivateDeleteObject
	Manual TestCase	:1.Catalogs -> Private Objects -> Delete page . 2. Catalogs  -> Private Objects  ->  Delete confirmation page
	Description		: Verify the message page is displayed like " Are you sure you want to delete <object name>?" 
					  Verify the OK and Cancel buttons are displayed	
						
					 Verify the Delete CatalogItem Success page like "Successfully deleted <image name> in <Catalog: name>"
					 Verify the OK button
					 Verify the "Successfully deleted <object name> in <catalog name>"
 
	Author 			: Vivek Kumar
	Creation Date 	: 05/21/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=5)
	public void navValCatalogPrivateDeleteObject()
	{
		FrameworkUtil.sTestCaseName = "Catalog-navValCatalogPrivateDeleteObject";
		FrameworkUtil.sManualTestCaseName= "1.Catalogs -> Private Objects -> Delete page . " + '\n' +" 2. Catalogs  -> Private Objects  ->  Delete confirmation page";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		//login to catalog
		navCatalogLogin();
		//Navigating to Catalog Page
		navigateCatalogPage();
		//Validate Delete functionality
		navPrivateObjectDeleteFunctionality();
		
	}
	
	
	/*==============================================================
	Test Script		: navValCatalogPrivateDeleteCancel
	Manual TestCase	: Catalogs page ->Private Objects -> Delete -> Cancel
	Description		: Verify that the user is able to cancel the Delete catalogs successfully. 
	Author 			: Vivek Kumar
	Creation Date 	: 05/27/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=6)
	public void navValCatalogPrivateDeleteCancel()
	{
		FrameworkUtil.sTestCaseName = "Catalog-navValCatalogPrivateDeleteCancel";
		FrameworkUtil.sManualTestCaseName= "Catalogs page ->Private Objects -> Delete -> Cancel";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		//login to catalog
		navCatalogLogin();
		//Navigating to Catalog Page
		navigateCatalogPage();
		//Validate Cancel Delete functionality
		navPrivateObjectCancelDeleteFunctionality();
	}
	
	
	/*==============================================================
	Test Script		: navValCatalogPrivateManageDeleteObjects
	Manual TestCase	: Catalogs  -> Private Objects  ->  Delete confirmation page
	Description		: Verify the Delete CatalogItem Success page like "Successfully deleted <image name> in <Catalog: name>"
					  Verify the OK button
					  Verify the "Successfully deleted <object name> in <catalog name>"
 
	Author 			: Vivek Kumar
	Creation Date 	: 05/27/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=7)
	public void navValCatalogPrivateManageDeleteObjects()
	{
		FrameworkUtil.sTestCaseName = "Catalog-navValCatalogPrivateManageDeleteObjects";
		FrameworkUtil.sManualTestCaseName= "Catalogs  -> Private Objects  ->  Delete confirmation page";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		//login to catalog
		navCatalogLogin();
		//Navigating to Catalog Page
		navigateCatalogPage();
		//Verify Manage Delete catalog
		navPrivateObjectManageCatalogDeleteFunctionality();
	}
	
	
	/*==============================================================
	Test Script		: navValCatalogPrivateManageCancelDelete
	Manual TestCase	: Catalogs page ->Private Objects -> Delete -> Cancel
	Description		: Verify that the user is able to cancel the Delete catalogs successfully. 
	Author 			: Vivek Kumar
	Creation Date 	: 05/27/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=8)
	public void navValCatalogPrivateManageCancelDelete()
	{
		FrameworkUtil.sTestCaseName = "Catalog-navValCatalogPrivateManageCancelDelete";
		FrameworkUtil.sManualTestCaseName= "Catalogs  -> Private Objects  ->  Delete confirmation page";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		//login to catalog
		navCatalogLogin();
		//Navigating to Catalog Page
		navigateCatalogPage();
		//Verify Manage Cancel Delete catalog
		navPrivateObjectManageCatalogCancelDelete();
	}
	
	/*==============================================================
	Test Script		: navValCatalogWindStreamDeployFunction
	Manual TestCase	: 1. Catalogs page -> Windstream Objects -> Deploy Object
					  2. Catalogs page -> Windstream Objects -> Deply page fields
					  3. Catalogs page -> Windstream Objects -> Check Deploy function
					  4. Catalogs page -> Windstream Objects -> Deploy -> Check Deploy successful message in the Feedback area
	Description		: Verify that the user is able to deploy windstream object successfully
	Author 			: Vivek Kumar
	Creation Date 	: 05/27/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=9)
	public void navValCatalogWindStreamDeployFunction()
	{
		FrameworkUtil.sTestCaseName = "Catalog-navValCatalogWindStreamDeployFunction";
		FrameworkUtil.sManualTestCaseName= "1. Catalogs page -> Windstream Objects -> Deploy Object"+'\n'+"2. Catalogs page -> Windstream Objects -> Deply page fields"+'\n'+"3. Catalogs page -> Windstream Objects -> Check Deploy function"+'\n'+"4. Catalogs page -> Windstream Objects -> Deploy -> Check Deploy successful message in the Feedback area";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		//login to catalog
		navCatalogLogin();
		//Navigating to Catalog Page
		navigateCatalogPage();
		//Validating WindStream Deploy function
		valWindStreamDeployFunctionality();
	}
	
	
	
	//#######################################################################################################
								//METHODS\\
	//#######################################################################################################	
	/*==============================================================
	Method Name 	: navigateCatalogLogin
	Description		: Login to Catalog using devco1
	Author 			: Vivek Kumar
	Creation Date 	: 05/07/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navCatalogLogin()
	{
		String sUserName,sPassword;
		//Validating for Role-A, 
		sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLE.USERID");
		sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLE.PWD");
		//Login to Navigator with E -Role
		LoginTestCase.nav_Login(sUserName,sPassword);
	}
	
	
		/*==============================================================
		Method Name 	: navigateCatalogPage
		Description		: Navigating to catalog page
		Author 			: Vivek Kumar
		Creation Date 	: 04/22/2015
		Pre-Requisites	:
		Revision History:
		==============================================================*/
	public static void navigateCatalogPage()
	{ 	
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		//Clicking EVDC name and verifying its landing page
		WebObjectUtil.clickAndVerifyElement(Catalog.getNav_EVDCname(), Catalog.getNav_CatalogPortletLink());
		WebObjectUtil.clickAndVerifyElement(Catalog.getNav_CatalogPortletLink(), Catalog.getNav_CatalogWindStreamLink());
	}

	/*==============================================================
	Method Name 	: validateWindStreamandPrivatePg
	Description		: Verifying Windstream and Private link and their landing page
	Author 			: Vivek Kumar
	Creation Date 	: 04/22/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void validateWindStreamandPrivatePg()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		//Clicking WindStream Link and Verifying its landing page
		//WebObjectUtil.clickAndVerifyElement(Catalog.getNav_CatalogWindStreamLink(), Catalog.getNav_CatalogWindStreamPDFImg());
		WebObjectUtil.clickElement(Catalog.getNav_CatalogWindStreamLink());
		WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogWindStreamPDFImg());
		//Clicking Private Object Link and verifying its landing page
		//WebObjectUtil.clickAndVerifyElement(Catalog.getNav_CatalogPrivateLink(), Catalog.getNav_CatalogPrivatePDFImg());
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateLink());
		WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivatePDFImg());
	}
	
	/*==============================================================
	Method Name 	: expandCatalogPrivateTable
	Description		: Expanding Private Table
	Author 			: Vivek Kumar
	Creation Date 	: 04/22/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void expandCatalogPrivateTable()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		int iRowCnt;
		String sName;
		sName=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.EDIT.NAME");
		sName = sName +"_"+FrameworkUtil.sTimeStamp;
		
		
		
		//iRowCnt=WebTableUtil.getRowCount(Catalog.getNav_CatalogDropDown());
		iRowCnt=WebTableUtil.getRowCount(Catalog.getNav_CatalogPrivateWebTable());
		//WebTableUtil.printEachCellText(Catalog.getNav_CatalogPrivateWebTable());
		if(iRowCnt>0){
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateFirstExpander());
			}
		else
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Issue with Private Object WebTable", "fail", "Items not found under PrivateObjects");
		}
	}
	
	/*==============================================================
	Method Name 	: settingNameandDescEdit
	Description		: setting Name and Desc under Edit for Private object
	Author 			: Vivek Kumar
	Creation Date 	: 04/22/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void settingNameandDescEdit()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		String sName,sDescription,sExpUserFeedBackMsg,sActUserFeedBackMsg;
		sName=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.EDIT.NAME");
		sExpUserFeedBackMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.EDIT.SUCCESS.MESSAGE");
		sName = sName +"_"+FrameworkUtil.sTimeStamp;
		sDescription=sName + "_Description";
		sExpUserFeedBackMsg = sExpUserFeedBackMsg + " " + sName;
		WebObjectUtil.clickAndVerifyElement(Catalog.getNav_CatalogPrivateWebTableEdit(), Catalog.getNav_CatalogName());
		WebObjectUtil.SetValueEdit(Catalog.getNav_CatalogName(), sName);
		WebObjectUtil.SetValueEdit(Catalog.getNav_CatalogPrivateEditDesc(), sDescription);
		//Clik on Save
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateEditSave());
		if(WebObjectUtil.isElementPresent(Catalog.getNav_NewCatalogPopUpBody()))
		{
			WebObjectUtil.clickElement(Catalog.getNav_NewCatalogPopUpOKBtn());
		}
		else
		{
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPopUpOKBtn());
		}
		
		
		//WebObjectUtil.waitForElementPresent(Catalog.getNav_CatalogUserFeedBack());
		WebObjectUtil.explicitWait(15);
		
		sActUserFeedBackMsg=Catalog.getNav_CatalogUserFeedBack().getText();
		boolean bUserFeedbackStatus = sActUserFeedBackMsg.contains(sExpUserFeedBackMsg);
		FrameworkUtil.updateCustomResultBasedOnStatus(bUserFeedbackStatus, sActUserFeedBackMsg);
				
	}
	/*==============================================================
	Method Name 	: valWindSteamCopyFunctioality
	Description		: Validating Copy Functionality of WindStream Objects
	Author 			: Vivek Kumar
	Creation Date 	: 04/22/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void valWindSteamCopyFunctionality()
	{
		String sName,sActUserFeedBackMsg,sExpUserFeedBackMsg,sDestination;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		sName=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.EDIT.NAME");
		sName = sName +"_"+ FrameworkUtil.sTimeStamp;
		sExpUserFeedBackMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.COPY.SUCCESS.MESSAGE");
		sDestination=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.WINDSTREAM.COPY.DESTINATION");
		sDestination=sDestination+"_"+FrameworkUtil.sTimeStamp;
		WebObjectUtil.clickElement(Catalog.getNav_CatalogWindStreamLink());
		//Expanding the very first item
		WebObjectUtil.clickElement(Catalog.getNav_CatalogWindStreamFirstExpander());
		WebObjectUtil.clickElement(Catalog.getNav_CatalogWindStreamCopyBtn());
		//Setting up New Name
		WebObjectUtil.SetValueEdit(Catalog.getNav_CatalogName(), sName);
		WebObjectUtil.clickElement(Catalog.getNav_CatalogWindStreamCopyDestDropDownArrow());
		
		WebObjectUtil.explicitWait(1);
		WebObjectUtil.selectCustomWebList(Catalog.getNav_CatalogDropDown(), 1);
		//WebObjectUtil.selectCustomWebList(Catalog.getNav_CatalogDropDown(), sDestination);
		WebObjectUtil.clickElement(Catalog.getNav_CatalogWindStreamCopyDialogCopyBtn());
		
		if(WebObjectUtil.isElementPresent(Catalog.getNav_NewCatalogPopUpBody()))
		{
			WebObjectUtil.clickElement(Catalog.getNav_NewCatalogPopUpOKBtn());
		}
		else
		{
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPopUpOKBtn());
		}
	
		WebObjectUtil.explicitWait(10);
		sActUserFeedBackMsg=Catalog.getNav_CatalogUserFeedBack().getText();
		boolean bUserFeedbackStatus = sActUserFeedBackMsg.contains(sExpUserFeedBackMsg);
		FrameworkUtil.updateCustomResultBasedOnStatus(bUserFeedbackStatus, sActUserFeedBackMsg);
		//Logging out from Navigator application
		LoginTestCase.nav_Logout();
	}
	
	
	/*==============================================================
	Method Name 	: valWindStreamDeployFunctionality
	Description		: Validating Deploy Functionality of WindStream Objects
	Author 			: Vivek Kumar
	Creation Date 	: 04/23/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void valWindStreamDeployFunctionality()
	{
		String sName,sActUserFeedBackMsg,sExpUserFeedBackMsg,sStorageProfile;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		sName=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.EDIT.NAME");
		sName = sName +"_"+ FrameworkUtil.sTimeStamp;
		sExpUserFeedBackMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.DEPLOY.SUCCESS.MESSAGE");
		sStorageProfile=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.WINDSTREAM.DEPLOY.STORAGEPROFILE");
		
		WebObjectUtil.clickElement(Catalog.getNav_CatalogWindStreamLink());
		//Expanding the very first item
		WebObjectUtil.clickElement(Catalog.getNav_CatalogWindStreamFirstExpander());
		WebObjectUtil.clickElement(Catalog.getNav_CatalogWindStreamDeployBtn());
		//Setting up New Name
		WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogWindStreamDeployNameEdit());
		WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogWindStreamDeployStorageProfileDropDownArrow());
		
		WebObjectUtil.SetValueEdit(Catalog.getNav_CatalogWindStreamDeployNameEdit(), sName);
		WebObjectUtil.clickElement(Catalog.getNav_CatalogWindStreamDeployStorageProfileDropDownArrow());
		
		WebObjectUtil.explicitWait(1);
		WebObjectUtil.selectCustomWebList(Catalog.getNav_CatalogDeployDropDown(), 1);
		//WebObjectUtil.selectCustomWebList(Catalog.getNav_CatalogDeployDropDown(), sStorageProfile);
		WebObjectUtil.clickElement(Catalog.getNav_CatalogWindStreamDeployDialogDeployBtn());
		if(WebObjectUtil.isElementPresent(Catalog.getNav_NewCatalogPopUpBody()))
		{
			WebObjectUtil.verifyElementPresent(Catalog.getNav_NewCatalogPopUpCancelBtn());
			WebObjectUtil.verifyElementPresent(Catalog.getNav_NewCatalogPopUpOKBtn());
			WebObjectUtil.clickElement(Catalog.getNav_NewCatalogPopUpOKBtn());
			
		}
		else
		{
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPopUpOKBtn());
			
		}
		
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPopUpOKBtn());
		WebObjectUtil.explicitWait(5);
		sActUserFeedBackMsg=Catalog.getNav_CatalogUserFeedBack().getText();
		boolean bUserFeedbackStatus = sActUserFeedBackMsg.contains(sExpUserFeedBackMsg);
		FrameworkUtil.updateCustomResultBasedOnStatus(bUserFeedbackStatus, sActUserFeedBackMsg);
		//Logging out from Navigator application
		LoginTestCase.nav_Logout();
		
	}
	
	
	/*==============================================================
	Method Name 	: valAddCatalogFunctionality
	Description		: Validating Add Catalog Functionality of Private Objects
	Author 			: Vivek Kumar
	Creation Date 	: 04/23/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void valPrivateAddCatalogFunctionality(String sUserName)
	{
		String sName,sDescription,sActUserFeedBackMsg,sExpUserFeedBackMsg;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		sName=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.EDIT.NAME");
		sExpUserFeedBackMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.PRIVATE.ADDCATALOG.SUCCESS.MESSAGE");
		sName = sName +"_"+sUserName+ "_"+FrameworkUtil.sTimeStamp ;
		sDescription=sName + "_Description";
		//Clicking on Private Object Link
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateLink());
		//Clicking ManageCatalog
		WebObjectUtil.clickAndVerifyElement(Catalog.getNav_CatalogPrivateManageCatalogBtn(), Catalog.getNav_CatalogPrivateAddCatalogLink());
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateAddCatalogLink());
		WebObjectUtil.SetValueEdit(Catalog.getNav_CatalogPrivateAddCatalogNameEdt(), sName);
		WebObjectUtil.SetValueEdit(Catalog.getNav_CatalogPrivateAddCatalogDescEdt(), sDescription);
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateAddCatalogOKBtn());
		if(WebObjectUtil.isElementPresent(Catalog.getNav_NewCatalogPopUpBody()))
		{
			WebObjectUtil.clickElement(Catalog.getNav_NewCatalogPopUpOKBtn());
		}
		else
		{
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPopUpOKBtn());
		}
		
		WebObjectUtil.explicitWait(10);
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPopUpOKBtn());
		WebObjectUtil.explicitWait(10);
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateAddCatalogCloseBtn());
		sActUserFeedBackMsg=Catalog.getNav_CatalogUserFeedBack().getText().trim();
		boolean bUserFeedbackStatus = sActUserFeedBackMsg.contains(sExpUserFeedBackMsg.trim());
		FrameworkUtil.updateCustomResultBasedOnStatus(bUserFeedbackStatus, sActUserFeedBackMsg);
		//Logging out from Navigator application
		LoginTestCase.nav_Logout();
	}
	
	
	/*==============================================================
	Method Name 	: valPrivateAddCatalogEditFunctionality
	Description		: Validating Add Catalog Edit Functionality of Private Objects
	Author 			: Vivek Kumar
	Creation Date 	: 04/23/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void valPrivateAddCatalogEditFunctionality(String sUserName)
	{
		String sName,sDescription,sActUserFeedBackMsg,sExpUserFeedBackMsg;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		sName=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.EDIT.NAME");
		sExpUserFeedBackMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.PRIVATE.ADDCATALOG.EDIT.SUCCESS.MESSAGE");
		sName = sName  +"_"+ sUserName +"_"+FrameworkUtil.sTimeStamp;
		sDescription=sName + "_Description";
		//Clicking on Private Object Link
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateLink());
		//Clicking ManageCatalog
		WebObjectUtil.clickAndVerifyElement(Catalog.getNav_CatalogPrivateManageCatalogBtn(), Catalog.getNav_CatalogPrivateAddCatalogLink());
		int iRowCnt=WebTableUtil.getRowCount(Catalog.getNav_CatalogPrivateManageCatalogWebTable());
		//System.out.println("----------------"+iRowCnt+"------------------");
		//WebTableUtil.printEachCellText(Catalog.getNav_CatalogPrivateWebTable());
		if(iRowCnt>0){
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateAddCatalogFirstExpander());
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateAddCatalogEditBtn());
			WebObjectUtil.SetValueEdit(Catalog.getNav_CatalogPrivateAddCatalogEditNameEdit(), sName);
			WebObjectUtil.SetValueEdit(Catalog.getNav_CatalogPrivateAddCatalogEditDescriptionEdit(), sDescription);
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateAddCatalogEditDialogOKBtn());
			
			if(WebObjectUtil.isElementPresent(Catalog.getNav_NewCatalogPopUpBody()))
			{
				WebObjectUtil.clickElement(Catalog.getNav_NewCatalogPopUpOKBtn());
			}
			else
			{
				WebObjectUtil.clickElement(Catalog.getNav_CatalogPopUpOKBtn());
			}
			
			WebObjectUtil.explicitWait(10);
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPopUpOKBtn());
			WebObjectUtil.explicitWait(10);
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateAddCatalogCloseBtn());
			sActUserFeedBackMsg=Catalog.getNav_CatalogUserFeedBack().getText();
			boolean bUserFeedbackStatus = sActUserFeedBackMsg.contains(sExpUserFeedBackMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bUserFeedbackStatus, sActUserFeedBackMsg);
			}
		else
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Issue with Private Object Manage Catalog  WebTable", "fail", "Items not found under PrivateObjects");
		}
		
		//Logging out from Navigator application
		LoginTestCase.nav_Logout();
	}
	/*==============================================================
	Method Name 	: valPrivateCopyFunctionality
	Description		: Validating Copy Functionality of Private Objects
	Author 			: Vivek Kumar
	Creation Date 	: 04/24/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	public static void valPrivateCopyFunctionality()
	{
		String sName,sActUserFeedBackMsg,sExpUserFeedBackMsg,sDestination;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		sName=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.EDIT.NAME");
		sName = sName +"_"+FrameworkUtil.sTimeStamp;
		sExpUserFeedBackMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.COPY.SUCCESS.MESSAGE");
		sDestination=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.PRIVATE.COPY.DESTINATION");
		
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateLink());
		//Expanding the very first item
		int iRowCnt=WebTableUtil.getRowCount(Catalog.getNav_CatalogPrivateWebTable());
		if(iRowCnt>0)
		{
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateFirstExpander());
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateCopyBtn());
			//Setting up New Name
			WebObjectUtil.SetValueEdit(Catalog.getNav_CatalogName(), sName);
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateCopyDropDownArrow());
			
			
			WebObjectUtil.explicitWait(1);
			//WebObjectUtil.selectCustomWebList(Catalog.getNav_CatalogDropDown(), sDestination);
			WebObjectUtil.selectCustomWebList(Catalog.getNav_CatalogDropDown(), 1);
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateCopyDialogCopyBtn());
			if(WebObjectUtil.isElementPresent(Catalog.getNav_NewCatalogPopUpBody()))
			{
				WebObjectUtil.clickElement(Catalog.getNav_NewCatalogPopUpOKBtn());
			}
			else
			{
				WebObjectUtil.clickElement(Catalog.getNav_CatalogPopUpOKBtn());
			}
			
			WebObjectUtil.explicitWait(10);
			sActUserFeedBackMsg=Catalog.getNav_CatalogUserFeedBack().getText();
			boolean bUserFeedbackStatus = sActUserFeedBackMsg.contains(sExpUserFeedBackMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bUserFeedbackStatus, sActUserFeedBackMsg);
		}
		else
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Issue with Private Object WebTable", "fail", "Items not found under PrivateObjects");
		}
		
		//Logging out from Navigator application
		LoginTestCase.nav_Logout();
	}
	
	
	/*==============================================================
	Method Name 	: valPrivateDeployFunctionality
	Description		: Validating Deploy Functionality of Private Objects
	Author 			: Vivek Kumar
	Creation Date 	: 04/23/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void valPrivateDeployFunctionality()
	{
		String sName,sActUserFeedBackMsg,sExpUserFeedBackMsg,sStorageProfile;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		sName=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.EDIT.NAME");
		sName = sName +"_"+ FrameworkUtil.sTimeStamp;
		sExpUserFeedBackMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.DEPLOY.SUCCESS.MESSAGE");
		sStorageProfile=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.PRIVATE.DEPLOY.STORAGEPROFILE");
		
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateLink());
		//Expanding the very first item
		int iRowCnt=WebTableUtil.getRowCount(Catalog.getNav_CatalogPrivateWebTable());
		if(iRowCnt>0)
		{
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateFirstExpander());
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateDeployBtn());
			//Setting up New Name
			WebObjectUtil.SetValueEdit(Catalog.getNav_CatalogPrivateDeployNameEdit(), sName);
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateDeployDropDownArrow());
			
			WebObjectUtil.explicitWait(1);
			//WebObjectUtil.selectCustomWebList(Catalog.getNav_CatalogDeployDropDown(), sStorageProfile);
			WebObjectUtil.selectCustomWebList(Catalog.getNav_CatalogDeployDropDown(), 1);
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateDeployDialogDeployBtn());
			if(WebObjectUtil.isElementPresent(Catalog.getNav_NewCatalogPopUpBody()))
			{
				WebObjectUtil.clickElement(Catalog.getNav_NewCatalogPopUpOKBtn());
			}
			else
			{
				WebObjectUtil.clickElement(Catalog.getNav_CatalogPopUpOKBtn());
			}
			
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPopUpOKBtn());
			WebObjectUtil.explicitWait(10);
			sActUserFeedBackMsg=Catalog.getNav_CatalogUserFeedBack().getText();
			boolean bUserFeedbackStatus = sActUserFeedBackMsg.contains(sExpUserFeedBackMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bUserFeedbackStatus, sActUserFeedBackMsg);
		}
		else
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Issue with Private Object WebTable", "fail", "Items not found under PrivateObjects");
		}
		
		
		//Logging out from Navigator application
		LoginTestCase.nav_Logout();
	}
	/*==============================================================
	Method Name 	: valPrivateMoveFunctionality
	Description		: Validating  Private Objects Move Functionality
	Author 			: Vivek Kumar
	Creation Date 	: 04/23/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void valPrivateMoveFunctionality()
	{
		String sName,sActUserFeedBackMsg,sExpUserFeedBackMsg,sDestination;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		sName=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.EDIT.NAME");
		sName = sName +"_"+FrameworkUtil.sTimeStamp;
		sExpUserFeedBackMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.MOVE.SUCCESS.MESSAGE");
		sDestination=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.PRIVATE.MOVE.DESTINATION");
		
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateLink());
		int iRowCnt=WebTableUtil.getRowCount(Catalog.getNav_CatalogPrivateWebTable());
		if(iRowCnt>0)
		{
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateFirstExpander());
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateMoveBtn());
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateMoveDestDropDownArrow());
			WebObjectUtil.explicitWait(1);
			//WebObjectUtil.selectCustomWebList(Catalog.getNav_CatalogDropDown(), sDestination);
			WebObjectUtil.selectCustomWebList(Catalog.getNav_CatalogDropDown(), 1);
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateMoveDialogMoveBtn());
			if(WebObjectUtil.isElementPresent(Catalog.getNav_NewCatalogPopUpBody()))
			{
				WebObjectUtil.clickElement(Catalog.getNav_NewCatalogPopUpOKBtn());
			}
			else
			{
				WebObjectUtil.clickElement(Catalog.getNav_CatalogPopUpOKBtn());
			}
		
			WebObjectUtil.explicitWait(10);
			sActUserFeedBackMsg=Catalog.getNav_CatalogUserFeedBack().getText();
			boolean bUserFeedbackStatus = sActUserFeedBackMsg.contains(sExpUserFeedBackMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bUserFeedbackStatus, sActUserFeedBackMsg);
		}
		else
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Issue with Private Object WebTable", "fail", "Items not found under PrivateObjects");
		}
		//Logging out from Navigator application
		LoginTestCase.nav_Logout();
		
	}
	
	/*==============================================================
	Method Name 	: navPrivateObjectManageCatalog
	Description		: Validate that Manage Btn is there for each User under Private Object
	Author 			: Vivek Kumar
	Creation Date 	: 04/27/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navPrivateObjectManageCatalog(String sUserName)
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		int iRows;
		
		//Clicking on Private Objects
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateLink());
		boolean bManageBtnStatus=WebObjectUtil.isElementPresent(Catalog.getNav_CatalogPrivateManageCatalogBtn());
		FrameworkUtil.updateCustomResultBasedOnStatus(bManageBtnStatus, sUserName + " able to see Manage Catalog");
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateManageCatalogBtn());
		WebObjectUtil.explicitWait(2);
		iRows=WebTableUtil.getRowCount(Catalog.getNav_CatalogPrivateManageCatalogWebTable());
		if(iRows>0)
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , sUserName + " can see WebTable", "pass", "Catalog List");
		}
		else
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , sUserName + " can not see WebTable", "fail", "Catalog List");
		}
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateAddCatalogCloseBtn());
		//Logging out from Navigator application
		LoginTestCase.nav_Logout();
	}
	
	
	/*==============================================================
	Method Name 	: navPrivateObjectDeleteFunctionality
	Description		: Validate the Delete Functionality for Private Objects
	Author 			: Vivek Kumar
	Creation Date 	: 04/28/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navPrivateObjectDeleteFunctionality()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		int iRows;
		String sExpDeleteConfirmMsg,sVMName,sActDeleteConfirmMsg;
		String sExpDeleteSuccessMsg,sActDeleteSuccessMsg;
		
		sExpDeleteConfirmMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.PRIVATE.DELETE.CONFIRM.MESSAGE");
		sExpDeleteSuccessMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.PRIVATE.DELETE.SUCCESS.MESSAGE");
		//clicking the Private Objects Tab
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateLink());
		//Expanding the first item
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateFirstExpander());
		
		sVMName=Catalog.getNav_CatalogPrivateFirstVMName().getText();
		sExpDeleteConfirmMsg=sExpDeleteConfirmMsg + " " + sVMName;
		
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateDeleteBtn());
		//Verifying OK and Delete Button
		WebObjectUtil.verifyElementPresent(Catalog.getNav_NewCatalogPopUpOKBtn());
		WebObjectUtil.verifyElementPresent(Catalog.getNav_NewCatalogPopUpCancelBtn());
		
		sActDeleteConfirmMsg=Catalog.getNav_NewCatalogPopUpMessage().getText();
		//comparing the expected message and actual message
		boolean bMessage=WebObjectUtil.compareString(sActDeleteConfirmMsg, sExpDeleteConfirmMsg, true);
		FrameworkUtil.updateCustomResultBasedOnStatus(bMessage, sActDeleteConfirmMsg);
		//Clicking on confirm OK btn
		WebObjectUtil.clickElement(Catalog.getNav_NewCatalogPopUpOKBtn());
		
		
		WebObjectUtil.explicitWait(20);
		//Need to validate User FeedBackMessage
		sActDeleteSuccessMsg=Catalog.getNav_CatalogUserFeedBack().getText();
		sExpDeleteSuccessMsg=sExpDeleteSuccessMsg + " " + sVMName;
		//boolean bDeleteMsg=WebObjectUtil.compareString(sActDeleteSuccessMsg,sExpDeleteSuccessMsg , true);
		boolean bDeleteMsg=sActDeleteSuccessMsg.contains(sExpDeleteSuccessMsg);
		FrameworkUtil.updateCustomResultBasedOnStatus(bDeleteMsg, sActDeleteSuccessMsg);
		//Logging out from Navigator application
		LoginTestCase.nav_Logout();
	
	}
	
	
	/*==============================================================
	Method Name 	: navPrivateObjectManageCatalogDeleteFunctionality
	Description		: Validate the Delete Functionality for Private Objects's Manage Catalog
	Author 			: Vivek Kumar
	Creation Date 	: 04/29/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navPrivateObjectManageCatalogDeleteFunctionality()
	{
		
		int iRowCnt,i,iRowIndex=0,iISO,iTemplate;
		WebElement wRowExpander,wDeleteBtn;
		String sActUserFeedBackMsg,sExpUserFeedBackMsg;
		List<WebElement> wPvtObjtTable,wManageCatalogRow;
		sExpUserFeedBackMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.PRIVATE.MANAGECATALOG.DELETE.SUCCESS.MESSAGE");
		//Clicking Private Object tab
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateLink());
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateManageCatalogBtn());
	//// this script is updated as part of EXTJS5 on 01/04/2016 by QAA04
		wManageCatalogRow=CustomWebElementUtil.loadCustomElement(Catalog.getNav_CatalogPrivateManageCatalogWebTable(), "table");
		iRowCnt=CustomWebElementUtil.iRowCount;
		
		//iRowCnt=WebTableUtil.getRowCount(Catalog.getNav_CatalogPrivateManageCatalogWebTable());
		
		//WebTableUtil.printEachCellText(Catalog.getNav_CatalogPrivateManageCatalogWebTable());
		for(i=1;i<=iRowCnt;i++)
		{
			iRowIndex=iRowIndex+1;
			 //// this script is updated as part of EXTJS5 on 01/04/2016 by QAA04
			wPvtObjtTable = CustomWebElementUtil.loadCustomElement(Catalog.getNav_CatalogPrivateManageCatalogWebTable(), "table");
			iISO=Integer.parseInt(CustomWebElementUtil.getCellData( i, 3));
			wPvtObjtTable = CustomWebElementUtil.loadCustomElement(Catalog.getNav_CatalogPrivateManageCatalogWebTable(), "table");
			iTemplate=Integer.parseInt(CustomWebElementUtil.getCellData( i, 4));
			
			
			//	int iISO=Integer.parseInt(WebTableUtil.getCellData(Catalog.getNav_CatalogPrivateManageCatalogWebTable(), i, 4));
			//int iTemplate=Integer.parseInt(WebTableUtil.getCellData(Catalog.getNav_CatalogPrivateManageCatalogWebTable(), i, 5));
			
			if(iISO==0 && iTemplate==0)
			{
				 //// this object is updated as part of EXTJS5 on 01/04/2016 by QAA04
				wRowExpander=WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "EVDC.CATALOG.PRIVATEOBJECT.MANAGECATALOG.TABLE.EXPANDER", "PARAMETER_ROWNUMBER", iRowIndex+"");
				//wRowExpander=WebObjectUtil.GetWebElement("xpath", "//div[10]//tr["+ iRowIndex +"]//tr[1]/td[1]//div[@class='x-grid-row-expander']", "Catalog List");
				WebObjectUtil.clickElement(wRowExpander);
				 //// this object is updated as part of EXTJS5 on 01/04/2016 by QAA04
				wDeleteBtn=WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "EVDC.CATALOG.PRIVATEOBJECT.MANAGECATALOG.TABLE.EXPANDER.DELETE.BUTTON", "PARAMETER_ROWNUMBER", iRowIndex+"");
				//wDeleteBtn=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+ iRowIndex +"]//a[contains(@id,'delPvtCatalog-urn')]", "Delete Button");
				WebObjectUtil.clickElement(wDeleteBtn);
				
				
				
				if(WebObjectUtil.isElementPresent(Catalog.getNav_NewCatalogPopUpBody()))
				{
					WebObjectUtil.clickElement(Catalog.getNav_NewCatalogPopUpOKBtn());
				}
				else
				{
					WebObjectUtil.clickElement(Catalog.getNav_CatalogPopUpOKBtn());
				}
			
				WebObjectUtil.explicitWait(10);
				WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateAddCatalogCloseBtn());
				
				sActUserFeedBackMsg=Catalog.getNav_CatalogUserFeedBack().getText();
				boolean bUserFeedbackStatus = sExpUserFeedBackMsg.contains(sActUserFeedBackMsg);
				FrameworkUtil.updateCustomResultBasedOnStatus(bUserFeedbackStatus, sActUserFeedBackMsg);
				break;
			}
		}
		//WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateAddCatalogCloseBtn());
		//Logging out from Navigator application
		LoginTestCase.nav_Logout();
	}
	
	
	
	/*==============================================================
	Method Name 	: valWindSteamCopyInDepthFunctioality
	Description		: Validating Copy Functionality in depth of WindStream Objects
	Author 			: Vivek Kumar
	Creation Date 	: 05/08/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void valWindStreamCopyPageAllObjects()
	{
		String sName,sActUserFeedBackMsg,sExpUserFeedBackMsg,sDestination;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		sName=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.EDIT.NAME");
		sName = sName +"_"+FrameworkUtil.sTimeStamp;
		
		sExpUserFeedBackMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.COPY.SUCCESS.MESSAGE");
		//sDestination=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.WINDSTREAM.COPY.DESTINATION");
		
		WebObjectUtil.clickElement(Catalog.getNav_CatalogWindStreamLink());
		//Expanding the very first item
		WebObjectUtil.clickElement(Catalog.getNav_CatalogWindStreamFirstExpander());
		WebObjectUtil.clickElement(Catalog.getNav_CatalogWindStreamCopyBtn());
		//Verifying and Setting up New Name
		WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogName());
		WebObjectUtil.SetValueEdit(Catalog.getNav_CatalogName(), sName);
		//Verifying and Selecting from Dropdown
		WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogWindStreamCopyDestDropDownArrow());
		WebObjectUtil.clickElement(Catalog.getNav_CatalogWindStreamCopyDestDropDownArrow());
		WebObjectUtil.explicitWait(1);
		WebObjectUtil.selectCustomWebList(Catalog.getNav_CatalogDropDown(), 1);
		//WebObjectUtil.selectCustomWebList(Catalog.getNav_CatalogDropDown(), sDestination);
		
		//Verifying Copy and Cancel Btn
		WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogWindStreamCopyDialogCopyBtn());
		WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogWindStreamCopyDialogCancelBtn());
		
		WebObjectUtil.clickElement(Catalog.getNav_CatalogWindStreamCopyDialogCopyBtn());
		
		
		String sExpPopUpMsg,sActPopUpMsg;
		sExpPopUpMsg="This template "+sName+" will be copied";
		if(WebObjectUtil.isElementPresent(Catalog.getNav_NewCatalogPopUpBody()))
		{
			//Verifying OK and Cancel Btn of POPUp
			WebObjectUtil.verifyElementPresent(Catalog.getNav_NewCatalogPopUpOKBtn());
			WebObjectUtil.verifyElementPresent(Catalog.getNav_NewCatalogPopUpCancelBtn());
			sActPopUpMsg=Catalog.getNav_NewCatalogPopUpMessage().getText();
			System.out.println(sExpPopUpMsg + '\n' +sActPopUpMsg );
			boolean bPopUpMessage=WebObjectUtil.compareString(sActPopUpMsg, sExpPopUpMsg, false);
			FrameworkUtil.updateCustomResultBasedOnStatus(bPopUpMessage, sActPopUpMsg);
			WebObjectUtil.clickElement(Catalog.getNav_NewCatalogPopUpOKBtn());
		}
		else
		{
			//Verifying OK and Cancel Btn of POPUp
			WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPopUpOKBtn());
			WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPopUpCancelBtn());
			sActPopUpMsg=Catalog.getNav_CatalogPopUpMessage().getText();
			boolean bPopUpMessage=WebObjectUtil.compareString(sActPopUpMsg, sExpPopUpMsg, false);
			FrameworkUtil.updateCustomResultBasedOnStatus(bPopUpMessage, sActPopUpMsg);
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPopUpOKBtn());
		}
		
		
		WebObjectUtil.explicitWait(10);
		sActUserFeedBackMsg=Catalog.getNav_CatalogUserFeedBack().getText();
		boolean bUserFeedbackStatus = sActUserFeedBackMsg.contains(sExpUserFeedBackMsg);
		FrameworkUtil.updateCustomResultBasedOnStatus(bUserFeedbackStatus, sActUserFeedBackMsg);
		//Logging out from Navigator application
		LoginTestCase.nav_Logout();
	}
	
	/*==============================================================
	Method Name 	: valPrivateCopyPageAllObjects
	Description		: Validating Copy Functionality in depth of Private Objects
	Author 			: Vivek Kumar
	Creation Date 	: 04/24/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	public static void valPrivateCopyPageAllObjects()
	{
		String sName,sActUserFeedBackMsg,sExpUserFeedBackMsg,sDestination;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		sName=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.EDIT.NAME");
		sName = sName +"_"+FrameworkUtil.sTimeStamp;
		sExpUserFeedBackMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.COPY.SUCCESS.MESSAGE");
		//sDestination=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.PRIVATE.COPY.DESTINATION");
		
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateLink());
		//Expanding the very first item
		int iRowCnt=WebTableUtil.getRowCount(Catalog.getNav_CatalogPrivateWebTable());
		if(iRowCnt>0)
		{
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateFirstExpander());
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateCopyBtn());
			//Verifying and Setting up New Name
			WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogName());
			WebObjectUtil.SetValueEdit(Catalog.getNav_CatalogName(), sName);
			//Verifying and Selecting from DropDown
			WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateCopyDropDownArrow());
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateCopyDropDownArrow());
			WebObjectUtil.explicitWait(1);
			WebObjectUtil.selectCustomWebList(Catalog.getNav_CatalogDropDown(), 1);
			//WebObjectUtil.selectCustomWebList(Catalog.getNav_CatalogDropDown(), sDestination);
			//Verifying Copy, and Cancel Button
			WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateCopyDialogCopyBtn());
			WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateCopyDialogCancelBtn());
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateCopyDialogCopyBtn());
			String sExpPopUpMsg,sActPopUpMsg;
			sExpPopUpMsg="This template "+sName+" will be copied";
			if(WebObjectUtil.isElementPresent(Catalog.getNav_NewCatalogPopUpBody()))
			{
				sActPopUpMsg=Catalog.getNav_NewCatalogPopUpMessage().getText();
				System.out.println(sExpPopUpMsg + '\n' +sActPopUpMsg );
				boolean bPopUpMessage=WebObjectUtil.compareString(sActPopUpMsg, sExpPopUpMsg, false);
				FrameworkUtil.updateCustomResultBasedOnStatus(bPopUpMessage, sActPopUpMsg);
				WebObjectUtil.clickElement(Catalog.getNav_NewCatalogPopUpOKBtn());
			}
			else
			{
				
				sActPopUpMsg=Catalog.getNav_CatalogPopUpMessage().getText();
			boolean bPopUpMessage=	WebObjectUtil.compareString(sActPopUpMsg, sExpPopUpMsg, false);
				FrameworkUtil.updateCustomResultBasedOnStatus(bPopUpMessage, sActPopUpMsg);
				WebObjectUtil.clickElement(Catalog.getNav_CatalogPopUpOKBtn());
			}
			
			
			
						
			WebObjectUtil.explicitWait(10);
			sActUserFeedBackMsg=Catalog.getNav_CatalogUserFeedBack().getText();
			boolean bUserFeedbackStatus = sActUserFeedBackMsg.contains(sExpUserFeedBackMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bUserFeedbackStatus, sActUserFeedBackMsg);
		}
		else
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Issue with Private Object WebTable", "fail", "Items not found under PrivateObjects");
		}
		
		//Logging out from Navigator application
		LoginTestCase.nav_Logout();
	}
	
	/*==============================================================
	Method Name 	: navPrivateObjectCancelDeleteFunctionality
	Description		: Validate the Cancel Functionality for Private Objects
	Author 			: Vivek Kumar
	Creation Date 	: 05/27/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navPrivateObjectCancelDeleteFunctionality()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		int iRows;
		//clicking the Private Objects Tab
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateLink());
		//Expanding the first item
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateFirstExpander());
		
				
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateDeleteBtn());
		//Verifying Delete confirmation dialog
		if(WebObjectUtil.isElementPresent(Catalog.getNav_NewCatalogPopUpBody()))
		{
			WebObjectUtil.verifyElementPresent(Catalog.getNav_NewCatalogPopUpCancelBtn());
			WebObjectUtil.clickElement(Catalog.getNav_NewCatalogPopUpCancelBtn());
			WebObjectUtil.explicitWait(2);
			if(!(WebObjectUtil.isElementPresent(Catalog.getNav_NewCatalogPopUpBody())))
			{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Cancel Delete Catalog Confirmation popup", "pass", "user is able to cancel the Delete catalogs successfully.");
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Cancel Delete Catalog Confirmation popup", "fail", "user is not able to cancel the Delete catalogs successfully.");
			}
		}
		else
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Issue with Delete Confirmation", "fail", "Delete Confirmation POPUP not present");
		}
		
		
		//Logging out from Navigator application
		LoginTestCase.nav_Logout();
	
	}
	
	
	/*==============================================================
	Method Name 	: navPrivateObjectManageCatalogCancelDelete
	Description		: Validate the Cancel Delete Functionality for Private Objects's Manage Catalog
	Author 			: Vivek Kumar
	Creation Date 	: 04/29/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navPrivateObjectManageCatalogCancelDelete()
	{
		
		int iRowCnt,i,iRowIndex=0;
		WebElement wRowExpander,wDeleteBtn;
		String sActUserFeedBackMsg,sExpUserFeedBackMsg;
		sExpUserFeedBackMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.PRIVATE.MANAGECATALOG.DELETE.SUCCESS.MESSAGE");
		//Clicking Private Object tab
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateLink());
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateManageCatalogBtn());
		iRowCnt=WebTableUtil.getRowCount(Catalog.getNav_CatalogPrivateManageCatalogWebTable());
		
		//WebTableUtil.printEachCellText(Catalog.getNav_CatalogPrivateManageCatalogWebTable());
		for(i=1;i<=iRowCnt;i=i+3)
		{
			iRowIndex=iRowIndex+1;
			int iISO=Integer.parseInt(WebTableUtil.getCellData(Catalog.getNav_CatalogPrivateManageCatalogWebTable(), i, 4));
			int iTemplate=Integer.parseInt(WebTableUtil.getCellData(Catalog.getNav_CatalogPrivateManageCatalogWebTable(), i, 5));
			
			if(iISO==0 && iTemplate==0)
			{
				wRowExpander=WebObjectUtil.GetWebElement("xpath", "//div[10]//tr["+ iRowIndex +"]//tr[1]/td[1]//div[@class='x-grid-row-expander']", "Catalog List");
				WebObjectUtil.clickElement(wRowExpander);
				
				wDeleteBtn=WebObjectUtil.GetWebElement("xpath", "//table/tbody/tr["+ iRowIndex +"]//a[contains(@id,'delPvtCatalog-urn')]", "Delete Button");
				WebObjectUtil.clickElement(wDeleteBtn);
				if(WebObjectUtil.isElementPresent(Catalog.getNav_NewCatalogPopUpBody()))
				{
					WebObjectUtil.verifyElementPresent(Catalog.getNav_NewCatalogPopUpCancelBtn());
					WebObjectUtil.clickElement(Catalog.getNav_NewCatalogPopUpCancelBtn());
					WebObjectUtil.explicitWait(2);
					if(!(WebObjectUtil.isElementPresent(Catalog.getNav_NewCatalogPopUpBody())))
					{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Cancel Delete Catalog Confirmation popup", "pass", "user is able to cancel the Delete catalogs successfully.");
					}
					else
					{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Cancel Delete Catalog Confirmation popup", "fail", "user is not able to cancel the Delete catalogs successfully.");
					}
					
				}
				else
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Issue with Delete Confirmation", "fail", "Delete Confirmation POPUP not present");
				}
				
			
				WebObjectUtil.explicitWait(2);
				WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateAddCatalogCloseBtn());
				
				
				//Logging out from Navigator application
				LoginTestCase.nav_Logout();
				break;
			}
			
		}
		
	}
	
	
	
///////////////////////?????????????????????Sukur???????????????????????????//////////////////////
//########################################################################
	
	/*==============================================================
	TestScript 		: VerifyManageCatalogListDisplayedForPrivateObjects
	Manual TestCase	: Catalogs -> Private Objects -> Manage Catalogs
	Description		: Verify Manage Catalog list displayed for Private Object.
	Author 			: Sukur Babu. B
	Creation Date 	: 05/05/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=1)
	public void VerifyManageCatalogListDisplayedForPrivateObjects(){
		String sUserName;
		String sPassword;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, CatalogTestCase.Catalog);
		FrameworkUtil.sTestCaseName = "Catalog-VerifyManageCatalogListDisplayedForPrivateObjects";
		FrameworkUtil.sManualTestCaseName="Verify Manage Catalog list displayed for Private Object";
		//Update results with Manual test case name
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.USERID");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.PASSWORD");
		LoginTestCase.nav_Login(sUserName, sPassword);
		NavigateToPrivateManageCatalogList();
		WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateWebTable());
		LoginTestCase.nav_Logout();
	}
	/*==============================================================
	TestScript 		: VerifyManageCatalogListDisplayed
	Manual TestCase	: Catalogs -> Private Objects -> Manage Catalogs - > Verify Add Catalog link
	Description		: Verify Add Catalog Link displayed in Private Object Manage Catalog list.
	Author 			: Sukur Babu. B
	Creation Date 	: 05/05/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=2)
	public void VerifyAddCatalogLinkDisplayedInPrivateObjectManageList(){
		String sUserName;
		String sPassword;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, CatalogTestCase.Catalog);
		FrameworkUtil.sTestCaseName = "Catalog-VerifyAddCatalogLinkDisplayedInPrivateObjectManageList";
		FrameworkUtil.sManualTestCaseName="Verify Add Catalog Link displayed in Private Object Manage Catalog list";
		//Update results with Manual test case name
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.USERID");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.PASSWORD");
		LoginTestCase.nav_Login(sUserName, sPassword);
		NavigateToPrivateManageCatalogList();
		WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateAddCatalogLink());
		LoginTestCase.nav_Logout();
	}
	/*==============================================================
	TestScript 		: VerifyPrivateObjectManageCatalogListColumns
	Manual TestCase	: Catalogs -> Private Objects -> Verify Manage Catalogs list columns
	Description		: Verify Private Object Manage List columns
	Author 			: Sukur Babu. B
	Creation Date 	: 05/05/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=3)
	public void VerifyPrivateObjectManageCatalogListColumns(){
		String sUserName;
		String sPassword;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, CatalogTestCase.Catalog);
		FrameworkUtil.sTestCaseName = "Catalog-VerifyPrivateObjectManageCatalogListColumns";
		FrameworkUtil.sManualTestCaseName="Verify Private Object Manage List columns";
		//Update results with Manual test case name
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.USERID");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.PASSWORD");
		LoginTestCase.nav_Login(sUserName, sPassword);
		NavigateToPrivateManageCatalogList();
		WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateManageCatalogListNameColumn());
		WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateManageCatalogListNumberOfISOsColumn());
		WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateManageCatalogListNumberOfTemplatesColumn());
		WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateManageCatalogListTotalStorageColumn());
		WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateManageCatalogListDateCreatedColumn());
		WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateManageCatalogListDescriptionColumn());
		LoginTestCase.nav_Logout();
	}
	
	/*==============================================================
	TestScript 		: VerifyPrivateObjectManageCatalogListCatalogButtons
	Manual TestCase	: Catalogs -> Private Objects -> Manage Catalogs -> Check buttons under the catalog
	Description		: Verify buttons displayed under catalog from Manage Catalog list 
	Author 			: Sukur Babu. B
	Creation Date 	: 06/05/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=4)
	public void VerifyPrivateObjectManageCatalogListCatalogButtons(){
		//ValPvtObjMngCtlgLstCtlgBtns();
		String sUserName;
		String sPassword;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, CatalogTestCase.Catalog);
		FrameworkUtil.sTestCaseName = "Catalog-VerifyPrivateObjectManageCatalogListCatalogButtons";
		FrameworkUtil.sManualTestCaseName="Verify buttons displayed under catalog from Manage Catalog list";
		//Update results with Manual test case name
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.USERID");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.PASSWORD");
		LoginTestCase.nav_Login(sUserName, sPassword);
		NavigateToPrivateManageCatalogList();
		//Expand any catalog
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateAddCatalogFirstExpander());
		//Verify Edit button displayed
		WebObjectUtil.verifyElementPresent(Catalog.getNav_PrivateObjectDeleteInManageCatalogList());
		//Verify Delete button displayed
		WebObjectUtil.verifyElementPresent(Catalog.getNav_PrivateObjectEditInManageCatalogList());
		LoginTestCase.nav_Logout();
	}
	/*==============================================================
	TestScript 		: VerifyAddCatalogFldsAndBtns
	Manual TestCase	: Catalogs -> Private Objects -> Manage Catalogs-> Check Add Catalog page 
	Description		: Verify the overalay page is displayed with below fields:
						Name and Description fields
						Cancel and OK buttons 
	Author 			: Sukur Babu. B
	Creation Date 	: 06/05/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=5)
	public void VerifyAddCatalogFldsAndBtns(){
		//ValPvtObjMngCtlgLstCtlgBtns();
		String sUserName;
		String sPassword;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, CatalogTestCase.Catalog);
		FrameworkUtil.sTestCaseName = "Catalog-VerifyAddCatalogFldsAndBtns";
		FrameworkUtil.sManualTestCaseName="Verify fields and buttons displyed in Add Catalog Overlay page";
		//Update results with Manual test case name
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.USERID");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.PASSWORD");
		LoginTestCase.nav_Login(sUserName, sPassword);
		NavigateToAddCatalogOverlayPage();
		WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateAddCatalogNameEdt());
		WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateAddCatalogDescEdt());
		WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateAddCatalogOKBtn());
		WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateAddCatalogCancelBtn());
		LoginTestCase.nav_Logout();
	}
	/*==============================================================
	TestScript 		: valPrivateAddCatalogFunctionality
	Manual TestCase	: Catalogs -> Private Objects -> Manage Catalogs-> Add Catalog -> Add Catalog entries 
	Description		: Verify the Add Catalog page is displayed with Field and values info that
	 entered in the Add Catalog page. 
	Verify the OK and Cancel buttons are there. 
	Author 			: Sukur Babu. B
	Creation Date 	: 11/05/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=5)
	public static void valPrivateAddCatalogFunctionality()
	{
		String sName,sDescription,sActUserFeedBackMsg,sExpUserFeedBackMsg,sUserName,sPassword;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		FrameworkUtil.sTestCaseName = "Catalog-valPrivateAddCatalogFunctionality";
		FrameworkUtil.sManualTestCaseName="Verify the Add Catalog page is displayed with Field and values info that entered in the Add Catalog page and verify OK button displayed in Popup window";
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.USERID");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.PASSWORD");
		
		sName=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.EDIT.NAME");
		String sExpUserpopupMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.PRIVATE.ADDCATALOG.SUCCESS.POPUP.MESSAGE");
		sExpUserFeedBackMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.PRIVATE.ADDCATALOG.SUCCESS.MESSAGE");
		sName = sName +"Catalog"+"_"+FrameworkUtil.sTimeStamp;
		sDescription=sName + "_Description";
		LoginTestCase.nav_Login(sUserName, sPassword);
		NavigateToAddCatalogOverlayPage();
		WebObjectUtil.SetValueEdit(Catalog.getNav_CatalogPrivateAddCatalogNameEdt(), sName);
		WebObjectUtil.SetValueEdit(Catalog.getNav_CatalogPrivateAddCatalogDescEdt(), sDescription);
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateAddCatalogOKBtn());
		String sMessage=Catalog.getNav_PopupWindow().getText();
		if(sMessage.contains(sName) && sMessage.contains(sDescription) )
			FrameworkUtil.updateCustomResultBasedOnStatus(true,"Pop up window contains entered Catalog Name and description");
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false,"Pop up window not contains entered Catalog Name and description");
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPopUpOKBtn());
		WebObjectUtil.explicitWait(10);
		String sMessageSecond=Catalog.getNav_PopupWindow().getText();
		if(sMessage.contains(sExpUserpopupMsg) )
			FrameworkUtil.updateCustomResultBasedOnStatus(true,sExpUserpopupMsg);
		else
			FrameworkUtil.updateCustomResultBasedOnStatus(false,sExpUserpopupMsg);
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPopUpOKBtn());
		WebObjectUtil.explicitWait(10);
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateAddCatalogCloseBtn());
		sActUserFeedBackMsg=Catalog.getNav_CatalogUserFeedBack().getText();
		boolean bUserFeedbackStatus = sActUserFeedBackMsg.contains(sExpUserFeedBackMsg);
		FrameworkUtil.updateCustomResultBasedOnStatus(bUserFeedbackStatus, sActUserFeedBackMsg);
		//Logging out from Navigator application
		LoginTestCase.nav_Logout();
	}

	/*==============================================================
	TestScript 		: valPrivateAddCatalogCancelFunctionality
	Manual TestCase	: Catalogs -> Private Objects -> Manage Catalogs-> Check Add Catalog page ->Cancel
	Description		: Verify the Add Catalog page is displayed with Field and values info that
	 entered in the Add Catalog page. Verify the OK and Cancel buttons are there. 
	Author 			: Sukur Babu. B
	Creation Date 	: 11/05/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=6)
	public static void valPrivateAddCatalogCancelFunctionality()
	{
		String sUserName,sPassword;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		FrameworkUtil.sTestCaseName = "Catalog-valPrivateAddCatalogCancelFunctionality";
		FrameworkUtil.sManualTestCaseName="Validate Add Catalog Cacen button functionality";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.USERID");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.PASSWORD");
				
		LoginTestCase.nav_Login(sUserName, sPassword);
		NavigateToAddCatalogOverlayPage();
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateAddCatalogCancelBtn());
		//WebObjectUtil.verifyElementNOTPresent(Catalog.getNav_CatalogPrivateAddCatalogCancelBtn());
		LoginTestCase.nav_Logout();
	}
	/*==============================================================
	TestScript 		: VerifyManagePrivateObjectsPDFAndCSVIcons
	Manual TestCase	: Catalogs -> Private Objects -> Manage Catalogs -> Check CSV and PDF reports
	Description		: Verify PDF and CSV icons displayed in Manage catalog overlay page for Private objects 
	Author 			: Sukur Babu. B
	Creation Date 	: 12/05/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=7)
	public static void VerifyManagePrivateObjectsPDFAndCSVIcons()
	{
		String sUserName,sPassword;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		FrameworkUtil.sTestCaseName = "Catalog-VerifyManagePrivateObjectsPDFAndCSVIcons";
		FrameworkUtil.sManualTestCaseName="Verify PDF and CSV icons displayed in Manage catalog overlay page for Private objects";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.USERID");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.PASSWORD");		
		LoginTestCase.nav_Login(sUserName, sPassword);
		NavigateToPrivateCatalogList();
		WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogManagePrivatePDFImg());
		WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogManagePrivateCSVImg());
		LoginTestCase.nav_Logout();
	}
	/*==============================================================
	TestScript 		: ValidateCSVReportForManagePrivateObject
	Manual TestCase	: Catalogs -> Private Objects -> Manage Catalogs -> Check CSV report
	Description		: Validate CSV report displayed for Private Object
	Author 			: Sukur Babu. B
	Creation Date 	: 12/05/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=8)
	public static void ValidateCSVReportForManagePrivateObject()
	{
		String sUserName,sPassword;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		FrameworkUtil.sTestCaseName = "Catalog-ValidateCSVReportForManagePrivateObject";
		FrameworkUtil.sManualTestCaseName="Validate CSV report displayed in Manage catalog overlay page for Private objects";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.USERID");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.PASSWORD");		
		LoginTestCase.nav_Login(sUserName, sPassword);
		NavigateToPrivateManageCatalogList();
		WebObjectUtil.explicitWait(10);

		//WebObjectUtil.clickElement(Catalog.getNav_CatalogManagePrivateCSVImg());
		String sCSVLnkTxt=Catalog.getNav_CatalogPrivateCSVLink().getAttribute("href");
		if(sCSVLnkTxt.contains("format=csv"))
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "CSV link contains ", "pass", " format=csv");
		else
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "CSV link contains ", "fail", " format=csv");
		
		LoginTestCase.nav_Logout();
	}
	/*==============================================================
	TestScript 		: ValidatePDFReportForManagePrivateObject
	Manual TestCase	: Catalogs -> Private Objects -> Manage Catalogs -> Check PDF report
	Description		: Validate PDF report displayed for Private Object
	Author 			: Sukur Babu. B
	Creation Date 	: 12/05/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=9)
	public static void ValidatePDFReportForManagePrivateObject()
	{
		String sUserName,sPassword;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		FrameworkUtil.sTestCaseName = "Catalog-ValidatePDFReportForManagePrivateObject";
		FrameworkUtil.sManualTestCaseName="Verify PDF report displayed in Manage catalog overlay page for Private objects";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.USERID");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.PASSWORD");		
		LoginTestCase.nav_Login(sUserName, sPassword);
		NavigateToPrivateManageCatalogList();
		//WebObjectUtil.clickElement(Catalog.getNav_CatalogManagePrivatePDFImg());
		WebObjectUtil.explicitWait(10);
		String sPDFLnkTxt=Catalog.getNav_CatalogPrivatePDFLink().getAttribute("href");
		if(sPDFLnkTxt.contains("format=pdf"))
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "PDF link contains ", "pass", " format=pdf");
		else
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "PDF link contains ", "fail", " format=pdf");
		
		LoginTestCase.nav_Logout();
	}
	/*==============================================================
	TestScript 		: VeirfyPaginationControlPvtObjMngeCatalogOverLayPage
	Manual TestCase	: Catalogs -> Private Objects -> Manage Catalogs -> Check Pagination
	Description		: Verify pagination control displayed in Manage Catalog overlay page for Private objects
	Author 			: Sukur Babu. B
	Creation Date 	: 12/05/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=9)
	public static void VeirfyPaginationControlPvtObjMngeCatalogOverLayPage()
	{
		String sUserName,sPassword;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		FrameworkUtil.sTestCaseName = "Catalog-VeirfyPaginationControlPvtObjMngeCatalogOverLayPage";
		FrameworkUtil.sManualTestCaseName="Verify Pagination Control displayed in Manage catalog overlay page for Private objects";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.USERID");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.PASSWORD");		
		LoginTestCase.nav_Login(sUserName, sPassword);
		NavigateToPrivateManageCatalogList();
		int iRowCount=WebTableUtil.getRowCount(Catalog.getNav_CatalogPrivateManageCatalogWebTable());
		if(iRowCount<=10)
			if(Catalog.getNav_CatalogPrivateManageCatalogNextPaginiation().isEnabled())
				FrameworkUtil.updateCustomResultBasedOnStatus(false,"Pagination's Next button is enabled even items in the table is less than 10");
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(true,"Pagination's Next button is disabled as expected");

		LoginTestCase.nav_Logout();
	}
	
	/*==============================================================
	TestScript 		: VerifyPrivateObjectsPDFAndCSVIcons
	Manual TestCase	: Catalogs -> Private Objects -> Check CSV and PDF reports
	Description		: Verify PDF and CSV icons displayed in catalog page for Private objects 
	Author 			: Sukur Babu. B
	Creation Date 	: 13/05/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=10)
	public static void VerifyPrivateObjectsPDFAndCSVIcons()
	{
		String sUserName,sPassword;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		FrameworkUtil.sTestCaseName = "Catalog-VerifyPrivateObjectsPDFAndCSVIcons";
		FrameworkUtil.sManualTestCaseName="Verify PDF and CSV icons displayed in catalog list page for Private objects";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.USERID");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.PASSWORD");		
		LoginTestCase.nav_Login(sUserName, sPassword);
		NavigateToPrivateManageCatalogList();
		WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivatePDFImg());
		WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateCSVImg());
		LoginTestCase.nav_Logout();
	}
	/*==============================================================
	TestScript 		: ValidateCSVReportForPrivateObject
	Manual TestCase	: Catalogs -> Private Objects  -> Check CSV report
	Description		: Validate CSV report displayed for Private Object
	Author 			: Sukur Babu. B
	Creation Date 	: 13/05/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=11)
	public static void ValidateCSVReportForPrivateObject()
	{
		String sUserName,sPassword;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		FrameworkUtil.sTestCaseName = "Catalog-ValidateCSVReportForPrivateObject";
		FrameworkUtil.sManualTestCaseName="Validate CSV report displayed in catalog page for Private objects";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.USERID");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.PASSWORD");		
		LoginTestCase.nav_Login(sUserName, sPassword);
		NavigateToPrivateCatalogList();
		//WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateCSVImg());
		WebObjectUtil.explicitWait(10);
		String sCSVLnkTxt=Catalog.getNav_CatalogPrivateCSVLink().getAttribute("href");
		if(sCSVLnkTxt.contains("format=csv"))
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "CSV link contains ", "pass", " format=csv");
		else
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "CSV link contains ", "fail", " format=csv");
		
		LoginTestCase.nav_Logout();
	}
	/*==============================================================
	TestScript 		: ValidatePDFReportForPrivateObject
	Manual TestCase	: Catalogs -> Private Objects -> Check CSV and PDF reports
	Description		: Validate PDF report displayed for Private Object
	Author 			: Sukur Babu. B
	Creation Date 	: 13/05/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=12)
	public static void ValidatePDFReportForPrivateObject()
	{
		String sUserName,sPassword;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		FrameworkUtil.sTestCaseName = "Catalog-ValidatePDFReportForPrivateObject";
		FrameworkUtil.sManualTestCaseName="Verify PDF report displayed in catalog page for Private objects";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.USERID");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.PASSWORD");		
		LoginTestCase.nav_Login(sUserName, sPassword);
		NavigateToPrivateCatalogList();
		//WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivatePDFImg());
		String sPDFLnkTxt=Catalog.getNav_CatalogPrivatePDFLink().getAttribute("href");
		if(sPDFLnkTxt.contains("format=pdf"))
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "PDF link contains ", "pass", " format=pdf");
		else
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "PDF link contains ", "fail", " format=pdf");
		
		LoginTestCase.nav_Logout();
	}
	/*==============================================================
	TestScript 		: VerifyWSObjectsPDFAndCSVIcons
	Manual TestCase	: Catalogs -> Windstream Objects ->  Check CSV and PDF reports
	Description		: Verify PDF and CSV icons displayed in catalog page for WindStream objects 
	Author 			: Sukur Babu. B
	Creation Date 	: 13/05/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=10)
	public static void VerifyWSObjectsPDFAndCSVIcons()
	{
		String sUserName,sPassword;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		FrameworkUtil.sTestCaseName = "Catalog-VerifyWSObjectsPDFAndCSVIcons";
		FrameworkUtil.sManualTestCaseName="Verify PDF and CSV icons displayed in catalog list page for WindStream objects";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.USERID");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.PASSWORD");		
		LoginTestCase.nav_Login(sUserName, sPassword);
		NavigateToPrivateManageCatalogList();
		WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogWSPDFImg());
		WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogWSCSVImg());
		LoginTestCase.nav_Logout();
	}
	/*==============================================================
	TestScript 		: ValidateCSVReportForWSObject
	Manual TestCase	: Catalogs ->Windstream Objects -> Check CSV report
	Description		: Validate CSV report displayed for WindStream Object
	Author 			: Sukur Babu. B
	Creation Date 	: 13/05/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=11)
	public static void ValidateCSVReportForWSObject()
	{
		String sUserName,sPassword;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		FrameworkUtil.sTestCaseName = "Catalog-ValidateCSVReportForWSObject";
		FrameworkUtil.sManualTestCaseName="Validate CSV report displayed in catalog page for WindStream objects";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.USERID");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.PASSWORD");		
		LoginTestCase.nav_Login(sUserName, sPassword);
		NavigateToWSCatalogList();
		//WebObjectUtil.clickElement(Catalog.getNav_CatalogWSCSVImg());
		String sCSVLnkTxt=Catalog.getNav_CatalogWSCSVLink().getAttribute("href");
		if(sCSVLnkTxt.contains("format=csv"))
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "CSV link contains ", "pass", " format=csv");
		else
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "CSV link contains ", "fail", " format=csv");
		
		LoginTestCase.nav_Logout();
	}
	/*==============================================================
	TestScript 		: ValidatePDFReportForWSObject
	Manual TestCase	: Catalogs -> Private Objects -> Check CSV and PDF reports
	Description		: Validate PDF report displayed for WindStream Object
	Author 			: Sukur Babu. B
	Creation Date 	: 13/05/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=12)
	public static void ValidatePDFReportForWSObject()
	{
		String sUserName,sPassword;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		FrameworkUtil.sTestCaseName = "Catalog-ValidatePDFReportForWSObject";
		FrameworkUtil.sManualTestCaseName="Verify PDF report displayed in catalog page for WindStream objects";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.USERID");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.PASSWORD");		
		LoginTestCase.nav_Login(sUserName, sPassword);
		NavigateToWSCatalogList();
		//WebObjectUtil.clickElement(Catalog.getNav_CatalogWSPDFImg());
		String sPDFLnkTxt=Catalog.getNav_CatalogWSPDFLink().getAttribute("href");
		if(sPDFLnkTxt.contains("format=pdf"))
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "PDF link contains ", "pass", " format=pdf");
		else
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "PDF link contains ", "fail", " format=pdf");
		
		LoginTestCase.nav_Logout();
	}
	/*==============================================================
	Method Name 	: valCatalogPrivateDeployFunctionality
	Manual Test Case:
	Description		: Validating Deploy Functionality of Private Objects
	Author 			: Sukur Babu
	Creation Date 	: 13/05/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=13)
	public static void valCatalogPrivateDeployFunctionality()
	{
		String sName,sActUserFeedBackMsg,sExpUserFeedBackMsg,sStorageProfile,sExpUserPopupMsg,sActUserPopupMsg1,sActUserPopupMsg2;
		
		String sUserName,sPassword;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		sName=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.EDIT.NAME");
		sName = sName +"DeployName"+"_"+FrameworkUtil.sTimeStamp;
		sExpUserPopupMsg= "This template "+sName+"will be deployed";
		sExpUserFeedBackMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.DEPLOY.SUCCESS.MESSAGE");
		sStorageProfile=(String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.PRIVATE.DEPLOY.STORAGEPROFILE");
		FrameworkUtil.sTestCaseName = "Catalog-valCatalogPrivateDeployFunctionality";
		FrameworkUtil.sManualTestCaseName="Validate Deploy Functionality of Private Objects";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.USERID");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.PASSWORD");	
		
		LoginTestCase.nav_Login(sUserName, sPassword);
		NavigateToPrivateCatalogList();
		//Expanding the very first item
		int iRowCnt=WebTableUtil.getRowCount(Catalog.getNav_CatalogPrivateWebTable());
		if(iRowCnt>0)
		{
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateFirstExpander());
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateDeployBtn());
			//Verify Deploy Overlay page and fields displayed
			WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPvtDeployOverlayPage());
			
			WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateDeployNameEdit());
			WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateDeployDropDownArrow());
			WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateDeployDialogDeployBtn());
			WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPvtDeployOverlayPageCancelButton());
			//Setting up New Name
			WebObjectUtil.SetValueEdit(Catalog.getNav_CatalogPrivateDeployNameEdit(), sName);
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateDeployDropDownArrow());
			WebObjectUtil.explicitWait(1);
			WebObjectUtil.selectCustomWebList(Catalog.getNav_CatalogDeployDropDown(), 3);
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateDeployDialogDeployBtn());
			WebObjectUtil.waitForElementPresent(Catalog.getNav_NewCatalogPopUpOKBtn());
			sActUserPopupMsg1=Catalog.getNav_NewCatalogPopUpBody().getText();
			if(sActUserPopupMsg1.contains(sExpUserPopupMsg))
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Deploy Popup Sucessful Message", "pass", "Private object Deploy Sucess message matching with Expected");
			else
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Deploy Popup Sucessful Message", "fail", "Private object Deploy Sucess message is not matching with Expected");
			WebObjectUtil.verifyElementPresent(Catalog.getNav_NewCatalogPopUpOKBtn());
			WebObjectUtil.verifyElementPresent(Catalog.getNav_NewCatalogPopUpCancelBtn());
			WebObjectUtil.clickElement(Catalog.getNav_NewCatalogPopUpOKBtn());
			sActUserPopupMsg2=Catalog.getNav_PopupWindow().getText();
			if(sActUserPopupMsg2.contains(sExpUserFeedBackMsg))
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Deploy Popup Sucessful Message", "pass", "Private object Deploy Sucess message matching with Expected");
			else
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Deploy Popup Sucessful Message", "fail", "Private object Deploy Sucess message is not matching with Expected");
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPopUpOKBtn());
			WebObjectUtil.explicitWait(10);
			sActUserFeedBackMsg=Catalog.getNav_CatalogUserFeedBack().getText();
			boolean bUserFeedbackStatus = sActUserFeedBackMsg.contains(sExpUserFeedBackMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bUserFeedbackStatus, sActUserFeedBackMsg);
			
			//div[6]/div/ul[@class='x-list-plain']
		}
		
		
		else
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Issue with Private Object WebTable", "fail", "Items not found under PrivateObjects");
		}
		
		
		//Logging out from Navigator application
		LoginTestCase.nav_Logout();
	}
	/*==============================================================
	TestScript 		: VerifyPvtObjCatalogPage
	Manual TestCase	: Catalogs page -> Private Objects, Catalogs page -> Private Objects page, Catalogs page -> Private Objects page ->Expand Private object
	Description		: Verify Private Object Page is displayed
	Author 			: Sukur Babu. B
	Creation Date 	: 13/05/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=12)
	public static void VerifyPvtObjCatalogPage()
	{
		String sUserName,sPassword;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		FrameworkUtil.sTestCaseName = "Catalog-VerifyPvtObjCatalogPage";
		FrameworkUtil.sManualTestCaseName="Verify Private Object Page is displayed";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.USERID");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.PASSWORD");		
		LoginTestCase.nav_Login(sUserName, sPassword);
		NavigateToPrivateCatalogList();
		WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPvtUploadButton());
		WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateManageCatalogBtn());
		WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivatePDFImg());
		WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateCSVImg());
		int iRowCnt=WebTableUtil.getRowCount(Catalog.getNav_CatalogPrivateWebTable());
		if(iRowCnt>0)
		{
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateFirstExpander());
			WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateWebTableEdit());
			WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateDeleteBtn());
			WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateMoveBtn());
			WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateCopyBtn());
			WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateDeployBtn());
			WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPvtStorageDetailsLink());
			
			
			
		}
		LoginTestCase.nav_Logout();
	}
	
	/*==============================================================
	TestScript 		: VerifyAndValidatePvtObjCatalogMove
	Manual TestCase	: Catalogs -> Private Objects -> Move page overlay
	Description		: Verify and validate Move functionality for Private Object and it's fields
	Author 			: Sukur Babu. B
	Creation Date 	: 13/05/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=12)
	public static void VerifyAndValidatePvtObjCatalogMove()
	{
		String sUserName,sPassword,sExpectedMovePopMsg,sActualMovePopupMsg,sExpFeedBackMsg,sActFeedBackMsg;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		sExpFeedBackMsg="Moving in progress :Move catalog action started";
		FrameworkUtil.sTestCaseName = "Catalog-VerifyAndValidatePvtObjCatalogMove";
		FrameworkUtil.sManualTestCaseName="Verify Move Overlay page and it's fields and validate Move catalog functionality";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.USERID");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.PASSWORD");
		//sExpectedMovePopMsg=
		LoginTestCase.nav_Login(sUserName, sPassword);
		NavigateToPrivateCatalogList();
		int iRowCnt=WebTableUtil.getRowCount(Catalog.getNav_CatalogPrivateWebTable());
		if(iRowCnt>0)
		{
			String sImageName=WebTableUtil.getCellData(Catalog.getNav_CatalogPrivateWebTable(), 2, 2);
			String sCatalogName=WebTableUtil.getCellData(Catalog.getNav_CatalogPrivateWebTable(), 2, 6);
			sExpectedMovePopMsg="This template " +sImageName+ " will be Moved";
			
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateFirstExpander());
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateMoveBtn());
			WebObjectUtil.waitForElementPresent(Catalog.getNav_CatalogPrivateMoveOverlayPage());
			WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateMoveOverlayPage());
			
			WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateMoveDestDropDownArrow());
			WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateMoveDialogMoveBtn());
			WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateMoveDialogCancelButton());
			
			//WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateMoveDestDropDownArrow());
			//WebObjectUtil.selectCustomWebList(Catalog.getNav_CatalogPrivateMoveDestDropDown(), 2);
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateMoveDialogCancelButton());
			
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateMoveBtn());
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateMoveDestDropDownArrow());
			/*boolean bItemStatus=VerifyIteminCustomWebList(Catalog.getNav_CatalogPrivateMoveDestDropDown(),sCatalogName);
			if(!bItemStatus)
				FrameworkUtil.updateCustomResultBasedOnStatus(true, "Item not exists in the destination drop down");
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false, "Item exists in the destination drop down");*/
			//WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateMoveDestDropDownArrow());
			
			WebObjectUtil.selectCustomWebList(Catalog.getNav_CatalogPrivateMoveDestDropDown(), "SeleniumTestImage");
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateMoveDialogMoveBtn());
			
			if(WebObjectUtil.isElementPresent(Catalog.getNav_ErrDialogBox()))
			{
				String sErrTxt=Catalog.getNav_ErrDialogBox().getText();
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Issue with Move dropdown", "fail",sErrTxt );
				
			}
			
			WebObjectUtil.waitForElementPresent(Catalog.getNav_NewCatalogPopUpBody());
			sActualMovePopupMsg=(String)Catalog.getNav_NewCatalogPopUpBody().getText();
			if(sActualMovePopupMsg.contains(sExpectedMovePopMsg))
				FrameworkUtil.updateCustomResultBasedOnStatus(true, sExpectedMovePopMsg +" is matching with actual message");
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false, sExpectedMovePopMsg +" is not matching with actual message");
			
			WebObjectUtil.verifyElementPresent(Catalog.getNav_NewCatalogPopUpOKBtn());
			WebObjectUtil.verifyElementPresent(Catalog.getNav_NewCatalogPopUpCancelBtn());
			
			WebObjectUtil.clickElement(Catalog.getNav_NewCatalogPopUpOKBtn());
			WebObjectUtil.explicitWait(10);
			WebObjectUtil.waitForElementPresent(Catalog.getNav_CatalogUserFeedBack());
			sActFeedBackMsg=(String)Catalog.getNav_CatalogUserFeedBack().getText();
			if(sActFeedBackMsg.contains(sExpFeedBackMsg))
				FrameworkUtil.updateCustomResultBasedOnStatus(true, sExpFeedBackMsg +" is matching with actual message");
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false, sExpFeedBackMsg +" is not matching with actual message");
			
		}
		LoginTestCase.nav_Logout();
	}
	/*==============================================================
	TestScript 		: VerifyAndValidatePvtObjCatalogEdit
	Manual TestCase	: Catalogs -> Private Objects -> Edit page overlay
						Catalogs -> Private Objects -> Edit page fields
						Catalogs  -> Private Objects  -> Edit confirmation page
						Catalogs  -> Private Objects  -> Edit -> Successful message 
						Catalogs page -> Private Objects page -> Edit -> Cancel
						
	Description		: Verify and validate Edit functionality for Private Object and it's fields
	Author 			: Sukur Babu. B
	Creation Date 	: 25/05/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=12)
	public static void VerifyAndValidatePvtObjCatalogEdit()
	{
		String sUserName,sPassword,sExpectedEditPopMsg,sActualEditPopupMsg,sExpFeedBackMsg,sActFeedBackMsg,sEditImageName,sEditImageDesc;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		//sExpFeedBackMsg="Moving in progress :Move catalog action started";
		FrameworkUtil.sTestCaseName = "Catalog-VerifyAndValidatePvtObjCatalogEdit";
		FrameworkUtil.sManualTestCaseName="Verify Edit Overlay page, it's fields and validate Edit catalog functionality";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.USERID");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.PASSWORD");
		sEditImageName = (String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.EDIT.NAME");
		sEditImageDesc = (String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.EDIT.DESCRIPTION");
		
		LoginTestCase.nav_Login(sUserName, sPassword);
		NavigateToPrivateCatalogList();
		int iRowCnt=WebTableUtil.getRowCount(Catalog.getNav_CatalogPrivateWebTable());
		if(iRowCnt>0)
		{
			String sImageName=WebTableUtil.getCellData(Catalog.getNav_CatalogPrivateWebTable(), 2, 2);
			sExpectedEditPopMsg="This template will be saved!";
			sExpFeedBackMsg="Edit Successful :: Template " +sEditImageName+ " saved!";
			
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateFirstExpander());
			WebObjectUtil.waitForElementPresent(Catalog.getNav_CatalogPrivateWebTableEdit());
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateWebTableEdit());
			WebObjectUtil.waitForElementPresent(Catalog.getNav_CatalogPrivateEditOverlayPage());
			WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateEditOverlayPage());
			WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateEditName());
			WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateEditDesc());
			WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateEditSave());
			WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateEditCancel());
			WebObjectUtil.SetValueEdit(Catalog.getNav_CatalogPrivateEditName(), sEditImageName);
			WebObjectUtil.SetValueEdit(Catalog.getNav_CatalogPrivateEditDesc(), sEditImageDesc);
			//WebObjectUtil.MouseHover(Catalog.getNav_CatalogPrivateEditCancel());
			WebObjectUtil.clickElement(Catalog.getNav_NewCatalogPopUpCloseBtn());
			
			//WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateEditCancel());
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateWebTableEdit());
			WebObjectUtil.waitForElementPresent(Catalog.getNav_CatalogPrivateEditOverlayPage());
			WebObjectUtil.SetValueEdit(Catalog.getNav_CatalogPrivateEditName(), sEditImageName);
			WebObjectUtil.SetValueEdit(Catalog.getNav_CatalogPrivateEditDesc(), sEditImageDesc);
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateEditSave());
			WebObjectUtil.waitForElementPresent(Catalog.getNav_NewCatalogPopUpBody());
			WebObjectUtil.verifyElementPresent(Catalog.getNav_NewCatalogPopUpBody());
			WebObjectUtil.verifyElementPresent(Catalog.getNav_NewCatalogPopUpOKBtn());
			WebObjectUtil.verifyElementPresent(Catalog.getNav_NewCatalogPopUpCancelBtn());
			
			sActualEditPopupMsg=Catalog.getNav_NewCatalogPopUpBody().getText();
			if(sActualEditPopupMsg.contains(sExpectedEditPopMsg))
			{
				FrameworkUtil.updateCustomResultBasedOnStatus(true, sExpectedEditPopMsg +" is matching with actual message");
			}
			else
			{
				FrameworkUtil.updateCustomResultBasedOnStatus(false, sExpectedEditPopMsg +" is not matching with actual message");
			}
			WebObjectUtil.clickElement(Catalog.getNav_NewCatalogPopUpOKBtn());
			WebObjectUtil.explicitWait(30);
			WebObjectUtil.waitForElementPresent(Catalog.getNav_CatalogUserFeedBack());
			sActFeedBackMsg=(String)Catalog.getNav_CatalogUserFeedBack().getText();
			if(sActFeedBackMsg.contains(sExpFeedBackMsg))
				FrameworkUtil.updateCustomResultBasedOnStatus(true, sExpFeedBackMsg +" is matching with actual message");
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false, sExpFeedBackMsg +" is not matching with actual message");
		}
		LoginTestCase.nav_Logout();
	}
	/*==============================================================
	TestScript 		: VerifyAndValidatePvtObjManageCatalogEdit
	Manual TestCase	: Catalogs -> Private Objects -> Manage Catalogs-> Edit
						Catalogs -> Private Objects -> Manage Catalogs- Edit page fields
						Catalogs -> Private Objects -> Manage Catalogs- Edit confirmation page
						Catalogs -> Private Objects -> Manage Catalogs->Edit -> Successful message 
						Catalogs page ->Private Objects -> Manage Catalogs->Edit -> Cancel
						
	Description		: Verify and validate Edit functionality in Manage Catalog for Private Objects and it's fields
	Author 			: Sukur Babu. B
	Creation Date 	: 25/05/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=13)
	public static void VerifyAndValidatePvtObjManageCatalogEdit()
	{
		String sUserName,sPassword,sExpectedEditPopMsg,sActualEditPopupMsg,sExpFeedBackMsg,sActFeedBackMsg,sEditImageName,sEditImageDesc;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		//sExpFeedBackMsg="Moving in progress :Move catalog action started";
		FrameworkUtil.sTestCaseName = "Catalog-VerifyAndValidatePvtObjManageCatalogEdit";
		FrameworkUtil.sManualTestCaseName="Verify Edit Overlay page, it's fields and validate Edit catalog functionality in Manage Catalog";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.USERID");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.PASSWORD");
		sEditImageName = (String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.EDIT.NAME");
		sEditImageDesc = (String)FrameworkUtil.dictPropertyData.get("NAV.CATALOG.EDIT.DESCRIPTION");
		
		LoginTestCase.nav_Login(sUserName, sPassword);
		NavigateToPrivateManageCatalogList();
		int iRowCnt=WebTableUtil.getRowCount(Catalog.getNav_CatalogPrivateManageCatalogWebTable());
		if(iRowCnt>0)
		{
			String sImageName=WebTableUtil.getCellData(Catalog.getNav_CatalogPrivateManageCatalogWebTable(), 2, 2);
			sExpectedEditPopMsg="This edited catalog "+sEditImageName+" will be saved";
			sExpFeedBackMsg="Edit Successful :Successfully edited catalog";
			
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateAddCatalogFirstExpander());
			WebObjectUtil.waitForElementPresent(Catalog.getNav_PrivateObjectEditInManageCatalogList());
			WebObjectUtil.clickElement(Catalog.getNav_PrivateObjectEditInManageCatalogList());
			WebObjectUtil.waitForElementPresent(Catalog.getNav_CatalogPrivateManageEditOverLayPage());
			WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateManageEditOverLayPage());
			WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateManageEditOverLayPageName());
			WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateManageEditOverLayPageDesc());
			WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateManageEditOverLayPageOKButton());
			WebObjectUtil.verifyElementPresent(Catalog.getNav_CatalogPrivateManageEditOverLayPageCancelButton());
			WebObjectUtil.SetValueEdit(Catalog.getNav_CatalogPrivateManageEditOverLayPageName(), sEditImageName);
			WebObjectUtil.SetValueEdit(Catalog.getNav_CatalogPrivateManageEditOverLayPageDesc(), sEditImageDesc);
			//WebObjectUtil.MouseHover(Catalog.getNav_CatalogPrivateEditCancel());
			WebObjectUtil.clickElement(Catalog.getNav_ManageCatalogEditPopUpCloseBtn());
			
			
			WebObjectUtil.clickElement(Catalog.getNav_PrivateObjectEditInManageCatalogList());
			WebObjectUtil.waitForElementPresent(Catalog.getNav_CatalogPrivateManageEditOverLayPage());
			WebObjectUtil.SetValueEdit(Catalog.getNav_CatalogPrivateManageEditOverLayPageName(), sEditImageName);
			WebObjectUtil.SetValueEdit(Catalog.getNav_CatalogPrivateManageEditOverLayPageDesc(), sEditImageDesc);
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateManageEditOverLayPageOKButton());
			WebObjectUtil.waitForElementPresent(Catalog.getNav_NewCatalogPopUpBody());
			WebObjectUtil.verifyElementPresent(Catalog.getNav_NewCatalogPopUpBody());
			WebObjectUtil.verifyElementPresent(Catalog.getNav_NewCatalogPopUpOKBtn());
			WebObjectUtil.verifyElementPresent(Catalog.getNav_NewCatalogPopUpCancelBtn());
			
			sActualEditPopupMsg=Catalog.getNav_NewCatalogPopUpBody().getText();
			if(sActualEditPopupMsg.contains(sExpectedEditPopMsg))
			{
				FrameworkUtil.updateCustomResultBasedOnStatus(true, sExpectedEditPopMsg +" is matching with actual message");
			}
			else
			{
				FrameworkUtil.updateCustomResultBasedOnStatus(false, sExpectedEditPopMsg +" is not matching with actual message");
			}
			
			WebObjectUtil.clickElement(Catalog.getNav_NewCatalogPopUpOKBtn());
			WebObjectUtil.explicitWait(30);
			WebObjectUtil.waitForElementPresent(Catalog.getNav_PopupWindow());
			WebObjectUtil.clickElement(Catalog.getNav_PopupOkBtn());
			WebObjectUtil.waitForElementPresent(Catalog.getNav_CatalogUserFeedBack());
			sActFeedBackMsg=(String)Catalog.getNav_CatalogUserFeedBack().getText();
			if(sActFeedBackMsg.contains(sExpFeedBackMsg))
				FrameworkUtil.updateCustomResultBasedOnStatus(true, sExpFeedBackMsg +" is matching with actual message");
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false, sExpFeedBackMsg +" is not matching with actual message");
			WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateManageCatalogListCloseButton());
			
		}
		LoginTestCase.nav_Logout();
	}
	public static void NavigateToPrivateManageCatalogList()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		WebObjectUtil.waitForElementPresent(Catalog.getNav_EVDCname());
		WebObjectUtil.clickElement(Catalog.getNav_EVDCname());
		WebObjectUtil.waitForElementPresent(Catalog.getNav_CatalogPortletLink());
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPortletLink());
		WebObjectUtil.waitForElementPresent(Catalog.getNav_CatalogPrivateLink());
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateLink());
		WebObjectUtil.waitForElementPresent(Catalog.getNav_CatalogPrivateManageCatalogBtn());
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateManageCatalogBtn());
		WebObjectUtil.waitForElementPresent(Catalog.getNav_CatalogPrivateAddCatalogLink());
		
	}
	public static void NavigateToPrivateCatalogList()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		WebObjectUtil.explicitWait(10);
		WebObjectUtil.clickElement(Catalog.getNav_EVDCname());
		WebObjectUtil.waitForElementPresent(Catalog.getNav_CatalogPortletLink());
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPortletLink());
		WebObjectUtil.waitForElementPresent(Catalog.getNav_CatalogPrivateLink());
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateLink());
		WebObjectUtil.waitForElementPresent(Catalog.getNav_CatalogPrivateManageCatalogBtn());
				
	}
	public static void NavigateToWSCatalogList()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		WebObjectUtil.clickElement(Catalog.getNav_EVDCname());
		WebObjectUtil.waitForElementPresent(Catalog.getNav_CatalogPortletLink());
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPortletLink());
		WebObjectUtil.waitForElementPresent(Catalog.getNav_CatalogPrivateLink());
		
				
	}
	public static void NavigateToAddCatalogOverlayPage()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Catalog);
		
		WebObjectUtil.clickElement(Catalog.getNav_EVDCname());
		WebObjectUtil.waitForElementPresent(Catalog.getNav_CatalogPortletLink());
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPortletLink());
		WebObjectUtil.waitForElementPresent(Catalog.getNav_CatalogPrivateLink());
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateLink());
		WebObjectUtil.waitForElementPresent(Catalog.getNav_CatalogPrivateManageCatalogBtn());
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateManageCatalogBtn());
		WebObjectUtil.waitForElementPresent(Catalog.getNav_CatalogPrivateAddCatalogLink());
		WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateAddCatalogLink());
		
	}
	
	public static boolean VerifyIteminCustomWebList(WebElement webElement,String sItemText){
		int iItem = 0,iTemp;
		String sItem = null;
		boolean flag = false;
	    	try {
				if (WebObjectUtil.isElementPresent(webElement)){
					//WebObjectUtil.MouseHover(webElement);
					List<WebElement> webListItems = webElement.findElements(By.tagName("li"));
					for (WebElement wb: webListItems){
						
						sItem =wb.getText() ;
						if(sItem.equalsIgnoreCase(sItemText))
						{
							flag=true;
							break;
						}
						else 
						{
							flag=false;
							continue;
						}
					}
				}else{
	    			LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element NOT present", "fail", "Element not present/visible ");
	    		}
			
			} catch (Exception e) {
				LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "selectCustomWebList", "warn", "catch block:Could NOT access webelement" +e.getMessage());
			}
	    	return flag;
	}

	
//########################################################################
	
	
	
	//update each @test result in custom result file
	@AfterMethod
	public static void afterEachMethod(){
		FrameworkUtil.updateTestCaseStatusinResult();
		
	}	
	
	
	
}
