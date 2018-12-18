package com.whs.navigator.testcases.Lefcourt;
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
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class LefCourt_SP2TestCase_Priyanka {
	public static HomePageFactory_old Home = new HomePageFactory_old();
	public static TicketPageFactory Ticket = new TicketPageFactory();
	public static TicketTestCase TicketTC =new TicketTestCase();
	public static SmokeTestPageFactory Smoke = new SmokeTestPageFactory();
	public static EVDC_VM_PageFactory EVDC_VMPF=new EVDC_VM_PageFactory();
	public static EVDC_OverviewPageFactory EVDC_OverviewPF = new EVDC_OverviewPageFactory();
	public static EntityBrowserPageFactory EBPanel = new EntityBrowserPageFactory();
	public static CommonPageFactory Common=new CommonPageFactory();
	public static DraasPageFactory Draas=new DraasPageFactory();
	public static FirewallPageFactory FireWall=new FirewallPageFactory();
	public static FormPageFactory Forms =new FormPageFactory();
	public static UserPermissionPageFactory UserPermission = new UserPermissionPageFactory(); 

	/*==============================================================
	TestScript  	: verifyCancelDeleteFirewallRule
	Manual TestCase	: QAT-467-WCP_3031_TC_1.1_Firewall-> Delete Firewall rule- >Confirmation message ->Cancel
	Description		: Verify that Edit the existing firewall rule successfully with diff destination address and status.
	Author 			: Priyanka R
	Creation Date 	: 02/05/2016
	Pre-Requisites	:
	Release Name    : LefCourt SP2
	Revision History:
	==============================================================*/
			@Test(priority=1)
			public void verifyCancelDeleteFirewallRule()
			{
				int iRow=1;
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, Ticket);
				PageFactory.initElements(driver, Home);
				PageFactory.initElements(driver, Smoke);
				PageFactory.initElements(driver, Forms);
				
				try{
				    FrameworkUtil.sTestCaseName = " verifyCancelDeleteFirewallRule";
					FrameworkUtil.sManualTestCaseName=" QAT-467-WCP_3031_TC_1.1_Firewall-> Delete Firewall rule- >Confirmation message ->Cancel";
			       	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			        //Login to Navigator
			        String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.ENTITY02.USERID");
					
					String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.PASSWORD");
					
					String sDeleteFirewallMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.DELETE.FIREWALL.POPUP.MSG");
					
					String sInterfaceName= (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.INTERFACENAME.INTERFACE1");

					String sInterfaceDesc= (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.INTERFACE1.DESCRIPTION");
					
					//Login to Navigator Portlet
					LoginTestCase_Old1.nav_Login(sUserName,sPassword);
					/*WebObjectUtil.explicitWait(Home.getNav_HomeEVDCPortlet());
					
					WebObjectUtil.clickElement(FireWall.getNav_FirewallViewLink());*/
					
					// navigating to the firewall page
					EVDC_FirewallTestCase.NavigateToFirewallPage();
					WebObjectUtil.explicitWait(10);
					/*WebObjectUtil.clickElement(FireWall.getNav_SecondFirewallRuleExpander());
					WebObjectUtil.explicitWait(5);
					WebElement wFireWallRuleExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.NAT.RULE.EXPANDER", "PARAMETER_ROWNUMBER", iRow+"");
					WebObjectUtil.clickElement(wFireWallRuleExpander);
					*/
				    expandInterface(sInterfaceName,sInterfaceDesc);
					WebObjectUtil.explicitWait(5);
					//Click on Delete icon
					WebObjectUtil.clickElement(FireWall.getNav_FirewallRuleDeleteIcon());
					WebObjectUtil.explicitWait(5);
					//verify delete firewall pop-up message 
					WebObjectUtil.verifyElementPresent(FireWall.getNav_DeleteFirewallPopUp());
					String sActualMsg=(FireWall.getNav_DeleteFirewallPopUpMsg().getText()).trim();
					
					boolean bStatus = (sDeleteFirewallMsg.equalsIgnoreCase(sActualMsg));
				    FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Message Displayed :"+sActualMsg);
				    //Verify delte firewall pop up buttons
				    WebObjectUtil.verifyElementPresent(FireWall.getNav_DeleteFirewallPopupOkBtn());
				    WebObjectUtil.clickElement(FireWall.getNav_FirewallDeletePopUpCancelBtn());
				    
				    
				}
					catch (Exception e) {
						// TODO Auto-generated catch block
						LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navContactUsCreateticket", "warn", "catch block:" +e.getMessage());  
					}	
			}
			
			/*===============================================================
			TestScript  	: verifyDeleteAllFirewallRules
			Manual TestCase	: QAT-466-WCP_3031_TC_1.1_Firewall-> Delete Firewall rule- >Confirmation message ->Cancel
			Description		: Verify that user is able to delete the existing firewall rules successfully 
			Author 			: Priyanka R
			Creation Date 	: 02/05/2016
			Pre-Requisites	:
			Release Name    : LefCourt SP2
			Revision History:
			================================================================*/
					//@Test(priority=2)
					public void verifyDeleteAllFirewallRules()
					{
						int iRow=1;
						WebDriver driver = WebDriverUtil.getDriver();
						PageFactory.initElements(driver, Ticket);
						PageFactory.initElements(driver, Home);
						PageFactory.initElements(driver, Smoke);
						PageFactory.initElements(driver, Forms);
						
						try{
						    FrameworkUtil.sTestCaseName = " verifyDeleteAllFirewallRules";
							FrameworkUtil.sManualTestCaseName=" QAT-466-WCP_3031_TC_1.0_Firewall-> Delete Firewall rule";
					       	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					        //Login to Navigator
					        String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.ENTITY02.USERID");
							
							String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.PASSWORD");
							//Login to Navigator Portlet
							LoginTestCase_Old1.nav_Login(sUserName,sPassword);
							/*WebObjectUtil.explicitWait(Home.getNav_HomeEVDCPortlet());
							WebObjectUtil.clickElement(FireWall.getNav_FirewallViewLink());*/
							// navigating to the firewall page
							EVDC_FirewallTestCase.NavigateToFirewallPage();
							WebObjectUtil.explicitWait(10);
							/*WebObjectUtil.clickElement(FireWall.getNav_SecondFirewallRuleExpander());
							WebObjectUtil.explicitWait(5);
							WebElement wFireWallRuleExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.NAT.RULE.EXPANDER", "PARAMETER_ROWNUMBER", iRow+"");
							WebObjectUtil.clickElement(wFireWallRuleExpander);
							WebObjectUtil.explicitWait(5);*/
							//Click on Delete
							WebObjectUtil.clickElement(FireWall.getNav_FirewallRuleDeleteIcon());
							WebObjectUtil.explicitWait(5);
							//click on OK for delete pop-up
							WebObjectUtil.clickElement(FireWall.getNav_FirewallDeletePopUpOkBtn());
							WebObjectUtil.explicitWait(300);
						    
							//yet to add for loop to delete all fire wall rules							
							
						}
							catch (Exception e) {
								// TODO Auto-generated catch block
								LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navContactUsCreateticket", "warn", "catch block:" +e.getMessage());  
							}	
					}
					/*===============================================================
					TestScript  	: verifyMoveFirewallRule
					Manual TestCase	: QAT-539-WCP_3031_TC_2.5_Firewall ->Move Firewall rule_QAT-538-WCP_3031
					Description		: Verify the move Firewall rule functionality is working correctly.
					Author 			: Priyanka R
					Creation Date 	: 02/10/2016
					Pre-Requisites	:
					Release Name    : LefCourt SP2
					Revision History:
					================================================================*/
							@Test(priority=3)
							public void verifyMoveFirewallRule()
							{
								int iRow=1;
								WebDriver driver = WebDriverUtil.getDriver();
								PageFactory.initElements(driver, Ticket);
								PageFactory.initElements(driver, Home);
								PageFactory.initElements(driver, Smoke);
								PageFactory.initElements(driver, Forms);
								
								try{
								    FrameworkUtil.sTestCaseName = " verifyMoveFirewallRule";
									FrameworkUtil.sManualTestCaseName="  QAT-539-WCP_3031_TC_2.5_Firewall ->Move Firewall rule_QAT-538-WCP_3031";
							       	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
							        //Login to Navigator
							        String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.ENTITY02.USERID");
									
									String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.PASSWORD");
									
									String sInterfaceName= (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.INTERFACENAME.INTERFACE1");

									String sInterfaceDesc= (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.INTERFACE1.DESCRIPTION");
									//Login to Navigator Portlet
									LoginTestCase_Old1.nav_Login(sUserName,sPassword);
									/*WebObjectUtil.explicitWait(Home.getNav_HomeEVDCPortlet());
									WebObjectUtil.clickElement(FireWall.getNav_FirewallViewLink());*/
									// navigating to the firewall page
									EVDC_FirewallTestCase.NavigateToFirewallPage();
									WebObjectUtil.explicitWait(10);
									/*WebObjectUtil.clickElement(FireWall.getNav_SecondFirewallRuleExpander());
									WebObjectUtil.explicitWait(5);
									WebElement wFireWallRuleExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.NAT.RULE.EXPANDER", "PARAMETER_ROWNUMBER", iRow+"");
									WebObjectUtil.clickElement(wFireWallRuleExpander);*/
									expandInterface(sInterfaceName,sInterfaceDesc);
									WebObjectUtil.explicitWait(5);
									//verify all fields displayed for move firewall 
									verifyMoveFirewallFields();
									WebObjectUtil.clickElement(FireWall.getNav_MoveLink());
									WebObjectUtil.verifyElementNOTPresent(FireWall.getNav_EditSuccessMsg());
									//Verify Firewall sequence number is displayed
									WebObjectUtil.isElementPresent(FireWall.getNav_FirewallSeqNum());
									WebObjectUtil.SetValueEdit(FireWall.getNav_FirewallSeqNum(), "2");
									WebObjectUtil.clickElement(FireWall.getNav_SaveEditsLink());
									WebObjectUtil.waitForElementPresent(FireWall.getNav_DeleteFirewallPopUp());
									WebObjectUtil.clickElement(FireWall.getNav_FirewallDeletePopUpOkBtn());
									WebObjectUtil.waitForElementPresent(Common.getNav_CommonPopUp());
									WebObjectUtil.clickElement(Common.getNav_CommonPopUpOKButton());
									WebObjectUtil.explicitWait(5);
									WebObjectUtil.verifyElementPresent(FireWall.getNav_EditSuccessMsg());
									WebObjectUtil.explicitWait(600);
									//click on refresh
									driver.navigate().refresh();
                                    //include sequence check
									
									
								}
								catch (Exception e) {
									// TODO Auto-generated catch block
									LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
									FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navContactUsCreateticket", "warn", "catch block:" +e.getMessage());  
								}	
						}
							/*===============================================================
							TestScript  	: verifyEditFireWallScreen
							Manual TestCase	: QAT-274-WCP_3031_TC_1.1_EVDC_Firewall Rules_Edit Friewall Screen
							Description		: Verify the Edit Firewall Rule pop up display on Firewall Rules page.
							Author 			: Priyanka R
							Creation Date 	: 03/08/2016
							Pre-Requisites	:
							Release Name    : LefCourt SP2
							Revision History:
							================================================================*/
									@Test(priority=4)
									public void verifyEditFireWallScreen()
									{
										WebDriver driver = WebDriverUtil.getDriver();
										PageFactory.initElements(driver, Ticket);
										PageFactory.initElements(driver, Home);
										PageFactory.initElements(driver, Smoke);
										PageFactory.initElements(driver, Forms);
									try
 									{
										int iRow=1;
										FrameworkUtil.sTestCaseName = "verifyEditFireWallScreen";
										FrameworkUtil.sManualTestCaseName="QAT-274-WCP_3031_TC_1.1_EVDC_Firewall Rules_Edit Friewall Screen";
								       	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
								        //Login to Navigator
								        String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.ENTITY02.USERID");
										
										String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.PASSWORD");
										
										String sDropDownItems=(String)FrameworkUtil.dictPropertyData.get("NAV.SOURCETYPE.DROPDOWN.ITEMS");
										
										String sDropDownItems1=(String)FrameworkUtil.dictPropertyData.get("NAV.DESTINATIONTYPE.DROPDOWN.ITEMS");
										
										String sDropDownItems2=(String)FrameworkUtil.dictPropertyData.get("NAV.SERVICETYPE.DROPDOWN.ITEMS");
										
										String sDropDownItems3=(String)FrameworkUtil.dictPropertyData.get("NAV.PROTOCOL.DROPDOWN.ITEMS");
										
										String sInterfaceName= (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.INTERFACENAME.INTERFACE1");

										String sInterfaceDesc= (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.INTERFACE1.DESCRIPTION");
										//Login to Navigator Portlet
										LoginTestCase_Old1.nav_Login(sUserName,sPassword);
										/*WebObjectUtil.explicitWait(Home.getNav_HomeEVDCPortlet());
										WebObjectUtil.clickElement(FireWall.getNav_FirewallViewLink());*/
										// navigating to the firewall page
										EVDC_FirewallTestCase.NavigateToFirewallPage();
										WebObjectUtil.explicitWait(10);
										/*WebObjectUtil.clickElement(FireWall.getNav_SecondFirewallRuleExpander());
										WebObjectUtil.explicitWait(5);
										WebElement wFireWallRuleExpander = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.NAT.RULE.EXPANDER", "PARAMETER_ROWNUMBER", iRow+"");
										WebObjectUtil.clickElement(wFireWallRuleExpander);*/
										expandInterface(sInterfaceName,sInterfaceDesc);
										WebObjectUtil.explicitWait(5);
										WebObjectUtil.clickElement(FireWall.getNav_EditLink());
										WebObjectUtil.explicitWait(5);
										WebObjectUtil.verifyElementPresent(FireWall.getNav_SequenceNumberinFirewallRuleTable());
										WebObjectUtil.clickElement(FireWall.getNav_SourceTypeDropdownArrow());
										WebObjectUtil.explicitWait(3);
										String sActualDropDownItems=WebObjectUtil.getCustomWebListItems(Ticket.getNav_SearchByDropdown()).trim();
										WebObjectUtil.explicitWait(3);
										verifySourceTypeDropdown(sDropDownItems, sActualDropDownItems);
										WebObjectUtil.selectCustomWebList(Ticket.getNav_SearchByDropdown(), "Group Object");
										WebObjectUtil.clickElement(FireWall.getNav_DestinationTypeDropdownArrow());
										WebObjectUtil.explicitWait(3);
										String sActualDropDownItems1=WebObjectUtil.getCustomWebListItems(Ticket.getNav_SearchByDropdown()).trim();
										WebObjectUtil.explicitWait(3);
										verifyDestinationTypeDropdown(sDropDownItems1, sActualDropDownItems1);
										WebObjectUtil.selectCustomWebList(Ticket.getNav_SearchByDropdown(), "Group Object");
										WebObjectUtil.clickElement(FireWall.getNav_ServiceTypeDropdownArrow());
										WebObjectUtil.explicitWait(3);
										String sActualDropDownItems2=WebObjectUtil.getCustomWebListItems(Ticket.getNav_SearchByDropdown()).trim();
										WebObjectUtil.explicitWait(3);
										verifyServiceTypeDropdown(sDropDownItems2, sActualDropDownItems2);
										WebObjectUtil.clickElement(FireWall.getNav_ProtocolDropdownArrow());
										WebObjectUtil.explicitWait(3);
										String sActualDropDownItems3=WebObjectUtil.getCustomWebListItems(Ticket.getNav_SearchByDropdown()).trim();
										verifyProtocolTypeDropdown(sDropDownItems3, sActualDropDownItems3);
										WebObjectUtil.verifyElementPresent(FireWall.getNav_SourceDropdownField());
										WebObjectUtil.verifyElementPresent(FireWall.getNav_SourceDropdownArrow());
										WebObjectUtil.verifyElementPresent(FireWall.getNav_DestinationDropdownField());
										WebObjectUtil.verifyElementPresent(FireWall.getNav_DestinationDropdownArrow());
										WebObjectUtil.verifyElementPresent(FireWall.getNav_EditFirewallRuleStatus());
										WebObjectUtil.verifyElementPresent(FireWall.getNav_EditFirewallAction());
										WebObjectUtil.verifyElementPresent(FireWall.getNav_MoveLink());
										WebObjectUtil.verifyElementPresent(FireWall.getNav_DeleteLink());
										WebObjectUtil.verifyElementPresent(FireWall.getNav_CancelLink());
										WebObjectUtil.verifyElementPresent(FireWall.getNav_SaveEditsLink());
										
										
        }
									catch (Exception e) {
										// TODO Auto-generated catch block
										LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
										FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navContactUsCreateticket", "warn", "catch block:" +e.getMessage());  
									}
									}
									
								/*===============================================================
								TestScript  	: verifyFirewallRefreshDetails()
								Manual TestCase	: QAT-523-WCP_3031_TC_2.0_Firewall rules-> Refresh Details
								Description		: Verify refresh Firewall functionality is working correctly.
								Author 			: Priyanka R
								Creation Date 	: 02/10/2016
								Pre-Requisites	:
								Release Name    : LefCourt SP2
								Revision History:
								================================================================*/
								@Test(priority=5)
								public void verifyFirewallRefreshDetails()
								{
									
									WebDriver driver = WebDriverUtil.getDriver();
									PageFactory.initElements(driver, Ticket);
									PageFactory.initElements(driver, Home);
									PageFactory.initElements(driver, Smoke);
									PageFactory.initElements(driver, Forms);
									
									try{
								FrameworkUtil.sTestCaseName = "verifyFirewallRefreshDetails";
								FrameworkUtil.sManualTestCaseName=" QAT-523-WCP_3031_TC_2.0_Firewall rules-> Refresh Details";
								FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
								//Login to Navigator
								String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.ENTITY02.USERID");
								
								String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.PASSWORD");
								//Login to Navigator Portlet
								LoginTestCase_Old1.nav_Login(sUserName,sPassword);
								/*WebObjectUtil.explicitWait(Home.getNav_HomeEVDCPortlet());
								WebObjectUtil.clickElement(FireWall.getNav_FirewallViewLink());*/
								// navigating to the firewall page
								EVDC_FirewallTestCase.NavigateToFirewallPage();
								WebObjectUtil.explicitWait(10);
								WebObjectUtil.clickElement(FireWall.getNav_FireWallRefreshDetailsIcon());
								WebObjectUtil.explicitWait(10);
								WebObjectUtil.verifyElementPresent(FireWall.getNav_FireWallRulesTabField());
									}
								catch (Exception e) {
									// TODO Auto-generated catch block
									LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
									FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navContactUsCreateticket", "warn", "catch block:" +e.getMessage());  
								}
								}
																	
								/*====================================================================================================
								Method Name 	: expandInterface
								Description		: Expand interface based on values of interface name and description
								Ex:sInterfaceName=Interface - 1 and sInterfaceDescription=Internal - tstqaauto-VLANabc
								Author 			: Sukur Babu. B
								Creation Date 	: 21/03/2016
								Pre-Requisites	:
								Revision History:
								====================================================================================================*/
								public static boolean expandInterface(String sInterfaceName,String sInterfaceDescription)
								{
									int iintferRow,iintferCol;
									int iReqInterfaceRow = 0;
									boolean bReqInterfaceFlag=false;
//									String sInterfaceText="Interface - 1",sInterfaceDescriptionText="Outside - outside",;
//									String sInterfaceText="Interface - 2",sInterfaceDescriptionText="Internal - tstqaauto-VLANabc",sTempText;
//									String sInterfaceText="Global Implicit rule",sInterfaceDescriptionText="",sTempText;
									String sTempText;
									WebDriver driver = WebDriverUtil.getDriver();
									PageFactory.initElements(driver, AddFirewallRuleTestCase.Firewall);
									PageFactory.initElements(driver, UserPermission);
									PageFactory.initElements(driver, Common);
									WebElement wIntFaceElement;
									/*LoginTestCase.LoginAsQaautoUser();
									EVDC_FirewallTestCase.NavigateToFirewallPage();*/
									int iInterfaceCntinPg=WebTableUtil.getRowCount(FireWall.getNav_FirewallTable());
									System.out.println("Number Of interface in the page "+iInterfaceCntinPg);
									int iinterfaceColCnt=WebTableUtil.getColumnCount(FireWall.getNav_FirewallTable(), 1);
									System.out.println("Firewall table column count is "+iinterfaceColCnt);
									
									
									for( iintferRow=1;iintferRow<=iInterfaceCntinPg;iintferRow++)
									{
										for(iintferCol=1;iintferCol<=iinterfaceColCnt;iintferCol++)
										{
											if(WebTableUtil.getColumnCount(FireWall.getNav_FirewallTable(), iintferRow)>1){
												
												sTempText=WebTableUtil.getCellData(FireWall.getNav_FirewallTable(), iintferRow, iintferCol);
																			
												if(sTempText.equalsIgnoreCase(sInterfaceName)){
													sTempText=WebTableUtil.getCellData(FireWall.getNav_FirewallTable(), iintferRow, iintferCol+1);
													if(!sTempText.isEmpty()){
													if(sTempText.equalsIgnoreCase(sInterfaceDescription)){
														System.out.println("Interface " +sInterfaceName+" found at row "+iintferRow+" and column "+iintferCol);
														iReqInterfaceRow=iintferRow;
														bReqInterfaceFlag=true;
														break;
												}
												}
												}
											}
											else if(WebTableUtil.getColumnCount(FireWall.getNav_FirewallTable(), iintferRow)==1){
												sTempText=WebTableUtil.getCellData(FireWall.getNav_FirewallTable(), iintferRow, 1);
												if(sTempText.equalsIgnoreCase(sInterfaceName)){
													iReqInterfaceRow=iintferRow;
													bReqInterfaceFlag=true;
													break;
												}
											}
										}
										 
									}
									if(bReqInterfaceFlag){
										WebElement wInterfaceExpandWebElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.EXPANDER","PARAMETER_ROWNUMBER",iReqInterfaceRow+"");
										wInterfaceExpandWebElement.click();
										WebObjectUtil.explicitWait(15);
										return true;
									}else{
										FrameworkUtil.updateCustomResultBasedOnStatus(false, "Issue in expanding Firewall interface");
										return false;
									}
									
								}									
									
									
//##############################################################################################################################\\
									

                                    /*==============================================================
									Method Name 	: verifyProtocolTypeDropdown
									Description		: This will verify the dropdown items
									Author 			: Priyanka R
									Creation Date 	: 03/18/16
									Pre-Requisites	:
									Revision History:
									==============================================================*/
									public static void verifyMoveFirewallFields()
									{
									WebDriver driver = WebDriverUtil.getDriver();
									PageFactory.initElements(driver,FireWall);
									Boolean bStatus=FireWall.getNav_MoveSeqNum().isEnabled();
									FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "SeqNum is "+bStatus);
									Boolean bStatus1=!(FireWall.getNav_SourceDropdownField().isEnabled());
									FrameworkUtil.updateCustomResultBasedOnStatus(bStatus1, "Source Dropdown is "+bStatus1);
									Boolean bStatus2=!(FireWall.getNav_EditFirewallSourceTypeField().isEnabled());
									FrameworkUtil.updateCustomResultBasedOnStatus(bStatus2, "Source Type Dropdown is "+bStatus2);
									Boolean bStatus3=!(FireWall.getNav_DestinationDropdownField().isEnabled());
									FrameworkUtil.updateCustomResultBasedOnStatus(bStatus3, "Destination Dropdown is "+bStatus3);
									Boolean bStatus4=!(FireWall.getNav_EditFirewallDestinationTypeField().isEnabled());
									FrameworkUtil.updateCustomResultBasedOnStatus(bStatus4, "Service Type Dropdown is "+bStatus4);
									Boolean bStatus5=!(FireWall.getNav_ServiceTypeField().isEnabled());
									FrameworkUtil.updateCustomResultBasedOnStatus(bStatus5, "Destination Type Dropdown is "+bStatus5);
									Boolean bStatus6=!(FireWall.getNav_ProtocolPortField().isEnabled());
									FrameworkUtil.updateCustomResultBasedOnStatus(bStatus6, "Destination Type Dropdown is "+bStatus6);
									
									
									}


									/*==============================================================
									Method Name 	: verifySourceDropdown
									Description		: This will verify the dropdown items
									Author 			: Priyanka R
									Creation Date 	: 03/18/16
									Pre-Requisites	:
									Revision History:
									==============================================================*/
									public static void verifySourceTypeDropdown(String sDropDownItems, String sActualDropDownItems)
									{
									WebDriver driver = WebDriverUtil.getDriver();
									PageFactory.initElements(driver,FireWall);


									String[] aDropDownItem;
									
									//Split the sDropDownItems
									aDropDownItem=sDropDownItems.split("@@");
									for(String sItem:aDropDownItem)
									{
									//System.out.println(sItem);
									if(sActualDropDownItems.contains(sItem))
									{
									LoggerUtil.log_type_info(sItem +" is present");
									FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName ,sItem , "pass","Verified");
									}
									else
									{
									LoggerUtil.log_type_error(sItem +" is not present");
									FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName ,sItem , "fail"," not Verified");
									}
									}
									}	
		
									/*==============================================================
									Method Name 	: verifyDestinationTypeDropdown
									Description		: This will verify the dropdown items
									Author 			: Priyanka R
									Creation Date 	: 03/18/16
									Pre-Requisites	:
									Revision History:
									==============================================================*/
									public static void verifyDestinationTypeDropdown(String sDropDownItems, String sActualDropDownItems)
									{
									WebDriver driver = WebDriverUtil.getDriver();
									PageFactory.initElements(driver,FireWall);


									String[] aDropDownItem;
									
									//Split the sDropDownItems
									aDropDownItem=sDropDownItems.split("@@");
									for(String sItem:aDropDownItem)
									{
									//System.out.println(sItem);
									if(sActualDropDownItems.contains(sItem))
									{
									LoggerUtil.log_type_info(sItem +" is present");
									FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName ,sItem , "pass","Verified");
									}
									else
									{
									LoggerUtil.log_type_error(sItem +" is not present");
									FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName ,sItem , "fail"," not Verified");
									}
									}
									}
									/*==============================================================
									Method Name 	: verifyServiceTypeDropdown
									Description		: This will verify the dropdown items
									Author 			: Priyanka R
									Creation Date 	: 03/18/16
									Pre-Requisites	:
									Revision History:
									==============================================================*/
									public static void verifyServiceTypeDropdown(String sDropDownItems, String sActualDropDownItems)
									{
									WebDriver driver = WebDriverUtil.getDriver();
									PageFactory.initElements(driver,FireWall);


									String[] aDropDownItem;
									
									//Split the sDropDownItems
									aDropDownItem=sDropDownItems.split("@@");
									for(String sItem:aDropDownItem)
									{
									//System.out.println(sItem);
									if(sActualDropDownItems.contains(sItem))
									{
									LoggerUtil.log_type_info(sItem +" is present");
									FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName ,sItem , "pass","Verified");
									}
									else
									{
									LoggerUtil.log_type_error(sItem +" is not present");
									FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName ,sItem , "fail"," not Verified");
									}
									}
									}
									/*==============================================================
									Method Name 	: verifyProtocolTypeDropdown
									Description		: This will verify the dropdown items
									Author 			: Priyanka R
									Creation Date 	: 03/18/16
									Pre-Requisites	:
									Revision History:
									==============================================================*/
									public static void verifyProtocolTypeDropdown(String sDropDownItems, String sActualDropDownItems)
									{
									WebDriver driver = WebDriverUtil.getDriver();
									PageFactory.initElements(driver,FireWall);


									String[] aDropDownItem;
									
									//Split the sDropDownItems
									aDropDownItem=sDropDownItems.split("@@");
									for(String sItem:aDropDownItem)
									{
									//System.out.println(sItem);
									if(sActualDropDownItems.contains(sItem))
									{
									LoggerUtil.log_type_info(sItem +" is present");
									FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName ,sItem , "pass","Verified");
									}
									else
									{
									LoggerUtil.log_type_error(sItem +" is not present");
									FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName ,sItem , "fail"," not Verified");
									}
									}
									WebObjectUtil.clickElement(FireWall.getNav_ProtocolDropdownArrow());
									WebObjectUtil.explicitWait(3);
									WebObjectUtil.selectCustomWebList(Ticket.getNav_SearchByDropdown(),3);
									WebObjectUtil.explicitWait(3);
									WebObjectUtil.verifyElementPresent(FireWall.getNav_ProtocolPortPopUPField());
									WebObjectUtil.clickElement(FireWall.getNav_ProtocolDropdownArrow());
									WebObjectUtil.explicitWait(3);
									WebObjectUtil.selectCustomWebList(Ticket.getNav_SearchByDropdown(),4);
									WebObjectUtil.explicitWait(3);
									WebObjectUtil.verifyElementPresent(FireWall.getNav_ProtocolPortPopUPField());
									
									}
									
									
			
			//update each @test result in custom result file
			@AfterMethod
			public static void afterEachMethod(){
			FrameworkUtil.updateTestCaseStatusinResult();
				}
}
