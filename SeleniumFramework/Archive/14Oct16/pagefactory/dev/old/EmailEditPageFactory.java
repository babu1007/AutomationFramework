package com.whs.navigator.pagefactory.dev.old;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class EmailEditPageFactory {
	//Page Factory and links under Account Tab 
	@FindBy(how=How.XPATH,using="//a[contains(text(),'account')]")
	private WebElement nav_AccountTab;
	
	@FindBy(how=How.LINK_TEXT,using="Account Settings")
	private WebElement nav_AccountSettingsMenuLink;
	
	@FindBy(how=How.LINK_TEXT,using="Escalation List")
	private WebElement nav_EscalationListLink;
	
	@FindBy(how=How.LINK_TEXT,using="Details")
	private WebElement nav_DetailsLink;
	

	@FindBy(how=How.XPATH,using="//div/input[contains(@id,'_2_emailAddress')]")
	private WebElement nav_emailIdText;


	public WebElement getnav_AccountTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AccountTab;
	}


	public WebElement getNav_AccountSettingsMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AccountSettingsMenuLink;
	}
	public WebElement getNav_EscalationListMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EscalationListLink;
	}


	public WebElement getnav_DetailsLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DetailsLink;
	}


	public WebElement getnav_EmailIdText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_emailIdText;
	}
	
	
	
}

