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

public class LoginTestCase {
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
		//nav_Login(sUserName, sPassword);
		LoginAsQaautoUser();
				
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
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
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
	
	public static boolean nav_Login_legacy(String sUserName,String sPassword)
	{
		String sURL=null,sSummaryURL;
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
				String[] arrURL = sURL.split(".com"); 
				sSummaryURL=arrURL[0]+".com";
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
				//HomeTestCase.nav_WindStreamToTierPointHomePopup();
				//WebDriverUtil.getDriver().get(sSummaryURL);
			} catch (Exception e) {
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
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
		String[] arrURL = sNavigatorUrl.split(".com"); 
		String sSummaryURL=arrURL[0]+".com";
		
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
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
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
		//WebDriverUtil.quitWebDriver();
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
		
		WebDriverUtil.refreshBrowser();
		if(bLoginStatus || WebObjectUtil.isElementPresent(login.getNav_SignOutLink()))
		{
			WebDriver driver = WebDriverUtil.getDriver();
			try {
				
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
				driver.get(sLogoutUrl);
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
		sLogoutUrl = arrURL[0] + ".com/en/c/portal/logout";
		sSignOutUrl="https://tst-lab2-navigator02.lab.hostedsolutions.com/en/c/portal/logout";
	} catch (Exception e) {
		// TODO Auto-generated catch block
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
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
 public static boolean LoginAsRoleAUser() {
	  
	  try {
		String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.USERID.ROLEA");
		  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.PWD.ROLEA");
		  LoginTestCase.nav_Login(sUserName, sPassword);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
	}
	  return bLoginStatus;
 }
 /*==============================================================
	MethodName 		: LoginAsRoleC
	Manual TestCase	: 
	Description		: login to navigator as arole user
	Author 			: Sukur Babu. B
	Creation Date 	: 12/30/2015
	release Name    : Hague
	Pre-Requisites	:
	Revision History:
	
	==============================================================*/
public static boolean LoginAsRoleCUser() {
	  
	try {
		String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.USERID.ROLEC");
		  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.PWD.ROLEC");
		  LoginTestCase.nav_Login(sUserName, sPassword);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
	}
	return bLoginStatus;
}
/*==============================================================
MethodName 		: LoginAsRoleE
Manual TestCase	: 
Description		: login to navigator as arole user
Author 			: Sukur Babu. B
Creation Date 	: 12/30/2015
release Name    : Hague
Pre-Requisites	:
Revision History:

==============================================================*/
public static boolean LoginAsRoleEUser() {
  
	try {
		String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.USERID.ROLEE");
		 String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.PWD.ROLEE");
        LoginTestCase.nav_Login(sUserName, sPassword);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
	}
	return bLoginStatus;
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
 public static boolean LoginAsHawkeyeUser() {
 	  
 	  try {
		String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTMASH4077.USERID.HAWKEYE");
		  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTMASH4077.PWD.HAWKEYE");
		  LoginTestCase.nav_Login(sUserName, sPassword);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
	}
 	 return bLoginStatus;
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
public static boolean LoginAsSravuriUser() {
	  
	  try {
		String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTDEVCO.USERID.SRAVURIDEV");
		  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTDEVCO.PWD.SRAVURIDEV");
		  LoginTestCase.nav_Login(sUserName, sPassword);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
	}
	  return bLoginStatus;
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
public static boolean LoginAsDevcoUser() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTDEVCO.USERID.DEVCO1");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTDEVCO.PWD.DEVCO1");
	  LoginTestCase.nav_Login(sUserName, sPassword);
} catch (Exception e) {
	// TODO Auto-generated catch block
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
}
  return bLoginStatus;
}

/*==============================================================
MethodName 		: LoginAsPuppyloveUser
Manual TestCase	: 
Description		: login to navigator as puppylove user
Author 			: QAA04
Creation Date 	: 05/09/2016
release Name    : Hague
Pre-Requisites	:
Revision History:

==============================================================*/
public static void LoginAsPuppyloveUser() {
  
  try {
	  
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.PUPPYLOVE.USERID");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.PUPPYLOVE.PASSWORD");
	  LoginTestCase.nav_Login(sUserName, sPassword);
	  
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

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
public static boolean LoginAsGirUser() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.11GIRAFFES.USERID.GIRUSER");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.11GIRAFFES.PWD.GIRUSER");
	  LoginTestCase.nav_Login(sUserName, sPassword);
} catch (Exception e) {
	// TODO Auto-generated catch block
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
}
  return bLoginStatus;
}
/*==============================================================
MethodName 		: LoginAsSingUser1User
Manual TestCase	: 
Description		: login to navigator as SingUser1
Author 			: Sukur Babu. B
Creation Date 	: 12/30/2015
release Name    : Hague
Pre-Requisites	:
Revision History:

==============================================================*/
public static boolean LoginAsSingUser1User() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.SINGLUXINC.USERID.SINGUSER1");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.SINGLUXINC.PWD.SINGUSER1");
	  LoginTestCase.nav_Login(sUserName, sPassword);
} catch (Exception e) {
	// TODO Auto-generated catch block
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
}
  return bLoginStatus;
}
/*==============================================================
MethodName 		: LoginAststmax02lasttUser
Manual TestCase	: 
Description		: login to navigator as SingUser1
Author 			: Sukur Babu. B
Creation Date 	: 1/05/2015
release Name    : Hague
Pre-Requisites	:
Revision History:

==============================================================*/
public static boolean LoginAststmax02lasttUser() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTDEVCO.USERID.TSTMAX02LASTT");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTDEVCO.PWD.TSTMAX02LASTT");
	  LoginTestCase.nav_Login(sUserName, sPassword);
} catch (Exception e) {
	// TODO Auto-generated catch block
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
}
  return bLoginStatus;
}
/*==============================================================
MethodName 		: LoginAsJeffParlanceUser
Manual TestCase	: 
Description		: login to navigator as SingUser1
Author 			: Sukur Babu. B
Creation Date 	: 1/05/2015
release Name    : Hague
Pre-Requisites	:
Revision History:

==============================================================*/
public static boolean LoginAsJeffParlanceUser() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USERID.JEFF.PARLANCE");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.PASSWORD.JEFF.PARLANCE");
	  LoginTestCase.nav_Login(sUserName, sPassword);
} catch (Exception e) {
	// TODO Auto-generated catch block
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
}
  return bLoginStatus;
}

/*==============================================================
MethodName 		: LoginAsKirkjUser
Manual TestCase	: 
Description		: login to navigator as SingUser1
Author 			: Sukur Babu. B
Creation Date 	: 1/05/2015
release Name    : Hague
Pre-Requisites	:
Revision History:

==============================================================*/
public static boolean LoginAsKirkjUser() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USERID.KIRKJ");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.PWD.KIRKJ");
	  LoginTestCase.nav_Login(sUserName, sPassword);
} catch (Exception e) {
	// TODO Auto-generated catch block
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
}
  return bLoginStatus;
}
/*==============================================================
MethodName 		: LoginAsTestMultiOrgUser
Manual TestCase	: 
Description		: login to navigator as SingUser1
Author 			: Sukur Babu. B
Creation Date 	: 1/05/2015
release Name    : Hague
Pre-Requisites	:
Revision History:

==============================================================*/
public static boolean LoginAsTestMultiOrgUser() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.BELK.USERID.TESTMULTIORG");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.BELK.PWD.TESTMULTIORG");
	  LoginTestCase.nav_Login(sUserName, sPassword);
} catch (Exception e) {
	// TODO Auto-generated catch block
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
}
  return bLoginStatus;
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
public static boolean LoginAsATestAUser() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO1.USERID.ATEST");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO1.PASSWORD.ATEST");
	  LoginTestCase.nav_Login(sUserName, sPassword);
} catch (Exception e) {
	// TODO Auto-generated catch block
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
}
  return bLoginStatus;
}
/*==============================================================
MethodName 		: LoginAsRRamDevUser
Manual TestCase	: 
Description		: login to navigator as rramdev user
Author 			: QAA04
Creation Date 	: 12/28/2015
release Name    : Hague
Pre-Requisites	:
Revision History:

==============================================================*/
public static boolean LoginAsRRamDevUser() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTDEVCO.USERID.RRAMDEV");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTDEVCO.PWD.RRAMDEV");
	  LoginTestCase.nav_Login(sUserName, sPassword);
} catch (Exception e) {
	// TODO Auto-generated catch block
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
}
  return bLoginStatus;
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
//public static boolean LoginAsRoleCUser() {
//  
//  String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO1.USERID.ATEST");
//  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO1.PASSWORD.ATEST");
//  LoginTestCase.nav_Login(sUserName, sPassword);
//}

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
public static boolean LoginAsATestCUser() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO1.USERID.CTEST");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO1.PASSWORD.CTEST");
	  LoginTestCase.nav_Login(sUserName, sPassword);
} catch (Exception e) {
	// TODO Auto-generated catch block
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
}
  return bLoginStatus;
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
public static boolean LoginAsATestEUser() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO1.USERID.ETEST");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.TSTDEVCO1.PASSWORD.ETEST");
	  LoginTestCase.nav_Login(sUserName, sPassword);
} catch (Exception e) {
	// TODO Auto-generated catch block
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
}
  return bLoginStatus;
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
public static boolean LoginAsTstMultiOrgRoleA1User() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.AROLE1");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.AROLE");
	  LoginTestCase.nav_Login(sUserName, sPassword);
} catch (Exception e) {
	// TODO Auto-generated catch block
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
}
  return bLoginStatus;
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
public static boolean LoginAsTstMultiOrgRoleCUser() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.CROLE");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.CROLE");
	  LoginTestCase.nav_Login(sUserName, sPassword);
} catch (Exception e) {
	// TODO Auto-generated catch block
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
}
  return bLoginStatus;
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
public static boolean LoginAsTstMultiOrgRoleEUser() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.EROLE");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PASSWORD.EROLE");
	  LoginTestCase.nav_Login(sUserName, sPassword);
} catch (Exception e) {
	// TODO Auto-generated catch block
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
}
  return bLoginStatus;
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
public static boolean LoginAsARoleAUser() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.USERID.AROLEA");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.PWD.AROLEA");
	  LoginTestCase.nav_Login(sUserName, sPassword);
	  //nav_TierPointLogin(sUserName, sPassword);
} catch (Exception e) {
	// TODO Auto-generated catch block
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
}
  return bLoginStatus;
}

/*==============================================================
MethodName 		: LoginAsARoleCUser
Manual TestCase	: 
Description		: login to navigator as ARoleA user
Author 			: QAASukur Babu. B04
Creation Date 	: 12/30/2015
release Name    : Hague
Pre-Requisites	:
Revision History:

==============================================================*/
public static boolean LoginAsARoleCUser() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.USERID.AROLEC");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.PWD.AROLEC");
	  LoginTestCase.nav_Login(sUserName, sPassword);
} catch (Exception e) {
	// TODO Auto-generated catch block
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
}
  return bLoginStatus;
}
/*==============================================================
MethodName 		: LoginAsARoleCUser
Manual TestCase	: 
Description		: login to navigator as ARoleA user
Author 			: QAASukur Babu. B04
Creation Date 	: 12/30/2015
release Name    : Hague
Pre-Requisites	:
Revision History:

==============================================================*/
public static boolean LoginAsARoleEUser() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.USERID.AROLEE");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.PWD.AROLEE");
	  LoginTestCase.nav_Login(sUserName, sPassword);
} catch (Exception e) {
	// TODO Auto-generated catch block
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
}
  return bLoginStatus;
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
public static boolean LoginAsIshannonUser() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ISHANNON.USERID");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ISHANNON.PASSWORD");
	  LoginTestCase.nav_Login(sUserName, sPassword);
} catch (Exception e) {
	// TODO Auto-generated catch block
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
}
  return bLoginStatus;
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
public static boolean LoginAsAgentUser() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTGETSMART.USERID.AGENT99");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTGETSMART.PWD.AGENT99");
	  LoginTestCase.nav_Login(sUserName, sPassword);
} catch (Exception e) {
	// TODO Auto-generated catch block
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
}
  return bLoginStatus;
}
/*==============================================================
MethodName 		: LoginAsQaautoUser
Manual TestCase	: 
Description		: login to navigator as Qaauto user
Author 			: Sukur Babu. B
Creation Date 	: 12/29/2015
Pre-Requisites	:
Revision History:

==============================================================*/
public static boolean LoginAsQaautoUser() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.USERID.QAAUTO");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.PWD.QAAUTO");
	  LoginTestCase.nav_Login(sUserName, sPassword);
} catch (Exception e) {
	// TODO Auto-generated catch block
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
}
  return bLoginStatus;
}

/*==============================================================
MethodName 		: LoginAsQaautoMMultiOrgUser
Manual TestCase	: 
Description		: login to navigator as Qaauto-M user
Author 			: Arularasu
Creation Date 	: 01/27/2016
Pre-Requisites	:
Revision History:

==============================================================*/
public static boolean LoginAsQaautoMMultiOrgUser() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.QAAUTOM");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PWD.QAAUTOM");
	  LoginTestCase.nav_Login(sUserName, sPassword);
} catch (Exception e) {
	// TODO Auto-generated catch block
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
}
return bLoginStatus;
}

/*==============================================================
MethodName 		: LoginAsQaautoMMultiOrgUser
Manual TestCase	: 
Description		: login to navigator as Qaauto-MC user
Author 			: QAA03
Creation Date 	: 01/28/2016
Pre-Requisites	:
Revision History:

==============================================================*/
public static boolean LoginAsQaautoMCMultiOrgUser() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.QAAUTOMC");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PWD.QAAUTOMC");
	  LoginTestCase.nav_Login(sUserName, sPassword);
} catch (Exception e) {
	// TODO Auto-generated catch block
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
}
  return bLoginStatus;
}
/*==============================================================
MethodName 		: LoginAsQaautoMMultiOrgUser
Manual TestCase	: 
Description		: login to navigator as Qaauto-ME user
Author 			: QAA03
Creation Date 	: 01/28/2016
Pre-Requisites	:
Revision History:

==============================================================*/
public static boolean LoginAsQaautoMEMultiOrgUser() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.USERID.QAAUTOME");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.PWD.QAAUTOME");
	  LoginTestCase.nav_Login(sUserName, sPassword);
} catch (Exception e) {
	// TODO Auto-generated catch block
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
}
  return bLoginStatus;
}
/*==============================================================
MethodName 		: LoginAsEntity01User
Manual TestCase	: 
Description		: login to navigator as Entity 01 user
Author 			: QAA03
Creation Date 	: 01/28/2016
Pre-Requisites	:
Revision History:

==============================================================*/
public static boolean LoginAsEntity01User() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTENTITY01.USERID.ENTITY01A");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTENTITY01.PWD.ENTITY01A");
	  LoginTestCase.nav_Login(sUserName, sPassword);
} catch (Exception e) {
	// TODO Auto-generated catch block
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
}
  return bLoginStatus;
}
/*==============================================================
MethodName 		: LoginAsEntity02User
Manual TestCase	: 
Description		: login to navigator as Entity 02 user
Author 			: QAA03
Creation Date 	: 01/28/2016
Pre-Requisites	:
Revision History:

==============================================================*/
public static boolean LoginAsEntity02User() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTENTITY02.USERID.ENTITY02A");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTENTITY02.PWD.ENTITY02A");
	  LoginTestCase.nav_Login(sUserName, sPassword);
} catch (Exception e) {
	// TODO Auto-generated catch block
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
}
  return bLoginStatus;
}
/*==============================================================
MethodName 		: LoginAsEntity03User
Manual TestCase	: 
Description		: login to navigator as Entity 03 user
Author 			: QAA03
Creation Date 	: 01/28/2016
Pre-Requisites	:
Revision History:

==============================================================*/
public static boolean LoginAsEntity03User() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTENTITY03.USERID.ENTITY03A");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTENTITY03.PWD.ENTITY03A");
	  LoginTestCase.nav_Login(sUserName, sPassword);
} catch (Exception e) {
	// TODO Auto-generated catch block
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
}
  return bLoginStatus;
}


/*==============================================================
MethodName 		: LoginAsEntity04User
Manual TestCase	: 
Description		: 
Author 			: QAA04
Creation Date 	: 03/17/2016
release Name    : Lefcourt
Pre-Requisites	:
Revision History:
==============================================================*/
public static void LoginAsEntity04User() {
	  
	  try {
		String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTENTITY04.USERID.ENTITY04A");
		  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTENTITY04.PWD.ENTITY04A");
		  LoginTestCase.nav_Login(sUserName, sPassword);
	
	  } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}


/*==============================================================
MethodName 		: LoginAsCoopertestUser
Manual TestCase	: 
Description		: login to navigator as Coopertest user
Author 			: QAA03
Creation Date 	: 02/18/2016
Pre-Requisites	:
Revision History:

==============================================================*/
public static boolean LoginAsCoopertestUser() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.COOPERSHAWK.USERID.COOPERTEST");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.COOPERSHAWK.PWD.COOPERTEST");
	  LoginTestCase.nav_Login(sUserName, sPassword);
} catch (Exception e) {
	// TODO Auto-generated catch block
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
}
  return bLoginStatus;
}
/*==============================================================
MethodName 		: LoginAsEfghaUser
Manual TestCase	: 
Description		: 
Author 			: QAA04
Creation Date 	: 01/20/2016
release Name    : Lefcourt
Pre-Requisites	:
Revision History:

==============================================================*/
public static boolean LoginAsEfghaUser() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTANDORDERTOX.USERID.EFGHA");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTANDORDERTOX.PWD.EFGHA");
	  LoginTestCase.nav_Login(sUserName, sPassword);
} catch (Exception e) {
	// TODO Auto-generated catch block
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
}
  return bLoginStatus;
}

/*==============================================================
MethodName 		: LoginAsTstMax02lasttUser
Manual TestCase	: 
Description		: 
Author 			: QAA04
Creation Date 	: 02/08/2016
release Name    : Lefcourt
Pre-Requisites	:
Revision History:

==============================================================*/
public static boolean LoginAsTstMax02lasttUser() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTMAX02.USERID.TSTMAX02LASTT");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTMAX02.PWD.TSTMAX02LASTT");
	  LoginTestCase.nav_Login(sUserName, sPassword);
} catch (Exception e) {
	// TODO Auto-generated catch block
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
}
  return bLoginStatus;
}

/*==============================================================
MethodName 		: LoginAsQaautoCUser
Manual TestCase	: 
Description		: login to navigator as quaauto-C user
Author 			: QAA03
Creation Date 	: 04/12/2016
release Name    : LefCourtSP2
Pre-Requisites	:
Revision History:

==============================================================*/
public static void LoginAsQaautoCUser() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.USERID.QAAUTOC");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.PWD.QAAUTOC");
	  LoginTestCase.nav_Login(sUserName, sPassword);
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}

/*==============================================================
MethodName 		: LoginAsQaautoEUser
Manual TestCase	: 
Description		: login to navigator as quaauto-E user
Author 			: Vivek Kumar
Creation Date 	: 06/23/2016
release Name    : LefCourtSP2
Pre-Requisites	:
Revision History:

==============================================================*/
public static void LoginAsQaautoEUser() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.USERID.QAAUTOE");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.PWD.QAAUTOE");
	  LoginTestCase.nav_Login(sUserName, sPassword);
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
/*==============================================================
MethodName 		: LoginAsQuaautoaUser
Manual TestCase	: 
Description		: login to navigator as quaauto-a user
Author 			: QAA04
Creation Date 	: 03/30/2016
release Name    : Hague
Pre-Requisites	:
Revision History:

==============================================================*/
public static void LoginAsQaautoAUser() {
  
  try {
	  String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.USERID.QAAUTOA");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.PWD.QAAUTOA");
	  LoginTestCase.nav_Login(sUserName, sPassword);
	  //nav_TierPointLogin(sUserName, sPassword);
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}

/*==============================================================
MethodName 		: LoginAsWHSUser
Manual TestCase	: 
Description		: login to navigator as whs.user user
Author 			: Vivek
Creation Date 	: 06/22/2016
release Name    : Kyle
Pre-Requisites	:
Revision History:

==============================================================*/
public static void LoginAsWHSUser() {
	  
	  try {
		  
		String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.WHS.USER.USERID");
		  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.WHS.USER.PASSWORD");
		  LoginTestCase.nav_Login(sUserName, sPassword);
		  
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
/*==============================================================
MethodName 		: LoginAsPottersUser
Manual TestCase	: 
Description		: 
Author 			: QAA03
Creation Date 	: 
release Name    : 
Pre-Requisites	:
Revision History:

==============================================================*/
public static void LoginAsPottersUser() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTMASH4077.USERID.POTTERS");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTMASH4077.PWD.POTTERS");
	  LoginTestCase.nav_Login(sUserName, sPassword);
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}

/*==============================================================
MethodName 		: LoginAsRacing3tUser
Manual TestCase	: 
Description		: login to navigator as racing3t user
Author 			: Vivek Kumar
Creation Date 	: 08/03/2016
release Name    : Valen
Pre-Requisites	:
Revision History:

==============================================================*/
public static void LoginAsRacing3tUser() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TST.RACESTOP3.USERID.RACING3T");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TST.RACESTOP3.PWD.RACING3T");
	  LoginTestCase.nav_Login(sUserName, sPassword);
	  	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  	}
}
/*==============================================================
MethodName 		: LoginAsAbhiRaceStopUser
Manual TestCase	: 
Description		: login to navigator as Abhi.racestop user
Author 			: Vivek Kumar
Creation Date 	: 08/03/2016
release Name    : Valen
Pre-Requisites	:
Revision History:

==============================================================*/
public static void LoginAsAbhiRaceStopUser() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TST.RACESTOP3.USERID.ABHI.RACESTOP");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TST.RACESTOP3.PWD.ABHI.RACESTOP");
	  LoginTestCase.nav_Login(sUserName, sPassword);
	  	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  	}
}

/*==============================================================
MethodName 		: LoginAsRaceStopUser
Manual TestCase	: 
Description		: login to navigator as racestop.user user
Author 			: Vivek Kumar
Creation Date 	: 08/04/2016
release Name    : Valen
Pre-Requisites	:
Revision History:

==============================================================*/
public static void LoginAsRaceStopUser() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TST.RACESTOP3.USERID.RACESTOP.USER");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TST.RACESTOP3.PWD.RACESTOP.USER");
	  LoginTestCase.nav_Login(sUserName, sPassword);
	  	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  	}
}


/*==============================================================
Method Name 	: nav_TierPointLogin
Description		: This method will login to Tier Point Navigator using   sUserName and sPassword
Author 			: Vivek
Creation Date 	: 08/24/2016
Pre-Requisites	:
Revision History: renamed nav_TierPointLogin to nav_Login
==============================================================*/

public static boolean nav_Login_SSO(String sUserName,String sPassword)
{
	String sURL=null,sSummaryURL;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, login);
	//PageFactory.initElements(driver, Home);

	/*if (bLoginStatus==true || WebObjectUtil.bCurrentTestStopped==true){
		forcedLogOut();
	}*/
	sURL = (String)FrameworkUtil.dictPropertyData.get("NAV.QA.URL");
	
	if(WebObjectUtil.isElementPresent(login.getNav_TierPointLogOutPg()))
	{
		/*WebObjectUtil.clickElement(login.getNav_TierPointSignIn());
		driver1.close();
		driver1.quit();*/
		
			//WebDriverUtil.getDriver().get("https://testauth1.lab3.tierpoint.com/cas/login?service=https%3A%2F%2Ftst-lab2-navigator02.lab.hostedsolutions.com%2F%2Fc%2Fportal%2Flogin%3Fredirect%3D%252Fen%252Fhome%26p_l_id%3D10980");
		WebDriverUtil.getDriver().get(sURL);
	}
	/*
	if(bLoginStatus != true || WebObjectUtil.isElementPresent(login.getNav_TierPointUserId()))
	{*/
		try {
		/*sURL = (String)FrameworkUtil.dictPropertyData.get("NAV.QA.URL");
		//String[] arrURL = sURL.split(".com"); 
		//sSummaryURL=arrURL[0]+".com";
		WebDriverUtil.getDriver().get(sURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverUtil.getSeleniumDriver(sURL);*/
		
			//WebDriverUtil.setDriver();
			//Startup_debug.openNavigator();
			String sTierPointURL="https://testauth1.lab3.tierpoint.com/cas/login?service=https%3A%2F%2Ftst-lab2-navigator02.lab.hostedsolutions.com%2F%2Fc%2Fportal%2Flogin%3Fredirect%3D%252Fen%252Fhome%26p_l_id%3D10980";
			WebDriverUtil.getDriver().get(sURL);
			
			//WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, login);
			PageFactory.initElements(driver, Home);
			
	    	WebObjectUtil.SetValueEdit(login.getNav_TierPointUserId(),sUserName );
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebObjectUtil.SetValueEdit(login.getNav_TierPointPwd(),sPassword );
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebObjectUtil.clickElement(login.getNav_TierPointSignIn());
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			boolean bflag=WebObjectUtil.verifyElementPresent(login.getNav_TierPointContinue());
			if (bflag) WebObjectUtil.clickElement(login.getNav_TierPointContinue());
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			WebObjectUtil.waitForPageLoad();
			bLoginStatus=true;
			FrameworkUtil.takeScreenShot();
			//WebDriverUtil.refreshBrowser();
			//HomeTestCase.nav_WindStreamToTierPointHomePopup();
			//WebDriverUtil.getDriver().get("https://tst-lab2-navigator02.lab.hostedsolutions.com");
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
			LoggerUtil.setClassNameForLog("Verify Login");
			LoggerUtil.log_type_error("Login Failed with UserID - " + sUserName);
			bLoginStatus=false;
		}
	//}	
	return bLoginStatus;
}

public static boolean nav_Login(String sUserName,String sPassword){
	boolean bflag = false;
	String sLogoutURL=null,sSSO_URL,sLegacyURL,sSummaryURL,sURL;
	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver, login);
	try {
		sURL = (String)FrameworkUtil.dictPropertyData.get("NAV.QA.URL");
		sLogoutURL = "https://tst-lab2-navigator02.lab.hostedsolutions.com/en/c/portal/logout";
		sLegacyURL = "https://tst-lab2-navigator02.lab.hostedsolutions.com/web/guest/userinfo?p_p_state=maximized&p_p_mode=view&saveLastPath=0&_58_struts_action=%2Flogin%2Flogin&p_p_id=58&p_p_lifecycle=0&_58_redirect=%2Fen%2Fweb%2Fguest%2Fhome";
		sSSO_URL = "https://testauth1.lab3.tierpoint.com/cas/login?service=https://tst-lab2-navigator02.lab.hostedsolutions.com/en/home";
		sSummaryURL = "https://tst-lab2-navigator02.lab.hostedsolutions.com/";
		driver.get(sURL);
		if (WebObjectUtil.isElementPresent(login.getNav_TierPointUserId())){
			bflag =nav_Login_SSO(sUserName, sPassword);
			driver.get(sSummaryURL);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "done", "Logged in with SSO page ");
		}else {
			driver.get(sLogoutURL);
			driver.get(sLegacyURL);
			if(WebObjectUtil.isElementPresent(login.getNav_userId())){
			bflag = nav_Login_legacy(sUserName, sPassword);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Logged in with Navigator legacy(old) page");
			}else{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
			}
		}
	} catch (Exception e) {
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Catch block : Issue with Login to navigator ");
	}
	return bflag;
}

/*==============================================================
MethodName 		: LoginAsTstMax02last02tUser
Manual TestCase	: 
Description		: 
Author 			: QAA03
Creation Date 	: 08/24/2016
release Name    : Valen
Pre-Requisites	:
Revision History:

==============================================================*/
public static boolean LoginAsTstmax02last02tUser() {
  
  try {
	String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTMAX02.USERID.TSTMAX02LAST02T");
	  String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTMAX02.PWD.TSTMAX02LAST02T");
	  LoginTestCase.nav_Login(sUserName, sPassword);
} catch (Exception e) {
	// TODO Auto-generated catch block
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Login to Nagivator", "warn", "Issue with Login to navigator ");
}
  return bLoginStatus;
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


