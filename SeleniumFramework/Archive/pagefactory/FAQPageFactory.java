package com.whs.navigator.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class FAQPageFactory {
	
	@FindBy(how=How.XPATH, using ="//div[@class='marketing_table_faq marketing_header_div']")
	private WebElement nav_FAQPageHeader;

	public WebElement getNav_FAQPageHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FAQPageHeader;
	}

	
}

