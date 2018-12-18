package com.whs.navigator.commonUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebTableUtil {
	
	private static List<WebElement> rowsWebElementList ;
	private static List<WebElement> colsWebElementList ;
	
	public static int getRowCount(WebElement webTable){
		int iRowCount=0;
		
	    	try {
				if (WebObjectUtil.isElementPresent(webTable)){
					rowsWebElementList = webTable.findElements(By.tagName("tr"));
					iRowCount= rowsWebElementList.size();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return iRowCount;
	}
	
	
	public static int getColumnCount(WebElement webTable,int iRowNo){
		WebElement rowIndex = null;
		int iColCount=0;
		try {
		if (WebObjectUtil.isElementPresent(webTable)){
		int iRowCount = getRowCount(webTable);

		rowIndex = rowsWebElementList.get(iRowNo-1);
		colsWebElementList = rowIndex.findElements(By.tagName("td"));
		
		if (iRowNo == 1 && colsWebElementList.size() <= 0 )
		{
			colsWebElementList = rowIndex.findElements(By.tagName("th"));
		}
		
/*				if (iRowNo != 1  ){
					rowIndex = rowsWebElementList.get(iRowNo-1);
					colsWebElementList = rowIndex.findElements(By.tagName("td"));
				}
				else{
					rowIndex = rowsWebElementList.get(iRowNo-1);
					colsWebElementList = rowIndex.findElements(By.tagName("th"));
				}*/
		
				iColCount= colsWebElementList.size();
			
		}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return iColCount;
	}
	
	

	public static String getCellData(WebElement webTable,int iRowNo,int iColNo){
		String sCellData = "";

    		try {
				int iRowCount = getRowCount(webTable);  
				int iColCount = getColumnCount(webTable,iRowNo);
/*    		 System.out.println("row count: " + iRowCount);
				 System.out.println("col count: " + iColCount );
				 System.out.println("get text: " + colsWebElementList.get(iColNo-1).getText() );*/
				
				 if (colsWebElementList.size() >= iColNo && iColNo > 0 ){
					 sCellData= colsWebElementList.get(iColNo-1).getText();
					 
				 }else {
					 sCellData= colsWebElementList.get(0).getText();	 
				 }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		 
    		
    		return sCellData;
	}
	
	
	public static WebElement getCellAsWebElement(WebElement webTable,int iRowNo,int iColNo){
		int iRowCount = getRowCount(webTable);  
		int iColCount = getColumnCount(webTable,iRowNo);
		return colsWebElementList.get(iColNo-1);
	}
	
	
	public static WebElement getRowAsWebElement(WebElement webTable,int iRowNo){
   		int iRowCount = getRowCount(webTable);  
   		if (iRowNo == 0){
   			return rowsWebElementList.get(iRowNo);
        }else{
        	return rowsWebElementList.get(iRowNo-1);
        }
	}
	
	
	
	public static int getRowByCellText(WebElement webTable, String sText, int iStartRow, int iStepIncrementor){
        int iRowIndex = 0,iRowCount;
        int iIndex =0;
        List<WebElement> rowsList = webTable.findElements(By.tagName("tr"));
        if (iStartRow == 0){
        	iRowCount = rowsList.size();
        }else{
        	iRowCount = rowsList.size()+1;
        }
        for (int i=iStartRow; i<iRowCount; i+=iStepIncrementor){
              iIndex++;
              String sRowText = rowsList.get(i).getText();
              //System.out.println("Row no :" + i + "row text: " + sRowText);
              if (sRowText.contains(sText) ){
                    iRowIndex = iIndex;
                    break;
              }
        }
        return iRowIndex;
  }

	
	
	public static boolean verifyTextOnWebTable(WebElement webTable, String sText){
		boolean bStatus = false;
		String sTableContent = null;
		sTableContent=webTable.getText();
			if (sTableContent.contains(sText) ){
				bStatus = true;
			}
    		return bStatus;
	}
	
	
	
	public static void expandTableRowByRowNum(int iRowNum,WebElement RowAswebElement){
	      try {
	            if (iRowNum > 0 && RowAswebElement != null  ){
	                  RowAswebElement.click();
	                  //System.out.println("expanding VM row success");
	                  LoggerUtil.log_type_info("expanding a row success");
	            }else{
	                  //System.out.println("expanding VM row failure");
	                  LoggerUtil.log_type_error("expanding a row failure");
	            }
	      } catch (Exception e) {
	            LoggerUtil.log_type_error("Exception occured:" + e.getMessage());
	      }
	}
	
	
	public static void printEachCellText(WebElement webTable){
		int iRowCount = getRowCount(webTable);  
		int iColCount ;
		for (int r=1; r<=iRowCount; r++){
			iColCount = getColumnCount(webTable,r);
			for (int c=1; c<=iColCount; c++){
				System.out.println("Row no :" + r + ", column no:" + c + ", cell text:" + colsWebElementList.get(c-1).getText());
			}
		}
	}


	
}
