package com.whs.navigator.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;
public class AddFirewallPageFactory {

@FindBy(how=How.ID,using="sequenceId-inputId")
private WebElement nav_AddFirewallSeqNumEdit;

@FindBy(how=How.ID,using="sourceType-inputId")
private WebElement nav_AddFirewallSourceTypeEdit;

@FindBy(how=How.ID,using="sourceIp-inputId")
private WebElement nav_AddFirewallSourceIPEdit;

@FindBy(how=How.ID,using="sourceMask-inputId")
private WebElement nav_AddFirewallSourceMaskEdit;

@FindBy(how=How.ID,using="destinationType-inputId")
private WebElement nav_AddFirewallDestTypeEdit;

@FindBy(how=How.ID,using="destinationIp-inputId")
private WebElement nav_AddFirewallDestIPEdit;

@FindBy(how=How.ID,using="destinationMask-inputId")
private WebElement nav_AddFirewallDestMaskEdit;

@FindBy(how=How.ID,using="serviceType-inputId")
private WebElement nav_AddFirewallServiceTypeEdit;

@FindBy(how=How.ID,using="protocolId-inputId")
private WebElement nav_AddFirewallProtocolEdit;

@FindBy(how=How.ID,using="portName-inputId")
private WebElement nav_AddFirewallPortEdit;

@FindBy(how=How.ID,using="statusAnchor")
private WebElement nav_AddFirewallStatus;

@FindBy(how=How.ID,using="actionAnchor")
private WebElement nav_AddFirewallAction;

@FindBy(how=How.XPATH,using="//a[@id='saveAddFW']")
private WebElement nav_SaveFirewallRuleButton;

@FindBy(how=How.XPATH,using="//div[@id='navpopuptitle']")
private WebElement nav_AddFirewallRuleConfirmationWindow;

//Added by QAA03
@FindBy(how=How.ID,using="serviceType-trigger-picker")
private WebElement nav_AddFirewallServiceTypeDropdown;

@FindBy(how=How.ID,using="protocolId-trigger-picker")
private WebElement nav_AddFirewallProtocolDropdown;

@FindBy(how=How.ID,using="sourceType-trigger-picker")
private WebElement nav_AddFirewallSourceDropdown;

@FindBy(how=How.ID,using="destinationType-trigger-picker")
private WebElement nav_AddFirewallDestinationDropdown;

@FindBy(how=How.ID,using="cancelAddFW")
private WebElement nav_AddFirewallCancelButton;


public WebElement getNav_AddFirewallSeqNumEdit() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFirewallSeqNumEdit;
	}

	public WebElement getNav_AddFirewallSourceTypeEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFirewallSourceTypeEdit;
	}

	public WebElement getNav_AddFirewallSourceIPEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFirewallSourceIPEdit;
	}

	public WebElement getNav_AddFirewallSourceMaskEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFirewallSourceMaskEdit;
	}

	public WebElement getNav_AddFirewallDestTypeEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFirewallDestTypeEdit;
	}

	public WebElement getNav_AddFirewallDestIPEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFirewallDestIPEdit;
	}

	public WebElement getNav_AddFirewallDestMaskEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFirewallDestMaskEdit;
	}

	public WebElement getNav_AddFirewallServiceTypeEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFirewallServiceTypeEdit;
	}

	public WebElement getNav_AddFirewallProtocolEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFirewallProtocolEdit;
	}

	public WebElement getNav_AddFirewallPortEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFirewallPortEdit;
	}

	public WebElement getNav_AddFirewallStatus() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFirewallStatus;
	}

	public WebElement getNav_AddFirewallAction() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFirewallAction;
	}

	public WebElement getNav_SaveFirewallRuleButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SaveFirewallRuleButton;
	}

	public WebElement getNav_AddFirewallRuleConfirmationWindow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFirewallRuleConfirmationWindow;
	}
	
	public WebElement getNav_AddFirewallServiceTypeDropdown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFirewallServiceTypeDropdown;
	}

	public WebElement getNav_AddFirewallProtocolDropdown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFirewallProtocolDropdown;
	}
	

	public WebElement getNav_AddFirewallSourceDropdown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFirewallSourceDropdown;
	}

	public WebElement getNav_AddFirewallDestinationDropdown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFirewallDestinationDropdown;
	}

	public WebElement getNav_AddFirewallCancelButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFirewallCancelButton;
	}
	
    
}
