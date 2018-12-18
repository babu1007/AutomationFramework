package com.DemandPortal.pagefactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.commonUtils.FrameworkUtil;
import com.commonUtils.WebObjectUtil;

public class LoginTestPageFactory {
	
	//Demand Portal Home Page
	@FindBy(how=How.XPATH,using="//input[contains(@id,'wtUserNameInput')]")
	private WebElement UsernameInput;

	@FindBy(how=How.XPATH,using="//input[contains(@id,'wtPasswordInput')]")
	private WebElement PasswordInput;
	
	@FindBy(how=How.XPATH,using="//input[contains(@id,'wtLoginButton')]")
	private WebElement LoginButton;

	@FindBy(how=How.XPATH,using="//img[contains(@src,'user.png')]")
	private WebElement UserImage;
	
	@FindBy(how=How.XPATH,using="//a[contains(@id,'wtLogoutLink')]")
	private WebElement LogoutLink;
	
	
	public WebElement getUsernameInput() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return UsernameInput;
	}

	public WebElement getPasswordInput() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return PasswordInput;
	}

	public WebElement getLoginButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return LoginButton;
	}
	
	public WebElement getUserImage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return UserImage;
	}
	
	public WebElement getLogoutLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return LogoutLink;
	}
	
	
	
	
}
