package com.whs.navigator.testcases.zathras;

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
import com.whs.navigator.testcases.LogViewerTestCase;
import com.whs.navigator.testcases.LoginTestCase;
import com.whs.navigator.testcases.TicketTestCase;
import com.whs.navigator.testcases.valen.ValenTestCase_SLP;
import com.whs.navigator.testcases.TicketTestCase;

public class ZathrasTestCase_Sukur {
	
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
		public void editstoragethresholdRoleAddastorageThresholddefaultchangequota()
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
				String sQuota;
				FrameworkUtil.sTestCaseName = "ElasticStorageAdmin-editstoragethresholdRoleAddastorageThresholddefaultchangequota";
				FrameworkUtil.sManualTestCaseName="QAT-1809";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
				//String sTicketHeader = (String) FrameworkUtil.dictPropertyData.get("NAV.TICKET.TABLEHEADER");
				ProviderVDCThreshold=(String) FrameworkUtil.dictPropertyData.get("NAV.EDIT.QAT1809.PROVIDER.VDC.THRESHOLD.PERSENTAGE");
				DataStoreThreshold=(String) FrameworkUtil.dictPropertyData.get("NAV.EDIT.QAT1809.DATASTORE.THRESHOLD.PERSENTAGE");
				sExpSuccessMsg=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.THRESHOLD.DEFAULT.ROW.FEEDBACK.MSG");
				sQuota=(String) FrameworkUtil.dictPropertyData.get("NAV.CAPACITY.TIER.QUOTA");
				sNothingHasChanged=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.THRESHOLD.NOTHING.CHANED.POPUP.WINDOW.TITLE");
				iQuota=Integer.parseInt(sQuota);
				//Login to Navigator
				
				LoginTestCase.LoginAsARoleAUser();
				//If Add threshold link is visible then continue executing remaining script
				if(navigateTOElasticStorageAdminAndVerifyAddThresholdLink()==true)
				{
					//Verify row displayed with Default cell and click on Default. Means clicking on default row
					verifyDefaultCellAndClickonDefaultRow();
					//Verify Default row elements
					verifyDefaultRowElements();
					editDefaultRowInputs(ProviderVDCThreshold,DataStoreThreshold);
					LoginTestCase.nav_Logout();
					//Following code commeted. Because Quota button is not available in application-09/19/2016
					/*LoginTestCase.LoginAsQaautoAUser();
					UpdateCapacityQuotaAndCheckSucessMsg(iQuota);
					LoginTestCase.nav_Logout();*/
				}
				
				
			} catch (Exception e) {
				LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
			
			}
			
		}
		
/*==============================================================
TestScript  	: editstoragethresholdRoleAddastorageThreshold
Manual TestCase	: QAT-1808
Description		: Verify user with 'edit storage threshold' role is able to add a storage threshold from portal.
Author 			: Sukur Babu
Creation Date 	: 08/24/2016
Pre-Requisites	:
Revision History:
==============================================================*/
	@Test(priority=2)
	public void editstoragethresholdRoleAddastorageThreshold()
	{
	
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Home);
		PageFactory.initElements(driver, Zathra);
		PageFactory.initElements(driver, Common);
		PageFactory.initElements(driver, EVDC_OverviewPF);
		PageFactory.initElements(driver,EVDC_Storage);
		try {
			String ProviderVDCThreshold,DataStoreThreshold;
			String sQuotaFailMsg,sNothingHasChanged;
			int iQuota;
			String sQuota;
			
			
			FrameworkUtil.sTestCaseName = "ElasticStorageAdmin-editstoragethresholdRoleAddastorageThreshold";
			FrameworkUtil.sManualTestCaseName="QAT-1808";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			sQuota=(String) FrameworkUtil.dictPropertyData.get("NAV.CAPACITY.TIER.QUOTA");
			sNothingHasChanged=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.THRESHOLD.NOTHING.CHANED.POPUP.WINDOW.TITLE");
			ProviderVDCThreshold=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.QAT1808.PROVIDER.VDC.THRESHOLD.PERSENTAGE");
			String StDataStoreThreshold=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.QAT1808.DATASTORE.THRESHOLD.PERSENTAGE");
			String sLoc=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.THRESHOLD.LOCATION");
			String sStragePlcy=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.THRESHOLD.STORAGEPOLOCY");
			iQuota=Integer.parseInt(sQuota);
			
			LoginTestCase.LoginAsARoleAUser();
			//If Add threshold link is visible then continue executing remaining script
			if(navigateTOElasticStorageAdminAndVerifyAddThresholdLink()==true)
			{
				
				AddThreshold(ProviderVDCThreshold,StDataStoreThreshold,sLoc,sStragePlcy);
				LoginTestCase.nav_Logout();
				//Following code commeted. Because Quota button is not available in application-09/19/2016
				/*
				LoginTestCase.LoginAsQaautoAUser();
				UpdateCapacityQuotaAndCheckSucessMsg(iQuota);
				LoginTestCase.nav_Logout();*/
			}
		} catch (Exception e) {
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		
		}
		
	}
	/*==============================================================
	TestScript  	: editstoragethresholdRoleAddastorageThresholdAndVerifyTicket
	Manual TestCase	: QAT-1803
	Description		: Verify user with 'edit storage threshold' role is able to add a storage threshold from portal and ticket created.
	Author 			: Sukur Babu
	Creation Date 	: 08/25/2016
	Pre-Requisites	:
	Revision History:
	==============================================================*/
		@Test(priority=3)
		public void editstoragethresholdRoleAddastorageThresholdAndVerifyTicket()
		{
		
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, Home);
			PageFactory.initElements(driver, Zathra);
			PageFactory.initElements(driver, Common);
			PageFactory.initElements(driver, EVDC_OverviewPF);
			PageFactory.initElements(driver,EVDC_Storage);
			try {
				String ProviderVDCThreshold,DataStoreThreshold;
				String sQuotaFailMsg,sNothingHasChanged;
				int iQuota;
				String sQuota;
				
				
				FrameworkUtil.sTestCaseName = "ElasticStorageAdmin-editstoragethresholdRoleAddastorageThresholdAndVerifyTicket";
				FrameworkUtil.sManualTestCaseName="QAT-1803";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				sQuota=(String) FrameworkUtil.dictPropertyData.get("NAV.CAPACITY.TIER.QUOTA");
				sNothingHasChanged=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.THRESHOLD.NOTHING.CHANED.POPUP.WINDOW.TITLE");
				
				ProviderVDCThreshold=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.QAT1803.PROVIDER.VDC.THRESHOLD.PERSENTAGE");
				String StDataStoreThreshold=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.QAT1803.DATASTORE.THRESHOLD.PERSENTAGE");
				String sLoc=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.QAT1803.THRESHOLD.LOCATION");
				String sStragePlcy=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.QAT1803.THRESHOLD.STORAGEPOLOCY");
				iQuota=Integer.parseInt(sQuota);
				String sExpectedQueueName=(String)FrameworkUtil.dictPropertyData.get("NAV.ADD.THRESHOLD.TICKET.VIRTUALIZATION.QUEUE.NAME");
				String sSummary=(String)FrameworkUtil.dictPropertyData.get("NAV.ADD.CAPACITY.THRESHOLD.TICKET.SUMMARY");
				
				LoginTestCase.LoginAsARoleAUser();
				//If Add threshold link is visible then continue executing remaining script
				if(navigateTOElasticStorageAdminAndVerifyAddThresholdLink()==true)
				{
					
					AddThreshold(ProviderVDCThreshold,StDataStoreThreshold,sLoc,sStragePlcy);
					LoginTestCase.nav_Logout();
					//Following code commeted. Because Quota button is not available in application-09/19/2016
					/*
					LoginTestCase.LoginAsQaautoAUser();
					UpdateCapacityQuotaAndCheckSucessMsg(iQuota);
					
					verifyTicketSummaryandQuesueName(sExpectedQueueName,sSummary);
					LoginTestCase.nav_Logout();*/
				}
			} catch (Exception e) {
				LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
			
			}
			
		}
		/*==============================================================
		TestScript  	: editstoragethresholdRoleAddastorageThresholdLessDataStoreAndVerifyTicket
		Manual TestCase	: QAT-1799
		Description		: Verify user with 'edit storage threshold' role is able to add a storage threshold by entering less Data store value from portal and ticket created.
		Author 			: Sukur Babu
		Creation Date 	: 08/29/2016
		Pre-Requisites	:
		Revision History:
		==============================================================*/
			@Test(priority=4)
			public void editstoragethresholdRoleAddastorageThresholdLessDataStoreAndVerifyTicket()
			{
			
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, Home);
				PageFactory.initElements(driver, Zathra);
				PageFactory.initElements(driver, Common);
				PageFactory.initElements(driver, EVDC_OverviewPF);
				PageFactory.initElements(driver,EVDC_Storage);
				try {
					String ProviderVDCThreshold,DataStoreThreshold;
					String sQuotaFailMsg,sNothingHasChanged;
					int iQuota;
					String sQuota;
					
					
					FrameworkUtil.sTestCaseName = "ElasticStorageAdmin-editstoragethresholdRoleAddastorageThresholdLessDataStoreAndVerifyTicket";
					FrameworkUtil.sManualTestCaseName="QAT-1799";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					sQuota=(String) FrameworkUtil.dictPropertyData.get("NAV.CAPACITY.TIER.QUOTA");
					sNothingHasChanged=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.THRESHOLD.NOTHING.CHANED.POPUP.WINDOW.TITLE");
					
					ProviderVDCThreshold=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.QAT1799.PROVIDER.VDC.THRESHOLD.PERSENTAGE");
					String StDataStoreThreshold=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.QAT1799.DATASTORE.THRESHOLD.PERSENTAGE");
					String sLoc=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.QAT1799.THRESHOLD.LOCATION");
					String sStragePlcy=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.QAT1799.THRESHOLD.STORAGEPOLOCY");
					iQuota=Integer.parseInt(sQuota);
					String sExpectedQueueName=(String)FrameworkUtil.dictPropertyData.get("NAV.ADD.THRESHOLD.TICKET.VIRTUALIZATION.QUEUE.NAME");
					String sSummary=(String)FrameworkUtil.dictPropertyData.get("NAV.ADD.CAPACITY.THRESHOLD.TICKET.SUMMARY");
					LoginTestCase.LoginAsARoleAUser();
					//If Add threshold link is visible then continue executing remaining script
					if(navigateTOElasticStorageAdminAndVerifyAddThresholdLink()==true)
					{
						
						AddThreshold(ProviderVDCThreshold,StDataStoreThreshold,sLoc,sStragePlcy);
						LoginTestCase.nav_Logout();
						//Following code commeted. Because Quota button is not available in application-09/19/2016
						/*
						LoginTestCase.LoginAsQaautoAUser();
						UpdateCapacityQuotaAndCheckSucessMsg(iQuota);
						
						verifyTicketSummaryandQuesueName(sExpectedQueueName,sSummary);
						LoginTestCase.nav_Logout();*/
					}
				} catch (Exception e) {
					LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
				
				}
				
			}
			/*==============================================================
			TestScript  	: editstoragethresholdRoleEditsastorageThresholdAndVerifylog
			Manual TestCase	: QAT-1798
			Description		: Verify user with 'edit storage threshold' role is able to edit a storage threshold by entering less Data store value from portal and verify log in log viewer.
			Author 			: Sukur Babu
			Creation Date 	: 08/29/2016
			Pre-Requisites	:
			Revision History:
			==============================================================*/
				@Test(priority=5)
				public void editstoragethresholdRoleEditsastorageThresholdAndVerifylog()
				{
				
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver, Home);
					PageFactory.initElements(driver, Zathra);
					PageFactory.initElements(driver, Common);
					PageFactory.initElements(driver, EVDC_OverviewPF);
					PageFactory.initElements(driver,EVDC_Storage);
					try {
						String ProviderVDCThreshold,DataStoreThreshold;
						String sQuotaFailMsg,sNothingHasChanged;
						int iQuota;
						String sQuota;
						
						
						FrameworkUtil.sTestCaseName = "ElasticStorageAdmin-editstoragethresholdRoleEditsastorageThresholdAndVerifylog";
						FrameworkUtil.sManualTestCaseName="QAT-1798";
						FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
						sQuota=(String) FrameworkUtil.dictPropertyData.get("NAV.CAPACITY.TIER.QUOTA");
						sNothingHasChanged=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.THRESHOLD.NOTHING.CHANED.POPUP.WINDOW.TITLE");
						
						
						ProviderVDCThreshold=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.QAT1798.PROVIDER.VDC.THRESHOLD.PERSENTAGE");
						String StDataStoreThreshold=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.QAT1798.DATASTORE.THRESHOLD.PERSENTAGE");
						String sLoc=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.QAT1798.THRESHOLD.LOCATION");
						String sStragePlcy=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.QAT1798.THRESHOLD.STORAGEPOLOCY");
						iQuota=Integer.parseInt(sQuota);
						String sDeleteLogMsg=(String) FrameworkUtil.dictPropertyData.get("NAV.LOG.VIEWER.DELETE.MSG");
						String sLogMsg=sDeleteLogMsg+ProviderVDCThreshold;
						
						LoginTestCase.LoginAsARoleAUser();
						String sExpSuccessMsg;
						sExpSuccessMsg=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.THRESHOLD.ROW.FEEDBACK.MSG");
						String sTablerowText,sTablerowTextArray[];
						//If Add threshold link is visible then continue executing remaining script
						if(navigateTOElasticStorageAdminAndVerifyAddThresholdLink()==true)
						{
							//Due to save link issue commented following method
							//AddThreshold(ProviderVDCThreshold,StDataStoreThreshold,sLoc,sStragePlcy);
							WebElement wTableRow = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGETHRESHOLD.TABLE.ROW", "PARAMETER_ROWNUMBER", "2");
							System.out.println(wTableRow.getText());
							sTablerowText=wTableRow.getText();
							sTablerowTextArray=sTablerowText.split("\n");
							sExpSuccessMsg=sExpSuccessMsg+sTablerowTextArray[0]+" - "+sTablerowTextArray[1];
							wTableRow.click();
							WebElement wEditElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGETHRESHOLD.EDIT", "PARAMETER_ROWNUMBER", "2");
							wEditElement.click();
							WebElement wProviderSVDCThresholdInput=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGETHRESHOLD.PROVIDERSVDC.THRESHOLD.INPUT.FIELD", "PARAMETER_ROWNUMBER", ""+1);
							WebElement wDataStoreThresholdInput=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGETHRESHOLD.DATASTORE.THRESHOLD.INPUT.FIELD", "PARAMETER_ROWNUMBER", ""+1);
							WebObjectUtil.SetValueEdit(wProviderSVDCThresholdInput, ProviderVDCThreshold);
							WebObjectUtil.SetValueEdit(wDataStoreThresholdInput, StDataStoreThreshold);
							
							WebElement wSaveIcon=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGETHRESHOLD.SAVE", "PARAMETER_ROWNUMBER", ""+2);
							WebObjectUtil.clickElement(wSaveIcon);
							
							String sActSuccessMsg=Common.getNav_UsrFeedBack().getText().trim();
							if(sActSuccessMsg.equalsIgnoreCase(sExpSuccessMsg))
								FrameworkUtil.updateCustomResultBasedOnStatus(true, "Feed back message is matching with actual feed back message. Actual Feed back message is  "+sActSuccessMsg);
							else
								FrameworkUtil.updateCustomResultBasedOnStatus(false, "Feed back message is not matching with actual feed back message. Actual Feed back message is  "+sActSuccessMsg);
							
							//saveDefaultRowAndCheckSucessMsg();
							
							LogViewerTestCase.navigatingToTheLogViewerPage();
							verifyLogViewerColumns();
							WebElement wLogTable=WebObjectUtil.getWebElementFromDynamicLocator("xpath","NAV.LOGVIEWER.TABLE","PARAMETER_ROWNUMBER", ""+0);
							
							int iLogRow=WebTableUtil.getRowByCellText(wLogTable, sLogMsg, 1, 1);
							
							if(wLogTable.getText().contains(sLogMsg))
									FrameworkUtil.updateCustomResultBasedOnStatus(true, "Message is displayed in log viewer after delete threshold");
								else
									FrameworkUtil.updateCustomResultBasedOnStatus(false, "Message is not displayed in log viewer after delete threshold");
							LoginTestCase.nav_Logout();
							
						}
					} catch (Exception e) {
						LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
					
					}
					
				}
				/*==============================================================
				TestScript  	: editstoragethresholdRoleDeletesastorageThresholdAndVerifylog
				Manual TestCase	: QAT-1797
				Description		: Verify user with 'edit storage threshold' role is able to edit a storage threshold by entering less Data store value from portal and verify log in log viewer.
				Author 			: Sukur Babu
				Creation Date 	: 08/29/2016
				Pre-Requisites	:
				Revision History:
				==============================================================*/
					@Test(priority=6)
					public void editstoragethresholdRoleDeletesastorageThresholdAndVerifylog()
					{
					
						WebDriver driver = WebDriverUtil.getDriver();
						PageFactory.initElements(driver, Home);
						PageFactory.initElements(driver, Zathra);
						PageFactory.initElements(driver, Common);
						PageFactory.initElements(driver, EVDC_OverviewPF);
						PageFactory.initElements(driver,EVDC_Storage);
						try {
							String ProviderVDCThreshold,DataStoreThreshold;
							String sQuotaFailMsg,sNothingHasChanged;
							int iQuota;
							String sQuota;
							
							
							FrameworkUtil.sTestCaseName = "ElasticStorageAdmin-editstoragethresholdRoleDeletesastorageThresholdAndVerifylog";
							FrameworkUtil.sManualTestCaseName="QAT-1797";
							FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
							sQuota=(String) FrameworkUtil.dictPropertyData.get("NAV.CAPACITY.TIER.QUOTA");
							sNothingHasChanged=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.THRESHOLD.NOTHING.CHANED.POPUP.WINDOW.TITLE");
							
							
							ProviderVDCThreshold=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.PROVIDER.VDC.THRESHOLD.PERSENTAGE");//80
							String StDataStoreThreshold=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.DATASTORE.THRESHOLD.PERSENTAGE");//80
							String sLoc=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.THRESHOLD.LOCATION");
							String sStragePlcy=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.THRESHOLD.STORAGEPOLOCY");
							iQuota=Integer.parseInt(sQuota);
							String sDeleteWndTitle=(String) FrameworkUtil.dictPropertyData.get("NAV.DELETE.THRESHOLD.POPUP.TITLE");
							String sDeleteLogMsg=(String) FrameworkUtil.dictPropertyData.get("NAV.LOG.VIEWER.DELETE.MSG");
							String sLogMsg=sDeleteLogMsg+ProviderVDCThreshold;
							//Delete Threshold ?
							LoginTestCase.LoginAsARoleAUser();
							//If Add threshold link is visible then continue executing remaining script
							if(navigateTOElasticStorageAdminAndVerifyAddThresholdLink()==true)
							{
								
								AddThreshold(ProviderVDCThreshold,StDataStoreThreshold,sLoc,sStragePlcy);
								WebElement wTableRow = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGETHRESHOLD.TABLE.ROW", "PARAMETER_ROWNUMBER", "1");
								wTableRow.click();
								WebElement wDeletElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGETHRESHOLD.DELETE", "PARAMETER_ROWNUMBER", "2");
								wDeletElement.click();
								String sActDeleteWndTitle=Zathra.getNav_DeleteThresholdPopup().getText();
								if(sActDeleteWndTitle.contains(sDeleteWndTitle))
								{
									FrameworkUtil.updateCustomResultBasedOnStatus(true, "Delete threshold window title is as expected");
								}
								else	
								{
									FrameworkUtil.updateCustomResultBasedOnStatus(false, "Delete threshold window title is not as expected");
								}
								saveDefaultRowAndCheckSucessMsg();
								verifyLogViewerColumns();
								int iLogRow=WebTableUtil.getRowByCellText(Zathra.getNav_LogViewerTable(), sLogMsg, 1, 1);
								if(iLogRow>0)
									FrameworkUtil.updateCustomResultBasedOnStatus(true, "Message is displayed in log viewer after delete threshold");
								else
									FrameworkUtil.updateCustomResultBasedOnStatus(false, "Message is not displayed in log viewer after delete threshold");
								//Verifying log message is pending as there is an issue in application.
								LoginTestCase.nav_Logout();
								
							}
						} catch (Exception e) {
							LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
						
						}
						
					}
				/*==============================================================
				TestScript  	: editstoragethresholdRoleAddastorageThresholddefaultchangequotaFailedMsgInTickets
				Manual TestCase	: QAT-1795
				Description		: Verify user with 'edit storage threshold' role is able to view a storage threshold page in portal. 
				When there is no threshold set for a specific storage tier at a specified location, use the 'Default' threshold to validate against
				Author 			: Sukur Babu
				Creation Date 	: 08/30/2016
				Pre-Requisites	:
				Revision History:
				==============================================================*/
					@Test(priority=6)
					public void editstoragethresholdRoleAddastorageThresholddefaultchangequotaFailedMsgInTickets()
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
							String sQuota;
							FrameworkUtil.sTestCaseName = "ElasticStorageAdmin-editstoragethresholdRoleAddastorageThresholddefaultchangequotaFailedMsgInTickets";
							FrameworkUtil.sManualTestCaseName="QAT-1795";
							FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
							
							//String sTicketHeader = (String) FrameworkUtil.dictPropertyData.get("NAV.TICKET.TABLEHEADER");
							ProviderVDCThreshold=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.QAT1795.PROVIDER.VDC.THRESHOLD.PERSENTAGE");
							DataStoreThreshold=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.QAT1795.DATASTORE.THRESHOLD.PERSENTAGE");
							sExpSuccessMsg=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.THRESHOLD.DEFAULT.ROW.FEEDBACK.MSG");
							sQuota=(String) FrameworkUtil.dictPropertyData.get("NAV.CAPACITY.TIER.QUOTA");
							sNothingHasChanged=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.THRESHOLD.NOTHING.CHANED.POPUP.WINDOW.TITLE");
							iQuota=Integer.parseInt(sQuota);
							String sExpectedQueueName=(String)FrameworkUtil.dictPropertyData.get("NAV.ADD.THRESHOLD.TICKET.VIRTUALIZATION.QUEUE.NAME");
							String sSummary=(String)FrameworkUtil.dictPropertyData.get("NAV.ADD.CAPACITY.THRESHOLD.TICKET.SUMMARY");
							//Login to Navigator
							
							LoginTestCase.LoginAsARoleAUser();
							//LoginTestCase.LoginAsQaautoAUser();
							//If Add threshold link is visible then continue executing remaining script
							if(navigateTOElasticStorageAdminAndVerifyAddThresholdLink()==true)
							{
								//Verify row displayed with Default cell and click on Default. Means clicking on default row
								verifyDefaultCellAndClickonDefaultRow();
								//Verify Default row elements
								verifyDefaultRowElements();
								editDefaultRowInputs(ProviderVDCThreshold,DataStoreThreshold);
								LoginTestCase.nav_Logout();
								//Following code commeted. Because Quota button is not available in application-09/19/2016
								/*
								LoginTestCase.LoginAsQaautoAUser();
								UpdateCapacityQuotaAndCheckSucessMsg(iQuota);
								verifyTicketSummaryandQuesueName(sExpectedQueueName,sSummary);
								LoginTestCase.nav_Logout();*/
								//LoginTestCase.nav_Logout();
							}
							
							
						} catch (Exception e) {
							LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
						
						}
						
					}
					/*==============================================================
					TestScript  	: verifythedisplayofelasticstorageadminpage
					Manual TestCase	: QAT-1772
					Description		: verify the display of elastic storage admin page
					Author 			: Sukur Babu
					Creation Date 	: 08/02/2016
					Pre-Requisites	:
					Revision History:
					==============================================================*/
						@Test(priority=7)
						public void verifythedisplayofelasticstorageadminpage()
						{
						
							WebDriver driver = WebDriverUtil.getDriver();
							PageFactory.initElements(driver, Home);
							PageFactory.initElements(driver, Zathra);
							
							try {
								
								FrameworkUtil.sTestCaseName = "ElasticStorageAdmin-verifythedisplayofelasticstorageadminpage";
								FrameworkUtil.sManualTestCaseName="QAT-1772";
								FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
								
																
								LoginTestCase.LoginAsARoleAUser();
								//If Add threshold link is visible then continue executing remaining script
								if(navigateTOElasticStorageAdminAndVerifyAddThresholdLink()==true)
								{
									WebObjectUtil.verifyElementPresent(Zathra.getNav_ThresholdTableLocationColumn());
									WebObjectUtil.verifyElementPresent(Zathra.getNav_ThresholdTableTierNameColumn());
									WebObjectUtil.verifyElementPresent(Zathra.getNav_ThresholdTableProviderVDCColumn());
									WebObjectUtil.verifyElementPresent(Zathra.getNav_ThresholdTableFirstcolumnDefaultCell());
									
									WebObjectUtil.verifyElementPresent(Zathra.getNav_ThresholdTableFirstPag());
									WebObjectUtil.verifyElementPresent(Zathra.getNav_ThresholdTablePrevPage());
									WebObjectUtil.verifyElementPresent(Zathra.getNav_ThresholdTablePageText());
									WebObjectUtil.verifyElementPresent(Zathra.getNav_ThresholdTableNextPage());
									WebObjectUtil.verifyElementPresent(Zathra.getNav_ThresholdTableLastPage());
									
									LoginTestCase.nav_Logout();
									//LoginTestCase.nav_Logout();
								}
								
								
							} catch (Exception e) {
								LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
							
							}
							
						}
			/*==============================================================
			TestScript  	: verifythedisplayofFieldsAddThresholdPopupWindow
			Manual TestCase	: QAT-1778
			Description		: verify the display of fields in add threshold pop up window
			Author 			: Sukur Babu
			Creation Date 	: 08/02/2016
			Pre-Requisites	:
			Revision History:
			==============================================================*/
				@Test(priority=8)
				public void verifythedisplayofFieldsAddThresholdPopupWindow()
				{
				
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver, Home);
					PageFactory.initElements(driver, Zathra);
					
					try {
						
						FrameworkUtil.sTestCaseName = "ElasticStorageAdmin-verifythedisplayofFieldsAddThresholdPopupWindow";
						FrameworkUtil.sManualTestCaseName="QAT-1778";
						FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
						String sLocItems,sStorageItems;
						sLocItems=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.THRESHOLD.LOCATION.DROPDOWN.ITEMS");
						sStorageItems=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.THRESHOLD.STRAGE.POLOCY.DROPDOWN.ITEMS");							
						
						LoginTestCase.LoginAsARoleAUser();
						//If Add threshold link is visible then continue executing remaining script
						if(navigateTOElasticStorageAdminAndVerifyAddThresholdLink()==true)
						{
							WebObjectUtil.clickElement(Zathra.getNav_AddaStorageThresholdLink());
							WebObjectUtil.explicitWait(3);
							verifyAddThresholdPopupWindowUIandFields();
							verifyAddThesholdLocationDropdownItems(sLocItems);
							verifyAddThresholdStorageProfileDropdownItems(sStorageItems);
							WebObjectUtil.clickElement(Zathra.getNav_AddThresholdPopupCancelButton());
							WebObjectUtil.clickElement(Zathra.getNav_AddaStorageThresholdLink());
							WebObjectUtil.explicitWait(3);
							WebObjectUtil.clickElement(Zathra.getNav_AddThresholdPopupWindowCloseImage());
							WebObjectUtil.verifyElementNOTPresent(Zathra.getNav_AddThresholdPopupTitle());
							LoginTestCase.nav_Logout();
							//LoginTestCase.nav_Logout();
						}
						
						
					} catch (Exception e) {
						LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
					
					}
					
				}
	/*==============================================================
	TestScript  	: assignEditStorageThresholdroletoanuser
	Manual TestCase	: QAT-1766
	Description		: Assign Edit Storage Threshold Role to user
	Author 			: Sukur Babu
	Creation Date 	: 08/02/2016
	Pre-Requisites	:
	Revision History:
	==============================================================*/
		@Test(priority=9)
		public void assignEditStorageThresholdroletoanuser()
		{
		
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, Home);
			PageFactory.initElements(driver, Zathra);
			
			try {
				
				FrameworkUtil.sTestCaseName = "ElasticStorageAdmin-assignEditStorageThresholdroletoanuser";
				FrameworkUtil.sManualTestCaseName="QAT-1766";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				String 	sSearchRole=(String) FrameworkUtil.dictPropertyData.get("NAV.ADMIN.ROLES.SEARCH.ROLE");				
				String sUserNameTosearch=(String) FrameworkUtil.dictPropertyData.get("NAV.ADMIN.ROLES.USERNAME.TO.SEARCH");
				
				LoginTestCase.LoginAsIshannonUser();
				//If Add threshold link is visible then continue executing remaining script
				AdminTestCase.navigatingToControlPanelOrgPage();
				
				WebObjectUtil.clickElement(Zathra.getNav_AdminRolesImg());
				WebObjectUtil.explicitWait(5);
				WebObjectUtil.SetValueEdit(Zathra.getNav_AdminRolesSearchInput(), sSearchRole);
				
				WebObjectUtil.clickElement(Zathra.getNav_AdminRolesSearchButton());
				WebObjectUtil.explicitWait(5);
				int iRow=WebTableUtil.getRowByCellText(Zathra.getNav_AdminRolesSearchResultsTable(), "Edit Storage Thresholds", 1, 1);
				WebElement wAction=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.ROLE.ACTION", "PARAMETER_ROWNUMBER", Integer.toString(iRow));
				wAction.click();
					
				WebObjectUtil.clickElement(Zathra.getNav_AdminActionAssignMembersLink());
				WebObjectUtil.explicitWait(5);
				
				WebObjectUtil.clickElement(Zathra.getNav_AdminAssignMemebersAvailableTab());
				WebObjectUtil.SetValueEdit(Zathra.getNav_AdminAssignMemebersUserNameInput(), sUserNameTosearch);
				WebObjectUtil.clickElement(Zathra.getNav_dminAssignMemebersAvailableSearchButton());
				WebObjectUtil.explicitWait(5);
				
				int iUserRow=WebTableUtil.getRowByCellText(Zathra.getNav_AdminRolesSearchResultsTable(), "Test Test", 1, 1);
				WebElement wUser=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.ROLE.ASSIGN.USER.CHECKBOX", "PARAMETER_ROWNUMBER", Integer.toString(iUserRow));
				wUser.click();
				WebObjectUtil.explicitWait(5);
				WebObjectUtil.clickElement(Zathra.getNav_AdminAssignMemebersCurrentTab());
				WebObjectUtil.explicitWait(5);
				
				int iAssignedUserRow=WebTableUtil.getRowByCellText(Zathra.getNav_AdminRolesSearchResultsTable(), "Test Test", 1, 1);
				if(iAssignedUserRow>0)
					FrameworkUtil.updateCustomResultBasedOnStatus(true, "User assigned is displayed in current tab");
				else
					FrameworkUtil.updateCustomResultBasedOnStatus(false, "User assigned is not displayed in current tab");
				
			} catch (Exception e) {
				LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
			
			}
			
		}
				/*====================================================================================================
				Method Name 	: verifyAddThresholdStorageProfileDropdownItems
				Description		: verify Storage polocy drop down items
				Author 			: Sukur Babu
				Creation Date 	: 09/02/2016
				Pre-Requisites	: 
				Revision History:
				====================================================================================================*/
				public static void verifyAddThresholdStorageProfileDropdownItems(String sDropdownitems)
				{
					String sActItemsaftersplit[],sExpItemsAfterSplit[];
					boolean bfound;
					 String sItems=WebObjectUtil.getCustomWebListItems(Zathra.getNav_AddThresholdPopupStragePlcyDropdown());
					 sActItemsaftersplit=sItems.split("|");
					 sExpItemsAfterSplit=sDropdownitems.split("#");
					 for(String sItem:sActItemsaftersplit)
					 {
						 for(String sExpItem:sExpItemsAfterSplit)
						 {
							 if(sExpItem.equalsIgnoreCase(sItem))
							 {
								 bfound=true;
								 //FrameworkUtil.updateCustomResultBasedOnStatus(true, "Item "+sExpItem+" found in Location drop down");
							 }
							 else
							 {
								 bfound=false;
								 //FrameworkUtil.updateCustomResultBasedOnStatus(true, "Item "+sExpItem+" not found in Location drop down");
							 }
							 if(bfound)
							 {
								 //bfound=true;
								 FrameworkUtil.updateCustomResultBasedOnStatus(true, "Item "+sExpItem+" found in Storage Polocy drop down");
							 }
							 else
							 {
								//bfound=false;
								 FrameworkUtil.updateCustomResultBasedOnStatus(true, "Item "+sExpItem+" not found in Storage Polocy drop down");
							 }
								 
						 }
								 
					 }
					
					
				}
				/*====================================================================================================
				Method Name 	: verifyAddThesholdLocationDropdownItems
				Description		: verify location drop down items
				Author 			: Sukur Babu
				Creation Date 	: 09/02/2016
				Pre-Requisites	: 
				Revision History:
				====================================================================================================*/
				public static void verifyAddThesholdLocationDropdownItems(String sDropdownitems)
				{
					String sActItemsaftersplit[],sExpItemsAfterSplit[];
					boolean bfound;
					 String sItems=WebObjectUtil.getCustomWebListItems(Zathra.getNav_AddThresholdPopupLocationdropdown());
					 sActItemsaftersplit=sItems.split("|");
					 sExpItemsAfterSplit=sDropdownitems.split("#");
					 for(String sItem:sActItemsaftersplit)
					 {
						 for(String sExpItem:sExpItemsAfterSplit)
						 {
							 if(sExpItem.equalsIgnoreCase(sItem))
							 {
								 bfound=true;
								 //FrameworkUtil.updateCustomResultBasedOnStatus(true, "Item "+sExpItem+" found in Location drop down");
							 }
							 else
							 {
								 bfound=false;
								 //FrameworkUtil.updateCustomResultBasedOnStatus(true, "Item "+sExpItem+" not found in Location drop down");
							 }
							 if(bfound)
							 {
								 //bfound=true;
								 FrameworkUtil.updateCustomResultBasedOnStatus(true, "Item "+sExpItem+" found in Location drop down");
							 }
							 else
							 {
								//bfound=false;
								 FrameworkUtil.updateCustomResultBasedOnStatus(true, "Item "+sExpItem+" not found in Location drop down");
							 }
								 
						 }
								 
					 }
					
					
				}
				/*====================================================================================================
				Method Name 	: verifyAddThresholdPopupWindowUIandFields
				Description		: Verify add threshold UI and fields
				Author 			: Sukur Babu
				Creation Date 	: 09/02/2016
				Pre-Requisites	: 
				Revision History:
				====================================================================================================*/
				public static void verifyAddThresholdPopupWindowUIandFields()
				{
					WebObjectUtil.verifyElementPresent(Zathra.getNav_AddThresholdPopupLocationdropdown());
					WebObjectUtil.verifyElementPresent(Zathra.getNav_AddThresholdPopupStragePlcyDropdown());
					WebObjectUtil.verifyElementPresent(Zathra.getNav_AddThresholdPopupVCDThresholdInput());
					WebObjectUtil.verifyElementPresent(Zathra.getNav_AddThresholdPopupDSThresholdInput());
					WebObjectUtil.verifyElementPresent(Zathra.getNav_AddThresholdPopupSaveButton());
					WebObjectUtil.verifyElementPresent(Zathra.getNav_AddThresholdPopupCancelButton());
					String sBtnProperty=Zathra.getNav_AddThresholdPopupSaveLink().getAttribute("class");
					if(sBtnProperty.contains("disabled"))
						FrameworkUtil.updateCustomResultBasedOnStatus(true, "Save button in Add threshold pop up window is disabled");
					else
						FrameworkUtil.updateCustomResultBasedOnStatus(false, "Save button in Add threshold pop up window is enabled");
					
					sBtnProperty=Zathra.getNav_AddThresholdPopupCancelButton().getAttribute("class");
					if(sBtnProperty.contains("disabled"))
						FrameworkUtil.updateCustomResultBasedOnStatus(false, "Cancel button in Add threshold pop up window is enabled");
					else
						FrameworkUtil.updateCustomResultBasedOnStatus(false, "Cancel button in Add threshold pop up window is disabled");
					
				}
				
		/*====================================================================================================
		Method Name 	: AddThreshold
		Description		: Adding threshold
		Author 			: Sukur Babu
		Creation Date 	: 08/24/2016
		Pre-Requisites	: 
		Revision History:
		====================================================================================================*/
		public static void verifyTicketSummaryandQuesueName(String sExpectedQueueName,String sSummary)
		{
			//PageFactory.initElements(driver, Ticket);
			
			
			TicketTestCase.navigateToTicketPage();
		    WebObjectUtil.explicitWait(5);
		    String sActSummary=WebTableUtil.getCellData(Ticket.getNav_TicketsWebTable(), 1, 2).trim();
		    if(sActSummary.equalsIgnoreCase(sSummary))
			   {
				   FrameworkUtil.updateCustomResultBasedOnStatus(true, "Ticket is summary is as expected. Summary is :" + sActSummary);
			   }
			   else{
				   FrameworkUtil.updateCustomResultBasedOnStatus(false, "Ticket is summary is not as expected, Expected : " +sSummary + ", actual : " + sActSummary);
			   }
		    WebObjectUtil.explicitWait(5);
		    String sTicketID=TicketTestCase.getTicketID(1);
		    TicketTestCase.expandTable(1);
		    WebObjectUtil.explicitWait(5);
		  // WebElement wQueuenameChk2 = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.TICKET.QUEUE.VALUE", "PARAMETER_ROWNUMBER", "1");
		   // this below line added by QAA04 - 02/26/2016
		  WebElement wQueuenameChk = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.TICKET.QUEUE.VALUE", "PARAMETER_ROWNUMBER", "1");
		 String   sQueuevalue=wQueuenameChk.getText().trim();  
		   if(sQueuevalue.equalsIgnoreCase(sExpectedQueueName))
		   {
			   FrameworkUtil.updateCustomResultBasedOnStatus(true, "Assigned to appropriate queue :" + sQueuevalue);
		   }
		   else{
			   FrameworkUtil.updateCustomResultBasedOnStatus(false, "Not Assigned to appropriate queue, Expected : " +sExpectedQueueName + ", actual : " + sQueuevalue);
		   }
			
		}
		
	/*====================================================================================================
	Method Name 	: AddThreshold
	Description		: Adding threshold
	Author 			: Sukur Babu
	Creation Date 	: 08/24/2016
	Pre-Requisites	: 
	Revision History:
	====================================================================================================*/
	public static void AddThreshold(String ProviderVDCThreshold,String  StDataStoreThreshold,String sLoc,String sStragePlcy)
	{
		String sFeedbackMsg,sExpAddThresholdFeedbackMsg;
		
		sExpAddThresholdFeedbackMsg=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.THRESHOLD.FEEDBACK.SUCC.MSG");
		
		WebObjectUtil.clickElement(Zathra.getNav_AddaStorageThresholdLink());
		
		WebObjectUtil.clickElement(Zathra.getNav_AddThresholdPopupLocationInput());
		WebObjectUtil.selectCustomWebList(Zathra.getNav_AddThresholdPopupLocationdropdown(), sLoc);
		WebObjectUtil.clickElement(Zathra.getNav_AddThresholdPopupStragePlcyInput());
		WebObjectUtil.selectCustomWebList(Zathra.getNav_AddThresholdPopupStragePlcyDropdown(), sStragePlcy);
		//WebObjectUtil.selectCustomWebList(Zathra.getNav_AddThresholdPopupStragePlcyDropdown(), 2);
		
		WebObjectUtil.SetValueEdit(Zathra.getNav_AddThresholdPopupVCDThresholdInput(), ProviderVDCThreshold);
		WebObjectUtil.SetValueEdit(Zathra.getNav_AddThresholdPopupDSThresholdInput(), StDataStoreThreshold);
		//WebObjectUtil.clickElement(Zathra.getNav_AddThresholdPopupCancelButton());
		WebObjectUtil.clickElement(Zathra.getNav_AddThresholdPopupSaveLink());
		if(!Zathra.getNav_AddThresholdPopupSaveLink().getAttribute("class").contains("disabled"))
		{
			FrameworkUtil.updateCustomResultBasedOnStatus(true,"Save button is now enabled and is expected");
			WebObjectUtil.clickElement(Zathra.getNav_AddThresholdPopupSaveLink());
			sFeedbackMsg=Common.getNav_UsrFeedBack().getText().trim();
			if(sFeedbackMsg.equalsIgnoreCase(sExpAddThresholdFeedbackMsg))
				FrameworkUtil.updateCustomResultBasedOnStatus(true,"Feed back message is matching with expected. Message is "+sFeedbackMsg);
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false,"Feed back message is not matching with expected. Message is "+sFeedbackMsg);
		}
		else
		{
			FrameworkUtil.updateCustomResultBasedOnStatus(false,"Save button is still disabled which is not expected");
		}
		
		
	}
		/*====================================================================================================
		Method Name 	: UpdateCapacityQuotaAndCheckSucessMsg
		Description		: Login as Qaauto A user and increas the quota for capacity tier and check the sucess messge
		Author 			: Sukur Babu
		Creation Date 	: 08/23/2016
		Pre-Requisites	: 
		Revision History:
		====================================================================================================*/
		public static void UpdateCapacityQuotaAndCheckSucessMsg(int iQuota)
		{
			String sQuotaFailMsg;
			//LoginTestCase.LoginAsQaautoAUser();
			//Navigating to Storage-Profile Page
			EVDC_StorageProfileTestCase.navigateToStorageTierPage();
			WebObjectUtil.explicitWait(5);
			increasequotaAndUpdate(iQuota);
			sQuotaFailMsg=(String) FrameworkUtil.dictPropertyData.get("NAV.INCREASE.CAPACITY.QUOTA.FAIL.MSG");
			String sQuotaActFeedBackMsg=Common.getNav_UsrFeedBack().getText().trim();
			if(sQuotaFailMsg.equalsIgnoreCase(sQuotaActFeedBackMsg))
				FrameworkUtil.updateCustomResultBasedOnStatus(false, "Feed back message is not matching with actual feed back message. Actual Feed back message is  "+sQuotaActFeedBackMsg);
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(true, "Feed back message is matching with actual feed back message. Actual Feed back message is  "+sQuotaActFeedBackMsg);
		}
		/*====================================================================================================
		Method Name 	: UpdateCapacityQuotaAndCheckSucessMsg
		Description		: Login as Qaauto A user and increas the quota for capacity tier and check the sucess messge
		Author 			: Sukur Babu
		Creation Date 	: 08/31/2016
		Pre-Requisites	: 
		Revision History:
		====================================================================================================*/
		public static void verifyLogViewerColumns()
		{
			WebObjectUtil.verifyElementPresent(Zathra.getNav_LogViewerUserNameColumn());
			WebObjectUtil.verifyElementPresent(Zathra.getNav_LogViewerUserActionColumn());
			WebObjectUtil.verifyElementPresent(Zathra.getNav_LogViewerMessageColumn());
			WebObjectUtil.verifyElementPresent(Zathra.getNav_LogViewerDateCreatedColumn());
			WebObjectUtil.verifyElementPresent(Zathra.getNav_LogViewerStatusColumn());
			
		}
		
		/*====================================================================================================
		Method Name 	: navigateTOElasticStorageAdminAndVerifyAddThresholdLink
		Description		: Navigate to Elastic Storage Admin and verify Add threshold link is present
		Author 			: Sukur Babu
		Creation Date 	: 08/22/2016
		Pre-Requisites	: 
		Revision History:
		====================================================================================================*/
		public static boolean navigateTOElasticStorageAdminAndVerifyAddThresholdLink()
		{
			WebDriver driver = WebDriverUtil.getDriver();
			String sElasticStrageAdminURL = (String) FrameworkUtil.dictPropertyData.get("NAV.ELASTIC.STORAGE.ADMIN.URL");
			driver.get(sElasticStrageAdminURL);
			
			return WebObjectUtil.verifyElementPresent(Zathra.getNav_AddaStorageThresholdLink());
		}
		/*====================================================================================================
		Method Name 	: verifyAndClickonDefaultRow()
		Description		: Verifies default row is displayed after that it clicks on default row
		Author 			: Sukur Babu
		Creation Date 	: 08/22/2016
		Pre-Requisites	: 
		Revision History:
		====================================================================================================*/
		public static void verifyDefaultCellAndClickonDefaultRow()
		{
			WebDriver driver = WebDriverUtil.getDriver();
			String sElasticStrageAdminURL = (String) FrameworkUtil.dictPropertyData.get("NAV.ELASTIC.STORAGE.ADMIN.URL");
			driver.get(sElasticStrageAdminURL);
			
			WebObjectUtil.verifyElementPresent(Zathra.getNav_ThresholdTableFirstcolumnDefaultCell());
			WebObjectUtil.clickElement(Zathra.getNav_ThresholdTableFirstcolumnDefaultCell());
		}
		/*====================================================================================================
		Method Name 	: increasequotaAndUpdate
		Description		: Increases quota and updates the same
		Author 			: Sukur Babu
		Creation Date 	: 08/22/2016
		Pre-Requisites	: 
		Revision History:
		====================================================================================================*/
		public static void increasequotaAndUpdate(int iQuotaIncrease)
		{
			String sQuotavalue,sQuotaEditvalue;
			int iQuotavalue;
			
			
			WebElement wQuotabutton = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTABUTTON", "PARAMETER_TIERNUMBER", ""+0);
			//WebElement wQuotabutton=WebDriverUtil.getDriver().findElement(By.xpath("//a[contains(@id,'q-quotaST-1')]"));
			
			if(wQuotabutton==null)
				FrameworkUtil.updateCustomResultBasedOnStatus(false, "Quoata button is not available in application or issue with Quota button");
			else
			{
				FrameworkUtil.updateCustomResultBasedOnStatus(true, "Quoata button is available in application");
				wQuotabutton.click();
			}
			WebElement wQuotaInputField = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTAINPUTFIELD", "PARAMETER_TIERNUMBER", ""+0);
			sQuotavalue=wQuotaInputField.getAttribute("value");
			iQuotavalue = Integer.parseInt(sQuotavalue);
			iQuotavalue=iQuotavalue+iQuotaIncrease;
			sQuotaEditvalue = String.valueOf(iQuotavalue);
			wQuotaInputField.clear();
			wQuotaInputField.sendKeys(sQuotaEditvalue);
			
			WebElement wQuotaSavebutton = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGEPROFILE.TIER.QUOTA.SAVEBUTTON", "PARAMETER_TIERNUMBER", ""+0); 
			
			WebObjectUtil.clickElement(wQuotaSavebutton);
			
			//Verifying all fields in quota agreement popup window
			ValenTestCase_SLP.verifyallFieldsinQuotaPopupWindow();
			
			WebObjectUtil.clickElement(EVDC_Storage.getNav_QuotaPopupWindow_AgreeCheckBox());
			WebObjectUtil.clickElement(EVDC_Storage.getNav_QuotaPopupWindow_OkButton());
			
			WebObjectUtil.explicitWait(15);
			WebObjectUtil.verifyElementPresent(Common.getNav_UsrFeedBack());
		}

/*====================================================================================================
		Method Name 	: verifyDefaultRowElements
		Description		: Verify Edit,Delete icons and Provider and Data store input fields in default row
		Author 			: Sukur Babu
		Creation Date 	: 08/23/2016
		Pre-Requisites	: 
		Revision History:
====================================================================================================*/
		public static void verifyDefaultRowElements()
		{
			WebElement wEidtIcon=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGETHRESHOLD.EDIT", "PARAMETER_ROWNUMBER", ""+1);
			WebElement wDeleteIcon=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGETHRESHOLD.DELETE", "PARAMETER_ROWNUMBER", ""+1);
			WebObjectUtil.verifyElementPresent(wEidtIcon);
			WebObjectUtil.verifyElementNOTPresent(wDeleteIcon);
			WebObjectUtil.clickElement(wEidtIcon);
			WebElement wProviderSVDCThresholdInput=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGETHRESHOLD.PROVIDERSVDC.THRESHOLD.INPUT.FIELD", "PARAMETER_ROWNUMBER", ""+0);
			WebElement wDataStoreThresholdInput=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGETHRESHOLD.DATASTORE.THRESHOLD.INPUT.FIELD", "PARAMETER_ROWNUMBER", ""+0);
			WebObjectUtil.verifyElementPresent(wProviderSVDCThresholdInput);
			WebObjectUtil.verifyElementPresent(wDataStoreThresholdInput);
							 
		}
		/*====================================================================================================
				Method Name 	: editDefaultRowInputs
				Description		: Update Provider and Data store input fields in default row
				Author 			: Sukur Babu
				Creation Date 	: 08/23/2016
				Pre-Requisites	: 
				Revision History:
		====================================================================================================*/
		public static void editDefaultRowInputs(String ProviderVDCThreshold,String DataStoreThreshold)
{
	
	WebElement wProviderSVDCThresholdInput=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGETHRESHOLD.PROVIDERSVDC.THRESHOLD.INPUT.FIELD", "PARAMETER_ROWNUMBER", ""+0);
	WebElement wDataStoreThresholdInput=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGETHRESHOLD.DATASTORE.THRESHOLD.INPUT.FIELD", "PARAMETER_ROWNUMBER", ""+0);
	WebObjectUtil.SetValueEdit(wProviderSVDCThresholdInput, ProviderVDCThreshold);
	WebObjectUtil.SetValueEdit(wDataStoreThresholdInput, DataStoreThreshold);
}

	/*====================================================================================================
			Method Name 	: saveDefaultRowAndCheckSucessMsg
			Description		: Save default row details after editing input fields from default row
			Author 			: Sukur Babu
			Creation Date 	: 08/23/2016
			Pre-Requisites	: 
			Revision History:
	====================================================================================================*/
	public static void saveDefaultRowAndCheckSucessMsg()
	{
		String sActSuccessMsg,sExpSuccessMsg,sNothingHasChanged;
		sExpSuccessMsg=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.THRESHOLD.DEFAULT.ROW.FEEDBACK.MSG");
		sNothingHasChanged=(String) FrameworkUtil.dictPropertyData.get("NAV.ADD.THRESHOLD.NOTHING.CHANED.POPUP.WINDOW.TITLE");
		WebElement wSaveIcon=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.STORAGETHRESHOLD.SAVE", "PARAMETER_ROWNUMBER", ""+1);
		WebObjectUtil.clickElement(wSaveIcon);
		if(!Zathra.getNav_NothingChanngedPopup().getText().trim().equalsIgnoreCase(sNothingHasChanged))
		{
			sActSuccessMsg=Common.getNav_UsrFeedBack().getText().trim();
			if(sActSuccessMsg.equalsIgnoreCase(sExpSuccessMsg))
				FrameworkUtil.updateCustomResultBasedOnStatus(true, "Feed back message is matching with actual feed back message. Actual Feed back message is  "+sActSuccessMsg);
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false, "Feed back message is not matching with actual feed back message. Actual Feed back message is  "+sActSuccessMsg);
		
		}
		else
		{
			WebObjectUtil.clickElement(Zathra.getNav_NothingChanngedPopupOKButton());
			FrameworkUtil.updateCustomResultBasedOnStatus(true, "It seems required value is already there in the field  "+sNothingHasChanged);
		}
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