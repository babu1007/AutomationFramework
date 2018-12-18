package com.whs.navigator.pagefactory.dev.old;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;



public class EVDC_VM_AdvancedActions_PageFactory {
	
	@FindBy(how=How.ID, using="gridview-1010-body")
	private WebElement nav_EVDCVMTable;
	//Advanced Actions
	@FindBy(how=How.LINK_TEXT,using="Advanced Actions")
	private WebElement nav_EVDCAdvancedActionsLink;
	
	
	//Advanced Actions
	@FindBy(how=How.LINK_TEXT,using="Save VM as Template")
	private WebElement nav_EVDCSaveVMTemplateLink;
	
	@FindBy(how=How.LINK_TEXT,using="Mount Media (ISO) from Catalog")
	private WebElement nav_EVDCMountMediaLink;
	
	//mount media popup
	@FindBy(how=How.ID, using="mountIsoPopup")
	private WebElement nav_EVDCmountIsoPopup;
	
	@FindBy(how=How.XPATH, using="//*[@id='mountIsoPopup']/button/img")
	private WebElement nav_EVDCmountIsoPopupClose;
	
	@FindBy(how=How.ID, using="mountIsoComboDiv")
	private WebElement nav_EVDCMountMediaParentDiv;
	
	
	// Mount Media table 
	@FindBy(how=How.ID, using="mountName-textEl")
	private WebElement nav_EVDCMountNameTableHeader;

	@FindBy(how=How.ID, using="mountCatalog-textEl")
	private WebElement nav_EVDCMountCatalogTableHeader;
	
	@FindBy(how=How.ID, using="mountUsed-textEl")
	private WebElement nav_EVDCStorageUsedTableHeader;
		
	
	
	//@FindBy(how=How.XPATH, using="//*[@id='mountIsoComboDiv']//table/tbody[contains(@id,'gridview-')]")
	@FindBy(how=How.XPATH, using="//*[@id='mountIsoComboDiv']//table[contains(@id,'gridview-')]")
	private WebElement nav_EVDCMountMediaTable;
	
	@FindBy(how=How.LINK_TEXT,using="Insert")
	private WebElement nav_EVDCMountMediaInsertBtn;
	
	@FindBy(how=How.LINK_TEXT,using="Cancel")
	private WebElement nav_EVDCMountMediaCancelBtn;
	
	
	//confirm popup
	
	@FindBy(how=How.ID, using="messagebox-1001")
	private WebElement nav_EVDCConfirmPopup;
	
	
	
	@FindBy(how=How.ID, using="button-1008-btnIconEl")
	private WebElement nav_EVDCConfirmPopupCancelBtn;
	
	//@FindBy(how=How.ID, using="button-1005-btnIconEl")
	
	@FindBy(how=How.XPATH, using="//span[contains(@id,'button-')]//span[text()='OK']")
	private WebElement nav_EVDCConfirmPopupOkBtn;	
	

	@FindBy(how=How.ID, using="navpopupbody")
	private WebElement nav_EVDCConfirmNewPopup;
	
	@FindBy(how=How.XPATH, using="//div[@id='navpopupbuttons']/span/a[contains(text(),'Ok')]")
	private WebElement nav_EVDCConfirmNewPopupOKBtn;
	
	@FindBy(how=How.XPATH, using="//div[@id='navpopupbuttons']/span/a[contains(text(),'Cancel')]")
	private WebElement nav_EVDCConfirmNewPopupCancelBtn;
	
	//success msg on main page
	@FindBy(how=How.ID, using="userfeedback")
	private WebElement nav_EVDCSuccessMsg;

	
	@FindBy(how=How.LINK_TEXT,using="Eject Media")
	private WebElement nav_EVDCEjectMediaLink;
	
	
	@FindBy(how=How.ID, using="ejectIsoPopup")
	private WebElement nav_EVDCEjectIsoPopup;
	
	@FindBy(how=How.XPATH, using="//*[@id='ejectIsoPopup']/button/img")
	private WebElement nav_EVDCEjectIsoPopupClose;
	
	@FindBy(how=How.LINK_TEXT,using="Cancel")
	private WebElement nav_EVDC_Advanced_Dialog_CancelBtn;
	
	// This object is updated by QAA04 -- 11/19/15
	//@FindBy(how=How.XPATH, using="//*[@id='navpopupbuttons']//a[contains(text(),'Ok')]")
	@FindBy(how=How.LINK_TEXT,using="OK")
	private WebElement nav_EVDC_Advanced_Dialog_OkBtn;

	@FindBy(how=How.ID, using="tool-1056-toolEl")
	private WebElement nav_EVDC_Advanced_Dialog_Close;
	
	@FindBy(how=How.ID, using="saveAsTemplateWindow")
	private WebElement nav_EVDCsaveAsTemplateWindow;
	
	
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'saveAsTemplateName-')]")
	private WebElement nav_EVDCsaveAsTemplateNameEdit;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'saveAsTemplateDesc-')]")
	private WebElement nav_EVDCsaveAsTemplateDescEdit;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'saveToCatalogCombo-')]")
	private WebElement nav_EVDCsaveToCatalogCombo;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'saveToCatalogCombo-')]/..")
	private WebElement nav_EVDCsaveToCatalogComboParentObject;
	
	
	@FindBy(how=How.XPATH, using="//div[1][contains(@id,'boundlist-')]/ul")
	private WebElement nav_EVDCsaveToCatalogComboDropDown;
	
	@FindBy(how=How.LINK_TEXT,using="Save")
	private WebElement nav_EVDC_Advanced_Dialog_SaveBtn;
	
	//delete VM
	@FindBy(how=How.LINK_TEXT,using="Delete VM")
	private WebElement nav_EVDCDeleteVMLink;
	
	@FindBy(how=How.ID, using="deleteVMPopup")
	private WebElement nav_EVDCDeleteVMPopup;
	
	@FindBy(how=How.ID, using="deleteVMBtn")
	private WebElement nav_EVDCDeleteVMBtn;
	
	//copy VM
	@FindBy(how=How.LINK_TEXT,using="Copy VM to new VM")
	private WebElement nav_EVDCcopyVMLink;
		
	@FindBy(how=How.ID, using="navpopupbody")
	private WebElement nav_EVDCcopyVMPopup;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'copyvmname')]")
	private WebElement nav_EVDCcopyVMnameEdit;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'copyvmspname-urn')]")
	private WebElement nav_EVDCcopyVMnameParentDropdown;
		
	@FindBy(how=How.XPATH, using="//ul[contains(@class,'x-list-plain')]")
	private WebElement nav_EVDCcopyVMnameDropdown;
	
	@FindBy(how=How.ID, using="copyVMBtn")
	private WebElement nav_EVDCcopyVMBtn;
	
	@FindBy(how=How.LINK_TEXT,using="Copy")
	private WebElement nav_EVDCcopyVMBotton;
	
	@FindBy(how=How.XPATH, using="//div[@id='navpopupbuttons']//span/a[contains(text(),'Ok')]")
	private WebElement nav_EVDCcopyOkBtn;


	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	public WebElement getNav_EVDCVMTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCVMTable;
	}

	public WebElement getNav_EVDCAdvancedActionsLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCAdvancedActionsLink;
	}

	public WebElement getNav_EVDCMountMediaLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCMountMediaLink;
	}

	public WebElement getNav_EVDCmountIsoPopup() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCmountIsoPopup;
	}

	public WebElement getNav_EVDCmountIsoPopupClose() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCmountIsoPopupClose;
	}

	public WebElement getNav_EVDCMountMediaParentDiv() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCMountMediaParentDiv;
	}

	public WebElement getNav_EVDCMountNameTableHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCMountNameTableHeader;
	}

	public WebElement getNav_EVDCMountCatalogTableHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCMountCatalogTableHeader;
	}

	public WebElement getNav_EVDCStorageUsedTableHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCStorageUsedTableHeader;
	}

	public WebElement getNav_EVDCMountMediaTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCMountMediaTable;
	}

	public WebElement getNav_EVDCMountMediaInsertBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCMountMediaInsertBtn;
	}

	public WebElement getNav_EVDCMountMediaCancelBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCMountMediaCancelBtn;
	}

	public WebElement getNav_EVDCConfirmPopup() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCConfirmPopup;
	}

	public WebElement getNav_EVDCConfirmPopupCancelBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCConfirmPopupCancelBtn;
	}

	public WebElement getNav_EVDCConfirmPopupOkBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCConfirmPopupOkBtn;
	}

	public WebElement getNav_EVDCSuccessMsg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCSuccessMsg;
	}

	public WebElement getNav_EVDCEjectMediaLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCEjectMediaLink;
	}

	public WebElement getNav_EVDCEjectIsoPopup() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCEjectIsoPopup;
	}

	public WebElement getNav_EVDCEjectIsoPopupClose() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCEjectIsoPopupClose;
	}

	public WebElement getNav_EVDC_Advanced_Dialog_CancelBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDC_Advanced_Dialog_CancelBtn;
	}

	public WebElement getNav_EVDC_Advanced_Dialog_OkBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDC_Advanced_Dialog_OkBtn;
	}
	
	public WebElement getNav_EVDCSaveVMTemplateLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCSaveVMTemplateLink;
	}
	
		
	
	public WebElement getNav_EVDCsaveAsTemplateNameEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCsaveAsTemplateNameEdit;
	}
	
	public WebElement getNav_EVDCsaveAsTemplateDescEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCsaveAsTemplateDescEdit;
	}	
			
	public WebElement getNav_EVDCsaveToCatalogComboDropDown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCsaveToCatalogComboDropDown;
	}
	
	public WebElement getNav_EVDCsaveToCatalogCombo() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCsaveToCatalogCombo;
	}
	
	
	
	public WebElement getNav_EVDC_Advanced_Dialog_SaveBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDC_Advanced_Dialog_SaveBtn;
	}
	
	
	public WebElement getNav_EVDC_Advanced_Dialog_Close() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDC_Advanced_Dialog_Close;
	}
	
	public WebElement getNav_EVDCsaveAsTemplateWindow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCsaveAsTemplateWindow;
	}
	
	public WebElement getNav_EVDCsaveToCatalogComboParentObject() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCsaveToCatalogComboParentObject;
	}

	public WebElement getNav_EVDCDeleteVMLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCDeleteVMLink;
	}

	public WebElement getNav_EVDCDeleteVMPopup() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCDeleteVMPopup;
	}

	public WebElement getNav_EVDCDeleteVMBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCDeleteVMBtn;
	}

	public WebElement getNav_EVDCcopyVMLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCcopyVMLink;
	}

	public WebElement getNav_EVDCcopyVMnameEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCcopyVMnameEdit;
	}

	public WebElement getNav_EVDCcopyVMBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCcopyVMBtn;
	}

	public WebElement getNav_EVDCcopyVMnameParentDropdown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCcopyVMnameParentDropdown;
	}

	public WebElement getNav_EVDCcopyVMnameDropdown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCcopyVMnameDropdown;
	}

	public WebElement getNav_EVDCcopyVMBotton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCcopyVMBotton;
	}

	public WebElement getNav_EVDCcopyVMPopup() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCcopyVMPopup;
	}

	public WebElement getNav_EVDCcopyOkBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCcopyOkBtn;
	}

	public WebElement getNav_EVDCConfirmNewPopup() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCConfirmNewPopup;
	}

	public WebElement getNav_EVDCConfirmNewPopupOKBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCConfirmNewPopupOKBtn;
	}

	public WebElement getNav_EVDCConfirmNewPopupCancelBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCConfirmNewPopupCancelBtn;
	}


	
}
