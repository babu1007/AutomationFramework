package com.whs.navigator.pagefactory.dev.old;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class ReportsPageFactory {

	
	@FindBy(how=How.LINK_TEXT, using="Storage Reports")
	private WebElement navStorageReportsLink;
	
	@FindBy(how=How.ID, using="tsTypeCmp-trigger-picker")
	private WebElement navCustomerTieredStorageLevelsDropDownArrow;
	
	@FindBy(how=How.XPATH, using="//ul[@data-ref='listEl']")
    private WebElement navCustomerTieredStorageLevelsDropDown_Elements;
	
	@FindBy(how=How.ID, using="tsPodCmp-trigger-picker")
	private WebElement navPODDropDownArrow;
	
	@FindBy(how=How.ID, using="tsTierCmp-trigger-picker")
	private WebElement navTierDropDownArrow;
	
	@FindBy(how=How.ID, using="tsDateCmp-trigger-picker")
    private WebElement navDateDropDownArrow;
	
	
	@FindBy(how=How.ID, using="psPodCmp-trigger-picker")
	private WebElement navPhysicalStoragePODDropDownArrow;
	
	@FindBy(how=How.ID, using="psTierCmp-trigger-picker")
	private WebElement navPhysicalStorageTierDropDownArrow;
	
	@FindBy(how=How.ID, using="psDateCmp-trigger-picker")
    private WebElement navPhysicalStorageDateDropDownArrow;
	
	@FindBy(how=How.XPATH, using="//div[@id='storage-chart']//svg:rect[@class=' highcharts-background']")
	private WebElement navReportsGraph;
	
	@FindBy(how=How.XPATH, using="//div[@id='storage-chart']//*[name()='g'][@title='Chart context menu']")
	private WebElement navGraphContextMenu;
	
	//@FindBy(how=How.XPATH, using="//div[@id='storage-chart']//svg:g[@class='highcharts-markers highcharts-tracker']/svg:path[@fill='#2F7ED8']")
		@FindBy(how=How.XPATH, using="//div[@id='storage-chart']//*[name()='svg']//*[name()='g'][@class='highcharts-markers highcharts-tracker'][1]")
		private WebElement navAllocatedGraph_GreenColorLine;
		
		//@FindBy(how=How.XPATH, using="//div[@id='storage-chart']//svg:g[@class='highcharts-markers highcharts-tracker']/svg:path[@fill='#3FAE29']")
		@FindBy(how=How.XPATH, using="//div[@id='storage-chart']//*[name()='svg']//*[name()='g'][@class='highcharts-markers highcharts-tracker'][2]")
	    private WebElement navCommittedGraph_BlueColorline;

		@FindBy(how=How.XPATH, using="//div[@id='storage-chart']//*[name()='svg']//*[name()='g']//*[name()='text']//*[name()='tspan'][3]")
		private WebElement navAllocatedValueInGB;
		
		@FindBy(how=How.ID, using="closeStorageGraphs")
		private WebElement navCloseBtn;
		
		// this below elements is added by NMR - 08/01/2016
		@FindBy(how=How.XPATH, using="//div[@id='content']//ul[@class='breadcrumbs breadcrumbs-horizontal lfr-component']")
		private WebElement navBreadCrumbChain;
		
		@FindBy(how=How.XPATH, using="//div[@id='ReportLauncherPortletDiv']//a[@href='/en/reports/bandwidth']")
		private WebElement navNetworkReports;
		
		@FindBy(how=How.ID, using="BandwidthReportPortletDiv")
		private WebElement navNetworkPortlets;
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////
                     ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public WebElement getNavStorageReportsLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navStorageReportsLink;
	}

	public WebElement getNavCustomerTieredStorageLevelsDropDownArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navCustomerTieredStorageLevelsDropDownArrow;
	}

	public WebElement getNavCustomerTieredStorageLevelsDropDown_Elements() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navCustomerTieredStorageLevelsDropDown_Elements;
	}
	
	public WebElement getNavPODDropDownArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navPODDropDownArrow;
	}

	public WebElement getNavTierDropDownArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navTierDropDownArrow;
	}

	public WebElement getNavDateDropDownArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navDateDropDownArrow;
	}

	public WebElement getNavGraphContextMenu() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navGraphContextMenu;
	}

	public WebElement getNavAllocatedGraph_GreenColorLine() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navAllocatedGraph_GreenColorLine;
	}

	public WebElement getNavCommittedGraph_BlueColorline() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navCommittedGraph_BlueColorline;
	}

	public WebElement getNavReportsGraph() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navReportsGraph;
	}

	public WebElement getNavPhysicalStoragePODDropDownArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navPhysicalStoragePODDropDownArrow;
	}

	public WebElement getNavPhysicalStorageTierDropDownArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navPhysicalStorageTierDropDownArrow;
	}

	public WebElement getNavPhysicalStorageDateDropDownArrow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navPhysicalStorageDateDropDownArrow;
	}

	public WebElement getNavAllocatedValueInGB() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navAllocatedValueInGB;
	}

	public WebElement getNavCloseBtn() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navCloseBtn;
	}

	public WebElement getNavBreadCrumbChain() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navBreadCrumbChain;
	}

	public WebElement getNavNetworkReports() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navNetworkReports;
	}

	public WebElement getNavNetworkPortlets() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return navNetworkPortlets;
	}
	
	
	
	
	
	
	
 }
