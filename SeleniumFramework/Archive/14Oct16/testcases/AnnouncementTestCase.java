package com.whs.navigator.testcases;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.CustomWebElementUtil;
import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.commonUtil.WebTableUtil;
import com.whs.navigator.pagefactory.AnnouncementPageFactory;
import com.whs.navigator.pagefactory.CommonPageFactory;
import com.whs.navigator.pagefactory.EntityBrowserPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.LogViewerPageFactory;
import com.whs.navigator.pagefactory.UserPermissionMultiOrgPageFactory;

public class AnnouncementTestCase {
	
			 public static HomePageFactory_old Home = new HomePageFactory_old();
			 public static AnnouncementPageFactory Announcement = new AnnouncementPageFactory();
			 public static EntityBrowserPageFactory EBPanel = new EntityBrowserPageFactory();
			 public static UserPermissionMultiOrgPageFactory UPMultiOrg = new UserPermissionMultiOrgPageFactory();
			 public static CommonPageFactory Common = new CommonPageFactory();
             public static LogViewerPageFactory Logviewer = new LogViewerPageFactory();
             
/*==============================================================
TestScript  	: verifyEBGrayedClickAddNewAnnouncement
Manual TestCase	: [QAT-620] WCP_4528_TC_1.0_Announcement_Page should grayed out when add new announcement box appears.
Description		: Verify the page is grayed out including Entity Browser footer when +Add new announcement box is displayed.
Author 			: QAA03
Creation Date 	: 02/09/2016
Release Name    : LefCourt-SP2
Pre-Requisites	:
Revision History:
==============================================================*/
	
@Test(priority=1)
public void verifyEBGrayedClickAddNewAnnouncement()
{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,Home);
				PageFactory.initElements(driver,Announcement);
				PageFactory.initElements(driver,EBPanel);
				String sEBfooterDisabled=null;
			
			
			try {
				FrameworkUtil.sTestCaseName = "verifyEBGrayedClickAddNewAnnouncement";
				FrameworkUtil.sManualTestCaseName="[QAT-620] WCP_4528_TC_1.0_Announcement_Page should grayed out when add new announcement box appears.";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
				
			    //Login to navigator with ARoleA user
				//LoginTestCase.LoginAsATestAUser();
				LoginTestCase_Old1.LoginAsARoleAUser();
				
				//Navigating to Announcement Page
				navAnnouncementPage();
								
				WebObjectUtil.verifyElementPresent(Announcement.getNav_AddNewAnnouncementLink());
				
				WebObjectUtil.clickElement(Announcement.getNav_AddNewAnnouncementLink());
				WebObjectUtil.verifyElementPresent(Announcement.getNav_AddNewAnnouncementWindow());
				
				//Verifying EB Panel grayed out after clicking add new announcement
				sEBfooterDisabled=EBPanel.getNav_EntityBrowserLink().getAttribute("class");
				if(sEBfooterDisabled.contains("disabledFooter"))
					FrameworkUtil.updateCustomResultBasedOnStatus(true,  "EB Footer grayed out after clicking add new announcement as expected");
				else
					FrameworkUtil.updateCustomResultBasedOnStatus(false,  "EB Footer still enabled after clicking add new announcement");
				
				//Logout from Navigator
				LoginTestCase_Old1.nav_Logout();
			
			   } catch (Exception e) {
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyEBGrayedClickAddNewAnnouncement", "warn", "catch block:" +e.getMessage());
		}
	}
/*==============================================================
TestScript  	: verifyAnnouncementsfieldsforSelectedOrgs
Manual TestCase	: [QAT-425,420] WCP_1523_TC_2.1_Announcements:Multiorg/Hosted solutions_Home page_Announcement portlet.
Description		: Verify the announcement portlet on Home page for multiorg user and hosted solutions user.
Author 			: QAA03
Creation Date 	: 02/09/2016
Release Name    : LefCourt-SP2
Pre-Requisites	:
Revision History:
==============================================================*/
			
@Test(priority=2)
public void verifyAnnouncementsfieldsforSelectedOrgs()
{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,UPMultiOrg);
				String sOrg1ToSelect=null,sOrg2ToSelect=null;
		
				
		  try {
				FrameworkUtil.sTestCaseName = "verifyAnnouncementsfieldsforSelectedOrgs";
				FrameworkUtil.sManualTestCaseName="[QAT-425,420] WCP_1523_TC_2.1_Announcements:Multiorg/Hosted solutions_Home page_Announcement portlet.";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					
				sOrg1ToSelect =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
				sOrg2ToSelect =(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME1");
					
				//Login to navigator with Qaauto-M user
				LoginTestCase_Old1.LoginAsQaautoMMultiOrgUser();
									
				//Selecting organization from drop down
				WebObjectUtil.selectWebList(UPMultiOrg.getNav_MOrg_SelectOrg(), sOrg1ToSelect, null, 0);
						 			   
				WebObjectUtil.clickElement(UPMultiOrg.getNav_MOrg_UsethisOrgButton());
								   
				WebObjectUtil.explicitWait(2);
				//HomeTestCase.nav_WindStreamToTierPointHomePopup();
				
				//Verifying Announcements carousel-items
				verifyAnnouncementsFieldsforOrg();
				
				//Selecting organization from top drop down
				UserPermissionMultiOrgTestCase.selectOrgnameInOrgSelector(sOrg2ToSelect);
				
				//Verifying Announcements carousel-items
				verifyAnnouncementsFieldsforOrg();
								    
				//Logout from Navigator
				LoginTestCase_Old1.nav_Logout();
									
				//Login to navigator with Role A user
				LoginTestCase_Old1.LoginAsRoleAUser();
				
				//Verifying Announcements carousel-items
				verifyAnnouncementsFieldsforOrg();
									
				//Logout from Navigator
				LoginTestCase_Old1.nav_Logout();
				
			} catch (Exception e) {
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAnnouncementsfieldsforSelectedOrgs", "warn", "catch block:" +e.getMessage());
				}
}
/*==============================================================
TestScript  	: verifyAnnouncementCreatedinViewcalendarAndViewboard
Manual TestCase	: [QAT-556][555][554][416][401][196][194][193[192][808][784][667][689] WCP_4534_TC_1.0_Announcements_Appear in readable format on landing page.
Description		: Verify the announcement appear in readable format in the portlet on landing page.
Author 			: QAA03
Creation Date 	: 02/10/2016
Release Name    : LefCourt-SP2/Matheson
Pre-Requisites	:
Revision History: Commented the script as the functionality changed the detail menu is removed
==============================================================*/

//@Test(priority=12)
public void verifyAnnouncementCreatedinViewcalendarAndViewboard()
{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,Home);
				PageFactory.initElements(driver,Announcement);
				
				String sAnnouncementDate=null,sAnnouncementTitle=null,sAnnouncementDetail=null,sAnnhyperlinkDetail=null,sTommorrowDate=null;
				String sCategory=null,sSubCategory=null;
				WebElement wTommorrowDate;
				int iColumnIndex=0,iRowCount=0;
	
	
		try {
				FrameworkUtil.sTestCaseName ="verifyAnnouncementCreatedinViewcalendarAndViewboard";
				FrameworkUtil.sManualTestCaseName="[QAT-556][555][554][416][401][196][194][193[192][808][784][667][689]"+ "/n"+" WCP_4534_TC_1.0_Announcements_Appear in readable format on landing page.";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
				sAnnouncementTitle = (String)FrameworkUtil.dictPropertyData.get("NAV.AUTOMATION.TEXT");
				sAnnouncementDate = (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.DATE");
				sAnnouncementDetail = (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.DETAIL");
				sAnnhyperlinkDetail =(String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.HYPERLINKDETAILTEXT");
			    sAnnouncementTitle = sAnnouncementTitle + FrameworkUtil.sTimeStamp;
				sAnnouncementDetail = sAnnouncementTitle + sAnnouncementDetail;
				
				sCategory = (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.DCCATEGORY");
				sSubCategory = (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.DCSUBCATEGORY");
				
				//sAnnouncementTitle ="SeleniumTest20160713_015304";	
				//sAnnouncementDetail="SeleniumTest20160601_212604www.google.com";
				//Login to navigator with ARole-A user
				//LoginTestCase.LoginAsATestAUser();
				LoginTestCase_Old1.LoginAsARoleAUser();
					
				//Navigating to Announcement Page	
				navAnnouncementPage();
									
				WebObjectUtil.verifyElementPresent(Announcement.getNav_AddNewAnnouncementLink());
				
				//Getting tomorrow date
				sTommorrowDate=getTommorrowDate();
				
				//Adding new announcement with detail field
				validateAddNewAnnouncementwithDetailField(sTommorrowDate,sAnnouncementTitle,sAnnouncementDetail,sCategory,sSubCategory);
					
				WebDriverUtil.refreshBrowser();
				
			    //sAnnouncementDate="11/21/2016";
					
				WebObjectUtil.explicitWait(3);
				
			    verifyAnnouncementPDFAndCSVLink();
			
			    //Navigating to View Calendar Page
				WebObjectUtil.clickElement(Announcement.getNav_AnnouncementViewCalendarOrBoardLink());
				WebObjectUtil.explicitWait(2);
				WebObjectUtil.verifyElementPresent(Announcement.getNav_AnnouncementViewCalendarPage());  
				
				//Verifying announcement in view calendar page
				verifyAnnouncementonCreatedDateinViewcalendar(sTommorrowDate,sAnnouncementTitle,sAnnouncementDetail);
			
				WebObjectUtil.scrollElementAtPageCenter(Announcement.getNav_AnnouncementViewCalendarOrBoardLink());
				
				
				//Navigating to View Board Page
				WebObjectUtil.clickElement(Announcement.getNav_AnnouncementViewCalendarOrBoardLink());
				WebObjectUtil.explicitWait(2);
				WebObjectUtil.verifyElementPresent(Announcement.getNav_AnnouncementViewBoardPage());  
				
				//Verifying announcement on view board page
				verifyAnnouncementonCreatedDateonviewBoard(sTommorrowDate,sAnnouncementTitle,sAnnouncementDetail,sAnnhyperlinkDetail);
				
											
				//Logout from Navigator
				LoginTestCase_Old1.nav_Logout();
	
	       } catch (Exception e) {
		        LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
		        FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAnnouncementCreatedinViewcalendarAndViewboard", "warn", "catch block:" +e.getMessage());
	 }
}		

/*==============================================================
TestScript  	: verifyAnnouncementwithLongerDetailTextinViewBoard
Manual TestCase	: [QAT-553][689] if a longer announcement is displaying, verify the text is fully cleared out and user is able to see the next announcement correctly without text overlapping on previous announcement
Description		: Verifying longer Detail announcement on view board page
Author 			: QAA03
Creation Date 	: 02/10/2016
Release Name    : LefCourtSP2/Matheson
Pre-Requisites	:
Revision History:
==============================================================*/

@Test(priority=4)
public void verifyAnnouncementwithLongerDetailTextinViewBoard()
{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,Home);
				PageFactory.initElements(driver,Announcement);
				
				String sAnnouncementDate=null,sAnnouncementTitle=null,sAnnouncementDetail=null,sCategory=null,sSubCategory=null;
				WebElement wTommorrowDate;
				int iColumnIndex=0,iRowCount=0;
	
	
		try {
				FrameworkUtil.sTestCaseName ="verifyAnnouncementwithLongerDetailTextinViewBoard";
				FrameworkUtil.sManualTestCaseName="[QAT-553][689] if a longer announcement is displaying, verify the text is fully cleared out and user is able to see the next announcement correctly without text overlapping on previous announcement.";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
				sAnnouncementTitle = (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.EXISTINGTITLE.TEXT");
				sAnnouncementDate = (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.DATE");
				sAnnouncementDetail = (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.DETAIL.LONGERTEXT");
				
				sCategory = (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.DCCATEGORY");
				sSubCategory = (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.DCSUBCATEGORY");
				
				//sAnnouncementTitle = sAnnouncementTitle + FrameworkUtil.sTimeStamp;
				//sAnnouncementTitle="SeleniumTest20160308_085310";
				
				//Login to navigator with ARoleA user
				//LoginTestCase.LoginAsATestAUser();
				LoginTestCase_Old1.LoginAsARoleAUser();
					
				//Navigating to Announcement Page	
				navAnnouncementPage();
									
				WebObjectUtil.verifyElementPresent(Announcement.getNav_AddNewAnnouncementLink());
					
				//validateAddNewAnnouncementwithLongerdetailsText(sAnnouncementDate,sAnnouncementTitle,sAnnouncementDetail,sCategory,sSubCategory);
				
				
				//WebDriverUtil.refreshBrowser();
				
				//Verifying longer Detail announcement on view board page
			   	verifyAnnouncementonCreatedDateonviewBoard(sAnnouncementDate,sAnnouncementTitle,sAnnouncementDetail,"");
			 				
				//Logout from Navigator
				LoginTestCase_Old1.nav_Logout();
	
	       } catch (Exception e) {
		        LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
		        FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAnnouncementwithLongerDetailTextinViewBoard", "warn", "catch block:" +e.getMessage());
	 }
}		
/*==============================================================
TestScript  	: verifyCreatedAnnouncementonHomepage
Manual TestCase	: [QAT-553][556][416][401][196][689][667] verify the announcement text and is fully cleared out and user is able to see the next announcement correctly without text overlapping on previous announcement on home page
Description		: Verifying announcement by clicking on dots in home page
Author 			: QAA03
Creation Date 	: 03/08/2016
Release Name    : LefCourtSP2/Matheson
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=5)
public static void verifyCreatedAnnouncementonHomepage()
{
				   WebDriver driver = WebDriverUtil.getDriver();
				   PageFactory.initElements(driver,Announcement);
				   PageFactory.initElements(driver,Home);
				   String sAnnouncementDetail=null;
				   
			 try {
				    FrameworkUtil.sTestCaseName ="verifyCreatedAnnouncementonHomepage";
					FrameworkUtil.sManualTestCaseName="[QAT-553][556][416][401][196][689] verify the announcement text and is fully cleared out and user is able to see the next announcement correctly without text overlapping on previous announcement on home page.";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					
				   sAnnouncementDetail=(String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.DETAIL.LONGERTEXT");
				   
				   //Login to navigator with ARole-A user
				   LoginTestCase_Old1.LoginAsARoleAUser();
					
				   //WebObjectUtil.ClickAndMouseHover(Home.getNav_MonitoringTab());
				   WebObjectUtil.clickElement(Home.getNav_MonitoringTab());
				   WebObjectUtil.clickElement(Home.getNav_SummaryViewMenuLink());
				   WebObjectUtil.explicitWait(5);
				   
				   //Verifying the announcement on home page
				   verifyAnnouncementinHomePage(sAnnouncementDetail);
				   
				   //Logout from Navigator
				   LoginTestCase_Old1.nav_Logout();
				    
				  //Login to navigator with qaauto-A user
				   LoginTestCase_Old1.LoginAsQaautoAUser();
						
				  //WebObjectUtil.ClickAndMouseHover(Home.getNav_MonitoringTab());
				   WebObjectUtil.clickElement(Home.getNav_MonitoringTab());
				   WebObjectUtil.clickElement(Home.getNav_SummaryViewMenuLink());
				   WebObjectUtil.explicitWait(5);
				   
				   //Verifying the announcement on home page
				   verifyAnnouncementinHomePage(sAnnouncementDetail);
					   
			      //Logout from Navigator
				   LoginTestCase_Old1.nav_Logout();
					    
				  //Login to navigator with qaauto-C user
				   LoginTestCase_Old1.LoginAsQaautoCUser();
							
				   //WebObjectUtil.ClickAndMouseHover(Home.getNav_MonitoringTab());
				   WebObjectUtil.clickElement(Home.getNav_MonitoringTab());
				   WebObjectUtil.clickElement(Home.getNav_SummaryViewMenuLink());
				   WebObjectUtil.explicitWait(5);
				   
				   //Verifying the announcement on home page
				   verifyAnnouncementinHomePage(sAnnouncementDetail);
						   
				  //Logout from Navigator
			       LoginTestCase_Old1.nav_Logout();
				   
				
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyCreatedAnnouncementonHomepage", "warn", "catch block:" +e.getMessage());
	 }
}

/*==============================================================
TestScript  	: verifyPDFAndCSVLinksinAnnouncementPageForDiffUsers
Manual TestCase	: [QAT-191,5][QAT-781,783]WCP_2387_TC_2.0_Announcements_Calendar View_Export to PDF and CSV.
Description		: Verifying PDF and CSV links
Author 			: QAA03
Creation Date 	: 04/04/2016
Release Name    : LefCourtSP2/Matheson
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=6)
public static void verifyPDFAndCSVLinksinAnnouncementPageForDiffUsers()
{
				   WebDriver driver = WebDriverUtil.getDriver();
				   PageFactory.initElements(driver,Announcement);
				   PageFactory.initElements(driver,Home);
				   PageFactory.initElements(driver,UPMultiOrg);
				   String sOrgName=null;
				   
				   
			 try {
				    FrameworkUtil.sTestCaseName ="verifyPDFAndCSVLinksinAnnouncementPageForDiffUsers";
					FrameworkUtil.sManualTestCaseName="[QAT-191,5][QAT-781,783] WCP_2387_TC_2.0_Announcements_Calendar View_Export to PDF and CSV.";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					
					sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
				   
				    //Login to navigator with ARole-A user
				    LoginTestCase_Old1.LoginAsARoleAUser();
					
				   //Navigating to Announcement Page
				    navAnnouncementPage();
					
					//Verifying PDF and CSV links 
					verifyAnnouncementPDFAndCSVLink();
				
				    //Logout from Navigator
				    LoginTestCase_Old1.nav_Logout();
				    
				    //Login to navigator with qaauto user
				    LoginTestCase_Old1.LoginAsQaautoUser();
					
				    //Navigating to Announcement Page
				    navAnnouncementPage();
					
					//Verifying PDF and CSV links					
					verifyAnnouncementPDFAndCSVLink();
				
				    //Logout from Navigator
				    LoginTestCase_Old1.nav_Logout();
				    
				    //Login to Navigator with QaautoM user
					LoginTestCase_Old1.LoginAsQaautoMMultiOrgUser();
					
					//Selecting the Organization from drop down
					WebObjectUtil.selectWebList(UPMultiOrg.getNav_MOrg_SelectOrg(),null, null, 1);
					WebObjectUtil.clickElement(UPMultiOrg.getNav_MOrg_UsethisOrgButton());
					WebObjectUtil.explicitWait(5);
					//HomeTestCase.nav_WindStreamToTierPointHomePopup();
					
					//Navigating to Announcement Page
					navAnnouncementPage();
					
					//Verifying PDF and CSV links
					verifyAnnouncementPDFAndCSVLink();
					
					UserPermissionMultiOrgTestCase.selectOrgnameInOrgSelector(sOrgName);
					
					//Verifying PDF and CSV links
					verifyAnnouncementPDFAndCSVLink();
					
					//Logout from Navigator
					LoginTestCase_Old1.nav_Logout();
				
				
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyPDFAndCSVLinksinAnnouncementPageForDiffUsers", "warn", "catch block:" +e.getMessage());
	 }
}
/*==============================================================
TestScript  	: verifyViewCalendarDisplayforAnnouncement
Manual TestCase	: [QAT-691][67][12][10] WCP_4644_TC_1.0_Announcements: Calendar view display in FireFox
Description		: 
Author 			: QAA03
Creation Date 	: 04/12/2016
Release Name    : Matheson
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=7)
public static void verifyViewCalendarDisplayforAnnouncement()
{
				   WebDriver driver = WebDriverUtil.getDriver();
				   PageFactory.initElements(driver,Announcement);
				   PageFactory.initElements(driver,Home);
				   String sCurrentDate=null,sCurrentDay=null,sAnnouncementTitle=null,sAnnouncementDate,sAnnouncementDetail;
				   String sDate[];
				   
			 try {
				    FrameworkUtil.sTestCaseName ="verifyViewCalendarDisplayforAnnouncement";
					FrameworkUtil.sManualTestCaseName="[QAT-691][67][12][10] WCP_4644_TC_1.0_Announcements: Calendar view display in FireFox";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					
					sAnnouncementTitle = (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.EXISTINGTITLE.TEXT");
					sAnnouncementDate = (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.DATE");
					sAnnouncementDetail=(String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.DETAIL.LONGERTEXT");
					
				    //Login to navigator with ARole-A user
				    LoginTestCase_Old1.LoginAsARoleAUser();
				
				    //Navigating to Announcement Page
				    navAnnouncementPage();
					
					//Navigating to View Calendar Page
					WebObjectUtil.clickElement(Announcement.getNav_AnnouncementViewCalendarOrBoardLink());
					WebObjectUtil.explicitWait(2);
					WebObjectUtil.verifyElementPresent(Announcement.getNav_AnnouncementViewCalendarPage());
					
					//Getting current date as string in MM/dd/yyyy format
					sCurrentDate = getCurrentDate();
					
					//Verifying current day is outlined in calendar of announcement page
					verifyAnnouncementCurrentDayinViewCalendar(sCurrentDate);
					
					//Verifying announcement in view calendar page
					verifyAnnouncementonCreatedDateinViewcalendar(sAnnouncementDate, sAnnouncementTitle, sAnnouncementDetail);
				
					WebObjectUtil.scrollElementAtPageCenter(Announcement.getNav_AnnouncementViewCalendarOrBoardLink());
					
					//Navigating to View Board Page
					WebObjectUtil.clickElement(Announcement.getNav_AnnouncementViewCalendarOrBoardLink());
					WebObjectUtil.explicitWait(2);
					WebObjectUtil.verifyElementPresent(Announcement.getNav_AnnouncementViewBoardPage());
				   
				    //Logout from Navigator
				    LoginTestCase_Old1.nav_Logout();
				   
				
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyViewCalendarDisplayforAnnouncement", "warn", "catch block:" +e.getMessage());
	 }
}
/*==============================================================
TestScript  	: verifyAnninViewCalendarAndViewBoardForDifferentUsers
Manual TestCase	: [QAT-416][401][196][808] WCP_3758_TC_1.1_Add sku in EM7 for the org_Add new Announcement with hyperlink_Login and verify. 
Description		: 
Author 			: QAA03
Creation Date 	: 04/12/2016
Release Name    : LefCourtSP2/Matheson
Pre-Requisites	:
Revision History:
==============================================================*/

@Test(priority=8)
public void verifyAnninViewCalendarAndViewBoardForDifferentUsers()
{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,Home);
				PageFactory.initElements(driver,Announcement);
				
				String sAnnouncementDate=null,sAnnouncementTitle=null,sAnnouncementDetail=null;
				WebElement wTommorrowDate;
				int iColumnIndex=0,iRowCount=0;
	
	
		try {
				FrameworkUtil.sTestCaseName ="verifyAnninViewCalendarAndViewBoardForDifferentUsers";
				FrameworkUtil.sManualTestCaseName="[QAT-416][401][196][808] WCP_3758_TC_1.1_Add sku in EM7 for the org_Add new Announcement with hyperlink_Login and verify";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
				sAnnouncementTitle = (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.EXISTINGTITLE.TEXT");
				sAnnouncementDate = (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.DATE");
				sAnnouncementDetail = (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.DETAIL.LONGERTEXT");
				
				
				
				//Login to navigator with qaauto-A user
				LoginTestCase_Old1.LoginAsQaautoAUser();
					
				//Navigating to Announcement Page	
				navAnnouncementPage();
								
				//Verifying longer Detail announcement on view board page
			   	verifyAnnouncementonCreatedDateonviewBoard(sAnnouncementDate,sAnnouncementTitle,sAnnouncementDetail,"");
			   	
			    //Navigating to View Calendar Page
				WebObjectUtil.clickElement(Announcement.getNav_AnnouncementViewCalendarOrBoardLink());
				WebObjectUtil.explicitWait(2);
				WebObjectUtil.verifyElementPresent(Announcement.getNav_AnnouncementViewCalendarPage());
			
				verifyAnnouncementonCreatedDateinViewcalendar(sAnnouncementDate, sAnnouncementTitle,sAnnouncementDetail);
			 				
				//Logout from Navigator
				LoginTestCase_Old1.nav_Logout();
				
				//Login to navigator with qaauto-C user
				LoginTestCase_Old1.LoginAsQaautoCUser();
					
				//Navigating to Announcement Page	
				navAnnouncementPage();
								
				//Verifying longer Detail announcement on view board page
			   	verifyAnnouncementonCreatedDateonviewBoard(sAnnouncementDate,sAnnouncementTitle,sAnnouncementDetail,"");
			   	
			    //Navigating to View Calendar Page
				WebObjectUtil.clickElement(Announcement.getNav_AnnouncementViewCalendarOrBoardLink());
				WebObjectUtil.explicitWait(2);
				WebObjectUtil.verifyElementPresent(Announcement.getNav_AnnouncementViewCalendarPage());
			
				verifyAnnouncementonCreatedDateinViewcalendar(sAnnouncementDate, sAnnouncementTitle,sAnnouncementDetail);
			 				
				//Logout from Navigator
				LoginTestCase_Old1.nav_Logout();
	
	       } catch (Exception e) {
		        LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
		        FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAnninViewCalendarAndViewBoardForDifferentUsers", "warn", "catch block:" +e.getMessage());
	 }
}

/*==============================================================
TestScript  	: verifyAnnouncementPageForDiffUsers
Manual TestCase	: [QAT-190][8][9] WCP_1523_TC_1.3_Announcements_multiorg_Board View
Description		: 
Author 			: QAA03
Creation Date 	: 04/13/2016
Release Name    : LefCourtSP2
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=9)
public static void verifyAnnouncementPageForDiffUsers()
{
				   WebDriver driver = WebDriverUtil.getDriver();
				   PageFactory.initElements(driver,Announcement);
				   PageFactory.initElements(driver,UPMultiOrg);
				   String sOrgName=null;
				   
				   
			 try {
				    FrameworkUtil.sTestCaseName ="verifyAnnouncementPageForDiffUsers";
					FrameworkUtil.sManualTestCaseName="[QAT-190][8][9]WCP_1523_TC_1.3_Announcements_multiorg_Board View.";
					FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
					
					sOrgName=(String)FrameworkUtil.dictPropertyData.get("NAV.USER.MULTORG.ORG.NAME2");
				   
				    //Login to navigator with ARole-A user
				    LoginTestCase_Old1.LoginAsARoleAUser();
					
				    navAnnouncementPage();
					
					WebObjectUtil.verifyElementPresent(Announcement.getNav_AddNewAnnouncementLink());
					
				
				    //Logout from Navigator
				    LoginTestCase_Old1.nav_Logout();
				    
				    //Login to navigator with ARole-A user
				    LoginTestCase_Old1.LoginAsQaautoAUser();
					
				    navAnnouncementPage();
					
					WebObjectUtil.verifyElementNOTPresent(Announcement.getNav_AddNewAnnouncementLink());
				
				    //Logout from Navigator
				    LoginTestCase_Old1.nav_Logout();
				    
				    //Login to Navigator with QaautoM user
					LoginTestCase_Old1.LoginAsQaautoMMultiOrgUser();
					
					//Selecting the Organization from drop down
					WebObjectUtil.selectWebList(UPMultiOrg.getNav_MOrg_SelectOrg(),null, null, 1);
					WebObjectUtil.clickElement(UPMultiOrg.getNav_MOrg_UsethisOrgButton());
					WebObjectUtil.explicitWait(5);
					//HomeTestCase.nav_WindStreamToTierPointHomePopup();
					
					navAnnouncementPage();
					
					WebObjectUtil.verifyElementNOTPresent(Announcement.getNav_AddNewAnnouncementLink());
					
					UserPermissionMultiOrgTestCase.selectOrgnameInOrgSelector(sOrgName);
					
                    WebObjectUtil.explicitWait(5);
					
					WebObjectUtil.verifyElementNOTPresent(Announcement.getNav_AddNewAnnouncementLink());
					
					//Logout from Navigator
					LoginTestCase_Old1.nav_Logout();
					
				   
				
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAnnouncementPageForDiffUsers", "warn", "catch block:" +e.getMessage());
	 }
}
/*==============================================================
TestScript  	: verifyAnnouncementCreatedwithoutEmail
Manual TestCase	: [QAT-1357][1456] WCP_4655_TC_1.0_Announcements_improve Sku searching and without entering email address
Description		: 
Author 			: QAA03
Creation Date 	: 04/20/2016
Release Name    : Talon
Pre-Requisites	:
Revision History:
==============================================================*/
@Test(priority=10)
public void verifyAnnouncementCreatedwithoutEmail()
{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,Home);
				PageFactory.initElements(driver,Announcement);
				
				String sAnnouncementDate=null,sAnnouncementTitle=null,sTommorrowDate=null,sCategory=null,sSubCategory=null,sEmail=null;
				String sCategoryText1=null,sCategoryText2=null,sCurrentDate=null;
	
	
		try {
				FrameworkUtil.sTestCaseName ="verifyAnnouncementCreatedwithoutEmail";
				FrameworkUtil.sManualTestCaseName="[QAT-1357][1456] WCP_4655_TC_1.0_Announcements_improve Sku searching and without entering email address";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
				sAnnouncementTitle = (String)FrameworkUtil.dictPropertyData.get("NAV.AUTOMATION.TEXT");
				sAnnouncementDate = (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.DATE");
				sAnnouncementTitle = sAnnouncementTitle + FrameworkUtil.sTimeStamp;
				
				sCategory = (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.STORAGECATEGORY");
				sSubCategory = (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.STORAGESUBCATEGORY");
				
				
				sCategoryText1=(String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.CATEGORYTEXT1");
				sCategoryText2=(String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.CATEGORYTEXT2");
				
								    
				//Login to navigator with ARole-A user
				LoginTestCase_Old1.LoginAsARoleAUser();
					
				//Navigating to Announcement Page	
				navAnnouncementPage();
									
				WebObjectUtil.verifyElementPresent(Announcement.getNav_AddNewAnnouncementLink());
				
				//Clicking on Add New Announcement Link
			    WebObjectUtil.clickElement(Announcement.getNav_AddNewAnnouncementLink());
			    WebObjectUtil.verifyElementPresent(Announcement.getNav_AddNewAnnouncementWindow());
				
				sTommorrowDate=getTommorrowDate();
				
				//Searching the Category list by entering the text -"nter"
				searchCategoryofAnnouncementbyEnteringText(sCategoryText1);
				
				//Searching the Category list by entering the text -"de"
				searchCategoryofAnnouncementbyEnteringText(sCategoryText2);
				
				//Adding new announcement with Date,Title and Category
				validateAddNewAnnouncementwithEmailField(sTommorrowDate,sAnnouncementTitle,sCategory,sSubCategory,sEmail);
									
				//Getting current date as string MM/dd/yyyy format
				sCurrentDate = getCurrentDate();
				
				//Navigating to Log Viewer Page
				navLogViewerPage();
				
				//Verifying Announcement data created with email in log viewer page
				verifyAnnDataThroughEmailLinkinLogViewerPage(sCurrentDate,sAnnouncementTitle,sEmail);
										
				//Logout from Navigator
				LoginTestCase_Old1.nav_Logout();
	
	       } catch (Exception e) {
		        LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
		        FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAnnouncementCreatedwithoutEmail", "warn", "catch block:" +e.getMessage());
	 }
}		
/*==============================================================
TestScript  	: verifyAnnouncementCreatedwithEmail
Manual TestCase	: [QAT-556][555][554][416][401][196][194][193[192][808][784][667][689][1355] WCP_4651_TC_1.0_ Announcement - BCC email list
Description		: 
Author 			: QAA03
Creation Date 	: 04/22/2016
Release Name    : Talon
Pre-Requisites	:
Revision History:
==============================================================*/

@Test(priority=11)
public void verifyAnnouncementCreatedwithEmail()
{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,Home);
				PageFactory.initElements(driver,Announcement);
				
				String sAnnouncementDate=null,sAnnouncementText=null,sTommorrowDate=null,sCategory=null,sSubCategory=null,sEmail=null,sCurrentDate=null;
				
	
	
		try {
				FrameworkUtil.sTestCaseName ="verifyAnnouncementCreatedwithEmail";
				FrameworkUtil.sManualTestCaseName="[QAT-1355] WCP_4651_TC_1.0_ Announcement - BCC email list";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				
				sAnnouncementText= (String)FrameworkUtil.dictPropertyData.get("NAV.AUTOMATION.TEXT");
				
				sAnnouncementText = sAnnouncementText + FrameworkUtil.sTimeStamp;
				
				sCategory = (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.STORAGECATEGORY");
				sSubCategory = (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.STORAGESUBCATEGORY");
				sEmail = (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.EMAIL");
				
				
				//Login to navigator with ARole-A user
				LoginTestCase_Old1.LoginAsARoleAUser();
					
				//Navigating to Announcement Page	
				navAnnouncementPage();
									
				WebObjectUtil.verifyElementPresent(Announcement.getNav_AddNewAnnouncementLink());
				
				//Clicking on Add New Announcement Link
			     WebObjectUtil.clickElement(Announcement.getNav_AddNewAnnouncementLink());
			     WebObjectUtil.verifyElementPresent(Announcement.getNav_AddNewAnnouncementWindow());
			   
				sTommorrowDate=getTommorrowDate();
				//sAnnouncementTitle="SeleniumTest20160713_015304";
				
				//Adding new announcement with Date,Title,Category and Email 
				validateAddNewAnnouncementwithEmailField(sTommorrowDate,sAnnouncementText,sCategory,sSubCategory,sEmail);
				
				WebDriverUtil.refreshBrowser();
				WebObjectUtil.waitForElementPresent(Announcement.getNav_AnnouncementViewCalendarOrBoardLink());
				 //Navigating to View Calendar Page
				WebObjectUtil.clickElement(Announcement.getNav_AnnouncementViewCalendarOrBoardLink());
				WebObjectUtil.explicitWait(4);
				WebObjectUtil.verifyElementPresent(Announcement.getNav_AnnouncementViewCalendarPage());
				
				//Verifying created announcement in View calendar page
				verifyAnnouncementonCreatedDateinViewcalendar(sTommorrowDate, sAnnouncementText,sAnnouncementText);
				
				//Getting current date as string in MM/dd/yyyy format
				sCurrentDate = getCurrentDate();
				
				//Navigating to Log Viewer Page
				navLogViewerPage();
				
				//Verifying Announcement data created with email in log viewer page
				verifyAnnDataThroughEmailLinkinLogViewerPage(sCurrentDate,sAnnouncementText,sEmail);
				
				//Getting current date as string in dd-MMM-yyyy format
				sCurrentDate = getCurrentDateinFormat();
				
				//Verifying Announcement data created with email in index of hosts url
				verifyAnnouncementDatainIndexOfHostsUrl(sCurrentDate, sAnnouncementText, sEmail);
				
				//Logout from Navigator
				LoginTestCase_Old1.nav_Logout();
	
	       } catch (Exception e) {
		        LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
		        FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAnnouncementCreatedwithEmail", "warn", "catch block:" +e.getMessage());
	 }
}

/*====================================================================================================
Method Name 	: navAnnouncementPage
Description		: 
Author 			: QAA03
Creation Date 	: 02/09/2016
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static void navAnnouncementPage()
{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,Announcement);
				PageFactory.initElements(driver, Home);
        try {
        	   WebObjectUtil.clickElement(Home.getNav_SupportTab());
			   WebObjectUtil.clickElement(Announcement.getNav_AnnouncementsMenuLink());
			   WebObjectUtil.explicitWait(5);
			   
	        } catch (Exception e) {
		       // TODO Auto-generated catch block
		       LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
		       FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navAnnouncementPage", "warn", "catch block:" +e.getMessage());  
	}

}
/*====================================================================================================
Method Name 	: verifyAnnouncementsFieldsforOrg
Description		: 
Author 			: QAA03
Creation Date 	: 02/09/2016
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static void verifyAnnouncementsFieldsforOrg()
{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver,Announcement);
				boolean bAnnouncementButton;
         try {
			    WebObjectUtil.verifyElementPresent(Announcement.getNav_AnnouncementsPortlet());
				
				WebObjectUtil.verifyElementPresent(Announcement.getNav_AnnouncementPrevButton());
				WebObjectUtil.verifyElementPresent(Announcement.getNav_AnnouncementNextButton());
				
			    bAnnouncementButton = WebObjectUtil.verifyElementPresent(Announcement.getNav_AnnouncementPauseButton());
			    
			   if(bAnnouncementButton)
			   {
				  WebObjectUtil.clickElement(Announcement.getNav_AnnouncementPauseButton());
				  WebObjectUtil.verifyElementPresent(Announcement.getNav_AnnouncementPlayButton());
			   }
			   else
			   {
				   WebObjectUtil.verifyElementPresent(Announcement.getNav_AnnouncementPlayButton());
				   WebObjectUtil.clickElement(Announcement.getNav_AnnouncementPlayButton());
				   WebObjectUtil.verifyElementPresent(Announcement.getNav_AnnouncementPauseButton());
			   }
	        } catch (Exception e) {
		     // TODO Auto-generated catch block
		      LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
		      FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAnnouncementsFieldsforOrg", "warn", "catch block:" +e.getMessage());  
	}

}

/*====================================================================================================
Method Name 	: validateAddNewAnnouncementwithDetailField
Description		: 
Author 			: QAA03
Creation Date 	: 02/10/2016
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static void validateAddNewAnnouncementwithDetailField(String sAnnouncementDate,String sAnnouncementTitle,String sAnnouncementDetail,String sCategory,String sSubCategory)
{
				    WebDriver driver = WebDriverUtil.getDriver();
				 	PageFactory.initElements(driver,Announcement);
					PageFactory.initElements(driver,Common);
					
					String sULElementXpath=null,sTime=null,sFeedbackpopup=null,sFeedback=null;
					String sAnnhyperlinkDetail=null,sdetailcolor=null;
					boolean bAnnCreatedStatus,bAnnDateenteredStatus;
			 try {
				    sULElementXpath =(String)FrameworkUtil.dictDynamicPagePactory.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.TIME");
				    sTime = (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.TIME");
				    sFeedback = (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.FEEDBACK");
				    sAnnhyperlinkDetail =(String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.HYPERLINKDETAILTEXT");
				    
				    
				    //Clicking on Add New Announcement Link
				    WebObjectUtil.clickElement(Announcement.getNav_AddNewAnnouncementLink());
				    WebObjectUtil.verifyElementPresent(Announcement.getNav_AddNewAnnouncementWindow());
				    
				    //sTommorrowDate = getTommorrowDate();
				    
				    //Entering the date on which announcement need to create
				    WebObjectUtil.SetValueEdit(Announcement.getNav_AddNewAnnouncementDateField(),sAnnouncementDate);
				    WebObjectUtil.explicitWait(2);
				    
				    //Verifying whether valid date entered or not
				    bAnnDateenteredStatus=!Announcement.getNav_AddNewAnnouncementInvalidDateField().isDisplayed();
				      
					FrameworkUtil.updateCustomResultBasedOnStatus(bAnnDateenteredStatus, "Valid Date Entered for Announcement"); 
					   
				    //Entering the time
					WebObjectUtil.clickElement(Announcement.getNav_AddNewAnnouncementTimeIcon());
					WebObjectUtil.selectCustomWebList(Announcement.getNav_AddNewAnnouncementTimeIcon(),sULElementXpath, sTime,0);
					
					//Selecting SKU category and Sub category fields
					selectSkuCategoryAndSubCategoryForAddNewAnnouncement(sCategory,sSubCategory);
					
					//Entering the title for new announcement
					WebObjectUtil.SetValueEdit(Announcement.getNav_AddNewAnnouncementTitle(), sAnnouncementTitle);
					
					//Entering the detail field
					enterDetailinAddNewAnnouncement(sAnnouncementDetail);
					
					//Selecting the detail text for the announcement
					selectAnnouncementDetailenteredtext();
				
					//Increasing the font and changing the color to blue for detail text of announcement
					sdetailcolor = changeAnnouncementDetailFontAndColor();
					
					WebObjectUtil.explicitWait(5);
					   
					Announcement.getNav_AddNewAnnouncementDetailHyperlink().click();
					driver.switchTo().alert().sendKeys(sAnnhyperlinkDetail);
					driver.switchTo().alert().accept();
					
					driver.switchTo().frame(Announcement.getNav_AddNewAnnouncementDetail());
					   
					//Validating the size and color of the detail text of the announcement
					valSizeandColorDetailTextofAnnouncement(sdetailcolor);
					driver.switchTo().parentFrame();
					 
					//Clicking on save button to add new announcement
					WebObjectUtil.clickElement(Announcement.getNav_AddNewAnnouncementSaveButton());
					
					WebObjectUtil.waitForElementPresent(Common.getNav_UsrFeedBack());
					
					//Verifying the feedback message
					sFeedbackpopup = Common.getNav_UsrFeedBack().getText();
					
					bAnnCreatedStatus = sFeedback.equalsIgnoreCase(sFeedbackpopup);
					
					FrameworkUtil.updateCustomResultBasedOnStatus(bAnnCreatedStatus, "Added New Announcement message");
				    
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName ,"validateAddNewAnnouncementwithDetailField", "warn", "catch block:" +e.getMessage());  
				}
		
}
/*====================================================================================================
Method Name 	: getTommorrowDate
Description		: Getting the Next day date
Author 			: QAA03
Creation Date 	: 02/10/2016
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static String getTommorrowDate()
{
					String sTommorrowDate=null;
			 try {
				    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					Date date = new Date();
					
					//int iDay =date.getDate();
					//iDay=iDay+1;
					 //date.setDate(iDay);
					 //sCurrentDate = dateFormat.format(date);
					 Date NextDate = new Date(date.getTime() + 1000 * 60 * 60 * 24);
					 sTommorrowDate = dateFormat.format(NextDate);
					
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "getTommorrowDate", "warn", "catch block:" +e.getMessage());  
				}
			 return sTommorrowDate;

}
/*====================================================================================================
Method Name 	: ChangeDateFormat
Description		: Changing the Date format to yyyyMMdd
Author 			: QAA03
Creation Date 	: 02/10/2016
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static String ChangeDateFormat(String sDate)
{
		
			 try {
				
				    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
					Date date = new Date(sDate);
					
					sDate = dateFormat.format(date);
				
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "ChangeDateFormat", "warn", "catch block:" +e.getMessage());  
				}
			 return sDate;

}

/*====================================================================================================
Method Name 	: getAnnouncementDateindex
Description		: Getting the index of date
Author 			: QAA03
Creation Date 	: 02/16/2016
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static int getAnnouncementDateindex(String sDate)
{
			    WebDriver driver = WebDriverUtil.getDriver();
			    PageFactory.initElements(driver,Announcement);
				String sAnnouncementDateindex=null,sDay=null,sChangedformatdate=null;
				WebElement wAnnouncementDateindex;
				int iColumnindex=1;
		 try {
			    Date date = new Date(sDate);
			    int iDay = date.getDate();
			    sDay = sDay.valueOf(iDay);
			    //Changing the Date format to yyyyMMdd
			    sChangedformatdate =ChangeDateFormat(sDate);
			    for(iColumnindex=1;iColumnindex<=7;iColumnindex++)
			    {
			    	wAnnouncementDateindex = WebObjectUtil.getWebElementFromDynamicLocator("xpath","NAV.ANNOUNCEMENT.VIEWCALENDAR.TEXTPRESENT", "PARAMETER_DATE,PARAMETER_COLUMNINDEX",sChangedformatdate+","+iColumnindex);
			    	sAnnouncementDateindex = wAnnouncementDateindex.getText();
			    	if(sAnnouncementDateindex.contentEquals(sDay))
			    	{
			    		break;
			    	}
			    }
				 
				
			 } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "getAnnouncementDateindex", "warn", "catch block:" +e.getMessage());  
			}
		 
		   return iColumnindex;
}

/*====================================================================================================
Method Name 	: getAnnouncementRows
Description		: Getting the announcements row number in the calendar view
Author 			: QAA03
Creation Date 	: 02/16/2016
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static int getAnnouncementRows(String sDate)
{
			    WebDriver driver = WebDriverUtil.getDriver();
			    PageFactory.initElements(driver,Announcement);
				String sChangedformatdate=null;
				WebElement wAnnouncementRows;
				int iRowCount=0;
				
		 try {
			    //Changing the Date format to yyyyMMdd
			    sChangedformatdate =ChangeDateFormat(sDate);
			    List<WebElement> wRowList = WebDriverUtil.getDriver().findElements(By.xpath("//td[@id='app-calendar-month-ev-day-"+sChangedformatdate+"']//..//..//tr"));
			    iRowCount = wRowList.size();
		 } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "getAnnouncementRows", "warn", "catch block:" +e.getMessage());  
			}
		 
		   return iRowCount;
}
/*====================================================================================================
Method Name 	: verifyAnnouncementonCreatedDateinViewcalendar
Description		: Verifying Created Announcement on view Calendar
Author 			: QAA03
Creation Date 	: 02/16/2016
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static void verifyAnnouncementonCreatedDateinViewcalendar(String sAnnouncementDate,String sAnnouncementTitle,String sAnnouncementDetail)
{
			     WebDriver driver = WebDriverUtil.getDriver();
			     PageFactory.initElements(driver,Announcement);
				 String sChangedformatdate=null,sAnnouncementText=null,sAnnouncementDayText=null,sAnnouncementDay=null;
				 String smonth=null,sAnnouncementExceededDayText=null,sAnnTitleText[];
				 WebElement wAnnouncementDateElement,wExceededAnnouncementbyTen,wAnnouncementExceededTextElement;
				 int iColumnCount=0,iColumnIndex=0,iRowCount=0,iERowCount=0;
				 
 try {
	            
			    Date date = new Date(sAnnouncementDate);
			    int iDay = date.getDate();
			    int month = date.getMonth();
			    //Getting the month in the word format
			    smonth = new DateFormatSymbols().getMonths()[month];
			    //Converting day from int to string
			    sAnnouncementDay = sAnnouncementDay.valueOf(iDay);
			    smonth = smonth.concat(" ").concat(sAnnouncementDay);
			    
			    //Verifying the month and year in view calendar and navigating to respective month and year of announcement need to verified
			    navMonthYearOfAnnouncementDate(sAnnouncementDate);
			    
			   // WebObjectUtil.explicitWait(5);
			     //Changing the Date format to yyyyMMdd
			    sChangedformatdate =ChangeDateFormat(sAnnouncementDate);
			   
			    sAnnTitleText = sAnnouncementTitle.split(" "); 
			    		    
			    iColumnIndex = getAnnouncementDateindex(sAnnouncementDate);
				
				iRowCount = getAnnouncementRows(sAnnouncementDate);
				
				wExceededAnnouncementbyTen = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.ANNOUNCEMENT.VIEWCALENDAR.ANNOUNCEMENTEXCEEDED.LINK", "PARAMETER_DATE",sChangedformatdate);
			
			Outerloop:
			    for(int i=2;i<=iRowCount;i++)
			    {
			    	    List<WebElement> wAnnouncementTextList = WebDriverUtil.getDriver().findElements(By.xpath("//td[@id='app-calendar-month-ev-day-"+sChangedformatdate+"']//..//..//tr["+i+"]/td/div"));
			    	    iColumnCount = wAnnouncementTextList.size();
			    	
			    	
			  	 for (WebElement wAnnouncementTextElement : wAnnouncementTextList )
			      {
			    	  
			    		    sAnnouncementText = wAnnouncementTextElement.getText(); //announcement text
			    		    wAnnouncementDateElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath","NAV.ANNOUNCEMENT.VIEWCALENDAR.TEXTPRESENT","PARAMETER_DATE,PARAMETER_COLUMNINDEX",sChangedformatdate+","+iColumnIndex);
			    	        WebObjectUtil.scrollToElement(wAnnouncementDateElement);
			    		    sAnnouncementDayText = wAnnouncementDateElement.getText();
			    		
			  	      if(sAnnouncementDayText.contentEquals(sAnnouncementDay)||(sAnnouncementDayText.contains("smonth")))
			        {
			    			if(wExceededAnnouncementbyTen!=null)
			    		{
								
				    		WebObjectUtil.clickElement(wExceededAnnouncementbyTen);
				    		
						    //List<WebElement> wAnnouncementTextList = WebDriverUtil.getDriver().findElements(By.xpath("//div[@id='app-calendar-month-details-view']//tr"));
				    		List<WebElement> wAnnouncementExceededText = Announcement.getNav_ViewCalendarAnnouncementListonDate();
				    		iERowCount = wAnnouncementExceededText.size();
						    	
						    	    for (int j=1;i<iERowCount;j++ )
						    	  {
						    		wAnnouncementExceededTextElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath","NAV.ANNOUNCEMENT.VIEWCALENDAR.EXCEEDEDANNOUNCEMENT.TEXTPRESENT","PARAMETER_ROWINDEX",j+"");
						    	    
						    		sAnnouncementExceededDayText = wAnnouncementExceededTextElement.getText();
						    		
						    		
						    			if(sAnnouncementExceededDayText.contentEquals(sAnnouncementTitle))
						    			{
						    				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Announcement Date and Title", "pass", "Announcement Date and Title verified on View Calendar");
						    				WebObjectUtil.clickElement(wAnnouncementExceededTextElement);
						    				WebObjectUtil.explicitWait(5);
						    				verifyAnnouncementTextafterClickingonlinkinViewCalendar(sAnnouncementTitle,sAnnouncementDetail);
						    				//WebObjectUtil.verifyElementPresent(Announcement.getNav_ViewcalendarViewAnnouncement());
						    				
						    				break Outerloop;
						    			 }
						    			else
						    			 {
						    				continue;
						    			 }
						    	    }
						    	   
						  } 
					
			            else
			  	       {
			    	
			    			 if(sAnnouncementText.contains(sAnnTitleText[0]))
			    			   {
			    				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Announcement Date and Title", "pass", "Announcement Date and Title verified on View Calendar");
			    				WebObjectUtil.clickElement(wAnnouncementTextElement);
			    				WebObjectUtil.explicitWait(20);
			    				verifyAnnouncementTextafterClickingonlinkinViewCalendar(sAnnouncementTitle,sAnnouncementDetail);
			    				//WebObjectUtil.verifyElementPresent(Announcement.getNav_ViewcalendarViewAnnouncement());
			    				break Outerloop;
			    			   }
			    			 else
			    			   {
			    				continue;
			    			   }
			    	    
			    			
			  	       }
			        }
			    			
			         
			       }
			    	
			    }
			   
		 } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAnnouncementonCreatedDateinViewcalendar", "warn", "catch block:" +e.getMessage());  
			}
		 
		   
}
/*====================================================================================================
Method Name 	: verifyAnnouncementonCreatedDateonviewBoard
Description		: Verifying Created Announcement on view board
Author 			: QAA03
Creation Date 	: 02/17/2016
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static void verifyAnnouncementonCreatedDateonviewBoard(String sDate,String sAnnouncementTitle,String sAnnouncementDetail,String sAnnhyperlinkDetail)
{
			   WebDriver driver = WebDriverUtil.getDriver();
			   PageFactory.initElements(driver,Announcement);
			   String sAnnouncementDateMonth=null,sAnnounceDateTitletext=null,sChangedDate=null,sAnnounceDate[],sAnnDetailText[],sAnnTitleText[];
			   WebElement wDetail,wDetailLink,wDetailLongText;
			   int iDateRowindex=0,iDetailsize=0,iTitlesize=0;
			   boolean bFlag=false; 
		 try {
			       
			    sChangedDate = ChangeDateFormatwithMonth(sDate);
			    sAnnounceDate = sChangedDate.split("/");
			    String swindowhandle = driver.getWindowHandle();
			    
			    iDetailsize = sAnnouncementDetail.length();
			    iTitlesize =  sAnnouncementTitle.length();
			    
				sAnnTitleText = sAnnouncementTitle.split(" "); 
				sAnnDetailText = sAnnouncementDetail.split(" "); 
			    
			    List<WebElement> wAnnouncementDatemonth = Announcement.getNav_AnnouncementDateMonth();
				for (WebElement wb : wAnnouncementDatemonth){
					sAnnouncementDateMonth = wb.getText();
					iDateRowindex++;
					if((sAnnouncementDateMonth.contains(sAnnounceDate[1]))&& (sAnnouncementDateMonth.contains(sAnnounceDate[2])))
					{
						WebElement wAnnouncementTitle = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.ANNOUNCEMENT.VIEWBOARD.DATEROW", "PARAMETER_DATEROW",iDateRowindex+"");
						 sAnnounceDateTitletext = wAnnouncementTitle.getText();
						
						if(sAnnounceDateTitletext.contains(sAnnTitleText[0])&&(sAnnounceDateTitletext.contains(sAnnDetailText[0])))
						{
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Announcement Title and Detail", "pass", "Announcement Title and Detail verified on View Board");
							bFlag=true;
							if(iDetailsize>50)
							{
							 wDetailLink = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.ANNOUNCEMENT.VIEWBOARD.LONGERDETAIL", "PARAMETER_DATEROW,PARAMETER_DETAILS",iDateRowindex+","+sAnnDetailText[0]);
							}
							else
							{
							  wDetailLink = WebObjectUtil.getWebElementFromDynamicLocator("xpath","NAV.ANNOUNCEMENT.VIEWBOARD.DETAILLINK","PARAMETER_DATEROW",iDateRowindex+"");
							}
							 	if(wDetailLink.getAttribute("href").contains(sAnnhyperlinkDetail))
							 	{
							 		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Announcement Detail Link", "pass", "Announcement Detail Link is verified");
							 		WebObjectUtil.clickElement(wDetailLink);
							 		WebObjectUtil.explicitWait(5);
							 		WebObjectUtil.switchToWindow(2,sAnnouncementDetail);
							 		driver.close();
							 		driver.switchTo().window(swindowhandle);
							 		break;
							 	}
							 	else
							 	{
							 		FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Announcement Detail Link", "fail", "Announcement Detail Link is not verified");
							 		break;
							 	}
						
						   }
					
					  }
					
				}
				
			 	if(!bFlag)
			 	{
			 		   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Announcement Detail", "fail", "Announcement Title and Detail is not verified on view board");
			 	}
			 	
				
			   
		 } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAnnouncementonCreatedDateonviewBoard","warn", "catch block:" +e.getMessage());  
			}
		 
}

/*====================================================================================================
Method Name 	: ChangeDateFormatwithMonth
Description		: Changing the Date format to yyyy/MMM/dd
Author 			: QAA03
Creation Date 	: 02/17/2016
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static String ChangeDateFormatwithMonth(String sDate)
{
		
 try {
	    
			    DateFormat dateFormat = new SimpleDateFormat("yyyy/MMM/dd");
				Date date = new Date(sDate);
				
				 sDate = dateFormat.format(date);
				 
			 } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "ChangeDateFormatwithMonth", "warn", "catch block:" +e.getMessage());  
			}
		    return sDate;

}

/*====================================================================================================
Method Name 	: enterDetailinAddNewAnnouncement
Description		: 
Author 			: QAA03
Creation Date 	: 02/18/2016
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static void enterDetailinAddNewAnnouncement(String sAnnouncementDetail)

{
			   WebDriver driver = WebDriverUtil.getDriver();
			   PageFactory.initElements(driver,Announcement);
			   String sAnnhyperlinkDetail=null,sdetailcolor=null;
			  
		 try {  
			  
			   // driver.switchTo().activeElement();
			   
			   Announcement.getNav_AddNewAnnouncementDetail().sendKeys(sAnnouncementDetail);
			  // WebObjectUtil.clickByActions(Announcement.getNav_AddNewAnnouncementDetail());
			   
			 
			 } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "enterDetailinAddNewAnnouncement", "warn", "catch block:" +e.getMessage());  
			}

}

/*====================================================================================================
Method Name 	: selectAnnouncementDetailenteredtext
Description		: Selecting the detail text for the announcement
Author 			: QAA03
Creation Date 	: 03/03/2016
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static void selectAnnouncementDetailenteredtext()

{
			   WebDriver driver = WebDriverUtil.getDriver();
			   PageFactory.initElements(driver,Announcement);
			   
			   
		 try {
			   
			    Actions DetailTextSelect = new Actions(WebDriverUtil.getDriver()) ;
				
			 //builder.moveToElement(Announcement.getNav_AddNewAnnouncementDetail(), 1, 15).clickAndHold().build().perform();
			  //builder.contextClick(Announcement.getNav_AddNewAnnouncementDetail()).build().perform();
			     DetailTextSelect.moveToElement(Announcement.getNav_AddNewAnnouncementDetail(), 1, 40)
			    .clickAndHold()
			    .moveByOffset(300, 0)
			    .release()
			    .perform(); 
			     
			     Announcement.getNav_AddNewAnnouncementDetail().click();
			     Announcement.getNav_AddNewAnnouncementDetail().sendKeys(Keys.chord(Keys.CONTROL, "a"));
			 
			 } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "selectAnnouncementDetailenteredtext", "warn", "catch block:" +e.getMessage());  
			}

}
/*====================================================================================================
Method Name 	: changeAnnouncementDetailFontAndColor
Description		: Increasing the font and changing the color to blue for detail text of announcement
Author 			: QAA03
Creation Date 	: 03/02/2016
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static String changeAnnouncementDetailFontAndColor()

{
			   WebDriver driver = WebDriverUtil.getDriver();
			   PageFactory.initElements(driver,Announcement);
			   String sDetailcolor=null;
			   
		 try {
			   
			   WebObjectUtil.clickElement(Announcement.getNav_AddNewAnnouncementDetailUnderline());
			   WebObjectUtil.clickElement(Announcement.getNav_AddNewAnnouncementIncreaseFont());
			  
			   WebObjectUtil.clickElement(Announcement.getNav_AddNewAnnouncementColorPickButton());
			   WebObjectUtil.clickElement(Announcement.getNav_AddNewAnnouncementBlueColorButton());
			 
			   sDetailcolor = Announcement.getNav_AddNewAnnouncementBlueColorButton().getAttribute("class");
			   
			   
			 } catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "changeAnnouncementDetailFontAndColor", "warn", "catch block:" +e.getMessage());  
			}
		
		 return sDetailcolor;
}

/*====================================================================================================
Method Name 	: verifyAnnouncementPDFAndCSVLink
Description		: Verifying the PDF and CSV announcement links
Author 			: QAA03
Creation Date 	: 03/01/2016
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static void verifyAnnouncementPDFAndCSVLink()

{
			     WebDriver driver = WebDriverUtil.getDriver();
			     PageFactory.initElements(driver,Announcement);
			     String sPDFLinkText=null,sCSVLinkText=null;
			     boolean bPDFStatus,bCSVStatus;
		 try {
			     sPDFLinkText=Announcement.getNav_AnnouncementPDFLink().getAttribute("src");
			     bPDFStatus= sPDFLinkText.contains("PDF_Icon.png");
			     FrameworkUtil.updateCustomResultBasedOnStatus(bPDFStatus, "PDF image verified");
			 
			     sCSVLinkText=Announcement.getNav_AnnouncementPDFLink().getAttribute("src");
			     bCSVStatus= sCSVLinkText.contains("CSV_Icon.png");
			     FrameworkUtil.updateCustomResultBasedOnStatus(bPDFStatus, "CSV image verified");
			    
			 } catch (Exception e) {
				// TODO Auto-generated catch block
				 LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAnnouncementPDFAndCSVLink", "warn", "catch block:" +e.getMessage());  
			}


}
/*====================================================================================================
Method Name 	: valSizeandColorDetailTextofAnnouncement
Description		: Validating the size and color of the detail text of the announcement
Author 			: QAA03
Creation Date 	: 03/02/2016
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static void valSizeandColorDetailTextofAnnouncement(String sdetailcolor)

{
				   WebDriver driver = WebDriverUtil.getDriver();
				   PageFactory.initElements(driver,Announcement);
				   String sDetailTextColor=null,sDetailsize=null;
				   String  sDetailColorText[];
				   boolean bDetailColorstatus,bDetailSizestatus;
				   int iDetailsize=0;
				   
			 try {
				   //driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
				   
				   //driver.switchTo().frame("idANNADetails-inputCmp-iframeEl");
				
				   sDetailsize = Announcement.getNav_AddNewAnnouncementDetailText().getAttribute("size");
				   iDetailsize = Integer.parseInt(sDetailsize);
				   sDetailTextColor =Announcement.getNav_AddNewAnnouncementDetailText().getAttribute("color");
				   
				   if(sDetailTextColor.startsWith("#"))
				   {
					    sDetailColorText = sDetailTextColor.split("#");
					   sDetailTextColor = sDetailColorText[1];
				   }
				   bDetailColorstatus = sdetailcolor.contains(sDetailTextColor);
				   FrameworkUtil.updateCustomResultBasedOnStatus(bDetailColorstatus, "Color Of Add new announcement detail field");
				   
				   bDetailSizestatus=iDetailsize>2;
				   
				   FrameworkUtil.updateCustomResultBasedOnStatus( bDetailSizestatus, "Increase in size of Add new announcement detail field");
				  
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "valSizeandColorDetailTextofAnnouncement", "warn", "catch block:" +e.getMessage());  
				}
			

}
/*====================================================================================================
Method Name 	: navMonthYearOfAnnouncementDate
Description		: Verifying the month and year in view calendar and navigating to respective month and year of announcement need to verified
Author 			: QAA03
Creation Date 	: 03/04/2016
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static void navMonthYearOfAnnouncementDate(String sAnnouncementDate)
{
				   WebDriver driver = WebDriverUtil.getDriver();
				   PageFactory.initElements(driver,Announcement);
				   String sAnnounceMonthYear=null,sChangeFormatdate=null,sAnnCreatedMonth=null,sAnnCreatedYear=null;
				   String sMonthViewcal=null;
				   int imonth=0,iYear=0;
				   WebElement wMonth,wYear;
				   boolean bCalMonthstatus;
			 try {
				 
				   sChangeFormatdate = ChangeDateFormatwithMonth(sAnnouncementDate); 
				   String sChangeDate[] = sChangeFormatdate.split("/");
				 //Date date = new Date(sChangeFormatdate);
				  // int iDay = date.getDate();
				  // imonth = date.getMonth();
				 //  iYear = date.getYear();
				 
				   sAnnCreatedYear = sChangeDate[0];
				   sAnnCreatedMonth=sChangeDate[1];
				  // sAnnCreatedMonth = new DateFormatSymbols().getMonths()[imonth];
				   sAnnounceMonthYear = Announcement.getNav_ViewcalendarDateTitle().getText();
				   String sAnnounceMonth[] = sAnnounceMonthYear.split(" ");
				   
				 if((sAnnounceMonth[0].contains(sAnnCreatedMonth))&&(sAnnounceMonth[1].contentEquals(sAnnCreatedYear)))
				 {
					 FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName,"View calendar month and year", "pass", "View calendar is displaying expected month and year");     	 
				 }
				 else
				 {
					 //Changing the month and year to respective created announcement month and year
					 WebObjectUtil.clickElement(Announcement.getNav_ViewcalendarDateTitle());
					 WebObjectUtil.explicitWait(2);
					 wMonth = WebObjectUtil.getWebElementFromDynamicLocator("xpath","NAV.ANNOUNCEMENT.VIEWCALENDAR.MONTH", "PARAMETER_MONTH", sAnnCreatedMonth);
					 WebObjectUtil.clickElement(wMonth);
					 wYear = WebObjectUtil.getWebElementFromDynamicLocator("xpath","NAV.ANNOUNCEMENT.VIEWCALENDAR.YEAR", "PARAMETER_YEAR", sAnnCreatedYear);
					 WebObjectUtil.clickElement(wYear);
					 WebObjectUtil.clickElement(Announcement.getNav_ViewcalendarChangeMonthYearOkButton());
					 WebObjectUtil.explicitWait(5);
					 sMonthViewcal = Announcement.getNav_AnnouncementMonthinViewCalendar().getText();
					 bCalMonthstatus =sMonthViewcal.contains(sAnnCreatedMonth);
					 
						 FrameworkUtil.updateCustomResultBasedOnStatus(bCalMonthstatus,"View calendar displaying expected month"); 
					 
				 }
			
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navMonthYearOfAnnouncementDate", "warn", "catch block:" +e.getMessage());
				 }
}
/*====================================================================================================
Method Name 	: selectSkuCategoryAndSubCategoryForAddNewAnnouncement
Description		: Selecting SKU category and Sub category fields
Author 			: QAA03
Creation Date 	: 03/04/2016
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static void selectSkuCategoryAndSubCategoryForAddNewAnnouncement(String sCategory,String sSubCategory)
{
				   WebDriver driver = WebDriverUtil.getDriver();
				   PageFactory.initElements(driver,Announcement);
				   int iRowCategory=0,iRowSubCategory=0;
				   WebElement wCategoryCheckbox,wSubCategoryCheckbox;
			 try {
				   
				   
				   //Clicking on Category checkbox
				   CustomWebElementUtil.loadCustomElement(Announcement.getNav_AddNewAnnouncementDCFCategory(),"table");
				   iRowCategory = CustomWebElementUtil.getRowByCellText(sCategory, 1);
				   wCategoryCheckbox = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.ANNOUNCEMENT.NEWADDANNOUNCEMENT.CATEGORY.CHECKBOX", "PARAMETER_ROWNUMBER", iRowCategory+"");
				   WebObjectUtil.clickElement(wCategoryCheckbox);
				   
				   WebObjectUtil.scrollElementAtPageCenter(Announcement.getNav_AddNewAnnouncementDCFCategory());
				   //Clicking on  Sub Category checkbox
				   CustomWebElementUtil.loadCustomElement(Announcement.getNav_AddNewAnnouncementDCFCategory(),"table");
				   iRowSubCategory = CustomWebElementUtil.getRowByCellText(sSubCategory, 1);
				   wSubCategoryCheckbox = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.ANNOUNCEMENT.NEWADDANNOUNCEMENT.SUBCATEGORY.CHECKBOX", "PARAMETER_ROWNUMBER", iRowSubCategory+"");
				   WebObjectUtil.clickElement(wSubCategoryCheckbox);
				   
				   WebObjectUtil.scrollElementAtPageCenter(Announcement.getNav_AddNewAnnouncementDCFCategory());
				//Sub Category -Data Center: Nashville, TN (Downtown)
				
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "selectSkuCategoryAndSubCategoryForAddNewAnnouncement", "warn", "catch block:" +e.getMessage());
	 }
}


/*====================================================================================================
Method Name 	: verifyAnnouncementTextafterClickingonlinkinViewCalendar
Description		: 
Author 			: QAA03
Creation Date 	: 03/08/2016
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static void verifyAnnouncementTextafterClickingonlinkinViewCalendar(String sAnnouncementTitle,String sAnnouncementDetail)
{
				   WebDriver driver = WebDriverUtil.getDriver();
				   PageFactory.initElements(driver,Announcement);
				   String sAnnouncementText=null,sChangeFormatDate=null,sAnnTitleText[],sAnnDetailText[];
				   int iAnnTitleLen=0,iAnnDetailLen=0;
				   boolean bAnnLinkstatus;
			 try {
				       
				        iAnnDetailLen = sAnnouncementDetail.length();
				    if(iAnnDetailLen>50)
				    {		    	
				   
				    	sAnnTitleText = sAnnouncementTitle.split(" "); 
				    	sAnnDetailText = sAnnouncementDetail.split(" ");					 				   
				    	sAnnouncementText = Announcement.getNav_ViewcalendarViewAnnouncement().getText();
				    	bAnnLinkstatus = sAnnouncementText.contains(sAnnTitleText[0])&& sAnnouncementText.contains(sAnnDetailText[0]);
				    }
				    else
				    {
				    	sAnnouncementText = Announcement.getNav_ViewcalendarViewAnnouncement().getText();
					    bAnnLinkstatus = sAnnouncementText.contains(sAnnouncementTitle)&& sAnnouncementText.contains(sAnnouncementDetail);
				    }
				    FrameworkUtil.updateCustomResultBasedOnStatus(bAnnLinkstatus, "Announcement Title and Detail on clicking the announcement link in View calendar");
				   
				
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAnnouncementTextafterClickingonlinkinViewCalendar", "warn", "catch block:" +e.getMessage());
	 }
}



/*====================================================================================================
Method Name 	: validateAddNewAnnouncementwithLongerdetailsText
Description		: 
Author 			: QAA03
Creation Date 	: 03/09/2026
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static void validateAddNewAnnouncementwithLongerdetailsText(String sAnnouncementDate,String sAnnouncementTitle,String sAnnouncementDetail,String sCategory,String sSubCategory)
{
				    WebDriver driver = WebDriverUtil.getDriver();
				 	PageFactory.initElements(driver,Announcement);
					PageFactory.initElements(driver,Common);
					
					String sULElementXpath=null,sTime=null,sFeedbackpopup=null,sFeedback=null;
					boolean bAnnAddedStatus,bAnnDateStatus;
			 try {
				    sULElementXpath =(String)FrameworkUtil.dictDynamicPagePactory.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.TIME");
				    sTime = (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.TIME");
				    sFeedback = (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.FEEDBACK");
				    
				    sCategory = (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.DCCATEGORY");
					sSubCategory = (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.DCSUBCATEGORY");
					
				    
				    //Clicking on Add New Announcement Link
				    WebObjectUtil.clickElement(Announcement.getNav_AddNewAnnouncementLink());
				    WebObjectUtil.verifyElementPresent(Announcement.getNav_AddNewAnnouncementWindow());
				    
				    //sTommorrowDate = getTommorrowDate();
				    
				    //Entering the date on which announcement need to create
				    WebObjectUtil.SetValueEdit(Announcement.getNav_AddNewAnnouncementDateField(),sAnnouncementDate);
				    WebObjectUtil.explicitWait(2);
				    
				    //Verifying whether valid date entered or not
				    bAnnDateStatus = !Announcement.getNav_AddNewAnnouncementInvalidDateField().isDisplayed();
				      
					FrameworkUtil.updateCustomResultBasedOnStatus(bAnnDateStatus, "Valid Date Entered"); 
					   
				    //Entering the time
					WebObjectUtil.clickElement(Announcement.getNav_AddNewAnnouncementTimeIcon());
					WebObjectUtil.selectCustomWebList(Announcement.getNav_AddNewAnnouncementTimeIcon(),sULElementXpath, sTime,0);
					
					//Selecting SKU category and Sub category fields
					selectSkuCategoryAndSubCategoryForAddNewAnnouncement(sCategory,sSubCategory);
					
					//Entering the title for new announcement
					WebObjectUtil.SetValueEdit(Announcement.getNav_AddNewAnnouncementTitle(), sAnnouncementTitle);
					
					//Entering the detail field
					enterDetailinAddNewAnnouncement(sAnnouncementDetail);
					
					//Clicking on save button to add new announcement
				    WebObjectUtil.clickElement(Announcement.getNav_AddNewAnnouncementSaveButton());
					
					WebObjectUtil.waitForElementPresent(Common.getNav_UsrFeedBack());
					
					//Verifying the feedback message
					sFeedbackpopup = Common.getNav_UsrFeedBack().getText();
					
					bAnnAddedStatus = sFeedback.equalsIgnoreCase(sFeedbackpopup);
					
					FrameworkUtil.updateCustomResultBasedOnStatus(bAnnAddedStatus, "Added New Announcement");
				    
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName ,"validateAddNewAnnouncementwithLongerdetailsText", "warn", "catch block:" +e.getMessage());  
				}
		
}
/*====================================================================================================
Method Name 	: verifyAnnouncementinHomePage
Description		: 
Author 			: QAA03
Creation Date 	: 03/08/2016
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static void verifyAnnouncementinHomePage(String sAnnouncementDetail)
{
				   WebDriver driver = WebDriverUtil.getDriver();
				   PageFactory.initElements(driver,Announcement);
				   String sAnnouncementText=null,sAnnouncementNextText=null;
				   int iAnnMenuCount=0,iTemp=0;
				   WebElement wAnnouncement,wAnnouncementText;
				   boolean bAnnDetailStatus=false;
			 try {
				    					 				   
				   WebObjectUtil.clickElement(Announcement.getNav_AnnouncementPauseButton());
				   CustomWebElementUtil.loadCustomElement(Announcement.getNav_AnnouncementMenuView(), "li");
				   iAnnMenuCount = CustomWebElementUtil.iRowCount;
				   
				   for(int i=3;i<=iAnnMenuCount-1;i++)
				   {
					   iTemp= i-2;
					  
					   //WebObjectUtil.clickElement(Announcement.getNav_AnnouncementPlayButton());
					   wAnnouncement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.ANNOUNCEMENT.MENU.ANNOUNCEMENTDOTS", "PARAMETER_DOTS", i+""); 
					   WebObjectUtil.clickElement(wAnnouncement);
					   //WebObjectUtil.clickElement(Announcement.getNav_AnnouncementPauseButton());
					   
					   wAnnouncementText = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.ANNOUNCEMENT.MENU.ANNOUNCEMENTTEXT", "PARAMETER_DOTS", iTemp+"");
					   sAnnouncementText = wAnnouncementText.getText();
					   if(sAnnouncementText.contains(sAnnouncementDetail))
					   {
						   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Announcement Detail Text", "pass", "Announcement Detail text present in Anouncement portlet of Home page");
						   bAnnDetailStatus = true;
						   if(i==(iAnnMenuCount-1))
						   {
							   i=3;
							   iTemp=i-2;
						   }
						   wAnnouncement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.ANNOUNCEMENT.MENU.ANNOUNCEMENTDOTS", "PARAMETER_DOTS", (i+1)+""); 
						   WebObjectUtil.clickElement(wAnnouncement);
						   wAnnouncementText = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.ANNOUNCEMENT.MENU.ANNOUNCEMENTTEXT", "PARAMETER_DOTS", (iTemp+1)+"");
						   sAnnouncementNextText = wAnnouncementText.getText();
						   if(!sAnnouncementNextText.equals(sAnnouncementText))
						   {
							   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Announcement Detail Text Clicking on Next Dot Button", "pass", "Announcement Detail text is changing after clicking on next dot in Anouncement portlet of Home page"); 
						   }
						   break;
					   }
					 
				   }
				   if(!bAnnDetailStatus)
				   {
				   FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Announcement Detail Text", "fail", "Announcement Detail text not present in Anouncement portlet of Home page");
				   }
				   				   
				
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAnnouncementinHomePage", "warn", "catch block:" +e.getMessage());
	 }
}

/*====================================================================================================
Method Name 	: verifyAnnouncementCurrentDayinViewCalendar
Description		: verifying current day has outline in month box of view calendar announcement page
Author 			: QAA03
Creation Date 	: 04/11/2016
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static void verifyAnnouncementCurrentDayinViewCalendar(String sCurrentDate)
{
				   WebDriver driver = WebDriverUtil.getDriver();
				   PageFactory.initElements(driver,Announcement);
				   String sAnnouncementText=null,sChangeFormatDate=null,sDate[],sAnnMonth=null,sAnnCurrentDayText=null;
				   WebElement wAnnCurrentDay;
				   boolean bAnnMonthStatus,bAnnDaystatus;
			 try {
				    sAnnCurrentDayText = (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.CURRENTDAY.TEXT");
				    
				    sCurrentDate = ChangeDateFormatwithMonth(sCurrentDate);
				    sDate = sCurrentDate.split("/");
				    
					WebObjectUtil.verifyElementPresent(Announcement.getNav_AnnouncementMonthBoxinViewcalendar());
					sAnnMonth = Announcement.getNav_ViewcalendarMonthDisplayed().getText();
					bAnnMonthStatus = sAnnMonth.contains(sDate[1]);
					if(bAnnMonthStatus)
					{
					wAnnCurrentDay = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.ANNOUNCEMENT.VIEWCALENDAR.CURRENTDAY", "PARAMETER_DAY", sDate[2]);
				    
				    bAnnDaystatus =	wAnnCurrentDay.getAttribute("title").contains(sAnnCurrentDayText);
				    FrameworkUtil.updateCustomResultBasedOnStatus(bAnnDaystatus, "Current Day outlined in View calendar page");
					}
					else
					{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName, "Announcement Month", "fail", "View Calendar Announcement page is not displaying current month");
					}
				
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAnnouncementCurrentDayinViewCalendar", "warn", "catch block:" +e.getMessage());
	 }
}

/*====================================================================================================
Method Name 	: getCurrentDate
Description		: Getting the Current date in MM/dd/yyyy format
Author 			: QAA03
Creation Date 	: 04/11/2016
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static String getCurrentDate()
{
					String sCurrentDate=null;
			 try {
				    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
					Date date = new Date();
				
					
					 sCurrentDate = dateFormat.format(date);
					 
					 
					
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "getCurrentDate", "warn", "catch block:" +e.getMessage());  
				}
			 return sCurrentDate;

}
/*====================================================================================================
Method Name 	: validateAddNewAnnouncementwithEmailField
Description		: Entering all the fields and creating announcement through add new announcement window
Author 			: QAA03
Creation Date 	: 02/10/2016
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static void validateAddNewAnnouncementwithEmailField(String sAnnouncementDate,String sAnnouncementText,String sCategory,String sSubCategory,String sEmail)
{
				    WebDriver driver = WebDriverUtil.getDriver();
				 	PageFactory.initElements(driver,Announcement);
					PageFactory.initElements(driver,Common);
					
					String sULElementXpath=null,sTime=null,sFeedbackpopup=null,sFeedback=null,sCategoryText1=null,sCategoryText2=null;
					boolean bAnnCreatedStatus,bAnnDateenteredStatus;
			 try {
				 
				    sULElementXpath =(String)FrameworkUtil.dictDynamicPagePactory.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.TIME");
				    sTime = (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.TIME");
				    sFeedback = (String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.FEEDBACK");
				   			    
				    //Entering the date on which announcement need to create
				    WebObjectUtil.SetValueEdit(Announcement.getNav_AddNewAnnouncementDateField(),sAnnouncementDate);
				    WebObjectUtil.explicitWait(2);
				    
				    //Verifying whether valid date entered or not
				    bAnnDateenteredStatus=!Announcement.getNav_AddNewAnnouncementInvalidDateField().isDisplayed();
				      
					FrameworkUtil.updateCustomResultBasedOnStatus(bAnnDateenteredStatus, "Valid Date Entered for Announcement"); 
					   
				    //Entering the time
					WebObjectUtil.clickElement(Announcement.getNav_AddNewAnnouncementTimeIcon());
					WebObjectUtil.selectCustomWebList(Announcement.getNav_AddNewAnnouncementTimeIcon(),sULElementXpath, sTime,0);
					
					//Selecting SKU category and Sub category fields
					selectSkuCategoryAndSubCategoryForAddNewAnnouncement(sCategory,sSubCategory);
					
					//Entering the title for new announcement
					WebObjectUtil.SetValueEdit(Announcement.getNav_AddNewAnnouncementTitle(), sAnnouncementText);
					
					//Entering the detail for new announcement
					WebObjectUtil.SetValueEdit(Announcement.getNav_AddNewAnnouncementDetail(), sAnnouncementText);
					 
					valAddNewAnnAdditionalRequirementfield(sEmail);
					
					
					WebObjectUtil.clickElement(Announcement.getNav_AddNewAnnouncementEmailCheckBox());
					
					
					//Clicking on save button to add new announcement
					WebObjectUtil.clickElement(Announcement.getNav_AddNewAnnouncementSaveButton());
					
					WebObjectUtil.waitForElementPresent(Common.getNav_UsrFeedBack());
					
					//Verifying the feedback message
					sFeedbackpopup = Common.getNav_UsrFeedBack().getText();
					
					bAnnCreatedStatus = sFeedback.equalsIgnoreCase(sFeedbackpopup);
					
					FrameworkUtil.updateCustomResultBasedOnStatus(bAnnCreatedStatus, "Added New Announcement message");
					
					
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName ,"validateAddNewAnnouncementwithEmailField", "warn", "catch block:" +e.getMessage());  
				}
		
}
/*====================================================================================================
Method Name 	: valAddNewAnnAdditionalRequirementfield
Description		: 
Author 			: QAA03
Creation Date 	: 04/20/2016
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static void valAddNewAnnAdditionalRequirementfield(String sEmail)
{
	
	                WebDriver driver = WebDriverUtil.getDriver();
	 	            PageFactory.initElements(driver,Announcement);
				    String sText=null;
				
			 try {
				 if(sEmail!=null)
				 {
				     sText= (String)FrameworkUtil.dictPropertyData.get("NAV.AUTOMATION.TEXT");
					 WebObjectUtil.SetValueEdit(Announcement.getNav_AddNewAnnouncementAddRequirementBox(), sText);
					 WebObjectUtil.verifyElementPresent(Announcement.getNav_AddNewAnnouncementAddReqErrorMessage());
					
					 WebObjectUtil.SetValueEdit(Announcement.getNav_AddNewAnnouncementAddRequirementBox(), sEmail);
				 }
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "valAddNewAnnAdditionalRequirementfield", "warn", "catch block:" +e.getMessage());  
				}
			

}

/*====================================================================================================
Method Name 	: searchCategoryofAnnouncementbyEnteringText
Description		: 
Author 			: QAA03
Creation Date 	: 04/20/2016
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static void searchCategoryofAnnouncementbyEnteringText(String sCategoryText)
{
	
	                WebDriver driver = WebDriverUtil.getDriver();
	 	            PageFactory.initElements(driver,Announcement);
	 	            int iSearchCount=0;
				    String sCategoryValue=null;
				
			 try {
				     WebObjectUtil.SetValueEdit(Announcement.getNav_AddNewAnnouncementSearchCategoryBox(), sCategoryText);
				     WebObjectUtil.explicitWait(2);
				     List<WebElement> wAnnouncementSearchCategory = Announcement.getNav_AddNewAnnouncementSearchCategoryValue();
				     iSearchCount = wAnnouncementSearchCategory.size();
				    
				     for (WebElement wCategory : wAnnouncementSearchCategory){
							sCategoryValue = wCategory.getText();
							
							if((sCategoryValue.toLowerCase().trim()).contains(sCategoryText))
							{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Announcement Category", "pass", "Announcement Category is displaying Category list which has "+sCategoryText);
							}
							else
							{
								FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Announcement Category", "fail", "Announcement Category is not displaying Category list which has "+sCategoryText);
							}
				     }
				     WebObjectUtil.SetValueEdit(Announcement.getNav_AddNewAnnouncementSearchCategoryBox(), " ");
				     WebObjectUtil.explicitWait(2);
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "searchCategoryofAnnouncementbyEnteringText", "warn", "catch block:" +e.getMessage());  
				}
			

}
/*====================================================================================================
Method Name 	: navLogViewerPage
Description		: 
Author 			: QAA03
Creation Date 	: 04/26/2016
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static void navLogViewerPage()
{
	
	                WebDriver driver = WebDriverUtil.getDriver();
	                PageFactory.initElements(driver,Home);
	 	            PageFactory.initElements(driver,Logviewer);
	 	            
				
			 try {
				   WebDriverUtil.refreshBrowser();
				   WebObjectUtil.explicitWait(2);
				   WebObjectUtil.clickElement(Home.getNav_SupportTab());
				   WebObjectUtil.explicitWait(2);
				   WebObjectUtil.clickElement(Logviewer.getNav_LogViewerlink());
				   WebObjectUtil.explicitWait(5);
				   WebObjectUtil.verifyElementPresent(Logviewer.getNav_LogviewerPortalActionLogText());
				   
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navLogViewerPage", "warn", "catch block:" +e.getMessage());  
				}
			

}
/*====================================================================================================
Method Name 	: verifyAnnDataThroughEmailLinkinLogViewerPage
Description		: 
Author 			: QAA03
Creation Date 	: 05/12/2016
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static void verifyAnnDataThroughEmailLinkinLogViewerPage(String sAnnouncementDate, String sAnnouncementTitle,String sEmail)
{
	
	                WebDriver driver = WebDriverUtil.getDriver();
	                PageFactory.initElements(driver,Logviewer);
	 	            int iRowAnnCount=0;
	 	            WebElement wAnnRowData,wAnnRowEmailLink;
				    String sAdminEmail=null;
				    boolean bFlag=false;
			 try {
				 
				    sAdminEmail=(String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.ADMINEMAIL");
				    
				    WebObjectUtil.SetValueEdit(Logviewer.getNav_LogViewerDateFromInputBox(), sAnnouncementDate);
				    WebObjectUtil.SetValueEdit(Logviewer.getNav_LogViewerDateToInputBox(), sAnnouncementDate);
				    WebObjectUtil.clickElement(Logviewer.getNavViewLogBtn());
				    WebObjectUtil.explicitWait(2);
				    CustomWebElementUtil.loadCustomElement(Logviewer.getNav_LogViewerWebTableDataParent(), "table");
				    iRowAnnCount = CustomWebElementUtil.iRowCount;
				    
				    for(int i=1;i<=iRowAnnCount;i++)
				    {
				    	wAnnRowData = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.LOGVIEWER.ADDANNOUNCEMENT.ROW", "PARAMETER_ROWNUMBER", i+"");
				    	
				    	if(wAnnRowData!=null)
				    	{
				    		wAnnRowEmailLink=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.LOGVIEWER.ADDANNOUNCEMENT.EMAILLINK.ROW", "PARAMETER_ROWNUMBER", i+"");
				    		WebObjectUtil.clickElement(wAnnRowEmailLink);
				    		WebObjectUtil.verifyElementPresent(Logviewer.getNav_LogViewerEmailwindow());
				    		verifyAnnDatainLogViewerEmailwindow(sAnnouncementTitle,sAdminEmail,sEmail);
				    		bFlag=true;
				    		break;
				    	}
				    	
				    }
				  if(!bFlag)
				  {
					  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Created Announcement in Logviewer page", "fail", "Created Announcement data is not present in log viewer page");
				  }
				   
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAnnDataThroughEmailLinkinLogViewerPage", "warn", "catch block:" +e.getMessage());  
				}
			

}
/*====================================================================================================
Method Name 	: verifyAnnDatainLogViewerEmailwindow
Description		: 
Author 			: QAA03
Creation Date 	: 05/12/2016
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static void verifyAnnDatainLogViewerEmailwindow(String sAnnouncementTitle,String sAdminEmail,String sEmail)
{
	
	                WebDriver driver = WebDriverUtil.getDriver();
	                PageFactory.initElements(driver,Logviewer);
	 	            boolean bAnnSubStatus,bAnnBccEmailStatus,bAnnToEmailStatus;
				
			 try {
				    driver.switchTo().frame(Logviewer.getNav_LogViewerEmailContentWindowBccField());
				    
				    if(sEmail==null)
				    {
				    bAnnBccEmailStatus= Logviewer.getNav_LogViewerEmailContentWindowBccAdminEmailText().getText().equalsIgnoreCase(sAdminEmail);
				    }
				    else
				    {
				   	bAnnBccEmailStatus= Logviewer.getNav_LogViewerEmailContentWindowBccAdminEmailText().getText().equalsIgnoreCase(sAdminEmail)&&Logviewer.getNav_LogViewerEmailContentWindowBccEmailText().getText().contains(sEmail);
				    }
				    
				    FrameworkUtil.updateCustomResultBasedOnStatus(bAnnBccEmailStatus, "Bcc Email Data of created announcement in Email window by clicking on email link in logviewer page");
				    
				    driver.switchTo().parentFrame();
				    
				    bAnnToEmailStatus =Logviewer.getNav_LogViewerEmailContentWindowToText().getAttribute("value").contains(sAdminEmail);
	 	    		
		    		FrameworkUtil.updateCustomResultBasedOnStatus(bAnnToEmailStatus, "Admin Email in the To field of Email window by clicking on email link in logviewer page");
				    				   
				    bAnnSubStatus =Logviewer.getNav_LogViewerEmailContentWindowSubjectText().getAttribute("value").trim().contains(sAnnouncementTitle);
				 	    		
		    		FrameworkUtil.updateCustomResultBasedOnStatus(bAnnSubStatus, "Title of created announcement in the subject field of Email window by clicking on email link in logviewer page");
		    			
		    		WebObjectUtil.clickElement(Logviewer.getNav_LogViewerEmailContentWindowCloseButton());	
				  
				   
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAnnDataThroughEmailLinkinLogViewerPage", "warn", "catch block:" +e.getMessage());  
				}
			

}
/*====================================================================================================
Method Name 	: verifyAnnouncementDatainIndexOfHostsUrl
Description		: 
Author 			: QAA03
Creation Date 	: 
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static void verifyAnnouncementDatainIndexOfHostsUrl(String sCurrentDate,String sAnnouncementTitle,String sEmail)
{
	
	                WebDriver driver = WebDriverUtil.getDriver();
	                PageFactory.initElements(driver,Announcement);
	 	            String sIndexOfHostsurl=null,sAdminEmail=null;
				    int iRowCount=0;
			 try {
				    sIndexOfHostsurl=(String)FrameworkUtil.dictPropertyData.get("INDEXOFHOSTS.URL");
				    
				    sAdminEmail=(String)FrameworkUtil.dictPropertyData.get("NAV.ANNOUNCEMENT.ADDNEWANNOUNCEMENT.ADMINEMAIL");
				    
				    driver.get(sIndexOfHostsurl);
				    
				    WebObjectUtil.verifyElementPresent(Announcement.getIndexOfHostsUrl_Table());
				    
				    WebObjectUtil.clickElement(Announcement.getIndexOfHostsUrl_tstnav01link());
				    
				    WebObjectUtil.verifyElementPresent(Announcement.getIndexOfHostsUrl_Table());
				    
				    clickFolderbasedonDateforIndexOfHosts(sCurrentDate);
				    
				    WebObjectUtil.verifyElementPresent(Announcement.getIndexOfHostsUrl_Table());
				    
				    clickFolderbasedonDateforIndexOfHosts(sCurrentDate);
				    
				    /*WebObjectUtil.VerifyTextUnderElement(Announcement.getIndexOfHostsUrl_FolderData(),sAnnouncementTitle);
				    
				    WebObjectUtil.VerifyTextUnderElement(Announcement.getIndexOfHostsUrl_FolderData(),sEmail);
				    
				    WebObjectUtil.VerifyTextUnderElement(Announcement.getIndexOfHostsUrl_FolderData(),sAdminEmail);
				    */
				    
				    			    
				    WebObjectUtil.VerifyTextOnPage(sAdminEmail);
				    
				    WebObjectUtil.VerifyTextOnPage(sEmail);
				    
				    WebObjectUtil.VerifyTextOnPage(sAnnouncementTitle);
				    
				    
				    driver.navigate().back();
				    driver.navigate().back();
				    driver.navigate().back();
				    driver.navigate().back();
				    
				   
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "verifyAnnouncementDatainIndexOfHostsUrl", "warn", "catch block:" +e.getMessage());  
				}
			

}

/*====================================================================================================
Method Name 	: getCurrentDateinFormat
Description		: Getting the Current date in dd-MMM-yyyy
Author 			: QAA03
Creation Date 	: 05/17/2016
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static String getCurrentDateinFormat()
{
					String sCurrentDate=null;
			 try {
				    DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
					Date date = new Date();
				
					sCurrentDate = dateFormat.format(date);
					 
				
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "getCurrentDateinFormat", "warn", "catch block:" +e.getMessage());  
				}
			 return sCurrentDate;

}


/*====================================================================================================
Method Name 	: clickFolderbasedonDateforIndexOfHosts
Description		: 
Author 			: QAA03
Creation Date 	: 
Pre-Requisites	: 
Revision History:
====================================================================================================*/
public static void clickFolderbasedonDateforIndexOfHosts(String sCurrentDate)
{
	               int iRowCount=0;
	               WebElement wRowElement,wCellDataElement;
			 try {
				   iRowCount =WebTableUtil.getRowCount(Announcement.getIndexOfHostsUrl_Table());
				   
				   for(int i=(iRowCount-1);i>=1;i--)
				   {
					   wRowElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "INDEXOFHOSTS.ROWDATA.ONDATE","PARAMETER_ROWNUMBER,PARAMETER_DATE", i+","+sCurrentDate);
					   if(wRowElement!=null)
					   {
						   wCellDataElement = WebTableUtil.getCellAsWebElement(Announcement.getIndexOfHostsUrl_Table(),i,2);
						   WebObjectUtil.clickElement(wCellDataElement);
						   break;
					   }
					   else
					   {
						   continue;
					   }
				   }
				   
				   
				 } catch (Exception e) {
					// TODO Auto-generated catch block
					LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "clickFolderbasedonDateforIndexOfHosts", "warn", "catch block:" +e.getMessage());  
				}
			

}


@AfterMethod
public static void afterEachMethod(){
		FrameworkUtil.updateTestCaseStatusinResult();
		//Should be deleted after today's execution by Arul on 7/14/16
		WebDriverUtil.quitWebDriver();	
	}
}
