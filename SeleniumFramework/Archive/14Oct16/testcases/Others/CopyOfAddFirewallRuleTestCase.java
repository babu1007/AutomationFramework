package com.whs.navigator.testcases.Others;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
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
//import com.whs.navigator.pagefactory.EVDC_FirewallPageFactory;
import com.whs.navigator.pagefactory.FirewallPageFactory;
//import com.whs.navigator.pagefactory.AddFirewallPageFactory;
import com.whs.navigator.pagefactory.UserPermissionPageFactory;
import com.whs.navigator.commonUtil.CustomWebElementUtil;


public class CopyOfAddFirewallRuleTestCase {

	static CommonPageFactory CommonPF = new CommonPageFactory();
	public static FirewallPageFactory Firewall = new FirewallPageFactory();
	public static UserPermissionPageFactory UserPermission=new UserPermissionPageFactory();
	//public static EVDC_FirewallPageFactory EVDC_Firewall=new EVDC_FirewallPageFactory();
    //static HomeTestCase HomeTestcase = new HomeTestCase();

	//String sFileNamePath=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.ADD.EXCEL.FILE.PATH");
	

	/*==============================================================
	TestScript 		: addFirewallRules
	Manual TestCase	: Verify given user able to add firewall rules
	Description		: Verify given user able to add firewall rules
	Author 			: Sukur Babu
	Creation Date 	: 08/01/2016
	Pre-Requisites	:
	Revision History:
	
	==============================================================*/
	@Test(priority=1)
	public void addFirewallRules(){
		
		String sFileNamePath=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.ADD.EXCEL.FILE.PATH");
			//	"D:\\Navigator-MasterWorkSpace\\WHS_Navigator_QAAUTO\\src\\resources\\Leftcourt Firewall Test Data.xlsx";
		
		String sSheetName=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.ADD.EXCEL.SHEET");
		//"Firewall TestData";
		String sCellData = null;
		String[] sTemp;
		int iSeqCol,iSTypeCol,iSourceCol,iSSubnetCol,iDTypeCol,iDestinationCol,iDSubnetCol,iSerTypeCol,iProtocolCol,iPortCol,iStsCol,iActionCol,iExeFlag,iExeStsCol;
		String sSeqNumber,sSrcType,sSrc,sSubnet,sDsetType,sDest,sDestSubnet,sSerType,sProtocol,sPort,sSts,sAction,sExeFlag; 
		boolean bfillDataSts = true,bVerifyDataSts = false;
		
		XSSFSheet xSheet;
		
		FileInputStream file;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, AddFirewallRuleTestCase.Firewall);
		PageFactory.initElements(driver, UserPermission);
		PageFactory.initElements(driver, CommonPF);
		
		
		
		FrameworkUtil.sTestCaseName = "Leftcourt2-addFirewallRules";
		FrameworkUtil.sManualTestCaseName="Verify given user able to add firewall rules";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		String sFireWallToExpand=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.FIREWALLTOEXPAND");
		String sFireWallRuleToExpand=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.FIREWALLRULETOEXPAND");
		
		String sFirewallHSWarnMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.HS.WARN.FEEDBACK.MSG");
		String sFirewallEditErrMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.EDIT.ERROR.FEEDBACK.MSG");
		String sInterFaceName=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.INTERFACENAME");
		String sInterFaceDesc=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.INTERFACEDESCRIPTION");
		//LoginTestCase.LoginAsEntity02aUser();
/*		LoginTestCase.LoginAsQaautoUser();
		EVDC_FirewallTestCase.NavigateToFirewallPage();
		if(UserPermission.getNav_FeedBackArea().getText().contains(sFirewallEditErrMsg))
			FrameworkUtil.updateCustomResultBasedOnStatus(false,UserPermission.getNav_FeedBackArea().getText() +" is displayed after navigating to the firewall Page ");
		*/
		XSSFWorkbook xWrkBook=getWB(sFileNamePath);
		xSheet=xWrkBook.getSheet(sSheetName);

		//		xSheet=getExcelSheet(sFileNamePath,sSheetName);
        iExeFlag=getColumnNumber(xSheet,"Add?");
        /* iSeqCol=getColumnNumber(xSheet,"Sequence Number");
        iSTypeCol=getColumnNumber(xSheet,"Source Type");
        iSourceCol=getColumnNumber(xSheet,"Source");
        iSSubnetCol=getColumnNumber(xSheet,"Source Subnet");
        iDTypeCol=getColumnNumber(xSheet,"Destination Type");
        iDestinationCol=getColumnNumber(xSheet,"Destination");
        iDSubnetCol=getColumnNumber(xSheet,"Destination Subnet");
        iSerTypeCol=getColumnNumber(xSheet,"Service Tpye");
        iProtocolCol=getColumnNumber(xSheet,"Protocol");
        iPortCol=getColumnNumber(xSheet,"Port");
        iStsCol=getColumnNumber(xSheet,"Status");
        iActionCol=getColumnNumber(xSheet,"Action");*/
        iExeStsCol=getColumnNumber(xSheet,"Execution Status");
        int iRowCnt=xSheet.getLastRowNum();
        
        for(int row=1;row<iRowCnt;row++)
        {
        	sExeFlag=getExcelCellData(xSheet,row,iExeFlag);
        	if(sExeFlag.equalsIgnoreCase("y"))
        	{
	        /*	sSeqNumber=getExcelCellData(xSheet,row,iSeqCol);
	        	sSrcType=getExcelCellData(xSheet,row,iSTypeCol);
	        	sSrc=getExcelCellData(xSheet,row,iSourceCol);
	        	sSubnet=getExcelCellData(xSheet,row,iSSubnetCol);
	        	sDsetType=getExcelCellData(xSheet,row,iDTypeCol);
	        	sDest=getExcelCellData(xSheet,row,iDestinationCol);
	        	sDestSubnet=getExcelCellData(xSheet,row,iDSubnetCol);
	        	sSerType=getExcelCellData(xSheet,row,iSerTypeCol);
	        	sProtocol=getExcelCellData(xSheet,row,iProtocolCol);
	        	sPort=getExcelCellData(xSheet,row,iPortCol);
	        	sSts=getExcelCellData(xSheet,row,iActionCol);
	        	sAction=getExcelCellData(xSheet,row,iSTypeCol);
	        	
	        	
	        	
	        	
	       /* 	int iRowNumber=WebTableUtil.getRowByCellText(UserPermission.getNav_FirewallTable(), sFireWallToExpand, 0,1);
	    		WebElement wInterfaceExpandWebElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.EXPANDER","PARAMETER_ROWNUMBER",iRowNumber+"");
	    		wInterfaceExpandWebElement.click();
	    		WebObjectUtil.waitForElementPresent(Firewall.getNav_AddFireWallLink());
	        	
	        	WebObjectUtil.clickElement(Firewall.getNav_AddFireWallLink());
	    		WebObjectUtil.waitForElementPresent(Firewall.getNav_AddFirewallSeqNumEdit());
	    		
	    		List<WebElement> wRowWebELements;
	    		int iFirewallRuleCnt=0;
	    		bfillDataSts=true;
	    		waitForFeedbackMsgNotdisplayed();
	    		expandInterface(sInterFaceName,sInterFaceDesc);
	    		WebObjectUtil.clickElement(Firewall.getNav_AddFireWallLink());
	    		//FrameworkUtil.updateCustomResultBasedOnStatus(true, "Executing Iteration.."+row);
	    		bfillDataSts=addFirewallInfoWindow(row,sSeqNumber,sSrcType,sSrc,sSubnet,sDsetType,sDest,sDestSubnet,sSerType,sProtocol,sPort,sSts,sAction);
	        	
	    		waitForFeedbackMsgNotdisplayed();*/
	        	if(bfillDataSts)
	        	{
	        		writeExcelData(xSheet,row,iExeStsCol,"PASS, Firewall rule not added");
	        		fillExcelCellCOlor(xWrkBook,xSheet,row,iExeStsCol,"RED");
//	        		int iRowNumber=WebTableUtil.getRowByCellText(UserPermission.getNav_FirewallTable(), sFireWallToExpand, 0,1);
//		    		WebElement wInterfaceExpandWebElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.EXPANDER","PARAMETER_ROWNUMBER",iRowNumber+"");
//		    		wInterfaceExpandWebElement.click();
	        		/*expandInterface(sInterFaceName,sInterFaceDesc);
		    		WebObjectUtil.waitForElementPresent(Firewall.getNav_AddFireWallLink());
		    		wRowWebELements=UserPermission.getNav_FirewallTable().findElements(By.tagName("table"));
		    		
//		    		If at all pagination needs to included, then we need to start loop here
//		    		Get the total number of page count
//		    		for p=1 to pgcnt
//		    		String ipgCnt=Firewall.getNav_NumberOfPagesText().getText();
//		    		String[] sTempArr;
//		    		sTempArr=ipgCnt.split(" ");
//		    		int iNumberofPages=Integer.parseInt(sTempArr[1]);
//		    				
//		    		for(int pg=1; pg<=iNumberofPages;pg++)
//		    		{
			    		iFirewallRuleCnt=wRowWebELements.size();
			    		
			    		for(int iFrcntr=1;iFrcntr<iFirewallRuleCnt;iFrcntr++)
			    		{
				    		//int iRuleRowNumber=WebTableUtil.getRowByCellText(UserPermission.getNav_FirewallTable(), sFireWallRuleToExpand, 0,1);
				    		WebElement wRuleExpandWebElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.RULE.EXPANDER","PARAMETER_ROWNUMBER",iFrcntr+"");
				    		wRuleExpandWebElement.click();
				    		
				    		if(!UserPermission.getNav_FeedBackArea().getText().contains(sFirewallHSWarnMsg))
				    			bVerifyDataSts=verifyFirewallRuledata(iFrcntr,"",sSrcType,sSrc,sSubnet,sDsetType,sDest,sDestSubnet,sSerType,sProtocol,sPort,sSts,sAction);
				    		else
				    		{
				    			
				    			FrameworkUtil.updateCustomResultBasedOnStatus(false,UserPermission.getNav_FeedBackArea().getText() +" is displayed while expanding the firewall rule at row "+iFrcntr);
				    			continue;
				    			
				    		}
				    		if(bVerifyDataSts)
				    			break;
				    		else
				    			continue;
			    		}
			    		if(bVerifyDataSts)
			    			break;
			    		else
			    			WebObjectUtil.clickElement(Firewall.getNav_PaginationNextButton());
//	        	}//????End Of pagination loop
//		    		
	        	}*/
	        		if(bVerifyDataSts)
	        		{
	        			//FrameworkUtil.updateCustomResultBasedOnStatus(true, "Firewall Rule found sucessfully for the data \n Sequesnce Number = "+sSeqNumber+"\n Source Type = "+sSrcType+"\nSource = "+sSrc+ "\n sSource Subnet = "+sSubnet+"\n Destination Type = "+sDsetType+"\n Destination = "+sDest+ "\n Destination Subnet = "+sDestSubnet+"\n Service Type = "+sSerType+"\n Protocol = "+sProtocol+ "\n Port = "+sPort+"\n Status = "+sSts+ "\n Action = "+sAction);
	        			//FrameworkUtil.updateCustomResultBasedOnStatus(true, "Firewall Rule found sucessfully for the data \n Source Type = "+sSrcType+"\nSource = "+sSrc+ "\n sSource Subnet = "+sSubnet+"\n Destination Type = "+sDsetType+"\n Destination = "+sDest+ "\n Destination Subnet = "+sDestSubnet+"\n Service Type = "+sSerType+"\n Protocol = "+sProtocol+ "\n Port = "+sPort+"\n Status = "+sSts+ "\n Action = "+sAction);
	        			writeExcelData(xSheet,row,iExeStsCol,"PASS, Added firewall rule found in the page");
	        			fillExcelCellCOlor(xWrkBook,xSheet,row,iExeStsCol,"RED");
	        		}else
	        		{
	        			//FrameworkUtil.updateCustomResultBasedOnStatus(false, "Firewall Rule not found for the data \n Sequesnce Number = "+sSeqNumber+"\n Source Type = "+sSrcType+"\nSource = "+sSrc+ "\n sSource Subnet = "+sSubnet+"\n Destination Type = "+sDsetType+"\n Destination = "+sDest+ "\n Destination Subnet = "+sDestSubnet+"\n Service Type = "+sSerType+"\n Protocol = "+sProtocol+ "\n Port = "+sPort+"\n Status = "+sSts+ "\n Action = "+sAction);
	        			//FrameworkUtil.updateCustomResultBasedOnStatus(false, "Firewall Rule not found for the data \n Source Type = "+sSrcType+"\nSource = "+sSrc+ "\n sSource Subnet = "+sSubnet+"\n Destination Type = "+sDsetType+"\n Destination = "+sDest+ "\n Destination Subnet = "+sDestSubnet+"\n Service Type = "+sSerType+"\n Protocol = "+sProtocol+ "\n Port = "+sPort+"\n Status = "+sSts+ "\n Action = "+sAction);
	        			writeExcelData(xSheet,row,iExeStsCol,"FAIL, Added firewall rule not found in the page");
	        			fillExcelCellCOlor(xWrkBook,xSheet,row,iExeStsCol,"RED");
	        		}
	        	//SetExcelCellData(sFileNamePath,xSheet,row,iExeStsCol,true);
        	}
        	else
        		continue;
        
        }
        }
        		saveExcel(xWrkBook,sFileNamePath);
				//LoginTestCase.nav_Logout();
		
		
		//LoginTestCase.nav_Logout();
	}
	
	
	
	@Test(priority=1)
	public void addFirewallRules1(){
		
		String sFileNamePath="C:\\Users\\Sbabu\\Desktop\\SS.xlsx";
			//	"D:\\Navigator-MasterWorkSpace\\WHS_Navigator_QAAUTO\\src\\resources\\Leftcourt Firewall Test Data.xlsx";
		
		String sSheetName="Delete Firewall Rule";
		XSSFWorkbook myWorkBook = null;
	
		
		String sCellData = null;
		String[] sTemp;
		int iSeqCol,iSTypeCol,iSourceCol,iSSubnetCol,iDTypeCol,iDestinationCol,iDSubnetCol,iSerTypeCol,iProtocolCol,iPortCol,iStsCol,iActionCol,iExeFlag,iExeStsCol;
		String sSeqNumber,sSrcType,sSrc,sSubnet,sDsetType,sDest,sDestSubnet,sSerType,sProtocol,sPort,sSts,sAction,sExeFlag; 
		boolean bfillDataSts,bVerifyDataSts = false;
		
		XSSFSheet xSheet;
		
		FileInputStream file = null;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, CopyOfAddFirewallRuleTestCase.Firewall);
		PageFactory.initElements(driver, UserPermission);
		PageFactory.initElements(driver, CommonPF);
		
		
		myWorkBook=getWB(sFileNamePath);
		xSheet=myWorkBook.getSheet(sSheetName);
		//xSheet=getExcelSheet(sFileNamePath,sSheetName);
       
        int iRowCnt=xSheet.getLastRowNum();
        int c=0;
        for(int row=1;row<iRowCnt;row++)
        {
        	  
	        	Row rowinExcel = xSheet.createRow(row);
	        	Cell cellInExcel=rowinExcel.createCell(c++);
	        	
	        	cellInExcel.setCellValue("SUKUR WRITTEN");
	        	
        }
      
    	FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(sFileNamePath);
			try {
				myWorkBook.write(fileOut);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//write this workbook to an Outputstream.
		
		try {
			fileOut.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fileOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		//LoginTestCase.nav_Logout();
		
		
		//LoginTestCase.nav_Logout();
	}
	@Test(priority=2)
public void writeXLSXFile() {
		
		String excelFileName = "C://Test.xlsx";//name of excel file

		String sheetName = "SUKUR";//name of sheet

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet(sheetName) ;

		//iterating r number of rows
		for (int r=0;r < 5; r++ )
		{
			XSSFRow row = sheet.createRow(r);

			//iterating c number of columns
			for (int c=0;c < 5; c++ )
			{
				XSSFCell cell = row.createCell(c);
	
				cell.setCellValue("Cell "+r+" "+c);
			}
		}

		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(excelFileName);
			try {
				wb.write(fileOut);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//write this workbook to an Outputstream.
		
		try {
			fileOut.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fileOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static boolean verifyFirewallRuledata(int iRow,String sSeqNumber,String sSrcType,String sSrc,String sSubnet,String sDsetType,String sDest,String sDestSubnet,String sSerType,String sProtocol,String sPort,String sSts,String sAction)
//	public static boolean verifyFirewallRuledata(int iRow,String sSrcType,String sSrc,String sSubnet,String sDsetType,String sDest,String sDestSubnet,String sSerType,String sProtocol,String sPort,String sSts,String sAction)
	{
		String sSrcSeqNum,sSrcTypeText,sSrcText,sSrcMskText,sDestTypeText,sDestText,sDestMskText,sSerText,sProtocolText,sPortText,sStsText,sActionText;
		String[] sTemp,sTemp1;
		boolean bFndFlag=false;
//		String sTmpPrt="78.0",s;
//		sTemp1=sTmpPrt.split(".");
//		s=sTemp1[0];
		if(sSrcType.equalsIgnoreCase("N/A"))
			sSrcType=" ";
		if(sSrc.equalsIgnoreCase("N/A"))
			sSrc=" ";
		if(sSubnet.equalsIgnoreCase("N/A"))
			sSubnet=" ";
		if(sDsetType.equalsIgnoreCase("N/A"))
			sDsetType=" ";
		if(sDest.equalsIgnoreCase("N/A"))
			sDest="";
		if(sDestSubnet.equalsIgnoreCase("N/A"))
			sDestSubnet=" ";
		if(sSerType.equalsIgnoreCase("N/A"))
			sSerType=" ";
		if(sProtocol.equalsIgnoreCase("N/A"))
			sProtocol=" ";
		if(sPort.equalsIgnoreCase("N/A"))
			sPort="";
		else if(sPort.contains("."))
		{
			 System.out.println("Port values before split is "+sPort);
			 sTemp=sPort.split("\\.");
			 System.out.println("Arrary length after split is "+sTemp.length);
			 sPort=sTemp[0];
		}
		if(sSts.equalsIgnoreCase("N/A"))
			sSts=" ";
		if(sAction.equalsIgnoreCase("N/A"))
			sAction=" ";
		WebElement wSeqNumElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.SEQUENCENUMBER","PARAMETER_ROWNUMBER",iRow+"");
		WebElement wSrcTypeElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.SOURCETYPE","PARAMETER_ROWNUMBER",iRow+"");
		WebElement wSrcElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.SOURCE","PARAMETER_ROWNUMBER",iRow+"");
		WebElement wSrcMskElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.SOURCEMASK","PARAMETER_ROWNUMBER",iRow+"");
		WebElement wDestTypeElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.DESTINATIONTYPE","PARAMETER_ROWNUMBER",iRow+"");
		WebElement wDestElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.DESTINATION","PARAMETER_ROWNUMBER",iRow+"");
		WebElement wDestMskElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.DESTINATIONMASK","PARAMETER_ROWNUMBER",iRow+"");
		WebElement wSerTypeElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.SERVICETYPE","PARAMETER_ROWNUMBER",iRow+"");
		WebElement wProtocolElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.PROTOCOL","PARAMETER_ROWNUMBER",iRow+"");
		WebElement wPortElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.PORT","PARAMETER_ROWNUMBER",iRow+"");
		WebElement wStsElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.STATUS","PARAMETER_ROWNUMBER",iRow+"");
		WebElement wActionElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.ACTION","PARAMETER_ROWNUMBER",iRow+"");
		
		sSrcSeqNum=wSeqNumElement.getAttribute("value");
		sSrcTypeText=wSrcTypeElement.getAttribute("value");
		sSrcText=wSrcElement.getAttribute("value");
		sSrcMskText=wSrcMskElement.getAttribute("value");
		sDestTypeText=wDestTypeElement.getAttribute("value");
		sDestText=wDestElement.getAttribute("value");
		sDestMskText=wDestMskElement.getAttribute("value");
		sSerText=wSerTypeElement.getAttribute("value");
		sProtocolText=wProtocolElement.getAttribute("value");
		sPortText=wPortElement.getAttribute("value");
		sStsText=wStsElement.getAttribute("alt");
		sActionText=wActionElement.getAttribute("alt");
		
//		if(sSrcSeqNum.equalsIgnoreCase(sSeqNumber)&& sSrcTypeText.equalsIgnoreCase(sSrcType) && sSrcText.equalsIgnoreCase(sSrc) && sSrcMskText.equalsIgnoreCase(sSubnet)&&
//				sDestTypeText.equalsIgnoreCase(sDsetType) && sDestText.equalsIgnoreCase(sDest) && sDestMskText.equalsIgnoreCase(sDestSubnet) &&
//				sSerText.equalsIgnoreCase(sSerType) && sProtocolText.equalsIgnoreCase(sProtocol) && sPortText.equalsIgnoreCase(sPort) && sStsText.equalsIgnoreCase(sSts) && sActionText.equalsIgnoreCase(sAction))
			
		
		if(sSeqNumber.equalsIgnoreCase(""))
		{
			if(sSrcTypeText.equalsIgnoreCase(sSrcType) && sSrcText.equalsIgnoreCase(sSrc) && sSrcMskText.equalsIgnoreCase(sSubnet)&&
						sDestTypeText.equalsIgnoreCase(sDsetType) && sDestText.equalsIgnoreCase(sDest) && sDestMskText.equalsIgnoreCase(sDestSubnet) &&
						sSerText.equalsIgnoreCase(sSerType) && sProtocolText.equalsIgnoreCase(sProtocol) && sPortText.equalsIgnoreCase(sPort) && sStsText.equalsIgnoreCase(sSts) && sActionText.equalsIgnoreCase(sAction))
				bFndFlag=true;
			else
				bFndFlag=false;
		}
		else
		{
			if(sSrcSeqNum.equalsIgnoreCase(sSeqNumber)&& sSrcTypeText.equalsIgnoreCase(sSrcType) && sSrcText.equalsIgnoreCase(sSrc) && sSrcMskText.equalsIgnoreCase(sSubnet)&&
					sDestTypeText.equalsIgnoreCase(sDsetType) && sDestText.equalsIgnoreCase(sDest) && sDestMskText.equalsIgnoreCase(sDestSubnet) &&
					sSerText.equalsIgnoreCase(sSerType) && sProtocolText.equalsIgnoreCase(sProtocol) && sPortText.equalsIgnoreCase(sPort) && sStsText.equalsIgnoreCase(sSts) && sActionText.equalsIgnoreCase(sAction))
			bFndFlag=true;
		else
			bFndFlag=false;
		}
//		if(bFndFlag)
//			FrameworkUtil.updateCustomResultBasedOnStatus(true, "Firewall Rule found for the data \n Sequesnce Number = "+sSeqNumber+"\n Source Type = "+sSrcType+"\nSource = "+sSrc+ "\n sSource Subnet = "+sSubnet);
//		else
//			FrameworkUtil.updateCustomResultBasedOnStatus(true, "Firewall Rule not found for the data \n Sequesnce Number = "+sSeqNumber+"\n Source Type = "+sSrcType+"\nSource = "+sSrc+ "\n sSource Subnet = "+sSubnet);
		//return true;
		return bFndFlag;
	}
	

	public static boolean addFirewallInfoWindow(int iIterationCntr,String sSeqNum,String sSrcTypeItem,String sSource,String sSrcSubnet,String sDestType,String sDest,String sDestSubnet,String sSerType,String sProtocol,String sPort,String sSts,String sAction)
	{
		String sULElementXpath = (String) FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
		String sFeedBackMsg=(String) FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.SUCCESS.FEEDBACK.MSG");
		boolean bSts;
		try{
			
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Firewall);
		PageFactory.initElements(driver, UserPermission);
		PageFactory.initElements(driver, CommonPF);
		
		FrameworkUtil.updateCustomResultBasedOnStatus(true, "Executing Iteration . . .  "+iIterationCntr);
		WebObjectUtil.SetValueEdit(Firewall.getNav_AddFirewallSeqNumEdit(), sSeqNum);
		
		WebObjectUtil.clickElement(Firewall.getNav_SourceTypeDropdownArrow());
		WebElement wDropDown=WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
		//Folowing code helps to enter all source realted fields
		WebObjectUtil.selectCustomWebList(wDropDown, sSrcTypeItem);
		if(sSrcTypeItem.equalsIgnoreCase("Host"))
			WebObjectUtil.SetValueEdit(Firewall.getNav_AddFirewallSourceIPEdit(), sSource);
		else if(sSrcTypeItem.equalsIgnoreCase("Object") || sSrcTypeItem.equalsIgnoreCase("Group Object"))
		{
			WebObjectUtil.clickElement(Firewall.getNav_SourceDropdownArrow());
			wDropDown=WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
			WebObjectUtil.selectCustomWebList(wDropDown, sSource);
		}
		else if(sSrcTypeItem.equalsIgnoreCase("Network"))
		{
			WebObjectUtil.SetValueEdit(Firewall.getNav_AddFirewallSourceIPEdit(), sSrcTypeItem);
			WebObjectUtil.clickElement(Firewall.getNav_SourceMaskDropdownArrow());
			wDropDown=WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
			WebObjectUtil.selectCustomWebList(wDropDown, sSrcSubnet);
		}
		
		//Folowing code helps to enter all destination realted fields
		WebObjectUtil.clickElement(Firewall.getNav_DestinationTypeDropdownArrow());
		wDropDown=WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
		WebObjectUtil.selectCustomWebList(wDropDown, sDestType);
		if(sDestType.equalsIgnoreCase("Host"))
			WebObjectUtil.SetValueEdit(Firewall.getNav_AddFirewallDestIPEdit(), sDest);
		else if(sDestType.equalsIgnoreCase("Object") || sSrcTypeItem.equalsIgnoreCase("Group Object"))
		{
			WebObjectUtil.clickElement(Firewall.getNav_DestinationDropdownArrow());
			wDropDown=WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
			
			WebObjectUtil.selectCustomWebList(wDropDown, sDest);
		}
		else if(sDestType.equalsIgnoreCase("Network"))
		{
			WebObjectUtil.SetValueEdit(Firewall.getNav_AddFirewallDestIPEdit(), sDest);
			WebObjectUtil.clickElement(Firewall.getNav_DestinationMaskDropdownArrow());
			wDropDown=WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
			WebObjectUtil.selectCustomWebList(wDropDown, sDestSubnet);
		}
		//Following code helps to enter all Service realted fields
		WebObjectUtil.clickElement(Firewall.getNav_ServiceTypeDropdownArrow());
		wDropDown=WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
		WebObjectUtil.selectCustomWebList(wDropDown, sSerType);
		if(sSerType.equalsIgnoreCase("Protocol"))
		{
			WebObjectUtil.clickElement(Firewall.getNav_ProtocolDropdownArrow());
			wDropDown=WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
			WebObjectUtil.selectCustomWebList(wDropDown, sProtocol);
			if(!sPort.equalsIgnoreCase("N/A"))
				WebObjectUtil.SetValueEdit(Firewall.getNav_AddFirewallPortEdit(),sPort);
		}
		else if(sSerType.equalsIgnoreCase("Service Group"))
		{
			WebObjectUtil.clickElement(Firewall.getNav_ProtocolDropdownArrow());
			wDropDown=WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
			WebObjectUtil.selectCustomWebList(wDropDown, sProtocol);
		}
		if(sSts.equalsIgnoreCase("Active"))
		{
			if(Firewall.getNav_AddFirewallStatus().getAttribute("alt").equalsIgnoreCase("Inactive"))
				WebObjectUtil.clickElement(Firewall.getNav_AddFirewallStatus());	
		}
		else if (sSts.equalsIgnoreCase("Inactive"))
		{
			if(Firewall.getNav_AddFirewallStatus().getAttribute("alt").equalsIgnoreCase("Active"))
				WebObjectUtil.clickElement(Firewall.getNav_AddFirewallStatus());
		}
		
		if(sAction.equalsIgnoreCase("Permit"))
		{
			if(Firewall.getNav_AddFirewallStatus().getAttribute("alt").equalsIgnoreCase("Deny"))
				WebObjectUtil.clickElement(Firewall.getNav_AddFirewallAction());	
		}
		else if (sAction.equalsIgnoreCase("Deny"))
		{
			if(Firewall.getNav_AddFirewallStatus().getAttribute("alt").equalsIgnoreCase("Permit"))
				WebObjectUtil.clickElement(Firewall.getNav_AddFirewallAction());
		}
		WebObjectUtil.clickElement(Firewall.getNav_FirewallSaveButton());
		WebObjectUtil.explicitWait(30);
		WebObjectUtil.waitForElementPresent(Firewall.getNav_FirewallConfirmWindow());
		WebObjectUtil.clickElement(Firewall.getNav_FirewallConfirmWindowOKButton());
		WebObjectUtil.explicitWait(20);
		if(CommonPF.getNav_UsrFeedBack().getText().contains(sFeedBackMsg))
		{
			FrameworkUtil.updateCustomResultBasedOnStatus(true, "Firewall Rule created sucessfully for the data \n Sequesnce Number = "+sSeqNum+"\n Source Type = "+sSrcTypeItem+"\nSource = "+sSource+ "\n sSource Subnet = "+sSrcSubnet);
			return true;
		}
		else
		{
			FrameworkUtil.updateCustomResultBasedOnStatus(false, "Issue in creating a firwall rule due to the issue " + CommonPF.getNav_UsrFeedBack().getText());
			return false;
		}
		
		}
		catch(Exception e){
			return false;
		}
			
		
		}
	public static boolean expandInterface(String sInterfaceName,String sInterfaceDescription)
	{
		int iintferRow,iintferCol;
		int iReqInterfaceRow = 0;
		boolean bReqInterfaceFlag=false;
//		String sInterfaceText="Interface - 1",sInterfaceDescriptionText="Outside - outside",;
//		String sInterfaceText="Interface - 2",sInterfaceDescriptionText="Internal - tstqaauto-VLANabc",sTempText;
//		String sInterfaceText="Global Implicit rule",sInterfaceDescriptionText="",sTempText;
		String sTempText;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, AddFirewallRuleTestCase.Firewall);
		PageFactory.initElements(driver, UserPermission);
		PageFactory.initElements(driver, CommonPF);
		WebElement wIntFaceElement;
		/*LoginTestCase.LoginAsQaautoUser();
		EVDC_FirewallTestCase.NavigateToFirewallPage();*/
		int iInterfaceCntinPg=WebTableUtil.getRowCount(Firewall.getNav_FirewallTable());
		System.out.println("Number Of interface in the page "+iInterfaceCntinPg);
		int iinterfaceColCnt=WebTableUtil.getColumnCount(Firewall.getNav_FirewallTable(), 1);
		System.out.println("Firewall table column count is "+iinterfaceColCnt);
		
		
		for( iintferRow=1;iintferRow<=iInterfaceCntinPg;iintferRow++)
		{
			for(iintferCol=1;iintferCol<=iinterfaceColCnt;iintferCol++)
			{
				if(WebTableUtil.getColumnCount(Firewall.getNav_FirewallTable(), iintferRow)>1){
					
					sTempText=WebTableUtil.getCellData(Firewall.getNav_FirewallTable(), iintferRow, iintferCol);
												
					if(sTempText.equalsIgnoreCase(sInterfaceName)){
						sTempText=WebTableUtil.getCellData(Firewall.getNav_FirewallTable(), iintferRow, iintferCol+1);
						if(!sTempText.isEmpty()){
						if(sTempText.equalsIgnoreCase(sInterfaceDescription)){
							System.out.println("Interface " +sInterfaceName+" found at row "+iintferRow+" and column "+iintferCol);
							iReqInterfaceRow=iintferRow;
							bReqInterfaceFlag=true;
							break;
					}
					}
					}
				}
				else if(WebTableUtil.getColumnCount(Firewall.getNav_FirewallTable(), iintferRow)==1){
					sTempText=WebTableUtil.getCellData(Firewall.getNav_FirewallTable(), iintferRow, 1);
					if(sTempText.equalsIgnoreCase(sInterfaceName)){
						iReqInterfaceRow=iintferRow;
						bReqInterfaceFlag=true;
						break;
					}
				}
			}
			 
		}
		if(bReqInterfaceFlag){
			WebElement wInterfaceExpandWebElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.EXPANDER","PARAMETER_ROWNUMBER",iReqInterfaceRow+"");
			wInterfaceExpandWebElement.click();
			WebObjectUtil.explicitWait(15);
			return true;
		}else{
			FrameworkUtil.updateCustomResultBasedOnStatus(false, "Issue in expanding Firewall interface");
			return false;
		}
		
	}
public static void writeExcelData(XSSFSheet xSheet,int iRow,int iCol,String sData)
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
		
	}
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
	
	public static int getColumnNumber(XSSFSheet xSheet,String sColumnName)
	{
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
	
	public static String getExcelCellData(XSSFSheet xSheet,int iRowNum,int iColumnNum)
	{
		String sData = null;
		sData=xSheet.getRow(iRowNum).getCell(iColumnNum).toString();
		
		return sData;
		
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
	
	public static boolean waitForFeedbackMsgNotdisplayed()
	{
		
		String sWaitFeedBackMsg;
		boolean bFuncStsFlag=false,bExec600Flag=false;
		Date d=new Date();
		//d=d.getDate();
		int dStrtsec,endSec = 0;
		//d.get
		sWaitFeedBackMsg=(String) FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.WAITING.FEEDBACK.MSG");
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, CopyOfAddFirewallRuleTestCase.Firewall);
		PageFactory.initElements(driver, CommonPF);
		try{
			dStrtsec=d.getSeconds();
			
			do
			{
				 
				driver.navigate().refresh();
				
				if(CommonPF.getNav_UsrFeedBack().getText().contains(sWaitFeedBackMsg))
				{
					//FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Firewall Feedback message", "done", CommonPF.getNav_UsrFeedBack().getText()+"time elapsed: "+endSec );
					WebObjectUtil.explicitWait(30);
				}
				else
					bFuncStsFlag=true;
				endSec=endSec+d.getSeconds();
				System.out.println("End Second"+endSec);
				if(endSec>1800)
				{
					//FrameworkUtil.updateCustomResultBasedOnStatus(false, CommonPF.getNav_UsrFeedBack().getText()+ "Feedback message is still displaying even after 10 mins");
					bFuncStsFlag=false;
					bExec600Flag=true;
					break;
				
				}
	
			}
			while(CommonPF.getNav_UsrFeedBack().getText().contains(sWaitFeedBackMsg));
			if(bExec600Flag)
				FrameworkUtil.updateCustomResultBasedOnStatus(false, CommonPF.getNav_UsrFeedBack().getText()+ "Feedback message is still displaying even after 10 mins");
			
			return bFuncStsFlag;
			
		}
		catch(Exception e)
		{
			bFuncStsFlag=false;
			return bFuncStsFlag;
		}
		
	}
	
	public static List findAllLinks(WebDriver driver)
	 
	  {
	 
		  List elementList = new ArrayList();
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
	
//update each @test result in custom result file
		@AfterMethod
		public static void afterEachMethod(){
			FrameworkUtil.updateTestCaseStatusinResult();
			FrameworkUtil.sTestExecutionStatus = true;
			
		}
	

}






