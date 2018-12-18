package com.whs.navigator.pagefactory.dev.old;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class SmokeTestPageFactory {

	//draas
	@FindBy(how=How.ID,using="draas")
	private WebElement nav_DraasPortlet;
	
	@FindBy(how=How.ID, using="draasLink")
	private WebElement nav_DraasLink;
	
	@FindBy(how=How.ID, using="idHBRPanel_header_hd-textEl")
	private WebElement nav_HosBasedReplicationText;
	
	//updated pf as part of extjs5 on 1st OCt 2015 by Arul
	//@FindBy(how=How.ID, using="idMoreDraasPdtsPanel_header_hd-textEl")
	@FindBy(how=How.ID, using="idMoreDraasPdtsPanel_header-innerCt")
	private WebElement nav_MoreDraasProducts;
	
	//tickets
	@FindBy(how=How.ID,using="tickets")
	private WebElement nav_TicketsPortlet;
	
	//@FindBy(how=How.LINK_TEXT, using="tickets")
	@FindBy(how=How.XPATH, using="//section[@id='tickets']//h2/a[text()='tickets']")
	private WebElement nav_TicketsLink;
	
	@FindBy(how=How.ID,using="searchByCombo-inputEl")
	private WebElement nav_SearchByWebList;
	
	@FindBy(how=How.ID,using="idCreateTicketButton-btnInnerEl")
	private WebElement nav_CreateTicketLink;
	
	
	//devices/alerts
	@FindBy(how=How.ID,using="devices_section")
	private WebElement nav_DevicesAlertsPortlet;
	
	//@FindBy(how=How.LINK_TEXT, using="devices/alerts")
	@FindBy(how=How.XPATH, using="//section[@id='devices_section']//h2/a[text()='devices/alerts']")
	private WebElement nav_DevicesAlertsLink;
	
	@FindBy(how=How.ID, using="submit")
	private WebElement nav_EM7_SignInBtn;
	
	
	
	//bandwidth
	@FindBy(how=How.ID,using="bandwidth")
	private WebElement nav_BandwidthPortlet;
	
	//@FindBy(how=How.LINK_TEXT, using="bandwidth")
	@FindBy(how=How.XPATH, using="//section[@id='bandwidth']//h2/a[text()='bandwidth']")
	private WebElement nav_BandwidthLink;
	
	@FindBy(how=How.XPATH, using=".//div[@id='mainReportContainer']//span[text()='Network Reports']")
	private WebElement nav_NetworkReportsText;
	
	@FindBy(how=How.XPATH, using="//div[@id='BandwidthReportPortletDiv']/div/table[1]/tbody/tr[1]/td/div")
	private WebElement nav_NetworkFirstGraphHeader;
	
	//announcements
	@FindBy(how=How.ID,using="announcements")
	private WebElement nav_AnnouncementsPortlet;
	
	//@FindBy(how=How.LINK_TEXT, using="announcements")
	@FindBy(how=How.XPATH, using="//div[@id='announcements']//h2/a[text()='announcements']")
	private WebElement nav_AnnouncementsLink;
	
	@FindBy(how=How.XPATH, using="//div[@id='NotificationsPortletDiv']//div[text()='Show Calendar']")
	private WebElement nav_ShowCalendarBtn;
	
	@FindBy(how=How.ID,using="idANViewCalButton")
	private WebElement nav_ViewCalender;
	
	
	//contact us
	@FindBy(how=How.ID,using="contact")
	private WebElement nav_ContactPortlet;
	
	//@FindBy(how=How.LINK_TEXT, using="contact us")
	@FindBy(how=How.XPATH, using="//section[@id='contact']//h2/a[text()='contact us']")
	private WebElement nav_ContactUsLink;
	
	//updated as part of extjs5 on 10/01/1025 by Arul
	//@FindBy(how=How.XPATH, using="//div[contains(@id,'ext-comp-')]//span[text()='Create Ticket']")
	@FindBy(how=How.XPATH,using="//div[contains(@id,'title') and text()='Create Ticket']")
	private WebElement nav_CreateTicketHeader;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'ext-comp-')]//span[text()='Cancel']")
	private WebElement nav_CreateTicketCancelBtn;
	
	
	//Feedback

	
	//@FindBy(how=How.LINK_TEXT, using="Feedback")
	@FindBy(how=How.XPATH, using="//section[@id='feedback']//h2/a[text()='Feedback']")
	private WebElement nav_FeedbackLink;
	
	//updated as part of extjs5 on 10/01/1025 by Arul
	//@FindBy(how=How.XPATH, using="//div[contains(@id,'createTicketPopup-')]//span[text()='Feedback']")
	@FindBy(how=How.XPATH, using="//div[contains(@id,'title') and text()='Feedback']")
	private WebElement nav_FeedbackHeader;
	
	//updated as part of extjs5 on 10/26/1025 by Arul
	//@FindBy(how=How.XPATH, using="//div[contains(@id,'createTicketPopup-')]//span[text()='Cancel']")
	@FindBy(how=How.XPATH, using="//span[contains(@id,'button-') and text()='Cancel']")
	private WebElement nav_FeedbackCancelBtn;
	
	
	//EVDC
	@FindBy(how=How.XPATH, using="//main/div/section[1][@class='rectangle long evdc']")
	private WebElement nav_EVDCPortlet;
	
	//@FindBy(how=How.XPATH, using="//main/div/section[1][@class='rectangle long evdc']//h2[@id='edvc_1']/a")
	@FindBy(how=How.XPATH, using="//div[contains(@id,'-innerCt')]/section[1]//h2[@id='edvc_1']/a")
	private WebElement nav_EVDCLink;
	
	
	//@FindBy(how=How.XPATH, using="//main/div/section[1][@class='rectangle long evdc']//a[text()='vCloud Director']")
	@FindBy(how=How.XPATH, using="//div[contains(@id,'-innerCt')]/section[1][@class='rectangle long evdc']//a[text()='vCloud Director']")
	private WebElement nav_vCloudDirectorLink;
	
	@FindBy(how=How.LINK_TEXT, using="Purchase Additional Cloud EVDC")
	private WebElement nav_PurchaseEVDCLink;
	
	@FindBy(how=How.XPATH, using="//div[@class='select_evdc']//li[@class='evdc_options']")
	private WebElement nav_EVDCselectorList;
	
	
	//EVDC Overview
	@FindBy(how=How.ID, using="virtual_machine")
	private WebElement nav_VMportlet;
	
	@FindBy(how=How.ID, using="catalogs")
	private WebElement nav_Catalogsportlet;
	
	@FindBy(how=How.ID, using="evdc_statistics")
	private WebElement nav_ComputeStatisticsportlet;
	
	@FindBy(how=How.ID, using="Storage")
	private WebElement nav_Storageportlet;
	
	@FindBy(how=How.ID, using="cloudAv")
	private WebElement nav_CloudAvportlet;
	
	@FindBy(how=How.ID, using="vCloud")
	private WebElement nav_CloudMigrationsportlet;
	
	@FindBy(how=How.ID, using="firewall")
	private WebElement nav_Firewallportlet;
	
	@FindBy(how=How.ID, using="feedback")
	//@FindBy(how=How.ID, using="userfeedback")
	private WebElement nav_Feedbackportlet;
	
	@FindBy(how=How.ID, using="evdc_bandwidth")
	private WebElement nav_Bandwidthportlet;
	
	@FindBy(how=How.ID, using="networks")
	private WebElement nav_Networksportlet;
	
	@FindBy(how=How.ID, using="loadBalancers")
	private WebElement nav_LoadBalancersportlet;
	
	
	
	//Virtual Machine

	@FindBy(how=How.XPATH, using="//section[@id='virtual_machine']/div/h2/a[text()='Virtual Machines']")
	private WebElement nav_VMLink;
	
	@FindBy(how=How.XPATH, using="//div[@id='vm_create']/span/a[text()='Add Virtual Machine']")
	private WebElement nav_AddVMLink;
	
	@FindBy(how=How.XPATH, using="//div[@id='vm_page']//table[contains(@id,'gridview-')]")
	private WebElement nav_VMtable;
	
	
	
	//Catalog
	
	@FindBy(how=How.XPATH, using="//div[@id='export']//a/img[@alt='CSV']")
	private WebElement nav_WHSObjCSVicon;
	
	@FindBy(how=How.XPATH, using="//div[@id='export']//a/img[@alt='PDF']")
	private WebElement nav_WHSObjPDFicon;
	
	@FindBy(how=How.XPATH, using="//div[@class='tabPrint']//a/img[@alt='CSV']")
	private WebElement nav_PvtObjCSVicon;
	
	@FindBy(how=How.XPATH, using="//div[@class='tabPrint']//a/img[@alt='PDF']")
	private WebElement nav_PvtObjPDFicon;
	
	@FindBy(how=How.CSS, using=".feedback")
	private WebElement nav_FeedbackArea;
	
	//updated pf as part of extjs5 on 10/01/2015 by Arul	
	//@FindBy(how=How.XPATH, using="//div[@id='winObjContainer']//div[@id='wsCtlgs-body']/div/table[contains(@id,'gridview-')]")
	@FindBy(how=How.XPATH, using="//div[@id='winObjContainer']//div[@id='wsCtlgs-body']//div[@class='x-grid-item-container']/table[1]")
	private WebElement nav_WindstreamObjectsTable;
	
	//updated pf as part of extjs5 on 10/01/2015 by Arul
	//@FindBy(how=How.XPATH, using="//div[@id='pvtObjGridContainer']//div[@id='pvtObjGrid-innerCt']/div/table[contains(@id,'gridview-')]")
	@FindBy(how=How.XPATH, using="//div[@id='pvtObjGridContainer']//div[@id='pvtObjGrid-innerCt']//div[@class='x-grid-item-container']/table[1]")
	private WebElement nav_PrivateObjectsTable;
	
	@FindBy(how=How.XPATH, using="//div[@id='catalog_page']//li[@id='tabWinObj']")
	private WebElement nav_WindstreamObjectsTab;
	
	@FindBy(how=How.XPATH, using="//div[@id='catalog_page']//li[@id='tabPvtObj']")
	private WebElement nav_PrivateObjectsTab;
	
	@FindBy(how=How.XPATH, using="//section[@id='catalogs']/div/h2/a[text()='Catalogs']")
	private WebElement nav_CatalogsLink;
	
	
	
	
	//Firewall
	
	@FindBy(how=How.XPATH, using="//div[@id='vm_print']/a/img[@alt='CSV']")
	private WebElement nav_CSVicon;
	
	@FindBy(how=How.XPATH, using="//div[@id='vm_print']/a/img[@alt='PDF']")
	private WebElement nav_PDFicon;
	
	@FindBy(how=How.XPATH, using="//table[@class='vm_table_construction']")
	private WebElement nav_FirewallTable;
	
	@FindBy(how=How.XPATH, using="//section[@id='firewall']/div/h2/a[text()='Firewall']")
	private WebElement nav_FirewallLink;
	
	
	
	//home page objects
	@FindBy(how=How.XPATH, using="//section[@class='navigation']//a[text()='monitoring']")
	private WebElement nav_MonitoringMenu;
	
	@FindBy(how=How.XPATH, using="//section[@class='navigation']//a[text()='services']")
	private WebElement nav_ServicesMenu;
	
	@FindBy(how=How.XPATH, using="//section[@class='navigation']//a[text()='security']")
	private WebElement nav_SecurityMenuLink;
	
	@FindBy(how=How.XPATH, using="//section[@class='navigation']//a[text()='support']")
	private WebElement nav_SupportMenuLink;
	
	@FindBy(how=How.XPATH, using="//section[@class='navigation']//a[text()='account']")
	private WebElement nav_AccountMenuLink;

	@FindBy(how=How.XPATH, using="//div[@id='ReportLauncherPortletDiv']/div/table//a[text()='Network Reports']")
	private WebElement nav_NetworkReportsLink;
	
	@FindBy(how=How.XPATH, using="//section[@class='navigation']//a[text()='Cloud API']")
	private WebElement nav_CloudAPISubMenuLink;
	
	
	@FindBy(how=How.XPATH, using="//section[@class='navigation']//a[text()='DDoS Mitigation']")
	private WebElement nav_DDoSMitigationSubMenuLink;
	
	@FindBy(how=How.XPATH, using="//section[@class='navigation']//a[text()='Cloud AV']")
	private WebElement nav_CloudAVSubMenuLink;
	
	@FindBy(how=How.XPATH, using="//section[@class='navigation']//a[text()='Documents']")
	private WebElement nav_DocumentsSubMenuLink;
	
	@FindBy(how=How.XPATH, using="//div[@class='portlet-content']//p/img")
	private WebElement nav_DocumentsImg;
	
	@FindBy(how=How.XPATH, using="//section[@class='navigation']//a[text()='Account Settings']")
	private WebElement nav_AccountSettingsSubMenuLink;
	
	@FindBy(how=How.XPATH, using="//section[@class='navigation']//a[text()='Permissions']")
	private WebElement nav_PermissionsSubMenuLink;
	
	@FindBy(how=How.XPATH, using="//section[@class='navigation']//a[text()='Escalation List']")
	private WebElement nav_EscalationListSubMenuLink;
	
	@FindBy(how=How.XPATH, using="//section[@class='navigation']//a[text()='Cloud Migrations']")
	private WebElement nav_CloudMigrationsSubMenuLink;
	
	@FindBy(how=How.XPATH, using="//section[@class='navigation']//a[text()='DNS']")
	private WebElement nav_DNSSubMenuLink;
	
	@FindBy(how=How.XPATH, using="//section[@class='navigation']//a[text()='Reports']")
	private WebElement nav_ReportsSubMenuLink;
	
	@FindBy(how=How.XPATH, using="//section[@class='navigation']//a[text()='Build Requirements (Forms)']")
	//@FindBy(how=How.XPATH, using="//section[@class='navigation']//a[text()='support']/..//ul//li[*]/a[text()='Build Requirements (Forms)']")
	private WebElement nav_BuildReq_Forms_SubMenuLink;
	
	
	@FindBy(how=How.XPATH, using="//div[@class='portlet-content']//h2/strong[text()='Managed Cloud Migration']")
	private WebElement nav_CloudMigrationsHeader;
	
	@FindBy(how=How.CSS, using=".marketing_table_migration")
	private WebElement nav_CloudMigrationsHeaderImg;
	
	
		
	@FindBy(how=How.CSS, using=".cloudApiHead1")
	private WebElement nav_CloudAPIHeader;
	
	@FindBy(how=How.CSS, using=".marketing_table_api")
	private WebElement nav_CloudAPIHeaderImg;
	
	@FindBy(how=How.XPATH, using="//div[@class='portlet-content']//h1[text()='Cloud AV']")
	private WebElement nav_CloudAVHeader;
	
	@FindBy(how=How.CSS, using=".marketing_table_av")
	private WebElement nav_CloudAVHeaderImg;
	
	@FindBy(how=How.XPATH, using="//div[@class='portlet-content']//p/strong[text()='Distributed Denial of Service (DDoS) Mitigation Service']")
	private WebElement nav_DDoSHeader;
	
	@FindBy(how=How.CSS, using=".marketing_table_ddos")
	private WebElement nav_DDoSHeaderImg;
	

	@FindBy(how=How.CSS, using=".user-greeting")
	private WebElement nav_ControlPanelHeader;
		
	@FindBy(how=How.XPATH, using="//span[contains(@id,'-btnInnerEl')][text()='Critical Escalation List']")
	private WebElement nav_EscalationHeader;
	
	@FindBy(how=How.XPATH, using="//div[@id='content']//span/a[text()='Permissions']")
	private WebElement nav_PermissionsBreadcrumb;
	
	
	//Build Requirement
	@FindBy(how=How.XPATH, using="//form[@id='loginform']//label[text()='EM7 Login']")
	private WebElement nav_EM7LoginText;
	
	@FindBy(how=How.XPATH, using="//div[contains(@id,'component')]//div[text()='Build Requirements Dashboard']")
	private WebElement nav_BuildReqPageHeader;
	
	
	//Permissions
	//@FindBy(how=How.ID, using="tab-1010-btnInnerEl")
	@FindBy(how=How.XPATH, using="//span[contains(@id,'tab-')][text()='Users']")
	private WebElement nav_UsersTab;
	
	//DNS
	@FindBy(how=How.XPATH, using="//span[text()='Records'][contains(@id,'-label')]")
	private WebElement nav_DNSTableHeader;
	
	//////////////LEFCOURT///////////////////////////////////////////////
	//private EVDC
	//@FindBy(how=How.XPATH, using="//div[Contains(@id,'-innerCt')]/section[2]/section/h2/a")
	@FindBy(how=How.XPATH, using="//div/div/section[2]/section[1]/h2/a")
	private WebElement nav_PrivateEVDC;
	
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	public WebElement getNav_PrivateEVDC() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PrivateEVDC;
	}
	
	public WebElement getNav_DraasPortlet() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DraasPortlet;
	}

	public WebElement getNav_DraasLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DraasLink;
	}



	public WebElement getNav_TicketsPortlet() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketsPortlet;
	}



	public WebElement getNav_TicketsLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketsLink;
	}



	public WebElement getNav_DevicesAlertsPortlet() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DevicesAlertsPortlet;
	}



	public WebElement getNav_DevicesAlertsLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DevicesAlertsLink;
	}



	public WebElement getNav_BandwidthPortlet() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_BandwidthPortlet;
	}



	public WebElement getNav_BandwidthLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_BandwidthLink;
	}



	public WebElement getNav_AnnouncementsPortlet() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AnnouncementsPortlet;
	}



	public WebElement getNav_AnnouncementsLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AnnouncementsLink;
	}



	public WebElement getNav_ContactPortlet() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ContactPortlet;
	}



	public WebElement getNav_ContactUsLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ContactUsLink;
	}



	public WebElement getNav_FeedbackLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FeedbackLink;
	}



	public WebElement getNav_EVDCPortlet() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCPortlet;
	}



	public WebElement getNav_EVDCLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCLink;
	}



	public WebElement getNav_PurchaseEVDCLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PurchaseEVDCLink;
	}



	public WebElement getNav_HosBasedReplicationText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_HosBasedReplicationText;
	}



	public WebElement getNav_SearchByWebList() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SearchByWebList;
	}



	public WebElement getNav_NetworkReportsText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NetworkReportsText;
	}



	public WebElement getNav_ShowCalendarBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ShowCalendarBtn;
	}



	public WebElement getNav_CreateTicketHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateTicketHeader;
	}



	public WebElement getNav_CreateTicketCancelBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateTicketCancelBtn;
	}



	public WebElement getNav_FeedbackHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FeedbackHeader;
	}



	public WebElement getNav_FeedbackCancelBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FeedbackCancelBtn;
	}



	public WebElement getNav_vCloudDirectorLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_vCloudDirectorLink;
	}



	public WebElement getNav_MonitoringMenu() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_MonitoringMenu;
	}



	public WebElement getNav_ServicesMenu() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ServicesMenu;
	}



	public WebElement getNav_SecurityMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SecurityMenuLink;
	}



	public WebElement getNav_SupportMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SupportMenuLink;
	}



	public WebElement getNav_AccountMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AccountMenuLink;
	}



	public WebElement getNav_ReportsSubMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ReportsSubMenuLink;
	}



	public WebElement getNav_NetworkReportsLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NetworkReportsLink;
	}



	public WebElement getNav_CloudMigrationsSubMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CloudMigrationsSubMenuLink;
	}



	public WebElement getNav_DNSSubMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNSSubMenuLink;
	}



	public WebElement getNav_AddVMLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddVMLink;
	}



	public WebElement getNav_CloudAPISubMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CloudAPISubMenuLink;
	}



	public WebElement getNav_DDoSMitigationSubMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DDoSMitigationSubMenuLink;
	}



	public WebElement getNav_CloudAVSubMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CloudAVSubMenuLink;
	}



	public WebElement getNav_DocumentsSubMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DocumentsSubMenuLink;
	}



	public WebElement getNav_DocumentsImg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DocumentsImg;
	}



	public WebElement getNav_AccountSettingsSubMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AccountSettingsSubMenuLink;
	}



	public WebElement getNav_PermissionsSubMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PermissionsSubMenuLink;
	}



	public WebElement getNav_EscalationListSubMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EscalationListSubMenuLink;
	}



	public WebElement getNav_CloudMigrationsHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CloudMigrationsHeader;
	}



	public WebElement getNav_CloudAPIHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CloudAPIHeader;
	}



	public WebElement getNav_CloudAVHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CloudAVHeader;
	}



	public WebElement getNav_DDoSHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DDoSHeader;
	}



	public WebElement getNav_ControlPanelHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ControlPanelHeader;
	}



	public WebElement getNav_EscalationHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EscalationHeader;
	}



	public WebElement getNav_PermissionsBreadcrumb() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PermissionsBreadcrumb;
	}



	public WebElement getNav_BuildReq_Forms_SubMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_BuildReq_Forms_SubMenuLink;
	}



	public WebElement getNav_EM7LoginText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EM7LoginText;
	}



	public WebElement getNav_EVDCselectorList() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCselectorList;
	}



	public WebElement getNav_FeedbackArea() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FeedbackArea;
	}



	public WebElement getNav_CSVicon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CSVicon;
	}



	public WebElement getNav_PDFicon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PDFicon;
	}



	public WebElement getNav_FirewallTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FirewallTable;
	}



	public WebElement getNav_FirewallLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FirewallLink;
	}



	public WebElement getNav_WHSObjCSVicon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_WHSObjCSVicon;
	}



	public WebElement getNav_WHSObjPDFicon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_WHSObjPDFicon;
	}



	public WebElement getNav_PvtObjCSVicon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PvtObjCSVicon;
	}



	public WebElement getNav_PvtObjPDFicon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PvtObjPDFicon;
	}



	public WebElement getNav_WindstreamObjectsTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_WindstreamObjectsTable;
	}



	public WebElement getNav_PrivateObjectsTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PrivateObjectsTable;
	}



	public WebElement getNav_WindstreamObjectsTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_WindstreamObjectsTab;
	}



	public WebElement getNav_PrivateObjectsTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PrivateObjectsTab;
	}



	public WebElement getNav_CatalogsLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogsLink;
	}



	public WebElement getNav_VMLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_VMLink;
	}



	public WebElement getNav_VMtable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_VMtable;
	}



	public WebElement getNav_VMportlet() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_VMportlet;
	}



	public WebElement getNav_Catalogsportlet() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Catalogsportlet;
	}



	public WebElement getNav_ComputeStatisticsportlet() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ComputeStatisticsportlet;
	}



	public WebElement getNav_Storageportlet() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Storageportlet;
	}



	public WebElement getNav_CloudAvportlet() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CloudAvportlet;
	}



	public WebElement getNav_CloudMigrationsportlet() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CloudMigrationsportlet;
	}



	public WebElement getNav_Firewallportlet() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Firewallportlet;
	}



	public WebElement getNav_Feedbackportlet() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Feedbackportlet;
	}



	public WebElement getNav_Bandwidthportlet() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Bandwidthportlet;
	}



	public WebElement getNav_Networksportlet() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Networksportlet;
	}



	public WebElement getNav_UsersTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_UsersTab;
	}



	public WebElement getNav_EM7_SignInBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EM7_SignInBtn;
	}



	public WebElement getNav_CloudMigrationsHeaderImg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CloudMigrationsHeaderImg;
	}



	public WebElement getNav_CloudAPIHeaderImg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CloudAPIHeaderImg;
	}



	public WebElement getNav_CloudAVHeaderImg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CloudAVHeaderImg;
	}



	public WebElement getNav_DDoSHeaderImg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DDoSHeaderImg;
	}



	public WebElement getNav_CreateTicketLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateTicketLink;
	}



	public WebElement getNav_DNSTableHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNSTableHeader;
	}



	public WebElement getNav_MoreDraasProducts() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_MoreDraasProducts;
	}



	public WebElement getNav_NetworkFirstGraphHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NetworkFirstGraphHeader;
	}



	public WebElement getNav_LoadBalancersportlet() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_LoadBalancersportlet;
	}



	public WebElement getNav_BuildReqPageHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_BuildReqPageHeader;
	}



	public WebElement getNav_ViewCalender() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ViewCalender;
	}

	
	
	
}
