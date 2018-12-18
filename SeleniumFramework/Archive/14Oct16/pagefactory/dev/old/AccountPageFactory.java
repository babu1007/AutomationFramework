package com.whs.navigator.pagefactory.dev.old;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class AccountPageFactory {
		
	@FindBy(how=How.XPATH, using="//a[contains(text(),'account')]")
	private WebElement nav_AccountLink;
	@FindBy(how=How.LINK_TEXT, using="Account Settings")
	private WebElement nav_AccountSettingsLink;
	
	@FindBy(how=How.ID, using="detailsLink")
	private WebElement nav_DetailsLink;
	@FindBy(how=How.ID, using="_2_firstName")
	private WebElement nav_FirstNameTextBox;
	
	@FindBy(how=How.ID, using="passwordLink")
	private WebElement nav_PasswordLink;
	@FindBy(how=How.ID, using="_2_password0")
	private WebElement nav_CurrentPasswordTextBox;
	
	@FindBy(how=How.ID, using="phoneNumbersLink")
	private WebElement nav_PhoneNumberLink;
	@FindBy(how=How.ID, using="_2_phoneNumber0")
	private WebElement nav_PhoneNumberTextBox;
	
	@FindBy(how=How.ID, using="displaySettingsLink")
	private WebElement nav_DisplaySettingsLink;
	@FindBy(how=How.ID, using="_2_greeting")
	private WebElement nav_GreetingsTextBox;
	
	@FindBy(how=How.XPATH, using="//*[contains(text(),'Your request processed successfully.')]")
	private WebElement nav_SavedSuccessMessage;
	
	@FindBy(how=How.XPATH,using="//*[@value='Save']")
	private WebElement nav_SaveButton;
	
	@FindBy(how= How.NAME, using="_2_languageId")
	private WebElement nav_LanguageListBox;
	
	@FindBy(how=How.ID, using="_2_phoneExtension0")
	private WebElement nav_PhoneExtensionTextBox;
	
	@FindBy(how=How.ID, using="_2_reminderQueryQuestion")
	private WebElement nav_ReminderQuestionListBox;
	
	@FindBy(how=How.ID, using="_2_reminderQueryAnswer")
	private WebElement nav_ReminderAnswerTextBox;


//#########################################################################################################################	
	
	public WebElement getNav_AccountLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AccountLink;
	}
	public WebElement getNav_AccountSettingsLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AccountSettingsLink;
	}
	public WebElement getNav_DetailsLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DetailsLink;
	}
	public WebElement getNav_FirstNameTextBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FirstNameTextBox;
	}
	public WebElement getNav_PasswordLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PasswordLink;
	}
	public WebElement getNav_CurrentPasswordTextBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CurrentPasswordTextBox;
	}
	public WebElement getNav_PhoneNumberLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PhoneNumberLink;
	}
	public WebElement getNav_PhoneNumberTextBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PhoneNumberTextBox;
	}
	public WebElement getNav_DisplaySettingsLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DisplaySettingsLink;
	}
	public WebElement getNav_GreetingsTextBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_GreetingsTextBox;
	}	
	public WebElement getNav_SavedSuccessMessage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SavedSuccessMessage;
	}
	public WebElement getNav_LanguageListBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_LanguageListBox;
	}
	public WebElement getNav_SaveButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SaveButton;
	}
	public WebElement getNav_PhoneExtensionTextBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PhoneExtensionTextBox;
	}
	public WebElement getNav_ReminderQuestionListBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ReminderQuestionListBox;
	}
	public WebElement getNav_ReminderAnswerTextBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ReminderAnswerTextBox;
	}
	
}
