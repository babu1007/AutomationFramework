package com.whs.navigator.pagefactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class EVDC_StorageProfilePageFactory {
	
	//@FindBy(how=How.XPATH, using = "//section[@id='Storage']/div[@class='block_header']//a[text()='Storage']")
	@FindBy(how=How.XPATH,using="//a[text()='Storage']")
	private WebElement nav_StorageLink;
	
	@FindBy(how=How.XPATH, using = "//div[@class='header_wrapper'] //li[@class='first']//a[text()='Home']/../../..//li[@class='last']")
	private WebElement nav_breadCrumbChain;
	
	//@FindBy(how=How.XPATH, using = "//div[@id='vm_create']//a[text()='Add Storage Tier']")
	@FindBy(how=How.XPATH,using="//a[text()='Add Storage Tier']")
	private WebElement nav_AddStoraegTeirLink;
	
	/// ________________________ QAA04 _______________________ ////
	
/// Taken from clarktestcase_SLPPageFactory
	
	@FindBy(how=How.XPATH, using = "//div[@id='vm_print']//img[@alt='PDF']")
	private WebElement nav_PdfIcon;
	
	@FindBy(how=How.XPATH, using = "//div[@id='vm_print']//img[@alt='CSV']")
	private WebElement nav_CsvIcon;
	
	@FindBy(how=How.XPATH,using="//div[@id='chart_storage']//*[name()='svg'][@id='stackedTSSvg']//*[name()='circle']")
	private List<WebElement> nav_StorageProfileCircle;
	
	/*@FindBy(how=How.XPATH,using="//div[@class='sTSTooltip]")
	private List<WebElement> nav_StorageProfileToolTipMsgList;*/
	
	@FindBy(how=How.XPATH,using="//div[@class='sTSTooltip']")
	private WebElement nav_StorageProfileToolTipMsg;
	
	//Valen Test Case - Vivek - 08022016
		@FindBy(how=How.XPATH,using="//div[contains(@id,'storageDetailPanelCont-')][@class='x-container x-column x-container-default']//a[contains(@id,'q-quotaST-')]")
		private List<WebElement> nav_StorageProfileQuotaButton;
		
		//Getting all Storgae Profile block
		@FindBy(how=How.XPATH,using="//div[contains(@id,'storageDetailPanelCont-')][@class='x-container x-column x-container-default']")
		private List<WebElement> nav_StorageProfileBlk;
		//Getting all Delete Btn
		@FindBy(how=How.XPATH,using="//div[contains(@id,'storageDetailPanelCont-')][@class='x-container x-column x-container-default']//a[contains(@id,'d-deleteST')]")
		private List<WebElement> nav_StorageProfileBlkDelBtn;
		
		// allocated value for each Storage profile
		@FindBy(how=How.XPATH,using="//div[contains(@id,'storageDetailPanelCont')]//*[name()='text'][@fill='#39b119']//*[name()='tspan']")
		private List<WebElement> nav_StorageProfileAllocatedValueSVG;
		

			
		//Popup confirmation
		@FindBy(how=How.XPATH,using="//div[contains(@id,'-msg')][contains(@class,'x-window-text')]")
		private WebElement nav_StorageProfilePopUpConfirmBox;
		
		@FindBy(how=How.ID,using="storage-chart-urn:vcloud:vdcstorageProfile:2df7d531-33db-42de-9230-dc21f0baca33")
		private WebElement nav_StorageProfileChartArea;
		
		@FindBy(how=How.XPATH,using="//section[@class='evdc_rectangle evdc_square_tall']")
		
		private WebElement nav_EVDCStoragePortlet;
		
		////____________________________QAA04______________________////
		
		//Valen Test Case -QAA03 - 08/09/2016
		
				@FindBy(how=How.XPATH,using="//div[contains(@id,'storageDetailPanelCont-')]//div[@class='spname']/span[1]")
				private List<WebElement> nav_StorageProfile_TierNames;
				
				@FindBy(how=How.XPATH,using="//div[contains(@id,'storageDetailPanelCont')]//*[name()='text'][@fill='#25427e']//*[name()='tspan']")
				private List<WebElement> nav_StorageProfile_QuotavalueSVG;
				
				@FindBy(how=How.XPATH,using="//div[contains(@id,'storageDetailPanelCont')]//*[name()='rect'][@fill='#25427e']")
				private List<WebElement> nav_StorageProfile_QuotaBox;
				
				@FindBy(how=How.XPATH,using="//div[contains(@id,'storageDetailPanelCont')]//*[name()='rect'][@fill='#3fae29']")
				private List<WebElement> nav_StorageProfile_AllocatedBox;
				
				@FindBy(how=How.XPATH,using="//div[contains(@id,'storageDetailPanelCont')]//*[name()='text'][@fill='#fa0000']//*[name()='tspan']")
				private List<WebElement> nav_StorageProfile_CommittedRedvalueSVG;
				
				@FindBy(how=How.XPATH,using="//div[contains(@id,'storageDetailPanelCont')]//*[name()='text'][@fill='#fa0000']//*[name()='tspan']")
				private List<WebElement> nav_StorageProfile_CommittedvalueSVG;
				
				@FindBy(how=How.ID,using="q-quotaST-0-btnInnerEl")
				private WebElement nav_StorageCapacityTierQuotaBtn;
				
				@FindBy(how=How.XPATH,using="//div[@id='agreement_panel_header-innerCt']//span")
				private WebElement nav_QuotaPopupWindow_TierName;
				
				@FindBy(how=How.NAME,using="dateRequested")
				private WebElement nav_QuotaPopupWindow_DateRequestedField;
				
				@FindBy(how=How.NAME,using="quota-display")
				private WebElement nav_QuotaPopupWindow_TotalRequestQuotaField;
				
				@FindBy(how=How.NAME,using="pricePerGB")
				private WebElement nav_QuotaPopupWindow_PricePerGBQuotaField;
				
				@FindBy(how=How.ID,using="agreement-cb-inputEl")
				private WebElement nav_QuotaPopupWindow_AgreeCheckBox;
				
				@FindBy(how=How.XPATH,using="//span[contains(@id,'-btnInnerEl')][text()='OK']")
				private WebElement nav_QuotaPopupWindow_OkButton;
								
				@FindBy(how=How.ID,using="hs_msgbox_0")
				private WebElement nav_Quota_GreaterMax_PopupBox;
				
				@FindBy(how=How.ID,using="hs_msgbox_0-msg")
				private WebElement nav_Quota_GreaterMax_PopupBoxMsg;
								
				@FindBy(how=How.ID,using="learnmore_panel")
				private WebElement nav_Quota_LearnMore_PopupBoxMsg;
				
				@FindBy(how=How.XPATH,using="//div[@id='learnmore_panel_header-targetEl']//div[contains(@class,'x-title-text')]")
				private WebElement nav_Quota_LearnMore_PopupMsgTitle;	
				
				@FindBy(how=How.XPATH,using="//div[@id='learnmore_panel-targetEl']/div")
				private WebElement nav_Quota_LearnMore_PopupMsgInf;
				
				@FindBy(how=How.XPATH,using="//a[contains(@class,'learnmore-btn-cls')]")
				private WebElement nav_Quota_LearnMore_PopupOkButton;
				
		
		public WebElement getNav_nav_StorageCapacityTierQuotaBtn() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_StorageCapacityTierQuotaBtn;
				}
		
		public WebElement getNav_EVDCStoragePortlet() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EVDCStoragePortlet;
		}
		
		public WebElement getNav_StorageProfileChartArea() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_StorageProfileChartArea;
		}
		
	
	public WebElement getNav_StorageLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_StorageLink;
	}
	
	public WebElement getNav_breadCrumbChain() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_breadCrumbChain;
	}
	
	public WebElement getNav_AddStoraegTeirLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddStoraegTeirLink;
	}

	public WebElement getNav_PdfIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PdfIcon;
	}

	public WebElement getNav_CsvIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CsvIcon;
	}

	public List<WebElement> getNav_StorageProfileCircle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_StorageProfileCircle;
	}

	public WebElement getNav_StorageProfileToolTipMsg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_StorageProfileToolTipMsg;
	}

	public List<WebElement> getNav_StorageProfileQuotaButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_StorageProfileQuotaButton;
	}

	public List<WebElement> getNav_StorageProfileBlk() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_StorageProfileBlk;
	}

	public List<WebElement> getNav_StorageProfileBlkDelBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_StorageProfileBlkDelBtn;
	}

	public List<WebElement> getNav_StorageProfileAllocatedValueSVG() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_StorageProfileAllocatedValueSVG;
	}

		
	public WebElement getNav_StorageProfilePopUpConfirmBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_StorageProfilePopUpConfirmBox;
	}

	public List<WebElement> getNav_StorageProfile_TierNames() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_StorageProfile_TierNames;
	}

	public List<WebElement> getNav_StorageProfile_QuotavalueSVG() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_StorageProfile_QuotavalueSVG;
	}

	public List<WebElement> getNav_StorageProfile_QuotaBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_StorageProfile_QuotaBox;
	}

	public List<WebElement> getNav_StorageProfile_AllocatedBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_StorageProfile_AllocatedBox;
	}

	public List<WebElement> getNav_StorageProfile_CommittedRedvalueSVG() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_StorageProfile_CommittedRedvalueSVG;
	}

	public List<WebElement> getNav_StorageProfile_CommittedvalueSVG() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_StorageProfile_CommittedvalueSVG;
	}

	public WebElement getNav_StorageCapacityTierQuotaBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_StorageCapacityTierQuotaBtn;
	}

	public WebElement getNav_QuotaPopupWindow_TierName() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_QuotaPopupWindow_TierName;
	}

	public WebElement getNav_QuotaPopupWindow_DateRequestedField() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_QuotaPopupWindow_DateRequestedField;
	}

	public WebElement getNav_QuotaPopupWindow_TotalRequestQuotaField() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_QuotaPopupWindow_TotalRequestQuotaField;
	}

	public WebElement getNav_QuotaPopupWindow_PricePerGBQuotaField() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_QuotaPopupWindow_PricePerGBQuotaField;
	}

	public WebElement getNav_QuotaPopupWindow_AgreeCheckBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_QuotaPopupWindow_AgreeCheckBox;
	}

	public WebElement getNav_QuotaPopupWindow_OkButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_QuotaPopupWindow_OkButton;
	}

	public WebElement getNav_Quota_GreaterMax_PopupBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Quota_GreaterMax_PopupBox;
	}

	public WebElement getNav_Quota_GreaterMax_PopupBoxMsg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Quota_GreaterMax_PopupBoxMsg;
	}

	public WebElement getNav_Quota_LearnMore_PopupBoxMsg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Quota_LearnMore_PopupBoxMsg;
	}

	public WebElement getNav_Quota_LearnMore_PopupOkButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Quota_LearnMore_PopupOkButton;
	}

	public WebElement getNav_Quota_LearnMore_PopupMsgTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Quota_LearnMore_PopupMsgTitle;
	}

	public WebElement getNav_Quota_LearnMore_PopupMsgInf() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Quota_LearnMore_PopupMsgInf;
	}

	
	
	

}
