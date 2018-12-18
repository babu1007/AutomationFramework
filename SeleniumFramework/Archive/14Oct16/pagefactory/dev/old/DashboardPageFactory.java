package com.whs.navigator.pagefactory.dev.old;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class DashboardPageFactory {
	/*@FindBy(how=How.ID,using="aui-3-2-0PR1-14578")
	private WebElement nav_DocumentLink;
	*/
	@FindBy(how=How.XPATH,using="//a[contains(text(), 'Documents')]")
	private WebElement nav_DocumentLink;


	@FindBy(how=How.XPATH,using="//*[contains(text(), 'Documents')]")
	private WebElement nav_DocumentMenuLink;
	
/*	@FindBy(how=How.ID,using="aui-3-2-0PR1-13112")
	private WebElement nav_SupportTab;
	*/
	@FindBy(how=How.XPATH,using="//nav/ul/li/a[contains(text(), 'support')]")
	private WebElement nav_SupportTab;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='user']/a/nobr")
	private WebElement nav_UserNameLink;
	
	
	@FindBy(how=How.XPATH,using="//*[@id='user']")
	private WebElement nav_UserNameDropDown;
	
	
	//@FindBy(how=How.LINK_TEXT,using = "Logout")
	//@FindBy(how=How.XPATH,using="//li[@id='user']/ul/li/a[text()='Logout']")
	@FindBy(how=How.XPATH,using="//div[@id='styled_user']//li[@id='user']/ul/li/a[text()='Logout']")
	private WebElement nav_LogoutLink;

	public WebElement getNav_DocumentLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DocumentLink;
	}
	
	public WebElement getNav_DocumentMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DocumentMenuLink;
	}
	

	public WebElement getNav_SupportTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SupportTab;
	}

	public WebElement getNav_UserNameLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_UserNameLink;
	}

	public WebElement getNav_LogoutLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_LogoutLink;
	}
	
	public WebElement getnav_UserNameDropDown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_UserNameDropDown;
	}
	//========================================================
	
	
	
}
