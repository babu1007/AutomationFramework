package com.whs.navigator.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class EntityBrowserPageFactory {
	
		
		//////////////////////////////Taken From Byron PageFactory//////////////////////////
		@FindBy(how=How.ID, using = "idFooterButton")
		private WebElement nav_entityBrowserLink;
		
		@FindBy(how=How.ID, using = "idEBtopSliderText")
		private WebElement nav_OrgNameTitleLink;
		
		@FindBy(how=How.ID, using = "idEBtopSliderIcon")
		private WebElement nav_topSliderIcon;
		
		@FindBy(how=How.ID, using = "firstCombo-inputEl")
		private WebElement nav_firstLevelChildrenEditBox;
		
		//This element updated on 10/01/2015 by QAA03
		//@FindBy(how=How.ID, using = "idFirstFramedPanel_header_hd-textEl")
		@FindBy(how=How.ID, using = "idFirstFramedPanel_header-innerCt")
		private WebElement nav_firstLevelChildrenTitle;
		
		@FindBy(how=How.ID, using = "secondCombo-inputEl")
		private WebElement nav_secondLevelChildrenEditBox;
		
		//This element updated on 10/01/2015 by QAA03
		//@FindBy(how=How.ID, using = "idSecondFramedPanel_header_hd-textEl")
		@FindBy(how=How.ID, using = "idSecondFramedPanel_header-innerCt")
		private WebElement nav_secondLevelChildrenTitle;
		
		@FindBy(how=How.ID, using = "thirdCombo-inputEl")
		private WebElement nav_thirdLevelChildrenEditBox;
		
		//This element updated on 10/01/2015 by QAA03
		//@FindBy(how=How.ID, using = "idThirdFramedPanel_header_hd-textEl")
		@FindBy(how=How.ID, using = "idThirdFramedPanel_header-innerCt")
		private WebElement nav_thirdLevelChildrenTitle;
		
		
		@FindBy(how=How.ID, using = "fourthCombo-inputEl")
		private WebElement nav_fourthLevelChildrenEditBox;
	     
		//This element updated on 10/01/2015 by QAA03
		//@FindBy(how=How.ID, using = "idFourthFramedPanel_header_hd-textEl")
		@FindBy(how=How.ID, using = "idFourthFramedPanel_header-innerCt")
		private WebElement nav_fourthLevelChildrenTitle;
		
		@FindBy(how=How.ID, using = "idEBCloseButton")
		private WebElement nav_closeButton;
		
		//This element updated on 10/01/2015 by QAA03
		//@FindBy(how=How.XPATH, using = "//div[@id='1stGrid']//table[contains(@id,'table')]")
		@FindBy(how=How.ID, using = "1stGrid")
		private WebElement nav_firstLevelChildrenOrgTable;
		
		//This element updated on 10/01/2015 by QAA03
		//@FindBy(how=How.XPATH, using = "//div[@id='2ndGrid']//table[contains(@id,'table')]")
		@FindBy(how=How.ID, using = "2ndGrid")
		private WebElement nav_secondLevelChildrenOrgTable;
		
		//This element updated on 10/01/2015 by QAA03
		//@FindBy(how=How.XPATH, using = "//div[@id='3rdGrid']//table[contains(@id,'table')]")
		@FindBy(how=How.ID, using = "3rdGrid")
		private WebElement nav_thirdLevelChildrenOrgTable;
		
		//This element updated on 10/01/2015 by QAA03
		//@FindBy(how=How.XPATH, using = "//div[@id='4thGrid']//table[contains(@id,'table')]")
		@FindBy(how=How.ID, using = "4thGrid")
		private WebElement nav_fourthLevelChildrenOrgTable;
		
		@FindBy(how=How.ID, using = "idEBPanel")
		private WebElement nav_entityBrowserTable;
		
		//This element commented on 10/01/2015 by QAA03
		
		//@FindBy(how=How.XPATH, using="//div[@id='idTicketsGridPanel-body']//table[contains(@id,'gridview-')]")
		//@FindBy(how=How.XPATH, using="//div[@id='idTicketsGridPanel-body']")
		//private WebElement nav_TicketsWebTable;
		
		@FindBy(how=How.XPATH, using="//img[@alt='TierPoint logo']")
		private WebElement nav_WSLogo;
		
		
		@FindBy(how=How.XPATH, using="//div[@id='content']/div//ul/li/span/a[text()='Home']")
		private WebElement nav_HomeBreadCrumb;
		
		
		@FindBy(how=How.XPATH, using="//section//li[@id='number_outstand_tix']")
		private WebElement nav_OutStandingTicketCntInHmPg;
		
		@FindBy(how=How.XPATH, using="//li[@id='number_resolved_tix']")
		private WebElement nav_ResolvedTicketCntInHmPg;
		
		@FindBy(how=How.XPATH,using="//a[contains(text(),'Andover')]")
		private WebElement nav_EVDCPortalLink;
		
		@FindBy(how=How.XPATH,using="//div[@class='header_wrapper']/ul/li[@class='last']/span/a")
		private WebElement nav_BreadCrumbSection;
		
		@FindBy(how=How.XPATH,using="//a[text()='Virtual Machines']")
		private WebElement nav_VMLink;
		
		@FindBy(how=How.XPATH,using="//a[text()='Catalogs']")
		private WebElement nav_CatalogLink;
		
		//@FindBy(how=How.XPATH,using="//div[@id='wsCtlgs-body']/div/table[contains(@id,'gridview-')]")
		@FindBy(how=How.XPATH, using="//div[@id='winObjContainer']//div[@id='wsCtlgs-body']//div[@class='x-grid-item-container']")
		private WebElement nav_CatalogWsWebTable;
		
		@FindBy(how=How.XPATH,using="//div[@id='messagebox-1001_header_hd']")
		private WebElement nav_InfoUnavailableText;
		
		@FindBy(how=How.XPATH,using="//span[contains(@id,'btnInnerEl')][text()='OK']")
		private WebElement nav_InfoUnavailableOKButton;
		
		@FindBy(how=How.XPATH,using="//ul[@id='val_vm']/li[@id='cat_rules']")
		private WebElement nav_RulesCountText;

		@FindBy(how=How.ID, using = "idFooterButton")
		private WebElement nav_EntityBrowserLink;
		
		
		
		
		
		
		//This element commented on 10/01/2015 for EXTJS5 by QAA03
		
		/*public WebElement getNav_TicketsWebTable() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_TicketsWebTable;
		}*/
		
		public WebElement getNav_EntityBrowserLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EntityBrowserLink;
		}

		public WebElement getNav_OrgNameTitleLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_OrgNameTitleLink;
		}
		
		public WebElement getNav_TopSliderIcon() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_topSliderIcon;
		}

		public WebElement getNav_FirstLevelChildrenEditBox() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_firstLevelChildrenEditBox;
		}

		public WebElement getNav_FirstLevelChildrenTitle() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_firstLevelChildrenTitle;
		}

		public WebElement getNav_SecondLevelChildrenEditBox() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_secondLevelChildrenEditBox;
		}

		public WebElement getNav_SecondLevelChildrenTitle() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_secondLevelChildrenTitle;
		}

		public WebElement getNav_ThirdLevelChildrenEditBox() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_thirdLevelChildrenEditBox;
		}

		public WebElement getNav_ThirdLevelChildrenTitle() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_thirdLevelChildrenTitle;
		}

		public WebElement getNav_FourthLevelChildrenEditBox() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_fourthLevelChildrenEditBox;
		}

		public WebElement getNav_FourthLevelChildrenTitle() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_fourthLevelChildrenTitle;
		}

		public WebElement getNav_CloseButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();	
			return nav_closeButton;
		}

		public WebElement getNav_FirstLevelChildrenOrgTable() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_firstLevelChildrenOrgTable;
		}

		public WebElement getNav_SecondLevelChildrenOrgTable() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_secondLevelChildrenOrgTable;
		}

		public WebElement getNav_ThirdLevelChildrenOrgTable() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_thirdLevelChildrenOrgTable;
		}

		public WebElement getNav_FourthLevelChildrenOrgTable() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_fourthLevelChildrenOrgTable;
		}

		public WebElement getNav_EntityBrowserTable() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_entityBrowserTable;
		}
		public WebElement getNav_WSLogo() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_WSLogo;
		}
		
		public WebElement getNav_OutStandingTicketCntInHmPg() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_OutStandingTicketCntInHmPg;
		}
		
		public WebElement getNav_ResolvedTicketCntInHmPg() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_ResolvedTicketCntInHmPg;
		}
		
		public WebElement getNav_EVDCPortalLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EVDCPortalLink;
		}
		
		public WebElement getNav_BreadCrumbSection() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_BreadCrumbSection;
		}
		
		public WebElement getNav_VMLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_VMLink;
		}
		
		public WebElement getNav_CatalogLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CatalogLink;
		}
		
		public WebElement getNav_CatalogWsWebTable() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_CatalogWsWebTable;
		}
		
		public WebElement getNav_InfoUnavailableText() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_InfoUnavailableText;
		}
		
		public WebElement getNav_InfoUnavailableOKButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_InfoUnavailableOKButton;
		}
		
		public WebElement getNav_RulesCountText() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_RulesCountText;
		}
		
		
		////$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$Priyanka$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
		
		@FindBy(how=How.XPATH, using = "*//div/ul/li[text()='Sev 1 - Critical']")
		private WebElement nav_EBpanelTicketSev1;
		
		@FindBy(how=How.XPATH, using="*//div/ul/li[text()='Normal']")
		private WebElement nav_EBPanelNormalPriority;
		
		@FindBy(how=How.XPATH, using="*//div/ul/li[text()='.General']")
		private WebElement nav_EBPanelCategory;
		
		//This Element updated on 10/01/2015 for EXTJS5 by QAA03
		
		//@FindBy(how=How.XPATH, using="*//td/div[text()='Successfully created the ticket']")
		//@FindBy(how=How.ID, using="messagebox-1001-targetEl")
	    //private WebElement nav_EBPanelCreateTktNotification;
		
		
		//@FindBy(how=How.ID, using="button-1005-btnIconEl")
		//@FindBy(how=How.ID, using="button-1005-btnInnerEl")
		//private WebElement nav_EBPanelTicketOKbutton;
		
		@FindBy(how=How.XPATH, using="*//a[text()='account']")
		private WebElement nav_EBPanelAccountTab;
		
		@FindBy(how=How.XPATH, using="//li/a[text()='Permissions']")
		private WebElement nav_EBPanelPerimissionsLink;
		
		@FindBy(how=How.XPATH, using="*//div[@id='idEbFooter']/div[text()='TST Devco1']")
		private WebElement nav_EBPanelTstFooter;
		
		@FindBy(how=How.XPATH, using="*//div[@id='idEbFooter']/div[text()='.Hosted Solutions']")
		private WebElement nav_EBPanelHostedSolFooter;
		
		//@FindBy(how=How.ID, using="edvc_1")
		@FindBy(how=How.XPATH,using="//*[@id='edvc_1']/a")
		private WebElement nav_EBPanelEVDCHomeLink;
		
		//@FindBy(how=How.XPATH, using="*//a[text()='Virtual Machines']")
		@FindBy(how=How.LINK_TEXT,using="Virtual Machines")
		private WebElement nav_EBPanelEVDCVmLink;
		
		// Duplicate already available in Smoke(Bandwidth portlet)
		/*//@FindBy(how=How.ID, using="evdc_bandwidth")
		@FindBy(how=How.ID, using="arrow_content_band")
		private WebElement nav_EBPanelBWPortalHome;*/
		
		@FindBy(how=How.XPATH, using="//input[@id='idSearchByCombo-inputEl']")
		private WebElement nav_EBPanelSearchByTktDropdown;
		
		@FindBy(how=How.XPATH, using="//div[@id='boundlist-1083-listEl']/ul/li[text()='Ticket ID']")
		private WebElement nav_EBPanelTktIdOption;
		
		@FindBy(how=How.ID, using="idSearchTextField-inputEl")
		private WebElement nav_EBPanelTktSearchbox;
		

		
		public WebElement getNav_EBpanelTicketSev1(){
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EBpanelTicketSev1;
		}
		public WebElement getNav_EBpanelNormalPriority(){
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EBPanelNormalPriority;
		}
		
		public WebElement getNav_EBPanelCategory(){
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EBPanelCategory;
		}
		
		/*public WebElement getNav_EBPanelCreateTktNotification()
		{
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EBPanelCreateTktNotification;
		}
		
		public WebElement getNav_EBPanelTicketOKbutton()
		{
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EBPanelTicketOKbutton;
		}*/
		
		public WebElement getNav_EBPanelAccountTab()
		{
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EBPanelAccountTab;
		}
		
		public WebElement getNav_EBPanelPerimissionsLink()
		{
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EBPanelPerimissionsLink;
		}
		
		public WebElement getNav_EBPanelFooter()
		{
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EBPanelTstFooter;
		}
		
		public WebElement getNav_EBPanelEVDCHomeLink()
		{
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EBPanelEVDCHomeLink;
		}
		
		public WebElement getNav_EBPanelEVDCVmLink()
		{
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EBPanelEVDCVmLink;
		}
		
		public WebElement getNav_EBPanelHostedSolFooter()
		{
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EBPanelHostedSolFooter;
		}
		
		/*public WebElement getNav_EBPanelBWPortalHome()
		{
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EBPanelBWPortalHome;
		}*/
		
		public WebElement getNav_EBPanelSearchByTktDropdown()
		{
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EBPanelSearchByTktDropdown;
		}
		
		public WebElement getNav_EBPanelTktIdOption()
		{
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EBPanelTktIdOption;
		}
		public WebElement getNav_EBPanelTktSearchbox()
		{
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EBPanelTktSearchbox;
		}

		
		public WebElement getNav_HomeBreadCrumb() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_HomeBreadCrumb;
		}
		
		
		
		
		

		/*public WebElement getNav_EBPanelTitle() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EBPanelTitle;
		}

		public WebElement getNav_EBPanelCloseBtn() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EBPanelCloseBtn;
		}*/

		
		
		
//////////////////////////////Taken From Byron PageFactory////////////////////////////
		
		/*public WebElement getNav_entityBrowserLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_entityBrowserLink;
		}*/

		public WebElement getNav_topSliderIcon() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_topSliderIcon;
		}

		public WebElement getNav_firstLevelChildrenEditBox() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_firstLevelChildrenEditBox;
		}

		public WebElement getNav_firstLevelChildrenTitle() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_firstLevelChildrenTitle;
		}

		public WebElement getNav_secondLevelChildrenEditBox() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_secondLevelChildrenEditBox;
		}

		public WebElement getNav_secondLevelChildrenTitle() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_secondLevelChildrenTitle;
		}

		public WebElement getNav_thirdLevelChildrenEditBox() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_thirdLevelChildrenEditBox;
		}

		public WebElement getNav_thirdLevelChildrenTitle() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_thirdLevelChildrenTitle;
		}

		public WebElement getNav_fourthLevelChildrenEditBox() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_fourthLevelChildrenEditBox;
		}

		public WebElement getNav_fourthLevelChildrenTitle() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_fourthLevelChildrenTitle;
		}

		public WebElement getNav_closeButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_closeButton;
		}

		public WebElement getNav_firstLevelChildrenOrgTable() {
			return nav_firstLevelChildrenOrgTable;
		}

		public WebElement getNav_secondLevelChildrenOrgTable() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_secondLevelChildrenOrgTable;
		}

		public WebElement getNav_thirdLevelChildrenOrgTable() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_thirdLevelChildrenOrgTable;
		}

		public WebElement getNav_fourthLevelChildrenOrgTable() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_fourthLevelChildrenOrgTable;
		}

		public WebElement getNav_entityBrowserTable() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_entityBrowserTable;
		}

		public WebElement getNav_EBPanelNormalPriority() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EBPanelNormalPriority;
		}

		public WebElement getNav_EBPanelTstFooter() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EBPanelTstFooter;
		}
	
		

/////////////////////////////////////////////// QAA04 ///////////////////////////////////////////////////////////
		// taken from calrk pagefactory
		
		@FindBy(how=How.XPATH, using="//li[@id='organization']/nobr")
		private WebElement nav_OrgName;
		
		// This Four Elements Updated on 10/06/2015 by QAA03 for EXTJS5
		//@FindBy(how=How.XPATH, using="//table/tbody/tr[1]/td[5]")
		@FindBy(how=How.XPATH, using="//table[1]/tbody/tr[1]/td[5]")
		private WebElement nav_Users_FirstRow_EntityColumn;
					
		//@FindBy(how=How.XPATH, using="//table/tbody/tr[1]/td[6]")
		@FindBy(how=How.XPATH, using="//table[1]/tbody/tr[1]/td[6]")
		private WebElement nav_Users_FirstRow_ParentColumn;
					
		//@FindBy(how=How.XPATH, using="//span[@id='gridcolumn-1047-textEl']")
		@FindBy(how=How.XPATH, using="//div[contains(@class,'x-box-target')]//div[5]")
		private WebElement nav_Users_EntityColumnName;
					
		//@FindBy(how=How.XPATH, using="//div[@class='x-column-header x-column-header-align-left x-box-item x-column-header-default x-unselectable x-column-header-last']")
		@FindBy(how=How.XPATH, using="//div[contains(@class,'x-column-header-last')]")
		private WebElement nav_Users_ParentColumnName;

		
		//The following elements are moved to admin module - updated - 11/18/2015-QAA03
		
		/*@FindBy(how=How.XPATH, using="//span[text()='Entity Management']")
	    private WebElement Upgrade_EntityMgtTab;

		@FindBy(how=How.XPATH, using="//div[@class='middleCenterInner']//table//table[@class='upgrade-grid']")
		private WebElement Upgrade_EntityMgtTable;

		@FindBy(how=How.XPATH, using="//button[text()='Next']")
		private WebElement upgrade_EntityMgt_Nextbutton;*/

		@FindBy(how=How.XPATH, using = "//input[contains(@id,'dv_summary_text')]")
		private WebElement nav_SummaryTextafterTcktExpand;
		
		
		//The following elements are moved to admin module - updated - 11/18/2015-QAA03
		
		/*@FindBy(how=How.ID, using="x-auto-20")
		private WebElement Upgrade_EntityMgtDropdownArrow;
		
		@FindBy(how=How.XPATH, using="//div[contains(@class,'x-trigger-wrap-focus')]/input")
		private WebElement Upgrade_EntityMgtOrgEdit;
		
		@FindBy(how=How.XPATH, using="//div[@class='middleCenterInner']//table//table[@class='upgrade-grid']//tr[2]//td[2]")
		private WebElement Upgrade_EntityMgtParentElement;
			
		@FindBy(how=How.XPATH, using="//button[text()='Change Parent']")
		private WebElement Upgrade_EM_ChangeParentButton;
		
		@FindBy(how=How.ID, using="x-auto-24")
		private WebElement Upgrade_EM_ChangeParentArrow;
		
		@FindBy(how=How.ID, using="x-auto-22-input")
		private WebElement Upgrade_EM_ChangeParentText;
		
		@FindBy(how=How.XPATH, using="//button[text()='Save']")
		private WebElement Upgrade_EM_CPTextSaveButton;*/
		
		
		
		public WebElement getNav_OrgName() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_OrgName;
		}

		public WebElement getNav_Users_FirstRow_EntityColumn() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_Users_FirstRow_EntityColumn;
		}

		public WebElement getNav_Users_FirstRow_ParentColumn() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_Users_FirstRow_ParentColumn;
		}

		public WebElement getNav_Users_EntityColumnName() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_Users_EntityColumnName;
		}

		public WebElement getNav_Users_ParentColumnName() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_Users_ParentColumnName;
		}

		/*public WebElement getUpgrade_EntityMgtTab() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return Upgrade_EntityMgtTab;
		}

		public WebElement getUpgrade_EntityMgtTable() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return Upgrade_EntityMgtTable;
		}

		public WebElement getUpgrade_EntityMgt_Nextbutton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return upgrade_EntityMgt_Nextbutton;
		}*/

		

		public WebElement getNav_SummaryTextafterTcktExpand() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_SummaryTextafterTcktExpand;
		}

		/*public WebElement getUpgrade_EntityMgtDropdownArrow() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return Upgrade_EntityMgtDropdownArrow;
		}

		public WebElement getUpgrade_EntityMgtOrgEdit() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return Upgrade_EntityMgtOrgEdit;
		}

		public WebElement getUpgrade_EntityMgtParentElement() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return Upgrade_EntityMgtParentElement;
		}

		public WebElement getUpgrade_EM_ChangeParentButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return Upgrade_EM_ChangeParentButton;
		}

		public WebElement getUpgrade_EM_ChangeParentArrow() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return Upgrade_EM_ChangeParentArrow;
		}

		public WebElement getUpgrade_EM_ChangeParentText() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return Upgrade_EM_ChangeParentText;
		}

		public WebElement getUpgrade_EM_CPTextSaveButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return Upgrade_EM_CPTextSaveButton;
		}
		
		*/
		
	///////******************************keffer TestCase Objects***********************************//////
		
		@FindBy(how=How.ID, using ="idEBRollUpButton")
		private WebElement nav_EBPanelRollUpButton;

		@FindBy(how=How.ID, using ="idEBFooterButtonIcon")
		private WebElement nav_EBPanelFooterRollUpButton;

		@FindBy(how=How.XPATH, using=".//*[@id='boundlist-1087-listEl']/li")
		private WebElement nav_TicketsOrgDropdownlist;

		
			
		public WebElement getNav_entityBrowserLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_entityBrowserLink;
		}

		public WebElement getNav_TicketsOrgDropdownlist() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_TicketsOrgDropdownlist;
		}

		public WebElement getNav_EBPanelRollUpButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EBPanelRollUpButton;
		}

		public WebElement getNav_EBPanelFooterRollUpButton() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_EBPanelFooterRollUpButton;
		}
		
		
       
}
