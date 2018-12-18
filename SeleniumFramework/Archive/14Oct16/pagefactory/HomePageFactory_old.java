package com.whs.navigator.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class HomePageFactory_old 
{
////////***********************************LefCourt Element***********************************/////
	@FindBy(how=How.XPATH, using ="//a[text()='FAQ']")
	private WebElement nav_FAQLink;
	
	//Page Factory and links under Monitoring Tab 
	@FindBy(how=How.XPATH, using="//a[contains(text(),'monitoring')]")
	//@FindBy(how=How.LINK_TEXT,using="monitoring")
	private WebElement nav_MonitoringTab;
	
	//@FindBy(how=How.XPATH, using="//a[contains(text(),'Summary View')]")
	//@FindBy(how=How.LINK_TEXT,using="Summary View")
	@FindBy(how=How.XPATH, using="//section[@class='navigation']//ul/li[1]/ul/li[1]/a")
	private WebElement nav_SummaryViewMenuLink;
	
	//@FindBy(how=How.XPATH, using="//a[contains(text(),'Device Monitor')]")
	@FindBy(how=How.LINK_TEXT,using="Device Monitor")
	private WebElement nav_DeviceMonitorMenuLink;

	//@FindBy(how=How.XPATH, using="//a[contains(text(),'Reports')]")
	@FindBy(how=How.LINK_TEXT,using="Reports")
	private WebElement nav_ReportMenuLink;
	
	//Page Factory and links under Service Tab 
	@FindBy(how=How.XPATH,using ="//a[contains(text(),'services')]")
	private WebElement nav_ServicesTab;
	
	@FindBy(how=How.LINK_TEXT,using ="Cloud Migrations")
	private WebElement nav_CloudMigrationMenuLink;
	
	@FindBy(how=How.LINK_TEXT,using="DRaaS")
	private WebElement nav_DRaaSMenuLink;
	
	@FindBy(how=How.LINK_TEXT,using="DNS")
	private WebElement nav_DNSMenuLink;
	
	@FindBy(how=How.LINK_TEXT,using="Cloud API")
	private WebElement nav_CloudAPIMenuLink;
	
	@FindBy(how=How.LINK_TEXT,using="Cloud Services")
	private WebElement nav_CloudServicesMenuLink;
	
	@FindBy(how=How.XPATH,using="//*[contains(text(),'Andover, MA - 11giraffes')]")
	private WebElement nav_CloudServicePOPUp;
	
	@FindBy(how=How.ID,using="component-1010")
	private WebElement nav_ArchitectureLabHTMLLink;
	
	//Page Factory and links under Security Tab 
	@FindBy(how=How.XPATH,using="//a[contains(text(),'security')]")
	private WebElement nav_SecurityTab;
	
	@FindBy(how=How.LINK_TEXT,using="DDoS Mitigation")
	private WebElement nav_DDoSMitigationMenuLink;
	
	@FindBy(how=How.LINK_TEXT,using="Cloud AV")
	private WebElement nav_CloudAVMenuLink;
	
	//Page Factory and links under Support Tab 
	@FindBy(how=How.XPATH,using="//section[@class='navigation']//ul//li/a[text()='support']")
	private WebElement nav_SupportTab;
	
	@FindBy(how=How.LINK_TEXT,using="Tickets")
	private WebElement nav_TicketsMenuLink;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Build Requirements')]")
	private WebElement nav_BuildReqMenuLink;
	
	@FindBy(how=How.LINK_TEXT,using="Announcements")
	private WebElement nav_AnnouncementsMenuLink;
	
	@FindBy(how=How.LINK_TEXT,using="Documents")
	private WebElement nav_DocumentsMenuLink;
	
	//Page Factory and links under Account Tab 
	@FindBy(how=How.XPATH,using="//a[contains(text(),'account')]")
	private WebElement nav_AccountTab;
	
	// this object is added by QAA04
	@FindBy(how=How.LINK_TEXT, using="Permissions")
	private WebElement nav_PermissionsLink;
	
	// this object added by QAA04 - 02/02/2016
	@FindBy(how=How.LINK_TEXT, using="Log Viewer")
	private WebElement nav_LogViewerMenuLink;
	
	@FindBy(how=How.LINK_TEXT,using="Account Settings")
	private WebElement nav_AccountSettingsMenuLink;
	
	@FindBy(how=How.LINK_TEXT,using="Escalation List")
	private WebElement nav_EsclationListMenuLink;
	
	//Edit Profile
	@FindBy(how=How.LINK_TEXT,using="Edit Profile")
	private WebElement nav_EditProfileLink; 
	
	//UserId
	@FindBy(how=How.XPATH,using="//*[@id='user']/a/nobr")
	private WebElement nav_UserNameLink;
	
	//Logout Link
	@FindBy(how=How.LINK_TEXT,using = "Logout")
	private WebElement nav_LogoutLink;
	
	
	//MultiSelect List
	@FindBy(how=How.NAME,using ="orgId")
	private WebElement nav_MultiSelectList;
	
	//Use This organization Button
	@FindBy(how=How.XPATH,using="//form/input[contains(@value,'Use this Organization')]")
	private WebElement nav_UseOrganizationBtn;
	
	@FindBy(how=How.LINK_TEXT,using="TST Hawaii Rainbow Warriors")
	private WebElement nav_MultiOrganizationUserLink;
	
	@FindBy(how=How.LINK_TEXT,using="TST Hawaii Rainbow Warriors")
	private WebElement nav_TSTHawaiiLink;
	
	@FindBy(how=How.LINK_TEXT,using="TST Western Michigan Broncos")
	private WebElement nav_TSTWesternLink;
	
	
	
	//Device and Alerts Box\
	@FindBy(how=How.ID,using="devices_section")
	private WebElement nav_DeviceAlertSection;
	
	@FindBy(how=How.LINK_TEXT,using="devices/alerts")
	private WebElement nav_DeviceAlertsLink;
	
	@FindBy(how=How.ID,using="devices_label")
	private WebElement nav_DeviceAlertsLabel;
	
	@FindBy(how=How.ID,using="alert_critical")
	private WebElement nav_AlertCriticalText;
	
	@FindBy(how=How.ID,using="number_critical_alerts")
	private WebElement nav_AlertCriticalNumber;
	
	//@FindBy(how=How.XPATH,using="//ul[4]/li[1]")
	@FindBy(how=How.ID,using="alert_major")
	private WebElement nav_AlertMajorText;
	
	@FindBy(how=How.ID,using="number_major_alerts")
	private WebElement nav_AlertMajorNumber;
	
	//@FindBy(how=How.XPATH,using="//ul[2]/li[2]")
	@FindBy(how=How.ID,using="alert_minor")
	private WebElement nav_AlertMinorText;
	
	@FindBy(how=How.ID,using="number_minor_alerts")
	private WebElement nav_AlertMinorNumber;
		
	@FindBy(how=How.ID,using="alert_notice")
	private WebElement nav_AlertNoticeText;
	
	@FindBy(how=How.ID,using="number_notice_alerts")
	private WebElement nav_AlertNoticeNumber;
	
	//Home Breadcrumb Link
	//@FindBy(how=How.LINK_TEXT,using="Home")
	@FindBy(how=How.XPATH,using="//div[@class='header_wrapper']//li[@class='first']//a")
	private WebElement nav_HomeBreadcrumb;
	
	//Announcement Section
	@FindBy(how=How.XPATH,using="//a[contains(text(),'announcements')]")
	private WebElement nav_AnnouncementSection;
	
	//Ticket Section
	@FindBy(how=How.XPATH,using="//h2/a[contains(text(),'tickets')]")
	private WebElement nav_TicketSection;
	
	@FindBy(how=How.ID,using="outstanding")
	private WebElement nav_OutstandingText;
	
	@FindBy(how=How.ID,using="number_outstand_tix")
	private WebElement nav_OutstandingNumber;
	
	@FindBy(how=How.ID,using="resolved")
	private WebElement nav_ResolvedText;
	
	@FindBy(how=How.ID,using="number_resolved_tix")
	private WebElement nav_ResolvedNumber;
	
	@FindBy(how=How.XPATH, using="//h2[@id='edvc_1']/strong")
	private WebElement nav_EVDCText;
	
	
	@FindBy(how=How.ID,using="btn-hbrmanage")
	private WebElement nav_HostedManageButton;
	
	@FindBy(how=How.XPATH,using="//*[@id='DraasDiv']/table[1]//button[contains(text(),'History')]")
	private WebElement nav_HostedHistoryButton;
	
	@FindBy(how=How.ID,using="btn-sbrmanage")
	private WebElement nav_StorageManageButton;
	
	@FindBy(how=How.XPATH,using="//*[@id='DraasDiv']/table[2]//button[contains(text(),'History')]")
	private WebElement nav_StorageHistoryButton;
	
	@FindBy(how=How.LINK_TEXT,using="Windstream Hosted Solutions Support")
	private WebElement nav_MailInfoLink;
	
	@FindBy(how=How.ID,using="numerator_assets")
	private WebElement nav_DRaaSNumerator;
	
	@FindBy(how=How.ID,using="draas_of")
	private WebElement nav_DRaaSof;
	
	@FindBy(how=How.ID,using="denominator_assets")
	private WebElement nav_DRaaSDenominator;
	
	@FindBy(how=How.ID,using="assets")
	private WebElement nav_DRaaSAssets;
	
	@FindBy(how=How.XPATH, using="//section[@id='draas']//ul")
	private WebElement nav_DraasPortal;
	
	
	@FindBy(how=How.ID,using="idDraasPdtPanel")
	private WebElement nav_DraasPanel;
	
	
	@FindBy(how=How.XPATH, using="//img[contains(@src,'images/C2CR.jpg')]")
	private WebElement nav_DraasC2CRImg;
	
	@FindBy(how=How.XPATH, using="//div[@id='idc2crPanel_header-targetEl']//div[contains(@id,'title-')][contains(@id,'-textEl')][contains(text(),'Cloud to Cloud Recovery')]")
	private WebElement nav_DRaaSC2CRTitle;
	
	@FindBy(how=How.XPATH, using="//img[contains(@src,'images/S2CR.jpg')]")
	private WebElement nav_DraasS2CRImg;
	
	@FindBy(how=How.XPATH, using="//img[contains(@src,'images/SBR.jpg')]")
	private WebElement nav_DraasSBRImg;
	
	//Contact Module
	@FindBy(how=How.ID, using="contact")
	private WebElement nav_ContactUsBox;

	@FindBy(how=How.XPATH, using="//a[contains(text(),'contact us')]")
	private WebElement nav_ContactUsLink;
	
	@FindBy(how=How.XPATH, using="//li[contains(text(),'1 (877) 621-6666')]")
	private WebElement nav_ContactNumber;
	
	//changed mail id from windstream to tierpoint by Arul on 12/21/15
	//@FindBy(how=How.LINK_TEXT, using="windstream.dcsupport@windstream.com")
	@FindBy(how=How.LINK_TEXT, using="hs.dcsupport@tierpoint.com")
	private WebElement nav_ContactMailIDLink;
	
	
	//FeedBack Box
	//@FindBy(how=How.LINK_TEXT,using="Click here")
	@FindBy(how=How.XPATH,using="//div[@id='right_feedback']/p/a")
	private WebElement nav_ClickhereLink;

	@FindBy(how=How.XPATH,using="//span[contains(text(),'Feedback')]")
	private WebElement nav_CreateFeedbackPopupWindowTitle;
	
	//@FindBy(how=How.XPATH,using="//input[contains(@name,'description')]")
	@FindBy(how=How.NAME ,using="description")
	private WebElement nav_TitleText;
	
	@FindBy(how=How.XPATH,using="//section[@id='feedback']")
	private WebElement nav_FeedBackBox;
	
	
	//@FindBy(how=How.XPATH,using="//iframe[contains(@id,'inputCmp-iframeEl')]")
	@FindBy(how=How.XPATH,using="//iframe[contains(@id,'-inputCmp-iframeEl')]")
	private WebElement nav_CreateFeedbackIframe;
	
	@FindBy(how=How.TAG_NAME,using="body")
	private WebElement nav_NoteText;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'OK')]")		
	private WebElement nav_OkBtn;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Submit')]")		
	private WebElement nav_SubmitBtn;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Cancel')]")		
	private WebElement nav_CancelBtn;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'We have received your feedback')]")		
	private WebElement nav_CreateFeedbackSucessNotification;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'OK')]")		
	private WebElement nav_CreateFeedbackSucessNotificationOKBtn;
	
	@FindBy(how=How.ID,using="messagebox-1001")
	private WebElement nav_SuccessPopupWindow;
	

	//CreateTicket
	@FindBy(how=How.LINK_TEXT,using="Create Ticket")
	private WebElement nav_CreateTicketLink;
	
	//Updated below two elements on 12/29/2015 by QAA03
		//@FindBy(how=How.ID,using="ext-comp-1009")
		@FindBy(how=How.XPATH,using="//div[contains(@class,'x-window CreateTicketPopup')]")
		private WebElement nav_CreateTicketPopupWindow;
		
		//@FindBy(how=How.ID,using="ext-comp-1009_header_hd-textEl")
		@FindBy(how=How.XPATH,using="//div[contains(@class,'x-window-header x-header')]")
		private WebElement nav_CreateTicketPopupWindowTitle;
		

		// this below element is added by QAA04 - 04/21/2016
		@FindBy(how=How.XPATH, using="//li[@id='organization']/nobr")
		private WebElement nav_OrgNameTitle;

		
	@FindBy(how=How.XPATH,using="//input[contains(@name,'severity')]")	
	private WebElement nav_SeverityList;
	
	@FindBy(how=How.XPATH,using="//li[contains(text(),'Sev 4 - Informational')]")	
	private WebElement nav_SeverityListItem;
	
	@FindBy(how=How.XPATH,using="//input[contains(@name,'priority')]")	
	private WebElement nav_PriorityList;
	
	@FindBy(how=How.XPATH,using="//li[contains(text(),'High')]")	
	private WebElement nav_PriorityListItem;
	
	@FindBy(how=How.XPATH,using="//input[contains(@name,'category')]")		
	private WebElement nav_CategoryList;
	
	@FindBy(how=How.XPATH,using="//li[contains(text(),'Billing')]")	
	private WebElement nav_CategoryListItem;
	
	@FindBy(how=How.XPATH,using="//iframe[contains(@id,'inputCmp-iframeEl')]")		
	private WebElement nav_CreateTicketIframe;
	
	@FindBy(how=How.XPATH,using="//div/nobr")		
	private WebElement nav_CreateTicketSucessNotification;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'OK')]")		
	private WebElement nav_CreateTicketSucessNotificationOKBtn;
	
	//@FindBy(how=How.ID,using="evdc_1")
	@FindBy(how=How.ID,using="//div[@id='nav_org_maindev']//section[1]//h2[@id='edvc_1']/a")
	private WebElement nav_HomeEVDCPortlet;
	
	//Service
	//Added by Sukur Babu. B. For covering one of the Talon Test case. 
	@FindBy(how=How.XPATH,using ="//a[contains(text(),'Add Services')]")
	private WebElement nav_AddServicesLink;
	
	
	////_________________________Hague testcase elements _______________________________________
	
	
	@FindBy(how=How.XPATH,using="//div[@id='top_left']/a/img[@alt='windstream logo']")		
	private WebElement nav_WindStreamLogo;
	
	
	@FindBy(how=How.XPATH,using="//div[@id='top_left']/a/img[@alt='TierPoint logo']")		
	private WebElement nav_TierPointLogo;
	
	
	@FindBy(how=How.XPATH,using="//div[@id='top_left']/a/img[@alt='windstream logo']")		
	private WebElement nav_FooterHomeLink;
	

	@FindBy(how=How.XPATH,using="//div[@class='header_wrapper'] //li[@class='first']//a[text()='Home']/../../..//li[@class='last']")		
	private WebElement nav_BreadscrumbChain;
	
	@FindBy(how=How.XPATH, using="//div[@class='header_wrapper']//li[@class='first']//a")
	//@FindBy(how=How.XPATH,using="//div[@class='header_wrapper'] //li[@class='first']//a[text()='Home']")		
	private WebElement nav_BreadscrumbHome;
	
	@FindBy(how=How.XPATH,using="//div[@id='nav_org_maindev']//section[1]//h2[@id='edvc_1']/a//../../..//dd[@id='info_network1']")		
	private WebElement nav_HomeEVDCNetworkNo;
	
	@FindBy(how=How.XPATH,using="//div[@id='rp_main_content']//button[text()='OK']")		
	private WebElement nav_HomeTempPopUpOk;
	
	//@FindBy(how=How.ID, using="closerpbutton")
	@FindBy(how=How.XPATH,using="//button[@class='rp_close_icon']")
	private WebElement nav_HomeTempPopUpCloseIcon;
	
	
	
	
	
	
	
	//Footer Left Copyright
		@FindBy(how=How.XPATH,using="//div[@class='footer-left']//li")
		private WebElement nav_FooterLeftCopyright;
		
		//Footer Right 
		@FindBy(how=How.CLASS_NAME,using="footer-right")
		private WebElement nav_FooterRightText;
		
		//Footer- Right - Company
		@FindBy(how=How.LINK_TEXT,using="Company")
		private WebElement nav_FooterRight_Company;
		
		@FindBy(how=How.LINK_TEXT,using="Privacy Policy")
		private WebElement nav_FooterRight_PrivacyPolicy;
		
		@FindBy(how=How.LINK_TEXT,using="Terms of Use")
		private WebElement nav_FooterRight_TermsofUse;
		
		@FindBy(how=How.LINK_TEXT,using="Acceptable Use Policy")
		private WebElement nav_FooterRight_AcceptableUsePolicy;
		
		//TierPoint Portal 
		//Client Login
		@FindBy(how=How.XPATH,using="//a[@title='Client Login']")
		private WebElement nav_TierPoint_ClientLogin;
		
		//Privacy
		@FindBy(how=How.XPATH,using="//h1[@class='page-title'][text()='Privacy Policy']")
		private WebElement nav_TierPoint_Privacy;
		
		//Terms of Use
		@FindBy(how=How.XPATH,using="//h1[@class='page-title'][text()='Terms of Use']")
		private WebElement nav_TierPoint_TermsOfUse;
		
		//Acceptance
		@FindBy(how=How.XPATH,using="//h1[@class='page-title'][text()='Acceptable Use Policy']")
		private WebElement nav_TierPoint_AcceptancePolicy;
		
		//@FindBy(how=How.XPATH, using="//div[@id='nav_org_maindev']//div[Contains(@id,'title')][Contains(@id,'textEl')]]")
		@FindBy(how=How.ID, using="title-1011")
		private WebElement nav_CloudServicesTitle;
		
		@FindBy(how=How.XPATH, using="//div[Contains(@id,'panel')]//h2//img[@alt='shared image']/..//a")
		//@FindBy(how=How.XPATH, using="//div[Contains(@id,'panel')]//a[Contains(text(),'Andover, MA')]")
		//@FindBy(how=How.XPATH, using="//a[@href='/evdc-overview?currEvdc=11']")
		private WebElement nav_EVDCShared;
		
		@FindBy(how=How.XPATH, using="//div[Contains(@id,'panel')]//h2//img[@alt='dedicated image']/..//a")
		//@FindBy(how=How.XPATH, using="//div[Contains(@id,'panel')]//a[Contains(text(),'Private')]")
		//@FindBy(how=How.XPATH, using="//a[@href='/evdc-overview?currEvdc=52']")
		private WebElement nav_EVDCPrivate;
		
		@FindBy(how=How.XPATH,using="//div[@id='nav_org_maindev']/div")
		private WebElement nav_CloudServicesArea;
		
	//***************************************************
	
	public WebElement getNav_HomeEVDCPortlet() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_HomeEVDCPortlet;
	}
	
	public WebElement getNav_MonitoringTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_MonitoringTab;
	}

	public WebElement getNav_SummaryViewMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SummaryViewMenuLink;
	}

	public WebElement getNav_DeviceMonitorMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DeviceMonitorMenuLink;
	}

	public WebElement getNav_ReportMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ReportMenuLink;
	}

	public WebElement getNav_ServicesTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ServicesTab;
	}

	public WebElement getNav_CloudMigrationMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CloudMigrationMenuLink;
	}

	public WebElement getNav_DRaaSMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DRaaSMenuLink;
	}

	public WebElement getNav_DNSMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNSMenuLink;
	}

	public WebElement getNav_CloudAPIMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CloudAPIMenuLink;
	}

	public WebElement getNav_CloudServicesMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CloudServicesMenuLink;
	}
	public WebElement getNav_ArchitectureLabHTMLLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ArchitectureLabHTMLLink;
	}

	public WebElement getNav_SecurityTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SecurityTab;
	}

	public WebElement getNav_DDoSMitigationMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DDoSMitigationMenuLink;
	}

	public WebElement getNav_CloudAVMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CloudAVMenuLink;
	}

	public WebElement getNav_SupportTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SupportTab;
	}

	public WebElement getNav_TicketsMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketsMenuLink;
	}

	public WebElement getNav_BuildReqMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_BuildReqMenuLink;
	}

	public WebElement getNav_AnnouncementsMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AnnouncementsMenuLink;
	}

	public WebElement getNav_DocumentsMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DocumentsMenuLink;
	}

	public WebElement getNav_AccountTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AccountTab;
	}

	public WebElement getNav_AccountSettingsMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AccountSettingsMenuLink;
	}

	public WebElement getNav_EsclationListMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EsclationListMenuLink;
	}

	public WebElement getNav_CloudServicePOPUp() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CloudServicePOPUp;
	}

	public WebElement getNav_EditProfileLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditProfileLink;
	}

	public WebElement getNav_UserNameLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_UserNameLink;
	}

	public WebElement getNav_LogoutLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_LogoutLink;
	}

	public WebElement getNav_MultiSelectList() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_MultiSelectList;
	}

	public WebElement getNav_UseOrganizationBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_UseOrganizationBtn;
	}

	public WebElement getNav_MultiOrganizationUserLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_MultiOrganizationUserLink;
	}

	public WebElement getNav_DeviceAlertSection() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DeviceAlertSection;
	}

	public WebElement getNav_DeviceAlertsLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DeviceAlertsLink;
	}

	public WebElement getNav_DeviceAlertsLabel() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DeviceAlertsLabel;
	}

	public WebElement getNav_AlertCriticalText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AlertCriticalText;
	}

	public WebElement getNav_AlertMajorText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AlertMajorText;
	}

	public WebElement getNav_AlertMinorText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AlertMinorText;
	}

	public WebElement getNav_AlertNoticeText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AlertNoticeText;
	}

	public WebElement getNav_HomeBreadcrumb() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_HomeBreadcrumb;
	}

	public WebElement getNav_AnnouncementSection() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AnnouncementSection;
	}

	public WebElement getNav_TicketSection() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketSection;
	}

	public WebElement getNav_AlertCriticalNumber() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AlertCriticalNumber;
	}

	public WebElement getNav_AlertMajorNumber() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AlertMajorNumber;
	}

	public WebElement getNav_AlertMinorNumber() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AlertMinorNumber;
	}

	public WebElement getNav_AlertNoticeNumber() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AlertNoticeNumber;
	}

	public WebElement getNav_TSTHawaiiLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TSTHawaiiLink;
	}

	public WebElement getNav_TSTWesternLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TSTWesternLink;
	}

	public WebElement getNav_OutstandingText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_OutstandingText;
	}

	public WebElement getNav_OutstandingNumber() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_OutstandingNumber;
	}

	public WebElement getNav_ResolvedText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ResolvedText;
	}

	public WebElement getNav_ResolvedNumber() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ResolvedNumber;
	}

	

	public WebElement getNav_HostedManageButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_HostedManageButton;
	}

	public WebElement getNav_HostedHistoryButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_HostedHistoryButton;
	}

	public WebElement getNav_StorageManageButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_StorageManageButton;
	}

	public WebElement getNav_StorageHistoryButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_StorageHistoryButton;
	}

	public WebElement getNav_MailInfoLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_MailInfoLink;
	}

	public WebElement getNav_DRaaSNumerator() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DRaaSNumerator;
	}

	public WebElement getNav_DRaaSof() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DRaaSof;
	}

	public WebElement getNav_DRaaSDenominator() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DRaaSDenominator;
	}

	public WebElement getNav_DRaaSAssets() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DRaaSAssets;
	}

	public WebElement getNav_ContactUsBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ContactUsBox;
	}

	public WebElement getNav_ContactUsLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ContactUsLink;
	}

	public WebElement getNav_ContactNumber() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ContactNumber;
	}

	public WebElement getNav_ContactMailIDLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ContactMailIDLink;
	}

	public WebElement getNav_CreateTicketLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateTicketLink;
	}
	
	public WebElement getnav_ClickhereLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ClickhereLink;
	}

	public WebElement getnav_CreateFeedbackPopupWindowTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateFeedbackPopupWindowTitle;
	}

	public WebElement getnav_TitleText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TitleText;
	}

	public WebElement getnav_CreateFeedbackIframe() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateFeedbackIframe;
	}

	public WebElement getnav_NoteText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NoteText;
	}

	public WebElement getnav_OkBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_OkBtn;
	}

	public WebElement getnav_CancelBtn() {
		return nav_CancelBtn;
	}

	public WebElement getnav_CreateFeedbackSucessNotification() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateFeedbackSucessNotification;
	}

	public WebElement getnav_CreateFeedbackSucessNotificationOKBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateFeedbackSucessNotificationOKBtn;
	}

	public WebElement getnav_FeedBackBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FeedBackBox;
	}

	
	public WebElement getnav_CreateTicketPopupWindow()
	{
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateTicketPopupWindow;
	}
	public WebElement getnav_CreateTicketPopupWindowTitle()
	{
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateTicketPopupWindowTitle;
	}
	
	public WebElement getnav_CreateTicketLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateTicketLink;
	}

	
	public WebElement getnav_ContactUsLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ContactUsLink;
	}
	
	public WebElement getnav_SeverityList() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SeverityList;
	}
	public WebElement getnav_SeverityListItem() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SeverityListItem;
	}

	public WebElement getnav_PriorityList() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PriorityList;
	}
	public WebElement getnav_PriorityListItem() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PriorityListItem;
	}
	public WebElement getnav_CategoryList() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CategoryList;
	}

	public WebElement getnav_CategoryListItem() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CategoryListItem;
	}
	public WebElement getnav_CreateTicketIframe() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateTicketIframe;
	}

	
	public WebElement getnav_CreateTicketSucessNotification() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateTicketSucessNotification;
	}
	public WebElement getnav_CreateTicketSucessNotificationOKBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateTicketSucessNotificationOKBtn;
	}
	
	public WebElement getnav_SuccessPopupWindow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SuccessPopupWindow;
	}

	public WebElement getNav_DraasPanel() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DraasPanel;
	}

	public WebElement getNav_DraasC2CRImg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DraasC2CRImg;
	}

	public WebElement getNav_DraasS2CRImg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DraasS2CRImg;
	}

	public WebElement getNav_DraasSBRImg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DraasSBRImg;
	}

	public WebElement getNav_DraasPortal() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DraasPortal;
	}
	
	
	public WebElement getNav_ClickhereLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ClickhereLink;
	}

	public WebElement getNav_CreateFeedbackPopupWindowTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateFeedbackPopupWindowTitle;
	}

	public WebElement getNav_TitleText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TitleText;
	}

	public WebElement getNav_FeedBackBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FeedBackBox;
	}

	public WebElement getNav_CreateFeedbackIframe() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateFeedbackIframe;
	}

	public WebElement getNav_NoteText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NoteText;
	}

	public WebElement getNav_OkBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_OkBtn;
	}

	public WebElement getNav_CancelBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CancelBtn;
	}

	public WebElement getNav_CreateFeedbackSucessNotification() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateFeedbackSucessNotification;
	}

	public WebElement getNav_CreateFeedbackSucessNotificationOKBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateFeedbackSucessNotificationOKBtn;
	}

	public WebElement getNav_SuccessPopupWindow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SuccessPopupWindow;
	}

	public WebElement getNav_CreateTicketPopupWindow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateTicketPopupWindow;
	}

	public WebElement getNav_CreateTicketPopupWindowTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateTicketPopupWindowTitle;
	}

	public WebElement getNav_SeverityList() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SeverityList;
	}

	public WebElement getNav_SeverityListItem() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SeverityListItem;
	}

	public WebElement getNav_PriorityList() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PriorityList;
	}

	public WebElement getNav_PriorityListItem() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PriorityListItem;
	}

	public WebElement getNav_CategoryList() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CategoryList;
	}

	public WebElement getNav_CategoryListItem() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CategoryListItem;
	}

	public WebElement getNav_CreateTicketIframe() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateTicketIframe;
	}

	public WebElement getNav_CreateTicketSucessNotification() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateTicketSucessNotification;
	}

	public WebElement getNav_CreateTicketSucessNotificationOKBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateTicketSucessNotificationOKBtn;
	}

	public WebElement getNav_PermissionsLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PermissionsLink;
	}

	public WebElement getNav_WindStreamLogo() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_WindStreamLogo;
	}

	public WebElement getNav_FooterHomeLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FooterHomeLink;
	}

	public WebElement getNav_BreadscrumbChain() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_BreadscrumbChain;
	}

	public WebElement getNav_BreadscrumbHome() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_BreadscrumbHome;
	}

	public WebElement getNav_HomeEVDCNetworkNo() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_HomeEVDCNetworkNo;
	}

	public WebElement getNav_HomeTempPopUpOk() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_HomeTempPopUpOk;
	}

	public WebElement getNav_DRaaSC2CRTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DRaaSC2CRTitle;
	}

	public WebElement getNav_TierPointLogo() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TierPointLogo;
	}

	public WebElement getNav_FAQLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FAQLink;
	}

	public WebElement getNav_HomeTempPopUpCloseIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_HomeTempPopUpCloseIcon;
	}

	public WebElement getNav_OrgNameTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_OrgNameTitle;
	}

	public WebElement getNav_LogViewerMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_LogViewerMenuLink;
	}

	public WebElement getNav_SubmitBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SubmitBtn;
	}

	public WebElement getNav_AddServicesLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddServicesLink;
	}

	public WebElement getNav_EVDCText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCText;
	}

	public WebElement getNav_FooterLeftCopyright() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FooterLeftCopyright;
	}

	public WebElement getNav_FooterRightText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FooterRightText;
	}

	public WebElement getNav_FooterRight_Company() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FooterRight_Company;
	}

	public WebElement getNav_FooterRight_PrivacyPolicy() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FooterRight_PrivacyPolicy;
	}

	public WebElement getNav_FooterRight_TermsofUse() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FooterRight_TermsofUse;
	}

	public WebElement getNav_FooterRight_AcceptableUsePolicy() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FooterRight_AcceptableUsePolicy;
	}

	public WebElement getNav_TierPoint_ClientLogin() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TierPoint_ClientLogin;
	}

	public WebElement getNav_TierPoint_Privacy() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TierPoint_Privacy;
	}

	public WebElement getNav_TierPoint_TermsOfUse() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TierPoint_TermsOfUse;
	}

	public WebElement getNav_TierPoint_AcceptancePolicy() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TierPoint_AcceptancePolicy;
	}

	public WebElement getNav_CloudServicesTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CloudServicesTitle;
	}

	public WebElement getNav_EVDCShared() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCShared;
	}

	public WebElement getNav_EVDCPrivate() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCPrivate;
	}

	public WebElement getNav_CloudServicesArea() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CloudServicesArea;
	}

     
	
	
}
