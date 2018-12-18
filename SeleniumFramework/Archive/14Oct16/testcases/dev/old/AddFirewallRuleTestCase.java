package com.whs.navigator.testcases.dev.old;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
//import com.whs.navigator.pagefactory.AddFirewallPageFactory;
import com.whs.navigator.pagefactory.UserPermissionPageFactory;
import com.whs.navigator.commonUtil.CustomWebElementUtil;


public class AddFirewallRuleTestCase {

	static CommonPageFactory CommonPF = new CommonPageFactory();
	public static EVDC_FirewallPageFactory Firewall = new EVDC_FirewallPageFactory();
	//public static FirewallPageFactory Firewall = new FirewallPageFactory();
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
		
		//Get the firewall rule test data file path
		String sFileNamePath=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.ADD.EXCEL.FILE.PATH");
		//Get the firewall rule test data sheet
		String sSheetName=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.ADD.EXCEL.SHEET");
		String sCellData = null;
		String[] sTemp;
		int iSeqCol,iSTypeCol,iSourceCol,iSSubnetCol,iDTypeCol,iDestinationCol,iDSubnetCol,iSerTypeCol,iProtocolCol,iPortCol,iStsCol,iActionCol,iExeFlag,iExeStsCol;
		String sSeqNumber,sSrcType,sSrc,sSubnet,sDsetType,sDest,sDestSubnet,sSerType,sProtocol,sPort,sSts,sAction,sExeFlag; 
		boolean bfillDataSts,bVerifyDataSts = false;
		XSSFSheet xSheet;
		FileInputStream file;
		//Initiate Webdriver and page factory
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, AddFirewallRuleTestCase.Firewall);
		PageFactory.initElements(driver, UserPermission);
		PageFactory.initElements(driver, CommonPF);
		//Update test case name,description in results
		FrameworkUtil.sTestCaseName = "Leftcourt2-addFirewallRules";
		FrameworkUtil.sManualTestCaseName="Verify given user able to add firewall rules";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		//Read the required data from properties file
		String sFireWallToExpand=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.FIREWALLTOEXPAND");
		String sFireWallRuleToExpand=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.FIREWALLRULETOEXPAND");
		String sFirewallHSWarnMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.HS.WARN.FEEDBACK.MSG");
		String sFirewallEditErrMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.EDIT.ERROR.FEEDBACK.MSG");
		String sInterFaceName=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.INTERFACENAME");
		String sInterFaceDesc=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.INTERFACEDESCRIPTION");
		//Login using Qaauto user credentials
		LoginTestCase.LoginAsQaautoUser();
		//Navigate to firewall page
		EVDC_FirewallTestCase.NavigateToFirewallPage();
		WebObjectUtil.explicitWait(10);
		//Check if any feedback message displayed
		if(UserPermission.getNav_FeedBackArea().getText().contains(sFirewallEditErrMsg))
			FrameworkUtil.updateCustomResultBasedOnStatus(false,UserPermission.getNav_FeedBackArea().getText() +" is displayed after navigating to the firewall Page ");
		//Get column number from excel
//		xSheet=getExcelSheet(sFileNamePath,sSheetName);
		XSSFWorkbook xWrkBook=getWB(sFileNamePath);
		xSheet=xWrkBook.getSheet(sSheetName);
        iExeFlag=getColumnNumber(xSheet,"Add?");
        iSeqCol=getColumnNumber(xSheet,"Sequence Number");
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
        iActionCol=getColumnNumber(xSheet,"Action");
        iExeStsCol=getColumnNumber(xSheet,"Execution Status");
        int iRowCnt=xSheet.getLastRowNum();
        
        for(int row=1;row<iRowCnt;row++)
        {
        	//Read the execution flag value from excel. If y add the firewall rule
        	sExeFlag=getExcelCellData(xSheet,row,iExeFlag);
        	//please pass any character value using properties file
        	if(sExeFlag.equalsIgnoreCase("y"))
        	{
        		//Read all the data from excel sheet
	        	sSeqNumber=getExcelCellData(xSheet,row,iSeqCol);
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
	        	

	    		List<WebElement> wRowWebELements;
	    		int iFirewallRuleCnt=0;
	    		bfillDataSts=true;
//	    		Wait until feedback messag disappears
	    		waitForFeedbackMsgNotdisplayed();
	    		//Expand given interface
	    		expandInterface(sInterFaceName,sInterFaceDesc);
	    		WebObjectUtil.clickElement(Firewall.getNav_AddFireWallLink());
	    		//FrameworkUtil.updateCustomResultBasedOnStatus(true, "Executing Iteration.."+row);
	    		//Fill all the data in all fields and click on save button and verify sucessful feedback message
	    		bfillDataSts=addFirewallInfoWindow(row,sSeqNumber,sSrcType,sSrc,sSubnet,sDsetType,sDest,sDestSubnet,sSerType,sProtocol,sPort,sSts,sAction);
//	    		Wait until feedback messag disappears
	    		waitForFeedbackMsgNotdisplayed();
	    		WebObjectUtil.explicitWait(300);
	    		//If firewall rule added sucessfully
	        	if(bfillDataSts)
	        	{

	        		expandInterface(sInterFaceName,sInterFaceDesc);
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
			    		//Loop until no of firwall rules in the page
			    		for(int iFrcntr=1;iFrcntr<iFirewallRuleCnt;iFrcntr++)
			    		{
				    		//int iRuleRowNumber=WebTableUtil.getRowByCellText(UserPermission.getNav_FirewallTable(), sFireWallRuleToExpand, 0,1);
				    		WebElement wRuleExpandWebElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.RULE.EXPANDER","PARAMETER_ROWNUMBER",iFrcntr+"");
				    		wRuleExpandWebElement.click();
				    		//Verify whether firewall rule added is available in application
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
	        	}
	        	//if firewall rule found then update the test data status column with pass with color
	        	if(bVerifyDataSts)
        		{
	        		FrameworkUtil.updateCustomResultBasedOnStatus(true, "Firewall Rule found sucessfully for the data \n Source Type = "+sSrcType+"\nSource = "+sSrc+ "\n sSource Subnet = "+sSubnet+"\n Destination Type = "+sDsetType+"\n Destination = "+sDest+ "\n Destination Subnet = "+sDestSubnet+"\n Service Type = "+sSerType+"\n Protocol = "+sProtocol+ "\n Port = "+sPort+"\n Status = "+sSts+ "\n Action = "+sAction);
        			writeExcelData(xSheet,row,iExeStsCol,"PASS, Added firewall rule found in the page");
        			fillExcelCellCOlor(xWrkBook,xSheet,row,iExeStsCol,"RED");
        		}else
        		{
        			FrameworkUtil.updateCustomResultBasedOnStatus(false, "Firewall Rule not found for the data \n Sequesnce Number = "+sSeqNumber+"\n Source Type = "+sSrcType+"\nSource = "+sSrc+ "\n sSource Subnet = "+sSubnet+"\n Destination Type = "+sDsetType+"\n Destination = "+sDest+ "\n Destination Subnet = "+sDestSubnet+"\n Service Type = "+sSerType+"\n Protocol = "+sProtocol+ "\n Port = "+sPort+"\n Status = "+sSts+ "\n Action = "+sAction);
        			writeExcelData(xSheet,row,iExeStsCol,"FAIL, Added firewall rule not found in the page");
        			fillExcelCellCOlor(xWrkBook,xSheet,row,iExeStsCol,"RED");
        		}
        	}
        	else
        		continue;
        
        }
        //Save the excel file
        saveExcel(xWrkBook,sFileNamePath);
		LoginTestCase.nav_Logout();
		
		
		//LoginTestCase.nav_Logout();
	}
	
	/*==============================================================
	TestScript 		: editFirewallRules
	Manual TestCase	: Verify given user able to edit firewall rules
	Description		: Verify given user able to edit firewall rules
	Author 			: Sukur Babu
	Creation Date 	: 08/01/2016
	Pre-Requisites	:
	Revision History:
	
	==============================================================*/
	@Test(priority=2)
	public void editFirewallRules(){
		
		//Please update the steps with appropriate comments for user's apprehension 
		//Get Add and Edit test data files and sheets
		String sEditFileNamePath=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.EDIT.EXCEL.FILE.PATH");
		String sEditSheetName=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.EDIT.EXCEL.SHEET");
		String sFileNamePath=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.ADD.EXCEL.FILE.PATH");
		String sSheetName=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.ADD.EXCEL.SHEET");
		
		String sCellData = null;
		String[] sTemp,sFieldsNeedToChangeArray;
		int iSeqCol,iSTypeCol,iSourceCol,iSSubnetCol,iDTypeCol,iDestinationCol,iDSubnetCol,iSerTypeCol,iProtocolCol,iPortCol,iStsCol,iActionCol,iAddExeFlagCol,iAddExeStsCol,iEditExeFlagCol;
		String sSeqNumber,sSrcType,sSrc,sSubnet,sDsetType,sDest,sDestSubnet,sSerType,sProtocol,sPort,sSts,sAction,sAddExeFlag,sEditExeFlag,sFirewallFieldsNeedToChangeCol; 
		int editFirewallRuleRow=0,iFirewallFieldsNeedToChangeCol;
		boolean bfillDataSts,bVerifyDataSts = false;
		WebElement wDropDown;
		boolean bNeedtoVerifyFlag=false;
		List<WebElement> wRowWebELements;
		int iFirewallRuleCnt=0;
		//xSheet is for Add firewall rule
		XSSFSheet xSheet,xEditSheet;
		
		FileInputStream file;
		//Intiate web driver and page factory
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, AddFirewallRuleTestCase.Firewall);
		PageFactory.initElements(driver, UserPermission);
		PageFactory.initElements(driver, CommonPF);
		
		//Update test case name and description in result file
		FrameworkUtil.sTestCaseName = "Leftcourt2-EditFirewallRules";
		FrameworkUtil.sManualTestCaseName="Verify given user able to edit firewall rules";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		//Get all firewall data from properties file
		String sFireWallToExpand=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.FIREWALLTOEXPAND");
		String sFireWallRuleToExpand=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.FIREWALL.FIREWALLRULETOEXPAND");
		String sInterFaceName=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.INTERFACENAME");
		String sInterFaceDesc=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.INTERFACEDESCRIPTION");
		String sFirewallHSWarnMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.HS.WARN.FEEDBACK.MSG");
		
		String sULElementXpath = (String) FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
		//Login into navigator using Qaauto user
		LoginTestCase.LoginAsQaautoUser();
		EVDC_FirewallTestCase.NavigateToFirewallPage();
		
		xSheet=getExcelSheet(sFileNamePath,sSheetName);
		//Get column numbers from excel
        iAddExeFlagCol=getColumnNumber(xSheet,"Add?");
        iEditExeFlagCol=getColumnNumber(xSheet,"Modify?");
        iSeqCol=getColumnNumber(xSheet,"Sequence Number");
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
        iActionCol=getColumnNumber(xSheet,"Action");
        //iAddExeStsCol=getColumnNumber(xSheet,"Execution Status");
        
        xEditSheet=getExcelSheet(sEditFileNamePath,sEditSheetName);
        //Get waht fields need to be changed in firewall rule
        iFirewallFieldsNeedToChangeCol=getColumnNumber(xEditSheet,"Modify Fields?");
        int iRowCnt=xSheet.getLastRowNum();
        
        for(int row=1;row<iRowCnt;row++)
        {
        	sAddExeFlag=getExcelCellData(xSheet,row,iAddExeFlagCol);
        	sEditExeFlag=getExcelCellData(xSheet,row,iEditExeFlagCol);
        	//If add flag and Modify flag bothe true then Update the firewall rule in the application
        	if(sAddExeFlag.equalsIgnoreCase("y") && sEditExeFlag.equalsIgnoreCase("y"))
        	{
	        	sSeqNumber=getExcelCellData(xSheet,row,iSeqCol);
	        	sSrcType=getExcelCellData(xSheet,row,iSTypeCol);
	        	sSrc=getExcelCellData(xSheet,row,iSourceCol);
	        	sSubnet=getExcelCellData(xSheet,row,iSSubnetCol);
	        	sDsetType=getExcelCellData(xSheet,row,iDTypeCol);
	        	sDest=getExcelCellData(xSheet,row,iDestinationCol);
	        	sDestSubnet=getExcelCellData(xSheet,row,iDSubnetCol);
	        	sSerType=getExcelCellData(xSheet,row,iSerTypeCol);
	        	sProtocol=getExcelCellData(xSheet,row,iProtocolCol);
	        	sPort=getExcelCellData(xSheet,row,iPortCol);
	        	sSts=getExcelCellData(xSheet,row,iStsCol);
	        	sAction=getExcelCellData(xSheet,row,iActionCol);
	        	
	        	sFirewallFieldsNeedToChangeCol=getExcelCellData(xEditSheet,row,iFirewallFieldsNeedToChangeCol);
	        	sFieldsNeedToChangeArray=sFirewallFieldsNeedToChangeCol.split(",");
	        	
//	        	int iRowNumber=WebTableUtil.getRowByCellText(UserPermission.getNav_FirewallTable(), sFireWallToExpand, 0,1);
//	    		WebElement wInterfaceExpandWebElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.EXPANDER","PARAMETER_ROWNUMBER",iRowNumber+"");
//	    		wInterfaceExpandWebElement.click();
//	    		waitForFeedbackMsgNotdisplayed(); 
//	    		wInterfaceExpandWebElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.EXPANDER","PARAMETER_ROWNUMBER",iRowNumber+"");
//	    		wInterfaceExpandWebElement.click();
	        	//Expand given interface
	        	expandInterface(sInterFaceName,sInterFaceDesc);
	        	//Click on Add firewall rule link
	    		WebObjectUtil.waitForElementPresent(Firewall.getNav_AddFireWallLink());
//	    		ipgCnt=Firewall.getNav_NumberOfPagesText().getText();
//				sTempArr=ipgCnt.split(" ");
//	    		int iNumberofPages=Integer.parseInt(sTempArr[1]);		
//	    		for(int pg=1; pg<=iNumberofPages;pg++)
//	    		{
	    		wRowWebELements=UserPermission.getNav_FirewallTable().findElements(By.tagName("table"));
	    		iFirewallRuleCnt=wRowWebELements.size();
	    		
	    		for(int iFrcntr=1;iFrcntr<=iFirewallRuleCnt;iFrcntr++)
	    		{
		    		//Expand firewall rule
	    			//int iRuleRowNumber=WebTableUtil.getRowByCellText(UserPermission.getNav_FirewallTable(), sFireWallRuleToExpand, 0,1);
		    		WebElement wRuleExpandWebElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.RULE.EXPANDER","PARAMETER_ROWNUMBER",iFrcntr+"");
		    		wRuleExpandWebElement.click();
		    		
		    		if(UserPermission.getNav_FeedBackArea().getText().contains(sFirewallHSWarnMsg) || !(UserPermission.getNav_FeedBackArea().getText().isEmpty()))
		    		{
		    			FrameworkUtil.updateCustomResultBasedOnStatus(false,UserPermission.getNav_FeedBackArea().getText() +" is displayed while expanding the firewall rule at row "+iFrcntr);
		    			continue;
		    		}
		    		else
		    		{
		    			//Click on Edit button after expanding rule and verify the rule available in application
//		    			wRuleExpandWebElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.RULE.EXPANDER","PARAMETER_ROWNUMBER",iFrcntr+"");
//			    		wRuleExpandWebElement.click();
		    			bVerifyDataSts=verifyFirewallRuledata(iFrcntr,"",sSrcType,sSrc,sSubnet,sDsetType,sDest,sDestSubnet,sSerType,sProtocol,sPort,sSts,sAction);
		    			if(bVerifyDataSts){
			    			editFirewallRuleRow=iFrcntr;
			    			break;
		    			}
		    			else
		    			{
		    				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "", "Search firewall rule in application for editing", "done", "Firewall rule not found in application" );
		    				continue;
		    			}
		    		}

	    		}
//        	}
//	    		if(editFirewallRuleRow<=0)
//	    		{
//	    			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "", "Search firewall rule in application for editing", "done", "Firewall rule not found in application" );
//	    		}
	    		//If firewall rule found then update the firewall rule in the application for givem field
	    		if(bVerifyDataSts)
	    		{
	    			WebElement wEditRuleWebElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.EDIT.BUTTON","PARAMETER_ROWNUMBER",editFirewallRuleRow+"");				
	    			wEditRuleWebElement.click();
	    			wEditRuleWebElement.click();
	    			boolean bfretSts=fFillEditFirewallRuleDetails(xEditSheet,row,editFirewallRuleRow,sFieldsNeedToChangeArray);
	    			if(bfretSts)
	    			{
	    				waitForFeedbackMsgNotdisplayed(); 
	    				if(UserPermission.getNav_FeedBackArea().getText().contains(sFirewallHSWarnMsg) || !(UserPermission.getNav_FeedBackArea().getText().isEmpty()))
			    		{
			    			FrameworkUtil.updateCustomResultBasedOnStatus(false,UserPermission.getNav_FeedBackArea().getText() +" is displayed while expanding the firewall rule at row "+editFirewallRuleRow);
//			    			continue;
			    			bNeedtoVerifyFlag=false;
			    		}
	    				else
	    					bNeedtoVerifyFlag=true;
	    				for(int i=0;i<sFieldsNeedToChangeArray.length;i++)
	    				{
	    					//String sEditSeqNum,sEditSrcType,sEditSrc,sEditSubnet,sEditDsetType,sEditDest,sEditDestSubnet,sEditSerType,sEditProtocol,sEditPort,sEditSts,sEditAction;
	    					//verifyFirewallRuledata(iFrcntr,sSeqNum,sSrcType,sSrc,sSubnet,sDsetType,sDest,sDestSubnet,sSerType,sProtocol,sPort,sSts,sAction);
	    					
	    					int ieditFieldCol;
	    					boolean bEdtFlag;
	    					String s;
	    					//String sEditedSeqNum,
	    					ieditFieldCol=getColumnNumber(xEditSheet,sFieldsNeedToChangeArray[i]);
	    					//get the the data based on field name
	    					switch(sFieldsNeedToChangeArray[i])
	    					{
	    						case "Sequence Number":
	    							sSeqNumber=getExcelCellData(xEditSheet,row,ieditFieldCol);
	    							break;
	    						case "Source Type":
	    							sSrcType=getExcelCellData(xEditSheet,row,ieditFieldCol);
	    							break;
	    						case "Source":
	    							sSrc=getExcelCellData(xEditSheet,row,ieditFieldCol);
	    							break;
	    						case "Source Subnet":
	    							sSubnet=getExcelCellData(xEditSheet,row,ieditFieldCol);
	    							break;						
	    						case "Destination Type":
	    							sDsetType=getExcelCellData(xEditSheet,row,ieditFieldCol);
	    							break;

	    						case "Destination":
	    							sDest=getExcelCellData(xEditSheet,row,ieditFieldCol);
	    							break;
	    						case "Destination Subnet":
	    							sDestSubnet=getExcelCellData(xEditSheet,row,ieditFieldCol);
	    							break;
	    						case "Service Type":
	    							sSerType=getExcelCellData(xEditSheet,row,ieditFieldCol);
	    							break;
	    						case "Protocol":
	    							sProtocol=getExcelCellData(xEditSheet,row,ieditFieldCol);
	    							break;
	    						case "Port":
	    							sPort=getExcelCellData(xEditSheet,row,ieditFieldCol);
	    							break;
	    						case "Status":
	    							sSts=getExcelCellData(xEditSheet,row,ieditFieldCol);
	    							break;
	    						case "Action":
	    							sAction=getExcelCellData(xEditSheet,row,ieditFieldCol);
	    							break;
	    					}
	    				
	    				}
	    			}
	    			//*******************//For verification get sFieldsNeedToChangeArray data first here. Then call function verifyFirewallRuledata
	    			//Verify the firewall rule after edit
	    			if(bNeedtoVerifyFlag){
	    				bVerifyDataSts=verifyFirewallRuledata(editFirewallRuleRow,sSeqNumber,sSrcType,sSrc,sSubnet,sDsetType,sDest,sDestSubnet,sSerType,sProtocol,sPort,sSts,sAction);
		    			if(bVerifyDataSts){
		    				FrameworkUtil.updateCustomResultBasedOnStatus(true,"Edited firewall rule found");
		    			}
		    			else
		    			{
		    				FrameworkUtil.updateCustomResultBasedOnStatus(true,"Edited firewall rule not found");
		    			}
	    			}
	    			else
	    			{
	    				FrameworkUtil.updateCustomResultBasedOnStatus(true,"Edited firewall rule not found");
	    			}
	    		}
        	}
        	else
        		continue;
        }

				LoginTestCase.nav_Logout();
		
		
		//LoginTestCase.nav_Logout();
	}
	
	/*==============================================================
	TestScript 		: DeleteFirewallRules
	Manual TestCase	: Verify given user able to delete firewall rules
	Description		: Verify given user able to delete firewall rules
	Author 			: Sukur Babu
	Creation Date 	: 21/03/2016
	Pre-Requisites	:
	Revision History:
	
	==============================================================*/
/*	@Test(priority=3)
	public void DeleteFirewallRules(){
		
		String sFileNamePath=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.DELETE.EXCEL.FILE.PATH");
		
		String sSheetName=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.DELETE.EXCEL.SHEET");

		String sEditFeedbackmsg1="Your request to delete Firewall Rule ";
		String sEditFeedbackmsg2=" is currently being processed and may take several minutes.";
		String sActEditFeedBackmsg,sExpEditFeedBackmsg;
		String[] sMsgArr;
		String sFeedbackSeqNumber;
		
		String sCellData = null;
		String[] sTemp,sFieldsNeedToChangeArray;
		int iSeqCol,iSTypeCol,iSourceCol,iSSubnetCol,iDTypeCol,iDestinationCol,iDSubnetCol,iSerTypeCol,iProtocolCol,iPortCol,iStsCol,iActionCol,iAddExeFlagCol,iAddExeStsCol,iEditExeFlagCol;
		String sSeqNumber,sSrcType,sSrc,sSubnet,sDsetType,sDest,sDestSubnet,sSerType,sProtocol,sPort,sSts,sAction,sAddExeFlag,sEditExeFlag,sFirewallFieldsNeedToChangeCol; 
		int editFirewallRuleRow=0,iFirewallFieldsNeedToChangeCol;
		boolean bfillDataSts,bVerifyDataSts = false;
		WebElement wDropDown;
		boolean bNeedtoVerifyFlag=false;
		List<WebElement> wRowWebELements;
		int iFirewallRuleCnt=0;
		//xSheet is for Add firewall rule
		XSSFSheet xSheet,xEditSheet;
		
		FileInputStream file;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, AddFirewallRuleTestCase.Firewall);
		PageFactory.initElements(driver, UserPermission);
		PageFactory.initElements(driver, CommonPF);
		
		
		
		FrameworkUtil.sTestCaseName = "Leftcourt2-DeleteFirewallRules";
		FrameworkUtil.sManualTestCaseName="Verify given user able to Delete firewall rules";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		String sFirewallHSWarnMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.HS.WARN.FEEDBACK.MSG");
		
		String sInterFaceName=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.INTERFACENAME");
		String sInterFaceDesc=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.INTERFACEDESCRIPTION");
		
		String sConFirmDeleteMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.DELETE.CONFIRM.MESSAGE");
		String sConFirmDeleteMsg1=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.DELETE.CONFIRM.MESSAGE1");
		LoginTestCase.LoginAsQaautoUser();
		EVDC_FirewallTestCase.NavigateToFirewallPage();
		
		xSheet=getExcelSheet(sFileNamePath,sSheetName);
		
        iAddExeFlagCol=getColumnNumber(xSheet,"Delete?");
		iSeqCol=getColumnNumber(xSheet,"Sequence Number");
		int iRowCnt=xSheet.getLastRowNum();
        
        for(int row=1;row<iRowCnt;row++)
        {
        	sAddExeFlag=getExcelCellData(xSheet,row,iAddExeFlagCol);
			if(sAddExeFlag.equalsIgnoreCase("y") )
        	{
	        	sSeqNumber=getExcelCellData(xSheet,row,iSeqCol);
				expandInterface(sInterFaceName,sInterFaceDesc);
				wRowWebELements=UserPermission.getNav_FirewallTable().findElements(By.tagName("table"));
	    		iFirewallRuleCnt=wRowWebELements.size();
	    		String [] sTmp;
	    		//String 
	    		for(int iFrcntr=1;iFrcntr<iFirewallRuleCnt;iFrcntr++)
	    		{
		    		//int iRuleRowNumber=WebTableUtil.getRowByCellText(UserPermission.getNav_FirewallTable(), sFireWallRuleToExpand, 0,1);
		    		WebElement wRuleExpandWebElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.RULE.EXPANDER","PARAMETER_ROWNUMBER",iFrcntr+"");
		    		wRuleExpandWebElement.click();
		    		
		    		if(UserPermission.getNav_FeedBackArea().getText().contains(sFirewallHSWarnMsg) || !(UserPermission.getNav_FeedBackArea().getText().isEmpty()))
		    		{
		    			FrameworkUtil.updateCustomResultBasedOnStatus(false,UserPermission.getNav_FeedBackArea().getText() +" is displayed while expanding the firewall rule at row "+iFrcntr);
		    			//continue;
		    		}
					else
					{
						WebElement wDelRuleWebElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.DELETE.BUTTON","PARAMETER_ROWNUMBER",iFrcntr+"");
						WebElement wSeqNumElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.SEQUENCENUMBER","PARAMETER_ROWNUMBER",iFrcntr+"");
						String sSeqNumberFromApp=wSeqNumElement.getAttribute("value");
						if(sSeqNumber.contains("."))
						{
							sTmp=sSeqNumber.split("\\.");
							sSeqNumber=sTmp[0];
						}
						if(sSeqNumberFromApp.equalsIgnoreCase(sSeqNumber))
						{
							wDelRuleWebElement.click();
							wDelRuleWebElement.click();
							if(CommonPF.getNav_CommonPopUpBox().getText().contains(sConFirmDeleteMsg))
							{
								FrameworkUtil.updateCustomResultBasedOnStatus(true, "Delete Confirmation message displayed after clicking Delete firewall rule button");
								WebObjectUtil.clickElement(CommonPF.getNav_CommonPopUpOkBtn());
								if(CommonPF.getNav_CommonPopUp().getText().contains(sConFirmDeleteMsg1)){
									FrameworkUtil.updateCustomResultBasedOnStatus(true, "Another Delete Confirmation message displayed after clicking ok in first delete confirmation popup window");
									WebObjectUtil.clickElement(CommonPF.getNav_CommonPopUpOkBtn());

									sActEditFeedBackmsg=CommonPF.getNav_UsrFeedBack().getText();
									sMsgArr=sActEditFeedBackmsg.split(" ");
									sFeedbackSeqNumber=sMsgArr[6];
									sExpEditFeedBackmsg=sEditFeedbackmsg1+sFeedbackSeqNumber+sEditFeedbackmsg2;
									if(sActEditFeedBackmsg.contains(sExpEditFeedBackmsg))
									{
										FrameworkUtil.updateCustomResultBasedOnStatus(true, "Firewall Rule deleted sucessfully for the sequence number and Feedback message "+sExpEditFeedBackmsg+" is displayed");
										waitForFeedbackMsgNotdisplayed(); 
										break;
										//Include logic, deleted firewall is not available here.
										
									}else{
									FrameworkUtil.updateCustomResultBasedOnStatus(true, "Issue in deleting firewall rule");
}
								}
							}
						}
					}
			}
		}		
        }
        
		}
	
	*/
	
	/*==============================================================
	TestScript 		: DeleteFirewallRules
	Manual TestCase	: Verify given user able to delete firewall rules
	Description		: Verify given user able to delete firewall rules
	Author 			: Sukur Babu
	Creation Date 	: 23/03/2016
	Pre-Requisites	:
	Revision History:
	
	==============================================================*/
	@Test(priority=3)
	public void DeleteFirewallRules(){
		
		
		String sActEditFeedBackmsg,sExpEditFeedBackmsg;
		String[] sMsgArr;
		String sFeedbackSeqNumber;
		
		List<WebElement> wRowWebELements;
		
		int iInterfaceCntinPg,iFirewallRuleCnt;
		String ipgCnt;
		String[] sTempArr;
	//Please get the text from properties file
		String sEditFeedbackmsg1=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.DELETEFIREWALL.FEEDBACK.MESSAGE1");
		String sEditFeedbackmsg2=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.DELETEFIREWALL.FEEDBACK.MESSAGE2");
		//Initiate web driver and page factory
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, AddFirewallRuleTestCase.Firewall);
		PageFactory.initElements(driver, UserPermission);
		PageFactory.initElements(driver, CommonPF);
		//update test case name and description in result file
		FrameworkUtil.sTestCaseName = "Leftcourt2-DeleteFirewallRules";
		FrameworkUtil.sManualTestCaseName="Verify given user able to Delete firewall rules";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		String sFirewallHSWarnMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.HS.WARN.FEEDBACK.MSG");
		//Read firewall data from properties file
		String sConFirmDeleteMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.DELETE.CONFIRM.MESSAGE");
		String sConFirmDeleteMsg1=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.DELETE.CONFIRM.MESSAGE1");
		String sInterFaceName=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.INTERFACENAME");
		String sInterFaceDesc=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.INTERFACEDESCRIPTION");
		//Login into Navigator using Qaauto user credentials
		LoginTestCase.LoginAsQaautoUser();
		//Navigate to firewall page
		EVDC_FirewallTestCase.NavigateToFirewallPage();
		//Get no of firewall pages
		iInterfaceCntinPg=WebTableUtil.getRowCount(Firewall.getNav_FirewallTable());
		//loop until interfaces pages
		for( int iintferRow=1;iintferRow<=iInterfaceCntinPg;iintferRow++)
		{
//			WebElement wInterfaceExpandWebElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.EXPANDER","PARAMETER_ROWNUMBER",iintferRow+"");
//			wInterfaceExpandWebElement.click();
//			WebObjectUtil.explicitWait(15);
//			waitForFeedbackMsgNotdisplayed();
//			wInterfaceExpandWebElement.click();
			//Expand the given interface
			expandInterface(sInterFaceName,sInterFaceDesc);
			ipgCnt=Firewall.getNav_NumberOfPagesText().getText();
			sTempArr=ipgCnt.split(" ");
    		int iNumberofPages=Integer.parseInt(sTempArr[1]);
    		//loop until firewall pages
    		for(int pg=1; pg<=iNumberofPages;pg++)
    		{
    			wRowWebELements=UserPermission.getNav_FirewallTable().findElements(By.tagName("table"));
				iFirewallRuleCnt=wRowWebELements.size();
//				for (WebElement wRow: wRowWebELements)
//				{
//					System.out.println("Firewall row text is: "+wRow.getText());
//				//	System.out.println("Firewall rule info is: "+wRow.getAttribute("value"));
//				}
	    		//for(int iFrcntr=1;iFrcntr<iFirewallRuleCnt;iFrcntr++)
				int iFrcntr;
				iFrcntr=1;
	    		for (WebElement wRow: wRowWebELements)
	    		{
	    			
	    			
		    		if(UserPermission.getNav_FeedBackArea().getText().contains(sFirewallHSWarnMsg) || !(UserPermission.getNav_FeedBackArea().getText().isEmpty()))
		    		{
		    			FrameworkUtil.updateCustomResultBasedOnStatus(false,UserPermission.getNav_FeedBackArea().getText() +" is displayed while expanding the firewall rule at row "+iFrcntr);
		    			waitForFeedbackMsgNotdisplayed(); 
//		    			wInterfaceExpandWebElement.click();
//		    			wRuleExpandWebElement.click();
		    			expandInterface(sInterFaceName,sInterFaceDesc);
		    		}
		    		else{
		    			System.out.println("Deleting Firewall Rule "+wRow.getText());
		    			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Deleting Firewall rule...", "done",wRow.getText() );
						//Expand firewall
		    			WebElement wRuleExpandWebElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.RULE.EXPANDER","PARAMETER_ROWNUMBER",iFrcntr+"");
			    		wRuleExpandWebElement.click();
			    		//Click on Delete link
						WebElement wDelRuleWebElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.DELETE.BUTTON","PARAMETER_ROWNUMBER",iFrcntr+"");
						wDelRuleWebElement.click();
						wDelRuleWebElement.click();
						WebObjectUtil.explicitWait(10);
					//Verify the delete confirmation pop up text
						if(CommonPF.getNav_CommonPopUpBox().getText().contains(sConFirmDeleteMsg))
						{
							FrameworkUtil.updateCustomResultBasedOnStatus(true, "Delete Confirmation message displayed after clicking Delete firewall rule button");
							WebObjectUtil.clickElement(CommonPF.getNav_CommonPopUpOkBtn());
							if(CommonPF.getNav_CommonPopUp().getText().contains(sConFirmDeleteMsg1)){
								FrameworkUtil.updateCustomResultBasedOnStatus(true, "Another Delete Confirmation message displayed after clicking ok in first delete confirmation popup window");
								WebObjectUtil.explicitWait(10);
								WebObjectUtil.clickElement(CommonPF.getNav_CommonPopUpOKButton());
	//				Verify the feedback message
								sActEditFeedBackmsg=CommonPF.getNav_UsrFeedBack().getText();
								sMsgArr=sActEditFeedBackmsg.split(" ");
								sFeedbackSeqNumber=sMsgArr[6];
								sExpEditFeedBackmsg=sEditFeedbackmsg1+sFeedbackSeqNumber+sEditFeedbackmsg2;
								if(sActEditFeedBackmsg.contains(sExpEditFeedBackmsg))
								{
									FrameworkUtil.updateCustomResultBasedOnStatus(true, "Firewall Rule deleted successfully for the sequence number and Feedback message "+sExpEditFeedBackmsg+" is displayed");
									waitForFeedbackMsgNotdisplayed(); 
									break;
									//Include logic, deleted firewall is not available here.
									
								}else{
								FrameworkUtil.updateCustomResultBasedOnStatus(true, "Issue in deleting firewall rule");
								}
							}
						}
		    		}
		    		iFrcntr++;
				}
			}
		}
}
	
	
	/*==============================================================
	TestScript 		: validateFirewallRUlewindowDropdownvalues
	Manual TestCase	: Verify all dropdown values displayed in firewall rule window page
	WCP_3031_TC_1.0_Firewall ->Add Firewall rule->Fields drop down values
	Description		: Verify all dropdown values displayed in firewall rule window page
	Author 			: Sukur Babu
	Creation Date 	: 21/03/2016
	Pre-Requisites	:
	Revision History:
	
	==============================================================*/
	/*	
	public void validateFirewallRUlewindowDropdownvalues()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, AddFirewallRuleTestCase.Firewall);
		PageFactory.initElements(driver, UserPermission);
		PageFactory.initElements(driver, CommonPF);
		
		
		
		FrameworkUtil.sTestCaseName = "Leftcourt2-WCP_3031_TC_1.0_Firewall ->Add Firewall rule->Fields drop down values";
		FrameworkUtil.sManualTestCaseName="Verify all dropdown values displayed in firewall rule window page";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		String sFirewallHSWarnMsg=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.HS.WARN.FEEDBACK.MSG");
		String sFirewallWindowName=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.WINDOW.NAME");
		String sInterFaceName=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.INTERFACENAME");
		String sInterFaceDesc=(String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.INTERFACEDESCRIPTION");
		
		LoginTestCase.LoginAsQaautoUser();
		EVDC_FirewallTestCase.NavigateToFirewallPage();
//		if(UserPermission.getNav_FeedBackArea().getText().contains(sFirewallHSWarnMsg) || !(UserPermission.getNav_FeedBackArea().getText().isEmpty()))
//		{
//			FrameworkUtil.updateCustomResultBasedOnStatus(false,UserPermission.getNav_FeedBackArea().getText() +" is displayed while expanding the firewall rule at row "+iFrcntr);
//			//continue;
//		}
//		else
//		{
			expandInterface(sInterFaceName,sInterFaceDesc);
			WebObjectUtil.clickElement(Firewall.getNav_AddFireWallLink());
			if(Firewall.getNav_AddFireWallWindow().getText().contains(sFirewallWindowName))
			{
				FrameworkUtil.updateCustomResultBasedOnStatus(true, "Add Firewall rule window displayed");
				
				WebObjectUtil.verifyElementPresent(Firewall.getNav_AddFirewallSeqNumEdit());
				
			}
			else
				FrameworkUtil.updateCustomResultBasedOnStatus(false, "Add Firewall rule window not displayed or Title does not match");
		
//		}
	}*/
	//@Test(priority=3)
/*	public void ExpandInterface(){
		int iintferRow,iintferCol;
		int iReqInterfaceRow = 0;
		boolean bInterfacenameFlag=false,bInterfaceDescFlag=false;
//		String sInterfaceText="Interface - 1",sInterfaceDescriptionText="Outside - outside",sTempText;
		String sInterfaceText="Interface - 2",sInterfaceDescriptionText="Internal - tstqaauto-VLANabc",sTempText;
//		String sInterfaceText="Global Implicit rule",sInterfaceDescriptionText="",sTempText;
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, AddFirewallRuleTestCase.Firewall);
		PageFactory.initElements(driver, UserPermission);
		PageFactory.initElements(driver, CommonPF);
		WebElement wIntFaceElement;
		LoginTestCase.LoginAsQaautoUser();
		EVDC_FirewallTestCase.NavigateToFirewallPage();
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
												
					if(sTempText.equalsIgnoreCase(sInterfaceText)){
						sTempText=WebTableUtil.getCellData(Firewall.getNav_FirewallTable(), iintferRow, iintferCol+1);
						if(!sTempText.isEmpty()){
						if(sTempText.equalsIgnoreCase(sInterfaceDescriptionText)){
							System.out.println("Interface " +sInterfaceText+" found at row "+iintferRow+" and column "+iintferCol);
							iReqInterfaceRow=iintferRow;
							break;
					}
					}
					}
				}
				else if(WebTableUtil.getColumnCount(Firewall.getNav_FirewallTable(), iintferRow)==1){
					sTempText=WebTableUtil.getCellData(Firewall.getNav_FirewallTable(), iintferRow, 1);
					if(sTempText.equalsIgnoreCase(sInterfaceText)){
						iReqInterfaceRow=iintferRow;
						break;
					}
				}
			}
			 
		}
		WebElement wInterfaceExpandWebElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.EXPANDER","PARAMETER_ROWNUMBER",iReqInterfaceRow+"");
		wInterfaceExpandWebElement.click();
		WebObjectUtil.explicitWait(15);

		LoginTestCase.nav_Logout();
			
	}*/
	/*====================================================================================================
	Method Name 	: expandInterface
	Description		: Expand interface based on values of interface name and description
	Ex:sInterfaceName=Interface - 1 and sInterfaceDescription=Internal - tstqaauto-VLANabc
	Author 			: Sukur Babu. B
	Creation Date 	: 21/03/2016
	Pre-Requisites	:
	Revision History:
	====================================================================================================*/
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
	/*====================================================================================================
	Method Name 	: fFillEditFirewallRuleDetails
	Description		: Used to enter firewall page details
	
	Author 			: Sukur Babu. B
	Creation Date 	: 21/03/2016
	Pre-Requisites	:
	Revision History:
	====================================================================================================*/
	public static boolean fFillEditFirewallRuleDetails(XSSFSheet xEditSheet,int row,int iFrcntr,String[] sFieldsNeedToChangeArray)
	{
	String sULElementXpath = (String) FrameworkUtil.dictDynamicPagePactory.get("CUSTOM.WEBLIST.XPATH");
	String sFeedBackMsg=(String) FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.SUCCESS.FEEDBACK.MSG");
//	String sEditFeedBackMsg=(String) FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.SUCCESS.FEEDBACK.MSG");
	String sEditSuccPopupMsg=(String) FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.SUCCESS.POPUP.MSG");
	String[] sTmp;
	boolean bSts;
	String sEditFeedbackmsg1="Your request to edit Firewall Rule ";
	String sEditFeedbackmsg2=" is currently being processed and may take several minutes.";
	String sActEditFeedBackmsg,sExpEditFeedBackmsg;
	String[] sMsgArr;
	String sFeedbackSeqNumber;
	boolean bExestsFlag=false;
			try{
				
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, Firewall);
			PageFactory.initElements(driver, UserPermission);
			PageFactory.initElements(driver, CommonPF);
			
			for(int i=0;i<sFieldsNeedToChangeArray.length;i++)
			    			{
			    				int ieditFieldCol;
			    				String sEditFieldData;
			    				ieditFieldCol=getColumnNumber(xEditSheet,sFieldsNeedToChangeArray[i]);
			    				sEditFieldData=getExcelCellData(xEditSheet,row,ieditFieldCol);
			    				boolean sEnterSrcFlag = false,sSelectSrcFlag=false,sSelectSrcSbnetFlag=false,sEnterDestFlag=false,sSelectDestFlag=false,sSelectDestSbnetFlag=false,sEnterPortFlag=false;
			    				WebElement wRuleWebElement,wDropDown;
			    				switch(sFieldsNeedToChangeArray[i])
			    				{
			    				case "Sequence Number":
			    				    if(sEditFieldData.contains("."))
			    				    {
			    				    	sTmp=sEditFieldData.split("\\.");
			    				    	sEditFieldData=sTmp[0];
			    				    }
			    					wRuleWebElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.SEQUENCENUMBER","PARAMETER_ROWNUMBER",iFrcntr+"");
			    					wRuleWebElement.clear();
			    					wRuleWebElement.sendKeys(sEditFieldData);
			    					break;
			    				case "Source Type":
			    					WebElement wSrcTypeDropdownArrow=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.SOURCETYPE.DROPDOWN","PARAMETER_ROWNUMBER",iFrcntr+"");
			    					wSrcTypeDropdownArrow.click();
			    					wDropDown=WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
			    					WebObjectUtil.selectCustomWebList(wDropDown, sEditFieldData);
			    					switch(sEditFieldData)
			    					{
			    					case "Any":
			    						sEnterSrcFlag=false;
			    						sSelectSrcFlag=false;
			    						sSelectSrcSbnetFlag=false;
			    						break;
			    					case "Host":
			    						sEnterSrcFlag=true;
			    						sSelectSrcFlag=false;
			    						sSelectSrcSbnetFlag=false;
			    						break;
			    					case "Network":
			    						sEnterSrcFlag=true;
			    						sSelectSrcFlag=false;
			    						sSelectSrcSbnetFlag=true;
			    						break;
			    					case "Object":
			    						sEnterSrcFlag=false;
			    						sSelectSrcFlag=true;
			    						sSelectSrcSbnetFlag=false;
			    						break;
			    					case "Group Object":
			    						sEnterSrcFlag=false;
			    						sSelectSrcFlag=true;
			    						sSelectSrcSbnetFlag=false;
			    						break;
			    					}
			    					break;
			    				case "Source":
			    					if(sEnterSrcFlag)
			    					{
			    					wRuleWebElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.SOURCE","PARAMETER_ROWNUMBER",iFrcntr+"");
			    					wRuleWebElement.sendKeys(sEditFieldData);
			    					}
			    					else if(sSelectSrcFlag)
			    					{
			    					WebElement wDSTypeDropdownArrow=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.SOURCE.DROPDOWN","PARAMETER_ROWNUMBER",iFrcntr+"");
			    					wDSTypeDropdownArrow.click();
			    					wDropDown=WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
			    					WebObjectUtil.selectCustomWebList(wDropDown, sEditFieldData);
			    					}		    					
			    					break;
			    				case "Source Subnet":
			    					if(sSelectSrcSbnetFlag)
			    					{
			    					WebElement wDSTypeDropdownArrow=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.SOURCEMASK.DROPDOWN","PARAMETER_ROWNUMBER",iFrcntr+"");
			    					wDSTypeDropdownArrow.click();
			    					wDropDown=WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
			    					WebObjectUtil.selectCustomWebList(wDropDown, sEditFieldData);
			    					}
			    					break;
								
								case "Destination Type":
									WebElement wDSTypeDropdownArrow=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.DESTINATIONTYPE.DROPDOWN","PARAMETER_ROWNUMBER",iFrcntr+"");
									wDSTypeDropdownArrow.click();
									wDropDown=WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
									WebObjectUtil.selectCustomWebList(wDropDown, sEditFieldData);
									switch(sEditFieldData)
			    					{
			    					case "Any":
			    						sEnterDestFlag=false;
			    						sSelectDestFlag=false;
			    						sSelectDestSbnetFlag=false;
			    						break;
			    					case "Host":
			    						sEnterDestFlag=true;
			    						sSelectDestFlag=false;
			    						sSelectDestSbnetFlag=false;
			    						break;
			    					case "Network":
			    						sEnterDestFlag=true;
			    						sSelectDestFlag=false;
			    						sSelectDestSbnetFlag=true;
			    						break;
			    					case "Object":
			    						sEnterDestFlag=false;
			    						sSelectDestFlag=true;
			    						sSelectDestSbnetFlag=false;
			    						break;
			    					case "Group Object":
			    						sEnterDestFlag=false;
			    						sSelectDestFlag=true;
			    						sSelectDestSbnetFlag=false;
			    						break;
			    					}
									break;
								case "Destination":
									if(sEnterDestFlag)
			    					{
			    					wRuleWebElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.DESTINATION","PARAMETER_ROWNUMBER",iFrcntr+"");
			    					wRuleWebElement.sendKeys(sEditFieldData);
			    					}
			    					else if(sSelectDestFlag)
			    					{
			    					wDSTypeDropdownArrow=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.DESTINATION.DROPDOWN","PARAMETER_ROWNUMBER",iFrcntr+"");
			    					wDSTypeDropdownArrow.click();
			    					wDropDown=WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
			    					WebObjectUtil.selectCustomWebList(wDropDown, sEditFieldData);
			    					}	
									break;
								case "Destination Subnet":
									if(sSelectDestSbnetFlag)
			    					{
			    					wDSTypeDropdownArrow=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.DESTINATIONMASK.DROPDOWN","PARAMETER_ROWNUMBER",iFrcntr+"");
			    					wDSTypeDropdownArrow.click();
			    					wDropDown=WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
			    					WebObjectUtil.selectCustomWebList(wDropDown, sEditFieldData);
			    					}
									break;
								case "Service Type":
									WebElement wSerTypeDropdownArrow=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.SERVICETYPE.DROPDOWN","PARAMETER_ROWNUMBER",iFrcntr+"");
									wSerTypeDropdownArrow.click();
									wDropDown=WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
									WebObjectUtil.selectCustomWebList(wDropDown, sEditFieldData);
									break;
								case "Protocol":
									WebElement wPrctlDropdownArrow=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.PROTOCOL.DROPDOWN","PARAMETER_ROWNUMBER",iFrcntr+"");
									wPrctlDropdownArrow.click();
									wDropDown=WebObjectUtil.getActiveElementasWebElement(sULElementXpath);
									WebObjectUtil.selectCustomWebList(wDropDown, sEditFieldData);
									switch(sEditFieldData)
			    					{
			    					case "icmp":
			    						sEnterPortFlag=false;
			    						break;
			    					case "tcp":
			    						sEnterPortFlag=true;
			    						break;
			    					case "udp":
			    						sEnterPortFlag=true;
			    						break;
			    					}
									break;
								case "Port":
									if(sEnterPortFlag)
									{
										WebElement wPortWebElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.PORT","PARAMETER_ROWNUMBER",iFrcntr+"");
										wPortWebElement.sendKeys(sEditFieldData);
									}
									break;
								case "Status":
									WebElement wStsWebElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.STATUS","PARAMETER_ROWNUMBER",iFrcntr+"");				
									if(sEditFieldData.equalsIgnoreCase("Active"))
									{
										if(wStsWebElement.getAttribute("alt").equalsIgnoreCase("Inactive"))
											wStsWebElement.click();;	
									}
									else if (sEditFieldData.equalsIgnoreCase("Inactive"))
									{
										if(wStsWebElement.getAttribute("alt").equalsIgnoreCase("Active"))
											wStsWebElement.click();
									}
									break;
								case "Action":
									WebElement wActionWebElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.ACTION","PARAMETER_ROWNUMBER",iFrcntr+"");				
									if(sEditFieldData.equalsIgnoreCase("Active"))
									{
										if(wActionWebElement.getAttribute("alt").equalsIgnoreCase("Inactive"))
											wActionWebElement.click();	
									}
									else if (sEditFieldData.equalsIgnoreCase("Inactive"))
									{
										if(wActionWebElement.getAttribute("alt").equalsIgnoreCase("Active"))
											wActionWebElement.click();
									}
									break;
			    				}
			    				
			    			}
			WebElement wSaveRuleWebElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.SAVEEDIT.BUTTON","PARAMETER_ROWNUMBER",iFrcntr+"");				
			wSaveRuleWebElement.click();
			WebObjectUtil.waitForElementPresent(CommonPF.getNav_CommonPopUpOkBtn());
			WebObjectUtil.clickElement(CommonPF.getNav_CommonPopUpOkBtn());
			WebObjectUtil.waitForElementPresent(CommonPF.getNav_CommonPopUp());
		
			if(CommonPF.getNav_CommonPopUp().getText().contains(sEditSuccPopupMsg))
			{
				FrameworkUtil.updateCustomResultBasedOnStatus(true, "Firewall Rule edited sucessfully for fields "+sFieldsNeedToChangeArray+" and pop up displayed with the message"+sEditSuccPopupMsg);
				bExestsFlag=true;
			}else
			{
				FrameworkUtil.updateCustomResultBasedOnStatus(false, "Issue in editing firewall rule for fields "+sFieldsNeedToChangeArray+" and pop up not displayed with the message"+sEditSuccPopupMsg);
				bExestsFlag=false;
			}
			WebObjectUtil.clickElement(CommonPF.getNav_CommonPopUpOKButton());
			
			
			sActEditFeedBackmsg=CommonPF.getNav_UsrFeedBack().getText();
			sMsgArr=sActEditFeedBackmsg.split(" ");
			sFeedbackSeqNumber=sMsgArr[6];
			sExpEditFeedBackmsg=sEditFeedbackmsg1+sFeedbackSeqNumber+sEditFeedbackmsg2;
			if(sActEditFeedBackmsg.contains(sExpEditFeedBackmsg))
			{
				FrameworkUtil.updateCustomResultBasedOnStatus(true, "Firewall Rule edited sucessfully for fields "+sFieldsNeedToChangeArray+" and Feedback message "+sExpEditFeedBackmsg+" is displayed");
				//return true;
				bExestsFlag=true;
			}
			else
			{
				FrameworkUtil.updateCustomResultBasedOnStatus(false, "Issue in creating a firwall rule");
				//return false;
				bExestsFlag=false;
			}
					if(bExestsFlag)
						return true;
					else
						return false;
			
			}

			catch(Exception e){
				return false;
			}

	}
	/*====================================================================================================
	Method Name 	: verifyFirewallRuledata
	Description		: Used to verify the firewall rule in available in the application
	
	Author 			: Sukur Babu. B
	Creation Date 	: 21/03/2016
	Pre-Requisites	:
	Revision History:
	====================================================================================================*/	
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
			// System.out.println("Port values before split is "+sPort);
			 sTemp=sPort.split("\\.");
			 //System.out.println("Arrary length after split is "+sTemp.length);
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
	
	/*====================================================================================================
	Method Name 	: addFirewallInfoWindow
	Description		: Used to add firewall rule
	
	Author 			: Sukur Babu. B
	Creation Date 	: 23/03/2016
	Pre-Requisites	:
	Revision History:
	====================================================================================================*/	
	public static boolean addFirewallInfoWindow(int iIterationCntr,String sSeqNum,String sSrcTypeItem,String sSource,String sSrcSubnet,String sDestType,String sDest,String sDestSubnet,String sSerType,String sProtocol,String sPort,String sSts,String sAction)
	{
		
		//please add comments
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
	/*====================================================================================================
	Method Name 	: validateWebListItems
	Description		: Used to averify all item sin the given drop down
	
	Author 			: Sukur Babu. B
	Creation Date 	: 23/03/2016
	Pre-Requisites	:
	Revision History:
	====================================================================================================*/	
	public static void validateWebListItems(WebElement webElement,String[] ListItems){
		String sItem = null;
		
		//please add comments
		
		
	    	try {
				if (WebObjectUtil.isElementPresent(webElement)){
					//WebObjectUtil.MouseHover(webElement);
					
					List<WebElement> webListItems = webElement.findElements(By.tagName("li"));
					for (WebElement wb: webListItems){
						
						sItem =wb.getText() ;
						
						for(int iarrcntr=0;iarrcntr<ListItems.length;iarrcntr++)
						{
							if (sItem.equalsIgnoreCase(ListItems[iarrcntr]))
							{
								FrameworkUtil.updateCustomResultBasedOnStatus(true, ListItems[iarrcntr]+" Item found in dropdown");
								break;
								
							}
															
							if(iarrcntr==(ListItems.length-1))
							{
								FrameworkUtil.updateCustomResultBasedOnStatus(false, ListItems[iarrcntr]+" Item not found in dropdown");
								break;
							}
							else
								continue;
							
						}
						
					}
				}else{
	    			LoggerUtil.log_type_info("Element not present/visible :" + FrameworkUtil.sElementName);
		    		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Element NOT present", "fail", "Element not present/visible ");
	    		}
				/*if (!flag){
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Select Item from Custom WebList", "fail", "Item Not found ");	
				}*/
			} catch (Exception e) {
				LoggerUtil.log_type_error("catch block:Could NOT access webelement " + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "selectCustomWebList", "warn", "catch block:Could NOT access webelement" +e.getMessage());
			}
	    	/*return flag;*/
	}
	/*====================================================================================================
	Method Name 	: getExcelSheet
	Description		: Used to get given excel sheeet from file
	
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
	/*====================================================================================================
	Method Name 	: waitForFeedbackMsgNotdisplayed
	Description		: Used to wait until feeback message displays
	
	Author 			: Sukur Babu. B
	Creation Date 	: 23/03/2016
	Pre-Requisites	:
	Revision History:
	====================================================================================================*/
	public static boolean waitForFeedbackMsgNotdisplayed()
	{
		//please add comments
		String sWaitFeedBackMsg;
		boolean bFuncStsFlag=false,bExec600Flag=false;
		Date d=new Date();
		//d=d.getDate();
		int dStrtsec,endSec = 0;
		//d.get
		sWaitFeedBackMsg=(String) FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.WAITING.FEEDBACK.MSG");
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, AddFirewallRuleTestCase.Firewall);
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
			XSSFCellStyle my_style = XWrkBook.createCellStyle();

			my_style.setFillPattern(XSSFCellStyle.FINE_DOTS );
			//my_style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
			my_style.setFillBackgroundColor(IndexedColors.RED.getIndex());
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






