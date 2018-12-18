package com.whs.navigator.pagefactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class FormPageFactory {
	
	@FindBy(how=How.XPATH, using="//span[text()='Forms Approval Status']/../../../../..//div[text()='Forms Approved']")
	private WebElement nav_FormsApprovalStatus;
	
	@FindBy(how=How.XPATH, using="//div[@class='dashboard-sales-HEADER-text']")
	private WebElement nav_FormsPageHeader;
	
	@FindBy(how=How.LINK_TEXT, using="Build Requirements (Forms)")
	private WebElement nav_SupportTabFormsLink;
	
	@FindBy(how=How.LINK_TEXT, using="Click here")
	private WebElement nav_FeedBackClickHereLink;
	
	@FindBy(how=How.ID,using="fbTicketTitle-inputEl")
	private WebElement nav_FeedBackTicketTitle;
	
	//@FindBy(how=How.XPATH,using="*//iframe[Contains(@id,'-inputCmp-iframeEl')]")
	@FindBy(how=How.XPATH,using="*//iframe")
	private WebElement nav_FeedBackTicketNote;
	///////////-Talon-/////////////////////////////
	@FindBy(how=How.ID, using="save-cnfrm-msg")
	private WebElement nav_FormFeedBackArea;
	
	@FindBy(how=How.XPATH,using="//a[contains(@class,'saveContinueClass')]//span[@id='forms-save-icon']")
	private WebElement nav_ContactInfoSaveAndCOntinueButton;
	
	
	
	//cell Phone - Area and code number
	@FindBy(how=How.XPATH,using="//input[@name='cPhone']")
	private WebElement nav_ContactInfoCellPhoneAreaCodeNumberInput;
	
	//E-Mail
	@FindBy(how=How.XPATH,using="//input[@name='email']")
	private WebElement nav_ContactInfoEmailInput;
	
	//Talon -- NMR
    // Updated on 06/24/2016 by QAA03
	//@FindBy(how=How.ID, using="forms-save-icon")
   @FindBy(how=How.XPATH, using="//a[contains(@class,'saveClass')]//span[@id='forms-save-icon']")
	private WebElement nav_ContactInfoSaveButton;
	
	@FindBy(how=How.XPATH, using="//input[@name='escalation']")
	private WebElement nav_ContactInfoEscalationEditField;
	
	//@FindBy(how=How.XPATH, using="//input[@value='Cloud Portal Access - User']")
	//private WebElement nav_ContactInfoUserRoleEditField;
	
	@FindBy(how=How.ID, using="contactInfo-innerCt")
	private WebElement nav_ContactInfoAddContactFormsHeader;
	
	@FindBy(how=How.XPATH, using="//strong[text()='Add Contact']")
	private WebElement nav_ContactInfoAddContactLink;
	
	@FindBy(how=How.XPATH, using="//input[@name='escalation']/../..//div[contains(@id,'-trigger-picker')]")
	private WebElement nav_ContactInfoEscalationDropDownArrow;
	
	@FindBy(how=How.XPATH, using="//input[@name='userRole']/../..//div[contains(@id,'-trigger-picker')]")
	private WebElement nav_ContactInfoUserRoleDropDownArrow;
	
	@FindBy(how=How.ID, using="forms-submit-icon")
	private WebElement nav_ContactInfoReviewAndSubmitBtn;
	
	@FindBy(how=How.LINK_TEXT, using="Contact Information")
	private WebElement nav_ReviewAndSubmit_ContactInformationLink;
	
	//@FindBy(how=How.XPATH, using="//span[text()='Forms Approval Status']/../../../../..//div[text()='Forms Approved']")
	//private WebElement nav_FormsApprovalStatus;
	
	@FindBy(how=How.XPATH, using="//div[@id='RFN_maindiv']//div[contains(@id,'-body')][contains(@class,'x-docked-noborder-right x-docked-noborder-left')]")
	private WebElement nav_RejectdFormWebTableParent;
	
	
	@FindBy(how=How.LINK_TEXT, using="//span[text()='OK']")
	private WebElement nav_ResetContactFormOkButton;
	
	//Contact Information Page details
	
		//First Name
		@FindBy(how=How.XPATH,using="//input[@name='firstName']")
		private WebElement nav_ContactInfoFirstNameInput;
		
		//Last Name
		@FindBy(how=How.XPATH,using="//input[@name='lastName']")
		private WebElement nav_ContactInfoLastNameInput;
		
		/*//E-Mail
		@FindBy(how=How.XPATH,using="//input[@name='email']")
		private WebElement nav_ContactInfoEmailInput;
		*/
		//Work Phone - Country Code dropdown arrow
		@FindBy(how=How.XPATH,using="//div[contains(@class,'contact-info-table-layout')]//tr//table//tr//div[contains(@class,'item-no-label x-field-focus')]//div[contains(@class,'arrow-trigger')]")
		private WebElement nav_ContactInfoCountryCodeDropDownArrow;
		
		//Work Phone - Country Code UL
		@FindBy(how=How.XPATH,using="//li[contains(text(),'United States')]/..")
		private WebElement nav_ContactInfoCountryCodeDropDownList;
		
		//Work Phone - Area Code & Phone number
		@FindBy(how=How.XPATH,using="//input[@name='wPhone']")
		private WebElement nav_ContactInfoAreaCodePhoneNumberInput;
			
		//Work Phone - Ext
		@FindBy(how=How.XPATH,using="//input[@name='wphoneExt']")
		private WebElement nav_ContactInfoPhoneExtInput;
		
		//cell Phone - Area and code number
		//@FindBy(how=How.XPATH,using="//input[@name='cPhone']")
		//private WebElement nav_ContactInfoCellPhoneAreaCodeNumberInput;
		
		//Reset Button
		@FindBy(how=How.XPATH,using="//span[text()='Reset']")
		private WebElement nav_ContactInfoResetButton;
		
		//Delete Button
		@FindBy(how=How.XPATH,using="//span[text()='Delete']")
		private WebElement nav_ContactInfoDeleteButton;
		
		//total Sales available
		@FindBys(@FindBy(how=How.XPATH,using="//div[@id='incompleteOrders_maindiv']//div[contains(@id,'innerCt')]/div[contains(@id,'form') and contains(@class,'incomplete')]"))
		private List<WebElement> nav_SalesOrderPortlet;
		
		//Build Requirements - Incomplete forms block
		@FindBy(how=How.XPATH,using="//a[contains(@id,'headerbutton')][1]")
		private WebElement nav_IncompleteFormBlk;
		
		//Build Requirements - table for incomplete forms
		@FindBy(how=How.XPATH,using="//div[@id='idFormsGridPanel-body']//div[@class='x-grid-item-container']")
		private WebElement nav_IncompleteFormsTable;
		
		
		@FindBy(how=How.XPATH,using="//div[@id='formPanel_1-outerCt']//a/span/span/span[text()='Reset']")
		private WebElement nav_EditFormResetButton;
		
		@FindBy(how=How.XPATH,using="//div[@id='formPanel_1-outerCt']//a/span/span/span[text()='Delete']")
		private WebElement nav_EditFormDeleteButton;
		
///////////////////////////////Added by QAA03 for Kyle TestCase//////////////////////////
		
@FindBy(how=How.XPATH, using="//a[1]//span[contains(@id,'greenbutton-') and contains(@class,'x-btn-inner')]")
private WebElement nav_FormsSalesOrderSelectedHeaderNameButton;

@FindBy(how=How.ID, using="idOrderDetailsWnd")
private WebElement nav_FormsSalesOrderWindow;

@FindBy(how=How.XPATH, using="//input[@role='checkbox']")
private WebElement nav_FormsSalesOrderWindowExpandAllCheckbox;

@FindBy(how=How.ID, using="idSalesOrderDetailGrid-body")
private WebElement nav_FormsSalesOrderWindowWebTable;

@FindBy(how=How.XPATH, using="//div[3]/div/div/div[2]")
private WebElement nav_FormsSalesOrderDetailColumn;

@FindBy(how=How.XPATH, using="//div[3]/div/div/div[contains(@class,'x-column-header-last')]")
private WebElement nav_FormsSalesOrderQuantityColumn;

@FindBy(how=How.XPATH, using="//div[@id='idSalesOrderGridToolbar-targetEl']//img[contains(@src,'/PDF_Icon.png')]")
private WebElement nav_FormsSalesOrderPopUpPDFIcon;

@FindBy(how=How.XPATH, using="//div[@id='idSalesOrderGridToolbar-targetEl']//img[contains(@src,'/CSV_Icon.png')]")
private WebElement nav_FormsSalesOrderPopUpCSVIcon;

@FindBy(how=How.ID, using="idSalesOrderDetailGrid_header")
private WebElement nav_FormsSalesOrderPopUpHeadername;

@FindBy(how=How.XPATH, using="//a[2]//span[contains(@id,'greenbutton-') and contains(@class,'x-btn-inner')]")
private WebElement nav_Forms_MYCIMButton;

@FindBy(how=How.ID, using="idHDContactWindow")
private WebElement nav_Forms_MYCIMPopUpWindow;

@FindBy(how=How.XPATH, using="//table[@id='idHDContactWindow-table']//tr[1]//span")
private WebElement nav_Forms_MYCIMPopUp_Name;

@FindBy(how=How.XPATH, using="//table[@id='idHDContactWindow-table']//tr[2]//span")
private WebElement nav_Forms_MYCIMPopUp_Designation;

@FindBy(how=How.XPATH, using="//table[@id='idHDContactWindow-table']//tr[4]/td[1]//span[1]")
private WebElement nav_Forms_MYCIMPopUp_CIMPhone;

@FindBy(how=How.XPATH, using="//table[@id='idHDContactWindow-table']//tr[4]/td[1]//span[2]")
private WebElement nav_Forms_MYCIMPopUp_TierPointPhone;

@FindBy(how=How.XPATH, using="//table[@id='idHDContactWindow-table']//tr[6]/td[1]//a[1]")
private WebElement nav_Forms_MYCIMPopUp_CIMEmail;

@FindBy(how=How.XPATH, using="//table[@id='idHDContactWindow-table']//tr[6]/td[1]//a[2]")
private WebElement nav_Forms_MYCIMPopUp_SupportEmail;

@FindBy(how=How.XPATH, using="//img[contains(@src,'Phone.jpg')]")
private WebElement nav_Forms_MYCIMPopUp_PhoneImage;

@FindBy(how=How.XPATH, using="//img[contains(@src,'Email.jpg')]")
private WebElement nav_Forms_MYCIMPopUp_EmailImage;

@FindBy(how=How.ID, using="completed_orders_maindiv")
private WebElement nav_Forms_CompletedOrdersSection;

@FindBy(how=How.ID, using="tbtext-1561")
private WebElement nav_Forms_CompletedOrders_PageOrdersCount;

@FindBy(how=How.XPATH, using="//div[@id='completed_orders_maindiv']//span[contains(@class,'x-tbar-page-next')]")
private WebElement nav_Forms_CompletedOrders_PageOrdersNextButton;

@FindBy(how=How.XPATH, using="//ul[contains(@class,'breadcrumbs')]//li[2]//a[contains(@href,'/forms')]")
private WebElement nav_FormsBreadCrumb;

@FindBy(how=How.ID, using="idMenuButton")
private WebElement nav_Forms_ReviewAndSubmit_LeftMenuButton;

@FindBy(how=How.ID, using="idCustomerDashboardWnd")
private WebElement nav_Forms_ReviewAndSubmit_LeftMenuWindow;

@FindBy(how=How.XPATH, using="//div[@id='idCustomerDashboardWnd-innerCt']//div[@class ='cd-text-cls']")
private WebElement nav_Forms_ReviewAndSubmit_LeftMenuWindow_TicketNumber;

@FindBy(how=How.XPATH, using="//div[@id='completed_orders_maindiv']//div[contains(@class,'-sort-DESC')]//span[@class='x-column-header-text']")
private WebElement nav_Forms_CompletedOrders_FirstColumn;

@FindBy(how=How.XPATH, using="//div[@id='idCustomerDashboardWnd-innerCt']//label[contains(@class,'cd-text-cls')]")
private WebElement nav_Forms_ReviewAndSubmit_LeftMenuWindow_TicketText;

@FindBy(how=How.XPATH, using="//div[@id='idCustomerDashboardWnd-innerCt']//label[contains(@class,'cd-text-cls')]")
private WebElement nav_Forms_ReviewAndSubmit_LeftMenuWindow_CustomerDashboardArea;
		
	///////////////////////////////////////////////////////////////////////////////////
	public WebElement getNav_FeedBackTicketNote(){
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FeedBackTicketNote;
	}
	
	public WebElement getNav_FeedBackTicketTitle(){
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FeedBackTicketTitle;
	}
	
	public WebElement getNav_FeedBackClickHereLink(){
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FeedBackClickHereLink;
	}
	
	public WebElement getNav_FormsPageHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FormsPageHeader;
	}
	
	public WebElement getNav_SupportTabFormsLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SupportTabFormsLink;
	}

	public WebElement getNav_FormsApprovalStatus() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FormsApprovalStatus;
	}

	public WebElement getNav_ContactInfoCellPhoneAreaCodeNumberInput() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ContactInfoCellPhoneAreaCodeNumberInput;
	}

	public WebElement getNav_ContactInfoEmailInput() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ContactInfoEmailInput;
	}

	public WebElement getNav_ContactInfoSaveButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ContactInfoSaveButton;
	}

	public WebElement getNav_ContactInfoEscalationEditField() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ContactInfoEscalationEditField;
	}

	public WebElement getNav_ContactInfoAddContactFormsHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ContactInfoAddContactFormsHeader;
	}

	public WebElement getNav_ContactInfoAddContactLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ContactInfoAddContactLink;
	}

	public WebElement getNav_ContactInfoEscalationDropDownArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ContactInfoEscalationDropDownArrow;
	}

	public WebElement getNav_ContactInfoUserRoleDropDownArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ContactInfoUserRoleDropDownArrow;
	}

	public WebElement getNav_ContactInfoReviewAndSubmitBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ContactInfoReviewAndSubmitBtn;
	}

	public WebElement getNav_ReviewAndSubmit_ContactInformationLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ReviewAndSubmit_ContactInformationLink;
	}

	public WebElement getNav_RejectdFormWebTableParent() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_RejectdFormWebTableParent;
	}

	public WebElement getNav_ResetContactFormOkButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ResetContactFormOkButton;
	}

	public WebElement getNav_ContactInfoFirstNameInput() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ContactInfoFirstNameInput;
	}

	public WebElement getNav_ContactInfoLastNameInput() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ContactInfoLastNameInput;
	}

	public WebElement getNav_ContactInfoCountryCodeDropDownArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ContactInfoCountryCodeDropDownArrow;
	}

	public WebElement getNav_ContactInfoCountryCodeDropDownList() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ContactInfoCountryCodeDropDownList;
	}

	public WebElement getNav_ContactInfoAreaCodePhoneNumberInput() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ContactInfoAreaCodePhoneNumberInput;
	}

	public WebElement getNav_ContactInfoPhoneExtInput() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ContactInfoPhoneExtInput;
	}

	public WebElement getNav_ContactInfoResetButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ContactInfoResetButton;
	}

	public WebElement getNav_ContactInfoDeleteButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ContactInfoDeleteButton;
	}

	public List<WebElement> getNav_SalesOrderPortlet() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SalesOrderPortlet;
	}

	public WebElement getNav_IncompleteFormBlk() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_IncompleteFormBlk;
	}

	public WebElement getNav_IncompleteFormsTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_IncompleteFormsTable;
	}

	public WebElement getNav_FormFeedBackArea() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FormFeedBackArea;
	}

	public WebElement getNav_ContactInfoSaveAndCOntinueButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ContactInfoSaveAndCOntinueButton;
	}

	public WebElement getNav_EditFormResetButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditFormResetButton;
	}

	public WebElement getNav_EditFormDeleteButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditFormDeleteButton;
	}

	public WebElement getNav_FormsSalesOrderSelectedHeaderNameButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FormsSalesOrderSelectedHeaderNameButton;
	}

	public WebElement getNav_FormsSalesOrderWindow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FormsSalesOrderWindow;
	}

	public WebElement getNav_FormsSalesOrderWindowExpandAllCheckbox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FormsSalesOrderWindowExpandAllCheckbox;
	}

	public WebElement getNav_FormsSalesOrderWindowWebTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FormsSalesOrderWindowWebTable;
	}

	public WebElement getNav_FormsSalesOrderDetailColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FormsSalesOrderDetailColumn;
	}

	public WebElement getNav_FormsSalesOrderQuantityColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FormsSalesOrderQuantityColumn;
	}

	public WebElement getNav_FormsSalesOrderPopUpPDFIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FormsSalesOrderPopUpPDFIcon;
	}

	public WebElement getNav_FormsSalesOrderPopUpCSVIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FormsSalesOrderPopUpCSVIcon;
	}

	public WebElement getNav_FormsSalesOrderPopUpHeadername() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FormsSalesOrderPopUpHeadername;
	}

	public WebElement getNav_Forms_MYCIMButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Forms_MYCIMButton;
	}

	public WebElement getNav_Forms_MYCIMPopUpWindow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Forms_MYCIMPopUpWindow;
	}

	public WebElement getNav_Forms_MYCIMPopUp_Name() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Forms_MYCIMPopUp_Name;
	}

	public WebElement getNav_Forms_MYCIMPopUp_Designation() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Forms_MYCIMPopUp_Designation;
	}

	public WebElement getNav_Forms_MYCIMPopUp_CIMPhone() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Forms_MYCIMPopUp_CIMPhone;
	}

	public WebElement getNav_Forms_MYCIMPopUp_TierPointPhone() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Forms_MYCIMPopUp_TierPointPhone;
	}

	public WebElement getNav_Forms_MYCIMPopUp_CIMEmail() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Forms_MYCIMPopUp_CIMEmail;
	}

	public WebElement getNav_Forms_MYCIMPopUp_SupportEmail() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Forms_MYCIMPopUp_SupportEmail;
	}

	public WebElement getNav_Forms_MYCIMPopUp_PhoneImage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Forms_MYCIMPopUp_PhoneImage;
	}

	public WebElement getNav_Forms_MYCIMPopUp_EmailImage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Forms_MYCIMPopUp_EmailImage;
	}

	public WebElement getNav_Forms_CompletedOrdersSection() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Forms_CompletedOrdersSection;
	}

	public WebElement getNav_Forms_CompletedOrders_PageOrdersCount() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Forms_CompletedOrders_PageOrdersCount;
	}

	public WebElement getNav_Forms_CompletedOrders_PageOrdersNextButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Forms_CompletedOrders_PageOrdersNextButton;
	}

	public WebElement getNav_FormsBreadCrumb() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FormsBreadCrumb;
	}

	public WebElement getNav_Forms_ReviewAndSubmit_LeftMenuButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Forms_ReviewAndSubmit_LeftMenuButton;
	}

	public WebElement getNav_Forms_ReviewAndSubmit_LeftMenuWindow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Forms_ReviewAndSubmit_LeftMenuWindow;
	}

	public WebElement getNav_Forms_ReviewAndSubmit_LeftMenuWindow_TicketNumber() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Forms_ReviewAndSubmit_LeftMenuWindow_TicketNumber;
	}

	public WebElement getNav_Forms_CompletedOrders_FirstColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Forms_CompletedOrders_FirstColumn;
	}

	public WebElement getNav_Forms_ReviewAndSubmit_LeftMenuWindow_TicketText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Forms_ReviewAndSubmit_LeftMenuWindow_TicketText;
	}

	public WebElement getNav_Forms_ReviewAndSubmit_LeftMenuWindow_CustomerDashboardArea() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Forms_ReviewAndSubmit_LeftMenuWindow_CustomerDashboardArea;
	}

	
}
