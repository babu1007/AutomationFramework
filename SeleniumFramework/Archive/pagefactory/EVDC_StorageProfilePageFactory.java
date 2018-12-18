package com.whs.navigator.pagefactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;

public class EVDC_StorageProfilePageFactory {
	
	//@FindBy(how=How.XPATH, using = "//section[@id='Storage']/div[@class='block_header']//a[text()='Storage']")
	@FindBy(how=How.XPATH,using="//a[text()='Storage']")
	private WebElement nav_StorageLink;
	
	@FindBy(how=How.XPATH, using = "//div[@class='header_wrapper'] //li[@class='first']//a[text()='Home']/../../..//li[@class='last']")
	private WebElement nav_breadCrumbChain;
	
	//@FindBy(how=How.XPATH, using = "//div[@id='vm_create']//a[text()='Add Storage Tier']")
	@FindBy(how=How.XPATH,using="//a[text()='Add Storage Tier']")
	private WebElement nav_AddStoraegTeirLink;
	
	///-----------------------------Arul-------------------------------
	@FindBy(how=How.XPATH,using="//div[@id='chart_storage']//*[name()='svg'][@id='stackedTSSvg']//*[name()='circle']")
	private List<WebElement> nav_StorageProfileCircle;
	
	/*@FindBy(how=How.XPATH,using="//div[@class='sTSTooltip]")
	private List<WebElement> nav_StorageProfileToolTipMsgList;*/
	
	@FindBy(how=How.XPATH,using="//div[@class='sTSTooltip']")
	private WebElement nav_StorageProfileToolTipMsg;
	
	/// ________________________ QAA04 _______________________ ////
	
/// Taken from clarktestcase_SLPPageFactory
	
	@FindBy(how=How.XPATH, using = "//div[@id='vm_print']//img[@alt='PDF']")
	private WebElement nav_PdfIcon;
	
	@FindBy(how=How.XPATH, using = "//div[@id='vm_print']//img[@alt='CSV']")
	private WebElement nav_CsvIcon;
	
	//////Sukur Added Dated on 11/07/2016. For writing TC for Lorien release
	@FindBy(how=How.XPATH, using = "//span[contains(text(),'Capacity Tier - Encrypted')]/../span/span")
	private WebElement nav_CapcityTierToolTip;
	//@FindBy(how=How.XPATH, using = "//span[contains(text(),'Capacity Tier')]/../span/img")
	@FindBy(how=How.XPATH, using = "//span[contains(text(),'Capacity Tier')]/../span/span")
	private WebElement nav_CapcityTierEncryptedToolTip;
	@FindBy(how=How.XPATH, using = "//span[contains(text(),'Non-Replicated-EMC-SAN')]/../span/span")
	private WebElement nav_NonReplicatedTierToolTip;
	
	//Valen Test Case - Vivek - 08022016
	@FindBy(how=How.XPATH,using="//div[contains(@id,'storageDetailPanelCont-')][@class='x-container x-column x-container-default']//a[contains(@id,'q-quotaST-')]")
	private List<WebElement> nav_StorageProfileQuotaButton;
	
	//Getting all Storgae Profile block
	@FindBy(how=How.XPATH,using="//div[contains(@id,'storageDetailPanelCont-')][@class='x-container x-column x-container-default']")
	private List<WebElement> nav_StorageProfileBlk;
	//Getting all Delete Btn
	@FindBy(how=How.XPATH,using="//div[contains(@id,'storageDetailPanelCont-')][@class='x-container x-column x-container-default']//a[contains(@id,'d-deleteST')]")
	private List<WebElement> nav_StorageProfileBlkDelBtn;
	
	/////Sukur Added Dated on 11/07/2016. For writing TC for Lorien release
	public WebElement getNav_CapcityTierToolTip() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CapcityTierToolTip;
	}
	
	public WebElement getNav_CapcityTierEncryptedToolTip() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CapcityTierEncryptedToolTip;
	}
	
	public WebElement getNav_NonReplicatedTierToolTip() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NonReplicatedTierToolTip;
	}
	////____________________________QAA04______________________////
	
	
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

	
	
	
	

}
