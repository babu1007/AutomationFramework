package com.whs.navigator.testcases;


import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.commonUtil.WebTableUtil;
import com.whs.navigator.pagefactory.AnnouncementPageFactory_Old;

public class AnnouncementTestCase_Old {
	public static AnnouncementPageFactory_Old announcement= new AnnouncementPageFactory_Old();
	
	/*==============================================================
	TestScript  	: navShowHideCalender
	Manual TestCase	: show calendar
					  hide calendar.
	Description		: verify show calendar and Hide Calendar button
	Author 			: Vivek Kumar
	Creation Date 	: 01/27/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test
	public void navShowHideCalender()
	{
		//Declaration
		String sUserName,sPassword;
		
		try {
			FrameworkUtil.sTestCaseName = "AnnouncementnavShowHideCalender";
			FrameworkUtil.sManualTestCaseName="1.show calendar "+ '\n' + " 2.Hide Calendar";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			
			 sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
			//getting password from properties file
			 sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
			//navigating to Announcement page
			navAnnouncement(sUserName,sPassword);
			//Clicking on Show Calendar button and verifying the calendar
			WebObjectUtil.clickAndVerifyElement(announcement.getNav_CalenderBtn(), announcement.getNav_DatePicker());
			//Verifying Hide Calendar button
			WebObjectUtil.verifyElementPresent(announcement.getNav_HideCalender());
			//clicking Hide Calendar button and verifying show calendar button
			WebObjectUtil.clickAndVerifyElement(announcement.getNav_HideCalender(), announcement.getNav_CalenderBtn());
			//Logging out from Navigator application
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_info(e.getMessage());
			LoggerUtil.log_type_error("Problem with Show/Hide Calendar button");
		}
		
	}
	
	/*==============================================================
	TestScript  	: navMonthScrolling
	Manual TestCase	: Month scrolling and Today link
	Description		: Month scrolling and Today link
	Author 			: Vivek Kumar
	Creation Date 	: 01/27/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test
	public void navMonthScrolling() 
	{
		//Declaration
		String sUserName,sPassword,MonthName;
		try {
			FrameworkUtil.sTestCaseName = "AnnouncementnavMonthScrolling";
			FrameworkUtil.sManualTestCaseName="Month scrolling and Today link";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			//Getting password from Properties file		
			 sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
			//getting password from properties file
			 sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
			//navigating to Announcement page
			navAnnouncement(sUserName,sPassword);
			//Clicking on Show Calendar button and verifying the calendar
			WebObjectUtil.clickAndVerifyElement(announcement.getNav_CalenderBtn(), announcement.getNav_DatePicker());
			//clicking on backward arrow
			WebObjectUtil.clickElement(announcement.getNav_BackwardMonthArrow());
			//clicking on backward arrow
			WebObjectUtil.clickElement(announcement.getNav_BackwardMonthArrow());
			//Clicking on Today's Link
			WebObjectUtil.clickElement(announcement.getNav_TodayLink());
			//Getting Month name of Current Month
			 MonthName = announcement.getNav_CurrentMonth().getText();
			//Fetching current month Year
			getCurrentMonthYear( MonthName);
			//Clicking on Forward Arrow
			WebObjectUtil.clickElement(announcement.getNav_ForwardMonthArrow());
			//Clicking on Forward Arrow
			WebObjectUtil.clickElement(announcement.getNav_ForwardMonthArrow());
			//Clicking on Today's Link
			WebObjectUtil.clickElement(announcement.getNav_TodayLink());
			//Fetching current month Year
			getCurrentMonthYear( MonthName);
			//Logging out from Navigator application
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_info(e.getMessage());
			LoggerUtil.log_type_error("Issue with Month Scrolling");
		}
	}

	
	/*==============================================================
	TestScript  	: navViewAnnouncement
	Manual TestCase	: view announcement
	Description		: view announcement with GirUser
	Author 			: Vivek Kumar
	Creation Date 	: 01/27/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	@Test
	public void navViewAnnouncement() 
	{
		//Declaration
		String sUserName,sPassword,sMonthName,sMonthYear,sAnnouncementDate,sDate;
		try {
			FrameworkUtil.sTestCaseName = "AnnouncementnavViewAnnouncement";
			FrameworkUtil.sManualTestCaseName="view announcement";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			
			//Getting UserNAme from properties file
			 sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TEST.USERID");
			//getting password from properties file
			 sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TEST.PWD");
			//navigating to Announcement page
			navAnnouncement(sUserName,sPassword);
			//Clicking on Show Calendar button and verifying the calendar
			WebObjectUtil.clickAndVerifyElement(announcement.getNav_CalenderBtn(), announcement.getNav_DatePicker());
			//get current month name from application
			 sMonthName = announcement.getNav_CurrentMonth().getText();
			//getting Month year from properties file
			 sMonthYear = (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.MONTHYEAR");
			//clicking backward month arrow till it match with sMonthYear
			while(!sMonthName.equalsIgnoreCase(sMonthYear))
			{
				//System.out.println(sMonthName);
				WebObjectUtil.clickElement(announcement.getNav_BackwardMonthArrow());
				sMonthName = announcement.getNav_CurrentMonth().getText();
			}
			//fetching announcement date from application
			 sAnnouncementDate=announcement.getNav_AnnouncementDate().getText();
			//fetching date from properties file
			 sDate= (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.DATE");
			//comparing sAnnouncementDate and sDate 
			if(WebObjectUtil.compareString(sAnnouncementDate, sDate, true))
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify 24th as date", "pass", "");
				WebObjectUtil.MouseHover(announcement.getNav_AnnouncementDate());
				WebObjectUtil.clickElement(announcement.getNav_AnnouncementDate());
				//Verifying Announcement for sAnnouncementDate
				WebObjectUtil.verifyElementPresent(announcement.getNav_Annuncement1());
				WebObjectUtil.verifyElementPresent(announcement.getNav_Annuncement2());
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify 24th as date", "fail", "");
				LoggerUtil.log_type_error("date 24  not verified ");
			}
			//Logging out from Navigator application
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_info(e.getMessage());
			LoggerUtil.log_type_error("Issue with Announcement Date");
		}
	}
	/*==============================================================
	TestScript  	: navAnnouncementProtected
	Manual TestCase	: announcement protected by SKU
	Description		: view announcement with Selenium.Test
	Author 			: Vivek Kumar
	Creation Date 	: 01/28/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test 
	public void navAnnouncementProtected()
	{
		//Declaration
		String sUserName,sPassword,sMonthName,sMonthYear,sAnnouncementDate,sDate;
		try {
			FrameworkUtil.sTestCaseName = "navAnnouncementProtected";
			FrameworkUtil.sManualTestCaseName="announcement protected by SKU";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			//getting UserName from properties file
			 sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.PROTECTED.USERID");
			//getting password from properties file
			 sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.PROTECTED.PASSWORD");
			//navigating to Announcement page
			navAnnouncement(sUserName,sPassword);
			//Clicking on Show Calendar button and verifying the calendar
			WebObjectUtil.clickAndVerifyElement(announcement.getNav_CalenderBtn(), announcement.getNav_DatePicker());
			//getting the Current Month name from application
			 sMonthName = announcement.getNav_CurrentMonth().getText();
			//fetching the Monthe year from properties file
			 sMonthYear = (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.MONTHYEAR");
			//clicking on Backward Month Arrow until sMonthName equals sMonthYear
			while(!sMonthName.equalsIgnoreCase(sMonthYear))
			{
				WebObjectUtil.clickElement(announcement.getNav_BackwardMonthArrow());
				sMonthName = announcement.getNav_CurrentMonth().getText();
			}
			///getting the Current Month name from application
			 sAnnouncementDate=announcement.getNav_AnnouncementDate().getText();
			//fetching the Monthe year from properties file
			 sDate= (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.DATE");
			//Comparing sAnnouncementDate and sDate
			if(WebObjectUtil.compareString(sAnnouncementDate, sDate, true))
			{
				
				WebObjectUtil.MouseHover(announcement.getNav_AnnouncementDate());
				WebObjectUtil.clickElement(announcement.getNav_AnnouncementDate());
				WebObjectUtil.verifyElementPresent(announcement.getNav_Annuncement1());
				WebObjectUtil.verifyElementPresent(announcement.getNav_Annuncement2());
				WebObjectUtil.verifyElementPresent(announcement.getNav_AnnouncementProtected());
			}
			else
			{
				System.out.println("failure: date 24  not verified");
				LoggerUtil.log_type_error("date 24  not verified ");
			}
			//Logging out from Navigator application
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			LoggerUtil.log_type_info(e.getMessage());
			LoggerUtil.log_type_error("Issue with Protected-Announcement Date");
		}
	}
	/*==============================================================
	TestScript  	: navTestMultiOrgAnnouncement
	Manual TestCase	: test multi org announcements
	Description		: test multi org announcements
	Author 			: Vivek Kumar
	Creation Date 	: 01/30/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	//@Test
	public void navTestMultiOrgAnnouncement()
	{
		//Declaration
		String sMultiUserId,sMultiPassword,sListByValue,sListByText,sMonthName,sMonthYear,sAnnouncementDate,sDate;
		try {
			FrameworkUtil.sTestCaseName = "navTestMultiOrgAnnouncement";
			FrameworkUtil.sManualTestCaseName = "test multi org announcements";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
						
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, announcement);	
			//Fetching test data from properties file
			//FrameworkUtil.dictPropertyData.get("NAV.MULTIANNOUNCEMENT.USERID");
			 sMultiUserId=(String)FrameworkUtil.dictPropertyData.get("NAV.MULTIANNOUNCEMENT.USERID");
			 sMultiPassword=(String)FrameworkUtil.dictPropertyData.get("NAV.MULTIANNOUNCEMENT.PASSWORD");
			 sListByValue = (String)FrameworkUtil.dictPropertyData.get("NAV.LIST.BYVALUE.BELKSMRT");
			 sListByText = (String)FrameworkUtil.dictPropertyData.get("NAV.LIST.BYTEXT.BELKSMRT");
			//Login to navigator with Multiorg UserId and Password
			LoginTestCase.nav_Login(sMultiUserId,sMultiPassword);
			
			//Selecting from WebList Belk - Smart
			WebObjectUtil.selectWebList(announcement.getNav_MultiSelectList(), null, sListByValue, null);
			//clicking and verifying BELK- Smart
			WebObjectUtil.clickAndVerifyText(announcement.getNav_UseOrganizationBtn(), sListByText);
			//Clicking on Support Tab
			WebObjectUtil.ClickAndMouseHover(announcement.getNav_SupportTab());
			//Clicking and Verifying Calender button
			WebObjectUtil.clickAndVerifyElement(announcement.getNav_AnnouncementsMenuLink(), announcement.getNav_CalenderBtn());
			//Clicking on Show Calendar button and verifying the calendar
			WebObjectUtil.clickAndVerifyElement(announcement.getNav_CalenderBtn(), announcement.getNav_DatePicker());
			//Fetching sMonthname form Application
			 sMonthName = announcement.getNav_CurrentMonth().getText();
			//Fetching sMonthYear from properties
			 sMonthYear = (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.MULTIORG.MONTHYEAR");
			//clicking on Backward month arrow until sMonthName equal to sMonthYear
			while(!sMonthName.equalsIgnoreCase(sMonthYear))
			{
				WebObjectUtil.clickElement(announcement.getNav_BackwardMonthArrow());
				sMonthName = announcement.getNav_CurrentMonth().getText();
				
			}
			//getting sAnnouncementDate from application and sDate from properties file
			 sAnnouncementDate=announcement.getNav_MultiOrgAnnouncementDate().getText();
			 sDate= (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.MULTIORG.DATE");
			//comparing sAnouncementDate and sDate
			if(WebObjectUtil.compareString(sAnnouncementDate, sDate, true))
			{
				WebObjectUtil.MouseHover(announcement.getNav_MultiOrgAnnouncementDate());
				WebObjectUtil.clickElement(announcement.getNav_MultiOrgAnnouncementDate());
				WebObjectUtil.verifyElementPresent(announcement.getNav_MultiUserAnnouncement());
				
			}
			else
			{
				System.out.println("failure: date 11  not verified");
				LoggerUtil.log_type_error("date 11  not verified ");
			}
			
			//Selecting BELK-WorkForce Management
			WebObjectUtil.ClickAndMouseHover(announcement.getNav_MultiUserName());
			WebObjectUtil.clickAndVerifyText(announcement.getNav_MultiUserBELKWorkForce(), "Belk - Workforce Management");
			//Clicking on Show Calendar button and verifying the calendar
			WebObjectUtil.clickAndVerifyElement(announcement.getNav_CalenderBtn(), announcement.getNav_DatePicker());
			//fetching sMonthName from application
			 sMonthName = announcement.getNav_CurrentMonth().getText();
			 //Fetching sMonthYear from properties file
			 sMonthYear = (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.MULTIORG.MONTHYEAR");
			//Clicking on Backward month arrow until sMonthName equals to sMonthYear
			while(!sMonthName.equalsIgnoreCase(sMonthYear))
			{
				WebObjectUtil.clickElement(announcement.getNav_BackwardMonthArrow());
				sMonthName = announcement.getNav_CurrentMonth().getText();
				
			}
			//Comparing sAnnouncementDate and sDate
			if(WebObjectUtil.compareString(sAnnouncementDate, sDate, true))
			{
				WebObjectUtil.MouseHover(announcement.getNav_MultiOrgNoAnnouncement());
				WebObjectUtil.clickElement(announcement.getNav_MultiOrgNoAnnouncement());
				//Verifying that No announce is there when user logged with Belk- Workforce management
				boolean bStatus=WebObjectUtil.isElementPresent(announcement.getNav_MultiUserAnnouncement());
				if(!bStatus)
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify no Announcement-BELK WrkFrce Mgmt", "pass", "");
					LoggerUtil.log_type_info("Announcement is not there");
				}
				else
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify no Announcement-BELK WrkFrce Mgmt", "fail", "");
					LoggerUtil.log_type_error("Announcement is there");
				}
			}
			else
			{
				//System.out.println("fail");
				LoggerUtil.log_type_error("date 11  not verified ");
			}
			
			//Logging out from Navigator application
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*==============================================================
	Method Name 	: navAnnouncement
	Description		: This will navigate to announcement page 
	Author 			: Vivek Kumar
	Creation Date 	: 01/27/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	public void navAnnouncement(String UserId, String Password) 
	{
		try {
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, announcement);				
			LoginTestCase.nav_Login(UserId,Password);
			WebObjectUtil.ClickAndMouseHover(announcement.getNav_SupportTab());
			WebObjectUtil.clickAndVerifyElement(announcement.getNav_AnnouncementsMenuLink(), announcement.getNav_CalenderBtn());
		} catch (Exception e) {
			LoggerUtil.log_type_error("Method:navAnnouncement, Error MSG :" + e.getMessage());
		}
		
	}
	/*==============================================================
	Method Name 	: getCurrentMonthYear
	Description		: To get current Month anme and year
	Author 			: Vivek Kumar
	Creation Date 	: 01/28/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	
	public void getCurrentMonthYear(String Month_Name)
	{
		String[] monthName = {"Jan", "Feb",
	            "Mar", "Apr", "May", "Jun", "Jul",
	            "Aug", "Sep", "Oct", "Nov",
	            "Dec"};
	 
	        Calendar cal = Calendar.getInstance();
	        String month = monthName[cal.get(Calendar.MONTH)];
	        int year = Calendar.getInstance().get(Calendar.YEAR);
	        String systemCalenderValue=month + " "  + year;
	        if(WebObjectUtil.compareString(Month_Name, systemCalenderValue, true) )
	        {
	        	LoggerUtil.log_type_info("Current Month  not verified");
	        }
	        else
	        {
	        	LoggerUtil.log_type_error("Current Month  not verified ");
	        }
	}
	
//_____________________ Gideon TestCase _________________________________________//
	
	/*==============================================================
	TestScript  	: navValPrivateCldAnnouncement
	Manual TestCase	: CPPOC-3094-Private Cloud_Announcements
	Description		: Private Cloud_Announcements
	Author 			: Vivek Kumar
	Creation Date 	: 08/25/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=24)
	public void navValPrivateCldAnnouncement()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		
		PageFactory.initElements(driver, announcement);
		
		boolean bStatus;
	
		
		FrameworkUtil.sTestCaseName = "Gideon-navValPrivateCldAnnouncement";
		FrameworkUtil.sManualTestCaseName=" CPPOC-3094-Private Cloud_Announcements";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);

		String sUserName,sPassword;
		
		sUserName = (String) FrameworkUtil.dictPropertyData.get("NAV.TSTDEVCO1.TSTMAX02LASTT.USERID");
		sPassword = (String) FrameworkUtil.dictPropertyData.get("NAV.TSTDEVCO1.TSTMAX02LASTT.PASSWORD");
		
		LoginTestCase.nav_Login(sUserName, sPassword);
		//Verifying the Announcement image
		bStatus=WebObjectUtil.verifyElementPresent(announcement.getNav_AnnouncementWithoutNewTextImg());
		FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, " Announcement image without 'NEW' text");
		//Clicking and verifying Anouncement landing page
		WebObjectUtil.clickAndVerifyElement(announcement.getNav_AnnouncementPortletLnk(), announcement.getNav_AnnouncementCalendarBtn());
		WebObjectUtil.clickElement(announcement.getNav_AnnouncementCalendarBtn());
		
		//
		String sMonthName,sMonthYear,sAnnouncementDate,sDate,sTitle,sDetail;
		int iActualDate,iExpectedDate;
		
		//get current month name from application
		 sMonthName = announcement.getNav_CurrentMonth().getText();
		//getting Month year from properties file
		 sMonthYear = (String)FrameworkUtil.dictPropertyData.get("NAV.GIDEON.ANNOUNCEMENT.MONTHYEAR");
		//clicking backward month arrow till it match with sMonthYear
		while(!sMonthName.equalsIgnoreCase(sMonthYear))
		{
			//System.out.println(sMonthName);
			WebObjectUtil.clickElement(announcement.getNav_BackwardMonthArrow());
			sMonthName = announcement.getNav_CurrentMonth().getText();
		}
		
		//fetching announcement date from application
		 sAnnouncementDate=announcement.getNav_AnnouncementDate().getText();
		//fetching date from properties file
		 sAnnouncementDate= (String)FrameworkUtil.dictPropertyData.get("NAV.GIDEON.ANNOUNCEMENT.DATE");
		//comparing sAnnouncementDate and sDate 
		if(WebObjectUtil.compareString(sAnnouncementDate, sAnnouncementDate, true))
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify 17th as date", "pass", "");
			WebObjectUtil.MouseHover(announcement.getNav_AnnouncementDate());
			WebObjectUtil.clickElement(announcement.getNav_AnnouncementDate());
			//Verifying Announcement for sAnnouncementDate
			bStatus=WebObjectUtil.verifyElementPresent(announcement.getNav_AnnuncementTitle());
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Verifying Announcement with title -" + announcement.getNav_AnnuncementTitle().getText());
			//WebObjectUtil.verifyElementPresent(announcement.getNav_Annuncement2());
			WebTableUtil.printEachCellText(announcement.getNav_AnnouncementTable());
			
			//Verifying Title format
			sTitle=WebTableUtil.getCellData(announcement.getNav_AnnouncementTable(), 1, 1);
			bStatus=sTitle.contains("Title");
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Verifying "+sTitle);
			//Verifying date
			sDate=WebTableUtil.getCellData(announcement.getNav_AnnouncementTable(), 2, 1);
			bStatus=sDate.contains("Date");
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Verifying "+sDate);
			//Verifying details
			sDetail=WebTableUtil.getCellData(announcement.getNav_AnnouncementTable(), 3, 1);
			bStatus=sDetail.contains("Detail");
			FrameworkUtil.updateCustomResultBasedOnStatus(bStatus, "Verifying "+sDetail);
			//Verifying date 
		
			sDate=WebTableUtil.getCellData(announcement.getNav_AnnouncementTable(), 2, 2);
			Date dDate=WebObjectUtil.convertStringToDate(sDate, "yyyy-MM-dd HH:mm");
			iActualDate=dDate.getDate();
			iExpectedDate=Integer.parseInt(sAnnouncementDate);
			if(iActualDate==iExpectedDate)
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verifying announcement date", "pass", sDate);
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verifying announcement date", "fail", sDate);
			}
			
			
			
		}
		else
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Verify 17th as date", "fail", "");
			LoggerUtil.log_type_error("date 17  not verified ");
		}
		//Logging out from Navigator application
		LoginTestCase.nav_Logout();
		
	}
	
//_____________________ Completed GideonTestCases  ________________________________//
	
	
	
	//update each @test result in custom result file
	@AfterMethod
	public static void afterEachMethod(){
		FrameworkUtil.updateTestCaseStatusinResult();
		
	}
	
		
	
}
