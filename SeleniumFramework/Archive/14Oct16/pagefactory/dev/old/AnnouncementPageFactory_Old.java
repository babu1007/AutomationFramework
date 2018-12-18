package com.whs.navigator.pagefactory.dev.old;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class AnnouncementPageFactory_Old 
{
	/////////**********************LefCourtSP2 Elements**********************///////
	
	
	//Page Factory and links under Support Tab 
	
	//This element updated on 09/21/2015 by QAA03
	//@FindBy(how=How.XPATH,using="//a[contains(text(),'support')]")
	@FindBy(how=How.XPATH,using="//a[text()='support']")
	private WebElement nav_SupportTab;
		
	@FindBy(how=How.LINK_TEXT,using="Announcements")
	private WebElement nav_AnnouncementsMenuLink;
	
	//This element updated on 09/21/2015 by QAA03
	//@FindBy(how=How.XPATH,using="//table/tbody/tr/td[1]/div/div")
	@FindBy(how=How.XPATH,using="//div[text()='Show Calendar']")
	private WebElement nav_CalenderBtn;
	
	@FindBy(how=How.XPATH,using="//table/tbody/tr[3]/td/table/tbody/tr[3]/td/table/tbody/tr")
	private WebElement nav_DatePicker;
	
	@FindBy(how=How.XPATH,using="//div[1]/section/div/div/div/div/table/tbody/tr[1]/td/table/tbody/tr/td[1]/div/div")
	private WebElement nav_HideCalender;
	
	@FindBy(how=How.XPATH, using="//u")
	private WebElement nav_TodayLink;
	
	@FindBy(how=How.XPATH, using="//table/tbody/tr/td[3]/div/div")
	private WebElement nav_ForwardMonthArrow;
	
	@FindBy(how=How.XPATH, using="//td[1]/table/tbody/tr[1]/td/table/tbody/tr/td[1]/div/div")
	private WebElement nav_BackwardMonthArrow;
	
	@FindBy(how=How.XPATH,using="//table/tbody/tr/td[1]/table/tbody/tr[1]/td/table/tbody/tr/td[2]")
	private WebElement nav_CurrentMonth;
	
	//@FindBy(how=How.CSS, using=".datePickerDay.datePickerDayIsNotificationOther.datePickerDayIsHighlighted")
	@FindBy(how=How.XPATH,using="//td[contains(@class, 'datePickerDayIsNotification') and text()='24' ]")
	private WebElement nav_AnnouncementDate;
	
	@FindBy(how=How.XPATH,using="//td[contains(@class, 'datePickerDayIsNotification') and text()='11' ]")
	private WebElement nav_MultiOrgAnnouncementDate;
	
	@FindBy(how=How.XPATH,using="//*[contains(text(),'Jul 2012')]/../../../../../..//td[contains(@class,'datePickerDay') and text()='11']")
	private WebElement nav_MultiOrgNoAnnouncement;
	
	@FindBy(how=How.XPATH,using="//*[contains(text(),'Announcement SKU test')]")
	private WebElement nav_Annuncement1;
	
	@FindBy(how=How.XPATH,using="//*[contains(text(),'Announcement sku test 3')]")
	private WebElement nav_Annuncement2;
	
	@FindBy(how=How.XPATH,using="//table/tbody/tr[4]/td/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/div/table/tbody/tr[1]/td[2]/div")
	private WebElement nav_AnnouncementProtected;
	
	
	//MultiSelect List
	@FindBy(how=How.NAME,using ="orgId")
	private WebElement nav_MultiSelectList;
	
	//Use This organization Button
	@FindBy(how=How.XPATH,using="//form/input[contains(@value,'Use this Organization')]")
	private WebElement nav_UseOrganizationBtn;
	
	//07/11/2012
	@FindBy(how=How.XPATH,using="//*[contains(@class,'datePickerDay datePickerDayIsNotificationOther datePickerDayIsValue')]]")
	private WebElement nav_MultiUserDate;
	
	//Announcement for MultiUser
	@FindBy(how=How.XPATH,using="//tbody/tr[1]/td[1]/*[contains(@class,'gwt-Label')]")
	private WebElement nav_MultiUserAnnouncement;
	
	
	@FindBy(how=How.LINK_TEXT,using="Belk - SMART")
	private WebElement nav_MultiUserName;
	
	@FindBy(how=How.LINK_TEXT,using="Belk - Workforce Management")
	private WebElement nav_MultiUserBELKWorkForce;
	
	@FindBy(how=How.ID, using="organization")
	private WebElement nav_OrganizationDropDown;

/// ____________________________ QAA04 __________________________________ ///
	// teken from Gideon pagefactory
	//Announcement Image without New
		@FindBy(how=How.ID,using="welcomeGraphic")
		private WebElement nav_AnnouncementWithoutNewTextImg;
		
		@FindBy(how=How.XPATH,using="//div[@id='announcements']//a[text()='announcements']")
		private WebElement nav_AnnouncementPortletLnk;
		
		@FindBy(how=How.XPATH,using="//div[text()='Show Calendar']")
		private WebElement nav_AnnouncementCalendarBtn;
		
		
		@FindBy(how=How.XPATH,using="//div[contains(text(),'Test UPS Maintenance')]")
		private WebElement nav_AnnuncementTitle;
			
		@FindBy(how=How.XPATH,using="//td[@class='middleCenter']//div/table/tbody")
		private WebElement nav_AnnouncementTable;
	
	
	
////________________________________ QAA04 __________________________________________///
//#######################################################################################
//#######################################################################################
	public WebElement getNav_SupportTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SupportTab;
	}

	public WebElement getNav_AnnouncementsMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AnnouncementsMenuLink;
	}

	public WebElement getNav_CalenderBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CalenderBtn;
	}

	public WebElement getNav_DatePicker() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DatePicker;
	}

	public WebElement getNav_HideCalender() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_HideCalender;
	}

	public WebElement getNav_TodayLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TodayLink;
	}

	public WebElement getNav_ForwardMonthArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ForwardMonthArrow;
	}

	public WebElement getNav_BackwardMonthArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_BackwardMonthArrow;
	}

	public WebElement getNav_CurrentMonth() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CurrentMonth;
	}

	public WebElement getNav_AnnouncementDate() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AnnouncementDate;
	}

	public WebElement getNav_Annuncement1() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Annuncement1;
	}

	public WebElement getNav_Annuncement2() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Annuncement2;
	}

	public WebElement getNav_MultiSelectList() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_MultiSelectList;
	}

	public WebElement getNav_UseOrganizationBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_UseOrganizationBtn;
	}

	public WebElement getNav_MultiUserDate() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_MultiUserDate;
	}

	public WebElement getNav_MultiUserAnnouncement() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_MultiUserAnnouncement;
	}

	public WebElement getNav_MultiUserName() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_MultiUserName;
	}

	public WebElement getNav_AnnouncementProtected() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AnnouncementProtected;
	}

	public WebElement getNav_MultiOrgAnnouncementDate() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_MultiOrgAnnouncementDate;
	}

	public WebElement getNav_MultiUserBELKWorkForce() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_MultiUserBELKWorkForce;
	}

	public WebElement getNav_MultiOrgNoAnnouncement() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_MultiOrgNoAnnouncement;
	}
	
	public WebElement getnav_OrganizationDropDown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_OrganizationDropDown;
	}

	public WebElement getNav_OrganizationDropDown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_OrganizationDropDown;
	}

	public WebElement getNav_AnnouncementWithoutNewTextImg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AnnouncementWithoutNewTextImg;
	}

	public WebElement getNav_AnnouncementPortletLnk() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AnnouncementPortletLnk;
	}

	public WebElement getNav_AnnouncementCalendarBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AnnouncementCalendarBtn;
	}

	public WebElement getNav_AnnuncementTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AnnuncementTitle;
	}

	public WebElement getNav_AnnouncementTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AnnouncementTable;
	}

	
}
