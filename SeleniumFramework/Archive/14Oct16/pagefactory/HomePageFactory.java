package com.whs.navigator.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class HomePageFactory 
{
////////***********************************LefCourt Element***********************************/////
	//MultiSelect List
	/*@FindBy(how=How.NAME,using ="orgId")
	private WebElement nav_MultiSelectList;
	
	//Use This organization Button
	@FindBy(how=How.XPATH,using="//form/input[contains(@value,'Use this Organization')]")
	private WebElement nav_UseOrganizationBtn;*/
	
	/*@FindBy(how=How.LINK_TEXT,using="TST Hawaii Rainbow Warriors")
	private WebElement nav_MultiOrganizationUserLink;
	
	@FindBy(how=How.LINK_TEXT,using="TST Hawaii Rainbow Warriors")
	private WebElement nav_TSTHawaiiLink;
	
	@FindBy(how=How.LINK_TEXT,using="TST Western Michigan Broncos")
	private WebElement nav_TSTWesternLink;
	*/
	
	@FindBy(how=How.ID, using="Bandwidth_number")
    private WebElement nav_HomeBandwidth;
	
	//Device and Alerts Box\
	@FindBy(how=How.ID,using="devices_section")
	private WebElement nav_DeviceAlertSection;
	
	//@FindBy(how=How.LINK_TEXT,using="devices/alerts")
	@FindBy(how=How.XPATH, using="//section[@id='devices_section']/div/h2/a")
	private WebElement nav_DeviceAlertsLink;
	
	@FindBy(how=How.ID, using="devices_monitored")
    private WebElement nav_HomeDevicesAlerts;
	
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
	//@FindBy(how=How.XPATH,using="//a[contains(text(),'announcements')]")
	@FindBy(how=How.XPATH, using="//a[@href='announcements']")
	private WebElement nav_AnnouncementSection;
	
	//Ticket Section
	//@FindBy(how=How.XPATH,using="//h2/a[contains(text(),'tickets')]")
	@FindBy(how=How.XPATH, using="//section[@id='tickets']/div/h2/a")
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
	
	/*@FindBy(how=How.XPATH,using="//*[@id='DraasDiv']/table[1]//button[contains(text(),'History')]")
	private WebElement nav_HostedHistoryButton;
	*/
	@FindBy(how=How.ID,using="btn-sbrmanage")
	private WebElement nav_StorageManageButton;
	
	/*@FindBy(how=How.XPATH,using="//*[@id='DraasDiv']/table[2]//button[contains(text(),'History')]")
	private WebElement nav_StorageHistoryButton;
	
	@FindBy(how=How.LINK_TEXT,using="Windstream Hosted Solutions Support")
	private WebElement nav_MailInfoLink;
	*/
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
	
	//@FindBy(how=How.XPATH, using="//div[@id='idc2crPanel_header-targetEl']//div[contains(@id,'title-')][contains(@id,'-textEl')][contains(text(),'Cloud to Cloud Recovery')]")
	@FindBy(how=How.XPATH, using="//div[@id='idc2crPanel_header-targetEl']//div[contains(@id,'title-')][contains(@id,'-textEl')]")
	private WebElement nav_DRaaSC2CRTitle;
	
	@FindBy(how=How.XPATH, using="//img[contains(@src,'images/S2CR.jpg')]")
	private WebElement nav_DraasS2CRImg;
	
	@FindBy(how=How.XPATH, using="//img[contains(@src,'images/SBR.jpg')]")
	private WebElement nav_DraasSBRImg;
	
	@FindBy(how=How.XPATH, using="//section[@id='draas']/div[2]")
	private WebElement nav_DraasHomeData;
	
	//Contact Module
	@FindBy(how=How.ID, using="contact")
	private WebElement nav_ContactUsBox;

	//@FindBy(how=How.XPATH, using="//a[contains(text(),'contact us')]")
	@FindBy(how=How.XPATH, using="//div[@id='left_contact']/div/h2/a")
	private WebElement nav_ContactUsLink;
	
	//@FindBy(how=How.XPATH, using="//li[contains(text(),'1 (877) 621-6666')]")
	@FindBy(how=How.XPATH, using="//div[@id='right_contact']/ul/li[1]")
	private WebElement nav_ContactNumber;
	
	//changed mail id from windstream to tierpoint by Arul on 12/21/15
	//@FindBy(how=How.LINK_TEXT, using="windstream.dcsupport@windstream.com")
	@FindBy(how=How.LINK_TEXT, using="hs.dcsupport@tierpoint.com")
	private WebElement nav_ContactMailIDLink;
	
	
	//FeedBack Box
	//@FindBy(how=How.LINK_TEXT,using="Click here")
	@FindBy(how=How.XPATH,using="//div[@id='right_feedback']/p/a")
	private WebElement nav_ClickhereLink;

	/*@FindBy(how=How.XPATH,using="//span[contains(text(),'Feedback')]")
	private WebElement nav_CreateFeedbackPopupWindowTitle;
	*/
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
	
	//@FindBy(how=How.XPATH,using="//span[contains(text(),'OK')]")		
	@FindBy(how=How.XPATH, using="//a[contains(@class,'x-btn CreateTicketPopupOK')]//span[@data-ref='btnInnerEl']")
	private WebElement nav_OkBtn;
	
	/*@FindBy(how=How.XPATH,using="//span[contains(text(),'Submit')]")		
	private WebElement nav_SubmitBtn; */
	
	@FindBy(how=How.XPATH, using="//a[contains(@class,'x-btn CreateTicketPopupCancel')]//span[@data-ref='btnInnerEl']")
	//@FindBy(how=How.XPATH,using="//span[contains(text(),'Cancel')]")		
	private WebElement nav_CancelBtn;
	
	/*@FindBy(how=How.XPATH,using="//div[contains(text(),'We have received your feedback')]")		
	private WebElement nav_CreateFeedbackSucessNotification;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'OK')]")		
	private WebElement nav_CreateFeedbackSucessNotificationOKBtn;
	
	@FindBy(how=How.ID,using="messagebox-1001")
	private WebElement nav_SuccessPopupWindow;
	*/

	//CreateTicket
	//@FindBy(how=How.LINK_TEXT,using="Create Ticket")
	@FindBy(how=How.XPATH,using="//div[@id='right_contact']//li/a[contains(@onclick,'openContactUsCreateTicketWindow')]")
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
	
	// This below elements is Create ticket
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
	//@FindBy(how=How.XPATH,using ="//a[contains(text(),'Add Services')]")
	@FindBy(how=How.XPATH, using="//a[@href='/en/services']")
	private WebElement nav_AddServicesLink;
	
	
	////_________________________Hague testcase elements _______________________________________
	
	//@FindBy(how=How.XPATH,using="//div[@class='header_wrapper'] //li[@class='first']//a[text()='Home']/../../..//li[@class='last']")		
	@FindBy(how=How.XPATH,using="//div[@class='header_wrapper'] //li[@class='first']/../../..//li[@class='last']")		
	private WebElement nav_BreadscrumbChain;
	
	
	//@FindBy(how=How.XPATH,using="//div[@class='header_wrapper'] //li[@class='first']//a[text()='Home']")		
	//@FindBy(how=How.XPATH,using="//div[@class='header_wrapper']//li[@class='first']")
	@FindBy(how=How.XPATH,using="//div[@class='header_wrapper']//li[@class='first']//a")
	private WebElement nav_BreadscrumbHome;
	
	@FindBy(how=How.XPATH,using="//div[@id='nav_org_maindev']//section[1]//h2[@id='edvc_1']/a//../../..//dd[@id='info_network1']")		
	private WebElement nav_HomeEVDCNetworkNo;
	
	//@FindBy(how=How.XPATH,using="//div[@id='rp_main_content']//button[text()='OK']")		
	@FindBy(how=How.XPATH, using="//div[@id='rp_main_content']//button[@onclick='resetPwPP.closerrp()']")
	private WebElement nav_HomeTempPopUpOk;
	
	
	//@FindBy(how=How.ID, using="closerpbutton")
	@FindBy(how=How.XPATH,using="//button[@class='rp_close_icon']")
	private WebElement nav_HomeTempPopUpCloseIcon;
		
		//TierPoint Portal 
		//Client Login
		@FindBy(how=How.XPATH,using="//a[@title='Client Login']")
		private WebElement nav_TierPoint_ClientLogin;
	
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
		
	//=========================================================================================
	//Moving the below objects from EVDC_OverviewPageFactory
	//=========================================================================================
		//EVDC Name
		//@FindBy(how=How.XPATH,using="//main/div/section[@class='rectangle long evdc'][1]//h2[@id='edvc_1']/a")
		//Commenting the above as xpath got change - Vivek - 12/4/2015
		//@FindBy(how=How.XPATH,using="//div[@id='nav_org_maindev']//section[1]//h2[@id='edvc_1']/a")
		@FindBy(how=How.XPATH,using="//div[@id='nav_org_maindev']//h2[@id='edvc_1']/a[@class='navigationMarker']")
		//@FindBy(how=How.XPATH,using="//section[1]/section[1]/h2/a")
		private WebElement nav_EVDCname;
		
		/// home page evdc portlets devision
			@FindBy(how=How.ID, using="p_p_id_NavOrganization_WAR_navorganizationportlet_")
			private WebElement nav_Home_EVDCPortletsDivision;
			
		//VM- Count text
		@FindBy(how=How.XPATH, using="//*[@id='edvc_1']/a/../../../section[2]/div[1]/dl/dt")
		private WebElement nav_VMCountText;

	//VM-Count Number
		//@FindBy(how=How.XPATH,using="//section[1]/section[2]/div[1]/dl/dd/a")
		//@FindBy(how=How.XPATH,using="//dd[@id='info_vm1']/a")
		@FindBy(how=How.XPATH,using="//div[@id='nav_org_maindev']//dd[@id='info_vm1']/a")
		private WebElement nav_VMCountNumberLink;
			
		//Networks
		@FindBy(how=How.XPATH,using="//*[@id='edvc_1']/a/../../../section[2]/div[2]/dl/dt")
		private WebElement nav_Networks;
		
		@FindBy(how=How.XPATH,using="//*[@id='evdcNetworksMainTable-body']")
		private WebElement nav_NetworksParentTable;
		
		//vCPUs
		@FindBy(how=How.XPATH,using="//*[@id='edvc_1']/a/../../../section[3]/section[1]/ul/li[contains(text(),'vCPUs')]")
		private WebElement nav_vCPUs;
		
		//Firewall
		@FindBy(how=How.XPATH,using="//*[@id='edvc_1']/a/../../../section[2]/div[3]/dl/dt")
		private WebElement nav_Firewall;
		
		//Firewall- View
		@FindBy(how=How.ID,using="info_firewall1")
		private WebElement nav_FirewallViewLink;
		
		//vRam
		@FindBy(how=How.XPATH,using="//*[@id='edvc_1']/a/../../../section[3]/section[2]/ul/li[contains(text(),'vRam')]")
		private WebElement nav_vRam;
		
		//Storage
		@FindBy(how=How.XPATH, using="//*[@id='edvc_1']/a/../../../section[3]/section[3]/ul/li[2]")
		private WebElement nav_Storage;
		
		//VCloud Director
		//@FindBy(how=How.XPATH, using="//span/a[contains(text(),'vCloud Director')]")
		@FindBy(how=How.XPATH, using="//div[@id='nav_org_maindev']//img[@alt='vCloud Director image']/../a")
		private WebElement nav_vCloudDirector;
		
		//vCPU section - KYLE release
			@FindBy(how=How.XPATH,using="//div[@id='nav_org_maindev']//section[@class='evdc_graphs']//div[@id='vcpu_1']/..")
			private WebElement nav_vCPUSection;
			
			//vCPU Section graph- KYLE release
			@FindBy(how=How.XPATH,using="//div[@id='nav_org_maindev']//div[@id='vcpu_1']//*[name()='svg']//*[name()='text'][1]/*[name()='tspan'][1]")
			private WebElement nav_vCPUSectionGraph;
			
			
			//vRAM section- KYLE release
			@FindBy(how=How.XPATH,using="//div[@id='nav_org_maindev']//section[@class='evdc_graphs']//div[@id='vram_1']/..")
			private WebElement nav_vRAMSection;
			
			//vRAM section - KYLE release
			@FindBy(how=How.XPATH,using="//div[@id='nav_org_maindev']//div[@id='vram_1']//*[name()='svg']//*[name()='text'][1]/*[name()='tspan'][1]")
			private WebElement nav_vRAMSectionGraph;
		
			
			
			//Keffer TC PF
			//Keffer TC PF
				@FindBy(how=How.ID,using="idEVDCGridPanel-body")
				private WebElement nav_EVDCViewHomeTable;
				
				@FindBy(how=How.XPATH,using="//div[@id='idEVDCGridPanel']//span[text()='Name']")
				private WebElement nav_EVDCViewNameTab;
				
				@FindBy(how=How.XPATH,using="//div[@id='idEVDCGridPanel']//span[text()='Parent']")
				private WebElement nav_EVDCViewParentTab;
				
				@FindBy(how=How.XPATH,using="//div[@id='idEVDCGridPanel']//span[contains(text(),'VM Count')]")
				private WebElement nav_EVDCViewVMCountTab;
				
				@FindBy(how=How.XPATH,using="//div[@id='idEVDCGridPanel']//span[contains(text(),'Networks')]")
				private WebElement nav_EVDCViewNetworksTab;
				
				@FindBy(how=How.XPATH,using="//div[@id='idEVDCGridPanel']//span[contains(text(),'vCPUs')]")
				private WebElement nav_EVDCViewvCPUsTab;
				
				@FindBy(how=How.XPATH,using="//div[@id='idEVDCGridPanel']//span[contains(text(),'vRAM')]")
				private WebElement nav_EVDCViewvRAMTab;
				
				@FindBy(how=How.XPATH,using="//div[@id='idEVDCGridPanel']//span[contains(text(),'Storage')]")
				private WebElement nav_EVDCViewStorageTab;
				
				@FindBy(how=How.XPATH,using="//div[@id='idNOPagingToolbar-targetEl']/div[contains(text(),'of')]")
				private WebElement nav_EVDCViewTotalPage;
				
				@FindBy(how=How.XPATH,using="//div[@id='idNOPagingToolbar-targetEl']//span[contains(@class,'page-next')]")
				private WebElement nav_EVDCViewPageNextBtn;
					
				@FindBy(how=How.XPATH,using="//section[@id='idEVDCHeaderExport']/a//img[@alt='PDF']")
				private WebElement nav_EVDCViewPDFIcon;
				
				@FindBy(how=How.XPATH,using="//section[@id='idEVDCHeaderExport']/a//img[@alt='CSV']")
				private WebElement nav_EVDCViewCSVIcon;
					
				@FindBy(how=How.ID, using="idEVDCSearchBox-inputEl")
				private WebElement nav_EVDCViewSearchEdit;
				
				@FindBy(how=How.XPATH, using="//a[contains(text(),'Private Cloud')]")
				private WebElement nav_EVDCPvtCloudLink;
				
				@FindBy(how=How.XPATH, using="//span[@class='ssrsText']")
				private WebElement nav_ComputeStaticsText;
				
				@FindBy(how=How.ID, using="CreateTicketPopup_header_hd")
				private WebElement nav_ComputeStaticsReportPopupHdr;
				 
				@FindBy(how=How.XPATH, using="//span[text()='Cancel']")
				private WebElement nav_ComputeStaticsReportPopupCancelButton;
				
				@FindBy(how=How.XPATH, using="//img[contains(@src,'sample_dcmp_graph.png')]")
				private WebElement nav_ComputeStaticsReportGraphImage;
				
				@FindBy(how=How.XPATH, using="//a[text()='here']")
				private WebElement nav_ComputeStaticsReportClickHereLink;
			
			
	//=========================================================================================
	//END Moving the below objects from EVDC_OverviewPageFactory
	//=========================================================================================	
				//=========================================================================================
				//Start Moving the below objects from DashboardPageFactory
				//=========================================================================================	
				
				@FindBy(how=How.XPATH, using="//img[@alt='TierPoint logo']")
				private WebElement nav_WSLogo;
	
				
				@FindBy(how=How.XPATH,using="//*[@id='user']/a/nobr")
				private WebElement nav_UserNameLink;
				
				
				@FindBy(how=How.XPATH,using="//*[@id='user']")
				private WebElement nav_UserNameDropDown;
				
				
				//@FindBy(how=How.LINK_TEXT,using = "Logout")
				//@FindBy(how=How.XPATH,using="//li[@id='user']/ul/li/a[text()='Logout']")
				@FindBy(how=How.XPATH,using="//div[@id='styled_user']//li[@id='user']/ul/li/a[text()='Logout']")
				private WebElement nav_LogoutLink;
				//=========================================================================================
				//End Moving the below objects from DashboardPageFactory
				//=========================================================================================	
							
				
	//***************************************************
	
	public WebElement getNav_HomeEVDCPortlet() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_HomeEVDCPortlet;
	}
	
	/*public WebElement getNav_MultiSelectList() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_MultiSelectList;
	}

	public WebElement getNav_UseOrganizationBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_UseOrganizationBtn;
	}*/

	/*public WebElement getNav_MultiOrganizationUserLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_MultiOrganizationUserLink;
	}*/

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

	

	public WebElement getNav_StorageManageButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_StorageManageButton;
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

	public WebElement getNav_DRaaSC2CRTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DRaaSC2CRTitle;
	}


	public WebElement getNav_HomeTempPopUpCloseIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_HomeTempPopUpCloseIcon;
	}

	public WebElement getNav_OrgNameTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_OrgNameTitle;
	}


	public WebElement getNav_AddServicesLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddServicesLink;
	}

	public WebElement getNav_EVDCText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCText;
	}

	public WebElement getNav_TierPoint_ClientLogin() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TierPoint_ClientLogin;
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

	public WebElement getNav_EVDCname() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCname;
	}

	public WebElement getNav_Home_EVDCPortletsDivision() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Home_EVDCPortletsDivision;
	}

	public WebElement getNav_VMCountText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_VMCountText;
	}

	public WebElement getNav_VMCountNumberLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_VMCountNumberLink;
	}

	public WebElement getNav_Networks() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Networks;
	}

	public WebElement getNav_NetworksParentTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NetworksParentTable;
	}

	public WebElement getNav_vCPUs() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_vCPUs;
	}

	public WebElement getNav_Firewall() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Firewall;
	}

	public WebElement getNav_FirewallViewLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FirewallViewLink;
	}

	public WebElement getNav_vRam() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_vRam;
	}

	public WebElement getNav_Storage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Storage;
	}

	public WebElement getNav_vCloudDirector() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_vCloudDirector;
	}

	public WebElement getNav_vCPUSection() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_vCPUSection;
	}

	public WebElement getNav_vCPUSectionGraph() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_vCPUSectionGraph;
	}

	public WebElement getNav_vRAMSection() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_vRAMSection;
	}

	public WebElement getNav_vRAMSectionGraph() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_vRAMSectionGraph;
	}

	public WebElement getNav_EVDCViewHomeTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCViewHomeTable;
	}

	public WebElement getNav_EVDCViewNameTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCViewNameTab;
	}

	public WebElement getNav_EVDCViewParentTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCViewParentTab;
	}

	public WebElement getNav_EVDCViewVMCountTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCViewVMCountTab;
	}

	public WebElement getNav_EVDCViewNetworksTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCViewNetworksTab;
	}

	public WebElement getNav_EVDCViewvCPUsTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCViewvCPUsTab;
	}

	public WebElement getNav_EVDCViewvRAMTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCViewvRAMTab;
	}

	public WebElement getNav_EVDCViewStorageTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCViewStorageTab;
	}

	public WebElement getNav_EVDCViewTotalPage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCViewTotalPage;
	}

	public WebElement getNav_EVDCViewPageNextBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCViewPageNextBtn;
	}

	public WebElement getNav_EVDCViewPDFIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCViewPDFIcon;
	}

	public WebElement getNav_EVDCViewCSVIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCViewCSVIcon;
	}

	public WebElement getNav_EVDCViewSearchEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCViewSearchEdit;
	}

	public WebElement getNav_EVDCPvtCloudLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCPvtCloudLink;
	}

	public WebElement getNav_ComputeStaticsText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ComputeStaticsText;
	}

	public WebElement getNav_ComputeStaticsReportPopupHdr() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ComputeStaticsReportPopupHdr;
	}

	public WebElement getNav_ComputeStaticsReportPopupCancelButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ComputeStaticsReportPopupCancelButton;
	}

	public WebElement getNav_ComputeStaticsReportGraphImage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ComputeStaticsReportGraphImage;
	}

	public WebElement getNav_ComputeStaticsReportClickHereLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ComputeStaticsReportClickHereLink;
	}

	public WebElement getNav_CancelBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CancelBtn;
	}

	public WebElement getNav_OkBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_OkBtn;
	}

	public WebElement getNav_PriorityList() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PriorityList;
	}

	public WebElement getNav_CategoryList() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CategoryList;
	}

	public WebElement getNav_CreateTicketIframe() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateTicketIframe;
	}

	public WebElement getNav_CreateTicketSucessNotification() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateTicketSucessNotification;
	}

	public WebElement getNav_HomeTempPopUpOk() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_HomeTempPopUpOk;
	}

	public WebElement getNav_HomeDevicesAlerts() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_HomeDevicesAlerts;
	}

	public WebElement getNav_HomeBandwidth() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_HomeBandwidth;
	}

	public WebElement getNav_DraasHomeData() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DraasHomeData;
	}

	public WebElement getNav_WSLogo() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_WSLogo;
	}

	public WebElement getNav_SeverityListItem() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SeverityListItem;
	}

	public WebElement getNav_PriorityListItem() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PriorityListItem;
	}

	public WebElement getNav_CategoryListItem() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CategoryListItem;
	}

	public WebElement getNav_CreateTicketSucessNotificationOKBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateTicketSucessNotificationOKBtn;
	}

	public WebElement getNav_UserNameLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_UserNameLink;
	}

	public WebElement getNav_UserNameDropDown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_UserNameDropDown;
	}

	public WebElement getNav_LogoutLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_LogoutLink;
	}

	
	
}
