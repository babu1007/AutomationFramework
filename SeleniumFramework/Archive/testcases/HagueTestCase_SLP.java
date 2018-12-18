package com.whs.navigator.testcases;

import java.awt.event.ActionEvent;

import org.openqa.selenium.JavascriptExecutor;
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
import com.whs.navigator.pagefactory.HomePageFactory;
import com.whs.navigator.pagefactory.EM7PageFactory;
import com.whs.navigator.pagefactory.AdminPageFactory;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.TicketPageFactory;
import com.whs.navigator.pagefactory.DraasPageFactory;
import com.whs.navigator.pagefactory.EntityBrowserPageFactory;
import com.whs.navigator.pagefactory.UserPermissionPageFactory;
import com.whs.navigator.pagefactory.LoadBalancerPageFactory;
import com.whs.navigator.pagefactory.EVDC_VM_PageFactory;

public class HagueTestCase_SLP {
	
	public static HomePageFactory Home = new HomePageFactory();
	public static EM7PageFactory EM7 = new EM7PageFactory();
	public static AdminPageFactory Admin = new AdminPageFactory();
	public static EVDC_OverviewPageFactory EVDC_OverviewPF =new EVDC_OverviewPageFactory();
	public static TicketPageFactory Ticket = new TicketPageFactory();
	public static EntityBrowserPageFactory EBPanel = new EntityBrowserPageFactory();
	public static DraasPageFactory Draas = new DraasPageFactory();
	public static UserPermissionPageFactory UserPermission = new UserPermissionPageFactory();
	public static LoadBalancerPageFactory LoadBalancer = new LoadBalancerPageFactory();
	public static EVDC_VM_PageFactory EVDC_VM = new EVDC_VM_PageFactory();
	
	static String sFeedbackTitle=null;
	

	
	//QAT-286 already covered and script is in Tickets Page
	
	
	
	

	

		
	/*====================================================================================================
	Method Name 	: navAdminClickActionsButtonOrg
	Description		: Clicking on actions button with respect to selected organization in Organization Table
	Author 			: QAA03
	Creation Date 	: 12/02/2015
	Pre-Requisites	:
	Revision History:
	====================================================================================================*/
	public static void navAdminClickActionsButtonOrg(String sOrganization)
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,Admin);
			WebElement wRowActionsButton;
			int iRowNumber=0;
				
     try {
        	CustomWebElementUtil.loadCustomElement(Admin.getNav_Admin_OrganizationsParentWebTable(), "tr");
		    iRowNumber = CustomWebElementUtil.getRowByCellText(sOrganization,1);
		    wRowActionsButton = WebObjectUtil.getWebElementFromDynamicLocator("xpath","ADMIN.MANAGE.CONTROLPANEL.ORGS.ORGTABLE.ACTIONSBUTTON", "PARAMETER_ROWNUMBER", iRowNumber+"");
			WebObjectUtil.clickElement(wRowActionsButton);
			
			  
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navAdminClickActionsButtonOrg", "warn", "catch block:" +e.getMessage());  
		}
		
	}
	
	/*====================================================================================================
	Method Name 	: navigatingToControlPanelOrgPage
	Description		: Navigating to Organizations page in Control Panel
	Author 			: QAA03
	Creation Date 	: 12/02/2015
	Pre-Requisites	:
	Revision History:
	====================================================================================================*/
	public static void navigatingToControlPanelOrgPage()
	{
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,Admin);
			
				
     try {   	
    	    WebObjectUtil.MouseHover(Admin.getNav_Admin_ManageTab());
			WebObjectUtil.clickElement(Admin.getNav_Admin_ControlPanelLink());
			WebObjectUtil.waitForElementPresent(Admin.getNav_Admin_ControlPanelText());
			WebObjectUtil.verifyElementPresent(Admin.getNav_Admin_ControlPanelText());
			WebObjectUtil.clickElement(Admin.getNav_Admin_OrganizationsLink());
			  
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navigatingToControlPanelOrgPage", "warn", "catch block:" +e.getMessage());  
		}
		
	}
	
	
	
	
	
	
	
	
	
		
	//update each @test result in custom result file
			@AfterMethod
	public static void afterEachMethod(){
				
			FrameworkUtil.updateTestCaseStatusinResult();
				
			}
}

		



