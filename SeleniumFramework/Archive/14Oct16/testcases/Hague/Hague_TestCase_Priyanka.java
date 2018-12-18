package com.whs.navigator.testcases.Hague;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.CustomWebElementUtil;
import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.commonUtil.WebTableUtil;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.EVDC_VM_PageFactory;
import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.LoadBalancerPageFactory;
import com.whs.navigator.pagefactory.SmokeTestPageFactory;
import com.whs.navigator.pagefactory.DraasPageFactory;
import com.whs.navigator.pagefactory.CommonPageFactory;
import com.whs.navigator.pagefactory.TicketPageFactory;
import com.whs.navigator.testcases.TicketTestCase;

public class Hague_TestCase_Priyanka {
	
	public static EVDC_OverviewPageFactory EVDC_OverviewPF= new EVDC_OverviewPageFactory();
	public static EVDC_VM_PageFactory EVDC_VMPF=new EVDC_VM_PageFactory();
	public static SmokeTestPageFactory Smoke= new SmokeTestPageFactory();
	public static HomePageFactory_old Home= new HomePageFactory_old();
	public static DraasPageFactory DRaaS= new DraasPageFactory();
	public static CommonPageFactory Common=new CommonPageFactory();
	public static TicketPageFactory Ticket=new TicketPageFactory();
	public static LoadBalancerPageFactory LoadBalancer = new LoadBalancerPageFactory();
    public static boolean sLoginExpandVM = false ;
	static boolean bVMStoppedStatus = false;
	static boolean bVMStartStatus = false ;
	static String sEVDCurl = null;


	/*==============================================================
	TestScript          : verifySummaryDelete()
	Manual TestCase        : QAT272-WCP_3681_TC_Ticket should not be saved when Summary field is blank
	Description                : Verify that user is unable to save ticket when summary field is blank 
	Author                         : Priyanka Rachupalli
	Creation Date         : 07/06/2015
	Pre-Requisites        :
	Release:               Hague
	Revision History:
	==============================================================*/
	// This script is already available in Ticket test cases file
	@Test(priority=68)
	public void verifySummaryDelete()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver,Ticket);
		try{
			int i;
			String sAllRows,sTicketID,sCreateNotes;
		    String sRows[]= new String[8];
			WebElement wExpander,nExpander,wCreateNotes;
			FrameworkUtil.sTestCaseName = "Ticket-verifySummaryDelete";
			FrameworkUtil.sManualTestCaseName="QAT272-WCP_3681_TC_Ticket should not be saved when Summary field is blank";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			//Login to Navigator
			TicketTestCase.navTicketLogin();
			//Select and Open Ticket page
			TicketTestCase.navigateToTicketPage();
			//dynamic XPATH of Expand icon
			WebObjectUtil.explicitWait(10);
			sTicketID = TicketTestCase.getTicketID(1);
			wExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "TICKET.TICKETTABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
			WebObjectUtil.explicitWait(10);
			WebObjectUtil.clickElement(wExpander);
			WebObjectUtil.explicitWait(10);
			WebObjectUtil.clickElement(Ticket.getNav_TicketSummaryEdit());
			Ticket.getNav_TicketSummaryEdit().clear();
			WebObjectUtil.clickElement(Ticket.getNav_TicketSaveUpdatesButton());
			WebObjectUtil.explicitWait(10);
			WebObjectUtil.verifyElementPresent(Common.getNav_CommonPopUpMessage());
			String sMsg=Common.getNav_CommonPopUpMessage().getText();
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , ""+sMsg, "Pass","Verified");
			
		 }
		   catch (Exception e) {
		       LoggerUtil.log_type_error("issue with -Ticket- verifySummaryDelete" );
		       LoggerUtil.log_type_error(e.getMessage());
		       FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(),FrameworkUtil.sElementName , "Exception occured", "fail",e.getMessage()+"null");
		       }
		}
				
				 
	
/*			==============================================================
			TestScript  	: VerifyLoadBalAddVIP()
			Manual TestCase	: Verify the Add VIP under Virtual IP in Load Balancer.		
			Description		: Verify the Add VIP under Virtual IP in Load Balancer.
			Author 			: Priyanka R
			Creation Date 	: 12/01/2015
			Release         : Hague
			Pre-Requisites	:
			Revision History:
			==============================================================
			@Test(priority=31)
			public void VerifyLoadBalAddVIP()
			{
				WebDriver driver = WebDriverUtil.getDriver();
				
				PageFactory.initElements(driver, EVDC_OverviewPF);
				PageFactory.initElements(driver, Ticket);
				PageFactory.initElements(driver, Home);
				PageFactory.initElements(driver, EVDC_VMPF);
				
				try {
				String sUserName,sPassword;
				FrameworkUtil.sTestCaseName = "Hague-VerifyLoadBalAddVIP";
				FrameworkUtil.sManualTestCaseName="Verify the Load Balancer portlet display on EVDC over view page";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

				
				sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.USER.HAWKEYE.USERID");
				sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.USER.HAWKEYE.PASSWORD");
				
				
				//Login
				LoginTestCase.nav_Login(sUserName, sPassword);
				
				VerifyAddAndSearchVIPTicket();

			    LoginTestCase.nav_Logout();
				
			}
				catch (Exception e) {
					// TODO Auto-generated catch block
			         	LoggerUtil.log_type_error( "Issue With-VerifyLoadBalAddVIP" +  e.getMessage());
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
				}
			
			}*/
		
			
			/*==============================================================
			TestScript  	: VerifyLoadBalInstanceTab()
			Manual TestCase	: WCP_881_TC_1.0_EVDC_Load Balancer_Instance Tab display details-Verification in DB	
			Description		: Verify Instance Tab display details.
			Author 			: Priyanka R
			Creation Date 	: 12/01/2015
			Release         : Hague
			Pre-Requisites	:
			Revision History:
			==============================================================
			@Test(priority=32)
			public void VerifyLoadBalInstanceTab()
			{
				WebDriver driver = WebDriverUtil.getDriver();
				
				PageFactory.initElements(driver, EVDC_OverviewPF);
				PageFactory.initElements(driver, Ticket);
				PageFactory.initElements(driver, Home);
				PageFactory.initElements(driver, EVDC_VMPF);
				PageFactory.initElements(driver, LoadBalancer);
				
				try {
				String sUserName,sPassword,sEVDCInstanceLBHeader,sLBHeader;
				FrameworkUtil.sTestCaseName = "Hague-VerifyLoadBalInstanceTab";
				FrameworkUtil.sManualTestCaseName="Verify the Load Balancer portlet display on EVDC over view page";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
               
				
				
				sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.USER.HAWKEYE.USERID");
				sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.USER.HAWKEYE.PASSWORD");
				
				
				//Login
				LoginTestCase.nav_Login(sUserName, sPassword);
				WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
				WebObjectUtil.explicitWait(10);
			    WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCLBLink());
			    WebObjectUtil.explicitWait(10);
                WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_InstancesTab());
                WebObjectUtil.explicitWait(10);
                WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCInstancePdfIcon());
                WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCInstanceCsvIcon());
                VerifyEVDCLBHeaderValues();
                //Sorting is out of scope-Verify that all columns are sortable with default sorting is by Load Balancer column
                WebElement wLBExpander= WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.LOAD.BALANCER.INSTANCE.ROW.EXPANDER","","");;
                WebObjectUtil.clickElement(wLBExpander);
                WebObjectUtil.explicitWait(5);
                verifyRefreshEditDeletelinksinLBTabsRowExpander();
                
                }
				
				
				catch (Exception e) {
					// TODO Auto-generated catch block
			         	LoggerUtil.log_type_error( "Issue With-VerifyLoadBalAddVIPTicketDetails" +  e.getMessage());
					    FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
				}
			}*/
			
			
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
		
			
			
	
			
	
		
		
/////////////////////////////////////EVDC_VM\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
		

		
		
		
		

		
		
		
		//update each @Test result in custom result file
			@AfterMethod
			public static void afterEachMethod(){
			FrameworkUtil.updateTestCaseStatusinResult();
				
			}

			@AfterTest
			public void afterTest(){
				if (sLoginExpandVM || LoginTestCase_Old1.bLoginStatus ){
				FrameworkUtil.sTestCaseName = "Logout";
				FrameworkUtil.sManualTestCaseName="Logout Navigator";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				LoginTestCase_Old1.nav_Logout();
				FrameworkUtil.updateTestCaseStatusinResult();
				}
			}
		
	}


