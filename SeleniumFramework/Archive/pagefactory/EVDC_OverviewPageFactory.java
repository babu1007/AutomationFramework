package com.whs.navigator.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class EVDC_OverviewPageFactory {
	
	//EVDC Name
	//@FindBy(how=How.XPATH,using="//main/div/section[@class='rectangle long evdc'][1]//h2[@id='edvc_1']/a")
	//Commenting the above as xpath got change - Vivek - 12/4/2015
	@FindBy(how=How.XPATH,using="//div[@id='nav_org_maindev']//section[1]//h2[@id='edvc_1']/a")
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
	
	// this below elements is added by NMR - 06/29/2016
	// firewall more text
	@FindBy(how=How.ID, using="cat_iipMore")
	private WebElement nav_FirewallMoreText;
	
	@FindBy(how=How.XPATH, using="//section[@id='firewall']//ul[@id='cat_vm']/li[1]")
	private WebElement nav_FirewallRulesText;
	
	@FindBy(how=How.ID, using="cat_rules")
	private WebElement nav_FirewallRulesCount;
	
	@FindBy(how=How.XPATH, using="//section[@id='firewall']//ul[@id='cat_vm']/li[2]")
	private WebElement nav_FirewallVPNTunnelsText;
	
	@FindBy(how=How.ID, using="cat_vpn_tunnels")
	private WebElement nav_FirewallVPNTunnelsCount;
	
	@FindBy(how=How.XPATH, using="//section[@id='firewall']//ul[@id='cat_vm']/li[3]")
	private WebElement nav_FirewallVPNUsersText;
	
	@FindBy(how=How.ID, using="cat_vpn_users")
	private WebElement nav_FirewallVPNUsersCount;
	
	@FindBy(how=How.XPATH, using="//section[@id='firewall']//ul[@id='cat_vm']/li[4]")
	private WebElement nav_FirewallNATSText;
	
	@FindBy(how=How.ID, using="cat_nats")
	private WebElement nav_FirewallNATSCount;
	
	@FindBy(how=How.XPATH, using="//section[@id='firewall']//ul[@id='cat_vm']/li[5]")
	private WebElement nav_FirewallOutsideIpText;
	
	@FindBy(how=How.ID, using="cat_oip")
	private WebElement nav_FirewallOutsideIpCount;
	
	@FindBy(how=How.XPATH, using="//section[@id='firewall']//ul[@id='cat_vm']/li[6]")
	private WebElement nav_FirewallInsideIpText;
	
	@FindBy(how=How.ID, using="cat_iip")
	private WebElement nav_FirewallInsideIpCount;
	
	//vRam
	@FindBy(how=How.XPATH,using="//*[@id='edvc_1']/a/../../../section[3]/section[2]/ul/li[contains(text(),'vRam')]")
	private WebElement nav_vRam;
	
	//Storage
	@FindBy(how=How.XPATH, using="//*[@id='edvc_1']/a/../../../section[3]/section[3]/ul/li[2]")
	private WebElement nav_Storage;
	
	//VCloud Director
	@FindBy(how=How.XPATH, using="//span/a[contains(text(),'vCloud Director')]")
	private WebElement nav_vCloudDirector;
	
	
	//EVDC overview Page
	
	//EVDC overview breadcrumb
	@FindBy(how=How.LINK_TEXT,using="EVDC Overview")
	private WebElement nav_EVDCOverViewLink;
	
	//Virtual Machine
	@FindBy(how=How.LINK_TEXT,using="Virtual Machines")
	private WebElement nav_EVDCOverviewVirtualMachine;
	
	//Catalogs
	@FindBy(how=How.LINK_TEXT,using="Catalogs")
	private WebElement nav_EVDCOverviewCatalogs;
	
	//Storage
   //@FindBy(how=How.XPATH,using="//h2[contains(text(),'Storage')]")
	//commented the above line and added the below line as part of EXTJS5 change-Vivek - 10082015
	@FindBy(how=How.XPATH,using="//h2/a[text()='Storage']")
	private WebElement nav_EVDCOverviewStorage;
	
	//Cloud AV
	//@FindBy(how=How.LINK_TEXT,using="Cloud AV")
	//commented the above line and added the below line as part of EXTJS5 change-Vivek - 10082015
	@FindBy(how=How.XPATH,using="//h2/a[text()='Cloud AV']")
	private WebElement nav_EVDCOverviewCloudAV;
	
	//Cloud Migrations
	//@FindBy(how=How.LINK_TEXT,using="Cloud Migrations")
	//commented the above line and added the below line as part of EXTJS5 change-Vivek - 10082015
	@FindBy(how=How.XPATH,using="//h2/a[text()='Cloud Migrations']")
	private WebElement nav_EVDCOverviewCloudMigrations;
	
	//Networks
	@FindBy(how=How.XPATH,using="//h2[contains(text(),'Networks')]")
	private WebElement nav_EVDCOverviewNetworks;
	
	//Feedback 
	@FindBy(how=How.LINK_TEXT,using="Feedback")
	private WebElement nav_EVDCOverviewFeedback;
	
	//Compute Statistics
	@FindBy(how=How.LINK_TEXT,using="Compute Statistics")
	private WebElement nav_EVDCOverviewComputeStatistics;
	
	//Firewall
	@FindBy(how=How.LINK_TEXT,using="Firewall")
	private WebElement nav_EVDCOverviewFirewall;
	
	//Bandwidth
	@FindBy(how=How.LINK_TEXT,using="Bandwidth")
	private WebElement nav_EVDCOverviewBandwidth;
	
	//This Element is created on 10/08/2015 for EXTJS5 by QAA03
	@FindBy(how=How.ID,using="evdc_bandwidth")
	private WebElement nav_BandwidthPortlet;

	@FindBy(how=How.XPATH,using="//*[@class='evdc_options']/a")
	private WebElement nav_EVDCOrgSelector;
	
	@FindBy(how=How.XPATH,using="//li[@class='evdc_options']//ul")
	private WebElement nav_EVDCOrgSelectorUL;
	
	
	//SVG files
	//vCPU
	//@FindBy(how=How.XPATH,using="//*[name()='svg']//*[name()='text']/*[name()='tspan'][contains(text(),'vCPU')]")
	@FindBy(how=How.XPATH,using="//div[@id='nav_org_maindev']//*[name()='svg']//*[name()='text'][1]/*[name()='tspan'][contains(text(),'vCPU')]")
	private WebElement nav_vCPUsvg;
	
	//vRAM
	//@FindBy(how=How.XPATH,using="//*[name()='svg']//*[name()='text']/*[name()='tspan'][contains(text(),'GB')]")
	@FindBy(how=How.XPATH,using="//div[@id='nav_org_maindev']//div[@id='vram_1']//*[name()='svg']//*[name()='text'][1]/*[name()='tspan'][contains(text(),'GB')]")
	private WebElement nav_vRAMsvg;
	
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
	
	//#####################################################################################
	//#####################################################################################
	
	//*******************************QAA03************************************//
		//Taken from Clark 

	@FindBy(how=How.XPATH, using="//a[text()='Compute Statistics']")
	private WebElement ComputerStatisticsLink;
	
	@FindBy(how=How.ID, using="vcpu-chart")
	private WebElement CS_CpuAllocationGraph;
	
	@FindBy(how=How.ID, using="vmem-chart")
	private WebElement CS_MemoryAllocationGraph;
	
	@FindBy(how=How.XPATH, using="//div[@id='vcpu-chart']//*[name()='svg']//*[name()='g'][@class='highcharts-button']")
	private WebElement CS_CpuAllocationMenu;
	
	@FindBy(how=How.XPATH, using="//div[@id='vmem-chart']//*[name()='svg']//*[name()='g'][@class='highcharts-button']")
	private WebElement CS_MemoryAllocationMenu;
	
	@FindBy(how=How.XPATH, using=" //div[@id='vcpu-chart']//div[contains(@style,'box-shadow:')]")
	private WebElement CS_CpuChartMenuData;
	
	@FindBy(how=How.XPATH, using=" //div[@id='vmem-chart']//div[contains(@style,'box-shadow:')]")
	private WebElement CS_MemoryChartMenuData;
	
	

	
	public WebElement getComputerStatisticsLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return ComputerStatisticsLink;
	}
	
	public WebElement getCS_CpuAllocationGraph() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return CS_CpuAllocationGraph;
	}
	
	public WebElement getCS_MemoryAllocationGraph() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return CS_MemoryAllocationGraph;
	}
	
	public WebElement getCS_CpuAllocationMenu() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return CS_CpuAllocationMenu;
	}
	
	public WebElement getCS_MemoryAllocationMenu() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return CS_MemoryAllocationMenu;
	}
	
	public WebElement getCS_CpuChartMenuData() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return CS_CpuChartMenuData;
	}
	
	public WebElement getCS_MemoryChartMenuData() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return CS_MemoryChartMenuData;
	}
	
		
			
	//*******************************QAA03************************************//
	//*******************************QAA04************************************//
	// taken from clark Pagecfactory
	@FindBy(how=How.XPATH,using="//a[text()='Add Storage Tier']")
	private WebElement nav_AddStoraegTeirLink;
	
	@FindBy(how=How.ID, using = "CreateTicketPopup")
	private WebElement nav_CreateTicketPopUp;
	
	@FindBy(how=How.ID, using = "createTicketTitle-inputEl")
	private WebElement nav_CreateTicketTitleEditBox;
	
	//@FindBy(how=How.XPATH, using="//section[@class='evdc_heading block_header']//a[contains(text(),'Private')][1]")
	@FindBy(how=How.XPATH,using="//div[@id='nav_org_maindev']//section[@class='evdc_heading block_header']//a[contains(text(),'Private')][1]")
	private WebElement nav_PrivateEVDCLink;
	
	
	@FindBy(how=How.XPATH, using = "//table[@class='marketing_table']//table[contains(@class,'marketing_table_2')]//span")
	private WebElement nav_CloudAVPageTitle;
	
	@FindBy(how=How.ID, using="loadBalancers")
	private WebElement nav_EVDCLoadBalancerPortlet;
	
	@FindBy(how=How.XPATH, using="//ul[@id='cat_vm']/li[text()='Instances']")
	private WebElement nav_EVDCLBInstances;
	
	@FindBy(how=How.XPATH, using="//ul[@id='cat_vm']/li[text()='VIPs']")
	private WebElement nav_EVDCLBVips;
	
	@FindBy(how=How.XPATH, using="//ul[@id='cat_vm']/li[text()='Pools']")
	private WebElement nav_EVDCLBPools;
	
	@FindBy(how=How.XPATH, using="//ul[@id='cat_vm']/li[text()='Members']")
	private WebElement nav_EVDCLBMembers;
	
	@FindBy(how=How.XPATH, using="//section[@id='loadBalancers']//ul[@id='val_vm']/li[1]")
	private WebElement nav_EVDCLBInstancesVal;
	
	@FindBy(how=How.XPATH, using="//section[@id='loadBalancers']//ul[@id='val_vm']/li[2]")
	private WebElement nav_EVDCLBVipsVal;
	
	@FindBy(how=How.XPATH, using="//section[@id='loadBalancers']//ul[@id='val_vm']/li[3]")
	private WebElement nav_EVDCLBPoolsVal;
	
	@FindBy(how=How.XPATH, using="//section[@id='loadBalancers']//ul[@id='val_vm']/li[4]")
	private WebElement nav_EVDCLBMembersVal;
	
	@FindBy(how=How.XPATH, using="//section[@id='loadBalancers']/div/h2/a")
	private WebElement nav_EVDCLBLink;
	
	@FindBy(how=How.ID, using="virtualIPsTab")
	private WebElement nav_VirtualIPTab;
	
	@FindBy(how=How.XPATH, using="//div[@id='vips-create']/span/a")
	private WebElement nav_LoadBalAddVIP;
	
	//@FindBy(how=How.XPATH, using="//iframe[Contains(@id,'inputCmp-iframeEl')]")
	@FindBy(how=How.ID, using="htmleditor-1032-inputCmp-iframeEl")
	private WebElement nav_AddVirtualIPPopUp;
	
	//@FindBy(how=How.XPATH, using="//div[Contains(@id,'targetEl')]//span[text()='OK']")
	@FindBy(how=How.XPATH, using=".//*[@id='button-1062-btnInnerEl']")
	private WebElement nav_AddVirtualIPPopUpOkBtn;
	
	@FindBy(how=How.ID, using="poolsTab")
	private WebElement nav_PoolsTab;
	
	@FindBy(how=How.ID, using="instanceTab")
	private WebElement nav_InstancesTab;
	
	@FindBy(how=How.XPATH, using="//div[@id='ldblncr-instance_create']/span/a")
	private WebElement nav_EVDCAddLBLink;
	
	@FindBy(how=How.XPATH, using="//div[@id='vips-print']/a/img[@alt='PDF']")
	private WebElement nav_EVDCInstancePdfIcon;
	
	@FindBy(how=How.XPATH, using="//div[@id='vips-print']/a/img[@alt='CSV']")
	private WebElement nav_EVDCInstanceCsvIcon;
	
	//@FindBy(how=How.XPATH, using="//div[@id='instancePanel']/div[Contains(@id,'headercontainer')]")
	@FindBy(how=How.XPATH, using="//div[@id='instancePanel']/div[1]/div/div")
	private WebElement nav_EVDCInstanceLBHeader;
	
	
	// storage portlet allocated data in GB
		@FindBy(how=How.XPATH, using="//div[@id='chart_storage']//li[2]//*[name()='svg']//*[name()='text']/*[name()='tspan'][contains(text(),'GB')]")
		private WebElement nav_StoragePortlet_AllocatedData;
		

	
	//******************************* QAA04 ************************************//
	
	/////******************Keffer Pagefactory Elements QAA03*********************////
		
		@FindBy(how=How.ID, using="messagebox-1001-msg")
		private WebElement nav_NoEVDCPopUpMessage;
		
		@FindBy(how=How.XPATH, using="//div[contains(@id,'-toolbar-targetEl')]//span[text()='Yes']")
		private WebElement nav_NoEVDCPopUpYesButton;
		
		@FindBy(how=How.XPATH, using="//div[contains(@id,'-toolbar-targetEl')]//span[text()='No']")
		private WebElement nav_NoEVDCPopUpNoButton;
		
		@FindBy(how=How.XPATH, using="//div[@id='panel-1010-innerCt']//img[@src='/navorganization-portlet/resources/images/Add_Dummy.PNG']")
		private WebElement nav_EVDCImage;
		
	//#################################################################################	
		
		//EVDC First Network Name field
		@FindBy(how=How.XPATH, using="//div[@id='evdcNetworksMainTable-body']//table/tbody/tr/td[1]/div")
		//@FindBy(how=How.XPATH, using="//div[@id='evdcNetworksMainTable-body']//table/tbody/tr/td[Contains(@Class,'first')]/div")
		private WebElement nav_EVDCFirstNetworkName;
		
		@FindBy(how=How.ID, using="storageProfileCharts")
		private WebElement nav_EVDCStorageProfileChart;
	//#################################################################################
		
		public WebElement getNav_EVDCStorageProfileChart() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EVDCStorageProfileChart;
		}
		
		public WebElement getNav_EVDCFirstNetworkName() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EVDCFirstNetworkName;
		}
	
	public WebElement getNav_EVDCAddLBLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCAddLBLink;
	}
	public WebElement getNav_StoragePortlet_AllocatedData() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_StoragePortlet_AllocatedData;
	}

	public WebElement getNav_EVDCInstancePdfIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCInstancePdfIcon;
	}
	public WebElement getNav_EVDCInstanceCsvIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCInstanceCsvIcon;
	}
	public WebElement getNav_EVDCInstanceLBHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCInstanceLBHeader;
	}
	
	public WebElement getNav_PoolsTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PoolsTab;
	}
	public WebElement getNav_InstancesTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_InstancesTab;
	}
	
	public WebElement getNav_AddVirtualIPPopUpOkBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddVirtualIPPopUpOkBtn;
	}
	
	public WebElement getNav_AddVirtualIPPopUp() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddVirtualIPPopUp;
	}
	
	public WebElement getNav_LoadBalAddVIP() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_LoadBalAddVIP;
	}

	public WebElement getNav_VirtualIPTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_VirtualIPTab;
	}
	
	public WebElement getNav_EVDCLBLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCLBLink;
	}
	
	public WebElement getNav_EVDCLBInstancesVal() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCLBInstancesVal;
	}
	
	public WebElement getNav_EVDCLBVipsVal() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCLBVipsVal;
	}
	
	public WebElement getNav_EVDCLBPoolsVal() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCLBPoolsVal;
	}
	
	public WebElement getNav_EVDCLBMembersVal() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCLBMembersVal;
	}

	public WebElement getNav_EVDCLBMembers() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCLBMembers;
	}
	
	public WebElement getNav_EVDCLBPools() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCLBPools;
	}
	
	public WebElement getNav_EVDCLBVips() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCLBVips;
	}
	
	public WebElement getNav_EVDCLBInstances() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCLBInstances;
	}
		
	public WebElement getNav_EVDCLoadBalancerPortlet() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCLoadBalancerPortlet;
	}
	
	public WebElement getNav_EVDCname() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCname;
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

	public WebElement getNav_EVDCOverViewLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCOverViewLink;
	}

	public WebElement getNav_EVDCOverviewVirtualMachine() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCOverviewVirtualMachine;
	}

	public WebElement getNav_EVDCOverviewCatalogs() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCOverviewCatalogs;
	}

	public WebElement getNav_EVDCOverviewStorage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCOverviewStorage;
	}

	public WebElement getNav_EVDCOverviewCloudAV() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCOverviewCloudAV;
	}

	public WebElement getNav_EVDCOverviewCloudMigrations() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCOverviewCloudMigrations;
	}

	public WebElement getNav_EVDCOverviewNetworks() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCOverviewNetworks;
	}

	public WebElement getNav_EVDCOverviewFeedback() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCOverviewFeedback;
	}

	public WebElement getNav_EVDCOverviewComputeStatistics() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCOverviewComputeStatistics;
	}

	public WebElement getNav_EVDCOverviewFirewall() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCOverviewFirewall;
	}

	public WebElement getNav_EVDCOverviewBandwidth() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCOverviewBandwidth;
	}

	public WebElement getNav_BandwidthPortlet() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_BandwidthPortlet;
	}

	public WebElement getNav_vCPUsvg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_vCPUsvg;
	}

	public WebElement getNav_vRAMsvg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_vRAMsvg;
	}

	public WebElement getNav_EVDCOrgSelector() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCOrgSelector;
	}

	public WebElement getNav_AddStoraegTeirLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddStoraegTeirLink;
	}

	public WebElement getNav_CreateTicketPopUp() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateTicketPopUp;
	}

	public WebElement getNav_CreateTicketTitleEditBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateTicketTitleEditBox;
	}

	public WebElement getNav_PrivateEVDCLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PrivateEVDCLink;
	}

	public WebElement getNav_CloudAVPageTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CloudAVPageTitle;
	}

	public WebElement getNav_EVDCOrgSelectorUL() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCOrgSelectorUL;
	}

	public WebElement getNav_NetworksParentTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NetworksParentTable;
	}

	public WebElement getNav_Home_EVDCPortletsDivision() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Home_EVDCPortletsDivision;
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
	
	public WebElement getNav_NoEVDCPopUpMessage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NoEVDCPopUpMessage;
	}

	public WebElement getNav_NoEVDCPopUpYesButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NoEVDCPopUpYesButton;
	}

	public WebElement getNav_NoEVDCPopUpNoButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NoEVDCPopUpNoButton;
	}

	public WebElement getNav_EVDCImage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCImage;
	}

	public WebElement getNav_vCPUSection() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_vCPUSection;
	}

	public WebElement getNav_vRAMSection() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_vRAMSection;
	}

	public WebElement getNav_vCPUSectionGraph() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_vCPUSectionGraph;
	}

	public WebElement getNav_vRAMSectionGraph() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_vRAMSectionGraph;
	}

	public WebElement getNav_FirewallMoreText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FirewallMoreText;
	}

	public WebElement getNav_FirewallRulesText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FirewallRulesText;
	}

	public WebElement getNav_FirewallRulesCount() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FirewallRulesCount;
	}

	public WebElement getNav_FirewallVPNTunnelsText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FirewallVPNTunnelsText;
	}

	public WebElement getNav_FirewallVPNTunnelsCount() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FirewallVPNTunnelsCount;
	}

	public WebElement getNav_FirewallVPNUsersText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FirewallVPNUsersText;
	}

	public WebElement getNav_FirewallVPNUsersCount() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FirewallVPNUsersCount;
	}

	public WebElement getNav_FirewallNATSText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FirewallNATSText;
	}

	public WebElement getNav_FirewallNATSCount() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FirewallNATSCount;
	}

	public WebElement getNav_FirewallOutsideIpText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FirewallOutsideIpText;
	}

	public WebElement getNav_FirewallOutsideIpCount() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FirewallOutsideIpCount;
	}

	public WebElement getNav_FirewallInsideIpText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FirewallInsideIpText;
	}

	public WebElement getNav_FirewallInsideIpCount() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FirewallInsideIpCount;
	}

	

	

}
