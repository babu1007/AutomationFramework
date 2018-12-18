package com.whs.navigator.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class ZathrasPageFactory_Sukur
{

	@FindBy(how=How.XPATH, using ="//div[@id='comps']//a[text()='Add a Storage Threshold']")
	private WebElement nav_AddaStorageThresholdLink;
	
	@FindBy(how=How.XPATH, using ="//div[@id='mainGrid-body']//td[1]//div[text()='Default']")
	private WebElement nav_ThresholdTableFirstcolumnDefaultCell;

	@FindBy(how=How.ID, using ="hs_msgbox_0")
	private WebElement nav_NothingChanngedPopup;
	
	@FindBy(how=How.XPATH, using ="//div[@id='hs_msgbox_0']//span[text()='OK']")
	private WebElement nav_NothingChanngedPopupOKButton;
	
	@FindBy(how=How.ID, using ="add_threshold_form_header-innerCt")
	private WebElement nav_AddThresholdPopupTitle;

	@FindBy(how=How.ID, using ="add-thres-loc-inputEl")
	private WebElement nav_AddThresholdPopupLocationInput;
	
	@FindBy(how=How.XPATH, using ="//div[@id='add_threshold_form']/following-sibling::div[contains(@id,'boundlist')][@tabindex='-1']//ul")
	private WebElement nav_AddThresholdPopupLocationdropdown;
	
	@FindBy(how=How.ID, using ="add-thres-sp-inputEl")
	private WebElement nav_AddThresholdPopupStragePlcyInput;
	
	//@FindBy(how=How.XPATH, using ="//div[@id='add_threshold_form']/following-sibling::div[contains(@id,'boundlist')][@tabindex='0']//ul")
	@FindBy(how=How.XPATH, using ="//div[contains(@id,'boundlist')][@tabindex='-1']//ul")
	private WebElement nav_AddThresholdPopupStragePlcyDropdown;
	
	@FindBy(how=How.ID, using ="display_vdc_threshold-inputEl")
	private WebElement nav_AddThresholdPopupVCDThresholdInput;
	
	@FindBy(how=How.ID, using ="display_ds_threshold-inputEl")
	private WebElement nav_AddThresholdPopupDSThresholdInput;
	
	@FindBy(how=How.XPATH, using ="//div[@id='add_threshold_form-body']/following-sibling::div[contains(@id,'toolbar')]//span[text()='Save']")
	private WebElement nav_AddThresholdPopupSaveButton;
	
	@FindBy(how=How.XPATH, using ="//div[@id='add_threshold_form-body']/following-sibling::div[contains(@id,'toolbar')]//span[text()='Cancel']")
	private WebElement nav_AddThresholdPopupCancelButton;
	
	//@FindBy(how=How.XPATH, using ="//div[@id='add_threshold_form']//div[Contains(@id,'toolbar')]//span[text()='Save']/ancestor::a")
	//@FindBy(how=How.XPATH, using ="//div[@id='add_threshold_form']//div[Contains(@id,'toolbar')]//span[text()='Save']")
	//@FindBy(how=How.XPATH, using ="//div[@id='add_threshold_form']//div[Contains(@id,'toolbar')]//a[2]//span[contains(@id,'btnInnerEl')]")
	//@FindBy(how=How.XPATH, using ="//div[@id='add_threshold_form']//div[Contains(@id,'toolbar')]//a[2]")
	//@FindBy(how=How.XPATH, using ="//html/body/div[3]//a[2]")
	@FindBy(how=How.XPATH, using ="//div[@id='add_threshold_form']//div[contains(@id,'toolbar-') and contains(@id,'-targetEl')]/a[@target='_blank']")
	private WebElement nav_AddThresholdPopupSaveLink;
	
	@FindBy(how=How.ID, using ="uname-textEl")
	private WebElement nav_LogViewerUserNameColumn;
	
	@FindBy(how=How.ID, using ="uaction-textEl")
	private WebElement nav_LogViewerUserActionColumn;
	
	@FindBy(how=How.ID, using ="msg-textEl")
	private WebElement nav_LogViewerMessageColumn;
	
	@FindBy(how=How.ID, using ="dtcreated-textEl")
	private WebElement nav_LogViewerDateCreatedColumn;
	
	@FindBy(how=How.ID, using ="status-textEl")
	private WebElement nav_LogViewerStatusColumn;
	
	@FindBy(how=How.ID, using ="hs_msgbox_0")
	private WebElement nav_DeleteThresholdPopup;
	
	@FindBy(how=How.XPATH, using ="//span[text()='OK']")
	private WebElement nav_DeleteThresholdPopupOKButton;
	
	@FindBy(how=How.XPATH, using ="//div[@class='x-grid-item-container']/table")
	private WebElement nav_LogViewerTable;
	
	
	@FindBy(how=How.XPATH, using ="//span[@class='x-column-header-text-wrapper']//span[text()='Location']")
	private WebElement nav_ThresholdTableLocationColumn;
	
	
	@FindBy(how=How.XPATH, using ="//span[@class='x-column-header-text-wrapper']//span[text()='Tier Name']")
	private WebElement nav_ThresholdTableTierNameColumn;
	
	
	@FindBy(how=How.XPATH, using ="//span[@class='x-column-header-text-wrapper']//span[text()='Provider VDC Threshold(%)']")
	private WebElement nav_ThresholdTableProviderVDCColumn;
	
	
	@FindBy(how=How.XPATH, using ="//span[@class='x-column-header-text-wrapper']//span[text()='Datastore Threshold(%)']")
	private WebElement nav_ThresholdTableDataStoreColumn;
		
	
	@FindBy(how=How.XPATH, using ="//span[contains(@class,'page-first')]")
	private WebElement nav_ThresholdTableFirstPage;
	
	
	@FindBy(how=How.XPATH, using ="//span[contains(@class,'page-prev')]")
	private WebElement nav_ThresholdTablePrevPage;
	
	
	@FindBy(how=How.XPATH, using ="//span[contains(@class,'page-next')]")
	private WebElement nav_ThresholdTableNextPage;
	
	
	@FindBy(how=How.XPATH, using ="//span[contains(@class,'page-last')]")
	private WebElement nav_ThresholdTableLastPage;
	
	@FindBy(how=How.XPATH, using ="//div[text()='Page']")
	private WebElement nav_ThresholdTablePageText;
	
	@FindBy(how=How.XPATH, using ="//img[@id='idCloseButton']")
	private WebElement nav_AddThresholdPopupWindowCloseImage;
	
	
	@FindBy(how=How.XPATH,using="//ul[@class='category-portlets']//img[@id='qyqk']")
	private WebElement nav_AdminRolesImg;
	
	@FindBy(how=How.XPATH,using="//input[contains(@name,'keywords')]")
	private WebElement nav_AdminRolesSearchInput;
	
	@FindBy(how=How.XPATH,using="//input[@value='Search']")
	private WebElement nav_AdminRolesSearchButton;
	
	@FindBy(how=How.XPATH,using="//table[@class='taglib-search-iterator']")
	private WebElement nav_AdminRolesSearchResultsTable;
	
	@FindBy(how=How.XPATH,using="//div[@id='mainGrid-body']//div[@class='x-grid-item-container']")
	private WebElement nav_AddThresholdTable;
	
	@FindBy(how=How.XPATH,using="//ul[@class='lfr-menu-list-overflow']//li[4]/a")
	private WebElement nav_AdminActionAssignMembersLink;
	
	@FindBy(how=How.XPATH,using="//ul[2]//li[2]//span[@class='aui-tab-content']//a")
	private WebElement nav_AdminAssignMemebersAvailableTab;
	
	@FindBy(how=How.XPATH,using="//ul[2]//li[1]//span[@class='aui-tab-content']//a")
	private WebElement nav_AdminAssignMemebersCurrentTab;
	
	@FindBy(how=How.XPATH,using="//input[@name='_128_screenName']")
	private WebElement nav_AdminAssignMemebersUserNameInput;
	
	
	@FindBy(how=How.XPATH,using="//input[@value='Search']")
	private WebElement nav_AdminAssignMemebersSearchButton;
	
	
	@FindBy(how=How.XPATH,using="//div[@id='toggle_id_users_admin_user_searchadvanced']//span[@class='aui-button-content']/input[@value='Search']")
	private WebElement nav_AdminAssignMemebersAvailableSearchButton;
	
	public WebElement getNav_dminAssignMemebersAvailableSearchButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AdminAssignMemebersAvailableSearchButton;
		}
	
	
	public WebElement getNav_AdminAssignMemebersCurrentTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AdminAssignMemebersCurrentTab;
		}
	
	public WebElement getNav_AdminAssignMemebersSearchButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AdminAssignMemebersSearchButton;
		}
	
	public WebElement getNav_AdminAssignMemebersUserNameInput() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AdminAssignMemebersUserNameInput;
		}
	
	public WebElement getNav_AdminAssignMemebersAvailableTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AdminAssignMemebersAvailableTab;
		}
	public WebElement getNav_AdminActionAssignMembersLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AdminActionAssignMembersLink;
		}
	
	public WebElement getNav_AddThresholdTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddThresholdTable;
		}
	
	public WebElement getNav_AdminRolesImg() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_AdminRolesImg;
	}
	
	public WebElement getNav_AdminRolesSearchInput() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_AdminRolesSearchInput;
	}
	
	public WebElement getNav_AdminRolesSearchButton() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_AdminRolesSearchButton;
	}
	
	public WebElement getNav_AdminRolesSearchResultsTable() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_AdminRolesSearchResultsTable;
	}

	public WebElement getNav_AddThresholdPopupWindowCloseImage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddThresholdPopupWindowCloseImage;
	}
		
	public WebElement getNav_ThresholdTableFirstPag() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ThresholdTableFirstPage;
	}
	
	public WebElement getNav_ThresholdTablePrevPage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ThresholdTablePrevPage;
	}
	
	public WebElement getNav_ThresholdTableNextPage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ThresholdTableNextPage;
	}
	
	public WebElement getNav_ThresholdTableLastPage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ThresholdTableLastPage;
	}
	
	public WebElement getNav_ThresholdTablePageText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ThresholdTablePageText;
	}
	
		
	public WebElement getNav_ThresholdTableLocationColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ThresholdTableLocationColumn;
	}
	
	public WebElement getNav_ThresholdTableTierNameColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ThresholdTableTierNameColumn;
	}
	
	public WebElement getNav_ThresholdTableProviderVDCColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ThresholdTableProviderVDCColumn;
	}
	
	public WebElement getNav_ThresholdTableDataStoreColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ThresholdTableDataStoreColumn;
	}
	
	public WebElement getNav_LogViewerTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_LogViewerTable;
	}
	
	public WebElement getNav_DeleteThresholdPopup() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DeleteThresholdPopup;
	}
	
	public WebElement getNav_DeleteThresholdPopupOKButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DeleteThresholdPopupOKButton;
	}
	public WebElement getNav_LogViewerUserNameColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_LogViewerUserNameColumn;
	}

	public WebElement getNav_LogViewerUserActionColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_LogViewerUserActionColumn;
	}

	public WebElement getNav_LogViewerMessageColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_LogViewerMessageColumn;
	}

	public WebElement getNav_LogViewerDateCreatedColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_LogViewerDateCreatedColumn;
	}

	public WebElement getNav_LogViewerStatusColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_LogViewerStatusColumn;
	}
	
	public WebElement getNav_AddThresholdPopupSaveLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddThresholdPopupSaveLink;
	}

	public WebElement getNav_AddThresholdPopupTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddThresholdPopupTitle;
	}
	
	public WebElement getNav_AddThresholdPopupLocationInput() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddThresholdPopupLocationInput;
	}

	public WebElement getNav_AddThresholdPopupLocationdropdown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddThresholdPopupLocationdropdown;
	}

	public WebElement getNav_AddThresholdPopupStragePlcyInput() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddThresholdPopupStragePlcyInput;
	}

	public WebElement getNav_AddThresholdPopupStragePlcyDropdown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddThresholdPopupStragePlcyDropdown;
	}

	public WebElement getNav_AddThresholdPopupVCDThresholdInput() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddThresholdPopupVCDThresholdInput;
	}

	public WebElement getNav_AddThresholdPopupDSThresholdInput() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddThresholdPopupDSThresholdInput;
	}

	public WebElement getNav_AddThresholdPopupSaveButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddThresholdPopupSaveButton;
	}

	public WebElement getNav_AddThresholdPopupCancelButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddThresholdPopupCancelButton;
	}

	public WebElement getNav_AddaStorageThresholdLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddaStorageThresholdLink;
	}

	public WebElement getNav_ThresholdTableFirstcolumnDefaultCell() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ThresholdTableFirstcolumnDefaultCell;
	}
	public WebElement getNav_NothingChanngedPopup() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NothingChanngedPopup;
	}
	public WebElement getNav_NothingChanngedPopupOKButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NothingChanngedPopupOKButton;
	}
}
