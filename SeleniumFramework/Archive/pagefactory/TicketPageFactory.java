package com.whs.navigator.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class TicketPageFactory {

	//Support Tab
	//@FindBy(how=How.XPATH,using="//a[contains(text(),'support')]")-on 10/01/15 by Priyanka
	@FindBy(how=How.XPATH,using="//a[text()='support']")
	private WebElement nav_SupportTabLink;
	
	//Ticket Menu Link
	@FindBy(how=How.LINK_TEXT,using="Tickets")
	private WebElement nav_TicketsMenuLink;
	
	//Create Ticket Link
	@FindBy(how=How.ID,using="idCreateTicketButton-btnInnerEl")
	private WebElement nav_CreateTicketLink;
	
	//This element updated on 10/02/2015 for EXTJS5 by QAA03
	//@FindBy(how=How.XPATH, using="//div[@id='idTicketsGridPanel-body']//table[contains(@id,'gridview-')]")
	@FindBy(how=How.XPATH, using="//div[@id='idTicketsGridPanel-body']")
	private WebElement nav_TicketsWebTableParent;
	
	//Search By dropdown
	@FindBy(how=How.XPATH,using="//div[contains(@id,'boundlist-')][contains(@class,'x-boundlist-list-ct x-unselectable')]/ul[contains(@class,'x-list-plain')]")
	//Updated as 2 nodes are identified with previous one- By Priyanka on 10/9/15
	//@FindBy(how=How.XPATH,using="//div[contains(@id,'boundlist-')][contains(@class,'x-boundlist-list-ct x-unselectable')][@style='overflow: auto; height: 299px;']/ul[contains(@class,'x-list-plain')]")
	private WebElement nav_SearchByDropdown; 
	
	//Search By Dropdown arrow
	@FindBy(how=How.ID,using="idSearchByCombo-inputEl")
	private WebElement nav_SearchByDropDownArrow;
	
	//Search Image/button
	//@FindBy(how=How.XPATH,using="//table[@id='idSearchTextField']/../img[contains(@id,'component-')]")-on 10/01/15 by Priyanka
	@FindBy(how=How.XPATH,using="//div[@id='idSearchTextField']/../img[contains(@id,'component-')]")
	private WebElement nav_SearchByImage;
	
	//Search Edit field
	@FindBy(how=How.ID,using="idSearchTextField-inputEl")
	private WebElement nav_SearchEdit;

   //This Element updated on 10/07/2015 by QAA03 for EXTJS5
   //@FindBy (how=How.ID, using="button-1064-btnIconEl")
   //@FindBy (how=How.ID, using="button-1070-btnIconEl")
	@FindBy (how=How.XPATH, using="//span[contains(@class,'x-tbar-page-last')]")
    private WebElement nav_TicketLastPageIcon;

	/////////////////////////Arul/////////////////////////////////////////////////////////////////////////////
	//tickets
	
	@FindBy(how=How.XPATH, using="//div[@id='idTicketsGridPanel']/div[contains(@id,'headercontainer')]")
	private WebElement nav_TicketsTableHeader;
	
	//Ticket details
	//@FindBy(how=How.XPATH, using="//input[contains(@id,'summary')]")--By Priyanka on 10/9/15
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'dv_summary_text')]")
	private WebElement nav_TicketSummaryEdit;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'severity_combo')]")
	private WebElement nav_TicketSeverityCombo;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'priority_combo')]")
	private WebElement nav_TicketPriorityCombo;
	
	@FindBy(how=How.XPATH, using="//input[contains(@id,'status_combo')]")
	private WebElement nav_TicketStatusCombo;
	
	
	@FindBy(how=How.XPATH, using="//span[contains(@id,'saveUpdate')][text()='Save Updates']")
	private WebElement nav_TicketSaveUpdatesBtn;
	
	
	@FindBy(how=How.XPATH, using="//span[contains(@id,'createNotes')][text()='Create Note']")
	private WebElement nav_TicketCreateNoteLink;
	
	
	@FindBy(how=How.ID,using="idStatusFilterCombo-inputEl")
	 private WebElement nav_TicketOutstandingList; 
	
	@FindBy(how=How.XPATH,using="//div[contains(@id,'boundlist-')][contains(@class,'x-boundlist-list-ct x-unselectable')]/ul[contains(@class,'x-list-plain')]")
	 private WebElement nav_TicketOutstandingDropdown; 
	
	@FindBy(how=How.XPATH,using="//span[contains(@id,'greenbutton-')][text()='Clone']")
	 private WebElement nav_TicketCloneBtn;
	
	@FindBy(how=How.XPATH,using="//span[text()='Browse']")
	 private WebElement nav_TicketBrowseBtn;
	
	//@FindBy(how=How.ID,using="attachmentFileUpload")-on10/01/15 by priyanka
	@FindBy(how=How.ID,using="attachmentFileUpload-inputEl")
	 private WebElement nav_TicketFileUpload;
	
	
	//@FindBy(how=How.ID,using="ttachmentFileUpload-triggerWrap")
	@FindBy(how=How.XPATH,using="/html/body/div[1]/div/div[3]/div/div[1]/div/div[1]/section/div/div/div/div[2]/table/tbody/tr[6]")
	 private WebElement nav_TicketFileUpload1;
	

	@FindBy(how=How.XPATH,using="//span[contains(@id,'button')][text()='OK']")
	 private WebElement nav_TicketFileUploadOkBtn;
	
	
	
	/////////////////////////Arul/////////////////////////////////////////////////////////////////////////////
	/// ____________________ QAA04 ____________________ //
//Taken from Gideon PageFactory 	
	@FindBy(how=How.XPATH, using="//div[@id='content_vCloud']//a[text()='open a ticket']")
	private WebElement nav_OpenTicketLink;
	
	@FindBy(how=How.XPATH, using="//div[@id='CreateTicketPopup']//span[text()='OK']")
	private WebElement nav_OkBtnInTicketPage;
	
	@FindBy(how=How.XPATH, using="//span[text()='OK']")
	private WebElement nav_CreatingTicketOkBtn;
	
	

	@FindBy(how=How.XPATH, using="//a[@class='x-btn tktDetailsPrintButton x-unselectable x-btn-default-small']")
	private WebElement nav_TicketsPrintIcon;

	@FindBy(how=How.XPATH, using="//div[@id='tp_ticket_summary']/div[contains(@style,'margin-bottom:')]")
	private WebElement nav_TktsPrintIcon_Summary;

	@FindBy(how=How.ID, using="tp_notes_summary")
	private WebElement nav_TktsPrintIcon_Notes;

	@FindBy(how=How.XPATH, using="//div[@id='idTicketsGridPanel-body']//tr[1]//table[@class='x-gridview-1022-table x-grid-table']/tbody/tr[1]/td[2]/div")
	private WebElement nav_FirstTicketId;

	@FindBy(how=How.XPATH,using="//tr[@class='x-grid-rowbody-tr']/td")
	private WebElement nav_TicketExpandTable;

	@FindBy(how=How.XPATH, using = "//input[@value='Private Cloud Firewall']")
	private WebElement nav_SummaryEditField;

/// Taken from Clark test cases	
	@FindBy(how=How.XPATH, using="//ul/li[text()='Ticket ID']")
	private WebElement nav_ClarkSearchByTicketID;
	
	// this object is updated on 10/06/2015 by QAA04
	@FindBy(how=How.ID, using="idOrgCombo-trigger-picker")
//	@FindBy(how=How.XPATH, using="//td[@id='idOrgCombo-inputCell']/../td[contains(@id,'ext-gen')]/div[contains(@id,'ext-gen')]")
	private WebElement nav_ClarkOrgComboSearch;
	
	@FindBy(how=How.XPATH, using="//ul/li[text()='.Hosted Solutions']")
	private WebElement nav_ClarkHostedsolorg;
	
	@FindBy(how=How.XPATH, using="//ul/li[text()='Advanced (All)']")
	private WebElement nav_ClarkSearchByAdv;
	
	@FindBy(how=How.XPATH, using="//span[text()='Date']")
	private WebElement nav_ClarkTktlogDateColumn;
	
	@FindBy(how=How.XPATH, using="//span[text()='Memo']")
	private WebElement nav_ClarkTktlogMemoColumn;
	
	@FindBy(how=How.XPATH, using="//span[text()='Billed Minutes']")
	private WebElement nav_ClarkBilledMinutesColumn;
	
	@FindBy(how=How.XPATH, using="//span[text()='Service Number']")
	private WebElement nav_ClarkSrvcNumColumn;
	
	@FindBy(how=How.XPATH, using="//span[text()='Service Description']")
	private WebElement nav_ClarkSrvcDescColumn;
	
	@FindBy(how=How.XPATH, using="//span[text()='User']")
	private WebElement nav_ClarkSrvcUserColumn;
	
	 //// this object is updated as part of EXTJS5 on 10/07/2015 by QAA04
 	@FindBy(how=How.XPATH, using="//div[contains(@id,'dv_status_combo-')]//div[contains(@id,'-trigger-picker')]")
	//@FindBy(how=How.ID, using="dv_status_combo-471446-inputCell")
	private WebElement nav_ClarkTktStatus;
 	
 	
 	 //// this object is updated as part of EXTJS5 on 10/08/2015 by QAA04
	@FindBy(how=How.XPATH, using="//ul[contains(@id,'-listEl')]")
	private WebElement nav_ClarkTckDetailStatusDropdown;
	
////this object is updated as part of EXTJS5 on 10/07/2015 by QAA04
 	@FindBy(how=How.XPATH, using="//span[text()='OK']")
	//@FindBy(how=How.XPATH, using="//div[Contains(@id,'toolbar-targetEl')]/a/span/span/span[text()='OK']")
	private WebElement nav_ClarkSaveTktOkBtn;
	
 	@FindBy(how=How.ID, using="organization")
	private WebElement nav_ClarkTktOrgHeader;
 	
 	@FindBy(how=How.XPATH, using="//div[text()='Successfully created the ticket']")
	private WebElement nav_ClarkCreateTktPopup;
	
	//updated as part of EXTJS5 on 10-9-2015 by Arul
	//@FindBy(how=How.XPATH, using="//Span[text()='OK']")
	@FindBy(how=How.ID, using="button-1005-btnEl")
	private WebElement  nav_ClarkCreateTktPopupOkBtn;
	
	// this object is updated by QAA04 on 10/06/2015
	@FindBy(how=How.XPATH, using = "//div[@id='idTicketsGridPanel-body']/div/div/table[1]/tbody/tr[1]/td[1]//div[@class='x-grid-row-expander']")
	//@FindBy(how=How.XPATH, using = "//tr[1]/td//tr[contains(@id,'-record-')]//div[@class='x-grid-row-expander']")
	//@FindBy(how=How.XPATH, using = "//tr[contains(@class,'x-grid-data-row')]//div[@class='x-grid-cell-inner x-grid-cell-inner-row-expander']/div[contains(@id,'ext-gen')]")
	private WebElement nav_FirstTicketExpander;
			
	//@FindBy(how=How.ID, using = "notesHtmlEditor-inputCmp")
	@FindBy(how=How.ID, using = "notesHtmlEditor-inputCmp-iframeEl")
	private WebElement nav_CreateNoteEditBox;
	
	// this element is added by NMR - 04/19/2016
	@FindBy(how=How.ID, using="noteHtmlEditor-inputCmp-iframeEl")
	private WebElement nav_CreateTicket_AddNoteEditBox;
	
	
	@FindBy(how=How.XPATH, using = "//div[contains(@id,'toolbar-')]//span[contains(text(),'OK')]")
	private WebElement nav_CreateNoteOkBtn;
	
	// this object is updated on 10/06/15 By QAA04
	@FindBy(how=How.XPATH, using="//div[contains(@id,'expandAllNotes-')]//input[contains(@id,'expandAllNotes-')]")
	//@FindBy(how=How.XPATH, using = "//td[contains(@id,'expandAllNotes-')]//input[contains(@id,'expandAllNotes-')]")
	private WebElement nav_ExpandAllCheckBox;
		
	@FindBy(how=How.ID, using = "idStatusFilterCombo-inputEl")
	private WebElement nav_FirstSearchDropDownBox;
	
	@FindBy(how=How.XPATH, using = "//div[contains(@id,'boundlist-')]/ul")
	private WebElement nav_FirstSearchDropDownOption;
	
	@FindBy(how=How.XPATH, using = "//div[contains(@id,'tktLogsGrid-')]//table")
	private WebElement nav_TicketLogsTable;
				
	/// ____________________ QAA04 ____________________ //
	
	@FindBy(how=How.NAME, using = "inputItem")
	private WebElement nav_PaginationTicketTableCurrentPageIndex;
	
	@FindBy(how=How.XPATH, using = "//div[contains(@id,'tbtext')][contains(text(),'of')]")
	private WebElement nav_PaginationTicketTableTotalPageIndex;
	
	@FindBy(how=How.XPATH, using = "//span[contains(@class,'page-next')]")
	private WebElement nav_PaginationTicketTableNextBtn;
	
	
	
	//######################################################################
	//######################################################################
	
	

	public WebElement getNav_SupportTabLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SupportTabLink;
	}

	public WebElement getNav_TicketsMenuLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketsMenuLink;
	}

	public WebElement getNav_CreateTicketLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateTicketLink;
	}
    // The below element name changed on 10/02/2015 by QAA03 for EXTJS5
	public WebElement getNav_TicketsWebTableParent() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketsWebTableParent;
	}

	public WebElement getNav_SearchByDropdown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SearchByDropdown;
	}

	public WebElement getNav_SearchByDropDownArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SearchByDropDownArrow;
	}

	public WebElement getNav_SearchByImage() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SearchByImage;
	}

	public WebElement getNav_SearchEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SearchEdit;
	}
	
	

	public WebElement getNav_TicketsTableHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketsTableHeader;
	}



	public WebElement getNav_TicketSummaryEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketSummaryEdit;
	}
	
	
	
	public WebElement getNav_TicketSeverityCombo() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketSeverityCombo;
	}

	public WebElement getNav_TicketPriorityCombo() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketPriorityCombo;
	}

	public WebElement getNav_TicketStatusCombo() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketStatusCombo;
	}

	public WebElement getNav_TicketSaveUpdatesBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketSaveUpdatesBtn;
	}

	public WebElement getNav_TicketCreateNoteLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketCreateNoteLink;
	}

	public WebElement getNav_TicketOutstandingList() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketOutstandingList;
	}

	public WebElement getNav_TicketOutstandingDropdown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketOutstandingDropdown;
	}

	public WebElement getNav_TicketCloneBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketCloneBtn;
	}

	public WebElement getNav_TicketBrowseBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketBrowseBtn;
	}

	public WebElement getNav_TicketFileUpload() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketFileUpload;
	}

	public WebElement getNav_TicketFileUpload1() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketFileUpload1;
	}

	public WebElement getNav_TicketFileUploadOkBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketFileUploadOkBtn;
	}

	public WebElement getNav_CreateTicket_AddNoteEditBox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateTicket_AddNoteEditBox;
	}
	
	
	
////###############################VIVEK#####################################################################

	//Notes WebTable
	//@FindBy(how=How.XPATH,using="//div[contains(@id,'idTicketsGridPanel-body')]/div/table[contains(@id,'gridview-')]")
	//@FindBy(how=How.XPATH,using="//table[1]/tbody/tr/td/div/section[2]/div[2]/div[3]/div/div[2]")
	@FindBy(how=How.XPATH,using="//div[Contains(@id,'notesGrid')][Contains(@id,'body')]")
	//@FindBy(how=How.XPATH,using="//table[1]/tbody/tr[2]/td/div/section[3]/div[2]/div[3]/div/div[2]/div[1]/div")
	private WebElement nav_NotesWebTable;
	
	//Expand All Notes
	//@FindBy(how=How.XPATH,using="//input[contains(@id,'expandAllNotes-')]")
	@FindBy(how=How.XPATH,using="table[1]/tbody/tr[2]/td/div/section[2]/div[1]/a/img")
	private WebElement nav_ExpandAllNotes;
	
	//Reset Button
	@FindBy(how=How.ID,using="idTGPResetButton-btnInnerEl")
	private WebElement nav_ResetButton;
	
	//Organization Link
	@FindBy(how=How.XPATH,using="//li[@id='organization']/nobr")
	private WebElement nav_OrganizationLink;
	
	//Organization dropdown arrow
	//@FindBy(how=How.XPATH,using="//td[@id='idOrgCombo-inputCell']/../td[contains(@id,'ext-gen')]/div[contains(@id,'ext-gen')]")
	@FindBy(how=How.ID,using="idOrgCombo-trigger-picker")
	private WebElement nav_OrganizationDropdownArrow;

	
	//First row from Webtable for organization column
	//@FindBy(how=How.XPATH,using="//table/tbody/tr[1]/td/table/tbody/tr[1]/td[4]/div")
	@FindBy(how=How.XPATH,using="//div[3]/div[1]/div/table[1]/tbody/tr[1]/td[4]/div")
	private WebElement nav_FirstRowWebTableOrganizationColumn;
	
	
	//Organization Tab @ webtable
	@FindBy(how=How.XPATH,using="//span[contains(@id,'gridcolumn')][text()='Organization']")
	private WebElement nav_WebTableOrganizationTab;
	
	//######################################################################
	//######################################################################
	



	public WebElement getNav_NotesWebTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NotesWebTable;
	}

	public WebElement getNav_ResetButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ResetButton;
	}

	public WebElement getNav_OrganizationLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_OrganizationLink;
	}

	public WebElement getNav_OrganizationDropdownArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_OrganizationDropdownArrow;
	}

	public WebElement getNav_FirstRowWebTableOrganizationColumn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FirstRowWebTableOrganizationColumn;
	}

	public WebElement getNav_WebTableOrganizationTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_WebTableOrganizationTab;
	}

	public WebElement getNav_ExpandAllNotes() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ExpandAllNotes;
	}
	

////###############################VIVEK#####################################################################
	
////??????????????????????????????????SUKUR?????????????????????????????????????????????????????????????????????
	
	
	//@FindBy(how=How.ID, using="messagebox-1001")
	@FindBy(how=How.ID, using="messagebox-1001-targetEl")
	private WebElement nav_ConfirmPopup;
	
	//@FindBy(how=How.ID, using="button-1005-btnIconEl")
	@FindBy(how=How.ID, using="button-1005-btnInnerEl")
	private WebElement nav_ConfirmPopupOkBtn;
	
	@FindBy(how=How.XPATH,  using="//section[@id='tickets']/div/h2/a[text()='tickets']")
	private WebElement nav_TicketPortalLink;
	
	//@FindBy(how=How.ID, using="organizationCombo-inputEl")
	@FindBy(how=How.ID, using="idOrgCombo-inputEl")
	private WebElement nav_TicketOrgWebList;

	// this element added by NMR -0 1/5/16
	@FindBy(how=How.ID, using="idOrgCombo-trigger-picker")
	private WebElement nav_TicketOrgWebListArrow;
	
	// this element added by NMR -0 1/5/16
	@FindBy(how=How.XPATH,  using="//ul[contains(@id,'boundlist-')][contains(@id,'-listEl')]")
	private WebElement nav_TicketOrgWebListDropDown;
	
	// this element added by NMR 04/19/2016
	@FindBy(how=How.XPATH, using="//span[@class='x-column-header-text']/img")
	private WebElement nav_NotesWebTable_DateUpwardPointingArrowIcon;
	
	//@FindBy(how=How.ID, using="CRT.Date_id-inputEl")
	@FindBy(how=How.ID, using="date_id-inputEl")
	//@FindBy(how=How.ID, using="ext-element-52")
	private WebElement nav_DateEdit;
	
	//@FindBy(how=How.ID, using="CRT.Organization_id-inputEl")
	@FindBy(how=How.ID, using="organization_id-inputEl")
	private WebElement nav_OrganizationEdit;
	
	//@FindBy(how=How.ID, using="CRT.Summary_id-inputEl")
	@FindBy(how=How.ID, using="summary_id-inputEl")
	private WebElement nav_SummaryEdit;
	
	@FindBy(how=How.ID, using="severity_combo-inputEl")
	private WebElement nav_SeverityEdit;

	@FindBy(how=How.ID, using="priority_combo-inputEl")
	private WebElement nav_PriorityEdit;

	@FindBy(how=How.ID, using="category_combo-inputEl")
	private WebElement nav_CategoryEdit;
	
	@FindBy(how=How.XPATH,  using="//span[contains(text(),'OK')]")
	private WebElement nav_CreateTicketOKButton;
	
	@FindBy(how=How.XPATH,  using="//span[contains(text(),'Cancel')]")
	private WebElement nav_CreateTicketCancelButton;

	
	@FindBy(how=How.ID, using="organization")
	private WebElement nav_OrganizationNameText;
	
	@FindBy(how=How.XPATH,  using="//input[contains(@id,'expandAllNotes-')]")
	private WebElement nav_ExpandAllNoteCheckbox;

	 
	 @FindBy(how=How.ID,using="noteHtmlEditor-inputCmp-iframeEl")
	 private WebElement nav_NotesFrame;
	 
	 @FindBy(how=How.ID,using="notesHtmlEditor-inputCmp-iframeEl")
	 private WebElement nav_CreateNotesFrame;
	 
	 @FindBy(how=How.XPATH,  using="//div[contains(@id,'createNoteBtn')]//span[text()='Create Note']")
	private WebElement nav_CreateNoteLink;
	
	 @FindBy(how=How.XPATH,  using="//span[text()='OK']")
	private WebElement nav_CreateNoteOKButton;
	
	 // this element is added by NMR 04/19/2016
	 @FindBy(how=How.XPATH, using="//div[Contains(@id,'messagebox-')]//span[text()='OK']")
	 private WebElement nav_CreateTicketConfirmOkBtn;
	 
	 @FindBy(how=How.XPATH,  using="//input[@id='cloakChkBox-inputEl']")
	private WebElement nav_CreateNoteCloakCheckbox;
	
     //@FindBy(how=How.XPATH, using="//table//tr/td/table//tr//input[contains(@id,'dv_status_combo')]")
	 @FindBy(how=How.ID, using="idStatusFilterCombo-trigger-picker")
     private WebElement nav_TicketStatusDropdown;
   
     @FindBy(how=How.XPATH, using="//div[@class='x-boundlist-list-ct x-unselectable']//ul[@class='x-list-plain']")
     private WebElement nav_TicketStatusList;
  
     @FindBy(how=How.XPATH, using=" //div[contains(@id,'saveCancelBtnDiv')]//span[text()='Save Updates']")
     private WebElement nav_TicketSaveUpdatesButton;
     
     @FindBy(how=How.XPATH, using="//div[Contains(@id,'headercontainer')]/div/div/span/span/span/img")
     private WebElement nav_TicketNoteDefaultSortCheck;
     
     @FindBy(how=How.ID, using="notesText")
     private WebElement nav_TicketNotesText;
     
     public WebElement getNav_TicketNotesText(){
    	 FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
 		return nav_TicketNotesText;
     }
     
    public WebElement getNav_TicketNoteDefaultSortCheck(){
    	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketNoteDefaultSortCheck;	
    }
 

	public WebElement getNav_TicketPortalLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketPortalLink;
	}

	public WebElement getNav_TicketOrgWebList() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketOrgWebList;
	}



	public WebElement getNav_DateEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DateEdit;
	}

	public WebElement getNav_OrganizationEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_OrganizationEdit;
	}

	public WebElement getNav_SummaryEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SummaryEdit;
	}

	public WebElement getNav_SeverityEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SeverityEdit;
	}

	public WebElement getNav_PriorityEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PriorityEdit;
	}

	public WebElement getNav_CategoryEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CategoryEdit;
	}

	public WebElement getNav_CreateTicketOKButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateTicketOKButton;
	}

	public WebElement getNav_CreateTicketCancelButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateTicketCancelButton;
	}
	
	
	public WebElement getNav_ConfirmPopupOkBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ConfirmPopupOkBtn;
	}
	
	public WebElement getNav_ConfirmPopup() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ConfirmPopup;
	}
	public WebElement getNav_OrganizationNameText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_OrganizationNameText;
	}


	public WebElement getNav_NotesFrame() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NotesFrame;
	}
	public WebElement getNav_ExpandAllNoteCheckbox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ExpandAllNoteCheckbox;
	}
	public WebElement getNav_CreateNoteLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateNoteLink;
	}
	
	public WebElement getNav_CreateNoteOKButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateNoteOKButton;
	}
	public WebElement getNav_CreateNoteCloakCheckbox() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateNoteCloakCheckbox;
	}
	public WebElement getNav_CreateNotesFrame() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateNotesFrame;
	}
	
	public WebElement getNav_TicketStatusDropdown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketStatusDropdown;
	}

	public WebElement getNav_TicketStatusList() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketStatusList;
	}

	public WebElement getNav_TicketSaveUpdatesButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_TicketSaveUpdatesButton;
	}

	public WebElement getNav_CreateNoteOk() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateNoteOk;
	}

	
	public WebElement getNav_CreateTicketConfirmOkBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateTicketConfirmOkBtn;
	}
	
	
////??????????????????????????????????SUKUR?????????????????????????????????????????????????????????????????????
	
	


		////$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$PRIYANKA$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	
	



		//Ticket WebTable
	//	@FindBy(how=How.XPATH, using="//div[@id='idTicketsGridPanel-body']//table[contains(@id,'gridview-')]")
		@FindBy(how=How.ID, using="idTicketsGridPanel-body")
			private WebElement nav_TicketsWebTable;
		
	//Create Ticket Dialog box
		@FindBy(how=How.ID, using="ticket_create_details")
		private WebElement nav_CreateTicketDialog;
	//Create Ticket Text on DialogBox
		@FindBy(how=How.ID, using="crt_header_text")
		private WebElement nav_CreateTicketDialogHeaderText;
	//Create Ticket Dialog Date Input Field
		//@FindBy(how=How.ID, using="CRT.Date_id-inputEl")
		@FindBy(how=How.ID, using="date_id-inputEl")
		private WebElement nav_CreateTicketDialogDate;
		
	//Create Ticket Dialog Organization Input Field
		//@FindBy(how=How.ID, using="CRT.Organization_id-inputEl")
		@FindBy(how=How.ID, using="organization_id-inputEl")
		//@FindBy(how=How.ID, using="organization_id-bodyEl")
		private WebElement nav_CreateTicketDialogOrganization;
	
		//This element updated on 10/01/2015 for EXTJS5 by QAA03
		//Create Ticket Dialog Summary Input Field
		//@FindBy(how=How.ID, using="CRT.Summary_id-inputEl")
		@FindBy(how=How.ID, using="summary_id-inputEl")
		private WebElement nav_CreateTicketDialogSummary;
		
	//Create Ticket Dialog Severity Dropdown
		@FindBy(how=How.ID, using="severity_combo-inputEl")
		private WebElement nav_CreateTicketDialogSeverity;
		//This element updated on 10/08/2015 for EXTJS5 by QAA04
		@FindBy(how=How.XPATH, using="//ul[contains(@id,'-listEl')]")
		private WebElement nav_CreateTicketDialogSeverityDropDown;
		
		//Create Ticket Dialog Priority Dropdown
		@FindBy(how=How.ID, using="priority_combo-inputEl")
		private WebElement nav_CreateTicketDialogPriority;
		
		//This element updated on 10/08/2015 for EXTJS5 by QAA04 -- we need to change the Xpath
		//@FindBy(how=How.XPATH,using="//div[9]//ul[contains(@id,'-listEl')]")
		@FindBy(how=How.XPATH,using="//div[contains(@class,'x-boundlist-list-ct x-unselectable')]")
		private WebElement nav_CreateTicketDialogPriorityDropDown;
		//Create Ticket Dialog Category Dropdown
		@FindBy(how=How.ID, using="category_combo-inputEl")
		private WebElement nav_CreateTicketDialogCategory;
	
		//This element updated on 10/08/2015 for EXTJS5 by QAA04
		@FindBy(how=How.XPATH,using="//div[contains(@class,'x-border-box x-boundlist-above')]//ul[@class='x-list-plain']")
		private WebElement nav_CreateTicketDialogCategoryDropDown;
		
		//Create Ticket Dialog Add Note Text Area
		@FindBy(how=How.ID, using="noteHtmlEditor-inputCmp-iframeEl")
		private WebElement nav_CreateTicketDialogAddNote;
	//Create Ticket Dialog Attachment Field
		@FindBy(how=How.ID, using="attachmentFileUpload-button-fileInputEl")
		private WebElement nav_CreateTicketDialogAttachment;
	
		
	//Create Ticket Dialog OK button
		@FindBy(how=How.XPATH, using="//span[text()='OK']")
		private WebElement nav_CreateTicketDialogOkButton;
		
	//Create Ticket Dialog Cancel button
		//@FindBy(how=How.ID, using="button-1090-btnInnerEl")
		@FindBy(how=How.ID, using="//span[text()='Cancel']")
		private WebElement nav_CreateTicketDialogCancelButton;
		
	//This Element updated on 10/01/2015 for EXTJS5 by QAA03(Newly created)
		
		//@FindBy(how=How.XPATH, using="*//td/div[text()='Successfully created the ticket']")
		@FindBy(how=How.ID, using="messagebox-1001-targetEl")
		private WebElement nav_CreateTicketNotification;
		
		@FindBy(how=How.ID, using="button-1005-btnInnerEl")
		private WebElement nav_CreateTicketNotificationOkButton;

	//@FindBy(how=How.LINK_TEXT, using="tickets")
			@FindBy(how=How.XPATH, using="*//section[@id='tickets']//h2/a[text()='tickets']")
			private WebElement nav_TicketsLink;
    // Home page User Name 
			@FindBy(how=How.XPATH, using="*//li[@id='user']//nobr")
			private WebElement nav_UserNameLink;
	// Detailed Ticketing System Link
			@FindBy(how=How.XPATH, using="*//a[text()='Detailed Ticketing System']")
			private WebElement nav_DetailedTicketingSystem;
	// Refresh Details Link
			@FindBy(how=How.XPATH, using="*//span[text()='Refresh Details']")
			private WebElement nav_RefreshDetailsLink;
	//CSV Icon Tickets page
			@FindBy(how=How.XPATH, using="*//img[@src='/ticketing-portlet/resources/images/PDF_Icon.png']")
			private WebElement nav_TicketsPdfIcon;
    //PDF Icon Tickets page
			@FindBy(how=How.XPATH, using="*//img[@src='/ticketing-portlet/resources/images/CSV_Icon.png']")
			private WebElement nav_TicketsCsvIcon;
	//Open Ticket Numbers
			@FindBy(how=How.XPATH, using="*//div[@id='idSpStatusPanel-targetEl']//div[text()='Open']/../div[@class='ticket_text1']")
			private WebElement nav_OpenTicketNumbers;
	//Working Ticket Numbers
			@FindBy(how=How.XPATH, using="*//div[@id='idSpStatusPanel-targetEl']//div[text()='Working']/../div[@class='ticket_text1']")
			private WebElement nav_WorkingTicketNumbers;
	//Pending Ticket Numbers
			@FindBy(how=How.XPATH, using="*//div[@id='idSpStatusPanel-targetEl']//div[text()='Pending']/../div[@class='ticket_text1']")
			private WebElement nav_PendingTicketNumbers;
	//Resolved Ticket Numbers
			@FindBy(how=How.XPATH, using="*//div[@id='idSpStatusPanel-targetEl']//div[text()='Resolved']/../div[@class='ticket_text1']")
			private WebElement nav_ResolvedTicketNumbers;
	//Create Ticket Error Message
			@FindBy(how=How.XPATH, using="*//div[text()='Please enter values for all required fields']")
			private WebElement nav_CreateTicketDialogErrMsg;
	//Create Ticket Close Error Message
			@FindBy(how=How.XPATH, using="*//img[@class='x-tool-img x-tool-close']")
			private WebElement nav_CreateTicketDialogCloseErrMsg;
	//Create Ticket Close button
			//@FindBy(how=How.XPATH, using="*//button[@class='close_icon']")
			@FindBy(how=How.XPATH, using="*//div[@id='ticket_create_details']/button[@class='close_icon']")
			private WebElement nav_CreateTicketCloseButton;
	//Create Note 
            @FindBy(how=How.XPATH,using="//iframe[@id='notesHtmlEditor-inputCmp-iframeEl']")
            private WebElement nav_CreateNote;
	//Create Note OK button
			@FindBy(how=How.XPATH, using="//span[text()='OK']")
			private WebElement nav_CreateNoteOk;
	//Create Note OK Error
			@FindBy(how=How.XPATH, using="*//div[text()='Please enter notes before submitting.']")
			private WebElement nav_CreateNoteOkError;
	//Create Note Error Close
			//@FindBy(how=How.XPATH, using="*//span[@id='button-1102-btnInnerEl']")
			@FindBy(how=How.XPATH, using="*//span[@id='button-1005-btnIconEl']")
			private WebElement nav_CreateNoteErrorClose;
			
	//PopUp OK Btn
			//@FindBy(how=How.ID,using="button-1005-btnIconEl")-by Priyanka on 10/8/15
			@FindBy(how=How.ID,using="button-1005-btnInnerEl")
			private WebElement nav_PopUpOKBtn;
	//Create Note Close
			//@FindBy(how=How.XPATH, using="*//button[@Class='close_icon']")
			@FindBy(how=How.XPATH, using="*//div[@id='note_create_details']/button")
			private WebElement nav_CreateNoteClose;
			
	//Ticket Page Fields
			//@FindBy(how=How.XPATH, using="*//a[text()='Tickets']") //Tickets tab on top left side of the page
			@FindBy(how=How.XPATH, using="//li[@Class='last']/span/a")
			private WebElement nav_TicketsTab;
			  //// this object is updated as part of EXTJS5 on 10/12/2015 by QAA04
            @FindBy(how=How.XPATH, using="*//div[@id='idSpStatusPanel-targetEl']//div[text()='Open']/..//div[@class='ticket_text1']")
			//@FindBy(how=How.XPATH, using="*//div[@id='idSpStatusPanel-targetEl']//div[text()='Open']/..")
            private WebElement nav_OpenTickets;
            //// this object is updated as part of EXTJS5 on 10/12/2015 by QAA04
            @FindBy(how=How.XPATH, using="*//div[@id='idSpStatusPanel-targetEl']//div[text()='Working']/..//div[@class='ticket_text1']")
            //@FindBy(how=How.XPATH, using="*//div[@id='idSpStatusPanel-targetEl']//div[text()='Working']/..")
            private WebElement nav_WorkingTickets;
           //// this object is updated as part of EXTJS5 on 10/12/2015 by QAA04
            @FindBy(how=How.XPATH, using="*//div[@id='idSpStatusPanel-targetEl']//div[text()='Pending']/..//div[@class='ticket_text1']")
            //@FindBy(how=How.XPATH, using="*//div[@id='idSpStatusPanel-targetEl']//div[text()='Pending']/..")
            private WebElement nav_PendingTickets;
            //// this object is updated as part of EXTJS5 on 10/12/2015 by QAA04
            @FindBy(how=How.XPATH, using="*//div[@id='idSpStatusPanel-targetEl']//div[text()='Resolved']/..//div[@class='ticket_text1']")
            //@FindBy(how=How.XPATH, using="*//div[@id='idSpStatusPanel-targetEl']//div[text()='Resolved']/..")
            private WebElement nav_ResolvedTickets;
            //@FindBy(how=How.ID, using="idStatusFilterCombo-inputEl")
            @FindBy(how=How.ID, using="idStatusFilterCombo-trigger-picker")
            private WebElement nav_FilterByStatusDropdown;
            @FindBy(how=How.XPATH, using="*//li[text()='Outstanding']")
            private WebElement nav_Outstanding;
            @FindBy(how=How.XPATH, using="*//li[text()='Closed (Less than 6 months)']")
            private WebElement nav_ClosedLess;
            @FindBy(how=How.XPATH, using="*//li[text()='Closed (More than 6 months)']")
            private WebElement nav_ClosedMore;
            
            @FindBy(how=How.ID, using="idSearchTextField-inputEl")
            private WebElement nav_SearchTextField;
            
            @FindBy(how=How.XPATH, using="*//img[@src='/ticketing-portlet/resources/images/Search_Icon2.png']")
            private WebElement nav_SearchIcon;

            //@FindBy(how=How.XPATH, using="*//ul/li[text()='Ticket ID']")
            @FindBy(how=How.XPATH, using="*//div[2]/div/span/span/span")
            private WebElement nav_TicketID;
            @FindBy(how=How.XPATH, using="*//span[text()='Summary']")
            private WebElement nav_Summary;
            @FindBy(how=How.XPATH, using="*//span[text()='Severity']")
            private WebElement nav_Severity;
            @FindBy(how=How.XPATH, using="*//span[text()='Priority']")
            private WebElement nav_Priority;
            @FindBy(how=How.XPATH, using="*//span[text()='Last update date']")
            private WebElement nav_LastUpdateDate;
            @FindBy(how=How.XPATH, using="*//span[text()='Assigned to']")
            private WebElement nav_AssignedTo;
            @FindBy (how=How.XPATH, using="*//span[text()='Status']")
            private WebElement nav_Status;
           
            //// This object is updated By QAA04
            @FindBy(how=How.XPATH, using="//div[@id='idTicketsGridPanel-body']//table[1]//div[text()='Closed']")
           // @FindBy (how=How.XPATH, using="*//div[text()='Closed']")
            private WebElement nav_StatusResult;
            //@FindBy (how=How.XPATH, using="*//a[@class='x-btn tktDetailsPdfButton x-unselectable x-btn-default-small']")
            //@FindBy (how=How.XPATH, using="*//a[Contains(@Class,'Pdf')]")-by Priyanka on 10/8/15
            @FindBy (how=How.ID, using="button-1086-btnEl")
            private WebElement nav_TicketPdfIcon;
            @FindBy (how=How.XPATH, using="*//a[@class='x-btn tktDetailsCsvButton x-unselectable x-btn-default-small']")
            private WebElement nav_TicketCsvIcon;
            @FindBy (how=How.XPATH, using="*//span[text()='OK']")
            //@FindBy (how=How.ID, using="button-1145-btnInnerEl")
            private WebElement nav_TicketNoteOk;
            
            @FindBy(how=How.ID, using="idSearchByCombo-inputEl")
            private WebElement nav_TicketSearchByDropdown;
            
            @FindBy(how=How.XPATH, using="//span[Contains(@id,'tktDurationButton')][Contains(@id,'btnInnerEl')]")
            private WebElement nav_TicketAgeField;
            
            //@FindBy(how=How.XPATH, using="//div[Contains(@id,'boundlist')]/ul/li[text()='Outstanding'][Contains(@Class,'selected')]")
            @FindBy(how=How.XPATH, using="//div[6]/div/ul/li[1]")
            private WebElement nav_EilersonChkDefaultStatus;
            
            //######################################################################
			//##################################################################
  
            public WebElement getNav_EilersonChkDefaultStatus(){
            	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
            	return nav_EilersonChkDefaultStatus;
            }   
            
            public WebElement getNav_TicketAgeField(){
            	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
            	return nav_TicketAgeField;
            }

            
    public WebElement getNav_CreateTicketDialog(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_CreateTicketDialog;
}
public WebElement getNav_CreateTicketDialogSeverityDropDown() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_CreateTicketDialogSeverityDropDown;
}

public WebElement getNav_CreateTicketDialogPriorityDropDown() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_CreateTicketDialogPriorityDropDown;
}

public WebElement getNav_CreateTicketDialogCategoryDropDown() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_CreateTicketDialogCategoryDropDown;
}

public WebElement getNav_TicketsWebTable() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_TicketsWebTable;
}

public WebElement getNav_CreateTicketDialogHeaderText(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_CreateTicketDialogHeaderText;
}
public WebElement getNav_CreateTicketDialogDate(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_CreateTicketDialogDate;
}
public WebElement getNav_CreateTicketDialogOrganization(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_CreateTicketDialogOrganization;
}
public WebElement getNav_CreateTicketDialogSummary(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_CreateTicketDialogSummary;
}
public WebElement getNav_CreateTicketDialogSeverity(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_CreateTicketDialogSeverity;
}
public WebElement getNav_CreateTicketDialogPriority(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_CreateTicketDialogPriority;
}
public WebElement getNav_CreateTicketDialogCategory(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_CreateTicketDialogCategory;
}
public WebElement getNav_CreateTicketDialogAddNote(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_CreateTicketDialogAddNote;
}
public WebElement getNav_CreateTicketDialogAttachment(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_CreateTicketDialogAttachment;
}

public WebElement getNav_CreateTicketDialogOkButton(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_CreateTicketDialogOkButton;
}
public WebElement getNav_CreateTicketDialogCancelButton(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_CreateTicketDialogCancelButton;
}

//This Element updated on 10/01/2015 for EXTJS5 by QAA03(Newly created)
public WebElement getNav_CreateTicketNotification(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_CreateTicketNotification;
}
//This Element updated on 10/01/2015 for EXTJS5 by QAA03(Newly created)
public WebElement getNav_CreateTicketNotificationOkButton(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_CreateTicketNotificationOkButton;
}
public WebElement getNav_TicketsLink() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_TicketsLink;
}
public WebElement getNav_UserNameLink(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_UserNameLink;
}
public WebElement getNav_DetailedTicketingSystem(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_DetailedTicketingSystem;
	}
public WebElement getNav_RefreshDetailsLink(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_RefreshDetailsLink;
}
public WebElement getNav_TicketsCsvIcon(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_TicketsCsvIcon;
}
public WebElement getNav_TicketsPdfIcon(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_TicketsPdfIcon;
}
public WebElement getNav_TicketsTab(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_TicketsTab;
}
public WebElement getNav_OpenTickets(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_OpenTickets;
}
public WebElement getNav_WorkingTickets(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_WorkingTickets;
}
public WebElement getNav_PendingTickets(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_PendingTickets;
}
public WebElement getNav_ResolvedTickets(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_ResolvedTickets;
}
public WebElement getNav_FilterByStatusDropdown(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_FilterByStatusDropdown;
}

public WebElement getNav_SearchTextField(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_SearchTextField;
}
public WebElement getNav_SearchIcon(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_SearchIcon;
}

public WebElement getNav_TicketID(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_TicketID;
}
public WebElement getNav_Summary(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_Summary;
}
public WebElement getNav_Severity(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_Severity;
}
public WebElement getNav_Priority(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_Priority;
}
public WebElement getNav_LastUpdateDate(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_LastUpdateDate;
}
public WebElement getNav_AssignedTo(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_AssignedTo;
}
public WebElement getNav_Status(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_Status;
}

public WebElement getNav_OpenTicketNumbers(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_OpenTicketNumbers;
}
public WebElement getNav_WorkingTicketNumbers(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_WorkingTicketNumbers;
}
public WebElement getNav_PendingTicketNumbers(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_PendingTicketNumbers;
}
public WebElement getNav_ResolvedTicketNumbers(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_ResolvedTicketNumbers;
}
public WebElement getNav_Outstanding(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_Outstanding;
}
public WebElement getNav_ClosedLess(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_ClosedLess;
}
public WebElement getNav_ClosedMore(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_ClosedMore;
}
public WebElement getNav_StatusResult(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_StatusResult;

}
public WebElement getNav_TicketPdfIcon(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_TicketPdfIcon;
}
public WebElement getNav_TicketCsvIcon(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_TicketCsvIcon;
}
public WebElement getNav_CreateTicketDialogErrMsg(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_CreateTicketDialogErrMsg;
}
public WebElement getNav_CreateTicketDialogCloseErrMsg(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_CreateTicketDialogCloseErrMsg;
}
public WebElement getNav_CreateTicketCloseButton(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_CreateTicketCloseButton;
}
public WebElement getNav_CreateNote(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_CreateNote;
}
public WebElement getNav_TicketNoteOk(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_TicketNoteOk;
}
public WebElement getNav_CreateNoteOkError(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_CreateNoteOkError;
}
public WebElement getNav_CreateNoteErrorClose(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_CreateNoteErrorClose;
}
public WebElement getNav_CreateNoteClose(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_CreateNoteClose;	
}

public WebElement getNav_TicketSearchByDropdown(){
    FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
    return nav_TicketSearchByDropdown;
}

public WebElement getNav_PopUpOKBtn() {
	  FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_PopUpOKBtn;
}

public WebElement getNav_TicketLastPageIcon() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_TicketLastPageIcon;
}






public WebElement getNav_TicketOrgWebListArrow() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_TicketOrgWebListArrow;
}

public WebElement getNav_TicketOrgWebListDropDown() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_TicketOrgWebListDropDown;
}

public WebElement getNav_TicketsPrintIcon() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_TicketsPrintIcon;
}

public WebElement getNav_TktsPrintIcon_Summary() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_TktsPrintIcon_Summary;
}

public WebElement getNav_TktsPrintIcon_Notes() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_TktsPrintIcon_Notes;
}




public WebElement getNav_TicketExpandTable() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_TicketExpandTable;
}


@FindBy(how=How.XPATH, using="//li[@id='number_outstand_tix']")
private WebElement nav_TicketsCount;


public WebElement getNav_TicketsCount() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_TicketsCount;
	
}

public WebElement getNav_OpenTicketLink() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_OpenTicketLink;
}

public WebElement getNav_OkBtnInTicketPage() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_OkBtnInTicketPage;
}

public WebElement getNav_CreatingTicketOkBtn() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_CreatingTicketOkBtn;
}

public WebElement getNav_FirstTicketId() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_FirstTicketId;
}

public WebElement getNav_SummaryEditField() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_SummaryEditField;
}

public WebElement getNav_ClarkSearchByTicketID() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_ClarkSearchByTicketID;
}

public WebElement getNav_ClarkOrgComboSearch() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_ClarkOrgComboSearch;
}

public WebElement getNav_ClarkHostedsolorg() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_ClarkHostedsolorg;
}

public WebElement getNav_ClarkSearchByAdv() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_ClarkSearchByAdv;
}

public WebElement getNav_ClarkTktlogDateColumn() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_ClarkTktlogDateColumn;
}

public WebElement getNav_ClarkTktlogMemoColumn() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_ClarkTktlogMemoColumn;
}

public WebElement getNav_ClarkBilledMinutesColumn() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_ClarkBilledMinutesColumn;
}

public WebElement getNav_ClarkSrvcNumColumn() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_ClarkSrvcNumColumn;
}

public WebElement getNav_ClarkSrvcDescColumn() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_ClarkSrvcDescColumn;
}

public WebElement getNav_ClarkSrvcUserColumn() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_ClarkSrvcUserColumn;
}

public WebElement getNav_ClarkTktStatus() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_ClarkTktStatus;
}

public WebElement getNav_ClarkTckDetailStatusDropdown() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_ClarkTckDetailStatusDropdown;
}

public WebElement getNav_ClarkSaveTktOkBtn() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_ClarkSaveTktOkBtn;
}

public WebElement getNav_ClarkTktOrgHeader() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_ClarkTktOrgHeader;
}

public WebElement getNav_ClarkCreateTktPopup() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_ClarkCreateTktPopup;
}

public WebElement getNav_ClarkCreateTktPopupOkBtn() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_ClarkCreateTktPopupOkBtn;
}

public WebElement getNav_FirstTicketExpander() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_FirstTicketExpander;
}

public WebElement getNav_CreateNoteEditBox() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_CreateNoteEditBox;
}

public WebElement getNav_CreateNoteOkBtn() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_CreateNoteOkBtn;
}

public WebElement getNav_ExpandAllCheckBox() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_ExpandAllCheckBox;
}

public WebElement getNav_FirstSearchDropDownBox() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_FirstSearchDropDownBox;
}

public WebElement getNav_FirstSearchDropDownOption() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_FirstSearchDropDownOption;
}

public WebElement getNav_TicketLogsTable() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_TicketLogsTable;
}
//////////////////////////////KEFFER////////////////////////////////////

@FindBy(how=How.XPATH,using="//div[@id='notesGridDiv-475638']//div[Contains(@id,'PagingToolbar')]")
private WebElement nav_TktNotesPaginationChk;

/*@FindBy(how=How.XPATH,using="//table//div/a[Contains(@id,'greenbutton')]")
private WebElement nav_C*/

public WebElement getNav_TktNotesPaginationChk() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_TktNotesPaginationChk;
}

public WebElement getNav_PaginationTicketTableCurrentPageIndex() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_PaginationTicketTableCurrentPageIndex;
}

public WebElement getNav_PaginationTicketTableTotalPageIndex() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_PaginationTicketTableTotalPageIndex;
}

public WebElement getNav_PaginationTicketTableNextBtn() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_PaginationTicketTableNextBtn;
}

public WebElement getNav_NotesWebTable_DateUpwardPointingArrowIcon() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_NotesWebTable_DateUpwardPointingArrowIcon;
}





}
