package com.whs.navigator.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.commonUtil.WebTableUtil;
import com.whs.navigator.pagefactory.EntityBrowserPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.PhysicalServicesPageFactory;

public class PhysicalServicesTestCase {

	
	public static PhysicalServicesPageFactory PDC = new PhysicalServicesPageFactory();
	public static HomePageFactory_old Home = new HomePageFactory_old();
	public static EntityBrowserPageFactory Entity = new EntityBrowserPageFactory();
	
	 /*==============================================================
	 TestScript   		: verifyPDCNotDisplayed
	 Manual TestCase 	: [QAT-1352]verify that Physical DC portlet is not displayed
	 Description  		:  
	 Author    			: Arularasu
	 Creation Date 		: 06/07/2016
	 Release Name		: Corwin
	 Pre-Requisites 	:
	 Revision History	:
	 ==============================================================*/
	@Test(priority=1)
	public void verifyPDCNotDisplayed(){
	
		FrameworkUtil.sTestCaseName = "verifyPDCNotDisplayed";
		FrameworkUtil.sManualTestCaseName="[QAT-1352]verify that Physical DC portlet is not displayed";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		PageFactory.initElements(WebDriverUtil.getDriver(), PDC);
		LoginTestCase_Old1.LoginAsEntity04User();
		WebObjectUtil.verifyElementNOTPresent(PDC.getNav_PDCName());
		
		LoginTestCase_Old1.nav_Logout();
		
	}
	
	
	 /*==============================================================
	 TestScript   		: verifyStorageAndDeviceDetailsOnPDC
	 Manual TestCase 	: [QAT-1351,QAT-972,QAT-974,QAT-971]verify that Physical DC portlet along with Allocated and Committed values are displayed
	 						Verify Device Monitor link on Physical DC leads to EM7 page
	 Description  		:  
	 Author    			: Arularasu
	 Creation Date 		: 06/07/2016
	 Release Name		: Corwin
	 Pre-Requisites 	:
	 Revision History	:
	 ==============================================================*/
	@Test(priority=2)
	public void verifyStorageAndDeviceDetailsOnPDC(){
		String sAllocated,sCommitted;
		
		
		
		FrameworkUtil.sTestCaseName = "verifyStorageAndDeviceDetailsOnPDC";
		FrameworkUtil.sManualTestCaseName="[QAT-1351,QAT-972,QAT-974,QAT-971]verify that Physical DC portlet along with Allocated and Committed values are displayed";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		PageFactory.initElements(WebDriverUtil.getDriver(), PDC);
		LoginTestCase_Old1.LoginAsEntity03User();
		WebObjectUtil.scrollElementAtPageCenter(PDC.getNav_PDCName());
		WebObjectUtil.verifyElementPresent(PDC.getNav_PDCName());
		WebObjectUtil.verifyElementPresent(PDC.getNav_PDCStorageText());
		WebObjectUtil.verifyElementPresent(PDC.getNav_PDCAllocated());
		sAllocated = PDC.getNav_PDCAllocated().getText();
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Allocated value", "Done", "PDC Allocated Value:" + sAllocated);
		//QAT-1359
		FrameworkUtil.updateCustomResultBasedOnStatus(sAllocated.contains("GB"), "Verify Allocated value in GB and Actual:"+sAllocated);
		
		WebObjectUtil.verifyElementPresent(PDC.getNav_PDCCommitted());
		sCommitted = PDC.getNav_PDCCommitted().getText();
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Committed value", "Done", "PDC Committed Value:" + sCommitted);
		//QAT-1359
		FrameworkUtil.updateCustomResultBasedOnStatus(sCommitted.contains("GB"), "Verify Committed value in GB and Actual:"+sCommitted);
		
		//QAT-971
		EM7TestCase.verifyCloseEM7LoginPage(PDC.getNav_PDCDeviceMonitorLink());
		
		LoginTestCase_Old1.nav_Logout();
		
	}
	
	
	
	 /*==============================================================
	 TestScript   		: verifyPDCNameFormat
	 Manual TestCase 	: [QAT-1359]Verify PDC header, Name and name format
	 Description  		:  
	 Author    			: Arularasu
	 Creation Date 		: 06/08/2016
	 Release Name		: Corwin
	 Pre-Requisites 	:
	 Revision History	:
	 ==============================================================*/
	@Test(priority=3)
	public void verifyPDCNameFormat(){
	 
		
		
		String sPDCName,sPDCHeader,sPDCHeaderExpected;
		FrameworkUtil.sTestCaseName = "verifyPDCNameFormat";
		FrameworkUtil.sManualTestCaseName="[QAT-1359]Verify PDC header, Name and name format";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		PageFactory.initElements(WebDriverUtil.getDriver(), PDC);
		//Step-1
		LoginTestCase_Old1.LoginAsEntity03User();
		WebObjectUtil.scrollElementAtPageCenter(PDC.getNav_PDCName());
		//Step-2
		WebObjectUtil.verifyElementPresent(PDC.getNav_PhysicalServicesHeaderIcon());
		
		sPDCHeader = PDC.getNav_PhysicalServicesHeader().getText();
		FrameworkUtil.updateCustomResultBasedOnStatus(sPDCHeader.contains("Physical Services"), "Verify PDC header  and Actual:"+sPDCHeader);
		
		//Step-3
		WebObjectUtil.verifyElementPresent(PDC.getNav_PDCNameIcon());
		
		sPDCName = PDC.getNav_PDCName().getText();
		sPDCHeaderExpected = (String)FrameworkUtil.dictPropertyData.get("NAV.PDC.NAME.LOCATION.PART");
		FrameworkUtil.updateCustomResultBasedOnStatus(sPDCName.contains(sPDCHeaderExpected), "Verify PDC name contains location and Actual is:"+sPDCName);
		
		//Step-4  - covered in verifyAllocatedCommittedDeviceDisplayedOnPDC
		
		LoginTestCase_Old1.nav_Logout();
		
	}
	
	/*==============================================================
	TestScript  	: VerifyPhysicalDCPortlet
	Manual TestCase	: QAT-1473-WCP_4381_TC_1.4_White List for Physical DC portlet on landing page
	Description		: Verify the Physical DC portlet displays on landing page only if the org is whitelisted. 
	Author 			: Priyanka
	Creation Date 	: 06/08/2016
	Pre-Requisites	:
	Release Name    : Corwin
	Revision History:
	==============================================================*/
		@Test(priority=4)
		public void VerifyPhysicalDCPortlet()
		{
			WebDriver driver = WebDriverUtil.getDriver();
			
			PageFactory.initElements(driver, PDC);
			
			try {
				FrameworkUtil.sTestCaseName = "VerifyPhysicalDCPortlet";
				FrameworkUtil.sManualTestCaseName="QAT-1473-WCP_4381_TC_1.4_White List for Physical DC portlet on landing page";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

			    LoginTestCase_Old1.LoginAsEntity03User();
			    WebObjectUtil.explicitWait(10);
			    WebObjectUtil.scrollToElement(PDC.getNav_PhysicalServicePortletArea());
				WebObjectUtil.verifyElementPresent(PDC.getNav_PhysicalServicePortletArea());
				VerifyPDCIcons();
				LoginTestCase_Old1.nav_Logout();
				LoginTestCase_Old1.LoginAsEntity04User();
				WebObjectUtil.explicitWait(5);
				WebObjectUtil.verifyElementNOTPresent(PDC.getNav_PhysicalServicePortletArea());
				LoginTestCase_Old1.nav_Logout();
			}

			catch (Exception e) {
						LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
					
					}
					}

/*==============================================================
TestScript  	: VerifyPhysicalDCPortletData
Manual TestCase	: QAT-397_QAT-394_QAT_970-WCP_4381_TC_1.1_Physical DC portlet on landing page data display
             WCP_4381_TC_1.0_Physical DC portlet on landing page
             WCP_4381_TC_1.3_Physical DC portlet on landing page data display for Firewalls, Load Balancers, Servers=-DB Verification
Description		: Verify the Physical DC portlet displays on landing page only if the org is whitelisted. 
Author 			: Priyanka
Creation Date 	: 06/08/2016
Pre-Requisites	:
Release Name    : Corwin
Revision History:
==============================================================*/
@Test(priority=5)
public void VerifyPhysicalDCPortletData()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, PDC);
	
	
	try {
		String sActualPortletName,sPortletName,sFirewallCount,sLBCount,sServerCount;
	    sPortletName=(String)FrameworkUtil.dictPropertyData.get("NAV.PDC.PORTLET.NAME");
		FrameworkUtil.sTestCaseName = "VerifyPhysicalDCPortletName";
		FrameworkUtil.sManualTestCaseName="QAT-397-WCP_4381_TC_1.1_WCP_4381_TC_1.0_WCP_4381_TC_1.3_WCP_4381_TC_1.3_";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

	    LoginTestCase_Old1.LoginAsEntity03User();
	    WebObjectUtil.explicitWait(10);
	    WebObjectUtil.scrollToElement(PDC.getNav_PhysicalServicePortletArea());
	    WebObjectUtil.verifyElementPresent(PDC.getNav_PhysicalServicePortletArea());
	    sActualPortletName=(PDC.getNav_PhysicalServicesHeaderTitle()).getText().trim();
	    if(sPortletName.equalsIgnoreCase(sActualPortletName))
           {
        	   FrameworkUtil.updateCustomResultBasedOnStatus(true, "Shared Value has been changed to EVDC");
           }
           else{
        	   FrameworkUtil.updateCustomResultBasedOnStatus(false, "Shared Value has not been changed to EVDC");
           }
	    WebObjectUtil.verifyElementPresent(PDC.getNav_PDCFirewallCount());
	    WebObjectUtil.verifyElementPresent(PDC.getNav_PDCLoadBalancersCount());
	    WebObjectUtil.verifyElementPresent(PDC.getNav_PDCServersCount());
	    VerifyPDCIcons();
	    sFirewallCount=PDC.getNav_PDCFirewallCount().getText();
	    sLBCount=PDC.getNav_PDCLoadBalancersCount().getText();
	    sServerCount=PDC.getNav_PDCServersCount().getText();
	    FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Firewall Count is"+""+sFirewallCount, "LoadBalancer Count is"+""+sLBCount, "Server Count is : " + sServerCount);
	    LoginTestCase_Old1.nav_Logout();
	}

	catch (Exception e) {
				LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
			
			}
			}
	
/*==============================================================
	TestScript 		: verifyPhysicalDCPortletObjects
	Manual TestCase	: QAT-294
	Description		: Verify that Physical DC portlet is displayed and verify that the counts for Servers, Load Balancers, Firewalls along with Storage and Device monitor link are displayed.
	Author 			: QAA04
	Creation Date 	: 06/08/2015
	release Name    : Corwin
	Pre-Requisites	:
	Revision History:
	==============================================================*/
@Test(priority=6)
public void verifyPhysicalDCPortletObjects(){
	String sFLCOrgData,sSLCOrgData,sServers,sLoadBalancers,sFirewall;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, Entity);
	PageFactory.initElements(driver, Home);
	PageFactory.initElements(driver, PDC);
	try{
	FrameworkUtil.sTestCaseName="verifyPhysicalDCPortletObjects";
	FrameworkUtil.sManualTestCaseName="(QAT-294) Corwin - Verify that Physical DC portlet is displayed and verify that the counts for Servers, Load Balancers, Firewalls along with Storage and Device monitor link are displayed.";
	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	
	// login to the navigator
	LoginTestCase_Old1.LoginAsEntity01User();
	
	// select org from entity browser
	 sFLCOrgData = (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY02");
      sSLCOrgData= (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.TSTENTITY03");
    
     WebObjectUtil.clickElement(Entity.getNav_EntityBrowserLink());
    
     EntityBrowserTestCase.selectOrgFromAllLevelsEB(sFLCOrgData, sSLCOrgData,"", "");
     WebObjectUtil.clickElement(Entity.getNav_OrgNameTitleLink());
     
     // verifying the org title
     WebObjectUtil.VerifyTextUnderElement(Home.getNav_OrgNameTitle(), sSLCOrgData);
  
     WebObjectUtil.verifyElementPresent(PDC.getNav_PhysicalServicesPortlet());
     
     sServers = WebTableUtil.getCellData(PDC.getNav_PDCWebTableParent(), 1, 2);
     FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Serveers count in PDC portlet", "pass", "The count is -" +sServers);
     
     sLoadBalancers = WebTableUtil.getCellData(PDC.getNav_PDCWebTableParent(), 1, 4);
     FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "LoadBalancers count in PDC portlet", "pass", "The count is -" +sLoadBalancers);
     
     sFirewall = WebTableUtil.getCellData(PDC.getNav_PDCWebTableParent(), 3, 2);
     FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Firewall count in PDC portlet", "pass", "The count is -" +sFirewall);
     
     /*WebObjectUtil.verifyElementPresent(PhysicalDC.getNav_PhysicalServicesPortlet());
     sServers = PhysicalDC.getNav_PDCServersCount().getText();
     FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Serveers count in PDC portlet", "pass", "The count is -" +sServers);
	
     sLoadBalancers = PhysicalDC.getNav_PDCLoadBalancersCount().getText();
     FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "LoadBalancers count in PDC portlet", "pass", "The count is -" +sLoadBalancers);
	
     sFirewall = PhysicalDC.getNav_PDCFirewallCount().getText();
     FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Firewall count in PDC portlet", "pass", "The count is -" +sFirewall);
    	*/
     WebObjectUtil.verifyElementPresent(PDC.getNav_PDCStorageTitle());
	WebObjectUtil.verifyElementPresent(PDC.getNav_PDCDeviceMonitorLink());
	
	// log out
	LoginTestCase_Old1.nav_Logout();
	}catch (Exception e) {
		// TODO Auto-generated catch block
	    LoggerUtil.log_type_error( "Issue With-verifyPhysicalDCPortletObjects" +  e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
}	
//////////////////////////////////////////////Out of Scope Test cases Start/////////////////////////////////////
/*==============================================================
TestScript  	: verifyCommittedDataforPhysicalDCPortlet
Manual TestCase	: QAT-974 WCP_4381_TC_1.0_Physical DC portlet on landing page--Storage Data verification in Orders
Description		: verifying committed data in physical DC Portlet 
Author 			: QAA03
Creation Date 	: 31/05/2016
Release Name    : DNS_PF
Coverage        : First three steps are automated
Pre-Requisites	:
Revision History:
==============================================================*/
	
@Test(priority=7)
public void verifyCommittedDataforPhysicalDCPortlet()
{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,PDC);
				
				String sCommittedData=null;
				boolean bPhysicalDCStatus;
			
			
			try {
				FrameworkUtil.sTestCaseName = "verifyCommittedDataforPhysicalDCPortlet";
				FrameworkUtil.sManualTestCaseName="QAT-974 WCP_4381_TC_1.0_Physical DC portlet on landing page--Storage Data verification in Orders.";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
				
				//Login to Navigator with entity03a user
				LoginTestCase_Old1.LoginAsEntity03User();
				
				//Verifying Physical DC Portlet
				bPhysicalDCStatus =WebObjectUtil.verifyElementPresent(PDC.getNav_PhysicalDCPortlet());
				
				//Getting Committed data
				sCommittedData = PDC.getNav_PhysicalDC_CommittedData().getText();
				
				FrameworkUtil.updateCustomResultBasedOnStatus(bPhysicalDCStatus, "Physical DC Portlet in home page and committed data"+sCommittedData);
				
				
				//Logout from Navigator
				LoginTestCase_Old1.nav_Logout();
			
			   } catch (Exception e) {
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyCommittedDataforPhysicalDCPortlet", "warn", "catch block:" +e.getMessage());
		}
	}

/*==============================================================
TestScript  	: verifyAllocatedDataforPhysicalDCPortlet
Manual TestCase	: QAT-972 WCP_4381_TC_1.0_Physical DC portlet on landing page--Storage Data verification in VIPER SRM
Description		: verifying allocated data in physical DC Portlet
Author 			: QAA03
Creation Date 	: 31/05/2016
Release Name    : DNS_PF
Coverage        : First three steps are automated
Pre-Requisites	:
Revision History:
==============================================================*/
	
@Test(priority=8)
public void verifyAllocatedDataforPhysicalDCPortlet()
{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,PDC);
				
				String sAllocatedData=null;
				boolean bPhysicalDCStatus;
			
			
			try {
				FrameworkUtil.sTestCaseName = "verifyAllocatedDataforPhysicalDCPortlet";
				FrameworkUtil.sManualTestCaseName="QAT-972 WCP_4381_TC_1.0_Physical DC portlet on landing page--Storage Data verification in VIPER SRM.";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
				
				//Login to Navigator with entity03a user
				LoginTestCase_Old1.LoginAsEntity03User();
				
				//Verifying Physical DC Portlet
                bPhysicalDCStatus =WebObjectUtil.verifyElementPresent(PDC.getNav_PhysicalDCPortlet());
				
              //Getting Allocated data
                sAllocatedData = PDC.getNav_PhysicalDC_AllocatedData().getText();
				
				FrameworkUtil.updateCustomResultBasedOnStatus(bPhysicalDCStatus, "Physical DC Portlet in home page and allocated data"+sAllocatedData);
				
				
				//Logout from Navigator
				LoginTestCase_Old1.nav_Logout();
			
			   } catch (Exception e) {
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAllocatedDataforPhysicalDCPortlet", "warn", "catch block:" +e.getMessage());
		}
	}

//////////////////////////////////////////////Out of Scope Test cases Start/////////////////////////////////////


/*==============================================================
Method Name       : VerifyPDCIcons
Description       : it will verify that user can not see Ticket Page
Author            : Priyanka Rachupalli
Creation Date     : 11/23/2015
Pre-Requisites    :
Release           : Corwin
Revision History  :
==============================================================*/
public static void VerifyPDCIcons()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver,PDC);
	
	boolean bTicketStatus=true;
	
	try {
		WebObjectUtil.verifyElementPresent(PDC.getNav_PhysicalServicesIcon());
		WebObjectUtil.verifyElementPresent(PDC.getNav_PhysicalServicesHeader());
		WebObjectUtil.verifyElementPresent(PDC.getNav_PhysicalSrvcSecondaryIcon());
		WebObjectUtil.verifyElementPresent(PDC.getNav_PhysicalServicesLocationName());
		WebObjectUtil.verifyElementPresent(PDC.getNav_PhysicalServicesServerIcon());
		WebObjectUtil.verifyElementPresent(PDC.getNav_PhysicalServicesFirewallIcon());
		WebObjectUtil.verifyElementPresent(PDC.getNav_PhysicalServicesLoadBalIcon());
		WebObjectUtil.verifyElementPresent(PDC.getNav_PhysicalServicesStorageIcon());
		WebObjectUtil.verifyElementPresent(PDC.getNav_PhysicalServicesDeviceIcon());
		WebObjectUtil.verifyElementPresent(PDC.getNav_PhysicalServicesDeviceLink());
	}

	catch (Exception e) {
				LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
			
			}
			}


	//update each @Test result in custom result file
	@AfterMethod
	public void afterEachMethod(){
		FrameworkUtil.updateTestCaseStatusinResult();
		FrameworkUtil.sTestExecutionStatus = true;
		WebDriverUtil.quitWebDriver();
	}
	
	
	
}
