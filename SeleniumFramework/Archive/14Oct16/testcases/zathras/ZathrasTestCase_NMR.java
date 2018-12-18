package com.whs.navigator.testcases.zathras;

import java.awt.Frame;

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
import com.whs.navigator.pagefactory.CommonPageFactory;
import com.whs.navigator.pagefactory.LoadBalancerPageFactory;
import com.whs.navigator.testcases.FirewallTestCase_GOM;
import com.whs.navigator.testcases.LoadBalancersTestCase;
import com.whs.navigator.testcases.LoginTestCase;
import com.whs.navigator.testcases.Lefcourt.LefCourt_SP2TestCase_NMR;

public class ZathrasTestCase_NMR {

	public static LoadBalancerPageFactory LoadBalancer = new LoadBalancerPageFactory();
	public static CommonPageFactory Common = new CommonPageFactory();
	
	/*==============================================================
	TestScript 		: VerifyAddPoolAndRefreshBtnFunctionality
	Manual TestCase	: QAT-1814,QAT-1813,QAT-1812,QAT-1811		  
	Description		: Add a pool is submitted and message will be displayed in the feedback area.
	Author 			: QAA04
	Release name    : Zathras
	Creation Date 	: 08/29/2016
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=1)
	public void VerifyAddPoolAndRefreshBtnFunctionality(){
		
		String sPoolName,sHealthMonotorVisibleText,sBalancingVisibleText,sPDFSrc,sCSVSrc,sSucessMsg,sFeedBackMsg;
		boolean bStatus;
		WebElement wExpander,wRefreshBtn,wEditBtn,wDeleteBtn;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, LoadBalancer);
		PageFactory.initElements(driver, Common);
		try {
			FrameworkUtil.sTestCaseName="VerifyAddPoolAndRefreshBtnFunctionality";
			FrameworkUtil.sManualTestCaseName="(QAT-1814)(QAT-1813)(QAT-1812)(QAT-1811)Add a pool is submitted and message will be displayed in the feedback area.";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to navigator
			LoginTestCase.LoginAsAgentUser();
			
			// navigating to the load balancer page
			LoadBalancersTestCase.NavigatingToLoadBalancerPage();
			LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
			WebObjectUtil.clickElement(LoadBalancer.getNavPoolsTab());
			
			WebObjectUtil.clickElement(LoadBalancer.getNavPools_AddLB());
			WebObjectUtil.explicitWait(3);
			sPoolName = (String) FrameworkUtil.dictPropertyData.get("NAV.LOADBALANCER.ADDPOOL.POOLNAME");
			sHealthMonotorVisibleText = (String) FrameworkUtil.dictPropertyData.get("NAV.LOADBALANCER.ADDPOOL.HEALTHMANITOR");
			sBalancingVisibleText = (String) FrameworkUtil.dictPropertyData.get("NAV.LOADBALANCER.ADDPOOL.BALANCINGMETHOD");
			sPoolName = sPoolName+FrameworkUtil.sTimeStamp;
			navAddPool(sPoolName, sHealthMonotorVisibleText, sBalancingVisibleText);
			WebObjectUtil.explicitWait(3);
			LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
			WebObjectUtil.clickElement(LoadBalancer.getNavPoolsTab());
			WebObjectUtil.explicitWait(5);
			 
			//Verifying PDF for Pools
				sPDFSrc=LoadBalancer.getNavPoolsTab_PDFIcon().getAttribute("src");
				bStatus=sPDFSrc.contains("PDF");
				FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "PDF file verified for Pools");
				//Verifying CSV for Pools
				sCSVSrc=LoadBalancer.getNavPoolsTab_CSVIcon().getAttribute("src");
				bStatus=sCSVSrc.contains("CSV");
				FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "CSV file verified for Pools");
			 
			   wExpander = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "EVDC.POOL.LOADBALANCER.TABLE.EXPANDER","PARAMETER_ROWNUMBER", 1+"");
			   WebObjectUtil.clickElement(wExpander);
			   WebObjectUtil.explicitWait(3);
			   wEditBtn= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "EVDC.POOL.LOADBALANCER.EXPANDER.EDIT.BUTTON", "PARAMETER_ROWNUMBER", 1 +"");
			   WebObjectUtil.verifyElementPresent(wEditBtn);
			   
			   wDeleteBtn = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "EVDC.POOL.LOADBALANCER.EXPANDER.DELETE.BUTTON", "PARAMETER_ROWNUMBER", 1 +"");
			   WebObjectUtil.verifyElementPresent(wDeleteBtn);
			   
			   wRefreshBtn = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "EVDC.POOL.LOADBALANCER.EXPANDER.REFRESHDETAILS.BUTTON", "PARAMETER_ROWNUMBER", 1 +"");
			   WebObjectUtil.verifyElementPresent(wRefreshBtn);
			   WebObjectUtil.clickElement(wRefreshBtn);
			   WebObjectUtil.explicitWait(5);
			   sSucessMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.LOADBALNCER.FEEDBACK.MESSAGE");
			   sFeedBackMsg =Common.getNav_UsrFeedBack().getText();
				bStatus=sFeedBackMsg.contains(sSucessMsg);
				FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Refresh details button sucess msg verified");
			   
				// log out
				LoginTestCase.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("Issue with VerifyAddPoolAndRefreshBtnFunctionality test case");
			LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage()+"null");
		   }
		
	}
	
	/*==============================================================
	TestScript 		:verifyAddPoolEditFiledsFunctionality
	Manual TestCase	:(QAT-1810)(QAT-1807)(QAT-1806)(QAT-1805)(QAT-1804)(QAT-1801)(QAT-1800) 
	Description		:verify the error message when user added duplicate members when adding a pool. 
	Author 			:QAA04
	Release name    :Zathras
	Creation Date 	:08/30/2016
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=2)
	public void verifyAddPoolEditFiledsFunctionality(){
		String sPoolName,sHealthMonotorVisibleText,sBalancingVisibleText,sMemberName,sFeedBackMsg,sMessage,sErrorMsg,sFailedMessage,sSubmitActive;
		WebElement wAddMemberDropDownArrow,wPort,wDelete;
		boolean bStatus;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, LoadBalancer);
		PageFactory.initElements(driver, Common);
		try {
			FrameworkUtil.sTestCaseName="verifyAddPoolEditFiledsFunctionality";
			FrameworkUtil.sManualTestCaseName="(QAT-1810)(QAT-1807)(QAT-1806)(QAT-1805)(QAT-1804)(QAT-1801)(QAT-1800)verify the failed message in the feedback area.";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to navigator
			LoginTestCase.LoginAsAgentUser();
			
			// navigating to the load balancer page
			LoadBalancersTestCase.NavigatingToLoadBalancerPage();
			LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
			WebObjectUtil.clickElement(LoadBalancer.getNavPoolsTab());
		
			WebObjectUtil.clickElement(LoadBalancer.getNavPools_AddLB());
			WebObjectUtil.explicitWait(3);
			sPoolName = (String) FrameworkUtil.dictPropertyData.get("NAV.LOADBALANCER.ADDPOOL.POOLNAME");
			sHealthMonotorVisibleText = (String) FrameworkUtil.dictPropertyData.get("NAV.LOADBALANCER.ADDPOOL.HEALTHMANITOR");
			sBalancingVisibleText = (String) FrameworkUtil.dictPropertyData.get("NAV.LOADBALANCER.ADDPOOL.BALANCINGMETHOD");
			sPoolName = sPoolName+FrameworkUtil.sTimeStamp;
			
			WebObjectUtil.SetValueEdit(LoadBalancer.getNav_AddPool_PoolName(), sPoolName);
			LefCourt_SP2TestCase_NMR.SelectElementFromDropDown(LoadBalancer.getNav_AddPool_HealthMonitorDropDownArrow(), sHealthMonotorVisibleText);
			WebObjectUtil.clickElement(LoadBalancer.getNav_AddPool_PoolName());
			WebObjectUtil.clickElement(LoadBalancer.getNav_AddPool_HealthMonitorEditField());
			WebObjectUtil.explicitWait(2);
			LefCourt_SP2TestCase_NMR.SelectElementFromDropDown(LoadBalancer.getNav_AddPool_BalancingMethodDropDownArrow(), sBalancingVisibleText);
			
			WebObjectUtil.clickElement(LoadBalancer.getNav_AddPool_AddMemberLink());
			
			sMemberName= (String) FrameworkUtil.dictPropertyData.get("NAV.LOADBALANCER.ADDPOOL.ADDMEMBER.MEMBERNAME");
			wAddMemberDropDownArrow=WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.LOADBALANCER.ADDPOOL.ADDMEMBER.MEMBERNAME.DROPDOWNARROW", "PARAMETER_ADDMEMBERNUMBER", 0+"");
			LefCourt_SP2TestCase_NMR.SelectElementFromDropDown(wAddMemberDropDownArrow, sMemberName);
			
			wPort = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.LOADBALANCER.ADDPOOL.ADDMEMBER.PORT.EDITFIELD", "PARAMETER_ADDMEMBERNUMBER", 0+"");
            WebObjectUtil.SetValueEdit(wPort, "1");
            
            WebObjectUtil.clickElement(LoadBalancer.getNav_AddPool_AddMemberLink());
			
			sMemberName= (String) FrameworkUtil.dictPropertyData.get("NAV.LOADBALANCER.ADDPOOL.ADDMEMBER.MEMBERNAME");
			wAddMemberDropDownArrow=WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.LOADBALANCER.ADDPOOL.ADDMEMBER.MEMBERNAME.DROPDOWNARROW", "PARAMETER_ADDMEMBERNUMBER", 1+"");
			LefCourt_SP2TestCase_NMR.SelectElementFromDropDown(wAddMemberDropDownArrow, sMemberName);
			
			wPort = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.LOADBALANCER.ADDPOOL.ADDMEMBER.PORT.EDITFIELD", "PARAMETER_ADDMEMBERNUMBER", 1+"");
            WebObjectUtil.SetValueEdit(wPort, "2");
			
            WebObjectUtil.clickElement(LoadBalancer.getNav_AddPool_AddMemberLink());
			
			sMemberName= (String) FrameworkUtil.dictPropertyData.get("NAV.LOADBALANCER.ADDPOOL.ADDMEMBER.MEMBERNAME");
			wAddMemberDropDownArrow=WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.LOADBALANCER.ADDPOOL.ADDMEMBER.MEMBERNAME.DROPDOWNARROW", "PARAMETER_ADDMEMBERNUMBER", 2+"");
			LefCourt_SP2TestCase_NMR.SelectElementFromDropDown(wAddMemberDropDownArrow, sMemberName);
			
			wPort = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.LOADBALANCER.ADDPOOL.ADDMEMBER.PORT.EDITFIELD", "PARAMETER_ADDMEMBERNUMBER", 2+"");
            WebObjectUtil.SetValueEdit(wPort, "2");
            WebObjectUtil.explicitWait(2);
            WebObjectUtil.clickElement(LoadBalancer.getNav_AddPool_SubmitBtn());
			WebObjectUtil.explicitWait(5);
			sErrorMsg=Common.getNav_CommonPopUpMessage().getText();
            FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verifying the error pop up", "pass", sErrorMsg);
			WebObjectUtil.clickElement(Common.getNav_CommonPopUpOKButton());
			
			WebObjectUtil.explicitWait(2);
            wDelete = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.LOADBALANCER.ADDPOOL.ADDMEMBER.DELETEICON", "PARAMETER_ADDMEMBERNUMBER", 2+"");
            WebObjectUtil.clickElement(wDelete);
            
            sSubmitActive =LoadBalancer.getNav_AddPool_SubmitBtn().getAttribute("class");
            bStatus = sSubmitActive.contains("x-btn-disabled");
            FrameworkUtil.updateCustomResultBasedOnStatus(!bStatus, "Submit button is enabled");
            
            WebObjectUtil.clickElement(LoadBalancer.getNav_AddPool_SubmitBtn());
			WebObjectUtil.explicitWait(5);
			sFeedBackMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.LOADBALANCER.ADDPOOL.SUCESS.MESSAGE");
			sMessage = Common.getNav_UsrFeedBack().getText();
			bStatus = sMessage.equalsIgnoreCase(sFeedBackMsg);
            FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, sMessage);
            WebObjectUtil.explicitWait(5);
            driver.navigate().refresh();
            WebObjectUtil.explicitWait(5);
            LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
            sFailedMessage = (String) FrameworkUtil.dictPropertyData.get("NAV.LOADBALANCER.ADDPOOL.FAILED.MESSAGE");
            sMessage = Common.getNav_UsrFeedBack().getText();
			bStatus = sMessage.equalsIgnoreCase(sFailedMessage);
            FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, sMessage);
            
            // log out
            LoginTestCase.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("Issue with verifyAddPoolEditFiledsFunctionality test case");
			LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage()+"null");
		   }
		
	}
	/*==============================================================
	TestScript 		: verifyResetBtnFunctionality
	Manual TestCase	: QAT-1794
	Description		: Verify that all the fields data is removed when user clicks on Reset button.
	Author 			: QAA04
	Release name    : Zathras
	Creation Date 	: 09/01/2016
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=3)
	public void verifyResetBtnFunctionality(){
		String sPoolName,sHealthMonotorVisibleText,sBalancingVisibleText;
		boolean bStatus;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, LoadBalancer);
		
		
		try {
			FrameworkUtil.sTCStartTime="verifyResetBtnFunctionality";
			FrameworkUtil.sManualTestCaseName="LoadBalancer-(QAT-1794)-Zathras- Verify that all the fields data is removed when user clicks on Reset button.";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to the navigator
			LoginTestCase.LoginAsAgentUser();
			
			// navigating to the loadbalancer page
			LoadBalancersTestCase.NavigatingToLoadBalancerPage();
			LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
			WebObjectUtil.clickElement(LoadBalancer.getNavPoolsTab());
			WebObjectUtil.explicitWait(3);
			
			sPoolName = (String) FrameworkUtil.dictPropertyData.get("NAV.LOADBALANCER.ADDPOOL.POOLNAME");
			sHealthMonotorVisibleText = (String) FrameworkUtil.dictPropertyData.get("NAV.LOADBALANCER.ADDPOOL.HEALTHMANITOR");
			sBalancingVisibleText = (String) FrameworkUtil.dictPropertyData.get("NAV.LOADBALANCER.ADDPOOL.BALANCINGMETHOD");
			sPoolName = sPoolName+FrameworkUtil.sTimeStamp;
			
			WebObjectUtil.clickElement(LoadBalancer.getNavPools_AddLB());
			WebObjectUtil.SetValueEdit(LoadBalancer.getNav_AddPool_PoolName(), sPoolName);
			LefCourt_SP2TestCase_NMR.SelectElementFromDropDown(LoadBalancer.getNav_AddPool_HealthMonitorDropDownArrow(), sHealthMonotorVisibleText);
			WebObjectUtil.clickElement(LoadBalancer.getNav_AddPool_PoolName());
			WebObjectUtil.clickElement(LoadBalancer.getNav_AddPool_HealthMonitorEditField());
			WebObjectUtil.explicitWait(2);
			LefCourt_SP2TestCase_NMR.SelectElementFromDropDown(LoadBalancer.getNav_AddPool_BalancingMethodDropDownArrow(), sBalancingVisibleText);
			
     WebObjectUtil.clickElement(LoadBalancer.getNav_AddPool_ResetBtn());
     WebObjectUtil.explicitWait(3);
     bStatus = LoadBalancer.getNav_AddPool_PoolName().getText().contains("");
     FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Pool name edit feild is empty");
     
     bStatus = LoadBalancer.getNav_AddPool_HealthMonitorEditField().getText().contains("");
     FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Health monitor edit feild is empty");
     
     bStatus = LoadBalancer.getNav_AddPool_BalancingMethodEditField().getText().contains("");
     FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Balancing method edit feild is empty");

     // log out 
     LoginTestCase.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("Issue with verifyResetBtnFunctionality test case");
			LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage()+"null");
		   }
	}
	
	/*==============================================================
	TestScript 		: verifyAddPoolEditFeilds
	Manual TestCase	: QAT-1782
	Description		: verify add pool edit feilds.
	Author 			: QAA04
	Release name    : Zathras
	Creation Date 	: 09/02/2016
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=4)
	public void verifyAddPoolEditFeilds(){
		String sPoolName,sHealthMonotorVisibleText,sBalancingVisibleText;
		WebElement wAddMemberDropDownArrow,wPort,wDelete;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, LoadBalancer);
		
		try {
			FrameworkUtil.sTestCaseName="verifyAddPoolEditFeilds";
			FrameworkUtil.sManualTestCaseName="Loadbalancer-(QAT-1782)-Zathras- verify add pool edit feilds.";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to the navigator
			LoginTestCase.LoginAsAgentUser();
			
			// navigating to the loadbalancer page
				LoadBalancersTestCase.NavigatingToLoadBalancerPage();
				LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
				WebObjectUtil.clickElement(LoadBalancer.getNavPoolsTab());
				WebObjectUtil.explicitWait(3);
				
				sPoolName = (String) FrameworkUtil.dictPropertyData.get("NAV.LOADBALANCER.ADDPOOL.POOLNAME");
				sHealthMonotorVisibleText = (String) FrameworkUtil.dictPropertyData.get("NAV.LOADBALANCER.ADDPOOL.HEALTHMANITOR");
				sBalancingVisibleText = (String) FrameworkUtil.dictPropertyData.get("NAV.LOADBALANCER.ADDPOOL.BALANCINGMETHOD");
				sPoolName = sPoolName+FrameworkUtil.sTimeStamp;
				
				WebObjectUtil.clickElement(LoadBalancer.getNavPools_AddLB());
				WebObjectUtil.explicitWait(2);
			    WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_AddPool_PoolName());
			    WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_AddPool_HealthMonitorEditField());
			    WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_AddPool_BalancingMethodEditField());
			    
			    WebObjectUtil.clickElement(LoadBalancer.getNav_AddPool_AddMemberLink());
			    WebObjectUtil.explicitWait(3);
			    wAddMemberDropDownArrow=WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.LOADBALANCER.ADDPOOL.ADDMEMBER.MEMBERNAME.DROPDOWNARROW", "PARAMETER_ADDMEMBERNUMBER", 0+"");
				WebObjectUtil.verifyElementPresent(wAddMemberDropDownArrow);
				
				wPort = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.LOADBALANCER.ADDPOOL.ADDMEMBER.PORT.EDITFIELD", "PARAMETER_ADDMEMBERNUMBER", 0+"");
			    WebObjectUtil.verifyElementPresent(wPort);
			    
			    wDelete = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.LOADBALANCER.ADDPOOL.ADDMEMBER.DELETEICON", "PARAMETER_ADDMEMBERNUMBER", 0+"");
			    WebObjectUtil.verifyElementPresent(wDelete);
			    
			    WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_AddPool_SubmitBtn());
			    WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_AddPool_ResetBtn());
			    
			   // log out
			   LoginTestCase.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("Issue with verifyAddPoolEditFeilds test case");
			LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage()+"null");
		   }
	}
	
	/*==============================================================
	TestScript 		: navEditPool
	Manual TestCase	: QAT-1781
	Description		: verify the edited pool info.
	Author 			: QAA04
	Release name    : Zathras
	Creation Date 	: 09/06/2016
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=5)
	public void navEditPool(){
		WebElement wExpander,wEditBtn,wHealthMonitorText,wDropDownElement;
		String sHealthMonitorvisibleText1,sHealthMonitorvisibleText2,sSucessMsg,sFeedBackMsg,sHealthMonitorText;
		boolean bStatus;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, LoadBalancer);
		PageFactory.initElements(driver, Common);
		try{
		FrameworkUtil.sTestCaseName="navEditPool";
		FrameworkUtil.sManualTestCaseName="LoadBalancer-QAT-1781-Zathras- Verify the edited pool info.";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		
		// login to the navigator
		LoginTestCase.LoginAsAgentUser();
		
		// navigating to the load balancers page.
		LoadBalancersTestCase.NavigatingToLoadBalancerPage();
		LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
		WebObjectUtil.clickElement(LoadBalancer.getNavPoolsTab());
		WebObjectUtil.explicitWait(3);
		
		wExpander = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "EVDC.POOL.LOADBALANCER.TABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
		WebObjectUtil.clickElement(wExpander);
		
		wEditBtn = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "EVDC.POOL.LOADBALANCER.EXPANDER.EDIT.BUTTON", "PARAMETER_ROWNUMBER", 1+"");
		WebObjectUtil.clickElement(wEditBtn);
		
		sHealthMonitorvisibleText1 = (String) FrameworkUtil.dictPropertyData.get("NAV.LOADBALANCER.ADDPOOL.HEALTHMANITOR.VISIBLE.TEXT");
		sHealthMonitorvisibleText2 = (String) FrameworkUtil.dictPropertyData.get("NAV.LOADBALANCER.ADDPOOL.HEALTHMANITOR");
		WebObjectUtil.explicitWait(5);
		WebObjectUtil.clickElement(LoadBalancer.getNav_AddPool_HealthMonitorDropDownArrow());
		wDropDownElement=WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.LOADBALANCER.ADDPOOL.HEALTHMANITOR.DROPDOWN.CHECKBOX", "PARAMETER_DROPDOWNVISIBLETEXT", sHealthMonitorvisibleText1);
		bStatus = WebObjectUtil.isCheckRadioSelected(wDropDownElement);
		if(bStatus==false){
			WebObjectUtil.selectCheckRadioBox(wDropDownElement);
		}
		else{
			WebObjectUtil.deSelectCheckBox(wDropDownElement);
		}
		
		//LefCourt_SP2TestCase_NMR.SelectElementFromDropDown(LoadBalancer.getNav_AddPool_HealthMonitorDropDownArrow(), sHealthMonitorvisibleText1);
		WebObjectUtil.clickElement(LoadBalancer.getNav_AddPool_PoolName());
		WebObjectUtil.clickElement(LoadBalancer.getNav_AddPool_HealthMonitorEditField());
		WebObjectUtil.explicitWait(2);
		
		/*LefCourt_SP2TestCase_NMR.SelectElementFromDropDown(LoadBalancer.getNav_AddPool_HealthMonitorDropDownArrow(), sHealthMonitorvisibleText2);
		WebObjectUtil.clickElement(LoadBalancer.getNav_AddPool_PoolName());
		WebObjectUtil.explicitWait(2);
		*/
		WebObjectUtil.clickElement(LoadBalancer.getNav_AddPool_SubmitBtn());
		WebObjectUtil.explicitWait(5);
		
		sFeedBackMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.LOADBALANCER.EDITPOOL.SUCESS.MESSAGE");
		sSucessMsg = Common.getNav_UsrFeedBack().getText();
		bStatus = sSucessMsg.contains(sFeedBackMsg);
		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, sSucessMsg);
		
		driver.navigate().refresh();
		WebObjectUtil.explicitWait(4);
		LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
		WebObjectUtil.clickElement(LoadBalancer.getNavPoolsTab());
		WebObjectUtil.explicitWait(3);
		
		wExpander = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "EVDC.POOL.LOADBALANCER.TABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
		WebObjectUtil.clickElement(wExpander);
		
		wHealthMonitorText =WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.LOADBALANCER.EXPANDEDROW.HEALTHMONITOER.TEXT", "PARAMETER_ROWNUMBER", 1+"");
		sHealthMonitorText= wHealthMonitorText.getText();
		
		bStatus = sHealthMonitorvisibleText1.contains(sHealthMonitorvisibleText1);
		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Pool is edited");
		
	
		// log out
		LoginTestCase.nav_Logout();
	}  catch (Exception e) {
			LoggerUtil.log_type_error("Issue with navEditPool test case");
			LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage()+"null");
		   }
	}
	
	/*==============================================================
	TestScript 		: navEditMemberFieldInPoolsTab
	Manual TestCase	: QAT-1780
	Description		:
	Author 			: QAA04
	Release name    : Zathras
	Creation Date 	: 09/13/2016
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=6)
	public void navEditMemberFieldInPoolsTab(){
		
		String sSucessMessage,sMessage,sMemberName;
		Boolean bStatus;
		WebElement wExpander,wEditBtn,wDelete,wAddMemberDropDownArrow,wPort;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, LoadBalancer);
		PageFactory.initElements(driver, Common);
		try{
		FrameworkUtil.sTestCaseName="navEditMemberFieldInPoolsTab";
		FrameworkUtil.sManualTestCaseName="LoadBalancer-QAT-1780-Zathras- User is able to submit the edits successfully.";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		
		// login to the navigator
		LoginTestCase.LoginAsAgentUser();
		
		// navigating to the load balancers page.
		LoadBalancersTestCase.NavigatingToLoadBalancerPage();
		LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
		WebObjectUtil.clickElement(LoadBalancer.getNavPoolsTab());
		WebObjectUtil.explicitWait(3);
		
		wExpander = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "EVDC.POOL.LOADBALANCER.TABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
		WebObjectUtil.clickElement(wExpander);
		
		wEditBtn = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "EVDC.POOL.LOADBALANCER.EXPANDER.EDIT.BUTTON", "PARAMETER_ROWNUMBER", 1+"");
		WebObjectUtil.clickElement(wEditBtn);
		
		WebObjectUtil.explicitWait(4);
      
		WebObjectUtil.clickElement(LoadBalancer.getNav_AddPool_AddMemberLink());
		WebObjectUtil.explicitWait(3);
		sMemberName= (String) FrameworkUtil.dictPropertyData.get("NAV.LOADBALANCER.ADDPOOL.ADDMEMBER.MEMBERNAME");
		wAddMemberDropDownArrow=WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.LOADBALANCER.ADDPOOL.ADDMEMBER.MEMBERNAME.DROPDOWNARROW", "PARAMETER_ADDMEMBERNUMBER", 0+"");
		LefCourt_SP2TestCase_NMR.SelectElementFromDropDown(wAddMemberDropDownArrow, sMemberName);
		
	
		WebObjectUtil.explicitWait(3);
        WebObjectUtil.clickElement(LoadBalancer.getNav_AddPool_SubmitBtn());
		//WebObjectUtil.explicitWait(5);
		
		WebObjectUtil.explicitWait(5);
	   driver.navigate().refresh();
	   FirewallTestCase_GOM.waitForFeedbackMsgNotdisplayed();

	   sSucessMessage = (String) FrameworkUtil.dictPropertyData.get("NAV.LOADBALANCER.EDITPOOL.SUCESS.MESSAGE");
	   sMessage = Common.getNav_UsrFeedBack().getText();
	   bStatus = sMessage.equalsIgnoreCase(sSucessMessage);
	   FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, sMessage);
	   
	   
	// log out
	   LoginTestCase.nav_Logout();
		
		}   catch (Exception e) {
			LoggerUtil.log_type_error("Issue with navMemberFieldInPoolsTab test case");
			LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage()+"null");
		   }
		
		}
	
	/*==============================================================
	TestScript 		: navDeleteMemberFieldsInPoolsTab
	Manual TestCase	: QAT-1779
	Description		: Verify that user is able to delete the existing member when editing the pool.
	Author 			: QAA04
	Release name    : Zathras
	Creation Date 	: 09/13/2016
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=7)
	public void navDeleteMemberFieldsInPoolsTab(){
		
		String sSucessMessage,sMessage,sMemberName,sSubmitActive;
		Boolean bStatus;
		WebElement wExpander,wEditBtn,wDelete,wAddMemberDropDownArrow,wPort;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, LoadBalancer);
		PageFactory.initElements(driver, Common);
		try{
		FrameworkUtil.sTestCaseName="navDeleteMemberFieldsInPoolsTab";
		FrameworkUtil.sManualTestCaseName="LoadBalancer-QAT-1779-Zathras- Verify that user is able to delete the existing member when editing the pool.";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		// login to the navigator
		LoginTestCase.LoginAsAgentUser();
		
		// navigating to the load balancers page.
		LoadBalancersTestCase.NavigatingToLoadBalancerPage();
		LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
		WebObjectUtil.clickElement(LoadBalancer.getNavPoolsTab());
		WebObjectUtil.explicitWait(3);
		
		wExpander = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "EVDC.POOL.LOADBALANCER.TABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
		WebObjectUtil.clickElement(wExpander);
		
		wEditBtn = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "EVDC.POOL.LOADBALANCER.EXPANDER.EDIT.BUTTON", "PARAMETER_ROWNUMBER", 1+"");
		WebObjectUtil.clickElement(wEditBtn);
		
	//	WebObjectUtil.explicitWait(4);
      //  wDelete = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.LOADBALANCER.ADDPOOL.ADDMEMBER.DELETEICON", "PARAMETER_ADDMEMBERNUMBER", 0+"");
      //WebObjectUtil.clickElement(wDelete);		
		WebObjectUtil.explicitWait(2);
        wDelete = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.LOADBALANCER.ADDPOOL.ADDMEMBER.DELETEICON", "PARAMETER_ADDMEMBERNUMBER", 1+"");
        WebObjectUtil.clickElement(wDelete);
        WebObjectUtil.explicitWait(3);
        sSubmitActive =LoadBalancer.getNav_AddPool_SubmitBtn().getAttribute("class");
        bStatus = sSubmitActive.contains("x-btn-disabled");
        FrameworkUtil.updateCustomResultBasedOnStatus(!bStatus, "Submit button is enabled");
		
		WebObjectUtil.explicitWait(3);
        WebObjectUtil.clickElement(LoadBalancer.getNav_AddPool_SubmitBtn());
		//WebObjectUtil.explicitWait(5);
		
		WebObjectUtil.explicitWait(5);
	   driver.navigate().refresh();
	   FirewallTestCase_GOM.waitForFeedbackMsgNotdisplayed();

	   sSucessMessage = (String) FrameworkUtil.dictPropertyData.get("NAV.LOADBALANCER.EDITPOOL.SUCESS.MESSAGE");
	   sMessage = Common.getNav_UsrFeedBack().getText();
	   bStatus = sMessage.equalsIgnoreCase(sSucessMessage);
	   FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, sMessage);
	   
	   
	// log out
	   LoginTestCase.nav_Logout();
		
		}  catch (Exception e) {
			LoggerUtil.log_type_error("Issue with navDeleteMemberFieldsInPoolsTab test case");
			LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage()+"null");
		   }
		}

	/*==============================================================
	TestScript 		: navAddMemberToExistingPool
	Manual TestCase	: QAT-1777, QAT-1775
	Description		: User is able to submit the edits successfully.
	Author 			: QAA04
	Release name    : Zathras
	Creation Date 	: 09/14/2016
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=8)
	public void navAddMemberToExistingPool(){
		
		String sSucessMessage,sMessage,sMemberName;
		Boolean bStatus;
		WebElement wExpander,wEditBtn,wDelete,wAddMemberDropDownArrow,wPort;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, LoadBalancer);
		PageFactory.initElements(driver, Common);
		try{
		FrameworkUtil.sTestCaseName="navAddMemberToExistingPool";
		FrameworkUtil.sManualTestCaseName="LoadBalancer-(QAT-1777)(QAT-1775)-Zathras- User is able to submit the edits successfully.";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		
		// login to the navigator
		LoginTestCase.LoginAsAgentUser();
		
		// navigating to the load balancers page.
		LoadBalancersTestCase.NavigatingToLoadBalancerPage();
		LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
		WebObjectUtil.clickElement(LoadBalancer.getNavPoolsTab());
		WebObjectUtil.explicitWait(3);
		
		wExpander = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "EVDC.POOL.LOADBALANCER.TABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
		WebObjectUtil.clickElement(wExpander);
		
		wEditBtn = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "EVDC.POOL.LOADBALANCER.EXPANDER.EDIT.BUTTON", "PARAMETER_ROWNUMBER", 1+"");
		WebObjectUtil.clickElement(wEditBtn);
		
		WebObjectUtil.explicitWait(4);
       	
		WebObjectUtil.clickElement(LoadBalancer.getNav_AddPool_AddMemberLink());
		WebObjectUtil.explicitWait(3);
		sMemberName= (String) FrameworkUtil.dictPropertyData.get("NAV.LOADBALANCER.ADDPOOL.ADDMEMBER.MEMBERNAME");
		wAddMemberDropDownArrow=WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.LOADBALANCER.ADDPOOL.ADDMEMBER.MEMBERNAME.DROPDOWNARROW", "PARAMETER_ADDMEMBERNUMBER", 2+"");
		LefCourt_SP2TestCase_NMR.SelectElementFromDropDown(wAddMemberDropDownArrow, sMemberName);
		
		wPort = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.LOADBALANCER.ADDPOOL.ADDMEMBER.PORT.EDITFIELD", "PARAMETER_ADDMEMBERNUMBER", 2+"");
        WebObjectUtil.SetValueEdit(wPort, "90");
		
        WebObjectUtil.clickElement(LoadBalancer.getNav_AddPool_AddMemberLink());
		WebObjectUtil.explicitWait(3);
		sMemberName= (String) FrameworkUtil.dictPropertyData.get("NAV.LOADBALANCER.ADDPOOL.ADDMEMBER.MEMBERNAME");
		wAddMemberDropDownArrow=WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.LOADBALANCER.ADDPOOL.ADDMEMBER.MEMBERNAME.DROPDOWNARROW", "PARAMETER_ADDMEMBERNUMBER", 3+"");
		LefCourt_SP2TestCase_NMR.SelectElementFromDropDown(wAddMemberDropDownArrow, sMemberName);
		
		wPort = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.LOADBALANCER.ADDPOOL.ADDMEMBER.PORT.EDITFIELD", "PARAMETER_ADDMEMBERNUMBER", 3+"");
        WebObjectUtil.SetValueEdit(wPort, "70");
        
		WebObjectUtil.explicitWait(3);
        WebObjectUtil.clickElement(LoadBalancer.getNav_AddPool_SubmitBtn());
		//WebObjectUtil.explicitWait(5);
		
		WebObjectUtil.explicitWait(5);
	   driver.navigate().refresh();
	   FirewallTestCase_GOM.waitForFeedbackMsgNotdisplayed();

	   sSucessMessage = (String) FrameworkUtil.dictPropertyData.get("NAV.LOADBALANCER.EDITPOOL.SUCESS.MESSAGE");
	   sMessage = Common.getNav_UsrFeedBack().getText();
	   bStatus = sMessage.equalsIgnoreCase(sSucessMessage);
	   FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, sMessage);
	   
	   
	// log out
	   LoginTestCase.nav_Logout();
		
		}   catch (Exception e) {
			LoggerUtil.log_type_error("Issue with navAddMemberToExistingPool test case");
			LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage()+"null");
		   }
		
		}
	
	
	/*==============================================================
	TestScript 		: navEditPoolName
	Manual TestCase	: QAT-1774
	Description		: Try to edit the Pool name and verify that Pool name is not editable field when editing the pool.
	Author 			: QAA04
	Release name    : Zathras
	Creation Date 	: 09/15/2016
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=9)
	public void navEditPoolName(){
		WebElement wExpander,wEditBtn;
		String sEditPoolName,sPoolName;
		boolean bStatus;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, LoadBalancer);
		PageFactory.initElements(driver, Common);
		try{
		FrameworkUtil.sTestCaseName="navEditPoolName";
		FrameworkUtil.sManualTestCaseName="LoadBalancer-(QAT-1774)-Zathras- Try to edit the Pool name and verify that Pool name is not editable field when editing the pool.";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		
		// login to the navigator
		LoginTestCase.LoginAsAgentUser();
		
		// navigating to the load balancers page.
		LoadBalancersTestCase.NavigatingToLoadBalancerPage();
		LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
		WebObjectUtil.clickElement(LoadBalancer.getNavPoolsTab());
		WebObjectUtil.explicitWait(3);
		
		wExpander = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "EVDC.POOL.LOADBALANCER.TABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
		WebObjectUtil.clickElement(wExpander);
		
		wEditBtn = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "EVDC.POOL.LOADBALANCER.EXPANDER.EDIT.BUTTON", "PARAMETER_ROWNUMBER", 1+"");
		WebObjectUtil.clickElement(wEditBtn);
		
		WebObjectUtil.explicitWait(4);
		sPoolName = LoadBalancer.getNav_AddPool_PoolName().getAttribute("value");
		WebObjectUtil.SetValueEdit(LoadBalancer.getNav_AddPool_PoolName(), "Selenium_Pool");
		sEditPoolName = LoadBalancer.getNav_AddPool_PoolName().getAttribute("value");
	
	    bStatus = sPoolName.equalsIgnoreCase(sEditPoolName);
		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "We are not able to edit the pool name");
		
		// log out
		LoginTestCase.nav_Logout();
		
	}   catch (Exception e) {
		LoggerUtil.log_type_error("Issue with navEditPoolName test case");
		LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage()+"null");
	   }
	}
	
	
	
	/*==============================================================
	TestScript 		: navVerifyEditPoolErrorMessage
	Manual TestCase	: QAT-1773
	Description		: Verify the error message like with out adding member when editing the pool. 
	Author 			: QAA04
	Release name    : Zathras
	Creation Date 	: 09/16/2016
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=10)
	public void navVerifyEditPoolErrorMessage(){
		int iRow,iRowCount;
		WebElement wExpander,wEditBtn,wDropDownElement;
		String sHealthMonitorvisibleText1,sErrorMsg;
		boolean bStatus;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, LoadBalancer);
		PageFactory.initElements(driver, Common);
		try{
		FrameworkUtil.sTestCaseName="navVerifyEditPoolErrorMessage";
		FrameworkUtil.sManualTestCaseName="LoadBalancer-QAT-1773-Zathras-Verify the error message like with out adding member when editing the pool.";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		// login to the navigator
				LoginTestCase.LoginAsAgentUser();
				
				// navigating to the load balancers page.
				LoadBalancersTestCase.NavigatingToLoadBalancerPage();
				LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
				WebObjectUtil.clickElement(LoadBalancer.getNavPoolsTab());
				WebObjectUtil.explicitWait(3);
				
				CustomWebElementUtil.loadCustomElement(LoadBalancer.getNavPoolsTableParent(), "table");
				iRow = CustomWebElementUtil.iRowCount;
				for(int i=1; i<=iRow; i++){
				wExpander = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "EVDC.POOL.LOADBALANCER.TABLE.EXPANDER", "PARAMETER_ROWNUMBER", i+"");
				WebObjectUtil.clickElement(wExpander);
				
				
				WebObjectUtil.explicitWait(3);
				CustomWebElementUtil.loadCustomElement(LoadBalancer.getNav_Pool_Expand_MemberWebTableParent(), "table");
				iRowCount = CustomWebElementUtil.iRowCount;
				
				if(iRowCount==0){
					wEditBtn = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "EVDC.POOL.LOADBALANCER.EXPANDER.EDIT.BUTTON", "PARAMETER_ROWNUMBER", i+"");
					WebObjectUtil.clickElement(wEditBtn);
					
					sHealthMonitorvisibleText1 = (String) FrameworkUtil.dictPropertyData.get("NAV.LOADBALANCER.ADDPOOL.HEALTHMANITOR.VISIBLE.TEXT");
					
					WebObjectUtil.explicitWait(5);
					WebObjectUtil.clickElement(LoadBalancer.getNav_AddPool_HealthMonitorDropDownArrow());
					wDropDownElement=WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.LOADBALANCER.ADDPOOL.HEALTHMANITOR.DROPDOWN.CHECKBOX", "PARAMETER_DROPDOWNVISIBLETEXT", sHealthMonitorvisibleText1);
					bStatus = WebObjectUtil.isCheckRadioSelected(wDropDownElement);
					if(bStatus==false){
						WebObjectUtil.selectCheckRadioBox(wDropDownElement);
					}
					else{
						WebObjectUtil.deSelectCheckBox(wDropDownElement);
					}
					
					WebObjectUtil.clickElement(LoadBalancer.getNav_AddPool_SubmitBtn());
					WebObjectUtil.explicitWait(10);
					sErrorMsg = Common.getNav_CommonPopUp().getText();
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, " verifying the error msg", "pass", sErrorMsg);
					WebObjectUtil.clickElement(Common.getNav_CommonPopUpOKButton());
					WebObjectUtil.explicitWait(5);
					break;
				}
				}
		
			// log out
				LoginTestCase.nav_Logout();
    }   catch (Exception e) {
	    LoggerUtil.log_type_error("Issue with navVerifyEditPoolErrorMessage test case");
	    LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
	    FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage()+"null");
        }
	 }
	
	
	/*==============================================================
	TestScript 		: navVerifyAdvancedPoolEditFields
	Manual TestCase	: QAT-1771
	Description		: Verify that edit fields will display: Pool name,Health Monitor,Balancing Method,Exising Memeber info &Add Member link,Reset and Submit buttons
	Author 			: QAA04
	Release name    : Zathras
	Creation Date 	: 09/16/2016
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=11)
	public void navVerifyAdvancedPoolEditFields(){
		WebElement wExpander,wEditBtn;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, LoadBalancer);
		PageFactory.initElements(driver, Common);
		try{
		FrameworkUtil.sTestCaseName="navVerifyAdvancedPoolEditFields";
		FrameworkUtil.sManualTestCaseName="Load balancer-QAT-1771-Verify that edit fields will display: Pool name,Health Monitor,Balancing Method,Exising Memeber info &Add Member link,Reset and Submit buttons";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		// login to the navigator
		LoginTestCase.LoginAsAgentUser();
		
		// navigating to the load balancers page.
				LoadBalancersTestCase.NavigatingToLoadBalancerPage();
				LefCourt_SP2TestCase_NMR.waitForFeedbackMsgNotdisplayed();
				WebObjectUtil.clickElement(LoadBalancer.getNavPoolsTab());
				WebObjectUtil.explicitWait(3);
				
				wExpander = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "EVDC.POOL.LOADBALANCER.TABLE.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
				WebObjectUtil.clickElement(wExpander);
				
				wEditBtn = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "EVDC.POOL.LOADBALANCER.EXPANDER.EDIT.BUTTON", "PARAMETER_ROWNUMBER", 1+"");
				WebObjectUtil.clickElement(wEditBtn);
				
		       WebObjectUtil.explicitWait(5);
		       WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_AddPool_PoolName());
		       WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_AddPool_HealthMonitorEditField());
		       WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_AddPool_HealthMonitorDropDownArrow());
		       WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_AddPool_BalancingMethodEditField());
		       WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_AddPool_BalancingMethodDropDownArrow());
	           WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_AddPool_AddMemberLink());
	           WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_AddPool_ResetBtn());
	           WebObjectUtil.verifyElementPresent(LoadBalancer.getNav_AddPool_SubmitBtn());
	           
	           // log out
	           LoginTestCase.nav_Logout();
	        }   catch (Exception e) {
		          LoggerUtil.log_type_error("Issue with navVerifyAdvancedPoolEditFields test case");
		          LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
		          FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage()+"null");
	        }
	
	}
	
	
	
	
	
	/*==============================================================
	 Method Name  	: navAddPool
	 Description	: 
	 Author 		: QAA04
	 Creation Date 	: 08/17/2016
	 Pre-Requisites	:
	 Revision History:
	 ==============================================================*/
	public static boolean navAddPool(String sPoolName, String sHealthMonotorVisibleText, String sBalancingVisibleText){
		String sMessage,sFeedBackMsg;
		boolean bStatus=false;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, LoadBalancer);
		PageFactory.initElements(driver, Common);
		
		try {
			WebObjectUtil.SetValueEdit(LoadBalancer.getNav_AddPool_PoolName(), sPoolName);
			LefCourt_SP2TestCase_NMR.SelectElementFromDropDown(LoadBalancer.getNav_AddPool_HealthMonitorDropDownArrow(), sHealthMonotorVisibleText);
			WebObjectUtil.clickElement(LoadBalancer.getNav_AddPool_PoolName());
			WebObjectUtil.clickElement(LoadBalancer.getNav_AddPool_HealthMonitorEditField());
			WebObjectUtil.explicitWait(2);
			LefCourt_SP2TestCase_NMR.SelectElementFromDropDown(LoadBalancer.getNav_AddPool_BalancingMethodDropDownArrow(), sBalancingVisibleText);
			
			WebObjectUtil.clickElement(LoadBalancer.getNav_AddPool_SubmitBtn());
			WebObjectUtil.explicitWait(5);
			sFeedBackMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.LOADBALANCER.ADDPOOL.SUCESS.MESSAGE");
			sMessage = Common.getNav_UsrFeedBack().getText();
			bStatus = sMessage.equalsIgnoreCase(sFeedBackMsg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navFeedbackClickhere", "warn", "catch block:" +e.getMessage());  
		}
		return bStatus;
	}
	
	
	
	
	
	
	//update each @test result in custom result file
			@AfterMethod
			public static void afterEachMethod(){
				FrameworkUtil.updateTestCaseStatusinResult();
				FrameworkUtil.sTestExecutionStatus = true;
				
			}
}
