package com.whs.navigator.commonUtil;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;



public class FrameworkUtil {
	public static String propName;
	public static String propValue;
	public static  String ClassMethodName;
	public static String timeStamp;
	public static String sElementName;
	public static Enumeration propKeys = null;
	public static int iStepNo = 0;
	public static String sTestCaseName;
	public static String sManualTestCaseName;
	public static String sTestCaseResult = "PASS" ;
	public static boolean bTestCaseResultFlag = true ;
	public static String sCustomFileName;
	public static String sCustomResultContent;
	public static String sTestcaseSummaryLinkList = "";
	public static int iTestcaseExecuted = 0;
	public static int iTestcasePassed = 0;
	public static int iTestcaseFailed = 0;
	public static int iTestcaseNotCompleted = 0;
	public static String sCurrentWorkingDir = System.getProperty("user.dir");
	public static String sPropertyFile_TestDataFile = null; 
	public static String sPropertyFile_DynamicPagePactory = null; 
	public static Dictionary dictPropertyData = null;
	public static Dictionary dictDynamicPagePactory = null;
	public static String sResourcePath = "./"; 
	public static String sResultPath = "./"; 
	public static String sTCStartTime;
	public static String sTestcaseSummaryRowContent = "";	
	public static String sTimeStamp = date_yyyyMMdd()+ "_" + date_HHmmss();
	public static String sHostTimeStamp = date_yyyyMMdd()+ "-" + date_HHmmss();
	public static String sExecStartTime;
	public static String sExecEndTime;
	public static boolean sTestExecutionStatus = true;
	
	/*==============================================================
	Method Name		: stepNo
	Description		: Incrementing the step Number
	Author 			: Arularasu
	Creation Date 	: 12/3/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
public static String stepNo(){
	iStepNo++;
	return "Step-" + iStepNo;	
}

/*==============================================================
Method Name		: getPropListAsDictionary
Description		: Load the property data to dictionary objects
Author 			: Arularasu
Creation Date 	: 02/05/2015
Pre-Requisites	:
Revision History:
==============================================================*/
public static void getPropListAsDictionary()
{
	String propFileName;
	List<String> sCredential = new ArrayList<String>();
	try{ 
	Properties prop = new Properties();
	dictPropertyData = new Hashtable();
	propFileName = FrameworkUtil.sPropertyFile_TestDataFile ;
	
	InputStream inputStream = FrameworkUtil.class.getClassLoader().getResourceAsStream(propFileName);
	prop.load(inputStream);
		
		propKeys = prop.propertyNames();
		while (propKeys.hasMoreElements()) 
		{	
			propName =(String) propKeys.nextElement();
			propValue = prop.getProperty(propName);
			dictPropertyData.put(propName, propValue);
			
		}
	}catch(Exception e) {
		String sMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		LoggerUtil.log_type_error( sMethodName + "catch block:  "  + e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , sMethodName, "warn", "catch block: Exception occured" +e.getMessage());
	}
	
}


public static void getPropListAsDictionary(String sPropertyFileName)
{
	String sPropFileName = null;
	List<String> sCredential = new ArrayList<String>();
	String sMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	try{ 
	Properties prop = new Properties();
	dictDynamicPagePactory = new Hashtable();

	
	if (sPropertyFileName.contains(".properties")){
		sPropFileName = sPropertyFileName ;
	}else{
		sPropFileName = sPropertyFileName+".properties" ;
	}
		
	InputStream inputStream = FrameworkUtil.class.getClassLoader().getResourceAsStream(sPropFileName);
	
	if (inputStream == null) {
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), sMethodName , "Read Property file", "fail", "Issue with Accessing Property file " + sPropertyFileName);
		throw new FileNotFoundException("property file '" + sPropFileName + "' not found in the classpath");
	}else{
	prop.load(inputStream);
		propKeys = prop.propertyNames();
		while (propKeys.hasMoreElements()) 
		{	
			propName =(String) propKeys.nextElement();
			propValue = prop.getProperty(propName);
			dictDynamicPagePactory.put(propName, propValue);
			
		}
		
	}
	}catch(Exception e) {
		
		LoggerUtil.log_type_error( sMethodName + "catch block:  "  + e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , sMethodName, "warn", "catch block: Exception occured" +e.getMessage());
	}
	
}

	/*==============================================================
	Method Name		: GetPropKeysList
	Description		: Getting  data from properties file as key-value pair
	Author 			: Arularasu
	Creation Date 	: 12/3/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static List<String> GetPropKeysList()
	{
		List<String> sCredential = new ArrayList<String>();
		try{ 
		Properties prop = new Properties();
		//String propFileName = "Navigator_TestData.properties";
		String propFileName = FrameworkUtil.sPropertyFile_TestDataFile;
 
		InputStream inputStream = FrameworkUtil.class.getClassLoader().getResourceAsStream(propFileName);
		prop.load(inputStream);
		
		
		if (inputStream == null) {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
		else{
			propKeys = prop.keys();
			while (propKeys.hasMoreElements()) 
			{	
				sCredential.add((String) propKeys.nextElement());
			}
		}
		
		}catch(Exception e) {
			String sMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			LoggerUtil.log_type_error( sMethodName + "catch block:  "  + e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , sMethodName, "warn", "catch block: Exception occured" +e.getMessage());
		}

		
		
		return sCredential;	
	}
	/*==============================================================
	Method Name		: getPropValues
	Description		: Reading Key's value from properties file as key-value pair
	Author 			: Arularasu
	Creation Date 	: 11/3/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	public static String getPropValues(String propName) throws IOException{
		try{ 
		Properties prop = new Properties();
		//String propFileName = "Navigator_TestData.properties";
		String propFileName = FrameworkUtil.sPropertyFile_TestDataFile;
 
		InputStream inputStream = FrameworkUtil.class.getClassLoader().getResourceAsStream(propFileName);
		prop.load(inputStream);
		if (inputStream == null) {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}
		else{
			propValue = prop.getProperty(propName);
			//System.out.println(propValue);
		}
		
		}catch(Exception e) {
			String sMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			LoggerUtil.log_type_error( sMethodName + "catch block:  "  + e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , sMethodName, "warn", "catch block: Exception occured" +e.getMessage());
		}
		return propValue ;
	}
	
	/*==============================================================
	Method Name		: getCallingClassMethodName
	Description		: get method name
	Author 			: Arularasu
	Creation Date 	: 11/3/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static String getCallingClassMethodName() {  
		
		try{
	    StackTraceElement[] stack = new Throwable().getStackTrace();  
	    StackTraceElement ste = null;
	    if (stack.length > 1)   
	        ste = stack[3]; 
	    String cName = ste.getClassName().toString();
	    String[] cnam = cName.split("\\.");
	    /*for (int i=0; i<=stack.length;i++){
	    System.out.println(i +" --- "+stack[i]);
	    }*/

	    ClassMethodName = cnam[cnam.length-1] + "_" + ste.getMethodName();
	    ClassMethodName = ste == null ? "[Unavailable]" : ClassMethodName;
		}catch (Exception e){
			String sMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			LoggerUtil.log_type_error( sMethodName + "catch block:  "  + e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , sMethodName, "warn", "catch block: Exception occured" +e.getMessage());
		}
	    return ClassMethodName; 
	    
	}
	
	
	/*==============================================================
	Method Name		: GetCurrentTimeStamp
	Description		: get Current Time Stamp
	Author 			: Arularasu
	Creation Date 	: 11/04/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
/*	public static String GetCurrentTimeStamp()
	{
		
		 Date date= new java.util.Date();
		 //System.out.println(new Timestamp(date.getTime()));
		 timeStamp = "[" + new Timestamp(date.getTime()).toString() + "]";
	    return timeStamp ;
	}*/
	
	
	/*==============================================================
	Method Name		: ScreenShot
	Description		: Capturing the Screen SHot
	Author 			: Arularasu
	Creation Date 	: 12/02/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void ScreenShot(File targetFile){
		 try {
		    WebDriver augmentedDriver = new Augmenter().augment(WebDriverUtil.getDriver());
		    File screenshotFile = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
		   	FileUtils.copyFile(screenshotFile, targetFile);
	
		 } catch (Exception e) {
				String sMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
				LoggerUtil.log_type_error( sMethodName + "catch block:  "  + e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , sMethodName, "warn", "catch block: Exception occured" +e.getMessage());
		 }
		
	}
	
	/*==============================================================
	Method Name		: takeScreenShot
	Description		: calling Screen Shot method to store screen shot 
					  img file in target folder
	Author 			: Arularasu
	Creation Date 	: 12/02/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void takeScreenShot(){
	File targetFile;
	String sFileName,sScreenShotFolderPath="Screenshot",sFolderName;
	try {
		createFolder(FrameworkUtil.sResultPath , sScreenShotFolderPath);
		sScreenShotFolderPath = FrameworkUtil.sResultPath+"/"+sScreenShotFolderPath;
		sFolderName = folderNameWithDateStamp(sScreenShotFolderPath, sTestCaseName);
		sFileName = stepNo()+"_"+ sTestCaseName +"_"+ date_HHmmss() +"_"+ date_yyyyMMdd() +".png";
		targetFile = new File( sScreenShotFolderPath +"/" + sFolderName +"/" + sFileName);
		ScreenShot(targetFile);
	} catch (Exception e) {
		String sMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		LoggerUtil.log_type_error( sMethodName + "catch block:  "  + e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , sMethodName, "warn", "catch block: Exception occured" +e.getMessage());
	}
		
	}
	
	
	
	/*==============================================================
	Method Name		: readFile
	Description		: Read all lines in a file
	Author 			: Arularasu
	Creation Date 	: 11/04/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static String readFile(String sFilePath, String sFileName){
		
		String sReadText = null;
			
			try {
				sFilePath=addBackSlash(sFilePath) + sFileName;

				File rFile= new File(sFilePath);
				sReadText = FileUtils.readFileToString(rFile);
				//System.out.println(rFile.canRead());
				   //System.out.println(sReadText);
				 } catch (IOException e) {
						String sMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
						LoggerUtil.log_type_error( sMethodName + "catch block:  "  + e.getMessage());
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , sMethodName, "warn", "catch block: Exception occured" +e.getMessage());
				}
 
    	return sReadText;
    	
	}
	
	
	/*==============================================================
	Method Name		: writefile
	Description		: Writing/appending file
	Author 			: Arularasu
	Creation Date 	: 11/04/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void writefile(String sText,String sFilePath, String sFileName){
		
		try{
			/*String sDateTime= date_yyyyMMdd()+ "_" + date_HHmmss();
			sFileName = sFileName.replaceAll(".html", sTimeStamp + ".html");
			*/
			
		
			
			File file = new File(addBackSlash(sFilePath)+sFileName);
 
			//if file doesnt exists, then create
    		if(!file.exists()){
    			//file.createNewFile();
    			File f = createFile(sFilePath, sFileName);
    		}
    		sText = sText + "\r\n";
    		//true = append file
    		
   		 OutputStream opFile = new FileOutputStream(file,true);
   		 OutputStreamWriter writer = new OutputStreamWriter(opFile);
   		 writer.append(sText);
   		 writer.close();
 
    	}catch(IOException e){
			String sMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			LoggerUtil.log_type_error( sMethodName + "catch block:  "  + e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , sMethodName, "warn", "catch block: Exception occured" +e.getMessage());
    	}
	}
	/*==============================================================
	Method Name		: writeCustomResult
	Description		: Writing custom result into the file
	Author 			: Arularasu
	Creation Date 	: 11/04/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void writeCustomResult(String sStepNo, String sWebObject, String sUserAction, String sStatus, String sRemarks){
		
		String sHTMLTableRow = "<tr |ROWCOLOR|><td>|STEPNO|</td><td>|WEBOBECT|</td><td>|USERACTION|</td><td>|STATUS|</td><td>|REMARKS|</td></tr>";
		String shtml = sHTMLTableRow;
		
		if (sWebObject == null){
			sWebObject = "NULL";
		}
		try {
		shtml = shtml.replace("|STEPNO|", sStepNo);
		shtml = shtml.replace("|WEBOBECT|", sWebObject);
		shtml = shtml.replace("|USERACTION|", sUserAction);
		shtml = shtml.replace("|STATUS|", sStatus);
		shtml = shtml.replace("|REMARKS|", sRemarks);
		
/* 		switch (sStatus){
			case "fail":
			shtml = shtml.replace("|ROWCOLOR|", "style=\"background:red\"");
			FrameworkUtil.sTestCaseResult = "FAIL";
			FrameworkUtil.bTestCaseResultFlag = false;
			break;
			
			case "warn" :
			shtml = shtml.replace("|ROWCOLOR|", "style=\"background:orange\"");
			break;
			
			case "pass":
			shtml = shtml.replace("|ROWCOLOR|", "style=\"background:green\"");
			break;
			
			default:
				shtml = shtml.replace("|ROWCOLOR|", "style=\"background:white\"");
				break;
			 }*/
		
		if (sStatus.equalsIgnoreCase("pass")){
			shtml = shtml.replace("|ROWCOLOR|", "style=\"background:green\"");
		}else if(sStatus.equalsIgnoreCase("fail")){
			shtml = shtml.replace("|ROWCOLOR|", "style=\"background:red\"");
			FrameworkUtil.sTestCaseResult = "FAIL";
			FrameworkUtil.bTestCaseResultFlag = false;
		}else if (sStatus.equalsIgnoreCase("warn")){
			shtml = shtml.replace("|ROWCOLOR|", "style=\"background:orange\"");
		}else{
			shtml = shtml.replace("|ROWCOLOR|", "style=\"background:white\"");
		}
			FrameworkUtil.writefile(shtml, FrameworkUtil.sResultPath, FrameworkUtil.sCustomFileName);
			
		} catch (Exception e) {
			String sMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			LoggerUtil.log_type_error( sMethodName + "catch block:  "  + e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , sMethodName, "warn", "catch block: Exception occured" +e.getMessage());
		}
	}
	/*==============================================================
	Method Name		: addBackSlash
	Description		: adding backslash to the file path, if it is not there
	Author 			: Vivek Kumar
	Creation Date 	: 11/05/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static String addBackSlash(String sPath)
	{
		String sChar = sPath.substring(sPath.length() - 1);
		
		
		if(sChar.equalsIgnoreCase("\\") || sChar.equalsIgnoreCase("/"))
		{
			//System.out.println(sChar);
			//System.out.println("pass");
		}
		else
		{
			//System.out.println(sPath);
			//sPath = sPath + "\\";
			sPath = sPath + "/";
			//System.out.println("After adding \\ with User's Path " + sPath);
					
		}
		
		return sPath;
	
	}
	/*==============================================================
	Method Name		: date_yyyyMMdd
	Description		: formatting date format in yyyyMMdd
	Author 			: Vivek Kumar
	Creation Date 	: 11/05/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static String date_yyyyMMdd()
	{
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		   //get current date time with Date()
		   Date date = new Date();
		 
		   //System.out.println(dateFormat.format(date));
		   String sDate = (dateFormat.format(date));
		   sDate=sDate.substring(0, 8);
		   return (sDate);
	}
	
	public static String date_HHmmss()
	{
		   DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd HHmmss");
		   //get current date time with Date()
		   Date date = new Date();
		   
		   String sDate = (dateFormat.format(date));
		   String[] arrDate=sDate.split(" ");
		   int iArrLength = arrDate.length;
		   
		   String sTime=arrDate[iArrLength-1];
		   return sTime;
	}
	/*==============================================================
	Method Name		: createFile
	Description		:Creating File
	Author 			: Vivek Kumar
	Creation Date 	: 11/05/2014
	Pre-Requisites	: provide file name with extension
	Revision History:
	==============================================================*/
	public static File createFile(String sFolderPath, String sFileNameWithExtension )
	{
		File sFile = null;
		try
		{
			
			 //String sFolderPath = "C:\\Users\\001793\\Desktop\\test\\";
			 //String sFileName="newfile.xlsx";
			 sFolderPath=addBackSlash(sFolderPath);
			 

			 String sAbsoluteFilePath= sFolderPath + sFileNameWithExtension ;
			 //System.out.println(sAbsoluteFilePath);
			 
		      sFile = new File(sAbsoluteFilePath);
		     
		      if (sFile.createNewFile())
		      {
		      //  System.out.println("File is created!");
		      }
		      else
		      {
		       // System.out.println("File already exists.");
		      }
		      return sFile;
		} 
		catch (IOException e) 
		{
			String sMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			LoggerUtil.log_type_error( sMethodName + "catch block:  "  + e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , sMethodName, "warn", "catch block: Exception occured" +e.getMessage());
		}
	
		return sFile;  
	}
	
	/*==============================================================
	Method Name		: appendDateTimeStamp
	Description		: append timestamp to given file name
	Author 			: Arularasu
	Creation Date 	: 11/04/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static String appendDateTimeStamp( String sFileNameWithExtension){
		
		 String[] arrExtnsion = sFileNameWithExtension.split("\\.");
		
		 System.out.println(arrExtnsion[0]+ sTimeStamp);
		 String sFileName=arrExtnsion[0] +  sTimeStamp ;  //+ date_yyyyMMdd()+ "_" + date_HHmmss();
		 //FrameworkUtil.sCustomFileName = sFileName+ "." + arrExtnsion[1] ;
		 String sAbsoluteFileName=  sFileName + "." + arrExtnsion[1] ;
		 return sAbsoluteFileName;
	}
	

	/*==============================================================
	Method Name		: writeOnlyfile
	Description		: write's only new text. no appending, means it erase existing content and write's new content.
	Author 			: Arularasu
	Creation Date 	: 11/04/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void writeOnlyfile(String sText,String sFilePath, String sFileName){
		
		try{
			File file=  FrameworkUtil.createFile(sFilePath,  sFileName);
		
    		
   		 OutputStream opFile = new FileOutputStream(file);
   		 OutputStreamWriter writer = new OutputStreamWriter(opFile);
   		 writer.write("");
   		writer.flush();
   		
   		 writer.close();
 
    	}catch(IOException e){
			String sMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			LoggerUtil.log_type_error( sMethodName + "catch block:  "  + e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , sMethodName, "warn", "catch block: Exception occured" +e.getMessage());
    	}
	}
	

	/*==============================================================
	Method Name		: updateTestCaseNameinResult
	Description		: update's Test case name in result HTML file 
	Author 			: Arularasu
	Creation Date 	: 11/04/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void updateTestCaseNameinResult(String sTestCaseName,String sManualTestCaseName){
		iStepNo = 0;
		FrameworkUtil.sTestCaseResult = "PASS" ;
		FrameworkUtil.bTestCaseResultFlag = true;
		
		//String sTestCaseLink = "<div><a href=\"#TESTCASENAME\" onclick=\"document.getElementById('TESTCASENAME').className='showDetail';if(document.all){document.getElementById('TESTCASENAME').style.display='block';}\"> TESTCASENAME </a></div>";
		String sTestCaseLink = "<tr style=\"background:white\" ><td><div><a onclick=\"ShowTable('TESTCASENAME');\"  href=\"#TESTCASENAME\" > TESTCASENAME </a></div></td><td> MANUALTCNAME </td><td> TESTCASEFINALSTATUS </td></tr>";
		//String sTestCaseLink = "<tr><td><div><a onclick=\"ShowTable('TESTCASENAME');\"  href=\"#TESTCASENAME\" > TESTCASENAME </a></div></td><td> " + FrameworkUtil.sTestCaseResult + " </td></tr>";
		String sTestCaseTable = "<br></br><table id=TESTCASENAME class=\"moreDetail\" border=1 width=\"800\"><tr><th width=\"100\">Step No.:</th><th width=\"200\">Web Object</th><th width=\"200\">Action</th><th width=\"100\">Status</th><th width=\"200\">Remarks</th></tr>";  //<tr><th></th></tr></table></body></html>
		String sHiddenTClinkContent = "<p hidden> UPDATETESTCASELINK </p>";
		String sManualTC = FrameworkUtil.sManualTestCaseName;
		try {
		sTestCaseLink = sTestCaseLink.replaceAll("TESTCASENAME", sTestCaseName);
		sTestCaseLink = sTestCaseLink.replaceAll("MANUALTCNAME", sManualTestCaseName);
		FrameworkUtil.sTestcaseSummaryRowContent = sTestCaseLink;
		
		FrameworkUtil.sTestcaseSummaryLinkList =FrameworkUtil.sTestcaseSummaryLinkList + sTestCaseLink ;
		//sUpdateTestCase = sUpdateTestCase + sTestCaseTable.replaceAll("TESTCASENAME", sTestCaseName);;
		sTestCaseTable = sTestCaseTable.replaceAll("TESTCASENAME", sTestCaseName);
		sTCStartTime = FrameworkUtil.getCurrentTimeStamp();
		System.out.println("Manual TC name: " +FrameworkUtil.sManualTestCaseName + " and start time " + sTCStartTime );
		
		
			//writefile(sUpdateTestCase, getPropValues("NAV.RESULTLOCATION"), getPropValues("NAV.CUSTOMRESULT.FILENAME"));
			writefile(sTestCaseTable, FrameworkUtil.sResultPath, FrameworkUtil.sCustomFileName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sTestCaseName , "TestcaseName", "Done", FrameworkUtil.sManualTestCaseName);
		} catch (Exception e) {
			String sMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			LoggerUtil.log_type_error( sMethodName + "catch block:  "  + e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , sMethodName, "warn", "catch block: Exception occured" +e.getMessage());
		}

	}
	
	/*==============================================================
	Method Name		: updateTestCaseStatusinResult
	Description		: update's Testcase status for each test in result HTML file 
	Author 			: Arularasu
	Creation Date 	: 11/04/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void updateTestCaseStatusinResult(){
		
		String sHTMLPart,sTimepart;
		FrameworkUtil.sTestcaseSummaryLinkList = FrameworkUtil.sTestcaseSummaryLinkList.replaceFirst("TESTCASEFINALSTATUS", FrameworkUtil.sTestCaseResult);
		FrameworkUtil.sTestcaseSummaryRowContent = FrameworkUtil.sTestcaseSummaryRowContent.replaceFirst("TESTCASEFINALSTATUS", FrameworkUtil.sTestCaseResult);
		if(FrameworkUtil.sTestCaseResult.equalsIgnoreCase("pass")){
			FrameworkUtil.sTestcaseSummaryLinkList = FrameworkUtil.replaceStringLast(FrameworkUtil.sTestcaseSummaryLinkList,"style=\"background:white\"","style=\"background:76ED98\""); //row with GREEN color
			FrameworkUtil.sTestcaseSummaryRowContent = FrameworkUtil.replaceStringLast(FrameworkUtil.sTestcaseSummaryRowContent,"style=\"background:white\"","style=\"background:76ED98\""); //row with GREEN color
			FrameworkUtil.iTestcasePassed++;
		}else if(FrameworkUtil.sTestCaseResult.equalsIgnoreCase("fail")){
			FrameworkUtil.sTestcaseSummaryLinkList = FrameworkUtil.replaceStringLast(FrameworkUtil.sTestcaseSummaryLinkList,"style=\"background:white\"","style=\"background:F85D5F\""); //row with RED color
			FrameworkUtil.sTestcaseSummaryRowContent = FrameworkUtil.replaceStringLast(FrameworkUtil.sTestcaseSummaryRowContent,"style=\"background:white\"","style=\"background:F85D5F\""); //row with RED color
			FrameworkUtil.iTestcaseFailed++;
		}else {
			FrameworkUtil.sTestcaseSummaryLinkList = FrameworkUtil.replaceStringLast(FrameworkUtil.sTestcaseSummaryLinkList,"style=\"background:white\"","style=\"background:white\""); //row with White color
			FrameworkUtil.sTestcaseSummaryRowContent = FrameworkUtil.replaceStringLast(FrameworkUtil.sTestcaseSummaryRowContent,"style=\"background:white\"","style=\"background:white\""); //row with White color
			FrameworkUtil.iTestcaseNotCompleted++;
		}

		FrameworkUtil.iTestcaseExecuted++;
		
		System.out.println("TC Exec time: "+FrameworkUtil.timeStampDifference(sTCStartTime, FrameworkUtil.getCurrentTimeStamp()));
		
		String sTESTCASEFINALSTATUS ="TESTCASEFINALSTATUS";
		String sHiddenTClinkContent = "<p hidden> UPDATETESTCASELINK </p>";
		

		FrameworkUtil.sTestcaseSummaryRowContent = FrameworkUtil.sTestcaseSummaryRowContent + sHiddenTClinkContent;
		sCustomResultContent =  FrameworkUtil.readFile(FrameworkUtil.sResultPath, FrameworkUtil.sCustomFileName);
		
		sCustomResultContent = sCustomResultContent.replaceFirst(sHiddenTClinkContent, FrameworkUtil.sTestcaseSummaryRowContent);
		FrameworkUtil.writeOnlyfile("", FrameworkUtil.sResultPath, FrameworkUtil.sCustomFileName);
		FrameworkUtil.writefile(sCustomResultContent, FrameworkUtil.sResultPath, FrameworkUtil.sCustomFileName);
		FrameworkUtil.writefile("</table>", FrameworkUtil.sResultPath, FrameworkUtil.sCustomFileName);
		
		
/*		if (FrameworkUtil.bTestCaseResultFlag){
			FrameworkUtil.sTestCaseResult = "PASS" ;
			FrameworkUtil.iTestcasePassed++;
		}else{
			FrameworkUtil.sTestCaseResult = "FAIL" ;
			FrameworkUtil.iTestcaseFailed++;
		}
		FrameworkUtil.iTestcaseExecuted++;
*/
		
		
/*	if (FrameworkUtil.sTestCaseResult == "PASS"){
		FrameworkUtil.iTestcasePassed++;
	}else if(FrameworkUtil.sTestCaseResult == "FAIL"){
		FrameworkUtil.iTestcaseFailed++;
	}else{  //else if(FrameworkUtil.sTestCaseResult == "NOTCOMPLETED"){
		FrameworkUtil.iTestcaseNotCompleted++;
	}
		FrameworkUtil.iTestcaseExecuted++;	*/
		
		//Test Execution time
		sExecEndTime = FrameworkUtil.getCurrentTimeStamp();
		String sTimeDiff = FrameworkUtil.timeStampDifference(sExecStartTime, sExecEndTime);
	
		sHTMLPart = "<td>Start Time</th><td>";
		sTimepart = sExecStartTime + "";
		FrameworkUtil.findReplaceinResultFile("",sTimepart, sHTMLPart);
		
		sHTMLPart = "<td>End Time</th><td>";
		sTimepart = sExecEndTime + "";
		FrameworkUtil.findReplaceinResultFile("",sTimepart, sHTMLPart);
		
		sHTMLPart = "<td>Execution Time</th><td>";
		sTimepart = sTimeDiff + "";
		FrameworkUtil.findReplaceinResultFile("",sTimepart, sHTMLPart);
		
		
		//Test Execution Statistic
		sHTMLPart = "<td>Test Executed</th><td>";
		sTimepart = iTestcaseExecuted + "";
		FrameworkUtil.findReplaceinResultFile("",sTimepart, sHTMLPart);
		
		sHTMLPart = "<td>Test Passed</th><td>";
		sTimepart = iTestcasePassed + "";
		FrameworkUtil.findReplaceinResultFile("",sTimepart, sHTMLPart);
		
		sHTMLPart = "<td>Test Failed</th><td>";
		sTimepart = iTestcaseFailed + "";
		FrameworkUtil.findReplaceinResultFile("",sTimepart, sHTMLPart);
		
		sHTMLPart = "<td>Not Completed/Executed</th><td>";
		sTimepart = iTestcaseNotCompleted + "";
		FrameworkUtil.findReplaceinResultFile("",sTimepart, sHTMLPart);
		
	}
	
	
	/*==============================================================
	Method Name		: findReplaceinResultFile
	Description		: this method used to find and replace string in result HTML file 
	Author 			: Arularasu
	Creation Date 	: 11/04/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void findReplaceinResultFile(String sFindString, String sReplaceString){
	
		String sCustomResultContent;
		try {
			sCustomResultContent = FrameworkUtil.readFile(FrameworkUtil.sResultPath, FrameworkUtil.sCustomFileName);
			sCustomResultContent = sCustomResultContent.replace(sFindString, sReplaceString);
			FrameworkUtil.writeOnlyfile("", FrameworkUtil.sResultPath, FrameworkUtil.sCustomFileName);
			FrameworkUtil.writefile(sCustomResultContent, FrameworkUtil.sResultPath, FrameworkUtil.sCustomFileName);
		} catch (Exception e) {
			String sMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			LoggerUtil.log_type_error( sMethodName + "catch block:  "  + e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , sMethodName, "warn", "catch block: Exception occured" +e.getMessage());
		}
		
	}
	
	/*==============================================================
	Method Name		: findReplaceinResultFile
	Description		: this method used to find and replace string in result HTML file 
	Author 			: Arularasu
	Creation Date 	: 11/04/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void findReplaceinResultFile(String sCustomResultContent, String sReplaceString, String sDelimiter){
		
		try {
			sCustomResultContent = FrameworkUtil.readFile(FrameworkUtil.sResultPath, FrameworkUtil.sCustomFileName);
			String[] sResultContent = sCustomResultContent.split(sDelimiter);
			int iSecondPartIndex = sResultContent[1].indexOf("</td>");
			String sSecondPart=sResultContent[1].substring(iSecondPartIndex);
			sCustomResultContent = sResultContent[0] + sDelimiter + sReplaceString + sSecondPart;
			FrameworkUtil.writeOnlyfile("", FrameworkUtil.sResultPath, FrameworkUtil.sCustomFileName);
			FrameworkUtil.writefile(sCustomResultContent, FrameworkUtil.sResultPath, FrameworkUtil.sCustomFileName);
		} catch (Exception e) {
			String sMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			LoggerUtil.log_type_error( sMethodName + "catch block:  "  + e.getMessage());
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , sMethodName, "warn", "catch block: Exception occured" +e.getMessage());
		}
	
	}

	/*==============================================================
	Method Name		: ArchiveFolder
	Description		: 
	Author 			: Vivek Kumar
	Creation Date 	: 11/05/2014
	Pre-Requisites	:
	Revision History:
	==============================================================*/
public static void ArchiveFolder(String sFolPath, String sArchiveFolderName, String sCreateFolName)
{

	sFolPath=addBackSlash(sFolPath);
	
	//Creating Archive folder @ sFolPath
	FrameworkUtil.createFolder(sFolPath, sArchiveFolderName);
	
	//Creating folder with current date and returning its value in sCurrentFolderName
	
	String sCurrentFolderName = sCreateFolName ;  //FrameworkUtil.folderNameWithDateStamp(sFolPath, sCreateFolName);
	//String sCurrentFolderName = FrameworkUtil.folderNameWithDateStamp(sFolPath, sCreateFolName);
	//System.out.println("current folder name   ---- " + sCurrentFolderName);
	File file = new File(sFolPath);
	
	//getting the total count of folder present @ sFolPath
	//System.out.println(file.list().length);
	
	//capturing all folder in an array
	String files[] = file.list();
		for (String stemp : files)
		{
			// construct the file structure
			File fileMove = new File(file, stemp);
			
			//getting the absolute path for each folder
			String sFolAbsoluteValue=fileMove.getAbsolutePath();
			//System.out.println(sFolAbsoluteValue);
			
			//Splitting each folder path with "\"
			String[]  sFolderName = sFolAbsoluteValue.split("\\\\");
			//System.out.println(sFolderName.length);
			
			//Capturing the ubound of each array
			int iArrLength= sFolderName.length;
			
			//Getting the folder name 
			String sName = sFolderName[iArrLength-1];
			
			//Condition-- If folder name is equal to sArchiveFolderName and sCurrentFolderName then dont 				//do anything
			//if not then move the folder from sSource to sDestination
			if(sName.equalsIgnoreCase(sArchiveFolderName))
			{
				//System.out.println("Archive folder so can not remove");
			}
			else if(sName.equalsIgnoreCase(sCurrentFolderName))
			{
				//System.out.println("current folder --- so can not moved");
			}
			else
			{
				String sSource = sFolAbsoluteValue;
				String sDestination = sFolPath + sArchiveFolderName;
				FrameworkUtil.moveFolder(sSource, sDestination);
			}
			
		}
		
	}



/*==============================================================
Method Name		: moveFolder
Description		: 
Author 			: Vivek Kumar
Creation Date 	: 11/05/2014
Pre-Requisites	:
Revision History:
==============================================================*/
public static void moveFolder(String sSource,String sDestination)
{
		sSource=addBackSlash(sSource);
		sDestination=addBackSlash(sDestination);
		File sFolder = new File(sSource);
		
        // Destination directory
        File sDir = new File(sDestination);
        
        String sNewPath = sDir + sFolder.getName();
        File sDestPath = new File(sNewPath);
        
        if (sDir.exists())
        {
        	if(!sFolder.exists())
	        {
	        	//System.out.println(sFolder.getName() + " - Folder does not exist");
	        	
	        }
	        else if(sDestPath.exists())
	        {
	        	//System.out.println("Already folder exist at destination -  " + sNewPath);
	        }
	        else
	        	
	        {
	        	
	        	  // Move file to new directory
	        	System.out.println(sFolder.getName());
	        	if (!FrameworkUtil.sCustomFileName.equalsIgnoreCase(sFolder.getName())){
	            boolean success = sFolder.renameTo(new File(sDir, sFolder.getName()));
	            if(success)
	            {
	            	//System.out.println(sFolder.getName() + " - Folder moved successfully");
	            }
	        	}
	        }
        }
        else
        {
        	//System.out.println("Destination folder is not available !");
        }
        
        
}





/*==============================================================
Method Name		: createFolder
Description		: 
Author 			: Vivek Kumar
Creation Date 	: 11/05/2014
Pre-Requisites	:
Revision History:
==============================================================*/

public static void createFolder(String sFolPath, String sFolName) {
	
	sFolPath=addBackSlash(sFolPath);
	String sFile = sFolPath + sFolName ;
	sFile= sFile.replace("\\", "/");
	File file = new File(sFile);
	if (!file.exists()) 
	{
		file.getParentFile().mkdirs();
		if (file.mkdir())
		{
			//System.out.println("folder created");
			//FrameworkUtil.sResultPath = sFile;
		} 
		else 
		{
			//System.out.println("Failed to create directory!");
		}
	} 
	else 
	{
		//System.out.println("Already folder is there");
		//FrameworkUtil.sResultPath = sFile;
	}

}


/*==============================================================
Method Name		: createFolder
Description		: 
Author 			: Vivek Kumar
Creation Date 	: 11/05/2014
Pre-Requisites	:
Revision History:
==============================================================*/
public static String folderNameWithDateStamp(String sFolPath, String sFolName )
{
	//String sFolPath = null; 
	//String sFolName = null;
	//sFolPath = "C:\\Users\\001793\\Desktop\\test\\";
	
	sFolPath=addBackSlash(sFolPath);
	sFolName = sFolName+ date_yyyyMMdd();
	//System.out.println(sFolName);
	File directory = new File(sFolPath);
	
	
	if(directory.exists())
	{
		//System.out.println("Directory is available");
		String sSubFolPath = sFolPath + sFolName;
		//System.out.println(sSubFolPath);
		File sSubFolder = new File(sSubFolPath);
		if(sSubFolder.exists())
		{
			//System.out.println("Already folder with name " + sFolName + " is present there" );
			return sFolName;
		}
		else
		{
			String sPath= sFolPath;
			//String sName = sFolName + date_yyyyMMdd() ;
			////System.out.println(sName);
			FrameworkUtil.createFolder(sPath, sFolName);
			return sFolName;
		}
	
		
	}
	
	else
	{
		//System.out.println("Invalid Directory !");
		return sFolName;
	}
	
			
}



/*==============================================================
Method Name		: copyFileToDir
Description		: Copy file to given location
Author 			: Arularasu
Creation Date 	: 12/02/2014
Pre-Requisites	:
Revision History:
==============================================================*/
public static void copyFileToDir(String sSource,String sDestination){
		
	try {
		
		File source = new File(sSource);
		File dest = new File(sDestination);
		//FileUtils.copyFile(source, dest);
		FileUtils.copyFileToDirectory(source, dest);
	} catch (IOException e) {
		String sMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		LoggerUtil.log_type_error( sMethodName + "catch block:  "  + e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , sMethodName, "warn", "catch block: Exception occured" +e.getMessage());
	}
}

/*==============================================================
Method Name		: replaceStringLast
Description		: replace first instance of string
Author 			: Arularasu
Creation Date 	: 12/02/2014
Pre-Requisites	:
Revision History:
==============================================================*/
public static String replaceStringLast(String string, String substring, String replacement)
{
  int index = string.lastIndexOf(substring);
  if (index == -1)
    return string;
  return string.substring(0, index) + replacement
          + string.substring(index+substring.length());
}

/*==============================================================
Method Name		: timeStampDifference
Description		: 
Author 			: Vivek
Creation Date 	: 12/02/2014
Pre-Requisites	:
Revision History:
==============================================================*/
public static String timeStampDifference(String sStartTime, String sEndTime){
	String sTimeDiff = "";
	//HH converts hour in 24 hours format (0-23), day calculation
	SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	Date d1 = null;
	Date d2 = null;

	try {
		d1 = format.parse(sStartTime);
		d2 = format.parse(sEndTime);

		//in milliseconds
		long diff = d2.getTime() - d1.getTime();

		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffDays = diff / (24 * 60 * 60 * 1000);
/*
		System.out.print(diffDays + " days, ");
		System.out.print(diffHours + " hours, ");
		System.out.print(diffMinutes + " minutes, ");
		System.out.print(diffSeconds + " seconds.");
*/
		sTimeDiff = diffHours + " : " + diffMinutes +" : " + diffSeconds;
	} catch (Exception e) {
		String sMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		LoggerUtil.log_type_error( sMethodName + "catch block:  "  + e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , sMethodName, "warn", "catch block: Exception occured" +e.getMessage());
}

	return sTimeDiff;
}



/*==============================================================
Method Name		: timeDiffInSeconds
Description		: 
Author 			: Arularasu
Creation Date 	: 12/02/2014
Pre-Requisites	:
Revision History:
==============================================================*/
public static long timeDiffInSeconds(String sStartTime, String sEndTime){
	Date d1,d2;
	long diffSeconds = 0,diffMinutes,diffHours,diffDays,diff;
	//HH converts hour in 24 hours format (0-23), day calculation
	SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	try {
		d1 = format.parse(sStartTime);
		d2 = format.parse(sEndTime);

		//in milliseconds
		 diff = d2.getTime() - d1.getTime();
		 diffSeconds = diff / 1000 % 60;
/*
		 diffMinutes = diff / (60 * 1000) % 60;
		 diffHours = diff / (60 * 60 * 1000) % 24;
		 diffDays = diff / (24 * 60 * 60 * 1000);

*/	} catch (Exception e) {
		String sMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		LoggerUtil.log_type_error( sMethodName + "catch block:  "  + e.getMessage());
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , sMethodName, "warn", "catch block: Exception occured" +e.getMessage());
}

	return diffSeconds;
}



/*==============================================================
Method Name		: getCurrentTimeStamp
Description		: returns current time as string
Author 			: Arularasu
Creation Date 	: 12/02/2014
Pre-Requisites	:
Revision History:
==============================================================*/
public static String getCurrentTimeStamp(){
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	return dateFormat.format(date).toString();
}

/*==============================================================
Method Name		: updateCustomResultBasedOnStatus
Description		: update's result file (pass/fail) based on boolean passed.
Author 			: Arularasu
Creation Date 	: 12/02/2014
Pre-Requisites	:
Revision History:
==============================================================*/
public static void updateCustomResultBasedOnStatus(boolean bstatus,String sMsg){
	if (bstatus){
	FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verify element/text", "pass", sMsg );
	}else{
		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "verify element/text", "fail", sMsg );
	}
}




}




