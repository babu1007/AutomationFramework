package com.whs.navigator.testcases.kyle;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.EVDC_StorageProfilePageFactory;
import com.whs.navigator.pagefactory.EVDC_VM_PageFactory;
import com.whs.navigator.pagefactory.HomePageFactory_old;

public class KyleTestCase_Vivek {
	
	public static EVDC_OverviewPageFactory EVDC_OverviewPF= new EVDC_OverviewPageFactory();
	public static EVDC_VM_PageFactory EVDC_VMPF=new EVDC_VM_PageFactory();
	public static HomePageFactory_old Home = new HomePageFactory_old();
	public static EVDC_StorageProfilePageFactory EVDC_StorageProfile = new EVDC_StorageProfilePageFactory();
	
	
	/*==============================================================
	TestScript  	: verifyEVDCStorageProfile
	Manual TestCase	: QAT-1489 - WCP-5254-TC_1.0_VM Details-> Reports
	Description		: Verify that Storage Profile info is displayed in the VM reports 
	Author 			: Vivek Kumar
	Creation Date 	: 06/20/2016
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=1)
	public void verifyEVDCStorageProfile()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_VMPF);
		
		String sPDFLnkTxt, sCSVLnkTxt, sVMNameorStatus;
		boolean bPDFStatus, bCSVStatus, bStatus;
		WebElement wStorageProfile;
		int iRowNo;
		
		
		FrameworkUtil.sTestCaseName = "Kyle-verifyEVDCStorageProfile";
		FrameworkUtil.sManualTestCaseName = "QAT-1489 - WCP-5254-TC_1.0_VM Details-> Reports";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
		
		try {
			//Login to Navigator using QaAuto
			LoginTestCase_Old1.LoginAsQaautoAUser();
			
			//Navigate to EVDC-VM page
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine(),EVDC_VMPF.getNav_AddVMLink());
			
			
			iRowNo = EVDC_VM_AdvancedActions.getRow_EVDC_VMTable(EVDC_VMPF.getNav_VMWebTableParent(),sVMNameorStatus,"");
			//System.out.println("VM name: " + sVMName + "--" + iRowNo);
			/*//WebTableUtil.printEachCellText(EVDC.getNav_VMWebTable());
			if (iRowNo > 0 ){
				bStatus = true;
				expandVMbyRowNum(iRowNo);
			}*/
			wStorageProfile=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.EVDC.VM.STORAGE.PROFILE", "PARAMETER_ROWNUMBER", iRowNo+"");
			
			 bStatus = LefCourt_SP2TestCase_NMR.GOMCreateObjectToolTipMsg(wStorageProfile, "data-qtip", "HOSTEDSOL-CPTY-ENCRYPT-REPNONE");
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Storage Profile for VM -"+ sVMNameorStatus + "is -HOSTEDSOL-CPTY-ENCRYPT-REPNONE");
			
			//Verifying PDF Icon on VM Machine portlet
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_PDFImg());
			//Verifying the PDF Icon contains "format=pdf"
			 sPDFLnkTxt=EVDC_VMPF.getNav_PDFLink().getAttribute("href");
			 bPDFStatus= sPDFLnkTxt.contains("format=pdf");
			 FrameworkUtil.updateCustomResultBasedOnStatus(bPDFStatus, "PDF link contains  format=pdf");
						
			//Verifying CSV Icon on VM Machine portlet
			WebObjectUtil.verifyElementPresent(EVDC_VMPF.getNav_CSVImg());
			//Verifying the CSV Icon contains "format=csv"
			sCSVLnkTxt=EVDC_VMPF.getNav_CSVLink().getAttribute("href");
			bCSVStatus=sCSVLnkTxt.contains("format=csv");
			FrameworkUtil.updateCustomResultBasedOnStatus(bCSVStatus, "CSV link contains format=csv");
			//Login Out
			LoginTestCase_Old1.nav_Logout();
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	TestScript  	: navValFooterFunctionality
	Manual TestCase	: QAT-1454-WCP_5086_TC_1.1_Update Footer Elements-functionality
					  QAT-1453-WCP_5086_TC_1.0_Update Footer Elements
	Description		: Verify that the footer elements
	Author 			: Vivek Kumar
	Creation Date 	: 06/21/2016
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=2)
	public void navValFooterFunctionality()
	{
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Home);	
		
		String sExpFooterLftTxt, sActFooterLftTxt, sExpFooterRgtTxt, sActFooterRgtTxt,sCompanyTitle,sPrivacyTitle,sAcceptanceTitle,sTermsOfUseTitle;
		
		boolean bStatus=false;
		
		FrameworkUtil.sTestCaseName = "Kyle-navValFooterFunctionality";
		FrameworkUtil.sManualTestCaseName = "QAT-1454,QAT-1453-WCP_5086_TC_1.1_Update Footer Elements-functionality";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	
		sExpFooterLftTxt=(String)FrameworkUtil.dictPropertyData.get("NAV.HOME.FOOTER.LEFT.TEXT");
		sExpFooterRgtTxt=(String)FrameworkUtil.dictPropertyData.get("NAV.HOME.FOOTER.RIGHT.TEXT");
		
		//Title declaration
		sCompanyTitle=(String)FrameworkUtil.dictPropertyData.get("NAV.HOME.FOOTER.COMPANY.TITLE");
		sPrivacyTitle=(String)FrameworkUtil.dictPropertyData.get("NAV.HOME.FOOTER.PRIVACY.TITLE");
		sAcceptanceTitle=(String)FrameworkUtil.dictPropertyData.get("NAV.HOME.FOOTER.ACCEPTANCE.TITLE");
		sTermsOfUseTitle=(String)FrameworkUtil.dictPropertyData.get("NAV.HOME.FOOTER.ACCEPTANCE.TITLE");
		
		try {
			//Login to Navigator using PuppyLove as user
			LoginTestCase_Old1.LoginAsPuppyloveUser();
			
			WebObjectUtil.VerifyTextOnPage("TST German Shepherd");
			//Verifying Copyright Text @ Footer left
			WebObjectUtil.isElementPresent(Home.getNav_FooterLeftCopyright());
			sActFooterLftTxt = Home.getNav_FooterLeftCopyright().getText();
			bStatus=sActFooterLftTxt.contains(sExpFooterLftTxt);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Verifying Footer left text as - " +sExpFooterLftTxt);

			//Verifying text @ Footer Right
			bStatus=false;
			sActFooterRgtTxt=Home.getNav_FooterRightText().getText();
			bStatus=sActFooterRgtTxt.equalsIgnoreCase(sExpFooterRgtTxt);
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Verifying Footer right text as - " +sExpFooterRgtTxt);
			
			//Validating Company footer link
			WebObjectUtil.verifyElementPresent(Home.getNav_FooterRight_Company());
			WebObjectUtil.clickElement(Home.getNav_FooterRight_Company());
			WebObjectUtil.switchToWindow(1, sCompanyTitle);
			WebObjectUtil.verifyElementPresent(Home.getNav_TierPoint_ClientLogin());
			driver.close();
			
			//Validating Privacy Policy 
			WebObjectUtil.switchToParentWindow();
			WebObjectUtil.verifyElementPresent(Home.getNav_FooterRight_PrivacyPolicy());
			WebObjectUtil.clickElement(Home.getNav_FooterRight_PrivacyPolicy());
			WebObjectUtil.switchToWindow(1, sPrivacyTitle);
			WebObjectUtil.verifyElementPresent(Home.getNav_TierPoint_Privacy());
			driver.close();
			
			//Validating Privacy Policy 
			WebObjectUtil.switchToParentWindow();
			WebObjectUtil.verifyElementPresent(Home.getNav_FooterRight_TermsofUse());
			WebObjectUtil.clickElement(Home.getNav_FooterRight_TermsofUse());
			WebObjectUtil.switchToWindow(1, sTermsOfUseTitle);
			WebObjectUtil.verifyElementPresent(Home.getNav_TierPoint_TermsOfUse());
			driver.close();
			
			//Validating acceptable use of policy
			WebObjectUtil.switchToParentWindow();
			WebObjectUtil.verifyElementPresent(Home.getNav_FooterRight_AcceptableUsePolicy());
			WebObjectUtil.clickElement(Home.getNav_FooterRight_AcceptableUsePolicy());
			WebObjectUtil.switchToWindow(1, sAcceptanceTitle);
			WebObjectUtil.verifyElementPresent(Home.getNav_TierPoint_AcceptancePolicy());
			driver.close();
			WebObjectUtil.switchToParentWindow();
					
			//Login Out
			LoginTestCase_Old1.nav_Logout();
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	
	/*==============================================================
	TestScript  	: navValStorageProfileInfo
	Manual TestCase	: QAT-1495-[NAVIGATOR], [NAVIGATOR] Summary View page (Home)
	Description		: Verify that Storage Profile info is displayed in the VM reports 
	Author 			: Vivek Kumar
	Creation Date 	: 06/22/2016
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=3)
	public void navValHomePgStorageProfileInfo()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		
		FrameworkUtil.sTestCaseName = "Kyle-navValStorageProfileInfo";
		FrameworkUtil.sManualTestCaseName = "QAT-1495-[NAVIGATOR],[NAVIGATOR]Summary View page (Home)";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	
		try {
			//Login to Navigator using whs.user as user
			LoginTestCase_Old1.LoginAsWHSUser();
			
			//Verifying vRAM and vCPU section
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_vCPUSection());
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_vRAMSection());
			
			//Verifying the vRAM and vCPU graph
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_vCPUSectionGraph());
			WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_vRAMSectionGraph());
			//Login Out
			LoginTestCase_Old1.nav_Logout();
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	/*==============================================================
	TestScript  	: valEVDCStorageProfilePortlet
	Manual TestCase	: QAT-833-WCP_5231_TC_1.0_EVDC Overview page- Storage
	Description		: Verify that the Storage reporting portlet is displayed stacked tiers instead of carousal 
	Author 			: Vivek Kumar
	Creation Date 	: 06/22/2016
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=4)
	public void valEVDCStorageProfilePortlet()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_OverviewPF);	
		PageFactory.initElements(driver, EVDC_StorageProfile);	
		
		int iCirleSize;
		WebElement wToolTipText;
		String sStorageProfileToolTip;
		
		FrameworkUtil.sTestCaseName = "Kyle-valEVDCStorageProfilePortlet";
		FrameworkUtil.sManualTestCaseName = "QAT-833-WCP_5231_TC_1.0_EVDC Overview page- Storage";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
	
		sStorageProfileToolTip=(String) FrameworkUtil.dictDynamicPagePactory.get("NAV.EVDC.STORAGE.PORTLET.TOOLTIP.MESSAGE");
							
		try {
			//Login to Navigator using QaAuto
			LoginTestCase_Old1.LoginAsQaautoAUser();
			
			//Navigate to EVDC-VM page
			WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
			
			//Getting the total count of circle
			//List<WebElement> lstStorageProfileCircle  = driver.findElements(By.xpath(EVDC_StorageProfile.getNav_StorageProfileCircle()));
			iCirleSize= EVDC_StorageProfile.getNav_StorageProfileCircle().size();
			if(iCirleSize<9)
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verifying Max number of tiers dispayed is 8 ", "pass", "Max number of tiers displayed "+iCirleSize);
				//Capturing the tooltip message for each circle available at Storage portlet
				for(WebElement toolTipElement : EVDC_StorageProfile.getNav_StorageProfileCircle())
				{
					WebObjectUtil.clickElement(toolTipElement);
					WebObjectUtil.explicitWait(2);
					wToolTipText=WebObjectUtil.getActiveElementasWebElement(sStorageProfileToolTip);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "ToolTip Message on EVDC- Storage portlet ", "pass",wToolTipText.getText());
				}
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verifying Max number of tiers dispayed is 8 ", "fail", "Max number of tiers displayed "+iCirleSize);
			}
			//Login Out
			LoginTestCase_Old1.nav_Logout();
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
		
		
	}
	
	
	@AfterMethod
	public static void afterEachMethod(){
		FrameworkUtil.updateTestCaseStatusinResult();
		FrameworkUtil.sTestExecutionStatus = true;
		
	}

}
