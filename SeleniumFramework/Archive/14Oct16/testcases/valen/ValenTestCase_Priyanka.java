package com.whs.navigator.testcases.valen;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import org.openqa.selenium.JavascriptExecutor;

import com.whs.navigator.commonUtil.CustomWebElementUtil;
import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.commonUtil.WebTableUtil;
import com.whs.navigator.pagefactory.DNSPageFactory;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.EVDC_StorageProfilePageFactory;
import com.whs.navigator.pagefactory.EVDC_VM_PageFactory;
import com.whs.navigator.pagefactory.EscalationPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.LoadBalancerPageFactory;
import com.whs.navigator.pagefactory.PhysicalServicesPageFactory;
import com.whs.navigator.pagefactory.SmokeTestPageFactory;
import com.whs.navigator.pagefactory.DraasPageFactory;
import com.whs.navigator.pagefactory.CommonPageFactory;
import com.whs.navigator.pagefactory.TicketPageFactory;
import com.whs.navigator.testcases.TicketTestCase;
import com.whs.navigator.pagefactory.FirewallPageFactory;
import com.whs.navigator.pagefactory.EM7PageFactory;
import com.whs.navigator.pagefactory.FormPageFactory;
import com.whs.navigator.pagefactory.EntityBrowserPageFactory;
import com.whs.navigator.testcases.LoginTestCase_Old1;
import com.whs.navigator.pagefactory.UserPermissionPageFactory;
import com.whs.navigator.testcases.EntityBrowserTestCase;
import com.whs.navigator.pagefactory.EVDC_FirewallPageFactory;
import com.whs.navigator.pagefactory.EVDC_StorageProfilePageFactory;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ValenTestCase_Priyanka {
	
	public static EVDC_StorageProfilePageFactory EVDC_Storage = new EVDC_StorageProfilePageFactory();
	public static EVDC_OverviewPageFactory EVDC_OverviewPF = new EVDC_OverviewPageFactory();
	public static CommonPageFactory Common = new CommonPageFactory();
	public static HomePageFactory_old Home = new HomePageFactory_old();
	public static SmokeTestPageFactory Smoke = new SmokeTestPageFactory();
	public static EVDC_VM_PageFactory EVDC_VMPF=new EVDC_VM_PageFactory();
	public static TicketPageFactory Ticket = new TicketPageFactory();
	
	
	/*==============================================================
	TestScript  	: VerifyPrivateStoragePortlet
	Manual TestCase	: QAT-1706_WCP_5933_TC_1.0_Elastic Storage->Private Storage portlet.
	Description		:
	Author 			: Priyanka 
	Creation Date 	: 05/08/2015
	Release         : Valen
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	   @Test(priority=1)
	   
	   public void VerifyPrivateStoragePortlet() {

		   try{
				WebDriver driver = WebDriverUtil.getDriver();
				
				PageFactory.initElements(driver, EVDC_Storage);
				PageFactory.initElements(driver, EVDC_OverviewPF);
				
				
				FrameworkUtil.sTestCaseName = "EVDCStorage-VerifyPrivateStoragePortlet";
				FrameworkUtil.sManualTestCaseName = "QAT-1706_WCP_5933_TC_1.0_Elastic Storage->Private Storage portlet.";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
				com.whs.navigator.testcases.LoginTestCase_Old1.LoginAsGirUser();
				WebObjectUtil.explicitWait(EVDC_OverviewPF.getNav_PrivateEVDCLink());
				WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_PrivateEVDCLink());
				WebObjectUtil.explicitWait(EVDC_Storage.getNav_EVDCStoragePortlet());
				WebObjectUtil.verifyElementPresent(EVDC_Storage.getNav_EVDCStoragePortlet());
			    WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCOverviewStorage());
			    WebObjectUtil.explicitWait(EVDC_Storage.getNav_StorageProfileChartArea());
			    WebObjectUtil.verifyElementPresent(EVDC_Storage.getNav_StorageProfileChartArea());
			    com.whs.navigator.testcases.LoginTestCase_Old1.nav_Logout();
			   
		   }
		   catch(Exception e)
			{
				LoggerUtil.log_type_error("issue with-VerifyPrivateStoragePortlet()" );
				LoggerUtil.log_type_error(e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
			}
		   

		}
	   
	   
		 
				/*==============================================================
				TestScript  	: verifyAddStorageTierTktKrikjUser()
				Manual TestCase	: QAT-1737_WCP_6013_TC_1.0_ Add new storage_create ticket_queue name virtualization
				Description		: When a ticket is created, verify the queue name is virtualization for this ticket.
				Author 			: Priyanka R
				Creation Date 	: 06/02/2016
				Pre-Requisites	:
				Release         : Valen
				Revision History:
				==============================================================*/
				@Test(priority=3)
				public void verifyAddStorageTierTktKrikjUser(){
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver, Ticket);
					PageFactory.initElements(driver, EVDC_OverviewPF);
					PageFactory.initElements(driver, EVDC_VMPF);
					
					
					try {
						FrameworkUtil.sTestCaseName = "verifyAddStorageTierTktKrikjUser()";
						FrameworkUtil.sManualTestCaseName="QAT-1737_WCP_6013_TC_1.0_ Add new storage_create ticket_queue name virtualization";
						FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
						 com.whs.navigator.testcases.LoginTestCase_Old1.LoginAsKirkjUser();
				         WebObjectUtil.explicitWait(EVDC_OverviewPF.getNav_EVDCname());
				         WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
			             WebObjectUtil.explicitWait(5);
			             WebObjectUtil.clickElement(EVDC_VMPF.getNav_EVDCStorageLink());
			             WebObjectUtil.explicitWait(5);
			             TicketTestCase.VerifyAddStorageTkt();
			             com.whs.navigator.testcases.LoginTestCase_Old1.nav_Logout();
			               
					}
					catch (Exception e) {
						LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
						
						}
					} 
		 
			   
			   

			
		@AfterMethod
		public static void afterEachMethod(){
			FrameworkUtil.updateTestCaseStatusinResult();
			WebDriverUtil.quitWebDriver();

		}
}
