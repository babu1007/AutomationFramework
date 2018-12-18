package com.whs.navigator.testcases.valen;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.CommonPageFactory;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.EVDC_StorageProfilePageFactory;
import com.whs.navigator.pagefactory.PhysicalServicesPageFactory;
import com.whs.navigator.testcases.EVDC_StorageProfileTestCase;
import com.whs.navigator.testcases.LoginTestCase_Old1;


public class ValenTestCase_SLP {
	
	
			 public static EVDC_OverviewPageFactory EVDC_Overview = new EVDC_OverviewPageFactory();
			 public static EVDC_StorageProfilePageFactory EVDC_Storage  = new EVDC_StorageProfilePageFactory();
			 public static CommonPageFactory Common = new CommonPageFactory();
			
			 
			/*==============================================================
			TestScript  	: verifyStoragePDFandCSVforkirkjUser
			Manual TestCase	: [QAT-1653] WCP_5452_TC_1.7_Elastic Storage->Storage tier-> Reports
	        Description		: Verify that CSV and PDF reports are displaying correctly with all the information in the storage Policies page
			Author 			: QAA03
			Creation Date 	: 08/08/2016
			Release Name    : Valen
			Pre-Requisites	: 
			Revision History:
		  ==============================================================*/
			
			@Test(priority=31)
			public void verifyStoragePDFandCSVforkirkjUser()
			{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver,Common);
				    
									
				try {
					FrameworkUtil.sTestCaseName = "Storage-verifyStoragePDFandCSVforkirkjUser";
					FrameworkUtil.sManualTestCaseName="[QAT-1653] WCP_5452_TC_1.7_Elastic Storage->Storage tier-> Reports";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
															
				    // Login to navigator with "racestop.user" user
					//LoginTestCase.LoginAsRaceStopUser();
					LoginTestCase_Old1.LoginAsKirkjUser();
					
					//Navigating to Storage-Profile Page
					EVDC_StorageProfileTestCase.navigateToStorageTierPage();
					
					//Verifying the PDF and CSV icons
			    	 WebObjectUtil.verifyElementPresent(Common.getNav_PdfIcon());
			    	 WebObjectUtil.verifyElementPresent(Common.getNav_CsvIcon());
		                      			
					// Logout from Navigator
					LoginTestCase_Old1.nav_Logout();
				
				   } catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyStoragePDFandCSVforkirkjUser", "warn", "catch block:" +e.getMessage());
				}
			}
			
			/*==============================================================
			TestScript  	: verifyAllocatedandQuotainStorageTier
			Manual TestCase	: [QAT-1652] WCP_5452_TC_1.6_Elastic Storage->Storage tier- Allocated, Quota, Rate & Commit values
	        Description		: Verify the Allocated, Quota, Rate & Commit values displayed correctly in all the storage tiers. 
			Author 			: QAA03
			Creation Date 	: 08/09/2016
			Release Name    : Valen
			Pre-Requisites	: 
			Revision History: Step 1 to Step 5 automated
		  ==============================================================*/
			
			@Test(priority=32)
			public void verifyAllocatedandQuotainStorageTier()
			{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver,EVDC_Storage);
							
				try {
					FrameworkUtil.sTestCaseName = "Storage-verifyAllocatedandQuotainStorageTier";
					FrameworkUtil.sManualTestCaseName="[QAT-1652] WCP_5452_TC_1.6_Elastic Storage->Storage tier- Allocated, Quota, Rate & Commit values";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
															
					// Login to navigator with "racestop.user" user
					//LoginTestCase.LoginAsRaceStopUser();
					LoginTestCase_Old1.LoginAsKirkjUser();
					
					//Navigating to Storage-Profile Page
					EVDC_StorageProfileTestCase.navigateToStorageTierPage();
					
					WebObjectUtil.explicitWait(5);
					
					//Verifying the allocated value in the tiers
					
					List<WebElement> wStorageAllocatedvalue = EVDC_Storage.getNav_StorageProfileAllocatedValueSVG();
					
					for(WebElement wStorageAllocated : wStorageAllocatedvalue)
						WebObjectUtil.verifyElementPresent(wStorageAllocated);
					
					//Verifying the quota value in the tiers
					
                    List<WebElement> wStorageQuotavalue = EVDC_Storage.getNav_StorageProfile_QuotavalueSVG();
					
					for(WebElement wStorageQuota : wStorageAllocatedvalue)
						WebObjectUtil.verifyElementPresent(wStorageQuota);
					
					//Verifying the quota box in the tiers
					
                   List<WebElement> wStoragesQuotaBox = EVDC_Storage.getNav_StorageProfile_QuotaBox();
					
					for(WebElement wStorageQuotaBox : wStoragesQuotaBox)
						WebObjectUtil.verifyElementPresent(wStorageQuotaBox);
					
					//Verifying the allocated box in the tiers
                      List<WebElement> wStoragesAllocatedBox = EVDC_Storage.getNav_StorageProfile_AllocatedBox();
					
					for(WebElement wStorageAllocatedBox : wStoragesAllocatedBox)
						WebObjectUtil.verifyElementPresent(wStorageAllocatedBox);    
		                      			
					// Logout from Navigator
					LoginTestCase_Old1.nav_Logout();
				
				   } catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAllocatedandQuotainStorageTier", "warn", "catch block:" +e.getMessage());
				}
			}
			
			/*==============================================================
			TestScript  	: verifyQuotaButtonNotavaialbleforNonStorageTier
			Manual TestCase	: [QAT-1651] WCP_5452_TC_1.5_Elastic Storage->Non storage tier
	        Description		: Verify that Quota button not available in the non-storage tiers
			Author 			: QAA03
			Creation Date 	: 08/09/2016
			Release Name    : Valen
			Pre-Requisites	: 
			Revision History: Step 1 to Step 4 automated
		  ==============================================================*/
			
			@Test(priority=33)
			public void verifyQuotaButtonNotavaialbleforNonStorageTier()
			{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver,EVDC_Storage);
					String sStorageTier=null,sStorageName=null;
					String sStorageNames [];
					int iQuotaIndex=0;
									
				try {
					FrameworkUtil.sTestCaseName ="Storage-verifyQuotaButtonNotavaialbleforNonStorageTier";
					FrameworkUtil.sManualTestCaseName="[QAT-1651] WCP_5452_TC_1.5_Elastic Storage->Non storage tier";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					
					sStorageTier = (String)FrameworkUtil.dictPropertyData.get("NAV.STORAGEPROFILE.STORAGETIER.NAMES");
			
				    // Login to navigator with entity04a user
					LoginTestCase_Old1.LoginAsEntity04User();
					
					//Navigating to Storage-Profile Page
					EVDC_StorageProfileTestCase.navigateToStorageTierPage();
					
					WebObjectUtil.explicitWait(5);
					
					//Splitting the Storage Tier Names
					sStorageNames = sStorageTier.split("##");
					
					//Getting the Storage tier names list
					List<WebElement> wStorageTierNames = EVDC_Storage.getNav_StorageProfile_TierNames();
					
					//Verifying the required storage name from list and checking quota button not present for that tier	
					for(WebElement wStorageName : wStorageTierNames)
					{
						sStorageName = wStorageName.getText();
						
						if(sStorageName.equalsIgnoreCase(sStorageNames[0].trim()) || sStorageName.equalsIgnoreCase(sStorageNames[1].trim()))
						{
						   	WebElement wQuota = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTABUTTON", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
						   	FrameworkUtil.updateCustomResultBasedOnStatus(wQuota==null, "Quota Button not present for - "+sStorageName+" Storage Tier");
						}
						iQuotaIndex++;
					}					
				
					// Logout from Navigator
					LoginTestCase_Old1.nav_Logout();
				
				   } catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyQuotaButtonNotavaialbleforNonStorageTier", "warn", "catch block:" +e.getMessage());
				}
			}
			
			/*==============================================================
			TestScript  	: verifyCommittedValueinRedForStorageTier
			Manual TestCase	: [QAT-1736] WCP_6021, 5453_TC_1.0_Elastic storage_Commit shows in red when allocation is greater
	        Description		: When a user increases allocation greater than the commit value, commit value will show in red on the dial graph for that tier.
			Author 			: QAA03
			Creation Date 	: 08/10/2016
			Release Name    : Valen
			Pre-Requisites	: 
			Revision History: 
		  ==============================================================*/
			
			@Test(priority=34)
			public void verifyCommittedValueinRedForStorageTier()
			{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver,EVDC_Storage);
					String sStorageName=null;
									
				try {
					FrameworkUtil.sTestCaseName ="Storage-verifyCommittedValueinRedForStorageTier";
					FrameworkUtil.sManualTestCaseName="[QAT-1736] WCP_6021, 5453_TC_1.0_Elastic storage_Commit shows in red when allocation is greater";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					
					sStorageName = (String)FrameworkUtil.dictPropertyData.get("NAV.STORAGEPROFILE.NAME.PERFORMANCETIER");
			
				    // Login to navigator with  user
					LoginTestCase_Old1.LoginAsKirkjUser();
					
					//Navigating to Storage-Profile Page
					EVDC_StorageProfileTestCase.navigateToStorageTierPage();
					
					WebObjectUtil.explicitWait(5);
										
					verifyCommittedValueinRedForStorage(sStorageName);
					
					// Logout from Navigator
					LoginTestCase_Old1.nav_Logout();
				
				   } catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyCommittedValueinRedForStorageTier", "warn", "catch block:" +e.getMessage());
				}
			}
			
			/*==============================================================
			TestScript  	: verifyBydecreasingQuotawhereAllocationisHigher
			Manual TestCase	: [QAT-1731][1745] WCP_5453_TC_2.0.1_Change quota for existing storage tier_Decrease quota_allocation is higher
	        Description		: Confirm a user is able to decrease the quota to either commit value or allocated value whichever is higher
			Author 			: QAA03
			Creation Date 	: 08/17/2016
			Release Name    : Valen
			Pre-Requisites	: 
			Revision History: 
		  ==============================================================*/
			
			@Test(priority=35)
			public void verifyBydecreasingQuotawhereAllocationisHigher()
			{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver,EVDC_Storage);
					PageFactory.initElements(driver,Common);
					String sStorageName=null,sQuotavalue=null,sQuotaEditvalue=null;
					int iQuotaIndex=0,iQuotavalue=0;				
				try {
					FrameworkUtil.sTestCaseName ="Storage-verifyBydecreasingQuotawhereAllocationisHigher";
					FrameworkUtil.sManualTestCaseName="[QAT-1731][1745] WCP_5453_TC_2.0.1_Change quota for existing storage tier_Decrease quota_allocation is higher";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					
					sStorageName = (String)FrameworkUtil.dictPropertyData.get("NAV.STORAGEPROFILE.NAME.PERFORMANCETIER");
			
				    // Login to navigator with  user
					LoginTestCase_Old1.LoginAsKirkjUser();
					
					//Navigating to Storage-Profile Page
					EVDC_StorageProfileTestCase.navigateToStorageTierPage();
					
					WebObjectUtil.explicitWait(5);
					
					//Verifying quota button exist for the storage tiers
					verifyQuotaButtonForStorageTiers();
					
					//Getting the index of storage tier
					iQuotaIndex=getIndexForStorageTier(sStorageName);
					
					//Verifying Committed value in Red Color for particular Storage Tier
					verifyCommittedValueinRedForStorage(sStorageName);
					
					//Verifying the default value is quota value in the quota input field
					verifyDefaultValueinInputQuotaField(sStorageName);
					
					WebElement wQuotaMaxValue = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.MAXQUOTAVALUE", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
					WebObjectUtil.verifyElementPresent(wQuotaMaxValue);
					
					WebElement wQuotaInputField = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTAINPUTFIELD", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
					sQuotavalue=wQuotaInputField.getAttribute("value");
					
					validateQuotaDecreasingInputfieldvalue(iQuotaIndex, sStorageName);
					
					//Verify multiple indicators are not present by increasing and decreasing quota input values
					verifyMultipleIndicatorsNotpresentafterChangingQuotaforStorageTier(iQuotaIndex, sStorageName);
					
					WebObjectUtil.explicitWait(10);
					
										
					iQuotavalue = Integer.parseInt(sQuotavalue);
					iQuotavalue = iQuotavalue-100;
					sQuotaEditvalue = String.valueOf(iQuotavalue);
					wQuotaInputField.clear();
					wQuotaInputField.sendKeys(sQuotaEditvalue);
					
					WebElement wQuotaSavebutton = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTA.SAVEBUTTON", "PARAMETER_TIERNUMBER", ""+iQuotaIndex); 
					WebObjectUtil.clickElement(wQuotaSavebutton);
					
					//Verifying all fields in quota agreement popup window
					verifyallFieldsinQuotaPopupWindow();
					
					WebObjectUtil.clickElement(EVDC_Storage.getNav_QuotaPopupWindow_AgreeCheckBox());
					WebObjectUtil.clickElement(EVDC_Storage.getNav_QuotaPopupWindow_OkButton());
					
					WebObjectUtil.explicitWait(15);
					WebObjectUtil.verifyElementPresent(Common.getNav_UsrFeedBack());
					
					WebDriverUtil.refreshBrowser();
					
					WebElement wQuotaBlue = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTABLUECOLOR", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
					WebObjectUtil.verifyElementPresent(wQuotaBlue);
					
					// Revert back the quota value editted to original value for storage tier
					revertBackQuotaToDefalutValue(iQuotaIndex,sStorageName,sQuotavalue);
					
					// Logout from Navigator
					LoginTestCase_Old1.nav_Logout();
				
				
				   } catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyBydecreasingQuotawhereAllocationisHigher", "warn", "catch block:" +e.getMessage());
				}
			}
			
			/*==============================================================
			TestScript  	: verifyGraphindicatorByChangingQuotavalue
			Manual TestCase	: [QAT-1740] WCP_6047_Elastic Storage_Key in quota value to increase or decrease
	        Description		: Verify the quota indicator on dial graph moves up and down when user keys in value for the desired quota
			Author 			: QAA03
			Creation Date 	: 08/17/2016
			Release Name    : Valen
			Pre-Requisites	: 
			Revision History: 
		  ==============================================================*/
			
			@Test(priority=36)
			public void verifyGraphindicatorByChangingQuotavalue()
			{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver,EVDC_Storage);
					String sStorageName=null;
					int iQuotaIndex=0;				
				try {
					FrameworkUtil.sTestCaseName ="Storage-verifyGraphindicatorByChangingQuotavalue";
					FrameworkUtil.sManualTestCaseName="[QAT-1740] WCP_6047_Elastic Storage_Key in quota value to increase or decrease";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					
					sStorageName = (String)FrameworkUtil.dictPropertyData.get("NAV.STORAGEPROFILE.NAME.PERFORMANCETIER");
			
				    // Login to navigator with  user
					LoginTestCase_Old1.LoginAsKirkjUser();
					
					//Navigating to Storage-Profile Page
					EVDC_StorageProfileTestCase.navigateToStorageTierPage();
					
					WebObjectUtil.explicitWait(5);
					
					//Getting the index of storage tier
					iQuotaIndex=getIndexForStorageTier(sStorageName);
									
					//Verifying the default value is quota value in the quota input field
					verifyDefaultValueinInputQuotaField(sStorageName);
					
					//Verify indicator moves up by increasing quota input and moves down by decreasing quota input value
					validateQuotaGraphIndicatorChanginginputfieldvalue(iQuotaIndex,sStorageName);
					
					// Logout from Navigator
					LoginTestCase_Old1.nav_Logout();
				
				   } catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyGraphindicatorByChangingQuotavalue", "warn", "catch block:" +e.getMessage());
				}
			}
			
			/*==============================================================
			TestScript  	: verifyErrorMsgByIncreasingQuotaBeyondMaxvalue
			Manual TestCase	: [QAT-1742] WCP_5453_TC_2.0.3_Elastic Storage_Key in quota value to increase_error message
	        Description		: When user keys in a value that is greater than max allowed quota, verify the error message.
			Author 			: QAA03
			Creation Date 	: 08/16/2016
			Release Name    : Valen
			Pre-Requisites	: 
			Revision History: 
		  ==============================================================*/
			
			@Test(priority=37)
			public void verifyErrorMsgByIncreasingQuotaBeyondMaxvalue()
			{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver,EVDC_Storage);
					String sStorageName=null;
					int iQuotaIndex=0;				
				try {
					FrameworkUtil.sTestCaseName ="Storage-verifyErrorMsgByIncreasingQuotaBeyondMaxvalue";
					FrameworkUtil.sManualTestCaseName="[QAT-1742] WCP_5453_TC_2.0.3_Elastic Storage_Key in quota value to increase_error message";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					
					sStorageName = (String)FrameworkUtil.dictPropertyData.get("NAV.STORAGEPROFILE.NAME.PERFORMANCETIER");
			
				    // Login to navigator with  user
					LoginTestCase_Old1.LoginAsKirkjUser();
					
					//Navigating to Storage-Profile Page
					EVDC_StorageProfileTestCase.navigateToStorageTierPage();
					
					WebObjectUtil.explicitWait(5);
					
					//Getting the index of storage tier
					iQuotaIndex=getIndexForStorageTier(sStorageName);
									
					//Verifying the default value is quota value in the quota input field
					verifyDefaultValueinInputQuotaField(sStorageName);
					
					// Validate Error message by increasing quota beyond max value
					validateQuotaIncreasingInputfieldvalue(iQuotaIndex,sStorageName);
					
					// Logout from Navigator
					LoginTestCase_Old1.nav_Logout();
				
				   } catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyErrorMsgByIncreasingQuotaBeyondMaxvalue", "warn", "catch block:" +e.getMessage());
				}
			}
			
			/*==============================================================
			TestScript  	: verifyErrorMsgByDecreasingQuotaBeyondMinvalue
			Manual TestCase	: [QAT-1744] WCP_5453_TC_2.0.4_Elastic Storage_Key in quota value to decrease_error message
	        Description		: When user keys in a value that is less than min allowed quota, verify the error message when hover over edit text box..
			Author 			: QAA03
			Creation Date 	: 08/16/2016
			Release Name    : Valen
			Pre-Requisites	: 
			Revision History: 
		  ==============================================================*/
			
			@Test(priority=38)
			public void verifyErrorMsgByDecreasingQuotaBeyondMinvalue()
			{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver,EVDC_Storage);
					String sStorageName=null;
					int iQuotaIndex=0;				
				try {
					FrameworkUtil.sTestCaseName ="Storage-verifyErrorMsgByDecreasingQuotaBeyondMinvalue";
					FrameworkUtil.sManualTestCaseName="[QAT-1744] WCP_5453_TC_2.0.4_Elastic Storage_Key in quota value to decrease_error message";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					
					sStorageName = (String)FrameworkUtil.dictPropertyData.get("NAV.STORAGEPROFILE.NAME.PERFORMANCETIER");
			
				    // Login to navigator with "Kirkj" user
					LoginTestCase_Old1.LoginAsKirkjUser();
					
					//Navigating to Storage-Profile Page
					EVDC_StorageProfileTestCase.navigateToStorageTierPage();
					
					WebObjectUtil.explicitWait(5);
					
					//Getting the index of storage tier
					iQuotaIndex=getIndexForStorageTier(sStorageName);
									
					//Verifying the default value is quota value in the quota input field
					verifyDefaultValueinInputQuotaField(sStorageName);
					
					// Validate Error message by decreasing quota beyond min value
					validateQuotaDecreasingInputfieldvalue(iQuotaIndex,sStorageName);
					
					// Logout from Navigator
					LoginTestCase_Old1.nav_Logout();
				
				   } catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyErrorMsgByDecreasingQuotaBeyondMinvalue", "warn", "catch block:" +e.getMessage());
				}
			}
			/*==============================================================
			TestScript  	: verifyBydecresingQuotawhereCommitisHigher
			Manual TestCase	: [QAT-1734] WCP_5453_TC_2.0.2_Change quota for existing storage tier_Decrease quota_commit is higher
	        Description		: Confirm a user is able to decrease the quota to either commit value or allocated value whichever is higher
			Author 			: QAA03
			Creation Date 	: 08/18/2016
			Release Name    : Valen
			Pre-Requisites	: 
			Revision History: 
		  ==============================================================*/
			
			@Test(priority=39)
			public void verifyBydecresingQuotawhereCommitisHigher()
			{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver,EVDC_Storage);
					PageFactory.initElements(driver,Common);
					String sStorageName=null,sQuotavalue=null,sQuotaEditvalue=null;
					int iQuotaIndex=0,iQuotavalue=0;
					String sMinQuota[];
					
				try {
					FrameworkUtil.sTestCaseName ="Storage-verifyBydecresingQuotawhereCommitisHigher";
					FrameworkUtil.sManualTestCaseName="[QAT-1734] WCP_5453_TC_2.0.2_Change quota for existing storage tier_Decrease quota_commit is higher";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					
					sStorageName = (String)FrameworkUtil.dictPropertyData.get("NAV.STORAGEPROFILE.NAME.CAPACITYTIER");
			
				    // Login to navigator with Kirkj user
					LoginTestCase_Old1.LoginAsKirkjUser();
					
					//Navigating to Storage-Profile Page
					EVDC_StorageProfileTestCase.navigateToStorageTierPage();
					
					WebObjectUtil.explicitWait(5);
					
					//Verifying quota button exist for the storage tiers
					verifyQuotaButtonForStorageTiers();
					
					//Getting the index of storage tier
					iQuotaIndex=getIndexForStorageTier(sStorageName);
					
					//Verifying Commited, Allocation and Quota value for particular Storage Tier
					verifyAllValuesForStorage(sStorageName);
					
					//Verifying the default value is quota value in the quota input field
					verifyDefaultValueinInputQuotaField(sStorageName);
					
					WebElement wQuotaMaxValue = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.MAXQUOTAVALUE", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
					WebObjectUtil.verifyElementPresent(wQuotaMaxValue);
					
					WebElement wQuotaInputField = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTAINPUTFIELD", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
					sQuotavalue=wQuotaInputField.getAttribute("value");
					
					validateQuotaDecreasingInputfieldvalue(iQuotaIndex, sStorageName);
					
					//Verify multiple indicators are not present by increasing and decreasing quota input values
					verifyMultipleIndicatorsNotpresentafterChangingQuotaforStorageTier(iQuotaIndex, sStorageName);
					
					WebObjectUtil.explicitWait(5);
											
					iQuotavalue = Integer.parseInt(sQuotavalue);
					iQuotavalue = iQuotavalue-100;
					sQuotaEditvalue = String.valueOf(iQuotavalue);
					wQuotaInputField.clear();
					wQuotaInputField.sendKeys(sQuotaEditvalue);
					
					
					WebElement wQuotaSavebutton = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTA.SAVEBUTTON", "PARAMETER_TIERNUMBER", ""+iQuotaIndex); 
					WebObjectUtil.clickElement(wQuotaSavebutton);
					
					//Verifying all fields in quota agreement popup window
					verifyallFieldsinQuotaPopupWindow();
					
					WebObjectUtil.clickElement(EVDC_Storage.getNav_QuotaPopupWindow_AgreeCheckBox());
					WebObjectUtil.clickElement(EVDC_Storage.getNav_QuotaPopupWindow_OkButton());
					
					WebObjectUtil.explicitWait(15);
					WebObjectUtil.verifyElementPresent(Common.getNav_UsrFeedBack());
					
					WebDriverUtil.refreshBrowser();
					
					WebElement wQuotaBlue = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTABLUECOLOR", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
					WebObjectUtil.verifyElementPresent(wQuotaBlue);
					
					// Revert back the quota value editted to original value for storage tier
					revertBackQuotaToDefalutValue(iQuotaIndex, sStorageName, sQuotavalue);
					
					// Logout from Navigator
					LoginTestCase_Old1.nav_Logout();
				
				   } catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyBydecresingQuotawhereCommitisHigher", "warn", "catch block:" +e.getMessage());
				}
			}
			
			/*==============================================================
			TestScript  	: verifyByincreasingQuotaforanyStorageTier
			Manual TestCase	: [QAT-1729][1719][1728] WCP_5453_TC_2.0.0_Change quota for existing storage tier_Increase quota
	        Description		: 
			Author 			: QAA03
			Creation Date 	: 08/22/2016
			Release Name    : Valen
			Pre-Requisites	: 
			Revision History: 
		  ==============================================================*/
			
			@Test(priority=40)
			public void verifyByincreasingQuotaforanyStorageTier()
			{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver,EVDC_Storage);
					PageFactory.initElements(driver,Common);
					String sStorageName=null,sQuotaMaxvalue=null,sQuotavalue=null;
					int iQuotaIndex=0;				
				try {
					FrameworkUtil.sTestCaseName ="Storage-verifyByincreasingQuotaforanyStorageTier";
					FrameworkUtil.sManualTestCaseName="[QAT-1729][1719][1728] WCP_5453_TC_2.0.0_Change quota for existing storage tier_Increase quota";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					
					sStorageName = (String)FrameworkUtil.dictPropertyData.get("NAV.STORAGEPROFILE.NAME.HIGHPERFORMANCETIER");
			
				    // Login to navigator with "tstmax02lastt" user
					LoginTestCase_Old1.LoginAsTstMax02lasttUser();
										
					validateQuotaForanyStorageTier(sStorageName);
					
					// Logout from Navigator
					LoginTestCase_Old1.nav_Logout();
					
					// Login to navigator with "tstmax02last02t" user
					LoginTestCase_Old1.LoginAsTstmax02last02tUser();
										
					validateQuotaForanyStorageTier(sStorageName);
					
					// Logout from Navigator
					LoginTestCase_Old1.nav_Logout();
				
				   } catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyByincreasingQuotaforanyStorageTier", "warn", "catch block:" +e.getMessage());
				}
			}
			
			/*==============================================================
			TestScript  	: verifyLearnMoreLinkForStorageTier
			Manual TestCase	: [QAT-1721] WCP_5453, 6032_TC_1.0_Elastic Storage->storage tiers -> Learn more info
	        Description		: Verify that Learn more information is displaying correctly in existing storage tiers
			Author 			: QAA03
			Creation Date 	: 09/01/2016
			Release Name    : Valen
			Pre-Requisites	: 
			Revision History: 
		  ==============================================================*/
			
			@Test(priority=41)
			public void verifyLearnMoreLinkForStorageTier()
			{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver,EVDC_Storage);
					PageFactory.initElements(driver,Common);
					String sStorageName=null,sQuotaMaxvalue=null,sQuotavalue=null;
					int iQuotaIndex=0;				
				try {
					FrameworkUtil.sTestCaseName ="Storage-verifyLearnMoreLinkForStorageTier";
					FrameworkUtil.sManualTestCaseName="[EVDC-StorageProfile-QAT-1721-Valen]- WCP_5453, 6032_TC_1.0_Elastic Storage->storage tiers -> Learn more info";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					
					sStorageName = (String)FrameworkUtil.dictPropertyData.get("NAV.STORAGEPROFILE.NAME.HIGHPERFORMANCETIER");
			
				    // Login to navigator with "tstmax02lastt" user
					LoginTestCase_Old1.LoginAsTstMax02lasttUser();
					
					//Navigating to Storage-Profile Page
					EVDC_StorageProfileTestCase.navigateToStorageTierPage();
					
					WebObjectUtil.explicitWait(5);
					
					//Verifying quota button exist for the storage tiers
					verifyQuotaButtonForStorageTiers();
					
					//Getting the index of storage tier
					iQuotaIndex=getIndexForStorageTier(sStorageName);
					 
					//Verifying learn more link by clicking quota button
					verifyLearnMoreLinkQuota(iQuotaIndex,sStorageName);
					
					// Logout from Navigator
					LoginTestCase_Old1.nav_Logout();
				
				   } catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyLearnMoreLinkForStorageTier", "warn", "catch block:" +e.getMessage());
				}
			}
			
			
			/*==============================================================
			TestScript  	: verifyMultipleIndicatorsNotPresentByChangingQuotavalue
			Manual TestCase	: [QAT-1745] WCP_5453_TC_1.0_Change quota_key in desired quota
	        Description		: Confirm user is able to key in desired quota value after highlighting the current value. Verify the multiple indicators are not present.
			Author 			: QAA03
			Creation Date 	: 08/22/2016
			Release Name    : Valen
			Pre-Requisites	: 
			Revision History: 
		  ==============================================================
			
			@Test(priority=41)
			public void verifyMultipleIndicatorsNotPresentByChangingQuotavalue()
			{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver,EVDC_Storage);
					PageFactory.initElements(driver,Common);
					String sStorageName=null,sQuotavalue=null,sQuotaEditvalue=null;
					int iQuotaIndex=0,iQuotavalue=0;				
				try {
					FrameworkUtil.sTestCaseName ="Storage-verifyMultipleIndicatorsNotPresentByChangingQuotavalue";
					FrameworkUtil.sManualTestCaseName="[QAT-1745] WCP_5453_TC_1.0_Change quota_key in desired quota";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					
					sStorageName = (String)FrameworkUtil.dictPropertyData.get("NAV.STORAGEPROFILE.NAME.PERFORMANCETIER");
			
				    // Login to navigator with "kirkj" user
					LoginTestCase.LoginAsKirkjUser();
					
					//Navigating to Storage-Profile Page
					EVDC_StorageProfileTestCase.navigateToStorageTierPage();
					
					WebObjectUtil.explicitWait(5);
					
					//Verifying quota button exist for the storage tiers
					verifyQuotaButtonForStorageTiers();
					
					//Getting the index of storage tier
					iQuotaIndex=getIndexForStorageTier(sStorageName);
					 									
					//Verifying the default value is quota value in the quota input field
					verifyDefaultValueinInputQuotaField(sStorageName);
					
					WebElement wQuotaInputField = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTAINPUTFIELD", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
					sQuotavalue=wQuotaInputField.getAttribute("value");
					
					//Verify multiple indicators are not present by increasing and decreasing quota input values
					verifyMultipleIndicatorsNotpresentafterChangingQuotaforStorageTier(iQuotaIndex,sStorageName);
					
					iQuotavalue = Integer.parseInt(sQuotavalue);
					iQuotavalue = iQuotavalue+200;
					sQuotaEditvalue = String.valueOf(iQuotavalue);
					wQuotaInputField.clear();
					wQuotaInputField.sendKeys(sQuotaEditvalue);
					
					
					WebElement wQuotaSavebutton = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTA.SAVEBUTTON", "PARAMETER_TIERNUMBER", ""+iQuotaIndex); 
					WebObjectUtil.clickElement(wQuotaSavebutton);
					
					//Verifying all fields in quota agreement popup window
					verifyallFieldsinQuotaPopupWindow();
					
					WebObjectUtil.clickElement(EVDC_Storage.getNav_QuotaPopupWindow_AgreeCheckBox());
					WebObjectUtil.clickElement(EVDC_Storage.getNav_QuotaPopupWindow_OkButton());
					
					WebObjectUtil.explicitWait(15);
					WebObjectUtil.verifyElementPresent(Common.getNav_UsrFeedBack());
					
					WebElement wQuotaBlue = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTABLUECOLOR", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
					WebObjectUtil.verifyElementPresent(wQuotaBlue);
					
					revertBackQuotaToDefalutValue(iQuotaIndex, sStorageName, sQuotavalue);
					
					// Logout from Navigator
					LoginTestCase.nav_Logout();
				
				   } catch (Exception e) {
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyMultipleIndicatorsNotPresentByChangingQuotavalue", "warn", "catch block:" +e.getMessage());
				}
			}
			*/
			
			/*====================================================================================================
			Method Name 	: verifyCommittedValueinRedForStorage
			Description		: Verifying Committed value in Red Color for particular Storage Tier
			Author 			: QAA03
			Creation Date 	: 08/10/2016
			Pre-Requisites	: 
			Revision History:
			====================================================================================================*/
			public static void verifyCommittedValueinRedForStorage(String sStorageName)
			{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver,EVDC_Storage);
					String sStorageTier=null;
					int iQuotaIndex=0;
					boolean bFlag=false;
			 try {
				 
				    //Getting the Storage tier names list
					List<WebElement> wStorageTierNames = EVDC_Storage.getNav_StorageProfile_TierNames();
					
					//Verifying the required storage name from list and checking quota button not present for that tier	
					for(WebElement wStorageTier : wStorageTierNames)
					{
						sStorageTier = wStorageTier.getText();
						
						if(sStorageTier.equalsIgnoreCase(sStorageName))
						{
							WebElement wCommittedRed = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.COMMITEDREDCOLOR", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
							WebObjectUtil.verifyElementPresent(wCommittedRed);
														
							WebElement wAllocatedGreen = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.ALLOCATEDGREENCOLOR", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
							WebObjectUtil.verifyElementPresent(wAllocatedGreen);
							
							WebElement wQuotaBlue = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTABLUECOLOR", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
							WebObjectUtil.verifyElementPresent(wQuotaBlue);
							
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Values verified for Storage Tier", "Storage Tier", "pass", " Commited, Allocated, quota values and colors verified for  "+sStorageName);
							bFlag=true;
							break;
						}
						
						iQuotaIndex++;
					}
					
					if(!bFlag)
					{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Storage Tier", "fail", "Storage Tier "+sStorageName+ " is not present");
					}
				    
					
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyCommittedValueinRedForStorage", "warn", "catch block:" +e.getMessage());  
				}
			 
			}
			
			/*====================================================================================================
			Method Name 	: verifyQuotaButtonForStorageTiers
			Description		: Verifying Quota button in the Storage Tiers
			Author 			: QAA03
			Creation Date 	: 08/11/2016
			Pre-Requisites	: 
			Revision History:
			====================================================================================================*/
			public static void verifyQuotaButtonForStorageTiers()
			{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver,EVDC_Storage);
					int iQuotaIndex=0;
                    String sStorageTier;
                    boolean bFlag=false;
			 try {
				 
				    
				//Getting the Storage tier names list
					List<WebElement> wStorageTierNames = EVDC_Storage.getNav_StorageProfile_TierNames();
					
					//Verifying the required storage name from list and checking quota button not present for that tier	
					for(WebElement wStorageTier : wStorageTierNames)
					{
						    sStorageTier = wStorageTier.getText();
							WebElement wQuota = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTABUTTON", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
							if(wQuota!=null)
							{
							WebObjectUtil.verifyElementPresent(wQuota);
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Quota button", "pass", " quota button is verified for  "+sStorageTier+ " ");
							bFlag=true;
							}
							else
							{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Quota button", "warn", "quota button is not present for  "+sStorageTier+ " ");
							}
						iQuotaIndex++;
					}
					if(!bFlag)
					{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Quota Button in Storage Tier", "fail", " Quota button is not present in Storage tiers");
					} 
					
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyQuotaButtonForStorageTiers", "warn", "catch block:" +e.getMessage());  
				}
			 
			}
			
			/*====================================================================================================
			Method Name 	: verifyDefaultValueinInputQuotaField
			Description		: Verifying whether the Quota value is the default value preseent in the input quota field
			Author 			: QAA03
			Creation Date 	: 08/11/2016
			Pre-Requisites	: 
			Revision History:
			====================================================================================================*/
			public static String verifyDefaultValueinInputQuotaField(String sStorageName)
			{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver,EVDC_Storage);
					int iQuotaIndex=0;
					String sStorageTier=null,sQuotavalue=null,sQuotaFieldValue=null;
					boolean bFlag=false,bQuotaValueStatus=false;;
				 
				try{
					
					//Getting the Storage tier names list
					List<WebElement> wStorageTierNames = EVDC_Storage.getNav_StorageProfile_TierNames();
					
					//Verifying the required storage name from list and checking quota button not present for that tier	
					for(WebElement wStorageTier : wStorageTierNames)
					{
						sStorageTier = wStorageTier.getText();
						
						if(sStorageTier.equalsIgnoreCase(sStorageName))
						{
							WebElement wQuotaBlue = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTABLUECOLOR", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
							WebObjectUtil.verifyElementPresent(wQuotaBlue);
							sQuotavalue = wQuotaBlue.getText();
							WebElement wQuotaButton = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTABUTTON", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
							WebObjectUtil.verifyElementPresent(wQuotaButton);
							WebObjectUtil.clickElement(wQuotaButton);
							WebObjectUtil.explicitWait(1);
							
							WebElement wQuotaEditClose = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTAEDIT.CLOSEICON", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
							WebObjectUtil.verifyElementPresent(wQuotaEditClose);
							WebObjectUtil.clickElement(wQuotaEditClose);
							WebObjectUtil.explicitWait(1);
							
							wQuotaButton = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTABUTTON", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
							WebObjectUtil.clickElement(wQuotaButton);
							WebElement wQuotaInputField = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTAINPUTFIELD", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
							WebObjectUtil.verifyElementPresent(wQuotaInputField);
							sQuotaFieldValue = wQuotaInputField.getAttribute("value");
							bQuotaValueStatus=sQuotavalue.contains(sQuotaFieldValue);
							FrameworkUtil.updateCustomResultBasedOnStatus(bQuotaValueStatus, "Default value that is displayed is the existing quota value for "+sStorageTier);
							bFlag=true;
								
								WebElement wQuotaSavebutton = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTA.SAVEBUTTON", "PARAMETER_TIERNUMBER", ""+iQuotaIndex); 
								WebObjectUtil.verifyElementPresent(wQuotaSavebutton);
								break;
							
							
						}
						iQuotaIndex++;
					}
					if(!bFlag)
					{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Quota Button in Storage Tier", "fail", " Quota button is not present in Storage tiers");
					} 
					
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyDefaultValueinInputQuotaField", "warn", "catch block:" +e.getMessage());  
				}
			 return sQuotavalue;
			}
			
			
			/*====================================================================================================
			Method Name 	: verifyallFieldsinQuotaPopupWindow
			Description		: verifying all fields in quota agreement popup window
			Author 			: QAA03
			Creation Date 	: 08/15/2016
			Pre-Requisites	: 
			Revision History:
			====================================================================================================*/
			public static void verifyallFieldsinQuotaPopupWindow()
			{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver,EVDC_Storage);
					PageFactory.initElements(driver,Common);
									 
				try{
					WebObjectUtil.verifyElementPresent(EVDC_Storage.getNav_QuotaPopupWindow_TierName());
					WebObjectUtil.verifyElementPresent(EVDC_Storage.getNav_QuotaPopupWindow_DateRequestedField());
					WebObjectUtil.verifyElementPresent(EVDC_Storage.getNav_QuotaPopupWindow_TotalRequestQuotaField());
					WebObjectUtil.verifyElementPresent(EVDC_Storage.getNav_QuotaPopupWindow_PricePerGBQuotaField());
					WebObjectUtil.verifyElementPresent(EVDC_Storage.getNav_QuotaPopupWindow_AgreeCheckBox());
					WebObjectUtil.verifyElementPresent(EVDC_Storage.getNav_QuotaPopupWindow_OkButton());
					WebObjectUtil.verifyElementPresent(Common.getNav_PopUpCancelButton());
					WebObjectUtil.verifyElementPresent(Common.getNav_DialogCloseIcon());
					//WebObjectUtil.clickElement(Common.getNav_DialogCloseIcon());
					
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyallFieldsinQuotaPopupWindow", "warn", "catch block:" +e.getMessage());  
				}
			 
			}
			
			/*====================================================================================================
			Method Name 	: validateQuotaGraphIndicatorChanginginputfieldvalue	
			Description		: Verify indicator moves up by increasing quota input and moves down by decreasing quota input value
			Author 			: QAA03
			Creation Date 	: 08/16/2016
			Pre-Requisites	: 
			Revision History:
			====================================================================================================*/
			public static void validateQuotaGraphIndicatorChanginginputfieldvalue(int iQuotaIndex,String sStorageTier)
			{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver,EVDC_Storage);
					
					String sQuotaIndvalue=null,sQuotaMinIndvalue=null,sQuotaFieldValue=null,sQuotaMaxIndvalue=null,sQuotaMaxvalue=null,sQuotaMinvalue=null;
					int iQuotaFieldValue=0,iQuotaMinIndvalue=0,iQuotaMaxIndvalue=0,iQuotaIndvalue=0;
					boolean bFlag=false,bQuotaValueStatus=false;
				    String sQuotaIndarray[],sQuotaMaxIndarray[],sQuotaMinIndarray[];
				try{
							
					
						WebElement wQuotaInputField = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTAINPUTFIELD", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
						WebObjectUtil.verifyElementPresent(wQuotaInputField);
						sQuotaFieldValue = wQuotaInputField.getAttribute("value");
						iQuotaFieldValue = Integer.parseInt(sQuotaFieldValue);
						
						WebElement wGraphIndicator = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.POLYGONVALUE", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
						sQuotaIndvalue=wGraphIndicator.getAttribute("transform");
						sQuotaIndarray=sQuotaIndvalue.split(",");
						sQuotaIndvalue=sQuotaIndarray[5].replace(')','0');		
						Double dValue = Double.parseDouble(sQuotaIndvalue);
												
						WebElement wQuotaMaxValue = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.MAXQUOTAVALUE", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
						WebObjectUtil.verifyElementPresent(wQuotaMaxValue);
						sQuotaMaxvalue = wQuotaMaxValue.getText();
						//WebElement wQuotaParentInputField = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.PARENTQUOTAINPUTFIELD", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
						wQuotaInputField.clear();
						wQuotaInputField.sendKeys(sQuotaMaxvalue);
						WebElement wGraphMaxIndicator = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.POLYGONVALUE", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
						sQuotaMaxIndvalue=wGraphMaxIndicator.getAttribute("transform");
						sQuotaMaxIndarray=sQuotaMaxIndvalue.split(",");
						sQuotaMaxIndvalue=sQuotaMaxIndarray[5].replace(')','0');		
						Double dMaxValue = Double.parseDouble(sQuotaMaxIndvalue);
										
						WebElement wQuotaMinValue = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.MINQUOTAVALUE", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
						WebObjectUtil.verifyElementPresent(wQuotaMinValue);
						sQuotaMinvalue = wQuotaMinValue.getText();
						//WebElement wQuotaParentInputField = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.PARENTQUOTAINPUTFIELD", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
						wQuotaInputField.clear();
						wQuotaInputField.sendKeys(sQuotaMinvalue);
						WebElement wGraphMinIndicator = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.POLYGONVALUE", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
						sQuotaMinIndvalue=wGraphMinIndicator.getAttribute("transform");
						sQuotaMinIndarray=sQuotaMinIndvalue.split(",");
						sQuotaMinIndvalue=sQuotaMinIndarray[5].replace(')','0');
						Double dMinValue = Double.parseDouble(sQuotaMinIndvalue);
						
						bQuotaValueStatus = dValue>dMaxValue;
						
						FrameworkUtil.updateCustomResultBasedOnStatus(bQuotaValueStatus, " Graph Indicator verified for "+sStorageTier+ " when Quota value is max value");
						
						bQuotaValueStatus =dValue<dMinValue ;
						
						FrameworkUtil.updateCustomResultBasedOnStatus(bQuotaValueStatus, " Graph Indicator verified for "+sStorageTier+ " when Quota value is min value");
						
												
					
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "validateQuotaGraphIndicatorChanginginputfieldvalue", "warn", "catch block:" +e.getMessage());  
				}
			 
			}
			
			/*====================================================================================================
			Method Name 	: validateQuotaIncreasingInputfieldvalue	
			Description		: Validate Error message by increasing quota beyond max value
			Author 			: QAA03
			Creation Date 	: 08/16/2016
			Pre-Requisites	: 
			Revision History:
			====================================================================================================*/
			public static void validateQuotaIncreasingInputfieldvalue(int iQuotaIndex,String sStorageTier)
			{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver,EVDC_Storage);
					PageFactory.initElements(driver,Common);
					
					String sQuotaMaxvalue=null,sQuotaErrorMsg=null,sQuotaFieldValue=null,sMaxQuotaExceedErrMsg=null;
					boolean bFlag=false,bQuotaValueStatus=false;
				    int iQuotaMaxvalue=0;
				    String sMaxQuota[];
				try{
							
					    sMaxQuotaExceedErrMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.STORAGEPROFILE.TIER.EXCEEDEDMAXQUOTA.ERRORMSG");
						WebElement wQuotaInputField = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTAINPUTFIELD", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
						WebObjectUtil.verifyElementPresent(wQuotaInputField);
						sQuotaFieldValue = wQuotaInputField.getAttribute("value");
						//WebElement wQuotaParentInputField = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.PARENTQUOTAINPUTFIELD", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
						
						WebElement wQuotaMaxValue = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.MAXQUOTAVALUE", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
						WebObjectUtil.verifyElementPresent(wQuotaMaxValue);
						sQuotaMaxvalue = wQuotaMaxValue.getText();
						sMaxQuota = sQuotaMaxvalue.split(" ");
						iQuotaMaxvalue = Integer.parseInt(sMaxQuota[0]);
						iQuotaMaxvalue = iQuotaMaxvalue+100;
						sQuotaMaxvalue = String.valueOf(iQuotaMaxvalue);
						wQuotaInputField.clear();
						wQuotaInputField.sendKeys(sQuotaMaxvalue);
						
						WebObjectUtil.verifyElementPresent(EVDC_Storage.getNav_Quota_GreaterMax_PopupBox());
						WebObjectUtil.verifyElementPresent(EVDC_Storage.getNav_Quota_GreaterMax_PopupBoxMsg());
						sQuotaErrorMsg =EVDC_Storage.getNav_Quota_GreaterMax_PopupBoxMsg().getText(); 
						
						bQuotaValueStatus=sQuotaErrorMsg.contains(sMaxQuotaExceedErrMsg);
						//WebElement wQuotaSavebutton = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTA.SAVEBUTTON", "PARAMETER_TIERNUMBER", ""+iQuotaIndex); 
						//WebObjectUtil.clickElement(wQuotaSavebutton);
					
						FrameworkUtil.updateCustomResultBasedOnStatus(bQuotaValueStatus, " Error message verified for "+sStorageTier+ " when Quota value is greater than max value");	
						
					
					
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "validateQuotaIncreasingInputfieldvalue", "warn", "catch block:" +e.getMessage());  
				}
			 
			}
			
			
			/*====================================================================================================
			Method Name 	: validateQuotaDecreasingInputfieldvalue	
			Description		: Validate Error message by decreasing quota beyond min value
			Author 			: QAA03
			Creation Date 	: 08/17/2016
			Pre-Requisites	: 
			Revision History:
			====================================================================================================*/
			public static void validateQuotaDecreasingInputfieldvalue(int iQuotaIndex, String sStorageTier)
			{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver,EVDC_Storage);
					
					String sQuotaMinvalue=null,sQuotaMinIndvalue=null,sQuotaFieldValue=null,sMinQuotaDecreasedErrMsg=null;
					boolean bFlag=false,bQuotaValueStatus=false;
					int iQuotaMinvalue=0;
				    String sMinQuota[];
				try{
					    sMinQuotaDecreasedErrMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.STORAGEPROFILE.TIER.DECRESEDMINQUOTA.ERRORMSG");	
					
						WebElement wQuotaInputField = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTAINPUTFIELD", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
						WebObjectUtil.verifyElementPresent(wQuotaInputField);
						sQuotaFieldValue = wQuotaInputField.getAttribute("value");
						
						WebElement wQuotaMinValue = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.MINQUOTAVALUE", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
						WebObjectUtil.verifyElementPresent(wQuotaMinValue);
						sQuotaMinvalue = wQuotaMinValue.getText();
						
						sMinQuota = sQuotaMinvalue.split(" ");
						iQuotaMinvalue = Integer.parseInt(sMinQuota[0]);
						iQuotaMinvalue = iQuotaMinvalue-100;
						sQuotaMinvalue = String.valueOf(iQuotaMinvalue);
						WebElement wQuotaParentInputField = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.PARENTQUOTAINPUTFIELD", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
						wQuotaInputField.clear();
						wQuotaInputField.sendKeys(sQuotaMinvalue);
						WebObjectUtil.explicitWait(2);
						bQuotaValueStatus=WebObjectUtil.getToolTipsMsg(wQuotaParentInputField, sMinQuotaDecreasedErrMsg);
						
					
						FrameworkUtil.updateCustomResultBasedOnStatus(bQuotaValueStatus, " Error message verified for "+sStorageTier+ " when Quota value is lesser than min value");	
						
						WebElement wQuotaEditClose = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTAEDIT.CLOSEICON", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
					    WebObjectUtil.verifyElementPresent(wQuotaEditClose);
					
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "validateQuotaDecreasingInputfieldvalue", "warn", "catch block:" +e.getMessage());  
				}
			 
			}
			
			/*====================================================================================================
			Method Name 	: revertBackQuotaToDefalutValue
			Description		: Revert back the quota value editted to original value for storage tier
			Author 			: QAA03
			Creation Date 	: 08/18/2016
			Pre-Requisites	: 
			Revision History:
			====================================================================================================*/
			public static void revertBackQuotaToDefalutValue(int iQuotaIndex,String sStorageTier, String sQuotaDefaultvalue)
			{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver,EVDC_Storage);
					
					
					
				try{
					    WebElement wQuota = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTABUTTON", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
					    WebObjectUtil.clickElement(wQuota);
					
						WebElement wQuotaInputField = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTAINPUTFIELD", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
						
						wQuotaInputField.clear();
						wQuotaInputField.sendKeys(sQuotaDefaultvalue);
						WebObjectUtil.explicitWait(2);
						
						WebElement wQuotaSavebutton = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTA.SAVEBUTTON", "PARAMETER_TIERNUMBER", ""+iQuotaIndex); 
						WebObjectUtil.clickElement(wQuotaSavebutton);
						
											
						WebObjectUtil.clickElement(EVDC_Storage.getNav_QuotaPopupWindow_AgreeCheckBox());
						WebObjectUtil.clickElement(EVDC_Storage.getNav_QuotaPopupWindow_OkButton());
						
						WebObjectUtil.explicitWait(15);
						WebObjectUtil.verifyElementPresent(Common.getNav_UsrFeedBack());
					
						
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "revertBackQuotaToDefalutValue", "warn", "catch block:" +e.getMessage());  
				}
			 
			}
			
			/*====================================================================================================
			Method Name 	: verifyAllValuesForStorage
			Description		: Verifying all values for particular Storage Tier
			Author 			: QAA03
			Creation Date 	: 08/18/2016
			Pre-Requisites	: 
			Revision History:
			====================================================================================================*/
			public static void verifyAllValuesForStorage(String sStorageName)
			{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver,EVDC_Storage);
					String sStorageTier=null;
					int iQuotaIndex=0;
					boolean bFlag=false;
			 try {
				 
				    //Getting the Storage tier names list
					List<WebElement> wStorageTierNames = EVDC_Storage.getNav_StorageProfile_TierNames();
					
					
					for(WebElement wStorageTier : wStorageTierNames)
					{
						sStorageTier = wStorageTier.getText();
						
						if(sStorageTier.equalsIgnoreCase(sStorageName))
						{
							WebElement wCommittedGray = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.COMMITEDGRAYCOLOR", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
							WebObjectUtil.verifyElementPresent(wCommittedGray);
														
							WebElement wAllocatedGreen = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.ALLOCATEDGREENCOLOR", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
							WebObjectUtil.verifyElementPresent(wAllocatedGreen);
							
							WebElement wQuotaBlue = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTABLUECOLOR", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
							WebObjectUtil.verifyElementPresent(wQuotaBlue);
							
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Values verified for Storage Tier", "Storage Tier", "pass", " Commited, Allocated, quota values and colors verified for  "+sStorageName);
							bFlag=true;
							break;
						}
						
						iQuotaIndex++;
					}
					
					if(!bFlag)
					{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Storage Tier", "fail", "Storage Tier "+sStorageName+ " is not present");
					}
				    
					
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAllValuesForStorage", "warn", "catch block:" +e.getMessage());  
				}
			 
			}
			
			/*====================================================================================================
			Method Name 	: getIndexForStorageTier
			Description		: Getting the index of Storage tier
			Author 			: QAA03
			Creation Date 	: 08/22/2016
			Pre-Requisites	: 
			Revision History:
			====================================================================================================*/
			public static int getIndexForStorageTier(String sStorageName)
			{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver,EVDC_Storage);
					String sStorageTier=null;
					int iQuotaIndex=0;
					boolean bFlag=false;
			 try {
				 
				    //Getting the Storage tier names list
					List<WebElement> wStorageTierNames = EVDC_Storage.getNav_StorageProfile_TierNames();
					
					
					for(WebElement wStorageTier : wStorageTierNames)
					{
						sStorageTier = wStorageTier.getText();
						
						if(sStorageTier.equalsIgnoreCase(sStorageName))
						{
							bFlag=true;
							break;
						}
						
						iQuotaIndex++;
					}
					
					if(!bFlag)
					{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Storage Tier", "fail", "Storage Tier "+sStorageName+ " is not present");
					}
				    
					
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAllValuesForStorage", "warn", "catch block:" +e.getMessage());  
				}
			 return iQuotaIndex;
			}
			
			
			/*====================================================================================================
			Method Name 	: verifyMultipleIndicatorsNotpresentafterChangingQuotaforStorageTier	
			Description		: Verify multiple indicators are not present by increasing and decreasing quota input values
			Author 			: QAA03
			Creation Date 	: 08/16/2016
			Pre-Requisites	: 
			Revision History:
			====================================================================================================*/
			public static void verifyMultipleIndicatorsNotpresentafterChangingQuotaforStorageTier(int iQuotaIndex,String sStorageTier)
			{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver,EVDC_Storage);
					
					String sQuotaMaxvalue=null,sQuotaMinvalue=null,sQuotavalue=null;				
					boolean bMaxIndStatus=false,bMinIndStatus=false,bQuotaMaxStatus=false,bQuotaMinStatus=false;
				    
				try{
							
					
						WebElement wQuotaInputField = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTAINPUTFIELD", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
						WebObjectUtil.verifyElementPresent(wQuotaInputField);
						
						
						WebElement wQuotaMaxValue = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.MAXQUOTAVALUE", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
						WebObjectUtil.verifyElementPresent(wQuotaMaxValue);
						sQuotaMaxvalue = wQuotaMaxValue.getText();
						//WebElement wQuotaParentInputField = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.PARENTQUOTAINPUTFIELD", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
						wQuotaInputField.clear();
						wQuotaInputField.sendKeys(sQuotaMaxvalue);
						WebElement wGraphMaxIndicator = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.POLYGONVALUE", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
						for(int j=1;j<=5;j++)
						{
							WebElement wQuotaUpArrow = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTAEDIT.UPARROW", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
							WebObjectUtil.clickElement(wQuotaUpArrow);
						}
						bQuotaMaxStatus =sQuotaMaxvalue.contains(wQuotaInputField.getAttribute("value"));
						bMaxIndStatus=WebObjectUtil.iWebElementsCount == 1;
						FrameworkUtil.updateCustomResultBasedOnStatus(bMaxIndStatus, " Multiple Graph Indicators are not present for "+sStorageTier+ " when Quota value is max value");
						FrameworkUtil.updateCustomResultBasedOnStatus(bQuotaMaxStatus, " Quota value  for "+sStorageTier+ " cannot be increased by " +sQuotaMaxvalue);
										
						WebElement wQuotaMinValue = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.MINQUOTAVALUE", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
						WebObjectUtil.verifyElementPresent(wQuotaMinValue);
						sQuotaMinvalue = wQuotaMinValue.getText();
						//WebElement wQuotaParentInputField = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.PARENTQUOTAINPUTFIELD", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
						wQuotaInputField.clear();
						wQuotaInputField.sendKeys(sQuotaMinvalue);
						WebElement wGraphMinIndicator = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.POLYGONVALUE", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
						for(int j=1;j<=5;j++)
						{
							WebElement wQuotaDownArrow = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTAEDIT.DOWNARROW", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
							WebObjectUtil.clickElement(wQuotaDownArrow);
						}
						//int pp=Integer.parseInt(wQuotaInputField.getAttribute("value"));
						double dQuotavalue = Double.parseDouble(wQuotaInputField.getAttribute("value"));
						long lQuotanewvalue =Math.round(dQuotavalue);
					    //System.out.println(">>>>>>>>>>"+lQuotanewvalue);
					    sQuotavalue = String.valueOf(lQuotanewvalue);
						bQuotaMinStatus =sQuotaMinvalue.contains(sQuotavalue);
						bMinIndStatus=WebObjectUtil.iWebElementsCount == 1;
						FrameworkUtil.updateCustomResultBasedOnStatus(bMinIndStatus, " Multiple Graph Indicators are not present for "+sStorageTier+ " when Quota value is min value");
						FrameworkUtil.updateCustomResultBasedOnStatus(bQuotaMinStatus, " Quota value  for "+sStorageTier+ " cannot be decreased by " +sQuotaMinvalue);						
					
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyMultipleIndicatorsNotpresentafterChangingQuotaforStorageTier", "warn", "catch block:" +e.getMessage());  
				}
			 
			}
			
			/*====================================================================================================
			Method Name 	: verifyQuotaisCommitorAllocatedwhichisHigher
			Description		: Verifying Quota value is commit r allocated value which is higher
			Author 			: QAA03
			Creation Date 	: 08/29/2016
			Pre-Requisites	: 
			Revision History:
			====================================================================================================*/
			public static void verifyQuotaisCommitorAllocatedwhichisHigher(int iQuotaIndex,String sQuotavalue)
			{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver,EVDC_Storage);
					String sCommittedvalue=null,sAllocatedvalue=null;
					int iCommittedvalue=0,iAllocatedvalue=0,iQuotavalue=0;
					String sCommit[]=null,sAllocat[]=null,sQuota[]=null;
					boolean bQuotaStatus=false;
			 try {
				
					WebElement wCommittedGray = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.COMMITEDGRAYCOLOR", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
					sCommittedvalue = wCommittedGray.getText();
					sCommit = sCommittedvalue.split(" ");
					iCommittedvalue = Integer.parseInt(sCommit[0]);
												
					WebElement wAllocatedGreen = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.ALLOCATEDGREENCOLOR", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
					sAllocatedvalue= wAllocatedGreen.getText();
					sAllocat = sAllocatedvalue.split(" ");
					iAllocatedvalue = Integer.parseInt(sAllocat[0]);
					sQuota = sQuotavalue.split(" ");
					iQuotavalue = Integer.parseInt(sQuota[0]);
					
					if(iAllocatedvalue>iCommittedvalue)
					{
						bQuotaStatus =iQuotavalue==iAllocatedvalue;
						FrameworkUtil.updateCustomResultBasedOnStatus(bQuotaStatus, "Quota default value is Allocated value which is higher and is "+sAllocatedvalue);
					}
					else
					{
						bQuotaStatus =iQuotavalue==iCommittedvalue;
						FrameworkUtil.updateCustomResultBasedOnStatus(bQuotaStatus, "Quota default value is Commit value which is higher and is "+sCommittedvalue);
					}
		  
					
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyQuotaisCommitorAllocatedwhichisHigher", "warn", "catch block:" +e.getMessage());  
				}
			 
			}
			
			/*====================================================================================================
			Method Name 	: verifyLearnMoreLinkQuota
			Description		: Verifying learn more link by clicking quota button
			Author 			: QAA03
			Creation Date 	: 09/01/2016
			Pre-Requisites	: 
			Revision History:
			====================================================================================================*/
			public static void verifyLearnMoreLinkQuota(int iQuotaIndex,String sStorageTier)
			{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver,EVDC_Storage);
					
			 try {
				
				    WebElement wQuota = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTABUTTON", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
				    WebObjectUtil.clickElement(wQuota);
				    
				    WebElement wLearnMore = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.LEARNMORELINK", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
					WebObjectUtil.verifyElementPresent(wLearnMore);
					
		            WebObjectUtil.clickElement(wLearnMore);
		            WebObjectUtil.waitForElementNotPresent(EVDC_Storage.getNav_Quota_LearnMore_PopupBoxMsg());
					
		            WebObjectUtil.verifyElementPresent(EVDC_Storage.getNav_Quota_LearnMore_PopupBoxMsg());
		            WebObjectUtil.verifyElementPresent(EVDC_Storage.getNav_Quota_LearnMore_PopupMsgTitle());
		            WebObjectUtil.verifyElementPresent(EVDC_Storage.getNav_Quota_LearnMore_PopupMsgInf());
		            WebObjectUtil.clickElement(EVDC_Storage.getNav_Quota_LearnMore_PopupOkButton());
		            
		            
		            
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyLearnMoreLinkQuota", "warn", "catch block:" +e.getMessage());  
				}
			 
			}
			
			/*====================================================================================================
			Method Name 	: validateQuotaForanyStorageTier
			Description		: 
			Author 			: QAA03
			Creation Date 	: 09/01/2016
			Pre-Requisites	: 
			Revision History:
			====================================================================================================*/
			public static void validateQuotaForanyStorageTier(String sStorageName)
			{
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver,EVDC_Storage);
					int iQuotaIndex=0;
					String sQuotavalue=null,sQuotaMaxvalue=null;
			 try {
				   //Navigating to Storage-Profile Page
					EVDC_StorageProfileTestCase.navigateToStorageTierPage();
					
					WebObjectUtil.explicitWait(5);
					
					//Verifying quota button exist for the storage tiers
					verifyQuotaButtonForStorageTiers();
					
					//Getting the index of storage tier
					iQuotaIndex=getIndexForStorageTier(sStorageName);
					 									
					//Verifying the default value is quota value in the quota input field
					sQuotavalue =verifyDefaultValueinInputQuotaField(sStorageName);
					
					// Verifying Quota value is commit r allocated value which is higher
					verifyQuotaisCommitorAllocatedwhichisHigher(iQuotaIndex,sQuotavalue);
					
					// Validate Error message by increasing quota beyond max value
					validateQuotaIncreasingInputfieldvalue(iQuotaIndex,sStorageName);
					
					WebObjectUtil.explicitWait(5);
					
					WebElement wQuotaMaxValue = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.MAXQUOTAVALUE", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
					WebObjectUtil.verifyElementPresent(wQuotaMaxValue);
					sQuotaMaxvalue = wQuotaMaxValue.getText();
					
					WebElement wQuotaInputField = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTAINPUTFIELD", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
					wQuotaInputField.clear();
					wQuotaInputField.sendKeys(sQuotaMaxvalue);
					
					WebElement wQuotaSavebutton = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTA.SAVEBUTTON", "PARAMETER_TIERNUMBER", ""+iQuotaIndex); 
					WebObjectUtil.clickElement(wQuotaSavebutton);
					
					WebElement wQuotaCloseicon = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTA.SAVEBUTTON", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
					WebObjectUtil.clickElement(wQuotaCloseicon);
					WebObjectUtil.verifyElementPresent(wQuotaInputField);
					WebObjectUtil.clickElement(wQuotaSavebutton);
															
					//Verifying all fields in quota agreement popup window
					 verifyallFieldsinQuotaPopupWindow();
					  
				    WebObjectUtil.clickElement(EVDC_Storage.getNav_QuotaPopupWindow_AgreeCheckBox());
					WebObjectUtil.clickElement(EVDC_Storage.getNav_QuotaPopupWindow_OkButton());
					
					WebObjectUtil.explicitWait(15);
					
					WebObjectUtil.verifyElementPresent(Common.getNav_UsrFeedBack());
					
					WebDriverUtil.refreshBrowser();
					
					WebElement wQuotaBlue = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTABLUECOLOR", "PARAMETER_TIERNUMBER", ""+iQuotaIndex);
					WebObjectUtil.verifyElementPresent(wQuotaBlue);
					
					// Revert back the quota value editted to original value for storage tier
					revertBackQuotaToDefalutValue(iQuotaIndex,sStorageName,sQuotavalue);           
		            
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "validateQuotaForanyStorageTier", "warn", "catch block:" +e.getMessage());  
				}
			 
			}
			@AfterMethod
			public static void afterEachMethod(){
					FrameworkUtil.updateTestCaseStatusinResult();
					
				}

	}


