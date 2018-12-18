package com.whs.navigator.testcases.dev.old;

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
import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.IACPageFactory_NMR;
import com.whs.navigator.pagefactory.LoadBalancerPageFactory;
import com.whs.navigator.pagefactory.UserPermissionPageFactory;

public class LoadBalancersTestCase {

	     public static UserPermissionPageFactory UserPermission = new UserPermissionPageFactory();
	     public static HomePageFactory_old Home = new HomePageFactory_old();
	     public static EVDC_OverviewPageFactory EVDC_OverviewPF= new EVDC_OverviewPageFactory();
	     public static LoadBalancerPageFactory LoadBalancer = new LoadBalancerPageFactory();
	     public static IACPageFactory_NMR IAC_PF = new IACPageFactory_NMR();
	 
	     
	     
	     
/////////////_____________________ Hague test cases ________________________________ /////////////////////

	 /*==============================================================
   	TestScript 		: verifyVirtualIpTabUnderLoadBalancer
   	Manual TestCase	: QAT-288
   	Description		: Verifying the all objects under virtual-IP tab
   	Author 			: QAA04
   	Creation Date 	: 12/1/2015
   	release Name    : Hague
   	Pre-Requisites	:
   	Revision History:
   	==============================================================*/
    @Test(priority=1) 
    public void verifyVirtualIpTabUnderLoadBalancer() {
    	
    	WebDriver driver = WebDriverUtil.getDriver();
    	try {
  
    	PageFactory.initElements(driver, LoadBalancer);
    	//Sukur Babu. B Dated on 12/28/2015--Give proper meaning ful script name. Like in your case verifyAllObjsInVirtualIpTabUnderLoadBalancer
    	 FrameworkUtil.sTestCaseName ="verifyVirtualIpTabUnderLoadBalancer";
    	 FrameworkUtil.sManualTestCaseName ="(QAT-288)Hague-Verifying the all objects under virtual-IP tab";
    	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
    	/// Login to the navigator
    	LoginTestCase.LoginAsHawkeyeUser();
    	/// navigating to the load balancer page
    	NavigatingToLoadBalancerPage();
    	// verifying virtualIP tab objects
    	
    	VerifyVirtualIPTabObjects();
    	
     LoginTestCase.nav_Logout();
    	}
    	catch(Exception e){
    		LoggerUtil.log_type_error("Issue with verifyVirtualIpTabUnderLoadBalancer test case");
    		LoggerUtil.log_type_error(e.getMessage());
    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception accured", "fail", e.getMessage()+"null");
    	}
    	}
    
    
    /*==============================================================
   	TestScript 		: verifyPDFandCVSIconsUnderInstancesTab
   	Manual TestCase	: QAT-279
   	Description		: Verifying the PDF and CSV icons
   	Author 			: QAA04
   	Creation Date 	: 12/03/2015
   	release Name    : Hague
   	Pre-Requisites	:
   	Revision History:
   	
   	==============================================================*/ 
    @Test(priority=2) 
    public void verifyPDFandCVSIconsUnderInstancesTab() {
    	
    	try {
    	WebDriver driver = WebDriverUtil.getDriver();
    
    	PageFactory.initElements(driver, LoadBalancer);
    	 FrameworkUtil.sTestCaseName ="verifyPDFandCVSIconsUnderInstancesTab";
    	 FrameworkUtil.sManualTestCaseName ="(QAT-279)Hague-Verifying the PDF and CSV icons under instances tab";
    	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
    	// Login to the navigator
    	LoginTestCase.LoginAsHawkeyeUser();
    	// Navigating to the loadBalncer Page
    	NavigatingToLoadBalancerPage();
    	
    	WebObjectUtil.clickElement(LoadBalancer.getNavInstanceTab());
    	WebObjectUtil.explicitWait(5);
    	////Sukur Babu. B Dated on 12/28/2015--Clicking on PDF and CSV icons and verifying url or some attribute is missing.
    	WebObjectUtil.verifyElementPresent(LoadBalancer.getNavInstanceTab_PDFIcon());
    	WebObjectUtil.verifyElementPresent(LoadBalancer.getNavInstanceTab_CSVIcon());
     LoginTestCase.nav_Logout();
    	
    	}
    	catch(Exception e){
    		LoggerUtil.log_type_error("issue with verifyPDFandCVSIconsUnderInstancesTab test case");
    		LoggerUtil.log_type_error(e.getMessage());
    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception occured", "fail", e.getMessage()+"null");
    	}
    	}
	
    
    //Sukur Babu. B Dated on 12/28/2015-- Following test case is marked as Out of Scope as it is IAC related test case
    //Not reviewed
    /*==============================================================
   	TestScript 		: VerifyCahngedIPAddressInInstancesTab
   	Manual TestCase	: QAT-317
   	Description		: verify the Changed ip address is reflected in the navigator or not for the instance tab
   	Author 			: QAA04
   	Creation Date 	: 12/09/2015
   	release Name    : Hague
   	Pre-Requisites	:
   	Revision History:
     Note :	IAC application related test case -- out of scope 
   	==============================================================*/ 
  //  @Test(priority=3)
    public static void VerifyCahngedIPAddressInInstancesTab() {
    	String sIACMenuItemSelect,sIACServiceItemSelect,sExpandServiceItem;
    	WebElement wIACMenuItemDropDrown,wExpandServiceItem;
    	try{
    	WebDriver driver = WebDriverUtil.getDriver();
    	PageFactory.initElements(driver, IAC_PF);
    	
    	
    	FrameworkUtil.sTestCaseName = "VerifyCahngedIPAddressInInstancesTab";
    	FrameworkUtil.sManualTestCaseName="(QAT-317) Change IP address in IAC App and verify its reflected navigator or not";
        FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
    /// Login to the navigator
        LoginTestCase.LoginAsHawkeyeUser();
    	/// navigating to the load balancer page
    	NavigatingToLoadBalancerPage();
    	// verifying the objects under instance table
    	verifyInstanceWebTablebuttons();
        /// login to IAC application
      // loging out 
    	LoginTestCase.nav_Logout();
    	// navigating to the IAC application
    	IACTestcase_NMR.IACLogin();
        /// selecting menu item
        sIACMenuItemSelect = (String) FrameworkUtil.dictPropertyData.get("NAV.IAC.SELECT.MENU.ITEM");
        IACTestcase_NMR.selectMenuItem(sIACMenuItemSelect);
        WebObjectUtil.clickElement(IAC_PF.getNavManageServiceItemsLink());
        WebObjectUtil.explicitWait(5);
       // expanding the service item 
        sIACServiceItemSelect = (String) FrameworkUtil.dictPropertyData.get("NAV.IAC.SERVICE.ITEM.EXPAND");
        IACTestcase_NMR.ExpandServiceItem(sIACServiceItemSelect);
       
       WebObjectUtil.explicitWait(5);
       WebObjectUtil.clickElement(IAC_PF.getNavLBMemberServiceItem());
      // sIAC_Service_IPAddress = (String) FrameworkUtil.dictPropertyData.get("NAV.IAC.SERVICE.ITEM.MANAGER.TABLE.IPADDRESS");
       // updating the ipAddress in IAC application
       IACTestcase_NMR.IAC_EditIPAdderess();
    // log out
       IACTestcase_NMR.IAC_Logout();
       
     // navigating to the navigator 
       LoginTestCase.LoginAsHawkeyeUser();
     	/// navigating to the load balancer page
    	NavigatingToLoadBalancerPage();
    	WebObjectUtil.clickElement(LoadBalancer.getNavInstanceTab());
    	WebObjectUtil.explicitWait(5);
    	VerifyReflectedIPAddressInInstancesTab();
    
    LoginTestCase.nav_Logout();
    	}
    	catch(Exception e) {
    		LoggerUtil.log_type_error("Issue with - VerifyCahngedIPAddressInInstancesTab");
    		LoggerUtil.log_type_error(e.getMessage());
    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage()+"null");
    	}
    	}
	
  //Sukur Babu. B Dated on 12/28/2015-- Following test case is marked as Out of Scope as it is IAC related test case
    //Not reviewed
    
    /*==============================================================
   	TestScript 		: VerifyCahngedIPAddressInPoolsTab
   	Manual TestCase	: QAT-331
   	Description		: verify the Changed ip address is reflected in the navigator or not for the pools tab
   	Author 			: QAA04
   	Creation Date 	: 12/9/2015
   	release Name    : Hague
   	Pre-Requisites	:
   	Revision History:
   	Note: IAC application related test case --out of scope
   	==============================================================*/ 
  //  @Test(priority=4)
    public static void VerifyCahngedIPAddressInPoolsTab() {
    	String sIACMenuItemSelect,sIACServiceItemSelect;
    	try {
    	WebDriver driver = WebDriverUtil.getDriver();
    	
    	PageFactory.initElements(driver, IAC_PF);
    	FrameworkUtil.sTestCaseName="VerifyCahngedIPAddressInPoolsTab";
    	FrameworkUtil.sManualTestCaseName="(QAT-331) Verify the changed ip address in the pools tab";
    	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
    	// login to the navigator
    	LoginTestCase.LoginAsHawkeyeUser();
     
    	
    	// navigating to the load balancers page
    	NavigatingToLoadBalancerPage();
    	// clickin on pools tab
    	WebObjectUtil.clickElement(LoadBalancer.getNavPoolsTab());
    	WebObjectUtil.explicitWait(5);
    	// verifying the refresh, edit, delete buttons
    	VerifyPoolsWebTableButtons();
    	// loging out
    	LoginTestCase.nav_Logout();
    	// navigating to the IAC application
    	IACTestcase_NMR.IACLogin();
        /// selecting menu item
        sIACMenuItemSelect = (String) FrameworkUtil.dictPropertyData.get("NAV.IAC.SELECT.MENU.ITEM");
        IACTestcase_NMR.selectMenuItem(sIACMenuItemSelect);
        WebObjectUtil.clickElement(IAC_PF.getNavManageServiceItemsLink());
        WebObjectUtil.explicitWait(5);
       // expanding the service item 
        sIACServiceItemSelect = (String) FrameworkUtil.dictPropertyData.get("NAV.IAC.SERVICE.ITEM.EXPAND");
        IACTestcase_NMR.ExpandServiceItem(sIACServiceItemSelect);
       
       WebObjectUtil.explicitWait(5);
       WebObjectUtil.clickElement(IAC_PF.getNavLBMemberServiceItem());
      // sIAC_Service_IPAddress = (String) FrameworkUtil.dictPropertyData.get("NAV.IAC.SERVICE.ITEM.MANAGER.TABLE.IPADDRESS");
       // updating the ipAddress in IAC application
       IACTestcase_NMR.IAC_EditIPAdderess();
     
       // log out
       IACTestcase_NMR.IAC_Logout();
     // navigating to the navigator 
       LoginTestCase.LoginAsHawkeyeUser();
      
       // clicking on home page popup window ok btn
   //	wOKBtn.click();
       /// navigating to the load balancer page
    	NavigatingToLoadBalancerPage();
    // clicking on pools tab
    	WebObjectUtil.clickElement(LoadBalancer.getNavPoolsTab());
    	WebObjectUtil.explicitWait(5);
    // verifying the changed ip address in pools tab
    	VerifyReflectedIPAddressInPoolsTab();
    // log out 
    	LoginTestCase.nav_Logout();
    
    	}
    	catch(Exception e) {
    		LoggerUtil.log_type_error("Issue with VerifyCahngedIPAddressInPoolsTab TestCase");
    		LoggerUtil.log_type_error(e.getMessage());
    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception occured", "fail", e.getMessage()+"null");
    		
    	}
    	}
    
  //Sukur Babu. B Dated on 12/28/2015-- Following test case is marked as Out of Scope as it is IAC related test case
    //Not reviewed
    /*==============================================================
   	TestScript 		: VerifyCahngedLBVirtualServerIPAddressInPoolsTab
   	Manual TestCase	: QAT-252
   	Description		: change the ip address in LBVirtual Server and verify its reflected in the pools tab
   	Author 			: QAA04
   	Creation Date 	: 12/9/2015
   	release Name    : Hague
   	Pre-Requisites	:
   	Revision History:
   	Note: IAC application related test case --out of scope
   	==============================================================*/ 
  // @Test(priority=5)
    public static void VerifyCahngedLBVirtualServerIPAddressInPoolsTab() {
    	String sIACMenuItemSelect,sIACServiceItemSelect;
    	try {
    	WebDriver driver = WebDriverUtil.getDriver();
    
    	PageFactory.initElements(driver, IAC_PF);
    	FrameworkUtil.sTestCaseName="VerifyCahngedLBVirtualServerIPAddressInPoolsTab";
    	FrameworkUtil.sManualTestCaseName="(QAT-252)change the ip address in LBVirtual Server and verify its reflected in the pools tab";
    	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
    	// login to the navigator
    	LoginTestCase.LoginAsHawkeyeUser();
       
    
    	// navigating to the load balancers page
    	NavigatingToLoadBalancerPage();
    	// clicking on pools tab
    	WebObjectUtil.clickElement(LoadBalancer.getNavPoolsTab());
    	WebObjectUtil.explicitWait(5);
    	// verifying the refresh, edit, delete buttons
    	VerifyPoolsWebTableButtons();
    	// loging out
    	LoginTestCase.nav_Logout();
    
     	// navigating to the IAC application
    	IACTestcase_NMR.IACLogin();
    	
        /// selecting menu item
        sIACMenuItemSelect = (String) FrameworkUtil.dictPropertyData.get("NAV.IAC.SELECT.MENU.ITEM");
        IACTestcase_NMR.selectMenuItem(sIACMenuItemSelect);
        WebObjectUtil.clickElement(IAC_PF.getNavManageServiceItemsLink());
        WebObjectUtil.explicitWait(5);
       // expanding the service item 
        sIACServiceItemSelect = (String) FrameworkUtil.dictPropertyData.get("NAV.IAC.SERVICE.ITEM.EXPAND");
        IACTestcase_NMR.ExpandServiceItem(sIACServiceItemSelect);
       
       WebObjectUtil.explicitWait(5);
       WebObjectUtil.clickElement(IAC_PF.getNavLBVirtualServerServiceItem());
       WebObjectUtil.explicitWait(5);
       // sIAC_Service_IPAddress = (String) FrameworkUtil.dictPropertyData.get("NAV.IAC.SERVICE.ITEM.MANAGER.TABLE.IPADDRESS");
       // updating the ipAddress in IAC application
       IACTestcase_NMR.IAC_EditIPAdderess();
    // log out
       IACTestcase_NMR.IAC_Logout();
    	
       // navigating to the navigator 
       LoginTestCase.LoginAsHawkeyeUser();
    // clicking on home page popup window ok btn
   //wOKBtn.click();
       /// navigating to the load balancer page
    	NavigatingToLoadBalancerPage();
    // clicking on pools tab
    	WebObjectUtil.clickElement(LoadBalancer.getNavPoolsTab());
    	WebObjectUtil.explicitWait(5);
    // verifying the changed ip address in pools tab
    	VerifyReflectedIPAddressInPoolsTab();
    // log out 
    	LoginTestCase.nav_Logout();
    }
    catch(Exception e) {
    	LoggerUtil.log_type_error("Issue with VerifyCahngedLBVirtualServerIPAddressInPoolsTab test case");
    	LoggerUtil.log_type_error(e.getMessage());
    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage()+"null");
    	
    }
    }
    
  //Sukur Babu. B Dated on 12/28/2015--Try Catch is missing
    /*==============================================================
   	TestScript 		: verifyEVDCPortletLoadBalancerLinks
   	Manual TestCase	: QAT-304
   	Description		: Click on LoadBalancer view link and verify its navigating to the loadbalancers page
   	Author 			: QAA04
   	Creation Date 	: 12/9/2015
   	release Name    : Hague
   	Pre-Requisites	:
   	Revision History:
   	
   	==============================================================*/
    @Test(priority=6)
    public static void verifyEVDCPortletLoadBalancerLinks() {
    	
    	
    	WebDriver driver =WebDriverUtil.getDriver();
    	
    	PageFactory.initElements(driver, LoadBalancer);
    	
    	FrameworkUtil.sTestCaseName="verifyEVDCPortletLoadBalancerLinks";
    	FrameworkUtil.sManualTestCaseName="(QAT-304)Hague -Click on LoadBalancer view link and verify its navigating to the loadbalancers page";
    	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
    	
    	//login to the navigator
    	LoginTestCase.LoginAsHawkeyeUser();
    	
    	
    	
    	WebObjectUtil.waitForElementPresent(LoadBalancer.getNavEVDCPortlet_LoadbalancerText());
    	String sText = LoadBalancer.getNavEVDCPortlet_LoadbalancerText().getText();
    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying the loadbalancer text in the evdc portlet", "pass", "load balancer text is - "+ sText);
    	
    	WebObjectUtil.clickElement(LoadBalancer.getNavEVDCPortlet_LoadBalancer_ViewLink());
    	
    	 WebObjectUtil.waitForElementPresent(LoadBalancer.getNavVirtualIpTab_AddVIPLink());
         WebObjectUtil.verifyElementPresent(LoadBalancer.getNavVirtualIpTab_AddVIPLink());
    	
         // log out 
         LoginTestCase.nav_Logout();
    }
    
    /*==============================================================
	TestScript  	: verifyLoadBalancerInstanceTabDisplayDetails
	Manual TestCase	: [QAT-270]- [WCP] EVDC - Load Balancers- Verifying Load Balancer Instance Tab Display Details 
	Description		: Verifying Load Balancer Instance Tab Display Details
	Author 			: QAA03
	Creation Date 	: 12/08/2015
	Release Name    : Hague
	Pre-Requisites	:
	Revision History:
==============================================================*/
	@Test(priority=101)
	public void verifyLoadBalancerInstanceTabDisplayDetails()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,EVDC_OverviewPF);
			PageFactory.initElements(driver,LoadBalancer);
			
			String sUserName=null,sPassword=null;
			int iRowNumber=1;
			WebElement wFirstRowExpander;
			
		try {
			FrameworkUtil.sTestCaseName = "verifyLoadBalancerInstanceTabDisplayDetails";
			FrameworkUtil.sManualTestCaseName="[QAT-270]- [WCP] EVDC - Load Balancers- Verifying Load Balancer Instance Tab Display Details";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HAWKEYE.USERID");
		    sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.PASSWORD");
		
            LoginTestCase.nav_Login(sUserName, sPassword);
			
			//Click on EVDC Name
          
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			
			//Click on Load Balancer link
			WebObjectUtil.clickAndVerifyElement((EVDC_OverviewPF.getNav_EVDCLBLink()),LoadBalancer.getNavVirtualIpTab());
			
			//clicking on Instance Tab
			WebObjectUtil.clickElement(LoadBalancer.getNavInstanceTab());
			
			verifyInstanceTabDetailsinLB();
			
			CustomWebElementUtil.loadCustomElement(LoadBalancer.getNavInstancesTableParent(), "table");
			wFirstRowExpander=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.INSTANCE.LOADBALANCER.EXPANDER", "PARAMETER_ROWNUMBER", iRowNumber+"");
			//Expanding first row
			WebObjectUtil.clickElement(wFirstRowExpander);
			WebObjectUtil.explicitWait(2);
			
			verifyRefreshEditDeletelinksinLBTabsRowExpander();
			
			//Logout from Navigator
			LoginTestCase.nav_Logout();
			
		   } catch (Exception e) {
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyLoadBalancerInstanceTabDisplayDetails", "warn", "catch block:" +e.getMessage());
		}
    }
	
	/*==============================================================
	TestScript  	: verifyLoadBalancerPageView
	Manual TestCase	: [QAT-259] [WCP] EVDC - Load Balancers Page details
	Description		: Verify Load Balancer page view and its tabs display on Load Balance page
	Author 			: QAA03
	Creation Date 	: 12/07/2015
	Release Name    : Hague
	Pre-Requisites	:
	Revision History:
==============================================================*/
	@Test(priority=102)
	public void verifyLoadBalancerPageView()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,Home);
			PageFactory.initElements(driver,EVDC_OverviewPF);
			PageFactory.initElements(driver,LoadBalancer);
			
			String sUserName=null,sPassword=null,sEVDCName=null,sEVDCSelector=null;
			boolean bStatus;
			
		
		
		try {
			FrameworkUtil.sTestCaseName = "verifyLoadBalancerPageView";
			FrameworkUtil.sManualTestCaseName="[QAT-259] [WCP] EVDC - Load Balancers Page Details";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HAWKEYE.USERID");
		    sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.PASSWORD");
		
			//Login to Navigator with devco1 user
			LoginTestCase.nav_Login(sUserName, sPassword);
			
			//Getting EVDC Name
			sEVDCName=EVDC_OverviewPF.getNav_EVDCname().getText();	
			
			//Click on EVDC Name
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			
			//Click on Load Balancer link
			WebObjectUtil.clickAndVerifyElement((EVDC_OverviewPF.getNav_EVDCLBLink()),LoadBalancer.getNavVirtualIpTab());
			
			//Verifying Tabs in the Load Balancer page
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNavVirtualIpTab());
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNavPoolsTab());
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNavInstanceTab());
			
			//Verifying Breadcrumb in the Load Balancer page
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_LoadBalancer_Breadcrumb());
			
			//Verifying EVDC Selector name with the EVDC name
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCOrgSelector());
			sEVDCSelector=EVDC_OverviewPF.getNav_EVDCOrgSelector().getText();
			bStatus=sEVDCName.equalsIgnoreCase(sEVDCSelector);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Data on EVDC selector and Data on EVDC name");
			
			
			//Logout from Navigator
			LoginTestCase.nav_Logout();
	
		   } catch (Exception e) {
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyLoadBalancerPageView", "warn", "catch block:" +e.getMessage());
		}
    }
	
	/*==============================================================
	TestScript  	: verifyLoadBalancerPoolsTabDisplayDetails
	Manual TestCase	:[QAT-255] [WCP] EVDC - Load Balancers- Verifying Load Balancer Pools Tab Display Details 
	Description		: Verifying Load Balancer Pools Tab Display Details
	Author 			: QAA03
	Creation Date 	: 12/11/2015
	Release Name    : Hague
	Pre-Requisites	:
	Revision History:
==============================================================*/
	@Test(priority=103)
	public void verifyLoadBalancerPoolsTabDisplayDetails()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,EVDC_OverviewPF);
			PageFactory.initElements(driver,LoadBalancer);
			
			String sUserName=null,sPassword=null;
			int iRowNumber=1;
			WebElement wFirstRowExpander;
		
		try {
			FrameworkUtil.sTestCaseName = "verifyLoadBalancerPoolsTabDisplayDetails";
			FrameworkUtil.sManualTestCaseName="[QAT-255] [WCP] EVDC - Load Balancers- Verifying Load Balancer Pools Tab Display Details";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HAWKEYE.USERID");
		    sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.PASSWORD");
		
            LoginTestCase.nav_Login(sUserName, sPassword);
			
			//Click on EVDC Name
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			
			//Click on Load Balancer link
			WebObjectUtil.clickAndVerifyElement((EVDC_OverviewPF.getNav_EVDCLBLink()),LoadBalancer.getNavVirtualIpTab());
			
			//Clicking on Instance Tab
			WebObjectUtil.clickElement(LoadBalancer.getNavPoolsTab());
			
			verifyPoolsTabDetailsinLB();
			
			CustomWebElementUtil.loadCustomElement(LoadBalancer.getNavPoolsTableParent(), "table");
			wFirstRowExpander=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.POOL.LOADBALANCER.TABLE.EXPANDER", "PARAMETER_ROWNUMBER", iRowNumber+"");
			//Expanding first row
			WebObjectUtil.clickElement(wFirstRowExpander);
			WebObjectUtil.explicitWait(2);
			
			// Validating the port/protocol data
			valDataofPortProtocolFieldPoolasTabinLB(iRowNumber);
			//Verifies Refresh,Edit,delete Links under row expanded
			verifyRefreshEditDeletelinksinLBTabsRowExpander();
			
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNavPools_Exp_AddMemberLink());
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNavPools_Exp_MemberColumn());
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNavPools_Exp_IPAddColumn());
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNavPools_Exp_StatusColumn());
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNavPools_Exp_RatioColumn());
			
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNavPools_Exp_PaginationBar());
			
			//Logout from Navigator
			LoginTestCase.nav_Logout();
		
		   } catch (Exception e) {
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyLoadBalancerPoolsTabDisplayDetails", "warn", "catch block:" +e.getMessage());
		}
    }
	
	
	///////Completed reviewing above tcs. Need to complete followiing
	/*==============================================================
	TestScript 		: valLoadBalancerEdtDelTab
	Manual TestCase	: Hague-QAT-333-WCP_881_EVDC_Load Balancer_Virtual IPs tab / Refresh Details,Edit,Delete tabs functionality when a load balancer is expanded
	Description		: Verify that when a load balancer is expanded, user is able to see Refresh Details,Edit,Delete buttons and upon clicking any of this a ticket is created
	Author 			: Vivek Kumar
	Creation Date 	: 12/02/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=201)
	public void valLoadBalancerEdtDelTab()
	{
		
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);
		PageFactory.initElements(driver, LoadBalancer);
		
		String sUserName,sPassword;
		int iRCnt,iRowNo;
		WebElement wVirtualIPExpander,wVirtualIPRefresh,wVirtualIPEdit,wVirtualIPDel;
		
		FrameworkUtil.sTestCaseName ="valLoadBalancerEdtDelTab";
		FrameworkUtil.sManualTestCaseName="Hague-QAT-333-WCP_881_EVDC_Load Balancer_Virtual IPs tab / Refresh Details,Edit,Delete tabs functionality when a load balancer is expanded";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HAWKEYE.USERID");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HAWKEYE.PASSWORD");
		
		
		
		try {
			//Login and navigating to LoadBalancer page
			LoginTestCase.nav_Login(sUserName, sPassword);
			navigateToLoadbalancer();
			  
			//Expanding the table
			CustomWebElementUtil.loadCustomElement(LoadBalancer.getNavVirtulIPTableParent(), "table");
			iRCnt=CustomWebElementUtil.iRowCount;
			
			if(iRCnt>0)
			{
				iRowNo=1;
				//Expanding the 1st Row
				wVirtualIPExpander=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.LOADBALANCER.EXPANDER", "PARAMETER_ROWNUMBER",iRowNo+"");
				WebObjectUtil.clickElement(wVirtualIPExpander);
				
				LoadBalancersTestCase.verifyRefreshEditDeletelinksinLBTabsRowExpander();
				
				//Clicking Edit button and verifying the ticket popup
				WebObjectUtil.clickElement(LoadBalancer.getNav_LB_Expander_EditLink());
				WebObjectUtil.explicitWait(2);
				WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_TicketPopUp());
				WebObjectUtil.clickElement(LoadBalancer.getNav_TicketpopupCancelBtn());
				
				WebObjectUtil.explicitWait(3);
				//Clicking Delete button and verifying the ticket popup
				WebObjectUtil.clickElement(LoadBalancer.getNav_LB_Expander_DeleteLink());
				WebObjectUtil.explicitWait(2);
				WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_TicketPopUp());
				WebObjectUtil.clickElement(LoadBalancer.getNav_TicketpopupCancelBtn());
				
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Virtual IPs Table", "fail", "There is 0(zero) row present for Virtual IP table at LoadBalancer page ");
			}
			//Logout
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
	}
    
	/*==============================================================
	TestScript 		: valVirtualIPandPoolPDFCSV
	Manual TestCase	: Hague-QAT-312-WCP_811_TC_1.0_EVDC_Load Balancer_Pools_PDF/CSV Reports
					  QAT-309-WCP_811_TC_1.0_EVDC_Load Balancer_Virtual IPs_PDF/CSV Reports
	Description		: Verifying PDF and CSV file of Virtual IP and Pools
	Author 			: Vivek Kumar
	Creation Date 	: 12/02/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=202)
	public void valVirtualIPandPoolPDFCSV()
	{
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);
		PageFactory.initElements(driver, LoadBalancer);
		
		String sUserName,sPassword;
		String sPDFSrc,sCSVSrc;
		boolean bStatus=false;
		
		FrameworkUtil.sTestCaseName ="valVirtualIPandPoolPDFCSV";
		FrameworkUtil.sManualTestCaseName="Hague-QAT-312-QAT-309WCP_811_TC_1.0_EVDC_Load Balancer_Pools_PDF/CSV Reports";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HAWKEYE.USERID");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HAWKEYE.PASSWORD");
		
		
		
		
		try {
			//Login and navigating to LoadBalancer page
			LoginTestCase.nav_Login(sUserName, sPassword);
			navigateToLoadbalancer();
			
			//Verifying PDF for Virtual IPS
			sPDFSrc=LoadBalancer.getNavVirtualIpTab_PDFIcon().getAttribute("src");
			bStatus=sPDFSrc.contains("PDF");
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "PDF file verified for Virtual IPs");
			//Verifying CSV for Virtual IPS
			sCSVSrc=LoadBalancer.getNavVirtualIpTab_CSVIcon().getAttribute("src");
			bStatus=sCSVSrc.contains("CSV");
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "CSV file verified for Virtual IPs");
			
			//Click on Pools
			WebObjectUtil.clickElement(LoadBalancer.getNavPoolsTab());
			WebObjectUtil.explicitWait(2);
			//Verifying PDF for Pools
			sPDFSrc=LoadBalancer.getNavPoolsTab_PDFIcon().getAttribute("src");
			bStatus=sPDFSrc.contains("PDF");
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "PDF file verified for Pools");
			//Verifying CSV for Pools
			sCSVSrc=LoadBalancer.getNavPoolsTab_CSVIcon().getAttribute("src");
			bStatus=sCSVSrc.contains("CSV");
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "CSV file verified for Pools");
			
			//Logout
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
	}
	
	/*==============================================================
	TestScript 		: valInstanceTabDelEdtRefreshBtn
	Manual TestCase	: Hague-QAT-306-WCP_881_TC_1.0_EVDC_Load Balancer_Instance Tab, Refresh Details,Edit, Delete buttons functionality
	Description		: Verify the Instance Tab on Load Balancer page in EVDC . Verify that Refresh Details, Edit, Delete buttons when click on any of these will create a ticket.
	Author 			: Vivek Kumar
	Creation Date 	: 12/03/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=203)
	public void valInstanceTabDelEdtRefreshBtn()
	{
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);
		PageFactory.initElements(driver, LoadBalancer);
		
		String sUserName,sPassword;
		int iRowCnt,iRowNo;
		WebElement wInstanceExpander;
		
		
		FrameworkUtil.sTestCaseName ="valInstanceTabDelEdtRefreshBtn";
		FrameworkUtil.sManualTestCaseName="Hague-QAT-306-WCP_881_TC_1.0_EVDC_Load Balancer_Instance Tab, Refresh Details,Edit, Delete buttons functionality";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HAWKEYE.USERID");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HAWKEYE.PASSWORD");
		
		
		try {
			LoginTestCase.nav_Login(sUserName, sPassword);
			navigateToLoadbalancer();
			//Click on Instance tab
			WebObjectUtil.clickElement(LoadBalancer.getNavInstanceTab());
			
			//Verifying "Add a Balancer" link
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNavInstancesTab_AddLoadBalancerLink());
			
			//Verifying PDF and CSV icon
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNavInstanceTab_PDFIcon());
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNavInstanceTab_CSVIcon());
			
			//Verifying LoadBalancer,Type,Link and Maximux Thoughput as Header
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNavInstances_LoadBalasHeader());
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNavInstances_TypeasHeader());
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNavInstances_LnkasHeader());
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNavInstances_MaxThoughPutasHeader());
			
			//Expanding the row
			CustomWebElementUtil.loadCustomElement(LoadBalancer.getNavInstancesTableParent(), "table");
			iRowCnt=CustomWebElementUtil.iRowCount;
			
			if(iRowCnt>0)
			{
				iRowNo=1;
				//Expanding the 1st Row
				wInstanceExpander=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.INSTANCE.LOADBALANCER.EXPANDER", "PARAMETER_ROWNUMBER",iRowNo+"");
				WebObjectUtil.clickElement(wInstanceExpander);
				
				LoadBalancersTestCase.verifyRefreshEditDeletelinksinLBTabsRowExpander();
				
				//Clicking Edit button and verifying the ticket popup
				WebObjectUtil.clickElement(LoadBalancer.getNav_LB_Expander_EditLink());
				WebObjectUtil.explicitWait(2);
				WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_TicketPopUp());
				WebObjectUtil.clickElement(LoadBalancer.getNav_TicketpopupCancelBtn());
				
				WebObjectUtil.explicitWait(3);
				//Clicking Delete button and verifying the ticket popup
				WebObjectUtil.clickElement(LoadBalancer.getNav_LB_Expander_DeleteLink());
				WebObjectUtil.explicitWait(2);
				WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_TicketPopUp());
				WebObjectUtil.clickElement(LoadBalancer.getNav_TicketpopupCancelBtn());
				
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Virtual IPs Table", "fail", "There is 0(zero) row present for Virtual IP table at LoadBalancer page ");
			}
			//Logout
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
	}
	
	/*==============================================================
	TestScript 		: valLoadBalPoolTab
	Manual TestCase	: QAT-299-WCP_881_EVDC_Load Balancer_Pools Tab display/Refresh Detials, Edit, Delete buttons functionality
	Description		:  Verify the Pools Tab on Load Balancer page in EVDC . Verify that clicking on buttons Refresh Details, Edit and Delete, user is able to create a ticket. 
	Author 			: Vivek Kumar
	Creation Date 	: 12/09/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=204)
	public void valLoadBalPoolTab()
	{
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, LoadBalancer);
		
		String sUserName,sPassword,sNotes,sSummary;
		int iRowCnt,iRowNo;
		WebElement wPoolExpander,wAddMember;
		
		
		FrameworkUtil.sTestCaseName ="valLoadBalPoolTab";
		FrameworkUtil.sManualTestCaseName="QAT-299-WCP_881_EVDC_Load Balancer_Pools Tab display/Refresh Detials, Edit, Delete buttons functionality";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HAWKEYE.USERID");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HAWKEYE.PASSWORD");
		
		//Login and navigating to LoadBalancer page
		LoginTestCase.nav_Login(sUserName, sPassword);
		navigateToLoadbalancer();
		//Click and Verify Pool tab landing page
		WebObjectUtil.clickAndVerifyElement(LoadBalancer.getNavPoolsTab(), LoadBalancer.getNavPoolsTab_PDFIcon());
		
		CustomWebElementUtil.loadCustomElement(LoadBalancer.getNavPoolsTableParent(), "table");
		iRowCnt=CustomWebElementUtil.iRowCount;
		
		if(iRowCnt>0)
		{
			iRowNo=1;
			wPoolExpander=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.POOL.LOADBALANCER.TABLE.EXPANDER", "PARAMETER_ROWNUMBER",iRowNo+"");
			WebObjectUtil.clickElement(wPoolExpander);
			
			
			
			LoadBalancersTestCase.verifyRefreshEditDeletelinksinLBTabsRowExpander();
			//Clicking on Edit button and verifying the tickect popup and appending title with timestamp
			WebObjectUtil.clickElement(LoadBalancer.getNav_LB_Expander_EditLink());
			//It will verify Edit popup and then verify the same @ Ticket page
			valTicketpopUp();
			
		//####################################Verifying Add Member Ticket#################################################################	
			
			 /// navigating to home page
		  	EVDC_FirewallTestCase.navReturnHomePage();
		  	navigateToLoadbalancer();
		  //Click and Verify Pool tab landing page
			WebObjectUtil.clickAndVerifyElement(LoadBalancer.getNavPoolsTab(), LoadBalancer.getNavPoolsTab_PDFIcon());
			//Expanding Pool expander
			iRowNo=1;
			wPoolExpander=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.POOL.LOADBALANCER.TABLE.EXPANDER", "PARAMETER_ROWNUMBER",iRowNo+"");
			WebObjectUtil.clickElement(wPoolExpander);
			
			//Verifying Add a member
			wAddMember=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.POOL.LOADBALANCER.ADDMEMBER", "PARAMETER_ROWNUMBER",iRowNo+"");
			WebObjectUtil.clickElement(wAddMember);
			//It will verify AddMember and then verify the same @ Ticket page
			valTicketpopUp();
			
			//#####################################Verifying Add Load Balancer Ticket################################################################	
			
			 /// navigating to home page
			EVDC_FirewallTestCase.navReturnHomePage();
		  	navigateToLoadbalancer();
		  //Click and Verify Pool tab landing page
			WebObjectUtil.clickAndVerifyElement(LoadBalancer.getNavPoolsTab(), LoadBalancer.getNavPoolsTab_PDFIcon());
			//Click on Add LB
			WebObjectUtil.clickElement(LoadBalancer.getNavPools_AddLB());
			//It will verify Add LB and then verify the same @ Ticket page
			valTicketpopUp();
			//Logout
			LoginTestCase.nav_Logout();
			
		}
		else
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Pool webTable"   , "fail", "There are "+iRowCnt +" rows present under pool tab");
		}
		
	}
	
	/*==============================================================
	TestScript  	: VerifyLoadBalPortlet()
	Manual TestCase	: QAT-249-WCP_2184_TC_1.1_EVDC_Load Balancer portlet on EVDC over view page		
	Description		: Verify the Load Balancer portlet display on EVDC over view page
	Author 			: Priyanka R
	Creation Date 	: 12/01/2015
	Release         : Hague
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=301)
	public void VerifyLoadBalPortlet()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		
		PageFactory.initElements(driver, EVDC_OverviewPF);
		PageFactory.initElements(driver, Home);
		
		
		try {
		String sUserName, sPassword, sVCloudUrl;
	
				
		FrameworkUtil.sTestCaseName = "Hague-VerifyLoadBalPortlet";
		FrameworkUtil.sManualTestCaseName="QAT-249-WCP_2184_TC_1.1_EVDC_Load Balancer portlet on EVDC over view page";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		
		sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.USER.HAWKEYE.USERID");
		sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.USER.HAWKEYE.PASSWORD");
		
		
		//Login
		LoginTestCase.nav_Login(sUserName, sPassword);
		
		WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
		WebObjectUtil.explicitWait(10);
		WebObjectUtil.waitForElementPresent(EVDC_OverviewPF.getNav_EVDCLoadBalancerPortlet());
		WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCLBInstances());
		WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCLBVips());
		WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCLBPools());
		WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCLBMembers());
		WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCLBInstancesVal());
		WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCLBVipsVal());
		WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCLBPoolsVal());
		WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCLBMembersVal());
		WebObjectUtil.explicitWait(10);
		VerifyLoadBalPageValuesWithPortlet();
	    
		//Logout
		LoginTestCase.nav_Logout();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
	         	LoggerUtil.log_type_error( "Issue With-VerifyLoadBalPortlet" +  e.getMessage());
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
	
	}

	
    ///_____________________ Completed Hague test cases ________________________________ ///
    
    
	///////////////////////////////  Methods //////////////////////////////////////////////
   
  
  
  /*==============================================================
	MethodName 		: NavigatingToLoadBalancerPage
	Manual TestCase	: 
	Description		: Navigating to the load balancers page
	Author 			: QAA04
	Creation Date 	: 11/30/2015
	release Name    : Hague
	Pre-Requisites	:
	Revision History:
	
	==============================================================*/
public static void NavigatingToLoadBalancerPage() {
	   
	   WebDriver driver =WebDriverUtil.getDriver();
	   
	   PageFactory.initElements(driver, EVDC_OverviewPF);
	   PageFactory.initElements(driver, LoadBalancer);
	   // clicking on evdc lank on home page
	   WebObjectUtil.waitForElementPresent(EVDC_OverviewPF.getNav_EVDCname());
	   WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
	  
	   // Clicking on Load balancers link on EVDCOverview page
	   WebObjectUtil.clickElement(LoadBalancer.getNavEVDCOverviewLoadBalancersLink());
	
   	 //Clicking on virtual IP tab
		WebObjectUtil.clickElement(LoadBalancer.getNavVirtualIpTab());
		 WebObjectUtil.waitForElementPresent(LoadBalancer.getNavVirtualIpTab_AddVIPLink());
		WebObjectUtil.verifyElementPresent(LoadBalancer.getNavVirtualIpTab_AddVIPLink());
 }
 
/*==============================================================
	Method Name 	: VerifyVirtualIPTabObjects
	Manual TestCase	: 
	Description		: Verifying the pdf,csv.addvip, and table columnheaders and also refresh,edit, delete buttons
	Author 			: QAA04
	Creation Date 	: 12/1/2015
	release Name    : Hague
	Pre-Requisites	:
	Revision History:
	
	==============================================================*/
 public static void VerifyVirtualIPTabObjects() {
	  String sExpander,sRefreshBtn,sEditBtn,sDeleteBtn;
	  WebElement wExpander,wRefreshBtn,wEditBtn,wDeleteBtn;
	  WebDriver driver =WebDriverUtil.getDriver();
	 
	  PageFactory.initElements(driver, LoadBalancer);
	  
	  WebObjectUtil.clickElement(LoadBalancer.getNavVirtualIpTab());
	  WebObjectUtil.explicitWait(3);
	  WebObjectUtil.verifyElementPresent(LoadBalancer.getNavVirtualIpTab_AddVIPLink());
	  WebObjectUtil.verifyElementPresent(LoadBalancer.getNavVirtualIpTab_PDFIcon());
	  WebObjectUtil.verifyElementPresent(LoadBalancer.getNavVirtualIpTab_CSVIcon());
	  
	  WebObjectUtil.verifyElementPresent(LoadBalancer.getNavVirtualIP_LoadBalancerColumnHeader());
	  WebObjectUtil.verifyElementPresent(LoadBalancer.getNavVirtualIP_NameColumnHeader());
	  WebObjectUtil.verifyElementPresent(LoadBalancer.getNavVirtualIP_IpAddressCloumnHeader());
	  WebObjectUtil.verifyElementPresent(LoadBalancer.getNavVirtualIP_PoolColumnHeader());
	  WebObjectUtil.verifyElementPresent(LoadBalancer.getNavVirtualIP_protocolColumnHeader());
	  WebObjectUtil.verifyElementPresent(LoadBalancer.getNavVirtualIP_DescriptionColumnHeader());

   sExpander = WebObjectUtil.getLocatorValueFromProperty("EVDC.LOADBALANCER.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
   wExpander = WebObjectUtil.GetWebElement("XPATH", sExpander, "Expand Arrow");
   wExpander.click();
   WebObjectUtil.explicitWait(5);
   
   sRefreshBtn = WebObjectUtil.getLocatorValueFromProperty("EVDC.LOADBALANCER.EXPANDER.REFRESHDETAILS.BUTTON", "PARAMETER_ROWNUMBER", 1 +"");
   wRefreshBtn = WebObjectUtil.GetWebElement("XPATH", sRefreshBtn, "RefreshDetailsButton");
   WebObjectUtil.verifyElementPresent(wRefreshBtn);

   sEditBtn = WebObjectUtil.getLocatorValueFromProperty("EVDC.LOADBALANCER.EXPANDER.EDIT.BUTTON", "PARAMETER_ROWNUMBER", 1 +"");
   wEditBtn = WebObjectUtil.GetWebElement("XPATH", sEditBtn, "EditButton");
   WebObjectUtil.verifyElementPresent(wEditBtn);
   
   sDeleteBtn =  WebObjectUtil.getLocatorValueFromProperty("EVDC.LOADBALANCER.EXPANDER.DELETE.BUTTON", "PARAMETER_ROWNUMBER", 1 +"");
   wDeleteBtn = WebObjectUtil.GetWebElement("XPATH", sDeleteBtn, "Delete button");
   WebObjectUtil.verifyElementPresent(wDeleteBtn);

 }
 /*==============================================================
 Method Name  	: verifyPoolsWebTablebuttons
 Manual TestCase	:
 Description		: After expanding the web table row, verifying the refresh,edit, delete btns
 Author 			: QAA04
 Creation Date 	: 12/08/2015
 Pre-Requisites	:
 Revision History:
 ==============================================================*/
 public static void VerifyPoolsWebTableButtons() {
 	String sPoolsExpander,sPoolsRefreshBtn,sPoolsEditBtn,sPoolsDeleteBtn;
 	WebElement wPoolsExpander,wPoolsRefreshBtn,wPoolsEditBtn,wPoolsDeleteBtn;
 	WebDriver driver = WebDriverUtil.getDriver();
    
     PageFactory.initElements(driver, LoadBalancer);
     
     sPoolsExpander = WebObjectUtil.getLocatorValueFromProperty("EVDC.POOL.LOADBALANCER.TABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
     wPoolsExpander =WebObjectUtil.GetWebElement("XPATH", sPoolsExpander, "Expand the row");
     WebObjectUtil.clickElement(wPoolsExpander);
     WebObjectUtil.explicitWait(5);
     
     sPoolsRefreshBtn = WebObjectUtil.getLocatorValueFromProperty("EVDC.POOL.LOADBALANCER.EXPANDER.REFRESHDETAILS.BUTTON", "PARAMETER_ROWNUMBER", 1+"");
     wPoolsRefreshBtn = WebObjectUtil.GetWebElement("XPATH", sPoolsRefreshBtn, "pools refresh button");
     WebObjectUtil.verifyElementPresent(wPoolsRefreshBtn);
     
     sPoolsEditBtn = WebObjectUtil.getLocatorValueFromProperty("EVDC.POOL.LOADBALANCER.EXPANDER.EDIT.BUTTON", "PARAMETER_ROWNUMBER", 1+"");
     wPoolsEditBtn = WebObjectUtil.GetWebElement("XPATH", sPoolsEditBtn, "pools edit button");
     WebObjectUtil.verifyElementPresent(wPoolsEditBtn);
     
     sPoolsDeleteBtn = WebObjectUtil.getLocatorValueFromProperty("EVDC.POOL.LOADBALANCER.EXPANDER.DELETE.BUTTON","PARAMETER_ROWNUMBER", 1+"");
     wPoolsDeleteBtn = WebObjectUtil.GetWebElement("XPATH", sPoolsDeleteBtn, "pools delete button");
     WebObjectUtil.verifyElementPresent(wPoolsDeleteBtn);
     
     
     
     
 }
 /*==============================================================
 Method Name  	: verifyInstanceWebTablebuttons
 Manual TestCase	:
 Description		: After expanding the web table row, verifying the refresh,edit, delete btns
 Author 			: QAA04
 Creation Date 	: 12/08/2015
 Pre-Requisites	:
 Revision History:
 ==============================================================*/
 public static void verifyInstanceWebTablebuttons() {
 	WebDriver driver = WebDriverUtil.getDriver();
 	PageFactory.initElements(driver, LoadBalancer);
 	String sTableExpander,sRefershBtn,sEditBtn,sDeleteBtn;
 	WebElement wTableExpander,wRefershBtn,wEditBtn,wDeleteBtn;
 	
 	WebObjectUtil.waitForElementPresent(LoadBalancer.getNavInstanceTab());
 	WebObjectUtil.clickElement(LoadBalancer.getNavInstanceTab());
 	WebObjectUtil.explicitWait(5);
 	
 	sTableExpander =WebObjectUtil.getLocatorValueFromProperty("EVDC.INSTANCE.LOADBALANCER.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
 	wTableExpander = WebObjectUtil.GetWebElement("XPATH", sTableExpander, "Expanding the row");
 	WebObjectUtil.clickElement(wTableExpander);
 	WebObjectUtil.explicitWait(10);
 	sRefershBtn =WebObjectUtil.getLocatorValueFromProperty("EVDC.INSTANCE.LOADBALANCER.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
 	wRefershBtn = WebObjectUtil.GetWebElement("XPATH", sTableExpander, "Expanding the row");
 	WebObjectUtil.verifyElementPresent(wRefershBtn);
 	
 	sEditBtn =WebObjectUtil.getLocatorValueFromProperty("EVDC.INSTANCE.LOADBALANCER.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
 	wEditBtn = WebObjectUtil.GetWebElement("XPATH", sTableExpander, "Expanding the row");
 	WebObjectUtil.verifyElementPresent(wEditBtn);
 	
 	sDeleteBtn =WebObjectUtil.getLocatorValueFromProperty("EVDC.INSTANCE.LOADBALANCER.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
 	wDeleteBtn = WebObjectUtil.GetWebElement("XPATH", sTableExpander, "Expanding the row");
 	WebObjectUtil.verifyElementPresent(wDeleteBtn);

 }
  
  
 /*==============================================================
 Method Name  	: VerifyReflectedIPAddressInInstancesTab
 Manual TestCase	:
 Description		: verifying the changed ip address is reflected to the navigator or not
 Author 			: QAA04
 Creation Date 	: 12/08/2015
 Pre-Requisites	:
 Revision History:
 ==============================================================*/
 public static void VerifyReflectedIPAddressInInstancesTab() {
 	WebDriver driver = WebDriverUtil.getDriver();
 	PageFactory.initElements(driver, LoadBalancer);
 	String sTableExpander,sRefershBtn,sEditBtn,sDeleteBtn,sIPAdderss,sReflectedIPAddress;
 	WebElement wTableExpander,wRefershBtn,wEditBtn,wDeleteBtn,wIPAdderss;
 	
 	WebObjectUtil.waitForElementPresent(LoadBalancer.getNavInstanceTab());
 	WebObjectUtil.clickElement(LoadBalancer.getNavInstanceTab());
 	WebObjectUtil.explicitWait(5);
 	
 	sTableExpander =WebObjectUtil.getLocatorValueFromProperty("EVDC.INSTANCE.LOADBALANCER.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
 	wTableExpander = WebObjectUtil.GetWebElement("XPATH", sTableExpander, "Expanding the row");
 	WebObjectUtil.clickElement(wTableExpander);
 	WebObjectUtil.explicitWait(5);
 	sRefershBtn =WebObjectUtil.getLocatorValueFromProperty("EVDC.INSTANCE.LOADBALANCER.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
 	wRefershBtn = WebObjectUtil.GetWebElement("XPATH", sRefershBtn, "Expanding the row");
 	WebObjectUtil.clickElement(wRefershBtn);
 	WebObjectUtil.explicitWait(10);
 	sIPAdderss =WebObjectUtil.getLocatorValueFromProperty("EVDC.INSTANCE.LOADBALANCER.TABLE.IPADDRESS.COLUMN", "PARAMETER_ROWNUMBER", 1+"");
 	wIPAdderss = WebObjectUtil.GetWebElement("XPATH", sIPAdderss, "Expanding the row");
 	sReflectedIPAddress = wIPAdderss.getText();
 	
 	
 	
 	
 	
 	if(sReflectedIPAddress.contains( IACTestcase_NMR.sUpdatedIPAdress)) {
 		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying the ipaddress", "pass", sReflectedIPAddress+" - IPAddress is reflected to navigator - " + IACTestcase_NMR.sUpdatedIPAdress);
 	}
 	else {
 		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying the ipaddress", "fail", sReflectedIPAddress+" - IPAddress is NOT reflected to navigator - " + IACTestcase_NMR.sUpdatedIPAdress);
 	}
 }

 /*==============================================================
 Method Name  	: VerifyReflectedIPAddressInPoolsTab
 Manual TestCase	:
 Description		: verifying the changed ip address is reflected to the navigator or not
 Author 			: QAA04
 Creation Date 	: 12/08/2015
 Pre-Requisites	:
 Revision History:
 ==============================================================*/
 public static void VerifyReflectedIPAddressInPoolsTab() {
 	String sPoolsExpander,sPoolsRefreshBtn,sPoolsIpAdrs,sPoolsIPAddress;
 	WebElement wPoolsExpander,wPoolsRefreshBtn,wPoolsIpAddress;
 	WebDriver driver = WebDriverUtil.getDriver();
    
     PageFactory.initElements(driver, LoadBalancer);
     WebObjectUtil.waitForElementPresent(LoadBalancer.getNavPoolsTab());
     WebObjectUtil.clickElement(LoadBalancer.getNavPoolsTab());
  
     sPoolsExpander = WebObjectUtil.getLocatorValueFromProperty("EVDC.POOL.LOADBALANCER.TABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
     wPoolsExpander =WebObjectUtil.GetWebElement("XPATH", sPoolsExpander, "Expand the row");
     WebObjectUtil.clickElement(wPoolsExpander);
    
     
     sPoolsRefreshBtn = WebObjectUtil.getLocatorValueFromProperty("EVDC.POOL.LOADBALANCER.EXPANDER.REFRESHDETAILS.BUTTON", "PARAMETER_ROWNUMBER", 1+"");
     wPoolsRefreshBtn = WebObjectUtil.GetWebElement("XPATH", sPoolsRefreshBtn, "pools refresh button");
     WebObjectUtil.clickElement(wPoolsRefreshBtn);
    // WebDriverUtil.refreshBrowser();
     //WebObjectUtil.clickElement(LoadBalancer.getNavPoolsTab());
     WebObjectUtil.explicitWait(5);
     sPoolsExpander = WebObjectUtil.getLocatorValueFromProperty("EVDC.POOL.LOADBALANCER.TABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
     wPoolsExpander =WebObjectUtil.GetWebElement("XPATH", sPoolsExpander, "Expand the row");
     WebObjectUtil.clickElement(wPoolsExpander);
     // WebObjectUtil.clickElement(wPoolsExpander);
     sPoolsIpAdrs = WebObjectUtil.getLocatorValueFromProperty("EVDC.POOL.LOADBALANCER.EXPANDER.IPADDRESS.COLUMN", "PARAMETER_ROWNUMBER", 1+"");
     wPoolsIpAddress = WebObjectUtil.GetWebElement("XPATH", sPoolsIpAdrs, "Pools web table ip address");
     WebObjectUtil.waitForElementPresent(wPoolsIpAddress);
     sPoolsIPAddress = wPoolsIpAddress.getText();
 	
 	if(sPoolsIPAddress.contains( IACTestcase_NMR.sUpdatedIPAdress)) {
 		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying the ipaddress", "pass", IACTestcase_NMR.sUpdatedIPAdress +" - IPAddress is reflected in the navigator - " +sPoolsIPAddress);
 	}
 	else {
 		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying the ipaddress", "fail", IACTestcase_NMR.sUpdatedIPAdress +" - IPAddress is NOT reflected in the navigator - " +sPoolsIPAddress);
 	}
 }

 /*====================================================================================================
	Method Name 	: verifyInstanceTabDetailsinLB
	Description		: Verifying all Links under Instance Tab
	Author 			: QAA03
	Creation Date 	: 12/10/2015
	Pre-Requisites	:
	Revision History:
	====================================================================================================*/
	public static void verifyInstanceTabDetailsinLB()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,LoadBalancer);
			
				
  try {
 	   //Verifying Add LoadBalancer link,PDF and CSV icons under instance tab
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNavInstancesTab_AddLoadBalancerLink());
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNavInstanceTab_PDFIcon());
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNavInstanceTab_CSVIcon());
			
			//Verifying all columns names of Load Balancer instances table
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNavInstances_LoadBalasHeader());
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNavInstances_TypeasHeader());
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNavInstances_LnkasHeader());
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNavInstances_MaxThoughPutasHeader());
 	   
			  
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyInstanceTabDetailsinLB", "warn", "catch block:" +e.getMessage());  
		}
		
	}
  
	/*====================================================================================================
	Method Name 	: verifyRefreshEditDeletelinksinLBTabsRowExpander
	Description		: Verifying RefreshDetails,Edit and Delete links in all Tabs of Load Balancer 
	Author 			: QAA03
	Creation Date 	: 12/10/2015
	Pre-Requisites	:
	Revision History:
	====================================================================================================*/
	public static void verifyRefreshEditDeletelinksinLBTabsRowExpander()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,LoadBalancer);
			
				
     try {
        	
    	   //Verifying RefreshDetails,Edit and Delete links
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_LB_Expander_RefreshDetailsLink());
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_LB_Expander_EditLink());
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_LB_Expander_DeleteLink());
			  
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyRefreshEditDeletelinksinLBTabsRowExpander", "warn", "catch block:" +e.getMessage());  
		}
		
	}
	/*====================================================================================================
	Method Name 	: verifyPoolsTabDetailsinLB
	Description		: Verifying all Links under Pools Tab
	Author 			: QAA03
	Creation Date 	: 12/10/2015
	Pre-Requisites	:
	Revision History:
	====================================================================================================*/
	public static void verifyPoolsTabDetailsinLB()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,LoadBalancer);
			
				
     try {
        	
    	   //Verifying Add LoadBalancer link ,PDF and CSV icons
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNavPoolsTab_AddLoadBalancerLink());
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNavPoolsTab_PDFIcon());
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNavPoolsTab_CSVIcon());
			
			//Verifying all columns names of Load Balancer pools table
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNavPools_LoadbalancerColumn());
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNavPools_NameColumn());
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNavPools_HealthCheckColumn());
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNavPools_PortProtocolColumn());
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNavPools_MethodColumn());
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNavPools_StatusColumn());
			WebObjectUtil.verifyElementPresent(LoadBalancer.getNavPools_DescriptionColumn());
			  
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyPoolsTabDetailsinLB", "warn", "catch block:" +e.getMessage());  
		}
		
	}
  
	/*====================================================================================================
	Method Name 	: valDataofPortProtocolFieldPoolasTabinLB
	Description		: Validating more than one Port/Protocol values are seperated by commas in expanding row of pools tab in LB
	Author 			: QAA03
	Creation Date 	: 12/10/2015
	Pre-Requisites	:
	Revision History:
	====================================================================================================*/
	public static void valDataofPortProtocolFieldPoolasTabinLB(int iRowNumber)
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,LoadBalancer);
			WebElement wPortProtocol;
			String sPortProtocol=null;
			int iPortArray;
	
     try {
	    	 wPortProtocol=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.LOADBALANCER.POOLS.EXPANDER.PORTPROTOCOl.VALUE", "PARAMETER_ROWNUMBER", iRowNumber+"");
	    	 sPortProtocol= wPortProtocol.getText();
	    	 String sPortArray[] = sPortProtocol.split(",");
	    	 iPortArray = sPortArray.length;
	    	 if(iPortArray>=1)
	    	 {
	    	 for(int i=0;i<iPortArray;i++)
	    	 {
	    		 if(sPortProtocol.contains(sPortArray[i]))
	    		 {
	    			 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Port/Protocol Data", "pass", "Port/Protocol Data is splitted with commas");	
	    		 }
	    		 else
	    		 {
	    			 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Port/Protocol Data", "fail", "Port/Protocol Data is not splitted with commas");
	    		 }
	    	 }
	    	 }
     
   		      else
   		      {
   		    	 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Port/Protocol Data", "warn", "Port/Protocol has only one value");
    	      }
	    	 
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "valDataofPortProtocolFieldPoolasTabinLB", "warn", "catch block:" +e.getMessage());  
		}
		
	}
	/*==============================================================
	Method Name 	: navigateToLoadbalancer
	Description		: This will navigate to load balancer
	Author 			: Vivek Kumar
	Creation Date 	: 12/02/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void navigateToLoadbalancer()
	{
		
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);
		PageFactory.initElements(driver, LoadBalancer);
		
		try {
						
			//Click on EVDC Name
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			
			//Click on Loadbalancer link
			WebObjectUtil.clickAndVerifyElement((EVDC_OverviewPF.getNav_EVDCLBLink()),LoadBalancer.getNavVirtualIpTab());
			
			//Clicking on virtuals IP tab
			WebObjectUtil.clickAndVerifyElement(LoadBalancer.getNavVirtualIpTab(),LoadBalancer.getNavVirtualIpTab_AddVIPLink());
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		
	}
	
	/*==============================================================
	Method Name 	: valTicketpopUp
	Description		: This will verify the ticket pop up and edit 
	Author 			: Vivek Kumar
	Creation Date 	: 12/10/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public void valTicketpopUp()
	{
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, LoadBalancer);
		String sSummary,sNotes;
		
		WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_TicketPopUp());
		
		sSummary=LoadBalancer.getNav_TicketTextArea().getText();
		//sTicketTitle=sTicketTitle + "_"+FrameworkUtil.sTimeStamp;
		sNotes=FrameworkUtil.sTimeStamp;
		
		driver.switchTo().frame(LoadBalancer.getNav_TicketNoteIframe());
		
		WebElement wElement = WebObjectUtil.GetWebElement("tagname", "body", "NoteEditArea");
		 
		wElement.sendKeys(sNotes);
		 
		driver.switchTo().defaultContent();
		 
		WebObjectUtil.clickElement(LoadBalancer.getNavPopUp_OkBtn());
		//Clicking on Info popup Ok btn
		WebObjectUtil.clickElement(LoadBalancer.getNavPopUp_OkBtn());
		valTicketatTicketPg(sNotes,sSummary);
		
	}
  
	/*==============================================================
	Method Name 	: valTicketatTicketPg
	Description		: This will verify the ticket at ticket page 
	Author 			: Vivek Kumar
	Creation Date 	: 12/15/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public void valTicketatTicketPg(String sNotes,String sSummary)
	{
		//Navigate to Ticket page
		TicketTestCase.navigateToTicketPage();
		TicketTestCase.searchTicket("Notes", sNotes);
		WebObjectUtil.explicitWait(5);
		TicketTestCase.SearcResultFound("Summary",3, sSummary);
	}
	
	/*==============================================================
	Method Name 	: VerifyLoadBalPageValuesWithPortlet
	Description		: This will validate the CPU n RAm count
	Author 			: Priyanka R
	Creation Date 	: 12/3/15
	Pre-Requisites	:
	Release         : Hague
	Revision History:
	==============================================================*/
	
public static void VerifyLoadBalPageValuesWithPortlet()
{
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, EVDC_OverviewPF);
	PageFactory.initElements(driver, Home);
	
	
	try{
		String sInstances,sVips,sPools,sMembers,sVipCount,sPoolCount,sInstanceCount;
		sInstances=EVDC_OverviewPF.getNav_EVDCLBInstancesVal().getText();
		sVips=EVDC_OverviewPF.getNav_EVDCLBVipsVal().getText();
		sPools=EVDC_OverviewPF.getNav_EVDCLBPoolsVal().getText();
		sMembers=EVDC_OverviewPF.getNav_EVDCLBMembersVal().getText();
		WebObjectUtil.explicitWait(5);
		WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCLBLink());
	    WebObjectUtil.explicitWait(10);
	    WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_VirtualIPTab());
		WebObjectUtil.explicitWait(5);
		
		//VIPs Tab
		WebElement wVipCount= WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.LOAD.BALANCER.VIP.COUNT","","");
	    sVipCount=wVipCount.getText().trim();
	    
	    String[] sVipCountVal=sVipCount.split("of");
	    String sVipCountValue=sVipCountVal[1].trim();
	    //FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , ""+sVipCountVal[0], ""+sVipCountVal[1], "");
	    if((Integer.parseInt(sVips))==Integer.parseInt(sVipCountValue))
			  FrameworkUtil.updateCustomResultBasedOnStatus(true, sVipCountVal[1]+" is matching with the value displayed in Vips field");
		  else
			  FrameworkUtil.updateCustomResultBasedOnStatus(false,sVipCountVal[1]+" is not matching with the value displayed in Vips field");
        
	     //Pools Tab
	     WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_PoolsTab());
	     WebObjectUtil.explicitWait(5);
	     WebElement wPoolCount= WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.LOAD.BALANCER.POOL.COUNT","","");
	     sPoolCount=wPoolCount.getText().trim();
	     String[] sPoolCountVal=sPoolCount.split("of");
	     String sPoolCountValue=sPoolCountVal[1].trim(); 
	     if((Integer.parseInt(sPools))==Integer.parseInt(sPoolCountValue))
				FrameworkUtil.updateCustomResultBasedOnStatus(true, sPoolCountVal[1]+" is matching with the value displayed in Pools field");
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false,sPoolCountVal[1]+" is not matching with the value displayed in Pools field");
	     
	     //Instances Tab
	     WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_InstancesTab());
	     WebObjectUtil.explicitWait(5);
	     WebElement wInstanceCount= WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.LOAD.BALANCER.INSTANCE.COUNT","","");
	     sInstanceCount=wInstanceCount.getText().trim();
	     String[] sInstanceCountVal=sInstanceCount.split("of");
	     String sInstanceCountValue=sInstanceCountVal[1].trim();
	     if((Integer.parseInt(sInstances))==Integer.parseInt(sInstanceCountValue))
				FrameworkUtil.updateCustomResultBasedOnStatus(true,sInstanceCountVal[1]+" is matching with the value displayed in Instances field");
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false,sInstanceCountVal[1]+" is not matching with the value displayed in Instances field");


	}
	catch (Exception e) {
		// TODO Auto-generated catch block
         	LoggerUtil.log_type_error( "Issue with-VerifyLoadBalPageValuesWithPortlet" +  e.getMessage());
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
	}

	}
	
	
 ////////________________________________________________________________________________//////////////////// 
//update each @test result in custom result file
		@AfterMethod
		public static void afterEachMethod(){
			FrameworkUtil.updateTestCaseStatusinResult();
			FrameworkUtil.sTestExecutionStatus = true;
			
		}
  
}
