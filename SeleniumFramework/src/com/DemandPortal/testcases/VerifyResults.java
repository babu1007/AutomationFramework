package com.DemandPortal.testcases;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.DemandPortal.pagefactory.AboutPageFactory;
import com.DemandPortal.pagefactory.verify;
import com.commonUtils.FrameworkUtil;
import com.commonUtils.LoggerUtil;
import com.commonUtils.WebDriverUtil;
import com.commonUtils.WebObjectUtil;
import com.commonUtils.WebTableUtil;


public class VerifyResults {

	
	//public VerifyResults v=new VerifyResults();
	
	public static verify verifyPF = new verify();
	/*==============================================================
	TestScript 		: 
	Manual TestCase	: 
	Description		: 
	Author 			: 
	Creation Date 	: 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	@Test
	public void verifyAllTestExecutedCompletely(){
		int iTestSummaryRowCnt,iTSROw, sLogoutRow=0;
		String sTstXpath,sTstTableXpath,sTstSts;
		String sFilepath="file:///D:/Selenium-Automation/Results/Navigator/debug/UP_Rerun20161117_232502.html";
		String sTestName,sStatus,sTestDesc;
		FrameworkUtil.sTestCaseName = "verifyAllTestExecutedCompletely";
		FrameworkUtil.sManualTestCaseName="Verify All tests are executed till end. None stoped in between";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		WebDriver driver= new FirefoxDriver();
		driver.get(sFilepath);
		
		PageFactory.initElements(driver, verifyPF);
		//Test Summary Table
		iTestSummaryRowCnt=WebTableUtil.getRowCount(verifyPF.getNav_TestSummaryTable());
		System.out.println("Total Number of scripts in Test Summary reuslts table  : "+iTestSummaryRowCnt);


		for(iTSROw=2;iTSROw<=iTestSummaryRowCnt;iTSROw++)
		{
			sTestName=WebTableUtil.getCellData(verifyPF.getNav_TestSummaryTable(), iTSROw, 1);
			sTstSts=WebTableUtil.getCellData(verifyPF.getNav_TestSummaryTable(), iTSROw, 3);
			System.out.println("Test Name   "+sTestName+"at row"+iTSROw);
			sTstXpath="//table[@id='TestSummary']//a[@href='#"+sTestName+"']";
			//WebElement wTstLink=WebObjectUtil.GetWebElement("xpath", sTstXpath, sTestName+" Link");
			WebElement wTstLink=driver.findElement(By.xpath(sTstXpath));
			wTstLink.click();
			sTstTableXpath="//table[@id='"+sTestName+"']";
			//WebElement wTstTable=WebObjectUtil.GetWebElement("xpath", sTstTableXpath, sTestName+" Table");
			WebElement wTstTable=driver.findElement(By.xpath(sTstTableXpath));
			try{
				if(sTstSts.equalsIgnoreCase("PASS"))
				{
					int iRc=WebTableUtil.getRowCount(wTstTable);
					String sText=WebTableUtil.getCellData(wTstTable, iRc, 2);
					if(sText.equalsIgnoreCase("Logout"))
						FrameworkUtil.updateCustomResultBasedOnStatus(true, sTestName+" Script is executed till end");
					else
						FrameworkUtil.updateCustomResultBasedOnStatus(false, sTestName+" Script is not executed till end. Reason is last row contains "+sText+" instead of Logout");
				}
				else
				{
					FrameworkUtil.updateCustomResultBasedOnStatus(false, sTestName+" Script itslef failed. So, not verified whether executed till end or not...");
				}
				}catch(Exception e)
			{
				FrameworkUtil.updateCustomResultBasedOnStatus(false, "Some issue with script execution"+e.getMessage());
			}
			
			}
			driver.navigate().back();
		}
	/*==============================================================
	TestScript 		: 
	Manual TestCase	: 
	Description		: 
	Author 			: 
	Creation Date 	: 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	@Test
	public void mergeAllInOne(){
		
		String sResFilesLoc,sResultFiles;
		String[] sResFiles;
		String sResFile;
		String stextToAppend="file:///";
		String sResultFileNamewithPath;
		String sPageSrc;
		
		
		int itestsExe=0,iTestPassed=0,iTestFailed=0;

		//String sTitleTag="<html><head><title>Navigator Test Result</title><style type=\"text/css\">table.moreDetail {display: none;}</style></head><body><h2>Navigator Test Result</h2>";
		String sTitleTag="<html><head><title>Navigator Test Result</title><style type=\"text/css\">table.moreDetail {display: none;}</style></head><body><h2>Navigator Test Result</h2><script>function ShowTable(tableID){var tableName=tableID;var tables=document.getElementsByTagName(\"table\");for(var i=0;i<tables.length;i++){if(tables[i].id== tableName){tables[i].style.display=\"block\";tables[i].style.visibility='visible';}else{tables[i].style.display=\"none\";}}document.getElementById('TestSummary').style.display='block';document.getElementById('TestSummary').style.visibility='visible';document.getElementById('TestSummary').style.display='block';document.getElementById('TestSummary').style.visibility='visible';document.getElementById('BuildDetailsTableId').style.display='block';document.getElementById('BuildDetailsTableId').style.visibility='visible';document.getElementById('TestStatistic').style.display='block';document.getElementById('TestStatistic').style.visibility='visible';document.getElementById('TimeStampTable').style.display='block';document.getElementById('TimeStampTable').style.visibility='visible';}</script>";
		String sTestModuleTable="<table id=\"ModuleTestStatistic\"  width=\"500\" border=1 style=\"background-color:C2F8F5\"><tr style=\"background-color:F58E2B\"><th>Test Module Name</th><th>Number Of Available Scripts</th><th>Number Scripts Passed</th><th>Number Scripts Failed</th></tr><tr><td>Accounts</td><td>AccountsTOTALSCRIPTS</td><td>AccountsPASSSCRIPTS</td><td>AccountsFAILEDSCRIPTS</td><tr><td>Admin</td><td>AdminSCRIPTS</td><td>AdminPASSSCRIPTS</td><td>AdminFAILEDSCRIPTS</td><tr><td>Announcement</td><td>AnnouncementTOTALSCRIPTS</td><td>AnnouncementPASSSCRIPTS</td><td>AnnouncementFAILEDSCRIPTS</td><tr><td>Catalog</td><td>CatalogTOTALSCRIPTS</td><td>CatalogPASSSCRIPTS</td><td>CatalogFAILEDSCRIPTS</td><tr><td>DNS</td><td>DNSTOTALSCRIPTS</td><td>DNSPASSSCRIPTS</td><td>DNSFAILEDSCRIPTS</td><tr><td>Document</td><td>DocumentTOTALSCRIPTS</td><td>DocumentPASSSCRIPTS</td><td>DocumentFAILEDSCRIPTS</td><tr><td>EVDC Firewall</td><td>EVDCFirewallTOTALSCRIPTS</td><td>EVDCFirewallPASSSCRIPTS</td><td>EVDCFirewallFAILEDSCRIPTS</td><tr><td>EVDC Overview</td><td>EVDCOverviewTOTALSCRIPTS</td><td>EVDCOverviewPASSSCRIPTS</td><td>EVDCOverviewFAILEDSCRIPTS</td><tr><td>EVDC StorageProfile</td><td>EVDCStorageProfileTOTALSCRIPTS</td><td>EVDCStorageProfilePASSSCRIPTS</td><td>EVDCStorageProfileFAILEDSCRIPTS</td></table>";
		String sTestStasticTable="<table id=\"TestStatistic\"  width=\"500\" border=1 style=\"background-color:C2F8F5\"><tr style=\"background-color:F58E2B\"><th>Test Statistic</th><th>Count</th></tr><tr><td>Test Executed</th><td>TESTCASECOUNT</td></tr><tr><td>Test Passed</th><td>TESTCASEPASSED</td></tr><tr><td>Test Failed</th><td>TESTCASEFAILED</td></tr><tr><td>Not Completed/Executed</th><td>TESTNOTCOMPLETED_EXECUTED</td></tr></table>";
		
		String sSummaryTableStartTag="<table id=\"TestSummary\" width=\"800\" border=\"1\" style=\"background-color:F0ECE3\">";
		//String sSummaryTableStartTag="";
		String sSummaryTableEndTag="</table>";
		
		String sSummaryTableFirstRowTag="<tr style=\"background-color:F58E2B\"><th>Test ScriptName</th><th>Manual Testcase Name</th><th>Result</th></tr>";
		
		String sSummaryTablePassRowTag="<tr style=\"background:76ED98\">";
		String sSummaryTableFailRowTag="<tr style=\"background:F85D5F\">";	
		
		String sSummaryTags = "";
		
		String sTestStartrTag="<td><div><a ";
		String sTestName;
		String sHref;
		String sOnlclick;
		String sTestEndTags="</div></td>";
		
		int iRc;
		
		String sbodyEndTag="</body>";
		String sHtmlEndTag="</html>";
		
		String sMTestName,SHrefStr,sOnclick,sOnclickStr,sSts,sAnchorEndTag,sStrtTDtag,sEndTDtag,sTestTag;
		
		FrameworkUtil.sTestCaseName = "mergeAllInOne";
		FrameworkUtil.sManualTestCaseName="Prepare a result file";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		//sResFilesLoc=(String)FrameworkUtil.dictPropertyData.get("RESULT.LOCATION");
		//sResultFiles=(String)FrameworkUtil.dictPropertyData.get("RESULT.FILE.NAMES");
		
		sResFilesLoc="C:\\Users\\Sbabu\\Desktop\\Sukur\\New folder";
		sResultFiles="Accounts.html@@Admin.html@@Announcement.html@@Catalog.html@@DNS.html@@Document.html@@EVDC Firewall.html@@EVDC Overview.html@@EVDC StorageProfile.html";
		
		
		sResFiles=sResultFiles.split("@@");
	
		try{
		File f = new File(sResFilesLoc);
		File f1 = new File(sResFilesLoc+"\\abc.html");
		if(!f1.exists()) {
            f1.createNewFile();
		}
         else
         {
        	 f1.delete();
         	 f1.createNewFile();
         
         }
         
        // FileWriter fileWritter = new FileWriter(f1.getName(),true);
         //BufferedWriter bw = new BufferedWriter(fileWritter);
        
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(f1.getAbsoluteFile(), true));
		PrintWriter pw = new PrintWriter(bw);
		WebDriver driver= new FirefoxDriver();
		
		int iOpenNavNum,iLogOutNum;
		WebElement wSummaryTable;
		for(String sfile:sResFiles)
		{
			sResultFileNamewithPath=stextToAppend+sResFilesLoc+"//"+sfile;
			driver.get(sResultFileNamewithPath);
			
			sPageSrc=driver.getPageSource();
			iOpenNavNum=sPageSrc.indexOf("table id=\"TestSummary\"");
			iLogOutNum=sPageSrc.indexOf("Logout Navigator");
			WebElement wTstStasticTable=driver.findElement(By.id("TestStatistic"));
			
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			//Making Module table ready
			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			if(sfile.contains("Accounts"))
			{
				
								
				sTestModuleTable=sTestModuleTable.replace("AccountsTOTALSCRIPTS", WebTableUtil.getCellData(wTstStasticTable, 2, 2));
				sTestModuleTable=sTestModuleTable.replace("AccountsPASSSCRIPTS", WebTableUtil.getCellData(wTstStasticTable, 3, 2));
				sTestModuleTable=sTestModuleTable.replace("AccountsFAILEDSCRIPTS", WebTableUtil.getCellData(wTstStasticTable, 4, 2));
				
				sSummaryTags=sSummaryTags+sSummaryTableStartTag+sSummaryTableFirstRowTag;
				
				wSummaryTable=driver.findElement(By.id("TestSummary"));
				iRc=WebTableUtil.getRowCount(wSummaryTable);
				for(int r=2;r<=iRc;r++)
				{
					/*String stable="<table id=";
					String sTableString="width=\"800\" border=\"1\" style=\"background-color:F0ECE3\">";
							
					sSummaryTableStartTag=stable+(char)34+"Accounts"+(char)34+sTableString;*/
					sTestName=WebTableUtil.getCellData(wSummaryTable, r, 1);
					sMTestName=WebTableUtil.getCellData(wSummaryTable, r, 2);
					sHref="href=";
					SHrefStr="#"+sTestName+"";
					SHrefStr=(char)34+SHrefStr+(char)34;
					sOnclick="onclick=";
					sOnclickStr=sOnclick+(char)34+"ShowTable('"+sTestName+"')"+(char)34+">";
					sSts=WebTableUtil.getCellData(wSummaryTable, r, 3);
					sAnchorEndTag="</a>";
					sStrtTDtag="<td>";
					sEndTDtag="</td>";
					if(sSts.equalsIgnoreCase("PASS"))
					{
						 sTestTag=sTestStartrTag+sHref+SHrefStr+sOnclickStr+sTestName+sAnchorEndTag+sTestEndTags+sStrtTDtag+sMTestName+sEndTDtag+sStrtTDtag+sSts+sEndTDtag;
						 
						 
						 sSummaryTags=sSummaryTags+sSummaryTablePassRowTag+sTestTag;
				//	<td><div><a href="#OpenNavigator" onclick="ShowTable('OpenNavigator');"> OpenNavigator </a></div></td>
						
					}
					else
					{
						sTestTag=sTestStartrTag+sHref+SHrefStr+sOnclickStr+sTestName+sAnchorEndTag+sTestEndTags+sStrtTDtag+sMTestName+sEndTDtag+sStrtTDtag+sSts+sEndTDtag;
						sSummaryTags=sSummaryTags+sSummaryTableFailRowTag;
					}
				}
			
			}
			else if(sfile.contains("Admin"))
			{
				sTestModuleTable=sTestModuleTable.replace("AdminSCRIPTS", WebTableUtil.getCellData(wTstStasticTable, 2, 2));
				sTestModuleTable=sTestModuleTable.replaceAll("AdminPASSSCRIPTS", WebTableUtil.getCellData(wTstStasticTable, 3, 2));
				sTestModuleTable=sTestModuleTable.replaceAll("AdminFAILEDSCRIPTS", WebTableUtil.getCellData(wTstStasticTable, 4, 2));
				sSummaryTags=sSummaryTags+sSummaryTableStartTag+sSummaryTableFirstRowTag;
				
				wSummaryTable=driver.findElement(By.id("TestSummary"));
				iRc=WebTableUtil.getRowCount(wSummaryTable);
				for(int r=2;r<=iRc;r++)
				{
					//String stable="<table id=";
					//String sTableString="width=\"800\" border=\"1\" style=\"background-color:F0ECE3\">";
							
					//sSummaryTableStartTag=stable+(char)34+"Admin"+(char)34+sTableString;
					sTestName=WebTableUtil.getCellData(wSummaryTable, r, 1);
					sMTestName=WebTableUtil.getCellData(wSummaryTable, r, 2);
					sHref="href=";
					SHrefStr="#"+sTestName+"";
					SHrefStr=(char)34+SHrefStr+(char)34;
					sOnclick="onclick=";
					sOnclickStr=sOnclick+(char)34+"ShowTable('"+sTestName+"')"+(char)34+">";
					sSts=WebTableUtil.getCellData(wSummaryTable, r, 3);
					sAnchorEndTag="</a>";
					sStrtTDtag="<td>";
					sEndTDtag="</td>";
					if(sSts.equalsIgnoreCase("PASS"))
					{
						 sTestTag=sTestStartrTag+sHref+SHrefStr+sOnclickStr+sTestName+sAnchorEndTag+sTestEndTags+sStrtTDtag+sMTestName+sEndTDtag+sStrtTDtag+sSts+sEndTDtag;
						 
						 sSummaryTags=sSummaryTags+sSummaryTablePassRowTag+sTestTag;
						// sSummaryTags=sSummaryTags+sSummaryTableStartTag+sSummaryTablePassRowTag+sTestTag;
				//	<td><div><a href="#OpenNavigator" onclick="ShowTable('OpenNavigator');"> OpenNavigator </a></div></td>
						
					}
					else
					{
						sTestTag=sTestStartrTag+sHref+SHrefStr+sOnclickStr+sTestName+sAnchorEndTag+sTestEndTags+sStrtTDtag+sMTestName+sEndTDtag+sStrtTDtag+sSts+sEndTDtag;
						sSummaryTags=sSummaryTags+sSummaryTableFailRowTag;
					}
				}
			}
			else if(sfile.contains("Announcement"))
			{
				sTestModuleTable=sTestModuleTable.replace("AnnouncementTOTALSCRIPTS", WebTableUtil.getCellData(wTstStasticTable, 2, 2));
				sTestModuleTable=sTestModuleTable.replace("AnnouncementPASSSCRIPTS", WebTableUtil.getCellData(wTstStasticTable, 3, 2));
				sTestModuleTable=sTestModuleTable.replace("AnnouncementFAILEDSCRIPTS", WebTableUtil.getCellData(wTstStasticTable, 4, 2));
				sSummaryTags=sSummaryTags+sSummaryTableStartTag+sSummaryTableFirstRowTag;
				
				wSummaryTable=driver.findElement(By.id("TestSummary"));
				iRc=WebTableUtil.getRowCount(wSummaryTable);
				for(int r=2;r<=iRc;r++)
				{
					//String stable="<table id=";
					///String sTableString="width=\"800\" border=\"1\" style=\"background-color:F0ECE3\">";
							
					//sSummaryTableStartTag=stable+(char)34+"Announcement"+(char)34+sTableString;
					sTestName=WebTableUtil.getCellData(wSummaryTable, r, 1);
					sMTestName=WebTableUtil.getCellData(wSummaryTable, r, 2);
					sHref="href=";
					SHrefStr="#"+sTestName+"";
					SHrefStr=(char)34+SHrefStr+(char)34;
					sOnclick="onclick=";
					sOnclickStr=sOnclick+(char)34+"ShowTable('"+sTestName+"')"+(char)34+">";
					sSts=WebTableUtil.getCellData(wSummaryTable, r, 3);
					sAnchorEndTag="</a>";
					sStrtTDtag="<td>";
					sEndTDtag="</td>";
					if(sSts.equalsIgnoreCase("PASS"))
					{
						 sTestTag=sTestStartrTag+sHref+SHrefStr+sOnclickStr+sTestName+sAnchorEndTag+sTestEndTags+sStrtTDtag+sMTestName+sEndTDtag+sStrtTDtag+sSts+sEndTDtag;
						 
						 
						 sSummaryTags=sSummaryTags+sSummaryTablePassRowTag+sTestTag;
				//	<td><div><a href="#OpenNavigator" onclick="ShowTable('OpenNavigator');"> OpenNavigator </a></div></td>
						
					}
					else
					{
						sTestTag=sTestStartrTag+sHref+SHrefStr+sOnclickStr+sTestName+sAnchorEndTag+sTestEndTags+sStrtTDtag+sMTestName+sEndTDtag+sStrtTDtag+sSts+sEndTDtag;
						sSummaryTags=sSummaryTags+sSummaryTableFailRowTag;
					}
				}
			}
			else if(sfile.contains("Catalog"))
			{
				sTestModuleTable=sTestModuleTable.replace("CatalogTOTALSCRIPTS", WebTableUtil.getCellData(wTstStasticTable, 2, 2));
				sTestModuleTable=sTestModuleTable.replace("CatalogPASSSCRIPTS", WebTableUtil.getCellData(wTstStasticTable, 3, 2));
				sTestModuleTable=sTestModuleTable.replace("CatalogFAILEDSCRIPTS", WebTableUtil.getCellData(wTstStasticTable, 4, 2));
				sSummaryTags=sSummaryTags+sSummaryTableStartTag+sSummaryTableFirstRowTag;
				
				wSummaryTable=driver.findElement(By.id("TestSummary"));
				iRc=WebTableUtil.getRowCount(wSummaryTable);
				for(int r=2;r<=iRc;r++)
				{
					//String stable="<table id=";
					//String sTableString="width=\"800\" border=\"1\" style=\"background-color:F0ECE3\">";
							
					//sSummaryTableStartTag=stable+(char)34+"Catalog"+(char)34+sTableString;
					sTestName=WebTableUtil.getCellData(wSummaryTable, r, 1);
					sMTestName=WebTableUtil.getCellData(wSummaryTable, r, 2);
					sHref="href=";
					SHrefStr="#"+sTestName+"";
					SHrefStr=(char)34+SHrefStr+(char)34;
					sOnclick="onclick=";
					sOnclickStr=sOnclick+(char)34+"ShowTable('"+sTestName+"')"+(char)34+">";
					sSts=WebTableUtil.getCellData(wSummaryTable, r, 3);
					sAnchorEndTag="</a>";
					sStrtTDtag="<td>";
					sEndTDtag="</td>";
					if(sSts.equalsIgnoreCase("PASS"))
					{
						 sTestTag=sTestStartrTag+sHref+SHrefStr+sOnclickStr+sTestName+sAnchorEndTag+sTestEndTags+sStrtTDtag+sMTestName+sEndTDtag+sStrtTDtag+sSts+sEndTDtag;
						 
						 
						 sSummaryTags=sSummaryTags+sSummaryTablePassRowTag+sTestTag;
				//	<td><div><a href="#OpenNavigator" onclick="ShowTable('OpenNavigator');"> OpenNavigator </a></div></td>
						
					}
					else
					{
						sTestTag=sTestStartrTag+sHref+SHrefStr+sOnclickStr+sTestName+sAnchorEndTag+sTestEndTags+sStrtTDtag+sMTestName+sEndTDtag+sStrtTDtag+sSts+sEndTDtag;
						sSummaryTags=sSummaryTags+sSummaryTableFailRowTag;
					}
				}
			}
			else if(sfile.contains("DNS"))
			{
				sTestModuleTable=sTestModuleTable.replace("DNSTOTALSCRIPTS", WebTableUtil.getCellData(wTstStasticTable, 2, 2));
				sTestModuleTable=sTestModuleTable.replace("DNSPASSSCRIPTS", WebTableUtil.getCellData(wTstStasticTable, 3, 2));
				sTestModuleTable=sTestModuleTable.replace("DNSFAILEDSCRIPTS", WebTableUtil.getCellData(wTstStasticTable, 4, 2));
				wSummaryTable=driver.findElement(By.id("TestSummary"));
				iRc=WebTableUtil.getRowCount(wSummaryTable);
				for(int r=2;r<=iRc;r++)
				{
					//String stable="<table id=";
					//String sTableString="width=\"800\" border=\"1\" style=\"background-color:F0ECE3\">";
							
					//sSummaryTableStartTag=stable+(char)34+"DNS"+(char)34+sTableString;
					sTestName=WebTableUtil.getCellData(wSummaryTable, r, 1);
					sMTestName=WebTableUtil.getCellData(wSummaryTable, r, 2);
					sHref="href=";
					SHrefStr="#"+sTestName+"";
					SHrefStr=(char)34+SHrefStr+(char)34;
					sOnclick="onclick=";
					sOnclickStr=sOnclick+(char)34+"ShowTable('"+sTestName+"')"+(char)34+">";
					sSts=WebTableUtil.getCellData(wSummaryTable, r, 3);
					sAnchorEndTag="</a>";
					sStrtTDtag="<td>";
					sEndTDtag="</td>";
					if(sSts.equalsIgnoreCase("PASS"))
					{
						 sTestTag=sTestStartrTag+sHref+SHrefStr+sOnclickStr+sTestName+sAnchorEndTag+sTestEndTags+sStrtTDtag+sMTestName+sEndTDtag+sStrtTDtag+sSts+sEndTDtag;
						 
						 
						 sSummaryTags=sSummaryTags+sSummaryTablePassRowTag+sTestTag;
				//	<td><div><a href="#OpenNavigator" onclick="ShowTable('OpenNavigator');"> OpenNavigator </a></div></td>
						
					}
					else
					{
						sTestTag=sTestStartrTag+sHref+SHrefStr+sOnclickStr+sTestName+sAnchorEndTag+sTestEndTags+sStrtTDtag+sMTestName+sEndTDtag+sStrtTDtag+sSts+sEndTDtag;
						sSummaryTags=sSummaryTags+sSummaryTableFailRowTag;
					}
				}
			}
			else if(sfile.contains("Document"))
			{
				sTestModuleTable=sTestModuleTable.replace("DocumentTOTALSCRIPTS", WebTableUtil.getCellData(wTstStasticTable, 2, 2));
				sTestModuleTable=sTestModuleTable.replace("DocumentPASSSCRIPTS", WebTableUtil.getCellData(wTstStasticTable, 3, 2));
				sTestModuleTable=sTestModuleTable.replace("DocumentFAILEDSCRIPTS", WebTableUtil.getCellData(wTstStasticTable, 4, 2));
				sSummaryTags=sSummaryTags+sSummaryTableStartTag+sSummaryTableFirstRowTag;
				
				wSummaryTable=driver.findElement(By.id("TestSummary"));
				iRc=WebTableUtil.getRowCount(wSummaryTable);
				for(int r=2;r<=iRc;r++)
				{
					//String stable="<table id=";
					//String sTableString="width=\"800\" border=\"1\" style=\"background-color:F0ECE3\">";
							
					//sSummaryTableStartTag=stable+(char)34+"Document"+(char)34+sTableString;
					sTestName=WebTableUtil.getCellData(wSummaryTable, r, 1);
					sMTestName=WebTableUtil.getCellData(wSummaryTable, r, 2);
					sHref="href=";
					SHrefStr="#"+sTestName+"";
					SHrefStr=(char)34+SHrefStr+(char)34;
					sOnclick="onclick=";
					sOnclickStr=sOnclick+(char)34+"ShowTable('"+sTestName+"')"+(char)34+">";
					sSts=WebTableUtil.getCellData(wSummaryTable, r, 3);
					sAnchorEndTag="</a>";
					sStrtTDtag="<td>";
					sEndTDtag="</td>";
					if(sSts.equalsIgnoreCase("PASS"))
					{
						 sTestTag=sTestStartrTag+sHref+SHrefStr+sOnclickStr+sTestName+sAnchorEndTag+sTestEndTags+sStrtTDtag+sMTestName+sEndTDtag+sStrtTDtag+sSts+sEndTDtag;
						 
						 
						 sSummaryTags=sSummaryTags+sSummaryTablePassRowTag+sTestTag;
				//	<td><div><a href="#OpenNavigator" onclick="ShowTable('OpenNavigator');"> OpenNavigator </a></div></td>
						
					}
					else
					{
						sTestTag=sTestStartrTag+sHref+SHrefStr+sOnclickStr+sTestName+sAnchorEndTag+sTestEndTags+sStrtTDtag+sMTestName+sEndTDtag+sStrtTDtag+sSts+sEndTDtag;
						sSummaryTags=sSummaryTags+sSummaryTableFailRowTag;
					}
				}
			}
			else if(sfile.contains("EVDC Firewall"))
			{
				sTestModuleTable=sTestModuleTable.replace("EVDCFirewallTOTALSCRIPTS", WebTableUtil.getCellData(wTstStasticTable, 2, 2));
				sTestModuleTable=sTestModuleTable.replace("EVDCFirewallPASSSCRIPTS", WebTableUtil.getCellData(wTstStasticTable, 3, 2));
				sTestModuleTable=sTestModuleTable.replace("EVDCFirewallFAILEDSCRIPTS", WebTableUtil.getCellData(wTstStasticTable, 4, 2));
				sSummaryTags=sSummaryTags+sSummaryTableStartTag+sSummaryTableFirstRowTag;
				
				wSummaryTable=driver.findElement(By.id("TestSummary"));
				iRc=WebTableUtil.getRowCount(wSummaryTable);
				for(int r=2;r<=iRc;r++)
				{
					//String stable="<table id=";
					//String sTableString="width=\"800\" border=\"1\" style=\"background-color:F0ECE3\">";
							
					//sSummaryTableStartTag=stable+(char)34+"EVDCFirewall"+(char)34+sTableString;
					sTestName=WebTableUtil.getCellData(wSummaryTable, r, 1);
					sMTestName=WebTableUtil.getCellData(wSummaryTable, r, 2);
					sHref="href=";
					SHrefStr="#"+sTestName+"";
					SHrefStr=(char)34+SHrefStr+(char)34;
					sOnclick="onclick=";
					sOnclickStr=sOnclick+(char)34+"ShowTable('"+sTestName+"')"+(char)34+">";
					sSts=WebTableUtil.getCellData(wSummaryTable, r, 3);
					sAnchorEndTag="</a>";
					sStrtTDtag="<td>";
					sEndTDtag="</td>";
					if(sSts.equalsIgnoreCase("PASS"))
					{
						 sTestTag=sTestStartrTag+sHref+SHrefStr+sOnclickStr+sTestName+sAnchorEndTag+sTestEndTags+sStrtTDtag+sMTestName+sEndTDtag+sStrtTDtag+sSts+sEndTDtag;
						 
						 
						 sSummaryTags=sSummaryTags+sSummaryTablePassRowTag+sTestTag;
				//	<td><div><a href="#OpenNavigator" onclick="ShowTable('OpenNavigator');"> OpenNavigator </a></div></td>
						
					}
					else
					{
						sTestTag=sTestStartrTag+sHref+SHrefStr+sOnclickStr+sTestName+sAnchorEndTag+sTestEndTags+sStrtTDtag+sMTestName+sEndTDtag+sStrtTDtag+sSts+sEndTDtag;
						sSummaryTags=sSummaryTags+sSummaryTableFailRowTag;
					}
				}
			}
			else if(sfile.contains("EVDC Overview"))
			{
				sTestModuleTable=sTestModuleTable.replace("EVDCOverviewTOTALSCRIPTS", WebTableUtil.getCellData(wTstStasticTable, 2, 2));
				sTestModuleTable=sTestModuleTable.replace("EVDCOverviewPASSSCRIPTS", WebTableUtil.getCellData(wTstStasticTable, 3, 2));
				sTestModuleTable=sTestModuleTable.replace("EVDCOverviewFAILEDSCRIPTS", WebTableUtil.getCellData(wTstStasticTable, 4, 2));
				sSummaryTags=sSummaryTags+sSummaryTableStartTag+sSummaryTableFirstRowTag;
				
				wSummaryTable=driver.findElement(By.id("TestSummary"));
				iRc=WebTableUtil.getRowCount(wSummaryTable);
				for(int r=2;r<=iRc;r++)
				{
					//String stable="<table id=";
					//String sTableString="width=\"800\" border=\"1\" style=\"background-color:F0ECE3\">";
							
					//sSummaryTableStartTag=stable+(char)34+"EVDCOverView"+(char)34+sTableString;
					sTestName=WebTableUtil.getCellData(wSummaryTable, r, 1);
					sMTestName=WebTableUtil.getCellData(wSummaryTable, r, 2);
					sHref="href=";
					SHrefStr="#"+sTestName+"";
					SHrefStr=(char)34+SHrefStr+(char)34;
					sOnclick="onclick=";
					sOnclickStr=sOnclick+(char)34+"ShowTable('"+sTestName+"')"+(char)34+">";
					sSts=WebTableUtil.getCellData(wSummaryTable, r, 3);
					sAnchorEndTag="</a>";
					sStrtTDtag="<td>";
					sEndTDtag="</td>";
					if(sSts.equalsIgnoreCase("PASS"))
					{
						 sTestTag=sTestStartrTag+sHref+SHrefStr+sOnclickStr+sTestName+sAnchorEndTag+sTestEndTags+sStrtTDtag+sMTestName+sEndTDtag+sStrtTDtag+sSts+sEndTDtag;
						 
						 
						 sSummaryTags=sSummaryTags+sSummaryTablePassRowTag+sTestTag;
				//	<td><div><a href="#OpenNavigator" onclick="ShowTable('OpenNavigator');"> OpenNavigator </a></div></td>
						
					}
					else
					{
						sTestTag=sTestStartrTag+sHref+SHrefStr+sOnclickStr+sTestName+sAnchorEndTag+sTestEndTags+sStrtTDtag+sMTestName+sEndTDtag+sStrtTDtag+sSts+sEndTDtag;
						sSummaryTags=sSummaryTags+sSummaryTableFailRowTag;
					}
				}
			}
			else if(sfile.contains("EVDC StorageProfile"))
			{
				sTestModuleTable=sTestModuleTable.replace("EVDCStorageProfileTOTALSCRIPTS", WebTableUtil.getCellData(wTstStasticTable, 2, 2));
				sTestModuleTable=sTestModuleTable.replace("EVDCStorageProfilePASSSCRIPTS", WebTableUtil.getCellData(wTstStasticTable, 3, 2));
				sTestModuleTable=sTestModuleTable.replace("EVDCStorageProfileFAILEDSCRIPTS", WebTableUtil.getCellData(wTstStasticTable, 4, 2));
				sSummaryTags=sSummaryTags+sSummaryTableStartTag+sSummaryTableFirstRowTag;
				
				wSummaryTable=driver.findElement(By.id("TestSummary"));
				iRc=WebTableUtil.getRowCount(wSummaryTable);
				for(int r=2;r<=iRc;r++)
				{
					//String stable="<table id=";
					//String sTableString="width=\"800\" border=\"1\" style=\"background-color:F0ECE3\">";
							
					//sSummaryTableStartTag=stable+(char)34+"EVDCStorageProfile"+(char)34+sTableString;
					sTestName=WebTableUtil.getCellData(wSummaryTable, r, 1);
					sMTestName=WebTableUtil.getCellData(wSummaryTable, r, 2);
					sHref="href=";
					SHrefStr="#"+sTestName+"";
					SHrefStr=(char)34+SHrefStr+(char)34;
					sOnclick="onclick=";
					sOnclickStr=sOnclick+(char)34+"ShowTable('"+sTestName+"')"+(char)34+">";
					sSts=WebTableUtil.getCellData(wSummaryTable, r, 3);
					sAnchorEndTag="</a>";
					sStrtTDtag="<td>";
					sEndTDtag="</td>";
					if(sSts.equalsIgnoreCase("PASS"))
					{
						 sTestTag=sTestStartrTag+sHref+SHrefStr+sOnclickStr+sTestName+sAnchorEndTag+sTestEndTags+sStrtTDtag+sMTestName+sEndTDtag+sStrtTDtag+sSts+sEndTDtag;
						 
						 
						 sSummaryTags=sSummaryTags+sSummaryTablePassRowTag+sTestTag;
				//	<td><div><a href="#OpenNavigator" onclick="ShowTable('OpenNavigator');"> OpenNavigator </a></div></td>
						
					}
					else
					{
						sTestTag=sTestStartrTag+sHref+SHrefStr+sOnclickStr+sTestName+sAnchorEndTag+sTestEndTags+sStrtTDtag+sMTestName+sEndTDtag+sStrtTDtag+sSts+sEndTDtag;
						sSummaryTags=sSummaryTags+sSummaryTableFailRowTag;
					}
				}
			}
			
			//WebElement wTstStasticTable=driver.findElement(By.id("TestStatistic"));		
			itestsExe=Integer.parseInt(WebTableUtil.getCellData(wTstStasticTable, 2, 2))+itestsExe;
			iTestPassed=Integer.parseInt(WebTableUtil.getCellData(wTstStasticTable, 3, 2))+iTestPassed;
			iTestFailed=Integer.parseInt(WebTableUtil.getCellData(wTstStasticTable, 4, 2))+iTestFailed;
			
			
	         
		}
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//Making Stastic table ready
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		sTestStasticTable=sTestStasticTable.replace("TESTCASECOUNT", String.valueOf(itestsExe));
		sTestStasticTable=sTestStasticTable.replace("TESTCASEPASSED", String.valueOf(iTestPassed));
		sTestStasticTable=sTestStasticTable.replace("TESTCASEFAILED", String.valueOf(iTestFailed));
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		pw.write(sTitleTag+sTestModuleTable+sTestStasticTable);
		pw.write(sSummaryTags);
		pw.write(sTestEndTags);
		pw.write(sSummaryTableEndTag);
		pw.write(sbodyEndTag);
		pw.write(sHtmlEndTag);
		//bw.flush();
		pw.close();
		bw.close();
}
	 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	//	PageFactory.initElements(driver, verifyPF);
		
		
	}
	
	//update each @test result in custom result file
	@AfterMethod
	public static void afterEachMethod(){
		FrameworkUtil.updateTestCaseStatusinResult();
		
	}
	

}
