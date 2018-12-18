package com.commonUtils;

import org.apache.log4j.Logger;


public class LoggerUtil {


	//Initialize Log4j logs
	private static Logger Log = Logger.getLogger(LoggerUtil.class.getName());
	
	/*==============================================================
	Method Name		: setClassNameForLog
	Description		:Setting the class name 
	Author 			: Sukur Babu
	Creation Date 	: 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void setClassNameForLog(String className){
		if (className == null ){
			className = WebObjectUtil.getOperationName();
		}
			if (className == null){
			Log = Logger.getLogger(FrameworkUtil.getCallingClassMethodName());
			}
		else {
			Log = Logger.getLogger(className);	
		}
		
	}
	
	
/*	public static void getClassName(String className){
		if (className == null){
		Log = Logger.getLogger(FrameworkUtil.getCallingClassMethodName());
		}else {
			Log = Logger.getLogger(className);	
		}
	}*/
	/*==============================================================
	Method Name		: writeStatusLog
	Description		: Writing Status log based on parameter passed
	Author 			: Sukur Babu
	Creation Date 	: 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void writeStatusLog(boolean bStatus,String sTitle,String sDescription){
		//setClassNameForLog(sTitle);
		WebObjectUtil.sOperationname = sTitle;
		if(bStatus)
		{	
			LoggerUtil.log_type_info("Success: " + sDescription);
			
		}
		else
		{
			LoggerUtil.log_type_error("Failure: " + sDescription);
			
		}
	}
	
	/*==============================================================
	Method Name		: log_type_info
	Description		: logging the data as info
	Author 			: Sukur Babu
	Creation Date 	: 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void log_type_info(String message) {
			setClassNameForLog(null);
			Log.info(message);
			WebObjectUtil.sOperationname = null;
			}
	/*==============================================================
	Method Name		: log_type_warn
	Description		: logging the data as warning
	Author 			: Sukur Babu
	Creation Date 	: 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void log_type_warn(String message) {
		setClassNameForLog(null);
	   Log.warn(message);
	   WebObjectUtil.sOperationname = null;
		}
	/*==============================================================
	Method Name		: log_type_error
	Description		: logging the data as error
	Author 			: Sukur Babu
	Creation Date 	: 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void log_type_error(String message) {
		setClassNameForLog(null);
	   Log.error(message);
	   WebObjectUtil.sOperationname = null;
		}
	/*==============================================================
	Method Name		: log_type_fatal
	Description		: logging the data as fatal
	Author 			: Sukur Babu
	Creation Date 	: 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void log_type_fatal(String message) {
		setClassNameForLog(null);
	   Log.fatal(message);
	   WebObjectUtil.sOperationname = null;
		}
	/*==============================================================
	Method Name		: log_type_debug
	Description		: logging the data as debug
	Author 			: Sukur Babu
	Creation Date 	: 
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public static void log_type_debug(String message) {
		setClassNameForLog(null);
	   Log.debug(message);
	   WebObjectUtil.sOperationname = null;
		}

}

