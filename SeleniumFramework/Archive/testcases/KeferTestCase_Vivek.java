package com.whs.navigator.testcases;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.CustomWebElementUtil;
import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.EntityBrowserPageFactory;
import com.whs.navigator.pagefactory.HomePageFactory;

public class KeferTestCase_Vivek {
	
	
	
	public static EntityBrowserPageFactory EBPanel = new EntityBrowserPageFactory();
	public static EVDC_OverviewPageFactory EVDC_Overview=new EVDC_OverviewPageFactory();
	public static HomePageFactory Home=new HomePageFactory();
	
	
	/*==============================================================
	TestScript 		: verChildEntityNotClickable
	Manual TestCase	: Keffer-QAT-372-WCP_3659_TC_1.0_Roll Up_EVDC overview page
	Description		: When roll up flag is ON, verify Child entity EVDC name is not clickable and VDC link is not displayed in the EVDC table.
	Author 			: Vivek Kumar
	Creation Date 	: 12/23/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=1)
	public void verChildEntityNotClickable()
	{
		
		WebDriver driver =WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EBPanel);
		PageFactory.initElements(driver, EVDC_Overview);
		
		String sUserName,sPassword;
		
		
		try {
			FrameworkUtil.sTestCaseName ="verChildEntityNotClickable";
			FrameworkUtil.sManualTestCaseName="Keffer-QAT-372-WCP_3659_TC_1.0_Roll Up_EVDC overview page";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.USERID");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.PASSWORD");
			
			//Login to navigator
			LoginTestCase.nav_Login(sUserName, sPassword);
			
			
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			//WebObjectUtil.clickElement(EBPanel.getNav_entityBrowserLink());
			EntityBrowserTestCase.selectOrgFromAllLevelsEB("TST Entity01", null, null, null);
			EntityBrowserTestCase.arrOrgNameFromEBPanel=EntityBrowserTestCase.getChildOrgNameListFromEBPanel(2);
			
			//Verifying that Parent entity should have link and Child should not have link	
			verParentChildEntityLink(true,false);
			//Logout
			LoginTestCase.nav_Logout();
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
	}
	
	/*==============================================================
	TestScript 		: verImmediateParent
	Manual TestCase	: Keffer-QAT-371WCP_1303_TC_1.5_RollUp_EVDCs table_shows immediate parent_name is clickable_vCloud Director link
					  QAT-357-WCP_3726_TC_1.0_RollUp EVDC_User Permissions_Role-A
	Description		: Verify the Parent column shows the immediate parent for that entity in that row
	Author 			: Vivek Kumar
	Creation Date 	: 12/29/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=2)
	public static void verImmediateParent()
	{
		
		
		
		WebDriver driver =WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EBPanel);
		PageFactory.initElements(driver, EVDC_Overview);
		
		String sUserName,sPassword;
		 int iRowCnt;
		String sEVDCName,sEVDCParent,sArrEVDCName = null,sArrEVDCParent = null;
		
		String[] arrEVDC_Entity_List;
		String[] arrEVDCInfo = null;
		boolean bFlag;
		
		
		
			FrameworkUtil.sTestCaseName ="verImmediateParent";
			FrameworkUtil.sManualTestCaseName="Keffer-QAT-371,357-WCP_1303_TC_1.5_RollUp_EVDCs table_shows immediate parent_name is clickable_vCloud Director link";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			//Setting the Child entity for TST ENTITY
			AdminTestCase.verifyTstEntityParentChildHierarchy();
			
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.USERID");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.PASSWORD");
			
			
			//Login to navigator
			LoginTestCase.nav_Login(sUserName, sPassword);
			
			
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			EntityBrowserTestCase.selectOrgFromAllLevelsEB("TST Entity01", null, null, null);
			//Verifying that Parent entity should have link and Child should not have link	
			verParentChildEntityLink(true,true);	
			//Back to main entity
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			EntityBrowserTestCase.setRollOnOffEBPanel(false);
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			WebObjectUtil.explicitWait(5);
			
			//Getting the EVDC Name along with their parent entity into array
			arrEVDC_Entity_List=EntityBrowserTestCase.getEVDCNameWithEntityName("TST Entity01",null,null,null);
		
			//Loading the EVDC View table
			CustomWebElementUtil.loadCustomElement(EVDC_Overview.getNav_EVDCViewHomeTable(), "table");
			iRowCnt=CustomWebElementUtil.iRowCount;
			
			//Verifying the available EVDC name with their Parent Entity
			for(int i=1;i<=iRowCnt;i++)
			{
				sEVDCName=CustomWebElementUtil.getCellData(i, 1).toLowerCase();
				sEVDCParent=CustomWebElementUtil.getCellData(i, 2).toLowerCase();
				bFlag=false;
			//==========================================	
				//for (String sEVDC :arrEVDC_Entity_List )
				for(int j=1;j<arrEVDC_Entity_List.length;j++)
				{
					arrEVDCInfo=arrEVDC_Entity_List[j].split("!P!");
					//Capturing EVDC name from Array
					sArrEVDCName=arrEVDCInfo[0];
					sArrEVDCName=sArrEVDCName.toLowerCase().trim();
					//Capturing EVDC- Parent entity from an array
					sArrEVDCParent=arrEVDCInfo[1];
					sArrEVDCParent=sArrEVDCParent.toLowerCase().trim();
					//Comparing the value from array with the value present at Home page under EVDC View Table
					if(sEVDCName.equals(sArrEVDCName) && sEVDCParent.equals(sArrEVDCParent) )
					{
						bFlag=true;
						break;
					}
				}
				//Based on Flag - Printing the result
				FrameworkUtil.updateCustomResultBasedOnStatus(bFlag, "Verified - EVDC Name - "+sArrEVDCName + ", Parent Entity - "+sArrEVDCParent);
			}
			
			//Verifying the EVDC View Table header
			verifyEVDCViewTableHeader();
		
			//Logout
			LoginTestCase.nav_Logout();
		}
	
	
	
	/*==============================================================
	TestScript 		: verifyEVDCViewTablePagination
	Manual TestCase	: Keffer-QAT-370-WCP_1303_TC_1.1_Rollup_View EVDCs_five per page_pagination after five EVDCs
	Description		: To verify pagination will be there if more than 5 EVDc are there
	Author 			: Vivek Kumar
	Creation Date 	: 01/05/2016
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=3)
	public static void verifyEVDCViewTablePagination()
	{
		WebDriver driver =WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EBPanel);
		

		String sUserName,sPassword;
		
		FrameworkUtil.sTestCaseName ="verifyEVDCViewTablePagination";
		FrameworkUtil.sManualTestCaseName="Keffer-QAT-370-WCP_1303_TC_1.1_Rollup_View EVDCs_five per page_pagination after five EVDCs";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.USERID");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.PASSWORD");
		
		
		//Login to navigator
		LoginTestCase.nav_Login(sUserName, sPassword);
		//Clicking on EB link		
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		//turning RollUp Button ON
		EntityBrowserTestCase.setRollOnOffEBPanel(true);
		
		//Clicking on EB Title link
		WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
		//Verifying Pagination
		verifyEVDCViewPagination();
		//Login out
		LoginTestCase.nav_Logout();
		
	}
	
	
	/*==============================================================
	TestScript 		: verifyEVDCLinkAndVCldNotThere
	Manual TestCase	: Keffer-QAT-367WCP_3726_TC_1.2_RollUp EVDC_User Permissions_Role-E
	Description		: Login to navigator with full service observer role (Role-E) and verify new roll up view EVDC table. Verify this user is able to go to EVDC overview page for his org only. Child entity EVDCs links are disabled. 
					  vCloud Director link is not available for all EVDCs as this user doesn't have permissions.
	Author 			: Vivek Kumar
	Creation Date 	: 01/05/2016
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=4)
	public void verifyEVDCLinkAndVCldNotThere()
	{
		
		WebDriver driver =WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EBPanel);
		PageFactory.initElements(driver, EVDC_Overview);
		
		String sUserName,sPassword;
		
		
		try {
			FrameworkUtil.sTestCaseName ="verifyEVDCLinkAndVCldNotThere";
			FrameworkUtil.sManualTestCaseName="Keffer-QAT-367WCP_3726_TC_1.2_RollUp EVDC_User Permissions_Role-E";
			FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
			
			sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEE.USERID");
			sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.ROLEE.PASSWORD");
			
			//Login to navigator
			LoginTestCase.nav_Login(sUserName, sPassword);
			
			
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			//WebObjectUtil.clickElement(EBPanel.getNav_entityBrowserLink());
			EntityBrowserTestCase.selectOrgFromAllLevelsEB("TST Entity01", null, null, null);
			//EntityBrowserTestCase.arrOrgNameFromEBPanel=EntityBrowserTestCase.getChildOrgNameListFromEBPanel(2);
			
			//Verifying that Parent entity should have link and Child should not have link	
			verParentChildEntityLink(true,false);
			
			//Verifying VCloud link should not be there for ROLE E
			verifyVCldLnkNotThere();
			//Logout
			LoginTestCase.nav_Logout();
		} catch (Exception e)
		{
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");	
		}
	}
	
	/*==============================================================
	TestScript 		: verifyParentEntityDoesntHaveEVDCAndChildHave
	Manual TestCase	: Keffer-QAT-362-WCP_1303_TC_3.2_Rollup_EVDC in table format_Parent entity doesn't have EVDCs_Child entities do
	Description		: When Roll Up Flag is ON, and Parent entity doesn't have any EVDCs but Child entities do, Verify EVDCs are displayed in a table format for the child entities.
	Author 			: Vivek Kumar
	Creation Date 	: 01/06/2016
	Pre-Requisites	:For this Test Case, Please use the following entities: 
						(Tst Entity01 and Tst Entity02 have EVDCs, RootLevelCascadeOrg doesn't have any EVDCs) 
						Tst Entity01 is a child entity of RootLevelCascadeOrg, 
						Tst Entity02 is a child entity of RootLevelCascadeOrg
	Revision History:
	==============================================================*/
	@Test(priority=5)
	public static void verifyParentEntityDoesntHaveEVDCAndChildHave()
	{
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EBPanel);
				
		String sEVDCName,sEVDCParent,sArrEVDCName = null,sArrEVDCParent = null;
		
		String[] arrEVDC_Entity_List;
		String[] arrEVDCInfo = null;
		boolean bFlag;
		int iRowCnt;
		
		String sUserName,sPassword;
		
		FrameworkUtil.sTestCaseName ="verifyParentEntityDoesntHaveEVDCAndChildHave";
		FrameworkUtil.sManualTestCaseName="Keffer-QAT-362-WCP_1303_TC_3.2_Rollup_EVDC in table format_Parent entity doesn't have EVDCs_Child entities do";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		//Setting the Child entity for RootLevelCascadeOrg
		AdminTestCase.verifyParentChildEntity("TST Entity01", "RootLevelCascadeOrg");
		AdminTestCase.verifyParentChildEntity("TST Entity02", "RootLevelCascadeOrg");
		
		//Login to application
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.USERID");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.PASSWORD");
		
		//Login to navigator
		LoginTestCase.nav_Login(sUserName, sPassword);
		
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		/*//EntityBrowserTestCase.selectOrgFromAllLevelsEB("RootLevelCascadeOrg", null, null, null);
		//Verifying that Parent entity should have link and Child should not have link	
		verParentChildEntityLink(true,true);	
		//Back to main entity
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		EntityBrowserTestCase.setRollOnOffEBPanel(false);
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		WebObjectUtil.explicitWait(5);
		
		*/
		//Getting the EVDC Name along with their parent entity into array
		arrEVDC_Entity_List=EntityBrowserTestCase.getEVDCNameWithEntityName("RootLevelCascadeOrg",null,null,null);

		//Loading the EVDC View table
		CustomWebElementUtil.loadCustomElement(EVDC_Overview.getNav_EVDCViewHomeTable(), "table");
		//CustomWebElementUtil.loadCustomElement(EVDC_Overview.getNav_EVDCViewHomeTable(), "table");
		iRowCnt=CustomWebElementUtil.iRowCount;
		
		//Verifying the available EVDC name with their Parent Entity
		for(int i=1;i<=iRowCnt;i++)
		{
			sEVDCName=CustomWebElementUtil.getCellData(i, 1).toLowerCase();
			sEVDCParent=CustomWebElementUtil.getCellData(i, 2).toLowerCase();
			bFlag=false;
		//==========================================	
			//for (String sEVDC :arrEVDC_Entity_List )
			for(int j=0;j<arrEVDC_Entity_List.length;j++)
			{
				arrEVDCInfo=arrEVDC_Entity_List[j].split("!P!");
				//Capturing EVDC name from Array
				sArrEVDCName=arrEVDCInfo[0];
				sArrEVDCName=sArrEVDCName.toLowerCase().trim();
				//Capturing EVDC- Parent entity from an array
				sArrEVDCParent=arrEVDCInfo[1];
				sArrEVDCParent=sArrEVDCParent.toLowerCase().trim();
				//Comparing the value from array with the value present at Home page under EVDC View Table
				if(sEVDCName.equals(sArrEVDCName) && sEVDCParent.equals(sArrEVDCParent) )
				{
					bFlag=true;
					break;
				}
			}
			//Based on Flag - Printing the result
			FrameworkUtil.updateCustomResultBasedOnStatus(bFlag, "Verified - EVDC Name - "+sArrEVDCName + ", Parent Entity - "+sArrEVDCParent);
		}
		//Logout
		LoginTestCase.nav_Logout();
	}
	
	
	/*==============================================================
	TestScript 		: verifyEVDCFormatAndColumns
	Manual TestCase	: QAT-338-WCP_1303_TC_1.2_RollUp_EVDCs in table format_Verify Columns
					  QAT-340-WCP_1303_TC_1.4_RollUp_EVDCs in table format_Sort by any column
					  QAT-350-WCP_1303_TC_1.0_RollUp_View EVDCs in table format
					  QAT-366-WCP_1303_TC_1.3_RollUp_EVDCs in table format_view PDF and CSV reports
	Description		: EVDCs are correctly displayed in table format for 'tst entity02 and tst entity03' with the following columns:
	 				  Name, Parents, VM Count, Networks, vCPUs, vRAM, and Storage.
	 				  vCloud Director links are displayed next to Storage column
	Author 			: Vivek Kumar
	Creation Date 	: 01/12/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=6)
	public void verifyEVDCFormatAndColumns()
	{
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EBPanel);
		PageFactory.initElements(driver, EVDC_Overview);
		
		String sUserName,sPassword;
		
		FrameworkUtil.sTestCaseName ="verifyEVDCFormatAndColumns";
		FrameworkUtil.sManualTestCaseName="QAT-338,340,350,366-WCP_1303_TC_1.2_RollUp_EVDCs in table format_Verify Columns";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		//Setting the Child entity for TST ENTITY
		AdminTestCase.verifyTstEntityParentChildHierarchy();
		
		//Login to application
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.USERID");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.PASSWORD");
		
		//Login to navigator
		LoginTestCase.nav_Login(sUserName, sPassword);
	
		//Clicking on Entity Browser Link
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		
		
		//Selecting Organization from First Level and Second Level Children
		EntityBrowserTestCase.selectOrgFromAllLevelsEB("TST Entity01","TST Entity02", "", "");
		
		//Clicking on Entity browser tab
		WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
		
		//Getting the EVDC Names of both Parent and child entity Selected in an array		
		String sChildEVDCArray[] =KefferTestCase_Arul.getEVDCNameforEntityAndItsChild("TST Entity02");
		
			
		//Clicking on Entity Browser Link to navigate to Parent - .HostedSolutions 
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		
		//Clicking on Entity Browser Link
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		
		//Selecting Org from First Level and setting Rollup flag button "ON" and selecting org from Second Level Children
		EntityBrowserTestCase.selectOrgFromAllLevelsEB("TST Entity01","TST Entity02", "", "",1,true);
		
		//Clicking on Entity browser tab
		WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
		
		//Verifying EVDC names of array in the Home Page
		KefferTestCase_Arul.verifyEVDCnameForEntityAndItsChild(sChildEVDCArray);
	
		 //Verify PDF reports
        WebObjectUtil.verifyElementPresent(EVDC_Overview.getNav_EVDCViewPDFIcon());
        //Verify CSV reports
        WebObjectUtil.verifyElementPresent(EVDC_Overview.getNav_EVDCViewCSVIcon());
	
		
		//Verifying the EVDC View Table header
		verifyEVDCViewTableHeader();
	
		//Logout
		LoginTestCase.nav_Logout();
		
	}
	
	/*==============================================================
	TestScript 		: verifyStaticImgForNoEVDC
	Manual TestCase	: QAT-343-WCP_1303_TC_3.0_Rollup_EVDC in table format_No EVDCs
	Description		: A Static image is displayed since these entities (parent and child) don't have any EVDCs
	Author 			: Vivek Kumar
	Creation Date 	: 01/13/2015
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=7)
	public void verifyStaticImgForNoEVDC()
	{
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EBPanel);
		PageFactory.initElements(driver, EVDC_Overview);
		
		String sUserName,sPassword;
		
		FrameworkUtil.sTestCaseName ="verifyStaticImgForNoEVDC";
		FrameworkUtil.sManualTestCaseName="QAT-343-WCP_1303_TC_3.0_Rollup_EVDC in table format_No EVDCs";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		//Setting the Child entity for RootLevelCascadeOrg
		//AdminTestCase.verifyParentChildEntity("Level1OrgA", "RootLevelCascadeOrg");
		
		LoginTestCase.LoginAsIshannonUser();
		AdminTestCase.verifyOrg("Level1OrgA", "RootLevelCascadeOrg");
		AdminTestCase.verifyOrg("Level2CascadeOrgA", "Level1OrgA");
		AdminTestCase.verifyOrg("Level3CascadeOrgA", "Level2CascadeOrgA");
		AdminTestCase.verifyOrg("Level4CascadeOrgA", "Level3CascadeOrgA");
		LoginTestCase.nav_Signout();
		
		//Login to application
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.USERID");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.HOSTEDSOLUTIONS.PASSWORD");
		
		//Login to navigator
		LoginTestCase.nav_Login(sUserName, sPassword);
	
		//Clicking on Entity Browser Link
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		
		
		//Selecting Organization from First Level and Second Level Children
		EntityBrowserTestCase.selectOrgFromAllLevelsEB("RootLevelCascadeOrg","Level1OrgA", "", "");
		
		//Clicking on Entity browser tab
		WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
		
		//Getting the EVDC Names of both Parent and child entity Selected in an array		
		//String sChildEVDCArray[] =KefferTestCase_Arul.getEVDCNameforEntityAndItsChild("Level1OrgA");
		WebObjectUtil.verifyElementPresent(EVDC_Overview.getNav_EVDCImage());
			
		//Clicking on Entity Browser Link to navigate to Parent - .HostedSolutions 
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		
		//Clicking on Entity Browser Link
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		
		//Selecting Org from First Level and setting Rollup flag button "ON" and selecting org from Second Level Children
		EntityBrowserTestCase.selectOrgFromAllLevelsEB("RootLevelCascadeOrg","Level1OrgA", "", "",1,true);
		
		//Clicking on Entity browser tab
		WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
		
		//Verifying EVDC names of array in the Home Page
		//KefferTestCase_Arul.verifyEVDCnameForEntityAndItsChild(sChildEVDCArray);
		
		//Need to add line to validate image
		//--------------------not seeing any image if it is roll on-------------------
		WebObjectUtil.verifyElementPresent(EVDC_Overview.getNav_EVDCImage());
	
		//Logout
		LoginTestCase.nav_Logout();
		
		LoginTestCase.LoginAsIshannonUser();
		AdminTestCase.verifyOrg("RootLevelCascadeOrg", ".Hosted Solutions");
		AdminTestCase.verifyOrg("Level1OrgA", ".Hosted Solutions");
		AdminTestCase.verifyOrg("Level2CascadeOrgA", ".Hosted Solutions");
		AdminTestCase.verifyOrg("Level3CascadeOrgA", ".Hosted Solutions");
		AdminTestCase.verifyOrg("Level4CascadeOrgA", ".Hosted Solutions");
		LoginTestCase.nav_Signout();
		
	}
	
	
	
	/*==============================================================
	TestScript 		: verifyEVDCTableAndChildNotClickable
	Manual TestCase	: Keffer_QAt-356-WCP_3726_TC_1.1_RollUp EVDC_User Permissions_Role-C
	Description		: Scroll down to EVDC table and verify child EVDC name is not displayed as a clickable link and VCD link is not available for child EVDC
	Author 			: Vivek Kumar
	Creation Date 	: 01/13/2016
	Pre-Requisites	:
	Revision History:
	==============================================================*/
	@Test(priority=8)
	public void verifyEVDCTableAndChildNotClickable()
	{
		
		WebDriver driver =WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EBPanel);
		PageFactory.initElements(driver, EVDC_Overview);
		
		String sUserName,sPassword;
			
		
		FrameworkUtil.sTestCaseName ="verifyEVDCTableAndChildNotClickable";
		FrameworkUtil.sManualTestCaseName="Keffer_QAT-356-WCP_3726_TC_1.1_RollUp EVDC_User Permissions_Role-C";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		//Setting the Child entity for TST ENTITY
		AdminTestCase.verifyTstEntityParentChildHierarchy();
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.CROLE");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.CROLE");
		
		
		//Login to navigator
		LoginTestCase.nav_Login(sUserName, sPassword);
		
		
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		EntityBrowserTestCase.selectOrgFromAllLevelsEB("TST Entity01", null, null, null);
		//Verifying that Parent entity should have link and Child should not have link	
		verParentChildEntityLink(true,true);	
		
		 
        //Verify PDF reports
        WebObjectUtil.verifyElementPresent(EVDC_Overview.getNav_EVDCViewPDFIcon());
        //Verify CSV reports
        WebObjectUtil.verifyElementPresent(EVDC_Overview.getNav_EVDCViewCSVIcon());
	
	
		//Logout
		LoginTestCase.nav_Logout();
		
		
	}
	
	
	//################################################################################################
	//METHODS
	//################################################################################################
	/*====================================================================================================
	Method Name 	: verifyEVDCViewPagination
	Description		: it will verify the pagination
	Author 			: Vivek Kumar
	Creation Date 	: 01/05/2016
	Pre-Requisites	:
	Revision History:
	=====================================================================================================*/
	public static void verifyEVDCViewPagination()
	{
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_Overview);
				
		String sTotalPageNumber,sFrstPgEVDC,sSecondPgEVDC;
		int iRowCnt,iTotalPageNumber;
		
		try {
			//Loading the EVDC View table
			CustomWebElementUtil.loadCustomElement(EVDC_Overview.getNav_EVDCViewHomeTable(), "table");
			iRowCnt=CustomWebElementUtil.iRowCount;
			
			sTotalPageNumber=EVDC_Overview.getNav_EVDCViewTotalPage().getText();
			sTotalPageNumber=sTotalPageNumber.replace("of ", "");
			iTotalPageNumber=Integer.parseInt(sTotalPageNumber);
			
			if(iRowCnt==5)
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "EVDC count" , "Verifying EVDC Count", "pass", "EVDC count is 5");
				if(iTotalPageNumber>1)
				{
					sFrstPgEVDC=CustomWebElementUtil.getCellData(1, 1);
					WebObjectUtil.clickElement(EVDC_Overview.getNav_EVDCViewPageNextBtn());
					WebObjectUtil.explicitWait(2);
					
					//Loading the EVDC View table
					CustomWebElementUtil.loadCustomElement(EVDC_Overview.getNav_EVDCViewHomeTable(), "table");
					sSecondPgEVDC=CustomWebElementUtil.getCellData(1, 1);
					
					if(!(sFrstPgEVDC.equals(sSecondPgEVDC)))
					{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Comparing EVDC" , "Verifying EVDC name from 1st page and 2nd page", "pass", "EVDC from 1st Page - "+sFrstPgEVDC + "/ EVDC from 2nd page - "+ sSecondPgEVDC);
					}
					else
					{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Comparing EVDC" , "Verifying EVDC name from 1st page and 2nd page", "fail", "EVDC from 1st Page - "+sFrstPgEVDC + "/ EVDC from 2nd page - "+ sSecondPgEVDC);
					}
				}
				else
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Comparing EVDC" , "Verifying EVDC Count", "pass", "EVDC count is less than or equal to 5, so Total page is "+iTotalPageNumber);	
				}
			}
			else
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "EVDC count" , "Verifying EVDC Count", "pass", "EVDC count is "+iRowCnt);
			}
		} catch (NumberFormatException e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
	}
	
	/*====================================================================================================
	Method Name 	: verifyEVDCViewTableHeader
	Description		: it will verify the header of EVDC View Table
	Author 			: Vivek Kumar
	Creation Date 	: 01/04/2016
	Pre-Requisites	:
	Revision History:
	=====================================================================================================*/
	public static void verifyEVDCViewTableHeader()
	{
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_Overview);
		
		try {
			WebObjectUtil.verifyElementPresent(EVDC_Overview.getNav_EVDCViewNameTab());
			WebObjectUtil.verifyElementPresent(EVDC_Overview.getNav_EVDCViewParentTab());
			WebObjectUtil.verifyElementPresent(EVDC_Overview.getNav_EVDCViewParentTab());
			WebObjectUtil.verifyElementPresent(EVDC_Overview.getNav_EVDCViewStorageTab());
			WebObjectUtil.verifyElementPresent(EVDC_Overview.getNav_EVDCViewNetworksTab());
			WebObjectUtil.verifyElementPresent(EVDC_Overview.getNav_EVDCViewvCPUsTab());
			WebObjectUtil.verifyElementPresent(EVDC_Overview.getNav_EVDCViewvRAMTab());
			WebObjectUtil.verifyElementPresent(EVDC_Overview.getNav_EVDCViewVMCountTab());
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
	}
	
	
	/*====================================================================================================
	Method Name 	: verParentChildEntityLink
	Description		: to verify that Parent Entity have link and Child entity should not have link
	Author 			: Vivek Kumar
	Creation Date 	: 12/29/2015
	Pre-Requisites	: Roll flag should be in OFF mode.
					click on the Entity browser link and then select the parent
					For example 
					WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
					EntityBrowserTestCase.selectOrgFromAllLevelsEB("TST Entity01", null, null, null);
	Revision History:
	=====================================================================================================*/
	public static void verParentChildEntityLink(boolean bVerifyEVDCLink, boolean bVerifyVCloudLink)
	{
		WebDriver driver= WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EBPanel);
		PageFactory.initElements(driver, EVDC_Overview);
		PageFactory.initElements(driver, Home);
		
		String sEVDCNameRunnTime = null,sCurrentEntityName;
		String OrgName,sLink,sVerifyVCLDTitle;
		int iRowCnt;
		WebElement wEVDCName,wEVDCvCLD;
		
		 sVerifyVCLDTitle=(String) FrameworkUtil.dictPropertyData.get("NAV.VCLOUD.TITLE");
		
		try {
			
			sCurrentEntityName = EBPanel.getNav_EntityBrowserLink().getText();
			 if (!sCurrentEntityName.equalsIgnoreCase("Back to your Entity")){
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			}
			 
			//Clicking on EBPanel Tab
			WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
					
			EVDC_VM_TestCase.getEVDCNameAsWebElement(" ");
			for (WebElement wEVDC : WebObjectUtil.webElementsList)
			{
				//concatinating the EVDC name with ##
				sEVDCNameRunnTime = sEVDCNameRunnTime+"##"+wEVDC.getText();
				
			}
			//Converting EVDC name into Lower case
			sEVDCNameRunnTime=sEVDCNameRunnTime.toLowerCase();
			
			//Clicking on Entity Browsre link
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			
			//turning RollUp Button ON
			//WebObjectUtil.clickElement(EBPanel.getNav_EBPanelRollUpButton());
			EntityBrowserTestCase.setRollOnOffEBPanel(true);
			
			//Clicking on EBPanel Tab
			WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
			
			//Loading the EVDC View table
			CustomWebElementUtil.loadCustomElement(EVDC_Overview.getNav_EVDCViewHomeTable(), "table");
			iRowCnt=CustomWebElementUtil.iRowCount;
			
			
			String HandleBefore = driver.getWindowHandle();
			for(int i=1;i<=iRowCnt;i++)
			{
				CustomWebElementUtil.loadCustomElement(EVDC_Overview.getNav_EVDCViewHomeTable(), "table");
				 OrgName=CustomWebElementUtil.getCellData(i, 1).toLowerCase();
				 sLink = (String) FrameworkUtil.dictDynamicPagePactory.get("NAV.EVDCVIEWTABLE.LINK");
				 sLink = sLink.replace("PARAMETER_ROWNUMBER", i+"");
				
				 
				 //Getting the link list for each row
				List<WebElement> wLinkList= driver.findElements(By.xpath(sLink));
				//System.out.println(wLinkList.size());
				//Checking the link count for each row
				if (wLinkList.size() > 0) 
				{
					
					if(sEVDCNameRunnTime.contains(OrgName))
					{
						
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "EVDC Name", "Verifying EVDC Link for Parent Entity", "pass", "EVDC Link verified  - "+OrgName);
						
						if(bVerifyEVDCLink)
						{
							wEVDCName = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.EVDCVIEWTABLE.EVDC", "PARAMETER_ROWNUMBER", i+"");
							WebObjectUtil.clickAndVerifyElement(wEVDCName, EVDC_Overview.getNav_EVDCOverviewVirtualMachine());
							//driver.navigate().back();
							WebObjectUtil.clickElement(Home.getNav_HomeBreadcrumb());
							WebObjectUtil.explicitWait(3);
						}
						
						if(bVerifyVCloudLink)
						{
						   wEVDCvCLD=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.EVDCVIEWTABLE.VCLOUD", "PARAMETER_ROWNUMBER", i+"");
						   WebObjectUtil.clickElement(wEVDCvCLD);
						   WebObjectUtil.switchToWindow(1, sVerifyVCLDTitle);
						   WebObjectUtil.explicitWait(5);
						   driver.close();
						  // WebObjectUtil.switchToParentWindow();
						   driver.switchTo().window(HandleBefore);
						   WebObjectUtil.explicitWait(3);
						}
					   
					   
					}
					else
					{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "EVDC Name", "Verifying EVDC Link for Parent Entity", "fail", "EVDC Link not verified - "+OrgName);
					}
				}
				else
				{
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "EVDC Name", "Verifying EVDC link is not there for Child Entity", "pass", "Verified - EVDC Link is not there for - "+OrgName);
				}
			}
		} catch (Exception e) {
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
				
	}
	
	/*====================================================================================================
	Method Name 	: verifyVCldLnkNotThere
	Description		: to verify VCloud link should not be there
	Author 			: Vivek Kumar
	Creation Date 	: 01/05/2016
	Pre-Requisites	:
	Revision History:
	=====================================================================================================*/
	public static void verifyVCldLnkNotThere()
	{
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EVDC_Overview);
		
		int iRowCnt;
		WebElement wEVDCvCLD;
		
		try {
			//Loading the EVDC View table
			CustomWebElementUtil.loadCustomElement(EVDC_Overview.getNav_EVDCViewHomeTable(), "table");
			iRowCnt=CustomWebElementUtil.iRowCount;

			for(int i=1;i<=iRowCnt;i++)
			{
				  wEVDCvCLD=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.EVDCVIEWTABLE.VCLOUD", "PARAMETER_ROWNUMBER", i+"");
				  if(wEVDCvCLD==null)
				  {
					  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "VCloud Link" , "Verifying VCloud Link not present", "pass", "VCloud Link not present for ROLE E"); 
				  }
				  else
				  {
					  FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "VCloud Link" , "Verifying VCloud Link not present", "fail", "VCloud Link present for ROLE E"); 
				  }
			}
		} catch (Exception e) {
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
		}
		
	}
	
	
	/*====================================================================================================
	Method Name 	: getEVDCNameWithEntityName
	Description		: get the EVDC name with entity name
	Author 			: Vivek Kumar
	Creation Date 	: 12/29/2015
	Pre-Requisites	:
	Revision History:
	=====================================================================================================
	public static String[] getEVDCNameWithEntityName(String sFrstEntity,String sSndEntity,String sThrdEntity, String sForthEntity)
	{
		WebDriver driver=WebDriverUtil.getDriver();
		PageFactory.initElements(driver, EBPanel);
		
		
		String sEVDCNameRunnTime = "";
		String[] arrEVDC_Entity_List;
		String sParent=EBPanel.getNav_EntityBrowserLink().getText();
		
		
		if(sFrstEntity!=null)
		{
				EVDC_VM_TestCase.getEVDCNameAsWebElement(" ");
				for (WebElement wEVDC : WebObjectUtil.webElementsList)
				{
					//concatinating the EVDC name with ##
					sEVDCNameRunnTime = sEVDCNameRunnTime+"!EVDC!"+(wEVDC.getText() + "!P!" + sParent);
					
				}
				
				sParent=EBPanel.getNav_EntityBrowserLink().getText();
				WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
				
				
				EntityBrowserTestCase.selectOrgFromAllLevelsEB(sFrstEntity, null, null, null);
				EntityBrowserTestCase.arrOrgNameFromEBPanel=EntityBrowserTestCase.getChildOrgNameListFromEBPanel(2);
				
				
				
				//Getting the EVDC name format
				//Clicking on EBPanel Tab
				WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
				//sParent=EVDC_Overview.getNav_EVDCname().getText();
				
				EVDC_VM_TestCase.getEVDCNameAsWebElement(" ");
				for (WebElement wEVDC : WebObjectUtil.webElementsList)
				{
					//concatinating the EVDC name with ##
					sEVDCNameRunnTime = sEVDCNameRunnTime+"!EVDC!"+(wEVDC.getText() + "!P!" + sParent);
					
				}
				
				
				//WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
				String sChild;
				for(int i=0;i<EntityBrowserTestCase.arrOrgNameFromEBPanel.length;i++)
				{
					sChild=EntityBrowserTestCase.arrOrgNameFromEBPanel[i];
					sParent=EBPanel.getNav_EntityBrowserLink().getText();
					WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
					EntityBrowserTestCase.selectOrgFromAllLevelsEB(sChild, null, null, null);
					WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
					
					EVDC_VM_TestCase.getEVDCNameAsWebElement(" ");
					for (WebElement wEVDC : WebObjectUtil.webElementsList)
					{
						//concatinating the EVDC name with ##
						sEVDCNameRunnTime = sEVDCNameRunnTime+"!EVDC!"+(wEVDC.getText() + "!P!" + sParent);
						
					}
					//#######################################
					//Going back to main entity
					WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
					WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
					WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
					WebObjectUtil.explicitWait(10);
					//Selecting the sFirst Entity
					EntityBrowserTestCase.selectOrgFromAllLevelsEB(sFrstEntity, null, null, null);
					//Clicking on EBPanel Tab
					WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
				}
		}
		
		if(sSndEntity!=null)
		{
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
			
			EntityBrowserTestCase.selectOrgFromAllLevelsEB(sFrstEntity, sSndEntity, null, null);
			EntityBrowserTestCase.arrOrgNameFromEBPanel=EntityBrowserTestCase.getChildOrgNameListFromEBPanel(3);
			sParent=sFrstEntity;
			//Clicking on EBPanel Tab
			WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
			//sParent=EVDC_Overview.getNav_EVDCname().getText();
			
			EVDC_VM_TestCase.getEVDCNameAsWebElement(" ");
			for (WebElement wEVDC : WebObjectUtil.webElementsList)
			{
				//concatinating the EVDC name with ##
				sEVDCNameRunnTime = sEVDCNameRunnTime+"!EVDC!"+(wEVDC.getText() + "!P!" + sParent);
				
			}
			
			
		}
		
		
		WebObjectUtil.clickElement(EBPanel.getNav_EntityBrowserLink());
		
		//turning RollUp Button ON
		WebObjectUtil.clickElement(EBPanel.getNav_EBPanelRollUpButton());
		//Clicking on EBPanel Tab
		WebObjectUtil.clickElement(EBPanel.getNav_OrgNameTitleLink());
		arrEVDC_Entity_List = sEVDCNameRunnTime.split("!EVDC!");
		
		//Removing the first index from array as it contains empty
		arrEVDC_Entity_List = Arrays.copyOfRange(arrEVDC_Entity_List, 1, arrEVDC_Entity_List.length);
		
		return arrEVDC_Entity_List;
	}

*/
	
	
	//update each @test result in custom result file
		@AfterMethod
		public static void afterEachMethod(){
				FrameworkUtil.updateTestCaseStatusinResult();
					
		 }
}
