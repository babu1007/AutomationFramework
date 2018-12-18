package com.whs.navigator.pagefactory.dev.old;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class CommonPageFactory {
	
	
	
	//Common PopUp Body
	@FindBy(how=How.ID,using="messagebox-1001")
	private WebElement nav_CommonPopUp;
	
	@FindBy(how=How.ID,using="navpopupbody")
	private WebElement nav_CommonPopUpBox;
	
	
	//Common PopUp Title
	//@FindBy(how=How.ID,using="messagebox-1001_header_hd-textEl")-by Priyanka on 10/06/15
	@FindBy(how=How.ID,using="messagebox-1001_header")
	private WebElement nav_CommonPopUpTitle;
	
	
	//Common Popup Message  Dialog Box
	//@FindBy(how=How.ID, using="messagebox-1001-displayfield-inputEl")-by Priyanka on 10/06/15
	@FindBy(how=How.ID,using="messagebox-1001-body")
	private WebElement nav_CommonPopUpMessage;
	
	//Common PopUp OK Buttom
	//@FindBy(how=How.ID, using="button-1005-btnIconEl")-by Priyanka on 10/06/15
	@FindBy(how=How.ID, using="button-1005-btnEl")
	private WebElement nav_CommonPopUpOKButton;

	@FindBy(how=How.XPATH,using="//div[@id='navpopupbuttons']//a[contains(text(),'Ok')]")
	private WebElement nav_CommonPopUpOkBtn;
	
	//FeedBack message
	@FindBy(how=How.ID,using="userfeedback")
	private WebElement nav_UsrFeedBack;
	
	//Common Screen mask
	@FindBy(how=How.XPATH,using="//div[@Class='x-mask x-border-box']")
	private WebElement nav_CommonPopUpScreenMask;
	
	////////Added by QAA03
	
	@FindBy(how=How.XPATH,using="//div[@id='vm_print']/a[1]/img/..")
	private WebElement nav_PDFLink;
		
	@FindBy(how=How.XPATH,using="//div[@id='vm_print']/a[2]/img/..")
	private WebElement nav_CSVLink;
	
	@FindBy(how=How.ID, using="button-1005-btnInnerEl")
	private WebElement nav_CommonPopUpOKButtonwithID;
	//=================================================================
	//=================================================================
	
	public WebElement getNav_CommonPopUpOKButtonwithID() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CommonPopUpOKButtonwithID;
	}
	
	public WebElement getNav_CommonPopUpScreenMask() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CommonPopUpScreenMask;
	}
	
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
		return nav_CommonPopUpOKButton;
	}
	//*******************************QAA03************************************//
	//Taken from Clark 
	// This object is updated on 10/02/2015 by QAA04
	@FindBy(how=How.XPATH, using="//span[text()='OK']")
	//@FindBy(how=How.XPATH, using="//div[contains(@id,'-toolbar-targetEl')]//span[text()='OK']") 
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

	public WebElement getNav_CommonPopUpBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CommonPopUpBox;
	}

	public WebElement getNav_CommonPopUpOkBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CommonPopUpOkBtn;
	}

	public WebElement getNav_PDFLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PDFLink;
	}

	public WebElement getNav_CSVLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CSVLink;
	}
		
	
	
	//*******************************QAA03************************************//

}
