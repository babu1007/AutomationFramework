package com.whs.navigator.commonUtil;


import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

import com.saucelabs.selenium.client.factory.SeleniumFactory;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import com.whs.navigator.testcases.Startup;

public class WebDriverUtil{
	//public static WebDriver webdriver = new FirefoxDriver();
	
	public static WebDriver webdriver ;
	
 /* public static String browser = (String)FrameworkUtil.dictPropertyData.get("SAUCE.BROWSER");
	public static String browserVersion = (String)FrameworkUtil.dictPropertyData.get("SAUCE.BROWSERVERSION");
	public static String os = (String)FrameworkUtil.dictPropertyData.get("SAUCE.OS");
	public static String osVersion = (String)FrameworkUtil.dictPropertyData.get("SAUCE.OSVERSION");
	public static String SauceUserName = (String)FrameworkUtil.dictPropertyData.get("SAUCE.USERNAME");
	public static String Saucekey = (String)FrameworkUtil.dictPropertyData.get("SAUCE.KEY");
	public static String TestNameOnSauceLabs = "NavigatorTest" + FrameworkUtil.sTimeStamp;
	public static String runningPlatform = "SauceLabs";
	*/
	
	public static String browser ;
	public static String browserVersion ;
	public static String os ;
	public static String osVersion ;
	public static String SauceUserName;
	public static String Saucekey ;
	public static String TestNameOnSauceLabs = "NavigatorTest" + FrameworkUtil.sTimeStamp;
	public static String runningPlatform ;
	public static int maxDuration = 10800;
	public static int commandTimeout = 300;
	public static int idleTimeout = 120;
	public static String sParentWindowName;
	public static SessionId sParentWindowSessionID;
	public static WebDriverBackedSelenium selenium;
	
	protected WebDriverUtil() {
	      // Exists only to defeat instantiation.
	   }
	/*==============================================================
	Method Name		: getDriver
	Description		: Returnig the driver instance
	Author 			: Arularasu
	Creation Date 	: 11/12/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static WebDriver getDriver(){
		if (webdriver == null){
		//d = new FirefoxDriver();
			webdriver =	WebDriverUtil.setDriver();
		}
		return webdriver; 
	}
	
	/*==============================================================
	Method Name		: setDriver
	Description		: creating the  instance
	Author 			: Arularasu
	Creation Date 	: 11/12/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static WebDriver setDriver(){
		
		String sDriverEXELocation = (String)FrameworkUtil.dictPropertyData.get("NAV.LIBRARY.LOCATION");
		
	if(runningPlatform.equalsIgnoreCase("SAUCELABS_JENKINS")){
		WebDriverUtil.remoteDriverSauceLabsJenkins();
	}else{
		
		if (browser.equalsIgnoreCase("FIREFOX")){
			if (runningPlatform.equalsIgnoreCase("local")){
				webdriver = new FirefoxDriver(FirefoxProfileConfig());
				//webdriver = new FirefoxDriver();
			}
			else if(runningPlatform.equalsIgnoreCase("SauceLabs")){
				WebDriverUtil.remoteDriverForSauceLabs("FIREFOX", WebDriverUtil.browserVersion);
			}
	        
		}
		else if(browser.equalsIgnoreCase("CHROME")){
			if (runningPlatform.equalsIgnoreCase("local")){
				System.setProperty("webdriver.chrome.driver",sDriverEXELocation + "chromedriver.exe");
				webdriver = new ChromeDriver();
			}
			else if(runningPlatform.equalsIgnoreCase("SauceLabs")){
				WebDriverUtil.remoteDriverForSauceLabs("CHROME", WebDriverUtil.browserVersion);
			}

			}
		else if(browser.equalsIgnoreCase("IE")){
			if (runningPlatform.equalsIgnoreCase("local")){
	            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
	            capabilities.setCapability( InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
				System.setProperty("webdriver.ie.driver",sDriverEXELocation + "IEDriverServer.exe");
				webdriver = new InternetExplorerDriver(capabilities);
			}
			else if(runningPlatform.equalsIgnoreCase("SauceLabs")){
				WebDriverUtil.remoteDriverForSauceLabs("IE", WebDriverUtil.browserVersion);
			}

			}
		else
		{
			System.out.println("Please set the browser type in testng xml");
		}
	}
		webdriver.manage().window().maximize();
		return webdriver; 
	}
	
	
	private static void remoteDriverForSauceLabs(String sBrowerName,String sBrowserVersion){
		DesiredCapabilities capabilities;
		 SauceUserName = (String)FrameworkUtil.dictPropertyData.get("SAUCE.USERNAME");
		 Saucekey = (String)FrameworkUtil.dictPropertyData.get("SAUCE.KEY");
		 
		 try {
			SauceUserName =FrameworkUtil.getPropValues("SAUCE.USERNAME");
			 Saucekey = FrameworkUtil.getPropValues("SAUCE.KEY");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Choose the browser, version, and platform to test
/* 		switch (sBrowerName){
			case "FIREFOX":
				 capabilities =  DesiredCapabilities.firefox();
				 capabilities.setBrowserName("firefox");
			break;
			
			case "CHROME" :
				 capabilities =  DesiredCapabilities.chrome();
				 capabilities.setBrowserName("chrome");
			break;
			
			case "IE":
				 capabilities =  DesiredCapabilities.internetExplorer();
				 //capabilities.setBrowserName("ie");
				 capabilities.setCapability("browser", "ie");
			break;
			
			default:
				 capabilities =  DesiredCapabilities.firefox();
				 capabilities.setBrowserName("firefox");
				break;
			 }*/
        
		if (sBrowerName.equalsIgnoreCase("FIREFOX")){
			 capabilities =  DesiredCapabilities.firefox();
			 capabilities.setBrowserName("firefox");
		}else if(sBrowerName.equalsIgnoreCase("CHROME")){
			 capabilities =  DesiredCapabilities.chrome();
			 capabilities.setBrowserName("chrome");
		}else if (sBrowerName.equalsIgnoreCase("IE")){
			 capabilities =  DesiredCapabilities.internetExplorer();
			 //capabilities.setBrowserName("ie");
			 capabilities.setCapability("browser", "ie");
		}else{
			 capabilities =  DesiredCapabilities.firefox();
			 capabilities.setBrowserName("firefox");
		}
 		
        
        if ((WebDriverUtil.os.equalsIgnoreCase("windows") || WebDriverUtil.os.startsWith("WIN")) && WebDriverUtil.osVersion.matches("8")  ){
        capabilities.setCapability("platform", Platform.WIN8 );
        }else if ((WebDriverUtil.os.equalsIgnoreCase("windows") || WebDriverUtil.os.startsWith("WIN")) && WebDriverUtil.osVersion.matches("8.1")  ){
        capabilities.setCapability("platform", Platform.WIN8_1);	
        }else if ((WebDriverUtil.os.equalsIgnoreCase("windows") || WebDriverUtil.os.startsWith("WIN")) && (WebDriverUtil.osVersion.matches("7") || WebDriverUtil.osVersion.equalsIgnoreCase("vista")) ){
            //capabilities.setCapability("platform", Platform.WINDOWS);  //Windows 2003
            capabilities.setCapability("platform", Platform.VISTA);  //Windows7
        }else if ((WebDriverUtil.os.equalsIgnoreCase("windows") || WebDriverUtil.os.startsWith("WIN")) && (WebDriverUtil.osVersion.equalsIgnoreCase("xp")) ){
            capabilities.setCapability("platform", Platform.XP);  
        }else if (WebDriverUtil.os.equalsIgnoreCase("linux")){
            capabilities.setCapability("platform", Platform.LINUX);	
        }else if (WebDriverUtil.os.equalsIgnoreCase("unix")){
            capabilities.setCapability("platform", Platform.UNIX);	
        }else{
        	capabilities.setCapability("platform", Platform.ANY);
        }
        
        //capabilities.setCapability("platform", Platform.WIN8 );
        capabilities.setCapability("version", sBrowserVersion);
        capabilities.setCapability("name", WebDriverUtil.TestNameOnSauceLabs);
	capabilities.setCapability("idletimeout", idleTimeout );
	capabilities.setCapability("commandTimeout", commandTimeout  );
	capabilities.setCapability("maxDuration", maxDuration );
        // Create the connection to Sauce Labs to run the tests
        try {
			webdriver = new RemoteWebDriver(
			        new URL("http://" + WebDriverUtil.SauceUserName + ":" + WebDriverUtil.Saucekey + "@ondemand.saucelabs.com:80/wd/hub"),
			        capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
	
	
	public static void remoteDriverSauceLabsJenkins(){
		WebDriver webdriver = SeleniumFactory.createWebDriver();
		/*try {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setBrowserName(System.getenv("SELENIUM_BROWSER"));
		desiredCapabilities.setVersion(System.getenv("SELENIUM_VERSION"));
		desiredCapabilities.setCapability(CapabilityType.PLATFORM, System.getenv("SELENIUM_PLATFORM"));
		
			WebDriver webdriver = new RemoteWebDriver(
			                   new URL("http://" + WebDriverUtil.username + ":" + WebDriverUtil.key + "@ondemand.saucelabs.com:80/wd/hub"),
			                desiredCapabilities);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}*/
	}
	
	
	private static FirefoxProfile FirefoxProfileConfig() {
	        //TODO change and keep profile over here
	        //this.profile = new FirefoxProfile(new File("/home/karel/.mozilla/firefox/1xtgionb.auto-tester"));
		 FirefoxProfile profile = new FirefoxProfile();
		 setPreferences( profile);
	        // Sets native events to true: Can cause problems under Linux
	        // @TODO: Monitor and keep in mind.
	        boolean nativeEvents = true;
	        profile.setEnableNativeEvents(true);
	        profile.setAcceptUntrustedCertificates(true);
	        profile.setPreference("security.default_personal_cert", "Select Automatically");
	        profile.setAssumeUntrustedCertificateIssuer(true);
	        return profile;
	    }
	 
	    private static void setPreferences(FirefoxProfile profile)  {
	    	String downloadDir = (String)FrameworkUtil.dictPropertyData.get("NAV.CUSTOMRESULT.FILENAME");
	        // Use the download folder to dowload files.
	        profile.setPreference("browser.download.folderList", 2);
	        
	        if (downloadDir.length()> 0){
	        // Set download folder
	        profile.setPreference("browser.download.dir", downloadDir);
	        profile.setPreference("browser.download.lastDir", downloadDir);
	        }
	        // Set open new window preferences to allways open tabs when
	        // triggered by javascript.
	        profile.setPreference("browser.link.open_newwindow.restriction", 0);
	        // Not allowed to override
	        //profile.setPreference("browser.link.open_newwindow", 3);
	        
	        // Dont ask where at the following mime types.
	        String mimeTypes = "application/rdf+xml,"
	                        + "text/rdf+n3,"
	                        + "text/turtle,"        
	                        + "text/plain,"
	                        + "application/zip,"
	                        + "application/x-trig,"
	                        + "application/trix,"
	                        + "application/x-binary-rdf,"
	                        + "application/xml";
	       
	        profile.setPreference("browser.helperApps.neverAsk.saveToDisk",mimeTypes);
	        // Do not ask where to save.
	        profile.setPreference("browser.download.useDownloadDir", true);
	        // Don't show download window.
	        profile.setPreference("browser.download.manager.showWhenStarting", false);
	    }
	 
	public static DesiredCapabilities firefoxBrowserLogs(DesiredCapabilities cap){
		LoggingPreferences logs = new LoggingPreferences();
		logs.enable(LogType.BROWSER, Level.ALL);
		logs.enable(LogType.CLIENT, Level.ALL);
		logs.enable(LogType.DRIVER, Level.ALL);
		logs.enable(LogType.PERFORMANCE, Level.ALL);
		logs.enable(LogType.PROFILER, Level.ALL);
		logs.enable(LogType.SERVER, Level.ALL);

		cap.firefox();
		cap.setCapability(CapabilityType.LOGGING_PREFS, logs);

		return cap;
	}
	/*==============================================================
	Method Name		: setbrowserType
	Description		: Setting up the browser
	Author 			: Arularasu
	Creation Date 	: 11/13/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void setbrowserType(String b)
	{
		browser = b;
	}
	
	public static void navigateTo(String sURL){
		webdriver.manage().window().maximize();
		webdriver.get(sURL);
		webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	public static void closeAndClearDriverInstance(){
	webdriver.close();
	webdriver.quit();
	webdriver = null;
	}
	
	/*==============================================================
	Method Name		: getParentWindowName
	Description		: store the parent window(first browser instance) name in variable sParentWindowName
	Author 			: Arularasu
	Creation Date 	: 05/11/2015
	Pre-Requisites	: 
	Revision History:
	==============================================================*/

	public static void getParentWindowName(){
		sParentWindowName = webdriver.getWindowHandle();
	}

	/*==============================================================
	Method Name		: getParentWindowName
	Description		: store the parent window(first browser instance) name in variable sParentWindowName
	Author 			: Arularasu
	Creation Date 	: 05/11/2015
	Pre-Requisites	: 
	Revision History:
	==============================================================*/

	public static void getParentWindowSessionID(){
		sParentWindowSessionID = ((RemoteWebDriver) webdriver).getSessionId();
	}

	public static void refreshBrowser(){
		webdriver.navigate().refresh();
		webdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}


	public static void implicitWait(int iTimeinSeconds){
		webdriver.manage().timeouts().implicitlyWait(iTimeinSeconds, TimeUnit.SECONDS);
	}
	
	
	public static void getSeleniumDriver(String baseUrl){
		selenium = new WebDriverBackedSelenium(getDriver(), baseUrl);
	}
	
	
	/*==============================================================
	Method Name		: getBrowserVersion
	Description		: get browser version
	Author 			: Arularasu
	Creation Date 	: 03/21/2016
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static String getBrowserVersion(){
		Capabilities caps = ((RemoteWebDriver) WebDriverUtil.getDriver()).getCapabilities();
		String browserName = caps.getBrowserName();
		String browserVersion = caps.getVersion();
		return "Browser Name: " + browserName+", Browser version: "+browserVersion;
	}
	
	
	/*==============================================================
	Method Name		: getPlatform
	Description		: get OS 
	Author 			: Arularasu
	Creation Date 	: 03/21/2016
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static String getPlatform(){
		
		String sSystemInfo = null;
		Capabilities caps = null;
		try {
			String sOSName= System.getProperty("os.name").toString();
			String sOSVersion = System.getProperty("os.version").toString();
			
			InetAddress addr = InetAddress.getLocalHost();
			String sMachineName= addr.getHostName();
			String sMachineIP= addr.getHostAddress();
			sSystemInfo = "System info: host: " + sMachineName + ", ip: " +sMachineIP + ", os.name: "+sOSName + ", os.version: " + sOSVersion;
		} catch (Exception e) {
			caps = ((RemoteWebDriver) WebDriverUtil.getDriver()).getCapabilities();
			Platform platform = caps.getPlatform();
			sSystemInfo =  "Platform: " + platform.getCurrent().toString();
		}
		return sSystemInfo;
		
	}
	
}

