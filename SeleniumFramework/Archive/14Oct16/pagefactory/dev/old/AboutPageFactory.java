package com.whs.navigator.pagefactory.dev.old;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class AboutPageFactory
{
	//This element updated on 09/21/2015 by QAA03
	//@FindBy(how=How.ID, using ="aui-3-2-0PR1-1997")
	@FindBy(how=How.XPATH, using ="//div[@id='AboutPortletDiv']/div/div")
	private WebElement nav_AboutHeader;
	
	@FindBy(how=How.XPATH, using ="//tr/td[(text()='Release Number')]")
	private WebElement nav_ReleaseNumber;
	
	@FindBy(how=How.XPATH, using ="//td[contains(text(),'Release Number')]/../td[2]")
	private WebElement nav_ReleaseNumberValue;
	
	@FindBy(how=How.XPATH, using ="//tr/td[(text()='Build Number')]")
	private WebElement nav_BuildNumber;
	
	@FindBy(how=How.XPATH, using ="//tr/td[(text()='Build Number')]/../td[2]")
	private WebElement nav_BuildNumberValue;
	
	@FindBy(how=How.XPATH, using ="//tr/td[(text()='Build Date')]")
	private WebElement nav_BuildDate;
	
	@FindBy(how=How.XPATH, using ="//tr/td[(text()='Build Date')]/../td[2]")
	private WebElement nav_BuildDateValue;
	
	@FindBy(how=How.XPATH, using ="//tr/td[(text()='Machine Name')]")
	private WebElement nav_MachineName;

	
	@FindBy(how=How.XPATH, using ="//tr/td[(text()='Machine Name')]/../td[2]")
	private WebElement nav_MachineNameValue;


	public WebElement getNav_AboutHeader() {
		return nav_AboutHeader;
	}


	public WebElement getNav_ReleaseNumber() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ReleaseNumber;
	}


	public WebElement getNav_ReleaseNumberValue() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ReleaseNumberValue;
	}


	public WebElement getNav_BuildNumber() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_BuildNumber;
	}


	public WebElement getNav_BuildNumberValue() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_BuildNumberValue;
	}


	public WebElement getNav_BuildDate() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_BuildDate;
	}


	public WebElement getNav_BuildDateValue() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_BuildDateValue;
	}


	public WebElement getNav_MachineName() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_MachineName;
	}


	public WebElement getNav_MachineNameValue() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_MachineNameValue;
	}


	
	
}
