package com.whs.navigator.testcases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.AboutPageFactory;




//@Test
public  class Startup {
	
//private  String className = this.getClass().getSimpleName();
public static WebDriver driver;
public static String sHTMLheader;
public static String sExecStartTime;
public static String sExecEndTime;

@BeforeSuite	
@Parameters({"browser","browserVersion","OperatingSystemName","OperatingSystemVersion","runningPlatform","TestDatapropertyFileName","SeleniumWorkSpacePath","CustomResultLocation","pickBrowserBasedOnDay"})
public static void initWebDriver(String browser,String browserVersion,String os,String osVersion,String runLocation,String TestDatapropertyFileName, String SeleniumWorkSpacePath,String CustomResultLocation,String pickBrowserBasedOnDay){

WebDriverUtil.browser =  browser;
WebDriverUtil.browserVersion =  browserVersion;
WebDriverUtil.runningPlatform = runLocation;
WebDriverUtil.os = os;
WebDriverUtil.osVersion = osVersion;
FrameworkUtil.sPropertyFile_TestDataFile = TestDatapropertyFileName;
FrameworkUtil.sExecStartTime = FrameworkUtil.getCurrentTimeStamp();
System.out.println("Execution Start time" + FrameworkUtil.sExecStartTime);
FrameworkUtil.getPropListAsDictionary();
driver = WebDriverUtil.getDriver();	
	//current working dir path
	String sWorkingDir = FrameworkUtil.addBackSlash(SeleniumWorkSpacePath)  ;
	//Ant workspace path
	String sANTworkspace = SeleniumWorkSpacePath + "/ANTworkspace/";
	sANTworkspace = FrameworkUtil.addBackSlash(sANTworkspace)  ;
	//Selenium & IE Chrome driver path
	FrameworkUtil.dictPropertyData.put("NAV.LIBRARY.LOCATION", sWorkingDir + "/Libraries/CommonLibs");
	if (WebDriverUtil.runningPlatform.equalsIgnoreCase("SAUCELABS_JENKINS")){
		sANTworkspace = FrameworkUtil.sCurrentWorkingDir + "/WHS_Navigator/" ;
	}
	System.out.println("Current working directory : " + sANTworkspace);  
	
	// Provide Log4j configuration settings
	DOMConfigurator.configure(sANTworkspace +  "log4j.xml");
	

	
	
	try {
		if (pickBrowserBasedOnDay.equalsIgnoreCase("true") )
			selectBrowserBasedonDay(browser);
		WebDriver driver = WebDriverUtil.getDriver();
		
		//FrameworkUtil.sResultPath = FrameworkUtil.addBackSlash((String)FrameworkUtil.dictPropertyData.get("NAV.RESULTLOCATION")); 
		FrameworkUtil.sResultPath = CustomResultLocation;
		FrameworkUtil.createFolder(FrameworkUtil.sResultPath, FrameworkUtil.date_yyyyMMdd());
		FrameworkUtil.sResultPath = FrameworkUtil.sResultPath + FrameworkUtil.date_yyyyMMdd() + "/";
		//FrameworkUtil.sCustomFileName = (String)FrameworkUtil.dictPropertyData.get("NAV.CUSTOMRESULT.FILENAME") + os + osVersion + "_" + browser + browserVersion  ;
		FrameworkUtil.sCustomFileName = (String)FrameworkUtil.dictPropertyData.get("NAV.CUSTOMRESULT.FILENAME")  ;
		FrameworkUtil.sCustomFileName = FrameworkUtil.appendDateTimeStamp(FrameworkUtil.sCustomFileName);
		sHTMLheader = (String)FrameworkUtil.dictPropertyData.get("NAV.CUSTOMRESULT.HEADER");
		
		FrameworkUtil.sTestCaseName = "OpenNavigator";

		FrameworkUtil.writefile(sHTMLheader, FrameworkUtil.sResultPath, FrameworkUtil.sCustomFileName);
		FrameworkUtil.sCustomResultContent = Startup.sHTMLheader;
	
		} catch (Exception e) {
				System.out.println(e.getMessage());
				LoggerUtil.writeStatusLog(false, "Open Navigator", "Navigator failed to open");
				quitWebDriver();
			}
	
	}


@AfterSuite
public static void quitWebDriver(){
	Startup.updateBuildInfoinResult();
	
	WebDriverUtil.getDriver().close();
	WebDriverUtil.getDriver().quit();
	
	
	String sHTMLfooter = "</table></body></html>";
	FrameworkUtil.sExecEndTime = FrameworkUtil.getCurrentTimeStamp();
	String sTimeDiff = FrameworkUtil.timeStampDifference(FrameworkUtil.sExecStartTime, FrameworkUtil.sExecEndTime);
	try {
		FrameworkUtil.writefile(sHTMLfooter, FrameworkUtil.sResultPath, FrameworkUtil.sCustomFileName);
		String sCustomResultContent =  FrameworkUtil.readFile(FrameworkUtil.sResultPath, FrameworkUtil.sCustomFileName);
		FrameworkUtil.writeOnlyfile("", FrameworkUtil.sResultPath, FrameworkUtil.sCustomFileName);
		sCustomResultContent = sCustomResultContent.replace("TESTCASECOUNT", FrameworkUtil.iTestcaseExecuted+"");
		sCustomResultContent = sCustomResultContent.replace("TESTCASEPASSED", FrameworkUtil.iTestcasePassed+"");
		sCustomResultContent = sCustomResultContent.replace("TESTCASEFAILED", FrameworkUtil.iTestcaseFailed+"");
		
		sCustomResultContent = sCustomResultContent.replace("STARTTIMESTAMP", FrameworkUtil.sExecStartTime);
		sCustomResultContent = sCustomResultContent.replace("ENDTIMESTAMP", FrameworkUtil.sExecEndTime);
		sCustomResultContent = sCustomResultContent.replace("TIMEDIFFERENCE", sTimeDiff);
		
		FrameworkUtil.writefile(sCustomResultContent, FrameworkUtil.sResultPath, FrameworkUtil.sCustomFileName);
		
	String sRESULTLOCATION=FrameworkUtil.addBackSlash(FrameworkUtil.sResultPath);
	String sResultFolderNameWithDate = FrameworkUtil.folderNameWithDateStamp(sRESULTLOCATION+  "/Archive/", "NavResult");
	System.out.println("Folder location to copy backup: " + sRESULTLOCATION + "/Archive/" + sResultFolderNameWithDate);
	System.out.println("Folder location to file: " + sRESULTLOCATION + FrameworkUtil.sCustomFileName);
	//FrameworkUtil.copyFileToDir(sRESULTLOCATION + FrameworkUtil.sCustomFileName, sRESULTLOCATION + "/Archive/" + sResultFolderNameWithDate);
	//FrameworkUtil.ArchiveFolder(sRESULTLOCATION, "Archive", "Test");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("Total execute " + FrameworkUtil.iTestcaseExecuted);
	System.out.println("Total passed " + FrameworkUtil.iTestcasePassed);
	System.out.println("Total failed " + FrameworkUtil.iTestcaseFailed);
	System.out.println(FrameworkUtil.sExecEndTime);
	System.out.println("Total Exec time: " + sTimeDiff);
	LoggerUtil.log_type_info("----------------------------------------end of execution---------------------------------" );
	}



//@AfterTest
public static void afterEachTest(){

	
	try {
		String sCustomResultContent;
		//String sTestCaseLink = "<tr><td><div><a onclick=\"ShowTable('TESTCASENAME');\"  href=\"#TESTCASENAME\" > TESTCASENAME </a></div></td></tr>";
		String sHiddenTClinkContent = "<p hidden> UPDATETESTCASELINK </p>";
		//sTestCaseLink = sTestCaseLink.replaceAll("TESTCASENAME", FrameworkUtil.sTestCaseName);
		

	
 		
		sCustomResultContent =  FrameworkUtil.readFile(FrameworkUtil.sResultPath, FrameworkUtil.sCustomFileName);
		FrameworkUtil.writeOnlyfile("", FrameworkUtil.sResultPath, FrameworkUtil.sCustomFileName);
		//sTestCaseLink = sTestCaseLink + sHiddenTClinkContent;
		
		FrameworkUtil.sTestcaseSummaryLinkList = FrameworkUtil.sTestcaseSummaryLinkList.replace("TESTCASEFINALSTATUS", FrameworkUtil.sTestCaseResult);
		
		

 	/*	switch (FrameworkUtil.sTestCaseResult){
			case "PASS":

			FrameworkUtil.sTestcaseSummaryLinkList = FrameworkUtil.sTestcaseSummaryLinkList.replace("style=\"background:white\"", "style=\"background:76ED98\""); //green
			break;
			
			case "FAIL" :
				FrameworkUtil.sTestcaseSummaryLinkList = FrameworkUtil.sTestcaseSummaryLinkList.replace("style=\"background:white\"", "style=\"background:F85D5F\""); //red
			break;
	
			default:
				FrameworkUtil.sTestcaseSummaryLinkList = FrameworkUtil.sTestcaseSummaryLinkList.replace("style=\"background:white\"", "style=\"background:white\"");
				break;
			 }*/
 		
 		
		if (FrameworkUtil.sTestCaseResult.equalsIgnoreCase("pass")){
			FrameworkUtil.sTestcaseSummaryLinkList = FrameworkUtil.sTestcaseSummaryLinkList.replace("style=\"background:white\"", "style=\"background:76ED98\""); //green
		}else if(FrameworkUtil.sTestCaseResult.equalsIgnoreCase("fail")){
			FrameworkUtil.sTestcaseSummaryLinkList = FrameworkUtil.sTestcaseSummaryLinkList.replace("style=\"background:white\"", "style=\"background:F85D5F\""); //red
			FrameworkUtil.sTestCaseResult = "FAIL";
			FrameworkUtil.bTestCaseResultFlag = false;
		}else{
			FrameworkUtil.sTestcaseSummaryLinkList = FrameworkUtil.sTestcaseSummaryLinkList.replace("style=\"background:white\"", "style=\"background:white\"");
		}
		
		
 		FrameworkUtil.sTestcaseSummaryLinkList = FrameworkUtil.sTestcaseSummaryLinkList  + sHiddenTClinkContent;
		sCustomResultContent = sCustomResultContent.replaceFirst(sHiddenTClinkContent, FrameworkUtil.sTestcaseSummaryLinkList);
		FrameworkUtil.writefile(sCustomResultContent, FrameworkUtil.sResultPath, FrameworkUtil.sCustomFileName);

		FrameworkUtil.writefile("</table>", FrameworkUtil.sResultPath, FrameworkUtil.sCustomFileName);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}


@AfterMethod
public static void afterEachMethod(){
	FrameworkUtil.updateTestCaseStatusinResult();
	
}

@Test
public static void openNavigator(){
	
	try {
		FrameworkUtil.sTestCaseName = "OpenNavigator";
		FrameworkUtil.sManualTestCaseName = "Open Navigator";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		LoggerUtil.writeStatusLog(true, "Initialization", "Opening browser "+ WebDriverUtil.browser);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Browser", "Open Browser", "Done", WebDriverUtil.browser + " is opened");
		
		WebDriverUtil.getDriver().get((String)FrameworkUtil.dictPropertyData.get("NAV.QA.URL"));
		String sNavTitle = WebDriverUtil.getDriver().getTitle();
		WebDriverUtil.sParentWindowName = driver.getWindowHandle().toString();
		LoggerUtil.writeStatusLog(WebObjectUtil.compareString(sNavTitle, (String)FrameworkUtil.dictPropertyData.get("NAV.LANDINGPAGE.TITLE"), true), "Open Navigator", "Navigator opened");
		//LoggerUtil.writeStatusLog(WebObjectUtil.VerifyTextOnPage("Username"), "Open Navigator", "Navigator opened");
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Navigator Application", "Open Navigator", "Done", "Navigator opened on "+ WebDriverUtil.browser );
		FrameworkUtil.writefile("</table>", FrameworkUtil.sResultPath, FrameworkUtil.sCustomFileName);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				LoggerUtil.writeStatusLog(false, "Open Navigator", "Navigator failed to open");
				quitWebDriver();
			}
	
	}


public static void updateBuildInfoinResult()
{
	WebDriver driver = WebDriverUtil.getDriver();
	AboutPageFactory aboutPage = new AboutPageFactory();
	PageFactory.initElements(driver, aboutPage);
	//Verifying Release Number, ReleaseNumber Value,
	//Build NumberValue and Build Date Value
	try {
		FrameworkUtil.sTestCaseName = "BuildInfo";
		FrameworkUtil.sManualTestCaseName = "BuildInfo";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		//capturing UserName and Password from properties file
		String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.ADMIN.USERID");
		String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.ADMIN.PWD");
		
		if(LoginTestCase_Old1.bLoginStatus)
		{
			LoginTestCase_Old1.nav_Logout();
		}
		//login to Navigator as admin
		LoginTestCase_Old1.nav_Login(sUserName, sPassword);
		
		//check for login success
		//WebObjectUtil.assertElementPresent(dashboard.getNav_UserNameLink());
		//WebObjectUtil.VerifyTextOnPage((String)FrameworkUtil.dictPropertyData.get("NAV.ADMIN.USERFULLNAME"));
			
		//Capturing current URL
		String sAboutUrl = (String)FrameworkUtil.dictPropertyData.get("NAV.QA.URL");
		//navigate to about page-Replacing /home from URL to /about and navigating to the new url
		sAboutUrl = sAboutUrl.replace("/home", "/about");
		driver.get(sAboutUrl);
		//Verifying About landing page
		boolean bstatus =WebObjectUtil.VerifyTextOnPage("Windstream Hosted Solutions Navigator");
		LoggerUtil.writeStatusLog(bstatus, "Verify About page", "About page verification for admin user");
		//Verifying Build Number, date and Release number
		
		String sRelaseNo = aboutPage.getNav_ReleaseNumberValue().getText();
		String sBuildNo = aboutPage.getNav_BuildNumberValue().getText();
		String sBuildDate = aboutPage.getNav_BuildDateValue().getText();
		String sMachineName = aboutPage.getNav_MachineNameValue().getText();
		FrameworkUtil.findReplaceinResultFile("RELEASENUMBERVALUE", sRelaseNo);
		FrameworkUtil.findReplaceinResultFile("BUILDNUMBERVALUE", sBuildNo);
		FrameworkUtil.findReplaceinResultFile("BUILDDATEVALUE", sBuildDate);
		FrameworkUtil.findReplaceinResultFile("MACHINENAMEVALUE", sMachineName);
		
		//sign out Navigator
		LoginTestCase_Old1.nav_Signout();
		
		//Startup.afterEachTest();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LoggerUtil.log_type_error("issue with navigator about page as admin user");
		}

	
		
}


public static void selectBrowserBasedonDay(String sBrowser){
	
	String sDay = null;
	if(WebDriverUtil.runningPlatform.equalsIgnoreCase("SauceLabs"))
	WebDriverUtil.browserVersion  = "latest-1";
	
	try {
		Date now = new Date();
		SimpleDateFormat simpleDateformat = new SimpleDateFormat("E"); // the day of the week abbreviated
		sDay = simpleDateformat.format(now).toString();
		System.out.println("Day of today is : " + sDay);
		switch (sDay){
		
			case "Mon":
				WebDriverUtil.browser = "FIRFOX";
				break;
			
			case "Tue":
				WebDriverUtil.browser = "CHROME";
				break;
					
			case "Wed":
				WebDriverUtil.browser = "EDGE";
				break;
				
			case "Thu":
				WebDriverUtil.browser = "IE";
				break;
			
			case "Fri":
				WebDriverUtil.browser = "FIREFOX";
				break;
					
			default:
				WebDriverUtil.browser = sBrowser;
				break;
				
		}
	} catch (Exception e) {
		System.out.println("Issue with selecting browser, please check your input");
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Select browser" , "Select browser based on day", "fail", "Issue with selecting browser, please check your input, catch block: Exception occured" +e.getMessage());
	}
	
	}

}

