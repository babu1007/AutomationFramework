package com.whs.navigator.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class CatalogPageFactory {

	@FindBy(how=How.ID,using="messagebox-1001-msg")
	private WebElement nav_ErrDialogBox;
	
	
	//EVDC Name
	//@FindBy(how=How.XPATH,using="//*[@id='edvc_1']/a")
	@FindBy(how=How.XPATH,using="//div[@id='nav_org_maindev']//h2[@id='edvc_1']/a[@class='navigationMarker']")
	private WebElement nav_EVDCname;
	
	@FindBy(how=How.LINK_TEXT,using="Catalogs")
	private WebElement nav_CatalogPortletLink;
	
	@FindBy(how=How.ID,using="userfeedback")
	private WebElement nav_CatalogUserFeedBack;
	
	//Catalog Page Object
	//@FindBy(how=How.LINK_TEXT,using="Windstream Objects")
	@FindBy(how=How.LINK_TEXT,using="Shared Objects")
	private WebElement nav_CatalogWindStreamLink;
	
	@FindBy(how=How.LINK_TEXT,using="Private Objects")
	private WebElement nav_CatalogPrivateLink;
	
   ////This object updated on 10/01/2015 by QAA04
	@FindBy(how=How.XPATH, using="//span[text()='OK']")
	//@FindBy(how=How.ID,using="button-1005-btnIconEl")
	private WebElement nav_CatalogPopUpOKBtn;
	
	@FindBy(how=How.ID,using="button-1008-btnIconEl")
	private WebElement nav_CatalogPopUpCancelBtn;
	
	@FindBy(how=How.ID,using="messagebox-1001-displayfield-inputEl")
	private WebElement nav_CatalogPopUpMessage;
	
	@FindBy(how=How.ID,using="navpopupmessage")
	private WebElement nav_NewCatalogPopUpMessage;
	
	@FindBy(how=How.ID,using="navpopupbody")
	private WebElement nav_NewCatalogPopUpBody;
	
 
	@FindBy(how=How.XPATH,using="//div[@id='navpopupbuttons']//a[contains(text(),'Ok')]")
	private WebElement nav_NewCatalogPopUpOKBtn;
	
	@FindBy(how=How.XPATH,using="//div[@id='navpopupbuttons']//a[contains(text(),'Cancel')]")
	private WebElement nav_NewCatalogPopUpCancelBtn;
	
	
	//WindStream
	//##############
	// this object added by QAA04 - 02/03/2016
		@FindBy(how=How.ID, using="wsCtlgs-body")
		private WebElement nav_SharedObjectsWebTableParent;
	
	//@FindBy(how=How.XPATH,using="//div[@id='windstreamObjectsPageDiv']//img[@alt='PDF']")
	@FindBy(how=How.XPATH,using="//div[@id='sharedObjectsPageDiv']//img[@alt='PDF']")
	private WebElement nav_CatalogWindStreamPDFImg;
	
	////This object updated on 10/01/2015 by QAA04
	@FindBy(how=How.XPATH,using="//div[@id='wsCtlgs-body']//table[1]//tr[1]//div[@class='x-grid-row-expander']")
	//@FindBy(how=How.XPATH,using="//tr[1]//tr[1]//div/div[@class='x-grid-row-expander']")
	private WebElement nav_CatalogWindStreamFirstExpander;
	
    ////This object updated on 10/01/2015 by QAA04
	@FindBy(how=How.XPATH,using="//table[1]//section[1]//a/img[@alt='copy catalog']")
	//@FindBy(how=How.XPATH,using="//table/tbody/tr[1]/td//a/img[@alt='copy catalog']")
	private WebElement nav_CatalogWindStreamCopyBtn;
	
	@FindBy(how=How.XPATH,using="//input[@role='textbox']")
	//private WebElement nav_CatalogWindStreamCopyNewName;
	//Changing the name as this is common for both Windstream and Private object 
	private WebElement nav_CatalogName;
	
	 ////This object updated on 10/01/2015 by QAA04
	@FindBy(how=How.XPATH, using="//div[@id='winObjCopyDest']//input[contains(@id,'copyWinObj-destCat-inputId-urn')]")
	//@FindBy(how=How.XPATH,using="//td[@class='x-form-trigger-input-cell'][contains(@id,'copyWinObj-destCat-extId-urn')]//input[contains(@id,'copyWinObj-destCat-inputId-urn')]")
	private WebElement nav_CatalogWindStreamCopyDestDropDownArrow;
	
	@FindBy(how=How.XPATH,using="//div[contains(@id,'boundlist-')]/ul[@class='x-list-plain']")
	//private WebElement nav_CatalogWindStreamCopyDestDropDown;
	//Changing the name as this is common for both Windstream and Private object 
	private WebElement nav_CatalogDropDown;
	
	@FindBy(how=How.XPATH,using="//span[@id='copyWinObjBut']/a[contains(text(),'Copy')]")
	private WebElement nav_CatalogWindStreamCopyDialogCopyBtn;
	
	@FindBy(how=How.XPATH,using="//div[@id='winObjCopyPopup']//a[text()='Cancel']")
	private WebElement nav_CatalogWindStreamCopyDialogCancelBtn;
	
	 ////This object is updated on 10/01/2015 by QAA04
	@FindBy(how=How.XPATH, using="//table[1]//a/img[@alt='deploy object from catalog']")
	//@FindBy(how=How.XPATH,using="//table/tbody/tr[1]/td//a/img[@alt='deploy object from catalog']")
	private WebElement nav_CatalogWindStreamDeployBtn;
	
	 ////This object is updated on 10/01/2015 by QAA04
	@FindBy(how=How.XPATH, using="//div[@id='winObjVMName']//input[contains(@id,'deployWinObj-Name-inputId-urn')]")
	//@FindBy(how=How.XPATH,using="//table/tbody/tr/td[2]/input[contains(@id,'deployWinObj-Name-inputId-urn')]")
	private WebElement nav_CatalogWindStreamDeployNameEdit;
	
	 ////This object is updated on 10/01/2015 by QAA04
	@FindBy(how=How.XPATH, using="//div[@id='winObjStrProfile']//input[contains(@id,'deployWinObj-strProf-inputId-urn')]")
	//@FindBy(how=How.XPATH,using="//td[contains(@id,'deployWinObj-strProf-extId-urn')]/input[contains(@id,'deployWinObj-strProf-inputId-urn')]")
	private WebElement nav_CatalogWindStreamDeployStorageProfileDropDownArrow;
	
	 ////This object is updated on 10/01/2015 by QAA04
	@FindBy(how=How.XPATH,using="//div/ul[@class='x-list-plain']")
	//private WebElement nav_CatalogWindStreamDeployStorageProfileDropDown;
	//Changing the name as this is common for both Windstream and Private object 
	private WebElement nav_CatalogDeployDropDown;
	
	@FindBy(how=How.XPATH,using="//span[@id='deployWinObjBut']/a[contains(text(),'Deploy')]")
	private WebElement nav_CatalogWindStreamDeployDialogDeployBtn;
	
	
	
	
	
	//Private Object
	//################
	@FindBy(how=How.XPATH,using="//div[@id='pvtObjContainer']//div[@class='tabPrint']//img[@alt='PDF']")
	private WebElement nav_CatalogPrivatePDFImg;
	
	 ////This object is updated on 10/01/2015 by QAA04
	@FindBy(how=How.ID,using="pvtObjGrid-innerCt")
	//@FindBy(how=How.XPATH,using="//div[@id='pvtObjGrid-innerCt']/div/table[contains(@id,'gridview-')]")
	private WebElement nav_CatalogPrivateWebTable;
	
	 ////This object is updated on 10/01/2015 by QAA04
	@FindBy(how=How.XPATH,using="//div[@id='pvtObjGrid-innerCt']//table[1]//div[@class='x-grid-row-expander']")
	//@FindBy(how=How.XPATH,using="//div[9]//tr[1]//tr[1]/td[1]//div[@class='x-grid-row-expander']")
	private WebElement nav_CatalogPrivateFirstExpander;
	 
	 ////This object is updated on 10/01/2015 by QAA04
	@FindBy(how=How.XPATH,using="//table[1]//a/img[@alt='edit private object']")
	//@FindBy(how=How.XPATH,using="//table/tbody/tr[1]/td//a/img[@alt='edit private object']")
	private WebElement nav_CatalogPrivateWebTableEdit;
	
	 ////This object is updated on 10/01/2015 by QAA04
	//Below xpath updated by Vivek - 10/06/2015
	//@FindBy(how=How.XPATH,using="//div/div[2]/span/div/div/table/tbody/tr[1]/td/table/tbody/tr[1]/td[2]/div")
	@FindBy(how=How.XPATH,using="//table[1]/tbody/tr[1]/td[@data-columnid='pvtImgName']/div")
	private WebElement nav_CatalogPrivateFirstVMName;
	
	//@FindBy(how=How.XPATH,using="//input[@role='textbox']")
	//private WebElement nav_CatalogPrivateEditName;
	
	@FindBy(how=How.XPATH,using="//textarea[@role='textbox']")
	private WebElement nav_CatalogPrivateEditDesc;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Save')]")
	private WebElement nav_CatalogPrivateEditSave;
	
	@FindBy(how=How.XPATH,using="//a/img[@alt='manage catalogs']")
	private WebElement nav_CatalogPrivateManageCatalogBtn;
	
	@FindBy(how=How.XPATH,using="//a/img[@alt='add catalog']")
	private WebElement nav_CatalogPrivateAddCatalogLink;
	
	@FindBy(how=How.ID,using="addPvtCatalogName-inputEl")
	private WebElement nav_CatalogPrivateAddCatalogNameEdt;
	
	@FindBy(how=How.ID,using="addPvtCatalogDesc-inputEl")
	private WebElement nav_CatalogPrivateAddCatalogDescEdt;
	
	@FindBy(how=How.XPATH,using="//span[@id='addPvtCatalog']/a[contains(text(),'OK')]")
	private WebElement nav_CatalogPrivateAddCatalogOKBtn;
	
	@FindBy(how=How.XPATH,using="//div[@id='manageCatalogPopup']/button[@class='close_icon']/img[contains(@src,'Close_Icon')]")
	private WebElement nav_CatalogPrivateAddCatalogCloseBtn;

	 ////This object is updated on 10/01/2015 by QAA04
	//@FindBy(how=How.XPATH,using="//div[10]//table[1]//div[@class='x-grid-row-expander']")
	//Update by Vivek - 2/12/2016
	@FindBy(how=How.XPATH,using="//div[@id='manageCatalogPanel-body']/div[contains(@id,'gridview-')]//table[1]//div[@class='x-grid-row-expander']")
	//@FindBy(how=How.XPATH,using="//div[10]//tr[1]//tr[1]/td[1]//div[@class='x-grid-row-expander']")
	private WebElement nav_CatalogPrivateAddCatalogFirstExpander;
	
	 ////This object is updated on 10/01/2015 by QAA04
	@FindBy(how=How.ID,using="manageCatalogPanel-body")
	//@FindBy(how=How.XPATH,using="//div[@id='manageCatalogPanel-body']/div/table/tbody[contains(@id,'gridview-')]")
	private WebElement nav_CatalogPrivateManageCatalogWebTable;
	
	 ////This object is updated on 10/01/2015 by QAA04
////This object is updated on 3/23/2016 by Arul
	@FindBy(how=How.XPATH,using="//a[contains(@id,'editPvtCatalog-urn')]/img[@alt='Edit private Catalog']")
	//@FindBy(how=How.XPATH,using="//div[10]//tr[1]//tr[2]//a[contains(@id,'editPvtCatalog-urn')]/img[@alt='Edit private Catalog']")
	private WebElement nav_CatalogPrivateAddCatalogEditBtn;
	
	@FindBy(how=How.XPATH,using="//input[contains(@id,'editPvtCat-Name-inputId-urn')]")
	private WebElement nav_CatalogPrivateAddCatalogEditNameEdit;
	
	@FindBy(how=How.XPATH,using="//textarea[contains(@id,'editPvtCat-desc-inputId-urn')]")
	private WebElement nav_CatalogPrivateAddCatalogEditDescriptionEdit;
	
	@FindBy(how=How.XPATH,using="//span[@id='editPvtCatalogBut']/a[contains(text(),'OK')]")
	private WebElement nav_CatalogPrivateAddCatalogEditDialogOKBtn;
	
	@FindBy(how=How.XPATH,using="//a[contains(@id,'copyPvtObj-urn')]")
	private WebElement nav_CatalogPrivateCopyBtn;
	
	@FindBy(how=How.XPATH,using="//span[@id='copyPvtObjBut']/a[contains(text(),'Copy')]")
	private WebElement nav_CatalogPrivateCopyDialogCopyBtn;
	
	@FindBy(how=How.XPATH,using="//div[@id='pvtObjCopyPopup']//a[text()='Cancel']")
	private WebElement nav_CatalogPrivateCopyDialogCancelBtn;
	
	 ////This object is updated on 10/01/2015 by QAA04
	//@FindBy(how=How.XPATH,using="//div[@id='pvtObjCopyDest']//div[contains(@id,'-inputWrap')]")
	@FindBy(how=How.XPATH,using="//div[@id='pvtObjCopyDest']//div[contains(@id,'copyPvtObj-destCat-extId-urnvcloudvapptemplate')][2]")
	//@FindBy(how=How.XPATH,using="//td[contains(@id,'copyPvtObj-destCat-extId-urn')]/..//td[contains(@id,'ext-gen')]/div[contains(@id,'ext-gen')]")
	private WebElement nav_CatalogPrivateCopyDropDownArrow;
	
	@FindBy(how=How.XPATH,using="//a[contains(@id,'deployPvtObj-urn')]")
	private WebElement nav_CatalogPrivateDeployBtn;
	
	@FindBy(how=How.XPATH,using="//input[contains(@id,'deployPvtObj-Name-inputId-urn')]")
	private WebElement nav_CatalogPrivateDeployNameEdit;
	
	@FindBy(how=How.XPATH,using="//input[contains(@id,'deployPvtObj-strProf-inputId-urn')]")
	private WebElement nav_CatalogPrivateDeployDropDownArrow;
	
	@FindBy(how=How.XPATH,using="//span[@id='deployPvtObjBut']/a[contains(text(),'Deploy')]")
	private WebElement nav_CatalogPrivateDeployDialogDeployBtn;	
	
	@FindBy(how=How.XPATH,using="//a[contains(@id,'movePvtObj-urn')]")
	private WebElement nav_CatalogPrivateMoveBtn;
	
	 ////This object is updated on 10/01/2015 by QAA04
	//@FindBy(how=How.XPATH,using="//div[@id='pvtObjMoveDest']//div[contains(@id,'-inputWrap')]")
	//@FindBy(how=How.XPATH,using="//div[@id='pvtObjMoveDest']//div[contains(@id,'movePvtObj-destCat-extId-urnvcloudvapptemplat')][2]")
	//Updated by Vivek- 2/12/2016
	@FindBy(how=How.XPATH,using="//div[contains(@id,'movePvtObj-destCat-extId-urnvcloudvapptemplat')][contains(@id,'-trigger-picker')]")
	//@FindBy(how=How.XPATH,using="//input[contains(@id,'movePvtObj-destCat-inputId-ur')]")
	private WebElement nav_CatalogPrivateMoveDestDropDownArrow;
	
	@FindBy(how=How.XPATH,using="//span[@id='movePvtObjBut']/a[text()='Move']")
	private WebElement nav_CatalogPrivateMoveDialogMoveBtn;
	
	// this below object is added by MNR - 06/01/2016
		@FindBy(how=How.XPATH, using="//input[contains(@id,'movePvtObj-destCat-inputId-urn:')]")
		private WebElement nav_PrivateDestinationDropDownEditField;
		
		@FindBy(how=How.ID,using="manageCatalogPanel")
		private WebElement nav_ManageCatalogTablePopUp;
	
	@FindBy(how=How.XPATH,using="//a[contains(@id,'delPvtObj-urn')]/img")
	private WebElement nav_CatalogPrivateDeleteBtn;
	
	 ////This object is updated on 10/01/2015 by QAA04
	@FindBy(how=How.XPATH,using="//table[1]//a[contains(@id,'delPvtCatalog-urn')]")
	//@FindBy(how=How.XPATH,using="//table/tbody/tr[1]//a[contains(@id,'delPvtCatalog-urn')]")
	private WebElement nav_CatalogPrivateManageCatalogDeleteBtn; 
	
	///sukur////

	@FindBy(how=How.XPATH,using="//input[contains(@id,'editPvtObj-Name-inputId-urn')]")
	private WebElement nav_CatalogPrivateEditName;
	

	@FindBy(how=How.XPATH,using="//div[@id='pvtObjEditPopup']")
	private WebElement nav_CatalogPrivateEditOverlayPage;
	
	@FindBy(how=How.XPATH,using="//span//a[contains(text(),'Cancel')]")
	private WebElement nav_CatalogPrivateEditCancel;
	
	@FindBy(how=How.XPATH,using="//a/img[contains(@src,'DownArrow_Icon.png')]")
	private WebElement nav_SelectEVDCDownArrow;
	
	@FindBy(how=How.XPATH,using="//div[@class='select_evdc']/nobr/ul//ul")
	private WebElement nav_SelectEVDCDrowDown;
	
////////////////////////////////////////////////////Sukur
	
@FindBy(how=How.XPATH,using="//span[text()='Name']")
private WebElement nav_CatalogPrivateManageCatalogListNameColumn;

@FindBy(how=How.XPATH,using="//span[text()='Number of ISOs']")
private WebElement nav_CatalogPrivateManageCatalogListNumberOfISOsColumn;

@FindBy(how=How.XPATH,using="//span[text()='Number of Templates']")
private WebElement nav_CatalogPrivateManageCatalogListNumberOfTemplatesColumn;

@FindBy(how=How.XPATH,using="//span[text()='Total Storage']")
private WebElement nav_CatalogPrivateManageCatalogListTotalStorageColumn;

@FindBy(how=How.XPATH,using="//span[text()='Date Created']")
private WebElement nav_CatalogPrivateManageCatalogListDateCreatedColumn;

@FindBy(how=How.XPATH,using="//span[text()='Description']")
private WebElement nav_CatalogPrivateManageCatalogListDescriptionColumn;

@FindBy(how=How.XPATH,using="//a[contains(@id,'delPvtCatalog-urn')]")
private WebElement nav_PrivateObjectDeleteInManageCatalogList;


@FindBy(how=How.XPATH,using="//a[contains(@id,'editPvtCatalog-urn')]")
private WebElement nav_PrivateObjectEditInManageCatalogList;


@FindBy(how=How.XPATH,using="//textarea[@id='addPvtCatalogDesc-inputEl']")
private WebElement nav_CatalogDescription;

@FindBy(how=How.XPATH,using="//div[@id='pvtCatalogAddPopup']/span[@class='tab_action_button']/a[contains(text(),'Cancel')]")
private WebElement nav_CatalogPrivateAddCatalogCancelBtn;

@FindBy(how=How.ID, using="messagebox-1001")
private WebElement nav_PopupWindow;

@FindBy(how=How.XPATH,using="//div[@id='pvtObjContainer']//div[@class='tabPrint']//img[@alt='CSV']")
private WebElement nav_CatalogPrivateCSVImg;

@FindBy(how=How.XPATH,using="//div[@id='pvtObjContainer']//div[@class='tabPrint']//img[@alt='CSV']//..")
private WebElement nav_CatalogPrivateCSVLink;


@FindBy(how=How.XPATH,using="//section//div[2]/div//a[3]/span/span/span[contains(@id,'btnIconEl')]")
private WebElement nav_CatalogPrivateManageCatalogNextButton;

@FindBy(how=How.XPATH,using="//div[@class='tabPrint']//img[@alt='PDF']")
private WebElement nav_CatalogManagePrivatePDFImg;

@FindBy(how=How.XPATH,using="//div[@class='tabPrint']//img[@alt='PDF']//..")
private WebElement nav_CatalogManagePrivatePDFLink;

@FindBy(how=How.XPATH,using="//div[@class='tabPrint']//img[@alt='CSV']")
private WebElement nav_CatalogManagePrivateCSVImg;

@FindBy(how=How.XPATH,using="//div[@class='tabPrint']//img[@alt='CSV']//..")
private WebElement nav_CatalogManagePrivateCSVLink;

//@FindBy(how=How.XPATH,using="//div[@id='export']//img[@alt='CSV']")
//Update by Vivek- 2/12/2016
@FindBy(how=How.XPATH,using="//div[@id='manage_catalog_print']//img[@alt='CSV']")
private WebElement nav_CatalogWSCSVImg;

//Update by QAA03-03/11/2016
//@FindBy(how=How.XPATH,using="//div[@id='export']//img[@alt='CSV']//..")
@FindBy(how=How.XPATH,using="//div[@id='sharedObjectsPageDiv']//img[@alt='CSV']//..")
private WebElement nav_CatalogWSCSVLink;

//@FindBy(how=How.XPATH,using="//div[@id='export']//img[@alt='PDF']")
//Update by Vivek- 2/12/2016
@FindBy(how=How.XPATH,using="//div[@id='manage_catalog_print']//img[@alt='PDF']")
private WebElement nav_CatalogWSPDFImg;

//@FindBy(how=How.XPATH,using="//div[@id='export']//img[@alt='PDF']//..")
//private WebElement nav_CatalogWSPDFLimk;

@FindBy(how=How.XPATH,using="//div[@id='pvtObjDeployPopup']")
private WebElement nav_CatalogPvtDeployOverlayPage;

@FindBy(how=How.XPATH,using="//div[@id='pvtObjDeployPopup']/span[@class='tab_action_button']/a[text()='Cancel']")
private WebElement nav_CatalogPvtDeployOverlayPageCancelButton;

@FindBy(how=How.XPATH,using="//div[@id='pvtObjDeployPopup']/a[text()='OK']")
private WebElement nav_CatalogPvtDeployOverlayPageOKButton;


@FindBy(how=How.XPATH,using="//div[@id='pvtObjEditPopup']/button[@class='close_icon']")
private WebElement nav_NewCatalogPopUpCloseBtn;

@FindBy(how=How.XPATH,using="//div[@id='pvtCatalogEditPopup']/button[@class='close_icon']")
private WebElement nav_ManageCatalogEditPopUpCloseBtn;


@FindBy(how=How.XPATH,using="//div[@id='pvtObjContainer']//div[contains(text(),'Upload')]")
private WebElement nav_CatalogPvtUploadButton;

////This object is updated on 10/01/2015 by QAA04
//@FindBy(how=How.XPATH,using="//table[1]//section[2]/div/a")
//Updated by Vivek -2/12/2016
@FindBy(how=How.XPATH,using="//div[@id='pvtObjGrid-innerCt']//table[1]//a[text()='Storage Details']")
//@FindBy(how=How.XPATH,using="//tr[1]/td/table/tbody/tr[2]/td/div/section[2]/div/a")
private WebElement nav_CatalogPvtStorageDetailsLink;

@FindBy(how=How.XPATH,using="//section//div[@id='pvtObjContainer']/div[2]//a[text()='Cancel']")
private WebElement nav_CatalogPrivateMoveDialogCancelButton;

@FindBy(how=How.XPATH,using="//div[1][@id='pvtObjMovePopup']")
private WebElement nav_CatalogPrivateMoveOverlayPage;

////This object is updated on 10/01/2015 by QAA04
//@FindBy(how=How.XPATH,using="//div[@id='pvtObjMoveDest']//div[contains(@id,'-inputWrap')]")
@FindBy(how=How.XPATH,using="//div[contains(@id,'boundlist-')]/ul[@class='x-list-plain']")
private WebElement nav_CatalogPrivateMoveDestDropDown;

@FindBy(how=How.ID,using="pvtCatalogEditPopup")
private WebElement nav_CatalogPrivateManageEditOverLayPage;

@FindBy(how=How.XPATH,using="//div[@id='pvtCatalogEditNewName']//input")
private WebElement nav_CatalogPrivateManageEditOverLayPageName;

@FindBy(how=How.XPATH,using="//div[@id='pvtCatalogEditDesc']//textarea")
private WebElement nav_CatalogPrivateManageEditOverLayPageDesc;

@FindBy(how=How.XPATH,using="//span[@id='editPvtCatalogBut']/a[text()='OK']")
private WebElement nav_CatalogPrivateManageEditOverLayPageOKButton;

@FindBy(how=How.XPATH,using="//div[@id='pvtCatalogEditPopup']//a[text()='Cancel']")
private WebElement nav_CatalogPrivateManageEditOverLayPageCancelButton;

//@FindBy(how=How.ID, using="button-1005-btnIconEl")
@FindBy(how=How.ID, using="button-1005-btnEl")
private WebElement nav_PopupOkBtn;

@FindBy(how=How.XPATH,using="//div[@class='manageCatalogPopup']/button[@class='close_icon']")
private WebElement nav_CatalogPrivateManageCatalogListCloseButton;

@FindBy(how=How.XPATH,using="//div[@id='pvtObjContainer']//div[@class='tabPrint']//img[@alt='PDF']//..")
private WebElement nav_CatalogPrivatePDFLink;

//Updated by QAA03 -03/11/2016
//@FindBy(how=How.XPATH,using="//div[@id='export']//img[@alt='PDF']//..")
@FindBy(how=How.XPATH,using="//div[@id='sharedObjectsPageDiv']//img[@alt='PDF']//..")
private WebElement nav_CatalogWSPDFLink;
	
	//###################################################################
	//###################################################################

	public WebElement getNav_EVDCname() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCname;
	}

	public WebElement getNav_CatalogPortletLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPortletLink;
	}

	public WebElement getNav_CatalogWindStreamLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogWindStreamLink;
	}

	public WebElement getNav_CatalogPrivateLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateLink;
	}

	public WebElement getNav_CatalogWindStreamPDFImg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogWindStreamPDFImg;
	}

	public WebElement getNav_CatalogPrivatePDFImg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivatePDFImg;
	}

	public WebElement getNav_CatalogPrivateWebTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateWebTable;
	}

	public WebElement getNav_CatalogPrivateFirstExpander() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateFirstExpander;
	}

	public WebElement getNav_CatalogPrivateWebTableEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateWebTableEdit;
	}

	//public WebElement getNav_CatalogPrivateEditName() {
	//	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	//	return nav_CatalogPrivateEditName;
	//}

	public WebElement getNav_CatalogPrivateEditDesc() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateEditDesc;
	}

	public WebElement getNav_CatalogPrivateEditSave() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateEditSave;
	}

	public WebElement getNav_CatalogPopUpOKBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPopUpOKBtn;
	}

	public WebElement getNav_CatalogUserFeedBack() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogUserFeedBack;
	}

	public WebElement getNav_CatalogWindStreamFirstExpander() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogWindStreamFirstExpander;
	}

	public WebElement getNav_CatalogWindStreamCopyBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogWindStreamCopyBtn;
	}



	public WebElement getNav_CatalogDropDown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogDropDown;
	}

	public WebElement getNav_CatalogWindStreamCopyDialogCopyBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogWindStreamCopyDialogCopyBtn;
	}

	public WebElement getNav_CatalogWindStreamCopyDestDropDownArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogWindStreamCopyDestDropDownArrow;
	}

	public WebElement getNav_CatalogWindStreamDeployBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogWindStreamDeployBtn;
	}

	public WebElement getNav_CatalogWindStreamDeployNameEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogWindStreamDeployNameEdit;
	}

	public WebElement getNav_CatalogWindStreamDeployStorageProfileDropDownArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogWindStreamDeployStorageProfileDropDownArrow;
	}

	public WebElement getNav_CatalogDeployDropDown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogDeployDropDown;
	}

	public WebElement getNav_CatalogWindStreamDeployDialogDeployBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogWindStreamDeployDialogDeployBtn;
	}

	public WebElement getNav_CatalogPrivateManageCatalogBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateManageCatalogBtn;
	}

	public WebElement getNav_CatalogPrivateAddCatalogLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateAddCatalogLink;
	}

	public WebElement getNav_CatalogPrivateAddCatalogNameEdt() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateAddCatalogNameEdt;
	}

	public WebElement getNav_CatalogPrivateAddCatalogDescEdt() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateAddCatalogDescEdt;
	}

	public WebElement getNav_CatalogPrivateAddCatalogOKBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateAddCatalogOKBtn;
	}

	public WebElement getNav_CatalogPrivateAddCatalogCloseBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateAddCatalogCloseBtn;
	}

	public WebElement getNav_CatalogPrivateAddCatalogFirstExpander() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateAddCatalogFirstExpander;
	}

	public WebElement getNav_CatalogPrivateAddCatalogEditBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateAddCatalogEditBtn;
	}

	public WebElement getNav_CatalogPrivateAddCatalogEditNameEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateAddCatalogEditNameEdit;
	}

	public WebElement getNav_CatalogPrivateAddCatalogEditDescriptionEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateAddCatalogEditDescriptionEdit;
	}

	public WebElement getNav_CatalogPrivateAddCatalogEditDialogOKBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateAddCatalogEditDialogOKBtn;
	}

	public WebElement getNav_CatalogPrivateCopyBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateCopyBtn;
	}

	public WebElement getNav_CatalogPrivateCopyDropDownArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateCopyDropDownArrow;
	}

	public WebElement getNav_CatalogPrivateCopyDialogCopyBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateCopyDialogCopyBtn;
	}

	public WebElement getNav_CatalogPrivateDeployBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateDeployBtn;
	}

	public WebElement getNav_CatalogPrivateDeployNameEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateDeployNameEdit;
	}

	public WebElement getNav_CatalogPrivateDeployDropDownArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateDeployDropDownArrow;
	}

	public WebElement getNav_CatalogPrivateDeployDialogDeployBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateDeployDialogDeployBtn;
	}

	public WebElement getNav_CatalogPrivateMoveBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateMoveBtn;
	}

	public WebElement getNav_CatalogPrivateMoveDestDropDownArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateMoveDestDropDownArrow;
	}

	public WebElement getNav_CatalogPrivateMoveDialogMoveBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateMoveDialogMoveBtn;
	}

	public WebElement getNav_CatalogPrivateDeleteBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateDeleteBtn;
	}

	public WebElement getNav_CatalogPrivateManageCatalogDeleteBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateManageCatalogDeleteBtn;
	}

	public WebElement getNav_CatalogWindStreamCopyDialogCancelBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogWindStreamCopyDialogCancelBtn;
	}

	public WebElement getNav_CatalogPopUpCancelBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPopUpCancelBtn;
	}

	public WebElement getNav_CatalogPopUpMessage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPopUpMessage;
	}

	public WebElement getNav_CatalogPrivateCopyDialogCancelBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateCopyDialogCancelBtn;
	}


	public WebElement getNav_CatalogPrivateFirstVMName() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateFirstVMName;
	}
	

	public WebElement getNav_CatalogPrivateManageCatalogListNameColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateManageCatalogListNameColumn;
	}

	public WebElement getNav_CatalogPrivateManageCatalogListNumberOfISOsColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateManageCatalogListNumberOfISOsColumn;
	}

	
	public WebElement getNav_CatalogPrivateManageCatalogListNumberOfTemplatesColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateManageCatalogListNumberOfTemplatesColumn;
	}

	
	public WebElement getNav_CatalogPrivateManageCatalogListTotalStorageColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();

		return nav_CatalogPrivateManageCatalogListTotalStorageColumn;
	}

	
	public WebElement getNav_CatalogPrivateManageCatalogListDateCreatedColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();

		return nav_CatalogPrivateManageCatalogListDateCreatedColumn;
	}

	
	public WebElement getNav_CatalogPrivateManageCatalogListDescriptionColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();

		return nav_CatalogPrivateManageCatalogListDescriptionColumn;
	}

	public WebElement getNav_PrivateObjectDeleteInManageCatalogList() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();

		return nav_PrivateObjectDeleteInManageCatalogList;
	}

	
	public WebElement getNav_PrivateObjectEditInManageCatalogList() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();

		return nav_PrivateObjectEditInManageCatalogList;
	}


	public WebElement getNav_CatalogName() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();

		return nav_CatalogName;
	}

	public WebElement getNav_CatalogDescription() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();

		return nav_CatalogDescription;
	}

	public WebElement getNav_CatalogPrivateAddCatalogCancelBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();

		return nav_CatalogPrivateAddCatalogCancelBtn;
	}
	public WebElement getNav_PopupWindow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PopupWindow;
	}
	public WebElement getNav_CatalogPrivateCSVImg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateCSVImg;
	}
	public WebElement getNav_CatalogPrivateManageCatalogWebTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateManageCatalogWebTable;
	}
	public WebElement getNav_CatalogPrivateManageCatalogNextPaginiation() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogPrivateManageCatalogNextButton;
	}
	
	public WebElement getNav_CatalogManagePrivatePDFImg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogManagePrivatePDFImg;
	}
	public WebElement getNav_CatalogManagePrivateCSVImg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogManagePrivateCSVImg;
	}
	
	
	public WebElement getNav_CatalogWSPDFImg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogWSPDFImg;
	}
	public WebElement getNav_CatalogWSCSVImg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CatalogWSCSVImg;
	}
	 public WebElement getNav_CatalogPrivateManageCatalogNextButton() {
		 FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CatalogPrivateManageCatalogNextButton;
		}

		public WebElement getNav_NewCatalogPopUpMessage() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_NewCatalogPopUpMessage;
		}

		public WebElement getNav_NewCatalogPopUpBody() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_NewCatalogPopUpBody;
		}

		public WebElement getNav_NewCatalogPopUpOKBtn() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_NewCatalogPopUpOKBtn;
		}
		
		public WebElement getNav_NewCatalogPopUpCancelBtn() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_NewCatalogPopUpCancelBtn;
		}
		public WebElement getNav_CatalogPvtDeployOverlayPage() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CatalogPvtDeployOverlayPage;
		}
		public WebElement getNav_CatalogPvtDeployOverlayPageCancelButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CatalogPvtDeployOverlayPageCancelButton;
		}
		public WebElement getNav_CatalogPvtUploadButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CatalogPvtUploadButton;
		}
		public WebElement getNav_CatalogPvtStorageDetailsLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CatalogPvtStorageDetailsLink;
		}
		public WebElement getNav_CatalogPrivateMoveDialogCancelButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CatalogPrivateMoveDialogCancelButton;
		}
		public WebElement getNav_CatalogPrivateMoveOverlayPage() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CatalogPrivateMoveOverlayPage;
		}
		public WebElement getNav_CatalogPrivateMoveDestDropDown() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CatalogPrivateMoveDestDropDown;
		}
		
		public WebElement getNav_CatalogPrivateEditCancel() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CatalogPrivateEditCancel;
		}
		
		public WebElement getNav_CatalogPrivateEditOverlayPage() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CatalogPrivateEditOverlayPage;
		}
		public WebElement getNav_NewCatalogPopUpCloseBtn() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_NewCatalogPopUpCloseBtn;
		}
		
		public WebElement getNav_CatalogPrivateManageEditOverLayPage() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CatalogPrivateManageEditOverLayPage;
		}
		
		public WebElement getNav_CatalogPrivateManageEditOverLayPageName() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CatalogPrivateManageEditOverLayPageName;
		}
		
		public WebElement getNav_CatalogPrivateManageEditOverLayPageDesc() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CatalogPrivateManageEditOverLayPageDesc;
		}
		
		public WebElement getNav_CatalogPrivateManageEditOverLayPageOKButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CatalogPrivateManageEditOverLayPageOKButton;
		}
		
		public WebElement getNav_CatalogPrivateManageEditOverLayPageCancelButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CatalogPrivateManageEditOverLayPageCancelButton;
		}
		
		public WebElement getNav_ManageCatalogEditPopUpCloseBtn() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_ManageCatalogEditPopUpCloseBtn;
		}
		public WebElement getNav_PopupOkBtn() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_PopupOkBtn;
		}
		public WebElement getNav_CatalogPrivateManageCatalogListCloseButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CatalogPrivateManageCatalogListCloseButton;
		}

		public WebElement getNav_CatalogPrivateEditName() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CatalogPrivateEditName;
		}

		public WebElement getNav_CatalogPrivateCSVLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CatalogPrivateCSVLink;
		}

		public WebElement getNav_CatalogManagePrivatePDFLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CatalogManagePrivatePDFLink;
		}

		public WebElement getNav_CatalogManagePrivateCSVLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CatalogManagePrivateCSVLink;
		}

		public WebElement getNav_CatalogWSCSVLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CatalogWSCSVLink;
		}

		public WebElement getNav_CatalogWSPDFLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CatalogWSPDFLink;
		}

		public WebElement getNav_CatalogPvtDeployOverlayPageOKButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CatalogPvtDeployOverlayPageOKButton;
		}

		public WebElement getNav_CatalogPrivatePDFLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CatalogPrivatePDFLink;
		}

		public WebElement getNav_SelectEVDCDownArrow() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_SelectEVDCDownArrow;
		}

		public WebElement getNav_SelectEVDCDrowDown() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_SelectEVDCDrowDown;
		}

		public WebElement getNav_ErrDialogBox() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_ErrDialogBox;
		}

		public WebElement getNav_SharedObjectsWebTableParent() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_SharedObjectsWebTableParent;
		}

		public WebElement getNav_PrivateDestinationDropDownEditField() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_PrivateDestinationDropDownEditField;
		}

		public WebElement getNav_ManageCatalogTablePopUp() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_ManageCatalogTablePopUp;
		}
		
		

}
