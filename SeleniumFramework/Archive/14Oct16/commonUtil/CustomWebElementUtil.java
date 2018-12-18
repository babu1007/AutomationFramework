package com.whs.navigator.commonUtil;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CustomWebElementUtil {

	public static List<WebElement> rowsWebElementList ;
	public static List<WebElement> colsWebElementList ;
	public static int iRowCount=0;
	private static String sChildElementTagName;
	
	public static List<WebElement> loadCustomElement(WebElement wParentElement,String sChildTagName){
		
    	try {
    		sChildElementTagName = sChildTagName;
			if (WebObjectUtil.isElementPresent(wParentElement)){
				rowsWebElementList = wParentElement.findElements(By.tagName(sChildTagName));
				iRowCount= rowsWebElementList.size();
			}
		} catch (Exception e) {
			String sMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			LoggerUtil.log_type_error( sMethodName + "catch block:  "  + e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), sMethodName , "get Custom object as list", "warn", "catch block: Exception occured" +e.getMessage());
		
		}
    	return rowsWebElementList;
}	
	

	
	
	public static int getColumnCount(int iRowNo){
		WebElement rowIndex,tableIndex = null;
		int iColCount=0;
		try {
		if (sChildElementTagName.equalsIgnoreCase("table")){
		tableIndex = rowsWebElementList.get(iRowNo-1);
		rowIndex = tableIndex.findElements(By.tagName("tr")).get(0);
		colsWebElementList = rowIndex.findElements(By.tagName("td"));
		if (iRowNo == 1 && colsWebElementList.size() <= 0 )
		{
			colsWebElementList = rowIndex.findElements(By.tagName("th"));
		}
			iColCount= colsWebElementList.size();
			
		}	
		} catch (Exception e) {
			String sMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			LoggerUtil.log_type_error( sMethodName + "catch block:  "  + e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), sMethodName , "get column count from list", "warn", "catch block: Exception occured" +e.getMessage());
		
		}
		return iColCount;
	}
	
	public static WebElement getRowAsWebElement(int iRowNo){
		WebElement webElement;
		if (iRowNo > 0)
			webElement = rowsWebElementList.get(iRowNo-1);
		else
			webElement = rowsWebElementList.get(iRowNo);
    	return webElement;
	}
	
	
	public static String getCellData(int iRowNo,int iColNo){
		String sCellData = "";

    		try {
    			getColumnCount(iRowNo);
				 if (colsWebElementList.size() >= iColNo && iColNo > 0 ){
					 sCellData= colsWebElementList.get(iColNo-1).getText();
				 }else {
					 sCellData= colsWebElementList.get(0).getText();	 
				 }
			} catch (Exception e) {
				String sMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
				LoggerUtil.log_type_error( sMethodName + "catch block:  "  + e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), sMethodName , "get cell data", "warn", "catch block: Exception occured" +e.getMessage());
			}
     		return sCellData;
	}
	
	
	public static int getRowByCellText( String sText,  int iStepIncrementor){
        int iRowIndex = 0;
        int iIndex =0;
       try {
			for (int i=0; i<=rowsWebElementList.size(); i+=iStepIncrementor){
			      iIndex++;
			      String sRowText = rowsWebElementList.get(i).getText();
			     // System.out.println("Row no :" + i + " row text: " + sRowText);
			      if (sRowText.contains(sText) ){
			            iRowIndex = iIndex;
			            break;
			      }
			}
		} catch (Exception e) {
			String sMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			LoggerUtil.log_type_error( sMethodName + "catch block:  "  + e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), sMethodName , "get row number by passing text", "warn", "catch block: Exception occured" +e.getMessage());
		}
        
        
       return iRowIndex;
  }

	
	
	public static WebElement getCellAsWebElement(int iRowNo,int iColNo){
		WebElement wCellElement = null;

    		try {
    			getColumnCount(iRowNo);
				 if (colsWebElementList.size() >= iColNo && iColNo > 0 ){
					 wCellElement= colsWebElementList.get(iColNo-1);
				 }else {
					 wCellElement= colsWebElementList.get(0);	 
				 }
			} catch (Exception e) {
				String sMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
				LoggerUtil.log_type_error( sMethodName + "catch block:  "  + e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), sMethodName , "get cell data", "warn", "catch block: Exception occured" +e.getMessage());
			}
     		return wCellElement;
	}
	
	
	
	public static boolean selectCustomWebList(WebElement webElementwithULtag,String sVisibleText, Integer iIndex){
		boolean bStatus = false;
		int iRowindex=0;
		WebElement webElement ;
		loadCustomElement(webElementwithULtag, "li");
		if ( sVisibleText != null && sVisibleText.length() > 0){
			iRowindex = CustomWebElementUtil.getRowByCellText(sVisibleText,  1);
			webElement = getRowAsWebElement(iRowindex);
			if ( webElement != null){
				webElement.click();
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "selectCustomWebList" , "Custom select item by visible text", "pass", "Item selected:"+sVisibleText);
				bStatus = true;
			}else{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "selectCustomWebList" , "Custom select item by visible text", "warn", "Item NOT found, pls check your input");
			}
		}else if (iIndex != null && iIndex > 0){
			webElement = getRowAsWebElement(iIndex-1);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "selectCustomWebList" , "Custom select item by Index", "pass", "Item selected:"+webElement.getText());
			webElement.click();
			bStatus = true;
		}else{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "selectCustomWebList" , "Custom web list", "warn", "Issue with accessing Custom weblist, pls check your input or pagefactory");
		}
		return bStatus;
	}
	
	
	
}
