package com.whs.navigator.testcases.zathras;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.EVDC_FirewallPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.TicketPageFactory;
import com.whs.navigator.testcases.EVDC_FirewallTestCase;
import com.whs.navigator.testcases.FirewallRuleTestCase;
import com.whs.navigator.testcases.LoginTestCase;
import com.whs.navigator.testcases.TicketTestCase;
import com.whs.navigator.pagefactory.CommonPageFactory;


public class ZathrasTestCase_Priyanka {
	public static HomePageFactory_old Home = new HomePageFactory_old();
	public static TicketPageFactory Ticket = new TicketPageFactory();
	public static EVDC_FirewallPageFactory Firewall = new EVDC_FirewallPageFactory();
	public static CommonPageFactory Common = new CommonPageFactory();
	/*==============================================================
	TestScript  	: verifyAgiLoft
	Manual TestCase	: Verify that Hosted solution user is able to view agiloft tickets page
	Description		: QAT-1758_QAT-1757_WCP_5802_TC_1.1_Tickets->Agiloft -> Tickets
	Author 			: Priyanka
	Creation Date 	: 06/16/2015
	Release         : Zathras
	Pre-Requisites	:
	Revision History:
	==============================================================*/
		@Test(priority=1)
		public void verifyAgiLoft()
		{
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, Ticket);
			
			try {
				FrameworkUtil.sTestCaseName = "Ticket-verifyAgiLoft";
				FrameworkUtil.sManualTestCaseName="QAT-1758_QAT-1757_WCP_5802_TC_1.1_Tickets->Agiloft -> Tickets";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				String sTicketHeader = (String) FrameworkUtil.dictPropertyData.get("NAV.TICKET.TABLEHEADER");
				String sURL=(String) FrameworkUtil.dictPropertyData.get("NAV.AGILOFT.URL");
				//Login to Navigator
				//TicketTestCase.navTicketLogin();
				com.whs.navigator.testcases.LoginTestCase.LoginAsRoleAUser();
				TicketTestCase.navigateToTicketPage();
				
				WebObjectUtil.clickElement(Ticket.getNav_SourceDropdownField());
				WebObjectUtil.clickElement(Ticket.getNav_SourceAgiloftValue());
				//WebObjectUtil.explicitWait(Ticket.getNav_AgiLoftUserID());
				WebObjectUtil.explicitWait(8);
				driver.switchTo().frame(Ticket.getNav_AgiLoftIframe());
				WebObjectUtil.SetValueEdit(Ticket.getNav_AgiLoftUserID(),"secuser1");
				//driver.switchTo().frame(1);
				WebObjectUtil.SetValueEdit(Ticket.getNav_AgiLoftPassword(),"LabPortalL0w");
				//driver.switchTo().frame(1);
			    WebObjectUtil.clickElement(Ticket.getNav_AgiLoftOKBtn());
			    driver.switchTo().defaultContent();
			    WebObjectUtil.explicitWait(5);
			    WebObjectUtil.verifyUrl(sURL);
			    
			    com.whs.navigator.testcases.LoginTestCase.nav_Logout();
				} 
	   catch (Exception e) {
				LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
			
			}
			
		}
		
		/*==============================================================
		TestScript  	: verifyAgiLoftPage
		Manual TestCase	: Verify Ticket details
		Description		: QAT-1756_WCP_5802_TC_1.0_Tickets->Agiloft page
		Author 			: Priyanka
		Creation Date 	: 06/16/2015
		Release         : Zathras
		Pre-Requisites	:
		Revision History:
		==============================================================*/
			@Test(priority=2)
			public void verifyAgiLoftPage()
			{
				
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, Ticket);
				
				try {
					FrameworkUtil.sTestCaseName = "Ticket-verifyAgiLoftPage";
					FrameworkUtil.sManualTestCaseName="QAT-1756_WCP_5802_TC_1.0_Tickets->Agiloft page";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					
					String sURL=(String) FrameworkUtil.dictPropertyData.get("NAV.AGILOFT.PAGE.URL");
					//Login to Navigator
					
					com.whs.navigator.testcases.LoginTestCase.LoginAsRoleAUser();
					TicketTestCase.navigateToTicketPage();
					
					WebObjectUtil.clickElement(Ticket.getNav_SourceDropdownField());
					WebObjectUtil.clickElement(Ticket.getNav_SourceAgiloftValue());
					WebObjectUtil.explicitWait(5);
				    WebObjectUtil.verifyUrl(sURL);
				    com.whs.navigator.testcases.LoginTestCase.nav_Logout();
					} 
		   catch (Exception e) {
					LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
				
				}
				
			}
			
			
			/*==============================================================
			TestScript  	: verifyAgiLoftSource
			Manual TestCase	: Verify Ticket details
			Description		: QAT-1749_WCP_5801_TC_1.3_Tickets->Agiloft login page
			Author 			: Priyanka 
			Creation Date 	: 06/16/2015
			Release         : Zathras
			Pre-Requisites	:
			Revision History:
			==============================================================*/
				@Test(priority=3)
				public void verifyAgiLoftSource()
				{
					
					WebDriver driver = WebDriverUtil.getDriver();
					PageFactory.initElements(driver, Ticket);
					
					try {
						FrameworkUtil.sTestCaseName = "Ticket-verifyAgiLoftSource";
						FrameworkUtil.sManualTestCaseName="QAT-1749_WCP_5801_TC_1.3_Tickets->Agiloft login page";
						FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
						//Login to Navigator
						
						com.whs.navigator.testcases.LoginTestCase.LoginAsQaautoAUser();
						TicketTestCase.navigateToTicketPage();
						WebObjectUtil.verifyElementNOTPresent(Ticket.getNav_SourceDropdownField());
						com.whs.navigator.testcases.LoginTestCase.nav_Logout();
					}
						  catch (Exception e) {
								LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
							
							}
							}
				
				/*==============================================================
				TestScript  	: verifySourceEM7
				Manual TestCase	: QAT-1748_WCP_5801_TC_1.2_Tickets->Ticket selector values
				Description		:
				Author 			: Priyanka
				Creation Date 	: 06/16/2015
				Release         : Zathras
				Pre-Requisites	:
				Revision History:
				==============================================================*/
					@Test(priority=4)
					public void verifySourceEM7()
					{
						
						WebDriver driver = WebDriverUtil.getDriver();
						PageFactory.initElements(driver, Ticket);
						
						try {
							FrameworkUtil.sTestCaseName = "Ticket-verifySourceEM7";
							FrameworkUtil.sManualTestCaseName=" QAT-1748_WCP_5801_TC_1.2_Tickets->Ticket selector values";
							FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
							
							String sURL=(String) FrameworkUtil.dictPropertyData.get("NAV.AGILOFT.PAGE.URL");
							//Login to Navigator
							
							com.whs.navigator.testcases.LoginTestCase.LoginAsRoleEUser();
							TicketTestCase.navigateToTicketPage();
							
							navVerifySourceSelectorValues();
						    com.whs.navigator.testcases.LoginTestCase.nav_Logout();
							} 
				   catch (Exception e) {
							LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
						
						}
						
					}
				
					/*==============================================================
					TestScript  	: verifySourceEM7Selector
					Manual TestCase	: QAT-1747_WCP_5801_TC_1.2_Tickets->Ticket selector values
					Description		:
					Author 			: Priyanka
					Creation Date 	: 06/16/2015
					Release         : Zathras
					Pre-Requisites	:
					Revision History:
					==============================================================*/
						@Test(priority=5)
						public void verifySourceEM7Selector()
						{
							
							WebDriver driver = WebDriverUtil.getDriver();
							PageFactory.initElements(driver, Ticket);
							
							try {
								FrameworkUtil.sTestCaseName = "Ticket-verifySourceEM7Selector";
								FrameworkUtil.sManualTestCaseName=" QAT-1747_WCP_5801_TC_1.2_Tickets->Ticket selector values";
								FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
								
								String sURL=(String) FrameworkUtil.dictPropertyData.get("NAV.AGILOFT.PAGE.URL");
								//Login to Navigator
								
								com.whs.navigator.testcases.LoginTestCase.LoginAsRoleCUser();
								TicketTestCase.navigateToTicketPage();
								
								navVerifySourceSelectorValues();
							    com.whs.navigator.testcases.LoginTestCase.nav_Logout();
								} 
					   catch (Exception e) {
								LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
							
							}
							
						}
						
						/*==============================================================
						TestScript  	: verifySourceEM7SelectorVal
						Manual TestCase	: QAT-1743_WCP_5801_TC_1.0_Tickets->Ticket selector value
						Description		:
						Author 			: Priyanka
						Creation Date 	: 06/16/2015
						Release         : Zathras
						Pre-Requisites	:
						Revision History:
						==============================================================*/
							@Test(priority=6)
							public void verifySourceEM7SelectorVal()
							{
								
								WebDriver driver = WebDriverUtil.getDriver();
								PageFactory.initElements(driver, Ticket);
								
								try {
									FrameworkUtil.sTestCaseName = "Ticket-verifySourceEM7SelectorVal";
									FrameworkUtil.sManualTestCaseName="QAT-1743_WCP_5801_TC_1.0_Tickets->Ticket selector value";
									FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
									
									String sURL=(String) FrameworkUtil.dictPropertyData.get("NAV.AGILOFT.PAGE.URL");
									//Login to Navigator
									
									com.whs.navigator.testcases.LoginTestCase.LoginAsRoleCUser();
									TicketTestCase.navigateToTicketPage();
									
									navVerifySourceSelectorValues();
								    
								    com.whs.navigator.testcases.LoginTestCase.nav_Logout();
									} 
						   catch (Exception e) {
									LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
									FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
								
								}
								
							}
							
							/*==============================================================
							TestScript  	: verifyEditNATPageUrl
							Manual TestCase	: QAT-1741_QAT-1739_WCP_5981_TC_1.3_NATSs-> Add, Edit & Delete NATs ->request parameter on page url
							Description		:
							Author 			: Priyanka
							Creation Date 	: 06/16/2015
							Release         : Zathras
							Pre-Requisites	:
							Revision History:
							==============================================================*/
								@Test(priority=7)
								public void verifyEditNATPageUrl()
								{
									
									WebDriver driver = WebDriverUtil.getDriver();
									PageFactory.initElements(driver, Firewall);
									
									try {
										FrameworkUtil.sTestCaseName = "Firewall-verifyEditNATPageUrl()";
										FrameworkUtil.sManualTestCaseName="QAT-1741_QAT-1739_WCP_5981_TC_1.3_NATSs-> Add, Edit & Delete NATs ->request parameter on page url";
										FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
										String sErrorMsg;
										String sURL=(String) FrameworkUtil.dictPropertyData.get("NAV.EDIT.FIREWALL.URL");
										int iRow=1;
										String sInterfaceName = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTMASH4077.FIREWALL.INTERFACENAME.INTERFACE1");
										String sInterfaceDesc = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTMASH4077.FIREWALL.INTERFACE1.DESCRIPTION");
										String sInterDestination =(String)FrameworkUtil.dictPropertyData.get("NAV.TSTMASH4077.FIREWALL.INTERFACE1.DESTINATION");
										//Login to Navigator
										com.whs.navigator.testcases.LoginTestCase.LoginAsQaautoAUser();
										TicketTestCase.navigateToTicketPage();
										EVDC_FirewallTestCase.NavigateToFirewallPage();
										FirewallRuleTestCase.expandInterface(sInterfaceName,sInterfaceDesc);
										WebObjectUtil.explicitWait(3);
										navVerifyURL(sURL);
										WebObjectUtil.clickElement(Firewall.getNav_AddFireWallLink());
										navVerifyURL(sURL);
										WebObjectUtil.clickElement(Firewall.getNav_FireWallRuleCancelButton());
										WebObjectUtil.explicitWait(5);
										WebElement wFWExpander=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.RULE.EXPANDER", "PARAMETER_ROWNUMBER",iRow+"");
										WebObjectUtil.clickElement(wFWExpander);
										WebObjectUtil.explicitWait(5);
										WebObjectUtil.clickElement(Firewall.getNav_FireWallRuleEditButton());
										WebObjectUtil.clickElement(Firewall.getNav_SourceTypeDropdownIcon());
										WebObjectUtil.selectCustomWebList(Firewall.getNav_SourceTypeDropdownList(), 1);
										WebObjectUtil.clickElement(Firewall.getNav_EditNatSaveRuleButton());
										WebObjectUtil.explicitWait(3);
										if(Common.getNav_CommonPopUp().isDisplayed()){
											sErrorMsg = Common.getNav_CommonPopUpMessage().getText();;
											FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verifying the edit error msg", "pass", "Error msg - "+sErrorMsg);
										WebObjectUtil.clickElement(Common.getNav_PopUpOKBtn());
										WebObjectUtil.explicitWait(5);
										}
										navVerifyURL(sURL);
										WebObjectUtil.clickElement(Firewall.getNav_FireWallRuleDeleteButton());
										navVerifyURL(sURL);
										com.whs.navigator.testcases.LoginTestCase.nav_Logout();
										} 
							   catch (Exception e) {
										LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
										FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
									
									}
									
								}
								
								/*==============================================================
								TestScript  	: verifyEditCatalogPageUrl
								Manual TestCase	: QAT-1738_WCP_5981_TC_1.1_Catalogs-> Move, Copy & Delete Catalog ->request parameter on page url
								Description		:
								Author 			: Priyanka
								Creation Date 	: 06/16/2015
								Release         : Zathras
								Pre-Requisites	:
								Revision History:
								==============================================================*/
									@Test(priority=8)
									public void verifyEditCatalogPageUrl()
									{
										
										WebDriver driver = WebDriverUtil.getDriver();
										PageFactory.initElements(driver, Firewall);
										
										try {
											FrameworkUtil.sTestCaseName = "Firewall-verifyEditCatalogPageUrl()";
											FrameworkUtil.sManualTestCaseName=" QAT-1738_WCP_5981_TC_1.1_Catalogs-> Move, Copy & Delete Catalog ->request parameter on page url";
											FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
											int iRow=1;
											
											String sUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.USERID.QAAUTO");
									    	String sPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.PWD.QAAUTO");
											String sURL=(String) FrameworkUtil.dictPropertyData.get("NAV.EDIT.FIREWALL.URL");
											String sInterfaceName = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTMASH4077.FIREWALL.INTERFACENAME.INTERFACE1");
											String sInterfaceDesc = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTMASH4077.FIREWALL.INTERFACE1.DESCRIPTION");
											String sInterDestination =(String)FrameworkUtil.dictPropertyData.get("NAV.TSTMASH4077.FIREWALL.INTERFACE1.DESTINATION");
											//Login to Navigator
											//com.whs.navigator.testcases.LoginTestCase.LoginAsQaautoAUser();
											
											EVDC_FirewallTestCase.navLoginAndNavigatetoNATSPage(sUserName,sPassword);
											navVerifyURL(sURL);
											/*//EVDC_FirewallTestCase.NavigateToFirewallPage();
											FirewallRuleTestCase.expandInterface(sInterfaceName,sInterfaceDesc);*/
											WebElement wNATExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.NAT.RULE.EXPANDER", "PARAMETER_ROWNUMBER", 1 +"");
									   		wNATExpander.click();
									   		WebObjectUtil.waitForElementPresent(Firewall.getNav_EditNATSRuleLink());
									   		WebObjectUtil.clickElement(Firewall.getNav_EditNATSRuleLink());
									   		WebObjectUtil.explicitWait(10);
									   		 WebObjectUtil.clickElement(Firewall.getNav_AddNatInsideInterfaceDropdown());
									   		  WebObjectUtil.selectCustomWebList(Firewall.getNav_AddNATBoundList(), 1);
									   		  WebObjectUtil.SetValueEdit(Firewall.getNav_PublicIpAddressEditBox(),"156.12.65.132");  
									   		  WebObjectUtil.SetValueEdit(Firewall.getNav_PrivateIPAddressEditBox(),"178.13.66.156");
									   		  WebObjectUtil.explicitWait(5);
									   		  WebObjectUtil.clickElement(Firewall.getNav_AddNATSaveRuleBtn());
									   		  WebObjectUtil.explicitWait(5);
									   		  WebObjectUtil.clickElement(Firewall.getNav_AddNatPopUpOKBtn());
								   		    navVerifyURL(sURL);
								   		 WebObjectUtil.clickElement(wNATExpander);
								   		 //Deleting the NAT
								   	 	WebObjectUtil.clickElement(Firewall.getNav_deleteButtonUnderNetwork());
								   	 	WebObjectUtil.explicitWait(2);
								   	 	WebObjectUtil.clickElement(Common.getNav_ConfirmPopUpOkBtn());
								   	 	WebObjectUtil.clickElement(Common.getNav_CommonPopUpOKButton());
								    	 navVerifyURL(sURL);
										    
											com.whs.navigator.testcases.LoginTestCase.nav_Logout();
											} 
								   catch (Exception e) {
											LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
											FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
										
										}
										
									}
							
									/*==============================================================
									TestScript  	: verifyEditVMPageUrl
									Manual TestCase	: QAT-1735_WCP_5981_TC_1.0_VM-> Add VM, Copy VM, Delete VM, Edit VM ->request parameter on page url
									Description		:
									Author 			: Priyanka
									Creation Date 	: 06/16/2015
									Release         : Zathras
									Pre-Requisites	:
									Revision History:
									==============================================================*/
										@Test(priority=9)
										public void verifyEditVMPageUrl()
										{
											
											WebDriver driver = WebDriverUtil.getDriver();
											PageFactory.initElements(driver, Firewall);
											
											try {
												FrameworkUtil.sTestCaseName = "Firewall-verifyEditVMPageUrl()";
												FrameworkUtil.sManualTestCaseName="QAT-1735_WCP_5981_TC_1.0_VM-> Add VM, Copy VM, Delete VM, Edit VM ->request parameter on page url";
												FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
												String sURL=(String) FrameworkUtil.dictPropertyData.get("NAV.EDIT.FIREWALL.URL");
												int iRow=1;
												String sInterfaceName = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTMASH4077.FIREWALL.INTERFACENAME.INTERFACE1");
												String sInterfaceDesc = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTMASH4077.FIREWALL.INTERFACE1.DESCRIPTION");
												String sInterDestination =(String)FrameworkUtil.dictPropertyData.get("NAV.TSTMASH4077.FIREWALL.INTERFACE1.DESTINATION");
												//Login to Navigator
												com.whs.navigator.testcases.LoginTestCase.LoginAsQaautoAUser();
												TicketTestCase.navigateToTicketPage();
												EVDC_FirewallTestCase.NavigateToFirewallPage();
												FirewallRuleTestCase.expandInterface(sInterfaceName,sInterfaceDesc);
												navVerifyURL(sURL);
												WebObjectUtil.explicitWait(3);
												WebObjectUtil.clickElement(Firewall.getNav_AddFireWallLink());
												navVerifyURL(sURL);
												WebObjectUtil.clickElement(Firewall.getNav_FireWallRuleCancelButton());
												WebObjectUtil.explicitWait(5);
												WebElement wFWExpander=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.RULE.EXPANDER", "PARAMETER_ROWNUMBER",iRow+"");
												WebObjectUtil.clickElement(wFWExpander);
												WebObjectUtil.explicitWait(5);
												WebObjectUtil.clickElement(Firewall.getNav_FireWallRuleEditButton());
												navVerifyURL(sURL);
												WebObjectUtil.clickElement(Firewall.getNav_FireWallRuleDeleteButton());
												navVerifyURL(sURL);
												com.whs.navigator.testcases.LoginTestCase.nav_Logout();
												} 
									   catch (Exception e) {
												LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
												FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
											
											}
											
										}
								
				/*==============================================================
				Method Name 	: navVerifyURL
				Description		: This will Verify Given URL 
				Author 			: Priyanka 
				Creation Date 	: 08/29/16
				Pre-Requisites	:
				Revision History:
				==============================================================*/
							public static void navVerifyURL(String sURL) 
							{
								WebDriver driver = WebDriverUtil.getDriver();
								PageFactory.initElements(driver, Ticket);
								
							try {
								
							String sActualUrl= driver.getCurrentUrl();
							if(sActualUrl.equalsIgnoreCase(sURL))
							{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verify URL", "pass", "Same URL is displayed : " +sURL );
							}else{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName,  "verify URL", "fail", "Same URL is not displayed : " +sActualUrl );
							}
							
							} catch (Exception e) {
							LoggerUtil.log_type_error("issue with navVerifyURL" );
							LoggerUtil.log_type_error(e.getMessage());
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
							}
							}			
				/*==============================================================
				Method Name 	: navVerifySourceSelectorValues
				Description		: This will Login to Navigator 
				Author 			: Priyanka 
				Creation Date 	: 06/16/2015
				Pre-Requisites	:
				Revision History:
				==============================================================*/
	
				public static void navVerifySourceSelectorValues() 
				{
				try {
					String sDefaultSourceVal,sVal;
				    sVal=(String) FrameworkUtil.dictPropertyData.get("NAV.VERIFY.DEFAULT.SOURCE.VAL");
					WebObjectUtil.explicitWait(5);
					WebObjectUtil.clickElement(Ticket.getNav_SourceDropdownField());
					WebObjectUtil.verifyElementPresent(Ticket.getNav_SourceAgiloftValue());
					WebObjectUtil.verifyElementPresent(Ticket.getNav_EM7Value());
					WebObjectUtil.clickElement(Ticket.getNav_SourceDropdownField());
					sDefaultSourceVal=(Ticket.getNav_SourceSelectorID()).getText();
					if(sVal.equalsIgnoreCase(sDefaultSourceVal))
					{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verify default Source value", "pass", "Value Displayed: " +sVal );
					}else{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName,  "verify default Source value", "warn", "Value not displayed" + sDefaultSourceVal + " and Clone ticket summary is : " + sVal  );
					}
					
					
				
				} catch (Exception e) {
				LoggerUtil.log_type_error("issue with navVerifySourceSelectorValues" );
				LoggerUtil.log_type_error(e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
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