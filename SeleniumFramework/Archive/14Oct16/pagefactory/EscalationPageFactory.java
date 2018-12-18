package com.whs.navigator.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class EscalationPageFactory {

	/// Critical escalation pdf and csv icons
	    // Updated below four elements by QAA03 on 07/29/2016
		//@FindBy(how=How.XPATH, using="//div[@id='idCelContainer-innerCt']//span[contains(@style,'PDF_Icon.png')]")
	    @FindBy(how=How.XPATH, using="//div[@id='idCELPanel']//div[contains(@id,'targetE')]/img[1]")
	    private WebElement navCriticalEscalationPDFIcon;
		
		//@FindBy(how=How.XPATH, using="//div[@id='idCelContainer-innerCt']//span[contains(@style,'CSV_Icon.png')]")
	    @FindBy(how=How.XPATH, using="//div[@id='idCELPanel']//div[contains(@id,'targetE')]/img[2]")
		private WebElement navCriticalEscalationCSVIcon;

	/// Authorized contact list pdf and csv icons	
		//@FindBy(how=How.XPATH, using="//div[@id='idACLContainer-innerCt']//span[contains(@style,'PDF_Icon.png')]")
	    @FindBy(how=How.XPATH, using="//div[@id='idACLPanel']//div[contains(@id,'targetE')]/img[1]")
		private WebElement navAuthorizedContactList_PDFIcon;
		
		//@FindBy(how=How.XPATH, using="//div[@id='idACLContainer-innerCt']//span[contains(@style,'CSV_Icon.png')]")
	    @FindBy(how=How.XPATH, using="//div[@id='idACLPanel']//div[contains(@id,'targetE')]/img[2]")
		private WebElement navAuthorizedContactList_CSVIcon;
		
		
	/// Deprovisioned UsersList 
		@FindBy(how=How.XPATH, using="//span[text()='Deprovisioned Users List']")
	    private WebElement navDeprovisedUsersLisTab;
		
	//// PDF and CSV icons
		@FindBy(how=How.XPATH, using="//div[@id='idDeproContainer-innerCt']//span[contains(@style,'PDF_Icon.png')]")
		private WebElement navDeprovisedUsersList_PdfIcon;
		
		@FindBy(how=How.XPATH, using="//div[@id='idDeproContainer-innerCt']//span[contains(@style,'CSV_Icon.png')]")
		private WebElement navDeprovisedUsersList_CSVIcon;

		public WebElement getNavCriticalEscalationPDFIcon() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return navCriticalEscalationPDFIcon;
		}

		public WebElement getNavCriticalEscalationCSVIcon() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return navCriticalEscalationCSVIcon;
		}

		public WebElement getNavAuthorizedContactList_PDFIcon() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return navAuthorizedContactList_PDFIcon;
		}

		public WebElement getNavAuthorizedContactList_CSVIcon() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return navAuthorizedContactList_CSVIcon;
		}

		public WebElement getNavDeprovisedUsersLisTab() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return navDeprovisedUsersLisTab;
		}

		public WebElement getNavDeprovisedUsersList_PdfIcon() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return navDeprovisedUsersList_PdfIcon;
		}

		public WebElement getNavDeprovisedUsersList_CSVIcon() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return navDeprovisedUsersList_CSVIcon;
		}


	
    	
}

	


