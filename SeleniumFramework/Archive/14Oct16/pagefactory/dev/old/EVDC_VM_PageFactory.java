package com.whs.navigator.pagefactory.dev.old;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class EVDC_VM_PageFactory {
	
	@FindBy(how=How.XPATH,using="//section/div/div/p")
	private WebElement nav_UserfeedBack;
	
	@FindBy(how=How.XPATH,using="//section/div/div/p/img")
	private WebElement nav_UserfeedBackImage;
	
	@FindBy(how=How.ID,using="navpopupmessage")
	private WebElement nav_NewEVDCPopUpMessage;
	
	@FindBy(how=How.ID,using="navpopupbody")
	private WebElement nav_NewEVDCPopUpBody;
	
	@FindBy(how=How.XPATH,using="//div[@id='navpopupbody']//div[@id='navpopupbuttons']/span[1]/a[contains(text(),'Ok')]")
	private WebElement nav_NewEVDCPopUpOKBtn;
	
	@FindBy(how=How.XPATH,using="//div[@id='navpopupbody']//div[@id='navpopupbuttons']/span[2]/a[contains(text(),'Cancel')]")
	private WebElement nav_NewEVDCPopUpCancelBtn;
	
	@FindBy(how=How.ID,using="button-1005-btnIconEl")
	private WebElement nav_PopUpOKBtn;
	
	@FindBy(how=How.XPATH,using="//img[@src='/navorganization-portlet/resources/images/Add.png']")
	private WebElement nav_EVDCMarketingImage;
		
	
	
	//@FindBy(how=How.LINK_TEXT,using="Add Virtual Machine")
	//commented the above line and added the below line as part of EXTJS5 change-Vivek - 10082015
	@FindBy(how=How.XPATH,using="//a[text()='Add Virtual Machine']")
	private WebElement nav_AddVMLink;
	
	
	@FindBy(how=How.XPATH,using="//div[@id='vmListExtGridPanel-body']")
	private WebElement nav_VMWebTableParent;
	
	//@FindBy(how=How.XPATH,using="//div[2]/a[1]/img")
	@FindBy(how=How.XPATH,using="//div[@id='vm_print']/a[1]/img")
	//commented the above line and added the below line as part of EXTJS5 change-Vivek - 10082015
	private WebElement nav_PDFImg;
	
	//@FindBy(how=How.XPATH,using="//div[2]/a[1]/img/..")
	//commented the above line and added the below line as part of EXTJS5 change-Vivek - 10082015
	@FindBy(how=How.XPATH,using="//div[@id='vm_print']/a[1]/img/..")
	private WebElement nav_PDFLink;
		
	@FindBy(how=How.XPATH,using="//div[2]/a[2]/img")
	private WebElement nav_CSVImg;
	
	@FindBy(how=How.XPATH,using="//div[2]/a[2]/img/..")
	private WebElement nav_CSVLink;
	

	@FindBy(how=How.XPATH,using="//span/a[contains(text(),'Home')]")
	private WebElement nav_HomeBreadCrumb;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'EVDC Overview')]")
	private WebElement nav_EVDCBreadCrumb;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Virtual Machines')]")
	private WebElement nav_VMBreadCrumb;
	

	@FindBy(how=How.XPATH,using="//*[@id='headercontainer-1009-innerCt']")
	private WebElement nav_VMTabList;
	
	
	

	//###########################
	//Network Details
	//###########################
	@FindBy(how=How.XPATH,using="//span[contains(text(),'NIC ID')]")
	private WebElement nav_NetworkNICIDTab;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'NIC IP')]")
	private WebElement nav_NetworkNICIPTab;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Status')]")
	private WebElement nav_NetworkStatusTab;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'MAC Address')]")
	private WebElement nav_NetworkMACAddressTab;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Network')]")
	private WebElement nav_NetworkTab;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Primary')]")
	private WebElement nav_NetworkPrimaryTab;
	
	//###########################
	//Storage Details
	//###########################
	// this object added by QAA04 - 2/3/16
	@FindBy(how=How.LINK_TEXT, using="Storage Details")
	private WebElement nav_StorageDetailsLink;
	
	// this object added by QAA04 - 2/3/16
	@FindBy(how=How.XPATH, using="//div[contains(@id,'sdPanel-urn:vcloud:vm:')][contains(@class,'x-panel-body-default')]")
	private WebElement nav_StorageDetailsWebTableParent;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Disk Name')]")
	private WebElement nav_StorageDiskName;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Size')]")
	private WebElement nav_StorageName;
	
	@FindBy(how=How.XPATH,using="//span[contains(text(),'SCSI Identifier')]")
	private WebElement nav_StorageSCSI;
		
	//Start PopUp Message
	//@FindBy(how=How.XPATH,using="//div/div[text()='Sending Start request...'")
	@FindBy(how=How.XPATH,using="/html/body/div[9]/div/div")
	private WebElement nav_StartPopUpMsg;
	
	@FindBy(how=How.XPATH,using="//div/div[text()='Please wait...']")
	private WebElement nav_PlzWaitPopUpMsg;
	
	//Reset Popup message
	@FindBy(how=How.XPATH,using="//div/div[text()='Sending Reset request...']")
	private WebElement nav_ResetPopUpMsg;	
	
	//Stop Popup Message
	/*@FindBy(how=How.XPATH,using="//div/div[text()='Sending Stop request...']")
	private WebElement nav_StopPopUpMsg;
	*/
	
	//Stop Popup Message
	@FindBy(how=How.XPATH,using="//div/div[text()='Sending Stop request...']")
	private WebElement nav_StopPopUpMsg;
	
	//Suspend popup message
	@FindBy(how=How.XPATH,using="//div/div[text()='Sending Suspend request...']")
	private WebElement nav_SuspendPopUpMsg;
	//Reset popup message
	@FindBy(how=How.XPATH,using="//div/div[text()='Refreshing VM Info ...']")
	private WebElement nav_RefreshPopUpMsg;
		

	//###########################
		//Virtual Machine Console
	//###########################
	
	@FindBy(how=How.XPATH,using="//object")
	private WebElement nav_ConsoleWindow;
	
	//@FindBy(how=How.XPATH,using="//div[1]/div/div/div/div[2]/img")
	//Commented the above line and added the below line as part of EXTJS5 change-Vivek-10082015
	@FindBy(how=How.XPATH,using="//img[@class='x-tool-img x-tool-close']")
	private WebElement nav_ConsoleClose;
	
	@FindBy(how=How.ID,using="vm_button_ctrlaltdel")
	private WebElement nav_ConsoleCtrlAltDelBtn;
		
	
	//General Tab
		@FindBy(how=How.XPATH,using="//a[contains(text(),'General')]")
		private WebElement nav_EditGeneralTab;
		
		@FindBy(how=How.XPATH,using="//*[@id='vmEditNameGroup']/div[contains(text(),'VM Name')]")
		private WebElement nav_EditGeneralVMName;
		
		@FindBy(how=How.XPATH,using="//*[@id='vmOsFamilyGroup']/div[contains(text(),'Operating System Family')]")
		private WebElement nav_EditGeneralOperatingSystemFamily;
		
		//@FindBy(how=How.XPATH,using="//*[@id='vmOsFamilyGroup']/div[contains(text(),'Operating System Family')]//img[@alt='infoIcon']")
		@FindBy(how=How.XPATH,using="//*[@id='vmOsFamilyGroup']/div[contains(text(),'Operating System Family')]/span/span")
		private WebElement nav_EditOSFamilyToolTipMsg;
		
		@FindBy(how=How.XPATH,using="//*[@id='vmOsGroup']/div[contains(text(),'Operating System')]")
		private WebElement nav_EditGeneralOS;
		
		//@FindBy(how=How.XPATH,using="//*[@id='vmOsGroup']/div[contains(text(),'Operating System')]//img[@alt='infoIcon']")
		@FindBy(how=How.XPATH,using="//*[@id='vmOsGroup']/div[contains(text(),'Operating System')]/span/span")
		private WebElement nav_EditOSToolTipMsg;
		
		@FindBy(how=How.XPATH,using="//*[@id='vmDescriptionGroup vm_edit_sub_title']/div[contains(text(),'Description')]")
		private WebElement nav_EditGeneralDescription;
		
		@FindBy(how=How.XPATH,using="//*[@id='vmStorageProfileGroup']/div[contains(text(),'Storage Profile')]")
		private WebElement nav_EditGeneralStorageprofile;
		
		//@FindBy(how=How.XPATH,using="//*[@id='vmStorageProfileGroup']/div[contains(text(),'Storage Profile')]//img[@alt='infoIcon']")
		@FindBy(how=How.XPATH,using="//*[@id='vmStorageProfileGroup']/div[contains(text(),'Storage Profile')]/span/span")
		private WebElement nav_EditStorageProfileToolTipMsg; 
		
		/*@FindBy(how=How.XPATH,using="//*[@id='cancelVMEdit']")
		private WebElement nav_EditGeneralCancelBtn;
		
		@FindBy(how=How.XPATH,using="//*[@id='saveVMEdit']")
		private WebElement nav_EditGeneralSaveBtn;*/
		
		@FindBy(how=How.XPATH,using="//*[@id='closeWindowButtonDiv']/button")
		private WebElement nav_EditGeneralCloseBtn;
		
		@FindBy(how=How.XPATH,using="//div[1]/span[@class='star_color']")
		private WebElement nav_EditVMNameRequired;
		
		@FindBy(how=How.XPATH,using="//*[@id='vmName-inputEl']")
		private WebElement nav_EditVMNameInput;
		
		@FindBy(how=How.XPATH,using="//*[@id='vmDescription-inputEl']")
		private WebElement nav_EditDescriptionInput;
		
		@FindBy(how=How.XPATH,using="//li[@role='alert' and text()='Required']")
		private WebElement nav_EditGeneralVMNameErrMsg;
		
		//@FindBy(how=How.XPATH,using="//*[@id='vmEditNameGroup']/div[contains(text(),'VM Name')]//img[@alt='infoIcon']")
		@FindBy(how=How.XPATH,using="//*[@id='vmEditNameGroup']/div[contains(text(),'VM Name')]/span/span")
		private WebElement nav_EditVMNameToolTipMsg;
		

		//###########################
		//Edit Button
		//###########################
		@FindBy(how=How.XPATH,using="//*[@id='cancelVMEdit']")
		private WebElement nav_EditVMCancelBtn;
		
		@FindBy(how=How.XPATH,using="//*[@id='saveVMEdit']")
		private WebElement nav_EditVMSaveBtn;
		
		@FindBy(how=How.XPATH,using="//span/span[contains(text(),'Commit')]")
		private WebElement nav_EditVMCommit;
		
		@FindBy(how=How.XPATH,using="//span/span[contains(text(),'Go Back')]")
		private WebElement nav_EditVMGoBack;
		
		
		//Compute Storage
		
		@FindBy(how=How.XPATH,using="//a[contains(text(),'Compute & Storage')]")
		private WebElement nav_EditComputeStorage;
		
		@FindBy(how=How.XPATH,using="//a[contains(text(),'Add Disk')]")
		private WebElement nav_ComputeStorageAddDisk;
		
		@FindBy(how=How.XPATH,using="//li[@role='alert' and text()='- is not a valid number']")
		private WebElement nav_ComputeStoragevCPUTooltipMsg;
		
		@FindBy(how=How.XPATH,using="//input[@id='editVCPU-inputEl']")
		private WebElement nav_ComputeStoragevCPUEdit;
		
		//@FindBy(how=How.ID,using="editVCPU-inputCell")
		//Commented the above code as aprt of EXTJS5
		@FindBy(how=How.ID,using="editVCPU-inputWrap")
		private WebElement nav_ComputeStoragevCPUEdtParent;
		
		
		@FindBy(how=How.ID,using="editVRAMTotal")
		private WebElement nav_ComputeStoragevRAMEdit;
		
		//@FindBy(how=How.ID,using="editVRAM-inputCell")
		//Commented the above code as aprt of EXTJS5
		@FindBy(how=How.ID,using="editVRAM-inputWrap")
		private WebElement nav_ComputeStoragevRAMEdtParent;
		
		//@FindBy(how=How.ID,using="editTotalVRAMUnit-inputCell")
		@FindBy(how=How.ID,using="editVRAMUnitInputId")
		private WebElement nav_ComputeStorageRAMUnit;
		
		@FindBy(how=How.XPATH,using="//div[contains(@id,'boundlist-')]/div/ul[@class='x-list-plain']")
		private WebElement nav_ComputeStorageRAMUnitDropDown;
		
		
		@FindBy(how=How.ID,using="container-1004")
		private WebElement nav_ComputeStorageErrMsg; 
		
	/*	@FindBy(how=How.XPATH,using="//*[@id='saveVMEdit']")
		private WebElement nav_ComputeStorageSaveEdit;
		
		@FindBy(how=How.XPATH,using="//*[@id='cancelVMEdit']")
		private WebElement nav_ComputeStorageCancel;*/
		
		@FindBy(how=How.XPATH,using="//div[contains(text(),'Number of vCPUs')]")
		private WebElement nav_ComputeStorageNumOfvCPUs;
		
		@FindBy(how=How.XPATH,using="//div[contains(text(),'Total vRam')]")
		private WebElement nav_ComputeStorageTotalvRAM;
		
		@FindBy(how=How.XPATH,using="//div[contains(text(),'vCPU Hot Add')]")
		private WebElement nav_ComputeStoragevCPUHotAdd;
		
		@FindBy(how=How.XPATH,using="//div[contains(text(),'vRAM Hot Add')]")
		private WebElement nav_ComputeStoragevRAMHotAdd;
		
		@FindBy(how=How.XPATH,using="//div[contains(text(),'Disks')]")
		private WebElement nav_ComputeStorageDisk;
		
		@FindBy(how=How.XPATH,using="//span[contains(text(),'Hardware')]")
		private WebElement nav_ComputeStorageHardware;
		
		/*@FindBy(how=How.XPATH,using="//span/span[contains(text(),'Commit')]")
		private WebElement nav_ComputeStorageCommit;
		
		@FindBy(how=How.XPATH,using="//span/span[contains(text(),'Go Back')]")
		private WebElement nav_ComputeStorageGoBack;
		*/
		//NICs
		@FindBy(how=How.XPATH,using="//a[contains(text(),'NICs')]")
		private WebElement nav_EditNICs;
		
		@FindBy(how=How.XPATH, using="//div[@id='editVmNics']//span[contains(text(),'NIC ID')]")
		private WebElement nav_NICsNICID;
		
		@FindBy(how=How.XPATH,using="//div[@id='editVmNics']//span[contains(text(),'Primary NIC')]")
		private WebElement nav_NICsPrimaryNIC;
		
		@FindBy(how=How.XPATH,using="//div[@id='editVmNics']//span[contains(text(),'Network')]")
		private WebElement nav_NICsNetwork;
		
		@FindBy(how=How.XPATH,using="//div[@id='editVmNics']//span[contains(text(),'IP Mode')]")
		private WebElement nav_NICsIPMode;
		
		@FindBy(how=How.ID,using="ipMode-0-trigger-picker")
		private WebElement nav_NICIPMode;
		
		@FindBy(how=How.XPATH,using=".//ul[@data-ref='listEl']")
		private WebElement nav_NICIPModelist;
		
		//@FindBy(how=How.ID,using="nicip-0")
		@FindBy(how=How.XPATH,using="//input[@componentid='nicip-0']")
		private WebElement nav_NICIPAddress;
		
		@FindBy(how=How.XPATH,using="//div[@id='editVmNics']//span[contains(text(),'IP Address')]")
		private WebElement nav_NICsIPAddress;
		
		@FindBy(how=How.XPATH,using="//div[@id='editVmNics']//span[contains(text(),'Status')]")
		private WebElement nav_NICsStatus;
		
		//@FindBy(how=How.XPATH,using=".//div[@id='editNicsPanel-body']/div/table")
		//commented the above line and added the below line as part of EXTJS5 change-Vivek - 10082015
		@FindBy(how=How.XPATH,using=".//div[@id='editNicsPanel-body']/div")
		private WebElement nav_NICWebTable;
		
		@FindBy(how=How.XPATH,using=".//*[@id='nic_create']/span/a")
		private WebElement nav_NICsAddNIC;
		
		@FindBy(how=How.ID,using="connected-1")
		private WebElement nav_NICStatusSlider;
		
		//Guset OS Customization
		
		@FindBy(how=How.XPATH,using="//a[contains(text(),'Guest OS Customization')]")
		private WebElement nav_EditGuestOSCust;
		
		@FindBy(how=How.XPATH,using="//span[contains(text(),'Password Reset')]")
		private WebElement nav_GuestOSCustPwdResetText;
		
		@FindBy(how=How.XPATH,using=".//*[@id='guestname']")
		private WebElement nav_GuestOSHostNameEdit;
		
		@FindBy(how=How.ID,using="guestCustomizationEnabled")
		private WebElement nav_GustCustomizationChkBox;
		
		@FindBy(how=How.ID,using="changeSID")
		private WebElement nav_GuestOSChangeSID;
		
		@FindBy(how=How.ID,using="joinDomain")
		private WebElement nav_GuestJoinDomain;
		
		@FindBy(how=How.ID,using="messagebox-1001-displayfield-inputEl")
		private WebElement nav_GuestOSChangeSIDErrMsg;
		
		@FindBy(how=How.ID,using="messagebox-1001-body")
		private WebElement nav_NICAddDelErrMsg;
		
		
		@FindBy(how=How.ID,using="button-1005-btnIconEl")
		private WebElement nav_GuestOSErrorMsgOKBtn;
		
		@FindBy(how=How.ID,using="adminPasswordEnabled")
		private WebElement nav_GuestAdminPwdChkBox;
		
		@FindBy(how=How.ID,using="messagebox-1001")
		private WebElement nav_EVDCcommonPopUp;
		
		@FindBy(how=How.ID,using="messagebox-1001")
		private WebElement nav_EVDCEditVMPopUp;
		
		@FindBy(how=How.ID,using="pwdGenTrue")
		private WebElement nav_GusetOSAutoGenPwd;
		
		@FindBy(how=How.ID,using="pwdGenFalse")
		private WebElement nav_GuestOSSpecificPwd;
		
		//Add Virtual Machine
		@FindBy(how=How.XPATH,using="//*[contains(text(),'Select VM type')]")
		private WebElement nav_AddVMSelectVMType;
		
		@FindBy(how=How.XPATH,using=".//*[@id='closeWindowButtonDivAdd']/button")
		private WebElement nav_AddVMCloseVM;
		
		@FindBy(how=How.XPATH,using="//*[@id='vmType-inputEl']")
		private WebElement nav_VMSelectType;
		
	//	@FindBy(how=How.XPATH,using=".//*[contains(text(),'Windstream Objects')]")
		//Windstream got changed to Shared object
		@FindBy(how=How.XPATH,using="//a[contains(text(),'Shared Objects')]")
		private WebElement nav_AddVMWindstreamObject;

		@FindBy(how=How.XPATH,using=".//*[contains(text(),'Private Objects')]")
		private WebElement nav_AddVMPrivateObject;
		
		@FindBy(how=How.XPATH,using=".//*[contains(text(),'VM from Template')]")
		private WebElement nav_AddVMfromTemplate;
		
		//@FindBy(how=How.XPATH,using=".//*[contains(text(),'Blank VM')]")
		@FindBy(how=How.XPATH,using="//ul/li[contains(text(),'Blank VM')]")
		private WebElement nav_AddVMBlankVM;
		
		//@FindBy(how=How.XPATH,using=".//*[contains(text(),'VM Name') and (@id='vmNam-labelEl')]")
		//commented the above line and added the below line as part of EXTJS5 change-Vivek - 10082015
		@FindBy(how=How.XPATH,using="//label[@id='vmNam-labelEl']")
		private WebElement nav_VMBlankVMName;
		
		//@FindBy(how=How.XPATH,using=".//*[@id='strgProf-labelEl' and contains(text(),'Storage Profile')]")
		//commented the above line and added the below line as part of EXTJS5 change-Vivek - 10082015
		@FindBy(how=How.XPATH,using="//label[@id='strgProf-labelEl']")
		private WebElement nav_VMBlankStorageProfile;
		
		@FindBy(how=How.XPATH,using="//*[@id='vmNam-inputEl']")
		private WebElement nav_VMBlankVMNameEdit;
		
		@FindBy(how=How.XPATH,using="//*[@id='strgProf-inputEl']")
		private WebElement nav_VMBlankVMDropDown;
		
		@FindBy(how=How.XPATH,using="//li[contains(text(),'Non-Replicated-EMC-SAN')]")
		private WebElement nav_VMBlankVMEMCSAN;
		
		@FindBy(how=How.XPATH,using="//li[contains(text(),'Any')]")
		private WebElement nav_VMBlankVMAny;
		
		@FindBy(how=How.XPATH,using="//section[4]/div[2]/span[1]/a[contains(text(),'OK')]")
		private WebElement nav_VMBlankVMOKBtn;
		
		//This Element updated on 10/13/2015 for EXTJS5 by QAA03
		//@FindBy(how=How.XPATH,using="//a[1]/span/span/span[contains(text(),'OK')]")
		@FindBy(how=How.XPATH,using="//div[@id='navpopupbuttons']/span/a[contains(text(),'Ok')]")
		private WebElement nav_VMBlankconfirmOKBtn;
		
		@FindBy(how=How.XPATH,using=".//*[@id='cancelVMAdd']")
		private WebElement nav_VMBlankCancelBtn;
		
		@FindBy(how=How.XPATH,using="//*[@id='closeWindowButtonDivAddBlank']/button")
		private WebElement nav_VMBlankVMCloseWindow;
		
		@FindBy(how=How.XPATH,using="//form//div[2]//tr[1]/td[1]/div")
		private WebElement nav_ClickingVMfromTemplate;
		
		@FindBy(how=How.XPATH,using="//li[@role='alert' and text()='Only 32 characters are allowed on the VM name']")
		private WebElement nav_VMNameValidation;
		
		@FindBy(how=How.XPATH,using="//*[@id='vmTicketTitle']//input[@id='vmTicketTitle-inputEl']")
		private WebElement nav_VMcreateTicketTitleEdit;
		
		//updated on 11/19/2015 for EXTJS5 by QAA03
		//@FindBy(how=How.XPATH,using="//div[contains(@id,'htmleditor-')]//iframe")
		//@FindBy(how=How.ID,using="vmTicketDescription-inputCmp-iframeEl")
		@FindBy(how=How.XPATH,using="//*[@id='vmTicketDescription-inputCmp-iframeEl']")
		private WebElement nav_VMcreateTicketNoteEdit;
		
		
		@FindBy(how=How.ID,using="vmEditSummaryTbl")
		private WebElement nav_VMEditChangePopUpTable;
		
		@FindBy(how=How.XPATH,using="//div[@id='messagebox-1001-msg']/strong[1]")
		private WebElement nav_VMcreateTicketID;
		
		@FindBy(how=How.XPATH,using=".//*[@id='boundlist-1033-listEl']/ul/li[1]")
		 private WebElement nav_AddVMUserPermission;
		
		
		//EVDC Selector
		@FindBy(how=How.XPATH,using="//*[@class='evdc_options']/ul")
		private WebElement nav_EVDCSelectorList;
		
		//EVDC Selector Edit
		@FindBy(how=How.XPATH,using="//*[@class='evdc_options']/a")
		private WebElement nav_EVDCSelectorEdit;
		
		//EVDC Selector dropdown arrow
		@FindBy(how=How.XPATH,using="//img[contains(@src,'DownArrow')]")
		private WebElement nav_EVDCSelectorDrpdwnArrow;
		
		//@FindBy(how=How.XPATH,using=".//*[@id='gridview-1010-body']")
		//commented the above line and added the below line as part of EXTJS5 change-Vivek - 10082015
		@FindBy(how=How.XPATH,using="//div[@id='vmListExtGridPanel-body']//div[@class='x-grid-item-container']")
		private WebElement nav_VMWebTable;
		
		
		
		@FindBy(how=How.ID,using="button-1005-btnIconEl")
		private WebElement nav_ConfirmDelete;
		
		@FindBy(how=How.ID,using="editDisksPanel-body")
		private WebElement nav_VMComputeStorageWebTableParent;
		
		@FindBy(how=How.ID,using="//section[@id='virtual_machine']/div/h2/a")
		private WebElement nav_EVDCVMLink;
		

	//#############LefCourt############
	//#################################
		@FindBy(how=How.XPATH, using="//*[@id='Storage']//h2/a")
		private WebElement nav_EVDCStorageLink;
		
		@FindBy(how=How.LINK_TEXT,using="Add Storage Tier")
		private WebElement nav_AddStorageTierLink;
		
		@FindBy(how=How.ID,using="createTicketTitle-inputEl")
		private WebElement nav_TitleAddStorageTierPopUp;
		
		@FindBy(how=How.XPATH,using=".//*[@id='combobox-1009-inputEl']")
		private WebElement nav_StorageTierPopupDropdown;
		
		@FindBy(how=How.XPATH,using="//*[Contains(@id,'inputCmp-iframeEl')]")
		private WebElement nav_AddStorageTierNotePopup;
		
		@FindBy(how=How.XPATH, using="//span[text()='OK']")
		private WebElement nav_AddStorageTierOkBtn;
		
	//#####################################################################################
	//#####################################################################################
	
		
		
		
		
		public WebElement getNav_AddStorageTierOkBtn() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_AddStorageTierOkBtn;
		}
		
		public WebElement getNav_StorageDetailsLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_StorageDetailsLink;
		}

		public WebElement getNav_StorageDetailsWebTableParent() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_StorageDetailsWebTableParent;
		}

		public WebElement getNav_AddStorageTierNotePopup() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_AddStorageTierNotePopup;
		}
		
		public WebElement getNav_StorageTierPopupDropdown() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_StorageTierPopupDropdown;
		}
		
		public WebElement getNav_TitleAddStorageTierPopUp() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_TitleAddStorageTierPopUp;
		}
		
		public WebElement getNav_AddStorageTierLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_AddStorageTierLink;
		}
		
		public WebElement getNav_EVDCStorageLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EVDCStorageLink;
		}
	
		public WebElement getNav_EVDCVMLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EVDCVMLink;
		}
		
	public WebElement getNav_AddVMLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddVMLink;
	}

	public WebElement getNav_VMWebTableParent() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_VMWebTableParent;
	}

	public WebElement getNav_PDFImg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PDFImg;
	}

	public WebElement getNav_PDFLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PDFLink;
	}

	public WebElement getNav_CSVImg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CSVImg;
	}

	public WebElement getNav_CSVLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CSVLink;
	}

	public WebElement getNav_HomeBreadCrumb() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_HomeBreadCrumb;
	}

	public WebElement getNav_EVDCBreadCrumb() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCBreadCrumb;
	}

	public WebElement getNav_VMBreadCrumb() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_VMBreadCrumb;
	}

	public WebElement getNav_VMTabList() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_VMTabList;
	}

	public WebElement getNav_StopPopUpMsg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_StopPopUpMsg;
	}

	public WebElement getNav_NetworkNICIDTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NetworkNICIDTab;
	}

	public WebElement getNav_NetworkNICIPTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NetworkNICIPTab;
	}

	public WebElement getNav_NetworkStatusTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NetworkStatusTab;
	}

	public WebElement getNav_NetworkMACAddressTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NetworkMACAddressTab;
	}

	public WebElement getNav_NetworkTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NetworkTab;
	}

	public WebElement getNav_NetworkPrimaryTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NetworkPrimaryTab;
	}

	public WebElement getNav_StorageDiskName() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_StorageDiskName;
	}

	public WebElement getNav_StorageName() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_StorageName;
	}

	public WebElement getNav_StorageSCSI() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_StorageSCSI;
	}

	public WebElement getNav_UserfeedBack() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_UserfeedBack;
	}

	public WebElement getNav_UserfeedBackImage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_UserfeedBackImage;
	}

	public WebElement getNav_StartPopUpMsg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_StartPopUpMsg;
	}

	public WebElement getNav_PlzWaitPopUpMsg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PlzWaitPopUpMsg;
	}

	public WebElement getNav_ResetPopUpMsg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ResetPopUpMsg;
	}

	public WebElement getNav_SuspendPopUpMsg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SuspendPopUpMsg;
	}

	public WebElement getNav_RefreshPopUpMsg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_RefreshPopUpMsg;
	}

	public WebElement getNav_ConsoleWindow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ConsoleWindow;
	}

	public WebElement getNav_ConsoleClose() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ConsoleClose;
	}

	public WebElement getNav_ConsoleCtrlAltDelBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ConsoleCtrlAltDelBtn;
	}

	public WebElement getNav_EditGeneralTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditGeneralTab;
	}

	public WebElement getNav_EditGeneralVMName() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditGeneralVMName;
	}

	public WebElement getNav_EditGeneralOperatingSystemFamily() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditGeneralOperatingSystemFamily;
	}

	public WebElement getNav_EditOSFamilyToolTipMsg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditOSFamilyToolTipMsg;
	}

	public WebElement getNav_EditGeneralOS() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditGeneralOS;
	}

	public WebElement getNav_EditOSToolTipMsg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditOSToolTipMsg;
	}

	public WebElement getNav_EditGeneralDescription() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditGeneralDescription;
	}

	public WebElement getNav_EditGeneralStorageprofile() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditGeneralStorageprofile;
	}

	public WebElement getNav_EditStorageProfileToolTipMsg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditStorageProfileToolTipMsg;
	}

	public WebElement getNav_EditGeneralCloseBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditGeneralCloseBtn;
	}

	public WebElement getNav_EditVMNameRequired() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditVMNameRequired;
	}

	public WebElement getNav_EditVMNameInput() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditVMNameInput;
	}

	public WebElement getNav_EditDescriptionInput() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditDescriptionInput;
	}

	public WebElement getNav_EditGeneralVMNameErrMsg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditGeneralVMNameErrMsg;
	}

	public WebElement getNav_EditVMNameToolTipMsg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditVMNameToolTipMsg;
	}

	public WebElement getNav_EditVMCancelBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditVMCancelBtn;
	}

	public WebElement getNav_EditVMSaveBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditVMSaveBtn;
	}

	public WebElement getNav_EditVMCommit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditVMCommit;
	}

	public WebElement getNav_EditVMGoBack() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditVMGoBack;
	}

	public WebElement getNav_EditComputeStorage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditComputeStorage;
	}

	public WebElement getNav_ComputeStorageAddDisk() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ComputeStorageAddDisk;
	}

	public WebElement getNav_ComputeStoragevCPUTooltipMsg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ComputeStoragevCPUTooltipMsg;
	}

	public WebElement getNav_ComputeStoragevCPUEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ComputeStoragevCPUEdit;
	}

	public WebElement getNav_ComputeStoragevCPUEdtParent() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ComputeStoragevCPUEdtParent;
	}

	public WebElement getNav_ComputeStoragevRAMEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ComputeStoragevRAMEdit;
	}

	public WebElement getNav_ComputeStoragevRAMEdtParent() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ComputeStoragevRAMEdtParent;
	}

	public WebElement getNav_ComputeStorageRAMUnit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ComputeStorageRAMUnit;
	}

	public WebElement getNav_ComputeStorageRAMUnitDropDown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ComputeStorageRAMUnitDropDown;
	}

	public WebElement getNav_ComputeStorageErrMsg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ComputeStorageErrMsg;
	}

	public WebElement getNav_ComputeStorageNumOfvCPUs() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ComputeStorageNumOfvCPUs;
	}

	public WebElement getNav_ComputeStorageTotalvRAM() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ComputeStorageTotalvRAM;
	}

	public WebElement getNav_ComputeStoragevCPUHotAdd() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ComputeStoragevCPUHotAdd;
	}

	public WebElement getNav_ComputeStoragevRAMHotAdd() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ComputeStoragevRAMHotAdd;
	}

	public WebElement getNav_ComputeStorageDisk() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ComputeStorageDisk;
	}

	public WebElement getNav_ComputeStorageHardware() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ComputeStorageHardware;
	}

	public WebElement getNav_EditNICs() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditNICs;
	}

	public WebElement getNav_NICsNICID() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NICsNICID;
	}

	public WebElement getNav_NICsPrimaryNIC() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NICsPrimaryNIC;
	}

	public WebElement getNav_NICsNetwork() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NICsNetwork;
	}

	public WebElement getNav_NICsIPMode() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NICsIPMode;
	}

	public WebElement getNav_NICIPMode() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NICIPMode;
	}

	public WebElement getNav_NICIPModelist() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NICIPModelist;
	}

	public WebElement getNav_NICIPAddress() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NICIPAddress;
	}

	public WebElement getNav_NICsIPAddress() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NICsIPAddress;
	}

	public WebElement getNav_NICsStatus() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NICsStatus;
	}

	public WebElement getNav_NICWebTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NICWebTable;
	}

	public WebElement getNav_NICsAddNIC() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NICsAddNIC;
	}

	public WebElement getNav_NICStatusSlider() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NICStatusSlider;
	}

	public WebElement getNav_EditGuestOSCust() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditGuestOSCust;
	}

	public WebElement getNav_GuestOSCustPwdResetText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_GuestOSCustPwdResetText;
	}

	public WebElement getNav_GuestOSHostNameEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_GuestOSHostNameEdit;
	}

	public WebElement getNav_GustCustomizationChkBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_GustCustomizationChkBox;
	}

	public WebElement getNav_GuestOSChangeSID() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_GuestOSChangeSID;
	}

	public WebElement getNav_GuestJoinDomain() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_GuestJoinDomain;
	}

	public WebElement getNav_GuestOSChangeSIDErrMsg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_GuestOSChangeSIDErrMsg;
	}

	public WebElement getNav_NICAddDelErrMsg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NICAddDelErrMsg;
	}

	public WebElement getNav_GuestOSErrorMsgOKBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_GuestOSErrorMsgOKBtn;
	}

	public WebElement getNav_GuestAdminPwdChkBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_GuestAdminPwdChkBox;
	}

	public WebElement getNav_EVDCcommonPopUp() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCcommonPopUp;
	}

	public WebElement getNav_EVDCEditVMPopUp() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCEditVMPopUp;
	}

	public WebElement getNav_GusetOSAutoGenPwd() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_GusetOSAutoGenPwd;
	}

	public WebElement getNav_GuestOSSpecificPwd() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_GuestOSSpecificPwd;
	}

	public WebElement getNav_AddVMSelectVMType() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddVMSelectVMType;
	}

	public WebElement getNav_AddVMCloseVM() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddVMCloseVM;
	}

	public WebElement getNav_VMSelectType() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_VMSelectType;
	}

	public WebElement getNav_AddVMWindstreamObject() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddVMWindstreamObject;
	}

	public WebElement getNav_AddVMPrivateObject() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddVMPrivateObject;
	}

	public WebElement getNav_AddVMfromTemplate() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddVMfromTemplate;
	}

	public WebElement getNav_AddVMBlankVM() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddVMBlankVM;
	}

	public WebElement getNav_VMBlankVMName() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_VMBlankVMName;
	}

	public WebElement getNav_VMBlankStorageProfile() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_VMBlankStorageProfile;
	}

	public WebElement getNav_VMBlankVMNameEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_VMBlankVMNameEdit;
	}

	public WebElement getNav_VMBlankVMDropDown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_VMBlankVMDropDown;
	}

	public WebElement getNav_VMBlankVMEMCSAN() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_VMBlankVMEMCSAN;
	}

	public WebElement getNav_VMBlankVMAny() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_VMBlankVMAny;
	}

	public WebElement getNav_VMBlankVMOKBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_VMBlankVMOKBtn;
	}

	public WebElement getNav_VMBlankconfirmOKBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_VMBlankconfirmOKBtn;
	}

	public WebElement getNav_VMBlankCancelBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_VMBlankCancelBtn;
	}

	public WebElement getNav_VMBlankVMCloseWindow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_VMBlankVMCloseWindow;
	}

	public WebElement getNav_ClickingVMfromTemplate() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ClickingVMfromTemplate;
	}

	public WebElement getNav_VMNameValidation() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_VMNameValidation;
	}

	public WebElement getNav_VMcreateTicketTitleEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_VMcreateTicketTitleEdit;
	}

	public WebElement getNav_VMcreateTicketNoteEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_VMcreateTicketNoteEdit;
	}

	public WebElement getNav_AddVMUserPermission() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddVMUserPermission;
	}

	public WebElement getNav_EVDCSelectorList() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCSelectorList;
	}

	public WebElement getNav_EVDCSelectorEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCSelectorEdit;
	}

	public WebElement getNav_EVDCSelectorDrpdwnArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCSelectorDrpdwnArrow;
	}

	public WebElement getNav_VMWebTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_VMWebTable;
	}

	public WebElement getNav_ConfirmDelete() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ConfirmDelete;
	}

	public WebElement getNav_VMComputeStorageWebTableParent() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_VMComputeStorageWebTableParent;
	}

	public WebElement getNav_NewEVDCPopUpMessage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NewEVDCPopUpMessage;
	}

	public WebElement getNav_NewEVDCPopUpBody() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NewEVDCPopUpBody;
	}

	public WebElement getNav_NewEVDCPopUpOKBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NewEVDCPopUpOKBtn;
	}

	public WebElement getNav_NewEVDCPopUpCancelBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NewEVDCPopUpCancelBtn;
	}

	public WebElement getNav_PopUpOKBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PopUpOKBtn;
	}

	public WebElement getNav_EVDCMarketingImage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCMarketingImage;
	}

	public WebElement getNav_VMcreateTicketID() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_VMcreateTicketID;
	}

	public WebElement getNav_VMEditChangePopUpTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_VMEditChangePopUpTable;
	}	
	
	
	
}
