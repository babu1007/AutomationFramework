package com.whs.navigator.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class EVDC_FirewallPageFactory {
	
///////////**********************LefCourt SP2 Elements **********************************////////

	@FindBy(how=How.ID,using="firewall_rules")
	private WebElement nav_AddFireWallWindow;
	
	@FindBy(how=How.XPATH, using="//div[@class='float_div_vertical_align']/a/img[@alt='PDF']")
	private WebElement nav_Firewall_PDFIcon;
	
	@FindBy(how=How.XPATH, using="//div[@class='float_div_vertical_align']/a/img[@alt='CSV']")
	private WebElement nav_Firewall_CSVIcon;
    

	
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
	//Add Fire wall link under Interface
		@FindBy(how=How.XPATH,using="//a[contains(text(),'Add Firewall Rule')]")
		private WebElement nav_AddFireWallLink;
		
		@FindBy(how=How.ID, using="firewallsummary-2")
		private WebElement nav_FirstFirewallRuleExpander;
// GOM	
		@FindBy(how=How.ID, using="gom-page")
		private WebElement nav_GOMPopup;
		
		@FindBy(how=How.XPATH,using="//div[@id='firewall_gom_button']//a")
		private WebElement nav_GOMLink;
		
		@FindBy(how=How.ID, using="gom_nw_tree_panel-body")
		private WebElement nav_Network_NetworkObjectWebTableParent;
		
		@FindBy(how=How.ID, using="gom-nw-ei")
		private WebElement nav_NetworkObjectExpander;
		
		@FindBy(how=How.XPATH, using="//div[@id='gom_print']//img[@alt='PDF']")
		private WebElement nav_GOM_PDFIcon;
		
		@FindBy(how=How.XPATH, using="//div[@id='gom_print']//img[@alt='CSV']")
		private WebElement nav_GOM_CSVIcon;
		
		
		//@FindBy(how=How.XPATH, using="//div[@id='gom_nw_tree_panel-body']//img[contains(@class,'x-tree-expander')]")
		@FindBy(how=How.ID,using="gom-nw-ei")
		private WebElement nav_NetworkExpander;
		
		@FindBy(how=How.XPATH, using="//img[@data-qtip='Create']")
		private WebElement nav_CreateImageUnderNetworkObjects;
		
		@FindBy(how=How.ID, using="gom-svc-ei")
		private WebElement nav_ServiceObjectsExpander;
		
		@FindBy(how=How.XPATH, using="//div[@id='gom_svc_tree_panel-body']//img[contains(@class,'x-tree-expander')]")
		private WebElement nav_ServiceExpander;
		
		@FindBy(how=How.XPATH,using="//div[@id='gom_details']/button[@class='close_icon']")
		private WebElement nav_GOMWindowClose;
		
		//Search Input field
		@FindBy(how=How.ID,using="svcsearchtrigger-inputEl")
		private WebElement nav_GOMServiceSearchEdit;
		
		@FindBy(how=How.XPATH,using="//div[@id='svcsearchtrigger']/../div[contains(@id,'displayfield')]/div[contains(@id,'displayfield') and contains(@id,'bodyEl')]/div[contains(@id,'inputEl')]")
		private WebElement nav_GOMServiceMatchesFound;
		
		//GOM Landing page Text
		@FindBy(how=How.XPATH,using="//div[@id='gom_create']/span[text()='Group Object Management']")
		private WebElement nav_GOMText;
		//GOM Service Grid Table
		@FindBy(how=How.ID,using="gomServiceObjectGrid")
		private WebElement nav_GOMServiceTableParent;
		//HS- Service Expander
		@FindBy(how=How.XPATH,using="//table[contains(@data-qtip,'HS')]//img[contains(@class,'x-tree-expander')]")
		private WebElement nav_GOMServiceHSServiceExpander;
		//Service Create Imag
		@FindBy(how=How.XPATH,using="//span[text()='Service']/../../..//img[@data-qtip='Create']")
		private WebElement nav_GOMServiceCreateImg;
		
		//Create Dialog Box - Services objects
		@FindBy(how=How.XPATH,using="//div[@id='gom-edit-div-s']/table[@class='edit-main-table']")
		private WebElement nav_GOMServiceCreateWindow;
		
		//ObjectType DropDown Arrow 
		@FindBy(how=How.ID,using="combo1_S-trigger-picker")
		private WebElement nav_Service_ObjectTypeDropDownArrow;
		//ObjectType DropDown List
		//@FindBy(how=How.XPATH,using="//div[contains(@id,'boundlist-') and contains(@class,'default x-border-box')]//ul")
		
		
		//From Existing Object - Table
		@FindBy(how=How.ID,using="lefthandgrid_S-bod")
		private WebElement nav_Service_FromExistingGrpTable;
		
		//From Existing Group
		@FindBy(how=How.ID,using="gom-radio1_S-inputEl")
		private WebElement nav_Service_ObjectTypeFromExistingGrp;
		
		//New Object Radio button
		@FindBy(how=How.ID,using="gom-radio2_S-inputEl")
		private WebElement nav_Service_ObjectTypeNewObjRadioBtn;
		//New Object Name
		@FindBy(how=How.ID,using="newObjectName_S-inputEl")
		private WebElement nav_Service_ObjectTypeNewObjName;
		//New Object Type Dropdown arrow
		@FindBy(how=How.ID,using="nwtypecombo_S-trigger-picker")
		private WebElement nav_Service_ObjectTypeNewObjTypeDropDownArrow;
		
		//Service End dropdown arrow
		@FindBy(how=How.ID,using="portServiceEnd-trigger-picker")
		private WebElement nav_Service_ObjectTypeServiceEndDropdownArrow;
		
		//Port Range - Start
		@FindBy(how=How.ID,using="portstartid-inputEl")
		private WebElement nav_Service_ObjectTypePortRangeStart;
		//Port Range - END
		@FindBy(how=How.ID,using="portendid-inputEl")
		private WebElement nav_Service_ObjectTypePortRangeEnd;
		//Transfer right >>
		@FindBy(how=How.ID,using="transfer-right-input-s")
		private WebElement nav_Service_ObjectTypeTransferRight;
		//Right side table
		@FindBy(how=How.XPATH,using="//div[@id='righthandsidegrid_S-body']//table")
		private WebElement nav_Service_CreateConfirmationTablRHS;
		//Save button
		@FindBy(how=How.ID,using="savebtn_GOM-s")
		private WebElement nav_Service_ObjectTypeSaveBtn;
		
		//cancel
		@FindBy(how=How.XPATH,using="//div[@id='gom-edit-div-s']/table[@class='edit-main-table']//a[text()='Cancel']")
		private WebElement nav_Service_ObjectTypeCancelBtn;
		
		//Service New Name
		@FindBy(how=How.ID,using="newNwGrpRHS_S-inputEl")
		private WebElement nav_Service_NewNameEdit;
		
		//Service Group Description
		@FindBy(how=How.ID,using="gomeditdesc-grp_S-inputEl")
		private WebElement nav_Service_GrpDescTextArea;
		
		
		
		// Create dialog box - Network Objects
		@FindBy(how=How.ID, using="combo1-trigger-picker")
		private WebElement nav_Network_ObjectTypeDropDownArrow;
		
		@FindBy(how=How.ID, using="combo1-inputEl")
		private WebElement nav_Network_ObjectTypeDropDownTextBox;
		
		@FindBy(how=How.ID, using="nwtypecombo-inputEl")
		private WebElement nav_Network_TypeDropDownTextBox;
		
		@FindBy(how=How.XPATH, using="//div[@id='new-object-radio']//input[contains(@id,'-inputEl')]")
		private WebElement nav_Network_EditObjectRadioBtn;
		
		@FindBy(how=How.ID, using="gom-radio1-inputEl")
		private WebElement nav_Network_FromExistingObjectsRadioBtn;
		
		@FindBy(how=How.ID, using="lefthandgrid-body")
		private WebElement nav_Network_ExistingObjectsWebTableParent;
		
		@FindBy(how=How.XPATH, using="//div[@id='lefthandgrid']//span[text()='IP Address']")
		private WebElement nav_Network_ExistingObject_IpAddressColumnTitle;
		
		@FindBy(how=How.XPATH, using="//div[@id='lefthandgrid']//span[text()='Netmask']")
		private WebElement nav_Network_ExisitingObject_NetmaskColumnTitle;
		
		@FindBy(how=How.XPATH, using="//span[contains(@id,'-btnIconEl')][contains(@class,' x-tbar-page-next')]")
		private WebElement nav_Network_ExistingObject_PaginationNextBtn;
		
		@FindBy(how=How.XPATH, using="//div[contains(@class,'x-toolbar-text-default')][contains(text(),'of')]")
		private WebElement nav_Network_ExistingObject_PaginationTotalCount;
		
		@FindBy(how=How.XPATH, using="//input[contains(@id,'-inputEl')][contains(@class,'x-field-form-focus x-field-default-form-focus')]")
		private WebElement nav_Network_ExistingObject_CurrentPageNumber;
		
		@FindBy(how=How.XPATH, using="//label[text()='New Object']//../input[contains(@id,'gom-radio')]")
		private WebElement nav_Network_NewObjectRadioBtn;
		
		@FindBy(how=How.ID, using="newObjectName-inputEl")
		private WebElement nav_Network_NetworkNameEditBox;
		
		@FindBy(how=How.ID, using="nwtypecombo-trigger-picker")
		private WebElement nav_Network_TypeDropDownArrow;
		
		@FindBy(how=How.ID, using="nw-ipaddr-inputEl")
		private WebElement nav_Network_IPAddressEditBox;
		
		@FindBy(how=How.ID, using="nw-netmask-inputEl")
		private WebElement nav_Network_NetmaskEditBox;
		
		@FindBy(how=How.ID, using="transfer-right-input")
		private WebElement nav_Network_ForwardArrow;
		
		@FindBy(how=How.ID, using="transfer-left-input")
		private WebElement nav_Network_BackwardArrow;
		
		@FindBy(how=How.ID, using="newNwGrpRHS-inputEl")
		private WebElement nav_Network_NewNameEditBox;
		
		@FindBy(how=How.ID, using="gomeditdesc-grp-inputEl")
		private WebElement nav_Network_GroupDiscriptionEditBox;
		
		@FindBy(how=How.ID, using="righthandsidegrid-body")
		private WebElement nav_Network_GroupWebTableParent;
	
		@FindBy(how=How.ID, using="savebtn_GOM")
		private WebElement nav_Network_SaveBtn;
		
		@FindBy(how=How.XPATH, using="//div[@id='gom-edit-div']//a[text()='Cancel']")
		private WebElement nav_Network_CancelBtn;
		
		@FindBy(how=How.ID, using="navpopupbody")
		private WebElement nav_Network_ConfirmPopupBox;
		
		@FindBy(how=How.ID, using="gom-edit-div")
		private WebElement nav_Network_CreateEditPopupBox;
		
		@FindBy(how=How.ID, using="navpopupbody")
        private WebElement nav_Network_deletePopupBox;
		
		@FindBy(how=How.XPATH, using="//div[@id='navpopupbuttons']//a[contains(text(),'Ok')]")
		private WebElement nav_Network_ConfirmPopupOkBtn;
		
		@FindBy(how=How.ID, using="userfeedback")
		private WebElement nav_Network_FeedbackMsg;
		
		@FindBy(how=How.XPATH, using="//label[@id='ipradiogroup-labelEl']/span")
		private WebElement nav_Network_IPVersionTitle;
		
		@FindBy(how=How.XPATH, using="//input[contains(@id,'radiofield-')][contains(@id,'-inputEl')]")
		private WebElement nav_Network_IPV4Radiobtn;
		
		@FindBy(how=How.XPATH, using="//label[text()='IPV6']")
		private WebElement nav_Network_IPV6Title;
		
		@FindBy(how=How.ID, using ="nwsearchtrigger-inputEl")
		private WebElement nav_Network_SearchEditBox;
		
		@FindBy(how=How.XPATH, using="//div[@id='gom_nw_tree_panel']//div[contains(@id,'displayfield-')][contains(@id,'-inputEl')]")
		private WebElement nav_Network_SearchMatchesCount;
		
		@FindBy(how=How.ID, using="gom_nw_tree_panel-body")
		private WebElement nav_NetworkWebTableParent;
		
		@FindBy(how=How.XPATH, using="//div[@id='gom_details']/button[@class='close_icon']/img")
		private WebElement nav_Network_CloseBtn;
		
		@FindBy(how=How.XPATH, using="//div[@id='gom_nw_tree_panel']//span[text()='Start IP Address']")
		private WebElement nav_Network_StartIpAddressColumnName;
		
		@FindBy(how=How.XPATH, using="//div[@id='gom_nw_tree_panel']//span[text()='End IP Address']")
		private WebElement nav_Network_EndIpAddressColumnName;
		
		@FindBy(how=How.XPATH, using="//div[@id='gom_nw_tree_panel']//span[text()='Netmask']")
		private WebElement nav_Network_NetmaskColumnName;
		
		@FindBy(how=How.XPATH, using="//div[@id='gom_nw_tree_panel']//span[text()='ObjectNat']")
		private WebElement nav_Network_ObjectNatColumnName;
		
		@FindBy(how=How.XPATH, using="//div[@id='gom_nw_tree_panel']//span[text()='Description']")
		private WebElement nav_Network_DescriptionColumnName;
		
	@FindBy(how=How.XPATH,using="//table[contains(@class,'vm_table_construction')]")
	private WebElement nav_FirewallTable;
	
	//NATS Link
	@FindBy(how=How.XPATH,using="//a[text()='NATs']")
	private WebElement nav_NATSLink;

	//Edit NATS Rule Link
		@FindBy(how=How.ID,using="createTicketTitle-inputEl")
		private WebElement nav_EditNatTitleInput;
		
		 @FindBy(how=How.XPATH,using="//iframe[@class='x-htmleditor-iframe']")
		 private WebElement nav_EditNATSNotesFrame;
		 
		//Edit NATS OK button
		@FindBy(how=How.XPATH,using="//span[text()='OK']")
		private WebElement nav_EditNatOkButton;
		
		// this element is updated by NMR - 06/29/2016
		//Edit NATS Cancel button
		@FindBy(how=How.ID, using="cancelAddNat")
		//@FindBy(how=How.XPATH,using="//span[text()='Cancel']")
		private WebElement nav_EditNatCancelButton;
		
		//Confirmation Pop up
		@FindBy(how=How.ID, using="messagebox-1001")
		private WebElement nav_ConfirmPopup;
		
		//Confirmation Pop up window OK button
		
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
			
			// this element is added by QAA04 --2/15/2016
			@FindBy(how=How.XPATH, using="//div[@id='nats-page']//img[@alt='PDF']")
		   // @FindBy(how=How.XPATH, using = ".//div[@id='nats_print']//img[@alt='PDF']")
		     private WebElement PDFButtonUnderNATs;

		//// this object is updated as part of EXTJS5 on 10/07/2015 by QAA04
			@FindBy(how=How.XPATH, using="//div[@id='natPanel-body']//table[1]/tbody/tr[1]/td[1]/div/div")
			//@FindBy(how=How.XPATH, using = "//div[@id='natPanel-body']//tr[contains(@class,' x-grid-data-row')] //div[@class='x-grid-row-expander']")
			private WebElement nav_networkExpanderunderNATs;
			
			@FindBy(how=How.XPATH, using = "//div[contains(@class,'x-grid-rowbody')]//span[contains(@id,'refDetailsSpan-')]/a[contains(@id,'refDetails-')]")
			private WebElement nav_refreshButtonUnderNetwork;
			

			@FindBy(how=How.XPATH, using = "(//div[contains(@class,'x-grid-rowbody')]//span[contains(@id,'delSpan-')])[1]")
			private WebElement nav_deleteButtonUnderNetwork;
			
			@FindBy(how=How.XPATH, using="(//div[contains(@class,'x-grid-rowbody')]//span[contains(@id,'editSpan-')])[1]")
			private WebElement nav_EditButtonUnderNetwork;
			
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
			
			@FindBy(how=How.XPATH, using="//div[@id='fw_rules']//img[@alt='PDF']")
			//@FindBy(how=How.XPATH, using = ".//div[@id='nats_print']//img[@alt='PDF']")
		    private WebElement nav_PDFButtonUnderNATs;
		    
			@FindBy(how=How.XPATH, using="//div[@id='fw_rules']//img[@alt='CSV']")
		   // @FindBy(how=How.XPATH, using = ".//div[@id='nats_print']//img[@alt='CSV']")
		    private WebElement nav_CSVButtonUnderNATs;
		    
			
///// Taken from Byron Test Cases
		    @FindBy(how=How.XPATH,using="//div[@id='messagebox-1001_header_hd']")
			private WebElement nav_InfoUnavailableText;
		    
		    @FindBy(how=How.XPATH,using="//ul[@id='val_vm']/li[@id='cat_rules']")
			private WebElement nav_RulesCountText;
		
//// Taken from Hague test cases
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
			
				/// Firewall user acess vpn tab
				@FindBy(how=How.LINK_TEXT, using="User Access VPNs")
				private WebElement navFirewall_UserAcessVPNsTab;
				
				@FindBy(how=How.XPATH, using="//div[@id='uavpn_create']//a[text()='Add User']")
				private WebElement navFirewall_UserAcessVPN_AddUserLink;
				
				@FindBy(how=How.ID, using="userPanel-body")
				private WebElement navFirewall_UserAcessVPN_TableParent;
				
			/// Firewall site to site vpn tab	
				@FindBy(how=How.LINK_TEXT, using="Site to Site VPNs")
				private WebElement navFirewall_SiteToSiteVPNsTab;
				
				@FindBy(how=How.LINK_TEXT, using="Add Site to Site VPNs")
				//@FindBy(how=How.ID, using="stsvpn_create")
				private WebElement navFirewall_AddSiteToSiteVPNLink;
				
				@FindBy(how=How.ID, using="stsPanel")
				private WebElement navFirewall_SiteToSiteVPN_TableParent;
				
				@FindBy(how=How.ID, using="gom_nw_tree_panel")
				private WebElement nav_NetworkObjectsTable;
				
				@FindBy(how=How.XPATH, using="//span[text()='Start IP Address']")
				private WebElement nav_StartIPAddressColumn;
				
				@FindBy(how=How.XPATH, using="//span[text()='End IP Address']")
				private WebElement nav_EndIPAddressColumn;
				
				@FindBy(how=How.XPATH, using="//span[text()='Netmask']")
				private WebElement nav_NetMaskColumn;
				
				@FindBy(how=How.XPATH, using="//span[text()='ObjectNat']")
				private WebElement nav_ObjectNatColumn;
				
				@FindBy(how=How.XPATH, using="//span[text()='Description']")
				private WebElement nav_DescriptionColumn;
				
				// this below elements is added by NMR - 06/07/2016
				@FindBy(how=How.XPATH, using="//img[@alt='create ticket']")
				private WebElement nav_CreateTicketLink;
				
				@FindBy(how=How.ID, using="saveAddNat")
				private WebElement nav_EditNatSaveRuleButton;
				
				@FindBy(how=How.ID, using="natEdit-publicIp-extId-inputEl")
				private WebElement nav_NatEdit_PublicIpAddressInputField;
				
				@FindBy(how=How.ID, using="natEdit-outsideInterface-extId-inputEl")
				private WebElement nav_NatEdit_OutsideInterfaceEditField;
				
				@FindBy(how=How.ID, using="natEdit-insideInterface-extId-trigger-picker")
				private WebElement nav_NatEdit_InsideInterfaceDropDownArrow;
				
				@FindBy(how=How.ID, using="natEdit-insideInterface-extId-inputEl")
				private WebElement nav_NatEdit_InsideInterfaceDropDownEditField;
				
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
				
	/////////////////////////////////////////////////////////////////////////////////////////////////
	
	
				
	public WebElement getNav_StartIPAddressColumn() {
					FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
					return nav_StartIPAddressColumn;
				}
	public WebElement getNav_EndIPAddressColumn() {
					FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
					return nav_NetworkObjectsTable;
				}
	public WebElement getNav_NetMaskColumn() {
					FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
					return nav_NetworkObjectsTable;
				}
	public WebElement getNav_DescriptionColumn() {
					FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
					return nav_DescriptionColumn;
				}
				
	public WebElement getNav_ObjectNatColumn() {
					FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
					return nav_NetworkObjectsTable;
				}
				
	public WebElement getNav_NetworkObjectsTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NetworkObjectsTable;
	}
	
	public WebElement getNav_GOMPopup() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_GOMPopup;
	}
				
	public WebElement getNav_AddNATSLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddNATSLink;
	}
	
	

	public WebElement getNav_Network_ExistingObject_PaginationNextBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_ExistingObject_PaginationNextBtn;
	}

	


	public WebElement getNav_Network_ExistingObject_PaginationTotalCount() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_ExistingObject_PaginationTotalCount;
	}



	public WebElement getNav_Network_ExistingObject_CurrentPageNumber() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_ExistingObject_CurrentPageNumber;
	}



	public WebElement getNav_SourceInterFaceColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SourceInterFaceColumn;
	}

	public WebElement getNav_CreateImageUnderNetworkObjects() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateImageUnderNetworkObjects;
	}	
	public WebElement getNav_ServiceObjectsExpander() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ServiceObjectsExpander;
	}

	public WebElement getNav_ServiceExpander() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ServiceExpander;
	}

	public WebElement getNav_SourceInsideIPColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
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

	public WebElement getNav_AddFireWallLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFireWallLink;
	}

	public WebElement getNav_FirstFirewallRuleExpander() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FirstFirewallRuleExpander;
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

	public WebElement getNav_GOMText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_GOMText;
	}

	public WebElement getNav_GOMServiceTableParent() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_GOMServiceTableParent;
	}
	
	public WebElement getNav_AddFireWallWindow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFireWallWindow;
	}

	
	public WebElement getNav_Network_ObjectTypeDropDownArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_ObjectTypeDropDownArrow;
	}

	public WebElement getNav_Network_FromExistingObjectsRadioBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_FromExistingObjectsRadioBtn;
	}

	public WebElement getNav_Network_ExistingObjectsWebTableParent() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_ExistingObjectsWebTableParent;
	}

	public WebElement getNav_Network_NewObjectRadioBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_NewObjectRadioBtn;
	}

	public WebElement getNav_Network_NetworkNameEditBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_NetworkNameEditBox;
	}

	public WebElement getNav_Network_TypeDropDownArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_TypeDropDownArrow;
	}

	public WebElement getNav_Network_IPAddressEditBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_IPAddressEditBox;
	}

	public WebElement getNav_Network_NetmaskEditBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_NetmaskEditBox;
	}

	public WebElement getNav_Network_ForwardArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_ForwardArrow;
	}

	public WebElement getNav_Network_BackwardArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_BackwardArrow;
	}

	public WebElement getNav_Network_NewNameEditBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_NewNameEditBox;
	}

	public WebElement getNav_Network_GroupDiscriptionEditBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_GroupDiscriptionEditBox;
	}

	public WebElement getNav_Network_SaveBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_SaveBtn;
	}

	public WebElement getNav_Network_CancelBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_CancelBtn;
	}

	public WebElement getNav_Network_IPVersionTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_IPVersionTitle;
	}

	public WebElement getNav_Network_IPV4Radiobtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_IPV4Radiobtn;
	}
	
	

	public WebElement getNav_Service_ObjectTypeDropDownArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Service_ObjectTypeDropDownArrow;
	}

	public WebElement getNav_Network_GroupWebTableParent() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_GroupWebTableParent;
	}

	public WebElement getNav_GOMServiceHSServiceExpander() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_GOMServiceHSServiceExpander;
	}

	public WebElement getNav_GOMServiceCreateImg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_GOMServiceCreateImg;
	}

	

	public WebElement getNav_Service_ObjectTypeNewObjRadioBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Service_ObjectTypeNewObjRadioBtn;
	}

	public WebElement getNav_Service_ObjectTypeNewObjName() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Service_ObjectTypeNewObjName;
	}

	public WebElement getNav_Service_ObjectTypeNewObjTypeDropDownArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Service_ObjectTypeNewObjTypeDropDownArrow;
	}

	
	public WebElement getNav_Service_ObjectTypeServiceEndDropdownArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Service_ObjectTypeServiceEndDropdownArrow;
	}

	
	public WebElement getNav_Service_ObjectTypePortRangeStart() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Service_ObjectTypePortRangeStart;
	}

	public WebElement getNav_Service_ObjectTypePortRangeEnd() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Service_ObjectTypePortRangeEnd;
	}

	public WebElement getNav_Service_ObjectTypeTransferRight() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Service_ObjectTypeTransferRight;
	}
	
	

	public WebElement getNav_Network_ConfirmPopupOkBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_ConfirmPopupOkBtn;
	}

	public WebElement getNav_Network_FeedbackMsg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_FeedbackMsg;
	}

	public WebElement getNav_Service_ObjectTypeSaveBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Service_ObjectTypeSaveBtn;
	}

	public WebElement getNav_GOMServiceCreateWindow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_GOMServiceCreateWindow;
	}

	public WebElement getNav_Network_NetworkObjectWebTableParent() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_NetworkObjectWebTableParent;
	}

	public WebElement getNav_Service_CreateConfirmationTablRHS() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Service_CreateConfirmationTablRHS;
	}

	public WebElement getNav_Network_ConfirmPopupBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_ConfirmPopupBox;
	}

	public WebElement getNav_Network_CreateEditPopupBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_CreateEditPopupBox;
	}

	public WebElement getNav_GOMWindowClose() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_GOMWindowClose;
	}



	public WebElement getNav_Service_NewNameEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Service_NewNameEdit;
	}



	public WebElement getNav_Service_GrpDescTextArea() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Service_GrpDescTextArea;
	}



	public WebElement getNav_GOM_PDFIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_GOM_PDFIcon;
	}



	public WebElement getNav_GOM_CSVIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_GOM_CSVIcon;
	}



	public WebElement getNav_Service_ObjectTypeFromExistingGrp() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Service_ObjectTypeFromExistingGrp;
	}



	public WebElement getNav_Service_FromExistingGrpTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Service_FromExistingGrpTable;
	}



	public WebElement getNav_Network_ObjectTypeDropDownTextBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_ObjectTypeDropDownTextBox;
	}



	public WebElement getNav_Network_TypeDropDownTextBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_TypeDropDownTextBox;
	}



	public WebElement getNav_Network_EditObjectRadioBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_EditObjectRadioBtn;
	}



	public WebElement getNav_Network_SearchEditBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_SearchEditBox;
	}



	public WebElement getNav_Network_CloseBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_CloseBtn;
	}



	public WebElement getNav_Network_StartIpAddressColumnName() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_StartIpAddressColumnName;
	}



	public WebElement getNav_Network_EndIpAddressColumnName() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_EndIpAddressColumnName;
	}

	


	public WebElement getNav_Network_IPV6Title() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_IPV6Title;
	}



	public WebElement getNav_Network_NetmaskColumnName() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_NetmaskColumnName;
	}



	public WebElement getNav_Network_ObjectNatColumnName() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_ObjectNatColumnName;
	}



	public WebElement getNav_Network_DescriptionColumnName() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_DescriptionColumnName;
	}



	public WebElement getNav_Network_deletePopupBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_deletePopupBox;
	}



	public WebElement getNav_Network_ExistingObject_IpAddressColumnTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_ExistingObject_IpAddressColumnTitle;
	}



	public WebElement getNav_Network_ExisitingObject_NetmaskColumnTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_ExisitingObject_NetmaskColumnTitle;
	}



	public WebElement getNav_GOMServiceSearchEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_GOMServiceSearchEdit;
	}



	public WebElement getNav_Service_ObjectTypeCancelBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Service_ObjectTypeCancelBtn;
	}



	public WebElement getNav_GOMServiceMatchesFound() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_GOMServiceMatchesFound;
	}



	public WebElement getNav_Network_SearchMatchesCount() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Network_SearchMatchesCount;
	}



	public WebElement getNav_NetworkWebTableParent() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NetworkWebTableParent;
	}



	public WebElement getNav_Firewall_PDFIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Firewall_PDFIcon;
	}



	public WebElement getNav_Firewall_CSVIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Firewall_CSVIcon;
	}
	public WebElement getNav_EditButtonUnderNetwork() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditButtonUnderNetwork;
	}
	public WebElement getNav_CreateTicketLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateTicketLink;
	}
	public WebElement getNav_EditNatSaveRuleButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditNatSaveRuleButton;
	}
	public WebElement getNav_NatEdit_PublicIpAddressInputField() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NatEdit_PublicIpAddressInputField;
	}
	public WebElement getNav_NatEdit_InsideInterfaceDropDownArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NatEdit_InsideInterfaceDropDownArrow;
	}
	public WebElement getNav_NatEdit_PrivateIpAddressInputField() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NatEdit_PrivateIpAddressInputField;
	}
	public WebElement getNav_NatEdit_InsideInterfaceDropDownEditField() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NatEdit_InsideInterfaceDropDownEditField;
	}
	public WebElement getNav_NatEdit_OutsideInterfaceEditField() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NatEdit_OutsideInterfaceEditField;
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
	public WebElement getNav_UserAccessVPN_ResetPasswordBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_UserAccessVPN_ResetPasswordBtn;
	}
	public WebElement getNav_UserAccessVPN_ResetPasswordEditField() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_UserAccessVPN_ResetPasswordEditField;
	}
	public WebElement getNav_UserAccessVPN_DeleteBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_UserAccessVPN_DeleteBtn;
	}
	public WebElement getNav_SiteToSiteVPNsTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SiteToSiteVPNsTab;
	}
	public WebElement getNav_UserAccessVPN_WebTableParent() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_UserAccessVPN_WebTableParent;
	}
		
	
}
