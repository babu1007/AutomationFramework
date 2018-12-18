package com.whs.navigator.testcases.Lefcourt;

import java.util.Date;

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
import com.whs.navigator.pagefactory.CommonPageFactory;
import com.whs.navigator.pagefactory.EVDC_FirewallPageFactory;

public class LefCourt_SP2TestCase_NMR {

	public static EVDC_FirewallPageFactory FirewallPF = new EVDC_FirewallPageFactory();
	public static CommonPageFactory Common = new CommonPageFactory();
	/*==============================================================
	TestScript 		: navVerifyIPV6option
	Manual TestCase	: QAT-314
	Description		: Verify that IPV6 option is not available in the IP version option.
	Author 			: QAA04
	Creation Date 	: 02/04/2016
	Release Name    : LefcourtSP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=1)
	public void navVerifyIPV6option(){
		WebElement wFirstRow,wCreateImg;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
        try{
		FrameworkUtil.sTestCaseName="navVerifyIPV6option";
		FrameworkUtil.sManualTestCaseName="(QAT-314)LefCourtSP2 -  Verify that IPV6 option is not available in the IP version option.";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	
		// login to the navigator
		//LoginTestCase.LoginAsDevco();
		LoginTestCase_Old1.LoginAsQaautoUser();
		
		// navigating to the firewall page
		EVDC_FirewallTestCase.NavigateToFirewallPage();
		
		// wait for the feedback message not displayed
		waitForFeedbackMsgNotdisplayed();
		
		WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
		WebObjectUtil.explicitWait(5);
		WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
		WebObjectUtil.clickElement(FirewallPF.getNav_NetworkExpander());
		
		wFirstRow = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.NETWORKOBJECTS.WEBTABLE", "PARAMETER_ROWNUMBER", 1+""); 
		WebObjectUtil.clickElement(wFirstRow);
		// mention comment which identifies element's representation
		wCreateImg = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.CREATEIMAGE", "PARAMETER_ROWNUMBER", 1+""); 
		WebObjectUtil.clickElement(wCreateImg);
		
		//WebObjectUtil.clickElement(FirewallPF.getNav_CreateImageUnderNetworkObjects());
		WebObjectUtil.verifyElementPresent(FirewallPF.getNav_Network_IPVersionTitle());
		WebObjectUtil.verifyElementNOTPresent(FirewallPF.getNav_Network_IPV6Title());
	
		//log out 
		LoginTestCase_Old1.nav_Logout();
	   }catch(Exception e){
		LoggerUtil.log_type_error("Issue with navVerifyIPV6option test case");
		LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Exception occured", "fail", e.getMessage()+"null");
	   }
   }
	
	/*==============================================================
	TestScript 		: navCreateNetworkAndValidateTheFields
	Manual TestCase	: QAT-307,QAT-308,QAT-289,QAT-264,QAT-247
	Description		: verify the create popup box edit fileds.
	Author 			: QAA04
	Creation Date 	: 02/10/2016
	Release Name    : LefcourtSP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=2)
	public void navCreateNetworkAndValidateTheFields(){
		int iRow;
		String sXpath,sName,sNetworkName,sGroupName,sIPAddress;
		WebElement wExpander,wFirstRow,wCreateImg,wTypeDropdown,wName;
		boolean bStatus;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		try{
		FrameworkUtil.sTestCaseName="navCreateNetworkAndValidateTheFields";
		FrameworkUtil.sManualTestCaseName="(QAT-308)(QAT-307)(QAT-289)(QAT-264)(QAT-247) LefCourtSP2 - Verify the create popup box edit fileds.";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		// login to the navigator
		LoginTestCase_Old1.LoginAsQaautoUser();
		
		// navigating to the firewall page
		EVDC_FirewallTestCase.NavigateToFirewallPage();
		
		// wait for the feedback message not displayed 
		waitForFeedbackMsgNotdisplayed();
		
		
		
		// GOM 
		WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
		WebObjectUtil.explicitWait(5);
		WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
		WebObjectUtil.explicitWait(3);
		wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
		WebObjectUtil.clickElement(wExpander);
		WebObjectUtil.explicitWait(3);
		wFirstRow = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.NETWORKOBJECTS.WEBTABLE", "PARAMETER_ROWNUMBER", 1+""); 
		WebObjectUtil.clickElement(wFirstRow);
		
		wCreateImg = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.CREATEIMAGE", "PARAMETER_ROWNUMBER", 1+""); 
		WebObjectUtil.clickElement(wCreateImg);
		
		// select form the drop down
		SelectElementFromDropDown(FirewallPF.getNav_Network_ObjectTypeDropDownArrow(), "Object Group");
		
		 
		 WebObjectUtil.selectCheckRadioBox(FirewallPF.getNav_Network_NewObjectRadioBtn());
		 sNetworkName = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.CREATE.NETWORKNAME01");
		 sNetworkName = "SeleniumTest_" + sNetworkName + FrameworkUtil.sTimeStamp;
		 WebObjectUtil.SetValueEdit(FirewallPF.getNav_Network_NetworkNameEditBox(), sNetworkName);
		
		 
		 //select from the drop down
		 SelectElementFromDropDown(FirewallPF.getNav_Network_TypeDropDownArrow(), "Host");
		 
		
		 WebObjectUtil.selectCheckRadioBox(FirewallPF.getNav_Network_IPV4Radiobtn());
		
		 // verifying the ipaddress
		 VerifyIPAddressErrorMsg("1.2.3.4");
         WebObjectUtil.explicitWait(3);
		 WebObjectUtil.clickElement(FirewallPF.getNav_Network_ForwardArrow());
		 WebObjectUtil.explicitWait(5);
		 
		// sNetworkName = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.CREATE.NETWORKNAME01");
		 verifyExpectedNetworkNameInGroupWebTable(sNetworkName);
		 
		 
		    bStatus = navVerifyTheNewNameEditFieldErrorMsg("a");
			if(bStatus==true){
				 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying the ipaddress", "pass", "Error tooltip is displaying");
			 }else{
				 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying the ipaddress", "fail", "Error tooltip is NOT displaying");
			 }
			
			FirewallPF.getNav_Network_NewNameEditBox().clear();
		 
		 sGroupName = "SeleniumTest_qaacreateobjgrp-2"+FrameworkUtil.sTimeStamp; 
		 WebObjectUtil.SetValueEdit(FirewallPF.getNav_Network_NewNameEditBox(), sGroupName);
		
		 sNetworkName = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.CREATE.NETWORKNAME02");
		 sNetworkName = "SeleniumTest_"+sNetworkName+FrameworkUtil.sTimeStamp;
		 WebObjectUtil.SetValueEdit(FirewallPF.getNav_Network_NetworkNameEditBox(), sNetworkName);
		 // select from the type drop down
		 SelectElementFromDropDown(FirewallPF.getNav_Network_TypeDropDownArrow(), "Network");
		
		 WebObjectUtil.selectCheckRadioBox(FirewallPF.getNav_Network_IPV4Radiobtn());
		
		 // verifying the ipaddress
		 VerifyIPAddressErrorMsg("11.22.33.44");
		 WebObjectUtil.SetValueEdit(FirewallPF.getNav_Network_NetmaskEditBox(), "/32");
		 
		 WebObjectUtil.clickElement(FirewallPF.getNav_Network_ForwardArrow());
		// verifying the expected network in the group web table
		// sNetworkName = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.CREATE.NETWORKNAME02");
		 verifyExpectedNetworkNameInGroupWebTable(sNetworkName);
		
		 sNetworkName = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.CREATE.NETWORKNAME03");
		 sNetworkName = "SeleniumTest_"+sNetworkName+FrameworkUtil.sTimeStamp;
		 WebObjectUtil.SetValueEdit(FirewallPF.getNav_Network_NetworkNameEditBox(), sNetworkName);
		 
		 // select from the type drop down
		 SelectElementFromDropDown(FirewallPF.getNav_Network_TypeDropDownArrow(), "Range");
		 
		 WebObjectUtil.selectCheckRadioBox(FirewallPF.getNav_Network_IPV4Radiobtn());
		 
		 //Need to refer this from properties file - Vivek - 03/29/2016
		   sIPAddress ="2.3.4.5/1.2.3.4";
			FirewallPF.getNav_Network_IPAddressEditBox().clear();
			WebObjectUtil.SetValueEdit(FirewallPF.getNav_Network_IPAddressEditBox(), sIPAddress);
			WebObjectUtil.MouseHover(FirewallPF.getNav_Network_IPAddressEditBox());
			 bStatus = GOMCreateObjectToolTipMsg(FirewallPF.getNav_Network_IPAddressEditBox(), "data-errorqtip", "Start must be less than End");
			//Uses already define method for the below code - Vivek 03/29/2016
			if(bStatus==true){
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying the ipaddress", "pass", "Error popup is displaying for this - "+sIPAddress);
			}else{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying the ipaddress", "fail", "Error popup is NOT displaying for this - "+sIPAddress);
			}
			
			bStatus = FirewallPF.getNav_Network_NetmaskEditBox().isEnabled();
			//Uses already define method for the below code - Vivek 03/29/2016
			if(bStatus==false){
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying the Netmask edit box", "pass", "Netmask edit box is disable");
			}else{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying the Netmask edit box", "fail", "Netmask edit box is enable ");
			}
			
		FirewallPF.getNav_Network_IPAddressEditBox().clear();
		 // verifying the ip address
		VerifyIPAddressErrorMsg("1.2.3.4/2.3.4.5");
		
		
	    WebObjectUtil.explicitWait(3);
		WebObjectUtil.clickElement(FirewallPF.getNav_Network_ForwardArrow());
		WebObjectUtil.explicitWait(5);
		// verifying the expected network in the group web table
		//sNetworkName = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.CREATE.NETWORKNAME03");
		verifyExpectedNetworkNameInGroupWebTable(sNetworkName);
		
		WebObjectUtil.explicitWait(5);
		 // clicking on save btn
		WebObjectUtil.scrollToElement(FirewallPF.getNav_Network_SaveBtn());
		WebObjectUtil.clickElement(FirewallPF.getNav_Network_SaveBtn());
		 WebObjectUtil.explicitWait(5);
		 WebObjectUtil.clickElement(FirewallPF.getNav_Network_ConfirmPopupOkBtn());
		 WebObjectUtil.explicitWait(10);
		 String sFeedbackMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.GROUP.FEEDBACK.MESSAGE");
		 String sMsg = FirewallPF.getNav_Network_FeedbackMsg().getText();
				 
		 boolean bSaveNetwork = sMsg.contains(sFeedbackMsg);
		 FrameworkUtil.updateCustomResultBasedOnStatus(bSaveNetwork, sMsg);
	
	// wait for feedback msg not displayed
		 waitForFeedbackMsgNotdisplayed();
		 
		// GOM 
			WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
			WebObjectUtil.explicitWait(5);
			WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
			WebObjectUtil.explicitWait(3);
			wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
			WebObjectUtil.clickElement(wExpander);
			
		 DeleteOrEditExpectedNetworkUnderNetworkObjectsWebTable(sGroupName, false, false);
		 
		// log out 
		 LoginTestCase_Old1.nav_Logout();
		}catch(Exception e){
			LoggerUtil.log_type_error("Issue with navCreateNetworkAndValidateTheFields test case");
			LoggerUtil.log_type_error("exception occured " +FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	TestScript 		: navCreateNewObject
	Manual TestCase	: QAT-310,QAT-426
	Description		: Verify that a new object created under the parent group Networks
	Author 			: QAA04
	Creation Date 	: 02/16/2016
	Release Name    : LefcourtSP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=3)
	public void navCreateNewObject(){
		WebElement wExpander,wFirstRow,wCreateImg,wTypeDropdown;
		String sXpath,sNetworkName,sFeedbackMsg,sMsg,sIpAdress;
		boolean bSaveNetwork,bStatus;
         WebDriver driver = WebDriverUtil.getDriver();
         PageFactory.initElements(driver, FirewallPF);
         try{
         FrameworkUtil.sTestCaseName="navCreateNewObject";
         FrameworkUtil.sManualTestCaseName="(QAT-310)(QAT-426) LefCourtSP2 - Verify that a new object created under the parent group Networks";
		 FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
         
		// login to the navigator
		 LoginTestCase_Old1.LoginAsQaautoUser();
		 
		 EVDC_FirewallTestCase.NavigateToFirewallPage();
		 
		 // wait for the feedback message not displayed
		 waitForFeedbackMsgNotdisplayed();
		  
		//give brief comment - Vivek 03/29/2016
		 WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
		 WebObjectUtil.explicitWait(5);
		 WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
		 WebObjectUtil.explicitWait(3);
		 wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
		 WebObjectUtil.clickElement(wExpander);
		 WebObjectUtil.explicitWait(3);
		 wFirstRow = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.NETWORKOBJECTS.WEBTABLE", "PARAMETER_ROWNUMBER", 1+""); 
		 WebObjectUtil.clickElement(wFirstRow);
			
		 wCreateImg = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.CREATEIMAGE", "PARAMETER_ROWNUMBER", 1+""); 
		 WebObjectUtil.clickElement(wCreateImg);
		 
	
		 // selecting the object from object type drop down
		SelectElementFromDropDown(FirewallPF.getNav_Network_ObjectTypeDropDownArrow(), "Object");
		
		WebObjectUtil.selectCheckRadioBox(FirewallPF.getNav_Network_NewObjectRadioBtn());
		
		//give brief comment - Vivek 03/29/2016
		sNetworkName = "SeleniumTest"+FrameworkUtil.sTimeStamp;
		WebObjectUtil.SetValueEdit(FirewallPF.getNav_Network_NetworkNameEditBox(), sNetworkName);
		
		WebObjectUtil.clickElement(FirewallPF.getNav_Network_TypeDropDownArrow());
		sXpath = (String) FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
		wTypeDropdown =WebObjectUtil.getActiveElementasWebElement(sXpath);
		//please pass the verification values using properties file-by Priyanka 
		 WebObjectUtil.VerifyTextUnderElement(wTypeDropdown, "Host");
		 WebObjectUtil.VerifyTextUnderElement(wTypeDropdown, "Network");
		 WebObjectUtil.VerifyTextUnderElement(wTypeDropdown, "Range");
		 WebObjectUtil.selectCustomWebList(wTypeDropdown, "Host");
		
		//give brief comment - Vivek 03/29/2016
		WebObjectUtil.selectCheckRadioBox(FirewallPF.getNav_Network_IPV4Radiobtn());
		//should pull the below value from properties file - vivek 03/29/2016
		sIpAdress = "1.2.3.4";
		VerifyIPAddressErrorMsg(sIpAdress);
		FirewallPF.getNav_Network_IPAddressEditBox().clear();
		//should pull the below value from properties file - vivek 03/29/2016
		sIpAdress = "111.22.33.444";
		//VerifyIPAddressErrorMsg(sIpAdress);
		WebObjectUtil.SetValueEdit(FirewallPF.getNav_Network_IPAddressEditBox(), sIpAdress);
		 WebObjectUtil.MouseHover(FirewallPF.getNav_Network_IPAddressEditBox());
		 bStatus = GOMCreateObjectToolTipMsg(FirewallPF.getNav_Network_IPAddressEditBox(), "data-errorqtip", "Invalid IP");
		 //Use already define method @ Framework Level - Vivek 03/29/2016
		 // Using updateCustomResultBasedOnStatus method will reduce number of lines in result verification-by Priyanka
		 if(bStatus){
			 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying the ipaddress", "pass", "Error popup is displaying for this - "+sIpAdress);
		 }else{
			 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying the ipaddress", "fail", "Error popup is NOT displaying for this - "+sIpAdress);
		 }
		FirewallPF.getNav_Network_IPAddressEditBox().clear();
		//give brief comment - Vivek 03/29/2016
		sIpAdress = "11.22.33.44";
		VerifyIPAddressErrorMsg(sIpAdress);
		
		WebObjectUtil.clickElement(FirewallPF.getNav_Network_ForwardArrow());
		WebObjectUtil.explicitWait(5);
		WebObjectUtil.scrollToElement(FirewallPF.getNav_Network_SaveBtn());
		WebObjectUtil.clickElement(FirewallPF.getNav_Network_SaveBtn());
		 WebObjectUtil.explicitWait(10);
		 WebObjectUtil.clickElement(FirewallPF.getNav_Network_ConfirmPopupOkBtn());
		 WebObjectUtil.explicitWait(10);
		 sFeedbackMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.OBJECT.FEEDBACK.MESSAGE");
		 sMsg = FirewallPF.getNav_Network_FeedbackMsg().getText();
				 
		 bSaveNetwork = sMsg.contains(sFeedbackMsg);
		 FrameworkUtil.updateCustomResultBasedOnStatus(bSaveNetwork, sMsg);
		
		 waitForFeedbackMsgNotdisplayed();
		 
		// log out
		 LoginTestCase_Old1.nav_Logout();
	}catch(Exception e){
		LoggerUtil.log_type_error("Issue with navCreateNewObject test case");
		LoggerUtil.log_type_error("exception occured " +FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception occured", "fail", e.getMessage()+"null");
	} 
	}
	
	
	/*==============================================================
	TestScript 		: navDeleteObjectUnderNetworkObjects
	Manual TestCase	: QAT-313,QAT-542,QAT-262
	Description		: Verify that the Object is deleted
	Author 			: QAA04
	Creation Date 	: 02/17/2016
	Release Name    : LefcourtSP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=4)
	public void navDeleteObjectUnderNetworkObjects(){
		int iRowCount;
		WebElement wNetworkName;
		String sFeedbackMsg,sMsg,sDeleteNetwork,sDeleteMsg;
		boolean bStatus;
		WebElement wExpander,wObject,wDelete;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		try{
		FrameworkUtil.sTestCaseName="navDeleteObjectUnderNetworkObjects";
		FrameworkUtil.sManualTestCaseName="(QAT-313)(QAT-542)(QAT-262) LefCourtSP2 - Verify that the Object is deleted sucessfully";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	
	// login to the navigator with entity04a user
		LoginTestCase_Old1.LoginAsQaautoUser();
		
		// navigate to firewall page
		EVDC_FirewallTestCase.NavigateToFirewallPage();
		
		// wait for the feedback message not displayed
		waitForFeedbackMsgNotdisplayed();
		
		//give brief comment - Vivek 03/29/2016
		 WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
		 WebObjectUtil.explicitWait(5);
		 WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
		 WebObjectUtil.explicitWait(3);
		 wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
		 WebObjectUtil.clickElement(wExpander);
		 WebObjectUtil.explicitWait(3);
	
		 // deleting the object from netwrok objects
		sDeleteNetwork = navDeleteObjectUnderNetworkObject();
		 /*wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 2+"");
			WebObjectUtil.clickElement(wExpander);

			WebObjectUtil.explicitWait(5);
			wNetworkName = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.WEBTABLE.NETWORK.NAME", "PARAMETER_ROWNUMBER,PARAMETER_COLUMNNUMBER", 3+","+1);
			sDeleteNetwork = wNetworkName.getText();
			WebObjectUtil.clickElement(wNetworkName);
			
			wDelete = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.DELETEIMAGE", "PARAMETER_ROWNUMBER", 3+"");
			WebObjectUtil.clickElement(wDelete);
			sDeleteMsg = FirewallPF.getNav_Network_ConfirmPopupBox().getText();
        	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying the delete message", "pass", " "+sDeleteMsg);
    	   WebObjectUtil.clickElement(FirewallPF.getNav_Network_ConfirmPopupOkBtn());
			*/
		//give brief comment - Vivek 03/29/2016	
		 WebObjectUtil.explicitWait(10);
		 sFeedbackMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.OBJECT.DELETE.FEEDBACK.MESSAGE");
		 sMsg = FirewallPF.getNav_Network_FeedbackMsg().getText();
				 
		 bStatus = sMsg.contains(sFeedbackMsg);
		 FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, sMsg);
	   
		 // wait statement 
		 waitForFeedbackMsgNotdisplayed();
		 
		// GOM 
		WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
		WebObjectUtil.explicitWait(5);
		WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
		WebObjectUtil.explicitWait(3);
		wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
		WebObjectUtil.clickElement(wExpander);
		
		 verifyExpectedNetworkNOTPresentInNetworkWebTable(sDeleteNetwork);
		 
		 // log out
		 LoginTestCase_Old1.nav_Logout();
		 
		}catch(Exception e){
		LoggerUtil.log_type_error("Issue with navDeleteObjectUnderNetworkObjects test case");
		LoggerUtil.log_type_error("exception occured " +FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception occured", "fail", e.getMessage()+"null");
	   } 
	}
	/*==============================================================
	TestScript 		: navCreateEmptyGroupAndDelete
	Manual TestCase	: QAT-320
	Description		: Verify that the Object is deleted
	Author 			: QAA04
	Creation Date 	: 02/17/2016
	Release Name    : LefcourtSP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=5)
	public void navCreateEmptyGroupAndDelete() {
	  WebElement wNetworkRow,wCreateLink,wExpander;
	  String sGroupName,sFeedBackMsg,sMsg,sFdMsg;
	  boolean bStatus;
	   WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		try{
		FrameworkUtil.sTestCaseName="navCreateEmptyGroupAndDelete";
		FrameworkUtil.sManualTestCaseName="(QAT-320) LefCourtSP2 - Create a empty object group and verify that the Object Group is deleted";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	
		// login to the navigator
		LoginTestCase_Old1.LoginAsQaautoUser();
		
		// navigating to the firewall page
		EVDC_FirewallTestCase.NavigateToFirewallPage();
		
		// wait for the feedback message not displayed
		waitForFeedbackMsgNotdisplayed();
		
		//give brief comment - Vivek 03/29/2016
		//clicking on GOM
		WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
		WebObjectUtil.explicitWait(10);
		
		WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
		WebObjectUtil.explicitWait(3);
		 wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
		 WebObjectUtil.clickElement(wExpander);
		
		wNetworkRow = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.NETWORKOBJECTS.WEBTABLE", "PARAMETER_ROWNUMBER", 1+"");
		WebObjectUtil.clickElement(wNetworkRow);
		
		wCreateLink = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.CREATEIMAGE", "PARAMETER_ROWNUMBER", 1+"");
		WebObjectUtil.clickElement(wCreateLink);
	
		WebObjectUtil.explicitWait(5);
		//Below value should come from properties file - Vivek 03/29/2016
		sGroupName = "SeleniumTest_CreateEmptygrp"+FrameworkUtil.sTimeStamp;
		WebObjectUtil.SetValueEdit(FirewallPF.getNav_Network_NewNameEditBox(), sGroupName);
		WebObjectUtil.explicitWait(3);
		WebObjectUtil.scrollToElement(FirewallPF.getNav_Network_SaveBtn());
		WebObjectUtil.clickElement(FirewallPF.getNav_Network_SaveBtn());
		WebObjectUtil.explicitWait(3);
		WebObjectUtil.clickElement(FirewallPF.getNav_Network_ConfirmPopupOkBtn());
		WebObjectUtil.explicitWait(5);
		sMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.GROUP.FEEDBACK.MESSAGE");
		sFeedBackMsg= FirewallPF.getNav_Network_FeedbackMsg().getText();
	
		bStatus = sFeedBackMsg.contains(sMsg);
		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, sFeedBackMsg);
		
		// wait for 5 minutes 
		waitForFeedbackMsgNotdisplayed();
		
		//give brief comment - Vivek 03/29/2016
		WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
		WebObjectUtil.explicitWait(15);
		WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
		WebObjectUtil.explicitWait(3);
		 wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
		 WebObjectUtil.clickElement(wExpander);
		 
		wNetworkRow = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.NETWORKOBJECTS.WEBTABLE", "PARAMETER_ROWNUMBER", 1+"");
		WebObjectUtil.clickElement(wNetworkRow);
		
		// verifying and delete the network under networkobjects web table
		DeleteOrEditExpectedNetworkUnderNetworkObjectsWebTable(sGroupName, true, false);
		
		sMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.GROUP.DELETE.FEEDBACK.MESSAGE");
		sFeedBackMsg = FirewallPF.getNav_Network_FeedbackMsg().getText();
		
		bStatus = sFeedBackMsg.contains(sMsg);
		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, sFeedBackMsg);
		
		 // wait statement 
		 waitForFeedbackMsgNotdisplayed();
		 
		// GOM 
			WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
			WebObjectUtil.explicitWait(5);
			WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
			WebObjectUtil.explicitWait(3);
			wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
			WebObjectUtil.clickElement(wExpander);
		 //Please comment what does this method do-by priyanka
		 verifyExpectedNetworkNOTPresentInNetworkWebTable(sGroupName);
		 
		// log out
		LoginTestCase_Old1.nav_Logout();
	}catch(Exception e){
		LoggerUtil.log_type_error("Issue with navCreateEmptyGroupAndDelete test case");
		LoggerUtil.log_type_error("exception occured " +FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception occured", "fail", e.getMessage()+"null");
	   } 
	}
	
	
	/*==============================================================
	TestScript 		: navCreateObjectUnderNetworkFolder
	Manual TestCase	: QAT-322,QAT-427
	Description		: Verify that the objects are created under the specified folder
	Author 			: QAA04
	Creation Date 	: 02/27/2016
	Release Name    : LefcourtSP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=6)
	public void navCreateObjectUnderNetworkFolder(){
		WebElement wExpander,wExistingRow;
		String sEditNetworkName,sNetworkName;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		
		try {
			FrameworkUtil.sTestCaseName="navCreateObjectUnderNetworkFolder";
			FrameworkUtil.sManualTestCaseName="(QAT-322)(QAT-427) LefCourtSP2 - Verify that the objects are created under the specified folder";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			
			// login to the navigator
			LoginTestCase_Old1.LoginAsQaautoUser();
			
			// navigating to the firewall page
			EVDC_FirewallTestCase.NavigateToFirewallPage();
			
			// wait for the feedback message not displayed
			waitForFeedbackMsgNotdisplayed();
			
			WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
			
			WebObjectUtil.explicitWait(10);
			WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
			
			WebObjectUtil.explicitWait(3);
			 wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
			 WebObjectUtil.clickElement(wExpander);
			
			// clicking on edit image
			sEditNetworkName =navEditObjectUnderNetworkObject();
			
			WebObjectUtil.clickElement(FirewallPF.getNav_Network_CreateEditPopupBox());
			WebObjectUtil.selectCheckRadioBox(FirewallPF.getNav_Network_FromExistingObjectsRadioBtn());
			
			//WebObjectUtil.clickElement(FirewallPF.getNav_Network_CreateEditPopupBox());
			// selecting the existing object from the existing objects web table
			 wExistingRow = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NTEWORKOBJETS.EXISTINGOBJECTS.WEBTABLE.COLUMN.NAME", "PARAMETER_ROWNUMBER", 1+"");
			WebObjectUtil.clickElement(wExistingRow);
			
			WebObjectUtil.explicitWait(5);
			WebObjectUtil.clickElement(FirewallPF.getNav_Network_ForwardArrow());
			
			WebObjectUtil.explicitWait(5);
			
			// selecting the existing object from the existing objects web table
			 wExistingRow = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NTEWORKOBJETS.EXISTINGOBJECTS.WEBTABLE.COLUMN.NAME", "PARAMETER_ROWNUMBER", 1+"");
			WebObjectUtil.clickElement(wExistingRow);
			
			//give brief comment - Vivek 03/29/2016
			WebObjectUtil.clickElement(FirewallPF.getNav_Network_ForwardArrow());
			WebObjectUtil.explicitWait(5);
			WebObjectUtil.scrollToElement(FirewallPF.getNav_Network_SaveBtn());
			WebObjectUtil.clickElement(FirewallPF.getNav_Network_SaveBtn());
			WebObjectUtil.explicitWait(5);
			WebObjectUtil.clickElement(FirewallPF.getNav_Network_ConfirmPopupOkBtn());
			
			WebObjectUtil.explicitWait(10);
			// wait for the feedback message not displayed
			waitForFeedbackMsgNotdisplayed();
			
			WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
			
			WebObjectUtil.explicitWait(10);
			WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
			
			WebObjectUtil.explicitWait(3);
			wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
			WebObjectUtil.clickElement(wExpander);

   // clicking on expected network 
			DeleteOrEditExpectedNetworkUnderNetworkObjectsWebTable(sEditNetworkName, false, true);
			
			WebObjectUtil.selectCheckRadioBox(FirewallPF.getNav_Network_NewObjectRadioBtn());
			
			sNetworkName = "SeleniumTest"+FrameworkUtil.sTimeStamp;
			WebObjectUtil.SetValueEdit(FirewallPF.getNav_Network_NetworkNameEditBox(), sNetworkName);
			
			// selecting the host from type drop down
			SelectElementFromDropDown(FirewallPF.getNav_Network_TypeDropDownArrow(), "Host");
			
			WebObjectUtil.SetValueEdit(FirewallPF.getNav_Network_IPAddressEditBox(), "1.2.3.4");
			
			WebObjectUtil.clickElement(FirewallPF.getNav_Network_ForwardArrow());
			WebObjectUtil.scrollToElement(FirewallPF.getNav_Network_SaveBtn());
			WebObjectUtil.clickElement(FirewallPF.getNav_Network_SaveBtn());
			WebObjectUtil.explicitWait(5);
			WebObjectUtil.clickElement(FirewallPF.getNav_Network_ConfirmPopupOkBtn());
			
			WebObjectUtil.explicitWait(10);
 // wait for the feedback message not displayed
			waitForFeedbackMsgNotdisplayed();
			
			WebObjectUtil.explicitWait(10);
			WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
			
			WebObjectUtil.explicitWait(10);
			WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
			
			WebObjectUtil.explicitWait(3);
			wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
			WebObjectUtil.clickElement(wExpander);
			
			// verifying the expected network 
			DeleteOrEditExpectedNetworkUnderNetworkObjectsWebTable(sEditNetworkName, false, false);
			
			// log out
			LoginTestCase_Old1.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("Issue with navCreateObjectUnderFolderNetwork test case");
			LoggerUtil.log_type_error("exception occured " +FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception occured", "fail", e.getMessage()+"null");
		}
		
	}
	
	/*==============================================================
	TestScript 		: verifyCreatePopupBoxElements
	Manual TestCase	: QAT-327,QAT-261
	Description		: Verify the create popup box elements
	Author 			: QAA04
	Creation Date 	: 03/21/2016
	Release Name    : LefcourtSP2
	Pre-Requisites	:
	Revision History:
	Pending :(QAT-327) Step 6: is NOT clear, some objects are NOT displaying in the Create window, but those elements are related add firewall window popup box.
	==============================================================*/
	@Test(priority=7)
	public void verifyCreatePopupBoxElements() {
		WebElement wExpander,wNetworkRow,wCreateLink,wTypeDropdown;
		String sXpath,sNetworkName;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		
		try {
			FrameworkUtil.sTestCaseName="verifyCreatePopupBoxElements";
			//Please add QAT-327 also in the below steps - Vivek 03/29/2016
			FrameworkUtil.sManualTestCaseName="(QAT-261)LefCourtSP2 - Verify the create popup box elements";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			//Format the below Code - Vivek 03/29/2016
			// login to the navigator
				//	LoginTestCase.LoginAsQaAuto();
					LoginTestCase_Old1.LoginAsQaautoUser();
					// navigating to the firewall page
					EVDC_FirewallTestCase.NavigateToFirewallPage();
					
					// wait for the feedback message not displayed
					waitForFeedbackMsgNotdisplayed();
					
					//clicking on GOM
					WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
					WebObjectUtil.explicitWait(10);
					
					WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
					WebObjectUtil.explicitWait(3);
					 wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
					 WebObjectUtil.clickElement(wExpander);
					
					wNetworkRow = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.NETWORKOBJECTS.WEBTABLE", "PARAMETER_ROWNUMBER", 1+"");
					WebObjectUtil.clickElement(wNetworkRow);
					
					wCreateLink = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.CREATEIMAGE", "PARAMETER_ROWNUMBER", 1+"");
					WebObjectUtil.clickElement(wCreateLink);
				
					WebObjectUtil.explicitWait(5);
				
   
					WebObjectUtil.clickElement(FirewallPF.getNav_Network_ObjectTypeDropDownArrow());
					sXpath = (String) FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
					wTypeDropdown =WebObjectUtil.getActiveElementasWebElement(sXpath);
					 WebObjectUtil.VerifyTextUnderElement(wTypeDropdown, "Object Group");
					 WebObjectUtil.VerifyTextUnderElement(wTypeDropdown, "Object");
					
					 SelectElementFromDropDown(FirewallPF.getNav_Network_ObjectTypeDropDownArrow(), "Object Group");
					 WebObjectUtil.verifyElementPresent(FirewallPF.getNav_Network_FromExistingObjectsRadioBtn());
			
					 WebObjectUtil.verifyElementPresent(FirewallPF.getNav_Network_ExistingObject_IpAddressColumnTitle());
						WebObjectUtil.verifyElementPresent(FirewallPF.getNav_Network_ExisitingObject_NetmaskColumnTitle());
			getRowCountInEachPage(FirewallPF.getNav_Network_ExistingObjectsWebTableParent(),null);

			  WebObjectUtil.selectCheckRadioBox(FirewallPF.getNav_Network_NewObjectRadioBtn());
			
			sNetworkName = "SeleniumTest"+FrameworkUtil.sTimeStamp;
			WebObjectUtil.SetValueEdit(FirewallPF.getNav_Network_NetworkNameEditBox(), sNetworkName);
			
			WebObjectUtil.clickElement(FirewallPF.getNav_Network_TypeDropDownArrow());
			sXpath = (String) FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
			wTypeDropdown =WebObjectUtil.getActiveElementasWebElement(sXpath);
			 WebObjectUtil.VerifyTextUnderElement(wTypeDropdown, "Host");
			 WebObjectUtil.VerifyTextUnderElement(wTypeDropdown, "Network");
			 WebObjectUtil.VerifyTextUnderElement(wTypeDropdown, "Range");
			 WebObjectUtil.selectCustomWebList(wTypeDropdown, "Network");
			
			// SelectElementFromDropDown(FirewallPF.getNav_Network_TypeDropDownArrow(), "Network");
   WebObjectUtil.verifyElementPresent(FirewallPF.getNav_Network_IPVersionTitle());
			 WebObjectUtil.selectCheckRadioBox(FirewallPF.getNav_Network_IPV4Radiobtn());
			
			VerifyIPAddressErrorMsg("1.2.3.0");
			
			//The below data should come from properties file - Vivek 03/29/2016
			WebObjectUtil.SetValueEdit(FirewallPF.getNav_Network_NetmaskEditBox(), "/24");
			
			WebObjectUtil.verifyElementPresent(FirewallPF.getNav_Network_GroupDiscriptionEditBox());
			WebObjectUtil.verifyElementPresent(FirewallPF.getNav_Network_ForwardArrow());
			WebObjectUtil.clickElement(FirewallPF.getNav_Network_ForwardArrow());
			WebObjectUtil.explicitWait(3);
			verifyExpectedNetworkNameInGroupWebTable(sNetworkName);

			WebObjectUtil.verifyElementPresent(FirewallPF.getNav_Network_BackwardArrow());
			WebObjectUtil.clickElement(FirewallPF.getNav_Network_BackwardArrow());
			
			
			
			// log out
			LoginTestCase_Old1.nav_Logout();
		}  catch (Exception e) {
			LoggerUtil.log_type_error("Issue with verifyCreatePopupBoxElements test case");
			LoggerUtil.log_type_error("exception occured " +FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception occured", "fail", e.getMessage()+"null");
		}
		
	}
	
	/*==============================================================
	TestScript 		: verifyPDFandCSVIcons
	Manual TestCase	: QAT-332,QAT-268
	Description		: Verify the  PDF and CSV reports icons
	Author 			: QAA04
	Creation Date 	: 03/14/2016
	Release Name    : LefcourtSP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=8)
    public void verifyPDFandCSVIcons(){
		int iRowNumber;
		WebElement wDeleteNetwork,wEditNetwork,wExpander;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		
		try {
			FrameworkUtil.sTestCaseName="verifyPDFandCSVIcons";
			FrameworkUtil.sManualTestCaseName="(QAT-332)(QAT-268) LefCourtSP2 - Verify the  PDF and CSV reports icons";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to the navigator
				LoginTestCase_Old1.LoginAsQaautoUser();
					// navigating to the firewall page
					EVDC_FirewallTestCase.NavigateToFirewallPage();
					
					// wait for the feedback message not displayed
					waitForFeedbackMsgNotdisplayed();
					
					//clicking on GOM
					WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
					WebObjectUtil.explicitWait(10);
					
					WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
					WebObjectUtil.explicitWait(3);
					
					WebObjectUtil.explicitWait(3);
					 wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
					 WebObjectUtil.clickElement(wExpander);
					
					 WebObjectUtil.explicitWait(5);
					iRowNumber = DeleteOrEditExpectedNetworkUnderNetworkObjectsWebTable("HS-Management", false, false);
					
					wDeleteNetwork = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.DELETEIMAGE", "PARAMETER_ROWNUMBER", iRowNumber+"");
                    WebObjectUtil.verifyElementNOTPresent(wDeleteNetwork);
					
					wEditNetwork = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.EDITIMAGE", "PARAMETER_ROWNUMBER", iRowNumber+"");
					WebObjectUtil.verifyElementNOTPresent(wEditNetwork);
                    
					WebObjectUtil.clickElement(FirewallPF.getNav_ServiceObjectsExpander());
					WebObjectUtil.explicitWait(3);

					WebObjectUtil.verifyElementPresent(FirewallPF.getNav_GOM_PDFIcon());
					WebObjectUtil.verifyElementPresent(FirewallPF.getNav_GOM_CSVIcon());
			
					// log out
					LoginTestCase_Old1.nav_Logout();
					
		} catch (Exception e) {
			LoggerUtil.log_type_error("Issue with verifyPDFandCSVIcons test case");
			LoggerUtil.log_type_error("exception occured " +FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	TestScript 		: verifyEmptyGroupObjectNOTPresentInExistingWebTable
	Manual TestCase	: QAT-525
	Description		: Verify that From existing is not displaying the group does not have objects in it.
	Author 			: QAA04
	Creation Date 	: 03/15/2016
	Release Name    : LefcourtSP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=9)
	public void verifyEmptyGroupObjectNOTPresentInExistingWebTable(){
		WebElement wExpander,wNetworkRow,wCreateLink;
		String sEmptyGroupName;
		boolean bStatus;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		
		try {
			FrameworkUtil.sTestCaseName="verifyEmptyGroupObjectNOTPresentInExistingWebTable";
			FrameworkUtil.sManualTestCaseName="(QAT-525) LefCourtSP2 - Verify that From existing is not displaying the group does not have objects in it.";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to the navigator
				LoginTestCase_Old1.LoginAsQaautoUser();
					// navigating to the firewall page
					EVDC_FirewallTestCase.NavigateToFirewallPage();
					
					// wait for the feedback message not displayed
					waitForFeedbackMsgNotdisplayed();
					
					//clicking on GOM
					WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
					WebObjectUtil.explicitWait(10);
					
					WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
					WebObjectUtil.explicitWait(3);
					 wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
					 WebObjectUtil.clickElement(wExpander);
					
					wNetworkRow = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.NETWORKOBJECTS.WEBTABLE", "PARAMETER_ROWNUMBER", 1+"");
					WebObjectUtil.clickElement(wNetworkRow);
					
					wCreateLink = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.CREATEIMAGE", "PARAMETER_ROWNUMBER", 1+"");
					WebObjectUtil.clickElement(wCreateLink);
				
					WebObjectUtil.explicitWait(5);
						
				     SelectElementFromDropDown(FirewallPF.getNav_Network_ObjectTypeDropDownArrow(), "Object Group");
					
					WebObjectUtil.selectCheckRadioBox(FirewallPF.getNav_Network_FromExistingObjectsRadioBtn());
					
					sEmptyGroupName = "Network_group_Object_Empty";
					bStatus =getRowCountInEachPage(FirewallPF.getNav_Network_ExistingObjectsWebTableParent(),sEmptyGroupName);
					
					if(bStatus==false){
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying the Expected network", "pass", "Expected network is NOT present in existing web table");
					}else{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying the Expected network", "fail", "Expected network is present in existing web table");
					}
			
					// log out
					LoginTestCase_Old1.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("Issue with verifyEmptyGroupObjectNOTPresentInExistingWebTable test case");
			LoggerUtil.log_type_error("exception occured " +FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	
	/*==============================================================
	TestScript 		: navVerifyToolTipMessageForNetworkObject
	Manual TestCase	: QAT-543
	Description		: verify that when user clicks or hover overs on that object, tool tip message is displayed 'This object is in use by one or more groups so cannot be deleted' is displayed
	Author 			: QAA04
	Creation Date 	: 03/16/2016
	Release Name    : LefcourtSP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=10)
	public void verifyToolTipMessageForNetworkObject(){
		WebElement wExpander,wObjectOne,wObjectTwo,wRow;
		String sObjectOne,sObjectTwo,sToolTipMessage;
		int iRowNumber;
		boolean bStatus;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		
		try {
			FrameworkUtil.sTestCaseName="verifyToolTipMessageForNetworkObject";
			FrameworkUtil.sManualTestCaseName="(QAT-543) LefCourtSP2 - verify that when user clicks or hover overs on that object, tool tip message is displayed 'This object is in use by one or more groups so cannot be deleted' is displayed";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);

			// login to the navigator
			
				LoginTestCase_Old1.LoginAsQaautoUser();
				// navigating to the firewall page
				EVDC_FirewallTestCase.NavigateToFirewallPage();
				
				// wait for the feedback message not displayed
				waitForFeedbackMsgNotdisplayed();
				
				//clicking on GOM
				WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
				WebObjectUtil.explicitWait(10);
				
				WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
				WebObjectUtil.explicitWait(3);
				wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
				WebObjectUtil.clickElement(wExpander);
				
				WebObjectUtil.explicitWait(3);
				wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 3+"");
				WebObjectUtil.clickElement(wExpander);
				
				WebObjectUtil.explicitWait(5);
				wObjectOne = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.WEBTABLE.NETWORK.NAME",  "PARAMETER_ROWNUMBER,PARAMETER_COLUMNNUMBER", 4+","+1);
				//WebObjectUtil.clickElement(wObjectOne);
				sObjectOne = wObjectOne.getText();
				System.out.println(sObjectOne); 
				
				wObjectTwo = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.WEBTABLE.NETWORK.NAME",  "PARAMETER_ROWNUMBER,PARAMETER_COLUMNNUMBER", 5+","+1);
				//WebObjectUtil.clickElement(wObjectTwo);
				sObjectTwo = wObjectTwo.getText();
				System.out.println(sObjectTwo); 
				
				wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 3+"");
				WebObjectUtil.clickElement(wExpander);
				WebObjectUtil.explicitWait(3);
				
				sToolTipMessage = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.WEBTABLE.TOOLTIP.MESSAGE");
				iRowNumber = DeleteOrEditExpectedNetworkUnderNetworkObjectsWebTable(sObjectOne, false, false);
				wRow = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.WEBTABLE.OBJECT", "PARAMETER_ROWNUMBER", iRowNumber+"");
				bStatus = GOMCreateObjectToolTipMsg(wRow, "data-qtip", sToolTipMessage);
				FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, " verifying the tooltip message");
				
				WebObjectUtil.explicitWait(3);
				iRowNumber = DeleteOrEditExpectedNetworkUnderNetworkObjectsWebTable(sObjectTwo, false, false);
				wRow = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.WEBTABLE.OBJECT", "PARAMETER_ROWNUMBER", iRowNumber+"");
				bStatus = GOMCreateObjectToolTipMsg(wRow, "data-qtip", sToolTipMessage);
				FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, " verifying the tooltip message");
				
				// log out
				LoginTestCase_Old1.nav_Logout();
				
		} catch (Exception e) {
			LoggerUtil.log_type_error("Issue with navVerifyToolTipMessageForNetworkObject test case");
			LoggerUtil.log_type_error("exception occured " +FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception occured", "fail", e.getMessage()+"null");
		}		
	}
	
	
	/*==============================================================
	TestScript 		: verifyToolTipMsgForTstentity03Network
	Manual TestCase	: QAT-424
	Description		: verify that when user clicks or hover overs on that object, tool tip message is displayed 'This object is in use by one or more groups so cannot be deleted' is displayed
	Author 			: QAA04
	Creation Date 	: 03/17/2016
	Release Name    : LefcourtSP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=11)
	public void verifyToolTipMsgForTstentity04Network(){
		WebElement wExpander,wNetwork;
		String sToolTipMsg;
		int iRowNumber;
		boolean bStatus;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		
		try {
			FrameworkUtil.sTestCaseName="verifyToolTipMsgForTstentity04Network";
			FrameworkUtil.sManualTestCaseName="(QAT-424) LefCourtSP2 - Verify that the message stating this group contains inline object(s), so cannot be edited or deleted";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to the navigator
			LoginTestCase_Old1.LoginAsEntity04User();
			
			// navigating to the firewall page
			EVDC_FirewallTestCase.NavigateToFirewallPage();
			
			// wait for the feedback message not displayed
			waitForFeedbackMsgNotdisplayed();
			
			//clicking on GOM
			WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
			WebObjectUtil.explicitWait(10);
			
			WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
			WebObjectUtil.explicitWait(3);
			wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
			WebObjectUtil.clickElement(wExpander);
			
			sToolTipMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.WEBTABLE.ENTITY.TOOLTIP.MESSAGE");
			iRowNumber = DeleteOrEditExpectedNetworkUnderNetworkObjectsWebTable("tstentity04-int", false, false);
			wNetwork = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.WEBTABLE.OBJECT", "PARAMETER_ROWNUMBER", iRowNumber+"");
			bStatus = GOMCreateObjectToolTipMsg(wNetwork, "data-qtip", sToolTipMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Verifying the tooltip message");
			
			// log out
			LoginTestCase_Old1.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("Issue with verifyToolTipMsgForTstentity03Network test case");
			LoggerUtil.log_type_error("exception occured " +FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception occured", "fail", e.getMessage()+"null");
		}			
	}
	
	
	/*==============================================================
	TestScript 		: verifyEditObjectElements
	Manual TestCase	: QAT-297
	Description		:  Verify that user is able to save the changes and that the changes are seen for the object edited.
	Author 			: QAA04
	Creation Date 	: 03/18/2016
	Release Name    : LefcourtSP2
	Pre-Requisites	:
	Revision History:
	Pending : we are not able get the text from object type drop down edit box after clicking on edit icon  
	==============================================================*/
	//@Test(priority=12)
	public void navModifyNetworkObject(){
		WebElement wExpander,wObject,wEditIcon,wStartIP,wEndIP,wNetMask;
		String sStartIP,sEndIP,sNetMask,sObjectType,sNetworkName,sEditNetwork,sIPAddress,sNetmask,sEditNewName,sNewName,sFeedBackMsg,sMsg;
		boolean bStatus;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		
		try {
			FrameworkUtil.sTestCaseName="navModifyNetworkObject";
			FrameworkUtil.sManualTestCaseName="(QAT-297) LefCourtSP2 - Verify that user is able to save the changes and that the changes are seen for the object edited.";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);

			// login to the navigator
			LoginTestCase_Old1.LoginAsQaautoUser();
			// navigating to the firewall page
			EVDC_FirewallTestCase.NavigateToFirewallPage();
			
			// wait for the feedback message not displayed
			waitForFeedbackMsgNotdisplayed();
			
			//clicking on GOM
			WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
			WebObjectUtil.explicitWait(10);
			//Please update comments for all the appropriate  lines that follow-by priyanka
			WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
			WebObjectUtil.explicitWait(3);
			wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
			WebObjectUtil.clickElement(wExpander);
			
			WebObjectUtil.explicitWait(3);
			wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 3+"");
			WebObjectUtil.clickElement(wExpander);
			
			WebObjectUtil.explicitWait(5);
			wObject = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.WEBTABLE.NETWORK.NAME",  "PARAMETER_ROWNUMBER,PARAMETER_COLUMNNUMBER", 4+","+1);
			WebObjectUtil.clickElement(wObject);
			
			wStartIP = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.WEBTABLE.NETWORK.NAME",  "PARAMETER_ROWNUMBER,PARAMETER_COLUMNNUMBER", 4+","+2);
			sStartIP = wStartIP.getText();
			
			wEndIP = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.WEBTABLE.NETWORK.NAME",  "PARAMETER_ROWNUMBER,PARAMETER_COLUMNNUMBER", 4+","+3);
			sEndIP = wEndIP.getText();
			
			wNetMask = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.WEBTABLE.NETWORK.NAME",  "PARAMETER_ROWNUMBER,PARAMETER_COLUMNNUMBER", 4+","+4);
			sNetMask = wNetMask.getText();
			
			
			wEditIcon = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.EDITIMAGE", "PARAMETER_ROWNUMBER", 4+"");
			WebObjectUtil.clickElement(wEditIcon);
			
			WebObjectUtil.explicitWait(5);
			
			sObjectType = FirewallPF.getNav_Network_ObjectTypeDropDownTextBox().getText();
			bStatus = sObjectType.equalsIgnoreCase("Object");
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Verify that Object Type drop down is auto populated with Object");
			
			WebObjectUtil.verifyElementPresent(FirewallPF.getNav_Network_EditObjectRadioBtn());
			
			
			sEditNetwork = "SeleniumTest_EditNetwork";
			WebObjectUtil.SetValueEdit(FirewallPF.getNav_Network_NetworkNameEditBox(), sEditNetwork);
			sNetworkName = FirewallPF.getNav_Network_NetworkNameEditBox().getText();

			bStatus = sNetworkName.equalsIgnoreCase(sEditNetwork);
			if(bStatus==false){
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying the network name field", "pass", " Network name field is un-editable and auto filled with "+sNetworkName);
				}
			
			sIPAddress = FirewallPF.getNav_Network_IPAddressEditBox().getText();
			bStatus = sIPAddress.equalsIgnoreCase(sStartIP);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Verify that ip address edit box is auto populated with "+sIPAddress);
			
			
      sNetmask = FirewallPF.getNav_Network_NetmaskEditBox().getText();
      bStatus = sNetmask.equalsIgnoreCase(sNetMask);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Verify that netmask edit box is auto populated with "+sNetmask);
			
			sEditNewName = "SeleniumTest_EditNewName";
			WebObjectUtil.SetValueEdit(FirewallPF.getNav_Network_NewNameEditBox(), sEditNewName);
			sNewName = FirewallPF.getNav_Network_NewNameEditBox().getText();

			bStatus = sNewName.equalsIgnoreCase(sEditNewName);
			if(bStatus==false){
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying the new name field", "pass", " New name field is un-editable and auto filled with "+sNewName);
				}
			
			WebObjectUtil.selectCheckRadioBox(FirewallPF.getNav_Network_EditObjectRadioBtn());
			SelectElementFromDropDown(FirewallPF.getNav_Network_TypeDropDownArrow(), "Range");
			
			WebObjectUtil.explicitWait(3);
			FirewallPF.getNav_Network_IPAddressEditBox().clear();
			WebObjectUtil.SetValueEdit(FirewallPF.getNav_Network_IPAddressEditBox(), "1.2.3.4/2.3.4.5");
			
			WebObjectUtil.explicitWait(3);
			WebObjectUtil.clickElement(FirewallPF.getNav_Network_ForwardArrow());
			WebObjectUtil.explicitWait(5);
			WebObjectUtil.scrollToElement(FirewallPF.getNav_Network_SaveBtn());
			WebObjectUtil.clickElement(FirewallPF.getNav_Network_SaveBtn());
			WebObjectUtil.explicitWait(5);
			WebObjectUtil.clickElement(FirewallPF.getNav_Network_ConfirmPopupOkBtn());
			WebObjectUtil.explicitWait(6);
			sMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.OBJECT.EDIT.FEEDBACK.MESSAGE");
			sFeedBackMsg = FirewallPF.getNav_Network_FeedbackMsg().getText();
			
			bStatus = sFeedBackMsg.contains(sMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, sFeedBackMsg);
			
			waitForFeedbackMsgNotdisplayed();
			
			// log out
			LoginTestCase_Old1.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("Issue with navModifyNetworkObject test case");
			LoggerUtil.log_type_error("exception occured " +FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception occured", "fail", e.getMessage()+"null");
		}			
	}
	
	/*==============================================================
	TestScript 		: verifyNetworkObjectsElements
	Manual TestCase	: QAT-277
	Description		: Verify that user is able to see Delete/Edit icons to perform the actions.
	Author 			: QAA04
	Creation Date 	: 03/21/2016
	Release Name    : LefcourtSP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=13)
	public void verifyNetworkObjectsElements(){
		WebElement wExpander,wNetworkRow,wCreateLink,wEditLink,wDeleteLink;
		boolean bStatus;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		
		try {
			FrameworkUtil.sTestCaseName="verifyNetworkObjectsElements";
			FrameworkUtil.sManualTestCaseName="(QAT-277) LefCourtSP2 - Verify that user is able to see Delete/Edit icons to perform the actions.";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);

			// login to the naviagtor
			LoginTestCase_Old1.LoginAsQaautoUser();
			
			EVDC_FirewallTestCase.NavigateToFirewallPage();
			
			// wait for the feedback message not displayed
			waitForFeedbackMsgNotdisplayed();
			
			WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
			WebObjectUtil.explicitWait(5);
			WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
			WebObjectUtil.explicitWait(3);
			
			wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
			WebObjectUtil.clickElement(wExpander);

			WebObjectUtil.verifyElementPresent(FirewallPF.getNav_Network_SearchEditBox());
			WebObjectUtil.verifyElementPresent(FirewallPF.getNav_Network_CloseBtn());
			
			WebObjectUtil.verifyElementPresent(FirewallPF.getNav_Network_StartIpAddressColumnName());
			WebObjectUtil.verifyElementPresent(FirewallPF.getNav_Network_EndIpAddressColumnName());
			WebObjectUtil.verifyElementPresent(FirewallPF.getNav_Network_NetmaskColumnName());
			WebObjectUtil.verifyElementPresent(FirewallPF.getNav_Network_ObjectNatColumnName());
			WebObjectUtil.verifyElementPresent(FirewallPF.getNav_Network_DescriptionColumnName());
			
			
			wNetworkRow = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.NETWORKOBJECTS.WEBTABLE", "PARAMETER_ROWNUMBER", 1+"");
			WebObjectUtil.clickElement(wNetworkRow);
			
			wCreateLink = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.CREATEIMAGE", "PARAMETER_ROWNUMBER", 1+"");
			WebObjectUtil.verifyElementPresent(wCreateLink);
			WebObjectUtil.clickElement(wCreateLink);

			WebObjectUtil.explicitWait(3);
			
			WebObjectUtil.clickElement(FirewallPF.getNav_Network_CancelBtn());
			WebObjectUtil.explicitWait(3);
			
			wNetworkRow = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.NETWORKOBJECTS.WEBTABLE", "PARAMETER_ROWNUMBER", 3+"");
			WebObjectUtil.clickElement(wNetworkRow);
			
			wEditLink = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.EDITIMAGE", "PARAMETER_ROWNUMBER", 3+"");
			WebObjectUtil.verifyElementPresent(wEditLink);
			
			/*wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 3+"");
			WebObjectUtil.clickElement(wExpander);
			
			wNetworkRow = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.NETWORKOBJECTS.WEBTABLE", "PARAMETER_ROWNUMBER", 4+"");
			WebObjectUtil.clickElement(wNetworkRow);*/
			
			wDeleteLink = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.DELETEIMAGE", "PARAMETER_ROWNUMBER", 3+"");
			WebObjectUtil.verifyElementPresent(wDeleteLink);
			
			WebObjectUtil.clickElement(wDeleteLink);
			WebObjectUtil.explicitWait(3);
			bStatus = WebObjectUtil.isElementPresent(FirewallPF.getNav_Network_deletePopupBox());
		//	bStatus = wDeleteLink.isEnabled();
			if(bStatus==false){
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verifying the delete icon", "pass", "Delete icon is in disable mode");
				}else{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verifying the delete icon", "fail", "Delete icon is in active mode");
					WebObjectUtil.clickElement(FirewallPF.getNav_Network_CancelBtn());
					WebObjectUtil.explicitWait(3);
				}

			wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 3+"");
			WebObjectUtil.clickElement(wExpander);
			WebObjectUtil.explicitWait(5);
			
			wNetworkRow = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.NETWORKOBJECTS.WEBTABLE", "PARAMETER_ROWNUMBER", 4+"");
			WebObjectUtil.clickElement(wNetworkRow);
			
			wEditLink = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.EDITIMAGE", "PARAMETER_ROWNUMBER", 4+"");
			WebObjectUtil.verifyElementPresent(wEditLink);
			
			wDeleteLink = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.DELETEIMAGE", "PARAMETER_ROWNUMBER", 4+"");
			WebObjectUtil.verifyElementPresent(wDeleteLink);
			
			
			// log out
			LoginTestCase_Old1.nav_Logout();
		}catch (Exception e) {
			LoggerUtil.log_type_error("Issue with verifyNetworkObjectsElements test case");
			LoggerUtil.log_type_error("exception occured " +FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception occured", "fail", e.getMessage()+"null");
		}			
	}
	
	/*==============================================================
	TestScript 		: CreateNetwotkObjectForEntity02User
	Manual TestCase	: QAT-250
	Description		: Verify that user is able to create a new group 
	Author 			: QAA04
	Creation Date 	: 03/22/2016
	Release Name    : LefcourtSP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=14)
	public void CreateNetwotkObjectForEntity02User(){
		String sFeedBackMsg,sMsg;
		boolean bStatus;
		WebElement wExpander,wNetworkRow,wCreateLink;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		try{
		FrameworkUtil.sTestCaseName="CreateNetwotkObjectForEntity02User";
		FrameworkUtil.sManualTestCaseName="(QAT-250) LefCourtSP2 - Verify that user is able to create a new group";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		// login to the navigator
		LoginTestCase_Old1.LoginAsEntity02User();
	
		// navigating to the firewall page
		EVDC_FirewallTestCase.NavigateToFirewallPage();
		
		// wait for the feedback message not displayed
		waitForFeedbackMsgNotdisplayed();
		
		//clicking on GOM
		WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
		WebObjectUtil.explicitWait(10);
		
		WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
		WebObjectUtil.explicitWait(3);
		 wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
		 WebObjectUtil.clickElement(wExpander);
		
		wNetworkRow = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.NETWORKOBJECTS.WEBTABLE", "PARAMETER_ROWNUMBER", 1+"");
		WebObjectUtil.clickElement(wNetworkRow);
		
		wCreateLink = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.CREATEIMAGE", "PARAMETER_ROWNUMBER", 1+"");
		WebObjectUtil.clickElement(wCreateLink);
	
		WebObjectUtil.explicitWait(5);
		SelectElementFromDropDown(FirewallPF.getNav_Network_ObjectTypeDropDownArrow(), "Object Group");
		
		WebObjectUtil.selectCheckRadioBox(FirewallPF.getNav_Network_FromExistingObjectsRadioBtn());
		
		getRowCountInEachPage(FirewallPF.getNav_Network_ExistingObjectsWebTableParent(), "test111");
		WebObjectUtil.clickElement(FirewallPF.getNav_Network_ForwardArrow());
		WebObjectUtil.explicitWait(5);
		verifyExpectedNetworkNameInGroupWebTable("test111");
		
		getRowCountInEachPage(FirewallPF.getNav_Network_ExistingObjectsWebTableParent(), "sub88");
		WebObjectUtil.clickElement(FirewallPF.getNav_Network_ForwardArrow());
		WebObjectUtil.explicitWait(5);
		verifyExpectedNetworkNameInGroupWebTable("sub88");
		
		WebObjectUtil.SetValueEdit(FirewallPF.getNav_Network_NewNameEditBox(), "QAAcreateobjgrp-1");
		WebObjectUtil.scrollToElement(FirewallPF.getNav_Network_SaveBtn());
		WebObjectUtil.clickElement(FirewallPF.getNav_Network_SaveBtn());
	    WebObjectUtil.explicitWait(5);
		WebObjectUtil.clickElement(FirewallPF.getNav_Network_ConfirmPopupOkBtn());
		WebObjectUtil.explicitWait(10);
			
		sMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.GROUP.FEEDBACK.MESSAGE");
		sFeedBackMsg= FirewallPF.getNav_Network_FeedbackMsg().getText();
	
		bStatus = sFeedBackMsg.contains(sMsg);
		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, sFeedBackMsg);
		
		// wait for 5 minutes 
		waitForFeedbackMsgNotdisplayed();
	
				
	  // log out
		LoginTestCase_Old1.nav_Logout();
		}catch (Exception e) {
			LoggerUtil.log_type_error("Issue with CreateNetwotkObjectForEntity02User test case");
			LoggerUtil.log_type_error("exception occured " +FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception occured", "fail", e.getMessage()+"null");
		}	
	}
	
	/*==============================================================
	TestScript 		: CreateEmptyGroupForEntity04
	Manual TestCase	: QAT-242
	Description		: Verify that empty group is created after 5 mins, refreshing the page
	Author 			: QAA04
	Creation Date 	: 03/22/2016
	Release Name    : LefcourtSP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=15)
	public void CreateEmptyGroupForEntity04() {
		  WebElement wNetworkRow,wCreateLink,wExpander;
		  String sGroupName,sFeedBackMsg,sMsg;
		  boolean bStatus;
		   WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, FirewallPF);
			try{
			FrameworkUtil.sTestCaseName="CreateEmptyGroupForEntity04";
			FrameworkUtil.sManualTestCaseName="(QAT-242) LefCourtSP2 - Verify that empty group is created after 5 mins, refreshing the page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
			// login to the navigator
			LoginTestCase_Old1.LoginAsEntity04User();
			
			// navigating to the firewall page
			EVDC_FirewallTestCase.NavigateToFirewallPage();
			
			// wait for the feedback message not displayed
			waitForFeedbackMsgNotdisplayed();
			
			// wait for the feedback message NOT displayed. 
			waitForFeedbackMsgNotdisplayed();
			
			//clicking on GOM
			WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
			WebObjectUtil.explicitWait(10);
			
			WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
			WebObjectUtil.explicitWait(3);
			 wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
			 WebObjectUtil.clickElement(wExpander);
			
			wNetworkRow = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.NETWORKOBJECTS.WEBTABLE", "PARAMETER_ROWNUMBER", 1+"");
			WebObjectUtil.clickElement(wNetworkRow);
			
			wCreateLink = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.CREATEIMAGE", "PARAMETER_ROWNUMBER", 1+"");
			WebObjectUtil.clickElement(wCreateLink);
		
			WebObjectUtil.explicitWait(5);
			
			sGroupName = "SeleniumTest_CreateEmptygrp"+FrameworkUtil.sTimeStamp;
			WebObjectUtil.SetValueEdit(FirewallPF.getNav_Network_NewNameEditBox(), sGroupName);
			WebObjectUtil.scrollToElement(FirewallPF.getNav_Network_SaveBtn());
			WebObjectUtil.clickElement(FirewallPF.getNav_Network_SaveBtn());
			WebObjectUtil.explicitWait(3);
			WebObjectUtil.clickElement(FirewallPF.getNav_Network_ConfirmPopupOkBtn());
			WebObjectUtil.explicitWait(5);
			sMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.GROUP.FEEDBACK.MESSAGE");
			sFeedBackMsg= FirewallPF.getNav_Network_FeedbackMsg().getText();
		
			bStatus = sFeedBackMsg.contains(sMsg);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, sFeedBackMsg);
			
			// wait for 5 minutes 
			waitForFeedbackMsgNotdisplayed();
				
			//clicking on GOM
			WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
			WebObjectUtil.explicitWait(10);
			
			WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
			WebObjectUtil.explicitWait(3);
			wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
			WebObjectUtil.clickElement(wExpander);
			WebObjectUtil.explicitWait(5);
			DeleteOrEditExpectedNetworkUnderNetworkObjectsWebTable(sGroupName, false, false);
			
			// log out
			LoginTestCase_Old1.nav_Logout();
			}catch (Exception e) {
				LoggerUtil.log_type_error("Issue with navCreateEmptyGroupForEntity04 test case");
				LoggerUtil.log_type_error("exception occured " +FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception occured", "fail", e.getMessage()+"null");
			}	
			}		
	
	/*==============================================================
	TestScript 		: editNetworkUnderNetworkObjects
	Manual TestCase	: QAT-244
	Description		: Verify that user is able to edit the group and no error or exception message is thrown
	Author 			: QAA04
	Creation Date 	: 03/23/2016
	Release Name    : LefcourtSP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/	
	@Test(priority=16)
	public void editNetworkUnderNetworkObjects(){
		int iRow;
		WebElement wExpander,wNetwork,wEditIcon,wExistingRow,wNetworkName;
		String sObjectType,sExistingRow,sNetworkName,sGroupName,sFeedBackMsg,sMsg,sExistingNetworkName,sNetwork;
		boolean bStatus;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		
		try {
			FrameworkUtil.sTestCaseName="editNetworkUnderNetworkObjects";
			FrameworkUtil.sManualTestCaseName="(QAT-244) LefCourtSP2 - Verify that user is able to edit the group and no error or exception message is thrown";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to the navigator
			LoginTestCase_Old1.LoginAsQaautoUser();
			
			// navigating to the firewall page
			EVDC_FirewallTestCase.NavigateToFirewallPage();
			
			// wait for the feedback message not displayed
				waitForFeedbackMsgNotdisplayed();
				
				WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
				
				WebObjectUtil.explicitWait(10);
				WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
				
				WebObjectUtil.explicitWait(3);
				wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
				WebObjectUtil.clickElement(wExpander);

				WebObjectUtil.explicitWait(5);
				wNetworkName = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.WEBTABLE.NETWORK.NAME", "PARAMETER_ROWNUMBER,PARAMETER_COLUMNNUMBER", 3+","+1);
				sNetworkName = wNetworkName.getText();
				WebObjectUtil.clickElement(wNetworkName);
				
				wNetwork =WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.WEBTABLE.OBJECT", "PARAMETER_ROWNUMBER", 3+"");
			    WebObjectUtil.clickElement(wNetwork);

			    wEditIcon =WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.EDITIMAGE", "PARAMETER_ROWNUMBER", 3+"");
			    WebObjectUtil.clickElement(wEditIcon);

			   sObjectType = FirewallPF.getNav_Network_ObjectTypeDropDownTextBox().getAttribute("value");
			   bStatus = sObjectType.equalsIgnoreCase("Object Group");
			  FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Verify that Object Type drop down is auto populated with Object Group");
			   
			  sGroupName = FirewallPF.getNav_Network_NewNameEditBox().getAttribute("value");
			  bStatus = sGroupName.equalsIgnoreCase(sNetworkName);
			  //please pass the verification text from properties file-by priyanka
			  FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the expected network name");
			 
			  WebObjectUtil.MouseHover(FirewallPF.getNav_Network_NewNameEditBox());
			//please pass the verification text from properties file-by priyanka
			  GOMCreateObjectToolTipMsg(FirewallPF.getNav_Network_NewNameEditBox(), "data-qtip", "Name cannot be edited, if you'd like to change the name, delete the entity first and then add a new one");
			   

			  WebObjectUtil.selectCheckRadioBox(FirewallPF.getNav_Network_NewObjectRadioBtn());
				WebObjectUtil.selectCheckRadioBox(FirewallPF.getNav_Network_FromExistingObjectsRadioBtn());
				
				 wExistingRow = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NTEWORKOBJETS.EXISTINGOBJECTS.WEBTABLE.COLUMN.NAME", "PARAMETER_ROWNUMBER", 1+"");
				 sExistingRow = wExistingRow.getText();
				 WebObjectUtil.clickElement(wExistingRow);
					
				WebObjectUtil.explicitWait(5);
				WebObjectUtil.clickElement(FirewallPF.getNav_Network_ForwardArrow());
				WebObjectUtil.explicitWait(5);
				verifyExpectedNetworkNameInGroupWebTable(sExistingRow);
				WebObjectUtil.scrollToElement(FirewallPF.getNav_Network_SaveBtn());
				WebObjectUtil.clickElement(FirewallPF.getNav_Network_SaveBtn());
				WebObjectUtil.explicitWait(5);
				WebObjectUtil.clickElement(FirewallPF.getNav_Network_ConfirmPopupOkBtn());
			    WebObjectUtil.explicitWait(10);
				sMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.GROUP.EDIT.FEEDBACK.MESSAGE");
				sFeedBackMsg= FirewallPF.getNav_Network_FeedbackMsg().getText();
				bStatus = sFeedBackMsg.contains(sMsg);
				FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, sFeedBackMsg);
				
				// wait for 5 minutes 
				waitForFeedbackMsgNotdisplayed();
			
			    WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
				
				WebObjectUtil.explicitWait(10);
				WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
				
				WebObjectUtil.explicitWait(3);
				wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
				WebObjectUtil.clickElement(wExpander);
				
				// verifying the expected network in the network objects web table
			iRow = DeleteOrEditExpectedNetworkUnderNetworkObjectsWebTable(sNetworkName, false, false);
			
			wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", iRow+"");
			WebObjectUtil.clickElement(wExpander);
			// verifying the expected object in the network objects web table
			DeleteOrEditExpectedNetworkUnderNetworkObjectsWebTable(sExistingRow, false, false);
			
			wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", iRow+"");
			WebObjectUtil.clickElement(wExpander);
			
			wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 3+"");
				WebObjectUtil.clickElement(wExpander);
				
				wNetworkName = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.WEBTABLE.NETWORK.NAME", "PARAMETER_ROWNUMBER,PARAMETER_COLUMNNUMBER", 4+","+1);
				sExistingNetworkName = wNetworkName.getText();
				
  // we are clicking on same edit icon   
				wNetworkName = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.WEBTABLE.NETWORK.NAME", "PARAMETER_ROWNUMBER,PARAMETER_COLUMNNUMBER", 3+","+1);
				sNetworkName = wNetworkName.getText();
				WebObjectUtil.clickElement(wNetworkName);
				
				wNetwork =WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.WEBTABLE.OBJECT", "PARAMETER_ROWNUMBER", 3+"");
			    WebObjectUtil.clickElement(wNetwork);

			    wEditIcon =WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.EDITIMAGE", "PARAMETER_ROWNUMBER", 3+"");
			    WebObjectUtil.clickElement(wEditIcon);
			    WebObjectUtil.explicitWait(3);
			      			    
			    WebObjectUtil.selectCheckRadioBox(FirewallPF.getNav_Network_NewObjectRadioBtn());
			   /* WebObjectUtil.SetValueEdit(FirewallPF.getNav_Network_NetworkNameEditBox(), sExistingNetworkName);
			    WebObjectUtil.MouseHover(FirewallPF.getNav_Network_NetworkNameEditBox());*/
	 // we need validate the network name edit field is displays an error message for an existing name   
			    
			    // verifing the netmask edit field is enabled or not
			    bStatus  = verifyNetMaskEditFieldIsEnabled("Host");
			    FrameworkUtil.updateCustomResultBasedOnStatus(!bStatus, "Netmask edit field is disabled for Host");
			    
			    bStatus  = verifyNetMaskEditFieldIsEnabled("Network");
			    FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Netmask edit field is enabled for Nework");
			    
			    
			    bStatus  = verifyNetMaskEditFieldIsEnabled("Range");
			    FrameworkUtil.updateCustomResultBasedOnStatus(!bStatus, "Netmask edit field is disabled for Range");
			    
			    sNetwork = "SeleniumTest_"+FrameworkUtil.sTimeStamp;
			    WebObjectUtil.SetValueEdit(FirewallPF.getNav_Network_NetworkNameEditBox(), sNetwork);
			    
			    SelectElementFromDropDown(FirewallPF.getNav_Network_TypeDropDownArrow(), "Host");
			    WebObjectUtil.SetValueEdit(FirewallPF.getNav_Network_IPAddressEditBox(), "1.2.3.4");
			    
			    WebObjectUtil.clickElement(FirewallPF.getNav_Network_ForwardArrow());
			    WebObjectUtil.explicitWait(3);
			    WebObjectUtil.scrollToElement(FirewallPF.getNav_Network_SaveBtn());
			    WebObjectUtil.clickElement(FirewallPF.getNav_Network_SaveBtn());
			    WebObjectUtil.explicitWait(5);
			    WebObjectUtil.clickElement(FirewallPF.getNav_Network_ConfirmPopupOkBtn());
			    WebObjectUtil.explicitWait(10);
			    
			    sMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.GROUP.EDIT.FEEDBACK.MESSAGE");
				sFeedBackMsg= FirewallPF.getNav_Network_FeedbackMsg().getText();
			
				bStatus = sFeedBackMsg.contains(sMsg);
				FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, sFeedBackMsg);
				
				// wait for 5 minutes 
				waitForFeedbackMsgNotdisplayed();
				
				 WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
					
				WebObjectUtil.explicitWait(10);
				WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
					
				WebObjectUtil.explicitWait(3);
				wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
				WebObjectUtil.clickElement(wExpander);
					
					// verifying the expected network in the network objects web table
				iRow = DeleteOrEditExpectedNetworkUnderNetworkObjectsWebTable(sNetworkName, false, false);
				
				wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", iRow+"");
				WebObjectUtil.clickElement(wExpander);
				// verifying the expected object in the network objects web table
				DeleteOrEditExpectedNetworkUnderNetworkObjectsWebTable(sNetwork, false, false);
				
				
				// log out
				LoginTestCase_Old1.nav_Logout();
		}catch (Exception e) {
			LoggerUtil.log_type_error("Issue with editNetworkUnderNetworkObjects test case");
			LoggerUtil.log_type_error("exception occured " +FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception occured", "fail", e.getMessage()+"null");
		}	
	        
	}
	
	/*==============================================================
	TestScript 		: createNewObjectGroupAndVerify
	Manual TestCase	: QAT-920
	Description		: 
	Author 			: QAA04
	Creation Date 	: 03/30/2016
	Release Name    : LefcourtSP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=16)
	public void createNewObjectGroupAndVerify(){
		WebElement wExpander,wFirstRow,wCreateImg;
		String sNetworkName,sGroupName;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		
		try {
			FrameworkUtil.sTestCaseName="createNewObjectGroupAndVerify";
			FrameworkUtil.sManualTestCaseName="(QAT-920) LefCourtSP2 - Verify that a new object group";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to the navigator
			LoginTestCase_Old1.LoginAsQaautoAUser();
			
			// navigating to the firewall page
					EVDC_FirewallTestCase.NavigateToFirewallPage();
					
					// wait for the feedback message not displayed 
					waitForFeedbackMsgNotdisplayed();
				
					// GOM 
					WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
					WebObjectUtil.explicitWait(5);
					WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
					WebObjectUtil.explicitWait(3);
					wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
					WebObjectUtil.clickElement(wExpander);
					WebObjectUtil.explicitWait(3);
					wFirstRow = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.NETWORKOBJECTS.WEBTABLE", "PARAMETER_ROWNUMBER", 1+""); 
					WebObjectUtil.clickElement(wFirstRow);
					
					wCreateImg = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.CREATEIMAGE", "PARAMETER_ROWNUMBER", 1+""); 
					WebObjectUtil.clickElement(wCreateImg);
					
					// select form the drop down
					SelectElementFromDropDown(FirewallPF.getNav_Network_ObjectTypeDropDownArrow(), "Object Group");
					
					 
					 WebObjectUtil.selectCheckRadioBox(FirewallPF.getNav_Network_NewObjectRadioBtn());
					
					 sNetworkName = "SeleniumTest_FWnetwork4" + FrameworkUtil.sTimeStamp;
					 WebObjectUtil.SetValueEdit(FirewallPF.getNav_Network_NetworkNameEditBox(), sNetworkName);
					
					 
					 //select from the drop down
					 SelectElementFromDropDown(FirewallPF.getNav_Network_TypeDropDownArrow(), "Host");
					 
					
					 WebObjectUtil.selectCheckRadioBox(FirewallPF.getNav_Network_IPV4Radiobtn());
					
					 // verifying the ipaddress
					 VerifyIPAddressErrorMsg("11.22.34.43");
			         WebObjectUtil.explicitWait(3);
					 WebObjectUtil.clickElement(FirewallPF.getNav_Network_ForwardArrow());
					 WebObjectUtil.explicitWait(5);
					 
					// sNetworkName = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.CREATE.NETWORKNAME01");
					 verifyExpectedNetworkNameInGroupWebTable(sNetworkName);
					 
					 sGroupName = "SeleniumTest_FWGrpObjectnetwork4"+FrameworkUtil.sTimeStamp; 
					 WebObjectUtil.SetValueEdit(FirewallPF.getNav_Network_NewNameEditBox(), sGroupName);
					
					WebObjectUtil.explicitWait(5);
					 // clicking on save btn
					
					WebObjectUtil.scrollToElement(FirewallPF.getNav_Network_SaveBtn());
					 WebObjectUtil.clickElement(FirewallPF.getNav_Network_SaveBtn());
					 WebObjectUtil.explicitWait(5);
					 WebObjectUtil.clickElement(FirewallPF.getNav_Network_ConfirmPopupOkBtn());
					 WebObjectUtil.explicitWait(10);
					 String sFeedbackMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.GROUP.FEEDBACK.MESSAGE");
					 String sMsg = FirewallPF.getNav_Network_FeedbackMsg().getText();
							 
					 boolean bSaveNetwork = sMsg.contains(sFeedbackMsg);
					 FrameworkUtil.updateCustomResultBasedOnStatus(bSaveNetwork, sMsg);
				
				// wait for feedback msg not displayed
					 waitForFeedbackMsgNotdisplayed();
					 
					// GOM 
						WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
						WebObjectUtil.explicitWait(5);
						WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
						WebObjectUtil.explicitWait(3);
						wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
						WebObjectUtil.clickElement(wExpander);
						// verifying the object group name in the network objects web table
					 DeleteOrEditExpectedNetworkUnderNetworkObjectsWebTable(sGroupName, false, false);
					
					 // verifying the object name in the network objects web table
					 DeleteOrEditExpectedNetworkUnderNetworkObjectsWebTable(sNetworkName, false, false);
					 
					// log out 
					 LoginTestCase_Old1.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("Issue with createNewObjectGroupAndVerify test case");
			LoggerUtil.log_type_error("exception occured " +FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	TestScript 		: creatNetworkObjectGroupAndVerify
	Manual TestCase	: QAT-921
	Description		: Verify that a new object group
	Author 			: QAA04
	Creation Date 	: 03/30/2016
	Release Name    : LefcourtSP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=17)
	public void creatNetworkObjectGroupAndVerify() {
		
		WebElement wExpander,wFirstRow,wCreateImg;
		String sNetworkName,sGroupName;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		
		try {
			FrameworkUtil.sTestCaseName="creatNetworkObjectGroupAndVerify";
			FrameworkUtil.sManualTestCaseName="(QAT-921) LefCourtSP2 - Verify that a new object group";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to the navigator
			LoginTestCase_Old1.LoginAsQaautoAUser();
			
			// navigating to the firewall page
					EVDC_FirewallTestCase.NavigateToFirewallPage();
					
					// wait for the feedback message not displayed 
					waitForFeedbackMsgNotdisplayed();
				
					// GOM 
					WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
					WebObjectUtil.explicitWait(5);
					WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
					WebObjectUtil.explicitWait(3);
					wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
					WebObjectUtil.clickElement(wExpander);
					WebObjectUtil.explicitWait(3);
					wFirstRow = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.NETWORKOBJECTS.WEBTABLE", "PARAMETER_ROWNUMBER", 1+""); 
					WebObjectUtil.clickElement(wFirstRow);
					
					wCreateImg = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.CREATEIMAGE", "PARAMETER_ROWNUMBER", 1+""); 
					WebObjectUtil.clickElement(wCreateImg);
					
					// select form the drop down
					SelectElementFromDropDown(FirewallPF.getNav_Network_ObjectTypeDropDownArrow(), "Object Group");
					
					 
					 WebObjectUtil.selectCheckRadioBox(FirewallPF.getNav_Network_NewObjectRadioBtn());
					
					 sNetworkName = "SeleniumTest_FWnetwork5" + FrameworkUtil.sTimeStamp;
					 WebObjectUtil.SetValueEdit(FirewallPF.getNav_Network_NetworkNameEditBox(), sNetworkName);
					
					 
					 //select from the drop down
					 SelectElementFromDropDown(FirewallPF.getNav_Network_TypeDropDownArrow(), "Range");
					 
					
					 WebObjectUtil.selectCheckRadioBox(FirewallPF.getNav_Network_IPV4Radiobtn());
					
					 // verifying the ipaddress
					 VerifyIPAddressErrorMsg("1.2.3.4/2.3.4.5");
			         WebObjectUtil.explicitWait(3);
					 WebObjectUtil.clickElement(FirewallPF.getNav_Network_ForwardArrow());
					 WebObjectUtil.explicitWait(5);
					 
					// sNetworkName = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.CREATE.NETWORKNAME01");
					 verifyExpectedNetworkNameInGroupWebTable(sNetworkName);
					 
					 sGroupName = "SeleniumTest_FWGrpObjectnetwork5"+FrameworkUtil.sTimeStamp; 
					 WebObjectUtil.SetValueEdit(FirewallPF.getNav_Network_NewNameEditBox(), sGroupName);
					
					WebObjectUtil.explicitWait(5);
					 // clicking on save btn
					WebObjectUtil.scrollToElement(FirewallPF.getNav_Network_SaveBtn());
					
					 WebObjectUtil.clickElement(FirewallPF.getNav_Network_SaveBtn());
					 WebObjectUtil.explicitWait(5);
					 WebObjectUtil.clickElement(FirewallPF.getNav_Network_ConfirmPopupOkBtn());
					 WebObjectUtil.explicitWait(10);
					 String sFeedbackMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.GROUP.FEEDBACK.MESSAGE");
					 String sMsg = FirewallPF.getNav_Network_FeedbackMsg().getText();
							 
					 boolean bSaveNetwork = sMsg.contains(sFeedbackMsg);
					 FrameworkUtil.updateCustomResultBasedOnStatus(bSaveNetwork, sMsg);
				
				// wait for feedback msg not displayed
					 waitForFeedbackMsgNotdisplayed();
					 
					// GOM 
						WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
						WebObjectUtil.explicitWait(5);
						WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
						WebObjectUtil.explicitWait(3);
						wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
						WebObjectUtil.clickElement(wExpander);
						// verifying the object group name in the network objects web table
					 DeleteOrEditExpectedNetworkUnderNetworkObjectsWebTable(sGroupName, false, false);
					
					 // verifying the object name in the network objects web table
					 DeleteOrEditExpectedNetworkUnderNetworkObjectsWebTable(sNetworkName, false, false);
					 
					// log out 
					 LoginTestCase_Old1.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("Issue with creatNetworkObjectGroupAndVerify test case");
			LoggerUtil.log_type_error("exception occured " +FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception occured", "fail", e.getMessage()+"null");
		}
			
	}
	
	/*==============================================================
	TestScript 		: createNewObjectGrpForQaautoaUser
	Manual TestCase	: QAT-919
	Description		: Verify that a new object group Verify that a new object group "FWGrpObjectnetwork3" with the object "FWnetwork3".
	Author 			: QAA04
	Creation Date 	: 04/04/2016
	Release Name    : LefcourtSP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=18)
	public void createNewObjectGrpForQaautoaUser(){
		WebElement wExpander,wFirstRow,wCreateImg;
		String sNetworkName,sGroupName;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		
		try {
			FrameworkUtil.sTestCaseName="createNewObjectGrpForQaautoaUser";
			FrameworkUtil.sManualTestCaseName="(QAT-919) LefCourtsp2 - Verify that a new object group Verify that a new object group FWGrpObjectnetwork3 with the object FWnetwork3.";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);

// login to the navigator
			LoginTestCase_Old1.LoginAsQaautoAUser();
			
 // navigating to the firewall page
			EVDC_FirewallTestCase.NavigateToFirewallPage();
			
			// wait for the feedback message not displayed 
			waitForFeedbackMsgNotdisplayed();

			// GOM 
			WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
			WebObjectUtil.explicitWait(5);
			WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
			WebObjectUtil.explicitWait(3);
			wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
			WebObjectUtil.clickElement(wExpander);
			WebObjectUtil.explicitWait(3);
			wFirstRow = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.NETWORKOBJECTS.WEBTABLE", "PARAMETER_ROWNUMBER", 1+""); 
			WebObjectUtil.clickElement(wFirstRow);
			
			wCreateImg = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.CREATEIMAGE", "PARAMETER_ROWNUMBER", 1+""); 
			WebObjectUtil.clickElement(wCreateImg);
			
			// select form the drop down
			SelectElementFromDropDown(FirewallPF.getNav_Network_ObjectTypeDropDownArrow(), "Object Group");
			
			 
			 WebObjectUtil.selectCheckRadioBox(FirewallPF.getNav_Network_NewObjectRadioBtn());
			
			 sNetworkName = "SeleniumTest_FWnetwork3" + FrameworkUtil.sTimeStamp;
			 WebObjectUtil.SetValueEdit(FirewallPF.getNav_Network_NetworkNameEditBox(), sNetworkName);
			
			 
			 //select from the drop down
			 SelectElementFromDropDown(FirewallPF.getNav_Network_TypeDropDownArrow(), "Range");
			 
			
			 WebObjectUtil.selectCheckRadioBox(FirewallPF.getNav_Network_IPV4Radiobtn());
			
			 // verifying the ipaddress
			 VerifyIPAddressErrorMsg("1.2.3.4/2.3.4.5");
			 WebObjectUtil.explicitWait(3);
			 WebObjectUtil.clickElement(FirewallPF.getNav_Network_ForwardArrow());
			 WebObjectUtil.explicitWait(5);
			 
			// sNetworkName = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.CREATE.NETWORKNAME01");
			 verifyExpectedNetworkNameInGroupWebTable(sNetworkName);
			 
			 sGroupName = "SeleniumTest_FWGrpObjectnetwork3"+FrameworkUtil.sTimeStamp; 
			 WebObjectUtil.SetValueEdit(FirewallPF.getNav_Network_NewNameEditBox(), sGroupName);
			
			WebObjectUtil.explicitWait(5);
			 // clicking on save btn
			WebObjectUtil.scrollToElement(FirewallPF.getNav_Network_SaveBtn());
			
			 WebObjectUtil.clickElement(FirewallPF.getNav_Network_SaveBtn());
			 WebObjectUtil.explicitWait(5);
			 WebObjectUtil.clickElement(FirewallPF.getNav_Network_ConfirmPopupOkBtn());
			 WebObjectUtil.explicitWait(10);
			 String sFeedbackMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.GROUP.FEEDBACK.MESSAGE");
			 String sMsg = FirewallPF.getNav_Network_FeedbackMsg().getText();
					 
			 boolean bSaveNetwork = sMsg.contains(sFeedbackMsg);
			 FrameworkUtil.updateCustomResultBasedOnStatus(bSaveNetwork, sMsg);

// wait for feedback msg not displayed
			 waitForFeedbackMsgNotdisplayed();
			 
			// GOM 
				WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
				WebObjectUtil.explicitWait(5);
				WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
				WebObjectUtil.explicitWait(3);
				wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
				WebObjectUtil.clickElement(wExpander);
				// verifying the object group name in the network objects web table
			 DeleteOrEditExpectedNetworkUnderNetworkObjectsWebTable(sGroupName, false, false);
			
			 // verifying the object name in the network objects web table
			 DeleteOrEditExpectedNetworkUnderNetworkObjectsWebTable(sNetworkName, false, false);
			 
			// log out 
			 LoginTestCase_Old1.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("Issue with createNewObjectGrpForQaautoaUser test case");
			LoggerUtil.log_type_error("exception occured " +FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception occured", "fail", e.getMessage()+"null");
		}
	
	}
	
	/*==============================================================
	TestScript 		: createNewNetworkObjectGrp
	Manual TestCase	: QAT-918
	Description		: Verify that a new object group "FWGrpObjectnetwork2" is created with object "FWnetwork2".
	Author 			: QAA04
	Creation Date 	: 04/04/2016
	Release Name    : LefcourtSP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=19)
	public void createNewNetworkObjectGrp(){
		WebElement wExpander,wFirstRow,wCreateImg;
		String sNetworkName,sGroupName;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		try{
		FrameworkUtil.sTestCaseName="createNewNetworkObjectGrp";
		FrameworkUtil.sManualTestCaseName="(QAT-918) LefCourtSP2 - Verify that a new object group FWGrpObjectnetwork2 is created with object FWnetwork2.";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	
		// login to the navigator
					LoginTestCase_Old1.LoginAsQaautoAUser();
					
		 // navigating to the firewall page
					EVDC_FirewallTestCase.NavigateToFirewallPage();
					
					// wait for the feedback message not displayed 
					waitForFeedbackMsgNotdisplayed();

					// GOM 
					WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
					WebObjectUtil.explicitWait(5);
					WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
					WebObjectUtil.explicitWait(3);
					wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
					WebObjectUtil.clickElement(wExpander);
					WebObjectUtil.explicitWait(3);
					wFirstRow = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.NETWORKOBJECTS.WEBTABLE", "PARAMETER_ROWNUMBER", 1+""); 
					WebObjectUtil.clickElement(wFirstRow);
					
					wCreateImg = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.CREATEIMAGE", "PARAMETER_ROWNUMBER", 1+""); 
					WebObjectUtil.clickElement(wCreateImg);
					
					// select form the drop down
					SelectElementFromDropDown(FirewallPF.getNav_Network_ObjectTypeDropDownArrow(), "Object Group");
					
					 
					 WebObjectUtil.selectCheckRadioBox(FirewallPF.getNav_Network_NewObjectRadioBtn());
					
					 sNetworkName = "SeleniumTest_FWnetwork2" + FrameworkUtil.sTimeStamp;
					 WebObjectUtil.SetValueEdit(FirewallPF.getNav_Network_NetworkNameEditBox(), sNetworkName);
					
					 
					 //select from the drop down
					 SelectElementFromDropDown(FirewallPF.getNav_Network_TypeDropDownArrow(), "Network");
					 
					
					 WebObjectUtil.selectCheckRadioBox(FirewallPF.getNav_Network_IPV4Radiobtn());
					
					 // verifying the ipaddress,Please pass values from properties file-by Priyanka
					 VerifyIPAddressErrorMsg("11.22.33.44");
					 WebObjectUtil.explicitWait(3);
					 WebObjectUtil.SetValueEdit(FirewallPF.getNav_Network_NetmaskEditBox(), "/32");
					 WebObjectUtil.explicitWait(4);
					 WebObjectUtil.clickElement(FirewallPF.getNav_Network_ForwardArrow());
					 WebObjectUtil.explicitWait(5);
					 
					// sNetworkName = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.CREATE.NETWORKNAME01");
					 verifyExpectedNetworkNameInGroupWebTable(sNetworkName);
					 
					 sGroupName = "SeleniumTest_FWGrpObjectnetwork2"+FrameworkUtil.sTimeStamp; 
					 WebObjectUtil.SetValueEdit(FirewallPF.getNav_Network_NewNameEditBox(), sGroupName);
					
					WebObjectUtil.explicitWait(5);
					 // clicking on save btn
					WebObjectUtil.scrollToElement(FirewallPF.getNav_Network_SaveBtn());
					
					 WebObjectUtil.clickElement(FirewallPF.getNav_Network_SaveBtn());
					 WebObjectUtil.explicitWait(5);
					 WebObjectUtil.clickElement(FirewallPF.getNav_Network_ConfirmPopupOkBtn());
					 WebObjectUtil.explicitWait(10);
					 String sFeedbackMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.GROUP.FEEDBACK.MESSAGE");
					 String sMsg = FirewallPF.getNav_Network_FeedbackMsg().getText();
							 
					 boolean bSaveNetwork = sMsg.contains(sFeedbackMsg);
					 FrameworkUtil.updateCustomResultBasedOnStatus(bSaveNetwork, sMsg);

		// wait for feedback msg not displayed
					 waitForFeedbackMsgNotdisplayed();
					 
					// GOM 
						WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
						WebObjectUtil.explicitWait(5);
						WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
						WebObjectUtil.explicitWait(3);
						wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
						WebObjectUtil.clickElement(wExpander);
						// verifying the object group name in the network objects web table
					 DeleteOrEditExpectedNetworkUnderNetworkObjectsWebTable(sGroupName, false, false);
					
					 // verifying the object name in the network objects web table
					 DeleteOrEditExpectedNetworkUnderNetworkObjectsWebTable(sNetworkName, false, false);
					 
					// log out 
					 LoginTestCase_Old1.nav_Logout();
				} catch (Exception e) {
					LoggerUtil.log_type_error("Issue with createNewNetworkObjectGrp test case");
					LoggerUtil.log_type_error("exception occured " +FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception occured", "fail", e.getMessage()+"null");
				}
	}
	
	
	/*==============================================================
	TestScript 		: verifySearchEditBoxFunctionality
	Manual TestCase	: QAT-975
	Description		: 
	Author 			: QAA04
	Creation Date 	: 04/06/2016
	Release Name    : LefcourtSP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=20)
	public void verifySearchEditBoxFunctionality(){
		WebElement wExpander;
		String sCount;
		int iSearchCount,iCount;
		boolean bStatus;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		
		try {
			FrameworkUtil.sTestCaseName="verifySearchEditBoxFunctionality";
			FrameworkUtil.sManualTestCaseName="(QAT-975) LefCourtSP2 - Verify that the number of records matching to the text count is displayed next to Matches";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);

			// login to the navigator
			LoginTestCase_Old1.LoginAsQaautoAUser();
			
   // navigating to the firewall page
			EVDC_FirewallTestCase.NavigateToFirewallPage();
			
			// GOM 
			WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
			WebObjectUtil.explicitWait(5);
			WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
			WebObjectUtil.explicitWait(3);
			wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
			WebObjectUtil.clickElement(wExpander);
			WebObjectUtil.explicitWait(3);

			// verifying the search edit box
			WebObjectUtil.verifyElementPresent(FirewallPF.getNav_Network_SearchEditBox());
			
			WebObjectUtil.SetValueEdit(FirewallPF.getNav_Network_SearchEditBox(), "qaacreateobjgrp-2");
			WebObjectUtil.explicitWait(3);
			sCount = FirewallPF.getNav_Network_SearchMatchesCount().getText();
			 iCount = Integer.parseInt(sCount);
			 
			 iSearchCount = getCountOfSearchElement("qaacreateobjgrp-2");
			
			 bStatus= (iCount==iSearchCount);
			 FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "The number of records matching to the text count is displayed next to Matches");

   /// log out
			 LoginTestCase_Old1.nav_Logout();
			 
		} catch (Exception e) {
			LoggerUtil.log_type_error("Issue with verifySearchEditBoxFunctionality test case");
			LoggerUtil.log_type_error("exception occured " +FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception occured", "fail", e.getMessage()+"null");
		}
		 
	}
	
	/*==============================================================
	TestScript 		: editNetworkObject
	Manual TestCase	: QAT-968
	Description		: 
	Author 			: QAA04
	Creation Date 	: 04/07/2016
	Release Name    : LefcourtSP2
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=21)
	public void editNetworkObject(){
		WebElement wExpander,wEditIcon,wExistingWebTableParent;
	    String sClassValue,sGroupName,sFeedBackMsg,sMsg,sNetworkName,sNewName;
	    int iRow;
	    boolean bStatus;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		
		try {
			FrameworkUtil.sTestCaseName ="editNetworkObject";
			FrameworkUtil.sManualTestCaseName="(QAT-968) LefCourtSP2 - edit the network object and click on save button";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			// login to the navigator
			LoginTestCase_Old1.LoginAsQaautoAUser();
			
			
			// navigating to the firewall page
				EVDC_FirewallTestCase.NavigateToFirewallPage();
				
				// wait for the feedback message not displayed
					waitForFeedbackMsgNotdisplayed();
					
					WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
					
					WebObjectUtil.explicitWait(10);
					WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
					
					WebObjectUtil.explicitWait(3);
					wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
					WebObjectUtil.clickElement(wExpander);

					WebObjectUtil.explicitWait(5);
					sGroupName ="SeleniumTest_FWGrpObjectnetwork520160330_073705";
					iRow = DeleteOrEditExpectedNetworkUnderNetworkObjectsWebTable(sGroupName, false, false);
					
					wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", iRow+"");
					WebObjectUtil.clickElement(wExpander);
			        sNetworkName ="SeleniumTest_FWnetwork520160330_073705";
					iRow = DeleteOrEditExpectedNetworkUnderNetworkObjectsWebTable(sNetworkName, false, false);
					
				    wEditIcon =WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.EDITIMAGE", "PARAMETER_ROWNUMBER", iRow+"");
				    WebObjectUtil.clickElement(wEditIcon);

				    wExistingWebTableParent = driver.findElement(By.xpath("//div[@id='lefthandgrid-body']/../div[contains(@id,'ext-element-')]"));
				    sClassValue = wExistingWebTableParent.getAttribute("class");
				    bStatus = sClassValue.contains("x-mask x-border-box");
				    FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Existing webtable is  greyed out");
				 
				    // verifying the edit radio btn 
				    WebObjectUtil.verifyElementPresent(FirewallPF.getNav_Network_EditObjectRadioBtn());
				    
				    sNewName = FirewallPF.getNav_Network_NewNameEditBox().getAttribute("value");
				  bStatus = sNewName.equalsIgnoreCase(sNetworkName);
				  FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Expected network name is displaying in the new name edit field");
				 
				  WebObjectUtil.MouseHover(FirewallPF.getNav_Network_NewNameEditBox());
				  GOMCreateObjectToolTipMsg(FirewallPF.getNav_Network_NewNameEditBox(), "data-qtip", "Name cannot be edited, if you'd like to change the name, delete the entity first and then add a new one");
				   

				  WebObjectUtil.selectCheckRadioBox(FirewallPF.getNav_Network_EditObjectRadioBtn());
				  SelectElementFromDropDown(FirewallPF.getNav_Network_TypeDropDownArrow(), "Host");
				
				  WebObjectUtil.SetValueEdit(FirewallPF.getNav_Network_IPAddressEditBox(), "1.2.3.4");
				  
				  WebObjectUtil.explicitWait(5);
					WebObjectUtil.clickElement(FirewallPF.getNav_Network_ForwardArrow());
					WebObjectUtil.explicitWait(5);
					
					WebObjectUtil.scrollToElement(FirewallPF.getNav_Network_SaveBtn());
					WebObjectUtil.clickElement(FirewallPF.getNav_Network_SaveBtn());
					WebObjectUtil.explicitWait(5);
					WebObjectUtil.clickElement(FirewallPF.getNav_Network_ConfirmPopupOkBtn());
				    WebObjectUtil.explicitWait(10);
					sMsg = (String) FrameworkUtil.dictPropertyData.get("NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.OBJECT.EDIT.FEEDBACK.MESSAGE");
					sFeedBackMsg= FirewallPF.getNav_Network_FeedbackMsg().getText();
					bStatus = sFeedBackMsg.contains(sMsg);
					FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, sFeedBackMsg);
							
					// wait for the feedback message not displayed
					waitForFeedbackMsgNotdisplayed();
					
					WebObjectUtil.clickElement(FirewallPF.getNav_GOMLink());
					
					WebObjectUtil.explicitWait(10);
					WebObjectUtil.clickElement(FirewallPF.getNav_NetworkObjectExpander());
					
					WebObjectUtil.explicitWait(3);
					wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", 1+"");
					WebObjectUtil.clickElement(wExpander);

					WebObjectUtil.explicitWait(5);
					iRow = DeleteOrEditExpectedNetworkUnderNetworkObjectsWebTable("FWGrpObjectnetwork5", false, false);
					
					wExpander= WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORK.EXPANDER", "PARAMETER_ROWNUMBER", iRow+"");
					WebObjectUtil.clickElement(wExpander);

					DeleteOrEditExpectedNetworkUnderNetworkObjectsWebTable("FWnetwork5", false, false);

					// log out
					LoginTestCase_Old1.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_error("Issue with editNetworkObject test case");
			LoggerUtil.log_type_error("exception occured " +FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "exception occured", "fail", e.getMessage()+"null");
		}
				
	}
	
	/////////////////////////////////////////////////// Methods //////////////////////////////////////////////////////////////////
	/*==============================================================
	MethodName 		: getRowCountInEveryPage
	Manual TestCase	: 
	Description		: get the row count in every page and search for the expected network in the existing web table
	Author 			: QAA04
	Creation Date 	: 03/01/2016
	release Name    : 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static boolean getRowCountInEachPage(WebElement wWebTableParent, String sExpectedNetworkName){
		boolean bStatus=false;
		int iRowCount;
		String sTotalPaginationCount,sPaginationCount,sNetworkName;
		String[] sTotalCount;
		WebElement wNetworkName;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		
		try {
			sPaginationCount = FirewallPF.getNav_Network_ExistingObject_PaginationTotalCount().getText();
			sTotalCount =sPaginationCount.split(" ");
			sTotalPaginationCount = sTotalCount[1];
			int iTotalPaginationCount = Integer.parseInt(sTotalPaginationCount);
			
			for(int i=1; i<=iTotalPaginationCount; i++){
				
			CustomWebElementUtil.loadCustomElement(wWebTableParent, "table");
			iRowCount = CustomWebElementUtil.iRowCount;
			   if(iRowCount<=5){
			
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Page count", "Done", i+" page conut is "+iRowCount);
			    }else{
			    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Page count", "fail", i+" page conut is more then five "+iRowCount);
			    }
			   for(int j=1; j<=iRowCount;j++){
				 wNetworkName =  WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NTEWORKOBJETS.EXISTINGOBJECTS.WEBTABLE.COLUMN.NAME", "PARAMETER_ROWNUMBER", j+"");
				   sNetworkName = wNetworkName.getText();
				   
				   if(sExpectedNetworkName != null && sExpectedNetworkName.equalsIgnoreCase(sNetworkName)){
					  WebObjectUtil.clickElement(wNetworkName);
					   bStatus = true;
					  break;
				   }
				  
			   }
			  if(bStatus==true){
				  break;
			  }
			WebObjectUtil.clickElement(FirewallPF.getNav_Network_ExistingObject_PaginationNextBtn());
			WebObjectUtil.explicitWait(5);
			}
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bStatus;	
	}
	
	
	/*==============================================================
	MethodName 		: waitForFeedbackMsgNotdisplayed
	Manual TestCase	: 
	Description		: Wait for the feedback message until not dispalyed in the feedback area 
	Author 			: Sukur
	Creation Date 	: 02/18/2016
	release Name    : 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void waitForFeedbackMsgNotdisplayed()
	 {
	  
	  String sWaitFeedBackMsg;
	  boolean sukur=true;
	  Date d=new Date();
	  //d=d.getDate();
	  int dStrtsec,endSec = 0;
	  //d.get
	  sWaitFeedBackMsg=(String) FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.WAITING.FEEDBACK.MSG");
	  WebDriver driver = WebDriverUtil.getDriver();
	  //PageFactory.initElements(driver, AddFirewallRuleTestCase.Firewall);
	  PageFactory.initElements(driver, FirewallPF);
	  PageFactory.initElements(driver, Common);
	  try{
	   dStrtsec=d.getSeconds();
	   
	   do
	   {
	     
	    driver.navigate().refresh();
	    WebObjectUtil.explicitWait(5);
	   // if(FirewallPF.getNav_Network_FeedbackMsg().getText().contains(sWaitFeedBackMsg)) 
	     if(Common.getNav_UsrFeedBack().getText().contains(sWaitFeedBackMsg))
	     WebObjectUtil.explicitWait(30);
	    endSec=endSec+d.getSeconds();
	    System.out.println("End Second"+endSec);
	    if(endSec>600)
	     break;
	 
	   }
	   //while(FirewallPF.getNav_Network_FeedbackMsg().getText().contains(sWaitFeedBackMsg));
	   while(Common.getNav_UsrFeedBack().getText().contains(sWaitFeedBackMsg));
	   //  while(CommonPF.getNav_UsrFeedBack().getText().contains(sWaitFeedBackMsg));
	    //while(sukur=true);
	    
	   }
	   catch(Exception e)
	   {
	    
	   }
	   
	  }
	
	
	
	/*==============================================================
	MethodName 		: SelectElementFromDropDown
	Manual TestCase	: 
	Description		: Select the element for the custom drop down by visible text
	Author 			: QAA04
	Creation Date 	: 02/10/2016
	release Name    : 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void SelectElementFromDropDown(WebElement wDropDownArrow, String sDropDownVisibleText){
		WebElement wTypeDropdown;
		String sXpath;
		try{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		
		 WebObjectUtil.clickElement(wDropDownArrow);
		 sXpath = (String) FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
		 wTypeDropdown =WebObjectUtil.getActiveElementasWebElement(sXpath);
		 WebObjectUtil.selectCustomWebList(wTypeDropdown, sDropDownVisibleText);
		}catch(Exception e){
			LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
			LoggerUtil.log_type_error(e.getMessage());
		}
	}
	/*==============================================================
	MethodName 		: VerifyIPAddressErrorMsg
	Manual TestCase	: 
	Description		: Verify that the IP address has 4 Octects and it is entered successfully without error msg 
	Author 			: QAA04
	Creation Date 	: 02/10/2016
	release Name    : 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void VerifyIPAddressErrorMsg(String sIPAddress){
		 boolean bStatus;
		try {
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, FirewallPF);
			 WebObjectUtil.SetValueEdit(FirewallPF.getNav_Network_IPAddressEditBox(), sIPAddress);
			 WebObjectUtil.MouseHover(FirewallPF.getNav_Network_IPAddressEditBox());
			 bStatus = GOMCreateObjectToolTipMsg(FirewallPF.getNav_Network_IPAddressEditBox(), "data-errorqtip", "Invalid IP");
			 if(!bStatus){
				 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying the ipaddress", "pass", "Error popup is NOT displaying for this - "+sIPAddress);
			 }else{
				 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying the ipaddress", "fail", "Error popup is displaying for this - "+sIPAddress);
			 }
		 }catch(Exception e){
			LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
			LoggerUtil.log_type_error(e.getMessage());
		}
	}
	
	
	/*==============================================================
	MethodName 		: verifyExpectedNetworkNameInGroupWebTable
	Manual TestCase	: 
	Description		: Verify the expected network is displaying in the group web table
	Author 			: QAA04
	Creation Date 	: 02/10/2016
	release Name    : 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void verifyExpectedNetworkNameInGroupWebTable(String sExpectedNetworkName){
		int iRow;
		String sName;
		WebElement wName;
		boolean bResultStatus;
		try {
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, FirewallPF);
			
			CustomWebElementUtil.loadCustomElement(FirewallPF.getNav_Network_GroupWebTableParent(), "table");
			 iRow = CustomWebElementUtil.iRowCount;
			 
			 wName = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.GROUPWEBTABLE.COLUMN.NAME", "PARAMETER_ROWNUMBER", iRow+"");
			 sName = wName.getText();
			 WebObjectUtil.clickElement(wName);
			 bResultStatus = sExpectedNetworkName.equalsIgnoreCase(sName);
			 FrameworkUtil.updateCustomResultBasedOnStatus(bResultStatus, "Verifying the expected network in the group web table");
		}catch(Exception e){
			LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
			LoggerUtil.log_type_error(e.getMessage());
		}
		 
		
	}
	/*==============================================================
	MethodName 		: verifyExpectedNetworkNOTPresentInNetworkWebTable
	Manual TestCase	: 
	Description		: Verify the expected network NOT is displaying in the web table
	Author 			: QAA04
	Creation Date 	: 03/14/2016
	release Name    : 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void verifyExpectedNetworkNOTPresentInNetworkWebTable(String sExpectedNetworkName){
		int iRow;
		WebElement wName;
		String sName;
		boolean bResultStatus;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		
		try {
			CustomWebElementUtil.loadCustomElement(FirewallPF.getNav_Network_NetworkObjectWebTableParent(), "table");
			 iRow = CustomWebElementUtil.iRowCount;
			 for (int i=1; i<=iRow; i++) {
			 wName = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.WEBTABLE.NETWORK.NAME", "PARAMETER_ROWNUMBER,PARAMETER_COLUMNNUMBER", i+","+1);
			 sName = wName.getText();
			
			 bResultStatus = sName.equalsIgnoreCase(sExpectedNetworkName);
			 
			    FrameworkUtil.updateCustomResultBasedOnStatus(!bResultStatus, ""+sExpectedNetworkName+" object NOT displaying in the web table");  
			  
			 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*==============================================================
	MethodName 		: DeleteOrEditExpectedNetworkUnderNetworkObjectsWebTable
	Manual TestCase	: 
	Description		: Verify the expected network is displaying in the group web table
	Author 			: QAA04
	Creation Date 	: 02/10/2016
	release Name    : 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static int DeleteOrEditExpectedNetworkUnderNetworkObjectsWebTable(String sExpectedNetworkName, boolean bDeleteNetworkClickStatus, boolean bEditNetworkClickStatus){
		int i = 0,iRow;
		String sName;
		WebElement wName = null,wDeleteNetwork,wEditNetwork;
		boolean bResultStatus=false;
		try {
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, FirewallPF);
			
			CustomWebElementUtil.loadCustomElement(FirewallPF.getNav_Network_NetworkObjectWebTableParent(), "table");
			 iRow = CustomWebElementUtil.iRowCount;
			 for (i=1; i<=iRow; i++) {
			 wName = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.WEBTABLE.NETWORK.NAME",  "PARAMETER_ROWNUMBER,PARAMETER_COLUMNNUMBER", i+","+1);
			 sName = wName.getText();
			
			 bResultStatus = sName.equalsIgnoreCase(sExpectedNetworkName);
			   if(bResultStatus==true){
			    FrameworkUtil.updateCustomResultBasedOnStatus(bResultStatus, "Verifying the expected network in the web table");
			     WebObjectUtil.clickElement(wName);
			    //WebObjectUtil.ClickAndMouseHover(wName); 
			    if(bDeleteNetworkClickStatus==true){
			    	 wDeleteNetwork = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.DELETEIMAGE", "PARAMETER_ROWNUMBER", i+"");
			    	 WebObjectUtil.clickElement(wDeleteNetwork);
			    	 WebObjectUtil.explicitWait(5);
			    	 WebObjectUtil.clickElement(FirewallPF.getNav_Network_ConfirmPopupOkBtn());
			    	 WebObjectUtil.explicitWait(10);
			     }
			     if(bEditNetworkClickStatus==true){
			    	 wEditNetwork = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.EDITIMAGE", "PARAMETER_ROWNUMBER", i+"");
			    	 WebObjectUtil.clickElement(wEditNetwork);
			    	 WebObjectUtil.explicitWait(5);
			     }
			    break;
			   }
			}
			 }catch(Exception e){
			LoggerUtil.log_type_error("Exception occured"+FrameworkUtil.sElementName);
			LoggerUtil.log_type_error(e.getMessage());
		}
		return i;
		
		 
		
	}
	
	/*==============================================================
	MethodName 		: GOMCreateObjectToolTipMsg
	Manual TestCase	: 
	Description		: verify tooltip text for GOM objects
	Author 			: QAA04
	Creation Date 	: 02/16/2016
	release Name    : 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static boolean GOMCreateObjectToolTipMsg(WebElement webElement, String sAttributeName, String sTooltipMsg){
		boolean bStatus = false;
		String sToolTipFromWeb;
		
		try {
			if (WebObjectUtil.isElementPresent(webElement)){
				System.out.println(webElement.getText());
				sToolTipFromWeb = webElement.getAttribute(sAttributeName); // old attribute name - "data-errorqtip"
				
				if (sToolTipFromWeb.contains(sTooltipMsg)){
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Tool Tips", "pass", "Text present: "+ sTooltipMsg);
						bStatus = true;
					}else{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Tool Tips", "pass", "Text present: "+ sTooltipMsg);
					}
			}else{
				LoggerUtil.log_type_info("Element not present" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element NOT present", "fail", "Element not present/visible ");
			}
		} catch (Exception e) {
			LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "getToolTipsMsg", "warn", "catch block:Could NOT access webelement" +e.getMessage());

		}
		return bStatus;
	}
	
	/*==============================================================
	MethodName 		: navDeleteObjectUnderNetworkObject
	Manual TestCase	: 
	Description		: deleting the object from the network objects webtable 
	Author 			: QAA04
	Creation Date 	: 02/16/2016
	release Name    : 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static String navDeleteObjectUnderNetworkObject(){
		int iRowCount;
		WebElement wObjectRow,wDelete,wDeleteObject;
		String sDeleteMsg,sDeleteObjectName=null;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		
		 try {
			CustomWebElementUtil.loadCustomElement(FirewallPF.getNav_Network_NetworkObjectWebTableParent(), "table");
			 iRowCount = CustomWebElementUtil.iRowCount;
			 WebObjectUtil.explicitWait(3);
			 
			 for(int i=iRowCount; i>=1; i--){
				 
				 wObjectRow = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.NETWORKOBJECTS.WEBTABLE", "PARAMETER_ROWNUMBER", i+""); 
				 WebObjectUtil.clickElement(wObjectRow);
			     
				 wDelete = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.DELETEIMAGE", "PARAMETER_ROWNUMBER", i+"");
				 if(WebObjectUtil.isElementPresent(wDelete)){
				   WebObjectUtil.clickElement(wDelete);
				
				    WebObjectUtil.explicitWait(3);
				   
			        if(WebObjectUtil.isElementPresent(FirewallPF.getNav_Network_ConfirmPopupBox())){
			        	wDeleteObject = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.WEBTABLE.NETWORK.NAME",  "PARAMETER_ROWNUMBER,PARAMETER_COLUMNNUMBER", i+","+1);
			        	sDeleteObjectName = wDeleteObject.getText();
			        	sDeleteMsg = FirewallPF.getNav_Network_ConfirmPopupBox().getText();
			        	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verifying the delete message", "pass", " "+sDeleteMsg);
			    	   WebObjectUtil.clickElement(FirewallPF.getNav_Network_ConfirmPopupOkBtn());
				 		 break;
			          }
				}else{
					
				}
			 }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sDeleteObjectName;
	}
	
    
	
	/*==============================================================
	MethodName 		: navEditObjectUnderNetworkObject
	Manual TestCase	: 
	Description		: clicking on edit image under network objects.
	Author 			: QAA04
	Creation Date 	: 02/25/2016
	release Name    : 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static String navEditObjectUnderNetworkObject(){
		int iRowCount;
		WebElement wObjectRow,wEdit,wEditObject;
		String sEditObjectName = null;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		
		 
			try {
				CustomWebElementUtil.loadCustomElement(FirewallPF.getNav_Network_NetworkObjectWebTableParent(), "table");
				 iRowCount = CustomWebElementUtil.iRowCount;
				 WebObjectUtil.explicitWait(3);
				 
				 for(int i=1; i<=iRowCount; i++){
					 
					 wObjectRow = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.NETWORKOBJECTS.WEBTABLE", "PARAMETER_ROWNUMBER", i+""); 
					 WebObjectUtil.clickElement(wObjectRow);
				     
					 wEdit = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.EDITIMAGE", "PARAMETER_ROWNUMBER", i+"");
					 if(WebObjectUtil.verifyElementPresent(wEdit)){
					   WebObjectUtil.clickElement(wEdit);
					
					    WebObjectUtil.explicitWait(3);
					   
				        if(WebObjectUtil.isElementPresent(FirewallPF.getNav_Network_CreateEditPopupBox())){
				        	wEditObject = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.WEBTABLE.NETWORK.NAME",  "PARAMETER_ROWNUMBER,PARAMETER_COLUMNNUMBER", i+","+1);
				        	sEditObjectName = wEditObject.getText();
				        	
				        	break;
				        }
				        
					 }
					
				 }
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return sEditObjectName;
			
	}
	
	/*==============================================================
	MethodName 		: navVerifyTheNewNameEditFieldErrorMsg
	Manual TestCase	: 
	Description		: Verify that name field does not accept more than 64 characters
	Author 			: QAA04
	Creation Date 	: 03/22/2016
	release Name    : 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static boolean navVerifyTheNewNameEditFieldErrorMsg(String sText){
		String sValue;
		int iLength;
		boolean bStatus = false;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		
			try {
				// Create a new StringBuilder.
				StringBuilder builder = new StringBuilder();

				// Loop and append values.
				for (int i=0; i<=65; i++) {
				    builder.append(sText);
				 // Convert to string.
					sValue = builder.toString();
					iLength = sValue.length();
					if(iLength>65){
						// Print result.
						System.out.println(sValue);
						WebObjectUtil.SetValueEdit(FirewallPF.getNav_Network_NewNameEditBox(), sValue);
						WebObjectUtil.clickElement(FirewallPF.getNav_Network_NewNameEditBox());
						
						WebObjectUtil.mouseHoverByJS(FirewallPF.getNav_Network_NewNameEditBox());
						bStatus = GOMCreateObjectToolTipMsg(FirewallPF.getNav_Network_NewNameEditBox(), "data-errorqtip", "Only 64 chars allowed, press tab for error to disappear");
						 break;
					}
				}
				

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return bStatus;	
	}
	
	/*==============================================================
	MethodName 		: verifyNetMaskEditFieldIsEnabled
	Manual TestCase	: 
	Description		: verifying the netmask edit field is enabled no not
	Author 			: QAA04
	Creation Date 	: 03/23/2016
	release Name    : 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static boolean verifyNetMaskEditFieldIsEnabled(String sDropDownVisibleText){
		boolean bStatus=false;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
		
			try {
				SelectElementFromDropDown(FirewallPF.getNav_Network_TypeDropDownArrow(), sDropDownVisibleText);
				
				WebObjectUtil.explicitWait(3);
				bStatus = FirewallPF.getNav_Network_IPAddressEditBox().isEnabled();
				FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "verifying the ipaddress edit field is enabled or not");

				bStatus = FirewallPF.getNav_Network_NetmaskEditBox().isEnabled();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return bStatus;
	
	}
	
	/*==============================================================
	MethodName 		: getCountOfSearchElement
	Manual TestCase	: 
	Description		: we are getting the count of searched element
	Author 			: QAA04
	Creation Date 	: 04/04/2016
	release Name    : 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static int getCountOfSearchElement(String sSearchString){
		WebElement wWebTable;
		String sSearchName;
		int iRowCount=0,iSearchCount=0;
		boolean bResultStatus;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, FirewallPF);
	    	try {
				if (WebObjectUtil.isElementPresent(FirewallPF.getNav_NetworkWebTableParent())){
				
					CustomWebElementUtil.loadCustomElement(FirewallPF.getNav_NetworkWebTableParent(), "table");
					iRowCount = CustomWebElementUtil.iRowCount;
					 for (int i=1; i<=iRowCount; i++) {
						 wWebTable = WebObjectUtil.getWebElementFromDynamicLocator("XPATH", "NAV.EVDC.FIREWALL.GOM.NETWORKOBJECTS.WEBTABLE.NETWORK.NAME",  "PARAMETER_ROWNUMBER,PARAMETER_COLUMNNUMBER", i+","+1);
						 sSearchName = wWebTable.getText();
						 sSearchName = sSearchName.toLowerCase();
						// bResultStatus = sSearchName.equalsIgnoreCase(sSearchString);
						 bResultStatus = sSearchName.contains(sSearchString.toLowerCase());  
						 if(bResultStatus==true){
							   iSearchCount= iSearchCount+1;
							   }
					 }
				}
					
	    	}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return iSearchCount;
	}
	
	
	// after method
	@AfterMethod
	public void afterEachMethod(){
		FrameworkUtil.updateTestCaseStatusinResult();
		FrameworkUtil.sTestExecutionStatus=true;
	}
}
