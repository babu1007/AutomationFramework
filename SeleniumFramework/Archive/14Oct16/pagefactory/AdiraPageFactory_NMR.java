package com.whs.navigator.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class AdiraPageFactory_NMR {

	///Form3 page -- 10/13/2016
	
	// My questions link
	@FindBy(how=How.XPATH, using="//a[@href='forms/questions?portlet_window_state=view']/h2")
	private WebElement nav_MyQuestionsLink;
	
	//Expand all check box
	@FindBy(how=How.XPATH, using="//div[@id='my-question-maindiv']//input[contains(@id,'checkbox-')]")
	private WebElement nav_Questions_ExpandAllCheckBox;
	
	//Add a new question link
	@FindBy(how=How.XPATH, using="//div[@id='my-question-maindiv']//span[contains(@id,'add-questions-btn-')][contains(@class,'x-btn-inner-default-small')]")
	private WebElement nav_AddaNewQuestionLink;
	
	//My questions - Sales Order/Ticket# drop down arrow
	@FindBy(how=How.XPATH, using="//div[contains(@id,'idSalesOrderNum_')  AND contains(@Id,'-trigger-picker')]")
	private WebElement nav_MYQuestions_SalesOrderDropDownArrow;
	
	//My questions -Form (Optional) drop down arrow
	@FindBy(how=How.XPATH, using="//div[contains(@id,'idFormName_')  AND contains(@Id,'-trigger-picker')]")
	private WebElement nav_MyQuestions_FormDropDownArrow;
	
	// My questions - text area
	@FindBy(how=How.XPATH, using="//textarea[contains(@id,'idResponseNote_')  AND contains(@Id,'-inputEl')]")
	private WebElement nav_MyQuestions_TextEditFeild;
	
	// My questions - cancel button
	@FindBy(how=How.XPATH, using="(//div[@id='idAddQuestionWnd-innerCt']//span[@class='x-btn-inner x-btn-inner-default-small'])[1]")
	private WebElement nav_MyQuestions_CancelBtn;
	
	// My questions - submit button
	@FindBy(how=How.XPATH, using="(//div[@id='idAddQuestionWnd-innerCt']//span[@class='x-btn-inner x-btn-inner-default-small'])[2]")
	private WebElement nav_MyQuestions_SubmitBtn;
	
	
	//////// Public cloud page 
	
	// Public cloud title
	@FindBy(how=How.XPATH, using="//*[contains(@id,'pcn-header-panel')  AND contains(@Id,'-innerCt')]")
	private WebElement nav_PublicCloudFormTitle;
	
	// Questions link
	@FindBy(how=How.XPATH, using="//div[@id='FormMainDiv-innerCt']//a[@class='green-link']")
	private WebElement nav_QuestionsLink;
	
	// My Question - question from drop down arrow
	@FindBy(how=How.ID, using="idMyQuestionCombo-trigger-picker")
	private WebElement nav_Question_QuestionFromDropDownArrow;
	
	// Question pop up close icon
	@FindBy(how=How.XPATH, using="idCloseButton_idAddQuestionWnd")
	private WebElement nav_QuestionPopup_CloseIcon;
	
	//// Network
	// Network expander
	@FindBy(how=How.XPATH, using="//div[@id='PublicCloudNetworkTopology-collapseArrow']/img")
	private WebElement nav_Network_Expander;
	
	// Network - read more link
	@FindBy(how=How.ID, using="network-read-more-link")
	private WebElement nav_Network_readMoreLink;
	
	// Network title/header
	@FindBy(how=How.ID, using="PublicCloud-NetworkTopology-formTitle")
	private WebElement nav_NetworkTitle;
	
	// Network image
	@FindBy(how=How.XPATH, using="//div[@id='PublicCloudNetworkTopology-collapseArrow']/..//img[@class='x-img img-hd-cls x-box-item x-img-default']")
	private WebElement nav_NetworkImg;
	
	//Network - Is TierPoint providing you with a new IP block? - Yes radio btn
	@FindBy(how=How.XPATH, using="(//div[@id='networkEnv-targetEl']//input[@role='radio'])[1]")
	private WebElement nav_Network_NewIPBlock_YesRadioBtn;
	
	//Network - Is TierPoint providing you with a new IP block? - No radio btn
	@FindBy(how=How.XPATH, using="(//div[@id='networkEnv-targetEl']//input[@role='radio'])[2]")
	private WebElement nav_Network_NewIPBlock_NoRadioBtn;
	
	//Network -  Add a network link
	@FindBy(how=How.XPATH, using="//div[@id='idNTGrid-innerCt']//img[@src='/forms3-portlet/images/Plus_Icon_sm.png']")
	private WebElement nav_Network_AddaNetworkLink;
	
	//Add a network popup - network name
	@FindBy(how=How.XPATH, using="//input[contains(@id,'networkName_')  AND contains(@Id,'-inputEl')]")
	private WebElement nav_AddNetwork_NetworkNameEditField;
	
	//Add a network popup - IP Addressing drop down 
	@FindBy(how=How.XPATH, using="//div[contains(@id,'ipAddressing_')  AND contains(@Id,'-trigger-picker')]")
	private WebElement nav_AddNetwork_IpAddressDropDown;
	
	//Network -  Add a network - Number of Hosts - Current text box
	@FindBy(how=How.XPATH, using="//input[contains(@id,'currentNumHosts_')  AND contains(@Id,'-inputEl')]")
	private WebElement nav_AddNetwork_CurrentEditField;
	
	// Add a network popup - Number of Hosts - 12 Months text box
	@FindBy(how=How.XPATH, using="//input[contains(@id,'twelveMonNumHosts_')  AND contains(@Id,'-inputEl')]")
	private WebElement nav_AddNetwork_TwelveMonthEditField;
	
	//Add a network popup - Number of NAT'd IP Addresses
	@FindBy(how=How.XPATH, using="//div[contains(@id,'pubNetworkSizeCombo_')  AND contains(@Id,'-trigger-picker')]")
	private WebElement nav_AddNetwork_NumberofNATIPAddressesDropDown;
	
	//Add a network - Tier point to provide radio button
	@FindBy(how=How.XPATH, using="//input[contains(@id,'pvtIPAssignmentTPProvider_')  AND contains(@Id,'-inputEl')]")
	private WebElement nav_AddNetwork_TierPointToProvideRadioBtn;
	
	// Add a network popup - specify radio button
	@FindBy(how=How.XPATH, using="//input[contains(@id,'pvtIPAssignmentSpecify_')  AND contains(@Id,'-inputEl')]")
	private WebElement nav_AddNetwork_SpecifyRadioBtn;
	
	//Add a network - specify text box
	@FindBy(how=How.XPATH, using="//input[contains(@id,'idPvtIPAssignmentText_')  AND contains(@Id,'-inputEl')]")
	private WebElement nav_AddNetwork_SpecifyEditField;
	
	// Add a network popup - cancel button
	@FindBy(how=How.XPATH, using="(//div[@id='idAddNetworkWnd-innerCt']//span[@class='x-btn-inner x-btn-inner-default-small'])[1]")
	private WebElement nav_AddNetwork_CancelBtn;
	
	// Add a network - save button
	@FindBy(how=How.XPATH, using="(//div[@id='idAddNetworkWnd-innerCt']//span[@class='x-btn-inner x-btn-inner-default-small'])[2]")
	private WebElement nav_AddNetwork_SaveBtn;
	
	// Add a network popup - close icon
	@FindBy(how=How.ID, using="idCloseButton_idAddNetworkWnd")
	private WebElement nav_AddNetworkPopup_CloseIcon;
	
	// Network - save button
	@FindBy(how=How.XPATH, using="(//div[@id='networkForm-innerCt']//span[@id='forms-save-icon'])[1]")
    private WebElement nav_Network_SaveBtn;	
	
	// Network - save and continue button
	@FindBy(how=How.XPATH, using="(//div[@id='networkForm-innerCt']//span[@id='forms-save-icon'])[2]")
	private WebElement nav_Network_SaveAndContinueBtn;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	public WebElement getNav_MyQuestionsLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_MyQuestionsLink;
	}

	public WebElement getNav_Questions_ExpandAllCheckBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Questions_ExpandAllCheckBox;
	}

	public WebElement getNav_AddaNewQuestionLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddaNewQuestionLink;
	}

	public WebElement getNav_MYQuestions_SalesOrderDropDownArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_MYQuestions_SalesOrderDropDownArrow;
	}

	public WebElement getNav_MyQuestions_FormDropDownArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_MyQuestions_FormDropDownArrow;
	}

	public WebElement getNav_MyQuestions_TextEditFeild() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_MyQuestions_TextEditFeild;
	}

	public WebElement getNav_MyQuestions_CancelBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_MyQuestions_CancelBtn;
	}

	public WebElement getNav_MyQuestions_SubmitBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_MyQuestions_SubmitBtn;
	}

	public WebElement getNav_PublicCloudFormTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PublicCloudFormTitle;
	}

	public WebElement getNav_QuestionsLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_QuestionsLink;
	}

	public WebElement getNav_Question_QuestionFromDropDownArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Question_QuestionFromDropDownArrow;
	}

	public WebElement getNav_QuestionPopup_CloseIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_QuestionPopup_CloseIcon;
	}

	public WebElement getNav_Network_Expander() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_Expander;
	}

	public WebElement getNav_NetworkTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NetworkTitle;
	}

	public WebElement getNav_NetworkImg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NetworkImg;
	}

	public WebElement getNav_Network_NewIPBlock_YesRadioBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_NewIPBlock_YesRadioBtn;
	}

	public WebElement getNav_Network_NewIPBlock_NoRadioBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_NewIPBlock_NoRadioBtn;
	}

	public WebElement getNav_Network_AddaNetworkLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_AddaNetworkLink;
	}

	public WebElement getNav_AddNetwork_NetworkNameEditField() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNetwork_NetworkNameEditField;
	}

	public WebElement getNav_AddNetwork_IpAddressDropDown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNetwork_IpAddressDropDown;
	}

	public WebElement getNav_AddNetwork_CurrentEditField() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNetwork_CurrentEditField;
	}

	public WebElement getNav_AddNetwork_TwelveMonthEditField() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNetwork_TwelveMonthEditField;
	}

	public WebElement getNav_AddNetwork_NumberofNATIPAddressesDropDown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNetwork_NumberofNATIPAddressesDropDown;
	}

	public WebElement getNav_AddNetwork_TierPointToProvideRadioBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNetwork_TierPointToProvideRadioBtn;
	}

	public WebElement getNav_AddNetwork_SpecifyRadioBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNetwork_SpecifyRadioBtn;
	}

	public WebElement getNav_AddNetwork_SpecifyEditField() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNetwork_SpecifyEditField;
	}

	public WebElement getNav_AddNetwork_CancelBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNetwork_CancelBtn;
	}

	public WebElement getNav_AddNetwork_SaveBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNetwork_SaveBtn;
	}

	public WebElement getNav_AddNetworkPopup_CloseIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNetworkPopup_CloseIcon;
	}

	public WebElement getNav_Network_SaveBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_SaveBtn;
	}

	public WebElement getNav_Network_SaveAndContinueBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_SaveAndContinueBtn;
	}
	

}
