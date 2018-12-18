package com.commonUtils;



import java.awt.Robot;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.base.Function;



public class WebObjectUtil {
public static String sOperationname = null;
public static ArrayList arrCustomWebListItems ;
public static ArrayList<WebElement> WebListAsArrayList;
public static List<WebElement> webElementsList ;
public static int iWebElementsCount ;
public static boolean bCurrentTestStopped=false;
public static int iObjectSyncTimeout=60 ;
//WebDriver driver=WebDriverUtil.getDriver();

public static String getOperationName() {
	return sOperationname;
}
public static void setOperationName(String sOperationname) {
	WebObjectUtil.sOperationname = sOperationname;
}
//----------------------------------------------------------------------------------------------------------------
/*==============================================================
Method Name		: isElementPresent
Description		: to check whether element present or not
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:
==============================================================*/
	  public static boolean isElementPresent(WebElement webElement) {
		  
		    try {	
		    	//setOperationName("Check the presents of element");
		    	if (webElement == null) return false;
		    	if (webElement.isDisplayed()){
		    	
		    		//LoggerUtil.log_type_info("Element present :" + FrameworkUtil.sElementName);
		    	}
		      return true;
		    } catch (NoSuchElementException e) {
		    	LoggerUtil.log_type_warn("Element Not present catch block:" + FrameworkUtil.sElementName);
		      return false;
		    }
		  }
	  
	  //----------------------------------------------------------------------------------------------------------------
	
	  /*==============================================================
	  Method Name		: verifyElementPresent
	  Description		: to verify the element present or not on webpage
	  Author 			: Sukur Babu
	  Creation Date 	: 
	  Pre-Requisites	: 
	  Revision History:
	  ==============================================================*/
		
	  public static boolean verifyElementPresent(WebElement webElement) {
		 boolean bStatus = false; 
		 
		    try {
		    	FrameworkUtil.sTestStepStartTime = FrameworkUtil.getCurrentTimeStamp();
				 
		    	if (isElementPresent(webElement)){
		    		bStatus = true;
		    		setOperationName("Verify Element");
		    		LoggerUtil.log_type_info("Element verified :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Element", "pass", "Success: Element Verified ");
		    	}
/*		    	else if (WebObjectUtil.waitForElementPresent(webElement)){
		    		//else if (WebObjectUtil.explicitWait(webElement)){
		    		LoggerUtil.log_type_info("Element verified using Explicit wait :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Element", "warn", "Explicit wait used to verify Element");
		    	}*/
		    	else{
	    			LoggerUtil.log_type_info("Element could not verified :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Element", "fail", "Element could not verified ");
		    			
	    		}
		     // return true;
		    } catch (Exception e) {
		    	LoggerUtil.log_type_error("Element NOT verified :" + FrameworkUtil.sElementName);
		    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element not present", "warn", "Element not Verified");
		     // return false;
		    } 
		    return bStatus;
		  }
	  
	  /*==============================================================
	  Method Name		: verifyElementPresent
	  Description		: to verify the element present or not on webpage and stop execution based on input flag.
	  Author 			: Sukur Babu
	  Creation Date 	: 
	  Pre-Requisites	: 
	  Revision History:
	  ==============================================================*/
		
	  public static boolean verifyElementPresent(WebElement webElement,boolean bStopExecution) {
		  boolean bStatus = false;
		    try {
		    	FrameworkUtil.sTestStepStartTime = FrameworkUtil.getCurrentTimeStamp();
		    	if (isElementPresent(webElement)){
		    		bStatus = true;
		    		setOperationName("Verify Element");
		    		LoggerUtil.log_type_info("Element verified :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Element", "pass", "Success: Element Verified ");
		    	}
/*		    	else if (WebObjectUtil.waitForElementPresent(webElement)){
		    		//else if (WebObjectUtil.explicitWait(webElement)){
		    		LoggerUtil.log_type_info("Element verified using Explicit wait :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Element", "warn", "Explicit wait used to verify Element");
		    	}*/
		    	else{
	    			LoggerUtil.log_type_info("Element could not verified :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Element", "fail", "Element could not verified ");
		    		if (bStopExecution){
		    			stopCurrentTestExecution();
		    		}
		    			
	    		}
		     // return true;
		    } catch (Exception e) {
		    	LoggerUtil.log_type_error("Element NOT verified :" + FrameworkUtil.sElementName);
		    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element not present", "warn", "Element not Verified");
		     // return false;
		    } 
		    return bStatus;
		  }
	  
	  /*==============================================================
	  Method Name		: verifyElementNOTPresent
	  Description		: verify the element NOT present  on webpage
	  Author 			: Sukur Babu
	  Creation Date 	: 
	  Pre-Requisites	: 
	  Revision History:
	  ==============================================================*/
		
	  public static boolean verifyElementNOTPresent(WebElement webElement) {
		  boolean bStatus = false;
		    try {
		    	FrameworkUtil.sTestStepStartTime = FrameworkUtil.getCurrentTimeStamp();
		    	if (!isElementPresent(webElement)){
		    		setOperationName("Verify Element not present");
		    		LoggerUtil.log_type_info("Verified that Element not present :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Element Not present", "pass", "Success: Element not present as expected ");
		    		bStatus = true;
		    	}else{
	    			LoggerUtil.log_type_info("Element could not verified :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Element Not present", "fail", "Element present but expected is Element should noit present");
		    			
	    		}
		     // return true;
		    } catch (Exception e) {
		    	LoggerUtil.log_type_error("catch block: Element NOT verified :" + FrameworkUtil.sElementName);
		    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element not present", "warn", "catch block: Element not Verified");
		     // return false;
		    } 
		    return bStatus;
		  }
	//----------------------------------------------------------------------------------------------------------------
	  /*==============================================================
	  Method Name		: assertElementPresent
	  Description		: to assert the element 
	  Author 			: Sukur Babu
	  Creation Date 	: 
	  Pre-Requisites	: 
	  Revision History:
	  ==============================================================*/
	  public static void assertElementPresent(WebElement webElement) {
		  
		    try {
		    	FrameworkUtil.sTestStepStartTime = FrameworkUtil.getCurrentTimeStamp();
		    	if (isElementPresent(webElement)){
		    		Assert.assertTrue(true);
		    		setOperationName("Assert Element");
		    		LoggerUtil.log_type_info("Element Validated :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Assert Element", "pass", "");
		    	/*}else if (WebObjectUtil.explicitWait(webElement)){
		    		Assert.assertTrue(true);
		    		LoggerUtil.log_type_info("Element Validated using Explicit wait :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Assert Element", "warn", "Explicit wait used to Assert Element");
		    	*/}else{
		    		LoggerUtil.log_type_info("Element could not verified :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Assert Element", "fail", "Element could not verified ");
		    		Assert.assertTrue(false);
		    	}
		     // return true;
		    } catch (Exception e) {
		    	LoggerUtil.log_type_error("catch block:Element NOT Validated :" + FrameworkUtil.sElementName);
		    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Assert Element", "warn", "catch block:Element not Asserted");
		    	Assert.assertTrue(false);
		     // return false;
		    } 
		  } 
	  
	  
	//----------------------------------------------------------------------------------------------------------------
	  /*==============================================================
	  Method Name		: clickAndVerifyElement
	  Description		: Clicking on the element and verifying the element
	  Author 			: Sukur Babu
	  Creation Date 	: 
	  Pre-Requisites	: 
	  Revision History:
	  ==============================================================*/
	  public static boolean clickAndVerifyElement(WebElement webElementClick,WebElement webElementVerify) {
		  
			    try {
			    	FrameworkUtil.sTestStepStartTime = FrameworkUtil.getCurrentTimeStamp();
		    	if (isElementPresent(webElementClick)){
		    		setOperationName("ClickAndVerifyElement");
/*		    		WebObjectUtil.scrollToElement(webElementClick);
		    		WebObjectUtil.scrollElementAtPageCenter(webElementClick);
		    		webElementClick.click();
	*/	    		
		    		WebObjectUtil.clickElement(webElementClick);
		    		WebDriverUtil.webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    		LoggerUtil.log_type_info("clicked on :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Click", "Done", "");
			    		if (webElementVerify.isDisplayed()){
			    			LoggerUtil.log_type_info("verified object : " + FrameworkUtil.sElementName);
			    			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Element", "pass", "");
			    			}else{
			    				LoggerUtil.log_type_info("Element could not verified :" + FrameworkUtil.sElementName);
					    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Element", "fail", "Element could not verified ");
					    		
			    			}
		    		}else{
		    			LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
			    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element not present", "fail", "Element not present/visible ");
		    		}
		      return true;
		    } catch (NoSuchElementException e) {
		    	LoggerUtil.log_type_error("catch block:Element Not present/verified :" + FrameworkUtil.sElementName);
		    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "ClickAndVerify", "warn", "catch block:Could not Verify Element");
		      return false;
		    }
		  }
	  
		//----------------------------------------------------------------------------------------------------------------
	  /*==============================================================
	  Method Name		: clickAndVerifyTextUnderElement
	  Description		: Clicking on the element and verifying the text under that element
	  Author 			: Sukur Babu
	  Creation Date 	: 
	  Pre-Requisites	: 
	  Revision History:
	  ==============================================================*/
	  public static boolean clickAndVerifyTextUnderElement(WebElement webElement, String sText, boolean clickAndVerify) {
		  
			  try {
				  FrameworkUtil.sTestStepStartTime = FrameworkUtil.getCurrentTimeStamp();
		    	if (isElementPresent(webElement)){
		    		setOperationName("verifyTextUnderElement");
		    		if (clickAndVerify){
		    		webElement.click();
		    		WebDriverUtil.webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    		LoggerUtil.log_type_info("clicked on :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Click", "Done", "");
		    		}
		    			if (webElement.getText().contains(sText)){
			    			LoggerUtil.log_type_info("verified text : " + sText);
			    			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Text:"+sText , "Verify Element", "pass", sText);
			    		}else{
			    			LoggerUtil.log_type_info("text could not verified :" + sText);
				    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify text", "fail", "text could not verified " + sText);
				    		
			    		}
		    	}else{
	    			LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element not present", "fail", "Element not present/visible ");
		    		stopCurrentTestExecution();
	    		}
		      return true;
		    } catch (NoSuchElementException e) {
		    	LoggerUtil.log_type_error( "catch block:" + sText + "- Text not verifed under :" + FrameworkUtil.sElementName);
		    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "clickAndVerifyTextUnderElement", "warn", "catch block: Could not Verify Element");
		      return false;
		    }
		  }
	  
		//----------------------------------------------------------------------------------------------------------------
	  /*==============================================================
	  Method Name		: VerifyTextOnPage
	  Description		: Verifying text on page
	  Author 			: Sukur Babu
	  Creation Date 	: 
	  Pre-Requisites	: 
	  Revision History:
	  ==============================================================*/
	  public static boolean VerifyTextOnPage(String sText) {
		  setOperationName("VerifyTextOnPage");
		  boolean bstatus = false;
		  try {
			  WebDriver driver = WebDriverUtil.getDriver();
			  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			  
			  FrameworkUtil.sTestStepStartTime = FrameworkUtil.getCurrentTimeStamp();
			  String sTextOnPage = driver.findElement(By.tagName("body")).getText();
			  if (sTextOnPage.contains(sText)){
				  //System.out.println(driver.findElement(By.tagName("body")).getText());
				  
	    			LoggerUtil.log_type_info("text verified : " + sText);
	    			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Text:"+sText , "Verify Text", "pass", "Text present: "+ sText);
	    			bstatus = true;
	    			}else{
	    				LoggerUtil.log_type_error("text NOT verified : " + sText);
	    		    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Text", "fail", "Text not present: "+ sText);
	    		    	bstatus =  false;
	    			}
			 
	    } catch (NoSuchElementException e) {
	    	LoggerUtil.log_type_error("catch block:text NOT verified : " + sText);
	    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Text", "warn", "catch block:Text not present: "+ sText);
	      return false;
	    }
		return bstatus;  
	  }
	  
	  /*==============================================================
	  Method Name		: VerifyTextUnderElement
	  Description		: Verifying text under specified element
	  Author 			: Sukur Babu
	  Creation Date 	: 
	  Pre-Requisites	: 
	  Revision History:
	  ==============================================================*/
	  public static boolean VerifyTextUnderElement(WebElement webElement, String sText) {
		  setOperationName("VerifyTextUnderElement");
		  boolean bstatus = false;
		  try {
			  WebDriver driver = WebDriverUtil.getDriver();
			  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			  
			  FrameworkUtil.sTestStepStartTime = FrameworkUtil.getCurrentTimeStamp();
			  if (isElementPresent(webElement)){
			  String sTextUnderElement = webElement.getText();
			  if (sTextUnderElement.contains(sText)){
				  
	    			LoggerUtil.log_type_info("text verified under element: " + sText);
	    			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Text  under element", "pass", "Text present: "+ sText);
	    			bstatus = true;
	    			}else{
	    				LoggerUtil.log_type_error("text NOT verified  under element : " + sText);
	    		    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Text  under element", "fail", "Text not present: "+ sText + ", Text displayed on element:" + sTextUnderElement);
	    		    	bstatus =  false;
	    			}
			  }else{
	    			LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "issue with Element", "fail", "Element not present/visible ");
	    		}
	    } catch (NoSuchElementException e) {
	    	LoggerUtil.log_type_error("catch block:Exception Occured on verified  under element: " + sText);
	    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Text  under element", "warn", "Exception Occured: "+ e.getMessage());
	      return false;
	    }
		return bstatus;  
	  }
	  
	  
	  
	  /*==============================================================
	  Method Name		: VerifyTextNotPresentOnPage
	  Description		: Verifying text Not Present on page
	  Creation Date 	: 
	  Pre-Requisites	: 
	  Revision History:
	  ==============================================================*/
	  public static boolean VerifyTextNotPresentOnPage(String sText) {
		  setOperationName("VerifyTextNotPresentOnPage");
		  boolean bstatus = false;
		  try {
			  WebDriver driver = WebDriverUtil.getDriver();
			  FrameworkUtil.sTestStepStartTime = FrameworkUtil.getCurrentTimeStamp();
			  if (!driver.findElement(By.tagName("body")).getText().contains(sText)){
				  //System.out.println(driver.findElement(By.tagName("body")).getText());
	    			LoggerUtil.log_type_info("Text NOT Present : " + sText);
	    			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Text:"+sText , "Text NOT Present", "pass", "Text NOT Present: "+ sText);
	    			bstatus = true;
	    			}else{
	    				LoggerUtil.log_type_error("Text Present : " + sText);
	    		    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Text NOT Present", "fail", "Text Present: "+ sText);
	    		    	bstatus =  false;
	    			}
			 
	    } catch (NoSuchElementException e) {
	    	LoggerUtil.log_type_error("catch block:text NOT verified : " + sText);
	    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Text NOT Present", "warn", "catch block:issue with verifying text : "+ sText);
	      return false;
	    }
		return bstatus;  
	  }
	  
		//----------------------------------------------------------------------------------------------------------------
	  /*==============================================================
	  Method Name		: SetValueEdit
	  Description		: setting the value in the edit field
	  Author 			: Sukur Babu
	  Creation Date 	: 
	  Pre-Requisites	: 
	  Revision History:
	  ==============================================================*/
public static void SetValueEdit(WebElement webElement,String value){
	
	try{
	
		FrameworkUtil.sTestStepStartTime = FrameworkUtil.getCurrentTimeStamp();
	if (isElementPresent(webElement) && webElement.isEnabled()) {
		setOperationName("Enter value");
		webElement.clear();
		webElement.sendKeys(value);	
		LoggerUtil.log_type_info("\"" + value + "\" entered to " + FrameworkUtil.sElementName );
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Enter value", "Done", value);
	}else if (webElement.isEnabled()==false){
		LoggerUtil.log_type_error("Object disbled :" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element disabled", "warn", value);
		stopCurrentTestExecution();
	}else{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Value NOT Entered", "fail", value);
		stopCurrentTestExecution();
	}
	}catch(Exception e){
		LoggerUtil.log_type_error("catch block: Could not set value \"" + value + "\" to webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Enter value", "warn", "catch block: " + e.getMessage());
		stopCurrentTestExecution();
	}
}
	
//----------------------------------------------------------------------------------------------------------------
/*==============================================================
Method Name		: clickElement
Description		: Clicking the webelement
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:
==============================================================*/
public static void clickElement(WebElement webElement){
	
	try{
		FrameworkUtil.sTestStepStartTime = FrameworkUtil.getCurrentTimeStamp();
	if (isElementPresent(webElement)){
		setOperationName("Click");
		webElement.click();
		
		WebObjectUtil.explicitWait(5);
/*		if (WebDriverUtil.browser.equalsIgnoreCase("IE")){
			WebObjectUtil.scrollToElement(webElement);
			webElement.sendKeys(Keys.ENTER);
		}else{
		webElement.click();
		}*/
		LoggerUtil.log_type_info("Clicked on " + FrameworkUtil.sElementName);
		WebDriverUtil.webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Click", "Done", "");
		WebObjectUtil.waitForPageLoad();
	}else{
		LoggerUtil.log_type_error("Could NOT Click on webelement,either element not present/visible " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Click", "fail", "Could NOT click on Element,either element not present/visible ");
		stopCurrentTestExecution();
		
	}
	}catch(Exception e){
		try {
			//WebObjectUtil.scrollToElement(webElement);
			WebObjectUtil.scrollElementAtPageCenter(webElement);
			webElement.click();
			LoggerUtil.log_type_info("Clicked on " + FrameworkUtil.sElementName);
			WebDriverUtil.webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Click", "Done", "");
		} catch (Exception e1) {
			
			try {
				if (!clickByJS(webElement))
				stopCurrentTestExecution();
			} catch (Exception e2) {
				LoggerUtil.log_type_error("catch block:Could NOT Click on webelement,either element not present/visible  " + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Click", "warn", "catch block:Could NOT click on Element,either element not present/visible " + e1.getMessage());
				//FrameworkUtil.bTestCaseResultFlag = false;
				
				stopCurrentTestExecution();
			}
			
			
		}
		
	}
}

//----------------------------------------------------------------------------------------------------------------
/*==============================================================
Method Name		: selectCheckRadioBox
Description		: Selecting Check box
Author 			: 
Creation Date 	: 11/17/2014
Pre-Requisites	: 
Revision History:
==============================================================*/
public static boolean selectCheckRadioBox(WebElement webElement){
	
	boolean status = false;
	try{
		FrameworkUtil.sTestStepStartTime = FrameworkUtil.getCurrentTimeStamp();
	if (isElementPresent(webElement)){
		setOperationName("Select Radio");
		if (!webElement.isSelected()){
			LoggerUtil.log_type_info("Selected/checked on " + FrameworkUtil.sElementName);
			webElement.click();
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Select", "Done", "");
			//call wait method
		}else{
		LoggerUtil.log_type_info("Webelement already selected " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Select", "warn", "");
		}
		status = true;
	}else{
		LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element not present", "fail", "Element not present/visible ");
	}
	}catch(Exception e){
		
		try {
			WebObjectUtil.scrollToElement(webElement);
			webElement.click();
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Select", "Done", "");
		} catch (Exception e1) {
			
			try {
				clickByJS(webElement);
			} catch (Exception e2) {
				LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Select", "warn", "catch block:Could NOT access Element" + e.getMessage());
				
			}
			
			
		}
		
		
		
	}
	
	return status;
}

//----------------------------------------------------------------------------------------------------------------	
 
/*==============================================================
Method Name		: getCheckRadioByValue
Description		: get checkbox/radio as Webelement by passing value
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:
Notes:			  pass null if there is no name attribute for checkbox or radio button
==============================================================*/
public static WebElement getCheckRadioByValue(String sValueText,String sWebElementName, String sWelementType ){
	
	WebDriver driver = WebDriverUtil.getDriver();
	WebElement element = null;
	List<WebElement> oCheckBox = null;
	String sXpath = "//input[@type='" + sWelementType + "']" ;
	
	try{
		FrameworkUtil.sTestStepStartTime = FrameworkUtil.getCurrentTimeStamp();
		// Find the checkbox or radio button element by value
		if (sWebElementName != null ){
			 oCheckBox = driver.findElements(By.name(sWebElementName));
		}else if (sValueText != null && sWelementType != null ){
			 oCheckBox = driver.findElements(By.xpath(sXpath));
		}else{
			return null;
		}

		 int iSize = oCheckBox.size();
		 for(int i=0; i < iSize ; i++ ){
			 String sValue = oCheckBox.get(i).getAttribute("value");
			 if (sValue.equalsIgnoreCase(sValueText)){
				 setOperationName("Find Radio/Check box by Value");
				 LoggerUtil.log_type_error("checkbox/radiobox webelement found" + getWebElementLocator(oCheckBox.get(i)));
				 element= oCheckBox.get(i);
				 break;
				 }
			}
		
	}catch(Exception e){
		setOperationName("Find Radio/Check box by Value");
		LoggerUtil.log_type_error("catch block:Could NOT found checkbox/radiobox with text --> " + sValueText + e.getMessage() );
		
	}
	return element;
}

//----------------------------------------------------------------------------------------------------------------
/*==============================================================
Method Name		: isCheckRadioSelected
Description		: to verify whether radio btn is selected or not
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:
==============================================================*/
public static boolean isCheckRadioSelected(WebElement webElement){
	
	boolean status = false;
	try{
		FrameworkUtil.sTestStepStartTime = FrameworkUtil.getCurrentTimeStamp();
		setOperationName("is Check/Radio box Selected");
	if (isElementPresent(webElement)){
		if (webElement.isSelected()){
			
			LoggerUtil.log_type_info("Webelement already selected " + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "isSelected", "Done", "Already Selected");
			status = true;
		}else{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "isSelected", "Done", "Not Selected");
			status = false;
		}
	}else{
		LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element not present", "fail", "Element not present/visible ");
	}
	}catch(Exception e){
		LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "isSelected", "warn", "catch block:Could NOT access webelement" +e.getMessage());
		
	}
	return status;
	}

//----------------------------------------------------------------------------------------------------------------
/*==============================================================
Method Name		: deSelectCheckBox
Description		: unselect Check/Radio box
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:
==============================================================*/
public static boolean deSelectCheckBox(WebElement webElement){
	
	boolean status = false;
	try{
		FrameworkUtil.sTestStepStartTime = FrameworkUtil.getCurrentTimeStamp();	
	if (isCheckRadioSelected(webElement)){
		webElement.click();
			setOperationName("unselect Check/Radio box");
			LoggerUtil.log_type_info("Webelement deselected " + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "unCheck", "Done", "");
			status = true;
	}
	}catch(Exception e){
		setOperationName("unselect Check/Radio box");
		LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "unCheck", "warn", "catch block:Could NOT access webelement" + e.getMessage());
		
	}
	return status;
}

//----------------------------------------------------------------------------------------------------------------
/*==============================================================
Method Name		: selectWebList
Description		: Select item from the web list
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:
==============================================================*/
public static void selectWebList(WebElement webElement,String byVisibleText, String byValue, Integer byIndex){
	
	try{
		FrameworkUtil.sTestStepStartTime = FrameworkUtil.getCurrentTimeStamp();	
	if (isElementPresent(webElement)){
		setOperationName("Select web list");
		Select select = new Select (webElement);
		//select.deselectAll();
		if (byVisibleText != null){
			select.selectByVisibleText(byVisibleText);
			LoggerUtil.log_type_info("item selected by selectByVisibleText and item is \"" + byVisibleText + "\" and select object(element) is" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Web List Select", "Done", "item selected by selectByVisibleText : " + byVisibleText);
		}else if (byValue != null){
			select.selectByValue(byValue);
			LoggerUtil.log_type_info("item selected by selectByValue and item is \"" + byValue + "\" and select object(element) is" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Web List Select", "Done", "item selected by selectByValue : " + byValue);
		}else if(byIndex != null ){
			select.selectByIndex(byIndex);
			LoggerUtil.log_type_info("item selected by selectByIndex and item is \"" + byIndex + "\" and select object(element) is" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Web List Select", "Done", "item selected by selectByIndex : " + byIndex);
		}else{
			LoggerUtil.log_type_error("item not selected!, please check your input " + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Web List Select", "Done", "item NOT selected");
		}
		
	}else{
		LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Element", "fail", "Element not present/visible ");
	}
	}catch(Exception e){
		setOperationName("Select web list");
		LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Web List Select", "warn", "catch block:Could NOT access webelement" + e.getMessage());

	}
}
//----------------------------------------------------------------------------------------------------------------
/*==============================================================
Method Name		: isMultiSelect
Description		: to check the weblist is multiselect or not
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:
==============================================================*/
public static boolean isMultiSelect(WebElement webElement){
	
	boolean status = false;
	try{
		FrameworkUtil.sTestStepStartTime = FrameworkUtil.getCurrentTimeStamp();
		if (isElementPresent(webElement)){
		Select select = new Select (webElement);
			if (select.isMultiple()){
				setOperationName("isMultiSelect web list");
				LoggerUtil.log_type_info("Weblist allows multi select " + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "is Multi Select", "Done", "");
				status = true;	
			}
		}else{
			LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element NOT present", "fail", "Element not present/visible ");
		}
	}catch(Exception e){
		setOperationName("isMultiSelect web list");
		LoggerUtil.log_type_error("catch block: Could NOT access webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "is Multi Select", "warn", "catch block: Could NOT access webelement" +	e.getMessage());
	
	}
	return status;
}

//----------------------------------------------------------------------------------------------------------------
/*==============================================================
Method Name		: multiSelectWebList
Description		: select multiple item from multiselect weblist 
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:
==============================================================*/
public static void multiSelectWebList(WebElement webElement,String sVisibleTextByCommaSeparated, String sValueByCommaSeparated, String sIndexNumberByCommaSeparated){
	
	try{
	String[] arrMultiSelect = null;
		
	FrameworkUtil.sTestStepStartTime = FrameworkUtil.getCurrentTimeStamp();	
	if (isElementPresent(webElement)){
		setOperationName("Select multi items from web list");
		Select select = new Select (webElement);
		select.deselectAll();
		if (sVisibleTextByCommaSeparated != null){
			if (sVisibleTextByCommaSeparated.contains(",")){
					arrMultiSelect = sVisibleTextByCommaSeparated.split(",");
					for (String valueToBeSelected : arrMultiSelect) {
						select.selectByVisibleText(valueToBeSelected);	
					}
				}
			
			LoggerUtil.log_type_info("Multi item selected by selectByVisibleText and item is \"" + sVisibleTextByCommaSeparated + "\" and select object(element) is" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Multi Select", "Done", "Multi item selected by selectByVisibleText");
		}else if (sValueByCommaSeparated != null){
			if (sValueByCommaSeparated.contains(",")){
				arrMultiSelect = sValueByCommaSeparated.split(",");
				for (String valueToBeSelected : arrMultiSelect) {
					select.selectByValue(valueToBeSelected);
				}
			}
			LoggerUtil.log_type_info("Multi item selected by selectByValue and item is \"" + sValueByCommaSeparated + "\" and select object(element) is" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Multi Select", "Done", "Multi item selected by selectByValue");
		}else if(sIndexNumberByCommaSeparated != null ){
			if (sIndexNumberByCommaSeparated.contains(",")){
				arrMultiSelect = sIndexNumberByCommaSeparated.split(",");
				for (String valueToBeSelected : arrMultiSelect) {
					int iValue = Integer.parseInt(valueToBeSelected);  //convert string to int.
					select.selectByIndex(iValue);	
				}
			}
			
			LoggerUtil.log_type_info("Multi item selected by selectByIndex and item is \"" + sIndexNumberByCommaSeparated + "\" and select object(element) is" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Multi Select", "Done", "Multi item selected by selectByIndex");
		}else{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Multi Select", "fail", "item not selected!");
			LoggerUtil.log_type_error("item not selected!, please check your input " + FrameworkUtil.sElementName);	
		}
	}else{
		LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element NOT present", "fail", "Element not present/visible ");
	}
	}catch(Exception e){
		setOperationName("Select multi items from web list");
		LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , " Multi Select", "warn", "catch block:Could NOT access webelement");
		e.getMessage();
	}
}

//----------------------------------------------------------------------------------------------------------------
/*==============================================================
Method Name		: getElementByText
Description		: get element by passing text
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:
==============================================================*/
public static WebElement getElementByText(String sText){
	WebElement webElement = null;
	setOperationName("Get Element by Text");
	WebDriver driver = WebDriverUtil.getDriver();
	try{
		FrameworkUtil.sTestStepStartTime = FrameworkUtil.getCurrentTimeStamp();
		webElement= driver.findElement(By.linkText(sText));
	//if (WebObjectUtil.isElementPresent(webElement)){
		
		LoggerUtil.log_type_info("Element found by text: " + sText);		
	//}
	}catch (NoSuchElementException e){
		
		LoggerUtil.log_type_info("Element NOT found by text: " + sText + e.getMessage());
	}
	return webElement;
}
//----------------------------------------------------------------------------------------------------------------k
/*==============================================================
Method Name		: explicitWait
Description		: explicitly wait for particular element
Author 			: Sukur Babu
Creation Date 	:
Pre-Requisites	: 
Revision History:
==============================================================*/
public static boolean explicitWait(WebElement webElement){
	setOperationName("explicitWait");
	WebElement element = null;
	try{
		
		WebDriverWait wait = new WebDriverWait(WebDriverUtil.webdriver, 100);
		//element = wait.until(ExpectedConditions.elementToBeClickable(webElement));
		element = wait.until(ExpectedConditions.visibilityOf(webElement));
		LoggerUtil.log_type_info("Explicit wait: " + FrameworkUtil.sElementName);
		return element.isDisplayed() ;
	}catch(Exception e){
		LoggerUtil.log_type_error("Error in Explicit wait for webelement " + FrameworkUtil.sElementName);
		e.getMessage();
		return false;
	}
}


/*==============================================================
Method Name		: explicitWait
Description		: explicitly wait for given time
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:
==============================================================*/
public static void explicitWait(int iTimeinSeconds){
	 
	 try {
		 LoggerUtil.log_type_info("Explicit wait seconds : " + iTimeinSeconds);
		 iTimeinSeconds = iTimeinSeconds * 1000;
		 Thread.sleep(iTimeinSeconds);
	  
	 } catch (InterruptedException e) {
		 LoggerUtil.log_type_error("issue Explicit wait " + e.getMessage());

	 }
	}

/*==============================================================
Method Name		: handleJSAlert
Description		: handling the java script alert
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:
==============================================================*/
public static String handleJSAlert() {
	setOperationName("Handle Javascript alert");
	WebDriver driver = WebDriverUtil.getDriver();
	String sAlertMessage=null;
    try {
    	FrameworkUtil.sTestStepStartTime = FrameworkUtil.getCurrentTimeStamp();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        sAlertMessage = alert.getText();
        //LoggerUtil.log_type_error("JS Alert present - " + alert.getText());
        alert.accept();
        //System.out.println("Alert/msgbox handled");
        LoggerUtil.log_type_info("JS Alert present - " + alert.getText() + " -and  handled successfully");
        FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Handle Javascript alert" , "Accept alert", "done", "JS Alert present - " + alert.getText() + " -and  handled successfully");
        } catch (Exception e) {
        	LoggerUtil.log_type_info("JS Alert NOT present or could not handle" + e.getMessage());
        	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Handle Javascript alert" , "Accept alert", "warn", "JS Alert NOT present , Catch block: " + e.getMessage())  ;
        //exception handling
    }
    
    return sAlertMessage;
}
/*==============================================================
Method Name		: handleHTMLAlert
Description		: handling the html alert
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:
==============================================================*/
public static void handleHTMLAlert(WebElement webElement) {
	setOperationName("Handle HTML alert");
	WebDriver driver = WebDriverUtil.getDriver();
    try {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        
    	if  (WebObjectUtil.isElementPresent(webElement)){ 
    		webElement.click();
    		LoggerUtil.log_type_info("HTML Alert present and handled successfully" + FrameworkUtil.sElementName);
    	}
    	//    System.out.println("Alert/msgbox handled");
        } catch (Exception e) {
        	LoggerUtil.log_type_info("HTML Alert NOT present or Could not handle" + FrameworkUtil.sElementName + e.getMessage());
        //exception handling
    }
}
/*==============================================================
Method Name		: compareString
Description		: compare 2 string either exact or part of it based on flag passed
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:
==============================================================*/
public static boolean compareString(String sSrcString, String sDestString, boolean bIsExactCompare){
	boolean bStatus = false;
	setOperationName("Compare string");
	if (bIsExactCompare){
		if(sSrcString.equalsIgnoreCase(sDestString)){
			bStatus = true;
			LoggerUtil.log_type_info("Both string are equal(case ignored), String1:" + sSrcString + "and String2:" + sDestString);
		}
	}	
		if (sSrcString.contains(sDestString)){
			bStatus = true;
			LoggerUtil.log_type_info("String1 contains String2, String1:" + sSrcString + "and String2:" + sDestString);
			if (!bIsExactCompare){
				//bStatus = false;
				LoggerUtil.log_type_warn("String1 contains String2 but expected is both should be equal, String1:" + sSrcString + "and String2:" + sDestString);
			}
		}
	
	return bStatus;
}


/*==============================================================
Method Name		: ClickAndMouseHover
Description		: click and mouse hover on same element
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:
==============================================================*/
public static void ClickAndMouseHover(WebElement webElement) {
	setOperationName("ClickAndMouseHover");
	WebDriver driver = WebDriverUtil.getDriver();
    try {
    	FrameworkUtil.sTestStepStartTime = FrameworkUtil.getCurrentTimeStamp();
	    	if (isElementPresent(webElement)){
		    	WebObjectUtil.clickElement(webElement);
		    	Actions builder = new Actions(driver) ;
		    	builder.moveToElement(webElement).perform();
		    	Thread.sleep(2000);
	    	}else{
    			LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
	    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element NOT present", "fail", "Element not present/visible ");
	    		stopCurrentTestExecution();
    		}
        } catch (Exception e) {
        	LoggerUtil.log_type_error("ClickAndMouseHover " + FrameworkUtil.sElementName);
        	LoggerUtil.log_type_error("Exception details:" + e.getMessage());
        	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "catch block:ClickAndMouseHover", "warn", "catch block:ClickAndMouseHover"+e.getMessage());
    }
}


/*==============================================================
Method Name		: clickAndVerifyUrl
Description		: click on element and verify URL
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:
==============================================================*/
public static boolean clickAndVerifyUrl(WebElement webElement, String sURL) {
	  
	    try {
	    	FrameworkUtil.sTestStepStartTime = FrameworkUtil.getCurrentTimeStamp();
  	if (isElementPresent(webElement)){
  		setOperationName("clickAndVerifyUrl");
  		WebObjectUtil.clickElement(webElement);
  		WebDriverUtil.webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  		LoggerUtil.log_type_info("clicked on :" + FrameworkUtil.sElementName);
  		String sCurrentUrl = WebDriverUtil.webdriver.getCurrentUrl();
	    		if (WebObjectUtil.compareString(sCurrentUrl, sURL, true)){
	    			LoggerUtil.log_type_info("URL Verified : " + sURL);
	    			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify URL", "pass", "URL Verified : " + sURL);
	    			}
  		}else{
			LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element NOT present", "fail", "Element not present/visible ");
    		stopCurrentTestExecution();
		}
    return true;
  } catch (NoSuchElementException e) {
  	LoggerUtil.log_type_error("Element Not present/verified :" + FrameworkUtil.sElementName + e.getMessage());
  	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "catch block: clickAndVerifyUrl", "warn", "catch block: clickAndVerifyUrl "+e.getMessage());
    return false;
  }
}


/*==============================================================
Method Name		: clickAndVerifyText
Description		: click on element and verify given text
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:
==============================================================*/
public static boolean clickAndVerifyText(WebElement webElement, String sText) {
	  
	    try {
	    	FrameworkUtil.sTestStepStartTime = FrameworkUtil.getCurrentTimeStamp();
  	if (isElementPresent(webElement)){
  		setOperationName("ClickAndVerifyText");
  		webElement.click();
  		WebDriverUtil.webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  		LoggerUtil.log_type_info("clicked on :" + FrameworkUtil.sElementName);
	    		if (WebObjectUtil.VerifyTextOnPage(sText)){
	    			LoggerUtil.log_type_info("Text Verified : " + sText);
	    			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Text under element", "pass", "Text Verified : " + sText);
	    			}
  		}else{
			LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element NOT present", "fail", "Element not present/visible ");
    		stopCurrentTestExecution();
		}
    return true;
  } catch (NoSuchElementException e) {
  	LoggerUtil.log_type_error("Element Not present/verified :" + FrameworkUtil.sElementName);
  	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "catch block: ClickAndVerifyText", "warn", "catch block: ClickAndVerifyText "+e.getMessage());
    return false;
  }
}
/*==============================================================
MethodName 		: verifyUrl
Description		: Verify URL
Author 			: Sukur Babu
Creation Date 	:
Pre-Requisites	:
Revision History:
==============================================================*/
public static boolean verifyUrl(String sURL) {
	  
    try {

	
		WebDriverUtil.webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		LoggerUtil.log_type_info("clicked on :" + FrameworkUtil.sElementName);
		String sCurrentUrl = WebDriverUtil.webdriver.getCurrentUrl();
    		if (WebObjectUtil.compareString(sCurrentUrl, sURL, true)){
    			LoggerUtil.log_type_info("URL Verified : " + sURL);
    			}
		
return true;
} catch (NoSuchElementException e) {
	LoggerUtil.log_type_error("Element Not present/verified :" + FrameworkUtil.sElementName);
return false;
}
}



/*==============================================================
Method Name		: switchToWindow
Description		: switch window based on title or index
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:
==============================================================*/

public static void switchToWindow(int iWindowIndex,String sNewWindowTitle){

int iWinIndex=0;
String sWindowTitle;

setOperationName("switch To Window");

try {
	FrameworkUtil.sTestStepStartTime = FrameworkUtil.getCurrentTimeStamp();
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	WebDriver driver = WebDriverUtil.getDriver();
	WebObjectUtil.explicitWait(10);
	Set<String> handles = driver.getWindowHandles();
	
	
	for (String handle : handles ) {
		iWinIndex++;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().window(handle);
		sWindowTitle = driver.getTitle();
		 new WebDriverWait(driver, 30).until(ExpectedConditions.titleContains(sWindowTitle));
		 waitForPageLoad();
		 Thread.sleep(8000);
		if (iWindowIndex > 1 ){
			if (iWinIndex==iWindowIndex){
				driver.switchTo().window(handle);
				LoggerUtil.log_type_info("Window Switched by index and Window Title :" + sWindowTitle);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Switch Window", "pass", sWindowTitle);
				break;
			}else{
				driver.switchTo().defaultContent();
			}
		}else if(sNewWindowTitle.length() > 0) {
			if ( driver.getTitle().equalsIgnoreCase(sNewWindowTitle) ){
				driver.switchTo().window(handle);
				LoggerUtil.log_type_info("Window Switched by Window Title :" + sWindowTitle);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Switch Window", "pass", sWindowTitle);
				break;
			}else{
				driver.switchTo().defaultContent();
				LoggerUtil.log_type_warn("no switching staying with parent window");
				
			}
		}else{
			driver.switchTo().defaultContent();	
			LoggerUtil.log_type_error("fail to switch window, check with input suppplied");
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Switch Window", "fail", "failed to switch window");
			}
		}
	} catch (Exception e) {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		LoggerUtil.log_type_error("catch block: fail to switch window, check with input suppplied");
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
	}
}


/*==============================================================
Method Name		: switchToParentWindow
Description		: switch to Parent window
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:
==============================================================*/

public static void switchToParentWindow(){
	
	try {
		FrameworkUtil.sTestStepStartTime = FrameworkUtil.getCurrentTimeStamp();
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		WebDriver driver = WebDriverUtil.getDriver();
		driver.switchTo().window(WebDriverUtil.sParentWindowName);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Switch to Parent", "done", "Switching to Parent window");
	} catch (Exception e) {
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Switch to Parent", "warn", "Catch block: Issue with Switching to Parent window " + e.getMessage());
	}
}


/*==============================================================
Method Name		: switchToFrame
Description		: switch to Frame/iFrame
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:
==============================================================*/

public static void switchToFrame(WebElement wFrameElement){
	
	try {
		FrameworkUtil.sTestStepStartTime = FrameworkUtil.getCurrentTimeStamp();
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		WebDriver driver = WebDriverUtil.getDriver();
		driver.switchTo().frame(wFrameElement);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Switch to Frame", "done", "Switching to Frame/iFrame");
	} catch (Exception e) {
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Switch to Frame", "warn", "Catch block: Issue with Switching to Frame/iFrame " + e.getMessage());
	}
}


/*==============================================================
Method Name		: waitForPageLoad
Description		: wait for page to load
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:
==============================================================*/
public static void waitForPageLoad() {
	WebDriver driver = WebDriverUtil.getDriver();
    Wait<WebDriver> wait = new WebDriverWait(driver, 90);
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wait.until(new Function<WebDriver, Boolean>() {
        public Boolean apply(WebDriver driver) {
        	String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"));
            return String
                .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                .equals("complete");
        }
    });
}


/*==============================================================
Method Name		: MouseHover
Description		: mouse hover on given element
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:
==============================================================*/
public static void MouseHover(WebElement webElement) {
	setOperationName("MouseHover");
	WebDriver driver = WebDriverUtil.getDriver();
	
    try {
    	FrameworkUtil.sTestStepStartTime = FrameworkUtil.getCurrentTimeStamp();
	    	if (isElementPresent(webElement)){

	    		WebDriverWait wait = new WebDriverWait(driver, 15, 100);
		    	Actions builder = new Actions(driver) ;
		    	builder.moveToElement(webElement).perform();
				wait.until(ExpectedConditions.elementToBeClickable(webElement));
		/*    	
		    	WebObjectUtil.clickElement(webElement);
		    	builder.build().perform();
		    	Thread.sleep(2000);
		    	WebObjectUtil.clickElement(webElement);*/
	    	}else{
    			LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
	    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element NOT present", "fail", "Element not present/visible ");
    		}
	    	
/*			//#2
	    	Locatable hoverItem = (Locatable) webElement;
	    	Mouse mouse = ((HasInputDevices) driver).getMouse();
	    	mouse.mouseMove(hoverItem.getCoordinates());
	    	
	    	//#3
	    	 hoverItem = (Locatable) webElement;
	    	 int y = hoverItem.getCoordinates().onScreen().getY();
	    	 ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,"+y+");");
	    	 
	    	 
	    	 //#4
	    	 Point coordinates = webElement.getLocation();
	    	 Robot robot = new Robot();
	    	 //webElement.click();
	    	 robot.mouseMove(coordinates.x,coordinates.y+80);
	    	 
	    	 
	    	 //#5

	    	 
*/	    	
    }catch (Exception e) {
        	LoggerUtil.log_type_error("MouseHover " + FrameworkUtil.sElementName);
        	LoggerUtil.log_type_error("Exception details:" + e.getMessage());
        //exception handling
    }
}

/*==============================================================
Method Name		: selectCustomWebList
Description		: select item by text from custom weblist with ul-li combination
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:
note: 			//this will work noly fo ul-li tags. pass ul tag as webElement and li as "text"
==============================================================*/

	public static boolean selectCustomWebList(WebElement webElement,String sVisibleText){
		String sItem = null;
		boolean flag = false;
		
	    	try {
	    		FrameworkUtil.sTestStepStartTime = FrameworkUtil.getCurrentTimeStamp();
				if (WebObjectUtil.isElementPresent(webElement)){
					
					if (WebDriverUtil.browser.equalsIgnoreCase("ie")) {
						return WebObjectUtil.selectCustomWebListIE(webElement, sVisibleText, null);
					}
					//WebObjectUtil.MouseHover(webElement);
					List<WebElement> webListItems = webElement.findElements(By.tagName("li"));
					if (sItem=="" && webElement.getText()=="" ){
						webListItems = WebObjectUtil.getActiveElementasWebElement((String)FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH")).findElements(By.tagName("li"));
					}
					
					for (WebElement wb: webListItems){
						sItem =wb.getText() ;
					//	WebObjectUtil.explicitWait(2);
	
						if (sItem.contains(sVisibleText)){
							//WebObjectUtil.MouseHover(webElement);
							WebObjectUtil.explicitWait(2);
							wb.click();
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Select Item from Custom WebList", "pass", "Item selected: "+ sVisibleText);
							flag = true;
							break;
						}
					}
				}else{
	    			LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element NOT present", "fail", "Element not present/visible ");
	    		}
				if (!flag){
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Select Item from Custom WebList", "warn", "Item Not found/selected: "+ sVisibleText);	
				}
			} catch (Exception e) {
				LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "selectCustomWebList", "warn", "catch block:Could NOT access webelement" +e.getMessage());
			}
	    	return flag;
	}

	
	/*==============================================================
	Method Name		: selectCustomWebList
	Description		: select item by index from custom weblist with ul-li combination
	Author 			: Sukur Babu
	Creation Date 	: 
	Pre-Requisites	: 
	Revision History:
	note: 				//this will work noly fo ul-li tags. pass ul tag as webElement and pass index no. to select item.
						//index starts with 1
	==============================================================*/	

		public static boolean selectCustomWebList(WebElement webElement,int iByIndex){
			int iItem = 0,iTemp;
			String sItem = null;
			boolean flag = false;
		    	try {
		    		FrameworkUtil.sTestStepStartTime = FrameworkUtil.getCurrentTimeStamp();
		    	
					if (WebObjectUtil.isElementPresent(webElement)){
						//WebObjectUtil.MouseHover(webElement);
						if (WebDriverUtil.browser.equalsIgnoreCase("ie")) {
							return WebObjectUtil.selectCustomWebListIE(webElement, null, iByIndex);
						}
						List<WebElement> webListItems = webElement.findElements(By.tagName("li"));
						if (sItem=="" && webElement.getText()=="" ){
							webListItems = WebObjectUtil.getActiveElementasWebElement((String)FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH")).findElements(By.tagName("li"));
						}
						
						for (WebElement wb: webListItems){
							sItem =wb.getText() ;
							iTemp = iItem + 1;
							if (iByIndex == iTemp){
								//WebObjectUtil.MouseHover(webElement);
								WebObjectUtil.explicitWait(2);
								wb.click();
								WebObjectUtil.explicitWait(2);
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Select Item from Custom WebList", "pass", "Item selected: By Index No." + iByIndex + ", Item: "+sItem);
								flag = true;
								break;
							}
							iItem++;

						}
					}else{
		    			LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
			    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element NOT present", "fail", "Element not present/visible ");
		    		}
				if (!flag){
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Select Item from Custom WebList", "warn", "Item NOT selected: By Index No." + iByIndex);	
				}
				} catch (Exception e) {
					LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "selectCustomWebList", "warn", "catch block:Could NOT access webelement" +e.getMessage());
				}
		    	return flag;
		}

	

/*==============================================================
Method Name		: selectCustomWebListIE
Description		: select item by text OR Index from custom weblist with ul-li combination works for IE Browser
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:
note: 			//this will work noly fo ul-li tags. pass ul tag as webElement and li as "text"
==============================================================*/

	public static boolean selectCustomWebListIE(WebElement webElement,String sVisibleText,Integer iByIndex){
		String sItem = null;
		boolean flag = false;
		int iTemp,iItem = 0;
	    	try {
	    		FrameworkUtil.sTestStepStartTime = FrameworkUtil.getCurrentTimeStamp();
				if (WebObjectUtil.isElementPresent(webElement)){
					//WebObjectUtil.MouseHover(webElement);
					List<WebElement> webListItems = webElement.findElements(By.tagName("li"));
					if (sItem=="" && webElement.getText()=="" ){
						webListItems = WebObjectUtil.getActiveElementasWebElement((String)FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH")).findElements(By.tagName("li"));
					}
					for (WebElement wb: webListItems){
						sItem =wb.getText() ;
						iTemp = iItem + 1;
						WebObjectUtil.explicitWait(2);
							wb.sendKeys(Keys.DOWN);
							wb.sendKeys(Keys.UP);
						if (sVisibleText != null && sItem.contains(sVisibleText)){
							WebObjectUtil.explicitWait(2);
							wb.sendKeys(Keys.ENTER);
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Select Item from Custom WebList", "pass", "Item selected: "+ sVisibleText);
							flag = true;
							break;
						}else if (iByIndex != null && iByIndex == iTemp ){

							WebObjectUtil.explicitWait(2);
							wb.sendKeys(Keys.ENTER);
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Select Item from Custom WebList", "pass", "Item selected: By Index No." + iByIndex + ", Item: "+sItem);
							flag = true;
							break;
						}
							wb.sendKeys(Keys.DOWN);
							iItem++;
					}
				}else{
	    			LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element NOT present", "fail", "Element not present/visible ");
	    		}
				if (!flag){
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Select Item from Custom WebList", "warn", "Item Not found/selected: "+ sVisibleText);	
				}
			} catch (Exception e) {
				LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "selectCustomWebList", "warn", "catch block:Could NOT access webelement" +e.getMessage());
			}
	    	return flag;
	}

		
		/*==============================================================
		Method Name		: getToolTipsMsg
		Description		: verify tooltip text for given element
		Author 			: Sukur Babu
		Creation Date 	: 
		Pre-Requisites	: 
		Revision History:
		note: 			//this method get the innerHTML of element, so pass the parent webElement to this method
						// do not pass element with has "input" tag. instead pass parent of input tag.
		==============================================================*/	

public static boolean getToolTipsMsg(WebElement webElement,String sTooltipMsg){
	boolean bStatus = false;
	String sToolTipFromWeb;
	
	try {
		FrameworkUtil.sTestStepStartTime = FrameworkUtil.getCurrentTimeStamp();
		if (isElementPresent(webElement)){
			System.out.println(webElement.getText());
			sToolTipFromWeb = webElement.getAttribute("innerHTML");
			//sToolTipFromWeb = (String)((JavascriptExecutor)driver).executeScript("return arguments[0].innerHTML;", webElement);
			if (sToolTipFromWeb.contains(sTooltipMsg)){
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Tool Tips", "pass", "Text present: "+ sTooltipMsg);
					bStatus = true;
				}else{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify Tool Tips", "pass", "Text present: "+ sTooltipMsg);
				}
		}else{
			LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element NOT present", "fail", "Element not present/visible ");
		}
	} catch (Exception e) {
		LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "getToolTipsMsg", "warn", "catch block:Could NOT access webelement" +e.getMessage());

	}
	
	
	return bStatus;
	
	}
		
		

/*==============================================================
Method Name		: waitForElementPresent
Description		: wait for element to be present
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:
==============================================================*/
public static boolean waitForElementPresent(WebElement webElement){
	int iTimeOut = 0,iStartTime,iEndTime = 0;
boolean bStatus = false;
boolean bElementStatus = false;
String sStartTime,sEndTime;
long TimeDiff = 0;
		try {
			Date date=new Date();
			
			iStartTime = date.getSeconds();
			
			while(!bElementStatus )
			{
				bElementStatus = WebObjectUtil.isElementPresent(webElement);
				iEndTime = iEndTime + date.getSeconds();
				if (iEndTime >= WebObjectUtil.iObjectSyncTimeout) break;
				   
			}
/*			sStartTime = FrameworkUtil.getCurrentTimeStamp();
			while(!bElementStatus )      //while(!bElementStatus || iTimeOut <= 30 )
			{
				bElementStatus = WebObjectUtil.isElementPresent(webElement);
				   try {
					Thread.sleep(1000);
					iTimeOut++;
					sEndTime = FrameworkUtil.getCurrentTimeStamp();
					TimeDiff = TimeDiff + FrameworkUtil.timeDiffInSeconds(sStartTime, sEndTime);
					if(iTimeOut >= 5 || TimeDiff >= 45){
						bElementStatus= true;
					}
				} catch (Exception e) {
					LoggerUtil.log_type_error("waitForElementPresent catch block :" + e.getMessage());
				}
			}*/
			if (WebObjectUtil.isElementPresent(webElement)){
				bStatus = true;
			}
		} catch (Exception e) {
			LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "waitForElementPresent", "warn", "catch block:Could NOT access webelement" +e.getMessage());

		}
		
	return bStatus;	
}

/*==============================================================
Method Name		: waitForElementNotPresent
Description		: wait for element to be NOT present
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:
==============================================================*/
public static boolean waitForElementNotPresent(WebElement webElement){
	int iTimeOut = 0,iStartTime,iEndTime = 0;
	boolean bStatus = false;
	boolean bElementStatus = true;
	String sStartTime,sEndTime;
	long TimeDiff = 0;

	try {
		Date date=new Date();
		
		iStartTime = date.getSeconds();
		
		while(bElementStatus )
		{
			bElementStatus = WebObjectUtil.isElementPresent(webElement);
			iEndTime = iEndTime + date.getSeconds();
			if (iEndTime >= WebObjectUtil.iObjectSyncTimeout) break;
			   
		}
		/*sStartTime = FrameworkUtil.getCurrentTimeStamp();
		while(bElementStatus )      //while(bElementStatus || iTimeOut <= 30 )
			{
				bElementStatus = WebObjectUtil.isElementPresent(webElement);
				   try {
					Thread.sleep(1000);
					iTimeOut++;
					sEndTime = FrameworkUtil.getCurrentTimeStamp();
					TimeDiff = TimeDiff + FrameworkUtil.timeDiffInSeconds(sStartTime, sEndTime);
					if(iTimeOut >= 5 || TimeDiff >= 45){
						bElementStatus= false;
					}
				} catch (Exception e) {
					LoggerUtil.log_type_error("waitForElementNotPresent catch block :" + e.getMessage());
				}
			}*/
if (!WebObjectUtil.isElementPresent(webElement)){
		bStatus = true;
}
	} catch (Exception e) {
		LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "waitForElementNotPresent", "warn", "catch block:Could NOT access webelement" +e.getMessage());
	}


return bStatus;	

}

/*
==============================================================
MethodName 		: GetWebElement
Description		: get as web element from its locator
Author 			: Sukur Babu
Creation Date 	:
Pre-Requisites	:
Revision History:
==============================================================

public static WebElement GetWebElement(String sLocatorType, String sLocatorValue,String sElementName){
    WebElement webElement = null ;
    By by ;
    try {
    if (sLocatorType.equalsIgnoreCase("id")){
          by = By.id(sLocatorValue);    
    }else if (sLocatorType.equalsIgnoreCase("name")){
          by = By.name(sLocatorValue);  
    }else if (sLocatorType.equalsIgnoreCase("xpath")){
          by = By.xpath(sLocatorValue); 
    }else if (sLocatorType.equalsIgnoreCase("linktext")){
          by = By.linkText(sLocatorValue);    
    }else if (sLocatorType.contains("partiallinktext")){
          by = By.partialLinkText(sLocatorValue);   
    }else if (sLocatorType.contains("css")){
          by = By.cssSelector(sLocatorValue); 
    }else if (sLocatorType.contains("class")){
          by = By.className(sLocatorValue);   
    }else if (sLocatorType.equalsIgnoreCase("tagname")){
          by = By.tagName(sLocatorValue);     
    }else{
          by = By.xpath(sLocatorValue);
    }
    if (WebDriverUtil.getDriver().findElement(by).isDisplayed()){
    webElement = WebDriverUtil.getDriver().findElement(by);
    FrameworkUtil.sElementName = sElementName;
    }
    //    webElement = driver.sfindElement;
    } catch (Exception e) {
    	LoggerUtil.log_type_error("catch block: GetWebElement " + e.getMessage());
          FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "GetWebElement", "issue with Identifying Element" , "warn",e.getMessage());
    }
return webElement;
}

*/



/*==============================================================
MethodName 		: GetWebElement
Description		: get as web element from its locator
Author 			: Sukur Babu
Creation Date 	:
Pre-Requisites	:
Revision History:
==============================================================*/

public static WebElement GetWebElement(String sLocatorType, String sLocatorValue,String sElementName){
    WebElement webElement = null ;
    By by ;
    try {
    if (sLocatorType.equalsIgnoreCase("id")){
          by = By.id(sLocatorValue);    
    }else if (sLocatorType.equalsIgnoreCase("name")){
          by = By.name(sLocatorValue);  
    }else if (sLocatorType.equalsIgnoreCase("xpath")){
          by = By.xpath(sLocatorValue); 
    }else if (sLocatorType.equalsIgnoreCase("linktext")){
          by = By.linkText(sLocatorValue);    
    }else if (sLocatorType.contains("partiallinktext")){
          by = By.partialLinkText(sLocatorValue);   
    }else if (sLocatorType.contains("css")){
          by = By.cssSelector(sLocatorValue); 
    }else if (sLocatorType.contains("class")){
          by = By.className(sLocatorValue);   
    }else if (sLocatorType.equalsIgnoreCase("tagname")){
          by = By.tagName(sLocatorValue);     
    }else{
          by = By.xpath(sLocatorValue);
    }
    
    
    webElementsList = WebDriverUtil.getDriver().findElements(by);
    iWebElementsCount =webElementsList.size();
    if(iWebElementsCount > 1){
        webElement = webElementsList.get(0);
        FrameworkUtil.sElementName = sElementName;
        //FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "GetWebElement:"+sElementName, "multiple Element found", "warn", "More than one element found, please find tune your locator, current locator details ->"+ sLocatorType +":" + sLocatorValue);
    }
    else{
	    if (WebDriverUtil.getDriver().findElement(by).isDisplayed()){
	    webElement = WebDriverUtil.getDriver().findElement(by);
	    FrameworkUtil.sElementName = sElementName;
	    }
    }
/*    
    if (WebDriverUtil.getDriver().findElement(by).isDisplayed()){
	    webElement = WebDriverUtil.getDriver().findElement(by);
	    FrameworkUtil.sElementName = sElementName;
	}*/
    
    //    webElement = driver.sfindElement;
    } catch (Exception e) {
    	LoggerUtil.log_type_error("catch block: GetWebElement " + e.getMessage());
          FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "GetWebElement:"+sElementName, "issue with Identifying Element" , "warn","Element NOT found/Visible, " + sLocatorType +":" + sLocatorValue);
          FrameworkUtil.takeScreenShot();
    }
return webElement;
}




/*==============================================================
MethodName 		: getElementbyTagNameValue
Description		: get as web element from tagname and its value
Author 			: Sukur Babu
Creation Date 	:
Pre-Requisites	:
Revision History:
==============================================================*/
public static WebElement getElementbyTagNameValue(String sTagName, String sTagValue,String sElementName){
	WebElement webElement = null ;
	WebDriver driver = WebDriverUtil.getDriver();
	
	try {
		WebElement body = driver.findElement(By.tagName("body"));
		List<WebElement> span  = body.findElements(By.tagName(sTagName));
		
		for (WebElement wb: span){
			if (wb.isDisplayed() && wb.getText().equalsIgnoreCase(sTagValue)){
				webElement = wb;
				FrameworkUtil.sElementName = sElementName;
				break;
			}
		}
	} catch (Exception e) {
		LoggerUtil.log_type_error("catch block: GetWebElement " + e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "getElementbyTagNameValue", "warn", "catch block:Could NOT access webelement" +e.getMessage());

	}
	
	return webElement;
}


/*==============================================================
Method Name		: setFocus
Description		: set the focus to given element
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:
==============================================================*/
public static void setFocus(WebElement webElement){
	
try {
	if (isElementPresent(webElement)){
	String sTagName =webElement.getTagName(); 
	if(sTagName.equalsIgnoreCase("input")){
		webElement.sendKeys("");
		} 
		else{
		   new Actions(WebDriverUtil.getDriver()).moveToElement(webElement).perform();
	
		}
	}else{
		LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element NOT present", "fail", "Element not present/visible ");
	}
	LoggerUtil.log_type_info("set focus on element " + FrameworkUtil.sElementName);
	} catch (Exception e) {
		LoggerUtil.log_type_error("Exception occured:" + e.getMessage());
	}

}



/*==============================================================
Method Name		: stopCurrentTestExecution
Description		: stop the current @test execution so that next will continue
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:
==============================================================*/
public static void stopCurrentTestExecution(){
	try {
		FrameworkUtil.sTestExecutionStatus = false;
		LoggerUtil.log_type_info("stop execution called");
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Stop Execution" , "calling Stop Execution", "fail", "Stop Execution called due to some issue with execution flow ");
		bCurrentTestStopped=true;
		FrameworkUtil.takeScreenShot();
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Page text" , "Get page text", "done", WebDriverUtil.getDriver().findElement(By.tagName("body")).getText());	
		Assert.assertTrue(FrameworkUtil.sTestExecutionStatus);
	} catch (Exception e) {
		LoggerUtil.log_type_error("Exception occured at stopCurrentTestExecution :" + e.getMessage());
	}
  }


/*==============================================================
Method Name		: getWebElementLocator
Description		: get locator of the WebElement
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	:
Revision History:
==============================================================*/
public static String getWebElementLocator(WebElement webElement) {  
	String sWebelement = null;
	try{
		sWebelement = webElement.toString() ;
		int startPos =sWebelement.indexOf("->");
		sWebelement = sWebelement.substring(startPos, sWebelement.length()-1);
	}catch (Exception e){
		String sMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		LoggerUtil.log_type_error( sMethodName + "catch block:  "  + e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , sMethodName, "warn", "catch block: Exception occured" +e.getMessage());
	}
    return sWebelement; 
    
}

/*==============================================================
Method Name		: getWebElementName
Description		: get runtime WebElement data
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	:
Revision History:
==============================================================*/

public static String getWebElementName() { 
	String sMethodname = null;
	try{
	    StackTraceElement[] stack = new Throwable().getStackTrace();  
	    StackTraceElement ste = null;
	    if (stack.length > 1)   
	        ste = stack[3]; 
	    for (int i=0; i<=stack.length;i++){
	   // System.out.println(i +" --- "+stack[i]);
	    }
	    sMethodname = ste == null ? "[Unavailable]" : ste.getMethodName();
	    //System.out.println(sMethodname);
		}catch (Exception e){
			String sMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			LoggerUtil.log_type_error( sMethodName + "catch block:  "  + e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , sMethodName, "warn", "catch block: Exception occured" +e.getMessage());
		}
	    return sMethodname;
	    
}




/*==============================================================
Method Name		: getCustomWebListItems
Description		: get all items from custom weblist with ul-li combination
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:
note: 			//this will work noly fo ul-li tags. pass ul tag as webElement and li as "text"
==============================================================*/

	public static String getCustomWebListItems(WebElement webElement){
		String sItem = null,sItemsList= "" ;
	    	try {
	    		arrCustomWebListItems = new ArrayList();
				if (WebObjectUtil.isElementPresent(webElement)){
					//WebObjectUtil.MouseHover(webElement);
					List<WebElement> webListItems = webElement.findElements(By.tagName("li"));
					for (WebElement wb: webListItems){
						sItem =wb.getText() ;
						arrCustomWebListItems.add(sItem);
						
						sItemsList = sItemsList  + sItem + "#";
						
						//sItemsList = sItemsList.concat( sItem  );
						
					}
				}else{
	    			LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element NOT present", "fail", "Element not present/visible ");
	    		}
			} catch (Exception e) {
				LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "selectCustomWebList", "warn", "catch block:Could NOT access webelement" +e.getMessage());
			}
	    	arrCustomWebListItems.trimToSize();
	    	if (sItemsList != null)
	    		sItemsList = sItemsList.substring(0, sItemsList.length()-1);
	    	return sItemsList;
	}

	

/*==============================================================
Method Name		: convertStringToDate
Description		: convert string to  Date
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	:
Revision History:
==============================================================*/
public static Date convertStringToDate(String sDateAsString, String sJavaDateFormat) {
	 Date date = null;
    try {
    	SimpleDateFormat dateFormat = new SimpleDateFormat(sJavaDateFormat);
    date = dateFormat.parse(sDateAsString);
    } catch (Exception e) {
    	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "convertStringToDate", "warn", "catch block: Exception occured" + " Could able to convert String to Date- Check your input");
         }
   
	return date;
}



////--------------------------------------------------------------------------------------------------------------------------------------
/*==============================================================
Method Name		: getWebListAllItemsAsText
Description		: get items as String (comma separated) from web list
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	:
Revision History:
==============================================================*/
public static String getWebListAllItemsAsText(WebElement webElement){
      String sItemsList = null;
      
      try {
                  if (WebObjectUtil.isElementPresent(webElement)){
                        List<WebElement> webListItems = webElement.findElements(By.tagName("option"));
                        WebListAsArrayList = (ArrayList<WebElement>) webListItems;
                        for (WebElement wb: webListItems){
                              sItemsList = sItemsList + wb.getText() + ",";
                        }
                  }
            } catch (Exception e) {
                  LoggerUtil.log_type_error("Could NOT access webelement " + FrameworkUtil.sElementName);
                  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "getWebListAllItemsAsText", "fail", "Could NOT access Element");
            }
      return sItemsList;
}


////--------------------------------------------------------------------------------------------------------------------------------------

/*==============================================================
Method Name		: getCustomWebListAllItemsAsText
Description		: get items as String (comma separated) from custom web list
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	:
Revision History:
==============================================================*/
// this will work noly fo ul-li tags. pass ul tag as webElement and li as "text"
public static String getCustomWebListAllItemsAsText(WebElement webElement){
      String sItemsList = "";
      
      try {
                  if (WebObjectUtil.isElementPresent(webElement)){
                        List<WebElement> webListItems = webElement.findElements(By.tagName("li"));
                        WebListAsArrayList = (ArrayList<WebElement>) webListItems;
                        for (WebElement wb: webListItems){
                              sItemsList = sItemsList + wb.getText() + FrameworkUtil.sDelimiter;
                        }
                  }
            } catch (Exception e) {
                  LoggerUtil.log_type_error("Could NOT access webelement " + FrameworkUtil.sElementName);
                  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "getWebListAllItemsAsText", "fail", "Could NOT access Element");
            }
      FrameworkUtil.sDelimiter=",";
      return sItemsList;
}
////--------------------------------------------------------------------------------------------------------------------------------------

/*==============================================================
Method Name		: getChildElementFromParent
Description		: 
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	:
Revision History:
==============================================================*/
public static WebElement getChildElementFromParent(String sText,WebElement wParentElement, String sChildTagName, String sSubChildTagName,int iSubChildIdex){
	WebElement wWebElement = null;
	List<WebElement> wChildElementList,wSubChildElemenList;
	int iChildCount=0,iSubChildCount=0;
	String sTextFromWebElement ;
		if (WebObjectUtil.isElementPresent(wParentElement)){
		if (sChildTagName != null && sChildTagName.length() >0){
			wChildElementList = wParentElement.findElements(By.tagName(sChildTagName));
			for (WebElement wChildElement :wChildElementList ){
				sTextFromWebElement = wChildElement.getText();
				if(sTextFromWebElement.contains(sText)){
					wWebElement = wChildElement;
					break;
					}
				iChildCount++;
			}

			if (wChildElementList.size()>0 ){
				if ( sSubChildTagName != null && sSubChildTagName.length() >0){
				wSubChildElemenList = wChildElementList.get(iChildCount).findElements(By.tagName(sSubChildTagName));
					for (WebElement wSubChildElement :wSubChildElemenList ){
						sTextFromWebElement = wSubChildElement.getText();
						if(sTextFromWebElement.contains(sText)){
							wWebElement = wSubChildElement;
							break;
						}
						iSubChildCount++;
						if(iSubChildCount==iSubChildIdex){
							wWebElement = wSubChildElemenList.get(iSubChildIdex-1);
							break;
						}
					}
				}
			}else{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "getWebElementByTag", "sSubChildTagName" , "warn", "Sub Child tag  not found, pls check the Sub child tag name:"+sSubChildTagName);	
			}
		}else{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "getWebElementByTag", "ChildTagName" , "warn", "Child tag  not found, pls check the child tag:"+sChildTagName);	
		}
	}else{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "getWebElementByTag", "Parent WebElement" , "fail", "Parent Element not found");	
	}
	return wWebElement;
}


/*==============================================================
Method Name		: GetLocatorValueFromProperty
Description		: Get Locator value from Dynamic property file and update its parameter(s).
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:
Note			: if locator has multiple parameters, pass the parameters with comma (,) seperated
==============================================================*/
public static String getLocatorValueFromProperty(String sDynamicPageFactoryName,String sParameterName, String sParameterValue){
	String sLocatorValue,arrParameterName[] = null,arrParameterValue[] = null;
	sLocatorValue = (String) FrameworkUtil.dictDynamicPagePactory.get(sDynamicPageFactoryName);
	
	if (sLocatorValue.contains(sParameterName)){
		sLocatorValue = sLocatorValue.replace(sParameterName, sParameterValue);
		return sLocatorValue;
	}else if (sParameterName.contains(",")){
		arrParameterName = sParameterName.split(",");
		arrParameterValue = sParameterValue.split(",");
		if (arrParameterName.length == arrParameterValue.length){
			for (int i=0 ; i<arrParameterName.length;i++){
				sLocatorValue = sLocatorValue.replace(arrParameterName[i], arrParameterValue[i]);
			}
		}else{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "GetLocatorValueFromProperty", "Dynamic pagefactory" , "warn", "Parameter name and value count are not matching, pls check your input(s)");
		}
	}
	else{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "GetLocatorValueFromProperty", "Dynamic pagefactory" , "warn", "Parameter not found in locator, pls check your input(s), Locator:" + sLocatorValue + "  and ParameterName:" + sParameterName);
	}
	return sLocatorValue;
}


/*==============================================================
Method Name		: GetWebElementFromDynamicLocator
Description		: Get web element from dynamic Locator value which are present on property file .
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:
Note			: if locator has multiple parameters, pass the parameters with comma (,) seperated
==============================================================*/
public static WebElement getWebElementFromDynamicLocator(String sLocatorType, String sDynamicPageFactoryName,String sParameterName, String sParameterValue){
	String sLocatorValue,arrParameterName[] = null,arrParameterValue[] = null;
	sLocatorValue = (String) FrameworkUtil.dictDynamicPagePactory.get(sDynamicPageFactoryName);
	WebElement webElement;
	if (sLocatorValue.contains(sParameterName)){
		sLocatorValue = sLocatorValue.replace(sParameterName, sParameterValue);
	}else if (sParameterName.contains(",")){
		arrParameterName = sParameterName.split(",");
		arrParameterValue = sParameterValue.split(",");
		if (arrParameterName.length == arrParameterValue.length){
			for (int i=0 ; i<arrParameterName.length;i++){
				sLocatorValue = sLocatorValue.replace(arrParameterName[i], arrParameterValue[i]);
			}
		}else{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "GetWebElementFromDynamicLocator", "Dynamic pagefactory" , "warn", "Parameter name and value count are not matching, pls check your input(s)");
		}
	}
	else{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "GetWebElementFromDynamicLocator", "Dynamic pagefactory" , "warn", "Parameter not found in locator, pls check your input(s), Locator:" + sLocatorValue + "  and ParameterName:" + sParameterName);
	}
	
	webElement = GetWebElement(sLocatorType, sLocatorValue, sDynamicPageFactoryName);
	return webElement;
}


/*==============================================================
Method Name		: getActiveULElementasWebElement
Description		: get active UL tag element as WebElement 
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:

==============================================================*/

public static WebElement getActiveElementasWebElement(String sULElementXpath){
	WebElement webElement=null;
    	try {
				List<WebElement> wULlist = WebDriverUtil.getDriver().findElements(By.xpath(sULElementXpath));
				webElementsList = wULlist;
				for (WebElement wUL: wULlist){
					if (wUL.isDisplayed()){
						webElement = wUL;
						break;
					}
				}
		} catch (Exception e) {
			LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "getActiveULElementasWebElement", "warn", "catch block:Could NOT access webelement" +e.getMessage());
			FrameworkUtil.takeScreenShot();
		}
    	return webElement;
}



/*==============================================================
Method Name		: getWebElementFromWebElementList
Description		: get active web element from web elements list returned by page factory.
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:

==============================================================*/

public static WebElement getWebElementFromWebElementList(List<WebElement> wWebElements){
	WebElement webElement=null;
    	try {
    		WebDriver driver=WebDriverUtil.getDriver();
    			webElementsList = wWebElements;
				for (WebElement wb: wWebElements){
					try {
						if (wb.isDisplayed()){
							webElement = wb;
							break;
						}
					} catch (Exception e) {

					}
				}
		} catch (Exception e) {
			LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "getWebElementFromWebElementList", "warn", "catch block:Could NOT access webelement" +e.getMessage());
			//FrameworkUtil.takeScreenShot();
		}
    	return webElement;
}



/*==============================================================
Method Name		: selectCustomWebList
Description		: Select item from custom list by text or index by passing Weblist dropdown arrow Element
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:

==============================================================*/

public static boolean selectCustomWebList(WebElement wWebListDropdownArrowAsElement,String sULElementXpath, String sListItemAsText,int iItemIndex){
	WebElement wULelement=null;
	String sItem;
	boolean flag = false;
	int iIndex=0;
    	try {
    		FrameworkUtil.sTestStepStartTime = FrameworkUtil.getCurrentTimeStamp();
    		 if (WebObjectUtil.isElementPresent(wWebListDropdownArrowAsElement)){
    			 //WebObjectUtil.clickElement(wWebListDropdownArrowAsElement);
    			 WebObjectUtil.explicitWait(3);
    			 wULelement = getActiveElementasWebElement(sULElementXpath);
    			 if (wULelement != null){
							List<WebElement> wLilist = wULelement.findElements(By.tagName("li"));
							for (WebElement wLi: wLilist){
								iIndex++;
								if(wLi.isDisplayed()){
									sItem=wLi.getText();
									if (sListItemAsText != null &&  sListItemAsText.length() >0 && sItem.equalsIgnoreCase(sListItemAsText)) {
										wLi.click();
										
										FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Custom WebList:Select Item by Text", "pass", "Item selected: "+ sItem);
										flag = true;
										break;

									}else if (iItemIndex >0 && iItemIndex==iIndex){
										wLi.click();
										FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName ,  "Custom WebList:Select Item by Index", "pass", "Item selected by Index: " + iItemIndex +", and Item selected: "+ sItem);
										flag = true;
										break; 
					    			 }
								}
							}
    			 }else{
    				 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element NOT present", "warn", "Ul-Li element NOT visible "); 
    			 }
    			
    		 }else{
    				LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
    	    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element NOT present", "fail", "Element not present/visible ");
    	    		//FrameworkUtil.takeScreenShot();
    	    		//stopCurrentTestExecution();
    		}
			if (!flag){
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Select Item from Custom WebList", "warn", "Item Not found/selected, please check your inputs");	
			}
		} catch (Exception e) {
			LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "getActiveULElementasWebElement", "warn", "catch block:Could NOT access webelement" +e.getMessage());
			FrameworkUtil.takeScreenShot();
		}
    	return flag;
}


/*==============================================================
Method Name		: getActiveElementByText
Description		: get active UL tag element as WebElement 
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:

==============================================================*/

public static WebElement getActiveElementByText(String sTagName, String sVisibleText){
	WebElement webElement=null;
	String sText=null;
    	try {
				List<WebElement> wULlist = WebDriverUtil.getDriver().findElements(By.tagName(sTagName));
				webElementsList = wULlist;
				for (WebElement wUL: wULlist){
					if (wUL.isDisplayed() ){
						sText = wUL.getText().trim();
						if (sText.equalsIgnoreCase(sVisibleText)){
						webElement = wUL;
						break;
						}
					}
				}
		} catch (Exception e) {
			LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "getActiveULElementasWebElement", "warn", "catch block:Could NOT access webelement" +e.getMessage());
			FrameworkUtil.takeScreenShot();
		}
    	return webElement;
}

/*==============================================================
Method Name		: clickByActions
Description		: click on element using selenium action
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:

==============================================================*/
public static void clickByActions(WebElement webElement){
	
	try {
		Actions builder = new Actions(WebDriverUtil.getDriver()) ;
		builder.moveToElement(webElement, webElement.getLocation().getX(), webElement.getLocation().getY()).click().build().perform();
		//builder.click(webElement);
	} catch (Exception e) {
		LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "clickByActions", "warn", "catch block:Could NOT access webelement" +e.getMessage());
		FrameworkUtil.takeScreenShot();
	}
	
}


/*==============================================================
Method Name		: scrollToElement
Description		: Scroll the page to make element visible
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:

==============================================================*/
public static void scrollToElement(WebElement webElement) {
	 String sCoOrdinates = "window.scrollTo";
	 
	 try {
		sCoOrdinates = sCoOrdinates + "(" + webElement.getLocation().getX() + ", " + webElement.getLocation().getY() + ")";
		   ((JavascriptExecutor) WebDriverUtil.getDriver())
		           .executeScript(sCoOrdinates);
	} catch (Exception e) {
		LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "scrollToElement", "warn", "catch block:Could NOT access webelement" +e.getMessage());
		FrameworkUtil.takeScreenShot();
	}
   }


/*==============================================================
Method Name		: scrollElementAtPageCenter
Description		: Scroll the page to make element visible and near to center of the page.
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:

==============================================================*/
public static void scrollElementAtPageCenter(WebElement webElement) {
	 String sCoOrdinates = "window.scrollTo";
	 
	 try {
		sCoOrdinates = sCoOrdinates + "(" + webElement.getLocation().getX() + ", " + (webElement.getLocation().getY()-250) + ")";
		   ((JavascriptExecutor) WebDriverUtil.getDriver())
		           .executeScript(sCoOrdinates);
	} catch (Exception e) {
		LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "scrollElementAtPageCenter", "warn", "catch block:Could NOT access webelement" +e.getMessage());
		FrameworkUtil.takeScreenShot();
	}
   }

/*==============================================================
Method Name		: clickByJS
Description		: Click element by JS
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:

==============================================================*/
public static boolean clickByJS(WebElement element) {
	boolean bFlag=false;
	WebDriver driver = WebDriverUtil.getDriver();
	try {
		
		if (element.isEnabled() && element.isDisplayed()) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Clicking on element by JS", "Done", "");
			bFlag=true;
		} else {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Clicking on element by JS", "warn", "issue with finding an element");
		}
	} catch (StaleElementReferenceException e) {
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Clicking on element by JS", "warn", "catch block: Element is not attached to the page document " +e.getMessage());  
	} catch (NoSuchElementException e) {
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Clicking on element by JS", "warn", "catch block: Element was not found in DOM " +e.getMessage());
	} catch (Exception e) {
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Clicking on element by JS", "warn", "catch block:Unable to click on element " +e.getMessage());
	}
	return bFlag;
}


/*==============================================================
Method Name		: mouseHoverByJS
Description		: mouse hover on element by JS
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:

==============================================================*/
public static void mouseHoverByJS(WebElement webElement) {
	try {
		WebDriver driver = WebDriverUtil.getDriver();
		if (isElementPresent(webElement)) {
			
			String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
			((JavascriptExecutor) driver).executeScript(mouseOverScript,webElement);
			webElement.sendKeys(Keys.ENTER);

		} else {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "mouse hover", "warn", "issue with finding an element");

		}
	
	} catch (Exception e) {
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "mouse hover", "warn", "catch block:Unable to mouse hover on element " +e.getMessage());
	}
}

/*==============================================================
Method Name		: clickElement
Description		: Clicking the webelement
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:
==============================================================*/
public static void clickElement(WebElement webElement,boolean bStopExexcutionOnFailure){
	
	try{
		FrameworkUtil.sTestStepStartTime = FrameworkUtil.getCurrentTimeStamp();
	if (isElementPresent(webElement)){
		setOperationName("Click");
		webElement.click();
/*		if (WebDriverUtil.browser.equalsIgnoreCase("IE")){
			WebObjectUtil.scrollToElement(webElement);
			webElement.sendKeys(Keys.ENTER);
		}else{
		webElement.click();
		}*/
		LoggerUtil.log_type_info("Clicked on " + FrameworkUtil.sElementName);
		WebDriverUtil.webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Click", "Done", "");
		WebObjectUtil.waitForPageLoad();
	}else{
		LoggerUtil.log_type_error("Could NOT Click on webelement,either element not present/visible " + FrameworkUtil.sElementName);
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Click", "fail", "Could NOT click on Element,either element not present/visible ");
		if (bStopExexcutionOnFailure) stopCurrentTestExecution();
		
	}
	}catch(Exception e){
		try {
			//WebObjectUtil.scrollToElement(webElement);
			WebObjectUtil.scrollElementAtPageCenter(webElement);
			webElement.click();
			LoggerUtil.log_type_info("Clicked on " + FrameworkUtil.sElementName);
			WebDriverUtil.webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Click", "Done", "");
		} catch (Exception e1) {
			
			try {
				if (!clickByJS(webElement))
					if (bStopExexcutionOnFailure)  stopCurrentTestExecution();
			} catch (Exception e2) {
				LoggerUtil.log_type_error("catch block:Could NOT Click on webelement,either element not present/visible  " + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Click", "warn", "catch block:Could NOT click on Element,either element not present/visible " + e1.getMessage());
				//FrameworkUtil.bTestCaseResultFlag = false;
				
				if (bStopExexcutionOnFailure)  stopCurrentTestExecution();
			}
			
			
		}
		
	}
}

/*==============================================================
Method Name		: getElementByText
Description		: get element by passing text
Author 			: Sukur Babu
Creation Date 	: 
Pre-Requisites	: 
Revision History:
==============================================================*/
public static WebElement getElementByText(WebElement wParentElement, String sText){
	List<WebElement> webElements = null;
	WebElement webElement = null;
	String sGetText;
	WebDriver driver = WebDriverUtil.getDriver();
	try{
		FrameworkUtil.sTestStepStartTime = FrameworkUtil.getCurrentTimeStamp();
		sGetText = wParentElement.getText().trim();
		if(sGetText.contains(sText)){
		webElements= wParentElement.findElements(By.partialLinkText(sText));
		if (!webElements.isEmpty())
		{
		for (WebElement wb: webElements){
			if(wb.isDisplayed()){
				wb= webElement;
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "get element by text", "done", "get element by text:" + sText);
			}
		}
		}else{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "get element by text", "warn", "could not get element by text:" + sText);
		}
	}else{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "get element by text", "warn", "Text not present under the passed element:" + sText);
	}
	}catch (Exception e){
		
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "get element by text", "warn", "Catch block:ould not get element by text:" + sText + e.getMessage());
	}
	return webElement;
}









public static boolean waitForJSandJQueryToLoad() {
	WebDriver driver = WebDriverUtil.getDriver();
	WebDriverWait wait = new WebDriverWait(driver, 30);

    // wait for jQuery to load
    ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
      @Override
      public Boolean apply(WebDriver driver) {
        try {
          return ((Long)((JavascriptExecutor)driver).executeScript("return jQuery.active") == 0);
        }
        catch (Exception e) {
          // no jQuery present
          return true;
        }
      }
    };

    // wait for Javascript to load
    ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
      @Override
      public Boolean apply(WebDriver driver) {
        return ((JavascriptExecutor)driver).executeScript("return document.readyState")
        .toString().equals("complete");
      }
    };

  return wait.until(jQueryLoad) && wait.until(jsLoad);
}





}



