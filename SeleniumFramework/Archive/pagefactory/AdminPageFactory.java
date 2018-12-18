package com.whs.navigator.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class AdminPageFactory {
	
//_______________________ From Gideon TestCases ________________________//
	@FindBy(how=How.XPATH, using="//div[@id='OrganizationMigrationPortletDiv']//span[text()='Employee Onboarding']")
	private WebElement nav_EmployeOnboardingLink;
	
	@FindBy(how=How.XPATH, using="//input[@name='fname']")
	private WebElement nav_FirstNameEditBox;
	
	@FindBy(how=How.XPATH, using="//input[@name='lname']")
	private WebElement nav_LastNameEditBox;
	
	@FindBy(how=How.XPATH, using="//input[@name='phone']")
	private WebElement nav_PhoneEditBox;
	
	@FindBy(how=How.XPATH, using="//input[@name='email']")
	private WebElement nav_EmailEditBox;
	
	@FindBy(how=How.XPATH, using="//button[text()='Generate Username']")
	private WebElement nav_GenerateUsrNmeButton;
	
	@FindBy(how=How.XPATH, using="//label[text()='WHS_Storage']/preceding-sibling::input")
    private WebElement nav_WhsStorageRadioBtn;
	
	@FindBy(how=How.XPATH, using="//div[@class='x-panel-footer']//button[text()='Submit']")
    private WebElement nav_SubmitBtn;

	
	@FindBy(how=How.XPATH, using="//label[text()='First Name:']")
	private WebElement nav_FirstNameTitle;
	
	@FindBy(how=How.XPATH, using="//label[text()='Last Name:']")
	private WebElement nav_LastNameTitle;
	
	@FindBy(how=How.XPATH, using="//label[text()='Phone:']")
	private WebElement nav_PhoneNumberTitle;
	
	@FindBy(how=How.XPATH, using="//label[text()='Email:']")
	private WebElement nav_EmailTitle;
	
	@FindBy(how=How.XPATH, using="//label[text()='User Name:']")
	private WebElement nav_UserNameTitle;
	
	@FindBy(how=How.XPATH, using="//input[@name='uname']")
	private WebElement nav_UserNameEditBox;
	
	@FindBy(how=How.XPATH, using="//label[text()='WHS_Networking']")
	private WebElement nav_WhsNetworkingTitle;
	
	@FindBy(how=How.XPATH, using="//label[text()='WHS_Sales']")
	private WebElement nav_whsSalesTitle;
	
	@FindBy(how=How.XPATH, using="//label[text()='WHS_Storage']")
	private WebElement nav_WhsStorageTitle;
	
	@FindBy(how=How.XPATH, using="//label[text()='WHS_Virtualization']")
    private WebElement nav_WhsVirtualizationTitle;
	
	@FindBy(how=How.XPATH, using="//label[text()='WHS_Networking']/preceding-sibling::input")
	private WebElement nav_WhsNetworkingRadioBtn;
	
	@FindBy(how=How.XPATH, using="//label[text()='WHS_Sales']/preceding-sibling::input")
	private WebElement nav_whsSalesRadioBtn;
	
	 @FindBy(how=How.XPATH, using="//label[text()='WHS_Virtualization']/preceding-sibling::input")
	  private WebElement nav_WhsVirtualizationBtn;
	 
	 @FindBy(how=How.XPATH, using="//div[@class='x-panel-footer']//td[@class='x-btn-mc']//button[text()='Reset']")
	    private WebElement nav_ResetBtn;
    
	 @FindBy(how=How.XPATH, using="//div[@id='OrganizationMigrationPortletDiv']//div[contains(text(),'is already in use')]")
	    private WebElement nav_EmailErrorMsg;
	
	/////////******************************Eilerson************************************************////
	 @FindBy(how=How.XPATH, using="//input[@class='gwt-TextBox']")
		private WebElement Upgrade_UserName;
		
		@FindBy(how=How.XPATH, using="//input[@class='gwt-PasswordTextBox']")
		private WebElement Upgrade_Password;
		
		@FindBy(how=How.XPATH, using="//button[text()='Upgrade']")
		private WebElement Upgrade_UpgradeButton;
		
	    @FindBy(how=How.XPATH, using="//span[text()='Entity Management']")
	    private WebElement Upgrade_EntityMgtTab;
	
		@FindBy(how=How.XPATH, using="//div[@class='middleCenterInner']//table//table[@class='upgrade-grid']")
		private WebElement Upgrade_EntityMgtTable;
			
		@FindBy(how=How.ID, using="x-auto-20")
		private WebElement Upgrade_EntityMgtDropdownArrow;
		
		@FindBy(how=How.XPATH, using="//div[contains(@class,'x-trigger-wrap-focus')]/input")
		private WebElement Upgrade_EntityMgtOrgEdit;
		
		@FindBy(how=How.XPATH, using="//div[@class='middleCenterInner']//table//table[@class='upgrade-grid']//tr[2]//td[2]")
		private WebElement Upgrade_EntityMgtParentElement;
			
		@FindBy(how=How.XPATH, using="//button[text()='Change Parent']")
		private WebElement Upgrade_EM_ChangeParentButton;
		
		@FindBy(how=How.ID, using="x-auto-24")
		private WebElement Upgrade_EM_ChangeParentArrow;
		
		@FindBy(how=How.ID, using="x-auto-22-input")
		private WebElement Upgrade_EM_ChangeParentText;
		
		@FindBy(how=How.XPATH, using="//button[text()='Save']")
		private WebElement Upgrade_EM_CPTextSaveButton;
		
		@FindBy(how=How.XPATH, using="//button[text()='Next']")
		private WebElement upgrade_EntityMgt_Nextbutton;
		
		@FindBy(how=How.XPATH, using="//img[contains(@class,'gwt-Image')]")
		private WebElement upgrade_EMErrorIcon;
		
		@FindBy(how=How.XPATH, using="//button[text()='Cancel']")
		private WebElement upgrade_EMCancelButton;
		
		
		
	////*******************************************Eilerson End*******************************//
		
	////*******************************************Hague Start********************************//
		
		@FindBy(how=How.LINK_TEXT,using="Manage")
		private WebElement nav_Admin_ManageTab;
		
		@FindBy(how=How.LINK_TEXT,using="Control Panel")
		private WebElement nav_Admin_ControlPanelLink;
		
		@FindBy(how=How.XPATH,using="//h1[contains(text(),'Control Panel')]")
		private WebElement nav_Admin_ControlPanelText;
		
		@FindBy(how=How.LINK_TEXT,using="Organizations")
		private WebElement nav_Admin_OrganizationsLink;
		
		@FindBy(how=How.LINK_TEXT,using="View Users")
		private WebElement nav_Admin_ViewUsersLink;
		
		@FindBy(how=How.XPATH,using="//div[@class='results-grid']")
		private WebElement nav_Admin_OrganizationsParentWebTable;
		
		@FindBy(how=How.XPATH,using="//div[@class='lfr-component lfr-menu-list']/ul/li[3]/a")
		private WebElement nav_Admin_ImpersonateUserLink;
		
		
		
	public WebElement getNav_EmployeOnboardingLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EmployeOnboardingLink;
	}

	public WebElement getNav_FirstNameEditBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FirstNameEditBox;
	}

	public WebElement getNav_LastNameEditBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_LastNameEditBox;
	}

	public WebElement getNav_PhoneEditBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PhoneEditBox;
	}

	public WebElement getNav_EmailEditBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EmailEditBox;
	}

	public WebElement getNav_GenerateUsrNmeButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_GenerateUsrNmeButton;
	}

	public WebElement getNav_WhsStorageRadioBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_WhsStorageRadioBtn;
	}

	public WebElement getNav_SubmitBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SubmitBtn;
	}

	public WebElement getNav_FirstNameTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FirstNameTitle;
	}

	public WebElement getNav_LastNameTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_LastNameTitle;
	}

	public WebElement getNav_PhoneNumberTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PhoneNumberTitle;
	}

	public WebElement getNav_EmailTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EmailTitle;
	}

	public WebElement getNav_UserNameTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_UserNameTitle;
	}

	public WebElement getNav_UserNameEditBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_UserNameEditBox;
	}

	public WebElement getNav_WhsNetworkingTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_WhsNetworkingTitle;
	}

	public WebElement getNav_whsSalesTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_whsSalesTitle;
	}

	public WebElement getNav_WhsStorageTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_WhsStorageTitle;
	}

	public WebElement getNav_WhsVirtualizationTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_WhsVirtualizationTitle;
	}

	public WebElement getNav_WhsNetworkingRadioBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_WhsNetworkingRadioBtn;
	}

	public WebElement getNav_whsSalesRadioBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_whsSalesRadioBtn;
	}

	public WebElement getNav_WhsVirtualizationBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_WhsVirtualizationBtn;
	}

	public WebElement getNav_ResetBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ResetBtn;
	}

	public WebElement getNav_EmailErrorMsg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EmailErrorMsg;
	}
	
	
//___________________________ Completed Gideon TestCases ________________________________________///
	
	public WebElement getUpgrade_UserName() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return Upgrade_UserName;
	}

	public WebElement getUpgrade_Password() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return Upgrade_Password;
	}

	public WebElement getUpgrade_UpgradeButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return Upgrade_UpgradeButton;
	}
    public WebElement getUpgrade_EntityMgtTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return Upgrade_EntityMgtTab;
	}

	public WebElement getUpgrade_EntityMgtTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return Upgrade_EntityMgtTable;
	}

	public WebElement getUpgrade_EntityMgtOrgEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return Upgrade_EntityMgtOrgEdit;
	}
			
	public WebElement getUpgrade_EntityMgtParentElement() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return Upgrade_EntityMgtParentElement;
	}

	public WebElement getUpgrade_EntityMgtDropdownArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return Upgrade_EntityMgtDropdownArrow;
	}

	public WebElement getUpgrade_EM_ChangeParentButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return Upgrade_EM_ChangeParentButton;
	}

	public WebElement getUpgrade_EM_ChangeParentArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return Upgrade_EM_ChangeParentArrow;
	}

	public WebElement getUpgrade_EM_ChangeParentText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return Upgrade_EM_ChangeParentText;
	}

	public WebElement getUpgrade_EM_CPTextSaveButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return Upgrade_EM_CPTextSaveButton;
	}
	public WebElement getUpgrade_EntityMgt_Nextbutton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return upgrade_EntityMgt_Nextbutton;
	}
	public WebElement getUpgrade_EMErrorIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return upgrade_EMErrorIcon;
	}

	public WebElement getUpgrade_EMCancelButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return upgrade_EMCancelButton;
	}

	public WebElement getNav_Admin_ManageTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Admin_ManageTab;
	}

	public WebElement getNav_Admin_ControlPanelLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Admin_ControlPanelLink;
	}
    
	public WebElement getNav_Admin_ControlPanelText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Admin_ControlPanelText;
	}

	public WebElement getNav_Admin_OrganizationsLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Admin_OrganizationsLink;
	}

	public WebElement getNav_Admin_ViewUsersLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Admin_ViewUsersLink;
	}

	public WebElement getNav_Admin_OrganizationsParentWebTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Admin_OrganizationsParentWebTable;
	}

	public WebElement getNav_Admin_ImpersonateUserLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Admin_ImpersonateUserLink;
	}
	
	
	
}
