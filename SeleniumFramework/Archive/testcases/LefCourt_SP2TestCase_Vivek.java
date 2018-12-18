package com.whs.navigator.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

//import com.gargoylesoftware.htmlunit.javascript.configuration.WebBrowser;
import com.whs.navigator.commonUtil.CustomWebElementUtil;
import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.commonUtil.WebTableUtil;
import com.whs.navigator.pagefactory.CommonPageFactory;
import com.whs.navigator.pagefactory.EVDC_FirewallPageFactory;
import com.whs.navigator.pagefactory.FirewallPageFactory;

public class LefCourt_SP2TestCase_Vivek {
	public static EVDC_FirewallPageFactory FirewallPF = new EVDC_FirewallPageFactory();
	public static CommonPageFactory Common =new CommonPageFactory();
	
/*==============================================================
	TestScript  	: verifyHSServiceDataNotVisible
	Manual TestCase	: QAT-303-WCP_2885_Group Object Management_Services_HS_Services
	Description		: Verify that HS Servicest data is not displayed in GOM under Services folder on WCP. 
					  Verify that user is not able to see the data related to HS Services on PDF/CSV reports too. 
	Author 			: Vivek Kumar
	Creation Date 	: 02/08/2016
	Release Name    : LefCourt_SP2
	Pre-Requisites	:
	Revision History:
==============================================================*/
	@Test(priority=1)
	public void verifyHSServiceDataNotVisible()
	{
		String sText,sHSService;
		boolean bStatus;
		WebElement wElement;
		int iRowCnt,iRowCntAfterClicking;
		
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		
		FrameworkUtil.sTestCaseName = "verifyHSServiceDataNotVisible";
		FrameworkUtil.sManualTestCaseName="QAT-303-WCP_2885_Group Object Management_Services_HS_Services";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		

		sHSService=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.GOM.SERVICEOBJECT.HSSERVICE");
				
		// login to the navigator
		LoginTestCase.LoginAsQaautoUser();
				
		// navigating to the firewall page
		EVDC_FirewallTestCase.NavigateToFirewallPage();
		
		// wait for the feedback message not displayed
		LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
				
		//Clicking on GOM link and verifying its landing page
		WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
		
		WebObjectUtil.explicitWait(5);
		
		//Expanding the Services Object
		WebObjectUtil.clickElement(FirewallPF.getNav_ServiceObjectsExpander());
		WebObjectUtil.explicitWait(5);
		//Expanding the HS Service
		WebObjectUtil.clickElement(FirewallPF.getNav_ServiceExpander());
		
		//Getting the total count of Service table
		CustomWebElementUtil.loadCustomElement(FirewallPF.getNav_GOMServiceTableParent(), "table");
		
		iRowCnt=CustomWebElementUtil.iRowCount;
		//System.out.println(iRowCnt);
		for(int i=1;i<=2;i++)
		{
			sText=CustomWebElementUtil.getCellData(i, 1);
			//System.out.println(sText);
			WebObjectUtil.explicitWait(2);
			if(sText.equalsIgnoreCase(sHSService))
			{
			wElement=CustomWebElementUtil.getRowAsWebElement(i);
			WebObjectUtil.clickElement(wElement);
			//Getting the total count of Service table
			CustomWebElementUtil.loadCustomElement(FirewallPF.getNav_GOMServiceTableParent(), "table");
			iRowCntAfterClicking=CustomWebElementUtil.iRowCount;
			WebObjectUtil.explicitWait(2);
			if(iRowCnt==iRowCntAfterClicking)
			{
				bStatus=WebObjectUtil.verifyElementNOTPresent(FirewallPF.getNav_GOMServiceHSServiceExpander());
				FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Expander is not there for HS-Service as expected");
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Comparing row count after clicking", "pass", "Row count before clicking on "+sHSService + " ="+iRowCnt+ " and row count after click is "+iRowCntAfterClicking );
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Comparing row count after clicking", "fail", "Row count before clicking on "+sHSService + " ="+iRowCnt+ " and row count after click is "+iRowCntAfterClicking );
			}
			
			break;
			}
		}

		//Logout
		LoginTestCase.nav_Logout();
		
	}
	
/*==============================================================
	TestScript  	: verifyCreateObjUsngTCP
	Manual TestCase	: QAT-302-WCP_2896 & 2592_Group Object Management_Service Objects_Create_Object/Object Group_New Object_Type=TCP
					  QAT-283-WCP_2896 & 2592_TC_Group Object Management_Service Objects_Create_Object Group with "New Objects"
					  QAT-237-WCP_2896 & 2592_TC_Group Object Management_Service Objects_Create an object to parent folder -Services
					  QAT-235-WCP_2984_TC_Group Object Management_Network/Service Objects_Screen closes after user performs and saves the actions
					  QAT-240-WCP_3954_Group Object Management_Service/Network Objects_User cannot make changes to the objects or objects groups when previous change is pending.
					  QAT-545-WCP_2593 & 2896_TC_1.13_Group Object Management_Service Objects_Delete-Object from Parent Group Services.
					  QAT-1345-WCP_2896 & 2592_Group Object Management_Service Objects_Create_New Object under Parent Service_Type=TCP
	Description		: Verify create object functionality when object Type=TCP
	Author 			: Vivek Kumar
	Creation Date 	: 02/09/2016
	Release Name    : LefCourt_SP2
	Pre-Requisites	:
	Revision History:
==============================================================*/
	@Test(priority=2)
	public void verifyCreateObjUsngTCP()
	{
		
		
		String sNewObjServiceName,sNewObjObjectType,sNewObjServiceEnd;
		
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		PageFactory.initElements(driver, Common);
		
		FrameworkUtil.sTestCaseName = "verifyCreateObjUsngTCP";
		FrameworkUtil.sManualTestCaseName="QAT-302-QAT-283-QAT-237-QAT-235-QAT-545-QAT-1345-WCP_2896 & 2592_Group Object Management_Service Objects_Create_Object/Object Group_New Object_Type=TCP";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		
		sNewObjServiceName=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.SERVICENAME");
		sNewObjObjectType=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.OBJECTTYPE.TCP");
		
		sNewObjServiceEnd=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.SERVICEEND.SOURCE");
		
		sNewObjServiceName=sNewObjServiceName+"_TCP_"+FrameworkUtil.sTimeStamp;
		
		try {
			// login to the navigator
			LoginTestCase.LoginAsQaautoUser();
					
			// navigating to the firewall page
			EVDC_FirewallTestCase.NavigateToFirewallPage();
			
			// wait for the feedback message not displayed
			LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
			
			//Clicking on GOM link and verifying its landing page
			WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
	
			WebObjectUtil.explicitWait(2);
			
			//Create New Object
			createNewObject(sNewObjServiceName,sNewObjObjectType,"Object",null,null,sNewObjServiceEnd);
			
			WebDriverUtil.refreshBrowser();
			LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
			
			WebObjectUtil.explicitWait(10);
			WebDriverUtil.refreshBrowser();
				
			//Clicking on GOM link and verifying its landing page
			WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
			WebObjectUtil.explicitWait(15);
			WebDriverUtil.refreshBrowser();
			
			//Clicking on GOM link and verifying its landing page
			WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
			
			WebObjectUtil.explicitWait(5);
			
			//Expanding the Services Object
			WebObjectUtil.clickElement(FirewallPF.getNav_ServiceObjectsExpander());
			WebObjectUtil.explicitWait(5);
			//Expanding the HS Service
			WebObjectUtil.clickElement(FirewallPF.getNav_ServiceExpander());
			
			//Deleting object
			deleteObject(sNewObjServiceName);
			
			//Logout
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}

	
/*==============================================================
TestScript  	: verifyCreateDeleteObjWithoutChild
Manual TestCase	: QAT-311-WCP_2593_Group Object Management_Service Objects_Delete-Object Group with no children in it.
				  QAT-293-WCP_2896_TC_Group Object Management_Service Objects_Create_Empty group
				  QAT-287-WCP_3765 & 3747_Group Object Management_IAC does not support nested object groups/Create icon is not available for Child folders under Network or Service Objects
				  QAT-336-WCP_2896_TC_Group Object Management_Name field length for Object or Object Group under Service Objects
				  QAT-1368-WCP_2896_TC_Group Object Management-Service Objects-Search box
Description		: Verify that user is able to delete Object Groups under Service Objects , when the Object Group has no children in it.
Author 			: Vivek Kumar
Creation Date 	: 03/01/2016
Release Name    : LefCourt_SP2
Pre-Requisites	:
Revision History:
==============================================================*/
	@Test(priority=3)
	public void verifyCreateDeleteObjWithoutChild()
	{
		
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		PageFactory.initElements(driver, Common);
		
		//Variable declaration
		int iRNumber;
		String sGrpName,sGrpDesc,sMatchFound;
		WebElement wRow,wDynamicCreateImage;
		boolean bImage;
		
		FrameworkUtil.sTestCaseName = "verifyCreateDeleteObjWithoutChild";
		FrameworkUtil.sManualTestCaseName="QAT-311-QAT-293-QAT-287-QAT-336-QAT-1368WCP_2593_Group Object Management_Service Objects_Delete-Object Group with no children in it.";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		//Importing group name from properties file
		sGrpName=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.SERVICENAME");
		
		//updating the Group name
		sGrpName=sGrpName+"_"+ FrameworkUtil.sTimeStamp;
		sGrpDesc=sGrpName+"_NoChild_Description";
		
		// login to the navigator
		LoginTestCase.LoginAsQaautoUser();
				
		// navigating to the firewall page
		EVDC_FirewallTestCase.NavigateToFirewallPage();
		
		// wait for the feedback message not displayed
		LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
		
		//Clicking on GOM link and verifying its landing page
		WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
		
		//Create Empty folder
		createGrpObject(sGrpName,sGrpDesc,false);
		
		//SCript need to wait until feedback message is there
		WebDriverUtil.refreshBrowser();
		LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
		
		WebObjectUtil.explicitWait(10);
		WebDriverUtil.refreshBrowser();
			
		//Clicking on GOM link and verifying its landing page
		WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
		WebObjectUtil.explicitWait(15);
		WebDriverUtil.refreshBrowser();
		
		//Clicking on GOM link and verifying its landing page
		WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
		
		WebObjectUtil.explicitWait(5);
		//Expanding the Services Object
		WebObjectUtil.clickElement(FirewallPF.getNav_ServiceObjectsExpander());
		WebObjectUtil.explicitWait(5);
		//Expanding the HS Service
		WebObjectUtil.clickElement(FirewallPF.getNav_ServiceExpander());
		WebObjectUtil.explicitWait(5);
		
		//getting the row number for respective group name and clicking on the same
		iRNumber=verifyServiceObject(sGrpName);
		CustomWebElementUtil.loadCustomElement(FirewallPF.getNav_GOMServiceTableParent(), "table");
		wRow=CustomWebElementUtil.getRowAsWebElement(iRNumber);
		WebObjectUtil.clickElement(wRow);
		
		//Getting create image value from dynamic properties file
		wDynamicCreateImage=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.IMAGE", "PARAMETER_ROWNUMBER", iRNumber+"");
		 bImage=false;
		if(wDynamicCreateImage==null)
		{
		bImage=true;	
		}
		//Updating result for create image
		FrameworkUtil.updateCustomResultBasedOnStatus(bImage, "Create Image is not there for child folder");
		
		WebObjectUtil.explicitWait(3);
		//Serching recently created Grp Name
		WebObjectUtil.SetValueEdit(FirewallPF.getNav_GOMServiceSearchEdit(), sGrpName);
		WebObjectUtil.explicitWait(3);
		sMatchFound=FirewallPF.getNav_GOMServiceMatchesFound().getText();
		//Updating the result based on search result 
		if(sMatchFound.equalsIgnoreCase("1") )
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verifying Matches Found" , "pass",sMatchFound+" match found");
		}
		else
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verifying Matches Found" , "fail",sMatchFound+" match found");
		}
		verifyServiceObject(sGrpName);
		
		
		
		//Delete empty folder
		deleteEmptyFolder(sGrpName);
		
		
		//Logout
		LoginTestCase.nav_Logout();
	}
	
	
	/*==============================================================
	TestScript  	: verifyCreateObjFromExistingObj
	Manual TestCase	: QAT-335-WCP_2896 & 2594_TC_Group Object Management_Service Objects_Create_Object Group with objects selected from "From Existing"
			 		  QAT-316-WCP_2593_Group Object Management_Service Objects_Delete-Object from a Group Object.
	Description		: Verify the create functionality and options in Service Objects.
	Author 			: Vivek Kumar
	Creation Date 	: 03/15/2016
	Release Name    : LefCourt_SP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=4)
	public void verifyCreateObjFromExistingObj()
	{
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		PageFactory.initElements(driver, Common);
		
		String sGrpName,sGrpDesc;
		
		FrameworkUtil.sTestCaseName = "verifyCreateObjFromExistingObj";
		FrameworkUtil.sManualTestCaseName=" QAT-335-QAT-316WCP_2896 & 2594_TC_Group Object Management_Service Objects_Create_Object Group with objects selected from From Existing";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		//Importing Group name from properties file
		sGrpName=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.SERVICENAME");
		
		//Updating the Group name with TimeStamp
		sGrpName=sGrpName+"_Exist_"+ FrameworkUtil.sTimeStamp;
		sGrpDesc=sGrpName+"_Exist_Description";
		
		// login to the navigator
		LoginTestCase.LoginAsQaautoUser();
				
		// navigating to the firewall page
		EVDC_FirewallTestCase.NavigateToFirewallPage();

		// wait for the feedback message not displayed
		LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
		
		//Clicking on GOM link and verifying its landing page
		WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
		
		//Create Empty folder
		createGrpObject(sGrpName,sGrpDesc,true);
		
		//Refresh the page and wait until feedback message there
		WebDriverUtil.refreshBrowser();
		LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
		
		WebObjectUtil.explicitWait(10);
		WebDriverUtil.refreshBrowser();
			
		//Clicking on GOM link and verifying its landing page
		WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
		WebObjectUtil.explicitWait(15);
		WebDriverUtil.refreshBrowser();
		
		//Clicking on GOM link and verifying its landing page
		WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
		
		WebObjectUtil.explicitWait(5);
		
		//Expanding the Services Object
		WebObjectUtil.clickElement(FirewallPF.getNav_ServiceObjectsExpander());
		WebObjectUtil.explicitWait(5);
		//Expanding the HS Service
		WebObjectUtil.clickElement(FirewallPF.getNav_ServiceExpander());
		
		//Verifying the recently created Grp Object
		int iRNumber;
		WebElement wExpander,wChild,wDynamicDelete;
		boolean bStatus=false;
		String sExpectedFeedbackMsg,sActualFeedbackMsg;
		
		//Getting the row number for respective group and expanding the same
		iRNumber=verifyServiceObject(sGrpName);
		wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.EXPANDER", "PARAMETER_ROWNUMBER", iRNumber+"");
		WebObjectUtil.clickElement(wExpander);
		//Incrementing the row number with 1 so that it will go to its child and clicking the same
		iRNumber=iRNumber+1;
		CustomWebElementUtil.loadCustomElement(FirewallPF.getNav_GOMServiceTableParent(), "table");
		wChild=CustomWebElementUtil.getRowAsWebElement(iRNumber);
		WebObjectUtil.clickElement(wChild);
		
		//Clicking on child delete image
		wDynamicDelete=	WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.DELETE.IMAGE", "PARAMETER_ROWNUMBER", iRNumber+"");
		WebObjectUtil.clickElement(wDynamicDelete);
		//Clicking on confirm popup and verifying the feedback message
		if(WebObjectUtil.isElementPresent(Common.getNav_CommonPopUpBox()))
		{
			WebObjectUtil.clickElement(Common.getNav_CommonPopUpOkBtn());
			WebObjectUtil.explicitWait(5);
			
			sExpectedFeedbackMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.DELETE.CHILD.FEEDBACK.MESSAGE");
			sActualFeedbackMsg=Common.getNav_UsrFeedBack().getText();
			bStatus=WebObjectUtil.compareString(sActualFeedbackMsg.trim(), sExpectedFeedbackMsg.trim(), true);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Object deleted feedback message - " + sActualFeedbackMsg);
			WebDriverUtil.refreshBrowser();
		}
		else
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verifying Confirm Popup" , "fail","Confirm Popup not verified");
		}
		
		
		//Logout
		LoginTestCase.nav_Logout();
	}
	
	
	/*==============================================================
	TestScript  	: verifyCreateObjectUsingICMP
	Manual TestCase	: QAT-334-WCP_2896 & 2592_Group Object Management_Service Objects_Create_Object/Object Group_New Object_Type=ICMP
	Description		: Verify create object functionality when object Type=ICMP
	Author 			: Vivek Kumar
	Creation Date 	: 03/16/2016
	Release Name    : LefCourt_SP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=5)
	public void verifyCreateObjectUsingICMP()
	{
		String sNewObjServiceName,sNewObjObjectType,sNewObjServiceEnd;
		
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		PageFactory.initElements(driver, Common);
		
		FrameworkUtil.sTestCaseName = "verifyCreateObjectUsingICMP";
		FrameworkUtil.sManualTestCaseName=" QAT-334-WCP_2896 & 2592_Group Object Management_Service Objects_Create_Object/Object Group_New Object_Type=ICMP";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		
		sNewObjServiceName=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.SERVICENAME");
		sNewObjObjectType=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.OBJECTTYPE.ICMP");
		sNewObjServiceEnd=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.SERVICEEND.SOURCE");

		
		sNewObjServiceName=sNewObjServiceName+"_ICMP_"+FrameworkUtil.sTimeStamp;
		
		try {
			// login to the navigator
			LoginTestCase.LoginAsQaautoUser();
					
			// navigating to the firewall page
			EVDC_FirewallTestCase.NavigateToFirewallPage();
			
			// wait for the feedback message not displayed
			LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
			
			//Clicking on GOM link and verifying its landing page
			WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
	
			//Create New Object using ICMP
			createNewObject(sNewObjServiceName,sNewObjObjectType,"Object",null,null,sNewObjServiceEnd);
			
			WebDriverUtil.refreshBrowser();
			LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
			
			WebObjectUtil.explicitWait(10);
			WebDriverUtil.refreshBrowser();
				
			//Clicking on GOM link and verifying its landing page
			WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
			WebObjectUtil.explicitWait(15);
			WebDriverUtil.refreshBrowser();
			
			//Clicking on GOM link and verifying its landing page
			WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
			
			WebObjectUtil.explicitWait(5);
			
			//Expanding the Services Object
			WebObjectUtil.clickElement(FirewallPF.getNav_ServiceObjectsExpander());
			WebObjectUtil.explicitWait(5);
			//Expanding the HS Service
			WebObjectUtil.clickElement(FirewallPF.getNav_ServiceExpander());
			
			verifyServiceObject(sNewObjServiceName);
			
			deleteObject(sNewObjServiceName);
			
			//Logout
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	
	/*==============================================================
	TestScript  	: verifyCreateObjectUsingUDP
	Manual TestCase	: QAT-319-WCP_2896 & 2592_Group Object Management_Service Objects_Create_Object/Object Group_New Object_Type=UDP
	Description		: Verify create object functionality when object Type=UDP
	Author 			: Vivek Kumar
	Creation Date 	: 03/16/2016
	Release Name    : LefCourt_SP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=6)
	public void verifyCreateObjectUsingUDP()
	{
		String sNewObjServiceName,sNewObjObjectType,sNewObjServiceEnd;
		
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		PageFactory.initElements(driver, Common);
		
		FrameworkUtil.sTestCaseName = "verifyCreateObjectUsingUDP";
		FrameworkUtil.sManualTestCaseName="QAT-319-WCP_2896 & 2592_Group Object Management_Service Objects_Create_Object/Object Group_New Object_Type=UDP";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		
		sNewObjServiceName=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.SERVICENAME");
		sNewObjObjectType=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.OBJECTTYPE.UDP");
		
		sNewObjServiceEnd=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.SERVICEEND.SOURCE");
		
		sNewObjServiceName=sNewObjServiceName+"_UDP_"+FrameworkUtil.sTimeStamp;
		
		try {
			// login to the navigator
			LoginTestCase.LoginAsQaautoUser();
					
			// navigating to the firewall page
			EVDC_FirewallTestCase.NavigateToFirewallPage();
			
			// wait for the feedback message not displayed
			LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
			
			//Clicking on GOM link and verifying its landing page
			WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
	
			//Create New Object using UDP
			createNewObject(sNewObjServiceName,sNewObjObjectType,"Object",null,null,sNewObjServiceEnd);
			
			WebDriverUtil.refreshBrowser();
			LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
			
			WebObjectUtil.explicitWait(10);
			WebDriverUtil.refreshBrowser();
				
			//Clicking on GOM link and verifying its landing page
			WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
			WebObjectUtil.explicitWait(15);
			WebDriverUtil.refreshBrowser();
			
			//Clicking on GOM link and verifying its landing page
			WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
			
			WebObjectUtil.explicitWait(5);
			
			//Expanding the Services Object
			WebObjectUtil.clickElement(FirewallPF.getNav_ServiceObjectsExpander());
			WebObjectUtil.explicitWait(5);
			//Expanding the HS Service
			WebObjectUtil.clickElement(FirewallPF.getNav_ServiceExpander());
			
			verifyServiceObject(sNewObjServiceName);
			
			deleteObject(sNewObjServiceName);
			
			//Logout
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	TestScript  	: verifyErrMsgIfUsedByOther
	Manual TestCase	: QAT-544-WCP_2593 & 2896_TC_1.13_Group Object Management_Service Objects_Delete-Object from Parent Group Services cannot be delete if in use in other Object Groups under Service Objects.
	Description		: Verify that object under Parent group Services is un-editable and undeletable when it is in use in any of the Child Object Groups
	Author 			: Vivek Kumar
	Creation Date 	: 03/23/2016
	Release Name    : LefCourt_SP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=7)
	public void verifyErrMsgIfUsedByOther()
	{
		
		int iRowCnt,iRowNo = 0;
		WebElement wExpander = null,wParentFolder = null,wDynamicChildName,wDynamicChildToolTip,wChild;
		boolean bFlag=false,bStatus;
		String sChildText,sToolTipMessage;
				
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		PageFactory.initElements(driver, Common);
		
		FrameworkUtil.sTestCaseName = "verifyErrMsgIfUsedByOther";
		FrameworkUtil.sManualTestCaseName=" QAT-544-WCP_2593 & 2896_TC_1.13_Group Object Management_Service Objects_Delete-Object from Parent Group Services cannot be delete if in use in other Object Groups under Service Objects.";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		try {
			// login to the navigator
			LoginTestCase.LoginAsQaautoUser();
					
			// navigating to the firewall page
			EVDC_FirewallTestCase.NavigateToFirewallPage();
			
			// wait for the feedback message not displayed
			LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
			
			//Clicking on GOM link and verifying its landing page
			WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
			WebObjectUtil.explicitWait(5);
			//Expanding the Services Object
			WebObjectUtil.clickElement(FirewallPF.getNav_ServiceObjectsExpander());
			WebObjectUtil.explicitWait(5);
			//Expanding the HS Service
			WebObjectUtil.clickElement(FirewallPF.getNav_ServiceExpander());
			
			
			//Getting the total count of Service table
			CustomWebElementUtil.loadCustomElement(FirewallPF.getNav_GOMServiceTableParent(), "table");
			iRowCnt=CustomWebElementUtil.iRowCount;

			for(int i=2;i<=iRowCnt; i++)
			{
				wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.EXPANDER", "PARAMETER_ROWNUMBER", i+"");
				wParentFolder=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.PARENT.FOLDER", "PARAMETER_ROWNUMBER", i+"");
				if(wExpander!=null && WebObjectUtil.isElementPresent(wExpander) && (WebObjectUtil.isElementPresent(wParentFolder)))
				{
					bFlag=true;
					iRowNo=i;
					break;
				}
				
			}
			
			if(bFlag)
			{
				//WebObjectUtil.clickElement(wParentFolder);
				WebObjectUtil.explicitWait(3);
				WebObjectUtil.clickElement(wExpander);
			}
			//incrementing the count by 1 and capturing the child name
			iRowNo=iRowNo+1;
			CustomWebElementUtil.loadCustomElement(FirewallPF.getNav_GOMServiceTableParent(), "table");
			CustomWebElementUtil.getRowAsWebElement(iRowNo);
			WebObjectUtil.explicitWait(3);
			wDynamicChildName=	WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CHILD.NAME", "PARAMETER_ROWNUMBER", iRowNo+"");
			sChildText=wDynamicChildName.getText();
			//refreshing the browser
			WebDriverUtil.refreshBrowser();
			
			//Clicking on GOM link and verifying its landing page
			WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
			WebObjectUtil.explicitWait(5);
			//Expanding the Services Object
			WebObjectUtil.clickElement(FirewallPF.getNav_ServiceObjectsExpander());
			WebObjectUtil.explicitWait(5);
			//Expanding the HS Service
			WebObjectUtil.clickElement(FirewallPF.getNav_ServiceExpander());
			WebObjectUtil.explicitWait(5);
			//Getting the total count of Service table
			CustomWebElementUtil.loadCustomElement(FirewallPF.getNav_GOMServiceTableParent(), "table");
			iRowCnt=CustomWebElementUtil.iRowCount;
			
			//Clicking the row based on rownumber
			iRowNo=verifyServiceObject(sChildText);
			wChild=CustomWebElementUtil.getRowAsWebElement(iRowNo);
			WebObjectUtil.clickElement(wChild);
			WebObjectUtil.explicitWait(2);
			//Expected tool tip message
			wDynamicChildToolTip=	WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CHILD.USING.TOOLTIP", "PARAMETER_ROWNUMBER", iRowNo+"");
				
			sToolTipMessage = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.WEBTABLE.TOOLTIP.MESSAGE");
			
			bStatus = LefCourt_SP2TestCase_NMR.GOMCreateObjectToolTipMsg(wDynamicChildToolTip, "data-qtip", sToolTipMessage);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, " verifying the tooltip message - "+ sToolTipMessage);
			
			//Logout
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
	}
	

	/*==============================================================
	TestScript  	: verifyServiceObjectsFolder
	Manual TestCase	: QAT-296-WCP_2885_TC_1.0_Group Object Management View-> Service Objects Folder view
	Description		: Verify the display in Group Object Management page/Service objects folder.
	Author 			: Vivek Kumar
	Creation Date 	: 03/24/2016
	Release Name    : LefCourt_SP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=8)
	public void verifyServiceObjectsFolder()
	{
		int iRowCnt,iRowNo = 0;
		WebElement wExpander = null,wParentFolder,wchildRow,wElement,wEdit,wParentRow,wDelete;
		boolean bFlag=false,bDelete=false;
		String sText;
		
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		PageFactory.initElements(driver, Common);
		
		FrameworkUtil.sTestCaseName = "verifyServiceObjectsFolder";
		FrameworkUtil.sManualTestCaseName="QAT-296-WCP_2885_TC_1.0_Group Object Management View-> Service Objects Folder view";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		
		LoginTestCase.LoginAsQaautoUser();
		
		// navigating to the firewall page
		EVDC_FirewallTestCase.NavigateToFirewallPage();
		
		// wait for the feedback message not displayed
		LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
		
		//Clicking on GOM link and verifying its landing page
		WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
		WebObjectUtil.explicitWait(5);
		//Expanding the Services Object
		WebObjectUtil.clickElement(FirewallPF.getNav_ServiceObjectsExpander());
		WebObjectUtil.explicitWait(5);
		//Expanding the HS Service
		WebObjectUtil.clickElement(FirewallPF.getNav_ServiceExpander());
		
		//Verifying Search Edit field and Close Button
		WebObjectUtil.isElementPresent(FirewallPF.getNav_GOMServiceSearchEdit());
		WebObjectUtil.isElementPresent(FirewallPF.getNav_GOMWindowClose());
		
		//Getting the total count of Service table
		CustomWebElementUtil.loadCustomElement(FirewallPF.getNav_GOMServiceTableParent(), "table");
		iRowCnt=CustomWebElementUtil.iRowCount;
		
		for(int i=1;i<=iRowCnt;i++)
		{
			sText=CustomWebElementUtil.getCellData(i, 1);
			//System.out.println(sText);
			WebObjectUtil.explicitWait(2);
			if(sText.equalsIgnoreCase("Service"))
			{
				wElement=CustomWebElementUtil.getRowAsWebElement(i);
				WebObjectUtil.clickElement(wElement);
				//Clicking on Service Create Image
				WebObjectUtil.isElementPresent(FirewallPF.getNav_GOMServiceCreateImg());
				WebObjectUtil.clickElement(FirewallPF.getNav_GOMServiceCreateImg());
				//verifying Create Window
				WebObjectUtil.verifyElementPresent(FirewallPF.getNav_GOMServiceCreateWindow());
				//Cancel icon
				WebObjectUtil.clickElement(FirewallPF.getNav_Service_ObjectTypeCancelBtn());
				break;
			}
		}
		
		
		
		//##########################################################

		for(int i=2;i<=iRowCnt; i++)
		{
			wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.EXPANDER", "PARAMETER_ROWNUMBER", i+"");
			wParentFolder=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.PARENT.FOLDER", "PARAMETER_ROWNUMBER", i+"");
			if(wExpander!=null && WebObjectUtil.isElementPresent(wExpander) && (WebObjectUtil.isElementPresent(wParentFolder)))
			{
				bFlag=true;
				iRowNo=i;
				break;
			}
		}
		
		if(bFlag)
		{
			//Verifying Parent folder should not have Delete if it contain Child
			CustomWebElementUtil.loadCustomElement(FirewallPF.getNav_GOMServiceTableParent(), "table");
			wParentRow=CustomWebElementUtil.getRowAsWebElement(iRowNo);
			WebObjectUtil.clickElement(wParentRow);
			wDelete=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.DELETE.IMAGE", "PARAMETER_ROWNUMBER", iRowNo+"");
			String sDeleteClass=wDelete.getAttribute("class");
		//	bDelete=WebObjectUtil.verifyElementNOTPresent(wDelete);
			bDelete=sDeleteClass.contains("disabled");
			FrameworkUtil.updateCustomResultBasedOnStatus(bDelete, "Delete image not there for Parent Folder");
			
			
			//WebObjectUtil.clickElement(wParentFolder);
			WebObjectUtil.explicitWait(3);
			CustomWebElementUtil.loadCustomElement(FirewallPF.getNav_GOMServiceTableParent(), "table");
			wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.EXPANDER", "PARAMETER_ROWNUMBER", iRowNo+"");
			
			WebObjectUtil.clickElement(wExpander);
		}
		//incrementing the count by 1 and capturing the child name
		iRowNo=iRowNo+1;
		CustomWebElementUtil.loadCustomElement(FirewallPF.getNav_GOMServiceTableParent(), "table");
		wchildRow=CustomWebElementUtil.getRowAsWebElement(iRowNo);
		WebObjectUtil.clickElement(wchildRow);
		
		//Validating the Edit/Create button
		wEdit= WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.EDIT.IMAGE", "PARAMETER_ROWNUMBER", iRowNo+"");
		WebObjectUtil.isElementPresent(wEdit);
		wDelete=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.DELETE.IMAGE", "PARAMETER_ROWNUMBER", iRowNo+"");
		bDelete=WebObjectUtil.isElementPresent(wDelete);
		FrameworkUtil.updateCustomResultBasedOnStatus(bDelete, "Delete image not there for Parent Folder");
		
		//Logout
		LoginTestCase.nav_Logout();
		
	}		
	
	
	/*==============================================================
	TestScript  	: verifyGroupWithNewObjICMP
	Manual TestCase	: QAT-1341-WCP_2896 & 2592_TC_Group Object Management_Service Objects_Create_Object Group with "New Objects" Type-ICMP
	Description		: Verify that user is able to create Object group with new objects under Service Objects, object type-UDP, Service type-Source
	Author 			: Vivek Kumar
	Creation Date 	: 03/31/2016
	Release Name    : LefCourt_SP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=9)
	public void verifyGroupWithNewObjICMP()
	{
		String sNewObjServiceName,sNewObjObjectType,sGrpName,sGrpDesc,sNewObjServiceEnd;
		
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		PageFactory.initElements(driver, Common);
		
		FrameworkUtil.sTestCaseName = "verifyGroupWithNewObj";
		FrameworkUtil.sManualTestCaseName="QAT-1341-WCP_2896 & 2592_TC_Group Object Management_Service Objects_Create_Object Group with New Objects Type-ICMP";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		
		sNewObjServiceName=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.SERVICENAME");
		sNewObjObjectType=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.OBJECTTYPE.ICMP");
		
		sNewObjServiceName=sNewObjServiceName+"_"+FrameworkUtil.sTimeStamp;
		sGrpName=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.SERVICENAME");
		sNewObjServiceEnd=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.SERVICEEND.SOURCE");	
		sGrpName=sGrpName+"_"+ FrameworkUtil.sTimeStamp + "ICMP_Grp";
		sGrpDesc=sGrpName+"_ICMP_Description";
		
		try {
			// login to the navigator
			LoginTestCase.LoginAsQaautoUser();
					
			// navigating to the firewall page
			EVDC_FirewallTestCase.NavigateToFirewallPage();
			
			// wait for the feedback message not displayed
			LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
			
			//Clicking on GOM link and verifying its landing page
			WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
	
			//Create New Object using ICMP
			createNewObject(sNewObjServiceName,sNewObjObjectType,"Object Group",sGrpName,sGrpDesc,sNewObjServiceEnd);
			
			WebDriverUtil.refreshBrowser();
			LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
			
			WebObjectUtil.explicitWait(10);
			WebDriverUtil.refreshBrowser();
				
			//Clicking on GOM link and verifying its landing page
			WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
			WebObjectUtil.explicitWait(15);
			WebDriverUtil.refreshBrowser();
			
			//Clicking on GOM link and verifying its landing page
			WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
			
			WebObjectUtil.explicitWait(5);
			
			//Expanding the Services Object
			WebObjectUtil.clickElement(FirewallPF.getNav_ServiceObjectsExpander());
			WebObjectUtil.explicitWait(5);
			//Expanding the HS Service
			WebObjectUtil.clickElement(FirewallPF.getNav_ServiceExpander());
			
			verifyServiceObject(sGrpName);
			//Logout
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	
	/*==============================================================
	TestScript  	: verifyGroupWithNewObjTCPDest
	Manual TestCase	: QAT-924-WCP_2896 & 2592_TC_Group Object Management_Service Objects_Create_Object Group with "New Objects" Type-TCP
	Description		: Verify that user is able to create Object group with new objects under Service Objects, object type-TCP, Service type-Destination
	Author 			: Vivek Kumar
	Creation Date 	: 04/01/2016
	Release Name    : LefCourt_SP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=10)
	public void verifyGroupWithNewObjTCPDest()
	{

		String sNewObjServiceName,sNewObjObjectType,sGrpName,sGrpDesc,sNewObjServiceEnd;
		
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		PageFactory.initElements(driver, Common);
		
		FrameworkUtil.sTestCaseName = "verifyGroupWithNewObjTCPDest";
		FrameworkUtil.sManualTestCaseName="QAT-924-WCP_2896 & 2592_TC_Group Object Management_Service Objects_Create_Object Group with New Objects Type-TCP";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		
		sNewObjServiceName=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.SERVICENAME");
		sNewObjObjectType=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.OBJECTTYPE.TCP");
		sNewObjServiceName=sNewObjServiceName+"_"+FrameworkUtil.sTimeStamp + "_TCP_Grp";
		
		sGrpName=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.SERVICENAME");
		sNewObjServiceEnd=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.SERVICEEND.DESTINATION");
		sGrpName=sGrpName+"_"+ FrameworkUtil.sTimeStamp + "_TCP_Grp";
		sGrpDesc=sGrpName+"_Description";
		
		try {
			// login to the navigator
			LoginTestCase.LoginAsQaautoUser();
					
			// navigating to the firewall page
			EVDC_FirewallTestCase.NavigateToFirewallPage();
			
			// wait for the feedback message not displayed
			LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
			
			//Clicking on GOM link and verifying its landing page
			WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
	
			//Create New Object
			createNewObject(sNewObjServiceName,sNewObjObjectType,"Object Group",sGrpName,sGrpDesc,sNewObjServiceEnd);
			
			WebDriverUtil.refreshBrowser();
			LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
			
			WebObjectUtil.explicitWait(10);
			WebDriverUtil.refreshBrowser();
				
			//Clicking on GOM link and verifying its landing page
			WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
			WebObjectUtil.explicitWait(15);
			WebDriverUtil.refreshBrowser();
			
			//Clicking on GOM link and verifying its landing page
			WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
			
			WebObjectUtil.explicitWait(5);
			
			//Expanding the Services Object
			WebObjectUtil.clickElement(FirewallPF.getNav_ServiceObjectsExpander());
			WebObjectUtil.explicitWait(5);
			//Expanding the HS Service
			WebObjectUtil.clickElement(FirewallPF.getNav_ServiceExpander());
			

			verifyServiceObject(sGrpName);
			//Logout
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	TestScript  	: verifyGroupWithNewObjICMPDest
	Manual TestCase	: QAT-925-WCP_2896 & 2592_TC_Group Object Management_Service Objects_Create_Object Group with "New Objects" Type-ICMP
	Description		: Verify that user is able to create Object group with new objects under Service Objects, object type-ICMP, Service type-Destination
	Author 			: Vivek Kumar
	Creation Date 	: 04/01/2016
	Release Name    : LefCourt_SP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=11)
	public void verifyGroupWithNewObjICMPDest()
	{
	String sNewObjServiceName,sNewObjObjectType,sGrpName,sGrpDesc,sNewObjServiceEnd;
		
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		PageFactory.initElements(driver, Common);
		
		FrameworkUtil.sTestCaseName = "verifyGroupWithNewObjICMPDest";
		FrameworkUtil.sManualTestCaseName="QAT-925-WCP_2896 & 2592_TC_Group Object Management_Service Objects_Create_Object Group with New Objects Type-ICMP";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		
		sNewObjServiceName=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.SERVICENAME");
		sNewObjObjectType=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.OBJECTTYPE.ICMP");
		
		sNewObjServiceName=sNewObjServiceName+"_"+FrameworkUtil.sTimeStamp + "_ICMPDest_Grp";
		sGrpName=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.SERVICENAME");
		sNewObjServiceEnd=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.SERVICEEND.DESTINATION");	
		sGrpName=sGrpName+"_"+ FrameworkUtil.sTimeStamp + "_ICMPDest_Grp";
		sGrpDesc=sGrpName+"_ICMPDest_Description";
		
		try {
			// login to the navigator
			LoginTestCase.LoginAsQaautoUser();
					
			// navigating to the firewall page
			EVDC_FirewallTestCase.NavigateToFirewallPage();
			
			// wait for the feedback message not displayed
			LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
			
			//Clicking on GOM link and verifying its landing page
			WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
	
			//Create New Object using ICMP
			createNewObject(sNewObjServiceName,sNewObjObjectType,"Object Group",sGrpName,sGrpDesc,sNewObjServiceEnd);
			
			WebDriverUtil.refreshBrowser();
			LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
			
			WebObjectUtil.explicitWait(10);
			WebDriverUtil.refreshBrowser();
				
			//Clicking on GOM link and verifying its landing page
			WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
			WebObjectUtil.explicitWait(15);
			WebDriverUtil.refreshBrowser();
			
			//Clicking on GOM link and verifying its landing page
			WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
			
			WebObjectUtil.explicitWait(5);
			
			//Expanding the Services Object
			WebObjectUtil.clickElement(FirewallPF.getNav_ServiceObjectsExpander());
			WebObjectUtil.explicitWait(5);
			//Expanding the HS Service
			WebObjectUtil.clickElement(FirewallPF.getNav_ServiceExpander());
			
			verifyServiceObject(sGrpName);
			
			//Logout
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	TestScript  	: verifyGroupWithNewObjTCP
	Manual TestCase	: QAT-923-WCP_2896 & 2592_TC_Group Object Management_Service Objects_Create_Object Group with "New Objects" Type-TCP
	Description		: Verify that user is able to create Object group with new objects under Service Objects, object type-TCP, Service type-Source
	Author 			: Vivek Kumar
	Creation Date 	: 04/01/2016
	Release Name    : LefCourt_SP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=12)
	public void verifyGroupWithNewObjTCP()
	{
		String sNewObjServiceName,sNewObjObjectType,sGrpName,sGrpDesc,sNewObjServiceEnd;
		
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		PageFactory.initElements(driver, Common);
		
		FrameworkUtil.sTestCaseName = "verifyGroupWithNewObjTCP";
		FrameworkUtil.sManualTestCaseName="QAT-923-WCP_2896 & 2592_TC_Group Object Management_Service Objects_Create_Object Group with New Objects Type-TCP";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		
		sNewObjServiceName=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.SERVICENAME");
		sNewObjObjectType=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.OBJECTTYPE.TCP");
		sNewObjServiceName=sNewObjServiceName+"_"+FrameworkUtil.sTimeStamp + "TCP_Grp";
		
		sGrpName=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.SERVICENAME");
		sNewObjServiceEnd=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.SERVICEEND.SOURCE");
		sGrpName=sGrpName+"_"+ FrameworkUtil.sTimeStamp + "TCP_Grp";
		sGrpDesc=sGrpName+"_Description";
		
		try {
			// login to the navigator
			LoginTestCase.LoginAsQaautoUser();
					
			// navigating to the firewall page
			EVDC_FirewallTestCase.NavigateToFirewallPage();
			
			// wait for the feedback message not displayed
			LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
			
			//Clicking on GOM link and verifying its landing page
			WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
	
			//Create New Object
			createNewObject(sNewObjServiceName,sNewObjObjectType,"Object Group",sGrpName,sGrpDesc,sNewObjServiceEnd);
			
			WebDriverUtil.refreshBrowser();
			LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
			
			WebObjectUtil.explicitWait(10);
			WebDriverUtil.refreshBrowser();
				
			//Clicking on GOM link and verifying its landing page
			WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
			WebObjectUtil.explicitWait(15);
			WebDriverUtil.refreshBrowser();
			
			//Clicking on GOM link and verifying its landing page
			WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
			
			WebObjectUtil.explicitWait(5);
			
			//Expanding the Services Object
			WebObjectUtil.clickElement(FirewallPF.getNav_ServiceObjectsExpander());
			WebObjectUtil.explicitWait(5);
			//Expanding the HS Service
			WebObjectUtil.clickElement(FirewallPF.getNav_ServiceExpander());
			

			verifyServiceObject(sGrpName);
			//Logout
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	
	/*==============================================================
	TestScript  	: verifyCreateObjectUsingICMPDest
	Manual TestCase	:  QAT-1346 - WCP_2896 & 2592_Group Object Management_Service Objects_Create_New Object under Parent Service_Type=ICMP
	Description		: Verify create object functionality when object Type=ICMP
	Author 			: Vivek Kumar
	Creation Date 	: 03/16/2016
	Release Name    : LefCourt_SP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=13)
	public void verifyCreateObjectUsingICMPDest()
	{
		String sNewObjServiceName,sNewObjObjectType,sNewObjServiceEnd;
		
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		PageFactory.initElements(driver, Common);
		
		FrameworkUtil.sTestCaseName = "verifyCreateObjectUsingICMPDest";
		FrameworkUtil.sManualTestCaseName=" QAT-1346-WCP_2896 & 2592_Group Object Management_Service Objects_Create_New Object under Parent Service_Type=ICMP";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		
		sNewObjServiceName=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.SERVICENAME");
		sNewObjObjectType=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.OBJECTTYPE.ICMP");
		sNewObjServiceEnd=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.SERVICEEND.DESTINATION");

		
		sNewObjServiceName=sNewObjServiceName+"_"+FrameworkUtil.sTimeStamp+"_ICMP";
		
		try {
			// login to the navigator
			LoginTestCase.LoginAsQaautoUser();
					
			// navigating to the firewall page
			EVDC_FirewallTestCase.NavigateToFirewallPage();
			
			// wait for the feedback message not displayed
			LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
			
			//Clicking on GOM link and verifying its landing page
			WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
	
			//Create New Object using ICMP
			createNewObject(sNewObjServiceName,sNewObjObjectType,"Object",null,null,sNewObjServiceEnd);
			
			WebDriverUtil.refreshBrowser();
			LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
			
			WebObjectUtil.explicitWait(10);
			WebDriverUtil.refreshBrowser();
				
			//Clicking on GOM link and verifying its landing page
			WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
			WebObjectUtil.explicitWait(15);
			WebDriverUtil.refreshBrowser();
			
			//Clicking on GOM link and verifying its landing page
			WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
			
			WebObjectUtil.explicitWait(5);
			
			//Expanding the Services Object
			WebObjectUtil.clickElement(FirewallPF.getNav_ServiceObjectsExpander());
			WebObjectUtil.explicitWait(5);
			//Expanding the HS Service
			WebObjectUtil.clickElement(FirewallPF.getNav_ServiceExpander());
			
			verifyServiceObject(sNewObjServiceName);
			
			deleteObject(sNewObjServiceName);
			
			//Logout
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	/*==============================================================
	TestScript  	: verifyCreateObjectUsingUDPDest
	Manual TestCase	:  QAT-1344-WCP_2896 & 2592_Group Object Management_Service Objects_Create_New Object under Parent Service_Type=UDP
	Description		: Verify create object functionality when object Type=UDP
	Author 			: Vivek Kumar
	Creation Date 	: 03/16/2016
	Release Name    : LefCourt_SP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=14)
	public void verifyCreateObjectUsingUDPDest()
	{
		String sNewObjServiceName,sNewObjObjectType,sNewObjServiceEnd;
		
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		PageFactory.initElements(driver, Common);
		
		FrameworkUtil.sTestCaseName = "verifyCreateObjectUsingUDPDest";
		FrameworkUtil.sManualTestCaseName="QAT-1344-WCP_2896 & 2592_Group Object Management_Service Objects_Create_New Object under Parent Service_Type=UDP";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		
		sNewObjServiceName=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.SERVICENAME");
		sNewObjObjectType=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.OBJECTTYPE.UDP");
		
		sNewObjServiceEnd=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.SERVICEEND.DESTINATION");
		
		sNewObjServiceName=sNewObjServiceName+"_"+FrameworkUtil.sTimeStamp + "_UDP";
		
		try {
			// login to the navigator
			LoginTestCase.LoginAsQaautoUser();
					
			// navigating to the firewall page
			EVDC_FirewallTestCase.NavigateToFirewallPage();
			
			// wait for the feedback message not displayed
			LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
			
			//Clicking on GOM link and verifying its landing page
			WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
	
			//Create New Object using UDP
			createNewObject(sNewObjServiceName,sNewObjObjectType,"Object",null,null,sNewObjServiceEnd);
			
			WebDriverUtil.refreshBrowser();
			LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
			
			WebObjectUtil.explicitWait(10);
			WebDriverUtil.refreshBrowser();
				
			//Clicking on GOM link and verifying its landing page
			WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
			WebObjectUtil.explicitWait(15);
			WebDriverUtil.refreshBrowser();
			
			//Clicking on GOM link and verifying its landing page
			WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
			
			WebObjectUtil.explicitWait(5);
			
			//Expanding the Services Object
			WebObjectUtil.clickElement(FirewallPF.getNav_ServiceObjectsExpander());
			WebObjectUtil.explicitWait(5);
			//Expanding the HS Service
			WebObjectUtil.clickElement(FirewallPF.getNav_ServiceExpander());
			
			verifyServiceObject(sNewObjServiceName);
			
			deleteObject(sNewObjServiceName);
			
			//Logout
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	TestScript  	: verifyCreateGrpObjectUsingUDPDest
	Manual TestCase	:  QAT-922-WCP_2896 & 2592_TC_Group Object Management_Service Objects_Create_Object Group with "New Objects" Type-UDP
	Description		: Verify create object functionality when object Type=UDP
	Author 			: Vivek Kumar
	Creation Date 	: 03/16/2016
	Release Name    : LefCourt_SP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=14)
	public void verifyCreateGrpObjectUsingUDPDest()
	{
		String sNewObjServiceName,sNewObjObjectType,sNewObjServiceEnd,sGrpName,sGrpDesc;
		
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		PageFactory.initElements(driver, Common);
		
		FrameworkUtil.sTestCaseName = "verifyCreateGrpObjectUsingUDPDest";
		FrameworkUtil.sManualTestCaseName="QAT-922-WCP_2896 & 2592_TC_Group Object Management_Service Objects_Create_Object Group with New Objects Type-UDP";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		
		sNewObjServiceName=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.SERVICENAME");
		sNewObjObjectType=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.OBJECTTYPE.UDP");
		
		sNewObjServiceEnd=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.SERVICEEND.DESTINATION");
		
		sNewObjServiceName=sNewObjServiceName+"_"+FrameworkUtil.sTimeStamp+ "_UDP_Grp";
		sGrpName=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.SERVICENAME");
		
		sGrpName=sGrpName+"_"+ FrameworkUtil.sTimeStamp+ "_UDP_Grp";
		sGrpDesc=sGrpName+"_UDP_Description";
		
		try {
			// login to the navigator
			LoginTestCase.LoginAsQaautoUser();
					
			// navigating to the firewall page
			EVDC_FirewallTestCase.NavigateToFirewallPage();
			
			// wait for the feedback message not displayed
			LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
			
			//Clicking on GOM link and verifying its landing page
			WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
	
			//Create New Object using UDP
			createNewObject(sNewObjServiceName,sNewObjObjectType,"Object Group",sGrpName,sGrpDesc,sNewObjServiceEnd);
			
			WebDriverUtil.refreshBrowser();
			LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
			
			WebObjectUtil.explicitWait(10);
			WebDriverUtil.refreshBrowser();
				
			//Clicking on GOM link and verifying its landing page
			WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
			WebObjectUtil.explicitWait(15);
			WebDriverUtil.refreshBrowser();
			
			//Clicking on GOM link and verifying its landing page
			WebObjectUtil.clickAndVerifyElement(FirewallPF.getNav_GOMLink(), FirewallPF.getNav_GOMText());
			
			WebObjectUtil.explicitWait(5);
			
			//Expanding the Services Object
			WebObjectUtil.clickElement(FirewallPF.getNav_ServiceObjectsExpander());
			WebObjectUtil.explicitWait(5);
			//Expanding the HS Service
			WebObjectUtil.clickElement(FirewallPF.getNav_ServiceExpander());
			
			verifyServiceObject(sGrpName);
			
				
			//Logout
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	
/*===================================================================================
							METHODS
===================================================================================*/
	
	/*==============================================================
	Method Name 	: createNewObject(ServiceName, sNewObjObjectType, Object or Object Group,Grp Name, Grp Desc)
	Description		: This will create a new object
	Author 			: Vivek Kumar
	Creation Date 	: 03/03/2016
	Pre-Requisites	:
	Revision History:
	Note			:
	==============================================================*/
	public static void createNewObject(String sNewObjServiceName,String sNewObjObjectType,String sObjectType,String sGrpName,String sGrpDesc,String sNewObjServiceEnd)
	{
		int iRowCnt,iRowNo = 0;
		String sText,sPortStartRange,sPortEndrange,sUlXpath,sNewObjType,sServiceEnd,sServiceEndList,sPortRngeError;
		String sNewObjectTypeList;
		String sActualFeedbackMsg,sExpectedFeedbackMsg;
		String sPortStartDisable,sPortEndDisable;
		WebElement wElement,wSearchDropdown;
		boolean bStatus=false,bPortStatus=false;
		
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		PageFactory.initElements(driver, Common);
		
		//sObjectType=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.OBJECTTYPE");
		
		
		sPortStartRange=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.STARTPORT");
		sPortEndrange=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.ENDPORT");
		sNewObjectTypeList=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.OBJECTTYPE.LIST");
		sServiceEndList=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.SERVICEEND.LIST");
		sUlXpath= (String)FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
		sPortRngeError=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.NEWOBJECT.PORTRANGE.ERROR");
		sExpectedFeedbackMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.FEEDBACK.MESSAGE");
		
		
		try {
			
			WebObjectUtil.explicitWait(5);
			//Expanding the Services Object
			WebObjectUtil.clickElement(FirewallPF.getNav_ServiceObjectsExpander());
			WebObjectUtil.explicitWait(5);
			//Expanding the Service
			WebObjectUtil.clickElement(FirewallPF.getNav_ServiceExpander());
			
			//Getting the total count of Service table
			CustomWebElementUtil.loadCustomElement(FirewallPF.getNav_GOMServiceTableParent(), "table");
			
			iRowCnt=CustomWebElementUtil.iRowCount;
			
			for(int i=1;i<=iRowCnt;i++)
			{
				sText=CustomWebElementUtil.getCellData(i, 1);
				//System.out.println(sText);
				WebObjectUtil.explicitWait(2);
				if(sText.equalsIgnoreCase("Service"))
				{
					wElement=CustomWebElementUtil.getRowAsWebElement(i);
					WebObjectUtil.clickElement(wElement);
					//Clicking on Service Create Image
					WebObjectUtil.clickElement(FirewallPF.getNav_GOMServiceCreateImg());
					//verifying Create Window
					WebObjectUtil.verifyElementPresent(FirewallPF.getNav_GOMServiceCreateWindow());
					//Creating Object
					WebObjectUtil.clickElement(FirewallPF.getNav_Service_ObjectTypeDropDownArrow());
					//Selecting Object from the dropdown
					wSearchDropdown = WebObjectUtil.getActiveElementasWebElement(sUlXpath);
					
					if(sObjectType.equalsIgnoreCase("Object"))
					{
						WebObjectUtil.selectCustomWebList(wSearchDropdown, 2);
					}
					else
					{
						WebObjectUtil.selectCustomWebList(wSearchDropdown, 1);
					}
					
					WebObjectUtil.selectCheckRadioBox(FirewallPF.getNav_Service_ObjectTypeNewObjRadioBtn());
					WebObjectUtil.SetValueEdit(FirewallPF.getNav_Service_ObjectTypeNewObjName(), sNewObjServiceName);
					
					//Validating the New Object Type list i.e. TCP, UDP and ICMP
					WebObjectUtil.clickElement(FirewallPF.getNav_Service_ObjectTypeNewObjTypeDropDownArrow());
					wSearchDropdown = WebObjectUtil.getActiveElementasWebElement(sUlXpath);
					sNewObjType=WebObjectUtil.getCustomWebListAllItemsAsText(wSearchDropdown);
					bStatus=WebObjectUtil.compareString(sNewObjType, sNewObjectTypeList, true);
					FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "New Object Type contains "+bStatus);
					
					if(sNewObjObjectType.equals("TCP"))
					{
						//Selecting TCP from the dropdown
						WebObjectUtil.selectCustomWebList(wSearchDropdown, sNewObjObjectType);
					}
					else if(sNewObjObjectType.equals("ICMP"))
					{
						//Selecting ICMP from the dropdown
						WebObjectUtil.selectCustomWebList(wSearchDropdown, sNewObjObjectType);
					}
					else if(sNewObjObjectType.equals("UDP"))
					{
						//Selecting ICMP from the dropdown
						WebObjectUtil.selectCustomWebList(wSearchDropdown, sNewObjObjectType);
					}
									
					bStatus=false;
					
					//Validating Service end list i.e. it contains Source and destination
					WebObjectUtil.clickElement(FirewallPF.getNav_Service_ObjectTypeServiceEndDropdownArrow());
					wSearchDropdown = WebObjectUtil.getActiveElementasWebElement(sUlXpath);
					sServiceEnd=WebObjectUtil.getCustomWebListAllItemsAsText(wSearchDropdown);
					bStatus=WebObjectUtil.compareString(sServiceEnd, sServiceEndList, true);
					FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Service End contains "+ sServiceEnd);
					//Selecting Source from dropdown
					WebObjectUtil.selectCustomWebList(wSearchDropdown, sNewObjServiceEnd);
						
					if(sNewObjObjectType.equals("TCP") ||sNewObjObjectType.equals("UDP") )
					{
						//Validating port error tool tip message i.e. it should show tool tip message if we enter start port greater than end port
						bStatus=false;
						WebObjectUtil.SetValueEdit(FirewallPF.getNav_Service_ObjectTypePortRangeStart(),"444");
						WebObjectUtil.SetValueEdit(FirewallPF.getNav_Service_ObjectTypePortRangeEnd(),"111");
						WebObjectUtil.explicitWait(1);
						bStatus=LefCourt_SP2TestCase_NMR.GOMCreateObjectToolTipMsg(FirewallPF.getNav_Service_ObjectTypePortRangeEnd(),"data-errorqtip",sPortRngeError);
						FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, sPortRngeError);
						WebObjectUtil.explicitWait(3);
						//Entering Start port and End Port	
						WebObjectUtil.SetValueEdit(FirewallPF.getNav_Service_ObjectTypePortRangeStart(),sPortStartRange);
						WebObjectUtil.SetValueEdit(FirewallPF.getNav_Service_ObjectTypePortRangeEnd(),sPortEndrange);
					}
					else if(sNewObjObjectType.equals("ICMP"))
					{
						sPortStartDisable=FirewallPF.getNav_Service_ObjectTypePortRangeStart().getAttribute("disabled");
						sPortEndDisable=FirewallPF.getNav_Service_ObjectTypePortRangeEnd().getAttribute("disabled");
						
						if((sPortStartDisable.equalsIgnoreCase("true")) && (sPortEndDisable.equalsIgnoreCase("true")))
						{
							bPortStatus=true;
						}
						
						FrameworkUtil.updateCustomResultBasedOnStatus(bPortStatus, "Port is disabled for ICMP");
					}
					
					WebObjectUtil.clickElement(FirewallPF.getNav_Service_ObjectTypeTransferRight());
					
					if(sObjectType.equalsIgnoreCase("Object Group"))
					{
						//Entering Grp Name
						WebObjectUtil.SetValueEdit(FirewallPF.getNav_Service_NewNameEdit(), sGrpName);
						WebObjectUtil.SetValueEdit(FirewallPF.getNav_Service_GrpDescTextArea(), sGrpDesc);
					}
					
					String sServiceNameRHS,sPortRangeRHS,sServiceEndRHS,sProtocolRHS,sPortRangeLHS;
					
					//Verifying the content @ RHS- Right hand side
					sServiceNameRHS=WebTableUtil.getCellData(FirewallPF.getNav_Service_CreateConfirmationTablRHS(), 1, 1);
					sPortRangeRHS=WebTableUtil.getCellData(FirewallPF.getNav_Service_CreateConfirmationTablRHS(), 1, 2);
					sServiceEndRHS=WebTableUtil.getCellData(FirewallPF.getNav_Service_CreateConfirmationTablRHS(), 1, 3);
					sProtocolRHS=WebTableUtil.getCellData(FirewallPF.getNav_Service_CreateConfirmationTablRHS(), 1, 4);
				
					bStatus=false;
					bStatus=WebObjectUtil.compareString(sServiceNameRHS, sNewObjServiceName, true);
					FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Service name verified to RHS table " + sServiceNameRHS);
					
					if(sNewObjObjectType.equals("TCP") ||sNewObjObjectType.equals("UDP") )
					{
						bStatus=false;
						sPortRangeLHS=sPortStartRange+"-"+sPortEndrange;
						bStatus=WebObjectUtil.compareString(sPortRangeRHS, sPortRangeLHS, true);
						FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Port range verified to RHS table " + sPortRangeRHS);
						
					}
					
					bStatus=false;
					bStatus=WebObjectUtil.compareString(sServiceEndRHS, sNewObjServiceEnd, true);
					FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Service End verified to RHS table " + sServiceEndRHS);
					
					bStatus=false;
					bStatus=WebObjectUtil.compareString(sProtocolRHS, sNewObjObjectType, true);
					FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Type/Protocol verified to RHS table " + sProtocolRHS);
					
					//Click on Save button
					WebObjectUtil.clickElement(FirewallPF.getNav_Service_ObjectTypeSaveBtn());
					if(WebObjectUtil.isElementPresent(Common.getNav_CommonPopUpBox()))
					{
						WebObjectUtil.explicitWait(5);
						WebObjectUtil.clickElement(Common.getNav_CommonPopUpOkBtn());
					}
					break;
				}
			}
			
			WebObjectUtil.explicitWait(5);
			//Verifying the feedback message
			if(sObjectType.equalsIgnoreCase("Object Group"))
			{
				sExpectedFeedbackMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.OBJECTGRP.FEEDBACK.MESSAGE");
			}
			
			bStatus=false;
			sActualFeedbackMsg=Common.getNav_UsrFeedBack().getText();
			bStatus=WebObjectUtil.compareString(sActualFeedbackMsg.trim(), sExpectedFeedbackMsg.trim(), true);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Object created feedback message - " + sActualFeedbackMsg);
			
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
	}
	
	
	/*==============================================================
	Method Name 	: deleteObject
	Description		: This will delete a object
	Author 			: Vivek Kumar
	Creation Date 	: 03/03/2016
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void deleteObject(String sNewObjServiceName)
	{

		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		PageFactory.initElements(driver, Common);
		
		int iRowCnt,iRowNo = 0;
		String sText,sExpectedFeedbackMsg,sActualFeedbackMsg;
		boolean bFlag=false,bStatus;
		WebElement wElement,wDynamicDelete,wDynamicEdit;
		
		try {
			//loading the table
			CustomWebElementUtil.loadCustomElement(FirewallPF.getNav_GOMServiceTableParent(), "table");
			//Getting the total count of Service table
			iRowCnt=CustomWebElementUtil.iRowCount;
			
			//Verifying the New Object 
			for(int j=1;j<=iRowCnt;j++)
			{
				sText=CustomWebElementUtil.getCellData(j, 1);
				//System.out.println(sText);
			//	WebObjectUtil.explicitWait(2);
				if(WebObjectUtil.compareString(sText, sNewObjServiceName, true))
				{
					bFlag=true;
					iRowNo=j;
					break;
				}
				
			 }
			FrameworkUtil.updateCustomResultBasedOnStatus(bFlag, "New Object - "+sNewObjServiceName + " found under Parent folder");
			//WebObjectUtil.clickElement(FirewallPF.getNav_GOMWindowClose());

			//Deleting 
			//loading the table
			CustomWebElementUtil.loadCustomElement(FirewallPF.getNav_GOMServiceTableParent(), "table");
			//Clicking on the row
			wElement=CustomWebElementUtil.getRowAsWebElement(iRowNo);
			WebObjectUtil.clickElement(wElement);
			//Verifying Delete and Edit image and Clicking on Delete image
//	wDynamicDelete= WebObjectUtil.getWebElementFromDynamicLocator("xpath", "//table[[PARAMETER_ROWNUMBER]//img[contains(@src,'delete')]", "PARAMETER_ROWNUMBER", iRowNo+"");
			wDynamicDelete=	WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.DELETE.IMAGE", "PARAMETER_ROWNUMBER", iRowNo+"");
			wDynamicEdit=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.EDIT.IMAGE", "PARAMETER_ROWNUMBER", iRowNo+"");
			
			WebObjectUtil.verifyElementPresent(wDynamicEdit);
			WebObjectUtil.verifyElementPresent(wDynamicDelete);
			
			WebObjectUtil.clickElement(wDynamicDelete);
			
			if(WebObjectUtil.isElementPresent(Common.getNav_CommonPopUpBox()))
			{
				WebObjectUtil.clickElement(Common.getNav_CommonPopUpOkBtn());
				WebObjectUtil.explicitWait(5);
				
				bStatus=false;
				sExpectedFeedbackMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.DELETE.FEEDBACK.MESSAGE");
				sActualFeedbackMsg=Common.getNav_UsrFeedBack().getText();
				bStatus=WebObjectUtil.compareString(sActualFeedbackMsg.trim(), sExpectedFeedbackMsg.trim(), true);
				FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Object deleted feedback message - " + sActualFeedbackMsg);
				WebDriverUtil.refreshBrowser();
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verifying Confirm Popup" , "fail","Confirm Popup not verified");
			}
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	
/*==============================================================
Method Name 	: createGrpObject
Description		: This will create empty folder
Author 			: Vivek Kumar
Creation Date 	: 03/04/2016
Pre-Requisites	:
Revision History:
==============================================================*/
	public static void createGrpObject(String sGrpName,String sGrpDesc,boolean bFromExistingObj)
	{
		
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		PageFactory.initElements(driver, Common);
		
		boolean bStatus=false,bMaxLength=false;
		WebElement wElement,wSearchDropdown,wFromExistingObject;
		String sText,sActualFeedbackMsg,sExpectedFeedbackMsg,sUlXpath,sNewNameMaxLength,sNewObjectname;
		int iRowCnt,iTableRowCnt;
		
		sExpectedFeedbackMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.OBJECTGRP.FEEDBACK.MESSAGE");
		sUlXpath= (String)FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
		
				
		try {
			WebObjectUtil.explicitWait(5);
			//Expanding the Services Object
			WebObjectUtil.clickElement(FirewallPF.getNav_ServiceObjectsExpander());
			WebObjectUtil.explicitWait(5);
			//Expanding the Service
			WebObjectUtil.clickElement(FirewallPF.getNav_ServiceExpander());
			
			//Getting the total count of Service table
			CustomWebElementUtil.loadCustomElement(FirewallPF.getNav_GOMServiceTableParent(), "table");
			
			iRowCnt=CustomWebElementUtil.iRowCount;
			
			for(int i=1;i<=iRowCnt;i++)
			{
				sText=CustomWebElementUtil.getCellData(i, 1);
				//System.out.println(sText);
				WebObjectUtil.explicitWait(2);
				if(sText.equalsIgnoreCase("Service"))
				{
					wElement=CustomWebElementUtil.getRowAsWebElement(i);
					WebObjectUtil.clickElement(wElement);
					//Clicking on Service Create Image
					WebObjectUtil.clickElement(FirewallPF.getNav_GOMServiceCreateImg());
					//verifying Create Window
					WebObjectUtil.verifyElementPresent(FirewallPF.getNav_GOMServiceCreateWindow());
					
					//Verifying Service new Name and Group name max length
					sNewObjectname=FirewallPF.getNav_Service_ObjectTypeNewObjName().getAttribute("maxlength").trim();
					bMaxLength=WebObjectUtil.compareString("64", sNewObjectname, true);
					FrameworkUtil.updateCustomResultBasedOnStatus(bMaxLength, "Maximum length of New Service Name is "+sNewObjectname);
					
					bMaxLength=false;
					sNewNameMaxLength=FirewallPF.getNav_Service_NewNameEdit().getAttribute("maxlength").trim();
					bMaxLength=WebObjectUtil.compareString("64", sNewNameMaxLength, true);
					FrameworkUtil.updateCustomResultBasedOnStatus(bMaxLength, "Maximum length of New Group Name is "+sNewNameMaxLength);
					//########################################################
					if(bFromExistingObj)
					{
						//Creating group folder using Existing Objects
						
						//Creating Object
						WebObjectUtil.clickElement(FirewallPF.getNav_Service_ObjectTypeDropDownArrow());
						//Selecting Object from the dropdown
						wSearchDropdown = WebObjectUtil.getActiveElementasWebElement(sUlXpath);
						WebObjectUtil.selectCustomWebList(wSearchDropdown, 1);
						
						//Select Radio Btn - from Existing group
						WebObjectUtil.selectCheckRadioBox(FirewallPF.getNav_Service_ObjectTypeFromExistingGrp());
						//Loading From Existing Grp table
						CustomWebElementUtil.loadCustomElement(FirewallPF.getNav_Service_FromExistingGrpTable(), "table");
						iTableRowCnt=CustomWebElementUtil.iRowCount;
						
						if(iTableRowCnt>2 || iTableRowCnt==2)
						{
							for(int iRowNo=1;iRowNo<=2;iRowNo++)
							{
								wFromExistingObject = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.CREATE.FROMEXISTINGOBJECT.ROW",  "PARAMETER_ROWNUMBER", 1+"");
								WebObjectUtil.clickElement(wFromExistingObject);
								WebObjectUtil.clickElement(FirewallPF.getNav_Service_ObjectTypeTransferRight());
							}
						}
					}
					
					
					
					//Entering Grp Name
					WebObjectUtil.SetValueEdit(FirewallPF.getNav_Service_NewNameEdit(), sGrpName);
					WebObjectUtil.SetValueEdit(FirewallPF.getNav_Service_GrpDescTextArea(), sGrpDesc);
					
					//Click on Save button
					WebObjectUtil.clickElement(FirewallPF.getNav_Service_ObjectTypeSaveBtn());
					if(WebObjectUtil.isElementPresent(Common.getNav_CommonPopUpBox()))
					{
						WebObjectUtil.explicitWait(5);
						WebObjectUtil.clickElement(Common.getNav_CommonPopUpOkBtn());
					}
					break;
				}
			}
			
			WebObjectUtil.explicitWait(5);
			//Verifying the feedback message
			sActualFeedbackMsg=Common.getNav_UsrFeedBack().getText();
			bStatus=WebObjectUtil.compareString(sActualFeedbackMsg.trim(), sExpectedFeedbackMsg.trim(), true);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Object created feedback message - " + sActualFeedbackMsg);
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
	}
	
/*==============================================================
Method Name 	: deleteEmptyFolder
Description		: This will delete empty folder
Author 			: Vivek Kumar
Creation Date 	: 03/04/2016
Pre-Requisites	:
Revision History:
==============================================================*/
	public static void deleteEmptyFolder(String sGrpName)
	{
		
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		PageFactory.initElements(driver, Common);
		
		int iRowCnt,iRowNo = 0;
		WebElement wExpander,wParentFolder,wElement,wDynamicDelete;
		String sExpectedFeedbackMsg,sActualFeedbackMsg,sText;
		boolean bStatus=false,bFlag=false;

		try {
			/*//Expanding the Services Object
			WebObjectUtil.clickElement(FirewallPF.getNav_ServiceObjectsExpander());
			
			//Expanding the HS Service
			WebObjectUtil.clickElement(FirewallPF.getNav_ServiceExpander());*/
			
			//Getting the total count of Service table
			CustomWebElementUtil.loadCustomElement(FirewallPF.getNav_GOMServiceTableParent(), "table");
			
			iRowCnt=CustomWebElementUtil.iRowCount;

			for(int i=1;i<=iRowCnt; i++)
			{
				sText=CustomWebElementUtil.getCellData(i, 1);
				
				WebObjectUtil.explicitWait(1);
				if(WebObjectUtil.compareString(sText, sGrpName, true))
				{
					wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.EXPANDER", "PARAMETER_ROWNUMBER", i+"");
					wParentFolder=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.PARENT.FOLDER", "PARAMETER_ROWNUMBER", i+"");
					if(wExpander==null && (WebObjectUtil.isElementPresent(wParentFolder)))
					{
						bFlag=true;
						iRowNo=i;
						break;
					}
				}
			}
			
			if(bFlag)
			{
				//Deleting 
				//loading the table
				CustomWebElementUtil.loadCustomElement(FirewallPF.getNav_GOMServiceTableParent(), "table");
				//Clicking on the row
				wElement=CustomWebElementUtil.getRowAsWebElement(iRowNo);
				WebObjectUtil.clickElement(wElement);
				//Clicking on Delete image
				wDynamicDelete=	WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.DELETE.IMAGE", "PARAMETER_ROWNUMBER", iRowNo+"");
				WebObjectUtil.clickElement(wDynamicDelete);
				//Clicking on comfirm popup window and verfying the feedback message
				if(WebObjectUtil.isElementPresent(Common.getNav_CommonPopUpBox()))
				{
					WebObjectUtil.clickElement(Common.getNav_CommonPopUpOkBtn());
					WebObjectUtil.explicitWait(5);
					
					sExpectedFeedbackMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.SERVICEOBJECTS.DELETE.OBJECTGRP.FEEDBACK.MESSAGE");
					sActualFeedbackMsg=Common.getNav_UsrFeedBack().getText();
					bStatus=WebObjectUtil.compareString(sActualFeedbackMsg.trim(), sExpectedFeedbackMsg.trim(), true);
					FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Object deleted feedback message - " + sActualFeedbackMsg);
					WebDriverUtil.refreshBrowser();
				}
				else
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verifying Confirm Popup" , "fail","Confirm Popup not verified");
				}
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verifying "+ sGrpName , "fail","Empty folder with name "+sGrpName+" not found");
			}
			
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
		
	}
	
	/*==============================================================
	Method Name 	: verifyServiceObject
	Description		: This will verify the service object
	Author 			: Vivek Kumar
	Creation Date 	: 03/15/2016
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static int verifyServiceObject(String sNewObjServiceName)
	{

		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		
		int iRowCnt,iRowNo,iRNumber=0;
		String sText;
		boolean bFlag=false;
		
		//loading the table
		CustomWebElementUtil.loadCustomElement(FirewallPF.getNav_GOMServiceTableParent(), "table");
		//Getting the total count of Service table
		iRowCnt=CustomWebElementUtil.iRowCount;
		
		//Verifying the New Object 
		for(int j=1;j<=iRowCnt;j++)
		{
			sText=CustomWebElementUtil.getCellData(j, 1);
			//System.out.println(sText);
		//	WebObjectUtil.explicitWait(2);
			if(WebObjectUtil.compareString(sText, sNewObjServiceName, true))
			{
				iRNumber=j;
				bFlag=true;
				break;
			}
			
		 }
		FrameworkUtil.updateCustomResultBasedOnStatus(bFlag, "New Object - "+sNewObjServiceName + " found under Parent folder");
		return iRNumber;
	}
	
	
	
	//update each @Test result in custom result file
	@AfterMethod
	public static void afterEachMethod(){
		FrameworkUtil.updateTestCaseStatusinResult();
		
	}

}

