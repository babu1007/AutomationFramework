package com.whs.navigator.pagefactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class DocumentPageFactory {
	
	//updated as per latest application change by Arul on 5/20/16
	//@FindBy(how=How.XPATH,using ="//*[contains(@id, '_col-1') ]/../..//tr//td//a[1]")
	@FindBy(how=How.XPATH,using ="//table[@class='taglib-search-iterator']//td//a//span[text()='Hosted Solutions Navigator Users Guide - R1.pdf']")
	private WebElement nav_DocumentPDFLink;
	
	//updated as per latest application change by Arul on 5/20/16
	//@FindBy(how=How.XPATH,using ="//*[contains(@id, '_110_INSTANCE_MX4l_gezi') ]")
	@FindBy(how=How.XPATH,using ="//button[contains(@id,'aui')]//span[text()='Download']")
	private WebElement nav_DownloadBtn;
	
	
	//Added as per latest application change by Arul on 5/20/16
	@FindBy(how=How.XPATH,using ="//*[contains(@id, '_110_INSTANCE_MX4l_ctvk') ]")
	private WebElement nav_DownloadLink;
	
	
	@FindBy(how=How.XPATH,using="//input[@type='text' and @readonly='true']")
	private WebElement nav_PDFUrlText;

	@FindBy(how=How.XPATH,using="//a[contains(text(), 'Documents')]")
	private WebElement nav_DocumentLink;
	
	//ID got changed - Vivek - 02242016
	//@FindBy(how=How.ID,using="viewerContainer")
	@FindBy(how=How.ID,using="outerContainer")
	private WebElement PDFcontainer;
	
	@FindBy(how=How.XPATH,using="//body")
	private WebElement PDFcontainer_Chrome;
	
	@FindBy(how=How.XPATH,using="//section/div/h3")
	private WebElement ErrorMsg;
	
	@FindBy(how=How.XPATH,using="//tr[3]/td[1]/a")
	private WebElement PDFVersionHistory;
	
	
	// kyle release 
	@FindBy(how=How.XPATH,using="//section[@class='navigation']//li[8]/a[text()='Add Org Specific Docs']")
	private WebElement Nav_SupportTab_AddOrgSpecificDocsLink;
	
	@FindBy(how=How.ID,using="org-spec-form-div")
	private WebElement Nav_AddOrgSpecificDocs_OrgSpecificDocsTable;
	
	@FindBy(how=How.NAME,using="org")
	private WebElement Nav_AddOrgSpecificDocs_OrganizationEditBox;
	
	@FindBy(how=How.ID,using="org-trigger-picker")
	private WebElement Nav_AddOrgSpecificDocs_OrganizationDropDown;
	
	@FindBy(how=How.ID,using="orgSpecificFileUpload-inputEl")
	private WebElement Nav_AddOrgSpecificDocs_UploadDocumentField;
	
	@FindBy(how=How.ID,using="orgSpecificFileUpload-button")
	private WebElement Nav_AddOrgSpecificDocs_BrowseButton;
	
	@FindBy(how=How.XPATH,using="//a[1]//span[text()='Reset']")
	private WebElement Nav_AddOrgSpecificDocs_ResetButton;
	
	@FindBy(how=How.XPATH,using="//a[2]//span[text()='Submit']")
	private WebElement Nav_AddOrgSpecificDocs_SubmitButton;
		
	@FindBy(how=How.XPATH,using="//div[@class='journal-content-article']/p/img")
	private WebElement Nav_Document_TierPointDocsImg;
	
	@FindBy(how=How.XPATH,using="//table[contains(@data-searchcontainerid,'foldersSearchContainer')]")
	private WebElement Nav_Document_FolderTable;
	
	@FindBy(how=How.XPATH,using="//table[contains(@data-searchcontainerid,'objectsSearchContainer')]")
	private WebElement Nav_Document_ObjectsTable;
	
	@FindBy(how=How.XPATH,using="//div[@class='document-info']")
	private WebElement Nav_Document_SearchDocument;
	
	
	public WebElement getPDFVersionHistory() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return PDFVersionHistory;
	}


	public WebElement getPDFcontainer() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return PDFcontainer;
	}

	
	public WebElement getNav_DocumentLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DocumentLink;
	}

	public WebElement getErrorMsg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return ErrorMsg;
	}


	public WebElement getNav_DocumentPDFLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DocumentPDFLink;
	}

	public WebElement getNav_DownloadBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DownloadBtn;
	}

	public WebElement getNav_PDFUrlText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PDFUrlText;
	}


	public WebElement getPDFcontainer_Chrome() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return PDFcontainer_Chrome;
	}


	public WebElement getNav_DownloadLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DownloadLink;
	}


	public WebElement getNav_SupportTab_AddOrgSpecificDocsLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return Nav_SupportTab_AddOrgSpecificDocsLink;
	}


	public WebElement getNav_AddOrgSpecificDocs_OrgSpecificDocsTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return Nav_AddOrgSpecificDocs_OrgSpecificDocsTable;
	}


	public WebElement getNav_AddOrgSpecificDocs_OrganizationEditBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return Nav_AddOrgSpecificDocs_OrganizationEditBox;
	}


	public WebElement getNav_AddOrgSpecificDocs_OrganizationDropDown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return Nav_AddOrgSpecificDocs_OrganizationDropDown;
	}


	public WebElement getNav_AddOrgSpecificDocs_UploadDocumentField() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return Nav_AddOrgSpecificDocs_UploadDocumentField;
	}


	public WebElement getNav_AddOrgSpecificDocs_BrowseButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return Nav_AddOrgSpecificDocs_BrowseButton;
	}


	public WebElement getNav_AddOrgSpecificDocs_ResetButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return Nav_AddOrgSpecificDocs_ResetButton;
	}


	public WebElement getNav_AddOrgSpecificDocs_SubmitButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return Nav_AddOrgSpecificDocs_SubmitButton;
	}


	public WebElement getNav_Document_TierPointDocsImg() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return Nav_Document_TierPointDocsImg;
	}


	public WebElement getNav_Document_FolderTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return Nav_Document_FolderTable;
	}


	public WebElement getNav_Document_ObjectsTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return Nav_Document_ObjectsTable;
	}


	public WebElement getNav_Document_SearchDocument() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return Nav_Document_SearchDocument;
	}
	
	


	
	
}
