package com.whs.navigator.pagefactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;

public class DNSPageFactory {

	@FindBy(how=How.ID, using="idZoneNameCombo-inputEl")
	private WebElement nav_DNS_ZoneNameEditBox;
	
	@FindBy(how=How.ID, using="idZoneNameCombo-trigger-picker")
	private WebElement nav_DNS_ZoneNameDropdownArrow;
	
	@FindBy(how=How.XPATH, using="//div[@id='idTabPanel']//span[text()='Sender Policy']")
	private WebElement nav_DNS_SenderPolicyTab;
	
	@FindBy(how=How.XPATH, using="//div[@id='idTabPanel']//span[text()='Alias']")
	private WebElement nav_DNS_AliasTab;
	
	@FindBy(how=How.XPATH, using="//div[@id='idTabPanel']//span[text()='Mail Exchanger']")
	private WebElement nav_DNS_MailExchangerTab;

	@FindBy(how=How.XPATH, using="//div[@id='idTabPanel']//span[text()='Text']")
	private WebElement nav_DNS_TextTab;
	
	@FindBy(how=How.XPATH, using="//div[@id='idSendPolicyTab']//span[text()='Name']")
	private WebElement nav_DNS_SenderPolicyNameColumn;
	
	@FindBy(how=How.XPATH, using="//div[@id='idSendPolicyTab']//span[text()='Data']")
	private WebElement nav_DNS_SenderPolicyDataColumn;
	
	@FindBy(how=How.XPATH, using="//div[@id='idSendPolicyTab']//span[text()='TTL(secs)']")
	private WebElement nav_DNS_SenderPolicyTTLColumn;
	
	@FindBy(how=How.ID, using="idDnsSPGrid-body")
	private WebElement nav_DNS_SenderPolicyWebTableParent;
	
	@FindBy(how=How.XPATH, using="//div[@id='idDnsMxGrid']//span[text()='Name']")
	private WebElement nav_DNS_MailExchangerNameColumn;
	
	@FindBy(how=How.XPATH, using="//div[@id='idDnsMxGrid']//span[text()='Data']")
	private WebElement nav_DNS_MailExchangerDataColumn;
	
	@FindBy(how=How.XPATH, using="//div[@id='idDnsMxGrid']//span[text()='TTL(secs)']")
	private WebElement nav_DNS_MailExchangerTTLColumn;
	
	@FindBy(how=How.ID, using="idDnsMxGrid-body")
	private WebElement nav_DNS_MailExchangerWebTableParent;
	
	@FindBy(how=How.XPATH, using="//div[@id='idDnsTextGrid']//span[text()='Name']")
	private WebElement nav_DNS_TextNameColumn;
	
	@FindBy(how=How.XPATH, using="//div[@id='idDnsTextGrid']//span[text()='Data']")
	private WebElement nav_DNS_TextDataColumn;
	
	@FindBy(how=How.XPATH, using="//div[@id='idDnsTextGrid']//span[text()='TTL(secs)']")
	private WebElement nav_DNS_TextTTLColumn;
	
	@FindBy(how=How.ID, using="idDnsTextGrid-body")
	private WebElement nav_DNS_TextWebTableParent;
	
	@FindBy(how=How.XPATH, using="//div[@id='idDnsAliasGrid']//span[text()='Name']")
	private WebElement nav_DNS_AliasNameColumn;
	
	@FindBy(how=How.XPATH, using="//div[@id='idDnsAliasGrid']//span[text()='Data']")
	private WebElement nav_DNS_AliasDataColumn;
	
	@FindBy(how=How.XPATH, using="//div[@id='idDnsAliasGrid']//span[text()='TTL(secs)']")
	private WebElement nav_DNS_AliasTTLColumn;
	
	@FindBy(how=How.ID, using="idDnsAliasGrid-body")
	private WebElement nav_DNS_AliasWebTableParent;
	
	@FindBy(how=How.XPATH, using="//div[@id='idDnsHostGrid']//span[text()='Name']")
    private WebElement nav_DNS_HostNameColumn;
	
	@FindBy(how=How.XPATH, using="//div[@id='idDnsHostGrid']//span[text()='Data']")
	private WebElement nav_DNS_HostDataColumn;
	
	@FindBy(how=How.XPATH, using="//div[@id='idDnsHostGrid']//span[text()='TTL(secs)']")
	private WebElement nav_DNS_HostTTLColumn;
	
	@FindBy(how=How.ID, using="idDnsHostGrid-body")
	private WebElement nav_DNS_HostWebTableParent;

	
	@FindBy(how=How.ID,using="idZoneNameCombo-trigger-picker")
	private WebElement nav_ZoneNameDropdownIcon;
	
	@FindBy(how=How.XPATH,using="//div[Contains(@id,'boundlist-')][Contains(@Class,'floating')]//ul")
	private WebElement nav_ZoneNameDropdownList;
	
	// this element updated by NMR - 07/14/2016
	@FindBy(how=How.ID, using="idDnsHostGrid-body")
	//@FindBy(how=How.ID,using="idHostTab-innerCt")
	private WebElement nav_ZoneNameHostTable;

	// this element updated by NMR - 07/14/2016
		@FindBy(how=How.ID, using="idDnsAliasGrid-body")
	//@FindBy(how=How.ID,using="idAliasTab-innerCt")
	private WebElement nav_ZoneNameAliasTable;
	
	// this element updated by NMR - 07/14/2016
	@FindBy(how=How.ID, using="idDnsMxGrid-body")
	//@FindBy(how=How.ID,using="idMailExchangeTab-innerCt")
	private WebElement nav_ZoneNameMailExchangerTable;
	
	// this element updated by NMR - 07/14/2016
	@FindBy(how=How.ID, using="idDnsTextGrid-body")
	//@FindBy(how=How.ID,using="idTextTab-innerCt")
	private WebElement nav_ZoneNameMailTextTable;
	
	// this element updated by NMR - 07/14/2016
	@FindBy(how=How.ID, using="idDnsSPGrid-body")
	//@FindBy(how=How.ID,using="idSendPolicyTab-innerCt")
	private WebElement nav_ZoneNameMailSenderPolicyTable;
	
	// this element is updated by NMR - 07/18/2016
	@FindBy(how=How.ID, using="headercontainer-1100-innerCt")
	//@FindBy(how=How.XPATH, using="//div[@id='idDnsSPGrid']/div[Contains(@id,'headercontainer')]//span[@class='x-column-header-text']")
	private WebElement nav_SenderPolicyColumnHeader;
	
	// this element is updated by NMR - 07/18/2016
	@FindBy(how=How.ID, using="headercontainer-1081-innerCt")
	//@FindBy(how=How.XPATH, using="//div[@id='idDnsTextGrid']//div[contains(@id,'headercontainer-')][contains(@class,'x-docked-noborder-left')]//span[@class='x-column-header-text']")
	//@FindBy(how=How.XPATH, using="//div[@id='idDnsTextGrid']/div[Contains(@id,'headercontainer')]//span[@class='x-column-header-text']")
	private WebElement nav_TextColumnHeader;
	
	// this element is updated by NMR - 07/18/2016
	@FindBy(how=How.ID, using="headercontainer-1061-innerCt")
	//@FindBy(how=How.XPATH, using="//div[@id='idDnsMxGrid']/div[Contains(@id,'headercontainer')]//span[@class='x-column-header-text']")
	private WebElement nav_MailExchangerColumnHeader;
	
	// this element is updated by NMR - 07/18/2016
	@FindBy(how=How.ID, using="headercontainer-1022-innerCt")
	//@FindBy(how=How.XPATH, using="//div[@id='idDnsHostGrid']/div[Contains(@id,'headercontainer')]//span[@class='x-column-header-text']")
	private WebElement nav_HostColumnHeader;
	
	// this element is updated by NMR - 07/18/2016
	/*@FindAll({
		@FindBy(how=How.ID, using="headercontainer-1041-innerCt"),
		@FindBy(how=How.XPATH, using="//div[@id='idDnsAliasGrid']//div[Contains(@id,'headercontainer')]"),
	@FindBy(how=How.XPATH, using="//div[@id='idDnsAliasGrid']//div[Contains(@id,'headercontainer')][contains(@class,'x-docked-noborder-left')]//span[@class='x-column-header-text']"),
	@FindBy(how=How.XPATH, using="//div[@id='idDnsAliasGrid']/div[Contains(@id,'headercontainer')]/span[@class='x-column-header-text']")
	
	})*/
	@FindBy(how=How.ID, using="headercontainer-1041-innerCt")
	private List<WebElement> nav_AliasColumnHeader;
	
	@FindBy(how=How.ID, using="idDnsPdfExporter-btnInnerEl")
	private WebElement nav_DNSPdfIcon;
	
	@FindBy(how=How.ID, using="idDnsCvsExporter-btnInnerEl")
	private WebElement nav_DNSCsvIcon;
	
	@FindBy(how=How.XPATH, using="//div[@id='dns_maindiv']/div/div/div/div")
	private WebElement nav_DNSRecordsArea;
	
	@FindBy(how=How.XPATH, using="//div[@id='dns_maindiv']/div/div/div/div/div[Contains(@style,'bottom')]")
	private WebElement nav_DNSNoRecordsNote;
	
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
	
	@FindBy(how=How.ID,using="idTabPanel")
	private WebElement nav_DNSTable;
	
	
	public WebElement getNav_DNSTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNSTable;
	}
	
	public WebElement getNav_ZoneNameSenderPolicyTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ZoneNameMailSenderPolicyTable;
	}
	
	
	public WebElement getNav_ZoneNameTextTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ZoneNameMailTextTable;
	}

	public WebElement getNav_DNS_ZoneNameEditBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNS_ZoneNameEditBox;
	}

	public WebElement getNav_DNS_ZoneNameDropdownArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNS_ZoneNameDropdownArrow;
	}

	public WebElement getNav_DNS_SenderPolicyTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNS_SenderPolicyTab;
	}

	public WebElement getNav_DNS_AliasTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNS_AliasTab;
	}

	public WebElement getNav_DNS_MailExchangerTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNS_MailExchangerTab;
	}

	public WebElement getNav_DNS_TextTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNS_TextTab;
	}

	public WebElement getNav_DNS_SenderPolicyNameColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNS_SenderPolicyNameColumn;
	}

	public WebElement getNav_DNS_SenderPolicyDataColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNS_SenderPolicyDataColumn;
	}

	public WebElement getNav_DNS_SenderPolicyTTLColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNS_SenderPolicyTTLColumn;
	}

	public WebElement getNav_DNS_SenderPolicyWebTableParent() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNS_SenderPolicyWebTableParent;
	}

	public WebElement getNav_DNS_MailExchangerNameColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNS_MailExchangerNameColumn;
	}

	public WebElement getNav_DNS_MailExchangerDataColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNS_MailExchangerDataColumn;
	}

	public WebElement getNav_DNS_MailExchangerTTLColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNS_MailExchangerTTLColumn;
	}

	public WebElement getNav_DNS_TextNameColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNS_TextNameColumn;
	}

	public WebElement getNav_DNS_TextDataColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNS_TextDataColumn;
	}

	public WebElement getNav_DNS_TextTTLColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNS_TextTTLColumn;
	}

	public WebElement getNav_DNS_AliasNameColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNS_AliasNameColumn;
	}

	public WebElement getNav_DNS_AliasDataColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNS_AliasDataColumn;
	}

	public WebElement getNav_DNS_AliasTTLColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNS_AliasTTLColumn;
	}

	public WebElement getNav_DNS_HostNameColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNS_HostNameColumn;
	}

	public WebElement getNav_DNS_HostDataColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNS_HostDataColumn;
	}

	public WebElement getNav_DNS_HostTTLColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNS_HostTTLColumn;
	}

	public WebElement getNav_DNS_MailExchangerWebTableParent() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNS_MailExchangerWebTableParent;
	}

	public WebElement getNav_DNS_TextWebTableParent() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNS_TextWebTableParent;
	}

	public WebElement getNav_DNS_AliasWebTableParent() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNS_AliasWebTableParent;
	}

	public WebElement getNav_DNS_HostWebTableParent() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNS_HostWebTableParent;
	}

	

	public WebElement getNav_ZoneNameDropdownIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ZoneNameDropdownIcon;
	}

	public WebElement getNav_ZoneNameDropdownList() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ZoneNameDropdownList;
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

	public WebElement getNav_ZoneNameMailTextTable() { 
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ZoneNameMailTextTable;
	}

	public WebElement getNav_ZoneNameMailSenderPolicyTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ZoneNameMailSenderPolicyTable;
	}

	public WebElement getNav_SenderPolicyColumnHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SenderPolicyColumnHeader;
	}

	public WebElement getNav_TextColumnHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TextColumnHeader;
	}

	public WebElement getNav_MailExchangerColumnHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_MailExchangerColumnHeader;
	}

	public WebElement getNav_HostColumnHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_HostColumnHeader;
	}

	public WebElement getNav_AliasColumnHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		WebElement webElement = WebObjectUtil.getWebElementFromWebElementList(nav_AliasColumnHeader);
		return webElement;
	}

	public WebElement getNav_DNSPdfIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNSPdfIcon;
	}

	public WebElement getNav_DNSCsvIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNSCsvIcon;
	}

	public WebElement getNav_DNSRecordsArea() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNSRecordsArea;
	}

	public WebElement getNav_DNSNoRecordsNote() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNSNoRecordsNote;
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

	public WebElement getNav_DNSHostTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DNSHostTab;
	}
	
	
	
}
