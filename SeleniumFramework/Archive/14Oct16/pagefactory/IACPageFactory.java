package com.whs.navigator.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class IACPageFactory {

	@FindBy(how=How.ID, using="NSA_LOGIN_NAME")
	private WebElement navUserName;
	
	@FindBy(how=How.ID, using="NSA_PASSWORD")
	private WebElement navPassword;
	
	@FindBy(how=How.ID, using="LP_loginSubmit_label")
	private WebElement navSubmitBtn;
	
	@FindBy(how=How.ID, using="ccpAcountOverlayAnchorID")
	private WebElement navUserDropDown;
	
	@FindBy(how=How.XPATH, using="//div[@id='ccpUIAccountOverlayLogoutIdentifier']/a[text()='Logout']")
	private WebElement navLogOutLink;
	
	@FindBy(how=How.ID, using="moduleMenu")
	private WebElement navModuleMenu_DropDown;
	
	@FindBy(how=How.XPATH, using="//div[text()='Manage Service Items']")
	//@FindBy(how=How.ID, using="selected")
	private WebElement navManageServiceItemsLink;
	
	@FindBy(how=How.XPATH, using="//div[@id='managerInstancePanelTree']//img[contains(@class,'x-tree-elbow-minus')]")
	private WebElement navStandardLoadBalancerVCNsArrow;
	
	@FindBy(how=How.XPATH, using="//button[text()='Filter and Search']")
	private WebElement navFilterandSrearchBtn;
	
	@FindBy(how=How.ID, using="UniqueID")
	private WebElement navFilterandSearch_UniqueIdEditField;
	
	@FindBy(how=How.XPATH, using="//div[@id='generalInfoGrid']//*[text()='IP Address']/../..//div[@class='x-grid3-cell-inner x-grid3-col-value x-unselectable']")
	private WebElement navIPAddressEditField;
	
	@FindBy(how=How.XPATH, using="//button[text()='Save']")
	private WebElement navSaveBtn;
	
	@FindBy(how=How.XPATH, using="//span[text()='LB Member']")
	private WebElement navLBMemberServiceItem;
	
	@FindBy(how=How.XPATH, using="//span[text()='LB Virtual Server']")
	private WebElement navLBVirtualServerServiceItem;
	
	@FindBy(how=How.XPATH, using="//span[text()='Filter and Search']/../../../../..")
	private WebElement navFilerandSearchPopUpBox;
	
	@FindBy(how=How.XPATH, using="//div[@id='generalInfoGrid']//input[@class='x-form-text x-form-field x-form-focus']")
	private WebElement navIPAddressEditInputField;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public WebElement getNavUserName() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navUserName;
	}

	public WebElement getNavPassword() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navPassword;
	}

	public WebElement getNavSubmitBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navSubmitBtn;
	}

	public WebElement getNavModuleMenu_DropDown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navModuleMenu_DropDown;
	}

	public WebElement getNavManageServiceItemsLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navManageServiceItemsLink;
	}

	public WebElement getNavStandardLoadBalancerVCNsArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navStandardLoadBalancerVCNsArrow;
	}

	public WebElement getNavFilterandSrearchBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navFilterandSrearchBtn;
	}

	public WebElement getNavFilterandSearch_UniqueIdEditField() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navFilterandSearch_UniqueIdEditField;
	}

	public WebElement getNavIPAddressEditField() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navIPAddressEditField;
	}

	public WebElement getNavSaveBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navSaveBtn;
	}

	public WebElement getNavLBMemberServiceItem() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navLBMemberServiceItem;
	}

	public WebElement getNavFilerandSearchPopUpBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navFilerandSearchPopUpBox;
	}

	public WebElement getNavIPAddressEditInputField() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navIPAddressEditInputField;
	}

	public WebElement getNavLBVirtualServerServiceItem() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navLBVirtualServerServiceItem;
	}

	public WebElement getNavUserDropDown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navUserDropDown;
	}

	public WebElement getNavLogOutLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navLogOutLink;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
