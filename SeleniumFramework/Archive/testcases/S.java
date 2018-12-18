package com.whs.navigator.testcases;

import java.sql.Time;
import java.util.List;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
 
import java.net.URL;
 
import java.util.ArrayList;
 
import java.util.Date;
import java.util.HashSet;
 
import java.util.Iterator;
 
import java.util.NoSuchElementException;
 
import java.util.Set;
 
import java.util.concurrent.TimeUnit;
 
























import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
 
import org.openqa.selenium.JavascriptExecutor;
 
import org.openqa.selenium.Keys;
 
import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.WebDriver.Navigation;
 
import org.openqa.selenium.WebDriver.Options;
 
import org.openqa.selenium.WebElement;
 
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
import org.openqa.selenium.firefox.FirefoxProfile;
 
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.*;

import com.google.common.base.Function;
 
import com.google.common.base.Predicate;
 
//import org.openqa.selenium.*;
 
//import org.openqa.selenium.firefox.*;
 
public class S {
 
  public static List findAllLinks(WebDriver driver)
 
  {
	  List<WebElement>  elementList = new ArrayList();
	  elementList = driver.findElements(By.tagName("a"));
	  elementList.addAll(driver.findElements(By.tagName("img")));
	  List finalList = new ArrayList(); ;
	  for (WebElement element : elementList)
	  {
		 if(element.getAttribute("href") != null)
		  {
			  finalList.add(element);
		  }		  
	  }	
	  return finalList;
  }
 
	public static String isLinkBroken(URL url) throws Exception
 
	{	//url = new URL("http://yahoo.com");
		String response = "";
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		try
		{
		    connection.connect();
		    response = connection.getResponseMessage();	        
		    connection.disconnect();
		    if(response.equalsIgnoreCase("OK"))
		    	return "NO";
		    else
		    	return "YES";
		}
		catch(Exception exp)
		{
			return exp.getMessage();
		}  				
	}
	public static XSSFWorkbook getWB(String sFile)
	{
		FileInputStream file;
		try {
			file = new FileInputStream(new File(sFile)); 
	        //Create Workbook instance holding reference to .xlsx file
	        XSSFWorkbook workbook = new XSSFWorkbook(file);
	       
	        
	        return workbook;
			}
		catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 return null;
		}
		
	}

	public static XSSFSheet getExcelSheet(String sFile,String sSheetName)
	{
		FileInputStream file;
		try {
			file = new FileInputStream(new File(sFile)); 
	        //Create Workbook instance holding reference to .xlsx file
	        XSSFWorkbook workbook = new XSSFWorkbook(file);
	        //workbook.
	        //Get first/desired sheet from the workbook
	        XSSFSheet sheet = workbook.getSheet(sSheetName);
	        
	        return sheet;
			}
		catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 return null;
		}
		
	}
	public static void writeExcelData(XSSFSheet xSheet,int iRow,int iCol,String sData)
	{
		Row rowinExcel ;
		Cell cellInExcel;
		try {
				if(xSheet.getLastRowNum()==0)
				{
					rowinExcel = xSheet.createRow(iRow);
					cellInExcel=rowinExcel.createCell(iCol);
				}
				else
				{
					rowinExcel = xSheet.createRow(iRow);
					rowinExcel =xSheet.getRow(iRow);
					cellInExcel=rowinExcel.createCell(iCol);
					cellInExcel=rowinExcel.getCell(iCol);
				}
				//rowinExcel.setRowNum(iRow);
								
				//Cell cellInExcel=rowinExcel.getCell(iCol);
				//cellInExcel.setAsActiveCell();
	        	cellInExcel.setCellValue(sData);
	        	//System.out.println(cellInExcel.CELL_TYPE_STRING);
					}
		catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 
		}
		
	}
	/*public static void writeExcelData(XSSFSheet xSheet,int iRow,int iCol,String sData)
	{
		try {
				//Row rowinExcel = xSheet.createRow(iRow);
				Row rowinExcel =xSheet.getRow(iRow);
				rowinExcel.setRowNum(iRow);
				
				//Cell cellInExcel=rowinExcel.createCell(iCol);
				Cell cellInExcel=rowinExcel.getCell(iCol);
	        	cellInExcel.setCellValue(sData);
	        	
					}
		catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 
		}
		
	}*/
public static void fillExcelCellCOlor(XSSFWorkbook XWrkBook,XSSFSheet xSheet,int iRow,int iCol,String sColor)
{
		Row rowinExcel =xSheet.getRow(iRow);
		rowinExcel.setRowNum(iRow);
		Cell cellInExcel=rowinExcel.getCell(iCol);
		XSSFCellStyle my_style = XWrkBook.createCellStyle();

		my_style.setFillPattern(XSSFCellStyle.FINE_DOTS );
		//my_style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
		my_style.setFillBackgroundColor(IndexedColors.RED.getIndex());
		cellInExcel.setCellStyle(my_style);
}
public static void fillExcelCellYellowCOlor(XSSFWorkbook XWrkBook,XSSFSheet xSheet,int iRow,int iCol,String sColor)
{
		Row rowinExcel =xSheet.getRow(iRow);
		rowinExcel.setRowNum(iRow);
		Cell cellInExcel=rowinExcel.getCell(iCol);
		XSSFCellStyle my_style = XWrkBook.createCellStyle();

		my_style.setFillPattern(XSSFCellStyle.FINE_DOTS );
		//my_style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
		my_style.setFillBackgroundColor(IndexedColors.YELLOW.getIndex());
		cellInExcel.setCellStyle(my_style);
}
public static void fillExcelCellGreenCOlor(XSSFWorkbook XWrkBook,XSSFSheet xSheet,int iRow,int iCol,String sColor)
{
		Row rowinExcel =xSheet.getRow(iRow);
		rowinExcel.setRowNum(iRow);
		Cell cellInExcel=rowinExcel.getCell(iCol);
		XSSFCellStyle my_style = XWrkBook.createCellStyle();

		my_style.setFillPattern(XSSFCellStyle.FINE_DOTS );
		//my_style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
		my_style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
		cellInExcel.setCellStyle(my_style);
}
	public static void saveExcel(XSSFWorkbook xWBook,String sFile)
	{
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(sFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			try {
				xWBook.write(fileOut);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
				
		try {
			fileOut.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fileOut.close();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
		
		
	public static void SetExcelCellData(String sFile,XSSFSheet xSheet,int iRowNum,int iColumnNum,boolean bStatus)
	{
		try{
			
		XSSFWorkbook workbook = new XSSFWorkbook(sFile);
		Row xssfRow=xSheet.createRow(iRowNum);
		xssfRow.setRowNum(iRowNum);
//		XSSFCell xssfcell=xssfRow.createCell(iColumnNum);
		Cell xssfcell=xssfRow.createCell(iColumnNum);
		xssfcell.setCellValue("PASS");
		FileOutputStream outputStream = new FileOutputStream(sFile) ;
		workbook.write(outputStream);
	
		outputStream.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		
	}
	public static int getColumnNumber(XSSFSheet xSheet,String sColumnName)
	{
		boolean bColFoundflag=false;
		XSSFCell cell = null;
		int iColNum = -1,iColCnt;
		Iterator<Row> rowIterator = xSheet.iterator();
	Row row;
//		//Row row = rowIterator.next();
//		int iColCnt=row.getLastCellNum();
		while (rowIterator.hasNext()) 
        {
			//xSheet.se
            row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            iColCnt=row.getLastCellNum();
            for(int c=0;c<iColCnt;c++)
            {
            	if(xSheet.getRow(0).getCell(c).toString().equalsIgnoreCase(sColumnName))
            	{
            		
            		iColNum=c;
            		bColFoundflag=true;
            		break;
            	}
            	else
            	{
            	continue;	
            	}
            }
            if(bColFoundflag)
            	break;
            
        }
				
		return iColNum;
	}
	
	public static String getExcelCellData(XSSFSheet xSheet,int iRowNum,int iColumnNum)
	{
		String sData = null;
		sData=xSheet.getRow(iRowNum).getCell(iColumnNum).toString();
		
		return sData;
		
	}
	
	public static String fFindBrokenLinks(XSSFWorkbook xWrkBook,XSSFSheet xSheet,XSSFWorkbook xInputWrkBook,XSSFSheet xInputSheet,List<WebElement> allImages,String sUrl)
	{
		int iRow;
		String sHref,sPgTitle,fFunSts = null;
		String[] sUrlArray;
	//	List<WebElement>  allImages = null;
		int iOutRowCnt;
		iOutRowCnt=xSheet.getLastRowNum();
		if(iOutRowCnt>0)
			iRow=iOutRowCnt+1;
		else
			iRow=1;
		writeExcelData(xSheet,iRow,0,sUrl);
		fillExcelCellYellowCOlor(xWrkBook,xSheet,iRow,0,"YELLOW");
		iRow=iRow+1;
	    for( WebElement element : allImages){
	    	 
	    	//for(int iRow=1;iRow<allImages.size();iRow++){
	    		
//		    	sUrl=getExcelCellData(xSheet,iRow,iUrlCol);
//		    	sLinkName=getExcelCellData(xSheet,iRow,iLinkNameCol);
//		    	sPgTitle=getExcelCellData(xSheet,iRow,iPageTitleCol);
	    		sHref=element.getAttribute("href");
	    		sUrlArray=sHref.split("/");
	    		sPgTitle=sUrlArray[(sUrlArray.length)-1];
		    	try
		    	{
//			    	lStrtTime=d.getTime();
//			    	System.out.println("Iteration Start Time  " + lStrtTime);
		    		String bLinkBrkSts=isLinkBroken(new URL(element.getAttribute("href")));
		    		writeExcelData(xSheet,iRow,0,sHref+" Link Is Broken???		Respoce Is--->   "+bLinkBrkSts);
		    		if(bLinkBrkSts.equalsIgnoreCase("NO"))
		    			fillExcelCellGreenCOlor(xWrkBook,xSheet,iRow,0,"GREEN");
		    		else
		    			fillExcelCellCOlor(xWrkBook,xSheet,iRow,0,"RED");
		    		//saveExcel(xWrkBook,sFileNamePath);
//			    	if(element.getText()!=null)
//			    	writeExcelData(xSheet,iRow,iLinkNameCol,element.getText());
//			    	//saveExcel(xWrkBook,sFileNamePath);
//			    	writeExcelData(xSheet,iRow,iLinkStsCol,isLinkBroken(new URL(element.getAttribute("href"))));
//			    	//saveExcel(xWrkBook,sFileNamePath);
//			    	writeExcelData(xSheet,iRow,iPageTitleCol,sPgTitle);
//			    	//saveExcel(xWrkBook,sFileNamePath);
//			    		
		    		System.out.println("i Value   "+iRow);
		    		if(iRow==99)
		    			System.out.println("Sukur is watching for DEFECT: "+iRow);
//				    System.out.println("Element Name  "+element.getText() +"and URL: " + element.getAttribute("href")+ " returned " + isLinkBroken(new URL(element.getAttribute("href"))));
		    		//System.out.println("URL: " + element.getAttribute("outerhtml")+ " returned " + isLinkBroken(new URL(element.getAttribute("href"))));
//			    	lEndTime=d.getTime();
//			    	System.out.println("Iteration End Time  " + lEndTime);
//			    	saveExcel(xWrkBook,sFileNamePath);
		    		iRow++;
//		    		writeExcelData(xSheet,iRow,1,"Executed and Passed");
//					fillExcelCellGreenCOlor(xWrkBook,xSheet,iRow,1,"GREEN");
		    		fFunSts="OK";
		    	}
		    	
		    	catch(Exception exp)
		    	{
		    		System.out.println("Element Name  "+element.getText() +"At " + element.getAttribute("innerHTML") + " Exception occured -&gt; " + exp.getMessage());
		    		writeExcelData(xSheet,iRow,1,"Executed and Failed");
					fillExcelCellCOlor(xWrkBook,xSheet,iRow,1,"RED");
		    		fFunSts="NOT OK";
		    	}
	    //}
		    	
//			    	if(iRow>=3)
//			    		break;
	    }
	    
	    if(fFunSts.equalsIgnoreCase("OK"))
	    {
	    	
	    	
	    	return "OK";
	    }
	    else
	    {
	    	
	    	return "NOT OK";
	    	
	    }
	}
	public static void main(String[] args) throws Exception {
		
		
		String sFileNamePath="C:\\Users\\Sbabu\\Desktop\\S.xlsx";
		String sSheetName="Sheet1";
		
		String sInputFile="C:\\Users\\Sbabu\\Desktop\\WissenTestInput.xlsx",sInputSheet="WissenTest";
		
		String sUrl,sLinkName,sPgTitle,sHref,sExeFlag,fFuncSts,sPageName,sActTitle;
		boolean bTitleSts=false;
		String[] sUrlArray;
		int iUrlCol,iLinkNameCol,iPageTitleCol,iLinkStsCol,iRow,iExeFlagCol,iPageNameCol,iExeStsCol;
		XSSFSheet xSheet,xInputSheet;
		Date d=new Date();
		long lStrtTime,lEndTime;
		
		
		
		XSSFWorkbook xWrkBook=getWB(sFileNamePath);
		xSheet=xWrkBook.getSheet(sSheetName);
	
		
		XSSFWorkbook xInputWrkBook=getWB(sInputFile);
		xInputSheet=xInputWrkBook.getSheet(sInputSheet);
		//FirefoxDriver ff = new FirefoxDriver();
 		//System.setProperty("webdriver.ie.driver","D:\\Selenium-Automation\\Libraries\\IEDriverServer.exe");
		//InternetExplorerDriver ff=new InternetExplorerDriver();
		
		System.setProperty("webdriver.chrome.driver","D:\\Selenium-Automation\\Libraries\\CommonLibs\\chromedriver.exe");
		ChromeDriver ff=new ChromeDriver();
		
		iExeFlagCol=getColumnNumber(xInputSheet,"Check?");
		iUrlCol=getColumnNumber(xInputSheet,"URL");
		iPageNameCol=getColumnNumber(xInputSheet,"Page Name");
		iExeStsCol=getColumnNumber(xInputSheet,"Status");
		int iRowCnt=xInputSheet.getLastRowNum();
		for(int row=1;row<=iRowCnt;row++)
        {
        	sExeFlag=getExcelCellData(xInputSheet,row,iExeFlagCol);
        	if(sExeFlag.equalsIgnoreCase("y"))
        	{
        		sUrl=getExcelCellData(xInputSheet,row,iUrlCol);
        		sPageName=getExcelCellData(xInputSheet,row,iPageNameCol);
				//ff.get("http://www.wisseninfotech.com/");	
				//ff.get("http://www.wissen.com/wissen/banking-and-financial-services/");
				ff.get(sUrl);
				sActTitle=ff.getTitle();
				if(sActTitle.equalsIgnoreCase(sPageName))
					bTitleSts=true;
				else
					bTitleSts=false;
				
				System.out.println("Page Title is :"+ff.getTitle());
				List<WebElement>  allImages = findAllLinks(ff);    
			    System.out.println("Total number of elements found " + allImages.size());
			    
			    fFuncSts=fFindBrokenLinks(xWrkBook,xSheet,xInputWrkBook,xInputSheet,allImages,sUrl);
			    
			    if (fFuncSts.equalsIgnoreCase("OK")) {
			    	if(bTitleSts){
					writeExcelData(xInputSheet, row, iExeStsCol, "Page name of the given link is matching with Expected. And all links in the page are working(Not broken)");
					fillExcelCellGreenCOlor(xInputWrkBook, xInputSheet, row, iExeStsCol, "GREEN");
			    	}
			    	else
			    	{
			    		writeExcelData(xInputSheet, row, iExeStsCol, "Page name of the given link is not matching with Expected. All links in the page are working(Not broken)");
						fillExcelCellCOlor(xInputWrkBook, xInputSheet, row, 1, "RED");
			    	}
				}
			    else
			    {
			    	if(bTitleSts){
						writeExcelData(xInputSheet, row, iExeStsCol, "Page name of the given link is matching with Expected. Any of the link is broken. Please refer detailed report to know which link is broken");
						fillExcelCellGreenCOlor(xInputWrkBook, xInputSheet, row, iExeStsCol, "GREEN");
				    	}
				    	else
				    	{
				    		writeExcelData(xInputSheet, row, iExeStsCol, "Page name of the given link is not matching with Expected. Any of the link is broken. Please refer detailed report to know which link is broken");
							fillExcelCellCOlor(xInputWrkBook, xInputSheet, row, iExeStsCol, "RED");
				    	}
			    }
				saveExcel(xWrkBook,sFileNamePath);
				saveExcel(xInputWrkBook,sInputFile);
			    lEndTime=d.getTime();
				System.out.println("Script End Time  " + lEndTime);
        	}
        }
	}
 	}