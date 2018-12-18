package com.whs.navigator.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class UserPermissionPageFactory {

	@FindBy(how=How.ID, using="p_p_id_UserManagement_WAR_usermanagementportlet_")
	private WebElement nav_UserManagementUnAvaiableErrorMsg;

	@FindBy(how=How.XPATH,  using="//section[@id='tickets']/div/h2/a[text()='tickets']")
	private WebElement nav_TicketPortalLink;
	
	
	@FindBy(how=How.ID, using="organizationCombo-inputEl")
	private WebElement nav_TicketOrgWebList;
	
	@FindBy(how=How.ID,  using="//table[@id='gridview-1091-table']")
	private WebElement nav_TicketTable;
	
	@FindBy(how=How.ID, using="tab-1059-btnInnerEl")
	private WebElement nav_DetailsTab;
	
	@FindBy(how=How.ID, using="textfield-1037-inputEl")
	private WebElement nav_DetailsEdit;
	
	@FindBy(how=How.ID, using="tab-1060-btnInnerEl")
	private WebElement nav_NotesTab;
	
	@FindBy(how=How.ID, using="button-1018-btnIconEl")
	private WebElement nav_CreateNoteBtn;
	
	@FindBy(how=How.ID, using="updTktBtn-btnIconEl")
	private WebElement nav_UpdateTicketBtn;
	
	@FindBy(how=How.ID, using="searchByCombo-inputEl")
	private WebElement nav_TicketSearchByList;
	
	@FindBy(how=How.ID, using="ext-comp-1094-inputEl")
	private WebElement nav_TicketSearchEdit;
	
	@FindBy(how=How.ID, using="button-1095-btnIconEl")
	private WebElement nav_TicketSearchBtn;
	
	@FindBy(how=How.XPATH,  using="//div[@id='TicketingPortletGrid']//table[contains(@id,'gridview-')]//tr[1]")
	private WebElement nav_TicketTableRow1;
	
	@FindBy(how=How.XPATH,  using="//table[@id='notesHtmleditor']//tr//div[@id='notesHtmleditor-inputCmp']//iframe")
	private WebElement nav_EnterNotesEdit;
	
	
	@FindBy(how=How.XPATH,  using="//div[contains(@id,'createNotePopup-')]//span[text()='OK']")
	private WebElement nav_CreateNoteOkBtn;
	
	//This element updated on 10/13/2015 by QAA03 for EXTJS5
	//@FindBy(how=How.ID, using="messagebox-1001-displayfield-bodyEl")
	@FindBy(how=How.ID, using="messagebox-1001-msg")
	private WebElement nav_popupMsg;
	
	@FindBy(how=How.ID, using="messagebox-1001-progressbar")
	private WebElement nav_ProgressBar;
	
	//This element updated on 10/13/2015 by QAA03 for EXTJS5
	//@FindBy(how=How.ID, using="button-1005-btnIconEl")
	@FindBy(how=How.ID, using="button-1005")
	private WebElement nav_PopupOkBtn;
	
	//@FindBy(how=How.ID, using="tab-1010-btnInnerEl")
	@FindBy(how=How.XPATH, using="//span[contains(@id,'tab-')][text()='Users']")
	private WebElement nav_UsersTab;
	
	//@FindBy(how=How.ID, using="tab-1011-btnInnerEl")
	@FindBy(how=How.XPATH, using="//span[contains(@id,'tab-')][text()='Manage Roles']")
	private WebElement nav_ManageRolesTab;
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'account')]")
	//@FindBy(how=How.CSS, using=".container>ul>li:nth-of-type(5)")
	private WebElement nav_AccountLink;
	
	@FindBy(how=How.LINK_TEXT, using="Permissions")
	private WebElement nav_PermissionsLink;
	
	//This element updated on 09/22/2015 by QAA03
	//@FindBy(how=How.XPATH, using="//table[contains(@id,'table')]")
	//@FindBy(how=How.ID, using="gridview-1046-table")
	@FindBy(how=How.ID, using="userListPanel-body")
	private WebElement nav_UserTable;
	
	@FindBy(how=How.XPATH, using="//div[1][contains(@id,'boundlist-')]//ul")
	private WebElement nav_UserRoleDropDown;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'combobox-')]//div[contains(@id,'-trigger-picker')]")
	private WebElement nav_UserRoleDropDownArrow;
	
/*	@FindBy(how=How.XPATH, using="//span[text()='Users']")
	private WebElement nav_UserTab;
	*/
	//@FindBy(how=How.ID, using="combobox-1023-inputEl")
	@FindBy(how=How.XPATH, using="//input[contains(@id,'combobox-')]")
	private WebElement nav_UserRoleDropDownAsEdit;
	
	
	@FindBy(how=How.ID, using="idRoleName-inputEl")
	private WebElement nav_SaveRoleAsEdit;
	
	@FindBy(how=How.XPATH, using="//div[@id='idCopyWindow']//span[contains(@id,'-btnInnerEl') and text()='Save']")
	private WebElement nav_SaveBtn;
	
	@FindBy(how=How.ID, using="messagebox-1001")
	private WebElement nav_ConfirmPopup;
	
	// This Element updated on 10/13/2015 by QAA03 for EXTJS5
	//@FindBy(how=How.ID, using="button-1005-btnIconEl")
	@FindBy(how=How.ID, using="button-1005-btnEl")
	private WebElement nav_ConfirmPopupOkBtn;
	
	@FindBy(how=How.XPATH, using="//div[@id='idCopyWindow']//input[contains(@id,'checkbox-')]")
	private WebElement nav_EditRole_ExpandAllCheckBox;
	
	@FindBy(how=How.XPATH, using="//div[@id='idPermissionTreePanelcurcopy-body']//table//tr//div/span[text()='Add User']/../input")
	private WebElement nav_EditRole_AddUserCheckBox;
	
	@FindBy(how=How.XPATH, using="//div[@id='idPermissionTreePanelcurcopy-body']//table//tr//div/span[text()='Delete User']/../input")
	private WebElement nav_EditRole_DeleteUserCheckBox;
	
	
	@FindBy(how=How.ID, using="idPermissionTreePanelcurcopy-body")
	private WebElement nav_EditRole_ParentWebTable;
	
	
	@FindBy(how=How.XPATH, using="//div[@id='idEditRoleBbar']//a//span[text()='Save']")
	private WebElement nav_EditRole_SaveBtn;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Create Ticket')]")
    private WebElement nav_CreateTicketLink;

	
	@FindBy(how=How.ID, using="userfeedback")
	private WebElement nav_Feedbackportlet;
	
	//Add user
	//This Element updated on 10/14/2015 for EXTJS5 by QAA03
	//@FindBy(how=How.ID, using="idBtnMUAddUser-btnInnerEl")
	//@FindBy(how=How.ID, using="idACLAddUserBtn-btnInnerEl")
	//updated-10/15/2015
	@FindBy(how=How.ID, using="idBtnMUAddUser")
	//This Element updated on 01/29/2016  by QAA03
	//@FindBy(how=How.ID, using="idBtnMUAddUser-btnIconEl")
	private WebElement nav_AddUserRoleLink;
	
	@FindBy(how=How.ID, using="idBtnMUAddUser-btnInnerEl")
	private WebElement nav_PermissionUserAddUserLink;
	
	@FindBy(how=How.NAME, using="firstName")
	private WebElement nav_FirstNameEdit;
	
	@FindBy(how=How.NAME, using="lastName")
	private WebElement nav_LastNameEdit;
	
	@FindBy(how=How.NAME, using="emailAddress")
	private WebElement nav_EmailAddressEdit;
	
	@FindBy(how=How.NAME, using="phone")
	private WebElement nav_PhoneEdit;
	
	@FindBy(how=How.NAME, using="cell")
	private WebElement nav_CellEdit;
	
	//@FindBy(how=How.XPATH,using="//span[contains(@id,'button-') and text()='OK']")
	@FindBy(how=How.XPATH,using="//span[contains(@id,'button') and text()='OK']")
    private WebElement nav_AddUserOKbtn;
	
	@FindBy(how=How.ID, using="orgListForUM-inputEl")
	private WebElement nav_OrgSelectDropDown;
	
	@FindBy(how=How.XPATH,using="//span[text()='Manage Entities']")
    private WebElement nav_ManageEntityTab;
	
	@FindBy(how=How.ID,using="idENNameButton-btnInnerEl")
	private WebElement nav_ManageEntityNameHeader;
	
	//Vivek
	@FindBy(how=How.XPATH,using="//input[contains(@id,'inputEl')][@name='copyToEntityId']")
	private WebElement nav_ManageEntityCopyEdit;
	
	
	@FindBy(how=How.XPATH, using = " //div[@id='userListPanel-body']//tr[1]//td[5]/div")
	private WebElement nav_OrgTitleInEntityColumn;
	
	
	////////////////////////// QAA04 //////////////////////////////
	
	/// taken from eilerson 
			@FindBy(how=How.XPATH, using="//ul[@id='idMultiMenuOrgs']//a[text()='11Giraffes']")
			private WebElement nav_11GiraffesLinkUnderOrg;
			
			//Add user on Escalation page
			@FindBy(how=How.ID, using="idACLAddUserBtn")
			private WebElement nav_AddUserLink;
			
			@FindBy(how=How.XPATH, using="//div[@id='userListPanel-body']//table//div[text()='rram']")
			private WebElement nav_RramUserTitle;

			@FindBy(how=How.XPATH, using="//div[text()='rram']/../..//td[contains(@class,'right-padded-cell x-unselectable')]/div")
			private WebElement nav_RoleTitleForRramUser;
			
			@FindBy(how=How.ID, using="orgListForUM-inputEl")
			private WebElement nav_SelectOrgEditBox;
			
			@FindBy(how=How.XPATH, using="//div[@id='userListPanel-body']//table//div[text()='rramdev']")
			private WebElement nav_RramdevUserTitle;
			
			@FindBy(how=How.XPATH, using="//div[text()='rramdev']/../..//td[contains(@class,'right-padded-cell x-unselectable')]/div")
			private WebElement nav_RoleTitleForRramdevUser;
			
			@FindBy(how=How.XPATH, using="//div[contains(@id,'boundlist-')]//li[text()='TST Devco1_2285']")
			//@FindBy(how=How.XPATH, using="//li[text()='tstdemoorg_2818']")
			private WebElement nav_TstDevcoTitle;
			
			
	////////////////////////////////////////////////////////////////////////////////////////////////
			
/////*********************************************Eilerson QAA03**************************************/////
			
			@FindBy(how=How.ID, using="main-content")
			private WebElement nav_Users_Table;
			
			@FindBy(how=How.XPATH, using="//div[@class='x-grid-item-container']/table[1]//tr[1]/td[5]/div")
			private WebElement nav_Users_EntityColumn;
			
	
	public WebElement getNav_UserManagementUnAvaiableErrorMsg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_UserManagementUnAvaiableErrorMsg;
	}


	public WebElement getNav_TicketPortalLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketPortalLink;
	}


	public WebElement getNav_TicketTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketTable;
	}
	
	public WebElement getNav_TicketOrgWebList() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketOrgWebList;
	}


	public WebElement getNav_DetailsTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DetailsTab;
	}


	public WebElement getNav_DetailsEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DetailsEdit;
	}


	public WebElement getNav_NotesTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NotesTab;
	}


	public WebElement getNav_CreateNoteBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateNoteBtn;
	}


	public WebElement getNav_UpdateTicketBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_UpdateTicketBtn;
	}


	public WebElement getNav_TicketSearchByList() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketSearchByList;
	}


	public WebElement getNav_TicketSearchEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketSearchEdit;
	}


	public WebElement getNav_TicketSearchBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketSearchBtn;
	}


	public WebElement getNav_TicketTableRow1() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketTableRow1;
	}


	public WebElement getNav_CreateNoteOkBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateNoteOkBtn;
	}


	public WebElement getNav_popupMsg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_popupMsg;
	}


	public WebElement getNav_ProgressBar() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ProgressBar;
	}


	public WebElement getNav_PopupOkBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PopupOkBtn;
	}


	public WebElement getNav_UsersTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_UsersTab;
	}


	public WebElement getNav_ManageRolesTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageRolesTab;
	}


	public WebElement getNav_AccountLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AccountLink;
	}


	public WebElement getNav_PermissionsLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PermissionsLink;
	}


	public WebElement getNav_UserTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_UserTable;
	}

/*	public WebElement getNav_nav_UserTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_UserTab;
	}
	*/

	public WebElement getNav_UserRoleDropDown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_UserRoleDropDown;
	}


	public WebElement getNav_UserRoleDropDownAsEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_UserRoleDropDownAsEdit;
	}


	public WebElement getNav_EnterNotesEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EnterNotesEdit;
	}


	public WebElement getNav_SaveRoleAsEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SaveRoleAsEdit;
	}


	public WebElement getNav_SaveBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SaveBtn;
	}


	public WebElement getNav_ConfirmPopup() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ConfirmPopup;
	}


	public WebElement getNav_ConfirmPopupOkBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ConfirmPopupOkBtn;
	}


	public WebElement getNav_EditRole_ExpandAllCheckBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditRole_ExpandAllCheckBox;
	}


	public WebElement getNav_EditRole_AddUserCheckBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditRole_AddUserCheckBox;
	}


	public WebElement getNav_EditRole_DeleteUserCheckBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditRole_DeleteUserCheckBox;
	}


	public WebElement getNav_EditRole_SaveBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditRole_SaveBtn;
	}
	
    public WebElement getNav_CreateTicketLink() {
        FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
        return nav_CreateTicketLink;
  }


	public WebElement getNav_Feedbackportlet() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Feedbackportlet;
	}


	public WebElement getNav_AddUserRoleLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddUserRoleLink;
	}


	public WebElement getNav_FirstNameEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FirstNameEdit;
	}


	public WebElement getNav_LastNameEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_LastNameEdit;
	}


	public WebElement getNav_EmailAddressEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EmailAddressEdit;
	}


	public WebElement getNav_PhoneEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PhoneEdit;
	}


	public WebElement getNav_CellEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CellEdit;
	}


	public WebElement getNav_AddUserOKbtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddUserOKbtn;
	}

	public WebElement getNav_OrgTitleInEntityColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_OrgTitleInEntityColumn;
	}
	
    
    ////#################  Vivek ################################################
	
	



	@FindBy(how=How.XPATH,using="//*[@id='p_p_id_NavOrganization_WAR_navorganizationportlet_']//section[@class='rectangle long evdc']")
	private WebElement nav_UPEVDCPortletParent;
	
	//EVDC Name
	//@FindBy(how=How.XPATH,using="//*[@id='edvc_1']/a")
	@FindBy(how=How.XPATH,using="//div[@id='nav_org_maindev']//h2[@id='edvc_1']/a[@class='navigationMarker']")
	private WebElement nav_EVDCNameLink;

	//VCloud Director
	@FindBy(how=How.XPATH, using="//span/a[contains(text(),'vCloud Director')]")
	private WebElement nav_vCloudDirectorLink;
	
	

	//EVDC Selector dropdown
	
	@FindBy(how=How.XPATH,using="//div[@class='select_evdc']/nobr/ul/li[@class='evdc_options']/a")
	private WebElement nav_EVDCOrgSelector;
		
	@FindBy(how=How.XPATH,using="//li[@class='evdc_options']/ul")
	private WebElement nav_EVDCOrgSelectorDropDown;
		
		
	//Virtual Machine Link
	@FindBy(how=How.LINK_TEXT,using="Virtual Machines")
	private WebElement nav_EVDCOverviewVirtualMachineLink;
	
	//Add Virtual machine link
	@FindBy(how=How.LINK_TEXT,using="Add Virtual Machine")
	private WebElement nav_AddVMLink;
	
	
	//VM Table
	//@FindBy(how=How.ID,using="gridview-1010-table")
	@FindBy(how=How.XPATH,using="//div[@id='vmListExtGridPanel-body']")
	private WebElement nav_VMTable;
	
	//Start Pop up message
	//This Element updated on 10/13/2015 for EXTJS5 by QAA03
	//@FindBy(how=How.XPATH,using="/html/body/div[9]/div/div")
	@FindBy(how=How.XPATH,using="/html/body/div[4]/div/div/div")
	private WebElement nav_StartPopUpMsg;
	
	
	//Stop Popup Message
	@FindBy(how=How.XPATH,using="//div/div[text()='Sending Stop request...']")
	private WebElement nav_StopPopUpMsg;
	
	
	//Suspend popup message
	@FindBy(how=How.XPATH,using="//div/div[text()='Sending Suspend request...']")
	private WebElement nav_SuspendPopUpMsg;
	
	
	//Reset popup message
	@FindBy(how=How.XPATH,using="//div/div[text()='Refreshing VM Info ...']")
	private WebElement nav_RefreshPopUpMsg;
	
	
	
	
	//##################################################################
	public WebElement getNav_UPEVDCPortletParent() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_UPEVDCPortletParent;
	}

	public WebElement getNav_EVDCNameLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCNameLink;
	}

	public WebElement getNav_vCloudDirectorLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_vCloudDirectorLink;
	}

	public WebElement getNav_EVDCOrgSelector() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCOrgSelector;
	}

	public WebElement getNav_EVDCOverviewVirtualMachineLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCOverviewVirtualMachineLink;
	}

	public WebElement getNav_AddVMLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddVMLink;
	}

	public WebElement getNav_VMTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_VMTable;
	}
	

	public WebElement getNav_StartPopUpMsg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_StartPopUpMsg;
	}

	public WebElement getNav_StopPopUpMsg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_StopPopUpMsg;
	}

	public WebElement getNav_SuspendPopUpMsg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SuspendPopUpMsg;
	}

	public WebElement getNav_RefreshPopUpMsg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_RefreshPopUpMsg;
	}

/////############################vivek end  #######################################3333333
    
/////############################ sukur  #######################################3333333
	

	
	//Reports-Permission objects
		@FindBy(how=How.XPATH, using="//*[contains(text(),'monitoring')]")
		private WebElement nav_MonitoringTab;
		
		@FindBy(how=How.XPATH, using="//*[contains(text(),'Summary View')]")
		private WebElement nav_SummaryView;
		
		@FindBy(how=How.LINK_TEXT,  using="Reports")
		private WebElement nav_ReportLink;
		
		@FindBy(how=How.ID,  using="ReportLauncherPortletDiv")
		private WebElement nav_NetworkReportLink;
		
		//Escalation-Permission objects
		
		//@FindBy(how=How.XPATH, using="//*[contains(text(),'account')]")
		//private WebElement nav_AccountTab;
		
		@FindBy(how=How.XPATH,using="//a[contains(text(),'account')]")
		private WebElement nav_AccountTab;
			
		@FindBy(how=How.LINK_TEXT,  using="Escalation List")
		private WebElement nav_EscalationListLink;
		
		//updated by QAA03 on 07/29/2016
		//@FindBy(how=How.XPATH, using="//*[contains(text(),'Critical Escalation List')]")
		@FindBy(how=How.XPATH, using="//span[contains(@id,'-btnEl')]/span[text()='Critical Escalation List']")
		private WebElement nav_CriticalEscalationListTab;
		
		@FindBy(how=How.XPATH, using="//*[contains(text(),'Authorized Contact List')]")
		private WebElement nav_AuthorizedContactListTab;
		
		//@FindBy(how=How.XPATH,  using="//table[contains(@id,'gridview-')]")
		//@FindBy(how=How.XPATH,  using="//span[contains(text(),'Critical Escalation List')]/../../../../../../../..//div[@id='idCELGridPanel-body']//table[contains(@id,'gridview-')]")
		@FindBy(how=How.XPATH,  using="//table[contains(@id,'gridview-1016-table')]")
		private WebElement nav_RoleACriticalEscalationListTable;
		
		@FindBy(how=How.XPATH,  using="//table[contains(@id,'gridview-1015-table')]")
		private WebElement nav_RoleCECriticalEscalationListTable;
		//@FindBy(how=How.XPATH,  using="//table[contains(@id,'gridview-')]")
		//@FindBy(how=How.XPATH,  using="//span[contains(text(),'Authorized Contact List')]/../../../../../../../..//div[@id='idCELGridPanel-body']//table[contains(@id,'gridview-')]")
		@FindBy(how=How.XPATH,  using="//table[contains(@id,'gridview-1026-table')]")
		private WebElement nav_RoleAAuthorizedContactListTable;
		
		//This element updated on 10/14/2015 for EXTJS5 by QAA03
		//@FindBy(how=How.XPATH,  using="//span[contains(text(),'Authorized Contact List')]/../../../../../../../..//div[@id='idACLGridPanel-body']//table[contains(@id,'gridview-')]")
		@FindBy(how=How.ID,  using="idACLGridPanel-body")
		//@FindBy(how=How.XPATH,  using="//table[contains(@id,'gridview-1026-table')]")
		private WebElement nav_AuthorizedContactListTableParent;
		
		// This element updated on 10/06/2015 by QAA03 for EXTJS5
		//@FindBy(how=How.XPATH,  using="//span[contains(text(),'Critical Escalation List')]/../../../../../../../..//div[@id='idCELGridPanel-body']//table[contains(@id,'gridview-')]")
		//@FindBy(how=How.XPATH,  using="//table[contains(@id,'gridview-1016-table')]")
		
		@FindBy(how=How.XPATH,  using="//div[@id='idCELGridPanel-body']")
		private WebElement nav_CriticalEscalationListTable;
				
		@FindBy(how=How.XPATH,  using="//table[contains(@id,'gridview-1025-table')]")
		private WebElement nav_RoleCEAuthorizedContactListTable;
		
		//duplicate of nav_AddUserRoleLink
		/*@FindBy(how=How.ID,  using="idACLAddUserBtn")
		private WebElement nav_AddUserLink;*/
		
		//This element updated on 09/22/2015 by QAA03
		//@FindBy(how=How.ID,  using="idACLaddUserWindow")
		@FindBy(how=How.ID,  using="idAddUserPanel-innerCt")
		private WebElement nav_AddUserPopwindow;
		
		//duplicate of nav_FirstNameEdit
		/*@FindBy(how=How.XPATH, using="//*[contains(@name,'firstName')]")
		private WebElement nav_AddUserWindowFirstNameInput;*/
		
		//duplicate of nav_LastNameEdit
		/*@FindBy(how=How.XPATH, using="//*[contains(@name,'lastName')]")
		private WebElement nav_AddUserWindowLastNameInput;*/
		
		//duplicate of nav_EmailAddressEdit
		/*@FindBy(how=How.XPATH, using="//*[contains(@name,'emailAddress')]")
		private WebElement nav_AddUserWindowemailAddressInput;*/
		
		//duplicate of nav_PhoneEdit
		/*@FindBy(how=How.XPATH, using="//*[contains(@name,'phone')]")
		private WebElement nav_AddUserWindowphoneInput;*/
		
		//duplicate of nav_CellEdit
		/*@FindBy(how=How.XPATH, using="//*[contains(@name,'cell')]")
		private WebElement nav_AddUserWindowcellInput;*/
		
		@FindBy(how=How.XPATH, using="//*[contains(text(),'Cancel')]")
		private WebElement nav_AddUserWindowCancelButton;
		
		//duplicate of nav_AddUserOKbtn
		/*@FindBy(how=How.XPATH, using="//*[contains(text(),'OK')]")
		private WebElement nav_AddUserWindowOkButton;*/
		
		@FindBy(how=How.XPATH, using="//div[contains(text(),'Successfully created a ticket with TicketId')]")
		private WebElement nav_AddUserSucessMessage;
		
		//duplicate of nav_ConfirmPopupOkBtn
		/*@FindBy(how=How.ID, using="button-1005-btnIconEl")
		private WebElement nav_AddUserSucessMessageOKButton;*/
		
		@FindBy(how=How.XPATH, using="//div[contains(text(),'Are you sure you want to remove Test Test from the Critical Escalation List?')]")
		private WebElement nav_DeleteUserConfirmMessage;
		
		//Updated on 01/29/2016 by QAA03
		//@FindBy(how=How.ID, using="button-1005-btnIconEl")
		@FindBy(how=How.ID, using="button-1005-btnEl")
		private WebElement nav_DeleteUserWindowOkButton;
		
		//@FindBy(how=How.XPATH, using="//div[contains(text(),'Are you sure you want to add Web Test to the Critical Escalation List?')]")
		//private WebElement nav_EditUserConfirmMessage;
		
		@FindBy(how=How.ID, using="button-1005-btnIconEl")
		private WebElement nav_EditUserWindowOkButton;
		
		@FindBy(how=How.ID, using="messagebox-1001")
		private WebElement nav_PopupWindow;
		
		@FindBy(how=How.XPATH, using="//*[contains(text(),'OK')]")
		private WebElement nav_PopupWindowOkButton;
		
		@FindBy(how=How.ID, using="userfeedback")
		private WebElement nav_FeedBackArea;
		
		@FindBy(how=How.XPATH, using="//span[contains(text(),'Add to Critical Escalation List')]")
		private WebElement nav_AddtoCriticalEscalationListLink;

		
		//DRaas
		@FindBy(how=How.XPATH,using="//a[contains(text(),'services')]")
		private WebElement nav_ServicesTab;
			
		@FindBy(how=How.LINK_TEXT,  using="DRaaS")
		private WebElement nav_DRaaSLink;
		
		@FindBy(how=How.XPATH,  using="//span[contains(text(),'Host Based Replication')]")
		private WebElement nav_HostBasedReplicationText;
		
		@FindBy(how=How.XPATH,  using="//span[contains(text(),'Storage Array Based Replication')]")
		private WebElement nav_StorageArrayBasedReplicationText;
		
		//@FindBy(how=How.XPATH,  using="//span[contains(text(),'Add Drive')]")
		//private WebElement nav_AddDrive;
		
		@FindBy(how=How.ID,  using="idBtnHBRAddDrive-btnInnerEl")
		private WebElement nav_HostBasedReplicationAddDrive;
		
		@FindBy(how=How.ID,  using="idBtnSBRAddDrive-btnInnerEl")
		private WebElement nav_StorageArrayBasedReplicationAddDrive;
		
		@FindBy(how=How.XPATH,  using="//input[contains(@name,'hostName')]")
		private WebElement nav_HostName;
		
		@FindBy(how=How.XPATH,  using="//input[contains(@name,'ipAddress')]")
		private WebElement nav_HostIpAddress;
		
		@FindBy(how=How.XPATH,  using="//input[contains(@name,'drivesToAdd')]")
		private WebElement nav_DrivesToAdd;
		
		//@FindBy(how=How.XPATH,  using="//span[contains(text(),'Save')]/../span[@class='x-btn-icon-el']")
		@FindBy(how=How.XPATH,  using="//span[contains(text(),'Save')]")
		private WebElement nav_SaveDrive;
		
		
		@FindBy(how=How.XPATH,  using="//input[contains(@name,'srcControllerName')]")
		private WebElement nav_SourceStorageControllerName;
		
		@FindBy(how=How.XPATH,  using="//input[contains(@name,'srcControllerIP')]")
		private WebElement nav_SourceStorageControllerIP;
		
		@FindBy(how=How.XPATH,  using="//input[contains(@name,'srcVolumeName')]")
		private WebElement nav_SourceVolumeName;
		
		@FindBy(how=How.ID,  using="idBtnHBRManage-btnInnerEl")
		private WebElement nav_ManageDriveButton;
		
		@FindBy(how=How.XPATH,  using="//table[contains(@id,'gridview-1032-table')]")
		private WebElement nav_ManageDriveTable;
		
		@FindBy(how=How.XPATH,  using="//div[@id='idfpWindowDelete']")
		private WebElement nav_DeleteDrivePopup;
		
		@FindBy(how=How.XPATH,  using="//span[contains(text(),'OK')]")
		private WebElement nav_DeleteDrivePopupOKButton;
		
		@FindBy(how=How.XPATH,  using="//span[contains(text(),'Remove Drive from Host-Based Replication')]")
		private WebElement nav_DeleteDriveMsg;
		
		//Forms
		@FindBy(how=How.XPATH,using="//a[contains(text(),'support')]")
		private WebElement nav_SupportTab;
			
		@FindBy(how=How.LINK_TEXT,  using="Build Requirements (Forms)")
		private WebElement nav_FormsLink;
		
		@FindBy(how=How.ID,  using="user")
		private WebElement nav_FormsUserInput;
		
		@FindBy(how=How.ID,  using="password")
		private WebElement nav_FormsPasswordInput;
		
		@FindBy(how=How.CSS,  using=".submit")
		private WebElement nav_FormsSubmitButton;
		
		@FindBy(how=How.XPATH,  using="//h3[contains(text(),'Forms Awaiting WHS Approval')]")
		private WebElement nav_FormsHomePageText;
		
		@FindBy(how=How.ID,using="LOGIN_user")
		private WebElement EM7_LoginUserID;

		//Login Password
		@FindBy(how=How.ID,using="LOGIN_pwd")
		private WebElement EM7_LoginPwd;
		
		@FindBy(how=How.ID,using="submit")
		private WebElement EM7_LoginSubmit;
		
		//The below two Elements updated on 10/14/2015 for EXTJS5 by QAA03
		@FindBy(how=How.XPATH,using="//span[@class='navbar_bars_icon']")
		private WebElement EM7_ToolBoxIcon;
		
		@FindBy(how=How.XPATH,using="//a[text()='LOG OFF']")
		private WebElement EM7_Logoff;
		
		@FindBy(how=How.XPATH,using=".//*[@id='topMenu']")
		private WebElement EM7_TopMenu;
		
		@FindBy(how=How.XPATH,using="//a[contains(text(),'[Sign-out]')]")
		private WebElement EM7_SignOutLink;

		@FindBy(how=How.XPATH,using="//table//td[contains(text(),'ID')]/../td[2]")
		private WebElement EM7_MonitoredID;
		
		@FindBy(how=How.XPATH,using="//button[contains(text(),'Close')]")
		private WebElement EM7_CloseBtn;
		
		//=======================================================
		//=======================================================
		//Ticket
		@FindBy(how=How.XPATH,using="//div[contains(@class,'CreateTicketPopup')]")
		private WebElement nav_CreateTicketPopupWindow;
		
		//@FindBy(how=How.XPATH,using="//a[contains(text(),'Detail Ticket System')]")
		@FindBy(how=How.XPATH,using="//a[contains(text(),'Detailed Ticketing System')]")
		private WebElement nav_DetailTicketSystem;
		
		

	  @FindBy(how=How.ID, using="navpopupbody")
       private WebElement nav_ConfirmNewPopup;
       
       @FindBy(how=How.XPATH, using="//div[@id='navpopupbuttons']/span/a[contains(text(),'Ok')]")
       private WebElement nav_ConfirmNewPopupOKBtn;
       
       @FindBy(how=How.XPATH, using="//div[@id='navpopupbuttons']/span/a[contains(text(),'Cancel')]")
       private WebElement nav_ConfirmNewPopupCancelBtn;
		

		
	//'==================================================================
		
		//FireWall
		@FindBy(how=How.XPATH,using="//a[contains(text(),'Andover')]")
		private WebElement nav_EVDCPortalLink;
		
		@FindBy(how=How.XPATH,using="//a[contains(text(),'Firewall')]")
		private WebElement nav_FirewallLink;
		
		@FindBy(how=How.XPATH,using="//table[contains(@class,'vm_table_construction')]")
		private WebElement nav_FirewallTable;
		
		@FindBy(how=How.XPATH,using="//a[contains(text(),'Add Firewall Rule')]")
		private WebElement nav_AddFireWallLink;
		
		@FindBy(how=How.XPATH,using="//div[@id='firewall_rules']")
		private WebElement nav_AddFireWallWindow;
		
		
		
		@FindBy(how=How.XPATH,using="//input[@id='sequenceId-inputId']")
		private WebElement nav_SequenceNumber;
		
		@FindBy(how=How.XPATH,using="//input[@id='sourceIp-inputId']")
		private WebElement nav_Source;
		
		@FindBy(how=How.XPATH,using="//input[@id='sourceMask-inputId']")
		private WebElement nav_SourceMask;
		
		@FindBy(how=How.XPATH,using="//input[@id='destinationIp-inputId']")
		private WebElement nav_Destination;
		
		@FindBy(how=How.XPATH,using="//input[@id='destinationMask-inputId']")
		private WebElement nav_DestinationMask;
		
		@FindBy(how=How.XPATH,using="//input[@id='protocolId-inputId']")
		private WebElement nav_ProtocolId;
		
		@FindBy(how=How.XPATH,using="//input[@id='portName-inputId']")
		private WebElement nav_PortName;
		
		@FindBy(how=How.XPATH,using="//*[contains(text(),'Save')]")
		private WebElement nav_FirewallSaveButton;
		
		@FindBy(how=How.XPATH,using="//section[@id='add_firewall_rule']")
		private WebElement nav_FirewallRuleTable;
		
		@FindBy(how=How.XPATH,using="//table/tbody//input[contains(@id,'fwEdit-seqNum-inputId')]")
		private WebElement nav_SequenceNumberinFirewallRuleTable;
		
		
		@FindBy(how=How.XPATH,using="//input[@id='sourceIp-inputId']/../../td[contains(@id,'ext-gen')]")
		private WebElement nav_SourceDropDownIcon;
		
		@FindBy(how=How.XPATH,using="//input[@id='destinationIp-inputId']/../../td[contains(@id,'ext-gen')]")
		private WebElement nav_DestinationDownIcon;
		
		@FindBy(how=How.XPATH,using="//input[@id='protocolId-inputId']/../../td[contains(@id,'ext-gen')]")
		private WebElement nav_ProtocolDownIcon;
		
		@FindBy(how=How.XPATH,using="//div[5]/div/ul[@class='x-list-plain']")
		private WebElement nav_SourceList;
		
		@FindBy(how=How.XPATH,using="//div[6]/div/ul[@class='x-list-plain']")
		private WebElement nav_DestinationList;
		
		@FindBy(how=How.XPATH,using="//div[7]/div/ul[@class='x-list-plain']")
		private WebElement nav_ProtocolList;
		
// This Element updated on 10/14/2015 by QAA03 for EXTJS5
		
//@FindBy(how=How.XPATH,using="//section//table//tr[1]/td/table//span[contains(@id,'fwEdit-moveButton-fwRuID')]/a[contains(text(),'Move')]")
@FindBy(how=How.XPATH,using="//div[@class='x-grid-item-container']//table[1]//a[text()='Move']")		
private WebElement nav_MoveLink;

@FindBy(how=How.XPATH,using="//section//table//tr[1]/td/table//span[contains(@id,'fwEdit-editButton-fwRuID')]/a[contains(text(),'Edit')]")
private WebElement nav_EditLink;

// This Element updated on 10/14/2015 by QAA03 for EXTJS5
//@FindBy(how=How.XPATH,using="//section//table//tr[1]/td/table//span[contains(@id,'fwEdit-deleteButton-fwRuID')]/a[contains(text(),'Delete')]")
@FindBy(how=How.XPATH,using="//div[@class='x-grid-item-container']//table[1]//a[text()='Delete']")
private WebElement nav_DeleteLink;

@FindBy(how=How.XPATH,using="//section//table//tr[1]/td/table//span[contains(@id,'fwEdit-cancelButton-fwRuID')]/a[contains(text(),'Cancel')]")
private WebElement nav_CancelLink;

@FindBy(how=How.XPATH,using="//section//table//tr[1]/td/table//span[contains(@id,'fwEdit-saveButton-fwRuID')]/a[contains(text(),'Save Edits')]")
private WebElement nav_SaveEditsLink;

//Virtual Machine
	@FindBy(how=How.LINK_TEXT,using="Virtual Machines")
	private WebElement nav_EVDCOverviewVirtualMachine;
	
	//This Element updated on 10/07/2015 by QAA03 for EXTJS5
	//@FindBy(how=How.XPATH,using=".//*[@id='gridview-1010-body']")
	@FindBy(how=How.XPATH,using=".//*[@id='vmListExtGridPanel-body']")
	private WebElement nav_VMWebTable;
	
	@FindBy(how=How.XPATH, using="//span[contains(@id,'btnInnerEl') and text()='Save']")
	private WebElement nav_EM_Edit_SaveBtn;	
	
	@FindBy(how=How.XPATH, using="//div[@id='idENENtitiesTreePanel-body']")
	private WebElement nav_Users_ManageEntityParentWebTable;
	
	@FindBy(how=How.ID, using="idENExpandAllCB-inputEl")
	private WebElement nav_EM_Edit_ExpandAllCheckBox;
	
	@FindBy(how=How.XPATH, using="//span[contains(@id,'btnInnerEl') and text()='Cancel']")
	//@FindBy(how=How.XPATH, using="//span[contains(@class,'x-btn-inner-default-toolbar-small')][text()='Cancel']")
	private WebElement nav_EM_Edit_CancelBtn;
	
	@FindBy(how=How.XPATH,using="//span[contains(@id,'rebutton') and text()='Cancel']")
	private WebElement nav_EM_Edit_ReCancelBtn;
	
	@FindBy(how=How.XPATH,using="//div[@id='idENEditorWindow']/img[@class='closeicon']")
	private WebElement nav_EM_Edit_CloseImage;
	
	@FindBy(how=How.ID, using="idENPermissionsTree-body")
	private WebElement nav_Users_ManageEntityEditParentWebTable;
	
	//// __________________ QAA04 ____________________ ///
	// Taken from clark
	@FindBy(how=How.XPATH, using = "//div[contains(@id,'-targetEl')]//div[contains(@id,'gridcolumn-')]//span[text()='Entity']")
	private WebElement nav_entityColumnUnderPermissionsTab;
	
	
	@FindBy(how=How.XPATH, using = "//div[contains(@id,'-targetEl')]//div[contains(@id,'gridcolumn-')]//span[text()='Parent']")
	private WebElement nav_parentsColumnUnderPermissionsTab;
	
	/// ___________________ QAA04 ____________________////
	
	public WebElement getNav_nav_EM_Edit_CancelBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EM_Edit_CancelBtn;
	}
	
	public WebElement getNav_Users_ManageEntityEditParentWebTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Users_ManageEntityEditParentWebTable;
	}
	
	public WebElement getNav_Users_ManageEntityParentWebTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Users_ManageEntityParentWebTable;
	}
	
	public WebElement getNav_EM_Edit_ExpandAllCheckBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EM_Edit_ExpandAllCheckBox;
	}
	public WebElement getNav_VMWebTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_VMWebTable;
	}
public WebElement getNav_EVDCOverviewVirtualMachine() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_EVDCOverviewVirtualMachine;
}

public WebElement getNav_MoveLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_MoveLink;
		}

public WebElement getNav_EditLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditLink;
		}

public WebElement getNav_DeleteLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DeleteLink;
		}	
public WebElement getNav_CancelLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CancelLink;
		}
public WebElement getNav_SaveEditsLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SaveEditsLink;
		}
		
		
		public WebElement getNav_SequenceNumberinFirewallRuleTable() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_SequenceNumberinFirewallRuleTable;
		}
		
		public WebElement getNav_SourceDropDownIcon() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_SourceDropDownIcon;
		}
		
		public WebElement getNav_nav_SourceDropDownIcon() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_DestinationDownIcon;
		}
		public WebElement getNav_DestinationDownIcon() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_DestinationDownIcon;
		}
		
		public WebElement getNav_ProtocolDownIcon() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_ProtocolDownIcon;
		}
		
		public WebElement getNav_SourceList() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_SourceList;
		}
		
		public WebElement getNav_DestinationList() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_DestinationList;
		}
		
		public WebElement getNav_ProtocolList() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_ProtocolList;
		}
		public WebElement getNav_FirewallSaveButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_FirewallSaveButton;
		}
		
		public WebElement getNav_FirewallRuleTable() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_FirewallRuleTable;
		}
		
		public WebElement getNav_PortName() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_PortName;
		}
		public WebElement getNav_ProtocolId() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_ProtocolId;
		}
		public WebElement getNav_DestinationMask() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_DestinationMask;
		}
		public WebElement getNav_Destination() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_Destination;
		}
		public WebElement getNav_SourceMask() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_SourceMask;
		}
		public WebElement getNav_Source() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_Source;
		}
		public WebElement getNav_SequenceNumber() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_SequenceNumber;
		}
		public WebElement getNav_AddFireWallWindow() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_AddFireWallWindow;
		}
		
		public WebElement getNav_AddFireWallLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_AddFireWallLink;
		}
		
		public WebElement getNav_EVDCPortalLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EVDCPortalLink;
		}
		
		public WebElement getNav_FirewallLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_FirewallLink;
		}
		
		public WebElement getNav_FirewallTable() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_FirewallTable;
		}
		


		public WebElement getNav_MonitoringTab() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_MonitoringTab;
		}
		
		public WebElement getNav_SummaryViewLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_SummaryView;
		}
		
		
		public WebElement getNav_ReportLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_ReportLink;
		}
		public WebElement getNav_PopupWindowOkButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_PopupWindowOkButton;
		}
		public WebElement getNav_NetworkReportLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_NetworkReportLink;
		}

		public WebElement getNav_AccountTab() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_AccountTab;
		}

		public WebElement getNav_EscalationListLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EscalationListLink;
		}

		public WebElement getNav_CriticalEscalationListTab() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CriticalEscalationListTab;
		}

		public WebElement getNav_AuthorizedContactListTab() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_AuthorizedContactListTab;
		}

		public WebElement getNav_RoleACriticalEscalationListTable() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_RoleACriticalEscalationListTable;
		}

		public WebElement getNav_RoleCECriticalEscalationListTable() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_RoleCECriticalEscalationListTable;
		}
		public WebElement getNav_ManageDriveTable() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_ManageDriveTable;
		}
		
		
		
		public WebElement getNav_RoleAAuthorizedContactListTable() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_RoleAAuthorizedContactListTable;
		}
       // This Element updated on 10/14/2015 by QAA03 for EXTJS5
		public WebElement getNav_AuthorizedContactListTableParent() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_AuthorizedContactListTableParent;
		}

		public WebElement getNav_CriticalEscalationListTable() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CriticalEscalationListTable;
		}

		public WebElement getNav_RoleCEAuthorizedContactListTable() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_RoleCEAuthorizedContactListTable;
		}

		/*public WebElement getNav_AddUserLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_AddUserLink;
		}*/

		public WebElement getNav_AddUserPopwindow() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_AddUserPopwindow;
		}

		/*public WebElement getNav_AddUserWindowFirstNameInput() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_AddUserWindowFirstNameInput;
		}*/

		/*public WebElement getNav_AddUserWindowLastNameInput() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_AddUserWindowLastNameInput;
		}

		public WebElement getNav_AddUserWindowemailAddressInput() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_AddUserWindowemailAddressInput;
		}

		public WebElement getNav_AddUserWindowphoneInput() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_AddUserWindowphoneInput;
		}

		public WebElement getNav_AddUserWindowcellInput() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_AddUserWindowcellInput;
		}
*/
		public WebElement getNav_AddUserWindowCancelButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_AddUserWindowCancelButton;
		}

		/*public WebElement getNav_AddUserWindowOkButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_AddUserWindowOkButton;
		}*/

		public WebElement getNav_AddUserSucessMessage() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_AddUserSucessMessage;
		}

		/*public WebElement getNav_AddUserSucessMessageOKButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_AddUserSucessMessageOKButton;
		}*/

		public WebElement getNav_DeleteUserConfirmMessage() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_DeleteUserConfirmMessage;
		}

		public WebElement getNav_DeleteUserWindowOkButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_DeleteUserWindowOkButton;
		}

		public WebElement getNav_EditUserWindowOkButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EditUserWindowOkButton;
		}

		public WebElement getNav_PopupWindow() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_PopupWindow;
		}

		public WebElement getNav_FeedBackArea() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_FeedBackArea;
		}

		public WebElement getNav_AddtoCriticalEscalationListLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_AddtoCriticalEscalationListLink;
		}

		public WebElement getNav_ServicesTab() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_ServicesTab;
		}

		public WebElement getNav_DRaaSLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_DRaaSLink;
		}

		public WebElement getNav_HostBasedReplicationText() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_HostBasedReplicationText;
		}

		public WebElement getNav_StorageArrayBasedReplicationText() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_StorageArrayBasedReplicationText;
		}

		public WebElement getNav_HostBasedReplicationAddDrive() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_HostBasedReplicationAddDrive;
		}

		public WebElement getNav_StorageArrayBasedReplicationAddDrive() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_StorageArrayBasedReplicationAddDrive;
		}
		
	
		public WebElement getNav_HostName() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_HostName;
		}

		public WebElement getNav_HostIpAddress() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_HostIpAddress;
		}

		public WebElement getNav_DrivesToAdd() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_DrivesToAdd;
		}

		public WebElement getNav_SaveDrive() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_SaveDrive;
		}
				
		public WebElement getNav_DeleteDriveMsg() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_DeleteDriveMsg;
		}
		
		public WebElement getNav_SourceStorageControllerIP() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_SourceStorageControllerIP;
		}
		
		public WebElement getNav_SourceVolumeName() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_SourceVolumeName;
		}
		
		public WebElement getNav_ManageDriveButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_ManageDriveButton;
		}
		
		public WebElement getNav_DeleteDrivePopup() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_DeleteDrivePopup;
		}
		
		public WebElement getNav_DeleteDrivePopupOKButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_DeleteDrivePopupOKButton;
		}
		
		public WebElement getNav_SourceStorageControllerName() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_SourceStorageControllerName;
		}
		
		public WebElement getNav_SupportTab() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_SupportTab;
		}

		public WebElement getNav_FormsLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_FormsLink;
		}

		public WebElement getNav_FormsUserInput() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_FormsUserInput;
		}

		public WebElement getNav_FormsPasswordInput() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_FormsPasswordInput;
		}

		public WebElement getNav_FormsSubmitButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_FormsSubmitButton;
		}

		public WebElement getNav_FormsHomePageText() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_FormsHomePageText;
		}

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
		//The below two Elements updated on 10/14/2015 for EXTJS5 by QAA03
		public WebElement getEM7_ToolBoxIcon() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return EM7_ToolBoxIcon;
		}


		public WebElement getEM7_Logoff() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return EM7_Logoff;
		}
		
		public WebElement getEM7_TopMenu() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return EM7_TopMenu;
		}

		


		public WebElement getEM7_SignOutLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return EM7_SignOutLink;
		}

		public WebElement getEM7_MonitoredID() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return EM7_MonitoredID;
		}

		public WebElement getEM7_CloseBtn() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return EM7_CloseBtn;
		}

		public WebElement getNav_CreateTicketPopupWindow() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CreateTicketPopupWindow;
		}

		public WebElement getNav_DetailTicketSystem() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_DetailTicketSystem;
		}


		public WebElement getNav_EVDCOrgSelectorDropDown() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EVDCOrgSelectorDropDown;
		}


		public WebElement getNav_ConfirmNewPopup() {
            FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
            return nav_ConfirmNewPopup;
           }

           public WebElement getNav_ConfirmNewPopupOKBtn() {
            FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
            return nav_ConfirmNewPopupOKBtn;
           }

           public WebElement getNav_ConfirmNewPopupCancelBtn() {
            FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
            return nav_ConfirmNewPopupCancelBtn;
           }

           
      //===================Element needed for other module test cases=========================     
         //This element updated on 10/02/2015 for EXTJS5 by QAA03 
       	//@FindBy(how=How.XPATH,using="//div[@id='messagebox-1001_header_hd']")
        @FindBy(how=How.XPATH,using="//div[@id='messagebox-1001']") 
    	private WebElement nav_InfoUnavailableText;
        
    	@FindBy(how=How.XPATH,using="//span[contains(@id,'btnInnerEl')][text()='OK']")
    	private WebElement nav_InfoUnavailableOKButton;
    	
    	
    	
    	@FindBy(how=How.XPATH,using="//span[text()='Select EVDC']")
    	private WebElement nav_SelectEVDCText;
    	
    	@FindBy(how=How.XPATH,using="//div[@id='gwt-debug-zoneGrid']")
    	private WebElement nav_ZonesTable;
    	
    	@FindBy(how=How.XPATH,using="//a[text()='services']")
    	private WebElement nav_ServicesLink;
    	
    	@FindBy(how=How.XPATH,using="//a[text()='DNS']")
    	private WebElement nav_DNSLink;


		public WebElement getNav_InfoUnavailableText() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_InfoUnavailableText;
		}


		public WebElement getNav_InfoUnavailableOKButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_InfoUnavailableOKButton;
		}


		


		public WebElement getNav_SelectEVDCText() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_SelectEVDCText;
		}


		public WebElement getNav_ZonesTable() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_ZonesTable;
		}


		public WebElement getNav_ServicesLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_ServicesLink;
		}


		public WebElement getNav_DNSLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_DNSLink;
		}


		public WebElement getNav_OrgSelectDropDown() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_OrgSelectDropDown;
		}
    	
		public WebElement getNav__ManageEntityTab() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_ManageEntityTab;
		}
		
		public WebElement getNav_EM_Edit_SaveBtn() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EM_Edit_SaveBtn;
		}


		public WebElement getNav_ManageEntityTab() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_ManageEntityTab;
		}


		public WebElement getNav_SummaryView() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_SummaryView;
		}


		public WebElement getNav_EM_Edit_CancelBtn() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EM_Edit_CancelBtn;
		}


		public WebElement getNav_entityColumnUnderPermissionsTab() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_entityColumnUnderPermissionsTab;
		}


		public WebElement getNav_parentsColumnUnderPermissionsTab() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_parentsColumnUnderPermissionsTab;
		}


		public WebElement getNav_ManageEntityNameHeader() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_ManageEntityNameHeader;
		}


		public WebElement getNav_ManageEntityCopyEdit() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_ManageEntityCopyEdit;
		}

/*
		public WebElement getNav_UserTab() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_UserTab;
		}
*/

		public WebElement getNav_EM_Edit_ReCancelBtn() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EM_Edit_ReCancelBtn;
		}


		public WebElement getNav_PermissionUserAddUserLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_PermissionUserAddUserLink;
		}




		public WebElement getNav_EditRole_ParentWebTable() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EditRole_ParentWebTable;
		}


		public WebElement getNav_EM_Edit_CloseImage() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EM_Edit_CloseImage;
		}


		public WebElement getNav_11GiraffesLinkUnderOrg() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_11GiraffesLinkUnderOrg;
		}


		public WebElement getNav_AddUserLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_AddUserLink;
		}


		public WebElement getNav_RramUserTitle() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_RramUserTitle;
		}


		public WebElement getNav_RoleTitleForRramUser() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_RoleTitleForRramUser;
		}


		public WebElement getNav_SelectOrgEditBox() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_SelectOrgEditBox;
		}


		public WebElement getNav_RramdevUserTitle() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_RramdevUserTitle;
		}


		public WebElement getNav_RoleTitleForRramdevUser() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_RoleTitleForRramdevUser;
		}


		public WebElement getNav_TstDevcoTitle() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_TstDevcoTitle;
		}

		public WebElement getNav_Users_Table() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_Users_Table;
		}

		public WebElement getNav_Users_EntityColumn() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_Users_EntityColumn;
		}


		public WebElement getNav_UserRoleDropDownArrow() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_UserRoleDropDownArrow;
		}
	


		
		
}

	


