package com.whs.navigator.pagefactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;


public class LoginPageFactory_Old {

	
	@FindBy(how=How.ID, using="_58_login")
	private WebElement nav_userId ;
	
	@FindBy(how=How.ID,using="_58_password")
	private WebElement nav_pwd;
	
	@FindBy(how=How.CSS,using = ".aui-button-input.aui-button-input-submit")
	private WebElement nav_submitBtn;

	@FindBy(how=How.XPATH, using = "//span[@class='sign-out']/a[contains(text(),'Sign Out')]")
	private WebElement nav_SignOutLink;
	
	//#################################################################
	//				New Login - Tier Point - 08242016 - Vivek Kumar
	//#################################################################
	@FindBy(how=How.ID,using="user")
	private WebElement nav_TierPointUserId;
	
	@FindBy(how=How.ID,using="pwd")
	private WebElement nav_TierPointPwd;
	
	@FindBy(how=How.XPATH,using="//div[@class='sign-container']/a")
	private WebElement nav_TierPointSignIn;
	
	@FindBy(how=How.XPATH,using="//div[contains(@id,'big-button')]/a[contains(@class,'button')]")
	private WebElement nav_TierPointContinue;
	
	//Logout Page
	@FindBy(how=How.XPATH,using="//div[@class='form-container']/div[text()='Logout successful']")
	private WebElement nav_TierPointLogOutPg;
	
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

	public WebElement getNav_TierPointUserId() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TierPointUserId;
	}

	public WebElement getNav_TierPointPwd() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TierPointPwd;
	}

	public WebElement getNav_TierPointSignIn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TierPointSignIn;
	}

	public WebElement getNav_TierPointContinue() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TierPointContinue;
	}

	public WebElement getNav_TierPointLogOutPg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TierPointLogOutPg;
	}


	
}

