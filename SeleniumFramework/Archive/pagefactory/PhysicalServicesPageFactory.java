package com.whs.navigator.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class PhysicalServicesPageFactory {

	@FindBy(how=How.XPATH, using="//div[contains(@id,'component-')]/img[contains(@src,'physical-services-icon')]")
	private WebElement nav_PhysicalServicesHeaderIcon;
	
	@FindBy(how=How.XPATH, using="//div[@id='PDC_maindiv']//div[contains(@class,'pdc_row_dm_location_lbl')]")
	private WebElement nav_PDCName;
	
	@FindBy(how=How.XPATH, using="//div[@id='PDC_maindiv']//div[contains(@class,'rectangle long')]")
	private WebElement nav_PhysicalServicesPortlet;

	@FindBy(how=How.XPATH, using="//div[contains(@class,'progress-bar-allocated-text')]")
	private WebElement nav_PDCAllocated;
	
	@FindBy(how=How.XPATH, using="//div[contains(@class,'progress-bar-committed-text')]")
	private WebElement nav_PDCCommitted;
	
	@FindBy(how=How.XPATH, using="//div[contains(@class,'pdc_row_dm_lbl')]/a")
	private WebElement nav_PDCDeviceMonitorLink;
		
	@FindBy(how=How.XPATH, using="//div[contains(@id,'component-')][contains(@class,'pdc_header_cls')]")
	private WebElement nav_PhysicalServicesHeader;
	
	@FindBy(how=How.XPATH, using="//div[@id='PDC_maindiv']//div[contains(@class,'x-component x-box-item x-toolbar-item x-component-default')]/img[contains(@src,'physical-services.png')]")
	private WebElement nav_PDCNameIcon;
	
	@FindBy(how=How.XPATH, using="//img[contains(@src,'storage.png')]/following-sibling::span")
	private WebElement nav_PDCStorageText;
	
	
	// These below elements added by NMR - 06/08/2016
	@FindBy(how=How.XPATH, using="//span[@class='pdc_details_lbl'][text()='Servers']")
	private WebElement nav_PDCServersCount;
	
	@FindBy(how=How.XPATH, using="//span[@class='pdc_details_lbl'][text()='Load Balancers']")
	private WebElement nav_PDCLoadBalancersCount;
	
	@FindBy(how=How.XPATH, using="//span[@class='pdc_details_lbl'][text()='Firewall']")
	private WebElement nav_PDCFirewallCount;
	
	@FindBy(how=How.XPATH, using="//div[@id='PDC_maindiv']//span[text()='Storage']")
	private WebElement nav_PDCStorageTitle;
	
	@FindBy(how=How.XPATH, using="//div[@id='PDC_maindiv']//table")
	private WebElement nav_PDCWebTableParent;
	
	@FindBy(how=How.XPATH, using="//div[@id='PDC_maindiv']//img[Contains(@src,'physical-services-icon')]")
	private WebElement nav_PhysicalServicesIcon;
	
	//Physical DC Elements
	@FindBy(how=How.XPATH, using="//div[@id='PDC_maindiv']//div[Contains(@Class,'pdc_cls')]")
	private WebElement nav_PhysicalServicePortletArea;
	
	
	@FindBy(how=How.XPATH, using="//div[@id='PDC_maindiv']//img[Contains(@src,'physical-services.png')]")
	private WebElement nav_PhysicalSrvcSecondaryIcon;
	
	@FindBy(how=How.XPATH, using="//div[@id='PDC_maindiv']//div[Contains(@Class,' pdc_row_dm_location_lbl')]")
	private WebElement nav_PhysicalServicesLocationName;
	
	@FindBy(how=How.XPATH, using="//div[@id='PDC_maindiv']//img[Contains(@src,'server.png')]")
	private WebElement nav_PhysicalServicesServerIcon;
	
	@FindBy(how=How.XPATH, using="//div[@id='PDC_maindiv']//img[Contains(@src,'firewall.png')]")
	private WebElement nav_PhysicalServicesFirewallIcon;
	
	@FindBy(how=How.XPATH, using="//div[@id='PDC_maindiv']//img[Contains(@src,'load_balance.png')]")
	private WebElement nav_PhysicalServicesLoadBalIcon;
	
	@FindBy(how=How.XPATH, using="//div[@id='PDC_maindiv']//img[Contains(@src,'storage.png')]]")
	private WebElement nav_PhysicalServicesStorageIcon;
	
	@FindBy(how=How.XPATH, using="//div[@id='PDC_maindiv']//img[Contains(@src,'device_monitor.png')]")
	private WebElement nav_PhysicalServicesDeviceIcon;
	
	@FindBy(how=How.XPATH, using="//div[@id='PDC_maindiv']//a")
	private WebElement nav_PhysicalServicesDeviceLink;
	
	@FindBy(how=How.XPATH, using="//div[@id='PDC_maindiv']//div[Contains(text(),'Physical Services')]")
	private WebElement nav_PhysicalServicesHeaderTitle;
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public WebElement getNav_PhysicalServicesHeaderTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PhysicalServicesHeaderTitle;
	}
		
		public WebElement getNav_PhysicalServicePortletArea() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_PhysicalServicePortletArea;
		}

		public WebElement getNav_PhysicalServicesIcon() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_PhysicalServicesIcon;
		}

	

		public WebElement getNav_PhysicalSrvcSecondaryIcon() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_PhysicalSrvcSecondaryIcon;
		}

		public WebElement getNav_PhysicalServicesLocationName() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_PhysicalServicesLocationName;
		}

		public WebElement getNav_PhysicalServicesServerIcon() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_PhysicalServicesServerIcon;
		}

		public WebElement getNav_PhysicalServicesFirewallIcon() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_PhysicalServicesFirewallIcon;
		}

		public WebElement getNav_PhysicalServicesLoadBalIcon() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_PhysicalServicesLoadBalIcon;
		}

		public WebElement getNav_PhysicalServicesStorageIcon() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_PhysicalServicesStorageIcon;
		}

		public WebElement getNav_PhysicalServicesDeviceIcon() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_PhysicalServicesDeviceIcon;
		}

		public WebElement getNav_PhysicalServicesDeviceLink() {
			FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
			return nav_PhysicalServicesDeviceLink;
		}


		

	
	public WebElement getNav_PhysicalServicesHeaderIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PhysicalServicesHeaderIcon;
	}


	public WebElement getNav_PhysicalServicesPortlet() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PhysicalServicesPortlet;
	}

	public WebElement getNav_PDCAllocated() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PDCAllocated;
	}

	public WebElement getNav_PDCCommitted() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PDCCommitted;
	}


	public WebElement getNav_PDCName() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PDCName;
	}


	public WebElement getNav_PDCDeviceMonitorLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PDCDeviceMonitorLink;
	}


	public WebElement getNav_PDCServersCount() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PDCServersCount;
	}


	public WebElement getNav_PDCLoadBalancersCount() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PDCLoadBalancersCount;
	}


	public WebElement getNav_PDCFirewallCount() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PDCFirewallCount;
	}


	public WebElement getNav_PDCStorageTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PDCStorageTitle;
	}


	public WebElement getNav_PhysicalServicesHeader() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PhysicalServicesHeader;
	}


	public WebElement getNav_PDCNameIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PDCNameIcon;
	}


	public WebElement getNav_PDCStorageText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PDCStorageText;
	}


	public WebElement getNav_PDCWebTableParent() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PDCWebTableParent;
	}
	

	
	
	
	
}
