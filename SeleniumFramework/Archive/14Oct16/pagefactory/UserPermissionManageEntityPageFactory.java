package com.whs.navigator.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class UserPermissionManageEntityPageFactory {

	@FindBy(how=How.XPATH, using="//section[@id='portlet_OrgSelector_WAR_orgselectorhookportlet']//select[@name='orgId']")
	private WebElement nav_MultiOrgDropDown;
	
	@FindBy(how=How.XPATH, using="//section[@id='portlet_OrgSelector_WAR_orgselectorhookportlet']//input[@value='Use this Organization']")
	private WebElement nav_UseOrgButton;  

	

	//Duplicate-Updated-11/16/2015
	/*@FindBy(how=How.XPATH, using="//li[@id='organization']/a")
	private WebElement nav_Home_OrgDropDown;*/
	
	
	
	
	
	
	
	
	
	//Created method for this selection
	/*@FindBy(how=How.XPATH, using="//table[@id='orgListForUM-triggerWrap']//td[contains(@id,'ext-gen')]")
	private WebElement nav_SelectOrgDropDown;*/
	

////////Manage Entities tab
	//Duplicate -Updated-11/16/2015
	@FindBy(how=How.XPATH, using="//span[text()='Manage Entities']")  
    private WebElement nav_Users_ManageEntityTab;
// updated by --QAA04  12/15/15
	@FindBy(how=How.ID, using="idENENtitiesTreePanel-body")
   // @FindBy(how=How.XPATH, using="//table[contains(@class,'x-treeview-')]")
    private WebElement Nav_Users_ManageEntityTable;
    
////////Manage Entity edit box
   	@FindBy(how=How.ID, using="idENExpandAllCB-bodyEl")
   	private WebElement nav_ManageEntityEdit_ExpandAllTitle;
   	
   	@FindBy(how=How.ID, using="idENExpandAllCB-inputEl")
   	private WebElement nav_ManageEntityEdit_ExpandAllCheckbox;

 	@FindBy(how=How.XPATH, using="//div[@id='idENENtitiesTreePanel']//table[1]")
   	private WebElement nav_ManageEntityTableRow;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Catalogs']")
   	//@FindBy(how=How.XPATH, using="//div[@id='idENPermissionsTree-body']//span[text()='Catalogs']")
   	private WebElement nav_ManageEntityEdit_CatalogsTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='View Catalogs']")
   	private WebElement nav_ManageEntityEdit_Catalogs_ViewCatalogsTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Edit Catalog Item']")
   	private WebElement nav_ManageEntityEdit_Catalogs_EditCatalogItemTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Create Catalog Item']")
   	private WebElement nav_ManageEntityEdit_Catalogs_CreateCatalogItemTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Upload new image to catalog']")
   	private WebElement nav_ManageEntityEdit_Catalogs_UploadNewImagetoCatalogTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Copy Catalog Item']")
   	private WebElement nav_ManageEntityEdit_Catalogs_CopyCatalogItemTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Delete Catalog Item']")
   	private WebElement  nav_ManageEntityEdit_Catalogs_DeleteCatalogItemTitle;
   	
   	
   	@FindBy(how=How.XPATH, using="//span[text()='DRaaS']")
   	private WebElement  nav_ManageEntityEdit_DRaaSTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='View DRaaS']")
   	private WebElement nav_ManageEntityEdit_DRaaS_ViewDRaaSTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Edit DRaaS']")
   	private WebElement nav_ManageEntityEdit_DRaaS_EditDRaaSTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Delete DRaaS']")
   	private WebElement nav_ManageEntityEdit_DRaaS_DeleteDRaaSTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='EVDC Overview']")
   	private WebElement nav_ManageEntityEdit_EVDCOverviewTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='View EVDC']")
   	private WebElement nav_ManageEntityEdit_EVDCOverview_ViewEVDCTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Edit EVDC']")
   	private WebElement nav_ManageEntityEdit_EVDCOverview_EditEVDCTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Create EVDC']")
   	private WebElement nav_ManageEntityEdit_EVDCOverview_CreateEVDCTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Access vCloud Director']")
   	private WebElement nav_ManageEntityEdit_EVDCOverview_AccessvCloudDirectorTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Firewall']")
   	private WebElement nav_ManageEntityEdit_FirewallTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='View Firewall Rules']")
   	private WebElement nav_ManageEntityEdit_Firewall_ViewFirewallRulesTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Edit Firewall Rules']")
   	private WebElement nav_ManageEntityEdit_Firewall_EditFirewallRulesTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Add Firewall Rules']")
   	private WebElement nav_ManageEntityEdit_Firewall_AddFirewallRulesTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Delete Firewall Rules']")
   	private WebElement nav_ManageEntityEdit_Firewall_DeleteFirewallRulesTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='LoadBalancer']")
   	private WebElement nav_ManageEntityEdit_LoadBalancerTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='View Loadbalancers']")
   	private WebElement nav_ManageEntityEdit_LoadBalancer_ViewLoadbalancersTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Edit Loadbalancers']")
   	private WebElement nav_ManageEntityEdit_LoadBalancer_EditLoadbalancersTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Add Loadbalancers']")
   	private WebElement nav_ManageEntityEdit_LoadBalancer_AddLoadbalancersTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Log Viewer Portlet']")
   	private WebElement nav_ManageEntityEdit_LogViewerPortletTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='View Logs']")
   	private WebElement nav_ManageEntityEdit_LogViewerPortlet_ViewLogsTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Others']")
   	private WebElement nav_ManageEntityEdit_OthersTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Enable Monitoring']")
   	private WebElement nav_ManageEntityEdit_Others_EnableMonitoringTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Disable Monitoring']")
   	private WebElement nav_ManageEntityEdit_Others_DisableMonitoringTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Subscribe to new Product/Service (e.g. OS Management)']")
   	private WebElement nav_ManageEntityEdit_Others_SubscribetoNewProductTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Access Forms']")
   	private WebElement nav_ManageEntityEdit_Others_AccessFormsTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Access EM7']")
   	private WebElement nav_ManageEntityEdit_Others_AccessEM7Title;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='View Reports']")
   	private WebElement nav_ManageEntityEdit_Others_ViewReportsTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Can whitelabel']")
   	private WebElement nav_ManageEntityEdit_Others_CanWhitelabelTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Permissions']")
   	private WebElement nav_ManageEntityEdit_PermissionsTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='View Permissions']")
   	private WebElement nav_ManageEntityEdit_Permissions_ViewPermissionsTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Edit Permissions']")
   	private WebElement nav_ManageEntityEdit_Permissions_EditPermissionsTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Tenancy']")
   	private WebElement nav_ManageEntityEdit_TenancyTitle;
   	
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Can See children / Can use ORG browser']")
   	private WebElement nav_ManageEntityEdit_Tenancy_CanSeeChildrenTitle;
   	
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Can manage children']")
   	private WebElement nav_ManageEntityEdit_Tenancy_CanManageChildrenTitle;
   	
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Can see roll-up']")
   	private WebElement nav_ManageEntityEdit_Tenancy_CanSeeRollUpTitle;
   	
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Tickets']")
   	private WebElement nav_ManageEntityEdit_TicketsTitle;
   	
   	
   	@FindBy(how=How.XPATH, using="//span[text()='View tickets']")
   	private WebElement nav_ManageEntityEdit_Tickets_ViewTicketsTitle;
   	
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Edit tickets/Add Attachments']")
   	private WebElement nav_ManageEntityEdit_Tickets_EditTicketsTitle;
   	
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Create Tickets']")
   	private WebElement nav_ManageEntityEdit_Tickets_CreateTicketsTitle;
   	
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Access Detailed Ticketing System']")
   	private WebElement nav_ManageEntityEdit_Tickets_AccessDetailedTicktingTitle;
   	
   	
   	@FindBy(how=How.XPATH, using="//span[text()='User Info']")
   	private WebElement nav_ManageEntityEdit_UserInfoTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Add User']")
   	private WebElement nav_ManageEntityEdit_UserInfo_AddUserTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Delete User']")
   	private WebElement nav_ManageEntityEdit_UserInfo_DeleteUserTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Edit User']")
   	private WebElement  nav_ManageEntityEdit_UserInfo_EditUserTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Reset Password']")
   	private WebElement nav_ManageEntityEdit_UserInfo_ResetPasswordTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Virtual Machines']")
   	private WebElement nav_ManageEntityEdit_VirtualMechinesTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='View VMs']")
   	private WebElement nav_ManageEntityEdit_VirtualMechines_ViewVMsTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='VM Controls (Start/Stop/Suspend/Reset/KVM)']")
   	private WebElement nav_ManageEntityEdit_VirtualMechines_VMControlsTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Edit VM']")
   	private WebElement nav_ManageEntityEdit_VirtualMechines_EditVMTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Add VM']")
   	private WebElement nav_ManageEntityEdit_VirtualMechines_AddVMTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Delete VM']")
   	private WebElement nav_ManageEntityEdit_VirtualMechines_DeleteVMTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Clone a VM']")
   	private WebElement nav_ManageEntityEdit_VirtualMechines_CloneaVMTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Clone a VM to Catalog Item']")
   	private WebElement nav_ManageEntityEdit_VirtualMechines_CloneaVMtoCatalogVMTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Add VM to monitoring']")
   	private WebElement nav_ManageEntityEdit_VirtualMechines_AddVMtoMonotoringTitle; 
   	
   	@FindBy(how=How.XPATH, using="//span[text()='VPN']")
   	private WebElement nav_ManageEntityEdit_VPNTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='View User VPNs']")
   	private WebElement nav_ManageEntityEdit_VPN_ViewUserVPNsTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Edit User VPNs']")
   	private WebElement nav_ManageEntityEdit_VPN_EditUserVPNsTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Add VPNs']")
   	private WebElement nav_ManageEntityEdit_VPN_AddVPNsTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Reset VPN password']")
   	private WebElement nav_ManageEntityEdit_VPN_ResetAddVPNTitle;
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Reset']")
   	private WebElement nav_ManageEntityEdit_ResetBtn; 
   	
   	@FindBy(how=How.XPATH, using="//span[text()='Save']")
   	private WebElement nav_ManageEntityEdit_SaveBtn;
   
   	//This element is common for Edit and Copy buttons under Manage Entity
   	@FindBy(how=How.XPATH, using="//span[text()='Cancel']")
   	private WebElement nav_ManageEntity_CancelBtn;
   	
   	@FindBy(how=How.XPATH, using="//label[text()='Cascade to Children']")
   	private WebElement nav_ManageEntityEdit_CascadetoChildrenTitle;

   	
   	//Vivek
   	@FindBy(how=How.XPATH,using="//img[@class='closeicon']")
	private WebElement nav_EM_Edit_CloseIcon;
   	
   	@FindBy(how=How.ID,using="idECCascadeCB-inputEl")
   	private WebElement nav_EM_Copy_CascadeChkBox;
   	
//// Firewall
   	@FindBy(how=How.XPATH, using="//div[contains(@id,'container-')]//div[contains(@id,'-msg')]")
	private WebElement nav_EVDCErrorMsg;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'-toolbar')]//span[contains(text(),'Yes')]")
	private WebElement nav_EVDCErrorOkBtn;
	
	
////SLP PageFactory	
	
	
	@FindBy(how=How.XPATH, using="//div[@id='idENENtitiesTreePanel-body']")
	private WebElement nav_ManageEntityParentWebTable;	
	
	/*@FindBy(how=How.XPATH, using="//tr[contains(@class,' x-grid-row-focused')]//img[contains(@class,'x-tree-expander')]")
	private WebElement nav_Users_MngeEntityOrgExpander;*/
	
	//Duplicate - updated - 11/16/2015
	/*@FindBy(how=How.ID, using="orgListForUM-inputEl")
	private WebElement nav_Users_SelectOrgEdit;*/
	
	
	
	@FindBy(how=How.ID, using="idENCopyWindow-innerCt")
	private WebElement Nav_ManageEntity_CopyWindow;
//Vivek
	
	@FindBy(how=How.XPATH,using="//div[contains(@id,'treepicker-') and contains(@id,'-bodyEl')]//input[contains(@id,'-inputE')]")
	private WebElement nav_ManageEntityCopyEdit;
	
	@FindBy(how=How.XPATH,using="//span[contains(@id,'rebutton')][text()='Submit']")
	private WebElement nav_CopyDialogSubmitBtn;
	
	@FindBy(how=How.XPATH,using="//input[contains(@id,'inputEl')][@name='copyToEntityId']/../..//div[contains(@id,'-trigger-picker')]")
	private WebElement nav_DestEntityDropDownArrow;
	
	@FindBy(how=How.ID,using="idTreePanelPickerTree-body")
	private WebElement nav_CopyDestParentWebTable;
	
	//Added by Sukur. Need to remove once Arul's Edit Entity method is ready
	@FindBy(how=How.XPATH, using="//table[1]//div/img[contains(@src,'Edit_Button_Icon.png')]")
	private WebElement nav_EditEntityFirstRowImg;
	
	@FindBy(how=How.XPATH, using="//section[@id='user_management']//table[165]")
	private WebElement nav_EditEntityTstentity01Table;

	@FindBy(how=How.XPATH, using="//section[@id='user_management']//table[165]//img[contains(@src,'Edit')]")
	private WebElement nav_EditEntityTstentity01Img;

	@FindBy(how=How.XPATH, using="//section[@id='user_management']//span[text()='TST Entity01']//..//img[2]")
	private WebElement nav_EditEntityTstentity01ExpandImg;
	
	@FindBy(how=How.ID, using="idENCascadeCB-inputEl")
	private WebElement nav_EditEntityCascadeToChilderenCheckBox;
	
	@FindBy(how=How.XPATH, using="//div[@id='idENTbOuterPanelDockedItems-targetEl']//a[contains(@class,'csvButton')]")
	private WebElement nav_ManageEntityCSVIconImg;
	
	@FindBy(how=How.XPATH, using="//div[@id='idENTbOuterPanelDockedItems-targetEl']//a[contains(@class,'pdfButton')]")
	private WebElement nav_ManageEntityPDFIconImg;
	
	
	
	public WebElement getNav_ManageEntityCSVIconImg() {
		FrameworkUtil.sElementName=Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityCSVIconImg;
	}
	
	public WebElement getNav_ManageEntityPDFIconImg() {
		FrameworkUtil.sElementName=Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityPDFIconImg;
	}
	
	public WebElement getNav_EditEntityTstentity01Table() {
		FrameworkUtil.sElementName=Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditEntityTstentity01Table;
	}

	
	public WebElement getNav_EditEntityCascadeToChilderenCheckBox() {
		FrameworkUtil.sElementName=Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditEntityCascadeToChilderenCheckBox;
}
	public WebElement getNav_EditEntityTstentity01Img() {
		FrameworkUtil.sElementName=Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditEntityTstentity01Img;
	}
	
	public WebElement getNav_EditEntityTstentity01ExpandImg() {
		FrameworkUtil.sElementName=Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditEntityTstentity01ExpandImg;
}
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	public WebElement getNav_MultiOrgDropDown() {
		FrameworkUtil.sElementName=Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_MultiOrgDropDown;
	}

	public WebElement getNav_UseOrgButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_UseOrgButton;
	}



	/*public WebElement getNav_Home_OrgDropDown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Home_OrgDropDown;
	}*/

	

	

	/*public WebElement getNav_SelectOrgDropDown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SelectOrgDropDown;
	}*/

	public WebElement getNav_Users_ManageEntityTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Users_ManageEntityTab;
	}

	public WebElement getNav_Users_ManageEntityTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return Nav_Users_ManageEntityTable;
	}

	public WebElement getNav_ManageEntityEdit_ExpandAllTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_ExpandAllTitle;
	}

	public WebElement getNav_ManageEntityEdit_ExpandAllCheckbox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_ExpandAllCheckbox;
	}

	public WebElement getNav_ManageEntityTableRow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityTableRow;
	}

	public WebElement getNav_ManageEntityEdit_CatalogsTitle() { 
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_CatalogsTitle;
	}        ///getNav_ManageEnetityEdit_CatalogsTitle

	public WebElement getNav_ManageEntityEdit_Catalogs_ViewCatalogsTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_Catalogs_ViewCatalogsTitle;
	}

	public WebElement getNav_ManageEntityEdit_Catalogs_EditCatalogItemTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_Catalogs_EditCatalogItemTitle;
	}

	public WebElement getNav_ManageEntityEdit_Catalogs_CreateCatalogItemTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_Catalogs_CreateCatalogItemTitle;
	}

	public WebElement getNav_ManageEntityEdit_Catalogs_UploadNewImagetoCatalogTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_Catalogs_UploadNewImagetoCatalogTitle;
	}

	public WebElement getNav_ManageEntityEdit_Catalogs_CopyCatalogItemTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_Catalogs_CopyCatalogItemTitle;
	}

	public WebElement getNav_ManageEntityEdit_Catalogs_DeleteCatalogItemTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_Catalogs_DeleteCatalogItemTitle;
	}

	public WebElement getNav_ManageEntityEdit_DRaaSTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_DRaaSTitle;
	}

	public WebElement getNav_ManageEntityEdit_DRaaS_ViewDRaaSTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_DRaaS_ViewDRaaSTitle;
	}

	public WebElement getNav_ManageEntityEdit_DRaaS_EditDRaaSTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_DRaaS_EditDRaaSTitle;
	}

	public WebElement getNav_ManageEntityEdit_DRaaS_DeleteDRaaSTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_DRaaS_DeleteDRaaSTitle;
	}

	public WebElement getNav_ManageEntityEdit_EVDCOverviewTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_EVDCOverviewTitle;
	}

	public WebElement getNav_ManageEntityEdit_EVDCOverview_ViewEVDCTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_EVDCOverview_ViewEVDCTitle;
	}

	public WebElement getNav_ManageEntityEdit_EVDCOverview_EditEVDCTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_EVDCOverview_EditEVDCTitle;
	}

	public WebElement getNav_ManageEntityEdit_EVDCOverview_CreateEVDCTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_EVDCOverview_CreateEVDCTitle;
	}

	public WebElement getNav_ManageEntityEdit_EVDCOverview_AccessvCloudDirectorTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_EVDCOverview_AccessvCloudDirectorTitle;
	}

	public WebElement getNav_ManageEntityEdit_FirewallTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_FirewallTitle;
	}

	public WebElement getNav_ManageEntityEdit_Firewall_ViewFirewallRulesTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_Firewall_ViewFirewallRulesTitle;
	}

	public WebElement getNav_ManageEntityEdit_Firewall_EditFirewallRulesTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_Firewall_EditFirewallRulesTitle;
	}

	public WebElement getNav_ManageEntityEdit_Firewall_AddFirewallRulesTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_Firewall_AddFirewallRulesTitle;
	}

	public WebElement getNav_ManageEntityEdit_Firewall_DeleteFirewallRulesTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_Firewall_DeleteFirewallRulesTitle;
	}

	public WebElement getNav_ManageEntityEdit_LoadBalancerTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_LoadBalancerTitle;
	}

	public WebElement getNav_ManageEntityEdit_LoadBalancer_ViewLoadbalancersTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_LoadBalancer_ViewLoadbalancersTitle;
	}

	public WebElement getNav_ManageEntityEdit_LoadBalancer_EditLoadbalancersTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_LoadBalancer_EditLoadbalancersTitle;
	}

	public WebElement getNav_ManageEntityEdit_LoadBalancer_AddLoadbalancersTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_LoadBalancer_AddLoadbalancersTitle;
	}

	public WebElement getNav_ManageEntityEdit_LogViewerPortletTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_LogViewerPortletTitle;
	}

	public WebElement getNav_ManageEntityEdit_LogViewerPortlet_ViewLogsTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_LogViewerPortlet_ViewLogsTitle;
	}

	public WebElement getNav_ManageEntityEdit_OthersTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_OthersTitle;
	}

	public WebElement getNav_ManageEntityEdit_Others_EnableMonitoringTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_Others_EnableMonitoringTitle;
	}

	public WebElement getNav_ManageEntityEdit_Others_DisableMonitoringTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_Others_DisableMonitoringTitle;
	}

	public WebElement getNav_ManageEntityEdit_Others_SubscribetoNewProductTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_Others_SubscribetoNewProductTitle;
	}

	public WebElement getNav_ManageEntityEdit_Others_AccessFormsTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_Others_AccessFormsTitle;
	}

	public WebElement getNav_ManageEntityEdit_Others_AccessEM7Title() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_Others_AccessEM7Title;
	}

	public WebElement getNav_ManageEntityEdit_Others_ViewReportsTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_Others_ViewReportsTitle;
	}

	public WebElement getNav_ManageEntityEdit_Others_CanWhitelabelTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_Others_CanWhitelabelTitle;
	}

	public WebElement getNav_ManageEntityEdit_PermissionsTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_PermissionsTitle;
	}

	public WebElement getNav_ManageEntityEdit_Permissions_ViewPermissionsTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_Permissions_ViewPermissionsTitle;
	}

	public WebElement getNav_ManageEntityEdit_Permissions_EditPermissionsTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_Permissions_EditPermissionsTitle;
	}

	public WebElement getNav_ManageEntityEdit_TenancyTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_TenancyTitle;
	}

	public WebElement getNav_ManageEntityEdit_Tenancy_CanSeeChildrenTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_Tenancy_CanSeeChildrenTitle;
	}

	public WebElement getNav_ManageEntityEdit_Tenancy_CanManageChildrenTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_Tenancy_CanManageChildrenTitle;
	}

	public WebElement getNav_ManageEntityEdit_Tenancy_CanSeeRollUpTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_Tenancy_CanSeeRollUpTitle;
	}

	public WebElement getNav_ManageEntityEdit_TicketsTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_TicketsTitle;
	}

	public WebElement getNav_ManageEntityEdit_Tickets_ViewTicketsTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_Tickets_ViewTicketsTitle;
	}

	public WebElement getNav_ManageEntityEdit_Tickets_EditTicketsTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_Tickets_EditTicketsTitle;
	}

	public WebElement getNav_ManageEntityEdit_Tickets_CreateTicketsTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_Tickets_CreateTicketsTitle;
	}

	public WebElement getNav_ManageEntityEdit_Tickets_AccessDetailedTicktingTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_Tickets_AccessDetailedTicktingTitle;
	}

	public WebElement getNav_ManageEntityEdit_UserInfoTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_UserInfoTitle;
	}

	public WebElement getNav_ManageEntityEdit_UserInfo_AddUserTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_UserInfo_AddUserTitle;
	}

	public WebElement getNav_ManageEntityEdit_UserInfo_DeleteUserTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_UserInfo_DeleteUserTitle;
	}

	public WebElement getNav_ManageEntityEdit_UserInfo_EditUserTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_UserInfo_EditUserTitle;
	}

	public WebElement getNav_ManageEntityEdit_UserInfo_ResetPasswordTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_UserInfo_ResetPasswordTitle;
	}

	public WebElement getNav_ManageEntityEdit_VirtualMechinesTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_VirtualMechinesTitle;
	}

	public WebElement getNav_ManageEntityEdit_VirtualMechines_ViewVMsTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_VirtualMechines_ViewVMsTitle;
	}

	public WebElement getNav_ManageEntityEdit_VirtualMechines_VMControlsTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_VirtualMechines_VMControlsTitle;
	}

	public WebElement getNav_ManageEntityEdit_VirtualMechines_EditVMTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_VirtualMechines_EditVMTitle;
	}

	public WebElement getNav_ManageEntityEdit_VirtualMechines_AddVMTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_VirtualMechines_AddVMTitle;
	}

	public WebElement getNav_ManageEntityEdit_VirtualMechines_DeleteVMTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_VirtualMechines_DeleteVMTitle;
	}

	public WebElement getNav_ManageEntityEdit_VirtualMechines_CloneaVMTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_VirtualMechines_CloneaVMTitle;
	}

	public WebElement getNav_ManageEntityEdit_VirtualMechines_CloneaVMtoCatalogVMTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_VirtualMechines_CloneaVMtoCatalogVMTitle;
	}

	public WebElement getNav_ManageEntityEdit_VirtualMechines_AddVMtoMonotoringTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_VirtualMechines_AddVMtoMonotoringTitle;
	}

	public WebElement getNav_ManageEntityEdit_VPNTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_VPNTitle;
	}

	public WebElement getNav_ManageEntityEdit_VPN_ViewUserVPNsTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_VPN_ViewUserVPNsTitle;
	}

	public WebElement getNav_ManageEntityEdit_VPN_EditUserVPNsTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_VPN_EditUserVPNsTitle;
	}

	public WebElement getNav_ManageEntityEdit_VPN_AddVPNsTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_VPN_AddVPNsTitle;
	}

	public WebElement getNav_ManageEntityEdit_VPN_ResetAddVPNTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_VPN_ResetAddVPNTitle;
	}

	public WebElement getNav_ManageEntityEdit_ResetBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_ResetBtn;
	}

	public WebElement getNav_ManageEntityEdit_SaveBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_SaveBtn;
	}

	public WebElement getNav_ManageEntity_CancelBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntity_CancelBtn;
	}

	public WebElement getNav_ManageEntityEdit_CascadetoChildrenTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityEdit_CascadetoChildrenTitle;
	}

	public WebElement getNav_EVDCErrorMsg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCErrorMsg;
	}

	public WebElement getNav_EVDCErrorOkBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCErrorOkBtn;
	}

	

	public WebElement getNav_ManageEntityParentWebTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityParentWebTable;
	}

	/*public WebElement getNav_Users_MngeEntityOrgExpander() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Users_MngeEntityOrgExpander;
	}*/

	/*public WebElement getNav_Users_SelectOrgEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Users_SelectOrgEdit;
	}*/

	
	
	public WebElement getNav_EditEntityFirstRowImg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditEntityFirstRowImg;
	}

	public WebElement getNav_CopyDialogSubmitBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CopyDialogSubmitBtn;
	}

	public WebElement getNav_DestEntityDropDownArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DestEntityDropDownArrow;
	}


	public WebElement getNav_CopyDestParentWebTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CopyDestParentWebTable;
	}


	public WebElement getNav_ManageEntity_CopyWindow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return Nav_ManageEntity_CopyWindow;
	}

	public WebElement getNav_EM_Edit_CloseIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EM_Edit_CloseIcon;
	}

	public WebElement getNav_EM_Copy_CascadeChkBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EM_Copy_CascadeChkBox;
	}

	public WebElement getNav_ManageEntityCopyEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageEntityCopyEdit;
	}

	
	
	
	
	
	
	
	
	
}
