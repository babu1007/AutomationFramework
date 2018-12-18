package com.whs.navigator.pagefactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;


public class LoginPageFactory {

	
	@FindBy(how=How.ID, using="_58_login")
	private WebElement nav_userId ;
	
	@FindBy(how=How.ID,using="_58_password")
	private WebElement nav_pwd;
	
	@FindBy(how=How.CSS,using = ".aui-button-input.aui-button-input-submit")
	private WebElement nav_submitBtn;

	@FindBy(how=How.XPATH, using = "//span[@class='sign-out']/a[contains(text(),'Sign Out')]")
	private WebElement nav_SignOutLink;
	//----------------------------------------------------------------------
	public WebElement getNav_userId() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_userId;
	}

	public WebElement getNav_pwd() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_pwd;
	}

	public WebElement getNav_submitBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_submitBtn;
	}

	public WebElement getNav_SignOutLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SignOutLink;
	}


}

