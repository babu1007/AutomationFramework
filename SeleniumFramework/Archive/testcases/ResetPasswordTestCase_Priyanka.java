package com.whs.navigator.testcases;

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
import com.whs.navigator.pagefactory.HomePageFactory;
import com.whs.navigator.pagefactory.LoadBalancerPageFactory;
import com.whs.navigator.pagefactory.LoginPageFactory;
import com.whs.navigator.pagefactory.SmokeTestPageFactory;
import com.whs.navigator.pagefactory.DraasPageFactory;
import com.whs.navigator.pagefactory.CommonPageFactory;
import com.whs.navigator.pagefactory.TicketPageFactory;
import com.whs.navigator.testcases.TicketTestCase;
import com.whs.navigator.pagefactory.FirewallPageFactory;
import com.whs.navigator.pagefactory.EM7PageFactory;
import com.whs.navigator.pagefactory.FormPageFactory;
import com.whs.navigator.pagefactory.EntityBrowserPageFactory;
import com.whs.navigator.testcases.LoginTestCase;
import com.whs.navigator.pagefactory.UserPermissionPageFactory;
import com.whs.navigator.testcases.EntityBrowserTestCase;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ResetPasswordTestCase_Priyanka{
	public static HomePageFactory Home = new HomePageFactory();
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
	public static  EscalationPageFactory Escalation = new EscalationPageFactory();
	public static LoginPageFactory login = new LoginPageFactory();

	/*==============================================================
	TestScript  	: verifyResetPasswordPage
	Manual TestCase	: QAT-840_QAT-845-WCP_4537_TC_1.1_Home-Portal Reset password page
	Description		: Verify that the Reset password page is displayed when user login to navigator 
	Author 			: Priyanka R
	Creation Date 	: 02/05/2016
	Pre-Requisites	:
	Release Name    : Santiago
	Revision History:
	==============================================================*/
			@Test(priority=1)
			public void verifyResetPasswordPage()
			{
				int iRow=1;
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, Ticket);
				PageFactory.initElements(driver, Home);

				PageFactory.initElements(driver, login);

				
				try{
				    FrameworkUtil.sTestCaseName = "verifyResetPasswordPage";
					FrameworkUtil.sManualTestCaseName="QAT-840_QAT-845-WCP_4537_TC_1.1_Home-Portal Reset password page";
			       	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			        //Login to Navigator
			        String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.USERID.QAAUTOA");
					
					String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.PWD.QAAUTOA");
					String sURL=(String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.URL");
					String sVerifyText=(String)FrameworkUtil.dictPropertyData.get("NAV.PORTAL.PASSWORD.TEXT");
					LoginTestCase.nav_LoginWithoutPopup(sUserName,sPassword);
					WebObjectUtil.explicitWait(10);
					if(WebObjectUtil.isElementPresent(Home.getNav_ResetPasswordLink()))
					{
					//WebObjectUtil.clickElement(Home.getNav_ResetPasswordLink());
					Home.getNav_ResetPasswordLink().click();
					WebObjectUtil.explicitWait(10);
					WebObjectUtil.verifyUrl(sURL);
					WebObjectUtil.explicitWait(5);
					WebObjectUtil.verifyElementPresent(Home.getNav_ResetPasswordTextArea());
					WebObjectUtil.explicitWait(5);
					//System.out.println(""+Home.getNav_ResetPasswordTextArea().getText());
					//String sActualVerifyText=Home.getNav_ResetPasswordTextArea().getText();
					WebObjectUtil.explicitWait(5);
					WebObjectUtil.clickElement(Home.getNav_ResetPasswordOkBtn());
					WebObjectUtil.explicitWait(15);
					WebObjectUtil.verifyElementPresent(Home.getNav_ResetPasswordMainSectionPopUp());
					}
					LoginTestCase.nav_Logout();
					
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception Occured", "", "catch block:" +e.getMessage());  
				}
			}
			
			/*==============================================================
			TestScript  	: public void verifyResetChallengeQuestions()
			Manual TestCase	: QAT-1418_WCP_4623_TC_1.0_ home page - Reset Challenge questions
			Description		:Verify that user is able to change the challenging questions using Reset Security 
			                 questions page and verify the given question and answer
			Author 			: Priyanka R
			Creation Date 	: 02/05/2016
			Pre-Requisites	:
			Release Name    : TalonSP1
			Revision History:
			==============================================================*/
					@Test(priority=2)
					public void verifyResetChallengeQuestions()
					{
						int iRow=1;
						WebDriver driver = WebDriverUtil.getDriver();
						PageFactory.initElements(driver, Ticket);
						PageFactory.initElements(driver, Home);

						PageFactory.initElements(driver, login);

						
						try{
							int i=1;
						    FrameworkUtil.sTestCaseName = "verifyResetChallengeQuestions";
							FrameworkUtil.sManualTestCaseName=" QAT-1418_WCP_4623_TC_1.0_ home page - Reset Challenge questions";
					       	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					        //Login to Navigator
					        String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.USERID.QAAUTOA");
							
							String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.PWD.QAAUTOA");
							String sURL=(String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.URL");
							String sAnswerValue=(String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTOA.ANSWER");
							String sControlPanel=(String)FrameworkUtil.dictPropertyData.get("NAV.ISHANNON.CONTROLPANEL");
							String sQaUserName=(String)FrameworkUtil.dictPropertyData.get("NAV.QAAUTOA.USERNAME");
							LoginTestCase.nav_LoginWithoutPopup(sUserName,sPassword);
							WebObjectUtil.explicitWait(10);
							if(WebObjectUtil.isElementPresent(Home.getNav_ResetPasswordLink()))
							{
							//WebObjectUtil.clickElement(Home.getNav_ResetPasswordLink());
							Home.getNav_ResetSecurityQuestionsLink().click();
							WebObjectUtil.explicitWait(10);
							WebObjectUtil.verifyElementPresent(Home.getNav_SetChallengeQuestionGrid());
							WebObjectUtil.clickElement(Home.getNav_SetChallengeQuestionDropdownIcon());
							WebObjectUtil.explicitWait(5);
							WebObjectUtil.selectCustomWebList(Home.getNav_SetChallengeQuestionDropdown(), i);
							WebObjectUtil.explicitWait(5);
							WebObjectUtil.SetValueEdit(Home.getNav_SetChallengeAnswer(), sAnswerValue);
							WebObjectUtil.clickElement(Home.getNav_SetChallengeAnswerOkBtn());
							LoginTestCase.nav_Logout();
							WebObjectUtil.explicitWait(5);
							LoginTestCase.LoginAsIshannonUser();
							WebObjectUtil.ClickAndMouseHover(Home.getNav_ManageButton());
							WebObjectUtil.explicitWait(3);
							WebObjectUtil.selectCustomWebList(Home.getNav_Managerdropdown(), sControlPanel);
							WebObjectUtil.clickElement(Home.getNav_ControlPanelUsersLink());
							WebObjectUtil.SetValueEdit(Home.getNav_ControlPanelUserNameSearchBox(), sQaUserName);
							WebObjectUtil.explicitWait(5);
							WebObjectUtil.clickElement(Home.getNav_UserSearchButton());
							WebObjectUtil.explicitWait(5);
							WebObjectUtil.clickElement(Home. getNav_QAautoAUserLink());
                            
							}
						}
						catch (Exception e) {
							// TODO Auto-generated catch block
							LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception Occured", "", "catch block:" +e.getMessage());  
						}
					}

					/*==============================================================
					TestScript  	: verifyResetPasswordSuccessMsg()
					Manual TestCase	: QAT-1358_WCP_4897_TC_1.0_ Reset password- home page
					Description		: Verify that user is able to change the challenging questions using Reset Security 
					                  questions page and verify the given question and answer
					Author 			: Priyanka R
					Creation Date 	: 02/05/2016
					Pre-Requisites	:
					Release Name    : TalonSP1
					Revision History:
					==============================================================*/
							@Test(priority=3)
							public void verifyResetPasswordSuccessMsg()
							{
								int iRow=1;
								WebDriver driver = WebDriverUtil.getDriver();
								PageFactory.initElements(driver, Ticket);
								PageFactory.initElements(driver, Home);

								PageFactory.initElements(driver, login);

								
								try{
									int i=1;
								    FrameworkUtil.sTestCaseName = "verifyResetPasswordSuccessMsg()";
									FrameworkUtil.sManualTestCaseName="QAT-1358_WCP_4897_TC_1.0_ Reset password- home page";
							       	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
							        //Login to Navigator
							        String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.USERID.QAAUTOA");
									
									String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.PWD.QAAUTOA");
									String sURL=(String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.URL");
									String sMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.FEEDBACK.MSG");
									LoginTestCase.nav_LoginWithoutPopup(sUserName,sPassword);
									WebObjectUtil.explicitWait(10);
									
									Home.getNav_ResetPasswordLink().click();
									WebObjectUtil.explicitWait(10);
									WebObjectUtil.verifyUrl(sURL);
									WebObjectUtil.explicitWait(5);
									WebObjectUtil.verifyElementPresent(Home.getNav_ResetPasswordTextArea());
									WebObjectUtil.explicitWait(5);
									WebObjectUtil.clickElement(Home.getNav_ResetPasswordOkBtn());
									WebObjectUtil.explicitWait(8);
									WebObjectUtil.verifyElementPresent(Home.getNav_UserFeedBackMsg());
									String sFeedBackMsg=Home.getNav_UserFeedBackMsg().getText().trim();
									WebObjectUtil.explicitWait(3);
									//Hold on with this test case
									if(sMsg.equalsIgnoreCase(sFeedBackMsg))
									{
										FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, " Verified", "pass", "Displayed Title is : " +sMsg);
									}
									else{
										FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName,  "Please verify manually, if Msg has changed or not displayed", "fail", "Displayed Title is : " +sFeedBackMsg  + " and actual title should be : " +sMsg);
									}

								}
								catch (Exception e) {
									// TODO Auto-generated catch block
									LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
									FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception Occured", "", "catch block:" +e.getMessage());  
								}
							}
	

	//update each @test result in custom result file
	@AfterMethod
	public static void afterEachMethod(){
	FrameworkUtil.updateTestCaseStatusinResult();
		}

}
