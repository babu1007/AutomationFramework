package com.whs.navigator.pagefactory.dev.old;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class FirewallPageFactory_old {
	
	
	//EVDC link in home page
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Andover')]")
	private WebElement nav_EVDCPortalLink;
	
	//Fire wall link EVDC page
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Firewall')]")
	private WebElement nav_FirewallLink;
	
	//Interface table in Fire wall page
	@FindBy(how=How.XPATH,using="//table[contains(@class,'vm_table_construction')]")
	private WebElement nav_FirewallTable;
	
	//Add Fire wall link under Interface
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Add Firewall Rule')]")
	private WebElement nav_AddFireWallLink;
	
	@FindBy(how=How.ID, using="firewallsummary-2")
	private WebElement nav_FirstFirewallRuleExpander;
	
	@FindBy(how=How.ID, using="firewallsummary-3")
	private WebElement nav_SecondFirewallRuleExpander;
	
	// this elements is added by NMR - 06/07/2016
	@FindBy(how=How.XPATH, using="//img[@alt='create ticket']")
	private WebElement nav_CreateTicketLink;
	
	@FindBy(how=How.XPATH, using="//li[@id='siteTab']/a")
	private WebElement nav_SiteToSiteVpnTab;
	
	@FindBy(how=How.XPATH, using="//div[@id='stsmain']//a[contains(@onclick,'addSiteToSiteVPNTicket')]")
	private WebElement nav_AddSiteToSiteVpnLink;
	
	@FindBy(how=How.ID, using="natTab")
	private WebElement nav_NATsTab;
	
	
	//Add Fire Wall window
	@FindBy(how=How.XPATH,using="//div[@id='firewall_rules']")
	private WebElement nav_AddFireWallWindow;
	
	//Sequence Input field in Add fire wall window
	@FindBy(how=How.XPATH,using="//input[@id='sequenceId-inputId']")
	private WebElement nav_SequenceNumber;
	
	//Source drop down arrow in Add fire wall window
	//@FindBy(how=How.XPATH,using="//input[@id='sourceIp-inputId']/../../td[contains(@id,'ext-gen')]")
	
	 ////This object is updated on 10/01/2015 by QAA04
	@FindBy(how=How.XPATH,using="//div[@class='source third_span']//span[@class='imgtip']")
	
	//@FindBy(how=How.XPATH,using="//input[@id='sourceIp-inputId']/../../td[contains(@id,'ext-gen')]/div[contains(@id,'ext-gen')]")
	private WebElement nav_SourceDropDownIcon;

	
	////Source Dropdown field
	@FindBy(how=How.XPATH,using="//input[Contains(@id,'fwEdit-sourceIp-inputId')]")
	private WebElement nav_SourceDropDownField;
	
    ////Destination Dropdown field
	@FindBy(how=How.XPATH,using="//input[Contains(@id,'fwEdit-destIp-inputId')]")
	private WebElement nav_DestinationDropDownField;
	
	 ////This object is updated on 10/01/2015 by QAA04
	//Destination drop down arrow in Add fire wall window
	@FindBy(how=How.XPATH, using="//div[@class='destination third_span']//span[@class='imgtip']")
	
	//@FindBy(how=How.XPATH,using="//input[@id='destinationIp-inputId']/../../td[contains(@id,'ext-gen')]/div[contains(@id,'ext-gen')]")
	private WebElement nav_DestinationDownIcon;

	 ////This object is updated on 10/01/2015 by QAA04
	//Protocol drop down arrow in Add fire wall window	
	@FindBy(how=How.XPATH, using="//div[@class='protocol light_boundary third_span']//span[@class='imgtip']")
	
	//@FindBy(how=How.XPATH,using="//input[@id='protocolId-inputId']/../../td[contains(@id,'ext-gen')]/div[contains(@id,'ext-gen')]")
	private WebElement nav_ProtocolDownIcon;
	
	//Protocol Dropdown pop-up field
	@FindBy(how=How.XPATH, using="//input[Contains(@id,'fwEdit-port-inputId')]")
	private WebElement nav_ProtocolPortPopUPField;
	
	//Source list in Add fire wall window
	@FindBy(how=How.XPATH,using="//div[5]/div/ul[@class='x-list-plain']")
	private WebElement nav_SourceList;
	
	//Destination list in Add fire wall window

	@FindBy(how=How.XPATH,using="//div[6]/div/ul[@class='x-list-plain']")
	private WebElement nav_DestinationList;
	

	//Protocol list in Add fire wall window
	@FindBy(how=How.XPATH,using="//div[7]/div/ul[@class='x-list-plain']")
	private WebElement nav_ProtocolList;
	
	//Save button in Add fire wall window	
	@FindBy(how=How.ID,using="saveAddFW")
	private WebElement nav_FirewallSaveButton;
	//Fire wall rule table in Fire wall page
	@FindBy(how=How.XPATH,using="//section[@id='add_firewall_rule']")
	private WebElement nav_FirewallRuleTable;
	//Sequence Number input field in Move Fire Wall Rule window
	@FindBy(how=How.XPATH,using="//table/tbody//input[contains(@id,'fwEdit-seqNum-inputId')]")
	private WebElement nav_SequenceNumberinFirewallRuleTable;
	
	// rules count 
	@FindBy(how=How.XPATH,using="//ul[@id='val_vm']/li[@id='cat_rules']")
	private WebElement nav_RulesCountText;
	//####################################################################
	

	//Not using in script. Because Move will present in each row.
	@FindBy(how=How.XPATH,using="//section//table//tr[1]/td/table//span[contains(@id,'fwEdit-moveButton-fwRuID')]/a[contains(text(),'Move')]")
	private WebElement nav_MoveLink;

	//Not using in script. Because Edit will present in each row.
	@FindBy(how=How.XPATH,using="//section//table//tr[1]/td/table//span[contains(@id,'fwEdit-editButton-fwRuID')]/a[contains(text(),'Edit')]")
	private WebElement nav_EditLink;
	
	//Not using in script. Because Delete will present in each row.
	@FindBy(how=How.XPATH,using="//section//table//tr[1]/td/table//span[contains(@id,'fwEdit-deleteButton-fwRuID')]/a[contains(text(),'Delete')]")
	private WebElement nav_DeleteLink;
	
	//Not used in any of the script and not sure which Cancel it is referring
	@FindBy(how=How.XPATH,using="//section//table//tr[1]/td/table//span[contains(@id,'fwEdit-cancelButton-fwRuID')]/a[contains(text(),'Cancel')]")
	private WebElement nav_CancelLink;

	//Not using in script. Because Save Edits will present in each row.
	@FindBy(how=How.XPATH,using="//section//table//tr[1]/td/table//span[contains(@id,'fwEdit-saveButton-fwRuID')]/a[contains(text(),'Save Edits')]")
	private WebElement nav_SaveEditsLink;
	
	@FindBy(how=How.XPATH,using="//div[contains(text(),'of ')]")
	private WebElement nav_NumberOfPagesText;
	
	 ////This object is updated on 10/01/2015 by QAA04
	@FindBy(how=How.XPATH,using="//div[contains(@id,'pagingtoolbar-')]//a[4]//span[contains(@id,'-btnIconEl')]")
	//@FindBy(how=How.XPATH,using="//span[contains(@class,'x-btn-icon-el x-tbar-page-next')]")
	private WebElement nav_PaginationNextButton;
 //#############################LEFCOURT####################################
	//@FindBy(how=How.XPATH,using="*//div[@id='content_vCloud']//a[Contains(text(),'ticket')]")
	@FindBy(how=How.LINK_TEXT,using="open a ticket")
	private WebElement nav_FirewallOpenTicket;
	
	@FindBy(how=How.ID,using="createTicketTitle-inputEl")
	private WebElement nav_FireWallTicketTitle;
	
	@FindBy(how=How.XPATH,using="//iframe[Contains(@id,'inputCmp-iframeEl')]")
	private WebElement nav_FireWallTicketNote;
	
	//Firewall- View
	//@FindBy(how=How.ID,using="info_firewall1")
	@FindBy(how=How.XPATH,using="*//div[@id='nav_org_list']//dd[@id='info_firewall1']/a")
	private WebElement nav_FirewallViewLink;
	
	@FindBy(how=How.XPATH,using="//span[@id='fwEdit-deleteButton-fwRuID-22-1']/a")
	private WebElement nav_FirewallRuleDeleteIcon;
	
	@FindBy(how=How.ID,using="navpopupbody")
	private WebElement nav_DeleteFirewallPopUp;
	
	@FindBy(how=How.XPATH,using="//div[@id='navpopupbuttons']/span/a[Contains(text(),'Ok')]")
	private WebElement nav_FirewallDeletePopUpOkBtn;
	
	@FindBy(how=How.XPATH,using="//div[@id='navpopupbuttons']//a[Contains(text(),'Cancel')]")
	private WebElement nav_FirewallDeletePopUpCancelBtn;
	
	
	///Added following from Addfirewall Page factory to here. By Sukur Babu. B Dated on 03/07/2016
	

@FindBy(how=How.ID,using="sequenceId-inputId")
private WebElement nav_AddFirewallSeqNumEdit;

@FindBy(how=How.ID,using="sourceType-inputId")
private WebElement nav_AddFirewallSourceTypeDropDown;

@FindBy(how=How.ID,using="sourceIp-inputId")
private WebElement nav_AddFirewallSourceIPEdit;

@FindBy(how=How.ID,using="sourceMask-inputId")
private WebElement nav_AddFirewallSourceMaskEdit;

@FindBy(how=How.ID,using="destinationType-inputId")
private WebElement nav_AddFirewallDestTypeDropDown;

@FindBy(how=How.ID,using="destinationIp-inputId")
private WebElement nav_AddFirewallDestIPEdit;

@FindBy(how=How.ID,using="destinationMask-inputId")
private WebElement nav_AddFirewallDestMaskEdit;

@FindBy(how=How.ID,using="serviceType-inputId")
private WebElement nav_AddFirewallServiceTypeDropDown;

@FindBy(how=How.ID,using="protocolId-inputId")
private WebElement nav_AddFirewallProtocolEdit;

@FindBy(how=How.ID,using="portName-inputId")
private WebElement nav_AddFirewallPortEdit;

@FindBy(how=How.ID,using="statusAnchor")
private WebElement nav_AddFirewallStatus;

@FindBy(how=How.ID,using="actionAnchor")
private WebElement nav_AddFirewallAction;

@FindBy(how=How.XPATH,using="//a[@id='fwEdit-actionAnchor-fwRuID-22-1']")
private WebElement nav_EditFirewallAction;

@FindBy(how=How.XPATH,using="//a[@id='saveAddFW']")
private WebElement nav_SaveFirewallRuleButton;

@FindBy(how=How.XPATH,using="//div[@id='navpopuptitle']")
private WebElement nav_AddFirewallRuleConfirmationWindow;	

@FindBy(how=How.ID,using="navpopupdiv")
private WebElement nav_FirewallConfirmWindow;

@FindBy(how=How.XPATH,using="//div[@id='navpopupbuttons']//a[contains(text(),'Ok')]")
private WebElement nav_FirewallConfirmWindowOKButton;

@FindBy(how=How.ID,using="sourceType-trigger-picker")
private WebElement nav_SourceTypeDropdownArrow;

@FindBy(how=How.ID,using="sourceIp-trigger-picker")
private WebElement nav_SourceDropdownArrow;

@FindBy(how=How.ID,using="sourceMask-trigger-picker")
private WebElement nav_SourceMaskDropdownArrow;

@FindBy(how=How.ID,using="destinationType-trigger-picker")
private WebElement nav_DestinationTypeDropdownArrow;

@FindBy(how=How.ID,using="destinationIp-trigger-picker")
private WebElement nav_DestinationDropdownArrow;

@FindBy(how=How.ID,using="destinationMask-trigger-picker")
private WebElement nav_DestinationMaskDropdownArrow;

@FindBy(how=How.ID,using="serviceType-trigger-picker")
private WebElement nav_ServiceTypeDropdownArrow;


@FindBy(how=How.ID,using="protocolId-trigger-picker")
private WebElement nav_ProtocolDropdownArrow;

@FindBy(how=How.XPATH,using="*//a[@id='fwEdit-statusAnchor-fwRuID-22-1']")
private WebElement nav_EditFirewallRuleStatus;

@FindBy(how=How.ID,using="navpopupmessage")
private WebElement nav_DeleteFirewallPopUpMsg;

@FindBy(how=How.XPATH, using = "//div[@id='navpopupbuttons']/span/a[Contains(text(),'Ok')]")
private WebElement nav_DeleteFirewallPopupOkBtn;

@FindBy(how=How.XPATH, using="//input[Contains(@id,'fwEdit-seqNum-inputId')]")
private WebElement nav_FirewallSeqNum;

@FindBy(how=How.ID, using="userfeedback")
private WebElement nav_EditSuccessMsg;

@FindBy(how=How.ID, using="//input[Contains(@id,'fwEdit-seqNum-inputId')]")
private WebElement nav_MoveSeqNum;

@FindBy(how=How.ID, using="fwEdit-sourceType-extId-22-1-inputWrap")
private WebElement nav_EditFirewallSourceTypeField;

@FindBy(how=How.ID, using="fwEdit-destinationType-inputId-22-1")
private WebElement nav_EditFirewallDestinationTypeField;

@FindBy(how=How.ID, using="fwEdit-sourceIp-inputId-22-1")
private WebElement nav_ServiceTypeField;

@FindBy(how=How.ID, using="fwEdit-protocol-inputId-22-1")
private WebElement nav_ProtocolPortField;

@FindBy(how=How.ID,using="fw_rules")
private WebElement nav_FireWallRulesTabField;

@FindBy(how=How.XPATH,using="//img[@alt='refresh vm']")
private WebElement nav_FireWallRefreshDetailsIcon;

@FindBy(how=How.XPATH, using="frPanel-13-body")
private WebElement nav_Interface1Table;

	//####################################################################
public WebElement getNav_Interface1Table() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_Interface1Table;
}

public WebElement getNav_FireWallRulesTabField() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_FireWallRulesTabField;
}

public WebElement getNav_FireWallRefreshDetailsIcon() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_FireWallRefreshDetailsIcon;
}

public WebElement getNav_ServiceTypeField() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_ServiceTypeField;
}

public WebElement getNav_ProtocolPortField() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_ProtocolPortField;
}

public WebElement getNav_EditFirewallSourceTypeField() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_EditFirewallSourceTypeField;
}

public WebElement getNav_EditFirewallDestinationTypeField() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_EditFirewallDestinationTypeField;
}


public WebElement getNav_SecondFirewallRuleExpander() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_SecondFirewallRuleExpander;
}

public WebElement getNav_MoveSeqNum() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_MoveSeqNum;
}

public WebElement getNav_EditSuccessMsg() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_EditSuccessMsg;
}

public WebElement getNav_FirewallSeqNum() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_FirewallSeqNum;
}

public WebElement getNav_DeleteFirewallPopUp() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_DeleteFirewallPopUp;
}

public WebElement getNav_DeleteFirewallPopUpMsg() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_DeleteFirewallPopUpMsg;
}

public WebElement getNav_DeleteFirewallPopupOkBtn() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_DeleteFirewallPopupOkBtn;
}
	
public WebElement getNav_EditFirewallAction() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_EditFirewallAction;
}

public WebElement getNav_EditFirewallRuleStatus() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_EditFirewallRuleStatus;
}

public WebElement getNav_ProtocolPortPopUPField() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_ProtocolPortPopUPField;
}

public WebElement getNav_FirewallConfirmWindow() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_FirewallConfirmWindow;
}

public WebElement getNav_FirewallConfirmWindowOKButton() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_FirewallConfirmWindowOKButton;
}

public WebElement getNav_SourceTypeDropdownArrow() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_SourceTypeDropdownArrow;
}

public WebElement getNav_DestinationDropdownField() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_DestinationDropDownField;
}

public WebElement getNav_SourceDropdownField() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_SourceDropDownField;
}

public WebElement getNav_SourceDropdownArrow() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_SourceDropdownArrow;
}

public WebElement getNav_SourceMaskDropdownArrow() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_SourceMaskDropdownArrow;
}

public WebElement getNav_DestinationTypeDropdownArrow() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_DestinationTypeDropdownArrow;
}

public WebElement getNav_DestinationDropdownArrow() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_DestinationDropdownArrow;
}

public WebElement getNav_DestinationMaskDropdownArrow() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_DestinationMaskDropdownArrow;
}

public WebElement getNav_ServiceTypeDropdownArrow() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_ServiceTypeDropdownArrow;
}

public WebElement getNav_ProtocolDropdownArrow() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_ProtocolDropdownArrow;
}
public WebElement getNav_AddFirewallSeqNumEdit() {
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFirewallSeqNumEdit;
	}

	public WebElement getNav_AddFirewallSourceTypeDropDown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFirewallSourceTypeDropDown;
	}

	public WebElement getNav_AddFirewallSourceIPEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFirewallSourceIPEdit;
	}

	public WebElement getNav_AddFirewallSourceMaskEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFirewallSourceMaskEdit;
	}

	public WebElement getNav_AddFirewallDestTypeDropDown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFirewallDestTypeDropDown;
	}

	public WebElement getNav_AddFirewallDestIPEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFirewallDestIPEdit;
	}

	public WebElement getNav_AddFirewallDestMaskEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFirewallDestMaskEdit;
	}

	public WebElement getNav_AddFirewallServiceTypeDropDown() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFirewallServiceTypeDropDown;
	}

	public WebElement getNav_AddFirewallProtocolEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFirewallProtocolEdit;
	}

	public WebElement getNav_AddFirewallPortEdit() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFirewallPortEdit;
	}

	public WebElement getNav_AddFirewallStatus() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFirewallStatus;
	}

	public WebElement getNav_AddFirewallAction() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFirewallAction;
	}

	public WebElement getNav_SaveFirewallRuleButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SaveFirewallRuleButton;
	}

	public WebElement getNav_AddFirewallRuleConfirmationWindow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFirewallRuleConfirmationWindow;
	}


	public WebElement getNav_FirewallDeletePopUpCancelBtn(){
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FirewallDeletePopUpCancelBtn;
			}
	
	public WebElement getNav_FirewallDeletePopUpOkBtn(){
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FirewallDeletePopUpOkBtn;
			}
	
	public WebElement getNav_FirewallRuleDeleteIcon(){
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FirewallRuleDeleteIcon;
			}
		
	
	public WebElement getNav_FirewallViewLink(){
	FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
	return nav_FirewallViewLink;
		}
	
	
	//######################## MNR ##################################################
	
	@FindBy(how=How.XPATH,using="//div[@id='firewall_gom_button']//a")
	private WebElement nav_GOMLink;
	
	@FindBy(how=How.ID, using="gom-nw-ei")
	private WebElement nav_NetworkObjectExpander;
	
	@FindBy(how=How.XPATH, using="//div[@id='gom_nw_tree_panel-body']//img[contains(@class,'x-tree-expander')]")
	private WebElement nav_NetworkExpander;
	
	
	
	
	public WebElement getNav_FirewallTicketNote() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FireWallTicketNote;
	}
	public WebElement getNav_FirewallOpenTicket() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FirewallOpenTicket;
	}
		
	
	
	//####################################################################
	
	
	public WebElement getNav_EVDCPortalLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EVDCPortalLink;
	}
	public WebElement getNav_FirewallLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FirewallLink;
	}
	public WebElement getNav_FirewallTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FirewallTable;
	}
	public WebElement getNav_AddFireWallLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFireWallLink;
	}
	public WebElement getNav_AddFireWallWindow() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddFireWallWindow;
	}
	public WebElement getNav_SequenceNumber() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SequenceNumber;
	}
	public WebElement getNav_SourceDropDownIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SourceDropDownIcon;
	}
	public WebElement getNav_DestinationDownIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DestinationDownIcon;
	}
	public WebElement getNav_ProtocolDownIcon() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ProtocolDownIcon;
	}
	public WebElement getNav_SourceList() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SourceList;
	}
	public WebElement getNav_DestinationList() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DestinationList;
	}
	public WebElement getNav_ProtocolList() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_ProtocolList;
	}
	public WebElement getNav_FirewallSaveButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FirewallSaveButton;
	}
	public WebElement getNav_FirewallRuleTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FirewallRuleTable;
	}
	public WebElement getNav_SequenceNumberinFirewallRuleTable() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SequenceNumberinFirewallRuleTable;
	}
	public WebElement getNav_MoveLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_MoveLink;
	}
	public WebElement getNav_EditLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_EditLink;
	}
	public WebElement getNav_DeleteLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DeleteLink;
	}
	public WebElement getNav_CancelLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CancelLink;
	}
	public WebElement getNav_SaveEditsLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SaveEditsLink;
	}
	
	public WebElement getNav_NumberOfPagesText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NumberOfPagesText;
	}

	public WebElement getNav_PaginationNextButton() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_PaginationNextButton;
	}
	
	public WebElement getNav_RulesCountText() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_RulesCountText;
	}
	public WebElement getNav_FireWallTicketTitle() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FireWallTicketTitle;
	}
	public WebElement getNav_FireWallTicketNote() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FireWallTicketNote;
	}
	public WebElement getNav_GOMLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_GOMLink;
	}
	public WebElement getNav_NetworkObjectExpander() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NetworkObjectExpander;
	}
	public WebElement getNav_NetworkExpander() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NetworkExpander;
	}
	public WebElement getNav_FirstFirewallRuleExpander() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_FirstFirewallRuleExpander;
	}

	public WebElement getNav_CreateTicketLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_CreateTicketLink;
	}

	public WebElement getNav_SourceDropDownField() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SourceDropDownField;
	}

	public WebElement getNav_DestinationDropDownField() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_DestinationDropDownField;
	}

	public WebElement getNav_SiteToSiteVpnTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_SiteToSiteVpnTab;
	}

	public WebElement getNav_AddSiteToSiteVpnLink() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_AddSiteToSiteVpnLink;
	}

	public WebElement getNav_NATsTab() {
		FrameworkUtil.sElementName = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nav_NATsTab;
	}

	
	
	
}
