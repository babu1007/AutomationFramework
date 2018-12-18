package com.whs.navigator.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class CloudServicesPageFactory {

	
	//Page Factory and links under Service Tab 
	@FindBy(how=How.XPATH,using ="//a[contains(text(),'services')]")
	private WebElement nav_ServicesTab;
	
	@FindBy(how=How.LINK_TEXT,using="Cloud Services")
	private WebElement nav_CloudServicesMenuLink;
	
	//@FindBy(how=How.XPATH,using ="//h1[contains(text(),'Cloud Services')]")
	@FindBy(how=How.XPATH,using ="//span[contains(text(),'Cloud Services')]")
	private WebElement nav_CloudServicesTitle;
	
	@FindBy(how=How.ID, using ="vcdInstanceSelectionPopup_header_hd-textEl")
	private WebElement nav_CloudLocationPopupTitle;
	
	@FindBy(how=How.XPATH,using ="//img[contains(@id, '-toolEl')]")
	private WebElement nav_CloudLocationPopupClose;
	
	
	//@FindBy(how=How.LINK_TEXT,using="Lab 3 Private Cloud - 11Giraffes")
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Lab 3 Private Cloud - 11Giraffes') and contains(@id,'component-')]")
	private WebElement nav_Lab3PrivateCloudLink;
	
	//@FindBy(how=How.LINK_TEXT,using="Andover, MA - 11giraffes")
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Andover, MA - 11giraffes') and contains(@id,'component-')]")
	private WebElement nav_Andover_MA_Link;
	
	//@FindBy(how=How.LINK_TEXT,using="Charlotte, NC - 11Giraffes")
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Charlotte, NC - 11Giraffes') and contains(@id,'component-')]")
	private WebElement nav_Charlotte_NC_Link;

	
	
	
	public WebElement getNav_ServicesTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ServicesTab;
	}

	public WebElement getNav_CloudServicesMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CloudServicesMenuLink;
	}

	public WebElement getNav_CloudServicesTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CloudServicesTitle;
	}

	public WebElement getNav_CloudLocationPopupTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CloudLocationPopupTitle;
	}

	public WebElement getNav_CloudLocationPopupClose() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CloudLocationPopupClose;
	}

	public WebElement getNav_Lab3PrivateCloudLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Lab3PrivateCloudLink;
	}

	public WebElement getNav_Andover_MA_Link() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Andover_MA_Link;
	}

	public WebElement getNav_Charlotte_NC_Link() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_Charlotte_NC_Link;
	}
	
	
	
	
	
}
