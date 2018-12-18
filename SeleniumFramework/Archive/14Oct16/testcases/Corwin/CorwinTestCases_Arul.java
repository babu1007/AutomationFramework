package com.whs.navigator.testcases.Corwin;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.EM7PageFactory;
import com.whs.navigator.pagefactory.PhysicalServicesPageFactory;

public class CorwinTestCases_Arul {

	public static PhysicalServicesPageFactory PDC = new PhysicalServicesPageFactory();
	
	
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
	
	
	//update each @Test result in custom result file
	@AfterMethod
	public void afterEachMethod(){
		FrameworkUtil.updateTestCaseStatusinResult();
		FrameworkUtil.sTestExecutionStatus = true;
	}

}
