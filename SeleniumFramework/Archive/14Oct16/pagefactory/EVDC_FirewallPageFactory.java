package com.whs.navigator.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class EVDC_FirewallPageFactory {
	
//// -------------------- QAA04 ---------------------------------------- ///////

///// Taken from clark test cases
	
	//Add NATS Link
		@FindBy(how=How.XPATH,using="//a[text()='Add NATs']")
		private WebElement nav_AddNATSLink;
		
	@FindBy(how=How.XPATH,using="//span[text()='Source Interface']")
	private WebElement nav_SourceInterFaceColumn;
	
	@FindBy(how=How.XPATH,using="//span[text()='Inside IP']")
	private WebElement nav_SourceInsideIPColumn;
	
	@FindBy(how=How.XPATH,using="//span[text()='Destination Interface']")
	private WebElement nav_DestinationInterfaceColumn;
	
	@FindBy(how=How.XPATH,using="//span[text()='External IP (NAT)']")
	private WebElement nav_ExternalIPColumn;
	
	@FindBy(how=How.XPATH,using="//span[text()='Host Name'] ")
	private WebElement nav_HostNameColumn;
	
//	Interface table in Fire wall page
  
	@FindBy(how=How.XPATH,using="//table[contains(@class,'vm_table_construction')]")
	private WebElement nav_FirewallTable;
	
	//NATS Link
	//@FindBy(how=How.XPATH,using="//a[text()='NATs']")
	@FindBy(how=How.ID,using="natTab")
	private WebElement nav_NATSLink;

	//Edit NATS Rule Link
		@FindBy(how=How.ID,using="createTicketTitle-inputEl")
		private WebElement nav_EditNatTitleInput;
		
		 @FindBy(how=How.XPATH,using="//iframe[@class='x-htmleditor-iframe']")
		 private WebElement nav_EditNATSNotesFrame;
		 
		//Edit NATS OK button
		@FindBy(how=How.XPATH,using="//span[text()='OK']")
		private WebElement nav_EditNatOkButton;
		
		//Edit NATS Cancel button
		//Updated by QAA03 on 07/18/2016
		//@FindBy(how=How.XPATH,using="//span[text()='Cancel']")
		@FindBy(how=How.ID,using="cancelAddNat")
		private WebElement nav_EditNatCancelButton;
		
		//Confirmation Pop up
		@FindBy(how=How.ID, using="messagebox-1001")
		private WebElement nav_ConfirmPopup;
		
		//Confirmation Pop up window OK button
		//This object is updated on 10/07/15 by QAA04 
		@FindBy(how=How.XPATH, using="//span[text()='OK']")
		//@FindBy(how=How.ID, using="button-1005-btnIconEl")
		private WebElement nav_ConfirmPopupOkBtn;
		
		 @FindBy(how=How.XPATH, using = "//input[contains(@id,'dv_severity_combo-')]")
		  private WebElement nav_NotesSeverity;
		    
		 @FindBy(how=How.XPATH, using = "//input[contains(@id,'dv_priority_combo-')]")
		  private WebElement nav_NotesPriority;
		    
		  @FindBy(how=How.XPATH, using = "//input[contains(@id,'dv_status_combo-')]")
		   private WebElement nav_NotesStatus;
	
		//Search By Dropdown arrow
			@FindBy(how=How.ID,using="idSearchByCombo-inputEl")
			private WebElement nav_SearchByDropDownArrow;
			
			//Search By dropdown
			@FindBy(how=How.XPATH,using="//div[contains(@id,'boundlist-')][contains(@class,'x-boundlist-list-ct x-unselectable')]/ul[contains(@class,'x-list-plain')]")
			private WebElement nav_SearchByDropdown; 
			
			
			//Search Edit field
			@FindBy(how=How.ID,using="idSearchTextField-inputEl")
			private WebElement nav_SearchEdit;
			
			//Search Image/button
			//This object is upddated on 10/07/2015 by QAA04
			@FindBy(how=How.XPATH,using="*//img[@src='/ticketing-portlet/resources/images/Search_Icon2.png']")
			//@FindBy(how=How.XPATH,using="//table[@id='idSearchTextField']/../img[contains(@id,'component-')]")
			private WebElement nav_SearchByImage;
			
			//Ticket WebTable
			@FindBy(how=How.XPATH, using="//div[@id='idTicketsGridPanel-body']//table[contains(@id,'gridview-')]")
				private WebElement nav_TicketsWebTable;
			
			
			//Expand All Notes
			@FindBy(how=How.XPATH,using="//input[contains(@id,'expandAllNotes-')]")
			private WebElement nav_ExpandAllNotes;
			
			
			//Notes WebTable
			//@FindBy(how=How.XPATH,using="//div[contains(@id,'idTicketsGridPanel-body')]/div/table[contains(@id,'gridview-')]")
			 //// this object is updated as part of EXTJS5 on 10/07/2015 by QAA04
			@FindBy(how=How.XPATH, using="//div[contains(@id,'notesGrid-')]//table")
			//@FindBy(how=How.XPATH,using="//table/tbody/tr/td/table/tbody/tr[2]/td/div/section[2]/div[2]/div[3]/div/div[2]/div/table/tbody")
			private WebElement nav_NotesWebTable;
			
			@FindBy(how=How.XPATH, using = "//nav[@id='fw_tabs']//li[@id='natTab']/a[@href='#']")
			private WebElement NATsLinkUnderFirewall;
			
		    @FindBy(how=How.XPATH, using = ".//div[@id='nats_print']//img[@alt='PDF'] ")
		     private WebElement PDFButtonUnderNATs;

		//// this object is updated as part of EXTJS5 on 10/07/2015 by QAA04
			@FindBy(how=How.XPATH, using="//div[@id='natPanel-body']//table[1]/tbody/tr[1]/td[1]/div/div")
			//@FindBy(how=How.XPATH, using = "//div[@id='natPanel-body']//tr[contains(@class,' x-grid-data-row')] //div[@class='x-grid-row-expander']")
			private WebElement nav_networkExpanderunderNATs;
			
			//@FindBy(how=How.XPATH, using = "//div[contains(@class,'x-grid-rowbody')]//span[contains(@id,'refDetailsSpan-')]/a[contains(@id,'refDetails-')]")
			@FindBy(how=How.XPATH, using = "//div[@id='nats-page']//div[@Class='ebuttons']/span/a")
			private WebElement nav_refreshButtonUnderNetwork;
			
            //updated by QAA03 on 07/18/2016
			//@FindBy(how=How.XPATH, using = "//div[contains(@class,'x-grid-rowbody')]//span[contains(@id,'delSpan-')]/a[contains(@id,'del-')]")
			@FindBy(how=How.XPATH, using = "//table[1]//div[contains(@class,'x-grid-rowbody')]//span[contains(@id,'delSpan-')]/a[contains(@id,'del-')]")
			private WebElement nav_deleteButtonUnderNetwork;
			
			//Edit NATS Rule Link
			@FindBy(how=How.XPATH,using="//a/img[@alt='Edit NAT rule']")
			private WebElement nav_EditNATSRuleLink;
	
			@FindBy(how=How.XPATH, using ="//div[@id='natPanel-body']//table[contains(@id,'-table')]//table[contains(@class,'-table x-grid-table')]")
			private WebElement nav_NATsTableUnderFirewall;
				
			 //// this object is updated as part of EXTJS5 on 10/07/2015 by QAA04
			@FindBy(how=How.XPATH, using="//div[contains(@id,'numberfield-')]//input[contains(@id,'-inputEl')]")
			//@FindBy(how=How.XPATH, using = "//table[contains(@id,'numberfield-')]//table[@class='x-form-trigger-wrap x-unselectable']//input[contains(@id,'-inputEl')]")
			private WebElement nav_pagenatEditBoxUnderNATS;
				
			@FindBy(how=How.XPATH, using = "//div[contains(@id,'pagingtoolbar-')]//div[contains(text(),'of')]")
			private WebElement nav_currentPagenatNumberUnderNATs;
			
			@FindBy(how=How.XPATH, using = ".//div[@id='nats-page']//img[@alt='PDF'] ")
		    private WebElement nav_PDFButtonUnderNATs;
		    
		    @FindBy(how=How.XPATH, using = ".//div[@id='nats-page']//img[@alt='CSV'] ")
		    private WebElement nav_CSVButtonUnderNATs;
		    
			
            // Taken from Byron Test Cases
		    @FindBy(how=How.XPATH,using="//div[@id='messagebox-1001_header_hd']")
			private WebElement nav_InfoUnavailableText;
		    
		    @FindBy(how=How.XPATH,using="//ul[@id='val_vm']/li[@id='cat_rules']") 
			private WebElement nav_RulesCountText;
		
            // Taken from Hague test cases
		    @FindBy(how=How.XPATH, using="//div[@id='top_left']//img[@alt='TierPoint logo']")
			//@FindBy(how=How.XPATH,using="//div[@id='top_left']//img[@alt='windstream logo']")
			private WebElement navTierPointLogo;
			
			@FindBy(how=How.XPATH, using="//div[@id='nav_org_maindev']//dd[@id='info_firewall1']/a")
			private WebElement navEVDCPortlet_FirewallVIewLink;
			
			// Firewall portlet
				@FindBy(how=How.XPATH, using="//section[@id='firewall']//img")
				private WebElement navEVDCOverviewFirewallImage;
				
				@FindBy(how=How.XPATH, using="//section[@id='firewall']//ul[@id='cat_vm']/li[1]")
				private WebElement navRulesText;
				
				@FindBy(how=How.ID, using="cat_rules")
				private WebElement navRulesCount;
				
				@FindBy(how=How.XPATH, using="//section[@id='firewall']//ul[@id='cat_vm']/li[2]")
				private WebElement navVPNTunnelsText;
				
				@FindBy(how=How.ID, using="cat_vpn_tunnels")
				private WebElement navVPNTunnelsCount;
				
				@FindBy(how=How.XPATH, using="//section[@id='firewall']//ul[@id='cat_vm']/li[3]")
				private WebElement navVPNUsersText;
				
				@FindBy(how=How.ID, using="cat_vpn_users")
				private WebElement navVPNUsersCount;
				
				@FindBy(how=How.XPATH, using="//section[@id='firewall']//ul[@id='cat_vm']/li[4]")
				private WebElement navNATSText;
				
				@FindBy(how=How.ID, using="cat_nats")
				private WebElement navNATSCount;
				
				@FindBy(how=How.ID, using="vm_create")
				private WebElement navFirewallPageTitle;
			
				// Firewall user acess vpn tab
				@FindBy(how=How.LINK_TEXT, using="User Access VPNs")
				private WebElement navFirewall_UserAcessVPNsTab;
				
				@FindBy(how=How.XPATH, using="//div[@id='uavpn_create']//a[text()='Add User']")
				private WebElement navFirewall_UserAcessVPN_AddUserLink;
				
				@FindBy(how=How.ID, using="userPanel-body")
				private WebElement navFirewall_UserAcessVPN_TableParent;
				
			// Firewall site to site vpn tab	
				@FindBy(how=How.LINK_TEXT, using="Site to Site VPNs")
				private WebElement navFirewall_SiteToSiteVPNsTab;
				
				@FindBy(how=How.LINK_TEXT, using="Add Site to Site VPNs")
				//@FindBy(how=How.ID, using="stsvpn_create")
				private WebElement navFirewall_AddSiteToSiteVPNLink;
				
				@FindBy(how=How.ID, using="stsPanel")
				private WebElement navFirewall_SiteToSiteVPN_TableParent;
				
	
// taken from spilt work space
				@FindBy(how=How.ID, using="firewallsummary-2")
				private WebElement nav_FirstFirewallRuleExpander;
				
				//Add Fire wall link under Interface
				@FindBy(how=How.XPATH,using="//a[contains(text(),'Add Firewall Rule')]")
				private WebElement nav_AddFireWallLink;
				
				// GOM	
				@FindBy(how=How.XPATH,using="//div[@id='firewall_gom_button']//a")
				private WebElement nav_GOMLink;
				
				@FindBy(how=How.ID, using="gom-nw-ei")
				private WebElement nav_NetworkObjectExpander;
				
				@FindBy(how=How.XPATH, using="//div[@id='gom_nw_tree_panel-body']//img[contains(@class,'x-tree-expander')]")
				private WebElement nav_NetworkExpander;
				
				@FindBy(how=How.LINK_TEXT,using="open a ticket")
				private WebElement nav_FirewallOpenTicket;
				
				@FindBy(how=How.ID,using="createTicketTitle-inputEl")
				private WebElement nav_FireWallTicketTitle;
				
				@FindBy(how=How.ID,using="natEdit-insideInterface-extId-trigger-picker")
				private WebElement nav_AddNatInsideInterfaceDropdown;
				
				@FindBy(how=How.ID,using="natEdit-privateIp-extId-inputEl")
				private WebElement nav_PrivateIPAddressEditBox;
				
				@FindBy(how=How.ID,using="natEdit-publicIp-extId-inputEl")
				private WebElement nav_PublicIpAddressEditBox;
				
				@FindBy(how=How.ID,using="saveAddNat")
				private WebElement nav_AddNATSaveRuleBtn;
				
				@FindBy(how=How.ID,using="boundlist-1055")
				private WebElement nav_AddNATBoundList;
				
				// this below element updated by NMR - 07/12/2016
				@FindBy(how=How.XPATH,using="//a/img[@alt='create ticket']")
				//@FindBy(how=How.ID,using="//img[@alt='create ticket']")
				private WebElement nav_CreateTicketTitle;
				
				//@FindBy(how=How.XPATH,using="//div[@id='navpopupbuttons']//a[Contains(text(),'Ok')]")
				@FindBy(how=How.XPATH,using="//div[@id='navpopupbuttons']/span[1]/a")
				private WebElement nav_AddNatPopUpOKBtn;
				
				// this below elements is added by NMR - 06/07/2016
				@FindBy(how=How.XPATH, using="//img[@alt='create ticket']")
				private WebElement nav_CreateTicketLink;
				
				@FindBy(how=How.XPATH, using="(//div[contains(@class,'x-grid-rowbody')]//span[contains(@id,'editSpan-')])[1]")
				private WebElement nav_EditButtonUnderNetwork;
				
				@FindBy(how=How.ID, using="natEdit-publicIp-extId-inputEl")
				private WebElement nav_NatEdit_PublicIpAddressInputField;
				
				@FindBy(how=How.ID, using="saveAddNat")
				private WebElement nav_EditNatSaveRuleButton;
				
				@FindBy(how=How.ID, using="natEdit-insideInterface-extId-trigger-picker")
				private WebElement nav_NatEdit_InsideInterfaceDropDownArrow;
				
				@FindBy(how=How.ID, using="natEdit-privateIp-extId-inputEl")
				private WebElement nav_NatEdit_PrivateIpAddressInputField;
				
				@FindBy(how=How.XPATH, using="//div[@class='insideInterface half_span']//span[@class='imgtip']")
				private WebElement nav_NatEdit_InsideInterfaceIcon;
				
				@FindBy(how=How.XPATH, using="//div[@class='outsideInterface half_span']//span[@class='imgtip']")
				private WebElement nav_NatEdit_OutsideInterfaceIcon;
				
				
				@FindBy(how=How.XPATH, using="//div[@class='privateIPAddress half_span']//span[@class='imgtip']")
				private WebElement nav_NatEdit_PrivateIpAddressIcon;
				
				@FindBy(how=How.XPATH, using="//div[@class='publicIPAddress half_span']//span[@class='imgtip']")
				private WebElement nav_NatEdit_PublicIpAddressIcon;
				
				@FindBy(how=How.ID, using="userAccessTab")
				private WebElement nav_UserAccessVPNsTab;
				
				@FindBy(how=How.ID, using="userPanel-body")
				private WebElement nav_UserAccessVPN_WebTableParent;
				
				@FindBy(how=How.ID, using="siteTab")
				private WebElement nav_SiteToSiteVPNsTab;
				
				@FindBy(how=How.XPATH, using="(//a[contains(@onclick,'RAVPNUSR.forms.fnResetPassword')])[1]")
				private WebElement nav_UserAccessVPN_ResetPasswordBtn;
				
				@FindBy(how=How.XPATH, using="(//a[contains(@onclick,'RAVPNUSR.forms.fnDeleteHandler')])[1]")
				private WebElement nav_UserAccessVPN_DeleteBtn;
				
				@FindBy(how=How.ID, using="h_pwd-inputEl")
				private WebElement nav_UserAccessVPN_ResetPasswordEditField;
				
				@FindBy(how=How.XPATH, using="(//div[@id='raVpnHiddenForm']//span[contains(@id,'-btnInnerEl')])[2]")
				private WebElement nav_UserAccessVpn_ResetPassword_ConfirmPopupOkBtn;
				
				@FindBy(how=How.ID, using="natEdit-outsideInterface-extId-inputEl")
				private WebElement nav_NatEdit_OutsideInterfaceEditField;
				
				@FindBy(how=How.ID, using="natEdit-insideInterface-extId-inputEl")
				private WebElement nav_NatEdit_InsideInterfaceDropDownEditField;
				
				@FindBy(how=How.ID, using="cancelAddFW")
				private WebElement nav_FireWallRuleCancelButton;
				
				@FindBy(how=How.XPATH, using="//span[@id='fwEdit-editButton-fwRuID-28-1']/a")
				private WebElement nav_FireWallRuleEditButton;
				
				@FindBy(how=How.XPATH, using="//span[@id='fwEdit-deleteButton-fwRuID-28-1']/a")
				private WebElement nav_FireWallRuleDeleteButton;
				
				@FindBy(how=How.ID, using="fwEdit-sourceType-extId-28-1-trigger-picker")
				private WebElement nav_SourceTypeDropdownIcon;
				
				@FindBy(how=How.ID, using="boundlist-1060")
				private WebElement nav_SourceTypeDropdownList;
				
	/////////////////////////////////////////////////////////////////////////////////////////////////
				
				public WebElement getNav_SourceTypeDropdownList() {
					FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
					return nav_SourceTypeDropdownList;
							}
				
				public WebElement getNav_SourceTypeDropdownIcon() {
					FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
					return nav_SourceTypeDropdownIcon;
							}
				
				public WebElement getNav_FireWallRuleDeleteButton() {
					FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
					return nav_FireWallRuleDeleteButton;
							}
				
				public WebElement getNav_FireWallRuleEditButton() {
					FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
					return nav_FireWallRuleEditButton;
							}
				
				public WebElement getNav_FireWallRuleCancelButton() {
					FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
					return nav_FireWallRuleCancelButton;
							}
				
				public WebElement getNav_CreateTicketTitle() {
					FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
					return nav_CreateTicketTitle;
							}
				
				public WebElement getNav_AddNatPopUpOKBtn() {
					FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
					return nav_AddNatPopUpOKBtn;
							}
	public WebElement getNav_AddNATBoundList() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNATBoundList;
				}
	public WebElement getNav_AddNATSaveRuleBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNATSaveRuleBtn;
	}
				
	public WebElement getNav_AddNatInsideInterfaceDropdown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNatInsideInterfaceDropdown;
    }
	
	public WebElement getNav_PublicIpAddressEditBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PublicIpAddressEditBox;
    }
	
	public WebElement getNav_PrivateIPAddressEditBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PrivateIPAddressEditBox;
    }
				
	public WebElement getNav_AddNATSLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNATSLink;
	}

	public WebElement getNav_SourceInterFaceColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SourceInterFaceColumn;
	}

	public WebElement getNav_SourceInsideIPColumn() {
		return nav_SourceInsideIPColumn;
	}

	public WebElement getNav_DestinationInterfaceColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DestinationInterfaceColumn;
	}

	public WebElement getNav_ExternalIPColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ExternalIPColumn;
	}

	public WebElement getNav_HostNameColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_HostNameColumn;
	}

	public WebElement getNav_FirewallTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FirewallTable;
	}

	public WebElement getNav_NATSLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NATSLink;
	}

	public WebElement getNav_EditNatTitleInput() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditNatTitleInput;
	}

	public WebElement getNav_EditNATSNotesFrame() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditNATSNotesFrame;
	}

	public WebElement getNav_EditNatOkButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditNatOkButton;
	}

	public WebElement getNav_EditNatCancelButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditNatCancelButton;
	}

	public WebElement getNav_ConfirmPopup() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ConfirmPopup;
	}

	public WebElement getNav_ConfirmPopupOkBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ConfirmPopupOkBtn;
	}

	public WebElement getNav_NotesSeverity() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NotesSeverity;
	}

	public WebElement getNav_NotesPriority() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NotesPriority;
	}

	public WebElement getNav_NotesStatus() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NotesStatus;
	}

	public WebElement getNav_SearchByDropDownArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SearchByDropDownArrow;
	}

	public WebElement getNav_SearchByDropdown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SearchByDropdown;
	}

	public WebElement getNav_SearchEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SearchEdit;
	}

	public WebElement getNav_SearchByImage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SearchByImage;
	}

	public WebElement getNav_TicketsWebTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketsWebTable;
	}

	public WebElement getNav_ExpandAllNotes() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ExpandAllNotes;
	}

	public WebElement getNav_NotesWebTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NotesWebTable;
	}

	public WebElement getNATsLinkUnderFirewall() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return NATsLinkUnderFirewall;
	}

	public WebElement getPDFButtonUnderNATs() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return PDFButtonUnderNATs;
	}

	public WebElement getNav_networkExpanderunderNATs() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_networkExpanderunderNATs;
	}

	public WebElement getNav_refreshButtonUnderNetwork() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_refreshButtonUnderNetwork;
	}

	public WebElement getNav_deleteButtonUnderNetwork() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_deleteButtonUnderNetwork;
	}

	public WebElement getNav_EditNATSRuleLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditNATSRuleLink;
	}

	public WebElement getNav_NATsTableUnderFirewall() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NATsTableUnderFirewall;
	}

	public WebElement getNav_pagenatEditBoxUnderNATS() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_pagenatEditBoxUnderNATS;
	}

	public WebElement getNav_currentPagenatNumberUnderNATs() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_currentPagenatNumberUnderNATs;
	}

	public WebElement getNav_PDFButtonUnderNATs() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PDFButtonUnderNATs;
	}

	public WebElement getNav_CSVButtonUnderNATs() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CSVButtonUnderNATs;
	}

	public WebElement getNav_InfoUnavailableText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_InfoUnavailableText;
	}

	public WebElement getNav_RulesCountText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_RulesCountText;
	}

	public WebElement getNavTierPointLogo() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navTierPointLogo;
	}

	public WebElement getNavEVDCPortlet_FirewallVIewLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navEVDCPortlet_FirewallVIewLink;
	}

	public WebElement getNavEVDCOverviewFirewallImage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navEVDCOverviewFirewallImage;
	}

	public WebElement getNavRulesText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navRulesText;
	}

	public WebElement getNavRulesCount() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navRulesCount;
	}

	public WebElement getNavVPNTunnelsText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navVPNTunnelsText;
	}

	public WebElement getNavVPNTunnelsCount() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navVPNTunnelsCount;
	}

	public WebElement getNavVPNUsersText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navVPNUsersText;
	}

	public WebElement getNavVPNUsersCount() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navVPNUsersCount;
	}

	public WebElement getNavNATSText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navNATSText;
	}

	public WebElement getNavNATSCount() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navNATSCount;
	}

	public WebElement getNavFirewallPageTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navFirewallPageTitle;
	}

	public WebElement getNavFirewall_UserAcessVPNsTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navFirewall_UserAcessVPNsTab;
	}

	public WebElement getNavFirewall_UserAcessVPN_AddUserLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navFirewall_UserAcessVPN_AddUserLink;
	}

	public WebElement getNavFirewall_UserAcessVPN_TableParent() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navFirewall_UserAcessVPN_TableParent;
	}

	public WebElement getNavFirewall_SiteToSiteVPNsTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navFirewall_SiteToSiteVPNsTab;
	}

	public WebElement getNavFirewall_AddSiteToSiteVPNLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navFirewall_AddSiteToSiteVPNLink;
	}

	public WebElement getNavFirewall_SiteToSiteVPN_TableParent() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navFirewall_SiteToSiteVPN_TableParent;
	}

	public WebElement getNav_FirstFirewallRuleExpander() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FirstFirewallRuleExpander;
	}

	public WebElement getNav_AddFireWallLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFireWallLink;
	}

	public WebElement getNav_GOMLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_GOMLink;
	}

	public WebElement getNav_NetworkObjectExpander() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NetworkObjectExpander;
	}

	public WebElement getNav_NetworkExpander() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NetworkExpander;
	}

	public WebElement getNav_FirewallOpenTicket() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FirewallOpenTicket;
	}

	public WebElement getNav_FireWallTicketTitle() { 
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FireWallTicketTitle;
	}

	public WebElement getNav_CreateTicketLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateTicketLink;
	}

	public WebElement getNav_EditButtonUnderNetwork() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditButtonUnderNetwork;
	}

	public WebElement getNav_NatEdit_PublicIpAddressInputField() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NatEdit_PublicIpAddressInputField;
	}

	public WebElement getNav_EditNatSaveRuleButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditNatSaveRuleButton;
	}

	public WebElement getNav_NatEdit_InsideInterfaceDropDownArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NatEdit_InsideInterfaceDropDownArrow;
	}

	public WebElement getNav_NatEdit_PrivateIpAddressInputField() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NatEdit_PrivateIpAddressInputField;
	}

	public WebElement getNav_NatEdit_InsideInterfaceIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NatEdit_InsideInterfaceIcon;
	}

	public WebElement getNav_NatEdit_OutsideInterfaceIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NatEdit_OutsideInterfaceIcon;
	}

	public WebElement getNav_NatEdit_PrivateIpAddressIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NatEdit_PrivateIpAddressIcon;
	}

	public WebElement getNav_NatEdit_PublicIpAddressIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NatEdit_PublicIpAddressIcon;
	}

	public WebElement getNav_UserAccessVPNsTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_UserAccessVPNsTab;
	}

	public WebElement getNav_UserAccessVPN_WebTableParent() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_UserAccessVPN_WebTableParent;
	}

	public WebElement getNav_SiteToSiteVPNsTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SiteToSiteVPNsTab;
	}

	public WebElement getNav_UserAccessVPN_ResetPasswordBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_UserAccessVPN_ResetPasswordBtn;
	}

	public WebElement getNav_UserAccessVPN_DeleteBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_UserAccessVPN_DeleteBtn;
	}

	public WebElement getNav_UserAccessVPN_ResetPasswordEditField() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_UserAccessVPN_ResetPasswordEditField;
	}

	public WebElement getNav_NatEdit_OutsideInterfaceEditField() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NatEdit_OutsideInterfaceEditField;
	}

	public WebElement getNav_NatEdit_InsideInterfaceDropDownEditField() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NatEdit_InsideInterfaceDropDownEditField;
	}

	public WebElement getNav_UserAccessVpn_ResetPassword_ConfirmPopupOkBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_UserAccessVpn_ResetPassword_ConfirmPopupOkBtn;
	}

	
	
}
