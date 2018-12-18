package com.whs.navigator.pagefactory.dev.old;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class ServicesPageFactory
{
	
	@FindBy(how=How.XPATH, using ="//table[@class='marketing_table_services2']")
	private WebElement nav_ServicesImage;
	
	@FindBy(how=How.XPATH, using ="//table[@class='marketing_table_2']//p[contains(text(),'TierPoint')]")
	private WebElement nav_ServicesTierPointText;

	@FindBy(how=How.XPATH, using ="//table[@class='marketing_table_2']//p[contains(text(),'learn more')]")
	private WebElement nav_ServicesTierPointLearnMoreText;

	
	
	public WebElement getNav_ServicesImage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ServicesImage;
	}

	public WebElement getNav_ServicesTierPointText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ServicesTierPointText;
	}
	public WebElement getNav_ServicesTierPointLearnMoreText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ServicesTierPointLearnMoreText;
	}
	
}
