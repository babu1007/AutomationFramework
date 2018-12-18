package com.whs.navigator.testcases.Talon;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.CustomWebElementUtil;
import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.commonUtil.WebTableUtil;
import com.whs.navigator.pagefactory.FormPageFactory;


public class TalonTestCase_Vivek {
	
	public static FormPageFactory Forms = new FormPageFactory();
	
	@Test
	public void searchValidSales()
	{
		String sFormName,sSalesOrder;
		
		WebDriver driver = WebDriverUtil.getDriver();
		PageFactory.initElements(driver, Forms);
		
		FrameworkUtil.sTestCaseName="searchValidSales";
		FrameworkUtil.sManualTestCaseName="(QAT-852) Talon - verify that new contact form is displayed under the above two filled in forms and user is able to see all the 3 forms";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName, FrameworkUtil.sManualTestCaseName);
		
		
		sFormName=(String)FrameworkUtil.dictPropertyData.get("NAV.FORMS.CONTACTINFORMATION");
		
		// login to the navigator
		LoginTestCase_Old1.LoginAsQaautoAUser();
		
		//Navigate to Forms Page
		FormTestCase.navToFormsPage();
		sFormName="Contact Information";
		//Search Sales Order which have contact information 
		sSalesOrder=getSalesOrderByFormName(sFormName);
		
	}
	
//##############################################################################################
	// METHODS
//##############################################################################################

	/*====================================================================================================
	Method Name 	: getSalesOrderByFormName
	Description		: It will search for Sales order which have Contact form incomplete
	Author 			: Vivek Kumar
	Creation Date 	: 04/26/2016
	Module Name     : Forms
	Pre-Requisites	: 
	Revision History: This method is updated by adding formsordertype parameter and forms header name validation
	and present in KyleTestCase_SLP file by QAA03

	====================================================================================================*/
	public static String getSalesOrderByFormName(String sFormName)
	{
			WebElement wSalesOrder, wIncompleteForms,wContinueImg;
			String sIncompleteForms,sSalesOrderNumber = null,sFormsname,sFormStatus;
			int iRowCnt,iSalesPortletCnt;
			boolean bFlag=false,bContStatus=false;
			
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver, Forms);
			
		try {	
			//Getting the list of All Sales Order block
			List<WebElement> webListItems = Forms.getNav_SalesOrderPortlet();
			iSalesPortletCnt=webListItems.size();
			
			//iterate through all and looking for Sales Order Which have Contact Info form
			for(int i=1;i<=iSalesPortletCnt;i++)
			{
				wIncompleteForms=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.FORMS.INCOMPLETEFORMS", "PARAMETER_ROWNUMBER", i+"");
				sIncompleteForms=wIncompleteForms.getText();
				//Looking for Sales order which have at least 1 incomplete form
			//	if(!sIncompleteForms.contains("0"))
			//	{
					wSalesOrder=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "NAV.FORMS.SALESORDER.LINK", "PARAMETER_ROWNUMBER", i+"");
					WebObjectUtil.scrollElementAtPageCenter(wSalesOrder);
					//Capturing the Sales Order value
					sSalesOrderNumber=wSalesOrder.getText();
					//Clicking on Sales Order
					
					WebObjectUtil.clickElement(wSalesOrder);
					WebObjectUtil.explicitWait(2);
					//Clicking on Incomplete Form Block
					WebObjectUtil.clickElement(Forms.getNav_IncompleteFormBlk());
					
					//Load table for Incomplete list
					CustomWebElementUtil.loadCustomElement(Forms.getNav_IncompleteFormsTable(), "table");
					//Get the row count 
					iRowCnt=CustomWebElementUtil.iRowCount;
					if(iRowCnt==0)
					{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "No Incomplete form" , "done","Sales order -"+sSalesOrderNumber+" - Does not have incomplete form");
						WebDriverUtil.getDriver().navigate().back();
						WebObjectUtil.explicitWait(5);
					}
					else
					{
					
					//looping through incomplete form table
					for(int j=1;j<=iRowCnt;j++)
					{
						//Getting the Form name and verifying with sFormName
						sFormsname=CustomWebElementUtil.getCellData(j, 1);
						sFormStatus=CustomWebElementUtil.getCellData(j, 3);
						if(sFormsname.equalsIgnoreCase(sFormName)&& sFormStatus.equalsIgnoreCase("continue"))
						{
							//Clicking on Continue image
							wContinueImg=CustomWebElementUtil.getRowAsWebElement(j).findElement(By.xpath("//a/img[contains(@src,'Continue')]"));
							//WebObjectUtil.clickElement(wContinueImg);
							bContStatus=WebObjectUtil.isElementPresent(wContinueImg);
							if(bContStatus)
							{
								
								if(TalonTestCase_NMR.navigatingToForm3Page(sSalesOrderNumber, sFormName)){
								bFlag=true;
								break;
								}
							}
							
						}
						/*else
						{
							sSalesOrderNumber=null;
						}*/
					}
					
					if(bFlag)
					{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Looking for "+sFormName , "pass",sFormName+"  found Under -" + sSalesOrderNumber);
						break;
					}
					else
					{
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Looking for "+sFormName , "done",sFormName+" not found" + "for Sale Order " +sSalesOrderNumber );
						sSalesOrderNumber=null;
						WebDriverUtil.getDriver().navigate().back();
						WebObjectUtil.explicitWait(5);
					}
				//}
				}
			}
			if(sSalesOrderNumber==null)
			{
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Looking for "+sFormName , "fail",sFormName+" not found");
			}
		} catch (Exception e) {
			String sCurrentMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
			FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName ,sCurrentMethodName, "warn", "catch block:" +e.getMessage());
		}
		
		//WebDriverUtil.getDriver().navigate().back();
		//WebObjectUtil.explicitWait(5);
		return sSalesOrderNumber;
		
	}
	
	
	@AfterMethod
	public void afterMethod(){
		FrameworkUtil.updateTestCaseStatusinResult();
		FrameworkUtil.sTestExecutionStatus=true;
	}
	
	
	

}
