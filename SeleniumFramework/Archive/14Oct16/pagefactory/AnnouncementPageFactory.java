package com.whs.navigator.pagefactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class AnnouncementPageFactory {
	
	@FindBy(how=How.LINK_TEXT,using="Announcements")
	private WebElement nav_AnnouncementsMenuLink;
	
	@FindBy(how=How.ID,using="announcements")
	private WebElement nav_AnnouncementsPortlet;
	
	@FindBy(how=How.XPATH,using="//span[text()='New Announcement']")
	private WebElement nav_AddNewAnnouncementLink;
	
	@FindBy(how=How.ID,using="idANNAWindow-innerCt")
	private WebElement nav_AddNewAnnouncementWindow;
	
	@FindBy(how=How.XPATH,using="//input[contains(@id,'datefield-')]")
	private WebElement nav_AddNewAnnouncementDateField;
	
	@FindBy(how=How.XPATH,using="//div[contains(@id,'datefield-')]//div[contains(@class,'x-form-invalid-icon-default')]")
	private WebElement nav_AddNewAnnouncementInvalidDateField;
	
	@FindBy(how=How.XPATH,using="//div[@id='idANNACategoriesTree-body']")
	private WebElement nav_AddNewAnnouncementDCFCategory;
	
	@FindBy(how=How.XPATH,using="//table[31]//input[contains(@class,'x-tree-checkbox')]")
	private WebElement nav_AddNewAnnouncementDCFCategory1;
	
	@FindBy(how=How.XPATH,using="//div[contains(@id,'timefield-')]//div[contains(@id,'-trigger-picker')]")
	private WebElement nav_AddNewAnnouncementTimeIcon;
	
	@FindBy(how=How.XPATH,using="//input[contains(@id,'textfield-')][contains(@class,'x-form-required-field')]")
	private WebElement nav_AddNewAnnouncementTitle;
	
	//@FindBy(how=How.XPATH,using="//iframe[@id='idANNADetails-inputCmp-iframeEl']")
	@FindBy(how=How.ID,using="idANNADetails-inputEl")
	private WebElement nav_AddNewAnnouncementDetail;
	
	@FindBy(how=How.XPATH,using="html/body//font")
	private WebElement nav_AddNewAnnouncementDetailText;
	
	@FindBy(how=How.XPATH,using="//span[contains(@class,'x-edit-createlink')]")
	private WebElement nav_AddNewAnnouncementDetailHyperlink;
	
	@FindBy(how=How.XPATH,using="//span[contains(@class,'x-edit-underline')]")
	private WebElement nav_AddNewAnnouncementDetailUnderline;
	
	@FindBy(how=How.XPATH,using="//span[contains(@class,'-increasefontsize')]")
	private WebElement nav_AddNewAnnouncementIncreaseFont;
	
	@FindBy(how=How.XPATH,using="//div[@id='idANNADetails-targetEl']//a[6]")
	private WebElement nav_AddNewAnnouncementColorPickButton;
	
	@FindBy(how=How.XPATH,using="//a[contains(@class,'color-000080')]")
	private WebElement nav_AddNewAnnouncementBlueColorButton;
	
	@FindBy(how=How.ID,using="idANNACatSearchTrigger-inputEl")
	private WebElement nav_AddNewAnnouncementSearchCategoryBox;
	
	@FindBys({ @FindBy(how=How.XPATH,using="//div[@id='idANNACategoriesTree-body']//table//div//input//..//span") })
	private List<WebElement> nav_AddNewAnnouncementSearchCategoryValue;
	
	@FindBy(how=How.NAME,using="bcclist")
	private WebElement nav_AddNewAnnouncementAddRequirementBox;
	
	@FindBy(how=How.XPATH,using="//table[@id='idANNAForm-table']//tr[3]//div[contains(@class,'x-form-error-msg')]")
	private WebElement nav_AddNewAnnouncementAddReqErrorMessage;
	
	@FindBy(how=How.XPATH,using="//input[contains(@id,'checkbox-')]")
	private WebElement nav_AddNewAnnouncementEmailCheckBox;
	
	@FindBy(how=How.XPATH,using="//span[text()='Save']")
	private WebElement nav_AddNewAnnouncementSaveButton;
	
	@FindBys({ @FindBy(how=How.XPATH,using="//div[@id='idANViewport-innerCt']//section[@class='date_panel']") })
	private List<WebElement> nav_AnnouncementDateMonth;
	
	@FindBy(how=How.ID,using="idANViewCalButton")
	private WebElement nav_AnnouncementViewCalendarOrBoardLink;
	
	@FindBy(how=How.ID,using="idCalVP")
	private WebElement nav_AnnouncementViewCalendarPage;
	
	@FindBy(how=How.ID,using="idANViewport-innerCt")
	private WebElement nav_AnnouncementViewBoardPage;
	
	@FindBy(how=How.ID,using="app-calendar-tb-month-btnInnerEl")
	private WebElement nav_AnnouncementMonthinViewCalendar;
	
	@FindBy(how=How.ID,using="app-nav-picker-eventEl")
	private WebElement nav_AnnouncementMonthBoxinViewcalendar;
	
	@FindBy(how=How.XPATH,using="//div[@id='app-nav-picker-middleBtnEl']//span[contains(@class,'x-btn-inner-default-small')]")
	private WebElement nav_ViewcalendarMonthDisplayed;
	
	@FindBy(how=How.XPATH,using="//span[contains(@class,'x-btn-split x-btn-split-right')]//span[contains(@class,'x-btn-inner-default-small')]")
	private WebElement nav_ViewcalendarDateTitle;	
	
	@FindBy(how=How.XPATH,using="//div[@id='app-nav-picker']//span[text()='OK']")
	private WebElement nav_ViewcalendarChangeMonthYearOkButton;
	
	@FindBy(how=How.XPATH,using="//section[@class='announcement_panel_south']")
	private WebElement nav_ViewcalendarViewAnnouncement;
	
	@FindBy(how=How.XPATH,using="//img[@src='/announcements-portlet/resources/images/PDF_Icon.png']")
	private WebElement nav_AnnouncementPDFLink;
	
	@FindBy(how=How.XPATH,using="//img[@src='/announcements-portlet/resources/images/CSV_Icon.png']")
	private WebElement nav_AnnouncementCSVLink;
	
	@FindBy(how=How.XPATH,using="//div[@id='announcement_body']//menu")
	private WebElement nav_AnnouncementMenuView;
	
	@FindBys({ @FindBy(how=How.XPATH,using="//div[@id='app-calendar-month-details-view']//tr") })
	private List<WebElement> nav_ViewCalendarAnnouncementListonDate;
	
	@FindBy(how=How.XPATH,using="//a[contains(@class,'aui-carousel-menu-item aui-carousel-menu-play')]")
	private WebElement nav_AnnouncementPlayButton;
	
	@FindBy(how=How.XPATH,using="//a[contains(@class,'aui-carousel-menu-item aui-carousel-menu-prev')]")
	private WebElement nav_AnnouncementPrevButton;
	
	@FindBy(how=How.XPATH,using="//a[contains(@class,'aui-carousel-menu-item aui-carousel-menu-next')]")
	private WebElement nav_AnnouncementNextButton;
	
	@FindBy(how=How.XPATH,using="//a[contains(@class,'aui-carousel-menu-item aui-carousel-menu-pause')]")
	private WebElement nav_AnnouncementPauseButton;
	
	// this element is added by NMR 
	@FindBy(how=How.ID, using="maindiv")
	private WebElement nav_AnnouncementWelcomePage;
	
	@FindBy(how=How.XPATH, using="//div[@id='content']//a[text()='Home']")
	private WebElement nav_HomeBreadCrumb;
	
///////////////////////////////////Hosts Url Elements/////////////////////////////////////////
	
   @FindBy(how=How.XPATH,using="html/body/table")
   private WebElement indexOfHostsUrl_Table;

   @FindBy(how=How.XPATH,using="//a[text()='tst-lab2-navigator01/']")
   private WebElement indexOfHostsUrl_tstnav01link;

   @FindBy(how=How.XPATH,using="xhtml:html/xhtml:body/xhtml:pre")
   private WebElement indexOfHostsUrl_FolderData;
   
   @FindBy(how=How.XPATH,using="xhtml:html/xhtml:body/xhtml:div[1]/xhtml:div[2]/xhtml:div[4]/xhtml:div/xhtml:div[1]/xhtml:div[2]")
   private WebElement nav_Document;
   
   

	
	public WebElement getNav_AnnouncementsMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AnnouncementsMenuLink;
	}

	public WebElement getNav_AnnouncementsPortlet() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AnnouncementsPortlet;
	}

	public WebElement getNav_AddNewAnnouncementLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNewAnnouncementLink;
	}

	public WebElement getNav_AddNewAnnouncementWindow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNewAnnouncementWindow;
	}
    
	public WebElement getNav_AddNewAnnouncementDateField() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNewAnnouncementDateField;
	}

	public WebElement getNav_AddNewAnnouncementDCFCategory() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNewAnnouncementDCFCategory;
	}

	public WebElement getNav_AddNewAnnouncementDCFCategory1() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNewAnnouncementDCFCategory1;
	}

	public WebElement getNav_AddNewAnnouncementTimeIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNewAnnouncementTimeIcon;
	}

	public WebElement getNav_AddNewAnnouncementTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNewAnnouncementTitle;
	}
    
	public WebElement getNav_AddNewAnnouncementDetail() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNewAnnouncementDetail;
	}
    
	public WebElement getNav_AddNewAnnouncementDetailHyperlink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNewAnnouncementDetailHyperlink;
	}

	public WebElement getNav_AddNewAnnouncementSaveButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNewAnnouncementSaveButton;
	}
     
	public WebElement getNav_AnnouncementViewCalendarOrBoardLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AnnouncementViewCalendarOrBoardLink;
	}
    
	public WebElement getNav_ViewcalendarViewAnnouncement() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ViewcalendarViewAnnouncement;
	}

	public List<WebElement> getNav_AnnouncementDateMonth() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AnnouncementDateMonth;
	}
	public List<WebElement> getNav_ViewCalendarAnnouncementListonDate() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ViewCalendarAnnouncementListonDate;
	}

	public WebElement getNav_AnnouncementPlayButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AnnouncementPlayButton;
	}

	public WebElement getNav_AnnouncementPrevButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AnnouncementPrevButton;
	}

	public WebElement getNav_AnnouncementNextButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AnnouncementNextButton;
	}

	public WebElement getNav_AnnouncementPauseButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AnnouncementPauseButton;
	}

	public WebElement getNav_AnnouncementPDFLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AnnouncementPDFLink;
	}

	public WebElement getNav_AnnouncementCSVLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AnnouncementCSVLink;
	}

	public WebElement getNav_AddNewAnnouncementIncreaseFont() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNewAnnouncementIncreaseFont;
	}

	public WebElement getNav_AddNewAnnouncementColorPickButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNewAnnouncementColorPickButton;
	}

	public WebElement getNav_AddNewAnnouncementBlueColorButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNewAnnouncementBlueColorButton;
	}

	public WebElement getNav_AddNewAnnouncementDetailText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNewAnnouncementDetailText;
	}

	public WebElement getNav_AddNewAnnouncementDetailUnderline() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNewAnnouncementDetailUnderline;
	}

	public WebElement getNav_AddNewAnnouncementInvalidDateField() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNewAnnouncementInvalidDateField;
	}

	public WebElement getNav_ViewcalendarDateTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ViewcalendarDateTitle;
	}

	public WebElement getNav_ViewcalendarChangeMonthYearOkButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ViewcalendarChangeMonthYearOkButton;
	}

	public WebElement getNav_AnnouncementMenuView() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AnnouncementMenuView;
	}

	public WebElement getNav_AnnouncementMonthinViewCalendar() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AnnouncementMonthinViewCalendar;
	}

	public WebElement getNav_AnnouncementViewCalendarPage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AnnouncementViewCalendarPage;
	}

	public WebElement getNav_AnnouncementViewBoardPage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AnnouncementViewBoardPage;
	}

	public WebElement getNav_AnnouncementMonthBoxinViewcalendar() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AnnouncementMonthBoxinViewcalendar;
	}

	public WebElement getNav_ViewcalendarMonthDisplayed() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ViewcalendarMonthDisplayed;
	}

	public WebElement getNav_AnnouncementWelcomePage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AnnouncementWelcomePage;
	}

	public WebElement getNav_HomeBreadCrumb() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_HomeBreadCrumb;
	}

	public WebElement getNav_AddNewAnnouncementSearchCategoryBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNewAnnouncementSearchCategoryBox;
	}

	public WebElement getNav_AddNewAnnouncementAddRequirementBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNewAnnouncementAddRequirementBox;
	}

	public WebElement getNav_AddNewAnnouncementEmailCheckBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNewAnnouncementEmailCheckBox;
	}

	public WebElement getNav_AddNewAnnouncementAddReqErrorMessage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNewAnnouncementAddReqErrorMessage;
	}
	
	public List<WebElement> getNav_AddNewAnnouncementSearchCategoryValue() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNewAnnouncementSearchCategoryValue;
	}

	public WebElement getIndexOfHostsUrl_Table() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return indexOfHostsUrl_Table;
	}

	public WebElement getIndexOfHostsUrl_tstnav01link() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return indexOfHostsUrl_tstnav01link;
	}

	public WebElement getIndexOfHostsUrl_FolderData() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return indexOfHostsUrl_FolderData;
	}
	

}
