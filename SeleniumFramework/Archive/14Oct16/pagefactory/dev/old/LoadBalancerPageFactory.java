package com.whs.navigator.pagefactory.dev.old;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class LoadBalancerPageFactory {

//// NMR
	// Home Page EVDC portlet
	@FindBy(how=How.XPATH, using="//div[@id='nav_org_maindev']//dt[text()='Load Balancers']")
	private WebElement navEVDCPortlet_LoadbalancerText;
	
	@FindBy(how=How.XPATH, using="//div[@id='nav_org_maindev']//dd[@id='info_loadbalancer']/a[contains(text(),'View')]")
	private WebElement navEVDCPortlet_LoadBalancer_ViewLink;
	
	/// EVDC Overview page Load balancers link
	@FindBy(how=How.LINK_TEXT, using="Load Balancers")
	private WebElement navEVDCOverviewLoadBalancersLink;

	/// virtualIp tab
	@FindBy(how=How.ID, using="virtualIPsTab")
	private WebElement navVirtualIpTab;
	
	@FindBy(how=How.XPATH, using="//div[@id='vips-page']//img[@alt='PDF']")
	private WebElement navVirtualIpTab_PDFIcon;
	
	@FindBy(how=How.XPATH, using="//div[@id='vips-page']//img[@alt='CSV']")
	private WebElement navVirtualIpTab_CSVIcon;
	
	// this element updated by QAA04 -- 02/15/2016
	@FindBy(how=How.XPATH, using="//div[@id='vips-page']//a[text()='Add VIP']")
	//@FindBy(how=How.LINK_TEXT, using="Add VIP")
	private WebElement navVirtualIpTab_AddVIPLink;
	
	@FindBy(how=How.ID, using="vipsPanel-body")
	private WebElement navVirtulIPTableParent;
	

/// common objects for all add pop up box elements 	
	@FindBy(how=How.ID, using="createTicketTitle-inputEl")
	private WebElement navPopUp_TitleEditBox;
	
	@FindBy(how=How.XPATH, using="//span[text()='OK']")
	private WebElement navPopUp_OkBtn;
	
	@FindBy(how=How.XPATH, using="//span[text()='Cancel']")
	private WebElement navPopUp_CancelBtn;
	
	@FindBy(how=How.XPATH, using="//div[@id='CreateTicketPopup_header-targetEl']//img[@class='x-tool-img x-tool-close']")
	private WebElement navPopUp_CloseBtn;
	
	//Common Ticket Object
	//Ticket popup
	@FindBy(how=How.ID,using="CreateTicketPopup-body")
	private WebElement nav_TicketPopUp;
	
	//Ticket popup Cancel btn
	@FindBy(how=How.XPATH,using="//div[@id='CreateTicketPopup']//span[text()='Cancel']")
	private WebElement nav_TicketpopupCancelBtn;
	
	@FindBy(how=How.XPATH,using="//iframe[contains(@id,'htmleditor')]")
	private WebElement nav_TicketNoteIframe;

	@FindBy(how=How.XPATH,using="//textarea[contains(@id,'htmleditor')]")
	private WebElement nav_TicketTextArea;
	
/// POOls Tab
	@FindBy(how=How.ID, using="poolsTab")
	private WebElement navPoolsTab;
	
	@FindBy(how=How.XPATH, using="//div[@id='ldblncr-pool-page']/div[@class='lb-header']//img[@alt='PDF']")
	private WebElement navPoolsTab_PDFIcon;
	
	// this element is updated by QAA04 -- 02/15/16
	@FindBy(how=How.XPATH, using="//div[@id='ldblncr-pool-page']/div[@class='lb-header']//img[@alt='CSV']")
	//@FindBy(how=How.XPATH, using="//div[@id='ldblncr-pool_header']//img[@alt='CSV']")
	private WebElement navPoolsTab_CSVIcon;
	
	@FindBy(how=How.XPATH, using="//div[@id='ldblncr-pool-page']//a[text()='Add a Load Balancer']")
	private WebElement navPoolsTab_AddLoadBalancerLink;
	
	@FindBy(how=How.ID, using="poolPanel-body")
	private WebElement navPoolsTableParent;
	
	@FindBy(how=How.ID, using="lbp-textEl")
	private WebElement navPools_LoadbalancerColumn;
	
	@FindBy(how=How.ID, using="nam-textEl")
	private WebElement navPools_NameColumn;
	
	@FindBy(how=How.ID, using="hc-textEl")
	private WebElement navPools_HealthCheckColumn;
	
	@FindBy(how=How.ID, using="pp-textEl")
	private WebElement navPools_PortProtocolColumn;
	
	@FindBy(how=How.ID, using="met-textEl")
	private WebElement navPools_MethodColumn;
	
	@FindBy(how=How.ID, using="sta-textEl")
	private WebElement navPools_StatusColumn;
	
	@FindBy(how=How.ID, using="des-textEl")
	private WebElement navPools_DescriptionColumn;
	
	@FindBy(how=How.LINK_TEXT, using="Add Member")
	private WebElement navPools_Exp_AddMemberLink;
	
	@FindBy(how=How.XPATH, using="//span[text()='Member']")
	private WebElement navPools_Exp_MemberColumn;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'poolMemPanel')]//span[text()='IP Address']")
	private WebElement navPools_Exp_IPAddColumn;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'poolMemPanel')]//span[text()='Status']")
	private WebElement navPools_Exp_StatusColumn;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'poolMemPanel')]//span[text()='Ratio']")
	private WebElement navPools_Exp_RatioColumn;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'poolMemPanel')]//div[contains(@id,'pagingtoolbar')][contains(@class,'x-box-target')]")
	private WebElement navPools_Exp_PaginationBar;
	
	@FindBy(how=How.LINK_TEXT,using="Add a Load Balancer")
	private WebElement navPools_AddLB;
	

/// Instances Tab
	@FindBy(how=How.ID, using="instanceTab")
	private WebElement navInstanceTab;
	
	@FindBy(how=How.XPATH, using="//div[@id='ldblncr-instance-page']//img[@alt='PDF']")
	private WebElement navInstanceTab_PDFIcon;
	
	@FindBy(how=How.XPATH, using="//div[@id='ldblncr-instance-page']//img[@alt='CSV']")
    private WebElement navInstanceTab_CSVIcon;
	

	@FindBy(how=How.XPATH, using="//div[@id='ldblncr-instance-page']//a[text()='Add a Load Balancer']")
	private WebElement navInstancesTab_AddLoadBalancerLink;
	
	@FindBy(how=How.ID, using="instancePanel-body")
	private WebElement navInstancesTableParent;

	@FindBy(how=How.ID, using="createTicketForm-outerCt")
	private WebElement navVirtualIp_AddVIPFrame;
	
	//Added by Vivek
	@FindBy(how=How.ID,using="lb-textEl")
	private WebElement navInstances_LoadBalasHeader;
	
	@FindBy(how=How.ID,using="lnk-textEl")
	private WebElement navInstances_LnkasHeader;
	
	@FindBy(how=How.ID,using="typ-textEl")
	private WebElement navInstances_TypeasHeader;
	
	@FindBy(how=How.ID,using="mtp-textEl")
	private WebElement navInstances_MaxThoughPutasHeader;
	
	//############################################################
	@FindBy(how=How.ID, using="loadBalancer-textEl")
	private WebElement navVirtualIP_LoadBalancerColumnHeader;
	
	@FindBy(how=How.ID, using="name-textEl")
	private WebElement navVirtualIP_NameColumnHeader;
	
	@FindBy(how=How.ID, using="ipAddress-textEl")
	private WebElement navVirtualIP_IpAddressCloumnHeader;
	
	@FindBy(how=How.ID, using="pool-textEl")
	private WebElement navVirtualIP_PoolColumnHeader;
	
	@FindBy(how=How.ID, using="portProtocol-textEl")
	private WebElement navVirtualIP_protocolColumnHeader;
	
	@FindBy(how=How.ID, using="description-textEl")
	private WebElement navVirtualIP_DescriptionColumnHeader;
	
	//*******************QAA03************************//
	
	@FindBy(how=How.LINK_TEXT,  using="Refresh Details")
	private WebElement nav_LB_Expander_RefreshDetailsLink;
	
	@FindBy(how=How.LINK_TEXT,  using="Edit")
	private WebElement nav_LB_Expander_EditLink;
	
	@FindBy(how=How.LINK_TEXT,  using="Delete")
	private WebElement nav_LB_Expander_DeleteLink;
	
	@FindBy(how=How.XPATH, using="//ul[@class='breadcrumbs lfr-component']")
	private WebElement nav_LoadBalancer_Breadcrumb;
	

	@FindBy(how=How.ID, using="poolName-inputEl")
	private WebElement nav_EditVIPPoolNamedropdownfield;
	
	@FindBy(how=How.ID, using="serverProfile-inputEl")
	private WebElement nav_EditVIPServerProfiledropdownfield;
	
	@FindBy(how=How.ID, using="clientProfile-inputWrap")
	private WebElement nav_EditVIPClientProfiledropdownfield;
	
	@FindBy(how=How.ID, using="servicePort-inputEl")
	private WebElement nav_EditVIPServicePortdropdownfield;
	
	@FindBy(how=How.ID, using="profile-inputEl")
	private WebElement nav_EditVIPProfiledropdownfield;
	
	@FindBy(how=How.ID, using="defaultPersistenceProfile-inputEl")
	private WebElement nav_EditVIPDefaultPersistencedropdownfield;
	
	@FindBy(how=How.ID, using="fallbackPersistenceProfile-inputEl")
	private WebElement nav_EditVIPFallBackProfiledropdownfield;
	
	@FindBy(how=How.ID, using="resetbtn")
	private WebElement nav_EditVIPResetButton;
	
	@FindBy(how=How.ID, using="submitBtn")
	private WebElement nav_EditVIPSubmitButton;
	
	@FindBy(how=How.ID, using="idCloseButton")
	private WebElement nav_EditVIPCloseButton;
	
	
	
////////////////////////////////////////////////////////////////////////////////
                      ////////////////////////////////////////////////////////////////////////////////////////
	
	public WebElement getNav_EditVIPPoolNamedropdownfield() {
		 FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditVIPPoolNamedropdownfield;
	}

	public WebElement getNav_EditVIPServerProfiledropdownfield() {
		 FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditVIPServerProfiledropdownfield;
	}


	public WebElement getNav_EditVIPClientProfiledropdownfield() {
		 FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditVIPClientProfiledropdownfield;
	}

	public WebElement getNav_EditVIPServicePortdropdownfield() {
		 FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditVIPServicePortdropdownfield;
	}

	public WebElement getNav_EditVIPProfiledropdownfield() {
		 FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditVIPProfiledropdownfield;
	}


	public WebElement getNav_EditVIPDefaultPersistencedropdownfield() {
		 FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditVIPDefaultPersistencedropdownfield;
	}


	public WebElement getNav_EditVIPFallBackProfiledropdownfield() {
		 FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditVIPFallBackProfiledropdownfield;
	}

	public WebElement getNav_EditVIPResetButton() {
		 FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditVIPResetButton;
	}

	public WebElement getNav_EditVIPSubmitButton() {
		 FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditVIPSubmitButton;
	}

	public WebElement getNav_EditVIPCloseButton() {
		 FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditVIPCloseButton;
	}
	
	public WebElement getNavVirtualIpTab() {
        FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navVirtualIpTab;
	}

	public WebElement getNavVirtualIpTab_PDFIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navVirtualIpTab_PDFIcon;
	}

	public WebElement getNavVirtualIpTab_CSVIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navVirtualIpTab_CSVIcon;
	}

	public WebElement getNavVirtualIpTab_AddVIPLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navVirtualIpTab_AddVIPLink;
	}

	public WebElement getNavVirtulIPTableParent() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navVirtulIPTableParent;
	}

	

	public WebElement getNavPopUp_TitleEditBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navPopUp_TitleEditBox;
	}

	public WebElement getNavPopUp_OkBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navPopUp_OkBtn;
	}

	public WebElement getNavPopUp_CancelBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navPopUp_CancelBtn;
	}

	public WebElement getNavPopUp_CloseBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navPopUp_CloseBtn;
	}

	public WebElement getNavPoolsTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navPoolsTab;
	}

	public WebElement getNavPoolsTab_PDFIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navPoolsTab_PDFIcon;
	}

	public WebElement getNavPoolsTab_CSVIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navPoolsTab_CSVIcon;
	}

	public WebElement getNavPoolsTab_AddLoadBalancerLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navPoolsTab_AddLoadBalancerLink;
	}

	public WebElement getNavPoolsTableParent() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navPoolsTableParent;
	}

	public WebElement getNavInstanceTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navInstanceTab;
	}

	public WebElement getNavInstanceTab_PDFIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navInstanceTab_PDFIcon;
	}

	public WebElement getNavInstanceTab_CSVIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navInstanceTab_CSVIcon;
	}

	public WebElement getNavInstancesTab_AddLoadBalancerLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navInstancesTab_AddLoadBalancerLink;
	}

	public WebElement getNavInstancesTableParent() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navInstancesTableParent;
	}

	public WebElement getNavVirtualIP_LoadBalancerColumnHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navVirtualIP_LoadBalancerColumnHeader;
	}

	public WebElement getNavVirtualIP_NameColumnHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navVirtualIP_NameColumnHeader;
	}

	public WebElement getNavVirtualIP_IpAddressCloumnHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navVirtualIP_IpAddressCloumnHeader;
	}

	public WebElement getNavVirtualIP_PoolColumnHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navVirtualIP_PoolColumnHeader;
	}

	public WebElement getNavVirtualIP_protocolColumnHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navVirtualIP_protocolColumnHeader;
	}

	public WebElement getNavVirtualIP_DescriptionColumnHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navVirtualIP_DescriptionColumnHeader;
	}

	public WebElement getNav_TicketPopUp() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketPopUp;
	}

	public WebElement getNav_TicketpopupCancelBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketpopupCancelBtn;
	}

	public WebElement getNavInstances_LoadBalasHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navInstances_LoadBalasHeader;
	}

	public WebElement getNavInstances_LnkasHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navInstances_LnkasHeader;
	}

	public WebElement getNavInstances_TypeasHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navInstances_TypeasHeader;
	}

	public WebElement getNavInstances_MaxThoughPutasHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navInstances_MaxThoughPutasHeader;
	}

	public WebElement getNav_LB_Expander_RefreshDetailsLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_LB_Expander_RefreshDetailsLink;
	}

	public WebElement getNav_LB_Expander_EditLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_LB_Expander_EditLink;
	}

	public WebElement getNav_LB_Expander_DeleteLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_LB_Expander_DeleteLink;
	}

	public WebElement getNav_LoadBalancer_Breadcrumb() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_LoadBalancer_Breadcrumb;
	}

	public WebElement getNavPools_LoadbalancerColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navPools_LoadbalancerColumn;
	}

	public WebElement getNavPools_NameColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navPools_NameColumn;
	}

	public WebElement getNavPools_HealthCheckColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navPools_HealthCheckColumn;
	}

	public WebElement getNavPools_PortProtocolColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navPools_PortProtocolColumn;
	}

	public WebElement getNavPools_MethodColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navPools_MethodColumn;
	}

	public WebElement getNavPools_StatusColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navPools_StatusColumn;
	}

	public WebElement getNavPools_DescriptionColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navPools_DescriptionColumn;
	}

	public WebElement getNavPools_Exp_AddMemberLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navPools_Exp_AddMemberLink;
	}

	public WebElement getNavPools_Exp_MemberColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navPools_Exp_MemberColumn;
	}

	public WebElement getNavPools_Exp_IPAddColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navPools_Exp_IPAddColumn;
	}

	public WebElement getNavPools_Exp_StatusColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navPools_Exp_StatusColumn;
	}

	public WebElement getNavPools_Exp_RatioColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navPools_Exp_RatioColumn;
	}

	public WebElement getNavPools_Exp_PaginationBar() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navPools_Exp_PaginationBar;
	}

	public WebElement getNav_TicketNoteIframe() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketNoteIframe;
	}

	public WebElement getNav_TicketTextArea() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketTextArea;
	}

	public WebElement getNavEVDCPortlet_LoadbalancerText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navEVDCPortlet_LoadbalancerText;
	}

	public WebElement getNavEVDCPortlet_LoadBalancer_ViewLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navEVDCPortlet_LoadBalancer_ViewLink;
	}

	public WebElement getNavPools_AddLB() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navPools_AddLB;
	}

	public WebElement getNavEVDCOverviewLoadBalancersLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navEVDCOverviewLoadBalancersLink;
	}

	public WebElement getNavVirtualIp_AddVIPFrame() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navVirtualIp_AddVIPFrame;
	}



	
	
     
}
