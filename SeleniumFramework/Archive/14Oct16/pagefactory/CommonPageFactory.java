package com.whs.navigator.pagefactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;

public class CommonPageFactory {
	
	//Common PopUp Body
	@FindBy(how=How.ID,using="messagebox-1001")
	private WebElement nav_CommonPopUp;
	
	@FindBy(how=How.ID,using="navpopupbody")
	private WebElement nav_CommonPopUpBox;
	
	
	@FindBy(how=How.XPATH,using="//div[@id='navpopupbuttons']/span[1]//a")
	private WebElement nav_ConfirmPopUpOkBtn;
	
	
	//Common PopUp Title
	//@FindBy(how=How.ID,using="messagebox-1001_header_hd-textEl")-by Priyanka on 10/06/15
	@FindBy(how=How.ID,using="messagebox-1001_header")
	private WebElement nav_CommonPopUpTitle;
	
	
	//Common Popup Message  Dialog Box
	//@FindBy(how=How.ID, using="messagebox-1001-displayfield-inputEl")-by Priyanka on 10/06/15
	@FindBy(how=How.ID,using="messagebox-1001-body")
	//@FindBy(how=How.ID,using="messagebox-1001-msg")
	private WebElement nav_CommonPopUpMessage;
	
	//Common PopUp OK Buttom
	//@FindBy(how=How.ID, using="button-1005-btnIconEl")-by Priyanka on 10/06/15
	@FindAll({
		@FindBy(how=How.ID, using="button-1005-btnInnerEl"),
		@FindBy(how=How.ID, using="button-1006-btnInnerEl"),
		@FindBy(how=How.XPATH, using="//a[contains(@id,'button-')][@class='x-btn x-unselectable x-box-item x-toolbar-item x-btn-default-small x-focus x-btn-focus x-btn-default-small-focus']"),
		@FindBy(how=How.XPATH, using="//div[contains(@id,'messagebox-')]//span[contains(@id,'-btnInnerEl')]")
	})
	private List<WebElement> nav_CommonPopUpOKButton;

	@FindBy(how=How.ID, using="button-1005-btnInnerEl")
	private WebElement nav_CommonPopUpOKButtonwithID;
	
	//FeedBack message
	@FindBy(how=How.ID,using="userfeedback")
	private WebElement nav_UsrFeedBack;
	
	//Common Screen mask
	// This object is added by QAA04 - 02/23/16
	@FindBy(how=How.XPATH, using="//div[contains(@id,'messagebox-')][contains(@class,'x-window-default-closable x-border-box')]")
	//@FindBy(how=How.XPATH,using="//div[@Class='x-mask x-border-box']")
	private WebElement nav_CommonPopUpScreenMask;
	
	@FindBy(how=How.XPATH, using="//a[contains(@class,'CreateTicketPopupOK')]//span[contains(@id,'btnInnerEl')]")
	private WebElement nav_CreateTicketPopupOKBtn;
	
	
	@FindAll({
		@FindBy(how=How.ID, using="button-1005-btnInnerEl"),
		@FindBy(how=How.XPATH, using="//span[contains(@id,'-btnInnerEl')][text()='No']")
	})
	private List<WebElement> nav_PopUpYesButton;
	
	@FindAll({
		@FindBy(how=How.ID, using="button-1006-btnInnerEl"),
		@FindBy(how=How.XPATH, using="//span[contains(@id,'-btnInnerEl')][text()='Yes']")
	})
	private List<WebElement> nav_PopUpNoButton;
	
	@FindAll({
		@FindBy(how=How.ID, using="button-1076-btnInnerEl"),
		@FindBy(how=How.XPATH, using="//span[contains(@id,'-btnInnerEl')][text()='Cancel']")
	})
	private List<WebElement> nav_PopUpCancelButton;
	
	
	//Close image(X)
	@FindBy(how=How.ID,using="idCloseButton")
	private WebElement nav_DialogCloseIcon;
	
	//=================================================================
	//=================================================================
	

	public WebElement getNav_CommonPopUp() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CommonPopUp;
	}

	public WebElement getNav_CommonPopUpTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CommonPopUpTitle;
	}

	public WebElement getNav_CommonPopUpMessage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CommonPopUpMessage;
	}

	public WebElement getNav_CommonPopUpOKButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		WebElement webElement = WebObjectUtil.getWebElementFromWebElementList(nav_CommonPopUpOKButton);
		return webElement;
	}
	//*******************************QAA03************************************//
	//Taken from Clark 
	// This object is updated on 10/02/2015 by QAA04
	@FindBy(how=How.XPATH, using="//div[contains(@id,'-toolbar-targetEl')]//span[text()='OK']") 
	//@FindBy(how=How.ID,using="button-1005-btnIconEl")
	private WebElement nav_PopUpOKBtn;
		
	//Error message
	//Changed by Vivek- as a part of EXTJS5
	//@FindBy(how=How.ID,using="messagebox-1001-displayfield-inputEl")
	@FindBy(how=How.ID,using="messagebox-1001")
	private WebElement nav_PopUpMessage;
		
	@FindBy(how=How.XPATH, using = "//div[@id='vm_print']//img[@alt='PDF']")
	private WebElement nav_PdfIcon;
	
	@FindBy(how=How.XPATH, using = "//div[@id='vm_print']//img[@alt='CSV']")
	private WebElement nav_CsvIcon;	
		
	public WebElement getNav_PopUpOKBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	    return nav_PopUpOKBtn;
	}

	public WebElement getNav_PopUpMessage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PopUpMessage;
	}
	
	public WebElement getNav_PdfIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PdfIcon;
	}

	public WebElement getNav_CsvIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CsvIcon;
	}

	public WebElement getNav_UsrFeedBack() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_UsrFeedBack;
	}

	public WebElement getNav_CommonPopUpScreenMask() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CommonPopUpScreenMask;
	}

	public WebElement getNav_CommonPopUpBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CommonPopUpBox;
	}

	public WebElement getNav_ConfirmPopUpOkBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ConfirmPopUpOkBtn;
	}

	public WebElement getNav_CommonPopUpOKButtonwithID() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CommonPopUpOKButtonwithID;
	}

	public WebElement getNav_CreateTicketPopupOKBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateTicketPopupOKBtn;
	}

		
	public WebElement getNav_PopUpNoButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		WebElement webElement = WebObjectUtil.getWebElementFromWebElementList(nav_PopUpNoButton);
		return webElement;
	}
	
	
	public WebElement getNav_PopUpYesButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		WebElement webElement = WebObjectUtil.getWebElementFromWebElementList(nav_PopUpYesButton);
		return webElement;
	}
	public WebElement getNav_PopUpCancelButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		WebElement webElement = WebObjectUtil.getWebElementFromWebElementList(nav_PopUpCancelButton);
		return webElement;
	}

	public WebElement getNav_DialogCloseIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DialogCloseIcon;
	}

	
	
}
