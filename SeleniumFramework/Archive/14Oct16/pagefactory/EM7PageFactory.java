package com.whs.navigator.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class EM7PageFactory {
	
	//Login UserId
	// this below element is updated by NMR - 07/06/2016
	@FindBy(how=How.ID, using="user")
	//@FindBy(how=How.ID,using="LOGIN_user")
	private WebElement EM7_LoginUserID;

	//Login Password
	// this below element is updated by NMR - 07/06/2016
	@FindBy(how=How.ID, using="password")
	//@FindBy(how=How.ID,using="LOGIN_pwd")
	private WebElement EM7_LoginPwd;
	
	@FindBy(how=How.ID,using="submit")
	private WebElement EM7_LoginSubmit;
	
	@FindBy(how=How.XPATH,using=".//*[@id='topMenu']")
	private WebElement EM7_TopMenu;

	@FindBy(how=How.XPATH,using="//table//td[contains(text(),'ID')]/../td[2]")
	private WebElement EM7_MonitoredID;
	
	@FindBy(how=How.XPATH,using="//button[contains(text(),'Close')]")
	private WebElement EM7_CloseBtn;
	
	//=======================================================
	//=======================================================
	
	public WebElement getEM7_LoginUserID() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_LoginUserID;
	}

	public WebElement getEM7_LoginPwd() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_LoginPwd;
	}

	public WebElement getEM7_LoginSubmit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_LoginSubmit;
	}

	public WebElement getEM7_TopMenu() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_TopMenu;
	}

	public WebElement getEM7_MonitoredID() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_MonitoredID;
	}

	public WebElement getEM7_CloseBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_CloseBtn;
	}
	
	
	//=======================================================
	          ///// Gideon Test case /////////
	//=======================================================
	
//////////EM7 Ticket page
	


	
@FindBy(how=How.XPATH, using="//div[@id='em7_mainnav']//div[@class='tabbar']//a[contains(text(),'ickets')]")
private WebElement EM7_TicketLink;

@FindBy(how=How.XPATH, using="//div[@id='summary_left']//div[contains(text(),'Private Cloud Firewall')]")
private WebElement EM7_DiscriptionEditField;

@FindBy(how=How.XPATH, using="//td[@id='tickets_descr_quick']//input[@name='descr']")
private WebElement EM7_DiscriptionSearchBox;

@FindBy(how=How.XPATH, using="//table[@id='tickets']//tr[1]/td[7]/a")
//@FindBy(how=How.XPATH, using="//table[@id='tickets']//tr[1]/td[2]//img")
private WebElement EM7_FirstTicketExpander;

@FindBy(how=How.XPATH, using="//td[@id='tickets_tid_quick']//input[@name='tid']")
private WebElement EM7_TidSearchBox;



public WebElement getEM7_TicketLink() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return EM7_TicketLink;
}


public WebElement getEM7_DiscriptionEditField() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return EM7_DiscriptionEditField;
}


public WebElement getEM7_DiscriptionSearchBox() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return EM7_DiscriptionSearchBox;
}


public WebElement getEM7_FirstTicketExpander() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return EM7_FirstTicketExpander;
}


public WebElement getEM7_TidSearchBox() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return EM7_TidSearchBox;
}

//////////////////// EM7 User accounts page








	@FindBy(how=How.XPATH, using="//a[contains(text(),'egistry')]")
	private WebElement EM7_RegistryButton;
	
	@FindBy(how=How.XPATH, using="//ul[@id='Accounts']//a[text()='User Accounts']")
	private WebElement EM7_UserAccountsLink;
	
	@FindBy(how=How.XPATH, using="//div[@id='title_container']/div[1]")
	private WebElement EM7_UserAccountsTitle;
	
	@FindBy(how=How.XPATH, using="//table[@id='users']//a[text()='Username']")
	private WebElement EM7_UserNameLink;
	
	@FindBy(how=How.XPATH, using="//td[@id='users_user_quick']//input[@name='user']")
	private WebElement EM7_UserNameSearchBox;
	
	@FindBy(how=How.XPATH, using="//table[@id='users']//a[text()='Last Name | First Name']")
	private WebElement EM7_LastNameLink;
	
	@FindBy(how=How.XPATH, using="//td[@id='users_fullname_quick']//input[@name='fullname']")
	private WebElement EM7_LastNameSearchBox;
	
	@FindBy(how=How.XPATH, using="//table[@id='users']//a[text()='Account Type']")
	private WebElement EM7_AccountTypeLink;
	
	@FindBy(how=How.XPATH, using="//td[@id='users_admin_quick']//input[@name='admin']")
	private WebElement EM7_AccountSerchBox;
	
	@FindBy(how=How.XPATH, using="//table[@id='users']//a[text()='User Policy']")
	private WebElement EM7_UserPolicyLink;
	
	@FindBy(how=How.XPATH, using="//td[@id='users_template_id_quick']//input[@name='template_id']")
	private WebElement EM7_UserPolicySearchBox;
	
	@FindBy(how=How.XPATH, using="//table[@id='users']//a[text()='Primary']")
	private WebElement EM7_PrimaryLink;
  
	@FindBy(how=How.XPATH, using="//td[@id='users_roa_id_quick']//input[@name='roa_id']")
	private WebElement EM7_PrimarySearchBox;
	
	@FindBy(how=How.XPATH, using="//table[@id='users']//a[text()='Email Address']")
	private WebElement EM7_EmailAddrsLink;
	
	@FindBy(how=How.XPATH, using="//td[@id='users_email_quick']//input[@name='email']")
	private WebElement EM7_EmailSearchBox;
	
	@FindBy(how=How.XPATH, using="//table[@id='users']//a[text()='State']")
	private WebElement EM7_StateLink;
	
	@FindBy(how=How.XPATH, using="//td[@id='users_state_quick']//input[@name='state']")
	private WebElement EM7_SateSearchBox;
	
	@FindBy(how=How.XPATH, using="//table[@id='users']//a[text()='Auth']")
	private WebElement EM7_AuthTypeLink;
	
	@FindBy(how=How.XPATH, using="//td[@id='users_ldap_quick']//input[@name='ldap']")
	private WebElement EM7_AuthSearchBox;
	
	@FindBy(how=How.XPATH, using="//table[@id='users']//a[text()='User']")
	private WebElement EM7_UserIdLink;
	
	@FindBy(how=How.XPATH, using="//td[@id='users_uid_quick']//input[@name='uid']")
	private WebElement EM7_UserIdSearchBox;
	
	@FindBy(how=How.XPATH, using="//table[@id='users']//a[text()='Edited By']")
	private WebElement EM7_EditedByLink;
	
	@FindBy(how=How.XPATH, using="//td[@id='users_edit_user_quick']//input[@name='edit_user']")
	private WebElement EM7_EditedSearchBox;
	
	@FindBy(how=How.XPATH, using="//table[@id='users']//a[text()='Last Edited']")
	private WebElement EM7_LastEditedLink;
	
	@FindBy(how=How.XPATH, using="//td[@id='users_edit_date_quick']//select[@name='edit_date']")
	private WebElement EM7_LasEditedDropDown;
	
	@FindBy(how=How.XPATH, using="//table[@id='users']//a[@class='selectall']")
	private WebElement EM7_SelectAllCheckBox;
	
	
	@FindBy(how=How.XPATH, using="//table[@id='users']//tbody")
	private WebElement EM7_UsersTable;
	
	@FindBy(how=How.ID, using="treeview_findme")
	private WebElement EM7_FindSearchBox;
	
	@FindBy(how=How.ID, using="users_pager")
	private WebElement EM7_ViewingPageDropDown;
	
	@FindBy(how=How.ID, using="bulk_function")
	private WebElement EM7_SelectActionDropDown;
	
	@FindBy(how=How.ID, using="bulk_function_submit")
	private WebElement EM7_GoButton;

	@FindBy(how=How.XPATH, using="//table[@id='users']//tr[contains(@id,'users_')]/td[8]")
	private WebElement EM7_ActiveState;
	
	@FindBy(how=How.XPATH, using="//table[@id='users']//tr[contains(@id,'users_')]/td[9]")
	private WebElement EM7_LDAPADState;
	
	@FindBy(how=How.ID, using="Accounts_label")
	//@FindBy(how=How.XPATH, using="//li[@id='Accounts_li']/div[@class='hitarea collapsable-hitarea']")
	private WebElement EM7_AccountsLink;
	
	// Hague -QAA03
	
	@FindBy(how=How.NAME, using="user")
	private WebElement EM7_UserAcc_UserEntryBox;
	
	@FindBy(how=How.NAME, using="roa_id")
	private WebElement EM7_UserAcc_PriOrgEntryBox;
	
	@FindBy(how=How.NAME, using="t_critical")
	private WebElement EM7_UserAcc_EditAccProp_CriContact;
	
	@FindBy(how=How.XPATH, using="html[@dir='ltr']")
	private WebElement EM7_UserAcc_EditAccProp_TextField;
	
	@FindBy(how=How.XPATH, using="//input[@value='Save'][@class='button']")
	private WebElement EM7_UserAcc_EditAccProp_SaveButton;
	
	@FindBy(how=How.XPATH, using="//b[contains(text(),'Update Successful')]")
	private WebElement EM7_UserAcc_EditAccProp_UpdatedSuccessfulMsg;
	

	public WebElement getEM7_RegistryButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_RegistryButton;
	}

	public WebElement getEM7_UserAccountsLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_UserAccountsLink;
	}

	public WebElement getEM7_UserAccountsTitle() {
		return EM7_UserAccountsTitle;
	}

	public WebElement getEM7_UserNameLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_UserNameLink;
	}

	public WebElement getEM7_UserNameSearchBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_UserNameSearchBox;
	}

	public WebElement getEM7_LastNameLink() {
		return EM7_LastNameLink;
	}

	public WebElement getEM7_LastNameSearchBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_LastNameSearchBox;
	}

	public WebElement getEM7_AccountTypeLink() {
		return EM7_AccountTypeLink;
	}

	public WebElement getEM7_AccountSerchBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_AccountSerchBox;
	}

	public WebElement getEM7_UserPolicyLink() {
		return EM7_UserPolicyLink;
	}

	public WebElement getEM7_UserPolicySearchBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_UserPolicySearchBox;
	}

	public WebElement getEM7_PrimaryLink() {
		return EM7_PrimaryLink;
	}

	public WebElement getEM7_PrimarySearchBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_PrimarySearchBox;
	}

	public WebElement getEM7_EmailAddrsLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_EmailAddrsLink;
	}

	public WebElement getEM7_EmailSearchBox() {
		return EM7_EmailSearchBox;
	}

	public WebElement getEM7_StateLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_StateLink;
	}

	public WebElement getEM7_SateSearchBox() {
		return EM7_SateSearchBox;
	}

	public WebElement getEM7_AuthTypeLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_AuthTypeLink;
	}

	public WebElement getEM7_AuthSearchBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_AuthSearchBox;
	}

	public WebElement getEM7_UserIdLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_UserIdLink;
	}

	public WebElement getEM7_UserIdSearchBox() {
		return EM7_UserIdSearchBox;
	}

	public WebElement getEM7_EditedByLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_EditedByLink;
	}

	public WebElement getEM7_EditedSearchBox() {
		return EM7_EditedSearchBox;
	}

	public WebElement getEM7_LastEditedLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_LastEditedLink;
	}

	public WebElement getEM7_LasEditedDropDown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_LasEditedDropDown;
	}

	public WebElement getEM7_SelectAllCheckBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_SelectAllCheckBox;
	}

	public WebElement getEM7_UsersTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_UsersTable;
	}

	public WebElement getEM7_FindSearchBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_FindSearchBox;
	}

	public WebElement getEM7_ViewingPageDropDown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_ViewingPageDropDown;
	}

	public WebElement getEM7_SelectActionDropDown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_SelectActionDropDown;
	}

	public WebElement getEM7_GoButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_GoButton;
	}

	public WebElement getEM7_ActiveState() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_ActiveState;
	}

	public WebElement getEM7_LDAPADState() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_LDAPADState;
	}

	public WebElement getEM7_AccountsLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_AccountsLink;
	}
	

	@FindBy(how=How.ID, using="LOGIN_user")
	private WebElement EM7_Account;
	
	@FindBy(how=How.ID, using="LOGIN_pwd")
	private WebElement EM7_Password;
	
	@FindBy(how=How.ID, using="submit")
	private WebElement EM7_SignIn;
	
	@FindBy(how=How.ID, using="TB_closeWindowButton")
	private WebElement EM7_TimeZonePopUpWindow;

	
	@FindBy(how=How.ID, using="Accounts_label")
	private WebElement EM7_Reg_AccountsButton;
	
	@FindBy(how=How.ID, using="Accounts_29_href")
	private WebElement EM7_Reg_Acc_UserAccButton;
	
	@FindBy(how=How.XPATH, using="//button[text()='Create']")
	private WebElement EM7_Reg_Acc_UserAcc_CreateButton;
	
	@FindBy(how=How.ID, using="t_contact_fname")
	private WebElement EM7_NewAcc_Firstname;
	
	@FindBy(how=How.ID, using="t_contact_lname")
	private WebElement EM7_NewAcc_Lastname;
	
	@FindBy(how=How.ID, using="t_user")
	private WebElement EM7_NewAcc_AccLoginname;
	
	@FindBy(how=How.NAME, using="t_email")
	private WebElement EM7_NewAcc_PrimaryEmail;
	
	@FindBy(how=How.ID, using="t_passwd")
	private WebElement EM7_NewAcc_Password;
	
	@FindBy(how=How.ID, using="tc_passwd")
	private WebElement EM7_NewAcc_ConfirmPassword;
	
	@FindBy(how=How.ID, using="pw_reset_toggle")
	private WebElement EM7_NewAcc_ReqPasswordReset;
	
	@FindBy(how=How.NAME, using="t_roa_id")
	private WebElement EM7_NewAcc_SelectOrg;
	
	@FindBy(how=How.NAME, using="t_type")
	private WebElement EM7_NewAcc_AccType;
	
	@FindBy(how=How.XPATH, using="//select[@class='etflight pol_grp']")
	private WebElement EM7_NewAcc_AccTemplate;
	
	@FindBy(how=How.NAME, using="save")
	private WebElement EM7_NewAcc_SaveButton;
	
	@FindBy(how=How.XPATH, using="//button[text()='Close']")
	private WebElement EM7_NewAcc_CloseButton;
	
	@FindBy(how=How.XPATH, using="//span[@class='navbar_bars_icon']")
	private WebElement EM7_NewAcc_ToolBoxButton;
	
	@FindBy(how=How.XPATH, using="//a[text()='LOG OFF']")
	private WebElement EM7_NewAcc_Logout;
	
////*******************************************Hague Start********************************//
	
	@FindBy(how=How.ID, using="users")
	private WebElement EM7_Reg_Acc_UserTable;
		
	public WebElement getEM7_Account() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_Account;
	}
	
	public WebElement getEM7_Password() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_Password;
		
	}
    
	public WebElement getEM7_SignIn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_SignIn;
	}
    
	public WebElement getEM7_TimeZonePopUpWindow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_TimeZonePopUpWindow;
	}
	
	

	
	public WebElement getEM7_Reg_AccountsButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_Reg_AccountsButton;
	}
	
	public WebElement getEM7_Reg_Acc_UserAccButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_Reg_Acc_UserAccButton;
	}
	
	public WebElement getEM7_Reg_Acc_UserAcc_CreateButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_Reg_Acc_UserAcc_CreateButton;
	}
	
	public WebElement getEM7_NewAcc_Firstname() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_NewAcc_Firstname;
	}
	
	public WebElement getEM7_NewAcc_Lastname() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_NewAcc_Lastname;
	}
    	
	public WebElement getEM7_NewAcc_AccLoginname() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_NewAcc_AccLoginname;
	}
	
	public WebElement getEM7_NewAcc_PrimaryEmail() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_NewAcc_PrimaryEmail;
	}
	
	public WebElement getEM7_NewAcc_Password() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_NewAcc_Password;
	}
	
	public WebElement getEM7_NewAcc_ConfirmPassword() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_NewAcc_ConfirmPassword;
	}
	
	public WebElement getEM7_NewAcc_ReqPasswordReset() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_NewAcc_ReqPasswordReset;
	}
	
	public WebElement getEM7_NewAcc_SelectOrg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_NewAcc_SelectOrg;
	}
	
	public WebElement getEM7_NewAcc_AccType() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_NewAcc_AccType;
	}
	
	public WebElement getEM7_NewAcc_AccTemplate() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_NewAcc_AccTemplate;
	}
	
	public WebElement getEM7_NewAcc_SaveButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_NewAcc_SaveButton;
	}
	
	public WebElement getEM7_NewAcc_CloseButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_NewAcc_CloseButton;
	}
	
	public WebElement getEM7_NewAcc_ToolBoxButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_NewAcc_ToolBoxButton;
	}
	
	public WebElement getEM7_NewAcc_Logout() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_NewAcc_Logout;
	}

	public WebElement getEM7_Reg_Acc_UserTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_Reg_Acc_UserTable;
	}

	public WebElement getEM7_UserAcc_UserEntryBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_UserAcc_UserEntryBox;
	}

	public WebElement getEM7_UserAcc_PriOrgEntryBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_UserAcc_PriOrgEntryBox;
	}

	public WebElement getEM7_UserAcc_EditAccProp_CriContact() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_UserAcc_EditAccProp_CriContact;
	}

	public WebElement getEM7_UserAcc_EditAccProp_TextField() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_UserAcc_EditAccProp_TextField;
	}

	public WebElement getEM7_UserAcc_EditAccProp_SaveButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_UserAcc_EditAccProp_SaveButton;
	}

	public WebElement getEM7_UserAcc_EditAccProp_UpdatedSuccessfulMsg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return EM7_UserAcc_EditAccProp_UpdatedSuccessfulMsg;
	}

	
	
}
