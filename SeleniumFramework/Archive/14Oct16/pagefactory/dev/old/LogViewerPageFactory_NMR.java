package com.whs.navigator.pagefactory.dev.old;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class LogViewerPageFactory_NMR {

	@FindBy(how=How.ID, using="dateFrom-trigger-picker")
	private WebElement navStartDateIcon;
	
	@FindBy(how=How.ID, using="dateTo-trigger-picker")
	private WebElement navEndDateICon;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'datepicker-')][contains(@id,'-prevEl')]")
	private WebElement navStartDateIcon_PreviousMonthIcon;
	
	@FindBy(how=How.ID, using="showLog-btnInnerEl")
	private WebElement navViewLogBtn;

	@FindBy(how=How.XPATH, using="//div[@class='x-box-inner']//span[text()='Server']")
	private WebElement navServerColumn;
	
	@FindBy(how=How.XPATH, using="//label[contains(text(),'Automation Request Status')]/../input")
	private WebElement navAutomationRequestStatusRadioBtn;
	
	@FindBy(how=How.ID, using="requestStatusDD-trigger-picker")
	private WebElement navIACStatusDropDownArrow;
	
	@FindBy(how=How.ID, using="requestStatusDD-inputEl")
	private WebElement navIACStatusDropDownEditBox;
	
	@FindBy(how=How.ID, using="org-trigger-picker")
	private WebElement navOrgDropDownArrow;
	
	@FindBy(how=How.ID, using="org-inputEl")
	private WebElement navOrgDropDownEditBox;
	
	@FindBy(how=How.ID, using="dateFrom")
	private WebElement navDateFromDivision;
	
	@FindBy(how=How.ID, using="dateTo")
	private WebElement navDateToDivision;
	
	@FindBy(how=How.ID, using="req-textEl")
	private WebElement navRequisitionIdColumnHeader;
	
	@FindBy(how=How.ID, using="act-textEl")
	private WebElement navActionColumnHeader;
	
	@FindBy(how=How.ID, using="dtcreated-textEl")
	private WebElement navDateCreatedColumnHeader;
	
	@FindBy(how=How.ID, using="status-textEl")
	private WebElement navStatusColumnHeader;
	
	@FindBy(how=How.ID, using="resetBtn-btnInnerEl")
	private WebElement navResetBtn;
	
	@FindBy(how=How.ID, using="reqStatusGridPanel-body")
	private WebElement navWebTableParent;
	
	@FindBy(how=How.XPATH, using="//a[@id='pdfLink']/img")
	private WebElement navPDFIcon;
	
	@FindBy(how=How.XPATH, using="//a[@id='csvLink']/img")
	private WebElement navCSVIcon;
	
////////////////////////////////////////////QAA03/////////////////////////////////////////////
	
//@FindBy(how=How.LINK_TEXT,using="Log Viewer")
@FindBy(how=How.XPATH, using="//div[@id='tpRebrandWrapper']//ul//ul//a[text()='Log Viewer']")
private WebElement nav_LogViewerlink;

@FindBy(how=How.XPATH, using="//div[text()='Portal Action Log']")
private WebElement nav_LogviewerPortalActionLogText;

@FindBy(how=How.ID, using="dateFrom-inputEl")
private WebElement nav_LogViewerDateFromInputBox;

@FindBy(how=How.ID, using="dateTo-inputEl")
private WebElement nav_LogViewerDateToInputBox;

@FindBy(how=How.ID, using="navlogpanel-body")
private WebElement nav_LogViewerWebTableDataParent;

@FindBy(how=How.ID, using="emailContentPanel")
private WebElement nav_LogViewerEmailwindow;

@FindBy(how=How.XPATH, using="//iframe[@id='bcchtmledit-inputCmp-iframeEl']")
private WebElement nav_LogViewerEmailContentWindowBccField;

@FindBy(how=How.XPATH, using="html/body/a")
private WebElement nav_LogViewerEmailContentWindowBccAdminEmailText;

@FindBy(how=How.XPATH, using="html/body/a[2]")
private WebElement nav_LogViewerEmailContentWindowBccEmailText;

@FindBy(how=How.XPATH, using="//div[@id='emailContentPanel-targetEl']/div[5]//input")
private WebElement nav_LogViewerEmailContentWindowSubjectText;

@FindBy(how=How.XPATH, using="//div[@id='emailContentPanel-targetEl']/div[1]//input")
private WebElement nav_LogViewerEmailContentWindowToText;

@FindBy(how=How.ID, using="idCloseButton")
private WebElement nav_LogViewerEmailContentWindowCloseButton;
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	public WebElement getNavStartDateIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navStartDateIcon;
	}

	public WebElement getNavServerColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navServerColumn;
	}

	public WebElement getNavEndDateICon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navEndDateICon;
	}

	public WebElement getNavStartDateIcon_PreviousMonthIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navStartDateIcon_PreviousMonthIcon;
	}

	public WebElement getNavViewLogBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navViewLogBtn;
	}

	public WebElement getNavAutomationRequestStatusRadioBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navAutomationRequestStatusRadioBtn;
	}

	public WebElement getNavIACStatusDropDownArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navIACStatusDropDownArrow;
	}

	public WebElement getNavIACStatusDropDownEditBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navIACStatusDropDownEditBox;
	}

	public WebElement getNavOrgDropDownArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navOrgDropDownArrow;
	}

	public WebElement getNavOrgDropDownEditBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navOrgDropDownEditBox;
	}

	public WebElement getNavDateFromDivision() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navDateFromDivision;
	}

	public WebElement getNavDateToDivision() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navDateToDivision;
	}

	public WebElement getNavRequisitionIdColumnHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navRequisitionIdColumnHeader;
	}

	public WebElement getNavActionColumnHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navActionColumnHeader;
	}

	public WebElement getNavDateCreatedColumnHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navDateCreatedColumnHeader;
	}

	public WebElement getNavStatusColumnHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navStatusColumnHeader;
	}

	public WebElement getNavResetBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navResetBtn;
	}

	public WebElement getNavWebTableParent() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navWebTableParent;
	}

	public WebElement getNavPDFIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navPDFIcon;
	}

	public WebElement getNavCSVIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navCSVIcon;
	}

	public WebElement getNav_LogViewerlink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_LogViewerlink;
	}

	public WebElement getNav_LogviewerPortalActionLogText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_LogviewerPortalActionLogText;
	}

	public WebElement getNav_LogViewerDateFromInputBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_LogViewerDateFromInputBox;
	}

	public WebElement getNav_LogViewerDateToInputBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_LogViewerDateToInputBox;
	}

	public WebElement getNav_LogViewerWebTableDataParent() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_LogViewerWebTableDataParent;
	}

	public WebElement getNav_LogViewerEmailwindow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_LogViewerEmailwindow;
	}
	
	public WebElement getNav_LogViewerEmailContentWindowBccField() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_LogViewerEmailContentWindowBccField;
	}

	public WebElement getNav_LogViewerEmailContentWindowBccAdminEmailText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_LogViewerEmailContentWindowBccAdminEmailText;
	}
	
	public WebElement getNav_LogViewerEmailContentWindowBccEmailText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_LogViewerEmailContentWindowBccEmailText;
	}

	public WebElement getNav_LogViewerEmailContentWindowSubjectText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_LogViewerEmailContentWindowSubjectText;
	}

	public WebElement getNav_LogViewerEmailContentWindowToText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_LogViewerEmailContentWindowToText;
	}

	public WebElement getNav_LogViewerEmailContentWindowCloseButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_LogViewerEmailContentWindowCloseButton;
	}
	

	
}
