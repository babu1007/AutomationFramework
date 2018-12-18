package com.whs.navigator.testcases.zathras;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.commonUtil.WebTableUtil;
import com.whs.navigator.pagefactory.CommonPageFactory;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.EVDC_StorageProfilePageFactory;
import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.TicketPageFactory;
import com.whs.navigator.pagefactory.ZathrasPageFactory_Sukur;
import com.whs.navigator.testcases.AdminTestCase;
import com.whs.navigator.testcases.EVDC_StorageProfileTestCase;
import com.whs.navigator.testcases.LoginTestCase;
import com.whs.navigator.testcases.TicketTestCase;
import com.whs.navigator.testcases.valen.ValenTestCase_SLP;
import com.whs.navigator.testcases.TicketTestCase;

public class CopyOfZathrasTestCase_Sukur {
	
	public static HomePageFactory_old Home = new HomePageFactory_old();
	public static ZathrasPageFactory_Sukur Zathra = new ZathrasPageFactory_Sukur();
	public static CommonPageFactory Common = new CommonPageFactory();
	public static EVDC_OverviewPageFactory EVDC_OverviewPF= new EVDC_OverviewPageFactory();
	public static EVDC_StorageProfilePageFactory EVDC_Storage  = new EVDC_StorageProfilePageFactory();
	public static TicketPageFactory Ticket = new TicketPageFactory();
	
	/*==============================================================
	TestScript  	: editstoragethresholdRoleAddastorageThresholddefaultchangequota
	Manual TestCase	: QAT-1809
	Description		: Verify user with 'edit storage threshold' role is able to add a storage 
					  threshold from portal. When a threshold is set to more than the threshold for Provider VDC in vcd, 
					  verify user is able to change the quota successfully for any storage policy. 
	Author 			: Sukur Babu
	Creation Date 	: 08/22/2016
	Pre-Requisites	:
	Revision History:
	==============================================================*/
		@Test(priority=1)
		public void Delete()
		{
		
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, Home);
			PageFactory.initElements(driver, Zathra);
			PageFactory.initElements(driver, Common);
			PageFactory.initElements(driver, EVDC_OverviewPF);
			PageFactory.initElements(driver,EVDC_Storage);
			PageFactory.initElements(driver, Ticket);
			try {
				WebElement wSaveIcon,wEidtIcon,wDeleteIcon,wProviderSVDCThresholdInput,wDataStoreThresholdInput;
				String ProviderVDCThreshold,DataStoreThreshold,sExpSuccessMsg,sActSuccessMsg;
				String sQuotaFailMsg,sNothingHasChanged;
				int iQuota;
				String sQuota,sRowText;
				String sRowTextArr[];
				FrameworkUtil.sTestCaseName = "ElasticStorageAdmin-Delete";
				FrameworkUtil.sManualTestCaseName="QAT-?";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				WebElement wTableRow;
				List<WebElement> wTables;
				String sDeleteMsg="Successfully deleted threshold :";
				//Login to Navigator
				LoginTestCase.LoginAsARoleAUser();
				//If Add threshold link is visible then continue executing remaining script
				if(navigateTOElasticStorageAdminAndVerifyAddThresholdLink()==true)
				{
					wTables=Zathra.getNav_AddThresholdTable().findElements(By.tagName("table"));
					if(wTables.size()<=1)
					{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Add Threshold Table", "Get Row Count from Add Threshold table", "warning", "Rows not found");
					}else{
					for(int i=1;i<=wTables.size();i++)
					{
						wTableRow = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGETHRESHOLD.TABLE", "PARAMETER_ROWNUMBER", Integer.toString(i));
						sRowText=wTableRow.getText();
						System.out.println(sRowText);
						sRowTextArr=sRowText.split("\n");
						System.out.println("Location  "+sRowTextArr[0]+"And Tier Name   "+sRowTextArr[1]);
						sDeleteMsg=sDeleteMsg+" "+sRowTextArr[0]+" - "+sRowTextArr[1];
						wTableRow.click();
						wDeleteIcon=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGETHRESHOLD.DELETE", "PARAMETER_ROWNUMBER", Integer.toString(i));
						if(wDeleteIcon==null)
						{
							FrameworkUtil.updateCustomResultBasedOnStatus(false, "Delete buton is not available in row "+i);
						}
						else
						{
							wDeleteIcon.click();
							if(Zathra.getNav_DeleteThresholdPopup().isDisplayed())
							{
								FrameworkUtil.updateCustomResultBasedOnStatus(true, "Delete pop up displayed for the delete button in row "+i);	
								WebObjectUtil.clickElement(Zathra.getNav_DeleteThresholdPopupOKButton());
								if(Common.getNav_UsrFeedBack().getText().equalsIgnoreCase(sDeleteMsg))
									FrameworkUtil.updateCustomResultBasedOnStatus(true, "Expected feed back is same expected and feed back is "+Common.getNav_UsrFeedBack().getText());
								else
									FrameworkUtil.updateCustomResultBasedOnStatus(false, "Expected feed back is not same expected and feed back is "+Common.getNav_UsrFeedBack().getText());
							}else
							{
								FrameworkUtil.updateCustomResultBasedOnStatus(false, "Delete pop up not displayed for the delete button in row "+i);
							}
						}
					}
					/**/
					
				}
				}
				
			} catch (Exception e) {
				LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
			
			}
			
		}
		public static boolean navigateTOElasticStorageAdminAndVerifyAddThresholdLink()
		{
			WebDriver driver = WebDriverUtil.getDriver();
			String sElasticStrageAdminURL = (String) FrameworkUtil.dictPropertyData.get("NAV.ELASTIC.STORAGE.ADMIN.URL");
			driver.get(sElasticStrageAdminURL);
			
			return WebObjectUtil.verifyElementPresent(Zathra.getNav_AddaStorageThresholdLink());
		}
		//update each @test result in custom result file
		@AfterMethod
		public static void afterEachMethod(){
			FrameworkUtil.updateTestCaseStatusinResult();
			if(WebDriverUtil.browser.equalsIgnoreCase("ie")){
				WebDriverUtil.quitWebDriver();
			}
}
}