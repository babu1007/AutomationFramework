package com.whs.navigator.pagefactory.dev.old;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class UserPermissionMultiOrgPageFactory {

////#########################################################Vivek start############################################
	//=====================MULTIORG======================================================
	
	@FindBy(how=How.LINK_TEXT,using="Documents")
	private WebElement nav_DocumentsMenuLink;
	
	@FindBy(how=How.LINK_TEXT,using="Announcements")
	private WebElement nav_AnnouncementsMenuLink;
	
	@FindBy(how=How.XPATH,using="//div[text()='Show Calendar']")
	private WebElement nav_ShowCalenderBtn;
	
	@FindBy(how=How.XPATH,using="//div[text()='New Announcement']")
	private WebElement nav_NewAnnouncementBtn;
	
	@FindBy(how=How.XPATH,using="//table[@class='marketing_table_api']")
	private WebElement nav_CloudAPIImage;
	
	@FindBy(how=How.LINK_TEXT,using="Cloud API")
	private WebElement nav_CloudAPIMenuLink;
	
	@FindBy(how=How.XPATH,using="//span[text()='Hosted Solutions Navigator Users Guide - R1.pdf']")
	private WebElement nav_DocumentLink;
	
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'security')]")
	private WebElement nav_SecurityTab;
	
	
	
	@FindBy(how=How.LINK_TEXT,using="Cloud AV")
	private WebElement nav_CloudAVMenuLink;
	
	@FindBy(how=How.XPATH,using="//table[@class='marketing_table_av']")
	private WebElement nav_CloudAVImage;
	
	@FindBy(how=How.LINK_TEXT,using="DDoS Mitigation")
	private WebElement nav_DDoSMitigationMenuLink;
	
	
	@FindBy(how=How.XPATH,using="//table[@class='marketing_table_ddos']")
	private WebElement nav_DDosMitigationImage;
		
////#########################################################Vivek end##############################################
	@FindBy(how=How.ID, using="p_p_id_UserManagement_WAR_usermanagementportlet_")
	private WebElement nav_UserManagementUnAvaiableErrorMsg;

	@FindBy(how=How.XPATH,  using="//section[@id='tickets']/div/h2/a[text()='tickets']")
	private WebElement nav_TicketPortalLink;
	
	//Reports-Permission objects
		@FindBy(how=How.XPATH, using="//*[contains(text(),'monitoring')]")
		private WebElement nav_MonitoringTab;
		
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
		
		@FindBy(how=How.XPATH, using="//*[contains(text(),'Critical Escalation List')]")
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
		
		
		@FindBy(how=How.XPATH,  using="//span[contains(text(),'Authorized Contact List')]/../../../../../../../..//div[@id='idACLGridPanel-body']//table[contains(@id,'gridview-')]")
		//@FindBy(how=How.XPATH,  using="//table[contains(@id,'gridview-1026-table')]")
		private WebElement nav_AuthorizedContactListTable;
		
		// This element updated on 10/06/2015 by QAA03 for EXTJS5
		//@FindBy(how=How.XPATH,  using="//span[contains(text(),'Critical Escalation List')]/../../../../../../../..//div[@id='idCELGridPanel-body']//table[contains(@id,'gridview-')]")
		//@FindBy(how=How.XPATH,  using="//table[contains(@id,'gridview-1016-table')]")
		@FindBy(how=How.XPATH,  using="//div[@id='idCELGridPanel-body']")
		private WebElement nav_CriticalEscalationListTable;
				
		@FindBy(how=How.XPATH,  using="//table[contains(@id,'gridview-1025-table')]")
		private WebElement nav_RoleCEAuthorizedContactListTable;
		
		//This element updated on 09/22/2015 by QAA03
		//@FindBy(how=How.ID,  using="idACLAddUserBtn")
		@FindBy(how=How.ID,  using="idBtnMUAddUser-btnInnerEl")
		private WebElement nav_AddUserLink;
		
		//This element updated on 09/22/2015 by QAA03
		//@FindBy(how=How.ID,  using="idACLaddUserWindow")
		@FindBy(how=How.ID, using="idAddUserPanel-innerCt")
		private WebElement nav_AddUserPopwindow;
		
		@FindBy(how=How.XPATH, using="//*[contains(@name,'firstName')]")
		private WebElement nav_AddUserWindowFirstNameInput;
		
		@FindBy(how=How.XPATH, using="//*[contains(@name,'lastName')]")
		private WebElement nav_AddUserWindowLastNameInput;
		
		@FindBy(how=How.XPATH, using="//*[contains(@name,'emailAddress')]")
		private WebElement nav_AddUserWindowemailAddressInput;
		
		@FindBy(how=How.XPATH, using="//*[contains(@name,'phone')]")
		private WebElement nav_AddUserWindowphoneInput;
		
		@FindBy(how=How.XPATH, using="//*[contains(@name,'cell')]")
		private WebElement nav_AddUserWindowcellInput;
		
		@FindBy(how=How.XPATH, using="//*[contains(text(),'Cancel')]")
		private WebElement nav_AddUserWindowCancelButton;
		
		@FindBy(how=How.XPATH, using="//*[contains(text(),'OK')]")
		private WebElement nav_AddUserWindowOkButton;
		
		@FindBy(how=How.XPATH, using="//div[contains(text(),'Successfully created a ticket with TicketId')]")
		private WebElement nav_AddUserSucessMessage;
		
		@FindBy(how=How.ID, using="button-1005-btnIconEl")
		private WebElement nav_AddUserSucessMessageOKButton;
		
		@FindBy(how=How.XPATH, using="//div[contains(text(),'Are you sure you want to remove Test Test from the Critical Escalation List?')]")
		private WebElement nav_DeleteUserConfirmMessage;
		
		@FindBy(how=How.ID, using="button-1005-btnIconEl")
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
		
		@FindBy(how=How.XPATH,using="//a[contains(text(),'Detailed Ticketing System')]")
		private WebElement nav_DetailTicketSystem;
		
		
		
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
		
		
		//@FindBy(how=How.XPATH,using="//input[@id='sourceIp-inputId']/../../td[contains(@id,'ext-gen')]")
		@FindBy(how=How.XPATH,using="//input[@id='sourceIp-inputId']/../../td[contains(@id,'ext-gen')]/div[contains(@id,'ext-gen')]")
		private WebElement nav_SourceDropDownIcon;
		
		@FindBy(how=How.XPATH,using="//input[@id='destinationIp-inputId']/../../td[contains(@id,'ext-gen')]/div[contains(@id,'ext-gen')]")
		private WebElement nav_DestinationDownIcon;
		
		@FindBy(how=How.XPATH,using="//input[@id='protocolId-inputId']/../../td[contains(@id,'ext-gen')]/div[contains(@id,'ext-gen')]")
		private WebElement nav_ProtocolDownIcon;
		
		@FindBy(how=How.XPATH,using="//div[5]/div/ul[@class='x-list-plain']")
		private WebElement nav_SourceList;
		
		@FindBy(how=How.XPATH,using="//div[6]/div/ul[@class='x-list-plain']")
		private WebElement nav_DestinationList;
		
		@FindBy(how=How.XPATH,using="//div[7]/div/ul[@class='x-list-plain']")
		private WebElement nav_ProtocolList;
		

		
		
@FindBy(how=How.XPATH,using="//section//table//tr[1]/td/table//span[contains(@id,'fwEdit-moveButton-fwRuID')]/a[contains(text(),'Move')]")
private WebElement nav_MoveLink;

@FindBy(how=How.XPATH,using="//section//table//tr[1]/td/table//span[contains(@id,'fwEdit-editButton-fwRuID')]/a[contains(text(),'Edit')]")
private WebElement nav_EditLink;

@FindBy(how=How.XPATH,using="//section//table//tr[1]/td/table//span[contains(@id,'fwEdit-deleteButton-fwRuID')]/a[contains(text(),'Delete')]")
private WebElement nav_DeleteLink;

@FindBy(how=How.XPATH,using="//section//table//tr[1]/td/table//span[contains(@id,'fwEdit-cancelButton-fwRuID')]/a[contains(text(),'Cancel')]")
private WebElement nav_CancelLink;

@FindBy(how=How.XPATH,using="//section//table//tr[1]/td/table//span[contains(@id,'fwEdit-saveButton-fwRuID')]/a[contains(text(),'Save Edits')]")
private WebElement nav_SaveEditsLink;

//Virtual Machine
	@FindBy(how=How.LINK_TEXT,using="Virtual Machines")
	private WebElement nav_EVDCOverviewVirtualMachine;
	
	@FindBy(how=How.XPATH,using=".//*[@id='gridview-1010-body']")
	private WebElement nav_VMWebTable;
	
	@FindBy(how=How.LINK_TEXT,using="Disable Monitoring")
	private WebElement nav_EVDCDisableMonitoring;
	//EVDC Selector dropdown
	
		@FindBy(how=How.XPATH,using="//div[@class='select_evdc']/nobr/ul/li[@class='evdc_options']/a")
		private WebElement nav_EVDCOrgSelector;
		
	@FindBy(how=How.LINK_TEXT,using="Disable Monitoring")
	private WebElement nav_EVDCEnableMonitoring;
	
	@FindBy(how=How.XPATH,using="//li[@class='evdc_options']/ul")
	private WebElement nav_EVDCOrgSelectorDropDown;
	
	@FindBy(how=How.ID, using="navpopupbody")
	 private WebElement nav_ConfirmNewPopup;
	 
	 @FindBy(how=How.XPATH, using="//div[@id='navpopupbuttons']/span/a[contains(text(),'Ok')]")
	 private WebElement nav_ConfirmNewPopupOKBtn;
	 
	 @FindBy(how=How.XPATH, using="//div[@id='navpopupbuttons']/span/a[contains(text(),'Cancel')]")
	 private WebElement nav_ConfirmNewPopupCancelBtn;
	 
	 @FindBy(how=How.XPATH, using="//div[@id='monitoringEnablePopup']")
	 private WebElement nav_DisableMonitorPopup;
	
	 @FindBy(how=How.XPATH, using="//section/div[@id='monitoringEnablePopup']/span[@id='monitorVmBtn']/a[text()='OK']")
	 private WebElement nav_DisableMonitorPopupOKButton;
	 
	//MULTI ORGANIZATION####################
	 
	 
		
		//Use This Org Button
		@FindBy(how=How.XPATH,using="//input[@value='Use this Organization']")
		private WebElement nav_UseThisOrgButton;
		
		//OrgSelector Tab on landing page
		@FindBy(how=How.XPATH, using="*//a[text()='OrgSelector']")
		private WebElement nav_MultiOrgSelector;
		
		//Header Text
		@FindBy(how=How.XPATH, using="*//h1[text()='Please Select your Organization for this Session']")
		private WebElement nav_MultiOrgHeaderText;
		
		//Org ID dropdown
		@FindBy(how=How.XPATH, using="*//select[@name='orgId']")
		private WebElement nav_MultiOrgIdDropdown;
		
		//Hosted dropdown value
		@FindBy(how=How.XPATH, using="//select/option[text()='.Hosted Solutions']")
		private WebElement nav_MultiOrgHostedSolDropdown;
		
		//11Giraffes dropdown value
		@FindBy(how=How.XPATH, using="//select/option[text()='11Giraffes']")
		private WebElement nav_MultiOrg11GiraffesDropdown;
		
		//TST Devco1 dropdown value
		@FindBy(how=How.XPATH, using="//select/option[text()='TST Devco1']")
		private WebElement nav_MultiOrgTSTDevco1Dropdown;
		
		//Hosted Solutions title on landing page  after selection
		@FindBy(how=How.XPATH, using="*//a[text()='.Hosted Solutions']")
		private WebElement nav_MultiOrgHostedSolTitle;
		
		//11Giraffes title on landing page after selection
		@FindBy(how=How.XPATH, using="*//a[text()='11Giraffes']")
		private WebElement nav_MultiOrg11GiraffesTitle;
		
		//Tickets Link on Home Page
		@FindBy(how=How.XPATH, using="//h2/a[text()='tickets']")
		private WebElement nav_MultiOrgTicketslinkHome;
		
		//TST Devco1 title on landing page after selection
		@FindBy(how=How.XPATH, using="*//a[text()='TST Devco1']")
		private WebElement nav_MultiOrgTSTDevco1Title;
		
		
		
		//Draas tab link
		@FindBy(how=How.XPATH, using="//a[text()='DRaaS']")
		private WebElement nav_MultiOrgDraasBreadCrumbLink;
		
		//Homepage Ticket numbers
		@FindBy(how=How.ID, using="number_outstand_tix")
		private WebElement nav_MultiOrgHomeTicketNum;
		
		//Orgname from Webtable
		@FindBy(how=How.XPATH, using="//td/div[@style='width:20%']/dl/dd[text()='11Giraffes']")
		private WebElement nav_MultiOrgnameWebTable;
		
		
		@FindBy(how=How.XPATH,using="*//section//div/h1")
		private WebElement nav_MultOrgPageText;

	    @FindBy(how=How.XPATH,using="*//span/a[text()='Home']")
	    private WebElement nav_HomeBreadCrumbLink;

	    @FindBy(how=How.XPATH,using="*//li[@id='organization']/a")
	    private WebElement nav_OrganizationnameLink;
	    
	    //Home page "BandWidth" link
	    @FindBy(how=How.XPATH, using="*//h2/a[text()='bandwidth']")
	    private WebElement nav_Bandwidthlink;
	    
	    //No of devices monitored
	    @FindBy(how=How.ID, using="devices_monitored")
	    private WebElement nav_HomeDevicesAlerts;
	    
	    //Critical Alerts
	    @FindBy(how=How.ID, using="number_critical_alerts")
	    private WebElement nav_HomeCriticalAlerts;
	    
	    //Minor Alerts
	    @FindBy(how=How.ID, using="number_minor_alerts")
	    private WebElement nav_HomeMinorAlerts;
	    
	    //Major Alerts
	    @FindBy(how=How.ID, using="number_major_alerts")
	    private WebElement nav_HomeMajorAlerts;
	    
	    //Notice Alerts
	    @FindBy(how=How.ID, using="number_notice_alerts")
	    private WebElement nav_HomeNoticeAlerts;
	    
	    //Resolved Tickets
	    @FindBy(how=How.ID, using="number_resolved_tix")
	    private WebElement nav_HomeResolvedTickets;
	    
	    //OutStanding Tickets
	    @FindBy(how=How.ID, using="number_outstand_tix")
	    private WebElement nav_HomeOutstandingTickets;
	    
	    //Draas Numerator Assets
	    @FindBy(how=How.ID, using="s2cr_numerator_assets")
	    private WebElement nav_HomeDraasNumerator;
	    
	    //Draas Denominator Assets
	    @FindBy(how=How.ID, using="s2cr_denominator_assets")
	    private WebElement nav_HomeDraasDenominator;
	    
	    //Bandwidth 
	    @FindBy(how=How.ID, using="Bandwidth_number")
	    private WebElement nav_HomeBandwidth;
	    
	    //AndOver 11Giraffes title
	    @FindBy(how=How.XPATH, using="*//h2[@id='edvc_1']/a[text()='Andover, MA - 11giraffes']")
	    private WebElement nav_HomeAndover11Giraffes;
	    
	    //Private Cloud 11giraffes title
	    @FindBy(how=How.XPATH, using="*//a[text()='Private Cloud - 11Giraffes']")
	    private WebElement nav_HomePrivateCloud11Giraffes;
	    
	   //AndOver TstDevco title
	    @FindBy(how=How.XPATH, using="*//h2[@id='edvc_1']/a[text()='Andover, MA - tstdevco1']")
	    private WebElement nav_HomeAndoverTstDevco;
	    

	@FindBy(how=How.XPATH,using="//a[text()='Virtual Machines']")
	private WebElement nav_VMLink;
	@FindBy(how=How.XPATH,using="//a[text()='Add Virtual Machine']")
	private WebElement nav_AddVMLink;
	@FindBy(how=How.XPATH,using="//*[@class='evdc_options']/a")
	private WebElement nav_EVDCSelectorList;		
	@FindBy(how=How.XPATH,using="//*[@class='evdc_options']/ul")
	private WebElement nav_EVDCSelectordropdown;
	@FindBy(how=How.LINK_TEXT,using="Catalogs")
	private WebElement nav_CatalogPortletLink;
	@FindBy(how=How.LINK_TEXT,using="Windstream Objects")
	private WebElement nav_CatalogWindStreamLink;
	@FindBy(how=How.XPATH,using="//div[@id='messagebox-1001_header_hd']")
	private WebElement nav_InfoUnavailableText;
	@FindBy(how=How.XPATH,using="//span[contains(@id,'btnInnerEl')][text()='OK']")
	private WebElement nav_InfoUnavailableOKButton;
	@FindBy(how=How.XPATH,using="//ul[@id='val_vm']/li[@id='cat_rules']")
	private WebElement nav_RulesCountText;
	@FindBy(how=How.XPATH,using="//span[text()='Select EVDC']")
	private WebElement nav_SelectEVDCText;
	
	@FindBy(how=How.XPATH,using="//div[@id='gwt-debug-zoneGrid']")
	private WebElement nav_ZonesTable;
	@FindBy(how=How.XPATH,using="//a[text()='services']")
	private WebElement nav_ServicesLink;
	@FindBy(how=How.XPATH,using="//a[text()='DNS']")
	private WebElement nav_DNSLink;
	
	//This Element updated on 10/07/2015 by QAA03 for EXTJS5
	//@FindBy(how=How.XPATH,using="//div[@id='wsCtlgs-body']/div/table[contains(@id,'gridview-')]")
	@FindBy(how=How.XPATH,using="//div[@id='wsCtlgs-body']")
	private WebElement nav_CatalogWsWebTable;

	//____________________________ From Gideon PageFactory __________________________________//
	
	@FindBy(how=How.XPATH,using="//li[@id='user']")
	private WebElement nav_MOrg_User;
	
	@FindBy(how=How.NAME,using="orgId")
	private WebElement nav_MOrg_SelectOrg;
	
	@FindBy(how=How.XPATH, using="//input[@type='submit']")
	private WebElement nav_MOrg_UsethisOrgButton;

	//Updated by QAA03 on 05/18/2016
	//@FindBy(how=How.XPATH,using="//li[@id='organization']/a")
	//@FindBy(how=How.ID,using="idMultiMenuOrgs")
	@FindBy(how=How.XPATH,using="//li[@id='organizations']/a")
	private WebElement nav_MOrg_OrgName;
	
	// this object is added by QAA04 -- > 12/17/15
	@FindBy(how=How.XPATH, using="//div[@id='top_left']//img[@alt='TierPoint logo']")
	//@FindBy(how=How.XPATH, using="//img[@alt='windstream logo']")
	private WebElement nav_WindStremIcon;

	@FindBy(how=How.XPATH, using="//section[@id='draas']/div[2]")
	private WebElement nav_MOrg_DraasData;
	
	@FindBy(how=How.XPATH,using="//select[@name='orgId']")
	private WebElement nav_MultiOrgDropDown;
	
	@FindBy(how=How.XPATH,using="//input[@value='Use this Organization']")
	private WebElement nav_UseThisOgrBtn;
	
	@FindBy(how=How.XPATH,using="//li[@id='organization']/a")
	private WebElement nav_OrganizationName;
	
	@FindBy(how=How.XPATH, using="//section[@id='portlet_OrgSelector_WAR_orgselectorhookportlet']//select[@name='orgId']")
	private WebElement nav_orgDropDown;
	
	@FindBy(how=How.XPATH, using="//section[@id='portlet_OrgSelector_WAR_orgselectorhookportlet']//input[@value='Use this Organization']")
	private WebElement nav_UseOrgButton;
	
	@FindBy(how=How.XPATH, using="//section[@id='firewall']//ul[@id='chart_vm']")
	private WebElement nav_FirewallPortlet;
	
	@FindBy(how=How.ID, using="firewallRulesTab")
	private WebElement nav_FirewallRulesTab;
	
	
	
	//////////////////////////////////// taken form clarkPageFactory
	
	@FindBy(how=How.ID, using = "idFooterButton")
	private WebElement nav_Users_EntityBrowserLink;
	
	@FindBy(how=How.ID, using = "1stGrid")
	private WebElement Nav_Users_EB_FLCOrgTable;
	
	@FindBy(how=How.ID, using = "idEBtopSliderText")
	private WebElement nav_Users_EntityBrowserTab;
	
	@FindBy(how=How.ID, using = "idEBCloseButton")
	private WebElement nav_Users_EB_CloseTab;
	
	@FindBy(how=How.ID, using = "idFooterButton")
	private WebElement nav_EntityBrowserLink;
	
	///////////////////////// taken from byronPageFactory
	@FindBy(how=How.ID,using="idEBtopSliderText")
	private WebElement nav_EBPanelTitle;
	
	@FindBy(how=How.ID,using="idEBCloseButton")
	private WebElement nav_EBPanelCloseBtn;
	
	
	
	
	////////////////////////////Added By Sukur. Dated On 11/12/2015///////////
	
	@FindBy(how=How.XPATH,using="//span[text()='Manage Entities']")
	private WebElement nav_PermissionManageEntityLink;
	
	//Below are taken from QAA04 Page Factory
	@FindBy(how=How.XPATH, using = " //div[@id='userListPanel-body']//tr[1]//td[5]/div")
	private WebElement nav_OrgTitleInEntityColumn;

	@FindBy(how=How.XPATH, using="//li[@id='organization']/a")
	private WebElement nav_Orglink;
	
	@FindBy(how=How.XPATH, using="//ul[@id='idMultiMenuOrgs']//a[text()='11Giraffes']")
	private WebElement nav_11GiraffesLinkUnderOrg;
	
	
	
	
	
	//##############################################################################################
	
	
	
	
	public WebElement getNav_EVDCOrgSelector() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCOrgSelector;
	}
	public WebElement getNav_EVDCOrgSelectorDropDown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCOrgSelectorDropDown;
	}
	public WebElement getNav_EVDCDisableMonitoring() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCDisableMonitoring;
	}
	
	public WebElement getNav_EVDCEnableMonitoring() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCEnableMonitoring;
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
		
		@FindBy(how=How.XPATH,using="//span[contains(text(),'Create Ticket')]")
		private WebElement nav_CreateTicketLink;
		
		public WebElement getNav_UserManagementUnAvaiableErrorMsg() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_UserManagementUnAvaiableErrorMsg;
		}



		public WebElement getNav_MonitoringTab() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_MonitoringTab;
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

		public WebElement getNav_AuthorizedContactListTable() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_AuthorizedContactListTable;
		}

		public WebElement getNav_CriticalEscalationListTable() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CriticalEscalationListTable;
		}

		public WebElement getNav_RoleCEAuthorizedContactListTable() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_RoleCEAuthorizedContactListTable;
		}

		public WebElement getNav_AddUserLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_AddUserLink;
		}

		public WebElement getNav_AddUserPopwindow() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_AddUserPopwindow;
		}

		public WebElement getNav_AddUserWindowFirstNameInput() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_AddUserWindowFirstNameInput;
		}

		public WebElement getNav_AddUserWindowLastNameInput() {
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

		public WebElement getNav_AddUserWindowCancelButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_AddUserWindowCancelButton;
		}

		public WebElement getNav_AddUserWindowOkButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_AddUserWindowOkButton;
		}

		public WebElement getNav_AddUserSucessMessage() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_AddUserSucessMessage;
		}

		public WebElement getNav_AddUserSucessMessageOKButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_AddUserSucessMessageOKButton;
		}

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

		public WebElement getNav_CreateTicketLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CreateTicketLink;
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
			 public WebElement getNav_DisableMonitorPopup() {
				  FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				  return nav_DisableMonitorPopup;
				 }
			 public WebElement getNav_DisableMonitorPopupOKButton() {
				  FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				  return nav_DisableMonitorPopupOKButton;
				 }
		//######################MULTI ORG


		public WebElement getNav_VMLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_VMLink;
		}
		public WebElement getNav_AddVMLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_AddVMLink;
		}
		public WebElement getNav_EVDCSelectorList() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EVDCSelectorList;
		}
		public WebElement getNav_EVDCSelectordropdown() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EVDCSelectordropdown;
		}
		public WebElement getNav_CatalogPortletLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CatalogPortletLink;
		}
		public WebElement getNav_CatalogWindStreamLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CatalogWindStreamLink;
		}
		public WebElement getNav_InfoUnavailableText() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_InfoUnavailableText;
		}
		public WebElement getNav_InfoUnavailableOKButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_InfoUnavailableOKButton;
		}
		public WebElement getNav_RulesCountText() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_RulesCountText;
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
		public WebElement getNav_CloudAPIMenuLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CloudAPIMenuLink;
		}
		public WebElement getNav_DocumentLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_DocumentLink;
		}
		public WebElement getNav_SecurityTab() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_SecurityTab;
		}
		public WebElement getNav_CloudAVMenuLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CloudAVMenuLink;
		}
		public WebElement getNav_CloudAVImage() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CloudAVImage;
		}
		public WebElement getNav_DDoSMitigationMenuLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_DDoSMitigationMenuLink;
		}
		public WebElement getNav_DDosMitigationImage() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_DDosMitigationImage;
		}
		public WebElement getNav_DocumentsMenuLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_DocumentsMenuLink;
		}
		public WebElement getNav_AnnouncementsMenuLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_AnnouncementsMenuLink;
		}
		public WebElement getNav_ShowCalenderBtn() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_ShowCalenderBtn;
		}
		public WebElement getNav_NewAnnouncementBtn() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_NewAnnouncementBtn;
		}
		public WebElement getNav_CloudAPIImage() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CloudAPIImage;
		}
		public WebElement getNav_UseThisOrgButton(){
			   FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			   return nav_UseThisOrgButton;
		}
		
		public WebElement getNav_MultiOrgSelector(){
		    FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_MultiOrgSelector;
		}
		
		public WebElement getNav_MultiOrgHeaderText(){
		    FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_MultiOrgHeaderText;
		}
		
		public WebElement getNav_MultiOrgIdDropdown(){
		    FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_MultiOrgIdDropdown;
		}
		
		public WebElement getNav_MultiOrgHostedSolTitle(){
		    FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_MultiOrgHostedSolTitle;
		}
		
		public WebElement getNav_MultiOrg11GiraffesTitle(){
		    FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_MultiOrg11GiraffesTitle;		
		}
		
		public WebElement getNav_MultiOrgTSTDevco1Title(){
		    FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_MultiOrgTSTDevco1Title;	
		}
		
		public WebElement getNav_TicketPortalLink(){
	 	   FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			   return nav_TicketPortalLink;
	   }
		
		 public WebElement getNav_MultOrgPageText(){
	     FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	     return nav_MultOrgPageText;
	   }

	     public WebElement getNav_HomeBreadCrumbLink(){
	     FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	     return nav_HomeBreadCrumbLink;
	   }

	     public WebElement getNav_OrganizationnameLink(){
	     FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	     return nav_OrganizationnameLink;
	   }
	     
	     public WebElement getNav_MultiOrgTicketslinkHome(){
	    	 FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	         return nav_MultiOrgTicketslinkHome;
	   }
	    
	     public WebElement getNav_MultiOrgDraasBreadCrumbLink(){
	    	 FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	         return nav_MultiOrgDraasBreadCrumbLink;
	     }
	     public WebElement getNav_MultiOrgHomeTicketNum(){
	    	 FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	         return nav_MultiOrgHomeTicketNum;
	     }
	     public WebElement getNav_MultiOrgnameWebTable(){
	    	 FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	         return nav_MultiOrgnameWebTable;
	     }
	     public WebElement getNav_Bandwidthlink(){
	    	 FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	         return nav_Bandwidthlink;
	     }
	     public WebElement getNav_HomeDevicesAlerts(){
	    	 FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	         return nav_HomeDevicesAlerts;	 
	     }
	     public WebElement getNav_HomeCriticalAlerts(){
	    	 FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	         return nav_HomeCriticalAlerts;
	     }
	     public WebElement getNav_HomeMinorAlerts(){
	    	 FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	         return nav_HomeMinorAlerts;
	      }
	     public WebElement getNav_HomeMajorAlerts(){
	    	 FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	         return nav_HomeMajorAlerts;
	      }
	     public WebElement getNav_HomeNoticeAlerts(){
	    	 FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	         return nav_HomeNoticeAlerts;
	     }
	     public WebElement getNav_HomeResolvedTickets(){
	    	 FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	         return nav_HomeResolvedTickets;
	     }
	     public WebElement getNav_HomeOutstandingTickets(){
	    	 FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	         return nav_HomeOutstandingTickets;
	     }
	     public WebElement getNav_HomeDraasNumerator(){
	    	 FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	         return nav_HomeDraasNumerator;	 
	     }
	     public WebElement getNav_HomeDraasDenominator(){
	    	 FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	         return nav_HomeDraasDenominator;
	     }
	     public WebElement getNav_HomeBandwidth(){
	    	 FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	         return nav_HomeBandwidth;
	        }
	     public WebElement getNav_HomeAndover11Giraffes(){
	    	 FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	         return nav_HomeAndover11Giraffes;
	     }
	     public WebElement getNav_HomePrivateCloud11Giraffes(){
	    	 FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	         return nav_HomePrivateCloud11Giraffes;
	     }
	     public WebElement getNav_HomeAndoverTstDevco(){
	    	 FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	         return nav_HomeAndoverTstDevco;
	     }
		public WebElement getNav_CatalogWsWebTable() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CatalogWsWebTable;
		}
		public WebElement getNav_MultiOrgHostedSolDropdown() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_MultiOrgHostedSolDropdown;
		}
		public WebElement getNav_MultiOrg11GiraffesDropdown() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_MultiOrg11GiraffesDropdown;
		}
		public WebElement getNav_MultiOrgTSTDevco1Dropdown() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_MultiOrgTSTDevco1Dropdown;
		}
		public WebElement getNav_MOrg_User() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_MOrg_User;
		}
		public WebElement getNav_MOrg_SelectOrg() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_MOrg_SelectOrg;
		}
		public WebElement getNav_MOrg_UsethisOrgButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_MOrg_UsethisOrgButton;
		}
		public WebElement getNav_MOrg_OrgName() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_MOrg_OrgName;
		}
		public WebElement getNav_WindStremIcon() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_WindStremIcon;
		}
		public WebElement getNav_MOrg_DraasData() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_MOrg_DraasData;
		}
		public WebElement getNav_Users_EntityBrowserLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_Users_EntityBrowserLink;
		}
		public WebElement getNav_Users_EB_FLCOrgTable() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return Nav_Users_EB_FLCOrgTable;
		}
		public WebElement getNav_Users_EntityBrowserTab() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_Users_EntityBrowserTab;
		}
		public WebElement getNav_Users_EB_CloseTab() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_Users_EB_CloseTab;
		}
		public WebElement getNav_MultiOrgDropDown() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_MultiOrgDropDown;
		}
		public WebElement getNav_UseThisOgrBtn() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_UseThisOgrBtn;
		}
		public WebElement getNav_OrganizationName() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_OrganizationName;
		}
		public WebElement getNav_EBPanelTitle() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EBPanelTitle;
		}
		public WebElement getNav_EntityBrowserLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EntityBrowserLink;
		}
		public WebElement getNav_EBPanelCloseBtn() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EBPanelCloseBtn;
		}
		public WebElement getNav_orgDropDown() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_orgDropDown;
		}
		public WebElement getNav_UseOrgButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_UseOrgButton;
		}
		public WebElement getNav_FirewallPortlet() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_FirewallPortlet;
		}
		public WebElement getNav_FirewallRulesTab() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_FirewallRulesTab;
		}

		
////////////////////////////Added By Sukur. Dated On 11/12/2015///////////
		
		public WebElement getNav_PermissionManageEntityLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_PermissionManageEntityLink;
		}
		
		

		public WebElement getNav_Orglink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_Orglink;
		}

		public WebElement getNav_11GiraffesLinkUnderOrg() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_11GiraffesLinkUnderOrg;
		}

		public WebElement getNav_OrgTitleInEntityColumn() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_OrgTitleInEntityColumn;
		}

		
}
