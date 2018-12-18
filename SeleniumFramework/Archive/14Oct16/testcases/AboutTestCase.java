package com.whs.navigator.testcases;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.AboutPageFactory;


public class AboutTestCase {

	
	//public static LoginPageFactory login = new LoginPageFactory();
	//DocumentPageFactory dashboard = new DocumentPageFactory();
	public static AboutPageFactory aboutPage = new AboutPageFactory();
	/*==============================================================
	TestScript 		: aboutAdminUser
	Manual TestCase	: about page viewable by admins
	Description		: Verifying the about page with admin user
	Author 			: Arularasu
	Creation Date 	: 11/19/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	@Test
	public void callAboutAdminUser(){
		FrameworkUtil.sTestCaseName = "AboutcallAboutAdminUser";
		FrameworkUtil.sManualTestCaseName="about page viewable by admins & Verify Build info present";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		//FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName);
		aboutAdminUser();
	}
	
	public void aboutAdminUser(){

		WebDriver driver = WebDriverUtil.getDriver();
		//PageFactory.initElements(driver, LoginPageFactory.class);
		//PageFactory.initElements(driver, DocumentPageFactory.class);
		PageFactory.initElements(driver, AboutPageFactory.class);
		try {
		//capturing UserName and Password from properties file
		String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.ADMIN.USERID");
		String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.ADMIN.PWD");
		
		//login to Navigator as admin
		//LoginTestCase.nav_Login(sUserName, sPassword);
		LoginTestCase_Old1.LoginAsIshannonUser();
		
		//check for login success
		//WebObjectUtil.assertElementPresent(dashboard.getNav_UserNameLink());
		//WebObjectUtil.VerifyTextOnPage((String)FrameworkUtil.dictPropertyData.get("NAV.ADMIN.USERFULLNAME"));
			
		//Capturing current URL
		String sAboutUrl = (String)FrameworkUtil.dictPropertyData.get("NAV.QA.URL");
		//navigate to about page-Replacing /home from URL to /about and navigating to the new url
		sAboutUrl = sAboutUrl.replace("/home", "/about");
		driver.get(sAboutUrl);
		//Verifying About landing page
		//boolean bstatus =WebObjectUtil.VerifyTextOnPage("Windstream Hosted Solutions Navigator");
		boolean bstatus =WebObjectUtil.VerifyTextOnPage((String)FrameworkUtil.dictPropertyData.get("NAV.ABOUT.ADMIN.PAGETEXT"));
		LoggerUtil.writeStatusLog(bstatus, "Verify About page", "About page verification for admin user");
		//Verifying Build Number, date and Release number
		verifyBuildInfo();
		
		//sign out Navigator
		LoginTestCase_Old1.nav_Signout();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LoggerUtil.log_type_error("issue with navigator about page as admin user");
		}
	}
	/*==============================================================
	TestScript 		: aboutTestUser
	Manual TestCase	: about page not viewable by non-admins
	Description		: Verifying the about page with test user
					  (The build details should not be available for test user)
	Author 			: Arularasu
	Creation Date 	: 11/20/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test
	public void aboutTestUser(){
		
		FrameworkUtil.sTestCaseName = "AboutaboutTestUser";
		FrameworkUtil.sManualTestCaseName = "about page not viewable by non-admins";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		//FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName);
		
		WebDriver driver = WebDriverUtil.getDriver();
		//PageFactory.initElements(driver, LoginPageFactory.class);
		//PageFactory.initElements(driver, DocumentPageFactory.class);
		PageFactory.initElements(driver, AboutPageFactory.class);
		try {
		
		//Capturing UserName and Password from properties file
		String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
		String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
		
		//login to Navigator as test
		//LoginTestCase.nav_Login(sUserName, sPassword);
		LoginTestCase_Old1.LoginAsQaautoUser();
		//check for login success
		//WebObjectUtil.assertElementPresent(dashboard.getNav_UserNameLink());
		//updated user full name to qaauto by Arul on 06/22/16
		WebObjectUtil.VerifyTextOnPage((String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.USERID.QAAUTO.USER.FULLNAME"));
			
		//navigate to about page
		String sAboutUrl = (String)FrameworkUtil.dictPropertyData.get("NAV.QA.URL");
		//Replacing /home from URL to /about and navigating to the new url
		sAboutUrl = sAboutUrl.replace("/home", "/about");
		driver.get(sAboutUrl);
		//Verifying about landing page
		boolean bstatus =WebObjectUtil.VerifyTextNotPresentOnPage("Windstream Hosted Solutions Navigator");
/*			if (!bstatus){
			LoggerUtil.writeStatusLog(true, "Verify About page", "SUCCESS: About page verification for TEST user");
			}else{
				LoggerUtil.writeStatusLog(bstatus, "Verify About page", "FAILURE: About page verification for TEST user");	
			}*/
		//sign out Navigator
		LoginTestCase_Old1.nav_Logout();
		} catch (Exception e) {
			e.printStackTrace();
			LoggerUtil.log_type_error("issue with navigator about page as TEST user");
		}
	}
	/*==============================================================
	Method Name		: verifyBuildInfo
	Manual TestCase	: verify build information
	Description		: Verifying Build information
						1. Release number and value
						2. Build number and date
	Author 			: Vivek Kumar
	Creation Date 	: 12/03/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	//@Test
	public void verifyBuildInfo()
	{

	/*	FrameworkUtil.sTestCaseName = "verifyBuildInfo";
		FrameworkUtil.sManualTestCaseName="verify build information";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		//FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName);
		*/
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, aboutPage);
		//Verifying Release Number, ReleaseNumber Value,
		//Build NumberValue and Build Date Value
		
		WebObjectUtil.verifyElementPresent(aboutPage.getNav_ReleaseNumber());
		WebObjectUtil.verifyElementPresent(aboutPage.getNav_ReleaseNumberValue());
		WebObjectUtil.verifyElementPresent(aboutPage.getNav_BuildNumberValue());
		WebObjectUtil.verifyElementPresent(aboutPage.getNav_BuildDateValue());
		
			
	}
	
	//update each @test result in custom result file
	@AfterMethod
	public static void afterEachMethod(){
		FrameworkUtil.updateTestCaseStatusinResult();
		
	}
	

}
