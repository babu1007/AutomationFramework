package com.whs.navigator.testcases.dev.old;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.crypto.dsig.keyinfo.PGPData;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;










import com.whs.navigator.commonUtil.CustomWebElementUtil;
import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.commonUtil.WebTableUtil;
import com.whs.navigator.pagefactory.CommonPageFactory;
import com.whs.navigator.pagefactory.EVDC_FirewallPageFactory;
//import com.whs.navigator.pagefactory.EVDC_FirewallPageFactory;
import com.whs.navigator.pagefactory.FirewallPageFactory;
import com.whs.navigator.pagefactory.SmokeTestPageFactory;
//import com.whs.navigator.pagefactory.AddFirewallPageFactory;
import com.whs.navigator.pagefactory.UserPermissionPageFactory;
import com.whs.navigator.commonUtil.CustomWebElementUtil;


public class SukurTestCase {

	static CommonPageFactory CommonPF = new CommonPageFactory();
	public static SmokeTestPageFactory smokeTest = new SmokeTestPageFactory();
	  
	@Test(priority=1)
	public void ABC(){
		String sExcelPageFactoryFile,sSheetName;
		int iSheetCount;
		
		XSSFWorkbook xPFWB;
		XSSFSheet xSheet;
		sExcelPageFactoryFile="D://PageFactory.xlsx";
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, smokeTest);
		
		try {
			FrameworkUtil.sTestCaseName = "ABC";
			FrameworkUtil.sManualTestCaseName="ABCDEFGH";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.USERID");
			String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.PASSWORD");
			
			xPFWB =getWB(sExcelPageFactoryFile);
			iSheetCount=xPFWB.getNumberOfSheets();
			for(int i=0;i<iSheetCount;i++)
			{
				sSheetName=xPFWB.getSheetName(i);
				xSheet=xPFWB.getSheet(sSheetName);
				switch(sSheetName)
				{
				case "Login":
						fChkAndUpdateLoginPF(sExcelPageFactoryFile,xPFWB,xSheet);
						break;
				}
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		}
		
		
		
	}
	
	public static void fChkAndUpdateLoginPF(String sExcelPageFactoryFile,XSSFWorkbook xPFWB, XSSFSheet xSheet)
	{
		
		WebElement wElement;
		int iRc;
		int iElmClmNum,iElmIdClmNum,iElmXpathClmNum,iElmIdStsClmNum,iElmXpathStsClmNum,iElmCssPathClmNum,iElmCssPathStsClmNum;
		String sElmName,sElmId,sElmXpath,sElmCss;
		iRc=xSheet.getLastRowNum();
		
		String sPkg="package com.whs.navigator.pagefactory;";
		String sLibsImp1="import org.openqa.selenium.WebElement;";
		String sLibsImp2="import org.openqa.selenium.support.FindBy;";
		String sLibsImp3="import org.openqa.selenium.support.How;";
		String sFrmUtilImp="import com.whs.navigator.commonUtil.FrameworkUtil;";
		String sClassStart="public class "+xSheet.getSheetName()+"{";
		String sFindByID="@FindBy(how=How.ID, using ="+"\"" ;
		//String sQ=;
		String sFindBy1="@FindBy(how=How.XATH, using ="+"\"";
		String sFindByProp;
		String sFindBy2="\""+")";
		String sFindByCss="@FindBy(how=How.css, using ="+"\"" ;
		String sEleName;
		String sFindBy;
		
		try{
			FileWriter fw = new FileWriter("D://out.txt",true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(sPkg);
			bw.write(System.getProperty( "line.separator" ));
			bw.write(sLibsImp1);
			bw.write(System.getProperty( "line.separator" ));
			bw.write(sLibsImp2);
			bw.write(System.getProperty( "line.separator" ));
			bw.write(sLibsImp3);
			bw.write(System.getProperty( "line.separator" ));
			
			
			bw.write(sFrmUtilImp);
			bw.write(System.getProperty( "line.separator" ));
			
			bw.write(sClassStart);
			bw.write(System.getProperty( "line.separator" ));
			
			
			WebDriver driver =WebDriverUtil.getDriver();
			String sURL = (String)FrameworkUtil.dictPropertyData.get("NAV.QA.URL");
			WebDriverUtil.getDriver().get(sURL);
			
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebDriverUtil.getSeleniumDriver(sURL);
			
			for(int iPFrow=1;iPFrow<=iRc;iPFrow++)
			{
				iElmClmNum=getColumnNumber(xSheet,"Element");
				iElmIdClmNum=getColumnNumber(xSheet,"id");
				iElmIdStsClmNum=getColumnNumber(xSheet,"ID Status");
				iElmCssPathClmNum=getColumnNumber(xSheet,"CSS");
				iElmCssPathStsClmNum=getColumnNumber(xSheet,"CSS Status");
				iElmXpathClmNum=getColumnNumber(xSheet,"Xpath");
				iElmXpathStsClmNum=getColumnNumber(xSheet,"Xpath Status");
				
				sElmName=getExcelCellData(xSheet,iPFrow,iElmClmNum);
				sElmId=getExcelCellData(xSheet,iPFrow,iElmIdClmNum);
				sElmCss=getExcelCellData(xSheet,iPFrow,iElmCssPathClmNum);
				sElmXpath=getExcelCellData(xSheet,iPFrow,iElmXpathClmNum);
				
				if(!sElmId.equalsIgnoreCase("NA"))
				{
					wElement=driver.findElement(By.id(sElmId));
					if(wElement != null)
					{
						fillExcelCellCOlor( xPFWB, xSheet, iPFrow, iElmIdStsClmNum, "GREEN");
						SetExcelCellData(sExcelPageFactoryFile,xSheet,iPFrow,iElmIdStsClmNum,true);
						sFindBy=sFindByID+sElmId+sFindBy2;
						sEleName="private WebElement nav_"+sElmName;
						bw.write(sFindBy);
						bw.write(System.getProperty( "line.separator" ));
						bw.write(sEleName);
						bw.write(System.getProperty( "line.separator" ));
						bw.write(System.getProperty( "line.separator" ));
						
					}
						
				}
				else if(!sElmCss.equalsIgnoreCase("NA"))
				{
					wElement=driver.findElement(By.cssSelector(sElmCss));
					if(wElement != null)
					{
						fillExcelCellCOlor( xPFWB, xSheet, iPFrow, iElmIdStsClmNum, "GREEN");
						SetExcelCellData(sExcelPageFactoryFile,xSheet,iPFrow,iElmIdStsClmNum,true);
						sFindBy=sFindByCss+sElmCss+sFindBy2;
						sEleName="private WebElement nav_"+sElmName;
						bw.write(sFindBy);
						bw.write(System.getProperty( "line.separator" ));
						bw.write(sEleName);
						bw.write(System.getProperty( "line.separator" ));
						bw.write(System.getProperty( "line.separator" ));
						
					}
						
				}
				else if(!sElmXpath.equalsIgnoreCase("NA"))
				{
					wElement=driver.findElement(By.id(sElmXpath));
					if(wElement != null)
					{
						SetExcelCellData(sExcelPageFactoryFile,xSheet,iPFrow,iElmXpathStsClmNum,true);
						fillExcelCellCOlor( xPFWB, xSheet, iPFrow, iElmIdStsClmNum, "GREEN");
						sFindBy=sFindBy1+sElmXpath+sFindBy2;
						sEleName="private WebElement nav_"+sElmName;
						bw.write(sFindBy);
						bw.write(System.getProperty( "line.separator" ));
						bw.write(sEleName);
						bw.write(System.getProperty( "line.separator" ));
						bw.write(System.getProperty( "line.separator" ));
					}
				}
				
				
			}
			saveExcel(xPFWB,sExcelPageFactoryFile);
			bw.close();
		}
	 catch (Exception e) {
		// TODO Auto-generated catch block
		LoggerUtil.log_type_error( "Exception occured" +  e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "warn", e.getMessage());
		
	 }
	}
	
		
		
	 
		
	 
	/*====================================================================================================
	Method Name 	: getExcelSheet
	Description		: Used to get given excel sheet from file
	
	Author 			: Sukur Babu. B
	Creation Date 	: 23/03/2016
	Pre-Requisites	:
	Revision History:
	====================================================================================================*/
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
	/*====================================================================================================
	Method Name 	: getColumnNumber
	Description		: Used to get the column number based on column name
	
	Author 			: Sukur Babu. B
	Creation Date 	: 23/03/2016
	Pre-Requisites	:
	Revision History:
	====================================================================================================*/
	
	public static int getColumnNumber(XSSFSheet xSheet,String sColumnName)
	{//please add comments
		boolean bColFoundflag=false;
		XSSFCell cell = null;
		int iColNum = -1;
		Iterator<Row> rowIterator = xSheet.iterator();
		Row row = rowIterator.next();
		int iColCnt=row.getLastCellNum();
		while (rowIterator.hasNext()) 
        {
			//xSheet.se
            row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
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
	/*====================================================================================================
	Method Name 	: getExcelCellData
	Description		: Used to get the cell data from given sheet
	
	Author 			: Sukur Babu. B
	Creation Date 	: 23/03/2016
	Pre-Requisites	:
	Revision History:
	====================================================================================================*/
	
	public static String getExcelCellData(XSSFSheet xSheet,int iRowNum,int iColumnNum)
	{
		String sData = null;
		sData=xSheet.getRow(iRowNum).getCell(iColumnNum).toString();
		
		return sData;
		
	}
	/*====================================================================================================
	Method Name 	: SetExcelCellData
	Description		: Used to set the cell data in a given sheet
	
	Author 			: Sukur Babu. B
	Creation Date 	: 23/03/2016
	Pre-Requisites	:
	Revision History:
	====================================================================================================*/
	public static void SetExcelCellData(String sFile,XSSFSheet xSheet,int iRowNum,int iColumnNum,boolean bStatus)
	{
		try{
			//please add comments
		XSSFWorkbook workbook = new XSSFWorkbook(sFile);
		//Row xssfRow=xSheet.createRow(iRowNum);
		//xssfRow.setRowNum(iRowNum);
//		XSSFCell xssfcell=xssfRow.createCell(iColumnNum);
		//Cell xssfcell=xssfRow.createCell(iColumnNum);
		Cell xssfcell=null;
		xssfcell=xSheet.getRow(iRowNum).getCell(iColumnNum);
		xssfcell.setCellValue("PASS");
		FileOutputStream outputStream = new FileOutputStream("D://A.xlsx") ;
		workbook.write(outputStream);
	
		outputStream.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		
	}
	
	/*====================================================================================================
	Method Name 	: writeExcelData
	Description		: Used to write cell data in excel sheet
	
	Author 			: Sukur Babu. B
	Creation Date 	: 23/03/2016
	Pre-Requisites	:
	Revision History:
	====================================================================================================*/
	public static void writeExcelData(XSSFSheet xSheet,int iRow,int iCol,String sData)
	{
		try {
				//Row rowinExcel = xSheet.createRow(iRow);
				Row rowinExcel =xSheet.getRow(iRow);
				rowinExcel.setRowNum(iRow);
				
				Cell cellInExcel=rowinExcel.createCell(iCol);
				//Cell cellInExcel=rowinExcel.getCell(iCol);
	        	cellInExcel.setCellValue(sData);
	        	
					}
		catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 
		}
		
	}
	/*====================================================================================================
	Method Name 	: fillExcelCellCOlor
	Description		: Used to fill woth color in cell
	
	Author 			: Sukur Babu. B
	Creation Date 	: 23/03/2016
	Pre-Requisites	:
	Revision History:
	====================================================================================================*/
	public static void fillExcelCellCOlor(XSSFWorkbook XWrkBook,XSSFSheet xSheet,int iRow,int iCol,String sColor)
	{       //please add comments
			Row rowinExcel =xSheet.getRow(iRow);
			rowinExcel.setRowNum(iRow);
			Cell cellInExcel=rowinExcel.getCell(iCol);
			//Cell cellInExcel=null;
			//cellInExcel=rowinExcel.getCell(iCol);
			//if(cellInExcel.getCellType=CELL_TYPE_BLANK)
				
			XSSFCellStyle my_style = XWrkBook.createCellStyle();

			my_style.setFillPattern(XSSFCellStyle.LESS_DOTS );
			//my_style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
			my_style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
			cellInExcel.setCellStyle(my_style);
	}
	/*====================================================================================================
	Method Name 	: fillExcelCellCOlor
	Description		: Used to fill woth color in cell
	
	Author 			: Sukur Babu. B
	Creation Date 	: 23/03/2016
	Pre-Requisites	:
	Revision History:
	====================================================================================================*/
	public static void fillExcelCellGREENCOlor(XSSFWorkbook XWrkBook,XSSFSheet xSheet,int iRow,int iCol,String sColor)
	{       //please add comments
			Row rowinExcel =xSheet.getRow(iRow);
			rowinExcel.setRowNum(iRow);
			Cell cellInExcel=rowinExcel.getCell(iCol);
			XSSFCellStyle my_style = XWrkBook.createCellStyle();

			my_style.setFillPattern(XSSFCellStyle.FINE_DOTS );
			//my_style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
			my_style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
			cellInExcel.setCellStyle(my_style);
	}
	/*====================================================================================================
	Method Name 	: saveExcel
	Description		: Used to Save an excel
	
	Author 			: Sukur Babu. B
	Creation Date 	: 23/03/2016
	Pre-Requisites	:
	Revision History:
	====================================================================================================*/
	public static void saveExcel(XSSFWorkbook xWBook,String sFile)
	{//please add comments
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
		
		/*====================================================================================================
		Method Name 	: getWB
		Description		: Used to get Wrok of an excel fiel
		
		Author 			: Sukur Babu. B
		Creation Date 	: 23/03/2016
		Pre-Requisites	:
		Revision History:
		====================================================================================================*/		
		
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
			
//update each @test result in custom result file
		@AfterMethod
		public static void afterEachMethod(){
			FrameworkUtil.updateTestCaseStatusinResult();
			FrameworkUtil.sTestExecutionStatus = true;
			
		}
	

}






