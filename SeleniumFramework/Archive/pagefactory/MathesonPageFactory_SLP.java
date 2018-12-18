package com.whs.navigator.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class MathesonPageFactory_SLP {
	
	@FindBy(how=How.LINK_TEXT, using="Customer Advocate")
	private WebElement nav_CustomerAdvocateLink;
	
	@FindBy(how=How.XPATH, using="//table[@class='marketing_section_right']//p[1]")
	private WebElement nav_CustomerAdvocateData;

	public WebElement getNav_CustomerAdvocateLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CustomerAdvocateLink;
	}

	public WebElement getNav_CustomerAdvocateData() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CustomerAdvocateData;
	}
	
	

}
