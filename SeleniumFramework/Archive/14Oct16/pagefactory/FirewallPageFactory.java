package com.whs.navigator.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class FirewallPageFactory {

	// GOM -> Network objects 	
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
			
			
			@FindBy(how=How.XPATH, using="//div[@id='gom_nw_tree_panel-body']//img[contains(@class,'x-tree-expander')]")
			private WebElement nav_NetworkExpander;
			
			@FindBy(how=How.XPATH, using="//img[@data-qtip='Create']")
			private WebElement nav_CreateImageUnderNetworkObjects;
			
			@FindBy(how=How.XPATH,using="//div[@id='gom_details']/button[@class='close_icon']")
			private WebElement nav_GOMWindowClose;
			
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
			
			@FindBy(how=How.XPATH, using="//div[@id='navpopupbuttons']//a[@onclick='submitGOMRequest()']")
			//@FindBy(how=How.XPATH, using="//div[@id='navpopupbuttons']//a[contains(text(),'Ok')]")
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

			@FindBy(how=How.XPATH, using="//div[@id='gom_svc_tree_panel-body']//img[contains(@class,'x-tree-expander')]")
			private WebElement nav_ServiceExpander;
			
			@FindBy(how=How.ID, using="gom-svc-ei")
			private WebElement nav_ServiceObjectsExpander;
			
			// service objects
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
			
			//Search Input field
			@FindBy(how=How.ID,using="svcsearchtrigger-inputEl")
			private WebElement nav_GOMServiceSearchEdit;
			
			@FindBy(how=How.XPATH,using="//div[@id='svcsearchtrigger']/../div[contains(@id,'displayfield')]/div[contains(@id,'displayfield') and contains(@id,'bodyEl')]/div[contains(@id,'inputEl')]")
			private WebElement nav_GOMServiceMatchesFound;
			
			//////////////////Updated by QAA03 on 08/02/2016//////////////
			
			//Updated by QAA03 on 08/03/2016 
			@FindBy(how=How.ID, using="frPanel-13-body")
			//@FindBy(how=How.ID, using="add_firewall_rule")
			private WebElement nav_Interface1Table;
			
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			public WebElement getNav_GOMPopup() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_GOMPopup;
			}

			public WebElement getNav_GOMLink() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_GOMLink;
			}

			public WebElement getNav_Network_NetworkObjectWebTableParent() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_Network_NetworkObjectWebTableParent;
			}

			public WebElement getNav_NetworkObjectExpander() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_NetworkObjectExpander;
			}

			public WebElement getNav_GOM_PDFIcon() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_GOM_PDFIcon;
			}

			public WebElement getNav_GOM_CSVIcon() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_GOM_CSVIcon;
			}

			public WebElement getNav_NetworkExpander() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_NetworkExpander;
			}

			public WebElement getNav_CreateImageUnderNetworkObjects() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_CreateImageUnderNetworkObjects;
			}

			public WebElement getNav_GOMWindowClose() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_GOMWindowClose;
			}

			public WebElement getNav_Network_ObjectTypeDropDownArrow() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_Network_ObjectTypeDropDownArrow;
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

			public WebElement getNav_Network_FromExistingObjectsRadioBtn() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_Network_FromExistingObjectsRadioBtn;
			}

			public WebElement getNav_Network_ExistingObjectsWebTableParent() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_Network_ExistingObjectsWebTableParent;
			}

			public WebElement getNav_Network_ExistingObject_IpAddressColumnTitle() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_Network_ExistingObject_IpAddressColumnTitle;
			}

			public WebElement getNav_Network_ExisitingObject_NetmaskColumnTitle() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_Network_ExisitingObject_NetmaskColumnTitle;
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

			public WebElement getNav_Network_GroupWebTableParent() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_Network_GroupWebTableParent;
			}

			public WebElement getNav_Network_SaveBtn() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_Network_SaveBtn;
			}

			public WebElement getNav_Network_CancelBtn() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_Network_CancelBtn;
			}

			public WebElement getNav_Network_ConfirmPopupBox() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_Network_ConfirmPopupBox;
			}

			public WebElement getNav_Network_CreateEditPopupBox() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_Network_CreateEditPopupBox;
			}

			public WebElement getNav_Network_deletePopupBox() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_Network_deletePopupBox;
			}

			public WebElement getNav_Network_ConfirmPopupOkBtn() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_Network_ConfirmPopupOkBtn;
			}

			public WebElement getNav_Network_FeedbackMsg() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_Network_FeedbackMsg;
			}

			public WebElement getNav_Network_IPVersionTitle() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_Network_IPVersionTitle;
			}

			public WebElement getNav_Network_IPV4Radiobtn() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_Network_IPV4Radiobtn;
			}

			public WebElement getNav_Network_IPV6Title() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_Network_IPV6Title;
			}

			public WebElement getNav_Network_SearchEditBox() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_Network_SearchEditBox;
			}

			public WebElement getNav_Network_SearchMatchesCount() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_Network_SearchMatchesCount;
			}

			public WebElement getNav_NetworkWebTableParent() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_NetworkWebTableParent;
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

			public WebElement getNav_ServiceExpander() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_ServiceExpander;
			}

			public WebElement getNav_ServiceObjectsExpander() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_ServiceObjectsExpander;
			}

			public WebElement getNav_GOMText() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_GOMText;
			}

			public WebElement getNav_GOMServiceTableParent() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_GOMServiceTableParent;
			}

			public WebElement getNav_GOMServiceHSServiceExpander() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_GOMServiceHSServiceExpander;
			}

			public WebElement getNav_GOMServiceCreateImg() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_GOMServiceCreateImg;
			}

			public WebElement getNav_GOMServiceCreateWindow() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_GOMServiceCreateWindow;
			}

			public WebElement getNav_Service_ObjectTypeDropDownArrow() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_Service_ObjectTypeDropDownArrow;
			}

			public WebElement getNav_Service_FromExistingGrpTable() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_Service_FromExistingGrpTable;
			}

			public WebElement getNav_Service_ObjectTypeFromExistingGrp() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_Service_ObjectTypeFromExistingGrp;
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

			public WebElement getNav_Service_CreateConfirmationTablRHS() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_Service_CreateConfirmationTablRHS;
			}

			public WebElement getNav_Service_ObjectTypeSaveBtn() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_Service_ObjectTypeSaveBtn;
			}

			public WebElement getNav_Service_ObjectTypeCancelBtn() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_Service_ObjectTypeCancelBtn;
			}

			public WebElement getNav_Service_NewNameEdit() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_Service_NewNameEdit;
			}

			public WebElement getNav_Service_GrpDescTextArea() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_Service_GrpDescTextArea;
			}

			public WebElement getNav_GOMServiceSearchEdit() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_GOMServiceSearchEdit;
			}

			public WebElement getNav_GOMServiceMatchesFound() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_GOMServiceMatchesFound;
			}

			public WebElement getNav_Interface1Table() {
				FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
				return nav_Interface1Table;
			}
			
			
			
			
			
			
			
			
	
	
	
	
	
}
