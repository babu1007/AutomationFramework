package com.whs.navigator.commonUtil;



import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.whs.navigator.commonUtil.WebDriverUtil;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Set;

public class FileDownloader {

   private static final Logger LOG = Logger.getLogger(FileDownloader.class);
   private WebDriver driver;
   private String localDownloadPath = System.getProperty("java.io.tmpdir");
   //private boolean followRedirects = true;
   private boolean followRedirects = false;
   private int httpStatusOfLastDownloadAttempt;

   public FileDownloader(WebDriver driverObject) {
       this.driver = driverObject;
       System.out.println("temp file location " + localDownloadPath);
   }

   /**
    * Specify if the FileDownloader class should follow redirects when trying to download a file
    *
    * @param value
    */
   public void followRedirectsWhenDownloading(boolean value) {
       this.followRedirects = value;
   }

   /**
    * Get the current location that files will be downloaded to.
    *
    * @return The filepath that the file will be downloaded to.
    */
   public String localDownloadPath() {
       return this.localDownloadPath;
   }

   /**
    * Set the path that files will be downloaded to.
    *
    * @param filePath The filepath that the file will be downloaded to.
    */
   public void localDownloadPath(String filePath) {
       this.localDownloadPath = filePath;
   }

   /**
    * Download the file specified in the href attribute of a WebElement
    *
    * @param element
    * @return
    * @throws Exception
    */
   public String downloadFile(WebElement element) throws Exception {
       return downloader(element, "href");
   }

   /**
    * Download the image specified in the src attribute of a WebElement
    *
    * @param element
    * @return
    * @throws Exception
    */
   public String downloadImage(WebElement element) throws Exception {
       return downloader(element, "src");
   }

   /**
    * Gets the HTTP status code of the last download file attempt
    *
    * @return
    */
   public int httpStatusOfLastDownloadAttempt() {
       return this.httpStatusOfLastDownloadAttempt;
   }

   /**
    * Load in all the cookies WebDriver currently knows about so that we can mimic the browser cookie state
    *
    * @param seleniumCookieSet
    * @return
    */
   private HttpState mimicCookieState(Set<org.openqa.selenium.Cookie> seleniumCookieSet) {
       HttpState mimicWebDriverCookieState = new HttpState();
       for (org.openqa.selenium.Cookie seleniumCookie : seleniumCookieSet) {
           Cookie httpClientCookie = new Cookie(seleniumCookie.getDomain(), seleniumCookie.getName(), seleniumCookie.getValue(), seleniumCookie.getPath(), seleniumCookie.getExpiry(), seleniumCookie.isSecure());
           mimicWebDriverCookieState.addCookie(httpClientCookie);
       }

       return mimicWebDriverCookieState;
   }

   /**
    * Set the host configuration based upon the URL of the file/image that will be downloaded
    *
    * @param hostURL
    * @param hostPort
    * @return
    */
   private HostConfiguration setHostDetails(String hostURL, int hostPort) {
       HostConfiguration hostConfig = new HostConfiguration();
       hostConfig.setHost(hostURL, hostPort);

       return hostConfig;
   }

   /**
    * Perform the file/image download.
    *
    * @param element
    * @param attribute
    * @return
    * @throws IOException
    * @throws NullPointerException
    */
   private String downloader(WebElement element, String attribute) throws IOException, NullPointerException {
       String fileToDownloadLocation = element.getAttribute(attribute);
       if (fileToDownloadLocation.trim().equals("")) throw new NullPointerException("The element you have specified does not link to anything!");

       URL fileToDownload = new URL(fileToDownloadLocation);
       File downloadedFile = new File(this.localDownloadPath + fileToDownload.getFile().replaceFirst("/|\\\\", ""));
       if (downloadedFile.canWrite() == false) downloadedFile.setWritable(true);

       HttpClient client = new HttpClient();
       client.getParams().setCookiePolicy(CookiePolicy.RFC_2965);
       client.setHostConfiguration(setHostDetails(fileToDownload.getHost(), fileToDownload.getPort()));
       client.setState(mimicCookieState(this.driver.manage().getCookies()));
       HttpMethod getFileRequest = new GetMethod(fileToDownload.getPath());
       getFileRequest.setFollowRedirects(this.followRedirects);
       LOG.info("Follow redirects when downloading: " + this.followRedirects);

       LOG.info("Sending GET request for: " + fileToDownload.toExternalForm());
       this.httpStatusOfLastDownloadAttempt = client.executeMethod(getFileRequest);
       LOG.info("HTTP GET request status: " + this.httpStatusOfLastDownloadAttempt);
       LOG.info("Downloading file: " + downloadedFile.getName());
       FileUtils.copyInputStreamToFile(getFileRequest.getResponseBodyAsStream(), downloadedFile);
       getFileRequest.releaseConnection();

       String downloadedFileAbsolutePath = downloadedFile.getAbsolutePath();
       LOG.info("File downloaded to '" + downloadedFileAbsolutePath + "'");

       return downloadedFileAbsolutePath;
   }
   
   public static void main(String[] Args){
	    WebDriver driver;
	   String sDriverEXELocation = "D:\\Shared-OffShore\\Selenium Automation\\Libraries\\CommonLibs\\";
       DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
       capabilities.setCapability( InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		System.setProperty("webdriver.ie.driver",sDriverEXELocation + "IEDriverServer.exe");
		driver = new InternetExplorerDriver(capabilities);
		try {	
			   FileDownloader downloadTestFile = new FileDownloader(driver);
			  
			   driver.get("http://automationsamurai.com/");
			   WebElement downloadLink = driver.findElement(By.xpath(".//*[@id='wsite-content']/div[3]/div/div/table/tbody/tr/td[2]/div/div/div/a"));
			   
				String downloadedFileAbsoluteLocation = downloadTestFile.downloadFile(downloadLink);
				System.out.println(downloadedFileAbsoluteLocation);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
   }
   
   public static String fileDownload(WebElement downloadWebElement){
	   WebDriver driver = WebDriverUtil.getDriver();
	   String downloadedFileAbsoluteLocation = null;
		try {	
			   FileDownloader downloadTestFile = new FileDownloader(driver);
			 	downloadedFileAbsoluteLocation = downloadTestFile.downloadFile(downloadWebElement);
				System.out.println(downloadedFileAbsoluteLocation);
			} catch (Exception e) {
			System.out.println("issue with file download " + e.getMessage());
			}
		return downloadedFileAbsoluteLocation ;
  } 
   
}
  

