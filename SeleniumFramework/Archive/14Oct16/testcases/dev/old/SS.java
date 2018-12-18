package com.whs.navigator.testcases.dev.old;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Flash.FlashObjectWebDriver;
 
public class SS {
 private WebDriver webDriver;
 private String flash_ObjectId;
 
//constructor for FlashSeleniumWebDriver
 public void FlashSeleniumWebDriver(final WebDriver webDriver, final String flash_ObjectId) {
 
//initialize webDriver variable to use in this class methods
 this.webDriver = webDriver;
 
 //initialize flashObjectId variable which have real flash object ID to use in this class methods
 this.flash_ObjectId = flash_ObjectId;
 }
 
public String call(final String functionName, final String... args) {
 
 
 final Object result = ((JavascriptExecutor)webDriver).executeScript(makeJavaScriptFunction(functionName, args),new Object[0]);
 return result != null ? result.toString() : null;
 }
 
private String makeJavaScriptFunction(final String function_Name, final String... args) {
 final StringBuffer function_Args = new StringBuffer();
 
if (args.length > 0) {
	 for (int i = 0; i < args.length; i++) {
		 if (i > 0) {
			 function_Args.append(",");
		 }
		 function_Args.append(String.format("'%1$s'", args[i]));
	 }
 }
 return String.format("return document.%1$s.%2$s(%3$s);",flash_ObjectId,function_Name,function_Args);
 }

public String click(final String objectId) {
    return click(objectId, "");
}
public String click(final String objectId, final String optionalButtonLabel) {
    return callFlashObject("doFlexClick", objectId, optionalButtonLabel);
}
public String callFlashObject(final String functionName, final String... args) {
    final Object result =
          ((JavascriptExecutor)webDriver).executeScript(makeJavaScriptFunction(functionName, args),new Object[0]);

       return result != null ? result.toString() : null;
  }

public static void main(String[] args) throws InterruptedException {
    //FirefoxDriver driver = new FirefoxDriver();
    System.setProperty("webdriver.chrome.driver","D:\\Selenium-Automation\\Libraries\\CommonLibs\\chromedriver.exe");
    ChromeDriver driver=new ChromeDriver();
    //driver.get("http://www.permadi.com/tutorial/flashjscommand/");
    driver.get("https://vcloud-lab0.lab.hostedsolutions.com/cloud/#/adminActivityLogTask?");
  

    
    
    driver.manage().window().maximize();
    //FlashObjectWebDriver flashApp = new FlashObjectWebDriver(driver, "myFlashMovie");
    FlashObjectWebDriver flashApp = new FlashObjectWebDriver(driver, "application");
    flashApp.click("application");
    
    flashApp.callFlashObject("Play"); // first number
	Thread.sleep(3000L);
	flashApp.callFlashObject("StopPlay"); // operation
	
	Thread.sleep(3000L);
	flashApp.callFlashObject("Rewind");  
	System.out.println(flashApp.callFlashObject("GetVariable","/:message"));
	flashApp.callFlashObject("SetVariable","/:message","Learn Flash testing with Webdriver");
	System.out.println(flashApp.callFlashObject("GetVariable","/:message"));
     
}
}