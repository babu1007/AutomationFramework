package com.commonUtils;


import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;

//import com.saucelabs.selenium.client.factory.SeleniumFactory;
//import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;



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
	//public static WebDriverBackedSelenium selenium;
	public static Set<String>  sWindowNamesList;
	
	protected WebDriverUtil() {
	      // Exists only to defeat instantiation.
	   }
	/*==============================================================
	Method Name		: getDriver
	Description		: Returnig the driver instance
	Author 			: Sukur Babu
	Creation Date 	: 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static WebDriver getDriver(){
		if (webdriver == null){
			webdriver =	WebDriverUtil.setDriver();
		}
		return webdriver; 
	}
	
	/*==============================================================
	Method Name		: setDriver
	Description		: creating the  instance
	Author 			: Sukur Babu
	Creation Date 	: 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static WebDriver setDriver(){
		
		try {
			String sDriverEXELocation = (String)FrameworkUtil.dictPropertyData.get("NAV.LIBRARY.LOCATION");
					
		if(runningPlatform.equalsIgnoreCase("SAUCELABS_JENKINS")){
					WebDriverUtil.remoteDriverSauceLabsJenkins();
		}else{
			
			if (browser.equalsIgnoreCase("FIREFOX")){
				if (runningPlatform.equalsIgnoreCase("local")){
					//webdriver = new FirefoxDriver(FirefoxProfileConfig());
					//webdriver = new FirefoxDriver();
					//webdriver = new FirefoxDriver(FirefoxUserDefinedProfile("SeleniumWebDriver"));
					
				}
				else if(runningPlatform.equalsIgnoreCase("SauceLabs")){
					WebDriverUtil.remoteDriverForSauceLabs("FIREFOX", WebDriverUtil.browserVersion);
				}
			    
			}
			else if(browser.equalsIgnoreCase("CHROME")){
				if (runningPlatform.equalsIgnoreCase("local")){
					System.setProperty("webdriver.chrome.driver",sDriverEXELocation + "chromedriver.exe");
					webdriver = new ChromeDriver();
					//Added by Sukur to resolve the issue in chrome Dated on 25/08/2016
					/*System.setProperty("webdriver.chrome.driver",sDriverEXELocation + "chromedriver.exe");
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--disable-extensions");
					
					webdriver = new ChromeDriver(options);*/
					
				}
				else if(runningPlatform.equalsIgnoreCase("SauceLabs")){
					WebDriverUtil.remoteDriverForSauceLabs("CHROME", WebDriverUtil.browserVersion);
				}

				}
			else if(browser.equalsIgnoreCase("IE")){
				if (runningPlatform.equalsIgnoreCase("local")){
			        //DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
					DesiredCapabilities capabilities = desiredCapabilitiesForIE();
			        System.setProperty("webdriver.ie.driver",sDriverEXELocation + "IEDriverServer.exe");
					webdriver = new InternetExplorerDriver(capabilities);
				}
				else if(runningPlatform.equalsIgnoreCase("SauceLabs")){
					WebDriverUtil.remoteDriverForSauceLabs("IE", WebDriverUtil.browserVersion);
				}

				}
			else if(browser.equalsIgnoreCase("EDGE")){
				if (runningPlatform.equalsIgnoreCase("local")){
					EdgeOptions options = new EdgeOptions();
					options.setPageLoadStrategy("eager");
					sDriverEXELocation = (String)FrameworkUtil.dictPropertyData.get("NAV.LIBRARY.MICROSOFT.EDGE.BROWSER.LOCATION");
					System.setProperty("webdriver.edge.driver",sDriverEXELocation + "MicrosoftWebServer.exe");
					webdriver = new EdgeDriver();
				}
				else if(runningPlatform.equalsIgnoreCase("SauceLabs")){
					WebDriverUtil.remoteDriverForSauceLabs("EDGE", WebDriverUtil.browserVersion);
				}

				}
			else
			{
				System.out.println("Please set the browser type in testng xml");
			}
		}
		sParentWindowName = webdriver.getWindowHandle();
		webdriver.manage().window().maximize();
		//added below line to solve execution halt issue in IE
		webdriver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Please set the browser type in testng xml");
		}

		return webdriver; 
	}
	
	/*==============================================================
	Method Name		: remoteDriverForSauceLabs
	Description		: Create remote driver instance on sauce labs
	Author 			: Sukur Babu
	Creation Date 	: 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	private static void remoteDriverForSauceLabs(String sBrowerName,String sBrowserVersion){
		DesiredCapabilities capabilities = null;
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
try {
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
			}else if (sBrowerName.equalsIgnoreCase("EDGE")){
				capabilities = DesiredCapabilities.edge();
				capabilities.setCapability("browser", "MicrosoftEdge");
			}else{
				 capabilities =  DesiredCapabilities.firefox();
				 capabilities.setBrowserName("firefox");
			}
	 		
	        
	        if ((WebDriverUtil.os.equalsIgnoreCase("windows") || WebDriverUtil.os.startsWith("WIN")) && WebDriverUtil.osVersion.matches("8")  ){
	        capabilities.setCapability("platform", Platform.WIN8 );
	        }else if ((WebDriverUtil.os.equalsIgnoreCase("windows") || WebDriverUtil.os.startsWith("WIN")) && WebDriverUtil.osVersion.matches("8.1")  ){
	        capabilities.setCapability("platform", Platform.WIN8_1);	
	        }else if ((WebDriverUtil.os.equalsIgnoreCase("windows") || WebDriverUtil.os.startsWith("WIN")) && WebDriverUtil.osVersion.matches("10")  ){
	        	//capabilities.setCapability("platform", "Windows 10");
	        	capabilities.setCapability("platform", Platform.WIN10);
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
		//capabilities.setCapability("seleniumVersion", "2.52");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        // Create the connection to Sauce Labs to run the tests
        try {
			webdriver = new RemoteWebDriver(new URL("http://" + WebDriverUtil.SauceUserName + ":" + WebDriverUtil.Saucekey + "@ondemand.saucelabs.com:80/wd/hub"),capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
	
	/*==============================================================
	Method Name		: remoteDriverForSauceLabs
	Description		: Create remote driver instance on sauce labs through jenkins
	Author 			: Sukur Babu
	Creation Date 	: 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void remoteDriverSauceLabsJenkins(){
//		WebDriver webdriver = SeleniumFactory.createWebDriver();
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
	
	/*==============================================================
	Method Name		: FirefoxProfileConfig
	Description		: set firefox profile
	Author 			: Sukur Babu
	Creation Date 	: 02/05/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	private static FirefoxProfile FirefoxProfileConfig() {
	        //TODO change and keep profile over here
	        //this.profile = new FirefoxProfile(new File("/home/karel/.mozilla/firefox/1xtgionb.auto-tester"));
		 FirefoxProfile profile = new FirefoxProfile();
		 //profile.setPreference("browser.privatebrowsing.autostart", true);
		 setPreferences( profile);
	        // Sets native events to true: Can cause problems under Linux
	        // @TODO: Monitor and keep in mind.
	        boolean nativeEvents = true;
	        //profile.setEnableNativeEvents(true);
	        profile.setAcceptUntrustedCertificates(true);
	        //profile.setAssumeUntrustedCertificateIssuer(true);
	        profile.setAssumeUntrustedCertificateIssuer(false);
	        
	        profile.setPreference("security.default_personal_cert", "Select Automatically");
	        //profile.setPreference("browser.private.browsing.autostart",true);
	       
	        return profile;
	    }
	 
	/*==============================================================
	Method Name		: FirefoxProfileConfig
	Description		: set firefox profile
	Author 			: Sukur Babu
	Creation Date 	: 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	private static FirefoxProfile FirefoxUserDefinedProfile(String sProfileName) {
	       
		FirefoxProfile profile;
		try {
			ProfilesIni prof = new ProfilesIni();			
			profile = prof.getProfile (sProfileName);
			/*setPreferences( profile);

			    boolean nativeEvents = true;
			    profile.setEnableNativeEvents(true);
			    profile.setAcceptUntrustedCertificates(true);
			    //profile.setAssumeUntrustedCertificateIssuer(true);
			    profile.setAssumeUntrustedCertificateIssuer(false);
			    
			    profile.setPreference("security.default_personal_cert", "Select Automatically");
			  //profile.setPreference("browser.privatebrowsing.autostart", true);
			  //profile.setPreference("browser.private.browsing.autostart",true);
			    */
		} catch (Exception e) {
			profile = FirefoxProfileConfig();
		}
	       
	       
	        return profile;
	    }
	/*==============================================================
	Method Name		: setPreferences
	Description		: set firefox profile
	Author 			: Sukur Babu
	Creation Date 	: 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
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
	 
		/*==============================================================
		Method Name		: firefoxBrowserLogs
		Description		: enable firefox log
		Author 			: Sukur Babu
		Creation Date 	: 
		Pre-Requisites	:
		Revision History:
		==============================================================*/
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
	Method Name		: desiredCapabilitiesForIE
	Description		: Setting up the IE browser
	Author 			: Sukur Babu
	Creation Date 	: 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static DesiredCapabilities desiredCapabilitiesForIE(){
		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		cap.setCapability("nativeEvents", false);
		cap.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
		cap.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, true);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true); 
		cap.internetExplorer().setCapability("ignoreProtectedModeSettings", false);
		//cap.setCapability("IE.binary", "C:/Program Files (x86)/Internet Explorer/iexplore.exe");
		cap.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true); 
		cap.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true); 
		cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true); 
	//Added following as getting following exception
		//Unexpected error launching Internet Explorer. Browser zoom level was set to 150%. It should be set to 100%
		cap.setCapability("ignoreZoomSetting", true);
		
	    cap.setJavascriptEnabled(true);
		return cap;
	}
	
	/*==============================================================
	Method Name		: getBrowserVersion
	Description		: get browser version
	Author 			: Sukur Babu
	Creation Date 	: 
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
	Author 			: Sukur Babu
	Creation Date 	: 
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
	/*==============================================================
	Method Name		: setbrowserType
	Description		: Setting up the browser
	Author 			: Sukur Babu
	Creation Date 	: 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void setbrowserType(String b)
	{
		browser = b;
	}
	
	/*==============================================================
	Method Name		: navigateTo
	Description		: 
	Author 			: Sukur Babu
	Creation Date 	: 
	Pre-Requisites	: 
	Revision History:
	==============================================================*/
	public static void navigateTo(String sURL){
		webdriver.manage().window().maximize();
		webdriver.get(sURL);
		webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Open URL", "Open URL on browser : "+browser, "done",  "URL : " + sURL);
	}
	

	/*==============================================================
	Method Name		: quitWebDriver
	Description		: 
	Author 			: Sukur Babu
	Creation Date 	: 
	Pre-Requisites	: 
	Revision History:
	==============================================================*/
	public static void quitWebDriver(){
	try {
		//webdriver.close();
		webdriver.quit();
		webdriver = null;
		//FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Close browser", "close and clear instance of browser", "done", "killed the browser");
	} catch (Exception e) {
		System.out.println("Issue with cleaning browser instance, might be no browser instance to clean");
	}
	}
	
	/*==============================================================
	Method Name		: getParentWindowName
	Description		: store the parent window(first browser instance) name in variable sParentWindowName
	Author 			: Sukur Babu
	Creation Date 	: 
	Pre-Requisites	: 
	Revision History:
	==============================================================*/

	public static void getParentWindowName(){
		sParentWindowName = webdriver.getWindowHandle();
	}

	/*==============================================================
	Method Name		: getParentWindowSessionID
	Description		: 
	Author 			: Sukur Babu
	Creation Date 	: 
	Pre-Requisites	: 
	Revision History:
	==============================================================*/

	public static void getParentWindowSessionID(){
		sParentWindowSessionID = ((RemoteWebDriver) webdriver).getSessionId();
	}

	/*==============================================================
	Method Name		: refreshBrowser
	Description		: 
	Author 			: Sukur Babu
	Creation Date 	: 
	Pre-Requisites	: 
	Revision History:
	==============================================================*/
	
	public static void refreshBrowser(){
		webdriver.navigate().refresh();
		webdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}


	/*=============================================================
	Method Name		: implicitWait
	Description		: 
	Author 			: Sukur Babu
	Creation Date 	: 
	Pre-Requisites	: 
	Revision History:
	==============================================================*/
	public static void implicitWait(int iTimeinSeconds){
		webdriver.manage().timeouts().implicitlyWait(iTimeinSeconds, TimeUnit.SECONDS);
	}
	

	/*==============================================================
	Method Name		: getSeleniumDriver
	Description		: 
	Author 			: Sukur Babu
	Creation Date 	: 
	Pre-Requisites	: 
	Revision History:
	==============================================================*/
	public static void getSeleniumDriver(String baseUrl){
		//selenium = new WebDriverBackedSelenium(getDriver(), baseUrl);
	}
	
	/*==============================================================
	Method Name		: getBrowserWindowCount
	Description		: 
	Author 			: Sukur Babu
	Creation Date 	: 
	Pre-Requisites	: 
	Revision History:
	==============================================================*/
	public static int getBrowserWindowCount(){

		webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
		sWindowNamesList = webdriver.getWindowHandles();
		int iWindowCount = sWindowNamesList.size();
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Browser window count", "Browser window count", "done", "Current browser windows count[opened by selenium webdriver]:" + iWindowCount);
		return iWindowCount;
	}	
		
}

