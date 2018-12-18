package com.whs.navigator.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class DraasPageFactory {
	
	@FindBy(how=How.ID, using = "draasLink")
    private WebElement nav_DraasLink;
	
	@FindBy(how=How.XPATH, using = "//div[@id='draas_print']//img[@alt='PDF']")
	private WebElement nav_PDFLink;
	
	@FindBy(how=How.XPATH, using = "//div[@id='draas_print']//img[@alt='CSV']")
	private WebElement nav_CSVLink;
	
	//Learn More link
	@FindBy(how=How.LINK_TEXT,using="Learn More")
	private WebElement nav_DRaasLearnMoreLnk;
	
	//DRaaS Products
	@FindBy(how=How.XPATH,using="//li[2]/span/a[text()='DRaaS Products']")
	private WebElement nav_DRaaSProdtPage;

	@FindBy(how=How.ID, using = "idMainContainer-innerCt")
	private WebElement nav_productsDivisionunderDRaasPage;
	
	@FindBy(how=How.ID, using = "draas")
	private WebElement nav_DRaaSPortlet;
	
	@FindBy(how=How.XPATH, using = "//section[@id='draas']//div[@class='bx-pager bx-default-pager']")
	private WebElement nav_DotsInDRaaSPortlet;
	
	@FindBy(how=How.ID, using="idMoreDraasPdtsPanel_header-innerCt")
	private WebElement nav_MoreDraasProducts;

	@FindBy(how=How.ID,using="idBtnS2CRAddDrive-btnInnerEl")
	private WebElement nav_SCRAddDrive;
	
	@FindBy(how=How.ID,using="idBtnS2CRManage-btnInnerEl")
	private WebElement nav_SCRManageBtn;
	
	@FindBy(how=How.XPATH,using="//div[@id='idHBRMWindow-body']//div[@class='x-grid-item-container']")
	private WebElement nav_SCRManageDriveTable;
	
	@FindBy(how=How.ID,using="idBtnS2CRHistory-btnInnerEl")
	private WebElement nav_SCRHistoryBtn;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'Remove Drive from Server to Cloud Recovery')]")
	private WebElement nav_SCRDeleteDriveMsg;	
	
	//DraaS Section
	@FindBy(how=How.LINK_TEXT,using="DRaaS")
	//@FindBy(how=How.ID, using="draasLink")
	private WebElement nav_DraaSSection;
	
	@FindBy(how=How.XPATH,using="//img[contains(@src,'SBR')]")
	private WebElement nav_SBRImage; 
	
	//This object is updated by QAA04 - 10/02/2015
	@FindBy(how=How.XPATH, using="//div[@id='idsbrPanel_header-innerCt']//div[contains(@id,'-textEl')]")
	//@FindBy(how=How.ID,using="idsbrPanel_header_hd-textEl")
	private WebElement nav_SBRProduct;
	
	@FindBy(how=How.XPATH, using="//div[contains(text(),'Storage Based Replication')]")
	private WebElement nav_SBRText;
	
	//AddDrive dialog
	@FindBy(how=How.ID,using="idfpHBRAdd-innerCt")
	private WebElement nav_AddDriveDialog;
	
	//manage dialog
	@FindBy(how=How.ID,using="idHBRMWindow")
	private WebElement nav_ManageBtnDialog;
	
	//closing Manage dialog and history dialog\
	@FindBy(how=How.ID,using="idCloseButton")
	private WebElement nav_ManageHistoryDialogClose;
	
    ////This object is updated on 10/01/2015 by QAA04
	//closing add drive dialog
	@FindBy(how=How.XPATH, using="//div[@id='idfpWindowAdd_header-targetEl']//img[contains(@id,'-toolEl')]")
	//@FindBy(how=How.ID,using="tool-1030-toolEl")
	private WebElement nav_SCRAddDriveWindowClose;
	
	//History dialog 
	@FindBy(how=How.ID,using="idHBRHWindow")
	private WebElement nav_HistoryBtnDialog;
	
	//This object is updated by QAA04 - 10/02/2015
	@FindBy(how=How.XPATH, using="//div[@id='ids2crPanel_header-targetEl']//div[contains(@id,'-textEl')]")
	//@FindBy(how=How.ID,using="ids2crPanel_header_hd-textEl")
	private WebElement nav_SCRLink;
	
	@FindBy(how=How.ID,using="idBtnSBRAddDrive-btnInnerEl")
	private WebElement nav_SBRAddDrive;
	
	@FindBy(how=How.ID,using="idfpWindowAdd")
	private WebElement nav_SBRAddDriveWindow;
	
	// This object is updated on 10/02/2015 by QAA04
	@FindBy(how=How.XPATH, using="//div[@id='idfpWindowAdd_header-targetEl']//img[contains(@id,'-toolEl')]")
	//@FindBy(how=How.ID,using="tool-1035-toolEl")
	private WebElement nav_SBRADDDriveWindowClose;
	
	@FindBy(how=How.XPATH, using = "//div[@id='draas_print']//img[@alt='PDF']")
	private WebElement nav_PDFLinkUnderDraas;
	
	@FindBy(how=How.XPATH, using = "//div[@id='draas_print']//img[@alt='CSV']")
	private WebElement nav_CSVLinkUnderDraas;
	
	//DRaas breadcrumb
	@FindBy(how=How.XPATH,using="//li[2]/span/a[text()='DRaaS']")
	private WebElement nav_DRaaSBreadCrumb;
	
	//More DRaaS product Expander
	@FindBy(how=How.XPATH,using="//span[@id='idMoreDraasPdtsPanel_header_hd-textEl']/img")
	private WebElement nav_MoreDRaaSPdtExpander;
		
	//S2CR expander
	@FindBy(how=How.XPATH,using="//span[@id='ids2crPanel_header_hd-textEl']/img")
	private WebElement nav_S2CRExpander;
		
	//SBR expander
	@FindBy(how=How.XPATH,using="//span[@id='idsbrPanel_header_hd-textEl']/img")
	private WebElement nav_SBRExpander;
		
	//C2CR expander
	@FindBy(how=How.XPATH,using="//span[@id='idc2crPanel_header_hd-textEl']/img")
	private WebElement nav_C2CRExpander;
		
		
	//SRM Expander
	@FindBy(how=How.XPATH,using="//span[@id='idsrmPanel_header_hd-textEl']/img")
	private WebElement nav_SRMExpander;
		
	@FindBy(how=How.XPATH,using="//tbody[contains(@id,'gridview-')]/tr[1]//a[text()='Delete']/../../../..")
	private WebElement nav_ManageBtnDialogTable;
		
	@FindBy(how=How.ID,using="idfpWindowDelete")
	private WebElement nav_DeleteWindowConfirmationDialog;
	
	@FindBy(how=How.ID,using="button-1039-btnIconEl")
	private WebElement nav_DeleteWindowDialogOKBtn;
	
	@FindBy(how=How.ID,using="messagebox-1001")
	private WebElement nav_PopUp;
	
	@FindBy(how=How.ID,using="userfeedback")
	private WebElement nav_FeedBack;
	
	//Storage based replication product table
	@FindBy(how=How.XPATH,using="//div[@id='idSBRGridPanel-body']/div/table[contains(@id,'gridview-')]/tbody[contains(@id,'gridview-')]")
	private WebElement nav_StorageBsedRepPrdtTable;	
	
	@FindBy(how=How.ID,using="idBtnSBRManage-btnInnerEl")
	private WebElement nav_SBRManageBtn;
	
	@FindBy(how=How.ID,using="idBtnSBRHistory-btnInnerEl")
	private WebElement nav_SBRHistoryBtn;
	
	//Images
	@FindBy(how=How.XPATH,using="//div[@id='idDraasPdtPanel']")
	private WebElement nav_Image;
	
	@FindBy(how=How.ID, using="draas_print")
	private WebElement nav_ClarkDraasPdficon;
	
	//Draas Link on Home Page
	@FindBy(how=How.XPATH, using="//a[@id='draasLink']")
	private WebElement nav_MultiOrgDraasLinkHome;
	
	//ADD DRIVE
	// This objects is updated on 10/02/2015 By QAA04
	@FindBy(how=How.XPATH, using="//div[@id='idfpHBRAdd-innerCt']/div[1]//input[contains(@id,'-inputEl')]")
	//@FindBy(how=How.XPATH,using="//table[1]/tbody/tr/td[2]/input")
	private WebElement nav_AddDriveHostName;
		
	//This object is updated on 10/02/2015 By QAA04
	@FindBy(how=How.XPATH, using="//div[@id='idfpHBRAdd-innerCt']/div[2]//input[contains(@id,'-inputEl')]")
	//@FindBy(how=How.XPATH,using="//table[2]/tbody/tr/td[2]/input")
	private WebElement nav_AddDriveHostIP;
		
	//This object is updated on 10/02/2015 By QAA04
	@FindBy(how=How.XPATH, using="//div[@id='idfpHBRAdd-innerCt']/div[3]//input[contains(@id,'-inputEl')]")
	//@FindBy(how=How.XPATH,using="//table[3]/tbody/tr/td[2]/input")
	private WebElement nav_AddDriveToAdd;
		
	//This object is updated on 10/02/2015 By QAA04
	@FindBy(how=How.XPATH, using="//div[@id='idfpHBRAdd-innerCt']/div[4]//input[contains(@id,'-inputEl')]")
	//@FindBy(how=How.XPATH,using="//input[contains(@id,'checkbox')]")
	private WebElement nav_AddDriveNewHostChkBox;
		
	//This object is updated on 10/02/2015 By QAA04
	@FindBy(how=How.XPATH, using="//div[@id='idfpHBRAdd-innerCt']/div[5]//input[contains(@id,'-inputEl')]")
	//@FindBy(how=How.XPATH,using="//table[5]/tbody/tr/td[2]/input")
	private WebElement nav_AddDriveHostOS;
		
	//This object is updated on 10/02/2015 By QAA04
	@FindBy(how=How.XPATH, using="//div[@id='idfpHBRAdd-innerCt']/div[6]//input[contains(@id,'-inputEl')]")
	//@FindBy(how=How.XPATH,using="//table[6]/tbody/tr/td[2]/input")
	private WebElement nav_AddDriveVersion;
		
	//This object is updated on 10/02/2015 By QAA04
	@FindBy(how=How.ID, using="radio1-inputEl")
	//@FindBy(how=How.ID,using="radio1-inputEl")
	private WebElement nav_AddDriveVMServerRadioBtn;
		
	//This object is updated on 10/02/2015 By QAA04
	@FindBy(how=How.XPATH, using="//div[@id='idfpHBRAdd-innerCt']/div[8]//input[contains(@id,'-inputEl')]")
	//@FindBy(how=How.XPATH,using="//table[8]/tbody/tr/td[2]/input")
	private WebElement nav_AddDriveRecoveryDest;
		
	@FindBy(how=How.XPATH, using="//span[text()='Save']")
	//@FindBy(how=How.ID,using="button-1035-btnInnerEl")
	private WebElement nav_AddDriveSaveBtn;
		
	@FindBy(how=How.XPATH, using = " //div[@class='header_wrapper'] //li[@class='first']//a[text()='Home']")
	private WebElement nav_breadCrumbChainHomeLink;
	
	///______________________ QAA04 ________________________ ///
	
	@FindBy(how=How.XPATH, using = "//div[@class='header_wrapper'] //li[@class='first']//a[text()='Home']/../../..//li[@class='last']")
	private WebElement nav_breadCrumbChain;
	
	@FindBy(how=How.XPATH,using="//table[@class='marketing_table']//table[contains(@class,'marketing_table_2')]//span[text()='DRaaS Features']")
	private WebElement nav_TitleInLearnMoreLink;
	
	// this object is updated by QAA04 -- 11/20/2015
	@FindBy(how=How.XPATH, using="//*[@id='idsbrPanel_header-targetEl']//div[contains(@id,'title-')][contains(@id,'-textEl')]")
	//@FindBy(how=How.ID, using = "idsbrPanel_header_hd-textEl")
	private WebElement nav_StorageBasedReplicationProductTitle;
	
	/// This object is updated by QAA04 -- 11/20/2015
	@FindBy(how=How.XPATH, using ="//div[@id='idfpSBRAdd']//span[text()='Cancel']")
	//@FindBy(how=How.XPATH, using = "//div[@id='idfpSBRAdd']//span[@class='x-btn-wrap']//span[text()='Cancel']")
	private WebElement nav_CancelBtnAddDriverLinkUnderSBR;
	
	@FindBy(how=How.ID, using = "idBtnSBRAddDrive-btnInnerEl")
    private WebElement nav_AddDriveLinkUnderSBR;
	
	////_________________________QAA04 ___________________/////
	
    ////_________________________QAA03___________________/////
	
	@FindBy(how=How.XPATH, using ="//img[@src='/draas-portlet/resources/images/SBR.jpg']")
    private WebElement nav_DraasSBRImage;
	
	@FindBy(how=How.XPATH, using ="//img[@src='/draas-portlet/resources/images/C2CR.jpg']")
    private WebElement nav_DraasC2CRImage;
	
	@FindBy(how=How.XPATH, using ="//img[@src='/draas-portlet/resources/images/S2CR.jpg']")
    private WebElement nav_DraasS2CRImage;
	
	///////***********************Keffer TestCase Elements ***********************************///////
	
	@FindBy(how=How.XPATH, using ="//div[@id='c2crContentsDiv']/div[@class='draas_header_text']")
    private WebElement nav_DraasC2CRProductText;
	
	@FindBy(how=How.LINK_TEXT,using="HERE")
	private WebElement nav_DRaasClickHereLink;
	
	@FindBy(how=How.XPATH, using ="//div[contains(@class,'CreateTicketPopup')]")
    private WebElement nav_DraasC2CRProductPopUpBox;
	
	@FindBy(how=How.LINK_TEXT,using="Raleigh-NC")
	private WebElement nav_DRaasC2CRProdRallink;
	
	@FindBy(how=How.LINK_TEXT,using="Chicago-IL")
	private WebElement nav_DRaasC2CRProdChilink;
	
	//###LEFCOURT###
	@FindBy(how=How.LINK_TEXT,using="Delete")
	private WebElement nav_SCRDeleteLink;
	
	@FindBy(how=How.ID,using="button-1046-btnEl")
	private WebElement nav_SCRDeletePopupOkBtn;
	
	@FindBy(how=How.ID,using="tool-1064-toolEl")
	private WebElement nav_SCRDeletePopupCloseBtn;
	
	@FindBy(how=How.LINK_TEXT, using="DRaaS")
    private WebElement nav_ServicesDraasMenuLink;
	
	public WebElement getNav_ServicesDraasMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ServicesDraasMenuLink;
	}
	
	public WebElement getNav_SCRDeletePopupCloseBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SCRDeletePopupCloseBtn;
	}
	
	public WebElement getNav_SCRDeletePopupOkBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SCRDeletePopupOkBtn;
	}
	
	public WebElement getNav_SCRDeleteLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SCRDeleteLink;
	}
	
	public WebElement getNav_DraasLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DraasLink;
	}
	
	public WebElement getNav_TitleInLearnMoreLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TitleInLearnMoreLink;
	}

	public WebElement getNav_breadCrumbChain() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_breadCrumbChain;
	}

	public WebElement getNav_PDFLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PDFLink;
	}
	
	public WebElement getNav_CSVLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CSVLink;
	}
	
	public WebElement getNav_DRaasLearnMoreLnk() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DRaasLearnMoreLnk;
	}
	
	public WebElement getNav_DRaaSProdtPage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DRaaSProdtPage;
	}
	
	public WebElement getNav_productsDivisionunderDRaasPage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_productsDivisionunderDRaasPage;
	}
	
	public WebElement getNav_DRaaSPortlet() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DRaaSPortlet;
	}
	
	public WebElement getNav_DotsInDRaaSPortlet() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DotsInDRaaSPortlet;
	}
	
	public WebElement getNav_SCRAddDrive() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SCRAddDrive;
	}
	
	public WebElement getNav_SCRManageBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SCRManageBtn;
	}
	
	public WebElement getNav_SCRHistoryBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SCRHistoryBtn;
	}
	
	public WebElement getNav_DraaSSection() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DraaSSection;
	}
	public WebElement getNav_SBRImage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SBRImage;
	}
	
	public WebElement getNav_SBRProduct() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SBRProduct;
	}
	public WebElement getNav_AddDriveDialog() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddDriveDialog;
	}
	
	public WebElement getNav_ManageBtnDialog() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageBtnDialog;
	}
	
	public WebElement getNav_ManageHistoryDialogClose() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageHistoryDialogClose;
	}
	
	public WebElement getNav_SCRAddDriveWindowClose() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SCRAddDriveWindowClose;
	}
    
	public WebElement getNav_HistoryBtnDialog() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_HistoryBtnDialog;
	}

	public WebElement getNav_SCRLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SCRLink;
	}
	
	public WebElement getNav_SBRAddDrive() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SBRAddDrive;
	}
	
	public WebElement getNav_SBRAddDriveWindow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SBRAddDriveWindow;
	}
	
	public WebElement getNav_SBRADDDriveWindowClose() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SBRADDDriveWindowClose;
	}
	
	public WebElement getNav_PDFLinkUnderDraas() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PDFLinkUnderDraas;
	}
	
	public WebElement getNav_CSVLinkUnderDraas() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CSVLinkUnderDraas;
	}
	
	public WebElement getNav_DRaaSBreadCrumb() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DRaaSBreadCrumb;
	}
	
	public WebElement getNav_MoreDRaaSPdtExpander() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_MoreDRaaSPdtExpander;
	}

	public WebElement getNav_S2CRExpander() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_S2CRExpander;
	}

	public WebElement getNav_SBRExpander() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SBRExpander;
	}

	public WebElement getNav_SRMExpander() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SRMExpander;
	}

	public WebElement getNav_C2CRExpander() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_C2CRExpander;
	}
	
	public WebElement getNav_ManageBtnDialogTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ManageBtnDialogTable;
	}
	
	public WebElement getNav_DeleteWindowConfirmationDialog() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DeleteWindowConfirmationDialog;
	}

	public WebElement getNav_DeleteWindowDialogOKBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DeleteWindowDialogOKBtn;
	}

	public WebElement getNav_PopUp() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PopUp;
	}

		
	public WebElement getNav_FeedBack() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FeedBack;
	}
	
	public WebElement getNav_StorageBsedRepPrdtTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_StorageBsedRepPrdtTable;
	}
	
	public WebElement getNav_SBRManageBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SBRManageBtn;
	}

	public WebElement getNav_SBRHistoryBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SBRHistoryBtn;
	}
     
	public WebElement getNav_Image() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Image;
	}
	
	public WebElement getNav_ClarkDraasPdficon(){
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	    return nav_ClarkDraasPdficon;
	}
    
	public WebElement getNav_MultiOrgDraasLinkHome(){
    	 FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
         return nav_MultiOrgDraasLinkHome; 
     }
	
	public WebElement getNav_AddDriveHostName() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddDriveHostName;
	}

	public WebElement getNav_AddDriveHostIP() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddDriveHostIP;
	}

	public WebElement getNav_AddDriveToAdd() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddDriveToAdd;
	}

	public WebElement getNav_AddDriveNewHostChkBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddDriveNewHostChkBox;
	}

	public WebElement getNav_AddDriveHostOS() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddDriveHostOS;
	}

	public WebElement getNav_AddDriveVersion() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddDriveVersion;
	}

	public WebElement getNav_AddDriveVMServerRadioBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddDriveVMServerRadioBtn;
	}

	public WebElement getNav_AddDriveRecoveryDest() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddDriveRecoveryDest;
	}

	public WebElement getNav_AddDriveSaveBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddDriveSaveBtn;
	}
    
	public WebElement getNav_breadCrumbChainHomeLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_breadCrumbChainHomeLink;
	}

	public WebElement getNav_StorageBasedReplicationProductTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_StorageBasedReplicationProductTitle;
	}

	public WebElement getNav_CancelBtnAddDriverLinkUnderSBR() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CancelBtnAddDriverLinkUnderSBR;
	}

	public WebElement getNav_AddDriveLinkUnderSBR() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddDriveLinkUnderSBR;
	}

	public WebElement getNav_MoreDraasProducts() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_MoreDraasProducts;
	}

	public WebElement getNav_SCRManageDriveTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SCRManageDriveTable;
	}

	public WebElement getNav_SCRDeleteDriveMsg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SCRDeleteDriveMsg;
	}

	public WebElement getNav_SBRText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SBRText;
	}

	public WebElement getNav_DraasSBRImage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DraasSBRImage;
	}

	public WebElement getNav_DraasC2CRImage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DraasC2CRImage;
	}

	public WebElement getNav_DraasS2CRImage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DraasS2CRImage;
	}

	public WebElement getNav_DraasC2CRProductText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DraasC2CRProductText;
	}

	public WebElement getNav_DRaasClickHereLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DRaasClickHereLink;
	}

	public WebElement getNav_DraasC2CRProductPopUpBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DraasC2CRProductPopUpBox;
	}

	public WebElement getNav_DRaasC2CRProdRallink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DRaasC2CRProdRallink;
	}

	public WebElement getNav_DRaasC2CRProdChilink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DRaasC2CRProdChilink;
	}
	
	
	
}
