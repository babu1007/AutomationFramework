package com.whs.navigator.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.DashboardPageFactory;
import com.whs.navigator.pagefactory.LoginPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory_old;

public class LoginTestCase_Old {
	public WebDriver driver = null;
	public static boolean bLoginStatus=false;
	public static boolean bLogOutStatus=false;
	static String sLogoutUrl ;
	static String sSignOutUrl;
	public static LoginPageFactory login = new LoginPageFactory();
	public static DashboardPageFactory dashboard = new DashboardPageFactory();
	public static HomePageFactory_old Home = new HomePageFactory_old();
	//public static FrameworkUtil fwUtil = new FrameworkUtil();
	
	/*==============================================================
	TestScript 		: loginSuccess
	Manual TestCase	: Login Success
	Description		: Verifying Login success using Valid credential
	Author 			: Vivek Kumar
	Creation Date 	: 10/27/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	@Test(priority=1)
	public void loginSuccess() 
	{
		
		
		FrameworkUtil.sTestCaseName = "LoginSuccess";
		FrameworkUtil.sManualTestCaseName="LoginSuccess";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, login);
		PageFactory.initElements(driver, dashboard);
		
		String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
		String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
				
		//login to Navigator 
		nav_Login(sUserName, sPassword);
				
		//check for login success
		WebObjectUtil.assertElementPresent(dashboard.getNav_UserNameLink());
			
		//log out Navigator
		nav_Logout();
		FrameworkUtil.writefile("</table>", FrameworkUtil.sResultPath, FrameworkUtil.sCustomFileName);

	}
	/*==============================================================
	TestScript 		: loginFail
	Manual TestCase	: Login Failure
	Description		: Verifying Login fail using InValid credential
	Author 			: Vivek Kumar
	Creation Date 	: 10/27/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	@Test(priority=2)
	public void loginFail()
	{
		FrameworkUtil.sTestCaseName = "LoginFail";
		FrameworkUtil.sManualTestCaseName="Login failure";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		PageFactory.initElements(driver, login);

		String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.INVALID.USERID");
		String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.INVALID.PWD");
		if(bLoginStatus)
		{
			nav_Logout();
		}
		nav_Login(sUserName, sPassword);
		bLoginStatus = false;
		
		if(!bLoginStatus)
		{	
			LoggerUtil.writeStatusLog(WebObjectUtil.VerifyTextOnPage("Authentication failed. Please try again."), "Invalid Login", "Login Failure error message verified");

		}
	}
	/*==============================================================
	TestScript 		: multipleLogin
	Manual TestCase	: Login Multi Org
	Description		: Verifying Login using valid credentials that is a part of multiple organizations 
	Author 			: Vivek Kumar
	Creation Date 	: 10/27/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	//@Test(priority=3)
	public void multipleLogin() 
	{
		FrameworkUtil.sTestCaseName = "MultipleLogin";
		FrameworkUtil.sManualTestCaseName="Login Multi Org";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, login);
		PageFactory.initElements(driver, dashboard);

			for (String sKey : FrameworkUtil.GetPropKeysList()){
				//System.out.println(sKey);
				
				//login to Navigator 
				if(sKey.contains(".USERID")==true && sKey.contains("INVALID")== false){
				String sPwd=sKey.replace(".USERID", ".PWD");
				
				try {
					nav_Login(FrameworkUtil.getPropValues(sKey), FrameworkUtil.getPropValues(sPwd));
							
					//check for login success
					String sUN=sKey.replace(".USERID", ".USERFULLNAME");
					boolean bUN =WebObjectUtil.VerifyTextOnPage(FrameworkUtil.getPropValues(sUN));
					
					//LoggerUtil.writeStatusLog(bUN, "Verify Login", "Login with User name: " + FrameworkUtil.getPropValues(sKey));

					//log out Navigator
					if (FrameworkUtil.getPropValues(sKey).contains("admin")){
						nav_Signout();
					}else{
						nav_Logout();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					/*if (WebObjectUtil.getElementByText("Sign Out") != null){
						nav_Signout();	
					}else{
						nav_Logout();
					}*/
					//bLoginStatus = false;
				}
			}
			
	}
	
	


	/*==============================================================
	Method Name 	: nav_Login
	Description		: This method will login Navigator using   sUserName and sPassword
	Author 			: Arul
	Creation Date 	: 10/24/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	public static boolean nav_Login(String sUserName,String sPassword)
	{
		String sURL=null;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, login);
		PageFactory.initElements(driver, Home);
		
		if (bLoginStatus==true || WebObjectUtil.bCurrentTestStopped==true){
			forcedLogOut();
		}

		
		if( !WebObjectUtil.isElementPresent(login.getNav_userId()))
		{
			WebDriverUtil.getDriver().get(getLogoutURL());
		}
		
		if(bLoginStatus != true || WebObjectUtil.isElementPresent(login.getNav_userId()))
		{
			try {
				sURL = (String)FrameworkUtil.dictPropertyData.get("NAV.QA.URL");
				WebDriverUtil.getDriver().get(sURL);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebDriverUtil.getSeleniumDriver(sURL);
				
				WebObjectUtil.SetValueEdit(login.getNav_userId(),sUserName );
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebObjectUtil.SetValueEdit(login.getNav_pwd(),sPassword );
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				WebObjectUtil.clickElement(login.getNav_submitBtn());
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				WebObjectUtil.waitForPageLoad();
				bLoginStatus=true;
				FrameworkUtil.takeScreenShot();
				HomeTestCase.nav_WindStreamToTierPointHomePopup();
				
			} catch (Exception e) {
				LoggerUtil.setClassNameForLog("Verify Login");
				LoggerUtil.log_type_error("Login Failed with UserID - " + sUserName);
				bLoginStatus=false;
			}
		}	
		return bLoginStatus;
	}
	
	/*==============================================================
	Method Name 	: nav_Logout
	Description		: This method will logout Navigator
	Author 			: Arul
	Creation Date 	: 10/24/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void nav_Logout()
	{
		//bLogOutStatus = false;
		boolean bstatus = false;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, login);
		PageFactory.initElements(driver, dashboard);
		
		String sNavigatorUrl = (String)FrameworkUtil.dictPropertyData.get("NAV.QA.URL");
		sLogoutUrl = sNavigatorUrl.replace("/home", "/c/portal/logout");
		//String sSummaryURL=sNavigatorUrl.replace("/home", "/navigator");
		String sSummaryURL=sNavigatorUrl;
		
		WebDriverUtil.getDriver().get(sSummaryURL);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		if(bLoginStatus || WebObjectUtil.isElementPresent(dashboard.getnav_UserNameDropDown()))
		{
			try {

			Actions builder = new Actions(driver) ;
			
			//if (WebObjectUtil.isElementPresent(dashboard.getNav_LogoutLink())){
			//	WebObjectUtil.clickElement(dashboard.getNav_LogoutLink());
			//}else{
			
				try {
/*				WebObjectUtil.clickElement(dashboard.getnav_UserNameDropDown());
				//WebObjectUtil.clickElement(dashboard.getNav_UserNameLink());
				builder.moveToElement(dashboard.getNav_UserNameLink()).perform();
				Thread.sleep(5000);
				WebElement logout = WebObjectUtil.GetWebElement("linktext", "Logout");
				FrameworkUtil.sElementName = "Logout";
				WebObjectUtil.clickElement(logout);
				//logout.click();
*/				WebObjectUtil.ClickAndMouseHover(dashboard.getnav_UserNameDropDown());
				Thread.sleep(2000);
				//WebObjectUtil.clickElement(dashboard.getNav_LogoutLink());
				dashboard.getNav_LogoutLink();
				bstatus = WebObjectUtil.selectCustomWebList(dashboard.getnav_UserNameDropDown(), "Logout");

				} catch (Exception e) {
					e.printStackTrace();
					driver.get(sLogoutUrl);
					//WebObjectUtil.clickElement(dashboard.getNav_LogoutLink());	
				}
			//}	
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//LoggerUtil.writeStatusLog(WebObjectUtil.isElementPresent(login.getNav_userId()), "Verify Logout", "user log out");
			//FrameworkUtil.updateCustomResultBasedOnStatus(bstatus);
				bLoginStatus=false;
			} catch (Exception e) {
				LoggerUtil.log_type_info("Navigator - Issue with Logout" );
			}
		}

		driver.get(sLogoutUrl);
		bLoginStatus=false;
	}
	
	/*==============================================================
	Method Name 	: nav_Signout
	Description		: This method will Signout Navigator
	Author 			: Arul
	Creation Date 	: 10/24/2014
	Pre-Requisites	:
	Revision History:
	==============================================================
	*/
	public static void nav_Signout()
	{
		bLogOutStatus = false;
		if(bLoginStatus || WebObjectUtil.isElementPresent(login.getNav_SignOutLink()))
		{
			try {
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, login);
			if (WebObjectUtil.isElementPresent(login.getNav_SignOutLink())){
			WebObjectUtil.clickElement(login.getNav_SignOutLink());
			}
/*			WebElement signOut = WebObjectUtil.getElementByText("Sign Out");
			if (signOut != null){
				signOut.click();
			}
*/
			LoggerUtil.writeStatusLog(WebObjectUtil.isElementPresent(login.getNav_userId()), "Verify Signout", "user Sign out");
			
			bLoginStatus=false;
			} catch( Exception e) {
				LoggerUtil.log_type_info("Navigator - Issue with Signout" );
			}
			
		}
		bLoginStatus=false;
	}

	/*==============================================================
	Method Name 	: forcedLogOut
	Description		: This method called to logout/signout navigator
	Author 			: Arul
	Creation Date 	: 12/21/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
public static void forcedLogOut(){
	String sURL;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, login);
	PageFactory.initElements(driver, Home);
	PageFactory.initElements(driver, dashboard);
	try {
		getLogoutURL();
		if( WebObjectUtil.isElementPresent(dashboard.getnav_UserNameDropDown()) )
		{
			nav_Logout();
		}else if( WebObjectUtil.isElementPresent(login.getNav_SignOutLink())){
			nav_Signout();
		}else {
			driver.get(sLogoutUrl);
			driver.get(sSignOutUrl);
			bLoginStatus=false;
			WebObjectUtil.bCurrentTestStopped=false;
		}
		
	} catch (Exception e2) {
		LoggerUtil.log_type_error("Did not logged out properly, Logging out before login as different user");
		driver.get(sLogoutUrl);
		driver.get(sSignOutUrl);
		bLoginStatus=false;
		WebObjectUtil.bCurrentTestStopped=false;
	}
	
	
	try {
		String sBodyText = driver.findElement(By.tagName("body")).getText();
		 if (sBodyText.contains("You are signed in as")){
			 System.out.println("body text : " + sBodyText);
			 nav_Logout();
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 bLoginStatus=false;
		 }
	} catch (Exception e1) {
		LoggerUtil.log_type_error("Did not logged out properly, Logging out before login as different user");
	}
	 
}

static String getLogoutURL(){
	String sURL;
	String[] arrURL = new String[1];
	
	
	try {
		sURL=(String)FrameworkUtil.dictPropertyData.get("NAV.QA.URL");
		arrURL = sURL.split(".com"); 
		sLogoutUrl = arrURL[0] + "/en/c/portal/logout";
		sSignOutUrl="https://tst-lab2-navigator02.lab.hostedsolutions.com/en/c/portal/logout";
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return sLogoutUrl;
}


/*==============================================================
	MethodName 		: LoginAsRoleA
	Manual TestCase	: 
	Description		: login to navigator as arole user
	Author 			: QAA04
	Creation Date 	: 11/30/2015
	release Name    : Hague
	Pre-Requisites	:
	Revision History:
	
	==============================================================*/
 public static void LoginAsRoleA() {
	  
	  String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEA.USERID");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEA.PASSWORD");
	  LoginTestCase_Old1.nav_Login(sUserName, sPassword);
 }
   /*==============================================================
 	MethodName 		: LoginAsHawkeyeUser
 	Manual TestCase	: 
 	Description		: login to navigator as hawkey user
 	Author 			: QAA04
 	Creation Date 	: 11/30/2015
 	release Name    : Hague
 	Pre-Requisites	:
 	Revision History:
 	
 	==============================================================*/
 public static void LoginAsHawkeyeUser() {
 	  
 	  String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HAWKEYE.USERID");
 	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.PASSWORD");
 	  LoginTestCase_Old1.nav_Login(sUserName, sPassword);
   }
	
 

 /*==============================================================
	MethodName 		: LoginAsSravuriUser
	Manual TestCase	: 
	Description		: login to navigator as sravuridev user
	Author 			: QAA04
	Creation Date 	: 12/01/2015
	release Name    : Hague
	Pre-Requisites	:
	Revision History:
	
	==============================================================*/
public static void LoginAsSravuriUser() {
	  
	  String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTDEVCO1.SRAVURIDEV.USERID");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTDEVCO1.SRAVURIDEV.PASSWORD");
	  LoginTestCase_Old1.nav_Login(sUserName, sPassword);
  }

/*==============================================================
MethodName 		: LoginAsDevco
Manual TestCase	: 
Description		: login to navigator as devco user
Author 			: QAA04
Creation Date 	: 11/30/2015
release Name    : Hague
Pre-Requisites	:
Revision History:

==============================================================*/
public static void LoginAsDevco() {
  
  String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLE.USERID");
  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.CLOUD.SINGLE.PWD");
  LoginTestCase_Old1.nav_Login(sUserName, sPassword);
}

/*==============================================================
MethodName 		: LoginAsGirUser
Manual TestCase	: 
Description		: login to navigator as giruser
Author 			: QAA04
Creation Date 	: 12/28/2015
release Name    : Hague
Pre-Requisites	:
Revision History:

==============================================================*/
public static void LoginAsGirUser() {
  
  String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
  LoginTestCase_Old1.nav_Login(sUserName, sPassword);
}

/*==============================================================
MethodName 		: LoginAsATestAUser
Manual TestCase	: 
Description		: login to navigator as Atest-c user
Author 			: QAA04
Creation Date 	: 12/28/2015
release Name    : Hague
Pre-Requisites	:
Revision History:

==============================================================*/
public static void LoginAsATestAUser() {
  
  String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO1.USERID.ATEST");
  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO1.PASSWORD.ATEST");
  LoginTestCase_Old1.nav_Login(sUserName, sPassword);
}

/*==============================================================
MethodName 		: LoginAsRoleCUser
Manual TestCase	: 
Description		: login to navigator as role-c user
Author 			: QAA04
Creation Date 	: 12/28/2015
release Name    : Hague
Pre-Requisites	:
Revision History:

==============================================================*/
public static void LoginAsRoleCUser() {
  
  String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO1.USERID.ATEST");
  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO1.PASSWORD.ATEST");
  LoginTestCase_Old1.nav_Login(sUserName, sPassword);
}

/*==============================================================
MethodName 		: LoginAsATestCUser
Manual TestCase	: 
Description		: login to navigator as Atest-c user
Author 			: QAA04
Creation Date 	: 12/28/2015
release Name    : Hague
Pre-Requisites	:
Revision History:

==============================================================*/
public static void LoginAsATestCUser() {
  
  String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO1.USERID.CTEST");
  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO1.PASSWORD.CTEST");
  LoginTestCase_Old1.nav_Login(sUserName, sPassword);
}

/*==============================================================
MethodName 		: LoginAsATestEUser
Manual TestCase	: 
Description		: login to navigator as Atest-e user
Author 			: QAA04
Creation Date 	: 12/28/2015
release Name    : Hague
Pre-Requisites	:
Revision History:

==============================================================*/
public static void LoginAsATestEUser() {
  
  String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO1.USERID.ETEST");
  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO1.PASSWORD.ETEST");
  LoginTestCase_Old1.nav_Login(sUserName, sPassword);
}

/*==============================================================
MethodName 		: LoginAsTstMultiOrgRoleA1User
Manual TestCase	: 
Description		: login to navigator as tstMultiOrgRole-A1 user
Author 			: QAA04
Creation Date 	: 12/28/2015
release Name    : Hague
Pre-Requisites	:
Revision History:

==============================================================*/
public static void LoginAsTstMultiOrgRoleA1User() {
  
  String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.AROLE1");
  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.AROLE");
  LoginTestCase_Old1.nav_Login(sUserName, sPassword);
}

/*==============================================================
MethodName 		: LoginAsTstMultiOrgRoleCUser
Manual TestCase	: 
Description		: login to navigator as tstMulliOrgRole-c user
Author 			: QAA04
Creation Date 	: 12/28/2015
release Name    : Hague
Pre-Requisites	:
Revision History:

==============================================================*/
public static void LoginAsTstMultiOrgRoleCUser() {
  
  String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.CROLE");
  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.CROLE");
  LoginTestCase_Old1.nav_Login(sUserName, sPassword);
}

/*==============================================================
MethodName 		: LoginAsTstMultiOrgRoleEUser
Manual TestCase	: 
Description		: login to navigator as tstMultiOrgRole-E user
Author 			: QAA04
Creation Date 	: 12/28/2015
release Name    : Hague
Pre-Requisites	:
Revision History:

==============================================================*/
public static void LoginAsTstMultiOrgRoleEUser() {
  
  String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.EROLE");
  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.EROLE");
  LoginTestCase_Old1.nav_Login(sUserName, sPassword);
}

/*==============================================================
MethodName 		: LoginAsARoleAUser
Manual TestCase	: 
Description		: login to navigator as ARoleA user
Author 			: QAA04
Creation Date 	: 12/28/2015
release Name    : Hague
Pre-Requisites	:
Revision History:

==============================================================*/
public static void LoginAsARoleAUser() {
  
  String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOL.USERID.AROLE");
  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOL.PASSWORD.AROLE");
  LoginTestCase_Old1.nav_Login(sUserName, sPassword);
}

/*==============================================================
MethodName 		: LoginAsIshannonUser
Manual TestCase	: 
Description		: login to navigator as ishnnon user
Author 			: QAA04
Creation Date 	: 12/28/2015
release Name    : Hague
Pre-Requisites	:
Revision History:

==============================================================*/
public static void LoginAsIshannonUser() {
  
  String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ISHANNON.USERID");
  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ISHANNON.PASSWORD");
  LoginTestCase_Old1.nav_Login(sUserName, sPassword);
}
/*==============================================================
MethodName 		: LoginAsAgentUser
Manual TestCase	: 
Description		: login to navigator as ishnnon user
Author 			: QAA04
Creation Date 	: 12/28/2015
release Name    : Hague
Pre-Requisites	:
Revision History:

==============================================================*/
public static void LoginAsAgentUser() {
  
  String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTGETSMART.AGENT.USERID");
  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTGETSMART.AGENT.PASSWORD");
  LoginTestCase_Old1.nav_Login(sUserName, sPassword);
}

//update each @test result in custom result file
	@AfterMethod
	public static void afterEachMethod(){
		FrameworkUtil.updateTestCaseStatusinResult();
		if (WebObjectUtil.bCurrentTestStopped==true){
			forcedLogOut();
		}
	}
	
	
}


