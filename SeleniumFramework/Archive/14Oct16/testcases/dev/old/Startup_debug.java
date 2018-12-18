package com.whs.navigator.testcases.dev.old;

import java.io.IOException;
import java.text.DateFormat;
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
public  class Startup_debug {
	
//private  String className = this.getClass().getSimpleName();
static FrameworkUtil prop = new FrameworkUtil();
public static String sHTMLheader;
//public static String sExecStartTime;
//public static String sExecEndTime;
	
@BeforeSuite
@Parameters({"browser","browserVersion","OperatingSystemName","OperatingSystemVersion","runningPlatform","TestDatapropertyFileName","WorkspacePath","AntParameter"})
	public static void initWebDriver(String browser,String browserVersion,String os,String osVersion,String runLocation,String TestDatapropertyFileName, String WorkspacePath,String AntParameter){
	
	WebDriverUtil.browser =  browser;
	WebDriverUtil.browserVersion =  browserVersion;
	WebDriverUtil.runningPlatform = runLocation;
	WebDriverUtil.os = os;
	WebDriverUtil.osVersion = osVersion;
	FrameworkUtil.sPropertyFile_TestDataFile = TestDatapropertyFileName;
	FrameworkUtil.sExecStartTime = FrameworkUtil.getCurrentTimeStamp();
	System.out.println(FrameworkUtil.sExecStartTime);
	FrameworkUtil.getPropListAsDictionary();
	FrameworkUtil.sPropertyFile_DynamicPagePactory = "Navigator_DynamicPageFactory.properties";
	FrameworkUtil.getPropListAsDictionary( FrameworkUtil.sPropertyFile_DynamicPagePactory);
	
	System.out.println("Value of Ant parameter : " + AntParameter);
	
	//current working dir path
	FrameworkUtil.sCurrentWorkingDir = System.getProperty("user.dir");

	//FrameworkUtil.sCurrentWorkingDir = AntParameter;

	String sWorkingDir = FrameworkUtil.addBackSlash(FrameworkUtil.sCurrentWorkingDir)  ;
	//Selenium & IE Chrome driver path
	FrameworkUtil.dictPropertyData.put("NAV.LIBRARY.LOCATION", "D:/Selenium-Automation/Libraries/CommonLibs/");
	System.out.println("Current working directory : " + sWorkingDir);  
	
	// Provide Log4j configuration settings
	DOMConfigurator.configure(sWorkingDir +  "log4j.xml");
		
	try {
		WebDriver driver = WebDriverUtil.getDriver();
		
		//FrameworkUtil.sResultPath = FrameworkUtil.addBackSlash((String)FrameworkUtil.dictPropertyData.get("NAV.RESULTLOCATION")); 
		FrameworkUtil.sResultPath = "D:/Selenium-Automation//Results/Navigator/";
        if (AntParameter.contains("debug")){
            FrameworkUtil.sResultPath = "D:/Selenium-Automation//Results/Navigator/debug/";
      }

		//System.out.println((String)FrameworkUtil.dictPropertyData.get("NAV.CUSTOMRESULT.FILENAME"));
		FrameworkUtil.sCustomFileName = (String)FrameworkUtil.dictPropertyData.get("NAV.CUSTOMRESULT.FILENAME");
		FrameworkUtil.sCustomFileName = FrameworkUtil.appendDateTimeStamp(FrameworkUtil.sCustomFileName);
		//sHTMLheader = FrameworkUtil.readFile("D:/EclipseWorkSpace/WHS_Navigator", "HTMLHeaderPart.html");
		//sHTMLheader = FrameworkUtil.readFile(sANTworkspace, "HTMLHeaderPart.html");
		sHTMLheader = (String)FrameworkUtil.dictPropertyData.get("NAV.CUSTOMRESULT.HEADER");
		
		FrameworkUtil.sTestCaseName = "OpenNavigator";
		

		//sHTMLheader ="<!DOCTYPE html><html><head><style>table, th, td {border: 1px solid black;}</style></head><body><table width=\"800\"><tr><th width=\"100\">Step No.:</th><th width=\"200\">Web Object</th><th width=\"200\">Action</th><th width=\"100\">Status</th><th width=\"200\">Remarks</th></tr>";
		FrameworkUtil.writefile(sHTMLheader, FrameworkUtil.sResultPath, FrameworkUtil.sCustomFileName);
		FrameworkUtil.sCustomResultContent = Startup_debug.sHTMLheader;
	
		} catch (Exception e) {
				System.out.println(e.getMessage());
				LoggerUtil.writeStatusLog(false, "Open Navigator", "Navigator failed to open");
				quitWebDriver();
			}
	
	}


@AfterSuite
public static void quitWebDriver(){
	//Startup.updateBuildInfoinResult();
	
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
	String sURL;
	try {
		FrameworkUtil.sTestCaseName = "OpenNavigator";
		FrameworkUtil.sManualTestCaseName = "Open Navigator";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		WebDriver driver = WebDriverUtil.getDriver();
		LoggerUtil.writeStatusLog(true, "Initialization", "Opening browser "+ WebDriverUtil.browser);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Browser", "Open Browser", "Done", WebDriverUtil.browser + " is opened");
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Browser", "Browser details", "Done", WebDriverUtil.getBrowserVersion());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Platform", "Platform details", "Done", WebDriverUtil.getPlatform());
		sURL = (String)FrameworkUtil.dictPropertyData.get("NAV.QA.URL");
		WebDriverUtil.getDriver().get(sURL);
		//WebDriverUtil.getSeleniumDriver(sURL);
		String sNavTitle = WebDriverUtil.getDriver().getTitle();
		String sCurrentURL = WebDriverUtil.getDriver().getCurrentUrl();
		WebDriverUtil.sParentWindowName = WebDriverUtil.getDriver().getWindowHandle();
		LoggerUtil.writeStatusLog(WebObjectUtil.compareString(sNavTitle, (String)FrameworkUtil.dictPropertyData.get("NAV.LANDINGPAGE.TITLE"), true), "Open Navigator", "Navigator opened");
		//LoggerUtil.writeStatusLog(WebObjectUtil.VerifyTextOnPage("Username"), "Open Navigator", "Navigator opened");
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Navigator Application", "Open Navigator", "Done", "Navigator opened with URL: "+ sCurrentURL );
		FrameworkUtil.writefile("</table>", FrameworkUtil.sResultPath, FrameworkUtil.sCustomFileName);

		//Startup.updateBuildInfoinResult();

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
		
		if(LoginTestCase.bLoginStatus)
		{
			LoginTestCase.nav_Logout();
		}
		//login to Navigator as admin
		LoginTestCase.nav_Login(sUserName, sPassword);
		
		//check for login success
		//WebObjectUtil.assertElementPresent(dashboard.getNav_UserNameLink());
		WebObjectUtil.VerifyTextOnPage((String)FrameworkUtil.dictPropertyData.get("NAV.ADMIN.USERFULLNAME"));
			
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
		LoginTestCase.nav_Signout();
		
		//Startup.afterEachTest();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LoggerUtil.log_type_error("issue with navigator about page as admin user");
		}

	
		
}


}

