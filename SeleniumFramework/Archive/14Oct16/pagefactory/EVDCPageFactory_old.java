package com.whs.navigator.pagefactory;

import org.openqa.selenium.support.How;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.whs.navigator.commonUtil.FrameworkUtil;

public class EVDCPageFactory_old 
{
	
	//String sEVDCName = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.NAME");
	
	
	
	//Table
	@FindBy(how=How.XPATH,using="//table[@id='gridview-1010-table']/tbody")
	private WebElement nav_navVMTable;
	
	
	
	
	
	//This Element is created on 10/08/2015 for EXTJS5 by QAA03
	

	

//================================================================================
	//EVDC Virtual Machine
//================================================================================

	
	
	
	@FindBy(how=How.XPATH,using="//*[@id='headercontainer-1009-innerCt']")
	private WebElement nav_VMTabList;
	
	@FindBy(how=How.XPATH,using="//*[@id='vmListExtGridPanel-body']/div/table/tbody/tr")
	private WebElement nav_TableRnd;
	
	@FindBy(how=How.XPATH,using="//*[@id='vmListExtGridPanel-body']/div/table/colgroup")
	private WebElement nav_TableColRnD;
	
	
	
	
	
	
	
//###########################
//Verifying Start - Stop - Reset message
//###########################
	//@FindBy(how=How.XPATH,using="/html/body/div[9]/div/div")
	//private WebElement nav_PopUpMsg;
	

	
	
	
	
	
	
	
	
	
	
	//###############################################################################
	//###############################################################################
	
		}
	

