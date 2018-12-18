package com.whs.navigator.pagefactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class DNSPageFactory {
	
	@FindBy(how=How.ID,using="idZoneNameCombo-trigger-picker")
	private WebElement nav_ZoneNameDropdownIcon;
	
	@FindBy(how=How.XPATH,using="//div[Contains(@id,'boundlist-')][Contains(@Class,'floating')]")
	private WebElement nav_ZoneNameDropdownList;
	
	@FindBy(how=How.ID,using="idHostTab-innerCt")
	private WebElement nav_ZoneNameHostTable;

	@FindBy(how=How.ID,using="idAliasTab-innerCt")
	private WebElement nav_ZoneNameAliasTable;
	
	@FindBy(how=How.ID,using="idMailExchangeTab-innerCt")
	private WebElement nav_ZoneNameMailExchangerTable;
	
	@FindBy(how=How.ID,using="idTextTab-innerCt")
	private WebElement nav_ZoneNameMailTextTable;
	
	@FindBy(how=How.ID,using="idSendPolicyTab-innerCt")
	private WebElement nav_ZoneNameMailSenderPolicyTable;
	
	@FindBy(how=How.XPATH, using="//div[@id='idDnsSPGrid']/div[Contains(@id,'headercontainer')]")
	private WebElement nav_SenderPolicyColumnHeader;
	
	@FindBy(how=How.XPATH, using="//div[@id='idDnsTextGrid']/div[Contains(@id,'headercontainer')]")
	private WebElement nav_TextColumnHeader;
	
	@FindBy(how=How.XPATH, using="//div[@id='idDnsMxGrid']/div[Contains(@id,'headercontainer')]")
	private WebElement nav_MailExchangerColumnHeader;
	
	@FindBy(how=How.XPATH, using="//div[@id='idDnsHostGrid']/div[Contains(@id,'headercontainer')]")
	private WebElement nav_HostColumnHeader;
	
	@FindBy(how=How.XPATH, using="//div[@id='idDnsAliasGrid']/div[Contains(@id,'headercontainer')]")
	private WebElement nav_AliasColumnHeader;
	
	@FindBy(how=How.ID, using="idDnsPdfExporter-btnInnerEl")
	private WebElement nav_DNSPdfIcon;
	
	@FindBy(how=How.ID, using="idDnsCvsExporter-btnInnerEl")
	private WebElement nav_DNSCsvIcon;
	
	@FindBy(how=How.XPATH, using="//div[@id='dns_maindiv']/div/div/div/div")
	private WebElement nav_DNSRecordsArea;
	
	@FindBy(how=How.XPATH, using="//div[@id='dns_maindiv']/div/div/div/div/div[Contains(@style,'bottom')]")
	private WebElement nav_DNSNoRecordsNote;
	
	@FindBy(how=How.ID, using="idTabPanel")
	private WebElement nav_DNSTable;
	
	public WebElement getNav_DNSTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNSTable;
	}
	
	public WebElement getNav_DNSNoRecordsNote() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNSNoRecordsNote;
	}
	
	public WebElement getNav_DNSRecordsArea() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNSRecordsArea;
	}
	
	public WebElement getNav_HostColumnHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_HostColumnHeader;
	}
	
	public WebElement getNav_DNSCsvIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNSCsvIcon;
	}
	
	public WebElement getNav_DNSPdfIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNSPdfIcon;
	}
	
	public WebElement getNav_AliasColumnHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AliasColumnHeader;
	}
	
	public WebElement getNav_MailExchangerColumnHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_MailExchangerColumnHeader;
	}
	
	public WebElement getNav_TextColumnHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TextColumnHeader;
	}
	
	public WebElement getNav_SenderPolicyColumnHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SenderPolicyColumnHeader;
	}
	
	public WebElement getNav_DNSAliasTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNSAliasTab;
	}

	public WebElement getNav_DNSMailExchangerTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNSMailExchangerTab;
	}


	public WebElement getNav_DNSTextTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNSTextTab;
	}

	public WebElement getNav_DNSSenderPolicyTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNSSenderPolicyTab;
	}

	

	@FindBy(how=How.XPATH,using="//span[text()='Alias']")
	private WebElement nav_DNSAliasTab;
	
	@FindBy(how=How.XPATH,using="//span[text()='Mail Exchanger']")
	private WebElement nav_DNSMailExchangerTab;
	
	@FindBy(how=How.XPATH,using="//span[text()='Text']")
	private WebElement nav_DNSTextTab;
	
	@FindBy(how=How.XPATH,using="//span[text()='Sender Policy']")
	private WebElement nav_DNSSenderPolicyTab;
	
	@FindBy(how=How.XPATH,using="//span[text()='Host']")
	private WebElement nav_DNSHostTab;
	
	
	public WebElement getNav_DNSHostTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNSHostTab;
	}
	
	public WebElement getNav_ZoneNameHostTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ZoneNameHostTable;
	}

	public WebElement getNav_ZoneNameAliasTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ZoneNameAliasTable;
	}

	public WebElement getNav_ZoneNameMailExchangerTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ZoneNameMailExchangerTable;
	}

	public WebElement getNav_ZoneNameTextTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ZoneNameMailTextTable;
	}

	public WebElement getNav_ZoneNameSenderPolicyTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ZoneNameMailSenderPolicyTable;
	}

	public WebElement getNav_ZoneNameDropdownIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ZoneNameDropdownIcon;
	}
	
	public WebElement getNav_ZoneNameDropdownList() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ZoneNameDropdownList;
	}
	

}
//=========================================================================================================