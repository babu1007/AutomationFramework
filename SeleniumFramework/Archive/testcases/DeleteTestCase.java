package com.whs.navigator.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.commonUtil.WebTableUtil;
import com.whs.navigator.pagefactory.CatalogPageFactory;
import com.whs.navigator.pagefactory.EVDCPageFactory;
import com.whs.navigator.pagefactory.EVDC_VM_AdvancedActions_PageFactory;

public class DeleteTestCase {
	public static CatalogPageFactory Catalog =new CatalogPageFactory();
	public static EVDCPageFactory EVDC= new EVDCPageFactory();
	public static  EVDC_VM_AdvancedActions_PageFactory EVDC_Advanced= new EVDC_VM_AdvancedActions_PageFactory();
	 
	
	 /*==============================================================
	 TestScript   		: deleteOldVMTest
	 Manual TestCase 	:
	 Description  		:  
	 Author    			: Arularasu
	 Creation Date 		: 05/26/2015
	 Pre-Requisites 	:
	 Revision History	:
	 ==============================================================*/
	@Test(priority=1)
	public void deleteOldVMTest(){
	
		FrameworkUtil.sTestCaseName = "deleteOldVMTest";
		FrameworkUtil.sManualTestCaseName="Delete old VM created by Script";
		FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
		
		String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
		deleteOldVMs(sUserName,sPassword);
		
	}

	
	 /*==============================================================
	 TestScript   		: navDeleteCatalog
	 Manual TestCase 	:
	 Description  		:  
	 Author    			: Arularasu
	 Creation Date 		: 05/26/2015
	 Pre-Requisites 	:
	 Revision History	:
	 ==============================================================*/
	 @Test(priority=2)
	 public void navDeleteCatalog()
	 {
	  FrameworkUtil.sTestCaseName = "Catalog-navDeleteCatalog";
	  FrameworkUtil.sManualTestCaseName= "delete old catalog created by script";
	  FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
	  WebDriver driver = WebDriverUtil.getDriver();
	  PageFactory.initElements(driver, Catalog);

		String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.USERID.AROLE");
		String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.USER.MANAGEMENT.PASSWORD.AROLE");
	
		 LoginTestCase.nav_Login(sUserName,sPassword);
		 
		
	  //Navigating to Catalog Page
	  navigateCatalogPage();

	  //delete Private Catalog
	  deleteCatalog(sUserName,sPassword);
	  

	 }

	 

	 
	 /*==============================================================
	 Method Name   		: navigateCatalogPage
	 Manual TestCase 	:
	 Description  		:  
	 Author    			: Vivek
	 Creation Date 		: 05/26/2015
	 Pre-Requisites 	:
	 Revision History	:
	 ==============================================================*/
	 public static void navigateCatalogPage()
	 {  
	  WebDriver driver = WebDriverUtil.getDriver();
	  PageFactory.initElements(driver, Catalog);
	  
	  //Clicking EVDC name and verifying its landing page
	  WebObjectUtil.clickAndVerifyElement(Catalog.getNav_EVDCname(), Catalog.getNav_CatalogPortletLink());
	  WebObjectUtil.clickAndVerifyElement(Catalog.getNav_CatalogPortletLink(), Catalog.getNav_CatalogWindStreamLink());
	 }
	 

	 
	 /*==============================================================
	 Method Name   		: deleteCatalog
	 Manual TestCase 	: Delete private catalog which are created by script
	 Description  		:  
	 Author    			: Arularasu
	 Creation Date 		: 05/26/2015
	 Pre-Requisites 	:
	 Revision History	:
	 ==============================================================*/
	 public static void deleteCatalog(String sUserName,String sPassword)
	 {
	  WebDriver driver = WebDriverUtil.getDriver();
	  PageFactory.initElements(driver, Catalog);
	  
	  int iRowNum=0,iCatalogTableRowCount;
	  String sCatalogName,sCurrentDate,sTodayDate,sCatalogtempname,sConfirmMsg,sExpanderXpath,sActualMsg;
	  WebElement expander;
	  
	  //LoginTestCase.nav_Login(sUserName,sPassword);
	  
	  try {
		sCatalogtempname = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.ADDVM.NAME");
		  sConfirmMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.DELETEVM.CONFIRMMSG");
		  WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateLink());
		  //WebTableUtil.printEachCellText(Catalog.getNav_CatalogPrivateWebTable());
			sTodayDate = FrameworkUtil.date_yyyyMMdd();
			iCatalogTableRowCount = WebTableUtil.getRowCount(Catalog.getNav_CatalogPrivateWebTable());
			for (int rowno=1; rowno<=iCatalogTableRowCount; rowno=rowno+3){
				iRowNum++;
				sCatalogName =WebTableUtil.getCellData(Catalog.getNav_CatalogPrivateWebTable(), rowno, 3);
				
				if (sCatalogName.contains(sCatalogtempname) && !sCatalogName.contains(sTodayDate)){
					FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Delete Catalog" , "Catalog Name ", "Done", sCatalogName);
					sExpanderXpath = "//div[@id='pvtObjGrid-body']//tr["+iRowNum+"]//tr[1]//div[@class='x-grid-row-expander']";
					expander = WebObjectUtil.GetWebElement("xpath", sExpanderXpath, "Expander");
					WebObjectUtil.clickElement(expander);
					WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateDeleteBtn());
					
					sConfirmMsg = sConfirmMsg + " " + sCatalogName + " ?";
					sActualMsg = Catalog.getNav_NewCatalogPopUpMessage().getText();
					boolean bConfirmMsg = sActualMsg.contains(sConfirmMsg);
					FrameworkUtil.updateCustomResultBasedOnStatus(bConfirmMsg,sActualMsg);
					WebObjectUtil.clickElement(Catalog.getNav_NewCatalogPopUpOKBtn());
					WebObjectUtil.explicitWait(10);
/*				if(WebObjectUtil.isElementPresent(Catalog.getNav_CatalogPopUpMessage())){
						WebObjectUtil.clickElement(Catalog.getNav_CatalogPopUpOKBtn());
					}*/
					System.out.println(sCatalogName + "row no:" +rowno );
					WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateLink());
					if (rowno > 3){
						rowno = rowno -3;
					}
					iRowNum = iRowNum -1;
					iCatalogTableRowCount = iCatalogTableRowCount -3;
						
				
				}	
				
			}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  
		  //Logging out from Navigator application
		  LoginTestCase.nav_Logout();
	  
	 }

	 

	 /*==============================================================
	 Method Name   		: deleteOldVMs
	 Manual TestCase 	: Delete VMs which are created by script
	 Description  		:  
	 Author    			: Arularasu
	 Creation Date 		: 05/26/2015
	 Pre-Requisites 	:
	 Revision History	:
	 ==============================================================*/
	 
		public static void deleteOldVMs(String sUserName,String sPassword){
	
			String sVMname, sTodayDate,sVMtempname,sRowText,sDeleteXpath,sDeleteString,sConfirmMsg;
			WebElement rowElement, DeleteVM;
			int iRowNum=0,iEVDCTableRowCount,iDeleteColNo;
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,EVDC);
			PageFactory.initElements(driver,EVDC_Advanced);
			
			LoginTestCase.nav_Login(sUserName,sPassword);
			
			try {
				//sVMtempname = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.ADDVM.NAME");
				sVMtempname = "DEMO123";
				sConfirmMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.DELETEVM.CONFIRMMSG");
				sDeleteXpath =	"//table[contains(@id,'gridview-')]//tr[" + iRowNum + "]//tbody//td//a[text()='Delete']";
				WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCname(), EVDC.getNav_EVDCOverviewVirtualMachine());
				WebObjectUtil.clickAndVerifyElement(EVDC.getNav_EVDCOverviewVirtualMachine(),EVDC.getNav_AddVMLink());


				//WebTableUtil.printEachCellText(EVDC.getNav_VMWebTable());
				sTodayDate = FrameworkUtil.date_yyyyMMdd();
				iEVDCTableRowCount = WebTableUtil.getRowCount(EVDC.getNav_VMWebTable());
				for (int rowno=1; rowno<=iEVDCTableRowCount; rowno=rowno+3){
				sVMname =WebTableUtil.getCellData(EVDC.getNav_VMWebTable(), rowno, 3);

					if (sVMname.contains(sVMtempname) && !sVMname.contains(sTodayDate)){
						iRowNum = EVDC_VM_AdvancedActions.getRow_EVDC_VMTable(EVDC.getNav_VMWebTable(),sVMname,"");
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Get VM and its State" , "VM Name and State ", "Done", EVDC_VM_AdvancedActions.sVMName + "//"+ EVDC_VM_AdvancedActions.sVMstatus);
						if (EVDC_VM_AdvancedActions.sVMstatus!="Stopped"){
							//call stop VM method
						}
						System.out.println( EVDC_VM_AdvancedActions.sVMName + "//"+ EVDC_VM_AdvancedActions.sVMstatus);
						if (!EVDC_VM_AdvancedActions.sVMstatus.equalsIgnoreCase("Failed")){
							EVDC_VM_AdvancedActions.expandVMbyRowNum(iRowNum);
							EVDC_VM_AdvancedActions.verifyDeleteVM();
						WebDriverUtil.refreshBrowser();
						}else{
						//sDeleteString = WebTableUtil.getCellData(EVDC.getNav_VMWebTable(), iRowNum, 15);
						
						//rowElement = WebTableUtil.getRowAsWebElement(EVDC.getNav_VMWebTable(), iRowNum);
						rowElement = WebTableUtil.getRowAsWebElement(EVDC.getNav_VMWebTable(), rowno);
						sRowText = rowElement.getText();
						if (sRowText.contains("Delete")){
						//if (sDeleteString.equalsIgnoreCase("Delete")){
							sDeleteXpath =	"//table[contains(@id,'gridview-')]//tr[" + iRowNum + "]//tbody//td//a[text()='Delete']";
							DeleteVM =WebObjectUtil.GetWebElement("xpath", sDeleteXpath, "Delete Link(Failed VM)");
							//DeleteVM.click();
							WebObjectUtil.clickElement(DeleteVM);
							
							//verify text present on Delete dialog
							
							sConfirmMsg = sConfirmMsg + " " + sVMname + "?";
							String sActualMsg = EVDC_Advanced.getNav_EVDCConfirmNewPopupOKBtn().getText();
							sActualMsg = sActualMsg.trim();
							boolean bConfirmMsg = sActualMsg.contains(sConfirmMsg);
							FrameworkUtil.updateCustomResultBasedOnStatus(bConfirmMsg,sConfirmMsg);
							WebObjectUtil.clickElement(EVDC_Advanced.getNav_EVDCConfirmNewPopupOKBtn());
							//WebObjectUtil.waitForElementNotPresent(EVDC.getNav_RefreshPopUpMsg());
							WebObjectUtil.explicitWait(10);
							sConfirmMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.DELETEVM.CONFIRMMSG");
							}
						}
						if (rowno > 3){
						rowno = rowno -3;
						//iEVDCTableRowCount = iEVDCTableRowCount -3;
						}
						
					}

					//iRowNum = iRowNum+1;
					iEVDCTableRowCount = WebTableUtil.getRowCount(EVDC.getNav_VMWebTable());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	

			LoginTestCase.nav_Logout();	
			
				
		}




//update each @Test result in custom result file
@AfterMethod
public void afterEachMethod(){
	FrameworkUtil.updateTestCaseStatusinResult();
	FrameworkUtil.sTestExecutionStatus = true;
}


}
