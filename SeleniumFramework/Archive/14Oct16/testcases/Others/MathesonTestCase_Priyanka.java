package com.whs.navigator.testcases.Others;
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

import com.whs.navigator.commonUtil.CustomWebElementUtil;
import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.commonUtil.WebTableUtil;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.EVDC_VM_PageFactory;
import com.whs.navigator.pagefactory.EscalationPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.LoadBalancerPageFactory;
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

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class MathesonTestCase_Priyanka {
	public static boolean sLoginExpandVM = false ;
	public static HomePageFactory_old Home = new HomePageFactory_old();
	public static TicketPageFactory Ticket = new TicketPageFactory();
	public static TicketTestCase TicketTC =new TicketTestCase();
	public static SmokeTestPageFactory Smoke = new SmokeTestPageFactory();
	public static EVDC_VM_PageFactory EVDC_VMPF=new EVDC_VM_PageFactory();
	public static EVDC_OverviewPageFactory EVDC_OverviewPF = new EVDC_OverviewPageFactory();
	public static EVDC_FirewallPageFactory EVDC_FW= new EVDC_FirewallPageFactory();
	public static EntityBrowserPageFactory EBPanel = new EntityBrowserPageFactory();
	public static CommonPageFactory Common=new CommonPageFactory();
	public static DraasPageFactory Draas=new DraasPageFactory();
    public static FirewallPageFactory FireWall=new FirewallPageFactory();
	public static FormPageFactory Forms =new FormPageFactory();
	public static UserPermissionPageFactory UserPermission = new UserPermissionPageFactory(); 
	public static  EscalationPageFactory Escalation = new EscalationPageFactory();
   // public static EVDC_FirewallPageFactory EVDC_Firewall = new EVDC_FirewallPageFactory();
	/*==============================================================
	TestScript  	: verifyDeprovisionedTabRemoved
	Manual TestCase	: QAT-647-WCP_4557_TC_1.0_Escalation List_remove Deprovisioned List tab
	Description		: On Escalation List page, verify the Deprovisioned Users tab is removed.
	Author 			: Priyanka R
	Creation Date 	: 04/04/2016
	Pre-Requisites	: 
	Release         : Matheson
	Revision History:
		==============================================================*/
			@Test(priority=1)
			public void verifyDeprovisionedTabRemoved()
			{
				int iRow=1;
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, Ticket);
				PageFactory.initElements(driver, Home);
				PageFactory.initElements(driver, Smoke);
				PageFactory.initElements(driver, Forms);
				
				try{
				    FrameworkUtil.sTestCaseName = "verifyDeprovisionedTabRemoved";
					FrameworkUtil.sManualTestCaseName="QAT-647-WCP_4557_TC_1.0_Escalation List_remove Deprovisioned List tab";
			       	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			        
			       	//Login to Navigator Portlet
					LoginTestCase_Old1.LoginAsRoleAUser();
					UserPermissionTestCase.NavigateToCriticalEscalationListPage(); 
					WebObjectUtil.explicitWait(10);
					WebObjectUtil.verifyElementNOTPresent( Escalation.getNavDeprovisedUsersLisTab());
					LoginTestCase_Old1.nav_Logout();

				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navContactUsCreateticket", "warn", "catch block:" +e.getMessage());  
				}
			}
			
			/*==============================================================
			TestScript  	: verifyCoopersHawkOrgName
			Manual TestCase	: QAT-674-WCP_4570_TC_1.0_Tickets_Org name shows \_roll up on_select from organization drop down
			Description		: verify the org name doesn't show "\" (when an org has 's in the name - ex. cooper's hawk)
			Author 			: Priyanka R
			Creation Date 	: 04/04/2016
			Pre-Requisites	: 
			Release         : Matheson
			Revision History:
			================================================================*/
					@Test(priority=2)
					public void verifyCoopersHawkOrgName()
					{
						int iRow=1;
						WebDriver driver = WebDriverUtil.getDriver();
						PageFactory.initElements(driver, Ticket);
						PageFactory.initElements(driver, Home);
						PageFactory.initElements(driver, Smoke);
						PageFactory.initElements(driver, EBPanel);
						
						try{
							boolean bRollOn = true;
							String sItem="/";
						    String sOrgName= (String)FrameworkUtil.dictPropertyData.get("NAV.ORG.NAME.SEARCH.ENTITY.BROWSER");
						    FrameworkUtil.sTestCaseName = "verifyCoopersHawkOrgName";
							FrameworkUtil.sManualTestCaseName="QAT-674-WCP_4570_TC_1.0_Tickets_Org name shows roll up on_select from organization drop down";
					       	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					        
					       	
					       	//Login to Navigator Portlet
							LoginTestCase_Old1.LoginAsRoleAUser();
							WebObjectUtil.explicitWait(5);
							WebObjectUtil.clickElement(EBPanel.getNav_EBPanelHostedSolFooter());
							WebObjectUtil.explicitWait(10);
                            EntityBrowserTestCase.setRollOnOffEBPanel(bRollOn);
							WebObjectUtil.explicitWait(5);
							//WebObjectUtil.clickElement(EBPanel.getNav_EBPanelHostedSolFooter());
							//WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
							WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
							WebObjectUtil.explicitWait(8);
							TicketTestCase.navigateToTicketPage();
							WebObjectUtil.explicitWait(5);
							EntityBrowserTestCase.verifyTicketDataPresentForOrg(sOrgName);
							
							String sText= EBPanel.getNav_TicketsOrgDropdownlist().getText();
							WebObjectUtil.explicitWait(3);
							if(!(sText.contains(sItem)))
							{
							LoggerUtil.log_type_info(sItem +" is not present");
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName ,sItem , "pass","Verified");
							}
							else
							{
							LoggerUtil.log_type_error(sItem +" is present");
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName ,sItem , "fail"," not Verified");
							}
							
							
						}
						catch (Exception e) {
							// TODO Auto-generated catch block
							LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navContactUsCreateticket", "warn", "catch block:" +e.getMessage());  
						}
					}
						/*==============================================================
						TestScript  	: verifyFireWallRuleEditDisabled
						Manual TestCase	: QAT-726-WCP_4577_TC_1.0_Firewall rule-> System defined rule validation
						Description		: Verify that Disable Editing of rules when destination is "Any Less Secured network" 
						Author 			: Priyanka R
						Creation Date 	: 04/04/2016
						Pre-Requisites	: 
						Release         : Matheson
						Revision History:
						=================================================================*/
								@Test(priority=3)
								public void verifyFireWallRuleEditDisabled()
								{
									int iRow=1,i=0;
									WebDriver driver = WebDriverUtil.getDriver();
									PageFactory.initElements(driver, Ticket);
									PageFactory.initElements(driver, Home);
									PageFactory.initElements(driver, Smoke);
									PageFactory.initElements(driver, Forms);
									
									try{
										String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTMASH4077.USERID.POTTERS");
										String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTMASH4077.PWD.POTTERS");
										String sInterfaceName = (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.INTERFACENAME.INTERFACE1");
										String sInterfaceDesc = (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.INTERFACE1.DESCRIPTION");
										FrameworkUtil.sTestCaseName = "verifyFireWallRuleEditDisabled";
										FrameworkUtil.sManualTestCaseName="QAT-726-WCP_4577_TC_1.0_Firewall rule-> System defined rule validation";
								       	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
								      //Login to Navigator portlet 
										LoginTestCase_Old1.nav_Login(sUserName,sPassword);
								     // navigating to the firewall page
										EVDC_FirewallTestCase.NavigateToFirewallPage();
										AddFirewallRuleTestCase.expandInterface(sInterfaceName,sInterfaceDesc);
										WebObjectUtil.explicitWait(3);
										int iRowLength=WebTableUtil.getRowCount(FireWall.getNav_Interface1Table());
										WebObjectUtil.explicitWait(5);
										while(i<iRowLength)
										{
										WebElement wFWExpander=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.RULE.EXPANDER", "PARAMETER_ROWNUMBER",i+"");
										WebObjectUtil.explicitWait(5);
										WebObjectUtil.clickElement(wFWExpander);
										WebObjectUtil.explicitWait(5);
										//if(FireWall.getNav_EditSuccessMsg().isDisplayed())
										if(Common.getNav_UsrFeedBack().isDisplayed())
										{
											LoggerUtil.log_type_info("You Cannot currently edit system defined rules");
											FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName ,"" , "pass","Verified");
	                                        break;
										}
										else
										{
											i++;
										}
										//break;
										}
						                
										LoginTestCase_Old1.nav_Logout();
								}
								catch (Exception e) {
									// TODO Auto-generated catch block
									LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
									FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navContactUsCreateticket", "warn", "catch block:" +e.getMessage());  
								}
}
								/*==============================================================
								TestScript  	: verifyEVDCPortlet
								Manual TestCase	: QAT-388-WCP_4380_TC_1.0_EVDC Landing Page Refactor on UI view
								Description		: Verify the refactored EVDC portlet on Landing page. 
								Author 			: Priyanka R
								Creation Date 	: 04/04/2016
								Pre-Requisites	: 
								Release         : Matheson
								Revision History:
								================================================================*/
										@Test(priority=4)
										public void verifyEVDCPortlet()
										{
											int iRow=1,i=0;
											String sActualCloud,sActualShared,sActualPrivate;
											String sCloudTitle=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.CLOUD.SERVICE.TITLE");
											String sSharedTitle=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.CLOUD.SHARED");
											String sPrivateTitle=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.CLOUD.PRIVATE");
											WebDriver driver = WebDriverUtil.getDriver();
											PageFactory.initElements(driver, Ticket);
											PageFactory.initElements(driver, Home);
											PageFactory.initElements(driver, Smoke);
											PageFactory.initElements(driver, Forms);
											
											try{
												FrameworkUtil.sTestCaseName = "verifyEVDCPortlet";
												FrameworkUtil.sManualTestCaseName="QAT-388-WCP_4380_TC_1.0_EVDC Landing Page Refactor on UI view";
										       	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

												LoginTestCase_Old1.LoginAsGirUser();
												WebObjectUtil.explicitWait(10);
												WebObjectUtil.verifyElementPresent(Home.getNav_CloudServicesArea());
												WebObjectUtil.explicitWait(5);
												sActualCloud=Home.getNav_CloudServicesTitle().getText().trim();
												WebObjectUtil.explicitWait(5);
												WebElement wb = Home.getNav_EVDCShared();
												sActualShared=Home.getNav_EVDCShared().getText().trim();
												WebObjectUtil.explicitWait(5);
												sActualPrivate=(Home.getNav_EVDCPrivate().getText()).trim();
												
												if(sActualCloud.equalsIgnoreCase(sCloudTitle))
												{
													FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verify Title", "pass", "Displayed Title is : " + sActualCloud );
												}else{
													FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName,  "Verify Title", "fail", "Displayed Title is : " +sActualCloud  + " and actual title should be : " + sCloudTitle  );
												}
											
												if(sActualShared.equalsIgnoreCase(sSharedTitle))
												{
													FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verify Title", "pass", "Displayed Title is : " +sActualShared);
												}else{
													FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName,  "Verify Title", "fail", "Displayed Title is : " +sActualShared  + " and actual title should be : " + sSharedTitle  );
												}
												
												if(sActualPrivate.equalsIgnoreCase(sPrivateTitle))
												{
													FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verify Title", "pass", "Displayed Title is : " +sActualPrivate);
												}else{
													FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName,  "Verify Title", "fail", "Displayed Title is : " +sActualPrivate  + " and actual title should be : " + sPrivateTitle  );
												}
												LoginTestCase_Old1.nav_Logout();
												
											}
											catch (Exception e) {
												// TODO Auto-generated catch block
												LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
												FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navContactUsCreateticket", "warn", "catch block:" +e.getMessage());  
											}
			}

										/*==============================================================
										TestScript  	: verifyNewEVDCDetails()
										Manual TestCase	: QAT-732-780-WCP_3702_TC_1.0_MSG Bus-Org Create-VDC Network
										Description		: Verify that created VDC network in VCD displayed correctly in navigator. 
										Author 			: Priyanka R
										Creation Date 	: 04/19/2016
										Pre-Requisites	: FIRST EVDC NAME, NETWORK NAME
										Release         : Matheson
										Revision History:
										================================================================*/
												@Test(priority=4)
												public void verifyNewEVDCDetails()
												{	
													WebDriver driver = WebDriverUtil.getDriver();
													PageFactory.initElements(driver, EVDC_OverviewPF);
													PageFactory.initElements(driver, Home);
													try{
														FrameworkUtil.sTestCaseName = "verifyNewEVDCDetails()";
														FrameworkUtil.sManualTestCaseName=" QAT-732-780-WCP_3702_TC_1.0_MSG Bus-Org Create-VDC Network";
												       	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
												       	String sActualEVDC,sEVDCName,sNetworkName,sActualNetworkName;
														sEVDCName=(String)FrameworkUtil.dictPropertyData.get("NAV.VCLOUD.EVDCNAME.CHECK");
														sNetworkName=(String)FrameworkUtil.dictPropertyData.get("NAV.VCLOUD.NETWORKNAME.CHECK");
														LoginTestCase_Old1.LoginAsDevcoUser();
														//LoginTestCase.LoginAsQaautoUser();
														WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCname());
														sActualEVDC=EVDC_OverviewPF.getNav_EVDCname().getText();
														//WebObjectUtil.VerifyTextUnderElement(EVDC_OverviewPF.getNav_EVDCname(), sText)
														if(sEVDCName.equalsIgnoreCase(sActualEVDC))
														{
															FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "The new EVDC Name is Verified", "pass", "Displayed Title is : " +sActualEVDC);
														}
														else{
															FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName,  "Please verify manually, if EVDC name has been newly updated", "fail", "Displayed Title is : " +sActualEVDC  + " and actual title should be : " +sEVDCName);
														}
                                                       // EVDC_VM_TestCase.getEVDCNameAsWebElement(sEVDCName);
														
														WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
														WebObjectUtil.explicitWait(10);
														WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCFirstNetworkName());
														sActualNetworkName=EVDC_OverviewPF.getNav_EVDCFirstNetworkName().getText().trim();
														if(sNetworkName.equalsIgnoreCase(sActualNetworkName))
														{
															FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "The new Network Name is Verified", "pass", "Displayed Title is : " +sActualNetworkName);
														}
														else{
															FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName,  "Please verify manually, if Network name has been newly updated", "fail", "Displayed Title is : " +sActualNetworkName  + " and actual title should be : " +sNetworkName);
														}
														LoginTestCase_Old1.nav_Logout();
													
												}
												catch (Exception e) {
													// TODO Auto-generated catch block
													LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
													FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception Occured", "warn", "catch block:" +e.getMessage());  
												}	
												}
												
												/*==============================================================
												TestScript  	: verifyEVDCStoragePolicies
												Manual TestCase	: QAT-782-WCP_3702_TC_1.3_MSG Bus-VDC Storage Policies
												Description		: Verify that created VDC Storage Policies in VCD displayed correctly in navigator
												Author 			: Priyanka R
												Creation Date 	: 04/19/2016
												Pre-Requisites	: 
										        Release         : Matheson
												Revision History:
												================================================================*/
														@Test(priority=5)
														public void verifyEVDCStoragePolicies()
														{	
															WebDriver driver = WebDriverUtil.getDriver();
															PageFactory.initElements(driver, EVDC_OverviewPF);
															PageFactory.initElements(driver, Home);
															try{
																FrameworkUtil.sTestCaseName = "verifyEVDCStoragePolicies";
																FrameworkUtil.sManualTestCaseName=" QAT-782-WCP_3702_TC_1.3_MSG Bus-VDC Storage Policies";
														       	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
														       	LoginTestCase_Old1.LoginAsDevcoUser();
																WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
																WebObjectUtil.explicitWait(15);
																WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCOverviewStorage());
																WebObjectUtil.explicitWait(5);
																WebObjectUtil.verifyElementPresent(EVDC_OverviewPF.getNav_EVDCStorageProfileChart());
															}
															catch (Exception e) {
																// TODO Auto-generated catch block
																LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
																FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception Occured", "warn", "catch block:" +e.getMessage());  
															}	
															}
														/*==============================================================
														TestScript  	: verifyEVDCEditVM()
														Manual TestCase	: QAT-727-WCP_4300_TC_1.0_MSG Bus-Edit VM
														Description		: Verify that Navigator VM edits are displayed immediately in VCD 
														Author 			: Priyanka R
														Creation Date 	: 04/19/2016
														Pre-Requisites	: 
												        Release         : Matheson
														Revision History:Revised from navValAdd10NIC() by Vivek
														================================================================*/
																@Test(priority=6)
																public void verifyEVDCEditVMandChkVCD()
																{	
																	WebDriver driver = WebDriverUtil.getDriver();
																	PageFactory.initElements(driver, EVDC_OverviewPF);
																	PageFactory.initElements(driver, Home);
																	String sVMStatus,sExpUserMessage,sActUserMessage;
																	int iRowNbr, iRows,iCount,iNICMaxCnt;
																	try{
																		FrameworkUtil.sTestCaseName = "verifyEVDCEditVMandChkVCD";
																		FrameworkUtil.sManualTestCaseName=" QAT-782-WCP_3702_TC_1.3_MSG Bus-VDC Storage Policies";
																       	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
																       	
																       	sExpUserMessage=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.NIC.LIMIT.MSG");
																		//iNICMaxCnt=Integer.parseInt((String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.NIC.MAXCOUNT"));
																       	iNICMaxCnt=2;
																       	String sVMNameorStatus=(String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.UNIX.VMNAME.OR.STATUS");
																       	LoginTestCase_Old1.LoginAsQaautoAUser();
																       	QAautoaEVDCLoginAndExpand(sVMNameorStatus);
																       	//EVDC_VM_AdvancedActions.navigateAndExpandVM(sVMNameorStatus);
																		iRowNbr = EVDC_VM_AdvancedActions.iVisibleVMRowNum;
																		EVDC_VM_TestCase.stopRunningVM(iRowNbr);
																		
																		//clicking Edit Button
																		//Verifying and Clicking on Edit button
																		EVDC_VM_TestCase.navVerifyClkEditBtn(iRowNbr);
																		
																		EVDC_VM_TestCase.navChkEnableGuestCustomization();
																		EVDC_VM_AdvancedActions.expandVMbyRowNum(iRowNbr);
																		EVDC_VM_TestCase.navVerifyClkEditBtn(iRowNbr);
																		
																		//Clicking NICs Tab
																		WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditNICs());
																		//Getting the NIC row count
																		iRows=WebTableUtil.getRowCount(EVDC_VMPF.getNav_NICWebTable());
																	//	System.out.println(iRows)
																		
																		if(iRows<iNICMaxCnt)
																		{
																			iCount=iNICMaxCnt-iRows;
																			for(int i=1;i<=iCount;i++)
																			{
																				//Clicking on Add NIC link
																				WebObjectUtil.clickElement(EVDC_VMPF.getNav_NICsAddNIC());
																			}
																		}
																		iRows=WebTableUtil.getRowCount(EVDC_VMPF.getNav_NICWebTable());
																		if(iRows==iNICMaxCnt)
																		{
																			WebObjectUtil.clickElement(EVDC_VMPF.getNav_NICsAddNIC());
																			sActUserMessage=EVDC_VMPF.getNav_UserfeedBack().getText();
																			//validating Actual message and Expected message
																			if(WebObjectUtil.compareString(sExpUserMessage, sActUserMessage, true))
																			{
																				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , sExpUserMessage , "pass"," user can add 10 Nics successfully.") ;
																				LoggerUtil.log_type_info(" Message Verified  = " +sExpUserMessage + " i.e.user can add 10 Nics successfully.");
																				
																			}
																			else
																			{
																				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Message not Verified"   , "fail", "Expected :"+sExpUserMessage +", Actual :"+sActUserMessage);
																				LoggerUtil.log_type_error(" Message not Verified  =  " +sExpUserMessage );
																			}
																		}
																		else
																		{
																			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Total NIC after adding " + iRows   , "fail", "");
																			LoggerUtil.log_type_error(" Total NIC after adding  =  " +iRows );
																		}
																		//Closing Window
																		WebObjectUtil.clickElement(EVDC_VMPF.getNav_EditGeneralCloseBtn());
																	}
																	catch (Exception e) {
																		// TODO Auto-generated catch block
																		LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
																		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception Occured", "warn", "catch block:" +e.getMessage());  
																	}	
																	}
																/*==============================================================
																TestScript  	: verifyGOMSortingDisabled()
																Manual TestCase	: QAT-729-WCP_4575_TC_1.0_EVDC ->GOM- Sorting column
																Description		: Verify that Sorting columns are disabled in GOM page 
																Author 			: Priyanka R
																Creation Date 	: 04/19/2016
																Pre-Requisites	: 
														        Release         : Matheson
																Revision History:
																================================================================*/
																		@Test(priority=7)
																		public void verifyGOMSortingDisabled()
																		{	
																			WebDriver driver = WebDriverUtil.getDriver();
																			PageFactory.initElements(driver, EVDC_OverviewPF);
																			PageFactory.initElements(driver, FireWall);
																			PageFactory.initElements(driver, EVDC_FW);
																			
																			try{
																				int iRow = 0,j;
																				FrameworkUtil.sTestCaseName = "verifyGOMSortingDisabled";
																				FrameworkUtil.sManualTestCaseName="QAT-729-WCP_4575_TC_1.0_EVDC ->GOM- Sorting column";
																		       	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
																		       	
																		       	LoginTestCase_Old1.LoginAsQaautoAUser();
																		       	WebObjectUtil.explicitWait(5);
																		       	WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
																		        WebObjectUtil.waitForElementPresent(EVDC_OverviewPF.getNav_EVDCOverviewFirewall());
																		       	WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCOverviewFirewall());
																		       	//WebObjectUtil.waitForElementPresent(FireWall.getNav_FirewallTable());
																		       	WebObjectUtil.explicitWait(10);
																		        WebObjectUtil.clickElement(EVDC_FW.getNav_GOMLink());
																		        WebObjectUtil.explicitWait(EVDC_FW.getNav_GOMPopup());
																		        WebObjectUtil.clickElement(EVDC_FW.getNav_NetworkObjectExpander());
																		        WebObjectUtil.explicitWait(EVDC_FW.getNav_NetworkExpander());
																		        WebObjectUtil.clickElement(EVDC_FW.getNav_NetworkExpander());
																		        WebObjectUtil.explicitWait(EVDC_FW.getNav_NetworkObjectsTable());
																		        int iRowLength=WebTableUtil.getRowCount(EVDC_FW.getNav_NetworkObjectsTable());
																		        verifyColumnSortingDisabled(iRowLength);
																		        for(j=2;j<iRowLength;j++)
																		        {
																		        WebElement wRowExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.NETWORK.SERVICE.OBJECT.EXPANDER", "PARAMETER_ROWNUMBER", j+""); 
																		        if(wRowExpander.isDisplayed())
																		        {
																		        	
																		        	wRowExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.NETWORK.SERVICE.OBJECT.EXPANDER", "PARAMETER_ROWNUMBER", j+"");
																		        	WebObjectUtil.clickElement(wRowExpander);
																		        	
																		        	break;
																		        	
																		        }
																		        }
																		        
																		        iRow=j+1;
																		        
																		        verifyColumnSortingDisabled(iRow);
																		        
																		        
																		        
																			}
																			catch (Exception e) {
																				// TODO Auto-generated catch block
																				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
																				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception Occured", "warn", "catch block:" +e.getMessage());  
																			}	
																			}
																//#################################Methods############################
															    //####################################################################
																
																		/*==============================================================
																		Method Name 	: verifyColumnSortingDisabled()
																		Description		: This will verify whether sorting disabled or not
																		Author 			: Priyanka Rachupalli
																		Creation Date 	: 01/12/2016
																		Pre-Requisites	:
																		Revision History:
																		==============================================================*/

																			public static void verifyColumnSortingDisabled(int iRowLength) 
																			{
																				WebDriver driver = WebDriverUtil.getDriver();
																				PageFactory.initElements(driver, EVDC_FW);
																			try {
																				String sRowText,sRowText1,sRowText2,sRowText3,sRowText4,sRowText5;
																			if(iRowLength>1)
																			{
																			for(int i=1;i<=2;i++)
																			{
																			WebElement wRowElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.NETWORK.OBJECT.ROW.ELEMENT", "PARAMETER_ROWNUMBER", i+""); 
																			sRowText=wRowElement.getText();	
																			WebObjectUtil.clickElement(EVDC_FW.getNav_Network_StartIpAddressColumnName());
																			sRowText1=wRowElement.getText();
																			WebObjectUtil.clickElement(EVDC_FW.getNav_Network_EndIpAddressColumnName());
																			sRowText2=wRowElement.getText();
																			WebObjectUtil.clickElement(EVDC_FW.getNav_Network_NetmaskColumnName());
																			sRowText3=wRowElement.getText();
																			WebObjectUtil.clickElement(EVDC_FW.getNav_Network_ObjectNatColumnName());
																			sRowText4=wRowElement.getText();
																			WebObjectUtil.clickElement(EVDC_FW.getNav_Network_DescriptionColumnName());
																			sRowText5=wRowElement.getText();
																			
																			if(sRowText.equalsIgnoreCase(sRowText1))
																			{
																				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verify Title", "pass", "Displayed Title is : " + sRowText );
																			}else{
																				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName,  "Verify Title", "fail", "Displayed Title is : " +sRowText1  + " and actual title should be : " + sRowText);
																			}
																			if(sRowText.equalsIgnoreCase(sRowText2))
																			{
																				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verify Title", "pass", "Displayed Title is : " + sRowText );
																			}else{
																				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName,  "Verify Title", "fail", "Displayed Title is : " +sRowText2  + " and actual title should be : " + sRowText);
																			}
																			if(sRowText.equalsIgnoreCase(sRowText3))
																			{
																				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verify Title", "pass", "Displayed Title is : " + sRowText );
																			}else{
																				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName,  "Verify Title", "fail", "Displayed Title is : " +sRowText3  + " and actual title should be : " + sRowText);
																			}
																			if(sRowText.equalsIgnoreCase(sRowText4))
																			{
																				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verify Title", "pass", "Displayed Title is : " + sRowText );
																			}else{
																				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName,  "Verify Title", "fail", "Displayed Title is : " +sRowText4  + " and actual title should be : " + sRowText);
																			}
																			if(sRowText.equalsIgnoreCase(sRowText5))
																			{
																				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Verify Title", "pass", "Displayed Title is : " + sRowText );
																			}else{
																				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName,  "Verify Title", "fail", "Displayed Title is : " +sRowText5  + " and actual title should be : " + sRowText);
																			}

																			}
																			}
																			}
																			catch (Exception e) {
																				// TODO Auto-generated catch block
																				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
																				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception Occured", "warn", "catch block:" +e.getMessage());  
																			}
																			}
																			
																					
																		public static void QAautoaEVDCLoginAndExpand(String sVMNameorStatus)
																{
																	sLoginExpandVM = false ;
																	
																	if (!sLoginExpandVM){
																		//sLoginExpandVM = EVDC_VM_AdvancedActions_EXTJS.navigateAndExpandVM("Stopped");
																		sLoginExpandVM = LoginTestCase_Old1.LoginAsEVDCQaautoaUser();
																		EVDC_VM_AdvancedActions.navigateAndExpandVM(sVMNameorStatus);	
																		
																	}
																	else
																	{
																		EVDC_VM_AdvancedActions.refreshAndExpandVM(sVMNameorStatus);
																	}
																	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Get VM and its State" , "VM Name and State ", "Done", EVDC_VM_AdvancedActions.sVMName + "//"+ EVDC_VM_AdvancedActions.sVMstatus);
																}
																	
					//update each @test result in custom result file
					@AfterMethod
					public static void afterEachMethod(){
					FrameworkUtil.updateTestCaseStatusinResult();
					}
}
